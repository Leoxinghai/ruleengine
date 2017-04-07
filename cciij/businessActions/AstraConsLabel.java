//*************************************************************************
//
// Filename: AstraLabel.java
//
// Description:  ASTRA Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /cvs/fedexccii/src/cciij/businessActions/AstraConsLabel.java,v $
//      $Revision: 1.2 $
//      $Date: 2006/09/05 10:09:25 $
//
// Modification History:
//
//   04/06/04  Gary Rockwood   Initial creation
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import java.math.*;
import java.util.*;
import java.sql.Timestamp;
import java.text.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;


public class AstraConsLabel extends FileBasedLabel
{
    protected    Java2uvsdkInterface uvsdk = null;
    protected    ConsSummary consSummary = null;
    protected    int UrsaEditLoaded = 0;
    protected    int mi_readFrequency = 0;
    protected    int mi_currentUseCount = -1;
    protected    String s_problemMessage1 = "";
    protected    String s_problemMessage2 = "";
    protected    String s_problemMessage3 = "";
//    protected    SimpleDateFormat ursaFormat = new SimpleDateFormat("yyyyMMdd");
//    protected    SimpleDateFormat currTime = new SimpleDateFormat("HHmm");
    protected    Date s_convertDt = null;
    protected    String s_dateString = "";
    protected    String s_shipTimeStart = "";
    protected    Boolean l_readFormatFile;
    protected    String s_locationCd = "";
    protected    String ConsContainerInd = "";
    protected    String ConsContainerId = "";
    protected    String s_formCode = "";
    protected    String s_routingOrigin = "";
    protected    String PostalCode = "";
    protected    String DestinationCountry = "";
    protected    String DestinationState = "";
    protected    String DestinationLoc = "";
    protected    String s_serviceCode = "";
    protected    String s_serviceLine = "";
    protected    String s_handlingCodes = "";
    protected    String s_satDelFlg = "";
    protected    String s_halLocFlg = "";
    protected    String s_intransitCd = "";
    protected    String s_astraLine1 = "";
    protected    String s_astraLine2 = "";
    protected    Shipment shipment = null;
    protected    Split split = null;
    protected    ContractBroker contractBroker = null;
    protected    Party party = null;
    protected    int LabelProblem = 0;
    protected    int ServiceCode = 0;
    protected    int i_handlingCodes[] = {0,0,0,0,0,0,0,0};    // max of 8 Handling Codes
    protected    int i_status = 0;
    protected    int i_noShipment = 0;
    protected    Boolean l_sendFormat;
    protected    String s_labelName = "";

    // Based on some Services and Handling Codes, the logic will change
    protected    int i_ipdService = 0;
    protected    int i_bsoPresent = 0;
    protected    int i_apptDelivery = 0;
    protected    int i_wkdDelivery = 0;
    protected    int i_satDelivery = 0;
    protected    int i_halDelivery = 0;
    protected    int i_handlingCount = 0;
    protected    int i_intransitYes = 0;

    // Split processing information
    protected    byte[]  m_splitFormat = new byte[300];
    protected    int i_fileLength = 0;
    protected    int MAX_SUFFIX_PER_LINE = 9;
    protected    int SAT_DEL = 3;
    protected    int WKD_DEL = 2;
    protected    int ADG = 14;
    protected    int IDG = 4;
    protected    int ICE = 6;
    
    private static final String m_whatVersion = "@(#) $RCSfile: AstraConsLabel.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

