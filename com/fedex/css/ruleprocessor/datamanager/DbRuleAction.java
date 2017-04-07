// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRuleAction.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.RuleAction;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbRuleAction extends DbBase
{

    public DbRuleAction()
    {
        RuleActionTableColumnNames = "SET_NM, RULE_NBR, STEP_NBR, FACTORY_ACTION_TYPE_NBR, ACTION_METHOD_NBR, PC_CLASS_ID_NBR,PC_FIELD_ID_NBR, VALUE_DESC ";
        fetchOrderedByRuleNbrStepNbrSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION ORDER BY SET_NM, RULE_NBR, STEP_NBR";
        fetchRuleActionByPrimaryKeysSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION WHERE SET_NM = ? " + "AND RULE_NBR = ? AND STEP_NBR = ? ";
        fetchByRuleNbrAndSetNameSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION WHERE RULE_NBR = ? AND SET_NM = ? " + "ORDER BY RULE_NBR, STEP_NBR";
        saveRuleActionSQL = "INSERT INTO RULE_ACTION ( " + RuleActionTableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?)";
        updateRuleActionSQL = "UPDATE RULE_ACTION SET FACTORY_ACTION_TYPE_NBR = ?, ACTION_METHOD_NBR = ? WHERE SET_NM = ? AND RULE_NBR = ? AND STEP_NBR = ? ";
        removeRuleActionSQL = "DELETE FROM RULE_ACTION WHERE SET_NM = ? AND RULE_NBR = ? AND STEP_NBR = ?";
        fetchRuleActionByPrimaryKeysStmt = null;
        fetchOrderedByRuleNbrStepNbrStmt = null;
        fetchByRuleNbrAndSetNameStmt = null;
        saveRuleActionStmt = null;
        updateRuleActionStmt = null;
        removeRuleActionStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchRuleActionByPrimaryKeysStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            fetchOrderedByRuleNbrStepNbrStmt.close();
        }
        catch(Exception exception1) { }
        try
        {
            fetchByRuleNbrAndSetNameStmt.close();
        }
        catch(Exception exception2) { }
        try
        {
            saveRuleActionStmt.close();
        }
        catch(Exception exception3) { }
        try
        {
            updateRuleActionStmt.close();
        }
        catch(Exception exception4) { }
        try
        {
            removeRuleActionStmt.close();
        }
        catch(Exception exception5) { }
    }

    private DbRuleAction(Connection connection)
        throws SQLException
    {
        RuleActionTableColumnNames = "SET_NM, RULE_NBR, STEP_NBR, FACTORY_ACTION_TYPE_NBR, ACTION_METHOD_NBR, PC_CLASS_ID_NBR,PC_FIELD_ID_NBR, VALUE_DESC ";
        fetchOrderedByRuleNbrStepNbrSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION ORDER BY SET_NM, RULE_NBR, STEP_NBR";
        fetchRuleActionByPrimaryKeysSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION WHERE SET_NM = ? " + "AND RULE_NBR = ? AND STEP_NBR = ? ";
        fetchByRuleNbrAndSetNameSQL = "SELECT " + RuleActionTableColumnNames + "FROM RULE_ACTION WHERE RULE_NBR = ? AND SET_NM = ? " + "ORDER BY RULE_NBR, STEP_NBR";
        saveRuleActionSQL = "INSERT INTO RULE_ACTION ( " + RuleActionTableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?)";
        updateRuleActionSQL = "UPDATE RULE_ACTION SET FACTORY_ACTION_TYPE_NBR = ?, ACTION_METHOD_NBR = ? WHERE SET_NM = ? AND RULE_NBR = ? AND STEP_NBR = ? ";
        removeRuleActionSQL = "DELETE FROM RULE_ACTION WHERE SET_NM = ? AND RULE_NBR = ? AND STEP_NBR = ?";
        fetchRuleActionByPrimaryKeysStmt = null;
        fetchOrderedByRuleNbrStepNbrStmt = null;
        fetchByRuleNbrAndSetNameStmt = null;
        saveRuleActionStmt = null;
        updateRuleActionStmt = null;
        removeRuleActionStmt = null;
        try
        {
            fetchRuleActionByPrimaryKeysStmt = connection.prepareStatement(fetchRuleActionByPrimaryKeysSQL);
            fetchOrderedByRuleNbrStepNbrStmt = connection.prepareStatement(fetchOrderedByRuleNbrStepNbrSQL);
            fetchByRuleNbrAndSetNameStmt = connection.prepareStatement(fetchByRuleNbrAndSetNameSQL);
            saveRuleActionStmt = connection.prepareStatement(saveRuleActionSQL);
            updateRuleActionStmt = connection.prepareStatement(updateRuleActionSQL);
            removeRuleActionStmt = connection.prepareStatement(removeRuleActionSQL);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1410", "DbRuleAction constructor", "Failed to construct DbRuleAction: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction constructor");
    }

    public int getRuleActionRecordCount()
    {
        return m_recordCount;
    }

    public RuleAction fetch(Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchByRuleNbrAndSetNameStmt != null)
                fetchByRuleNbrAndSetNameStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.fetch() - unable to close statement");
        }
        try
        {
            fetchByRuleNbrAndSetNameStmt = connection.prepareStatement(fetchByRuleNbrAndSetNameSQL);
            runQuery(fetchByRuleNbrAndSetNameStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleAction.fetch(conn)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.fetch(conn)");
        return fetchNext();
    }

    public RuleAction fetch(int i, String s, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchByRuleNbrAndSetNameStmt != null)
                fetchByRuleNbrAndSetNameStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.fetch() - unable to close statement");
        }
        try
        {
            fetchByRuleNbrAndSetNameStmt = connection.prepareStatement(fetchByRuleNbrAndSetNameSQL);
            fetchByRuleNbrAndSetNameStmt.setInt(1, i);
            fetchByRuleNbrAndSetNameStmt.setString(2, s);
            runQuery(fetchByRuleNbrAndSetNameStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleAction.fetch(ruleNbr,setName)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.fetch(ruleNbr,setName)");
        return fetchNext();
    }

    public RuleAction fetch(String s, int i, int j, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchRuleActionByPrimaryKeysStmt != null)
                fetchRuleActionByPrimaryKeysStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.fetch() - unable to close statement");
        }
        try
        {
            fetchRuleActionByPrimaryKeysStmt = connection.prepareStatement(fetchRuleActionByPrimaryKeysSQL);
            fetchRuleActionByPrimaryKeysStmt.setString(1, s);
            fetchRuleActionByPrimaryKeysStmt.setInt(2, i);
            fetchRuleActionByPrimaryKeysStmt.setInt(3, j);
            runQuery(fetchRuleActionByPrimaryKeysStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleAction.fetch(setName,ruleNbr,stepNbr,conn)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.fetch(setName,ruleNbr,stepNbr,conn)");
        return fetchNext();
    }

    public RuleAction fetchNext()
        throws SQLException
    {
        RuleAction ruleaction = new RuleAction();
        try
        {
            if(m_hasMore)
            {
                ruleaction.setSetNm(m_resultSet.getString(1));
                ruleaction.setRuleNbr(m_resultSet.getInt(2));
                ruleaction.setStepNbr(m_resultSet.getInt(3));
                ruleaction.setFactoryActionTypeNbr(m_resultSet.getInt(4));
                ruleaction.setActionMethodNbr(m_resultSet.getInt(5));
                ruleaction.setPcClassIDNbr(m_resultSet.getInt(6));
                ruleaction.setPcFieldIDNbr(m_resultSet.getInt(7));
                ruleaction.setPcValue(m_resultSet.getString(8));
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
                ruleaction = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleAction.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.fetchNext()");
        return ruleaction;
    }

    public void save(RuleAction ruleaction, Connection connection)
        throws SQLException
    {
        try
        {
            if(saveRuleActionStmt != null)
                saveRuleActionStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.save() - unable to close statement");
        }
        try
        {
            saveRuleActionStmt = connection.prepareStatement(saveRuleActionSQL);
            saveRuleActionStmt.setString(1, ruleaction.getSetNm());
            saveRuleActionStmt.setInt(2, ruleaction.getRuleNbr());
            saveRuleActionStmt.setInt(3, ruleaction.getStepNbr());
            saveRuleActionStmt.setInt(4, ruleaction.getFactoryActionTypeNbr());
            saveRuleActionStmt.setInt(5, ruleaction.getActionMethodNbr());
            saveRuleActionStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbRuleAction.save()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.save()");
    }

    public void update(RuleAction ruleaction, Connection connection)
        throws SQLException
    {
        try
        {
            if(updateRuleActionStmt != null)
                updateRuleActionStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.update() - unable to close statement");
        }
        try
        {
            updateRuleActionStmt = connection.prepareStatement(updateRuleActionSQL);
            updateRuleActionStmt.setInt(1, ruleaction.getFactoryActionTypeNbr());
            updateRuleActionStmt.setInt(2, ruleaction.getActionMethodNbr());
            updateRuleActionStmt.setString(3, ruleaction.getSetNm());
            updateRuleActionStmt.setInt(4, ruleaction.getRuleNbr());
            updateRuleActionStmt.setInt(5, ruleaction.getStepNbr());
            updateRuleActionStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbRuleAction.update(ra)", "Failure in update for all non-keyed fields in the database: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.update()");
    }

    public void remove(RuleAction ruleaction, Connection connection)
        throws SQLException
    {
        try
        {
            if(removeRuleActionStmt != null)
                removeRuleActionStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleAction.remove() - unable to close statement");
        }
        try
        {
            removeRuleActionStmt = connection.prepareStatement(removeRuleActionSQL);
            removeRuleActionStmt.setString(1, ruleaction.getSetNm());
            removeRuleActionStmt.setInt(2, ruleaction.getRuleNbr());
            removeRuleActionStmt.setInt(3, ruleaction.getStepNbr());
            removeRuleActionStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1500", "DbRuleAction.remove(ra)", "Failed to delete RuleAction: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleAction.remove()");
    }

    private String RuleActionTableColumnNames;
    private String fetchOrderedByRuleNbrStepNbrSQL;
    private String fetchRuleActionByPrimaryKeysSQL;
    private String fetchByRuleNbrAndSetNameSQL;
    private String saveRuleActionSQL;
    private String updateRuleActionSQL;
    private String removeRuleActionSQL;
    private PreparedStatement fetchRuleActionByPrimaryKeysStmt;
    private PreparedStatement fetchOrderedByRuleNbrStepNbrStmt;
    private PreparedStatement fetchByRuleNbrAndSetNameStmt;
    private PreparedStatement saveRuleActionStmt;
    private PreparedStatement updateRuleActionStmt;
    private PreparedStatement removeRuleActionStmt;
}
