// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelFormatTypeUtil.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelFormatTypeUtilInterface;
import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;

public class LabelFormatTypeUtil
    implements LabelFormatTypeUtilInterface
{

    public LabelFormatTypeUtil()
    {
        ms_buffer = "";
    }

    public boolean isFormatNeededForPrinter(CCIIState a_data, int formatNumber)
    {
        if(a_data.getScan().getLabel3Length() == 0)
        {
            String formatNum = "," + formatNumber + ",";
            if(a_data.getScan().getLabel3Data().indexOf(formatNum) != -1)
                return false;
        }
        return true;
    }

    public String getSendFormatInit(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("{F," + formatNumber + ",A,R,E,300,200");
        return cmd;
    }

    public String getSendFormatFinalizer(int fieldID)
    {
        return "} ";
    }

    public String getPrintLabelInit(int formatNumber)
    {
        String cmd = "";
        cmd = cmd + formatCommand("{B," + formatNumber + ",N,1");
        return cmd;
    }

    public String getPrintLabelComponent(int fieldID, String value)
    {
        return formatCommand(" " + fieldID + ",\"" + value + "\"");
    }

    public String getPrintLabelFinalizer(int formatNumber)
    {
        return "}\0";
    }

    public String formatCommand(String cmd)
    {
        return cmd + "|";
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
