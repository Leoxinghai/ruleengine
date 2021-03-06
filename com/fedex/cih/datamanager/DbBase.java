/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;

import com.fedex.css.util.Trace;
import java.sql.*;

public class DbBase
{

    public DbBase()
    {
        m_resultSet = null;
        m_recordCount = -1;
        m_hasMore = false;
        trace = new Trace();
    }

    protected void finalize()
    {
        try
        {
            m_resultSet.close();
        }
        catch(Exception exception) { }
    }

    public ResultSetMetaData getMetaData()
        throws SQLException
    {
        ResultSetMetaData resultsetmetadata = null;
        try
        {
            if(m_resultSet != null)
                resultsetmetadata = m_resultSet.getMetaData();
            else
                resultsetmetadata = null;
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1420", "getMetaData()", "Exception thrown:" + sqlexception);
        }
        trace.trace(16, "SUCCESS  getMetaData()");
        return resultsetmetadata;
    }

    protected void checkReturnStatusFromResultSet()
        throws SQLException
    {
        try
        {
            if(m_resultSet.next())
                m_hasMore = true;
            else
                m_hasMore = false;
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "checkReturnStatusFromResultSet()", "m_resultSet.next() failed: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  checkReturnStatusFromResultSet()");
    }

    protected void runQuery(PreparedStatement preparedstatement)
        throws SQLException
    {
        if(m_resultSet != null)
            m_resultSet.close();
        m_resultSet = preparedstatement.executeQuery();
        checkReturnStatusFromResultSet();
        m_resultSet.clearWarnings();
        preparedstatement.clearWarnings();
    }

    protected Trace trace;
    protected ResultSet m_resultSet;
    protected int m_recordCount;
    protected boolean m_hasMore;
}
