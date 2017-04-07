// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbInTransit.java

package cciij.cciidatabase;

import cciij.cciidata.InTransit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Referenced classes of package cciij.cciidatabase:
//            DbBase

public class DbInTransit extends DbBase
{

    public DbInTransit()
    {
        selectAllInTransitStmt = null;
        selectInTransitByLocCdAndShipmentOidStmt = null;
        selectInTransitByLocCdStmt = null;
        selectInTransitByShipmentOidStmt = null;
        saveInTransitStmt = null;
        updateInTransitStmt = null;
        deleteInTransitStmt = null;
    }

    public InTransit fetchNext()
        throws SQLException
    {
        InTransit inTransit = new InTransit();
        if(m_hasMore)
        {
            inTransit.setLocationCode(m_resultSet.getString("LOCATION_CD"));
            inTransit.setShipmentOidNumber(shipmentOidNumber);
            inTransit.setCCNNumber(m_resultSet.getString("CCN_NBR"));
            inTransit.setPrepDate(m_resultSet.getDate("PREP_DT"));
            inTransit.setPrintTimeStamp(m_resultSet.getTimestamp("PRINT_TMSTP"));
            inTransit.setActiveFlg(m_resultSet.getString("ACTIVE_FLG"));
            inTransit.setChangedFlg(m_resultSet.getString("CHANGED_FLG"));
            try
            {
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            }
            catch(SQLException e)
            {
                printSQLException(e, getClass().getName(), "fetchNext", "", "");
                throw e;
            }
        } else
        {
            inTransit = null;
            m_recordCount = 0;
        }
        return inTransit;
    }

    public InTransit fetchAllInTransit(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllInTransitStmt = conn.prepareStatement("SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT ");
            runQuery(selectAllInTransitStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAllInTransit", "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT ", "");
            throw e;
        }
        return fetchNext();
    }

    public InTransit fetchInTransitByLocCdAndShipmentOid(Connection conn, String locationCd, int shipmentOidNbr)
        throws SQLException
    {
        try
        {
            selectInTransitByLocCdAndShipmentOidStmt = conn.prepareStatement("SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ? ");
            selectInTransitByLocCdAndShipmentOidStmt.setString(1, locationCd);
            selectInTransitByLocCdAndShipmentOidStmt.setInt(2, shipmentOidNbr);
            runQuery(selectInTransitByLocCdAndShipmentOidStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchInTransitByLocCdAndShipmentOid", "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ? ", locationCd + ", " + shipmentOidNbr);
            throw e;
        }
        return fetchNext();
    }

    public InTransit fetchInTransitByLocCd(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            selectInTransitByLocCdStmt = conn.prepareStatement("SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ");
            selectInTransitByLocCdStmt.setString(1, locationCd);
            runQuery(selectInTransitByLocCdStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchInTransitByLocCd", "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ", locationCd);
            throw e;
        }
        return fetchNext();
    }

    public InTransit fetchInTransitByShipmentOid(Connection conn, int shipmentOidNbr)
        throws SQLException
    {
        try
        {
            shipmentOidNumber = shipmentOidNbr;
            selectInTransitByShipmentOidStmt = conn.prepareStatement("SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ");
            selectInTransitByShipmentOidStmt.setInt(1, shipmentOidNbr);
            runQuery(selectInTransitByShipmentOidStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchInTransitByShipmentOid", "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ", "" + shipmentOidNbr);
            throw e;
        }
        return fetchNext();
    }

    public void saveInTransit(Connection conn, InTransit inTransit)
        throws SQLException
    {
        try
        {
            Date tmpPrepDt = null;
            if(inTransit.getPrepDate() != null)
                tmpPrepDt = new Date(inTransit.getPrepDate().getTime());
            saveInTransitStmt = conn.prepareStatement("INSERT INTO ENT.INTRANSIT ( LOCATION_CD, SHIPMENT_OID_NBR, CCN_NBR, PREP_DT, PRINT_TMSTP, ACTIVE_FLG, CHANGED_FLG )  VALUES( ?,?,?,?,?,?,? )");
            saveInTransitStmt.setString(1, inTransit.getLocationCode());
            saveInTransitStmt.setInt(2, inTransit.getShipmentOidNumber());
            saveInTransitStmt.setString(3, inTransit.getCCNNumber());
            saveInTransitStmt.setDate(4, tmpPrepDt);
            saveInTransitStmt.setTimestamp(5, inTransit.getPrintTimeStamp());
            saveInTransitStmt.setString(6, inTransit.getActiveFlg());
            saveInTransitStmt.setString(7, inTransit.getChangedFlg());
            saveInTransitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "saveInTransit", "INSERT INTO ENT.INTRANSIT ( LOCATION_CD, SHIPMENT_OID_NBR, CCN_NBR, PREP_DT, PRINT_TMSTP, ACTIVE_FLG, CHANGED_FLG )  VALUES( ?,?,?,?,?,?,? )", inTransit.getLocationCode() + ", " + inTransit.getShipmentOidNumber() + ", " + inTransit.getCCNNumber() + ", " + inTransit.getPrepDate() + ", " + inTransit.getPrintTimeStamp() + ", " + inTransit.getActiveFlg() + ", " + inTransit.getChangedFlg());
            throw e;
        }
    }

    public void updateInTransit(Connection conn, InTransit inTransit)
        throws SQLException
    {
        try
        {
            Date tmpPrepDt = null;
            if(inTransit.getPrepDate() != null)
                tmpPrepDt = new Date(inTransit.getPrepDate().getTime());
            updateInTransitStmt = conn.prepareStatement("UPDATE ENT.INTRANSIT SET CCN_NBR = ?, PREP_DT = ?, PRINT_TMSTP = ?, ACTIVE_FLG = ?, CHANGED_FLG = ? WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?");
            updateInTransitStmt.setString(1, inTransit.getCCNNumber());
            updateInTransitStmt.setDate(2, tmpPrepDt);
            updateInTransitStmt.setTimestamp(3, inTransit.getPrintTimeStamp());
            updateInTransitStmt.setString(4, inTransit.getActiveFlg());
            updateInTransitStmt.setString(5, inTransit.getChangedFlg());
            updateInTransitStmt.setString(6, inTransit.getLocationCode());
            updateInTransitStmt.setInt(7, inTransit.getShipmentOidNumber());
            updateInTransitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "updateInTransit", "UPDATE ENT.INTRANSIT SET CCN_NBR = ?, PREP_DT = ?, PRINT_TMSTP = ?, ACTIVE_FLG = ?, CHANGED_FLG = ? WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?", inTransit.getCCNNumber() + ", " + inTransit.getPrepDate() + ", " + inTransit.getPrintTimeStamp() + ", " + inTransit.getActiveFlg() + ", " + inTransit.getChangedFlg() + ", " + inTransit.getLocationCode() + ", " + inTransit.getShipmentOidNumber());
            throw e;
        }
    }

