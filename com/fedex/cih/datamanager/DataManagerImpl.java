/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;


import com.fedex.cih.vo.*;
import com.fedex.css.util.Trace;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.Hashtable;
import java.util.TimeZone;
import javax.naming.*;
import javax.sql.DataSource;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DbRuleAction, DbRuleSet, DbBusinessActionEntry, DbActionMethod, 
//            DataManagerInterface

public class DataManagerImpl
    implements DataManagerInterface
{

    public DataManagerImpl()
        throws Exception
    {
        webSrvrAddress = "";
        schemaName = "";
        config = null;
        conn = null;
        connPoolName = "";
        dbShipment = null;
        dbDeliveryAddress = null;
        dbShipmentStatus = null;
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        initialize();
    }

    protected void finalize()
    {
        try
        {
            if(conn != null)
                conn.close();
        }
        catch(Exception exception)
        {
            trace.trace(8, "DataManagerImpl.finalize() Couldn't colse connection\n " + exception);
            exception.printStackTrace();
        }
    }

    protected void initialize()
        throws Exception
    {
        trace = new Trace();
        try
        {
            connect();
            dbShipment = new DbShipment();
            dbDeliveryAddress = new DbDeliveryAddress();
            dbShipmentStatus = new DbShipmentStatus();
        }
        catch(Exception exception)
        {
            trace.trace(2, "1100", "DataManagerImpl.initialize()", "Unable to initialize Rule Processor DataManager ComponentsException: " + exception);
            throw exception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.initialize()");
    }

    protected void connect()
        throws Exception, NamingException
    {
        try
        {
            readConfigFile();
            InitialContext initialcontext = getInitialContext();
            connectionPool = (DataSource)initialcontext.lookup(connPoolName);
            conn = connectionPool.getConnection();
            if(schemaName != null)
                setSchemaName(schemaName);
        }
        catch(NamingException namingexception)
        {
            namingexception.printStackTrace();
            trace.trace(2, "1100", "DataManagerImpl.connect()", "Couldn't obtain JDBC connection pool: " + connPoolName + "Exception: " + namingexception);
            throw namingexception;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            trace.trace(2, "1100", "DataManagerImpl.connect()", "Connection failed " + exception);
            throw exception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.connected()");
    }

    protected InitialContext getInitialContext()
        throws Exception
    {
        try {
	    	Hashtable hashtable;
	        hashtable = new Hashtable();
	        hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
	        hashtable.put("java.naming.provider.url", "t3://" + webSrvrAddress);
	        InitialContext initialcontext = new InitialContext(hashtable);
	        return initialcontext;
        } catch(Exception exception) {
	        System.out.println(exception);
	        return null;
        }
    }

    protected void readConfigFile()
        throws Exception
    {
        try
        {
            config = new Config();
            connPoolName = "jdbc.ccii";//config.getValue("CONNECTION_POOL_NAME");
            webSrvrAddress = config.getValue("WEB_SERVER_ADDRESS");
            schemaName = "EXPACCS";//config.getValue("ACCS_SCHEMA");
            if(connPoolName == null)
                trace.trace(2, "CONNECTION_POOL_NAME config item not set");
            if(webSrvrAddress == null)
                trace.trace(2, "WEB_SERVER_ADDRESS config item not set");
            if(schemaName == null)
                trace.trace(2, "RULEPROC_SCHEMA config item not set");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            trace.trace(2, "1150", "DataManagerImpl.readConfigFile()", "Failed to get values for connection " + exception);
            throw exception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.readConfigFile()");
    }

    public void closeConnection()
        throws RemoteException, Exception
    {
        try
        {
            if(!conn.isClosed())
                conn.close();
        }
        catch(SQLException sqlexception)
        {
            sqlexception.printStackTrace();
            trace.trace(4, "1400", "DataManagerImpl.closeConnection()", "Close connection failed: " + sqlexception);
            throw sqlexception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.closeConnection()");
    }

    public boolean commitTransaction()
        throws RemoteException, Exception
    {
        boolean flag = false;
        try
        {
            conn.commit();
            flag = true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            trace.trace(4, "1400", "DataManagerImpl.commitTransaction()", "Commit transaction failed: " + exception);
            throw exception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.commitTransaction()");
        return flag;
    }

    public boolean rollbackTransaction()
        throws RemoteException, Exception
    {
        boolean flag = false;
        try
        {
            conn.rollback();
            flag = true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            trace.trace(4, "1400", "DataManagerImpl.rollbackTransaction()", "Rollback transaction failed: " + exception);
            throw exception;
        }
        trace.trace(16, "SUCCESS  DataManagerImpl.rollbackTransaction()");
        return flag;
    }

    public ShipmentInfo fetchShipment(int shipment_oid)
        throws RemoteException, SQLException
    {
        return dbShipment.fetch(shipment_oid,conn);
    }

    public ShipmentInfo fetchNextShipment()
    throws RemoteException, SQLException
	{
	    return dbShipment.fetchNext();
	}
	
	public void saveShipment(ShipmentInfo ruleaction)
	    throws RemoteException, SQLException
	{
		dbShipment.save(ruleaction, conn);
	}
	
	public void updateShipment(ShipmentInfo ruleaction)
	    throws RemoteException, SQLException
	{
		dbShipment.update(ruleaction, conn);
	}
	
	public void removeShipment(ShipmentInfo ruleaction)
	    throws RemoteException, SQLException
	{
		dbShipment.remove(ruleaction, conn);
	}
	

	public DeliveryAddressInfo fetchDeliveryAddress(int i)
        throws RemoteException, SQLException
    {
        return dbDeliveryAddress.fetch(i, conn);
    }

    public DeliveryAddressInfo fetchNextDeliveryAddress()
        throws RemoteException, SQLException
    {
        return dbDeliveryAddress.fetchNext();
    }

    public void saveDeliveryAddress(DeliveryAddressInfo ruleaction)
        throws RemoteException, SQLException
    {
    	dbDeliveryAddress.save(ruleaction, conn);
    }

    public void updateDeliveryAddress(DeliveryAddressInfo ruleaction)
        throws RemoteException, SQLException
    {
    	dbDeliveryAddress.update(ruleaction, conn);
    }

    public void removeDeliveryAddress(DeliveryAddressInfo ruleaction)
        throws RemoteException, SQLException
    {
    	dbDeliveryAddress.remove(ruleaction, conn);
    }

    public ShipmentStatus fetchShipmentStatus(int shipmentOid, String statusTypeCode)
        throws RemoteException, SQLException
    {
        return dbShipmentStatus.fetch(shipmentOid, conn);
    }

    public ShipmentStatus fetchNextShipmentStatus()
        throws RemoteException, SQLException
    {
        return dbShipmentStatus.fetchNext();
    }

    public void saveShipmentStatus(ShipmentStatus ruleset)
        throws RemoteException, SQLException
    {
        dbShipmentStatus.save(ruleset, conn);
    }

    public void updateShipmentStatus(ShipmentStatus ruleset)
        throws RemoteException, SQLException
    {
        dbShipmentStatus.update(ruleset, conn);
    }

    public void removeRuleSet(ShipmentStatus ruleset)
        throws RemoteException, SQLException
    {
        dbShipmentStatus.remove(ruleset, conn);
    }


    protected void setSchemaName(String s)
    {
        try
        {
            String s1 = "ALTER SESSION SET CURRENT_SCHEMA = " + s;
            Statement statement = conn.createStatement();
            statement.execute(s1);
        }
        catch(Exception exception)
        {
            trace.trace(2, "UNABLE TO SET THE SCHEMA NAME: " + exception);
            exception.printStackTrace();
        }
    }

    private String webSrvrAddress;
    private String schemaName;
    private Config config;
    public Connection conn;
    private String connPoolName;
    private DataSource connectionPool;
    private DbShipment dbShipment;
    private DbDeliveryAddress dbDeliveryAddress;
    private DbShipmentStatus dbShipmentStatus;
    
    private Trace trace;
}
