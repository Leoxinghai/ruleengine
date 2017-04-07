package cciij.businessActions;

/**
 * Title:        Find Inbound Route Info
 * Description:  This is the class for the business action which retrieves the route leg info
 *               for the scanned package and stores it in the CCIIState object.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author       Tom Knobeloch
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Route Leg fetch failed
 *
 * return        state - state object.
 *
 * Known SubClasses: None
 *
 *
 * Pre-condition:
 * @param        dbConnection - valid database connection from connection pool.
 *               routeLeg - route leg record object exists in the DB for the
 *                          specified HandlingUnitOid.
 *
 */



import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class  FindInboundRouteInfo extends BusinessActionBase
{

  private static final String m_whatVersion = "@(#) $RCSfile: FindInboundRouteInfo.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";


  /**
   * FindInboundRouteInfo
   *
   */
  public FindInboundRouteInfo() throws Exception
  {
  }


  /**
   * readSiteConfigVariables
   *
   */
  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  
  /**
   * doIt
   * @param CCIIState state
   * @param DatabaseBean dbConnection
   * @return CCIIState
   */

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    RouteLeg routeLeg = null;
    traceLog("FindInboundRouteInfo ()",state);

    try
    {
      routeLeg = dbConnection.fetchRouteLeg(state.getScan().getHandlingUnitOid(),
                                            state.getScan().getLocationCode());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Route Leg fetch failed");
      throw cciiEx;
    }

    if ( routeLeg == null )
    {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_FND);
    }
    
    state.setRouteLegInfo(routeLeg);
    return state;
  }
}
