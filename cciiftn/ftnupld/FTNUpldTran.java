/*************************************************************/
/* Copyright (C) 2004 OSS Nokalva, Inc.  All rights reserved.*/
/*************************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA, INC.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA, INC.
 * THIS FILE MAY NOT BE DISTRIBUTED. */

/* Generated for: Federal Express Worldwide Agreement, Memphis, TN - PJ 9820,21,22; 1Step 9823,24; C 9825,26,27,28,29,30 */
/* Abstract syntax: cciiftn */
/* ASN.1 Java project: cciiftn.Cciiftn */
/* Created: Sun Oct 10 11:36:23 2004 */
/* ASN.1 Pure Java Compiler version: 2.0 */
/* ASN.1 compiler options and file names specified:
 * -output cciiftn cciiFTN.asn
 */


package cciiftn.ftnupld;

import com.oss.asn1.*;
import com.oss.metadata.*;
import cciiftn.*;

/**
 * Define the ASN1 Type FTNUpldTran from ASN1 Module FTNUpld.
 * @see Set
 */

public class FTNUpldTran extends Set {
    
    /**
     * The default constructor.
     */
    public FTNUpldTran()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public FTNUpldTran(IA5String mawbNbr, IA5String hawbNbr, 
		    IA5String subHouseID, Agg1 agg1, 
		    IA5String entryCategoryTypeCode, 
		    IA5String entryCategorySourceCode, 
		    IA5String entryRecurringCriteriaFlag, IA5String flightNbr, 
		    IA5String flightDate, IA5String routeNbr, 
		    IA5String routeDate, IA5String arrivalDate, 
		    IA5String clearanceLocationCode, Agg2 agg2)
    {
	setMawbNbr(mawbNbr);
	setHawbNbr(hawbNbr);
	setSubHouseID(subHouseID);
	setAgg1(agg1);
	setEntryCategoryTypeCode(entryCategoryTypeCode);
	setEntryCategorySourceCode(entryCategorySourceCode);
	setEntryRecurringCriteriaFlag(entryRecurringCriteriaFlag);
	setFlightNbr(flightNbr);
	setFlightDate(flightDate);
	setRouteNbr(routeNbr);
	setRouteDate(routeDate);
	setArrivalDate(arrivalDate);
	setClearanceLocationCode(clearanceLocationCode);
	setAgg2(agg2);
    }
    
    public void initComponents()
    {
	mComponents[0] = new IA5String();
	mComponents[1] = new IA5String();
	mComponents[2] = new IA5String();
	mComponents[3] = new IA5String();
	mComponents[4] = new IA5String();
	mComponents[5] = new IA5String();
	mComponents[6] = new Agg1();
	mComponents[7] = new IA5String();
	mComponents[8] = new IA5String();
	mComponents[9] = new IA5String();
	mComponents[10] = new IA5String();
	mComponents[11] = new IA5String();
	mComponents[12] = new IA5String();
	mComponents[13] = new Agg2();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[14];
    }
    
    
    // Methods for field "flightNbr"
    public IA5String getFlightNbr()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setFlightNbr(IA5String flightNbr)
    {
	mComponents[0] = flightNbr;
    }
    
    public boolean hasFlightNbr()
    {
	return componentIsPresent(0);
    }
    
    public void deleteFlightNbr()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "clearanceLocationCode"
    public IA5String getClearanceLocationCode()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setClearanceLocationCode(IA5String clearanceLocationCode)
    {
	mComponents[1] = clearanceLocationCode;
    }
    
    public boolean hasClearanceLocationCode()
    {
	return componentIsPresent(1);
    }
    
    public void deleteClearanceLocationCode()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "hawbNbr"
    public IA5String getHawbNbr()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setHawbNbr(IA5String hawbNbr)
    {
	mComponents[2] = hawbNbr;
    }
    
    public boolean hasHawbNbr()
    {
	return componentIsPresent(2);
    }
    
    public void deleteHawbNbr()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "flightDate"
    public IA5String getFlightDate()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setFlightDate(IA5String flightDate)
    {
	mComponents[3] = flightDate;
    }
    
    public boolean hasFlightDate()
    {
	return componentIsPresent(3);
    }
    
    public void deleteFlightDate()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "mawbNbr"
    public IA5String getMawbNbr()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setMawbNbr(IA5String mawbNbr)
    {
	mComponents[4] = mawbNbr;
    }
    
