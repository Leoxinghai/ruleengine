//*************************************************************************
//
// Filename: SplitsLabel.java
//
// Description:  SPLITS Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/SplitsLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   04/06/04  Gary Rockwood   Initial creation
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import java.lang.*;
import java.util.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;


public class SplitsLabel extends FileBasedLabel
{
    protected    byte[]  m_splitFormat = new byte[300];
    protected    String[]  SuffixLabel1 = {"3", "5", "7", "9", "B", "D"};
    protected    String[]  SuffixLabel2 = {"4", "6", "8", "A", "C", "E"};
    protected    String[]  PrefixLabel1 = {"F", "H", "J", "L", "N", "P", "R", "T", "V", "X", "Z", "/", "%"};
    protected    String[]  PrefixLabel2 = {"G", "I", "K", "M", "O", "Q", "S", "U", "W", "Y", "$", "+", "-"};
    protected    String[]  Services = {"", "P1", "XS", "E2", "USPS", "SOS", "F0", "F1", "F2", "F3"};
    protected    String[]  Special = {"ADG ", "IDG ", "ICE "};
    protected    String s_hexCRC = "";
    protected    String[] s_list = new String[5];
    protected    String s_splitType = "";
    protected    String s_suffixCount = "";
    protected    int i_suffixCount = 0;
    protected    char[] s_suffixWorking = new char[160];
    protected    char[] s_prefixWorking = new char[330];
    protected    Split split = null;
    protected    Boolean l_readFormatFile;
    protected    Boolean l_sendFormat;


