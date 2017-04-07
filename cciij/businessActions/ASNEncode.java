package cciij.businessActions;

/**
 * Title:        ASN Encode
 * Description:  Create an ASN message based on the State.   When created put the
 *               ASN buffer onto the MQ communicating with the Event Translator.
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   02/24/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;

import cciicosmos.Cciicosmos;
import cciicosmos.cosmosasn.CosmosAsn;
import cciicosmos.cosmosasn.CosmosMasterGrp;
import cciicosmos.cosmosasn.CosmosTrackingNumberGrp;

import java.text.*;
import java.util.*;
import java.io.*;
import com.oss.asn1.*;
import com.oss.util.*;


public class ASNEncode extends PostMQMessage
{
  private static final String m_whatVersion = "@(#) $RCSfile: ASNEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  private CosmosMasterGrp m_cosmosMasterGrp = null;

  public ASNEncode() throws Exception
  { 
    m_format = "ASN1";
    m_transactionType = "BZT598C";
    traceLog("ASNEncode","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public void initialize(UploadCategoryDef uploadCategoryDef, String system, String mode) throws Exception
  {
    super.initialize(uploadCategoryDef, system, mode);
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    return state;
  } 

  public void createMessage(CCIIState state,
                            DatabaseBean dbConnection,
                            Upload upload)
                            throws Exception

  {
    traceLog("ASNEncode", state); 

    m_cosmosMasterGrp   = new CosmosMasterGrp();
    CosmosTrackingNumberGrp cosmosTrackingNumberGrp = new CosmosTrackingNumberGrp();
    CosmosMasterGrp.AssocTrackingNumber assocTrackingNumber = new CosmosMasterGrp.AssocTrackingNumber();

    Date m_convertDt = null; 

    String ms_scanTypeCode = null;
    String ms_hourMinute   = null;
    String ms_monthDay     = null;
    String ms_statCode     = null;
    String ms_containerInd = null;
    String ms_handlingCode = null;


    m_config.setLocationCode(state.getCurrentScan().getLocationCd());

    ms_scanTypeCode = state.getScanTypeCode();

    // Move the common fields to their position
//Yap 28/03    m_cosmosMasterGrp.setScanSource(new IA5String("7"));                                        // 103 Scan Source, CCII = 7
    m_cosmosMasterGrp.setScanLocation(new IA5String(upload.getCosmosLocCode()));                                //  39 Location Code
    if (state.getScan().getUserLogon().length() > 6)
    {
      m_cosmosMasterGrp.setEmployeeNumber(new IA5String(state.getScan().getUserLogon().substring(1,7)));
    }
    else
    {
      m_cosmosMasterGrp.setEmployeeNumber(new IA5String(state.getScan().getUserLogon()));       //  14 Logon Number
    }
    if (state.getScan().getOrgCode().length() > 5)
    {
      int i_len = state.getScan().getOrgCode().length();
      m_cosmosMasterGrp.setLastPartOrgCode(new IA5String(state.getScan().getOrgCode().substring(i_len-5)));
    }
    else
    {
      m_cosmosMasterGrp.setLastPartOrgCode(new IA5String(state.getScan().getOrgCode()));        // 183 User Org Code
    }
    if (state.getScan().getSysDateTime() > 0)
    {
      // Get Date/Time information from l_sysDateTime
      m_convertDt = new Date(state.getScan().getSysDateTime());
    }
    else
    {
      // Get Date/Time information as current Date/Time
      m_convertDt = new Date();
    }

    // set the calendar to the local timezone
//    System.out.println("ASNEncode, ready to perform Date conversion for time zone " + m_localTimeZone);

    TimeZone m_timeZone = TimeZone.getTimeZone(m_localTimeZone);       // Comes from LOCAL_TIMEZONE parameter
    Calendar calendar = new GregorianCalendar(m_timeZone);             // Build a Calendar based on m_timeZone
    calendar.setTime(m_convertDt);                                     // Load in the time

//    System.out.println("HOUR " + calendar.get(Calendar.HOUR_OF_DAY));
//    System.out.println("MINUTE " + calendar.get(Calendar.MINUTE));
//    System.out.println("YEAR " + calendar.get(Calendar.YEAR));
//    System.out.println("MONTH " + (calendar.get(Calendar.MONTH)+1));
//    System.out.println("DAY_OF_MONTH " + calendar.get(Calendar.DAY_OF_MONTH));
//    System.out.println("ZONE OFFSET " + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
//    System.out.println("DST OFFSET " + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));

    // set ms_hourMinute in HHMM format
    if (calendar.get(Calendar.HOUR_OF_DAY) < 10)
    {
      ms_hourMinute = "0" + Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    }
    else
    {
      ms_hourMinute = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    }
    if (calendar.get(Calendar.MINUTE) < 10)
    {
      ms_hourMinute = ms_hourMinute + "0" + Integer.toString(calendar.get(Calendar.MINUTE));
    }
    else
    {
      ms_hourMinute = ms_hourMinute + Integer.toString(calendar.get(Calendar.MINUTE));
    }
//    System.out.println("ASNEncode, AFTER Time being sent to COSMOS " + ms_hourMinute);

    // set  ms_monthDay    in MMDD format
    if (calendar.get(Calendar.MONTH)+1 < 10)
    {
      ms_monthDay = "0" + Integer.toString(calendar.get(Calendar.MONTH)+1);
    }
    else
    {
      ms_monthDay = Integer.toString(calendar.get(Calendar.MONTH)+1);
    }
    if (calendar.get(Calendar.DAY_OF_MONTH) < 10)
    {
      ms_monthDay = ms_monthDay + "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    }
    else
    {
      ms_monthDay = ms_monthDay + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    }
    // System.out.println("ASNEncode, Date being sent to COSMOS " + ms_monthDay);

    m_cosmosMasterGrp.setBeginFunctionTime(new IA5String(ms_hourMinute));                       //  34 Begin Scan Time
    m_cosmosMasterGrp.setScanDate(new IA5String(ms_monthDay));                                  //  35 Scan Date
    m_cosmosMasterGrp.setEndFunctionTime(new IA5String(ms_hourMinute));                         //  36 End Scan Time

//    System.out.println("ASNEncode, ms_scanTypeCode >" + ms_scanTypeCode + "<");
    //added by xinghai
    m_cosmosMasterGrp.setScanType(new IA5String(state.getScan().getLocStatNbr()));
    
    // CONS and DCON stores airbills differently
    if (!ms_scanTypeCode.equals("CONS")   &&         // Not a CONS
        !ms_scanTypeCode.equals("DCON") )            // Not a DCON 
    {
      m_cosmosMasterGrp.setAirbillNumber(new IA5String(state.getScan().getAirbillNumber()));    //  38 Airbill Number
      m_cosmosMasterGrp.setAirbillTypeCode(new IA5String(state.getScan().getAirbillType()));    //   2 Airbill Type
      m_cosmosMasterGrp.setAirbillFormCode(new IA5String(state.getScan().getAirbillFormType())); // 212 Airbill Form code
//Yap 28/03      m_cosmosMasterGrp.setAirbillEntryType(new IA5String(state.getScan().getAirbillEntry()));  // 211 Airbill Entry
//      m_cosmosMasterGrp.setAstraLabelData(new IA5String(state.getScan().getAstraData()));       // 357 Astra, first 16 chars
      m_cosmosMasterGrp.setAirbillTimeOfScan(new IA5String(ms_hourMinute));                     //  40 Airbill Scan Time
    }
    
//Yap 28/03 Begin -->   
    if (!ms_scanTypeCode.equals("CONS")   &&	// Not a CONS
            !ms_scanTypeCode.equals("DCON") &&	// Not a DCON
            !ms_scanTypeCode.equals("CMT"))		// Not a CMT 
    {
        m_cosmosMasterGrp.setAirbillEntryType(new IA5String(state.getScan().getAirbillEntry()));  // 211 Airbill Entry	
    }
//Yap 28/03 End
    
    // This paragraph for the SIP Scan
    if (ms_scanTypeCode.equals("SIP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("02"));                                       //  41 SIP scan is type 02
      m_cosmosMasterGrp.setScanningLocation(new IA5String(upload.getCosmosLocCode()));          //  39 Scan Location Code
    }

    // This paragraph for the SOP Scan
    if (ms_scanTypeCode.equals("SOP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("01"));                                       //  41 SOP scan is type 01
      m_cosmosMasterGrp.setConveyanceRouteNbr(new IA5String(state.getScan().getMdeRoute()));    // 186 Conveyance Route Nbr
      m_cosmosMasterGrp.setDestinationCountry(new IA5String(state.getScan().getDestCountry())); //  98 Destination Country
      m_cosmosMasterGrp.setRampLocation(new IA5String(state.getScan().getLocationCode()));      //  25 Ramp Location
    }

    // this paragraph for the RIP Scan
    if (ms_scanTypeCode.equals("RIP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("24"));                                       //  41 RIP scan is type 24
      m_cosmosMasterGrp.setScanningLocation(new IA5String(upload.getCosmosLocCode()));			//  39 Scan Location Code
      m_cosmosMasterGrp.setLastPartOrgCode(new IA5String(state.getScan().getOrgCode()));								//  Yap - valude to be retrieved from config file
    }

    // This paragraph for the ROP Scan
    if (ms_scanTypeCode.equals("ROP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("22"));                                       //  41 ROP scan is type 22
 /*     if(state.getScan().getComments() != null) {
      	m_cosmosMasterGrp.setComments(new IA5String(state.getScan().getComments()));
      }
   */
      m_cosmosMasterGrp.setScanningLocation(new IA5String(upload.getCosmosLocCode()));			//  39 Scan Location Code
      m_cosmosMasterGrp.setScanLocation(new IA5String(upload.getCosmosLocCode()));			//  39 Scan Location Code
      m_cosmosMasterGrp.setRampLocation(new IA5String(upload.getCosmosLocCode()));      //  25 Ramp Location
      
      m_cosmosMasterGrp.setConveyanceRouteNbr(new IA5String(state.getScan().getMdeRoute()));    // 186 Conveyance Route Nbr
      m_cosmosMasterGrp.setDestinationCountry(new IA5String(state.getScan().getDestCountry())); //  98 Destination Country
