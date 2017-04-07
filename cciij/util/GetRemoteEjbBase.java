package cciij.util;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 *          1.1 Lorraine Dominguez -- Changed static variables to non-static
 */

 import rmtc.util.Config;
 import javax.ejb.*;
 import java.rmi.*;
 import javax.rmi.*;
 import java.util.Hashtable;
 import javax.naming.*;

public abstract class GetRemoteEjbBase implements java.io.Serializable
{
  protected static Config m_config = new Config();
  protected String m_jndi_lookup_string = "";
  protected String m_jndi_lookup_string_default = "";
  protected boolean m_useJNDIdefault = false;
  protected String m_jndi_name = "";
  protected String m_t3address = "";
  protected final static String CCII_INITIAL_CONTEXT_FACTORY_DEFAULT = "weblogic.jndi.WLInitialContextFactory";
  protected String m_initial_context_factory = CCII_INITIAL_CONTEXT_FACTORY_DEFAULT;
  protected EJBHome m_genericHome;
  protected Class m_genericEJBClass;
  protected String m_webserver_address_key = "";

  public GetRemoteEjbBase()
  {
    localInit();
  }

  protected void localInit()
  {
    //override this method in child classes and use to initialize variables
  }

  protected synchronized final void initEJBHome(String site) throws NamingException
  {
    String local_jndi_name = "";
    if (m_useJNDIdefault)
    {
      local_jndi_name = readConfigVariableString(
           m_jndi_lookup_string,site,m_jndi_lookup_string_default);
    } else
    {
      local_jndi_name = readConfigVariableString(m_jndi_lookup_string,site);
    }

    String localT3Address = getT3WebAddress(site);
    if (m_genericHome == null
        || !m_jndi_name.equals(local_jndi_name)
        || !m_t3address.equals(localT3Address))
    {
        m_jndi_name = local_jndi_name;
        m_t3address = localT3Address;
        Hashtable env = new Hashtable();
        env.put (Context.INITIAL_CONTEXT_FACTORY, m_initial_context_factory);
        env.put(Context.PROVIDER_URL,m_t3address );
        try
        {
            InitialContext ctx = new InitialContext(env);
            Object objref = ctx.lookup(m_jndi_name);
            m_genericHome = (EJBHome) PortableRemoteObject.narrow(objref,m_genericEJBClass);
        }
        catch (NamingException ne)
        {
            System.out.println("GetRemoteEjbBase: Naming Exception: could not connect to lookup home" + ne);
            throw ne;
        }
    }
  }

  protected abstract EJBObject callCreate() throws javax.ejb.CreateException, java.rmi.RemoteException;

  public synchronized final EJBObject getEJBObject(String site) throws NamingException,CreateException,RemoteException
    {
        //init only executes needed code
        initEJBHome(site);
        EJBObject ejbObject = null;
        try
        {
            if (m_genericHome == null)
            {
                System.out.println("GetRemoteEjbBase: ejb home was null");
                initEJBHome(site);
            }
            if (m_genericHome != null)
            {
                ejbObject = callCreate();
            }
            else
            {
                System.out.println("GetRemoteEjbBase: ejb home still null");
            }
        }
        catch (javax.ejb.CreateException ce)
        {
            String str = "GetRemoteEjbBase: Creation Exception: could not create lookup";
            System.out.println(str);
            throw ce;
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "GetRemoteEjbBase: Remote Exception: could not create lookup";
            System.out.println(str);
            throw re;
        }
        return ejbObject;
    }


  public String getT3WebAddress(String site)
  {
    return "t3://" + readConfigVariableString(m_webserver_address_key,site);//"WEB_SERVER_ADDRESS",site);
  }

  public String readConfigVariableString(String key, String locationCd)
  {
    //basic read, most other readConfig methods call this one

    //m_notify.initSite(locationCd);
    String tempString = null;
    if (m_config == null)
    {
      m_config = new Config();
    }
    if (key == null)
    {
       //m_notify.traceLog("config name is null");
       //addLogMessageReadConfigFailed(key, ERROR, locationCd);
    }
    else
    {
      m_config.setLocationCode(locationCd);
      tempString =  m_config.getValue(key);
      if ( tempString == null )
      {
        //m_notify.traceLog(key + " value is null in config file");
        //addLogMessageReadConfigFailed(key, ERROR,locationCd);
      }
    }
    return tempString;
  }

  public String readConfigVariableString(String key, String locationCd, String defaultValue)
  {
    String tempString = null;
    tempString = readConfigVariableString(key,locationCd);
    if (tempString == null)
    {
       tempString = defaultValue;
       //addLogMessageReadConfigUseDefault(key,defaultValue, ERROR,locationCd);
    }
    return tempString;
  }
}