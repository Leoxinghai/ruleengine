// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbIntercept.java

package cciij.cciidatabase;

import cciij.cciidata.Intercept;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbIntercept extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        int interceptOidNbr = -3;
        int shipmentOidNbr = -2;
        int pieceOidNbr = -1;
        String interceptCode = "C1";
        String activeFlag = "Y";
        Date createDate = new Date(0L);
        String employeeNumberForCreation = "KS92163";
        String processNameCreated = "NNN DB TEST";
        Date dateUpdated = new Date(0L);
        String employeeNumberForUpdate = "92163";
        String processNameUpdated = "NNN DB TESTING";
        int stagingAreaPriorityNumber = 1;
        Date transactionDate = new Date(0L);
        String agencyCode = "CU";
        String fromRecurringCriteriaFlag = "Y";
        Intercept intercept = new Intercept(interceptOidNbr, shipmentOidNbr, pieceOidNbr, interceptCode, activeFlag, createDate, employeeNumberForCreation, processNameCreated, dateUpdated, employeeNumberForUpdate, processNameUpdated, stagingAreaPriorityNumber, transactionDate, agencyCode, fromRecurringCriteriaFlag);
        Intercept interceptSave = new Intercept();
        try
        {
            db.setLocationCode("NNN");
            intercept.setInterceptLocationCode("NNN");
            db.removeIntercept(intercept);
            intercept.setInterceptLocationCode("");
            db.saveIntercept(intercept);
            interceptOidNbr = -4;
            interceptCode = "C2";
            activeFlag = "N";
            intercept = new Intercept(interceptOidNbr, shipmentOidNbr, pieceOidNbr, interceptCode, activeFlag, createDate, employeeNumberForCreation, processNameCreated, dateUpdated, employeeNumberForUpdate, processNameUpdated, stagingAreaPriorityNumber, transactionDate, agencyCode, fromRecurringCriteriaFlag);
            intercept.setInterceptLocationCode("NNN");
            db.removeIntercept(intercept);
            intercept.setInterceptLocationCode("");
            db.saveIntercept(intercept);
            db.setLocationCode("JJJ");
            processNameCreated = "JJJ DB TEST";
            processNameUpdated = "JJJ DB TESTING";
            interceptOidNbr = -5;
            interceptCode = "C1";
            activeFlag = "N";
            intercept = new Intercept(interceptOidNbr, shipmentOidNbr, pieceOidNbr, interceptCode, activeFlag, createDate, employeeNumberForCreation, processNameCreated, dateUpdated, employeeNumberForUpdate, processNameUpdated, stagingAreaPriorityNumber, transactionDate, agencyCode, fromRecurringCriteriaFlag);
            intercept.setInterceptLocationCode("JJJ");
            db.removeIntercept(intercept);
            db.saveIntercept(intercept);
            db.setLocationCode("JJJ");
            interceptOidNbr = -6;
            interceptCode = "C2";
            activeFlag = "Y";
            intercept = new Intercept(interceptOidNbr, shipmentOidNbr, pieceOidNbr, interceptCode, activeFlag, createDate, employeeNumberForCreation, processNameCreated, dateUpdated, employeeNumberForUpdate, processNameUpdated, stagingAreaPriorityNumber, transactionDate, agencyCode, fromRecurringCriteriaFlag);
            intercept.setInterceptLocationCode("JJJ");
            db.removeIntercept(intercept);
            intercept.setInterceptLocationCode("");
            db.saveIntercept(intercept);
            System.out.println("Test Case 1: Successfully saved Intercepts");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchInterceptWithActiveFlag(shipmentOidNbr);
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3: Row = " + currentRow + "-Results of fetchWithActiveFlg(shipmentOid, m_locationCd)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("JJJ");
            intercept = db.fetchInterceptByPieceOid(agencyCode, pieceOidNbr, "C1", "N");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4a: Row = " + currentRow + "-Results of fetchinterceptByPieceOid(agencyCode, pieceOidNumber, interceptCode, activeFlag)" + intercept);
                intercept = db.fetchNextIntercept();
            }

            db.setLocationCode("JJJ");
            intercept = db.fetchInterceptByPieceOid(agencyCode, pieceOidNbr, "C1", "Y");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 4b: Row = " + currentRow + "-Results of fetchinterceptByPieceOid(agencyCode, pieceOidNumber, interceptCode, activeFlag)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchInterceptByShipmentOid(agencyCode, shipmentOidNbr, "C2", "N");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5: Row = " + currentRow + "-Results of fetchInterceptByShipmentOid(agencyCode, shipmentOidNbr, interceptCd, activeFlag)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 5 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchInterceptByInterceptDefJoin(shipmentOidNbr, pieceOidNbr, "CG3", "CUST");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 6: Row = " + currentRow + "-Results of fetchByInterceptDefJoin(shipmentOid, pieceOid, stageAreaCd)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 6 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("JJJ");
            intercept = db.fetchInterceptWithShipOidAndInterceptCd(shipmentOidNbr, "C2");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 7: Row = " + currentRow + "-Results of fetchInterceptWithShipOidAndInterceptCd(shipmentOidNbr, locationCd)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 7 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchInterceptJoiningAgencyTable(shipmentOidNbr, pieceOidNbr, "CUST", "WHSE");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 8: Row = " + currentRow + "-Results of fetchInterceptByJoiningAgency(shipmentOidNbr, pieceOidNbr)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 8 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchInterceptByShipmentOrPieceOid(shipmentOidNbr, pieceOidNbr);
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 9: Row = " + currentRow + "-Results of fetchInterceptByShipmentOrPieceOid(shipmentOid, pieceOid)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 9 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("NNN");
            intercept = db.fetchIntercept(shipmentOidNbr, pieceOidNbr);
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 10: Row = " + currentRow + "-Results of fetchByIntercept(shipmentOid, pieceOid)" + intercept);
                interceptSave = intercept;
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 10 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("JJJ");
            intercept = db.fetchInterceptWithShipOidAndInterceptCd(shipmentOidNbr, "C1");
            intercept.setEmployeeNumberForUpdate("33333");
            db.updateIntercept(intercept);
            intercept = db.fetchInterceptWithShipOidAndInterceptCd(shipmentOidNbr, "C1");
            for(int currentRow = 1; db.getInterceptRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 11: Row = " + currentRow + "-Results of updateIntercept(Intercept intercept)" + intercept);
                intercept = db.fetchNextIntercept();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 11 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.removeIntercept(interceptSave);
            if(db.getInterceptRecordCount() == 0)
                System.out.println("Test Case 12: Remove Successful ");
            else
                System.out.println("Test Case 12: Remove Successful ");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 12 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public DbIntercept()
    {
        selectColumns = "SELECT I.INTERCEPT_OID_NBR, I.SHIPMENT_OID_NBR, I.PIECE_OID_NBR, I.INTERCEPT_CD, I.ACTIVE_FLG, I.CREATE_DT, I.CREATE_EMPLOYEE_NBR, I.CREATE_PROCESS_NM, I.UPDATE_DT, I.UPDATE_EMPLOYEE_NBR, I.UPDATE_PROCESS_NM, I.STAGING_AREA_PRIORITY_NBR, I.TRANSACTION_DT, I.AGENCY_CD, I.RECURRING_CRITERIA_FLG, I.INTERCEPT_LOCATION_CD, I.AGENCY_LOCATION_CD FROM ";
        interceptTable = "INTERCEPT I";
        interceptDefTable = ", INTERCEPT_DEF ID";
        joinInterceptDefTable = " JOIN INTERCEPT_DEF ID ON I.INTERCEPT_CD = ID.INTERCEPT_CD";
        agencyTable = ", AGENCY A";
        joinAgencyTable = " JOIN AGENCY A ON I.INTERCEPT_LOCATION_CD = A.AGENCY_LOCATION_CD AND I.AGENCY_CD = A.AGENCY_CD";
        agencyStagingAreaTable = ", ENT.AGENCY_STAGING_AREA ASA";
        interceptStagingAreaTable = ", ENT.INTERCEPT_STAGING_AREA ISA";
        pieceTable = ", PIECE P";
        shipmentTable = ", SHIPMENT S";
        joinPhysicalScanCountView = " LEFT OUTER JOIN ENT.PHYSICAL_SCAN_COUNT_VW PSCV ON I.INTERCEPT_LOCATION_CD = PSCV.LOCATION_CD AND I.SHIPMENT_OID_NBR = PSCV.SHIPMENT_OID_NBR";
        where = " WHERE ";
        fetchInterceptSecuredWithActiveFlagSQL = selectColumns + interceptTable + joinInterceptDefTable + joinAgencyTable + joinPhysicalScanCountView + where + "(A.CUSTOMS_AGENCY_FLG = 'N' OR " + "(PSCV.CUSTODY_SCAN_NBR IS NOT NULL AND PCSV.CUSTODY_SCAN_NBR > 0)) AND " + "I.SHIPMENT_OID_NBR = ? AND " + "I.ACTIVE_FLG = 'Y' AND " + "INTERCEPT_LOCATION_CD = ? " + "ORDER BY A.CLEARANCE_PRIORITY_CD, A.AGENCY_CD, " + "ID.INTERCEPT_PRIORITY_NBR";
        fetchInterceptWithActiveFlagSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT.INTERCEPT_CD, ACTIVE_FLG, INTERCEPT.CREATE_DT, INTERCEPT.CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, INTERCEPT.UPDATE_DT, INTERCEPT.UPDATE_EMPLOYEE_NBR, INTERCEPT.UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, INTERCEPT.AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT, INTERCEPT_DEF, AGENCY WHERE SHIPMENT_OID_NBR = ? AND ACTIVE_FLG = 'Y' AND INTERCEPT.INTERCEPT_CD = INTERCEPT_DEF.INTERCEPT_CD AND INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND INTERCEPT.AGENCY_CD = AGENCY.AGENCY_CD AND INTERCEPT_LOCATION_CD = ? ORDER BY AGENCY.CLEARANCE_PRIORITY_CD, AGENCY.AGENCY_CD, INTERCEPT_DEF.INTERCEPT_PRIORITY_NBR";
        fetchInterceptByPieceOidSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT WHERE AGENCY_CD = ? AND PIECE_OID_NBR = ? AND INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND INTERCEPT_CD = ? AND ACTIVE_FLG = ? AND INTERCEPT_LOCATION_CD = ?";
        fetchInterceptByShipmentOidSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT WHERE AGENCY_CD = ? AND SHIPMENT_OID_NBR = ? AND INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND INTERCEPT_CD = ? AND ACTIVE_FLG = ? AND INTERCEPT_LOCATION_CD = ?";
        fetchInterceptByShipOidSACdActFlgSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT.INTERCEPT_CD, ACTIVE_FLG, INTERCEPT.CREATE_DT, INTERCEPT.CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, INTERCEPT.UPDATE_DT, INTERCEPT.UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT, INTERCEPT_DEF, ENT.INTERCEPT_STAGING_AREA WHERE (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?) AND  INTERCEPT_DEF.LOCATION_CD = INTERCEPT_LOCATION_CD AND INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND ACTIVE_FLG = 'Y'  AND  INTERCEPT_DEF.INTERCEPT_CD = INTERCEPT.INTERCEPT_CD AND INTERCEPT_STAGING_AREA.STAGING_AREA_CD = ? AND INTERCEPT_STAGING_AREA.LOCATION_CD = INTERCEPT_DEF.LOCATION_CD AND INTERCEPT_STAGING_AREA.INTERCEPT_CD = INTERCEPT_DEF.INTERCEPT_CD AND INTERCEPT_STAGING_AREA.WAREHOUSE_CD = ? AND INTERCEPT_LOCATION_CD = ? ";
        fetchInteceptByAgencyJoinSQL = "SELECT I.INTERCEPT_OID_NBR, I.SHIPMENT_OID_NBR, I.PIECE_OID_NBR, I.INTERCEPT_CD, I.ACTIVE_FLG, I.CREATE_DT, I.CREATE_EMPLOYEE_NBR, I.CREATE_PROCESS_NM, I.UPDATE_DT, I.UPDATE_EMPLOYEE_NBR, I.UPDATE_PROCESS_NM, I.STAGING_AREA_PRIORITY_NBR, I.TRANSACTION_DT, I.AGENCY_CD, I.RECURRING_CRITERIA_FLG, I.INTERCEPT_LOCATION_CD, I.AGENCY_LOCATION_CD FROM INTERCEPT I, AGENCY A, ENT.AGENCY_STAGING_AREA ASA WHERE (I.SHIPMENT_OID_NBR = ? OR I.PIECE_OID_NBR = ?) AND I.ACTIVE_FLG = 'Y' AND A.AGENCY_CD = I.AGENCY_CD AND ASA.AGENCY_CD = I.AGENCY_CD AND I.AGENCY_LOCATION_CD = A.LOCATION_CD AND A.LOCATION_CD = ASA.LOCATION_CD AND ASA.STAGING_AREA_CD = ? AND ASA.WAREHOUSE_CD = ? AND I.INTERCEPT_LOCATION_CD = ? ";
        fetchInterceptByShipOid_IntcpCdSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT WHERE SHIPMENT_OID_NBR = ? AND  INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND INTERCEPT_CD = ? AND INTERCEPT_LOCATION_CD = ?";
        fetchActiveInterceptByShipOid_PcOid_IntcpCdSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT.INTERCEPT_CD, ACTIVE_FLG, INTERCEPT.CREATE_DT, INTERCEPT.CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, INTERCEPT.UPDATE_DT, INTERCEPT.UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, INTERCEPT.AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD  FROM INTERCEPT, AGENCY, INTERCEPT_DEF WHERE (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?) AND INTERCEPT_LOCATION_CD = ? AND ACTIVE_FLG = 'Y' AND INTERCEPT.AGENCY_CD = AGENCY.AGENCY_CD AND INTERCEPT_LOCATION_CD  = AGENCY.LOCATION_CD AND INTERCEPT_LOCATION_CD  = INTERCEPT_DEF.LOCATION_CD AND INTERCEPT_LOCATION_CD = AGENCY_LOCATION_CD AND INTERCEPT.INTERCEPT_CD = INTERCEPT_DEF.INTERCEPT_CD ORDER BY AGENCY.CLEARANCE_PRIORITY_CD, AGENCY.AGENCY_CD, INTERCEPT_DEF.INTERCEPT_PRIORITY_NBR";
        fetchActiveInterceptByShipOidOrPcOidSQL = "SELECT INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD FROM INTERCEPT WHERE (SHIPMENT_OID_NBR = ? OR PIECE_OID_NBR = ?) AND INTERCEPT_LOCATION_CD = ? AND ACTIVE_FLG = 'Y'";
        fetchActiveIntercptByAgencySQL = "SELECT I.INTERCEPT_OID_NBR, I.SHIPMENT_OID_NBR, I.PIECE_OID_NBR, I.INTERCEPT_CD, I.ACTIVE_FLG, I.CREATE_DT, I.CREATE_EMPLOYEE_NBR, I.CREATE_PROCESS_NM, I.UPDATE_DT, I.UPDATE_EMPLOYEE_NBR, I.UPDATE_PROCESS_NM, I.STAGING_AREA_PRIORITY_NBR, I.TRANSACTION_DT, I.AGENCY_CD, I.RECURRING_CRITERIA_FLG, I.INTERCEPT_LOCATION_CD, I.AGENCY_LOCATION_CD FROM INTERCEPT I, PIECE P, SHIPMENT S WHERE S.SHIPMENT_OID_NBR = ? AND P.SHIPMENT_OID_NBR = S.SHIPMENT_OID_NBR AND P.TRACKING_NBR = S.AWB_NBR AND I.PIECE_OID_NBR = P.PIECE_OID_NBR AND I.AGENCY_CD = ? AND I.ACTIVE_FLG = 'Y' AND I.RECURRING_CRITERIA_FLG = ? AND I.INTERCEPT_LOCATION_CD LIKE ? ";
        saveInterceptSQL = "INSERT INTO INTERCEPT (INTERCEPT_OID_NBR, SHIPMENT_OID_NBR, PIECE_OID_NBR, INTERCEPT_CD, ACTIVE_FLG, CREATE_DT, CREATE_EMPLOYEE_NBR, CREATE_PROCESS_NM, UPDATE_DT, UPDATE_EMPLOYEE_NBR, UPDATE_PROCESS_NM, STAGING_AREA_PRIORITY_NBR, TRANSACTION_DT, AGENCY_CD, RECURRING_CRITERIA_FLG, INTERCEPT_LOCATION_CD, AGENCY_LOCATION_CD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeInterceptSQL = "DELETE FROM INTERCEPT WHERE INTERCEPT_OID_NBR = ?";
        updateInterceptSQL = "UPDATE INTERCEPT SET INTERCEPT_OID_NBR = ?, SHIPMENT_OID_NBR = ?, PIECE_OID_NBR = ?, INTERCEPT_CD = ?, ACTIVE_FLG = ?, CREATE_DT = ?, CREATE_EMPLOYEE_NBR = ?, CREATE_PROCESS_NM = ?, UPDATE_DT = ?, UPDATE_EMPLOYEE_NBR = ?, UPDATE_PROCESS_NM = ?, STAGING_AREA_PRIORITY_NBR = ?, TRANSACTION_DT = ?, AGENCY_CD = ?, RECURRING_CRITERIA_FLG = ? WHERE INTERCEPT_OID_NBR = ?";
        fetchInterceptSecuredWithActiveFlagStmt = null;
        fetchInterceptWithActiveFlagStmt = null;
        fetchInterceptByPieceOidStmt = null;
        fetchInterceptByShipmentOidStmt = null;
        fetchInterceptByShipOidSACdActFlgStmt = null;
        fetchInteceptByAgencyJoinStmt = null;
        fetchInterceptByShipOid_IntcpCdStmt = null;
        fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt = null;
        fetchActiveInterceptByShipOidOrPcOidStmt = null;
        fetchActiveIntercptByAgencyStmt = null;
        saveInterceptStmt = null;
        removeInterceptStmt = null;
        updateInterceptStmt = null;
    }

    public int getInterceptRecordCount()
    {
        return m_recordCount;
    }

    public Intercept fetchSecuredWithActiveFlag(Connection conn, int shipOid, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInterceptSecuredWithActiveFlagStmt = conn.prepareStatement(fetchInterceptSecuredWithActiveFlagSQL);
            fetchInterceptSecuredWithActiveFlagStmt.setInt(1, shipOid);
            fetchInterceptSecuredWithActiveFlagStmt.setString(2, locationCd);
            runQuery(fetchInterceptSecuredWithActiveFlagStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchSecuredWithActiveFlag", fetchInterceptSecuredWithActiveFlagSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchWithActiveFlag(Connection conn, int shipOid, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInterceptWithActiveFlagStmt = conn.prepareStatement(fetchInterceptWithActiveFlagSQL);
            fetchInterceptWithActiveFlagStmt.setInt(1, shipOid);
            fetchInterceptWithActiveFlagStmt.setString(2, locationCd);
            runQuery(fetchInterceptWithActiveFlagStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchWithActiveFlag", fetchInterceptWithActiveFlagSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchByPieceOid(Connection conn, String agencyCd, int pcOidNbr, String interceptCd, String activeFlg, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInterceptByPieceOidStmt = conn.prepareStatement(fetchInterceptByPieceOidSQL);
            fetchInterceptByPieceOidStmt.setString(1, agencyCd);
            fetchInterceptByPieceOidStmt.setInt(2, pcOidNbr);
            fetchInterceptByPieceOidStmt.setString(3, interceptCd);
            fetchInterceptByPieceOidStmt.setString(4, activeFlg);
            fetchInterceptByPieceOidStmt.setString(5, locationCd);
            runQuery(fetchInterceptByPieceOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = agencyCd + ", " + pcOidNbr + ", " + interceptCd + ", " + activeFlg + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchByPieceOid", fetchInterceptByPieceOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchByShipmentOid(Connection conn, String agencyCd, int shipOidNbr, String interceptCd, String activeFlg, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInterceptByShipmentOidStmt = conn.prepareStatement(fetchInterceptByShipmentOidSQL);
            fetchInterceptByShipmentOidStmt.setString(1, agencyCd);
            fetchInterceptByShipmentOidStmt.setInt(2, shipOidNbr);
            fetchInterceptByShipmentOidStmt.setString(3, interceptCd);
            fetchInterceptByShipmentOidStmt.setString(4, activeFlg);
            fetchInterceptByShipmentOidStmt.setString(5, locationCd);
            runQuery(fetchInterceptByShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = agencyCd + ", " + shipOidNbr + ", " + interceptCd + ", " + activeFlg + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchByShipmentOid", fetchInterceptByShipmentOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetch(Connection conn, int shipmentOid, int pieceOid, String stageAreaCd, String warehouseCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInterceptByShipOidSACdActFlgStmt = conn.prepareStatement(fetchInterceptByShipOidSACdActFlgSQL);
            fetchInterceptByShipOidSACdActFlgStmt.setInt(1, shipmentOid);
            fetchInterceptByShipOidSACdActFlgStmt.setInt(2, pieceOid);
            fetchInterceptByShipOidSACdActFlgStmt.setString(3, stageAreaCd);
            fetchInterceptByShipOidSACdActFlgStmt.setString(4, warehouseCd);
            fetchInterceptByShipOidSACdActFlgStmt.setString(5, locationCd);
            runQuery(fetchInterceptByShipOidSACdActFlgStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipmentOid + ", " + pieceOid + ", " + stageAreaCd + ", " + warehouseCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchInterceptByShipOidSACdActFlgSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchJoiningAgencyTable(Connection conn, int shipmentOid, int pieceOid, String stageAreaCd, String warehouseCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchInteceptByAgencyJoinStmt = conn.prepareStatement(fetchInteceptByAgencyJoinSQL);
            fetchInteceptByAgencyJoinStmt.setInt(1, shipmentOid);
            fetchInteceptByAgencyJoinStmt.setInt(2, pieceOid);
            fetchInteceptByAgencyJoinStmt.setString(3, stageAreaCd);
            fetchInteceptByAgencyJoinStmt.setString(4, warehouseCd);
            fetchInteceptByAgencyJoinStmt.setString(5, locationCd);
            runQuery(fetchInteceptByAgencyJoinStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipmentOid + ", " + pieceOid + ", " + stageAreaCd + ", " + warehouseCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchJoiningAgencyTable", fetchInteceptByAgencyJoinSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchWithOidAndInterceptCd(Connection conn, int shipmentOid, String interceptCd, String locationCd)
        throws SQLException
    {
        try
        {
            if(m_resultSet != null)
                m_resultSet.close();
            fetchInterceptByShipOid_IntcpCdStmt = conn.prepareStatement(fetchInterceptByShipOid_IntcpCdSQL);
            fetchInterceptByShipOid_IntcpCdStmt.setInt(1, shipmentOid);
            fetchInterceptByShipOid_IntcpCdStmt.setString(2, interceptCd);
            fetchInterceptByShipOid_IntcpCdStmt.setString(3, locationCd);
            runQuery(fetchInterceptByShipOid_IntcpCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipmentOid + ", " + interceptCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchWithOidAndInterceptCd", fetchInterceptByShipOid_IntcpCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchActiveInterceptByShipOid_PcOid_IntcpCd(Connection conn, int shipOid, int pcOid, String locationCd)
        throws SQLException
    {
        try
        {
            if(m_resultSet != null)
                m_resultSet.close();
            fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt = conn.prepareStatement(fetchActiveInterceptByShipOid_PcOid_IntcpCdSQL);
            fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt.setInt(1, shipOid);
            fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt.setInt(2, pcOid);
            fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt.setString(3, locationCd);
            runQuery(fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipOid + ", " + pcOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchActiveInterceptByShipOid_PcOid_IntcpCd", fetchActiveInterceptByShipOid_PcOid_IntcpCdSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetch(Connection conn, int shipOid, int pcOid, String locationCd)
        throws SQLException
    {
        try
        {
            if(m_resultSet != null)
                m_resultSet.close();
            fetchActiveInterceptByShipOidOrPcOidStmt = conn.prepareStatement(fetchActiveInterceptByShipOidOrPcOidSQL);
            fetchActiveInterceptByShipOidOrPcOidStmt.setInt(1, shipOid);
            fetchActiveInterceptByShipOidOrPcOidStmt.setInt(2, pcOid);
            fetchActiveInterceptByShipOidOrPcOidStmt.setString(3, locationCd);
            runQuery(fetchActiveInterceptByShipOidOrPcOidStmt);
        }
        catch(SQLException ex)
        {
            String paramList = shipOid + ", " + pcOid + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchActiveInterceptByShipOidOrPcOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchActiveIntercptByAgency(Connection conn, int shipOidNbr, String agencyCd, String recurringFlag, String locationCd)
        throws SQLException
    {
        try
        {
            fetchActiveIntercptByAgencyStmt = conn.prepareStatement(fetchActiveIntercptByAgencySQL);
            fetchActiveIntercptByAgencyStmt.setInt(1, shipOidNbr);
            fetchActiveIntercptByAgencyStmt.setString(2, agencyCd);
            fetchActiveIntercptByAgencyStmt.setString(3, recurringFlag);
            fetchActiveIntercptByAgencyStmt.setString(4, locationCd);
            runQuery(fetchActiveIntercptByAgencyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = agencyCd + ", " + shipOidNbr + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetchByShipmentOid", fetchInterceptByShipmentOidSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Intercept fetchNext()
        throws SQLException
    {
        Intercept intercept = new Intercept();
        try
        {
            if(m_hasMore)
            {
                int intcptOid = m_resultSet.getInt(1);
                int shipOid = m_resultSet.getInt(2);
                int pcOid = m_resultSet.getInt(3);
                String intcptCode = m_resultSet.getString(4);
                String activeFlag = m_resultSet.getString(5);
                Timestamp createDtTmstp = m_resultSet.getTimestamp(6);
                String createEmpNum = m_resultSet.getString(7);
                String createProcessName = m_resultSet.getString(8);
                Timestamp updateDtTmstp = m_resultSet.getTimestamp(9);
                String updtEmpNum = m_resultSet.getString(10);
                String updtProcessName = m_resultSet.getString(11);
                int stageAreaPriorityNum = m_resultSet.getInt(12);
                Timestamp transDtTmstp = m_resultSet.getTimestamp(13);
                String agtCd = m_resultSet.getString(14);
                String flg = m_resultSet.getString(15);
                String interceptLocationCode = m_resultSet.getString(16);
                String agencyLocationCode = m_resultSet.getString(17);
                Date createDt = convertTimestampToDate(createDtTmstp);
                Date updateDt = convertTimestampToDate(updateDtTmstp);
                Date transDt = convertTimestampToDate(transDtTmstp);
                intercept = new Intercept(intcptOid, shipOid, pcOid, intcptCode, activeFlag, createDt, createEmpNum, createProcessName, updateDt, updtEmpNum, updtProcessName, stageAreaPriorityNum, transDt, agtCd, flg);
                intercept.setInterceptLocationCode(interceptLocationCode);
                intercept.setAgencyLocationCode(agencyLocationCode);
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
                intercept = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return intercept;
    }

    public void save(Connection conn, Intercept intercept, String locationCode)
        throws SQLException
    {
        Timestamp createDtTimestamp = new Timestamp(intercept.getCreateDate().getTime());
        Timestamp updateDtTimestamp = new Timestamp(intercept.getDateUpdated().getTime());
        Timestamp transactionDtTimestamp = new Timestamp(intercept.getTransactionDate().getTime());
        try
        {
            saveInterceptStmt = conn.prepareStatement(saveInterceptSQL);
            saveInterceptStmt.setInt(1, intercept.getInterceptOidNumber());
            saveInterceptStmt.setInt(2, intercept.getShipmentOidNumber());
            saveInterceptStmt.setInt(3, intercept.getPieceOidNumber());
            saveInterceptStmt.setString(4, intercept.getInterceptCode());
            saveInterceptStmt.setString(5, intercept.getActiveFlag());
            saveInterceptStmt.setTimestamp(6, createDtTimestamp);
            saveInterceptStmt.setString(7, intercept.getEmployeeNumberForCreation());
            saveInterceptStmt.setString(8, intercept.getProcessNameCreated());
            saveInterceptStmt.setTimestamp(9, updateDtTimestamp);
            saveInterceptStmt.setString(10, intercept.getEmployeeNumberForUpdate());
            saveInterceptStmt.setString(11, intercept.getProcessNameUpdated());
            saveInterceptStmt.setInt(12, intercept.getStagingAreaPriorityNumber());
            saveInterceptStmt.setTimestamp(13, transactionDtTimestamp);
            saveInterceptStmt.setString(14, intercept.getAgencyCode());
            saveInterceptStmt.setString(15, intercept.getFromRecurringCriteriaFlag());
            if(intercept.getInterceptLocationCode().equals(""))
                saveInterceptStmt.setString(16, locationCode);
            else
                saveInterceptStmt.setString(16, intercept.getInterceptLocationCode());
            if(intercept.getAgencyLocationCode().equals(""))
                saveInterceptStmt.setString(17, locationCode);
            else
                saveInterceptStmt.setString(17, intercept.getAgencyLocationCode());
            saveInterceptStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = intercept.getInterceptOidNumber() + ", " + intercept.getShipmentOidNumber() + ", " + intercept.getPieceOidNumber() + ", " + intercept.getInterceptCode() + ", " + intercept.getActiveFlag() + ", " + createDtTimestamp + ", " + intercept.getEmployeeNumberForCreation() + ", " + intercept.getProcessNameCreated() + ", " + updateDtTimestamp + ", " + intercept.getEmployeeNumberForUpdate() + ", " + intercept.getProcessNameUpdated() + ", " + intercept.getStagingAreaPriorityNumber() + ", " + transactionDtTimestamp + ", " + intercept.getAgencyCode() + ", " + intercept.getFromRecurringCriteriaFlag() + ", ";
            if(intercept.getInterceptLocationCode().equals(""))
                paramList = paramList + locationCode;
            else
                paramList = paramList + intercept.getInterceptLocationCode();
            if(intercept.getAgencyLocationCode().equals(""))
                paramList = paramList + locationCode;
            else
                paramList = paramList + intercept.getAgencyLocationCode();
            printSQLException(ex, getClass().getName(), "save", saveInterceptSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, Intercept intercept)
        throws SQLException
    {
        try
        {
            removeInterceptStmt = conn.prepareStatement(removeInterceptSQL);
            removeInterceptStmt.setInt(1, intercept.getInterceptOidNumber());
            removeInterceptStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = Integer.toString(intercept.getInterceptOidNumber());
            printSQLException(ex, getClass().getName(), "remove", removeInterceptSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, Intercept intercept)
        throws SQLException
    {
        Timestamp createDtTimestamp = new Timestamp(intercept.getCreateDate().getTime());
        Timestamp updateDtTimestamp = new Timestamp(intercept.getDateUpdated().getTime());
        Timestamp transactionDtTimestamp = new Timestamp(intercept.getTransactionDate().getTime());
        try
        {
            updateInterceptStmt = conn.prepareStatement(updateInterceptSQL);
            updateInterceptStmt.setInt(1, intercept.getInterceptOidNumber());
            updateInterceptStmt.setInt(2, intercept.getShipmentOidNumber());
            updateInterceptStmt.setInt(3, intercept.getPieceOidNumber());
            updateInterceptStmt.setString(4, intercept.getInterceptCode());
            updateInterceptStmt.setString(5, intercept.getActiveFlag());
            updateInterceptStmt.setTimestamp(6, createDtTimestamp);
            updateInterceptStmt.setString(7, intercept.getEmployeeNumberForCreation());
            updateInterceptStmt.setString(8, intercept.getProcessNameCreated());
            updateInterceptStmt.setTimestamp(9, updateDtTimestamp);
            updateInterceptStmt.setString(10, intercept.getEmployeeNumberForUpdate());
            updateInterceptStmt.setString(11, intercept.getProcessNameUpdated());
            updateInterceptStmt.setInt(12, intercept.getStagingAreaPriorityNumber());
            updateInterceptStmt.setTimestamp(13, transactionDtTimestamp);
            updateInterceptStmt.setString(14, intercept.getAgencyCode());
            updateInterceptStmt.setString(15, intercept.getFromRecurringCriteriaFlag());
            updateInterceptStmt.setInt(16, intercept.getInterceptOidNumber());
            updateInterceptStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = intercept.getInterceptOidNumber() + ", " + intercept.getShipmentOidNumber() + ", " + intercept.getPieceOidNumber() + ", " + intercept.getInterceptCode() + ", " + intercept.getActiveFlag() + ", " + createDtTimestamp + ", " + intercept.getEmployeeNumberForCreation() + ", " + intercept.getProcessNameCreated() + ", " + updateDtTimestamp + ", " + intercept.getEmployeeNumberForUpdate() + ", " + intercept.getProcessNameUpdated() + ", " + intercept.getStagingAreaPriorityNumber() + ", " + transactionDtTimestamp + ", " + intercept.getAgencyCode() + ", " + intercept.getFromRecurringCriteriaFlag() + ", " + intercept.getInterceptOidNumber();
            printSQLException(ex, getClass().getName(), "update", updateInterceptSQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String selectColumns;
    private String interceptTable;
    private String interceptDefTable;
    private String joinInterceptDefTable;
    private String agencyTable;
    private String joinAgencyTable;
    private String agencyStagingAreaTable;
    private String interceptStagingAreaTable;
    private String pieceTable;
    private String shipmentTable;
    private String joinPhysicalScanCountView;
    private String where;
    private String fetchInterceptSecuredWithActiveFlagSQL;
    private String fetchInterceptWithActiveFlagSQL;
    private String fetchInterceptByPieceOidSQL;
    private String fetchInterceptByShipmentOidSQL;
    private String fetchInterceptByShipOidSACdActFlgSQL;
    private String fetchInteceptByAgencyJoinSQL;
    private String fetchInterceptByShipOid_IntcpCdSQL;
    private String fetchActiveInterceptByShipOid_PcOid_IntcpCdSQL;
    private String fetchActiveInterceptByShipOidOrPcOidSQL;
    private String fetchActiveIntercptByAgencySQL;
    private String saveInterceptSQL;
    private String removeInterceptSQL;
    private String updateInterceptSQL;
    private PreparedStatement fetchInterceptSecuredWithActiveFlagStmt;
    private PreparedStatement fetchInterceptWithActiveFlagStmt;
    private PreparedStatement fetchInterceptByPieceOidStmt;
    private PreparedStatement fetchInterceptByShipmentOidStmt;
    private PreparedStatement fetchInterceptByShipOidSACdActFlgStmt;
    private PreparedStatement fetchInteceptByAgencyJoinStmt;
    private PreparedStatement fetchInterceptByShipOid_IntcpCdStmt;
    private PreparedStatement fetchActiveInterceptByShipOid_PcOid_IntcpCdStmt;
    private PreparedStatement fetchActiveInterceptByShipOidOrPcOidStmt;
    private PreparedStatement fetchActiveIntercptByAgencyStmt;
    private PreparedStatement saveInterceptStmt;
    private PreparedStatement removeInterceptStmt;
    private PreparedStatement updateInterceptStmt;
}
