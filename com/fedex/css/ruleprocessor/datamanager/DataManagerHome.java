// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataManagerHome.java

package com.fedex.css.ruleprocessor.datamanager;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DataManager

public interface DataManagerHome
    extends EJBHome
{

    public abstract DataManager create()
        throws CreateException, RemoteException;
}
