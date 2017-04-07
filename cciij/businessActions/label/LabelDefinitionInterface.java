// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDefinitionInterface.java

package cciij.businessActions.label;

import cciij.businessActions.LabelData;
import cciij.cciidata.CCIIState;

// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException, LabelTransmition, LabelFormatTypeUtilInterface

public interface LabelDefinitionInterface
{

    public abstract boolean sendInit(LabelTransmition labeltransmition)
        throws LabelPrintException;

    public abstract boolean sendFormat(LabelTransmition labeltransmition)
        throws LabelPrintException;

    public abstract boolean printLabel(LabelTransmition labeltransmition, LabelData labeldata)
        throws LabelPrintException;

    public abstract boolean printLabel(LabelTransmition labeltransmition, CCIIState cciistate)
        throws LabelPrintException;

    public abstract void setFormatNumber(int i);

    public abstract int getFormatNumber();

    public abstract void resetLabelFormat();

    public abstract LabelFormatTypeUtilInterface getFormatTypeUtil();

    public abstract void setFormatTypeUtil(LabelFormatTypeUtilInterface labelformattypeutilinterface);

    public abstract boolean isFormatNeeded(CCIIState cciistate)
        throws LabelPrintException;
}
