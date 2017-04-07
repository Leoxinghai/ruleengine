package cciij.cciidata;

/**
 *
 * Title:        CCII
 * Description:  Reperesent a record in the SHIPEMENT_REMARK table
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Dan St. John
 * @version 1.0
 *
 * Modification History:
 * 10/30/2003   Tom Knobeloch  corrected spelling errors/typos
 *                             corrected member data typing
 */
import java.util.*;
import java.io.Serializable;

public class ShipmentRemark  implements Serializable
{
  // SHIPMENT_REMARK_OID_NBR NUMBER(10) PK
  private int m_shipmentRemarkOidNbr;
  // SHIPMENT_OID_NBR NUMBER(10)
  private int m_shipmentOidNbr;
  //LOCATION_CD VARCHAR2(5) default 'YYZ'
  private String m_locationCd = "";
  // SHIPMENT_REMARK_CD VARCHAR2(4)
  private String m_shipmentRemarkCd = "";
  //PIECE_OID_NBR NUMBER(10)
  private int m_pieceOidNbr;
  //REMARK_DESC VARCHAR2(255) not null,
  private String m_remarkDesc = "";
  //CREATE_DT DATE
  private Date m_createDt = new Date(0);
  // CREATE_EMPLOYEE_NBR VARCHAR2(10)
  private String m_createEmployeeNbr = "";
  //CREATE_PROCESS_NM VARCHAR2(20)
  private String m_createProcessNm = "";
  //UPDATE_DT DATE
  private Date m_updateDt = new Date(0);
  // UPDATE_EMPLOYEE_NBR VARCHAR2(10)
  private String m_updateEmployeeNbr = "";
  //UPDATE_PROCESS_NM VARCHAR2(20)
  private String m_updateProcessNm = "";
  //AGENCY_CD VARCHAR2(2)
  private String m_agencyCd = "";
    
  /**
   * ShipmentRemark constructor comment.
   */
  public ShipmentRemark() {
  }
  
  /**
   * ShipmentRemark constructor comment.
   */
  public ShipmentRemark(
    int shipmentRemarkOidNbr,
    int shipmentOidNbr,
    String locationCd,
    String shipmentRemarkCd,
    int pieceOidNbr,
    String remarkDesc,
    Date createDt,
    String createEmployeeNbr,
    String createProcessNm,
    Date updateDt,
    String updateEmployeeNbr,
    String updateProcessNm)
  {
    m_shipmentRemarkOidNbr = shipmentRemarkOidNbr;
    m_shipmentOidNbr = shipmentOidNbr;
    m_locationCd = locationCd;
    m_shipmentRemarkCd = shipmentRemarkCd;
    m_pieceOidNbr = pieceOidNbr;
    m_remarkDesc = remarkDesc;
    if (createDt == null)
    {
      m_createDt = new Date(0);
    }
    else
    {
      m_createDt = createDt;
    }
    m_createEmployeeNbr = createEmployeeNbr;
    m_createProcessNm = createProcessNm;
    if (updateDt == null)
    {
      m_updateDt = new Date(0);
    }
    else
    {
      m_updateDt = updateDt;
    }
    m_updateEmployeeNbr = updateEmployeeNbr;
    m_updateProcessNm = updateProcessNm;
  }
  
  /**
   * ShipmentRemark constructor comment.
   */
  public ShipmentRemark(
    int shipmentRemarkOidNbr,
    int shipmentOidNbr,
    String locationCd,
    String shipmentRemarkCd,
    int pieceOidNbr,
    String remarkDesc,
    Date createDt,
    String createEmployeeNbr,
    String createProcessNm,
    Date updateDt,
    String updateEmployeeNbr,
    String updateProcessNm,
    String agencyCd)
  {
    m_shipmentRemarkOidNbr = shipmentRemarkOidNbr;
    m_shipmentOidNbr = shipmentOidNbr;
    m_locationCd = locationCd;
    m_shipmentRemarkCd = shipmentRemarkCd;
    m_pieceOidNbr = pieceOidNbr;
    m_remarkDesc = remarkDesc;
    if (createDt == null)
    {
      m_createDt = new Date(0);
    }
    else
    {
      m_createDt = createDt;
    }
    m_createEmployeeNbr = createEmployeeNbr;
    m_createProcessNm = createProcessNm;
    if (updateDt == null)
    {
      m_updateDt = new Date(0);
    }
    else
    {
      m_updateDt = updateDt;
    }
    m_updateEmployeeNbr = updateEmployeeNbr;
    m_updateProcessNm = updateProcessNm;
    m_agencyCd = agencyCd;
  }
  
  /**
   * getCreateDt
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return Date
   */
  public Date getCreateDt() {
    return m_createDt;
  }
  
  /**
   * getCreateEmployeeNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getCreateEmployeeNbr() {
    return m_createEmployeeNbr;
  }
  
  /**
   * getCreateProcessNm
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getCreateProcessNm() {
    return m_createProcessNm;
  }
  
  /**
   * getLocationCd
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getLocationCd() {
    return m_locationCd;
  }
  
  /**
   * getPieceOidNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return int
   */
  public int getPieceOidNbr() {
    return m_pieceOidNbr;
  }
  