//      m_cosmosMasterGrp.setRampLocation(new IA5String(state.getScan().getLocationCode()));      //  25 Ramp Location
    }

    // this paragraph for the HIP Scan
    if (ms_scanTypeCode.equals("HIP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("13"));                                       //  41 HIP scan is type 13
      setScanComment(state.getCurrentScan().getCommentDescription());
      m_cosmosMasterGrp.setQualMark(new IA5String("Q"));                                        // 279 Qual Mark
    }

    // This paragraph for the HOP Scan
    if (ms_scanTypeCode.equals("HOP"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("10"));                                       //  41 HOP scan is type 10
      setScanComment(state.getCurrentScan().getCommentDescription());
      m_cosmosMasterGrp.setDestinationCountry(new IA5String(state.getScan().getDestCountry())); //  98 Destination Country
      m_cosmosMasterGrp.setConveyanceRouteNbr(new IA5String(state.getScan().getMdeRoute()));    // 186 Conveyance Route Nbr
      // Fields not done in CCII application
      //        Container Id                                      // 141 Container Id
      //        Freight Checked Flag                              // 184 Freight Checked
      //        Mini Sort Flag                                    // 268 Mini Sort
      //        Cons Destination Location                         // 631 Cons Destination
      //        Container Indicator                               // 222 Container Indicator
    }

    if (ms_scanTypeCode.equals("STAT"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("07"));                                       //  41 STAT scan is type 07

      // Make sure there is a Stat Code to switch on
      ms_statCode = state.getCurrentScan().getLocStatNumber().trim();
      if (ms_statCode.length() < 1)
      {
        ms_statCode = "0";
      }
      m_cosmosMasterGrp.setExceptionCode(new IA5String(ms_statCode));                           //  37 Status Code

      // Use the status code to switch on what is encoded
      if(!isDigital(ms_statCode)) ms_statCode = "0";
      
      switch (Integer.parseInt(ms_statCode))
      {
        case 14 :   // Undeliverable Shipment
//        m_cosmosMasterGrp.setReturnAirbillNumber(new IA5String(state.getScan().getReturnAirbill())); // 603 ReturnAirbill
//        if (state.getScan().getAuthorizedBy().length() > 30)
//        {
//          m_cosmosMasterGrp.setAuthorizedBy(new IA5String(state.getScan().getAuthorizedBy().substring(1,31)));
//        }
//        else
//        {
//          m_cosmosMasterGrp.setAuthorizedBy(new IA5String(state.getScan().getAuthorizedBy()));         // 604 Authorized By
//        }
          break;

        case 20 :   // Dangerous Good Unacceptable
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;

        case 37 :   // Observed Package Damage
          m_cosmosMasterGrp.setConditionOfPackage(new IA5String(state.getScan().getPkgCondition()));   //  53 Package Condition
          break;

        case 50 :   // Improper International Paperwork
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;

        case 68 :   // In Country Transit  (Requires URSA)
          m_cosmosMasterGrp.setPackageRoutedFlag(new IA5String(state.getScan().getPkgRouted()));       // 277 Package Routed set to 'N'
          setScanComment(state.getCurrentScan().getCommentDescription());
          m_cosmosMasterGrp.setTypeService(new IA5String(state.getScan().getServiceCode()));           //  42 Service Code, 2 characters numeric

//          System.out.println("Handling Codes " + state.getScan().getHandlingCodes());

          // Set the Handling Codes, there can be more than 1, but we have it in 1 string
          CosmosMasterGrp.HandlingCodes handlingCodes = new CosmosMasterGrp.HandlingCodes();
          int i_numHandling = state.getScan().getHandlingCodes().length() / 2;
          for (int i=0, j=0; i<i_numHandling; i++)
          {
            ms_handlingCode = state.getScan().getHandlingCodes().substring(j, j+2); 
            handlingCodes.add(new IA5String(ms_handlingCode));
            j += 2;
          }
          m_cosmosMasterGrp.setHandlingCodes(handlingCodes);                                           //  16 Handling Codes

          m_cosmosMasterGrp.setHalPostalCode(new IA5String(state.getScan().getHalPostal()));           //  17 Hold at Location Postal Code
          m_cosmosMasterGrp.setDestinationPostalCd(new IA5String(state.getScan().getDestPostal()));    //  12 Destination Postal Code
          m_cosmosMasterGrp.setUrsaRoutingId(new IA5String(state.getScan().getRoutingId()));           //  43 Routing Id from URSA
          m_cosmosMasterGrp.setDeliveryTypeCode(new IA5String(state.getScan().getDelCommit()));        //   6 Service Area Committment from URSA
          m_cosmosMasterGrp.setDestinationCountry(new IA5String(state.getScan().getDestCountry()));    //  98 Destination Country
          break;

        case 69 :  // Batch received at Imaging Loc
          m_cosmosMasterGrp.setAstrayFlag(new IA5String(state.getScan().getAstray()));                 // 188 Astray Indicator, set to 'Y'
          break;

        case 77 :  // International Transit Out
          m_cosmosMasterGrp.setConveyanceRouteNbr(new IA5String(state.getScan().getMdeRoute()));       // 186 Conveyance Route Nbr
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;

        case 85 :  // Mechanical Delay
          m_cosmosMasterGrp.setFlightNumber(new IA5String(state.getScan().getFlightNumber()));         // 125 Flight Number
          m_cosmosMasterGrp.setFlightDate(new IA5String(state.getScan().getFlightDate()));             // 310 Flight Date
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;

        case 90 :  // Customs Paperwork Outbound
          m_cosmosMasterGrp.setFlightNumber(new IA5String(state.getScan().getFlightNumber()));         // 125 Flight Number
          m_cosmosMasterGrp.setFlightDate(new IA5String(state.getScan().getFlightDate()));             // 310 Flight Date
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;

        default :  // All other Status Codes (Must be entered into the SCAN_DEF table to be recognized) 
                   // 15, 18, 19, 20, 21, 22, 27, 29, 31, 32, 33, 34, 36, 37, 41, 42, 44, 45, 48, 50, 51, 
                   // 52, 53, 55, 56, 57, 58, 60, 61, 62, 63, 64, 65, 66, 67, 70, 71, 72, 73, 74, 75, 76, 
                   // 78, 80, 84, 85, 88, 89, 91
          setScanComment(state.getCurrentScan().getCommentDescription());
          break;
       }
      setScanComment(state.getScan().getComments());
    }

    // this paragraph for the CONS Scan
    if (ms_scanTypeCode.equals("CONS"))
    {
      setComment(state.getCurrentScan().getCommentDescription());
      if(state.getScan().getConsFormType().equals("0503")) {
          setComment("BAG CONS."+" SPLIT#:"+ state.getScan().getSplitNumber());
      } else if(state.getScan().getConsFormType().equals("0501")) {
          setComment("ULD#:"+state.getScan().getContainerId()+" SPLIT#:"+ state.getScan().getSplitNumber());
      }
      
      m_cosmosMasterGrp.setScanType(new IA5String("12"));                                       //  41 CONS scan is type 12
      if (state.getScan().getUserLogon().length() > 6)
      {
        m_cosmosMasterGrp.setEmployeeNumber(new IA5String(state.getScan().getUserLogon().substring(1,7)));
      }
      else
      {
        m_cosmosMasterGrp.setEmployeeNumber(new IA5String(state.getScan().getUserLogon()));       //  14 UserLogon (used instead of 613)
      }
      m_cosmosMasterGrp.setScanningLocation(new IA5String(upload.getCosmosLocCode()));          // 291 Scanning Location (used instead of 612)
      m_cosmosMasterGrp.setConsTypeCode(new IA5String("3"));          // 223 Cons Type Code
//      m_cosmosMasterGrp.setConsTypeCode(new IA5String(state.getScan().getConsType()));          // 223 Cons Type Code
      m_cosmosMasterGrp.setConsNbr(new IA5String(state.getScan().getConsId()));                 // 150 Cons Number
      m_cosmosMasterGrp.setAirbillFormCode(new IA5String(state.getScan().getConsFormType()));   // 212 Form Type used for Cons

//    m_cosmosMasterGrp.setFreightCheckedflag(new IA5String(state.getScan().getFreightChk()));  // 184 Freight Checked
//    m_cosmosMasterGrp.setMiniSortFlag(new IA5String(state.getScan().getMiniSortFlg()));       // 268 Mini Sort Flag
//      m_cosmosMasterGrp.setFreightCheckedFlag(new IA5String("N"));                              // 184 Freight Checked
//      m_cosmosMasterGrp.setMiniSortFlag(new IA5String("N"));                                    // 268 Mini Sort Flag

      m_cosmosMasterGrp.setConsDestination(new IA5String(state.getScan().getConsDestLoc()));    // 631 Cons Destination
//      setComment(state.getCurrentScan().getCommentDescription());
      m_cosmosMasterGrp.setContainerIndicator(new IA5String(state.getScan().getContainerInd())); // 222 Container Indicator
//      m_cosmosMasterGrp.setDestinationCountry(new IA5String(state.getScan().getDestCountry())); //  98 Destination Country
//      m_cosmosMasterGrp.setConveyanceRouteNbr(new IA5String(state.getScan().getMdeRoute()));    // 186 Conveyance Route Nbr
//      m_cosmosMasterGrp.setFlightNumber(new IA5String(state.getScan().getContainerId()));       // 125 Container Id
//      m_cosmosMasterGrp.setContainerId(new IA5String(state.getScan().getContainerId()));
      
      ms_containerInd = state.getScan().getContainerInd();
      // If Cons Container has a Flight Number, save that also
      if (ms_containerInd.equals("V") ||       // CTV
          ms_containerInd.equals("F") ||       // Flight
          ms_containerInd.equals("D") ||       // Feeder
          ms_containerInd.equals("S") ||       // Shuttle
          ms_containerInd.equals("K") )        // Bulk
      {
        m_cosmosMasterGrp.setFlightNumber(new IA5String(state.getScan().getFlightNumber()));         // 125 Flight Number

     }

      // Build the Airbills belonging to the CONS
      for (int i=0; i<1; i++)      // There is only 1 airbill in this group
      {
        cosmosTrackingNumberGrp.setTrackingNbr(new IA5String(state.getScan().getAirbillNumber())); // 215,0 Airbill Number
        cosmosTrackingNumberGrp.setTypeCd(new IA5String(state.getScan().getAirbillType()));        // 215,1 Airbill Type
        cosmosTrackingNumberGrp.setFormCd(new IA5String(state.getScan().getAirbillFormType()));    // 215,2 Airbill Form Type
        cosmosTrackingNumberGrp.setAstraLabelScannedFlg(new IA5String("3"));//new IA5String(state.getScan().getAirbillEntry()));// 215,3 Airbill Entry, Scan, Manual, ASTRA
        cosmosTrackingNumberGrp.setTrackingItemTime(new IA5String(ms_hourMinute));                 // 215,4 Airbill Entry Time
        if(state.getScan().getAstraData().length()>16)
        	cosmosTrackingNumberGrp.setAstraLabelData(new IA5String(state.getScan().getAstraData().substring(0,16)));  // 741 ASTRA data, first 16 characters

        assocTrackingNumber.add(cosmosTrackingNumberGrp);
      }
      m_cosmosMasterGrp.setAssocTrackingNumber(assocTrackingNumber);
    }

    if (ms_scanTypeCode.equals("DCON"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("14"));                                       //  41 DCON scan is type 14
      m_cosmosMasterGrp.setConsNbr(new IA5String(state.getScan().getConsId()));                 // 150 Cons Number
      m_cosmosMasterGrp.setAirbillFormCode(new IA5String(state.getScan().getConsFormType()));   // 212 Form Type used for Cons
      // Build the Airbills belonging to the DCON
      for (int i=0; i<1; i++)      // There is only 1 airbill in this group
      {
        cosmosTrackingNumberGrp.setTrackingNbr(new IA5String(state.getScan().getAirbillNumber())); // 215,0 Airbill Number
        cosmosTrackingNumberGrp.setTypeCd(new IA5String(state.getScan().getAirbillType()));        // 215,1 Airbill Type
        cosmosTrackingNumberGrp.setFormCd(new IA5String(state.getScan().getAirbillFormType()));    // 215,2 Airbill Form Type
        cosmosTrackingNumberGrp.setAstraLabelScannedFlg(new IA5String(state.getScan().getAirbillEntry())); // 215,3 Airbill Entry
        cosmosTrackingNumberGrp.setTrackingItemTime(new IA5String(ms_hourMinute));                 // 215,4 Airbill Entry Time
        cosmosTrackingNumberGrp.setDconDate(new IA5String(ms_monthDay));                           // 215,5 DCons Date
        cosmosTrackingNumberGrp.setDconTime(new IA5String(ms_hourMinute));                         // 215,6 DCons Time
        if(state.getScan().getAstraData().length()>16)
	        cosmosTrackingNumberGrp.setAstraLabelData(new IA5String(state.getScan().getAstraData().substring(0,16)));  // 741 ASTRA data, first 16 characters
        assocTrackingNumber.add(cosmosTrackingNumberGrp);
      }
      m_cosmosMasterGrp.setAssocTrackingNumber(assocTrackingNumber);
    }

    if (ms_scanTypeCode.equals("CMT"))
    {
      m_cosmosMasterGrp.setScanType(new IA5String("90"));                                       //  41 CMT scan is type 90
      //setComment(state.getCurrentScan().getCommentDescription());
      setComment(state.getScan().getComments());
//      m_cosmosMasterGrp.setQualMark(new IA5String("Q"));                                        // 279 Qual Mark
//    m_cosmosMasterGrp.setComment23(new IA5String(new IA5String(state.getScan().getComment23())); // 356 'P' or 'F' if airbill was 023
    }

    // Encode the message into ASN format
    try
    {
      Coder coder = Cciicosmos.getBERCoder();
      coder.enableAutomaticEncoding();
      coder.disableEncoderDebugging();
      coder.disableEncoderConstraints();
      ByteArrayOutputStream aSink = new ByteArrayOutputStream();
      coder.encode(m_cosmosMasterGrp, aSink);
      m_outboundEncodedMsg = aSink.toByteArray();
    }
    catch (EncodeFailedException efe)
    {
      System.out.println(efe.getLocalizedMessage());
      System.out.println(efe.getReason());
      System.out.println(efe.getMessage());
    }
    super.createMessage( state, dbConnection, upload);

  }
  public void setScanComment(String comment)
  {
      if (comment.length() > 30)
      {
         m_cosmosMasterGrp.setScanComment(new IA5String(comment.substring(1,31)));
      }
      else
      {
         m_cosmosMasterGrp.setScanComment(new IA5String(comment)); 
	 //  62 Scan Comments
     }
  }
  public void setComment(String comment)
  {
      if (comment.length() > 30)
      {
         m_cosmosMasterGrp.setComments(new IA5String(comment.substring(1,31)));
      }
      else
      {
         m_cosmosMasterGrp.setComments(new IA5String(comment)); 
	 //  62 Scan Comments
      }
  }

  private boolean isDigital(String ss)
  {
		if (ss.length()<=0) return false;
		String value=ss.trim();
		char c;
		for(int i=0; i<value.length(); i++)
		{
	    	    c=value.charAt(i);
		    if( (c<'0' || c>'9') &&(c!='-') )
		        return false;
		}
		return true;
  }
  
  public static void main(String[] args)
  {
     System.out.println("ASNEncode in main");

     System.out.println("Leaving main");
  }

}
