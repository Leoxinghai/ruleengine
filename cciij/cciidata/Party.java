package cciij.cciidata;

/**
 * Title:        Party
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Gary Rockwood
 * @version 1.0
 */

import java.util.*;
import java.io.Serializable;
import cciij.businessActions.*;

public class Party
{
   private static final String m_whatVersion = "@(#) $RCSfile: Party.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private int m_oidNbr = 0;
   private String m_oidTypeCd = "";
   private String m_partyTypeCd = "";
   private int m_customerAcctNbr = 0;
   private String m_countryCd = "";
   private String m_countrySubEntityCd = "";
   private String m_customsIdCd = "";
   private String m_companyNm = "";
   private String m_contactNm = "";
   private String m_address1Desc = "";
   private String m_address2Desc = "";
   private String m_cityNm = "";
   private String m_stateCd = "";
   private String m_postalCd = "";
   private String m_contactPhoneNbr = "";
   private String m_emailNm = "";
   private String m_lastModifiedNm = "";
   private Date m_lastModifiedTmstp = new Date(0);
   private String m_customsSelfAssessmentFlg = "";

   /**
    * Public default constructor
    */
   public Party()
   {
   }

   /**
    * Public constructor
    * @Param int m_oidNbr
    * @Param String m_oidTypeCd
    * @Param String m_partyTypeCd
    * @Param int m_customerAcctNbr
    * @Param String m_countryCd
    * @Param String m_countrySubEntityCd
    * @Param String m_customsIdCd
    * @Param String m_companyNm
    * @Param String m_contactNm
    * @Param String m_address1Desc
    * @Param String m_address2Desc
    * @Param String m_cityNm
    * @Param String m_stateCd
    * @Param String m_postalCd
    * @Param String m_contactPhoneNbr
    * @Param String m_emailNm
    * @Param String m_lastModifiedNm
    * @Param Date m_lastModifiedTmstp
    * @Param String m_customsSelfAssessmentFlg
    */
   public Party( int oidNbr,
                 String oidTypeCd,
                 String partyTypeCd,
                 int customerAcctNbr,
                 String countryCd,
                 String countrySubEntityCd,
                 String customsIdCd,
                 String companyNm,
                 String contactNm,
                 String address1Desc,
                 String address2Desc,
                 String cityNm,
                 String stateCd,
                 String postalCd,
                 String contactPhoneNbr,
                 String emailNm,
                 String lastModifiedNm,
                 Date lastModifiedTmstp,
                 String customsSelfAssessmentFlg )
   {
      this.m_oidNbr = oidNbr;
      this.m_oidTypeCd = oidTypeCd;
      this.m_partyTypeCd = partyTypeCd;
      this.m_customerAcctNbr = customerAcctNbr;
      this.m_countryCd = countryCd;
      this.m_countrySubEntityCd = countrySubEntityCd;
      this.m_customsIdCd = customsIdCd;
      this.m_companyNm = companyNm;
      this.m_contactNm = contactNm;
      this.m_address1Desc = address1Desc;
      this.m_address2Desc = address2Desc;
      this.m_cityNm = cityNm;
      this.m_stateCd = stateCd;
      this.m_postalCd = postalCd;
      this.m_contactPhoneNbr = contactPhoneNbr;
      this.m_emailNm = emailNm;
      this.m_lastModifiedNm = lastModifiedNm;
      this.m_lastModifiedTmstp = lastModifiedTmstp;
      this.m_customsSelfAssessmentFlg = customsSelfAssessmentFlg;
   }

    /**
     * getOidNbr
     * @return int
     */
    public int getOidNbr() {
        return m_oidNbr;
    }

   /**
    * getOidTypeCd
    * @return String
    */
   public String getOidTypeCd()
   {
      return m_oidTypeCd;
   }

   /**
    * getPartyTypeCd
    * @return String
    */
   public String getPartyTypeCd()
   {
      return m_partyTypeCd;
   }