    public void deleteInTransit(Connection conn, InTransit inTransit)
        throws SQLException
    {
        try
        {
            deleteInTransitStmt = conn.prepareStatement("DELETE FROM ENT.INTRANSIT WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?");
            deleteInTransitStmt.setString(1, inTransit.getLocationCode());
            deleteInTransitStmt.setInt(2, inTransit.getShipmentOidNumber());
            deleteInTransitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "deleteInTransit", "DELETE FROM ENT.INTRANSIT WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?", inTransit.getLocationCode() + ", " + inTransit.getShipmentOidNumber());
            throw e;
        }
    }

    public int getInTransitRecordCount()
    {
        return m_recordCount;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbInTransit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private final String tableName = "ENT.INTRANSIT ";
    private final String columnList = " LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG ";
    private final String selectAllInTransitSQL = "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT ";
    private final String selectInTransitByLocCdAndShipmentOidSQL = "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ? ";
    private final String selectInTransitByLocCdSQL = "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ";
    private final String selectInTransitByShipmentOidSQL = "SELECT  LOCATION_CD,SHIPMENT_OID_NBR,CCN_NBR,PREP_DT,PRINT_TMSTP,ACTIVE_FLG,CHANGED_FLG FROM ENT.INTRANSIT  WHERE SHIPMENT_OID_NBR = ? ";
    private final String saveInTransitSQL = "INSERT INTO ENT.INTRANSIT ( LOCATION_CD, SHIPMENT_OID_NBR, CCN_NBR, PREP_DT, PRINT_TMSTP, ACTIVE_FLG, CHANGED_FLG )  VALUES( ?,?,?,?,?,?,? )";
    private final String updateInTransitSQL = "UPDATE ENT.INTRANSIT SET CCN_NBR = ?, PREP_DT = ?, PRINT_TMSTP = ?, ACTIVE_FLG = ?, CHANGED_FLG = ? WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?";
    private final String deleteInTransitSQL = "DELETE FROM ENT.INTRANSIT WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?";
    private PreparedStatement selectAllInTransitStmt;
    private PreparedStatement selectInTransitByLocCdAndShipmentOidStmt;
    private PreparedStatement selectInTransitByLocCdStmt;
    private PreparedStatement selectInTransitByShipmentOidStmt;
    private PreparedStatement saveInTransitStmt;
    private PreparedStatement updateInTransitStmt;
    private PreparedStatement deleteInTransitStmt;
    private int shipmentOidNumber;
}
