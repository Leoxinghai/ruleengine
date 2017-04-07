/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;

import com.fedex.cih.vo.ShipmentInfo;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbShipment extends DbBase
{

    public DbShipment()
    {
        ShipmentTableColumnNames = "ROUTE_NBR,ROUTE_DT, CLASSIFICATION, MAWB, DECLARED_FLG ";
        fetchShipmentByPrimaryKeysSQL = "SELECT " + ShipmentTableColumnNames + "FROM ACCS_CORE_SHIPMENT_REF S WHERE S.SHIPMENT_OID =? ";
        saveShipmentSQL = "INSERT INTO ACCS_CORE_SHIPMENT_REF ( SHIPMENT_OID," + ShipmentTableColumnNames + " ) VALUES (?,?,?,?,?)";
        updateShipmentSQL = "UPDATE ACCS_CORE_SHIPMENT_REF SET ROUTE_NBR = ?, ROUTE_DT = ?, CLASSIFICATION = ?, MAWB = ?, DECLARED_FLG WHERE SHIPMENT_OID = ? ";
        removeShipmentSQL = "DELETE FROM ACCS_CORE_SHIPMENT_REF WHERE SHIPMENT_OID = ?";
        fetchShipmentByPrimaryKeysStmt = null;
        saveShipmentStmt = null;
        updateShipmentStmt = null;
        removeShipmentStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchShipmentByPrimaryKeysStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            saveShipmentStmt.close();
        }
        catch(Exception exception2) { }
        try
        {
            updateShipmentStmt.close();
        }
        catch(Exception exception3) { }
        try
        {
            removeShipmentStmt.close();
        }
        catch(Exception exception4) { }
    }

    private DbShipment(Connection connection)
        throws SQLException
    {
        ShipmentTableColumnNames = "ROUTE_NBR,ROUTE_DT, CLASSIFICATION, MAWB, DECLARED_FLG ";
        fetchShipmentByPrimaryKeysSQL = "SELECT " + ShipmentTableColumnNames + "FROM ACCS_CORE_SHIPMENT_REF S WHERE S.SHIPMENT_OID =? ";
        saveShipmentSQL = "INSERT INTO ACCS_CORE_SHIPMENT_REF (SHIPMENT_OID, " + ShipmentTableColumnNames + " ) VALUES (?,?,?,?,?,?)";
        updateShipmentSQL = "UPDATE ACCS_CORE_SHIPMENT_REF SET ROUTE_NBR = ?, ROUTE_DT = ?, CLASSIFICATION = ?, MAWB = ?, DECLARED_FLG WHERE SHIPMENT_OID = ? ";
        removeShipmentSQL = "DELETE FROM ACCS_CORE_SHIPMENT_REF WHERE SHIPMENT_OID = ?";
        fetchShipmentByPrimaryKeysStmt = null;
        saveShipmentStmt = null;
        updateShipmentStmt = null;
        removeShipmentStmt = null;
        try
        {
            fetchShipmentByPrimaryKeysStmt = connection.prepareStatement(fetchShipmentByPrimaryKeysSQL);
            saveShipmentStmt = connection.prepareStatement(saveShipmentSQL);
            updateShipmentStmt = connection.prepareStatement(updateShipmentSQL);
            removeShipmentStmt = connection.prepareStatement(removeShipmentSQL);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1410", "DbShipment constructor", "Failed to construct DBShipment: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment constructor");
    }

    public int getShipmentRecordCount()
    {
        return m_recordCount;
    }

    public ShipmentInfo fetch(int shipmentOid, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchShipmentByPrimaryKeysStmt != null)
                fetchShipmentByPrimaryKeysStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.fetch() - unable to close statement");
        }
        try
        {
            fetchShipmentByPrimaryKeysStmt = connection.prepareStatement(fetchShipmentByPrimaryKeysSQL);
            fetchShipmentByPrimaryKeysStmt.setInt(1, shipmentOid);
            runQuery(fetchShipmentByPrimaryKeysStmt);
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbShipment.fetch(setName,ruleNbr,condNbr)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.fetch(setName,ruleNbr,condNbr)");
        return fetchNext();
    }

    public ShipmentInfo fetchNext()
        throws SQLException
    {
        ShipmentInfo shipmentinfo = new ShipmentInfo();
        try
        {
            if(m_hasMore)
            {
                shipmentinfo.setFlightNumber(m_resultSet.getString(1));
                shipmentinfo.setFlightDate(m_resultSet.getDate(2));
                shipmentinfo.setClassification(m_resultSet.getString(3));
                shipmentinfo.setMAWBNumber(m_resultSet.getString(4));
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
                shipmentinfo = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1200", "DbShipment.fetchNext()", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.fetchNext()");
        return shipmentinfo;
    }

    public void save(ShipmentInfo shipmentinfo, Connection connection)
        throws SQLException
    {
        try
        {
            if(saveShipmentStmt != null)
                saveShipmentStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.save() - unable to close statement");
        }
        try
        {
            saveShipmentStmt = connection.prepareStatement(saveShipmentSQL);
            saveShipmentStmt.setInt(1, (int)shipmentinfo.getShipmentOid());
            saveShipmentStmt.setString(2, shipmentinfo.getFlightNumber());
            saveShipmentStmt.setDate(3, new java.sql.Date(shipmentinfo.getFlightDate().getTime()));
            saveShipmentStmt.setString(4, shipmentinfo.getClassification());
            saveShipmentStmt.setString(5, shipmentinfo.getMAWBNumber());
            saveShipmentStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbShipment.save(rs)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.save()");
    }

    public void update(ShipmentInfo shipmentinfo, Connection connection)
        throws SQLException
    {
        try
        {
            if(updateShipmentStmt != null)
                updateShipmentStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.update() - unable to close statement");
        }
        try
        {
            updateShipmentStmt = connection.prepareStatement(updateShipmentSQL);
            updateShipmentStmt.setString(1, shipmentinfo.getFlightNumber());
            updateShipmentStmt.setDate(2,new java.sql.Date(shipmentinfo.getFlightDate().getTime()));
            updateShipmentStmt.setString(3, shipmentinfo.getClassification());
            updateShipmentStmt.setString(4, shipmentinfo.getMAWBNumber());
            updateShipmentStmt.setInt(5, (int)shipmentinfo.getShipmentOid());
            updateShipmentStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbShipment.update(rs)", "Failure in update for all non-keyed fields in the database: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.update()");
    }

    public void remove(ShipmentInfo shipmentinfo, Connection connection)
        throws SQLException
    {
        try
        {
            if(removeShipmentStmt != null)
                removeShipmentStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.remove() - unable to close statement");
        }
        try
        {
            removeShipmentStmt = connection.prepareStatement(removeShipmentSQL);
            removeShipmentStmt.setInt(1, (int)shipmentinfo.getShipmentOid());
            removeShipmentStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1500", "DbShipment.remove(rs)", "Failed to delete Shipment: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.remove()");
    }

    private String ShipmentTableColumnNames;
    private String fetchShipmentByPrimaryKeysSQL;
    private String saveShipmentSQL;
    private String updateShipmentSQL;
    private String removeShipmentSQL;
    private PreparedStatement fetchShipmentByPrimaryKeysStmt;
    private PreparedStatement saveShipmentStmt;
    private PreparedStatement updateShipmentStmt;
    private PreparedStatement removeShipmentStmt;
}
