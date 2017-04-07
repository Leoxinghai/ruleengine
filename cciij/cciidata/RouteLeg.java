package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;

public class RouteLeg implements Serializable, Cloneable {
  private static final String m_whatVersion = "@(#) $RCSfile: RouteLeg.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_routeNumber = "";
  private Date m_routeDate = new Date(0);
  private int m_routeLegNumber;
  private String m_MAWBNumber = "";
  private String m_destinationLocCode = "";
  private String m_originLocCode = "";
  private Date m_departureGMTTimestamp = new Date(0);
  private Date m_arrivalGMTTimestamp = new Date(0);
  private Date m_departureLocalTimestamp = new Date(0);
  private Date m_arrivalLocalTimestamp = new Date(0);
  private String m_destinationCountryCode = "";
  private String m_originCountryCode = "";
  private Date m_sortDate = new Date(0);
  private String m_routeLegStatusCd = "";
  private String m_brokerCompleteFlag = "";
  private String m_customsCompleteFlag = "";
  private int m_routeLegOidNumber;

  /**
   * RouteLeg
   */
  public RouteLeg()
  {

  }

  /**
   * RouteLeg
   * @param routeNumber
   * @param routeDate
   * @param routLegNumber
   * @param MAWBNumber
   * @param destinationLocCode
   * @param originLocCode
   * @param departureBMTTimestamp
   * @param arrivalGMTTimestamp
   * @param departureLocalTimestamp
   * @param arrivalLocalTimestamp
   * @param destinationCountryCode
   * @param originCountyCode
   * @param sortDate
   * @param routeLegStatusCd
   * @param brokerCompleteFlag
   * @param customsCompleteFlag
   * @param routeLegOidNumber
   */
  public RouteLeg(String routeNumber,
                  Date routeDate,
                  int routeLegNumber,
                  String MAWBNumber,
                  String destinationLocCode,
                  String originLocCode,
                  Date departureGMTTimestamp,
                  Date arrivalGMTTimestamp,
                  Date departureLocalTimestamp,
                  Date arrivalLocalTimestamp,
                  String destinationCountryCode,
                  String originCountryCode,
                  Date sortDate,
                  String routeLegStatusCd,
                  String brokerCompleteFlag,
                  String customsCompleteFlag,
                  int routeLegOidNumber)
  {
     setRouteNumber(routeNumber);
     m_routeDate = routeDate;
     m_routeLegNumber = routeLegNumber;
     setMAWBNumber(MAWBNumber);
     setDestinationLocCode(destinationLocCode);
     setOriginLocCode(originLocCode);
     m_departureGMTTimestamp = departureGMTTimestamp;
     m_arrivalGMTTimestamp = arrivalGMTTimestamp;
     m_departureLocalTimestamp = departureLocalTimestamp;
     m_arrivalLocalTimestamp = arrivalLocalTimestamp;
     setDestinationCountryCode(destinationCountryCode);
     setOriginCountryCode(originCountryCode);
     m_sortDate = sortDate;
     setRouteLegStatusCd(routeLegStatusCd);
     setBrokerCompleteFlag(brokerCompleteFlag);
     setCustomsCompleteFlag(customsCompleteFlag);
     m_routeLegOidNumber = routeLegOidNumber;
  }

   /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * clone
   */
  public Object clone()
  {
     RouteLeg copy;

     try
     {
        copy = (RouteLeg)super.clone();
     }

     catch(CloneNotSupportedException e)
     {
        System.out.println("RouteLeg.clone() caught: " + e);
        e.printStackTrace(System.out);
        return null;
     }

     if (m_routeDate != null)
     {
        copy.m_routeDate = (Date)m_routeDate.clone();
     }

     if (m_departureGMTTimestamp != null)
     {
        copy.m_departureGMTTimestamp = (Date)m_departureGMTTimestamp.clone();
     }

     if (m_arrivalGMTTimestamp != null)
     {
        copy.m_arrivalGMTTimestamp = (Date)m_arrivalGMTTimestamp.clone();
     }

     if (m_departureLocalTimestamp != null)
     {
        copy.m_departureLocalTimestamp = (Date)m_departureLocalTimestamp.clone();
     }

     if (m_arrivalLocalTimestamp != null)
     {
        copy.m_arrivalLocalTimestamp = (Date)m_arrivalLocalTimestamp.clone();
     }

     if (m_sortDate != null)
     {
        copy.m_sortDate = (Date)m_sortDate.clone();
     }

     return copy;
  }

