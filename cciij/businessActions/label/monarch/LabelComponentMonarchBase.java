// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelComponentMonarchBase.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.*;

public abstract class LabelComponentMonarchBase extends LabelComponentBase
    implements LabelComponent
{

    public LabelComponentMonarchBase()
    {
        mc_fieldType = new char[2];
        mi_widthMagnification = 1;
        ms_constantMsg = "";
        m_defaultValue = new String("");
    }

    public String getCommand()
        throws LabelPrintException
    {
        return getCoreCommand();
    }

    protected String getCoreCommand()
    {
        String ls_coreCommand = new String();
        return ls_coreCommand;
    }

    protected void setFieldType(char ac_fieldType)
    {
        mc_fieldType[0] = ac_fieldType;
        mc_fieldType[1] = '\0';
    }

    public void setFieldID(int ai_fieldID)
    {
        mi_fieldID = ai_fieldID;
    }

    public int getFieldID()
    {
        return mi_fieldID;
    }

    public void setOrigin(int ai_originX, int ai_originY)
    {
        mi_originX = ai_originX;
        mi_originY = ai_originY;
    }

    public void setOrientation(int ai_orientation)
    {
        mi_orientation = ai_orientation;
    }

    public void setWidthMagnification(int ai_widthMagnification)
    {
        mi_widthMagnification = ai_widthMagnification;
    }

    public boolean isConstant()
    {
        return mb_constant;
    }

    public void setConstant(boolean ab_constant)
    {
        mb_constant = ab_constant;
    }

    public void setDefaultValue(String a_defaultValue)
    {
        m_defaultValue = a_defaultValue;
    }

    public String getDefaultValue()
    {
        return m_defaultValue;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelComponentMonarchBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    protected boolean mb_constant;
    protected char mc_fieldType[];
    protected int mi_fieldID;
    protected int mi_originX;
    protected int mi_originY;
    protected int mi_orientation;
    protected int mi_widthMagnification;
    protected int mi_rotation;
    protected int mi_heightMagnification;
    protected int mi_fontType;
    protected int mi_fontSubType;
    protected int mi_dataLen;
    protected String ms_constantMsg;
    protected int mi_height;
    private String m_defaultValue;
}
