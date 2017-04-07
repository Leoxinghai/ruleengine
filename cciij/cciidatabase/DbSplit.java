// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbSplit.java

package cciij.cciidatabase;

import cciij.cciidata.Split;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbSplit extends DbBase
{

    public DbSplit()
    {
        fetchAllSplitSql = "SELECT LOCATION_CD, SPLIT_NBR, SPLIT_VALUE, SPLIT_DESC, SPLIT_VERSION_NBR, RECORD_ACTIVE_FLG, UPDATE_DT, UPDATE_EMPLOYEE_NBR FROM ent.SPLIT WHERE LOCATION_CD = ?";
        fetchSplitSql = "SELECT LOCATION_CD, SPLIT_NBR, SPLIT_VALUE, SPLIT_DESC, SPLIT_VERSION_NBR, RECORD_ACTIVE_FLG, UPDATE_DT, UPDATE_EMPLOYEE_NBR FROM ent.SPLIT WHERE LOCATION_CD = ?  AND SPLIT_NBR = ?";
        saveSplitSql = "INSERT INTO ent.SPLIT  (LOCATION_CD, SPLIT_NBR, SPLIT_VALUE, SPLIT_DESC, SPLIT_VERSION_NBR, RECORD_ACTIVE_FLG, UPDATE_DT, UPDATE_EMPLOYEE_NBR ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
        deleteSplitSql = "DELETE FROM ent.SPLIT  WHERE LOCATION_CD = ? AND SPLIT_NBR = ?";
        updateSplitSql = "UPDATE ent.SPLIT  SET SPLIT_VALUE = ?, SPLIT_DESC = ?, SPLIT_VERSION_NBR = ?, RECORD_ACTIVE_FLG = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ? WHERE LOCATION_CD = ? AND SPLIT_NBR = ?";
        fetchAllSplitStmt = null;
        fetchSplitStmt = null;
        saveSplitStmt = null;
        deleteSplitStmt = null;
        updateSplitStmt = null;
    }

    public Split fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllSplitStmt = conn.prepareStatement(fetchAllSplitSql);
            fetchAllSplitStmt.setString(1, locationCd);
            runQuery(fetchAllSplitStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", fetchAllSplitSql, locationCd);
            throw e;
        }
        return fetchNext();
    }

    public Split fetch(Connection conn, int splitNbr, String locationCd)
        throws SQLException
    {
        try
        {
            fetchSplitStmt = conn.prepareStatement(fetchSplitSql);
            fetchSplitStmt.setString(1, locationCd);
            fetchSplitStmt.setInt(2, splitNbr);
            runQuery(fetchSplitStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", fetchSplitSql, locationCd + ", " + splitNbr);
            throw e;
        }
        return fetchNext();
    }

    public Split fetchNext()
        throws SQLException
    {
        Split split = new Split();
        if(m_hasMore)
        {
            split.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            split.setSplitNbr(m_resultSet.getInt("SPLIT_NBR"));
            split.setSplitValue(m_resultSet.getBytes("SPLIT_VALUE"));
            split.setSplitDesc(m_resultSet.getString("SPLIT_DESC"));
            split.setSplitVersionNbr(m_resultSet.getString("SPLIT_VERSION_NBR"));
            split.setRecordActiveFlg(m_resultSet.getString("RECORD_ACTIVE_FLG"));
            Timestamp updateDtTmstp = m_resultSet.getTimestamp("UPDATE_DT");
            split.setUpdateEmployeeNbr(m_resultSet.getString("UPDATE_EMPLOYEE_NBR"));
            split.setUpdateDt(convertTimestampToDate(updateDtTmstp));
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
            split = null;
            m_recordCount = 0;
        }
        return split;
    }

    public void save(Connection conn, Split split)
        throws SQLException
    {
        try
        {
            tmstpUpdateDt = new Timestamp(split.getUpdateDt().getTime());
            saveSplitStmt = conn.prepareStatement(saveSplitSql);
            saveSplitStmt.setString(1, split.getLocationCd());
            saveSplitStmt.setInt(2, split.getSplitNbr());
            saveSplitStmt.setBytes(3, split.getSplitValue());
            saveSplitStmt.setString(4, split.getSplitDesc());
            saveSplitStmt.setString(5, split.getSplitVersionNbr());
            saveSplitStmt.setString(6, split.getRecordActiveFlg());
            saveSplitStmt.setTimestamp(7, tmstpUpdateDt);
            saveSplitStmt.setString(8, split.getUpdateEmployeeNbr());
            saveSplitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "save", saveSplitSql, split.getLocationCd() + ", " + split.getSplitNbr() + ", " + split.getSplitDesc() + ", " + split.getSplitVersionNbr() + ", " + split.getRecordActiveFlg() + ", " + split.getUpdateDt() + ", " + split.getUpdateEmployeeNbr());
            throw e;
        }
    }

    public void update(Connection conn, Split split)
        throws SQLException
    {
        try
        {
            tmstpUpdateDt = new Timestamp(split.getUpdateDt().getTime());
            updateSplitStmt = conn.prepareStatement(updateSplitSql);
            updateSplitStmt.setBytes(1, split.getSplitValue());
            updateSplitStmt.setString(2, split.getSplitDesc());
            updateSplitStmt.setString(3, split.getSplitVersionNbr());
            updateSplitStmt.setString(4, split.getRecordActiveFlg());
            updateSplitStmt.setTimestamp(5, tmstpUpdateDt);
            updateSplitStmt.setString(6, split.getUpdateEmployeeNbr());
            updateSplitStmt.setString(7, split.getLocationCd());
            updateSplitStmt.setInt(8, split.getSplitNbr());
            updateSplitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "update", updateSplitSql, "SplitValue is raw data, " + split.getSplitDesc() + ", " + split.getSplitVersionNbr() + ", " + split.getRecordActiveFlg() + ", " + tmstpUpdateDt + ", " + split.getUpdateEmployeeNbr() + ", " + split.getLocationCd() + ", " + split.getSplitNbr());
            throw e;
        }
    }

    public void delete(Connection conn, int splitNbr, String locationCd)
        throws SQLException
    {
        try
        {
            deleteSplitStmt = conn.prepareStatement(deleteSplitSql);
            deleteSplitStmt.setString(1, locationCd);
            deleteSplitStmt.setInt(2, splitNbr);
            deleteSplitStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "delete", deleteSplitSql, splitNbr + ", " + locationCd);
            throw e;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("COSA");
        db.connect();
        DbSplit dbSplit = new DbSplit();
        dbSplit.testDbSplit(db);
        db.closeConnection();
    }

    private void testDbSplit(DatabaseBean db)
    {
        Split split = null;
        Date splitDt = new Date(0L);
        byte byteArray[] = new byte[200];
        try
        {
            System.out.println("====Executing INSERT COSA, 12, 0, COSA Split 12, 0403, Y, splitDt, 12345");
            db.saveSplit(new Split("COSA", 12, byteArray, "COSA Split 12", "0403", "Y", splitDt, "12345"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting split " + e.getMessage());
        }
        try
        {
            System.out.println("====Executing SELECT BY SPLIT_NBR 12");
            split = db.fetchSplit(12);
            if(split != null)
                System.out.println(split);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SPLIT-NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE BY SPLIT_NBR");
            db.updateSplit(new Split("COSA", 12, byteArray, "COSA APLIT 12", "0403", "Y", splitDt, "54321"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while updateing by SPLIT_NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SPLIT_NBR");
            split = db.fetchSplit(12);
            if(split != null)
                System.out.println(split);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SPLIT_NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE SPLIT NBR 12");
            db.removeSplit(12);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while deleting Split " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SPLIT_NBR 12");
            split = db.fetchSplit(12);
            if(split != null)
                System.out.println(split);
            else
                System.out.println("Split not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while fetching Split by SPLIT_NBR " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbSplit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private Timestamp tmstpUpdateDt;
    private static final String tableName = "ent.SPLIT ";
    private String fetchAllSplitSql;
    private String fetchSplitSql;
    private String saveSplitSql;
    private String deleteSplitSql;
    private String updateSplitSql;
    private PreparedStatement fetchAllSplitStmt;
    private PreparedStatement fetchSplitStmt;
    private PreparedStatement saveSplitStmt;
    private PreparedStatement deleteSplitStmt;
    private PreparedStatement updateSplitStmt;
}
