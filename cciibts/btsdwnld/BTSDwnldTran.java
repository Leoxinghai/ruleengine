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


package cciibts.btsdwnld;

import com.oss.asn1.*;
import com.oss.metadata.*;
import cciibts.*;

/**
 * Define the ASN1 Type BTSDwnldTran from ASN1 Module BTSDwnld.
 * @see Set
 */

public class BTSDwnldTran extends Set {
    
    /**
     * The default constructor.
     */
    public BTSDwnldTran()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public BTSDwnldTran(IA5String airbillNbr, IA5String formCd, 
		    IA5String serialNbr, IA5String originLoc, 
		    IA5String destinationLoc, IA5String transCd, 
		    IA5String totalPieces, IA5String transDtEst, 
		    IA5String employeeNbr, IA5String comment, 
		    IA5String reasonCd1, IA5String reasonCd2, 
		    IA5String reasonCd3, IA5String reasonCd4, 
		    IA5String reasonCd5, IA5String reasonCd6, 
		    IA5String reasonCd7, IA5String reasonCd8, 
		    IA5String entryNbr, IA5String entryType, 
		    IA5String entryDtEst, IA5String agencyCd, 
		    IA5String selectCd, IA5String errorCd, IA5String errorMsg, 
		    IA5String errorSource)
    {
	setAirbillNbr(airbillNbr);
	setFormCd(formCd);
	setSerialNbr(serialNbr);
	setOriginLoc(originLoc);
	setDestinationLoc(destinationLoc);
	setTransCd(transCd);
	setTotalPieces(totalPieces);
	setTransDtEst(transDtEst);
	setEmployeeNbr(employeeNbr);
	setComment(comment);
	setReasonCd1(reasonCd1);
	setReasonCd2(reasonCd2);
	setReasonCd3(reasonCd3);
	setReasonCd4(reasonCd4);
	setReasonCd5(reasonCd5);
	setReasonCd6(reasonCd6);
	setReasonCd7(reasonCd7);
	setReasonCd8(reasonCd8);
	setEntryNbr(entryNbr);
	setEntryType(entryType);
	setEntryDtEst(entryDtEst);
	setAgencyCd(agencyCd);
	setSelectCd(selectCd);
	setErrorCd(errorCd);
	setErrorMsg(errorMsg);
	setErrorSource(errorSource);
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
	mComponents[11] = new IA5String();
	mComponents[12] = new IA5String();
	mComponents[13] = new IA5String();
	mComponents[14] = new IA5String();
	mComponents[15] = new IA5String();
	mComponents[16] = new IA5String();
	mComponents[17] = new IA5String();
	mComponents[18] = new IA5String();
	mComponents[19] = new IA5String();
	mComponents[20] = new IA5String();
	mComponents[21] = new IA5String();
	mComponents[22] = new IA5String();
	mComponents[23] = new IA5String();
	mComponents[24] = new IA5String();
	mComponents[25] = new IA5String();
    }
    
    // Instance initializer
    {
	mComponents = new AbstractData[26];
    }
    
    
    // Methods for field "airbillNbr"
    public IA5String getAirbillNbr()
    {
	return (IA5String)mComponents[0];
    }
    
    public void setAirbillNbr(IA5String airbillNbr)
    {
	mComponents[0] = airbillNbr;
    }
    
    public boolean hasAirbillNbr()
    {
	return componentIsPresent(0);
    }
    
    public void deleteAirbillNbr()
    {
	setComponentAbsent(0);
    }
    
    
    // Methods for field "formCd"
    public IA5String getFormCd()
    {
	return (IA5String)mComponents[1];
    }
    
    public void setFormCd(IA5String formCd)
    {
	mComponents[1] = formCd;
    }
    
    public boolean hasFormCd()
    {
	return componentIsPresent(1);
    }
    
    public void deleteFormCd()
    {
	setComponentAbsent(1);
    }
    
    
    // Methods for field "serialNbr"
    public IA5String getSerialNbr()
    {
	return (IA5String)mComponents[2];
    }
    
    public void setSerialNbr(IA5String serialNbr)
    {
	mComponents[2] = serialNbr;
    }
    
    public boolean hasSerialNbr()
    {
	return componentIsPresent(2);
    }
    
    public void deleteSerialNbr()
    {
	setComponentAbsent(2);
    }
    
    
    // Methods for field "originLoc"
    public IA5String getOriginLoc()
    {
	return (IA5String)mComponents[3];
    }
    
    public void setOriginLoc(IA5String originLoc)
    {
	mComponents[3] = originLoc;
    }
    
    public boolean hasOriginLoc()
    {
	return componentIsPresent(3);
    }
    