  /**
   * getRemarkDesc
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getRemarkDesc() {
    return m_remarkDesc;
  }
  
  /**
   * getShipmentRemarkCd
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getShipmentRemarkCd() {
    return m_shipmentRemarkCd;
  }
  
  /**
   * getShipmentRemarkOidNbr
   * Creation date: (1/27/2003 1:12:33 PM)
   * @return int
   */
  public int getShipmentRemarkOidNbr() {
    return m_shipmentRemarkOidNbr;
  }
  
  /**
   * getShipmentOidNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return int
   */
  public int getShipmentOidNbr() {
    return m_shipmentOidNbr;
  }
  
  /**
   * getUpdateDt
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return Date
   */
  public Date getUpdateDt() {
    return m_updateDt;
  }
  
  /**
   * getUpdateEmployeeNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getUpdateEmployeeNbr() {
    return m_updateEmployeeNbr;
  }
  
  /**
   * getUpdateProcessNm
   * Creation date: (1/27/2003 1:07:57 PM)
   * @return String
   */
  public String getUpdateProcessNm() {
    return m_updateProcessNm;
  }
  
  /**
   * getAgencyCd
   * Creation date: (10/13/2004 20:07:57 PM)
   * @return String
   */
  public String getAgencyCd() {
    return m_agencyCd;
  }
  
  /**
   * setCreateDt
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param Date newCreateDt
   */
  public void setCreateDt(Date newCreateDt) {
    m_createDt = newCreateDt;
  }

  /**
   * setCreateEmployeeNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setCreateEmployeeNbr(String s) {
    if (s == null)
    {
      m_createEmployeeNbr = "";
    }
    else
    {
      m_createEmployeeNbr = s;
    }
  }
  
  /**
   * setCreateProcessNm
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setCreateProcessNm(String s) {
    if (s == null)
    {
      m_createProcessNm = "";
    }
    else
    {
      m_createProcessNm = s;
    }
  }
  
  /**
   * setLocationCd
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setLocationCd(String s) {
    if (s == null)
    {
      m_locationCd = "";
    }
    else
    {
      m_locationCd = s;
    }
  }
  
  /**
   * setPieceOidNbr.
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param int newPieceOidNbr
   */
  public void setPieceOidNbr(int newPieceOidNbr) {
    m_pieceOidNbr = newPieceOidNbr;
  }
  
  /**
   * setRemarkDesc
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setRemarkDesc(String s) {
    if (s == null)
    {
      m_remarkDesc = "";
    }
    else
    {
      m_remarkDesc = s;
    }
  }
  
  /**
   * setShipmentRemarkCd
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setShipmentRemarkCd(String s) {
    if (s == null)
    {
      m_shipmentRemarkCd = "";
    }
    else
    {
      m_shipmentRemarkCd = s;
    }
  }
  
  /**
   * setShipmentOidNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param int newShipmentOidNdrg
   */
  public void setShipmentOidNbr(int newShipmentOidNbr) {
    m_shipmentOidNbr = newShipmentOidNbr;
  }
  
  /**
   * setUpdateDt
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param Date newUpdateDt
   */
  public void setUpdateDt(Date newUpdateDt) {
    m_updateDt = newUpdateDt;
  }
  
  /**
   * setUpdateEmployeeNbr
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setUpdateEmployeeNbr(String s) {
    if (s == null)
    {
      m_updateEmployeeNbr = "";
    }
    else
    {
      m_updateEmployeeNbr = s;
    }
  }
  
  /**
   * setUpdateProcessNm
   * Creation date: (1/27/2003 1:07:57 PM)
   * @param String s
   */
  public void setUpdateProcessNm(String s) {
    if (s == null)
    {
      m_updateProcessNm = "";
    }
    else
    {
      m_updateProcessNm = s;
    }
  }
  
  /**
   * setAgencyCd
   * Creation date: (10/13/2004 20:07:57 PM)
   * @param String s
   */
  public void setAgencyCd(String s) {
    if (s == null)
    {
      m_agencyCd = "";
    }
    else
    {
      m_agencyCd = s;
    }
  }

  /**
   * toString
   * @return String
   */
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("SHIPMENT_REMARK object -- \n");
    sb.append("SHIPMENT_REMARK_OID_NBR : " + this.m_shipmentRemarkOidNbr + "\n" );
    sb.append("SHIPMENT_OID_NBR        : " + this.m_shipmentOidNbr + "\n" );
    sb.append("LOCATION_CD             : " + this.m_locationCd + "\n" );
    sb.append("SHIPMENT_REMARK_CD      : " + this.m_shipmentRemarkCd + "\n" );
    sb.append("PIECE_OID_NBR           : " + this.m_pieceOidNbr + "\n" );
    sb.append("REMARK_DESC             : " + this.m_remarkDesc + "\n" );
    sb.append("CREATE_DT               : " + this.m_createDt + "\n" );
    sb.append("CREATE_EMPLOYEE_NBR     : " + this.m_createEmployeeNbr + "\n" );
    sb.append("CREATE_PROCESS_NM       : " + this.m_createProcessNm + "\n" );
    sb.append("UPDATE_DT               : " + this.m_updateDt + "\n" );
    sb.append("UPDATE_EMPLOYEE_NBR     : " + this.m_updateEmployeeNbr + "\n" );
    sb.append("UPDATE_PROCESS_NM       : " + this.m_updateProcessNm + "\n" );
    sb.append("AGENCY_CD               : " + this.m_agencyCd + "\n" );

    return sb.toString();
  }
}
