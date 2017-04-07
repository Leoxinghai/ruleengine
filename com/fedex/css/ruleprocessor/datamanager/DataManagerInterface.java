// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataManagerInterface.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface DataManagerInterface
{

    public abstract void closeConnection()
        throws RemoteException, Exception;

    public abstract boolean commitTransaction()
        throws RemoteException, Exception;

    public abstract boolean rollbackTransaction()
        throws RemoteException, Exception;

    public abstract RuleAction fetchRuleAction(String s, int i, int j)
        throws RemoteException, SQLException;

    public abstract RuleAction fetchRuleAction()
        throws RemoteException, SQLException;

    public abstract RuleAction fetchRuleAction(int i, String s)
        throws RemoteException, SQLException;

    public abstract RuleAction fetchNextRuleAction()
        throws RemoteException, SQLException;

    public abstract void saveRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException;

    public abstract void updateRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException;

    public abstract void removeRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException;

    public abstract RuleSet fetchRuleSet(String s, int i, int j)
        throws RemoteException, SQLException;

    public abstract RuleSet fetchRuleSet()
        throws RemoteException, SQLException;

    public abstract RuleSet fetchNextRuleSet()
        throws RemoteException, SQLException;

    public abstract void saveRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException;

    public abstract void updateRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException;

    public abstract void removeRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException;

    public abstract BusinessActionEntry fetchBusinessActionEntry()
        throws RemoteException, SQLException;

    public abstract BusinessActionEntry fetchNextBusinessActionEntry()
        throws RemoteException, SQLException;

    public abstract ActionMethod fetchActionMethod(int i)
        throws RemoteException, SQLException;

    public abstract ActionMethod fetchActionMethod()
        throws RemoteException, SQLException;

    public abstract ActionMethod fetchNextActionMethod()
        throws RemoteException, SQLException;
}
