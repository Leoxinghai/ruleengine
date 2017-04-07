package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

public class AccessControl {
  private static final String m_whatVersion = "@(#) $RCSfile: AccessControl.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_accessControlCode = "";
  private String m_accessControlDescription = "";

  /**
   * AccessControl
   */
  public AccessControl()
  {

  }

  public AccessControl(String accessControlCode,
                       String accessControlDescription)
  {
    setAccessControlCode(accessControlCode);
    setAccessControlDescription(accessControlDescription);
  }

   /**
  * finalize
  */
  protected void finalize()
  {

  }

  /**
   * getAccessControlCode
   * @return String
   */
  public String getAccessControlCode()
  {
    return m_accessControlCode;
  }

  /**
   * getAccessControlDescription
   * @return String
   */
  public String getAccessControlDescription()
  {
    return m_accessControlDescription;
  }

  /**
   * setAccessControlCode
   * @param String
   */
  public void setAccessControlCode(String s)
  {
     if(s == null)
     {
        m_accessControlCode = "";
     }
     else
     {
        m_accessControlCode = s;
     }
  }

  /**
   * setAccessControlDescription
   * @param String
   */
  public void setAccessControlDescription(String s)
  {
     if(s == null)
     {
        m_accessControlDescription = "";
     }
     else
     {
        m_accessControlDescription = s;
     }
  }

   /**
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

         s +=  "AccessControl object -- " + "\n";

         s += "accessControlCode        : " + m_accessControlCode+ "\n";
         s += "accessControlDescription : " + m_accessControlDescription+ "\n";

      return s;
   }
}