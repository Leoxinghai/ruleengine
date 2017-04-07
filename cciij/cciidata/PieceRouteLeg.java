package cciij.cciidata;
/**
 * Title: PieceRouteLeg Role Class
 * Description:
 * Copyright:  Copyright (c) 2007
 * Company: Fedex Services
 * @author
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;

public class PieceRouteLeg implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: PieceRouteLeg.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_routeNumber = "";
  private Date m_routeDate = new Date(0);
  private int m_routeLegNumber;
  private int m_shipmentOidNumber;
  private int m_handlingUnitOidNumber;
  private String m_originLocationCode = "";
  private int m_sequenceNumber;
  private String m_scanReconFlag = "";

  /**
   * PieceRouteLeg
   */
  public PieceRouteLeg() {

  }


  /**
   * PieceRouteLeg
   * @param String
   * @param Date
   * @param int
   * @param int
   * @param int
   * @param String
   * @param int
   * @param String
   */
  public PieceRouteLeg (String routeNumber,
                        Date routeDate,
                        int routeLegNumber,
                        int shipmentOidNumber,
                        int handlingUnitOidNumber,
                        String originLocationCode,
                        int sequenceNumber,
                        String scanReconFlag ) {

    setRouteNumber(routeNumber);
    m_routeDate = routeDate;
    m_routeLegNumber = routeLegNumber;
    m_shipmentOidNumber = shipmentOidNumber;
    m_handlingUnitOidNumber = handlingUnitOidNumber;
    setOriginLocationCode(originLocationCode);
    m_sequenceNumber = sequenceNumber;
    setScanReconFlag(scanReconFlag);
  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
  * getRouteNumber
  * @return String
  */
  public String getRouteNumber() {
      return m_routeNumber;
  }


  /**
  * getRouteDate
  * @return Date
  */
  public Date getRouteDate() {
      return m_routeDate;
  }

  /**
  * getRouteLegNumber
  * @return int
  */
  public int getRouteLegNumber() {
      return m_routeLegNumber;
  }

  /**
  * getShipmentOidNumber
  * @return int
  */
  public int getShipmentOidNumber() {
      return m_shipmentOidNumber;
  }

  /**
  * getHandlingUnitOidNumber
  * @return int
  */
  public int getHandlingUnitOidNumber() {
      return m_handlingUnitOidNumber;
  }

  /**
  * getOriginLocationCode
  * @return String
  */
  public String getOriginLocationCode() {
      return m_originLocationCode;
  }

  /**
  * getSequenceNumber
  * @return int
  */
  public int getSequenceNumber() {
      return m_sequenceNumber;
  }

  /**
  * getScanReconFlag
  * @return String
  */
  public String getScanReconFlag() {
      return m_scanReconFlag;
  }

  /**
   * setRouteNumber
   * @param String
   */
  private void setRouteNumber(String s)
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
   * setOriginLocationCode
   * @param String
   */
  private void setOriginLocationCode(String s)
  {
    if(s == null)
    {
       m_originLocationCode = "";
    }
    else
    {
      m_originLocationCode = s;
    }
  }

  /**
   * setScanReconFlag
   * @param String
   */
  private void setScanReconFlag(String s)
  {
    if(s == null)
    {
      m_scanReconFlag = "";
    }
    else
    {
      m_scanReconFlag = s;
    }
  }

  /**
   * toString
   * @return String
   */
 public String toString()
   {
      String s = "";

         s +=  "PieceRouteLeg object -- " + "\n";

         s += "routeNumber           : " + m_routeNumber+ "\n";
         s += "routeDate             : " + m_routeDate+ "\n";
         s += "routeLegNumber        : " + m_routeLegNumber+ "\n";
         s += "shipmentOidNumber     : " + m_shipmentOidNumber+ "\n";
         s += "handlingUnitOidNumber : " + m_handlingUnitOidNumber+ "\n";
         s += "originLocationCode    : " + m_originLocationCode+ "\n";
         s += "sequenceNumber        : " + m_sequenceNumber+ "\n";
         s += "scanReconFlag         : " + m_scanReconFlag+ "\n";

      return s;
  }
}

