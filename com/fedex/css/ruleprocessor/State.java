// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   State.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;

public abstract class State
    implements Serializable
{

    public State()
    {
    }

    public final void set(int i, int j, String s)
    {
        if(i == 0)
            set(j, s);
        else
            setContainedClass(i, j, s);
    }

    public abstract void setContainedClass(int i, int j, String s);

    public final Object get(int i, int j)
    {
        if(i == 0)
            return get(j);
        else
            return getContainedClass(i, j);
    }

    public abstract Object getContainedClass(int i, int j);

    public String getRuleSetName()
    {
        return ruleSetName;
    }

    public int getStatusCd()
    {
        return statusCd;
    }

    public boolean getAbortFlag()
    {
        return abortFlag;
    }

    public void setRuleSetName(String s)
    {
        ruleSetName = s;
    }

    public void setStatusCd(int i)
    {
        statusCd = i;
    }

    public void setAbortFlag(boolean flag)
    {
        abortFlag = flag;
    }

    private void set(int i, String s)
    {
        switch(i)
        {
        case 0: // '\0'
            ruleSetName = s;
            break;

        case 1: // '\001'
            statusCd = Integer.parseInt(s);
            break;

        case 2: // '\002'
            abortFlag = Boolean.getBoolean(s);
            break;
        }
    }

    protected Object get(int i)
    {
        Object obj = null;
        switch(i)
        {
        case 0: // '\0'
            obj = ruleSetName;
            break;

        case 1: // '\001'
            obj = new Integer(statusCd);
            break;

        case 2: // '\002'
            obj = new Boolean(abortFlag);
            break;

        default:
            obj = null;
            break;
        }
        return obj;
    }

    public String toString()
    {
        String s = new String("State Object\n");
        s = s + "\t RuleSetName: " + ruleSetName + "\n";
        s = s + "\t StatusCd: " + statusCd + "\n";
        s = s + "\t AbortFlag: " + abortFlag + "\n";
        return s;
    }

    protected String ruleSetName;
    protected int statusCd;
    protected boolean abortFlag;
    public static final int STATECLASS = 0;
    public static final int RULE_SET_NAME = 0;
    public static final int STATUS_CODE = 1;
    public static final int ABORT_FLAG = 2;
}
