// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbStagingArea.java

package cciij.cciidatabase;

import cciij.cciidata.StagingArea;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbStagingArea extends DbBase
{

    public DbStagingArea()
    {
        STAGING_AREA = "STAGING_AREA ";
        fetchAllSQL = "SELECT WAREHOUSE_CD, STAGING_AREA_CD, STAGING_AREA_DESC, PRINTER_CD, SO_SATIFIES_ALL_SA_INTRCPS_FLG, DIVERTER_NBR, DIVERTER_DESC, STAGING_ROUTING_CD, RECORD_ACTIVE_FLG, LOCATION_CD FROM " + STAGING_AREA + " WHERE LOCATION_CD = ? ORDER BY STAGING_AREA_CD";
        fetchWithStagingAreaCdSQL = "SELECT WAREHOUSE_CD, STAGING_AREA_CD, STAGING_AREA_DESC, PRINTER_CD, SO_SATIFIES_ALL_SA_INTRCPS_FLG, DIVERTER_NBR, DIVERTER_DESC, STAGING_ROUTING_CD, RECORD_ACTIVE_FLG, LOCATION_CD FROM " + STAGING_AREA + " WHERE " + "STAGING_AREA_CD = ? AND LOCATION_CD = ?";
        fetchAllActiveStagingAreaSQL = "SELECT WAREHOUSE_CD, STAGING_AREA_CD, STAGING_AREA_DESC, PRINTER_CD, SO_SATIFIES_ALL_SA_INTRCPS_FLG, DIVERTER_NBR, DIVERTER_DESC, STAGING_ROUTING_CD, RECORD_ACTIVE_FLG,  LOCATION_CD FROM " + STAGING_AREA + " WHERE RECORD_ACTIVE_FLG = 'Y' AND " + "LOCATION_CD = ? ORDER BY STAGING_AREA_CD";
        saveStagingAreaSQL = "INSERT INTO " + STAGING_AREA + " (WAREHOUSE_CD, STAGING_AREA_CD, " + "STAGING_AREA_DESC, PRINTER_CD, SO_SATIFIES_ALL_SA_INTRCPS_FLG, " + "DIVERTER_NBR, DIVERTER_DESC, STAGING_ROUTING_CD, RECORD_ACTIVE_FLG, LOCATION_CD) " + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        removeStagingAreaSQL = "DELETE FROM " + STAGING_AREA + " WHERE STAGING_AREA_CD = ? AND LOCATION_CD = ? AND WAREHOUSE_CD = ?";
        updateStagingAreaSQL = "UPDATE " + STAGING_AREA + " SET " + "STAGING_AREA_DESC = ?, " + "PRINTER_CD = ?, SO_SATIFIES_ALL_SA_INTRCPS_FLG = ?, " + "DIVERTER_NBR = ?, DIVERTER_DESC = ?, " + "STAGING_ROUTING_CD = ?, RECORD_ACTIVE_FLG = ? " + "WHERE STAGING_AREA_CD = ? AND LOCATION_CD = ? AND WAREHOUSE_CD = ?";
        fetchWithStagingAreaCdStmt = null;
        fetchAllStmt = null;
        fetchAllActiveStagingAreaStmt = null;
        saveStagingAreaStmt = null;
        removeStagingAreaStmt = null;
        updateStagingAreaStmt = null;
    }

    public int getStagingAreaRecordCount()
    {
        return m_recordCount;
    }

    public StagingArea fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllStmt = conn.prepareStatement(fetchAllSQL);
            fetchAllStmt.setString(1, locationCd);
            runQuery(fetchAllStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchAllSQL, locationCd);
            throw ex;
        }
        return fetchNext();
    }

    public StagingArea fetchAllActiveStagingArea(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllActiveStagingAreaStmt = conn.prepareStatement(fetchAllActiveStagingAreaSQL);
            fetchAllActiveStagingAreaStmt.setString(1, locationCd);
            runQuery(fetchAllActiveStagingAreaStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchAllActiveStagingArea", fetchAllActiveStagingAreaSQL, locationCd);
            throw ex;
        }
        return fetchNext();
    }

    public StagingArea fetch(Connection conn, String stagingAreaCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchWithStagingAreaCdStmt = conn.prepareStatement(fetchWithStagingAreaCdSQL);
            fetchWithStagingAreaCdStmt.setString(1, stagingAreaCd);
            fetchWithStagingAreaCdStmt.setString(2, locationCd);
            runQuery(fetchWithStagingAreaCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchWithStagingAreaCdSQL, locationCd + ", " + stagingAreaCd);
            throw ex;
        }
        return fetchNext();
    }

    public StagingArea fetchNext()
        throws SQLException
    {
        StagingArea sa = new StagingArea();
        try
        {
            if(m_hasMore)
            {
                String warehouseCd = m_resultSet.getString(1);
                String stageAreaCd = m_resultSet.getString(2);
                String stageAreaDesc = m_resultSet.getString(3);
                String printerCd = m_resultSet.getString(4);
                String stageOut = m_resultSet.getString(5);
                String diverterNbr = m_resultSet.getString(6);
                String diverterDesc = m_resultSet.getString(7);
                String routingCd = m_resultSet.getString(8);
                String recordActiveFlg = m_resultSet.getString(9);
                String locationCd = m_resultSet.getString(10);
                sa = new StagingArea(warehouseCd, stageAreaCd, stageAreaDesc, printerCd, stageOut, diverterNbr, diverterDesc, routingCd, recordActiveFlg);
                sa.setLocationCode(locationCd);
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
                sa = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return sa;
    }

    public void save(Connection conn, StagingArea sa, String locationCode)
        throws SQLException
    {
        try
        {
            saveStagingAreaStmt = conn.prepareStatement(saveStagingAreaSQL);
            saveStagingAreaStmt.setString(1, sa.getWarehouseCode());
            saveStagingAreaStmt.setString(2, sa.getStagingAreaCode());
            saveStagingAreaStmt.setString(3, sa.getStagingAreaDescription());
            saveStagingAreaStmt.setString(4, sa.getPrinterCode());
            saveStagingAreaStmt.setString(5, sa.getStageOutSatisfiesAllIntercepts());
            saveStagingAreaStmt.setString(6, sa.getDiverterNumber());
            saveStagingAreaStmt.setString(7, sa.getDiverterDescription());
            saveStagingAreaStmt.setString(8, sa.getStagingRoutingCode());
            saveStagingAreaStmt.setString(9, sa.getRecordActiveFlag());
            if(sa.getLocationCode().equals(""))
                saveStagingAreaStmt.setString(10, locationCode);
            else
                saveStagingAreaStmt.setString(10, sa.getLocationCode());
            saveStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveStagingAreaSQL, sa.getWarehouseCode() + ", " + sa.getStagingAreaCode() + ", " + sa.getStagingAreaDescription() + ", " + sa.getPrinterCode() + ", " + sa.getStageOutSatisfiesAllIntercepts() + ", " + sa.getDiverterNumber() + ", " + sa.getDiverterDescription() + ", " + sa.getStagingRoutingCode() + ", " + sa.getRecordActiveFlag() + ", " + locationCode);
            throw ex;
        }
    }

    public void remove(Connection conn, StagingArea sa)
        throws SQLException
    {
        try
        {
            removeStagingAreaStmt = conn.prepareStatement(removeStagingAreaSQL);
            removeStagingAreaStmt.setString(1, sa.getStagingAreaCode());
            removeStagingAreaStmt.setString(2, sa.getLocationCode());
            removeStagingAreaStmt.setString(3, sa.getWarehouseCode());
            removeStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeStagingAreaSQL, sa.getStagingAreaCode() + ", " + sa.getLocationCode() + ", " + sa.getWarehouseCode());
            throw ex;
        }
    }

    public void update(Connection conn, StagingArea sa)
        throws SQLException
    {
        try
        {
            updateStagingAreaStmt = conn.prepareStatement(updateStagingAreaSQL);
            updateStagingAreaStmt.setString(1, sa.getStagingAreaDescription());
            updateStagingAreaStmt.setString(2, sa.getPrinterCode());
            updateStagingAreaStmt.setString(3, sa.getStageOutSatisfiesAllIntercepts());
            updateStagingAreaStmt.setString(4, sa.getDiverterNumber());
            updateStagingAreaStmt.setString(5, sa.getDiverterDescription());
            updateStagingAreaStmt.setString(6, sa.getStagingRoutingCode());
            updateStagingAreaStmt.setString(7, sa.getRecordActiveFlag());
            updateStagingAreaStmt.setString(8, sa.getStagingAreaCode());
            updateStagingAreaStmt.setString(9, sa.getLocationCode());
            updateStagingAreaStmt.setString(10, sa.getWarehouseCode());
            updateStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateStagingAreaSQL, sa.getStagingAreaDescription() + ", " + sa.getPrinterCode() + ", " + sa.getStageOutSatisfiesAllIntercepts() + ", " + sa.getDiverterNumber() + ", " + sa.getDiverterDescription() + ", " + sa.getStagingRoutingCode() + ", " + sa.getRecordActiveFlag() + ", " + sa.getStagingAreaCode() + ", " + sa.getLocationCode() + ", " + sa.getWarehouseCode());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        StagingArea stagingArea = new StagingArea("WHD", "STAG", "STAGING AREA DESC", "XXX", "Y", "2", "DIVERTER DESC", "COSD", "Y");
        try
        {
            db.setLocationCode("NNN");
            stagingArea.setLocationCode("NNN");
            db.removeStagingArea(stagingArea);
            stagingArea.setLocationCode("");
            db.saveStagingArea(stagingArea);
            db.setLocationCode("JJJ");
            stagingArea.setLocationCode("JJJ");
            db.removeStagingArea(stagingArea);
            stagingArea.setLocationCode("");
            db.saveStagingArea(stagingArea);
            stagingArea = new StagingArea("WHD", "KATH", "JJJ KATHY STAGING AREA DESC", "XXX", "Y", "2", "KATHY DIVERTER DESC", "COSD", "Y");
            stagingArea.setLocationCode("JJJ");
            db.removeStagingArea(stagingArea);
            db.saveStagingArea(stagingArea);
            stagingArea = new StagingArea("WHD", "KATH", "NNN KATHY STAGING AREA DESC", "XXX", "Y", "2", "KATHY DIVERTER DESC", "COSD", "Y");
            stagingArea.setLocationCode("NNN");
            db.removeStagingArea(stagingArea);
            db.saveStagingArea(stagingArea);
            stagingArea = new StagingArea("WHD", "KATT", "NNN KATT STAGING AREA DESC", "XXX", "Y", "2", "KATHY DIVERTER DESC", "COSD", "Y");
            stagingArea.setLocationCode("NNN");
            db.removeStagingArea(stagingArea);
            db.saveStagingArea(stagingArea);
            System.out.println("Test Case 1: Successfully saved StagingAreas");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            stagingArea = db.fetchStagingArea();
            for(int currentRow = 1; db.getStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + "-Results of fetch(locationCd)" + stagingArea);
                stagingArea = db.fetchNextStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("JJJ");
            stagingArea = db.fetchStagingArea("KATH");
            for(int currentRow = 1; db.getStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row " + currentRow + "-Results of fetch(stagingAreaCd, locationCd)" + stagingArea);
                stagingArea = db.fetchNextStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            stagingArea = db.fetchStagingArea("STAG");
            stagingArea.setRecordActiveFlag("N");
            db.updateStagingArea(stagingArea);
            System.out.println("Test Case 4 successful");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            stagingArea = db.fetchStagingAreaAllActive();
            for(int currentRow = 1; db.getStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row = " + currentRow + "-Results of fetchAllActiveStagingArea(locationCd)" + stagingArea);
                stagingArea = db.fetchNextStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            stagingArea = db.fetchStagingArea("KATH");
            db.removeStagingArea(stagingArea);
            if(db.fetchStagingArea("STAG") == null)
                System.out.println("Test Case 6: Remove Successful ");
            else
                System.out.println("Test Case 6: Remove Successful ");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 7 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbStagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String STAGING_AREA;
    private String fetchAllSQL;
    private String fetchWithStagingAreaCdSQL;
    private String fetchAllActiveStagingAreaSQL;
    private String saveStagingAreaSQL;
    private String removeStagingAreaSQL;
    private String updateStagingAreaSQL;
    private PreparedStatement fetchWithStagingAreaCdStmt;
    private PreparedStatement fetchAllStmt;
    private PreparedStatement fetchAllActiveStagingAreaStmt;
    private PreparedStatement saveStagingAreaStmt;
    private PreparedStatement removeStagingAreaStmt;
    private PreparedStatement updateStagingAreaStmt;
}
