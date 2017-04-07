// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScannerPrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;
import java.io.*;

// Referenced classes of package cciij.businessActions.label:
//            PrintServerBase, PrintServer, LabelPrintException, LabelTransmition

public class ScannerPrintServer extends PrintServerBase
    implements PrintServer
{

    public ScannerPrintServer()
    {
    }

    public void verifyReadiness()
        throws LabelPrintException
    {
    }

    public String transmit(LabelTransmition cmds, CCIIState a_data)
        throws IOException, UnsupportedEncodingException
    {
        System.out.println("Transmit to Scanner....");
        System.out.println("Buffer size=" + cmds.getCommand().length());
        if(a_data.getScan().getLabel1Length() == 0)
        {
            a_data.getScan().setLabel1Length(cmds.getCommand().length());
            a_data.getScan().setLabel1Data(cmds.getCommand());
        } else
        if(a_data.getScan().getLabel2Length() == 0)
        {
            a_data.getScan().setLabel2Length(cmds.getCommand().length());
            a_data.getScan().setLabel2Data(cmds.getCommand());
        } else
        {
            a_data.getScan().setLabel3Length(cmds.getCommand().length());
            a_data.getScan().setLabel3Data(cmds.getCommand());
        }
        System.out.println(cmds.getCommand());
        return "";
    }

    public String getPrinterStatus()
        throws IOException, UnsupportedEncodingException
    {
        System.out.println("getPrinterStatus()");
        return "";
    }

    private static final String m_whatVersion = "@(#) $RCSfile: ScannerPrintServer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
}
