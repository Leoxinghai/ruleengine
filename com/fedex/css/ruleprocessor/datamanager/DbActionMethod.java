// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbActionMethod.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.ActionMethod;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbActionMethod extends DbBase
{

    public DbActionMethod()
    {
        ActionMethodTableColumnNames = "FACTORY_ACTION_TYPE_NBR, ACTION_METHOD_NBR, ACTION_METHOD_NM ";
        fetchActionMethodByClassIDSQL = "SELECT " + ActionMethodTableColumnNames + "FROM ACTION_METHOD WHERE FACTORY_ACTION_TYPE_NBR = ? ";
        fetchActionMethodOrderedSQL = "SELECT " + ActionMethodTableColumnNames + "FROM ACTION_METHOD ORDER BY FACTORY_ACTION_TYPE_NBR";
        fetchActionMethodByClassIDStmt = null;
        fetchActionMethodOrderedStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchActionMethodByClassIDStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            fetchActionMethodOrderedStmt.close();
        }
        catch(Exception exception1) { }
    }

    public ActionMethod fetch(Connection connection)
        throws SQLException
    {
        try
        {
            fetchActionMethodOrderedStmt = connection.prepareStatement(fetchActionMethodOrderedSQL);
            runQuery(fetchActionMethodOrderedStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbActionMethod.fetch(conn)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbActionMethod.fetch(conn)");
        return fetchNext();
    }

    public ActionMethod fetch(Connection connection, int i)
        throws SQLException
    {
        try
        {
            if(fetchActionMethodByClassIDStmt != null)
                fetchActionMethodByClassIDStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbActionMethod.ftech() - unable to close statement");
        }
        try
        {
            fetchActionMethodByClassIDStmt = connection.prepareStatement(fetchActionMethodByClassIDSQL);
            fetchActionMethodByClassIDStmt.setInt(1, i);
            runQuery(fetchActionMethodByClassIDStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbActionMethod.fetch(conn, classID)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbActionMethod.fetch(conn,classID)");
        return fetchNext();
    }

    public ActionMethod fetchNext()
        throws SQLException
    {
        ActionMethod actionmethod = new ActionMethod();
        try
        {
            if(m_hasMore)
            {
                actionmethod.setClassID(m_resultSet.getInt(1));
                actionmethod.setMethodID(m_resultSet.getInt(2));
                actionmethod.setMethodName(m_resultSet.getString(3));
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
                actionmethod = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbActionMethod.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbActionMethod.fetchNext()");
        return actionmethod;
    }

    private String ActionMethodTableColumnNames;
    private String fetchActionMethodByClassIDSQL;
    private String fetchActionMethodOrderedSQL;
    private PreparedStatement fetchActionMethodByClassIDStmt;
    private PreparedStatement fetchActionMethodOrderedStmt;
}
