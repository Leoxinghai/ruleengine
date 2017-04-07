

package cciij.cciidata;

/**
 * Title: HandlingUnit Role Class
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:  Fedex Services
 * @author
 * @version 1.0
 *    03/09/04   Gary Rockwood  Added TravelStatus information
 *  2004/10/25   Joey Cline     Added isManifested method
 */

import java.util.*;
import cciij.businessActions.*;
import java.io.Serializable;

public class HandlingUnit  implements Serializable
{
    private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnit.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    // fields in piece table
    private int m_handlingUnitOidNumber;
    private String m_trackingNumber = "";
    private String m_formTypeCode = "";
    private int m_shipmentOidNumber;
    private String m_harmonizedTariffNumber = "";
    private float m_totalWeight;
    private String m_totalWeightTypeCode = "";
    private double m_customsValueAmount;
    private String m_entryStatusCode = "";
    private String  m_airbillTypeCode = "";
    private String m_detainmentLocationDescription = "";
    private Date m_transactionSequenceTimestamp = new Date(0);
    private String m_manifestStatusCode = "";
    private String m_pieceStatusCode = "";

    //fields in piece core clearance table
    private Date m_lastModifiedTimeStamp = new Date(0);
    private String m_lastUserName = "";
    private String m_entryCategoryTypeCode = "";
    private String m_recurringSelectFlag = "";
    private String m_overageReasonCode = "";
    private String m_stagingAreaCode = "";
    private String m_locationCode = "";
    private boolean m_nullCoreClearance = true;
    private String m_warehouseCode = "";
    private String m_destLocationCd = "";
    private String m_shuttleCode = "";
    private String m_travelStatus = "";

    /**
     * HandlingUnit
     */
    public HandlingUnit()
    {
    }

    /**
     * HandlingUnit
     * @param handlingUnitOidNumber
     * @param trackingNumber
     * @param formTypeCode
     * @param shipmentOidNumber
     * @param harmonizedTariffNumber
     * @param totalWeight
     * @param totalWeightTypeCode
     * @param customValueAmount
     * @param entryStatCode
     * @param awbTypeCode
     * @param detainLocationDescription
     * @param entryCategoryTypeCode
     * @param recurringSelectFlag
     * @param overageReasonCode
     * @param manifestStatusCode
     */
    public HandlingUnit(int handlingUnitOidNumber,
			String trackingNumber,
			String formTypeCode,
			int shipmentOidNumber,
			String harmonizedTariffNumber,
			float totalWeight,
			String totalWeightTypeCode,
			double customsValueAmount,
			String entryStatusCode,
			String airbillTypeCode,
			String detainmentLocationDescription,
			String manifestStatusCode,
			String pieceStatusCode)
    {
	m_handlingUnitOidNumber = handlingUnitOidNumber;
	setTrackingNumber(trackingNumber);
	setFormTypeCode(formTypeCode);
	m_shipmentOidNumber = shipmentOidNumber;
	setHarmonizedTarrifNumber(harmonizedTariffNumber);
	m_totalWeight = totalWeight;
	setTotalWeightTypeCode(totalWeightTypeCode);
	m_customsValueAmount = customsValueAmount;
	setEntryStatusCode(entryStatusCode);
	setAirbillTypeCode(airbillTypeCode);
	setDetainmentLocationDescription(detainmentLocationDescription);
	setManifestStatusCode(manifestStatusCode);
	setPieceStatusCode(pieceStatusCode);
	//    m_lastModifiedTimeStamp = lastModifiedTimeStamp ;
	//    m_lastUserName = lastUserName;


    }

    /**
     * finalize
     */
    protected void finalize()
    {
    }

    /**
     * getShuttleCode
     * @return String
     */
    public String getShuttleCode()
    {
       return m_shuttleCode;
    }

