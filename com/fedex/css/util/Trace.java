// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Trace.java

package com.fedex.css.util;

import com.fedex.css.ruleprocessor.State;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.util:
//            SendToOpsLogQueue

public class Trace
{

    public static void setTraceLevel(int i)
    {
        conf = new Config();
        String s = conf.getValue("DEFAULT_TRACE_LEVEL");
        String s1 = conf.getValue("SEND_TO_OPS_LOG");
        if(s1 == null)
            s1 = "FALSE";
        if(i >= 0)
        {
            traceLevel = i;
        } else
        {
            int j;
            if(s != null)
                j = Integer.parseInt(s);
            else
                j = 127;
            traceLevel = j;
        }
        levelSet = true;
        if(s1.equals("TRUE"))
        {
            sendToOpsLog = new Boolean(true);
            sendToOLQ = new SendToOpsLogQueue();
        } else
        {
            sendToOpsLog = new Boolean(false);
        }
    }

    public static int getTraceLevel()
    {
        return traceLevel;
    }

    public static void trace(int i, String s, String s1, String s2)
    {
        String s3 = new String();
        s3 = s + ", " + s1 + ", " + s2;
        trace(i, s3);
    }

    public static void trace(int i, String s)
    {
        Date date = new Date();
        if(!levelSet)
            setTraceLevel(-1);
        String s1 = new String();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssSSSzzz");
        String s2 = simpledateformat.format(date);
        String s3 = new String();
        switch(i)
        {
        case 16: // '\020'
            s3 = "INFORMATION";
            break;

        case 8: // '\b'
            s3 = "WARNING";
            break;

        case 4: // '\004'
            s3 = "ERROR";
            break;

        case 2: // '\002'
            s3 = "CRITICAL";
            break;

        case 1: // '\001'
            s3 = "TERMINAL";
            break;
        }
        String s4 = s2 + " " + s3 + " " + s;
        if((i & traceLevel) > 0)
        {
            if(i <= 4)
            {
                System.err.println(s4);
                if(sendToOpsLog.booleanValue())
                    sendToOLQ.send(s4);
            }
            System.out.println(s4);
        }
    }

    public static void trace(int i, State state)
    {
        Date date = new Date();
        if(!levelSet)
            setTraceLevel(-1);
        String s = new String();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssSSSzzz");
        String s1 = simpledateformat.format(date);
        String s2 = new String();
        switch(i)
        {
        case 16: // '\020'
            s2 = "INFORMATION";
            break;

        case 8: // '\b'
            s2 = "WARNING";
            break;

        case 4: // '\004'
            s2 = "ERROR";
            break;

        case 2: // '\002'
            s2 = "CRITICAL";
            break;

        case 1: // '\001'
            s2 = "TERMINAL";
            break;
        }
        if((i & traceLevel) > 0)
            if(i <= 4)
                System.err.println(s1 + " " + s2 + "State object.../n" + state.toString() + "\nEnd StateObject");
            else
                System.out.println(s1 + " " + s2 + "State object.../n" + state.toString() + "\nEnd StateObject");
    }

    public Trace()
    {
    }

    public static final int VERBOSE = 64;
    public static final int DBINFO = 32;
    public static final int INFORMATION = 16;
    public static final int WARNING = 8;
    public static final int ERROR = 4;
    public static final int CRITICAL = 2;
    public static final int TERMINAL = 1;
    private static int traceLevel = 31;
    private static boolean levelSet = false;
    private static SendToOpsLogQueue sendToOLQ = null;
    private static Config conf;
    private static Boolean sendToOpsLog = null;

}
