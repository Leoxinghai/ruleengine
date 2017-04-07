// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BusinessActionEntry.java

package com.fedex.css.ruleprocessor;


public class BusinessActionEntry
{

    public BusinessActionEntry()
    {
    }

    public int getActionID()
    {
        return actionID;
    }

    public String getClassName()
    {
        return className;
    }

    public String getConstructorArg()
    {
        return constructorArg;
    }

    public void setActionID(int i)
    {
        actionID = i;
    }

    public void setClassName(String s)
    {
        className = s;
    }

    public void setConstructorArg(String s)
    {
        constructorArg = s;
    }

    private int actionID;
    private String className;
    private String constructorArg;
}
