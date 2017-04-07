package cciij.businessActions;

/**
 * Title:        Splits Maintenance
 * Description:  Activated by the ScanClient to perform some kind
 *               of Mainentance on a Split Record.
 *                  Activities are identified in s_splitFunction
 *          (not impl) ADD - Add a split to the file system
 *                     SCN - Scan barcodes to create a Split
 *          (not impl) VEW - View an existing Split
 *          (not impl) EDT - Edit an existing Split
 *                     DEL - Delete an existing Split
 *                     UND - Un-delete a previously deleted Split
 *                     PRT - Print an existing Split on barcode labels (Validate it exists)
 *                     RLD - Re-load URSA, EDIT and Splits
 *                     RNM - Rename Split
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   06/29/04    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.io.*;
import java.lang.*;
import java.util.Date;

public class SplitsMaintenance extends BusinessActionBase
{
//    private int SPLIT_RECORD_SIZE = 191;
//    private String SPLIT_VERSION_NBR = "0403";

    private int BUFFER_SIZE = 200;

    protected    String s_locationCd = "";
    protected    byte[]  m_splitFormat = new byte[BUFFER_SIZE];
    protected    byte[]  m_splitRead   = new byte[BUFFER_SIZE];
    protected    String s_saveSplitDesc = "";
    protected    String s_saveRecordActiveFlg = "";
    protected    int i_fileLength = 0;
    protected    Java2uvsdkInterface uvsdk = null;

    private static final String m_whatVersion = "@(#) $RCSfile: SplitsMaintenance.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    /////////////////////////////////////////////////////////////////////////////
    //
    //    SplitsMaintenance   BusinessActions to control Split files
    //
    ////////////////////////////////////////////////////////////////////////////
    public SplitsMaintenance() throws Exception
    {
        traceLog("SplitsMaintenance","In Constructor");

        // Instantiate the Java2uvsdk class, so we can use the CRC calculation
        uvsdk = Java2uvsdkFactory.getJava2uvsdk();

        // The actual Ursa, Edit or Split files do not need to be loaded
    }


    /////////////////////////////////////////////////////////////////////////////
    //
    //    Read any Site specific variables from the site_param table
    //
    ////////////////////////////////////////////////////////////////////////////
    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();

        s_locationCd = m_config.getValue("SITE_PARAM_LOCATION_CD");
    }


    //////////////////////////////////////////////////////////////////////////////
    //
    //    doIt   The entry point for SplitMaintenance Business Action
    //
    //////////////////////////////////////////////////////////////////////////////
    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        traceLog("SplitsMaintenance", state);

        if (Integer.parseInt(state.getScan().getSplitNumber()) > SplitsCheck.SPLIT_MAX)
        {
            state.getScan().setErrorNumber(Messages.EM_INVALID_SPLIT);
            return state;
        }

        // Find the specified Split and read
//        System.out.println("SplitMaintenance splitNumber >" + state.getScan().getSplitNumber() + "<");
//        System.out.println("SplitMaintenance splitFunction >" + state.getScan().getSplitFunction() + "<");

        // Set the Split Name based on the location and the Split Number
        state.getScan().setSplitName( s_locationCd + state.getScan().getSplitNumber() );

        // ADD Split ***********************************************************
//        if (state.getScan().getSplitFunction().equals("ADD"))
//        {
//            // If this is an existing Split File then ask user to perform an SEDT
//            if (ReadSplit(state, dbConnection) == true)
//            {
//                // An existing Split, do not overwrite it with this new info
//                // Pass back that the Split exists, use SEDT
//                state.getScan().setErrorNumber(Messages.EM_SPLIT_EXISTS);
//            }
//            else
//            {
//                // Build the Split information into a buffer
//                i_size = PutViewToFormat(state);
//                if (i_size == 0)
//                {
//                    // Return with a Update Error
//                    state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
//                }
//                else
//                {
//                    s_saveRecordActiveFlg = "Y";
//                    if (state.getScan().getSplitNumber().length() < 2)
//                    {
//                        s_saveSplitDesc = s_locationCd + "0" + state.getScan().getSplitNumber() +
//                                          " to " + state.getScan().getSplitDestId();
//                    }
//                    else
//                    {
//                        s_saveSplitDesc = s_locationCd + state.getScan().getSplitNumber() +
//                                          " to " + state.getScan().getSplitDestId();
//                    }
////                  s_saveSplitDesc = "Split Added vie Scanner");
//
//                    if (WriteSplit(state, dbConnection, "SAVE") == false)
//                    {
//                        // Return with an Update Error
//                        state.getScan().setErrorNumber(Messages.EM_SPLIT_ADD_ERR);
//                    }
//                }
//            }
//        }

        // SCN Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("SCN"))
        {
            // Build the Split information into a buffer
            int i_size = PutViewToFormat(state);
            if (i_size == 0)
            {
                // Return with a Update Error
                state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
            }
            else
            {
                // Does this Split already exist
                if (ReadSplit(state, dbConnection) == true)
                {
                    if (state.getScan().getSplitNumber().length() < 2)
                    {
                        s_saveSplitDesc = s_locationCd + "0" + state.getScan().getSplitNumber() +
                                          " to " + state.getScan().getSplitDestId();
                    }
                    else
                    {
                        s_saveSplitDesc = s_locationCd + state.getScan().getSplitNumber() +
                                          " to " + state.getScan().getSplitDestId();
                    }
//                    s_saveSplitDesc = "Split Updated by scanning Barcodes";
                    s_saveRecordActiveFlg = "Y";

                    if (WriteSplit(state, dbConnection, "UPDATE") == false)
                    {
                        // Return with an Update Error
                        state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                    }
                }
                else
                {
                    if (state.getScan().getSplitNumber().length() < 2)
                    {
                        s_saveSplitDesc = s_locationCd + "0" + state.getScan().getSplitNumber() +
                                          " to " + state.getScan().getSplitDestId();
                    }
                    else
                    {
                        s_saveSplitDesc = s_locationCd + state.getScan().getSplitNumber() +
                                          " to " + state.getScan().getSplitDestId();
                    }
//                    s_saveSplitDesc = "Split Added by scanning Barcodes";
                    s_saveRecordActiveFlg = "Y";

                    if (WriteSplit(state, dbConnection, "SAVE") == false)
                    {
                        // Return with an Update Error
                        state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                    }


                }
            }
        }

//        // VEW Split ***********************************************************
//        if (state.getScan().getSplitFunction().equals("VEW"))
//        {
//            if (ReadSplit(state, dbConnection) == true)
//            {
//                // Process the split buffer
//                if (PutFormatToView(state) == 0)
//                {
//                    // return with a Read Error
//                    state.getScan().setErrorNumber(Messages.EM_SPLIT_READ_ERR);
//                }
//            }
//            else
//            {
//                // Send back a message indicating the Split does not exist
//                state.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
//            }
//        }

//        // EDT Split ***********************************************************
//        if (state.getScan().getSplitFunction().equals("EDT"))
//        {
//            // After editing the Split info return as an ADD
//
//            if (ReadSplit(state, dbConnection) == true)
//            {
//                // Process the split buffer
//                if (PutFormatToView(state) == 0)
//                {
//                    // return with a Read Error
//                    state.getScan().setErrorNumber(Messages.EM_SPLIT_READ_ERR);
//                }
//                // Tell ScanClient that this is the EDT function that now needs updating
//            }
//            else
//            {
//                // Send back a message indicating the Split does not exist
//                state.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
//            }
//        }

        // DEL Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("DEL"))
        {
            if (ReadSplit(state, dbConnection) == true)
            {
                s_saveRecordActiveFlg = "N";

                for (int i=0; i<BUFFER_SIZE; i++)
                {
                    m_splitFormat[i] = m_splitRead[i];
                }

                if (WriteSplit(state, dbConnection, "UPDATE") == false)
                {
                    // Return with a Delete Error
                    state.getScan().setErrorNumber(Messages.EM_SPLIT_DELETE_ERR);
                }
            }
            else
            {
                // Pass back a message indicating the Split does not exist
                state.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
            }
        }

        // UND Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("UND"))
        {
            if (ReadSplit(state, dbConnection) == true)
            {
                if (s_saveRecordActiveFlg == "Y")
                {
                    // File not deleted
                    // Return with a notice that Split File already exists
                    state.getScan().setErrorNumber(Messages.EM_SPLIT_EXISTS);
                }
                else
                {
                    s_saveRecordActiveFlg = "Y";

                    for (int i=0; i<BUFFER_SIZE; i++)
                    {
                        m_splitFormat[i] = m_splitRead[i];
                    }

                    if (WriteSplit(state, dbConnection, "UPDATE") == false)
                    {
                        // an undelete error
                        state.getScan().setErrorNumber(Messages.EM_SPLIT_UNDEL_ERR);
                    }
                }
            }
            else
            {
                // Pass back a message indicating the Deleted Split does not exist
                state.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
            }
        }

        // PRT Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("PRT"))
        {
            // Must be an exisitng Split File
            if (ReadSplit(state, dbConnection) == true)
            {
                // Split present just return
                // System.out.println("Split Exists");
            }
            else
            {
                // System.out.println("Split NOT found");
                // Set the error message to indicate that this Split does not exist
                state.getScan().setErrorNumber(Messages.EM_UNKNOWN_SPLIT);
            }
        }

        // RLD Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("RLD"))
        {
            // The instantiation does the full URSA, EDIT and Split load
            SplitsCheck SplitsC = new SplitsCheck();
            SplitsC.s_splitLoaded = "SPLIT_NOT_LOADED";
            if (SplitsC.BuildNewSplits(state, dbConnection) == false)
            {
                System.out.println("SPLIT_NOT_LOADED");
                // Set the error message to indicate that this Split does not exist
                state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
            }
        }

        // RNM Split ***********************************************************
        if (state.getScan().getSplitFunction().equals("RNM"))
        {
            if (ReadSplit(state, dbConnection) == true)
            {
                s_saveRecordActiveFlg = "N";
                s_saveSplitDesc = "Split being renamed";

                for (int i=0; i<BUFFER_SIZE; i++)
                {
                    m_splitFormat[i] = m_splitRead[i];
                }

                if (WriteSplit(state, dbConnection, "UPDATE") == false)
                {
                    // Return with Update Error
                    state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                }
                else
                {
                    // Move the new split number found in s_splitZipCode
                    m_splitFormat[0] = (byte)Integer.parseInt(state.getScan().getSplitZipCode());

                    // Set the new Split Number back into the state
                    state.getScan().setSplitNumber(state.getScan().getSplitZipCode());

                    // The check digit needs to be re-computed
                    short i_crc = -1;
                    try
                    {
                        i_crc = (short)uvsdk.CreateCrc(m_splitFormat, SplitsCheck.SPLIT_RECORD_SIZE - 2);
                    }
                    catch(Java2uvsdkException e)
                    {
                        System.out.println("Failed to createCRC in uvsdk:  " + e);
                        e.printStackTrace(System.out);
                        state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                        throw e;
                    }


                    // See if the new split exists
                    if (ReadSplit(state, dbConnection) == true)
                    {
                        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-2] = (byte)((i_crc >>> 8) & 0x00FF);
                        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-1] = (byte)(i_crc & 0x00FF);

                        s_saveRecordActiveFlg = "Y";
                        s_saveSplitDesc = "Split Updated by Re-nameing";

                        for (int i=0; i<BUFFER_SIZE; i++)
                        {
                            m_splitFormat[i] = m_splitRead[i];
                        }

                        // Write the new split to the database
                        if (WriteSplit(state, dbConnection, "UPDATE") == false)
                        {
                            // Return with Update Error
                            state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                        }
                    }
                    else
                    {
                        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-2] = (byte)((i_crc >>> 8) & 0x00FF);
                        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-1] = (byte)(i_crc & 0x00FF);

                        s_saveRecordActiveFlg = "Y";
                        s_saveSplitDesc = "Split Added by Re-nameing Split";

                        // Write the new split to the database
                        if (WriteSplit(state, dbConnection, "SAVE") == false)
                        {
                            // Return with Update Error
                            state.getScan().setErrorNumber(Messages.EM_SPLIT_UPDATE_ERR);
                        }
                    }
                }
            }
            else
            {
                // return with a Read Error
                state.getScan().setErrorNumber(Messages.EM_SPLIT_READ_ERR);
            }
        }

        return state;
    }


    ////////////////////////////////////////////////////////////////////
    //
    //    WriteSplit  Writes information in m_splitFormat into Split directory
    //
    ////////////////////////////////////////////////////////////////////
    private boolean WriteSplit(CCIIState state, DatabaseBean dbConnection, String Action)
    {
        Split split = new Split();

        split.setLocationCd(s_locationCd);
        split.setSplitNbr(Integer.parseInt(state.getScan().getSplitNumber()));
        split.setSplitValue(m_splitFormat);
        split.setSplitDesc(s_saveSplitDesc);
        split.setSplitVersionNbr(SplitsCheck.SPLIT_VERSION_NBR);
        split.setRecordActiveFlg(s_saveRecordActiveFlg);
        split.setUpdateDt(new Date(state.getScan().getSysDateTime()));
        split.setUpdateEmployeeNbr(state.getScan().getUserLogon());

        try
        {
/*            if (Action.equals("UPDATE") == true)
            {
                // System.out.println("updateSplit being called");
                dbConnection.updateSplit(split);
            }

            if (Action.equals("SAVE") == true)
            {
                // System.out.println("saveSplit being called");
                dbConnection.saveSplit(split);
            }
*/
        	Split split0 = dbConnection.fetchSplit(split.getSplitNbr());
        	if(split0 ==null) {
        		dbConnection.saveSplit(split);
        	} else {
        		dbConnection.updateSplit(split);
        	}
        }
        catch (Exception ex)
        {
            System.out.println("Some kind of error");
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in AstraLabel");
            return false;
        }

        return true;
    }


    ////////////////////////////////////////////////////////////////////
    //
    //    ReadSplit  Read an existing Split from the Split database table
    //
    ////////////////////////////////////////////////////////////////////
    private boolean ReadSplit(CCIIState state, DatabaseBean dbConnection)
    {
        Split split = new Split();

        // Read the split
        // System.out.println("Split Number " + Integer.parseInt(state.getScan().getSplitNumber()));
        try
        {
            split = dbConnection.fetchSplit(Integer.parseInt(state.getScan().getSplitNumber()));
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in SplitMaintenance");
            return false;
        }

        if (split == null)
        {
            // No current Split entry
            return false;
        }
        else
        {
            // pull information from Split
            m_splitRead = split.getSplitValue();
            s_saveSplitDesc = split.getSplitDesc();
            s_saveRecordActiveFlg = split.getRecordActiveFlg();
        }
        return true;
    }


    /////////////////////////////////////////////////////////////////////
    //
    //    PutViewToFormat   takes the SPLTView and builds the Split Record
    //                      which will be written to the file
    //
    //////////////////////////////////////////////////////////////////////
    private int PutViewToFormat(CCIIState state) throws Java2uvsdkException
    {
        short   i_crc = 0;


        // Byte 1 is the Split Number in Binary
//        System.out.println("Split Number >" + state.getScan().getSplitNumber() + "<");
        m_splitFormat[0] = (byte)Integer.parseInt(state.getScan().getSplitNumber());

        // Destination Id is the next 5 bytes in ASCII
//        System.out.println("Split DestId >" + state.getScan().getSplitDestId() + "<");
        for (int i=0; i<5; i++)  m_splitFormat[i+1] = (byte)state.getScan().getSplitDestId().charAt(i);


        // The Binary Split Array is next
        if (state.getScan().getSplitType().equals("P"))
        {
//            System.out.println("Prefix Split");
            // Prefix Split
            // This needs to be broken down from 320 to the appropriate nibbles
            int i_lastByte = -1;
            for (int i=0; i<320; i++)
            {
//                System.out.println("Prefix Split, index " + i + " char " +
//                                    state.getScan().getSplitArray().charAt(i));
                // Each character represents a nibble of a byte array
                byte i_value = 0;
                // convert the ascii byte to binary
                if ((state.getScan().getSplitArray().charAt(i) >= '0') &&
                    (state.getScan().getSplitArray().charAt(i) <= '9'))
                {
                    i_value = (byte)(state.getScan().getSplitArray().charAt(i) - '0');
                }
                else
                {
                    i_value = (byte)((state.getScan().getSplitArray().charAt(i) - 'A') + 10);
                }

                // Determine the byte to be updated, between 1 and 160
                int i_byte = i / 2;
                int i_mod = (i+2) % 2;

                byte i_hold = m_splitFormat[i_byte + 6];

                // If this is a new byte, first clear it to 0
                if (i_byte != i_lastByte)
                {
                    i_hold = (byte)0;
                    i_lastByte = i_byte;
                }

                // This might should be (i_mod != 0)
                if (i_mod == 0)
                {
                    // Left hand nibble
                    i_hold = (byte)(i_hold + (i_value << 4));    // Shift the bits by 4
                }
                else
                {
                    // Right hand nibble
                    i_hold = (byte)(i_hold + i_value);           // No shift just add to byte
                }

                m_splitFormat[i_byte + 6] = i_hold;
            }
        }
        else
        {
            // Suffix split, or Airport split, or Airport Exception split
//            System.out.println("Suffix, or Airport or Airport Exception Split");
            for (int i=0; i<160; i++)
            {
//                System.out.println("S, A, E  Split, index " + i + " char " +
//                                    state.getScan().getSplitArray().charAt(i));
                m_splitFormat[i+6] = (byte)state.getScan().getSplitArray().charAt(i);
            }
        }

        // Move Services into place
//        System.out.println("SplitServices >" + state.getScan().getSplitServices() + "<");
        for (int i=0, j=0; i<10; i++) m_splitFormat[i+166] = ' ';
        for (int i=0, j=0; i<10; i++)
        {
            if (state.getScan().getSplitServices().charAt(i) != '0')
            {
                 m_splitFormat[j+166] = (byte)(i+'0');
                 j++;
            }
        }

        // Move Handling into position
//        System.out.println("Split Handling >" + state.getScan().getSplitHandling() + "<");
        m_splitFormat[176] = (byte)Integer.parseInt(state.getScan().getSplitHandling());

        // Move Special Handling
//        System.out.println("Split Spc Handling >" + state.getScan().getSplitSpcHandling() + "<");
        for (int i=0; i<3; i++)
        {
            m_splitFormat[i+177] = (byte)(state.getScan().getSplitSpcHandling().charAt(i) - '0');
        }
        if (state.getScan().getSplitType().charAt(0) == 'E')
        {
            // For Airport Exception Splits the Box/Doc contains a binary Offset
            // and the Alternate Split contain a binary Offset
            m_splitFormat[180] = (byte)state.getScan().getSplitBoxDoc().charAt(0);
            m_splitFormat[181] = (byte)state.getScan().getSplitAltSplit().charAt(0);
        }
        else
        {
            // Set Box/Doc to the value 3
//            System.out.println("Split Box/Doc >" + state.getScan().getSplitBoxDoc() + "<");
            m_splitFormat[180] = (byte)Integer.parseInt(state.getScan().getSplitBoxDoc());

            // Alternate Split
//            System.out.println("Split AltSplit >" + state.getScan().getSplitAltSplit() + "<");
            m_splitFormat[181] = (byte)0xFF;
        }

        // Indicate the type of Split
//        System.out.println("Split Type >" + state.getScan().getSplitType() + "<");
        if (state.getScan().getSplitType().charAt(0) == 'P')
        {
            // Prefix Split
            m_splitFormat[182] = (byte)0xFF;
        }
        else if (state.getScan().getSplitType().charAt(0) == 'S')
        {
            // Suffix Split
            m_splitFormat[182] = (byte)0x00;
        }
        else if (state.getScan().getSplitType().charAt(0) == 'A')
        {
            // Suffix Split
            m_splitFormat[182] = (byte)0xFD;
        }
        else if (state.getScan().getSplitType().charAt(0) == 'E')
        {
            // Suffix Split
            m_splitFormat[182] = (byte)0xFE;
        }

        // Set Intl/Dom
//        System.out.println("Split Intl/Dom >" + state.getScan().getSplitIntlDom() + "<");
        m_splitFormat[183] = (byte)Integer.parseInt(state.getScan().getSplitIntlDom());

        // Set Zip Code to all Blanks
        for (int i=0; i<5; i++)  m_splitFormat[i+184] = (byte)' ';

        // Calculate the CRC for this structure and put into place
        try
        {
            i_crc = (short)uvsdk.CreateCrc(m_splitFormat, SplitsCheck.SPLIT_RECORD_SIZE - 2);
        }
        catch(Java2uvsdkException e)
        {
            System.out.println("Failed to createCrc:  " + e);
            e.printStackTrace(System.out);
            throw e;
        }
//        System.out.println("Split CRC > " + i_crc + "<");

        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-2] = (byte)((i_crc >>> 8) & 0x00FF);
        m_splitFormat[SplitsCheck.SPLIT_RECORD_SIZE-1] = (byte)(i_crc & 0x00FF);
