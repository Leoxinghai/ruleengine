/*************************************************************/
/* Copyright (C) 2004 OSS Nokalva, Inc.  All rights reserved.*/
/*************************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA, INC.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA, INC.
 * THIS FILE MAY NOT BE DISTRIBUTED. */

/* Generated for: Federal Express Worldwide Agreement, Memphis, TN - PJ 9820,21,22; 1Step 9823,24; C 9825,26,27,28,29,30 */
/* Abstract syntax: cciibts */
/* ASN.1 Java project: cciibts.Cciibts */
/* Created: Thu Aug 12 08:37:42 2004 */
/* ASN.1 Pure Java Compiler version: 2.0 */
/* ASN.1 compiler options and file names specified:
 * -output cciibts cciiBTS.asn
 */


package cciibts;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Cciibts extends XASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	new PDUDecoder (
	    new PDUDecoderElement[] {
		new PDUDecoderElement (
		    (short)0x43e8,
		    new QName (
			"cciibts.btsdwnld",
			"BTSDwnldTran"
		    )
		)
	    }
	),
	new byte[] {
	    (byte)0x0b, (byte)0xcd, (byte)0x27, (byte)0x27, (byte)0xb1,
	    (byte)0x54, (byte)0x11, (byte)0xd8, (byte)0x82, (byte)0x55,
	    (byte)0x11, (byte)0xd8, (byte)0x82, (byte)0x0f, (byte)0x63,
	    (byte)0x83, (byte)0xda, (byte)0x07, (byte)0xa2, (byte)0x06,
	    (byte)0xb6, (byte)0xe8, (byte)0x03, (byte)0x10, (byte)0x51,
	    (byte)0xeb, (byte)0x2b, (byte)0x6e, (byte)0xe9, (byte)0xdc,
	    (byte)0x89, (byte)0x7c, (byte)0xe6, (byte)0xe4, (byte)0x33,
	    (byte)0x87, (byte)0xd7, (byte)0xd7, (byte)0x4b, (byte)0xf1,
	    (byte)0xed, (byte)0xc7, (byte)0x69, (byte)0xdb, (byte)0x0e,
	    (byte)0xaf, (byte)0x78, (byte)0x9b, (byte)0xab, (byte)0x8b,
	    (byte)0x0a, (byte)0x9d, (byte)0xda, (byte)0xd0, (byte)0x92,
	    (byte)0x44, (byte)0x78, (byte)0xcc, (byte)0x8f, (byte)0x44,
	    (byte)0x88, (byte)0x5c, (byte)0x93, (byte)0xba, (byte)0xb8,
	    (byte)0x39, (byte)0xe0, (byte)0xf8, (byte)0x1d, (byte)0xfd,
	    (byte)0x3e, (byte)0x4b, (byte)0xef, (byte)0x96, (byte)0xed,
	    (byte)0xbc, (byte)0xe2, (byte)0x08, (byte)0xdc, (byte)0xda,
	    (byte)0x4b, (byte)0x66, (byte)0x13, (byte)0xef, (byte)0x42,
	    (byte)0x0c, (byte)0xf3, (byte)0x88, (byte)0xb8, (byte)0x9c,
	    (byte)0xe8, (byte)0x79, (byte)0x39, (byte)0xa3, (byte)0x94,
	    (byte)0x30, (byte)0xae, (byte)0xd7, (byte)0x3b, (byte)0x50,
	    (byte)0x38, (byte)0x8f, (byte)0x70, (byte)0xb7, (byte)0xfc,
	    (byte)0xa9, (byte)0x5f, (byte)0xfb, (byte)0x83, (byte)0x6d,
	    (byte)0x42, (byte)0x7d, (byte)0xbe, (byte)0x16, (byte)0x0e,
	    (byte)0x51, (byte)0xc4, (byte)0x8c, (byte)0x9f, (byte)0x48,
	    (byte)0xf6, (byte)0xcc, (byte)0xfb, (byte)0x43, (byte)0x65,
	    (byte)0x69, (byte)0x80, (byte)0x09, (byte)0xd0, (byte)0x09,
	    (byte)0xaf, (byte)0xae, (byte)0xeb, (byte)0x1a, (byte)0x85,
	    (byte)0x6a, (byte)0xe8, (byte)0x1e, (byte)0x65, (byte)0x43,
	    (byte)0x52, (byte)0x22, (byte)0x5f, (byte)0x9f, (byte)0xf8,
	    (byte)0x31, (byte)0x80, (byte)0x7c, (byte)0x39, (byte)0x3c,
	    (byte)0xa4, (byte)0xc7, (byte)0x4d, (byte)0xe8, (byte)0xf9,
	    (byte)0xc2, (byte)0x1c, (byte)0x33
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
		    "BTSDwnldTran",
		    new QName (
			"cciibts.btsdwnld",
			"BTSDwnldTran"
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
    
    private static final ASN1Project c_project = new Cciibts();

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
