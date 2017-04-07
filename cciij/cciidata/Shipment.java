package cciij.cciidata;

/**
 * Title: Shipment Role Class
 * Description:
 * Copyright:   Copyright (c) 2001
 * Company:  Fedex Services
 * @author
 * @version 1.0
 *  2004/10/25   Joey Cline     Added isManifested method
 */
import java.util.*;
import cciij.businessActions.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class Shipment implements Serializable {
    private static final String m_whatVersion = "@(#) $RCSfile: Shipment.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
    private int m_shipmentOidNumber;
    private String m_awbNumber = "";
    private Date m_shipmentDate = new Date(0);
    private int m_pieceQuanity;
    private int m_handlingUnitQuanity;
    private int m_shipperAccountNumber;
    private int m_consigneeAccountNumber;
    private boolean m_isReasonCodeActive;
    private boolean m_isReleaseCodeActive;
    private double m_customsValueAmount;
    private double m_carriageValueAmount;
    private String m_serviceCode = "";
    private String m_originCountryCode = "";
    private String m_destinationCountryCode = "";
    private String m_shipperCompanyName = "";
    private String m_shipperContactName = "";
    private String m_shipperPostalCode = "";
    private String m_shipperCountryCode = "";
    private String m_consigneeCompanyName = "";
    private String m_consigneeContactName = "";
    private String m_consigneePostalCode = "";
    private String m_consigneeStateCode = "";
    private String m_consigneeCountryCode = "";
    private String m_consigneeAddress = "";
    private String m_consigneeCity = "";
    private String m_shipmentDescription = "";
    private String m_returnAWBNumber = "";
    private String m_destinationLocationCode = "";
    private String m_originLocationCode = "";
    private String m_formTypeCode = "";
    private String m_lastModifiedName = "";
    private Date m_lastModifiedTimestamp = new Date(0);
    private String m_overageReasonCode = "";
    private Date m_transactionSequenceTimestamp = new Date(0);
    private String m_manifestStatusCode = "";
    private String m_rodFlag = "";

    private String m_brokerEntryNumber = "";
    private String m_customsReviewedFlag = ""; //not null field added to the core table
    private String m_customsReleaseFlag = "";
    private String m_inTransitCd = "";
    private String m_customsDestCd = "";

    private String m_locationCode = "";
    private boolean m_nullCoreClearance = true;
    private String m_declaredFlg = "";
    private String m_saturdayDelFlg = "";
    private String m_holdAtLocFlg = "";
    private String m_dutiableFlg = "";
    private String m_specialHandling1Cd = "";
    private String m_specialHandling2Cd = "";
    private String m_specialHandling3Cd = "";
    private String m_specialHandling4Cd = "";
    private String m_specialHandling5Cd = "";
    private double m_localCustomsValueAmt = 0.0;

    private int m_hawbSerialNbr = 0;
    private String m_entryCategoryTypeCd = "";
    private String m_mawbNbr = "";
    private float m_lbsWgt = 0;
    private String m_priorNotificationNbr = "";
     

    Timestamp m_declaredTransactionSequenceTimestamp = new Timestamp(0);

    private String m_entryCategorySourceCd = "";

    //  Revision ShipmentRevision;

    /**
     * Shipment
     */
    public Shipment() {

    }

    /**
     * Shipment
     * @param shipOidNum
     * @param awbNum
     * @param shipDt
     * @param pcQty
     * @param handlingUnitQuantity
     * @param isReasonCodeActive
     * @param isReleaseCodeActive
     * @param dLocCode
     * @param oLocCode
     * @param frmTypeCode
     * @param brokerEntryNumber
     * @param manifestStatusCode
     * @param customsReleaseFlag
     */
    public Shipment(int shipmentOidNumber,
                    String awbNumber,
                    Date shipmentDate,
                    int pieceQuanity,
                    int handlingUnitQuantity,
                    boolean isReasonCodeActive,
                    boolean isReleaseCodeActive,
                    String dLocCode,
                    String oLocCode,
                    String formTypeCode,
                    String manifestStatusCode,
                    String customsReleaseFlag)
    {
        m_shipmentOidNumber = shipmentOidNumber;
        setAwbNumber(awbNumber);
        m_shipmentDate = shipmentDate;
        m_pieceQuanity = pieceQuanity;
        m_handlingUnitQuanity = handlingUnitQuantity;
        m_isReasonCodeActive = isReasonCodeActive;
        m_isReleaseCodeActive = isReleaseCodeActive;
        setDestinationLocationCode(dLocCode);
        setOriginLocationCode(oLocCode);
        setFormTypeCode(formTypeCode);
        m_customsValueAmount = 0.0;
        m_carriageValueAmount = 0.0;
        m_serviceCode = "";
        m_originCountryCode = "";
        m_destinationCountryCode = "";
        m_shipperCompanyName = "";
        m_shipperPostalCode = "";
        m_shipperCountryCode = "";
        m_consigneeCompanyName = "";
        m_consigneePostalCode = "";
        m_consigneeStateCode = "";
        m_consigneeCountryCode = "";
        m_shipmentDescription = "";
        m_returnAWBNumber = "";
        m_brokerEntryNumber = "";
        m_localCustomsValueAmt = 0.0;
        setIntransitCd("N");
        setRODFlag("N");
        setCustomsDestCd("     ");
        setCustomsReviewedFlag("N");
        setManifestStatusCode(manifestStatusCode);
        setCustomsReleaseFlag(customsReleaseFlag);
        setDeclaredFlag("N");

        //    OidFactory = null;

    }

    /**
     * Shipment
     * @param shipOdNumber
     * @param awbNum
     * @param shipDt
     * @param pcQty
     * @param handlingUnitQuantity
     * @param isReasonCodeActive
     * @param isReleaseCodeActive
     * @param custValueAmt
     * @param carrValueAmt
     * @param srvcCode
     * @param orgnCntryCode
     * @param destCntryCode
     * @param shipCoNm
     * @param shipPostCode
     * @param shipCntryCode
     * @param consCoNm
     * @param consPostCode
     * @param consCntryCode
     * @param shipDesc
     * @param manifestStatusCode
     * @param customsReleaseFlag
     */
    public Shipment(int shipmentOidNumber,
                    String awbNumber,
                    Date shipmentDate,
                    int pieceQuanity,
                    int handlingUnitQuantity,
                    boolean isReasonCodeActive,
                    boolean isReleaseCodeActive,
                    double customsValueAmount,
                    double carriageValueAmount,
                    String serviceCode,
                    String originCountryCode,
                    String destinationCountryCode,
                    String shipperCompanyName,
                    String shipperPostalCode,
                    String shipperCountryCode,
                    String consigneeCompanyName,
                    String consigneePostalCode,
                    String consigneeCountryCode,
                    String shipmentDescription,
                    String manifestStatusCode,
                    String customsReleaseFlag)
    {
        m_shipmentOidNumber = shipmentOidNumber;
        setAwbNumber(awbNumber);
        m_shipmentDate = shipmentDate;
        m_pieceQuanity = pieceQuanity;
        m_handlingUnitQuanity = handlingUnitQuantity;
        m_isReasonCodeActive = isReasonCodeActive;
        m_isReleaseCodeActive = isReleaseCodeActive;
        m_customsValueAmount = customsValueAmount;
        m_carriageValueAmount = carriageValueAmount;
        setServiceCode(serviceCode);
        setOriginCountryCode(originCountryCode);
        setDestinationCountryCode(destinationCountryCode);
        setShipperCompanyName(shipperCompanyName);
        setShipperPostalCode(shipperPostalCode);
        setShipperCountryCode(shipperCountryCode);
        setConsigneeCompanyName(consigneeCompanyName);
        setConsigneePostalCode(consigneePostalCode);
        setConsigneeCountryCode(consigneeCountryCode);
        setShipmentDescription(shipmentDescription);
        m_returnAWBNumber = "";
        m_destinationLocationCode = "";
        m_originLocationCode = "";
        m_formTypeCode = "";
        m_brokerEntryNumber = "";
        setCustomsReviewedFlag("N");
        setManifestStatusCode(manifestStatusCode);
        setCustomsReleaseFlag(customsReleaseFlag);
        setDeclaredFlag("N");

        //     OidFactory = null;


    }

    /**
     * Shipment
     * @param shipOdNumber
     * @param awbNum
     * @param shipDt
     * @param pcQty
     * @param handlingUnitQuantity
     * @param isReasonCodeActive
     * @param isReleaseCodeActive
     * @param custValueAmt
     * @param carrValueAmt
     * @param srvcCode
     * @param orgnCntryCode
     * @param destCntryCode
     * @param shipCoNm
     * @param shipPostCode
     * @param shipCntryCode
     * @param consCoNm
     * @param consPostCode
     * @param consCntryCode
     * @param shipDesc
     * @param rtrnAWBNum
     * @param dLocCode
     * @param oLocCode
     * @param frmTypeCode
     * @param manifestStatusCode
     * @param customsReleaseFlag
     */
    public Shipment(int shipmentOidNumber,
                    String awbNumber,
                    Date shipmentDate,
                    int pieceQuanity,
                    int handlingUnitQuantity,
                    boolean isReasonCodeActive,
                    boolean isReleaseCodeActive,
                    double customsValueAmount,
                    double carriageValueAmount,
                    String serviceCode,
                    String originCountryCode,
                    String destinationCountryCode,
                    String shipperCompanyName,
                    String shipperPostalCode,
                    String shipperCountryCode,
                    String consigneeCompanyName,
                    String consigneePostalCode,
                    String consigneeCountryCode,
                    String shipmentDescription,
                    String returnAWBNumber,
                    String dLocCode,
                    String oLocCode,
                    String formTypeCode,
                    String brokerEntryNumber,
                    String customsReviewedFlag,
                    String manifestStatusCode,
                    String customsReleaseFlag,
                    String declaredFlg,
                    Timestamp declaredTransactionSeqTmstp)
    {
        m_shipmentOidNumber = shipmentOidNumber;
        setAwbNumber(awbNumber);
        m_shipmentDate = shipmentDate;
        m_pieceQuanity = pieceQuanity;
        m_handlingUnitQuanity = handlingUnitQuantity;
        m_isReasonCodeActive = isReasonCodeActive;
        m_isReleaseCodeActive = isReleaseCodeActive;
        m_customsValueAmount = customsValueAmount;
        m_carriageValueAmount = carriageValueAmount;
        setServiceCode(serviceCode);
        setOriginCountryCode(originCountryCode);
        setDestinationCountryCode(destinationCountryCode);
        setShipperCompanyName(shipperCompanyName);
        setShipperPostalCode(shipperPostalCode);
        setShipperCountryCode(shipperCountryCode);
        setConsigneeCompanyName(consigneeCompanyName);
        setConsigneePostalCode(consigneePostalCode);
        setConsigneeCountryCode(consigneeCountryCode);
        setShipmentDescription(shipmentDescription);
        setReturnAWBNumber(returnAWBNumber);
        setDestinationLocationCode(dLocCode);
        setOriginLocationCode(oLocCode);
        setFormTypeCode(formTypeCode);
        setBrokerEntryNumber(brokerEntryNumber);
        setManifestStatusCode(manifestStatusCode);
        setCustomsReleaseFlag(customsReleaseFlag);
        setCustomsReviewedFlag(customsReviewedFlag);
        setDeclaredFlag(declaredFlg);
        setDeclaredTransactionSequenceTimestamp(declaredTransactionSeqTmstp);

        //    OidFactory = null;


    }

    /**
     * finalize
     */
    protected void finalize() {

    }

    /**
     * getShipmentOidNumber
     * @return int
     */
    public int getShipmentOidNumber()
    {
        return m_shipmentOidNumber;
    }

    /**
     * getAWBNumber
     * @return String
     */
    public String getAWBNumber()
    {
        return m_awbNumber;
    }

    /**
     * getHAWBSerialNumber
     * @return int
     */
    public int getHAWBSerialNumber()
    {
        return m_hawbSerialNbr;
    }

    /**
     * getShipmentDate
     * @return Date
     */
    public Date getShipmentDate()
    {
        return m_shipmentDate;
    }

    /**
     * getPieceQuanity
     * @return int
     */
    public int getPieceQuanity()
    {
        return m_pieceQuanity;
    }

    /**
     * getHandlingUnitQuanity
     * @return int
     */
    public int getHandlingUnitQuanity()
    {
        return m_handlingUnitQuanity;
    }

    /**
     * isManifested
     * @return boolean
     */
    public boolean isManifested()
    {
	boolean retVal = true;

	if (  ( getManifestStatusCode() == null )
	   || ( getManifestStatusCode().trim().equals("A") == false ) )
	{
	    //not manifested
	    retVal = false;
	}

	return retVal;
    }

    /**
     * isReasonCodeActive
     * @return boolean
     */
    public boolean isReasonCodeActive()
    {
        boolean retVal = false;

        if(m_isReasonCodeActive == true)
        {
            retVal =  true;
        }

        return retVal;

    }

    /**
     * isReleaseCodeActive
     * @return boolean
     */
    public boolean isReleaseCodeActive()
    {
        boolean retVal = false;

        if(m_isReleaseCodeActive == true)
        {
            retVal =  true;
        }

        return retVal;
    }

    /**
     * getCustomValueAmount
     * @return double
     */
    public double getCustomValueAmount()
    {
        return m_customsValueAmount;
    }

    /**
     * getLocalCustomValueAmount
     * @return double
     */
    public double getLocalCustomValueAmount()
    {
        return m_localCustomsValueAmt;
    }

    /**
     * getCarriageValueAmount
     * @return double
     */
    public double getCarriageValueAmount()
    {
        return m_carriageValueAmount;
    }

    /**
     * getServiceCode
     * @return String
     */
    public String getServiceCode()
    {
        return m_serviceCode;
    }

    /**
     * getOriginCountryCode
     * @return String
     */
    public String getOriginCountryCode()
    {
        return m_originCountryCode;
    }

    /**
     * getDestinationCountryCode
     * @return String
     */
    public String getDestinationCountryCode()
    {
        return m_destinationCountryCode;
    }

    /**
     * getShipperAccountNumber
     * @return int
     */
    public int getShipperAccountNumber()
    {
        return m_shipperAccountNumber;
    }

    /**
     * getShipperCompanyName
     * @return String
     */
    public String getShipperCompanyName()
    {
        return m_shipperCompanyName;
    }

    /**
     * getShipperContactName
     * @return String
     */
    public String getShipperContactName()
    {
        return m_shipperContactName;
    }

    /**
     * getShipperPostalCode
     * @return String
     */
    public String getShipperPostalCode()
    {
        return m_shipperPostalCode;
    }

    /**
     * getShipperCountryCode
     * @return String
     */
    public String getShipperCountryCode()
    {
        return m_shipperCountryCode;
    }

    /**
     * getConsigneeAccountNumber
     * @return int
     */
    public int getConsigneeAccountNumber()
    {
        return m_consigneeAccountNumber;
    }

    /**
     * getConsigneeCompanyName
     * @return String
     */
    public String getConsigneeCompanyName()
    {
        return m_consigneeCompanyName;
    }

    /**
     * getConsigneeContactName
     * @return String
     */
    public String getConsigneeContactName()
    {
        return m_consigneeContactName;
    }

    /**
     * getConsigneePostalCode
     * @return String
     */
    public String getConsigneePostalCode()
    {
        return m_consigneePostalCode;
    }

    /**
     * getConsigneeStateCode
     * @return String
     */
    public String getConsigneeStateCode()
    {
    return m_consigneeStateCode;
    }

    /**
     * getConsigneeCountryCode
     * @return String
     */
    public String getConsigneeCountryCode()
    {
        return m_consigneeCountryCode;
    }

    /**
     * getShipmentDescription
     * @return String
     */
    public String getShipmentDescription()
    {
        return m_shipmentDescription;
    }

    /**
     * getReturnAWBNumber
     * @return String
     */
    public String getReturnAWBNumber()
    {
        return m_returnAWBNumber;
    }

    /**
     * getDestinationLocCode
     * @return String
     */
    public String getDestinationLocCode()
    {
        return m_destinationLocationCode;
    }

    /**
     * getOriginLocCode
     * @return String
     */
    public String getOriginLocCode()
    {
        return m_originLocationCode;
    }

    /**
     * getFormTypeCode
     * @return String
     */
    public String getFormTypeCode()
    {
        return m_formTypeCode;
    }

    /**
     * getLastModifiedName
     * @return String
     */
    public String getLastModifiedName()
    {
        return m_lastModifiedName;
    }

    /**
     * getLastModifiedTimestamp
     * @return Date
     */
    public Date getLastModifiedTimestamp()
    {
        return m_lastModifiedTimestamp;
    }

    /**
     * getOverageReasonCode
     * @return String
     */
    public String getOverageReasonCode()
    {
        return m_overageReasonCode;
    }

    /**
     * getBrokerEntryNumber
     * @return String
     */
    public String getBrokerEntryNumber()
    {
        return m_brokerEntryNumber;
    }
    /**
     * getCustomsReviewedFlag()
     * @return String
     */
    public String getCustomsReviewedFlag()
    {
        return m_customsReviewedFlag;
    }
    /**
     * getDeclaredFlag()
     * @return String
     */
    public String getDeclaredFlag()
    {
        return m_declaredFlg;
    }

    /**
     * getTransactionSequenceTimestamp
     * @return Date
     */
    public Date getTransactionSequenceTimestamp()
    {
        return m_transactionSequenceTimestamp;
    }

    /**
     * getDeclaredTransactionSequenceTimestamp
     * @return Timestamp
     */
    public Timestamp getDeclaredTransactionSequenceTimestamp()
    {
        return m_declaredTransactionSequenceTimestamp;
    }

    public String getManifestStatusCode()
    {
        return m_manifestStatusCode;
    }

    /**
     * getCustomsReleaseFlag
     * @return String
     */
    public String getCustomsReleaseFlag()
    {
        return m_customsReleaseFlag;
    }

    public String getLocationCode()
    {
        return m_locationCode;
    }

    public boolean getNullCoreClearance()
    {
        return m_nullCoreClearance;
    }

    public String getSaturdayDelFlg()
    {
       return this.m_saturdayDelFlg;
    }

    public String getHoldAtLocFlg()
    {
       return this.m_holdAtLocFlg;
    }

    public String getDutiableFlg()
    {
       return this.m_dutiableFlg;
    }

    public String getSpecialHandling1Cd()
    {
       return this.m_specialHandling1Cd;
    }

    public String getSpecialHandling2Cd()
    {
       return this.m_specialHandling2Cd;
    }

    public String getSpecialHandling3Cd()
    {
       return this.m_specialHandling3Cd;
    }

    public String getSpecialHandling4Cd()
    {
       return this.m_specialHandling4Cd;
    }

    public String getSpecialHandling5Cd()
    {
       return this.m_specialHandling5Cd;
    }

    public String getEntryCategoryTypeCode()
    {
        return this.m_entryCategoryTypeCd;
    }

    public String getEntryCategorySourceCode()
    {
        return this.m_entryCategorySourceCd;
    }

/*    public String getLocalCustomsValueAmt()
    {
        return this.m_localCustomsValueAmt.asString;
    }
*/
    public double getLocalCustomsValueAmt()
    {
        return this.m_localCustomsValueAmt;
    }

    public String getIntransitCd()
    {
        return this.m_inTransitCd;
    }

    public String getRODFlag()
    {
        return this.m_rodFlag;
    }

    public String getCustomsDestCd()
    {
        return this.m_customsDestCd;
    }

    public String getMawbNbr()
    {
        return this.m_mawbNbr;
    }

    public float getLbsWgt()
    {
        return m_lbsWgt;
    }

    public String getPriorNotificationNbr()
    {
        return m_priorNotificationNbr;
    }

    public String getConsigneeAddress()
    {
        return this.m_consigneeAddress;
    }
    
    public String getConsigneeCity()
    {
        return this.m_consigneeCity;
    }

    /**
     * setShipmentOidNumber
     * @int
     */
    public void setShipmentOidNumber(int i)
    {
        if (m_shipmentOidNumber == 0)
        {
            m_shipmentOidNumber = i;
        }
    }

    /**
     * setFormTypeCode
     * @param ftc
     */
    public void setFormTypeCode(String ftc)
    {
        if(ftc == null)
        {
            m_formTypeCode = "";
        }
        else
        {
            m_formTypeCode = ftc;
        }
    }

    /**
     * setReturnAWBNumber
     * @param newAWBNum
     */
    public void setReturnAWBNumber(String s)
    {
        if(s == null)
        {
            m_returnAWBNumber = "";
        }
        else
        {
            m_returnAWBNumber = s;
        }
    }

    /**
     * setLastModifiedName
     * @param String
     */
    public void setLastModifiedName(String s)
    {
        if(s == null)
        {
            m_lastModifiedName = "";
        }
        else
        {
            m_lastModifiedName = s;
        }
    }

    /**
     * setLastModifiedTimestamp
     * @param Date
     */
    public void setLastModifiedTimestamp(Date d)
    {
        m_lastModifiedTimestamp = d;
    }

    /**
     * setLastModifiedTimestamp
     * @param long lDt
     */
    public void setLastModifiedTimestamp(long lDt)
    {
        m_lastModifiedTimestamp = new Date(lDt);
    }

    /**
     * setOverageReasonCode
     * @param String
     */
    public void setOverageReasonCode(String s)
    {
        if(s == null)
        {
            m_overageReasonCode = "";
        }
        else
        {
            m_overageReasonCode = s;
        }
    }

    /**
     * setBrokerEntryNumber
     * @param String
     */
    public void setBrokerEntryNumber(String s)
    {
        if(s == null)
        {
            m_brokerEntryNumber = "";
        }
        else
        {
            m_brokerEntryNumber = s;
        }
    }
    /**
     * setCustomsReviewedFlag()
     * @param String
     */
    public void setCustomsReviewedFlag(String s)
    {
        if( s != null )
        {
           m_customsReviewedFlag = s;
        }
        else
        {
           m_customsReviewedFlag = "N";
        }
    }

    /**
     * setDeclaredFlag()
     * @param String
     */
    public void setDeclaredFlag(String s)
    {
        if( s != null )
        {
           m_declaredFlg = s;
        }
        else
        {
           m_declaredFlg = "N";
        }
    }

    /**
     * setAwbNumber
     * @param String
     */
    private void setAwbNumber(String s)
    {
        if(s == null)
        {
            m_awbNumber = "";
        }
        else
        {
            m_awbNumber = s;
        }
    }

    /**
     * setHAWBSerialNumber
     * @param int
     */
    public void setHAWBSerialNumber(int i)
    {
        m_hawbSerialNbr = i;
    }

    /**
     * setServiceCode
     * @param String
     */
    private void setServiceCode(String s)
    {
        if(s == null)
        {
            m_serviceCode = "";
        }
        else
        {
            m_serviceCode = s;
        }
    }

    /**
     * setOriginCountryCode
     * @param String
     */
    public void setOriginCountryCode(String s)
    {
        if(s == null)
        {
            m_originCountryCode = "";
        }
        else
        {
            m_originCountryCode = s;
        }
    }

    /**
     * setDestinationCountrycode
     * @param String
     */
    private void setDestinationCountryCode(String s)
    {
        if(s == null)
        {
            m_destinationCountryCode = "";
        }
        else
        {
            m_destinationCountryCode = s;
        }
    }

    /**
     * setShipperAccountNumber
     * @param int
     */
    public void setShipperAccountNumber(int i)
    {
        m_shipperAccountNumber = i;
    }

    /**
     * setShipperCompanyName
     * @param String
     */
    public void setShipperCompanyName(String s)
    {
        if(s == null)
        {
            m_shipperCompanyName = "";
        }
        else
        {
            m_shipperCompanyName = s;
        }
    }

    /**
     * setShipperContactName
     * @param String
     */
    public void setShipperContactName(String s)
    {
        if(s == null)
        {
            m_shipperContactName = "";
        }
        else
        {
            m_shipperContactName = s;
        }
    }

    /**
     * setShipperPostalCode
     * @param String
     */
    private void setShipperPostalCode(String s)
    {
        if(s == null)
        {
            m_shipperPostalCode = "";
        }
        else
        {
            m_shipperPostalCode = s;
        }
    }

    /**
     * setShipperCountryCode
     * @param String
     */
    private void setShipperCountryCode(String s)
    {
        if(s == null)
        {
            m_shipperCountryCode = "";
        }
        else
        {
            m_shipperCountryCode = s;
        }
    }

    /**
     * setConsigneeAccountNumber
     * @param int
     */
    public void setConsigneeAccountNumber(int i)
    {
        m_consigneeAccountNumber = i;
    }

    /**
     * setConsigneeCompanyName
     * @param String
     */
    public void setConsigneeCompanyName(String s)
    {
        if(s == null)
        {
            m_consigneeCompanyName = "";
        }
        else
        {
            m_consigneeCompanyName = s;
        }
    }

    /**
     * setConsigneeContactName
     * @param String
     */
    public void setConsigneeContactName(String s)
    {
        if(s == null)
        {
            m_consigneeContactName = "";
        }
        else
        {
            m_consigneeContactName = s;
        }
    }

    /**
     * setConsigneePostalCode
     * @param String
     */
    private void setConsigneePostalCode(String s)
    {
        if(s == null)
        {
            m_consigneePostalCode = "";
        }
        else
        {
            m_consigneePostalCode = s;
        }
    }

    /**
     * setConsigneeStateCode
     * @param String
     */
    public void setConsigneeStateCode(String s)
    {
    if(s == null)
    {
        m_consigneeStateCode = "";
    }
    else
    {
        m_consigneeStateCode = s;
    }
    }

    /**
     * setConsigneeCountryCode
     * @param String
     */
    private void setConsigneeCountryCode(String s)
    {
        if(s == null)
        {
            m_consigneeCountryCode = "";
        }
        else
        {
            m_consigneeCountryCode = s;
        }
    }

    /**
     * setShipmentDescription
     * @param String
     */
    private void setShipmentDescription(String s)
    {
        if(s == null)
        {
            m_shipmentDescription = "";
        }
        else
        {
            m_shipmentDescription = s;
        }
    }

    /**
     * setDestinationLocationCode
     * @param String
     */
    public void setDestinationLocationCode(String s)
    {
        if(s == null)
        {
            m_destinationLocationCode = "";
        }
        else
        {
            m_destinationLocationCode = s;
        }
    }

    /**
     * setOriginLocationCode
     * @param String
     */
    public void setOriginLocationCode(String s)
    {
        if(s == null)
        {
            m_originLocationCode = "";
        }
        else
        {
            m_originLocationCode = s;
        }
    }

    /**
     * setLocalCustomsValueAmount
     * @param double
     */
    private void setLocalCustomsValueAmount(double d)
    {
        m_localCustomsValueAmt = d;
    }


    /**
     * setDeclaredTransactionSequenceTimestamp
     * @param Timestamp
     */
    public void setDeclaredTransactionSequenceTimestamp(Date date)
    {

        if ( date instanceof Timestamp )  // subclass must be checked first
        {
            m_declaredTransactionSequenceTimestamp = (java.sql.Timestamp)date;
        }
        else
        if ( date instanceof Date )
        {
            m_declaredTransactionSequenceTimestamp
              = new Timestamp ( date.getTime() );
        }
    }

    // use tmstp from this point on...}

    /**
     * setTransactionSequenceTimestamp
     * @param Date
     */
    public void setTransactionSequenceTimestamp(Date d)
    {
        m_transactionSequenceTimestamp = d;
    }

    /**
     * setTransactionSequenceTimestamp
     * @param long
     */
    public void setTransactionSequenceTimestamp(long l)
    {
        m_transactionSequenceTimestamp = new Date( l );
    }

    /**
     * setManifestStatusCode
     * @param String
     */
    public void setManifestStatusCode(String s)
    {
        if(s == null)
        {
            m_manifestStatusCode = "";
        }
        else
        {
            m_manifestStatusCode = s;
        }
    }

    public void setCustomsReleaseFlag(String s)
    {
        if (s == null)
        {
            m_customsReleaseFlag = "";
        }
        else
        {
            m_customsReleaseFlag = s;
        }
    }


    public void setLocationCode(String s)
    {
        if(s == null)
        {
            m_locationCode = "";
        }
        else
        {
            m_locationCode = s;
        }
    }

    public void setNullCoreClearance(boolean b)
    {
        m_nullCoreClearance = b;
    }

    /**
     * displayRevision
     */
    public void displayRevision()
    {
        //      ShipmentRevision.displayRevision();
    }

    public void setSaturdayDelFlg( String saturdayDelFlg )
    {
       this.m_saturdayDelFlg = saturdayDelFlg;
    }

    public void setHoldAtLocFlg( String holdAtLocFlg )
    {
       this.m_holdAtLocFlg = holdAtLocFlg;
    }

    public void setDutiableFlg( String dutiableFlg )
    {
       this.m_dutiableFlg = dutiableFlg;
    }

    public void setSpecialHandling1Cd( String specialHandling1Cd )
    {
       this.m_specialHandling1Cd = specialHandling1Cd;
    }

    public void setSpecialHandling2Cd( String specialHandling2Cd )
    {
       this.m_specialHandling2Cd = specialHandling2Cd;
    }

    public void setSpecialHandling3Cd( String specialHandling3Cd )
    {
       this.m_specialHandling3Cd = specialHandling3Cd;
    }

    public void setSpecialHandling4Cd( String specialHandling4Cd )
    {
       this.m_specialHandling4Cd = specialHandling4Cd;
    }

    public void setSpecialHandling5Cd( String specialHandling5Cd )
    {
       this.m_specialHandling5Cd = specialHandling5Cd;
    }

    public void setLocalCustomsValueAmt( double localCustomsValueAmt )
    {
        this.m_localCustomsValueAmt = localCustomsValueAmt;
    }

    /**
     * setIntransitCd()
     * @param String
     */
    public void setIntransitCd(String s)
    {
    if( s != null )
    {
           m_inTransitCd = s;
        }
        else
    {
           m_inTransitCd = "N";
        }
    }

    /**
     * setRODFlag()
     * @param String
     */
    public void setRODFlag(String s)
    {
    if( s != null )
    {
           m_rodFlag = s;
        }
        else
    {
           m_rodFlag = "N";
        }
    }

    public void setCustomsDestCd(String s)
    {
    if( s != null )
    {
           m_customsDestCd = s;
        }
        else
    {
           m_customsDestCd = "     ";
        }
    }

    public void setEntryCategoryTypeCd(String s)
    {
      if ( s != null )
      {
        this.m_entryCategoryTypeCd = s;
      }
      else
      {
         m_entryCategoryTypeCd = "";
      }
    }

    public void setEntryCategorySourceCd(String s)
    {
      if ( s != null )
      {
        m_entryCategorySourceCd = s;
      }
      else
      {
        m_entryCategorySourceCd = "";
      }
    }


    /**
     * setMawbNbr()
     * @param String
     */
    public void setMawbNbr(String s)
    {
       this.m_mawbNbr = s;
    }

    public void setLbsWgt(float lbsWgt)
    {
        m_lbsWgt = lbsWgt;
    }

    public void setPriorNotificationNbr(String priorNotificationNbr)
    {
        m_priorNotificationNbr = priorNotificationNbr;
    }

    /**
     * setConsigneeAddress()
     * @param String
     */
    public void setConsigneeAddress(String s)
    {
       this.m_consigneeAddress = s;
    }

    /**
     * setConsigneeCity()
     * @param String
     */
    public void setConsigneeCity(String s)
    {
       this.m_consigneeCity = s;
    }

    /**
     * toString
     * @return String
     */
    public String toString()
    {
        String s = "";

        s +=  "Shipment object -- " + "\n";

        s += "shipmentOidNumber            : " + m_shipmentOidNumber+ "\n";
        s += "awbNumber                    : " + m_awbNumber+ "\n";
        s += "shipmentDate                 : " + m_shipmentDate+ "\n";
        s += "pieceQuanity                 : " + m_pieceQuanity+ "\n";
        s += "handlingUnitQuanity          : " + m_handlingUnitQuanity+ "\n";
        s += "isReasonCodeActive           : " + m_isReasonCodeActive+ "\n";
        s += "isReleaseCodeActive          : " + m_isReleaseCodeActive+ "\n";
        s += "customsValueAmount           : " + m_customsValueAmount+ "\n";
        s += "carriageValueAmount          : " + m_carriageValueAmount+ "\n";
        s += "serviceCode                  : " + m_serviceCode+ "\n";
        s += "originCountryCode            : " + m_originCountryCode+ "\n";
        s += "destinationCountryCode       : " + m_destinationCountryCode+ "\n";
        s += "shipperAccountNumber         : " + m_shipperAccountNumber+ "\n";
        s += "shipperCompanyName           : " + m_shipperCompanyName+ "\n";
        s += "shipperContactName           : " + m_shipperContactName+ "\n";
        s += "shipperPostalCode            : " + m_shipperPostalCode+ "\n";
        s += "shipperCountryCode           : " + m_shipperCountryCode+ "\n";
        s += "consigneeAccountNumber         : " + m_consigneeAccountNumber+ "\n";
        s += "consigneeCompanyName         : " + m_consigneeCompanyName+ "\n";
        s += "consigneeContactName         : " + m_consigneeContactName+ "\n";
        s += "consigneeAddress             : " + m_consigneeAddress + "\n";
        s += "consigneeCity                : " + m_consigneeCity + "\n";
        s += "consigneePostalCode          : " + m_consigneePostalCode+ "\n";
        s += "consigneeStateCode           : " + m_consigneeStateCode+ "\n";
        s += "consigneeCountryCode         : " + m_consigneeCountryCode+ "\n";
        s += "shipmentDescription          : " + m_shipmentDescription+ "\n";
        s += "returnAWBNumber              : " + m_returnAWBNumber+ "\n";
        s += "destinationLocationCode      : " + m_destinationLocationCode+ "\n";
        s += "originLocationCode           : " + m_originLocationCode+ "\n";
        s += "formTypeCode                 : " + m_formTypeCode+ "\n";
        s += "lastModifiedName             : " + m_lastModifiedName+ "\n";
        s += "lastModifiedTimestamp        : " + m_lastModifiedTimestamp+ "\n";
        s += "overageReasonCode            : " + m_overageReasonCode+ "\n";
        s += "brokerEntryNumber            : " + m_brokerEntryNumber+ "\n";
        s += "customsReviewedFlag          : " + m_customsReviewedFlag+ "\n";
        s += "transactionSequenceTimestamp : " + m_transactionSequenceTimestamp+ "\n";
        s += "manifestStatusCode           : " + m_manifestStatusCode+ "\n";
        s += "brokerEntryNumber            : " + m_brokerEntryNumber+ "\n";
        s += "customsReviewedFlag          : " + m_customsReviewedFlag+ "\n";
        s += "customsReleaseFlag           : " + m_customsReleaseFlag+ "\n";
        s += "IntransitCd                  : " + m_inTransitCd + "\n";
        s += "RODFlag                      : " + m_rodFlag + "\n";
        s += "CustomsDestCd                : " + m_customsDestCd + "\n";
        s += "locationCode                 : " + m_locationCode + "\n";
        s += "nullCoreClearance            : " + m_nullCoreClearance + "\n";
        s += "declaredFlag                 : " + m_declaredFlg + "\n";
        s += "declaredTransactionSeqTmstp  : " + m_declaredTransactionSequenceTimestamp + "\n";
        s += "saturdayDelFlg               : " + m_saturdayDelFlg + "\n";
        s += "holdAtLocFlg                 : " + m_holdAtLocFlg + "\n";
        s += "dutiableFlg                  : " + m_dutiableFlg + "\n";
        s += "specialHandling1Cd           : " + m_specialHandling1Cd + "\n";
        s += "specialHandling2Cd           : " + m_specialHandling2Cd + "\n";
        s += "specialHandling3Cd           : " + m_specialHandling3Cd + "\n";
        s += "specialHandling4Cd           : " + m_specialHandling4Cd + "\n";
        s += "specialHandling5Cd           : " + m_specialHandling5Cd + "\n";
        s += "localCustomsValueAmt         : " + m_localCustomsValueAmt + "\n";
        s += "hawbSerialNbr                : " + m_hawbSerialNbr + "\n";
        s += "entryCategoryTypeCd          : " + m_entryCategoryTypeCd + "\n";
        s += "mawbNbr                      : " + m_mawbNbr + "\n";
        s += "lbsWgt                       : " + m_lbsWgt + "\n";
        s += "priorNotificationNbr         : " + m_priorNotificationNbr + "\n";
        s += "entryCategorySourceCd        : " + m_entryCategorySourceCd + "\n";
       

        return s;
    }
}
