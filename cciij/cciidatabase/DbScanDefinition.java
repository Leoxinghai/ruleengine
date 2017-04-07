// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbScanDefinition.java

package cciij.cciidatabase;

import cciij.cciidata.ScanDefinition;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbScanDefinition extends DbBase
{

    public DbScanDefinition()
    {
        SCAN_DEF = "SCAN_DEF ";
        fetchScanDefWithScanTypeCdSQL = "SELECT SCAN_TYPE_CD, LOC_STAT_NBR, SCAN_DESC, SCANNER_WS_ONLY_CD, MASS_ENTRY_FLG, RECORD_ACTIVE_FLG, ACTIVITY_LOG_TEXT_DESC, ALLOW_MULTIPLE_UPLOAD_FLG, ALLOW_SUBSCAN_FLG , LOCATION_CD, ACTIVITY_CD FROM " + SCAN_DEF + "WHERE SCAN_TYPE_CD = ? AND LOCATION_CD = ?";
        fetchAllScanDefOrderByScanTypeCdSQL = "SELECT SCAN_TYPE_CD, LOC_STAT_NBR, SCAN_DESC, SCANNER_WS_ONLY_CD, MASS_ENTRY_FLG, RECORD_ACTIVE_FLG, ACTIVITY_LOG_TEXT_DESC, ALLOW_MULTIPLE_UPLOAD_FLG, ALLOW_SUBSCAN_FLG , LOCATION_CD, ACTIVITY_CD FROM " + SCAN_DEF + "WHERE LOCATION_CD= ? ORDER BY SCAN_TYPE_CD";
        fetchScanDefByPrimaryKeysSQL = "SELECT SCAN_TYPE_CD, LOC_STAT_NBR, SCAN_DESC, SCANNER_WS_ONLY_CD, MASS_ENTRY_FLG, RECORD_ACTIVE_FLG, ACTIVITY_LOG_TEXT_DESC, ALLOW_MULTIPLE_UPLOAD_FLG, ALLOW_SUBSCAN_FLG , LOCATION_CD, ACTIVITY_CD FROM " + SCAN_DEF + "WHERE SCAN_TYPE_CD = ? " + "AND LOC_STAT_NBR = ? AND LOCATION_CD = ? " + "AND RECORD_ACTIVE_FLG = 'Y' ";
        saveScanDefSQL = "INSERT INTO " + SCAN_DEF + "(SCAN_TYPE_CD, " + "LOC_STAT_NBR, SCAN_DESC, " + "SCANNER_WS_ONLY_CD, MASS_ENTRY_FLG, RECORD_ACTIVE_FLG, " + "ACTIVITY_LOG_TEXT_DESC, " + "ALLOW_MULTIPLE_UPLOAD_FLG, " + "ALLOW_SUBSCAN_FLG, LOCATION_CD, ACTIVITY_CD) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        removeScanDefSQL = "DELETE FROM " + SCAN_DEF + "WHERE SCAN_TYPE_CD = ? AND LOC_STAT_NBR = ? AND LOCATION_CD = ?";
        updateScanDefSQL = "UPDATE " + SCAN_DEF + "SET " + "SCAN_DESC = ?, " + "SCANNER_WS_ONLY_CD = ?, " + "MASS_ENTRY_FLG = ?, RECORD_ACTIVE_FLG = ?, " + "ACTIVITY_LOG_TEXT_DESC = ?, " + "ALLOW_MULTIPLE_UPLOAD_FLG = ?, " + "ALLOW_SUBSCAN_FLG = ? " + "WHERE SCAN_TYPE_CD = ? AND LOC_STAT_NBR = ? AND LOCATION_CD = ?";
        fetchScanDefWithScanTypeCdStmt = null;
        fetchAllScanDefOrderByScanTypeCdStmt = null;
        fetchScanDefByPrimaryKeysStmt = null;
        saveScanDefStmt = null;
        removeScanDefStmt = null;
        updateScanDefStmt = null;
    }

    public ScanDefinition fetch(Connection conn, String locationCd)
        throws SQLException
    {
        ScanDefinition scandef = null;
        try
        {
            fetchAllScanDefOrderByScanTypeCdStmt = conn.prepareStatement(fetchAllScanDefOrderByScanTypeCdSQL);
            fetchAllScanDefOrderByScanTypeCdStmt.setString(1, locationCd);
            runQuery(fetchAllScanDefOrderByScanTypeCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchAllScanDefOrderByScanTypeCdSQL, locationCd);
            throw ex;
        }
        scandef = fetchNext();
        fetchAllScanDefOrderByScanTypeCdStmt.close();
        return scandef;
    }

    public ScanDefinition fetch(Connection conn, String scanTypeCd, String locationCd)
        throws SQLException
    {
        ScanDefinition scandef = null;
        try
        {
            fetchScanDefWithScanTypeCdStmt = conn.prepareStatement(fetchScanDefWithScanTypeCdSQL);
            fetchScanDefWithScanTypeCdStmt.setString(1, scanTypeCd);
            fetchScanDefWithScanTypeCdStmt.setString(2, locationCd);
            runQuery(fetchScanDefWithScanTypeCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchScanDefWithScanTypeCdSQL, locationCd + ", " + scanTypeCd);
            throw ex;
        }
        scandef = fetchNext();
        fetchScanDefWithScanTypeCdStmt.close();
        return scandef;
    }

    public ScanDefinition fetch(Connection conn, String scanTypeCd, String locStatNbr, String locationCd)
        throws SQLException
    {
        ScanDefinition scandef = null;
        try
        {
            fetchScanDefByPrimaryKeysStmt = conn.prepareStatement(fetchScanDefByPrimaryKeysSQL);
            fetchScanDefByPrimaryKeysStmt.setString(1, scanTypeCd);
            fetchScanDefByPrimaryKeysStmt.setString(2, locStatNbr);
            fetchScanDefByPrimaryKeysStmt.setString(3, locationCd);
            runQuery(fetchScanDefByPrimaryKeysStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchScanDefByPrimaryKeysSQL, scanTypeCd + ", " + locStatNbr + ", " + locationCd);
            throw ex;
        }
        scandef = fetchNext();
        fetchScanDefByPrimaryKeysStmt.close();
        return scandef;
    }

    public ScanDefinition fetchNext()
        throws SQLException
    {
        ScanDefinition sd = new ScanDefinition();
        try
        {
            if(m_hasMore)
            {
                String scnCd = m_resultSet.getString(1);
                String locStat = m_resultSet.getString(2);
                String scnDesc = m_resultSet.getString(3);
                String scannerWSCd = m_resultSet.getString(4);
                String massEntryFlg = m_resultSet.getString(5);
                String recordActiveFlg = m_resultSet.getString(6);
                String activityLogTxt = m_resultSet.getString(7);
                String allowMultiUpldFlg = m_resultSet.getString(8);
                String allowSubscanFlg = m_resultSet.getString(9);
                String locationCd = m_resultSet.getString(10);
                String activityCd = m_resultSet.getString(11);
                sd = new ScanDefinition(scnCd, locStat, scnDesc, scannerWSCd, massEntryFlg, recordActiveFlg, allowMultiUpldFlg, allowSubscanFlg, locationCd, activityCd);
                sd.setActivityLogTextDescription(activityLogTxt);
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
                sd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return sd;
    }

    public int getScanDefRecordCount()
    {
        return m_recordCount;
    }

    public void remove(Connection conn, ScanDefinition sd)
        throws SQLException
    {
        try
        {
            removeScanDefStmt = conn.prepareStatement(removeScanDefSQL);
            removeScanDefStmt.setString(1, sd.getScanTypeCode());
            removeScanDefStmt.setString(2, sd.getLocStatNumber());
            removeScanDefStmt.setString(3, sd.getLocationCd());
            removeScanDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeScanDefSQL, sd.getScanTypeCode() + ", " + sd.getLocStatNumber() + ", " + sd.getLocationCd());
            throw ex;
        }
    }

    public void save(Connection conn, ScanDefinition sd, String locationCd)
        throws SQLException
    {
        try
        {
            saveScanDefStmt = conn.prepareStatement(saveScanDefSQL);
            saveScanDefStmt.setString(1, sd.getScanTypeCode());
            saveScanDefStmt.setString(2, sd.getLocStatNumber());
            saveScanDefStmt.setString(3, sd.getScanDescription());
            saveScanDefStmt.setString(4, sd.getScannerWSOnlyCode());
            saveScanDefStmt.setString(5, sd.getMassEntryFlag());
            saveScanDefStmt.setString(6, sd.getRecordActiveFlag());
            saveScanDefStmt.setString(7, sd.getActivityLogTextDescription());
            saveScanDefStmt.setString(8, sd.getAllowMultipleUploadFlag());
            saveScanDefStmt.setString(9, sd.getAllowSubscanFlag());
            if(sd.getLocationCd().equals("") || sd.getLocationCd().equals(null))
                saveScanDefStmt.setString(10, locationCd);
            else
                saveScanDefStmt.setString(10, sd.getLocationCd());
            saveScanDefStmt.setString(11, sd.getActivityCode());
            saveScanDefStmt.executeUpdate();
            saveScanDefStmt.close();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveScanDefSQL, sd.getScanTypeCode() + ", " + sd.getLocStatNumber() + ", " + sd.getScanDescription() + ", " + sd.getScannerWSOnlyCode() + ", " + sd.getMassEntryFlag() + ", " + sd.getRecordActiveFlag() + ", " + sd.getActivityLogTextDescription() + ", " + sd.getAllowMultipleUploadFlag() + ", " + sd.getAllowSubscanFlag() + ", " + locationCd + ", " + sd.getActivityCode());
            throw ex;
        }
    }

    public void update(Connection conn, ScanDefinition sd)
        throws SQLException
    {
        try
        {
            updateScanDefStmt = conn.prepareStatement(updateScanDefSQL);
            updateScanDefStmt.setString(1, sd.getScanDescription());
            updateScanDefStmt.setString(2, sd.getScannerWSOnlyCode());
            updateScanDefStmt.setString(3, sd.getMassEntryFlag());
            updateScanDefStmt.setString(4, sd.getRecordActiveFlag());
            updateScanDefStmt.setString(5, sd.getActivityLogTextDescription());
            updateScanDefStmt.setString(6, sd.getAllowMultipleUploadFlag());
            updateScanDefStmt.setString(7, sd.getAllowSubscanFlag());
            updateScanDefStmt.setString(8, sd.getScanTypeCode());
            updateScanDefStmt.setString(9, sd.getLocStatNumber());
            updateScanDefStmt.setString(10, sd.getLocationCd());
            updateScanDefStmt.setString(11, sd.getActivityCode());
            updateScanDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateScanDefSQL, sd.getScanDescription() + ", " + sd.getScannerWSOnlyCode() + ", " + sd.getMassEntryFlag() + ", " + sd.getRecordActiveFlag() + ", " + sd.getActivityLogTextDescription() + ", " + sd.getAllowMultipleUploadFlag() + ", " + sd.getAllowSubscanFlag() + ", " + sd.getScanTypeCode() + ", " + sd.getLocStatNumber() + ", " + sd.getLocationCd() + ", " + sd.getActivityCode());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbScanDefinition dbScanDefinition = new DbScanDefinition();
        dbScanDefinition.testDbScanDefinition(db);
        db.closeConnection();
    }

    private void testDbScanDefinition(DatabaseBean db)
    {
        ScanDefinition scanDefinition = null;
        try
        {
            System.out.println("============Executing INSERT LOC4, SC1, AA, DESC1");
            db.saveScanDefinition(new ScanDefinition("SC1", "AA", "DESC1", "CD1", "Y", "Y", "Y", "N", "N", "LOC4"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting scanDefinition " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SC1, AA");
            scanDefinition = db.fetchScanDefinition("SC1", "AA");
            if(scanDefinition != null)
                System.out.println(scanDefinition);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE ");
            db.updateScanDefinition(new ScanDefinition("SC1", "AA", "MONICADESC1", "CD1", "Y", "Y", "Y", "N", "N", "LOC4"));
            if(scanDefinition != null)
                System.out.println(scanDefinition);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATION_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT by LOC4 ");
            if((scanDefinition = db.fetchScanDefinition()) != null)
                System.out.println(scanDefinition);
            while((scanDefinition = db.fetchNextScanDefinition()) != null) 
                System.out.println(scanDefinition);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all scanDefinition " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_TYPE_CD ");
            scanDefinition = db.fetchScanDefinition("SC1");
            if(scanDefinition != null)
                System.out.println(scanDefinition);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting scanDefinition by LOC4, AA, SC1 " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE LOC4, SC1, AA, MONICADESC1 ");
            db.removeScanDefinition(new ScanDefinition("SC1", "AA", "MONICADESC1", "CD1", "Y", "Y", "Y", "N", "N", "LOC4"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting ScanDefinition " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOC4, SC1, AA");
            scanDefinition = db.fetchScanDefinition("SC1", "AA");
            if(scanDefinition != null)
                System.out.println(scanDefinition);
            else
                System.out.println("ScanDefinition not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting LOC4, SC1, AA " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbScanDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String SCAN_DEF;
    private String fetchScanDefWithScanTypeCdSQL;
    private String fetchAllScanDefOrderByScanTypeCdSQL;
    private String fetchScanDefByPrimaryKeysSQL;
    private String saveScanDefSQL;
    private String removeScanDefSQL;
    private String updateScanDefSQL;
    private PreparedStatement fetchScanDefWithScanTypeCdStmt;
    private PreparedStatement fetchAllScanDefOrderByScanTypeCdStmt;
    private PreparedStatement fetchScanDefByPrimaryKeysStmt;
    private PreparedStatement saveScanDefStmt;
    private PreparedStatement removeScanDefStmt;
    private PreparedStatement updateScanDefStmt;
}
