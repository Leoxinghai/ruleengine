// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Condition.java

package com.fedex.css.ruleprocessor;

import com.fedex.css.util.Trace;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
// Referenced classes of package com.fedex.css.ruleprocessor:
//            State

public class Condition
    implements Serializable
{

    public Condition()
    {
        setName = new String();
        value = new String();
    }

    public boolean match(State state)
    {
        boolean flag = false;
        obj2obj = false;
        Object obj = state.get(classID, fieldID);
        compareVal = null;
        if(value.compareTo("RP_FIELD_TO_FIELD") == 0)
        {
            obj2obj = true;
            compareVal = state.get(compareClassID, compareFieldID);
//            logger.debug("condition.match."+compareClassID+";"+compareFieldID);
            if(!compareVal.getClass().equals(obj.getClass()))
                return false;
        }
        if(obj instanceof String)
        {
            String s = (String)obj;
            return match(s);
        }
        if(obj instanceof Date)
        {
            Date date = (Date)obj;
            return match(date);
        }
        if(obj instanceof Integer)
        {
            Integer integer = (Integer)obj;
            return match(integer);
        }
        if(obj instanceof Double)
        {
            Double double1 = (Double)obj;
            return match(double1);
        }
        if(obj instanceof Float)
        {
            Float float1 = (Float)obj;
            return match(float1);
        }
        if(obj instanceof Boolean)
        {
            Boolean boolean1 = (Boolean)obj;
            return match(boolean1);
        } else
        {
            Trace.trace(8, "Condition.match() - NOT VALID TYPE");
            return false;
        }
    }

    private boolean match(String s)
    {
        String s1;
        if(obj2obj)
            s1 = (String)compareVal;
        else
            s1 = value;
        Trace.trace(16, "Condition.match - if " + s + " op: " + op + " " + s1);
        boolean flag = false;
        if(s == null)
            s = new String();
        if(s1 == null)
            s1 = new String();
        int i = s.compareTo(s1);
        switch(op)
        {
        default:
            break;

        case 1: // '\001'
            if(i == 0)
                flag = true;
            break;

        case 2: // '\002'
            if(i != 0)
                flag = true;
            break;

        case 3: // '\003'
            if(i > 0)
                flag = true;
            break;

        case 4: // '\004'
            if(i < 0)
                flag = true;
            break;

        case 5: // '\005'
            if(i >= 0)
                flag = true;
            break;

        case 6: // '\006'
            if(i <= 0)
                flag = true;
            break;
        }
        Trace.trace(16, "Condition.match() - MATCH: " + flag);
        return flag;
    }

    private boolean match(Boolean boolean1)
    {
        boolean flag = boolean1.booleanValue();
        Trace.trace(16, "Condition.match - if " + flag + " op: " + op + " " + value);
        boolean flag2 = false;
        boolean flag1;
        if(obj2obj)
            flag1 = ((Boolean)compareVal).booleanValue();
        else
        if(value.compareTo("true") == 0)
            flag1 = true;
        else
            flag1 = false;
        switch(op)
        {
        case 1: // '\001'
            if(flag1 == flag)
                flag2 = true;
            break;

        case 2: // '\002'
            if(flag1 != flag)
                flag2 = true;
            break;

        default:
            flag2 = false;
            break;
        }
        return flag2;
    }

    private boolean match(Integer integer)
    {
        int i = integer.intValue();
        Trace.trace(16, "Condition.match - if " + i + " op: " + op + " " + value);
        boolean flag = false;
        int j;
        if(obj2obj)
            j = ((Integer)compareVal).intValue();
        else
            j = Integer.parseInt(value);
        switch(op)
        {
        default:
            break;

        case 1: // '\001'
            if(i == j)
                flag = true;
            break;

        case 2: // '\002'
            if(i != j)
                flag = true;
            break;

        case 3: // '\003'
            if(i > j)
                flag = true;
            break;

        case 4: // '\004'
            if(i < j)
                flag = true;
            break;

        case 5: // '\005'
            if(i >= j)
                flag = true;
            break;

        case 6: // '\006'
            if(i <= j)
                flag = true;
            break;
        }
        Trace.trace(16, "Condition.match - MATCH: " + flag);
        return flag;
    }

    private boolean match(Double double1)
    {
        double d = double1.doubleValue();
        Trace.trace(16, "Condition.match - if " + d + " op: " + op + " " + value);
        boolean flag = false;
        double d1;
        if(obj2obj)
            d1 = ((Double)compareVal).doubleValue();
        else
            d1 = Double.parseDouble(value);
        switch(op)
        {
        default:
            break;

        case 1: // '\001'
            if(d == d1)
                flag = true;
            break;

        case 2: // '\002'
            if(d != d1)
                flag = true;
            break;

        case 3: // '\003'
            if(d > d1)
                flag = true;
            break;

        case 4: // '\004'
            if(d < d1)
                flag = true;
            break;

        case 5: // '\005'
            if(d >= d1)
                flag = true;
            break;

        case 6: // '\006'
            if(d <= d1)
                flag = true;
            break;
        }
        return flag;
    }

    private boolean match(Float float1)
    {
        float f = float1.floatValue();
        Trace.trace(16, "Condition.match - if " + f + " op: " + op + " " + value);
        boolean flag = false;
        float f1;
        if(obj2obj)
            f1 = ((Float)compareVal).floatValue();
        else
            f1 = Float.parseFloat(value);
        switch(op)
        {
        default:
            break;

        case 1: // '\001'
            if(f == f1)
                flag = true;
            break;

        case 2: // '\002'
            if(f != f1)
                flag = true;
            break;

        case 3: // '\003'
            if(f > f1)
                flag = true;
            break;

        case 4: // '\004'
            if(f < f1)
                flag = true;
            break;

        case 5: // '\005'
            if(f >= f1)
                flag = true;
            break;

        case 6: // '\006'
            if(f <= f1)
                flag = true;
            break;
        }
        return flag;
    }

    private boolean match(Date date)
    {
        DateFormat dateformat = DateFormat.getDateInstance();
        Date date1;
        try
        {
            if(obj2obj)
                date1 = (Date)compareVal;
            else
                date1 = dateformat.parse(value);
        }
        catch(ParseException parseexception)
        {
            return false;
        }
        boolean flag = false;
        switch(op)
        {
        default:
            break;

        case 1: // '\001'
            if(date == date1)
                flag = true;
            break;

        case 2: // '\002'
            if(date != date1)
                flag = true;
            break;

        case 3: // '\003'
            if(date.compareTo(date1) > 0)
                flag = true;
            break;

        case 4: // '\004'
            if(date.compareTo(date1) < 0)
                flag = true;
            break;

        case 5: // '\005'
            if(date.compareTo(date1) >= 0)
                flag = true;
            break;

        case 6: // '\006'
            if(date.compareTo(date1) <= 0)
                flag = true;
            break;
        }
        return flag;
    }

    public String getSetName()
    {
        return setName;
    }

    public void setSetName(String s)
    {
        setName = s;
    }

    public int getClassID()
    {
        return classID;
    }

    public int getFieldID()
    {
        return fieldID;
    }

    public int getOp()
    {
        return op;
    }

    public String getValue()
    {
        return value;
    }

    public int getCompareClassID()
    {
        return compareClassID;
    }

    public int getCompareFieldID()
    {
        return compareFieldID;
    }

    public void setClassID(int i)
    {
        classID = i;
    }

    public void setFieldID(int i)
    {
        fieldID = i;
    }

    public void setOp(int i)
    {
        op = i;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public void setCompareClassID(int i)
    {
        compareClassID = i;
    }

    public void setCompareFieldID(int i)
    {
        compareFieldID = i;
    }

    public String toString()
    {
        String s = "CONDITION:\n";
        s = s + "\tSET NAME: " + setName + "\n";
        s = s + "\tCLASS: " + classID + "\n";
        s = s + "\tFIELD: " + fieldID + "\n";
        s = s + "\tOP: " + op + "\n";
        s = s + "\tVALUE: " + value + "\n";
        s = s + "\tCOMPARE CLASS: " + compareClassID + "\n";
        s = s + "\tCOMPARE FIELD: " + compareFieldID + "\n";
        return s;
    }

    public static final int EQUAL = 1;
    public static final int NOTEQUAL = 2;
    public static final int GREATERTHAN = 3;
    public static final int LESSTHAN = 4;
    public static final int GREATEROREQUAL = 5;
    public static final int LESSOREQUAL = 6;
    public static final int IN = 7;
    private String setName;
    private int classID;
    private int fieldID;
    private int op;
    private String value;
    private int compareClassID;
    private int compareFieldID;
    private boolean obj2obj;
    private Object compareVal;
    
    private Logger logger = Logger.getLogger(Condition.class);
}