    private static final String m_whatVersion = "@(#) $RCSfile: SplitsLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    //    LabelDefinitionInterface m_definition;
    public SplitsLabel(String as_LabelName) throws Exception
    {
        super(as_LabelName);
    }


    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    protected LabelData getLabelData(CCIIState state)
    {
        String s_barString1 = "";
        String s_barString2 = "";
        char[] c_destWorking = new char[5];

//        System.out.println("SplitsLabel start");

        // Set up the area to put Print Label information
        Map l_printData = state.m_printData;

        l_readFormatFile = (Boolean)state.m_printData.get("READ_FORMAT");

        // Only attempt to gather data for the label if SEND_FORMAT is false
        l_sendFormat = (Boolean)l_printData.get("SEND_FORMAT");

        if ((l_sendFormat != null) && (l_sendFormat.booleanValue() == true))
        {
            // Do not perform the CheckAirbill or GetABFormCode
        }
        else
        {
            // Read in the Splits File specified by Split Number
            if (ReadSplit(state) == true)
            {
                // If this is i_labelCount == 1, first time thru
                if (i_labelCount == 1)
                {
                    // Deteremine the number of labels needed to complete the split
                    if (m_splitFormat[182] == (byte)0xFF)
                    {
                        // This needs to be broken down from 320 to the appropriate nibbles
                        for (int i=0, j=0; i<319; i=i+2)
                        {
                            j=i+1;
                            // Determine the byte to be updated, between 1 and 160
                            int i_byte = i / 2;
                            byte i_hold = m_splitFormat[i_byte + 6];
//                            System.out.println("Full byte (" + i + ") >" + i_hold);

                            byte i_value = (byte)(((int)i_hold >>> 4) & 0x0F);
//                            System.out.println("Left nibble >" + i_value);
                            if ((i_value >= 0) && (i_value <= 9))
                            {
                                s_prefixWorking[i] = (char)(i_value + '0');
                            }
                            else
                            {
                                s_prefixWorking[i] = (char)((i_value - 10) + 'A');
                            }
 
                            i_value = (byte)((int)i_hold & (int)0x0F);
//                            System.out.println("Right nibble >" + i_value);
                            if ((i_value >= 0) && (i_value <= 9))
                            {
                                s_prefixWorking[j] = (char)(i_value + '0');
                            }
                            else
                            {
                                s_prefixWorking[j] = (char)((i_value - 10) + 'A');
                            }
                        }

                        // Zero out the remaining bytes for label 15
                        for (int i=320; i<330; i++)
                        {
                            s_prefixWorking[i] = (char)'0';
                        }

                        // Prefix Split, always 15 labels
                        i_labelMax = 15;
                        i_suffixCount = 1;    // Used in Label 1
                    }
                    else 
                    {
                        // Move from byte array to char array
                        for (int i=0; i<160; i++)
                        {
                            s_suffixWorking[i] = (char)m_splitFormat[i+6];
                        }
 
                        // Non-prefix, count the number of Suffix or Airport entries
                        i_suffixCount = 0;
                        for (int i=0; i<32; i++)
                        {
                            if(m_splitFormat[(i*5) + 6] != ' ')
                            {
                                i_suffixCount++;
                            }
                        }

                        // 6 suffix to a label so devide by 6, but account for the remainder
                        if ((i_suffixCount % 6) > 0)
                        {
                            i_labelMax = (i_suffixCount / 6) + 1;
                        }
                        else
                        {
                            i_labelMax = i_suffixCount / 6;
                        }
                        // Add 2 for Label 1 and 2
                        i_labelMax = i_labelMax + 2;
                    }
                } 
            } 

//            System.out.println("Label count " + i_labelMax + " suffixCount " + i_suffixCount);

            // Clear any previous entries
            l_printData.clear();

            // Build the common top line of label
            String s_topLine = state.getScan().getLocationCode() + 
                               "   SPLIT # " + 
                               Integer.toString(m_splitFormat[0]) +
                               "        " + 
                               Integer.toString(i_labelCount) + 
                               " of " + 
                               Integer.toString(i_labelMax);
            l_printData.put("SPLITTopLine", s_topLine);

            // Build label based on l_labelCount
            switch (i_labelCount)
            {
                case 1:
                    // Get the destination
                    for (int i=0; i<5; i++)
                    {
                       c_destWorking[i] = (char)m_splitFormat[i+1];
                    }
                    l_printData.put("SPLITSecondLine", "SPLT Dest ID:");
                    l_printData.put("SPLITDestId", String.copyValueOf(c_destWorking, 0, 5));
                    l_printData.put("SPLITSplitDesc", split.getSplitDesc());

                    // Clean out any previous line entries
                    for (int i=0; i<5; i++)
                    {
                        s_list[i] = "";
                    }

                    if (m_splitFormat[182] == (byte)0xFF)
                    {
                        // This is a Prefix Split
                        BuildPrefixList(state);
                        s_splitType = "P";
                    }
                    else if (m_splitFormat[182] == (byte)0x00)
                    {
                        // This is a Suffix Split
                        s_splitType = "S";
                        BuildSuffixList("SUFFIXES:");
                        for (int i=0; i<5; i++)
                        {
                             c_destWorking[i] = ' ';
                        }
                    }
                    else if (m_splitFormat[182] == (byte)0xFD)
                    {
                        // This is an Airport Split
                        s_splitType = "A";
                        BuildSuffixList("AIRPORTS:");
                    }
                    else
                    {
                        // This is an Airport Exception Split
                        s_splitType = "E";
                        BuildSuffixList("AIRxEXCP:");
                    }

                    l_printData.put("SPLITList1", s_list[0]);
                    l_printData.put("SPLITList2", s_list[1]);
                    l_printData.put("SPLITList3", s_list[2]);
                    l_printData.put("SPLITList4", s_list[3]);
                    l_printData.put("SPLITList5", s_list[4]);

                    // Build the barcode for Label 1
                    BuildHexCRC(state);

                    // Build the suffix count using base 36
                    s_suffixCount = "";
                    char[] c_count = new char[1];
                    if (i_suffixCount >0 && i_suffixCount < 10)
                    {
                        c_count[0] = (char)(i_suffixCount + '0');
                    }
                    else
                    {
                        c_count[0] = (char)((i_suffixCount - 10) + 'A');
                    }

                    s_suffixCount = String.copyValueOf(c_count);

                    s_barString2 = "11" +
                                   state.getScan().getSplitNumber() +
                                   s_hexCRC + 
                                   s_splitType +
                                   s_suffixCount +
                                   String.copyValueOf(c_destWorking, 0, 5);

                    l_printData.put("SPLITBar2", s_barString2);
                    break;

                case 2:
                    s_barString2 = "2";
                    l_printData.put("SPLITSplitDesc", "");

                    // Build the Domestic or International
                    switch (m_splitFormat[183])
                    {
                        case 1:
                            l_printData.put("SPLITIntlDom", "Allow: DOMESTIC");
                            break;
                        case 2:
                            l_printData.put("SPLITIntlDom", "Allow: INTERNATIONAL");
                            break;
                        case 3:
                            l_printData.put("SPLITIntlDom", "Allow: DOMESTIC & INTL");
                            break;
                    }
                    char[] c_char = new char[10];
                    for (int i=0; i<10; i++)    c_char[i] = '0';
                    c_char[0] = (char)(m_splitFormat[183] + (byte)'0');
                    s_barString2 = s_barString2 + String.copyValueOf(c_char,0, 1);


                    // Build the Delivery option
                    switch (m_splitFormat[176])
                    {
                        case 1:
                        case 4:
                        case 5:
                            l_printData.put("SPLITList4", "Delivery: WEEKDAY");
                            break;
                        case 2:
                        case 6:
                            l_printData.put("SPLITList4", "Delivery: SATURDAY");
                            break;
                        case 3:
                        case 7:
                            l_printData.put("SPLITList4", "Delivery: WEEKDAY & SATURDAY");
                            break;
                    }
                    c_char[0] = (char)(m_splitFormat[176] + (byte)'0');
                    s_barString2 = s_barString2 + String.copyValueOf(c_char, 0, 1);

                    // Build the Services allowed for this split
                    l_printData.put("SPLITServiceText", "Services:");
                    String s_serviceString = "";
                    int i_value = 0;
                    for (int i=0; i<10; i++)    c_char[i] = '0';
                    for (int i=0; i<10; i++)
                    {
                        if (m_splitFormat[166 + i] != ' ')
                        {
                            i_value = m_splitFormat[166 + i] - '0';
                            if (i_value > 0)
                            {
                                s_serviceString = s_serviceString + Services[i_value] + " ";
                                c_char[i_value] = '1';
                            }
                        }
                    }
                    l_printData.put("SPLITServices", s_serviceString);
                    s_barString2 = s_barString2 + String.copyValueOf(c_char, 0, 10);
             
                    // Build the Special Handling
                    String s_special = "Special Handling: ";

                    i_value = 0;
                    for (int i=0; i<3; i++)
                    {
                        c_char[i] = (char)(m_splitFormat[177 + i] + (byte)'0');
                        if (c_char[i] == '1')
                        {
                            s_special = s_special + Special[i];
                            i_value = 1;
                        }
                    }

                    if (i_value == 0)
                    {
                        s_special = s_special + "None";
                    }
                    l_printData.put("SPLITList5", s_special);
                    s_barString2 = s_barString2 + String.copyValueOf(c_char, 0, 3);

                    // If this is an AIRwExcp split there are 4 more characters for label 2
                    if (s_splitType == "E")
                    {
                        // Offset for Station exclusion
                        if (m_splitFormat[180] > 9)
                        {
                            // Make a 2 digit number
                            s_barString2 = s_barString2 + Integer.toString((int)m_splitFormat[180]);
                        }
                        else
                        {
                            // Preceed the value with a "0"
                            s_barString2 = s_barString2 + "0" + Integer.toString((int)m_splitFormat[180]);
                        }

                        // Offset for Station inclusion
                        if (m_splitFormat[181] > 9)
                        {
                            // Make a 2 digit number
                            s_barString2 = s_barString2 + Integer.toString((int)m_splitFormat[181]);
                        }
                        else
                        {
                            // Preceed the value with a "0"
                            s_barString2 = s_barString2 + "0" + Integer.toString((int)m_splitFormat[181]);
                        }
                    }

                    // Define the I2of5 barcode
                    l_printData.put("SPLITBar3", s_barString2); 
                    break;

                default:
                    l_printData.put("SPLITSplitDesc", "");

                    if (m_splitFormat[182] == (byte)0xFF)
                    {
                        // Prefix Split, put Prefix values 13 nibbles at a time
                        s_barString1 = PrefixLabel1[i_labelCount - 3] + 
                                       String.copyValueOf(s_prefixWorking, ((i_labelCount - 3) * 26), 13);

                        l_printData.put("SPLITBar1", s_barString1);

                        if (i_labelCount != i_labelMax)
                        {
                            // Put the second barcode
                            s_barString2 = PrefixLabel2[i_labelCount - 3] +
                                           String.copyValueOf(s_prefixWorking, ((i_labelCount - 3) * 26) + 13, 13);

                            l_printData.put("SPLITBar2", s_barString2);
                        }
                    }
                    else
                    {
                        // Suffix or Airport or Airport Exception, put 3 at a time
                        s_barString1 = SuffixLabel1[i_labelCount - 3] +
                                       String.copyValueOf(s_suffixWorking, ((i_labelCount - 3) * 30), 15);

                        s_barString2 = SuffixLabel2[i_labelCount - 3] +
                                       String.copyValueOf(s_suffixWorking, (((i_labelCount - 3) * 30) + 15), 15);
                    }
                    l_printData.put("SPLITBar1", s_barString1);
                    l_printData.put("SPLITBar2", s_barString2);
                    break;
            } 

            // Build the info for the current label based on i_labelCount
        }

        return null;
    } 


