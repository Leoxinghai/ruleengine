package cciij.cciidata;

/**
 * Title:        LocationDef
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

public class LocationDef 
{
   private static final String m_whatVersion = "@(#) $RCSfile: LocationDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd    = "";
   private String m_districtNbr   = "";
   private String m_portNbr       = "";
   private String m_cityNm        = "";
   private String m_stateCd       = "";

   public LocationDef()
   {
   }

   /**
    * Public Constructor
    * @param String locationCd
    */
   public LocationDef(String locationCd)
    	       
    	      
   {		 
      this.m_locationCd = locationCd;
   }

   /**
    * Public constructor
    * @param String locationCd
    * @param String districtNbr
    * @param String portNbr
    * @param String cityNm
    * @param String stateCd
    */
   public LocationDef( String locationCd, 
    		       String districtNbr,
    		       String portNbr,
                       String cityNm,
                       String stateCd)
   {
      this.m_locationCd = locationCd;
      this.m_districtNbr = districtNbr;
      this.m_portNbr = portNbr;
      this.m_cityNm = cityNm;
      this.m_stateCd = stateCd;
   }

/**
    * getLocationCd
    * @return string 
    */
   public String getLocationCode()
   {
      return this.m_locationCd;
   }

 /**
    * getDistrictNumber
    * @return String
    */
   public String getDistrictNumber()
   {
      return this.m_districtNbr;
   }

   /**
    * getPortNumber
    * @return string
    */
   public String getPortNumber()
   {
      return this.m_portNbr;
   }

   /**
    * getCityName
    * @return string
    */
   public String getCityName()
   {
      return this.m_cityNm;
   }


   /**
    * getStateCode
    * @return String
    */
   public String getStateCode()
   {
      return this.m_stateCd;
   }

   
   /**
    * setLocationCode
    * @param string locationCd
    */
   public void setLocationCode( String locationCd )
   {
      this.m_locationCd = locationCd;
   }

/**
    * setDistrictNumber 
    * @param string districtNbr
    */
   public void setDistrictNumber( String districtNbr )
   {
      this.m_districtNbr = districtNbr;
   }

   /**
    * setPortNumber
    * @param string portNbr
    */
   public void setPortNumber( String portNbr )
   {
      this.m_portNbr = portNbr;
   }

   /**
    * setCityName
    * @param string cityNm
    */
   public void setCityName( String cityNm )
   {
      this.m_cityNm = cityNm;
   }
   
   /**
    * setStateCode
    * @param string stateCd
    */
   public void setStateCode( String stateCd )
   {
      m_stateCd = stateCd;
   } 


    /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("LOCATION_DEF object -- \n");
      sb.append("LOCATION_CD       : " + m_locationCd + "\n" );
      sb.append("DISTRICT_NBR      : " + m_districtNbr + "\n" );
      sb.append("PORT_NBR          : " + m_portNbr + "\n" );
      sb.append("CITY_NAME         : " + m_cityNm + "\n" );
      sb.append("STATE_CD          : " + m_stateCd + "\n" );
      return sb.toString();
   } 
   
}
