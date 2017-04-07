// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CaBrkrMessage.java

package cabrkrmsg.canadabrokerasn;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class CaBrkrMessage extends Set
{

    public CaBrkrMessage()
    {
        mComponents = new AbstractData[6];
    }

    public CaBrkrMessage(IA5String airbillNumber, IA5String originLocation, IA5String destinationLocation, IA5String inputDate, IA5String iciFlag, IA5String imageStatusCd)
    {
        mComponents = new AbstractData[6];
        setAirbillNumber(airbillNumber);
        setOriginLocation(originLocation);
        setDestinationLocation(destinationLocation);
        setInputDate(inputDate);
        setIciFlag(iciFlag);
        setImageStatusCd(imageStatusCd);
    }

    public void initComponents()
    {
        mComponents[0] = new IA5String();
        mComponents[1] = new IA5String();
        mComponents[2] = new IA5String();
        mComponents[3] = new IA5String();
        mComponents[4] = new IA5String();
        mComponents[5] = new IA5String();
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

    public IA5String getOriginLocation()
    {
        return (IA5String)mComponents[1];
    }

    public void setOriginLocation(IA5String originLocation)
    {
        mComponents[1] = originLocation;
    }

    public boolean hasOriginLocation()
    {
        return componentIsPresent(1);
    }

    public void deleteOriginLocation()
    {
        setComponentAbsent(1);
    }

    public IA5String getDestinationLocation()
    {
        return (IA5String)mComponents[2];
    }

    public void setDestinationLocation(IA5String destinationLocation)
    {
        mComponents[2] = destinationLocation;
    }

    public boolean hasDestinationLocation()
    {
        return componentIsPresent(2);
    }

    public void deleteDestinationLocation()
    {
        setComponentAbsent(2);
    }

    public IA5String getInputDate()
    {
        return (IA5String)mComponents[3];
    }

    public void setInputDate(IA5String inputDate)
    {
        mComponents[3] = inputDate;
    }

    public boolean hasInputDate()
    {
        return componentIsPresent(3);
    }

    public void deleteInputDate()
    {
        setComponentAbsent(3);
    }

    public IA5String getIciFlag()
    {
        return (IA5String)mComponents[4];
    }

    public void setIciFlag(IA5String iciFlag)
    {
        mComponents[4] = iciFlag;
    }

    public boolean hasIciFlag()
    {
        return componentIsPresent(4);
    }

    public void deleteIciFlag()
    {
        setComponentAbsent(4);
    }

    public IA5String getImageStatusCd()
    {
        return (IA5String)mComponents[5];
    }

    public void setImageStatusCd(IA5String imageStatusCd)
    {
        mComponents[5] = imageStatusCd;
    }

    public boolean hasImageStatusCd()
    {
        return componentIsPresent(5);
    }

    public void deleteImageStatusCd()
    {
        setComponentAbsent(5);
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
            17383
        }), new QName("cabrkrmsg.canadabrokerasn", "CaBrkrMessage"), new QName("CanadaBrokerAsn", "CaBrkrMessage"), 22, null, new Fields(new SequenceFieldInfo[] {
            new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32767
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(12), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(12L)), IA5StringPAInfo.paInfo)), "airbillNumber", 0, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32766
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(5), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(5L)), IA5StringPAInfo.paInfo)), "originLocation", 1, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32765
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(5), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(5L)), IA5StringPAInfo.paInfo)), "destinationLocation", 2, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32764
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(8), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(8L)), IA5StringPAInfo.paInfo)), "inputDate", 3, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32763
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(1), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(1L)), IA5StringPAInfo.paInfo)), "iciFlag", 4, 3, null), new SequenceFieldInfo(new TypeInfoRef(new KMCStringInfo(new Tags(new short[] {
                -32762
            }), new QName("com.oss.asn1", "IA5String"), new QName("builtin", "IA5String"), 18, new Intersection(new SizeConstraint(new ValueRangeConstraint(new AbstractBounds(new INTEGER(0), new INTEGER(1), 0))), new PermittedAlphabetConstraint(IA5StringPAInfo.pa)), new Bounds(new Long(0L), new Long(1L)), IA5StringPAInfo.paInfo)), "imageStatusCd", 5, 3, null)
        }), 0, new TagDecoder(new TagDecoderElement[] {
            new TagDecoderElement((short)-32767, 0), new TagDecoderElement((short)-32766, 1), new TagDecoderElement((short)-32765, 2), new TagDecoderElement((short)-32764, 3), new TagDecoderElement((short)-32763, 4), new TagDecoderElement((short)-32762, 5)
        }));
    }
}
