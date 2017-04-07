// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbShipmentRemarkDef.java

package cciij.cciidatabase;

import cciij.cciidata.ShipmentRemarkDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbShipmentRemarkDef extends DbBase
{

    public DbShipmentRemarkDef()
    {
        SHIPMENT_REMARK_DEF = "SHIPMENT_REMARK_DEF ";
        fetchShipmentRemarkDefSQL = "SELECT SHIPMENT_REMARK_CD, REMARK_DESC, RECORD_ACTIVE_FLG , LOCATION_CD FROM " + SHIPMENT_REMARK_DEF + "  WHERE LOCATION_CD = ? ORDER BY SHIPMENT_REMARK_CD";
        fetchShipmentRemarkDefByShipmentRemarkCodeSQL = "SELECT SHIPMENT_REMARK_CD, REMARK_DESC, RECORD_ACTIVE_FLG , LOCATION_CD FROM " + SHIPMENT_REMARK_DEF + "  WHERE LOCATION_CD = ? AND SHIPMENT_REMARK_CD = ?";
        saveShipmentRemarkDefSQL = "INSERT INTO " + SHIPMENT_REMARK_DEF + " (SHIPMENT_REMARK_CD, REMARK_DESC, RECORD_ACTIVE_FLG, LOCATION_CD) " + "VALUES(?,?,?,?)";
        removeShipmentRemarkDefSQL = "DELETE FROM " + SHIPMENT_REMARK_DEF + " WHERE SHIPMENT_REMARK_CD = ? AND LOCATION_CD = ?";
        updateShipmentRemarkDefSQL = "UPDATE " + SHIPMENT_REMARK_DEF + "SET REMARK_DESC = ?, RECORD_ACTIVE_FLG = ? " + "WHERE SHIPMENT_REMARK_CD = ? AND LOCATION_CD= ?";
        fetchShipmentRemarkDefStmt = null;
        fetchShipmentRemarkDefByShipmentRemarkCodeStmt = null;
        saveShipmentRemarkDefStmt = null;
        removeShipmentRemarkDefStmt = null;
        updateShipmentRemarkDefStmt = null;
    }

    public ShipmentRemarkDef fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkDefStmt = conn.prepareStatement(fetchShipmentRemarkDefSQL);
            fetchShipmentRemarkDefStmt.setString(1, locationCd);
            runQuery(fetchShipmentRemarkDefStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchShipmentRemarkDefSQL, locationCd);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemarkDef fetch(Connection conn, String locationCd, String shipmentRemarkCd)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkDefByShipmentRemarkCodeStmt = conn.prepareStatement(fetchShipmentRemarkDefByShipmentRemarkCodeSQL);
            fetchShipmentRemarkDefByShipmentRemarkCodeStmt.setString(1, locationCd);
            fetchShipmentRemarkDefByShipmentRemarkCodeStmt.setString(2, shipmentRemarkCd);
            runQuery(fetchShipmentRemarkDefByShipmentRemarkCodeStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByShipmentRemarkCode", fetchShipmentRemarkDefByShipmentRemarkCodeSQL, shipmentRemarkCd);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemarkDef fetchNext()
        throws SQLException
    {
        ShipmentRemarkDef srd = new ShipmentRemarkDef();
        try
        {
            if(m_hasMore)
            {
                String shipRemarkCd = m_resultSet.getString(1);
                String remarkDesc = m_resultSet.getString(2);
                String recordActiveFlag = m_resultSet.getString(3);
                String locationCd = m_resultSet.getString(4);
                srd = new ShipmentRemarkDef(shipRemarkCd, remarkDesc, recordActiveFlag, locationCd);
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            } else
            {
                srd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return srd;
    }

    public int getShipmentRemarkDefRecordCount()
    {
        return m_recordCount;
    }

    public void remove(Connection conn, ShipmentRemarkDef srd)
        throws SQLException
    {
        try
        {
            removeShipmentRemarkDefStmt = conn.prepareStatement(removeShipmentRemarkDefSQL);
            removeShipmentRemarkDefStmt.setString(1, srd.getShipmentRemarkCode());
            removeShipmentRemarkDefStmt.setString(2, srd.getLocationCd());
            removeShipmentRemarkDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeShipmentRemarkDefSQL, srd.getShipmentRemarkCode() + ", " + srd.getLocationCd());
            throw ex;
        }
    }

    public void save(Connection conn, ShipmentRemarkDef srd, String locationCd)
        throws SQLException
    {
        try
        {
            saveShipmentRemarkDefStmt = conn.prepareStatement(saveShipmentRemarkDefSQL);
            saveShipmentRemarkDefStmt.setString(1, srd.getShipmentRemarkCode());
            saveShipmentRemarkDefStmt.setString(2, srd.getShipmentDescription());
            saveShipmentRemarkDefStmt.setString(3, srd.getRecordActiveFlag());
            if(srd.getLocationCd().equals("") || srd.getLocationCd().equals(null))
                saveShipmentRemarkDefStmt.setString(4, locationCd);
            else
                saveShipmentRemarkDefStmt.setString(4, srd.getLocationCd());
            saveShipmentRemarkDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveShipmentRemarkDefSQL, srd.getShipmentRemarkCode() + ", " + srd.getShipmentDescription() + ", " + srd.getRecordActiveFlag() + ", " + locationCd);
            throw ex;
        }
    }

    public void update(Connection conn, ShipmentRemarkDef srd)
        throws SQLException
    {
        try
        {
            updateShipmentRemarkDefStmt = conn.prepareStatement(updateShipmentRemarkDefSQL);
            updateShipmentRemarkDefStmt.setString(1, srd.getShipmentDescription());
            updateShipmentRemarkDefStmt.setString(2, srd.getRecordActiveFlag());
            updateShipmentRemarkDefStmt.setString(3, srd.getShipmentRemarkCode());
            updateShipmentRemarkDefStmt.setString(4, srd.getLocationCd());
            updateShipmentRemarkDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateShipmentRemarkDefSQL, srd.getShipmentDescription() + ", " + srd.getRecordActiveFlag() + ", " + srd.getShipmentRemarkCode() + ", " + srd.getLocationCd());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbShipmentRemarkDef dbShipmentRemarkDef = new DbShipmentRemarkDef();
        dbShipmentRemarkDef.testDbShipmentRemarkDef(db);
        db.closeConnection();
    }

    private void testDbShipmentRemarkDef(DatabaseBean db)
    {
        ShipmentRemarkDef shipmentRemarkDef = null;
        try
        {
            System.out.println("============Executing INSERT RMK1, MONICA DESC, Y");
            db.saveShipmentRemarkDef(new ShipmentRemarkDef("RMK1", "MONICA DESC", "Y"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting ShipmentRemarkDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT ");
            shipmentRemarkDef = db.fetchShipmentRemarkDef();
            if(shipmentRemarkDef != null)
                System.out.println(shipmentRemarkDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting ShipmentRemarkDefS" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY CODE");
            shipmentRemarkDef = db.fetchShipmentRemarkDef("RMK1");
            if(shipmentRemarkDef != null)
                System.out.println(shipmentRemarkDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting ShipmentRemarkDefS" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE RMK1, MONICA UPDATED DESC, Y");
            db.updateShipmentRemarkDef(new ShipmentRemarkDef("RMK1", "MONICA UPDATED DESC", "Y", "LOC4"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while updating ShipmentRemarkDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE RMK1, MONICA UPDATED DESC, Y");
            db.removeShipmentRemarkDef(new ShipmentRemarkDef("RMK1", "MONICA UPDATED DESC", "Y", "LOC4"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while removing ShipmentRemarkDef " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbShipmentRemarkDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String SHIPMENT_REMARK_DEF;
    private String fetchShipmentRemarkDefSQL;
    private String fetchShipmentRemarkDefByShipmentRemarkCodeSQL;
    private String saveShipmentRemarkDefSQL;
    private String removeShipmentRemarkDefSQL;
    private String updateShipmentRemarkDefSQL;
    private PreparedStatement fetchShipmentRemarkDefStmt;
    private PreparedStatement fetchShipmentRemarkDefByShipmentRemarkCodeStmt;
    private PreparedStatement saveShipmentRemarkDefStmt;
    private PreparedStatement removeShipmentRemarkDefStmt;
    private PreparedStatement updateShipmentRemarkDefStmt;
}
