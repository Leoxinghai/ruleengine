//*************************************************************************
//
// Filename: Java2uvsdk.java
//
// Description:  interface with the UVSDK 'c' routines
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/util/Java2uvsdk.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:20 $
//
// Modification History:
//
//   12/31/02  Gary Rockwood  Initial Creation
//
// Procdedure:
//    1) Write code using the same name as contained in the UVSDK, ie:
//           s_workingTrackNumber = VuCheckAirbill(VContext, s_workingTrackNumber, 4);
//    2) Compile that code in the actual directory where it is located, ie:
//           javac Java2uvsdk.java
//    3) Check that there is a 'class' created by the same name as the source file, ie:
//           Java2uvsdk.class
//    4) Execute the following:
//           javah Java2uvsdk
//    5) Check that there is a 'c' type header file by the name 'Java2uvsdk.h'
//    6) Move that header file to the directory where the 'c' code can include it
//       in the code interfacing the UVSDK, ie:
//           cp Java2uvsdk.h ../foundation/uvsdk/Java2uvsdk.h
//    7) Edit the header file (I know it says not to do it) with the following:
//       Change all references from 'Java2uvsdk' to 'cciij_util_Java2uvsdk'
//    8) Write the corresponding 'c' logic to do the actual interface with the uvsdk lib
//       using the machine generated 'h' file.   See the example file 'Java2uvsdk.c'
//    9) The compiled java class can be removed from where it was created in step 2.
//   10) The 'c' header file created in step 4, with the same name '.h' can also be removed.
//
//*************************************************************************

package cciij.util;

import rmtc.util.Config;
import java.io.*;
import java.util.*;
import java.text.*;

/////////////////////////////////////////////////////////////////
//
//    Java2uvsdk Class definition
//
////////////////////////////////////////////////////////////////
public class Java2uvsdk implements Java2uvsdkInterface
{

    private static final String m_whatVersion = "@(#) $RCSfile: Java2uvsdk.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";

    private short ASTRA_LENGTH = 32;
    private short NTN_NO_FORM_CODE = 12;
    private short NTN_PLUS_FORM_CODE = 16;

    protected Notify m_notify = null;

    private byte m_uvsdkContext[] = null;

    //    private int m_contextIndex = -1;
    private String m_contextIndex = this.toString();

    // Make sure that Java2uvsdk library written in 'c' is loaded
    static 
    {
        try
        {
            System.loadLibrary("Java2uvsdk");
//            System.load("/ccs/home/gr61983/CCII/foundation/java2uvsdk/libJava2uvsdk.sl");
//            System.load("/ccs/home/gr61983/foundation/lib/libJava2uvsdk.sl");
//            System.load("/ccs/home/gr61983/tester/libJava2uvsdk.sl");

            System.out.println("libJava2uvsdk.sl loaded");
        }
        catch (java.lang.UnsatisfiedLinkError e)
        {
            System.out.println("UnsatisfiedLinkError on System.load of libJava2uvsdk.sl NOT loaded");
            System.out.println("Message " + e.getMessage());
            e.printStackTrace();
        }
    }


