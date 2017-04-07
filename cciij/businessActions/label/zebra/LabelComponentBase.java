// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelComponentBase.java

package cciij.businessActions.label.zebra;

import cciij.businessActions.label.LabelComponent;
import cciij.businessActions.label.LabelPrintException;

public abstract class LabelComponentBase extends cciij.businessActions.label.LabelComponentBase
    implements LabelComponent
{

    public LabelComponentBase()
    {
        mi_widthMagnification = 1;
        mi_upperLeftX = 0;
        mi_upperLeftY = 0;
        mi_lowerRightX = 0;
        mi_lowerRightY = 0;
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
        ls_coreCommand = m_fieldType + " ";
        return ls_coreCommand;
    }

    protected void setFieldType(String type)
    {
        m_fieldType = type;
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

    public void setInverseCoordinates(int ai_upperLeftX, int ai_upperLeftY, int ai_lowerRightX, int ai_lowerRightY)
    {
        mi_upperLeftX = ai_upperLeftX;
        mi_upperLeftY = ai_upperLeftY;
        mi_lowerRightX = ai_lowerRightX;
        mi_lowerRightY = ai_lowerRightY;
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

    private static final String m_whatVersion = "@(#) $RCSfile: LabelComponentBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    protected boolean mb_constant;
    protected String m_fieldType;
    protected int mi_fieldID;
    protected int mi_originX;
    protected int mi_originY;
    protected int mi_orientation;
    protected int mi_rotation;
    protected int mi_widthMagnification;
    protected int mi_upperLeftX;
    protected int mi_upperLeftY;
    protected int mi_lowerRightX;
    protected int mi_lowerRightY;
    protected String m_defaultValue;
}
