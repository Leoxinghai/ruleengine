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
import java.io.Serializable;
import cciij.businessActions.*;

public class Intercept  implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: Intercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int m_interceptOidNumber;
  private int m_shipmentOidNumber;
  private int m_pieceOidNumber;
  private String m_interceptCode = "";
  private String m_activeFlag = "";
  private Date m_createDate = new Date(0);
  private String m_employeeNumberForCreation = "";
  private String m_processNameCreated = "";
  private Date m_dateUpdated = new Date(0);
  private String m_employeeNumberForUpdate = "";
  private String m_processNameUpdated = "";
  private int m_stagingAreaPriorityNumber;
  private Date m_transactionDate = new Date(0);
  private String m_agencyCode = "";
  private String m_fromRecurringCriteriaFlag = "";
  private String m_interceptLocationCode = "";
  private String m_agencyLocationCode = "";

  /**
   *  Intercept
   */
  public Intercept()
  {

  }

  /**
   * Intercept
   * @param interceptOidNumber
   * @param shipmentOidNumber
   * @param pieceOidNumber
   * @param interceptCode
   * @param activeFlag
   * @param createDate
   * @param employeeNumberForCreation
   * @param processNameCreated
   * @param dateUpdated
   * @param employeeNameForUpdate
   * @param processNameUpdated
   * @param stagingAreaPriorityNumber
   * @param transactionDate
   * @param agencyCode
   * @param fromRecurringCriteriaFlag
   */
   public Intercept (int interceptOidNumber,
                     int shipmentOidNumber,
                     int pieceOidNumber,
                     String interceptCode,
                     String activeFlag,
                     Date createDate,
                     String employeeNumberForCreation,
                     String processNameCreated,
                     Date dateUpdated,
                     String employeeNumberForUpdate,
                     String processNameUpdated,
                     int stagingAreaPriorityNumber,
                     Date transactionDate,
                     String agencyCode,
                     String fromRecurringCriteriaFlag)
  {
     m_interceptOidNumber = interceptOidNumber;
     m_shipmentOidNumber = shipmentOidNumber;
     m_pieceOidNumber = pieceOidNumber;
     setInterceptCode(interceptCode);
     setActiveFlag(activeFlag);
     m_createDate = createDate;
     setEmployeeNumberForCreation(employeeNumberForCreation);
     setProcessNameCreated(processNameCreated);
     m_dateUpdated = dateUpdated;
     setEmployeeNumberForUpdate(employeeNumberForUpdate);
     setProcessNameUpdated(processNameUpdated);
     m_stagingAreaPriorityNumber = stagingAreaPriorityNumber;
     m_transactionDate = transactionDate;
     setAgencyCode(agencyCode);
     setFromRecurringCriteriaFlag(fromRecurringCriteriaFlag);
  }

   /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getInterceptOidNumber
   * @return int
   */
  public int getInterceptOidNumber()
  {
    return m_interceptOidNumber;
  }

  /**
   * getShipmentOidNumber
   * @return int
   */
  public int getShipmentOidNumber()
  {
    return m_shipmentOidNumber;
  }

  /**
   * getPieceOidNumber
   * @return int
   */
  public int getPieceOidNumber()
  {
    return m_pieceOidNumber;
  }

  /**
   * getInterceptCode
   * @return String
   */
  public String getInterceptCode()
  {
    return m_interceptCode;
  }

  /**
   * getActiveFlag
   * @return String
   */
  public String getActiveFlag()
  {
    return  m_activeFlag;
  }

  /**
   * getCreateDate
   * @return Date
   */
  public Date getCreateDate()
  {
    return  m_createDate;
  }

  /**
   * getEmployeeNumberForCreation
   * @return String
   */
  public String getEmployeeNumberForCreation()
  {
    return  m_employeeNumberForCreation;
  }

  /**
   * getProcessNameCreated
   * @return String
   */
  public String getProcessNameCreated()
  {
    return m_processNameCreated;
  }

  /**
   * getDateUpdated
   * @return Date
   */
  public Date getDateUpdated()
  {
    return m_dateUpdated;
  }

  /**
   * getEmployeeNumberForUpdate
   * @return String
   */
  public String getEmployeeNumberForUpdate()
  {
    return  m_employeeNumberForUpdate;
  }

  /**
   * getProcessNameUpdated
   * @return String
   */
  public String getProcessNameUpdated()
  {
    return m_processNameUpdated;
  }

  /**
   * getStagingAreaPriorityNumber
   * @return int
   */
  public int getStagingAreaPriorityNumber()
  {
    return m_stagingAreaPriorityNumber;
  }

  /**
   * getTransactionDate
   * @return Date
   */
  public Date getTransactionDate()
  {
    return m_transactionDate;
  }

/**
  * getAgencyCode
  * @return String
  */
  public String getAgencyCode() {
    return m_agencyCode;
}

