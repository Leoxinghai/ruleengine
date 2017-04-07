// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScanOut.java

package bondinout.cciievent;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class ScanOut extends Set
{

    public ScanOut()
    {
        mComponents = new AbstractData[8];
    }

    public ScanOut(IA5String airbillNumber, IA5String millisecondtimestamp, IA5String eventType, IA5String shipmentOid, IA5String handlingUnitOid, IA5String locationCode, IA5String scanDate, 
            IA5String masterAirbillNumber)
    {
        mComponents = new AbstractData[8];
        setAirbillNumber(airbillNumber);
        setMillisecondtimestamp(millisecondtimestamp);
        setEventType(eventType);
        setShipmentOid(shipmentOid);
        setHandlingUnitOid(handlingUnitOid);
        setLocationCode(locationCode);
        setScanDate(scanDate);
        setMasterAirbillNumber(masterAirbillNumber);
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
    }

    public IA5String getAirbillNumber()
    {
        return (IA5String)mComponents[0];
    }

    public void setAirbillNumber(IA5String airbillNumber)
    {
        mComponents[0] = airbillNumber;
    }

    public boolean hasAirbillNumber()
    {
        return componentIsPresent(0);
    }

    public void deleteAirbillNumber()
    {
        setComponentAbsent(0);
    }

    public IA5String getMillisecondtimestamp()
    {
        return (IA5String)mComponents[1];
    }

    public void setMillisecondtimestamp(IA5String millisecondtimestamp)
    {
        mComponents[1] = millisecondtimestamp;
    }

    public boolean hasMillisecondtimestamp()
    {
        return componentIsPresent(1);
    }

    public void deleteMillisecondtimestamp()
    {
        setComponentAbsent(1);
    }

    public IA5String getEventType()
    {
        return (IA5String)mComponents[2];
    }

    public void setEventType(IA5String eventType)
    {
        mComponents[2] = eventType;
    }

    public boolean hasEventType()
    {
        return componentIsPresent(2);
    }

    public void deleteEventType()
    {
        setComponentAbsent(2);
    }

    public IA5String getShipmentOid()
    {
        return (IA5String)mComponents[3];
    }

    public void setShipmentOid(IA5String shipmentOid)
    {
        mComponents[3] = shipmentOid;
    }

    public boolean hasShipmentOid()
    {
        return componentIsPresent(3);
    }

    public void deleteShipmentOid()
    {
        setComponentAbsent(3);
    }

    public IA5String getHandlingUnitOid()
    {
        return (IA5String)mComponents[4];
    }

    public void setHandlingUnitOid(IA5String handlingUnitOid)
    {
        mComponents[4] = handlingUnitOid;
    }

    public boolean hasHandlingUnitOid()
    {
        return componentIsPresent(4);
    }

    public void deleteHandlingUnitOid()
    {
        setComponentAbsent(4);
    }

    public IA5String getLocationCode()
    {
        return (IA5String)mComponents[5];
    }

    public void setLocationCode(IA5String locationCode)
    {
        mComponents[5] = locationCode;
    }

    public boolean hasLocationCode()
    {
        return componentIsPresent(5);
    }

    public void deleteLocationCode()
    {
        setComponentAbsent(5);
    }

    public IA5String getScanDate()
    {
        return (IA5String)mComponents[6];
    }

    public void setScanDate(IA5String scanDate)
    {
        mComponents[6] = scanDate;
    }

    public boolean hasScanDate()
    {
        return componentIsPresent(6);
    }

    public void deleteScanDate()
    {
        setComponentAbsent(6);
    }

    public IA5String getMasterAirbillNumber()
    {
        return (IA5String)mComponents[7];
    }

    public void setMasterAirbillNumber(IA5String masterAirbillNumber)
    {
        mComponents[7] = masterAirbillNumber;
    }

    public boolean hasMasterAirbillNumber()
    {
        return componentIsPresent(7);
    }

    public void deleteMasterAirbillNumber()
    {
        setComponentAbsent(7);
    }

    public TypeInfo getTypeInfo()
    {
        return c_typeinfo;
    }

    public static TypeInfo getStaticTypeInfo()
    {
        return c_typeinfo;
    }

    public boolean isPDU()
    {
        return true;
    }

    private static final SetInfo c_typeinfo;

    static 
    {
        c_typeinfo = new SetInfo(new Tags(new short[] {
            18383
        }), new QName("bondinout.cciievent", "ScanOut"), new QName("CCIIEVENT", "ScanOut"), 22, null, new Fields(new SequenceFieldInfo[] {
            new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32758
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(12), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(12L)), IA5StringPAInfo.paInfo)), "airbillNumber", 0, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32748
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(30), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(30L)), IA5StringPAInfo.paInfo)), "millisecondtimestamp", 1, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32738
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(4), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(4L)), IA5StringPAInfo.paInfo)), "eventType", 2, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32728
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(64), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(64L)), IA5StringPAInfo.paInfo)), "shipmentOid", 3, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32718
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(64), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(64L)), IA5StringPAInfo.paInfo)), "handlingUnitOid", 4, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32668
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(6), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(6L)), IA5StringPAInfo.paInfo)), "locationCode", 5, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32658
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(30), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(30L)), IA5StringPAInfo.paInfo)), "scanDate", 6, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32648
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(12), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(12L)), IA5StringPAInfo.paInfo)), "masterAirbillNumber", 7, 3, null)
        }), 0, new TagDecoder(new TagDecoderElement[] {
            new TagDecoderElement((short)-32758, 0), new TagDecoderElement((short)-32748, 1), new TagDecoderElement((short)-32738, 2), new TagDecoderElement((short)-32728, 3), new TagDecoderElement((short)-32718, 4), new TagDecoderElement((short)-32668, 5), new TagDecoderElement((short)-32658, 6), new TagDecoderElement((short)-32648, 7)
        }));
    }
}
