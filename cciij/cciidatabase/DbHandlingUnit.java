// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbHandlingUnit.java

package cciij.cciidatabase;

import cciij.cciidata.HandlingUnit;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbHandlingUnit extends DbBase
{

    public DbHandlingUnit()
    {
        schema_name = "ENT.";
        fetchPickListSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ?  AND pcc.WAREHOUSE_CD = ?  AND  pcc.STAGING_AREA_CD = ?  AND NOT exists ( SELECT I.SHIPMENT_OID_NBR    FROM INTERCEPT I, INTERCEPT_DEF ID, " + schema_name + "INTERCEPT_STAGING_AREA ISA " + "   WHERE ACTIVE_FLG = 'Y' " + "   AND I.INTERCEPT_CD = ID.INTERCEPT_CD " + "   AND I.INTERCEPT_LOCATION_CD = ID.LOCATION_CD " + "   AND ID.INTERCEPT_CD = ISA.INTERCEPT_CD " + "   AND ID.LOCATION_CD = ISA.LOCATION_CD " + "   AND ISA.WAREHOUSE_CD = ? " + "   AND ISA.STAGING_AREA_CD = ? " + "   AND I.SHIPMENT_OID_NBR = p.SHIPMENT_OID_NBR) " + "   AND NOT exists " + "( SELECT I2.PIECE_OID_NBR " + "   FROM INTERCEPT I2, INTERCEPT_DEF ID2, " + schema_name + "INTERCEPT_STAGING_AREA ISA2 " + "   WHERE ACTIVE_FLG = 'Y' " + "   AND I2.INTERCEPT_CD = ID2.INTERCEPT_CD " + "   AND I2.INTERCEPT_LOCATION_CD = ID2.LOCATION_CD " + "   AND ID2.INTERCEPT_CD = ISA2.INTERCEPT_CD " + "   AND ID2.LOCATION_CD = ISA2.LOCATION_CD " + "   AND ISA2.WAREHOUSE_CD = ? " + "   AND ISA2.STAGING_AREA_CD = ? " + "   AND I2.PIECE_OID_NBR = p.PIECE_OID_NBR)";
        saveHandlingUnitSQL = "INSERT INTO PIECE(PIECE_OID_NBR, TRACKING_NBR, FORM_TYPE_CD, SHIPMENT_OID_NBR, HARMONIZED_TARIFF_NBR, TOTAL_WGT, TOTAL_WGT_TYPE_CD, CUSTOMS_VALUE_AMT, ENTRY_STATUS_CD, AWB_TYPE_CD, TRANSACTION_SEQ_TMSTP, MANIFEST_STATUS_CD, PIECE_STATUS_CD, DEST_LOCATION_CD ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        saveCoreHandlingUnitSQL = "INSERT INTO PIECE_CORE_CLEARANCE(PIECE_OID_NBR, ENTRY_CATEGORY_TYPE_CD, RECURRING_SELECT_FLG, LAST_MODIFIED_TMSTP, LAST_USER_NM, DETAINMENT_LOCATION_CD, OVERAGE_REASON_CD, TRAVEL_STATUS_CD, STAGING_AREA_CD, LOCATION_CD, WAREHOUSE_CD, SHUTTLE_CD ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        removeHandlingUnitSQL = "DELETE FROM PIECE WHERE PIECE_OID_NBR = ?";
        removeCoreHandlingUnitSQL = "DELETE FROM PIECE_CORE_CLEARANCE WHERE PIECE_OID_NBR = ? AND PIECE_CORE_CLEARANCE.LOCATION_CD LIKE ? ";
        updateHandlingUnitSQL = "UPDATE PIECE SET TRACKING_NBR = ?, FORM_TYPE_CD = ?, SHIPMENT_OID_NBR = ?, HARMONIZED_TARIFF_NBR = ?, TOTAL_WGT = ?, TOTAL_WGT_TYPE_CD = ?, CUSTOMS_VALUE_AMT = ?, ENTRY_STATUS_CD = ?, AWB_TYPE_CD = ?, TRANSACTION_SEQ_TMSTP = ?, MANIFEST_STATUS_CD = ?, PIECE_STATUS_CD = ?, DEST_LOCATION_CD = ? WHERE PIECE_OID_NBR = ?";
        updateCoreHandlingUnitSQL = "UPDATE PIECE_CORE_CLEARANCE SET LAST_MODIFIED_TMSTP = ?, LAST_USER_NM = ?, DETAINMENT_LOCATION_CD = ?, OVERAGE_REASON_CD = ?, TRAVEL_STATUS_CD = ?, STAGING_AREA_CD = ?, WAREHOUSE_CD = ?, SHUTTLE_CD = ?  WHERE PIECE_OID_NBR = ? AND LOCATION_CD = ? ";
        fetchWithPieceOidStmt = null;
        fetchWithPieceOidAllowNullLocationStmt = null;
        fetchWithShipmentOidStmt = null;
        fetchWithShipmentOidAndTrackingNbrStmt = null;
        fetchSingleLocWithTrackingNbrStmt = null;
        fetchLocListWithTrackingNbrStmt = null;
        fetchPickListStmt = null;
        fetchAllNonScannedPiecesOnRouteStmt = null;
        saveHandlingUnitStmt = null;
        saveCoreHandlingUnitStmt = null;
        removeHandlingUnitStmt = null;
        removeCoreHandlingUnitStmt = null;
        updateHandlingUnitStmt = null;
        updateCoreHandlingUnitStmt = null;
    }

    public int getHandlingUnitRecordCount()
    {
        return m_recordCount;
    }

    public HandlingUnit fetch(Connection conn, int pieceOid, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithPieceOidStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC, SHIPMENT SH WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND SH.SHIPMENT_OID_NBR=P.SHIPMENT_OID_NBR AND SH.SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999 AND PCC.LOCATION_CD = ? AND P.PIECE_OID_NBR = ?");
            fetchWithPieceOidStmt.setInt(2, pieceOid);
            fetchWithPieceOidStmt.setString(1, locationCode);
            runQuery(fetchWithPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + pieceOid;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.PIECE_OID_NBR = ?", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchAllowNullLocation(Connection conn, int pieceOid, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithPieceOidAllowNullLocationStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND P.PIECE_OID_NBR = ? ");
            fetchWithPieceOidAllowNullLocationStmt.setInt(2, pieceOid);
            fetchWithPieceOidAllowNullLocationStmt.setString(1, locationCode);
            runQuery(fetchWithPieceOidAllowNullLocationStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + pieceOid;
            printSQLException(ex, getClass().getName(), "fetchAllowNullLocation", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND P.PIECE_OID_NBR = ? ", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchAllNonScannedPiecesOnRoute(Connection conn, String routeNbr, java.util.Date routeDt, int routeLegNbr, String locationCode)
        throws SQLException
    {
        Date tmpRouteDt = new Date(routeDt.getTime());
        try
        {
            fetchAllNonScannedPiecesOnRouteStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM ccii.PIECE P, ccii.PIECE_CORE_CLEARANCE PCC, ccii.PIECE_ROUTE_LEG prl  WHERE  pcc.location_cd = ?  and prl.route_nbr = ? and prl.route_dt = ? and prl.route_leg_nbr = ? and prl.piece_oid_nbr = p.piece_oid_nbr and p.piece_oid_nbr = pcc.piece_oid_nbr and not exists    ( select distinct s.piece_oid_nbr     from ccii.scan s, ccii.scan_def sd     where       p.piece_oid_nbr = s.piece_oid_nbr       and s.scan_type_cd = sd.scan_type_cd       and s.loc_stat_nbr = sd.loc_stat_nbr       and s.location_cd = sd.location_cd       and sd.physical_custody_scan_flg = 'Y' ) ORDER BY p.piece_oid_nbr");
            fetchAllNonScannedPiecesOnRouteStmt.setString(1, locationCode);
            fetchAllNonScannedPiecesOnRouteStmt.setString(2, routeNbr);
            fetchAllNonScannedPiecesOnRouteStmt.setDate(3, tmpRouteDt);
            fetchAllNonScannedPiecesOnRouteStmt.setInt(4, routeLegNbr);
            runQuery(fetchAllNonScannedPiecesOnRouteStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + routeNbr + ", " + routeDt + ", " + routeLegNbr;
            printSQLException(ex, getClass().getName(), "fetchAllNonScannedPiecesOnRoute", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM ccii.PIECE P, ccii.PIECE_CORE_CLEARANCE PCC, ccii.PIECE_ROUTE_LEG prl  WHERE  pcc.location_cd = ?  and prl.route_nbr = ? and prl.route_dt = ? and prl.route_leg_nbr = ? and prl.piece_oid_nbr = p.piece_oid_nbr and p.piece_oid_nbr = pcc.piece_oid_nbr and not exists    ( select distinct s.piece_oid_nbr     from ccii.scan s, ccii.scan_def sd     where       p.piece_oid_nbr = s.piece_oid_nbr       and s.scan_type_cd = sd.scan_type_cd       and s.loc_stat_nbr = sd.loc_stat_nbr       and s.location_cd = sd.location_cd       and sd.physical_custody_scan_flg = 'Y' ) ORDER BY p.piece_oid_nbr", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchHandlingUnitWithShipmentOid(Connection conn, int shipOid, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOidStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC, SHIPMENT SH WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND SH.SHIPMENT_OID_NBR=P.SHIPMENT_OID_NBR AND SH.SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999 AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ?");
            fetchWithShipmentOidStmt.setString(1, locationCode);
            fetchWithShipmentOidStmt.setInt(2, shipOid);
            runQuery(fetchWithShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + shipOid;
            printSQLException(ex, getClass().getName(), "fetchHandlingUnitWithShipmentOid", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ?", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchHandlingUnitWithShipmentOidAndTrackingNbr(Connection conn, int shipOid, String trackingNbr, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOidAndTrackingNbrStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC,SHIPMENT SH WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND SH.SHIPMENT_OID_NBR=P.SHIPMENT_OID_NBR AND SH.SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999 AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ? AND TRACKING_NBR = ?");
            fetchWithShipmentOidAndTrackingNbrStmt.setString(1, locationCode);
            fetchWithShipmentOidAndTrackingNbrStmt.setInt(2, shipOid);
            fetchWithShipmentOidAndTrackingNbrStmt.setString(3, trackingNbr);
            runQuery(fetchWithShipmentOidAndTrackingNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + shipOid + ", " + trackingNbr;
            printSQLException(ex, getClass().getName(), "fetchHandlingUnitWithShipmentOidAndTrackingNbr", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ? AND TRACKING_NBR = ?", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchPickList(Connection conn, String stagingAreaCd, String locationCode, String warehouseCode)
        throws SQLException
    {
        try
        {
            fetchPickListStmt = conn.prepareStatement(fetchPickListSQL);
            System.out.println(fetchPickListStmt.toString());
            fetchPickListStmt.setString(1, locationCode);
            fetchPickListStmt.setString(2, warehouseCode);
            fetchPickListStmt.setString(3, stagingAreaCd);
            fetchPickListStmt.setString(4, warehouseCode);
            fetchPickListStmt.setString(5, stagingAreaCd);
            fetchPickListStmt.setString(6, warehouseCode);
            fetchPickListStmt.setString(7, stagingAreaCd);
            runQuery(fetchPickListStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + warehouseCode + ", " + stagingAreaCd + ", " + warehouseCode + ", " + stagingAreaCd + ", " + warehouseCode + ", " + stagingAreaCd;
            printSQLException(ex, getClass().getName(), "fetchPickList", fetchPickListSQL, paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetch(Connection conn, String trackingNbr, String locationCode)
        throws SQLException
    {
        try
        {
            fetchSingleLocWithTrackingNbrStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC,SHIPMENT SH WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND SH.SHIPMENT_OID_NBR=P.SHIPMENT_OID_NBR AND SH.SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999 AND PCC.LOCATION_CD = ?  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ");
            fetchSingleLocWithTrackingNbrStmt.setString(1, locationCode);
            fetchSingleLocWithTrackingNbrStmt.setString(2, trackingNbr);
            runQuery(fetchSingleLocWithTrackingNbrStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + trackingNbr;
            printSQLException(ex, getClass().getName(), "fetch", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ?  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetch(Connection conn, String trackingNbr, String locationCode, String locationList[])
        throws SQLException
    {
        String paramList = "";
        try
        {
            fetchLocListWithTrackingNbrStmt = conn.prepareStatement("SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC,SHIPMENT SH WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+) AND SH.SHIPMENT_OID_NBR=P.SHIPMENT_OID_NBR AND SH.SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999 AND PCC.LOCATION_CD(+) = ?  AND exists (SELECT * FROM PIECE_CORE_CLEARANCE PCC2                WHERE PCC2.PIECE_OID_NBR = P.PIECE_OID_NBR                AND PCC2.LOCATION_CD in (?,?,?,?,?,?,?,?,?,?))  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ");
            fetchLocListWithTrackingNbrStmt.setString(1, locationCode);
            paramList = locationCode + ", ";
            for(int i = 0; i < 10; i++)
                if(i < locationList.length)
                {
                    fetchLocListWithTrackingNbrStmt.setString(i + 2, locationList[i]);
                    paramList = paramList + locationList[i] + ", ";
                } else
                {
                    fetchLocListWithTrackingNbrStmt.setString(i + 2, locationList[0]);
                    paramList = paramList + locationList[0] + ", ";
                }

            fetchLocListWithTrackingNbrStmt.setString(12, trackingNbr);
            paramList = paramList + trackingNbr;
            runQuery(fetchLocListWithTrackingNbrStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND exists (SELECT * FROM PIECE_CORE_CLEARANCE PCC2                WHERE PCC2.PIECE_OID_NBR = P.PIECE_OID_NBR                AND PCC2.LOCATION_CD in (?,?,?,?,?,?,?,?,?,?))  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ", paramList);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public HandlingUnit fetchNext(String dbBeanLocationCode)
        throws SQLException
    {
        HandlingUnit handlingUnit = new HandlingUnit();
        try
        {
            if(m_hasMore)
            {
                int pcOid = m_resultSet.getInt(1);
                String trkNbr = m_resultSet.getString(2);
                String frmTypeCd = m_resultSet.getString(3);
                int shipOid = m_resultSet.getInt(4);
                String harmonizedTarrif = m_resultSet.getString(5);
                float totalWgt = m_resultSet.getFloat(6);
                String totalWgtTypeCd = m_resultSet.getString(7);
                double customValAmt = m_resultSet.getDouble(8);
                String entryStatCd = m_resultSet.getString(9);
                String awbTypeCd = m_resultSet.getString(10);
                String detainLocDesc = m_resultSet.getString(11);
                Timestamp lastModTmstp = m_resultSet.getTimestamp(12);
                String lastUsrNm = m_resultSet.getString(13);
                String entryCatTypeCd = m_resultSet.getString(14);
                String recurFlg = m_resultSet.getString(15);
                String overReasonCd = m_resultSet.getString(16);
                String travelStatusCd = m_resultSet.getString(17);
                String stgAreaCd = m_resultSet.getString(18);
                String warehouseCode = m_resultSet.getString(19);
                Timestamp transSeqTmstp = m_resultSet.getTimestamp(20);
                String manifestStatusCd = m_resultSet.getString(21);
                String pieceStatusCd = m_resultSet.getString(22);
                String locationCode = m_resultSet.getString(23);
                int pccOidNbr = m_resultSet.getInt(24);
                boolean nullCoreClearance = m_resultSet.wasNull();
                String destLocationCd = m_resultSet.getString(25);
                String shuttleCode = m_resultSet.getString(26);
                java.util.Date lastModDt = convertTimestampToDate(lastModTmstp);
                java.util.Date transDt = convertTimestampToDate(transSeqTmstp);
                handlingUnit = new HandlingUnit(pcOid, trkNbr, frmTypeCd, shipOid, harmonizedTarrif, totalWgt, totalWgtTypeCd, customValAmt, entryStatCd, awbTypeCd, detainLocDesc, manifestStatusCd, pieceStatusCd);
                handlingUnit.setLastModifiedTimeStamp(lastModDt);
                handlingUnit.setLastUserName(lastUsrNm);
                handlingUnit.setEntryCategoryTypeCode(entryCatTypeCd);
                handlingUnit.setRecurringSelectFlag(recurFlg);
                handlingUnit.setOverageReasonCode(overReasonCd);
                handlingUnit.setTravelStatus(travelStatusCd);
                handlingUnit.setStagingAreaCode(stgAreaCd);
                handlingUnit.setWarehouseCode(warehouseCode);
                handlingUnit.setTransactionSequenceTimestamp(transDt);
                handlingUnit.setLocationCode(locationCode);
                handlingUnit.setNullCoreClearance(nullCoreClearance);
                handlingUnit.setDestLocationCd(destLocationCd);
                handlingUnit.setShuttleCode(shuttleCode);
                if(nullCoreClearance)
                    handlingUnit.setLocationCode(dbBeanLocationCode);
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
                handlingUnit = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNex()", " ", " ");
            throw ex;
        }
        return handlingUnit;
    }

    public void save(Connection conn, HandlingUnit hu, String locationCode)
        throws SQLException
    {
        Timestamp transSeqTimestamp = new Timestamp(hu.getTransactionSequenceTimestamp().getTime());
        try
        {
            saveHandlingUnitStmt = conn.prepareStatement(saveHandlingUnitSQL);
            saveHandlingUnitStmt.setInt(1, hu.getHandlingUnitOidNumber());
            saveHandlingUnitStmt.setString(2, hu.getTrackingNumber());
            saveHandlingUnitStmt.setString(3, hu.getFormTypeCode());
            saveHandlingUnitStmt.setInt(4, hu.getShipmentOidNumber());
            saveHandlingUnitStmt.setString(5, hu.getHarmonizedTariffNumber());
            saveHandlingUnitStmt.setFloat(6, hu.getTotalWeight());
            saveHandlingUnitStmt.setString(7, hu.getTotalWeightTypeCode());
            saveHandlingUnitStmt.setDouble(8, hu.getCustomsValueAmount());
            saveHandlingUnitStmt.setString(9, hu.getEntryStatusCode());
            saveHandlingUnitStmt.setString(10, hu.getAirbillTypeCode());
            saveHandlingUnitStmt.setTimestamp(11, transSeqTimestamp);
            saveHandlingUnitStmt.setString(12, hu.getManifestStatusCode());
            saveHandlingUnitStmt.setString(13, hu.getPieceStatusCode());
            saveHandlingUnitStmt.setString(14, hu.getDestLocationCd());
            saveHandlingUnitStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hu.getHandlingUnitOidNumber() + ", " + hu.getTrackingNumber() + ", " + hu.getFormTypeCode() + ", " + hu.getShipmentOidNumber() + ", " + hu.getHarmonizedTariffNumber() + ", " + hu.getTotalWeight() + ", " + hu.getTotalWeightTypeCode() + ", " + hu.getCustomsValueAmount() + ", " + hu.getEntryStatusCode() + ", " + hu.getAirbillTypeCode() + ", " + transSeqTimestamp + ", " + hu.getManifestStatusCode() + ", " + hu.getPieceStatusCode() + ", " + hu.getDestLocationCd();
            printSQLException(ex, getClass().getName(), "save", saveHandlingUnitSQL, paramList);
            throw ex;
        }
        saveCoreClearance(conn, hu, locationCode);
    }

    public void saveCoreClearance(Connection conn, HandlingUnit hu, String locationCode)
        throws SQLException
    {
        Timestamp lastModifiedTimestamp = new Timestamp(hu.getLastModifiedTimeStamp().getTime());
        try
        {
            saveCoreHandlingUnitStmt = conn.prepareStatement(saveCoreHandlingUnitSQL);
            saveCoreHandlingUnitStmt.setInt(1, hu.getHandlingUnitOidNumber());
            saveCoreHandlingUnitStmt.setString(2, hu.getEntryCategoryTypeCode());
            saveCoreHandlingUnitStmt.setString(3, hu.getRecurringSelectFlag());
            saveCoreHandlingUnitStmt.setTimestamp(4, lastModifiedTimestamp);
            saveCoreHandlingUnitStmt.setString(5, hu.getLastUserName());
            saveCoreHandlingUnitStmt.setString(6, hu.getDetainmentLocationDescription());
            saveCoreHandlingUnitStmt.setString(7, hu.getOverageReasonCode());
            saveCoreHandlingUnitStmt.setString(8, hu.getTravelStatus());
            saveCoreHandlingUnitStmt.setString(9, hu.getStagingAreaCode());
            if(hu.getLocationCode() == null || hu.getLocationCode().equals(""))
                saveCoreHandlingUnitStmt.setString(10, locationCode);
            else
                saveCoreHandlingUnitStmt.setString(10, hu.getLocationCode());
            saveCoreHandlingUnitStmt.setString(11, hu.getWarehouseCode());
            saveCoreHandlingUnitStmt.setString(12, hu.getShuttleCode());
            saveCoreHandlingUnitStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hu.getHandlingUnitOidNumber() + ", " + hu.getEntryCategoryTypeCode() + ", " + hu.getRecurringSelectFlag() + ", " + lastModifiedTimestamp + ", " + hu.getLastUserName() + ", " + hu.getDetainmentLocationDescription() + ", " + hu.getOverageReasonCode() + ", " + hu.getTravelStatus() + ", " + hu.getStagingAreaCode() + ", ";
            if(hu.getLocationCode() == null || hu.getLocationCode().equals(""))
                paramList = paramList + locationCode + ", " + hu.getWarehouseCode();
            else
                paramList = paramList + hu.getLocationCode() + ", " + hu.getWarehouseCode();
            printSQLException(ex, getClass().getName(), "saveCoreClearance", saveCoreHandlingUnitSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, HandlingUnit hu)
        throws SQLException
    {
        try
        {
            removeHandlingUnitStmt = conn.prepareStatement(removeHandlingUnitSQL);
            removeHandlingUnitStmt.setInt(1, hu.getHandlingUnitOidNumber());
            removeHandlingUnitStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(hu.getHandlingUnitOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeHandlingUnitSQL, paramList);
            throw ex;
        }
        removeAllCoreClearance(conn, hu);
    }

    public void removeCoreClearance(Connection conn, HandlingUnit hu, String locationCode)
        throws SQLException
    {
        try
        {
            removeCoreHandlingUnitStmt = conn.prepareStatement(removeCoreHandlingUnitSQL);
            removeCoreHandlingUnitStmt.setInt(1, hu.getHandlingUnitOidNumber());
            if(hu.getLocationCode() == null || hu.getLocationCode().equals(""))
                removeCoreHandlingUnitStmt.setString(2, locationCode);
            else
                removeCoreHandlingUnitStmt.setString(2, hu.getLocationCode());
            removeCoreHandlingUnitStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList;
            if(hu.getLocationCode() == null || hu.getLocationCode().equals(""))
                paramList = hu.getHandlingUnitOidNumber() + locationCode;
            else
                paramList = hu.getHandlingUnitOidNumber() + hu.getLocationCode();
            printSQLException(ex, getClass().getName(), "removeCoreClearance", removeCoreHandlingUnitSQL, paramList);
            throw ex;
        }
    }

    public void removeAllCoreClearance(Connection conn, HandlingUnit hu)
        throws SQLException
    {
        try
        {
            removeCoreHandlingUnitStmt = conn.prepareStatement(removeCoreHandlingUnitSQL);
            removeCoreHandlingUnitStmt.setInt(1, hu.getHandlingUnitOidNumber());
            removeCoreHandlingUnitStmt.setString(2, "%");
            removeCoreHandlingUnitStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = hu.getHandlingUnitOidNumber() + ", " + "%";
            printSQLException(ex, getClass().getName(), "removeAllCoreClearance", removeCoreHandlingUnitSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, HandlingUnit hu, String locationCode)
        throws SQLException
    {
        Timestamp transSeqTimestamp = new Timestamp(hu.getTransactionSequenceTimestamp().getTime());
        try
        {
            updateHandlingUnitStmt = conn.prepareStatement(updateHandlingUnitSQL);
            updateHandlingUnitStmt.setString(1, hu.getTrackingNumber());
            updateHandlingUnitStmt.setString(2, hu.getFormTypeCode());
            updateHandlingUnitStmt.setInt(3, hu.getShipmentOidNumber());
            updateHandlingUnitStmt.setString(4, hu.getHarmonizedTariffNumber());
            updateHandlingUnitStmt.setFloat(5, hu.getTotalWeight());
            updateHandlingUnitStmt.setString(6, hu.getTotalWeightTypeCode());
            updateHandlingUnitStmt.setDouble(7, hu.getCustomsValueAmount());
            updateHandlingUnitStmt.setString(8, hu.getEntryStatusCode());
            updateHandlingUnitStmt.setString(9, hu.getAirbillTypeCode());
            updateHandlingUnitStmt.setTimestamp(10, transSeqTimestamp);
            updateHandlingUnitStmt.setString(11, hu.getManifestStatusCode());
            updateHandlingUnitStmt.setString(12, hu.getPieceStatusCode());
            updateHandlingUnitStmt.setString(13, hu.getDestLocationCd());
            updateHandlingUnitStmt.setInt(14, hu.getHandlingUnitOidNumber());
            updateHandlingUnitStmt.execute();
        }
        catch(SQLException ex)
        {
            String paramList = hu.getTrackingNumber() + ", " + hu.getFormTypeCode() + ", " + hu.getShipmentOidNumber() + ", " + hu.getHarmonizedTariffNumber() + ", " + hu.getTotalWeight() + ", " + hu.getTotalWeightTypeCode() + ", " + hu.getCustomsValueAmount() + ", " + hu.getEntryStatusCode() + ", " + hu.getEntryStatusCode() + ", " + transSeqTimestamp + ", " + hu.getManifestStatusCode() + ", " + hu.getPieceStatusCode() + ", " + hu.getDestLocationCd() + ", " + hu.getHandlingUnitOidNumber();
            printSQLException(ex, getClass().getName(), "update", updateHandlingUnitSQL, paramList);
            throw ex;
        }
        updateCoreClearance(conn, hu, locationCode);
    }

    public void updateCoreClearance(Connection conn, HandlingUnit hu, String locationCode)
        throws SQLException
    {
        if(hu.getNullCoreClearance())
        {
            saveCoreClearance(conn, hu, locationCode);
        } else
        {
            Timestamp lastModifiedTimestamp = new Timestamp(hu.getLastModifiedTimeStamp().getTime());
            try
            {
                updateCoreHandlingUnitStmt = conn.prepareStatement(updateCoreHandlingUnitSQL);
                updateCoreHandlingUnitStmt.setTimestamp(1, lastModifiedTimestamp);
                updateCoreHandlingUnitStmt.setString(2, hu.getLastUserName());
                updateCoreHandlingUnitStmt.setString(3, hu.getDetainmentLocationDescription());
                updateCoreHandlingUnitStmt.setString(4, hu.getOverageReasonCode());
                updateCoreHandlingUnitStmt.setString(5, hu.getTravelStatus());
                updateCoreHandlingUnitStmt.setString(6, hu.getStagingAreaCode());
                updateCoreHandlingUnitStmt.setString(7, hu.getWarehouseCode());
                updateCoreHandlingUnitStmt.setString(8, hu.getShuttleCode());
                updateCoreHandlingUnitStmt.setInt(9, hu.getHandlingUnitOidNumber());
                updateCoreHandlingUnitStmt.setString(10, hu.getLocationCode());
                updateCoreHandlingUnitStmt.executeUpdate();
            }
            catch(SQLException ex)
            {
                String paramList = lastModifiedTimestamp + ", " + hu.getLastUserName() + ", " + hu.getDetainmentLocationDescription() + ", " + hu.getOverageReasonCode() + ", " + hu.getTravelStatus() + ", " + hu.getStagingAreaCode() + ", " + hu.getWarehouseCode() + ", " + hu.getHandlingUnitOidNumber() + ", " + hu.getLocationCode();
                printSQLException(ex, getClass().getName(), "updateCoreClearance", updateCoreHandlingUnitSQL, paramList);
                throw ex;
            }
        }
    }

    public static boolean dbTestCheckResults(HandlingUnit hu, DatabaseBean db, boolean isNullGood, int goodCount, String trkNbr[], String location[], boolean nullList[], String stagingAreaCode[], 
            String warehouseCode[], String shuttleCode[], String msgPrefix)
        throws Exception
    {
        if(hu == null && !isNullGood)
        {
            System.out.println(msgPrefix + "  FAIL  No record found");
            return false;
        }
        for(int i = 0; i < goodCount; i++)
        {
            if(hu == null)
            {
                System.out.println(msgPrefix + "  FAIL  Minimum Record Count not found");
                return false;
            }
            if(!hu.getTrackingNumber().equals(trkNbr[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Tracking Number");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            if(nullList[i] != hu.getNullCoreClearance())
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match null core clearance flag");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            if(!nullList[i] && !hu.getLocationCode().equals(location[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Location Code");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            if(!nullList[i] && !hu.getStagingAreaCode().equals(stagingAreaCode[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Staging Area Code");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            if(!nullList[i] && !hu.getWarehouseCode().equals(warehouseCode[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Warehouse Code");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            if(!nullList[i] && !hu.getShuttleCode().equals(shuttleCode[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Shuttle Code");
                System.err.println(msgPrefix + "  returned:  " + hu);
                return false;
            }
            System.out.println(msgPrefix + "  Row Number:  " + (i + 1) + " Success");
            hu = db.fetchNextHandlingUnit();
        }

        if((hu = db.fetchNextHandlingUnit()) != null)
        {
            System.out.println(msgPrefix + "  FAIL  Extra Rows Returned");
            do
                System.err.println(msgPrefix + "  returned:  " + hu);
            while((hu = db.fetchNextHandlingUnit()) != null);
            return false;
        } else
        {
            System.out.println(msgPrefix + "  success");
            return true;
        }
    }

    public static boolean dbTest(DatabaseBean db)
        throws Exception
    {
        String location1 = "MWR";
        String location2 = "TUL";
        String location3 = "DHN";
        String location4 = "ICT";
        db.setLocationCode(location1);
        int successCases = 0;
        int failCases = 0;
        int poid1 = -2222;
        int poid2 = -2224;
        int soid1 = -2223;
        int soid2 = -2225;
        String trk1 = "1234567890";
        String trk2 = "0987654321";
        String trkNbrList1[] = {
            trk1
        };
        String trkNbrList2[] = {
            trk2
        };
        String locList1[] = {
            location4, location3, location2, location1
        };
        String locationList1[] = {
            location1
        };
        String locationList2[] = {
            location1, location2
        };
        String locationList3[] = {
            location2
        };
        boolean nullList1[] = {
            false
        };
        boolean nullList2[] = {
            true
        };
        String stageAreaList1[] = {
            "MWR"
        };
        String stageAreaList2[] = {
            "MR2"
        };
        String warehouseCdList1[] = {
            "WH1"
        };
        String warehouseCdList2[] = {
            "WH2"
        };
        String shuttleCode1[] = {
            "SHTL1"
        };
        String shuttleCode2[] = {
            "SHTL2"
        };
        System.out.println("DbHandlingUnit Unit Test Pre-Cleanup");
        HandlingUnit remHu = new HandlingUnit();
        System.out.println("Removing any previous data from Test Case #1");
        remHu.setHandlingUnitOidNumber(poid1);
        db.removeHandlingUnit(remHu);
        db.commitTransaction();
        System.out.println("DbHandlingUnit Unit Test Pre-Cleanup completed");
        System.out.println("");
        System.out.println("*****************************************************");
        System.out.println("          DbHandlingUnit Begining Unit Test");
        System.out.println("*****************************************************");
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #1:  fetchHandlingUnit(int pieceOidNbr)");
        System.out.println("---------------------------------------------------------------------");
        HandlingUnit hu1 = new HandlingUnit(poid1, trk1, "1111", soid1, "", 0.0F, "", 0.0D, "", "", "", "", "");
        hu1.setStagingAreaCode("MWR");
        hu1.setWarehouseCode("WH1");
        hu1.setShuttleCode(shuttleCode1[0]);
        System.out.println("DbHandlingUnit UTC #1:  Insert Record");
        db.saveHandlingUnit(hu1);
        System.out.println("DbHandlingUnit UTC #1:  Insert Record success");
        System.out.println("DbHandlingUnit UTC #1:  Commit");
        db.commitTransaction();
        System.out.println("DbHandlingUnit UTC #1:  Commit Success");
        System.out.println("DbHandlingUnit UTC #1:  fetchHandlingUnit(" + poid1 + ");");
        HandlingUnit hu = db.fetchHandlingUnit(poid1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #1:  fetchHandlingUnit(" + poid1 + ");"))
        {
            System.out.println("                                                                        *******");
            System.out.println("DbHandlingUnit Unit Test Case #1:  fetchHandlingUnit(int pieceOidNbr)   SUCCESS");
            System.out.println("                                                                        *******");
            successCases++;
        } else
        {
            System.out.println("                                                                        ****************");
            System.out.println("DbHandlingUnit Unit Test Case #1:  fetchHandlingUnit(int pieceOidNbr)   ***   FAIL   ***");
            System.out.println("                                                                        ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #2:  fetchHandlingUnitWithShipmentOid(int shipmentOidNbr)");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #2:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #2:  fetchHandlingUnitWithShipmentOid(" + soid1 + ");");
        hu = db.fetchHandlingUnitWithShipmentOid(soid1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #2:  fetchHandlingUnitWithShipmentOid(" + soid1 + ");"))
        {
            System.out.println("                                                                                      *******");
            System.out.println("DbHandlingUnit Unit Test Case #2:  fetchHandlingUnitWithShipmentOid(int shipOidNbr)   SUCCESS");
            System.out.println("                                                                                      *******");
            successCases++;
        } else
        {
            System.out.println("                                                                                      ****************");
            System.out.println("DbHandlingUnit Unit Test Case #2:  fetchHandlingUnitWithShipmentOid(int shipOidNbr)   ***   FAIL   ***");
            System.out.println("                                                                                      ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #3:  fetchHandlingUnit(String trackNbr)");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #3:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #3:  fetchHandlingUnit(" + trk1 + ");");
        hu = db.fetchHandlingUnit(trk1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #3:  fetchHandlingUnit(" + trk1 + ");"))
        {
            System.out.println("                                                                        *******");
            System.out.println("DbHandlingUnit Unit Test Case #3:  fetchHandlingUnit(String trackNbr)   SUCCESS");
            System.out.println("                                                                        *******");
            successCases++;
        } else
        {
            System.out.println("                                                                        ****************");
            System.out.println("DbHandlingUnit Unit Test Case #3:  fetchHandlingUnit(String trackNbr)   ***   FAIL   ***");
            System.out.println("                                                                        ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #4:  fetchHandlingUnit(String trackNbr,String locList[])");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #4:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #4:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");");
        hu = db.fetchHandlingUnit(trk1, locList1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #4:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");"))
        {
            System.out.println("                                                                                         *******");
            System.out.println("DbHandlingUnit Unit Test Case #4:  fetchHandlingUnit(String trackNbr,String locList[])   SUCCESS");
            System.out.println("                                                                                         *******");
            successCases++;
        } else
        {
            System.out.println("                                                                                         ****************");
            System.out.println("DbHandlingUnit Unit Test Case #4:  fetchHandlingUnit(String trackNbr,String locList[])   ***   FAIL   ***");
            System.out.println("                                                                                         ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #5:  fetchHandlingUnit(String trackNbr,String locList[])");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #5:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #5:  Inserting extra Piece_core_clearance Record with Location: " + location2);
        hu.setLocationCode(location3);
        db.saveHandlingUnitCoreClearance(hu);
        System.out.println("DbHandlingUnit UTC #5:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");");
        hu = db.fetchHandlingUnit(trk1, locList1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #5:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");"))
        {
            System.out.println("                                                                                         *******");
            System.out.println("DbHandlingUnit Unit Test Case #5:  fetchHandlingUnit(String trackNbr,String locList[])   SUCCESS");
            System.out.println("                                                                                         *******");
            successCases++;
        } else
        {
            System.out.println("                                                                                         ****************");
            System.out.println("DbHandlingUnit Unit Test Case #5:  fetchHandlingUnit(String trackNbr,String locList[])   ***   FAIL   ***");
            System.out.println("                                                                                         ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #6:  fetchHandlingUnit(String trackNbr,String locList[])");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #6:  Using record from UTC #1");
        db.setLocationCode(location2);
        System.out.println("DbHandlingUnit UTC #6:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");");
        hu = db.fetchHandlingUnit(trk1, locList1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList2, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #6:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");"))
        {
            System.out.println("                                                                                         *******");
            System.out.println("DbHandlingUnit Unit Test Case #6:  fetchHandlingUnit(String trackNbr,String locList[])   SUCCESS");
            System.out.println("                                                                                         *******");
            successCases++;
        } else
        {
            System.out.println("                                                                                         ****************");
            System.out.println("DbHandlingUnit Unit Test Case #6:  fetchHandlingUnit(String trackNbr,String locList[])   ***   FAIL   ***");
            System.out.println("                                                                                         ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #7:  update with nullCoreClearance(call save)");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #7:  update fetch HU from #6");
        hu.setStagingAreaCode("MWR");
        hu.setWarehouseCode("WH1");
        hu.setNullCoreClearance(false);
        db.updateHandlingUnitCoreClearance(hu);
        System.out.println("DbHandlingUnit UTC #7:  commit update");
        db.commitTransaction();
        System.out.println("DbHandlingUnit UTC #7:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");");
        hu = db.fetchHandlingUnit(trk1, locList1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList3, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #7:  fetchHandlingUnit(" + trk1 + "," + locList1 + ");"))
        {
            System.out.println("                                                                              *******");
            System.out.println("DbHandlingUnit Unit Test Case #7:  update with nullCoreClearance(call save)   SUCCESS");
            System.out.println("                                                                              *******");
            successCases++;
        } else
        {
            System.out.println("                                                                              ****************");
            System.out.println("DbHandlingUnit Unit Test Case #7:  update with nullCoreClearance(call save)   ***   FAIL   ***");
            System.out.println("                                                                              ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #8:  fetchHandlingUnit(String stageArea)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #8:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #8:  Inserting Intercept record on this piece");
        db.setLocationCode("MWR");
        System.out.println("DbHandlingUnit UTC #8:  fetchHandlingUnitPickList(MWR, WH1);");
        hu = db.fetchHandlingUnitPickList("MWR", "WH1");
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList1, locationList1, nullList1, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #8:  fetchHandlingUnitPickList(MWR, WH1);"))
        {
            System.out.println("                                                                                 *******");
            System.out.println("DbHandlingUnit Unit Test Case #8:  fetchHandlingUnitPickList(String stageArea)   SUCCESS");
            System.out.println("                                                                                 *******");
            successCases++;
        } else
        {
            System.out.println("                                                                                 ****************");
            System.out.println("DbHandlingUnit Unit Test Case #8:  fetchHandlingUnitPickList(String stageArea)   ***   FAIL   ***");
            System.out.println("                                                                                 ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #9:  update ");
        System.out.println("------------------------------------------");
        System.out.println("DbHandlingUnit UTC #9:  update fetch HU from #8");
        hu.setLocationCode("MWR");
        hu.setStagingAreaCode("MR2");
        hu.setWarehouseCode("WH2");
        hu.setTrackingNumber(trk2);
        hu.setNullCoreClearance(false);
        hu.setShuttleCode(shuttleCode2[0]);
        db.updateHandlingUnit(hu);
        System.out.println("DbHandlingUnit UTC #9:  commit update");
        db.commitTransaction();
        System.out.println("DbHandlingUnit UTC #9:  fetchHandlingUnit(" + poid1 + ");");
        hu = db.fetchHandlingUnit(poid1);
        if(dbTestCheckResults(hu, db, false, 1, trkNbrList2, locationList1, nullList1, stageAreaList2, warehouseCdList2, shuttleCode2, "DbHandlingUnit UTC #9:  fetchHandlingUnit(" + poid1 + ");"))
        {
            System.out.println("                                             *******");
            System.out.println("DbHandlingUnit Unit Test Case #9:  update    SUCCESS");
            System.out.println("                                             *******");
            successCases++;
        } else
        {
            System.out.println("                                            ****************");
            System.out.println("DbHandlingUnit Unit Test Case #9:  update   ***   FAIL   ***");
            System.out.println("                                            ****************");
            failCases++;
        }
        System.out.println("Start Handling Unit dump before delete...");
        System.out.println(hu);
        System.out.println("End Handling Unit dump before delete...");
        System.out.println("DbHandlingUnit Unit Test Post-Cleanup");
        remHu = new HandlingUnit();
        System.out.println("Removing any leftover data from Test Case #1");
        remHu.setHandlingUnitOidNumber(poid1);
        db.removeHandlingUnit(remHu);
        db.commitTransaction();
        System.out.println("DbHandlingUnit Unit Test Post-Cleanup completed");
        System.out.println("");
        System.out.println("DbHandlingUnit Unit Test Case #11:  remove check");
        System.out.println("------------------------------------------------");
        System.out.println("DbHandlingUnit UTC #11:  Using record from UTC #1");
        System.out.println("DbHandlingUnit UTC #11:  fetchHandlingUnit(" + poid1 + ");");
        db.setLocationCode(location4);
        hu = db.fetchHandlingUnit(poid1);
        if(dbTestCheckResults(hu, db, true, 0, trkNbrList2, locationList1, nullList2, stageAreaList1, warehouseCdList1, shuttleCode1, "DbHandlingUnit UTC #11:  fetchHandlingUnit(" + poid1 + ");"))
        {
            System.out.println("                                                   *******");
            System.out.println("DbHandlingUnit Unit Test Case #11:  remove check   SUCCESS");
            System.out.println("                                                   *******");
            successCases++;
        } else
        {
            System.out.println("                                                   ****************");
            System.out.println("DbHandlingUnit Unit Test Case #11:  remove check   ***   FAIL   ***");
            System.out.println("                                                   ****************");
            failCases++;
        }
        System.out.println("");
        System.out.println("*****************************************************");
        System.out.println("          DbHandlingUnit Unit Test Results:");
        System.out.println("*****************************************************");
        System.out.println("Succesful Cases:  " + successCases);
        System.out.println("Failure Cases:    " + failCases);
        System.out.println("*****************************************************");
        return failCases <= 0;
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
            System.out.println("DbHandlingUnit.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbHandlingUnit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private static final String fetchColumnList = "P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD ";
    private static final String fetchTableList = "PIECE P, PIECE_CORE_CLEARANCE PCC";
    private String schema_name;
    private static final String fetchBaseSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE ";
    private static final String fetchAllNonScannedPiecesOnRouteSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM ccii.PIECE P, ccii.PIECE_CORE_CLEARANCE PCC, ccii.PIECE_ROUTE_LEG prl  WHERE  pcc.location_cd = ?  and prl.route_nbr = ? and prl.route_dt = ? and prl.route_leg_nbr = ? and prl.piece_oid_nbr = p.piece_oid_nbr and p.piece_oid_nbr = pcc.piece_oid_nbr and not exists    ( select distinct s.piece_oid_nbr     from ccii.scan s, ccii.scan_def sd     where       p.piece_oid_nbr = s.piece_oid_nbr       and s.scan_type_cd = sd.scan_type_cd       and s.loc_stat_nbr = sd.loc_stat_nbr       and s.location_cd = sd.location_cd       and sd.physical_custody_scan_flg = 'Y' ) ORDER BY p.piece_oid_nbr";
    private static final String singleLocFetchBaseSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? ";
    private static final String fetchOuterBaseSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ? ";
    private static final String locListFetchBaseSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND exists (SELECT * FROM PIECE_CORE_CLEARANCE PCC2                WHERE PCC2.PIECE_OID_NBR = P.PIECE_OID_NBR                AND PCC2.LOCATION_CD in (?,?,?,?,?,?,?,?,?,?)) ";
    private static final String fetchWithPieceOidSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.PIECE_OID_NBR = ?";
    private static final String fetchWithPieceOidAllowNullLocationSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND P.PIECE_OID_NBR = ? ";
    private static final String fetchWithShipmentOidSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ?";
    private static final String fetchWithShipmentOidAndTrackingNbrSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ? AND P.SHIPMENT_OID_NBR = ? AND TRACKING_NBR = ?";
    private static final String fetchSingleLocWithTrackingNbrSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR  AND PCC.LOCATION_CD = ?  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ";
    private static final String fetchLocListWithTrackingNbrSQL = "SELECT P.PIECE_OID_NBR, P.TRACKING_NBR, P.FORM_TYPE_CD, P.SHIPMENT_OID_NBR, P.HARMONIZED_TARIFF_NBR, P.TOTAL_WGT, P.TOTAL_WGT_TYPE_CD, P.CUSTOMS_VALUE_AMT, P.ENTRY_STATUS_CD, P.AWB_TYPE_CD, PCC.DETAINMENT_LOCATION_CD, PCC.LAST_MODIFIED_TMSTP, PCC.LAST_USER_NM, PCC.ENTRY_CATEGORY_TYPE_CD, PCC.RECURRING_SELECT_FLG, PCC.OVERAGE_REASON_CD, PCC.TRAVEL_STATUS_CD, PCC.STAGING_AREA_CD, PCC.WAREHOUSE_CD, P.TRANSACTION_SEQ_TMSTP, P.MANIFEST_STATUS_CD, P.PIECE_STATUS_CD, PCC.LOCATION_CD, PCC.PIECE_OID_NBR, P.DEST_LOCATION_CD, PCC.SHUTTLE_CD  FROM PIECE P, PIECE_CORE_CLEARANCE PCC WHERE  P.PIECE_OID_NBR = PCC.PIECE_OID_NBR(+)  AND PCC.LOCATION_CD(+) = ?  AND exists (SELECT * FROM PIECE_CORE_CLEARANCE PCC2                WHERE PCC2.PIECE_OID_NBR = P.PIECE_OID_NBR                AND PCC2.LOCATION_CD in (?,?,?,?,?,?,?,?,?,?))  AND TRACKING_NBR = ? ORDER BY MANIFEST_STATUS_CD ";
    private String fetchPickListSQL;
    private String saveHandlingUnitSQL;
    private String saveCoreHandlingUnitSQL;
    private String removeHandlingUnitSQL;
    private String removeCoreHandlingUnitSQL;
    private String updateHandlingUnitSQL;
    private String updateCoreHandlingUnitSQL;
    private PreparedStatement fetchWithPieceOidStmt;
    private PreparedStatement fetchWithPieceOidAllowNullLocationStmt;
    private PreparedStatement fetchWithShipmentOidStmt;
    private PreparedStatement fetchWithShipmentOidAndTrackingNbrStmt;
    private PreparedStatement fetchSingleLocWithTrackingNbrStmt;
    private PreparedStatement fetchLocListWithTrackingNbrStmt;
    private PreparedStatement fetchPickListStmt;
    private PreparedStatement fetchAllNonScannedPiecesOnRouteStmt;
    private PreparedStatement saveHandlingUnitStmt;
    private PreparedStatement saveCoreHandlingUnitStmt;
    private PreparedStatement removeHandlingUnitStmt;
    private PreparedStatement removeCoreHandlingUnitStmt;
    private PreparedStatement updateHandlingUnitStmt;
    private PreparedStatement updateCoreHandlingUnitStmt;
}
