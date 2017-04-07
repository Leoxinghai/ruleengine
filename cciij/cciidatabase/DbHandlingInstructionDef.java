// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbHandlingInstructionDef.java

package cciij.cciidatabase;

import cciij.cciidata.HandlingInstructionDefinition;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbHandlingInstructionDef extends DbBase
{

    public DbHandlingInstructionDef()
    {
        fetchWithPrimaryKeySQL = "SELECT LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, APPLIES_RELEASE_CD, RECORD_ACTIVE_FLG FROM HANDLING_INSTRUCTION_DEF WHERE LOCATION_CD = ? AND HANDLING_INSTRUCTION_CD = ? ORDER BY HANDLING_INSTRUCTION_CD";
        fetchHandlingInstructionDefSQL = "SELECT LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, APPLIES_RELEASE_CD, RECORD_ACTIVE_FLG FROM HANDLING_INSTRUCTION_DEF WHERE LOCATION_CD = ? ORDER BY HANDLING_INSTRUCTION_CD";
        saveHandlingInstructionDefSQL = "INSERT INTO HANDLING_INSTRUCTION_DEF  (LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, APPLIES_RELEASE_CD, RECORD_ACTIVE_FLG) VALUES(?,?,?,?,?)";
        removeHandlingInstructionDefSQL = "DELETE FROM HANDLING_INSTRUCTION_DEF WHERE LOCATION_CD = ? AND HANDLING_INSTRUCTION_CD = ?";
        updateHandlingInstructionDefSQL = "UPDATE HANDLING_INSTRUCTION_DEF SET HANDLING_INSTRUCTION_DESC = ?, APPLIES_RELEASE_CD = ?, RECORD_ACTIVE_FLG = ? WHERE LOCATION_CD = ? AND HANDLING_INSTRUCTION_CD = ?";
        fetchWithPrimaryKeyStmt = null;
        fetchHandlingInstructionDefStmt = null;
        saveHandlingInstructionDefStmt = null;
        removeHandlingInstructionDefStmt = null;
        updateHandlingInstructionDefStmt = null;
    }

    public int getHandlingInstructionDefRecordCount()
    {
        return m_recordCount;
    }

    public HandlingInstructionDefinition fetch(Connection conn, String locationCode, String hiCd)
        throws SQLException
    {
        try
        {
            fetchWithPrimaryKeyStmt = conn.prepareStatement(fetchWithPrimaryKeySQL);
            fetchWithPrimaryKeyStmt.setString(1, locationCode);
            fetchWithPrimaryKeyStmt.setString(2, hiCd);
            runQuery(fetchWithPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + hiCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructionDefinition fetch(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchHandlingInstructionDefStmt = conn.prepareStatement(fetchHandlingInstructionDefSQL);
            fetchHandlingInstructionDefStmt.setString(1, locationCode);
            runQuery(fetchHandlingInstructionDefStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchHandlingInstructionDefSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructionDefinition fetchNext()
        throws SQLException
    {
        HandlingInstructionDefinition hiDef = new HandlingInstructionDefinition();
        try
        {
            if(m_hasMore)
            {
                String locationCode = m_resultSet.getString(1);
                String hiCd = m_resultSet.getString(2);
                String hiDesc = m_resultSet.getString(3);
                String appliesReleaseCd = m_resultSet.getString(4);
                String recordActiveFlg = m_resultSet.getString(5);
                hiDef = new HandlingInstructionDefinition(locationCode, hiCd, hiDesc, appliesReleaseCd, recordActiveFlg);
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
                hiDef = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return hiDef;
    }

    public void save(Connection conn, HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        try
        {
            saveHandlingInstructionDefStmt = conn.prepareStatement(saveHandlingInstructionDefSQL);
            saveHandlingInstructionDefStmt.setString(1, hiDef.getLocationCode());
            saveHandlingInstructionDefStmt.setString(2, hiDef.getHandlingInstructionCode());
            saveHandlingInstructionDefStmt.setString(3, hiDef.getHandlingInstructionDescription());
            saveHandlingInstructionDefStmt.setString(4, hiDef.getAppliesReleaseCode());
            saveHandlingInstructionDefStmt.setString(5, hiDef.getRecordActiveFlag());
            saveHandlingInstructionDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hiDef.getLocationCode() + ", " + hiDef.getHandlingInstructionCode() + ", " + hiDef.getHandlingInstructionDescription() + ", " + hiDef.getAppliesReleaseCode() + ", " + hiDef.getRecordActiveFlag();
            printSQLException(ex, getClass().getName(), "save", saveHandlingInstructionDefSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        try
        {
            removeHandlingInstructionDefStmt = conn.prepareStatement(removeHandlingInstructionDefSQL);
            removeHandlingInstructionDefStmt.setString(1, hiDef.getLocationCode());
            removeHandlingInstructionDefStmt.setString(2, hiDef.getHandlingInstructionCode());
            removeHandlingInstructionDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hiDef.getLocationCode() + ", " + hiDef.getHandlingInstructionCode();
            printSQLException(ex, getClass().getName(), "remove", removeHandlingInstructionDefSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        try
        {
            updateHandlingInstructionDefStmt = conn.prepareStatement(updateHandlingInstructionDefSQL);
            updateHandlingInstructionDefStmt.setString(1, hiDef.getHandlingInstructionDescription());
            updateHandlingInstructionDefStmt.setString(2, hiDef.getAppliesReleaseCode());
            updateHandlingInstructionDefStmt.setString(3, hiDef.getRecordActiveFlag());
            updateHandlingInstructionDefStmt.setString(4, hiDef.getLocationCode());
            updateHandlingInstructionDefStmt.setString(5, hiDef.getHandlingInstructionCode());
            updateHandlingInstructionDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hiDef.getHandlingInstructionDescription() + ", " + hiDef.getAppliesReleaseCode() + ", " + hiDef.getRecordActiveFlag() + ", " + hiDef.getLocationCode() + ", " + hiDef.getHandlingInstructionCode();
            printSQLException(ex, getClass().getName(), "update", updateHandlingInstructionDefSQL, paramList);
            throw ex;
        }
    }

    public static void dbTest(DatabaseBean db)
    {
        HandlingInstructionDefinition hiDef = new HandlingInstructionDefinition();
        HandlingInstructionDefinition hiDef1 = new HandlingInstructionDefinition("TEK", "TEK1", "TEK'S TEST HIDEF ONE", "Y", "Y");
        HandlingInstructionDefinition hiDef2 = new HandlingInstructionDefinition("TEK", "TEK2", "TEK'S TEST HIDEF TWO", "Y", "Y");
        db.setLocationCode("TEK");
        try
        {
            db.saveHandlingInstructionDef(hiDef1);
            System.out.println("Test Case 1: Successfully saved HandlingInstructionDef hiDef1");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
            db.saveHandlingInstructionDef(hiDef2);
            System.out.println("Test Case 1: Successfully saved HandlingInstructionDef hiDef2");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: unsuccessful" + ex);
        }
        hiDef2.setHandlingInstructionDescription("TEK'S TEST HIDEF 2");
        hiDef2.setAppliesReleaseCode("N");
        hiDef2.setRecordActiveFlag("N");
        try
        {
            db.updateHandlingInstructionDef(hiDef2);
            System.out.println("Test Case 2: Successfully updated HandlingInstructionDef hiDef2");
            db.commitTransaction();
            System.out.println("Test Case 2: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: unsuccessful" + ex);
        }
        try
        {
            hiDef = db.fetchHandlingInstructionDef("TEK1");
            System.out.println("Test Case 3a: Successfully fetched hiDef1; HandlingInstructionDef = " + hiDef);
            hiDef = db.fetchHandlingInstructionDef();
            for(int currentRow = 1; db.getHandlingInstructionDef() > 0; currentRow++)
            {
                System.out.println("Test Case 3b: Successfully fetched Row = " + currentRow + " HandlingInstructionDef = " + hiDef);
                hiDef = db.fetchNextHandlingInstructionDef();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: unsuccessful" + ex);
        }
        try
        {
            db.removeHandlingInstructionDef(hiDef1);
            System.out.println("Test Case 4: Successfully removed HandlingInstructionDef hiDef1");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
            db.removeHandlingInstructionDef(hiDef2);
            System.out.println("Test Case 4: Successfully removed HandlingInstructionDef hiDef2");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: unsuccessful" + ex);
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbHandlingInstructionDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchWithPrimaryKeySQL;
    private String fetchHandlingInstructionDefSQL;
    private String saveHandlingInstructionDefSQL;
    private String removeHandlingInstructionDefSQL;
    private String updateHandlingInstructionDefSQL;
    private PreparedStatement fetchWithPrimaryKeyStmt;
    private PreparedStatement fetchHandlingInstructionDefStmt;
    private PreparedStatement saveHandlingInstructionDefStmt;
    private PreparedStatement removeHandlingInstructionDefStmt;
    private PreparedStatement updateHandlingInstructionDefStmt;
}
