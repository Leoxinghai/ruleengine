/*************************************************************/
/* Copyright (C) 2004 OSS Nokalva, Inc.  All rights reserved.*/
/*************************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA, INC.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA, INC.
 * THIS FILE MAY NOT BE DISTRIBUTED. */

/* Generated for: Federal Express Worldwide Agreement, Memphis, TN - PJ 9820,21,22; 1Step 9823,24; C 9825,26,27,28,29,30 */
/* Abstract syntax: cciicosmos */
/* ASN.1 Java project: cciicosmos.Cciicosmos */
/* Created: Fri Dec  3 17:04:25 2004 */
/* ASN.1 Pure Java Compiler version: 2.0 */
/* ASN.1 compiler options and file names specified:
 * -output cciicosmos CciiCosmos.asn
 */


package cciicosmos.cosmosasn;

import com.oss.asn1.*;
import com.oss.metadata.*;
import cciicosmos.*;

/**
 * Define the ASN1 Type CosmosMasterGrp from ASN1 Module CosmosAsn.
 * @see Set
 */

public class CosmosMasterGrp extends Set {
    
    /**
     * The default constructor.
     */
    public CosmosMasterGrp()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public CosmosMasterGrp(IA5String airbillTypeCode, IA5String comments, 
		    IA5String deliveryTypeCode, IA5String destinationPostalCd, 
		    IA5String employeeNumber, HandlingCodes handlingCodes, 
		    IA5String halPostalCode, IA5String rampLocation, 
		    IA5String recipientCompany, IA5String recipientName, 
		    IA5String shipperName, IA5String beginFunctionTime, 
		    IA5String scanDate, IA5String endFunctionTime, 
		    IA5String exceptionCode, IA5String airbillNumber, 
		    IA5String scanLocation, IA5String airbillTimeOfScan, 
		    IA5String scanType, IA5String typeService, 
		    IA5String ursaRoutingId, IA5String cpFlag, 
		    IA5String conditionOfPackage, IA5String scanComment, 
		    IA5String recipientPhone, IA5String destinationCountry, 
		    IA5String scanSource, IA5String flightNumber, 
		    IA5String containerId, IA5String consNbr, 
		    IA5String lastPartOrgCode, IA5String freightCheckedFlag, 
		    IA5String conveyanceRouteNbr, IA5String astrayFlag, 
		    IA5String airbillEntryType, IA5String airbillFormCode, 
		    AssocTrackingNumber assocTrackingNumber, 
		    IA5String containerIndicator, IA5String consTypeCode, 
		    IA5String destCityFirstChar, IA5String miniSortFlag, 
		    IA5String packageRoutedFlag, IA5String qualMark, 
		    IA5String zipCityMismatchFlag, IA5String scanningLocation, 
		    IA5String operationalScanFlag, IA5String flightDate, 
		    IA5String comment23, IA5String astraLabelData, 
		    IA5String statMenuCd, IA5String returnAirbillNumber, 
		    IA5String authorizedBy, IA5String consDestination)
    {
	setAirbillTypeCode(airbillTypeCode);
	setComments(comments);
	setDeliveryTypeCode(deliveryTypeCode);
	setDestinationPostalCd(destinationPostalCd);
	setEmployeeNumber(employeeNumber);
	setHandlingCodes(handlingCodes);
	setHalPostalCode(halPostalCode);
	setRampLocation(rampLocation);
	setRecipientCompany(recipientCompany);
	setRecipientName(recipientName);
	setShipperName(shipperName);
	setBeginFunctionTime(beginFunctionTime);
	setScanDate(scanDate);
	setEndFunctionTime(endFunctionTime);
	setExceptionCode(exceptionCode);
	setAirbillNumber(airbillNumber);
	setScanLocation(scanLocation);
	setAirbillTimeOfScan(airbillTimeOfScan);
	setScanType(scanType);
	setTypeService(typeService);
	setUrsaRoutingId(ursaRoutingId);
	setCpFlag(cpFlag);
	setConditionOfPackage(conditionOfPackage);
	setScanComment(scanComment);
	setRecipientPhone(recipientPhone);
	setDestinationCountry(destinationCountry);
	setScanSource(scanSource);
	setFlightNumber(flightNumber);
	setContainerId(containerId);
	setConsNbr(consNbr);
	setLastPartOrgCode(lastPartOrgCode);
	setFreightCheckedFlag(freightCheckedFlag);
	setConveyanceRouteNbr(conveyanceRouteNbr);
	setAstrayFlag(astrayFlag);
	setAirbillEntryType(airbillEntryType);
	setAirbillFormCode(airbillFormCode);
	setAssocTrackingNumber(assocTrackingNumber);
	setContainerIndicator(containerIndicator);
	setConsTypeCode(consTypeCode);
	setDestCityFirstChar(destCityFirstChar);
	setMiniSortFlag(miniSortFlag);
	setPackageRoutedFlag(packageRoutedFlag);
	setQualMark(qualMark);
	setZipCityMismatchFlag(zipCityMismatchFlag);
	setScanningLocation(scanningLocation);
	setOperationalScanFlag(operationalScanFlag);
	setFlightDate(flightDate);
	setComment23(comment23);
	setAstraLabelData(astraLabelData);
	setStatMenuCd(statMenuCd);
	setReturnAirbillNumber(returnAirbillNumber);
	setAuthorizedBy(authorizedBy);
	setConsDestination(consDestination);
    }
    
