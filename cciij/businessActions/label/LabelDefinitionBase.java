// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDefinitionBase.java

package cciij.businessActions.label;

import cciij.businessActions.LabelData;
import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;
import cciij.util.SimpleNotify;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.*;
import rmtc.util.Config;

// Referenced classes of package cciij.businessActions.label:
//            LabelDefinitionInterface, LabelPrintException, LabelFormatTypeUtilInterface, LabelTransmition, 
//            LabelComponent

public abstract class LabelDefinitionBase
    implements LabelDefinitionInterface
{

    public LabelDefinitionBase()
    {
        mi_formatNumber = -1;
        m_config = new Config("LabelDefinitionBase");
        m_notify = new SimpleNotify("LabelDefinitionBase");
        String ls_timeZone = m_config.getValue("LOCAL_TIMEZONE");
        if(ls_timeZone == null || ls_timeZone.length() <= 0)
            m_timeZone = TimeZone.getTimeZone("GMT+00:00");
        else
            m_timeZone = TimeZone.getTimeZone(ls_timeZone);
    }

    public boolean sendInit(LabelTransmition cmds)
        throws LabelPrintException
    {
        return true;
    }

    public LabelFormatTypeUtilInterface getFormatTypeUtil()
    {
        return m_formatTypeUtil;
    }

    public void setFormatTypeUtil(LabelFormatTypeUtilInterface formatTypeUtil)
    {
        m_formatTypeUtil = formatTypeUtil;
    }

    public void setFormatNumber(int ai_formatNumber)
    {
        mi_formatNumber = ai_formatNumber;
    }

    public int getFormatNumber()
    {
        return mi_formatNumber;
    }

    public void resetLabelFormat()
    {
    }

    public boolean isFormatNeeded(CCIIState a_data)
    {
        return m_formatTypeUtil.isFormatNeededForPrinter(a_data, getFormatNumber());
    }

    public boolean sendFormat(LabelTransmition cmds)
        throws LabelPrintException
    {
        if(m_components != null)
        {
            String initCmd = m_formatTypeUtil.getSendFormatInit(mi_formatNumber);
            cmds.addFormattedCommand(initCmd);
            for(int i = 0; i < m_components.length; i++)
                m_components[i].addCommand(cmds);

            cmds.addFormattedCommand(m_formatTypeUtil.getSendFormatFinalizer(mi_formatNumber));
        } else
        {
            System.out.println("Label format " + mi_formatNumber + " has not been found");
        }
        return true;
    }

    public boolean printLabel(LabelTransmition cmds, LabelData a_data)
        throws LabelPrintException
    {
        if(m_components != null)
        {
            String ls_command = new String();
            cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelInit(mi_formatNumber));
            int i = 0;
            for(int j = 0; i < m_components.length && j < a_data.getDataCount(); i++)
                if(!m_components[i].isConstant())
                    cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelComponent(m_components[i].getFieldID(), a_data.getString(j++)));

            cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelFinalizer(mi_formatNumber));
        } else
        {
            System.out.println("PrintLabel requested on label number " + mi_formatNumber + ", label not found");
        }
        return true;
    }

    public boolean printLabel(LabelTransmition cmds, CCIIState a_data)
        throws LabelPrintException
    {
        if(m_components == null)
        {
            System.out.println("Print request on label format " + mi_formatNumber + ", label not found");
            return true;
        }
        RPBScan l_scan = a_data.getScan();
        Map l_labelData = a_data.getPrintData();
        String ls_specialCommand = new String();
        Object l_paramList[] = new Object[0];
        cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelInit(mi_formatNumber));
        int i = 0;
        int j = 0;
        for(; i < m_components.length; i++)
        {
            if(l_paramList.length > 0)
                l_paramList = new Object[0];
            if(m_components[i].isConstant())
                continue;
            Object l_object = null;
            switch(m_components[i].getDataSourceObjectID())
            {
            case 1: // '\001'
            {
                l_object = a_data;
                break;
            }

            case 2: // '\002'
            {
                l_object = l_scan;
                break;
            }

            case 3: // '\003'
            {
                l_object = l_labelData;
                l_paramList = new Object[1];
                l_paramList[0] = m_components[i].getDataSourceMapEntry();
                break;
            }

            case 4: // '\004'
            {
                ls_specialCommand = getStrTime(l_scan.getSysDateTime());
                break;
            }

            case 5: // '\005'
            {
                ls_specialCommand = getStrDate(l_scan.getSysDateTime());
                break;
            }

            case 6: // '\006'
            {
                ls_specialCommand = formatAWB(l_scan.getAirbillNumber());
                break;
            }

            case 8: // '\b'
            {
                int li_pieceCount = Integer.parseInt((String)l_labelData.get("PieceQuantity"));
                if(li_pieceCount < 1 && l_scan.getHAWB().length() <= 0)
                    ls_specialCommand = formatAWB(l_scan.getAirbillNumber());
                else
                    ls_specialCommand = formatAWB(l_scan.getHAWB());
                break;
            }

            case 7: // '\007'
            {
                int li_pieceCount = Integer.parseInt((String)l_labelData.get("PieceQuantity"));
                if(li_pieceCount > 1)
                {
                    if(l_scan.getAirbillNumber().equals(l_scan.getHAWB()) || l_scan.getHAWB().length() <= 0)
                        ls_specialCommand = "      MASTER      ";
                    else
                        ls_specialCommand = formatAWB(l_scan.getAirbillNumber());
                } else
                if(li_pieceCount == 1)
                    ls_specialCommand = "";
                else
                if(l_scan.getAirbillNumber().equals(l_scan.getHAWB()) || l_scan.getHAWB().length() <= 0)
                    ls_specialCommand = "";
                else
                    ls_specialCommand = formatAWB(l_scan.getAirbillNumber());
                break;
            }
            }
            if(l_object != null)
            {
                Method l_method = m_components[i].getDataSourceMethod();
                try
                {
                    Object l_methodValue = l_method.invoke(l_object, l_paramList);
                    String ls_dataValue = "" + l_methodValue;
                    int dataLen = m_components[i].getDataLen();
                    if(dataLen > 0 && ls_dataValue.length() > dataLen)
                        ls_dataValue = ls_dataValue.substring(0, dataLen);
                    if(l_methodValue == null || ls_dataValue.length() < 1)
                        cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelComponent(m_components[i].getFieldID(), m_components[i].getDefaultValue()));
                    else
                        cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelComponent(m_components[i].getFieldID(), ls_dataValue));
                    continue;
                }
                catch(Exception e)
                {
                    System.out.println("Caught an exception:  " + e);
                    e.printStackTrace(System.out);
                    System.out.println("Ignoring.........................");
                }
            } else
            {
                cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelComponent(m_components[i].getFieldID(), ls_specialCommand));
                ls_specialCommand = "";
            }
        }

        cmds.addFormattedCommand(m_formatTypeUtil.getPrintLabelFinalizer(mi_formatNumber));
        return true;
    }

    protected String formatAWB(String as_awb)
    {
        String ls_formattedAWB = "";
        String ls_spaces = "         ";
        int li_grpBegin[] = null;
        int li_grpEnd[] = null;
        String lc_interSpace[] = null;
        int li_preSpaces = 0;
        int li_postSpaces = 0;
        int li_grpCount = 0;
        switch(as_awb.length())
        {
        case 12: // '\f'
            li_grpBegin = (new int[] {
                0, 4, 8
            });
            li_grpEnd = (new int[] {
                4, 8, 12
            });
            li_preSpaces = 0;
            li_postSpaces = 0;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 11: // '\013'
            li_grpBegin = (new int[] {
                0, 3, 7
            });
            li_grpEnd = (new int[] {
                3, 7, 11
            });
            li_preSpaces = 1;
            li_postSpaces = 0;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            if(as_awb.substring(0, 3).equals("400"))
                lc_interSpace[0] = "-";
            li_grpCount = 3;
            break;

        case 10: // '\n'
            li_grpBegin = (new int[] {
                0, 3, 7
            });
            li_grpEnd = (new int[] {
                3, 7, 10
            });
            li_preSpaces = 1;
            li_postSpaces = 1;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 9: // '\t'
            li_grpBegin = (new int[] {
                0, 3, 6
            });
            li_grpEnd = (new int[] {
                3, 6, 9
            });
            li_preSpaces = 1;
            li_postSpaces = 2;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 8: // '\b'
            li_grpBegin = (new int[] {
                0, 2, 5
            });
            li_grpEnd = (new int[] {
                2, 5, 8
            });
            li_preSpaces = 2;
            li_postSpaces = 2;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 0: // '\0'
            li_preSpaces = 0;
            li_postSpaces = 0;
            li_grpCount = 0;
            break;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            li_grpBegin = (new int[] {
                0
            });
            li_grpEnd = (new int[] {
                as_awb.length()
            });
            li_preSpaces = 0;
            li_postSpaces = 14 - as_awb.length();
            li_grpCount = 1;
            lc_interSpace = (new String[] {
                ""
            });
            break;
        }
        if(li_preSpaces > 0)
            ls_formattedAWB = ls_formattedAWB.concat(ls_spaces.substring(0, li_preSpaces));
        for(int i = 0; i < li_grpCount; i++)
        {
            ls_formattedAWB = ls_formattedAWB.concat(as_awb.substring(li_grpBegin[i], li_grpEnd[i]));
            ls_formattedAWB = ls_formattedAWB.concat(lc_interSpace[i]);
        }

        if(li_postSpaces > 0)
            ls_formattedAWB = ls_formattedAWB.concat(ls_spaces.substring(0, li_postSpaces));
        return ls_formattedAWB;
    }

    protected String getStrTime(long al_dateTime)
    {
        String ls_tmp = new String();
        Calendar l_calendar = Calendar.getInstance(m_timeZone);
        l_calendar.setTime(new Date(al_dateTime));
        int tmp = l_calendar.get(11);
        ls_tmp = "" + tmp + ":";
        tmp = l_calendar.get(12);
        if(tmp < 10)
            ls_tmp = ls_tmp + "0";
        ls_tmp = ls_tmp + tmp;
        return ls_tmp;
    }

    protected String getStrDate(long al_dateTime)
    {
        String ls_tmp = new String();
        Calendar l_calendar = Calendar.getInstance(m_timeZone);
        int tmp = l_calendar.get(5);
        ls_tmp = ls_tmp + tmp;
        switch(l_calendar.get(2))
        {
        case 0: // '\0'
            ls_tmp = ls_tmp + "JAN";
            break;

        case 1: // '\001'
            ls_tmp = ls_tmp + "FEB";
            break;

        case 2: // '\002'
            ls_tmp = ls_tmp + "MAR";
            break;

        case 3: // '\003'
            ls_tmp = ls_tmp + "APR";
            break;

        case 4: // '\004'
            ls_tmp = ls_tmp + "MAY";
            break;

        case 5: // '\005'
            ls_tmp = ls_tmp + "JUN";
            break;

        case 6: // '\006'
            ls_tmp = ls_tmp + "JUL";
            break;

        case 7: // '\007'
            ls_tmp = ls_tmp + "AUG";
            break;

        case 8: // '\b'
            ls_tmp = ls_tmp + "SEP";
            break;

        case 9: // '\t'
            ls_tmp = ls_tmp + "OCT";
            break;

        case 10: // '\n'
            ls_tmp = ls_tmp + "NOV";
            break;

        case 11: // '\013'
            ls_tmp = ls_tmp + "DEC";
            break;

        default:
            ls_tmp = ls_tmp + "UNK";
            break;
        }
        ls_tmp = ls_tmp + l_calendar.get(1);
        return ls_tmp;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelDefinitionBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    LabelComponent m_components[];
    int mi_formatNumber;
    Config m_config;
    SimpleNotify m_notify;
    LabelFormatTypeUtilInterface m_formatTypeUtil;
    TimeZone m_timeZone;
}
