package cciij.cciidata;

/**
 * Title:        CCII Data Classes
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Dan Krucoff
 * @version 1.0
 */
import java.util.*;
import java.io.Serializable;

public class CCIIDataVector implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: CCIIDataVector.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private Vector m_data = new Vector();
  private int m_dataType;

  // VECTOR TYPES
  /**
   * data object represents a Vector of ReasonCode
   * @see cciij.cciidata.ReasonCode
   */
  public final static int REASON_CODE_DEF = 1;
  /**
   * data object represents a Vector of ReleaseCodes
   * @see cciij.cciidata.ReleaseCodes
   */
  public final static int RELEASE_CODE_DEF = 2;
  /**
   * data object represents a Vector of HandlingInstructionsDef
   * @see cciij.cciidata.HandlingInstructionsDef
   */
  public final static int HANDLING_INSTRUCTION_DEF = 3;
  /**
   * data object represents a Vector of ShipmentRemarkDef
   * @see cciij.cciidata.ShipmentRemarkDef
   */
  public final static int SHIPMENT_REMARK_DEF = 4;
  /**
   * data object represents a Vector of InterceptCodeDef
   * @see cciij.cciidata.InterceptCodeDef
   */
  public final static int INTERCEPT_CODE_DEF = 5;
  /**
   * data object represents a Vector of PrinterConfiguration
   * @see cciij.cciidata.PrinterConfiguration
   */
  public final static int PRINTER_CONFIGURATION = 6;
  /**
   * data object represents a Vector of StagingArea
   * @see cciij.cciidata.StagingArea
   */
  public final static int STAGING_AREA = 7;
  /**
   * data object represents a Vector of RouteLeg
   * @see cciij.cciidata.RouteLeg
   */
  public final static int ROUTE_LEG = 8;
  /**
   * data object represents a Vector of java.util.Date
   * @see java.util.Date
   */
  public final static int JAVA_UTIL_DATE = 9;
  /**
   * data object represents a Vector of Shipment
   * @see cciij.cciidata.Shipment
   */
//no longer used
 // public final static int SHIPMENT = 10;
  /**
   * data object represents a Vector of HandlingUnit
   * @see cciij.cciidata.HandlingUnit
   */
  public final static int HANDLING_UNIT = 11;
  /**
   * data object represents a Vector of Scan
   * @see cciij.cciidata.Scan
   */
  public final static int SCANS = 12;
  /**
   * data object represents a Vector of Strings that represent Route Numbers
   */
  public final static int ROUTE_NBR = 13;
  /**
   * data object represents a Vector of HandlingUnitAndShipment
   * @see cciij.WSUtil.HandlingUnitAndShipment
   */
  public final static int HU_AND_SHIPMENT = 14;
  /**
   * data object represents a Vector of AgencyDescription
   * @see cciij.cciidata.AgencyDescription
   */
  public final static int AGENCY_DEF = 15;
  /**
   * data object represents a Vector of ClearanceActivity
   * @see cciij.cciidata.ClearanceActivity
   */
  public final static int CLEARANCE_ACTIVITY = 16;
  /**
   * data object represents a Vector of ScanDefinitions
   * @see cciij.cciidata.ScanDefinitions
   */
  public final static int SCAN_DEF = 17;
  /**
   * data object represents a Vector of ScanDefinition for the STAT scans
   * @see cciij.cciidata.ScanDefinition
   */
  public final static int STAT_SCAN_DEF = 18;
  /**
   * data object represents a Vector of Strings that represent Site Location Codes
   */
  public final static int SITE_CD = 19;
  /**
   * data object represents a Vector of Strings that represent warehouse codes
   */
  public final static int WHSE_CD = 20;

   /**
   * data object represents a Vector of HandlingUnitShipmentAndRoute
   * @see cciij.WSUtil.HandlingUnitShipmentAndRoute
   */
  public final static int HU_SHIPMENT_AND_ROUTE = 21;

  /**
   * data object representing intercepts on a package
   */
   public final static int INTERCEPT = 22;

  public CCIIDataVector() {
  }


  public CCIIDataVector(int vectorType, Vector vec)
  {
    if (vec != null)
    {
         m_data = vec;
         m_dataType = vectorType;
    }
  }

  /**
   * returns the current data vector
   * @return Vector of data
   */
  public Vector getData() {
    return m_data;
  }
  /**
   * returns the current data type
   * @return int that defines what the data represents
   */

  public int getDataType() {
    return m_dataType;
  }

  /**
   * sets the data vector
   * @param vec a vector of data to be stored
   */

  public void setVector(Vector vec) {
    m_data = vec;
  }

  /**
   * sets the datatype to describe what is stored in the datavector
   * @param dType int that defines data type.  See public final variables
   */

  public void setDataType(int dType) {
    m_dataType = dType;
  }

  /**
   *sets both data and datatype in one call
   *@param dataType int the defines data type.  See public final variables
   *@param data Vector containing data to be stored
   */
   public void setDataAndDataType(int dataType, Vector data)
   {
    if (data != null)
    {
         m_data = data;
         m_dataType = dataType;
    }

   }
  static public void main(String[] args)
  {
  }

}