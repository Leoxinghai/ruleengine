// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbClearanceActivity.java

package cciij.cciidatabase;

import cciij.cciidata.ClearanceActivity;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbClearanceActivity extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        int activityOidNbr = -3;
        String activityCode = "AMM";
        String activityDataDesc = "Test aaa";
        Date activityDt = new Date(0L);
        Date processDt = new Date(0L);
        int milsecTmstp = 33;
        int oidNbr = -2;
        String oidTypeCd = "S";
        String processDesc = "TEST CASE 1";
        String processSourceDesc = "TEST CASE 1";
        String lastUserNm = "24619";
        String agencyCd = "JJ";
        ClearanceActivity ca = new ClearanceActivity(activityOidNbr, activityCode, activityDataDesc, activityDt, milsecTmstp, oidNbr, oidTypeCd, processDesc, processDt, processSourceDesc, lastUserNm, agencyCd);
        try
        {
            ca = new ClearanceActivity(activityOidNbr, activityCode, activityDataDesc, activityDt, milsecTmstp, oidNbr, oidTypeCd, processDesc, processDt, processSourceDesc, lastUserNm, agencyCd);
            ca.setAgencyLocationCode("AAA");
            ca.setActivityLocationCode("AAA");
            db.removeClearanceActivity(ca);
            ca.setAgencyLocationCode("");
            ca.setActivityLocationCode("");
            db.saveClearanceActivity(ca);
            db.setLocationCode("BBB");
            processSourceDesc = "BBB DB TEST";
            activityOidNbr = -5;
            activityCode = "RPM";
            ca = new ClearanceActivity(activityOidNbr, activityCode, activityDataDesc, activityDt, milsecTmstp, oidNbr, oidTypeCd, processDesc, processDt, processSourceDesc, lastUserNm, agencyCd);
            ca.setAgencyLocationCode("BBB");
            ca.setActivityLocationCode("BBB");
            db.removeClearanceActivity(ca);
            db.saveClearanceActivity(ca);
            db.setLocationCode("CCC");
            activityOidNbr = -6;
            activityCode = "SAM";
            ca = new ClearanceActivity(activityOidNbr, activityCode, activityDataDesc, activityDt, milsecTmstp, oidNbr, oidTypeCd, processDesc, processDt, processSourceDesc, lastUserNm, agencyCd);
            ca.setAgencyLocationCode("CCC");
            ca.setActivityLocationCode("CCC");
            db.removeClearanceActivity(ca);
            ca.setAgencyLocationCode("");
            ca.setActivityLocationCode("");
            db.saveClearanceActivity(ca);
            System.out.println("Test Case 1: Successfully saved ClearanceActivity");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
        }
        try
        {
            db.setLocationCode("CCC");
            ca = db.fetchClearanceActivity(activityOidNbr);
            for(int currentRow = 1; db.getClearanceActivityRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2 Successful: Row " + currentRow + "-Results of fetch(activityOidNbr, m_locationCd)" + ca);
                ca = db.fetchNextClearanceActivity();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("CCC");
            ca = db.fetchClearanceActivity(oidNbr, oidTypeCd);
            for(int currentRow = 1; db.getClearanceActivityRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3 Successful: Row = " + currentRow + "-Results of fetchClearanceActivity(oidNbr, oidTypeCd, m_locationCd)" + ca);
                ca = db.fetchNextClearanceActivity();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("CCC");
            ca = db.fetchClearanceActivity(activityOidNbr);
            ca.setLastUserName("Julie");
            db.updateClearanceActivity(ca);
            ca = db.fetchClearanceActivity(activityOidNbr);
            for(int currentRow = 1; db.getClearanceActivityRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4 Successful: Row = " + currentRow + "-Results of updateClearanceActivity(ClearanceActivity ca)" + ca);
                ca = db.fetchNextClearanceActivity();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("CCC");
            ca = db.fetchClearanceActivity(activityOidNbr);
            db.removeClearanceActivity(ca);
            if(db.getClearanceActivityRecordCount() == 0)
                System.out.println("Test Case 5: Remove Successful ");
            else
                System.out.println("Test Case 5: Remove Successful ");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public DbClearanceActivity()
    {
        fetchClearanceActivitySQL = "SELECT ACTIVITY_OID_NBR, ACTIVITY_CD, ACTIVITY_DATA_DESC, ACTIVITY_TMSTP, ACTIVITY_MSEC_TMSTP, OID_NBR, OID_TYPE_CD, PROCESS_DESC, PROCESS_SOURCE_TMSTP, PROCESS_SOURCE_DESC, LAST_USER_NM, AGENCY_CD, AGENCY_LOCATION_CD, ACTIVITY_LOCATION_CD FROM CLEARANCE_ACTIVITY WHERE AGENCY_LOCATION_CD = ACTIVITY_LOCATION_CD AND ACTIVITY_OID_NBR = ? AND ACTIVITY_LOCATION_CD = ?";
        fetchByOidAndOidTypeSQL = "SELECT ACTIVITY_OID_NBR, ACTIVITY_CD, ACTIVITY_DATA_DESC, ACTIVITY_TMSTP, ACTIVITY_MSEC_TMSTP, OID_NBR, OID_TYPE_CD, PROCESS_DESC, PROCESS_SOURCE_TMSTP, PROCESS_SOURCE_DESC, LAST_USER_NM, AGENCY_CD, AGENCY_LOCATION_CD, ACTIVITY_LOCATION_CD FROM CLEARANCE_ACTIVITY WHERE AGENCY_LOCATION_CD = ACTIVITY_LOCATION_CD AND OID_NBR = ? AND OID_TYPE_CD = ? AND ACTIVITY_LOCATION_CD = ?ORDER BY ACTIVITY_TMSTP DESC";
        saveClearanceActivitySQL = "INSERT INTO CLEARANCE_ACTIVITY (ACTIVITY_OID_NBR, ACTIVITY_CD, ACTIVITY_DATA_DESC, ACTIVITY_TMSTP, ACTIVITY_MSEC_TMSTP, OID_NBR, OID_TYPE_CD, PROCESS_DESC, PROCESS_SOURCE_TMSTP, PROCESS_SOURCE_DESC, LAST_USER_NM, AGENCY_CD, AGENCY_LOCATION_CD, ACTIVITY_LOCATION_CD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeClearanceActivitySQL = "DELETE FROM CLEARANCE_ACTIVITY WHERE ACTIVITY_OID_NBR = ?";
        updateClearanceActivitySQL = "UPDATE CLEARANCE_ACTIVITY SET ACTIVITY_CD = ?,ACTIVITY_DATA_DESC = ?, ACTIVITY_TMSTP = ?, ACTIVITY_MSEC_TMSTP = ?, OID_NBR = ?, OID_TYPE_CD = ?, PROCESS_DESC = ?, PROCESS_SOURCE_TMSTP = ?, PROCESS_SOURCE_DESC = ?, LAST_USER_NM = ? , AGENCY_CD = ? WHERE ACTIVITY_OID_NBR = ? ";
        fetchClearanceActivityStmt = null;
        fetchByOidAndOidTypeStmt = null;
        saveClearanceActivityStmt = null;
        removeClearanceActivityStmt = null;
        updateClearanceActivityStmt = null;
    }

    public int getClearanceActivityRecordCount()
    {
        return m_recordCount;
    }

    public ClearanceActivity fetch(Connection conn, int activityOidNbr, String locationCd)
        throws SQLException
    {
        try
        {
            fetchClearanceActivityStmt = conn.prepareStatement(fetchClearanceActivitySQL);
            fetchClearanceActivityStmt.setInt(1, activityOidNbr);
            fetchClearanceActivityStmt.setString(2, locationCd);
            runQuery(fetchClearanceActivityStmt);
        }
        catch(SQLException ex)
        {
            String paramList = activityOidNbr + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchClearanceActivitySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ClearanceActivity fetch(Connection conn, int oidNbr, String oidTypeCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchByOidAndOidTypeStmt = conn.prepareStatement(fetchByOidAndOidTypeSQL);
            fetchByOidAndOidTypeStmt.setInt(1, oidNbr);
            fetchByOidAndOidTypeStmt.setString(2, oidTypeCd);
            fetchByOidAndOidTypeStmt.setString(3, locationCd);
            runQuery(fetchByOidAndOidTypeStmt);
        }
        catch(SQLException ex)
        {
            String paramList = oidNbr + ", " + oidTypeCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchByOidAndOidTypeSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ClearanceActivity fetchNext()
        throws SQLException
    {
        ClearanceActivity ca = new ClearanceActivity();
        try
        {
            if(m_hasMore)
            {
                int activityOidNbr = m_resultSet.getInt(1);
                String activityCode = m_resultSet.getString(2);
                String activityDataDesc = m_resultSet.getString(3);
                Timestamp activityTmstp = m_resultSet.getTimestamp(4);
                int milsecTmstp = m_resultSet.getInt(5);
                int oidNbr = m_resultSet.getInt(6);
                String oidTypeCd = m_resultSet.getString(7);
                String processDesc = m_resultSet.getString(8);
                Timestamp processSourceTmstp = m_resultSet.getTimestamp(9);
                String processSourceDesc = m_resultSet.getString(10);
                String lastUserNm = m_resultSet.getString(11);
                String agencyCd = m_resultSet.getString(12);
                String agencyLocationCode = m_resultSet.getString(13);
                String activityLocationCode = m_resultSet.getString(14);
                Date activityDt = convertTimestampToDate(activityTmstp);
                Date processDt = convertTimestampToDate(processSourceTmstp);
                ca = new ClearanceActivity(activityOidNbr, activityCode, activityDataDesc, activityDt, milsecTmstp, oidNbr, oidTypeCd, processDesc, processDt, processSourceDesc, lastUserNm, agencyCd);
                ca.setAgencyLocationCode(agencyLocationCode);
                ca.setActivityLocationCode(activityLocationCode);
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
                ca = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return ca;
    }

    public void save(Connection conn, ClearanceActivity ca, String locationCd)
        throws SQLException
    {
        try
        {
            saveClearanceActivityStmt = conn.prepareStatement(saveClearanceActivitySQL);
            activityDt = new Timestamp(ca.getActivityTimestamp().getTime());
            processDt = new Timestamp(ca.getProcessSourceTimestamp().getTime());
            saveClearanceActivityStmt.setInt(1, ca.getActivityOidNumber());
            saveClearanceActivityStmt.setString(2, ca.getActivityCode());
            saveClearanceActivityStmt.setString(3, ca.getActivityDataDescription());
            saveClearanceActivityStmt.setTimestamp(4, activityDt);
            saveClearanceActivityStmt.setInt(5, ca.getActivityMillisecondTimestamp());
            saveClearanceActivityStmt.setInt(6, ca.getOidNumber());
            saveClearanceActivityStmt.setString(7, ca.getOidTypeCode());
            saveClearanceActivityStmt.setString(8, ca.getProcessDescription());
            saveClearanceActivityStmt.setTimestamp(9, processDt);
            saveClearanceActivityStmt.setString(10, ca.getProcessSourceDescription());
            saveClearanceActivityStmt.setString(11, ca.getLastUserName());
            saveClearanceActivityStmt.setString(12, ca.getAgencyCode());
            if(ca.getAgencyLocationCode().equals(""))
                saveClearanceActivityStmt.setString(13, locationCd);
            else
                saveClearanceActivityStmt.setString(13, ca.getAgencyLocationCode());
            if(ca.getActivityLocationCode().equals(""))
                saveClearanceActivityStmt.setString(14, locationCd);
            else
                saveClearanceActivityStmt.setString(14, ca.getActivityLocationCode());
            saveClearanceActivityStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = ca.getActivityOidNumber() + ", " + ca.getActivityCode() + ", " + ca.getActivityDataDescription() + ", " + activityDt + ", " + ca.getActivityMillisecondTimestamp() + ", " + ca.getOidNumber() + ", " + ca.getOidTypeCode() + ", " + ca.getProcessDescription() + ", " + processDt + ", " + ca.getProcessSourceDescription() + ", " + ca.getLastUserName() + ", " + ca.getAgencyCode() + ", ";
            if(ca.getAgencyLocationCode().equals(""))
                paramList = paramList + locationCd;
            else
                paramList = paramList + ca.getAgencyLocationCode();
            if(ca.getActivityLocationCode().equals(""))
                paramList = paramList + locationCd;
            else
                paramList = paramList + ca.getActivityLocationCode();
            printSQLException(ex, getClass().getName(), "save", saveClearanceActivitySQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, ClearanceActivity ca)
        throws SQLException
    {
        try
        {
            removeClearanceActivityStmt = conn.prepareStatement(removeClearanceActivitySQL);
            removeClearanceActivityStmt.setInt(1, ca.getActivityOidNumber());
            removeClearanceActivityStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(ca.getActivityOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeClearanceActivitySQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, ClearanceActivity ca)
        throws SQLException
    {
        try
        {
            updateClearanceActivityStmt = conn.prepareStatement(updateClearanceActivitySQL);
            activityDt = new Timestamp(ca.getActivityTimestamp().getTime());
            processDt = new Timestamp(ca.getProcessSourceTimestamp().getTime());
            updateClearanceActivityStmt.setString(1, ca.getActivityCode());
            updateClearanceActivityStmt.setString(2, ca.getActivityDataDescription());
            updateClearanceActivityStmt.setTimestamp(3, activityDt);
            updateClearanceActivityStmt.setInt(4, ca.getActivityMillisecondTimestamp());
            updateClearanceActivityStmt.setInt(5, ca.getOidNumber());
            updateClearanceActivityStmt.setString(6, ca.getOidTypeCode());
            updateClearanceActivityStmt.setString(7, ca.getProcessDescription());
            updateClearanceActivityStmt.setTimestamp(8, processDt);
            updateClearanceActivityStmt.setString(9, ca.getProcessSourceDescription());
            updateClearanceActivityStmt.setString(10, ca.getLastUserName());
            updateClearanceActivityStmt.setString(11, ca.getAgencyCode());
            updateClearanceActivityStmt.setInt(12, ca.getActivityOidNumber());
            updateClearanceActivityStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = ca.getActivityCode() + ", " + ca.getActivityDataDescription() + ", " + activityDt + ", " + ca.getActivityMillisecondTimestamp() + ", " + ca.getOidNumber() + ", " + ca.getOidTypeCode() + ", " + ca.getProcessDescription() + ", " + processDt + ", " + ca.getProcessSourceDescription() + ", " + ca.getLastUserName() + ca.getLastUserName();
            printSQLException(ex, getClass().getName(), "update", updateClearanceActivitySQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbClearanceActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchClearanceActivitySQL;
    private String fetchByOidAndOidTypeSQL;
    private String saveClearanceActivitySQL;
    private String removeClearanceActivitySQL;
    private String updateClearanceActivitySQL;
    private PreparedStatement fetchClearanceActivityStmt;
    private PreparedStatement fetchByOidAndOidTypeStmt;
    private PreparedStatement saveClearanceActivityStmt;
    private PreparedStatement removeClearanceActivityStmt;
    private PreparedStatement updateClearanceActivityStmt;
    private Timestamp activityDt;
    private Timestamp processDt;
}
