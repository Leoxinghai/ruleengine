// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleAction.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;

public class RuleAction
    implements Serializable
{

    public RuleAction()
    {
        _setNm = "";
        _ruleNbr = 0x1869f;
        _stepNbr = 0x1869f;
        _factoryActionTypeNbr = 0x1869f;
        _actionMethodNbr = 0x1869f;
        _pcClassIDNbr = 0x1869f;
        _pcFieldIDNbr = 0x1869f;
        _pcValue = "";
    }

    public RuleAction(String s, int i, int j, int k, int l)
    {
        _setNm = "";
        _ruleNbr = 0x1869f;
        _stepNbr = 0x1869f;
        _factoryActionTypeNbr = 0x1869f;
        _actionMethodNbr = 0x1869f;
        _pcClassIDNbr = 0x1869f;
        _pcFieldIDNbr = 0x1869f;
        _pcValue = "";
        setSetNm(s);
        setRuleNbr(i);
        setStepNbr(j);
        setFactoryActionTypeNbr(k);
        setActionMethodNbr(l);
    }

    public String getSetNm()
    {
        return _setNm;
    }

    public int getRuleNbr()
    {
        return _ruleNbr;
    }

    public int getStepNbr()
    {
        return _stepNbr;
    }

    public int getFactoryActionTypeNbr()
    {
        return _factoryActionTypeNbr;
    }

    public int getActionMethodNbr()
    {
        return _actionMethodNbr;
    }

    public int getPcClassIDNbr()
    {
        return _pcClassIDNbr;
    }

    public int getPcFieldIDNbr()
    {
        return _pcFieldIDNbr;
    }

    public String getPcValue()
    {
        return _pcValue;
    }

    public void setSetNm(String s)
    {
        if(s == null)
            _setNm = "";
        else
            _setNm = s;
    }

    public void setRuleNbr(int i)
    {
        _ruleNbr = i;
    }

    public void setStepNbr(int i)
    {
        _stepNbr = i;
    }

    public void setFactoryActionTypeNbr(int i)
    {
        _factoryActionTypeNbr = i;
    }

    public void setActionMethodNbr(int i)
    {
        _actionMethodNbr = i;
    }

    public void setPcClassIDNbr(int i)
    {
        _pcClassIDNbr = i;
    }

    public void setPcFieldIDNbr(int i)
    {
        _pcFieldIDNbr = i;
    }

    public void setPcValue(String s)
    {
        _pcValue = s;
    }

    public String toString()
    {
        String s = "RuleAction Object \n";
        s = s + "  setNm                   : " + _setNm + "\n";
        s = s + "  ruleNbr                 : " + _ruleNbr + "\n";
        s = s + "  stepNbr                 : " + _stepNbr + "\n";
        s = s + "  factoryActionTypeNbr    : " + _factoryActionTypeNbr + "\n";
        s = s + "  actionMethodNbr         : " + _actionMethodNbr + "\n";
        return s;
    }

    private String _setNm;
    private int _ruleNbr;
    private int _stepNbr;
    private int _factoryActionTypeNbr;
    private int _actionMethodNbr;
    private int _pcClassIDNbr;
    private int _pcFieldIDNbr;
    private String _pcValue;
}
