/********************************************************/
/* Copyright (C) 2004 OSS Nokalva.  All rights reserved.*/
/********************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA.
 * THIS FILE MAY NOT BE DISTRIBUTED. */

/* Generated for: FedEx Services - Colorado Springs, Colorado - license 8640 for Solaris Pure Java */
/* Abstract syntax: requestasn */
/* ASN.1 Java project: imageRequestASN.Imagerequestasn */
/* Created: Tue May 25 09:40:57 2004 */
/* ASN.1 Pure Java Compiler version: pre1.4 */
/* ASN.1 compiler options and file names specified:
 * -output imageRequestASN requestASN.asn
 */


package imageRequestASN.ddtran;

import com.oss.asn1.*;
import com.oss.metadata.*;
import imageRequestASN.*;

/**
 * Define the ASN1 Type ASNrequest from ASN1 Module DDTRAN.
 * @see Set
 */

public class ASNrequest extends Set {
    
    /**
     * The default constructor.
     */
    public ASNrequest()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public ASNrequest(IA5String cddFunctionCode, 
		    IA5String cddFunctionTypeCode, IA5String cddAirbillNumber, 
		    IA5String cddAwbSerialNumber, IA5String cddRequestTime, 
		    IA5String cddClearanceLocCode, IA5String cddOriginLoc, 
		    IA5String cddDestinationLoc, IA5String cddShipDate, 
		    IA5String cddSelectCode, IA5String cddSelectionSource, 
		    IA5String cddAgencyCode, IA5String cddSelectionTimeStamp, 
		    IA5String cddEntryType, IA5String cddEmployeeNbr, 
		    IA5String cddReceiver, IA5String cddShipperName, 
		    IA5String cddShipperAccountNumber, 
		    IA5String cddConsigneeName, IA5String cddConsigneeAcctNbr, 
		    IA5String cddRouteNumber, IA5String cddRouteDate, 
		    IA5String cddArrivalWorkDate, 
		    IA5String cddLocalTotalCustAmt, 
		    IA5String cddCountryOfOrigin, IA5String cddServiceType, 
		    IA5String cddHiValLoVal, IA5String cddShipperCompanyNm, 
		    IA5String cddConsigneeCompanyNm, IA5String cddSdlFlg, 
		    CddSpclHandlingCds cddSpclHandlingCds)
    {
	setCddFunctionCode(cddFunctionCode);
	setCddFunctionTypeCode(cddFunctionTypeCode);
	setCddAirbillNumber(cddAirbillNumber);
	setCddAwbSerialNumber(cddAwbSerialNumber);
	setCddRequestTime(cddRequestTime);
	setCddClearanceLocCode(cddClearanceLocCode);
	setCddOriginLoc(cddOriginLoc);
	setCddDestinationLoc(cddDestinationLoc);
	setCddShipDate(cddShipDate);
	setCddSelectCode(cddSelectCode);
	setCddSelectionSource(cddSelectionSource);
	setCddAgencyCode(cddAgencyCode);
	setCddSelectionTimeStamp(cddSelectionTimeStamp);
	setCddEntryType(cddEntryType);
	setCddEmployeeNbr(cddEmployeeNbr);
	setCddReceiver(cddReceiver);
	setCddShipperName(cddShipperName);
	setCddShipperAccountNumber(cddShipperAccountNumber);
	setCddConsigneeName(cddConsigneeName);
	setCddConsigneeAcctNbr(cddConsigneeAcctNbr);
	setCddRouteNumber(cddRouteNumber);
	setCddRouteDate(cddRouteDate);
	setCddArrivalWorkDate(cddArrivalWorkDate);
	setCddLocalTotalCustAmt(cddLocalTotalCustAmt);
	setCddCountryOfOrigin(cddCountryOfOrigin);
	setCddServiceType(cddServiceType);
	setCddHiValLoVal(cddHiValLoVal);
	setCddShipperCompanyNm(cddShipperCompanyNm);
	setCddConsigneeCompanyNm(cddConsigneeCompanyNm);
	setCddSdlFlg(cddSdlFlg);
	setCddSpclHandlingCds(cddSpclHandlingCds);
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
	mComponents[30] = new CddSpclHandlingCds();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[31];
	mComponents[0] = null;
	mComponents[1] = null;
	mComponents[2] = null;
	mComponents[3] = null;
	mComponents[4] = null;
	mComponents[5] = null;
	mComponents[6] = null;
	mComponents[7] = null;
	mComponents[8] = null;
	mComponents[9] = null;
	mComponents[10] = null;
	mComponents[11] = null;
	mComponents[12] = null;
	mComponents[13] = null;
	mComponents[14] = null;
	mComponents[15] = null;
	mComponents[16] = null;
	mComponents[17] = null;
	mComponents[18] = null;
	mComponents[19] = null;
	mComponents[20] = null;
	mComponents[21] = null;
	mComponents[22] = null;
	mComponents[23] = null;
	mComponents[24] = null;
	mComponents[25] = null;
	mComponents[26] = null;
	mComponents[27] = null;
	mComponents[28] = null;
	mComponents[29] = null;
	mComponents[30] = null;
    }
    
    
    // Methods for field "cddFunctionCode"
    public IA5String getCddFunctionCode()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setCddFunctionCode(IA5String cddFunctionCode)
    {
	mComponents[0] = cddFunctionCode;
    }
    
