// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LPDPrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import java.io.*;
import java.net.*;
import rmtc.util.Config;

// Referenced classes of package cciij.businessActions.label:
//            PrintServerBase, LabelPrintException, PrintServer, LabelTransmition

public class LPDPrintServer extends PrintServerBase
    implements PrintServer
{

    public LPDPrintServer(String as_HostName, int ai_port, String as_queueName, int ai_timeout)
    {
        ms_userName = "nobody";
        ms_localHostName = "intercept";
        m_config = new Config("LPDPrintServer");
        mi_jobID = 24;
        if(as_HostName == null || as_HostName.length() <= 0)
            ms_hostName = new String("localhost");
        else
            ms_hostName = new String(as_HostName);
        mi_port = ai_port;
        ms_queueName = new String(as_queueName);
        mi_timeout = ai_timeout;
        ms_userName = System.getProperty("user.name");
        if(ms_userName == null || ms_userName.length() < 1)
        {
            ms_userName = m_config.getValue("USER_NAME");
            if(ms_userName == null || ms_userName.length() < 1)
                ms_userName = new String("ccii");
        }
        try
        {
            ms_localHostName = InetAddress.getLocalHost().getHostName();
        }
        catch(UnknownHostException e) { }
        if(ms_localHostName == null || ms_localHostName.length() < 1)
        {
            ms_localHostName = m_config.getValue("HOST_NAME");
            if(ms_localHostName == null || ms_localHostName.length() < 1)
                ms_localHostName = new String("intercept");
        }
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
        throws IOException, UnsupportedEncodingException,LabelPrintException
    {
        String ls_jobID = getNextJobID();
        String ls_tmp = "";
        String buffer = cmds.getCommand();
        int li_controlFileLen = 0;
        int li_dataFileLen = 0;
        String ls_controlFile = "";
        ls_controlFile = ls_controlFile + "H" + ms_localHostName + "\n";
        ls_controlFile = ls_controlFile + "J" + ms_queueName + "-" + mi_jobID + "\n";
        ls_controlFile = ls_controlFile + "P" + ms_userName + "\n";
        ls_controlFile = ls_controlFile + "C\n";
        ls_controlFile = ls_controlFile + "L" + ms_userName + "\n";
        ls_controlFile = ls_controlFile + "B\n";
        ls_controlFile = ls_controlFile + "K1\n";
        ls_controlFile = ls_controlFile + "O\n";
        ls_controlFile = ls_controlFile + "Tlabel.dat\n";
        ls_controlFile = ls_controlFile + "Fda" + ls_jobID + ms_localHostName + "\n";
        ls_controlFile = ls_controlFile + "fdA" + ls_jobID + ms_localHostName + "\n";
        ls_controlFile = ls_controlFile + "Uda" + ls_jobID + ms_localHostName + "\n";
        ls_controlFile = ls_controlFile + "Nlabel.dat\n";
        ls_controlFile = ls_controlFile + "A0\n";
        li_controlFileLen = ls_controlFile.length();
        connect();
        m_out.write(2);
        m_out.write(ms_queueName.getBytes("US-ASCII"));
        m_out.write(10);
        if(m_in.read() != 0)
        {
            disconnect();
            throw new LabelPrintException("Failed to get an awknoledgement that the LPD is ready to receve the files");
        }
        li_dataFileLen = buffer.length();
        m_out.write(3);
        ls_tmp = "" + li_dataFileLen + " dA" + ls_jobID + ms_localHostName + "\n";
        m_out.write(ls_tmp.getBytes("US-ASCII"));
        m_out.flush();
        if(m_in.read() != 0)
        {
            disconnect();
            throw new LabelPrintException("Failed to write the data file Header");
        }
        m_out.write(buffer.getBytes("US-ASCII"));
        m_out.write(0);
        m_out.flush();
        if(m_in.read() != 0)
        {
            disconnect();
            throw new LabelPrintException("Failed to write the data file Body");
        }
        m_out.write(2);
        ls_tmp = "" + li_controlFileLen + " cA" + ls_jobID + ms_localHostName + "\n";
        m_out.write(ls_tmp.getBytes("US-ASCII"));
        m_out.flush();
        if(m_in.read() != 0)
        {
            disconnect();
            throw new LabelPrintException("Failed to write the control file Header");
        }
        m_out.write(ls_controlFile.getBytes("US-ASCII"));
        m_out.write(0);
        m_out.flush();
        if(m_in.read() != 0)
        {
            disconnect();
            throw new LabelPrintException("Failed to write the control file Body");
        } else
        {
            disconnect();
            return "";
        }
    }

    protected boolean connect()
        throws LabelPrintException
    {
        try
        {
            m_connection = new Socket(ms_hostName, mi_port);
            m_in = m_connection.getInputStream();
            m_out = m_connection.getOutputStream();
            m_connection.setTcpNoDelay(true);
            m_connection.setSoTimeout(mi_timeout);
        }
        catch(Exception e)
        {
            throw new LabelPrintException("Caught Exception in connect to LPD:  " + e);
        }
        return true;
    }

    protected boolean disconnect()
        throws LabelPrintException
    {
        try
        {
            m_in.close();
            m_out.close();
            m_connection.close();
        }
        catch(Exception e)
        {
            throw new LabelPrintException("Caught Exception in disconnect from LPD:  " + e);
        }
        return true;
    }

    protected synchronized int getNextSharedJobID()
    {
        if(mi_sharedJobID >= 9999)
            mi_sharedJobID = 1;
        else
            mi_sharedJobID++;
        return mi_sharedJobID;
    }

    protected String getNextJobID()
    {
        mi_jobID = getNextSharedJobID();
        if(mi_jobID > 999)
            return "" + mi_jobID;
        if(mi_jobID > 99)
            return "0" + mi_jobID;
        if(mi_jobID > 9)
            return "00" + mi_jobID;
        else
            return "000" + mi_jobID;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LPDPrintServer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
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
    private static int mi_sharedJobID = 30;

}
