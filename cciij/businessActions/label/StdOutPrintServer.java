// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StdOutPrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import java.io.*;

// Referenced classes of package cciij.businessActions.label:
//            PrintServerBase, PrintServer, LabelPrintException, LabelTransmition

public class StdOutPrintServer extends PrintServerBase
    implements PrintServer
{

    public StdOutPrintServer()
    {
    }

    public void verifyReadiness()
        throws LabelPrintException
    {
    }

    public String transmit(LabelTransmition cmds, CCIIState a_data)
        throws IOException, UnsupportedEncodingException
    {
        System.out.println("Transmit to StdOut....");
        System.out.println(cmds.getCommand());
        return "";
    }

    public String getPrinterStatus()
        throws IOException, UnsupportedEncodingException
    {
        System.out.println("getPrinterStatus()");
        return "";
    }

    private static final String m_whatVersion = "@(#) $RCSfile: StdOutPrintServer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
}
