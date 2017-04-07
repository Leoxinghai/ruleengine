//Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://kpdus.tripod.com/jad.html
//Decompiler options: packimports(3) fieldsfirst nonlb 
//Source File Name:   CCIIScanClient.java

package cciij.ruleprocessor;

import cciij.cciidata.*;
import java.io.PrintStream;
import java.util.Date;
import java.util.Vector;
import rmtc.util.Config;

import org.apache.log4j.Logger;

//Referenced classes of package cciij.ruleprocessor:
//         RuleProcessorClient

public class CCIIScanClient {

 private static final String m_whatVersion = "@(#) $RCSfile: CCIIScanClient.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
 protected Config m_config;
 protected RuleProcessorClient m_rpc;
 public static final String ARRIVAL_SCAN_VIEWNAME = "IPAVIEW";
 public static final String DEPARTURE_SCAN_VIEWNAME = "DEPVIEW";
 public static final String QUERY_SCAN_VIEWNAME = "QUERYVIEW";
 public static final String SPS_SCAN_VIEWNAME = "SPSVIEW";
 public static final String CAGE_SCAN_VIEWNAME = "CAGEVIEW";
 public static final String CORP_SCAN_VIEWNAME = "STATVIEW";
 public static final String HIP_SCAN_VIEWNAME = "HIPVIEW";
 public static final String HOP_SCAN_VIEWNAME = "HOPVIEW";
 public static final String RIP_SCAN_VIEWNAME = "RIPVIEW";
 public static final String ROP_SCAN_VIEWNAME = "ROPVIEW";
 public static final String SIP_SCAN_VIEWNAME = "SIPVIEW";
 public static final String SOP_SCAN_VIEWNAME = "SOPVIEW";
 public static final String COMMENT_SCAN_VIEWNAME = "CMTVIEW";
 public static final String STRIP_SCAN_VIEWNAME = "STRVIEW";
 public static final String MOVEMENT_IN_SCAN_VIEWNAME = "MOVEINVIEW";
 public static final String MOVEMENT_OUT_SCAN_VIEWNAME = "MOVEOUTVIEW";
 public static final String STAGE_IN_SCAN_VIEWNAME = "STIVIEW";
 public static final String STAGE_OUT_SCAN_VIEWNAME = "STOVIEW";
 public static final String POST_ACTIVITY_VIEWNAME = "POSTACTIVITYVIEW";
 public static final String BATCH_ADD_VIEWNAME = "CONSVIEW";
 public static final String BATCH_REMOVE_VIEWNAME = "DCONSVIEW";
 public static final String CLEARANCE_LABEL_VIEWNAME = "CLEARANCELABELVIEW";
 public static final String DOWNLOAD_PRINTER_CODES_VIEWNAME = "DNLDFMTVIEW";
 public static final String DUP_LABEL_VIEWNAME = "DUPLABVIEW";
 public static final String PRINTER_LABEL_VIEWNAME = "PRTRLBLVIEW";
 public static final String STAGE_AREA_LABEL_VIEWNAME = "STGLBLVIEW";
 public static final String WAREHOUSE_LABEL_VIEWNAME = "WHLBLVIEW";
 public static final String DETAINMENT_LOC_LABEL_VIEWNAME = "DETLOCLBLVIEW";
 public static final String MASS_ENTRY_SCAN_VIEWNAME = "MASS_ENTRY_INTERCEPT";
 public static final String ASSOCIATE_CRN_VIEWNAME = "ASSOCIATE_CRN";
 public static final String ROUTE_EDIT_VIEW_PREFIX = "RTED";
 public static final String ROUTE_EDIT_SCAN_VIEWNAME = "RTEDVIEW";
 public static final String ROUTE_EDIT_SORT_DATE_VIEWNAME = "RTEDSDTVIEW";
 public static final String ROUTE_EDIT_STATUS_CODE_VIEWNAME = "RTEDSCDVIEW";
 public static final String DETAINMENT_IN_SCAN_VIEWNAME = "EFPAVIEW";
 public static final String DETAINMENT_OUT_SCAN_VIEWNAME = "EFDOVIEW";
 public static final String REASON_CODE_SCAN_VIEWNAME = "EFREACVIEW";
 public static final String RELEASE_CODE_SCAN_VIEWNAME = "EFRELCVIEW";
 public static final String HANDLING_INSTRUCTION_SCAN_VIEWNAME = "EFHIVIEW";
 public static final String SHIPMENT_REMARK_SCAN_VIEWNAME = "EFSRVIEW";
 public static final int SCAN_NOT_IMPLEMENTED = 32;

 public CCIIScanClient() throws Exception {
     m_config = new Config();
     m_rpc = new RuleProcessorClient();
 }

 public RPBScan doArrivalScan(RPBScan scanObj) throws Exception {
     return doArrivalScan(scanObj, null);
 }

