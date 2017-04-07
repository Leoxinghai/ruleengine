package cciij.businessActions;

/**
 * Title:       Post Scan
 * Description:
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Scan type code not found
 * @throws      cciij.util.CCIILogException Failure during fetch of Scan Definition
 * @throws      cciij.util.CCIILogException Scan definition not found in DB
 * @throws      cciij.util.CCIILogException Failure during Jolt service call to get Scan Oid Number
 * @throws      cciij.util.CCIILogException Failure attempting to save Scan
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 02/27/2004   Julie McCarthy Modified to process each scan from the getScanVectorElement vector 
 *                             in the CCIIState object.  Also to add and activity to the activity
 *                             vector in the CCIIState object based on the SCAN_DEF record.
 *
 * 05/14/2003   Tom Knobeloch  Added code to save INPUT_METHOD_CD in the scan table.
 *
 * 12/26/2001   Ed McAleer   Add tags and changed exceptions to CCIILogException.
 *
 * Modification History:
 * 12/26/2001   Dan St John  code now uses Scan Class constructor that respects locationCd
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class PostScan extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostScan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  SortDate m_sortDate = new SortDate();

  public PostScan() throws Exception
  {
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {

    ScanDefinition scanDefinition = null;
    Scan scan = null;
    String activityCode = null;
    String scanCode = null;
    String locStatNbr = null;
  
    traceLog("PostScan", "Begining doIt()");
    traceLog("PostScan", state);

    
System.out.println(" state before postScan loop " + state);
    for (Iterator i = state.getScanVectorElement().iterator() ; i.hasNext(); ) 
    {
      scan = (Scan) i.next();
System.out.println(" in postScan loop " + scan);
      scanCode = scan.getScanTypeCode();
      locStatNbr = scan.getLocStatNumber();
      if (( locStatNbr == null ) || ( locStatNbr.length() < 1 ))
      {
        locStatNbr = "00";
      }
      scanDefinition = dbConnection.fetchScanDefinition(scanCode,locStatNbr);
      if (scanDefinition == null)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_FETCH_ERROR_NUMB", "Scan definition: " + scanCode + ":" + locStatNbr + " not found in DB");
        throw cciiEx;
      }
      else 
      if (scanDefinition.getActivityCode() != "")
      {
      	activityCode = scanDefinition.getActivityCode();
      	state.addActivity(activityCode);
      }
      try
      {
        dbConnection.saveScan(scan);
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure attempting to save Scan", ex);
        throw cciiEx;
      }
    }
    return state;
  }
  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }
  
   public static void main(String args[])
  {
      try
      {
	  PostScan postScan = new PostScan();
	  postScan.test();
       }
       catch (Exception ex)
       {
          System.out.println(ex);
       }
   } 
   
   public void  test() throws Exception
   {
        traceLog("PostScan","In test method");

        Date now = new Date();
        rmtc.util.Config cfg = new rmtc.util.Config();
        traceLog("PostScan","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("VerifyDepartureScan","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("PostScan","Server:" + server);
        traceLog("PostScan","User:" + user);
        traceLog("PostScan","Pass:" + pass);

        System.out.println("calling getconnection....................");
        java.sql.Connection conn =
        java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("PostScan","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("PostScan","Setting Connection object in bean");

        dbb.connect(conn);
        dbb.setLocationCode("NRT");
        traceLog("Post Scan","************* location code = "  + dbb.getLocationCode());

        traceLog("Post Scan","Creating State object");

        CCIIState state = new CCIIState();
        RPBScan scan = new RPBScan();
        scan.setSysDateTime(now);
        scan.setInViewName("   ");
        scan.setShipmentOid(12345);
        scan.setHandlingUnitOid(12345);
        scan.setUserLogon("92163");
        scan.setLocStatNbr("22"); 
        scan.setStagingAreaCode("EEC");
        scan.setLocationCode("NRT");
        scan.setWarehouseCode("IWJ");
        scan.setInputMethodCode("YYZ");
        scan.setFromConsFlag("N");
        scan.setDetainLoc("" );
        scan.setTransactionTimestamp(now);
        state.setScan(scan);
        state.setScanTypeCode("STAT");
        state.addUploadKey("NRT", "SCAN_DEF", "STAT", "22");
        state.addUploadKey("NRT", "SCAN_DEF", "BOUT", "00");
        System.out.println("Before" + state);
        state = (CCIIState) actionEntry(state);

        System.out.println("After" + state);
        return;
    }
  
}

