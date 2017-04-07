// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbReleaseCode.java

package cciij.cciidatabase;

import cciij.cciidata.ReleaseCode;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbReleaseCode extends DbBase
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
        ReleaseCode releaseCode = new ReleaseCode(1111, 2222, "LO", "Y", createDate, "EMP", "PROC", updateDate, "EMP2", "PROC2", "N", 3333, "LOR");
        ReleaseCode releaseCode1 = new ReleaseCode(4444, 2224, "LO", "N", createDate, "EMP", "PROC", updateDate, "EMP2", "PROC2", "N", 3334, "LOR");
        try
        {
            db.saveReleaseCode(releaseCode);
            db.saveReleaseCode(releaseCode1);
            System.out.println("Test Case 1: Successfully saved ReleaseCode");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: Unseccessful save of ReleaseCode " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCode("LOR");
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2: Row = " + currentRow + " Results of fetch(locationCode) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: Unseccessful fetch of ReleaseCode(locationCode) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCode("LOR", 1111);
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + " Results of fetch(locationCode, releaseOidNbr) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: Unseccessful fetch of ReleaseCode(locationCode,releaseOidNbr) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCodeWithActiveFlag("LOR");
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4: Row = " + currentRow + " Results of fetch(locationCode, activeFlag) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: Unseccessful fetch of ReleaseCode(locationCode,activeFlag) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCodeByPieceOid("LOR", 3333);
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row = " + currentRow + " Results of fetch(locationCode, pieceOid) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5: Unseccessful fetch of ReleaseCode(locationCode,pieceOid) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCodeByShipmentOid("LOR", 2222);
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 6: Row = " + currentRow + " Results of fetch(locationCode, shipmentOid) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 6: Unseccessful fetch of ReleaseCode(locationCode,shipmentOid) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCodeByShipOrPieceOid("LOR", 2222, 3333);
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 7: Row = " + currentRow + " Results of fetch(locationCode, shipmentOid, pieceOid) " + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 7: Unseccessful fetch of ReleaseCode(locationCode,shipmentOid,pieceOid) " + ex);
            return false;
        }
        try
        {
            releaseCode = db.fetchReleaseCode("LOR", 1111);
            releaseCode.setEmployeeNumberForUpdate("UPDATEDEMP");
            db.updateReleaseCode(releaseCode);
            releaseCode = db.fetchReleaseCode("LOR", 1111);
            for(int currentRow = 1; db.getReleaseCodeRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 8: Row = " + currentRow + "-Results of updateReleaseCode(ReleaseCode releaseCode)" + releaseCode);
                releaseCode = db.fetchNextReleaseCode();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 8: Unseccessful update) " + ex);
            return false;
        }
        try
        {
            db.removeReleaseCode(new ReleaseCode(1111, 2222, "LO", "Y", createDate, "EMP", "PROC", updateDate, "UPDATEDEMP", "PROC2", "N", 3333, "LOR"));
            System.out.println("Test Case 9: Successfully removed ReasonCode");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 9: Unseccessful delete) " + ex);
            return false;
        }
        return true;
    }

    public DbReleaseCode()
    {
        fetchReleaseCodeSQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE LOCATION_CD = ? ORDER BY RELEASE_CD";
        fetchByPrimaryKeySQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE LOCATION_CD = ? AND RELEASE_OID_NBR = ? ORDER BY RELEASE_CD";
        fetchReleaseCodeWithActiveFlagSQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE ACTIVE_FLG = 'Y' AND LOCATION_CD = ? ";
        fetchReleaseCodeByPieceOidSQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE LOCATION_CD = ? AND PIECE_OID_NBR = ?";
        fetchReleaseCodeByShipmentOidSQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?";
        fetchReleaseCodeByShipOrPieceOidSQL = "SELECT RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG,  PIECE_OID_NBR, LOCATION_CD FROM RELEASE_CODE WHERE LOCATION_CD = ? AND (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?)";
        saveReleaseCodeSQL = "INSERT INTO RELEASE_CODE (RELEASE_OID_NBR, SHIPMENT_OID_NBR, RELEASE_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, UPLOADED_FLG, PIECE_OID_NBR, LOCATION_CD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeReleaseCodeSQL = "DELETE FROM RELEASE_CODE WHERE RELEASE_OID_NBR = ?";
        updateReleaseCodeSQL = "UPDATE RELEASE_CODE SET SHIPMENT_OID_NBR = ?, RELEASE_CD = ?, ACTIVE_FLG = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, CREATE_PROCESS_NM = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ?, UPDATE_PROCESS_NM = ?, UPLOADED_FLG = ?, PIECE_OID_NBR = ?, LOCATION_CD = ? WHERE RELEASE_OID_NBR = ?";
        fetchReleaseCodeStmt = null;
        fetchByPrimaryKeyStmt = null;
        fetchReleaseCodeWithActiveFlagStmt = null;
        fetchReleaseCodeByPieceOidStmt = null;
        fetchReleaseCodeByShipmentOidStmt = null;
        fetchReleaseCodeByShipOrPieceOidStmt = null;
        saveReleaseCodeStmt = null;
        removeReleaseCodeStmt = null;
        updateReleaseCodeStmt = null;
    }

    public int getReleaseCodeRecordCount()
    {
        return m_recordCount;
    }

    public ReleaseCode fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeStmt = conn.prepareStatement(fetchReleaseCodeSQL);
            fetchReleaseCodeStmt.setString(1, locationCd);
            runQuery(fetchReleaseCodeStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbReleaseCode fetch: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetch(Connection conn, String locationCd, int releaseOidNbr)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCd);
            fetchByPrimaryKeyStmt.setInt(2, releaseOidNbr);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbReleaseCode fetch by primary key: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetchReleaseCodeWithActiveFlag(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeWithActiveFlagStmt = conn.prepareStatement(fetchReleaseCodeWithActiveFlagSQL);
            fetchReleaseCodeWithActiveFlagStmt.setString(1, locationCd);
            runQuery(fetchReleaseCodeWithActiveFlagStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetchReleaseCodeWithActiveFlag", fetchReleaseCodeWithActiveFlagSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetchReleaseCodeByPieceOid(Connection conn, String locationCd, int pcOidNbr)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeByPieceOidStmt = conn.prepareStatement(fetchReleaseCodeByPieceOidSQL);
            fetchReleaseCodeByPieceOidStmt.setString(1, locationCd);
            fetchReleaseCodeByPieceOidStmt.setInt(2, pcOidNbr);
            runQuery(fetchReleaseCodeByPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + pcOidNbr;
            printSQLException(ex, getClass().getName(), "fetchReleaseCodeByPieceOid", fetchReleaseCodeByPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetchReleaseCodeByShipmentOid(Connection conn, String locationCd, int shipOidNbr)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeByShipmentOidStmt = conn.prepareStatement(fetchReleaseCodeByShipmentOidSQL);
            fetchReleaseCodeByShipmentOidStmt.setString(1, locationCd);
            fetchReleaseCodeByShipmentOidStmt.setInt(2, shipOidNbr);
            runQuery(fetchReleaseCodeByShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + shipOidNbr;
            printSQLException(ex, getClass().getName(), "fetchReleaseCodeByShipmentOid", fetchReleaseCodeByShipmentOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetchReleaseCodeByShipOrPieceOid(Connection conn, String locationCd, int shipmentOid, int pieceOid)
        throws SQLException
    {
        try
        {
            fetchReleaseCodeByShipOrPieceOidStmt = conn.prepareStatement(fetchReleaseCodeByShipOrPieceOidSQL);
            fetchReleaseCodeByShipOrPieceOidStmt.setString(1, locationCd);
            fetchReleaseCodeByShipOrPieceOidStmt.setInt(2, shipmentOid);
            fetchReleaseCodeByShipOrPieceOidStmt.setInt(3, pieceOid);
            runQuery(fetchReleaseCodeByShipOrPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd + ", " + shipmentOid + ", " + pieceOid;
            printSQLException(ex, getClass().getName(), "fetchReleaseCodeByShipOrPieceOid", fetchReleaseCodeByShipOrPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public ReleaseCode fetchNext()
        throws SQLException
    {
        ReleaseCode releaseCode = new ReleaseCode();
        try
        {
            if(m_hasMore)
            {
                int releaseOidNbr = m_resultSet.getInt(1);
                int shipOid = m_resultSet.getInt(2);
                String releaseCd = m_resultSet.getString(3);
                String activeFlg = m_resultSet.getString(4);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(5);
                Date createDt = convertTimestampToDate(createDtTmstp);
                String createEmpNum = m_resultSet.getString(6);
                String createProcessName = m_resultSet.getString(7);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(8);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                String updtEmpNum = m_resultSet.getString(9);
                String updtProcessName = m_resultSet.getString(10);
                String uploadedFlg = m_resultSet.getString(11);
                int pcOid = m_resultSet.getInt(12);
                String locationCode = m_resultSet.getString(13);
                releaseCode = new ReleaseCode(releaseOidNbr, shipOid, releaseCd, activeFlg, createDt, createEmpNum, createProcessName, updateDt, updtEmpNum, updtProcessName, uploadedFlg, pcOid, locationCode);
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
                releaseCode = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return releaseCode;
    }

    public void save(Connection conn, ReleaseCode releaseCode, String locationCode)
        throws SQLException
    {
        try
        {
            saveReleaseCodeStmt = conn.prepareStatement(saveReleaseCodeSQL);
            saveReleaseCodeStmt.setInt(1, releaseCode.getReleaseCodeOidNumber());
            saveReleaseCodeStmt.setInt(2, releaseCode.getShipmentOidNumber());
            saveReleaseCodeStmt.setString(3, releaseCode.getReleaseCode());
            saveReleaseCodeStmt.setString(4, releaseCode.getActiveInactiveFlag());
            saveReleaseCodeStmt.setTimestamp(5, new Timestamp(releaseCode.getCreateDate().getTime()));
            saveReleaseCodeStmt.setString(6, releaseCode.getCreateEmployeeNumber());
            saveReleaseCodeStmt.setString(7, releaseCode.getCreatedProcessName());
            saveReleaseCodeStmt.setTimestamp(8, new Timestamp(releaseCode.getUpdateDate().getTime()));
            saveReleaseCodeStmt.setString(9, releaseCode.getUpdateEmployeeNumber());
            saveReleaseCodeStmt.setString(10, releaseCode.getUpdatedProcessName());
            saveReleaseCodeStmt.setString(11, releaseCode.getUploadedFlag());
            saveReleaseCodeStmt.setInt(12, releaseCode.getPieceOidNumber());
            if(releaseCode.getLocationCd().equals("") || releaseCode.getLocationCd().equals(null))
                saveReleaseCodeStmt.setString(13, locationCode);
            else
                saveReleaseCodeStmt.setString(13, releaseCode.getLocationCd());
            saveReleaseCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = releaseCode.getReleaseCodeOidNumber() + ", " + releaseCode.getShipmentOidNumber() + ", " + releaseCode.getReleaseCode() + ", " + releaseCode.getActiveInactiveFlag() + ", " + new Timestamp(releaseCode.getCreateDate().getTime()) + ", " + releaseCode.getCreateEmployeeNumber() + ", " + releaseCode.getCreatedProcessName() + ", " + new Timestamp(releaseCode.getUpdateDate().getTime()) + ", " + releaseCode.getUpdateEmployeeNumber() + ", " + releaseCode.getUpdatedProcessName() + ", " + releaseCode.getUploadedFlag() + ", " + releaseCode.getPieceOidNumber();
            if(releaseCode.getLocationCd().equals(""))
                paramList = paramList + locationCode;
            else
                paramList = paramList + releaseCode.getLocationCd();
            printSQLException(ex, getClass().getName(), "save", saveReleaseCodeSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, ReleaseCode releaseCode)
        throws SQLException
    {
        try
        {
            removeReleaseCodeStmt = conn.prepareStatement(removeReleaseCodeSQL);
            removeReleaseCodeStmt.setInt(1, releaseCode.getReleaseCodeOidNumber());
            removeReleaseCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(releaseCode.getReleaseCodeOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeReleaseCodeSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, ReleaseCode releaseCode)
        throws SQLException
    {
        try
        {
            updateReleaseCodeStmt = conn.prepareStatement(updateReleaseCodeSQL);
            updateReleaseCodeStmt.setInt(1, releaseCode.getShipmentOidNumber());
            updateReleaseCodeStmt.setString(2, releaseCode.getReleaseCode());
            updateReleaseCodeStmt.setString(3, releaseCode.getActiveInactiveFlag());
            updateReleaseCodeStmt.setTimestamp(4, new Timestamp(releaseCode.getCreateDate().getTime()));
            updateReleaseCodeStmt.setString(5, releaseCode.getCreateEmployeeNumber());
            updateReleaseCodeStmt.setString(6, releaseCode.getCreatedProcessName());
            updateReleaseCodeStmt.setTimestamp(7, new Timestamp(releaseCode.getUpdateDate().getTime()));
            updateReleaseCodeStmt.setString(8, releaseCode.getUpdateEmployeeNumber());
            updateReleaseCodeStmt.setString(9, releaseCode.getUpdatedProcessName());
            updateReleaseCodeStmt.setString(10, releaseCode.getUploadedFlag());
            updateReleaseCodeStmt.setInt(11, releaseCode.getPieceOidNumber());
            updateReleaseCodeStmt.setString(12, releaseCode.getLocationCd());
            updateReleaseCodeStmt.setInt(13, releaseCode.getReleaseCodeOidNumber());
            updateReleaseCodeStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = releaseCode.getReleaseCodeOidNumber() + ", " + releaseCode.getShipmentOidNumber() + ", " + releaseCode.getReleaseCode() + ", " + releaseCode.getActiveInactiveFlag() + ", " + new Timestamp(releaseCode.getCreateDate().getTime()) + ", " + releaseCode.getCreateEmployeeNumber() + ", " + releaseCode.getCreatedProcessName() + ", " + new Timestamp(releaseCode.getUpdateDate().getTime()) + ", " + releaseCode.getUpdateEmployeeNumber() + ", " + releaseCode.getUpdatedProcessName() + ", " + releaseCode.getUploadedFlag() + ", " + releaseCode.getPieceOidNumber() + ", " + releaseCode.getLocationCd() + ", " + releaseCode.getReleaseCodeOidNumber();
            printSQLException(ex, getClass().getName(), "update", updateReleaseCodeSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchReleaseCodeSQL;
    private String fetchByPrimaryKeySQL;
    private String fetchReleaseCodeWithActiveFlagSQL;
    private String fetchReleaseCodeByPieceOidSQL;
    private String fetchReleaseCodeByShipmentOidSQL;
    private String fetchReleaseCodeByShipOrPieceOidSQL;
    private String saveReleaseCodeSQL;
    private String removeReleaseCodeSQL;
    private String updateReleaseCodeSQL;
    private PreparedStatement fetchReleaseCodeStmt;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchReleaseCodeWithActiveFlagStmt;
    private PreparedStatement fetchReleaseCodeByPieceOidStmt;
    private PreparedStatement fetchReleaseCodeByShipmentOidStmt;
    private PreparedStatement fetchReleaseCodeByShipOrPieceOidStmt;
    private PreparedStatement saveReleaseCodeStmt;
    private PreparedStatement removeReleaseCodeStmt;
    private PreparedStatement updateReleaseCodeStmt;
}
