/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;

import com.fedex.cih.vo.*;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbDeliveryAddress extends DbBase
{

    public DbDeliveryAddress()
    {
        TableColumnNames = "OID_NBR,OID_TYPE_CD,REF_COUNTRY_CD,DEST_LOC_CD,CONSIGNEE_CONTACT_NM,CONSIGNEE_COMPANY_NM,CONSIGNEE_ADDRESS1_DESC, ";
        fetchByPrimaryKeysSQL = "SELECT " + TableColumnNames + "FROM RULE_SET WHERE SET_NM = ? " + "AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        fetchOrderedBySQL = "SELECT " + TableColumnNames + "FROM RULE_SET ORDER BY SET_NM, RULE_NBR, CONDITION_NBR";
        saveSQL = "INSERT INTO RULE_SET ( " + TableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?,?)";
        updateSQL = "UPDATE RULE_SET SET CLASS_ID_NBR = ?, FIELD_ID_NBR = ?, OPERATION_NBR = ?, VALUE_DESC = ? WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        removeSQL = "DELETE FROM RULE_SET WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ?";
        fetchByPrimaryKeysStmt = null;
        fetchOrderedByStmt = null;
        saveStmt = null;
        updateStmt = null;
        removeStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchByPrimaryKeysStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            fetchOrderedByStmt.close();
        }
        catch(Exception exception1) { }
        try
        {
            saveStmt.close();
        }
        catch(Exception exception2) { }
        try
        {
            updateStmt.close();
        }
        catch(Exception exception3) { }
        try
        {
            removeStmt.close();
        }
        catch(Exception exception4) { }
    }

    private DbDeliveryAddress(Connection connection)
        throws SQLException
    {
        TableColumnNames = "SET_NM, RULE_NBR, CONDITION_NBR, CLASS_ID_NBR, FIELD_ID_NBR, OPERATION_NBR, VALUE_DESC, COMPARE_CLASS_ID_NBR, COMPARE_FIELD_ID_NBR ";
        fetchByPrimaryKeysSQL = "SELECT " + TableColumnNames + "FROM RULE_SET WHERE SET_NM = ? " + "AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        fetchOrderedBySQL = "SELECT " + TableColumnNames + "FROM RULE_SET ORDER BY SET_NM, RULE_NBR, CONDITION_NBR";
        saveSQL = "INSERT INTO RULE_SET ( " + TableColumnNames + " ) VALUES (?,?,?,?,?,?,?,?,?)";
        updateSQL = "UPDATE RULE_SET SET CLASS_ID_NBR = ?, FIELD_ID_NBR = ?, OPERATION_NBR = ?, VALUE_DESC = ? WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ? ";
        removeSQL = "DELETE FROM RULE_SET WHERE SET_NM = ? AND RULE_NBR = ? AND CONDITION_NBR = ?";
        fetchByPrimaryKeysStmt = null;
        fetchOrderedByStmt = null;
        saveStmt = null;
        updateStmt = null;
        removeStmt = null;
        try
        {
            fetchByPrimaryKeysStmt = connection.prepareStatement(fetchByPrimaryKeysSQL);
            fetchOrderedByStmt = connection.prepareStatement(fetchOrderedBySQL);
            saveStmt = connection.prepareStatement(saveSQL);
            updateStmt = connection.prepareStatement(updateSQL);
            removeStmt = connection.prepareStatement(removeSQL);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1410", "Db constructor", "Failed to construct DB: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db constructor");
    }

    public int getRecordCount()
    {
        return m_recordCount;
    }

    public DeliveryAddressInfo fetch(int oidNbr, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchByPrimaryKeysStmt != null)
                fetchByPrimaryKeysStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "Db.fetch() - unable to close statement");
        }
        try
        {
            fetchByPrimaryKeysStmt = connection.prepareStatement(fetchByPrimaryKeysSQL);
            fetchByPrimaryKeysStmt.setInt(1, oidNbr);
            runQuery(fetchByPrimaryKeysStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "Db.fetch(setName,ruleNbr,condNbr)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db.fetch(setName,ruleNbr,condNbr)");
        return fetchNext();
    }

    public DeliveryAddressInfo fetchNext()
        throws SQLException
    {
    	DeliveryAddressInfo ruleset = new DeliveryAddressInfo();
        try
        {
            if(m_hasMore)
            {
/*                ruleset.setSetNm(m_resultSet.getString(1));
                ruleset.setRuleNbr(m_resultSet.getInt(2));
                ruleset.setConditionNbr(m_resultSet.getInt(3));
                ruleset.setClassIdNbr(m_resultSet.getInt(4));
                ruleset.setFieldIdNbr(m_resultSet.getInt(5));
                ruleset.setOperationNbr(m_resultSet.getInt(6));
                ruleset.setValueDesc(m_resultSet.getString(7));
                ruleset.setCompClassIdNbr(m_resultSet.getInt(8));
                ruleset.setCompFieldIdNbr(m_resultSet.getInt(9));
*/               
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
            trace.trace(4, "1200", "Db.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db.fetchNext()");
        return ruleset;
    }

    public void save( DeliveryAddressInfo ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(saveStmt != null)
                saveStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "Db.save() - unable to close statement");
        }
        try
        {
            saveStmt = connection.prepareStatement(saveSQL);
            /*
            saveStmt.setString(1, ruleset.getSetNm());
            saveStmt.setInt(2, ruleset.getRuleNbr());
            saveStmt.setInt(3, ruleset.getConditionNbr());
            saveStmt.setInt(4, ruleset.getClassIdNbr());
            saveStmt.setInt(5, ruleset.getFieldIdNbr());
            saveStmt.setInt(6, ruleset.getOperationNbr());
            saveStmt.setString(7, ruleset.getValueDesc());
            */
            saveStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "Db.save(rs)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db.save()");
    }

    public void update( DeliveryAddressInfo ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(updateStmt != null)
                updateStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "Db.update() - unable to close statement");
        }
        try
        {
        	/*
            updateStmt = connection.prepareStatement(updateSQL);
            updateStmt.setInt(1, ruleset.getClassIdNbr());
            updateStmt.setInt(2, ruleset.getFieldIdNbr());
            updateStmt.setInt(3, ruleset.getOperationNbr());
            updateStmt.setString(4, ruleset.getValueDesc());
            updateStmt.setString(5, ruleset.getSetNm());
            updateStmt.setInt(6, ruleset.getRuleNbr());
            updateStmt.setInt(7, ruleset.getConditionNbr());
            */
            updateStmt.executeUpdate();
            
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "Db.update(rs)", "Failure in update for all non-keyed fields in the database: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db.update()");
    }

    public void remove( DeliveryAddressInfo ruleset, Connection connection)
        throws SQLException
    {
        try
        {
            if(removeStmt != null)
                removeStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "Db.remove() - unable to close statement");
        }
        try
        {
      /*      removeStmt = connection.prepareStatement(removeSQL);
            removeStmt.setString(1, ruleset.getSetNm());
            removeStmt.setInt(2, ruleset.getRuleNbr());
            removeStmt.setInt(3, ruleset.getConditionNbr());
        */
        	removeStmt.executeUpdate();
        
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1500", "Db.remove(rs)", "Failed to delete : " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  Db.remove()");
    }

    private String TableColumnNames;
    private String fetchByPrimaryKeysSQL;
    private String fetchOrderedBySQL;
    private String saveSQL;
    private String updateSQL;
    private String removeSQL;
    private PreparedStatement fetchByPrimaryKeysStmt;
    private PreparedStatement fetchOrderedByStmt;
    private PreparedStatement saveStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement removeStmt;
}