    public void initComponents()
    {
	mComponents[0] = new IA5String();
	mComponents[1] = new IA5String();
	mComponents[2] = new IA5String();
	mComponents[3] = new IA5String();
	mComponents[4] = new IA5String();
	mComponents[5] = new IA5String();
	mComponents[6] = new IA5String();
	mComponents[7] = new IA5String();
	mComponents[8] = new IA5String();
	mComponents[9] = new IA5String();
	mComponents[10] = new IA5String();
	mComponents[11] = new IA5String();
	mComponents[12] = new IA5String();
	mComponents[13] = new IA5String();
	mComponents[14] = new IA5String();
	mComponents[15] = new IA5String();
	mComponents[16] = new IA5String();
	mComponents[17] = new IA5String();
	mComponents[18] = new IA5String();
	mComponents[19] = new IA5String();
	mComponents[20] = new IA5String();
	mComponents[21] = new IA5String();
	mComponents[22] = new IA5String();
	mComponents[23] = new IA5String();
	mComponents[24] = new IA5String();
	mComponents[25] = new IA5String();
	mComponents[26] = new IA5String();
	mComponents[27] = new IA5String();
	mComponents[28] = new IA5String();
	mComponents[29] = new IA5String();
	mComponents[30] = new IA5String();
	mComponents[31] = new IA5String();
	mComponents[32] = new IA5String();
	mComponents[33] = new IA5String();
	mComponents[34] = new IA5String();
	mComponents[35] = new AssocTrackingNumber();
	mComponents[36] = new IA5String();
	mComponents[37] = new IA5String();
	mComponents[38] = new IA5String();
	mComponents[39] = new IA5String();
	mComponents[40] = new IA5String();
	mComponents[41] = new IA5String();
	mComponents[42] = new IA5String();
	mComponents[43] = new IA5String();
	mComponents[44] = new IA5String();
	mComponents[45] = new IA5String();
	mComponents[46] = new IA5String();
	mComponents[47] = new IA5String();
	mComponents[48] = new IA5String();
	mComponents[49] = new IA5String();
	mComponents[50] = new IA5String();
	mComponents[51] = new IA5String();
	mComponents[52] = new HandlingCodes();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[53];
    }
    
    
    // Methods for field "airbillTypeCode"
    public IA5String getAirbillTypeCode()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setAirbillTypeCode(IA5String airbillTypeCode)
    {
	mComponents[0] = airbillTypeCode;
    }
    
    public boolean hasAirbillTypeCode()
    {
	return componentIsPresent(0);
    }
    
    public void deleteAirbillTypeCode()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "comments"
    public IA5String getComments()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setComments(IA5String comments)
    {
	mComponents[1] = comments;
    }
    
    public boolean hasComments()
    {
	return componentIsPresent(1);
    }
    
    public void deleteComments()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "deliveryTypeCode"
    public IA5String getDeliveryTypeCode()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setDeliveryTypeCode(IA5String deliveryTypeCode)
    {
	mComponents[2] = deliveryTypeCode;
    }
    
    public boolean hasDeliveryTypeCode()
    {
	return componentIsPresent(2);
    }
    
    public void deleteDeliveryTypeCode()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "destinationPostalCd"
    public IA5String getDestinationPostalCd()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setDestinationPostalCd(IA5String destinationPostalCd)
    {
	mComponents[3] = destinationPostalCd;
    }
    
    public boolean hasDestinationPostalCd()
    {
	return componentIsPresent(3);
    }
    
    public void deleteDestinationPostalCd()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "employeeNumber"
    public IA5String getEmployeeNumber()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setEmployeeNumber(IA5String employeeNumber)
    {
	mComponents[4] = employeeNumber;
    }
    
    public boolean hasEmployeeNumber()
    {
	return componentIsPresent(4);
    }
    
    public void deleteEmployeeNumber()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "halPostalCode"
    public IA5String getHalPostalCode()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setHalPostalCode(IA5String halPostalCode)
    {
	mComponents[5] = halPostalCode;
    }
    
    public boolean hasHalPostalCode()
    {
	return componentIsPresent(5);
    }
    
    public void deleteHalPostalCode()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "rampLocation"
    public IA5String getRampLocation()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setRampLocation(IA5String rampLocation)
    {
	mComponents[6] = rampLocation;
    }
    
    public boolean hasRampLocation()
    {
	return componentIsPresent(6);
    }
    
    public void deleteRampLocation()
    {
	setComponentAbsent(6);
    }
    
    
    // Methods for field "recipientCompany"
    public IA5String getRecipientCompany()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setRecipientCompany(IA5String recipientCompany)
    {
	mComponents[7] = recipientCompany;
    }
    
    public boolean hasRecipientCompany()
    {
	return componentIsPresent(7);
    }
    
