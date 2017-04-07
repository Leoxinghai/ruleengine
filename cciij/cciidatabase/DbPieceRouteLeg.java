// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbPieceRouteLeg.java

package cciij.cciidatabase;

import cciij.cciidata.PieceRouteLeg;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Referenced classes of package cciij.cciidatabase:
//            DbBase

public class DbPieceRouteLeg extends DbBase
{

    public DbPieceRouteLeg()
    {
        fetchWithPieceOIDSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, ORIGIN_LOCATION_CD, SEQUENCE_NBR, SCAN_RECON_FLG FROM PIECE_ROUTE_LEG WHERE PIECE_OID_NBR = ?";
        fetchPieceWithRouteInfoSQL = "SELECT ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, ORIGIN_LOCATION_CD, SEQUENCE_NBR, SCAN_RECON_FLG FROM PIECE_ROUTE_LEG WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ?";
        savePieceRouteLegSQL = "INSERT INTO PIECE_ROUTE_LEG (ROUTE_NBR, ROUTE_DT, ROUTE_LEG_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, ORIGIN_LOCATION_CD, SEQUENCE_NBR, SCAN_RECON_FLG) VALUES(?,?,?,?,?,?,?,?)";
        removePieceRouteLegSQL = "DELETE FROM PIECE_ROUTE_LEG WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ? AND PIECE_OID_NBR = ?";
        updatePieceRouteLegSQL = "UPDATE PIECE_ROUTE_LEG SET ROUTE_NBR = ?, ROUTE_DT = ?, ROUTE_LEG_NBR = ?, SHIPMENT_OID_NBR = ?, PIECE_OID_NBR = ?, ORIGIN_LOCATION_CD = ?, SEQUENCE_NBR = ?, SCAN_RECON_FLG = ? WHERE ROUTE_NBR = ? AND ROUTE_DT = ? AND ROUTE_LEG_NBR = ? AND PIECE_OID_NBR = ?";
        fetchWithPieceOIDStmt = null;
        fetchPieceWithRouteInfoStmt = null;
        savePieceRouteLegStmt = null;
        removePieceRouteLegStmt = null;
        updatePieceRouteLegStmt = null;
    }

    public int getPieceRouteLegRecordCount()
    {
        return m_recordCount;
    }

