// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ActionMethod.java

package com.fedex.css.ruleprocessor;


public class ActionMethod
{

    public ActionMethod()
    {
    }

    public int getClassID()
    {
        return classID;
    }

    public int getMethodID()
    {
        return methodID;
    }

    public String getMethodName()
    {
        return methodName;
    }

    public void setClassID(int i)
    {
        classID = i;
    }

    public void setMethodID(int i)
    {
        methodID = i;
    }

    public void setMethodName(String s)
    {
        methodName = s;
    }

    protected int classID;
    protected int methodID;
    protected String methodName;
}
