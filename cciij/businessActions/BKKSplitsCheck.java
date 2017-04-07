/*
 * Created on Mar 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
 
 	import cciij.cciidatabase.*;
 	import cciij.cciidata.*;
 	import cciij.util.*;

 	import java.io.*;
 	import java.lang.*;
 	import java.math.*;
 	import java.util.*;
 	import java.text.*;


 	public class BKKSplitsCheck extends BusinessActionBase
 	{
 	    // Variables to be used as Constants
 	    public static final int SPLIT_RECORD_SIZE = 191;
 	    public static final int SPLIT_MAX = 80;            // Configured in sSplit.h (part of UVSDK)
 	    public static final int SPLIT_HEADER_SIZE = 14;
 	    public static final int SPLIT_CRC_SIZE = 2;
 	    public static final int SPLIT_TABLE_ID = 1;
 	    public static final String SPLIT_VERSION_NBR = "0403";

 	    // Object definitions 
 	    protected Java2uvsdkInterface uvsdk = null;
 	    protected Split dbSplit = null;
 	    protected ModCheck modCheck = null;

 	    // Database definitions may use these classes
 	    protected Shipment shipment = null;
 	    protected ContractBroker contractBroker = null;
 	    protected Party party = null;

 	    // System objects 
 	    protected SimpleDateFormat ursaFormat = new SimpleDateFormat("yyyyMMdd");
 	    protected SimpleDateFormat currTime = new SimpleDateFormat("HHmm");
 	    protected SimpleDateFormat dayOfWeek = new SimpleDateFormat("EEE");
 	    protected Date s_convertDt = null;

 	    // Variables
 	    protected int UrsaEditLoaded; 
 	    public    String s_splitLoaded;
 	    protected String s_splitDirectory = "";
 	    protected String s_locationCd = "";
 	    protected int i_handlingCodes[] = {0,0,0,0,0,0,0,0};    // max of 8 Handling Codes
 	    protected int ServiceCode = 0;
 	    protected String s_serviceCode = "";
 	    protected String s_serviceLine = "";
 	    protected String s_satDelFlg = "";
 	    protected String s_halLocFlg = "";
 	    protected String PostalCode = "";
 	    protected String DestinationCountry = "";
 	    protected String DestinationState = "";
 	    protected String DestinationLoc = "";
 	    protected String s_dateString = "";
 	    protected String s_shipTimeStart = "";
 	    protected String s_astraLabel= "";

 	    // Based on some Services and Handling Codes, the logic will change
 	    protected    int i_ipdService = 0;
 	    protected    int i_bsoPresent = 0;
 	    protected    int i_satDelivery = 0;
 	    protected    int i_halDelivery = 0;
 	    protected    int i_wkdDelivery = 0;
 	    protected    int i_handlingCount = 0;
 	    protected  	 int i_bagmixSplit = 0;

 	    // If for any reason the Split Check cannot be performed set this variable
 	    //     i_splitsStatus == 0       Package allowed into Split
 	    //     i_splitsStatus == 1       Package not allowed in Split
 	    //     i_splitsStatue == 2       Split file unable to load or not present
 	    //     i_splitsStatus == 3       No Shipment Record
 	    //     i_splitsStatus == 4       No Broker Record
 	    //     i_splitsStatus == 5       No Party Record
 	    //     i_splitsStatus == 6       Unable to destination Country, Postal or Location
 	    //     i_splitsStatus == 7       Invalid ASTRA label 
 	    private int i_splitsStatus = 0;  // Default set to package allowed
 	 
 	    private String[] s_list  = new String[100];
 	    
 	    private static final String m_whatVersion = "@(#) $RCSfile: BKKSplitsCheck.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";


 	    public BKKSplitsCheck() throws Exception
 	    {
 	        traceLog("SplitsCheck","In Constructor");

 	        // Instantiate the Java2uvsdk class
 	        uvsdk = Java2uvsdkFactory.getJava2uvsdk();

 	        // Set the database interface
 	        dbSplit = new Split();
 	    }


 	    protected void readSiteConfigVariables() throws Exception
 	    {
 	        i_bagmixSplit = m_config.getInt("BAGMIX_SPLIT");
 	        super.readSiteConfigVariables();
 	    }


 	    public boolean BuildNewSplits(CCIIState state, DatabaseBean dbConnection) throws Java2uvsdkException
 	    {
 	        int     i_loadStatus = 0;
 	        boolean mb_splitStatus = false;
 	    
 	        if ((s_splitLoaded != null) &&
 	            (s_splitLoaded.length() > 0) &&
 	            (s_splitLoaded.equals("SPLIT_LOADED") == true ))
 	        {
 	            // Load the Split File as it comes from COSMOS, but only if not already loaded
 	            i_loadStatus = uvsdk.LoadSplitFile("SPLIT_UVSDK", false);
 	            if (i_loadStatus == 0)
 	            {
 	                // System.out.println("SplitsCheck, Split File loaded");
 	                // Indicate that the SPLIT file loaded correctly
 	                s_splitLoaded = "SPLIT_LOADED";
 	                return true;
 	            }
 	            else
 	            {
 	                // Problem with the SPLIT file
 	                System.out.println("SplitsCheck, problem with LoadSplitFile, status " + i_loadStatus);
 	                return false;
 	            }
 	        }
 	        else
 	        {
 	            // Set the split load status
 	            s_splitLoaded = "SPLIT_NOT_LOADED";

 	            s_locationCd = m_config.getValue("SITE_PARAM_LOCATION_CD");
 	            // System.out.println("SplitCheck, location Cd " + s_locationCd);

 	            s_splitDirectory = m_config.getValue("SplitFileDirectory");
 	            // System.out.println("SplitsCheck, split directory " + s_splitDirectory);

 	            // Initialize these variables
 	            UrsaEditLoaded = 0;

 	            // Load the Ursa and Edit files
 	            if (uvsdk.LoadUrsaEditFiles() == 0)
 	            {
 	                // Indicate that the URSA and EDIT loaded correctly
 	                UrsaEditLoaded = 1;
 	                // System.out.println("SplitsCheck, Ursa Edit loaded");

 	                // Make sure we have a valid directory
 	                if ((s_splitDirectory != null) &&
 	                    (s_splitDirectory.length() > 0))
 	                {
 	                    // Create the Split file to load as a combination of 
 	                    // COSMOS split file plus local splits
 	                    if (dbSplit != null)
 	                    { 
 	                        synchronized(dbSplit)
 	                        {
 	                            mb_splitStatus = BuildSplitFile(state, dbConnection);
 	                        }
 	                    }
 	                    else
 	                    {
 	                        mb_splitStatus = BuildSplitFile(state, dbConnection);
 	                    }

 	                    if (mb_splitStatus == true)
 	                    {
 	                        // System.out.println("SplitsCheck, SPLIT_UVSDK file built");

 	                        // Load the Split File as it comes from COSMOS
 	                        i_loadStatus = uvsdk.LoadSplitFile("SPLIT_UVSDK", true);
 	                        if (i_loadStatus == 0)
 	                        {
 	                            // System.out.println("SplitsCheck, Split File loaded");
 	                            // Indicate that the SPLIT file loaded correctly
 	                            s_splitLoaded = "SPLIT_LOADED";
 	                        }
 	                        else
 	                        {
 	                            // Problem with the SPLIT file
 	                            System.out.println("SplitsCheck, problem with LoadSplitFile, status " + i_loadStatus);
 	                            return false;
 	                        }
 	                    }
 	                    else
 	                    {
 	                        // Problem with building the SPLIT_UVSDK file
 	                        System.out.println("SplitsCheck, Problem with BuildSplitFile"); 
 	                        return false;
 	                    }
 	                }
 	                else
 	                {
 	                    // Problem with split directory name
 	                    System.out.println("SplitsCheck, Split directory problem");
 	                    return false;
 	                }
 	            }
 	            else
 	            {
 	                // Problem with the URSA or EDIT files
 	                UrsaEditLoaded = 2;
 	                System.out.println("SplitsCheck, Problem with UrsaEditLoad");
 	                return false;
 	            }
 	        }

 	        return true;
 	    }


 	    private boolean BuildSplitFile(CCIIState state, DatabaseBean dbConnection)
 	    {
 	        int              i_fileLength = 0;              // Copunt of actual file size
 	        int              i_cnt = 0;                     // the count of bytes read
 	        int              i_recordCount;                 // Count of Splits contained in SPLIT file

 	        // If all 80 splits were defined there would be (80 * 191) + 14 + 2 = 15296
 	        byte[]           splitBuffer = new byte[SPLIT_RECORD_SIZE];
 	        byte[]           m_buffer = new byte[(SPLIT_RECORD_SIZE * SPLIT_MAX) + SPLIT_HEADER_SIZE + SPLIT_CRC_SIZE];    // Possible length of the SPLIT file
 	        String           s_action = "";                 // Determines if Update or Insert
 	        File             m_file = null;                 // File Handle for SPLIT file
 	        File             d_file = null;                 // File Handle for SPLIT_UVSDK file
 	        FileInputStream  in_file;                       // Input Stream handler
 	        FileOutputStream out_file;                      // Output Stream handler


 	        // Remove any file by the name SPLIT_UVSDK if it exists then
 	        // Create a new SPLIT_UVSDK file and add the existing COSMOS
 	        // Splits, then append the local splits onto the end of
 	        // the newely created SPLIT_UVSDK file

 	        // If there is a file called SPLIT, extract the various splits and put
 	        // them into individual entries in the database tables
 	        m_file = new File(s_splitDirectory + s_locationCd + "/SPLIT");

 	        if (m_file.exists() == true)
 	        {
 	            // System.out.println("SplitCheck, SPLIT file found");
 	            // Get the file length for reading and writing
 	            i_fileLength = (int)m_file.length();

 	            // Read the SPLIT file into m_buffer for additions of local splits
 	            try
 	            {
 	               // Establish the file reader
 	               in_file = new FileInputStream(s_splitDirectory + s_locationCd + "/SPLIT");
 	            }
 	            catch (IOException e)
 	            {
 	                System.out.println("File Reader error for " +
 	                                   s_splitDirectory + s_locationCd + "/SPLIT");
 	                e.printStackTrace(System.out);
 	                return false;
 	            }

 	            // Read the specified Split
 	            try
 	            {
 	                i_cnt = in_file.read(m_buffer, 0, i_fileLength);
 	            }
 	            catch (IOException e)
 	            {
 	                System.out.println("Error in reading split file " +
 	                                    s_splitDirectory + s_locationCd + "/SPLIT");
 	                e.printStackTrace(System.out);
 	                return false;
 	            }

 	            // Close the SPLIT file
 	            try
 	            {
 	                // Close the flush the file
 	                in_file.close();
 	            }
 	            catch (IOException e)
 	            {
 	                System.out.println("File close problem for " +
 	                               s_splitDirectory + s_locationCd + "/SPLIT");
 	                e.printStackTrace(System.out);
 	                return false;
 	            }

 	            // Get the count of Split entries in the COSMOS portion of the splits
 	            i_recordCount = (m_buffer[0] * 256) + m_buffer[1];

 	            // Extract the splits from the Split file
 	            for (int i=0; i<i_recordCount; i++)
 	            {
 	                int i_startPos = (i * SPLIT_RECORD_SIZE) + SPLIT_HEADER_SIZE;
 	              
 	                // Build the entries for the Split Database
 	                dbSplit.setLocationCd(s_locationCd);
 	                
 	                // Check that we do not exceed the Splits Possible in the uvsdk
 	                if (m_buffer[i_startPos] <= SPLIT_MAX)
 	                {
 	                    dbSplit.setSplitNbr(m_buffer[i_startPos]);
 	                    for (int j=0; j<SPLIT_RECORD_SIZE; j++)
 	                    {
 	                        splitBuffer[j] = m_buffer[j+i_startPos];
 	                    }
 	                    dbSplit.setSplitValue(splitBuffer); 
 	                    dbSplit.setSplitDesc("Split received from COSMOS");
 	                    dbSplit.setSplitVersionNbr(SPLIT_VERSION_NBR);
 	                    dbSplit.setRecordActiveFlg("Y");
 	                    dbSplit.setUpdateDt(new Date(0));
 	                    dbSplit.setUpdateEmployeeNbr("COSMOS");

 	                    // need to determine if this is a save or an update
 	                    Split rdSplit = new Split();

 	                    // System.out.println("Split Number " + m_buffer[i_startPos]);
 	                    try
 	                    {
 	                        rdSplit = dbConnection.fetchSplit(m_buffer[i_startPos]);
 	                    }
 	                    catch (Exception ex)
 	                    {
 	                        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	                        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in SplitsCheck");
 	                        return false;
 	                    }

 	                    if (rdSplit == null)
 	                    {
 	                        s_action = "INSERT";
 	                    }
 	                    else
 	                    {
 	                        s_action = "UPDATE";
 	                    }

 	                    try
 	                    {
 	                        if (s_action.equals("UPDATE") == true)
 	                        {
 	                            // System.out.println("updateSplit being called");
 	                            dbConnection.updateSplit(dbSplit);
 	                        }

 	                        if (s_action.equals("INSERT") == true)
 	                        {
 	                            // System.out.println("saveSplit being called");
 	                            dbConnection.saveSplit(dbSplit);
 	                        }

 	                    }
 	                    catch (Exception ex)
 	                    {
 	                        System.out.println("Some kind of error doing a " + s_action);
 	                        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	                        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Write failed in SplitsCheck");
 	                        return false;
 	                    }
 	                }
 	            }

 	            // Now lets rename the SPLIT file to SPLIT_OLD
 	            // Establish the file then delete it
 	            d_file = new File(s_splitDirectory +  s_locationCd + "/SPLIT_OLD");

 	            // Delete the old
 	            d_file.delete();

 	            // Establish the file then rename it
 	            File old_file = new File(s_splitDirectory +  s_locationCd + "/SPLIT");

 	            File new_file = new File(s_splitDirectory +  s_locationCd + "/SPLIT_OLD");

 	            old_file.renameTo(new_file);
 	        }

 	        // If the old SPLIT_UVSDK exists then delete it
 	        d_file = new File(s_splitDirectory + s_locationCd + "/SPLIT_UVSDK");

 	        if (d_file.exists() == true)
 	        {
 	            // Delete it so it can be re-created
 	            d_file.delete();
 	            // System.out.println("SplitsCheck, SPLTTEMP file found and deleted");
 	        }
 	        else
 	        {
 	            // System.out.println("SplitsCheck, no SPLIT_UVSDK file found");
 	        }

 	        // Set the count of splits initially to 0
 	        i_recordCount = 0;

 	        // Build the Split file header in the first 14 bytes of m_buffer

 	        // Set the Split Count to 0
 	        m_buffer[0] = 0;
 	        m_buffer[1] = 0;

 	        // Set the individual Split record size
 	        m_buffer[2] = (byte)(SPLIT_RECORD_SIZE / 256);
 	        m_buffer[3] = (byte)(SPLIT_RECORD_SIZE - ((byte)(SPLIT_RECORD_SIZE / 256) * 256));

 	        // Set the Table Id
 	        m_buffer[4] = (byte)SPLIT_TABLE_ID;

 	        // Set the Split File name
 	        m_buffer[5] = (byte)'S';
 	        m_buffer[6] = (byte)'P';
 	        m_buffer[7] = (byte)'L';
 	        m_buffer[8] = (byte)'I';
 	        m_buffer[9] = (byte)'T';

 	        // Set the Version Major
 	        m_buffer[10] = (byte)SPLIT_VERSION_NBR.charAt(0);
 	        m_buffer[11] = (byte)SPLIT_VERSION_NBR.charAt(1);

 	        // Set the Version Minor
 	        m_buffer[12] = (byte)SPLIT_VERSION_NBR.charAt(2);
 	        m_buffer[13] = (byte)SPLIT_VERSION_NBR.charAt(3);

 	        // System.out.println("SplitsCheck, Split file Header created");

 	        // Start build the SPLIT_UVSDK file from database entries

 	        // Start building the Local Splits at (i_recordCount * SPLIT_RECORD_SIZE) + SPLIT_HEADER_SIZE
 	        try
 	        {
 	            dbSplit = dbConnection.fetchSplit();
 	        }
 	        catch (Exception ex)
 	        {
 	            System.out.println("Caught fetchSplit fetch error " + ex);
 	            ex.printStackTrace(System.out);
 	            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch Split failed");
 	        }
 	        while (dbSplit != null)
 	        {
 	            if (dbSplit.getSplitNbr() <= SPLIT_MAX)
 	            {
 	                // Move the SplitValue to m_splitRecord
 	                splitBuffer = dbSplit.getSplitValue();

 	                // Start location of transfer calculation
 	                 int i_start = (i_recordCount * SPLIT_RECORD_SIZE) + SPLIT_HEADER_SIZE;
 	                for (int i=0; i<SPLIT_RECORD_SIZE; i++)
 	                {
 	                    m_buffer[i_start + i] = splitBuffer[i];
 	                }
 	                // Increment the record count
 	                i_recordCount++;
 	            }

 	            // Read the next Record from Split database
 	            try
 	            {
 	                 dbSplit = dbConnection.fetchNextSplit();
 	            }
 	            catch (Exception ex)
 	            {
 	                 state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	                 CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch NextSplit failed");
 	            }
 	        }

 	        // Put the record count into bytes 0 and 1
 	        m_buffer[0] = (byte)((i_recordCount >>> 8) & 0x00FF);
 	        m_buffer[1] = (byte)(i_recordCount & 0x00FF);

 	        // Calculate what needs to be CRC'd
 	        i_cnt = (i_recordCount * SPLIT_RECORD_SIZE) + SPLIT_HEADER_SIZE;

 	        // Calculate the CRC for the entire file and put into the next 2 bytes of m_buffer
 	        int i_crc = -1;
 	        try
 	        {
 	            i_crc = (short)uvsdk.CreateCrc(m_buffer, i_cnt);
 	        }
 	        catch(Java2uvsdkException e)
 	        {
 	            System.out.println("Failed to createCRC:  " + e);
 	            e.printStackTrace(System.out);
 	            return false;
 	        }
 	        // System.out.println("Split CRC >" + i_crc + "<");
 	        m_buffer[i_cnt] = (byte)((i_crc >>> 8) & 0x00FF);
 	        m_buffer[i_cnt+1] = (byte)(i_crc & 0x00FF);

 	        // All Splits created, write the information to SPLIT_UVSDK
 	        try
 	        {
 	            // Create the SPLIT_UVSDK file to be written
 	            out_file = new FileOutputStream(s_splitDirectory + s_locationCd + "/SPLIT_UVSDK");
 	        }
 	        catch (IOException e)
 	        {
 	            System.out.println("Exception with FileWriter for " +
 	                               s_splitDirectory + s_locationCd + "/SPLIT_UVSDK");
 	            e.printStackTrace(System.out);
 	            return false;
 	        }

 	        // Write the SPLIT file to SPLIT_UVSDK
 	        try
 	        {
 	            out_file.write(m_buffer, 0, (i_cnt + 2));
 	        }
 	        catch (IOException e)
 	        {
 	            System.out.println("Error in writing split file " +
 	                                s_splitDirectory + s_locationCd + "/SPLIT_UVSDK");
 	            e.printStackTrace(System.out);
 	            return false;
 	        }

 	        // Close the SPLIT_UVSDK file
 	        try
 	        {
 	            out_file.close();
 	        }
 	        catch (IOException e)
 	        {
 	            System.out.println("File close problem for " +
 	                               s_splitDirectory + s_locationCd + "/SPLIT_UVSDK");
 	            e.printStackTrace(System.out);
 	            return false;
 	        }

 	        return true;
 	    }

 	    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
 	    {
 	        traceLog("SplitsCheck", state);
 	        // Initialize all variables    
 	        i_ipdService = 0;
 	        i_bsoPresent = 0;
 	        i_satDelivery = 0;
 	        i_halDelivery = 0;
 	        i_wkdDelivery = 0;
 	        i_handlingCount = 0;
 	        for (int i=0; i<8; i++)
 	        {
 	            i_handlingCodes[i] = 0;    // max of 8 Handling Codes
 	        }
 	        ServiceCode = 0;
 	        s_serviceCode = "";
 	        s_serviceLine = "";
 	        s_satDelFlg = "";
 	        s_halLocFlg = "";
 	        PostalCode = "";
 	        DestinationCountry = "";
 	        DestinationState = "";
 	        DestinationLoc = "";
 	        s_dateString = "";
 	        s_shipTimeStart = "";
 	        s_astraLabel= "";

 	        // Check if Splits have been loaded, if not load them
 	        if (BuildNewSplits(state, dbConnection) == false)
 	        {
 	            // Splits not loaded
 	            state.getScan().setErrorNumber(Messages.EM_SPLIT_LOAD_ERR);
 	        }
 	        else
 	        {
 	            // Find the specified Split and read 
 	            int i_split = Integer.parseInt(state.getScan().getSplitNumber());
// 	            System.out.println("Split Position " + i_split);

 	            // Set the split status to 0
 	            i_splitsStatus = 0;

 	            // If the AbScanned is the same as what is in the scan record, and it is an ASTRA
 	            // scanned barcode, we can use the ASTRA data
// 	            if ((state.getScan().getAirbillNumber().equals(state.getAbScanned())) &&
// 	                (state.getScan().getAirbillEntry().equals("3")))// &&
// 	                (state.getScan().getAirbillEntry().equals("2")))      // this is impossible, do not use ASTRA
 	            if(state.getScan().getAirbillEntry().equals("3"))
 	            {
 	                // This was an ASTRA label scanned
 	                // Re-build the ASTRA label

 	                // Append the ASTRA Check Digit number
// 	                modCheck = new ModCheck();
// 	                int checkDigit = modCheck.computeCheckDigit(s_astraLabel + "0");

 	                s_astraLabel =  state.getScan().getAstraData();
 	                
 	                s_astraLabel = s_astraLabel.substring(0,31);//s_astraLabel.substring(0,2)+"0536"+s_astraLabel.substring(6,31);
 	                // Append the ASTRA Check Digit number
 	                modCheck = new ModCheck();
 	                int checkDigit = modCheck.computeCheckDigit(s_astraLabel + "0");
 	                
 	                // Replace the last digit with the checkDigit
 	                s_astraLabel = s_astraLabel.substring(0,31) + Integer.toString(checkDigit);

// 	                System.out.println("ASTRA barcode " + s_astraLabel);

 	                synchronized(uvsdk)
 	                {
 	                    // Initialize the Context areas of Ursa and Edit
 	                    uvsdk.UEInitialize();
 	                    uvsdk.SetDestStation("PEKA");
 	                    uvsdk.SetServiceCode(11);
 	                    // Check the airbill that it is valid and build context info
 	                    String ABNumber = uvsdk.CheckAirbill(s_astraLabel);               
 	                    if (ABNumber.length() > 0)
 	                    {
 	                        // Build the context 
 	                        // AstraScan can only be called following CheckAirbill
 	                        uvsdk.AstraScan();
// 	                        state.getScan().setAirbillNumber(ABNumber);
// 	                        state.setAbScanned(ABNumber);
 	                        // Perform the Splits Check
 	                        PerformSplitsCheck(i_split, state, dbConnection);
 	                    }
 	                    else
 	                    {
 	                        // Some kind of ASTRA check problem
 	                        state.getScan().setErrorNumber(Messages.EM_SPLIT_ASTRA_ERR);
 	                        i_splitsStatus = 7;
 	                    }
 	                }    // End of synchronized(uvsdk)
 	            }
 	            else
 	            {
 	                // Non-ASTRA, read information from Shipment Record
 	                // Read the Shipment record for this package
 	                ReadShipment(state, dbConnection);

 	                if (i_splitsStatus == 0)
 	                {
 	                    // Get Service and Handling info from Shipment record
 	                    ProcessServiceHandling(state);

 	                    // Set Destination for URSA routing purposes
 	                    GetDestinationInfo(state, dbConnection);

 	                    if (i_splitsStatus == 0)
 	                    {
 	                        // Determine the Shipment Date
 	                        ModifyShipDate(state);

 	                        synchronized(uvsdk)
 	                        {
 	                            // Initialize the Context areas of Ursa and Edit
 	                            uvsdk.UEInitialize();

 	                            // Based on the Date information just computed set the ship date and todays date
 	                            uvsdk.SetTodaysDate(s_dateString);
 	                            uvsdk.SetShipDate(s_dateString);

 	                            // Set the Airbill and Form Code into the barcode area
 	                            if (state.getScan().getAirbillNumber().length() == 12)
 	                            {
 	                                // Its an NTN, append the form Code
 	                                String s_stripedAirbill = uvsdk.CheckAirbill(state.getScan().getAirbillNumber() +
 	                                                                             state.getScan().getAirbillFormType());
 	                            }
 	                            else
 	                            {
 	                                // Not an NTN, just send the airbill
 	                                String s_stripedAirbill = uvsdk.CheckAirbill(state.getScan().getAirbillNumber());
 	                            }

 	                            // Set the destination country and postal info into the URSA Context
 	                            SetDestination(state);
 	 
 	                            // Set the Service code (numeric value)
 	                            uvsdk.SetServiceCode(ServiceCode);

 	                            // Set the Handling Codes
 	                            for (int i_loop=0; i_loop<8; i_loop++)
 	                            {
 	                                // Only do this if there is an actual handling code
 	                                if (i_handlingCodes[i_loop] != 0)
 	                                {
 	                                    // Set the Handling Code in the Ursa Context
 	                                    uvsdk.SetHandlingCode(i_handlingCodes[i_loop]);
 	                                }
 	                            }

 	                            // Set the Airbill and Form Code into the barcode area
 	                            uvsdk.SetAirbillAndFormCode(state.getScan().getAirbillNumber(),
 	                                                        state.getScan().getAirbillFormType());

 	                            // Everything has been set up, now do the routing and commit calculation
 	                            uvsdk.RouteUrsa();
 	                            uvsdk.CommitUrsa();

 	                            String s_astraAB = uvsdk.GetAstraBarcode();
// 	                            System.out.println("AstraBarcode " + s_astraAB);

 	                            // Splits Check only works with ASTRA entered Airbills
 	                           
 	                            String ABNumber = uvsdk.CheckAirbill(s_astraAB);
 	                            if (ABNumber.length() > 0)
 	                            {
 	                                // Build the context
 	                                // AstraScan can only be called following CheckAirbill
 	                                uvsdk.AstraScan();

 	                                // Perform the Splits Check
 	                                PerformSplitsCheck(i_split, state,dbConnection);
 	                            }
 	                            else
 	                            {
 	                                // Some kind of ASTRA check problem
 	                                state.getScan().setErrorNumber(Messages.EM_SPLIT_ASTRA_ERR);
 	                                i_splitsStatus = 7;
 	                            }

 	                        } // End of Syncronization
 	                    }
 	                    else
 	                    {
 	                        // Unable to get Destination info
 	                        // Error message set in GetDestinationInfo
 	                    }
 	                }
 	                else
 	                {
 	                    // Unable to read Shipment information
 	                    // Error message set in ReadShipment
 	                }
 	            }  // end of ASTRA barcode check
 	        }
 	        return state;
 	    }


 	    protected void PerformSplitsCheck(int i_split, CCIIState state,DatabaseBean dbConnection) throws Java2uvsdkException
 	    {
 	        // Initialize the Splits Context
 	 	    byte[] m_splitFormat = new byte[340];
 	    	String splitType = "";
 	    	String splitList = "";
 	    	Split split = null;
 	    	String szBuildString = "";
 	        if(i_bagmixSplit == i_split) return;
 	    	uvsdk.SInitialize();
 	    	
 	    	if(state.getScan().getAirbillFormType().equals("0503")) {
		 	   	    ConsSummary consSummary = null;
		 		    try {
		 		      consSummary =  dbConnection.fetchConsSummary(state.getScan().getAirbillNumber());
		 		    }
		 		    catch (Exception ex) {
		 		      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
		 		    }
		 		    if(consSummary.getSplitNumber() != i_split) {
 	 	        		state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
 	 	        		state.getScan().setReturnMessage("WRONG DEST.");
		 		    }
		 		    return;
 	    	}
 	    	
 	    	
 	        try {
 	        	split =dbConnection.fetchSplit(i_split);
 	        } catch(Exception sex) {
 	        	state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	        	return;
 	        }
 	        
 	        System.arraycopy(split.getSplitValue(),0,m_splitFormat,0,split.getSplitValue().length);

 	        if (m_splitFormat[182] == (byte)0xFF)
 	        {
 	            state.getScan().setSplitType("P");
 	            splitType = "P";
 	        }
 	        else if (m_splitFormat[182] == (byte)0x00)
 	        {
 	            state.getScan().setSplitType("S");
 	            splitType = "S";
 	        }
 	        else if (m_splitFormat[182] == (byte)0xFD)
 	        {
 	            state.getScan().setSplitType("A");
 	            splitType = "A";
 	        }
 	        else if (m_splitFormat[182] == (byte)0xFE)
 	        {
 	            state.getScan().setSplitType("E");
 	            splitType = "E";
 	        }

 	        if(state.getScan().getAstraData().length()!= 32) {
				state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
				state.getScan().setReturnMessage("INVALID ASTRA.");
				return;
			} /*else if(state.getScan().getAirbillNumber().length()==11 &&state.getScan().getAstraData().length()!= 31) {
				state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
				state.getScan().setReturnMessage("INVALID ASTRA.");
				return;
			}*/
 	        
 	        if(state.getScan().getAirbillNumber().length()==12 && !state.getScan().getAstraData().substring(16,28).equals(state.getScan().getAirbillNumber())) {
				state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
				state.getScan().setReturnMessage("INVALID ASTRA.");
				return;
 	        } else if(state.getScan().getAirbillNumber().length()==11 && !state.getScan().getAstraData().substring(16,27).equals(state.getScan().getAirbillNumber())) {
				state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
				state.getScan().setReturnMessage("INVALID ASTRA.");
				return;
 	        }

 	        // Set the Split to Position 0
 	        int i_status = uvsdk.SelectSplit(0, i_split);
 	        if (i_status != 0)
 	        {
 	            // Indicated split is not present or in error
 	            state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
 	            i_splitsStatus = 2;
 	        }
 	        else
 	        {
 	           
 	        	String dest = uvsdk.GetDestinationAirport();
 	        	String prefix = uvsdk.GetRoutingPrefix();
 	        	String suffix = uvsdk.GetRoutingSuffix();
 	        	
 	 	        if(splitType.equals("P")) {
 	 	        	szBuildString = BuildPrefixList(m_splitFormat);
 	 	        	if(szBuildString.indexOf(prefix)==-1) {
 	 	        		state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
 	 	        		state.getScan().setReturnMessage("WRONG DEST.");
 	 	        	}
 	 	        } else {
 	 	        	szBuildString = BuildSuffixList(m_splitFormat);
 	 	        	if(szBuildString.indexOf(suffix)==-1) {
 	 	        		state.getScan().setErrorNumber(Messages.EM_FAILED_SPLIT);
 	 	        		state.getScan().setReturnMessage("WRONG DEST.");
 	 	        	}
 	 	        }
 	        }
 	        
 	        
 	    }


 	    protected void ReadShipment(CCIIState state, DatabaseBean dbConnection)
 	    {
 	        // Based on the Shipment Oid load the Shipment Table entry
 	        if (state.getScan().getShipmentOid() == 0)
 	        {
 	            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","SplitsCheck No Shipment Oid");

 	            System.out.println("Unable to read Shipment for Oid " + state.getScan().getShipmentOid());

 	            i_splitsStatus = 3;
 	            state.getScan().setErrorNumber(Messages.EM_NO_SHIPMENT_INFO);
 	        }
 	        else
 	        {
 	            // Need the shipment
 	            try
 	            {
 	                shipment = dbConnection.fetchShipment(state.getScan().getShipmentOid());
 	            }
 	            catch (Exception ex)
 	            {
 	                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","SplitsCheck Shipment fetch failed");
 	                System.err.println("Caught an exception..." + ex);
 	                ex.printStackTrace();
 	                i_splitsStatus = 3;
 	                state.getScan().setErrorNumber(Messages.EM_NO_SHIPMENT_INFO);
 	                return;
 	            }

 	            if (shipment == null)
 	            {
 	                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
 	                CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","SplitsCheck Shipment not found");
 	                i_splitsStatus = 3;
 	                state.getScan().setErrorNumber(Messages.EM_NO_SHIPMENT_INFO);
 	            }
 	            else
 	            {

// 	                System.out.println("Service Code       : >" + shipment.getServiceCode() + "<");
 	                if ((shipment.getServiceCode() != null) &&
 	                    (shipment.getServiceCode().length() > 0))
 	                {
 	                    s_serviceCode = shipment.getServiceCode();
 	                }
 	                else
 	                {
 	                    System.out.println("Service Code missing for " + state.getScan().getAirbillNumber());
 	                    i_splitsStatus = 3;
 	                    state.getScan().setErrorNumber(Messages.EM_NO_SHIPMENT_INFO);
 	                    return;
 	                }

// 	                System.out.println("Handling Code 1    : " + shipment.getSpecialHandling1Cd());
// 	                System.out.println("Handling Code 2    : " + shipment.getSpecialHandling2Cd());
// 	                System.out.println("Handling Code 3    : " + shipment.getSpecialHandling3Cd());
// 	                System.out.println("Handling Code 4    : " + shipment.getSpecialHandling4Cd());
// 	                System.out.println("Handling Code 5    : " + shipment.getSpecialHandling5Cd());
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

// 	                System.out.println("Saturday Del Flag  : " + shipment.getSaturdayDelFlg());
 	                if ((shipment.getSaturdayDelFlg() != null) &&
 	                    (shipment.getSaturdayDelFlg().length() > 0))
 	                {
 	                    s_satDelFlg = shipment.getSaturdayDelFlg();
 	                }

// 	                System.out.println("Hold at Loc Flag   : " + shipment.getHoldAtLocFlg());
 	                if ((shipment.getHoldAtLocFlg() != null) &&
 	                    (shipment.getHoldAtLocFlg().length() > 0))
 	                {
 	                    s_halLocFlg = shipment.getHoldAtLocFlg();
 	                }
 	            }
 	        }
 	        return;
 	    }

 	    protected void ProcessServiceHandling(CCIIState state)
 	    {
 	        // Convert the ServiceCode in the Shipment Record to its numeric value
 	        if (m_config.getValue("SERVICE_CODE_" + s_serviceCode.toUpperCase()) != null)
 	        {
 	            s_serviceLine = m_config.getValue("SERVICE_CODE_" + s_serviceCode.toUpperCase());
 	        }
 	        else
 	        {
 	            // Use the Default of Priority Overnight
 	            s_serviceLine = m_config.getValue("11 INTL PRIORITY CLEARED");
 	        }

 	        // For IPD shipments, indicate its IPD based on the original service
 	        // If conversion to something else after clearance that is handled in the site_param table
 	        if ((s_serviceCode.toUpperCase().equals("ID")) ||
 	            (s_serviceCode.equals("18")))
 	        {
 	            i_ipdService = 1;
 	        }

 	        ServiceCode = Integer.parseInt(s_serviceLine.substring(0,2));

 	        // If the Service Code is still IPD shipments the destination information is in the PARTY table
 	        if (ServiceCode == 18)    // 18 = IPD Service
 	        {
 	            i_ipdService = 1;
 	        }

 	        // Set any logic tests based on Handling Codes
 	        for (int i_loop=0; i_loop<5; i_loop++)
 	        {
 	            if (i_handlingCodes[i_loop] == 40)  i_bsoPresent = 1;        // For BSO use ContractBroker for destination info
 	            if (i_handlingCodes[i_loop] == 3)   i_satDelivery = 1;       // Used to Determine if Sat Delivery is in handling codes
 	            if (i_handlingCodes[i_loop] == 1)   i_halDelivery = 1;       // Used to Determine if Hold At Loc is in handling codes
 	            if (i_handlingCodes[i_loop] == 2)   i_wkdDelivery = 1;       // Used to Determine if Weekday delivery is in handling codes
 	            if (i_handlingCodes[i_loop] != 0)   i_handlingCount ++;      // A count of handling codes
 	        }

 	        // Check the sdl_flg and hal_flg
 	        if (s_satDelFlg.equals("Y") &&
 	            (i_satDelivery == 0))
 	        {
// 	            System.out.println("Need to add Sat Del to Handling codes");
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
 	    }


 	    protected void GetDestinationInfo(CCIIState state, DatabaseBean dbConnection)
 	    {
 	        int  i_contractBrokerProblem = 0;
 	        int  i_partyProblem = 0;

 	        // Set the destination Country, State and Postal from Consignee
 	        //    if Handling Code 40, then use ContractBroker information
 	        //    if ServiceCode = 18, then use Party information
 	        if (i_bsoPresent == 1)
 	        {
 	            // Use Broker as Destination location
 	            try
 	            {
 	                contractBroker = dbConnection.fetchContractBroker(state.getScan().getShipmentOid());
 	            }
 	            catch (Exception ex)
 	            {
 	                System.out.println("Unable to read ContractBroker record for ShipmentOid "
 	                                    + state.getScan().getShipmentOid());
 	                System.err.println("Caught an exception..." + ex);
 	                ex.printStackTrace();

 	                i_contractBrokerProblem = 1;
 	            }

 	            if ((contractBroker == null) && (i_contractBrokerProblem == 0))
 	            {
 	                System.out.println("Unable to find ContractBroker record for ShipmentOid "
 	                                    + state.getScan().getShipmentOid());
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

 	                i_splitsStatus = 4;
 	                state.getScan().setErrorNumber(Messages.EM_BROKER_INFO_MIS);
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
 	                        i_splitsStatus = 4;
 	                        state.getScan().setErrorNumber(Messages.EM_BROKER_INFO_MIS);
 	                        i_contractBrokerProblem = 1;
 	                    } 
 	                }
 	            }
 	        }
 	        else if (i_ipdService == 1)
 	        {
 	            // Use information from Party Table
 	            try
 	            {
 	                party = dbConnection.fetchParty(state.getScan().getHandlingUnitOid(), "P");
 	            }
 	            catch (Exception ex)
 	            {
 	                System.out.println("Unable to read Party record for HandlingUnitOid "
 	                                    + state.getScan().getHandlingUnitOid());
 	                System.err.println("Caught an exception..." + ex);
 	                ex.printStackTrace();

 	                i_partyProblem = 1;
 	            }

 	            if ((party == null) && (i_partyProblem == 0))
 	            {
 	                System.out.println("Unable to find Party record for HandlingUnitOid "
 	                                    + state.getScan().getHandlingUnitOid());
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

 	                i_splitsStatus = 5;
 	                state.getScan().setErrorNumber(Messages.EM_PARTY_INFO_MIS);
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
 	                        i_splitsStatus = 5;
 	                        state.getScan().setErrorNumber(Messages.EM_PARTY_INFO_MIS);
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
 	            if (i_splitsStatus == 0)
 	            {
 	                 // Use Consignee as Destination location
 	                PostalCode = shipment.getConsigneePostalCode();
 	                DestinationCountry = shipment.getConsigneeCountryCode();
 	                DestinationState = shipment.getConsigneeStateCode();
 	                DestinationLoc = shipment.getDestinationLocCode();
 	            }
 	        }
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

 	        // The logic below returns GMT date/time
// 	        s_convertDt = l_calendar.getTime();
// 	        s_dateString = ursaFormat.format(s_convertDt);
// 	        i_currentTime = Integer.parseInt(currTime.format(s_convertDt));

 	        String s_dayOfWeek = WeekDay[l_calendar.get(Calendar.DAY_OF_WEEK) - 1];
// 	        System.out.println("Date/Time " + s_dayOfWeek + " " + s_dateString + " " + i_currentTime);

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
// 	        System.out.println("Time test for CutOver, now " + i_currentTime + ", Cutover " + i_shipTimeCutOver);
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
// 	                s_convertDt = l_calendar.getTime();
// 	                s_dateString = ursaFormat.format(s_convertDt);
// 	                System.out.println("Modified full date after add of " + i_daysToAdd + " Days " + s_dateString);
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
// 	                    s_convertDt = l_calendar.getTime();
// 	                    s_dateString = ursaFormat.format(s_convertDt);
// 	                    System.out.println("Modified full Date after sub of " + i_daysToAdd + " Days " + s_dateString);
 	                }
 	            }
 	        }
 	    }

 	    protected void SetDestination(CCIIState state) throws Java2uvsdkException
 	    {
 	        int i_status = 0;

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
 	                                state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	                                i_splitsStatus = 6;
 	                            }
 	                        }
 	                        else
 	                        {
 	                            // Problem with Postal
 	                            state.getScan().setErrorNumber(Messages.EM_INVALID_POSTAL);
 	                            i_splitsStatus = 6; 
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
 	                            state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	                            i_splitsStatus = 6;
 	                        }
 	                    }
 	                    else
 	                    {
 	                        // Both Postal and Dest Loc are missing
 	                        state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	                        i_splitsStatus = 6;
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
 	                        state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	                        i_splitsStatus = 6;
 	                    }
 	                }
 	                else
 	                {
 	                    // Destination Loc missing, Postals not supported
 	                    state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	                    i_splitsStatus = 6;
 	                }
 	            }
 	        }
 	        else
 	        {
 	            // No destination country info
 	            state.getScan().setErrorNumber(Messages.EM_INVALID_DEST);
 	            i_splitsStatus = 6;
 	        }
 	    }

 	    private static String BuildPrefixList(byte[] m_splitFormat)   {
 	        int MAX_CHARACTERS   = 53;
 	        char[] firstChar     = {'0','1','2','3','4','5','6','7','8','9',
 	                                'A','B','C','D','E','F','G','H','I','J',
 	                                'K','L','M','N','O','P','Q','R','S','T',
 	                                'U','V','W','X','Y','Z'};
 	        char[] secondChar    = {'0','1','2','3','4','5','6','7','8','9',
 	                                'A','B','C','D','E','F','G','H','I','J',
 	                                'K','L','M','N',    'P','Q','R','S','T',
 	                                'U','V','W','X','Y','Z'};
 	        byte[] mask          = {(byte)0x001, (byte)0x002, (byte)0x004, (byte)0x008,
 	                                (byte)0x010, (byte)0x020, (byte)0x040, (byte)0x080};
 	        char[] c_prefix      = new char[2];
 	        char[] c_lastGood    = new char[2];
 	        int i_byte           = 0;
 	        int i_bit            = 0;
 	        int i_count          = 0;
 	        int i_listCount      = 0;
 	        String s_buildString = "";

 	        // The first list always has the Split Type
 	        s_buildString = " ";
 	        
 	        int j = 0;
 	        for (int i=0; i<36; i++)
 	        {
 	        for (int k=0; k<35; k++)
 	        {
 	            j = (k * 36) + i;
 	            i_byte = j / 8;
 	            i_bit  = j % 8; 
 	            System.out.println("i_byte"+i_byte);
 	            System.out.println("i_bit"+i_bit);
 	            if ((m_splitFormat[i_byte + 6] & mask[i_bit]) != 0)
 	            {
 	                    // First of a possible string or its a single 
 	                    c_prefix[0] = firstChar[i];
 	                    c_prefix[1] = secondChar[k];
 	                    s_buildString = s_buildString + String.copyValueOf(c_prefix);
 	                    s_buildString = s_buildString + " ";
		                i_count++;
 	            }

 	        }
 	        }
 	        return s_buildString;
 	    }
 	    

 	    private String BuildSuffixList(byte[] m_splitFormat)   {
 	    	byte oneByte;
 	    	String s_buildString = "";

 	        // The first list always has the Split Type
 	        s_buildString = " ";
 	        int continueSpaceCount = 0;
 	        int i = 0;
 	        for(i=0;i<m_splitFormat.length-6;i++) {
 	        	oneByte = m_splitFormat[i+6];
 	        	if(oneByte == ' ') {
 	        		continueSpaceCount++;
 	        	} else {
 	        		continueSpaceCount = 0;
 	        	}
 	        	if(continueSpaceCount >=6) break;
 	        }
 	        s_buildString = new String(m_splitFormat,6,i);
 	        return s_buildString;
 	    }

 	    public static void main(String[] args)
 	    {
 	        String result ="";
 	        byte orign[] = new byte[1024];
 	        try {
 	            orign = "234B554C412000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000313637383920202020200302060203FFFF0220202020200517000000000000000000".getBytes();
// 	            orign[5]='A';
// 	            orign[8]='A';
// 	            orign = "234B554C4120ABCD0000000000000".getBytes();
 	            result = BKKSplitsCheck.BuildPrefixList(orign);
 	            System.out.println(result);
 	        }catch(Exception ex) {
 	            
 	        System.out.println("SplitsCheck in main"+ex.toString());
 	        }

// 	        System.out.println("Leaving main");
 	    }

 	}

