// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbScan.java

package cciij.cciidatabase;

import cciij.cciidata.Scan;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbScan extends DbBase
{

    public DbScan()
    {
        fetchWithScanTypeCd_PieceOid_ShipmentOidSQL = "SELECT SCAN_OID_NBR, PIECE_OID_NBR, SHIPMENT_OID_NBR, SCAN_DT, EMPLOYEE_NBR, SCAN_TYPE_CD, LOC_STAT_NBR, STAGING_AREA_CD, STAGING_AREA_FLG, FROM_CONS_FLG, SORT_DT, SCAN_LOCATION_DESC, LOCATION_CD, WAREHOUSE_CD, INPUT_METHOD_CD, COMMENT_DESC FROM " + SCAN + "WHERE SCAN_TYPE_CD = ? AND " + "PIECE_OID_NBR = ? AND SHIPMENT_OID_NBR = ? AND LOCATION_CD = ? AND SCAN_DT >=?";
        fetchWithScanTypeCd_ShipmentOidSQL = "SELECT SCAN_OID_NBR, PIECE_OID_NBR, SHIPMENT_OID_NBR, SCAN_DT, EMPLOYEE_NBR, SCAN_TYPE_CD, LOC_STAT_NBR, STAGING_AREA_CD, STAGING_AREA_FLG, FROM_CONS_FLG, SORT_DT, SCAN_LOCATION_DESC, LOCATION_CD, WAREHOUSE_CD, INPUT_METHOD_CD, COMMENT_DESC FROM " + SCAN + "WHERE SCAN_TYPE_CD = ? AND " + "SHIPMENT_OID_NBR = ? AND LOCATION_CD = ? AND SCAN_DT >=?";
        fetchScanWithPhysicalCustodySQL = "SELECT S.SCAN_OID_NBR, S.PIECE_OID_NBR, S.SHIPMENT_OID_NBR, S.SCAN_DT, S.EMPLOYEE_NBR, S.SCAN_TYPE_CD, S.LOC_STAT_NBR, S.STAGING_AREA_CD, S.STAGING_AREA_FLG, S.FROM_CONS_FLG, S.SORT_DT, S.SCAN_LOCATION_DESC, S.LOCATION_CD, S.WAREHOUSE_CD, S.INPUT_METHOD_CD, S.COMMENT_DESC FROM " + SCAN + " S, " + SCAN_DEF + "SD " + "WHERE S.SCAN_TYPE_CD = SD.SCAN_TYPE_CD " + "AND S.LOC_STAT_NBR = SD.LOC_STAT_NBR " + "AND S.PIECE_OID_NBR = ? AND S.LOCATION_CD = ? AND SD.PHYSICAL_CUSTODY_SCAN_FLG = 'Y'";
        fetchWithHandlingUnitOidSQL = "SELECT SCAN_OID_NBR, PIECE_OID_NBR, SHIPMENT_OID_NBR, SCAN_DT, EMPLOYEE_NBR, SCAN_TYPE_CD, LOC_STAT_NBR, STAGING_AREA_CD, STAGING_AREA_FLG, FROM_CONS_FLG, SORT_DT, SCAN_LOCATION_DESC, LOCATION_CD, WAREHOUSE_CD, INPUT_METHOD_CD, COMMENT_DESC FROM " + SCAN + "WHERE PIECE_OID_NBR = ? AND LOCATION_CD = ? ORDER BY SCAN_DT ";
        saveScanSQL = "INSERT INTO " + SCAN + " (SCAN_OID_NBR, PIECE_OID_NBR, " + "SHIPMENT_OID_NBR, SCAN_DT, EMPLOYEE_NBR, " + "SCAN_TYPE_CD, LOC_STAT_NBR, STAGING_AREA_CD, " + "STAGING_AREA_FLG, FROM_CONS_FLG, SORT_DT, " + "SCAN_LOCATION_DESC, LOCATION_CD, WAREHOUSE_CD, INPUT_METHOD_CD, " + "COMMENT_DESC ) " + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        removeScanSQL = "DELETE FROM " + SCAN + " WHERE SCAN_OID_NBR = ?";
        updateScanSQL = "UPDATE " + SCAN + " SET " + "SCAN_OID_NBR = ?, PIECE_OID_NBR = ?, " + "SHIPMENT_OID_NBR = ?, SCAN_DT = ?, EMPLOYEE_NBR = ?, " + "SCAN_TYPE_CD = ?, LOC_STAT_NBR = ?, STAGING_AREA_CD = ?, " + "STAGING_AREA_FLG = ?, FROM_CONS_FLG = ?, SORT_DT = ?, " + "SCAN_LOCATION_DESC = ?, LOCATION_CD = ?, " + "WAREHOUSE_CD = ?, INPUT_METHOD_CD = ?, COMMENT_DESC = ?" + "WHERE SCAN_OID_NBR = ?";
        fetchWithScanTypeCd_PieceOid_ShipmentOidStmt = null;
        fetchWithScanTypeCd_ShipmentOidStmt = null;
        fetchWithHandlingUnitOidStmt = null;
        fetchScanWithPhysicalCustodyStmt = null;
        saveScanStmt = null;
        removeScanStmt = null;
        updateScanStmt = null;
    }

    public Scan fetch(Connection conn, String scanTypeCd, int pcOid, int shipOid, String locationCd)
        throws SQLException
    {
        Scan scan = null;
        try
        {
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt = conn.prepareStatement(fetchWithScanTypeCd_PieceOid_ShipmentOidSQL);
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.setString(1, scanTypeCd);
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.setInt(2, pcOid);
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.setInt(3, shipOid);
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.setString(4, locationCd);
            fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            runQuery(fetchWithScanTypeCd_PieceOid_ShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramListStr = scanTypeCd + ", " + pcOid + ", " + shipOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithScanTypeCd_PieceOid_ShipmentOidSQL, paramListStr);
            throw ex;
        }
        scan = fetchNext();
        fetchWithScanTypeCd_PieceOid_ShipmentOidStmt.close();
        return scan;
    }

    public Scan fetch(Connection conn, String scanTypeCd, int shipOid, String locationCd)
        throws SQLException
    {
        Scan scan = null;
        try
        {
            fetchWithScanTypeCd_ShipmentOidStmt = conn.prepareStatement(fetchWithScanTypeCd_ShipmentOidSQL);
            fetchWithScanTypeCd_ShipmentOidStmt.setString(1, scanTypeCd);
            fetchWithScanTypeCd_ShipmentOidStmt.setInt(2, shipOid);
            fetchWithScanTypeCd_ShipmentOidStmt.setString(3, locationCd);
            fetchWithScanTypeCd_ShipmentOidStmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            runQuery(fetchWithScanTypeCd_ShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramListStr = scanTypeCd + ", " + shipOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithScanTypeCd_ShipmentOidSQL, paramListStr);
            throw ex;
        }
        scan = fetchNext();
        fetchWithScanTypeCd_ShipmentOidStmt.close();
        return scan;
    }

    public Scan fetchNext()
        throws SQLException
    {
        Scan scan = new Scan();
        try
        {
            if(m_hasMore)
            {
                int scanOid = m_resultSet.getInt(1);
                int pieceOid = m_resultSet.getInt(2);
                int shipmentOid = m_resultSet.getInt(3);
                Timestamp scanDtTimestamp = m_resultSet.getTimestamp(4);
                String emplNbr = m_resultSet.getString(5);
                String scanTypeCd = m_resultSet.getString(6);
                String locStatNbr = m_resultSet.getString(7);
                String stageAreaCd = m_resultSet.getString(8);
                String stageAreaFlg = m_resultSet.getString(9);
                String fromConsFlg = m_resultSet.getString(10);
                Timestamp sortDtTimestamp = m_resultSet.getTimestamp(11);
                String scanLocDesc = m_resultSet.getString(12);
                String locationCd = m_resultSet.getString(13);
                String warehouseCd = m_resultSet.getString(14);
                String inputMethodCd = m_resultSet.getString(15);
                String commentDesc = m_resultSet.getString(16);
                Date scanDt = convertTimestampToDate(scanDtTimestamp);
                Date sortDt = convertTimestampToDate(sortDtTimestamp);
                scan = new Scan(scanOid, pieceOid, shipmentOid, scanDt, emplNbr, scanTypeCd, locStatNbr, stageAreaCd, stageAreaFlg, fromConsFlg, sortDt, locationCd, warehouseCd, inputMethodCd, commentDesc);
                scan.setScanLocationDescription(scanLocDesc);
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
                scan = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "", "");
            throw ex;
        }
        return scan;
    }

    public Scan fetchWithHUOid(Connection conn, int handlingUnitOid, String locationCd)
        throws SQLException
    {
        Scan scan = null;
        try
        {
            fetchWithHandlingUnitOidStmt = conn.prepareStatement(fetchWithHandlingUnitOidSQL);
            fetchWithHandlingUnitOidStmt.setInt(1, handlingUnitOid);
            fetchWithHandlingUnitOidStmt.setString(2, locationCd);
            runQuery(fetchWithHandlingUnitOidStmt);
        }
        catch(SQLException ex)
        {
            String paramListStr = handlingUnitOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchWithHandlingUnitOidSQL, paramListStr);
            throw ex;
        }
        scan = fetchNext();
        fetchWithHandlingUnitOidStmt.close();
        return scan;
    }

    public Scan fetchWithPhysicalCustody(Connection conn, int handlingUnitOid, String locationCd)
        throws SQLException
    {
        Scan scan = null;
        try
        {
            fetchScanWithPhysicalCustodyStmt = conn.prepareStatement(fetchScanWithPhysicalCustodySQL);
            fetchScanWithPhysicalCustodyStmt.setInt(1, handlingUnitOid);
            fetchScanWithPhysicalCustodyStmt.setString(2, locationCd);
            runQuery(fetchScanWithPhysicalCustodyStmt);
        }
        catch(SQLException ex)
        {
            String paramListStr = handlingUnitOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchScanWithPhysicalCustodySQL, paramListStr);
            throw ex;
        }
        scan = fetchNext();
        fetchScanWithPhysicalCustodyStmt.close();
        return scan;
    }

    public int getScanRecordCount()
    {
        return m_recordCount;
    }

    public void remove(Connection conn, Scan scan)
        throws SQLException
    {
        try
        {
            removeScanStmt = conn.prepareStatement(removeScanSQL);
            removeScanStmt.setInt(1, scan.getScanOidNumber());
            removeScanStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeScanSQL, (new Integer(scan.getScanOidNumber())).toString());
            throw ex;
        }
    }

    public void save(Connection conn, Scan scan, String locationCd)
        throws SQLException
    {
        //Timestamp scanDtTimestamp = new Timestamp(new Date().getTime()) ;
        //Timestamp sortDtTimestamp = new Timestamp(new Date().getTime());
        try
        {
            saveScanStmt = conn.prepareStatement(saveScanSQL);
//            scanDtTimestamp = new Timestamp(scan.getScanDate().getTime());
//            sortDtTimestamp = new Timestamp(scan.getSortDate().getTime());
            saveScanStmt.setInt(1, scan.getScanOidNumber());
            saveScanStmt.setInt(2, scan.getPieceOidNumber());
            saveScanStmt.setInt(3, scan.getShipmentOidNumber());
            saveScanStmt.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
//            saveScanStmt.setTimestamp(4, new java.sql.Date(new java.util.Date().getTime()));
            saveScanStmt.setString(5, scan.getEmployeeNumber());
            saveScanStmt.setString(6, scan.getScanTypeCode());
            saveScanStmt.setString(7, scan.getLocStatNumber());
            saveScanStmt.setString(8, scan.getStagingAreaCode());
            saveScanStmt.setString(9, scan.getStagingAreaFlag());
            saveScanStmt.setString(10, scan.getFromConsFlag());
            saveScanStmt.setTimestamp(11,new Timestamp(System.currentTimeMillis()));
//            saveScanStmt.setDate(11, new java.sql.Date(new java.util.Date().getTime()));
            saveScanStmt.setString(12, scan.getScanLocationDescription());
            if(scan.getLocationCd().equals("") || scan.getLocationCd().equals(null))
                saveScanStmt.setString(13, locationCd);
            else
                saveScanStmt.setString(13, scan.getLocationCd());
            saveScanStmt.setString(14, scan.getWarehouseCd());
            saveScanStmt.setString(15, scan.getInputMethodCode());
            saveScanStmt.setString(16, scan.getCommentDescription());
            saveScanStmt.executeUpdate();
            saveScanStmt.close();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveScanSQL, scan.getScanOidNumber() + ", " + scan.getPieceOidNumber() + ", " + scan.getShipmentOidNumber() + ", " +  ", " + scan.getEmployeeNumber() + ", " + scan.getScanTypeCode() + ", " + scan.getLocStatNumber() + ", " + scan.getStagingAreaCode() + ", " + scan.getStagingAreaFlag() + ", " + scan.getFromConsFlag() + ", " +  ", " + scan.getScanLocationDescription() + ", " + locationCd + ", " + scan.getWarehouseCd() + ", " + scan.getInputMethodCode() + ", " + scan.getCommentDescription());
            throw ex;
        }
    }

    public void update(Connection conn, Scan scan)
        throws SQLException
    {
//        Timestamp scanDtTimestamp = null;
//        Timestamp sortDtTimestamp = null;
        try
        {
            updateScanStmt = conn.prepareStatement(updateScanSQL);
  //          scanDtTimestamp = new Timestamp(scan.getScanDate().getTime());
  //          sortDtTimestamp = new Timestamp(scan.getSortDate().getTime());
            updateScanStmt.setInt(1, scan.getScanOidNumber());
            updateScanStmt.setInt(2, scan.getPieceOidNumber());
            updateScanStmt.setInt(3, scan.getShipmentOidNumber());
            updateScanStmt.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            //updateScanStmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            updateScanStmt.setString(5, scan.getEmployeeNumber());
            updateScanStmt.setString(6, scan.getScanTypeCode());
            updateScanStmt.setString(7, scan.getLocStatNumber());
            updateScanStmt.setString(8, scan.getStagingAreaCode());
            updateScanStmt.setString(9, scan.getStagingAreaFlag());
            updateScanStmt.setString(10, scan.getFromConsFlag());
            updateScanStmt.setTimestamp(11,new Timestamp(System.currentTimeMillis()));
//            updateScanStmt.setDate(11, new java.sql.Date(new java.util.Date().getTime()));
            updateScanStmt.setString(12, scan.getScanLocationDescription());
            updateScanStmt.setString(13, scan.getLocationCd());
            updateScanStmt.setString(14, scan.getWarehouseCd());
            updateScanStmt.setString(15, scan.getInputMethodCode());
            updateScanStmt.setString(16, scan.getCommentDescription());
            updateScanStmt.setInt(17, scan.getScanOidNumber());
            updateScanStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateScanSQL, scan.getScanOidNumber() + ", " + scan.getPieceOidNumber() + ", " + scan.getShipmentOidNumber() + ", " +  ", " + scan.getEmployeeNumber() + ", " + scan.getScanTypeCode() + ", " + scan.getLocStatNumber() + ", " + scan.getStagingAreaCode() + ", " + scan.getStagingAreaFlag() + ", " + scan.getFromConsFlag() + ", " +  ", " + scan.getScanLocationDescription() + ", " + scan.getLocationCd() + ", " + scan.getWarehouseCd() + ", " + scan.getScanOidNumber() + ", " + scan.getInputMethodCode() + ", " + scan.getCommentDescription());
            throw ex;
        }
    }

    private void testDbScan(DatabaseBean db)
    {
        Scan scan = null;
        try
        {
            System.out.println("===============Executing SELECT  ");
            if((scan = db.fetchScan("STO", 5621, 53221)) != null)
                System.out.println(scan);
            while((scan = db.fetchNextScan()) != null) 
                System.out.println(scan);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all dbScans " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY PIECE_OID_NBR");
            scan = db.fetchScanWithHandlingUnitOid(5621);
            if(scan != null)
                System.out.println(scan);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting nextoids by nextoidnbr " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing INSERT  60000");
            db.saveScan(new Scan(60000, 5621, 53221, new Date(), "Monica", "STO", "", "", "", "", new Date(), "LOCA", "WH1", "XX", "COMMENT"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE Scan 60000");
            db.updateScan(new Scan(60000, 5621, 53221, new Date(), "Monica", "STO", "", "", "", "", new Date(), "LOCA", "WH1", "XX", "COMMENT"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE Scan 60000");
            db.removeScan(new Scan(60000, 5621, 53221, new Date(), "Monica", "STO", "", "", "", "", new Date(), "LOCA", "WH1", "XX", "COMMENT"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting nextOid " + e.getMessage());
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("YYZ");
        db.connect();
        DbScan dbScan = new DbScan();
        dbScan.testDbScan(db);
        db.closeConnection();
    }

    private static String SCAN = "SCAN ";
    private static String SCAN_DEF = "SCAN_DEF ";
    private static final String m_whatVersion = "@(#) $RCSfile: DbScan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchWithScanTypeCd_PieceOid_ShipmentOidSQL;
    private String fetchWithScanTypeCd_ShipmentOidSQL;
    private String fetchScanWithPhysicalCustodySQL;
    private String fetchWithHandlingUnitOidSQL;
    private String saveScanSQL;
    private String removeScanSQL;
    private String updateScanSQL;
    private PreparedStatement fetchWithScanTypeCd_PieceOid_ShipmentOidStmt;
    private PreparedStatement fetchWithScanTypeCd_ShipmentOidStmt;
    private PreparedStatement fetchWithHandlingUnitOidStmt;
    private PreparedStatement fetchScanWithPhysicalCustodyStmt;
    private PreparedStatement saveScanStmt;
    private PreparedStatement removeScanStmt;
    private PreparedStatement updateScanStmt;

}