    public void deleteOriginLoc()
    {
	setComponentAbsent(3);
    }
    
    
    // Methods for field "destinationLoc"
    public IA5String getDestinationLoc()
    {
	return (IA5String)mComponents[4];
    }
    
    public void setDestinationLoc(IA5String destinationLoc)
    {
	mComponents[4] = destinationLoc;
    }
    
    public boolean hasDestinationLoc()
    {
	return componentIsPresent(4);
    }
    
    public void deleteDestinationLoc()
    {
	setComponentAbsent(4);
    }
    
    
    // Methods for field "transCd"
    public IA5String getTransCd()
    {
	return (IA5String)mComponents[5];
    }
    
    public void setTransCd(IA5String transCd)
    {
	mComponents[5] = transCd;
    }
    
    public boolean hasTransCd()
    {
	return componentIsPresent(5);
    }
    
    public void deleteTransCd()
    {
	setComponentAbsent(5);
    }
    
    
    // Methods for field "totalPieces"
    public IA5String getTotalPieces()
    {
	return (IA5String)mComponents[6];
    }
    
    public void setTotalPieces(IA5String totalPieces)
    {
	mComponents[6] = totalPieces;
    }
    
    public boolean hasTotalPieces()
    {
	return componentIsPresent(6);
    }
    
    public void deleteTotalPieces()
    {
	setComponentAbsent(6);
    }
    
    
    // Methods for field "transDtEst"
    public IA5String getTransDtEst()
    {
	return (IA5String)mComponents[7];
    }
    
    public void setTransDtEst(IA5String transDtEst)
    {
	mComponents[7] = transDtEst;
    }
    
    public boolean hasTransDtEst()
    {
	return componentIsPresent(7);
    }
    
    public void deleteTransDtEst()
    {
	setComponentAbsent(7);
    }
    
    
    // Methods for field "employeeNbr"
    public IA5String getEmployeeNbr()
    {
	return (IA5String)mComponents[8];
    }
    
    public void setEmployeeNbr(IA5String employeeNbr)
    {
	mComponents[8] = employeeNbr;
    }
    
    public boolean hasEmployeeNbr()
    {
	return componentIsPresent(8);
    }
    
    public void deleteEmployeeNbr()
    {
	setComponentAbsent(8);
    }
    
    
    // Methods for field "comment"
    public IA5String getComment()
    {
	return (IA5String)mComponents[9];
    }
    
    public void setComment(IA5String comment)
    {
	mComponents[9] = comment;
    }
    
    public boolean hasComment()
    {
	return componentIsPresent(9);
    }
    
    public void deleteComment()
    {
	setComponentAbsent(9);
    }
    
    
    // Methods for field "reasonCd1"
    public IA5String getReasonCd1()
    {
	return (IA5String)mComponents[10];
    }
    
    public void setReasonCd1(IA5String reasonCd1)
    {
	mComponents[10] = reasonCd1;
    }
    
    public boolean hasReasonCd1()
    {
	return componentIsPresent(10);
    }
    
    public void deleteReasonCd1()
    {
	setComponentAbsent(10);
    }
    
    
    // Methods for field "reasonCd2"
    public IA5String getReasonCd2()
    {
	return (IA5String)mComponents[11];
    }
    
    public void setReasonCd2(IA5String reasonCd2)
    {
	mComponents[11] = reasonCd2;
    }
    
    public boolean hasReasonCd2()
    {
	return componentIsPresent(11);
    }
    
    public void deleteReasonCd2()
    {
	setComponentAbsent(11);
    }
    
    
    // Methods for field "reasonCd3"
    public IA5String getReasonCd3()
    {
	return (IA5String)mComponents[12];
    }
    
    public void setReasonCd3(IA5String reasonCd3)
    {
	mComponents[12] = reasonCd3;
    }
    
    public boolean hasReasonCd3()
    {
	return componentIsPresent(12);
    }
    
    public void deleteReasonCd3()
    {
	setComponentAbsent(12);
    }
    
    
    // Methods for field "reasonCd4"
    public IA5String getReasonCd4()
    {
	return (IA5String)mComponents[13];
    }
    
    public void setReasonCd4(IA5String reasonCd4)
    {
	mComponents[13] = reasonCd4;
    }
    
    public boolean hasReasonCd4()
    {
	return componentIsPresent(13);
    }
    
    public void deleteReasonCd4()
    {
	setComponentAbsent(13);
    }
    
    
    // Methods for field "reasonCd5"
    public IA5String getReasonCd5()
    {
	return (IA5String)mComponents[14];
    }
    
    public void setReasonCd5(IA5String reasonCd5)
    {
	mComponents[14] = reasonCd5;
    }
    
