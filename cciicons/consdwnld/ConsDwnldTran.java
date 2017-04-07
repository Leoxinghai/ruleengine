/*************************************************************/
/* Copyright (C) 2004 OSS Nokalva, Inc.  All rights reserved.*/
/*************************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA, INC.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA, INC.
 * THIS FILE MAY NOT BE DISTRIBUTED. */

/* Generated for: Federal Express Worldwide Agreement, Memphis, TN - PJ 9820,21,22; 1Step 9823,24; C 9825,26,27,28,29,30 */
/* Abstract syntax: cciicons */
/* ASN.1 Java project: cciicons.Cciicons */
/* Created: Thu Aug  5 09:52:15 2004 */
/* ASN.1 Pure Java Compiler version: 2.0 */
/* ASN.1 compiler options and file names specified:
 * -output cciicons cciiCONS.asn
 */


package cciicons.consdwnld;

import com.oss.asn1.*;
import com.oss.metadata.*;
import cciicons.*;

/**
 * Define the ASN1 Type ConsDwnldTran from ASN1 Module ConsDwnld.
 * @see Set
 */

public class ConsDwnldTran extends Set {
    
    /**
     * The default constructor.
     */
    public ConsDwnldTran()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public ConsDwnldTran(IA5String consTrakItemNbr, IA5String consTypeCd, 
		    IA5String consFormCd, IA5String trakType, 
		    IA5String noiDestinationLocId, IA5String consScanLoc, 
		    IA5String sourceCd, IA5String transmitCd, 
		    IA5String astraLabelScannedFlg, IA5String consFailedFlg, 
		    IA5String containerId, IA5String containerIndicator, 
		    IA5String consCategory, IA5String consDestination, 
		    IA5String consDestCountry, IA5String consMinisortFlg, 
		    IA5String consScanDt, IA5String consScanTm, 
		    IA5String consCreateDt, IA5String consCreateTm, 
		    IA5String consTimeZoneChgCd, 
		    IA5String consAirbillGroupCnt, Agg215 agg215, 
		    IA5String employeeNbr, IA5String priorDayFlg, 
		    IA5String beginFunctionDt, IA5String endFunctionDt, 
		    IA5String trakEndFunctionTm, 
		    IA5String trakBeginFunctionTm, 
		    IA5String destApplicationId, IA5String flightNbr, 
		    IA5String flightDt, IA5String flightOrigin, 
		    IA5String flightDest, IA5String actualDepDt, 
		    IA5String actualDepTm)
    {
	setConsTrakItemNbr(consTrakItemNbr);
	setConsTypeCd(consTypeCd);
	setConsFormCd(consFormCd);
	setTrakType(trakType);
	setNoiDestinationLocId(noiDestinationLocId);
	setConsScanLoc(consScanLoc);
	setSourceCd(sourceCd);
	setTransmitCd(transmitCd);
	setAstraLabelScannedFlg(astraLabelScannedFlg);
	setConsFailedFlg(consFailedFlg);
	setContainerId(containerId);
	setContainerIndicator(containerIndicator);
	setConsCategory(consCategory);
	setConsDestination(consDestination);
	setConsDestCountry(consDestCountry);
	setConsMinisortFlg(consMinisortFlg);
	setConsScanDt(consScanDt);
	setConsScanTm(consScanTm);
	setConsCreateDt(consCreateDt);
	setConsCreateTm(consCreateTm);
	setConsTimeZoneChgCd(consTimeZoneChgCd);
	setConsAirbillGroupCnt(consAirbillGroupCnt);
	setAgg215(agg215);
	setEmployeeNbr(employeeNbr);
	setPriorDayFlg(priorDayFlg);
	setBeginFunctionDt(beginFunctionDt);
	setEndFunctionDt(endFunctionDt);
	setTrakEndFunctionTm(trakEndFunctionTm);
	setTrakBeginFunctionTm(trakBeginFunctionTm);
	setDestApplicationId(destApplicationId);
	setFlightNbr(flightNbr);
	setFlightDt(flightDt);
	setFlightOrigin(flightOrigin);
	setFlightDest(flightDest);
	setActualDepDt(actualDepDt);
	setActualDepTm(actualDepTm);
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
	mComponents[15] = new Agg215();
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
	mComponents[35] = new IA5String();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[36];
    }
    
    
    // Methods for field "consTypeCd"
    public IA5String getConsTypeCd()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setConsTypeCd(IA5String consTypeCd)
    {
	mComponents[0] = consTypeCd;
    }
    
