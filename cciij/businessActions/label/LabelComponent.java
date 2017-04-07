// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelComponent.java

package cciij.businessActions.label;

import java.lang.reflect.Method;

// Referenced classes of package cciij.businessActions.label:
//            LabelPrintException, LabelTransmition

public interface LabelComponent
{

    public abstract boolean addCommand(LabelTransmition labeltransmition)
        throws LabelPrintException;

    public abstract String getCommand()
        throws LabelPrintException;

    public abstract boolean isConstant();

    public abstract void setConstant(boolean flag);

    public abstract int getFieldID();

    public abstract int getDataSourceObjectID();

    public abstract void setDataSourceObjectID(int i);

    public abstract Method getDataSourceMethod();

    public abstract void setDataSourceMethod(Method method);

    public abstract void setFieldID(int i);

    public abstract String getDataSourceMapEntry();

    public abstract void setDataSourceMapEntry(String s);

    public abstract String getDefaultValue();

    public abstract void setDefaultValue(String s);

    public abstract int getDataLen();
}
