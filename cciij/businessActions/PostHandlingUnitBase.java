package cciij.businessActions;

/**
 * Title:       Post Handling Unit Base
 * Description: This Business Action is the base class for all post handling unit operations.
 *              It retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the staging area code
 *              - the detainment location description
 *              - the warehouse code
 *              - the last modified date timestamp
 *              - the last user name
 *
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Lorraine Dominguez
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of HandlingUnit
 * @throws      cciij.util.CCIILogException HandlingUnit fetch by Oid failed
 * @throws      cciij.util.CCIILogException Failure during update of HandlingUnit
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:  PostHandlingUnitSetPlaceToBlank
 *                    PostHandlingUnitSetPlace
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public abstract class PostHandlingUnitBase extends BusinessActionBase {

private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingUnitBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

public PostHandlingUnitBase() throws Exception 
{
   traceLog("PostHandlingUnitBase","In Constructor");
}

protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  //no local variables to read in
}

protected abstract void setPlaceValues(HandlingUnit hu, CCIIState state) throws Exception;


public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

  HandlingUnit hu = null;
  String viewName = "";

  traceLog("PostHandlingUnitBase","Begining doIt()");
  traceLog("PostHandlingUnitBase",state);

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

   setPlaceValues(hu, state);
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
