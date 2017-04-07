// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cabrkrmsg.java

package cabrkrmsg;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Cabrkrmsg extends XASN1Project
{

    public Cabrkrmsg()
    {
    }

    public ProjectInfo getProjectInfo()
    {
        return c_projectInfo;
    }

    public XERInfo getXERInfo()
    {
        return c_XERInfo;
    }

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

    private static final ProjectInfo c_projectInfo = new ProjectInfo(new PDUDecoder(new PDUDecoderElement[] {
        new PDUDecoderElement((short)17383, new QName("cabrkrmsg.canadabrokerasn", "CaBrkrMessage"))
    }), new byte[] {
        11, -117, 114, 111, -92, 43, -15, 22, 102, 42, 
        -15, 22, 102, -57, 16, 96, 66, 114, -115, -75, 
        20, 109, 43, 87, -124, -108, 47, -51, -84, 112, 
        72, -111, -95, 0, 112, 88, -128, -85, -113, 70, 
        -74, 31, -37, -24, -124, 44, 79, 4, 53, 104, 
        114, 96, 54, -98, 22, 127, -96, -90, 63, 51, 
        -79, -6, -93, -50, -110, 74, -77, -59, -125, 108, 
        49, 47, -48, 3, -58, 92, 35, 123, -50, 55, 
        36, 37, 96, 67, 35, -120, -25, 55, -124, -42, 
        -126, 104, -34, -25, 70, 57, -3, -83, -65, 98, 
        121, 117, 87, 21, -49, 0, 118, -97, -113, -55, 
        22, -119, -124, -112, -82, 33, -37, 85, 2, 39, 
        115, 24, -104, -37, -51, -64, 96, -33, -124, -49, 
        112, -111, -38, 31, -37, 60, -116, -47, 70, -106, 
        123, 21, -41, -15, 24, 25, 74, 5, 30, 14, 
        -45, 85, -5, 71, 85, -87
    });
    private static final XERInfo c_XERInfo = new XERInfo(new XPDUDecoder(new XPDUDecoderElement[] {
        new XPDUDecoderElement("CaBrkrMessage", new QName("cabrkrmsg.canadabrokerasn", "CaBrkrMessage"))
    }));
    private static final ASN1Project c_project = new Cabrkrmsg();

}