    public boolean hasReasonCd5()
    {
	return componentIsPresent(14);
    }
    
    public void deleteReasonCd5()
    {
	setComponentAbsent(14);
    }
    
    
    // Methods for field "reasonCd6"
    public IA5String getReasonCd6()
    {
	return (IA5String)mComponents[15];
    }
    
    public void setReasonCd6(IA5String reasonCd6)
    {
	mComponents[15] = reasonCd6;
    }
    
    public boolean hasReasonCd6()
    {
	return componentIsPresent(15);
    }
    
    public void deleteReasonCd6()
    {
	setComponentAbsent(15);
    }
    
    
    // Methods for field "reasonCd7"
    public IA5String getReasonCd7()
    {
	return (IA5String)mComponents[16];
    }
    
    public void setReasonCd7(IA5String reasonCd7)
    {
	mComponents[16] = reasonCd7;
    }
    
    public boolean hasReasonCd7()
    {
	return componentIsPresent(16);
    }
    
    public void deleteReasonCd7()
    {
	setComponentAbsent(16);
    }
    
    
    // Methods for field "reasonCd8"
    public IA5String getReasonCd8()
    {
	return (IA5String)mComponents[17];
    }
    
    public void setReasonCd8(IA5String reasonCd8)
    {
	mComponents[17] = reasonCd8;
    }
    
    public boolean hasReasonCd8()
    {
	return componentIsPresent(17);
    }
    
    public void deleteReasonCd8()
    {
	setComponentAbsent(17);
    }
    
    
    // Methods for field "entryNbr"
    public IA5String getEntryNbr()
    {
	return (IA5String)mComponents[18];
    }
    
    public void setEntryNbr(IA5String entryNbr)
    {
	mComponents[18] = entryNbr;
    }
    
    public boolean hasEntryNbr()
    {
	return componentIsPresent(18);
    }
    
    public void deleteEntryNbr()
    {
	setComponentAbsent(18);
    }
    
    
    // Methods for field "entryType"
    public IA5String getEntryType()
    {
	return (IA5String)mComponents[19];
    }
    
    public void setEntryType(IA5String entryType)
    {
	mComponents[19] = entryType;
    }
    
    public boolean hasEntryType()
    {
	return componentIsPresent(19);
    }
    
    public void deleteEntryType()
    {
	setComponentAbsent(19);
    }
    
    
    // Methods for field "entryDtEst"
    public IA5String getEntryDtEst()
    {
	return (IA5String)mComponents[20];
    }
    
    public void setEntryDtEst(IA5String entryDtEst)
    {
	mComponents[20] = entryDtEst;
    }
    
    public boolean hasEntryDtEst()
    {
	return componentIsPresent(20);
    }
    
    public void deleteEntryDtEst()
    {
	setComponentAbsent(20);
    }
    
    
    // Methods for field "agencyCd"
    public IA5String getAgencyCd()
    {
	return (IA5String)mComponents[21];
    }
    
    public void setAgencyCd(IA5String agencyCd)
    {
	mComponents[21] = agencyCd;
    }
    
    public boolean hasAgencyCd()
    {
	return componentIsPresent(21);
    }
    
    public void deleteAgencyCd()
    {
	setComponentAbsent(21);
    }
    
    
    // Methods for field "selectCd"
    public IA5String getSelectCd()
    {
	return (IA5String)mComponents[22];
    }
    
    public void setSelectCd(IA5String selectCd)
    {
	mComponents[22] = selectCd;
    }
    
    public boolean hasSelectCd()
    {
	return componentIsPresent(22);
    }
    
    public void deleteSelectCd()
    {
	setComponentAbsent(22);
    }
    
    
    // Methods for field "errorCd"
    public IA5String getErrorCd()
    {
	return (IA5String)mComponents[23];
    }
    
    public void setErrorCd(IA5String errorCd)
    {
	mComponents[23] = errorCd;
    }
    
    public boolean hasErrorCd()
    {
	return componentIsPresent(23);
    }
    
    public void deleteErrorCd()
    {
	setComponentAbsent(23);
    }
    
    
    // Methods for field "errorMsg"
    public IA5String getErrorMsg()
    {
	return (IA5String)mComponents[24];
    }
    
    public void setErrorMsg(IA5String errorMsg)
    {
	mComponents[24] = errorMsg;
    }
    
    public boolean hasErrorMsg()
    {
	return componentIsPresent(24);
    }
    
    public void deleteErrorMsg()
    {
	setComponentAbsent(24);
    }
    
    
    // Methods for field "errorSource"
    public IA5String getErrorSource()
    {
	return (IA5String)mComponents[25];
    }
    
