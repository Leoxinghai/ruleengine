/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.vo;


import java.io.Serializable;
import java.util.Date;

public class ShipmentStatus
    implements Serializable
{

    public ShipmentStatus()
    {
    }

    public ShipmentStatus(int shipment_oid,String status_type_cd, String status_cd)
    {
        m_ShipmentOid = shipment_oid;
    	m_StatusTypeCode = status_type_cd;
        m_StatusCode = status_cd;
    }

    public long getShipmentOid()
    {
        return m_ShipmentOid;
    }

    public void setShipmentOid(int m_ShipmentOid)
    {
        this.m_ShipmentOid = m_ShipmentOid;
    }

    public String getStatusTypeCode()
    {
        return m_StatusTypeCode;
    }

    public void setStatusTypeCode(String status_type_code)
    {
        this.m_StatusTypeCode = status_type_code;
    }

    public String getStatusCode()
    {
        return m_StatusCode;
    }

    public void setStatusCode(String status_code)
    {
        this.m_StatusCode = status_code;
    }

    public String toString()
    {
        return " ShipmentOid = " + m_ShipmentOid + (" StatusTypeCode = " + m_StatusTypeCode) + (" StatusCode = " + m_StatusCode);
    }

    public static String SHIPMENT_TABLE = "ACCS_CORE_SHIPMENT_REF";
    public static String STATUS_TABLE = "ACCS_CORE_SHP_STATUS";
    private String m_StatusTypeCode;
    private int m_ShipmentOid;
    private String m_StatusCode;

}

