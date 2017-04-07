package cciij.businessActions;

/**
 * Title:        Verify Route Provided
 * Description:  This business action verifies the route for the package
 *               scanned is closed.
 * Copyright:    Copyright (c) 2007
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
 * Known SubClasses:
 *    N/A
 *
 * Pre-condition:
 * @param        dbConnection - valid database connection from connection pool.
 *               routeLeg - route leg record object exists in the DB for the
 *                          specified HandlingUnitOid.
 *
 * Modification History:
 * 10/24/2001    Ed McAleer   Add tags and complete description.
 * 12/26/2001    Ed McAleer   Change exceptions to CCIILogException.
 */

// This business action verifies the route for the package scanned is closed

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class VerifyRouteStatusCode extends VerifyRouteStatusBase
{
  private  SimpleDateFormat m_df = null;
  private  String m_errorMessage = null;
  private  String m_okayToScanRouteStatus = null;
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyRouteStatusCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public VerifyRouteStatusCode() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_df = new SimpleDateFormat(readConfigVariableString("ROUTE_DATE_FORMAT","MMM d, yyyy"));
    m_okayToScanRouteStatus = readConfigVariableString("ROUTE_STATUS_OKAY_TO_SCAN_LIST","Y");
    // m_df.setTimeZone(TimeZone.getTimeZone(readConfigVariableString("LOCAL_TIMEZONE")));
  }


  public CCIIState checkRouteStatus(CCIIState state, RouteLeg routeLeg)
  {
    if ( m_okayToScanRouteStatus.indexOf ( routeLeg.getRouteLegStatusCd() ) == -1 )
    {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_CLOSED);
      state.getScan().setReturnMessage(routeLeg.getRouteNumber() + " " + m_df.format(routeLeg.getRouteDate()));
      return state;
    }
    state.setCurrentSortDate(routeLeg.getSortDate());
    return state;
  }
}
