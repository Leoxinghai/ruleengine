/*
 * Created on Mar 8, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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


public class BKKAstraBarcodeAccept extends BusinessActionBase
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
    
    private static final String m_whatVersion = "@(#) $RCSfile: BKKAstraBarcodeAccept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    //    LabelDefinitionInterface m_definition;
    public BKKAstraBarcodeAccept(String as_LabelName) throws Exception
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

    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState a_data,DatabaseBean conn) throws Exception 
    {


        // Check if Ursa and Edit loaded correctly
        if (UrsaEditLoaded == 1)
        {
            try
            {
                // Initialize the Context areas of Ursa and Edit
                uvsdk.UEInitialize();

                s_dateString = "20060308";
                // Based on the Date information just computed set the ship date and todays date
                uvsdk.SetTodaysDate(s_dateString);
                uvsdk.SetShipDate(s_dateString);

                // Set the Ursa Routing Origin station
                uvsdk.SetOriginStation("SINA");


                if (LabelProblem == 0)
                {
                    // Set the Service code (numeric value)
                    //uvsdk.SetServiceCode(ServiceCode);
  //              	uvsdk.SetServiceCode(1);
                }

                String destination = "";//uvsdk.GetDestinationAirport();
                uvsdk.CheckAirbill("40054999110000038403946712575008");
                destination = uvsdk.GetDestinationAirport();
                // Set the Handling Codes string for Astra
                // Everything has been set up, now do the routing and commit calculation
                uvsdk.RouteUrsa();
                uvsdk.CommitUrsa();

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
//        System.out.println("InterceptLabel.main()");
//
//        try
//        {
//            CCIIState l_data = new CCIIState();
//
//            RPBScan l_scan = new RPBScan();
//
//            Date now = new Date();
//
//            l_data.m_printData.put("SEND_LABEL",new Boolean(true));
//            l_data.m_printData.put("SEND_FORMAT",new Boolean(true));
//
//            if(args.length > 0)
//            {
//                l_scan.setPrinterCode(args[0]);
//            }
//            else
//            {
//                l_scan.setPrinterCode("PRTEST003");
//            }
//            l_scan.setAirbillNumber("802049333852");
//            //	    l_scan.setHAWB("802049333863");
//            l_data.setDiverterCode("3");
//            l_scan.setAgencyCode("AG");
//            l_scan.setInterceptCode("BP");
//            l_scan.setUserLogon("364942");
//            l_scan.setSysDateTime(now);
//            //	    l_data.setLabelInterceptType("MPS STAGING");
//
//            //	    l_data.m_printData.put("PieceQuantity","33");
//            l_data.m_printData.put("LabelInterceptType","MPS Staging");
//            l_data.m_printData.put("Agency3","FX");
//            l_data.m_printData.put("Agency3Intercept1","PS");
//            l_data.m_printData.put("Agency3Intercept2","WJ");
//            l_data.m_printData.put("Agency3Intercept3","LSM");
//            l_data.m_printData.put("Agency3Intercept4","HSM");
//            l_data.m_printData.put("Agency2","CA");
//            l_data.m_printData.put("Agency2Intercept1","ROD");
//            l_data.m_printData.put("Agency1","CA");
//            l_data.m_printData.put("Agency1Intercept1","RLV");
//            l_data.m_printData.put("Agency1Intercept2","RHV");
//
//            l_data.m_printData.put("BrokerEntryNumber","12345678901234");
//
//            l_data.m_printData.put("LocationCode","YYZ");
//
//            l_data.m_printData.put("ServiceCode","IP");
//
//            l_data.setScan(l_scan);
//
//            System.out.println("Got the dummy object...");
//            BusinessActionInterface l_label = new AstraLabel("AstraLabel");
//            System.out.println("Got the AstraLabel Object...");
//
//            DatabaseBean db = new DatabaseBean();
//
//            db.connect();
//
//            l_label.doIt(l_data,db);
//        }
//        catch(Exception e)
//        {
//            System.err.println("Caught an exception..." + e);
//            e.printStackTrace();
//        }
//
//        System.out.println("AstraLabel.main()...end");
//
//        return;
    }
}