    public void deleteRecipientCompany()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "recipientName"
    public IA5String getRecipientName()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setRecipientName(IA5String recipientName)
    {
	mComponents[8] = recipientName;
    }
    
    public boolean hasRecipientName()
    {
	return componentIsPresent(8);
    }
    
    public void deleteRecipientName()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "shipperName"
    public IA5String getShipperName()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setShipperName(IA5String shipperName)
    {
	mComponents[9] = shipperName;
    }
    
    public boolean hasShipperName()
    {
	return componentIsPresent(9);
    }
    
    public void deleteShipperName()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "beginFunctionTime"
    public IA5String getBeginFunctionTime()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setBeginFunctionTime(IA5String beginFunctionTime)
    {
	mComponents[10] = beginFunctionTime;
    }
    
    public boolean hasBeginFunctionTime()
    {
	return componentIsPresent(10);
    }
    
    public void deleteBeginFunctionTime()
    {
	setComponentAbsent(10);
    }
    
    
    // Methods for field "scanDate"
    public IA5String getScanDate()
    {
	return (IA5String)mComponents[11];
    }
    
    public void setScanDate(IA5String scanDate)
    {
	mComponents[11] = scanDate;
    }
    
    public boolean hasScanDate()
    {
	return componentIsPresent(11);
    }
    
    public void deleteScanDate()
    {
	setComponentAbsent(11);
    }
    
    
    // Methods for field "endFunctionTime"
    public IA5String getEndFunctionTime()
    {
	return (IA5String)mComponents[12];
    }
    
    public void setEndFunctionTime(IA5String endFunctionTime)
    {
	mComponents[12] = endFunctionTime;
    }
    
    public boolean hasEndFunctionTime()
    {
	return componentIsPresent(12);
    }
    
    public void deleteEndFunctionTime()
    {
	setComponentAbsent(12);
    }
    
    
    // Methods for field "exceptionCode"
    public IA5String getExceptionCode()
    {
	return (IA5String)mComponents[13];
    }
    
    public void setExceptionCode(IA5String exceptionCode)
    {
	mComponents[13] = exceptionCode;
    }
    
    public boolean hasExceptionCode()
    {
	return componentIsPresent(13);
    }
    
    public void deleteExceptionCode()
    {
	setComponentAbsent(13);
    }
    
    
    // Methods for field "airbillNumber"
    public IA5String getAirbillNumber()
    {
	return (IA5String)mComponents[14];
    }
    
    public void setAirbillNumber(IA5String airbillNumber)
    {
	mComponents[14] = airbillNumber;
    }
    
    public boolean hasAirbillNumber()
    {
	return componentIsPresent(14);
    }
    
    public void deleteAirbillNumber()
    {
	setComponentAbsent(14);
    }
    
    
    // Methods for field "scanLocation"
    public IA5String getScanLocation()
    {
	return (IA5String)mComponents[15];
    }
    
    public void setScanLocation(IA5String scanLocation)
    {
	mComponents[15] = scanLocation;
    }
    
    public boolean hasScanLocation()
    {
	return componentIsPresent(15);
    }
    
    public void deleteScanLocation()
    {
	setComponentAbsent(15);
    }
    
    
    // Methods for field "airbillTimeOfScan"
    public IA5String getAirbillTimeOfScan()
    {
	return (IA5String)mComponents[16];
    }
    
    public void setAirbillTimeOfScan(IA5String airbillTimeOfScan)
    {
	mComponents[16] = airbillTimeOfScan;
    }
    
    public boolean hasAirbillTimeOfScan()
    {
	return componentIsPresent(16);
    }
    
    public void deleteAirbillTimeOfScan()
    {
	setComponentAbsent(16);
    }
    
    
    // Methods for field "scanType"
    public IA5String getScanType()
    {
	return (IA5String)mComponents[17];
    }
    
    public void setScanType(IA5String scanType)
    {
	mComponents[17] = scanType;
    }
    
    public boolean hasScanType()
    {
	return componentIsPresent(17);
    }
    
    public void deleteScanType()
    {
	setComponentAbsent(17);
    }
    
    
    // Methods for field "typeService"
    public IA5String getTypeService()
    {
	return (IA5String)mComponents[18];
    }
    
    public void setTypeService(IA5String typeService)
    {
	mComponents[18] = typeService;
    }
    
    public boolean hasTypeService()
    {
	return componentIsPresent(18);
    }
    
    public void deleteTypeService()
    {
	setComponentAbsent(18);
    }
    
    
    // Methods for field "ursaRoutingId"
    public IA5String getUrsaRoutingId()
    {
	return (IA5String)mComponents[19];
    }
    
    public void setUrsaRoutingId(IA5String ursaRoutingId)
    {
	mComponents[19] = ursaRoutingId;
    }
    
    public boolean hasUrsaRoutingId()
    {
	return componentIsPresent(19);
    }
    
    public void deleteUrsaRoutingId()
    {
	setComponentAbsent(19);
    }
    
    
    // Methods for field "cpFlag"
    public IA5String getCpFlag()
    {
	return (IA5String)mComponents[20];
    }
    
    public void setCpFlag(IA5String cpFlag)
    {
	mComponents[20] = cpFlag;
    }
    
