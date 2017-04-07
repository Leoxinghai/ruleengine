// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleLookupContainer.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

public class RuleLookupContainer
    implements Serializable
{

    public RuleLookupContainer()
    {
    }

    public void setTimeStamp(Date date)
    {
        timeStamp = date;
    }

    public void setData(Hashtable hashtable)
    {
        data = hashtable;
    }

    public Date getTimeStamp()
    {
        return timeStamp;
    }

    public Hashtable getData()
    {
        return data;
    }

    Date timeStamp;
    Hashtable data;
}
