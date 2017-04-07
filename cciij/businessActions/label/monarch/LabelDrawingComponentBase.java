// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDrawingComponentBase.java

package cciij.businessActions.label.monarch;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.monarch:
//            LabelComponentMonarchBase

public abstract class LabelDrawingComponentBase extends LabelComponentMonarchBase
{

    public LabelDrawingComponentBase()
    {
        mi_lineLength = 100;
    }

    public String getCommand()
        throws LabelPrintException
    {
        return getCoreDrawingCommand();
    }

    protected String getCoreDrawingCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        return ls_command;
    }

    public void setLineLength(int ai_lineLength)
    {
        mi_lineLength = ai_lineLength;
    }

    public void setWidth(int ai_width)
    {
        setWidthMagnification(ai_width);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelDrawingComponentBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    protected int mi_lineLength;
}