 public RPBScan doArrivalScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("IPAVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doBatchAddScan(RPBScan scanObj) throws Exception {
     return doBatchAddScan(scanObj, null);
 }

 public RPBScan doBatchAddScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("CONSVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doBatchRemoveScan(RPBScan scanObj) throws Exception {
     return doBatchRemoveScan(scanObj, null);
 }

 public RPBScan doBatchRemoveScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
 	 scanObj.setInViewName("DCONSVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doCageScan(RPBScan scanObj) throws Exception {
     return doCageScan(scanObj, null);
 }

 public RPBScan doCageScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("CAGEVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doCommentScan(RPBScan scanObj) throws Exception {
     return doCommentScan(scanObj, null);
 }

 public RPBScan doCommentScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("CMTVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doCorporateScan(RPBScan scanObj) throws Exception {
     return doCorporateScan(scanObj, null);
 }

 public RPBScan doCorporateScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     try {
	 	 int statNbr = Integer.parseInt(scanObj.getLocStatNbr());
	     if(statNbr < 0 || statNbr > 100) {
		     scanObj.setReturnMessage("Invalid statNbr:  " + statNbr);
		     scanObj.setErrorNumber(47);
		     return scanObj;
	     }
     } catch(NumberFormatException nfe) {
	     scanObj.setReturnMessage("Invalid statNbr:  " + scanObj.getLocStatNbr() + ":" + nfe);
	     scanObj.setErrorNumber(47);
	     return scanObj;
     }     
     scanObj.setInViewName("STATVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doDepartureScan(RPBScan scanObj) throws Exception {
     return doDepartureScan(scanObj, null);
 }

 public RPBScan doDepartureScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("DEPVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doHipScan(RPBScan scanObj) throws Exception {
     return doHipScan(scanObj, null);
 }

 public RPBScan doHipScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("HIPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doHopScan(RPBScan scanObj) throws Exception {
     return doHopScan(scanObj, null);
 }

 public RPBScan doHopScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("HOPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doMoveInScan(RPBScan scanObj) throws Exception {
     return doMoveInScan(scanObj, null);
 }

