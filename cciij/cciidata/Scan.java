package cciij.cciidata;

/**
 * Title:        CCII Data Classes
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Dan Krucoff
 * @version 1.0

 Modification history:
 * 4/28/2003     Tom Knobeloch  Added member and methods for INPUT_METHOD_CD
 *
 * 1/30/2003     Dan St John M Added Constructor to use locationCd
 *                           for mulitsite port and set locationCd to
 *                           "" in existing constuctor
 *
 *
 *
 */

import java.util.*;
import java.io.Serializable;
import cciij.businessActions.*;

public class Scan implements Serializable, Cloneable
{
    private static final String m_whatVersion =
        "@(#) $RCSfile: Scan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

    private int m_scanOidNumber;
    private int m_pieceOidNumber;
    private int m_shipmentOidNumber;
    private Date m_scanDate = new Date(0);
    private String m_employeeNumber = "";
    private String m_scanTypeCode = "";
    private String m_locStatNumber = "";
    private String m_stagingAreaCode = "";
    private String m_stagingAreaFlag = "";
    private String m_fromConsFlag = "";
    private Date m_sortDate = new Date(0);
    private String m_scanLocationDescription = "";
    private String m_locationCd = ""; // DSJ
    private String m_warehouseCd = null;
    private String m_inputMethodCd = "";
    private String m_commentDesc = "";

    /**
     * Scan
     */
    public Scan()
    {
    }
/**
 * Scan
 * @param int scanOidNumber
 * @param int pieceOidNumber
 * @param int shipmentOidNumber
 * @param java.sql.Timestamp scanDate
 * @param String employeeNumber
 * @param String scanTypeCode
 * @param String locStatNumber
 * @param String stagingAreaCode
 * @param String stagingAreaFlag
 * @param String fromConsFlag
 * @param Date sortDate
 * @param String warehouseCd
 */
public Scan(
             int scanOidNumber,
             int pieceOidNumber,
             int shipmentOidNumber,
             Date scanDate,
             String employeeNumber,
             String scanTypeCode,
             String locStatNumber,
             String stagingAreaCode,
             String stagingAreaFlag,
             String fromConsFlag,
             Date sortDate,
             String warehouseCd)
    {
       m_scanOidNumber = scanOidNumber;
       m_pieceOidNumber = pieceOidNumber;
       m_shipmentOidNumber = shipmentOidNumber;
       m_scanDate = scanDate;
       setEmployeeNumber(employeeNumber);
       setScanTypeCode(scanTypeCode);
       setLocStatNumber(locStatNumber);
       setStagingAreaCode(stagingAreaCode);
       setStagingAreaFlag(stagingAreaFlag);
       setFromConsFlag(fromConsFlag);
       m_sortDate = sortDate;
       m_locationCd = ""; //DSJ
       m_warehouseCd = warehouseCd;
    }
/**
 * Scan
 * @param int scanOidNumber
 * @param int pieceOidNumber
 * @param int shipmentOidNumber
 * @param java.sql.Timestamp scanDate
 * @param String employeeNumber
 * @param String scanTypeCode
 * @param String locStatNumber
 * @param String stagingAreaCode
 * @param String stagingAreaFlag
 * @param String fromConsFlag
 * @param Date sortDate
 * @param String warehouseCd
 */
public Scan(
             int scanOidNumber,
             int pieceOidNumber,
             int shipmentOidNumber,
             Date scanDate,
             String employeeNumber,
             String scanTypeCode,
             String locStatNumber,
             String stagingAreaCode,
             String stagingAreaFlag,
             String fromConsFlag,
             Date sortDate,
             String locationCd,
             String warehouseCd )
    {
       m_scanOidNumber = scanOidNumber;
       m_pieceOidNumber = pieceOidNumber;
       m_shipmentOidNumber = shipmentOidNumber;
       m_scanDate = scanDate;
       setEmployeeNumber(employeeNumber);
       setScanTypeCode(scanTypeCode);
       setLocStatNumber(locStatNumber);
       setStagingAreaCode(stagingAreaCode);
       setStagingAreaFlag(stagingAreaFlag);
       setFromConsFlag(fromConsFlag);
       m_sortDate = sortDate;
       m_locationCd = locationCd; //DSJ
       m_warehouseCd = warehouseCd;
   }
/**
 * Scan
 * @param int scanOidNumber
 * @param int pieceOidNumber
 * @param int shipmentOidNumber
 * @param java.sql.Timestamp scanDate
 * @param String employeeNumber
 * @param String scanTypeCode
 * @param String locStatNumber
 * @param String stagingAreaCode
 * @param String stagingAreaFlag
 * @param String fromConsFlag
 * @param Date sortDate
 * @param String warehouseCd
 * @param String inputMethodCd
 */
public Scan(
             int scanOidNumber,
             int pieceOidNumber,
             int shipmentOidNumber,
             Date scanDate,
             String employeeNumber,
             String scanTypeCode,
             String locStatNumber,
             String stagingAreaCode,
             String stagingAreaFlag,
             String fromConsFlag,
             Date sortDate,
             String locationCd,
             String warehouseCd,
             String inputMethodCd,
             String commentDesc)
    {
       m_scanOidNumber = scanOidNumber;
       m_pieceOidNumber = pieceOidNumber;
       m_shipmentOidNumber = shipmentOidNumber;
       m_scanDate = scanDate;
       setEmployeeNumber(employeeNumber);
       setScanTypeCode(scanTypeCode);
       setLocStatNumber(locStatNumber);
       setStagingAreaCode(stagingAreaCode);
       setStagingAreaFlag(stagingAreaFlag);
       setFromConsFlag(fromConsFlag);
       m_sortDate = sortDate;
       m_locationCd = locationCd; //DSJ
       m_warehouseCd = warehouseCd;
       setInputMethodCode(inputMethodCd);
       setCommentDescription(commentDesc);
   }
    /**
    * finalize
    */
    protected void finalize()
    {
    }