    private void BuildPrefixList(CCIIState state)
    {
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
        s_buildString = "PREFIXES: ";

        int j = 0;
        for (int i=0; i<36; i++)
        {
        for (int k=0; k<35; k++)
        {
            j = (k * 36) + i;
            i_byte = j / 8;
            i_bit  = j % 8; 

            if ((m_splitFormat[i_byte + 6] & mask[i_bit]) != 0)
            {
                if (i_count > 0)
                {
                    // Still in a string
                    c_lastGood[0] = firstChar[i];
                    c_lastGood[1] = secondChar[k];
                }
                else
                {
                    // First of a possible string or its a single 
                    c_prefix[0] = firstChar[i];
                    c_prefix[1] = secondChar[k];

                    s_buildString = s_buildString + String.copyValueOf(c_prefix);
                    
                }
                i_count++;
            }
            else
            {
                if (i_count == 0)
               {
                    // The last one was also a 0, do nothing
                }
                else if (i_count == 1)
                {
                    // The last one was a single, just add a ', '
                    s_buildString = s_buildString + " ";
                }
                else
                {
                    // This is the end of a string, add '-' and the last Prefix with a ','
                    s_buildString = s_buildString +  "-" + String.copyValueOf(c_lastGood) + " ";
                }
                i_count = 0;
            }

            // Check the length of the line
            if (s_buildString.length() >= MAX_CHARACTERS)
            {
                // Move the output to the list
                s_list[i_listCount] = s_buildString;
                s_buildString = "          ";
                i_listCount++;
            }
        }
        }
        // Is there a partial line or a string open
        if (i_count > 1)
        {
            // There is a run, close it out with lastGood
            s_buildString = s_buildString +  "-" + String.copyValueOf(c_lastGood);
        }
        if (s_buildString.length() > 10)
        {
            s_list[i_listCount] = s_buildString;
        }
    }


