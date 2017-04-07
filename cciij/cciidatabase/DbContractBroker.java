// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbContractBroker.java

package cciij.cciidatabase;

import cciij.cciidata.ContractBroker;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbContractBroker extends DbBase
{

    public DbContractBroker()
    {
        fetchContractBrokerSql = "SELECT SHIPMENT_OID_NBR, BROKER_NM, BROKER_CITY_NM, BROKER_COUNTRY_CD, BROKER_POSTAL_CD, BROKER_DEST_LOC_CD, BROKER_PHONE_NBR FROM CONTRACT_BROKER WHERE SHIPMENT_OID_NBR = ? ";
        saveContractBrokerSql = "INSERT INTO CONTRACT_BROKER  (SHIPMENT_OID_NBR, BROKER_NM, BROKER_CITY_NM, BROKER_COUNTRY_CD, BROKER_POSTAL_CD, BROKER_DEST_LOC_CD, BROKER_PHONE_NBR ) VALUES( ?, ?, ?, ?, ?, ?, ?)";
        deleteContractBrokerSql = "DELETE FROM CONTRACT_BROKER  WHERE SHIPMENT_OID_NBR = ?";
        updateContractBrokerSql = "UPDATE CONTRACT_BROKER  SET SHIPMENT_OID_NBR = ?, BROKER_NM = ?, BROKER_CITY_NM = ?, BROKER_COUNTRY_CD = ?, BROKER_POSTAL_CD = ?, BROKER_DEST_LOC_CD = ?, BROKER_PHONE_NBR = ? WHERE SHIPMENT_OID_NBR = ?";
        fetchContractBrokerStmt = null;
        saveContractBrokerStmt = null;
        deleteContractBrokerStmt = null;
        updateContractBrokerStmt = null;
    }

    public ContractBroker fetch(Connection conn, int shipmentOidNbr)
        throws SQLException
    {
        try
        {
            fetchContractBrokerStmt = conn.prepareStatement(fetchContractBrokerSql);
            fetchContractBrokerStmt.setInt(1, shipmentOidNbr);
            runQuery(fetchContractBrokerStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", fetchContractBrokerSql, "");
            throw e;
        }
        return fetchNext();
    }

    public ContractBroker fetchNext()
        throws SQLException
    {
        ContractBroker contractBroker = new ContractBroker();
        if(m_hasMore)
        {
            contractBroker.setShipmentOidNbr(m_resultSet.getInt("SHIPMENT_OID_NBR"));
            contractBroker.setBrokerNm(m_resultSet.getString("BROKER_NM"));
            contractBroker.setBrokerCityNm(m_resultSet.getString("BROKER_CITY_NM"));
            contractBroker.setBrokerCountryCd(m_resultSet.getString("BROKER_COUNTRY_CD"));
            contractBroker.setBrokerPostalCd(m_resultSet.getString("BROKER_POSTAL_CD"));
            contractBroker.setBrokerDestLocCd(m_resultSet.getString("BROKER_DEST_LOC_CD"));
            contractBroker.setBrokerPhoneNbr(m_resultSet.getString("BROKER_PHONE_NBR"));
            try
            {
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            }
            catch(SQLException e)
            {
                printSQLException(e, getClass().getName(), "fetchNext", "", "");
                throw e;
            }
        } else
        {
            contractBroker = null;
            m_recordCount = 0;
        }
        return contractBroker;
    }

    public void save(Connection conn, ContractBroker contractBroker)
        throws SQLException
    {
        try
        {
            saveContractBrokerStmt = conn.prepareStatement(saveContractBrokerSql);
            saveContractBrokerStmt.setInt(1, contractBroker.getShipmentOidNbr());
            saveContractBrokerStmt.setString(2, contractBroker.getBrokerNm());
            saveContractBrokerStmt.setString(3, contractBroker.getBrokerCityNm());
            saveContractBrokerStmt.setString(4, contractBroker.getBrokerCountryCd());
            saveContractBrokerStmt.setString(5, contractBroker.getBrokerPostalCd());
            saveContractBrokerStmt.setString(6, contractBroker.getBrokerDestLocCd());
            saveContractBrokerStmt.setString(7, contractBroker.getBrokerPhoneNbr());
            saveContractBrokerStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "save", saveContractBrokerSql, contractBroker.getShipmentOidNbr() + ", " + contractBroker.getBrokerNm() + ", " + contractBroker.getBrokerCityNm() + ", " + contractBroker.getBrokerCountryCd() + ", " + contractBroker.getBrokerPostalCd() + ", " + contractBroker.getBrokerDestLocCd() + ", " + contractBroker.getBrokerPhoneNbr());
            throw e;
        }
    }

    public void update(Connection conn, ContractBroker contractBroker)
        throws SQLException
    {
        try
        {
            updateContractBrokerStmt = conn.prepareStatement(updateContractBrokerSql);
            updateContractBrokerStmt.setInt(1, contractBroker.getShipmentOidNbr());
            updateContractBrokerStmt.setString(2, contractBroker.getBrokerNm());
            updateContractBrokerStmt.setString(3, contractBroker.getBrokerCityNm());
            updateContractBrokerStmt.setString(4, contractBroker.getBrokerCountryCd());
            updateContractBrokerStmt.setString(5, contractBroker.getBrokerPostalCd());
            updateContractBrokerStmt.setString(6, contractBroker.getBrokerDestLocCd());
            updateContractBrokerStmt.setString(7, contractBroker.getBrokerPhoneNbr());
            updateContractBrokerStmt.setInt(8, contractBroker.getShipmentOidNbr());
            updateContractBrokerStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "update", updateContractBrokerSql, contractBroker.getShipmentOidNbr() + ", " + contractBroker.getBrokerNm() + ", " + contractBroker.getBrokerCityNm() + ", " + contractBroker.getBrokerCountryCd() + ", " + contractBroker.getBrokerPostalCd() + ", " + contractBroker.getBrokerDestLocCd() + ", " + contractBroker.getBrokerPhoneNbr() + ", " + contractBroker.getShipmentOidNbr());
            throw e;
        }
    }

    public void delete(Connection conn, int ShipmentOidNbr)
        throws SQLException
    {
        try
        {
            deleteContractBrokerStmt = conn.prepareStatement(deleteContractBrokerSql);
            deleteContractBrokerStmt.setInt(1, ShipmentOidNbr);
            deleteContractBrokerStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "delete", deleteContractBrokerSql, "");
            throw e;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("COSA");
        db.connect();
        DbContractBroker dbContractBroker = new DbContractBroker();
        dbContractBroker.testDbContractBroker(db);
        db.closeConnection();
    }

    private void testDbContractBroker(DatabaseBean db)
    {
        ContractBroker contractBroker = null;
        try
        {
            System.out.println("====Executing INSERT 12345, XYZ BROKER, COLORADO SPRINGS, US, 80132, COSA, 123-4567");
            db.saveContractBroker(new ContractBroker(12345, "XYZ Broker", "Colorado Springs", "US", "80132", "COSA", "123-4567"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting contractBroker " + e.getMessage());
        }
        try
        {
            System.out.println("====Executing SELECT BY SHIPMENT_OID_NBR 12345");
            contractBroker = db.fetchContractBroker(12345);
            if(contractBroker != null)
                System.out.println(contractBroker);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHIPMENT_OID_NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE BY SHIPMENT_OID_NBR");
            db.updateContractBroker(new ContractBroker(54321, "ABC BROKER", "DENVER", "US", "80101", "DENRT", "987-3210"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while updateing by SHIPMENT_OID_NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHIPMENT_OID_NBR");
            contractBroker = db.fetchContractBroker(54321);
            if(contractBroker != null)
                System.out.println(contractBroker);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by SHIPMENT_OID_NBR" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE 54321 ");
            db.removeContractBroker(54321);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while deleting ContractBroker " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY SHIPMENT_OID_NBR 12345");
            contractBroker = db.fetchContractBroker(54321);
            if(contractBroker != null)
                System.out.println(contractBroker);
            else
                System.out.println("ContractBroker not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while fetching ContractBroker by SHIPMENT_OID_NBR " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbContractBroker.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private static final String tableName = "CONTRACT_BROKER ";
    private String fetchContractBrokerSql;
    private String saveContractBrokerSql;
    private String deleteContractBrokerSql;
    private String updateContractBrokerSql;
    private PreparedStatement fetchContractBrokerStmt;
    private PreparedStatement saveContractBrokerStmt;
    private PreparedStatement deleteContractBrokerStmt;
    private PreparedStatement updateContractBrokerStmt;
}
