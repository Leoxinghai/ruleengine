package cciij.cciidata;

/**
 * Title:        ContractBroker
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Gary Rockwood
 * @version 1.0
 */

public class ContractBroker
{
   private static final String m_whatVersion = "@(#) $RCSfile: ContractBroker.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private int m_shipmentOidNbr;
   private String m_brokerNm = "";
   private String m_brokerCityNm   = "";
   private String m_brokerCountryCd = "";
   private String m_brokerPostalCd = "";
   private String m_brokerDestLocCd = "";
   private String m_brokerPhoneNbr = "";

   /**
    * Public default constructor
    */
   public ContractBroker()
   {
   }

   /**
    * Public constructor
    * @param int shipmentOidNbr
    * @param String brokerNm
    * @param String brokerCityNm
    * @param String brokerCountryCd
    * @param String brokerPostalCd
    * @param String brokerDestLocCd
    * @param String brokerPhoneNbr
    */
   public ContractBroker( int shipmentOidNbr,
                          String brokerNm,
                          String brokerCityNm,
                          String brokerCountryCd,
                          String brokerPostalCd,
                          String brokerDestLocCd,
                          String brokerPhoneNbr )
   {
      this.m_shipmentOidNbr = shipmentOidNbr;
      this.m_brokerNm = brokerNm;
      this.m_brokerCityNm = brokerCityNm;
      this.m_brokerCountryCd = brokerCountryCd;
      this.m_brokerPostalCd = brokerPostalCd;
      this.m_brokerDestLocCd = brokerDestLocCd;
      this.m_brokerPhoneNbr = brokerPhoneNbr;
   }

    /**
     * getShipmentOidNbr
     * @return int
     */
    public int getShipmentOidNbr() {
        return m_shipmentOidNbr;
    }

   /**
    * getBrokerNm
    * @return String
    */
   public String getBrokerNm()
   {
      return m_brokerNm;
   }

   /**
    * getBrokerCityNm
    * @return String
    */
   public String getBrokerCityNm()
   {
      return m_brokerCityNm;
   }

   /**
    * getBrokerCountryCd
    * @return String
    */
   public String getBrokerCountryCd()
   {
      return m_brokerCountryCd;
   }

   /**
    * getBrokerPostalCd
    * @return String
    */
   public String getBrokerPostalCd()
   {
      return m_brokerPostalCd;
   }

   /**
    * getBrokerDestLocCd
    * @return String
    */
   public String getBrokerDestLocCd()
   {
      return m_brokerDestLocCd;
   }

   /**
    * getBrokerPhoneNbr
    * @return String
    */
   public String getBrokerPhoneNbr()
   {
      return m_brokerPhoneNbr;
   }

   /**
     * setShipmentOidNumber
     * @param int oid
     */
   public void setShipmentOidNbr(int oid) 
   {
      this.m_shipmentOidNbr = oid;
   }

   /**
    * setBrokerNm
    * @param String brokerNm
    */
   public void setBrokerNm( String brokerNm )
   {
      this.m_brokerNm = brokerNm;
   }

   /**
    * setBrokerCityNm
    * @param String brokerCityNm
    */
   public void setBrokerCityNm( String brokerCityNm )
   {
      this.m_brokerCityNm = brokerCityNm;
   }

   /**
    * setBrokerCountryCd
    * @param String brokerCountryCd
    */
   public void setBrokerCountryCd( String brokerCountryCd )
   {
      this.m_brokerCountryCd = brokerCountryCd;
   }

   /**
    * setBrokerPostalCd
    * @param String brokerPostalCd
    */
   public void setBrokerPostalCd( String brokerPostalCd )
   {
      this.m_brokerPostalCd = brokerPostalCd;
   }

   /** setBrokerDestLocCd
    *  @param String brokerDestLocCd
    */
   public void setBrokerDestLocCd( String brokerDestLocCd )
   {
      this.m_brokerDestLocCd = brokerDestLocCd;
   }

   /** setBrokerPhoneNbr
    *  @param String brokerPhoneNbr
    */
   public void setBrokerPhoneNbr( String brokerPhoneNbr )
   {
      this.m_brokerPhoneNbr = brokerPhoneNbr;
   }

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("CONTRACT_BROKER object -- \n");
      sb.append("SHIPMENT_OID_NBR   : " + m_shipmentOidNbr + "\n" );
      sb.append("BROKER_NM          : " + m_brokerNm + "\n" );
      sb.append("BROKER_CITY_NM     : " + m_brokerCityNm + "\n" );
      sb.append("BROKER_COUNTRY_CD  : " + m_brokerCountryCd + "\n" );
      sb.append("BROKER_POSTAL_CD   : " + m_brokerPostalCd + "\n" );
      sb.append("BROKER_DEST_LOC_CD : " + m_brokerDestLocCd + "\n" );
      sb.append("BROKER_PHONE_NBR   : " + m_brokerPhoneNbr + "\n" );
      return sb.toString();
   }

}
