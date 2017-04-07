package cciij.businessActions;

/**
 * Title:        RouteLegChangeBase
 * Description:  Abstract class that extends BusinessActionBase.  Used for the
 *               validation and update of the route_leg_status_cd field in the Route_Leg
 *               database table.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Tom Knobeloch
 * @version      1.0
 *
 * Modification History:
 *  04/10/02    Tom Knobeloch  Initial version.
 *  06/11/03    Tom Knobeloch  Changed RouteLegStatusChange to RouteLegInfo
 *  08/21/03    Joey Cline     Renamed method isValidRouteLegChange (from isValidRouteStatusChange)
 *                             Renamed class from RouteLegStatusChangeBase to reflect that it is
 *                             now the parent class for status and sort date changes.
 *  09/18/03    Tom Knobeloch  Added statements to add the RouteNumber and RouteLegOidNumber to the
 *                             scan object.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public abstract class RouteLegChangeBase extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: RouteLegChangeBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

/**
 * Method:       RouteLegChangeBase()
 * Description:  Constructor for RouteLegStatusBase.
 * @author       Tom Knobeloch
 *
 */
    public RouteLegChangeBase() throws Exception
    {
    }

/**
 * Method:       getRouteLegFromDB(RouteLeg newRLeg, DatabaseBean dbConnection)
 * Description:  Using an passed DatabaseBean object (dbConnection) and key fields in
 *               the passed RouteLeg object (newRLeg), retrieves a RouteLeg object
 *               from the database.
 * @author       Tom Knobeloch
 *
 * @param        dbRLeg - RouteLeg with data contents from the database.
 * @param        dbConnection - DatabaseBean with connection.
 *
 * @return       RouteLeg
 */
    protected final RouteLeg getRouteLegFromDB(RouteLeg newRLeg, DatabaseBean dbConnection)
                                              throws Exception
    {
        RouteLeg RLeg;

        RLeg = dbConnection.fetchRouteLeg(newRLeg.getRouteNumber(),
                                          newRLeg.getRouteDate(),
                                          newRLeg.getRouteLegNumber() );
        return RLeg;
    }

/**
 * Method:       setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
 * Description:  Copies the RouteLegInfo from changeRLeg to dbRLeg.
 * @author       Tom Knobeloch
 *
 * @param        dbRLeg - RouteLeg with data contents from the database.
 * @param        changeRLeg - RouteLeg with the new route leg status.
 *
 * @return       void
 */
    protected void setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
    {
        dbRLeg.setRouteLegStatusCd(changeRLeg.getRouteLegStatusCd());
    }

/**
 * Method:       writeRouteLegToDB(RouteLeg newRLeg, DatabaseBean dbConnection)
 * Description:  Using an passed DatabaseBean object (dbConnection) updates the newRLeg
 *               in the database.
 * @author       Tom Knobeloch
 *
 * @param        newRLeg - RouteLeg with data contents to be added to the database.
 * @param        dbConnection - DatabaseBean with connection.
 *
 * @return       void
 */
    protected final void writeRouteLegToDB(RouteLeg newRLeg, DatabaseBean dbConnection)
                                          throws Exception
    {
        dbConnection.updateRouteLeg(newRLeg);
    }

/**
 * Method:       isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
 * Description:  Abstract method to specify the method signature to be implemented by
 *               child classes to validate the route leg data change.
 * @author       Tom Knobeloch
 *
 * @param        databaseRLeg - RouteLeg with data contents from the database.
 * @param        newRLeg - RouteLeg with data contents to be changed in the database.
 *
 * @return       int - 0 for valid or an error number
 */
    protected abstract int isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg);

/**
 * Method:       addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
 * Description:  Abstract method to specify the method signature to be implemented by
 *               child classes to create an activity to record the route leg status
 *               change.
 * @author       Tom Knobeloch
 *
 * @param        state - CCIIState for the existing 'scan'.
 * @param        dbRLeg - RouteLeg with data contents from the database.
 *
 * @return       void
 */
    protected abstract void addClearanceActivity(CCIIState state, RouteLeg dbRLeg);

/**
 * Method:       doIt(CCIIState state, DatabaseBean dbConnection)
 * Description:  Method invoked by RuleProcessor to retrieve a RouteLeg from the
 *               database, validate the requested change, update the database with the
 *               change, and create an activity to record the change.
 * @author       Tom Knobeloch
 *
 * @param        state - CCIIState for the existing 'scan'.
 * @param        dbConnection - DatabaseBean with connection.
 *
 * @return       void
 */
    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        int writeReturn;
        int valid;
        RouteLeg dbRLeg;
        RouteLeg changeRLeg;

	state.setRouteWasClosed(false);

        changeRLeg = state.getRouteLegInfo();
        try
        {
            dbRLeg = getRouteLegFromDB(changeRLeg, dbConnection);
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failure during fetch of RouteLeg");
            throw cciiEx;
        }

        state.getScan().setRouteNumber(dbRLeg.getRouteNumber());
        state.getScan().setRouteLegOid(dbRLeg.getRouteLegOidNumber());

        valid = isValidRouteLegChange(dbRLeg, changeRLeg);
        if (valid == 0)
        {
	    if ( changeRLeg.getRouteLegStatusCd().equals("C") )
	    {
		state.setRouteWasClosed(true);
	    }

            try
            {
                addClearanceActivity(state, dbRLeg);
                setDbFields(dbRLeg, changeRLeg);
                writeRouteLegToDB(dbRLeg, dbConnection);
            }
            catch (Exception ex)
            {
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                               "Failure during update of RouteLeg");
                throw cciiEx;
            }
        }
        else
        {
            state.getScan().setErrorNumber(valid);
        }
        return state;
    }
}
