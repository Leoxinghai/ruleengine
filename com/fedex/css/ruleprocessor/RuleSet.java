// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleSet.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;

public class RuleSet
    implements Serializable
{

    public RuleSet()
    {
        _setNm = "";
        _ruleNbr = 0x1869f;
        _conditionNbr = 0x1869f;
        _classIdNbr = 0x1869f;
        _fieldIdNbr = 0x1869f;
        _operationNbr = 0x1869f;
        _valueDesc = "";
        _compClassIdNbr = 0x1869f;
        _compFieldIdNbr = 0x1869f;
    }

    public RuleSet(String s, int i, int j, int k, int l, int i1, String s1, 
            int j1, int k1)
    {
        _setNm = "";
        _ruleNbr = 0x1869f;
        _conditionNbr = 0x1869f;
        _classIdNbr = 0x1869f;
        _fieldIdNbr = 0x1869f;
        _operationNbr = 0x1869f;
        _valueDesc = "";
        _compClassIdNbr = 0x1869f;
        _compFieldIdNbr = 0x1869f;
        setSetNm(s);
        setRuleNbr(i);
        setConditionNbr(j);
        setClassIdNbr(k);
        setFieldIdNbr(l);
        setOperationNbr(i1);
        setValueDesc(s1);
        setCompClassIdNbr(j1);
        setCompFieldIdNbr(k1);
    }

    public String getSetNm()
    {
        return _setNm;
    }

    public int getRuleNbr()
    {
        return _ruleNbr;
    }

    public int getConditionNbr()
    {
        return _conditionNbr;
    }

    public int getClassIdNbr()
    {
        return _classIdNbr;
    }

    public int getFieldIdNbr()
    {
        return _fieldIdNbr;
    }

    public int getOperationNbr()
    {
        return _operationNbr;
    }

    public String getValueDesc()
    {
        return _valueDesc;
    }

    public int getCompClassIdNbr()
    {
        return _compClassIdNbr;
    }

    public int getCompFieldIdNbr()
    {
        return _compFieldIdNbr;
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

    public void setConditionNbr(int i)
    {
        _conditionNbr = i;
    }

    public void setClassIdNbr(int i)
    {
        _classIdNbr = i;
    }

    public void setFieldIdNbr(int i)
    {
        _fieldIdNbr = i;
    }

    public void setOperationNbr(int i)
    {
        _operationNbr = i;
    }

    public void setValueDesc(String s)
    {
        if(s == null)
            _valueDesc = "";
        else
            _valueDesc = s;
    }

    public void setCompClassIdNbr(int i)
    {
        _compClassIdNbr = i;
    }

    public void setCompFieldIdNbr(int i)
    {
        _compFieldIdNbr = i;
    }

    public String toString()
    {
        String s = "ruleSet Object \n";
        s = s + "  setNm         : " + _setNm + "\n";
        s = s + "  ruleNbr       : " + _ruleNbr + "\n";
        s = s + "  conditionNbr  : " + _conditionNbr + "\n";
        s = s + "  classIdNbr    : " + _classIdNbr + "\n";
        s = s + "  fieldIdNbr    : " + _fieldIdNbr + "\n";
        s = s + "  operationNbr  : " + _operationNbr + "\n";
        s = s + "  valueDesc     : " + _valueDesc + "\n";
        s = s + "  compClassNbr  : " + _compClassIdNbr + "\n";
        s = s + "  compFieldNbr  : " + _compFieldIdNbr + "\n";
        return s;
    }

    private String _setNm;
    private int _ruleNbr;
    private int _conditionNbr;
    private int _classIdNbr;
    private int _fieldIdNbr;
    private int _operationNbr;
    private String _valueDesc;
    private int _compClassIdNbr;
    private int _compFieldIdNbr;
}
