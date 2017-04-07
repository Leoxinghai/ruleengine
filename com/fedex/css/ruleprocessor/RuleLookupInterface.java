// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleLookupInterface.java

package com.fedex.css.ruleprocessor;

import java.rmi.RemoteException;
import java.util.Date;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            RuleLookupContainer

public interface RuleLookupInterface
{

    public abstract boolean updateRules()
        throws RemoteException;

    public abstract boolean updateBusinessActions()
        throws RemoteException;

    public abstract boolean updateActionMethods()
        throws RemoteException;

    public abstract RuleLookupContainer getRules(Date date)
        throws RemoteException;

    public abstract RuleLookupContainer getBusinessActions(Date date)
        throws RemoteException;

    public abstract RuleLookupContainer getActionMethods(Date date, int i)
        throws RemoteException;

    public abstract void setTraceLevel(int i)
        throws RemoteException;

    public abstract void setPrintDiagnostics(boolean flag)
        throws RemoteException;
}