    public boolean hasConsTypeCd()
    {
	return componentIsPresent(0);
    }
    
    public void deleteConsTypeCd()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "consDestination"
    public IA5String getConsDestination()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setConsDestination(IA5String consDestination)
    {
	mComponents[1] = consDestination;
    }
    
    public boolean hasConsDestination()
    {
	return componentIsPresent(1);
    }
    
    public void deleteConsDestination()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "employeeNbr"
    public IA5String getEmployeeNbr()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setEmployeeNbr(IA5String employeeNbr)
    {
	mComponents[2] = employeeNbr;
    }
    
    public boolean hasEmployeeNbr()
    {
	return componentIsPresent(2);
    }
    
    public void deleteEmployeeNbr()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "trakBeginFunctionTm"
    public IA5String getTrakBeginFunctionTm()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setTrakBeginFunctionTm(IA5String trakBeginFunctionTm)
    {
	mComponents[3] = trakBeginFunctionTm;
    }
    
    public boolean hasTrakBeginFunctionTm()
    {
	return componentIsPresent(3);
    }
    
    public void deleteTrakBeginFunctionTm()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "consScanDt"
    public IA5String getConsScanDt()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setConsScanDt(IA5String consScanDt)
    {
	mComponents[4] = consScanDt;
    }
    
    public boolean hasConsScanDt()
    {
	return componentIsPresent(4);
    }
    
    public void deleteConsScanDt()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "trakEndFunctionTm"
    public IA5String getTrakEndFunctionTm()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setTrakEndFunctionTm(IA5String trakEndFunctionTm)
    {
	mComponents[5] = trakEndFunctionTm;
    }
    
    public boolean hasTrakEndFunctionTm()
    {
	return componentIsPresent(5);
    }
    
    public void deleteTrakEndFunctionTm()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "consScanTm"
    public IA5String getConsScanTm()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setConsScanTm(IA5String consScanTm)
    {
	mComponents[6] = consScanTm;
    }
    
    public boolean hasConsScanTm()
    {
	return componentIsPresent(6);
    }
    
    public void deleteConsScanTm()
    {
	setComponentAbsent(6);
    }
    
    
    // Methods for field "trakType"
    public IA5String getTrakType()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setTrakType(IA5String trakType)
    {
	mComponents[7] = trakType;
    }
    
    public boolean hasTrakType()
    {
	return componentIsPresent(7);
    }
    
    public void deleteTrakType()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "astraLabelScannedFlg"
    public IA5String getAstraLabelScannedFlg()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setAstraLabelScannedFlg(IA5String astraLabelScannedFlg)
    {
	mComponents[8] = astraLabelScannedFlg;
    }
    
    public boolean hasAstraLabelScannedFlg()
    {
	return componentIsPresent(8);
    }
    
    public void deleteAstraLabelScannedFlg()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "consDestCountry"
    public IA5String getConsDestCountry()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setConsDestCountry(IA5String consDestCountry)
    {
	mComponents[9] = consDestCountry;
    }
    
    public boolean hasConsDestCountry()
    {
	return componentIsPresent(9);
    }
    
    public void deleteConsDestCountry()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "sourceCd"
    public IA5String getSourceCd()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setSourceCd(IA5String sourceCd)
    {
	mComponents[10] = sourceCd;
    }
    
    public boolean hasSourceCd()
    {
	return componentIsPresent(10);
    }
    
    public void deleteSourceCd()
    {
	setComponentAbsent(10);
    }
    
    
    // Methods for field "flightNbr"
    public IA5String getFlightNbr()
    {
	return (IA5String)mComponents[11];
    }
    
    public void setFlightNbr(IA5String flightNbr)
    {
	mComponents[11] = flightNbr;
    }
    
