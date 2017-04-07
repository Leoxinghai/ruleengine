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
 * Define the ASN1 Type Aggregate215 from ASN1 Module ConsDwnld.
 * @see Set
 */

public class Aggregate215 extends Set {
    
    /**
     * The default constructor.
     */
    public Aggregate215()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public Aggregate215(IA5String componentTrakNbr, IA5String componentTypeCd, 
		    IA5String componentFormTypeCd, 
		    IA5String componentEntryType, 
		    IA5String componentTimeStamp, IA5String deconsDt, 
		    IA5String deconsTm)
    {
	setComponentTrakNbr(componentTrakNbr);
	setComponentTypeCd(componentTypeCd);
	setComponentFormTypeCd(componentFormTypeCd);
	setComponentEntryType(componentEntryType);
	setComponentTimeStamp(componentTimeStamp);
	setDeconsDt(deconsDt);
	setDeconsTm(deconsTm);
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
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[7];
    }
    
    
    // Methods for field "componentTrakNbr"
    public IA5String getComponentTrakNbr()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setComponentTrakNbr(IA5String componentTrakNbr)
    {
	mComponents[0] = componentTrakNbr;
    }
    
    public boolean hasComponentTrakNbr()
    {
	return componentIsPresent(0);
    }
    
    public void deleteComponentTrakNbr()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "componentTypeCd"
    public IA5String getComponentTypeCd()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setComponentTypeCd(IA5String componentTypeCd)
    {
	mComponents[1] = componentTypeCd;
    }
    
    public boolean hasComponentTypeCd()
    {
	return componentIsPresent(1);
    }
    
    public void deleteComponentTypeCd()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "componentFormTypeCd"
    public IA5String getComponentFormTypeCd()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setComponentFormTypeCd(IA5String componentFormTypeCd)
    {
	mComponents[2] = componentFormTypeCd;
    }
    
    public boolean hasComponentFormTypeCd()
    {
	return componentIsPresent(2);
    }
    
    public void deleteComponentFormTypeCd()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "componentEntryType"
    public IA5String getComponentEntryType()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setComponentEntryType(IA5String componentEntryType)
    {
	mComponents[3] = componentEntryType;
    }
    
    public boolean hasComponentEntryType()
    {
	return componentIsPresent(3);
    }
    
    public void deleteComponentEntryType()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "componentTimeStamp"
    public IA5String getComponentTimeStamp()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setComponentTimeStamp(IA5String componentTimeStamp)
    {
	mComponents[4] = componentTimeStamp;
    }
    
    public boolean hasComponentTimeStamp()
    {
	return componentIsPresent(4);
    }
    
    public void deleteComponentTimeStamp()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "deconsDt"
    public IA5String getDeconsDt()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setDeconsDt(IA5String deconsDt)
    {
	mComponents[5] = deconsDt;
    }
    
    public boolean hasDeconsDt()
    {
	return componentIsPresent(5);
    }
    
    public void deleteDeconsDt()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "deconsTm"
    public IA5String getDeconsTm()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setDeconsTm(IA5String deconsTm)
    {
	mComponents[6] = deconsTm;
    }
    
    public boolean hasDeconsTm()
    {
	return componentIsPresent(6);
    }
    
    public void deleteDeconsTm()
    {
	setComponentAbsent(6);
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
	    "cciicons.consdwnld",
	    "Aggregate215"
	),
	new QName (
	    "ConsDwnld",
	    "Aggregate215"
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
				    (short)0x8000
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
		    "componentTrakNbr",
		    0,
		    3,
		    null
		),
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
		    "componentTypeCd",
		    1,
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
		    "componentFormTypeCd",
		    2,
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
		    "componentEntryType",
		    3,
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
		    "componentTimeStamp",
		    4,
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
		    "deconsDt",
		    5,
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
		    "deconsTm",
		    6,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8000, 0),
		new TagDecoderElement((short)0x8001, 1),
		new TagDecoderElement((short)0x8002, 2),
		new TagDecoderElement((short)0x8003, 3),
		new TagDecoderElement((short)0x8004, 4),
		new TagDecoderElement((short)0x8005, 5),
		new TagDecoderElement((short)0x8006, 6)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' Aggregate215 object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' Aggregate215 object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
} // End class definition for Aggregate215
