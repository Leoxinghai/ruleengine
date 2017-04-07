package cciij.businessActions;

/**
 * Title:       Verify Arrival Scan
 *
 * Description: This business action checks the database for a scan record
 *              that matches the shipmentOid number, the handlingUnit Oid number,
 *              and has an arrival scan type. If no record is found an error message
 *              (IM_NO_ARRIVAL_SCAN) is set in the scan object error message attribute.
 *
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Scan fetch failed
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001   Ed McAleer   Add tags and changed exception to CCIILogException.
 * 03/06/2003   Lorraine Dominguez  Changed to inherit from base class and added new
 *                                  method getScanName()
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class VerifyArrivalScan extends VerifyScanBase {

    private static final String m_whatVersion = "@(#) $RCSfile: VerifyArrivalScan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public VerifyArrivalScan() throws Exception 
    {
	traceLog("VerifyArrivalScan","In Constructor");
    }

    public VerifyArrivalScan(String groupName) throws Exception
    {
	super(groupName);
    }


    // reads and returns the string value of ARRIVAL_SCAN_NAME from the config file
    protected String getScanName() throws Exception
    {
	return readConfigVariableString("ARRIVAL_SCAN_NAME");
    }

    protected int getCodeForScanMissing(CCIIState state)
    {
	if(readConfigVariableBool("PREVIOUS_ARRIVAL_REQUIRED",false))
	{	    
	    String exceptActCode = m_config.getValue("NO_PREV_ARRIVAL_EXCEPT_ACTIVITY_CODE");
	    if((exceptActCode != null) && (exceptActCode.length() > 0))
	    {
		state.addExceptionActivity(exceptActCode);
	    }

	    return Messages.EM_NO_ARRIVAL_SCAN;
	}
	else
	{
	    if(readConfigVariableBool("NO_PREVIOUS_ARRIVAL_SET_IM",false))
	    {
		return Messages.IM_NO_ARRIVAL_SCAN;
	    }
	    else
	    {
		return state.getScan().getErrorNumber();
	    }
	}
    }

    protected int getCodeForScanThere(CCIIState state)
    {
	if(readConfigVariableBool("PREVIOUS_ARRIVAL_ALLOWED",true))
	{
	    if(readConfigVariableBool("PREVIOUS_ARRIVAL_SET_IM",false))
	    {
		return Messages.IM_ARRIVAL_SCAN;
	    }
	    else
	    {
		return state.getScan().getErrorNumber();
	    }
	}
	else
	{
	    String exceptActCode = m_config.getValue("PREV_ARRIVAL_EXCEPT_ACTIVITY_CODE");
	    if((exceptActCode != null) && (exceptActCode.length() > 0))
	    {
		state.addExceptionActivity(exceptActCode);
	    }
	    
	    return Messages.EM_PREVIOUS_ARRIVAL;
	}
    }

    public static void main(String args[])
    {
	try
	{
	    VerifyArrivalScan verifyArrivalScan = new VerifyArrivalScan();
	    verifyArrivalScan.test();
	}
	catch (Exception e)
	{
	    System.out.println(e);
	}
    }

    public void test() throws Exception
    {
	CCIIState cciiState = new CCIIState();

	//Get an existing shipment oid and hanling unit oid number in the database to test the business action
	//one with an arrival scan in the scan table and one without

	//with arrival scan
	cciiState.getScan().setShipmentOid(53221);
	cciiState.getScan().setHandlingUnitOid(5621);

	//without arrival scan
	//cciiState.getScan().setShipmentOid(53004);
	//cciiState.getScan().setHandlingUnitOid(5404);

	java.util.Date time = new java.util.Date();
	cciiState.getScan().setTransactionTimestamp(time);
	cciiState.getScan().setLocationCode("YYZ");
	cciiState = (CCIIState) actionEntry(cciiState);
	System.out.println("state after execution " + cciiState);

	return;
    }

}




