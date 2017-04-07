// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelFormatTypeUtilInterface.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;

public interface LabelFormatTypeUtilInterface
{

    public abstract String getSendFormatInit(int i);

    public abstract String getPrintLabelInit(int i);

    public abstract String getPrintLabelComponent(int i, String s);

    public abstract String getPrintLabelFinalizer(int i);

    public abstract String formatCommand(String s);

    public abstract String getSendFormatFinalizer(int i);

    public abstract boolean isFormatNeededForPrinter(CCIIState cciistate, int i);
}
