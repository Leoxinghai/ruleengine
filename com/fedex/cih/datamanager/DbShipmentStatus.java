/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;


import com.fedex.cih.vo.ShipmentStatus;
import com.fedex.css.util.Trace;
import java.sql.*;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbBase

public class DbShipmentStatus extends DbBase
{

    public DbShipmentStatus()
    {
        TableColumnNames = "GRP_OID_NBR, STATUS_TYPE_CD, STATUS_CD ";
        fetchByPrimaryKeysSQL = "SELECT " + TableColumnNames + "FROM ACCS_CORE_SHP_STATUS WHERE GRP_OID_NBR =? AND OID_TYPE_CD ='S'";
        fetchByStatusSQL = "SELECT " + TableColumnNames + "FROM ACCS_CORE_SHP_STATUS WHERE GRP_OID_NBR =? AND OID_TYPE_CD ='S' AND STATUS_TYPE=? ";
        
        saveSQL = "INSERT INTO ACCS_CORE_SHIPMENT_STATUS ( GRP_OID_NBR," + TableColumnNames + " ) VALUES (?,?,?,?,?)";
        updateSQL = "UPDATE ACCS_CORE_SHIPMENT_STATUS SET ROUTE_NBR = ?, ROUTE_DT = ?, CLASSIFICATION = ?, MAWB = ?, DECLARED_FLG WHERE SHIPMENT_OID = ? ";
        removeSQL = "DELETE FROM ACCS_CORE_SHIPMENT_STATUS WHERE SHIPMENT_OID = ?";
        fetchByPrimaryKeysStmt = null;
        fetchByStatusStmt = null;
        saveStmt = null;
        updateStmt = null;
        removeStmt = null;
    }

    protected void finalize()
    {
        try
        {
            fetchByPrimaryKeysStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            fetchByStatusStmt.close();
        }
        catch(Exception exception) { }
        try
        {
            saveStmt.close();
        }
        catch(Exception exception2) { }
        try
        {
            updateStmt.close();
        }
        catch(Exception exception3) { }
        try
        {
            removeStmt.close();
        }
        catch(Exception exception4) { }
    }

    private DbShipmentStatus(Connection connection)
        throws SQLException
    {
        TableColumnNames = "GRP_OID_NBR, STATUS_TYPE_CD, STATUS_CD ";
        fetchByPrimaryKeysSQL = "SELECT " + TableColumnNames + "FROM ACCS_CORE_SHP_STATUS WHERE GRP_OID_NBR =? AND OID_TYPE_CD ='S'";
        fetchByStatusSQL = "SELECT " + TableColumnNames + "FROM ACCS_CORE_SHP_STATUS WHERE GRP_OID_NBR =? AND OID_TYPE_CD ='S' AND STATUS_TYPE=? ";
            
        saveSQL = "INSERT INTO ACCS_CORE_SHIPMENT_STATUS ( GRP_OID_NBR," + TableColumnNames + " ) VALUES (?,?,?,?,?)";
        updateSQL = "UPDATE ACCS_CORE_SHIPMENT_STATUS SET ROUTE_NBR = ?, ROUTE_DT = ?, CLASSIFICATION = ?, MAWB = ?, DECLARED_FLG WHERE SHIPMENT_OID = ? ";
        removeSQL = "DELETE FROM ACCS_CORE_SHIPMENT_STATUS WHERE GRP_OID_NBR = ?";
        fetchByPrimaryKeysStmt = null;
        fetchByStatusStmt = null;
        saveStmt = null;
        updateStmt = null;
        removeStmt = null;
        try
        {
            fetchByPrimaryKeysStmt = connection.prepareStatement(fetchByPrimaryKeysSQL);
            fetchByStatusStmt = connection.prepareStatement(fetchByStatusSQL);
            saveStmt = connection.prepareStatement(saveSQL);
            updateStmt = connection.prepareStatement(updateSQL);
            removeStmt = connection.prepareStatement(removeSQL);
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

    public ShipmentStatus fetch(int shipmentOid, Connection connection)
        throws SQLException
    {
        try
        {
            if(fetchByPrimaryKeysStmt != null)
                fetchByPrimaryKeysStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.fetch() - unable to close statement");
        }
        try
        {
            fetchByPrimaryKeysStmt = connection.prepareStatement(fetchByPrimaryKeysSQL);
            fetchByPrimaryKeysStmt.setInt(1, shipmentOid);
            runQuery(fetchByPrimaryKeysStmt);
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

    public ShipmentStatus fetchNext()
        throws SQLException
    {
        ShipmentStatus shipmentstatus = new ShipmentStatus();
        try
        {
            if(m_hasMore)
            {
                shipmentstatus.setShipmentOid(m_resultSet.getInt(1));
                shipmentstatus.setStatusTypeCode(m_resultSet.getString(2));
                shipmentstatus.setStatusCode(m_resultSet.getString(3));
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
                shipmentstatus = null;
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
        return shipmentstatus;
    }

    public void save(ShipmentStatus shipmentstatus, Connection connection)
        throws SQLException
    {
        try
        {
            if(saveStmt != null)
                saveStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.save() - unable to close statement");
        }
        try
        {
            saveStmt = connection.prepareStatement(saveSQL);
            saveStmt.setInt(1, (int)shipmentstatus.getShipmentOid());
            saveStmt.setString(2, shipmentstatus.getStatusTypeCode());
            saveStmt.setString(3, shipmentstatus.getStatusCode());
            saveStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbShipment.save(rs)", "Exception thrown: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.save()");
    }

    public void update(ShipmentStatus shipmentstatus, Connection connection)
        throws SQLException
    {
        try
        {
            if(updateStmt != null)
            	updateStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.update() - unable to close statement");
        }
        try
        {
            updateStmt = connection.prepareStatement(updateSQL);
            updateStmt.setString(1, shipmentstatus.getStatusTypeCode());
            updateStmt.setString(2, shipmentstatus.getStatusCode());
            updateStmt.setInt(3, (int)shipmentstatus.getShipmentOid());
            updateStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1300", "DbShipment.update(rs)", "Failure in update for all non-keyed fields in the database: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.update()");
    }

    public void remove(ShipmentStatus shipmentstatus, Connection connection)
        throws SQLException
    {
        try
        {
            if(removeStmt != null)
                removeStmt.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DbShipment.remove() - unable to close statement");
        }
        try
        {
            removeStmt = connection.prepareStatement(removeSQL);
            removeStmt.setInt(1, (int)shipmentstatus.getShipmentOid());
            removeStmt.executeUpdate();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1500", "DbShipment.remove(rs)", "Failed to delete Shipment: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DbShipment.remove()");
    }

    private String TableColumnNames;
    private String fetchByPrimaryKeysSQL;
    private String fetchByStatusSQL;
    private String saveSQL;
    private String updateSQL;
    private String removeSQL;
    private PreparedStatement fetchByPrimaryKeysStmt;
    private PreparedStatement fetchByStatusStmt;
    private PreparedStatement saveStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement removeStmt;
}
