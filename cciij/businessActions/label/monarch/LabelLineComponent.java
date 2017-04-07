// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelLineComponent.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.monarch:
//            LabelDrawingComponentBase

public class LabelLineComponent extends LabelDrawingComponentBase
{

    public LabelLineComponent(int ai_fieldID)
    {
        setDefaults(ai_fieldID);
    }

    public LabelLineComponent(int ai_fieldID, int ai_originX, int ai_originY, int ai_length, int ai_width)
    {
        setDefaults(ai_fieldID);
        setOrigin(ai_originX, ai_originY);
        setLineLength(ai_length);
        setWidth(ai_width);
    }

    private void setDefaults(int ai_fieldID)
    {
        setConstant(true);
        setFieldType('L');
        setFieldID(ai_fieldID);
        setOrientation(0);
        setWidth(4);
    }

    public String getCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        ls_command = ls_command + "L,V," + mi_originX + "," + mi_originY + "," + mi_orientation + "," + mi_lineLength + "," + mi_widthMagnification + ",\"\"";
        return ls_command;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelLineComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
}