    /**
     * setShuttleCode
     * @param String shuttleCode
     */
    public void setShuttleCode( String shuttleCode )
    {
       this.m_shuttleCode = shuttleCode;
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
     * @param String destLocationCd
     */
    public void setDestLocationCd( String destLocationCd )
    {
       this.m_destLocationCd = destLocationCd;
    }

    /**
     * getHandlingUnitOidNumber
     * @return int
     */
    public int getHandlingUnitOidNumber()
    {
	return m_handlingUnitOidNumber;
    }

    /**
     * getTrackingNumber
     * @return String
     */
    public String getTrackingNumber()
    {
	return m_trackingNumber;
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
     * getShipmentOidNumber
     * @return int
     */
    public int getShipmentOidNumber()
    {
	return m_shipmentOidNumber;
    }

    /**
     * getHarmonizedTariffNumber
     * @return String
     */
    public String getHarmonizedTariffNumber()
    {
	return m_harmonizedTariffNumber;
    }

    /**
     * getTotalWeight
     * @return float
     */
    public float getTotalWeight()
    {
	return m_totalWeight;
    }

    /**
     * getTotalWeightTypeCode
     * @return String
     */
    public String getTotalWeightTypeCode()
    {
	return m_totalWeightTypeCode;
    }

    /**
     * getCustomsValueAmount
     * @return double
     */
    public double getCustomsValueAmount()
    {
	return m_customsValueAmount;
    }

    /**
     * getEntryStatusCode
     * @return String
     */
    public String getEntryStatusCode()
    {
	return m_entryStatusCode;
    }

    /**
     * getAirbillTypeCode
     * @return String
     */
    public String getAirbillTypeCode()
    {
	return m_airbillTypeCode;
    }

    /**
     * getDetainmentLocationDescription
     * @return String
     */
    public String getDetainmentLocationDescription()
    {
	return m_detainmentLocationDescription;
    }

    /**
     * getManifestStatusCode
     * @return String
     */
    public String getManifestStatusCode()
    {
	return m_manifestStatusCode;
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
     * getLastModifiedTimeStamp
     * @return Date
     */
    public Date getLastModifiedTimeStamp() {
	return m_lastModifiedTimeStamp;
    }

    /**
     * getLastUserName
     * @return String
     */
    public String getLastUserName() {
	return m_lastUserName;
    }

    /**
     * getEntryCategoryTypeCode
     * @return String
     */
    public String getEntryCategoryTypeCode()
    {
	return m_entryCategoryTypeCode;
    }

    /**
     * getRecurringSelectFlag
     * @retrun String
     */
    public String getRecurringSelectFlag()
    {
	return m_recurringSelectFlag;
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
     * getStagingAreaCode
     * @return String
     */
    public String getStagingAreaCode()
    {
	return m_stagingAreaCode;
    }

    /**
     * getPieceStatusCode
     * @return String
     */
    public String getPieceStatusCode()
    {
	return m_pieceStatusCode;
    }

    /**
     * getLocationCode
     * @return String
     */
    public String getLocationCode()
    {
	return m_locationCode;
    }

    /**
     * getNullCoreClearance
     * @return boolean
     */
    public boolean getNullCoreClearance()
    {
	return m_nullCoreClearance;
    }

    /**
     * getWarehouseCode
     * @return String
     */
    public String getWarehouseCode()
    {
	return m_warehouseCode;
    }

    /**
     * getTravslStatus
     * @return String
     */
    public String getTravelStatus()
    {
    return m_travelStatus;
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
     * isCRN
     * @return boolean
     */
    public boolean isCRN()
    {
	boolean retVal = false;

	if (m_airbillTypeCode.equals("G") || m_airbillTypeCode.equals("6") ||
        m_formTypeCode.equals("0491") || m_formTypeCode.equals("491") ||m_formTypeCode.indexOf("044")==0 )
	{
	    //we have crn
	    retVal = true;
	}

	return retVal;
    }

    /**
     * isCONS
     * @return boolean
     */
    public boolean isCONS()
    {
	boolean retVal = false;

	if (m_airbillTypeCode.equals("3"))
	{
	    retVal = true;
	}

	return retVal;

    }

    /**
     * isAirbill
     * @return boolean
     */
    public boolean isAirbill()
    {
	boolean retVal = false;


	switch (m_airbillTypeCode.charAt(1))
	{
	case '1':
	case '7':
	case '9':
	case 'A':
	case 'D':
	case 'F':
	    retVal = true;
	    break;

	default:
	    //do nothing
	    break;
	}

	return retVal;

    }

    public boolean isMPSMaster(Shipment shipment) {
	// look up the shipment and see if
	//  piece quanity is > 1
	//  and tracking_nbr = awb_nbr

	boolean result = false;

	if ( shipment.getPieceQuanity() > 1 && shipment.getAWBNumber().equals(m_trackingNumber) ) {
	    result = true;
	}

	return result;

    }

    /**
     * setHandlingUnitOidNumber
     * @param int
     */
    public void setHandlingUnitOidNumber(int i)
    {
	if (m_handlingUnitOidNumber == 0)
	{
	    m_handlingUnitOidNumber = i;
	}
    }

    /**
     * setTrackingNumber
     * @param String
     */
    public void setTrackingNumber(String s)
    {
	if(s == null)
	{
	    m_trackingNumber = "";
	}
	else
	{
	    m_trackingNumber = s;
	}
    }

    /**
     * setFormTypeCode
     * @param String
     */
    public void setFormTypeCode(String s)
    {
	if(s == null)
	{
	    m_formTypeCode = "";
	}
	else
	{
	    m_formTypeCode = s;
	}
    }

    /**
     * setHarmonizedTarrifNumber
     * @param String
     */
    private void setHarmonizedTarrifNumber(String s)
    {
	if(s == null)
	{
	    m_harmonizedTariffNumber = "";
	}
	else
	{
	    m_harmonizedTariffNumber = s;
	}
    }

    /**
     * setTotalWeightTypeCode
     * @param String
     */
    private void setTotalWeightTypeCode(String s)
    {
	if(s == null)
	{
	    m_totalWeightTypeCode = "";
	}
	else
	{
	    m_totalWeightTypeCode = s;
	}
    }

    /**
     * setEntryStatusCode
     * @param String
     */
    private void setEntryStatusCode(String s)
    {
	if(s == null)
	{
	    m_entryStatusCode = "";
	}
	else
	{
	    m_entryStatusCode = s;
	}
    }

    /**
     * setAirbillTypeCode
     * @param String
     */
    private void setAirbillTypeCode(String s)
    {
	if(s == null)
	{
	    m_airbillTypeCode = "";
	}
	else
	{
	    m_airbillTypeCode = s;
	}
    }

    /**
     * setLastModifiedTimeStamp
     * @param Date
     */
    public void setLastModifiedTimeStamp(Date d) {
	m_lastModifiedTimeStamp = d;
    }

    /**
     * setLastUserName
     * @param String
     */
    public void setLastUserName(String s) {
	if(s == null)
	{
	    m_lastUserName = "";
	}
	else
	{
	    m_lastUserName = s ;
	}
    }

    /**
     * setDetainmentLocationDescription
     * @param String
     */
    public void setDetainmentLocationDescription(String s) {
	if(s == null)
	{
	    m_detainmentLocationDescription = "";
	}
	else
	{
	    m_detainmentLocationDescription = s;
	}
    }

    /**
     * setEntryCategoryTypeCode
     * @param String
     */
    public void setEntryCategoryTypeCode(String s)
    {
	if(s == null)
	{
	    m_entryCategoryTypeCode = "";
	}
	else
	{
	    m_entryCategoryTypeCode = s;
	}
    }

    /**
     * setRecurringSelectFlag
     * @param String
     */
    public void setRecurringSelectFlag(String s)
    {
	if(s == null)
	{
	    m_recurringSelectFlag = "";
	}
	else
	{
	    m_recurringSelectFlag = s;
	}
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
     * setStagingAreaCode
     * @param String
     */
    public void setStagingAreaCode(String s)
    {
	if(s == null)
	{
	    m_stagingAreaCode = "";
	}
	else
	{
	    m_stagingAreaCode = s;
	}
    }

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

    /**
     * setPieceStatusCode
     * @param String
     */
    public void setPieceStatusCode(String s)
    {
	if(s == null)
	{
	    m_pieceStatusCode = "";
	}
	else
	{
	    m_pieceStatusCode = s;
	}
    }

    /**
     * setLocationCode
     * @param String
     */
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

    /**
     * setNullCoreClearance
     * @param boolean
     */
    public void setNullCoreClearance(boolean b)
    {
	m_nullCoreClearance = b;
    }

    /**
     * setWarehouseCode
     * @param String
     */
    public void setWarehouseCode(String s)
    {
	if(s == null)
	{
	    m_warehouseCode = "";
	}
	else
	{
	    m_warehouseCode = s;
	}
    }

    /**
     * setTravelStatus
     * @param String
     */
    public void setTravelStatus(String s)
    {
    if(s == null)
    {
        // Default to "I" if not specified
        m_travelStatus = "I";
    }
    else
    {
        m_travelStatus = s;
    }
    }

    /**
     * setShipmentOidNumber
     * @param int 
     */
    public void setShipmentOidNumber(int oidNbr)
    {
        m_shipmentOidNumber = oidNbr;
    }
    
    /**
     * toString
     * @return String
     */
    public String toString()
    {
	String s = "";

	s +=  "HandlingUnit object -- " + "\n";

	s += "handlingUnitOidNumber         : " + m_handlingUnitOidNumber+ "\n";
	s += "trackingNumber                : " + m_trackingNumber+ "\n";
	s += "formTypeCode                  : " + m_formTypeCode+ "\n";
	s += "shipmentOidNumber             : " + m_shipmentOidNumber+ "\n";
	s += "harmonizedTariffNumber        : " + m_harmonizedTariffNumber+ "\n";
	s += "totalWeight                   : " + m_totalWeight+ "\n";
	s += "totalWeightTypeCode           : " + m_totalWeightTypeCode+ "\n";
	s += "customsValueAmount            : " + m_customsValueAmount+ "\n";
	s += "entryStatusCode               : " + m_entryStatusCode+ "\n";
	s += "airbillTypeCode               : " + m_airbillTypeCode+ "\n";
	s += "detainmentLocationDescription : " + m_detainmentLocationDescription+ "\n";
	s += "transactionSequenceTimestamp  : " + m_transactionSequenceTimestamp+ "\n";
	s += "manifestStatusCode            : " + m_manifestStatusCode+ "\n";
	s += "lastModifiedTimeStamp         : " + m_lastModifiedTimeStamp+ "\n";
	s += "lastUserName                  : " + m_lastUserName+ "\n";
	s += "recurringSelectFlag           : " + m_recurringSelectFlag+ "\n";
	s += "overageReasonCode             : " + m_overageReasonCode+ "\n";
	s += "stagingAreaCode               : " + m_stagingAreaCode+ "\n";
	s += "transactionSequenceTimestamp  : " + m_transactionSequenceTimestamp+ "\n";
	s += "locationCode                  : " + m_locationCode + "\n";
	s += "nullCoreClearance             : " + m_nullCoreClearance + "\n";
	s += "warehouseCode                 : " + m_warehouseCode+ "\n";
	s += "destLocationCode              : " + m_destLocationCd + "\n";
	s += "shuttleCode                   : " + m_shuttleCode + "\n";
	s += "travelStatus                  : " + m_travelStatus + "\n";    
	return s;
    }
}
