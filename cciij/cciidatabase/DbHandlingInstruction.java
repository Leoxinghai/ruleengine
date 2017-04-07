// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbHandlingInstruction.java

package cciij.cciidatabase;

import cciij.cciidata.HandlingInstructions;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbHandlingInstruction extends DbBase
{

    public DbHandlingInstruction()
    {
        fetchWithPrimaryKeySQL = "SELECT HANDLING_INSTRUCTION_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM FROM HANDLING_INSTRUCTION WHERE HANDLING_INSTRUCTION_OID_NBR = ?";
        fetchWithShipmentOrPieceOidSQL = "SELECT HANDLING_INSTRUCTION_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM FROM HANDLING_INSTRUCTION WHERE LOCATION_CD = ? AND (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?)";
        fetchWithShipmentOidSQL = "SELECT HANDLING_INSTRUCTION_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM FROM HANDLING_INSTRUCTION WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR = ?";
        fetchWithPieceOidSQL = "SELECT HANDLING_INSTRUCTION_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM FROM HANDLING_INSTRUCTION WHERE LOCATION_CD = ? AND PIECE_OID_NBR = ?";
        saveHandlingInstructionSQL = "INSERT INTO HANDLING_INSTRUCTION (HANDLING_INSTRUCTION_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, LOCATION_CD, HANDLING_INSTRUCTION_CD, HANDLING_INSTRUCTION_DESC, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeHandlingInstructionSQL = "DELETE FROM HANDLING_INSTRUCTION WHERE HANDLING_INSTRUCTION_OID_NBR = ?";
        updateHandlingInstructionSQL = "UPDATE HANDLING_INSTRUCTION SET SHIPMENT_OID_NBR = ?, PIECE_OID_NBR = ?, LOCATION_CD = ?, HANDLING_INSTRUCTION_CD = ?, HANDLING_INSTRUCTION_DESC = ?, ACTIVE_FLG = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, CREATE_PROCESS_NM = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ?, UPDATE_PROCESS_NM = ? WHERE HANDLING_INSTRUCTION_OID_NBR = ?";
        fetchWithPrimaryKeyStmt = null;
        fetchWithShipmentOrPieceOidStmt = null;
        fetchWithShipmentOidStmt = null;
        fetchWithPieceOidStmt = null;
        saveHandlingInstructionStmt = null;
        removeHandlingInstructionStmt = null;
        updateHandlingInstructionStmt = null;
    }

    public int getHandlingInstructionRecordCount()
    {
        return m_recordCount;
    }

    public HandlingInstructions fetch(Connection conn, int handlingInstructionOidNbr)
        throws SQLException
    {
        try
        {
            fetchWithPrimaryKeyStmt = conn.prepareStatement(fetchWithPrimaryKeySQL);
            fetchWithPrimaryKeyStmt.setInt(1, handlingInstructionOidNbr);
            runQuery(fetchWithPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(handlingInstructionOidNbr);
            printSQLException(ex, getClass().getName(), "fetch", fetchWithPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructions fetchByShipmentOrPieceOidNbr(Connection conn, String locationCode, int shipmentOidNbr, int pieceOidNbr)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOrPieceOidStmt = conn.prepareStatement(fetchWithShipmentOrPieceOidSQL);
            fetchWithShipmentOrPieceOidStmt.setString(1, locationCode);
            fetchWithShipmentOrPieceOidStmt.setInt(2, shipmentOidNbr);
            fetchWithShipmentOrPieceOidStmt.setInt(3, pieceOidNbr);
            runQuery(fetchWithShipmentOrPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + shipmentOidNbr + pieceOidNbr;
            printSQLException(ex, getClass().getName(), "fetchByShipmentOrPieceOidNbr", fetchWithShipmentOrPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructions fetchByShipmentOidNbr(Connection conn, String locationCode, int shipmentOidNbr)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOidStmt = conn.prepareStatement(fetchWithShipmentOidSQL);
            fetchWithShipmentOidStmt.setString(1, locationCode);
            fetchWithShipmentOidStmt.setInt(2, shipmentOidNbr);
            runQuery(fetchWithShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + shipmentOidNbr;
            printSQLException(ex, getClass().getName(), "fetchByShipmentOidNbr", fetchWithShipmentOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructions fetchByPieceOidNbr(Connection conn, String locationCode, int pieceOidNbr)
        throws SQLException
    {
        try
        {
            fetchWithPieceOidStmt = conn.prepareStatement(fetchWithPieceOidSQL);
            fetchWithPieceOidStmt.setString(1, locationCode);
            fetchWithPieceOidStmt.setInt(2, pieceOidNbr);
            runQuery(fetchWithPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + pieceOidNbr;
            printSQLException(ex, getClass().getName(), "fetchByPieceOidNbr", fetchWithPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public HandlingInstructions fetchNext()
        throws SQLException
    {
        HandlingInstructions hi = new HandlingInstructions();
        try
        {
            if(m_hasMore)
            {
                int handlingInstructionOidNumber = m_resultSet.getInt(1);
                int shipmentOidNumber = m_resultSet.getInt(2);
                int pieceOidNumber = m_resultSet.getInt(3);
                String locationCode = m_resultSet.getString(4);
                String handlingInstructionCode = m_resultSet.getString(5);
                String handlingInstructionDescription = m_resultSet.getString(6);
                String activeFlag = m_resultSet.getString(7);
                Timestamp createDateTmstp = m_resultSet.getTimestamp(8);
                String createEmployeeNumber = m_resultSet.getString(9);
                String createProcessName = m_resultSet.getString(10);
                Timestamp updateDateTmstp = m_resultSet.getTimestamp(11);
                String updateEmployeeNumber = m_resultSet.getString(12);
                String updateProcessName = m_resultSet.getString(13);
                Date createDate = convertTimestampToDate(createDateTmstp);
                Date updateDate = convertTimestampToDate(updateDateTmstp);
                hi = new HandlingInstructions(handlingInstructionOidNumber, shipmentOidNumber, pieceOidNumber, locationCode, handlingInstructionCode, handlingInstructionDescription, activeFlag, createDate, createEmployeeNumber, createProcessName, updateDate, updateEmployeeNumber, updateProcessName);
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
                hi = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return hi;
    }

    public void save(Connection conn, HandlingInstructions hi)
        throws SQLException
    {
        try
        {
            saveHandlingInstructionStmt = conn.prepareStatement(saveHandlingInstructionSQL);
            Timestamp tmpCreateDt = new Timestamp(hi.getCreateDate().getTime());
            Timestamp tmpUpdateDt = new Timestamp(hi.getUpdateDate().getTime());
            saveHandlingInstructionStmt.setInt(1, hi.getHandlingInstructionOidNumber());
            saveHandlingInstructionStmt.setInt(2, hi.getShipmentOidNumber());
            saveHandlingInstructionStmt.setInt(3, hi.getPieceOidNumber());
            saveHandlingInstructionStmt.setString(4, hi.getLocationCode());
            saveHandlingInstructionStmt.setString(5, hi.getHandlingInstructionCode());
            saveHandlingInstructionStmt.setString(6, hi.getHandlingInstructionDescription());
            saveHandlingInstructionStmt.setString(7, hi.getActiveFlag());
            saveHandlingInstructionStmt.setTimestamp(8, tmpCreateDt);
            saveHandlingInstructionStmt.setString(9, hi.getEmployeeNumber());
            saveHandlingInstructionStmt.setString(10, hi.getCreateProcessName());
            saveHandlingInstructionStmt.setTimestamp(11, tmpUpdateDt);
            saveHandlingInstructionStmt.setString(12, hi.getUpdateEmployeeNumber());
            saveHandlingInstructionStmt.setString(13, hi.getUpdateProcessName());
            saveHandlingInstructionStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hi.getHandlingInstructionOidNumber() + ", " + hi.getShipmentOidNumber() + ", " + hi.getPieceOidNumber() + ", " + hi.getPieceOidNumber() + ", " + hi.getHandlingInstructionCode() + ", " + hi.getHandlingInstructionDescription() + ", " + hi.getActiveFlag() + ", " + this.tmpCreateDt + ", " + hi.getEmployeeNumber() + ", " + hi.getCreateProcessName() + ", " + this.tmpUpdateDt + ", " + hi.getUpdateEmployeeNumber() + ", " + hi.getUpdateProcessName();
            printSQLException(ex, getClass().getName(), "save", saveHandlingInstructionSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, HandlingInstructions hi)
        throws SQLException
    {
        try
        {
            removeHandlingInstructionStmt = conn.prepareStatement(removeHandlingInstructionSQL);
            removeHandlingInstructionStmt.setInt(1, hi.getHandlingInstructionOidNumber());
            removeHandlingInstructionStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(hi.getHandlingInstructionOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeHandlingInstructionSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, HandlingInstructions hi)
        throws SQLException
    {
        try
        {
            updateHandlingInstructionStmt = conn.prepareStatement(updateHandlingInstructionSQL);
            tmpCreateDt = new Timestamp(hi.getCreateDate().getTime());
            tmpUpdateDt = new Timestamp(hi.getUpdateDate().getTime());
            updateHandlingInstructionStmt.setInt(1, hi.getShipmentOidNumber());
            updateHandlingInstructionStmt.setInt(2, hi.getPieceOidNumber());
            updateHandlingInstructionStmt.setString(3, hi.getLocationCode());
            updateHandlingInstructionStmt.setString(4, hi.getHandlingInstructionCode());
            updateHandlingInstructionStmt.setString(5, hi.getHandlingInstructionDescription());
            updateHandlingInstructionStmt.setString(6, hi.getActiveFlag());
            updateHandlingInstructionStmt.setTimestamp(7, tmpCreateDt);
            updateHandlingInstructionStmt.setString(8, hi.getEmployeeNumber());
            updateHandlingInstructionStmt.setString(9, hi.getCreateProcessName());
            updateHandlingInstructionStmt.setTimestamp(10, tmpUpdateDt);
            updateHandlingInstructionStmt.setString(11, hi.getUpdateEmployeeNumber());
            updateHandlingInstructionStmt.setString(12, hi.getUpdateProcessName());
            updateHandlingInstructionStmt.setInt(13, hi.getHandlingInstructionOidNumber());
            updateHandlingInstructionStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hi.getShipmentOidNumber() + ", " + hi.getPieceOidNumber() + ", " + hi.getLocationCode() + ", " + hi.getHandlingInstructionCode() + ", " + hi.getHandlingInstructionDescription() + ", " + hi.getActiveFlag() + ", " + tmpCreateDt + ", " + hi.getEmployeeNumber() + ", " + hi.getCreateProcessName() + ", " + tmpUpdateDt + ", " + hi.getUpdateEmployeeNumber() + ", " + hi.getUpdateProcessName() + ", " + hi.getHandlingInstructionOidNumber();
            printSQLException(ex, getClass().getName(), "update", updateHandlingInstructionSQL, paramList);
            throw ex;
        }
    }

    public static void dbTest(DatabaseBean db)
    {
        Date now = new Date();
        HandlingInstructions hi = new HandlingInstructions();
        HandlingInstructions hi1 = new HandlingInstructions(-1, 45, 308, "TEK", "TEK1", "TEK'S TEST HI ONE", "Y", now, "86515", "TEKPROCESS", now, "", "");
        HandlingInstructions hi2 = new HandlingInstructions(-2, 45, 308, "TEK", "TEK2", "TEK'S TEST HI TWO", "Y", now, "86515", "TEKPROCESS", now, "", "");
        db.setLocationCode("TEK");
        try
        {
            db.saveHandlingInstruction(hi1);
            System.out.println("Test Case 1: Successfully saved HandlingInstructions hi1");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
            db.saveHandlingInstruction(hi2);
            System.out.println("Test Case 1: Successfully saved HandlingInstructions hi2");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: unsuccessful" + ex);
        }
        hi2.setHandlingInstructionDescription("TEK'S TEST HI 2");
        hi2.setActiveFlag(false);
        hi2.setUpdateDate(new Date());
        hi2.setUpdateEmployeeNumber("86515");
        try
        {
            db.updateHandlingInstruction(hi2);
            System.out.println("Test Case 2: Successfully updated HandlingInstructions hi2");
            db.commitTransaction();
            System.out.println("Test Case 2: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: unsuccessful" + ex);
        }
        try
        {
            hi = db.fetchHandlingInstruction(-1);
            System.out.println("Test Case 3a: Successfully fetched hi1; HandlingInstructions = " + hi);
            hi = db.fetchHandlingInstructionByShipmentOrPieceOid(45, 308);
            for(int currentRow = 1; db.getHandlingInstructionRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3b: Successfully fetched Row = " + currentRow + " HandlingInstructions = " + hi);
                hi = db.fetchNextHandlingInstruction();
            }

            hi = db.fetchHandlingInstructionByShipmentOid(45);
            for(int currentRow = 1; db.getHandlingInstructionRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3c: Successfully fetched Row = " + currentRow + " HandlingInstructions = " + hi);
                hi = db.fetchNextHandlingInstruction();
            }

            hi = db.fetchHandlingInstructionByPieceOid(308);
            for(int currentRow = 1; db.getHandlingInstructionRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3d: Successfully fetched Row = " + currentRow + " HandlingInstructions = " + hi);
                hi = db.fetchNextHandlingInstruction();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: unsuccessful" + ex);
        }
        try
        {
            db.removeHandlingInstruction(hi1);
            System.out.println("Test Case 4: Successfully removed HandlingInstructions hi1");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
            db.removeHandlingInstruction(hi2);
            System.out.println("Test Case 4: Successfully removed HandlingInstructions hi2");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: unsuccessful" + ex);
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("TEK");
        db.connect();
        dbTest(db);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbHandlingInstruction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private Timestamp tmpCreateDt;
    private Timestamp tmpUpdateDt;
    private String fetchWithPrimaryKeySQL;
    private String fetchWithShipmentOrPieceOidSQL;
    private String fetchWithShipmentOidSQL;
    private String fetchWithPieceOidSQL;
    private String saveHandlingInstructionSQL;
    private String removeHandlingInstructionSQL;
    private String updateHandlingInstructionSQL;
    private PreparedStatement fetchWithPrimaryKeyStmt;
    private PreparedStatement fetchWithShipmentOrPieceOidStmt;
    private PreparedStatement fetchWithShipmentOidStmt;
    private PreparedStatement fetchWithPieceOidStmt;
    private PreparedStatement saveHandlingInstructionStmt;
    private PreparedStatement removeHandlingInstructionStmt;
    private PreparedStatement updateHandlingInstructionStmt;
}
