// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelPrintMessageException.java

package cciij.businessActions.label;


// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException

public class LabelPrintMessageException extends LabelPrintException
{

    public LabelPrintMessageException(String as_message)
    {
        super(as_message);
        mi_msgId = 0;
        mi_msgId = 0;
    }

    public LabelPrintMessageException(String as_message, int ai_msgId)
    {
        super(as_message);
        mi_msgId = 0;
        mi_msgId = ai_msgId;
    }

    public int getErrorNumber()
    {
        return mi_msgId;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelPrintMessageException.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    private int mi_msgId;
}
