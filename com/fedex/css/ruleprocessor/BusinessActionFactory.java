// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BusinessActionFactory.java

package com.fedex.css.ruleprocessor;

import com.fedex.css.util.Trace;
import java.lang.reflect.Constructor;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            RuleLookupHome, RuleLookup, BusinessActionEntry, BusinessAction, 
//            RuleLookupInterface, RuleLookupContainer

public class BusinessActionFactory
{

    public BusinessActionFactory()
        throws Exception
    {
        ruleLookup = null;
        businessActionTimeStamp = new Date(0L);
        actionObjects = new Hashtable();
        actionClasses = new Hashtable();
        Config config = new Config();
        String s = config.getValue("WEB_SERVER_ADDRESS");
        InitialContext initialcontext = null;
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        hashtable.put("java.naming.provider.url", "t3://" + s);
        initialcontext = new InitialContext();
        Object obj = initialcontext.lookup("ruleprocessor.RuleLookup");
        RuleLookupHome rulelookuphome = (RuleLookupHome)PortableRemoteObject.narrow(obj, com.fedex.css.ruleprocessor.RuleLookupHome.class);
        ruleLookup = (RuleLookup)PortableRemoteObject.narrow(rulelookuphome.create(), com.fedex.css.ruleprocessor.RuleLookup.class);
        updateActions();
    }

    public BusinessAction getAction(int i)
    {
        Object obj = null;
        try
        {
            updateActions();
            Integer integer = new Integer(i);
            obj = actionObjects.get(integer);
            if(obj == null)
            {
                BusinessActionEntry businessactionentry = (BusinessActionEntry)actionClasses.get(integer);
                Class class1 = Class.forName(businessactionentry.getClassName());
                if(businessactionentry.getConstructorArg() == null)
                {
                    Constructor constructor = class1.getConstructor(new Class[0]);
                    obj = constructor.newInstance(new Object[0]);
                } else
                {
                    Class class2 = Class.forName("java.lang.String");
                    Constructor constructor1 = class1.getConstructor(new Class[] {
                        class2
                    });
                    obj = constructor1.newInstance(new Object[] {
                        businessactionentry.getConstructorArg()
                    });
                }
                actionObjects.put(integer, obj);
            }
        }
        catch(Exception exception)
        {
            Trace.trace(1, "0000", "BusinessActionFactory.getAction() ", exception.toString());
            Trace.trace(1, "CONSTRUCTION OF BUSINESS ACTION FAILED...UNABLE TO CONTINUE");
            exception.printStackTrace();
            System.exit(-1);
        }
        catch(Throwable throwable) {
            Trace.trace(1, "0000", "BusinessActionFactory.getAction() ", throwable.toString());
        }
        ((BusinessAction)obj).setActionNumber(i);
        return (BusinessAction)obj;
    }

    protected void updateActions()
        throws Exception
    {
        try
        {
            RuleLookupContainer rulelookupcontainer = ruleLookup.getBusinessActions(businessActionTimeStamp);
            if(rulelookupcontainer != null)
            {
                actionClasses = new Hashtable();
                actionObjects = new Hashtable();
                Integer integer;
                BusinessActionEntry businessactionentry;
                for(Enumeration enumeration = rulelookupcontainer.getData().keys(); enumeration.hasMoreElements(); actionClasses.put(integer, businessactionentry))
                {
                    integer = (Integer)enumeration.nextElement();
                    businessactionentry = (BusinessActionEntry)rulelookupcontainer.getData().get(integer);
                }

                businessActionTimeStamp = rulelookupcontainer.getTimeStamp();
            }
        }
        catch(Exception exception)
        {
            Trace.trace(2, "0000", "BusinessActionFactory.updateActions", "Could not add class to array");
            exception.printStackTrace();
            throw exception;
        }
    }

    protected Hashtable actionClasses;
    protected Hashtable actionObjects;
    protected RuleLookupInterface ruleLookup;
    protected Date businessActionTimeStamp;
}
