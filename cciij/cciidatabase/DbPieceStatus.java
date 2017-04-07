// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbPieceStatus.java

package cciij.cciidatabase;

import cciij.cciidata.PieceStatus;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbPieceStatus extends DbBase
{

    public DbPieceStatus()
    {
        savePieceStatusSQL = "INSERT INTO ENT.PIECE_STATUS (PIECE_OID_NBR, LOCATION_CD, SORT_DT, PIECE_STATUS_CD, SHIPMENT_OID_NBR, ROUTE_LEG_OID_NBR, RESOLUTION_STATUS_CD, RFA_CD) VALUES(?,?,?,?,?,?,?,?)";
        updatePieceStatusSQL = "UPDATE ENT.PIECE_STATUS PS SET PS.SHIPMENT_OID_NBR = ?, PS.ROUTE_LEG_OID_NBR = ?, PS.RESOLUTION_STATUS_CD = ?, PS.RFA_CD = ? WHERE PS.PIECE_OID_NBR = ?   AND PS.LOCATION_CD = ?   AND PS.SORT_DT = ?   AND PS.PIECE_STATUS_CD = ? ";
        updateResolutionAndRfaOnlySQL = "UPDATE ENT.PIECE_STATUS PS SET PS.RESOLUTION_STATUS_CD = ?, PS.RFA_CD = ? WHERE PS.PIECE_OID_NBR = ?   AND PS.LOCATION_CD = ?   AND PS.SORT_DT = ?   AND PS.PIECE_STATUS_CD = ? ";
        fetchPieceStatusStmt = null;
        savePieceStatusStmt = null;
        updatePieceStatusStmt = null;
        updateResolutionAndRfaOnlyStmt = null;
    }

    public int getPieceStatusRecordCount()
    {
        return m_recordCount;
    }

    public PieceStatus fetch(Connection conn, int pieceOidNbr, String locationCd, java.util.Date sortDt, String pieceStatusCd)
        throws SQLException
    {
        Date convertedSortDt = new Date(sortDt.getTime());
        try
        {
            fetchPieceStatusStmt = conn.prepareStatement("SELECT PS.PIECE_OID_NBR, PS.LOCATION_CD, PS.SORT_DT, PS.PIECE_STATUS_CD, PS.SHIPMENT_OID_NBR, PS.ROUTE_LEG_OID_NBR, PS.RESOLUTION_STATUS_CD, PS.RFA_CD  FROM ENT.PIECE_STATUS PS WHERE  PS.PIECE_OID_NBR = ?  AND PS.LOCATION_CD = ?  AND PS.SORT_DT = ?  AND PS.PIECE_STATUS_CD = ? ");
            fetchPieceStatusStmt.setInt(1, pieceOidNbr);
            fetchPieceStatusStmt.setString(2, locationCd);
            fetchPieceStatusStmt.setDate(3, convertedSortDt);
            fetchPieceStatusStmt.setString(4, pieceStatusCd);
            runQuery(fetchPieceStatusStmt);
        }
        catch(SQLException ex)
        {
            String paramList = pieceOidNbr + ", " + locationCd + ", " + convertedSortDt + "," + pieceStatusCd;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT PS.PIECE_OID_NBR, PS.LOCATION_CD, PS.SORT_DT, PS.PIECE_STATUS_CD, PS.SHIPMENT_OID_NBR, PS.ROUTE_LEG_OID_NBR, PS.RESOLUTION_STATUS_CD, PS.RFA_CD  FROM ENT.PIECE_STATUS PS WHERE  PS.PIECE_OID_NBR = ?  AND PS.LOCATION_CD = ?  AND PS.SORT_DT = ?  AND PS.PIECE_STATUS_CD = ? ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public PieceStatus fetchNext()
        throws SQLException
    {
        PieceStatus pieceStatus = new PieceStatus();
        if(m_hasMore)
        {
            pieceStatus.setPieceOidNbr(m_resultSet.getInt("PIECE_OID_NBR"));
            pieceStatus.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            pieceStatus.setSortDt(m_resultSet.getDate("SORT_DT"));
            pieceStatus.setPieceStatusCd(m_resultSet.getString("PIECE_STATUS_CD"));
            pieceStatus.setShipmentOidNbr(m_resultSet.getInt("SHIPMENT_OID_NBR"));
            pieceStatus.setRouteLegOidNbr(m_resultSet.getInt("ROUTE_LEG_OID_NBR"));
            pieceStatus.setResolutionStatusCd(m_resultSet.getString("RESOLUTION_STATUS_CD"));
            pieceStatus.setRfaCd(m_resultSet.getString("RFA_CD"));
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
            pieceStatus = null;
            m_recordCount = 0;
        }
        return pieceStatus;
    }

    public void save(Connection conn, PieceStatus pieceStatus, String locationCode)
        throws SQLException
    {
        Date tmpSortDt = new Date(pieceStatus.getSortDt().getTime());
        try
        {
            savePieceStatusStmt = conn.prepareStatement(savePieceStatusSQL);
            savePieceStatusStmt.setInt(1, pieceStatus.getPieceOidNbr());
            savePieceStatusStmt.setString(2, pieceStatus.getLocationCd());
            savePieceStatusStmt.setDate(3, tmpSortDt);
            savePieceStatusStmt.setString(4, pieceStatus.getPieceStatusCd());
            savePieceStatusStmt.setInt(5, pieceStatus.getShipmentOidNbr());
            savePieceStatusStmt.setInt(6, pieceStatus.getRouteLegOidNbr());
            savePieceStatusStmt.setString(7, pieceStatus.getResolutionStatusCd());
            savePieceStatusStmt.setString(8, pieceStatus.getRfaCd());
            savePieceStatusStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pieceStatus.getPieceOidNbr() + ", " + pieceStatus.getLocationCd() + ", " + pieceStatus.getSortDt() + ", " + pieceStatus.getPieceStatusCd() + ", " + pieceStatus.getShipmentOidNbr() + ", " + pieceStatus.getRouteLegOidNbr() + ", " + pieceStatus.getResolutionStatusCd() + ", " + pieceStatus.getRfaCd() + ", ";
            printSQLException(ex, getClass().getName(), "save", savePieceStatusSQL, paramList);
            throw ex;
        }
    }

    public void updatePieceStatus(PieceStatus ps, Connection conn)
        throws SQLException
    {
        try
        {
            updatePieceStatusStmt = conn.prepareStatement(updatePieceStatusSQL);
            updatePieceStatusStmt.setInt(1, ps.getShipmentOidNbr());
            updatePieceStatusStmt.setInt(2, ps.getRouteLegOidNbr());
            updatePieceStatusStmt.setString(3, ps.getResolutionStatusCd());
            updatePieceStatusStmt.setString(4, ps.getRfaCd());
            updatePieceStatusStmt.setInt(5, ps.getPieceOidNbr());
            updatePieceStatusStmt.setString(6, ps.getLocationCd());
            updatePieceStatusStmt.setDate(7, new Date(ps.getSortDt().getTime()));
            updatePieceStatusStmt.setString(8, ps.getPieceStatusCd());
            updateDatabase(updatePieceStatusStmt);
            if(updatePieceStatusStmt.getUpdateCount() == 0)
                throw new SQLException("updatePieceStatus failed to update any rows");
        }
        catch(SQLException ex)
        {
            String paramList = ps.getShipmentOidNbr() + ", " + ps.getRouteLegOidNbr() + ", " + ps.getResolutionStatusCd() + "," + ps.getRfaCd() + ", " + ps.getPieceOidNbr() + ", " + ps.getLocationCd() + ", " + ps.getSortDt() + ", " + ps.getPieceStatusCd();
            printSQLException(ex, getClass().getName(), "update", updatePieceStatusSQL, paramList);
            throw ex;
        }
    }

    public void updatePieceStatusResolutionAndRfaOnly(PieceStatus ps, Connection conn)
        throws SQLException
    {
        try
        {
            updatePieceStatusStmt = conn.prepareStatement(updateResolutionAndRfaOnlySQL);
            updatePieceStatusStmt.setString(1, ps.getResolutionStatusCd());
            updatePieceStatusStmt.setString(2, ps.getRfaCd());
            updatePieceStatusStmt.setInt(3, ps.getPieceOidNbr());
            updatePieceStatusStmt.setString(4, ps.getLocationCd());
            updatePieceStatusStmt.setDate(5, new Date(ps.getSortDt().getTime()));
            updatePieceStatusStmt.setString(6, ps.getPieceStatusCd());
            updateDatabase(updatePieceStatusStmt);
            if(updatePieceStatusStmt.getUpdateCount() == 0)
                throw new SQLException("updatePieceStatusResolutionAndRfaOnly failed to update any rows");
        }
        catch(SQLException ex)
        {
            String paramList = ps.getResolutionStatusCd() + "," + ps.getRfaCd() + ", " + ps.getPieceOidNbr() + ", " + ps.getLocationCd() + ", " + ps.getSortDt() + ", " + ps.getPieceStatusCd();
            printSQLException(ex, getClass().getName(), "update", updateResolutionAndRfaOnlySQL, paramList);
            throw ex;
        }
    }

    public static boolean dbTest(DatabaseBean db)
        throws Exception
    {
        DateFormat df = DateFormat.getDateInstance();
        java.util.Date sortDate = df.parse("September 8, 2004");
        java.util.Date createDate = new java.util.Date(0L);
        java.util.Date updateDate = new java.util.Date(0L);
        PieceStatus pieceStatus = new PieceStatus(0xb996aa, "OAK", sortDate, "O", 0x166a60d, 0x67c29, "C", "LO");
        try
        {
            db.savePieceStatus(pieceStatus);
            System.out.println("Test Case 1: Successfully saved PieceStatus");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of PieceStatus " + ex);
            System.out.println("piece status is " + pieceStatus);
            return false;
        }
        try
        {
            System.out.println("date is " + sortDate);
            System.out.println("In the test case");
            for(int currentRow = 1; db.getPieceStatusRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2 Results of fetch() " + pieceStatus);
                pieceStatus = db.fetchNextPieceStatus();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of PieceStatus() " + ex);
            return false;
        }
        try
        {
            pieceStatus.setResolutionStatusCd("X");
            pieceStatus.setRfaCd("YYY");
            System.out.println("PieceStatus after setting fields for update:: " + pieceStatus.toString());
            System.out.println("call the db.update");
            db.updatePieceStatusResolutionAndRfaOnly(pieceStatus);
            System.out.println("refetch your record and see if update worked");
            pieceStatus = null;
            pieceStatus = db.fetchPieceStatus(0xb996aa, "OAK", sortDate, "O");
            System.out.println("fetch returned:: " + pieceStatus.toString());
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of PieceStatus() " + ex);
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
            System.out.println("DbPieceStatus.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbPieceStatus.java,v $Revision: 1.1 $Author: xinghai $Date: \n";
    private static final String fetchColumnList = "PS.PIECE_OID_NBR, PS.LOCATION_CD, PS.SORT_DT, PS.PIECE_STATUS_CD, PS.SHIPMENT_OID_NBR, PS.ROUTE_LEG_OID_NBR, PS.RESOLUTION_STATUS_CD, PS.RFA_CD ";
    private static final String fetchTableList = "ENT.PIECE_STATUS PS";
    private static final String fetchBaseSQL = "SELECT PS.PIECE_OID_NBR, PS.LOCATION_CD, PS.SORT_DT, PS.PIECE_STATUS_CD, PS.SHIPMENT_OID_NBR, PS.ROUTE_LEG_OID_NBR, PS.RESOLUTION_STATUS_CD, PS.RFA_CD  FROM ENT.PIECE_STATUS PS WHERE ";
    private static final String fetchPieceStatusBaseSQL = "SELECT PS.PIECE_OID_NBR, PS.LOCATION_CD, PS.SORT_DT, PS.PIECE_STATUS_CD, PS.SHIPMENT_OID_NBR, PS.ROUTE_LEG_OID_NBR, PS.RESOLUTION_STATUS_CD, PS.RFA_CD  FROM ENT.PIECE_STATUS PS WHERE  PS.PIECE_OID_NBR = ?  AND PS.LOCATION_CD = ?  AND PS.SORT_DT = ?  AND PS.PIECE_STATUS_CD = ? ";
    private String savePieceStatusSQL;
    private String updatePieceStatusSQL;
    private String updateResolutionAndRfaOnlySQL;
    private PreparedStatement fetchPieceStatusStmt;
    private PreparedStatement savePieceStatusStmt;
    private PreparedStatement updatePieceStatusStmt;
    private PreparedStatement updateResolutionAndRfaOnlyStmt;
}
