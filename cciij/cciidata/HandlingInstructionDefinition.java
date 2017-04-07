package cciij.cciidata;

/**
 * Title: HandlingInstructionDefinition Role Class
 * Description:
 * Copyright:  Copyright (c) 2007
 * Company:  Fedex Services
 * @author
 * @version 1.0
 * *
 * Modification history:
 * 1/20/2003    Tom Knobeloch  modified members and methods to handle the addition
 *                             of LOCATION_CD in the database table definition as
 *                             a new member.  added new instantiation method with
 *                             new parameter.
 */


import java.io.Serializable;

public class HandlingInstructionDefinition implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: HandlingInstructionDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode = "";
  private String m_handlingInstructionCode = "";
  private String m_handlingInstructionDescription = "";
  private String m_appliesReleaseCode = "";
  private String m_recordActiveFlag = "";


  /**
   * HandlingInstructionDefinition
   */
  public HandlingInstructionDefinition()
  {

  }

  /**
   * HandlingInstructionDefinition
   * @param locationCode
   * @param handlingInstructionCode
   * @param handlingInstructionDescription
   * @param appliesReleaseCode
   * @param recordActiveFlag
   */
  public HandlingInstructionDefinition(String locationCode,
                                       String handlingInstructionCode,
                                       String handlingInstructionDescription,
                                       String appliesReleaseCode,
                                       String recordActiveFlag)
  {
     setLocationCode(locationCode);
     setHandlingInstructionCode(handlingInstructionCode);
     setHandlingInstructionDescription(handlingInstructionDescription);
     setAppliesReleaseCode(appliesReleaseCode);
     setRecordActiveFlag(recordActiveFlag);
  }

  /**
   * HandlingInstructionDefinition
   * @param handlingInstructionCode
   * @param handlingInstructionDescription
   * @param appliesReleaseCode
   * @param recordActiveFlag
   */
  public HandlingInstructionDefinition(String handlingInstructionCode,
                                       String handlingInstructionDescription,
                                       String appliesReleaseCode,
                                       String recordActiveFlag)
  {
     this("", handlingInstructionCode, handlingInstructionDescription,
          appliesReleaseCode, recordActiveFlag);
  }

  /**
   * finalize
   */
  protected void finalize()
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
   * getHandlingInstructionCode
   * @return String
   */
  public String getHandlingInstructionCode()
  {
     return m_handlingInstructionCode;
  }

  /**
   * getHandlingInstructionDescription
   * @return String
   */
  public String getHandlingInstructionDescription()
  {
     return m_handlingInstructionDescription;
  }

  /**
   * getAppliesReleaseCode
   * @return String
   */
  public String getAppliesReleaseCode()
  {
     return m_appliesReleaseCode;
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
   * setLocationCd
   * @param String
   */
  private void setLocationCode(String s)
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
   * setHandlingInstructionCode
   * @param String
   */
  private void setHandlingInstructionCode(String s)
  {
     if(s == null)
     {
        m_handlingInstructionCode = "";
     }
     else
     {
        m_handlingInstructionCode = s;
     }
  }

  /**
   * setHandlingInstructionDescription
   * @param String
   */
  public void setHandlingInstructionDescription(String s)
  {
     if(s == null)
     {
        m_handlingInstructionDescription = "";
     }
     else
     {
        m_handlingInstructionDescription = s;
     }
  }

  /**
   * setAppliesReleaseCode
   * @param String
   */
  public void setAppliesReleaseCode(String s)
  {
     if(s == null)
     {
        m_appliesReleaseCode = "";
     }
     else
     {
       m_appliesReleaseCode = s;
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

     s += "HandlingInstructionDefinition object -- " + "\n";

     s += "locationCode                    : " + m_locationCode + "\n";
     s += "handlingInstructionCode         : " + m_handlingInstructionCode+ "\n";
     s += "handlingInstructionDescription  : " + m_handlingInstructionDescription+ "\n";
     s += "appliesReleaseCode              : " + m_appliesReleaseCode+ "\n";
     s += "recordActiveFlag                : " + m_recordActiveFlag+ "\n";

     return s;
  }
}