 public RPBScan doMoveInScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     if(scanObj.getStagingAreaCode().length() == 0) {
         scanObj.setErrorNumber(108);
         return scanObj;
     } else {
         scanObj.setInViewName("MOVEINVIEW");
         return doCommonCode(scanObj, uploadObj);
     }
 }

 public RPBScan doMoveOutScan(RPBScan scanObj) throws Exception {
     return doMoveOutScan(scanObj, null);
 }

 public RPBScan doMoveOutScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     if(scanObj.getStagingAreaCode().length() == 0) {
         scanObj.setErrorNumber(108);
         return scanObj;
     } else {
         scanObj.setInViewName("MOVEOUTVIEW");
         return doCommonCode(scanObj, uploadObj);
     }
 }

 public RPBScan doQueryScan(RPBScan scanObj) throws Exception {
     return doQueryScan(scanObj, null);
 }

 public RPBScan doQueryScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("QUERYVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doRipScan(RPBScan scanObj) throws Exception {
     return doRipScan(scanObj, null);
 }

 public RPBScan doRipScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("RIPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doRopScan(RPBScan scanObj) throws Exception {
     return doRopScan(scanObj, null);
 }

 public RPBScan doRopScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("ROPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doShowPackageStatusScan(RPBScan scanObj) throws Exception {
     return doQueryScan(scanObj, null);
 }

 public RPBScan doShowPackageStatusScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("SPSVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doSipScan(RPBScan scanObj) throws Exception {
     return doSipScan(scanObj, null);
 }

 public RPBScan doSipScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("SIPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doSopScan(RPBScan scanObj) throws Exception {
     return doSopScan(scanObj, null);
 }

 public RPBScan doSopScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("SOPVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doStageInScan(RPBScan scanObj) throws Exception {
     return doStageInScan(scanObj, null);
 }

 public RPBScan doStageInScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("STIVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doStageOutScan(RPBScan scanObj) throws Exception {
     return doStageOutScan(scanObj, null);
 }

 public RPBScan doStageOutScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("STOVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doStripPaperworkScan(RPBScan scanObj) throws Exception {
     return doStageInScan(scanObj, null);
 }

 public RPBScan doStripPaperworkScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("STRVIEW");
     return doCommonCode(scanObj, uploadObj, false);
 }

 public RPBScan doDetainmentInScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFPAVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doDetainmentOutScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFDOVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doReasonCodeScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFREACVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doReleaseCodeScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFRELCVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doHandlingInstructionScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFHIVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doShipmentRemarkScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     scanObj.setInViewName("EFSRVIEW");
     return doCommonCode(scanObj, uploadObj);
 }

 public RPBScan doScanByViewName(String viewName,RPBScan scanObj, UploadStatus uploadObj) throws Exception {
 	scanObj.setInViewName(viewName);
    scanObj.setSysDateTime(new Date());
    scanObj.setTransactionTimestamp(new Date());
    scanObj.setErrorNumber(0);
    RPBScan scanResult = scanObj;
    checkRuleProcessor();
    scanResult = m_rpc.sendScan(scanObj, uploadObj, null, null, false);
    return scanResult;
 }
 
 public boolean downloadPrinterCodes(String locationCd, String printerId) throws Exception {
     RPBScan scanObj = new RPBScan();
     scanObj.setSysDateTime(new Date());
     scanObj.setErrorNumber(0);
     scanObj.setInViewName("DNLDFMTVIEW");
     scanObj.setLocationCode(locationCd);
     scanObj.setPrinterCode(printerId);
     RPBScan scanResult = scanObj;
     checkRuleProcessor();
     scanResult = m_rpc.sendScan(scanObj);
     return scanResult.getErrorNumber() == 0;
 }

 public RPBScan doSendGenericScan(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     return doCommonCode(scanObj, uploadObj);
 }

 public Vector getIntercepts() {
     Vector ints = new Vector();
     return ints;
 }

 public RPBScan updateRouteInfo(RPBScan scanObj, RouteLeg rteObj) throws Exception {
     scanObj.setInViewName("RTEDVIEW");
     return doCommonCode(scanObj, null, rteObj);
 }

 public RPBScan updateRouteSortDate(RPBScan scanObj, RouteLeg rteObj) throws Exception {
     scanObj.setInViewName("RTEDSDTVIEW");
     return doCommonCode(scanObj, null, rteObj);
 }

 public RPBScan updateRouteStatusCode(RPBScan scanObj, RouteLeg rteObj) throws Exception {
     scanObj.setInViewName("RTEDSCDVIEW");
     return doCommonCode(scanObj, null, rteObj);
 }

 public RPBScan postActivity(RPBScan scanObj, ActivitiesList actList) throws Exception {
     scanObj.setInViewName("POSTACTIVITYVIEW");
     scanObj.setSysDateTime(new Date());
     scanObj.setErrorNumber(0);
     checkRuleProcessor();
     RPBScan scanResult = m_rpc.sendScan(scanObj, null, actList);
     return scanResult;
 }

 public RPBScan printClearanceLabel(RPBScan scan) throws Exception {
     scan.setInViewName("CLEARANCELABELVIEW");
     scan.setErrorNumber(0);
     return doCommonCode(scan, null, false);
 }

 public RPBScan doDupLabel(RPBScan scan) throws Exception {
     scan.setInViewName("DUPLABVIEW");
     return doCommonCode(scan, null, false);
 }

 public boolean printPrinterLabel(String printerId, String locationCd) throws Exception {
     RPBScan scanObj = new RPBScan();
     scanObj.setPrinterCode(printerId);
     scanObj.setLocationCode(locationCd);
     return printLabel(scanObj, "PRTRLBLVIEW");
 }

 public boolean printStageAreaLabel(String printerId, String warehouseCode, String stagingArea, String locationCd) throws Exception {
     RPBScan scanObj = new RPBScan();
     scanObj.setPrinterCode(printerId);
     scanObj.setWarehouseCode(warehouseCode);
     scanObj.setStagingAreaCode(stagingArea);
     scanObj.setLocationCode(locationCd);
     return printLabel(scanObj, "STGLBLVIEW");
 }

 public boolean printDetainmentLocLabel(String printerId, String warehouseCode, String stagingArea, String detainmentLoc, String locationCd) throws Exception {
     RPBScan scanObj = new RPBScan();
     scanObj.setPrinterCode(printerId);
     scanObj.setWarehouseCode(warehouseCode);
     scanObj.setStagingAreaCode(stagingArea);
     scanObj.setDetainLoc(detainmentLoc);
     scanObj.setLocationCode(locationCd);
     return printLabel(scanObj, "DETLOCLBLVIEW");
 }

 public boolean printWarehouseLabel(String printerId, String warehouseCode, String locationCd) throws Exception {
     RPBScan scanObj = new RPBScan();
     scanObj.setPrinterCode(printerId);
     scanObj.setWarehouseCode(warehouseCode);
     scanObj.setLocationCode(locationCd);
     return printLabel(scanObj, "WHLBLVIEW");
 }

 public void cleanup() {
     if(m_rpc != null) {
         m_rpc.remove();
         m_rpc = null;
     }
 }

 public static void main(String args[]) {
     if(args.length < 6 || args.length > 7) {
         System.out.println("Usage: ");
         System.out.println("<location> <warehouse> <airbill number> <airbill form type> <airbill type> <airbill entry> [<printer code>]");
     }
     System.out.println("starting main...");
     try {
         CCIIScanClient sc = new CCIIScanClient();
         RPBScan rpb = new RPBScan();
         rpb.setLocationCode(args[0]);
         rpb.setWarehouseCode(args[1]);
         rpb.setAirbillNumber(args[2]);
         rpb.setAirbillType(args[3]);
         rpb.setAirbillFormType(args[4]);
         rpb.setAirbillEntry(args[5]);
         if(args.length == 7)
             rpb.setPrinterCode(args[6]);
         rpb.setUserLogon("SClient");
         rpb.setErrorNumber(0);
         UploadStatus uls = new UploadStatus();
         uls.setFedExShuttleFlag(true);
         RPBScan rpbBack = sc.doArrivalScan(rpb, uls);
         System.out.println("\n...finished main .......");
         System.out.println("Result is: " + rpbBack.getErrorNumber());
         System.out.println("Scan object: " + rpbBack);
     }
     catch(Exception e) {
         System.out.println("Caughtexception: " + e);
         e.printStackTrace();
         System.exit(1);
     }
 }

 protected RPBScan doCommonCode(RPBScan scanObj, UploadStatus uploadObj) throws Exception {
     return doCommonCode(scanObj, uploadObj, ((RouteLeg) (null)));
 }

 protected RPBScan doCommonCode(RPBScan scanObj, UploadStatus uploadObj, boolean requiresWhse) throws Exception {
     return doCommonCode(scanObj, uploadObj, null, requiresWhse, false);
 }

 protected RPBScan doCommonCode(RPBScan scanObj, UploadStatus uploadObj, RouteLeg rl) throws Exception {
     return doCommonCode(scanObj, uploadObj, rl, true, false);
 }

 protected RPBScan doCommonCode(RPBScan scanObj, UploadStatus uploadObj, RouteLeg rl, boolean requiresWhse, boolean isPieceLevelIntercept) throws Exception {
     if(!isScanObjectOk(scanObj, requiresWhse)) {
         return scanObj;
     } else {
         scanObj.setSysDateTime(new Date());
         scanObj.setTransactionTimestamp(new Date());
         scanObj.setErrorNumber(0);
         RPBScan scanResult = scanObj;
         checkRuleProcessor();
         scanResult = m_rpc.sendScan(scanObj, uploadObj, null, rl, isPieceLevelIntercept);
         return scanResult;
     }
 }

 protected void checkRuleProcessor() throws Exception {
     if(m_rpc == null)
         m_rpc = new RuleProcessorClient();
 }

 protected boolean printLabel(RPBScan scanObj, String viewName) throws Exception {
     scanObj.setInViewName(viewName);
     scanObj.setSysDateTime(new Date());
     scanObj.setErrorNumber(0);
     RPBScan scanResult = scanObj;
     checkRuleProcessor();
     scanResult = m_rpc.sendScan(scanObj);
     return scanResult.getErrorNumber() == 0;
 }

 protected boolean isScanObjectOk(RPBScan scanObj, boolean requiresWhse) {
    logger.debug("isScanObjectOk.1"); 
 	if(scanObj.getInViewName().length() == 0) {
         scanObj.setReturnMessage("Internal CCIIScanClient Error");
         scanObj.setErrorNumber(36);
         return false;
     }
     if(scanObj.getAirbillNumber().length() < 10 && !scanObj.getInViewName().startsWith("RTED")) {
         scanObj.setErrorNumber(42);
         return false;
     }
     if(scanObj.getUserLogon().length() == 0) {
         scanObj.setErrorNumber(38);
         return false;
     }
     if(scanObj.getLocationCode().length() == 0) {
         scanObj.setReturnMessage("Location Code is Required");
         scanObj.setErrorNumber(36);
         return false;
     }
     if(scanObj.getWarehouseCode().length() == 0) {
         m_config.setLocationCode(scanObj.getLocationCode());
         String defaultWhseCode = m_config.getValue("DEFAULT_WAREHOUSE_CODE");
         if(defaultWhseCode == null) {
             if(requiresWhse) {
                 scanObj.setErrorNumber(36);
                 scanObj.setReturnMessage("Warehouse Code or Default Warehouse Code is required for location:  " + scanObj.getLocationCode());
                 return false;
             }
             scanObj.setWarehouseCode(scanObj.getLocationCode());
         } else {
             scanObj.setWarehouseCode(defaultWhseCode);
         }
     }
     logger.debug("isScanObjectOk.4"); 
     return true;
 }

 protected RPBScan notImplemented(RPBScan scanObj) {
     scanObj.setReturnMessage("This function is not supported at this time");
     scanObj.setErrorNumber(32);
     return scanObj;
 }
 
 private Logger logger = Logger.getLogger(CCIIScanClient.class);
}
