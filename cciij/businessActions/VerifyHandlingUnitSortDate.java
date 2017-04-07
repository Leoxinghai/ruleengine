package cciij.businessActions;

/**
 * Title:        Verify Handling Unit Sort Date
 * Description:  This business action verifys the Handling Unit Sort Date
 *               by verifying that a Piece Route Leg record and a matching
 *               Route Leg record exist in the DB. Once the records are retrieved
 *               the Route Leg Sort Date is compared to the current sort date. If
 *               the current sort date is different than the Route Leg Sort Date,
 *               the overage flag is set in the state object. The state object
 *               is then returned to the caller.
 *
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author       Robert Fisher
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Piece Route Leg not found in db
 * @throws       cciij.util.CCIILogException Piece Route Leg not found in db
 * @throws       cciij.util.CCIILogException Failure during fetch of Route Leg
 * @throws       cciij.util.CCIILogException Route Leg not found in db
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *               PieceRouteLeg - exists in DB for specified HandlingUnitOid
 *               RouteLeg - exists in DB that contians matching RouteNumber
 *                          RouteDate, and RouteLegNumber for PieceRouteLeg.
 *
 * Modification History:
 * 10/24/2001    Ed McAleer   Add tags and complete description.
 * 12/26/2001    Ed McAleer   Change exceptions to CCIILogException. Also added
 *                            NUMBER_OF_ROUTE_DAYS config variable.
 * 06/11/2003    Tom Knobeloch  Removed database access for RouteLeg and made
 *                              use of RouteLegInfo in the state object.
 *                              Even though DatabaseBean dbConnection is no longer
 *                              used, it was NOT removed to maintain a consistent
 *                              method signature.
 *                              Removed commented-out code.
 * 08/19/2003    Tom Knobeloch  Added code to eliminate the time element of the Dates
 *                              involved in a SortDate comparison.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

import java.text.DateFormat;

public class VerifyHandlingUnitSortDate extends BusinessActionBase {

private static final String m_whatVersion = "@(#) $RCSfile: VerifyHandlingUnitSortDate.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
private String m_numbSortDays = null;
private String m_dateOverageAgencyCode = null;
private String m_dateOverateInterceptCode = null;
static public final long milliSecondsPerDay = 86400000;

public VerifyHandlingUnitSortDate() throws Exception {

}

protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  m_numbSortDays = readConfigVariableString("NUMBER_OF_SORT_DAYS","3");
  m_dateOverageAgencyCode = readConfigVariableString("DATEOVERAGE_AGENCY_CODE");
  m_dateOverateInterceptCode = readConfigVariableString("DATEOVERAGE_INTERCEPT_CODE");
}


public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

  PieceRouteLeg pieceRouteLeg = null;
  RouteLeg routeLeg = null;
  SortDate sortDate = new SortDate();
  String errorMessage = null;

    routeLeg = state.getRouteLegInfo();
    if ( routeLeg == null ) {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_FND);
      return state;
    }

    if ( m_notify.getTraceLevel() > 0 )
    {
      Date dt = new Date();
      DateFormat df = DateFormat.getDateInstance();
      DateFormat tf = DateFormat.getTimeInstance();
      traceLog("VerifyHandlingUnitSortDate", "Date       == " + df.format(dt) + " " + tf.format(dt));
      traceLog("VerifyHandlingUnitSortDate", "Date long  == " + dt.getTime());
      traceLog("VerifyHandlingUnitSortDate", "Route      == " + df.format(routeLeg.getSortDate()) + " " + tf.format(routeLeg.getSortDate()));
      traceLog("VerifyHandlingUnitSortDate", "Route long == " + routeLeg.getSortDate().getTime());
      traceLog("VerifyHandlingUnitSortDate", "Sort       == " + df.format(new Date(sortDate.currentSortDate(state.getScan().getLocationCode()))) + " " + tf.format(new Date(sortDate.currentSortDate(state.getScan().getLocationCode()))));
      traceLog("VerifyHandlingUnitSortDate", "Sort long  == " + sortDate.currentSortDate(state.getScan().getLocationCode()));
      traceLog("VerifyHandlingUnitSortDate", "sub value == " + Integer.parseInt(m_numbSortDays)*sortDate.milliSecondsPerDay);
    }

    // New code to eliminate the time component from the SortDate comparison that follows.
    long packageSortDateMS = routeLeg.getSortDate().getTime();
    long adjustmentFromMidnightMS = packageSortDateMS % milliSecondsPerDay;
    packageSortDateMS = packageSortDateMS - adjustmentFromMidnightMS;
    Date packageSortDate = new Date(packageSortDateMS);

    long currentSystemSortDateMS = sortDate.currentSortDate(state.getScan().getLocationCode());
    Date currentSystemSortDate = new Date(currentSystemSortDateMS);

    long earliestDateAllowedMS = currentSystemSortDateMS - (Integer.parseInt(m_numbSortDays)*sortDate.milliSecondsPerDay);
    Date earliestDateAllowed = new Date(earliestDateAllowedMS);

    if (  ( packageSortDate.after(currentSystemSortDate) )
        ||( packageSortDate.before(earliestDateAllowed) ) ) {
    // End of new code to eliminate the time component from the SortDate comparison
      state.setOverageFlag("SORTDATE");
      state.getScan().setErrorNumber(Messages.IM_OVERAGE);
      state.getScan().setAgencyCode(m_dateOverageAgencyCode);
      state.getScan().setInterceptCode(m_dateOverateInterceptCode);
    }

    return state;

  }
}
