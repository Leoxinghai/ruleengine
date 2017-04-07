// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelComponentBase.java

package cciij.businessActions.label;

import java.lang.reflect.Method;

// Referenced classes of package cciij.businessActions.label:
//            LabelComponent, LabelPrintException, LabelTransmition

public abstract class LabelComponentBase
    implements LabelComponent
{

    public LabelComponentBase()
    {
        m_defaultValue = new String("");
    }

    public abstract String getCommand()
        throws LabelPrintException;

    public Method getDataSourceMethod()
    {
        return m_method;
    }

    public void setDataSourceMethod(Method a_method)
    {
        m_method = a_method;
    }

    public int getDataSourceObjectID()
    {
        return m_objectID;
    }

    public void setDataSourceObjectID(int a_objectID)
    {
        m_objectID = a_objectID;
    }

    public void setDataSourceMapEntry(String a_mapEntry)
    {
        m_mapEntry = a_mapEntry;
    }

    public String getDataSourceMapEntry()
    {
        return m_mapEntry;
    }

    public boolean addCommand(LabelTransmition cmds)
        throws LabelPrintException
    {
        cmds.addCommand(getCommand());
        return true;
    }

    public int getDataLen()
    {
        return 0;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelComponentBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    private boolean mb_constant;
    private int m_objectID;
    private Method m_method;
    private String m_mapEntry;
    private String m_defaultValue;
    public static final int STATE = 1;
    public static final int SCAN = 2;
    public static final int PRINT_DATA = 3;
    public static final int TIME = 4;
    public static final int DATE = 5;
    public static final int TRACKING_NUMBER = 6;
    public static final int AWB = 7;
    public static final int HAWB = 8;
}
