package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.1                                                           <BR>
 * Updated by: Joey Cline                                                 <BR>
 * - Changed the access on the set methods for parameter name, value, and
 * description from private to public.
 *
 * Updated by: Kim Statham                                                 <BR>
 * - Added Constructor which includes EDIT_LEVEL_NUMBER as a parameter.
 */

 import java.util.*;
 import cciij.businessActions.*;
 import java.io.Serializable;

public class SiteParam implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: SiteParam.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode = "";
  private String m_paramName = "";
  private String m_paramValue = "";
  private String m_paramDescription = "";
  private String m_groupName = "";
  private int m_editLevelNbr; 

  /**
   * SiteParam
   */
  public SiteParam()
  {

  }
  /**
   * SiteParam
   * @param String locationCode
   * @param String paramName
   * @param String paramValue
   * @param String paramDespcription
   * @param String groupName
   */
  public SiteParam(String locationCode,
                   String paramName,
                   String paramValue,
                   String paramDescription,
                   String groupName)
  {
    this(locationCode, paramName, paramValue, paramDescription, groupName, 0);
    
  }
  /**
   * SiteParam
   * @param String locationCode
   * @param String paramName
   * @param String paramValue
   * @param String paramDespcription
   * @param String groupName
   */
  public SiteParam(String locationCode,
                   String paramName,
                   String paramValue,
                   String paramDescription,
                   String groupName,
                   int editLevelNbr)
  {
    setLocationCode(locationCode);
    setParamName(paramName);
    setParamValue(paramValue);
    setParamDescription(paramDescription);
    setGroupName(groupName);
    setEditLevelNbr(editLevelNbr);
  }
  /**
  * finalize
  */
  protected void finalize() {

  }
  /**
   * getEditLevelNbr
   * @return int
   */
  public int getEditLevelNbr()
  {
    return m_editLevelNbr;
  }
  /**
   * getGroupName
   * @return String
   */
  public String getGroupName()
  {
    return m_groupName;
  }
  /**
   * getLocationCode
   * @return String
   */
  public String getLocationCode()
  {
    return m_locationCode;
  }
  /**
   * getParamDescription
   * @return String
   */
  public String getParamDescription()
  {
    return m_paramDescription;
  }
  /**
   * getParamName
   * @return String
   */
  public String getParamName()
  {
    return m_paramName;
  }
  /**
   * getParamValue
   * @return String
   */
  public String getParamValue()
  {
    return m_paramValue;
  }
  /**
   * setEditLevelNbr
   * @param int
   */
  public void setEditLevelNbr(int i)
  {
    m_editLevelNbr = i;
  }
  /**
   * setGroupName
   * @param String
   */
  private void setGroupName(String s)
  {
    if(s == null)
    {
       m_groupName = "";
    }
    else
    {
      m_groupName = s;
    }
  }
  /**
   * setLocationCode
   * @param String
   */
  private void setLocationCode(String s)
  {
    if(s == null)
    {
       m_locationCode = "";
    }
    else
    {
      m_locationCode = s;
    }
  }
  /**
   * setParamDescription
   * @param String
   */
  public void setParamDescription(String s)
  {
    if(s == null)
    {
       m_paramDescription = "";
    }
    else
    {
      m_paramDescription = s;
    }
  }
  /**
   * setParamName
   * @param String
   */
  public void setParamName(String  s)
  {
    if(s == null)
    {
      m_paramName = "";
    }
    else
    {
      m_paramName = s;
    }
  }
  /**
   * setParamValue
   * @param String
   */
  public void setParamValue(String s)
  {
    if(s == null)
    {
       m_paramValue = "";
    }
    else
    {
      m_paramValue = s;
    }
  }
  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "SiteParm object -- " + "\n";

         s += "locationCode     : " + m_locationCode+ "\n";
         s += "paramName        : " + m_paramName+ "\n";
         s += "paramValue       : " + m_paramValue+ "\n";
         s += "paramDescription : " + m_paramDescription+ "\n";
         s += "groupName        : " + m_groupName+ "\n";
         s += "editLevelNbr     : " + m_editLevelNbr+ "\n";

      return s;
  }
}
