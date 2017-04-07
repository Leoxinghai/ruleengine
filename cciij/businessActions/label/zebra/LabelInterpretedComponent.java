// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelInterpretedComponent.java

package cciij.businessActions.label.zebra;

import cciij.businessActions.label.LabelPrintException;

// Referenced classes of package cciij.businessActions.label.zebra:
//            LabelHumanReadableComponent

public class LabelInterpretedComponent extends LabelHumanReadableComponent
{

    public LabelInterpretedComponent(int ai_fieldID)
    {
        super(ai_fieldID);
        setDefaults();
    }

    public LabelInterpretedComponent(int ai_fieldID, int ai_originX, int ai_originY, int ai_fontType, int ai_fontSubType)
    {
        super(ai_fieldID, ai_originX, ai_originY, ai_fontType, ai_fontSubType, 0);
        setDefaults();
    }

    private void setDefaults()
    {
        setConstant(true);
    }

    public String getCommand()
        throws LabelPrintException
    {
        String ls_command = super.getCommand();
        int li_index = ls_command.indexOf(";d");
        li_index++;
        String ls_newCommand = ls_command.substring(0, li_index);
        li_index = ls_command.indexOf(";", li_index);
        ls_newCommand = ls_newCommand + ls_command.substring(li_index + 1);
        return ls_newCommand;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelInterpretedComponent.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
}
