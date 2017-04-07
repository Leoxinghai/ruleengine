// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbNextOid.java

package cciij.cciidatabase;

import cciij.cciidata.NextOid;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbNextOid extends DbBase
{

    public DbNextOid()
    {
        selectAllStmt = null;
        selectByTableNameStmt = null;
        selectByNextOidNbrStmt = null;
        saveNextOidStmt = null;
        updateNextOidStmt = null;
        removeNextOidStmt = null;
    }

    public void save(Connection conn, NextOid nextOid)
        throws SQLException
    {
        try
        {
            saveNextOidStmt = conn.prepareStatement("INSERT INTO NEXT_OID  VALUES( ?, ?) ");
            saveNextOidStmt.setString(1, nextOid.getTableName());
            saveNextOidStmt.setInt(2, nextOid.getNextOidNumber());
            saveNextOidStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = nextOid.getTableName() + ", " + nextOid.getNextOidNumber();
            printSQLException(ex, getClass().getName(), "save", "INSERT INTO NEXT_OID  VALUES( ?, ?) ", paramList);
            throw ex;
        }
    }

    public void update(Connection conn, NextOid nextOid)
        throws SQLException
    {
        try
        {
            updateNextOidStmt = conn.prepareStatement("UPDATE NEXT_OID  SET NEXT_OID_NBR = ? WHERE TABLE_NM = ?");
            updateNextOidStmt.setInt(1, nextOid.getNextOidNumber());
            updateNextOidStmt.setString(2, nextOid.getTableName());
            updateNextOidStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = nextOid.getNextOidNumber() + ", " + nextOid.getTableName();
            printSQLException(ex, getClass().getName(), "update", "UPDATE NEXT_OID  SET NEXT_OID_NBR = ? WHERE TABLE_NM = ?", paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, NextOid nextOid)
        throws SQLException
    {
        try
        {
            removeNextOidStmt = conn.prepareStatement("DELETE FROM NEXT_OID WHERE TABLE_NM = ? ");
            removeNextOidStmt.setString(1, nextOid.getTableName());
            removeNextOidStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = nextOid.getTableName();
            printSQLException(ex, getClass().getName(), "remove", "DELETE FROM NEXT_OID WHERE TABLE_NM = ? ", paramList);
            throw ex;
        }
    }

    public NextOid fetch(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllStmt = conn.prepareStatement("SELECT * FROM NEXT_OID ");
            runQuery(selectAllStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM NEXT_OID ", " ");
            throw ex;
        }
        return fetchNext();
    }

    public NextOid fetch(Connection conn, String tableName)
        throws SQLException
    {
        try
        {
            selectByTableNameStmt = conn.prepareStatement("SELECT * FROM NEXT_OID WHERE TABLE_NM = ? ");
            selectByTableNameStmt.setString(1, tableName);
            runQuery(selectByTableNameStmt);
        }
        catch(SQLException ex)
        {
            String paramList = tableName;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM NEXT_OID WHERE TABLE_NM = ? ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public NextOid fetch(Connection conn, int netxOidNbr)
        throws SQLException
    {
        try
        {
            selectByNextOidNbrStmt = conn.prepareStatement("SELECT * FROM NEXT_OID WHERE NEXT_OID_NBR = ? ");
            selectByNextOidNbrStmt.setInt(1, netxOidNbr);
            runQuery(selectByNextOidNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(netxOidNbr);
            printSQLException(ex, getClass().getName(), "fetch", "SELECT * FROM NEXT_OID WHERE NEXT_OID_NBR = ? ", paramList);
            throw ex;
        }
        return fetchNext();
    }

    public NextOid fetchNext()
        throws SQLException
    {
        NextOid nextOid = new NextOid();
        if(m_hasMore)
        {
            nextOid.setTableName(m_resultSet.getString("TABLE_NM"));
            nextOid.setNextOidNumber(m_resultSet.getInt("NEXT_OID_NBR"));
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
            catch(SQLException ex)
            {
                printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
                throw ex;
            }
        } else
        {
            nextOid = null;
            m_recordCount = 0;
        }
        return nextOid;
    }

    public int getNextOidRecordCount()
    {
        return m_recordCount;
    }

    private void testDbNextOid(DatabaseBean db)
    {
        NextOid nextOid = null;
        try
        {
            System.out.println("===============Executing SELECT *");
            if((nextOid = db.fetchNextOid()) != null)
                System.out.println(nextOid);
            while((nextOid = db.fetchNextNextOid()) != null) 
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all nextoids " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY NEXT_OID_NBR");
            nextOid = db.fetchNextOidByNextOidNbr(0x497c9);
            if(nextOid != null)
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by nextoidnbr " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY TABLE_NAME");
            nextOid = db.fetchNextOidByTableName("piece");
            if(nextOid != null)
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by tableName " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing INSERT  MyPiece, 11111111");
            db.saveNextOid(new NextOid("Mypiece", 0xa98ac7));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY NEXT_OID_NBR 11111111");
            nextOid = db.fetchNextOidByNextOidNbr(0xa98ac7);
            if(nextOid != null)
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by nextoidnbr " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE  MyPiece, 3333");
            db.updateNextOid(new NextOid("Mypiece", 3333));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY NEXT_OID_NBR 3333");
            nextOid = db.fetchNextOidByNextOidNbr(3333);
            if(nextOid != null)
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by nextoidnbr " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE MyPiece 3333");
            db.removeNextOid(new NextOid("Mypiece", 3333));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY NEXT_OID_NBR 3333");
            nextOid = db.fetchNextOidByNextOidNbr(3333);
            if(nextOid != null)
                System.out.println(nextOid);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by nextoidnbr " + e.getMessage());
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        DbNextOid dbNextOid = new DbNextOid();
        dbNextOid.testDbNextOid(db);
        db.closeConnection();
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbNextOid.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private final String m_tableName = "NEXT_OID ";
    private final String selectAllSQL = "SELECT * FROM NEXT_OID ";
    private final String selectByTableNameSQL = "SELECT * FROM NEXT_OID WHERE TABLE_NM = ? ";
    private final String selectByNextOidNbrSQL = "SELECT * FROM NEXT_OID WHERE NEXT_OID_NBR = ? ";
    private final String saveNextOidSQL = "INSERT INTO NEXT_OID  VALUES( ?, ?) ";
    private final String updateNextOidSQL = "UPDATE NEXT_OID  SET NEXT_OID_NBR = ? WHERE TABLE_NM = ?";
    private final String removeNextOidSQL = "DELETE FROM NEXT_OID WHERE TABLE_NM = ? ";
    private PreparedStatement selectAllStmt;
    private PreparedStatement selectByTableNameStmt;
    private PreparedStatement selectByNextOidNbrStmt;
    private PreparedStatement saveNextOidStmt;
    private PreparedStatement updateNextOidStmt;
    private PreparedStatement removeNextOidStmt;
}
