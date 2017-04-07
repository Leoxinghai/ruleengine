package cciij.businessActions;

/**
 * Title:        Verify Route Status base
 * Description:  This is base class for business action which verifies the route for the package
 *               scanned is closed.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author       Srinivas Jawaji
 * @version 1.0
 *
 * @throws       java.lang.Exception Config error, ROUTE_MAINT_DEST_LOC_CODE not found
 *
 * @throws       cciij.util.CCIILogException Route Leg fetch failed
 * @throws       cciij.util.CCIILogException RouteLeg record not found for handlingUnitOid
 *
 * return        state - state object.
 *
 * Known SubClasses:VerifyRouteStatusCode,VerifyRouteStatusAsFlag
 *
 *
 * Pre-condition:
 * @param        dbConnection - valid database connection from connection pool.
 *               routeLeg - route leg record object exists in the DB for the
 *                          specified HandlingUnitOid.
 *
 * Modification History:
 *   06/11/03  Tom Knobeloch   Removed database access and made use of RouteLegInfo 
 *                             in the state object.
 *                             Even though DatabaseBean dbConnection is no longer used,
 *                             it was NOT removed to maintain a consistent method
 *                             signature.
 *
 */



import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public abstract class  VerifyRouteStatusBase extends BusinessActionBase
{

  private static final String m_whatVersion = "@(#) $RCSfile: VerifyRouteStatusBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";


  /**
   * VerifyRouteStatusBase
   *
   */
  public VerifyRouteStatusBase() throws Exception
  {
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
    traceLog("VerifyRouteStatusBase (RouteClosed)",state);
    
    routeLeg = state.getRouteLegInfo();
    if ( routeLeg == null )
    {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_FND);
      return state;
    }
    return checkRouteStatus(state, routeLeg);
  }

  public abstract CCIIState checkRouteStatus(CCIIState state, RouteLeg routeLeg);

}
