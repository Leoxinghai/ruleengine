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


package cciiftn;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Cciiftn extends XASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	new PDUDecoder (
	    new PDUDecoderElement[] {
		new PDUDecoderElement (
		    (short)0x48ae,
		    new QName (
			"cciiftn.ftnupld",
			"FTNUpldTran"
		    )
		)
	    }
	),
	new byte[] {
	    (byte)0x0b, (byte)0x09, (byte)0x7d, (byte)0x6a, (byte)0x2f,
	    (byte)0xf0, (byte)0xc8, (byte)0x95, (byte)0x1c, (byte)0xf1,
	    (byte)0xc8, (byte)0x95, (byte)0x1c, (byte)0x29, (byte)0x5d,
	    (byte)0xd9, (byte)0x2a, (byte)0xcf, (byte)0x86, (byte)0x84,
	    (byte)0xa1, (byte)0x5e, (byte)0xca, (byte)0x53, (byte)0x51,
	    (byte)0xe9, (byte)0xaf, (byte)0x1c, (byte)0x0d, (byte)0x1e,
	    (byte)0x27, (byte)0x73, (byte)0xbd, (byte)0xf2, (byte)0x5b,
	    (byte)0xff, (byte)0x7c, (byte)0x8b, (byte)0x71, (byte)0x25,
	    (byte)0xea, (byte)0xcd, (byte)0x68, (byte)0x6a, (byte)0xce,
	    (byte)0x12, (byte)0x50, (byte)0x77, (byte)0xd2, (byte)0x63,
	    (byte)0x5b, (byte)0xf5, (byte)0x77, (byte)0x6b, (byte)0xeb,
	    (byte)0x58, (byte)0xc8, (byte)0xfa, (byte)0x50, (byte)0x25,
	    (byte)0x90, (byte)0x79, (byte)0x3e, (byte)0x08, (byte)0xfd,
	    (byte)0xd5, (byte)0xd5, (byte)0xcb, (byte)0xac, (byte)0xe3,
	    (byte)0x2c, (byte)0x6f, (byte)0x37, (byte)0xe9, (byte)0xff,
	    (byte)0x6d, (byte)0x82, (byte)0x2c, (byte)0x38, (byte)0x2e,
	    (byte)0x1e, (byte)0x6c, (byte)0xcd, (byte)0xdf, (byte)0xdb,
	    (byte)0xe7, (byte)0x23, (byte)0x6a, (byte)0x69, (byte)0xa8,
	    (byte)0x7e, (byte)0x8d, (byte)0xaa, (byte)0xc3, (byte)0x95,
	    (byte)0x45, (byte)0x49, (byte)0xf2, (byte)0x01, (byte)0x0f,
	    (byte)0x40, (byte)0xc3, (byte)0xe4, (byte)0xc8, (byte)0x3e,
	    (byte)0x64, (byte)0x21, (byte)0x0f, (byte)0x06, (byte)0xfe,
	    (byte)0x4f, (byte)0xbf, (byte)0xf4, (byte)0xd4, (byte)0x53,
	    (byte)0x28, (byte)0xad, (byte)0x94, (byte)0x8c, (byte)0x46,
	    (byte)0xd8, (byte)0xd3, (byte)0x16, (byte)0xc0, (byte)0x2c,
	    (byte)0x0c, (byte)0xc6, (byte)0xa7, (byte)0x9c, (byte)0x77,
	    (byte)0x9d, (byte)0x70, (byte)0x09, (byte)0xa6, (byte)0x7d,
	    (byte)0xdc, (byte)0x7a, (byte)0x70, (byte)0x26, (byte)0x07,
	    (byte)0x1a, (byte)0x21, (byte)0x16, (byte)0xe3, (byte)0x49,
	    (byte)0x41, (byte)0xdb, (byte)0xa4, (byte)0xa9
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
		    "FTNUpldTran",
		    new QName (
			"cciiftn.ftnupld",
			"FTNUpldTran"
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
    
    private static final ASN1Project c_project = new Cciiftn();

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
