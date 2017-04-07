// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRuleSets.java

package cciij.cciidatabase;

import cciij.cciidata.RuleSets;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbRuleSets extends DbBase
{

    public DbRuleSets()
    {
        RULE_SET = "RULE_SET ";
        fetchOrderedByRuleNbrCondtionNbrSQL = "SELECT SET_NM, RULE_NBR, CONDITION_NBR, CLASS_ID_NBR, FIELD_ID_NBR, OPERATION_NBR, VALUE_DESC FROM " + RULE_SET + " ORDER BY SET_NM, RULE_NBR, CONDITION_NBR";
        saveRuleSetsSQL = "INSERT INTO " + RULE_SET + " (SET_NM, RULE_NBR, " + "CONDITION_NBR, CLASS_ID_NBR, FIELD_ID_NBR, OPERATION_NBR, VALUE_DESC) " + "VALUES(?,?,?,?,?,?,?)";
        removeRuleSetsSQL = "DELETE FROM " + RULE_SET + " WHERE SET_NM = ? AND RULE_NBR = ? AND " + "CONDITION_NBR = ?";
        updateRuleSetsSQL = "UPDATE " + RULE_SET + "SET " + "SET_NM = ?, RULE_NBR = ?, " + "CONDITION_NBR = ?, CLASS_ID_NBR = ?, FIELD_ID_NBR = ?, " + "OPERATION_NBR = ?, VALUE_DESC = ? " + "WHERE SET_NM = ? AND RULE_NBR = ? AND " + "CONDITION_NBR = ?";
        fetchOrderedByRuleAndCondNbrsStmt = null;
        saveRuleSetsStmt = null;
        removeRuleSetsStmt = null;
        updateRuleSetsStmt = null;
    }

    public int getRuleSetsRecordCount()
    {
        return m_recordCount;
    }

    public RuleSets fetch(Connection conn)
        throws SQLException
    {
        try
        {
            fetchOrderedByRuleAndCondNbrsStmt = conn.prepareStatement(fetchOrderedByRuleNbrCondtionNbrSQL);
            runQuery(fetchOrderedByRuleAndCondNbrsStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchOrderedByRuleNbrCondtionNbrSQL, "");
            throw ex;
        }
        return fetchNext();
    }

    public RuleSets fetchNext()
        throws SQLException
    {
        RuleSets ruleSets = new RuleSets();
        try
        {
            if(m_hasMore)
            {
                ruleSets.setSet(m_resultSet.getString(1));
                ruleSets.setRuleNumber(m_resultSet.getInt(2));
                ruleSets.setConditionNumber(m_resultSet.getInt(3));
                ruleSets.setClassId(m_resultSet.getInt(4));
                ruleSets.setFieldId(m_resultSet.getInt(5));
                ruleSets.setOperation(m_resultSet.getInt(6));
                ruleSets.setValue(m_resultSet.getString(7));
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
                ruleSets = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return ruleSets;
    }

    public void save(Connection conn, RuleSets rs)
        throws SQLException
    {
        try
        {
            saveRuleSetsStmt = conn.prepareStatement(saveRuleSetsSQL);
            saveRuleSetsStmt.setString(1, rs.getSet());
            saveRuleSetsStmt.setInt(2, rs.getRuleNumber());
            saveRuleSetsStmt.setInt(3, rs.getConditionNumber());
            saveRuleSetsStmt.setInt(4, rs.getClassId());
            saveRuleSetsStmt.setInt(5, rs.getFieldId());
            saveRuleSetsStmt.setInt(6, rs.getOperation());
            saveRuleSetsStmt.setString(7, rs.getValue());
            saveRuleSetsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveRuleSetsSQL, rs.getSet() + ", " + rs.getRuleNumber() + ", " + rs.getConditionNumber() + ", " + rs.getClassId() + ", " + rs.getFieldId() + ", " + rs.getOperation() + ", " + rs.getValue());
            throw ex;
        }
    }

    public void remove(Connection conn, RuleSets rs)
        throws SQLException
    {
        try
        {
            removeRuleSetsStmt = conn.prepareStatement(removeRuleSetsSQL);
            removeRuleSetsStmt.setString(1, rs.getSet());
            removeRuleSetsStmt.setInt(2, rs.getRuleNumber());
            removeRuleSetsStmt.setInt(3, rs.getConditionNumber());
            removeRuleSetsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeRuleSetsSQL, rs.getSet() + ", " + rs.getRuleNumber() + ", " + rs.getConditionNumber());
            throw ex;
        }
    }

    public void update(Connection conn, RuleSets rs)
        throws SQLException
    {
        try
        {
            updateRuleSetsStmt = conn.prepareStatement(updateRuleSetsSQL);
            updateRuleSetsStmt.setString(1, rs.getSet());
            updateRuleSetsStmt.setInt(2, rs.getRuleNumber());
            updateRuleSetsStmt.setInt(3, rs.getConditionNumber());
            updateRuleSetsStmt.setInt(4, rs.getClassId());
            updateRuleSetsStmt.setInt(5, rs.getFieldId());
            updateRuleSetsStmt.setInt(6, rs.getOperation());
            updateRuleSetsStmt.setString(7, rs.getValue());
            updateRuleSetsStmt.setString(8, rs.getSet());
            updateRuleSetsStmt.setInt(9, rs.getRuleNumber());
            updateRuleSetsStmt.setInt(10, rs.getConditionNumber());
            updateRuleSetsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateRuleSetsSQL, rs.getSet() + ", " + rs.getRuleNumber() + ", " + rs.getConditionNumber() + ", " + rs.getClassId() + ", " + rs.getFieldId() + ", " + rs.getOperation() + ", " + rs.getValue() + ", " + rs.getSet() + ", " + rs.getRuleNumber() + ", " + rs.getConditionNumber());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbRuleSets dbRuleSets = new DbRuleSets();
        dbRuleSets.testDbRuleSets(db);
        db.closeConnection();
    }

    private void testDbRuleSets(DatabaseBean db)
    {
        Connection conn = db.getConnection();
        RuleSets ra = new RuleSets();
        ra.setClassId(222);
        ra.setConditionNumber(333);
        ra.setFieldId(444);
        ra.setOperation(111);
        ra.setRuleNumber(555);
        ra.setSet("Monica Set");
        ra.setValue("Monica Set Description");
        try
        {
            save(conn, ra);
            System.out.println("Monica rule set saved!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while saving Monica's set");
        }
        RuleSets ra1 = null;
        try
        {
            ra1 = fetch(conn);
            System.out.println("Monica rule set fetched!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while fetching Monica's rule set");
        }
        if(ra1 == null)
            System.out.println("Monica's rule set does not exist in the db");
        else
            System.out.println(ra1);
        ra.setValue("Monica Updated Set Description");
        try
        {
            update(conn, ra);
            System.out.println("Monica rule set updated!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while upadating Monica's rule set");
        }
        try
        {
            remove(conn, ra);
            System.out.println("Monica rule set removed!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while removing Monica's rule set");
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbRuleSets.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String RULE_SET;
    private String fetchOrderedByRuleNbrCondtionNbrSQL;
    private String saveRuleSetsSQL;
    private String removeRuleSetsSQL;
    private String updateRuleSetsSQL;
    private PreparedStatement fetchOrderedByRuleAndCondNbrsStmt;
    private PreparedStatement saveRuleSetsStmt;
    private PreparedStatement removeRuleSetsStmt;
    private PreparedStatement updateRuleSetsStmt;
}
