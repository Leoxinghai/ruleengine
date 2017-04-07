// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BusinessAction.java

package com.fedex.css.ruleprocessor;

import com.fedex.css.util.Trace;
import java.lang.reflect.Method;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            RuleLookupHome, RuleLookup, State, ActionMethod, 
//            RuleLookupInterface, RuleLookupContainer

public class BusinessAction
{

    public BusinessAction()
        throws Exception
    {
        ruleLookup = null;
        lookupTimeStamp = new Date(0L);
        Config config = new Config();
        String s = config.getValue("WEB_SERVER_ADDRESS");
        InitialContext initialcontext = null;
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        hashtable.put("java.naming.provider.url", "t3://" + s);
        initialcontext = new InitialContext(hashtable);
        Object obj = initialcontext.lookup("ruleprocessor.RuleLookup");
        RuleLookupHome rulelookuphome = (RuleLookupHome)PortableRemoteObject.narrow(obj, com.fedex.css.ruleprocessor.RuleLookupHome.class);
        ruleLookup = (RuleLookup)PortableRemoteObject.narrow(rulelookuphome.create(), com.fedex.css.ruleprocessor.RuleLookup.class);
    }

    public State actionEntry(State state, int i)
    {
        try
        {
            updateMethods();
            Method method = (Method)methods.get(new Integer(i));
            Object aobj[] = {
                state
            };
            State state1 = (State)method.invoke(this, aobj);
            return state1;
        }
        catch(Exception exception)
        {
            Trace.trace(2, "0000", getClass().getName() + ".actionEntry", "Error invoking method: " + i);
            exception.printStackTrace();
            return null;
        }
    }

    protected void updateMethods()
        throws Exception
    {
        Class class1 = getClass();
        Class class2 = Class.forName("com.fedex.css.ruleprocessor.State");
        try
        {
            RuleLookupContainer rulelookupcontainer = ruleLookup.getActionMethods(lookupTimeStamp, actionNumber);
            if(rulelookupcontainer != null)
            {
                Hashtable hashtable = rulelookupcontainer.getData();
                methods = new Hashtable();
                Integer integer;
                Method method;
                for(Enumeration enumeration = rulelookupcontainer.getData().keys(); enumeration.hasMoreElements(); methods.put(integer, method))
                {
                    integer = (Integer)enumeration.nextElement();
                    ActionMethod actionmethod = (ActionMethod)hashtable.get(integer);
                    String s = actionmethod.getMethodName();
                    method = class1.getMethod(s, new Class[] {
                        class2
                    });
                }

                lookupTimeStamp = rulelookupcontainer.getTimeStamp();
            }
        }
        catch(Exception exception)
        {
            Trace.trace(2, "0000", "BusinessAction.updateMethods", "Error getting methods");
            exception.printStackTrace();
            throw exception;
        }
    }

    public void setActionNumber(int i)
    {
        actionNumber = i;
    }

    protected Hashtable methods;
    protected RuleLookupInterface ruleLookup;
    protected Date lookupTimeStamp;
    protected int actionNumber;
}