    ////////////////////////////////////////////////////////////
    //
    //  Java2uvsdk instantiator
    //
    ////////////////////////////////////////////////////////////
    public Java2uvsdk() 
    {
        m_notify= new Notify(this.getClass().getName());
//         int contextSize = getUVSDKContextSize();
//         m_uvsdkContext = new byte[contextSize];
//        m_contextIndex = initializeContext();
        System.out.println("InitializeContext!!!!!");
        int index = initializeContext(m_contextIndex);
        m_contextIndex = "" + index;
        System.out.println("New context index:  " + m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  Load URSA and EDIT files into memory
    //
    ////////////////////////////////////////////////////////////
    public int LoadUrsaEditFiles()
    {
        int i_loadStatus = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date m_convertDt = null;
        String m_dateTime = "";

        Config cfg = new Config("ALL");
        String s_ursaLocation = cfg.getValue("UrsaFile");
        String s_editLocation = cfg.getValue("EditFile");
        String s_origRouting = cfg.getValue("URSA_DUMMY_ROUTING_ORIGIN");

//        System.out.println("Ursa File at " + s_ursaLocation);
//        System.out.println("Edit File at " + s_editLocation);
//        System.out.println("Routing Code is " + s_origRouting);

        // Make sure we have the URSA file location
        if ((s_ursaLocation != null)
            && (s_ursaLocation.length() > 0))
        {
            // Make sure we have the EDIT file location
            if ((s_editLocation != null)
                && (s_editLocation.length() > 0))
            {
                // Make sure we have the ORIG information
                if ((s_origRouting != null)
                    && (s_origRouting.length() > 0))
                {
                    // Perform Ursa and Edit file loads, set the Origin Location and Todays Date
//                    i_loadStatus = UrsaEditLoad(s_ursaLocation, s_ursaLocation.length(),
//                                                s_editLocation, s_editLocation.length(),
//                                                s_origRouting, s_origRouting.length());

                    // Load the URSA file into memory
                    i_loadStatus = UrsaFileLoad(m_contextIndex,s_ursaLocation, s_ursaLocation.length());
                    if (i_loadStatus == 0)
                    {
//                        System.out.println("UrsaFileLoad was successful");
                    }
 
                    // Load the EDIT file into memory
                    i_loadStatus = EditFileLoad(m_contextIndex,s_editLocation, s_editLocation.length());
                    if (i_loadStatus == 0)
                    {
//                        System.out.println("EditFileLoad was successful");
                    }

                    // Validate the EDIT file using todays date
                    i_loadStatus = ValidateEditFile(m_contextIndex);
                    if (i_loadStatus == 0)
                    {
//                        System.out.println("ValidateEditFile was successful");
                    }
 
                    // Associate the uContext with the vContext
                    UrsaEditInitialize(m_contextIndex);
                    // System.out.println("UrsaEditInitialize was successful");

                    // Set the Origin Location for routing purposes
                    i_loadStatus = SetOriginLocation(m_contextIndex,s_origRouting, s_origRouting.length());
                    if (i_loadStatus == 0)
                    {
//                        System.out.println("SetOriginLocation was successful");
                    }

                    // Check the status of the URSA and EDIT file load
                    if (i_loadStatus != 0)
                    {
                        // Problem loading the URSA or EDIT files
                        System.out.println("URSA or EDIT file did NOT load, i_loadStatus " + i_loadStatus);
                        return (1);
                    }
                }
                else
                {
                    // Invalid or missing Orig Location
                    System.out.println("ORIG location was not found");
                    m_notify.trace("ORIG location was not found");
                    return (1);
                }
            }
            else
            {
                // Invalid or missing directory where EDIT file is located
                System.out.println("EDIT file directory not found");
                m_notify.trace("EDIT file directory not found");
                return (1);
            }
        }
        else
        {
            // Invalid or missing directory where URSA file is located
            System.out.println("URSA file directory not found");
            m_notify.trace("URSA file directory not found");
            return (1);
        }
        return (0);
    }


    ////////////////////////////////////////////////////////////
    //
    //  Load SPLIT file into memory
    //
    ////////////////////////////////////////////////////////////
    public int LoadSplitFile(String splitFileName, boolean LoadCheck)
    {
        // Only perform the actual load if LoadCheck is set to true
        if (LoadCheck == false)
        {
            return 0;
        }

        // As of July 2004 the following Split definitions apply:
        //   COSMOS supports splits 1-40
        //   UVSDK supports splits 1-80   (which means local splits are 41-80)
        //
        int i_loadStatus = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date m_convertDt = null;
        String m_dateTime = "";

        Config cfg = new Config("ALL");
        String s_splitDirectory = cfg.getValue("SplitFileDirectory");
        String s_locationCd = cfg.getValue("SITE_PARAM_LOCATION_CD");
        String s_splitLocation;

        // Check if there is a SplitFile to be loaded
        if ((s_splitDirectory != null)
             && (s_splitDirectory.length() > 0))
        {
            // The SplitFile definition has been found
//          System.out.println("Split File Directory at " + s_splitDirectory + s_locationCd + "/");

            // The SPLITTEMP file is a combination of SPLIT file and all local splits
            s_splitLocation = s_splitDirectory + s_locationCd + "/" + splitFileName;

            // Load the SPLIT file into memory
            i_loadStatus = SplitFileLoad(m_contextIndex,s_splitLocation, s_splitLocation.length());

            // Validate if the load was successful
            if (i_loadStatus == 0)
            {
                // System.out.println("SplitFileLoad was successful");

                // Validate the SPLIT file
                i_loadStatus = ValidateSplitFile(m_contextIndex);

                // Check the status of the SPLIT file load
                if (i_loadStatus != 0)
                {
                    // Problem loading the SPLIT file
                    System.out.println("SPLIT file did NOT Validate");
                    m_notify.trace("SPLIT file did not load properly");
                    return (i_loadStatus);
                }
                else
                {
                    // System.out.println("ValidateSplitFile was successful");
                }
            }
            else
            {
                 System.out.println("Split File failed to load");
                 return i_loadStatus; 
            }
        } 
        else
        {
            // Invalid or missing directory where SPLIT file is located
            System.out.println("SPLIT file directory not found");
            m_notify.trace("SPLIT file directory not found");
            return (1);
        }

        return (0);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetUrsaEffectiveDate  Method to return the Effective
    //                        date of the loaded Ursa File
    //
    ////////////////////////////////////////////////////////////
    public String GetUrsaEffectiveDate(String s_formatString)
    {
        // Perform the UVSDK call to get the Effective Date
        String s_effectiveDate = UrsaEffectiveDateGet(m_contextIndex,s_formatString, s_formatString.length());

        return s_effectiveDate;
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetUrsaExpirationDate  Method to return the Expiration
    //                         date of the loaded Ursa File
    //
    ////////////////////////////////////////////////////////////
    public String GetUrsaExpirationDate(String s_formatString)
    {
        // Perform the UVSDK call to get the Expiration Date
        String s_expirationDate = UrsaExpirationDateGet(m_contextIndex,s_formatString, s_formatString.length());

        return s_expirationDate;
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetUrsaVersion  Method to return the Version number
    //                  of the loaded Ursa File
    //
    ////////////////////////////////////////////////////////////
    public int GetUrsaVersion()
    {
        String s_version = UrsaVersionGet(m_contextIndex);

        int i_version = Integer.parseInt(s_version);

        return i_version;
    }


    ////////////////////////////////////////////////////////////
    //
    //  UEInitialize   Method to initialize the Context buffers
    //                 for both Ursa and Edit
    //
    ////////////////////////////////////////////////////////////
    public void UEInitialize()
    {
        // Make the call to the UVSDK shared library
        UrsaEditInitialize(m_contextIndex);

        return;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SInitialize   Method to initialize the Context buffers
    //                for both Splits
    //
    ////////////////////////////////////////////////////////////
    public void SInitialize()
    {
        // Make the call to the UVSDK shared library
        SplitsInitialize(m_contextIndex);

        return;
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetUrsaFileType   Method to return the type of URSA file
    //                    which has been loaded.
    //                    (All, Slice, Region, Unknown)
    //
    ///////////////////////////////////////////////////////////
    public int GetUrsaFileType()
    {
        int    i_fileType = 0;

        // Perform the UVSDK call to get the URSA File Type
        String s_fileType = UrsaFileTypeGet(m_contextIndex);
        // System.out.println("s_fileType " + s_fileType);

        i_fileType = Integer.parseInt(s_fileType);

        // The file types are defined in 'uStrLn.h' of the UVSDK
        switch(i_fileType)
        {
            case 43 :
                i_fileType = 1;      // ALL
                break;
            case 44 :
                i_fileType = 2;      // Slice
                break;
            case 45 :
                i_fileType = 3;      // Region
                break;
            default :
                i_fileType = 4;      // Unknown
                break;
        }

        return i_fileType;
    }


    ////////////////////////////////////////////////////////////
    //
    //  UInitialize    Initialize the Ursa Context buffer
    //
    ////////////////////////////////////////////////////////////
    public void UInitialize()
    {
        // Make the call to the UVSDK shared library
        UrsaInitialize(m_contextIndex);

        return;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetTodaysDate   Set Todays date to the string
    //
    ////////////////////////////////////////////////////////////
    public int SetTodaysDate(String DateString)
    {
        int     i_status = 0;

        i_status = TodaysDateStringSet( m_contextIndex,DateString );

        return i_status;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetShipDate   Set the Ship Date for Ursa
    //
    ////////////////////////////////////////////////////////////
    public int SetShipDate(String DateString)
    {
        int     i_status = 0;

        i_status = ShipDateStringSet( m_contextIndex,DateString );

        return i_status;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetDestCountry   Set Destination's Country Code
    //
    ////////////////////////////////////////////////////////////
    public int SetDestCountry(String CountryString)
    {
        int     i_status = 0;

        i_status = DestinationCountrySet( m_contextIndex,CountryString );

        return i_status;
    }

    ////////////////////////////////////////////////////////////
    //
    //  PostalCountry    Determine if Postals are supported
    //
    ////////////////////////////////////////////////////////////
    public boolean PostalCountry()
    {
        // Make the call to the UVSDK shared library
        if(CountryPostal(m_contextIndex) == 1)
        {
             return true;
        }
        else
        {
            return false;
        }
    }

    ////////////////////////////////////////////////////////////
    //
    //  SetDestPostalCode   Set Destination's Postal Code
    //
    ////////////////////////////////////////////////////////////
    public int SetDestPostalCode(String PostalString)
    {
        int     i_status = 0;

        i_status = DestinationPostalSet( m_contextIndex,PostalString, PostalString.length() );

        return i_status;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetDestStation   Set Destination's FedEx station Code
    //
    ////////////////////////////////////////////////////////////
    public int SetDestStation(String StationString)
    {
        int     i_status = 0;

        i_status = DestinationStationSet( m_contextIndex,StationString, StationString.length() );

        return i_status;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetOriginStation   Set Origin FedEx station Code
    //
    ////////////////////////////////////////////////////////////
    public int SetOriginStation(String StationString)
    {
        int     i_status = 0;

        i_status = SetOriginLocation( m_contextIndex,StationString, StationString.length() );

        return i_status;
    }


    ////////////////////////////////////////////////////////////
    //
    //  CheckAirbill   Method to verify that the airbill passed in
    //                 as an argument is valid
    //
    ////////////////////////////////////////////////////////////
    public String CheckAirbill(String TrackNumber)
    {
        int     i_status = 0;
        String  s_workingTrackNumber;

        // The last parameter indicates how entered, 0=manual
        if (TrackNumber.length() == ASTRA_LENGTH)
        {
            // ASTRA cannot be manually entered, attach start/stop charters
            s_workingTrackNumber = "*" + TrackNumber + "*";
            s_workingTrackNumber = AirbillCheck(m_contextIndex,s_workingTrackNumber, 4);
        }
        else if (TrackNumber.length() > 3 && TrackNumber.charAt(3) == '-')
        {
            // It is a dash, put the 'ab' as start/stop and remove the '-'
            s_workingTrackNumber = "a" + TrackNumber.substring(0, 3) + TrackNumber.substring(4) + "b";
            s_workingTrackNumber = AirbillCheck(m_contextIndex,s_workingTrackNumber, 1);
        }
        else if (TrackNumber.length() == NTN_PLUS_FORM_CODE)
        {
            // NTN with attached Form Code
            s_workingTrackNumber = "b" + TrackNumber + "d";
            s_workingTrackNumber = AirbillCheck(m_contextIndex,s_workingTrackNumber, 1);
        }
        else if (TrackNumber.length() == NTN_NO_FORM_CODE)
        {
            // The Form Code must be entered, return invalid
            s_workingTrackNumber = "";
        }
        else
        {
            // Indicate the Track Number was manually entered
            s_workingTrackNumber = TrackNumber;
            s_workingTrackNumber = AirbillCheck(m_contextIndex,s_workingTrackNumber, 0);
        }

        return s_workingTrackNumber;

    }


    ////////////////////////////////////////////////////////////
    //
    //  GetABFormCode  Method to retrieve the Form Code from the
    //                 last tracking number processed
    //
    ////////////////////////////////////////////////////////////
    public String GetABFormCode()
    {
        String s_formCode;

        s_formCode = ABFormCodeGet(m_contextIndex);
        return s_formCode;
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetABTypeCode  Method to retrieve the AB type from the
    //                 last tacking number processed
    //
    ////////////////////////////////////////////////////////////
    public String GetABTypeCode()
    {
        String s_typeCode;

        s_typeCode = ABTypeCodeGet(m_contextIndex);
        return s_typeCode;
    }

   
    ///////////////////////////////////////////////////////////
    //
    //  GetHandlingText   Method to retrieve the text represnetation
    //                    of a passed numeric handling code
    //
    ///////////////////////////////////////////////////////////
    public String GetHandlingText(int HandCode)
    {
        String s_handlingText;

        s_handlingText = HandlingTextGet(m_contextIndex,HandCode);
        return s_handlingText;
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetServiceCode   Method to set the service code in the Ursa Context
    //
    ////////////////////////////////////////////////////////////
    public void SetServiceCode(int serviceCode)
    {
        ServiceCodeSet(m_contextIndex,serviceCode);
    }


    ////////////////////////////////////////////////////////////
    //
    //  SetHandlingCode   Method for setting Handling Codes in
    //                    the Ursa Context
    //
    ////////////////////////////////////////////////////////////
    public void SetHandlingCode(int handlingCode)
    {
        HandlingCodeSet(m_contextIndex,handlingCode);
    }


    //////////////////////////////////////////////////////////////
    //
    //  SetAirbillAndFormCode   Method to set the Airbill and the
    //                          Form code for the ASTRA barcode
    //                          No validation is performed.   All
    //                          Validation must be performed previously.
    //
    ///////////////////////////////////////////////////////////////
    public void SetAirbillAndFormCode(String airbillNumber, String formCode)
    {
        AirbillAndFormCodeSet(m_contextIndex,airbillNumber, formCode);
    }


    ///////////////////////////////////////////////////////////////
    //
    // RouteUrsa   Method to compute routing based on information
    //             which has been set in the URSA Context
    //
    ///////////////////////////////////////////////////////////////
    public void RouteUrsa()
    {
        UrsaRoute(m_contextIndex);
    }


    ///////////////////////////////////////////////////////////////
    //
    //  CommitUrsa    Method to compute the delivery Committment
    //                based on information in the URSA Context
    //
    ///////////////////////////////////////////////////////////////
    public void CommitUrsa()
    {
        UrsaCommit(m_contextIndex);
    }

 
    /////////////////////////////////////////////////////////////
    //
    //  GetServiceAreaCode   Method to retrieve 2 character Service
    //                       area committment code
    //
    /////////////////////////////////////////////////////////////
    public String GetServiceAreaCode()
    {
        return ServiceAreaCodeGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetDestinationAirport   Method to retrieve 3 character
    //                          destination airport code
    //
    ////////////////////////////////////////////////////////////
    public String GetDestinationAirport()
    {
        return DestinationAirportGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetRoutingPrefix  Method to retireve the 2 character
    //                    URSA routing prefix
    //
    ////////////////////////////////////////////////////////////
    public String GetRoutingPrefix()
    {
        return RoutingPrefixGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetRoutingSuffix  Method to retrieve the 4 or 5 character
    //                    URSA routing suffix
    //
    ////////////////////////////////////////////////////////////
    public String GetRoutingSuffix()
    {
        return RoutingSuffixGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetAstraBarcode  Method to retrieve the 32 character Ursa
    //                   ASTRA barcode
    //
    ///////////////////////////////////////////////////////////
    public String GetAstraBarcode()
    {
        return AstraBarcodeGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  GetDeliveryDayOfWeek  Method to retrieve the Delivery Day
    //                        of Week
    //                 
    //////////////////////////////////////////////////////////// 
    public String GetDeliveryDayOfWeek()
    {
        return DeliveryDateToString(m_contextIndex,"%a", 2);    // Format and length of Format
    }


    /////////////////////////////////////////////////////////////
    //
    //  GetDeliveryDate  Method to retrieve the Delivery Date
    //
    /////////////////////////////////////////////////////////////
    public String GetDeliveryDate()
    {
        return DeliveryDateToString(m_contextIndex,"%d%b%y", 6);     // Format and length of Format
    }


    /////////////////////////////////////////////////////////////
    //
    // GetAstraLine1  Method to retrieve the 1st line of ASTRA label
    //
    /////////////////////////////////////////////////////////////
    public String GetAstraLine1()
    {
        return AstraLine1Get(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //  CommitCalculated   Method to determine if Commitment was
    //                     calculated in the URSA calls
    //
    ////////////////////////////////////////////////////////////
    public int CommitCalculated()
    {
        return CalculatedCommit(m_contextIndex);
    }


    ///////////////////////////////////////////////////////////
    //
    //  GetServiceText   Method to retrieve the text represnetation
    //                   of a passed numeric Service code
    //
    ///////////////////////////////////////////////////////////
    public String GetServiceText(int ServiceCode)
    {
        String s_serviceText;

        s_serviceText = ServiceTextGet(m_contextIndex,ServiceCode);
        return s_serviceText;
    }

 
    ///////////////////////////////////////////////////////////
    //
    //  CreateCrc   Method to create a CRC as used in Ursa or
    //              Edit or Splits
    //
    ///////////////////////////////////////////////////////////
    public int CreateCrc(byte[] array, int length)
    {
        return CrcGet(m_contextIndex,array, length);
    }


    ////////////////////////////////////////////////////////////
    //
    //   SelectSplit  Method to select the split position and
    //                assign a split to that position
    //                return == 0 Split loaded
    //                return != 0 Split not loaded
    //
    ////////////////////////////////////////////////////////////
    public int SelectSplit(int i_pos, int i_split)
    {
        return  SelectSplitGet(m_contextIndex,i_pos, i_split);
    }


    ////////////////////////////////////////////////////////////
    //
    //    SplitsCheck  Method to check if the airbill info entered
    //                 causes the package to be included or 
    //                 excluded from the selected split
    //                 return == 1 Package Accepted
    //                           2 Package Upgraded, Accept
    //                 anything else is an error
    //
    ////////////////////////////////////////////////////////////
    public int SplitsCheck()
    {
        return DoSplitsCheck(m_contextIndex);
    }
 

    ////////////////////////////////////////////////////////////
    //
    //    GetSplitsAction  Method to retrieve a numeric Split
    //                     error
    // 
    ////////////////////////////////////////////////////////////
    public int GetSplitsErrorNumber()
    {
        return SplitsErrorNumberGet(m_contextIndex);
    }        


    ////////////////////////////////////////////////////////////
    //
    //    GetSplitsText  Method to retrieve a String value which
    //                   explains the Split Error
    // 
    ////////////////////////////////////////////////////////////
    public String GetSplitsErrorText()
    {
        return SplitsErrorTextGet(m_contextIndex);
    }


    ////////////////////////////////////////////////////////////
    //
    //    AstraScan  Method to set information from an ASTRA
    //               label into the various context structures
    //        note:  This routine can only be called after the
    //               CheckAirbill routine has been called
    //
    ////////////////////////////////////////////////////////////
    public void AstraScan()
    {
        ScanAstra(m_contextIndex);

        return;
    }


    ////////////////////////////////////////////////////////////
    //
    //  The NATIVE calls to the libuvsdk.a library
    //
    ////////////////////////////////////////////////////////////

    native int UrsaEditLoad(String ctxIndex,String UrsaLocation, int UrsaLocationSize,
                            String EditLocation, int EditLocationSize,
                            String OrigLocation, int OrigLocationSize);

    native static synchronized int UrsaFileLoad(String ctxIndex,String UrsaLocation, int UrsaLocationSize);

    native int EditFileLoad(String ctxIndex,String EditLocation, int EditLocationSize);

    native int SplitFileLoad(String ctxIndex,String SplitLocation, int SplitLocationSize);

    native int ValidateEditFile(String ctxIndex); 
 
    native int ValidateSplitFile(String ctxIndex);

    native void UrsaEditInitialize(String ctxIndex);

    native void SplitsInitialize(String ctxIndex);

    native int SetOriginLocation(String ctxIndex,String OrigLocation, int OrgLocationSize);

    native String UrsaEffectiveDateGet(String ctxIndex,String formatString, int formatStringSize);

    native String UrsaExpirationDateGet(String ctxIndex,String formatString, int formatStringSize);

    native String UrsaVersionGet(String ctxIndex);

    native String UrsaFileTypeGet(String ctxIndex);

    native void UrsaInitialize(String ctxIndex);

    native int TodaysDateStringSet(String ctxIndex,String dateString);

    native int ShipDateStringSet(String ctxIndex,String dateString);

    native int DestinationCountrySet(String ctxIndex,String destCountry);

    native int CountryPostal(String ctxIndex);

    native int DestinationPostalSet(String ctxIndex,String postalString, int postalStringSize);

    native int DestinationStationSet(String ctxIndex,String stationString, int stationStringSize);

    native String AirbillCheck(String ctxIndex,String workingTrackNumber, int decode);

    native String ABFormCodeGet(String ctxIndex);

    native String ABTypeCodeGet(String ctxIndex);
 
    native String HandlingTextGet(String ctxIndex,int handlingCode);

    native void ServiceCodeSet(String ctxIndex,int serviceCode);

    native void HandlingCodeSet(String ctxIndex,int handlingCode);

    native void AirbillAndFormCodeSet(String ctxIndex,String airbillNumber, String FormCode);

    native void UrsaRoute(String ctxIndex);

    native void UrsaCommit(String ctxIndex);

    native String ServiceAreaCodeGet(String ctxIndex);

    native String DestinationAirportGet(String ctxIndex);

    native String RoutingPrefixGet(String ctxIndex);

    native String RoutingSuffixGet(String ctxIndex);

    native String AstraBarcodeGet(String ctxIndex);

    native String DeliveryDateToString(String ctxIndex,String dateFormat, int dateLength);

    native String AstraLine1Get(String ctxIndex);

    native int CalculatedCommit(String ctxIndex);

    native String ServiceTextGet(String ctxIndex,int serviceCode);
 
    native int CrcGet(String ctxIndex,byte[] array, int length);         

    native int SelectSplitGet(String ctxIndex,int i_pos, int i_split);

    native int DoSplitsCheck(String ctxIndex);

    native int SplitsErrorNumberGet(String ctxIndex);

    native String SplitsErrorTextGet(String ctxIndex);

    native void ScanAstra(String ctxIndex);

    native int initializeContext(String ctxIndex);

    native void clearContext(String ctxIndex);

    protected void finalize() throws Exception
    {
        System.out.println("Java2uvsdk.finalize() called for object:  " + this.toString() + "!!!!!!!!!!!!!!!!!");
        clearContext(m_contextIndex);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  Main Routine used for testing                                              //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
     public static void main(String[] args)
    {
        Java2uvsdk uvsdk = new Java2uvsdk();
        System.out.println("Back from constructor");
        uvsdk.LoadUrsaEditFiles();
        System.out.println("returned from LoadUrsaEditFiles()");
    }
}


