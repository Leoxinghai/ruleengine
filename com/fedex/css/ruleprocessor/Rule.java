// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Rule.java

package com.fedex.css.ruleprocessor;

import java.io.Serializable;
import java.util.Vector;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            Condition, Action, State

public class Rule
    implements Serializable
{

    public Rule()
    {
        conditions = new Vector();
        actions = new Vector();
    }

    public boolean match(State state)
    {
        boolean flag = true;
        for(int i = 0; i < conditions.size() && flag; i++)
        {
            Condition condition = (Condition)conditions.elementAt(i);
            if(!condition.match(state))
                flag = false;
        }

        return flag;
    }

    public void addCondition(Condition condition)
    {
        conditions.add(condition);
    }

    public void addAction(Action action)
    {
        actions.add(action);
    }

    public Vector getConditions()
    {
        return conditions;
    }

    public Vector getActions()
    {
        return actions;
    }

    public String toString()
    {
        String s = "RULE: \n";
        for(int i = 0; i < conditions.size(); i++)
            s = s + ((Condition)conditions.elementAt(i)).toString();

        for(int j = 0; j < actions.size(); j++)
            s = s + ((Action)actions.elementAt(j)).toString();

        return s;
    }

    private Vector conditions;
    private Vector actions;
}