    public PieceRouteLeg fetch(Connection conn, String routeNumber, java.util.Date routeDate, int routeLegNumber)
        throws SQLException
    {
        Date convertedRouteDt = new Date(routeDate.getTime());
        try
        {
            fetchPieceWithRouteInfoStmt = conn.prepareStatement(fetchPieceWithRouteInfoSQL);
            fetchPieceWithRouteInfoStmt.setString(1, routeNumber);
            fetchPieceWithRouteInfoStmt.setDate(2, convertedRouteDt);
            fetchPieceWithRouteInfoStmt.setInt(3, routeLegNumber);
            runQuery(fetchPieceWithRouteInfoStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbPieceRouteLeg fetch: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public PieceRouteLeg fetch(Connection conn, int pcOidNbr)
        throws SQLException
    {
        try
        {
            fetchWithPieceOIDStmt = conn.prepareStatement(fetchWithPieceOIDSQL);
            fetchWithPieceOIDStmt.setInt(1, pcOidNbr);
            runQuery(fetchWithPieceOIDStmt);
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(pcOidNbr);
            printSQLException(ex, getClass().getName(), "fetch", fetchWithPieceOIDSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public PieceRouteLeg fetchNext()
        throws SQLException
    {
        PieceRouteLeg pcRtLeg = new PieceRouteLeg();
        try
        {
            if(m_hasMore)
            {
                String routeNbr = m_resultSet.getString(1);
                java.sql.Timestamp routeDtTmstp = m_resultSet.getTimestamp(2);
                int routeLegNbr = m_resultSet.getInt(3);
                int shipOidNbr = m_resultSet.getInt(4);
                int pcOidNbr = m_resultSet.getInt(5);
                String orgLocCd = m_resultSet.getString(6);
                int seqNbr = m_resultSet.getInt(7);
                String scanReconFlg = m_resultSet.getString(8);
                java.util.Date routeDt = convertTimestampToDate(routeDtTmstp);
                pcRtLeg = new PieceRouteLeg(routeNbr, routeDt, routeLegNbr, shipOidNbr, pcOidNbr, orgLocCd, seqNbr, scanReconFlg);
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
                pcRtLeg = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return pcRtLeg;
    }

    public void save(Connection conn, PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        Date tmpRouteDt = new Date(pcRouteLeg.getRouteDate().getTime());
        try
        {
            savePieceRouteLegStmt = conn.prepareStatement(savePieceRouteLegSQL);
            savePieceRouteLegStmt.setString(1, pcRouteLeg.getRouteNumber());
            savePieceRouteLegStmt.setDate(2, tmpRouteDt);
            savePieceRouteLegStmt.setInt(3, pcRouteLeg.getRouteLegNumber());
            savePieceRouteLegStmt.setInt(4, pcRouteLeg.getShipmentOidNumber());
            savePieceRouteLegStmt.setInt(5, pcRouteLeg.getHandlingUnitOidNumber());
            savePieceRouteLegStmt.setString(6, pcRouteLeg.getOriginLocationCode());
            savePieceRouteLegStmt.setInt(7, pcRouteLeg.getSequenceNumber());
            savePieceRouteLegStmt.setString(8, pcRouteLeg.getScanReconFlag());
            savePieceRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pcRouteLeg.getRouteNumber() + ", " + tmpRouteDt + ", " + pcRouteLeg.getRouteLegNumber() + ", " + pcRouteLeg.getShipmentOidNumber() + ", " + pcRouteLeg.getHandlingUnitOidNumber() + ", " + pcRouteLeg.getOriginLocationCode() + ", " + pcRouteLeg.getSequenceNumber() + ", " + pcRouteLeg.getScanReconFlag();
            printSQLException(ex, getClass().getName(), "save", savePieceRouteLegSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        Date tmpRouteDt = new Date(pcRouteLeg.getRouteDate().getTime());
        try
        {
            removePieceRouteLegStmt = conn.prepareStatement(removePieceRouteLegSQL);
            removePieceRouteLegStmt.setString(1, pcRouteLeg.getRouteNumber());
            removePieceRouteLegStmt.setDate(2, tmpRouteDt);
            removePieceRouteLegStmt.setInt(3, pcRouteLeg.getRouteLegNumber());
            removePieceRouteLegStmt.setInt(4, pcRouteLeg.getHandlingUnitOidNumber());
            removePieceRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pcRouteLeg.getRouteNumber() + ", " + tmpRouteDt + ", " + pcRouteLeg.getRouteLegNumber() + ", " + pcRouteLeg.getHandlingUnitOidNumber();
            printSQLException(ex, getClass().getName(), "remove", removePieceRouteLegSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        Date tmpRouteDt = new Date(pcRouteLeg.getRouteDate().getTime());
        try
        {
            updatePieceRouteLegStmt = conn.prepareStatement(updatePieceRouteLegSQL);
            updatePieceRouteLegStmt.setString(1, pcRouteLeg.getRouteNumber());
            updatePieceRouteLegStmt.setDate(2, tmpRouteDt);
            updatePieceRouteLegStmt.setInt(3, pcRouteLeg.getRouteLegNumber());
            updatePieceRouteLegStmt.setInt(4, pcRouteLeg.getShipmentOidNumber());
            updatePieceRouteLegStmt.setInt(5, pcRouteLeg.getHandlingUnitOidNumber());
            updatePieceRouteLegStmt.setString(6, pcRouteLeg.getOriginLocationCode());
            updatePieceRouteLegStmt.setInt(7, pcRouteLeg.getSequenceNumber());
            updatePieceRouteLegStmt.setString(8, pcRouteLeg.getScanReconFlag());
            updatePieceRouteLegStmt.setString(9, pcRouteLeg.getRouteNumber());
            updatePieceRouteLegStmt.setDate(10, tmpRouteDt);
            updatePieceRouteLegStmt.setInt(11, pcRouteLeg.getRouteLegNumber());
            updatePieceRouteLegStmt.setInt(12, pcRouteLeg.getHandlingUnitOidNumber());
            updatePieceRouteLegStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pcRouteLeg.getRouteNumber() + ", " + tmpRouteDt + ", " + pcRouteLeg.getRouteLegNumber() + ", " + pcRouteLeg.getShipmentOidNumber() + ", " + pcRouteLeg.getHandlingUnitOidNumber() + ", " + pcRouteLeg.getOriginLocationCode() + ", " + pcRouteLeg.getSequenceNumber() + ", " + pcRouteLeg.getScanReconFlag() + ", " + pcRouteLeg.getRouteNumber() + ", " + tmpRouteDt + ", " + pcRouteLeg.getRouteLegNumber() + ", " + pcRouteLeg.getHandlingUnitOidNumber();
            printSQLException(ex, getClass().getName(), "update", updatePieceRouteLegSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbPieceRouteLeg.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String fetchWithPieceOIDSQL;
    private String fetchPieceWithRouteInfoSQL;
    private String savePieceRouteLegSQL;
    private String removePieceRouteLegSQL;
    private String updatePieceRouteLegSQL;
    private PreparedStatement fetchWithPieceOIDStmt;
    private PreparedStatement fetchPieceWithRouteInfoStmt;
    private PreparedStatement savePieceRouteLegStmt;
    private PreparedStatement removePieceRouteLegStmt;
    private PreparedStatement updatePieceRouteLegStmt;
}
