// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelBarCodeComponent.java

package cciij.businessActions.label.intermec;

import cciij.businessActions.label.LabelPrintException;
import java.io.PrintStream;

// Referenced classes of package cciij.businessActions.label.intermec:
//            LabelDataComponentBase

public class LabelBarCodeComponent extends LabelDataComponentBase
{

    public LabelBarCodeComponent(int ai_fieldID)
    {
        setDefaults(ai_fieldID);
    }

    public LabelBarCodeComponent(int ai_fieldID, int ai_originX, int ai_originY, int ai_fontType, int ai_fontSubType, int ai_fieldLen)
    {
        setDefaults(ai_fieldID);
        setOrigin(ai_originX, ai_originY);
        setFont(ai_fontType, ai_fontSubType);
        setDataLen(ai_fieldLen);
    }

    public void setDefaults(int ai_fieldID)
    {
        setFieldType('B');
        setFieldID(ai_fieldID);
        setOrientation(3);
        setRotation(2);
        setHeightMagnification(1);
        setWidthMagnification(1);
        setConstant(false);
        setInterpreted(false);
    }

    public String getCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        ls_command = ls_command + "i" + (mb_interpreted ? "1" : "0") + ";";
        return ls_command;
    }

    public void setInterpreted(boolean ab_interpreted)
    {
        mb_interpreted = ab_interpreted;
    }

    public static void main(String args[])
    {
        try
        {
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("Caught a Exception in LabelBarCodeComponent::main():  " + e);
            System.exit(1);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelBarCodeComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    private boolean mb_interpreted;
}
