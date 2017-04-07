package cciij.cciidata;

/**
 * Title: Agency Role Class
 * Description:
 * Copyright:  Copyright (c) 2001
 * Company:  Fedex Services
 * @author
 * @version 1.0
 */


import java.io.Serializable;

public class Agency implements Serializable {
  private static final String m_whatVersion = "@(#) $RCSfile: Agency.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_agencyCode = "";
  private String m_agencyDescription = "";
  private int    m_clearancePriorityCode;
  //private String m_stagingAreaCode = "";
  private String m_stageOutInterceptSatisfyFlag = "";
  private String m_customsAgencyFlag = "";
  private String m_recordActiveFlag = "";
  private String m_locationCode = "";


  /**
  * Agency
  */
  public Agency () {

  }

  /**
  * Agency
  * @param String
  * @param String
  * @param int
  * @param String
  * @param String
  * @param String
  * @param String
  */
  public Agency(String agencyCode,
                String agencyDescription,
                int    clearancePriorityCode,
                //String stagingAreaCode,
                String stageOutInterceptSatisfyFlag,
                String customsAgencyFlag,
                String recordActiveFlag)
  {
    setAgencyCode(agencyCode);
    setAgencyDescription(agencyDescription);
    m_clearancePriorityCode = clearancePriorityCode;
    //setStagingAreaCode(stagingAreaCode);
    setStageOutInterceptSatisfyFlag(stageOutInterceptSatisfyFlag);
    setCustomsAgencyFlag(customsAgencyFlag);
    setRecordActiveFlag(recordActiveFlag);
  }

   /**
  * finalize
  */
  protected void finalize()
  {

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
  * getAgencyDescription
  * @return String
  */
  public String getAgencyDescription()
  {
      return m_agencyDescription;
  }

  /**
  * getClearancePriorityCode
  * @return int
  */
  public int getClearancePriorityCode()
  {
    return m_clearancePriorityCode;
  }

  /**
  * getStagingAreaCode
  * @return String
  */
  /*public String getStagingAreaCode()
  {
     return m_stagingAreaCode;
  }*/

  /**
  * getStageOutInterceptSatisfyFlag
  * @return String
  */
  public String getStageOutInterceptSatisfyFlag()
  {
    return m_stageOutInterceptSatisfyFlag;
  }

  /**
   * getCustomsAgencyFlag
   * @return String
   */
   public String getCustomsAgencyFlag()
   {
    return m_customsAgencyFlag;
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
    * setAgencyCode
    * @param String
    */
    private void setAgencyCode(String s)
    {
      if(s == null)
      {
         m_agencyCode = "";
      }
      else
      {
        m_agencyCode = s;
      }
    }

    /**
     * setAgencyDescription
     * @param String
     */
    private void setAgencyDescription(String s)
    {
      if(s == null)
      {
        m_agencyDescription = "";
      }
      else
      {
        m_agencyDescription = s;
      }
    }

    /**
     * setStagingAreaCode
     * @param String
     */
    /*private void setStagingAreaCode(String s)
    {
      if(s == null)
      {
        m_stagingAreaCode = "";
      }
      else
      {
        m_stagingAreaCode = s;
      }
    }*/

    /**
     * setStageOutInterceptSatisfyFlag
     * @param String
     */
    private void setStageOutInterceptSatisfyFlag(String s)
    {
      if(s == null)
      {
        m_stageOutInterceptSatisfyFlag = "";
      }
      else
      {
        m_stageOutInterceptSatisfyFlag = s;
      }
    }

    /**
     * setCustomsAgencyFlag
     * @param String
     */
    private void setCustomsAgencyFlag(String s)
    {
      if(s == null)
      {
        m_customsAgencyFlag = "";
      }
      else
      {
        m_customsAgencyFlag = s;
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

         s +=  "Agency object -- " + "\n";

         s += "agencyCode                   : " + m_agencyCode+ "\n";
         s += "agencyDescription            : " + m_agencyDescription+ "\n";
         s += "clearancyPriorityCode        : " + m_clearancePriorityCode+ "\n";
         /*s += "stagingAreaCode              : " + m_stagingAreaCode+ "\n";*/
         s += "stageOutInterceptSatisfyFlag : " + m_stageOutInterceptSatisfyFlag+ "\n";
         s += "customsAgencyFlag            : " + m_customsAgencyFlag+ "\n";
         s += "recordActiveFlag             : " + m_recordActiveFlag+ "\n";
         s += "locationCode                 : " + m_locationCode+ "\n";
      return s;
  }

}