    public void setErrorSource(IA5String errorSource)
    {
	mComponents[25] = errorSource;
    }
    
    public boolean hasErrorSource()
    {
	return componentIsPresent(25);
    }
    
    public void deleteErrorSource()
    {
	setComponentAbsent(25);
    }
    
    
    /**
     * Initialize the type descriptor.
     */
    private static final SetInfo c_typeinfo = new SetInfo (
	new Tags (
	    new short[] {
		0x43e8
	    }
	),
	new QName (
	    "cciibts.btsdwnld",
	    "BTSDwnldTran"
	),
	new QName (
	    "BTSDwnld",
	    "BTSDwnldTran"
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
					    new com.oss.asn1.INTEGER(13),
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
				new Long(13)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "airbillNbr",
		    0,
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
		    "formCd",
		    1,
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
		    "serialNbr",
		    2,
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "originLoc",
		    3,
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "destinationLoc",
		    4,
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
		    "transCd",
		    5,
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
		    "totalPieces",
		    6,
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
		    "transDtEst",
		    7,
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
					    new com.oss.asn1.INTEGER(9),
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
				new Long(9)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "employeeNbr",
		    8,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800a
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
					    new com.oss.asn1.INTEGER(161),
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
				new Long(161)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "comment",
		    9,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800b
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd1",
		    10,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800c
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd2",
		    11,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800d
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd3",
		    12,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800e
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd4",
		    13,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x800f
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd5",
		    14,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8010
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd6",
		    15,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8011
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd7",
		    16,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8012
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
					    new com.oss.asn1.INTEGER(6),
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
				new Long(6)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "reasonCd8",
		    17,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8013
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
					    new com.oss.asn1.INTEGER(14),
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
				new Long(14)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "entryNbr",
		    18,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8014
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
		    "entryType",
		    19,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8015
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
		    "entryDtEst",
		    20,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8016
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
		    "agencyCd",
		    21,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8017
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
		    "selectCd",
		    22,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8018
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
		    "errorCd",
		    23,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x8019
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
					    new com.oss.asn1.INTEGER(31),
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
				new Long(31)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "errorMsg",
		    24,
		    3,
		    null
		),
		new SequenceFieldInfo (
		    new TypeInfoRef (
			new KMCStringInfo (
			    new Tags (
				new short[] {
				    (short)0x801a
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
					    new com.oss.asn1.INTEGER(9),
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
				new Long(9)
			    ),
			    IA5StringPAInfo.paInfo
			)
		    ),
		    "errorSource",
		    25,
		    3,
		    null
		)
	    }
	),
	0,
	new TagDecoder (
	    new TagDecoderElement[] {
		new TagDecoderElement((short)0x8001, 0),
		new TagDecoderElement((short)0x8002, 1),
		new TagDecoderElement((short)0x8003, 2),
		new TagDecoderElement((short)0x8004, 3),
		new TagDecoderElement((short)0x8005, 4),
		new TagDecoderElement((short)0x8006, 5),
		new TagDecoderElement((short)0x8007, 6),
		new TagDecoderElement((short)0x8008, 7),
		new TagDecoderElement((short)0x8009, 8),
		new TagDecoderElement((short)0x800a, 9),
		new TagDecoderElement((short)0x800b, 10),
		new TagDecoderElement((short)0x800c, 11),
		new TagDecoderElement((short)0x800d, 12),
		new TagDecoderElement((short)0x800e, 13),
		new TagDecoderElement((short)0x800f, 14),
		new TagDecoderElement((short)0x8010, 15),
		new TagDecoderElement((short)0x8011, 16),
		new TagDecoderElement((short)0x8012, 17),
		new TagDecoderElement((short)0x8013, 18),
		new TagDecoderElement((short)0x8014, 19),
		new TagDecoderElement((short)0x8015, 20),
		new TagDecoderElement((short)0x8016, 21),
		new TagDecoderElement((short)0x8017, 22),
		new TagDecoderElement((short)0x8018, 23),
		new TagDecoderElement((short)0x8019, 24),
		new TagDecoderElement((short)0x801a, 25)
	    }
	)
    );
    
    /**
     * Get the type descriptor (TypeInfo) of 'this' BTSDwnldTran object.
     */
    public TypeInfo getTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * Get the static type descriptor (TypeInfo) of 'this' BTSDwnldTran object.
     */
    public static TypeInfo getStaticTypeInfo()
    {
	return c_typeinfo;
    }
    
    /**
     * The type is a PDU.
     */
    public boolean isPDU()
    {
	return true;
    }
    
} // End class definition for BTSDwnldTran
