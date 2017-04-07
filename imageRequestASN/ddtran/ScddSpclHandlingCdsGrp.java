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
 * Define the ASN1 Type ScddSpclHandlingCdsGrp from ASN1 Module DDTRAN.
 * @see Set
 */

public class ScddSpclHandlingCdsGrp extends Set {
    
    /**
     * The default constructor.
     */
    public ScddSpclHandlingCdsGrp()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public ScddSpclHandlingCdsGrp(IA5String cddSpclHandlingCd)
    {
	setCddSpclHandlingCd(cddSpclHandlingCd);
    }
    
    public void initComponents()
    {
	mComponents[0] = new IA5String();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[1];
	mComponents[0] = null;
    }
    
    
    // Methods for field "cddSpclHandlingCd"
    public IA5String getCddSpclHandlingCd()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setCddSpclHandlingCd(IA5String cddSpclHandlingCd)
    {
	mComponents[0] = cddSpclHandlingCd;
    }
    
    public boolean hasCddSpclHandlingCd()
    {
	return componentIsPresent(0);
    }
    
    public void deleteCddSpclHandlingCd()
    {
	setComponentAbsent(0);
    }
    
    
    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		(short)0x8001
	    }
	),
	new QName (
	    "imageRequestASN.ddtran",
	    "ScddSpclHandlingCdsGrp"
	),
	new QName (
	    "DDTRAN",
	    "ScddSpclHandlingCdsGrp"
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
		    "cddSpclHandlingCd",
		    0,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8001, 0)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' ScddSpclHandlingCdsGrp object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' ScddSpclHandlingCdsGrp object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
} // End class definition for ScddSpclHandlingCdsGrp