    public boolean hasCpFlag()
    {
	return componentIsPresent(20);
    }
    
    public void deleteCpFlag()
    {
	setComponentAbsent(20);
    }
    
    
    // Methods for field "conditionOfPackage"
    public IA5String getConditionOfPackage()
    {
	return (IA5String)mComponents[21];
    }
    
    public void setConditionOfPackage(IA5String conditionOfPackage)
    {
	mComponents[21] = conditionOfPackage;
    }
    
    public boolean hasConditionOfPackage()
    {
	return componentIsPresent(21);
    }
    
    public void deleteConditionOfPackage()
    {
	setComponentAbsent(21);
    }
    
    
    // Methods for field "scanComment"
    public IA5String getScanComment()
    {
	return (IA5String)mComponents[22];
    }
    
    public void setScanComment(IA5String scanComment)
    {
	mComponents[22] = scanComment;
    }
    
    public boolean hasScanComment()
    {
	return componentIsPresent(22);
    }
    
    public void deleteScanComment()
    {
	setComponentAbsent(22);
    }
    
    
    // Methods for field "recipientPhone"
    public IA5String getRecipientPhone()
    {
	return (IA5String)mComponents[23];
    }
    
    public void setRecipientPhone(IA5String recipientPhone)
    {
	mComponents[23] = recipientPhone;
    }
    
    public boolean hasRecipientPhone()
    {
	return componentIsPresent(23);
    }
    
    public void deleteRecipientPhone()
    {
	setComponentAbsent(23);
    }
    
    
    // Methods for field "destinationCountry"
    public IA5String getDestinationCountry()
    {
	return (IA5String)mComponents[24];
    }
    
    public void setDestinationCountry(IA5String destinationCountry)
    {
	mComponents[24] = destinationCountry;
    }
    
    public boolean hasDestinationCountry()
    {
	return componentIsPresent(24);
    }
    
    public void deleteDestinationCountry()
    {
	setComponentAbsent(24);
    }
    
    
    // Methods for field "scanSource"
    public IA5String getScanSource()
    {
	return (IA5String)mComponents[25];
    }
    
    public void setScanSource(IA5String scanSource)
    {
	mComponents[25] = scanSource;
    }
    
    public boolean hasScanSource()
    {
	return componentIsPresent(25);
    }
    
    public void deleteScanSource()
    {
	setComponentAbsent(25);
    }
    
    
    // Methods for field "flightNumber"
    public IA5String getFlightNumber()
    {
	return (IA5String)mComponents[26];
    }
    
    public void setFlightNumber(IA5String flightNumber)
    {
	mComponents[26] = flightNumber;
    }
    
    public boolean hasFlightNumber()
    {
	return componentIsPresent(26);
    }
    
    public void deleteFlightNumber()
    {
	setComponentAbsent(26);
    }
    
    
    // Methods for field "containerId"
    public IA5String getContainerId()
    {
	return (IA5String)mComponents[27];
    }
    
    public void setContainerId(IA5String containerId)
    {
	mComponents[27] = containerId;
    }
    
    public boolean hasContainerId()
    {
	return componentIsPresent(27);
    }
    
    public void deleteContainerId()
    {
	setComponentAbsent(27);
    }
    
    
    // Methods for field "consNbr"
    public IA5String getConsNbr()
    {
	return (IA5String)mComponents[28];
    }
    
    public void setConsNbr(IA5String consNbr)
    {
	mComponents[28] = consNbr;
    }
    
    public boolean hasConsNbr()
    {
	return componentIsPresent(28);
    }
    
    public void deleteConsNbr()
    {
	setComponentAbsent(28);
    }
    
    
    // Methods for field "lastPartOrgCode"
    public IA5String getLastPartOrgCode()
    {
	return (IA5String)mComponents[29];
    }
    
    public void setLastPartOrgCode(IA5String lastPartOrgCode)
    {
	mComponents[29] = lastPartOrgCode;
    }
    
    public boolean hasLastPartOrgCode()
    {
	return componentIsPresent(29);
    }
    
    public void deleteLastPartOrgCode()
    {
	setComponentAbsent(29);
    }
    
    
    // Methods for field "freightCheckedFlag"
    public IA5String getFreightCheckedFlag()
    {
	return (IA5String)mComponents[30];
    }
    
    public void setFreightCheckedFlag(IA5String freightCheckedFlag)
    {
	mComponents[30] = freightCheckedFlag;
    }
    
    public boolean hasFreightCheckedFlag()
    {
	return componentIsPresent(30);
    }
    
    public void deleteFreightCheckedFlag()
    {
	setComponentAbsent(30);
    }
    
    
    // Methods for field "conveyanceRouteNbr"
    public IA5String getConveyanceRouteNbr()
    {
	return (IA5String)mComponents[31];
    }
    
    public void setConveyanceRouteNbr(IA5String conveyanceRouteNbr)
    {
	mComponents[31] = conveyanceRouteNbr;
    }
    
    public boolean hasConveyanceRouteNbr()
    {
	return componentIsPresent(31);
    }
    
