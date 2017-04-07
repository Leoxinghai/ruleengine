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


package imageRequestASN;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Imagerequestasn extends ASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	new PDUDecoder (
	    new PDUDecoderElement[] {
		new PDUDecoderElement (
		    (short)0x4287,
		    new QName (
			"imageRequestASN.ddtran",
			"ASNrequest"
		    )
		)
	    }
	),
	new byte[] {
	    (byte)0x0b, (byte)0x28, (byte)0xa6, (byte)0x24, (byte)0x52,
	    (byte)0xa3, (byte)0xc5, (byte)0x6a, (byte)0xd2, (byte)0xa2,
	    (byte)0xc5, (byte)0x6a, (byte)0xd2, (byte)0x0a, (byte)0x22,
	    (byte)0xcd, (byte)0x40, (byte)0x24, (byte)0x13, (byte)0x2e,
	    (byte)0x56, (byte)0xbf, (byte)0x7e, (byte)0x1a, (byte)0x7d,
	    (byte)0x04, (byte)0x30, (byte)0x4d, (byte)0xab, (byte)0x3c,
	    (byte)0xe2, (byte)0xa8, (byte)0xa4, (byte)0x1d, (byte)0xea,
	    (byte)0xc5, (byte)0x85, (byte)0xee, (byte)0xea, (byte)0x3a,
	    (byte)0xe8, (byte)0xa8, (byte)0xbc, (byte)0x87, (byte)0x13,
	    (byte)0x4f, (byte)0xe5, (byte)0xf3, (byte)0x34, (byte)0x0f,
	    (byte)0x37, (byte)0x35, (byte)0x88, (byte)0xbd, (byte)0x20,
	    (byte)0x56, (byte)0x2d, (byte)0x78, (byte)0xbc, (byte)0xac,
	    (byte)0x58, (byte)0x7d, (byte)0x64, (byte)0xc8, (byte)0x2a,
	    (byte)0xf6, (byte)0xf9, (byte)0x49, (byte)0xb3, (byte)0x07,
	    (byte)0xdd, (byte)0xde, (byte)0x26, (byte)0x30, (byte)0x5b,
	    (byte)0xae, (byte)0xaf, (byte)0x67, (byte)0x0e, (byte)0x42,
	    (byte)0xec, (byte)0x38, (byte)0x2b, (byte)0x19, (byte)0xb7,
	    (byte)0xa8, (byte)0x59, (byte)0x6b, (byte)0x87, (byte)0x33,
	    (byte)0x9c, (byte)0x8e, (byte)0x15, (byte)0xb3, (byte)0x6d,
	    (byte)0xb5, (byte)0x16, (byte)0x60, (byte)0x6a, (byte)0x48,
	    (byte)0x8d, (byte)0x8c, (byte)0xfb, (byte)0x9d, (byte)0x19,
	    (byte)0x43, (byte)0x74, (byte)0x4e, (byte)0xa5, (byte)0x49,
	    (byte)0x47, (byte)0x1a, (byte)0x83, (byte)0x78, (byte)0x8a,
	    (byte)0x5a, (byte)0xfe, (byte)0x1c, (byte)0xda, (byte)0x53,
	    (byte)0xe9, (byte)0xb1, (byte)0xd4
	}
    );
    
    /**
     * Get the project descriptor of 'this' object.
     */
    public ProjectInfo getProjectInfo()
    {
	return c_projectInfo;
    }
    
    private static final ASN1Project c_project = new Imagerequestasn();

    /**
     * Methods for accessing Coders.
     */
    public static Coder getDefaultCoder()
    {
	return createBERCoder(c_project);
    }
    
    // No coder specified
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
    
}
