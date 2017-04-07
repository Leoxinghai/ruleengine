package cciij.businessActions;
/**
 * Title:       Get Context
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException MASTERUNKNOWN_RULESET not found for view
 * @throws      cciij.util.CCIILogException Context == ShipmentOid provided, not currently supported
 * @throws      cciij.util.CCIILogException MASTERPROVIDED_RULESET not found for view
 * @throws      cciij.util.CCIILogException RESOLVEDHU_RULESET not found for view
 * @throws      cciij.util.CCIILogException Unknown Context for scan
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001   Ed McAleer   Changes exceptions to CCIILogException.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class GetContext extends GetContextBase {
private static final String m_whatVersion = "@(#) $RCSfile: GetContext.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public GetContext() throws Exception {
    traceLog("GetContext","In Constructor");
  }
protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  //no local variables to read in
}
public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    traceLog("GetContext", state);

    if  ( state.getScan().getHAWBUnknownFlag().equals("T") ) {
        changeRuleSets(state,"MASTERUNKNOWN");
    }
    else if ( state.getScan().getShipmentOid() != 0 ) {
        state.getScan().setErrorNumber(Messages.EM_START_OVER);
        CCIILogException cciiEx = new CCIILogException("BA_UNSUPPORTED_ERROR_NUMB",
                                                      "Context == ShipmentOid provided, not currently supported");
        throw cciiEx;
    }
    else if ( state.getScan().getHAWB().equals("") == false ) {
        changeRuleSets(state,"MASTERPROVIDED");
    }
    else if ( state.getScan().getHandlingUnitOid() != 0 ) {
        changeRuleSets(state,"RESOLVEDHU");
    }
    else if ( state.getScan().getAirbillNumber().equals("") == false ) {
      //  this is the default case, since airbillNumber should be present
      //   so we don't change anything
      traceLog("GetContext","Default context, ruleset unchanged");
    }
    else {
      state.getScan().setErrorNumber(Messages.EM_START_OVER);
      CCIILogException cciiEx = new CCIILogException("BA_UNKNOW_CONTEXT_ERROR_NUMB",
                                                      "Unknown Context for scan " + state.getScan().toString());
      throw cciiEx;
    }

    traceLog("GetContext", "processing complete");
    traceLog("GetContext", state);

    return state;

  }

public static void main(String[] args){
     System.out.println("GetContext in main");

     DatabaseBean db = new DatabaseBean();

     db.connect();
     HandlingUnit hu = null ;

     try {
       hu = db.fetchHandlingUnit("825955495854");
     }
     catch (Exception ex) {
       System.out.println("Caught an Exception during fetch");
       ex.printStackTrace();
     }

     if ( hu != null ) {
       System.out.println(hu.getHandlingUnitOidNumber());
     }
     else {
       System.out.println("Didnt find the HU you wanted!!");
     }

     System.out.println("Leaving main");
    }
}
