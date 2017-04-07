// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Action.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;

public class Action
    implements Serializable
{

    public Action()
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

    public int getPostCondClassID()
    {
        return postCondClassID;
    }

    public int getPostCondFieldID()
    {
        return postCondFieldID;
    }

    public String getPostCondVal()
    {
        return postCondVal;
    }

    public void setClassID(int i)
    {
        classID = i;
    }

    public void setMethodID(int i)
    {
        methodID = i;
    }

    public void setPostCondClassID(int i)
    {
        postCondClassID = i;
    }

    public void setPostCondFieldID(int i)
    {
        postCondFieldID = i;
    }

    public void setPostCondVal(String s)
    {
        postCondVal = s;
    }

    public String toString()
    {
        String s = "ACTION\n";
        s = s + "\tCLASS: " + classID + "\n";
        s = s + "\tMETHOD: " + methodID + "\n";
        s = s + "\tPOST CONDITION CLASS: " + postCondClassID + "\n";
        s = s + "\tPOST CONDITION FIELD: " + postCondFieldID + "\n";
        s = s + "\tPOST CONDITION VALUE: " + postCondVal + "\n";
        return s;
    }

    private int classID;
    private int methodID;
    private boolean causeStateChange;
    private int postCondClassID;
    private int postCondFieldID;
    private String postCondVal;
}
