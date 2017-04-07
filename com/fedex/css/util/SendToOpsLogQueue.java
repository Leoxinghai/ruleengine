// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SendToOpsLogQueue.java

package com.fedex.css.util;

import com.fedex.css.communication.CSSQueue;
import com.fedex.css.communication.JMSQueue;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.util:
//            Trace

public class SendToOpsLogQueue
{

    public SendToOpsLogQueue()
    {
        opsLogQueue = null;
        Config config = new Config();
        String s = config.getValue("WEB_SERVER_ADDRESS");
        String s1 = config.getValue("OPSLOG_QUEUE");
        jmsConnFactName = config.getValue("JMS_CONN_FACTORY");
        try
        {
            opsLogQueue = new JMSQueue(s1, s, jmsConnFactName, false);
        }
        catch(Exception exception)
        {
            Trace.trace(8, "SendToOpsLogQueue constructor could not connect to queue");
        }
    }

    public void send(String s)
    {
        try
        {
            opsLogQueue.putObject(s);
        }
        catch(Exception exception)
        {
            Trace.trace(8, "SendToOpsLogQueue.send could not send to queue");
        }
    }

    private CSSQueue opsLogQueue;
    private String jmsConnFactName;
}