    public boolean hasCddFunctionCode()
    {
	return componentIsPresent(0);
    }
    
    public void deleteCddFunctionCode()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "cddFunctionTypeCode"
    public IA5String getCddFunctionTypeCode()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setCddFunctionTypeCode(IA5String cddFunctionTypeCode)
    {
	mComponents[1] = cddFunctionTypeCode;
    }
    
    public boolean hasCddFunctionTypeCode()
    {
	return componentIsPresent(1);
    }
    
    public void deleteCddFunctionTypeCode()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "cddAirbillNumber"
    public IA5String getCddAirbillNumber()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setCddAirbillNumber(IA5String cddAirbillNumber)
    {
	mComponents[2] = cddAirbillNumber;
    }
    
    public boolean hasCddAirbillNumber()
    {
	return componentIsPresent(2);
    }
    
    public void deleteCddAirbillNumber()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "cddAwbSerialNumber"
    public IA5String getCddAwbSerialNumber()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setCddAwbSerialNumber(IA5String cddAwbSerialNumber)
    {
	mComponents[3] = cddAwbSerialNumber;
    }
    
    public boolean hasCddAwbSerialNumber()
    {
	return componentIsPresent(3);
    }
    
    public void deleteCddAwbSerialNumber()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "cddRequestTime"
    public IA5String getCddRequestTime()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setCddRequestTime(IA5String cddRequestTime)
    {
	mComponents[4] = cddRequestTime;
    }
    
    public boolean hasCddRequestTime()
    {
	return componentIsPresent(4);
    }
    
    public void deleteCddRequestTime()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "cddClearanceLocCode"
    public IA5String getCddClearanceLocCode()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setCddClearanceLocCode(IA5String cddClearanceLocCode)
    {
	mComponents[5] = cddClearanceLocCode;
    }
    
    public boolean hasCddClearanceLocCode()
    {
	return componentIsPresent(5);
    }
    
    public void deleteCddClearanceLocCode()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "cddOriginLoc"
    public IA5String getCddOriginLoc()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setCddOriginLoc(IA5String cddOriginLoc)
    {
	mComponents[6] = cddOriginLoc;
    }
    
    public boolean hasCddOriginLoc()
    {
	return componentIsPresent(6);
    }
    
    public void deleteCddOriginLoc()
    {
	setComponentAbsent(6);
    }
    
    
    // Methods for field "cddDestinationLoc"
    public IA5String getCddDestinationLoc()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setCddDestinationLoc(IA5String cddDestinationLoc)
    {
	mComponents[7] = cddDestinationLoc;
    }
    
    public boolean hasCddDestinationLoc()
    {
	return componentIsPresent(7);
    }
    
    public void deleteCddDestinationLoc()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "cddShipDate"
    public IA5String getCddShipDate()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setCddShipDate(IA5String cddShipDate)
    {
	mComponents[8] = cddShipDate;
    }
    
    public boolean hasCddShipDate()
    {
	return componentIsPresent(8);
    }
    
    public void deleteCddShipDate()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "cddSelectCode"
    public IA5String getCddSelectCode()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setCddSelectCode(IA5String cddSelectCode)
    {
	mComponents[9] = cddSelectCode;
    }
    
