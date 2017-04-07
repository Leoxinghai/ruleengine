// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ShipmentInfo.java

package com.fedex.cih.vo;

import java.io.Serializable;
import java.util.Date;

public class ShipmentInfo
    implements Serializable
{

    public ShipmentInfo()
    {
    }

    public ShipmentInfo(String aClass, String aMawb, String aStatus)
    {
        m_Classification = aClass;
        m_MAWBNumber = aMawb;
        m_ClearStatus = aStatus;
    }

    public String getClassification()
    {
        return m_Classification;
    }

    public String getClearanceStatus()
    {
        return m_ClearStatus;
    }

    public String getMAWBNumber()
    {
        return m_MAWBNumber;
    }

    public void setClassification(String m_Classification)
    {
        this.m_Classification = m_Classification;
    }

    public boolean getBondTransfered()
    {
        return m_BondTransfered;
    }

    public void setBondTransfered(boolean bondTransfered)
    {
        m_BondTransfered = bondTransfered;
    }

    public void setClearanceStatus(String m_ClearStatus)
    {
        this.m_ClearStatus = m_ClearStatus;
    }

    public void setMAWBNumber(String m_MAWBNumber)
    {
        this.m_MAWBNumber = m_MAWBNumber;
    }

    public String getDestLocationCode()
    {
        return m_LocationCode;
    }

    public long getShipmentOid()
    {
        return m_ShipmentOid;
    }

    public void setDestLocationCode(String m_LocationCode)
    {
        this.m_LocationCode = m_LocationCode;
    }

    public void setShipmentOid(long m_ShipmentOid)
    {
        this.m_ShipmentOid = m_ShipmentOid;
    }

    public Date getFlightDate()
    {
        return m_FlightDate;
    }

    public void setFlightDate(Date m_FlightDate)
    {
        this.m_FlightDate = m_FlightDate;
    }

    public String getFlightNumber()
    {
        return m_FlightNumber;
    }

    public void setFlightNumber(String m_FlightNumber)
    {
        this.m_FlightNumber = m_FlightNumber;
    }

    public String toString()
    {
        return " ShipmentOid = " + m_ShipmentOid + (" LocationCode = " + m_LocationCode) + (" Classification = " + m_Classification) + (" ClearStatus = " + m_ClearStatus) + (" MAWBNumber = " + m_MAWBNumber) + (" FlightNumber = " + m_FlightNumber);
    }

    public static String SHIPMENT_TABLE = "ACCS_CORE_SHIPMENT_REF";
    public static String STATUS_TABLE = "ACCS_CORE_SHP_STATUS";
    private long m_ShipmentOid;
    private String m_LocationCode;
    private String m_Classification;
    private String m_MAWBNumber;
    private String m_ClearStatus;
    private String m_DeclaredFlag;
    private String m_StatusCode;
    private String m_FlightNumber;
    private boolean m_BondTransfered;
    private Date m_FlightDate;

}
