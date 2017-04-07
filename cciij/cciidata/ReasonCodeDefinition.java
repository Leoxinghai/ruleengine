package cciij.cciidata;
/**
 * Title: ReasonCodeDefinition Role Class
 * Description:
 * Copyright:  Copyright (c) 2001
 * Company: Fedex Services
 * @author
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;

public class ReasonCodeDefinition implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: ReasonCodeDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode = "";
  private String m_reasonCode = "";
  private String m_reasonCodeDescription = "";
  private String m_openCERFlag = "";
  private String m_postLocStatNumber = "";
  private String m_recordActiveFlag = "";

  /**
   * ReasonCodeDefinition
   */
  public ReasonCodeDefinition() {
  }

  /**
   * ReasonCodeDefinition
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public ReasonCodeDefinition(String locationCode,
                              String reasonCode,
                              String codeDescription,
                              String cerFlag,
                              String locStatNumber,
                              String recordActiveFlag)
  {
      setLocationCode(locationCode);
      setReasonCode(reasonCode);
      setReasonCodeDescription(codeDescription);
      setOpenCERFlag(cerFlag);
      setPostLocStatNumber(locStatNumber);
      setRecordActiveFlag(recordActiveFlag);

  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  /**
  * getReasonCode
  * @return String
  */
  public String getReasonCode() {
      return m_reasonCode;
  }


  /**
  * getReasonCodeDescription
  * @return String
  */
  public String getReasonCodeDescription() {
      return m_reasonCodeDescription;
  }

  /**
  * getOpenCERFlg
  * @return char
  */
  public String getOpenCERFlag() {
      return m_openCERFlag;
  }

  /**
  * getPostLocStatNbr
  * @return String
  */
  public String getPostLocStatNumber() {
      return m_postLocStatNumber;
  }

  /**
  * getRecordActiveFlag
  * @return String
  */
  public String getRecordActiveFlag() {
      return m_recordActiveFlag;
  }

   /**
  * getLocationCode
  * @return String
  */
  public String getLocationCode() {
      return m_locationCode;
  }

  /**
   * setLocationCode
   * @param String
   */
  private void setLocationCode(String s)
  {
    if(s == null)
    {
       m_locationCode = "";
    }
    else
    {
      m_locationCode = s;
    }
  }

  /**
   * setReasonCode
   * @param String
   */
  private void setReasonCode(String s)
  {
    if(s == null)
    {
       m_reasonCode = "";
    }
    else
    {
      m_reasonCode = s;
    }
  }

  /**
   * setReasonCodeDescription
   * @param String
   */
  private void setReasonCodeDescription(String s)
  {
    if(s == null)
    {
       m_reasonCodeDescription = "";
    }
    else
    {
       m_reasonCodeDescription = s;
    }
  }

  /**
   * setOpenCERFlag
   * @param String
   */
  private void setOpenCERFlag(String s)
  {
    if(s == null)
    {
       m_openCERFlag = "";
    }
    else
    {
      m_openCERFlag = s;
    }
  }

  /**
   * setPostLocStatNumber
   * @param String
   */
  public void setPostLocStatNumber(String s)
  {
    if(s == null)
    {
       m_postLocStatNumber = "";
    }
    else
    {
      m_postLocStatNumber = s;
    }
  }

  /**
   * setRecordActiveFlag
   * @param String
   */
  private void setRecordActiveFlag(String s)
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
   * @param String
   */
   public String toString()
   {
      String s = "";

         s +=  "ReasonCodeDefinition object -- " + "\n";

         s += "locationCode          : " + m_locationCode + "\n";
         s += "reasonCode            : " + m_reasonCode+ "\n";
         s += "reasonCodeDescription : " + m_reasonCodeDescription+ "\n";
         s += "openCERFlag           : " + m_openCERFlag+ "\n";
         s += "postLocStatNumber     : " + m_postLocStatNumber+ "\n";
         s += "recordActiveFlag      : " + m_recordActiveFlag+ "\n";

      return s;
  }
}
