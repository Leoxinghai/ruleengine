// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DatabaseBean.java

package cciij.cciidatabase;

import cciij.cciidata.*;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;
import rmtc.util.Config;

// Referenced classes of package cciij.cciidatabase:
//            DbShipment, DbHandlingUnit, DbIntercept, DbRouteLeg, 
//            DbScan, DbConsSummary, DbCons, DbPrinterConfiguration, 
//            DbPieceRouteLeg, DbHandlingInstruction, DbHandlingInstructionDef, DbReasonCode, 
//            DbReasonCodeDefinition, DbInterceptDef, DbStagingArea, DbAgency, 
//            DbPAResolveDup, DbScanDefinition, DbDetainmentLocDef, DbSiteParam, 
//            DbActivityDef, DbClearanceActivity, DbReleaseCode, DbReleaseCodeDef, 
//            DbShipmentRemark, DbShipmentRemarkDef, DbWarehouseDef, DbAgencyStagingArea, 
//            DbInterceptStagingArea, DbNextOid, DbShuttle, DbUpload, 
//            DbFlightInfo, DbPieceStatus, DbUploadCategoryDef, DbContractBroker, 
//            DbParty, DbSplit, DbLocationDef, DbCountryDef, 
//            DbInTransit, DbEntry, DbEntryTypeDef, DbCustomsNumberMgmt

public class DatabaseBean
{

    public DatabaseBean()
    {
        m_server = "";
        m_user = "";
        m_password = "";
        m_schema = "";
        m_locationCd = "";
        m_validLocationCd = null;
        conn = null;
        dbShip = null;
        dbHandlingUnit = null;
        dbIntercept = null;
        dbRouteLeg = null;
        dbScan = null;
        dbConsSummary = null;
        dbCons = null;
        dbPrinterConfiguration = null;
        dbPieceRouteLeg = null;
        dbHandlingInstruction = null;
        dbHandlingInstructionDef = null;
        dbReasonCode = null;
        dbReasonCodeDef = null;
        dbInterceptDef = null;
        dbStagingArea = null;
        dbAgency = null;
        dbPAResolveDup = null;
        dbScanDef = null;
        dbDetLoc = null;
        dbSiteParam = null;
        dbActivityDef = null;
        dbClearanceActivity = null;
        dbReleaseCode = null;
        dbReleaseCodeDef = null;
        dbShipmentRemark = null;
        dbShipmentRemarkDef = null;
        dbWarehouseDef = null;
        dbAgencyStagingArea = null;
        dbInterceptStagingArea = null;
        dbNextOid = null;
        dbShuttle = null;
        dbUpload = null;
        dbFlightInfo = null;
        dbPieceStatus = null;
        dbUploadCategoryDef = null;
        dbContractBroker = null;
        dbParty = null;
        dbSplit = null;
        dbLocationDef = null;
        dbCountryDef = null;
        dbInTransit = null;
        dbEntry = null;
        dbEntryTypeDef = null;
        dbCustomsNumberMgmt = null;
        
        dbBatch = null;
        dbBatchSummary = null;
        dbTruck = null;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public void connect()
    {
        try
        {
            DriverManager.registerDriver(new OracleDriver());
            readConfigFile();
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + m_server, m_user, m_password);
            setDatabaseSchemaName();
            dbShip = new DbShipment();
            dbHandlingUnit = new DbHandlingUnit();
            dbIntercept = new DbIntercept();
            dbRouteLeg = new DbRouteLeg();
            dbScan = new DbScan();
            dbConsSummary = new DbConsSummary();
            dbCons = new DbCons();
            dbPrinterConfiguration = new DbPrinterConfiguration();
            dbPieceRouteLeg = new DbPieceRouteLeg();
            dbHandlingInstruction = new DbHandlingInstruction();
            dbHandlingInstructionDef = new DbHandlingInstructionDef();
            dbReasonCode = new DbReasonCode();
            dbReasonCodeDef = new DbReasonCodeDefinition();
            dbInterceptDef = new DbInterceptDef();
            dbStagingArea = new DbStagingArea();
            dbAgency = new DbAgency();
            dbPAResolveDup = new DbPAResolveDup();
            dbScanDef = new DbScanDefinition();
            dbDetLoc = new DbDetainmentLocDef();
            dbSiteParam = new DbSiteParam();
            dbActivityDef = new DbActivityDef();
            dbClearanceActivity = new DbClearanceActivity();
            dbReleaseCode = new DbReleaseCode();
            dbReleaseCodeDef = new DbReleaseCodeDef();
            dbShipmentRemark = new DbShipmentRemark();
            dbShipmentRemarkDef = new DbShipmentRemarkDef();
            dbWarehouseDef = new DbWarehouseDef();
            dbAgencyStagingArea = new DbAgencyStagingArea();
            dbInterceptStagingArea = new DbInterceptStagingArea();
            dbNextOid = new DbNextOid();
            dbShuttle = new DbShuttle();
            dbUpload = new DbUpload();
            dbFlightInfo = new DbFlightInfo();
            dbPieceStatus = new DbPieceStatus();
            dbUploadCategoryDef = new DbUploadCategoryDef();
            dbContractBroker = new DbContractBroker();
            dbParty = new DbParty();
            dbSplit = new DbSplit();
            dbLocationDef = new DbLocationDef();
            dbCountryDef = new DbCountryDef();
            dbInTransit = new DbInTransit();
            dbEntry = new DbEntry();
            dbEntryTypeDef = new DbEntryTypeDef();
            
            dbBatch = new DbBatch();
            dbBatchSummary = new DbBatchSummary();
            dbTruck = new DbTruck();
            
            dbCustomsNumberMgmt = new DbCustomsNumberMgmt();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            ex.getClass();
            System.out.println("DATABASEBEAN--ERROR in connect(): " + ex);
        }
    }

    public Vector getValidSiteLocCd()
    {
        String temp = null;
        Vector sites = new Vector();
        try
        {
            for(temp = fetchSiteParamAllSiteLocationCd(); temp != null; temp = fetchSiteParamNextSiteLocationCd())
                sites.add(temp);

        }
        catch(SQLException se)
        {
            sites = null;
        }
        if(sites != null)
            m_validLocationCd = sites;
        return sites;
    }

    public void setLocationCode(String locationCd)
    {
        if(locationCd != null && !locationCd.equals(""))
            m_locationCd = locationCd;
    }

    public String getLocationCode()
    {
        return m_locationCd;
    }

    public void setConnection(Connection c)
    {
        conn = c;
        if(conn != null)
            try
            {
                setDatabaseSchemaName();
            }
            catch(Exception e)
            {
                System.out.println("Failed to set Schema Name:  " + e);
                System.err.println("Failed to set Schema Name:  " + e);
                e.printStackTrace(System.out);
                e.printStackTrace();
            }
    }

    public Connection getConnection()
    {
        return conn;
    }

    public void connect(Connection newConn)
    {
        try
        {
            readConfigFile();
            setConnection(newConn);
            dbShip = new DbShipment();
            dbHandlingUnit = new DbHandlingUnit();
            dbIntercept = new DbIntercept();
            dbRouteLeg = new DbRouteLeg();
            dbScan = new DbScan();
            dbConsSummary = new DbConsSummary();
            dbCons = new DbCons();
            dbPrinterConfiguration = new DbPrinterConfiguration();
            dbPieceRouteLeg = new DbPieceRouteLeg();
            dbHandlingInstruction = new DbHandlingInstruction();
            dbHandlingInstructionDef = new DbHandlingInstructionDef();
            dbReasonCode = new DbReasonCode();
            dbReasonCodeDef = new DbReasonCodeDefinition();
            dbInterceptDef = new DbInterceptDef();
            dbStagingArea = new DbStagingArea();
            dbAgency = new DbAgency();
            dbPAResolveDup = new DbPAResolveDup();
            dbScanDef = new DbScanDefinition();
            dbSiteParam = new DbSiteParam();
            dbActivityDef = new DbActivityDef();
            dbClearanceActivity = new DbClearanceActivity();
            dbReleaseCode = new DbReleaseCode();
            dbReleaseCodeDef = new DbReleaseCodeDef();
            dbShipmentRemarkDef = new DbShipmentRemarkDef();
            dbShipmentRemark = new DbShipmentRemark();
            dbWarehouseDef = new DbWarehouseDef();
            dbAgencyStagingArea = new DbAgencyStagingArea();
            dbInterceptStagingArea = new DbInterceptStagingArea();
            dbNextOid = new DbNextOid();
            dbShuttle = new DbShuttle();
            dbUpload = new DbUpload();
            dbFlightInfo = new DbFlightInfo();
            dbPieceStatus = new DbPieceStatus();
            dbUploadCategoryDef = new DbUploadCategoryDef();
            dbContractBroker = new DbContractBroker();
            dbParty = new DbParty();
            dbSplit = new DbSplit();
            dbLocationDef = new DbLocationDef();
            dbCountryDef = new DbCountryDef();
            dbInTransit = new DbInTransit();
            dbEntry = new DbEntry();
            dbEntryTypeDef = new DbEntryTypeDef();

            dbBatch = new DbBatch();
            dbBatchSummary = new DbBatchSummary();
            dbTruck = new DbTruck();
            dbCustomsNumberMgmt = new DbCustomsNumberMgmt();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            ex.getClass();
            System.out.println("DATABASEBEAN--ERROR in connect(Connection): " + ex);
        }
    }