    public boolean hasMawbNbr()
    {
	return componentIsPresent(4);
    }
    
    public void deleteMawbNbr()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "subHouseID"
    public IA5String getSubHouseID()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setSubHouseID(IA5String subHouseID)
    {
	mComponents[5] = subHouseID;
    }
    
    public boolean hasSubHouseID()
    {
	return componentIsPresent(5);
    }
    
    public void deleteSubHouseID()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "agg1"
    public Agg1 getAgg1()
    {
	return (Agg1)mComponents[6];
    }
    
    public void setAgg1(Agg1 agg1)
    {
	mComponents[6] = agg1;
    }
    
    public boolean hasAgg1()
    {
	return componentIsPresent(6);
    }
    
    public void deleteAgg1()
    {
	setComponentAbsent(6);
    }
    
    
    
    /**
     * Define the ASN1 Type Agg1 from ASN1 Module FTNUpld.
     * @see SetOf
     */
    public static class Agg1 extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public Agg1()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public Agg1(BrokerIntercepts[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(BrokerIntercepts element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(BrokerIntercepts element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized BrokerIntercepts get(int atIndex)
	{
	    return (BrokerIntercepts)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(BrokerIntercepts element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(BrokerIntercepts element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new BrokerIntercepts();
	}
	
	/**
	 * Initialize the type descriptor.
	 */
	private static final ContainerInfo c_typeinfo = new ContainerInfo (
	    new Tags (
		new short[] {
		    (short)0x8195
		}
	    ),
	    new QName (
		"cciiftn.ftnupld",
		"FTNUpldTran$Agg1"
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
		    "cciiftn.ftnupld",
		    "BrokerIntercepts"
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' Agg1 object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' Agg1 object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for Agg1

    // Methods for field "entryCategoryTypeCode"
    public IA5String getEntryCategoryTypeCode()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setEntryCategoryTypeCode(IA5String entryCategoryTypeCode)
    {
	mComponents[7] = entryCategoryTypeCode;
    }
    
    public boolean hasEntryCategoryTypeCode()
    {
	return componentIsPresent(7);
    }
    
    public void deleteEntryCategoryTypeCode()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "entryCategorySourceCode"
    public IA5String getEntryCategorySourceCode()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setEntryCategorySourceCode(IA5String entryCategorySourceCode)
    {
	mComponents[8] = entryCategorySourceCode;
    }
    
    public boolean hasEntryCategorySourceCode()
    {
	return componentIsPresent(8);
    }
    
    public void deleteEntryCategorySourceCode()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "entryRecurringCriteriaFlag"
    public IA5String getEntryRecurringCriteriaFlag()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setEntryRecurringCriteriaFlag(IA5String entryRecurringCriteriaFlag)
    {
	mComponents[9] = entryRecurringCriteriaFlag;
    }
    
    public boolean hasEntryRecurringCriteriaFlag()
    {
	return componentIsPresent(9);
    }
    
    public void deleteEntryRecurringCriteriaFlag()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "routeNbr"
    public IA5String getRouteNbr()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setRouteNbr(IA5String routeNbr)
    {
	mComponents[10] = routeNbr;
    }
    
    public boolean hasRouteNbr()
    {
	return componentIsPresent(10);
    }
    
    public void deleteRouteNbr()
    {
	setComponentAbsent(10);
    }
    
    
    // Methods for field "routeDate"
    public IA5String getRouteDate()
    {
	return (IA5String)mComponents[11];
    }
    
    public void setRouteDate(IA5String routeDate)
    {
	mComponents[11] = routeDate;
    }
    
    public boolean hasRouteDate()
    {
	return componentIsPresent(11);
    }
    
    public void deleteRouteDate()
    {
	setComponentAbsent(11);
    }
    
    
    // Methods for field "arrivalDate"
    public IA5String getArrivalDate()
    {
	return (IA5String)mComponents[12];
    }
    
    public void setArrivalDate(IA5String arrivalDate)
    {
	mComponents[12] = arrivalDate;
    }
    
    public boolean hasArrivalDate()
    {
	return componentIsPresent(12);
    }
    
    public void deleteArrivalDate()
    {
	setComponentAbsent(12);
    }
    
    
    // Methods for field "agg2"
    public Agg2 getAgg2()
    {
	return (Agg2)mComponents[13];
    }
    
    public void setAgg2(Agg2 agg2)
    {
	mComponents[13] = agg2;
    }
    
    public boolean hasAgg2()
    {
	return componentIsPresent(13);
    }
    
    public void deleteAgg2()
    {
	setComponentAbsent(13);
    }
    
    
    
    /**
     * Define the ASN1 Type Agg2 from ASN1 Module FTNUpld.
     * @see SetOf
     */
    public static class Agg2 extends SetOf {
	
	/**
	 * The default constructor.
	 */
	public Agg2()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public Agg2(InterceptingAgencies[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Add an Element to the SEQUENCE OF/SET OF.
	 */
	public synchronized void add(InterceptingAgencies element)
	{
	    super.addElement(element);
	}
	
	/**
	 * Set an Element in the SEQUENCE OF/SET OF.
	 */
	public synchronized void set(InterceptingAgencies element, int atIndex)
	{
	    super.setElement(element, atIndex);
	}
	
	/**
	 * Get an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized InterceptingAgencies get(int atIndex)
	{
	    return (InterceptingAgencies)super.getElement(atIndex);
	}
	
	/**
	 * Insert an Element into the SEQUENCE OF/SET OF.
	 */
	public synchronized void insert(InterceptingAgencies element, int atIndex)
	{
	    super.insertElement(element, atIndex);
	}
	
	/**
	 * Remove an Element from the SEQUENCE OF/SET OF.
	 */
	public synchronized void remove(InterceptingAgencies element)
	{
	    super.removeElement(element);
	}
	
	/**
	 * Create an instance of  SEQUENCE OF/SET OF.
	 */
	public AbstractData createInstance()
	{
	    return (AbstractData)new InterceptingAgencies();
	}
	
	/**
	 * Initialize the type descriptor.
	 */
	private static final ContainerInfo c_typeinfo = new ContainerInfo (
	    new Tags (
		new short[] {
		    (short)0x819c
		}
	    ),
	    new QName (
		"cciiftn.ftnupld",
		"FTNUpldTran$Agg2"
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
		    "cciiftn.ftnupld",
		    "InterceptingAgencies"
		)
	    )
	);
	
	/**
	 * Get the type descriptor (TypeInfo) of 'this' Agg2 object.
	 */
	public TypeInfo getTypeInfo()
	{
	    return c_typeinfo;
	}
	
	/**
	 * Get the static type descriptor (TypeInfo) of 'this' Agg2 object.
	 */
	public static TypeInfo getStaticTypeInfo()
	{
	    return c_typeinfo;
	}
	
    } // End class definition for Agg2

    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		0x48ae
	    }
	),
	new QName (
	    "cciiftn.ftnupld",
	    "FTNUpldTran"
	),
	new QName (
	    "FTNUpld",
	    "FTNUpldTran"
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
		    "flightNbr",
		    0,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80e4
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
		    "clearanceLocationCode",
		    1,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x80fa
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
		    "hawbNbr",
		    2,
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
		    "flightDate",
		    3,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8193
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
		    "mawbNbr",
		    4,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8194
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
		    "subHouseID",
		    5,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "cciiftn.ftnupld",
			    "FTNUpldTran$Agg1"
			)
		    ),
		    "agg1",
		    6,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8196
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
		    "entryCategoryTypeCode",
		    7,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8197
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
		    "entryCategorySourceCode",
		    8,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8198
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
		    "entryRecurringCriteriaFlag",
		    9,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8199
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
		    "routeNbr",
		    10,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x819a
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
		    "routeDate",
		    11,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x819b
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
		    "arrivalDate",
		    12,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new QName (
			    "cciiftn.ftnupld",
			    "FTNUpldTran$Agg2"
			)
		    ),
		    "agg2",
		    13,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x807d, 0),
		new TagDecoderElement((short)0x80e4, 1),
		new TagDecoderElement((short)0x80fa, 2),
		new TagDecoderElement((short)0x8136, 3),
		new TagDecoderElement((short)0x8193, 4),
		new TagDecoderElement((short)0x8194, 5),
		new TagDecoderElement((short)0x8195, 6),
		new TagDecoderElement((short)0x8196, 7),
		new TagDecoderElement((short)0x8197, 8),
		new TagDecoderElement((short)0x8198, 9),
		new TagDecoderElement((short)0x8199, 10),
		new TagDecoderElement((short)0x819a, 11),
		new TagDecoderElement((short)0x819b, 12),
		new TagDecoderElement((short)0x819c, 13)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' FTNUpldTran object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' FTNUpldTran object.
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
    
} // End class definition for FTNUpldTran
