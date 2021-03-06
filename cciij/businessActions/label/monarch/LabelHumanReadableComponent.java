// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelHumanReadableComponent.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelPrintException;
import java.io.PrintStream;

// Referenced classes of package cciij.businessActions.label.monarch:
//            LabelDataComponentBase

public class LabelHumanReadableComponent extends LabelDataComponentBase
{

    public LabelHumanReadableComponent(int ai_fieldID)
    {
        mi_borderSize = 0;
        setDefaults(ai_fieldID);
    }

    public LabelHumanReadableComponent(int ai_fieldID, int ai_originX, int ai_originY, int ai_fontType, int ai_fontSubType, int ai_fieldLen)
    {
        mi_borderSize = 0;
        setDefaults(ai_fieldID);
        setOrigin(ai_originX, ai_originY);
        setFont(ai_fontType, ai_fontSubType);
        setDataLen(ai_fieldLen);
    }

    public void setDefaults(int ai_fieldID)
    {
        setFieldType('T');
        setFieldID(ai_fieldID);
        setOrientation(3);
        setRotation(0);
        setHeightMagnification(1);
        setWidthMagnification(1);
        setBorderSize(0);
        setConstant(false);
    }

    public void setBorderSize(int ai_borderSize)
    {
        mi_borderSize = ai_borderSize;
    }

    public String getCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        if(isConstant())
            ls_command = ls_command + "C";
        else
            ls_command = ls_command + "T," + mi_fieldID + "," + mi_dataLen + ",V";
        ls_command = ls_command + "," + mi_originX + "," + mi_originY + ",0" + "," + mi_fontType + "," + mi_heightMagnification + "," + mi_widthMagnification;
        if(mi_borderSize == 1)
            ls_command = ls_command + ",D";
        else
            ls_command = ls_command + ",B";
        ls_command = ls_command + ",L,0," + mi_orientation;
        if(isConstant())
            ls_command = ls_command + ",\"" + ms_constantMsg + "\"" + ",0";
        return ls_command;
    }

    public static void main(String args[])
    {
        try
        {
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("Caught a Exception in BarCode::main():  " + e);
            System.exit(1);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelHumanReadableComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    protected int mi_borderSize;
}