    protected void readConfigFile()
        throws Exception
    {
        try
        {
            m_config = new Config();
            m_server = m_config.getValue("JDBC_SERVER");
            m_user = m_config.getValue("JDBC_USER");
            m_password = m_config.getValue("JDBC_PASSWORD");
            m_schema = m_config.getValue("JDBC_SCHEMA");
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    public void setDatabaseSchemaName()
        throws Exception
    {
        try
        {
            String setSchemaNameSQL = "ALTER SESSION SET CURRENT_SCHEMA = " + m_schema;
            PreparedStatement setSchemaNameStmt = conn.prepareStatement(setSchemaNameSQL);
            setSchemaNameStmt.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println("Alter Session Error:  " + ex);
            System.out.println(ex + ".getMessage() ==>" + ex.getMessage() + "<==");
            ex.printStackTrace(System.out);
            throw ex;
        }
    }

    protected void finalize()
    {
    }

    public void closeConnection()
    {
        if(conn == null)
        {
            System.out.println("DATABASEBEAN--WARNING in closeConnection; conn is already null");
            return;
        }
        try
        {
            if(!conn.isClosed())
                conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println("DATABASEBEAN--ERROR in closeConnection " + ex);
        }
        return;
    }

    public boolean commitTransaction()
    {
        return true;
    }

    public boolean rollbackTransaction()
    {
        return true;
    }

    public Shipment fetchShipment(int shipOid)
        throws SQLException
    {
        return dbShip.fetchAllowNullLocation(conn, shipOid, m_locationCd);
    }

    public Shipment fetchShipment(String AWBNbr)
        throws SQLException
    {
        return dbShip.fetch(conn, AWBNbr, m_locationCd);
    }

    public Shipment fetchShipment(String AWBNbr, String locationList[])
        throws SQLException
    {
        return dbShip.fetch(conn, AWBNbr, m_locationCd, locationList);
    }

    public Shipment fetchShipment(String AWBNbr, int hawbSerialNbr, java.util.Date inputDt, String destLocCd, String originLocCd)
        throws SQLException
    {
        return dbShip.fetch(conn, m_locationCd, AWBNbr, hawbSerialNbr, inputDt, destLocCd, originLocCd);
    }

    public Shipment fetchNextShipment()
        throws SQLException
    {
        return dbShip.fetchNext(m_locationCd);
    }

    public void saveShipment(Shipment ship)
        throws SQLException
    {
        dbShip.save(conn, ship, m_locationCd);
    }

    public void removeShipment(Shipment ship)
        throws SQLException
    {
        dbShip.remove(conn, ship);
    }

    public void removeShipmentCoreClearance(Shipment ship)
        throws SQLException
    {
        dbShip.removeCoreClearance(conn, ship, m_locationCd);
    }

    public void removeAllShipmentCoreClearance(Shipment ship)
        throws SQLException
    {
        dbShip.removeAllCoreClearance(conn, ship);
    }

    public void updateShipment(Shipment ship)
        throws SQLException
    {
        dbShip.update(conn, ship, m_locationCd);
    }

    public void updateShipmentCoreClearance(Shipment ship)
        throws SQLException
    {
        dbShip.updateCoreClearance(conn, ship, m_locationCd);
    }

    public void updateShipmentCoreClearanceWarehouse(int shipmentOid, String warehouseCode)
    throws SQLException
	{
	    dbShip.updateCoreClearanceWarehouse(conn, shipmentOid, warehouseCode, m_locationCd);
	}

    public int getShipmentRecordCount()
    {
        return dbShip.getShipmentRecordCount();
    }

    public HandlingUnit fetchHandlingUnit(int pieceOid)
        throws SQLException
    {
        return dbHandlingUnit.fetchAllowNullLocation(conn, pieceOid, m_locationCd);
    }

    public HandlingUnit fetchAllNonScannedPiecesOnRoute(String routeNbr, java.util.Date routeDt, int routeLegNbr)
        throws SQLException
    {
        return dbHandlingUnit.fetchAllNonScannedPiecesOnRoute(conn, routeNbr, routeDt, routeLegNbr, m_locationCd);
    }

    public HandlingUnit fetchHandlingUnitWithShipmentOid(int shipmentOid)
        throws SQLException
    {
        return dbHandlingUnit.fetchHandlingUnitWithShipmentOid(conn, shipmentOid, m_locationCd);
    }

    public HandlingUnit fetchHandlingUnitWithShipmentOidAndTrackingNbr(int shipmentOid, String trackingNbr)
        throws SQLException
    {
        return dbHandlingUnit.fetchHandlingUnitWithShipmentOidAndTrackingNbr(conn, shipmentOid, trackingNbr, m_locationCd);
    }

    public HandlingUnit fetchHandlingUnitPickList(String stagingAreaCd, String warehouseCode)
        throws SQLException
    {
        return dbHandlingUnit.fetchPickList(conn, stagingAreaCd, m_locationCd, warehouseCode);
    }

    public HandlingUnit fetchHandlingUnit(String trkNbr)
        throws SQLException
    {
        return dbHandlingUnit.fetch(conn, trkNbr, m_locationCd);
    }

    public HandlingUnit fetchHandlingUnit(String trkNbr, String locationList[])
        throws SQLException
    {
        return dbHandlingUnit.fetch(conn, trkNbr, m_locationCd, locationList);
    }

    public HandlingUnit fetchNextHandlingUnit()
        throws SQLException
    {
        return dbHandlingUnit.fetchNext(m_locationCd);
    }

    public void saveHandlingUnit(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.save(conn, hu, m_locationCd);
    }

    public void saveHandlingUnitCoreClearance(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.saveCoreClearance(conn, hu, m_locationCd);
    }

    public void removeHandlingUnit(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.remove(conn, hu);
    }

    public void removeHandlingUnitAllCoreClearance(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.removeAllCoreClearance(conn, hu);
    }

    public void removeHandlingUnitCoreClearance(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.removeCoreClearance(conn, hu, m_locationCd);
    }

    public void updateHandlingUnit(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.update(conn, hu, m_locationCd);
    }

    public void updateHandlingUnitCoreClearance(HandlingUnit hu)
        throws SQLException
    {
        dbHandlingUnit.updateCoreClearance(conn, hu, m_locationCd);
    }

    public int getHandlingUnitRecordCount()
    {
        return dbHandlingUnit.getHandlingUnitRecordCount();
    }

    public Intercept fetchInterceptWithActiveFlag(int shipmentOid)
        throws SQLException
    {
        return dbIntercept.fetchWithActiveFlag(conn, shipmentOid, m_locationCd);
    }

    public Intercept fetchInterceptSecuredWithActiveFlag(int shipmentOid)
        throws SQLException
    {
        return dbIntercept.fetchSecuredWithActiveFlag(conn, shipmentOid, m_locationCd);
    }

    public Intercept fetchInterceptByPieceOid(String agencyCode, int pieceOidNumber, String interceptCode, String activeFlag)
        throws SQLException
    {
        return dbIntercept.fetchByPieceOid(conn, agencyCode, pieceOidNumber, interceptCode, activeFlag, m_locationCd);
    }

    public Intercept fetchInterceptByShipmentOid(String agencyCode, int shipmentOidNumber, String interceptCode, String activeFlag)
        throws SQLException
    {
        return dbIntercept.fetchByShipmentOid(conn, agencyCode, shipmentOidNumber, interceptCode, activeFlag, getLocationCode());
    }

    public Intercept fetchInterceptByInterceptDefJoin(int shipmentOid, int pieceOid, String stageAreaCd, String warehouseCd)
        throws SQLException
    {
        return dbIntercept.fetch(conn, shipmentOid, pieceOid, stageAreaCd, warehouseCd, getLocationCode());
    }

    public Intercept fetchInterceptWithShipOidAndInterceptCd(int shipmentOid, String interceptCd)
        throws SQLException
    {
        return dbIntercept.fetchWithOidAndInterceptCd(conn, shipmentOid, interceptCd, getLocationCode());
    }

    public Intercept fetchInterceptJoiningAgencyTable(int shipmentOid, int pieceOid, String stageAreaCd, String warehouseCd)
        throws SQLException
    {
        return dbIntercept.fetchJoiningAgencyTable(conn, shipmentOid, pieceOid, stageAreaCd, warehouseCd, getLocationCode());
    }

    public Intercept fetchInterceptByShipmentOrPieceOid(int shipmentOid, int pieceOid)
        throws SQLException
    {
        return dbIntercept.fetchActiveInterceptByShipOid_PcOid_IntcpCd(conn, shipmentOid, pieceOid, getLocationCode());
    }

    public Intercept fetchIntercept(int shipmentOid, int pieceOid)
        throws SQLException
    {
        return dbIntercept.fetch(conn, shipmentOid, pieceOid, getLocationCode());
    }

    public Intercept fetchNextIntercept()
        throws SQLException
    {
        return dbIntercept.fetchNext();
    }

    public void saveIntercept(Intercept intercept)
        throws SQLException
    {
        dbIntercept.save(conn, intercept, getLocationCode());
    }

    public void removeIntercept(Intercept intercept)
        throws SQLException
    {
        dbIntercept.remove(conn, intercept);
    }

    public void updateIntercept(Intercept intercept)
        throws SQLException
    {
        dbIntercept.update(conn, intercept);
    }

    public int getInterceptRecordCount()
    {
        return dbIntercept.getInterceptRecordCount();
    }

    public RouteLeg fetchRouteLeg(String routeNumber, java.util.Date routeDate, int routeLegNumber)
        throws SQLException
    {
        return dbRouteLeg.fetch(conn, routeNumber, routeDate, routeLegNumber);
    }

    public java.util.Date fetchRouteLeg(String destinationLocCd)
        throws SQLException
    {
        return dbRouteLeg.fetchByDestLocCd(conn, destinationLocCd);
    }

    public String fetchRouteLegByDistinctRouteNumber(String destinationLocCd)
        throws SQLException
    {
        return dbRouteLeg.fetchByDistinctRouteNumber(conn, destinationLocCd);
    }

    public RouteLeg fetchRouteLeg(java.util.Date sortDate, String destinationLocCd)
        throws SQLException
    {
        return dbRouteLeg.fetch(conn, sortDate, destinationLocCd);
    }

    public RouteLeg fetchRouteLeg(int pcOid, String destLocCd)
        throws SQLException
    {
        return dbRouteLeg.fetch(conn, pcOid, destLocCd);
    }

    public RouteLeg fetchRouteLeg(String destLocCd, int shipmentOID)
        throws SQLException
    {
        return dbRouteLeg.fetch(conn, destLocCd, shipmentOID);
    }

    public RouteLeg fetchRouteLeg(int rtLegOidNbr)
        throws SQLException
    {
        return dbRouteLeg.fetch(conn, rtLegOidNbr);
    }

    public String fetchNextDisctinctRouteNumber()
        throws SQLException
    {
        return dbRouteLeg.fetchNextRouteNumber();
    }

    public java.util.Date fetchNextDistinctSortDate()
        throws SQLException
    {
        return dbRouteLeg.fetchNextSortDt();
    }

    public RouteLeg fetchNextRouteLeg()
        throws SQLException
    {
        return dbRouteLeg.fetchNext();
    }

    public void saveRouteLeg(RouteLeg routeLeg)
        throws SQLException
    {
        dbRouteLeg.save(conn, routeLeg);
    }

    public void removeRouteLeg(RouteLeg routeLeg)
        throws SQLException
    {
        dbRouteLeg.remove(conn, routeLeg);
    }

    public void updateRouteLeg(RouteLeg routeLeg)
        throws SQLException
    {
        dbRouteLeg.update(conn, routeLeg);
    }

    public int getRouteLegRecordCount()
    {
        return dbRouteLeg.getRouteLegRecordCount();
    }

    public Scan fetchScan(String scanTypeCd, int pieceOid, int shipOid)
        throws SQLException
    {
        return dbScan.fetch(conn, scanTypeCd, pieceOid, shipOid, m_locationCd);
    }

    public Scan fetchScan(String scanTypeCd, int shipOid)
        throws SQLException
    {
        return dbScan.fetch(conn, scanTypeCd, shipOid, m_locationCd);
    }

    public Scan fetchScanWithHandlingUnitOid(int handlingUnitOid)
        throws SQLException
    {
        return dbScan.fetchWithHUOid(conn, handlingUnitOid, m_locationCd);
    }

    public Scan fetchScanInPhysicalCustody(int handlingUnitOid)
        throws SQLException
    {
        return dbScan.fetchWithPhysicalCustody(conn, handlingUnitOid, m_locationCd);
    }

    public Scan fetchNextScan()
        throws SQLException
    {
        return dbScan.fetchNext();
    }

    public void saveScan(Scan scan)
        throws SQLException
    {
        dbScan.save(conn, scan, m_locationCd);
    }

    public void removeScan(Scan scan)
        throws SQLException
    {
        dbScan.remove(conn, scan);
    }

    public void updateScan(Scan scan)
        throws SQLException
    {
        dbScan.update(conn, scan);
    }

    public int getScanRecordCount()
    {
        return dbScan.getScanRecordCount();
    }

    public ConsSummary fetchConsSummary(int consOid)
        throws SQLException
    {
        return dbConsSummary.fetch(conn, consOid);
    }

    public ConsSummary fetchConsSummary(String consNbr)
        throws SQLException
    {
        return dbConsSummary.fetch(conn, consNbr);
    }

    public ConsSummary fetchNextConsSummary()
        throws SQLException
    {
        return dbConsSummary.fetchNext();
    }

    public void saveConsSummary(ConsSummary consSum)
        throws SQLException
    {
        dbConsSummary.save(conn, consSum);
    }

    public void updateConsSummary(ConsSummary consSum)
        throws SQLException
    {
        dbConsSummary.update(conn, consSum);
    }

    public int getConsSummaryRecordCount()
    {
        return dbConsSummary.getConsSummaryRecordCount();
    }

    public Cons fetchCons(int consOid, String trackingNbr)
        throws SQLException
    {
        return dbCons.fetch(conn, consOid, trackingNbr);
    }

    public Cons fetchCons(int consOid)
    throws SQLException
	{
	    return dbCons.fetch(conn, consOid);
	}
    
    public Cons fetchCons(String consNbr)
        throws SQLException
    {
        return dbCons.fetch(conn, consNbr);
    }

    public Cons fetchNextCons()
        throws SQLException
    {
        return dbCons.fetchNext();
    }

    public void saveCons(Cons cons)
        throws SQLException
    {
        dbCons.save(conn, cons);
    }

    public void updateCons(Cons cons)
        throws SQLException
    {
        dbCons.update(conn, cons);
    }

    public int getConsRecordCount()
    {
        return dbCons.getConsRecordCount();
    }

    public PrinterConfiguration fetchPrinterConfiguration(String printerCd)
        throws SQLException
    {
        return dbPrinterConfiguration.fetch(conn, m_locationCd, printerCd);
    }

    public PrinterConfiguration fetchPrinterConfiguration()
        throws SQLException
    {
        return dbPrinterConfiguration.fetch(conn, m_locationCd);
    }

    public PrinterConfiguration fetchNextPrinterConfiguration()
        throws SQLException
    {
        return dbPrinterConfiguration.fetchNext();
    }

    public void savePrinterConfiguration(PrinterConfiguration printConfig)
        throws SQLException
    {
        dbPrinterConfiguration.save(conn, printConfig, m_locationCd);
    }

    public void removePrinterConfiguration(PrinterConfiguration printConfig)
        throws SQLException
    {
        dbPrinterConfiguration.remove(conn, printConfig, m_locationCd);
    }

    public void updatePrinterConfiguration(PrinterConfiguration printConfig)
        throws SQLException
    {
        dbPrinterConfiguration.update(conn, printConfig, m_locationCd);
    }

    public int getPrinterConfigurationRecordCount()
    {
        return dbPrinterConfiguration.getPrinterConfigurationRecordCount();
    }

    public PieceRouteLeg fetchAllPiecesForRouteLeg(RouteLeg routeLeg)
        throws SQLException
    {
        return dbPieceRouteLeg.fetch(conn, routeLeg.getRouteNumber(), routeLeg.getRouteDate(), routeLeg.getRouteLegNumber());
    }

    public PieceRouteLeg fetchPieceRouteLeg(int pieceOidNumber)
        throws SQLException
    {
        return dbPieceRouteLeg.fetch(conn, pieceOidNumber);
    }

    public PieceRouteLeg fetchNextPieceRouteLeg()
        throws SQLException
    {
        return dbPieceRouteLeg.fetchNext();
    }

    public void savePieceRouteLeg(PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        dbPieceRouteLeg.save(conn, pcRouteLeg);
    }

    public void removePieceRouteLeg(PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        dbPieceRouteLeg.remove(conn, pcRouteLeg);
    }

    public void updatePieceRouteLeg(PieceRouteLeg pcRouteLeg)
        throws SQLException
    {
        dbPieceRouteLeg.update(conn, pcRouteLeg);
    }

    public int getPieceRouteLegRecordCount()
    {
        return dbPieceRouteLeg.getPieceRouteLegRecordCount();
    }

    public HandlingInstructions fetchHandlingInstruction(int handlingInstructionOidNumber)
        throws SQLException
    {
        return dbHandlingInstruction.fetch(conn, handlingInstructionOidNumber);
    }

    public HandlingInstructions fetchHandlingInstructionByShipmentOrPieceOid(int shipmentOidNumber, int pieceOidNumber)
        throws SQLException
    {
        return dbHandlingInstruction.fetchByShipmentOrPieceOidNbr(conn, m_locationCd, shipmentOidNumber, pieceOidNumber);
    }

    public HandlingInstructions fetchHandlingInstructionByShipmentOid(int shipmentOidNumber)
        throws SQLException
    {
        return dbHandlingInstruction.fetchByShipmentOidNbr(conn, m_locationCd, shipmentOidNumber);
    }

    public HandlingInstructions fetchHandlingInstructionByPieceOid(int pieceOidNumber)
        throws SQLException
    {
        return dbHandlingInstruction.fetchByPieceOidNbr(conn, m_locationCd, pieceOidNumber);
    }

    public HandlingInstructions fetchNextHandlingInstruction()
        throws SQLException
    {
        return dbHandlingInstruction.fetchNext();
    }

    public void saveHandlingInstruction(HandlingInstructions handlingInstruction)
        throws SQLException
    {
        dbHandlingInstruction.save(conn, handlingInstruction);
    }

    public void removeHandlingInstruction(HandlingInstructions handlingInstruction)
        throws SQLException
    {
        dbHandlingInstruction.remove(conn, handlingInstruction);
    }

    public void updateHandlingInstruction(HandlingInstructions handlingInstruction)
        throws SQLException
    {
        dbHandlingInstruction.update(conn, handlingInstruction);
    }

    public int getHandlingInstructionRecordCount()
    {
        return dbHandlingInstruction.getHandlingInstructionRecordCount();
    }

    public HandlingInstructionDefinition fetchHandlingInstructionDef(String handlingInstructionCode)
        throws SQLException
    {
        return dbHandlingInstructionDef.fetch(conn, m_locationCd, handlingInstructionCode);
    }

    public HandlingInstructionDefinition fetchHandlingInstructionDef()
        throws SQLException
    {
        return dbHandlingInstructionDef.fetch(conn, m_locationCd);
    }

    public HandlingInstructionDefinition fetchNextHandlingInstructionDef()
        throws SQLException
    {
        return dbHandlingInstructionDef.fetchNext();
    }

    public void saveHandlingInstructionDef(HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        dbHandlingInstructionDef.save(conn, hiDef);
    }

    public void removeHandlingInstructionDef(HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        dbHandlingInstructionDef.remove(conn, hiDef);
    }

    public void updateHandlingInstructionDef(HandlingInstructionDefinition hiDef)
        throws SQLException
    {
        dbHandlingInstructionDef.update(conn, hiDef);
    }

    public int getHandlingInstructionDef()
    {
        return dbHandlingInstructionDef.getHandlingInstructionDefRecordCount();
    }

    public ReasonCodeDefinition fetchReasonCodeDef(String reasonCode)
        throws SQLException
    {
        return dbReasonCodeDef.fetch(conn, m_locationCd, reasonCode);
    }

    public ReasonCodeDefinition fetchReasonCodeDef()
        throws SQLException
    {
        return dbReasonCodeDef.fetch(conn, m_locationCd);
    }

    public ReasonCodeDefinition fetchNextReasonCodeDef()
        throws SQLException
    {
        return dbReasonCodeDef.fetchNext();
    }

    public void saveReasonCodeDef(ReasonCodeDefinition rcd)
        throws SQLException
    {
        dbReasonCodeDef.save(conn, m_locationCd, rcd);
    }

    public void removeReasonCodeDef(ReasonCodeDefinition rcd)
        throws SQLException
    {
        dbReasonCodeDef.remove(conn, m_locationCd, rcd);
    }

    public void updateReasonCodeDef(ReasonCodeDefinition rcd)
        throws SQLException
    {
        dbReasonCodeDef.update(conn, m_locationCd, rcd);
    }

    public int getReasonCodeDefRecordCount()
    {
        return dbReasonCodeDef.getReasonCodeDefRecordCount();
    }

    public int getReasonCodeRecordCount()
    {
        return dbReasonCode.getReasonCodeRecordCount();
    }

    public ReasonCode fetchReasonCode(String locationCd)
        throws SQLException
    {
        return dbReasonCode.fetch(conn, locationCd);
    }

    public ReasonCode fetchReasonCode(String locationCd, int reasonOidNbr)
        throws SQLException
    {
        return dbReasonCode.fetch(conn, locationCd, reasonOidNbr);
    }

    public ReasonCode fetchReasonCodeWithActiveFlag(String locationCd)
        throws SQLException
    {
        return dbReasonCode.fetchReasonCodeWithActiveFlag(conn, locationCd);
    }

    public ReasonCode fetchReasonCodeByPieceOid(String locationCd, int pieceOidNbr)
        throws SQLException
    {
        return dbReasonCode.fetchReasonCodeByPieceOid(conn, locationCd, pieceOidNbr);
    }

    public ReasonCode fetchReasonCodeByShipmentOid(String locationCd, int shipmentOidNbr)
        throws SQLException
    {
        return dbReasonCode.fetchReasonCodeByShipmentOid(conn, locationCd, shipmentOidNbr);
    }

    public ReasonCode fetchReasonCodeByShipOrPieceOid(String locationCd, int shipmentOidNbr, int pieceOidNbr)
        throws SQLException
    {
        return dbReasonCode.fetchReasonCodeByShipOrPieceOid(conn, locationCd, shipmentOidNbr, pieceOidNbr);
    }

    public ReasonCode fetchNextReasonCode()
        throws SQLException
    {
        return dbReasonCode.fetchNext();
    }

    public void saveReasonCode(ReasonCode rc)
        throws SQLException
    {
        dbReasonCode.save(conn, rc, m_locationCd);
    }

    public void removeReasonCode(ReasonCode rc)
        throws SQLException
    {
        dbReasonCode.remove(conn, rc);
    }

    public void updateReasonCode(ReasonCode rc)
        throws SQLException
    {
        dbReasonCode.update(conn, rc);
    }

    public InterceptCodeDefinition fetchInterceptCodeDef(String interceptCode)
        throws SQLException
    {
        return dbInterceptDef.fetch(conn, interceptCode, m_locationCd);
    }

    public InterceptCodeDefinition fetchInterceptCodeDef()
        throws SQLException
    {
        return dbInterceptDef.fetch(conn, m_locationCd);
    }

    public InterceptCodeDefinition fetchInterceptCodeDefAllActive()
        throws SQLException
    {
        return dbInterceptDef.fetchAllActiveInterceptDef(conn, getLocationCode());
    }

    public InterceptCodeDefinition fetchNextInterceptCodeDef()
        throws SQLException
    {
        return dbInterceptDef.fetchNext();
    }

    public void saveInterceptCodeDef(InterceptCodeDefinition icd)
        throws SQLException
    {
        dbInterceptDef.save(conn, icd, m_locationCd);
    }

    public void removeInterceptCodeDef(InterceptCodeDefinition icd)
        throws SQLException
    {
        dbInterceptDef.remove(conn, icd);
    }

    public void updateInterceptCodeDef(InterceptCodeDefinition icd)
        throws SQLException
    {
        dbInterceptDef.update(conn, icd);
    }

    public int getInterceptCodeDefRecordCount()
    {
        return dbInterceptDef.getInterceptDefRecordCount();
    }

    public StagingArea fetchStagingArea(String stagingAreaCode)
        throws SQLException
    {
        return dbStagingArea.fetch(conn, stagingAreaCode, m_locationCd);
    }

    public StagingArea fetchStagingArea()
        throws SQLException
    {
        return dbStagingArea.fetch(conn, m_locationCd);
    }

    public StagingArea fetchStagingAreaAllActive()
        throws SQLException
    {
        return dbStagingArea.fetchAllActiveStagingArea(conn, m_locationCd);
    }

    public StagingArea fetchNextStagingArea()
        throws SQLException
    {
        return dbStagingArea.fetchNext();
    }

    public void saveStagingArea(StagingArea sa)
        throws SQLException
    {
        dbStagingArea.save(conn, sa, m_locationCd);
    }

    public void removeStagingArea(StagingArea sa)
        throws SQLException
    {
        dbStagingArea.remove(conn, sa);
    }

    public void updateStagingArea(StagingArea sa)
        throws SQLException
    {
        dbStagingArea.update(conn, sa);
    }

    public int getStagingAreaRecordCount()
    {
        return dbStagingArea.getStagingAreaRecordCount();
    }

    public Agency fetchAgency(String agencyCode)
        throws SQLException
    {
        return dbAgency.fetch(conn, agencyCode, m_locationCd);
    }

    public Agency fetchAgency()
        throws SQLException
    {
        return dbAgency.fetch(conn, m_locationCd);
    }

    public Agency fetchAgencyAllActive()
        throws SQLException
    {
        return dbAgency.fetchActiveAgency(conn, m_locationCd);
    }

    public Agency fetchNextAgency()
        throws SQLException
    {
        return dbAgency.fetchNext();
    }

    public void saveAgency(Agency agency)
        throws SQLException
    {
        dbAgency.save(conn, agency, m_locationCd);
    }

    public void removeAgency(Agency agency)
        throws SQLException
    {
        dbAgency.remove(conn, agency);
    }

    public void updateAgency(Agency agency)
        throws SQLException
    {
        dbAgency.update(conn, agency);
    }

    public int getAgencyRecordCount()
    {
        return dbAgency.getAgencyRecordCount();
    }

    public ScanDefinition fetchScanDefinition()
        throws SQLException
    {
        return dbScanDef.fetch(conn, m_locationCd);
    }

    public ScanDefinition fetchScanDefinition(String scanTypeCode)
        throws SQLException
    {
        return dbScanDef.fetch(conn, scanTypeCode, m_locationCd);
    }

    public ScanDefinition fetchScanDefinition(String scanTypeCode, String locStatNbr)
        throws SQLException
    {
        return dbScanDef.fetch(conn, scanTypeCode, locStatNbr, m_locationCd);
    }

    public ScanDefinition fetchNextScanDefinition()
        throws SQLException
    {
        return dbScanDef.fetchNext();
    }

    public void saveScanDefinition(ScanDefinition sd)
        throws SQLException
    {
        dbScanDef.save(conn, sd, m_locationCd);
    }

    public void removeScanDefinition(ScanDefinition sd)
        throws SQLException
    {
        dbScanDef.remove(conn, sd);
    }

    public void updateScanDefinition(ScanDefinition sd)
        throws SQLException
    {
        dbScanDef.update(conn, sd);
    }

    public int getScanDefRecordCount()
    {
        return dbScanDef.getScanDefRecordCount();
    }

    public DetainmentLocDef fetchDetainmentLocDef()
        throws SQLException
    {
        return dbDetLoc.fetch(conn);
    }

    public DetainmentLocDef fetchDetainmentLocDef(String locationCd, String warehouseCd, String stagingAreaCd)
        throws SQLException
    {
        return dbDetLoc.fetch(conn, m_locationCd, warehouseCd, stagingAreaCd);
    }

    public DetainmentLocDef fetchDetainmentLocDef(String locationCd, String warehouseCd, String stagingAreaCd, String detainmentLocCd)
        throws SQLException
    {
        return dbDetLoc.fetch(conn, m_locationCd, warehouseCd, stagingAreaCd, detainmentLocCd);
    }

    public DetainmentLocDef fetchNextDetainmentLocDef()
        throws SQLException
    {
        return dbDetLoc.fetchNext();
    }

    public void saveDetainmentLocDef(DetainmentLocDef dd)
        throws SQLException
    {
        dbDetLoc.save(conn, dd);
    }

    public void removeDetainmentLocDef(DetainmentLocDef dd)
        throws SQLException
    {
        dbDetLoc.remove(conn, dd);
    }

    public void updateDetainmentLocDef(DetainmentLocDef dd)
        throws SQLException
    {
        dbDetLoc.update(conn, dd);
    }

    public int getDetainmentLocDefRecordCount()
    {
        return dbDetLoc.getDetainmentLocDefRecordCount();
    }

    public SiteParam fetchSiteParam()
        throws SQLException
    {
        return dbSiteParam.fetch(conn);
    }

    public SiteParam fetchSiteParam(String locationCd)
        throws SQLException
    {
        return dbSiteParam.fetch(conn, locationCd);
    }

    public SiteParam fetchSiteParam(String locationCd, String groupNm)
        throws SQLException
    {
        return dbSiteParam.fetch(conn, locationCd, groupNm);
    }

    public SiteParam fetchNextSiteParam()
        throws SQLException
    {
        return dbSiteParam.fetchNext();
    }

    public String fetchSiteParamAllSiteLocationCd()
        throws SQLException
    {
        return dbSiteParam.fetchAllSiteLocationCd(conn);
    }

    public String fetchSiteParamNextSiteLocationCd()
        throws SQLException
    {
        return dbSiteParam.fetchNextSiteLocationCd();
    }

    public void saveSiteParam(SiteParam sp)
        throws SQLException
    {
        dbSiteParam.save(conn, sp);
    }

    public void removeSiteParam(SiteParam sp)
        throws SQLException
    {
        dbSiteParam.remove(conn, sp);
    }

    public void removeSiteParam(String locationCode, String groupName, String paramName)
        throws SQLException
    {
        dbSiteParam.remove(conn, locationCode, groupName, paramName);
    }

    public void updateSiteParam(SiteParam sp)
        throws SQLException
    {
        dbSiteParam.update(conn, sp);
    }

    public void updateSiteParamNonKeyFields(SiteParam sp)
        throws SQLException
    {
        dbSiteParam.updateNonKeyFields(conn, sp);
    }

    public void updateSiteParam(SiteParam sp, String oldParamName)
        throws SQLException
    {
        dbSiteParam.update(conn, sp, oldParamName);
    }

    public int getSiteParamRecordCount()
    {
        return dbSiteParam.getSiteParamRecordCount();
    }

    public ActivityDef fetchActivityDef(String activityCd)
        throws SQLException
    {
        return dbActivityDef.fetch(conn, activityCd, m_locationCd);
    }

    public ActivityDef fetchActivityDef()
        throws SQLException
    {
        return dbActivityDef.fetch(conn, m_locationCd);
    }

    public ActivityDef fetchNextActivityDef()
        throws SQLException
    {
        return dbActivityDef.fetchNext();
    }

    public void saveActivityDef(ActivityDef ad)
        throws SQLException
    {
        dbActivityDef.save(conn, ad, m_locationCd);
    }

    public void removeActivityDef(ActivityDef ad)
        throws SQLException
    {
        dbActivityDef.remove(conn, ad);
    }

    public void updateActivityDef(ActivityDef ad)
        throws SQLException
    {
        dbActivityDef.update(conn, ad);
    }

    public int getActivityDefRecordCount()
    {
        return dbActivityDef.getActivityDefRecordCount();
    }

    public ClearanceActivity fetchClearanceActivity(int activityOidNbr)
        throws SQLException
    {
        return dbClearanceActivity.fetch(conn, activityOidNbr, m_locationCd);
    }

    public ClearanceActivity fetchClearanceActivity(int oidNbr, String oidTypeCd)
        throws SQLException
    {
        return dbClearanceActivity.fetch(conn, oidNbr, oidTypeCd, m_locationCd);
    }

    public ClearanceActivity fetchNextClearanceActivity()
        throws SQLException
    {
        return dbClearanceActivity.fetchNext();
    }

    public void saveClearanceActivity(ClearanceActivity ad)
        throws SQLException
    {
        dbClearanceActivity.save(conn, ad, m_locationCd);
    }

    public void removeClearanceActivity(ClearanceActivity ca)
        throws SQLException
    {
        dbClearanceActivity.remove(conn, ca);
    }

    public void updateClearanceActivity(ClearanceActivity ca)
        throws SQLException
    {
        dbClearanceActivity.update(conn, ca);
    }

    public int getClearanceActivityRecordCount()
    {
        return dbClearanceActivity.getClearanceActivityRecordCount();
    }

    public ReleaseCodeDef fetchReleaseCodeDef()
        throws SQLException
    {
        return dbReleaseCodeDef.fetch(conn, m_locationCd);
    }

    public ReleaseCodeDef fetchReleaseCodeDef(String releaseCode)
        throws SQLException
    {
        return dbReleaseCodeDef.fetch(conn, m_locationCd, releaseCode);
    }

    public ReleaseCodeDef fetchNextReleaseCodeDef()
        throws SQLException
    {
        return dbReleaseCodeDef.fetchNext();
    }

    public void saveReleaseCodeDef(ReleaseCodeDef rcd)
        throws SQLException
    {
        dbReleaseCodeDef.save(conn, rcd);
    }

    public void removeReleaseCodeDef(ReleaseCodeDef rcd)
        throws SQLException
    {
        dbReleaseCodeDef.remove(conn, m_locationCd, rcd);
    }

    public void updateReleaseCodeDef(ReleaseCodeDef rcd)
        throws SQLException
    {
        dbReleaseCodeDef.update(conn, m_locationCd, rcd);
    }

    public int getReleaseCodeDefRecordCount()
    {
        return dbReleaseCodeDef.getReleaseCodeDefRecordCount();
    }

    public int getReleaseCodeRecordCount()
    {
        return dbReleaseCode.getReleaseCodeRecordCount();
    }

    public ReleaseCode fetchReleaseCode(String locationCd)
        throws SQLException
    {
        return dbReleaseCode.fetch(conn, locationCd);
    }

    public ReleaseCode fetchReleaseCode(String locationCd, int releaseOidNbr)
        throws SQLException
    {
        return dbReleaseCode.fetch(conn, locationCd, releaseOidNbr);
    }

    public ReleaseCode fetchReleaseCodeWithActiveFlag(String locationCd)
        throws SQLException
    {
        return dbReleaseCode.fetchReleaseCodeWithActiveFlag(conn, locationCd);
    }

    public ReleaseCode fetchReleaseCodeByPieceOid(String locationCd, int pieceOidNbr)
        throws SQLException
    {
        return dbReleaseCode.fetchReleaseCodeByPieceOid(conn, locationCd, pieceOidNbr);
    }

    public ReleaseCode fetchReleaseCodeByShipmentOid(String locationCd, int shipmentOidNbr)
        throws SQLException
    {
        return dbReleaseCode.fetchReleaseCodeByShipmentOid(conn, locationCd, shipmentOidNbr);
    }

    public ReleaseCode fetchReleaseCodeByShipOrPieceOid(String locationCd, int shipmentOidNbr, int pieceOidNbr)
        throws SQLException
    {
        return dbReleaseCode.fetchReleaseCodeByShipOrPieceOid(conn, locationCd, shipmentOidNbr, pieceOidNbr);
    }

    public ReleaseCode fetchNextReleaseCode()
        throws SQLException
    {
        return dbReleaseCode.fetchNext();
    }

    public void saveReleaseCode(ReleaseCode rc)
        throws SQLException
    {
        dbReleaseCode.save(conn, rc, m_locationCd);
    }

    public void removeReleaseCode(ReleaseCode rc)
        throws SQLException
    {
        dbReleaseCode.remove(conn, rc);
    }

    public void updateReleaseCode(ReleaseCode rc)
        throws SQLException
    {
        dbReleaseCode.update(conn, rc);
    }

    public ShipmentRemarkDef fetchShipmentRemarkDef()
        throws SQLException
    {
        return dbShipmentRemarkDef.fetch(conn, m_locationCd);
    }

    public ShipmentRemarkDef fetchShipmentRemarkDef(String shipmentRemarkCd)
        throws SQLException
    {
        return dbShipmentRemarkDef.fetch(conn, m_locationCd, shipmentRemarkCd);
    }

    public ShipmentRemarkDef fetchNextShipmentRemarkDef()
        throws SQLException
    {
        return dbShipmentRemarkDef.fetchNext();
    }

    public void saveShipmentRemarkDef(ShipmentRemarkDef srd)
        throws SQLException
    {
        dbShipmentRemarkDef.save(conn, srd, m_locationCd);
    }

    public void removeShipmentRemarkDef(ShipmentRemarkDef srd)
        throws SQLException
    {
        dbShipmentRemarkDef.remove(conn, srd);
    }

    public void updateShipmentRemarkDef(ShipmentRemarkDef srd)
        throws SQLException
    {
        dbShipmentRemarkDef.update(conn, srd);
    }

    public int getShipmentRemarkDefRecordCount()
    {
        return dbShipmentRemarkDef.getShipmentRemarkDefRecordCount();
    }

    public ShipmentRemark fetchShipmentRemark(int shipmentRemarkOidNbr)
        throws SQLException
    {
        return dbShipmentRemark.fetch(conn, shipmentRemarkOidNbr);
    }

    public ShipmentRemark fetchShipmentRemarkByShipmentOrPieceOidNbr(int shipmentOidNbr, int pieceOidNbr)
        throws SQLException
    {
        return dbShipmentRemark.fetchByShipmentOrPieceOidNbr(conn, m_locationCd, shipmentOidNbr, pieceOidNbr);
    }

    public ShipmentRemark fetchShipmentRemarkByShipmentOidNbr(int shipmentOidNbr)
        throws SQLException
    {
        return dbShipmentRemark.fetchByShipmentOidNbr(conn, m_locationCd, shipmentOidNbr);
    }

    public ShipmentRemark fetchShipmentRemarkByPieceOidNbr(int pieceOidNbr)
        throws SQLException
    {
        return dbShipmentRemark.fetchByPieceOidNbr(conn, m_locationCd, pieceOidNbr);
    }

    public ShipmentRemark fetchNextShipmentRemark()
        throws SQLException
    {
        return dbShipmentRemark.fetchNext();
    }

    public void removeShipmentRemark(ShipmentRemark sr)
        throws SQLException
    {
        dbShipmentRemark.remove(conn, sr);
    }

    public void updateShipmentRemark(ShipmentRemark sr)
        throws SQLException
    {
        dbShipmentRemark.update(conn, sr);
    }

    public void saveShipmentRemark(ShipmentRemark sr)
        throws SQLException
    {
        dbShipmentRemark.save(conn, sr, m_locationCd);
    }

    public int getShipmentRemarkRecordCount()
    {
        return dbShipmentRemark.getShipmentRemarkRecordCount();
    }

    public WarehouseDef fetchWarehouseDefByLocCd()
        throws SQLException
    {
        return dbWarehouseDef.fetchByLocationCd(conn, m_locationCd);
    }

    public WarehouseDef fetchWarehouseDefByWhCd(String whc)
        throws SQLException
    {
        return dbWarehouseDef.fetchByWarehouseCd(conn, whc);
    }

    public WarehouseDef fetchWarehouseDef()
        throws SQLException
    {
        return dbWarehouseDef.fetch(conn);
    }

    public WarehouseDef fetchNextWarehouseDef()
        throws SQLException
    {
        return dbWarehouseDef.fetchNext();
    }

    public void saveWarehouseDef(WarehouseDef whd)
        throws SQLException
    {
        dbWarehouseDef.save(conn, whd);
    }

    public void removeWarehouseDef(WarehouseDef whd)
        throws SQLException
    {
        dbWarehouseDef.remove(conn, whd);
    }

    public void updateWarehouseDef(WarehouseDef whd)
        throws SQLException
    {
        dbWarehouseDef.update(conn, whd);
    }

    public int getWarehouseDefRecordCount()
    {
        return dbWarehouseDef.getWarehouseDefRecordCount();
    }

    public AgencyStagingArea fetchAgencyStagingAreaByLocCd()
        throws SQLException
    {
        return dbAgencyStagingArea.fetchByLocationCd(conn, m_locationCd);
    }

    public AgencyStagingArea fetchAgencyStagingAreaByLocCdWhCd(String whcd)
        throws SQLException
    {
        return dbAgencyStagingArea.fetchByLocationCdWarehouseCd(conn, m_locationCd, whcd);
    }

    public AgencyStagingArea fetchAgencyStagingAreaByLocCdWhCdAgCd(String whcd, String agCd)
        throws SQLException
    {
        return dbAgencyStagingArea.fetchByLocCdWhCdAgCd(conn, m_locationCd, whcd, agCd);
    }

    public AgencyStagingArea fetchAgencyStagingArea()
        throws SQLException
    {
        return dbAgencyStagingArea.fetch(conn);
    }

    public AgencyStagingArea fetchNextAgencyStagingArea()
        throws SQLException
    {
        return dbAgencyStagingArea.fetchNext();
    }

    public void saveAgencyStagingArea(AgencyStagingArea asa)
        throws SQLException
    {
        dbAgencyStagingArea.save(conn, asa);
    }

    public void removeAgencyStagingArea(AgencyStagingArea asa)
        throws SQLException
    {
        dbAgencyStagingArea.remove(conn, asa);
    }

    public int getAgencyStagingAreaRecordCount()
    {
        return dbAgencyStagingArea.getAgencyRecordCount();
    }

    public void removeInterceptStagingArea(InterceptStagingArea interceptStagingArea)
        throws SQLException
    {
        dbInterceptStagingArea.remove(conn, interceptStagingArea);
    }

    public void saveInterceptStagingArea(InterceptStagingArea interceptStagingArea)
        throws SQLException
    {
        dbInterceptStagingArea.save(conn, interceptStagingArea);
    }

    public InterceptStagingArea fetchInterceptStagingArea()
        throws SQLException
    {
        return dbInterceptStagingArea.fetch(conn);
    }

    public InterceptStagingArea fetchByLocationCd()
        throws SQLException
    {
        return dbInterceptStagingArea.fetch(conn, m_locationCd);
    }

    public InterceptStagingArea fetchByWarehouseCdLocationCd(String warehouseCd)
        throws SQLException
    {
        return dbInterceptStagingArea.fetch(conn, m_locationCd, warehouseCd);
    }

    public InterceptStagingArea fetchInterceptStagingAreaByWhCdIntCd(String warehouseCd, String interceptCd)
        throws SQLException
    {
        return dbInterceptStagingArea.fetch(conn, m_locationCd, warehouseCd, interceptCd);
    }

    public InterceptStagingArea fetchNextInterceptStagingArea()
        throws SQLException
    {
        return dbInterceptStagingArea.fetchNext();
    }

    public int getInterceptStagingAreaRecordCount()
    {
        return dbInterceptStagingArea.getInterceptStagingAreaRecordCount();
    }

    public void removeNextOid(NextOid nextOid)
        throws SQLException
    {
        dbNextOid.remove(conn, nextOid);
    }

    public void saveNextOid(NextOid nextOid)
        throws SQLException
    {
        dbNextOid.save(conn, nextOid);
    }

    public void updateNextOid(NextOid nextOid)
        throws SQLException
    {
        dbNextOid.update(conn, nextOid);
    }

    public NextOid fetchNextOid()
        throws SQLException
    {
        return dbNextOid.fetch(conn);
    }

    public NextOid fetchNextOidByTableName(String tableName)
        throws SQLException
    {
        return dbNextOid.fetch(conn, tableName);
    }

    public NextOid fetchNextOidByNextOidNbr(int nextOidNbr)
        throws SQLException
    {
        return dbNextOid.fetch(conn, nextOidNbr);
    }

    public NextOid fetchNextNextOid()
        throws SQLException
    {
        return dbNextOid.fetchNext();
    }

    public int getNextOidRecordCount()
    {
        return dbNextOid.getNextOidRecordCount();
    }

    public void removeShuttle(Shuttle shuttle)
        throws SQLException
    {
        dbShuttle.delete(conn, shuttle);
    }

    public void saveShuttle(Shuttle shuttle)
        throws SQLException
    {
        dbShuttle.save(conn, shuttle);
    }

    public void updateShuttle(Shuttle shuttle)
        throws SQLException
    {
        dbShuttle.update(conn, shuttle);
    }

    public Shuttle fetchAllShuttle()
        throws SQLException
    {
        return dbShuttle.fetchAll(conn);
    }

    public Shuttle fetchShuttleByLocationCd()
        throws SQLException
    {
        return dbShuttle.fetch(conn, m_locationCd);
    }

    public Shuttle fetchShuttleByWarehouseCdLocationCd(String warehouseCd)
        throws SQLException
    {
        return dbShuttle.fetch(conn, m_locationCd, warehouseCd);
    }

    public Shuttle fetchShuttleByLocWhShuttleCd(String warehouseCd, String shuttleCd)
        throws SQLException
    {
        return dbShuttle.fetch(conn, m_locationCd, warehouseCd, shuttleCd);
    }

    public Shuttle fetchShuttleByDestLocShuttleCd(String destLocationCd, String shuttleCd)
        throws SQLException
    {
        return dbShuttle.fetchByDestLocationCd(conn, m_locationCd, destLocationCd, shuttleCd);
    }

    public Shuttle fetchShuttleByWhDest(String warehouseCd, String destLocationCd)
        throws SQLException
    {
        return dbShuttle.fetchByLocWhDest(conn, m_locationCd, warehouseCd, destLocationCd);
    }

    public Shuttle fetchNextShuttle()
        throws SQLException
    {
        return dbShuttle.fetchNext();
    }

    public int getShuttleRecordCount()
    {
        return dbShuttle.getShuttleRecordCount();
    }

    public void removeUpload(Upload upload)
        throws SQLException
    {
        dbUpload.deleteUpload(conn, upload);
    }

    public void saveUpload(Upload upload)
        throws SQLException
    {
        dbUpload.saveUpload(conn, upload);
    }

    public void updateUpload(Upload upload)
        throws SQLException
    {
        dbUpload.updateUpload(conn, upload);
    }

    public Upload fetchAllUpload()
        throws SQLException
    {
        return dbUpload.fetchAllUpload(conn);
    }

    public Upload fetchUpload(Vector uploadKeyVector)
        throws SQLException
    {
        return dbUpload.fetchUpload(conn, m_locationCd, uploadKeyVector);
    }

    public Upload fetchNextUpload()
        throws SQLException
    {
        return dbUpload.fetchNext();
    }

    public int getUploadRecordCount()
    {
        return dbUpload.getUploadRecordCount();
    }

    public void removeUploadCategoryDef(UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        dbUploadCategoryDef.deleteUploadCategoryDef(conn, uploadCategoryDef);
    }

    public void saveUploadCategoryDef(UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        dbUploadCategoryDef.saveUploadCategoryDef(conn, uploadCategoryDef);
    }

    public void updateUploadCategoryDef(UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        dbUploadCategoryDef.updateUploadCategoryDef(conn, uploadCategoryDef);
    }

    public UploadCategoryDef fetchAllUploadCategoryDef()
        throws SQLException
    {
        return dbUploadCategoryDef.fetchAllUploadCategoryDef(conn);
    }

    public UploadCategoryDef fetchUploadCategoryDef()
        throws SQLException
    {
        return dbUploadCategoryDef.fetchUploadCategoryDef(conn);
    }

    public UploadCategoryDef fetchUploadCategoryDefs(String locationCd, String uploadCategoryCd)
        throws SQLException
    {
        return dbUploadCategoryDef.fetchUploadCategoryDefs(conn, m_locationCd, uploadCategoryCd);
    }

    public UploadCategoryDef fetchNextUploadCategoryDef()
        throws SQLException
    {
        return dbUploadCategoryDef.fetchNext();
    }

    public int getUploadCategoryDefRecordCount()
    {
        return dbUploadCategoryDef.getUploadCategoryDefRecordCount();
    }

    public FlightInfo fetchFlightInfo(String routeNbr, int routeLegNbr, java.util.Date routeDt)
        throws SQLException
    {
        return dbFlightInfo.fetch(conn, routeNbr, routeLegNbr, routeDt);
    }

    public FlightInfo fetchNext()
        throws SQLException
    {
        return dbFlightInfo.fetchNext();
    }

    public PieceStatus fetchPieceStatus(int pieceOidNbr, String m_locationCd, java.util.Date sortDt, String pieceStatusCd)
        throws SQLException
    {
        return dbPieceStatus.fetch(conn, pieceOidNbr, m_locationCd, sortDt, pieceStatusCd);
    }

    public PieceStatus fetchNextPieceStatus()
        throws SQLException
    {
        return dbPieceStatus.fetchNext();
    }

    public int getPieceStatusRecordCount()
    {
        return dbPieceStatus.getPieceStatusRecordCount();
    }

    public void savePieceStatus(PieceStatus pieceStatus)
        throws SQLException
    {
        dbPieceStatus.save(conn, pieceStatus, m_locationCd);
    }

    public void updatePieceStatus(PieceStatus pieceStatus)
        throws SQLException
    {
        dbPieceStatus.updatePieceStatus(pieceStatus, conn);
    }

    public void updatePieceStatusResolutionAndRfaOnly(PieceStatus pieceStatus)
        throws SQLException
    {
        dbPieceStatus.updatePieceStatusResolutionAndRfaOnly(pieceStatus, conn);
    }

    public void removeContractBroker(int shipmentOidNbr)
        throws SQLException
    {
        dbContractBroker.delete(conn, shipmentOidNbr);
    }

    public void saveContractBroker(ContractBroker contractBroker)
        throws SQLException
    {
        dbContractBroker.save(conn, contractBroker);
    }

    public void updateContractBroker(ContractBroker contractBroker)
        throws SQLException
    {
        dbContractBroker.update(conn, contractBroker);
    }

    public ContractBroker fetchContractBroker(int shipmentOidNbr)
        throws SQLException
    {
        return dbContractBroker.fetch(conn, shipmentOidNbr);
    }

    public void removeParty(int OidNbr, String OidTypeCd)
        throws SQLException
    {
        dbParty.delete(conn, OidNbr, OidTypeCd);
    }

    public void saveParty(Party party)
        throws SQLException
    {
        dbParty.save(conn, party);
    }

    public void updateParty(Party party, int OidNbr, String OidTypeCd)
        throws SQLException
    {
        dbParty.update(conn, party, OidNbr, OidTypeCd);
    }

    public Party fetchParty(int OidNbr, String OidTypeCd)
        throws SQLException
    {
        return dbParty.fetch(conn, OidNbr, OidTypeCd);
    }

    public void removeSplit(int splitNbr)
        throws SQLException
    {
        dbSplit.delete(conn, splitNbr, m_locationCd);
    }

    public void saveSplit(Split split)
        throws SQLException
    {
        dbSplit.save(conn, split);
    }

    public void updateSplit(Split split)
        throws SQLException
    {
        dbSplit.update(conn, split);
    }

    public Split fetchSplit(int splitNbr)
        throws SQLException
    {
        return dbSplit.fetch(conn, splitNbr, m_locationCd);
    }

    public Split fetchSplit()
        throws SQLException
    {
        return dbSplit.fetch(conn, m_locationCd);
    }

    public Split fetchNextSplit()
        throws SQLException
    {
        return dbSplit.fetchNext();
    }

    public void removeLocationDef(LocationDef locationDef)
        throws SQLException
    {
        dbLocationDef.deleteLocationDef(conn, locationDef);
    }

    public void saveLocationDef(LocationDef locationDef)
        throws SQLException
    {
        dbLocationDef.saveLocationDef(conn, locationDef);
    }

    public void updateLocationDef(LocationDef locationDef)
        throws SQLException
    {
        dbLocationDef.updateLocationDef(conn, locationDef);
    }

    public LocationDef fetchAllLocationDef()
        throws SQLException
    {
        return dbLocationDef.fetchAllLocationDef(conn);
    }

    public LocationDef fetchLocationDef(String locationCd)
        throws SQLException
    {
        return dbLocationDef.fetchLocationDef(conn, locationCd);
    }

    public LocationDef fetchNextLocationDef()
        throws SQLException
    {
        return dbLocationDef.fetchNext();
    }

    public void removeCountryDef(CountryDef countryDef)
        throws SQLException
    {
        dbCountryDef.deleteCountryDef(conn, countryDef);
    }

    public void saveCountryDef(CountryDef countryDef)
        throws SQLException
    {
        dbCountryDef.saveCountryDef(conn, countryDef);
    }

    public void updateCountryDef(CountryDef countryDef)
        throws SQLException
    {
        dbCountryDef.updateCountryDef(conn, countryDef);
    }

    public CountryDef fetchCountryDef(String countryCd)
        throws SQLException
    {
        return dbCountryDef.fetchCountryDef(conn, countryCd);
    }

    public CountryDef fetchAllCountryDef()
        throws SQLException
    {
        return dbCountryDef.fetchAllCountryDef(conn);
    }

    public CountryDef fetchNextCountryDef()
        throws SQLException
    {
        return dbCountryDef.fetchNext();
    }

    public void removeInTransit(InTransit inTransit)
        throws SQLException
    {
        dbInTransit.deleteInTransit(conn, inTransit);
    }

    public void saveInTransit(InTransit inTransit)
        throws SQLException
    {
        dbInTransit.saveInTransit(conn, inTransit);
    }

    public void updateInTransit(InTransit inTransit)
        throws SQLException
    {
        dbInTransit.updateInTransit(conn, inTransit);
    }

    public InTransit fetchInTransitByShipmentOid(int shipmentOid)
        throws SQLException
    {
        return dbInTransit.fetchInTransitByShipmentOid(conn, shipmentOid);
    }

    public InTransit fetchInTransitByLocCd(String locationCd)
        throws SQLException
    {
        return dbInTransit.fetchInTransitByLocCd(conn, locationCd);
    }

    public InTransit fetchInTransitByLocCdAndShipmentOid(String locationCd, int shipmentOid)
        throws SQLException
    {
        return dbInTransit.fetchInTransitByLocCdAndShipmentOid(conn, locationCd, shipmentOid);
    }

    public InTransit fetchAllInTransit()
        throws SQLException
    {
        return dbInTransit.fetchAllInTransit(conn);
    }

    public InTransit fetchNextInTransit()
        throws SQLException
    {
        return dbInTransit.fetchNext();
    }

    public Entry fetchEntry(String entryTypeCode, int routeLegOid)
        throws SQLException
    {
        return dbEntry.fetch(entryTypeCode, routeLegOid, conn);
    }

    public void saveEntry(Entry entry)
        throws SQLException
    {
        dbEntry.saveEntry(entry, conn);
    }

    public EntryTypeDefinition fetchEntryTypeDef(String entryTypeCode)
        throws SQLException
    {
        return dbEntryTypeDef.fetch(entryTypeCode, conn);
    }

    public CustomsNumberManagement fetchCustomsEntryTypeAndActive(String typeCode)
        throws SQLException
    {
        return dbCustomsNumberMgmt.fetchEntryTypeAndActive(typeCode, getLocationCode(), conn);
    }

    public CustomsNumberManagement fetchNextCustomsNumberManagement()
        throws SQLException
    {
        return dbCustomsNumberMgmt.fetchNext();
    }

    public void updateCustomsNumberLastUsed(CustomsNumberManagement cnm, int oldLastUsed)
        throws SQLException
    {
        dbCustomsNumberMgmt.updateCustomsNumberLastUsed(cnm, oldLastUsed, conn);
    }

    public void updateCustomsNumberManagement(CustomsNumberManagement cnm)
        throws SQLException
    {
        dbCustomsNumberMgmt.updateCustomsNumberManagement(cnm, conn);
    }

    public BatchConsSummary fetchBatchConsSummary(int consOid)
    throws SQLException
	{
	    return dbBatchSummary.fetch(conn, consOid);
	}
	
	public BatchConsSummary fetchBatchConsSummary(String consNbr)
	    throws SQLException
	{
	    return dbBatchSummary.fetch(conn, consNbr);
	}
	
	public BatchConsSummary fetchNextBatchConsSummary()
	    throws SQLException
	{
	    return dbBatchSummary.fetchNext();
	}
	
	public void saveBatchConsSummary(BatchConsSummary consSum)
	    throws SQLException
	{
	    dbBatchSummary.save(conn, consSum);
	}
	
	public void updateBatchConsSummary(BatchConsSummary consSum)
	    throws SQLException
	{
	    dbBatchSummary.update(conn, consSum);
	}
	
	public int getBatchConsSummaryRecordCount()
	{
	    return dbBatchSummary.getConsSummaryRecordCount();
	}
	
	public BatchCons fetchBatchCons(int consOid, String trackingNbr, boolean dconsflag)
	    throws SQLException
	{
	    return dbBatch.fetch(conn, consOid, trackingNbr, dconsflag);
	}
	
	public BatchCons fetchBatchCons(int consOid)
	throws SQLException
	{
	    return dbBatch.fetch(conn, consOid);
	}
	
	public BatchCons fetchBatchCons(String consNbr)
	    throws SQLException
	{
	    return dbBatch.fetch(conn, consNbr);
	}
	
	public BatchCons fetchNextBatchCons()
	    throws SQLException
	{
	    return dbBatch.fetchNext();
	}
	
	public void saveBatchCons(BatchCons cons)
	    throws SQLException
	{
	    dbBatch.save(conn, cons);
	}
	
	public void updateBatchCons(BatchCons cons)
	    throws SQLException
	{
	    dbBatch.update(conn, cons);
	}
	
	public void removeBatchCons(BatchCons cons) 
		throws SQLException 
	{
	    dbBatch.remove(conn,cons);
	}

	public int getBatchConsRecordCount()
	{
	    return dbBatch.getConsRecordCount();
	}

	public void updateBatchPieceTruckNbr(String truckNbr, int pieceOid) 
		throws SQLException
	{
	    dbBatch.updatePieceTruckNbr(conn, truckNbr, pieceOid);
	}
	
	public Truck fetchTruckByTruckId( String truckId)
		throws SQLException
	{
	    return dbTruck.fetchTruckByTruckId(conn, truckId);
	}
	
    private static final String m_whatVersion = "@(#) $RCSfile: DatabaseBean.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    private String m_server;
    private String m_user;
    private String m_password;
    private String m_schema;
    private Config m_config;
    private String m_locationCd;
    private Vector m_validLocationCd;
    private Connection conn;
    private DbShipment dbShip;
    private DbHandlingUnit dbHandlingUnit;
    private DbIntercept dbIntercept;
    private DbRouteLeg dbRouteLeg;
    private DbScan dbScan;
    private DbConsSummary dbConsSummary;
    private DbCons dbCons;
    private DbPrinterConfiguration dbPrinterConfiguration;
    private DbPieceRouteLeg dbPieceRouteLeg;
    private DbHandlingInstruction dbHandlingInstruction;
    private DbHandlingInstructionDef dbHandlingInstructionDef;
    private DbReasonCode dbReasonCode;
    private DbReasonCodeDefinition dbReasonCodeDef;
    private DbInterceptDef dbInterceptDef;
    private DbStagingArea dbStagingArea;
    private DbAgency dbAgency;
    private DbPAResolveDup dbPAResolveDup;
    private DbScanDefinition dbScanDef;
    private DbDetainmentLocDef dbDetLoc;
    private DbSiteParam dbSiteParam;
    private DbActivityDef dbActivityDef;
    private DbClearanceActivity dbClearanceActivity;
    private DbReleaseCode dbReleaseCode;
    private DbReleaseCodeDef dbReleaseCodeDef;
    private DbShipmentRemark dbShipmentRemark;
    private DbShipmentRemarkDef dbShipmentRemarkDef;
    private DbWarehouseDef dbWarehouseDef;
    private DbAgencyStagingArea dbAgencyStagingArea;
    private DbInterceptStagingArea dbInterceptStagingArea;
    private DbNextOid dbNextOid;
    private DbShuttle dbShuttle;
    private DbUpload dbUpload;
    private DbFlightInfo dbFlightInfo;
    private DbPieceStatus dbPieceStatus;
    private DbUploadCategoryDef dbUploadCategoryDef;
    private DbContractBroker dbContractBroker;
    private DbParty dbParty;
    private DbSplit dbSplit;
    private DbLocationDef dbLocationDef;
    private DbCountryDef dbCountryDef;
    private DbInTransit dbInTransit;
    private DbEntry dbEntry;
    private DbEntryTypeDef dbEntryTypeDef;
    private DbCustomsNumberMgmt dbCustomsNumberMgmt;
    
    //add by xinghai for BKK batch scan
    private DbBatch dbBatch;
    private DbBatchSummary dbBatchSummary;
    private DbTruck dbTruck;
}
