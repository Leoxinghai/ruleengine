// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbInterceptDef.java

package cciij.cciidatabase;

import cciij.cciidata.InterceptCodeDefinition;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbInterceptDef extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static void dbTest(DatabaseBean db)
    {
        InterceptCodeDefinition interceptDef = new InterceptCodeDefinition("tl3", "MONICATEST", 1, "Y", "RA", "NNN ARRIVAL COMMENT", "NNN SATISFIED COMMENT");
        try
        {
            db.setLocationCode("ZZZ");
            interceptDef.setUpdateEmployeeNumber("Monica1");
            db.saveInterceptCodeDef(interceptDef);
            interceptDef = db.fetchInterceptCodeDef("tl3");
            if(interceptDef != null)
                System.out.println("Inserted " + interceptDef);
            interceptDef.setUpdateEmployeeNumber("Monica3");
            db.updateInterceptCodeDef(interceptDef);
            InterceptCodeDefinition ic = db.fetchInterceptCodeDef("tl3");
            if(ic != null)
                System.out.println("Updated " + ic);
            else
                System.out.println("Update did not happen ");
            db.removeInterceptCodeDef(interceptDef);
            InterceptCodeDefinition ic2 = db.fetchInterceptCodeDefAllActive();
            if(ic2 == null)
                System.out.println("InterceptDef removed ");
            else
                System.out.println("Intercept fetched " + ic2);
            db.closeConnection();
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
        }
    }

    public DbInterceptDef()
    {
        fetchWithInterceptCdSQL = "SELECT INTERCEPT_CD, INTERCEPT_DESC, INTERCEPT_PRIORITY_NBR, RECORD_ACTIVE_FLG, RESTRICTED_AGENCY_CD, ARRIVAL_COMMENT_TEXT_DESC, SATISFIED_COMMENT_TEXT_DESC, INTERCEPT_LABEL_TEXT_DESC, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, LOCATION_CD FROM INTERCEPT_DEF WHERE INTERCEPT_CD = ? AND LOCATION_CD = ? ORDER BY INTERCEPT_CD";
        fetchInterceptDefSQL = "SELECT INTERCEPT_CD, INTERCEPT_DESC, INTERCEPT_PRIORITY_NBR, RECORD_ACTIVE_FLG, RESTRICTED_AGENCY_CD, ARRIVAL_COMMENT_TEXT_DESC, SATISFIED_COMMENT_TEXT_DESC, INTERCEPT_LABEL_TEXT_DESC, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, LOCATION_CD FROM INTERCEPT_DEF WHERE LOCATION_CD = ? ORDER BY INTERCEPT_CD";
        fetchAllActiveInterceptDefSQL = "SELECT INTERCEPT_CD, INTERCEPT_DESC, INTERCEPT_PRIORITY_NBR, RECORD_ACTIVE_FLG, RESTRICTED_AGENCY_CD, ARRIVAL_COMMENT_TEXT_DESC, SATISFIED_COMMENT_TEXT_DESC, INTERCEPT_LABEL_TEXT_DESC, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, LOCATION_CD FROM INTERCEPT_DEF WHERE RECORD_ACTIVE_FLG = 'Y' AND LOCATION_CD = ? ORDER BY INTERCEPT_CD";
        saveInterceptDefSQL = "INSERT INTO INTERCEPT_DEF (INTERCEPT_CD, INTERCEPT_DESC, INTERCEPT_PRIORITY_NBR, RECORD_ACTIVE_FLG, RESTRICTED_AGENCY_CD, ARRIVAL_COMMENT_TEXT_DESC, SATISFIED_COMMENT_TEXT_DESC, INTERCEPT_LABEL_TEXT_DESC, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, LOCATION_CD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeInterceptDefSQL = "DELETE FROM INTERCEPT_DEF WHERE INTERCEPT_CD = ? AND LOCATION_CD = ?";
        updateInterceptDefSQL = "UPDATE INTERCEPT_DEF SET INTERCEPT_DESC = ?, INTERCEPT_PRIORITY_NBR = ?, RECORD_ACTIVE_FLG = ?, RESTRICTED_AGENCY_CD = ?, ARRIVAL_COMMENT_TEXT_DESC = ?, SATISFIED_COMMENT_TEXT_DESC = ?, INTERCEPT_LABEL_TEXT_DESC = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ? WHERE INTERCEPT_CD = ? AND LOCATION_CD = ?";
        fetchWithInterceptCdStmt = null;
        fetchInterceptDefStmt = null;
        fetchAllActiveInterceptDefStmt = null;
        saveInterceptDefStmt = null;
        removeInterceptDefStmt = null;
        updateInterceptDefStmt = null;
    }

    public int getInterceptDefRecordCount()
    {
        return m_recordCount;
    }

    public InterceptCodeDefinition fetch(Connection conn, String interceptCode, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithInterceptCdStmt = conn.prepareStatement(fetchWithInterceptCdSQL);
            fetchWithInterceptCdStmt.setString(1, interceptCode);
            fetchWithInterceptCdStmt.setString(2, locationCode);
            runQuery(fetchWithInterceptCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = interceptCode + ", " + locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithInterceptCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptCodeDefinition fetch(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchInterceptDefStmt = conn.prepareStatement(fetchInterceptDefSQL);
            fetchInterceptDefStmt.setString(1, locationCode);
            runQuery(fetchInterceptDefStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchInterceptDefSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptCodeDefinition fetchAllActiveInterceptDef(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchAllActiveInterceptDefStmt = conn.prepareStatement(fetchAllActiveInterceptDefSQL);
            fetchAllActiveInterceptDefStmt.setString(1, locationCode);
            runQuery(fetchAllActiveInterceptDefStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetchAllActiveInterceptDef", fetchAllActiveInterceptDefSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public InterceptCodeDefinition fetchNext()
        throws SQLException
    {
        InterceptCodeDefinition icd = new InterceptCodeDefinition();
        try
        {
            if(m_hasMore)
            {
                String iCd = m_resultSet.getString(1);
                String iDesc = m_resultSet.getString(2);
                int priorityNbr = m_resultSet.getInt(3);
                String recordStatusFlg = m_resultSet.getString(4);
                String restrictedAgcyCd = m_resultSet.getString(5);
                String arrivalCommentTxt = m_resultSet.getString(6);
                String satisfiedCommentTxt = m_resultSet.getString(7);
                String interceptLablTextDesc = m_resultSet.getString(8);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(9);
                String createEmpNum = m_resultSet.getString(10);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(11);
                String updtEmpNum = m_resultSet.getString(12);
                String locationCode = m_resultSet.getString(13);
                Date createDt = convertTimestampToDate(createDtTmstp);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                icd = new InterceptCodeDefinition(iCd, iDesc, priorityNbr, recordStatusFlg, restrictedAgcyCd, arrivalCommentTxt, satisfiedCommentTxt);
                icd.setInterceptLabelTextDescription(interceptLablTextDesc);
                icd.setCreateDate(createDtTmstp);
                icd.setCreateEmployeeNumber(createEmpNum);
                icd.setUpdateDate(updateDtTmstp);
                icd.setUpdateEmployeeNumber(updtEmpNum);
                icd.setLocationCode(locationCode);
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
                icd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return icd;
    }

    public void save(Connection conn, InterceptCodeDefinition icd, String locationCode)
        throws SQLException
    {
        Timestamp createDtTimestamp = new Timestamp(icd.getCreateDate().getTime());
        Timestamp updateDtTimestamp = new Timestamp(icd.getUpdateDate().getTime());
        try
        {
            saveInterceptDefStmt = conn.prepareStatement(saveInterceptDefSQL);
            saveInterceptDefStmt.setString(1, icd.getInterceptCode());
            saveInterceptDefStmt.setString(2, icd.getInterceptDescription());
            saveInterceptDefStmt.setInt(3, icd.getInterceptPriorityNumber());
            saveInterceptDefStmt.setString(4, icd.getRecordActiveFlag());
            saveInterceptDefStmt.setString(5, icd.getRestrictedAgencyCode());
            saveInterceptDefStmt.setString(6, icd.getArrivalCommentText());
            saveInterceptDefStmt.setString(7, icd.getSatisfiedCommentText());
            saveInterceptDefStmt.setString(8, icd.getInterceptLabelTextDescription());
            saveInterceptDefStmt.setTimestamp(9, createDtTimestamp);
            saveInterceptDefStmt.setString(10, icd.getCreateEmployeeNumber());
            saveInterceptDefStmt.setTimestamp(11, updateDtTimestamp);
            saveInterceptDefStmt.setString(12, icd.getUpdateEmployeeNumber());
            if(icd.getLocationCode().equals(""))
                saveInterceptDefStmt.setString(13, locationCode);
            else
                saveInterceptDefStmt.setString(13, icd.getLocationCode());
            saveInterceptDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = icd.getInterceptCode() + ", " + icd.getInterceptDescription() + ", " + icd.getInterceptPriorityNumber() + ", " + icd.getInterceptPriorityNumber() + ", " + icd.getRestrictedAgencyCode() + ", " + icd.getArrivalCommentText() + ", " + icd.getSatisfiedCommentText() + ", " + icd.getInterceptLabelTextDescription() + ", " + createDtTimestamp + ", " + icd.getCreateEmployeeNumber() + ", " + updateDtTimestamp + ", " + icd.getUpdateEmployeeNumber() + ", ";
            if(icd.getLocationCode().equals(""))
                paramList = paramList + locationCode;
            else
                paramList = paramList + icd.getLocationCode();
            printSQLException(ex, getClass().getName(), "save", saveInterceptDefSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, InterceptCodeDefinition icd)
        throws SQLException
    {
        try
        {
            removeInterceptDefStmt = conn.prepareStatement(removeInterceptDefSQL);
            removeInterceptDefStmt.setString(1, icd.getInterceptCode());
            removeInterceptDefStmt.setString(2, icd.getLocationCode());
            removeInterceptDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = icd.getInterceptCode() + ", " + icd.getLocationCode();
            printSQLException(ex, getClass().getName(), "remove", removeInterceptDefSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, InterceptCodeDefinition icd)
        throws SQLException
    {
        Timestamp createDtTimestamp = new Timestamp(icd.getCreateDate().getTime());
        Timestamp updateDtTimestamp = new Timestamp(icd.getUpdateDate().getTime());
        try
        {
            updateInterceptDefStmt = conn.prepareStatement(updateInterceptDefSQL);
            updateInterceptDefStmt.setString(1, icd.getInterceptDescription());
            updateInterceptDefStmt.setInt(2, icd.getInterceptPriorityNumber());
            updateInterceptDefStmt.setString(3, icd.getRecordActiveFlag());
            updateInterceptDefStmt.setString(4, icd.getRestrictedAgencyCode());
            updateInterceptDefStmt.setString(5, icd.getArrivalCommentText());
            updateInterceptDefStmt.setString(6, icd.getSatisfiedCommentText());
            updateInterceptDefStmt.setString(7, icd.getInterceptLabelTextDescription());
            updateInterceptDefStmt.setTimestamp(8, createDtTimestamp);
            updateInterceptDefStmt.setString(9, icd.getCreateEmployeeNumber());
            updateInterceptDefStmt.setTimestamp(10, updateDtTimestamp);
            updateInterceptDefStmt.setString(11, icd.getUpdateEmployeeNumber());
            updateInterceptDefStmt.setString(12, icd.getInterceptCode());
            updateInterceptDefStmt.setString(13, icd.getLocationCode());
            updateInterceptDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = icd.getInterceptDescription() + ", " + icd.getInterceptPriorityNumber() + ", " + icd.getRecordActiveFlag() + ", " + icd.getRestrictedAgencyCode() + ", " + icd.getArrivalCommentText() + ", " + icd.getSatisfiedCommentText() + ", " + icd.getInterceptLabelTextDescription() + ", " + icd.getInterceptLabelTextDescription() + ", " + icd.getCreateEmployeeNumber() + ", " + updateDtTimestamp + ", " + icd.getUpdateEmployeeNumber() + ", " + icd.getInterceptCode() + ", " + icd.getLocationCode();
            printSQLException(ex, getClass().getName(), "update", updateInterceptDefSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbInterceptDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchWithInterceptCdSQL;
    private String fetchInterceptDefSQL;
    private String fetchAllActiveInterceptDefSQL;
    private String saveInterceptDefSQL;
    private String removeInterceptDefSQL;
    private String updateInterceptDefSQL;
    private PreparedStatement fetchWithInterceptCdStmt;
    private PreparedStatement fetchInterceptDefStmt;
    private PreparedStatement fetchAllActiveInterceptDefStmt;
    private PreparedStatement saveInterceptDefStmt;
    private PreparedStatement removeInterceptDefStmt;
    private PreparedStatement updateInterceptDefStmt;
}
