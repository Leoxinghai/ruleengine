package cciij.businessActions;

/**
 * Title:       Intransit Data 
 * Description:
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Julie McCarthy
 * @version 	1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
import java.text.*;
import java.sql.Timestamp;


public class GetIntransitData extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: GetIntransitData.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  String  m_post7512PrintActivityCode = "";

  public GetIntransitData() throws Exception
  {
  }

  protected void readSiteConfigVariables () throws Exception
  {
     super.readSiteConfigVariables();
     m_post7512PrintActivityCode = readConfigVariableString("POST7512_PRINT_ACTIVITY_CODE");
  }
  
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {

      traceLog("GetIntransitData","Starting");
      Shipment shipment = null;
      ContractBroker contractBroker = null;
      RouteLeg routeLeg = null;
      HandlingUnit handlingUnit = null;
      PieceRouteLeg pieceRouteLeg = null;
      InTransit inTransit = null;
      FlightInfo flightInfo = null;
      Print7512Form print7512Form = new Print7512Form();
      CountryDef countryDef = null;
      LocationDef locationDef = null;
      Form7512Data form7512Data = null;
      form7512Data = new Form7512Data();
      traceLog("GetIntransitData", "Begining doIt()");
      traceLog("GetIntransitData", state);
      
      int shipmentOid, pieceOid;
      String locCd, destLocCd, awbNbr, consigneeNm, intransitCd, mawbNbr;
      String brokerNm, brokerCity, brokerCountry, formatedAwbNbr;
      String consigneeAddress, consigneeCity, consigneeCountryCode;
      String formattedConsigneeField = "";
      String lastForeignOrigin = "";
      String lastForeignOriginCountry = "";
      String importCd = "";
      String firstForeignLocCd = "";
      String finalForeignDest= "";
      String tailNbr = "";
      String flightNbr = ""; 
      String usPortOfUnlading = "";
      String portDirector = "";
      String exportedFrom = ""; 
      String userId = "";
      String customsDestCd = "";
      Date flightArrivalDt = new Date(0);
      Date flightDepartureDt = new Date(0);
      String dayOfMonth = "";
      int fileSeqNbr = 0;
      String fileName = "";
      String entryType;
      String specialHandling1Cd, specialHandling2Cd, specialHandling3Cd, specialHandling4Cd,
             specialHandling5Cd;
       
      shipmentOid = state.getScan().getShipmentOid();
      pieceOid = state.getScan().getHandlingUnitOid();
      locCd = state.getScan().getLocationCode();
      userId = state.getScan().getUserLogon();
      
      try {
          shipment = dbConnection.fetchShipment(shipmentOid);
          destLocCd = shipment.getDestinationLocCode();
          awbNbr = shipment.getAWBNumber();
          customsDestCd = shipment.getCustomsDestCd();
          specialHandling1Cd = shipment.getSpecialHandling1Cd();
          specialHandling2Cd = shipment.getSpecialHandling2Cd();
          specialHandling3Cd = shipment.getSpecialHandling3Cd();
          specialHandling4Cd = shipment.getSpecialHandling4Cd();
          specialHandling5Cd = shipment.getSpecialHandling5Cd();
          consigneeAddress = shipment.getConsigneeAddress();
          consigneeCity = shipment.getConsigneeCity();
          consigneeCountryCode = shipment.getConsigneeCountryCode();
          consigneeNm = shipment.getConsigneeCompanyName();
          if (consigneeNm.equals("")) {
      	      consigneeNm = shipment.getConsigneeContactName();
           }
      }
      catch (Exception ex) {
	CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
					"Failure trying to fetch shipment in GetIntransitData");
          throw cciiEx;
      }
      
         if (((specialHandling1Cd != null) && (specialHandling1Cd.equals("40"))) || 
             ((specialHandling2Cd != null) && (specialHandling2Cd.equals("40"))) ||
             ((specialHandling3Cd != null) && (specialHandling3Cd.equals("40"))) ||
             ((specialHandling4Cd != null) && (specialHandling4Cd.equals("40"))) ||
             ((specialHandling5Cd != null) && (specialHandling5Cd.equals("40")))) 
         {
             try {
                contractBroker = dbConnection.fetchContractBroker(shipmentOid);
             }
             catch (Exception ex) {
	     CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
					"Failure trying to fetch contractBroker in GetIntransitData");
             throw cciiEx;
             }   
             brokerNm = contractBroker.getBrokerNm();
             brokerCity = contractBroker.getBrokerCityNm();
             brokerCountry = contractBroker.getBrokerCountryCd();
             if (brokerNm == null) {
                  form7512Data.setConsignee(consigneeNm + "," + consigneeAddress + "," + consigneeCity + "," + consigneeCountryCode);
             	}
             else {
             	formattedConsigneeField += (consigneeNm + " c/o " + brokerNm);
             	if (brokerCity != null) {
             	   formattedConsigneeField += ", " + brokerCity;
             	} 
             	if (brokerCountry != null) {
             	   formattedConsigneeField += ", " + brokerCountry;
             	}
                form7512Data.setConsignee(formattedConsigneeField);
             }
         }
         else 
         {
           form7512Data.setConsignee(consigneeNm + "," + shipment.getConsigneeAddress() + "," + shipment.getConsigneeCity() + "," + shipment.getConsigneeCountryCode());
         }  
      
      
      try {
          handlingUnit = dbConnection.fetchHandlingUnitWithShipmentOidAndTrackingNbr(shipmentOid,awbNbr);
          pieceOid = handlingUnit.getHandlingUnitOidNumber();  
      }
      catch (Exception ex) {
	CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
				"Failure trying to fetch pieceRouteLeg inGetIntransitData");
          throw cciiEx;
      }
      
      try {
          pieceRouteLeg = dbConnection.fetchPieceRouteLeg(pieceOid);
          while (pieceRouteLeg != null) {
              try {	
                  routeLeg = dbConnection.fetchRouteLeg(pieceRouteLeg.getRouteNumber(), pieceRouteLeg.getRouteDate(), pieceRouteLeg.getRouteLegNumber());
                  flightArrivalDt = routeLeg.getArrivalLocalTimestamp();
	      }
              catch (Exception ex) {
	      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure trying to fetch routeLeg in GetIntransitData");
              throw cciiEx;
              }
	      if ((!(routeLeg.getOriginCountryCode().equals("US"))) && (routeLeg.getDestinationCountryCode().equals("US"))) {
                  lastForeignOrigin = routeLeg.getOriginLocCode();
                  lastForeignOriginCountry = routeLeg.getOriginCountryCode();
                  importCd = routeLeg.getDestinationLocCode();
              }
              if ((routeLeg.getOriginCountryCode().equals("US")) && (!(routeLeg.getDestinationCountryCode().equals("US")))) {
                 firstForeignLocCd = routeLeg.getDestinationLocCode();
              }
	      if (routeLeg.getDestinationLocCode().equals(locCd)) {
                  flightInfo = dbConnection.fetchFlightInfo(routeLeg.getRouteNumber(), routeLeg.getRouteLegNumber(), routeLeg.getRouteDate());
                  tailNbr = flightInfo.getTailNbr();
                  flightNbr = flightInfo.getTravelPlanNbr();
                  flightDepartureDt = flightInfo.getScheduledDepartureDt();
                  String newFlightDt = flightDepartureDt.toString();
                  dayOfMonth = newFlightDt.substring(8,10);
	      }
          pieceRouteLeg = dbConnection.fetchNextPieceRouteLeg();
         }
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of Piece Route Leg failed in GetIntransitData",ex);
	 throw cciiEx;
      }
      
      try {
          inTransit = dbConnection.fetchInTransitByShipmentOid(shipmentOid);
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of Intransit failed in GetIntransitData",ex);
	 throw cciiEx;
      }
            
      form7512Data.setEntryNo("");
      form7512Data.setPort("");
      form7512Data.setDate3(null);
      form7512Data.setCcnNumber(inTransit.getCCNNumber());
      entryType = (shipment.getEntryCategoryTypeCode());
      if (entryType.equals("IT")) {
      	entryType = "61";
      }	
      if (entryType.equals("TE")) {
      	entryType = "62";
      }	
      if (entryType.equals("IE")) {
      	entryType = "63";
      }	
      form7512Data.setClassOfEntry(entryType);
      try {
          locationDef = dbConnection.fetchLocationDef(importCd);
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of LocationDef failed in GetIntransitData",ex);
	 throw cciiEx;
      }
      form7512Data.setPortCodeNo(locationDef.getDistrictNumber() + " " + locationDef.getPortNumber());
      usPortOfUnlading = (locationDef.getCityName() + ", " + locationDef.getStateCode());
      form7512Data.setUsPortOfUnlading(usPortOfUnlading);
      form7512Data.setPortOf("Oakland, CA");
      
      form7512Data.setPreparationDate(inTransit.getPrepDate()); //prep date passed from client
      form7512Data.setEnteredBy("FEDERAL EXPRESS CORP");
      form7512Data.setIrsNbr("0071-0427-00700");
      form7512Data.setInBondVia("FEDERAL EXPRESS CORP  (IRS# 0071-0427-00700)");
      try {
          locationDef = dbConnection.fetchLocationDef(customsDestCd.substring(0,3));
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of LocationDef failed in GetIntransitData",ex);
	 throw cciiEx;
      }
      //if (!(entryType.equals("63"))) {
          portDirector = (locationDef.getCityName() + ", " + locationDef.getStateCode() + ", " + locationDef.getDistrictNumber() + locationDef.getPortNumber());
      //}     
      form7512Data.setPortDirector(portDirector);
      countryDef = dbConnection.fetchCountryDef(shipment.getConsigneeCountryCode());
      if (!(entryType.equals("61"))) {
      	   finalForeignDest = countryDef.getCountryName();
      }     
      form7512Data.setFinalForeignDestination(finalForeignDest);
      
      form7512Data.setForeignPortOfLading("");
      mawbNbr = shipment.getMawbNbr();
      if (mawbNbr != null) {
          mawbNbr = (mawbNbr.substring(0,3) + " " + mawbNbr.substring(3,7) + " " + mawbNbr.substring(7,11));
      }	
      form7512Data.setBlNo(mawbNbr);
      form7512Data.setDateOfSailing(null);
      form7512Data.setImportedOn(flightNbr + "-" + dayOfMonth + " - " + tailNbr);
      form7512Data.setFlag("USA");
      form7512Data.setFlightArrivalDate(flightArrivalDt);
      try {
          countryDef = dbConnection.fetchCountryDef(lastForeignOriginCountry);
          locationDef = dbConnection.fetchLocationDef(lastForeignOrigin);
          form7512Data.setLastForeignPort(locationDef.getCityName() + " " + countryDef.getCountryName());
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of LocationDef failed in GetIntransitData",ex);
	 throw cciiEx;
      }
      
      try {
          countryDef = dbConnection.fetchCountryDef(shipment.getShipperCountryCode());
          exportedFrom = countryDef.getCountryName();
          form7512Data.setExportedFrom(exportedFrom);
      }
      catch (Exception ex) {
	 CCIILogException cciiEx = new CCIILogException("BA_DB_ERR_NUMB", 
	 "Fetch of CountryDef failed in GetIntransitData",ex);
	 throw cciiEx;
      }     
      
      form7512Data.setFlightDepartureDate(flightDepartureDt); 
      form7512Data.setGoodsNowAt("FEC IMPORT FACILITY");
      form7512Data.setMarksAndNumbers(shipment.getPieceQuanity());
      
      if (awbNbr.length() > 11) {
           formatedAwbNbr =(awbNbr.substring(0,4) + " " + awbNbr.substring(4,8) + " " + awbNbr.substring(8,12));
      }
      else {
      	    formatedAwbNbr =(awbNbr.substring(0,3) + " " + awbNbr.substring(3,7) + " " + awbNbr.substring(7,11));
      }
      form7512Data.setDescriptionAndQuantity(formatedAwbNbr + (m_config.getValue("FORM7512_LINEITEM_FIELD_DELIMITER")) + shipment.getShipmentDescription());
      form7512Data.setGrossWeight(shipment.getLbsWgt()); 
      form7512Data.setValue(shipment.getLocalCustomsValueAmt());
      form7512Data.setPnNumber(shipment.getPriorNotificationNbr());
      form7512Data.setLineItemNote("ESTIMATED NOT VERIFIED");
      locationDef = dbConnection.fetchLocationDef(customsDestCd.substring(0,3));
      form7512Data.setCertificateOfLading(locationDef.getCityName() + ", " + locationDef.getStateCode()  + " " + locationDef.getDistrictNumber() + locationDef.getPortNumber());
      form7512Data.setEnteredOrWithdrawnComp("FEDERAL EXPRESS CORP");
      form7512Data.setEnteredOrWithdrawnInd("Emp# " + userId); 
      form7512Data.setNos("WAIVED");
      form7512Data.setCarrierName("FEDERAL EXPRESS CORP");
      form7512Data.setAgentOfCarrier("Emp# " + userId); 
      //pass 7512 object to print class
      fileSeqNbr ++;
      DecimalFormat decFormat = new DecimalFormat();
      decFormat.applyPattern("0000");
      String fileNumber = decFormat.format(fileSeqNbr);
      //fileName = (awbNbr + fileNumber + ".txt");
      fileName = (awbNbr + fileNumber);
      print7512Form.print(form7512Data,m_config,fileName);
      inTransit.setPrintTimeStamp(new java.sql.Timestamp(new Date().getTime()));
      dbConnection.updateInTransit(inTransit);
      state.addActivity( m_post7512PrintActivityCode );
  return state;     
  }

  public static void main(String args[])
  {
      try
      {
	  GetIntransitData getIntransitData = new GetIntransitData();
	  getIntransitData.test();
       }
       catch (Exception ex)
       {
          System.out.println(ex);
       }
   } 
   
   public void  test() throws Exception
   {
        traceLog("GetIntransitData","In test method");

        Date now = new Date();
        rmtc.util.Config cfg = new rmtc.util.Config();
        traceLog("GetIntransitData","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("GetIntransitData","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("GetIntransitData","Server:" + server);
        traceLog("GetIntransitData","User:" + user);
        traceLog("GetIntransitData","Pass:" + pass);

        System.out.println("calling getconnection....................");
        java.sql.Connection conn =
        java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("GetIntransitData","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("GetIntransitData","Setting Connection object in bean");

        dbb.connect(conn);
        dbb.setLocationCode("OAK");
        traceLog("GetIntransitData","************* location code = "  + dbb.getLocationCode());

        traceLog("GetIntransitData","Creating State object");

          CCIIState state = new CCIIState();
          RPBScan scan = new RPBScan();
          scan.setShipmentOid(23647144);
          scan.setHandlingUnitOid(12211074);
          scan.setUserLogon("24619");
          scan.setLocationCode("OAK"); 
          state.setScan(scan);
          
          System.out.println("Before" + state);
          state = (CCIIState) doIt(state, dbb);
          //state = (CCIIState) actionEntry(state);

           System.out.println("After" + state);
           conn.commit();
           conn.close();
           return;
    }

  
}

