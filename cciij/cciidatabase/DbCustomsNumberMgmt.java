// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbCustomsNumberMgmt.java

package cciij.cciidatabase;

import cciij.cciidata.CustomsNumberManagement;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rmtc.util.Config;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbCustomsNumberMgmt extends DbBase
{

    public DbCustomsNumberMgmt()
    {
        config = null;
        customsNumberTypeCode = null;
        customsNumberStatusCode = null;
        columnNames = "C.LOCATION_CD, C.CUSTOMS_TYPE_NBR_CD, C.TYPE_LOW_NBR, C.TYPE_HIGH_NBR, C.ACTIVATED_DT, C.STATUS_CD, C.TYPE_LAST_USED_NBR, C.CREATE_DT, C.CREATE_EMPLOYEE_NBR, C.LAST_MODIFIED_NM, C.LAST_MODIFIED_TMSTP ";
        tableName = " ENT.CUSTOMS_NUMBER_MANAGEMENT C ";
        fetchBaseSQL = "SELECT " + columnNames + " FROM " + tableName + " WHERE ";
        fetchCustomsNumberManagementBaseSQL = fetchBaseSQL + " C.CUSTOMS_TYPE_NBR_CD = ? ";
        fetchEntryTypeAndActiveSQL = fetchBaseSQL + " C.CUSTOMS_TYPE_NBR_CD = ? " + " AND C.STATUS_CD = ? " + " AND C.LOCATION_CD = ? " + " order by C.ACTIVATED_DT ASC " + " FOR UPDATE ";
        insertCustomsNumberManagementBaseSQL = "INSERT INTO " + tableName + " ( " + columnNames + " )" + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        updateCustomsNumberBaseSQL = "UPDATE " + tableName + " SET " + "C.ACTIVATED_DT = ?, " + "C.STATUS_CD = ?, " + "C.TYPE_LAST_USED_NBR = ?, " + "C.CREATE_DT = ?, " + "C.CREATE_EMPLOYEE_NBR = ?, " + "C.LAST_MODIFIED_NM = ?, " + "C.LAST_MODIFIED_TMSTP = ? " + " WHERE C.TYPE_LOW_NBR = ? " + "   AND C.TYPE_HIGH_NBR = ? " + "   AND C.LOCATION_CD = ? " + "   AND C.CUSTOMS_TYPE_NBR_CD = ? ";
        updateCustomsNumberLastUsedSQL = "UPDATE " + tableName + " SET " + "C.TYPE_LAST_USED_NBR = ?, " + "C.LAST_MODIFIED_NM = ?, " + "C.LAST_MODIFIED_TMSTP = ? " + " WHERE C.LOCATION_CD = ? " + "   AND C.TYPE_LOW_NBR = ? " + "   AND C.TYPE_HIGH_NBR = ?" + "   AND C.CUSTOMS_TYPE_NBR_CD = ? " + "   AND C.TYPE_LAST_USED_NBR = ? ";
        fetchCustomsNumberManagementBaseStatement = null;
        fetchEntryTypeAndActiveStatement = null;
        insertCustomsNumberManagementBaseStatement = null;
        updateCustomsNumberManagementBaseStatement = null;
        updateCustomsNumberLastUsedStatement = null;
    }

    public CustomsNumberManagement fetchEntryTypeAndActive(String typeCode, String loc, Connection conn)
        throws SQLException
    {
        String activeStatusCode = "A";
        try
        {
            fetchEntryTypeAndActiveStatement = conn.prepareStatement(fetchEntryTypeAndActiveSQL);
            fetchEntryTypeAndActiveStatement.setString(1, typeCode);
            fetchEntryTypeAndActiveStatement.setString(2, activeStatusCode);
            fetchEntryTypeAndActiveStatement.setString(3, loc);
            runQuery(fetchEntryTypeAndActiveStatement);
        }
        catch(SQLException ex)
        {
            String paramList = "paramlist: typeCode == " + typeCode + ", statusCode == " + activeStatusCode + " location == " + loc;
            printSQLException(ex, getClass().getName(), "fetch", fetchEntryTypeAndActiveSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public CustomsNumberManagement fetchNext()
        throws SQLException
    {
        CustomsNumberManagement cnm = new CustomsNumberManagement();
        if(m_hasMore)
        {
            cnm.setLocationCd(m_resultSet.getString("LOCATION_CD"));
            cnm.setCustomsTypeNbrCd(m_resultSet.getString("CUSTOMS_TYPE_NBR_CD"));
            cnm.setActivatedDt(m_resultSet.getDate("ACTIVATED_DT"));
            cnm.setStatusCd(m_resultSet.getString("STATUS_CD"));
            cnm.setTypeLowNbr(m_resultSet.getInt("TYPE_LOW_NBR"));
            cnm.setTypeHighNbr(m_resultSet.getInt("TYPE_HIGH_NBR"));
            cnm.setTypeLastUsedNbr(m_resultSet.getInt("TYPE_LAST_USED_NBR"));
            cnm.setCreateDt(m_resultSet.getDate("CREATE_DT"));
            cnm.setCreateEmployeeNbr(m_resultSet.getString("CREATE_EMPLOYEE_NBR"));
            cnm.setLastModifiedNm(m_resultSet.getString("LAST_MODIFIED_NM"));
            cnm.setLastModifiedTmstp(m_resultSet.getDate("LAST_MODIFIED_TMSTP"));
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
            cnm = null;
            m_recordCount = 0;
        }
        return cnm;
    }

    public void updateCustomsNumberLastUsed(CustomsNumberManagement cnm, int oldLastUsed, Connection conn)
        throws SQLException
    {
        try
        {
            updateCustomsNumberLastUsedStatement = conn.prepareStatement(updateCustomsNumberLastUsedSQL);
            updateCustomsNumberLastUsedStatement.setInt(1, cnm.getTypeLastUsedNbr());
            updateCustomsNumberLastUsedStatement.setString(2, cnm.getLastModifiedNm());
            updateCustomsNumberLastUsedStatement.setDate(3, new Date(cnm.getLastModifiedTmstp().getTime()));
            updateCustomsNumberLastUsedStatement.setString(4, cnm.getLocationCd());
            updateCustomsNumberLastUsedStatement.setInt(5, cnm.getTypeLowNbr());
            updateCustomsNumberLastUsedStatement.setInt(6, cnm.getTypeHighNbr());
            updateCustomsNumberLastUsedStatement.setString(7, cnm.getCustomsTypeNbrCd());
            updateCustomsNumberLastUsedStatement.setInt(8, oldLastUsed);
            updateDatabase(updateCustomsNumberLastUsedStatement);
            if(updateCustomsNumberLastUsedStatement.getUpdateCount() == 0)
                throw new SQLException("dbCustomsNumberManagement.updateLastUsed failed");
        }
        catch(SQLException ex)
        {
            String paramList = "not supplied";
            printSQLException(ex, getClass().getName(), "fetch", updateCustomsNumberLastUsedSQL, paramList);
            throw ex;
        }
    }

    public void updateCustomsNumberManagement(CustomsNumberManagement cnm, Connection conn)
        throws SQLException
    {
        try
        {
            updateCustomsNumberManagementBaseStatement = conn.prepareStatement(updateCustomsNumberBaseSQL);
            updateCustomsNumberManagementBaseStatement.setDate(1, new Date(cnm.getActivatedDt().getTime()));
            updateCustomsNumberManagementBaseStatement.setString(2, cnm.getStatusCd());
            updateCustomsNumberManagementBaseStatement.setInt(3, cnm.getTypeLastUsedNbr());
            updateCustomsNumberManagementBaseStatement.setDate(4, new Date(cnm.getCreateDt().getTime()));
            updateCustomsNumberManagementBaseStatement.setString(5, cnm.getCreateEmployeeNbr());
            updateCustomsNumberManagementBaseStatement.setString(6, cnm.getLastModifiedNm());
            updateCustomsNumberManagementBaseStatement.setDate(7, new Date(cnm.getLastModifiedTmstp().getTime()));
            updateCustomsNumberManagementBaseStatement.setInt(8, cnm.getTypeLowNbr());
            updateCustomsNumberManagementBaseStatement.setInt(9, cnm.getTypeHighNbr());
            updateCustomsNumberManagementBaseStatement.setString(10, cnm.getLocationCd());
            updateCustomsNumberManagementBaseStatement.setString(11, cnm.getCustomsTypeNbrCd());
            updateDatabase(updateCustomsNumberManagementBaseStatement);
        }
        catch(SQLException ex)
        {
            String paramList = "not supplied";
            printSQLException(ex, getClass().getName(), "fetch", updateCustomsNumberLastUsedSQL, paramList);
            throw ex;
        }
    }

    public void standAloneTest()
    {
        int oldLastUsedNumber = 0;
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            db.setLocationCode("OAK");
            CustomsNumberManagement cnm = db.fetchCustomsEntryTypeAndActive("C");
            System.out.println("CNM object == " + cnm.toString());
            cnm.setLastModifiedNm("justForjoey");
            cnm.setLastModifiedTmstp(new java.util.Date());
            oldLastUsedNumber = cnm.getTypeLastUsedNbr();
            cnm.setTypeLastUsedNbr(oldLastUsedNumber + 1);
            System.out.println("cnm ready for update == " + cnm.toString());
            db.updateCustomsNumberLastUsed(cnm, oldLastUsedNumber);
            System.out.println("mighnt have worked, if you got this message");
            System.out.println("fetch it back and see your data");
            cnm = db.fetchCustomsEntryTypeAndActive("C");
            System.out.println("CNM object == " + cnm.toString());
        }
        catch(Exception e)
        {
            System.out.println("DbShipment.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    public static void main(String args[])
    {
        DbCustomsNumberMgmt o = new DbCustomsNumberMgmt();
        o.standAloneTest();
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbCustomsNumberMgmt.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private Config config;
    private String customsNumberTypeCode;
    private String customsNumberStatusCode;
    String columnNames;
    private String tableName;
    private String fetchBaseSQL;
    private String fetchCustomsNumberManagementBaseSQL;
    private String fetchEntryTypeAndActiveSQL;
    private String insertCustomsNumberManagementBaseSQL;
    private String updateCustomsNumberBaseSQL;
    private String updateCustomsNumberLastUsedSQL;
    private PreparedStatement fetchCustomsNumberManagementBaseStatement;
    private PreparedStatement fetchEntryTypeAndActiveStatement;
    private PreparedStatement insertCustomsNumberManagementBaseStatement;
    private PreparedStatement updateCustomsNumberManagementBaseStatement;
    private PreparedStatement updateCustomsNumberLastUsedStatement;
}
