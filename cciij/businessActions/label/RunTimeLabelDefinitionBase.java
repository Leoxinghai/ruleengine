// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RunTimeLabelDefinitionBase.java

package cciij.businessActions.label;

import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.TreeMap;
import java.util.Vector;

// Referenced classes of package cciij.businessActions.label:
//            LabelDefinitionBase, LabelComponent

public class RunTimeLabelDefinitionBase extends LabelDefinitionBase
{

    public RunTimeLabelDefinitionBase()
    {
        m_componentVector = new Vector();
        CCIIState l_state = new CCIIState();
        RPBScan l_scan = new RPBScan();
        TreeMap l_map = new TreeMap();
        m_stateClass = l_state.getClass();
        m_scanClass = l_scan.getClass();
        m_mapClass = l_map.getClass();
    }

    protected boolean resetComponents()
    {
        m_componentVector = new Vector();
        return true;
    }

    protected boolean saveComponents()
    {
        Object l_objArray[] = m_componentVector.toArray();
        m_components = new LabelComponent[l_objArray.length];
        for(int i = 0; i < l_objArray.length; i++)
        {
            m_components[i] = (LabelComponent)l_objArray[i];
            m_components[i].setFieldID(i);
        }

        return true;
    }

    protected boolean addComponent()
    {
        if(m_currentComponent == null)
        {
            return false;
        } else
        {
            m_componentVector.addElement(m_currentComponent);
            m_currentComponent = null;
            m_currentClass = null;
            return true;
        }
    }

    protected boolean newComponent(String as_componentName, String printerFormatType)
    {
        try {
	    	m_currentClass = Class.forName("cciij.businessActions.label." + printerFormatType + ".Label" + as_componentName + "Component");
	        Constructor l_constructors[] = m_currentClass.getConstructors();
	        for(int i = 0; i < l_constructors.length; i++)
	        {
	            Class l_params[] = l_constructors[i].getParameterTypes();
	            if(l_params.length == 1 && l_params[0].getName().equals("int"))
	            {
	                Object l_initParams[] = new Object[1];
	                l_initParams[0] = new Integer(0);
	                m_currentComponent = (LabelComponent)l_constructors[i].newInstance(l_initParams);
	                i = l_constructors.length;
	            }
	        }
	
	        return true;
        }catch(Exception e) {
	        e.printStackTrace();
	        return false;
        }
    }

    protected boolean setComponentValue(String as_paramName, int ai_paramCount, int a_valueTypes[], int a_intValues[], boolean a_boolValues[], String a_stringValues[])
    {
        Class l_paramTypes[] = new Class[ai_paramCount];
        Object l_paramValues[] = new Object[ai_paramCount];
        Integer l_int = new Integer(0);
        Boolean l_boolean = new Boolean(false);
        String l_string = new String();
        Object l_object = new Object();
        String l_methodName = "set" + as_paramName;
        if(as_paramName.equals("DataSource"))
        {
            l_paramTypes = new Class[0];
            l_methodName = "get" + a_stringValues[1];
            if(a_valueTypes[0] == 2)
                if(a_stringValues[0].equals("STATE"))
                    a_intValues[0] = 1;
                else
                if(a_stringValues[0].equals("SCAN"))
                    a_intValues[0] = 2;
                else
                if(a_stringValues[0].equals("OTHER"))
                    a_intValues[0] = 3;
                else
                if(a_stringValues[0].equals("TIME"))
                    a_intValues[0] = 4;
                else
                if(a_stringValues[0].equals("DATE"))
                    a_intValues[0] = 5;
                else
                if(a_stringValues[0].equals("TRACKING_NUMBER"))
                    a_intValues[0] = 6;
                else
                if(a_stringValues[0].equals("AWB"))
                    a_intValues[0] = 7;
                else
                if(a_stringValues[0].equals("HAWB"))
                    a_intValues[0] = 8;
            Class l_class;
            switch(a_intValues[0])
            {
            case 1: // '\001'
                l_class = m_stateClass;
                break;

            case 2: // '\002'
                l_class = m_scanClass;
                break;

            case 3: // '\003'
                l_class = m_mapClass;
                l_paramTypes = new Class[1];
                l_methodName = "get";
                l_paramTypes[0] = l_object.getClass();
                m_currentComponent.setDataSourceMapEntry(a_stringValues[1]);
                break;

            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            default:
                l_class = null;
                break;
            }
            try
            {
                Method l_setter = l_class.getMethod(l_methodName, l_paramTypes);
                m_currentComponent.setDataSourceObjectID(a_intValues[0]);
                m_currentComponent.setDataSourceMethod(l_setter);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
        for(int i = 0; i < ai_paramCount; i++)
            switch(a_valueTypes[i])
            {
            case 1: // '\001'
                l_paramTypes[i] = Integer.TYPE;
                l_paramValues[i] = new Integer(a_intValues[i]);
                break;

            case 2: // '\002'
                l_paramTypes[i] = a_stringValues[i].getClass();
                l_paramValues[i] = a_stringValues[i];
                break;

            case 3: // '\003'
                l_paramTypes[i] = Boolean.TYPE;
                l_paramValues[i] = new Boolean(a_boolValues[i]);
                break;

            default:
                return false;
            }

        try
        {
            Method l_setter = m_currentClass.getMethod(l_methodName, l_paramTypes);
            l_setter.invoke(m_currentComponent, l_paramValues);
        }
        catch(Exception e)
        {
            System.out.println("Caught an exception:  " + e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: RunTimeLabelDefinitionBase.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    protected static final int INTEGER = 1;
    protected static final int STRING = 2;
    protected static final int BOOLEAN = 3;
    private Vector m_componentVector;
    private LabelComponent m_currentComponent;
    private Class m_currentClass;
    private static Class m_stateClass;
    private static Class m_scanClass;
    private static Class m_mapClass;
}
