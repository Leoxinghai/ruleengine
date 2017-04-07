// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRouteLeg.java

package cciij.cciidatabase;

import cciij.cciidata.RouteLeg;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

// Referenced classes of package cciij.cciidatabase:
//            DbBase

public class DbRouteLeg extends DbBase
{

    public DbRouteLeg()
    {
        fetchWithRouteNumberRouteDateRouteLegNumberSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, MAWB_NBR, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR FROM ROUTE_LEG WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ?";
        fetchRouteLegByDistinctRteNbrSQL = "SELECT DISTINCT ROUTE_NBR FROM ROUTE_LEG WHERE DEST_LOCATION_CD = ? ORDER BY ROUTE_NBR ASC";
        fetchRouteLegByDestLocCdSQL = "SELECT DISTINCT SORT_DT FROM ROUTE_LEG WHERE DEST_LOCATION_CD = ? ORDER BY SORT_DT DESC";
        fetchRouteLegBySortDtAndDescLocCdSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, MAWB_NBR, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR FROM ROUTE_LEG WHERE SORT_DT = ?  AND DEST_LOCATION_CD = ? ORDER BY ROUTE_NBR";
        fetchRouteLegByRtDt_RtNbr_DestLocCdSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, MAWB_NBR, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR FROM ROUTE_LEG WHERE ROUTE_DT = ? AND ROUTE_NBR = ? AND DEST_LOCATION_CD = ?";
        fetchRouteLegSQL = "SELECT ROUTE_LEG.ROUTE_NBR, ROUTE_LEG.ROUTE_DT, ROUTE_LEG.ROUTE_LEG_NBR, MAWB_NBR, ROUTE_LEG.DEST_LOCATION_CD, ROUTE_LEG.ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR  FROM ROUTE_LEG, PIECE_ROUTE_LEG WHERE PIECE_ROUTE_LEG.PIECE_OID_NBR = ? AND ROUTE_LEG.ROUTE_DT = PIECE_ROUTE_LEG.ROUTE_DT AND ROUTE_LEG.ROUTE_NBR = PIECE_ROUTE_LEG.ROUTE_NBR AND ROUTE_LEG.ROUTE_LEG_NBR = PIECE_ROUTE_LEG.ROUTE_LEG_NBR AND ROUTE_LEG.DEST_LOCATION_CD = ?";
        fetchRouteLegByShipmentOIDSQL = "SELECT ROUTE_LEG.ROUTE_NBR, ROUTE_LEG.ROUTE_DT, ROUTE_LEG.ROUTE_LEG_NBR, MAWB_NBR, ROUTE_LEG.DEST_LOCATION_CD, ROUTE_LEG.ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ROUTE_LEG.ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR  FROM PIECE, ROUTE_LEG, PIECE_ROUTE_LEG WHERE PIECE.SHIPMENT_OID_NBR = PIECE_ROUTE_LEG.SHIPMENT_OID_NBR AND PIECE.PIECE_TYPE_CD = 'A' AND PIECE_ROUTE_LEG.SHIPMENT_OID_NBR = ? AND ROUTE_LEG.ROUTE_DT = PIECE_ROUTE_LEG.ROUTE_DT AND ROUTE_LEG.ROUTE_NBR = PIECE_ROUTE_LEG.ROUTE_NBR AND ROUTE_LEG.ROUTE_LEG_NBR = PIECE_ROUTE_LEG.ROUTE_LEG_NBR AND ROUTE_LEG.DEST_LOCATION_CD = ?";
        fetchRouteLegWithRtLegOidSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, MAWB_NBR, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR FROM ROUTE_LEG WHERE ROUTE_LEG_OID_NBR = ?";
        saveRouteLegSQL = "INSERT INTO ROUTE_LEG (ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, MAWB_NBR, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, DEPART_GMT_TMSTP, ARRIVAL_GMT_TMSTP, DEPART_LOCAL_TMSTP, ARRIVAL_LOCAL_TMSTP, DEST_COUNTRY_CD, ORIGIN_COUNTRY_CD, SORT_DT, ROUTE_LEG_STATUS_CD, BROKER_COMPLETE_FLG, CUSTOMS_COMPLETE_FLG, ROUTE_LEG_OID_NBR) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeRouteLegSQL = "DELETE FROM ROUTE_LEG WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ?";
        updateRouteLegSQL = "UPDATE ROUTE_LEG SET ROUTE_NBR = ?, ROUTE_DT = ?, ROUTE_LEG_NBR = ?, MAWB_NBR = ?, DEST_LOCATION_CD = ?, ORIGIN_LOCATION_CD = ?, DEPART_GMT_TMSTP = ?, ARRIVAL_GMT_TMSTP = ?, DEPART_LOCAL_TMSTP = ?, ARRIVAL_LOCAL_TMSTP = ?, DEST_COUNTRY_CD = ?, ORIGIN_COUNTRY_CD = ?, SORT_DT = ?, ROUTE_LEG_STATUS_CD = ?, BROKER_COMPLETE_FLG = ?, CUSTOMS_COMPLETE_FLG = ?, ROUTE_LEG_OID_NBR = ? WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ?";
        fetchWithRouteNumberRouteDateRouteLegNumberStmt = null;
        fetchRouteLegByDestLocCdStmt = null;
        fetchRouteLegByDistinctRteNbrStmt = null;
        fetchRouteLegBySortDtAndDescLocCdStmt = null;
        fetchRouteLegStmt = null;
        fetchRouteLegWithRtLegOidStmt = null;
        saveRouteLegStmt = null;
        removeRouteLegStmt = null;
        updateRouteLegStmt = null;
    }

