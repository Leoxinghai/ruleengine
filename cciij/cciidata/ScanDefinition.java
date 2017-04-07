package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author       Kathleen Krucoff
 * @version 1.0
 *
 * Modification history:
 * 1/30/2003     Dan St John Added Constructor to use locationCd
 *                           for mulitsite port and set locationCd to
 *                           "" in existinf constuctor
 */

 import java.io.Serializable;

public class ScanDefinition implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ScanDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

  private String m_locationCd = "";
  private String m_scanTypeCode = "";
  private String m_locStatNumber = "";
  private String m_scanDescription = "";
  private String m_scannerWSOnlyCode = "";
  private String m_massEntryFlag = "";
  private String m_recordActiveFlag = "";
  private String m_activityLogTextDescription = "";
  private String m_allowMultipleUploadFlag = "";
  private String m_allowSubscanFlag = "";
  private String m_activityCd = "";


  //new columns added to the database 7/2001  kmk
  /*
  private String m_corporateScanCode = "";
  private String m_uploadLocStatCode = "";
  private String m_uploadComScanTemplateDescription = "";
  private String m_uploadEccoScanCode = "";
  private String m_interceptCorporateScanCode = "";
  private String m_interceptUploadLocStatCode = "";
  private String m_interceptUploadScanTemplateDescription = "";
  private String m_interceptUploadEccoScanCode = "";
  private String m_uninterceptUploadScanCode = "";
  private String m_uninterceptUploadLocStatCode = "";
  private String m_uninterceptUploadScanTemplateDescription = "";
  private String m_uninterceptUploadEccoScanCode = "";

*/

  /**
   * ScanDefinition
   */
  public ScanDefinition()
  {
  }
  /**
   * ScanDefinition // DSJ 1/9/03
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
  public ScanDefinition(String scanTypeCode,
                        String locStatNumber,
                        String scanDescription,
                        String scannerWSOnlyCode,
                        String massEntryFlag,
                        String recordActiveFlag,
                        String allowMultipleUploadFlag,
                        String allowSubscanFlag,
                        String activityCd)
  {
     setScanTypeCode(scanTypeCode);
     setLocStatNumber(locStatNumber);
     setScanDescription(scanDescription);
     setScannerWSOnlyCode(scannerWSOnlyCode);
     setMassEntryFlag(massEntryFlag);
     setRecordActiveFlag(recordActiveFlag);
     setAllowMultipleUploadFlag(allowMultipleUploadFlag);
     setAllowSubscanFlag(allowSubscanFlag);
     // DSJ 1/9/03
     //m_locationCd = "";
     // END DSJ
     setActivityCode(activityCd);
  }
  /**
   * ScanDefinition // DSJ 1/9/03
   * @param String
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
  public ScanDefinition(String scanTypeCode,
                        String locStatNumber,
                        String scanDescription,
                        String scannerWSOnlyCode,
                        String massEntryFlag,
                        String recordActiveFlag,
                        String allowMultipleUploadFlag,
                        String allowSubscanFlag,
                        String locationCd,
                        String activityCd)
  {
     setScanTypeCode(scanTypeCode);
     setLocStatNumber(locStatNumber);
     setScanDescription(scanDescription);
     setScannerWSOnlyCode(scannerWSOnlyCode);
     setMassEntryFlag(massEntryFlag);
     setRecordActiveFlag(recordActiveFlag);
     setAllowMultipleUploadFlag(allowMultipleUploadFlag);
     setAllowSubscanFlag(allowSubscanFlag);
     // DSJ 1/9/03
     m_locationCd = locationCd;
     // END DSJ
     setActivityCode(activityCd);
  }
  /**
  * finalize
  */
  protected void finalize()
  {
  }

    /**
     * getActivityLogTextDescription
     * @return String
     */
    public String getActivityLogTextDescription()
    {
      return m_activityLogTextDescription;
    }
    /**
     * getAllowMultipleUploadFlag
     * @return String
     */
    public String getAllowMultipleUploadFlag()
    {
      return m_allowMultipleUploadFlag;
    }
    /**
     * getAllowSubscanFlag
     * @return String
     */
    public String getAllowSubscanFlag()
    {
      return m_allowSubscanFlag;
    }

    /**
     * getCorporateScanCode
     * @return String
     */
     /*
    public String getCorporateScanCode()
    {
      return m_corporateScanCode;
    }
  
    /**
     * getInterceptCorporateScanCode
     * @return String
     */
     /*
     public String getInterceptCorporateScanCode()
    {
      return m_interceptCorporateScanCode;
    }
    /**
     * getInterceptUploadEccoScanCode
     * @return String
     */
     /*
    public String getInterceptUploadEccoScanCode()
    {
      return m_interceptUploadEccoScanCode;
    }
    /**
     * getInterceptUploadLocStatCode
     * @return String
     */
     /*
    public String getInterceptUploadLocStatCode()
    {
      return m_interceptUploadLocStatCode;
    }
    /**
     * getInterceptUploadScanTemplateDescription
     * @return String
     */
     /*
    public String getInterceptUploadScanTemplateDescription()
    {
      return m_interceptUploadScanTemplateDescription;
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
    * getLocStatNumber
    * @return String
    */
    public String getLocStatNumber()
    {
        return m_locStatNumber;
    }
    /**
    * getMassEntryFlag
    * @return String
    */
    public String getMassEntryFlag()
    {
        return m_massEntryFlag;
    }
    /**
    * getRecordStatusFlag
    * @return String
    */
    public String getRecordActiveFlag()
    {
        return m_recordActiveFlag;
    }
    /**
    * getScanDescription
    * @return String
    */
    public String getScanDescription()
    {
        return m_scanDescription;
    }
    /**
    * getScannerWSOnlyCode
    * @return String
    */
    public String getScannerWSOnlyCode()
    {
        return m_scannerWSOnlyCode;
    }
   /**
    * getScanTypeCode
    * @return String
    */
    public String getScanTypeCode()
    {
        return m_scanTypeCode;
    }
    /**
     * getUninterceptUploadEccoScanCode
     * @return String
     */
     /*
    public String getUninterceptUploadEccoScanCode()
    {
      return m_uninterceptUploadEccoScanCode;
    }
    /**
     * getUninterceptUploadLocStatCode
     * @return String
     */
     /*
    public String getUninterceptUploadLocStatCode()
    {
      return m_uninterceptUploadLocStatCode;
    }
    /**
     * getUninterceptUploadScanCode
     * @return String
     */
     /*
    public String getUninterceptUploadScanCode()
    {
      return m_uninterceptUploadScanCode;
    }
    /**
     * getUnintercepUploadScanTemplateDescription
     * @return String
     */
     /*
    public String getUnintercepUploadScanTemplateDescription()
    {
      return m_uninterceptUploadScanTemplateDescription;
    }
    /**
     * getUploadComScanTemplateDescription
     * @return String
     */
     /*
    public String getUploadComScanTemplateDescription()
    {
      return m_uploadComScanTemplateDescription;
    }
    /**
     * getUploadEccoScanCode
     * @return String
     */
     /*
    public String getUploadEccoScanCode()
    {
      return m_uploadEccoScanCode;
    }
    /**
     * getUploadLocStatCode
     * @return String
     */
     /*
    public String getUploadLocStatCode()
    {
      return m_uploadLocStatCode;
    }
    
    /**
     * getActivityCode
     * @return String
     */
    public String getActivityCode()
    {
      return m_activityCd;
    }
    
    /**
    * setActivityLogTextDescription
    * @param String
    */
    public void setActivityLogTextDescription(String s)
    {
      if(s == null)
      {
        m_activityLogTextDescription = "";
      }
      else
      {
        m_activityLogTextDescription = s;
      }
    }
     /**
     * setAllowMultipleUploadFlag
     * @param String
     */
    public void setAllowMultipleUploadFlag(String s)
    {
      if (s == null)
      {
        m_allowMultipleUploadFlag = "";
      }
      else
      {
        m_allowMultipleUploadFlag = s;
      }
    }

    /**
     * setAllowSubscanFlag
     * @param String
     */
    public void setAllowSubscanFlag(String s)
    {
      if (s == null)
      {
        m_allowSubscanFlag = "";
      }
      else
      {
        m_allowSubscanFlag = s;
      }
    }
    /**
    * setCorporateScanCode
    * @param String
    */
    /*
    public void setCorporateScanCode(String s)
    {
       if(s == null)
      {
        m_corporateScanCode = "";
      }
      else
      {
        m_corporateScanCode = s;
      }
    }
    
    /**
    * setInterceptCorporateScanCode
    * @param String
    */
    /*
    public void setInterceptCorporateScanCode(String s)
    {
       if(s == null)
      {
        m_interceptCorporateScanCode = "";
      }
      else
      {
        m_interceptCorporateScanCode = s;
      }
    }
    /**
    * setInterceptUploadEccoScanCode
    * @param String
    */
    /*
    public void setInterceptUploadEccoScanCode(String s)
    {
       if(s == null)
      {
        m_interceptUploadEccoScanCode = "";
      }
      else
      {
        m_interceptUploadEccoScanCode = s;
      }
    }
    /**
    * setInterceptUploadLocStatCode
    * @param String
    */
    /*
    public void setInterceptUploadLocStatCode(String s)
    {
       if(s == null)
      {
        m_interceptUploadLocStatCode = "";
      }
      else
      {
        m_interceptUploadLocStatCode = s;
      }
    }
    /**
    * setInterceptUploadScanTemplateDescription
    * @param String
    */
    /*
    public void setInterceptUploadScanTemplateDescription(String s)
    {
       if(s == null)
      {
        m_interceptUploadScanTemplateDescription = "";
      }
      else
      {
        m_interceptUploadScanTemplateDescription = s;
      }
    }
  /**
   * setLocationCd
   * @param String
   */
  public void setLocationCd(String s)
  {
     if( s == null)
    {
      m_locationCd = "";
    }
    else
    {
      m_locationCd = s;
    }
  }
    /**
     * setLocStatNumber
     * @param String
     */
    private void setLocStatNumber(String s)
    {
      if(s == null)
      {
         m_locStatNumber = "";
      }
      else
      {
        m_locStatNumber = s;
      }
    }
    /**
    * setMassEntryFlag
    * @param String
    */
    public void setMassEntryFlag(String flg)
    {
      if(flg == null)
      {
        m_massEntryFlag = "";
      }
      else
      {
        m_massEntryFlag = flg;
      }
    }
    /**
    * setRecordActiveFlag
    * @param String
    */
    public void setRecordActiveFlag(String flg)
    {
      if(flg == null)
      {
        m_recordActiveFlag = "";
      }
      else
      {
        m_recordActiveFlag = flg;
      }
    }
    /**
     * setScanDescription
     * @param String
     */
    private void setScanDescription(String s)
    {
      if(s == null)
      {
         m_scanDescription = "";
      }
      else
      {
        m_scanDescription = s;
      }
    }
    /**
     * setScannerWSOnlyCode
     * @param String
     */
    private void setScannerWSOnlyCode(String s)
    {
      if(s == null)
      {
         m_scannerWSOnlyCode = "";
      }
      else
      {
        m_scannerWSOnlyCode = s;
      }
    }
    /**
     * setScanTypeCode
     * @param String
     */
    private void setScanTypeCode(String s)
    {
      if(s == null)
      {
        m_scanTypeCode = "";
      }
      else
      {
        m_scanTypeCode = s;
      }
    }
    /**
    * setUninterceptUploadEccoScanCode
    * @param String
    */
    /*
    public void setUninterceptUploadEccoScanCode(String s)
    {
       if(s == null)
      {

        m_uninterceptUploadEccoScanCode = "";

      }

      else

      {

        m_uninterceptUploadEccoScanCode = s;

      }

    }

    /**

    * setUninterceptUploadLocStatCode

    * @param String

    */
