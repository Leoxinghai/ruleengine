// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbBusinessActionEntry.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.BusinessActionEntry;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbBusinessActionEntry extends DbBase
{

    public DbBusinessActionEntry()
    {
        BusinessActionTableColumnNames = "ACTION_FACTORY_NBR, OBJECT_CLASS_NM, CONSTRUCTOR_PARAM_NM ";
        fetchBusinessActionSQL = "SELECT " + BusinessActionTableColumnNames + "FROM BUSINESS_ACTION";
        fetchBusinessActionStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchBusinessActionStmt.close();
        }
        catch(Exception exception) { }
    }

    public BusinessActionEntry fetch(Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchBusinessActionStmt != null)
                fetchBusinessActionStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbBusinessActionEntry.fetch() - unable to close statement");
        }
        try
        {
            fetchBusinessActionStmt = connection.prepareStatement(fetchBusinessActionSQL);
            runQuery(fetchBusinessActionStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1410", "DbBusinessActionEntry.fetch", "Failed to fetch: " + sqlexception);
            throw sqlexception;
        }
        return fetchNext();
    }

    public BusinessActionEntry fetchNext()
        throws SQLException
    {
        BusinessActionEntry businessactionentry = new BusinessActionEntry();
        try
        {
            if(m_hasMore)
            {
                businessactionentry.setActionID(m_resultSet.getInt(1));
                businessactionentry.setClassName(m_resultSet.getString(2));
                businessactionentry.setConstructorArg(m_resultSet.getString(3));
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
                businessactionentry = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbBusinessActionEntry.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbBusinessActionEntry.fetchNext()");
        return businessactionentry;
    }

    public int getBusinessActionEntryRecordCount()
    {
        return m_recordCount;
    }

    private String BusinessActionTableColumnNames;
    private String fetchBusinessActionSQL;
    private PreparedStatement fetchBusinessActionStmt;
}