    public void deleteConveyanceRouteNbr()
    {
	setComponentAbsent(31);
    }
    
    
    // Methods for field "astrayFlag"
    public IA5String getAstrayFlag()
    {
	return (IA5String)mComponents[32];
    }
    
    public void setAstrayFlag(IA5String astrayFlag)
    {
	mComponents[32] = astrayFlag;
    }
    
    public boolean hasAstrayFlag()
    {
	return componentIsPresent(32);
    }
    
    public void deleteAstrayFlag()
    {
	setComponentAbsent(32);
    }
    
    
    // Methods for field "airbillEntryType"
    public IA5String getAirbillEntryType()
    {
	return (IA5String)mComponents[33];
    }
    
    public void setAirbillEntryType(IA5String airbillEntryType)
    {
	mComponents[33] = airbillEntryType;
    }
    
    public boolean hasAirbillEntryType()
    {
	return componentIsPresent(33);
    }
    
    public void deleteAirbillEntryType()
    {
	setComponentAbsent(33);
    }
    
    
    // Methods for field "airbillFormCode"
    public IA5String getAirbillFormCode()
    {
	return (IA5String)mComponents[34];
    }
    
    public void setAirbillFormCode(IA5String airbillFormCode)
    {
	mComponents[34] = airbillFormCode;
    }
    
    public boolean hasAirbillFormCode()
    {
	return componentIsPresent(34);
    }
    
    public void deleteAirbillFormCode()
    {
	setComponentAbsent(34);
    }
    
    
    // Methods for field "assocTrackingNumber"
    public AssocTrackingNumber getAssocTrackingNumber()
    {
	return (AssocTrackingNumber)mComponents[35];
    }
    
    public void setAssocTrackingNumber(AssocTrackingNumber assocTrackingNumber)
    {
	mComponents[35] = assocTrackingNumber;
    }
    
    public boolean hasAssocTrackingNumber()
    {
	return componentIsPresent(35);
    }
    
    public void deleteAssocTrackingNumber()
    {
	setComponentAbsent(35);
    }
    
    
    