    public boolean hasCddSelectCode()
    {
	return componentIsPresent(9);
    }
    
    public void deleteCddSelectCode()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "cddSelectionSource"
    public IA5String getCddSelectionSource()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setCddSelectionSource(IA5String cddSelectionSource)
    {
	mComponents[10] = cddSelectionSource;
    }
    
    public boolean hasCddSelectionSource()
    {
	return componentIsPresent(10);
    }
    
    public void deleteCddSelectionSource()
    {
	setComponentAbsent(10);
    }
    
    
    // Methods for field "cddAgencyCode"
    public IA5String getCddAgencyCode()
    {
	return (IA5String)mComponents[11];
    }
    
    public void setCddAgencyCode(IA5String cddAgencyCode)
    {
	mComponents[11] = cddAgencyCode;
    }
    
    public boolean hasCddAgencyCode()
    {
	return componentIsPresent(11);
    }
    
    public void deleteCddAgencyCode()
    {
	setComponentAbsent(11);
    }
    
    
    // Methods for field "cddSelectionTimeStamp"
    public IA5String getCddSelectionTimeStamp()
    {
	return (IA5String)mComponents[12];
    }
    
    public void setCddSelectionTimeStamp(IA5String cddSelectionTimeStamp)
    {
	mComponents[12] = cddSelectionTimeStamp;
    }
    
    public boolean hasCddSelectionTimeStamp()
    {
	return componentIsPresent(12);
    }
    
    public void deleteCddSelectionTimeStamp()
    {
	setComponentAbsent(12);
    }
    
    
    // Methods for field "cddEntryType"
    public IA5String getCddEntryType()
    {
	return (IA5String)mComponents[13];
    }
    
    public void setCddEntryType(IA5String cddEntryType)
    {
	mComponents[13] = cddEntryType;
    }
    
    public boolean hasCddEntryType()
    {
	return componentIsPresent(13);
    }
    
    public void deleteCddEntryType()
    {
	setComponentAbsent(13);
    }
    
    
    // Methods for field "cddEmployeeNbr"
    public IA5String getCddEmployeeNbr()
    {
	return (IA5String)mComponents[14];
    }
    
    public void setCddEmployeeNbr(IA5String cddEmployeeNbr)
    {
	mComponents[14] = cddEmployeeNbr;
    }
    
    public boolean hasCddEmployeeNbr()
    {
	return componentIsPresent(14);
    }
    
    public void deleteCddEmployeeNbr()
    {
	setComponentAbsent(14);
    }
    
    
    // Methods for field "cddReceiver"
    public IA5String getCddReceiver()
    {
	return (IA5String)mComponents[15];
    }
    
    public void setCddReceiver(IA5String cddReceiver)
    {
	mComponents[15] = cddReceiver;
    }
    
    public boolean hasCddReceiver()
    {
	return componentIsPresent(15);
    }
    
    public void deleteCddReceiver()
    {
	setComponentAbsent(15);
    }
    
    
    // Methods for field "cddShipperName"
    public IA5String getCddShipperName()
    {
	return (IA5String)mComponents[16];
    }
    
    public void setCddShipperName(IA5String cddShipperName)
    {
	mComponents[16] = cddShipperName;
    }
    
    public boolean hasCddShipperName()
    {
	return componentIsPresent(16);
    }
    
    public void deleteCddShipperName()
    {
	setComponentAbsent(16);
    }
    
    
    // Methods for field "cddShipperAccountNumber"
    public IA5String getCddShipperAccountNumber()
    {
	return (IA5String)mComponents[17];
    }
    
    public void setCddShipperAccountNumber(IA5String cddShipperAccountNumber)
    {
	mComponents[17] = cddShipperAccountNumber;
    }
    
    public boolean hasCddShipperAccountNumber()
    {
	return componentIsPresent(17);
    }
    
    public void deleteCddShipperAccountNumber()
    {
	setComponentAbsent(17);
    }
    
    
    // Methods for field "cddConsigneeName"
    public IA5String getCddConsigneeName()
    {
	return (IA5String)mComponents[18];
    }
    
    public void setCddConsigneeName(IA5String cddConsigneeName)
    {
	mComponents[18] = cddConsigneeName;
    }
    
