package cciij.cciidata;
/**
 * Title: StagingArea Role Class
 * Description:
 * Copyright:  Copyright (c) 2001
 * Company: Fedex Services
 * @author
 * @version 1.0
 */

import java.io.Serializable;

public class StagingArea implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: StagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_stagingAreaCode = "";
  private String m_stagingAreaDescription = "";
  private String m_printerCode = "";
  private String m_stageOutSatisfiesAllIntercepts = "";
  private String m_diverterNumber = "";
  private String m_diverterDescription = "";
  private String m_stagingRoutingCode = "";
  private String m_recordActiveFlag = "";
  private String m_locationCode = "";
  private String m_warehouseCode = "";

  /**
   * StagingArea
   */
  public StagingArea() {

  }

  /**
   * StagingArea
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
   public StagingArea (String warehouseCode,
		      String stagingAreaCode,
                      String stagingAreaDescription,
                      String printerCode,
                      String stageOutSatisfiesAllIntercepts,
                      String diverterNumber,
                      String diverterDescription,
                      String stagingRoutingCode,
                      String recordActiveFlag)
    {
      setWarehouseCode(warehouseCode);
      setStagingAreaCode(stagingAreaCode);
      setStagingAreaDescription(stagingAreaDescription);
      setPrinterCode(printerCode);
      setStageOutSatisfiesAllIntercepts(stageOutSatisfiesAllIntercepts);
      setDiverterNumber(diverterNumber);
      setDiverterDescription(diverterDescription);
      setStagingRoutingCode(stagingRoutingCode);
      setRecordActiveFlag(recordActiveFlag);
    }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
  * getWarehouseCode
  * @return String
  */
  public String getWarehouseCode() {
      return m_warehouseCode;
  }

  /**
  * getStagingAreaCode
  * @return String
  */
  public String getStagingAreaCode() {
      return m_stagingAreaCode;
  }


  /**
  * getStagingAreaDescription
  * @return String
  */
  public String getStagingAreaDescription() {
      return m_stagingAreaDescription;
  }

  /**
  * getPrinterCode
  * @return String
  */
  public String getPrinterCode() {
      return m_printerCode;
  }

  /**
  * getStageOutSatisfiesAllIntercepts
  * @return String
  */
  public String getStageOutSatisfiesAllIntercepts() {
      return m_stageOutSatisfiesAllIntercepts;
  }

  /**
  * getDiverterNumber
  * @return String
  */
  public String getDiverterNumber() {
      return m_diverterNumber;
  }

  /**
  * getDiverterDescription
  * @return String
  */
  public String getDiverterDescription() {
      return m_diverterDescription;
  }

  /**
  * getStagingRoutingCode
  * @return String
  */
  public String getStagingRoutingCode() {
      return m_stagingRoutingCode;
  }

  /**
   * getRecordActiveFlag
   * @return String
   */
  public String getRecordActiveFlag(){
    return m_recordActiveFlag;
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
  private void setWarehouseCode(String s)
  {
    if(s == null)
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
  private void setStagingAreaCode(String s)
  {
    if(s == null)
    {
       m_stagingAreaCode = "";
    }
    else
    {
      m_stagingAreaCode = s;
    }
  }

  /**
   * setStagingAreaDescription
   * @param String
   */
  private void setStagingAreaDescription(String s)
  {
    if(s == null)
    {
       m_stagingAreaDescription = "";
    }
    else
    {
      m_stagingAreaDescription = s;
    }
  }

  /**
   * setPrinterCode
   * @param String
   */
  private void setPrinterCode(String s)
  {
    if(s == null)
    {
       m_printerCode = "";
    }
    else
    {
      m_printerCode = s;
    }
  }

  /**
   * setStageOutSatisfiesAllIntercepts
   * @param String
   */
  private void setStageOutSatisfiesAllIntercepts(String s)
  {
    if(s == null)
    {
       m_stageOutSatisfiesAllIntercepts = "";
    }
    else
    {
      m_stageOutSatisfiesAllIntercepts = s;
    }
  }

  /**
   * setDiverterNumber
   * @param String
   */
  private void setDiverterNumber(String s)
  {
    if(s == null)
    {
       m_diverterNumber = "";
    }
    else
    {
      m_diverterNumber = s;
    }
  }

  /**
   * setDiverterDescription
   * @param String
   */
  private void setDiverterDescription(String s)
  {
    if(s == null)
    {
      m_diverterDescription = "";
    }
    else
    {
      m_diverterDescription = s;
    }
  }

  /**
   * setStagingRoutingCode
   * @param String
   */
  private void setStagingRoutingCode(String s)
  {
    if(s == null)
    {
       m_stagingRoutingCode = "";
    }
    else
    {
      m_stagingRoutingCode = s;
    }
  }

  /**
   * setRecordActiveFlag
   * @param String
   */
  public void setRecordActiveFlag(String s)
  {
    if(s == null)
    {
      m_recordActiveFlag = "";
    }
    else
    {
      m_recordActiveFlag = s;
    }
  }
  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "StagingArea object -- " + "\n";

         s += "stagingAreaCode                : " + m_stagingAreaCode+ "\n";
         s += "stagingAreaDescription         : " + m_stagingAreaDescription+ "\n";
         s += "printerCode                    : " + m_printerCode+ "\n";
         s += "stageOutSatisfiesAllIntercepts : " + m_stageOutSatisfiesAllIntercepts+ "\n";
         s += "diverterNumber                 : " + m_diverterNumber+ "\n";
         s += "diverterDescription            : " + m_diverterDescription+ "\n";
         s += "stagingRoutingCode             : " + m_stagingRoutingCode+ "\n";
         s += "recordActiveFlag               : " + m_recordActiveFlag+ "\n";
         s += "locationCode                   : " + m_locationCode+ "\n";
	 s += "warehouseCode                  : " + m_warehouseCode+ "\n";

      return s;
  }
}

