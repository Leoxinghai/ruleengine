// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleProcessorInterface.java

package com.fedex.css.ruleprocessor;

import java.rmi.RemoteException;
import java.util.Vector;

// Referenced classes of package com.fedex.css.ruleprocessor:
//            State

public interface RuleProcessorInterface
{

    public abstract State executeRules(State state)
        throws RemoteException;

    public abstract State executeRules(Vector vector)
        throws RemoteException;
}
