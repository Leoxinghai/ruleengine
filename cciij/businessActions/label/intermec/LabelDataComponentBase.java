// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDataComponentBase.java

package cciij.businessActions.label.intermec;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.intermec:
//            LabelComponentIntermecBase

public abstract class LabelDataComponentBase extends LabelComponentIntermecBase
{

    public LabelDataComponentBase()
    {
        ms_constantMsg = "";
    }

    public String getCommand()
        throws LabelPrintException
    {
        return getCoreDataCommand();
    }

    protected String getCoreDataCommand()
        throws LabelPrintException
    {
        String ls_coreCommand = super.getCommand();
        ls_coreCommand = ls_coreCommand + "r" + mi_rotation + ";";
        ls_coreCommand = ls_coreCommand + "h" + mi_heightMagnification + ";";
        if(mi_fontSubType >= 0)
            ls_coreCommand = ls_coreCommand + "c" + mi_fontType + "," + mi_fontSubType + ";";
        else
            ls_coreCommand = ls_coreCommand + "c" + mi_fontType + ";";
        if(isConstant())
            ls_coreCommand = ls_coreCommand + "d3," + ms_constantMsg + ";";
        else
            ls_coreCommand = ls_coreCommand + "d0," + mi_dataLen + ";";
        return ls_coreCommand;
    }

    public void setFont(int ai_fontType, int ai_fontSubType)
    {
        mi_fontType = ai_fontType;
        mi_fontSubType = ai_fontSubType;
    }

    public void setRotation(int ai_rotation)
    {
        mi_rotation = ai_rotation;
    }

    public void setDataLen(int ai_dataLen)
    {
        mi_dataLen = ai_dataLen;
    }

    public int getDataLen()
    {
        return mi_dataLen;
    }

    public void setConstantMsg(String as_constantMsg)
    {
        ms_constantMsg = as_constantMsg;
    }

    public void setHeightMagnification(int ai_heightMagnification)
    {
        mi_heightMagnification = ai_heightMagnification;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelDataComponentBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    private int mi_rotation;
    private int mi_heightMagnification;
    private int mi_fontType;
    private int mi_fontSubType;
    private int mi_dataLen;
    private String ms_constantMsg;
}
