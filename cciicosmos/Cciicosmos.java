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


package cciicosmos;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Cciicosmos extends XASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	new PDUDecoder (
	    new PDUDecoderElement[] {
		new PDUDecoderElement (
		    (short)0x4002,
		    new QName (
			"cciicosmos.cosmosasn",
			"CosmosMasterGrp"
		    )
		)
	    }
	),
	new byte[] {
	    (byte)0x0b, (byte)0x53, (byte)0xd6, (byte)0x1c, (byte)0x88,
	    (byte)0x25, (byte)0xb9, (byte)0x76, (byte)0x2d, (byte)0x24,
	    (byte)0xb9, (byte)0x76, (byte)0x2d, (byte)0x0c, (byte)0x6c,
	    (byte)0x01, (byte)0x8d, (byte)0xa8, (byte)0xd0, (byte)0xc2,
	    (byte)0x45, (byte)0xa9, (byte)0x1c, (byte)0x50, (byte)0xb7,
	    (byte)0xc1, (byte)0x1e, (byte)0xa1, (byte)0x0d, (byte)0xe8,
	    (byte)0x7c, (byte)0x4e, (byte)0x79, (byte)0xbe, (byte)0xf5,
	    (byte)0x3e, (byte)0x35, (byte)0x88, (byte)0xfd, (byte)0x17,
	    (byte)0x52, (byte)0xbb, (byte)0x95, (byte)0x3a, (byte)0xc2,
	    (byte)0xca, (byte)0xe3, (byte)0xfe, (byte)0xec, (byte)0x09,
	    (byte)0x8b, (byte)0x14, (byte)0xf1, (byte)0x4f, (byte)0xa8,
	    (byte)0x4b, (byte)0x48, (byte)0x9e, (byte)0xb7, (byte)0x9b,
	    (byte)0x62, (byte)0xea, (byte)0xb7, (byte)0x2e, (byte)0x0d,
	    (byte)0x9b, (byte)0x5d, (byte)0x57, (byte)0xa9, (byte)0xac,
	    (byte)0x3e, (byte)0xbc, (byte)0x19, (byte)0x34, (byte)0x82,
	    (byte)0x70, (byte)0x34, (byte)0x9b, (byte)0x7d, (byte)0x6b,
	    (byte)0xc3, (byte)0x68, (byte)0x59, (byte)0x3f, (byte)0x26,
	    (byte)0xf2, (byte)0xf6, (byte)0x4f, (byte)0x55, (byte)0x1a,
	    (byte)0xe6, (byte)0x56, (byte)0x89, (byte)0x6b, (byte)0x79,
	    (byte)0x5e, (byte)0xe6, (byte)0xa5, (byte)0x33, (byte)0x16,
	    (byte)0x8c, (byte)0xd3, (byte)0x15, (byte)0xbc, (byte)0x62,
	    (byte)0x83, (byte)0x7e, (byte)0xd3, (byte)0xa3, (byte)0xc0,
	    (byte)0x96, (byte)0x85, (byte)0x9c, (byte)0x48, (byte)0xb9,
	    (byte)0x06, (byte)0x0d, (byte)0x2c, (byte)0xe6, (byte)0x0e,
	    (byte)0xe8, (byte)0x99, (byte)0x17, (byte)0x2f, (byte)0xa7,
	    (byte)0x16, (byte)0xd8, (byte)0x0b, (byte)0x63, (byte)0xa7,
	    (byte)0x2c, (byte)0xd6, (byte)0xf7, (byte)0xd4, (byte)0x73,
	    (byte)0x2c, (byte)0xe9, (byte)0xe3, (byte)0xca, (byte)0xbd,
	    (byte)0xe6, (byte)0xcd, (byte)0xdf, (byte)0xb4, (byte)0x8a,
	    (byte)0xc7, (byte)0xd7, (byte)0x6b, (byte)0x36, (byte)0xa9,
	    (byte)0xe1, (byte)0x25, (byte)0x4f, (byte)0x20, (byte)0x19,
	    (byte)0xb8, (byte)0x88, (byte)0xa2
	}
    );
    
    /**
     * Get the project descriptor of 'this' object.
     */
    public ProjectInfo getProjectInfo()
    {
	return c_projectInfo;
    }
    
    /**
     * Initialize XER specific project info.
     */
    private static final XERInfo c_XERInfo = new XERInfo (
	new XPDUDecoder(
	    new XPDUDecoderElement[] {
		new XPDUDecoderElement(
		    "CosmosMasterGrp",
		    new QName (
			"cciicosmos.cosmosasn",
			"CosmosMasterGrp"
		    )
		)
	    }
	)
    );
    
    /**
     * Get the XERInfo project descriptor of 'this' object.
     */
    public XERInfo getXERInfo()
    {
	return c_XERInfo;
    }
    
    private static final ASN1Project c_project = new Cciicosmos();

    /**
     * Methods for accessing Coders.
     */
    public static Coder getDefaultCoder()
    {
	return createBERCoder(c_project);
    }
    
    public static BERCoder getBERCoder()
    {
	return createBERCoder(c_project);
    }
    
    public static DERCoder getDERCoder()
    {
	return createDERCoder(c_project);
    }
    
    public static PERAlignedCoder getPERAlignedCoder()
    {
	return createPERAlignedCoder(c_project);
    }
    
    public static PERUnalignedCoder getPERUnalignedCoder()
    {
	return createPERUnalignedCoder(c_project);
    }
    
    public static XERCoder getXERCoder()
    {
	return createXERCoder(c_project);
    }
    
    public static CXERCoder getCXERCoder()
    {
	return createCXERCoder(c_project);
    }
    
}