/**
  * getFromRecurringInterceptFlag
  * @return String
  */
  public String getFromRecurringCriteriaFlag() {
     return m_fromRecurringCriteriaFlag;
  }

  /**
   * setInterceptCode
   * @param String
   */
  public void setInterceptCode(String s)
  {
     if( s == null)
    {
      m_interceptCode = "";
    }
    else
    {
      m_interceptCode = s;
    }
  }
  /**
   * getInterceptLocationCode
   * @retrun String
   */
  public String getInterceptLocationCode()
  {
    return m_interceptLocationCode;
  }

  /**
   * setInterceptLocationCode
   * @param String
   */
  public void setInterceptLocationCode(String s)
  {
     if( s == null)
    {
      m_interceptLocationCode = "";
    }
    else
    {
      m_interceptLocationCode = s;
    }
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
   * setInterceptLocationCode
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
   * setEmployeeNumberForCreation
   * @param String
   */
  private void setEmployeeNumberForCreation(String s)
  {
    if(s == null)
    {
       m_employeeNumberForCreation = "";
    }
    else
    {
      m_employeeNumberForCreation = s;
    }
  }

  /**
   * setProcessNameCreated
   * @param String
   */
  private void setProcessNameCreated(String s)
  {
    if(s == null)
    {
       m_processNameCreated = "";
    }
    else
    {
      m_processNameCreated = s;
    }
  }

  /**
   * setAgencyCode
   * @param String
   */
  private void setAgencyCode(String s)
  {
    if(s == null)
    {
       m_agencyCode = "";
    }
    else
    {
      m_agencyCode = s;
    }
  }

  /**
   * setFromRecurringCriteriaFlag
   * @param String
   */
  public void setFromRecurringCriteriaFlag(String s)
  {
    if(s == null)
    {
       m_fromRecurringCriteriaFlag = "";
    }
    else
    {
      m_fromRecurringCriteriaFlag = s;
    }
  }

  /**
   * setActiveFlag
   * @param activeFlag
   */
  public void setActiveFlag(String s)
  {
    if(s == null)
    {
      m_activeFlag = "";
    }
    else
    {
      m_activeFlag = s;
    }
  }

  /**
   * setDateUpdated
   * @param dateUpdated
   */
  public void setDateUpdated(Date dateUpdated)
  {
    m_dateUpdated = dateUpdated;
  }

  /**
   * setEmployeeNumberForUpdate
   * @param String
   */
  public void setEmployeeNumberForUpdate(String s)
  {
    if(s == null)
    {
      m_employeeNumberForUpdate = "";
    }
    else
    {
      m_employeeNumberForUpdate = s;
    }
  }

  /**
   * setProcessNameUpdated
   * @param String
   */
  public void setProcessNameUpdated(String s)
  {
    if(s == null)
    {
      m_processNameUpdated = "";
    }
    else
    {
      m_processNameUpdated = s;
    }
  }

  /**
   * setStagingAreaPriorityNumber
   * @param int
   */
  public void setStagingAreaPriorityNumber(int stagingAreaPriorityNumber)
  {
     m_stagingAreaPriorityNumber = stagingAreaPriorityNumber;
  }

  /**
   * setTransactionDate
   * @param transactionDate
   */
  public void setTransactionDate(Date transactionDate)
  {
    m_transactionDate = transactionDate;
  }

  /**
   * setInterceptOidNumber
   * @param int
   */
  public void setInterceptOidNumber(int i)
   {
       if (m_interceptOidNumber == 0)
      {
          m_interceptOidNumber = i;
      }
  }


  public boolean equals(Object i) {
    if ( ( (Intercept) i).getInterceptOidNumber() == getInterceptOidNumber() ) {
      return true;
    }
    return false;
  }

   /**
    * toString
    * @return String
    */
    public String toString()
    {
      String s = "";

      s +=  "Intercept object -- " + "\n";
      s += "interceptOidNumber         : " + m_interceptOidNumber+ "\n";
      s += "shipmentOidNumber          : " + m_shipmentOidNumber+ "\n";
      s += "pieceOidNumber             : " + m_pieceOidNumber+ "\n";
      s += "interceptCode              : " + m_interceptCode+ "\n";
      s += "activeFlag                 : " + m_activeFlag+ "\n";
      s += "createDate                 : " + m_createDate+ "\n";
      s += "employeeNumberForCreation  : " + m_employeeNumberForCreation+ "\n";
      s += "processNameCreated         : " + m_processNameCreated+ "\n";
      s += "dateUpdated                : " + m_dateUpdated+ "\n";
      s += "employeeNumberForUpdate    : " + m_employeeNumberForUpdate+ "\n";
      s += "processNameUpdated         : " + m_processNameUpdated+ "\n";
      s += "stagingAreaPriorityNumber  : " + m_stagingAreaPriorityNumber+ "\n";
      s += "transactionDate            : " + m_transactionDate+ "\n";
      s += "agencyCode                 : " + m_agencyCode+ "\n";
      s += "fromRecurringCriteriaFlag  : " + m_fromRecurringCriteriaFlag+ "\n";
      s += "interceptLocationCode      : " + m_interceptLocationCode + "\n";
      s += "agencyLocationCode         : " + m_agencyLocationCode + "\n";
      return s;
    }
}
