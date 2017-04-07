// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileBasedLabelDefinition.java

package cciij.businessActions.label;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;


import rmtc.util.Config;

// Referenced classes of package cciij.businessActions.label:
//            RunTimeLabelDefinitionBase, LabelPrintException, LabelFormatTypeUtilInterface, LabelDefinitionMux

public class FileBasedLabelDefinition extends RunTimeLabelDefinitionBase
{

    public FileBasedLabelDefinition(int ai_formatID)
    {
        setFormatNumber(ai_formatID);
    }

    public FileBasedLabelDefinition()
    {
        this(17);
    }

    public FileBasedLabelDefinition(String as_fileName)
    {
        this(17, as_fileName, "");
    }

    public FileBasedLabelDefinition(int ai_formatID, String as_fileName, String printerFormatType)
    {
        this(ai_formatID);
        readLabelFormatFile(as_fileName, printerFormatType);
    }

    public static void addSupportedLabelFormats(LabelDefinitionMux definitions, Config config, int formatNumber)
        throws LabelPrintException
    {
        String locations = config.getValue("LABEL_DEFINITION_LOCATION_LIST");
        if(locations == null)
            locations = "ALL";
        StringTokenizer tok = new StringTokenizer(locations, ",");
        Vector locs = new Vector();
        for(; tok.hasMoreTokens(); locs.add(tok.nextToken()));
        String locList[] = new String[0];
        locList = (String[])locs.toArray(locList);
        String origLoc = config.getLocationCode();
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < locList.length; j++)
            {
                config.setLocationCode(locList[j]);
                String filename = null;
                if((filename = config.getValue("LABEL_DEFINITION_FILE_NAME_" + ms_supportedFormatTypes[i].toUpperCase())) == null)
                    throw new LabelPrintException("LABEL_DEFINITION_FILE_NAME_" + ms_supportedFormatTypes[i].toUpperCase() + " not defined in config file for:  " + config.getGroup() + " in location:  " + locList[j]);

                FileBasedLabelDefinition def = new FileBasedLabelDefinition(formatNumber, filename, ms_supportedFormatTypes[i]);
                try
                {
                    Class cls = Class.forName("cciij.businessActions.label." + ms_supportedFormatTypes[i] + ".LabelFormatTypeUtil");
                    def.setFormatTypeUtil((LabelFormatTypeUtilInterface)cls.newInstance());
                }
                catch(Exception e)
                {
                    System.out.println("Failed to construct a FormatTypeUtil for the label type of:  " + ms_supportedFormatTypes[i]);
                    e.printStackTrace(System.out);
                    throw new LabelPrintException("Failed to construct a FormatTypeUtil for the label type of:  " + ms_supportedFormatTypes[i] + "\n  With a full name of:  cciij.businessActions.label." + ms_supportedFormatTypes[i] + ".LabelFormatTypeUtil");
                }
                definitions.addLabelDefinition(ms_supportedFormatTypes[i], locList[j], def);
            }

        }

    }

    public void resetLabelFormat()
    {
        readLabelFormatFile();
    }

    public boolean readLabelFormatFile()
    {
        return readLabelFormatFile(ms_fileName);
    }

    public boolean readLabelFormatFile(String as_fileName)
    {
        return readLabelFormatFile(as_fileName, true, "");
    }

    public boolean readLabelFormatFile(String as_filename, String printerFormatType)
    {
        return readLabelFormatFile(as_filename, true, printerFormatType);
    }

    private boolean readLabelFormatFile(String as_fileName, boolean resetComponents, String printerFormatType)
    {
        int currentComponent = 0;
        boolean l_inComponent = false;
        String ls_name = "";
        String ls_values[] = new String[5];
        int li_values[] = new int[5];
        boolean lb_values[] = new boolean[5];
        int l_valueTypes[] = new int[5];
        int li_cur = 0;
        boolean l_name = true;
        if(resetComponents)
            ms_fileName = as_fileName;
        if(resetComponents)
            resetComponents();
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader(as_fileName);
            br = new BufferedReader(fr);
            StreamTokenizer l_tokenizer = new StreamTokenizer(br);
            l_tokenizer.slashSlashComments(true);
            l_tokenizer.slashStarComments(true);
            l_tokenizer.commentChar(35);
            l_tokenizer.quoteChar(34);
            l_tokenizer.quoteChar(39);
            l_tokenizer.wordChars(95, 95);
            l_tokenizer.eolIsSignificant(true);
            boolean l_moreTokens = true;
            int currentTokenType;
            while(l_moreTokens)
                switch(currentTokenType = l_tokenizer.nextToken())
                {
                default:
                    break;

                case -2:
                    if(!l_name)
                    {
                        Double ld_nval = new Double(l_tokenizer.nval);
                        li_values[li_cur] = ld_nval.intValue();
                        l_valueTypes[li_cur] = 1;
                        li_cur++;
                    }
                    break;

                case -3:
                case 34: // '"'
                case 39: // '\''
                    if(l_name)
                    {
                        ls_name = l_tokenizer.sval;
                        l_name = false;
                        break;
                    }
                    if(!l_inComponent && !ls_name.equals("include"))
                        break;
                    ls_values[li_cur] = l_tokenizer.sval;
                    if(ls_values[li_cur].equals("true"))
                    {
                        lb_values[li_cur] = true;
                        l_valueTypes[li_cur] = 3;
                        li_cur++;
                        break;
                    }
                    if(ls_values[li_cur].equals("false"))
                    {
                        lb_values[li_cur] = false;
                        l_valueTypes[li_cur] = 3;
                        li_cur++;
                    } else
                    {
                        l_valueTypes[li_cur] = 2;
                        li_cur++;
                    }
                    break;

                case -1:
                    if(resetComponents)
                        saveComponents();
                    l_moreTokens = false;
                    break;

                case 10: // '\n'
                    if(ls_name.length() != 0)
                    {
                        l_name = true;
                        if(l_inComponent)
                        {
                            if(ls_name.equals("END"))
                            {
                                addComponent();
                                l_inComponent = false;
                            } else
                            {
                                setComponentValue(ls_name, li_cur, l_valueTypes, li_values, lb_values, ls_values);
                            }
                        } else
                        if(ls_name.equals("include"))
                        {
                            readLabelFormatFile(ls_values[0], false, printerFormatType);
                        } else
                        {
                            newComponent(ls_name, printerFormatType);
                            l_inComponent = true;
                        }
                    }
                    li_cur = 0;
                    ls_name = "";
                    break;
                }
        }
        catch(Exception e)
        {
            boolean flag = false;
            return flag;
        }
        finally
        {
            try
            {
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }
            catch(IOException e)
            {
                System.out.println("Failed to close the Label Definition File:  " + e);
                e.printStackTrace(System.out);
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        FileBasedLabelDefinition l_labelDev;
        try
        {
            l_labelDev = new FileBasedLabelDefinition("input.dat");
        }
        catch(Exception e) { }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: FileBasedLabelDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    private String ms_fileName;
    private static final String ms_fileNamePrefix = "LABEL_DEFINITION_FILE_NAME_";
    private static final String ms_supportedFormatTypes[] = {
        "intermec", "zebra"
    };
    private static final int mi_supportedFormatTypeCount = 2;

    private Logger logger = Logger.getLogger(FileBasedLabelDefinition.class);
}
