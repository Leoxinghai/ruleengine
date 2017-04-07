// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbEntry.java

package cciij.cciidatabase;

import cciij.cciidata.Entry;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbEntry extends DbBase
{

    public DbEntry()
    {
        ORACLE_PRIMARY_KEY_EXISTS = 1;
        columnNames = " E.ENTRY_CATEGORY_TYPE_CD, E.ROUTE_LEG_OID_NBR, E.ENTRY_NBR, E.BROKER_FILE_NBR ";
        tableName = " ENT.ENTRY E ";
        fetchBaseSQL = "SELECT " + columnNames + " FROM " + tableName + " WHERE ";
        FetchEntryBaseSQL = fetchBaseSQL + " E.ENTRY_CATEGORY_TYPE_CD = ? " + " AND E.ROUTE_LEG_OID_NBR = ? ";
        insertEntryBaseSQL = "INSERT INTO " + tableName + " ( " + columnNames + " )" + " VALUES ( ?, ?, ?, ? )";
        updateEntryBaseSQL = "UPDATE " + tableName + " SET " + " E.ENTRY_NBR = ?, " + " E.BROKER_FILE_NBR = ? " + "WHERE E.ENTRY_CATEGORY_TYPE_CD = ? " + "  AND E.ROUTE_LEG_OID_NBR = ? ";
        fetchEntryBaseStatement = null;
        insertEntryBaseStatement = null;
        updateEntryBaseStatement = null;
    }

    public Entry fetch(String entryTypeCode, int routeLegOid, Connection conn)
        throws SQLException
    {
        try
        {
            fetchEntryBaseStatement = conn.prepareStatement(FetchEntryBaseSQL);
            fetchEntryBaseStatement.setString(1, entryTypeCode);
            fetchEntryBaseStatement.setInt(2, routeLegOid);
            runQuery(fetchEntryBaseStatement);
        }
        catch(SQLException ex)
        {
            String paramList = entryTypeCode + ", " + routeLegOid;
            printSQLException(ex, getClass().getName(), "fetch", FetchEntryBaseSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public void saveEntry(Entry entry, Connection conn)
        throws SQLException
    {
        try
        {
            insertEntryBaseStatement = conn.prepareStatement(insertEntryBaseSQL);
            insertEntryBaseStatement.setString(1, entry.getEntryCategoryTypeCd());
            insertEntryBaseStatement.setInt(2, entry.getRouteLegOidNbr());
            insertEntryBaseStatement.setString(3, entry.getEntryNbr());
            insertEntryBaseStatement.setInt(4, entry.getBrokerFileNbr());
            saveToDatabase(insertEntryBaseStatement);
        }
        catch(SQLException sqlEx)
        {
            printSQLException(sqlEx, getClass().getName(), "save", insertEntryBaseSQL, entry.getEntryCategoryTypeCd() + ", " + entry.getRouteLegOidNbr() + ", " + entry.getEntryNbr() + ", " + entry.getBrokerFileNbr());
            throw sqlEx;
        }
    }

    public Entry fetchNext()
        throws SQLException
    {
        Entry entry = new Entry();
        if(m_hasMore)
        {
            entry.setEntryCategoryTypeCd(m_resultSet.getString("ENTRY_CATEGORY_TYPE_CD"));
            entry.setRouteLegOidNbr(m_resultSet.getInt("ROUTE_LEG_OID_NBR"));
            entry.setEntryNbr(m_resultSet.getString("ENTRY_NBR"));
            entry.setBrokerFileNbr(m_resultSet.getInt("BROKER_FILE_NBR"));
            try
            {
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            }
            catch(SQLException e)
            {
                printSQLException(e, getClass().getName(), "fetchNext", "", "");
                throw e;
            }
        } else
        {
            entry = null;
            m_recordCount = 0;
        }
        return entry;
    }

    public static boolean dbTest(DatabaseBean db)
        throws Exception
    {
        boolean dbResult = false;
        Entry entry1 = new Entry();
        try
        {
            System.out.println(".begin test case");
            entry1.setEntryCategoryTypeCd("TST");
            entry1.setRouteLegOidNbr(0x49400);
            entry1.setEntryNbr("AABBCC");
            entry1.setBrokerFileNbr(0x30d55);
            System.out.println("...save first");
            db.saveEntry(entry1);
            System.out.println("....returned from save");
            System.out.println(".....fetch it back");
            Entry entry2 = db.fetchEntry("TST", 0x49400);
            System.out.println("......Results of fetch() " + entry2);
            dbResult = true;
        }
        catch(SQLException ex)
        {
            System.out.println("Entry Db test Case failed " + ex);
            ex.printStackTrace(System.out);
        }
        return dbResult;
    }

    public static void main(String args[])
    {
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            dbTest(db);
            db.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("DbEntry.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbEntry.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    protected int ORACLE_PRIMARY_KEY_EXISTS;
    private String columnNames;
    private String tableName;
    private String fetchBaseSQL;
    private String FetchEntryBaseSQL;
    private String insertEntryBaseSQL;
    private String updateEntryBaseSQL;
    private PreparedStatement fetchEntryBaseStatement;
    private PreparedStatement insertEntryBaseStatement;
    private PreparedStatement updateEntryBaseStatement;
}