    public boolean hasCddConsigneeName()
    {
	return componentIsPresent(18);
    }
    
    public void deleteCddConsigneeName()
    {
	setComponentAbsent(18);
    }
    
    
    // Methods for field "cddConsigneeAcctNbr"
    public IA5String getCddConsigneeAcctNbr()
    {
	return (IA5String)mComponents[19];
    }
    
    public void setCddConsigneeAcctNbr(IA5String cddConsigneeAcctNbr)
    {
	mComponents[19] = cddConsigneeAcctNbr;
    }
    
    public boolean hasCddConsigneeAcctNbr()
    {
	return componentIsPresent(19);
    }
    
    public void deleteCddConsigneeAcctNbr()
    {
	setComponentAbsent(19);
    }
    
    
    // Methods for field "cddRouteNumber"
    public IA5String getCddRouteNumber()
    {
	return (IA5String)mComponents[20];
    }
    
    public void setCddRouteNumber(IA5String cddRouteNumber)
    {
	mComponents[20] = cddRouteNumber;
    }
    
    public boolean hasCddRouteNumber()
    {
	return componentIsPresent(20);
    }
    
    public void deleteCddRouteNumber()
    {
	setComponentAbsent(20);
    }
    
    
    // Methods for field "cddRouteDate"
    public IA5String getCddRouteDate()
    {
	return (IA5String)mComponents[21];
    }
    
    public void setCddRouteDate(IA5String cddRouteDate)
    {
	mComponents[21] = cddRouteDate;
    }
    
    public boolean hasCddRouteDate()
    {
	return componentIsPresent(21);
    }
    
    public void deleteCddRouteDate()
    {
	setComponentAbsent(21);
    }
    
    
    // Methods for field "cddArrivalWorkDate"
    public IA5String getCddArrivalWorkDate()
    {
	return (IA5String)mComponents[22];
    }
    
    public void setCddArrivalWorkDate(IA5String cddArrivalWorkDate)
    {
	mComponents[22] = cddArrivalWorkDate;
    }
    
    public boolean hasCddArrivalWorkDate()
    {
	return componentIsPresent(22);
    }
    
    public void deleteCddArrivalWorkDate()
    {
	setComponentAbsent(22);
    }
    
    
    // Methods for field "cddLocalTotalCustAmt"
    public IA5String getCddLocalTotalCustAmt()
    {
	return (IA5String)mComponents[23];
    }
    
    public void setCddLocalTotalCustAmt(IA5String cddLocalTotalCustAmt)
    {
	mComponents[23] = cddLocalTotalCustAmt;
    }
    
    public boolean hasCddLocalTotalCustAmt()
    {
	return componentIsPresent(23);
    }
    
    public void deleteCddLocalTotalCustAmt()
    {
	setComponentAbsent(23);
    }
    
    
    // Methods for field "cddCountryOfOrigin"
    public IA5String getCddCountryOfOrigin()
    {
	return (IA5String)mComponents[24];
    }
    
    public void setCddCountryOfOrigin(IA5String cddCountryOfOrigin)
    {
	mComponents[24] = cddCountryOfOrigin;
    }
    
    public boolean hasCddCountryOfOrigin()
    {
	return componentIsPresent(24);
    }
    
    public void deleteCddCountryOfOrigin()
    {
	setComponentAbsent(24);
    }
    
    
    // Methods for field "cddServiceType"
    public IA5String getCddServiceType()
    {
	return (IA5String)mComponents[25];
    }
    
    public void setCddServiceType(IA5String cddServiceType)
    {
	mComponents[25] = cddServiceType;
    }
    
    public boolean hasCddServiceType()
    {
	return componentIsPresent(25);
    }
    
    public void deleteCddServiceType()
    {
	setComponentAbsent(25);
    }
    
    
    // Methods for field "cddHiValLoVal"
    public IA5String getCddHiValLoVal()
    {
	return (IA5String)mComponents[26];
    }
    
    public void setCddHiValLoVal(IA5String cddHiValLoVal)
    {
	mComponents[26] = cddHiValLoVal;
    }
    
    public boolean hasCddHiValLoVal()
    {
	return componentIsPresent(26);
    }
    
    public void deleteCddHiValLoVal()
    {
	setComponentAbsent(26);
    }
    
    
    // Methods for field "cddShipperCompanyNm"
    public IA5String getCddShipperCompanyNm()
    {
	return (IA5String)mComponents[27];
    }
    
