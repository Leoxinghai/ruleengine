package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
import java.text.FieldPosition;
import java.text.DateFormat;

/**
 * Title:        RouteLegSortDateChange
 * Description:  Class that extends BusinessActionBase.  Used for the
 *               validation and update of the sort_dt field in the Route_Leg
 *               database table.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Joey Cline
 * @version      1.0
 *
 * Modification History:
 *  08/20/03    Joey Cline     Initial version.
 */
 
public class RouteLegSortDateChange extends RouteLegChangeBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: RouteLegSortDateChange.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    private static final long MILLISECONDS_IN_DAY = 86400000;

/**
 * Method:       RouteLegSortDateChange()
 * Description:  Constructor for RouteLegSortDateChange.
 * @author       Joey Cline
 */
    public RouteLegSortDateChange() throws Exception
    {
    }
     
/**
 * Method:       setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
 * Description:  Copies the RouteLegInfo from changeRLeg to dbRLeg.
 * @author       Joey Cline
 *
 * @param        dbRLeg - RouteLeg with data contents from the database.
 * @param        changeRLeg - RouteLeg with the new route leg.
 *
 * @return       void
 */
    protected void setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
    {
        dbRLeg.setSortDate(changeRLeg.getSortDate());
    }
    
/**
 * Method:       isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
 * Description:  Validates the change of route leg sort date from the existing value
 *               (in the databaseRLeg) to the new route leg sort date (in newRLeg).
 * @author       Joey Cline
 *
 * @param        databaseRLeg - RouteLeg with data contents from the database.
 * @param        newRLeg - RouteLeg with the new route leg status.
 *
 * @return       int - 0 for valid change or an error number
 */
    protected int isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
    {    
        traceLog ( "RouteLegSortDateChange", "New Route Leg: " + newRLeg );
        traceLog ( "RouteLegSortDateChange", "Sort date in ms: " + newRLeg.getSortDate().getTime() );
        if ( ( newRLeg.getSortDate().getTime() % MILLISECONDS_IN_DAY ) != 0 )
        {
            DateFormat df = DateFormat.getDateInstance();
            DateFormat tf = DateFormat.getTimeInstance();
            FieldPosition fpos = new FieldPosition ( DateFormat.MILLISECOND_FIELD );

            // traceLog ( "RouteLegSortDateChange", "Sort date invalid: " + df.format(newRLeg.getSortDate()) + " " + tf.format(newRLeg.getSortDate()) );
            traceLog ( "RouteLegSortDateChange", "Sort date invalid: " + df.format(newRLeg.getSortDate()) + " " + tf.format(newRLeg.getSortDate()) + " (and " + (newRLeg.getSortDate().getTime() % 1000) + " ms)" );
            return Messages.EM_INV_RTE_SDTE_CHG;
        }

        return Messages.EM_NO_ERROR;
    }
    
/**
 * Method:       addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
 * Description:  Adds an Activity, appropriate to the route leg status change, to the
 *               activity vector in state.
 * @author       Joey Cline
 *
 * @param        state - CCIIState for the existing 'scan'.
 * @param        dbRLeg - RouteLeg with data contents from the database.
 *
 * @return       void
 */
    protected void addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
    {
        state.addActivity(m_config.getValue("ROUTE_EDIT_CHANGED_SORT_DATE"));
    }

/**
 * Method:       main(String arg[])
 * Description:  Main method used only for testing of businessAction.
 * @author       Joey Cline
 *
 * @param        arg - list of input arguments.  None required.
 *
 * @return       void
 */
    public static void main(String arg[])
    {
        System.out.println("RouteLegSortDateChange in main");
        try
        {
            RouteLegSortDateChange obj = new RouteLegSortDateChange();
            obj.m_config.setLocationCode("NRT");
            obj.test();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Leaving RouteLegSortDateChange main");       
    }
    
/**
 * Method:       test()
 * Description:  Test method used only for testing of businessAction.
 * @author       Joey Cline
 *
 * @return       void
 */
    public void test()
    {        
        System.out.println("RouteLegSortDateChange in test");

        GregorianCalendar now = new GregorianCalendar();
        Date dateTime = now.getTime();
        
        now.set(Calendar.HOUR_OF_DAY,0);
        now.set(Calendar.MINUTE,0);
        now.set(Calendar.SECOND,0);
        now.set(Calendar.MILLISECOND,0);
        Date date = now.getTime();
        now.add(Calendar.DAY_OF_MONTH,1);
        Date datePlusOne = now.getTime();
        
        DatabaseBean db = new DatabaseBean();
        db.connect();
        
        RouteLeg dbRLeg = new RouteLeg("JC123", date, 10, "023", "DESTN", "ORIGN",
                                       dateTime, dateTime, dateTime, dateTime, "DC",
                                       "OC", date, "N", "N", "N", -222);
        
        RouteLeg chgRLeg = new RouteLeg("JC123", date, 10, "023", "DESTN", "ORIGN",
                                       dateTime, dateTime, dateTime, dateTime, "DC",
                                       "OC", datePlusOne, null, null, null, -222);
                                     
        CCIIState state = new CCIIState();

        // write a RouteLeg
        try
        {
            System.out.println("Inserting RouteLeg, with OID -222, for testing");
            db.saveRouteLeg(dbRLeg);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }

        
        // change to valid new date; do not expect error
        System.out.println("=========================================================");
        System.out.println("Beginning Test1: Sort date + 1 day - VALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        System.out.println("Adjusted Route Leg: " + chgRLeg);
        state.setRouteLegInfo(chgRLeg);
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test1 passed");
        }
        else
        {
            System.out.println("Test1 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        System.out.println("Activity list = " + state.m_activityCodes.toString());
        
        // change to invalid new date; expect error
        System.out.println("=========================================================");
        state = new CCIIState();
        System.out.println("Beginning Test2: Sort date + 1 day with hour not midnight - INVALID CHANGE");
        now.set(Calendar.HOUR_OF_DAY,15);
        Date invalidDate = now.getTime();
        chgRLeg.setSortDate(invalidDate);
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        System.out.println("Adjusted Route Leg: " + chgRLeg);
        state.setRouteLegInfo(chgRLeg);
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test2 passed; therefore this IS AN ERROR");
        }
        else
        {
            System.out.println("Test2 failed: therefore this is NOT an error" );
            System.out.println("ErrorNumber = " + state.getScan().getErrorNumber());
        }
        System.out.println("Activity list = " + state.m_activityCodes.toString());
        
        System.out.println("=========================================================");
        System.out.println("RouteLegSortDateChange test complete");
    }
}    