    private void BuildSuffixList(String s_type)
    {
        int i_entryCount = 0;
        int i_lineCount = 0;

        // Put the list of Suffix's into the lines
        for (int i=0; i<i_suffixCount; i++)
        {
            if (i_entryCount == 0)
            {
                if (i_lineCount == 0)
                {
                   s_list[i_lineCount] = s_type;
                }
                else
                {
                    s_list[i_lineCount] = "         ";
                }
            }

            if (s_splitType == "E")
            {
                // this is an Airport Exception Split
                if (i >= m_splitFormat[180])
                {
                    if (i >= m_splitFormat[181])
                    {
                        // Plus these locations
                        s_list[i_lineCount] = s_list[i_lineCount] + " +" +
                                              String.copyValueOf(s_suffixWorking, (i * 5), 5);
                    }
                    else
                    {
                        // Minus these locations
                        s_list[i_lineCount] = s_list[i_lineCount] + " -" +
                                              String.copyValueOf(s_suffixWorking, (i * 5), 5);
                    }
                }   
                else
                {
                    // Include these airports
                    s_list[i_lineCount] = s_list[i_lineCount] + " " +
                                          String.copyValueOf(s_suffixWorking, (i * 5), 5);
                }
            }
            else
            {
                // Suffix or Airport Split
                // Start putting the entries into the list
                s_list[i_lineCount] = s_list[i_lineCount] + " " +   
                                      String.copyValueOf(s_suffixWorking, (i * 5), 5);
            }

            // Keep count of the entires on this line
            i_entryCount++;

            // If there are 8 entries on this line go to the next line, 
            // except for AIRxExcp which should be 7
            int i_limit = 8;
            if (s_splitType == "E")
            {
                i_limit = 7;
            }

            if (i_entryCount == i_limit)
            {
                i_lineCount++;
                i_entryCount = 0;
            }
        }
    }