    public boolean hasFlightNbr()
    {
	return componentIsPresent(11);
    }
    
    public void deleteFlightNbr()
    {
	setComponentAbsent(11);
    }
    
    
    // Methods for field "containerId"
    public IA5String getContainerId()
    {
	return (IA5String)mComponents[12];
    }
    
    public void setContainerId(IA5String containerId)
    {
	mComponents[12] = containerId;
    }
    
    public boolean hasContainerId()
    {
	return componentIsPresent(12);
    }
    
    public void deleteContainerId()
    {
	setComponentAbsent(12);
    }
    
    
    // Methods for field "consTrakItemNbr"
    public IA5String getConsTrakItemNbr()
    {
	return (IA5String)mComponents[13];
    }
    
    public void setConsTrakItemNbr(IA5String consTrakItemNbr)
    {
	mComponents[13] = consTrakItemNbr;
    }
    
    public boolean hasConsTrakItemNbr()
    {
	return componentIsPresent(13);
    }
    
    public void deleteConsTrakItemNbr()
    {
	setComponentAbsent(13);
    }
    
    
    // Methods for field "consFormCd"
    public IA5String getConsFormCd()
    {
	return (IA5String)mComponents[14];
    }
    
    public void setConsFormCd(IA5String consFormCd)
    {
	mComponents[14] = consFormCd;
    }
    
    public boolean hasConsFormCd()
    {
	return componentIsPresent(14);
    }
    
    public void deleteConsFormCd()
    {
	setComponentAbsent(14);
    }
    
    
    // Methods for field "agg215"
    public Agg215 getAgg215()
    {
	return (Agg215)mComponents[15];
    }
    
    public void setAgg215(Agg215 agg215)
    {
	mComponents[15] = agg215;
    }
    
    public boolean hasAgg215()
    {
	return componentIsPresent(15);
    }
    
    public void deleteAgg215()
    {
	setComponentAbsent(15);
    }
    
    
    
