package cciij.businessActions;

/**
 * Title:       Post Handling Unit
 * Description: This Business Action retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the staging area code
 *              - the detainment location description
 *              - the last modified date timestamp
 *              - the last user name
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of HandlingUnit
 * @throws      cciij.util.CCIILogException HandlingUnit fetch by Oid failed
 * @throws      cciij.util.CCIILogException Failure during update of HandlingUnit
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer   Add tags and changed exceptions to CCIILogException.
 * 02/22/2002    Ed McAleer   Add condition logic for a scan view name of either
 *                            STOVIEW or DEPVIEW to clear the stageAreaCode and
 *                            the detainmentLocationDescription HandlingUnit variables.
 * 09/24/2002    Ed McAleer   Add conditional logic to include STRVIEW to the check
 *                            for STOVIEW and DEPVIEW. The inclusion of the STRVIEW
 *                            will clear the stage area and detainment location for
 *                            STR scans.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostHandlingUnit extends BusinessActionBase {

private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingUnit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public PostHandlingUnit() throws Exception {
    traceLog("PostHandlingUnit","In Constructor");
  }
protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  //no local variables to read in
}
public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

  HandlingUnit hu = null;
  String viewName = "";

  traceLog("PostHandlingUnit","Begining doIt()");
  traceLog("PostHandlingUnit",state);

  try {
      hu = dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
  }
  catch (Exception ex) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                            "Failure during fetch of HandlingUnit");
       throw cciiEx;
  }

  if ( hu == null ) {
    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
    CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                              "HandlingUnit fetch by Oid failed, huOid == " + state.getScan().getHandlingUnitOid());;
    throw cciiEx;
  }

  viewName = state.getScan().getInViewName().toUpperCase();

   // update the hu object with data from the RPBScan/State Obj
   // If the viewName is DEPVIEW, STOVIEW, or STRVIEW clear the
   // starge area code and detainment location description attributes.

  if ( viewName.equals("STOVIEW") ||
       viewName.equals("DEPVIEW") ||
       viewName.equals("STRVIEW") ) {
    hu.setStagingAreaCode("");
    hu.setDetainmentLocationDescription("");
  }
  else {
    hu.setStagingAreaCode(state.getScan().getStagingAreaCode());
    hu.setDetainmentLocationDescription(state.getScan().getDetainLoc());
  }

   hu.setLastModifiedTimeStamp( new Date(state.getScan().getSysDateTime()));
   hu.setLastUserName(state.getScan().getUserLogon());

    try {
      dbConnection.updateHandlingUnit(hu);
    }
    catch (Exception ex ) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                    "Failure during update of HandlingUnit");
      throw cciiEx;
    }

    traceLog("PostHandlingUnit","returning ...");
    return state;
  }
}
