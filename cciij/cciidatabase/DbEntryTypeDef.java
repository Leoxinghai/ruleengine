// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbEntryTypeDef.java

package cciij.cciidatabase;

import cciij.cciidata.EntryTypeDefinition;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbEntryTypeDef extends DbBase
{

    public DbEntryTypeDef()
    {
        ORACLE_PRIMARY_KEY_EXISTS = 1;
        columnNames = " ED.ENTRY_TYPE_CD, ED.ENTRY_TYPE_DESC,  ED.HS_NEEDED_FLG, ED.ENTRY_NBR_NEEDED_FLG,  ED.MULTIPLE_ENTRY_FLG, ED.UPPER_ENTRY_VALUE_AMT,  ED.ENTRY_NBR, ED.CATEGORY_TYPE_CD ";
        tableName = " ACCS.ENTRY_TYPE_DEF ED ";
        fetchBaseSQL = "SELECT " + columnNames + " FROM " + tableName + " WHERE ";
        FetchEntryDefBaseSQL = fetchBaseSQL + " ED.ENTRY_TYPE_CD = ? ";
        insertEntryDefBaseSQL = "INSERT INTO " + tableName + " ( " + columnNames + " )" + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
        updateEntryDefBaseSQL = "UPDATE " + tableName + " SET " + " ED.ENTRY_TYPE_DESC = ?, " + " ED.HS_NEEDED_FLG = ?, " + " ED.ENTRY_NBR_NEEDED_FLG = ?, " + " ED.MULTIPLE_ENTRY_FLG = ?, " + " ED.UPPER_ENTRY_VALUE_AMT = ?, " + " ED.ENTRY_NBR = ?, " + " ED.CATEGORY_TYPE_CD = ? " + "WHERE ED.ENTRY_TYPE_CD = ? ";
        fetchEntryDefBaseStatement = null;
        insertEntryDefBaseStatement = null;
        updateEntryDefBaseStatement = null;
    }

    public EntryTypeDefinition fetch(String entryTypeCode, Connection conn)
        throws SQLException
    {
        try
        {
            fetchEntryDefBaseStatement = conn.prepareStatement(FetchEntryDefBaseSQL);
            fetchEntryDefBaseStatement.setString(1, entryTypeCode);
            runQuery(fetchEntryDefBaseStatement);
        }
        catch(SQLException ex)
        {
            String paramList = entryTypeCode;
            printSQLException(ex, getClass().getName(), "fetch", FetchEntryDefBaseSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public EntryTypeDefinition fetchNext()
        throws SQLException
    {
        EntryTypeDefinition entryDef = new EntryTypeDefinition();
        if(m_hasMore)
        {
            entryDef.setEntryTypeCd(m_resultSet.getString("ENTRY_TYPE_CD"));
            entryDef.setEntryTypeDesc(m_resultSet.getString("ENTRY_TYPE_DESC"));
            entryDef.setHsNeededFlg(m_resultSet.getString("HS_NEEDED_FLG"));
            entryDef.setEntryNbrNeededFlg(m_resultSet.getString("ENTRY_NBR_NEEDED_FLG"));
            entryDef.setMultipleEntryFlg(m_resultSet.getString("MULTIPLE_ENTRY_FLG"));
            entryDef.setUpperEntryValueAmt(m_resultSet.getFloat("UPPER_ENTRY_VALUE_AMT"));
            entryDef.setEntryNumber(m_resultSet.getString("ENTRY_NBR"));
            entryDef.setCategoryTypeCode(m_resultSet.getString("CATEGORY_TYPE_CD"));
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
            entryDef = null;
            m_recordCount = 0;
        }
        return entryDef;
    }

    public void standAloneTest()
    {
        int oldLastUsedNumber = 0;
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            db.setLocationCode("OAK");
            EntryTypeDefinition etd = db.fetchEntryTypeDef("92");
            System.out.println("etd object == " + etd.toString());
            System.out.println("mighnt have worked, if you got this message");
        }
        catch(Exception e)
        {
            System.out.println("standAloneTest caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    public static void main(String args[])
    {
        DbEntryTypeDef o = new DbEntryTypeDef();
        o.standAloneTest();
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbEntryTypeDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    protected int ORACLE_PRIMARY_KEY_EXISTS;
    private String columnNames;
    private String tableName;
    private String fetchBaseSQL;
    private String FetchEntryDefBaseSQL;
    private String insertEntryDefBaseSQL;
    private String updateEntryDefBaseSQL;
    private PreparedStatement fetchEntryDefBaseStatement;
    private PreparedStatement insertEntryDefBaseStatement;
    private PreparedStatement updateEntryDefBaseStatement;
}
