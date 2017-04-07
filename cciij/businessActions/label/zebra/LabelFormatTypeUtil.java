// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelFormatTypeUtil.java

package cciij.businessActions.label.zebra;

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
        cmd = cmd + formatCommand("! DEFINE-FORMAT FORMAT" + formatNumber + ".FMT");
        cmd = cmd + formatCommand("! 0 200 200 800 1");
        cmd = cmd + formatCommand("GAP-SENSE");
        cmd = cmd + formatCommand("SET_TOF 0");
        cmd = cmd + formatCommand("TIMEOUT 0");
        return cmd;
    }

    public String getSendFormatFinalizer(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("SETMAG 0 0");
        cmd = cmd + formatCommand("FORM");
        cmd = cmd + formatCommand("PRINT");
        return cmd;
    }

    public String getSendFormatComponent(int fieldID, String value)
    {
        return formatCommand(value);
    }

    public String getPrintLabelInit(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("! USE-FORMAT FORMAT" + formatNumber + ".FMT");
        return cmd;
    }

    public String getPrintLabelComponent(int fieldID, String value)
    {
        return formatCommand(value);
    }

    public String getPrintLabelFinalizer(int formatNumber)
    {
        String cmd = "";
        return cmd;
    }

    public String formatCommand(String cmd)
    {
        return cmd + "\r\n";
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
