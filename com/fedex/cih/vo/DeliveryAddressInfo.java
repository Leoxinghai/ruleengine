// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeliveryAddressInfo.java

package com.fedex.cih.vo;

import java.io.Serializable;

public class DeliveryAddressInfo
    implements Serializable
{

    public DeliveryAddressInfo()
    {
    }

    public DeliveryAddressInfo(String aName, String aCompany, String aAddr1, String aAddr2)
    {
        m_ContactName = aName;
        m_ContactCompany = aCompany;
        m_ContactAddress1 = aAddr1;
        m_ContactAddress2 = aAddr2;
    }

    public String getContactAddress1()
    {
        return m_ContactAddress1;
    }

    public String getContactAddress2()
    {
        return m_ContactAddress2;
    }

    public String getContactCompany()
    {
        return m_ContactCompany;
    }

    public String getContactName()
    {
        return m_ContactName;
    }

    public String getLocationCode()
    {
        return m_LocationCode;
    }

    public long getOidNumber()
    {
        return m_OidNumber;
    }

    public String getOidType()
    {
        return m_OidType;
    }

    public void setContactAddress1(String m_ContactAddress1)
    {
        this.m_ContactAddress1 = m_ContactAddress1;
    }

    public void setContactAddress2(String m_ContactAddress2)
    {
        this.m_ContactAddress2 = m_ContactAddress2;
    }

    public void setContactCompany(String m_ContactCompany)
    {
        this.m_ContactCompany = m_ContactCompany;
    }

    public void setContactName(String m_ContactName)
    {
        this.m_ContactName = m_ContactName;
    }

    public void setLocationCode(String m_LocationCode)
    {
        this.m_LocationCode = m_LocationCode;
    }

    public void setOidNumber(long m_OidNumber)
    {
        this.m_OidNumber = m_OidNumber;
    }

    public void setOidType(String m_OidType)
    {
        this.m_OidType = m_OidType;
    }

    public String getComments()
    {
        return m_Comments;
    }

    public void setComments(String m_Comments)
    {
        this.m_Comments = m_Comments;
    }

    public String toString()
    {
        return " ShipmentOid = " + m_OidNumber + (" LocationCode = " + m_LocationCode) + (" ContactName = " + m_ContactName) + (" ContactCompany = " + m_ContactCompany) + (" ContactAddress1 = " + m_ContactAddress1) + (" ContactAddress2 = " + m_ContactAddress2);
    }

    public static String ADDRESS_TABLE = "ACCS_CORE_CHANGE_OF_ADDRESS";
    public static String OID_TYPE_SHIPMENT = "S";
    public static String OID_TYPE_PIECE = "P";
    private long m_OidNumber;
    private String m_OidType;
    private String m_LocationCode;
    private String m_ContactName;
    private String m_ContactCompany;
    private String m_ContactAddress1;
    private String m_ContactAddress2;
    private String m_Comments;

}