    //    LabelDefinitionInterface m_definition;
    public AstraConsLabel(String as_LabelName) throws Exception
    {
        super(as_LabelName);

//        System.out.println("AstraLabel init started");
        s_labelName = as_LabelName;

        uvsdk = Java2uvsdkFactory.getJava2uvsdk();

        // Initialize the variable indicating Ursa and Edit loaded
        UrsaEditLoaded = 0;

        synchronized(uvsdk)
        {
            // Load the Ursa and Edit Files
            if (uvsdk.LoadUrsaEditFiles() == 0)
            {
                // Ursa and Edit loaded successfully
                UrsaEditLoaded = 1;
            }
            else
            { 
                // Problem loading Ursa or Edit files
                UrsaEditLoaded = 2;
            }
        }

        int li_formatNumber;
        String ls_formatNumber;
   
        try
        {
            if ((ls_formatNumber = m_config.getValue("LABEL_DEFINITION_FORMAT_NUMBER")) == null)
            {
                li_formatNumber = 0;
                throw new Exception("null value");
            }
            else
            {
                li_formatNumber = Integer.parseInt(ls_formatNumber);
            }
        }
        catch(Throwable e)
        {
            throw new LabelPrintException("Failed to retrieve LABEL_DEFINITION_FORMAT_NUMBER from the config file for: "
                                          + as_LabelName + ":  " + e);
        }

        try
        {
            FileBasedLabelDefinition.addSupportedLabelFormats(m_definitions, m_config, li_formatNumber);
        }
        catch(Throwable e)
        {
            throw new LabelPrintException("Failed to create the label Definition Object for: " + as_LabelName + ": " + e);
        }

        try
        {
            mi_readFrequency = Integer.parseInt(m_config.getValue("LABEL_DEFINITION_READ_FREQUENCY"));
        }
        catch(Throwable e)
        {
            // This is not a critical error, here we will just default it to 0
            mi_readFrequency = 0;
        }
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    protected LabelData getLabelData(CCIIState a_data)
    {

        // Use the specific location as primary parameter
        m_config.setLocationCode(a_data.getScan().getLocationCode());
        s_routingOrigin = m_config.getValue("URSA_ROUTING_ORIGIN");
//        System.out.println("Primary location code for routing will be " + s_routingOrigin);

        i_labelCount = 1;
        // Set up the area to put Print Label information
        Map l_printData = a_data.m_printData;

        s_locationCd = a_data.getScan().getLocationCode();

        l_readFormatFile = (Boolean)a_data.m_printData.get("READ_FORMAT");

        boolean compareResult = false;
        compareResult = ((l_readFormatFile != null) && (l_readFormatFile.booleanValue() == false));
        compareResult = compareResult || ((mi_currentUseCount >= mi_readFrequency)
                && (mi_readFrequency >= 0)); 
        if (((l_readFormatFile != null) && (l_readFormatFile.booleanValue() == false))
            || ((mi_currentUseCount >= mi_readFrequency)
            && (mi_readFrequency >= 0)))
        {
            m_definitions.resetLabelFormat();
            mi_currentUseCount = 0;

            // Since we are re-reading the input file, we need to download the format as well
            //      a_data.m_printData.put("SEND_LABEL",new Boolean(true));
            //a_data.m_printData.put("SEND_FORMAT",new Boolean(true));
            
//            return null;
        }
        else
        {
            mi_currentUseCount++;
        }

        // Only attempt to gather data for the label if SEND_FORMAT is false
        //a_data.m_printData.put("SEND_FORMAT",new Boolean(true));

        l_sendFormat = (Boolean)l_printData.get("SEND_FORMAT");

        // Build all variables that do not need URSA or ASTRA outside of the synchronized paragraph
        InitializeVariables();

        // Get the Ship Date and use for Today and the Ship Date 

        // Get the User number and the actual scan date and time
        l_printData.put("ASTRAEmpDate", "Emp# " + a_data.getScan().getUserLogon() + " " +
                        (String)l_printData.get("DATE") + " " + (String)l_printData.get("TIME"));
        l_printData.put("ASTRAEmp", "Emp# " + a_data.getScan().getUserLogon());
        l_printData.put("ASTRADate", (String)l_printData.get("DATE") + " " + (String)l_printData.get("TIME"));

        l_printData.put("ASTRAProblem1", "");
        l_printData.put("ASTRAProblem2", "");
        l_printData.put("ASTRAProblem3", "");

        l_printData.put("ASTRAOrig", s_locationCd);

        // If this is a CONS there is no Shipment data
        if ((a_data.getScan().getConsId().length() > 0) &&
            (s_labelName.equals("AstraConsLabel")))
        {
            // CONS Astra Label requested, get CONS info
            if (ProcessCONS(a_data) == false)
            {
                return null;
            }
        }
        else
        {
            // Read the Shipment record for this package
            ReadShipment(a_data);

            if (LabelProblem == 0)
            {
                // Get Service and Handling info from Shipment record
                ProcessServiceHandling(a_data);
  
                // Set Destination for URSA routing purposes
                SetDestinationInfo(a_data);

                // Set the Postal Display for ASTRA label
                FormatPostalForAstra(a_data);

                // Set State Country Display for ASTRA label
                FormatStateCountryForAstra(a_data);

                // Set Trk# or MPS# or MASTER# for ASTRA label
                FormatTrkNumbersForAstra(a_data);
            }
        }    

        // Build the ASTRA top line info
        FormatAstraText(a_data);

        ModifyShipDate(a_data);

        // Add Customs Cleared to Handling Codes
        //   but only if BSO is not present and it is not an Intransit package
        //   or this is NOT a CONS label
        if (a_data.getScan().getConsId().equals(""))
        {
            if ((i_bsoPresent == 0) &&
                (i_intransitYes == 0))
            {
                i_handlingCodes[i_handlingCount] = 7;
                i_handlingCount++;
            }
        }

        // Check if Ursa and Edit loaded correctly
        if (UrsaEditLoaded == 1)
        {
            try
            {
            synchronized(uvsdk)
            {
                // Initialize the Context areas of Ursa and Edit
                uvsdk.UEInitialize();

                // Based on the Date information just computed set the ship date and todays date
                uvsdk.SetTodaysDate(s_dateString);
                uvsdk.SetShipDate(s_dateString);

                // Set the Ursa Routing Origin station
                uvsdk.SetOriginStation(s_routingOrigin);

                // Set the Airbill and Form Code into the barcode area
                if ((l_sendFormat != null) && (l_sendFormat.booleanValue() == true))
                {
                    // Do not perform the CheckAirbill or GetABFormCode
                }
                else
                {
                    if ((a_data.getScan().getConsId().length() > 0) &&
                        (s_labelName.equals("AstraConsLabel")))
                    {
                        if (a_data.getAbScanned().length() == 12)
                        {
                            // Its an NTN, append the form Code
                            String s_stripedAirbill = uvsdk.CheckAirbill(consSummary.getConsNumber() +
                                                                         consSummary.getConsFormTypeCode());
                        }
                        else
                        {
                            // Not an NTN, just send the Cons Id
                            String s_stripedAirbill = uvsdk.CheckAirbill(consSummary.getConsNumber());
                            s_formCode = consSummary.getConsFormTypeCode();
                        }
                    }
                    else
                    {
                        if (a_data.getScan().getAirbillNumber().length() == 12)
                        {
                            // Its an NTN, append the form Code
                            String s_stripedAirbill = uvsdk.CheckAirbill(a_data.getScan().getAirbillNumber() + 
                                                                         a_data.getScan().getAirbillFormType());
                        }
                        else
                        {
                            // Not an NTN, just send the airbill
                            String s_stripedAirbill = uvsdk.CheckAirbill(a_data.getScan().getAirbillNumber());
                            // Get the correct form code back for later use
                            s_formCode = uvsdk.GetABFormCode();
                        }
                    }
                }

                // Set the destination country and postal info into the URSA Context
                FormatDestinationForAstra(a_data);

                if (LabelProblem == 0)
                {
                    // Set the Service code (numeric value)
                    uvsdk.SetServiceCode(ServiceCode);
                	//uvsdk.SetServiceCode(1);
                }

                // Set the Handling Codes string for Astra
                FormatHandlingForAstra(a_data);

                // Save the previously generated astraLine's into position
                if (m_config.getValue("ASTRA_TEXT_FROM_EDIT_FILE").equals("N"))
                {
                    l_printData.put("ASTRAText", s_astraLine1);
                }
                else
                {
                    if (LabelProblem == 0)
                    {
                        l_printData.put("ASTRAText", uvsdk.GetAstraLine1());
                    }
                    else
                    {
                        // Make sure there is a shipment record first
                        if (i_noShipment == 0)
                        {
                            // Label problem, service not set, make a line
                            l_printData.put("ASTRAText", s_serviceCode.toUpperCase() + " SERVICE");
                        }
                        else
                        {
                            l_printData.put("ASTRAText", "UNKNOWN SERVICE");
                        }
                    } 
                }
                
                // Line 2 has been set previously
                l_printData.put("ASTRAWeekend", s_astraLine2);
 
                if (LabelProblem == 0)
                {
                    // Set the Airbill and Form Code into the barcode area
                    if ((a_data.getScan().getConsId().length() > 0) &&
                        (s_labelName.equals("AstraConsLabel")))
                    {
                        if (a_data.getAbScanned().length() == 12)
                        {
                            // Its an NTN, append the form Code
                            uvsdk.SetAirbillAndFormCode(consSummary.getConsNumber(),
                                                        consSummary.getConsFormTypeCode());
                        }
                        else
                        {
                            // Not an NTN, just send the Cons Id
                            uvsdk.SetAirbillAndFormCode(consSummary.getConsNumber(),
                                                        s_formCode);
                        }
                    }
                    else
                    {
                        if (a_data.getScan().getAirbillNumber().length() == 12)
                        {
                            // Its an NTN, append the form Code
                            uvsdk.SetAirbillAndFormCode(a_data.getScan().getAirbillNumber(),
                                                        a_data.getScan().getAirbillFormType());
                        }
                        else
                        {
                            // Not an NTN, just send the airbill
                            uvsdk.SetAirbillAndFormCode(a_data.getScan().getAirbillNumber(),
                                                        s_formCode);
                        }
                    }

                    // Everything has been set up, now do the routing and commit calculation
                    uvsdk.RouteUrsa();
                    uvsdk.CommitUrsa();

                    // Pull information for the ASTRA label
                    l_printData.put("ASTRACommit", uvsdk.GetServiceAreaCode());
//                    System.out.println("ServiceAreaCode " + uvsdk.GetServiceAreaCode());

                    l_printData.put("ASTRAAirport", uvsdk.GetDestinationAirport());
//                    System.out.println("DestinationAirport " + uvsdk.GetDestinationAirport());
 
                    l_printData.put("ASTRAUrsaPrefix", uvsdk.GetRoutingPrefix());
//                    System.out.println("RoutingPrefix " + uvsdk.GetRoutingPrefix());

                    l_printData.put("ASTRAUrsaSuffix", uvsdk.GetRoutingSuffix());
                    l_printData.put("ASTRADest", uvsdk.GetRoutingSuffix().substring(0,3));
//                    System.out.println("RoutingSuffix " + uvsdk.GetRoutingSuffix());

                    l_printData.put("ASTRABarcode", uvsdk.GetAstraBarcode());
//                    System.out.println("AstraBarcode " + uvsdk.GetAstraBarcode());
  
                    // Format the Delivery Commitment infor for Astra
                    FormatCommitmentForAstra(a_data);
                }
            }
            }
            catch(Java2uvsdkException e)
            {
                System.out.println("Error from UVSDK:  " + e);
                e.printStackTrace(System.out);
                SetProblemMessage("URSA or EDIT error, no URSA routing");
            }
        }
        else
        {
            // Ursa or Edit failed to load
            SetProblemMessage("URSA or EDIT file failed to load, no URSA routing");
        }
   
        // Check if Label Problems need to be placed on Label
        if (LabelProblem == 1)
        {
//            System.out.println("There is a Label Problem");
            // Label Problem
            if (s_problemMessage1.length() > 0)
            {
                l_printData.put("ASTRAProblem1", s_problemMessage1);
                if (s_problemMessage2.length() > 0)
                {
                    l_printData.put("ASTRAProblem2", s_problemMessage2);
                    if (s_problemMessage3.length() > 0)
                    {
                        l_printData.put("ASTRAProblem3", s_problemMessage3);
                    }
                }
            }
        }
        //return a_data.
        return null;
    }


    protected void InitializeVariables()
    {
        s_problemMessage1 = "";
        s_problemMessage2 = "";
        s_problemMessage3 = "";
        s_convertDt = null;
//        s_dateTime = "";
        s_dateString = "";
        s_shipTimeStart = "";
        ConsContainerInd = "";
        ConsContainerId = "";
        s_formCode = "";
        PostalCode = "";
        DestinationCountry = "";
        DestinationState = "";
        DestinationLoc = "";
        s_serviceCode = "";
        s_serviceLine = "";
        s_handlingCodes = "";
        s_satDelFlg = "";
        s_halLocFlg = "";
        s_intransitCd = "";
        s_astraLine1 = "";
        s_astraLine2 = "";
        shipment = null;
        contractBroker = null;
        party = null;
        LabelProblem = 0;
        ServiceCode = 0;
        for (int i_loop=0; i_loop<8; i_loop++)
        {
            i_handlingCodes[i_loop] = 0;    
        }
        i_status = 0;
        i_noShipment = 0;
        i_ipdService = 0;
        i_bsoPresent = 0;
        i_apptDelivery = 0;
        i_wkdDelivery = 0;
        i_satDelivery = 0;
        i_halDelivery = 0;
        i_handlingCount = 0;
    }


    protected void ReadShipment(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        if ((l_sendFormat != null) && (l_sendFormat.booleanValue() == true))
        {
            // This is in the SEND_FORMAT mode, set variables to dummy values
            i_noShipment = 1;
        }
        else
        {
            // Based on the Shipment Oid load the Shipment Table entry
            if (a_data.getScan().getShipmentOid() == 0)
            {
                a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ASTRA No Shipment Oid");

                System.out.println("Unable to read Shipment for Oid " + a_data.getScan().getShipmentOid());

                SetProblemMessage("Shipment Record not found for AWB " + a_data.getScan().getAirbillNumber());
                i_noShipment = 1;
            }
            else
            {
                // Need the shipment
                try
                {
                    shipment = m_db.fetchShipment(a_data.getScan().getShipmentOid());
                }
                catch (Exception ex)
                {
                    a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ASTRA Shipment fetch failed");

                    SetProblemMessage("Shipment Record fetch problem for ShipmentOid " + a_data.getScan().getShipmentOid());
                    i_noShipment = 1;
                    System.err.println("Caught an exception..." + ex);
                    ex.printStackTrace();
                }

                if ((shipment == null) && (LabelProblem == 0))
                {
                    a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                    CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","ASTRA Shipment not found");

                    SetProblemMessage("Shipment Record fetch problem for ShipmentOid " + a_data.getScan().getShipmentOid());
                    i_noShipment = 1;
                }
                else
                {
                    // Shipment Record successfully read
                    // Extract the following: Service Code                shipment.getServiceCode()
                    //                        Piece Count                 shipment.getPieceQuantity()
                    //                        Handling Codes              shipment.getSpecialHandling1Cd()
                    //                                                    shipment.getSpecialHandling2Cd()
                    //                                                    shipment.getSpecialHandling3Cd()
                    //                                                    shipment.getSpecialHandling4Cd()
                    //                                                    shipment.getSpecialHandling5Cd()
                    //                        Destination Postal Code     shipment.getConsigneePostalCode()
                    //                        Destination State Code      shipment.getConsigneeStateCode()
                    //                        Destination Country Code    shipment.getConsigneeCountryCode()
                    //                        Destination Location Code   shipment.getDestinationLocCode()
                    //                        Saturday Delivery Flag      shipment.getSaturdayDeliveryFlag()
                    //                        Hold at Location Flag       shipment.getHoldAtLocationFlag()
                    //                        Intransit                   shipment.getIntransitCd()
                    //                        Tracking Number             a_data.getScan().getAirbillNumber()
                    //                        Tracking Number Form Code   a_data.getScan().getAirbillFormType()
                    //

                    // Test and debug code
//                    System.out.println("Service Code       : " + shipment.getServiceCode());
                    s_serviceCode = shipment.getServiceCode();

//                    System.out.println("Piece Quantity     : " + shipment.getPieceQuanity());
                    // PieceQuanity retrieved from l_printData

//                    System.out.println("Handling Code 1    : " + shipment.getSpecialHandling1Cd());
//                    System.out.println("Handling Code 2    : " + shipment.getSpecialHandling2Cd());
//                    System.out.println("Handling Code 3    : " + shipment.getSpecialHandling3Cd());
//                    System.out.println("Handling Code 4    : " + shipment.getSpecialHandling4Cd());
//                    System.out.println("Handling Code 5    : " + shipment.getSpecialHandling5Cd());
                    // Convert the Handling Codes to integers and save in the i_handlingCodes array
                    if ((shipment.getSpecialHandling1Cd() != null) && 
                        (shipment.getSpecialHandling1Cd().length() > 0))
                    {
                        i_handlingCodes[0] = Integer.parseInt(shipment.getSpecialHandling1Cd());
                    }
                    if ((shipment.getSpecialHandling2Cd() != null) && 
                        (shipment.getSpecialHandling2Cd().length() > 0))
                    {
                        i_handlingCodes[1] = Integer.parseInt(shipment.getSpecialHandling2Cd());
                    }
                    if ((shipment.getSpecialHandling3Cd() != null) && 
                        (shipment.getSpecialHandling3Cd().length() > 0))
                    {
                        i_handlingCodes[2] = Integer.parseInt(shipment.getSpecialHandling3Cd());
                    }
                    if ((shipment.getSpecialHandling4Cd() != null) && 
                        (shipment.getSpecialHandling4Cd().length() > 0))
                    {
                        i_handlingCodes[3] = Integer.parseInt(shipment.getSpecialHandling4Cd());
                    }
                    if ((shipment.getSpecialHandling5Cd() != null) && 
                        (shipment.getSpecialHandling5Cd().length() > 0))
                    {
                        i_handlingCodes[4] = Integer.parseInt(shipment.getSpecialHandling5Cd());
                    }

//                    System.out.println("Postal Code        : " + shipment.getConsigneePostalCode());
//                    System.out.println("State              : " + shipment.getConsigneeStateCode());
//                    System.out.println("Country            : " + shipment.getConsigneeCountryCode());
//                    System.out.println("Destination Loc    : " + shipment.getDestinationLocCode());

//                    System.out.println("Saturday Del Flag  : " + shipment.getSaturdayDelFlg());
                    if ((shipment.getSaturdayDelFlg() != null) &&
                        (shipment.getSaturdayDelFlg().length() > 0))
                    {
                        s_satDelFlg = shipment.getSaturdayDelFlg();
                    }

//                    System.out.println("Hold at Loc Flag   : " + shipment.getHoldAtLocFlg());
                    if ((shipment.getHoldAtLocFlg() != null) &&
                        (shipment.getHoldAtLocFlg().length() > 0))
                    {
                        s_halLocFlg = shipment.getHoldAtLocFlg();
                    }

//                    System.out.println("Intransit Cd       : " + shipment.getIntransitCd());
                    if ((shipment.getIntransitCd() != null) &&
                        (shipment.getIntransitCd().length() > 0))
                    {
                        s_intransitCd = shipment.getIntransitCd();
                    }

//                    System.out.println("Airbill Number     : " + a_data.getScan().getAirbillNumber());
//                    System.out.println("Airbill Form Code  : " + a_data.getScan().getAirbillFormType());
                }
            }
        }
    }

    protected void ProcessServiceHandling(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        l_printData.put("ASTRASvc", "Svc:  " + s_serviceCode.toUpperCase());

        // For IPD shipments, indicate its IPD but route as Priority Overnight
        // The site_param table should do the actual conversion
        if ((s_serviceCode.toUpperCase().equals("ID")) ||
            (s_serviceCode.equals("18")))
        {
            i_ipdService = 1;
        }

        // Convert the ServiceCode in the Shipment Record to its numeric value
        // and get the lines for the ASTRA label
        if (m_config.getValue("SERVICE_CODE_" + s_serviceCode.toUpperCase()) != null)
        {
            s_serviceLine = m_config.getValue("SERVICE_CODE_" + s_serviceCode.toUpperCase());
        }
        else
        {
            // Use the Default of Priority Overnight
            s_serviceLine = "11";//m_config.getValue("11 INTL PRIORITY CLEARED");
        }

        ServiceCode = Integer.parseInt(s_serviceLine.substring(0,2));

        // In the event that the site_param table converts to IPD, indicate that condition
        if (ServiceCode == 18)    // 18 = IPD Service
        {
            i_ipdService = 1;
        }

        // Set any logic tests based on Handling Codes
        for (int i_loop=0; i_loop<5; i_loop++)
        {
            if (i_handlingCodes[i_loop] == 2)   i_wkdDelivery = 1;       // Weekday delivery specified
            if (i_handlingCodes[i_loop] == 40)  i_bsoPresent = 1;        // For BSO use ContractBroker for destination info
            if (i_handlingCodes[i_loop] == 17)  i_apptDelivery = 1;      // Modify 2nd line '** APPT DEL **' (NOT USED)
            if (i_handlingCodes[i_loop] == 3)   i_satDelivery = 1;       // Used to Determine if Sat Delivery is in handling codes
            if (i_handlingCodes[i_loop] == 1)   i_halDelivery = 1;       // Used to Determine if Hold At Loc is in handling codes
            if (i_handlingCodes[i_loop] != 0)   i_handlingCount ++;      // A count of handling codes
        }

        // Check the sdl_flg and hal_flg
        if (s_satDelFlg.equals("Y") &&
            (i_satDelivery == 0))
        {
//            System.out.println("Need to add Sat Del to Handling codes");
            // Saturday Delivery is not set in the Handling Codes list
            // Put it in the list but make it the first entry
            int i_loopMax = i_handlingCount;
            if (i_loopMax > 7)  i_loopMax = 7;
            for (int i_loop=i_loopMax; i_loop>0; i_loop--)
            {
                i_handlingCodes[i_loop] = i_handlingCodes[i_loop - 1];
            }
            i_handlingCodes[0] = 3;
            i_handlingCount++;
            i_satDelivery = 1;
        }

        if ((s_halLocFlg.equals("Y")) &&
            (i_halDelivery == 0))
        {
            // Hold At Location is not set in the HandlingCodes list
            // Put it in the list, but make it the first entry
            int i_loopMax = i_handlingCount;
            if (i_loopMax > 7)  i_loopMax = 7;
            for (int i_loop=i_loopMax; i_loop>0; i_loop--)
            {
                i_handlingCodes[i_loop] = i_handlingCodes[i_loop - 1];
            }
            i_handlingCodes[0] = 1;
            i_handlingCount++;
            i_halDelivery = 1;
        }

        // If Delivery is not specified, set to 2
        if ((i_satDelivery == 0) &&
            (i_halDelivery == 0) &&
            (i_wkdDelivery == 0))
        {
            // Set weekday Delivery in position 1
            int i_loopMax = i_handlingCount;
            if (i_loopMax > 7)  i_loopMax = 7;
            for (int i_loop=i_loopMax; i_loop>0; i_loop--)
            {
                i_handlingCodes[i_loop] = i_handlingCodes[i_loop - 1];
            }
            i_handlingCodes[0] = 2;
            i_handlingCount++;
            i_wkdDelivery = 1;
        }

        // Set the Intransit flag
        if (s_intransitCd.equals("N"))
        {
            i_intransitYes = 0;
        }
        else
        {
            i_intransitYes = 1;
        }
    }


    protected void SetDestinationInfo(CCIIState a_data)
    {
        // Set the ability to put information to the Print lable
        Map l_printData = a_data.m_printData;
        int  i_contractBrokerProblem = 0;
        int  i_partyProblem = 0;

        // Set the destination Country, State and Postal from Consignee
        //    if Handling Code 40 (BSO) 
        //    then 
        //        use Contract Broker information
        // 
        //    if ServiceCode = 18 (IPD) and 
        //    if NOT Intransit package 
        //    then 
        //        use Party information
        //    else
        //        use Consignee information
        //
        if (i_bsoPresent == 1)
        {
            // Use Broker as Destination location
            try
            {
                contractBroker = m_db.fetchContractBroker(a_data.getScan().getShipmentOid());
            }
            catch (Exception ex)
            {
                System.out.println("Unable to read ContractBroker record for ShipmentOid "
                                    + a_data.getScan().getShipmentOid());
                System.err.println("Caught an exception..." + ex);
                ex.printStackTrace();

                i_contractBrokerProblem = 1;
            }

            if ((contractBroker == null) && (i_contractBrokerProblem == 0))
            {
                System.out.println("Unable to find ContractBroker record for ShipmentOid "
                                    + a_data.getScan().getShipmentOid());
                i_contractBrokerProblem = 1;
            }

            // If there was a readProblem then set values to blank
            if (i_contractBrokerProblem == 1)
            {
                // Clear the Destination info
                PostalCode = "";
                DestinationCountry = "";
                DestinationState = "";
                DestinationLoc = "";

                SetProblemMessage("Contract Broker Info Missing");
            }
            else
            {
                // Use ContractBroker as Destination location
                PostalCode = contractBroker.getBrokerPostalCd();
                DestinationCountry = contractBroker.getBrokerCountryCd();
                DestinationState =  "";    // State code is not in ContractBroker table
                DestinationLoc = contractBroker.getBrokerDestLocCd();

                // Make sure there is valid data in the record
                if (PostalCode.equals("") || DestinationCountry.equals(""))
                {
                    if (DestinationLoc.equals(""))
                    {
                        SetProblemMessage("Contract Broker Info Missing");
                        i_contractBrokerProblem = 1;
                    }
                }
            }
        }
        else if ((i_ipdService == 1) &&
                 (i_intransitYes == 0))
        {
            // Use information from Party Table
            try
            {
                party = m_db.fetchParty(a_data.getScan().getHandlingUnitOid(), "P");
            }
            catch (Exception ex)
            {
                System.out.println("Unable to read Party record for HandlingUnitOid "
                                    + a_data.getScan().getHandlingUnitOid());
                System.err.println("Caught an exception..." + ex);
                ex.printStackTrace();

                i_partyProblem = 1;
            }

            if ((party == null) && (i_partyProblem == 0))
            {
                System.out.println("Unable to find Party record for HandlingUnitOid "
                                    + a_data.getScan().getHandlingUnitOid());
                i_partyProblem = 1;
            }

            // If there was a readProblem then set values to blank
            if (i_partyProblem == 1)
            {
                // Clear the Destination info
                PostalCode = "";
                DestinationCountry = "";
                DestinationState = "";
                DestinationLoc = "";

                SetProblemMessage("IPD Party Info Missing");
            }
            else
            {
                // Use Party as Destination location
                PostalCode = party.getPostalCd();
                DestinationCountry = party.getCountryCd();
                DestinationState = party.getStateCd();
                // There is no Destination Location in the Party table
                // If the information is needed, use the Consignee Destination
                DestinationLoc = shipment.getDestinationLocCode();

                // Make sure there is valid data in the record
                if (PostalCode.equals("") || DestinationCountry.equals(""))
                {
                    if (DestinationLoc.equals(""))
                    {
                        SetProblemMessage("IPD Party Info Missing");
                        i_partyProblem = 1;
                    }
                }


                // For IPD shipment that clear customs they are to be sent IP not IPD.
                // I got word that this is not true.   Only change to IP if the IPD service
                // is not valid at the routing location.   This is handeled in the 
                // Java2uvsdk.c native code.
                // ServiceCode == 11;
            }
        }
        else
        {
            if (i_noShipment == 0)
            {
                 // Use Consignee as Destination location
                PostalCode = shipment.getConsigneePostalCode();
                DestinationCountry = shipment.getConsigneeCountryCode();
                DestinationState = shipment.getConsigneeStateCode();
                DestinationLoc = shipment.getDestinationLocCode();
            }
        }
    }


    protected void FormatPostalForAstra(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        // Set the Postal Code
        if ((DestinationCountry == "US") &&
            (PostalCode.length() > 5))
        {
            l_printData.put("ASTRAPostal", PostalCode.substring(0,5));
        }
        else if (PostalCode.length() > 5)
        {
            l_printData.put("ASTRAPostal", PostalCode.substring(0,3) + " " +
                                           PostalCode.substring(3,PostalCode.length()));
        }
        else
        {
            l_printData.put("ASTRAPostal", PostalCode);
        }
    }


    protected void FormatStateCountryForAstra(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        // If both State and Country are present, display both
        // If Country is not present, display neither
        // If State is not present but Country is, display country
        if (DestinationCountry.length() > 0)
        {
            if (DestinationState.length() > 0)
            {
                l_printData.put("ASTRAStateCntry", "-" + DestinationState +
                                               "-" + DestinationCountry);
            }
            else
            {
               l_printData.put("ASTRAStateCntry", "-" + DestinationCountry);
            }
        }
        else
        {
            l_printData.put("ASTRAStateCntry", "");
        }
    }


    protected void FormatTrkNumbersForAstra(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        // Set the ASTRA airbill Number and the ASTRA Master info if present
        // Check if this is an MPS or a Master from and MPS
        if (a_data.getMPSFlag().equals("CRN"))
        {
            // This is an MPS airbill, get the Master info
            l_printData.put("ASTRATrkType", "MPS#:");

            if (l_printData.containsKey("AWB"))
            {
                l_printData.put("ASTRATrkNumber", (String)l_printData.get("AWB"));
            }
            if (l_printData.containsKey("AWBForm"))
            {
                l_printData.put("ASTRATrkForm", (String)l_printData.get("AWBForm"));
            }

            l_printData.put("ASTRAMasterInfo", "Mstr Trk#:" +
                                     (String)l_printData.get("HAWB") +
                                     " Pieces: " +
                                     (String)l_printData.get("PieceQuantity"));

            if (l_printData.containsKey("HAWB"))
            {
                l_printData.put("ASTRAOthNumber", (String)l_printData.get("HAWB"));
                l_printData.put("ASTRAOthType", "MSTR:");
            }
            if (l_printData.containsKey("HAWBForm"))
            {
                l_printData.put("ASTRAOthForm", (String)l_printData.get("HAWBForm"));
                l_printData.put("ASTRAOthFormConst", "Form");
            }

            l_printData.put("ASTRAPieces", "Pieces: " + (String)l_printData.get("PieceQuantity"));
        }
        else if (a_data.getMPSFlag().equals("MASTER"))
        {
            // This is a Master from an MPS shipment
            l_printData.put("ASTRATrkType", "MSTR:");

            if (l_printData.containsKey("HAWB"))
            {
                l_printData.put("ASTRATrkNumber", (String)l_printData.get("HAWB"));
            }
            if (l_printData.containsKey("HAWBForm"))
            {
                l_printData.put("ASTRATrkForm", (String)l_printData.get("HAWBForm"));
            }

            l_printData.put("ASTRAMasterInfo", "Master Trk #   Pieces: " +
                                     (String)l_printData.get("PieceQuantity"));
            l_printData.put("ASTRAOthType", "");
            l_printData.put("ASTRAOTHNumber", "");
            l_printData.put("ASTRAOthFormConst", "");
            l_printData.put("ASTRAOthForm", "");

            l_printData.put("ASTRAPieces", "Pieces: " + (String)l_printData.get("PieceQuantity"));
        }
        else
        {
            // Neither MPS or MASTER, build the info for a single ASTRA
            l_printData.put("ASTRATrkType", "TRK#:");

            if (l_printData.containsKey("HAWB"))
            {
                l_printData.put("ASTRATrkNumber", a_data.getScan().getAirbillNumber());
            }
            if (l_printData.containsKey("HAWBForm"))
            {
                l_printData.put("ASTRATrkForm", a_data.getScan().getAirbillFormType());
            }

            l_printData.put("ASTRAMasterInfo", "");
            l_printData.put("ASTRAOthType", "");
            l_printData.put("ASTRAOTHNumber", "");
            l_printData.put("ASTRAOthFormConst", "");
            l_printData.put("ASTRAOthForm", "");
            l_printData.put("ASTRAPieces", "");
        }
    }


    protected void FormatAstraText(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;

        if (m_config.getValue("ASTRA_TEXT_FROM_EDIT_FILE").equals("N"))
        {
            if (s_serviceLine.length() < 25)
            {
                s_astraLine1 = s_serviceLine.substring(3,s_serviceLine.length());
                s_astraLine2 = "";
            }
            else
            {
                s_astraLine1 = s_serviceLine.substring(3,24);
                if (s_serviceLine.length() < 47)
                {
                    s_astraLine2 = s_serviceLine.substring(25,s_serviceLine.length());
                }
                else
                {
                    s_astraLine2 = s_serviceLine.substring(24,46);
                }
            }
        }
    }


    protected void FormatDestinationForAstra(CCIIState a_data) throws Java2uvsdkException
    {
        // Create the link to put information to the Print Label area
        Map l_printData = a_data.m_printData;

        // NO Destination will cause ASTRA to not include the barcode
        if (DestinationCountry.length() > 0)
        {
            i_status = uvsdk.SetDestCountry(DestinationCountry);

            if (uvsdk.PostalCountry())
            {
                // Set the Postal Code
                if (PostalCode.length() > 0)
                {
                    if ((DestinationCountry == "US") &&
                        (PostalCode.length() > 5))
                    {
                        i_status = uvsdk.SetDestPostalCode(PostalCode.substring(0,5));
                    }
                    else
                    {
                        i_status = uvsdk.SetDestPostalCode(PostalCode);
                    }
                    if (i_status != 0)
                    {
                        // Postal Code is somehow invalid, lets try the destinationLoc
                        if (DestinationLoc.length() > 0)
                        {
                            i_status = 0;
                            i_status = uvsdk.SetDestStation(DestinationLoc);
                            if (i_status != 0)
                            {
                                // Problem also with Destination location
                                SetProblemMessage("Invalid Postal and Destination Loc");
                            }
                        }
                        else
                        {
                            SetProblemMessage("Invalid or Unknown Postal Code");
                        }
                    }
                }
                else
                {
                    // Postal missing, try the dest loc
                    if (DestinationLoc.length() > 0)
                    {
                        i_status = uvsdk.SetDestStation(DestinationLoc);
                        if (i_status != 0)
                        {
                            // Problem also with Destination location
                            SetProblemMessage("Invalid or Unknown Destination Location");
                        }
                    }
                    else
                    {
                        // Both Postal and Dest Loc are missing
                        SetProblemMessage("Postal and Destination Loc missing");
                    }
                }
            }   
            else
            {
                // Set the FedEx Dest Loc Code, Postals not supported
                if (DestinationLoc.length() > 0)
                {
                    i_status = uvsdk.SetDestStation(DestinationLoc);
                    if (i_status != 0)
                    {
                        // Problem with destination loc, postals not supported
                        SetProblemMessage("Invalid or Unknown Destination Loc");
                    }
                }
                else
                {
                    // Destination Loc missing, Postals not supported
                    SetProblemMessage("Distination Loc is missing");
                }
            }
        }
        else
        {
            if (a_data.getScan().getConsId().equals(""))
            {
                SetProblemMessage("No Destination Country");
            }
            else
            {
                // For the CONS all we have is the destination Fedex Location
                if (DestinationLoc.length() > 0)
                {
                    i_status = uvsdk.SetDestStation(DestinationLoc);
                    if (i_status != 0)
                    {
                        // Problem also with Destination location
                        SetProblemMessage("Invalid or Unknown Destination Location");
                    }
                }
            }
        }
    }


    protected void FormatHandlingForAstra(CCIIState a_data) throws Java2uvsdkException
    {
        Map l_printData = a_data.m_printData;

        // Set the Special Handling Codes, and build the Astra Handling String
        int i_firstSet = 0;

        for (int i_loop=0; i_loop<8; i_loop++)
        {
            // Only do this if there is an actual handling code
            if (i_handlingCodes[i_loop] != 0)
            {
                if (LabelProblem == 0)
                {
                    // Set the Handling Code in the Ursa Context
                    uvsdk.SetHandlingCode(i_handlingCodes[i_loop]);
                }

                String s_handlingCodeAbbr = uvsdk.GetHandlingText(i_handlingCodes[i_loop]);

                if (s_handlingCodeAbbr.length() > 0)
                {
                    if (i_firstSet == 0)
                    {
                        s_handlingCodes = s_handlingCodeAbbr;
                        i_firstSet = 1;
                    }
                    else
                    {
                        s_handlingCodes = s_handlingCodes + "-";
                        s_handlingCodes = s_handlingCodes + s_handlingCodeAbbr;
                    }
                }
            }
        }
        if (a_data.getScan().getConsId().equals(""))
        {
            // Do not modify s_handlingCodes
        }
        else
        {
            if (s_handlingCodes.length() == 0)
            {
                s_handlingCodes = "NO SPCL HNDLNG";
            }
        }
        l_printData.put("ASTRAHandling", s_handlingCodes);
    }


    protected void FormatCommitmentForAstra(CCIIState a_data) throws Java2uvsdkException
    {
        Map l_printData = a_data.m_printData;

        // Delivery Commitment will only be done if URSA_COMMIT = Y
        if (m_config.getValue("URSA_COMMIT").equals("Y"))
        {
            int i_startDate = Integer.parseInt(uvsdk.GetUrsaEffectiveDate("%Y%m%d"));
            int i_endDate = Integer.parseInt(uvsdk.GetUrsaExpirationDate("%Y%m%d"));
            int i_routeDate = Integer.parseInt(s_dateString);
//            System.out.println("Effective " + i_startDate + ", Expir " + i_endDate + ", Now " + i_routeDate);
            if ((i_routeDate > i_startDate) &&
                (i_routeDate <= i_endDate))
            {
                // Only put on label if Committment was Calculated
                if (uvsdk.CommitCalculated() == 0)
                {
                    l_printData.put("ASTRADelDay", uvsdk.GetDeliveryDayOfWeek());      // EEE
                    l_printData.put("ASTRADeliverBy", "Deliver By:");
                    l_printData.put("ASTRADeliverDate", uvsdk.GetDeliveryDate());      // ddMMMyy
                }
            }
        }
    }


    protected boolean ProcessCONS(CCIIState a_data)
    {
        // The Service Priority and Value were supplied by the UVSDK development group
        byte[] servicePriority = {  '6',  '1',  '5',  '7',  '3',  '8',  '2',  '9',  '4'};
        String[] serviceValue  = { "61", "11", "51", "70", "31", "80", "20", "83", "41"};

        Map l_printData = a_data.m_printData;
        boolean   b_moreSuffix = true;
        char[] s_working = new char[6];

        // If this is an CONSView scan then use the CONS contained in the a_data.getConsId()
        //     for the information to generate the Astra CONS label. (A CONS which needs an Astra label)
        // If the AbTypeScanned = 3 and it is not a CONSView scan, use the CONS information
        //     associated with the CONS in the AbScanned variable (A nested CONS which needs an Astra label)
        // In both cases perform a ConsSummary lookup of the information

        try
        {
            //if (a_data.getScan().getInViewName().equals("CONSView"))
        	if (a_data.getScan().getConsId() != null)
            {
                consSummary = m_db.fetchConsSummary(a_data.getScan().getConsId());
            }
            else if (a_data.getAbTypeScanned().equals("3"))
            {
                consSummary = m_db.fetchConsSummary(a_data.getAbScanned());
            }
            else
            {
                // I do not know why we were called ??
                System.out.println("AstraCONS asked for but I do not know why");
                System.out.println("   The Scan View is " + a_data.getScan().getInViewName());
                System.out.println("   Airbill Scanned " + a_data.getAbScanned() + 
                                   " form type " + a_data.getAbFormTypeScanned() + 
                                   " Airbill type " + a_data.getAbTypeScanned()); 
                return false;
            }
        }
        catch (Exception ex)
        {
            a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
            return false;
        }
      
        if (consSummary == null)
        {
            // Something wrong, this should never happen
            System.out.println("AstraCONS asked for but not found in database");
            System.out.println("   Airbill in View " + a_data.getScan().getConsId() +
                               " form type " + a_data.getScan().getConsFormType());
            System.out.println("   Airbill Scanned " + a_data.getAbScanned() +
                               " form type " + a_data.getAbFormTypeScanned() +
                               " Airbill type " + a_data.getAbTypeScanned()); 
            return false;
        }

        //  If its a CONS AB:     CONS Number                 consSummary.getConsNumber()
        //                        CONS Form Id                consSummary.getConsFormTypeCode()
        //                        Container Type ( Bag, ...)  consSummary.getConsCode()
        //                        Container Identification    consSummary.getContainerNumber()
        //                        CONS Destination Location   consSummary.getDestinationLocaitonCode()
        //                        CONS Split number           consSummary.getSplitNumber()

        String s_buildString = consSummary.getConsNumber().substring(0,4) + " " +
                               consSummary.getConsNumber().substring(4,8) + " " +
                               consSummary.getConsNumber().substring(8,12);
        l_printData.put("ASTRAConsTrkNbr", s_buildString );
        l_printData.put("ASTRAConsFormCode", consSummary.getConsFormTypeCode() );

        // Build the type of copntainer and description if needed
        ConsContainerInd = consSummary.getConsCode();
        ConsContainerId = consSummary.getContainerNumber();

        switch (ConsContainerInd.charAt(0))
        {
            case 'U':     // ULD
                l_printData.put("ASTRAConsCntnr", "ULD: " + ConsContainerId);
                break;
            case 'C':     // Cage
                l_printData.put("ASTRAConsCntnr", "CAGE: " + ConsContainerId);
                break;
            case 'B':     // Bag
                l_printData.put("ASTRAConsCntnr", "BAG");
                break;
            case 'O':     // Other
                l_printData.put("ASTRAConsCntnr", "OTHER: " + ConsContainerId);
                break;
            case 'V':     // CTV
                l_printData.put("ASTRAConsCntnr", "CTV: " + ConsContainerId);
                break;
            case 'F':     // Flight
                l_printData.put("ASTRAConsCntnr", "FLIGHT: " + ConsContainerId);
                break;
            case 'D':     // Feeder
                l_printData.put("ASTRAConsCntnr", "FEEDER: " + ConsContainerId);
                break;
            case 'S':     // Shuttle
                l_printData.put("ASTRAConsCntnr", "SHUTTLE: " + ConsContainerId);
                break;
            case 'K':     // Bulk
                l_printData.put("ASTRAConsCntnr", "BULK");
                break;
            default:
                l_printData.put("ASTRAConsCntnr", "");
                break;
        }

        // Check for Split information
        if (consSummary.getSplitNumber() == 0)
        {
            // No split infor for CONS label, set some defaults

            l_printData.put("ASTRAConsDestLoc", consSummary.getDestinationLocationCode());
            DestinationLoc = consSummary.getDestinationLocationCode();

            s_serviceLine = m_config.getValue("SERVICE_CODE_CONS");
            ServiceCode = Integer.parseInt(s_serviceLine.substring(0,2));

            ServiceCode = 11;                // Priority Overnight
            s_serviceCode = "11";
            i_handlingCodes[0] = 2;          // Weekday delivery

            return true;
        }
//        System.out.println("Perform a ReadSplit for " + consSummary.getSplitNumber());
        
        // Read in the Split and put information on label
        // ASTRASplitName
        // ASTRASplitType
        // ASTRASuffixList1 ASTRASuffixList2 ASTRASuffixList3 ASTRASuffixList4
        if (ReadSplit(a_data, consSummary.getSplitNumber()) == true)
        {
            // Read was good, put the split name
            l_printData.put("ASTRASplitName", "Split=#" + split.getLocationCd() + split.getSplitNbr() + " " +
                                                          split.getSplitDesc() );

            // Set the Split Type
            if (m_splitFormat[182] == (byte)0xFF)
            {
                // Set Split type to Prefix
                l_printData.put("ASTRASplitType", "Prefix Split");
            }
            else if (m_splitFormat[182] == (byte)0x00)
            {
                // Set Split type to Suffix
                l_printData.put("ASTRASplitType", "Suffix Split");
            }
            else if (m_splitFormat[182] == (byte)0xFD)
            {
                // Set Split type to Airport
                l_printData.put("ASTRASplitType", "Airport Split");
            }
            else if (m_splitFormat[182] == (byte)0xFE)
            {
                // Set Split type to Airport with Exceptions
                l_printData.put("ASTRASplitType", "Airport with Exceptions Split");
            }

            // Set the Destination location from the Split info
            for (int i=0; i<5; i++)  s_working[i] = (char)m_splitFormat[i+1];
            l_printData.put("ASTRAConsDestLoc", String.copyValueOf(s_working, 0, 5));
            DestinationLoc = String.copyValueOf(s_working, 0, 5);

            // The Service is based on the priority as listed at start of method
            s_serviceLine = m_config.getValue("SERVICE_CODE_CONS");
            ServiceCode = Integer.parseInt(s_serviceLine.substring(0,2));
            int i = 0;
            boolean b_notFound = true;
            while (b_notFound == true)
            {
                for (int j=0; j<9; j++)
                {
//                  System.out.println("Looking for Service " + m_splitFormat[j+166] + " " + servicePriority[i]);
                    if (m_splitFormat[j + 166] == servicePriority[i])
                    {
                        // Use this service
//                        s_serviceLine = "0100";//m_config.getValue("SERVICE_CODE_" + serviceValue[i]);
//                        ServiceCode = Integer.parseInt(s_serviceLine.substring(0,2));
                        ServiceCode = Integer.parseInt(serviceValue[i]);
                        b_notFound = false;
                        break;
                    }
                }
                i++;
            }
            s_serviceCode = Integer.toString(ServiceCode);

//          System.out.println("ServiceCode " + ServiceCode);
            
            // Set the Handling Code
            s_satDelFlg = "N";                      // Set No Sat Del as default
            i_handlingCodes[0] = WKD_DEL;           // Set Weekday as default
            i_wkdDelivery = 1;                      // Indicate it is in the Handling list
            if ((m_splitFormat[176] == 7) ||        // All
                (m_splitFormat[176] == 6) ||        // Sat and Sun
                (m_splitFormat[176] == 3) ||        // Wkd and Sat
                (m_splitFormat[176] == 2))          // Sat
            {
                s_satDelFlg = "Y";                  // Saturday Delivery
                i_handlingCodes[0] = SAT_DEL;       // Set the handling list to show Saturday
                i_satDelivery = 1;                  // Indicate it is in the Handling list
            } 

            // Set the Special Handling Codes
            int i_handIdx = 1;
            if (m_splitFormat[177] == (byte)0x01)
            {
                i_handlingCodes[i_handIdx] = ADG;
                i_handIdx++;
            }

            if (m_splitFormat[178] == (byte)0x01)
            {
                i_handlingCodes[i_handIdx] = IDG;
                i_handIdx++;
            }

            if (m_splitFormat[179] == (byte)0x01)
            {
                i_handlingCodes[i_handIdx] = ICE;
                i_handIdx++;
            }

            // Move Suffix or Airport or Airport Exception data 
            if (m_splitFormat[182] != (byte)0xFF)
            {
                // Everyone except the Prefix split
                int i_labelLineCnt = 1;
                int i_lineCnt = 0;
                int i_suffixCnt = 1;            // Set to 1 to bypass first split in list
                char s_suffix[] = new char[5];
                String s_suffixString = "";
                String s_line = "";
                b_moreSuffix = true;
                do
                {
                    // Are we at the end of the Array
                    if ((i_suffixCnt * 5) >= 160)
                    {
                       // At the end of the array
                        b_moreSuffix = false;
                        i_lineCnt = MAX_SUFFIX_PER_LINE; 
                    }

                    if (b_moreSuffix == true)
                    {
                        // extract a Suffix or Airport
                        for (i=0; i<5; i++) s_suffix[i] = (char)m_splitFormat[(i_suffixCnt * 5) + i + 6];
                        s_suffixString = String.copyValueOf(s_suffix);

                        // Determine if it is empty
                        if (s_suffixString.equals("     "))
                        {
                            // do nothing with this entry
                        }
                        else
                        {
                            // We have a valid Suffix or Airport
                            if (m_splitFormat[182] != (byte)0x00)
                            {
                                // This is an Airport Exception Split
                                if (i_suffixCnt > m_splitFormat[180])
                                {
                                    // We are in the excpeptions
                                    if (i_suffixCnt > m_splitFormat[181])
                                    {
                                        // Add a '+' to the string
                                        s_line = s_line + "+" + s_suffixString;
                                    }
                                    else
                                    {
                                        // Add a '-' to the string 
                                        s_line = s_line + "-" + s_suffixString;
                                    }
                                }
                                else
                                {
                                    // this is an Airport 
                                    s_line = s_line + s_suffixString;
                                }
                            }
                            else
                            {
                                // Put the entry into the line string
                                s_line = s_line + s_suffixString;
                            }
                            i_lineCnt++;

                            // Work the spacing
                            if (s_line.endsWith(" ") )
                            {
                                // Do nothing
                            }
                            else
                            {
                                s_line = s_line + " ";
                            }
                        }
                        // Increment the array pointer
                        i_suffixCnt++;
                    }                       

                    // If the line is full move it to the AstraList? area
                    if ((i_lineCnt == MAX_SUFFIX_PER_LINE) ||
                        (b_moreSuffix == false))
                    {
                        // line is full or we are finished, move to AstraList
                        switch (i_labelLineCnt)
                        {
                            case 1:     // List line 1
                                l_printData.put("ASTRASuffixList1", s_line);
                                break;
                            case 2:     // List line 2
                                l_printData.put("ASTRASuffixList2", s_line);
                                break;
                            case 3:     // List line 3
                                l_printData.put("ASTRASuffixList3", s_line);
                                break;
                            case 4:     // List line 4
                                l_printData.put("ASTRASuffixList4", s_line);
                                break;
                        }    

                        // increment the labelLineCnt
                        i_labelLineCnt++;

                        // Start the count of entries per line over
                        i_lineCnt = 0;

                        s_line = "";
                    }    
                } while (b_moreSuffix);
            }
        }
        else
        {
            System.out.println("Unable to Read Split");
            return false;
        }

        return true;
    }



    ////////////////////////////////////////////////////////////////////
    //
    //    ReadSplit  Read an existing Split from the Split database table
    //
    ////////////////////////////////////////////////////////////////////
    private boolean ReadSplit(CCIIState a_data, int splitNumber)
    {
        // Read the split
        try
        {
            split = m_db.fetchSplit(splitNumber);
        	/*split = new Split();
        	String splitString = "1SINA QPGA  78747748847478488488488848488472927346";
        	for(int i=0 ;i <18; i++) splitString +="1234567890E"; 
            split.setLocationCd("AKL");
            split.setSplitNbr(1);
            split.setSplitValue(splitString.getBytes());
            split.setSplitDesc("AKL split test");
            split.setSplitVersionNbr("1.1");
            split.setRecordActiveFlg("ACTIVE");
//            Timestamp updateDtTmstp = new Timestamp();
            split.setUpdateEmployeeNbr("XINGHAI");
            split.setUpdateDt(new java.util.Date());
        	*/
        }
        catch (Exception ex)
        {
            a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in AstraLabel");

            SetProblemMessage("Split Record fetch problem for split number " + splitNumber);
            return false;
        }

        if (split == null)
        {
            a_data.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
            CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","Split not found in AstraLabel");

            SetProblemMessage("Split Record fetch problem for Split number " + splitNumber);
            return false;
        }
        else
        {
            m_splitFormat = split.getSplitValue();
        }
        return true;
    }


    protected void ModifyShipDate(CCIIState a_data)
    {
        Map l_printData = a_data.m_printData;
        String timeZoneStr;
        TimeZone timeZone;
        int i_currentTime;
        int tmp;
        String[] WeekDay = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        // Based on when the Ship date starts modify the dates for URSA (Can be different by day of week)
        // First get the current date (yyyyMMdd), current time (HHmm), and day of week (EEE)
        timeZoneStr = m_config.getString("LOCAL_TIMEZONE","GMT+00:00");
        Calendar l_calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneStr));
        l_calendar.setTime(new Date(a_data.getScan().getSysDateTime()));

