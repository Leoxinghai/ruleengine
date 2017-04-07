// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelBoxComponent.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.monarch:
//            LabelDrawingComponentBase

public class LabelBoxComponent extends LabelDrawingComponentBase
{

    public LabelBoxComponent(int ai_fieldID)
    {
        setDefaults(ai_fieldID);
    }

    public LabelBoxComponent(int ai_fieldID, int ai_originX, int ai_originY, int ai_length, int ai_height, int ai_width)
    {
        setDefaults(ai_fieldID);
        setOrigin(ai_originX, ai_originY);
        setLineLength(ai_length);
        setWidth(ai_width);
        setHeight(ai_height);
    }

    public void setHeight(int ai_height)
    {
        mi_height = ai_height;
    }

    private void setDefaults(int ai_fieldID)
    {
        setConstant(true);
        setFieldType('W');
        setFieldID(ai_fieldID);
        setOrientation(3);
        setWidth(1);
        setHeight(1);
    }

    public String getCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        ls_command = ls_command + "Q," + mi_originX + "," + mi_originY + "," + (mi_originX + mi_height) + "," + (mi_originY + mi_lineLength) + "," + mi_widthMagnification + ",\"\"";
        return ls_command;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelBoxComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
}
