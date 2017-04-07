// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbInterceptStagingArea.java

package cciij.cciidatabase;

import cciij.cciidata.InterceptStagingArea;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbInterceptStagingArea extends DbBase
{

    public DbInterceptStagingArea()
    {
        selectAllStmt = null;
        selectByLocationCdStmt = null;
        selectByWarehouseCdLocationCdStmt = null;
        selectByLocIntecptWhStmt = null;
        saveInterceptStagingAreaStmt = null;
        removeInterceptStagingAreaStmt = null;
    }

    public void save(Connection conn, InterceptStagingArea interceptStagingArea)
        throws SQLException
    {
        try
        {
            saveInterceptStagingAreaStmt = conn.prepareStatement("INSERT INTO ENT.INTERCEPT_STAGING_AREA VALUES( ?, ?, ?, ?)");
            saveInterceptStagingAreaStmt.setString(1, interceptStagingArea.getLocationCd());
            saveInterceptStagingAreaStmt.setString(2, interceptStagingArea.getWarehouseCd());
            saveInterceptStagingAreaStmt.setString(3, interceptStagingArea.getStagingAreaCd());
            saveInterceptStagingAreaStmt.setString(4, interceptStagingArea.getInterceptCd());
            saveInterceptStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = interceptStagingArea.getLocationCd() + ", " + interceptStagingArea.getWarehouseCd() + ", " + interceptStagingArea.getStagingAreaCd() + ", " + interceptStagingArea.getInterceptCd();
            printSQLException(ex, getClass().getName(), "save", "INSERT INTO ENT.INTERCEPT_STAGING_AREA VALUES( ?, ?, ?, ?)", paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, InterceptStagingArea interceptStagingArea)
        throws SQLException
    {
        try
        {
            removeInterceptStagingAreaStmt = conn.prepareStatement("DELETE FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND STAGING_AREA_CD = ? AND INTERCEPT_CD = ?");
            removeInterceptStagingAreaStmt.setString(1, interceptStagingArea.getLocationCd());
            removeInterceptStagingAreaStmt.setString(2, interceptStagingArea.getWarehouseCd());
            removeInterceptStagingAreaStmt.setString(3, interceptStagingArea.getStagingAreaCd());
            removeInterceptStagingAreaStmt.setString(4, interceptStagingArea.getInterceptCd());
            removeInterceptStagingAreaStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = interceptStagingArea.getLocationCd() + ", " + interceptStagingArea.getWarehouseCd() + ", " + interceptStagingArea.getStagingAreaCd() + ", " + interceptStagingArea.getInterceptCd();
            printSQLException(ex, getClass().getName(), "remove", "DELETE FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND STAGING_AREA_CD = ? AND INTERCEPT_CD = ?", paramList);
            throw ex;
        }
    }

    public InterceptStagingArea fetch(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllStmt = conn.prepareStatement("SELECT * FROM ENT.INTERCEPT_STAGING_AREA ");
            runQuery(selectAllStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM ENT.INTERCEPT_STAGING_AREA ", " ");
            throw ex;
        }
        return fetchNext();
    }

    public InterceptStagingArea fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            selectByLocationCdStmt = conn.prepareStatement("SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? ");
            selectByLocationCdStmt.setString(1, locationCd);
            runQuery(selectByLocationCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptStagingArea fetch(Connection conn, String locationCd, String warehouseCd)
        throws SQLException
    {
        try
        {
            selectByWarehouseCdLocationCdStmt = conn.prepareStatement("SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ");
            selectByWarehouseCdLocationCdStmt.setString(1, locationCd);
            selectByWarehouseCdLocationCdStmt.setString(2, warehouseCd);
            runQuery(selectByWarehouseCdLocationCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + warehouseCd;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptStagingArea fetch(Connection conn, String locationCd, String warehouseCd, String interceptCd)
        throws SQLException
    {
        try
        {
            selectByLocIntecptWhStmt = conn.prepareStatement("SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE WAREHOUSE_CD = ? AND LOCATION_CD = ? AND INTERCEPT_CD = ? ORDER BY INTERCEPT_CD");
            selectByLocIntecptWhStmt.setString(1, warehouseCd);
            selectByLocIntecptWhStmt.setString(2, locationCd);
            selectByLocIntecptWhStmt.setString(3, interceptCd);
            runQuery(selectByLocIntecptWhStmt);
        }
        catch(SQLException ex)
        {
            String paramList = warehouseCd + ", " + locationCd + ", " + interceptCd;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE WAREHOUSE_CD = ? AND LOCATION_CD = ? AND INTERCEPT_CD = ? ORDER BY INTERCEPT_CD", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptStagingArea fetchNext()
        throws SQLException
    {
        InterceptStagingArea interceptStagingArea = new InterceptStagingArea();
        if(m_hasMore)
        {
            interceptStagingArea.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            interceptStagingArea.setWarehouseCd(m_resultSet.getString("WAREHOUSE_CD"));
            interceptStagingArea.setStagingAreaCd(m_resultSet.getString("STAGING_AREA_CD"));
            interceptStagingArea.setInterceptCd(m_resultSet.getString("INTERCEPT_CD"));
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
            catch(SQLException ex)
            {
                printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
                throw ex;
            }
        } else
        {
            interceptStagingArea = null;
            m_recordCount = 0;
        }
        return interceptStagingArea;
    }

    public int getInterceptStagingAreaRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC1");
        db.connect();
        DbInterceptStagingArea dbInterceptStagingArea = new DbInterceptStagingArea();
        dbInterceptStagingArea.testDbInterceptStagingArea(db);
        db.closeConnection();
    }

    private void testDbInterceptStagingArea(DatabaseBean db)
    {
        InterceptStagingArea interceptStagingArea = null;
        try
        {
            System.out.println("===============Executing SELECT *");
            if((interceptStagingArea = db.fetchInterceptStagingArea()) != null)
                System.out.println(interceptStagingArea);
            while((interceptStagingArea = db.fetchNextInterceptStagingArea()) != null) 
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all InterceptStagingAreas " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC1");
            interceptStagingArea = db.fetchByLocationCd();
            if(interceptStagingArea != null)
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting InterceptStagingAreas by InterceptStagingArea " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC1, WAREHOUSE_CD WH1");
            interceptStagingArea = db.fetchByWarehouseCdLocationCd("WH1");
            if(interceptStagingArea != null)
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting InterceptStagingAreas by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC1, WAREHOUSE_CD WH1 INTERCEPT_CD  CD2");
            interceptStagingArea = db.fetchInterceptStagingAreaByWhCdIntCd("WH1", "CD1");
            if(interceptStagingArea != null)
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting InterceptStagingAreas by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing INSERT LOC4, WH1, SA1, CD1");
            db.saveInterceptStagingArea(new InterceptStagingArea("LOC4", "WH1", "SA1", "CD1"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting InterceptStagingArea " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT * ");
            if((interceptStagingArea = db.fetchInterceptStagingArea()) != null)
                System.out.println(interceptStagingArea);
            while((interceptStagingArea = db.fetchNextInterceptStagingArea()) != null) 
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE LOC4, WH1, SA1, CD1 ");
            db.removeInterceptStagingArea(new InterceptStagingArea("LOC4", "WH1", "SA1", "CD1"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting InterceptStagingArea " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT * ");
            if((interceptStagingArea = db.fetchInterceptStagingArea()) != null)
                System.out.println(interceptStagingArea);
            while((interceptStagingArea = db.fetchNextInterceptStagingArea()) != null) 
                System.out.println(interceptStagingArea);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbInterceptStagingArea.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private final String m_tableName = "ENT.INTERCEPT_STAGING_AREA ";
    private final String selectAllSQL = "SELECT * FROM ENT.INTERCEPT_STAGING_AREA ";
    private final String selectByLocationCdSQL = "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? ";
    private final String selectByWarehouseCdLocationCdSQL = "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ";
    private final String selectByLocIntecptWhSQL = "SELECT * FROM ENT.INTERCEPT_STAGING_AREA WHERE WAREHOUSE_CD = ? AND LOCATION_CD = ? AND INTERCEPT_CD = ? ORDER BY INTERCEPT_CD";
    private final String saveInterceptStagingAreaSQL = "INSERT INTO ENT.INTERCEPT_STAGING_AREA VALUES( ?, ?, ?, ?)";
    private final String removeInterceptStagingAreaSQL = "DELETE FROM ENT.INTERCEPT_STAGING_AREA WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND STAGING_AREA_CD = ? AND INTERCEPT_CD = ?";
    private PreparedStatement selectAllStmt;
    private PreparedStatement selectByLocationCdStmt;
    private PreparedStatement selectByWarehouseCdLocationCdStmt;
    private PreparedStatement selectByLocIntecptWhStmt;
    private PreparedStatement saveInterceptStagingAreaStmt;
    private PreparedStatement removeInterceptStagingAreaStmt;
}
