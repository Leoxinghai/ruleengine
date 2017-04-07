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


package cciicons;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Cciicons extends XASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	new PDUDecoder (
	    new PDUDecoderElement[] {
		new PDUDecoderElement (
		    (short)0x4001,
		    new QName (
			"cciicons.consdwnld",
			"ConsDwnldTran"
		    )
		)
	    }
	),
	new byte[] {
	    (byte)0x0b, (byte)0x51, (byte)0x59, (byte)0x0d, (byte)0x5a,
	    (byte)0xa2, (byte)0x98, (byte)0xad, (byte)0xc5, (byte)0xa3,
	    (byte)0x98, (byte)0xad, (byte)0xc5, (byte)0x5c, (byte)0xef,
	    (byte)0x54, (byte)0xbb, (byte)0xc8, (byte)0xe8, (byte)0x37,
	    (byte)0x92, (byte)0x0d, (byte)0x13, (byte)0x95, (byte)0x00,
	    (byte)0x96, (byte)0xba, (byte)0xf2, (byte)0xf0, (byte)0xb2,
	    (byte)0xd0, (byte)0x18, (byte)0xc4, (byte)0x07, (byte)0x67,
	    (byte)0x86, (byte)0x3d, (byte)0xe8, (byte)0x8d, (byte)0x16,
	    (byte)0x36, (byte)0xc1, (byte)0x90, (byte)0xd8, (byte)0x1d,
	    (byte)0x97, (byte)0xde, (byte)0xa9, (byte)0xb2, (byte)0xeb,
	    (byte)0x3f, (byte)0xf4, (byte)0x13, (byte)0xc3, (byte)0x07,
	    (byte)0xff, (byte)0xaa, (byte)0xec, (byte)0x96, (byte)0x0d,
	    (byte)0x1c, (byte)0xc6, (byte)0x1f, (byte)0x94, (byte)0x63,
	    (byte)0xf7, (byte)0xa0, (byte)0xe9, (byte)0xbe, (byte)0xb4,
	    (byte)0xfd, (byte)0xd2, (byte)0xdd, (byte)0xbb, (byte)0x88,
	    (byte)0xd0, (byte)0x3c, (byte)0x49, (byte)0x1f, (byte)0xc2,
	    (byte)0x3d, (byte)0xd8, (byte)0x61, (byte)0xfb, (byte)0xfc,
	    (byte)0x77, (byte)0x3c, (byte)0x6c, (byte)0x65, (byte)0xdb,
	    (byte)0xe2, (byte)0xce, (byte)0xdd, (byte)0xe0, (byte)0xfa,
	    (byte)0x25, (byte)0x98, (byte)0x9f, (byte)0xfe, (byte)0xbc,
	    (byte)0x49, (byte)0xbb, (byte)0xa9, (byte)0xcd, (byte)0xf7,
	    (byte)0xc2, (byte)0x1b, (byte)0xc9, (byte)0x97, (byte)0x08,
	    (byte)0xb0, (byte)0xa7, (byte)0x8b, (byte)0x15, (byte)0xd6,
	    (byte)0xd0, (byte)0x95, (byte)0xff, (byte)0x5b, (byte)0xc0,
	    (byte)0x5d, (byte)0x82, (byte)0x31, (byte)0xe6, (byte)0x1c,
	    (byte)0x99, (byte)0x80, (byte)0x62, (byte)0xe8, (byte)0xae,
	    (byte)0x34, (byte)0x2d, (byte)0x33, (byte)0xdb, (byte)0x98,
	    (byte)0x5e, (byte)0xdf, (byte)0x3a, (byte)0x4c, (byte)0xc4,
	    (byte)0xb2, (byte)0x09, (byte)0xe1, (byte)0xf4, (byte)0xb5,
	    (byte)0xc3, (byte)0x42, (byte)0xbf, (byte)0x5e, (byte)0xdb,
	    (byte)0xf9, (byte)0x8d, (byte)0x99, (byte)0x16
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
		    "ConsDwnldTran",
		    new QName (
			"cciicons.consdwnld",
			"ConsDwnldTran"
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
    
    private static final ASN1Project c_project = new Cciicons();

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
