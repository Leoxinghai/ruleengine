// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbShipmentRemark.java

package cciij.cciidatabase;

import cciij.cciidata.ShipmentRemark;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbShipmentRemark extends DbBase
{

    public DbShipmentRemark()
    {
        SHIPMENT_REMARK = "SHIPMENT_REMARK ";
        columns = "SHIPMENT_REMARK_OID_NBR, SHIPMENT_OID_NBR, LOCATION_CD, SHIPMENT_REMARK_CD, PIECE_OID_NBR, REMARK_DESC, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, AGENCY_CD, AGENCY_LOCATION_CD ";
        fetchShipmentRemarkSQL = "SELECT " + columns + "FROM " + SHIPMENT_REMARK + "WHERE SHIPMENT_REMARK_OID_NBR= ?  ";
        fetchShipmentRemarkByShipmentOrPieceOidSQL = "SELECT " + columns + "FROM " + SHIPMENT_REMARK + "WHERE LOCATION_CD = ? " + "AND (SHIPMENT_OID_NBR= ? OR PIECE_OID_NBR= ?)";
        fetchShipmentRemarkByShipmentOidSQL = "SELECT " + columns + "FROM " + SHIPMENT_REMARK + "WHERE LOCATION_CD = ? AND SHIPMENT_OID_NBR= ?  ";
        fetchShipmentRemarkByPieceOidSQL = "SELECT " + columns + "FROM " + SHIPMENT_REMARK + "WHERE LOCATION_CD = ? AND PIECE_OID_NBR= ?  ";
        saveShipmentRemarkSQL = "INSERT INTO " + SHIPMENT_REMARK + " (" + columns + ") " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeShipmentRemarkSQL = "DELETE FROM " + SHIPMENT_REMARK + "WHERE SHIPMENT_REMARK_OID_NBR = ?";
        updateShipmentRemarkSQL = "UPDATE " + SHIPMENT_REMARK + "SET SHIPMENT_OID_NBR = ?, LOCATION_CD = ?, SHIPMENT_REMARK_CD = ?, " + "PIECE_OID_NBR = ?, REMARK_DESC = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, " + "CREATE_PROCESS_NM = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ?, " + "UPDATE_PROCESS_NM = ?, AGENCY_CD = ?, AGENCY_LOCATION_CD = ? " + "WHERE SHIPMENT_REMARK_OID_NBR = ? ";
        fetchShipmentRemarkStmt = null;
        fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt = null;
        fetchShipmentRemarkWithShipmentOidNbrStmt = null;
        fetchShipmentRemarkWithPieceOidNbrStmt = null;
        saveShipmentRemarkStmt = null;
        removeShipmentRemarkStmt = null;
        updateShipmentRemarkStmt = null;
    }

    public ShipmentRemark fetch(Connection conn, int shipmentRemarkOidNbr)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkStmt = conn.prepareStatement(fetchShipmentRemarkSQL);
            fetchShipmentRemarkStmt.setInt(1, shipmentRemarkOidNbr);
            runQuery(fetchShipmentRemarkStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchShipmentRemarkSQL, "" + shipmentRemarkOidNbr);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemark fetchByShipmentOrPieceOidNbr(Connection conn, String locationCd, int shipmentOidNbr, int pieceOidNbr)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt = conn.prepareStatement(fetchShipmentRemarkByShipmentOrPieceOidSQL);
            fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt.setString(1, locationCd);
            fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt.setInt(2, shipmentOidNbr);
            fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt.setInt(3, pieceOidNbr);
            runQuery(fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByShipmentOrPieceOidNbr", fetchShipmentRemarkByShipmentOrPieceOidSQL, "" + shipmentOidNbr + pieceOidNbr);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemark fetchByShipmentOidNbr(Connection conn, String locationCd, int shipmentOidNbr)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkWithShipmentOidNbrStmt = conn.prepareStatement(fetchShipmentRemarkByShipmentOidSQL);
            fetchShipmentRemarkWithShipmentOidNbrStmt.setString(1, locationCd);
            fetchShipmentRemarkWithShipmentOidNbrStmt.setInt(2, shipmentOidNbr);
            runQuery(fetchShipmentRemarkWithShipmentOidNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByShipmentOidNbr", fetchShipmentRemarkByShipmentOidSQL, "" + shipmentOidNbr);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemark fetchByPieceOidNbr(Connection conn, String locationCd, int pieceOidNbr)
        throws SQLException
    {
        try
        {
            fetchShipmentRemarkWithPieceOidNbrStmt = conn.prepareStatement(fetchShipmentRemarkByPieceOidSQL);
            fetchShipmentRemarkWithPieceOidNbrStmt.setString(1, locationCd);
            fetchShipmentRemarkWithPieceOidNbrStmt.setInt(2, pieceOidNbr);
            runQuery(fetchShipmentRemarkWithPieceOidNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchByPieceOidNbr", fetchShipmentRemarkByPieceOidSQL, "" + pieceOidNbr);
            throw ex;
        }
        return fetchNext();
    }

    public ShipmentRemark fetchNext()
        throws SQLException
    {
        ShipmentRemark sr = null;
        try
        {
            if(m_hasMore)
            {
                int shipmentRemarkOidNbr = m_resultSet.getInt(1);
                int shipmentOidNbr = m_resultSet.getInt(2);
                String locationCd = m_resultSet.getString(3);
                String shipmentRemarkCd = m_resultSet.getString(4);
                int pieceOidNbr = m_resultSet.getInt(5);
                String remarkDesc = m_resultSet.getString(6);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(7);
                Date createDt = convertTimestampToDate(createDtTmstp);
                String createEmployeeNbr = m_resultSet.getString(8);
                String createProcessNm = m_resultSet.getString(9);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(10);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                String updateEmployeeNbr = m_resultSet.getString(11);
                String updateProcessNm = m_resultSet.getString(12);
                String agencyCd = m_resultSet.getString(13);
                String agencyLocationCd = m_resultSet.getString(14);
                sr = new ShipmentRemark(shipmentRemarkOidNbr, shipmentOidNbr, locationCd, shipmentRemarkCd, pieceOidNbr, remarkDesc, createDt, createEmployeeNbr, createProcessNm, updateDt, updateEmployeeNbr, updateProcessNm, agencyCd);
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
                sr = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return sr;
    }

    public int getShipmentRemarkRecordCount()
    {
        return m_recordCount;
    }

    public void remove(Connection conn, ShipmentRemark sr)
        throws SQLException
    {
        try
        {
            removeShipmentRemarkStmt = conn.prepareStatement(removeShipmentRemarkSQL);
            removeShipmentRemarkStmt.setInt(1, sr.getShipmentRemarkOidNbr());
            removeShipmentRemarkStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeShipmentRemarkSQL, "" + sr.getShipmentRemarkOidNbr());
            throw ex;
        }
    }

    public void save(Connection conn, ShipmentRemark sr, String locationCd)
        throws SQLException
    {
        try
        {
            saveShipmentRemarkStmt = conn.prepareStatement(saveShipmentRemarkSQL);
            saveShipmentRemarkStmt.setInt(1, sr.getShipmentRemarkOidNbr());
            saveShipmentRemarkStmt.setInt(2, sr.getShipmentOidNbr());
            if(sr.getLocationCd().equals("") || sr.getLocationCd().equals(null))
                saveShipmentRemarkStmt.setString(3, locationCd);
            else
                saveShipmentRemarkStmt.setString(3, sr.getLocationCd());
            saveShipmentRemarkStmt.setString(4, sr.getShipmentRemarkCd());
            saveShipmentRemarkStmt.setInt(5, sr.getPieceOidNbr());
            saveShipmentRemarkStmt.setString(6, sr.getRemarkDesc());
            saveShipmentRemarkStmt.setTimestamp(7, new Timestamp(sr.getCreateDt().getTime()));
            saveShipmentRemarkStmt.setString(8, sr.getCreateEmployeeNbr());
            saveShipmentRemarkStmt.setString(9, sr.getCreateProcessNm());
            saveShipmentRemarkStmt.setTimestamp(10, new Timestamp(sr.getUpdateDt().getTime()));
            saveShipmentRemarkStmt.setString(11, sr.getUpdateEmployeeNbr());
            saveShipmentRemarkStmt.setString(12, sr.getUpdateProcessNm());
            saveShipmentRemarkStmt.setString(13, sr.getAgencyCd());
            if(sr.getAgencyCd().equals("") || sr.getAgencyCd().equals(null))
                saveShipmentRemarkStmt.setString(14, "");
            else
            if(sr.getLocationCd().equals("") || sr.getLocationCd().equals(null))
                saveShipmentRemarkStmt.setString(14, locationCd);
            else
                saveShipmentRemarkStmt.setString(14, sr.getLocationCd());
            saveShipmentRemarkStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveShipmentRemarkSQL, sr.getShipmentRemarkOidNbr() + ", " + sr.getShipmentOidNbr() + ", " + sr.getShipmentRemarkCd() + ", " + sr.getPieceOidNbr() + ", " + sr.getRemarkDesc() + ", " + new Timestamp(sr.getCreateDt().getTime()) + ", " + sr.getCreateEmployeeNbr() + ", " + sr.getCreateProcessNm() + ", " + new Timestamp(sr.getUpdateDt().getTime()) + ", " + sr.getUpdateEmployeeNbr() + ", " + sr.getUpdateProcessNm() + ", " + sr.getAgencyCd() + ", " + locationCd);
            throw ex;
        }
    }

    public void update(Connection conn, ShipmentRemark sr)
        throws SQLException
    {
        try
        {
            updateShipmentRemarkStmt = conn.prepareStatement(updateShipmentRemarkSQL);
            updateShipmentRemarkStmt.setInt(1, sr.getShipmentOidNbr());
            updateShipmentRemarkStmt.setString(2, sr.getLocationCd());
            updateShipmentRemarkStmt.setString(3, sr.getShipmentRemarkCd());
            updateShipmentRemarkStmt.setInt(4, sr.getPieceOidNbr());
            updateShipmentRemarkStmt.setString(5, sr.getRemarkDesc());
            updateShipmentRemarkStmt.setTimestamp(6, new Timestamp(sr.getCreateDt().getTime()));
            updateShipmentRemarkStmt.setString(7, sr.getCreateEmployeeNbr());
            updateShipmentRemarkStmt.setString(8, sr.getCreateProcessNm());
            updateShipmentRemarkStmt.setTimestamp(9, new Timestamp((new Date()).getTime()));
            updateShipmentRemarkStmt.setString(10, sr.getUpdateEmployeeNbr());
            updateShipmentRemarkStmt.setString(11, sr.getUpdateProcessNm());
            updateShipmentRemarkStmt.setString(12, sr.getAgencyCd());
            if(sr.getAgencyCd().equals("") || sr.getAgencyCd().equals(null))
                updateShipmentRemarkStmt.setString(13, "");
            else
                updateShipmentRemarkStmt.setString(13, sr.getLocationCd());
            updateShipmentRemarkStmt.setInt(14, sr.getShipmentRemarkOidNbr());
            updateShipmentRemarkStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchShipmentRemarkSQL, sr.getShipmentOidNbr() + ", " + sr.getLocationCd() + ", " + sr.getShipmentRemarkCd() + ", " + sr.getPieceOidNbr() + ", " + sr.getRemarkDesc() + ", " + new Timestamp(sr.getCreateDt().getTime()) + ", " + sr.getCreateEmployeeNbr() + ", " + sr.getCreateProcessNm() + ", " + new Timestamp((new Date()).getTime()) + ", " + sr.getUpdateEmployeeNbr() + ", " + sr.getUpdateProcessNm() + ", " + sr.getAgencyCd() + ", " + sr.getShipmentRemarkOidNbr());
            throw ex;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbShipmentRemark dbShipmentRemark = new DbShipmentRemark();
        dbShipmentRemark.testDbShipmentRemark(db);
        db.closeConnection();
    }

    private void testDbShipmentRemark(DatabaseBean db)
    {
        ShipmentRemark shipmentRemark = null;
        try
        {
            System.out.println("============Executing INSERT SHP_RMK 111111, SHP_OID_1, LOC4,  CD1");
            db.saveShipmentRemark(new ShipmentRemark(0x1b207, 0x3640e, "LOC4", "CD1", 0x6c81c, "DESC1", null, "CRT_EMP_1", "CRT_PRC_1", null, "EMPLMON", "PROC1", "TK"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting shipmentRemark " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHP_RMK 111111 ");
            shipmentRemark = db.fetchShipmentRemark(0x1b207);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHP_RMK 111111" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHP_OID 222222, PCE_OID 444444 ");
            shipmentRemark = db.fetchShipmentRemarkByShipmentOrPieceOidNbr(0x3640e, 0x6c81c);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHP_OID 222222, PCE_OID 444444" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHP_OID 222222 ");
            shipmentRemark = db.fetchShipmentRemarkByShipmentOidNbr(0x3640e);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHP_OID 222222" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY PCE_OID 444444 ");
            shipmentRemark = db.fetchShipmentRemarkByPieceOidNbr(0x6c81c);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by PCE_OID 444444" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE BY SHP_RMK 111111");
            db.updateShipmentRemark(new ShipmentRemark(0x1b207, 0x3640e, "LOC4", "CD1", 0x6c81c, "DESC2222", null, "CRT_EMP_1", "CRT_PRC_1", null, "EMPLMON", "PROC1", "TK"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while updating SHP_RMK 111111" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHP_RMK 111111 ");
            shipmentRemark = db.fetchShipmentRemark(0x1b207);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHP_RMK 111111" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE SHP_RMK 111111 ");
            db.removeShipmentRemark(new ShipmentRemark(0x1b207, 0x3640e, "LOC4", "CD1", 0x6c81c, "DESC2222", null, "CRT_EMP_1", "CRT_PRC_1", null, "EMPLMON", "PROC1", "TK"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while removeing ShipmentRemark " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHP_RMK 111111 ");
            shipmentRemark = db.fetchShipmentRemark(0x1b207);
            if(shipmentRemark != null)
                System.out.println(shipmentRemark);
            else
                System.out.println("Shipment Remark 111111 was removed!!");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHP_RMK 111111" + e.getMessage());
        }
    }

    private static final String m_whatVersion = "";
    private String SHIPMENT_REMARK;
    private String columns;
    private String fetchShipmentRemarkSQL;
    private String fetchShipmentRemarkByShipmentOrPieceOidSQL;
    private String fetchShipmentRemarkByShipmentOidSQL;
    private String fetchShipmentRemarkByPieceOidSQL;
    private String saveShipmentRemarkSQL;
    private String removeShipmentRemarkSQL;
    private String updateShipmentRemarkSQL;
    private PreparedStatement fetchShipmentRemarkStmt;
    private PreparedStatement fetchShipmentRemarkWithShipmentOrPieceOidNbrStmt;
    private PreparedStatement fetchShipmentRemarkWithShipmentOidNbrStmt;
    private PreparedStatement fetchShipmentRemarkWithPieceOidNbrStmt;
    private PreparedStatement saveShipmentRemarkStmt;
    private PreparedStatement removeShipmentRemarkStmt;
    private PreparedStatement updateShipmentRemarkStmt;
}