    private void BuildHexCRC(CCIIState state)
    {
        int[] i_part = new int[4];
        char[] c_part = new char[5];

        // Clear out any previous values
        s_hexCRC = "";

        // Break apart the CRC nibbles
        i_part[0] = (m_splitFormat[189] >>> (byte)4) & (byte)0x0F;
        i_part[1] = m_splitFormat[189] & (byte)0x0F;
        i_part[2] = (m_splitFormat[190] >>> (byte)4) & (byte)0x0F;
        i_part[3] = m_splitFormat[190] & (byte)0x0F;

        for (int i=0; i<4; i++)
        {
            if (i_part[i] >= 0 && i_part[i] <= 9)
            {
                c_part[i] = (char)(i_part[i] + '0');
            }
            else
            {
                c_part[i] = (char)((i_part[i] - 10) + 'A');
            }
        }
        s_hexCRC = String.copyValueOf(c_part, 0, 5);
    }


    ////////////////////////////////////////////////////////////////////
    //
    //    ReadSplit  Read an existing Split from the Split database table
    //
    ////////////////////////////////////////////////////////////////////
    private boolean ReadSplit(CCIIState state)
    {
        // Read the split
        try
        {
            split = m_db.fetchSplit(Integer.parseInt(state.getScan().getSplitNumber()));
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in AstraLabel");
            return false;
        }

        if (split == null)
        {
            state.getScan().setErrorNumber(Messages.EM_INVALID_SPLIT);
            CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","Split not found in AstraLabel");
            return false;
        }
        else
        {
            m_splitFormat = split.getSplitValue();
        }
        return true;
    }


    public static void main(String args[])
    {
//        System.out.println("SplitsLabel.main()");
//
//        try
//        {
//            CCIIState l_data = new CCIIState();
//
//            RPBScan l_scan = new RPBScan();
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
//
//            System.out.println("Got the dummy object...");
//            BusinessActionInterface l_label = new SplitsLabel("SplitsLabel");
//            System.out.println("Got the SplitsLabel Object...");
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
//        System.out.println("SplitsLabel.main()...end");
//
//        return;
    }
}
