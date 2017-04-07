// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbShipment.java

package cciij.cciidatabase;

import cciij.cciidata.Shipment;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbShipment extends DbBase
{

    public DbShipment()
    {
        fetchShipmentWithFiveFieldsSQL = fetchSingleLocBaseSQL + "AND AWB_NBR = ? " + "AND HAWB_SERIAL_NBR = ? " + "AND INPUT_DT = ? ";
        saveShipmentSQL = "INSERT INTO " + SHIPMENT + "(SHIPMENT_OID_NBR, AWB_NBR, " + "SHIPMENT_DT, PIECE_QTY, HANDLING_UNIT_QTY, " + "CUSTOMS_VALUE_AMT, CARRIAGE_VALUE_AMT, SERVICE_CD, " + "ORIGIN_LOCATION_COUNTRY_CD, DEST_LOCATION_COUNTRY_CD, " + "SHIPPER_COMPANY_NM, SHIPPER_POSTAL_CD, SHIPPER_COUNTRY_CD, " + "CONSIGNEE_COMPANY_NM, CONSIGNEE_POSTAL_CD, CONSIGNEE_STATE_CD, CONSIGNEE_COUNTRY_CD, " + "SHIPMENT_DESC, DEST_LOCATION_CD, ORIGIN_LOCATION_CD, " + "FORM_TYPE_CD, TRANSACTION_SEQ_TMSTP, MANIFEST_STATUS_CD, " + "SDL_FLG, HAL_FLG, DUTIABLE_FLG, SPECIAL_HANDLING1_CD, " + "SPECIAL_HANDLING2_CD, SPECIAL_HANDLING3_CD, " + "SPECIAL_HANDLING4_CD, SPECIAL_HANDLING5_CD, " + "LOCAL_CUSTOMS_VALUE_AMT, HAWB_SERIAL_NBR, ROD_FLG ) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        saveShipmentCoreSQL = "INSERT INTO " + SHIPMENT_CORE_CLEARANCE + "(SHIPMENT_OID_NBR, " + "RETURN_AWB_NBR, LAST_MODIFIED_NM, LAST_MODIFIED_TMSTP, " + "OVERAGE_REASON_CD, BROKER_ENTRY_NBR, CUSTOMS_REVIEWED_FLG, " + "CUSTOMS_RELEASE_FLG, LOCATION_CD, DECLARED_FLG, " + "DECLARED_TRANSACTION_SEQ_TMSTP, INTRANSIT_CD, CUSTOMS_DEST_CD, ENTRY_CATEGORY_TYPE_CD, ENTRY_CATEGORY_SOURCE_CD ) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        removeShipmentSQL = "DELETE FROM " + SHIPMENT + "WHERE SHIPMENT_OID_NBR = ?";
        removeShipmentCoreSQL = "DELETE FROM " + SHIPMENT_CORE_CLEARANCE + "WHERE SHIPMENT_OID_NBR = ? " + "AND LOCATION_CD like ? ";
        updateShipmentSQL = "UPDATE " + SHIPMENT + "SET AWB_NBR = ?, " + "SHIPMENT_DT = ?, PIECE_QTY = ?, HANDLING_UNIT_QTY = ?, " + "CUSTOMS_VALUE_AMT = ?, CARRIAGE_VALUE_AMT = ?, SERVICE_CD = ?, " + "ORIGIN_LOCATION_COUNTRY_CD = ?, DEST_LOCATION_COUNTRY_CD = ?, " + "SHIPPER_COMPANY_NM = ?, SHIPPER_POSTAL_CD = ?, SHIPPER_COUNTRY_CD = ?, " + "CONSIGNEE_COMPANY_NM = ?, CONSIGNEE_POSTAL_CD = ?, CONSIGNEE_STATE_CD = ?, CONSIGNEE_COUNTRY_CD = ?, " + "SHIPMENT_DESC = ?, DEST_LOCATION_CD = ?, ORIGIN_LOCATION_CD = ?, " + "FORM_TYPE_CD = ?, TRANSACTION_SEQ_TMSTP = ?, MANIFEST_STATUS_CD = ?, " + "SDL_FLG = ?, HAL_FLG = ?, DUTIABLE_FLG = ?, SPECIAL_HANDLING1_CD = ?, " + "SPECIAL_HANDLING2_CD = ?, SPECIAL_HANDLING3_CD = ?, " + "SPECIAL_HANDLING4_CD = ?, SPECIAL_HANDLING5_CD = ?, " + "LOCAL_CUSTOMS_VALUE_AMT = ?, ROD_FLG = ? " + "WHERE SHIPMENT_OID_NBR = ?";
        updateShipmentCoreSQL = "UPDATE " + SHIPMENT_CORE_CLEARANCE + "SET RETURN_AWB_NBR = ?, LAST_MODIFIED_NM = ?, LAST_MODIFIED_TMSTP = ?, " + "OVERAGE_REASON_CD = ?, BROKER_ENTRY_NBR = ?, CUSTOMS_REVIEWED_FLG = ?, " + "CUSTOMS_RELEASE_FLG = ?, DECLARED_FLG = ?, " + "DECLARED_TRANSACTION_SEQ_TMSTP  = ?, INTRANSIT_CD = ?, CUSTOMS_DEST_CD = ?, " + "ENTRY_CATEGORY_TYPE_CD = ?, ENTRY_CATEGORY_SOURCE_CD = ? " + "WHERE SHIPMENT_OID_NBR = ? AND LOCATION_CD = ? ";
        updateShipmentCoreWarehouseSQL = "UPDATE " + SHIPMENT_CORE_CLEARANCE + "SET WAREHOUSE_CD = ? " + "WHERE SHIPMENT_OID_NBR = ? AND LOCATION_CD = ? ";
        
        fetchWithShipmentOidStmt = null;
        fetchWithShipmentOidOuterStmt = null;
        fetchShipmentWithTrackingNbrSingleStmt = null;
        fetchShipmentWithTrackingNbrListStmt = null;
        fetchShipmentWithFiveFieldsStmt = null;
        saveShipmentStmt = null;
        saveShipmentCoreStmt = null;
        removeShipmentStmt = null;
        removeShipmentCoreStmt = null;
        updateShipmentStmt = null;
        updateShipmentCoreStmt = null;
    }

    public int getShipmentRecordCount()
    {
        return m_recordCount;
    }

    public Shipment fetch(Connection conn, int shipOid, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOidStmt = conn.prepareStatement(fetchWithShipmentOidSQL);
            fetchWithShipmentOidStmt.setString(1, locationCode);
            fetchWithShipmentOidStmt.setInt(2, shipOid);
            runQuery(fetchWithShipmentOidStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchWithShipmentOidSQL, shipOid + ", " + locationCode);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public Shipment fetchAllowNullLocation(Connection conn, int shipOid, String locationCode)
        throws SQLException
    {
        try
        {
            fetchWithShipmentOidOuterStmt = conn.prepareStatement(fetchWithShipmentOidOuterSQL);
            fetchWithShipmentOidOuterStmt.setString(1, locationCode);
            fetchWithShipmentOidOuterStmt.setInt(2, shipOid);
            runQuery(fetchWithShipmentOidOuterStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchWithShipmentOidOuterSQL, shipOid + ", " + locationCode);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public Shipment fetch(Connection conn, String AWBNbr, String locationCode)
        throws SQLException
    {
        try
        {
            fetchShipmentWithTrackingNbrSingleStmt = conn.prepareStatement(fetchShipmentWithTrackingNbrSingleSQL);
            fetchShipmentWithTrackingNbrSingleStmt.setString(1, locationCode);
            fetchShipmentWithTrackingNbrSingleStmt.setString(2, AWBNbr);
            runQuery(fetchShipmentWithTrackingNbrSingleStmt);
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetch", fetchShipmentWithTrackingNbrSingleSQL, AWBNbr + ", " + locationCode);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public Shipment fetch(Connection conn, String AWBNbr, String locationCode, String locationList[])
        throws SQLException
    {
        try
        {
            fetchShipmentWithTrackingNbrListStmt = conn.prepareStatement(fetchShipmentWithTrackingNbrListSQL);
            fetchShipmentWithTrackingNbrListStmt.setString(1, locationCode);
            for(int i = 0; i < 10; i++)
                if(i < locationList.length)
                    fetchShipmentWithTrackingNbrListStmt.setString(i + 2, locationList[i]);
                else
                    fetchShipmentWithTrackingNbrListStmt.setString(i + 2, locationList[0]);

            fetchShipmentWithTrackingNbrListStmt.setString(12, AWBNbr);
            runQuery(fetchShipmentWithTrackingNbrListStmt);
        }
        catch(SQLException ex)
        {
            StringBuffer paramListStrBuff = new StringBuffer();
            paramListStrBuff.append(AWBNbr);
            paramListStrBuff.append(", ");
            paramListStrBuff.append(locationCode);
            paramListStrBuff.append(", ");
            for(int i = 0; i < locationList.length; i++)
                paramListStrBuff.append(locationList[i] + ", ");

            printSQLException(ex, getClass().getName(), "fetch", fetchShipmentWithTrackingNbrListSQL, paramListStrBuff.toString());
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public Shipment fetch(Connection conn, String locationCode, String AWBNbr, int hawbSerialNbr, java.util.Date inputDt, String destLocCd, String originLocCd)
        throws SQLException
    {
        Date convertInputDt = new Date(inputDt.getTime());
        try
        {
            fetchShipmentWithFiveFieldsStmt = conn.prepareStatement(fetchShipmentWithFiveFieldsSQL);
            fetchShipmentWithFiveFieldsStmt.setString(1, locationCode);
            fetchShipmentWithFiveFieldsStmt.setString(2, AWBNbr);
            fetchShipmentWithFiveFieldsStmt.setInt(3, hawbSerialNbr);
            fetchShipmentWithFiveFieldsStmt.setDate(4, convertInputDt);
            runQuery(fetchShipmentWithFiveFieldsStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbShipment fetch with AWBNbr, hawbSerialNbr, inputDt, destLocCd, originLocCd:  " + ex);
            throw ex;
        }
        return fetchNext(locationCode);
    }

    public Shipment fetchNext(String dbBeanLocationCode)
        throws SQLException
    {
        Shipment ship = new Shipment();
        try
        {
            if(m_hasMore)
            {
                int sOid = m_resultSet.getInt(1);
                String awbNbr = m_resultSet.getString(2);
                Timestamp shipDtTmstp = m_resultSet.getTimestamp(3);
                int pcQty = m_resultSet.getInt(4);
                int handlingUnitQty = m_resultSet.getInt(5);
                double custValAmt = m_resultSet.getDouble(6);
                double carrValAmt = m_resultSet.getDouble(7);
                String srvcCd = m_resultSet.getString(8);
                String orgCountry = m_resultSet.getString(9);
                String destCountry = m_resultSet.getString(10);
                String shipCoNm = m_resultSet.getString(11);
                String shipPostalCd = m_resultSet.getString(12);
                String shipCntryCd = m_resultSet.getString(13);
                String consCoNm = m_resultSet.getString(14);
                String consPostalCd = m_resultSet.getString(15);
                String consStateCd = m_resultSet.getString(16);
                String consCntryCd = m_resultSet.getString(17);
                String shipDesc = m_resultSet.getString(18);
                String saturdayDelFlg = m_resultSet.getString(19);
                String holdAtLocFlg = m_resultSet.getString(20);
                String dutiableFlg = m_resultSet.getString(21);
                String specialHandling1Cd = m_resultSet.getString(22);
                String specialHandling2Cd = m_resultSet.getString(23);
                String specialHandling3Cd = m_resultSet.getString(24);
                String specialHandling4Cd = m_resultSet.getString(25);
                String specialHandling5Cd = m_resultSet.getString(26);
                String returnAWBNbr = m_resultSet.getString(27);
                String destLocCd = m_resultSet.getString(28);
                String origLocCd = m_resultSet.getString(29);
                String formTypeCd = m_resultSet.getString(30);
                String lastModNm = m_resultSet.getString(31);
                Timestamp lastModTmstp = m_resultSet.getTimestamp(32);
                String overageReasonCd = m_resultSet.getString(33);
                String brokerRecordNbr = m_resultSet.getString(34);
                String customsReviewedFlg = m_resultSet.getString(35);
                Timestamp transSeqTmstp = m_resultSet.getTimestamp(36);
                String manifestStatusCd = m_resultSet.getString(37);
                String customReleaseFlg = m_resultSet.getString(38);
                String locationCode = m_resultSet.getString(39);
                boolean nullCoreClearance = m_resultSet.wasNull();
                int sccOid = m_resultSet.getInt(40);
                String declaredFlg = m_resultSet.getString(41);
                Timestamp declaredTransactionSeqTmstp = m_resultSet.getTimestamp(42);
                String inTransitCd = m_resultSet.getString(43);
                String customsDestCd = m_resultSet.getString(44);
                double localCustomsValueAmt = m_resultSet.getDouble(45);
                int hawbSerialNbr = m_resultSet.getInt(46);
                String entryCategoryTypeCd = m_resultSet.getString(47);
                String shipperContactNm = m_resultSet.getString(48);
                String consigneeContactNm = m_resultSet.getString(49);
                int shipperAcctNbr = m_resultSet.getInt(50);
                int consigneeAcctNbr = m_resultSet.getInt(51);
                String sdlFlg = m_resultSet.getString(52);
                float lbsWgt = m_resultSet.getFloat(53);
                String mawbNbr = m_resultSet.getString(54);
                String priorNotificationNbr = m_resultSet.getString(55);
                String entryTypeSourceCode = m_resultSet.getString(56);
                String rodFlag = m_resultSet.getString(57);
                String consigneeAddress = m_resultSet.getString(58);
                String consigneeCity = m_resultSet.getString(59);
                java.util.Date shipDt = convertTimestampToDate(shipDtTmstp);
                java.util.Date lastModDt = convertTimestampToDate(lastModTmstp);
                java.util.Date transSeqDt = convertTimestampToDate(transSeqTmstp);
                boolean tempReason = false;
                boolean tempRelease = false;
                ship = new Shipment(sOid, awbNbr, shipDt, pcQty, handlingUnitQty, tempReason, tempRelease, custValAmt, carrValAmt, srvcCd, orgCountry, destCountry, shipCoNm, shipPostalCd, shipCntryCd, consCoNm, consPostalCd, consCntryCd, shipDesc, returnAWBNbr, destLocCd, origLocCd, formTypeCd, brokerRecordNbr, customsReviewedFlg, manifestStatusCd, customReleaseFlg, declaredFlg, declaredTransactionSeqTmstp);
                ship.setLastModifiedName(lastModNm);
                ship.setLastModifiedTimestamp(lastModDt);
                ship.setOverageReasonCode(overageReasonCd);
                ship.setTransactionSequenceTimestamp(transSeqDt);
                ship.setConsigneeStateCode(consStateCd);
                ship.setSaturdayDelFlg(sdlFlg);
                ship.setHoldAtLocFlg(holdAtLocFlg);
                ship.setDutiableFlg(dutiableFlg);
                ship.setSpecialHandling1Cd(specialHandling1Cd);
                ship.setSpecialHandling2Cd(specialHandling2Cd);
                ship.setSpecialHandling3Cd(specialHandling3Cd);
                ship.setSpecialHandling4Cd(specialHandling4Cd);
                ship.setSpecialHandling5Cd(specialHandling5Cd);
                ship.setLocalCustomsValueAmt(localCustomsValueAmt);
                ship.setIntransitCd(inTransitCd);
                ship.setCustomsDestCd(customsDestCd);
                ship.setHAWBSerialNumber(hawbSerialNbr);
                ship.setEntryCategoryTypeCd(entryCategoryTypeCd);
                ship.setShipperContactName(shipperContactNm);
                ship.setConsigneeContactName(consigneeContactNm);
                ship.setOriginLocationCode(origLocCd);
                ship.setDestinationLocationCode(destLocCd);
                ship.setSaturdayDelFlg(sdlFlg);
                ship.setMawbNbr(mawbNbr);
                ship.setLbsWgt(lbsWgt);
                ship.setPriorNotificationNbr(priorNotificationNbr);
                ship.setEntryCategorySourceCd(entryTypeSourceCode);
                ship.setRODFlag(rodFlag);
                ship.setConsigneeAddress(consigneeAddress);
                ship.setConsigneeCity(consigneeCity);
                ship.setNullCoreClearance(nullCoreClearance);
                ship.setCustomsReleaseFlag(customReleaseFlg);
                ship.setDeclaredFlag(declaredFlg);
                if(nullCoreClearance)
                {
                    ship.setLocationCode(dbBeanLocationCode);
                    ship.setCustomsReviewedFlag("N");
                } else
                {
                    ship.setLocationCode(locationCode);
                }
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
                ship = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return ship;
    }

    public void saveCoreClearance(Connection conn, Shipment ship, String locationCode)
        throws SQLException
    {
        try
        {
            saveShipmentCoreStmt = conn.prepareStatement(saveShipmentCoreSQL);
            Timestamp modifiedTimestamp = new Timestamp(ship.getLastModifiedTimestamp().getTime());
            saveShipmentCoreStmt.setInt(1, ship.getShipmentOidNumber());
            saveShipmentCoreStmt.setString(2, ship.getReturnAWBNumber());
            saveShipmentCoreStmt.setString(3, ship.getLastModifiedName());
            saveShipmentCoreStmt.setTimestamp(4, modifiedTimestamp);
            saveShipmentCoreStmt.setString(5, ship.getOverageReasonCode());
            saveShipmentCoreStmt.setString(6, ship.getBrokerEntryNumber());
            saveShipmentCoreStmt.setString(7, ship.getCustomsReviewedFlag());
            saveShipmentCoreStmt.setString(8, ship.getCustomsReleaseFlag());
            if(ship.getLocationCode() == null || ship.getLocationCode().equals(""))
                saveShipmentCoreStmt.setString(9, locationCode);
            else
                saveShipmentCoreStmt.setString(9, ship.getLocationCode());
            saveShipmentCoreStmt.setString(10, ship.getDeclaredFlag());
            saveShipmentCoreStmt.setTimestamp(11, ship.getDeclaredTransactionSequenceTimestamp());
            saveShipmentCoreStmt.setString(12, ship.getIntransitCd());
            saveShipmentCoreStmt.setString(13, ship.getCustomsDestCd());
            saveShipmentCoreStmt.setString(14, ship.getEntryCategoryTypeCode());
            saveShipmentCoreStmt.setString(15, ship.getEntryCategorySourceCode());
            saveShipmentCoreStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "saveCoreClearance", saveShipmentCoreSQL, ship.getLastModifiedTimestamp().getTime() + ", " + ship.getShipmentOidNumber() + ", " + ship.getReturnAWBNumber() + ", " + ship.getLastModifiedName() + ", " + ship.getOverageReasonCode() + ", " + ship.getBrokerEntryNumber() + ", " + ship.getCustomsReviewedFlag() + ", " + ship.getCustomsReleaseFlag() + ", " + ship.getDeclaredFlag() + ", " + ship.getDeclaredTransactionSequenceTimestamp() + ", " + ship.getIntransitCd() + ", " + ship.getCustomsDestCd() + ", " + ship.getEntryCategoryTypeCode() + ", " + ship.getEntryCategorySourceCode() + ", " + locationCode);
            throw ex;
        }
    }

    public void save(Connection conn, Shipment ship, String locationCode)
        throws SQLException
    {
        Timestamp shipDtTimestamp = null;
        Timestamp tranSeqTimestamp = null;
        try
        {
            saveShipmentStmt = conn.prepareStatement(saveShipmentSQL);
            shipDtTimestamp = new Timestamp(ship.getShipmentDate().getTime());
            tranSeqTimestamp = new Timestamp(ship.getTransactionSequenceTimestamp().getTime());
            saveShipmentStmt.setInt(1, ship.getShipmentOidNumber());
            saveShipmentStmt.setString(2, ship.getAWBNumber());
            saveShipmentStmt.setTimestamp(3, shipDtTimestamp);
            saveShipmentStmt.setInt(4, ship.getPieceQuanity());
            saveShipmentStmt.setInt(5, ship.getHandlingUnitQuanity());
            saveShipmentStmt.setDouble(6, ship.getCustomValueAmount());
            saveShipmentStmt.setDouble(7, ship.getCarriageValueAmount());
            saveShipmentStmt.setString(8, ship.getServiceCode());
            saveShipmentStmt.setString(9, ship.getOriginCountryCode());
            saveShipmentStmt.setString(10, ship.getDestinationCountryCode());
            saveShipmentStmt.setString(11, ship.getShipperCompanyName());
            saveShipmentStmt.setString(12, ship.getShipperPostalCode());
            saveShipmentStmt.setString(13, ship.getShipperCountryCode());
            saveShipmentStmt.setString(14, ship.getConsigneeCompanyName());
            saveShipmentStmt.setString(15, ship.getConsigneePostalCode());
            saveShipmentStmt.setString(16, ship.getConsigneeStateCode());
            saveShipmentStmt.setString(17, ship.getConsigneeCountryCode());
            saveShipmentStmt.setString(18, ship.getShipmentDescription());
            saveShipmentStmt.setString(19, ship.getDestinationLocCode());
            saveShipmentStmt.setString(20, ship.getOriginLocCode());
            saveShipmentStmt.setString(21, ship.getFormTypeCode());
            saveShipmentStmt.setTimestamp(22, tranSeqTimestamp);
            saveShipmentStmt.setString(23, ship.getManifestStatusCode());
            saveShipmentStmt.setString(24, ship.getSaturdayDelFlg());
            saveShipmentStmt.setString(25, ship.getHoldAtLocFlg());
            saveShipmentStmt.setString(26, ship.getDutiableFlg());
            saveShipmentStmt.setString(27, ship.getSpecialHandling1Cd());
            saveShipmentStmt.setString(28, ship.getSpecialHandling2Cd());
            saveShipmentStmt.setString(29, ship.getSpecialHandling3Cd());
            saveShipmentStmt.setString(30, ship.getSpecialHandling4Cd());
            saveShipmentStmt.setString(31, ship.getSpecialHandling5Cd());
            saveShipmentStmt.setDouble(32, ship.getLocalCustomsValueAmt());
            saveShipmentStmt.setInt(33, ship.getHAWBSerialNumber());
            saveShipmentStmt.setString(34, ship.getRODFlag());
            saveShipmentStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "save", saveShipmentSQL, ship.getShipmentDate().getTime() + ", " + ship.getTransactionSequenceTimestamp().getTime() + ", " + ship.getShipmentOidNumber() + ", " + ship.getAWBNumber() + ", " + shipDtTimestamp + ", " + ship.getPieceQuanity() + ", " + ship.getHandlingUnitQuanity() + ", " + ship.getCustomValueAmount() + ", " + ship.getCarriageValueAmount() + ", " + ship.getServiceCode() + ", " + ship.getOriginCountryCode() + ", " + ship.getDestinationCountryCode() + ", " + ship.getShipperCompanyName() + ", " + ship.getShipperPostalCode() + ", " + ship.getShipperCountryCode() + ", " + ship.getConsigneeCompanyName() + ", " + ship.getConsigneePostalCode() + ", " + ship.getConsigneeStateCode() + ", " + ship.getConsigneeCountryCode() + ", " + ship.getShipmentDescription() + ", " + ship.getDestinationLocCode() + ", " + ship.getOriginLocCode() + ", " + ship.getFormTypeCode() + ", " + tranSeqTimestamp + ", " + ship.getManifestStatusCode() + ", " + ship.getSaturdayDelFlg() + ", " + ship.getHoldAtLocFlg() + ", " + ship.getDutiableFlg() + ", " + ship.getSpecialHandling1Cd() + ", " + ship.getSpecialHandling2Cd() + ", " + ship.getSpecialHandling3Cd() + ", " + ship.getSpecialHandling4Cd() + ", " + ship.getSpecialHandling5Cd() + ", " + ship.getLocalCustomsValueAmt() + ", " + ship.getHAWBSerialNumber() + ", " + ship.getRODFlag() + ", " + locationCode);
            throw ex;
        }
        saveCoreClearance(conn, ship, locationCode);
    }

    public void removeCoreClearance(Connection conn, Shipment ship, String locationCode)
        throws SQLException
    {
        try
        {
            removeShipmentCoreStmt = conn.prepareStatement(removeShipmentCoreSQL);
            removeShipmentCoreStmt.setInt(1, ship.getShipmentOidNumber());
            if(ship.getLocationCode() == null || ship.getLocationCode().equals(""))
                removeShipmentCoreStmt.setString(2, locationCode);
            else
                removeShipmentCoreStmt.setString(2, ship.getLocationCode());
            removeShipmentCoreStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "removeCoreClearance", removeShipmentCoreSQL, ship.getShipmentOidNumber() + ", " + locationCode);
            throw ex;
        }
    }

    public void removeAllCoreClearance(Connection conn, Shipment ship)
        throws SQLException
    {
        try
        {
            removeShipmentCoreStmt = conn.prepareStatement(removeShipmentCoreSQL);
            removeShipmentCoreStmt.setInt(1, ship.getShipmentOidNumber());
            removeShipmentCoreStmt.setString(2, "%");
            removeShipmentCoreStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "removeAllCoreClearance", removeShipmentCoreSQL, ship.getShipmentOidNumber() + ", " + "%");
            throw ex;
        }
    }

    public void remove(Connection conn, Shipment ship)
        throws SQLException
    {
        try
        {
            removeShipmentStmt = conn.prepareStatement(removeShipmentSQL);
            removeShipmentStmt.setInt(1, ship.getShipmentOidNumber());
            removeShipmentStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "remove", removeShipmentSQL, (new Integer(ship.getShipmentOidNumber())).toString());
            throw ex;
        }
        removeAllCoreClearance(conn, ship);
    }

    public void update(Connection conn, Shipment ship, String locationCode)
        throws SQLException
    {
        Timestamp shipDtTimestamp = null;
        Timestamp modifiedTimestamp = null;
        Timestamp tranSeqTimestamp = null;
        try
        {
            updateShipmentStmt = conn.prepareStatement(updateShipmentSQL);
            shipDtTimestamp = new Timestamp(ship.getShipmentDate().getTime());
            modifiedTimestamp = new Timestamp(ship.getLastModifiedTimestamp().getTime());
            tranSeqTimestamp = new Timestamp(ship.getTransactionSequenceTimestamp().getTime());
            updateShipmentStmt.setString(1, ship.getAWBNumber());
            updateShipmentStmt.setTimestamp(2, shipDtTimestamp);
            updateShipmentStmt.setInt(3, ship.getPieceQuanity());
            updateShipmentStmt.setInt(4, ship.getHandlingUnitQuanity());
            updateShipmentStmt.setDouble(5, ship.getCustomValueAmount());
            updateShipmentStmt.setDouble(6, ship.getCarriageValueAmount());
            updateShipmentStmt.setString(7, ship.getServiceCode());
            updateShipmentStmt.setString(8, ship.getOriginCountryCode());
            updateShipmentStmt.setString(9, ship.getDestinationCountryCode());
            updateShipmentStmt.setString(10, ship.getShipperCompanyName());
            updateShipmentStmt.setString(11, ship.getShipperPostalCode());
            updateShipmentStmt.setString(12, ship.getShipperCountryCode());
            updateShipmentStmt.setString(13, ship.getConsigneeCompanyName());
            updateShipmentStmt.setString(14, ship.getConsigneePostalCode());
            updateShipmentStmt.setString(15, ship.getConsigneeStateCode());
            updateShipmentStmt.setString(16, ship.getConsigneeCountryCode());
            updateShipmentStmt.setString(17, ship.getShipmentDescription());
            updateShipmentStmt.setString(18, ship.getDestinationLocCode());
            updateShipmentStmt.setString(19, ship.getOriginLocCode());
            updateShipmentStmt.setString(20, ship.getFormTypeCode());
            updateShipmentStmt.setTimestamp(21, tranSeqTimestamp);
            updateShipmentStmt.setString(22, ship.getManifestStatusCode());
            updateShipmentStmt.setString(23, ship.getSaturdayDelFlg());
            updateShipmentStmt.setString(24, ship.getHoldAtLocFlg());
            updateShipmentStmt.setString(25, ship.getDutiableFlg());
            updateShipmentStmt.setString(26, ship.getSpecialHandling1Cd());
            updateShipmentStmt.setString(27, ship.getSpecialHandling2Cd());
            updateShipmentStmt.setString(28, ship.getSpecialHandling3Cd());
            updateShipmentStmt.setString(29, ship.getSpecialHandling4Cd());
            updateShipmentStmt.setString(30, ship.getSpecialHandling5Cd());
            updateShipmentStmt.setDouble(31, ship.getLocalCustomsValueAmt());
            updateShipmentStmt.setString(32, ship.getRODFlag());
            updateShipmentStmt.setInt(33, ship.getShipmentOidNumber());
            updateShipmentStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "update", updateShipmentSQL, ship.getShipmentDate().getTime() + ", " + ship.getLastModifiedTimestamp().getTime() + ", " + ship.getTransactionSequenceTimestamp().getTime() + ", " + ship.getAWBNumber() + ", " + shipDtTimestamp + ", " + ship.getPieceQuanity() + ", " + ship.getHandlingUnitQuanity() + ", " + ship.getCustomValueAmount() + ", " + ship.getCarriageValueAmount() + ", " + ship.getServiceCode() + ", " + ship.getOriginCountryCode() + ", " + ship.getDestinationCountryCode() + ", " + ship.getShipperCompanyName() + ", " + ship.getShipperPostalCode() + ", " + ship.getShipperCountryCode() + ", " + ship.getConsigneeCompanyName() + ", " + ship.getConsigneePostalCode() + ", " + ship.getConsigneeStateCode() + ", " + ship.getConsigneeCountryCode() + ", " + ship.getShipmentDescription() + ", " + ship.getDestinationLocCode() + ", " + ship.getOriginLocCode() + ", " + ship.getFormTypeCode() + ", " + tranSeqTimestamp + ", " + ship.getManifestStatusCode() + ", " + ship.getSaturdayDelFlg() + ", " + ship.getHoldAtLocFlg() + ", " + ship.getDutiableFlg() + ", " + ship.getSpecialHandling1Cd() + ", " + ship.getSpecialHandling2Cd() + ", " + ship.getSpecialHandling3Cd() + ", " + ship.getSpecialHandling4Cd() + ", " + ship.getSpecialHandling5Cd() + ", " + ship.getLocalCustomsValueAmt() + ", " + ship.getRODFlag() + ", " + ship.getShipmentOidNumber() + ", " + locationCode);
            throw ex;
        }
        updateCoreClearance(conn, ship, locationCode);
    }

    public void updateCoreClearance(Connection conn, Shipment ship, String locationCode)
        throws SQLException
    {
        updateShipmentCoreStmt = conn.prepareStatement(updateShipmentCoreSQL);
        if(ship.getNullCoreClearance())
            saveCoreClearance(conn, ship, locationCode);
        Timestamp modifiedTimestamp = new Timestamp(ship.getLastModifiedTimestamp().getTime());
        updateShipmentCoreStmt.setString(1, ship.getReturnAWBNumber());
        updateShipmentCoreStmt.setString(2, ship.getLastModifiedName());
        updateShipmentCoreStmt.setTimestamp(3, modifiedTimestamp);
        updateShipmentCoreStmt.setString(4, ship.getOverageReasonCode());
        updateShipmentCoreStmt.setString(5, ship.getBrokerEntryNumber());
        updateShipmentCoreStmt.setString(6, ship.getCustomsReviewedFlag());
        updateShipmentCoreStmt.setString(7, ship.getCustomsReleaseFlag());
        updateShipmentCoreStmt.setString(8, ship.getDeclaredFlag());
        updateShipmentCoreStmt.setTimestamp(9, ship.getDeclaredTransactionSequenceTimestamp());
        updateShipmentCoreStmt.setString(10, ship.getIntransitCd());
        updateShipmentCoreStmt.setString(11, ship.getCustomsDestCd());
        updateShipmentCoreStmt.setString(12, ship.getEntryCategoryTypeCode());
        updateShipmentCoreStmt.setString(13, ship.getEntryCategorySourceCode());
        updateShipmentCoreStmt.setInt(14, ship.getShipmentOidNumber());
        updateShipmentCoreStmt.setString(15, ship.getLocationCode());
        updateShipmentCoreStmt.executeUpdate();
    }

    public void updateCoreClearanceWarehouse(Connection conn, int shipmentOid, String warehouseCode, String locationCode)
    throws SQLException
	{
	    updateShipmentCoreWarehouseStmt = conn.prepareStatement(updateShipmentCoreWarehouseSQL);
	    updateShipmentCoreWarehouseStmt.setString(1, warehouseCode);
	    updateShipmentCoreWarehouseStmt.setInt(2, shipmentOid);
	    updateShipmentCoreWarehouseStmt.setString(3, locationCode);
	    updateShipmentCoreWarehouseStmt.executeUpdate();
	}

    public static boolean dbTestCheckResults(Shipment s, DatabaseBean db, boolean isNullGood, int goodCount, String trkNbr[], String location[], boolean nullList[], String overageReasonCode[], 
            String msgPrefix)
        throws Exception
    {
        if(s == null && !isNullGood)
        {
            System.out.println(msgPrefix + "  FAIL  No record found");
            return false;
        }
        for(int i = 0; i < goodCount; i++)
        {
            if(s == null)
            {
                System.out.println(msgPrefix + "  FAIL  Minimum Record Count not found");
                return false;
            }
            if(!s.getAWBNumber().equals(trkNbr[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Shipment Waybill Number");
                System.err.println(msgPrefix + "  returned:  " + s);
                return false;
            }
            if(nullList[i] != s.getNullCoreClearance())
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match null core clearance flag");
                System.err.println(msgPrefix + "  returned:  " + s);
                return false;
            }
            if(!nullList[i] && !s.getLocationCode().equals(location[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Location Code");
                System.err.println(msgPrefix + "  returned:  " + s);
                return false;
            }
            if(!nullList[i] && !s.getOverageReasonCode().equals(overageReasonCode[i]))
            {
                System.out.println(msgPrefix + "  FAIL  Mis-Match Overage Reason Code");
                System.err.println(msgPrefix + "  returned:  " + s);
                return false;
            }
            System.out.println(msgPrefix + "  Row Number:  " + (i + 1) + " Success");
            s = db.fetchNextShipment();
        }

        if((s = db.fetchNextShipment()) != null)
        {
            System.out.println(msgPrefix + "  FAIL  Extra Rows Returned");
            do
                System.err.println(msgPrefix + "  returned:  " + s);
            while((s = db.fetchNextShipment()) != null);
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
        Shipment s3 = new Shipment(33, "44", new java.util.Date(), 0, 0, false, false, "", "", "", "", "");
        s3.setLocationCode("DHN");
        s3.setOverageReasonCode("S");
        s3.setCustomsReviewedFlag("N");
        s3.setSpecialHandling1Cd("HCD11");
        s3.setSpecialHandling2Cd("HCD22");
        s3.setSpecialHandling3Cd("HCD33");
        s3.setSpecialHandling4Cd("HCD44");
        s3.setSpecialHandling5Cd("HCD55");
        s3.setRODFlag("N");
        s3.setSaturdayDelFlg("N");
        s3.setHoldAtLocFlg("N");
        s3.setDutiableFlg("N");
        s3.setNullCoreClearance(false);
        s3.setEntryCategorySourceCd("M");
        s3.setEntryCategoryTypeCd("TST");
        s3.setBrokerEntryNumber("Noodle");
        db.saveShipment(s3);
        db.commitTransaction();
        System.out.println("Shipment 33 Saved successfully");
        Shipment shipment4 = db.fetchShipment(33);
        System.out.println("Shipment 33 FETCHED " + shipment4);
        db.removeShipment(s3);
        Shipment shipment5 = db.fetchShipment(33);
        if(shipment5 == null)
            System.out.println("Removal of shipment 33 successful ");
        else
            System.out.println("Could not remove shipment 33 ");
        db.closeConnection();
        return true;
    }

    public static void main(String args[])
    {
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            db.setLocationCode("DHN");
            dbTest(db);
        }
        catch(Exception e)
        {
            System.out.println("DbShipment.main() caught an exception:  " + e);
            e.printStackTrace(System.out);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbShipment.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    private static String SHIPMENT;
    private static String SHIPMENT_CORE_CLEARANCE;
    private static final String fetchColumnList = "S.SHIPMENT_OID_NBR, S.AWB_NBR, S.SHIPMENT_DT, S.PIECE_QTY, S.HANDLING_UNIT_QTY, S.CUSTOMS_VALUE_AMT, S.CARRIAGE_VALUE_AMT, S.SERVICE_CD, S.ORIGIN_LOCATION_COUNTRY_CD, S.DEST_LOCATION_COUNTRY_CD, S.SHIPPER_COMPANY_NM, S.SHIPPER_POSTAL_CD, S.SHIPPER_COUNTRY_CD, S.CONSIGNEE_COMPANY_NM, S.CONSIGNEE_POSTAL_CD, S.CONSIGNEE_STATE_CD, S.CONSIGNEE_COUNTRY_CD, S.SHIPMENT_DESC, S.SDL_FLG, S.HAL_FLG, S.DUTIABLE_FLG, S.SPECIAL_HANDLING1_CD, S.SPECIAL_HANDLING2_CD, S.SPECIAL_HANDLING3_CD, S.SPECIAL_HANDLING4_CD, S.SPECIAL_HANDLING5_CD, SCC.RETURN_AWB_NBR, S.DEST_LOCATION_CD, S.ORIGIN_LOCATION_CD, S.FORM_TYPE_CD, SCC.LAST_MODIFIED_NM, SCC.LAST_MODIFIED_TMSTP, SCC.OVERAGE_REASON_CD, SCC.BROKER_ENTRY_NBR, SCC.CUSTOMS_REVIEWED_FLG, S.TRANSACTION_SEQ_TMSTP, S.MANIFEST_STATUS_CD, SCC.CUSTOMS_RELEASE_FLG, SCC.LOCATION_CD, SCC.SHIPMENT_OID_NBR, SCC.DECLARED_FLG,  TO_DATE(TO_CHAR(SCC.DECLARED_TRANSACTION_SEQ_TMSTP,'MM/DD/YYYY hh24:mi:ss'),'MM/DD/YYYY hh24:mi:ss'), SCC.INTRANSIT_CD, SCC.CUSTOMS_DEST_CD, S.LOCAL_CUSTOMS_VALUE_AMT, S.HAWB_SERIAL_NBR, SCC.ENTRY_CATEGORY_TYPE_CD, S.SHIPPER_CONTACT_NM, S.CONSIGNEE_CONTACT_NM, S.SHIPPER_ACCT_NBR, S.CONSIGNEE_ACCT_NBR, S.SDL_FLG, S.LBS_WGT, S.MAWB_NBR, S.PRIOR_NOTIFICATION_NBR, SCC.ENTRY_CATEGORY_SOURCE_CD, S.ROD_FLG, S.CONSIGNEE_ADDRESS1_DESC, S.CONSIGNEE_CITY_NM ";
    private static final String fetchBaseSQL;
    private static final String fetchSingleLocBaseSQL;
    private static final String fetchSingleLocBaseOuterSQL;
    private static final String fetchLocListBaseSQL;
    private static final String fetchWithShipmentOidSQL;
    private static final String fetchWithShipmentOidOuterSQL;
    private static final String fetchShipmentWithTrackingNbrSingleSQL;
    private static final String fetchShipmentWithTrackingNbrListSQL;
    private String fetchShipmentWithFiveFieldsSQL;
    private String saveShipmentSQL;
    private String saveShipmentCoreSQL;
    private String removeShipmentSQL;
    private String removeShipmentCoreSQL;
    private String updateShipmentSQL;
    private String updateShipmentCoreSQL;
    private String updateShipmentCoreWarehouseSQL;
    
    private PreparedStatement fetchWithShipmentOidStmt;
    private PreparedStatement fetchWithShipmentOidOuterStmt;
    private PreparedStatement fetchShipmentWithTrackingNbrSingleStmt;
    private PreparedStatement fetchShipmentWithTrackingNbrListStmt;
    private PreparedStatement fetchShipmentWithFiveFieldsStmt;
    private PreparedStatement saveShipmentStmt;
    private PreparedStatement saveShipmentCoreStmt;
    private PreparedStatement removeShipmentStmt;
    private PreparedStatement removeShipmentCoreStmt;
    private PreparedStatement updateShipmentStmt;
    private PreparedStatement updateShipmentCoreStmt;

    private PreparedStatement updateShipmentCoreWarehouseStmt;

    
    static 
    {
        SHIPMENT = "SHIPMENT ";
        SHIPMENT_CORE_CLEARANCE = "SHIPMENT_CORE_CLEARANCE ";
        fetchBaseSQL = "SELECT S.SHIPMENT_OID_NBR, S.AWB_NBR, S.SHIPMENT_DT, S.PIECE_QTY, S.HANDLING_UNIT_QTY, S.CUSTOMS_VALUE_AMT, S.CARRIAGE_VALUE_AMT, S.SERVICE_CD, S.ORIGIN_LOCATION_COUNTRY_CD, S.DEST_LOCATION_COUNTRY_CD, S.SHIPPER_COMPANY_NM, S.SHIPPER_POSTAL_CD, S.SHIPPER_COUNTRY_CD, S.CONSIGNEE_COMPANY_NM, S.CONSIGNEE_POSTAL_CD, S.CONSIGNEE_STATE_CD, S.CONSIGNEE_COUNTRY_CD, S.SHIPMENT_DESC, S.SDL_FLG, S.HAL_FLG, S.DUTIABLE_FLG, S.SPECIAL_HANDLING1_CD, S.SPECIAL_HANDLING2_CD, S.SPECIAL_HANDLING3_CD, S.SPECIAL_HANDLING4_CD, S.SPECIAL_HANDLING5_CD, SCC.RETURN_AWB_NBR, S.DEST_LOCATION_CD, S.ORIGIN_LOCATION_CD, S.FORM_TYPE_CD, SCC.LAST_MODIFIED_NM, SCC.LAST_MODIFIED_TMSTP, SCC.OVERAGE_REASON_CD, SCC.BROKER_ENTRY_NBR, SCC.CUSTOMS_REVIEWED_FLG, S.TRANSACTION_SEQ_TMSTP, S.MANIFEST_STATUS_CD, SCC.CUSTOMS_RELEASE_FLG, SCC.LOCATION_CD, SCC.SHIPMENT_OID_NBR, SCC.DECLARED_FLG,  TO_DATE(TO_CHAR(SCC.DECLARED_TRANSACTION_SEQ_TMSTP,'MM/DD/YYYY hh24:mi:ss'),'MM/DD/YYYY hh24:mi:ss'), SCC.INTRANSIT_CD, SCC.CUSTOMS_DEST_CD, S.LOCAL_CUSTOMS_VALUE_AMT, S.HAWB_SERIAL_NBR, SCC.ENTRY_CATEGORY_TYPE_CD, S.SHIPPER_CONTACT_NM, S.CONSIGNEE_CONTACT_NM, S.SHIPPER_ACCT_NBR, S.CONSIGNEE_ACCT_NBR, S.SDL_FLG, S.LBS_WGT, S.MAWB_NBR, S.PRIOR_NOTIFICATION_NBR, SCC.ENTRY_CATEGORY_SOURCE_CD, S.ROD_FLG, S.CONSIGNEE_ADDRESS1_DESC, S.CONSIGNEE_CITY_NM  FROM " + SHIPMENT + " S , " + SHIPMENT_CORE_CLEARANCE + " SCC ";
        fetchSingleLocBaseSQL = fetchBaseSQL + "WHERE S.SHIPMENT_OID_NBR = SCC.SHIPMENT_OID_NBR " + "AND SCC.LOCATION_CD = ? ";
        fetchSingleLocBaseOuterSQL = fetchBaseSQL + "WHERE S.SHIPMENT_OID_NBR = SCC.SHIPMENT_OID_NBR(+) " + "AND SCC.LOCATION_CD(+) = ? ";
        fetchLocListBaseSQL = fetchBaseSQL + "WHERE S.SHIPMENT_OID_NBR = SCC.SHIPMENT_OID_NBR(+) " + " AND SCC.LOCATION_CD(+) = ? " + " AND exists (SELECT * FROM " + SHIPMENT_CORE_CLEARANCE + "SCC2 " + "               WHERE SCC2.SHIPMENT_OID_NBR = S.SHIPMENT_OID_NBR " + "               AND SCC2.LOCATION_CD in (?,?,?,?,?,?,?,?,?,?)) ";
        fetchWithShipmentOidSQL = fetchSingleLocBaseSQL + "AND S.SHIPMENT_OID_NBR = ? ";
        fetchWithShipmentOidOuterSQL = fetchSingleLocBaseOuterSQL + "AND S.SHIPMENT_OID_NBR = ? ";
        fetchShipmentWithTrackingNbrSingleSQL = fetchSingleLocBaseSQL + "AND AWB_NBR = ? AND SHIPMENT_DT BETWEEN TRUNC(SYSDATE) AND  TRUNC(SYSDATE) +0.9999";
        fetchShipmentWithTrackingNbrListSQL = fetchLocListBaseSQL + "AND AWB_NBR = ?";
    }
}
