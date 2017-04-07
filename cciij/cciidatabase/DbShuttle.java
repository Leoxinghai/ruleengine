// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbShuttle.java

package cciij.cciidatabase;

import cciij.cciidata.Shuttle;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbShuttle extends DbBase
{

    public DbShuttle()
    {
        selectAllShuttlesStmt = null;
        selectByLocationCdStmt = null;
        selectShuttleByLocationCdWarehouseCdStmt = null;
        selectShuttleByLocationWarehouseShuttleStmt = null;
        selectByDestLocShuttleCdLocationStmt = null;
        fetchByLocWarehouseDestStmt = null;
        saveShuttleStmt = null;
        updateShuttleStmt = null;
        deleteShuttleStmt = null;
    }

    public Shuttle fetchAll(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllShuttlesStmt = conn.prepareStatement("SELECT * FROM SHUTTLE ");
            runQuery(selectAllShuttlesStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAll", "SELECT * FROM SHUTTLE ", "");
            throw e;
        }
        return fetchNext();
    }

    public Shuttle fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            selectByLocationCdStmt = conn.prepareStatement("SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? ");
            selectByLocationCdStmt.setString(1, locationCd);
            runQuery(selectByLocationCdStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? ", locationCd);
            throw e;
        }
        return fetchNext();
    }

    public Shuttle fetch(Connection conn, String locationCd, String warehouseCd)
        throws SQLException
    {
        try
        {
            selectShuttleByLocationCdWarehouseCdStmt = conn.prepareStatement("SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ");
            selectShuttleByLocationCdWarehouseCdStmt.setString(1, locationCd);
            selectShuttleByLocationCdWarehouseCdStmt.setString(2, warehouseCd);
            runQuery(selectShuttleByLocationCdWarehouseCdStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ", locationCd + ", " + warehouseCd);
            throw e;
        }
        return fetchNext();
    }

    public Shuttle fetch(Connection conn, String locationCd, String warehouseCd, String shuttleId)
        throws SQLException
    {
        try
        {
            selectShuttleByLocationWarehouseShuttleStmt = conn.prepareStatement("SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? ");
            selectShuttleByLocationWarehouseShuttleStmt.setString(1, locationCd);
            selectShuttleByLocationWarehouseShuttleStmt.setString(2, warehouseCd);
            selectShuttleByLocationWarehouseShuttleStmt.setString(3, shuttleId);
            runQuery(selectShuttleByLocationWarehouseShuttleStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? ", locationCd + ", " + warehouseCd + ", " + shuttleId);
            throw e;
        }
        return fetchNext();
    }

    public Shuttle fetchByDestLocationCd(Connection conn, String locationCd, String destLocationCd, String shuttleCd)
        throws SQLException
    {
        try
        {
            selectByDestLocShuttleCdLocationStmt = conn.prepareStatement("SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND DEST_LOCATION_CD = ? AND SHUTTLE_CD = ? ");
            selectByDestLocShuttleCdLocationStmt.setString(1, locationCd);
            selectByDestLocShuttleCdLocationStmt.setString(2, destLocationCd);
            selectByDestLocShuttleCdLocationStmt.setString(3, shuttleCd);
            runQuery(selectByDestLocShuttleCdLocationStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchByDestLocationCd", "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND DEST_LOCATION_CD = ? AND SHUTTLE_CD = ? ", locationCd + ", " + destLocationCd + ", " + shuttleCd);
            throw e;
        }
        return fetchNext();
    }

    public Shuttle fetchByLocWhDest(Connection conn, String locationCd, String warehouseCd, String destLocationCd)
        throws SQLException
    {
        try
        {
            fetchByLocWarehouseDestStmt = conn.prepareStatement("SELECT * FROM SHUTTLE  WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? and DEST_LOCATION_CD = ? ");
            fetchByLocWarehouseDestStmt.setString(1, locationCd);
            fetchByLocWarehouseDestStmt.setString(2, warehouseCd);
            fetchByLocWarehouseDestStmt.setString(3, destLocationCd);
            runQuery(fetchByLocWarehouseDestStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchByLocWhDest", "SELECT * FROM SHUTTLE  WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? and DEST_LOCATION_CD = ? ", locationCd + ", " + warehouseCd + ", " + destLocationCd);
            throw e;
        }
        return fetchNext();
    }

    public void save(Connection conn, Shuttle shuttle)
        throws SQLException
    {
        try
        {
            saveShuttleStmt = conn.prepareStatement("INSERT INTO SHUTTLE ( LOCATION_CD, WAREHOUSE_CD, SHUTTLE_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, SHUTTLE_TYPE_CD, SHUTTLE_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )");
            saveShuttleStmt.setString(1, shuttle.getLocationCd());
            saveShuttleStmt.setString(2, shuttle.getWarehouseCd());
            saveShuttleStmt.setString(3, shuttle.getShuttleId());
            saveShuttleStmt.setString(4, shuttle.getDestinationLocationCd());
            saveShuttleStmt.setString(5, shuttle.getShuttleTypeCd());
            saveShuttleStmt.setString(6, shuttle.getSlideAreaCd());
            saveShuttleStmt.setString(7, shuttle.getShuttleStatusCd());
            saveShuttleStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "save", "INSERT INTO SHUTTLE ( LOCATION_CD, WAREHOUSE_CD, SHUTTLE_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, SHUTTLE_TYPE_CD, SHUTTLE_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )", shuttle.getLocationCd() + ", " + shuttle.getWarehouseCd() + ", " + shuttle.getShuttleId() + ", " + shuttle.getDestinationLocationCd() + ", " + shuttle.getShuttleTypeCd() + ", " + shuttle.getSlideAreaCd() + ", " + shuttle.getShuttleStatusCd());
            throw e;
        }
    }

    public void update(Connection conn, Shuttle shuttle)
        throws SQLException
    {
        try
        {
            updateShuttleStmt = conn.prepareStatement("UPDATE SHUTTLE SET SLIDE_AREA_CD = ?, SHUTTLE_TYPE_CD = ?, SHUTTLE_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ");
            updateShuttleStmt.setString(1, shuttle.getSlideAreaCd());
            updateShuttleStmt.setString(2, shuttle.getShuttleTypeCd());
            updateShuttleStmt.setString(3, shuttle.getShuttleStatusCd());
            updateShuttleStmt.setString(4, shuttle.getLocationCd());
            updateShuttleStmt.setString(5, shuttle.getWarehouseCd());
            updateShuttleStmt.setString(6, shuttle.getShuttleId());
            updateShuttleStmt.setString(7, shuttle.getDestinationLocationCd());
            updateShuttleStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "update", "UPDATE SHUTTLE SET SLIDE_AREA_CD = ?, SHUTTLE_TYPE_CD = ?, SHUTTLE_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ", shuttle.getSlideAreaCd() + ", " + shuttle.getShuttleTypeCd() + ", " + shuttle.getShuttleStatusCd() + ", " + shuttle.getLocationCd() + ", " + shuttle.getWarehouseCd() + ", " + shuttle.getShuttleId() + ", " + shuttle.getDestinationLocationCd());
            throw e;
        }
    }

    public void delete(Connection conn, Shuttle shuttle)
        throws SQLException
    {
        try
        {
            deleteShuttleStmt = conn.prepareStatement("DELETE FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ");
            deleteShuttleStmt.setString(1, shuttle.getLocationCd());
            deleteShuttleStmt.setString(2, shuttle.getWarehouseCd());
            deleteShuttleStmt.setString(3, shuttle.getShuttleId());
            deleteShuttleStmt.setString(4, shuttle.getDestinationLocationCd());
            deleteShuttleStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "delete", "DELETE FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ", shuttle.getLocationCd() + ", " + shuttle.getWarehouseCd() + ", " + shuttle.getShuttleId() + ", " + shuttle.getDestinationLocationCd());
            throw e;
        }
    }

    public Shuttle fetchNext()
        throws SQLException
    {
        Shuttle shuttle = new Shuttle();
        if(m_hasMore)
        {
            shuttle.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            shuttle.setWarehouseCd(m_resultSet.getString("WAREHOUSE_CD"));
            shuttle.setShuttleId(m_resultSet.getString("SHUTTLE_CD"));
            shuttle.setDestinationLocationCd(m_resultSet.getString("DEST_LOCATION_CD"));
            shuttle.setSlideAreaCd(m_resultSet.getString("SLIDE_AREA_CD"));
            shuttle.setShuttleTypeCd(m_resultSet.getString("SHUTTLE_TYPE_CD"));
            shuttle.setShuttleStatusCd(m_resultSet.getString("SHUTTLE_STATUS_CD"));
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
            shuttle = null;
            m_recordCount = 0;
        }
        return shuttle;
    }

    public int getShuttleRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbShuttle dbShuttle = new DbShuttle();
        dbShuttle.testDbShuttle(db);
        db.closeConnection();
    }

    private void testDbShuttle(DatabaseBean db)
    {
        Shuttle shuttle = null;
        try
        {
            System.out.println("============Executing INSERT LOC4, WH1, SA1, CD1");
            db.saveShuttle(new Shuttle("LOC4", "WH1", "SA1", "CD1", "AA", "BB", "CC"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting shuttle " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4");
            shuttle = db.fetchShuttleByLocationCd();
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE BY LOCATION_CD LOC4");
            db.updateShuttle(new Shuttle("LOC4", "WH1", "SA1", "CD1", "AA", "BB", "XX"));
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATION_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT *");
            if((shuttle = db.fetchAllShuttle()) != null)
                System.out.println(shuttle);
            while((shuttle = db.fetchNextShuttle()) != null) 
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all shuttle " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4");
            shuttle = db.fetchShuttleByLocationCd();
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting shuttle by shuttle " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD WAREHOUSE_CD WH1");
            shuttle = db.fetchShuttleByWarehouseCdLocationCd("WH1");
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting shuttle by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD WAREHOUSE_CD  SHUTTLE_CD ");
            shuttle = db.fetchShuttleByLocWhShuttleCd("WH1", "SA1");
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting shuttle by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD DEST_LOCATION_CD  SHUTTLE_CD ");
            shuttle = db.fetchShuttleByDestLocShuttleCd("WH1", "CD1");
            if(shuttle != null)
                System.out.println(shuttle);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting shuttle by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE LOC4, WH1, SA1, CD1 ");
            db.removeShuttle(new Shuttle("LOC4", "WH1", "SA1", "CD1", "AA", "BB", "XX"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting InterceptStagingArea " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4");
            shuttle = db.fetchShuttleByLocationCd();
            if(shuttle != null)
                System.out.println(shuttle);
            else
                System.out.println("Shuttle not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting LOCATION_CD " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbShuttle.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private static final String tableName = "SHUTTLE ";
    private static final String selectAllShuttlesSQL = "SELECT * FROM SHUTTLE ";
    private static final String selectByLocationCdSQL = "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? ";
    private static final String selectByLocationCdWarehouseCdSQL = "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? ";
    private static final String selectByLocationWarehouseShuttleSQL = "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? ";
    private static final String selectByDestLocShuttleCdLocationSQL = "SELECT * FROM SHUTTLE WHERE LOCATION_CD = ? AND DEST_LOCATION_CD = ? AND SHUTTLE_CD = ? ";
    private static final String fetchByLocWarehouseDestSQL = "SELECT * FROM SHUTTLE  WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? and DEST_LOCATION_CD = ? ";
    private static final String saveShuttleSQL = "INSERT INTO SHUTTLE ( LOCATION_CD, WAREHOUSE_CD, SHUTTLE_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, SHUTTLE_TYPE_CD, SHUTTLE_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )";
    private static final String updateShuttleSQL = "UPDATE SHUTTLE SET SLIDE_AREA_CD = ?, SHUTTLE_TYPE_CD = ?, SHUTTLE_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ";
    private static final String deleteShuttleSQL = "DELETE FROM SHUTTLE WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND SHUTTLE_CD = ? AND DEST_LOCATION_CD = ? ";
    private PreparedStatement selectAllShuttlesStmt;
    private PreparedStatement selectByLocationCdStmt;
    private PreparedStatement selectShuttleByLocationCdWarehouseCdStmt;
    private PreparedStatement selectShuttleByLocationWarehouseShuttleStmt;
    private PreparedStatement selectByDestLocShuttleCdLocationStmt;
    private PreparedStatement fetchByLocWarehouseDestStmt;
    private PreparedStatement saveShuttleStmt;
    private PreparedStatement updateShuttleStmt;
    private PreparedStatement deleteShuttleStmt;
}
