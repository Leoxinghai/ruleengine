package cciij.cciidata;
/**
 * Title: HandlingInstructions Role Class
 * Description:
 * Copyright:  Copyright (c) 2001
 * Company:  Fedex Services
 * @author
 * @version 1.0
 * *
 * Modification history:
 * 1/20/2003    Tom Knobeloch  modified members and methods to handle the addition
 *                             of LOCATION_CD in the database table definition as
 *                             a new member.  added new instantiation method with
 *                             new parameter.
 */

import java.util.Date;
import java.io.Serializable;

public class HandlingInstructions implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: HandlingInstructions.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int    m_handlingInstructionOidNumber;
  private int    m_shipmentOidNumber;
  private int    m_pieceOidNumber;
  private String m_locationCode = "";
  private String m_handlingInstructionCode = "";
  private String m_handlingInstructionDescription = "";
  private String m_activeFlag = "";
  private String m_employeeNumber = "";
  private Date   m_createDate;
  private String m_createProcessName = "";
  private Date   m_updateDate;
  private String m_updateEmployeeNumber = "";
  private String m_updateProcessName = "";

  /**
  * HandlingInstructions
  */
  public HandlingInstructions()
  {
  }

  /**
   * HandlingInstructions
   * @param int handlingInstructionOidNumber
   * @param int shipmentOidNumber
   * @param int pieceOidNumber
   * @param String locationCode
   * @param String handlingInstructionCode
   * @param String handlingInstructionDescription
   * @param String activeFlag
   * @param Date createDate
   * @param String employeeNumber
   * @param String createdProcessName
   * @param Date updateDate
   * @param String employeeNumberForUpdate
   * @param String updatedProcessName
   */
  public HandlingInstructions(int handlingInstructionOidNumber,
                              int shipmentOidNumber,
                              int pieceOidNumber,
                              String locationCode,
                              String handlingInstructionCode,
                              String handlingInstructionDescription,
                              String activeFlag,
                              Date createDate,
                              String employeeNumber,
                              String createdProcessName,
                              Date updateDate,
                              String employeeNumberForUpdate,
                              String updatedProcessName)
  {
     setHandlingInstructionOidNumber(handlingInstructionOidNumber);
     setShipmentOidNumber(shipmentOidNumber);
     setPieceOidNumber(pieceOidNumber);
     setLocationCode(locationCode);
     setHandlingInstructionCode(handlingInstructionCode);
     setHandlingInstructionDescription(handlingInstructionDescription);
     setActiveFlag(activeFlag);
     setEmployeeNumber(employeeNumber);
     setCreateDate(createDate);
     setCreateProcessName(createdProcessName);
     setUpdateDate(updateDate);
     setUpdateEmployeeNumber(employeeNumberForUpdate);
     setUpdateProcessName(updatedProcessName);
  }

  /**
   * HandlingInstructions
   * @param int handlingInstructionOidNumber
   * @param int shipmentOidNumber
   * @param int pieceOidNumber
   * @param String handlingInstructionCode
   * @param String handlingInstructionDescription
   * @param String activeFlag
   * @param Date createDate
   * @param String employeeNumber
   * @param String createdProcessName
   * @param Date updateDate
   * @param String employeeNumberForUpdate
   * @param String updatedProcessName
   */
  public HandlingInstructions(int handlingInstructionOidNumber,
                              int shipmentOidNumber,
                              int pieceOidNumber,
                              String handlingInstructionCode,
                              String handlingInstructionDescription,
                              String activeFlag,
                              Date createDate,
                              String employeeNumber,
                              String createdProcessName,
                              Date updateDate,
                              String employeeNumberForUpdate,
                              String updatedProcessName)
  {
     this(handlingInstructionOidNumber, shipmentOidNumber, pieceOidNumber,
          "", handlingInstructionCode, handlingInstructionDescription,
          activeFlag, createDate, employeeNumber, createdProcessName,
          updateDate, employeeNumberForUpdate, updatedProcessName);
  }

  /**
   * finalize
   */
  protected void finalize()
  {
  }

  /**
   * getHandlingInstrOidNbr
   * @return int
   */
  public int getHandlingInstructionOidNumber()
  {
     return m_handlingInstructionOidNumber;
  }

  /**
   * getShipmentOidNbr
   * @return int
   */
  public int getShipmentOidNumber()
  {
     return m_shipmentOidNumber;
  }

  /**
   * getPieceOidNumber()
   * @return int
   */
  public int getPieceOidNumber()
  {
     return m_pieceOidNumber;
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
   * getHandlingInstructionCode
   * @return String
   */
  public String getHandlingInstructionCode()
  {
     return m_handlingInstructionCode;
  }

  /**
   * getHandlingInstructionDescription
   * @return String
   */
  public String getHandlingInstructionDescription()
  {
     return m_handlingInstructionDescription;
  }

  /**
   * getActiveFlag
   * @return String
   */
  public String getActiveFlag()
  {
     return m_activeFlag;
  }

  /**
   * getEmployeeNumber
   * @return String
   */
  public String getEmployeeNumber()
  {
     return m_employeeNumber;
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
   * getCreateProcessName
   * @return String
   */
  public String getCreateProcessName()
  {
     return m_createProcessName;
  }

  /**
   * getUpdateDate
   * @return Date
   */
  public Date getUpdateDate()
  {
     return m_updateDate;
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
   * getUpdateProcessName
   * @return String
   */
  public String getUpdateProcessName()
  {
     return m_updateProcessName;
  }

  /**
   * setHandlingInstructionOidNbr
   * @param int
   */
  private void setHandlingInstructionOidNumber(int i)
  {
     if (m_handlingInstructionOidNumber == 0)
     {
        m_handlingInstructionOidNumber = i;
     }
  }

  /**
   * setShipmentOidNbr
   * @param int
   */
  public void setShipmentOidNumber(int i)
  {
     if (m_shipmentOidNumber == 0)
     {
        m_shipmentOidNumber = i;
     }
  }

  /**
   * setPieceOidNbr
   * @param int
   */
  public void setPieceOidNumber(int i)
  {
     if (m_pieceOidNumber == 0)
     {
        m_pieceOidNumber = i;
     }
  }

  /**
   * setLocationCode
   * @param String
   */
  private void setLocationCode(String s)
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
   * setHandlingInstructionCode
   * @param String
   */
  private void setHandlingInstructionCode(String s)
  {
     if(s == null)
     {
        m_handlingInstructionCode = "";
     }
     else
     {
        m_handlingInstructionCode = s;
     }
  }

  /**
   * setHandlingInstructionDescription
   * @param String
   */
  public void setHandlingInstructionDescription(String s)
  {
     if(s == null)
     {
        m_handlingInstructionDescription = "";
     }
     else
     {
        m_handlingInstructionDescription = s;
     }
  }

  /**
   * setActiveFlag
   * @param String
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
   * setActiveFlag
   * @param boolean
   */
  public void setActiveFlag(boolean b)
  {
     if (b ==  true )
     {
        m_activeFlag = "Y";
     }
     else
     {
        m_activeFlag = "N";
     }
  }

  /**
   * setEmployeeNumber
   * @param String
   */
  private void setEmployeeNumber(String s)
  {
     if(s == null)
     {
        m_employeeNumber = "";
     }
     else
     {
        m_employeeNumber = s;
     }
  }

  /**
   * setCreateDate
   * @param newDate
   */
  private void setCreateDate(Date newDate)
  {
     m_createDate = newDate;
  }

  /**
   * setCreatedProcessName
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
   * setUpdateDate
   * @param newDate
   */
  public void setUpdateDate(Date newDate)
  {
     m_updateDate = newDate;
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
   * setUpdateProcessName
   * @param String
   */
  public void setUpdateProcessName(String s)
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
   * toString
   * @return String
   */
  public String toString()
  {
     String s = "";

     s +=  "HandlingInstructions object -- " + "\n";

     s += "handlingInstructionOidNumber   : " + m_handlingInstructionOidNumber+ "\n";
     s += "shipmentOidNumber              : " + m_shipmentOidNumber+ "\n";
     s += "pieceOidNumber                 : " + m_pieceOidNumber+ "\n";
     s += "locationCode                   : " + m_locationCode + "\n";
     s += "handlingInstructionCode        : " + m_handlingInstructionCode+ "\n";
     s += "handlingInstructionDescription : " + m_handlingInstructionDescription+ "\n";
     s += "activeFlag                     : " + m_activeFlag+ "\n";
     s += "employeeNumber                 : " + m_employeeNumber+ "\n";
     s += "createDate                     : " + m_createDate+ "\n";
     s += "createProcessName              : " + m_createProcessName+ "\n";
     s += "updateDate                     : " + m_updateDate+ "\n";
     s += "updateEmployeeNumber           : " + m_updateEmployeeNumber+ "\n";
     s += "updateProcessName              : " + m_updateProcessName+ "\n";

     return s;
  }
}