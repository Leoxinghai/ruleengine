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
import java.util.Date;
import java.sql.Timestamp;

public class PostDeclaredStatus extends PostShipmentBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: PostDeclaredStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    String ms_declaredActivityCode;
    String ms_outOfOrderActivityCode;
    String ms_ignoredActivityCode;


    /**
     * PostDeclaredStatus
    */
    public PostDeclaredStatus() throws Exception
    {
        super("PostDeclaredStatus");
        traceLog("PostDeclaredStatus","In Constructor");
    }

    /**
     * readSiteConfigVariables
    */
    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      ms_declaredActivityCode = readConfigVariableString("DECLARED_STATUS_ACTIVITY_CODE","DCL");
      ms_outOfOrderActivityCode = readConfigVariableString("DECLARED_STATUS_OUT_OF_ORDER_ACTIVITY_CODE","DCLOO");
      ms_ignoredActivityCode = readConfigVariableString("DECLARED_STATUS_ALREADY_SET_ACTIVITY_CODE","DCLER");
    }

    /**
     * modifyShipmentData
     * @param Shipment
     * @param CCIIState
    */
    public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception
    {
        traceLog("PostDeclaredStatus","Beginning modifyShipmentData()");


        if(isNewTransaction(state.getScan().getTransactionTimestamp(),
		    ship.getDeclaredTransactionSequenceTimestamp()))
        {
            if(!(ship.getDeclaredFlag().equals("Y")))
            {
                ship.setDeclaredFlag("Y");
		ship.setDeclaredTransactionSequenceTimestamp(
		     state.getScan().getTransactionTimestamp());
                m_updateShipmentCoreClearance = true;
                state.addActivity(ms_declaredActivityCode);
                traceLog("PostDeclaredStatus","Post declared activity");
            }
            else
            {
                state.addActivity(ms_ignoredActivityCode);
                traceLog("PostDeclaredStatus","Post ignored activity");
            }
        }
	else
	{
            state.addActivity(ms_outOfOrderActivityCode);
            traceLog("PostDeclaredStatus","Post out of order activity");
        }

        traceLog("PostDeclaredStatus","returning from modifyShipmentData() ...");
        return state;
    }

    public static void main(String args[])
    {
	 try
	 {
             PostDeclaredStatus postDeclaredStatus = new PostDeclaredStatus();

             postDeclaredStatus.test();
	 }
	 catch (Exception e)
	 {
	    System.out.println(e);
         }


    }

    public void test() throws Exception
    {
        CCIIState cciiState = new CCIIState();
	cciiState.getScan().setLocationCode("YYZ");
	cciiState.getScan().setShipmentOid(312086);
	java.util.Date time = new java.util.Date();
	cciiState.getScan().setTransactionTimestamp(time);

        cciiState = (CCIIState) actionEntry(cciiState);
	System.out.println("state after execution " + cciiState);


        return;
    }


}
