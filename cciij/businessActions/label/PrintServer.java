// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException, LabelTransmition

public interface PrintServer
{

    public abstract String transmit(LabelTransmition labeltransmition, CCIIState cciistate)
        throws IOException, UnsupportedEncodingException;

    public abstract String getPrinterStatus()
        throws IOException, UnsupportedEncodingException;

    public abstract void verifyReadiness()
        throws LabelPrintException;

    public abstract String getPrinterFormatType();

    public abstract void setPrinterFormatType(String s);
}