    public void setCddShipperCompanyNm(IA5String cddShipperCompanyNm)
    {
	mComponents[27] = cddShipperCompanyNm;
    }
    
    public boolean hasCddShipperCompanyNm()
    {
	return componentIsPresent(27);
    }
    
    public void deleteCddShipperCompanyNm()
    {
	setComponentAbsent(27);
    }
    
    
    // Methods for field "cddConsigneeCompanyNm"
    public IA5String getCddConsigneeCompanyNm()
    {
	return (IA5String)mComponents[28];
    }
    
    public void setCddConsigneeCompanyNm(IA5String cddConsigneeCompanyNm)
    {
	mComponents[28] = cddConsigneeCompanyNm;
    }
    
    public boolean hasCddConsigneeCompanyNm()
    {
	return componentIsPresent(28);
    }
    
    public void deleteCddConsigneeCompanyNm()
    {
	setComponentAbsent(28);
    }
    
    
    // Methods for field "cddSdlFlg"
    public IA5String getCddSdlFlg()
    {
	return (IA5String)mComponents[29];
    }
    
    public void setCddSdlFlg(IA5String cddSdlFlg)
    {
	mComponents[29] = cddSdlFlg;
    }
    
    public boolean hasCddSdlFlg()
    {
	return componentIsPresent(29);
    }
    
    public void deleteCddSdlFlg()
    {
	setComponentAbsent(29);
    }
    
    
    // Methods for field "cddSpclHandlingCds"
    public CddSpclHandlingCds getCddSpclHandlingCds()
    {
	return (CddSpclHandlingCds)mComponents[30];
    }
    
    public void setCddSpclHandlingCds(CddSpclHandlingCds cddSpclHandlingCds)
    {
	mComponents[30] = cddSpclHandlingCds;
    }
    
    public boolean hasCddSpclHandlingCds()
    {
	return componentIsPresent(30);
    }
    
    public void deleteCddSpclHandlingCds()
    {
	setComponentAbsent(30);
    }
    
    
    
