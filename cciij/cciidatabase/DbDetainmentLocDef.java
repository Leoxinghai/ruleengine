// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbDetainmentLocDef.java

package cciij.cciidatabase;

import cciij.cciidata.DetainmentLocDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbDetainmentLocDef extends DbBase
{

    public DbDetainmentLocDef()
    {
        DETAINMENT_LOCATION_DEF = "DETAINMENT_LOCATION_DEF ";
        fetchAllDetainmentLocDefSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, DETAINMENT_LOCATION_CD, DETAINMENT_LOCATION_DESC FROM " + DETAINMENT_LOCATION_DEF;
        fetchDetainmentLocDefByLocWhseStageSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, DETAINMENT_LOCATION_CD, DETAINMENT_LOCATION_DESC FROM " + DETAINMENT_LOCATION_DEF + "WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND STAGING_AREA_CD = ?";
        fetchDetainmentLocDefByLocWhseStageDetSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, DETAINMENT_LOCATION_CD, DETAINMENT_LOCATION_DESC FROM " + DETAINMENT_LOCATION_DEF + "WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND STAGING_AREA_CD = ? " + "AND DETAINMENT_LOCATION_CD = ?";
        saveDetainmentLocDefSQL = "INSERT INTO " + DETAINMENT_LOCATION_DEF + "(LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, DETAINMENT_LOCATION_CD, " + "DETAINMENT_LOCATION_DESC) " + "VALUES(?,?,?,?,?)";
        removeDetainmentLocDefSQL = "DELETE FROM " + DETAINMENT_LOCATION_DEF + "WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? " + "AND STAGING_AREA_CD = ? AND DETAINMENT_LOCATION_CD = ?";
        updateDetainmentLocDefSQL = "UPDATE " + DETAINMENT_LOCATION_DEF + "SET " + "DETAINMENT_LOCATION_DESC = ? " + "WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? " + "AND STAGING_AREA_CD = ? AND DETAINMENT_LOCATION_CD = ?";
        fetchAllDetainmentLocDefStmt = null;
        fetchDetainmentLocDefByLocWhseStageStmt = null;
        fetchDetainmentLocDefByLocWhseStageDetStmt = null;
        saveDetainmentLocDefStmt = null;
        removeDetainmentLocDefStmt = null;
        updateDetainmentLocDefStmt = null;
    }

    public DetainmentLocDef fetch(Connection conn)
        throws SQLException
    {
        try
        {
            fetchAllDetainmentLocDefStmt = conn.prepareStatement(fetchAllDetainmentLocDefSQL);
            runQuery(fetchAllDetainmentLocDefStmt);
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return fetchNext();
    }

    public DetainmentLocDef fetch(Connection conn, String locationCd, String warehouseCd, String stagingAreaCd)
        throws SQLException
    {
        try
        {
            fetchDetainmentLocDefByLocWhseStageStmt = conn.prepareStatement(fetchDetainmentLocDefByLocWhseStageSQL);
            fetchDetainmentLocDefByLocWhseStageStmt.setString(1, locationCd);
            fetchDetainmentLocDefByLocWhseStageStmt.setString(2, warehouseCd);
            fetchDetainmentLocDefByLocWhseStageStmt.setString(3, stagingAreaCd);
            runQuery(fetchDetainmentLocDefByLocWhseStageStmt);
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return fetchNext();
    }

    public DetainmentLocDef fetch(Connection conn, String locationCd, String warehouseCd, String stagingAreaCd, String detainmentLocCd)
        throws SQLException
    {
        try
        {
            fetchDetainmentLocDefByLocWhseStageDetStmt = conn.prepareStatement(fetchDetainmentLocDefByLocWhseStageDetSQL);
            fetchDetainmentLocDefByLocWhseStageDetStmt.setString(1, locationCd);
            fetchDetainmentLocDefByLocWhseStageDetStmt.setString(2, warehouseCd);
            fetchDetainmentLocDefByLocWhseStageDetStmt.setString(3, stagingAreaCd);
            fetchDetainmentLocDefByLocWhseStageDetStmt.setString(4, detainmentLocCd);
            runQuery(fetchDetainmentLocDefByLocWhseStageDetStmt);
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return fetchNext();
    }

    public DetainmentLocDef fetchNext()
        throws SQLException
    {
        DetainmentLocDef dd = new DetainmentLocDef();
        try
        {
            if(m_hasMore)
            {
                String locationCd = m_resultSet.getString(1);
                String warehouseCd = m_resultSet.getString(2);
                String stagingAreaCd = m_resultSet.getString(3);
                String detainmentLocCd = m_resultSet.getString(4);
                String detainmentLocDesc = m_resultSet.getString(5);
                dd = new DetainmentLocDef(locationCd, warehouseCd, stagingAreaCd, detainmentLocCd, detainmentLocDesc);
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
                dd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return dd;
    }

    public int getDetainmentLocDefRecordCount()
    {
        return m_recordCount;
    }

    public void remove(Connection conn, DetainmentLocDef dd)
        throws SQLException
    {
        try
        {
            removeDetainmentLocDefStmt = conn.prepareStatement(removeDetainmentLocDefSQL);
            removeDetainmentLocDefStmt.setString(1, dd.getLocationCd());
            removeDetainmentLocDefStmt.setString(2, dd.getWarehouseCd());
            removeDetainmentLocDefStmt.setString(3, dd.getStagingAreaCd());
            removeDetainmentLocDefStmt.setString(4, dd.getDetainmentLocCd());
            removeDetainmentLocDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
    }

    public void save(Connection conn, DetainmentLocDef dd)
        throws SQLException
    {
        try
        {
            saveDetainmentLocDefStmt = conn.prepareStatement(saveDetainmentLocDefSQL);
            saveDetainmentLocDefStmt.setString(1, dd.getLocationCd());
            saveDetainmentLocDefStmt.setString(2, dd.getWarehouseCd());
            saveDetainmentLocDefStmt.setString(3, dd.getStagingAreaCd());
            saveDetainmentLocDefStmt.setString(4, dd.getDetainmentLocCd());
            saveDetainmentLocDefStmt.setString(5, dd.getDetainmentLocDesc());
            saveDetainmentLocDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
    }

    public void update(Connection conn, DetainmentLocDef dd)
        throws SQLException
    {
        try
        {
            updateDetainmentLocDefStmt = conn.prepareStatement(updateDetainmentLocDefSQL);
            updateDetainmentLocDefStmt.setString(1, dd.getDetainmentLocDesc());
            updateDetainmentLocDefStmt.setString(2, dd.getLocationCd());
            updateDetainmentLocDefStmt.setString(3, dd.getWarehouseCd());
            updateDetainmentLocDefStmt.setString(4, dd.getStagingAreaCd());
            updateDetainmentLocDefStmt.setString(5, dd.getDetainmentLocCd());
            updateDetainmentLocDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOCL");
        db.connect();
        DbDetainmentLocDef dbDetainmentLocDef = new DbDetainmentLocDef();
        dbDetainmentLocDef.testDbDetainmentLocDef(db);
        db.closeConnection();
    }

    private void testDbDetainmentLocDef(DatabaseBean db)
    {
        DetainmentLocDef detainmentLocDef = null;
        try
        {
            System.out.println("============Executing INSERT LOCL, WHSE, STG, DETLOC, DETDSC");
            db.saveDetainmentLocDef(new DetainmentLocDef("LOCL", "WHSE", "STG", "DETLOC", "DETDSC"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting detainmentLocDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing INSERT LOCL, WHSE2, STG2, DETLOC2, DETDSC2");
            db.saveDetainmentLocDef(new DetainmentLocDef("LOCL", "WHSE2", "STG2", "DETLOC2", "DETDSC2"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting detainmentLocDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT ALL ");
            detainmentLocDef = db.fetchDetainmentLocDef();
            if(detainmentLocDef != null)
                System.out.println(detainmentLocDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Detainment Loc Def" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT by Location, Warehouse, Staging code ");
            detainmentLocDef = db.fetchDetainmentLocDef("LOCL", "WHSE", "STG");
            if(detainmentLocDef != null)
                System.out.println(detainmentLocDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Detainment Loc Def" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT by Location, Warehouse, Staging, Detainment code ");
            detainmentLocDef = db.fetchDetainmentLocDef("LOCL", "WHSE", "STG", "DETLOC");
            if(detainmentLocDef != null)
                System.out.println(detainmentLocDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Detainment Loc Def" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE ");
            db.updateDetainmentLocDef(new DetainmentLocDef("LOCL", "WHSE", "STG", "DETLOC", "NEWDSC"));
            if(detainmentLocDef != null)
                System.out.println(detainmentLocDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while UPDATING" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE ");
            db.removeDetainmentLocDef(new DetainmentLocDef("LOCL", "WHSE", "STG", "DETLOC", "DETDSC"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while DELETING DetainmentLocDef " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbDetainmentLocDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String DETAINMENT_LOCATION_DEF;
    private String fetchAllDetainmentLocDefSQL;
    private String fetchDetainmentLocDefByLocWhseStageSQL;
    private String fetchDetainmentLocDefByLocWhseStageDetSQL;
    private String saveDetainmentLocDefSQL;
    private String removeDetainmentLocDefSQL;
    private String updateDetainmentLocDefSQL;
    private PreparedStatement fetchAllDetainmentLocDefStmt;
    private PreparedStatement fetchDetainmentLocDefByLocWhseStageStmt;
    private PreparedStatement fetchDetainmentLocDefByLocWhseStageDetStmt;
    private PreparedStatement saveDetainmentLocDefStmt;
    private PreparedStatement removeDetainmentLocDefStmt;
    private PreparedStatement updateDetainmentLocDefStmt;
}
