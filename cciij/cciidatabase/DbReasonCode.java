// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbReasonCode.java

package cciij.cciidatabase;

import cciij.cciidata.ReasonCode;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbReasonCode extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOR");
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        Date createDate = new Date(0L);
        Date updateDate = new Date(0L);
        ReasonCode reasonCode = new ReasonCode("LDREA", 1111, 2222, 3333, "N", "Y", createDate, "EMP", updateDate, "EMP2", "PROC", "PROC2", "N", "LOR");
        try
        {
            db.saveReasonCode(reasonCode);
            System.out.println("Test Case 1: Successfully saved ReasonCode");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ReasonCode " + ex);
            System.out.println("reason code is " + reasonCode);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCode("LOR");
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetch(locationCode) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ReasonCode(locationCode) " + ex);
            System.out.println("Location is " + reasonCode.getLocationCd());
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCode("LOR", 1111);
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetch(locationCode, reasonOidNbr) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetch of ReasonCode(locationCode,reasonOidNbr) " + ex);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCodeWithActiveFlag("LOR");
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row = " + currentRow + " Results of fetch(locationCode, activeFlag) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: Unseccessful fetch of ReasonCode(locationCode,activeFlag) " + ex);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCodeByPieceOid("LOR", 3333);
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row = " + currentRow + " Results of fetch(locationCode, pieceOid) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5: Unseccessful fetch of ReasonCode(locationCode,pieceOid) " + ex);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCodeByShipmentOid("LOR", 2222);
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 6: Row = " + currentRow + " Results of fetch(locationCode, shipmentOid) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 6: Unseccessful fetch of ReasonCode(locationCode,shipmentOid) " + ex);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCodeByShipOrPieceOid("LOR", 2222, 3333);
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 7: Row = " + currentRow + " Results of fetch(locationCode, shipmentOid, pieceOid) " + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 7: Unseccessful fetch of ReasonCode(locationCode,shipmentOid,pieceOid) " + ex);
            return false;
        }
        try
        {
            reasonCode = db.fetchReasonCode("LOR", 1111);
            reasonCode.setEmployeeNumberForUpdate("UPDATEDEMP");
            db.updateReasonCode(reasonCode);
            reasonCode = db.fetchReasonCode("LOR", 1111);
            for(int currentRow = 1; db.getReasonCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 8: Row = " + currentRow + "-Results of updateReasonCode(ReasonCode reasonCode)" + reasonCode);
                reasonCode = db.fetchNextReasonCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 8: Unseccessful update) " + ex);
            return false;
        }
        try
        {
            db.removeReasonCode(new ReasonCode("LDREA", 1111, 2222, 3333, "N", "Y", createDate, "EMP", updateDate, "UPDATEDEMP", "PROC", "PROC2", "N", "LOR"));
            System.out.println("Test Case 9: Successfully removed ReasonCode");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 10: Unseccessful delete) " + ex);
            return false;
        }
        return true;
    }

    public DbReasonCode()
    {
        fetchReasonCodeSQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE LOCATION_CD = ? ORDER BY REASON_CD";
        fetchByPrimaryKeySQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE LOCATION_CD = ? AND REASON_OID_NBR = ? ORDER BY REASON_CD";
        fetchReasonCodeWithActiveFlagSQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE ACTIVE_FLG = 'Y' AND LOCATION_CD = ? ";
        fetchReasonCodeByPieceOidSQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE LOCATION_CD = ? AND PIECE_OID_NBR = ?";
        fetchReasonCodeByShipmentOidSQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?";
        fetchReasonCodeByShipOrPieceOidSQL = "SELECT REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD FROM REASON_CODE WHERE LOCATION_CD = ? AND (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?)";
        saveReasonCodeSQL = "INSERT INTO REASON_CODE (REASON_CD, REASON_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, RECURRING_CRITERIA_FLG, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, UPDATE_DT, UPDATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_PROCESS_NM, UPLOADED_FLG, LOCATION_CD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeReasonCodeSQL = "DELETE FROM REASON_CODE WHERE REASON_OID_NBR = ?";
        updateReasonCodeSQL = "UPDATE REASON_CODE SET REASON_CD = ?, SHIPMENT_OID_NBR = ?, PIECE_OID_NBR = ?, RECURRING_CRITERIA_FLG = ?, ACTIVE_FLG = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ?, CREATE_PROCESS_NM = ?, UPDATE_PROCESS_NM = ?, UPLOADED_FLG = ?, LOCATION_CD = ? WHERE REASON_OID_NBR = ?";
        fetchReasonCodeStmt = null;
        fetchByPrimaryKeyStmt = null;
        fetchReasonCodeWithActiveFlagStmt = null;
        fetchReasonCodeByPieceOidStmt = null;
        fetchReasonCodeByShipmentOidStmt = null;
        fetchReasonCodeByShipOrPieceOidStmt = null;
        saveReasonCodeStmt = null;
        removeReasonCodeStmt = null;
        updateReasonCodeStmt = null;
    }

    public int getReasonCodeRecordCount()
    {
        return m_recordCount;
    }

    public ReasonCode fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchReasonCodeStmt = conn.prepareStatement(fetchReasonCodeSQL);
            fetchReasonCodeStmt.setString(1, locationCd);
            runQuery(fetchReasonCodeStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbReasonCode fetch: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetch(Connection conn, String locationCd, int reasonOidNbr)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCd);
            fetchByPrimaryKeyStmt.setInt(2, reasonOidNbr);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbReasonCode fetch by primary key: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetchReasonCodeWithActiveFlag(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchReasonCodeWithActiveFlagStmt = conn.prepareStatement(fetchReasonCodeWithActiveFlagSQL);
            fetchReasonCodeWithActiveFlagStmt.setString(1, locationCd);
            runQuery(fetchReasonCodeWithActiveFlagStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetchReasonCodeWithActiveFlag", fetchReasonCodeWithActiveFlagSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetchReasonCodeByPieceOid(Connection conn, String locationCd, int pcOidNbr)
        throws SQLException
    {
        try
        {
            fetchReasonCodeByPieceOidStmt = conn.prepareStatement(fetchReasonCodeByPieceOidSQL);
            fetchReasonCodeByPieceOidStmt.setString(1, locationCd);
            fetchReasonCodeByPieceOidStmt.setInt(2, pcOidNbr);
            runQuery(fetchReasonCodeByPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + pcOidNbr;
            printSQLException(ex, getClass().getName(), "fetchReasonCodeByPieceOid", fetchReasonCodeByPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetchReasonCodeByShipmentOid(Connection conn, String locationCd, int shipOidNbr)
        throws SQLException
    {
        try
        {
            fetchReasonCodeByShipmentOidStmt = conn.prepareStatement(fetchReasonCodeByShipmentOidSQL);
            fetchReasonCodeByShipmentOidStmt.setString(1, locationCd);
            fetchReasonCodeByShipmentOidStmt.setInt(2, shipOidNbr);
            runQuery(fetchReasonCodeByShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + shipOidNbr;
            printSQLException(ex, getClass().getName(), "fetchReasonCodeByShipmentOid", fetchReasonCodeByShipmentOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetchReasonCodeByShipOrPieceOid(Connection conn, String locationCd, int shipmentOid, int pieceOid)
        throws SQLException
    {
        try
        {
            fetchReasonCodeByShipOrPieceOidStmt = conn.prepareStatement(fetchReasonCodeByShipOrPieceOidSQL);
            fetchReasonCodeByShipOrPieceOidStmt.setString(1, locationCd);
            fetchReasonCodeByShipOrPieceOidStmt.setInt(2, shipmentOid);
            fetchReasonCodeByShipOrPieceOidStmt.setInt(3, pieceOid);
            runQuery(fetchReasonCodeByShipOrPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + shipmentOid + ", " + pieceOid;
            printSQLException(ex, getClass().getName(), "fetchReasonCodeByShipOrPieceOid", fetchReasonCodeByShipOrPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReasonCode fetchNext()
        throws SQLException
    {
        ReasonCode reasonCode = new ReasonCode();
        try
        {
            if(m_hasMore)
            {
                String reasonCd = m_resultSet.getString(1);
                int reasonOidNbr = m_resultSet.getInt(2);
                int shipOid = m_resultSet.getInt(3);
                int pcOid = m_resultSet.getInt(4);
                String recurringCriteriaFlg = m_resultSet.getString(5);
                String activeFlg = m_resultSet.getString(6);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(7);
                Date createDt = convertTimestampToDate(createDtTmstp);
                String createEmpNum = m_resultSet.getString(8);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(9);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                String updtEmpNum = m_resultSet.getString(10);
                String createProcessName = m_resultSet.getString(11);
                String updtProcessName = m_resultSet.getString(12);
                String uploadedFlg = m_resultSet.getString(13);
                String locationCode = m_resultSet.getString(14);
                reasonCode = new ReasonCode(reasonCd, reasonOidNbr, shipOid, pcOid, recurringCriteriaFlg, activeFlg, createDt, createEmpNum, updateDt, updtEmpNum, createProcessName, updtProcessName, uploadedFlg, locationCode);
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
                reasonCode = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return reasonCode;
    }

    public void save(Connection conn, ReasonCode reasonCode, String locationCode)
        throws SQLException
    {
        Timestamp reasonCodeCreateDate = new Timestamp(reasonCode.getReasonCodeDate().getTime());
        Timestamp reasonCodeUpdateDate = new Timestamp(reasonCode.getUpdateDate().getTime());
        try
        {
            saveReasonCodeStmt = conn.prepareStatement(saveReasonCodeSQL);
            saveReasonCodeStmt.setString(1, reasonCode.getReasonCode());
            saveReasonCodeStmt.setInt(2, reasonCode.getReasonCodeOidNumber());
            saveReasonCodeStmt.setInt(3, reasonCode.getShipmentOidNumber());
            saveReasonCodeStmt.setInt(4, reasonCode.getPieceOidNumber());
            saveReasonCodeStmt.setString(5, reasonCode.getRecurringCriteriaFlag());
            saveReasonCodeStmt.setString(6, reasonCode.getActiveInactiveFlag());
            saveReasonCodeStmt.setTimestamp(7, reasonCodeCreateDate);
            saveReasonCodeStmt.setString(8, reasonCode.getCreateEmployeeNumber());
            saveReasonCodeStmt.setTimestamp(9, reasonCodeUpdateDate);
            saveReasonCodeStmt.setString(10, reasonCode.getUpdateEmployeeNumber());
            saveReasonCodeStmt.setString(11, reasonCode.getCreatedProcessName());
            saveReasonCodeStmt.setString(12, reasonCode.getUpdatedProcessName());
            saveReasonCodeStmt.setString(13, reasonCode.getUploadedFlag());
            if(reasonCode.getLocationCd().equals("") || reasonCode.getLocationCd().equals(null))
                saveReasonCodeStmt.setString(14, locationCode);
            else
                saveReasonCodeStmt.setString(14, reasonCode.getLocationCd());
            saveReasonCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = reasonCode.getReasonCode() + ", " + reasonCode.getReasonCodeOidNumber() + ", " + reasonCode.getShipmentOidNumber() + ", " + reasonCode.getPieceOidNumber() + ", " + reasonCode.getRecurringCriteriaFlag() + ", " + reasonCode.getActiveInactiveFlag() + ", " + reasonCodeCreateDate + ", " + reasonCode.getCreateEmployeeNumber() + ", " + reasonCodeUpdateDate + ", " + reasonCode.getUpdateEmployeeNumber() + ", " + reasonCode.getCreatedProcessName() + ", " + reasonCode.getUpdatedProcessName() + ", " + reasonCode.getUploadedFlag() + ", ";
            if(reasonCode.getLocationCd().equals(""))
                paramList = paramList + locationCode;
            else
                paramList = paramList + reasonCode.getLocationCd();
            printSQLException(ex, getClass().getName(), "save", saveReasonCodeSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, ReasonCode reasonCode)
        throws SQLException
    {
        try
        {
            System.out.println("object before trying to delete is " + reasonCode);
            removeReasonCodeStmt = conn.prepareStatement(removeReasonCodeSQL);
            removeReasonCodeStmt.setInt(1, reasonCode.getReasonCodeOidNumber());
            removeReasonCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(reasonCode.getReasonCodeOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeReasonCodeSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, ReasonCode reasonCode)
        throws SQLException
    {
        Timestamp reasonCodeCreateDate = new Timestamp(reasonCode.getReasonCodeDate().getTime());
        Timestamp reasonCodeUpdateDate = new Timestamp(reasonCode.getUpdateDate().getTime());
        try
        {
            updateReasonCodeStmt = conn.prepareStatement(updateReasonCodeSQL);
            updateReasonCodeStmt.setString(1, reasonCode.getReasonCode());
            updateReasonCodeStmt.setInt(2, reasonCode.getShipmentOidNumber());
            updateReasonCodeStmt.setInt(3, reasonCode.getPieceOidNumber());
            updateReasonCodeStmt.setString(4, reasonCode.getRecurringCriteriaFlag());
            updateReasonCodeStmt.setString(5, reasonCode.getActiveInactiveFlag());
            updateReasonCodeStmt.setTimestamp(6, reasonCodeCreateDate);
            updateReasonCodeStmt.setString(7, reasonCode.getCreateEmployeeNumber());
            updateReasonCodeStmt.setTimestamp(8, reasonCodeUpdateDate);
            updateReasonCodeStmt.setString(9, reasonCode.getUpdateEmployeeNumber());
            updateReasonCodeStmt.setString(10, reasonCode.getCreatedProcessName());
            updateReasonCodeStmt.setString(11, reasonCode.getUpdatedProcessName());
            updateReasonCodeStmt.setString(12, reasonCode.getUploadedFlag());
            updateReasonCodeStmt.setString(13, reasonCode.getLocationCd());
            updateReasonCodeStmt.setInt(14, reasonCode.getReasonCodeOidNumber());
            updateReasonCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = reasonCode.getReasonCode() + ", " + reasonCode.getShipmentOidNumber() + ", " + reasonCode.getPieceOidNumber() + ", " + reasonCode.getRecurringCriteriaFlag() + ", " + reasonCode.getActiveInactiveFlag() + ", " + reasonCodeCreateDate + ", " + reasonCode.getCreateEmployeeNumber() + ", " + reasonCodeUpdateDate + ", " + reasonCode.getUpdateEmployeeNumber() + ", " + reasonCode.getCreatedProcessName() + ", " + reasonCode.getUpdatedProcessName() + ", " + reasonCode.getUploadedFlag() + ", " + reasonCode.getLocationCd() + ", " + reasonCode.getReasonCodeOidNumber();
            printSQLException(ex, getClass().getName(), "update", updateReasonCodeSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbReasonCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchReasonCodeSQL;
    private String fetchByPrimaryKeySQL;
    private String fetchReasonCodeWithActiveFlagSQL;
    private String fetchReasonCodeByPieceOidSQL;
    private String fetchReasonCodeByShipmentOidSQL;
    private String fetchReasonCodeByShipOrPieceOidSQL;
    private String saveReasonCodeSQL;
    private String removeReasonCodeSQL;
    private String updateReasonCodeSQL;
    private PreparedStatement fetchReasonCodeStmt;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchReasonCodeWithActiveFlagStmt;
    private PreparedStatement fetchReasonCodeByPieceOidStmt;
    private PreparedStatement fetchReasonCodeByShipmentOidStmt;
    private PreparedStatement fetchReasonCodeByShipOrPieceOidStmt;
    private PreparedStatement saveReasonCodeStmt;
    private PreparedStatement removeReasonCodeStmt;
    private PreparedStatement updateReasonCodeStmt;
}
