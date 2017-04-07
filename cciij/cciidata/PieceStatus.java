package cciij.cciidata;

/**
 * Title: FlightInfo Role Class
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:  Fedex Services
 * @author
 * @version 1.0
 *    08/16/04   Lorraine Dominguez Initial Creation
 */

import java.util.*;
import cciij.businessActions.*;
import java.io.Serializable;

public class PieceStatus implements Serializable
{
    private static final String m_whatVersion = "@(#) $RCSfile: PieceStatus.java,v $Revision: 1.1 $Author: xinghai $Date: \n";
    // fields in piece status table
    private int m_pieceOidNbr = 0;
    private String m_locationCd = "";
    private Date m_sortDt = new Date(0);
    private String m_pieceStatusCd = "";
    private int m_shipmentOidNbr = 0;
    private int m_routeLegOidNbr = 0;
    private String m_resolutionStatusCd = "";
    private String m_rfaCd = "";


    /**
     * PieceStatus
     */
    public PieceStatus()
    {
    }

    public PieceStatus(int pieceOidNbr, String locationCd, Date sortDt, String pieceStatusCd, int shipmentOidNbr, int routeLegOidNbr, String resolutionStatusCd, String rfaCd)
    {
	m_pieceOidNbr = pieceOidNbr;
	m_locationCd = locationCd;
	m_sortDt = sortDt;
	m_pieceStatusCd = pieceStatusCd;
	m_shipmentOidNbr = shipmentOidNbr;
	m_routeLegOidNbr = routeLegOidNbr;
	m_resolutionStatusCd = resolutionStatusCd;
	m_rfaCd = rfaCd;

    }

    /**
     * finalize
     */
    protected void finalize()
    {
    }

    /**
     * getPieceOidNbr
     * @return int
     */
     public int getPieceOidNbr()
     {
        return m_pieceOidNbr;
     }



    /**
     * setPieceOidNbr
     * @param int
     */
     public void setPieceOidNbr(int i)
     {
        m_pieceOidNbr = i;
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
      * setLocationCd
      * @param String
      */
      public void setLocationCd(String s)
      {
         if(s == null)
	 {
	    m_locationCd = "";
	 }
	 else
	 {
	    m_locationCd = s ;
	 }
      }


    /**
     *getSortDt
     * @param Date
     */
     public Date getSortDt()
     {
        return m_sortDt;
     }

    /**
     * setSortDt
     * @param Dt
     */
     public void setSortDt(Date dt)
     {
        m_sortDt = dt;
     }


     /**
      * getPieceStatusCd
      * @return String
      */
      public String getPieceStatusCd()
      {
         return m_pieceStatusCd;
      }



     /**
      * setPieceStatusCd
      * @param String
      */
      public void setPieceStatusCd(String s)
      {
         if(s == null)
         {
	    m_pieceStatusCd = "";
	 }
	 else
	 {
	    m_pieceStatusCd = s ;
	 }
      }


     /**
      * getShipmentOidNbr
      * @return int
      */
      public int getShipmentOidNbr()
      {
         return m_shipmentOidNbr;
      }



     /**
      * setShipmentOidNbr
      * @param int
      */
      public void setShipmentOidNbr(int i)
      {
	    m_shipmentOidNbr = i;
      }

     /**
      * getRouteLegOidNbr
      * @return int
      */
      public int getRouteLegOidNbr()
      {
         return m_routeLegOidNbr;
      }



     /**
      * setRouteLegOidNbr
      * @param int
      */
      public void setRouteLegOidNbr(int i)
      {
	    m_routeLegOidNbr = i;
      }


     /**
      * getResolutionStatusCd
      * @return String
      */
      public String getResolutionStatusCd()
      {
         return m_resolutionStatusCd;
      }



     /**
      * setResolutionStatusCd
      * @param String
      */
      public void setResolutionStatusCd(String s)
      {
         if(s == null)
	 {
	    m_resolutionStatusCd = "";
	 }
         else
	 {
	    m_resolutionStatusCd = s ;
	 }
      }


    /**
     * getRfaCd
     * @return String
     */
    public String getRfaCd()
    {
       return m_rfaCd;
    }

    /**
     * setRfaCd
     * @param String
     */
     public void setRfaCd(String s)
     {
        if(s == null)
	{
           m_rfaCd = "";
	}
	else
	{
	   m_rfaCd = s ;
	}
     }


    /**
     * toString
     * @return String
     */
    public String toString()
    {
	String s = "";

	s +=  "PieceStatus object -- " + "\n";

	s += "pieceOidNbr                   : " + m_pieceOidNbr+ "\n";
	s += "locationCd                    : " + m_locationCd+ "\n";
	s += "sortDt                        : " + m_sortDt+ "\n";
	s += "pieceStatusCd                 : " + m_pieceStatusCd+ "\n";
	s += "shipmentOidNbr                : " + m_shipmentOidNbr+ "\n";
	s += "routeLegOidNbr                : " + m_routeLegOidNbr+ "\n";
	s += "resolutionStatusCd            : " + m_resolutionStatusCd+ "\n";
	s += "rfaCd                         : " + m_rfaCd+ "\n";
	return s;
    }
}
