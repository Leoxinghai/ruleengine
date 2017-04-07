// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleProcessorClient.java

package com.fedex.css.ruleprocessor;

import java.io.PrintStream;
import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            RuleProcessorHome, RuleProcessor, RuleProcessorInterface, State

public class RuleProcessorClient
{

    public static void main(String args[])
    {
        RuleProcessorClient ruleprocessorclient;
        try
        {
            ruleprocessorclient = new RuleProcessorClient();
        }
        catch(Exception exception)
        {
            System.out.println("EXCEPTION: " + exception);
            exception.printStackTrace();
        }
    }

    public RuleProcessorClient()
        throws Exception
    {
        rp = null;
        m_config = null;
        m_webServerAddress = null;
        m_config = new Config();
        m_webServerAddress = "t3://" + m_config.getValue("WEB_SERVER_ADDRESS");
        System.out.println("web address is:: " + m_webServerAddress);
        rp = getRuleProcessor();
    }

    public State sendState(State state)
    {
        boolean flag = false;
        try
        {
            state = rp.executeRules(state);
        }
        catch(Exception exception)
        {
            System.out.println("EXCEPTION: " + exception);
        }
        return state;
    }

    private InitialContext getInitialContext()
        throws Exception
    {
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        hashtable.put("java.naming.provider.url", m_webServerAddress);
        try
        {
            InitialContext initialcontext = new InitialContext(hashtable);
            return initialcontext;
        }
        catch(Exception exception)
        {
            System.out.println(exception);
            throw exception;
        }
    }

    private RuleProcessor getRuleProcessor()
        throws Exception
    {
        try
        {
            InitialContext initialcontext = getInitialContext();
            Object obj = initialcontext.lookup("com.fedex.css.RuleProcessor");
            RuleProcessorHome ruleprocessorhome = (RuleProcessorHome)PortableRemoteObject.narrow(obj, com.fedex.css.ruleprocessor.RuleProcessorHome.class);
            RuleProcessor ruleprocessor = (RuleProcessor)PortableRemoteObject.narrow(ruleprocessorhome.create(), com.fedex.css.ruleprocessor.RuleProcessor.class);
            return ruleprocessor;
        }
        catch(Exception exception)
        {
            System.out.println(exception);
            throw exception;
        }
    }

    private RuleProcessor rp;
    private Config m_config;
    private String m_webServerAddress;
}
