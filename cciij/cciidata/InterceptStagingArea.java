package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:  Models a row in the INTERCEPT_STAGING_AREA
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Monica Marshall
 * @version 1.0
 */

public class InterceptStagingArea implements java.io.Serializable
{
   private static final String m_whatVersion = "@(#) $RCSfile: InterceptStagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd    = null;
   private String m_warehouseCd   = null;
   private String m_stagingAreaCd = null;
   private String m_interceptCd   = null;

   /**
    * Default Constructor
    */
   public InterceptStagingArea()
   {
   }

   /**
    * Public Constructor
    * @param String interceptCd
    * @param String locationCd
    * @param String warehouseCd
    * @param String stagingAreaCd
    */
   public InterceptStagingArea( String locationCd, String warehouseCd,
                                String stagingAreaCd, String interceptCd )
   {
      setInterceptCd( interceptCd );
      setLocationCd( locationCd );
      setWarehouseCd( warehouseCd );
      setStagingAreaCd( stagingAreaCd );
   }

   /**
    * setLocationCd
    * @param String locationCd
    */
   public void setLocationCd( String locationCd )
   {
      this.m_locationCd = locationCd;
   }

   /**
    * setWarehouseCd
    * @param String warehouseCd
    */
   public void setWarehouseCd( String warehouseCd )
   {
      this.m_warehouseCd = warehouseCd;
   }

   /**
    * setStagingAreaCd
    * @param String stagingAreaCd
    */
   public void setStagingAreaCd( String stagingAreaCd )
   {
      this.m_stagingAreaCd = stagingAreaCd;
   }

   /**
    * setInterceptCd
    * @param String interceptCd
    */
   public void setInterceptCd( String interceptCd )
   {
      this.m_interceptCd = interceptCd;
   }

   /**
    * getInterceptCd
    * @return String
    */
   public String getInterceptCd()
   {
      return this.m_interceptCd;
   }

   /**
    * getLocationCd
    * @return String
    */
   public String getLocationCd()
   {
      return this.m_locationCd;
   }

   /**
    * getStagingAreaCd
    * @return String
    */
   public String getStagingAreaCd()
   {
      return this.m_stagingAreaCd;
   }

   /**
    * getWarehouseCd
    * @return String
    */
   public String getWarehouseCd()
   {
      return this.m_warehouseCd;
   }

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("INTERCEPT_STAGING_AREA object -- \n");
      sb.append("LOCATION_CD      : " + m_locationCd + "\n" );
      sb.append("WAREHOUSE_CD     : " + m_warehouseCd + "\n" );
      sb.append("STAGING_AREA_CD  : " + m_stagingAreaCd + "\n" );
      sb.append("INTERCEPT_CD     : " + m_interceptCd + "\n" );
      return sb.toString();
   }

}