// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbAgencyStagingArea.java

package cciij.cciidatabase;

import cciij.cciidata.AgencyStagingArea;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbAgencyStagingArea extends DbBase
{

    public DbAgencyStagingArea()
    {
        table_name = "ENT.AGENCY_STAGING_AREA";
        fetchByLocationCdSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, AGENCY_CD FROM " + table_name + " WHERE " + "LOCATION_CD = ? ORDER BY WAREHOUSE_CD";
        fetchByLocationCdWarehouseCdSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, AGENCY_CD FROM " + table_name + " WHERE " + "LOCATION_CD = ? AND WAREHOUSE_CD = ?";
        fetchByLocCdWhCdAgCdSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, AGENCY_CD FROM " + table_name + " WHERE LOCATION_CD = ? " + "AND WAREHOUSE_CD = ? AND AGENCY_CD = ?";
        fetchSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, STAGING_AREA_CD, AGENCY_CD FROM " + table_name + " ORDER BY LOCATION_CD, WAREHOUSE_CD";
        saveAgencyStagingAreaSQL = "INSERT INTO " + table_name + "(LOCATION_CD, " + "WAREHOUSE_CD, STAGING_AREA_CD, AGENCY_CD) " + "VALUES (?,?,?,?)";
        removeAgencyStagingAreaSQL = "DELETE FROM " + table_name + " WHERE " + "LOCATION_CD = ? AND WAREHOUSE_CD = ? AND " + "STAGING_AREA_CD = ? AND AGENCY_CD = ?";
        fetchByLocationCdStmt = null;
        fetchByLocationCdWarehouseCdStmt = null;
        fetchByLocCdWhCdAgCdStmt = null;
        fetchStmt = null;
        saveAgencyStagingAreaStmt = null;
        removeAgencyStagingAreaStmt = null;
    }

    public int getAgencyRecordCount()
    {
        return m_recordCount;
    }

    public AgencyStagingArea fetchByLocationCd(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchByLocationCdStmt = conn.prepareStatement(fetchByLocationCdSQL);
            fetchByLocationCdStmt.setString(1, locationCd);
            runQuery(fetchByLocationCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetchByLocationCd", fetchByLocationCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public AgencyStagingArea fetchByLocationCdWarehouseCd(Connection conn, String locationCd, String warehouseCd)
        throws SQLException
    {
        try
        {
            fetchByLocationCdWarehouseCdStmt = conn.prepareStatement(fetchByLocationCdWarehouseCdSQL);
            fetchByLocationCdWarehouseCdStmt.setString(1, locationCd);
            fetchByLocationCdWarehouseCdStmt.setString(2, warehouseCd);
            runQuery(fetchByLocationCdWarehouseCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + warehouseCd;
            printSQLException(ex, getClass().getName(), "fetchByLocationCdWarehouseCd", fetchByLocationCdWarehouseCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public AgencyStagingArea fetchByLocCdWhCdAgCd(Connection conn, String locationCd, String warehouseCd, String agencyCode)
        throws SQLException
    {
        try
        {
            fetchByLocCdWhCdAgCdStmt = conn.prepareStatement(fetchByLocCdWhCdAgCdSQL);
            fetchByLocCdWhCdAgCdStmt.setString(1, locationCd);
            fetchByLocCdWhCdAgCdStmt.setString(2, warehouseCd);
            fetchByLocCdWhCdAgCdStmt.setString(3, agencyCode);
            runQuery(fetchByLocCdWhCdAgCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + warehouseCd + ", " + agencyCode;
            printSQLException(ex, getClass().getName(), "fetchByLocCdWhCdAgCd", fetchByLocCdWhCdAgCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public AgencyStagingArea fetch(Connection conn)
        throws SQLException
    {
        try
        {
            fetchStmt = conn.prepareStatement(fetchSQL);
            runQuery(fetchStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchSQL, "");
            throw ex;
        }
        return fetchNext();
    }

    public AgencyStagingArea fetchNext()
        throws SQLException
    {
        AgencyStagingArea asa = new AgencyStagingArea();
        try
        {
            if(m_hasMore)
            {
                asa.setLocationCode(m_resultSet.getString(1));
                asa.setWarehouseCode(m_resultSet.getString(2));
                asa.setStagingAreaCode(m_resultSet.getString(3));
                asa.setAgencyCode(m_resultSet.getString(4));
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
                asa = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return asa;
    }

    public void save(Connection conn, AgencyStagingArea asa)
        throws SQLException
    {
        try
        {
            saveAgencyStagingAreaStmt = conn.prepareStatement(saveAgencyStagingAreaSQL);
            saveAgencyStagingAreaStmt.setString(1, asa.getLocationCode());
            saveAgencyStagingAreaStmt.setString(2, asa.getWarehouseCode());
            saveAgencyStagingAreaStmt.setString(3, asa.getStagingAreaCode());
            saveAgencyStagingAreaStmt.setString(4, asa.getAgencyCode());
            saveAgencyStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = asa.getLocationCode() + ", " + asa.getWarehouseCode() + ", " + asa.getStagingAreaCode() + ", " + asa.getAgencyCode();
            printSQLException(ex, getClass().getName(), "save", saveAgencyStagingAreaSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, AgencyStagingArea asa)
        throws SQLException
    {
        try
        {
            removeAgencyStagingAreaStmt = conn.prepareStatement(removeAgencyStagingAreaSQL);
            removeAgencyStagingAreaStmt.setString(1, asa.getLocationCode());
            removeAgencyStagingAreaStmt.setString(2, asa.getWarehouseCode());
            removeAgencyStagingAreaStmt.setString(3, asa.getStagingAreaCode());
            removeAgencyStagingAreaStmt.setString(4, asa.getAgencyCode());
            removeAgencyStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = asa.getLocationCode() + ", " + asa.getWarehouseCode() + ", " + asa.getStagingAreaCode() + ", " + asa.getAgencyCode();
            printSQLException(ex, getClass().getName(), "remove", removeAgencyStagingAreaSQL, paramList);
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
        db.closeConnection();
    }

    private static boolean dbTest(DatabaseBean db)
    {
        AgencyStagingArea asa = new AgencyStagingArea();
        asa.setLocationCode("XX1");
        asa.setWarehouseCode("YY1");
        asa.setStagingAreaCode("ZZ1");
        asa.setAgencyCode("DD");
        try
        {
            db.removeAgencyStagingArea(asa);
            db.saveAgencyStagingArea(asa);
            System.out.println("Test case 1 successful");
        }
        catch(SQLException ex)
        {
            System.out.println("Test case 1 unsuccessful" + ex);
        }
        try
        {
            asa = db.fetchAgencyStagingArea();
            for(int currentRow = 1; db.getAgencyStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row" + currentRow + " fetch Results- " + asa);
                asa = db.fetchNextAgencyStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 2 unsuccessful" + ex);
        }
        try
        {
            asa = db.fetchAgencyStagingAreaByLocCd();
            for(int currentRow = 1; db.getAgencyStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row" + currentRow + " fetchByLocationCd Results- " + asa);
                asa = db.fetchNextAgencyStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 3 unsuccessful" + ex);
        }
        try
        {
            db.setLocationCode("XX1");
            asa = db.fetchAgencyStagingAreaByLocCdWhCd("YY1");
            for(int currentRow = 1; db.getAgencyStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row" + currentRow + " fetchByLocationCdWarehouseCd Results- " + asa);
                asa = db.fetchNextAgencyStagingArea();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 4 unsuccessful" + ex);
        }
        try
        {
            asa = db.fetchAgencyStagingAreaByLocCdWhCdAgCd("YY1", "DD");
            for(int currentRow = 1; db.getAgencyStagingAreaRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row" + currentRow + " fetchByLocCdWhCdAgCd Results- " + asa);
                asa = db.fetchNextAgencyStagingArea();
            }

            AgencyStagingArea asa1 = new AgencyStagingArea("XX1", "YY1", "ZZ1", "DD");
            db.removeAgencyStagingArea(asa1);
        }
        catch(SQLException ex)
        {
            System.out.println("Test case 5 unsuccessful" + ex);
        }
        return true;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbAgencyStagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String table_name;
    private final String fetchByLocationCdSQL;
    private final String fetchByLocationCdWarehouseCdSQL;
    private final String fetchByLocCdWhCdAgCdSQL;
    private final String fetchSQL;
    private final String saveAgencyStagingAreaSQL;
    private final String removeAgencyStagingAreaSQL;
    private PreparedStatement fetchByLocationCdStmt;
    private PreparedStatement fetchByLocationCdWarehouseCdStmt;
    private PreparedStatement fetchByLocCdWhCdAgCdStmt;
    private PreparedStatement fetchStmt;
    private PreparedStatement saveAgencyStagingAreaStmt;
    private PreparedStatement removeAgencyStagingAreaStmt;
}