  /**
   * getRouteNumber
   * @return String
   */
   public String getRouteNumber()
   {
      return m_routeNumber;
   }

   /**
    * getRouteDate
    * @return Date
    */
   public Date getRouteDate()
   {
      return m_routeDate;
   }

   /**
    * getRouteLegNumber
    * @return int
    */
   public int getRouteLegNumber()
   {
      return m_routeLegNumber;
   }

   /**
    * getMAWBNumber
    * @return String
    */
   public String getMAWBNumber()
   {
      return m_MAWBNumber;
   }

   /**
    * getDestinationLocCode
    * @return String
    */
   public String getDestinationLocCode()
   {
      return m_destinationLocCode;
   }

   /**
    * getOriginLocCode
    * @return String
    */
   public String getOriginLocCode()
   {
      return m_originLocCode;
   }

   /**
    * getDepartureGMTTimestamp
    * @return Date
    */
   public Date getDepartureGMTTimestamp()
   {
      return m_departureGMTTimestamp;
   }

   /**
    * getArrivalGMTTimestamp
    * @return Date
    */
   public Date getArrivalGMTTimestamp()
   {
      return m_arrivalGMTTimestamp;
   }

   /**
    * getDepartureLocalTimestamp
    * @return Date
    */
   public Date getDepartureLocalTimestamp()
   {
      return m_departureLocalTimestamp;
   }

   /**
    * getArrivalLocalTimestamp
    * @return Date
    */
   public Date getArrivalLocalTimestamp()
   {
      return m_arrivalLocalTimestamp;
   }

   /**
    * getDestinationCountryCode
    * @return String
    */
   public String getDestinationCountryCode()
   {
      return m_destinationCountryCode;
   }

   /**
    * getOriginCountryCode
    * @return String
    */
   public String getOriginCountryCode()
   {
      return m_originCountryCode;
   }

   /**
    * getSortDate
    * @return Date
    */
   public Date getSortDate()
   {
      return m_sortDate;
   }

   /**
    * getRouteLegStatusCd
    * @return String
    */
   public String getRouteLegStatusCd()
   {
      return m_routeLegStatusCd;
   }

   /**
    *  getBrokerCompleteFlag
    *  @return String
    */
   public String getBrokerCompleteFlag()
   {
      return m_brokerCompleteFlag;
   }

   /**
    * getCustomsCompleteFlag
    * @return String
    */
   public String getCustomsCompleteFlag()
   {
      return m_customsCompleteFlag;
   }

   /**
    * getRouteLegOidNumber
    * @return int
    */
   public int getRouteLegOidNumber()
   {
      return m_routeLegOidNumber;
   }

   /**
    * setRouteNumber
    * @param String
    */
    public void setRouteNumber(String s)
    {
      if(s == null)
      {
        m_routeNumber = "";
      }
      else
      {
        m_routeNumber = s;
      }
    }

    /**
     * setMAWBNumber
     * @param String
     */
    private void setMAWBNumber(String s)
    {
      if(s == null)
      {
         m_MAWBNumber = "";
      }
      else
      {
        m_MAWBNumber = s;
      }
    }

    /**
     * setDestinationLocCode
     * @param String
     */
    private void setDestinationLocCode(String s)
    {
      if(s == null)
      {
         m_destinationLocCode = "";
      }
      else
      {
         m_destinationLocCode = s;
      }
    }

    /**
     * setOriginLocCode
     * @param String
     */
    private void setOriginLocCode(String s)
    {
      if(s == null)
      {
         m_originLocCode = "";
      }
      else
      {
        m_originLocCode = s;
      }
    }

    /**
     * setDestinationCountryCode
     * @param String
     */
    private void setDestinationCountryCode(String s)
    {
      if(s == null)
      {
         m_destinationCountryCode = "";
      }
      else
      {
        m_destinationCountryCode = s;
      }
    }

