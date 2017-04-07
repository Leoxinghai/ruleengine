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
 * Define the ASN1 Type BrokerIntercepts from ASN1 Module FTNUpld.
 * @see Set
 */

public class BrokerIntercepts extends Set {
    
    /**
     * The default constructor.
     */
    public BrokerIntercepts()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public BrokerIntercepts(IA5String interceptCode, IA5String createDate, 
		    IA5String createEmployeeNumber, 
		    IA5String recurringCriteriaFlag, IA5String updateDate, 
		    IA5String updateEmployeeNumber)
    {
	setInterceptCode(interceptCode);
	setCreateDate(createDate);
	setCreateEmployeeNumber(createEmployeeNumber);
	setRecurringCriteriaFlag(recurringCriteriaFlag);
	setUpdateDate(updateDate);
	setUpdateEmployeeNumber(updateEmployeeNumber);
    }
    
    public void initComponents()
    {
	mComponents[0] = new IA5String();
	mComponents[1] = new IA5String();
	mComponents[2] = new IA5String();
	mComponents[3] = new IA5String();
	mComponents[4] = new IA5String();
	mComponents[5] = new IA5String();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[6];
    }
    
    
    // Methods for field "interceptCode"
    public IA5String getInterceptCode()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setInterceptCode(IA5String interceptCode)
    {
	mComponents[0] = interceptCode;
    }
    
    public boolean hasInterceptCode()
    {
	return componentIsPresent(0);
    }
    
    public void deleteInterceptCode()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "createDate"
    public IA5String getCreateDate()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setCreateDate(IA5String createDate)
    {
	mComponents[1] = createDate;
    }
    
    public boolean hasCreateDate()
    {
	return componentIsPresent(1);
    }
    
    public void deleteCreateDate()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "createEmployeeNumber"
    public IA5String getCreateEmployeeNumber()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setCreateEmployeeNumber(IA5String createEmployeeNumber)
    {
	mComponents[2] = createEmployeeNumber;
    }
    
    public boolean hasCreateEmployeeNumber()
    {
	return componentIsPresent(2);
    }
    
    public void deleteCreateEmployeeNumber()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "recurringCriteriaFlag"
    public IA5String getRecurringCriteriaFlag()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setRecurringCriteriaFlag(IA5String recurringCriteriaFlag)
    {
	mComponents[3] = recurringCriteriaFlag;
    }
    
    public boolean hasRecurringCriteriaFlag()
    {
	return componentIsPresent(3);
    }
    
    public void deleteRecurringCriteriaFlag()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "updateDate"
    public IA5String getUpdateDate()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setUpdateDate(IA5String updateDate)
    {
	mComponents[4] = updateDate;
    }
    
    public boolean hasUpdateDate()
    {
	return componentIsPresent(4);
    }
    
    public void deleteUpdateDate()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "updateEmployeeNumber"
    public IA5String getUpdateEmployeeNumber()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setUpdateEmployeeNumber(IA5String updateEmployeeNumber)
    {
	mComponents[5] = updateEmployeeNumber;
    }
    
    public boolean hasUpdateEmployeeNumber()
    {
	return componentIsPresent(5);
    }
    
    public void deleteUpdateEmployeeNumber()
    {
	setComponentAbsent(5);
    }
    
    
    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		(short)0x8000
	    }
	),
	new QName (
	    "cciiftn.ftnupld",
	    "BrokerIntercepts"
	),
	new QName (
	    "FTNUpld",
	    "BrokerIntercepts"
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
		    "interceptCode",
		    0,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x819d
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
		    "createDate",
		    1,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x819e
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
		    "createEmployeeNumber",
		    2,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x819f
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
		    "recurringCriteriaFlag",
		    3,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x81a0
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
		    "updateDate",
		    4,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x81a1
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
		    "updateEmployeeNumber",
		    5,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8136, 0),
		new TagDecoderElement((short)0x819d, 1),
		new TagDecoderElement((short)0x819e, 2),
		new TagDecoderElement((short)0x819f, 3),
		new TagDecoderElement((short)0x81a0, 4),
		new TagDecoderElement((short)0x81a1, 5)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' BrokerIntercepts object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' BrokerIntercepts object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
} // End class definition for BrokerIntercepts