/*
    public void setUninterceptUploadLocStatCode(String s)

    {

       if(s == null)

      {

        m_uninterceptUploadLocStatCode = "";

      }

      else

      {

        m_uninterceptUploadLocStatCode = s;

      }

    }

    /**

    * setUninterceptUploadScanCode

    * @param String

    */
/*
    public void setUninterceptUploadScanCode(String s)

    {

       if(s == null)

      {

        m_uninterceptUploadScanCode = "";

      }

      else

      {

        m_uninterceptUploadScanCode = s;

      }

    }

    /**

    * setUnintercepUploadScanTemplateDescription

    * @param String

    */
/*
    public void setUnintercepUploadScanTemplateDescription(String s)

    {

       if(s == null)

      {

        m_uninterceptUploadScanTemplateDescription = "";

      }

      else

      {

        m_uninterceptUploadScanTemplateDescription = s;

      }

    }

    /**

    * setUploadComScanTemplateDescription

    * @param String

    */
/*
    public void setUploadComScanTemplateDescription(String s)

    {

       if(s == null)

      {

        m_uploadComScanTemplateDescription = "";

      }

      else

      {

        m_uploadComScanTemplateDescription = s;

      }

    }

    /**

    * setUploadEccoScanCode

    * @param String

    */
/*
    public void setUploadEccoScanCode(String s)

    {

       if(s == null)

      {

        m_uploadEccoScanCode = "";

      }

      else

      {

        m_uploadEccoScanCode = s;

      }

    }

    /**

    * setUploadLocStatCode

    * @param String

    */
