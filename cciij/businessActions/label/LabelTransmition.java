// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelTransmition.java

package cciij.businessActions.label;


// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException, LabelDefinitionMux, LabelFormatTypeUtilInterface

public class LabelTransmition
{

    public LabelTransmition(String formatTypeCode, String formatLocationCode, LabelDefinitionMux mux)
        throws LabelPrintException
    {
        ms_buffer = "";
        ms_formatTypeCode = "";
        ms_formatLocationCode = "";
        m_formatTypeUtil = null;
        setFormatTypeCode(formatTypeCode);
        setFormatLocationCode(formatLocationCode);
        setFormatTypeUtil(mux.getFormatTypeUtil(ms_formatTypeCode, formatLocationCode));
    }

    public void addFormattedCommand(String cmd)
    {
        ms_buffer += cmd;
    }

    public void addCommand(String cmd)
    {
        ms_buffer += m_formatTypeUtil.formatCommand(cmd);
    }

    public String getCommand()
    {
        return ms_buffer;
    }

    public String getFormatTypeCode()
    {
        return ms_formatTypeCode;
    }

    private void setFormatTypeCode(String fmt)
    {
        ms_formatTypeCode = fmt;
    }

    public String getFormatLocationCode()
    {
        return ms_formatLocationCode;
    }

    private void setFormatLocationCode(String loc)
    {
        ms_formatLocationCode = loc;
    }

    public LabelFormatTypeUtilInterface getFormatTypeUtil()
    {
        return m_formatTypeUtil;
    }

    private void setFormatTypeUtil(LabelFormatTypeUtilInterface ftui)
    {
        m_formatTypeUtil = ftui;
    }

    private String ms_buffer;
    private String ms_formatTypeCode;
    private String ms_formatLocationCode;
    private LabelFormatTypeUtilInterface m_formatTypeUtil;
}
