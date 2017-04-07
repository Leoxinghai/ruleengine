package cciij.cciidata;

/**
 * Title:        Agency Staging Area
 * Description:  Models the AGENCY_STAGING_AREA table
 * Copyright:    Copyright (c) 2003
 * Company:      Fedex Services
 * @author:      srinivas
 * @version 1.0
 */

public class AgencyStagingArea
{
  private static final String m_whatVersion = "@(#) $RCSfile: AgencyStagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode;
  private String m_warehouseCode;
  private String m_stagingAreaCode;
  private String m_agencyCode;

 /**
  * Default Constructor
  */
  public AgencyStagingArea()
  {
  }

  /**
   * @param String locationCode
   * @param String warehouseCode
   * @param String stagingAreaCode
   * @param String agencyCode
   */
  public AgencyStagingArea(String locationCode,
			   String warehouseCode,
			   String stagingAreaCode,
			   String agencyCode)
  {
      setLocationCode(locationCode);
      setWarehouseCode(warehouseCode);
      setStagingAreaCode(stagingAreaCode);
      setAgencyCode(agencyCode);
  }

 /**
  * finalize
  */
  protected void  finalize()
  {
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
 * getWarehouseCode
 * @return String
 */
  public String getWarehouseCode()
  {
    return m_warehouseCode;
  }
/**
 * getStagingAreaCode
 * @return String
 */
  public String getStagingAreaCode()
  {
    return m_stagingAreaCode;
  }
/**
 * getAgencyCode
 * @return String
 */
  public String getAgencyCode()
  {
    return m_agencyCode;
  }
/**
 * setLocationCode
 * @param String
 */
  public void setLocationCode(String s)
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
   * setWarehouseCode
   * @param String
   */
  public void setWarehouseCode(String s)
  {
     if( s == null)
    {
      m_warehouseCode = "";
    }
    else
    {
      m_warehouseCode = s;
    }
  }

  /**
   * setStagingAreaCode
   * @param String
   */
  public void setStagingAreaCode(String s)
  {
     if( s == null)
    {
      m_stagingAreaCode = "";
    }
    else
    {
      m_stagingAreaCode = s;
    }
  }
/**
 * setAgencyCode
 * @param String
 */
  public void setAgencyCode(String s)
  {
     if( s == null)
    {
      m_agencyCode = "";
    }
    else
    {
      m_agencyCode = s;
    }
  }
  /**
   * toString
   * @return String
   */
   public String toString()
   {
       StringBuffer sb = new StringBuffer() ;

       sb.append("AgencyStagingArea object --\n");
       sb.append("locationCode    : " + m_locationCode+ "\n");
       sb.append("warehouseCode   : " + m_warehouseCode+ "\n");
       sb.append("stagingAreaCode : " + m_stagingAreaCode+"\n");
       sb.append("agencyCode      : " + m_agencyCode+ "\n");
       return sb.toString();
   }
}