   /**
    * getCustomerAcctNbr
    * @return int
    */
   public int getCustomerAcctNbr()
   {
      return m_customerAcctNbr;
   }

   /**
    * getCountryCd
    * @return String
    */
   public String getCountryCd()
   {
      return m_countryCd;
   }

   /**
    * getCountrySubEntityCd
    * @return String
    */
   public String getCountrySubEntityCd()
   {
      return m_countrySubEntityCd;
   }

   /**
    * getCustomsIdCd
    * @return String
    */
   public String getCustomsIdCd()
   {
      return m_customsIdCd;
   }

   /**
    * getCompanyNm
    * @return String
    */
   public String getCompanyNm()
   {
     return m_companyNm;
   }

   /**
    * getContactNm
    * @return String
    */
   public String getContactNm()
   {
      return m_contactNm;
   }

   /**
    * getAddress1Desc
    * @return String
    */
   public String getAddress1Desc()
   {
      return m_address1Desc;
   }

   /**
    * getAddress2Desc
    * @return String
    */
   public String getAddress2Desc()
   {
      return m_address2Desc;
   }

   /**
    * getCityNm
    * @return String
    */
   public String getCityNm()
   {
      return m_cityNm;
   }

   /**
    * getStateCd
    * @return String
    */
   public String getStateCd()
   {
      return m_stateCd;
   }

   /**
    * getPostalCd
    * @return String
    */
   public String getPostalCd()
   {
      return m_postalCd;
   }

   /**
    * getContactPhoneNbr
    * @return String
    */
   public String getContactPhoneNbr()
   {
      return m_contactPhoneNbr;
   }

   /**
    * getEmailNm
    * @return String
    */
   public String getEmailNm()
   {
      return m_emailNm;
   }

   /**
    * getLastModifiedNm
    * @return String
    */
   public String getLastModifiedNm()
   {
      return m_lastModifiedNm;
   }

   /**
    * getiLastModifiedTmstp
    * @return Date
    */
   public Date getLastModifiedTmstp()
   {
      return m_lastModifiedTmstp;
   }

   /**
    * getCustomsiSelfAssessmentFlg
    * @return String
    */
   public String getCustomsSelfAssessmentFlg()
   {
      return m_customsSelfAssessmentFlg;
   }

   /**
     * setOidNbr
     * @param int oid
     */
   public void setOidNbr(int oid) 
   {
      this.m_oidNbr = oid;
   }

   /**
    * setOidTypeCd
    * @param String oidTypeCd
    */
   public void setOidTypeCd( String oidTypeCd )
   {
      this.m_oidTypeCd = oidTypeCd;
   }

   /**
    * setPartyTypeCd
    * @param String partyTypeCd
    */
   public void setPartyTypeCd( String partyTypeCd )
   {
      this.m_partyTypeCd = partyTypeCd;
   }

   /**
    * setCustomerAcctNbr
    * @param int customerAcctNbr
    */
   public void setCustomerAcctNbr( int customerAcctNbr )
   {
      this.m_customerAcctNbr = customerAcctNbr;
   }

   /**
    * setCountryCd
    * @param String countryCd
    */
   public void setCountryCd( String countryCd )
   {
      this.m_countryCd = countryCd;
   }

   /** setCountrySubEntityCd
    *  @param String countrySubEntityCd
    */
   public void setCountrySubEntityCd( String countrySubEntityCd )
   {
      this.m_countrySubEntityCd = countrySubEntityCd;
   }

   /** setCustomsIdCd
    *  @param String customsIdCd
    */
   public void setCustomsIdCd( String customsIdCd )
   {
      this.m_customsIdCd = customsIdCd;
   }

   /** setCompanyNm
    *  @param String companyNm
    */
   public void setCompanyNm( String companyNm )
   {
      this.m_companyNm = companyNm;
   }

   /** setContactNm
    *  @param String contactNm
    */
   public void setContactNm( String contactNm )
   {
      this.m_contactNm = contactNm;
   }