    /**
     * getWarehouseCd
     * @return String
     */
    public String getWarehouseCd()
    {
       return m_warehouseCd;
    }

    /**
     * getCommentDescription
     * @return String
     */
    public String getCommentDescription()
    {
       return m_commentDesc;
    }
    /**
     * setWarehouseCd
     * @param String warehouseCd
     */
    public void setWarehouseCd( String warehouseCd )
    {
       this.m_warehouseCd = warehouseCd;
    }

    /**
     * getEmployeeNumber
     * @return String
     */
    public String getEmployeeNumber() {
        return m_employeeNumber;
    }
    /**
     * getFromConsFlag
     * @return String
     */
    public String getFromConsFlag() {
        return m_fromConsFlag;
    }
    /**
    * getLocationCd
    * @return String
    */
    public String getLocationCd() {
        return m_locationCd;
    }
    /**
     * getLocStatNumber
     * @return String
     */
    public String getLocStatNumber() {
        return m_locStatNumber;
    }
    /**
     * getPieceOidNumber
     * @return int
     */
    public int getPieceOidNumber() {
        return m_pieceOidNumber;
    }
    /**
     * getScanDate
     * @return java.sql.Timestamp
     */
    public Date getScanDate() {
        return m_scanDate;
    }
    /**
     * getScanLocationDescription()
     * @return String
     */
    public String getScanLocationDescription() {
        return m_scanLocationDescription;
    }
    /**
     * getScanOidNumber
     * @return int
     */
    public int getScanOidNumber() {
        return m_scanOidNumber;
    }
    /**
     * getScanTypeCode
     * @return String
     */
    public String getScanTypeCode() {
        return m_scanTypeCode;
    }
    /**
     * getShipmentOidNumber
     * @return int
     */
    public int getShipmentOidNumber() {
        return m_shipmentOidNumber;
    }
    /**
     * getSortDate
     * @return Date
     */
    public Date getSortDate() {
        return m_sortDate;
    }
    /**
     * getStagingAreaCode
     * @return String
     */
    public String getStagingAreaCode() {
        return m_stagingAreaCode;
    }
    /**
     * getStagingAreaFlag
     * @return String
     */
    public String getStagingAreaFlag() {
        return m_stagingAreaFlag;
    }
    /**
     * getInputMethodCode
     * @return String
     */
    public String getInputMethodCode() {
        return m_inputMethodCd;
    }
    /**
     * setEmployeeNumber
     * @param String empNumber
     */
    public void setEmployeeNumber(String empNumber) {
        if (empNumber == null) {
            m_employeeNumber = "";
        } else {
            m_employeeNumber = empNumber;
        }
    }
    /**
     * setFromConsFlag
     * @param String
     */
    public void setFromConsFlag(String flg) {
        if (flg == null) {
            m_fromConsFlag = "";
        } else {
            m_fromConsFlag = flg;
        }
    }
    /**
     * setLocationCd
     * @param String
     */
    public void setLocationCd(String s) {
        if (s == null) {
            m_locationCd = "";
        } else {
            m_locationCd = s;
        }
    }
    /**
     * setLocStatNumber
     * @param String
     */
    public void setLocStatNumber(String lsn) {
        if (lsn == null) {
            m_locStatNumber = "";
        } else {
            m_locStatNumber = lsn;
        }
    }
    /**
    * setPieceOidNumber
    * @param int oid
    */
    public void setPieceOidNumber(int oid) {
        m_pieceOidNumber = oid;
    }
    /**
     * setScanDate
     * @param long lDt
     */
    public void setScanDate(long lDt) {
        m_scanDate = new Date(lDt);
    }
    /**
     * setScanDate
     * @param Date dt
     */
    public void setScanDate(Date dt) {
        m_scanDate = dt;
    }
    /**
     * setScanLocationDescription
     * @param String
     */
    public void setScanLocationDescription(String s) {
        if (s == null) {
            m_scanLocationDescription = "";
        } else {
            m_scanLocationDescription = s;
        }
    }
    /**
     * setScanOidNumber
     * @param int
     */
    public void setScanOidNumber(int i) {
        if (m_scanOidNumber == 0) {
            m_scanOidNumber = i;
        }
    }
    /**
     * setScanTypeCode
     * @param String
     */
    public void setScanTypeCode(String type) {
        if (type == null) {
            m_scanTypeCode = "";
        } else {
            m_scanTypeCode = type;
        }
    }
    /**
     * setShipmentOidNumber
     * @param int oid
     */
    public void setShipmentOidNumber(int oid) {
        m_shipmentOidNumber = oid;
    }
    /**
     * setSortDate
     * @parma long
     */
    public void setSortDate(long lDt) {
        m_sortDate = new Date(lDt);
    }
    /**
     * setSortDate
     * @param Date
     */
    public void setSortDate(Date dt) {
        m_sortDate = dt;
    }
    /**
     * setStagingAreaCode
     * @param String
     */
    public void setStagingAreaCode(String sac) {
        if (sac == null) {
            m_stagingAreaCode = "";
        } else {
            m_stagingAreaCode = sac;
        }
    }
    /**
     * setStagingAreaFlag
     * @param String
     */
    public void setStagingAreaFlag(String flg) {
        if (flg == null) {
            m_stagingAreaFlag = "";
        } else {
            m_stagingAreaFlag = flg;
        }
    }
    /**
     * setInputMethodCode
     * @param String
     */
    public void setInputMethodCode(String cd) {
        if (cd == null) {
            m_inputMethodCd = "";
        } else {
            m_inputMethodCd = cd;
        }
    }
    /**
     * setCommentDescription
     * @param String
     */
    public void setCommentDescription(String comment) {
        if (comment == null) {
            m_commentDesc = "";
        } else {
            m_commentDesc = comment;
        }
    }
    /**
     * toString
     * @return String
     */
    public String toString() {
        String s = "";

        s += "Scan object -- " + "\n";

        s += "scanOidNumber     : " + m_scanOidNumber + "\n";
        s += "pieceOidNumber    : " + m_pieceOidNumber + "\n";
        s += "shipmentOidNumber : " + m_shipmentOidNumber + "\n";
        s += "scanDate          : " + m_scanDate + "\n";
        s += "employeeNumber    : " + m_employeeNumber + "\n";
        s += "scanTypeCode      : " + m_scanTypeCode + "\n";
        s += "locStatNumber     : " + m_locStatNumber + "\n";
        s += "stagingAreaCode   : " + m_stagingAreaCode + "\n";
        s += "stagingAreaFlag   : " + m_stagingAreaFlag + "\n";
        s += "sortDate          : " + m_sortDate + "\n";
        s += "scanLocationDesc  : " + m_scanLocationDescription + "\n";
        s += "locationCd        : " + m_locationCd + "\n";
        s += "warehouseCd       : " + m_warehouseCd + "\n";
        s += "inputMethodCd     : " + m_inputMethodCd + "\n";
	s += "commentDesc       : " + m_commentDesc + "\n";

        return s;
    }

  public Object clone()
  {
     Scan copy = null;
     try
     {
       copy = (Scan)super.clone();
     }
     catch(CloneNotSupportedException e)
     {
       throw new InternalError(e.toString());
     }
     if(getScanDate() == null)
     {
       copy.setScanDate(null);
     }
     else
     {
       copy.setScanDate((java.util.Date)getScanDate().clone());
     }
     if(getSortDate() == null)
     {
       copy.setSortDate(null);
     }
     else
     {
       copy.setSortDate((java.util.Date)getSortDate().clone());
     }
     return copy;
   }

}
