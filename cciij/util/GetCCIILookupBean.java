package cciij.util;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */
import cciij.cciilookup.*;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public class GetCCIILookupBean extends GetRemoteEjbBase implements java.io.Serializable
{

  public GetCCIILookupBean()
  {
  }

  protected void localInit()
  {
    //override this method in child classes and use to initialize variables
    m_jndi_lookup_string = "JNDI_LOOKUP_CCII_LOOKUP";
    m_jndi_lookup_string_default = "ccii_cciilookup";
    m_useJNDIdefault = false;
    m_initial_context_factory = CCII_INITIAL_CONTEXT_FACTORY_DEFAULT;
    m_genericEJBClass = LookupHome.class;
    m_webserver_address_key = "WEB_SERVER_ADDRESS";
  }

  protected EJBObject callCreate() throws javax.ejb.CreateException, java.rmi.RemoteException
  {
    return ((LookupHome)m_genericHome).create();
  }

  public synchronized final Lookup getLookup(String site) throws NamingException,CreateException,RemoteException
  {
    return (Lookup)getEJBObject(site);
  }

  public final void cleanupCCIILookup(Lookup lookup)
  {
    try
    {
        if (lookup != null)
            lookup.remove();
    }
    catch (javax.ejb.RemoveException re)
    {
      //no big deal if this fails
      String str = "GetCCIILookupBean: Problem cleaning up lookup ejb";
      System.out.println(str);
    }
    catch (java.rmi.RemoteException re)
    {
      //no big deal if this fails
      String str = "GetCCIILookupBean:Problem cleaning up lookup ejb";
      System.out.println(str);
    }
  }
}