        tmp = l_calendar.get(Calendar.HOUR_OF_DAY);
        i_currentTime = (tmp * 100) + l_calendar.get(Calendar.MINUTE);

        s_dateString = "";
        tmp = l_calendar.get(Calendar.YEAR);
        s_dateString += tmp;
        tmp = l_calendar.get(Calendar.MONTH) + 1;
        if (tmp < 10)  s_dateString += "0";
        s_dateString += tmp;
        tmp = l_calendar.get(Calendar.DAY_OF_MONTH);
        if (tmp < 10)  s_dateString += "0";
        s_dateString += tmp;

          // The logic below returns GMT time and date
//        s_convertDt = l_calendar.getTime();
//        s_dateString = ursaFormat.format(s_convertDt);
//        i_currentTime = Integer.parseInt(currTime.format(s_convertDt)); 

        String s_dayOfWeek = WeekDay[l_calendar.get(Calendar.DAY_OF_WEEK) - 1];
//        System.out.println("Date/Time " + s_dayOfWeek + " " + s_dateString + " " + i_currentTime);

        // Read from the site_param table when cutover is to start and how many days to add
        if ((s_shipTimeStart = m_config.getValue("URSA_SHIP_TIME_CUTOVER_" +
                                                  s_dayOfWeek.toUpperCase())) == null)
        {
            // Default to 1800 as URSA ship time cut over and add 1 day
            s_shipTimeStart = "XXX AFTER 18:00 ADD 1 DAY";
        }

