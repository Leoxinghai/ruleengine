package cciij.WSUtil;

import cciij.cciidata.CCIIState;
import cciij.businessActions.*;
import cciij.cciidatabase.DatabaseBean;
import cciij.util.CCIILogException;
import java.text.SimpleDateFormat;
import cciij.util.Notify;
/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class WSNotify implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: WSNotify.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected String m_actionName="WorkStation";
  protected WSInnerNotify m_inner = null;
  protected boolean m_initialized = false;
  protected String m_locationCd = "ALL";
  protected Notify m_notify = new Notify(m_actionName);

  public class WSInnerNotify extends cciij.businessActions.BusinessActionBase implements java.io.Serializable
  {
    private static final String m_whatVersion = "@(#) $RCSfile: WSNotify.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";

    public WSInnerNotify() throws java.lang.Exception
    {
      super();
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read in
    }

    public CCIIState doIt(CCIIState s, DatabaseBean db) throws java.lang.Exception
    {
      /**@todo: implement this cciij.businessActions.BusinessActionBase abstract method*/
      return new CCIIState();
    }
    public void notifyInnerLog(String str, Exception e)
    {
      notifyLog(str, e);
    }
  }

  public WSNotify()
  {
    //initialize();
  }

  /*
  protected void initialize()
  {
    try
    {
      m_inner = new WSInnerNotify();
      m_initialized = true;
    }
    catch (Exception e)
    {
      System.out.println(emergencyErrorFormat("Unable to create WSInnerNotify"));
      e.printStackTrace();
      m_initialized = false;
      CCIILogException ex = new CCIILogException();
      ex.printStackTrace();
    }
  }
  */

  public WSNotify(String actionName)
  {
    this();
    setActionName(actionName);
  }

  public synchronized void setActionName(String actionName)
  {
      if (actionName != null)
          m_actionName = actionName;
      else
         m_actionName = "Unknown";
  }

  public synchronized void wsNotifyLog(String errorString, Exception e)
  {
    try
    {
      m_notify.setServiceName(m_actionName);
      m_notify.triggerNotify(errorString,e);
    } catch (Exception ex)
    {
      System.out.println("wsNotifyLog: caught exception while trying to write log message");
      System.out.println("Exception info from this exception");
      ex.printStackTrace();
      System.out.println("Original Exception information: " + errorString);
      e.printStackTrace();
    }

  }

  public void wsNotifyLog(String errorNumber, String errorMessage, Exception e,final Object thisPointer)
  {
    String errorString = "";
    try{
      errorString = m_notify.formatError(errorNumber, errorMessage, thisPointer);
    } catch (Exception ex)
    {
      System.out.println("Caught an exception while trying to format error");
      ex.printStackTrace();
    }
    wsNotifyLog(errorString,e);
  }

  public void wsNotifyLog(String errorNumber, String errorMessage, Exception e, String className)
  {
    String errorString = m_notify.formatError(errorNumber, errorMessage, null);
    wsNotifyLog(errorString, e);
  }

  public synchronized void traceLog(String data)
  {
    m_notify.trace(m_actionName + ": " + data);
  }
  /*
  public String emergencyErrorFormat(String errorMsg)
  {
    //this is only used if you cannot use the innerNotify formatError class
    SimpleDateFormat df = new SimpleDateFormat(CCIIProperties.DEFAULT_DATE_FORMAT_ERROR_LOG);
    df.setTimeZone(CCIIProperties.LOCAL_TIME_ZONE);
    String errorString = "***ERROR | APPLICATION | " + df.format(new java.util.Date())
           + " | CCII | JAVA | cciij.util.WSNotify | "
           + CCIIProperties.WS_ERROR_NOTIFY_ERROR + " " + errorMsg;
    return errorString;
  }
*/
  public void initSite(String site)
  {
    if (site == null || site.equals(""))
       site = "ALL";
    m_locationCd = site;
  }
}
