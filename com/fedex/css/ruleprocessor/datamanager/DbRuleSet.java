// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbRuleSet.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.RuleSet;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbRuleSet extends DbBase
{

    public DbRuleSet()
    {
        RuleSetTableColumnNames = "SET_NM, RULE_NBR, CONDITION_NBR, CLASS_ID_NBR, FIELD_ID_NBR, OPERATION_NBR, VALUE_DESC, COMPARE_CLASS_ID_NBR, COMPARE_FIELD_ID_NBR ";
        fetchRuleSetByPrimaryKeysSQL = "SELECT " + RuleSetTableColumnNames + "FROM RULE_SET WHERE SET_NM = ? " + "AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        fetchOrderedByRuleSetSQL = "SELECT " + RuleSetTableColumnNames + "FROM RULE_SET ORDER BY SET_NM, RULE_NBR, CONDITION_NBR";
        saveRuleSetSQL = "INSERT INTO RULE_SET ( " + RuleSetTableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?,?)";
        updateRuleSetSQL = "UPDATE RULE_SET SET CLASS_ID_NBR = ?, FIELD_ID_NBR = ?, OPERATION_NBR = ?, VALUE_DESC = ? WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        removeRuleSetSQL = "DELETE FROM RULE_SET WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ?";
        fetchRuleSetByPrimaryKeysStmt = null;
        fetchOrderedByRuleSetStmt = null;
        saveRuleSetStmt = null;
        updateRuleSetStmt = null;
        removeRuleSetStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchRuleSetByPrimaryKeysStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            fetchOrderedByRuleSetStmt.close();
        }
        catch(Exception exception1) { }
        try
        {
            saveRuleSetStmt.close();
        }
        catch(Exception exception2) { }
        try
        {
            updateRuleSetStmt.close();
        }
        catch(Exception exception3) { }
        try
        {
            removeRuleSetStmt.close();
        }
        catch(Exception exception4) { }
    }

    private DbRuleSet(Connection connection)
        throws SQLException
    {
        RuleSetTableColumnNames = "SET_NM, RULE_NBR, CONDITION_NBR, CLASS_ID_NBR, FIELD_ID_NBR, OPERATION_NBR, VALUE_DESC, COMPARE_CLASS_ID_NBR, COMPARE_FIELD_ID_NBR ";
        fetchRuleSetByPrimaryKeysSQL = "SELECT " + RuleSetTableColumnNames + "FROM RULE_SET WHERE SET_NM = ? " + "AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        fetchOrderedByRuleSetSQL = "SELECT " + RuleSetTableColumnNames + "FROM RULE_SET ORDER BY SET_NM, RULE_NBR, CONDITION_NBR";
        saveRuleSetSQL = "INSERT INTO RULE_SET ( " + RuleSetTableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?,?)";
        updateRuleSetSQL = "UPDATE RULE_SET SET CLASS_ID_NBR = ?, FIELD_ID_NBR = ?, OPERATION_NBR = ?, VALUE_DESC = ? WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        removeRuleSetSQL = "DELETE FROM RULE_SET WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ?";
        fetchRuleSetByPrimaryKeysStmt = null;
        fetchOrderedByRuleSetStmt = null;
        saveRuleSetStmt = null;
        updateRuleSetStmt = null;
        removeRuleSetStmt = null;
        try
        {
            fetchRuleSetByPrimaryKeysStmt = connection.prepareStatement(fetchRuleSetByPrimaryKeysSQL);
            fetchOrderedByRuleSetStmt = connection.prepareStatement(fetchOrderedByRuleSetSQL);
            saveRuleSetStmt = connection.prepareStatement(saveRuleSetSQL);
            updateRuleSetStmt = connection.prepareStatement(updateRuleSetSQL);
            removeRuleSetStmt = connection.prepareStatement(removeRuleSetSQL);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1410", "DbRuleSet constructor", "Failed to construct DBRuleSet: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet constructor");
    }

    public int getRuleSetRecordCount()
    {
        return m_recordCount;
    }

    public RuleSet fetch(Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchOrderedByRuleSetStmt != null)
                fetchOrderedByRuleSetStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleSet.fetch() - unable to close statement");
        }
        try
        {
            fetchOrderedByRuleSetStmt = connection.prepareStatement(fetchOrderedByRuleSetSQL);
            runQuery(fetchOrderedByRuleSetStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleSet.fetch()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.fetch()");
        return fetchNext();
    }

    public RuleSet fetch(String s, int i, int j, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchRuleSetByPrimaryKeysStmt != null)
                fetchRuleSetByPrimaryKeysStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleSet.fetch() - unable to close statement");
        }
        try
        {
            fetchRuleSetByPrimaryKeysStmt = connection.prepareStatement(fetchRuleSetByPrimaryKeysSQL);
            fetchRuleSetByPrimaryKeysStmt.setString(1, s);
            fetchRuleSetByPrimaryKeysStmt.setInt(2, i);
            fetchRuleSetByPrimaryKeysStmt.setInt(3, j);
            runQuery(fetchRuleSetByPrimaryKeysStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleSet.fetch(setName,ruleNbr,condNbr)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.fetch(setName,ruleNbr,condNbr)");
        return fetchNext();
    }

    public RuleSet fetchNext()
        throws SQLException
    {
        RuleSet ruleset = new RuleSet();
        try
        {
            if(m_hasMore)
            {
                ruleset.setSetNm(m_resultSet.getString(1));
                ruleset.setRuleNbr(m_resultSet.getInt(2));
                ruleset.setConditionNbr(m_resultSet.getInt(3));
                ruleset.setClassIdNbr(m_resultSet.getInt(4));
                ruleset.setFieldIdNbr(m_resultSet.getInt(5));
                ruleset.setOperationNbr(m_resultSet.getInt(6));
                ruleset.setValueDesc(m_resultSet.getString(7));
                ruleset.setCompClassIdNbr(m_resultSet.getInt(8));
                ruleset.setCompFieldIdNbr(m_resultSet.getInt(9));
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
                ruleset = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbRuleSet.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.fetchNext()");
        return ruleset;
    }

    public void save(RuleSet ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(saveRuleSetStmt != null)
                saveRuleSetStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleSet.save() - unable to close statement");
        }
        try
        {
            saveRuleSetStmt = connection.prepareStatement(saveRuleSetSQL);
            saveRuleSetStmt.setString(1, ruleset.getSetNm());
            saveRuleSetStmt.setInt(2, ruleset.getRuleNbr());
            saveRuleSetStmt.setInt(3, ruleset.getConditionNbr());
            saveRuleSetStmt.setInt(4, ruleset.getClassIdNbr());
            saveRuleSetStmt.setInt(5, ruleset.getFieldIdNbr());
            saveRuleSetStmt.setInt(6, ruleset.getOperationNbr());
            saveRuleSetStmt.setString(7, ruleset.getValueDesc());
            saveRuleSetStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbRuleSet.save(rs)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.save()");
    }

    public void update(RuleSet ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(updateRuleSetStmt != null)
                updateRuleSetStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleSet.update() - unable to close statement");
        }
        try
        {
            updateRuleSetStmt = connection.prepareStatement(updateRuleSetSQL);
            updateRuleSetStmt.setInt(1, ruleset.getClassIdNbr());
            updateRuleSetStmt.setInt(2, ruleset.getFieldIdNbr());
            updateRuleSetStmt.setInt(3, ruleset.getOperationNbr());
            updateRuleSetStmt.setString(4, ruleset.getValueDesc());
            updateRuleSetStmt.setString(5, ruleset.getSetNm());
            updateRuleSetStmt.setInt(6, ruleset.getRuleNbr());
            updateRuleSetStmt.setInt(7, ruleset.getConditionNbr());
            updateRuleSetStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbRuleSet.update(rs)", "Failure in update for all non-keyed fields in the database: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.update()");
    }

    public void remove(RuleSet ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(removeRuleSetStmt != null)
                removeRuleSetStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbRuleSet.remove() - unable to close statement");
        }
        try
        {
            removeRuleSetStmt = connection.prepareStatement(removeRuleSetSQL);
            removeRuleSetStmt.setString(1, ruleset.getSetNm());
            removeRuleSetStmt.setInt(2, ruleset.getRuleNbr());
            removeRuleSetStmt.setInt(3, ruleset.getConditionNbr());
            removeRuleSetStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1500", "DbRuleSet.remove(rs)", "Failed to delete RuleSet: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbRuleSet.remove()");
    }

    private String RuleSetTableColumnNames;
    private String fetchRuleSetByPrimaryKeysSQL;
    private String fetchOrderedByRuleSetSQL;
    private String saveRuleSetSQL;
    private String updateRuleSetSQL;
    private String removeRuleSetSQL;
    private PreparedStatement fetchRuleSetByPrimaryKeysStmt;
    private PreparedStatement fetchOrderedByRuleSetStmt;
    private PreparedStatement saveRuleSetStmt;
    private PreparedStatement updateRuleSetStmt;
    private PreparedStatement removeRuleSetStmt;
}
