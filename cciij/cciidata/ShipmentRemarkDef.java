package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 *
 * Modification history:
 * 1/30/2003     Dan St John M Added Constructor to use locationCd
 *                           for mulitsite port and set locationCd to
 *                           "" in existing constuctor
 */

 import java.util.*;
 import cciij.businessActions.*;
 import java.io.Serializable;

public class ShipmentRemarkDef implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ShipmentRemarkDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_shipmentRemarkCode = "";
  private String m_shipmentDescription = "";
  private String m_recordActiveFlag = "";
  private String m_locationCd = "";

  /**
   * ShipmentRemarkDef
   */
  public ShipmentRemarkDef()
  {

  }
/**
 * ShipmentRemarkDef
 * @param String
 * @param String
 * @param String
 */
public ShipmentRemarkDef(
    String shipmentRemarkCode,
    String shipmentDescription,
    String recordActiveFlag)
{

    setShipmentRemarkCode(shipmentRemarkCode);
    setShipmentDescription(shipmentDescription);
    setRecordActiveFlag(recordActiveFlag);
    // DSJ
    setLocationCd("");
    // END
}
/**
 * ShipmentRemarkDef
 * @param String
 * @param String
 * @param String
 */
public ShipmentRemarkDef(
    String shipmentRemarkCode,
    String shipmentDescription,
    String recordActiveFlag,
    String locationCd) // DSJ
{

    setShipmentRemarkCode(shipmentRemarkCode);
    setShipmentDescription(shipmentDescription);
    setRecordActiveFlag(recordActiveFlag);
    // DSJ
    setLocationCd(locationCd);
    // END
}
  /**
  * finalize
  */
  protected void finalize() {

  }
  /**
   * getLocationCd
   * @return String
   */
  public String getLocationCd()
  {
    return m_locationCd;
  }
  /**
   * getRecordActiveFlag
   * @return String
   */
  public String getRecordActiveFlag()
  {
    return m_recordActiveFlag;
  }
  /**
   * getShipmentDescription
   * @retrun String
   */
  public String getShipmentDescription()
  {
    return m_shipmentDescription;
  }
/**
 * getShipmentRemarkCode
 * @return String
 */
public String getShipmentRemarkCode()
{
    return m_shipmentRemarkCode;
}
/**
* setLocationCd
* @param String
*/
private void setLocationCd(String s)
{
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
   * setRecordActiveFlag
   * @param String
   */
  public void setRecordActiveFlag(String s)
  {
    if( s == null)
    {
      m_recordActiveFlag = "";
    }
    else
    {
      m_recordActiveFlag = s;
    }
  }
  /**
   * setShipmentDescription
   * @param String
   */
  private void setShipmentDescription(String s)
  {
    if( s == null)
    {
      m_shipmentDescription = "";
    }
    else
    {
      m_shipmentDescription = s;
    }
  }
/**
 * setShipmentRemarkCode
 * @param String
 */
  private void setShipmentRemarkCode(String s)
  {
    if( s == null)
    {
      m_shipmentRemarkCode = "";
    }
    else
    {
      m_shipmentRemarkCode = s;
    }
  }
  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "ShipmentRemark object -- " + "\n";

         s += "shipmentRemarkCode   : " + m_shipmentRemarkCode+ "\n";
         s += "shipmentDescription  : " + m_shipmentDescription+ "\n";
         s += "recordActiveFlag     : " + m_recordActiveFlag+ "\n";
         s += "locationCd           : " + m_locationCd + "\n";

      return s;
  }
}
