// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bondinout.java

package bondinout;

import com.oss.asn1.*;
import com.oss.metadata.*;

public class Bondinout extends XASN1Project
{

    public Bondinout()
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
        new PDUDecoderElement((short)18383, new QName("bondinout.cciievent", "ScanOut"))
    }), new byte[] {
        11, -117, -125, -71, -30, -86, -10, -63, -78, -85, 
        -10, -63, -78, -45, 37, -11, -87, -127, -119, 126, 
        94, 31, 29, 95, 76, -7, 31, -14, -64, 127, 
        42, -30, -99, 21, -29, -30, 56, 93, 10, -103, 
        -28, 29, -12, -90, -9, -35, -100, -16, -107, -68, 
        -31, 101, 56, -24, -48, -14, -105, -64, 116, 83, 
        127, -86, 20, -6, 103, -54, -8, 46, -121, 7, 
        -126, -115, -1, 102, 20, -107, -76, 91, -108, 125, 
        121, 120, -13, 43, -114, 84, -34, -95, 97, -102, 
        -83, -5, -91, 6, -110, -25, -110, -16, 47, -81, 
        -33, 118, 44, 92, 99, 74, 16, -54, -111, -114, 
        63, 62, 67, 25, 0, 22, -29, 90, 82, 13, 
        85, -107, -50, -99, -82, 111, 41, 90, 72, -115, 
        50, 52, 73, -119, 73, 99, 95, -45, -12, -13, 
        -115, 127, -125, 87, 10, -28, -60, -103, -18, 78, 
        95
    });
    private static final XERInfo c_XERInfo = new XERInfo(new XPDUDecoder(new XPDUDecoderElement[] {
        new XPDUDecoderElement("ScanOut", new QName("bondinout.cciievent", "ScanOut"))
    }));
    private static final ASN1Project c_project = new Bondinout();

}
