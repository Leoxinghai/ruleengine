package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
//import bea.jolt.*;

public class AddDelSatIntercept extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: AddDelSatIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public AddDelSatIntercept() throws Exception {
    traceLog("AddDelSatIntercept","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

traceLog("addDelSatIntercept","Business Action no longer used");
Exception ex= new Exception("addDelSatIntercept:Business Action no longer used");
throw ex;

// need to call the AddDelSatIntercept on the Inventory side
/*
    traceLog("AddDelSatIntercept","Begining doIt()");

    if ( state.getScan().getErrorNumber() == Messages.IM_OVERAGE ) {
      state.getScan().setErrorNumber(Messages.EM_NOT_FOUND);
      return state;
    }
    else if (  state.getScan().getErrorNumber() == Messages.IM_MPS ) {
      state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
    }

    boolean endJoltSession = false;

    if (m_session == null) {
      try {
        getJoltSession();
        endJoltSession = true;
      }
      catch (Exception ex) {
        CCIILogException cciiEx = new CCIILogException("BA_JOLT_ERROR_NUMB",
                                                       "AddDelSatIntercept failed on getJoltSession");
        throw cciiEx;
      }
    }

    // Probably want to read the name from the config file
    JoltRemoteService interceptService = new JoltRemoteService("RINT",m_session);

    if (interceptService == null) {
      traceLog("AddDelSatIntercept.","Remote Service is null");
      throw new Exception("Remote Service is null, jolt call failed?");
    }

   if ( m_traceLevel.equals("0") == false ) {
     traceLog("AddDelSatIntercept.",state.getActivityCodes().toString());
   }

  // do the All the adds except returnMessage
    try {
      interceptService.addDouble("d_returnStatus",0.0);
      interceptService.addString("s_inViewName",state.getScan().getInViewName().toUpperCase());
      interceptService.addString("s_outViewName",state.getScan().getOutViewName().toUpperCase());
// don't know if casting the long to int is good
      interceptService.addInt("l_sysDateTime", (int) (state.getScan().getSysDateTime()/1000) );
      interceptService.addString("s_userLogon",state.getScan().getUserLogon());
      interceptService.addString("s_orgCode",state.getScan().getOrgCode());
      interceptService.addString("s_inputDevice",state.getScan().getInputDevice());
      interceptService.addInt("i_errorNumber",state.getScan().getErrorNumber());

      interceptService.addInt("o_shipmentOid",state.getScan().getShipmentOid());
      interceptService.addString("s_interceptCode", state.getScan().getInterceptCode());
      interceptService.addString("s_agencyCode", state.getScan().getAgencyCode());
      interceptService.addString("s_actionCode",state.getScan().getActionCode());
    }
    catch ( NoSuchFieldError ex) {
        state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
        throw ex;
    }


     try {
       interceptService.call(null);
       state.getScan().setErrorNumber(interceptService.getIntDef("i_errorNumber",0));
     }
     catch (Exception ex) {
        ex.printStackTrace();
        state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
        throw ex;
     }

    interceptService.done();
    interceptService = null;

    if ( endJoltSession == true ) {
       m_session.endSession();
       m_session = null;
       m_sessionAttributes.clear();
       m_sessionAttributes = null;
    }

    traceLog("AddDelSatIntercept",state);
    traceLog("AddDelSatIntercept","returning ...");

    return state;
    */
  }
}

