// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LPExecPrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import cciij.util.SimpleNotify;
import java.io.*;
import java.net.Socket;
import rmtc.util.Config;

// Referenced classes of package cciij.businessActions.label:
//            PrintServerBase, LabelPrintException, PrintServer, LabelTransmition

public class LPExecPrintServer extends PrintServerBase
    implements PrintServer
{

    public LPExecPrintServer(String as_queueName)
    {
        ms_userName = "nobody";
        ms_localHostName = "intercept";
        m_config = new Config("LPDPrintServer");
        mi_jobID = 24;
        m_notify = new SimpleNotify("LPExecPrintServer");
        ms_queueName = new String(as_queueName);
        ms_userName = System.getProperty("user.name");
        if(ms_userName == null || ms_userName.length() < 1)
        {
            ms_userName = m_config.getValue("USER_NAME");
            if(ms_userName == null || ms_userName.length() < 1)
                ms_userName = new String("ccii");
        }
        String ls_directoryBase;
        if((ls_directoryBase = m_config.getValue("LABEL_PRINT_BASE_DIRECTORY")) == null)
            ls_directoryBase = "/var/fedex/ccii/spool";
        ms_directory = ls_directoryBase + "/" + ms_queueName;
        ms_dataFileName = new String[10000];
        mi_jobID = 0;
        for(int i = 1; i < 10000; i++)
        {
            String ls_jobID = getNextJobID();
            ms_dataFileName[i] = new String(ms_directory + "/dA" + ls_jobID);
        }

        ms_exec = new String[6];
        ms_exec[0] = "lp";
        ms_exec[1] = "-s";
        ms_exec[2] = "-d";
        ms_exec[3] = ms_queueName;
        ms_exec[5] = "&";
    }

    public void verifyReadiness()
        throws LabelPrintException
    {
    }

    public String getPrinterStatus()
        throws IOException, UnsupportedEncodingException
    {
        return "";
    }

    public String transmit(LabelTransmition cmds, CCIIState a_data)
        throws IOException, UnsupportedEncodingException
    {
        String ls_jobID = getNextJobID();
        String ls_tmp = "";
        String buffer = cmds.getCommand();
        connect(ms_dataFileName[mi_jobID]);
        m_out.write(buffer.getBytes("US-ASCII"));
        m_out.flush();
        disconnect();
        ms_exec[4] = ms_dataFileName[mi_jobID];
        m_notify.trace_CriticalCode_TM_3S_CHECKPOINT("transmit", "execing:", ms_exec);
        Runtime.getRuntime().exec(ms_exec);
        return "";
    }

    protected boolean connect(String as_fileName)
        throws LabelPrintException
    {
        return connect(as_fileName, false);
    }

    protected boolean connect(String as_fileName, boolean a_append)
        throws LabelPrintException
    {
        try
        {
            m_out = new FileOutputStream(as_fileName, a_append);
        }
        catch(Exception e)
        {
            System.out.println("LPExecPrintServer:connect(String)  Caught:  " + e);
            e.printStackTrace();
            throw new LabelPrintException("LPDPrintServer:connect(String)  Caught:  " + e);
        }
        return true;
    }

    protected boolean disconnect()
        throws LabelPrintException
    {
        try
        {
            m_out.close();
        }
        catch(Exception e)
        {
            throw new LabelPrintException("Caught Exception in disconnect from LPExec:  " + e);
        }
        return true;
    }

    protected String getNextJobID()
    {
        if(mi_jobID >= 9999)
            mi_jobID = 1;
        else
            mi_jobID++;
        if(mi_jobID > 999)
            return "" + mi_jobID;
        if(mi_jobID > 99)
            return "0" + mi_jobID;
        if(mi_jobID > 9)
            return "00" + mi_jobID;
        else
            return "000" + mi_jobID;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LPExecPrintServer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    private Socket m_connection;
    private InputStream m_in;
    private OutputStream m_out;
    private String ms_hostName;
    private int mi_port;
    private int mi_timeout;
    private String ms_userName;
    private String ms_queueName;
    private String ms_localHostName;
    private Config m_config;
    private int mi_jobID;
    private String ms_dataFileName[];
    private String ms_directory;
    private byte mb_queueName[];
    private byte mb_hostName[];
    private byte mb_userName[];
    private String ms_exec[];
    private SimpleNotify m_notify;
}
