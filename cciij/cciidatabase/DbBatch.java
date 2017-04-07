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
import cciij.cciidata.BatchCons;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbBatch extends DbBase
{

    public DbBatch()
    {
        fetchWithConsOidAndTrackingNbrSQL = "SELECT BATCH_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, BATCH_NBR, CONS_FORM_TYPE_CD, OID_NBR, OID_TYPE_CD, GMT_SCAN_DT, DECONS_FLG, UPDATE_SOURCE_DESC, UPDATE_DT FROM BATCH_CONS WHERE OID_NBR = ? AND TRACKING_NBR = ? AND nvl(trim(DECONS_FLG),' ') !='D' ";
        fetchWithConsOidAndTrackingNbrSQL2 = "SELECT BATCH_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, BATCH_NBR, CONS_FORM_TYPE_CD, OID_NBR, OID_TYPE_CD, GMT_SCAN_DT, DECONS_FLG, UPDATE_SOURCE_DESC, UPDATE_DT FROM BATCH_CONS WHERE BATCH_OID_NBR = ? AND TRACKING_NBR = ? ";

        fetchWithConsummarySQL = "SELECT BATCH_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, BATCH_NBR, CONS_FORM_TYPE_CD, OID_NBR, OID_TYPE_CD, GMT_SCAN_DT, DECONS_FLG, UPDATE_SOURCE_DESC, UPDATE_DT FROM BATCH_CONS WHERE BATCH_OID_NBR = ? ";
        
        fetchConsWithConsNbrSQL = "SELECT BATCH_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, BATCH_NBR, CONS_FORM_TYPE_CD, OID_NBR, OID_TYPE_CD, GMT_SCAN_DT, DECONS_FLG, UPDATE_SOURCE_DESC, UPDATE_DT FROM BATCH_CONS WHERE BATCH_NBR = ?";
        saveConsSQL = "INSERT INTO BATCH_CONS (BATCH_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, BATCH_NBR, CONS_FORM_TYPE_CD, OID_NBR, OID_TYPE_CD, GMT_SCAN_DT, DECONS_FLG, UPDATE_SOURCE_DESC, UPDATE_DT) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        updateConsSQL = "UPDATE BATCH_CONS SET FORM_TYPE_CD = ?, BATCH_NBR = ?, CONS_FORM_TYPE_CD = ?, OID_NBR = ?, OID_TYPE_CD = ?, GMT_SCAN_DT = ?, DECONS_FLG = ?, UPDATE_SOURCE_DESC = ?, UPDATE_DT = ? WHERE BATCH_OID_NBR = ? AND TRACKING_NBR = ?";
        removeBatchSQL ="DELETE BATCH_CONS WHERE BATCH_OID_NBR=? AND OID_NBR = ?";
        fetchWithConsOidAndTrackNbrStmt = null;
        fetchConsWithConsNbrStmt = null;
        updatePieceTruckNbrStmt = null;
        saveConsStmt = null;
        updateConsStmt = null;
        removeBatchStmt = null;
    }

    public int getConsRecordCount()
    {
        return m_recordCount;
    }

    public BatchCons fetch(Connection conn, int oid, String trackingNbr, boolean dconsflag)
        throws SQLException
    {
        try
        {
            if(dconsflag) {
	            fetchWithConsOidAndTrackNbrStmt = conn.prepareStatement(fetchWithConsOidAndTrackingNbrSQL);
	            fetchWithConsOidAndTrackNbrStmt.setInt(1, oid);
	            fetchWithConsOidAndTrackNbrStmt.setString(2, trackingNbr);
            } else {
	            fetchWithConsOidAndTrackNbrStmt = conn.prepareStatement(fetchWithConsOidAndTrackingNbrSQL2);
	            fetchWithConsOidAndTrackNbrStmt.setInt(1, oid);
	            fetchWithConsOidAndTrackNbrStmt.setString(2, trackingNbr);
            }
	        runQuery(fetchWithConsOidAndTrackNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = oid + ", " + trackingNbr;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithConsOidAndTrackingNbrSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public BatchCons fetch(Connection conn, int consOid )
    throws SQLException
	{
    try
    {
        fetchWithConsummaryStmt = conn.prepareStatement(fetchWithConsummarySQL);
        fetchWithConsummaryStmt.setInt(1, consOid);
        runQuery(fetchWithConsummaryStmt);
    }
    catch(SQLException ex)
    {
        String paramList = consOid + ", " ;
        printSQLException(ex, getClass().getName(), "fetch", fetchWithConsummarySQL, paramList);
        throw ex;
    }
    return fetchNext();
}
    public BatchCons fetch(Connection conn, String consNbr)
        throws SQLException
    {
        try
        {
            fetchConsWithConsNbrStmt = conn.prepareStatement(fetchConsWithConsNbrSQL);
            fetchConsWithConsNbrStmt.setString(1, consNbr);
            runQuery(fetchConsWithConsNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = consNbr;
            printSQLException(ex, getClass().getName(), "fetch", fetchConsWithConsNbrSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public BatchCons fetchNext()
        throws SQLException
    {
        BatchCons cons = new BatchCons();
        try
        {
            if(m_hasMore)
            {
                int consOid = m_resultSet.getInt(1);
                String trackingNbr = m_resultSet.getString(2);
                String formTypeCd = m_resultSet.getString(3);
                String consNbr = m_resultSet.getString(4);
                String consFormTypeCd = m_resultSet.getString(5);
                int oidNbr = m_resultSet.getInt(6);
                String oidTypeCd = m_resultSet.getString(7);
                Timestamp gmtScanDtTmstp = m_resultSet.getTimestamp(8);
                String deconsFlg = m_resultSet.getString(9);
                String updateSourceDesc = m_resultSet.getString(10);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(11);
                Date gmtScanDt = convertTimestampToDate(gmtScanDtTmstp);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                cons = new BatchCons(consOid, trackingNbr, formTypeCd, consNbr, consFormTypeCd, oidNbr, oidTypeCd, gmtScanDt, deconsFlg, updateSourceDesc, updateDt);
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
                cons = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return cons;
    }

    public void save(Connection conn, BatchCons cons)
        throws SQLException
    {
        try
        {
            tmstpGMTScanDt = new Timestamp(cons.getGMTScanDate().getTime());
            tmstpUpdateDt = new Timestamp(cons.getUpdateDate().getTime());
            saveConsStmt = conn.prepareStatement(saveConsSQL);
            saveConsStmt.setInt(1, cons.getConsOidNumber());
            saveConsStmt.setString(2, cons.getTrackingNumber());
            saveConsStmt.setString(3, cons.getFormTypeCode());
            saveConsStmt.setString(4, cons.getConsNumber());
            saveConsStmt.setString(5, cons.getConsFormTypeCode());
            saveConsStmt.setInt(6, cons.getOidNumber());
            saveConsStmt.setString(7, cons.getOidTypeCode());
            saveConsStmt.setTimestamp(8, tmstpGMTScanDt);
            saveConsStmt.setString(9, cons.getDeconsFlag());
            saveConsStmt.setString(10, cons.getUpdateSourceDescription());
            saveConsStmt.setTimestamp(11, tmstpUpdateDt);
            saveConsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = cons.getConsOidNumber() + ", " + cons.getTrackingNumber() + ", " + cons.getFormTypeCode() + ", " + cons.getConsNumber() + ", " + cons.getConsFormTypeCode() + ", " + cons.getOidNumber() + ", " + cons.getOidTypeCode() + ", " + tmstpGMTScanDt + ", " + cons.getDeconsFlag() + ", " + cons.getUpdateSourceDescription() + ", " + tmstpUpdateDt;
            printSQLException(ex, getClass().getName(), "save", saveConsSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, BatchCons cons)
        throws SQLException
    {
        try
        {
            tmstpGMTScanDt = new Timestamp(cons.getGMTScanDate().getTime());
            tmstpUpdateDt = new Timestamp(cons.getUpdateDate().getTime());
            updateConsStmt = conn.prepareStatement(updateConsSQL);
            updateConsStmt.setString(1, cons.getFormTypeCode());
            updateConsStmt.setString(2, cons.getConsNumber());
            updateConsStmt.setString(3, cons.getConsFormTypeCode());
            updateConsStmt.setInt(4, cons.getOidNumber());
            updateConsStmt.setString(5, cons.getOidTypeCode());
            updateConsStmt.setTimestamp(6, tmstpGMTScanDt);
            updateConsStmt.setString(7, cons.getDeconsFlag());
            updateConsStmt.setString(8, cons.getUpdateSourceDescription());
            updateConsStmt.setTimestamp(9, tmstpUpdateDt);
            updateConsStmt.setInt(10, cons.getConsOidNumber());
            updateConsStmt.setString(11, cons.getTrackingNumber());
            updateConsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = cons.getFormTypeCode() + ", " + cons.getConsNumber() + ", " + cons.getConsFormTypeCode() + ", " + cons.getOidNumber() + ", " + cons.getOidTypeCode() + ", " + tmstpGMTScanDt + ", " + cons.getDeconsFlag() + ", " + cons.getUpdateSourceDescription() + ", " + tmstpUpdateDt;
            printSQLException(ex, getClass().getName(), "update", updateConsSQL, paramList);
            throw ex;
        }
    }
    
    
    public void updatePieceTruckNbr(Connection conn, String truckNbr, int pieceOid)
    throws SQLException
	{
        String updatePieceTruckNbrSQL = "UPDATE PIECE SET TRUCK_NBR =? WHERE PIECE_OID_NBR =?";
	    try
	    {
	        updatePieceTruckNbrStmt = conn.prepareStatement(updatePieceTruckNbrSQL);
	        updatePieceTruckNbrStmt.setString(1, truckNbr);
	        updatePieceTruckNbrStmt.setInt(2, pieceOid);
	        updatePieceTruckNbrStmt.executeUpdate();
	    }
	    catch(SQLException ex)
	    {
	        String paramList = "Truck Nbr." + truckNbr;
	        printSQLException(ex, getClass().getName(), "update", updatePieceTruckNbrSQL, paramList);
	        throw ex;
	    }
	}

    public void remove(Connection conn, BatchCons cons)
    throws SQLException
	{
	    try
	    {
	        removeBatchStmt = conn.prepareStatement(removeBatchSQL);
	        removeBatchStmt.setInt(1, cons.getConsOidNumber());
	        removeBatchStmt.setInt(2, cons.getOidNumber());
	        removeBatchStmt.executeUpdate();
	    }
	    catch(SQLException ex)
	    {
	        printSQLException(ex, getClass().getName(), "remove", removeBatchSQL ,""+ cons.getConsOidNumber());
	        throw ex;
	    }
	}
    
    public static boolean dbTest(DatabaseBean db)
    {
        Date consDt = new Date(0L);
        BatchCons ConsTest = new BatchCons(12345, "40033333333", "0002", "140851889017", "0504", 6789, "P", consDt, " ", "TEST", consDt);
        try
        {
            db.saveBatchCons(ConsTest);
            System.out.println("Test Case 1: Successfully saved ConsTest");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ConsTest " + ex);
            return false;
        }
        try
        {
            ConsTest = db.fetchBatchCons(12345, "40033333333",false);
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetchCons(OidNbr, trkNbr) " + ConsTest);
                ConsTest = db.fetchNextBatchCons();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ConsTest(OidNbr, trkNbr) " + ex);
            return false;
        }
        try
        {
            ConsTest = db.fetchBatchCons("140851889017");
            for(int currentRow = 1; db.getConsRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetchCons(TrkNbr) " + ConsTest);
                ConsTest = db.fetchNextBatchCons();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetchCons(TrkNbr) " + ex);
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

    private static final String m_whatVersion = "@(#) $RCSfile: DbBatch.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    private Timestamp tmstpGMTScanDt;
    private Timestamp tmstpUpdateDt;
    private String fetchWithConsOidAndTrackingNbrSQL;
    private String fetchWithConsOidAndTrackingNbrSQL2;
    private String fetchWithConsummarySQL;
    
    private String fetchConsWithConsNbrSQL;
    private String saveConsSQL;
    private String updateConsSQL;
    private String removeBatchSQL;
    private PreparedStatement fetchWithConsOidAndTrackNbrStmt;
    private PreparedStatement fetchWithConsummaryStmt;
    private PreparedStatement fetchConsWithConsNbrStmt;
    private PreparedStatement saveConsStmt;
    private PreparedStatement updateConsStmt;
    private PreparedStatement updatePieceTruckNbrStmt;
    private PreparedStatement removeBatchStmt;
}
