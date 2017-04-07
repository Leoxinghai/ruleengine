// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDataComponentBase.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.monarch:
//            LabelComponentMonarchBase

public abstract class LabelDataComponentBase extends LabelComponentMonarchBase
{

    public LabelDataComponentBase()
    {
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

    public void setConstantMsg(String as_constantMsg)
    {
        ms_constantMsg = as_constantMsg;
    }

    public void setHeightMagnification(int ai_heightMagnification)
    {
        mi_heightMagnification = ai_heightMagnification;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelDataComponentBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
}
