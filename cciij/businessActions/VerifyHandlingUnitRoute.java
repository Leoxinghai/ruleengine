package cciij.businessActions;

/**
 * Title:        Verify Handling Unit Route
 * Description:  This business action verifys the Handling Unit Route
 *               by checking that a Route Leg record exists in CCIIState.
 *               If a Route Leg object exists, the route number from the state
 *               object is compared to the route number of the RouteLeg object.
 *               A difference will cause the overage flag "ROUTE" to be set.
 *               Finally, the state object is returned to the caller.
 *
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author       Robert Fisher
 * @version 1.0
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *               RouteLeg - exists in DB for specified HandlingUnitOid
 *
 * Modification History:
 * 10/24/2001    Ed McAleer   Add tags and complete description.
 * 12/26/2001    Ed McAleer   Change exceptions to CCIILogException
 * 06/11/2003    Tom Knobeloch  Removed database access for PieceRouteLeg and made use
 *                              of RouteLegInfo in the state object.
 *                              Even though DatabaseBean dbConnection is no longer
 *                              used, it was NOT removed to maintain a consistent
 *                              method signature.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class VerifyHandlingUnitRoute extends BusinessActionBase  {
private static final String m_whatVersion = "@(#) $RCSfile: VerifyHandlingUnitRoute.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
public VerifyHandlingUnitRoute() throws Exception  {
  }
protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  //no local variables to read in
}
public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)  throws Exception {

   RouteLeg routeLeg = null;

   traceLog("VerifyHandlingUnitRoute","begining doIt");
   traceLog("VerifyHandlingUnitRoute",state);

   routeLeg = state.getRouteLegInfo();
    if ( routeLeg == null ) {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_FND);
      return state;
    }

    traceLog("VerifyHandlingUnitRoute","scan.getRouteNumber ==" + state.getScan().getRouteNumber());

    traceLog("VerifyHandlingUnitRoute","routeLeg.getRouteNumber ==" + routeLeg.getRouteNumber());

    if ( routeLeg.getRouteNumber().equals(state.getScan().getRouteNumber()) == false ) {
      state.setOverageFlag("ROUTE");
      state.getScan().setErrorNumber(Messages.IM_OVERAGE);
    }

    traceLog("VerifyHandlingUnitRoute","returning..");
    return state;
  }
}