    /**
     * setOriginCountryCode
     * @param String
     */
    private void setOriginCountryCode(String s)
    {
      if(s == null)
      {
         m_originCountryCode = "";
      }
      else
      {
        m_originCountryCode = s;
      }
    }


   /**
    * setDepartureGMTTimestamp
    * @param departureGMTTimestamp
    */
   public void setDepartureGMTTimestamp(Date departureGMTTimestamp)
   {
      m_departureGMTTimestamp = departureGMTTimestamp;
   }

   /**
    * setArrivalGMTTimestamp
    * @param arrivalGMTTimestamp
    */
   public void setArrivalGMTTimestamp(Date arrivalGMTTimestamp)
   {
      m_arrivalGMTTimestamp = arrivalGMTTimestamp;
   }

   /**
    * setDepartureLocalTimestamp
    * @param departureLocalTimestamp
    */
   public void setDepartureLocalTimestamp(Date departureLocalTimestamp)
   {
      m_departureLocalTimestamp = departureLocalTimestamp;
   }

   /**
    * setArrivalLocalTimestamp
    * @param arrivalLocalTimestamp
    */
   public void setArrivalLocalTimestamp(Date arrivalLocalTimestamp)
   {
      m_arrivalLocalTimestamp = arrivalLocalTimestamp;
   }

   /**
    * setRouteDate
    * @param routeDate
    */
    public void setRouteDate(Date routeDate)
    {
      m_routeDate = routeDate;
    }
   /**
    * setSortDate
    * @param sortDate
    */
    public void setSortDate(Date sortDate)
    {
      m_sortDate = sortDate;
    }

    /**
     * setRouteLegStatusCd
     * @param flag
     */
    public void setRouteLegStatusCd(String flag)
    {
      if(flag == null)
      {
        m_routeLegStatusCd = "";
      }
      else
      {
        m_routeLegStatusCd = flag;
      }
    }

    /**
     * setBrokerCompleteFlag
     * @param flag
     */
    public void setBrokerCompleteFlag(String flag)
    {
      if(flag == null)
      {
        m_brokerCompleteFlag = "";
      }
      else
      {
        m_brokerCompleteFlag = flag;
      }
    }

    /**
     * setCustomsComplteFlag
     * @param flag
     */
    public void setCustomsCompleteFlag(String flag)
    {
       if(flag == null)
      {
        m_customsCompleteFlag = "";
      }
      else
      {
        m_customsCompleteFlag = flag;
      }
    }

    /**
     * toString
     * @return String
     */
    public String toString()
    {
      String s = "";

      s +=  "CCIIRouteLeg object dump" + "\n";

      s += "m_routeNumber             = " + m_routeNumber + "\n";
      s += "m_routeDate               = " + m_routeDate + "\n";
      s += "m_routeLegNumber          = " + m_routeLegNumber + "\n";
      s += "m_MAWBNumber              = " + m_MAWBNumber + "\n";
      s += "m_destinationLocCode      = " + m_destinationLocCode + "\n";
      s += "m_originLocCode           = " + m_originLocCode + "\n";
      s += "m_departureGMTTimestamp   = " + m_departureGMTTimestamp + "\n";
      s += "m_arrivalGMTTimestamp     = " + m_arrivalGMTTimestamp + "\n";
      s += "m_departureLocalTimestamp = " + m_departureLocalTimestamp + "\n";
      s += "m_arrivalLocalTimestamp   = " + m_arrivalLocalTimestamp + "\n";
      s += "m_destinationCountryCode  = " + m_destinationCountryCode + "\n";
      s += "m_originCountryCode       = " + m_originCountryCode + "\n";
      s += "m_sortDate                = " + m_sortDate + "\n";
      s += "m_routeLegStatusCd      = " + m_routeLegStatusCd + "\n";
      s += "m_brokerCompleteFlag      = " + m_brokerCompleteFlag + "\n";
      s += "m_customsCompleteFlag     = " + m_customsCompleteFlag + "\n";

      return s;
    }
}
