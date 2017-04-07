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

public class AddIntercept extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: AddIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  String m_interceptCode;
  String m_agencyCode;

    public AddIntercept(String groupName) throws Exception
    {
        //m_config.setGroup(groupName);
	super(groupName);
	traceLog("AddIntercept","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {

        traceLog("AddIntercept","Beginning doIt");

        state.getScan().setInterceptCode(readConfigVariableString("INTERCEPT_CODE"));
        state.getScan().setAgencyCode(readConfigVariableString("AGENCY_CODE"));
        return state;
    }

    public static void main(String args[])
    {
        rmtc.util.Config cfg = new rmtc.util.Config();

	cfg.setLocationCode("NRT");
        CCIIState cciiState = new CCIIState();

        try
        {
            AddIntercept addIntercept = new AddIntercept("MISSORT");

            addIntercept.doIt(cciiState, null);
            System.out.println("Intercept: " + cciiState.getScan().getInterceptCode() + " Agency:" + cciiState.getScan().getAgencyCode());
        }
        catch (Exception e)
        {
           System.out.println(e);
        }
    }
    public void test() throws Exception
    {
/*        CCIIState cciiState = new CCIIState();
        cciiState.getScan().setLocationCode("YYZ");
	cciiState.getScan().setShipmentOid(312086);
        java.util.Date time = new java.util.Date();
        cciiState.getScan().setTransactionTimestamp(time);

        cciiState = (CCIIState) actionEntry(cciiState);
        System.out.println("state after execution " + cciiState);
*/

        return;
    }

}

