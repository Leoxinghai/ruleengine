// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbAgency.java

package cciij.cciidatabase;

import cciij.cciidata.Agency;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbAgency extends DbBase
{

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    public static boolean dbTest(DatabaseBean db)
    {
        Agency agency = new Agency("JM", "FEDEX", 1, "Y", "Y", "Y");
        try
        {
            db.setLocationCode("AAA");
            agency.setLocationCode("AAA");
            db.removeAgency(agency);
            agency.setLocationCode("");
            db.saveAgency(agency);
            db.setLocationCode("BBB");
            agency = new Agency("SM", "Federal Express", 1, "Y", "Y", "Y");
            agency.setLocationCode("BBB");
            db.removeAgency(agency);
            agency.setLocationCode("");
            db.saveAgency(agency);
            agency = new Agency("RM", "Agi", 1, "Y", "Y", "Y");
            db.setLocationCode("CCC");
            agency.setLocationCode("CCC");
            db.removeAgency(agency);
            db.saveAgency(agency);
            System.out.println("Test Case 1: Successfully saved agency");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1 unsuccessful" + ex);
        }
        int currentRow;
        try
        {
            db.setLocationCode("CCC");
            agency = db.fetchAgency("RM");
            for(currentRow = 1; db.getAgencyRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 2 Successful: Row " + currentRow + "-Results of fetch(agencyCd, locationCd)" + agency);
                agency = db.fetchNextAgency();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("CCC");
            agency = db.fetchAgency();
            for(currentRow = 1; db.getAgencyRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3 Successful: Row = " + currentRow + "-Results of fetch(locationCd)" + agency);
                agency = db.fetchNextAgency();
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
            db.setLocationCode("CCC");
            agency = db.fetchAgency("RM");
            agency.setRecordActiveFlag("Y");
            db.updateAgency(agency);
            System.out.println("Test Case 4 Successful: Row = " + currentRow + "-Results update" + agency);
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        try
        {
            db.setLocationCode("CCC");
            agency = db.fetchAgencyAllActive();
            for(currentRow = 1; db.getAgencyRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 5 Succesful: Row = " + currentRow + "-Results of fetchAgencyAllActive(locationCd)" + agency);
                agency = db.fetchNextAgency();
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
            agency = db.fetchAgency("RM");
            db.removeAgency(agency);
            if(db.fetchAgency("RM") == null)
                System.out.println("Test Case 6: Remove Successful ");
            else
                System.out.println("Test Case 6: Remove UnSuccessful ");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 6 unsuccessful" + ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public DbAgency()
    {
        fetchByPrimaryKeySQL = "SELECT AGENCY_CD, AGENCY_DESC, CLEARANCE_PRIORITY_CD, STAGE_OUT_INTCP_SATISFY_FLG, CUSTOMS_AGENCY_FLG, RECORD_ACTIVE_FLG, LOCATION_CD FROM AGENCY WHERE AGENCY_CD = ? AND LOCATION_CD = ?";
        fetchAllAgencySQL = "SELECT AGENCY_CD, AGENCY_DESC, CLEARANCE_PRIORITY_CD, STAGE_OUT_INTCP_SATISFY_FLG, CUSTOMS_AGENCY_FLG, RECORD_ACTIVE_FLG, LOCATION_CD FROM AGENCY WHERE LOCATION_CD = ? ORDER BY AGENCY_CD";
        fetchAllActiveAgencySQL = "SELECT AGENCY_CD, AGENCY_DESC, CLEARANCE_PRIORITY_CD, STAGE_OUT_INTCP_SATISFY_FLG, CUSTOMS_AGENCY_FLG, RECORD_ACTIVE_FLG, LOCATION_CD FROM AGENCY WHERE RECORD_ACTIVE_FLG = 'Y' AND LOCATION_CD = ?ORDER BY AGENCY_CD";
        saveAgencySQL = "INSERT INTO AGENCY (AGENCY_CD, AGENCY_DESC, CLEARANCE_PRIORITY_CD, STAGE_OUT_INTCP_SATISFY_FLG, CUSTOMS_AGENCY_FLG, RECORD_ACTIVE_FLG, LOCATION_CD) VALUES(?,?,?,?,?,?,?)";
        removeAgencySQL = "DELETE FROM AGENCY WHERE AGENCY_CD = ? AND LOCATION_CD = ?";
        updateAgencySQL = "UPDATE AGENCY SET AGENCY_DESC = ?, CLEARANCE_PRIORITY_CD = ?, STAGE_OUT_INTCP_SATISFY_FLG = ?, CUSTOMS_AGENCY_FLG = ?,RECORD_ACTIVE_FLG = ? WHERE AGENCY_CD = ? AND LOCATION_CD = ?";
        fetchByPrimaryKeyStmt = null;
        fetchAllAgencyStmt = null;
        fetchAllActiveAgencyStmt = null;
        saveAgencyStmt = null;
        removeAgencyStmt = null;
        updateAgencyStmt = null;
    }

    public int getAgencyRecordCount()
    {
        return m_recordCount;
    }

    public Agency fetch(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllAgencyStmt = conn.prepareStatement(fetchAllAgencySQL);
            fetchAllAgencyStmt.setString(1, locationCd);
            runQuery(fetchAllAgencyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchAllAgencySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Agency fetchActiveAgency(Connection conn, String locationCd)
        throws SQLException
    {
        try
        {
            fetchAllActiveAgencyStmt = conn.prepareStatement(fetchAllActiveAgencySQL);
            fetchAllActiveAgencyStmt.setString(1, locationCd);
            runQuery(fetchAllActiveAgencyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCd;
            printSQLException(ex, getClass().getName(), "fetchActiveAgency", fetchAllActiveAgencySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Agency fetch(Connection conn, String agencyCd, String locationCd)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, agencyCd);
            fetchByPrimaryKeyStmt.setString(2, locationCd);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = agencyCd + ", " + locationCd;
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public Agency fetchNext()
        throws SQLException
    {
        Agency agency = new Agency();
        try
        {
            if(m_hasMore)
            {
                String agcyCd = m_resultSet.getString(1);
                String agcyDesc = m_resultSet.getString(2);
                int priorityCd = m_resultSet.getInt(3);
                String satisfyFlg = m_resultSet.getString(4);
                String customAgcyFlg = m_resultSet.getString(5);
                String recordActiveFlg = m_resultSet.getString(6);
                String locationCd = m_resultSet.getString(7);
                agency = new Agency(agcyCd, agcyDesc, priorityCd, satisfyFlg, customAgcyFlg, recordActiveFlg);
                agency.setLocationCode(locationCd);
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
                agency = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext", "", "");
            throw ex;
        }
        return agency;
    }

    public void save(Connection conn, Agency agency, String locationCd)
        throws SQLException
    {
        try
        {
            saveAgencyStmt = conn.prepareStatement(saveAgencySQL);
            saveAgencyStmt.setString(1, agency.getAgencyCode());
            saveAgencyStmt.setString(2, agency.getAgencyDescription());
            saveAgencyStmt.setInt(3, agency.getClearancePriorityCode());
            saveAgencyStmt.setString(4, agency.getStageOutInterceptSatisfyFlag());
            saveAgencyStmt.setString(5, agency.getCustomsAgencyFlag());
            saveAgencyStmt.setString(6, agency.getRecordActiveFlag());
            if(agency.getLocationCode().equals(""))
                saveAgencyStmt.setString(7, locationCd);
            else
                saveAgencyStmt.setString(7, agency.getLocationCode());
            System.out.println("agency object" + agency);
            saveAgencyStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = agency.getAgencyCode() + ", " + agency.getAgencyDescription() + ", " + agency.getClearancePriorityCode() + ", " + agency.getStageOutInterceptSatisfyFlag() + ", " + agency.getCustomsAgencyFlag() + ", " + agency.getRecordActiveFlag() + ", ";
            if(agency.getLocationCode().equals(""))
                paramList = paramList + locationCd;
            else
                paramList = paramList + agency.getLocationCode();
            printSQLException(ex, getClass().getName(), "save", saveAgencySQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, Agency agency)
        throws SQLException
    {
        try
        {
            removeAgencyStmt = conn.prepareStatement(removeAgencySQL);
            removeAgencyStmt.setString(1, agency.getAgencyCode());
            removeAgencyStmt.setString(2, agency.getLocationCode());
            removeAgencyStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = agency.getAgencyCode() + ", " + agency.getLocationCode();
            printSQLException(ex, getClass().getName(), "remove", removeAgencySQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, Agency agency)
        throws SQLException
    {
        try
        {
            updateAgencyStmt = conn.prepareStatement(updateAgencySQL);
            updateAgencyStmt.setString(1, agency.getAgencyDescription());
            updateAgencyStmt.setInt(2, agency.getClearancePriorityCode());
            updateAgencyStmt.setString(3, agency.getStageOutInterceptSatisfyFlag());
            updateAgencyStmt.setString(4, agency.getCustomsAgencyFlag());
            updateAgencyStmt.setString(5, agency.getRecordActiveFlag());
            updateAgencyStmt.setString(6, agency.getAgencyCode());
            updateAgencyStmt.setString(7, agency.getLocationCode());
            updateAgencyStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = agency.getAgencyDescription() + ", " + agency.getClearancePriorityCode() + ", " + agency.getStageOutInterceptSatisfyFlag() + ", " + agency.getCustomsAgencyFlag() + ", " + agency.getRecordActiveFlag() + ", " + agency.getAgencyCode() + ", " + agency.getLocationCode();
            printSQLException(ex, getClass().getName(), "update", updateAgencySQL, paramList);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbAgency.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchByPrimaryKeySQL;
    private String fetchAllAgencySQL;
    private String fetchAllActiveAgencySQL;
    private String saveAgencySQL;
    private String removeAgencySQL;
    private String updateAgencySQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchAllAgencyStmt;
    private PreparedStatement fetchAllActiveAgencyStmt;
    private PreparedStatement saveAgencyStmt;
    private PreparedStatement removeAgencyStmt;
    private PreparedStatement updateAgencyStmt;
}
