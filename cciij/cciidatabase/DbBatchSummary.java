/*
 * Created on May 5, 2006
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
import cciij.cciidata.BatchConsSummary;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbBatchSummary extends DbBase
{

    public DbBatchSummary()
    {
        fetchWithConsOidSQL = "SELECT BATCH_OID_NBR, BATCH_NBR, CONS_FORM_TYPE_CD, CREATE_DT, TRUCK_NBR, ORIGIN_LOC_CD, DEST_LOC_CD, EMPLOYEE_NBR, SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, STATUS_FLG FROM BATCH_CONS_SUMMARY WHERE BATCH_OID_NBR = ?";
        saveConsSummarySQL = "INSERT INTO BATCH_CONS_SUMMARY (BATCH_OID_NBR, BATCH_NBR, CONS_FORM_TYPE_CD, CREATE_DT, TRUCK_NBR, ORIGIN_LOC_CD, DEST_LOC_CD, EMPLOYEE_NBR,  SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, LOCATION_CD ) VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
        updateConsSummarySQL = "UPDATE BATCH_CONS_SUMMARY SET BATCH_OID_NBR = ?, BATCH_NBR = ?, CONS_FORM_TYPE_CD = ?, CREATE_DT = ?,  ORIGIN_LOC_CD = ?, DEST_LOC_CD = ?,  EMPLOYEE_NBR = ?, SCAN_DT = ?, UPDATE_DT = ?, TOTAL_PIECE_QTY = ?, REG_NOTICE_QTY = ?, INTERCEPT_QTY = ?, RELEASE_QTY = ?, CLEARANCE_PIECES_QTY = ?, MANIFESTED_QTY = ?, UNIQUE_QTY = ?, STATUS_FLG=? WHERE BATCH_OID_NBR = ?";
        fetchWithConsNbrSQL = "SELECT BATCH_OID_NBR, BATCH_NBR, CONS_FORM_TYPE_CD, CREATE_DT, TRUCK_NBR, ORIGIN_LOC_CD, DEST_LOC_CD, EMPLOYEE_NBR, SCAN_DT, UPDATE_DT, TOTAL_PIECE_QTY, REG_NOTICE_QTY, INTERCEPT_QTY, RELEASE_QTY, CLEARANCE_PIECES_QTY, MANIFESTED_QTY, UNIQUE_QTY, STATUS_FLG FROM BATCH_CONS_SUMMARY WHERE BATCH_NBR = ?";
        fetchWithConsOidStmt = null;
        fetchWithConsNbrStmt = null;
        saveConsSummaryStmt = null;
        updateConsSummaryStmt = null;
    }

    public int getConsSummaryRecordCount()
    {
        return m_recordCount;
    }

    public BatchConsSummary fetch(Connection conn, int consOid)
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

    public BatchConsSummary fetch(Connection conn, String consNbr)
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

    public BatchConsSummary fetchNext()
        throws SQLException
    {
        BatchConsSummary consSum = new BatchConsSummary();
        try
        {
            if(m_hasMore)
            {
                int consOid = m_resultSet.getInt(1);
                String consNbr = m_resultSet.getString(2);
                String consFrmTypeCd = m_resultSet.getString(3);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(4);
                String fltNbr = m_resultSet.getString(5);
                String originLocCd = m_resultSet.getString(6);
                String destLocCd = m_resultSet.getString(7);
                String emplyNbr = m_resultSet.getString(8);
                String scanLocCd = "";
                Timestamp scanDtTmstmp = m_resultSet.getTimestamp(9);
                Timestamp updateDtTmstmp = m_resultSet.getTimestamp(10);
                int totalPcQty = m_resultSet.getInt(11);
                int regNoticeQty = m_resultSet.getInt(12);
                int interceptQty = m_resultSet.getInt(13);
                int releaseQty = m_resultSet.getInt(14);
                int clearancePcQty = m_resultSet.getInt(15);
                int manifestedQty = m_resultSet.getInt(16);
                int uniqueQty = m_resultSet.getInt(17);
//                int splitNumber = m_resultSet.getInt(18);
                int statusFlag = m_resultSet.getInt(18);
                Date createDt = convertTimestampToDate(createDtTmstp);
                Date scanDt = convertTimestampToDate(scanDtTmstmp);
                Date updateDt = convertTimestampToDate(updateDtTmstmp);
                consSum = new BatchConsSummary(consOid, consNbr, consFrmTypeCd, createDt, fltNbr, originLocCd, "", null, "", "", destLocCd, "", "", emplyNbr, scanLocCd, scanDt, updateDt, totalPcQty, regNoticeQty, interceptQty, releaseQty, clearancePcQty, manifestedQty, uniqueQty);
//                consSum.setSplitNumber(splitNumber);
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

    public void save(Connection conn, BatchConsSummary consSum)
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
            saveConsSummaryStmt.setString(5, consSum.getContainerNumber());
            saveConsSummaryStmt.setString(6, consSum.getFlightOriginLocationCode());
            saveConsSummaryStmt.setString(7, consSum.getDestinationLocationCode());
            
            saveConsSummaryStmt.setString(8, consSum.getEmployeeNumber());
            saveConsSummaryStmt.setTimestamp(9, tmstpScanDt);
            saveConsSummaryStmt.setTimestamp(10, tmstpUpdateDt);
            saveConsSummaryStmt.setInt(11, consSum.getTotalPieceQuantity());
            saveConsSummaryStmt.setInt(12, consSum.getRegularNoticeQuantity());
            saveConsSummaryStmt.setInt(13, consSum.getInterceptQuantity());
            saveConsSummaryStmt.setInt(14, consSum.getReleaseQuantity());
            saveConsSummaryStmt.setInt(15, consSum.getClearancePiecesQuantity());
            saveConsSummaryStmt.setInt(16, consSum.getManifestedQuantity());
            saveConsSummaryStmt.setInt(17, consSum.getUniqueQuantity());
//            saveConsSummaryStmt.setInt(25, consSum.getSplitNumber());
            saveConsSummaryStmt.setString(18,consSum.getScanLocationCode());
            saveConsSummaryStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = consSum.getConsOidNumber() + ", " + consSum.getConsNumber() + ", " + consSum.getConsFormTypeCode() + ", " + tmstpCreateDt + ", " + consSum.getFlightNumber() + ", " + consSum.getFlightOriginLocationCode() + ", " + consSum.getFlightDestinationLocationCode() + ", " + tmstpActualFltArrivalDt + ", " + consSum.getContainerNumber() + ", " + consSum.getConsCode() + ", " + consSum.getDestinationLocationCode() + ", " + consSum.getDestinationCountryCode() + ", " + consSum.getNoiDestinationLocationCode() + ", " + consSum.getEmployeeNumber() + ", " + consSum.getScanLocationCode() + ", " + tmstpScanDt + ", " + tmstpUpdateDt + ", " + consSum.getTotalPieceQuantity() + ", " + consSum.getRegularNoticeQuantity() + ", " + consSum.getInterceptQuantity() + ", " + consSum.getClearancePiecesQuantity() + ", " + consSum.getUniqueQuantity() + ", " + consSum.getSplitNumber();
            printSQLException(ex, getClass().getName(), "save", saveConsSummarySQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, BatchConsSummary consSum)
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
//            updateConsSummaryStmt.setString(5, consSum.getFlightNumber());
            updateConsSummaryStmt.setString(5, consSum.getFlightOriginLocationCode());
            updateConsSummaryStmt.setString(6, consSum.getFlightDestinationLocationCode());
            updateConsSummaryStmt.setString(7, consSum.getEmployeeNumber());
            updateConsSummaryStmt.setTimestamp(8, tmstpScanDt);
            updateConsSummaryStmt.setTimestamp(9, tmstpUpdateDt);
            updateConsSummaryStmt.setInt(10, consSum.getTotalPieceQuantity());
            updateConsSummaryStmt.setInt(11, consSum.getRegularNoticeQuantity());
            updateConsSummaryStmt.setInt(12, consSum.getInterceptQuantity());
            updateConsSummaryStmt.setInt(13, consSum.getReleaseQuantity());
            updateConsSummaryStmt.setInt(14, consSum.getClearancePiecesQuantity());
            updateConsSummaryStmt.setInt(15, consSum.getManifestedQuantity());
            updateConsSummaryStmt.setInt(16, consSum.getUniqueQuantity());
            updateConsSummaryStmt.setInt(17, consSum.getStatusFlag());
            updateConsSummaryStmt.setInt(18, consSum.getConsOidNumber());
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
        BatchConsSummary ConsSummaryTest = new BatchConsSummary(12345, "140851889017", "0504", consDt, "FLIGHT", "COS", "YYZ", consDt, "ULD#", "U", "YYZ", "CA", "YYZ", "TESTER", "COS", consDt, consDt, 12, 12, 0, 12, 12, 12, 0);
        try
        {
            db.saveBatchConsSummary(ConsSummaryTest);
            System.out.println("Test Case 1: Successfully saved ConsSummaryTest");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ConsSummaryTest " + ex);
            return false;
        }
        try
        {
            ConsSummaryTest = db.fetchBatchConsSummary(12345);
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetchConsSummary(OidNbr) " + ConsSummaryTest);
                ConsSummaryTest = db.fetchNextBatchConsSummary();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ConsSummaryTest(OidNbr) " + ex);
            return false;
        }
        try
        {
            ConsSummaryTest = db.fetchBatchConsSummary("140851889017");
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetchConsSummary(ConsNbr) " + ConsSummaryTest);
                ConsSummaryTest = db.fetchNextBatchConsSummary();
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

    private static final String m_whatVersion = "@(#) $RCSfile: DbBatchSummary.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
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

