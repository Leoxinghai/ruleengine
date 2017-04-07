package cciij.businessActions;

import com.oss.asn1.*;
import com.oss.util.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import imageRequestASN.*;
import imageRequestASN.ddtran.*;
import java.util.Date;
import java.lang.Number;
import java.text.*;
import java.io.*;

/*
 * Title:        ImageRequest.java
 * Description:  This class will be used to request an image from CDD.
 *               This message will be put on MQ.
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Kathy Smathers
 * @version 1.0
 *
 * Modification History:
 *   05/20/04    Kathy Smathers - Initial Creation.
 *
 */

public class ImageRequest extends JMSByteMessagePushBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: ImageRequest.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private float mf_highLowValueCutoff;
  private String m_highValueCd;
  private String m_lowValueCd;
  private String m_selectionSource;
  private String m_receiver;
  private String m_imgReqActCode;

  public ImageRequest() throws Exception
  {
      super("ImageRequest");
      traceLog("ImageRequest","In Constructor");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)
  throws Exception
  {
      traceLog("In ImageRequest Class", "In doIt Method");
      ASNrequest asnImageRequest= new ASNrequest();
      byte[]  outboundEncodedASNMsg
            = createMessage(state, asnImageRequest, dbConnection);
      if ( ! pushToQueue(outboundEncodedASNMsg) )
      {
        CCIILogException cciiEx =
             new CCIILogException ( "Failed to enqueue the message:",
                 "outboundEncodedASNMsg = [" + outboundEncodedASNMsg + "]");
        throw cciiEx;
      }
      state.addActivity ( m_imgReqActCode );
      return state;
  }

  protected void readSiteConfigVariables() throws Exception
  {
      super.readSiteConfigVariables();
      String highLowValueCutoff = readConfigVariableString("CDD_HI_LOW_VAL_CUTOFF");
      mf_highLowValueCutoff = Float.parseFloat(highLowValueCutoff);
      m_highValueCd = readConfigVariableString("CDD_HIGH_VALUE_CODE");
      m_lowValueCd = readConfigVariableString("CDD_LOW_VALUE_CODE");
      m_selectionSource = readConfigVariableString("CDD_REQUEST_SOURCE");
      m_receiver = readConfigVariableString("CDD_RECEIVER");
      m_imgReqActCode = readConfigVariableString("CDD_IMG_REQ_ACTIVITY_CODE");
  }

  public byte[] createMessage(CCIIState state,
                ASNrequest asnImageRequest,
                DatabaseBean dbConnection)
  throws Exception
  {
      traceLog("In ImageRequest Class", "In createMessage Method");
      traceLog("ImageRequest", state);

      SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss0");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      byte[] outboundASNMsg = null;
      Date m_convertDt = null;
      Date d_unformattedDt = null;
      String ls_formattedDt = null;
      String ls_date = null;
      String ls_shipmentOid = null;
      String ls_handlingUnitOid = null;
      String ls_awbSerialNbr;
      int li_shipmentOid;
      int li_handlingUnitOid;

      // Convert shipmentOid to a string
      li_shipmentOid = (state.getScan().getShipmentOid());
      ls_shipmentOid = String.valueOf(li_shipmentOid);

      asnImageRequest.setCddFunctionCode(new IA5String("A"));
      if (state.getRecuringInterceptFlag() == true)
      {
          asnImageRequest.setCddFunctionTypeCode(new IA5String("A"));
      }
      else
      {
          asnImageRequest.setCddFunctionTypeCode(new IA5String("M"));
      }

      Shipment shipment;
      try
      {
          shipment = dbConnection.fetchShipment(state.getScan().getShipmentOid());
          if (shipment == null)
          {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                       "ShipmentOid not found");
            throw cciiEx;
          }
      }
      catch (Exception ex )
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                       "Failure during fetch of Shipment data");
        throw cciiEx;
      }
      asnImageRequest.setCddAirbillNumber(new IA5String(shipment.getAWBNumber()));
      ls_awbSerialNbr = String.valueOf(shipment.getHAWBSerialNumber());
      asnImageRequest.setCddAwbSerialNumber(new IA5String(ls_awbSerialNbr));
      ls_formattedDt = dateTimeFormat.format(new Date(state.getScan().getSysDateTime()));
      asnImageRequest.setCddRequestTime(new IA5String(ls_formattedDt));
      asnImageRequest.setCddSelectionTimeStamp(new IA5String(ls_formattedDt));
      asnImageRequest.setCddClearanceLocCode(new IA5String(dbConnection.getLocationCode()));
      asnImageRequest.setCddOriginLoc(new IA5String(shipment.getOriginLocCode()));
      asnImageRequest.setCddDestinationLoc(new IA5String(shipment.getDestinationLocCode()));

      ASNrequest.CddSpclHandlingCds cddSpclHandlingCds= new ASNrequest.CddSpclHandlingCds();
      ScddSpclHandlingCdsGrp sddSpclHandlingCdsGrp  = new ScddSpclHandlingCdsGrp();
      if (shipment.getSpecialHandling1Cd() != null)
      {
          sddSpclHandlingCdsGrp.setCddSpclHandlingCd(new IA5String(shipment.getSpecialHandling1Cd()));
          cddSpclHandlingCds.add(sddSpclHandlingCdsGrp);
      }
      if (shipment.getSpecialHandling2Cd() != null)
      {
          sddSpclHandlingCdsGrp.setCddSpclHandlingCd(new IA5String(shipment.getSpecialHandling1Cd()));
          cddSpclHandlingCds.add(sddSpclHandlingCdsGrp);
      }
      if (shipment.getSpecialHandling3Cd() != null)
      {
          sddSpclHandlingCdsGrp.setCddSpclHandlingCd(new IA5String(shipment.getSpecialHandling1Cd()));
          cddSpclHandlingCds.add(sddSpclHandlingCdsGrp);
      }
      if (shipment.getSpecialHandling4Cd() != null)
      {
          sddSpclHandlingCdsGrp.setCddSpclHandlingCd(new IA5String(shipment.getSpecialHandling1Cd()));
          cddSpclHandlingCds.add(sddSpclHandlingCdsGrp);
      }
      if (shipment.getSpecialHandling5Cd() != null)
      {
          sddSpclHandlingCdsGrp.setCddSpclHandlingCd(new IA5String(shipment.getSpecialHandling1Cd()));
          cddSpclHandlingCds.add(sddSpclHandlingCdsGrp);
      }
      ls_formattedDt = dateTimeFormat.format(shipment.getShipmentDate());

      asnImageRequest.setCddShipDate(new IA5String(ls_formattedDt));

      asnImageRequest.setCddSelectCode(new IA5String(state.getScan().getInterceptCode()));
      asnImageRequest.setCddSelectionSource(new IA5String(m_selectionSource));
      asnImageRequest.setCddAgencyCode(new IA5String(state.getScan().getAgencyCode()));
      asnImageRequest.setCddEntryType(new IA5String(shipment.getEntryCategoryTypeCode()));
      asnImageRequest.setCddEmployeeNbr(new IA5String(m_selectionSource));
      asnImageRequest.setCddReceiver(new IA5String(m_receiver));
      asnImageRequest.setCddShipperName(new IA5String(shipment.getShipperContactName()));
      asnImageRequest.setCddShipperCompanyNm(new IA5String(shipment.getShipperCompanyName()));
      asnImageRequest.setCddShipperAccountNumber(new IA5String(Integer.toString(shipment.getShipperAccountNumber())));
      asnImageRequest.setCddConsigneeName(new IA5String(shipment.getConsigneeContactName()));
      asnImageRequest.setCddConsigneeCompanyNm(new IA5String(shipment.getConsigneeCompanyName()));
      asnImageRequest.setCddConsigneeAcctNbr(new IA5String(Integer.toString(shipment.getConsigneeAccountNumber())));
      asnImageRequest.setCddRouteNumber(new IA5String(state.getRouteLegInfo().getRouteNumber()));

      ls_formattedDt = dateFormat.format(state.getRouteLegInfo().getRouteDate());
      asnImageRequest.setCddRouteDate(new IA5String(ls_formattedDt));
      ls_formattedDt = dateFormat.format(state.getRouteLegInfo().getSortDate());
      asnImageRequest.setCddArrivalWorkDate(new IA5String(ls_formattedDt));
      asnImageRequest.setCddLocalTotalCustAmt(new IA5String(Double.toString(shipment.getLocalCustomsValueAmt())));
      asnImageRequest.setCddCountryOfOrigin(new IA5String(shipment.getOriginCountryCode()));
      asnImageRequest.setCddServiceType(new IA5String(shipment.getServiceCode()));

      if (shipment.getLocalCustomsValueAmt() > mf_highLowValueCutoff)
      {
          asnImageRequest.setCddHiValLoVal(new IA5String(m_highValueCd));
      }
      else
      {
          asnImageRequest.setCddHiValLoVal(new IA5String(m_lowValueCd));
      }
      asnImageRequest.setCddSdlFlg(new IA5String(shipment.getSaturdayDelFlg()));

      System.out.println("new asnImageRequest: " + asnImageRequest);
      traceLog("ImageRequest", "asnImageRequest " + asnImageRequest);

      // Encode the message into ASN format
      try
      {
          Imagerequestasn.initialize();
          Coder coder = Imagerequestasn.getBERCoder();
          coder.enableAutomaticEncoding();
          coder.disableEncoderDebugging();
          coder.disableEncoderConstraints();
          ByteArrayOutputStream aSink = new ByteArrayOutputStream();
          coder.encode(asnImageRequest, aSink);
          outboundASNMsg = aSink.toByteArray();
      }
      catch (EncodeFailedException efe)
      {
          System.out.println(efe.getLocalizedMessage());
          System.out.println(efe.getReason());
          System.out.println(efe.getMessage());
          throw efe;
      }

      return outboundASNMsg;
  }

  public void test(ImageRequest iR)
  {
      // Open a database connection
      DatabaseBean db = new DatabaseBean();
      try
      {
          db.connect();
          db.setLocationCode("OAK");
      }
      catch (Exception e)
      {
          System.out.println("ImageRequest failure opening DatabaseBean: " + e);
          e.printStackTrace(System.out);
          return;
      }
      
      java.util.Date aDt = new java.util.Date();
      // Create a shipment record to use in testing
      Shipment shp = new Shipment(86515,           // shipmentOidNumber
                                  "257443044247",  // awbNumber
                                  aDt,             // shipmentDate
                                  1,               // pieceQuantity
                                  1,               // handlingUnitQuantity
                                  false,           // isReasonCodeActive
                                  false,           // isReleaseCodeActive
                                  "OAK",           // dLocCode
                                  "NRT",           // oLocCode
                                  "0402",          // formTypeCode
                                  "A",             // manifestStatusCode
                                  "N");            // customsReleaseFlag
                                
      shp.setHAWBSerialNumber(1);
      shp.setSpecialHandling1Cd("10");
      shp.setSpecialHandling2Cd("20");
      shp.setSpecialHandling3Cd("30");
      shp.setSpecialHandling4Cd("40");
      shp.setSpecialHandling5Cd("50");
      shp.setEntryCategoryTypeCd("CN");
      shp.setShipperContactName("S ContactName");
      shp.setShipperCompanyName("S CompanyName");
      shp.setShipperAccountNumber(719593828);
      shp.setConsigneeContactName("C ContactName");
      shp.setConsigneeCompanyName("C CompanyName");
      shp.setConsigneeAccountNumber(828395917);
      shp.setLocalCustomsValueAmt(1234.50);
      shp.setOriginCountryCode("JP");
      shp.setSaturdayDelFlg("N");
      
      // Save the shipment record for testing
      try
      {
          db.saveShipment(shp);
      }
      catch (Exception e)
      {
          System.out.println("ImageRequest failure saving Shipment: " + e);
          e.printStackTrace(System.out);
          return;
      }

      // Create a state/scan object for testing
      CCIIState state = new CCIIState();
      RPBScan scan = new RPBScan();
      scan.setLocationCode(db.getLocationCode());
      scan.setAirbillNumber(shp.getAWBNumber());
      scan.setSysDateTime(new Date());
      scan.setHandlingUnitOid(0);
      scan.setShipmentOid(shp.getShipmentOidNumber());
      scan.setHAWB(shp.getAWBNumber());
      scan.setInterceptCode("BR");
      scan.setAgencyCode("B");
      scan.setServiceCode("SC");
      state.setScan(scan);

      state.setRouteLegInfo(new RouteLeg("TK123",   // RouteNumber
                                         aDt,       // RouteDate
                                         1,         // RouteLegNumber
                                         "",        // MAWBNumber
                                         "",        // DestinationLocCode
                                         "",        // OriginLocCode
                                         aDt,       // DepartureGMTTimestamp
                                         aDt,       // ArrivalGMTTimestamp
                                         aDt,       // DepartureLocalTimestamp
                                         aDt,       // ArrivalLocalTimestamp
                                         "",        // DestinationCountryCode
                                         "",        // OriginCountryCode
                                         aDt,       // SortDate
                                         "",        // RouteLegStatusCd
                                         "",        // BrokerCompleteFlag
                                         "",        // CustomsCompleteFlag
                                         0));       // RouteLegOidNumber
      
      System.out.println("preImageRequest state object: " + state);

      // Start a timer
      java.util.Date startDt = new java.util.Date();

      // Submit the state object to the ImageRequest businessAction
      state = (CCIIState)iR.actionEntry(state);
    
      // Stop the timer and log the elasped time
      java.util.Date endDt = new java.util.Date();
      long elapsedMS = 0;
      elapsedMS = endDt.getTime() - startDt.getTime();
      System.out.println("Posting of ImageRequest took " + elapsedMS + " ms");
      
      System.out.println("postImageRequest state object: " + state);
      
      // Delete the shipment record created for testing
      try
      {
          db.removeShipment(shp);
      }
      catch (Exception e)
      {
          System.out.println("ImageRequest failure removing Shipment: " + e);
          e.printStackTrace(System.out);
          return;
      }
      return;
  }
  public static void main(String args[]) throws Exception
  {
      ImageRequest iR = new ImageRequest();
      System.out.println("ImageRequest in main");
      iR.test(iR);
      System.out.println("ImageRequest exiting main");
  }

}
