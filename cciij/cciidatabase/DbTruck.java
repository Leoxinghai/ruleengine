/*
 * Created on Aug 4, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.cciidatabase;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import cciij.cciidata.Truck;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbTruck extends DbBase
{

    public DbTruck()
    {
        fetchTruckByTruckIdStmt = null;
        saveTruckStmt = null;
        updateTruckStmt = null;
        deleteTruckStmt = null;
    }


    public Truck fetchTruckByTruckId(Connection conn, String truckId)
        throws SQLException
    {
        try
        {
            fetchTruckByTruckIdStmt = conn.prepareStatement(fetchTruckByTruckIdSQL);
//            fetchTruckByTruckIdStmt.setString(1, locationCd);
            fetchTruckByTruckIdStmt.setString(1, truckId);
            runQuery(fetchTruckByTruckIdStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchByLocWhDest", "SELECT * FROM LOCAL_TRUCK_TH  WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? and DEST_LOCATION_CD = ? ",  ", " + truckId);
            throw e;
        }
        return fetchNext();
    }

    public void save(Connection conn, Truck truck)
        throws SQLException
    {
        try
        {
            saveTruckStmt = conn.prepareStatement("INSERT INTO LOCAL_TRUCK_TH ( LOCATION_CD, WAREHOUSE_CD, LOCAL_TRUCK_TH_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, LOCAL_TRUCK_TH_TYPE_CD, LOCAL_TRUCK_TH_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )");
            saveTruckStmt.setString(1, truck.getLocationCd());
            saveTruckStmt.setString(2, truck.getWarehouseCd());
            saveTruckStmt.setString(3, truck.getTruckId());
            saveTruckStmt.setString(4, truck.getDestinationLocationCd());
            saveTruckStmt.setString(5, truck.getTruckTypeCd());
            saveTruckStmt.setString(6, truck.getSlideAreaCd());
            saveTruckStmt.setString(7, truck.getTruckStatusCd());
            saveTruckStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "save", "INSERT INTO LOCAL_TRUCK_TH ( LOCATION_CD, WAREHOUSE_CD, LOCAL_TRUCK_TH_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, LOCAL_TRUCK_TH_TYPE_CD, LOCAL_TRUCK_TH_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )", truck.getLocationCd() + ", " + truck.getWarehouseCd() + ", " + truck.getTruckId() + ", " + truck.getDestinationLocationCd() + ", " + truck.getTruckTypeCd() + ", " + truck.getSlideAreaCd() + ", " + truck.getTruckStatusCd());
            throw e;
        }
    }

    public void update(Connection conn, Truck truck)
        throws SQLException
    {
        try
        {
            updateTruckStmt = conn.prepareStatement("UPDATE LOCAL_TRUCK_TH SET SLIDE_AREA_CD = ?, LOCAL_TRUCK_TH_TYPE_CD = ?, LOCAL_TRUCK_TH_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ");
            updateTruckStmt.setString(1, truck.getSlideAreaCd());
            updateTruckStmt.setString(2, truck.getTruckTypeCd());
            updateTruckStmt.setString(3, truck.getTruckStatusCd());
            updateTruckStmt.setString(4, truck.getLocationCd());
            updateTruckStmt.setString(5, truck.getWarehouseCd());
            updateTruckStmt.setString(6, truck.getTruckId());
            updateTruckStmt.setString(7, truck.getDestinationLocationCd());
            updateTruckStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "update", "UPDATE LOCAL_TRUCK_TH SET SLIDE_AREA_CD = ?, LOCAL_TRUCK_TH_TYPE_CD = ?, LOCAL_TRUCK_TH_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ", truck.getSlideAreaCd() + ", " + truck.getTruckTypeCd() + ", " + truck.getTruckStatusCd() + ", " + truck.getLocationCd() + ", " + truck.getWarehouseCd() + ", " + truck.getTruckId() + ", " + truck.getDestinationLocationCd());
            throw e;
        }
    }

    public void delete(Connection conn, Truck truck)
        throws SQLException
    {
        try
        {
            deleteTruckStmt = conn.prepareStatement("DELETE FROM LOCAL_TRUCK_TH WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ");
            deleteTruckStmt.setString(1, truck.getLocationCd());
            deleteTruckStmt.setString(2, truck.getWarehouseCd());
            deleteTruckStmt.setString(3, truck.getTruckId());
            deleteTruckStmt.setString(4, truck.getDestinationLocationCd());
            deleteTruckStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "delete", "DELETE FROM LOCAL_TRUCK_TH WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ", truck.getLocationCd() + ", " + truck.getWarehouseCd() + ", " + truck.getTruckId() + ", " + truck.getDestinationLocationCd());
            throw e;
        }
    }

    public Truck fetchNext()
        throws SQLException
    {
        Truck truck = new Truck();
        if(m_hasMore)
        {
            truck.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            truck.setTruckId(m_resultSet.getString("TRUCK_NBR"));
            truck.setActiveFlag(m_resultSet.getString("ACTIVE_FLG"));
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
            truck = null;
            m_recordCount = 0;
        }
        return truck;
    }

    public int getTruckRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbTruck dbTruck = new DbTruck();
//        dbTruck.testDbTruck(db);
        db.closeConnection();
    }

    private void testDbTruck(DatabaseBean db)
    {
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbTruck.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    private static final String tableName = "LOCAL_TRUCK_TH ";
    private static final String fetchTruckByTruckIdSQL = "SELECT * FROM LOCAL_TRUCK_TH  WHERE TRUCK_NBR = ? ";
    private static final String saveTruckSQL = "INSERT INTO LOCAL_TRUCK_TH ( LOCATION_CD, WAREHOUSE_CD, LOCAL_TRUCK_TH_CD, DEST_LOCATION_CD, SLIDE_AREA_CD, LOCAL_TRUCK_TH_TYPE_CD, LOCAL_TRUCK_TH_STATUS_CD ) VALUES( ?,?,?,?,?,?,? )";
    private static final String updateTruckSQL = "UPDATE LOCAL_TRUCK_TH SET SLIDE_AREA_CD = ?, LOCAL_TRUCK_TH_TYPE_CD = ?, LOCAL_TRUCK_TH_STATUS_CD = ? WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ";
    private static final String deleteTruckSQL = "DELETE FROM LOCAL_TRUCK_TH WHERE LOCATION_CD = ? AND WAREHOUSE_CD = ? AND LOCAL_TRUCK_TH_CD = ? AND DEST_LOCATION_CD = ? ";
    private PreparedStatement fetchTruckByTruckIdStmt;
    private PreparedStatement saveTruckStmt;
    private PreparedStatement updateTruckStmt;
    private PreparedStatement deleteTruckStmt;
}

