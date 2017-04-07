package cciij.cciidata;

import java.io.Serializable;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Julie Mccarthy
 * @version 	 1.0
 */
 
 public class UploadKey implements Serializable
{
   private static final String m_whatVersion = "@(#) $RCSfile: UploadKey.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd       = "";
   private String m_eventNm    = "";
   private String m_eventValueCd       = "";
   private String m_eventDetailCd    = "";
   
   public UploadKey()
   {
   }

   /**
    * Public Constructor
    * @param String locationCd
    * @param String eventNm
    * @param String eventValueCd
    * @param String eventDetailCd
   */
   public UploadKey(String locationCd,
   		       String eventNm,
                       String eventValueCd,
                       String eventDetailCd)
                    
   {
      this.m_locationCd = locationCd;
      this.m_eventNm = eventNm;
      this.m_eventValueCd = eventValueCd;
      this.m_eventDetailCd = eventDetailCd;
   }

    /**
    * getLocationCode
    * @return String
    */
   public String getLocationCode()
   {
      return this.m_locationCd;
   }

   
/**
    * getEventName
    * @return String
    */
   public String getEventName()
   {
      return this.m_eventNm;
   }

   /**
    * getEventValueCode
    * @return String
    */
   public String getEventValueCode()
   {
      return this.m_eventValueCd;
   }

   /**
    * getEventDetailCode
    * @return String
    */
   public String getEventDetailCode()
   {
      return this.m_eventDetailCd;
   }

  
    /**
    * setLocationCode
    * @param String locationCd
    */
   public void setLocationCode( String locationCd )
   {
      this.m_locationCd = locationCd;
   }
 
   /**
    * setEventName
    * @param String eventNm
    */
   public void setEventName( String eventNm )
   {
      this.m_eventNm = eventNm;
   }

   /**
    * setEventValueCode
    * @param String eventValueCd
    */
   public void setEventValueCode( String eventValueCd )
   {
      this.m_eventValueCd = eventValueCd;
   }

   /**
    * setEventDetailCode
    * @param String eventDetailCd
    */
   public void setEventDetailCode( String eventDetailCd )
   {
      this.m_eventDetailCd= eventDetailCd;
   }
   
   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("UPLOAD_ object -- \n");
      sb.append("LOCATION_CD        : " + m_locationCd + "\n" );
      sb.append("EVENT_NM           : " + m_eventNm + "\n" );
      sb.append("EVENT_VALUE_CD     : " + m_eventValueCd + "\n" );
      sb.append("EVENT_DETAIL_CD    : " + m_eventDetailCd + "\n" );
      return sb.toString();
   }
 }
