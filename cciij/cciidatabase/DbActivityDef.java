// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbActivityDef.java

package cciij.cciidatabase;

import cciij.cciidata.ActivityDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbActivityDef extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        ActivityDef ad = new ActivityDef("testa", "testaa", "aaa test", "Y", "S", "M");
        try
        {
            db.setLocationCode("aaa");
            ad.setLocationCode("aaa");
            db.removeActivityDef(ad);
            ad.setLocationCode("");
            db.saveActivityDef(ad);
            db.setLocationCode("bbb");
            ad = new ActivityDef("testb", "testbb", "bbb test", "Y", "S", "M");
            ad.setLocationCode("bbb");
            db.removeActivityDef(ad);
            ad.setLocationCode("");
            db.saveActivityDef(ad);
            ad = new ActivityDef("testc", "testcc", "ccc test", "N", "S", "M");
            db.setLocationCode("ccc");
            ad.setLocationCode("ccc");
            db.removeActivityDef(ad);
            db.saveActivityDef(ad);
            System.out.println("Test Case 1: Successfully saved ActivityDef");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
        }
        int currentRow;
        try
        {
            db.setLocationCode("ccc");
            ad = db.fetchActivityDef("testc");
            for(currentRow = 1; db.getActivityDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2 Successful: Row " + currentRow + "-Results of fetch(activityCd, locationCd)" + ad);
                ad = db.fetchNextActivityDef();
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
            db.setLocationCode("ccc");
            ad = db.fetchActivityDef();
            for(currentRow = 1; db.getActivityDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3 Successful: Row = " + currentRow + "-Results of fetch(locationCd)" + ad);
                ad = db.fetchNextActivityDef();
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
            db.setLocationCode("ccc");
            ad = db.fetchActivityDef("testc");
            ad.setRecordActiveFlag("Y");
            db.updateActivityDef(ad);
            System.out.println("Test Case 4 Successful: Row = " + currentRow + "-Results update" + ad);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            ad = db.fetchActivityDef("testc");
            db.removeActivityDef(ad);
            if(db.fetchActivityDef("testc") == null)
                System.out.println("Test Case 5: Remove Successful ");
            else
                System.out.println("Test Case 5: Remove UnSuccessful ");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public DbActivityDef()
    {
        fetchByPrimaryKeySQL = "SELECT ACTIVITY_CD, ACTIVITY_TYPE_DESC, ACTIVITY_TEXT_TEMPLATE_DESC, RECORD_ACTIVE_FLG, OID_TYPE_CD, ACTIVITY_RETRIEVAL_TYPE_CD, LOCATION_CD FROM ACTIVITY_DEF WHERE ACTIVITY_CD = ? AND LOCATION_CD = ? ORDER BY ACTIVITY_CD";
        fetchAllSQL = "SELECT ACTIVITY_CD, ACTIVITY_TYPE_DESC, ACTIVITY_TEXT_TEMPLATE_DESC, RECORD_ACTIVE_FLG, OID_TYPE_CD, ACTIVITY_RETRIEVAL_TYPE_CD, LOCATION_CD FROM ACTIVITY_DEF WHERE LOCATION_CD = ? ORDER BY ACTIVITY_CD";
        saveActivityDefSQL = "INSERT INTO ACTIVITY_DEF (ACTIVITY_CD, ACTIVITY_TYPE_DESC, ACTIVITY_TEXT_TEMPLATE_DESC, RECORD_ACTIVE_FLG, OID_TYPE_CD, ACTIVITY_RETRIEVAL_TYPE_CD, LOCATION_CD)VALUES(?,?,?,?,?,?,?)";
        removeActivityDefSQL = "DELETE FROM ACTIVITY_DEF WHERE ACTIVITY_CD = ? AND LOCATION_CD = ?";
        updateActivityDefSQL = "UPDATE ACTIVITY_DEF SET ACTIVITY_TYPE_DESC = ?, ACTIVITY_TEXT_TEMPLATE_DESC = ?, RECORD_ACTIVE_FLG = ?, OID_TYPE_CD = ?, ACTIVITY_RETRIEVAL_TYPE_CD = ? WHERE ACTIVITY_CD = ? AND LOCATION_CD = ?";
        fetchByPrimaryKeyStmt = null;
        fetchAllStmt = null;
        saveActivityDefStmt = null;
        removeActivityDefStmt = null;
        updateActivityDefStmt = null;
    }

    public int getActivityDefRecordCount()
    {
        return m_recordCount;
    }

    public ActivityDef fetch(Connection conn, String activityCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, activityCd);
            fetchByPrimaryKeyStmt.setString(2, locationCd);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = activityCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ActivityDef fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllStmt = conn.prepareStatement(fetchAllSQL);
            fetchAllStmt.setString(1, locationCd);
            runQuery(fetchAllStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchAllSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ActivityDef fetchNext()
        throws SQLException
    {
        ActivityDef ad = new ActivityDef();
        try
        {
            if(m_hasMore)
            {
                String activityCd = m_resultSet.getString(1);
                String actTypeDesc = m_resultSet.getString(2);
                String actTxtTmpltDesc = m_resultSet.getString(3);
                String recordActiveFlg = m_resultSet.getString(4);
                String oidTypeCd = m_resultSet.getString(5);
                String actRetrvTypeCd = m_resultSet.getString(6);
                String locationCd = m_resultSet.getString(7);
                ad = new ActivityDef(activityCd, actTypeDesc, actTxtTmpltDesc, recordActiveFlg, oidTypeCd, actRetrvTypeCd);
                ad.setLocationCode(locationCd);
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
                ad = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", "", "");
            throw ex;
        }
        return ad;
    }

    public void save(Connection conn, ActivityDef ad, String locationCd)
        throws SQLException
    {
        try
        {
            saveActivityDefStmt = conn.prepareStatement(saveActivityDefSQL);
            saveActivityDefStmt.setString(1, ad.getActivityCode());
            saveActivityDefStmt.setString(2, ad.getActivityTypeDescription());
            saveActivityDefStmt.setString(3, ad.getActivityTextTemplateDescription());
            saveActivityDefStmt.setString(4, ad.getRecordActiveFlag());
            saveActivityDefStmt.setString(5, ad.getOidTypeCode());
            saveActivityDefStmt.setString(6, ad.getActivityRetrievalTypeCode());
            if(ad.getLocationCode().equals(""))
                saveActivityDefStmt.setString(7, locationCd);
            else
                saveActivityDefStmt.setString(7, ad.getLocationCode());
            System.out.println("DbActivityDef save " + ad);
            saveActivityDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = ad.getActivityCode() + ", " + ad.getActivityTypeDescription() + ", " + ad.getActivityTextTemplateDescription() + ", " + ad.getRecordActiveFlag() + ", " + ad.getOidTypeCode() + ", " + ad.getActivityRetrievalTypeCode();
            if(ad.getLocationCode().equals(""))
                paramList = paramList + ", " + locationCd;
            else
                paramList = paramList + ", " + ad.getLocationCode();
            printSQLException(ex, getClass().getName(), "save", saveActivityDefSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, ActivityDef ad)
        throws SQLException
    {
        try
        {
            removeActivityDefStmt = conn.prepareStatement(removeActivityDefSQL);
            removeActivityDefStmt.setString(1, ad.getActivityCode());
            removeActivityDefStmt.setString(2, ad.getLocationCode());
            removeActivityDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = ad.getActivityCode() + ", " + ad.getLocationCode();
            printSQLException(ex, getClass().getName(), "remove", removeActivityDefSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, ActivityDef ad)
        throws SQLException
    {
        try
        {
            updateActivityDefStmt = conn.prepareStatement(updateActivityDefSQL);
            updateActivityDefStmt.setString(1, ad.getActivityTypeDescription());
            updateActivityDefStmt.setString(2, ad.getActivityTextTemplateDescription());
            updateActivityDefStmt.setString(3, ad.getRecordActiveFlag());
            updateActivityDefStmt.setString(4, ad.getOidTypeCode());
            updateActivityDefStmt.setString(5, ad.getActivityRetrievalTypeCode());
            updateActivityDefStmt.setString(6, ad.getActivityCode());
            updateActivityDefStmt.setString(7, ad.getLocationCode());
            updateActivityDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = ad.getActivityTypeDescription() + ", " + ad.getActivityTextTemplateDescription() + ", " + ad.getRecordActiveFlag() + ", " + ad.getOidTypeCode() + ", " + ad.getActivityRetrievalTypeCode() + ", " + ad.getActivityCode() + ", " + ad.getLocationCode();
            printSQLException(ex, getClass().getName(), "update", updateActivityDefSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbActivityDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchByPrimaryKeySQL;
    private String fetchAllSQL;
    private String saveActivityDefSQL;
    private String removeActivityDefSQL;
    private String updateActivityDefSQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchAllStmt;
    private PreparedStatement saveActivityDefStmt;
    private PreparedStatement removeActivityDefStmt;
    private PreparedStatement updateActivityDefStmt;
}
