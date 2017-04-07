package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import cciij.businessActions.Messages;
//import cciij.Security.CCIISecurityHome;
import cciij.Security.CCIISecurity;
import cciij.WSUtil.EjbProcessing;

public class UserAttributes implements java.io.Serializable, javax.servlet.http.HttpSessionBindingListener
{
  private static final String m_whatVersion = "@(#) $RCSfile: UserAttributes.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  private String m_userName = "";
  private String m_orgCode = "";
  private Vector m_acl = new Vector();
  private int m_language = 1;
  private int m_errorCode = Messages.EM_INVALID_LOGON;
  private boolean m_changingPassword = false;
  private boolean m_testingAccess = false;
  private boolean m_autoLogoff = false;
  private String m_locationCd = "";
  private Vector m_agencies;

  public UserAttributes()
  {
    m_agencies = new Vector();
  }

   public UserAttributes(String userName, String orgCode, int language,
          Vector acl, int errorCode, boolean changingPassword, String site)
  {
    m_agencies = new Vector();
    m_userName = userName;
    m_orgCode = orgCode;
    m_language = language;
    m_errorCode = errorCode;
    m_changingPassword = changingPassword;
    m_locationCd = site;
    m_acl = acl;
     if (CCIIProperties.readConfigVariableBoolean(
        CCIIProperties.CCII_WS_CONNECT_TESTING_NAME,site,
        CCIIProperties.CCII_WS_CONNECT_TESTING_DEFAULT)
       && userName.equals(CCIIProperties.CCII_WS_CONNECT_TESTING_LOGIN))
    {
      m_testingAccess = true;
    }
    setAgencies();
  }

  private void setAgencies()
  {
    if ( m_acl != null )
    {
      Enumeration enum = m_acl.elements();

      while ( enum.hasMoreElements() )
      {
        String tempStr = (String) enum.nextElement();
        if ( tempStr.trim().endsWith("*") )
        {
	  String temp2 = tempStr.substring ( 0, tempStr.length() - 1 );
          m_agencies.add ( temp2 );
        }
      }
    }
  }

  public Vector getAgencies()
  {
    return m_agencies;
  }

  public boolean getAutoLogoff()
  {
    return m_autoLogoff;
  }

  public void setAutoLogoff(boolean autoLogoff)
  {
    m_autoLogoff = autoLogoff;
  }

  public int getLanguage()
  {
    return m_language;
  }
  public String getUserName ()
  {
    return m_userName;
  }

  public String getOrgCode()
  {
    return m_orgCode;
  }

  public Vector getAcl()
  {
    return m_acl;
  }

  public int getErrorCode()
  {
    return m_errorCode;
  }

  public boolean isValidLogin()
  {
    return (m_errorCode == Messages.EM_NO_ERROR);
  }

  public boolean isActive()
  {
    return (!(m_errorCode == Messages.EM_USER_NOT_ACTIVE));
  }

  public boolean isEnabled()
  {
    return (!(m_errorCode == Messages.EM_REVOKED_LOGON));
  }

  public boolean isNoLogonGroup()
  {
    return (m_errorCode == Messages.EM_NO_LOGON_GROUP);
  }

  public boolean isPasswordCorrect()
  {
    return (!(m_errorCode == Messages.EM_INVALID_LOGON));
  }

  public boolean isExpired()
  {
    return (m_errorCode == Messages.EM_EXPIRED_LOGON);
  }

  public boolean doNewPasswordsMatch()
  {
    return (!(m_errorCode == Messages.EM_PASSWD_DONT_MATCH));
  }
  public boolean isPasswordChangeNotAllowed()
  {
    return (m_errorCode == Messages.EM_PW_CHG_NOT_ALLOW);
  }
  public boolean isNewPasswordNotLongEnough()
  {
    return (m_errorCode == Messages.EM_PW_LENGTH_ERROR);
  }
  public boolean doesNewPasswordContainInvalidChars()
  {
    return (m_errorCode == Messages.EM_INVALID_CHARS );
  }

  public boolean hasPrivledge(String access)
  {
    boolean retValue = false;
    if (access != null)
    {
      if (access == CCIIProperties.ACCESS_CONTROL_ALL_ACCESS || m_testingAccess)
         retValue = true;
      else
        retValue = m_acl.contains(access);
    }
    return retValue;
  }

  /*public CCIISecurityHome getSecurityHome()
  {
    return m_securityHome;
  }

  public void setSecurityHome(CCIISecurityHome home)
  {
    m_securityHome = home;
  }
*/
  public void valueBound(javax.servlet.http.HttpSessionBindingEvent hsbe)
  {
    //System.out.println("Value Bound");
  }
  public void valueUnbound(javax.servlet.http.HttpSessionBindingEvent hsbe)
  {
    //System.out.println("Value Unbound");
    callAutoLogoff();
  }
  protected void callAutoLogoff()
  {
    if (m_autoLogoff && CCIIProperties.readConfigVariableBoolean(
                     "WORKSTATION_AUTOLOGOFF",m_locationCd,true))
    {
      EjbProcessing ejbProcess = new EjbProcessing();
      CCIISecurity security = ejbProcess.getSecurity(m_locationCd);
      //System.out.println("AutoLogout for: " +getUserName());
      if (security != null)
      {
        try
        {
          security.autoLogout(getUserName(),m_locationCd);
        }
        catch (java.rmi.RemoteException re)
        {
          WSNotify notify = new WSNotify();
          notify.wsNotifyLog("Remote Exception while trying to autologoff",re);
        }
        ejbProcess.cleanupSecurity(security);
      }
    }
  }

  public String toString()
  {
    String s = "UserAttributes\n";
    s+= "User Name" +  m_userName + "\n";
    s+= "orgCode" +  m_orgCode + "\n";
    s+= "acl \n";
    if (m_acl != null)
    {
      for (Iterator it = m_acl.iterator(); it.hasNext(); )
      {
        s+= (String)it.next() + ",";
      }
    }
    s+= "'\n";
    s+= "language" + m_language + "\n";
    s+= "errorCode" +  m_errorCode + "\n";
    s+= "changingPassword" +  m_changingPassword + "\n";
    s+= "testingAccess" +  m_testingAccess + "\n";
    s+= "autoLogoff" +  m_autoLogoff + "\n";
    s+= "locationCd" +  m_locationCd + "\n";
    s+= "agencies : [";
    /******************
    if (m_agencies != null)
    {
      for (Iterator it = m_agencies.iterator(); it.hasNext(); )
      {
        s+= (String)it.next() + ",";
      }
    }
    *********************/
      Enumeration enum = m_agencies.elements();

      while ( enum.hasMoreElements() )
      {
        s+= (String)enum.nextElement() + ",";
      }
    s+= "]\n";
    return s;
  }

  public static void main(String[] args)
  {
    UserAttributes userProperties1 = new UserAttributes();
  }
}