   /** setAddress1Desc
    *  @param String address1Desc
    */
   public void setAddress1Desc( String address1Desc )
   {
      this.m_address1Desc = address1Desc;
   }

   /** setAddress2Desc
    *  @param String address2Desc
    */
   public void setAddress2Desc( String address2Desc )
   {
      this.m_address2Desc = address2Desc;
   }

   /** setCityNm
    *  @param String cityNm
    */
   public void setCityNm( String cityNm )
   {
      this.m_cityNm = cityNm;
   }

   /** setiStateCd
    *  @param String stateCd
    */
   public void setStateCd( String stateCd )
   {
      this.m_stateCd = stateCd;
   }

   /** setPostalCd
    *  @param String postalCd
    */
   public void setPostalCd( String postalCd )
   {
      this.m_postalCd = postalCd;
   }

   /** setContactPhoneNbr
    *  @param String contactPhoneNbr
    */
   public void setContactPhoneNbr( String contactPhoneNbr )
   {
      this.m_contactPhoneNbr = contactPhoneNbr;
   }

   /** setiEmailNm
    *  @param String emailNm
    */
   public void setEmailNm( String emailNm )
   {
      this.m_emailNm = emailNm;
   }

   /** setLastModifiedNm
    *  @param String lastModifiedNm
    */
   public void setLastModifiedNm( String lastModifiedNm )
   {
      this.m_lastModifiedNm = lastModifiedNm;
   }

   /** setLastModifiedTmstp
    *  @param Date lastModifiedTmstp
    */
   public void setLastModifiedTmstp( Date lastModifiedTmstp )
   {
      this.m_lastModifiedTmstp = lastModifiedTmstp;
   }

   /** setCustomsiSelfAssessmentFlg
    *  @param String customsSelfAsstssmentFlg
    */
   public void setCustomsSelfAssessmentFlg( String customsSelfAssessmentFlg )
   {
      this.m_customsSelfAssessmentFlg = customsSelfAssessmentFlg;
   }

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("PARTY object -- \n");
      sb.append("OID_NBR                     : " + m_oidNbr + "\n" );
      sb.append("OID_TYPE_CD                 : " + m_oidTypeCd + "\n" );
      sb.append("PARTY_TYPE_CD               : " + m_partyTypeCd + "\n" );
      sb.append("CUSTOMER_ACCT_NBR           : " + m_customerAcctNbr + "\n" );
      sb.append("COUNTRY_CD                  : " + m_countryCd + "\n" );
      sb.append("COUNTRY_SUB_ENTITY_CD       : " + m_countrySubEntityCd + "\n" );
      sb.append("CUSTOMS_ID_CD               : " + m_customsIdCd + "\n" );
      sb.append("COMPANY_NM                  : " + m_companyNm + "\n" );
      sb.append("CONTACT_NM                  : " + m_contactNm + "\n" );
      sb.append("ADDRESS1_DESC               : " + m_address1Desc + "\n" );
      sb.append("ADDRESS2_DESC               : " + m_address2Desc + "\n" );
      sb.append("CITY_NM                     : " + m_cityNm + "\n" );
      sb.append("STATE_CD                    : " + m_stateCd + "\n" );
      sb.append("POSTAL_CD                   : " + m_postalCd + "\n" );
      sb.append("CONTACT_PHONE_NBR           : " + m_contactPhoneNbr + "\n" );
      sb.append("EMAIL_NM                    : " + m_emailNm + "\n" );
      sb.append("LAST_MODIFIED_NM            : " + m_lastModifiedNm + "\n" );
      sb.append("LAST_MODIFIED_TMSTP         : " + m_lastModifiedTmstp + "\n" );
      sb.append("CUSTOMS_SELF_ASSESSMENT_FLG : " + m_customsSelfAssessmentFlg + "\n" );

      return sb.toString();
   }

}