    /**
     * Define the ASN1 Type AssocTrackingNumber from ASN1 Module CosmosAsn.
     * @see SetOf
     */
    public static class AssocTrackingNumber extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public AssocTrackingNumber()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public AssocTrackingNumber(CosmosTrackingNumberGrp[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(CosmosTrackingNumberGrp element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(CosmosTrackingNumberGrp element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized CosmosTrackingNumberGrp get(int atIndex)
	{
	    return (CosmosTrackingNumberGrp)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(CosmosTrackingNumberGrp element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(CosmosTrackingNumberGrp element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new CosmosTrackingNumberGrp();
	}
	
	/**
	 * Initialize the type descriptor.
	 */
	private static final ContainerInfo c_typeinfo = new ContainerInfo (
	    new Tags (
		new short[] {
		    (short)0x80d7
		}
	    ),
	    new QName (
		"cciicosmos.cosmosasn",
		"CosmosMasterGrp$AssocTrackingNumber"
	    ),
	    new QName (
		"builtin",
		"SET OF"
	    ),
	    18,
	    new SizeConstraint (
		new ValueRangeConstraint (
		    new AbstractBounds(
			new com.oss.asn1.INTEGER(0), 
			new com.oss.asn1.INTEGER(12),
			0
		    )
		)
	    ),
	    new Bounds (
		new Long(0),
		new Long(12)
	    ),
	    new TypeInfoRef (
		new QName (
		    "cciicosmos.cosmosasn",
		    "CosmosTrackingNumberGrp"
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' AssocTrackingNumber object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' AssocTrackingNumber object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for AssocTrackingNumber

    // Methods for field "containerIndicator"
    public IA5String getContainerIndicator()
    {
	return (IA5String)mComponents[36];
    }
    
    public void setContainerIndicator(IA5String containerIndicator)
    {
	mComponents[36] = containerIndicator;
    }
    
    public boolean hasContainerIndicator()
    {
	return componentIsPresent(36);
    }
    
    public void deleteContainerIndicator()
    {
	setComponentAbsent(36);
    }
    
    
    // Methods for field "consTypeCode"
    public IA5String getConsTypeCode()
    {
	return (IA5String)mComponents[37];
    }
    
    public void setConsTypeCode(IA5String consTypeCode)
    {
	mComponents[37] = consTypeCode;
    }
    
    public boolean hasConsTypeCode()
    {
	return componentIsPresent(37);
    }
    
    public void deleteConsTypeCode()
    {
	setComponentAbsent(37);
    }
    
    
    // Methods for field "destCityFirstChar"
    public IA5String getDestCityFirstChar()
    {
	return (IA5String)mComponents[38];
    }
    
    public void setDestCityFirstChar(IA5String destCityFirstChar)
    {
	mComponents[38] = destCityFirstChar;
    }
    
    public boolean hasDestCityFirstChar()
    {
	return componentIsPresent(38);
    }
    
    public void deleteDestCityFirstChar()
    {
	setComponentAbsent(38);
    }
    
    
    // Methods for field "miniSortFlag"
    public IA5String getMiniSortFlag()
    {
	return (IA5String)mComponents[39];
    }
    
    public void setMiniSortFlag(IA5String miniSortFlag)
    {
	mComponents[39] = miniSortFlag;
    }
    
    public boolean hasMiniSortFlag()
    {
	return componentIsPresent(39);
    }
    
    public void deleteMiniSortFlag()
    {
	setComponentAbsent(39);
    }
    
    
    // Methods for field "packageRoutedFlag"
    public IA5String getPackageRoutedFlag()
    {
	return (IA5String)mComponents[40];
    }
    
    public void setPackageRoutedFlag(IA5String packageRoutedFlag)
    {
	mComponents[40] = packageRoutedFlag;
    }
    
    public boolean hasPackageRoutedFlag()
    {
	return componentIsPresent(40);
    }
    
    public void deletePackageRoutedFlag()
    {
	setComponentAbsent(40);
    }
    
    
    // Methods for field "qualMark"
    public IA5String getQualMark()
    {
	return (IA5String)mComponents[41];
    }
    
    public void setQualMark(IA5String qualMark)
    {
	mComponents[41] = qualMark;
    }
    
    public boolean hasQualMark()
    {
	return componentIsPresent(41);
    }
    
    public void deleteQualMark()
    {
	setComponentAbsent(41);
    }
    
    
    // Methods for field "zipCityMismatchFlag"
    public IA5String getZipCityMismatchFlag()
    {
	return (IA5String)mComponents[42];
    }
    
    public void setZipCityMismatchFlag(IA5String zipCityMismatchFlag)
    {
	mComponents[42] = zipCityMismatchFlag;
    }
    
    public boolean hasZipCityMismatchFlag()
    {
	return componentIsPresent(42);
    }
    
    public void deleteZipCityMismatchFlag()
    {
	setComponentAbsent(42);
    }
    
    
    // Methods for field "scanningLocation"
    public IA5String getScanningLocation()
    {
	return (IA5String)mComponents[43];
    }
    
    public void setScanningLocation(IA5String scanningLocation)
    {
	mComponents[43] = scanningLocation;
    }
    
    public boolean hasScanningLocation()
    {
	return componentIsPresent(43);
    }
    
    public void deleteScanningLocation()
    {
	setComponentAbsent(43);
    }
    
    
    // Methods for field "operationalScanFlag"
    public IA5String getOperationalScanFlag()
    {
	return (IA5String)mComponents[44];
    }
    
    public void setOperationalScanFlag(IA5String operationalScanFlag)
    {
	mComponents[44] = operationalScanFlag;
    }
    
    public boolean hasOperationalScanFlag()
    {
	return componentIsPresent(44);
    }
    
    public void deleteOperationalScanFlag()
    {
	setComponentAbsent(44);
    }
    
    
    // Methods for field "flightDate"
    public IA5String getFlightDate()
    {
	return (IA5String)mComponents[45];
    }
    
    public void setFlightDate(IA5String flightDate)
    {
	mComponents[45] = flightDate;
    }
    
    public boolean hasFlightDate()
    {
	return componentIsPresent(45);
    }
    
    public void deleteFlightDate()
    {
	setComponentAbsent(45);
    }
    
    
    // Methods for field "comment23"
    public IA5String getComment23()
    {
	return (IA5String)mComponents[46];
    }
    
    public void setComment23(IA5String comment23)
    {
	mComponents[46] = comment23;
    }
    
    public boolean hasComment23()
    {
	return componentIsPresent(46);
    }
    
    public void deleteComment23()
    {
	setComponentAbsent(46);
    }
    
    
    // Methods for field "astraLabelData"
    public IA5String getAstraLabelData()
    {
	return (IA5String)mComponents[47];
    }
    
    public void setAstraLabelData(IA5String astraLabelData)
    {
	mComponents[47] = astraLabelData;
    }
    
    public boolean hasAstraLabelData()
    {
	return componentIsPresent(47);
    }
    
    public void deleteAstraLabelData()
    {
	setComponentAbsent(47);
    }
    
    
    // Methods for field "statMenuCd"
    public IA5String getStatMenuCd()
    {
	return (IA5String)mComponents[48];
    }
    
    public void setStatMenuCd(IA5String statMenuCd)
    {
	mComponents[48] = statMenuCd;
    }
    
    public boolean hasStatMenuCd()
    {
	return componentIsPresent(48);
    }
    
    public void deleteStatMenuCd()
    {
	setComponentAbsent(48);
    }
    
    
    // Methods for field "returnAirbillNumber"
    public IA5String getReturnAirbillNumber()
    {
	return (IA5String)mComponents[49];
    }
    
    public void setReturnAirbillNumber(IA5String returnAirbillNumber)
    {
	mComponents[49] = returnAirbillNumber;
    }
    
    public boolean hasReturnAirbillNumber()
    {
	return componentIsPresent(49);
    }
    
    public void deleteReturnAirbillNumber()
    {
	setComponentAbsent(49);
    }
    
    
    // Methods for field "authorizedBy"
    public IA5String getAuthorizedBy()
    {
	return (IA5String)mComponents[50];
    }
    
    public void setAuthorizedBy(IA5String authorizedBy)
    {
	mComponents[50] = authorizedBy;
    }
    
    public boolean hasAuthorizedBy()
    {
	return componentIsPresent(50);
    }
    
    public void deleteAuthorizedBy()
    {
	setComponentAbsent(50);
    }
    
    
    // Methods for field "consDestination"
    public IA5String getConsDestination()
    {
	return (IA5String)mComponents[51];
    }
    
    public void setConsDestination(IA5String consDestination)
    {
	mComponents[51] = consDestination;
    }
    
    public boolean hasConsDestination()
    {
	return componentIsPresent(51);
    }
    
    public void deleteConsDestination()
    {
	setComponentAbsent(51);
    }
    
    
    // Methods for field "handlingCodes"
    public HandlingCodes getHandlingCodes()
    {
	return (HandlingCodes)mComponents[52];
    }
    
    public void setHandlingCodes(HandlingCodes handlingCodes)
    {
	mComponents[52] = handlingCodes;
    }
    
    public boolean hasHandlingCodes()
    {
	return componentIsPresent(52);
    }
    
    public void deleteHandlingCodes()
    {
	setComponentAbsent(52);
    }
    
    
    
    /**
     * Define the ASN1 Type HandlingCodes from ASN1 Module CosmosAsn.
     * @see SetOf
     */
    public static class HandlingCodes extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public HandlingCodes()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public HandlingCodes(IA5String[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(IA5String element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(IA5String element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized IA5String get(int atIndex)
	{
	    return (IA5String)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(IA5String element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(IA5String element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new IA5String();
	}
	
	/**
	 * Initialize the type descriptor.
	 */
	private static final ContainerInfo c_typeinfo = new ContainerInfo (
	    new Tags (
		new short[] {
		    (short)0x83c8
		}
	    ),
	    new QName (
		"cciicosmos.cosmosasn",
		"CosmosMasterGrp$HandlingCodes"
	    ),
	    new QName (
		"builtin",
		"SET OF"
	    ),
	    18,
	    new SizeConstraint (
		new ValueRangeConstraint (
		    new AbstractBounds(
			new com.oss.asn1.INTEGER(0), 
			new com.oss.asn1.INTEGER(13),
			0
		    )
		)
	    ),
	    new Bounds (
		new Long(0),
		new Long(13)
	    ),
	    new TypeInfoRef (
		new KMCStringInfo (
		    new Tags (
			new short[] {
			    0x0016
			}
		    ),
		    new QName (
			"com.oss.asn1",
			"IA5String"
		    ),
		    new QName (
			"builtin",
			"IA5String"
		    ),
		    18,
		    new Intersection (
			new SizeConstraint (
			    new ValueRangeConstraint (
				new AbstractBounds(
				    new com.oss.asn1.INTEGER(0), 
				    new com.oss.asn1.INTEGER(2),
				    0
				)
			    )
			),
			new PermittedAlphabetConstraint (
			    IA5StringPAInfo.pa
			)
		    ),
		    new Bounds (
			new Long(0),
			new Long(2)
		    ),
		    IA5StringPAInfo.paInfo
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' HandlingCodes object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' HandlingCodes object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for HandlingCodes

    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		0x4002
	    }
	),
	new QName (
	    "cciicosmos.cosmosasn",
	    "CosmosMasterGrp"
	),
	new QName (
	    "CosmosAsn",
	    "CosmosMasterGrp"
	),
	22,
	null,
	new Fields (
	    new SequenceFieldInfo[] {
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8002
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillTypeCode",
		    0,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8005
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(30),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(30)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "comments",
		    1,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8006
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(2),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(2)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "deliveryTypeCode",
		    2,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800c
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(9),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(9)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "destinationPostalCd",
		    3,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800e
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(6),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "employeeNumber",
		    4,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8011
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(8),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(8)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "halPostalCode",
		    5,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8019
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "rampLocation",
		    6,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801e
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(25),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(25)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "recipientCompany",
		    7,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801f
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(25),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(25)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "recipientName",
		    8,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8020
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(25),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(25)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "shipperName",
		    9,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8022
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(4),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(4)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "beginFunctionTime",
		    10,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8023
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanDate",
		    11,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8024
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "endFunctionTime",
		    12,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8025
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(2),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(2)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "exceptionCode",
		    13,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8026
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(12),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(12)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillNumber",
		    14,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8027
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanLocation",
		    15,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8028
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(4),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(4)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillTimeOfScan",
		    16,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8029
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(2),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(2)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanType",
		    17,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x802a
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(2),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(2)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "typeService",
		    18,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x802b
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(8),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(8)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "ursaRoutingId",
		    19,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x802d
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cpFlag",
		    20,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8035
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "conditionOfPackage",
		    21,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x803e
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(30),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(30)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanComment",
		    22,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x804d
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(10),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(10)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "recipientPhone",
		    23,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8062
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(2),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(2)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "destinationCountry",
		    24,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8067
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanSource",
		    25,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x807d
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(10),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(10)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "flightNumber",
		    26,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x808d
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(10),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(10)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "containerId",
		    27,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8096
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(12),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(12)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "consNbr",
		    28,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80b7
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "lastPartOrgCode",
		    29,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80b8
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "freightCheckedFlag",
		    30,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80ba
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(6),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "conveyanceRouteNbr",
		    31,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80bc
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "astrayFlag",
		    32,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80d3
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillEntryType",
		    33,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80d4
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(4),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(4)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillFormCode",
		    34,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "cciicosmos.cosmosasn",
			    "CosmosMasterGrp$AssocTrackingNumber"
			)
		    ),
		    "assocTrackingNumber",
		    35,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80de
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "containerIndicator",
		    36,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80df
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "consTypeCode",
		    37,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80eb
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "destCityFirstChar",
		    38,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x810c
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "miniSortFlag",
		    39,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8115
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "packageRoutedFlag",
		    40,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8117
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "qualMark",
		    41,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x811f
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "zipCityMismatchFlag",
		    42,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8123
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "scanningLocation",
		    43,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x812e
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "operationalScanFlag",
		    44,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8136
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(4),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(4)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "flightDate",
		    45,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8164
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "comment23",
		    46,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8165
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(16),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(16)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "astraLabelData",
		    47,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8226
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(1),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(1)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "statMenuCd",
		    48,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x825b
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(12),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(12)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "returnAirbillNumber",
		    49,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x825c
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(30),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(30)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "authorizedBy",
		    50,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8277
				}
			    ),
			    new QName (
				"com.oss.asn1",
				"IA5String"
			    ),
			    new QName (
				"builtin",
				"IA5String"
			    ),
			    18,
			    new Intersection (
				new SizeConstraint (
				    new ValueRangeConstraint (
					new AbstractBounds(
					    new com.oss.asn1.INTEGER(0), 
					    new com.oss.asn1.INTEGER(5),
					    0
					)
				    )
				),
				new PermittedAlphabetConstraint (
				    IA5StringPAInfo.pa
				)
			    ),
			    new Bounds (
				new Long(0),
				new Long(5)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "consDestination",
		    51,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "cciicosmos.cosmosasn",
			    "CosmosMasterGrp$HandlingCodes"
			)
		    ),
		    "handlingCodes",
		    52,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8002, 0),
		new TagDecoderElement((short)0x8005, 1),
		new TagDecoderElement((short)0x8006, 2),
		new TagDecoderElement((short)0x800c, 3),
		new TagDecoderElement((short)0x800e, 4),
		new TagDecoderElement((short)0x8011, 5),
		new TagDecoderElement((short)0x8019, 6),
		new TagDecoderElement((short)0x801e, 7),
		new TagDecoderElement((short)0x801f, 8),
		new TagDecoderElement((short)0x8020, 9),
		new TagDecoderElement((short)0x8022, 10),
		new TagDecoderElement((short)0x8023, 11),
		new TagDecoderElement((short)0x8024, 12),
		new TagDecoderElement((short)0x8025, 13),
		new TagDecoderElement((short)0x8026, 14),
		new TagDecoderElement((short)0x8027, 15),
		new TagDecoderElement((short)0x8028, 16),
		new TagDecoderElement((short)0x8029, 17),
		new TagDecoderElement((short)0x802a, 18),
		new TagDecoderElement((short)0x802b, 19),
		new TagDecoderElement((short)0x802d, 20),
		new TagDecoderElement((short)0x8035, 21),
		new TagDecoderElement((short)0x803e, 22),
		new TagDecoderElement((short)0x804d, 23),
		new TagDecoderElement((short)0x8062, 24),
		new TagDecoderElement((short)0x8067, 25),
		new TagDecoderElement((short)0x807d, 26),
		new TagDecoderElement((short)0x808d, 27),
		new TagDecoderElement((short)0x8096, 28),
		new TagDecoderElement((short)0x80b7, 29),
		new TagDecoderElement((short)0x80b8, 30),
		new TagDecoderElement((short)0x80ba, 31),
		new TagDecoderElement((short)0x80bc, 32),
		new TagDecoderElement((short)0x80d3, 33),
		new TagDecoderElement((short)0x80d4, 34),
		new TagDecoderElement((short)0x80d7, 35),
		new TagDecoderElement((short)0x80de, 36),
		new TagDecoderElement((short)0x80df, 37),
		new TagDecoderElement((short)0x80eb, 38),
		new TagDecoderElement((short)0x810c, 39),
		new TagDecoderElement((short)0x8115, 40),
		new TagDecoderElement((short)0x8117, 41),
		new TagDecoderElement((short)0x811f, 42),
		new TagDecoderElement((short)0x8123, 43),
		new TagDecoderElement((short)0x812e, 44),
		new TagDecoderElement((short)0x8136, 45),
		new TagDecoderElement((short)0x8164, 46),
		new TagDecoderElement((short)0x8165, 47),
		new TagDecoderElement((short)0x8226, 48),
		new TagDecoderElement((short)0x825b, 49),
		new TagDecoderElement((short)0x825c, 50),
		new TagDecoderElement((short)0x8277, 51),
		new TagDecoderElement((short)0x83c8, 52)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' CosmosMasterGrp object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' CosmosMasterGrp object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * The type is a PDU.
     */
    public boolean isPDU()
    {
	return true;
    }
    
} // End class definition for CosmosMasterGrp
