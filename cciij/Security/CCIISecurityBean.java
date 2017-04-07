package cciij.Security;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that
 *               will be required to implement the CCII interface on a browser
 *               on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 *
 * * Modification history:
 * 05/06/2002     Steve Hurd  added a JoltRemoteService.done() command to fix memory leak.
 * 07/27/2004     Ed McAleer  Change login to use SIP instead of Jolt and Tux security service.
 * 12/02/2004     Joey Cline  Modified to use StringTokenizer to ensure that the last element is used.
 *
 */

import java.rmi.*;
import javax.ejb.*;
import java.util.*;
import cciij.businessActions.Messages;
import cciij.WSUtil.CCIIProperties;
import cciij.WSUtil.UserAttributes;
import cciij.WSUtil.WSNotify;
import cciij.util.CCIILogException;
import cciij.util.sip.JSIPConverter;
import cciij.util.Notify;

public class CCIISecurityBean
    implements javax.ejb.SessionBean
{
  private static final String m_whatVersion =
      "@(#) $RCSfile: CCIISecurityBean.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";

  protected String m_currentAddress = "";

  private final static String ACCESS_LIST_DEMILITER = ",";
  protected String m_actionName = "CCIISecurityBean";
  protected WSNotify m_notify = new WSNotify();
  protected Notify notify = new Notify();
  protected long m_resetSystemTime = System.currentTimeMillis();
  protected Date m_resetSystemDate = new Date(m_resetSystemTime);
  protected long m_resetTime = 0;
  protected Date m_resetDate = new Date(m_resetTime);

  protected static String SECURITY_ERROR_LOGIN_NULL = "309901";
  protected static String SECURITY_ERROR_LOGIN_NO_ELEMENT = "309902";
  protected static String SECURITY_ERROR_JOLT_SETUP = "309903";
  protected static String SECURITY_ERROR_JOLT_APP = "309904";
  protected static String SECURITY_ERROR_LOGOUT = "109905";
  protected static String SECURITY_APPLICATION_NAME = "accs";
  protected long iTime = System.currentTimeMillis();

  /**
   * CCIISecurityBean
   */
  public CCIISecurityBean()
  {
    localInit();
  }

  /**
   * login
   *
   * <p>USE:  Use this method to login users into the application without changing
   *          the password and to receive a UseAttributes object in return.</p>
   *
   * @param userName String
   * @param password String
   * @param language int
   * @param site String
   * @throws RemoteException
   * @return UserAttributes
   */
  public UserAttributes login(String userName, String password,
                              int language, String site) throws RemoteException
  {
    return login(userName, password, language, false, null, null, site);
  }

  /**
   * login
   *
   * <p>USE:  Call this method to log a user into the application, allow the user
   *      to change his/her password and receive a UserAttribute object in return.</p>
   *
   * @param userName String
   * @param password String
   * @param language int
   * @param changePass boolean
   * @param newPass String
   * @param confimPass String
   * @param site String
   * @throws RemoteException
   * @return UserAttributes
   */
  public UserAttributes login(String userName, String password,
                              int language, boolean changePass, String newPass,
                              String confimPass, String site) throws
      RemoteException
  {
    System.out.println("login");
    if (m_resetTime < m_resetSystemTime)
    {
      reset();
    }
    m_notify.initSite(site);
    UserAttributes user = null;
    int errorCode = Messages.EM_NO_ERROR;
    String orgCode = CCIIProperties.CCII_WS_CONNECT_TESTING_ORGCODE;
    Vector acl = new Vector();

    //Check for supported languages.
    if (language < 1 || language > CCIIProperties.NUM_LANG_SUPPORTED)
    {
      language = CCIIProperties.getDefaultSiteLanguage(site);
      System.out.println("login 2");
    }

    //Read config items and check for invalid login conditions.
    if (CCIIProperties.readConfigVariableBoolean(
        CCIIProperties.CCII_WS_CONNECT_TESTING_NAME, site,
        CCIIProperties.CCII_WS_CONNECT_TESTING_DEFAULT)
        && userName.equals(CCIIProperties.CCII_WS_CONNECT_TESTING_LOGIN)
        && password.equals(CCIIProperties.CCII_WS_CONNECT_TESTING_PASSWORD))
    {
      System.out.println("login 3");
      errorCode = Messages.EM_NO_ERROR;
      orgCode = CCIIProperties.CCII_WS_CONNECT_TESTING_ORGCODE;
      changePass = false;
    }
    else if (userName == null)
    {
      errorCode = Messages.EM_INVALID_LOGON;
    }
    else if (password == null)
    {
      errorCode = Messages.EM_INVALID_LOGON;
    }
    else if (changePass && (newPass == null || confimPass == null))
    {
      errorCode = Messages.EM_PW_LENGTH_ERROR;
    }
    else if (changePass && !newPass.equals(confimPass))
    {
      errorCode = Messages.EM_PASSWD_DONT_MATCH;
    }
    else // valid login information so attempt to log user into application.
    {
      System.out.println("login 4");
      Vector result = login(userName, password, changePass, confimPass, site);
      System.out.println("login 5");
      m_notify.traceLog("Got result Vector");

      //Check result set and log error.
      if (result == null)
      {
        m_notify.traceLog("Login Result is null");
        String str = "Login Result is null";
        System.out.println(str);
        CCIILogException ex = new CCIILogException(SECURITY_ERROR_LOGIN_NULL,
            str);
        m_notify.wsNotifyLog(SECURITY_ERROR_LOGIN_NULL, str, ex, this);
        throw new RemoteException(str, ex);
      }

      //Retrieve Login data from result vector.
      Iterator it = result.iterator();
      try
      {
        errorCode = ( (Integer) it.next()).intValue();
        userName = (String) it.next();
        orgCode = (String) it.next();
        acl = (Vector) it.next();
        m_notify.traceLog("Got all elements out of result vector");
      }
      catch (NoSuchElementException nsee)
      {
        String str = "No Such Element when trying to parse login results";
        m_notify.wsNotifyLog(SECURITY_ERROR_LOGIN_NO_ELEMENT, str, nsee, this);
        //m_notify.wsNotifyLog(nsee);
        throw new RemoteException(str, nsee);
      }

      //Check ACL out put contents.
      if (acl != null)
      {
        System.out.print("ACL : '");
        for (Iterator it2 = acl.iterator(); it2.hasNext(); )
        {
          System.out.print( (String) it2.next() + ",");
        }
        //m_notify.traceLog("'");
      }
      else
      {
        //m_notify.traceLog("acl is null");
      }

    }
    //m_notify.traceLog("About to create user");
    user = new UserAttributes(userName, orgCode, language, acl, errorCode,
                              changePass, site);
    //m_notify.traceLog("About to return");
    return user;
  }

  /**
   * login
   *
   * <p>USE:  Call this method to log a user into the application, do not change the
   *      password, and obtain a vector object in return. </p>
   *
   * @param userName String
   * @param password String
   * @param site String
   * @throws RemoteException
   * @return Vector
   */
  public Vector login(String userName, String password, String site) throws
      RemoteException
  {
    return this.login(userName, password, false, null, site);
  }

  /**
   * login
   *
   * <p>USE: Log user into the application with only the userName, password and
   *      receive a vector object in return</p>
   *
   * @param userName String
   * @param password String
   * @throws RemoteException
   * @return Vector
   */
  public Vector login(String userName, String password) throws RemoteException
  {
    return this.login(userName, password, false, null, "ALL");
  }

  /**
   * login
   *
   * This method will attempt to either log the user into the application or
   * change the user's application password. The changePass attribute will determine
   * if a normal login or change password is performed.
   *
   * <p.USE:  Call this method to log a user into the application, allow him/her
   *          to change passwords, and receive a vector object in return.</p>
   *
   * @param userName String - application login user name
   * @param password String - application login password
   * @param changePass boolean - "true" change password, "false" normal login
   * @param newPass String - New password
   * @param site String - site or location code.
   * @throws RemoteException
   * @return Vector
   */
  public Vector login(String userName, String passWord,
                      boolean changePass, String newPass, String site) throws
      RemoteException
  {
    //System.out.println("login 10");
    if (m_resetTime < m_resetSystemTime)
    {
      reset();
    }
    m_notify.initSite(site);
    Vector returnVector = new Vector();
    int errorNumber;
    String accessString = "";
    Vector accessList = new Vector();
    String accessEntry = null;
    String orgCode = "";
    String newPassword = "";
    int delimiterLocation;
    //String dutyCode;
    int auditCode = 1; //logon request

    //Check for change password and modify auditCode for password change.
    if (changePass)
    {
      auditCode = 4; //logon and change password
      newPassword = newPass;
    }

    init(site);

    // +++++++++++++++++++++++++++++++++++++++++++
    // SIP login
    // Log user into application using SIP security
    // +++++++++++++++++++++++++++++++++++++++++++

    JSIPConverter jsipConverter = new JSIPConverter();

    // Determine if change password or normal login.
    if (newPassword.equals(""))
    {
      jsipConverter.logon(userName, passWord, SECURITY_APPLICATION_NAME, site);

      // Check for error during login.
      if (jsipConverter.getErrorNumber() == 0)
      {
        System.out.println("CCIISecurityBean::login - jsipConverter errorNumber = 0");
        accessString = jsipConverter.getAccessList();
        System.out.println("ACL = \n" + accessString);

        orgCode = jsipConverter.getOrgCode();
        orgCode = orgCode.trim();
      }
      else // Error encountered during login
      {
        System.out.println("CCIISecurityBean::login - jsipConverter errorNumber = " + jsipConverter.getErrorNumber());
        logError(notify.errorLevelError, Messages.EM_INVALID_LOGON,
                 "Error during login - ERROR # is: "
                 + jsipConverter.getErrorNumber()
                 + " for user: "
                 + userName
                 + " for location: "
                 + site);
      }
    }
    else // Password change
    {
      jsipConverter.changePassword(userName, SECURITY_APPLICATION_NAME,
                                   passWord, newPassword, site);
      if (jsipConverter.getErrorNumber() == 0)
      {
        System.out.println("Password changed for user: " + userName);
      }
      else // Error encountered during change password.
      {
        logError(notify.errorLevelError, Messages.EM_CHANGE_PW,
                 +jsipConverter.getErrorNumber()
                 + " for user: "
                 + userName
                 + " for location: "
                 + site);
      }
    }

    System.out.println("login 11");

    m_notify.traceLog("Access String: '" + accessString + "'");
    m_notify.traceLog("Error Number: " + jsipConverter.getErrorNumber());
    m_notify.traceLog("userName: '" + userName + "'");
    m_notify.traceLog("orgCode: '" + orgCode + "'");
    m_notify.traceLog("Access list: " + accessString);

    /**************************************************************
    //Convert access string into vector.
    while (accessString.length() > 0)
    {
      delimiterLocation = accessString.indexOf(ACCESS_LIST_DEMILITER);
      if (delimiterLocation == -1)
      {
        if (accessString.length() > 1)
        {
          accessEntry = accessString;
        }

        accessString = "";
      }
      else
      {
        accessEntry = accessString.substring(0, delimiterLocation).trim();
        accessString = accessString.substring(delimiterLocation + 1);
        accessList.add(accessEntry);
      }
    }

    *******************************************************************/

    StringTokenizer stok = new StringTokenizer ( accessString, ACCESS_LIST_DEMILITER );

    while ( stok.hasMoreTokens() )
    {
	String temp = stok.nextToken();
	accessList.add(temp);
    }

    System.out.println("CCIISecurityBean::login - populating the return vector");
    // Populate returnVector
    returnVector.add(new Integer(jsipConverter.getErrorNumber()));
    returnVector.add(userName);
    returnVector.add(orgCode);
    returnVector.add(accessList);
//    returnVector.add(new Integer(jsipConverter.getErrorNumber()));

    System.out.println("login 22");

    System.out.println("CCIISecurityBean::login - return vector contains");

    Enumeration e = returnVector.elements();

    while (e.hasMoreElements())
    {
      System.out.println("CCIISecurityBean::login - return vector element = " + e.nextElement());
    }
    return returnVector;
  }

  /**
   * login
   *
   * This method will attempt to either log the user into the application or
   * change the user's application password. The changePass attribute will determine
   * if a normal login or change password is performed.
   *
   * <p> USE: Call this method to log into the applicaiton with a site/locationCd of "ALL".</p>
   *
   * @param userName String
   * @param password String
   * @param changePass boolean
   * @param newPass String
   * @throws RemoteException
   * @return Vector
   */
  public Vector login(String userName, String password,
                      boolean changePass, String newPass) throws
      RemoteException
  {
    return this.login(userName, password, changePass, newPass, "ALL");
  }

  /**
   * logout
   *
   * <p>NOTE:  The SIP security application does not support logout functionality, so
   *           an entry is placed in the log file taht the user was logged out of the
   *           application. The site and time are placed in the log entry. </p>
   *
   * @param userName String
   * @param site String
   * @throws RemoteException
   */
  public void logout(String userName, String site) throws RemoteException
  {

    String infoMsg = "User " + userName + " logged out for location " + site + " at " + iTime;
    logError(notify.errorLevelInfo, Messages.IM_MSG_USER_LOGOUT, infoMsg);
  }

  /**
   * autoLogout
   *
   * <p>NOTE:  The SIP security application does not support logout functionality, so
   *           an entry is placed in the log file taht the user was logged out of the
   *           application. The site and time are placed in the log entry. </p>
   *
   * @param userName String
   * @param site String
   * @throws RemoteException
   */
  public void autoLogout(String userName, String site) throws RemoteException
  {
    String infoMsg = "User " + userName + " auto logged out for location " + site + " at " + iTime;
    logError(notify.errorLevelInfo, Messages.IM_MSG_AUTOLOGOUT, infoMsg);
  }

  /**
   * init
   *
   * <p> This method will read the configuration parameter and load the static class
   *     attributes.</p>
   * @param locationCd String
   */
  protected void init(String locationCd)
  {
    rmtc.util.Config config;
    config = new rmtc.util.Config("ALL");
    m_notify.initSite(locationCd);
    String tempString = config.getValue("SECURITY_ERROR_LOGIN_NULL");

    if (tempString != null)
    {
      SECURITY_ERROR_LOGIN_NULL = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: SECURITY_ERROR_LOGIN_NULL");
    }

    tempString = config.getValue("SECURITY_ERROR_LOGIN_NO_ELEMENT");
    if (tempString != null)
    {
      SECURITY_ERROR_LOGIN_NO_ELEMENT = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: SECURITY_ERROR_LOGIN_NO_ELEMENT");
    }

    tempString = config.getValue("SECURITY_ERROR_JOLT_SETUP");
    if (tempString != null)
    {
      SECURITY_ERROR_JOLT_SETUP = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: SECURITY_ERROR_JOLT_SETUP");
    }

    tempString = config.getValue("SECURITY_ERROR_JOLT_APP");
    if (tempString != null)
    {
      SECURITY_ERROR_JOLT_APP = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: SECURITY_ERROR_JOLT_APP");
    }

    tempString = config.getValue("SECURITY_ERROR_LOGOUT");
    if (tempString != null)
    {
      SECURITY_ERROR_LOGOUT = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: SECURITY_ERROR_LOGOUT");
    }

    tempString = config.getValue("APPLICATION_NAME");
    if (tempString != null)
    {
      SECURITY_APPLICATION_NAME = tempString;
    }
    else
    {
      System.out.println(
          "Security Bean unable to read config item: APPLICATION_NAME");
    }

    m_currentAddress = CCIIProperties.getJoltAddress(locationCd);
    //System.out.println("current Address : " + m_currentAddress);
  }

  public void ejbCreate()
  {}

  public void setSessionContext(SessionContext ctx)
  {}

  public void ejbRemove()
  {}

  public void ejbActivate()
  {}

  public void ejbPassivate()
  {}

  public void ejbLoad()
  {}

  public void ejbStore()
  {}

  protected void localInit()
  {
    m_notify = new WSNotify();
    m_notify.setActionName(m_actionName);
    m_notify.initSite("ALL");
    synchronized (m_resetDate)
    {
      m_resetTime = System.currentTimeMillis();
      m_resetDate = new Date(m_resetTime);
    }
  }

  public void reset() throws RemoteException
  {
    System.out.println("In the Security reset function");
    synchronized (m_resetSystemDate)
    {
      m_resetSystemTime = System.currentTimeMillis();
      m_resetSystemDate = new Date(m_resetSystemTime);
    }
    localInit();
  }

  /**
   * logError<p>
   *
   * Send explicit error messages to this method for logging or
   * display.
   *
   * <P>
   *
   * @param errorLevel int
   * @param errorNumber int
   * @param errorMessage java.lang.String
   */
  private void logError(int errorLevel, int errorNumber, String errorMessage)
  {
    notify.triggerNotify(errorLevel, errorNumber, errorMessage);
  }

  public static void main(String[] args)
  {
    CCIISecurityBean bean = new CCIISecurityBean();
    Vector user;
    boolean chgPwdFlg = false;

    System.out.println("Length = " + args.length);

    for (int x = 0; x < args.length; x++)
    {
      System.out.println("Cmd args[" + x + "] = " + args[x]);
    }

    String usrNm = args[0];
    String pwd = args[1];
    String pwdFlg = args[2];
    String site = args[3];
    String newPwd = "";

    if (args[2].equals("Y"))
    {
      System.out.println("Change Pwd Flg set!");
      newPwd = "aC1aC2aC3";
      chgPwdFlg = true;
    }

    try
    {
      user = bean.login(usrNm, pwd, chgPwdFlg, newPwd, site);
    }
    catch (RemoteException re)
    {
      //System.out.println("Caught a remote Exception");
      re.printStackTrace();
    }

  }

}
