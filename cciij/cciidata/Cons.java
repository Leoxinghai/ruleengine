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


public class Cons  implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: Cons.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int m_consOidNumber;
  private String m_trackingNumber = "";
  private String m_formTypeCode = "";
  private String m_consNumber = "";
  private String m_consFormTypeCode = "";
  private int m_oidNumber;
  private String m_oidTypeCode = "";
  private Date m_gmtScanDate = new Date(0);
  private String m_deconsFlag = "";
  private String m_updateSourceDescription = "";
  private Date m_updateDate = new Date(0);

  /**
   * Cons
   */
  public Cons()
  {
  }

  /**
   * Cons
   * @param consOidNumber
   * @param trackingNumber
   * @param formTypeCode
   * @param consNumber
   * @param consFormTypeCode
   * @param oidNumber
   * @param oidTypeCode
   * @param gmtScanDate
   * @param deconsFlag
   * @param updateSourceDescription
   * @param updateDate
   */
  public Cons(int consOidNumber,
              String trackingNumber,
              String formTypeCode,
              String consNumber,
              String consFormTypeCode,
              int oidNumber,
              String oidTypeCode,
              Date gmtScanDate,
              String deconsFlag,
              String updateSourceDescription,
              Date updateDate)
  {
    m_consOidNumber = consOidNumber;
    setTrackingNumber(trackingNumber);
    setFormTypeCode(formTypeCode);
    setConsNumber(consNumber);
    setConsFormTypeCode(consFormTypeCode);
    m_oidNumber = oidNumber;
    setOidTypeCode(oidTypeCode);
    m_gmtScanDate = gmtScanDate;
    setDeconsFlag(deconsFlag);
    setUpdateSourceDescription(updateSourceDescription);
    setUpdateDate(updateDate);
  }

   /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getConsOidNumber
   * @return int
   */
  public int getConsOidNumber()
  {
    return m_consOidNumber;
  }

  /**
   * getTrackingNumber
   * @return String
   */
  public String getTrackingNumber()
  {
    return m_trackingNumber;
  }

  /**
   * getFormTypeCode
   * @return String
   */
  public String getFormTypeCode()
  {
    return m_formTypeCode;
  }

  /**
   * getConsNumber
   * @return String
   */
  public String getConsNumber()
  {
    return m_consNumber;
  }

  /**
   * getConsFormTypeCode
   * @return String
   */
  public String getConsFormTypeCode()
  {
    return m_consFormTypeCode;
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
   * getGMTScanDate
   * @return Date
   */
  public Date getGMTScanDate()
  {
    return m_gmtScanDate;
  }

  /**
   * getDeconsFlag
   * @return String
   */
  public String getDeconsFlag()
  {
    return m_deconsFlag;
  }

  /**
   * getUpdateSourceDescription
   * @return String
   */
  public String getUpdateSourceDescription()
  {
    return m_updateSourceDescription;
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
   * setTrackingNumber
   * @param String
   */
  private void setTrackingNumber(String s)
  {
    if(s == null)
    {
       m_trackingNumber = "";
    }
    else
    {
      m_trackingNumber = s;
    }
  }

  /**
   * setFormTypeCode
   * @param String
   */
  private void setFormTypeCode(String s)
  {
    if(s == null)
    {
      m_formTypeCode = "";
    }
    else
    {
      m_formTypeCode = s;
    }
  }

  /**
   * setConsNumber
   * @param String
   */
  private void setConsNumber(String s)
  {
    if(s == null)
    {
       m_consNumber = "";
    }
    else
    {
      m_consNumber = s;
    }
  }

  /**
   * setConsFormTypeCode
   * @param String
   */
  private void setConsFormTypeCode(String s)
  {
    if(s == null)
    {
       m_consFormTypeCode = "";
    }
    else
    {
      m_consFormTypeCode = s;
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
   * setDeconsFlag
   * @param String
   */
  public void setDeconsFlag(String s)
  {
    if(s == null)
    {
       m_deconsFlag = "";
    }
    else
    {
      m_deconsFlag = s;
    }
  }

  /**
   * setUpdateSourceDescription
   * @param updateDesc
   */
  public void setUpdateSourceDescription(String  s)
  {
    if(s == null)
    {
      m_updateSourceDescription = s;
    }
    else
    {
      m_updateSourceDescription = s;
    }
  }

  /**
   * setUpdateDate
   * @param updateDt
   */
  public void setUpdateDate(Date updateDt)
  {
    m_updateDate = updateDt;
  }

  /**
   * setConsOidNumber
   * @param int
   */
  public void setConsOidNumber(int i)
  {
    if(m_consOidNumber == 0)
    {
      m_consOidNumber = i;
    }
  }

  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "Cons object -- " + "\n";

         s += "consFormTypeCode        : " + m_consFormTypeCode+ "\n";
         s += "consNumber              : " + m_consNumber+ "\n";
         s += "consOidNumber           : " + m_consOidNumber+ "\n";
         s += "deconsFlag              : " + m_deconsFlag+ "\n";
         s += "formTypeCode            : " + m_formTypeCode+ "\n";
         s += "gmtScanDate             : " + m_gmtScanDate+ "\n";
         s += "oidNumber               : " + m_oidNumber+ "\n";
         s += "oidTypeCode             : " + m_oidTypeCode+ "\n";
         s += "trackingNumber          : " + m_trackingNumber+ "\n";
         s += "updateDate              : " + m_updateDate+ "\n";
         s += "updateSourceDescription : " + m_updateSourceDescription+ "\n";

      return s;
   }


}


