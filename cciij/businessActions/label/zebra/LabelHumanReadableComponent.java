// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelHumanReadableComponent.java

package cciij.businessActions.label.zebra;

import cciij.businessActions.label.LabelPrintException;
import java.io.PrintStream;

// Referenced classes of package cciij.businessActions.label.zebra:
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
        setFieldType("TEXT");
        setFieldID(ai_fieldID);
        setOrientation(3);
        setRotation(0);
        setHeightMagnification(0);
        setWidthMagnification(0);
        setBorderSize(0);
        setConstant(false);
        setInverseCoordinates(0, 0, 0, 0);
    }

    public void setBorderSize(int ai_borderSize)
    {
        mi_borderSize = ai_borderSize;
    }

    public String getCommand()
        throws LabelPrintException
    {
        String command = "";
        command = command + "SETMAG " + mi_widthMagnification + " " + mi_heightMagnification + "\r\n";
        switch(mi_orientation)
        {
        case 0: // '\0'
            setFieldType("TEXT");
            break;

        case 1: // '\001'
            setFieldType("TEXT90");
            break;

        case 2: // '\002'
            setFieldType("TEXT180");
            break;

        case 3: // '\003'
            setFieldType("TEXT270");
            break;
        }
        command = command + m_fieldType + " ";
        command = command + mi_fontType + " " + mi_fontSubType + " ";
        command = command + mi_originX + " " + mi_originY + " ";
        if(mb_constant)
            command = command + ms_constantMsg;
        else
            command = command + "\\\\";
        command = command + "\r\n";
        command = command + "SETMAG 0 0\r\n";
        if(mi_upperLeftX != 0 || mi_upperLeftY != 0 || mi_lowerRightX != 0 || mi_lowerRightY != 0)
            command = command + "IL " + mi_upperLeftX + " " + mi_upperLeftY + " " + mi_lowerRightX + " " + mi_upperLeftY + " " + (mi_lowerRightY - mi_upperLeftY) + "\r\n";
        return command;
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

    private static final String m_whatVersion = "@(#) $RCSfile: LabelHumanReadableComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private int mi_borderSize;
}
