// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRuleActions.java

package cciij.cciidatabase;

import cciij.cciidata.RuleActions;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbRuleActions extends DbBase
{

    public DbRuleActions()
    {
        RULE_ACTION = "RULE_ACTION ";
        fetchByRuleNbrSQL = "SELECT SET_NM, RULE_NBR, STEP_NBR, FACTORY_ACTION_TYPE_NBR, ACTION_METHOD_NBR FROM " + RULE_ACTION + "WHERE RULE_NBR = ? AND SET_NM = ? " + "ORDER BY RULE_NBR, STEP_NBR";
        saveRuleActionsSQL = "INSERT INTO " + RULE_ACTION + "(SET_NM, RULE_NBR, " + "STEP_NBR, FACTORY_ACTION_TYPE_NBR, ACTION_METHOD_NBR) " + "VALUES(?,?,?,?,?)";
        removeRuleActionsSQL = "DELETE FROM " + RULE_ACTION + "WHERE SET_NM = ? AND RULE_NBR = ? AND " + "STEP_NBR = ?";
        updateRuleActionsSQL = "UPDATE " + RULE_ACTION + "SET " + "SET_NM = ?, RULE_NBR = ?, " + "STEP_NBR = ?, FACTORY_ACTION_TYPE_NBR = ?, ACTION_METHOD_NBR = ? " + "WHERE SET_NM = ? AND RULE_NBR = ? AND " + "STEP_NBR = ?";
        fetchByRuleNbrStmt = null;
        saveRuleActionsStmt = null;
        removeRuleActionsStmt = null;
        updateRuleActionsStmt = null;
    }

    public int getRuleActionsRecordCount()
    {
        return m_recordCount;
    }

    public RuleActions fetch(Connection conn, int ruleNbr, String setName)
        throws SQLException
    {
        try
        {
            fetchByRuleNbrStmt = conn.prepareStatement(fetchByRuleNbrSQL);
            fetchByRuleNbrStmt.setInt(1, ruleNbr);
            fetchByRuleNbrStmt.setString(2, setName);
            runQuery(fetchByRuleNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchByRuleNbrSQL, ruleNbr + ", " + setName);
            throw ex;
        }
        return fetchNext();
    }

    public RuleActions fetchNext()
        throws SQLException
    {
        RuleActions ruleActions = new RuleActions();
        try
        {
            if(m_hasMore)
            {
                ruleActions.setSet(m_resultSet.getString(1));
                ruleActions.setRuleNumber(m_resultSet.getInt(2));
                ruleActions.setStepNumber(m_resultSet.getInt(3));
                ruleActions.setActionFactoryType(m_resultSet.getInt(4));
                ruleActions.setActionMethod(m_resultSet.getInt(5));
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
                ruleActions = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "", "");
            throw ex;
        }
        return ruleActions;
    }

    public void save(Connection conn, RuleActions ra)
        throws SQLException
    {
        try
        {
            saveRuleActionsStmt = conn.prepareStatement(saveRuleActionsSQL);
            saveRuleActionsStmt.setString(1, ra.getSet());
            saveRuleActionsStmt.setInt(2, ra.getRuleNumber());
            saveRuleActionsStmt.setInt(3, ra.getStepNumber());
            saveRuleActionsStmt.setInt(4, ra.getActionFactoryType());
            saveRuleActionsStmt.setInt(5, ra.getActionMethod());
            saveRuleActionsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveRuleActionsSQL, ra.getSet() + ", " + ra.getRuleNumber() + ", " + ra.getStepNumber() + ", " + ra.getActionFactoryType() + ", " + ra.getActionMethod());
            throw ex;
        }
    }

    public void remove(Connection conn, RuleActions ra)
        throws SQLException
    {
        try
        {
            removeRuleActionsStmt = conn.prepareStatement(removeRuleActionsSQL);
            removeRuleActionsStmt.setString(1, ra.getSet());
            removeRuleActionsStmt.setInt(2, ra.getRuleNumber());
            removeRuleActionsStmt.setInt(3, ra.getStepNumber());
            removeRuleActionsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeRuleActionsSQL, ra.getSet() + ", " + ra.getRuleNumber() + ", " + ra.getStepNumber());
            throw ex;
        }
    }

    public void update(Connection conn, RuleActions ra)
        throws SQLException
    {
        try
        {
            updateRuleActionsStmt = conn.prepareStatement(updateRuleActionsSQL);
            updateRuleActionsStmt.setString(1, ra.getSet());
            updateRuleActionsStmt.setInt(2, ra.getRuleNumber());
            updateRuleActionsStmt.setInt(3, ra.getStepNumber());
            updateRuleActionsStmt.setInt(4, ra.getActionFactoryType());
            updateRuleActionsStmt.setInt(5, ra.getActionMethod());
            updateRuleActionsStmt.setString(6, ra.getSet());
            updateRuleActionsStmt.setInt(7, ra.getRuleNumber());
            updateRuleActionsStmt.setInt(8, ra.getStepNumber());
            updateRuleActionsStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateRuleActionsSQL, ra.getSet() + ", " + ra.getRuleNumber() + ", " + ra.getStepNumber() + ", " + ra.getActionFactoryType() + ", " + ra.getActionMethod() + ", " + ra.getSet() + ", " + ra.getRuleNumber() + ", " + ra.getStepNumber());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbRuleActions dbRuleActions = new DbRuleActions();
        dbRuleActions.testDbRuleActions(db);
        db.closeConnection();
    }

    private void testDbRuleActions(DatabaseBean db)
    {
        Connection conn = db.getConnection();
        RuleActions ra = new RuleActions();
        ra.setActionFactoryType(222);
        ra.setActionMethod(333);
        ra.setRuleNumber(444);
        ra.setSet("Monica's set");
        ra.setStepNumber(555);
        try
        {
            save(conn, ra);
            System.out.println("Monica rule Action saved!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while saving Monica's ruleAction");
        }
        RuleActions ra1 = null;
        try
        {
            ra1 = fetch(conn, 444, "Monica's set");
            System.out.println("Monica rule Action fetched!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while fetching Monica's set");
        }
        if(ra1 == null)
            System.out.println("Monica's set does not exist in the db");
        else
            System.out.println(ra1);
        ra = new RuleActions();
        ra.setActionFactoryType(111);
        ra.setActionMethod(333);
        ra.setRuleNumber(444);
        ra.setSet("Monica's set");
        ra.setStepNumber(555);
        try
        {
            update(conn, ra);
            System.out.println("Monica rule Action updated!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while upadating Monica's set");
        }
        try
        {
            ra1 = fetch(conn, 444, "Monica's set");
            System.out.println("Monica rule Action fetched!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while fetching Monica's set");
        }
        if(ra1 == null)
            System.out.println("Monica's set does not exist in the db");
        else
            System.out.println(ra1);
        try
        {
            remove(conn, ra);
            System.out.println("Monica rule Action removed!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while removing Monica's set");
        }
        try
        {
            ra1 = fetch(conn, 444, "Monica's set");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while fetching Monica's set");
        }
        if(ra1 == null)
            System.out.println("Monica's set does not exist in the db");
        else
            System.out.println(ra1);
    }

    private String RULE_ACTION;
    private static final String m_whatVersion = "@(#) $RCSfile: DbRuleActions.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchByRuleNbrSQL;
    private String saveRuleActionsSQL;
    private String removeRuleActionsSQL;
    private String updateRuleActionsSQL;
    private PreparedStatement fetchByRuleNbrStmt;
    private PreparedStatement saveRuleActionsStmt;
    private PreparedStatement removeRuleActionsStmt;
    private PreparedStatement updateRuleActionsStmt;
}
