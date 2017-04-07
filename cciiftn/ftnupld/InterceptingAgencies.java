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
 * Define the ASN1 Type InterceptingAgencies from ASN1 Module FTNUpld.
 * @see Set
 */

public class InterceptingAgencies extends Set {
    
    /**
     * The default constructor.
     */
    public InterceptingAgencies()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public InterceptingAgencies(IA5String agencyCode)
    {
	setAgencyCode(agencyCode);
    }
    
    public void initComponents()
    {
	mComponents[0] = new IA5String();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[1];
    }
    
    
    // Methods for field "agencyCode"
    public IA5String getAgencyCode()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setAgencyCode(IA5String agencyCode)
    {
	mComponents[0] = agencyCode;
    }
    
    public boolean hasAgencyCode()
    {
	return componentIsPresent(0);
    }
    
    public void deleteAgencyCode()
    {
	setComponentAbsent(0);
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
	    "InterceptingAgencies"
	),
	new QName (
	    "FTNUpld",
	    "InterceptingAgencies"
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
				    (short)0x813b
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
		    "agencyCode",
		    0,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x813b, 0)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' InterceptingAgencies object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' InterceptingAgencies object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
} // End class definition for InterceptingAgencies
