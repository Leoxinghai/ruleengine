/*
 * Created on Mar 8, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.util.*;

public class BKKPostScan extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: BKKPostScan.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  SortDate m_sortDate = new SortDate();

  public BKKPostScan() throws Exception
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
    if(state.getScan().getInViewName().equals("RIPRECONSOLE")) {
    	state.setScanTypeCode(state.getScan().getOutViewName());
    } else if(state.getScan().getInViewName().equals("BKKDUP")) {
        if(state.getScan().getOutViewName().equals("BAGMIX"))
            state.setScanTypeCode("CONS");
        else
	        state.setScanTypeCode(state.getScan().getOutViewName());
    }

    if(state.getScan().getShipmentOid() ==0) {
    	state.getScan().setErrorNumber(Messages.EM_SHIPMENT_OID_NULL);
    }
    if(!state.getScanTypeCode().equals("CMT") && !state.getScanTypeCode().equals("STAT") &&!state.getScanTypeCode().equals("CONS")&&!state.getScanTypeCode().equals("DCON")&&!state.getScanTypeCode().equals("BAT")&&!state.getScanTypeCode().equals("DBAT")) {
	    try
	    {
	      scan = dbConnection.fetchScan(state.getScanTypeCode(),state.getScan().getHandlingUnitOid(),state.getScan().getShipmentOid());
	    }
	    catch (Exception ex)
	    {
	      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure attempting to save Scan", ex);
	      throw cciiEx;
	    }
    }
    if(scan != null) {
    	state.getScan().setErrorNumber(Messages.EM_REPEAT_SCAN);
    	return state;
    }
    scan = new Scan();
    scan.setScanTypeCode(state.getScanTypeCode());
    scan.setLocStatNumber(state.getScan().getLocStatNbr());
    scan.setEmployeeNumber(state.getScan().getUserLogon());
    scan.setWarehouseCd(state.getScan().getWarehouseCode());
    scan.setStagingAreaCode(state.getScan().getStagingAreaCode());
    scan.setCommentDescription(state.getScan().getComments());
    scan.setFromConsFlag(state.getScan().getFromConsFlag());
    
    try
    {
      scan.setScanOidNumber(getOid(OidFactoryTypes.SCAN));
      scan.setShipmentOidNumber(state.getScan().getShipmentOid());
      scan.setPieceOidNumber(state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
      String msg = "Failure during Jolt service call to get Scan Oid Number " + ex + "(See System.err for initial stack trace)";
      traceLog("SetScanForPosting", msg);
      System.err.println(msg);
      ex.printStackTrace(System.err);
      CCIILogException cciiEx =
          new CCIILogException("BA_JOLT_ERROR_NUMB", msg );
      throw cciiEx;
    }
    
      scanCode = scan.getScanTypeCode();
      locStatNbr = scan.getLocStatNumber();
      if (( locStatNbr == null ) || ( locStatNbr.length() < 1 ))
      {
        locStatNbr = "00";
      }
      scanDefinition = dbConnection.fetchScanDefinition(scanCode,locStatNbr);
      if (scanDefinition == null)
      {
        state.getScan().setErrorNumber(Messages.EM_INVALID_STAT_NUMBER);
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

