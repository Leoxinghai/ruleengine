package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Julie McCarthy 
 * @version 	 1.0
 *
 */

import java.util.*;
import cciij.businessActions.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class CountryDef 
{
   private static final String m_whatVersion = "@(#) $RCSfile: CountryDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_countryCd   = "";
   private String m_countryNm   = "";

   public CountryDef()
   {
   }


   /**
    * Public constructor
    * @param String countryCd
    * @param String countryNm
    */
   public CountryDef( String countryCd, 
    		   String countryNm)
   {
      this.m_countryCd = countryCd;
      this.m_countryNm = countryNm;
   }


 /**
    * getCountryCode
    * @return String
    */
   public String getCountryCode()
   {
      return this.m_countryCd;
   }

   /**
    * getCountryName
    * @return string
    */
   public String getCountryName()
   {
      return this.m_countryNm;
   }


/**
    * setCountryCode 
    * @param string countryCd
    */
   public void setCountryCode( String countryCd )
   {
      this.m_countryCd = countryCd;
   }

   /**
    * setCountryName
    * @param string countryNm
    */
   public void setCountryName( String countryNm )
   {
      this.m_countryNm = countryNm;
   }


    /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("COUNTRY_DEF object -- \n");
      sb.append("COUNTRY_CD      : " + m_countryCd + "\n" );
      sb.append("COUNTRY_NM      : " + m_countryNm + "\n" );
      return sb.toString();
   }
}
