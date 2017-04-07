// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelInterface.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;

// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException

public interface LabelInterface
{

    public abstract void doit(CCIIState cciistate)
        throws LabelPrintException;
}
