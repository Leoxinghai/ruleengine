package cciij.util;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author       Lorraine Dominguez
 * @version 1.0
 */
import cciij.cciilookup.*;
import javax.ejb.*;
import com.fedex.cih.ejb.CCIILookupHome;
import com.fedex.cih.ejb.CCIILookup;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.NamingException;

public class GetAPACLookupBean extends GetRemoteEjbBase implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: GetAPACLookupBean.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";

  public GetAPACLookupBean()
  {
  }

  protected void localInit()
  {
    //override this method in child classes and use to initialize variables
    m_jndi_lookup_string = "JNDI_LOOKUP_APAC_LOOKUP";
    m_jndi_lookup_string_default = "";
    m_useJNDIdefault = false;
    m_initial_context_factory = CCII_INITIAL_CONTEXT_FACTORY_DEFAULT;
    m_genericEJBClass = CCIILookupHome.class;
    m_webserver_address_key = "WEB_SERVER_APAC_LOOKUP";
  }

  protected EJBObject callCreate() throws javax.ejb.CreateException, java.rmi.RemoteException
  {
    return ((CCIILookupHome)m_genericHome).create();
  }

  public synchronized final CCIILookup getLookup(String site) throws NamingException,CreateException,RemoteException
  {
    return (CCIILookup)getEJBObject(site);
  }

  public final void cleanupAPACLookup(CCIILookup lookup)
  {
      try
      {
          if (lookup != null)
              lookup.remove();
      }
      catch (javax.ejb.RemoveException re)
      {//if this fails its no big deal
          String str = "GetAPACLookupBean: Problem cleaning up lookup ejb";
          System.out.println(str);
      }
      catch (java.rmi.RemoteException re)
      {//if this fails its no big deal
          String str = "GetAPACLookupBean: Problem cleaning up lookup ejb";
          System.out.println(str);
      }
  }
}