        // Convert the time field to an integer
        int i_shipTimeCutOver = Integer.parseInt(s_shipTimeStart.substring(10,12)) * 100 +
                                Integer.parseInt(s_shipTimeStart.substring(13,15));

        // Convert the days to add to an integer
        int i_daysToAdd = Integer.parseInt(s_shipTimeStart.substring(20,21));

        // Determine if the actual date needs to be incremented, based on URSA ship time cut over
//        System.out.println("Time test for CutOver, now " + i_currentTime + ", Cutover " + i_shipTimeCutOver);
        if ((s_shipTimeStart.substring(4,9).equals("AFTER")) &&
            (s_shipTimeStart.substring(16,19).equals("ADD")))
        {
            if (i_currentTime >= i_shipTimeCutOver)
            {
                l_calendar.add(Calendar.DAY_OF_MONTH, i_daysToAdd);

                s_dateString = "";
                tmp = l_calendar.get(Calendar.YEAR);
                s_dateString += tmp;
                tmp = l_calendar.get(Calendar.MONTH) + 1;
                if (tmp < 10)  s_dateString += "0";
                s_dateString += tmp;
                tmp = l_calendar.get(Calendar.DAY_OF_MONTH);
                if (tmp < 10)  s_dateString += "0";
                s_dateString += tmp;

                // The logic below returns GMT date/time
//                s_convertDt = l_calendar.getTime();
//                s_dateString = ursaFormat.format(s_convertDt);
//                System.out.println("Modified full date after add of " + i_daysToAdd + " Days " + s_dateString);
            }
        }
        else
        {
            if ((s_shipTimeStart.substring(4,9).equals("BEFOR")) &&
                (s_shipTimeStart.substring(16,19).equals("SUB")))
            {
                if (i_currentTime <= i_shipTimeCutOver)
                {
                    l_calendar.add(Calendar.DAY_OF_MONTH, (i_daysToAdd * -1));

                    s_dateString = "";
                    tmp = l_calendar.get(Calendar.YEAR);
                    s_dateString += tmp;
                    tmp = l_calendar.get(Calendar.MONTH) + 1;
                    if (tmp < 10)  s_dateString += "0";
                    s_dateString += tmp;
                    tmp = l_calendar.get(Calendar.DAY_OF_MONTH);
                    if (tmp < 10)  s_dateString += "0";
                    s_dateString += tmp;

                    // The logic below returns GMT date/time
//                    s_convertDt = l_calendar.getTime();
//                    s_dateString = ursaFormat.format(s_convertDt);
//                    System.out.println("Modified full Date after sub of " + i_daysToAdd + " Days " + s_dateString);
                }
            }
        }
    }

    protected void SetProblemMessage(String s_msg)
    {
        if ((s_problemMessage1 != null) && (s_problemMessage1.length() > 0))
        {
            if ((s_problemMessage2 != null) && (s_problemMessage2.length() > 0))
            {
                if ((s_problemMessage3 != null) && (s_problemMessage3.length() > 0))
                {
                    // All message areas are full, ignore this message
                }
                else
                {
                    s_problemMessage3 = s_msg;
                }
            }
            else
            {
                s_problemMessage2 = s_msg;
            }
        }
        else
        {
            s_problemMessage1 = s_msg;
        }

        // Set the Master flag
        LabelProblem = 1;
    }           


    public static void main(String args[])
    {
        System.out.println("InterceptLabel.main()");

        try
        {
            CCIIState l_data = new CCIIState();

            RPBScan l_scan = new RPBScan();

            Date now = new Date();

            l_data.m_printData.put("SEND_LABEL",new Boolean(true));
            l_data.m_printData.put("SEND_FORMAT",new Boolean(true));

            if(args.length > 0)
            {
                l_scan.setPrinterCode(args[0]);
            }
            else
            {
                l_scan.setPrinterCode("PRTEST003");
            }
            l_scan.setAirbillNumber("802049333852");
            	    l_scan.setHAWB("802049333863");
            l_data.setDiverterCode("3");
            l_scan.setAgencyCode("AG");
            l_scan.setPrinterCode("BKRT10");
            l_scan.setLocationCode("BKK");
            l_scan.setInterceptCode("BP");
            l_scan.setUserLogon("364942");
            l_scan.setSysDateTime(now);
//            	    l_data.setLabelInterceptType("MPS STAGING");

            	    l_data.m_printData.put("PieceQuantity","33");
            l_data.m_printData.put("LabelInterceptType","MPS Staging");
            l_data.m_printData.put("Agency3","FX");
            l_data.m_printData.put("Agency3Intercept1","PS");
            l_data.m_printData.put("Agency3Intercept2","WJ");
            l_data.m_printData.put("Agency3Intercept3","LSM");
            l_data.m_printData.put("Agency3Intercept4","HSM");
            l_data.m_printData.put("Agency2","CA");
            l_data.m_printData.put("Agency2Intercept1","ROD");
            l_data.m_printData.put("Agency1","CA");
            l_data.m_printData.put("Agency1Intercept1","RLV");
            l_data.m_printData.put("Agency1Intercept2","RHV");

            l_data.m_printData.put("BrokerEntryNumber","12345678901234");

            l_data.m_printData.put("LocationCode","YYZ");

            l_data.m_printData.put("ServiceCode","IP");

            l_data.setScan(l_scan);

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new AstraLabel("AstraLabel");
            System.out.println("Got the AstraLabel Object...");

            DatabaseBean db = new DatabaseBean();

            db.connect();

            l_label.doIt(l_data,db);
        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
            e.printStackTrace();
        }

        System.out.println("AstraLabel.main()...end");

        return;
    }
}
