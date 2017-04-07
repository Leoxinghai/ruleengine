// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbSiteParam.java

package cciij.cciidatabase;

import cciij.cciidata.SiteParam;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbSiteParam extends DbBase
{

    public DbSiteParam()
    {
        SITE_PARAM = "SITE_PARAM ";
        fetchSiteParamSQL = "SELECT LOCATION_CD, PARAM_NM, PARAM_VALUE, PARAM_DESC, GROUP_NM, EDIT_LEVEL_NBR FROM " + SITE_PARAM + " ORDER BY LOCATION_CD";
        fetchByPrimaryKeySQL = "SELECT LOCATION_CD, PARAM_NM, PARAM_VALUE, PARAM_DESC, GROUP_NM, EDIT_LEVEL_NBR FROM " + SITE_PARAM + "WHERE LOCATION_CD = ? AND PARAM_NM = ? " + "AND GROUP_NM = ?";
        fetchByLocationCdSQL = "SELECT LOCATION_CD, PARAM_NM, PARAM_VALUE, PARAM_DESC, GROUP_NM, EDIT_LEVEL_NBR FROM " + SITE_PARAM + " WHERE LOCATION_CD = ?";
        fetchByLocationAndGroupSQL = "SELECT LOCATION_CD, PARAM_NM, PARAM_VALUE, PARAM_DESC, GROUP_NM, EDIT_LEVEL_NBR FROM " + SITE_PARAM + " WHERE LOCATION_CD = ? AND GROUP_NM = ?";
        fetchAllSiteLocationCdSQL = "SELECT DISTINCT LOCATION_CD FROM " + SITE_PARAM + " WHERE LOCATION_CD != 'ALL' " + "ORDER BY LOCATION_CD";
        saveSiteParamSQL = "INSERT INTO " + SITE_PARAM + " (LOCATION_CD, " + "PARAM_NM, PARAM_VALUE, PARAM_DESC, GROUP_NM, EDIT_LEVEL_NBR ) " + "VALUES(?,?,?,?,?,?)";
        removeSiteParamSQL = "DELETE FROM " + SITE_PARAM + " WHERE LOCATION_CD = ?";
        removeSiteParamWithConditionsSQL = "DELETE FROM " + SITE_PARAM + " WHERE LOCATION_CD = ? AND GROUP_NM = ? " + "AND PARAM_NM = ?";
        updateSiteParamSQL = "UPDATE " + SITE_PARAM + "SET PARAM_NM = ?, PARAM_VALUE = ?, PARAM_DESC = ?, " + "GROUP_NM = ?, EDIT_LEVEL_NBR = ? WHERE LOCATION_CD = ?";
        updateSiteParamNonKeyFieldsSQL = "UPDATE " + SITE_PARAM + "SET PARAM_VALUE = ?, PARAM_DESC = ?, EDIT_LEVEL_NBR = ? " + "WHERE LOCATION_CD = ? AND GROUP_NM = ? AND PARAM_NM = ?";
        updateSiteParam3ConditionsSQL = "UPDATE " + SITE_PARAM + "SET PARAM_NM = ?, PARAM_VALUE = ?, PARAM_DESC = ?, " + "EDIT_LEVEL_NBR = ? " + "WHERE LOCATION_CD = ? AND GROUP_NM = ? AND PARAM_NM = ?";
        fetchByPrimaryKeyStmt = null;
        fetchSiteParamStmt = null;
        fetchByLocationCdStmt = null;
        fetchByLocationAndGroupStmt = null;
        fetchAllSiteLocationCdStmt = null;
        saveSiteParamStmt = null;
        removeSiteParamStmt = null;
        removeSiteParamWithConditionsStmt = null;
        updateSiteParamStmt = null;
        updateSiteParamNonKeyFieldsStmt = null;
        updateSiteParam3ConditionsStmt = null;
    }

    public SiteParam fetch(Connection conn)
        throws SQLException
    {
        try
        {
            fetchSiteParamStmt = conn.prepareStatement(fetchSiteParamSQL);
            runQuery(fetchSiteParamStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchSiteParamSQL, "");
            throw ex;
        }
        return fetchNext();
    }

    public SiteParam fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchByLocationCdStmt = conn.prepareStatement(fetchByLocationCdSQL);
            fetchByLocationCdStmt.setString(1, locationCd);
            runQuery(fetchByLocationCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchByLocationCdSQL, locationCd);
            throw ex;
        }
        return fetchNext();
    }

    public SiteParam fetch(Connection conn, String locationCd, String groupNm)
        throws SQLException
    {
        try
        {
            fetchByLocationAndGroupStmt = conn.prepareStatement(fetchByLocationAndGroupSQL);
            fetchByLocationAndGroupStmt.setString(1, locationCd);
            fetchByLocationAndGroupStmt.setString(2, groupNm);
            runQuery(fetchByLocationAndGroupStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchByLocationAndGroupSQL, locationCd + ", " + groupNm);
            throw ex;
        }
        return fetchNext();
    }

    public SiteParam fetch(Connection conn, String locationCd, String paramNm, String groupNm)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCd);
            fetchByPrimaryKeyStmt.setString(2, paramNm);
            fetchByPrimaryKeyStmt.setString(3, groupNm);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, locationCd + ", " + paramNm + ", " + groupNm);
            throw ex;
        }
        return fetchNext();
    }

    public String fetchAllSiteLocationCd(Connection conn)
        throws SQLException
    {
        try
        {
            fetchAllSiteLocationCdStmt = conn.prepareStatement(fetchAllSiteLocationCdSQL);
            runQuery(fetchAllSiteLocationCdStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchAllSiteLocationCd", fetchAllSiteLocationCdSQL, "");
            throw ex;
        }
        return fetchNextSiteLocationCd();
    }

    public SiteParam fetchNext()
        throws SQLException
    {
        SiteParam sp = new SiteParam();
        try
        {
            if(m_hasMore)
            {
                String locCd = m_resultSet.getString(1);
                String paramNm = m_resultSet.getString(2);
                String paramVal = m_resultSet.getString(3);
                String paramDesc = m_resultSet.getString(4);
                String groupNm = m_resultSet.getString(5);
                int editLevelNbr = m_resultSet.getInt(6);
                sp = new SiteParam(locCd, paramNm, paramVal, paramDesc, groupNm, editLevelNbr);
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
                sp = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return sp;
    }

    public String fetchNextSiteLocationCd()
        throws SQLException
    {
        String siteLocationCd = "";
        try
        {
            if(m_hasMore)
            {
                siteLocationCd = m_resultSet.getString(1);
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
                siteLocationCd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNextSiteLocationCd", "", "");
            throw ex;
        }
        return siteLocationCd;
    }

    public int getSiteParamRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        boolean testResult = test(db);
        if(testResult)
            System.out.println("Test method run SUCCESSFUL");
        else
            System.out.println("Test method run FAILED");
    }

    public void remove(Connection conn, SiteParam sp)
        throws SQLException
    {
        try
        {
            removeSiteParamStmt = conn.prepareStatement(removeSiteParamSQL);
            removeSiteParamStmt.setString(1, sp.getLocationCode());
            removeSiteParamStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeSiteParamSQL, sp.getLocationCode());
            throw ex;
        }
    }

    public void remove(Connection conn, String locCd, String grpNm, String paramNm)
        throws SQLException
    {
        try
        {
            removeSiteParamWithConditionsStmt = conn.prepareStatement(removeSiteParamWithConditionsSQL);
            removeSiteParamWithConditionsStmt.setString(1, locCd);
            removeSiteParamWithConditionsStmt.setString(2, grpNm);
            removeSiteParamWithConditionsStmt.setString(3, paramNm);
            removeSiteParamWithConditionsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeSiteParamWithConditionsSQL, locCd + ", " + paramNm + ", " + grpNm);
            throw ex;
        }
    }

    public void save(Connection conn, SiteParam sp)
        throws SQLException
    {
        try
        {
            saveSiteParamStmt = conn.prepareStatement(saveSiteParamSQL);
            saveSiteParamStmt.setString(1, sp.getLocationCode());
            saveSiteParamStmt.setString(2, sp.getParamName());
            saveSiteParamStmt.setString(3, sp.getParamValue());
            saveSiteParamStmt.setString(4, sp.getParamDescription());
            saveSiteParamStmt.setString(5, sp.getGroupName());
            saveSiteParamStmt.setInt(6, sp.getEditLevelNbr());
            saveSiteParamStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveSiteParamSQL, sp.getLocationCode() + ", " + sp.getParamName() + ", " + sp.getParamValue() + ", " + sp.getParamDescription() + ", " + sp.getGroupName() + ", " + sp.getEditLevelNbr());
            throw ex;
        }
    }

    public static boolean test(DatabaseBean db)
    {
        SiteParam siteParam = new SiteParam("ZZZ", "TEST1 PARAM", "TEST1 VALUE", "Save SiteParam Record", "TEST1 GRP");
        try
        {
            db.saveSiteParam(siteParam);
            System.out.println("Test Case 1: Successfully saved SiteParam");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1, saving SiteParam unsuccessful " + ex);
            return false;
        }
        siteParam = new SiteParam("ZZK", "TEST2 PARAM", "TEST2 VALUE", "Save SiteParam with edit level", "TEST2 GRP", 1);
        try
        {
            db.saveSiteParam(siteParam);
            System.out.println("Test Case 2: Successfully saved SiteParam");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2, saving SiteParam unsuccessful " + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("YIB");
            for(int currentRow = 1; db.getSiteParamRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetchSiteParam(locationCd) " + siteParam);
                siteParam = db.fetchNextSiteParam();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3 unsuccessful " + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam();
            for(int currentRow = 1; db.getSiteParamRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row = " + currentRow + " Results of fetchSiteParam() " + siteParam);
                siteParam = db.fetchNextSiteParam();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful " + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            for(int currentRow = 1; db.getSiteParamRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row = " + currentRow + " Results of fetchSiteParam(locCd, groupNm) " + siteParam);
                siteParam = db.fetchNextSiteParam();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5 unsuccessful " + ex);
            return false;
        }
        try
        {
            String locCd = db.fetchSiteParamAllSiteLocationCd();
            for(int currentRow = 1; db.getSiteParamRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 6: Row = " + currentRow + " Results of fetchSiteParamAllSiteLocationCd() " + locCd);
                locCd = db.fetchSiteParamNextSiteLocationCd();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 6 unsuccessful " + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            siteParam.setParamName("UPDATE TEST 7");
            siteParam.setEditLevelNbr(7);
            db.updateSiteParam(siteParam);
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            System.out.println("Test Case 7:  Results of updateSiteParam(siteParam) " + siteParam);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 7 unsuccessful" + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            siteParam.setParamName("UPDATE TEST 8");
            siteParam.setParamValue("UPDATE TEST 8 VALUE");
            siteParam.setEditLevelNbr(8);
            db.updateSiteParam(siteParam, "UPDATE TEST 7");
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            System.out.println("Test Case 8:  Results of updateSiteParam(siteParam, oldParamName) " + siteParam);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 8 unsuccessful" + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            siteParam.setParamValue("UPDATE TEST 9 VALUE");
            siteParam.setEditLevelNbr(9);
            db.updateSiteParamNonKeyFields(siteParam);
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            System.out.println("Test Case 9:  Results of updateSiteParamNonKeyFields(siteParam) " + siteParam);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 9 unsuccessful" + ex);
            return false;
        }
        try
        {
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            db.removeSiteParam(siteParam);
            siteParam = db.fetchSiteParam("ZZZ", "TEST1 GRP");
            System.out.println("Test Case 10:  Results of removeSiteParam(siteParam) " + siteParam);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 10 unsuccessful " + ex);
            return false;
        }
        try
        {
            db.removeSiteParam("ZZK", "TEST2 GRP", "TEST2 PARAM");
            siteParam = db.fetchSiteParam("ZZK", "TEST2 GRP");
            System.out.println("Test Case 11:  Results of removeSiteParam(locCd, groupNm, paramNm) " + siteParam);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 11 unsuccessful" + ex);
            return false;
        }
        return true;
    }

    public void update(Connection conn, SiteParam sp)
        throws SQLException
    {
        try
        {
            updateSiteParamStmt = conn.prepareStatement(updateSiteParamSQL);
            updateSiteParamStmt.setString(1, sp.getParamName());
            updateSiteParamStmt.setString(2, sp.getParamValue());
            updateSiteParamStmt.setString(3, sp.getParamDescription());
            updateSiteParamStmt.setString(4, sp.getGroupName());
            updateSiteParamStmt.setInt(5, sp.getEditLevelNbr());
            updateSiteParamStmt.setString(6, sp.getLocationCode());
            updateSiteParamStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateSiteParamSQL, sp.getParamName() + ", " + sp.getParamValue() + ", " + sp.getParamDescription() + ", " + sp.getGroupName() + ", " + sp.getEditLevelNbr() + ", " + sp.getLocationCode());
            throw ex;
        }
    }

    public void update(Connection conn, SiteParam sp, String oldParamNm)
        throws SQLException
    {
        try
        {
            updateSiteParam3ConditionsStmt = conn.prepareStatement(updateSiteParam3ConditionsSQL);
            updateSiteParam3ConditionsStmt.setString(1, sp.getParamName());
            updateSiteParam3ConditionsStmt.setString(2, sp.getParamValue());
            updateSiteParam3ConditionsStmt.setString(3, sp.getParamDescription());
            updateSiteParam3ConditionsStmt.setInt(4, sp.getEditLevelNbr());
            updateSiteParam3ConditionsStmt.setString(5, sp.getLocationCode());
            updateSiteParam3ConditionsStmt.setString(6, sp.getGroupName());
            updateSiteParam3ConditionsStmt.setString(7, oldParamNm);
            updateSiteParam3ConditionsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateSiteParam3ConditionsSQL, sp.getParamName() + ", " + sp.getParamValue() + ", " + sp.getParamDescription() + ", " + sp.getEditLevelNbr() + ", " + sp.getLocationCode() + ", " + sp.getGroupName() + ", " + oldParamNm);
            throw ex;
        }
    }

    public void updateNonKeyFields(Connection conn, SiteParam sp)
        throws SQLException
    {
        try
        {
            updateSiteParamNonKeyFieldsStmt = conn.prepareStatement(updateSiteParamNonKeyFieldsSQL);
            updateSiteParamNonKeyFieldsStmt.setString(1, sp.getParamValue());
            updateSiteParamNonKeyFieldsStmt.setString(2, sp.getParamDescription());
            updateSiteParamNonKeyFieldsStmt.setInt(3, sp.getEditLevelNbr());
            updateSiteParamNonKeyFieldsStmt.setString(4, sp.getLocationCode());
            updateSiteParamNonKeyFieldsStmt.setString(5, sp.getGroupName());
            updateSiteParamNonKeyFieldsStmt.setString(6, sp.getParamName());
            updateSiteParamNonKeyFieldsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "updateNonKeyFields", updateSiteParamNonKeyFieldsSQL, sp.getParamValue() + ", " + sp.getParamDescription() + ", " + sp.getEditLevelNbr() + ", " + sp.getLocationCode() + ", " + sp.getGroupName() + ", " + sp.getParamName());
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbSiteParam.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String SITE_PARAM;
    private String fetchSiteParamSQL;
    private String fetchByPrimaryKeySQL;
    private String fetchByLocationCdSQL;
    private String fetchByLocationAndGroupSQL;
    private String fetchAllSiteLocationCdSQL;
    private String saveSiteParamSQL;
    private String removeSiteParamSQL;
    private String removeSiteParamWithConditionsSQL;
    private String updateSiteParamSQL;
    private String updateSiteParamNonKeyFieldsSQL;
    private String updateSiteParam3ConditionsSQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchSiteParamStmt;
    private PreparedStatement fetchByLocationCdStmt;
    private PreparedStatement fetchByLocationAndGroupStmt;
    private PreparedStatement fetchAllSiteLocationCdStmt;
    private PreparedStatement saveSiteParamStmt;
    private PreparedStatement removeSiteParamStmt;
    private PreparedStatement removeSiteParamWithConditionsStmt;
    private PreparedStatement updateSiteParamStmt;
    private PreparedStatement updateSiteParamNonKeyFieldsStmt;
    private PreparedStatement updateSiteParam3ConditionsStmt;
}
