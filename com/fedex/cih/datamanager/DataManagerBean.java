/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;


import java.io.PrintStream;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.DataSource;

// Referenced classes of package com.fedex.css.ruleprocessor.datamanager:
//            DataManagerImpl

public class DataManagerBean extends DataManagerImpl
    implements SessionBean
{

    public DataManagerBean()
        throws Exception
    {
        sessionContext = null;
    }

    public void ejbActivate()
        throws RemoteException
    {
    }

    public void ejbCreate()
        throws CreateException, RemoteException, NamingException, SQLException
    {
        Object obj = null;
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        hashtable.put("java.naming.provider.url", "t3://localhost:7001");
        String s = "DataManagerBean";
        try
        {
            InitialContext initialcontext = new InitialContext(hashtable);
            DataSource datasource = (DataSource)initialcontext.lookup(s);
            try
            {
                conn = datasource.getConnection();
            }
            catch(SQLException sqlexception)
            {
                sqlexception.printStackTrace();
                System.out.println("DataManagerBean.ejbCreate()--Error connecting to Database: " + sqlexception);
                throw sqlexception;
            }
        }
        catch(NamingException namingexception)
        {
            namingexception.printStackTrace();
            System.out.println("Naming exception getting Initial context or doing lookup on " + namingexception);
            throw namingexception;
        }
    }

    public void ejbPassivate()
        throws RemoteException
    {
    }

    public void ejbRemove()
        throws RemoteException
    {
        try
        {
            conn.close();
        }
        catch(SQLException sqlexception)
        {
            RemoteException remoteexception = new RemoteException(sqlexception.getMessage());
            remoteexception.printStackTrace();
            throw remoteexception;
        }
    }

    public void setSessionContext(SessionContext sessioncontext)
        throws RemoteException
    {
        sessionContext = sessioncontext;
    }

    private SessionContext sessionContext;
}
