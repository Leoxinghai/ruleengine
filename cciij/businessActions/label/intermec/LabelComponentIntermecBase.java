// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelComponentIntermecBase.java

package cciij.businessActions.label.intermec;

import cciij.businessActions.label.*;

public abstract class LabelComponentIntermecBase extends LabelComponentBase
    implements LabelComponent
{

    public LabelComponentIntermecBase()
    {
        mc_fieldType = new char[2];
        mi_widthMagnification = 1;
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
        ls_coreCommand = new String(mc_fieldType) + mi_fieldID + ";";
        ls_coreCommand = ls_coreCommand + "o" + mi_originX + "," + mi_originY + ";";
        ls_coreCommand = ls_coreCommand + "f" + mi_orientation + ";";
        ls_coreCommand = ls_coreCommand + "w" + mi_widthMagnification + ";";
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

    private static final String m_whatVersion = "@(#) $RCSfile: LabelComponentIntermecBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    private boolean mb_constant;
    private char mc_fieldType[];
    private int mi_fieldID;
    private int mi_originX;
    private int mi_originY;
    private int mi_orientation;
    private int mi_rotation;
    private int mi_widthMagnification;
    private String m_defaultValue;
}
