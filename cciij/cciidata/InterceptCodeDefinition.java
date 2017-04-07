package cciij.cciidata;
/**
 * Title: InterceptCodeDefinition Role Class
 * Description:
 * Copyright:  Copyright (c) 2007
 * Company: Fedex Services
 * @author
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;

public class InterceptCodeDefinition  implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: InterceptCodeDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

  private String m_interceptCode = "";
  private String m_interceptDescription = "";
  private int    m_interceptPriorityNumber;
  private String m_recordActiveFlag = "";
  private String m_restrictedAgencyCode = "";
  private String m_arrivalCommentText = "";
  private String m_satisfiedCommentText = "";
  //added 11/14/01 due to additions to db table   kk
  private String m_interceptLabelTextDescription = "";
  private Date   m_createDate = new Date(0);
  private String m_createEmployeeNumber = "";
  private Date   m_updateDate = new Date(0);
  private String m_updateEmployeeNumber = "";
  //added 11/19/02 due to additions to the db table sh
  private String m_locationCode = "";


  /**
   * InterceptCodeDefinition
   */
  public InterceptCodeDefinition() {

  }

  /**
   * InterceptCodeDefinition
   * @param String
   * @param String
   * @param int
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public InterceptCodeDefinition(String interceptCode,
                                  String interceptDescription,
                                  int interceptPriorityNumber,
                                  String recordActiveFlag,
                                  String restrictedAgencyCode,
                                  String arrivalCommentText,
                                  String satisfiedCommentText) {

    setInterceptCode(interceptCode);
    setInterceptDescription(interceptDescription);
    m_interceptPriorityNumber = interceptPriorityNumber;
    setRecordActiveFlag(recordActiveFlag);
    setRestrictedAgencyCode(restrictedAgencyCode);
    setArrivalCommentText(arrivalCommentText);
    setSatisfiedCommentText(satisfiedCommentText);
  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
  * getInterceptCode
  * @return String
  */
  public String getInterceptCode() {
      return m_interceptCode;
  }


  /**
  * getInterceptCodeDescription
  * @return String
  */
  public String getInterceptDescription() {
      return m_interceptDescription;
  }

  /**
  * getInterceptPriorityNumber
  * @return int
  */
  public int getInterceptPriorityNumber() {
      return m_interceptPriorityNumber;
  }

  /**
  * getRecordActiveFlag
  * @return String
  */
  public String getRecordActiveFlag() {
      return m_recordActiveFlag;
  }

  /**
  * getRestrictedAgencyCode
  * @return String
  */
  public String getRestrictedAgencyCode() {
      return m_restrictedAgencyCode;
  }

  /**
  * getArrivalCommentText
  * @return String
  */
  public String getArrivalCommentText() {
      return m_arrivalCommentText;
  }

  /**
  * getSatisfiedCommentText
  * @return String
  */
  public String getSatisfiedCommentText() {
      return m_satisfiedCommentText;
  }

  /**
   * getInterceptLabelTextDescription
   * @return String
   */
  public String getInterceptLabelTextDescription()
  {
    return m_interceptLabelTextDescription;
  }

  /**
   * getCreateDate
   * @return Date
   */
  public Date getCreateDate()
  {
    return m_createDate;
  }

  /**
   * getCreateEmployeeNumber
   * @return String
   */
  public String getCreateEmployeeNumber()
  {
    return m_createEmployeeNumber;
  }

  /**
   * getUpdateDate
   * @return Date
   */
  public Date getUpdateDate()
  {
    return  m_updateDate;
  }

  /**
   * getUpdateEmployeeNumber
   * @return String
   */
  public String getUpdateEmployeeNumber()
  {
    return m_updateEmployeeNumber;
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
   * setInterceptCode
   * @param String
   */
  private void setInterceptCode(String s)
  {
    if(s == null)
    {
       m_interceptCode = "";
    }
    else
    {
      m_interceptCode = s;
    }
  }

  /**
   * setInterceptDescription
   * @param String
   */
  private void setInterceptDescription(String s)
  {
    if(s == null)
    {
       m_interceptDescription = "";
    }
    else
    {
      m_interceptDescription = s;
    }
  }

  /**
   * setRestrictedAgencyCode
   * @param String
   */
  private void setRestrictedAgencyCode(String s)
  {
    if(s == null)
    {
       m_restrictedAgencyCode = "";
    }
    else
    {
      m_restrictedAgencyCode = s;
    }
  }

  /**
   * setArrivalCommentText
   * @param String
   */
  private void setArrivalCommentText(String s)
  {
    if(s == null)
    {
       m_arrivalCommentText = "";
    }
    else
    {
      m_arrivalCommentText = s;
    }
  }

  /**
   * setSatisfiedCommentText
   * @param String
   */
  private void setSatisfiedCommentText(String s)
  {
    if(s == null)
    {
       m_satisfiedCommentText = "";
    }
    else
    {
      m_satisfiedCommentText = s;
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
   * setInterceptLabelTextDescription
   * @param String
   */
  public void setInterceptLabelTextDescription(String s)
  {
    if(s == null)
    {
       m_interceptLabelTextDescription = "";
    }
    else
    {
       m_interceptLabelTextDescription = s;
    }
  }

  /**
   * setCreateDate
   * @param Date
   */
  public void setCreateDate(Date d)
  {
     m_createDate = d;
  }

  /**
  * setCreateDate
  * @param long lDt
  */
  public void setCreateDate(long lDt)
  {
    m_createDate = new Date(lDt);
  }

  /**
   * setCreateEmployeeNumber
   * @param String
   */
  public void setCreateEmployeeNumber(String s)
  {
    if(s == null)
    {
      m_createEmployeeNumber = "";
    }
    else
    {
      m_createEmployeeNumber = s;
    }
  }

  /**
   * setUpdateDate
   * @param Date
   */
  public void setUpdateDate(Date d)
  {
     m_updateDate = d;
  }

  /**
  * setUpdateDate
  * @param long lDt
  */
  public void setUpdateDate(long lDt)
  {
    m_updateDate = new Date(lDt);
  }

  /**
   * setUpdateEmployeeNumber
   * @param String
   */
  public void setUpdateEmployeeNumber(String s)
  {
    if(s == null)
    {
      m_updateEmployeeNumber = "";
    }
    else
    {
      m_updateEmployeeNumber = s;
    }
  }

  /**
   * setLocationCode
   * @param String
   */
  public void setLocationCode(String s)
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
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

         s +=  "InterceptCodeDefinition object -- " + "\n";

         s += "interceptCode                 : " + m_interceptCode+ "\n";
         s += "interceptDescription          : " + m_interceptDescription+ "\n";
         s += "interceptPriorityNumber       : " + m_interceptPriorityNumber+ "\n";
         s += "recordActiveFlag              : " + m_recordActiveFlag+ "\n";
         s += "restrictedAgencyCode          : " + m_restrictedAgencyCode+ "\n";
         s += "arrivalCommentText            : " + m_arrivalCommentText+ "\n";
         s += "satisfiedCommentText          : " + m_satisfiedCommentText+ "\n";
         s += "interceptLabelTextDescription : " + m_interceptLabelTextDescription+ "\n";
         s += "createDate                    : " + m_createDate+ "\n";
         s += "createEmployeeNumber          : " + m_createEmployeeNumber+ "\n";
         s += "updateDate                    : " + m_updateDate+ "\n";
         s += "updateEmployeeNumber          : " + m_updateEmployeeNumber+ "\n";
         s += "locationCd                    : " + m_locationCode+ "\n";


      return s;
  }

}