    public int getRouteLegRecordCount()
    {
        return m_recordCount;
    }

    public RouteLeg fetch(Connection conn, String routeNumber, java.util.Date routeDate, int routeLegNumber)
        throws SQLException
    {
        Date convertedRtDt = new Date(routeDate.getTime());
        try
        {
            fetchWithRouteNumberRouteDateRouteLegNumberStmt = conn.prepareStatement(fetchWithRouteNumberRouteDateRouteLegNumberSQL);
            fetchWithRouteNumberRouteDateRouteLegNumberStmt.setString(1, routeNumber);
            fetchWithRouteNumberRouteDateRouteLegNumberStmt.setDate(2, convertedRtDt);
            fetchWithRouteNumberRouteDateRouteLegNumberStmt.setInt(3, routeLegNumber);
            runQuery(fetchWithRouteNumberRouteDateRouteLegNumberStmt);
        }
        catch(SQLException ex)
        {
            String paramList = routeNumber + ", " + convertedRtDt + ", " + routeLegNumber;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithRouteNumberRouteDateRouteLegNumberSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public java.util.Date fetchByDestLocCd(Connection conn, String destLocCd)
        throws SQLException
    {
        try
        {
            fetchRouteLegByDestLocCdStmt = conn.prepareStatement(fetchRouteLegByDestLocCdSQL);
            fetchRouteLegByDestLocCdStmt.setString(1, destLocCd);
            runQuery(fetchRouteLegByDestLocCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = destLocCd;
            printSQLException(ex, getClass().getName(), "fetchByDestLocCd", fetchRouteLegByDestLocCdSQL, paramList);
            throw ex;
        }
        return fetchNextSortDt();
    }

    public RouteLeg fetch(Connection conn, java.util.Date sortDt, String destLocCd)
        throws SQLException
    {
        Date convertedSortDt = new Date(sortDt.getTime());
        try
        {
            fetchRouteLegBySortDtAndDescLocCdStmt = conn.prepareStatement(fetchRouteLegBySortDtAndDescLocCdSQL);
            fetchRouteLegBySortDtAndDescLocCdStmt.setDate(1, convertedSortDt);
            fetchRouteLegBySortDtAndDescLocCdStmt.setString(2, destLocCd);
            runQuery(fetchRouteLegBySortDtAndDescLocCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = convertedSortDt + ", " + destLocCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchRouteLegBySortDtAndDescLocCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public String fetchByDistinctRouteNumber(Connection conn, String destLocCd)
        throws SQLException
    {
        try
        {
            fetchRouteLegByDistinctRteNbrStmt = conn.prepareStatement(fetchRouteLegByDistinctRteNbrSQL);
            fetchRouteLegByDistinctRteNbrStmt.setString(1, destLocCd);
            runQuery(fetchRouteLegByDistinctRteNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByDistinctRouteNumber", fetchRouteLegByDistinctRteNbrSQL, " ");
            throw ex;
        }
        return fetchNextRouteNumber();
    }

    public RouteLeg fetch(Connection conn, int pcOid, String destLocCd)
        throws SQLException
    {
        try
        {
            fetchRouteLegStmt = conn.prepareStatement(fetchRouteLegSQL);
            fetchRouteLegStmt.setInt(1, pcOid);
            fetchRouteLegStmt.setString(2, destLocCd);
            runQuery(fetchRouteLegStmt);
        }
        catch(SQLException ex)
        {
            String paramList = pcOid + ", " + destLocCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchRouteLegSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public RouteLeg fetch(Connection conn, String destLocCd, int shipmentOID)
        throws SQLException
    {
        try
        {
            fetchRouteLegStmt = conn.prepareStatement(fetchRouteLegByShipmentOIDSQL);
            fetchRouteLegStmt.setInt(1, shipmentOID);
            fetchRouteLegStmt.setString(2, destLocCd);
            runQuery(fetchRouteLegStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipmentOID + ", " + destLocCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchRouteLegSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public RouteLeg fetch(Connection conn, int rtLegOidNbr)
        throws SQLException
    {
        try
        {
            fetchRouteLegWithRtLegOidStmt = conn.prepareStatement(fetchRouteLegWithRtLegOidSQL);
            fetchRouteLegWithRtLegOidStmt.setInt(1, rtLegOidNbr);
            runQuery(fetchRouteLegWithRtLegOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(rtLegOidNbr);
            printSQLException(ex, getClass().getName(), "fetch", fetchRouteLegWithRtLegOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public RouteLeg fetchNext()
        throws SQLException
    {
        RouteLeg routeLeg = new RouteLeg();
        try
        {
            if(m_hasMore)
            {
                String routeNbr = m_resultSet.getString(1);
                Timestamp routeDtTmstp = m_resultSet.getTimestamp(2);
                int routeLegNbr = m_resultSet.getInt(3);
                String MAWBNbr = m_resultSet.getString(4);
                String destLocCd = m_resultSet.getString(5);
                String originLocCd = m_resultSet.getString(6);
                Timestamp departGMTTmstp = m_resultSet.getTimestamp(7);
                Timestamp arrivalGMTTmstp = m_resultSet.getTimestamp(8);
                Timestamp departLocalTmstp = m_resultSet.getTimestamp(9);
                Timestamp arrivalLocalTmstp = m_resultSet.getTimestamp(10);
                String destCountryCd = m_resultSet.getString(11);
                String originCountryCd = m_resultSet.getString(12);
                Timestamp sortDtTmstp = m_resultSet.getTimestamp(13);
                String rtLegStatusCd = m_resultSet.getString(14);
                String brkrCompleteFlg = m_resultSet.getString(15);
                String customsCompleteFlg = m_resultSet.getString(16);
                int rtLegOidNbr = m_resultSet.getInt(17);
                java.util.Date routeDt = convertTimestampToDate(routeDtTmstp);
                java.util.Date departGMTDt = convertTimestampToDate(departGMTTmstp);
                java.util.Date arrivalGMTDt = convertTimestampToDate(arrivalGMTTmstp);
                java.util.Date departLocalDt = convertTimestampToDate(departLocalTmstp);
                java.util.Date arrivalLocalDt = convertTimestampToDate(arrivalLocalTmstp);
                java.util.Date sortDt = convertTimestampToDate(sortDtTmstp);
                routeLeg = new RouteLeg(routeNbr, routeDt, routeLegNbr, MAWBNbr, destLocCd, originLocCd, departGMTDt, arrivalGMTDt, departLocalDt, arrivalLocalDt, destCountryCd, originCountryCd, sortDt, rtLegStatusCd, brkrCompleteFlg, customsCompleteFlg, rtLegOidNbr);
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
                routeLeg = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return routeLeg;
    }

    public java.util.Date fetchNextSortDt()
        throws SQLException
    {
        java.util.Date sortDt = new java.util.Date(0L);
        try
        {
            if(m_hasMore)
            {
                Timestamp sortDtTimestamp = m_resultSet.getTimestamp(1);
                sortDt = convertTimestampToDate(sortDtTimestamp);
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
                sortDt = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNextSortDt()", " ", " ");
            throw ex;
        }
        return sortDt;
    }

    public String fetchNextRouteNumber()
        throws SQLException
    {
        String routeNbr = new String();
        try
        {
            if(m_hasMore)
            {
                routeNbr = m_resultSet.getString(1);
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
                routeNbr = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNextRouteNumber()", " ", " ");
            throw ex;
        }
        return routeNbr;
    }

    public void save(Connection conn, RouteLeg routeLeg)
        throws SQLException
    {
        Timestamp routeDtTimestamp = new Timestamp(routeLeg.getRouteDate().getTime());
        Timestamp departureGMTTimestamp = new Timestamp(routeLeg.getDepartureGMTTimestamp().getTime());
        Timestamp arrivalGMTTimestamp = new Timestamp(routeLeg.getArrivalGMTTimestamp().getTime());
        Timestamp departureLocalTimestamp = new Timestamp(routeLeg.getDepartureLocalTimestamp().getTime());
        Timestamp arrivalLocalTimestamp = new Timestamp(routeLeg.getArrivalLocalTimestamp().getTime());
        Timestamp sortDtTimestamp = new Timestamp(routeLeg.getSortDate().getTime());
        try
        {
            saveRouteLegStmt = conn.prepareStatement(saveRouteLegSQL);
            saveRouteLegStmt.setString(1, routeLeg.getRouteNumber());
            saveRouteLegStmt.setTimestamp(2, routeDtTimestamp);
            saveRouteLegStmt.setInt(3, routeLeg.getRouteLegNumber());
            saveRouteLegStmt.setString(4, routeLeg.getMAWBNumber());
            saveRouteLegStmt.setString(5, routeLeg.getDestinationLocCode());
            saveRouteLegStmt.setString(6, routeLeg.getOriginLocCode());
            saveRouteLegStmt.setTimestamp(7, departureGMTTimestamp);
            saveRouteLegStmt.setTimestamp(8, arrivalGMTTimestamp);
            saveRouteLegStmt.setTimestamp(9, departureLocalTimestamp);
            saveRouteLegStmt.setTimestamp(10, arrivalLocalTimestamp);
            saveRouteLegStmt.setString(11, routeLeg.getDestinationCountryCode());
            saveRouteLegStmt.setString(12, routeLeg.getOriginCountryCode());
            saveRouteLegStmt.setTimestamp(13, sortDtTimestamp);
            saveRouteLegStmt.setString(14, routeLeg.getRouteLegStatusCd());
            saveRouteLegStmt.setString(15, routeLeg.getBrokerCompleteFlag());
            saveRouteLegStmt.setString(16, routeLeg.getCustomsCompleteFlag());
            saveRouteLegStmt.setInt(17, routeLeg.getRouteLegOidNumber());
            saveRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = routeLeg.getRouteNumber() + ", " + routeDtTimestamp + ", " + routeLeg.getRouteLegNumber() + ", " + routeLeg.getMAWBNumber() + ", " + routeLeg.getDestinationLocCode() + ", " + routeLeg.getOriginLocCode() + ", " + departureGMTTimestamp + ", " + arrivalGMTTimestamp + ", " + departureLocalTimestamp + ", " + arrivalLocalTimestamp + ", " + routeLeg.getDestinationCountryCode() + ", " + routeLeg.getOriginCountryCode() + ", " + sortDtTimestamp + ", " + routeLeg.getRouteLegStatusCd() + ", " + routeLeg.getBrokerCompleteFlag() + ", " + routeLeg.getCustomsCompleteFlag() + ", " + routeLeg.getRouteLegOidNumber();
            printSQLException(ex, getClass().getName(), "save", saveRouteLegSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, RouteLeg routeLeg)
        throws SQLException
    {
        Date tmpRouteDt = new Date(routeLeg.getRouteDate().getTime());
        try
        {
            removeRouteLegStmt = conn.prepareStatement(removeRouteLegSQL);
            removeRouteLegStmt.setString(1, routeLeg.getRouteNumber());
            removeRouteLegStmt.setDate(2, tmpRouteDt);
            removeRouteLegStmt.setInt(3, routeLeg.getRouteLegNumber());
            removeRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = routeLeg.getRouteNumber() + ", " + tmpRouteDt + ", " + routeLeg.getRouteLegNumber();
            printSQLException(ex, getClass().getName(), "remove", removeRouteLegSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, RouteLeg routeLeg)
        throws SQLException
    {
        Timestamp routeDtTimestamp = new Timestamp(routeLeg.getRouteDate().getTime());
        Timestamp departureGMTTimestamp = new Timestamp(routeLeg.getDepartureGMTTimestamp().getTime());
        Timestamp arrivalGMTTimestamp = new Timestamp(routeLeg.getArrivalGMTTimestamp().getTime());
        Timestamp departureLocalTimestamp = new Timestamp(routeLeg.getDepartureLocalTimestamp().getTime());
        Timestamp arrivalLocalTimestamp = new Timestamp(routeLeg.getArrivalLocalTimestamp().getTime());
        Timestamp sortDtTimestamp = new Timestamp(routeLeg.getSortDate().getTime());
        try
        {
            updateRouteLegStmt = conn.prepareStatement(updateRouteLegSQL);
            updateRouteLegStmt.setString(1, routeLeg.getRouteNumber());
            updateRouteLegStmt.setTimestamp(2, routeDtTimestamp);
            updateRouteLegStmt.setInt(3, routeLeg.getRouteLegNumber());
            updateRouteLegStmt.setString(4, routeLeg.getMAWBNumber());
            updateRouteLegStmt.setString(5, routeLeg.getDestinationLocCode());
            updateRouteLegStmt.setString(6, routeLeg.getOriginLocCode());
            updateRouteLegStmt.setTimestamp(7, departureGMTTimestamp);
            updateRouteLegStmt.setTimestamp(8, arrivalGMTTimestamp);
            updateRouteLegStmt.setTimestamp(9, departureLocalTimestamp);
            updateRouteLegStmt.setTimestamp(10, arrivalLocalTimestamp);
            updateRouteLegStmt.setString(11, routeLeg.getDestinationCountryCode());
            updateRouteLegStmt.setString(12, routeLeg.getOriginCountryCode());
            updateRouteLegStmt.setTimestamp(13, sortDtTimestamp);
            updateRouteLegStmt.setString(14, routeLeg.getRouteLegStatusCd());
            updateRouteLegStmt.setString(15, routeLeg.getBrokerCompleteFlag());
            updateRouteLegStmt.setString(16, routeLeg.getCustomsCompleteFlag());
            updateRouteLegStmt.setInt(17, routeLeg.getRouteLegOidNumber());
            updateRouteLegStmt.setString(18, routeLeg.getRouteNumber());
            updateRouteLegStmt.setTimestamp(19, routeDtTimestamp);
            updateRouteLegStmt.setInt(20, routeLeg.getRouteLegNumber());
            updateRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = routeLeg.getRouteNumber() + ", " + routeDtTimestamp + ", " + routeLeg.getRouteLegNumber() + ", " + routeLeg.getMAWBNumber() + ", " + routeLeg.getDestinationLocCode() + ", " + routeLeg.getOriginLocCode() + ", " + departureGMTTimestamp + ", " + arrivalGMTTimestamp + ", " + departureLocalTimestamp + ", " + arrivalLocalTimestamp + ", " + routeLeg.getDestinationCountryCode() + ", " + routeLeg.getOriginCountryCode() + ", " + sortDtTimestamp + ", " + routeLeg.getRouteLegStatusCd() + ", " + routeLeg.getBrokerCompleteFlag() + ", " + routeLeg.getCustomsCompleteFlag() + ", " + routeLeg.getRouteLegOidNumber() + ", " + routeLeg.getRouteNumber() + ", " + routeDtTimestamp + ", " + routeLeg.getRouteLegNumber();
            printSQLException(ex, getClass().getName(), "update", updateRouteLegSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbRouteLeg.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String fetchWithRouteNumberRouteDateRouteLegNumberSQL;
    private String fetchRouteLegByDistinctRteNbrSQL;
    private String fetchRouteLegByDestLocCdSQL;
    private String fetchRouteLegBySortDtAndDescLocCdSQL;
    private String fetchRouteLegByRtDt_RtNbr_DestLocCdSQL;
    private String fetchRouteLegSQL;
    private String fetchRouteLegByShipmentOIDSQL;
    private String fetchRouteLegWithRtLegOidSQL;
    private String saveRouteLegSQL;
    private String removeRouteLegSQL;
    private String updateRouteLegSQL;
    private PreparedStatement fetchWithRouteNumberRouteDateRouteLegNumberStmt;
    private PreparedStatement fetchRouteLegByDestLocCdStmt;
    private PreparedStatement fetchRouteLegByDistinctRteNbrStmt;
    private PreparedStatement fetchRouteLegBySortDtAndDescLocCdStmt;
    private PreparedStatement fetchRouteLegStmt;
    private PreparedStatement fetchRouteLegWithRtLegOidStmt;
    private PreparedStatement saveRouteLegStmt;
    private PreparedStatement removeRouteLegStmt;
    private PreparedStatement updateRouteLegStmt;
}
