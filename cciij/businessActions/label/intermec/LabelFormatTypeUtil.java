// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelFormatTypeUtil.java

package cciij.businessActions.label.intermec;

import cciij.businessActions.label.LabelFormatTypeUtilInterface;
import cciij.cciidata.CCIIState;

public class LabelFormatTypeUtil
    implements LabelFormatTypeUtilInterface
{

    public LabelFormatTypeUtil()
    {
        ms_buffer = "";
    }

    public boolean isFormatNeededForPrinter(CCIIState a_data, int formatNumber)
    {
        return false;
    }

    public String getSendFormatInit(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("<ESC>C0");
        cmd = cmd + formatCommand("<ESC>P;");
        cmd = cmd + formatCommand("E" + formatNumber + ";F" + formatNumber + ";");
        return cmd;
    }

    public String getSendFormatFinalizer(int fieldID)
    {
        return "";
    }

    public String getPrintLabelInit(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("R");
        cmd = cmd + formatCommand("<ESC>C0");
        cmd = cmd + formatCommand("<ESC>E" + formatNumber + "<CAN>");
        return cmd;
    }

    public String getPrintLabelComponent(int fieldID, String value)
    {
        return formatCommand("<ESC>F" + fieldID + "<LF>" + value);
    }

    public String getPrintLabelFinalizer(int formatNumber)
    {
        return formatCommand("<ETB>");
    }

    public String formatCommand(String cmd)
    {
        return "<STX>" + cmd + "<ETX>\n";
    }

    public void appendToCommand(String subCmd)
    {
        appendFormattedToCommand(formatCommand(subCmd));
    }

    public void appendFormattedToCommand(String formattedSubCmd)
    {
        ms_buffer += formattedSubCmd;
    }

    public String getCommand(boolean clear)
    {
        String buf = ms_buffer;
        if(clear)
            ms_buffer = "";
        return buf;
    }

    private String ms_buffer;
}
