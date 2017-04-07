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

public class GetContextForProcessIntercept extends GetContextBase {

    private static final String m_whatVersion = "@(#) $RCSfile: GetContextForProcessIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public GetContextForProcessIntercept() throws Exception {
        traceLog("GetContextForProcessIntercept","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read in
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        traceLog("GetContext", state);

        if  ( state.getScan().getHAWBUnknownFlag().equals("T") ) {
            changeRuleSets(state,"MASTERUNKNOWN");
        }

        state.setRecuringInterceptFlag(false);

        // The workstation will set the pieceLevelIntercept for us, so ignore the following subtle logic for the WS.
        if(state.getScan().getInputDevice().equals("JavaWS") == false)
        {
            // Here we are going to set the pieceLevelIntercept flag to false if only the shipoid is set
            //   and to true if only the pieceoid is set
            //   otherwise error cuz we cant have the ship and piece oids set
            if(state.getScan().getShipmentOid() == 0)
            {
                if(state.getScan().getHandlingUnitOid() == 0)
                {
                    CCIILogException cciiEx = new CCIILogException("BA_UNKNOW_CONTEXT_ERROR_NUMB",
                                                                   "Unknown Context for Intercept Processing " + state.getScan().toString());
                    throw cciiEx;
                }
                else
                {
                    state.setPieceLevelIntercept(true);
                }
            }
            else if(state.getScan().getHandlingUnitOid() == 0)
            {
                state.setPieceLevelIntercept(false);
            }
            else
            {
                CCIILogException cciiEx = new CCIILogException("BA_UNKNOW_CONTEXT_ERROR_NUMB",
                                                               "Unknown Context for Intercept Processing " + state.getScan().toString());
                throw cciiEx;
            }
        }

        if(state.getScan().getInViewName().equals("PCRFView") && state.getScan().getActionCode().charAt(0) == 'S')
        {
            state.getScan().setActionCode("Q");  // this is to allow the switch below to work better
        }

        switch(state.getScan().getActionCode().charAt(0))
        {
        case 'B':
            state.setRecuringInterceptFlag(true);
            state.getScan().setActionCode("A");
        case 'A':
            changeRuleSets(state,"ADD_INTERCEPT");
            break;
        case 'E':
            state.setRecuringInterceptFlag(true);
            state.getScan().setActionCode("D");
        case 'D':
            changeRuleSets(state,"DEL_INTERCEPT");
            break;
        case 'T':
            state.setRecuringInterceptFlag(true);
            state.getScan().setActionCode("S");
        case 'S':
            changeRuleSets(state,"SAT_INTERCEPT");
            break;
        case 'Q':
            state.getScan().setActionCode("S");
        case 'R':
            changeRuleSets(state,"CUSTOMS_RELEASE");
            break;
        case 'U':
            changeRuleSets(state,"CUSTOMS_UNRELEASE");
            break;
        case 'G':
            changeRuleSets(state,"POST_DECLARED");
            break;
        case 'H':
           changeRuleSets(state,"POST_UNDECLARED");
           break;

        default:
            state.getScan().setErrorNumber(Messages.EM_START_OVER);
            CCIILogException cciiEx = new CCIILogException("BA_UNKNOW_CONTEXT_ERROR_NUMB",
                                                           "Unknown Context for Intercept Processing " + state.getScan().toString());
            throw cciiEx;
            //	    break;
        }

        traceLog("GetContextForProcessIntercept", "processing complete");
        traceLog("GetContextForProcessIntercept", state);

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
