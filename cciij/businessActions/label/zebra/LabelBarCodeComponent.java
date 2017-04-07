// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelBarCodeComponent.java

package cciij.businessActions.label.zebra;

import cciij.businessActions.label.LabelPrintException;
import java.io.PrintStream;

// Referenced classes of package cciij.businessActions.label.zebra:
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
        setFieldID(ai_fieldID);
        setOrientation(3);
        setRotation(2);
        setHeightMagnification(1);
        setWidthMagnification(-1);
        setConstant(false);
        setInterpreted(false);
    }

    private void setTypeAndRatio()
    {
        int width = 1;
        switch(mi_fontType)
        {
        case 2: // '\002'
            m_barcodeType = "I2OF5";
            m_ratio = 25;
            width = 2;
            break;

        case 4: // '\004'
            m_barcodeType = "39";
            m_ratio = 25;
            width = 2;
            break;

        case 6: // '\006'
            m_barcodeType = "128";
            m_ratio = 0;
            width = 1;
            break;

        case 8: // '\b'
            m_barcodeType = "CODABAR";
            m_ratio = 25;
            width = 2;
            break;

        case 3: // '\003'
        case 5: // '\005'
        case 7: // '\007'
        default:
            System.out.println("Trying to use an unexpected barcode font:  " + mi_fontType + ":" + mi_fontSubType);
            m_barcodeType = "UNKNOWN";
            m_ratio = -1;
            break;
        }
        if(mi_widthMagnification == -1)
            setWidthMagnification(width);
    }

    public String getCommand()
        throws LabelPrintException
    {
        String command = "";
        switch(mi_orientation)
        {
        case 0: // '\0'
        default:
            setFieldType("BARCODE");
            break;

        case 1: // '\001'
            setFieldType("VBARCODE");
            break;
        }
        command = command + m_fieldType + " ";
        setTypeAndRatio();
        command = command + m_barcodeType + " ";
        command = command + mi_widthMagnification + " ";
        command = command + m_ratio + " ";
        command = command + mi_heightMagnification + " ";
        command = command + mi_originX + " " + mi_originY + " ";
        if(mb_constant)
            command = command + ms_constantMsg;
        else
            command = command + "\\\\";
        return command;
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

    private static final String m_whatVersion = "@(#) $RCSfile: LabelBarCodeComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private boolean mb_interpreted;
    private String m_barcodeType;
    private int m_ratio;
}