//        System.out.println("Split 1 >" + (byte)(i_crc >>> 8));
//        System.out.println("Split 2 >" + (byte)(i_crc & 0x00FF));

        return SplitsCheck.SPLIT_RECORD_SIZE;  // Split file size

    }


    /////////////////////////////////////////////////////////////////////
    //
    //    PutFormatToView   takes the Split Record and builds the SPLTView
    //                      which will be passed back to the user
    //
    //////////////////////////////////////////////////////////////////////
    private int PutFormatToView(CCIIState state)
    {
        char[] s_working = new char[320];
        String s_string;
        int i_integer;

        // m_splitFormat has the split record as read from the directory
        // Byte 1 is the Split Number in Binary
        if (m_splitFormat[0] < 9)
        {
            s_string = "0" + Integer.toString((int)m_splitFormat[0]);
        }
        else
        {
            s_string = Integer.toString(m_splitFormat[0]);
        }
        state.getScan().setSplitNumber(s_string);
//        System.out.println("Split Number >" + state.getScan().getSplitNumber() + "<");

        // Destination Id is the next 5 bytes in ASCII
        for (int i=0; i<5; i++)  s_working[i] = (char)m_splitFormat[i+1];
        state.getScan().setSplitDestId(String.copyValueOf(s_working,0,5));
//        System.out.println("Split DestId >" + state.getScan().getSplitDestId() + "<");

        // Move Services into place
        for (int i=0; i<10; i++) s_working[i] = '0';
        for (int i=0; i<10; i++)
        {
             if (m_splitFormat[i+166] != ' ')
             {
                 // Convert the value to an index
                 int i_value = (m_splitFormat[i+166] - '0');
                 s_working[i_value] = '1';
             }
        }
        state.getScan().setSplitServices(String.copyValueOf(s_working,0,10));
//        System.out.println("SplitServices >" + state.getScan().getSplitServices() + "<");

        // Move Handling into position
        s_working[0] = (char)(m_splitFormat[176] + (byte)'0');
        state.getScan().setSplitHandling(String.copyValueOf(s_working,0,1));
//        System.out.println("Split Handling >" + state.getScan().getSplitHandling() + "<");

        // Move Special Handling
        for (int i=0; i<3; i++) s_working[i] = (char)(m_splitFormat[i+177] + (byte)'0');

        state.getScan().setSplitSpcHandling(String.copyValueOf(s_working,0,3));
//        System.out.println("Split Spc Handling >" + state.getScan().getSplitSpcHandling() + "<");

        // Set Box/Doc, but differently for Airport Exception
        if (m_splitFormat[182] == (byte)0xFE)
        {
            s_working[0] = (char)(m_splitFormat[180]);
        }
        else
        {
            s_working[0] = (char)(m_splitFormat[180] + (byte)'0');
        }
        state.getScan().setSplitBoxDoc(String.copyValueOf(s_working,0,1));

        // Alternate Split, but differently for AirportException
        if (m_splitFormat[182] == (byte)0xFE)
        {
            s_working[0] = (char)(m_splitFormat[181]);
        }
        else
        {
            s_working[0] = (char)(m_splitFormat[181] + (byte)'0');
        }
        state.getScan().setSplitAltSplit(String.copyValueOf(s_working,0,1));

        // Indicate the type of Split
        if (m_splitFormat[182] == (byte)0xFF)
        {
            state.getScan().setSplitType("P");
        }
        else if (m_splitFormat[182] == (byte)0x00)
        {
            state.getScan().setSplitType("S");
        }
        else if (m_splitFormat[182] == (byte)0xFD)
        {
            state.getScan().setSplitType("A");
        }
        else if (m_splitFormat[182] == (byte)0xFE)
        {
            state.getScan().setSplitType("E");
        }

//        System.out.println("Split Type >" + state.getScan().getSplitType() + "<");

        // Set Intl/Dom
        s_working[0] = (char)(m_splitFormat[183] + (byte)'0');
        state.getScan().setSplitIntlDom(String.copyValueOf(s_working,0,1));
//        System.out.println("Split Intl/Dom >" + state.getScan().getSplitIntlDom() + "<");

        // Set Zip Code to all Blanks
        state.getScan().setSplitZipCode("     ");
//        System.out.println("Split ZipCode >" + state.getScan().getSplitZipCode() + "<");

        // The Binary Split Array is next
        if (state.getScan().getSplitType().charAt(0) == 'P')
        {
//            System.out.println("Prefix Split");
            // Prefix Split
            // This needs to be broken down from 320 to the appropriate nibbles
            for (int i=0, j=0; i<320; i=i+2)
            {
                j=i+1;
                // Determine the byte to be updated, between 1 and 160
                int i_byte = i / 2;
                byte i_hold = m_splitFormat[i_byte + 6];

                byte i_value = (byte)((int)i_hold >>> 4);
                if ((i_value >= 0) && (i_value <= 9))
                {
                    s_working[i] = (char)(i_value + '0');
                }
                else
                {
                    s_working[i] = (char)((i_value - 10) + 'A');
                }

                i_value = (byte)((int)i_hold & (int)0x000F);
                if ((i_value >= 0) && (i_value <= 9))
                {
                    s_working[j] = (char)(i_value + '0');
                }
                else
                {
                    s_working[j] = (char)((i_value - 10) + 'A');
                }
//                System.out.println("Prefix Split, index " + i + " char " + s_working[i]);
//                System.out.println("Prefix Split, index " + j + " char " + s_working[i+1]);
            }
            state.getScan().setSplitArray(String.copyValueOf(s_working,0,319));
        }
        else
        {
            // Suffix split
//            System.out.println("Suffix Split");
            for (int i=0; i<160; i++)
            {
                s_working[i] = (char)m_splitFormat[i+6];
//                System.out.println("Suffix Split, index " + i + " char " + s_working[i]);
            }
            // Pad the ramainder with spaces
            for (int i=160; i<320; i++)  s_working[i] = ' ';
            state.getScan().setSplitArray(String.copyValueOf(s_working,0,319));
        }

        return 1;
    }


    public static void main(String[] args)
    {
//        System.out.println("SplitsMaintenance in main");

//        System.out.println("Leaving main");
    }

}