    /**
     * Define the ASN1 Type Agg215 from ASN1 Module ConsDwnld.
     * @see SetOf
     */
    public static class Agg215 extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public Agg215()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public Agg215(Aggregate215[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(Aggregate215 element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(Aggregate215 element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized Aggregate215 get(int atIndex)
	{
	    return (Aggregate215)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(Aggregate215 element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(Aggregate215 element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new Aggregate215();
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
		"cciicons.consdwnld",
		"ConsDwnldTran$Agg215"
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
			new com.oss.asn1.INTEGER(50),
			0
		    )
		)
	    ),
	    new Bounds (
		new Long(0),
		new Long(50)
	    ),
	    new TypeInfoRef (
		new QName (
		    "cciicons.consdwnld",
		    "Aggregate215"
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' Agg215 object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' Agg215 object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for Agg215

    // Methods for field "containerIndicator"
    public IA5String getContainerIndicator()
    {
	return (IA5String)mComponents[16];
    }
    
    public void setContainerIndicator(IA5String containerIndicator)
    {
	mComponents[16] = containerIndicator;
    }
    
    public boolean hasContainerIndicator()
    {
	return componentIsPresent(16);
    }
    
    public void deleteContainerIndicator()
    {
	setComponentAbsent(16);
    }
    
    
    // Methods for field "consCategory"
    public IA5String getConsCategory()
    {
	return (IA5String)mComponents[17];
    }
    
    public void setConsCategory(IA5String consCategory)
    {
	mComponents[17] = consCategory;
    }
    
    public boolean hasConsCategory()
    {
	return componentIsPresent(17);
    }
    
    public void deleteConsCategory()
    {
	setComponentAbsent(17);
    }
    
    
    // Methods for field "consCreateDt"
    public IA5String getConsCreateDt()
    {
	return (IA5String)mComponents[18];
    }
    
    public void setConsCreateDt(IA5String consCreateDt)
    {
	mComponents[18] = consCreateDt;
    }
    
    public boolean hasConsCreateDt()
    {
	return componentIsPresent(18);
    }
    
    public void deleteConsCreateDt()
    {
	setComponentAbsent(18);
    }
    
    
    // Methods for field "consCreateTm"
    public IA5String getConsCreateTm()
    {
	return (IA5String)mComponents[19];
    }
    
    public void setConsCreateTm(IA5String consCreateTm)
    {
	mComponents[19] = consCreateTm;
    }
    
    public boolean hasConsCreateTm()
    {
	return componentIsPresent(19);
    }
    
    public void deleteConsCreateTm()
    {
	setComponentAbsent(19);
    }
    
    
    // Methods for field "consMinisortFlg"
    public IA5String getConsMinisortFlg()
    {
	return (IA5String)mComponents[20];
    }
    
    public void setConsMinisortFlg(IA5String consMinisortFlg)
    {
	mComponents[20] = consMinisortFlg;
    }
    
    public boolean hasConsMinisortFlg()
    {
	return componentIsPresent(20);
    }
    
    public void deleteConsMinisortFlg()
    {
	setComponentAbsent(20);
    }
    
    
    // Methods for field "transmitCd"
    public IA5String getTransmitCd()
    {
	return (IA5String)mComponents[21];
    }
    
    public void setTransmitCd(IA5String transmitCd)
    {
	mComponents[21] = transmitCd;
    }
    
    public boolean hasTransmitCd()
    {
	return componentIsPresent(21);
    }
    
    public void deleteTransmitCd()
    {
	setComponentAbsent(21);
    }
    
    
    // Methods for field "consFailedFlg"
    public IA5String getConsFailedFlg()
    {
	return (IA5String)mComponents[22];
    }
    
    public void setConsFailedFlg(IA5String consFailedFlg)
    {
	mComponents[22] = consFailedFlg;
    }
    
    public boolean hasConsFailedFlg()
    {
	return componentIsPresent(22);
    }
    
    public void deleteConsFailedFlg()
    {
	setComponentAbsent(22);
    }
    
    
    // Methods for field "consScanLoc"
    public IA5String getConsScanLoc()
    {
	return (IA5String)mComponents[23];
    }
    
    public void setConsScanLoc(IA5String consScanLoc)
    {
	mComponents[23] = consScanLoc;
    }
    
    public boolean hasConsScanLoc()
    {
	return componentIsPresent(23);
    }
    
    public void deleteConsScanLoc()
    {
	setComponentAbsent(23);
    }
    
    
    // Methods for field "noiDestinationLocId"
    public IA5String getNoiDestinationLocId()
    {
	return (IA5String)mComponents[24];
    }
    
    public void setNoiDestinationLocId(IA5String noiDestinationLocId)
    {
	mComponents[24] = noiDestinationLocId;
    }
    
    public boolean hasNoiDestinationLocId()
    {
	return componentIsPresent(24);
    }
    
    public void deleteNoiDestinationLocId()
    {
	setComponentAbsent(24);
    }
    
    
    // Methods for field "priorDayFlg"
    public IA5String getPriorDayFlg()
    {
	return (IA5String)mComponents[25];
    }
    
    public void setPriorDayFlg(IA5String priorDayFlg)
    {
	mComponents[25] = priorDayFlg;
    }
    
    public boolean hasPriorDayFlg()
    {
	return componentIsPresent(25);
    }
    
    public void deletePriorDayFlg()
    {
	setComponentAbsent(25);
    }
    
    
    // Methods for field "beginFunctionDt"
    public IA5String getBeginFunctionDt()
    {
	return (IA5String)mComponents[26];
    }
    
    public void setBeginFunctionDt(IA5String beginFunctionDt)
    {
	mComponents[26] = beginFunctionDt;
    }
    
    public boolean hasBeginFunctionDt()
    {
	return componentIsPresent(26);
    }
    
    public void deleteBeginFunctionDt()
    {
	setComponentAbsent(26);
    }
    
    
    // Methods for field "endFunctionDt"
    public IA5String getEndFunctionDt()
    {
	return (IA5String)mComponents[27];
    }
    
    public void setEndFunctionDt(IA5String endFunctionDt)
    {
	mComponents[27] = endFunctionDt;
    }
    
    public boolean hasEndFunctionDt()
    {
	return componentIsPresent(27);
    }
    
    public void deleteEndFunctionDt()
    {
	setComponentAbsent(27);
    }
    
    
    // Methods for field "destApplicationId"
    public IA5String getDestApplicationId()
    {
	return (IA5String)mComponents[28];
    }
    
    public void setDestApplicationId(IA5String destApplicationId)
    {
	mComponents[28] = destApplicationId;
    }
    
    public boolean hasDestApplicationId()
    {
	return componentIsPresent(28);
    }
    
    public void deleteDestApplicationId()
    {
	setComponentAbsent(28);
    }
    
    
    // Methods for field "flightDt"
    public IA5String getFlightDt()
    {
	return (IA5String)mComponents[29];
    }
    
    public void setFlightDt(IA5String flightDt)
    {
	mComponents[29] = flightDt;
    }
    
    public boolean hasFlightDt()
    {
	return componentIsPresent(29);
    }
    
    public void deleteFlightDt()
    {
	setComponentAbsent(29);
    }
    
    
    // Methods for field "flightOrigin"
    public IA5String getFlightOrigin()
    {
	return (IA5String)mComponents[30];
    }
    
    public void setFlightOrigin(IA5String flightOrigin)
    {
	mComponents[30] = flightOrigin;
    }
    
    public boolean hasFlightOrigin()
    {
	return componentIsPresent(30);
    }
    
    public void deleteFlightOrigin()
    {
	setComponentAbsent(30);
    }
    
    
    // Methods for field "flightDest"
    public IA5String getFlightDest()
    {
	return (IA5String)mComponents[31];
    }
    
    public void setFlightDest(IA5String flightDest)
    {
	mComponents[31] = flightDest;
    }
    
    public boolean hasFlightDest()
    {
	return componentIsPresent(31);
    }
    
    public void deleteFlightDest()
    {
	setComponentAbsent(31);
    }
    
    
    // Methods for field "actualDepDt"
    public IA5String getActualDepDt()
    {
	return (IA5String)mComponents[32];
    }
    
    public void setActualDepDt(IA5String actualDepDt)
    {
	mComponents[32] = actualDepDt;
    }
    
    public boolean hasActualDepDt()
    {
	return componentIsPresent(32);
    }
    
    public void deleteActualDepDt()
    {
	setComponentAbsent(32);
    }
    
    
    // Methods for field "actualDepTm"
    public IA5String getActualDepTm()
    {
	return (IA5String)mComponents[33];
    }
    
    public void setActualDepTm(IA5String actualDepTm)
    {
	mComponents[33] = actualDepTm;
    }
    
    public boolean hasActualDepTm()
    {
	return componentIsPresent(33);
    }
    
    public void deleteActualDepTm()
    {
	setComponentAbsent(33);
    }
    
    
    // Methods for field "consTimeZoneChgCd"
    public IA5String getConsTimeZoneChgCd()
    {
	return (IA5String)mComponents[34];
    }
    
    public void setConsTimeZoneChgCd(IA5String consTimeZoneChgCd)
    {
	mComponents[34] = consTimeZoneChgCd;
    }
    
    public boolean hasConsTimeZoneChgCd()
    {
	return componentIsPresent(34);
    }
    
    public void deleteConsTimeZoneChgCd()
    {
	setComponentAbsent(34);
    }
    
    
    // Methods for field "consAirbillGroupCnt"
    public IA5String getConsAirbillGroupCnt()
    {
	return (IA5String)mComponents[35];
    }
    
    public void setConsAirbillGroupCnt(IA5String consAirbillGroupCnt)
    {
	mComponents[35] = consAirbillGroupCnt;
    }
    
    public boolean hasConsAirbillGroupCnt()
    {
	return componentIsPresent(35);
    }
    
    public void deleteConsAirbillGroupCnt()
    {
	setComponentAbsent(35);
    }
    
    
    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		0x4001
	    }
	),
	new QName (
	    "cciicons.consdwnld",
	    "ConsDwnldTran"
	),
	new QName (
	    "ConsDwnld",
	    "ConsDwnldTran"
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
		    "consTypeCd",
		    0,
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
		    1,
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
		    "employeeNbr",
		    2,
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
		    "trakBeginFunctionTm",
		    3,
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
		    "consScanDt",
		    4,
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
		    "trakEndFunctionTm",
		    5,
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
		    "consScanTm",
		    6,
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
		    "trakType",
		    7,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x802c
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
		    "astraLabelScannedFlg",
		    8,
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
		    "consDestCountry",
		    9,
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
		    "sourceCd",
		    10,
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
		    "flightNbr",
		    11,
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
		    12,
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
		    "consTrakItemNbr",
		    13,
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
					    new com.oss.asn1.INTEGER(15),
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
				new Long(15)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "consFormCd",
		    14,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "cciicons.consdwnld",
			    "ConsDwnldTran$Agg215"
			)
		    ),
		    "agg215",
		    15,
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
		    16,
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
		    "consCategory",
		    17,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80e6
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
		    "consCreateDt",
		    18,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80e7
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
		    "consCreateTm",
		    19,
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
		    "consMinisortFlg",
		    20,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x811c
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
		    "transmitCd",
		    21,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8122
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
		    "consFailedFlg",
		    22,
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
		    "consScanLoc",
		    23,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8124
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
		    "noiDestinationLocId",
		    24,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8127
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
		    "priorDayFlg",
		    25,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8131
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
		    "beginFunctionDt",
		    26,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8132
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
		    "endFunctionDt",
		    27,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8135
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
		    "destApplicationId",
		    28,
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
		    "flightDt",
		    29,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8137
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
		    "flightOrigin",
		    30,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8138
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
		    "flightDest",
		    31,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8139
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
		    "actualDepDt",
		    32,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x813a
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
		    "actualDepTm",
		    33,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x813f
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
		    "consTimeZoneChgCd",
		    34,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8140
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
					    new com.oss.asn1.INTEGER(15),
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
				new Long(15)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "consAirbillGroupCnt",
		    35,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8002, 0),
		new TagDecoderElement((short)0x800b, 1),
		new TagDecoderElement((short)0x800e, 2),
		new TagDecoderElement((short)0x8022, 3),
		new TagDecoderElement((short)0x8023, 4),
		new TagDecoderElement((short)0x8024, 5),
		new TagDecoderElement((short)0x8028, 6),
		new TagDecoderElement((short)0x8029, 7),
		new TagDecoderElement((short)0x802c, 8),
		new TagDecoderElement((short)0x8062, 9),
		new TagDecoderElement((short)0x8067, 10),
		new TagDecoderElement((short)0x807d, 11),
		new TagDecoderElement((short)0x808d, 12),
		new TagDecoderElement((short)0x8096, 13),
		new TagDecoderElement((short)0x80d4, 14),
		new TagDecoderElement((short)0x80d7, 15),
		new TagDecoderElement((short)0x80de, 16),
		new TagDecoderElement((short)0x80df, 17),
		new TagDecoderElement((short)0x80e6, 18),
		new TagDecoderElement((short)0x80e7, 19),
		new TagDecoderElement((short)0x810c, 20),
		new TagDecoderElement((short)0x811c, 21),
		new TagDecoderElement((short)0x8122, 22),
		new TagDecoderElement((short)0x8123, 23),
		new TagDecoderElement((short)0x8124, 24),
		new TagDecoderElement((short)0x8127, 25),
		new TagDecoderElement((short)0x8131, 26),
		new TagDecoderElement((short)0x8132, 27),
		new TagDecoderElement((short)0x8135, 28),
		new TagDecoderElement((short)0x8136, 29),
		new TagDecoderElement((short)0x8137, 30),
		new TagDecoderElement((short)0x8138, 31),
		new TagDecoderElement((short)0x8139, 32),
		new TagDecoderElement((short)0x813a, 33),
		new TagDecoderElement((short)0x813f, 34),
		new TagDecoderElement((short)0x8140, 35)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' ConsDwnldTran object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' ConsDwnldTran object.
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
    
} // End class definition for ConsDwnldTran
