package cciij.cciidata;

/**
 * Title:        InTransit
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

public class InTransit 
{
   private static final String m_whatVersion = "@(#) $RCSfile: InTransit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String    m_locationCd     = "";
   private int       m_shipmentOidNbr = 0;
   private String    m_ccnNbr         = "";
   private Date      m_prepDt         = null;
   private java.sql.Timestamp m_printTmstp = null;
   private String    m_activeFlg      = "";
   private String    m_changedFlg     = "";

   public InTransit()
   {
   }

   /**
    * Public Constructor
    * @param String locationCd
    * @param int shipmentOidNbr
    */
   public InTransit(String locationCd,
                    int shipmentOidNbr)
    	       
    	      
   {		 
      this.m_locationCd = locationCd;
      this.m_shipmentOidNbr = shipmentOidNbr;
   }

  public InTransit(String locationCd, 
		   int shipmentOidNbr,
                   String ccnNbr,
		   Date prepDt,  
		   Timestamp printTmstp,
		   String activeFlg,
		   String changedFlg) {
      this(locationCd,shipmentOidNbr);
      setCCNNumber(ccnNbr);
      setPrepDate(prepDt);
      setPrintTimeStamp(printTmstp);
      setActiveFlg(activeFlg);
      setChangedFlg(changedFlg);
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
    * getShipmentOidNumber
    * @return int
    */
   public int getShipmentOidNumber()
   {
      return this.m_shipmentOidNbr;
   }

   /**
    * getCCNNumber
    * @return string
    */
   public String getCCNNumber()
   {
      return this.m_ccnNbr;
   }

   /**
    * getPrepDate
    * @return date
    */
   public Date getPrepDate()
   {
      return this.m_prepDt;
   }


   /**
    * getPrintTimeStamp
    * @return timestamp
    */
   public java.sql.Timestamp getPrintTimeStamp()
   {
      return this.m_printTmstp;
   }

   /**
   * getActiveFlg
   * @return String
   */
   public String getActiveFlg()
   { 
      return this.m_activeFlg;
   }

   /**
   * getChangedFlg
   * @return String
   */
   public String getChangedFlg()
   {
    return this.m_changedFlg;
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
    * setShipmentOidNumber 
    * @param int shipmentOidNbr
    */
   public void setShipmentOidNumber( int shipmentOidNbr )
   {
      this.m_shipmentOidNbr = shipmentOidNbr;
   }

   /**
    * setCCNNumber
    * @param string ccnNbr
    */
   public void setCCNNumber( String ccnNbr )
   {
      this.m_ccnNbr = ccnNbr;
   }

   /**
    * setPrepDate
    * @param date prepDt
    */
   public void setPrepDate( Date prepDt )
   {
      this.m_prepDt = prepDt;
   }
   
   /**
    * setPrintTimeStamp
    * @param timestamp printTmstp
    */
   public void setPrintTimeStamp( java.sql.Timestamp printTmstp )
   {
      m_printTmstp = printTmstp;
   } 
 
   /**
    * setActiveFlg
    * @param String activeFlg
    */
    public void setActiveFlg( String activeFlg )
    {
       m_activeFlg = activeFlg;
    }

   /**
    * setChangedFlg
    * @param String changedFlg
    */
    public void setChangedFlg( String changedFlg )
    {
       m_changedFlg = changedFlg;
    }

    /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("INTRANSIT object -- \n");
      sb.append("LOCATION_CD       : " + m_locationCd + "\n" );
      sb.append("SHIPMENT_OID_NBR  : " + m_shipmentOidNbr + "\n" );
      sb.append("CCN_NBR           : " + m_ccnNbr + "\n" );
      sb.append("PREP_DT           : " + m_prepDt + "\n" );
      sb.append("PRINT_TMSTP       : " + m_printTmstp + "\n" );
      sb.append("ACTIVE_FLG        : " + m_activeFlg + "\n" );
      sb.append("CHANGED_FLG       : " + m_changedFlg + "\n" );
      return sb.toString();
   } 
   
}
