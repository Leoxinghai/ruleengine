package cciij.cciidata;

/**
 * Title: ReasonCode Role Class
 * Description:
 * Copyright:  Copyright (c) 2001
 * Company: Fedex Services
 * @author
 * @version 1.0
 *
 */
import java.util.*;
import java.io.Serializable;

public class ReasonCode implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: ReasonCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_reasonCode = "";
  private int m_reasonCodeOidNumber;
  private int m_shipmentOidNumber;
  private int m_pieceOidNumber;
  private String m_recurringCriteriaFlag = "";
  private String m_activeInactiveFlag = "";
  private Date m_reasonCodeDate = new Date(0);
  private String m_createEmployeeNumber = "";
  private Date m_dateReasonCodeUpdated = new Date(0);
  private String m_updateEmployeeNumber = "";
  private String m_createProcessName = "";
  private String m_updateProcessName = "";
  private String m_uploadedFlag = "";
  private String m_locationCd = "";


  /**
   * ReasonCode
   */
  public ReasonCode() {

  }


  /**
   * ReasonCode
   * @param String
   * @param int
   * @param int
   * @param int
   * @param String
   * @param String
   * @param Date
   * @param String
   * @param Date
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public ReasonCode(String reasonCode,
                    int reasonCodeOidNumber,
                    int shipmentOidNumber,
                    int pieceOidNumber,
		    String recurringCriteriaFlag,
                    String activeInactiveFlag,
                    Date reasonCodeDate,
                    String createEmployeeNumber,
                    Date dateReasonCodeUpdated,
                    String updateEmployeeNumber,
                    String createProcessName,
                    String updateProcessName,
                    String uploadedFlag,
		    String locationCode)
  {
      setReasonCode(reasonCode);
      m_reasonCodeOidNumber = reasonCodeOidNumber;
      m_shipmentOidNumber = shipmentOidNumber;
      m_pieceOidNumber = pieceOidNumber;
      setRecurringCriteriaFlag(recurringCriteriaFlag);
      setLocationCd(locationCode);
      setActiveInactiveFlag(activeInactiveFlag);
      m_reasonCodeDate = reasonCodeDate;
      setCreateEmployeeNumber(createEmployeeNumber);
      m_dateReasonCodeUpdated = dateReasonCodeUpdated;
      setEmployeeNumberForUpdate(updateEmployeeNumber);
      setCreateProcessName(createProcessName);
      setUpdatedProcessName(updateProcessName);
      setUploadFlag(uploadedFlag);


  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getReasonCode
   * @return String
   */
  public String getReasonCode() {
      return m_reasonCode;
  }

  /**
   * getReasonCodeOidNumber
   * @return int
   */
  public int getReasonCodeOidNumber() {
       return m_reasonCodeOidNumber;
  }

  /**
   * getShipmentOidNumber
   * @return int
   */
  public int getShipmentOidNumber() {
      return  m_shipmentOidNumber;
  }

  /**
   * getPieceOidNumber
   * @return int
   */
  public int getPieceOidNumber() {
      return  m_pieceOidNumber;
  }

  /**
   * getRecurringCriteriaFlag
   * @return String
   */
  public String getRecurringCriteriaFlag() {
     return m_recurringCriteriaFlag;
  }


  /**
   * getActiveInactiveFlag
   * @return String
   */
  public String getActiveInactiveFlag() {
      return  m_activeInactiveFlag;
  }

  /**
   * getReasonCodeDate
   * @return Date
   */
  public Date getReasonCodeDate() {
      return m_reasonCodeDate;
  }

  /**
   * getUpdateDate
   * @return Date
   */
  public Date getUpdateDate() {
      return m_dateReasonCodeUpdated;
  }

  /**
   * getCreateEmployeeNumber
   * @return String
   */
  public String getCreateEmployeeNumber() {
      return  m_createEmployeeNumber;
  }

  /**
   * getDateReasonCodeUpdated
   * @return Date
   */
  public Date getDateReasonCodeUpdated() {
      return m_dateReasonCodeUpdated;
  }

  /**
   * getUpdateEmployeeNumber
   * @return String
   */
  public String getUpdateEmployeeNumber() {
      return m_updateEmployeeNumber;
  }

  /**
   * getCreatedProcessName
   * @return String
   */
  public String getCreatedProcessName() {
      return m_createProcessName;
  }

  /**
   * getUpdatedProcessName
   * @return String
   */
  public String getUpdatedProcessName() {
      return m_updateProcessName;
  }

  /**
   * getUploadedFlag
   * @return String
   */
  public String getUploadedFlag() {
      return m_uploadedFlag;
  }

  /**
   * getLocationCd
   * @return String
   */
  public String getLocationCd() {
      return m_locationCd;
  }

  /**
   * setLocationCd
   * @param String
   */
  public void setLocationCd(String s) {

      if(s == null)
      {
         m_locationCd = "";
      }
      else
      {
         m_locationCd = s;
      }
  }


  /**
   * setRecurringCriteriaFlag
   * @param String
   */
  public void setRecurringCriteriaFlag(String s) {

     if(s == null)
     {
	m_recurringCriteriaFlag = "";
     }
     else
     {
        m_recurringCriteriaFlag = s;
     }
  }






  /**
   * setActiveInactiveFlag
   * @param boolean
   */
  public void setActiveInactiveFlag(boolean isActive) {

      if(isActive == true)
      {
         m_activeInactiveFlag = "Y";
      }
      else
      {
         m_activeInactiveFlag = "N";
      }
  }

  /**
   * setUploadFlag
   * @param boolean
   */
  public void setUploadFlag(boolean isUploaded) {
      if(isUploaded == true)
      {
          m_uploadedFlag = "Y";
      }
      else
      {
          m_uploadedFlag = "N";
      }
  }


  /**
   * setReasonCodeOidNumber
   * @param int
   */
  public void setReasonCodeOidNumber(int i)
  {
    if (m_reasonCodeOidNumber == 0)
    {
      m_reasonCodeOidNumber = i;
    }
  }

  /**
   * setReasonCode
   * @param String
   */
  private void setReasonCode(String s)
  {
    if(s == null)
    {
       m_reasonCode = "";
    }
    else
    {
      m_reasonCode = s;
    }
  }

  /**
   * setCreateEmployeeNumber
   * @param String
   */
  private void setCreateEmployeeNumber(String s)
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
   * setCreateProcessName
   * @param String
   */
  private void setCreateProcessName(String s)
  {
    if(s == null)
    {
       m_createProcessName = "";
    }
    else
    {
      m_createProcessName = s;
    }
  }

  /**
   * setActiveInactiveFlag
   * @param String
   */
  private void setActiveInactiveFlag(String s)
  {
    if(s == null)
    {
      m_activeInactiveFlag = "";
    }
    else
    {
      m_activeInactiveFlag = s;
    }
  }

  /**
   * setUploadFlag
   * @param String
   */
  private void setUploadFlag(String s)
  {
    if(s == null)
    {
      m_uploadedFlag = "";
    }
    else
    {
      m_uploadedFlag = s;
    }
  }

  /**
   * setDateUpdated
   * @param Date
   */
  public void setDateUpdated(Date newDate) {
      m_dateReasonCodeUpdated = newDate;
  }

  /**
   * setEmployeeNumberForUpdate
   * @param String
   */
  public void setEmployeeNumberForUpdate(String s)
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
   * setUpdatedProcessName
   * @param String
   */
  public void setUpdatedProcessName(String s)
  {
    if(s == null)
    {
      m_updateProcessName = "";
    }
    else
    {
      m_updateProcessName = s;
    }
  }


  /**
   * displayRevision
   */
  public void displayRevision() {
  //	ReasonCodeRevision.displayRevision();
  }

  /**
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

         s +=  "ReasonCode object -- " + "\n";

         s += "reasonCode            : " + m_reasonCode+ "\n";
         s += "reasonCodeOidNumber   : " + m_reasonCodeOidNumber+ "\n";
         s += "shipmentOidNumber     : " + m_shipmentOidNumber+ "\n";
	 s += "pieceOidNumber        : " + m_pieceOidNumber+ "\n";
	 s += "recurringCriteriaFlag : " + m_recurringCriteriaFlag+ "\n";
         s += "activeInactiveFlag    : " + m_activeInactiveFlag+ "\n";
         s += "reasonCodeDate        : " + m_reasonCodeDate+ "\n";
         s += "createEmployeeNumber  : " + m_createEmployeeNumber+ "\n";
         s += "dateReasonCodeUpdated : " + m_dateReasonCodeUpdated+ "\n";
         s += "updateEmployeeNumber  : " + m_updateEmployeeNumber+ "\n";
         s += "createProcessName     : " + m_createProcessName+ "\n";
         s += "updateProcessName     : " + m_updateProcessName+ "\n";
         s += "uploadedFlag          : " + m_uploadedFlag+ "\n";
         s += "locationCd            : " + m_locationCd+ "\n";


      return s;
  }

}
