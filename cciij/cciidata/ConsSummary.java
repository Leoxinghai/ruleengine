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


public class ConsSummary  implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: ConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int m_consOidNumber;
  private String m_consNumber = "";
  private String m_consFormTypeCode = "";
  private Date m_createDate = new Date(0);
  private String m_flightNumber = "";
  private String m_flightOriginLocationCode = "";
  private String m_flightDestinationLocationCode = "";
  private Date m_flightActualArrivalDate = new Date(0);
  private String m_containerNumber = "";
  private String m_consCode = "";
  private String m_destinationLocationCode = "";
  private String m_destinationCountryCode = "";
  private String m_noiDestinationLocationCode = "";
  private String m_employeeNumber = "";
  private String m_scanLocationCode = "";
  private Date m_scanDate = new Date(0);
  private Date m_updateDate = new Date(0);
  private int m_totalPieceQuantity;
  private int m_regularNoticeQuantity;
  private int m_interceptQuantity;
  private int m_releaseQuantity;
  private int m_clearancePiecesQuantity;
  private int m_manifestedQuantity;
  private int m_uniqueQuantity;
  private int m_splitNumber;

  private int m_statusFlag;

  /**
   * ConsSummary
   */
  public ConsSummary()
  {

  }

  /**
   * ConsSummary
   * @param consOidNumber
   * @param consNumber
   * @param consFormTypeCode
   * @param createDate
   * @param flightNumber
   * @param flightOriginLocationCode
   * @param flightDestinationLocationCode
   * @param flightActualArrivalDate
   * @param containerNumber
   * @param consCode
   * @param destinationLocationCode
   * @param destinationCountryCode
   * @param noiDestinationLocationCode
   * @param employeeNumber
   * @param scanLocationCode
   * @param scanDate
   * @param updateDate
   * @param totalPieceQuantity
   * @param regularNoticeQuantity
   * @param interceptQuantity
   * @param releaseQuantity
   * @param clearancePiecesQuantity
   * @param manifestedQuantity
   * @param uniqueQuantity
   */
  public ConsSummary(int consOidNumber,
                     String consNumber,
                     String consFormTypeCode,
                     Date createDate,
                     String flightNumber,
                     String flightOriginLocationCode,
                     String flightDestinationLocationCode,
                     Date flightActualArrivalDate,
                     String containerNumber,
                     String consCode,
                     String destinationLocationCode,
                     String destinationCountryCode,
                     String noiDestinationLocationCode,
                     String employeeNumber,
                     String scanLocationCode,
                     Date scanDate,
                     Date updateDate,
                     int totalPieceQuantity,
                     int regularNoticeQuantity,
                     int interceptQuantity,
                     int releaseQuantity,
                     int clearancePiecesQuantity,
                     int manifestedQuantity,
                     int uniqueQuantity)
  {
     m_consOidNumber = consOidNumber;
     setConsNumber(consNumber);
     setConsFormTypeCode(consFormTypeCode);
     m_createDate = createDate;
     setFlightNumber(flightNumber);
     setFlightOriginLocationCode(flightOriginLocationCode);
     setFlightDestinationLocationCode(flightDestinationLocationCode);
     m_flightActualArrivalDate = flightActualArrivalDate;
     setContainerNumber(containerNumber);
     setConsCode(consCode);
     setDestinationLocationCode(destinationLocationCode);
     setDestinationCountryCode(destinationCountryCode);
     setNoiDestinationLocationCode(noiDestinationLocationCode);
     setEmployeeNumber(employeeNumber);
     setScanLocationCode(scanLocationCode);
     m_scanDate = scanDate;
     m_updateDate = updateDate;
     m_totalPieceQuantity = totalPieceQuantity;
     m_regularNoticeQuantity = regularNoticeQuantity;
     m_interceptQuantity = interceptQuantity;
     m_releaseQuantity = releaseQuantity;
     m_clearancePiecesQuantity = clearancePiecesQuantity;
     m_manifestedQuantity = manifestedQuantity;
     m_uniqueQuantity = uniqueQuantity;
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
   * getCreateDate
   * @return Date
   */
  public Date getCreateDate()
  {
    return m_createDate;
  }

  /**
   * getFlightNumber
   * @return String
   */
  public String getFlightNumber()
  {
    return m_flightNumber;
  }

  /**
   * getFlightOriginLocationCode
   * @return String
   */
  public String getFlightOriginLocationCode()
  {
    return m_flightOriginLocationCode;
  }

  /**
   * getFlightDestinationLocationCode
   * @return String
   */
  public String getFlightDestinationLocationCode()
  {
    return m_flightDestinationLocationCode;
  }

  /**
   * getFlightActualArrivalDate
   * @return Date
   */
  public Date getFlightActualArrivalDate()
  {
    return m_flightActualArrivalDate;
  }

  /**
   * getContainerNumber
   * @return String
   */
  public String getContainerNumber()
  {
    return m_containerNumber;
  }

  /**
   * getConsCode
   * @return String
   */
  public String getConsCode()
  {
    return m_consCode;
  }

  /**
   * getDestinationLocationCode
   * @return String
   */
  public String getDestinationLocationCode()
  {
    return m_destinationLocationCode;
  }

  /**
   * getDestinationationCountryCode
   * @return String
   */
  public String getDestinationCountryCode()
  {
    return m_destinationCountryCode;
  }

  /**
   * getNoiDestinationLocationCode
   * @return String
   */
  public String getNoiDestinationLocationCode()
  {
    return m_noiDestinationLocationCode;
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
   * getScanLocationCode
   * @return String
   */
  public String getScanLocationCode()
  {
    return m_scanLocationCode;
  }

  /**
   * getScanDate
   * @return Date
   */
  public Date getScanDate()
  {
    return m_scanDate;
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
   * getTotatlPieceQuantity
   * @return int
   */
  public int getTotalPieceQuantity()
  {
    return m_totalPieceQuantity;
  }

  /**
   * getRegularNoticeQuantity
   * @return int
   */
  public int getRegularNoticeQuantity()
  {
    return m_regularNoticeQuantity;
  }

  /**
   * getInterceptQuantity
   * @return int
   */
  public int getInterceptQuantity()
  {
    return m_interceptQuantity;
  }

  /**
   * getReleaseQuantity
   * @return int
   */
  public int getReleaseQuantity()
  {
    return m_releaseQuantity;
  }

  /**
   * getClearancePiecesQuantity
   * @return int
   */
  public int getClearancePiecesQuantity()
  {
    return m_clearancePiecesQuantity;
  }

  /**
   * getManifestedQuantity
   * @return int
   */
  public int getManifestedQuantity()
  {
    return m_manifestedQuantity;
  }

  /**
   * getUniqueQuantity
   * @return int
   */
  public int getUniqueQuantity()
  {
    return m_uniqueQuantity;
  }

  /**
   * getSplitNumber
   * @return int
   */
  public int getSplitNumber()
  {
    return m_splitNumber;
  }

  /**
   * getStatusFlag
   * @return int
   */
  public int getStatusFlag()
  {
    return m_statusFlag;
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
   * setFlightNumber
   * @param String
   */
  private void setFlightNumber(String s)
  {
    if(s == null)
    {
       m_flightNumber = "";
    }
    else
    {
      m_flightNumber = s;
    }
  }

  /**
   * setFlightOriginLocationCode
   * @param String
   */
  private void setFlightOriginLocationCode(String s)
  {
    if(s == null)
    {
       m_flightOriginLocationCode = "";
    }
    else
    {
      m_flightOriginLocationCode = s;
    }
  }

  /**
   * setFlightDestinationLocationCode
   * @param String
   */
  private void setFlightDestinationLocationCode(String s)
  {
    if(s == null)
    {
       m_flightDestinationLocationCode = "";
    }
    else
    {
      m_flightDestinationLocationCode = s;
    }
  }

  /**
   * setContainerNumber
   * @param String
   */
  private void setContainerNumber(String s)
  {
    if(s == null)
    {
       m_containerNumber = "";
    }
    else
    {
      m_containerNumber = s;
    }
  }

  /**
   * setConsCode
   * @param String
   */
  private void setConsCode(String s)
  {
    if(s == null)
    {
       m_consCode = "";
    }
    else
    {
      m_consCode = s;
    }
  }

  /**
   * setDestinationLocationCode
   * @param String
   */
  private void setDestinationLocationCode(String s)
  {
    if(s == null)
    {
       m_destinationLocationCode = "";
    }
    else
    {
      m_destinationLocationCode = s;
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
   * setNoiDestinationLocationCode
   * @param String
   */
  private void setNoiDestinationLocationCode(String s)
  {
    if(s == null)
    {
       m_noiDestinationLocationCode = "";
    }
    else
    {
      m_noiDestinationLocationCode = s;
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
   * setScanLocationCode
   * @param String
   */
  private void setScanLocationCode(String s)
  {
    if(s == null)
    {
       m_scanLocationCode = "";
    }
    else
    {
      m_scanLocationCode = s;
    }
  }

  /**
   * setUpdateDate
   * @param newUpdateDate
   */
  public void setUpdateDate(Date newUpdateDate)
  {
    m_updateDate = newUpdateDate;
  }

  /**
   * setTotalPieceQuantity
   * @param newTotalPieceQuantity
   */
  public void setTotalPieceQuantity(int newTotalPieceQuantity)
  {
    m_totalPieceQuantity = newTotalPieceQuantity;
  }

  /**
   * setConsSummaryOidNumber
   * @param int
   */
   public void setConsSummaryOidNumber(int i)
  {
    if(m_consOidNumber == 0)
    {
      m_consOidNumber = i;
    }
  }

  /**
   * setSplitNumber
   * @param int
   */
   public void setSplitNumber(int i)
  {
    m_splitNumber = i;
  }

   /**
    * setStatusFlag
    * @param int
    */
    public void setStatusFlag(int statusFlag)
   {
     m_statusFlag = statusFlag;
   }
    
   /**
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

         s +=  "ConsSummary object -- " + "\n";

         s += "consOidNumber                 : " + m_consOidNumber+ "\n";
         s += "consNumber                    : " + m_consNumber+ "\n";
         s += "consFormTypeCode              : " + m_consFormTypeCode+ "\n";
         s += "createDate                    : " + m_createDate+ "\n";
         s += "flightNumber                  : " + m_flightNumber+ "\n";
         s += "flightOriginLocationCode      : " + m_flightOriginLocationCode+ "\n";
         s += "flightDestinationLocationCode : " + m_flightDestinationLocationCode+ "\n";
         s += "flightActualArrivalDate       : " + m_flightActualArrivalDate+ "\n";
         s += "containerNumber               : " + m_containerNumber+ "\n";
         s += "consCode                      : " + m_consCode+ "\n";
         s += "destingationLocationCode      : " + m_destinationLocationCode+ "\n";
         s += "destinationCountryCode        : " + m_destinationCountryCode+ "\n";
         s += "noiDestinationLocationCode    : " + m_noiDestinationLocationCode+ "\n";
         s += "employeeNumber                : " + m_employeeNumber+ "\n";
         s += "scanLocationCode              : " + m_scanLocationCode+ "\n";
         s += "scanDate                      : " + m_scanDate+ "\n";
         s += "updateDate                    : " + m_updateDate+ "\n";
         s += "totalPieceQuantity            : " + m_totalPieceQuantity+ "\n";
         s += "regularNoticeQuantity         : " + m_regularNoticeQuantity+ "\n";
         s += "interceptQuantity             : " + m_interceptQuantity+ "\n";
         s += "releaseQuantity               : " + m_releaseQuantity+ "\n";
         s += "clearancePiecesQuantity       : " + m_clearancePiecesQuantity+ "\n";
         s += "manifestedQuantity            : " + m_manifestedQuantity+ "\n";
         s += "uniqueQuantity                : " + m_uniqueQuantity+ "\n";
         s += "splitNumber                   : " + m_splitNumber+ "\n";

      return s;
  }
}

