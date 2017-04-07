// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbReleaseCodeDef.java

package cciij.cciidatabase;

import cciij.cciidata.ReleaseCodeDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbReleaseCodeDef extends DbBase
{

    public DbReleaseCodeDef()
    {
        fetchReleaseCodeDefSQL = "SELECT RELEASE_CD, RELEASE_CD_DESC, CLOSE_CER_FLG, POST_LOC_STAT_NBR, TEMPORARY_PERMANENT_CD, RECORD_ACTIVE_FLG, LOCATION_CD FROM RELEASE_CODE_DEF WHERE LOCATION_CD = ? ORDER BY RELEASE_CD";
        fetchByPrimaryKeySQL = "SELECT RELEASE_CD, RELEASE_CD_DESC, CLOSE_CER_FLG, POST_LOC_STAT_NBR, TEMPORARY_PERMANENT_CD, RECORD_ACTIVE_FLG, LOCATION_CD FROM RELEASE_CODE_DEF WHERE LOCATION_CD = ? AND RELEASE_CD = ? ORDER BY RELEASE_CD";
        saveReleaseCodeDefSQL = "INSERT INTO RELEASE_CODE_DEF  (RELEASE_CD, RELEASE_CD_DESC, CLOSE_CER_FLG, POST_LOC_STAT_NBR, TEMPORARY_PERMANENT_CD, RECORD_ACTIVE_FLG, LOCATION_CD) VALUES(?,?,?,?,?,?,?)";
        removeReleaseCodeDefSQL = "DELETE FROM RELEASE_CODE_DEF WHERE LOCATION_CD = ? AND RELEASE_CD = ?";
        updateReleaseCodeDefSQL = "UPDATE RELEASE_CODE_DEF SET RELEASE_CD_DESC = ?, CLOSE_CER_FLG = ?, POST_LOC_STAT_NBR = ?, TEMPORARY_PERMANENT_CD = ?, RECORD_ACTIVE_FLG = ? WHERE LOCATION_CD = ? AND RELEASE_CD = ?";
        fetchByPrimaryKeyStmt = null;
        fetchReleaseCodeDefStmt = null;
        saveReleaseCodeDefStmt = null;
        removeReleaseCodeDefStmt = null;
        updateReleaseCodeDefStmt = null;
    }

    public int getReleaseCodeDefRecordCount()
    {
        return m_recordCount;
    }

    public ReleaseCodeDef fetch(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeDefStmt = conn.prepareStatement(fetchReleaseCodeDefSQL);
            fetchReleaseCodeDefStmt.setString(1, locationCode);
            runQuery(fetchReleaseCodeDefStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchReleaseCodeDefSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCodeDef fetch(Connection conn, String locationCode, String releaseCode)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCode);
            fetchByPrimaryKeyStmt.setString(2, releaseCode);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + releaseCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCodeDef fetchNext()
        throws SQLException
    {
        ReleaseCodeDef rcd = new ReleaseCodeDef();
        try
        {
            if(m_hasMore)
            {
                String releaseCd = m_resultSet.getString(1);
                String releaseCodeDescription = m_resultSet.getString(2);
                String closeCerFlag = m_resultSet.getString(3);
                String postLocStatNumber = m_resultSet.getString(4);
                String temporaryPermanentCode = m_resultSet.getString(5);
                String recordActiveFlag = m_resultSet.getString(6);
                String locationCode = m_resultSet.getString(7);
                rcd = new ReleaseCodeDef(releaseCd, releaseCodeDescription, closeCerFlag, postLocStatNumber, temporaryPermanentCode, recordActiveFlag, locationCode);
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
                rcd = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return rcd;
    }

    public void save(Connection conn, ReleaseCodeDef rcd)
        throws SQLException
    {
        try
        {
            saveReleaseCodeDefStmt = conn.prepareStatement(saveReleaseCodeDefSQL);
            saveReleaseCodeDefStmt.setString(1, rcd.getReleaseCode());
            saveReleaseCodeDefStmt.setString(2, rcd.getReleaseCodeDescription());
            saveReleaseCodeDefStmt.setString(3, rcd.getCloseCerFlag());
            saveReleaseCodeDefStmt.setString(4, rcd.getPostLocStatNumber());
            saveReleaseCodeDefStmt.setString(5, rcd.getTemporaryPermanentCode());
            saveReleaseCodeDefStmt.setString(6, rcd.getRecordActiveFlag());
            saveReleaseCodeDefStmt.setString(7, rcd.getLocationCd());
            saveReleaseCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = rcd.getReleaseCode() + ", " + rcd.getReleaseCodeDescription() + ", " + rcd.getCloseCerFlag() + ", " + rcd.getPostLocStatNumber() + ", " + rcd.getTemporaryPermanentCode() + ", " + rcd.getRecordActiveFlag() + ", " + rcd.getLocationCd();
            printSQLException(ex, getClass().getName(), "save", saveReleaseCodeDefSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, String locationCode, ReleaseCodeDef rcd)
        throws SQLException
    {
        try
        {
            removeReleaseCodeDefStmt = conn.prepareStatement(removeReleaseCodeDefSQL);
            removeReleaseCodeDefStmt.setString(1, rcd.getLocationCd());
            removeReleaseCodeDefStmt.setString(2, rcd.getReleaseCode());
            removeReleaseCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList;
            if(rcd.getLocationCd() != null && !rcd.getLocationCd().equals(""))
                paramList = rcd.getLocationCd() + ", " + rcd.getReleaseCode();
            else
                paramList = locationCode + ", " + rcd.getReleaseCode();
            printSQLException(ex, getClass().getName(), "remove", removeReleaseCodeDefSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, String locationCode, ReleaseCodeDef rcd)
        throws SQLException
    {
        try
        {
            updateReleaseCodeDefStmt = conn.prepareStatement(updateReleaseCodeDefSQL);
            updateReleaseCodeDefStmt.setString(1, rcd.getReleaseCodeDescription());
            updateReleaseCodeDefStmt.setString(2, rcd.getCloseCerFlag());
            updateReleaseCodeDefStmt.setString(3, rcd.getPostLocStatNumber());
            updateReleaseCodeDefStmt.setString(4, rcd.getTemporaryPermanentCode());
            updateReleaseCodeDefStmt.setString(5, rcd.getRecordActiveFlag());
            if(rcd.getLocationCd().equals("") || rcd.getLocationCd().equals(null))
                updateReleaseCodeDefStmt.setString(6, locationCode);
            else
                updateReleaseCodeDefStmt.setString(6, rcd.getLocationCd());
            updateReleaseCodeDefStmt.setString(7, rcd.getReleaseCode());
            updateReleaseCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = rcd.getReleaseCodeDescription() + ", " + rcd.getCloseCerFlag() + ", " + rcd.getPostLocStatNumber() + ", " + rcd.getTemporaryPermanentCode() + ", " + rcd.getRecordActiveFlag() + ", " + rcd.getReleaseCode() + ", ";
            if(rcd.getLocationCd() != null && !rcd.getLocationCd().equals(""))
                paramList = paramList + rcd.getLocationCd() + ", " + rcd.getReleaseCode();
            else
                paramList = paramList + locationCode + ", " + rcd.getReleaseCode();
            printSQLException(ex, getClass().getName(), "update", updateReleaseCodeDefSQL, paramList);
            throw ex;
        }
    }

    public static boolean dbTest(DatabaseBean db)
    {
        ReleaseCodeDef releaseCodeDef = new ReleaseCodeDef("LO", "LO TEST", "Y", "99", "P", "Y", "LOR");
        db.setLocationCode("LOR");
        try
        {
            db.saveReleaseCodeDef(releaseCodeDef);
            System.out.println("Test Case 1: Successfully saved ReleaseCodeDef" + releaseCodeDef);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ReleaseCodeDef " + ex);
            return false;
        }
        try
        {
            System.out.println("In test 2");
            releaseCodeDef = db.fetchReleaseCodeDef("LO");
            System.out.println("object after fetch" + releaseCodeDef);
            for(int currentRow = 1; db.getReleaseCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetch(locationCode, releaseCode) " + releaseCodeDef);
                releaseCodeDef = db.fetchNextReleaseCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ReleaseCodeDef(locationCode, releaseCode) " + ex);
            return false;
        }
        try
        {
            releaseCodeDef = db.fetchReleaseCodeDef();
            for(int currentRow = 1; db.getReleaseCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetch(locationCode) " + releaseCodeDef);
                releaseCodeDef = db.fetchNextReleaseCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetch of ReleaseCode(locationCode) " + ex);
            return false;
        }
        try
        {
            releaseCodeDef = db.fetchReleaseCodeDef("LO");
            releaseCodeDef.setPostLocStatNumber("00");
            db.updateReleaseCodeDef(releaseCodeDef);
            releaseCodeDef = db.fetchReleaseCodeDef("LO");
            for(int currentRow = 1; db.getReleaseCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row = " + currentRow + "Results of updateReleaseCodeDef(ReleaseCodeDefinition releaseCodeDef)" + releaseCodeDef);
                releaseCodeDef = db.fetchNextReleaseCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: Unseccessful update) " + ex);
            return false;
        }
        try
        {
            db.removeReleaseCodeDef(new ReleaseCodeDef("LO", "LO TEST", "Y", "00", "P", "Y", "LOR"));
            System.out.println("Test Case 5: Successfully removed ReleaseCodeDef");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5: Unseccessful delete) " + ex);
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

    private static final String m_whatVersion = "@(#) $RCSfile: DbReleaseCodeDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private String fetchReleaseCodeDefSQL;
    private String fetchByPrimaryKeySQL;
    private String saveReleaseCodeDefSQL;
    private String removeReleaseCodeDefSQL;
    private String updateReleaseCodeDefSQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchReleaseCodeDefStmt;
    private PreparedStatement saveReleaseCodeDefStmt;
    private PreparedStatement removeReleaseCodeDefStmt;
    private PreparedStatement updateReleaseCodeDefStmt;
}
