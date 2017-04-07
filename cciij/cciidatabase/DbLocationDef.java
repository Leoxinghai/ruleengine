// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbLocationDef.java

package cciij.cciidatabase;

import cciij.cciidata.LocationDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbLocationDef extends DbBase
{

    public DbLocationDef()
    {
        selectAllLocationDefStmt = null;
        selectLocationDefByLocStmt = null;
        saveLocationDefStmt = null;
        updateLocationDefStmt = null;
        deleteLocationDefStmt = null;
    }

    public LocationDef fetchNext()
        throws SQLException
    {
        LocationDef locationDef = new LocationDef();
        if(m_hasMore)
        {
            locationDef.setLocationCode(locationCode);
            locationDef.setDistrictNumber(m_resultSet.getString("DISTRICT_NBR"));
            locationDef.setPortNumber(m_resultSet.getString("PORT_NBR"));
            locationDef.setCityName(m_resultSet.getString("CITY_NM"));
            locationDef.setStateCode(m_resultSet.getString("STATE_CD"));
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
            locationDef = null;
            m_recordCount = 0;
        }
        return locationDef;
    }

    public LocationDef fetchAllLocationDef(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllLocationDefStmt = conn.prepareStatement("SELECT LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF ");
            runQuery(selectAllLocationDefStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAllLocationDef", "SELECT LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF ", "");
            throw e;
        }
        return fetchNext();
    }

    public LocationDef fetchLocationDef(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            locationCode = locationCd;
            selectLocationDefByLocStmt = conn.prepareStatement("SELECT DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF  WHERE LOCATION_CD = ? ");
            selectLocationDefByLocStmt.setString(1, locationCd);
            runQuery(selectLocationDefByLocStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchLocationDef", "SELECT DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF  WHERE LOCATION_CD = ? ", locationCd);
            throw e;
        }
        return fetchNext();
    }

    public void saveLocationDef(Connection conn, LocationDef locationDef)
        throws SQLException
    {
        try
        {
            saveLocationDefStmt = conn.prepareStatement("INSERT INTO ENT.LOCATION_DEF ( LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD )  VALUES( ?,?,?,?,? )");
            saveLocationDefStmt.setString(1, locationDef.getLocationCode());
            saveLocationDefStmt.setString(2, locationDef.getDistrictNumber());
            saveLocationDefStmt.setString(3, locationDef.getPortNumber());
            saveLocationDefStmt.setString(4, locationDef.getCityName());
            saveLocationDefStmt.setString(5, locationDef.getStateCode());
            saveLocationDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "saveLocationDef", "INSERT INTO ENT.LOCATION_DEF ( LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD )  VALUES( ?,?,?,?,? )", locationDef.getLocationCode() + ", " + locationDef.getDistrictNumber() + ", " + locationDef.getPortNumber() + ", " + locationDef.getCityName() + ", " + locationDef.getStateCode());
            throw e;
        }
    }

    public void updateLocationDef(Connection conn, LocationDef locationDef)
        throws SQLException
    {
        try
        {
            updateLocationDefStmt = conn.prepareStatement("UPDATE ENT.LOCATION_DEF SET DISTRICT_NBR = ?, PORT_NBR = ?, CITY_NM = ?, STATE_CD = ? WHERE LOCATION_CD = ? ");
            updateLocationDefStmt.setString(1, locationDef.getDistrictNumber());
            updateLocationDefStmt.setString(2, locationDef.getPortNumber());
            updateLocationDefStmt.setString(3, locationDef.getCityName());
            updateLocationDefStmt.setString(4, locationDef.getStateCode());
            updateLocationDefStmt.setString(5, locationDef.getLocationCode());
            updateLocationDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "updateLocationDef", "UPDATE ENT.LOCATION_DEF SET DISTRICT_NBR = ?, PORT_NBR = ?, CITY_NM = ?, STATE_CD = ? WHERE LOCATION_CD = ? ", locationDef.getDistrictNumber() + ", " + locationDef.getPortNumber() + ", " + locationDef.getCityName() + ", " + locationDef.getStateCode() + ", " + locationDef.getLocationCode());
            throw e;
        }
    }

    public void deleteLocationDef(Connection conn, LocationDef locationDef)
        throws SQLException
    {
        try
        {
            deleteLocationDefStmt = conn.prepareStatement("DELETE FROM ENT.LOCATION_DEF WHERE LOCATION_CD = ? ");
            deleteLocationDefStmt.setString(1, locationDef.getLocationCode());
            deleteLocationDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "deleteLocationDef", "DELETE FROM ENT.LOCATION_DEF WHERE LOCATION_CD = ? ", locationDef.getLocationCode());
            throw e;
        }
    }

    public int getLocationDefRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("OAK1");
        db.connect();
        DbLocationDef dbLocationDef = new DbLocationDef();
        dbLocationDef.testDbLocationDef(db);
        db.closeConnection();
    }

    private void testDbLocationDef(DatabaseBean db)
    {
        LocationDef locationDef = null;
        try
        {
            System.out.println("============Executing INSERT OAK1, 123, 456, OAKLAND, CA ");
            db.saveLocationDef(new LocationDef("OAK1", "123", "456", "OAKLAND", "CA"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting locationDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD OAK1");
            locationDef = db.fetchLocationDef("OAK1");
            if(locationDef != null)
                System.out.println(locationDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE LOCATION_CD OAK1");
            db.updateLocationDef(new LocationDef("OAK1", "789", "012", "OAKLAND", "CA"));
            if(locationDef != null)
                System.out.println(locationDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATION_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT *");
            if((locationDef = db.fetchAllLocationDef()) != null)
                System.out.println(locationDef);
            while((locationDef = db.fetchNextLocationDef()) != null) 
                System.out.println(locationDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all locationDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD OAK1 ");
            locationDef = db.fetchLocationDef("OAK1");
            if(locationDef != null)
                System.out.println(locationDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting locationDef by locationcd " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE OAK1, 789, 012, OAKLAND, CA ");
            db.removeLocationDef(new LocationDef("OAK1", "789", "012", "OAKLAND", "CA"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while deleting Location " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD OAK1 ");
            locationDef = db.fetchLocationDef("OAK1");
            if(locationDef != null)
                System.out.println(locationDef);
            else
                System.out.println("LocationDef not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting locationDef " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbLocationDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private final String tableName = "ENT.LOCATION_DEF ";
    private final String selectAllLocationDefSQL = "SELECT LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF ";
    private final String selectLocationDefByLocSQL = "SELECT DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD FROM ENT.LOCATION_DEF  WHERE LOCATION_CD = ? ";
    private final String saveLocationDefSQL = "INSERT INTO ENT.LOCATION_DEF ( LOCATION_CD, DISTRICT_NBR, PORT_NBR, CITY_NM, STATE_CD )  VALUES( ?,?,?,?,? )";
    private final String updateLocationDefSQL = "UPDATE ENT.LOCATION_DEF SET DISTRICT_NBR = ?, PORT_NBR = ?, CITY_NM = ?, STATE_CD = ? WHERE LOCATION_CD = ? ";
    private final String deleteLocationDefSQL = "DELETE FROM ENT.LOCATION_DEF WHERE LOCATION_CD = ? ";
    private PreparedStatement selectAllLocationDefStmt;
    private PreparedStatement selectLocationDefByLocStmt;
    private PreparedStatement saveLocationDefStmt;
    private PreparedStatement updateLocationDefStmt;
    private PreparedStatement deleteLocationDefStmt;
    private String locationCode;
}
