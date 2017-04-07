// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbConsSummary.java

package cciij.cciidatabase;

import cciij.cciidata.ConsSummary;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbConsSummary extends DbBase
{

    public DbConsSummary()
    {
        fetchWithConsOidSQL = "SELECT CONS_OID_NBR, CONS_NBR, CONS_FORM_TYPE_CD, CREATE_DT, FLIGHT_NBR, FLIGHT_ORIGIN_LOC_CD, FLIGHT_DEST_LOC_CD, FLIGHT_ACTUAL_ARRIVAL_DT, CONTAINER_NBR, CONS_CD, DEST_LOCATION_CD, DEST_COUNTRY_CD, NOI_DEST_LOC_CD, EMPLOYEE_NBR, SCAN_LOC_CD, SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, SPLIT_NBR,STATUS_FLG FROM CONS_SUMMARY WHERE CONS_OID_NBR = ?";
        saveConsSummarySQL = "INSERT INTO CONS_SUMMARY (CONS_OID_NBR, CONS_NBR, CONS_FORM_TYPE_CD, CREATE_DT, FLIGHT_NBR, FLIGHT_ORIGIN_LOC_CD, FLIGHT_DEST_LOC_CD, FLIGHT_ACTUAL_ARRIVAL_DT, CONTAINER_NBR, CONS_CD, DEST_LOCATION_CD, DEST_COUNTRY_CD, NOI_DEST_LOC_CD, EMPLOYEE_NBR, SCAN_LOC_CD, SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, SPLIT_NBR,LOCATION_CD ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        updateConsSummarySQL = "UPDATE CONS_SUMMARY SET CONS_OID_NBR = ?, CONS_NBR = ?, CONS_FORM_TYPE_CD = ?, CREATE_DT = ?, FLIGHT_NBR = ?, FLIGHT_ORIGIN_LOC_CD = ?, FLIGHT_DEST_LOC_CD = ?, FLIGHT_ACTUAL_ARRIVAL_DT = ?, CONTAINER_NBR = ?, CONS_CD = ?, DEST_LOCATION_CD = ?, DEST_COUNTRY_CD = ?, NOI_DEST_LOC_CD = ?, EMPLOYEE_NBR = ?, SCAN_LOC_CD = ?, SCAN_DT = ?, UPDATE_DT = ?, TOTAL_PIECE_QTY = ?, REG_NOTICE_QTY = ?, INTERCEPT_QTY = ?, RELEASE_QTY = ?, CLEARANCE_PIECES_QTY = ?, MANIFESTED_QTY = ?, UNIQUE_QTY = ?, SPLIT_NBR = ?,STATUS_FLG=? WHERE CONS_OID_NBR = ?";
        fetchWithConsNbrSQL = "SELECT CONS_OID_NBR, CONS_NBR, CONS_FORM_TYPE_CD, CREATE_DT, FLIGHT_NBR, FLIGHT_ORIGIN_LOC_CD, FLIGHT_DEST_LOC_CD, FLIGHT_ACTUAL_ARRIVAL_DT, CONTAINER_NBR, CONS_CD, DEST_LOCATION_CD, DEST_COUNTRY_CD, NOI_DEST_LOC_CD, EMPLOYEE_NBR, SCAN_LOC_CD, SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, SPLIT_NBR,STATUS_FLG FROM CONS_SUMMARY WHERE CONS_NBR = ?";
        fetchWithConsOidStmt = null;
        fetchWithConsNbrStmt = null;
        saveConsSummaryStmt = null;
        updateConsSummaryStmt = null;
    }

    public int getConsSummaryRecordCount()
    {
        return m_recordCount;
    }

    public ConsSummary fetch(Connection conn, int consOid)
        throws SQLException
    {
        try
        {
            fetchWithConsOidStmt = conn.prepareStatement(fetchWithConsOidSQL);
            fetchWithConsOidStmt.setInt(1, consOid);
            runQuery(fetchWithConsOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(consOid);
            printSQLException(ex, getClass().getName(), "fetch", fetchWithConsOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ConsSummary fetch(Connection conn, String consNbr)
        throws SQLException
    {
        try
        {
            fetchWithConsNbrStmt = conn.prepareStatement(fetchWithConsNbrSQL);
            fetchWithConsNbrStmt.setString(1, consNbr);
            runQuery(fetchWithConsNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = consNbr;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithConsNbrSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ConsSummary fetchNext()
        throws SQLException
    {
        ConsSummary consSum = new ConsSummary();
        try
        {
            if(m_hasMore)
            {
                int consOid = m_resultSet.getInt(1);
                String consNbr = m_resultSet.getString(2);
                String consFrmTypeCd = m_resultSet.getString(3);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(4);
                String fltNbr = m_resultSet.getString(5);
                String fltOrgLocCd = m_resultSet.getString(6);
                String fltDestLocCd = m_resultSet.getString(7);
                Timestamp actualFltArrivalDtTmstp = m_resultSet.getTimestamp(8);
                String containerNbr = m_resultSet.getString(9);
                String consCd = m_resultSet.getString(10);
                String destLocCd = m_resultSet.getString(11);
                String destCntryCd = m_resultSet.getString(12);
                String noiDestLocCd = m_resultSet.getString(13);
                String emplyNbr = m_resultSet.getString(14);
                String scanLocCd = m_resultSet.getString(15);
                Timestamp scanDtTmstmp = m_resultSet.getTimestamp(16);
                Timestamp updateDtTmstmp = m_resultSet.getTimestamp(17);
                int totalPcQty = m_resultSet.getInt(18);
                int regNoticeQty = m_resultSet.getInt(19);
                int interceptQty = m_resultSet.getInt(20);
                int releaseQty = m_resultSet.getInt(21);
                int clearancePcQty = m_resultSet.getInt(22);
                int manifestedQty = m_resultSet.getInt(23);
                int uniqueQty = m_resultSet.getInt(24);
                int splitNumber = m_resultSet.getInt(25);
                int statusFlag = m_resultSet.getInt(26);
                Date createDt = convertTimestampToDate(createDtTmstp);
                Date actualFlgArrivalDt = convertTimestampToDate(actualFltArrivalDtTmstp);
                Date scanDt = convertTimestampToDate(scanDtTmstmp);
                Date updateDt = convertTimestampToDate(updateDtTmstmp);
                consSum = new ConsSummary(consOid, consNbr, consFrmTypeCd, createDt, fltNbr, fltOrgLocCd, fltDestLocCd, actualFlgArrivalDt, containerNbr, consCd, destLocCd, destCntryCd, noiDestLocCd, emplyNbr, scanLocCd, scanDt, updateDt, totalPcQty, regNoticeQty, interceptQty, releaseQty, clearancePcQty, manifestedQty, uniqueQty);
                consSum.setSplitNumber(splitNumber);
                consSum.setStatusFlag(statusFlag);
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
                consSum = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return consSum;
    }

    public void save(Connection conn, ConsSummary consSum)
        throws SQLException
    {
        try
        {
            tmstpCreateDt = new Timestamp(consSum.getCreateDate().getTime());
            if(consSum.getFlightActualArrivalDate() != null)
                tmstpActualFltArrivalDt = new Timestamp(consSum.getFlightActualArrivalDate().getTime());
            else
                tmstpActualFltArrivalDt = null;
            tmstpScanDt = new Timestamp(consSum.getScanDate().getTime());
            tmstpUpdateDt = new Timestamp(consSum.getUpdateDate().getTime());
            saveConsSummaryStmt = conn.prepareStatement(saveConsSummarySQL);
            saveConsSummaryStmt.setInt(1, consSum.getConsOidNumber());
            saveConsSummaryStmt.setString(2, consSum.getConsNumber());
            saveConsSummaryStmt.setString(3, consSum.getConsFormTypeCode());
            saveConsSummaryStmt.setTimestamp(4, tmstpCreateDt);
            saveConsSummaryStmt.setString(5, consSum.getFlightNumber());
            saveConsSummaryStmt.setString(6, consSum.getFlightOriginLocationCode());
            saveConsSummaryStmt.setString(7, consSum.getFlightDestinationLocationCode());
            saveConsSummaryStmt.setTimestamp(8, tmstpActualFltArrivalDt);
            saveConsSummaryStmt.setString(9, consSum.getContainerNumber());
            saveConsSummaryStmt.setString(10, consSum.getConsCode());
            saveConsSummaryStmt.setString(11, consSum.getDestinationLocationCode());
            saveConsSummaryStmt.setString(12, consSum.getDestinationCountryCode());
            saveConsSummaryStmt.setString(13, consSum.getNoiDestinationLocationCode());
            saveConsSummaryStmt.setString(14, consSum.getEmployeeNumber());
            saveConsSummaryStmt.setString(15, consSum.getScanLocationCode());
            saveConsSummaryStmt.setTimestamp(16, tmstpScanDt);
            saveConsSummaryStmt.setTimestamp(17, tmstpUpdateDt);
            saveConsSummaryStmt.setInt(18, consSum.getTotalPieceQuantity());
            saveConsSummaryStmt.setInt(19, consSum.getRegularNoticeQuantity());
            saveConsSummaryStmt.setInt(20, consSum.getInterceptQuantity());
            saveConsSummaryStmt.setInt(21, consSum.getReleaseQuantity());
            saveConsSummaryStmt.setInt(22, consSum.getClearancePiecesQuantity());
            saveConsSummaryStmt.setInt(23, consSum.getManifestedQuantity());
            saveConsSummaryStmt.setInt(24, consSum.getUniqueQuantity());
            saveConsSummaryStmt.setInt(25, consSum.getSplitNumber());
            saveConsSummaryStmt.setString(26,consSum.getScanLocationCode());
            saveConsSummaryStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = consSum.getConsOidNumber() + ", " + consSum.getConsNumber() + ", " + consSum.getConsFormTypeCode() + ", " + tmstpCreateDt + ", " + consSum.getFlightNumber() + ", " + consSum.getFlightOriginLocationCode() + ", " + consSum.getFlightDestinationLocationCode() + ", " + tmstpActualFltArrivalDt + ", " + consSum.getContainerNumber() + ", " + consSum.getConsCode() + ", " + consSum.getDestinationLocationCode() + ", " + consSum.getDestinationCountryCode() + ", " + consSum.getNoiDestinationLocationCode() + ", " + consSum.getEmployeeNumber() + ", " + consSum.getScanLocationCode() + ", " + tmstpScanDt + ", " + tmstpUpdateDt + ", " + consSum.getTotalPieceQuantity() + ", " + consSum.getRegularNoticeQuantity() + ", " + consSum.getInterceptQuantity() + ", " + consSum.getClearancePiecesQuantity() + ", " + consSum.getUniqueQuantity() + ", " + consSum.getSplitNumber();
            printSQLException(ex, getClass().getName(), "save", saveConsSummarySQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, ConsSummary consSum)
        throws SQLException
    {
        try
        {
            tmstpCreateDt = new Timestamp(consSum.getCreateDate().getTime());
            if(consSum.getFlightActualArrivalDate() != null)
                tmstpActualFltArrivalDt = new Timestamp(consSum.getFlightActualArrivalDate().getTime());
            else
                tmstpActualFltArrivalDt = null;
            tmstpScanDt = new Timestamp(consSum.getScanDate().getTime());
            tmstpUpdateDt = new Timestamp(consSum.getUpdateDate().getTime());
            updateConsSummaryStmt = conn.prepareStatement(updateConsSummarySQL);
            updateConsSummaryStmt.setInt(1, consSum.getConsOidNumber());
            updateConsSummaryStmt.setString(2, consSum.getConsNumber());
            updateConsSummaryStmt.setString(3, consSum.getConsFormTypeCode());
            updateConsSummaryStmt.setTimestamp(4, tmstpCreateDt);
            updateConsSummaryStmt.setString(5, consSum.getFlightNumber());
            updateConsSummaryStmt.setString(6, consSum.getFlightOriginLocationCode());
            updateConsSummaryStmt.setString(7, consSum.getFlightDestinationLocationCode());
            updateConsSummaryStmt.setTimestamp(8, tmstpActualFltArrivalDt);
            updateConsSummaryStmt.setString(9, consSum.getContainerNumber());
            updateConsSummaryStmt.setString(10, consSum.getConsCode());
            updateConsSummaryStmt.setString(11, consSum.getDestinationLocationCode());
            updateConsSummaryStmt.setString(12, consSum.getDestinationCountryCode());
            updateConsSummaryStmt.setString(13, consSum.getNoiDestinationLocationCode());
            updateConsSummaryStmt.setString(14, consSum.getEmployeeNumber());
            updateConsSummaryStmt.setString(15, consSum.getScanLocationCode());
            updateConsSummaryStmt.setTimestamp(16, tmstpScanDt);
            updateConsSummaryStmt.setTimestamp(17, tmstpUpdateDt);
            updateConsSummaryStmt.setInt(18, consSum.getTotalPieceQuantity());
            updateConsSummaryStmt.setInt(19, consSum.getRegularNoticeQuantity());
            updateConsSummaryStmt.setInt(20, consSum.getInterceptQuantity());
            updateConsSummaryStmt.setInt(21, consSum.getReleaseQuantity());
            updateConsSummaryStmt.setInt(22, consSum.getClearancePiecesQuantity());
            updateConsSummaryStmt.setInt(23, consSum.getManifestedQuantity());
            updateConsSummaryStmt.setInt(24, consSum.getUniqueQuantity());
            updateConsSummaryStmt.setInt(25, consSum.getSplitNumber());
            updateConsSummaryStmt.setInt(26, consSum.getStatusFlag());
            updateConsSummaryStmt.setInt(27, consSum.getConsOidNumber());
            updateConsSummaryStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = consSum.getConsOidNumber() + ", " + consSum.getConsNumber() + ", " + consSum.getConsFormTypeCode() + ", " + tmstpCreateDt + ", " + consSum.getFlightNumber() + ", " + consSum.getFlightOriginLocationCode() + ", " + consSum.getFlightDestinationLocationCode() + ", " + tmstpActualFltArrivalDt + ", " + consSum.getContainerNumber() + ", " + consSum.getConsCode() + ", " + consSum.getDestinationLocationCode() + ", " + consSum.getDestinationCountryCode() + ", " + consSum.getNoiDestinationLocationCode() + ", " + consSum.getEmployeeNumber() + ", " + consSum.getScanLocationCode() + ", " + tmstpScanDt + ", " + tmstpUpdateDt + ", " + consSum.getTotalPieceQuantity() + ", " + consSum.getRegularNoticeQuantity() + ", " + consSum.getInterceptQuantity() + ", " + consSum.getReleaseQuantity() + ", " + consSum.getClearancePiecesQuantity() + ", " + consSum.getManifestedQuantity() + ", " + consSum.getUniqueQuantity() + ", " + consSum.getSplitNumber();
            printSQLException(ex, getClass().getName(), "update", updateConsSummarySQL, paramList);
            throw ex;
        }
    }

    public static boolean dbTest(DatabaseBean db)
    {
        Date consDt = new Date(0L);
        ConsSummary ConsSummaryTest = new ConsSummary(12345, "140851889017", "0504", consDt, "FLIGHT", "COS", "YYZ", consDt, "ULD#", "U", "YYZ", "CA", "YYZ", "TESTER", "COS", consDt, consDt, 12, 12, 0, 12, 12, 12, 0);
        try
        {
            db.saveConsSummary(ConsSummaryTest);
            System.out.println("Test Case 1: Successfully saved ConsSummaryTest");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ConsSummaryTest " + ex);
            return false;
        }
        try
        {
            ConsSummaryTest = db.fetchConsSummary(12345);
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetchConsSummary(OidNbr) " + ConsSummaryTest);
                ConsSummaryTest = db.fetchNextConsSummary();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ConsSummaryTest(OidNbr) " + ex);
            return false;
        }
        try
        {
            ConsSummaryTest = db.fetchConsSummary("140851889017");
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetchConsSummary(ConsNbr) " + ConsSummaryTest);
                ConsSummaryTest = db.fetchNextConsSummary();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetchConsSummary(ConsNbr) " + ex);
            return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private Timestamp tmstpCreateDt;
    private Timestamp tmstpActualFltArrivalDt;
    private Timestamp tmstpScanDt;
    private Timestamp tmstpUpdateDt;
    private String fetchWithConsOidSQL;
    private String saveConsSummarySQL;
    private String updateConsSummarySQL;
    private String fetchWithConsNbrSQL;
    private PreparedStatement fetchWithConsOidStmt;
    private PreparedStatement fetchWithConsNbrStmt;
    private PreparedStatement saveConsSummaryStmt;
    private PreparedStatement updateConsSummaryStmt;
}
