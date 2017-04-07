/*
 * Created on Aug 4, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.cciidata;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Truck
{
   private static final String m_whatVersion = "@(#) $RCSfile: Truck.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

   private String m_locationCd = "";
   private String m_warehouseCd = "";
   private String m_TruckId   = "";
   private String m_destinationLocationCd = "";
   private String m_slideAreaCd = "";
   private String m_TruckTypeCd = "";
   private String m_TruckStatusCd = "";
   private String m_activeFlag = "";
   private String m_truckRegNo = "";

   /**
    * Public default constructor
    */
   public Truck()
   {
   }

   /**
    * Public constructor
    * @param String locationCd
    * @param String warehouseCd
    * @param String TruckId
    * @param String destinationLocationCd
    * @param String slideAreaCd
    * @param String TruckTypeCd
    * @param String TruckStatusCd
    */
   public Truck( String locationCd,
                      String warehouseCd,
                      String TruckId,
                      String activeFlag,
                      String truckRegNo
   				)
   {
      this.m_locationCd = locationCd;
      this.m_warehouseCd = warehouseCd;
      this.m_TruckId = TruckId;
      this.m_activeFlag = activeFlag;
      this.m_truckRegNo = truckRegNo;
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
    * getTruckId
    * @return String
    */
   public String getTruckId()
   {
      return m_TruckId;
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
    * getTruckTypeCd
    * @return String
    */
   public String getTruckTypeCd()
   {
      return m_TruckTypeCd;
   }

   /**
    * getTruckStatusCd
    * @return String
    */
   public String getTruckStatusCd()
   {
      return m_TruckStatusCd;
   }

   /**
    * getActiveFlag
    * @return String
    */
   public String getActiveFlag()
   {
      return m_activeFlag;
   }

   /**
    * getTruckRegNo
    * @return String
    */
   public String getTruckRegNo()
   {
      return m_truckRegNo;
   }

   /**
    * setTruckStatusCd
    * @param String TruckStatusCd
    */
   public void setTruckStatusCd( String TruckStatusCd )
   {
      this.m_TruckStatusCd = TruckStatusCd;
   }

   /**
    * setTruckTypeCd
    * @param String TruckTypeCd
    */
   public void setTruckTypeCd( String TruckTypeCd )
   {
      this.m_TruckTypeCd = TruckTypeCd;
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
    * setTruckId
    * @param String TruckId
    */
   public void setTruckId( String TruckId )
   {
      this.m_TruckId = TruckId;
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

   /** setActiveFlag
    *  @param String locationCd
    */
   public void setActiveFlag( String activeFlag )
   {
      this.m_activeFlag = activeFlag;
   }

   /** setTruckRegNo
    *  @param String locationCd
    */
   public void setTruckRegNo( String truckRegNo )
   {
      this.m_truckRegNo = truckRegNo;
   }
   

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("Truck_DEF object -- \n");
      sb.append("LOCATION_CD      : " + m_locationCd + "\n" );
      sb.append("WAREHOUSE_CD     : " + m_warehouseCd + "\n" );
      sb.append("Truck_CD       : " + m_TruckId + "\n" );
      sb.append("DEST_LOCATION_CD : " + m_destinationLocationCd + "\n" );
      sb.append("SLIDE_AREA_CD    : " + m_slideAreaCd + "\n" );
      sb.append("Truck_TYPE_CD  : " + m_TruckTypeCd + "\n" );
      sb.append("Truck_STATUS_CD: " + m_TruckStatusCd + "\n" );
      return sb.toString();
   }

}