// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataManagerImpl.java

package com.fedex.css.ruleprocessor.datamanager;

import com.fedex.css.ruleprocessor.*;
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
        dbRuleAction = null;
        dbRuleSet = null;
        dbBusActEntry = null;
        dbActionMethod = null;
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
            dbRuleAction = new DbRuleAction();
            dbRuleSet = new DbRuleSet();
            dbBusActEntry = new DbBusinessActionEntry();
            dbActionMethod = new DbActionMethod();
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
            connPoolName = config.getValue("CONNECTION_POOL_NAME");
            webSrvrAddress = config.getValue("WEB_SERVER_ADDRESS");
            schemaName = config.getValue("RULEPROC_SCHEMA");
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

    public RuleAction fetchRuleAction()
        throws RemoteException, SQLException
    {
        return dbRuleAction.fetch(conn);
    }

    public RuleAction fetchRuleAction(int i, String s)
        throws RemoteException, SQLException
    {
        return dbRuleAction.fetch(i, s, conn);
    }

    public RuleAction fetchRuleAction(String s, int i, int j)
        throws RemoteException, SQLException
    {
        return dbRuleAction.fetch(s, i, j, conn);
    }

    public RuleAction fetchNextRuleAction()
        throws RemoteException, SQLException
    {
        return dbRuleAction.fetchNext();
    }

    public void saveRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException
    {
        dbRuleAction.save(ruleaction, conn);
    }

    public void updateRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException
    {
        dbRuleAction.update(ruleaction, conn);
    }

    public void removeRuleAction(RuleAction ruleaction)
        throws RemoteException, SQLException
    {
        dbRuleAction.remove(ruleaction, conn);
    }

    public RuleSet fetchRuleSet()
        throws RemoteException, SQLException
    {
        return dbRuleSet.fetch(conn);
    }

    public RuleSet fetchRuleSet(String s, int i, int j)
        throws RemoteException, SQLException
    {
        return dbRuleSet.fetch(s, i, j, conn);
    }

    public RuleSet fetchNextRuleSet()
        throws RemoteException, SQLException
    {
        return dbRuleSet.fetchNext();
    }

    public void saveRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException
    {
        dbRuleSet.save(ruleset, conn);
    }

    public void updateRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException
    {
        dbRuleSet.update(ruleset, conn);
    }

    public void removeRuleSet(RuleSet ruleset)
        throws RemoteException, SQLException
    {
        dbRuleSet.remove(ruleset, conn);
    }

    public BusinessActionEntry fetchBusinessActionEntry()
        throws RemoteException, SQLException
    {
        return dbBusActEntry.fetch(conn);
    }

    public BusinessActionEntry fetchNextBusinessActionEntry()
        throws RemoteException, SQLException
    {
        return dbBusActEntry.fetchNext();
    }

    public ActionMethod fetchActionMethod(int i)
        throws RemoteException, SQLException
    {
        return dbActionMethod.fetch(conn, i);
    }

    public ActionMethod fetchActionMethod()
        throws RemoteException, SQLException
    {
        return dbActionMethod.fetch(conn);
    }

    public ActionMethod fetchNextActionMethod()
        throws RemoteException, SQLException
    {
        return dbActionMethod.fetchNext();
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
    private DbRuleAction dbRuleAction;
    private DbRuleSet dbRuleSet;
    private DbBusinessActionEntry dbBusActEntry;
    private DbActionMethod dbActionMethod;
    private Trace trace;
}
