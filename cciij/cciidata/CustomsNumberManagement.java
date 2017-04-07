package cciij.cciidata;



/**
 * Title:        Entry - used to store data from the Entry table
 * Description:
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Joey Cline
 * @version 1.0
 */
import java.io.Serializable;
import java.util.Date;

 public class CustomsNumberManagement implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CustomsNumberManagement.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

  /**
   * Public default constructor
   */
  public CustomsNumberManagement()
  {
  }

  /**
   * Public constructor
   * @param String locationCd
   * @param String customsTypeNbrCd
   * @param Date activatedDt
   * @param String statusCd
   * @param int typeLowNbr
   * @param int typeHighNbr
   * @param int typeLastUsedNbr
   * @param Date createDt
   * @param String createEmployeeNbr
   * @param String lastModifiedNm
   * @param Date lastModifiedTmstp
   */
  public CustomsNumberManagement (
    String locationCd,
    String customsTypeNbrCd,
    Date activatedDt,
    String statusCd,
    int typeLowNbr,
    int typeHighNbr,
    int typeLastUsedNbr,
    Date createDt,
    String createEmployeeNbr,
    String lastModifiedNm,
    Date lastModifiedTmstp )
  {
    setLocationCd(locationCd);
    setCustomsTypeNbrCd(customsTypeNbrCd);
    setActivatedDt(activatedDt);
    setStatusCd(statusCd);
    setTypeLowNbr(typeLowNbr);
    setTypeHighNbr(typeHighNbr);
    setTypeLastUsedNbr(typeLastUsedNbr);
    setCreateDt(createDt);
    setCreateEmployeeNbr(createEmployeeNbr);
    setLastModifiedNm(lastModifiedNm);
    setLastModifiedTmstp(lastModifiedTmstp);
  }

  private String m_locationCd;
  private String m_customsTypeNbrCd;
  private Date m_activatedDt;
  private String m_statusCd;
  private int m_typeLowNbr;
  private int m_typeHighNbr;
  private int m_typeLastUsedNbr;
  private Date m_createDt;
  private String m_createEmployeeNbr;
  private String m_lastModifiedNm;
  private Date m_lastModifiedTmstp;



  public String getLocationCd ()
  {
    return m_locationCd;
  }

  public String getCustomsTypeNbrCd ()
  {
    return m_customsTypeNbrCd;
  }

  public Date getActivatedDt ()
  {
    return m_activatedDt;
  }

  public String getStatusCd ()
  {
    return m_statusCd;
  }

  public int getTypeLowNbr ()
  {
    return m_typeLowNbr;
  }

  public int getTypeHighNbr ()
  {
    return m_typeHighNbr;
  }

  public int getTypeLastUsedNbr ()
  {
    return m_typeLastUsedNbr;
  }

  public Date getCreateDt ()
  {
    return m_createDt;
  }

  public String getCreateEmployeeNbr ()
  {
    return m_createEmployeeNbr;
  }

  public String getLastModifiedNm ()
  {
    return m_lastModifiedNm;
  }

  public Date getLastModifiedTmstp ()
  {
    return m_lastModifiedTmstp;
  }



  public boolean setLocationCd (String val)
  {
    m_locationCd = val;
    return true;
  }

  public boolean setCustomsTypeNbrCd (String val)
  {
    m_customsTypeNbrCd = val;
    return true;
  }

  public boolean setActivatedDt (Date val)
  {
    m_activatedDt = val;
    return true;
  }

  public boolean setStatusCd (String val)
  {
    m_statusCd = val;
    return true;
  }

  public boolean setTypeLowNbr (int val)
  {
    m_typeLowNbr = val;
    return true;
  }

  public boolean setTypeHighNbr (int val)
  {
    m_typeHighNbr = val;
    return true;
  }

  public boolean setTypeLastUsedNbr (int val)
  {
    m_typeLastUsedNbr = val;
    return true;
  }

  public boolean setCreateDt (Date val)
  {
    m_createDt = val;
    return true;
  }

  public boolean setCreateEmployeeNbr (String val)
  {
    m_createEmployeeNbr = val;
    return true;
  }

  public boolean setLastModifiedNm (String val)
  {
    m_lastModifiedNm = val;
    return true;
  }

  public boolean setLastModifiedTmstp (Date val)
  {
    m_lastModifiedTmstp = val;
    return true;
  }

  /**
   * toString
   * @return String
   */
  public String toString()
  {
    StringBuffer sb = new StringBuffer();

    sb.append("LocationCd       : " + m_locationCd + "\n" );
    sb.append("CustomsTypeNbrCd : " + m_customsTypeNbrCd + "\n" );
    sb.append("ActivatedDt      : " + m_activatedDt + "\n" );
    sb.append("StatusCd         : " + m_statusCd + "\n" );
    sb.append("TypeLowNbr       : " + m_typeLowNbr + "\n" );
    sb.append("TypeHighNbr      : " + m_typeHighNbr + "\n" );
    sb.append("TypeLastUsedNbr  : " + m_typeLastUsedNbr + "\n" );
    sb.append("CreateDt         : " + m_createDt + "\n" );
    sb.append("CreateEmployeeNbr: " + m_createEmployeeNbr + "\n" );
    sb.append("LastModifiedNm   : " + m_lastModifiedNm + "\n" );
    sb.append("LastModifiedTmstp: " + m_lastModifiedTmstp + "\n" );

    return sb.toString();
  }
}


