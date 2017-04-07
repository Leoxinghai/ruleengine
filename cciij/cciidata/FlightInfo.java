package cciij.cciidata;

/**
 * Title: FlightInfo Role Class
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:  Fedex Services
 * @author
 * @version 1.0
 *    08/16/04   Lorraine Dominguez Initial Creation
 */

import java.util.*;
import cciij.businessActions.*;
import java.io.Serializable;

public class FlightInfo implements Serializable
{
    private static final String m_whatVersion = "@(#) $RCSfile: FlightInfo.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
    // fields in trip table
    private String m_travelPlanNbr = "";
    private Date m_scheduledDepartureDt = new Date(0);
    private String m_originLocationCd = "";
    private String m_destLocationCd = "";
    private String m_originCountryCd = "";
    private String m_destCountryCd = "";
    private Date m_scheduledArrivalDt = new Date(0);
    private String m_tailNbr = "";


    /**
     * FlightInfo
     */
    public FlightInfo()
    {
    }

    /**
     * FlightInfo
     * @param scheduledDepartureDt
     * @param tailNbr
     */
    public FlightInfo(String travelPlanNbr, Date scheduledDepartureDt,
			String originLocationCd, String destLocationCd, 
			String originCountryCd, String destCountryCd,
			Date scheduledArrivalDt, String tailNbr)
    {
	m_travelPlanNbr = travelPlanNbr;
	m_scheduledDepartureDt = scheduledDepartureDt;
	m_originLocationCd = originLocationCd;
	m_destLocationCd = destLocationCd;
	m_originCountryCd = originCountryCd;
	m_destCountryCd = destCountryCd;
	m_scheduledArrivalDt = scheduledArrivalDt;
	m_tailNbr = tailNbr;

    }

    /**
     * finalize
     */
    protected void finalize()
    {
    }


    /**
     * getTravelPlanNbr
     * @return String
     */
     public String getTravelPlanNbr()
     {
        return m_travelPlanNbr;
     }

     /**
      * setTravelPlanNbr
      * @param String
      */
      public void setTravelPlanNbr(String s)
      {
         if(s == null)
	 {
	    m_travelPlanNbr = "";
	 }
	 else
	 {
	    m_travelPlanNbr = s ;
	 }
 }



    /**
     * getScheduledDepartureDt
     * @return Date
     */
    public Date getScheduledDepartureDt()
    {
       return m_scheduledDepartureDt;
    }

    /**
     * setScheduledDepartureDt
     * @param Date
     */
     public void setScheduledDepartureDt(Date d)
     {
        m_scheduledDepartureDt = d;
     }


     /**
      * getOriginLocationCd
      * @return String
      */
      public String getOriginLocationCd()
      {
         return m_originLocationCd;
      }



     /**
      * setOriginLocationCd
      * @param String
      */
      public void setOriginLocationCd(String s)
      {
         if(s == null)
         {
	    m_originLocationCd = "";
	 }
	 else
	 {
	    m_originLocationCd = s ;
	 }
      }


     /**
      * getDestLocationCd
      * @return String
      */
      public String getDestLocationCd()
      {
         return m_destLocationCd;
      }



     /**
      * setDestLocationCd
      * @param String
      */
      public void setDestLocationCd(String s)
      {
         if(s == null)
         {
	    m_destLocationCd = "";
	 }
	 else
	 {
	    m_destLocationCd = s ;
	 }
      }

     /**
      * getOriginCountryCd
      * @return String
      */
      public String getOriginCountryCd()
      {
         return m_originCountryCd;
      }



     /**
      * setOriginCountryCd
      * @param String
      */
      public void setOriginCountryCd(String s)
      {
         if(s == null)
	 {
	    m_originCountryCd = "";
	 }
	 else
	 {
	    m_originCountryCd = s ;
	 }
       }


     /**
      * getDestCountryCd
      * @return String
      */
      public String getDestCountryCd()
      {
         return m_destCountryCd;
      }



     /**
      * setDestCountryCd
      * @param String
      */
      public void setDestCountryCd(String s)
      {
         if(s == null)
	 {
	    m_destCountryCd = "";
	 }
         else	
	 {
	    m_destCountryCd = s ;
	 }
      }

    /**
     * getScheduledArrialDt
     * @return Date
     */
     public Date getScheduledArrivalDt()
     {
        return m_scheduledArrivalDt;
     }



    /**
     * setScheduledArrivalDt
     * @param Date
     */
     public void setScheduledArrivalDt(Date d)
     {
        m_scheduledArrivalDt = d;
     }


    /**
     * getTailNbr
     * @return String
     */
    public String getTailNbr()
    {
       return m_tailNbr;
    }

    /**
     * setTailNbr
     * @param String
     */
     public void setTailNbr(String s)
     {
        if(s == null)
	{
           m_tailNbr = "";
	}
	else
	{
	   m_tailNbr = s ;
	}
     }


    /**
     * toString
     * @return String
     */
    public String toString()
    {
	String s = "";

	s +=  "FlightInfo object -- " + "\n";
 
	s += "travelPlanNbr                 : " + m_travelPlanNbr+ "\n";
	s += "scheduledDepartureDt          : " + m_scheduledDepartureDt+ "\n";
	s += "originLocationCd              : " + m_originLocationCd+ "\n";
	s += "destLocationCd                : " + m_destLocationCd+ "\n";
	s += "originCountryCd               : " + m_originCountryCd+ "\n";
	s += "destCountryCd                 : " + m_destCountryCd+ "\n";
	s += "scheduledArrivalDt            : " + m_scheduledArrivalDt+ "\n";
	s += "tailNbr                       : " + m_tailNbr+ "\n";
	return s;
    }
}
