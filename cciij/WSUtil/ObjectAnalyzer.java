package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

 import java.lang.reflect.*;

public class ObjectAnalyzer implements java.io.Serializable
{
   private static final String m_whatVersion = "@(#) $RCSfile: ObjectAnalyzer.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
   public static String toString(Object obj)
   {  Class cl = obj.getClass();
      String r = cl.getName() + "[";
      Class sc = cl.getSuperclass();
      if (!sc.equals(Object.class)) r += sc + ",";
      Field[] fields = cl.getDeclaredFields();
      try
      {  AccessibleObject.setAccessible(fields, true);
      }
      catch(SecurityException e) {}
      for (int i = 0; i < fields.length; i++)
      {  Field f = fields[i];
         r += f.getName() + "=";
         try
         {  Object val = f.get(obj);
            r += val.toString();
         } catch (IllegalAccessException e)
         {  r += "???";
         }
         if (i < fields.length - 1)
            r += ",";
         else
            r += "]";
      }
      return r;
   }

   public static boolean equals(Object a, Object b)
   {  Class cl = a.getClass();
      if (!cl.equals(b.getClass())) return false;
      Field[] fields = cl.getDeclaredFields();
      AccessibleObject.setAccessible(fields, true);
      for (int i = 0; i < fields.length; i++)
      {  Field f = fields[i];
         try
         {  if (!f.get(a).equals(f.get(b)))
               return false;
         }
         catch(IllegalAccessException e)
         {  return false;
         }
      }
      return true;
   }
}