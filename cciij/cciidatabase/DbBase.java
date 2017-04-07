// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbBase.java

package cciij.cciidatabase;

import cciij.util.Notify;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import rmtc.util.Config;

public class DbBase
{

    public DbBase()
    {
        m_resultSet = null;
        m_recordCount = -1;
        m_hasMore = false;
        m_locationCd = "";
    }

    public Date convertTimestampToDate(Timestamp tmstmp)
    {
        Date returnDate = null;
        if(tmstmp != null)
            returnDate = new Date(tmstmp.getTime());
        else
            returnDate = new Date(m_defaultDate.getTime());
        return returnDate;
    }

    public ResultSetMetaData getMetaData()
        throws SQLException
    {
        ResultSetMetaData rsmd;
        try
        {
            if(m_resultSet != null)
                rsmd = m_resultSet.getMetaData();
            else
                rsmd = null;
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR in DbHandlingUnit getMetaData: " + ex);
            throw ex;
        }
        return rsmd;
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
        catch(SQLException ex)
        {
            System.out.println("ERROR from DbHandlingUnit checkReturnStatusFromResultSet() " + ex);
            throw ex;
        }
    }

    protected void setLocationCd(String locationCd)
    {
        m_locationCd = locationCd;
    }

    protected String getLocationCd()
    {
        return m_locationCd;
    }

    protected void runQuery(PreparedStatement preparedSQL)
        throws SQLException
    {
        if(m_resultSet != null)
            m_resultSet.close();
        m_resultSet = preparedSQL.executeQuery();
        checkReturnStatusFromResultSet();
        m_resultSet.clearWarnings();
        preparedSQL.clearWarnings();
    }

    protected void updateDatabase(PreparedStatement preparedSQL)
        throws SQLException
    {
        try
        {
            preparedSQL.executeUpdate();
            preparedSQL.clearWarnings();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR Database update: " + ex);
            throw ex;
        }
    }

    protected void saveToDatabase(PreparedStatement preparedSQL)
        throws SQLException
    {
        try
        {
            preparedSQL.executeUpdate();
            preparedSQL.clearWarnings();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR Database save: " + ex);
            throw ex;
        }
    }

    protected void deleteFromDatabase(PreparedStatement preparedSQL)
        throws SQLException
    {
        try
        {
            preparedSQL.executeUpdate();
            preparedSQL.clearWarnings();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR Database delete: " + ex);
            throw ex;
        }
    }

    protected void printSQLException(SQLException ex, String className, String methodName, String sqlString, String substitutionValues)
    {
        m_notify = new Notify(getClass().getName());
        String errMessage = formatErrMsg(ex, className, methodName, sqlString, substitutionValues);
        m_notify.triggerNotify(errMessage, ex);
    }

    private String formatErrMsg(SQLException ex, String className, String methodName, String sqlString, String substitutionValues)
    {
        m_config = new Config();
        m_simpleDateFormatStr = m_config.getValue("ERROR_MSG_SIMPLE_DATE_FORMAT");
        StringBuffer msg = new StringBuffer();
        m_simpDateFmt = new SimpleDateFormat(m_simpleDateFormatStr);
        Date currentDtTm = new Date();
        msg.append("\n###########    Error Message      ###############\n");
        msg.append("Date:                " + m_simpDateFmt.format(currentDtTm) + "\n");
        msg.append("SQLException:        " + ex);
        msg.append("Class:               " + className + "   Method: " + methodName + "\n");
        msg.append("SQL String:          " + sqlString + "\n");
        msg.append("Substitution Values: " + substitutionValues + "\n");
        msg.append("Stack Trace:         " + getStackTrace(ex));
        msg.append("################################################\n");
        return msg.toString();
    }

    private String getStackTrace(SQLException e)
    {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        StringBuffer error = stringWriter.getBuffer();
        return error.toString();
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private static final Date m_defaultDate = new Date(0L);
    protected ResultSet m_resultSet;
    protected int m_recordCount;
    protected boolean m_hasMore;
    protected String m_locationCd;
    protected Notify m_notify;
    private static String m_simpleDateFormatStr;
    private static SimpleDateFormat m_simpDateFmt;
    private Config m_config;

}
