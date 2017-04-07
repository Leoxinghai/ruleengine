package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

 import java.util.*;
 import cciij.businessActions.*;
 import java.io.Serializable;

public class ClearanceActivity implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ClearanceActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int m_activityOidNumber;
  private String m_activityCode = "";
  private String m_activityDataDescription = "";
  private Date m_activityTimestamp = new Date(0);
  private int m_activityMillisecondTimestamp;
  private int m_oidNumber;
  private String m_oidTypeCode = "";
  private String m_processDescription = "";
  private Date m_processSourceTimestamp = new Date(0);
  private String m_processSourceDescription = "";
  private String m_lastUserName = "";
  private String m_agencyCode = "";
  private String m_activityLocationCode = "";
  private String m_agencyLocationCode = "";


  /**
   * ClearanceActivity
   */
  public ClearanceActivity()
  {

  }

  /**
   * ClearanceActivity
   * @param int activityOidNumber,
   * @param String activityCode,
   * @param String activityDataDescription,
   * @param Date activityTimestamp,
   * @param int activityMillisecondTimestamp,
   * @param int oidNumber,
   * @param String oidTypeCode,
   * @param String processDescription,
   * @param Date processSourceTimestamp,
   * @param String processSourceDescription,
   * @param String lastUserName
   * @param String agencyCode
   */
  public ClearanceActivity(int activityOidNumber,
                           String activityCode,
                           String activityDataDescription,
                           Date activityTimestamp,
                           int activityMillisecondTimestamp,
                           int oidNumber,
                           String oidTypeCode,
                           String processDescription,
                           Date processSourceTimestamp,
                           String processSourceDescription,
                           String lastUserName,
                           String agencyCode)
  {
      m_activityOidNumber = activityOidNumber;
      m_activityCode = activityCode;
      m_activityDataDescription = activityDataDescription;
      m_activityTimestamp = activityTimestamp;
      m_activityMillisecondTimestamp = activityMillisecondTimestamp;
      m_oidNumber = oidNumber;
      m_oidTypeCode = oidTypeCode;
      m_processDescription = processDescription;
      m_processSourceTimestamp = processSourceTimestamp;
      m_processSourceDescription = processSourceDescription;
      m_lastUserName = lastUserName;
      m_agencyCode = agencyCode;
  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getActivityOidNumber
   * @return int
   */
  public int getActivityOidNumber()
  {
    return m_activityOidNumber;
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
   * getActivityDataDescription
   * @return String
   */
  public String getActivityDataDescription()
  {
    return m_activityDataDescription;
  }

  /**
   * getActivityTimestamp
   * @return Date
   */
  public Date getActivityTimestamp()
  {
    return m_activityTimestamp;
  }

  /**
   * getActivityMillisecondTimestamp
   * @return int
   */
  public int getActivityMillisecondTimestamp()
  {
    return m_activityMillisecondTimestamp;
  }

  /**
   * getOidNumber
   * @return int
   */
  public int getOidNumber()
  {
    return m_oidNumber;
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
   * getProcessDescription
   * @return String
   */
  public String getProcessDescription()
  {
    return m_processDescription;
  }

  /**
   * getProcessSourceTimestamp
   * @return Date
   */
  public Date getProcessSourceTimestamp()
  {
    return m_processSourceTimestamp;
  }

  /**
   * getProcessSourceDescription
   * @return String
   */
  public String getProcessSourceDescription()
  {
    return m_processSourceDescription;
  }

  /**
   * getLastUserName
   * @return String
   */
  public String getLastUserName()
  {
    return m_lastUserName;
  }

  /**
   * getAgencyCode
   * @return String
   */
  public String getAgencyCode()
  {
    return m_agencyCode;
  }

  /**
   * getAgencyLocationCode
   * @return String
   */
  public String getAgencyLocationCode()
  {
    return m_agencyLocationCode;
  }

/**
   * getactivityLocationCode
   * @return String
   */
  public String getActivityLocationCode()
  {
    return m_activityLocationCode;
  }

  /**
   * setAgencyLocationCode
   * @param String
   */
  public void setAgencyLocationCode(String s)
  {
     if( s == null)
    {
      m_agencyLocationCode = "";
    }
    else
    {
      m_agencyLocationCode = s;
    }
  }

  /**
   * setActivityLocationCode
   * @param String
   */
  public void setActivityLocationCode(String s)
  {
     if( s == null)
    {
      m_activityLocationCode = "";
    }
    else
    {
      m_activityLocationCode = s;
    }
  }

  /**
   * setProcessDescription
   * @param String
   */
  public void setProcessDescription(String s)
  {
    if(s == null)
    {
       m_processDescription = "";
    }
    else
    {
      m_processDescription = s;
    }
  }

  /**
   * setProcessSourceTimestamp
   * @param Date
   */
  public void setProcessSourceTimestamp(Date d)
  {
     m_processSourceTimestamp = d;
  }

  /**
   * setProcessSourceTimestamp
   * @param long
   */
  public void setProcessSourceTimestamp(long l)
  {
    m_processSourceTimestamp = new Date( l );
  }

  /**
   * setProcessSourceDescription
   * @param String
   */
   public void setProcessSourceDescription(String s)
   {
      if (s == null)
      {
         m_processSourceDescription = "";
      }
      else
      {
         m_processSourceDescription = s;
      }
   }

   /**
    * setLastUserName
    * @param String
    */
   public void setLastUserName(String s)
   {
      if(s == null)
      {
         m_lastUserName = "";
      }
      else
      {
         m_lastUserName = s;
      }
   }
  /**
   * setClearanceActivityOidNumber
   * @param int
   */
  public void setClearanceActivityOidNumber(int i)
   {
       if (m_activityOidNumber == 0)
      {
          m_activityOidNumber = i;
      }
  }

   /**
    * toString
    * @return String
    */
    public String toString()
   {
      String s = "";

         s +=  "ClearanceActivity object -- " + "\n";

         s += "activityOidNumber            : " + m_activityOidNumber+ "\n";
         s += "activityCode                 : " + m_activityCode+ "\n";
         s += "activityDataDescription      : " + m_activityDataDescription+ "\n";
         s += "activityTimestamp            : " + m_activityTimestamp+ "\n";
         s += "activityMillisecondTimestamp : " + m_activityMillisecondTimestamp+ "\n";
         s += "oidNumber                    : " + m_oidNumber+ "\n";
         s += "oidTypeCode                  : " + m_oidTypeCode+ "\n";
         s += "processDescription           : " + m_processDescription+ "\n";
         s += "processSourceTimestamp       : " + m_processSourceTimestamp+ "\n";
         s += "processSourceDescription     : " + m_processSourceDescription+ "\n";
         s += "lastUserName                 : " + m_lastUserName+ "\n";
         s += "agencyCode                   : " + m_agencyCode+ "\n";
         s += "agencyLocationCode           : " + m_agencyLocationCode+ "\n";
         s += "activityLocationCode         : " + m_activityLocationCode+ "\n";

 
      return s;
  }
}