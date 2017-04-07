package cciij.businessActions;

/**
 * Title:       Verify Departure Scan
 *
 * Description: This business action checks the database for a scan record
 *              that matches the shipmentOid number, the handlingUnit Oid number,
 *              and has an departure scan type. If no record is found an error message
 *              (IM_NO_DEPARTURE_SCAN) is set in the scan object error message attribute.
 *
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author
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
 *
 * 09/6/2005   Julie McCarthy
 *                          Removed dbb.setDatabaseSchemaName();
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class VerifyDepartureScan extends VerifyScanBase {

    private static final String m_whatVersion = "@(#) $RCSfile: VerifyDepartureScan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public VerifyDepartureScan() throws Exception
    {
	traceLog("VerifyDepartureScan","In Constructor");
    }

    public VerifyDepartureScan(String groupName) throws Exception
    {
	super(groupName);
    }


    // reads and returns the string value of Departure_SCAN_NAME from the config file
    protected String getScanName() throws Exception
    {
	return readConfigVariableString("DEPARTURE_SCAN_NAME");
    }

    protected int getCodeForScanMissing(CCIIState state)
    {
	if(readConfigVariableBool("PREVIOUS_DEPARTURE_REQUIRED",false))
	{
	    String exceptActCode = m_config.getValue("NO_PREV_DEPARTURE_EXCEPT_ACTIVITY_CODE");
	    if((exceptActCode != null) && (exceptActCode.length() > 0))
	    {
		state.addExceptionActivity(exceptActCode);
	    }

	    return Messages.EM_NO_DEPART_SCAN;
	}
	else
	{
	    if(readConfigVariableBool("NO_PREVIOUS_DEPARTURE_SET_IM",false))
	    {
		return Messages.IM_NO_DEPART_SCAN;
	    }
	    else
	    {
		return state.getScan().getErrorNumber();
	    }
	}
    }

    protected int getCodeForScanThere(CCIIState state)
    {
	if(readConfigVariableBool("PREVIOUS_DEPARTURE_ALLOWED",true))
	{
	    if(readConfigVariableBool("PREVIOUS_DEPARTURE_SET_IM",false))
	    {
		return Messages.IM_DEPART_SCAN;
	    }
	    else
	    {
		return state.getScan().getErrorNumber();
	    }
	}
	else
	{
	    String exceptActCode = m_config.getValue("PREV_DEPARTURE_EXCEPT_ACTIVITY_CODE");
	    if((exceptActCode != null) && (exceptActCode.length() > 0))
	    {
		state.addExceptionActivity(exceptActCode);
	    }

	    return Messages.EM_PREVIOUS_DEPART;
	}
    }

    public static void main(String args[])
    {
	try
	{
	    VerifyDepartureScan verifyDepartureScan = new VerifyDepartureScan();
	    verifyDepartureScan.test();
	}
	catch (Exception e)
	{
	    System.out.println(e);
	}
    }

    public void test() throws Exception
    {
        traceLog("VerifyDepartureScan","In test method");

        this.m_config.setLocationCode("YYZ");

        rmtc.util.Config cfg = new rmtc.util.Config();

        traceLog("VerifyDepartureScan","Loading Oracle driver");

        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        traceLog("VerifyDepartureScan","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("VerifyShuttleData","Server:" + server);
        traceLog("VerifyShuttleData","User:" + user);
        traceLog("VerifyShuttleData","Pass:" + pass);

	System.out.println("calling getconnection....................");
        java.sql.Connection conn =
             java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("VerifyDepartureScan","Creating DB Bean");


	DatabaseBean dbb = new DatabaseBean();

        traceLog("VerifyDepartureScan","Setting Connection object in bean");

        dbb.connect(conn);

        dbb.setLocationCode("YYZ");
        traceLog("VerifyDepartureScan","************* location code = "  + dbb.getLocationCode());

        traceLog("VerifyDepartureScan","Creating State object");


	CCIIState cciiState = new CCIIState();

	//Get an existing shipment oid and hanling unit oid number in the database to test the business action
	//one with an Departure scan in the scan table and one without

	//with Departure scan
	//cciiState.getScan().setShipmentOid(53221);
	//cciiState.getScan().setHandlingUnitOid(5621);

	//without Departure scan
	cciiState.getScan().setShipmentOid(53004);
	cciiState.getScan().setHandlingUnitOid(5404);

	java.util.Date time = new java.util.Date();
	cciiState.getScan().setTransactionTimestamp(time);
	cciiState.getScan().setLocationCode("NRT");
	//cciiState = (CCIIState) actionEntry(cciiState);
	System.out.println("calling doIt....................");

	cciiState = (CCIIState) doIt(cciiState,dbb);
	System.out.println("state after execution " + cciiState);

	return;
    }

}




