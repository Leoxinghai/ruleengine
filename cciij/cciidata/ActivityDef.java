package cciij.cciidata;

/** 
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

 import java.io.Serializable;

public class ActivityDef implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ActivityDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_activityCode = "";
  private String m_activityTypeDescription = "";
  private String m_activityTextTemplateDescription = "";
  private String m_recordActiveFlag = "";
  private String m_oidTypeCode = "";
  private String m_activityRetrievalTypeCode = "";
  private String m_locationCode = "";


 /**
  * ActivityDef
  */
  public ActivityDef()
  {

  }

  /**
   * ActiityDef
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public ActivityDef(String activityCode,
                     String activityTypeDescription,
                     String activityTextTemplateDescription,
                     String recordActiveFlag,
                     String oidTypeCode,
                     String activityRetrievalTypeCode)
  {
      setActivityCode(activityCode);
      setActivityTypeDescription(activityTypeDescription);
      setActivityTextTemplateDescription(activityTextTemplateDescription);
      setRecordActiveFlag(recordActiveFlag);
      setOidTypeCode(oidTypeCode);
      setActivityRetrievalTypeCode(activityRetrievalTypeCode);
  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getActivityCode
   * @return String
   */
  public String getActivityCode()
  {
    return m_activityCode;
  }

  /**
   * getActivityTypeDescription
   * @return String
   */
  public String getActivityTypeDescription()
  {
    return m_activityTypeDescription;
  }

  /**
   * getActivityTextTemplateDescription
   * @return String
   */
  public String getActivityTextTemplateDescription()
  {
    return m_activityTextTemplateDescription;
  }

  /**
   * getRecordActiveFlag
   * @return String
   */
  public String getRecordActiveFlag()
  {
    return m_recordActiveFlag;
  }

  /**
   * getOidTypeCode
   * @return String
   */
  public String getOidTypeCode()
  {
    return m_oidTypeCode;
  }

  /**
   * getActivityRetrievalTypeCode
   * @return String
   */
  public String getActivityRetrievalTypeCode()
  {
    return m_activityRetrievalTypeCode;
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
   * setLocationCode
   * @param String
   */
  public void setLocationCode(String s)
  {
     if( s == null)
    {
      m_locationCode = "";
    }
    else
    {
      m_locationCode = s;
    }
  }

  /**
   * setActivityCode
   * @param String
   */
  private void setActivityCode(String s)
  {
    if(s == null)
    {
      m_activityCode = "";
    }
    else
    {
      m_activityCode = s;
    }
  }

  /**
   * setActivityTypeDescription
   * @param String
   */
  private void setActivityTypeDescription(String s)
  {
    if(s == null)
    {
       m_activityTypeDescription = "";
    }
    else
    {
      m_activityTypeDescription = s;
    }
  }

  /**
   * setActivityTextTemplateDescription
   * @param String
   */
  private void setActivityTextTemplateDescription(String s)
  {
    if(s == null)
    {
       m_activityTextTemplateDescription = "";
    }
    else
    {
      m_activityTextTemplateDescription = s;
    }
  }

  /**
   * setRecordActiveFlag
   * @param String
   */
  public void setRecordActiveFlag(String s)
  {
    if(s == null)
    {
       m_recordActiveFlag = "";
    }
    else
    {
      m_recordActiveFlag = s;
    }
  }

  /**
   * setOidTypeCode
   * @param String
   */
  private void setOidTypeCode(String s)
  {
    if(s == null)
    {
       m_oidTypeCode = "";
    }
    else
    {
      m_oidTypeCode = s;
    }
  }

  /**
   * setActivityRetrievalTypeCode
   * @param String
   */
  private void setActivityRetrievalTypeCode(String s)
  {
    if(s == null)
    {
       m_activityRetrievalTypeCode = "";
    }
    else
    {
      m_activityRetrievalTypeCode = s;
    }
  }

   /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "ActivityDef object -- " + "\n";

         s += "activityCode                    : " + m_activityCode+ "\n";
         s += "activityTypeDescription         : " + m_activityTypeDescription+ "\n";
         s += "activityTextTemplateDescription : " + m_activityTextTemplateDescription+ "\n";
         s += "recordActiveFlag                : " + m_recordActiveFlag+ "\n";
         s += "oidTypeCode                     : " + m_oidTypeCode+ "\n";
         s += "activityRetrievalTypeCode       : " + m_activityRetrievalTypeCode+ "\n";
         s += "locationCode                      : " + m_locationCode+ "\n";
         return s;
  }
}

