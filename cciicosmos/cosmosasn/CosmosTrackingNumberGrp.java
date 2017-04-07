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
 * Define the ASN1 Type CosmosTrackingNumberGrp from ASN1 Module CosmosAsn.
 * @see Set
 */

public class CosmosTrackingNumberGrp extends Set {
    
    /**
     * The default constructor.
     */
    public CosmosTrackingNumberGrp()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public CosmosTrackingNumberGrp(IA5String trackingNbr, IA5String typeCd, 
		    IA5String formCd, IA5String astraLabelScannedFlg, 
		    IA5String trackingItemTime, IA5String dconDate, 
		    IA5String dconTime, IA5String formatCd, 
		    IA5String associationType, IA5String assocAirbillUniqueId, 
		    IA5String astraLabelData)
    {
	setTrackingNbr(trackingNbr);
	setTypeCd(typeCd);
	setFormCd(formCd);
	setAstraLabelScannedFlg(astraLabelScannedFlg);
	setTrackingItemTime(trackingItemTime);
	setDconDate(dconDate);
	setDconTime(dconTime);
	setFormatCd(formatCd);
	setAssociationType(associationType);
	setAssocAirbillUniqueId(assocAirbillUniqueId);
	setAstraLabelData(astraLabelData);
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
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[11];
    }
    
    
    // Methods for field "trackingNbr"
    public IA5String getTrackingNbr()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setTrackingNbr(IA5String trackingNbr)
    {
	mComponents[0] = trackingNbr;
    }
    
    public boolean hasTrackingNbr()
    {
	return componentIsPresent(0);
    }
    
    public void deleteTrackingNbr()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "typeCd"
    public IA5String getTypeCd()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setTypeCd(IA5String typeCd)
    {
	mComponents[1] = typeCd;
    }
    
    public boolean hasTypeCd()
    {
	return componentIsPresent(1);
    }
    
    public void deleteTypeCd()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "formCd"
    public IA5String getFormCd()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setFormCd(IA5String formCd)
    {
	mComponents[2] = formCd;
    }
    
    public boolean hasFormCd()
    {
	return componentIsPresent(2);
    }
    
    public void deleteFormCd()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "astraLabelScannedFlg"
    public IA5String getAstraLabelScannedFlg()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setAstraLabelScannedFlg(IA5String astraLabelScannedFlg)
    {
	mComponents[3] = astraLabelScannedFlg;
    }
    
    public boolean hasAstraLabelScannedFlg()
    {
	return componentIsPresent(3);
    }
    
    public void deleteAstraLabelScannedFlg()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "trackingItemTime"
    public IA5String getTrackingItemTime()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setTrackingItemTime(IA5String trackingItemTime)
    {
	mComponents[4] = trackingItemTime;
    }
    
    public boolean hasTrackingItemTime()
    {
	return componentIsPresent(4);
    }
    
    public void deleteTrackingItemTime()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "dconDate"
    public IA5String getDconDate()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setDconDate(IA5String dconDate)
    {
	mComponents[5] = dconDate;
    }
    
    public boolean hasDconDate()
    {
	return componentIsPresent(5);
    }
    
    public void deleteDconDate()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "dconTime"
    public IA5String getDconTime()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setDconTime(IA5String dconTime)
    {
	mComponents[6] = dconTime;
    }
    
    public boolean hasDconTime()
    {
	return componentIsPresent(6);
    }
    
    public void deleteDconTime()
    {
	setComponentAbsent(6);
    }
    
    
    // Methods for field "formatCd"
    public IA5String getFormatCd()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setFormatCd(IA5String formatCd)
    {
	mComponents[7] = formatCd;
    }
    
    public boolean hasFormatCd()
    {
	return componentIsPresent(7);
    }
    
    public void deleteFormatCd()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "associationType"
    public IA5String getAssociationType()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setAssociationType(IA5String associationType)
    {
	mComponents[8] = associationType;
    }
    
    public boolean hasAssociationType()
    {
	return componentIsPresent(8);
    }
    
    public void deleteAssociationType()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "assocAirbillUniqueId"
    public IA5String getAssocAirbillUniqueId()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setAssocAirbillUniqueId(IA5String assocAirbillUniqueId)
    {
	mComponents[9] = assocAirbillUniqueId;
    }
    
    public boolean hasAssocAirbillUniqueId()
    {
	return componentIsPresent(9);
    }
    
    public void deleteAssocAirbillUniqueId()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "astraLabelData"
    public IA5String getAstraLabelData()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setAstraLabelData(IA5String astraLabelData)
    {
	mComponents[10] = astraLabelData;
    }
    
    public boolean hasAstraLabelData()
    {
	return componentIsPresent(10);
    }
    
    public void deleteAstraLabelData()
    {
	setComponentAbsent(10);
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
	    "cciicosmos.cosmosasn",
	    "CosmosTrackingNumberGrp"
	),
	new QName (
	    "CosmosAsn",
	    "CosmosTrackingNumberGrp"
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
		    "trackingNbr",
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
		    "typeCd",
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
		    "formCd",
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
		    "astraLabelScannedFlg",
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
		    "trackingItemTime",
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
		    "dconDate",
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
		    "dconTime",
		    6,
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
		    "formatCd",
		    7,
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
		    "associationType",
		    8,
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
		    "assocAirbillUniqueId",
		    9,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x82e5
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
		    10,
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
		new TagDecoderElement((short)0x8006, 6),
		new TagDecoderElement((short)0x8007, 7),
		new TagDecoderElement((short)0x8008, 8),
		new TagDecoderElement((short)0x8009, 9),
		new TagDecoderElement((short)0x82e5, 10)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' CosmosTrackingNumberGrp object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' CosmosTrackingNumberGrp object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
} // End class definition for CosmosTrackingNumberGrp
