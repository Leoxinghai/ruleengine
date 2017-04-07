// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbReasonCodeDefinition.java

package cciij.cciidatabase;

import cciij.cciidata.ReasonCodeDefinition;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbReasonCodeDefinition extends DbBase
{

    public DbReasonCodeDefinition()
    {
        fetchByPrimaryKeySQL = "SELECT LOCATION_CD, REASON_CD, REASON_CD_DESC, OPEN_CER_FLG, POST_LOC_STAT_NBR, RECORD_ACTIVE_FLG FROM REASON_CODE_DEF WHERE LOCATION_CD = ? AND REASON_CD = ? ORDER BY REASON_CD";
        fetchReasonCodeDefSQL = "SELECT LOCATION_CD, REASON_CD, REASON_CD_DESC, OPEN_CER_FLG, POST_LOC_STAT_NBR, RECORD_ACTIVE_FLG FROM REASON_CODE_DEF WHERE LOCATION_CD = ? ORDER BY REASON_CD";
        saveReasonCodeDefSQL = "INSERT INTO REASON_CODE_DEF (LOCATION_CD, REASON_CD, REASON_CD_DESC, OPEN_CER_FLG, POST_LOC_STAT_NBR, RECORD_ACTIVE_FLG) VALUES(?,?,?,?,?,?)";
        removeReasonCodeDefSQL = "DELETE FROM REASON_CODE_DEF WHERE LOCATION_CD = ? AND REASON_CD = ?";
        updateReasonCodeDefSQL = "UPDATE REASON_CODE_DEF SET REASON_CD_DESC = ?, OPEN_CER_FLG = ?, POST_LOC_STAT_NBR = ?, RECORD_ACTIVE_FLG = ? WHERE LOCATION_CD = ? AND REASON_CD = ?";
        fetchByPrimaryKeyStmt = null;
        fetchReasonCodeDefStmt = null;
        saveReasonCodeDefStmt = null;
        removeReasonCodeDefStmt = null;
        updateReasonCodeDefStmt = null;
    }

    public int getReasonCodeDefRecordCount()
    {
        return m_recordCount;
    }

    public ReasonCodeDefinition fetch(Connection conn, String locationCode, String reasonCode)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCode);
            fetchByPrimaryKeyStmt.setString(2, reasonCode);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + reasonCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCodeDefinition fetch(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchReasonCodeDefStmt = conn.prepareStatement(fetchReasonCodeDefSQL);
            fetchReasonCodeDefStmt.setString(1, locationCode);
            runQuery(fetchReasonCodeDefStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchReasonCodeDefSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCodeDefinition fetchNext()
        throws SQLException
    {
        ReasonCodeDefinition rcd = new ReasonCodeDefinition();
        try
        {
            if(m_hasMore)
            {
                String locationCode = m_resultSet.getString(1);
                String reasonCode = m_resultSet.getString(2);
                String reasonCodeDesc = m_resultSet.getString(3);
                String openCerFlg = m_resultSet.getString(4);
                String postLocStatNbr = m_resultSet.getString(5);
                String recordActiveFlg = m_resultSet.getString(6);
                rcd = new ReasonCodeDefinition(locationCode, reasonCode, reasonCodeDesc, openCerFlg, postLocStatNbr, recordActiveFlg);
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

    public void save(Connection conn, String locationCode, ReasonCodeDefinition rcd)
        throws SQLException
    {
        try
        {
            saveReasonCodeDefStmt = conn.prepareStatement(saveReasonCodeDefSQL);
            if(rcd.getLocationCode() != null && !rcd.getLocationCode().equals(""))
                saveReasonCodeDefStmt.setString(1, rcd.getLocationCode());
            else
                saveReasonCodeDefStmt.setString(1, locationCode);
            saveReasonCodeDefStmt.setString(2, rcd.getReasonCode());
            saveReasonCodeDefStmt.setString(3, rcd.getReasonCodeDescription());
            saveReasonCodeDefStmt.setString(4, rcd.getOpenCERFlag());
            saveReasonCodeDefStmt.setString(5, rcd.getPostLocStatNumber());
            saveReasonCodeDefStmt.setString(6, rcd.getRecordActiveFlag());
            saveReasonCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + rcd.getReasonCode() + ", " + rcd.getReasonCodeDescription() + ", " + rcd.getOpenCERFlag() + ", " + rcd.getPostLocStatNumber() + ", " + rcd.getRecordActiveFlag();
            printSQLException(ex, getClass().getName(), "save", saveReasonCodeDefSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, String locationCode, ReasonCodeDefinition rcd)
        throws SQLException
    {
        try
        {
            removeReasonCodeDefStmt = conn.prepareStatement(removeReasonCodeDefSQL);
            if(rcd.getLocationCode() != null && !rcd.getLocationCode().equals(""))
                removeReasonCodeDefStmt.setString(1, rcd.getLocationCode());
            else
                removeReasonCodeDefStmt.setString(1, locationCode);
            removeReasonCodeDefStmt.setString(2, rcd.getReasonCode());
            removeReasonCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList;
            if(rcd.getLocationCode() != null && !rcd.getLocationCode().equals(""))
                paramList = rcd.getLocationCode() + ", " + rcd.getReasonCode();
            else
                paramList = locationCode + ", " + rcd.getReasonCode();
            printSQLException(ex, getClass().getName(), "remove", removeReasonCodeDefSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, String locationCode, ReasonCodeDefinition rcd)
        throws SQLException
    {
        try
        {
            updateReasonCodeDefStmt = conn.prepareStatement(updateReasonCodeDefSQL);
            updateReasonCodeDefStmt.setString(1, rcd.getReasonCodeDescription());
            updateReasonCodeDefStmt.setString(2, rcd.getOpenCERFlag());
            updateReasonCodeDefStmt.setString(3, rcd.getPostLocStatNumber());
            updateReasonCodeDefStmt.setString(4, rcd.getRecordActiveFlag());
            if(rcd.getLocationCode() != null && !rcd.getLocationCode().equals(""))
                updateReasonCodeDefStmt.setString(5, rcd.getLocationCode());
            else
                updateReasonCodeDefStmt.setString(5, locationCode);
            updateReasonCodeDefStmt.setString(6, rcd.getReasonCode());
            updateReasonCodeDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = rcd.getReasonCodeDescription() + ", " + rcd.getOpenCERFlag() + ", " + rcd.getPostLocStatNumber() + ", " + rcd.getRecordActiveFlag() + ", ";
            if(rcd.getLocationCode() != null && !rcd.getLocationCode().equals(""))
                paramList = paramList + rcd.getLocationCode() + ", " + rcd.getReasonCode();
            else
                paramList = paramList + locationCode + ", " + rcd.getReasonCode();
            printSQLException(ex, getClass().getName(), "update", updateReasonCodeDefSQL, paramList);
            throw ex;
        }
    }

    public static boolean dbTest(DatabaseBean db)
    {
        ReasonCodeDefinition ReasonCodeDef = new ReasonCodeDefinition("LOR", "LO", "LO TEST", "N", "99", "Y");
        db.setLocationCode("LOR");
        try
        {
            db.saveReasonCodeDef(ReasonCodeDef);
            System.out.println("Test Case 1: Successfully saved ReasonCodeDef");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ReasonCodeDef " + ex);
            return false;
        }
        try
        {
            ReasonCodeDef = db.fetchReasonCodeDef("LO");
            for(int currentRow = 1; db.getReasonCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetch(locationCod,e reasonCode) " + ReasonCodeDef);
                ReasonCodeDef = db.fetchNextReasonCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ReasonCodeDef(locationCode, reasonCode) " + ex);
            return false;
        }
        try
        {
            ReasonCodeDef = db.fetchReasonCodeDef();
            for(int currentRow = 1; db.getReasonCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetch(locationCode) " + ReasonCodeDef);
                ReasonCodeDef = db.fetchNextReasonCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetch of ReasonCode(locationCode) " + ex);
            return false;
        }
        try
        {
            ReasonCodeDef = db.fetchReasonCodeDef("LO");
            ReasonCodeDef.setPostLocStatNumber("00");
            db.updateReasonCodeDef(ReasonCodeDef);
            ReasonCodeDef = db.fetchReasonCodeDef("LO");
            for(int currentRow = 1; db.getReasonCodeDefRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row = " + currentRow + "Results of updateReasonCodeDef(ReasonCodeDefinition ReasonCodeDef)" + ReasonCodeDef);
                ReasonCodeDef = db.fetchNextReasonCodeDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: Unseccessful update) " + ex);
            return false;
        }
        try
        {
            db.removeReasonCodeDef(new ReasonCodeDefinition("LOR", "LO", "LO TEST", "N", "00", "Y"));
            System.out.println("Test Case 5: Successfully removed ReasonCodeDefinition");
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

    private static final String m_whatVersion = "@(#) $RCSfile: DbReasonCodeDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchByPrimaryKeySQL;
    private String fetchReasonCodeDefSQL;
    private String saveReasonCodeDefSQL;
    private String removeReasonCodeDefSQL;
    private String updateReasonCodeDefSQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchReasonCodeDefStmt;
    private PreparedStatement saveReasonCodeDefStmt;
    private PreparedStatement removeReasonCodeDefStmt;
    private PreparedStatement updateReasonCodeDefStmt;
}
