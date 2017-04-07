package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Monica Marshall
 * @version 1.0
 */

public class Shuttle
{
   private static final String m_whatVersion = "@(#) $RCSfile: Shuttle.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd = "";
   private String m_warehouseCd = "";
   private String m_shuttleCd   = "";
   private String m_destinationLocationCd = "";
   private String m_slideAreaCd = "";
   private String m_shuttleTypeCd = "";
   private String m_shuttleStatusCd = "";

   /**
    * Public default constructor
    */
   public Shuttle()
   {
   }

   /**
    * Public constructor
    * @param String locationCd
    * @param String warehouseCd
    * @param String shuttleCd
    * @param String destinationLocationCd
    * @param String slideAreaCd
    * @param String shuttleTypeCd
    * @param String shuttleStatusCd
    */
   public Shuttle( String locationCd,
                      String warehouseCd,
                      String shuttleCd,
                      String destinationLocationCd,
                      String slideAreaCd,
                      String shuttleTypeCd,
                      String shuttleStatusCd )
   {
      this.m_locationCd = locationCd;
      this.m_warehouseCd = warehouseCd;
      this.m_shuttleCd = shuttleCd;
      this.m_destinationLocationCd = destinationLocationCd;
      this.m_slideAreaCd = slideAreaCd;
      this.m_shuttleTypeCd = shuttleTypeCd;
      this.m_shuttleStatusCd = shuttleStatusCd;
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
    * getWarehouseCd
    * @return String
    */
   public String getWarehouseCd()
   {
      return m_warehouseCd;
   }

   /**
    * getShuttleId
    * @return String
    */
   public String getShuttleId()
   {
      return m_shuttleCd;
   }

   /**
    * getDestinationLocationCd
    * @return String
    */
   public String getDestinationLocationCd()
   {
      return m_destinationLocationCd;
   }

   /**
    * getSlideAreaCd
    * @return String
    */
   public String getSlideAreaCd()
   {
      return m_slideAreaCd;
   }

   /**
    * getShuttleTypeCd
    * @return String
    */
   public String getShuttleTypeCd()
   {
      return m_shuttleTypeCd;
   }

   /**
    * getShuttleStatusCd
    * @return String
    */
   public String getShuttleStatusCd()
   {
      return m_shuttleStatusCd;
   }

   /**
    * setShuttleStatusCd
    * @param String shuttleStatusCd
    */
   public void setShuttleStatusCd( String shuttleStatusCd )
   {
      this.m_shuttleStatusCd = shuttleStatusCd;
   }

   /**
    * setShuttleTypeCd
    * @param String shuttleTypeCd
    */
   public void setShuttleTypeCd( String shuttleTypeCd )
   {
      this.m_shuttleTypeCd = shuttleTypeCd;
   }

   /**
    * setSlideAreaCd
    * @param String slideAreaCd
    */
   public void setSlideAreaCd( String slideAreaCd )
   {
      this.m_slideAreaCd = slideAreaCd;
   }

   /**
    * setDestinationLocationCd
    * @param String destinationLocationCd
    */
   public void setDestinationLocationCd( String destinationLocationCd )
   {
      this.m_destinationLocationCd = destinationLocationCd;
   }

   /**
    * setShuttleId
    * @param String shuttleCd
    */
   public void setShuttleId( String shuttleCd )
   {
      this.m_shuttleCd = shuttleCd;
   }

   /**
    * setWarehouseCd
    * @param String warehouseCd
    */
   public void setWarehouseCd( String warehouseCd )
   {
      this.m_warehouseCd = warehouseCd;
   }

   /** setLocationCd
    *  @param String locationCd
    */
   public void setLocationCd( String locationCd )
   {
      this.m_locationCd = locationCd;
   }

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("SHUTTLE_DEF object -- \n");
      sb.append("LOCATION_CD      : " + m_locationCd + "\n" );
      sb.append("WAREHOUSE_CD     : " + m_warehouseCd + "\n" );
      sb.append("SHUTTLE_CD       : " + m_shuttleCd + "\n" );
      sb.append("DEST_LOCATION_CD : " + m_destinationLocationCd + "\n" );
      sb.append("SLIDE_AREA_CD    : " + m_slideAreaCd + "\n" );
      sb.append("SHUTTLE_TYPE_CD  : " + m_shuttleTypeCd + "\n" );
      sb.append("SHUTTLE_STATUS_CD: " + m_shuttleStatusCd + "\n" );
      return sb.toString();
   }

}