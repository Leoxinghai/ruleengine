// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbFlightInfo.java

package cciij.cciidatabase;

import cciij.cciidata.FlightInfo;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbFlightInfo extends DbBase
{

    public DbFlightInfo()
    {
        fetchFlightInfoStmt = null;
    }

    public FlightInfo fetch(Connection conn, String routeNbr, int routeLegNbr, java.util.Date routeDt)
        throws SQLException
    {
        Date convertedRtDt = new Date(routeDt.getTime());
        try
        {
            fetchFlightInfoStmt = conn.prepareStatement("SELECT T.TRAVEL_PLAN_NBR, T.SCHEDULED_DEPARTURE_DT, T.ORIGIN_LOCATION_CD, T.DEST_LOCATION_CD, T.ORIGIN_COUNTRY_CD, T.DEST_COUNTRY_CD, T.SCHEDULED_ARRIVAL_DT, T.TAIL_NBR  FROM ENT.TRIP T, ENT.ROUTE_LEG_TRIP RLT WHERE  RLT.ROUTE_NBR = ?  AND RLT.ROUTE_LEG_NBR = ?  AND RLT.ROUTE_LEG_SCHED_DPRT_DT = ?  AND RLT.TRAVEL_PLAN_NBR = T.TRAVEL_PLAN_NBR  AND RLT.TRIP_SCHED_DPRT_DT = T.SCHEDULED_DEPARTURE_DT  AND RLT.ORIGIN_LOCATION_CD = T.ORIGIN_LOCATION_CD  AND RLT.DEST_LOCATION_CD = T.DEST_LOCATION_CD ");
            fetchFlightInfoStmt.setString(1, routeNbr);
            fetchFlightInfoStmt.setInt(2, routeLegNbr);
            fetchFlightInfoStmt.setDate(3, convertedRtDt);
            runQuery(fetchFlightInfoStmt);
        }
        catch(SQLException ex)
        {
            String paramList = routeNbr + ", " + routeLegNbr + ", " + convertedRtDt;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT T.TRAVEL_PLAN_NBR, T.SCHEDULED_DEPARTURE_DT, T.ORIGIN_LOCATION_CD, T.DEST_LOCATION_CD, T.ORIGIN_COUNTRY_CD, T.DEST_COUNTRY_CD, T.SCHEDULED_ARRIVAL_DT, T.TAIL_NBR  FROM ENT.TRIP T, ENT.ROUTE_LEG_TRIP RLT WHERE  RLT.ROUTE_NBR = ?  AND RLT.ROUTE_LEG_NBR = ?  AND RLT.ROUTE_LEG_SCHED_DPRT_DT = ?  AND RLT.TRAVEL_PLAN_NBR = T.TRAVEL_PLAN_NBR  AND RLT.TRIP_SCHED_DPRT_DT = T.SCHEDULED_DEPARTURE_DT  AND RLT.ORIGIN_LOCATION_CD = T.ORIGIN_LOCATION_CD  AND RLT.DEST_LOCATION_CD = T.DEST_LOCATION_CD ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public FlightInfo fetchNext()
        throws SQLException
    {
        FlightInfo flightInfo = new FlightInfo();
        if(m_hasMore)
        {
            flightInfo.setTravelPlanNbr(m_resultSet.getString("TRAVEL_PLAN_NBR"));
            flightInfo.setScheduledDepartureDt(m_resultSet.getDate("SCHEDULED_DEPARTURE_DT"));
            flightInfo.setOriginLocationCd(m_resultSet.getString("ORIGIN_LOCATION_CD"));
            flightInfo.setDestLocationCd(m_resultSet.getString("DEST_LOCATION_CD"));
            flightInfo.setOriginCountryCd(m_resultSet.getString("ORIGIN_COUNTRY_CD"));
            flightInfo.setDestCountryCd(m_resultSet.getString("DEST_COUNTRY_CD"));
            flightInfo.setScheduledArrivalDt(m_resultSet.getDate("SCHEDULED_ARRIVAL_DT"));
            flightInfo.setTailNbr(m_resultSet.getString("TAIL_NBR"));
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
            flightInfo = null;
            m_recordCount = 0;
        }
        return flightInfo;
    }

    public static boolean dbTest(DatabaseBean db)
        throws Exception
    {
        DateFormat df = DateFormat.getDateInstance();
        java.util.Date routeDate = df.parse("August 17, 2004");
        FlightInfo flightInfo = new FlightInfo();
        try
        {
            System.out.println("date is " + routeDate);
            System.out.println("In the test case");
            flightInfo = db.fetchFlightInfo("LD001", 5, routeDate);
            System.out.println("Test Case 1 Results of fetch() " + flightInfo);
            flightInfo = db.fetchNext();
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful fetch of FlightInfo() " + ex);
            return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            dbTest(db);
            db.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("DbFlightInfo.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbFlightInfo.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private static final String fetchColumnList = "T.TRAVEL_PLAN_NBR, T.SCHEDULED_DEPARTURE_DT, T.ORIGIN_LOCATION_CD, T.DEST_LOCATION_CD, T.ORIGIN_COUNTRY_CD, T.DEST_COUNTRY_CD, T.SCHEDULED_ARRIVAL_DT, T.TAIL_NBR ";
    private static final String fetchTableList = "ENT.TRIP T, ENT.ROUTE_LEG_TRIP RLT";
    private static final String fetchBaseSQL = "SELECT T.TRAVEL_PLAN_NBR, T.SCHEDULED_DEPARTURE_DT, T.ORIGIN_LOCATION_CD, T.DEST_LOCATION_CD, T.ORIGIN_COUNTRY_CD, T.DEST_COUNTRY_CD, T.SCHEDULED_ARRIVAL_DT, T.TAIL_NBR  FROM ENT.TRIP T, ENT.ROUTE_LEG_TRIP RLT WHERE ";
    private static final String FetchFlightInfoBaseSQL = "SELECT T.TRAVEL_PLAN_NBR, T.SCHEDULED_DEPARTURE_DT, T.ORIGIN_LOCATION_CD, T.DEST_LOCATION_CD, T.ORIGIN_COUNTRY_CD, T.DEST_COUNTRY_CD, T.SCHEDULED_ARRIVAL_DT, T.TAIL_NBR  FROM ENT.TRIP T, ENT.ROUTE_LEG_TRIP RLT WHERE  RLT.ROUTE_NBR = ?  AND RLT.ROUTE_LEG_NBR = ?  AND RLT.ROUTE_LEG_SCHED_DPRT_DT = ?  AND RLT.TRAVEL_PLAN_NBR = T.TRAVEL_PLAN_NBR  AND RLT.TRIP_SCHED_DPRT_DT = T.SCHEDULED_DEPARTURE_DT  AND RLT.ORIGIN_LOCATION_CD = T.ORIGIN_LOCATION_CD  AND RLT.DEST_LOCATION_CD = T.DEST_LOCATION_CD ";
    private PreparedStatement fetchFlightInfoStmt;
}