/*
    public void setUploadLocStatCode(String s)

    {

       if(s == null)

      {

        m_uploadLocStatCode = "";

      }

      else

      {

        m_uploadLocStatCode = s;

      }

    }

/**
     * setActivityCode
     * @param String
     */
    private void setActivityCode(String s)
    {
      if(s == null)
      {
         m_activityCd = "";
      }
      else
      {
        m_activityCd = s;
      }
    }


    /**

     * toString

     * @return String

     */

   public String toString()
   {
      String s = "";
         s +=  "ScanDefintion object -- " + "\n";
         s += "scanTypeCode                             : " + m_scanTypeCode+ "\n";
         s += "locStatNumber                            : " + m_locStatNumber+ "\n";
         s += "scanDescription                          : " + m_scanDescription+ "\n";
         s += "scannerWSOnlyCode                        : " + m_scannerWSOnlyCode+ "\n";
         s += "massEntryFlag                            : " + m_massEntryFlag+ "\n";
         s += "recordActiveFlag                         : " + m_recordActiveFlag+ "\n";
         s += "activityLogTextDescription               : " + m_activityLogTextDescription+ "\n";
         /*
         s += "corporateScanCode                        : " + m_corporateScanCode+ "\n";
         s += "uploadLocStatCode                        : " + m_uploadLocStatCode+ "\n";
         s += "uploadComScanTemplateDescription         : " + m_uploadComScanTemplateDescription+ "\n";
         s += "uploadEccoScanCode                       : " + m_uploadEccoScanCode+ "\n";
         s += "interceptUploadScanTemplateDescription   : " + m_interceptUploadScanTemplateDescription+ "\n";
         s += "interceptUploadEccoScanCode              : " + m_interceptUploadEccoScanCode+ "\n";
         s += "uninterceptUploadScanCode                : " + m_uninterceptUploadScanCode+ "\n";
         s += "uninterceptUploadLocStatCode             : " + m_uninterceptUploadLocStatCode+ "\n";
         s += "uninterceptUploadScanTemplateDescription : " + m_uninterceptUploadScanTemplateDescription+ "\n";
         s += "uninterceptUploadEccoScanCode            : " + m_uninterceptUploadEccoScanCode+ "\n";
         */
         s += "allowMultipleUploadFlag                  : " + m_allowMultipleUploadFlag+ "\n";
         s += "allowSubscanFlag                         : " + m_allowSubscanFlag+ "\n";
         s += "locationCd                               : " + m_locationCd+ "\n";
         s += "activityCd                               : " + m_activityCd+ "\n";
      return s;
  }
}

