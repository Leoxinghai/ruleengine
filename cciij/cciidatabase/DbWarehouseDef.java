// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbWarehouseDef.java

package cciij.cciidatabase;

import cciij.cciidata.WarehouseDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbWarehouseDef extends DbBase
{

    public DbWarehouseDef()
    {
        fetchWithLocationCdStmt = null;
        fetchWithWarehouseCdStmt = null;
        fetchStmt = null;
        saveWarehouseDefStmt = null;
        updateWarehouseDefStmt = null;
        removeWarehouseDefStmt = null;
    }

    public int getWarehouseDefRecordCount()
    {
        return m_recordCount;
    }

    public WarehouseDef fetchByLocationCd(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchWithLocationCdStmt = conn.prepareStatement("SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? ORDER BY WAREHOUSE_CD");
            fetchWithLocationCdStmt.setString(1, locationCd);
            runQuery(fetchWithLocationCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByLocationCd", "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? ORDER BY WAREHOUSE_CD", locationCd);
            throw ex;
        }
        return fetchNext();
    }

    public WarehouseDef fetchByWarehouseCd(Connection conn, String warehouseCd)
        throws SQLException
    {
        try
        {
            fetchWithWarehouseCdStmt = conn.prepareStatement("SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE WAREHOUSE_CD = ? ORDER BY LOCATION_CD");
            fetchWithWarehouseCdStmt.setString(1, warehouseCd);
            runQuery(fetchWithWarehouseCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByWarehouseCd", "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE WAREHOUSE_CD = ? ORDER BY LOCATION_CD", warehouseCd);
            throw ex;
        }
        return fetchNext();
    }

    public WarehouseDef fetch(Connection conn)
        throws SQLException
    {
        try
        {
            fetchStmt = conn.prepareStatement("SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF ORDER BY LOCATION_CD, WAREHOUSE_CD");
            runQuery(fetchStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF ORDER BY LOCATION_CD, WAREHOUSE_CD", "");
            throw ex;
        }
        return fetchNext();
    }

    public WarehouseDef fetchNext()
        throws SQLException
    {
        WarehouseDef whd = new WarehouseDef();
        try
        {
            if(m_hasMore)
            {
                whd.setLocationCode(m_resultSet.getString(1));
                whd.setWarehouseCode(m_resultSet.getString(2));
                whd.setWarehouseDescription(m_resultSet.getString(3));
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
                whd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return whd;
    }

    public void save(Connection conn, WarehouseDef whd)
        throws SQLException
    {
        try
        {
            saveWarehouseDefStmt = conn.prepareStatement("INSERT INTO ENT.WAREHOUSE_DEF(LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC) VALUES(?,?,?)");
            saveWarehouseDefStmt.setString(1, whd.getLocationCode());
            saveWarehouseDefStmt.setString(2, whd.getWarehouseCode());
            saveWarehouseDefStmt.setString(3, whd.getWarehouseDescription());
            saveWarehouseDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", "INSERT INTO ENT.WAREHOUSE_DEF(LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC) VALUES(?,?,?)", whd.getLocationCode() + ", " + whd.getWarehouseCode() + ", " + whd.getWarehouseDescription());
            throw ex;
        }
    }

    public void update(Connection conn, WarehouseDef whd)
        throws SQLException
    {
        try
        {
            updateWarehouseDefStmt = conn.prepareStatement("UPDATE ENT.WAREHOUSE_DEF SET WAREHOUSE_DESC = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?");
            updateWarehouseDefStmt.setString(1, whd.getWarehouseDescription());
            updateWarehouseDefStmt.setString(2, whd.getLocationCode());
            updateWarehouseDefStmt.setString(3, whd.getWarehouseCode());
            updateWarehouseDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", "UPDATE ENT.WAREHOUSE_DEF SET WAREHOUSE_DESC = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?", whd.getWarehouseDescription() + ", " + whd.getLocationCode() + ", " + whd.getWarehouseCode());
            throw ex;
        }
    }

    public void remove(Connection conn, WarehouseDef whd)
        throws SQLException
    {
        try
        {
            removeWarehouseDefStmt = conn.prepareStatement("DELETE FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?");
            removeWarehouseDefStmt.setString(1, whd.getLocationCode());
            removeWarehouseDefStmt.setString(2, whd.getWarehouseCode());
            removeWarehouseDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", "DELETE FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?", whd.getLocationCode() + ", " + whd.getWarehouseCode());
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
        WarehouseDef whd = new WarehouseDef();
        try
        {
            whd.setLocationCode("JS5");
            whd.setWarehouseCode("SS5");
            whd.setWarehouseDescription("Test Insert");
            db.removeWarehouseDef(whd);
            db.saveWarehouseDef(whd);
            System.out.println("Test case 1 successful");
        }
        catch(SQLException ex)
        {
            System.out.println("Test case 1 unsuccessful" + ex);
        }
        try
        {
            whd = db.fetchWarehouseDefByWhCd("SS5");
            for(int currentRow = 1; db.getWarehouseDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row " + currentRow + "-Results of fetchByWarehouseCd(whCd)" + whd);
                whd = db.fetchNextWarehouseDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 2 unsuccessful" + ex);
        }
        try
        {
            WarehouseDef whd1 = new WarehouseDef();
            whd1.setLocationCode("JS5");
            whd1.setWarehouseCode("SS5");
            whd1.setWarehouseDescription("Test Update");
            db.updateWarehouseDef(whd1);
            System.out.println("Test Case 3 successful");
        }
        catch(SQLException ex)
        {
            System.out.println("Test case 3 unsuccessful" + ex);
        }
        try
        {
            whd = db.fetchWarehouseDef();
            for(int currentRow = 1; db.getWarehouseDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row " + currentRow + "-Results of fetch()" + whd);
                whd = db.fetchNextWarehouseDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 4 unsuccessful" + ex);
        }
        try
        {
            WarehouseDef whd1 = new WarehouseDef();
            whd1.setLocationCode("SS5");
            whd1.setWarehouseCode("JS5");
            db.removeWarehouseDef(whd1);
            System.out.println("Test Case 5 successful");
        }
        catch(SQLException ex)
        {
            System.out.println("Test case 5 unsuccessful" + ex);
        }
        try
        {
            db.setLocationCode("JS9");
            whd = db.fetchWarehouseDefByLocCd();
            for(int currentRow = 1; db.getWarehouseDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 6: Row " + currentRow + "-Results of fetchByLocCd(locationCd)" + whd);
                whd = db.fetchNextWarehouseDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test case 6 unsuccessful" + ex);
        }
        return true;
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbWarehouseDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private final String table_name = "ENT.WAREHOUSE_DEF";
    private final String fetchWithLocationCdSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? ORDER BY WAREHOUSE_CD";
    private final String fetchWithWarehouseCdSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF WHERE WAREHOUSE_CD = ? ORDER BY LOCATION_CD";
    private final String fetchSQL = "SELECT LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC FROM ENT.WAREHOUSE_DEF ORDER BY LOCATION_CD, WAREHOUSE_CD";
    private final String saveWarehouseDefSQL = "INSERT INTO ENT.WAREHOUSE_DEF(LOCATION_CD, WAREHOUSE_CD, WAREHOUSE_DESC) VALUES(?,?,?)";
    private final String updateWarehouseDefSQL = "UPDATE ENT.WAREHOUSE_DEF SET WAREHOUSE_DESC = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?";
    private final String removeWarehouseDefSQL = "DELETE FROM ENT.WAREHOUSE_DEF WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ?";
    private PreparedStatement fetchWithLocationCdStmt;
    private PreparedStatement fetchWithWarehouseCdStmt;
    private PreparedStatement fetchStmt;
    private PreparedStatement saveWarehouseDefStmt;
    private PreparedStatement updateWarehouseDefStmt;
    private PreparedStatement removeWarehouseDefStmt;
}
