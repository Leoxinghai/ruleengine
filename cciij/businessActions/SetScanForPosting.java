package cciij.businessActions;

/**
 * Title:       Set Scan For Posting
 * Description:
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Julie McCarthy
 * @version 	1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of Scan Definition
 * @throws      cciij.util.CCIILogException Scan definition not found in DB
 * @throws      cciij.util.CCIILogException Failure during Jolt service call to get Scan Oid Number
 * @throws      cciij.util.CCIILogException Failure attempting to save Scan
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Modification History:
 * 2004/08/12    Tom Knobeloch  Added method setScanTypeCode to allow extending functionality
 *
 * 09/6/2005   Julie McCarthy
 *                          Removed dbb.setDatabaseSchemaName();
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class SetScanForPosting extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: SetScanForPosting.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  SortDate m_sortDate = new SortDate();

  public SetScanForPosting() throws Exception
  {
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {

        traceLog("SetScanForPosting","Starting");
      ScanDefinition scanDefinition = null;
      Scan scan = null;
      UploadKey uploadKey = null;
      String activityCode = null;
      String scanCode = null;
      Date sortDate = null;
      String warehouseCd = null;
      boolean addUploadKey = false;

      traceLog("SetScanForPosting", "Begining doIt()");
      traceLog("SetScanForPosting", state);

      scanCode = setScanTypeCode(state);

      if (scanCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException(
                "BA_CONFIG_ERROR_NUMB",
                "Scan type code not found: " + state.getScan().getInViewName().toUpperCase() + "_SCAN_CODE");
        throw cciiEx;
      }

      try
      {
        if (scanCode.equals("STAT"))
        {
          scanDefinition = dbConnection.fetchScanDefinition(scanCode, state.getScan().getLocStatNbr());
        }
        else
        {
          scanDefinition = dbConnection.fetchScanDefinition(scanCode);
        }
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure during fetch of Scan Definition");
        throw cciiEx;
      }

      if (scanDefinition == null)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_FETCH_ERROR_NUMB", "Scan definition: " + scanCode + ":" + state.getScan().getLocStatNbr() + " not found in DB");
        throw cciiEx;
      }

      sortDate = m_sortDate.currentSortDate(state.getScan().getLocationCode(),new Date(state.getScan().getSysDateTime()));

      scan = new Scan(0, //ScanOid
                state.getScan().getHandlingUnitOid(), //HUOid
                state.getScan().getShipmentOid(), //ShipmentOid
                new Date(state.getScan().getSysDateTime()), //DateTime
                state.getScan().getUserLogon(), //User
                scanDefinition.getScanTypeCode(), //ScanTypeCode
                scanDefinition.getLocStatNumber(), //LocStatNumber
                state.getScan().getStagingAreaCode(), //StagingAreaCode
                "", //StagingAreaFlag
                "", //fromCONSFlag
                sortDate,//sort date
                state.getScan().getLocationCode(),//locationcd
                state.getScan().getWarehouseCode(),//warehouseCd
                state.getScan().getInputMethodCode(),
		state.getScan().getComments());
      try
      {
        scan.setScanOidNumber(getOid(OidFactoryTypes.SCAN));
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

      scan.setScanLocationDescription(state.getScan().getDetainLoc());

      // This field is set in the 'UnrollCons.java" routine
      if (state.getScan().getFromConsFlag().equals("Y"))
      {
        scan.setFromConsFlag("Y");
      }

      state.setUploadFlag("Y");

      state.addScan(scan);

      if (scanDefinition.getAllowMultipleUploadFlag().equals("N") )
      {
        // look for previous scans of this scan type for this
        // piece, if any are found then return

        scan = dbConnection.fetchScan(scanDefinition.getScanTypeCode(),
                                      state.getScan().getHandlingUnitOid(),
                                      state.getScan().getShipmentOid() );

      }
      if (scan == null)
      {
          addUploadKey = true;
      }

      if ((scanDefinition.getAllowMultipleUploadFlag().equals("Y")) || (addUploadKey == true))
      {
	  String locStatNbr;
	  if (state.getScan().getLocStatNbr().equals(""))
	  {
	      locStatNbr = "00";
          }
	  else
	  {
	      locStatNbr = state.getScan().getLocStatNbr();
          }
      	  uploadKey = new UploadKey(
                         state.getScan().getLocationCode(),
                         "SCAN_DEF",
                         scanCode,
                         locStatNbr);

          state.addUploadKey(uploadKey);
      }
      return state;
  }

  protected String setScanTypeCode(CCIIState state)
  {
    return state.getScanTypeCode();
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
	  SetScanForPosting setScanForPosting = new SetScanForPosting();
	  setScanForPosting.test();
       }
       catch (Exception ex)
       {
          System.out.println(ex);
       }
   }

   public void  test() throws Exception
   {
        traceLog("SetScanForPosting","In test method");

        this.m_config.setLocationCode("YYZ");
        Date now = new Date();
        rmtc.util.Config cfg = new rmtc.util.Config();
        traceLog("SetScanForPosting","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("VerifyDepartureScan","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("SetScanForPosting","Server:" + server);
        traceLog("SetScanForPosting","User:" + user);
        traceLog("SetScanForPosting","Pass:" + pass);

        System.out.println("calling getconnection....................");
        java.sql.Connection conn =
        java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("SetScanForPosting","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("SetScanForPosting","Setting Connection object in bean");

        dbb.connect(conn);

        dbb.setLocationCode("YYZ");
        traceLog("SetScanForPosting","************* location code = "  + dbb.getLocationCode());

        traceLog("SetScanForPosting","Creating State object");

          CCIIState state = new CCIIState();
          RPBScan scan = new RPBScan();
          scan.setSysDateTime(now);
          scan.setInViewName("   ");
          scan.setShipmentOid(12345);
          scan.setHandlingUnitOid(12345);
          scan.setUserLogon("92163");
          scan.setLocStatNbr("22");
          scan.setStagingAreaCode("EEC");
          scan.setLocationCode("YYZ");
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
          //state = (CCIIState) actionEntry(state);
          doIt(state, dbb);

           System.out.println("After" + state);
           return;
    }

}