    /**
     * Define the ASN1 Type CddSpclHandlingCds from ASN1 Module DDTRAN.
     * @see SetOf
     */
    public static class CddSpclHandlingCds extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public CddSpclHandlingCds()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public CddSpclHandlingCds(ScddSpclHandlingCdsGrp[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(ScddSpclHandlingCdsGrp element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(ScddSpclHandlingCdsGrp element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized ScddSpclHandlingCdsGrp get(int atIndex)
	{
	    return (ScddSpclHandlingCdsGrp)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(ScddSpclHandlingCdsGrp element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(ScddSpclHandlingCdsGrp element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new ScddSpclHandlingCdsGrp();
	}
	
	/**
	 * Initialize the type descriptor.
	 */
	private static final ContainerInfo c_typeinfo = new ContainerInfo (
	    new Tags (
		new short[] {
		    (short)0x801f
		}
	    ),
	    new QName (
		"imageRequestASN.ddtran",
		"ASNrequest$CddSpclHandlingCds"
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
			new com.oss.asn1.INTEGER(6),
			0
		    )
		)
	    ),
	    new Bounds (
		new Long(0),
		new Long(6)
	    ),
	    new TypeInfoRef (
		new QName (
		    "imageRequestASN.ddtran",
		    "ScddSpclHandlingCdsGrp"
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' CddSpclHandlingCds object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' CddSpclHandlingCds object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for CddSpclHandlingCds

    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		0x4287
	    }
	),
	new QName (
	    "imageRequestASN.ddtran",
	    "ASNrequest"
	),
	new QName (
	    "DDTRAN",
	    "ASNrequest"
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
				    (short)0x8001
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
		    "cddFunctionCode",
		    0,
		    3,
		    null
		),
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
		    "cddFunctionTypeCode",
		    1,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8003
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
					    new com.oss.asn1.INTEGER(13),
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
				new Long(13)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddAirbillNumber",
		    2,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8004
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
					    new com.oss.asn1.INTEGER(64),
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
				new Long(64)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddAwbSerialNumber",
		    3,
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
		    "cddRequestTime",
		    4,
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
		    "cddClearanceLocCode",
		    5,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8007
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
		    "cddOriginLoc",
		    6,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8008
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
		    "cddDestinationLoc",
		    7,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8009
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
		    "cddShipDate",
		    8,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800a
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
					    new com.oss.asn1.INTEGER(3),
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
				new Long(3)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddSelectCode",
		    9,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800b
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
					    new com.oss.asn1.INTEGER(11),
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
				new Long(11)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddSelectionSource",
		    10,
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
					    new com.oss.asn1.INTEGER(3),
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
				new Long(3)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddAgencyCode",
		    11,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800d
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
		    "cddSelectionTimeStamp",
		    12,
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
		    "cddEntryType",
		    13,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800f
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
					    new com.oss.asn1.INTEGER(11),
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
				new Long(11)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddEmployeeNbr",
		    14,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8010
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
		    "cddReceiver",
		    15,
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
					    new com.oss.asn1.INTEGER(36),
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
				new Long(36)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddShipperName",
		    16,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8012
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
		    "cddShipperAccountNumber",
		    17,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8013
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
					    new com.oss.asn1.INTEGER(36),
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
				new Long(36)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddConsigneeName",
		    18,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8014
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
		    "cddConsigneeAcctNbr",
		    19,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8015
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
					    new com.oss.asn1.INTEGER(7),
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
				new Long(7)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddRouteNumber",
		    20,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8016
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
		    "cddRouteDate",
		    21,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8017
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
		    "cddArrivalWorkDate",
		    22,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8018
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
					    new com.oss.asn1.INTEGER(64),
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
				new Long(64)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddLocalTotalCustAmt",
		    23,
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
					    new com.oss.asn1.INTEGER(3),
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
				new Long(3)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddCountryOfOrigin",
		    24,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801a
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
					    new com.oss.asn1.INTEGER(3),
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
				new Long(3)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddServiceType",
		    25,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801b
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
					    new com.oss.asn1.INTEGER(3),
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
				new Long(3)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddHiValLoVal",
		    26,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801c
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
					    new com.oss.asn1.INTEGER(36),
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
				new Long(36)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddShipperCompanyNm",
		    27,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801d
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
					    new com.oss.asn1.INTEGER(36),
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
				new Long(36)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "cddConsigneeCompanyNm",
		    28,
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
		    "cddSdlFlg",
		    29,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "imageRequestASN.ddtran",
			    "ASNrequest$CddSpclHandlingCds"
			)
		    ),
		    "cddSpclHandlingCds",
		    30,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8001, 0),
		new TagDecoderElement((short)0x8002, 1),
		new TagDecoderElement((short)0x8003, 2),
		new TagDecoderElement((short)0x8004, 3),
		new TagDecoderElement((short)0x8005, 4),
		new TagDecoderElement((short)0x8006, 5),
		new TagDecoderElement((short)0x8007, 6),
		new TagDecoderElement((short)0x8008, 7),
		new TagDecoderElement((short)0x8009, 8),
		new TagDecoderElement((short)0x800a, 9),
		new TagDecoderElement((short)0x800b, 10),
		new TagDecoderElement((short)0x800c, 11),
		new TagDecoderElement((short)0x800d, 12),
		new TagDecoderElement((short)0x800e, 13),
		new TagDecoderElement((short)0x800f, 14),
		new TagDecoderElement((short)0x8010, 15),
		new TagDecoderElement((short)0x8011, 16),
		new TagDecoderElement((short)0x8012, 17),
		new TagDecoderElement((short)0x8013, 18),
		new TagDecoderElement((short)0x8014, 19),
		new TagDecoderElement((short)0x8015, 20),
		new TagDecoderElement((short)0x8016, 21),
		new TagDecoderElement((short)0x8017, 22),
		new TagDecoderElement((short)0x8018, 23),
		new TagDecoderElement((short)0x8019, 24),
		new TagDecoderElement((short)0x801a, 25),
		new TagDecoderElement((short)0x801b, 26),
		new TagDecoderElement((short)0x801c, 27),
		new TagDecoderElement((short)0x801d, 28),
		new TagDecoderElement((short)0x801e, 29),
		new TagDecoderElement((short)0x801f, 30)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' ASNrequest object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' ASNrequest object.
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
    
} // End class definition for ASNrequest
