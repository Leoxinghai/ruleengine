// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LPDFastPrintServer.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import java.io.*;
import java.net.*;
import rmtc.util.Config;

// Referenced classes of package cciij.businessActions.label:
//            PrintServerBase, LabelPrintException, PrintServer, LabelTransmition

public class LPDFastPrintServer extends PrintServerBase
    implements PrintServer
{

    public LPDFastPrintServer(String as_HostName, int ai_port, String as_queueName, int ai_timeout)
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
        byte l_heloByte[];
        try
        {
            l_heloByte = ms_queueName.getBytes("US-ASCII");
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
            return;
        }
        m_heloSequence = new byte[l_heloByte.length + 2];
        m_heloSequence[0] = 2;
        for(int j = 0; j < l_heloByte.length; j++)
            m_heloSequence[j + 1] = l_heloByte[j];

        m_heloSequence[l_heloByte.length + 1] = 10;
        if(m_controlFile == null)
        {
            m_controlFile = new byte[10000][];
            m_controlFileHeader = new byte[10000][];
            ms_dataFileHeaderSuffix = new String[10000];
            mi_jobID = 0;
            for(int i = 1; i < 10000; i++)
            {
                String ls_jobID = getNextJobID();
                String ls_controlFile = "";
                ls_controlFile = ls_controlFile + "H" + ms_localHostName + "\n";
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
                byte lb_controlFileBytes[];
                try
                {
                    lb_controlFileBytes = ls_controlFile.getBytes("US-ASCII");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                    return;
                }
                m_controlFile[i] = new byte[lb_controlFileBytes.length + 1];
                for(int j = 0; j < lb_controlFileBytes.length; j++)
                    m_controlFile[i][j] = lb_controlFileBytes[j];

                m_controlFile[i][lb_controlFileBytes.length] = 0;
                String ls_tmp = "" + ls_controlFile.length() + " cA" + ls_jobID + ms_localHostName + "\n";
                byte lb_tmpBytes[];
                try
                {
                    lb_tmpBytes = ls_tmp.getBytes("US-ASCII");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                    return;
                }
                m_controlFileHeader[i] = new byte[lb_tmpBytes.length + 1];
                m_controlFileHeader[i][0] = 2;
                for(int j = 0; j < lb_tmpBytes.length; j++)
                    m_controlFileHeader[i][j + 1] = lb_tmpBytes[j];

                ms_dataFileHeaderSuffix[i] = new String(" dA" + ls_jobID + ms_localHostName + "\n");
            }

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
        throws IOException, UnsupportedEncodingException
    {
        String ls_jobID = getNextJobID();
        String ls_tmp = "";
        String buffer = cmds.getCommand();
        int li_controlFileLen = 0;
        int li_dataFileLen = 0;
        connect();
        m_out.write(m_heloSequence);
        if(m_in.read() != 0)
            throw new LabelPrintException("Failed to get an awknoledgement that the LPD is ready to receve the files");
        li_dataFileLen = buffer.length();
        m_out.write(3);
        ls_tmp = "" + li_dataFileLen + ms_dataFileHeaderSuffix[mi_jobID];
        m_out.write(ls_tmp.getBytes("US-ASCII"));
        m_out.flush();
        if(m_in.read() != 0)
            throw new LabelPrintException("Failed to write the data file Header");
        m_out.write(buffer.getBytes("US-ASCII"));
        m_out.write(0);
        m_out.flush();
        if(m_in.read() != 0)
            throw new LabelPrintException("Failed to write the data file Body");
        m_out.write(m_controlFileHeader[mi_jobID]);
        m_out.flush();
        if(m_in.read() != 0)
            throw new LabelPrintException("Failed to write the control file Header");
        m_out.write(m_controlFile[mi_jobID]);
        m_out.flush();
        if(m_in.read() != 0)
        {
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

    private static final String m_whatVersion = "@(#) $RCSfile: LPDFastPrintServer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
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
    private static byte m_controlFile[][] = (byte[][])null;
    private static byte m_controlFileHeader[][] = (byte[][])null;
    private byte m_heloSequence[];
    private static String ms_dataFileHeaderSuffix[] = null;
    private static LPDFastPrintServer m_holdStaticData = new LPDFastPrintServer("localhost", 515, "crap", 1000);

}
