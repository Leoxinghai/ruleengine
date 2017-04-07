// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRuleSetDef.java

package cciij.cciidatabase;

import cciij.cciidata.RuleSetDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbRuleSetDef extends DbBase
{

    public DbRuleSetDef()
    {
        RULE_SET_DEF = "RULE_SET_DEF ";
        saveRuleSetDefSQL = "INSERT INTO " + RULE_SET_DEF + " (STATE_ID_CD, " + "SET_NM, COMMENT_DESC) VALUES(?,?,?)";
        removeRuleSetDefSQL = "DELETE FROM " + RULE_SET_DEF + " WHERE STATE_ID_CD = ?";
        updateRuleSetDefSQL = "UPDATE " + RULE_SET_DEF + " SET " + "SET_NM = ?, COMMENT_DESC = ? " + "WHERE STATE_ID_CD = ?";
        saveRuleSetDefStmt = null;
        removeRuleSetDefStmt = null;
        updateRuleSetDefStmt = null;
    }

    public int getRuleSetDefRecordCount()
    {
        return m_recordCount;
    }

    public void save(Connection conn, RuleSetDef rsd)
        throws SQLException
    {
        try
        {
            saveRuleSetDefStmt = conn.prepareStatement(saveRuleSetDefSQL);
            saveRuleSetDefStmt.setString(1, rsd.getStateId());
            saveRuleSetDefStmt.setString(2, rsd.getSet());
            saveRuleSetDefStmt.setString(3, rsd.getComment());
            saveRuleSetDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveRuleSetDefSQL, rsd.getStateId() + ", " + rsd.getSet() + ", " + rsd.getComment());
            throw ex;
        }
    }

    public void remove(Connection conn, RuleSetDef rsd)
        throws SQLException
    {
        try
        {
            removeRuleSetDefStmt = conn.prepareStatement(removeRuleSetDefSQL);
            removeRuleSetDefStmt.setString(1, rsd.getStateId());
            removeRuleSetDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeRuleSetDefSQL, rsd.getStateId());
            throw ex;
        }
    }

    public void update(Connection conn, RuleSetDef rsd)
        throws SQLException
    {
        try
        {
            updateRuleSetDefStmt = conn.prepareStatement(updateRuleSetDefSQL);
            updateRuleSetDefStmt.setString(1, rsd.getSet());
            updateRuleSetDefStmt.setString(2, rsd.getComment());
            updateRuleSetDefStmt.setString(3, rsd.getStateId());
            updateRuleSetDefStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateRuleSetDefSQL, rsd.getSet() + ", " + rsd.getComment() + ", " + rsd.getStateId());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbRuleSetDef dbRuleSetDef = new DbRuleSetDef();
        dbRuleSetDef.testDbRuleSetDef(db);
        db.closeConnection();
    }

    private void testDbRuleSetDef(DatabaseBean db)
    {
        Connection conn = db.getConnection();
        RuleSetDef rsd = new RuleSetDef();
        rsd.setStateId("222");
        rsd.setSet("Monica set");
        rsd.setComment("Monica Comment");
        try
        {
            save(conn, rsd);
            System.out.println("Monica set inserted!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while saving Monica's rule set definition ");
        }
        rsd.setStateId("222");
        rsd.setSet("Monica set");
        rsd.setComment("Monica new Comment");
        try
        {
            update(conn, rsd);
            System.out.println("Monica set updated!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while upadating Monica's rule set definition");
        }
        try
        {
            remove(conn, rsd);
            System.out.println("Monica set removed!");
        }
        catch(SQLException ex)
        {
            System.out.println("Caught exception while removing Monica's rule set definition");
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbRuleSetDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String RULE_SET_DEF;
    private String saveRuleSetDefSQL;
    private String removeRuleSetDefSQL;
    private String updateRuleSetDefSQL;
    private PreparedStatement saveRuleSetDefStmt;
    private PreparedStatement removeRuleSetDefStmt;
    private PreparedStatement updateRuleSetDefStmt;
}
