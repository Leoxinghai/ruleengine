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

public class PostUndeclaredStatus extends PostShipmentBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: PostUndeclaredStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    String ms_undeclaredActivityCode;
    String ms_outOfOrderActivityCode;
    String ms_ignoredActivityCode;


    /**
     * PostUndeclaredStatus
    */
    public PostUndeclaredStatus() throws Exception
    {
        super("PostUndeclaredStatus");
        traceLog("PostUndeclaredStatus","In Constructor");
    }

    /**
     * readSiteConfigVariables
    */
    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      ms_undeclaredActivityCode = readConfigVariableString("UNDECLARED_STATUS_ACTIVITY_CODE","UDCL");
      ms_outOfOrderActivityCode = readConfigVariableString("UNDECLARED_STATUS_OUT_OF_ORDER_ACTIVITY_CODE","UDCLOO");
      ms_ignoredActivityCode = readConfigVariableString("UNDECLARED_STATUS_ALREADY_SET_ACTIVITY_CODE","UDCLER");
    }

    /**
     * modifyShipmentData
     * @param Shipment
     * @param CCIIState
    */
    public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception
    {
        traceLog("PostUndeclaredStatus","Beginning modifyShipmentData()");


        if(isNewTransaction(state.getScan().getTransactionTimestamp(),
		    ship.getDeclaredTransactionSequenceTimestamp()))
        {
            if(!(ship.getDeclaredFlag().equals("N")))
            {
                ship.setDeclaredFlag("N");
		ship.setDeclaredTransactionSequenceTimestamp(
		     state.getScan().getTransactionTimestamp());
                m_updateShipmentCoreClearance = true;
                state.addActivity(ms_undeclaredActivityCode);
                traceLog("PostUndeclaredStatus","Post declared activity");
            }
            else
            {
                state.addActivity(ms_ignoredActivityCode);
                traceLog("PostUndeclaredStatus","Post ignored activity");
            }
        }
	else
	{
            state.addActivity(ms_outOfOrderActivityCode);
            traceLog("PostUndeclaredStatus","Post out of order activity");
        }

        traceLog("PostUndeclaredStatus","returning from modifyShipmentData() ...");
        return state;
    }

    public static void main(String args[])
    {
	 try
	 {
             PostUndeclaredStatus postUndeclaredStatus = new PostUndeclaredStatus();

             postUndeclaredStatus.test();
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
