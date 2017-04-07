
package cciij.businessActions;

import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.naming.*;
import javax.sql.XADataSource;
import javax.sql.XAConnection;
import java.text.*;
import java.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import rmtc.util.*;
import cciij.util.*;
import bea.jolt.*;
//import armapi.*;

/**
 * Title:        Business Action Base<br>
 * Description:  Base abstract class for business actions. During construction
 *               of a BusinessActionBase object, the initialization method will
 *               check for the necessary configuration data contained in either
 *               the configuration file ccii.cfg, or the site parameter table.<br>
 * Copyright:    Copyright (c) 2001<br>
 * Company:      FedEx<br>
 * Exceptions:<br>
 * <UL>
 *   <LI>java.lang.Exception if error encountered attempting to fetch HandlingUnit.
 *   <LI>java.lang.Exception Unable to read application name from config file
 *   <LI>ava.lang.Exception Unable to read error message seperator string from config file
 *   <LI>java.lang.Exception Unable to read error message beginning character string from config file
 *   <LI>java.lang.Exception Unable to read error message severity mask string from config file
 *   <LI>java.lang.Exception Unable to read error message shift count from config file
 *   <LI>java.lang.Exception Unable to read error message severity FATAL value from config file
 *   <LI>java.lang.Exception Unable to read error message severity ERROR value from config file
 *   <LI>java.lang.Exception Unable to read error message severity WARN value from config file
 *   <LI>java.lang.Exception Unable to read error message severity INFO value from config file
 *   <LI>java.lang.Exception Config item missing, JOLT_IP_ADDRESS not found
 *   <LI>java.lang.Exception Config item missing, JOLT_IP_PORT not found
 *   <LI>java.lang.Exception Config item missing, TRACE_LEVEL not found
 *   <LI>java.lang.Exception WARNING: Jolt Session died prior to closing in BusinessActionBase
 * </UL>
 * <br>
 * @author       Robert Fisher
 * @version 1.0
 * <br>
 * <br>
 * Modification History:<br>
 *   <UL>
 *     <LI>Date: 2006/01/06
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Modified the initialization of the Notify so that we can start
 *                turning on the trace level for just a single business action
 *                by using the business action name, or for business actions that
 *                take a constructor, use the string "actionName" that is passed to
 *                the constructor.  The Notify object intialization was changed 
 *                in two spots:
 *               <UL>
 *                  <LI>In the default constructor, by trimming
 *                      the package name off of the class name (just like we already
 *                      do for the Config object initialization in the line above it).
 *                  <LI>In the constructor with a String argument, by changing to
 *                      use the "actionName" string passed (just like we already
 *                      do for the Config object initialization in the line above it).
 *               </UL>
 *         </UL>
 *       </UL>
 *     <LI>Date: 2005/02/01
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Modified getDBConnection method to rethrow an Exception instead of
 *                returning null.
 *            <LI>Added try block in actionEntry where getDBConnection is called.
 *                If an exception is caught the abort flag is set, and processing
 *                returns immediately to Scan Engine (RuleProcessor).
 *         </UL>
 *       </UL>
 *     <LI>Date: 2005/01/31
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Performance enhancement change to have the context as a property
 *                instead of recreating it each time a connection is needed.
 *         </UL>
 *       </UL>
 *     <LI>Date: 2004/11/05
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Add ARM capability to the application.
 *         </UL>
 *       </UL>
 *     <LI>Date: 2004/08/23
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Moved call to output the VERSIONINFO in order to allow the location
 *                to be set for the Config object.
 *         </UL>
 *       </UL>
 *     <LI>Date: 2004/08/16
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Commented out setting the PROVIDER_URL at recommendation of bea.
 *         </UL>
 *       </UL>
 *     <LI>Date: 03/10/04
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Added static member and method to optionally output version information
 *            <LI>Modified this comment block for Javadoc purposes
 *            <LI>Added traceLog to show calls to the initialize method
 *            <LI>Removed reference to get a Jolt connection
 *         </UL>
 *       </UL>
 *     <LI>Date: 08/26/02
 *       <UL>
 *         <LI>By: Steve Hurd
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Added methods to read config variables
 *         </UL>
 *       </UL>
 *     <LI>Date: 06/03/02
 *       <UL>
 *         <LI>By: Ed McAleer
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Move code that gets the AWB and scan object from formatErrMsg() to
 *                notifyLog() to correct the problem with the scan object dump being
 *                truncated by notifyLog().
 *         </UL>
 *       </UL>
 *     <LI>Date: 05/16/02
 *       <UL>
 *         <LI>By: Steve Hurd
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Added Conditional to calls on m_temp to check for null.
 *         </UL>
 *       </UL>
 *     <LI>Date: 05/06/02
 *       <UL>
 *         <LI>By: Robert Fisher
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>ActionEntry only establishes a jolt session if TRACE_LEVEL != 0
 *                traceLog and notifyLog call done() on jolt services
 *         </UL>
 *       </UL>
 *     <LI>Date: 04/24/02
 *       <UL>
 *         <LI>By: Ed McAleer
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Add BEGIN_STACK_TRACE and END_STACK_TRACE to separate non-formatted
 *                errors in the log file. Also, added statements to obtain the scan type
 *                and AWB from the state and scan objects.
 *         </UL>
 *       </UL>
 *   </UL>
 *
 */

public abstract class BusinessActionBase extends com.fedex.css.ruleprocessor.BusinessAction implements BusinessActionInterface
{
    private static final String m_whatVersion = "@(#) $RCSfile: BusinessActionBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    protected Config m_config;
    protected LocationList m_locationList;
    protected Notify m_notify;
    protected String m_traceLevel = "";
    //protected String m_hostAddress;
    //protected String m_hostPort;
    protected JoltSession m_session;
    protected JoltSessionAttributes m_sessionAttributes;
    protected JoltRemoteService m_notifyService;
    protected JoltRemoteService m_traceService;

    private QueueWriter m_exceptionActivityCodeQueueWriter;

    private CCIIState m_temp;
    private static String m_configDefaultedNumb;
    private static SimpleDateFormat m_simpDateFmt;
    protected static String m_localTimeZone;
    private static final String BEGIN_STACK_TRACE = "\n\n#=#=#=# BEGIN ERROR #=#=#=#\n\n";
    private static final String END_STACK_TRACE = "\n\n*=*=*=* END ERROR *=*=*=*\n\n";
    protected String m_locationCd = "";
    private DatabaseBean m_db = null;

    private static boolean m_showVersionInfo = true;

    protected String m_armTag = null;
//    protected ARMApplication m_armApp = null;
//    protected ARMTransaction m_tran = null;
//    protected ARMTransactionInstance m_transInstance = null;
    protected boolean m_armEnabled = false;
    protected boolean m_armedTransaction = false;


    public BusinessActionBase() throws Exception
    {
        //      System.out.println("BusinassActionBase()");
        //        m_config = new Config("WLTrace");
        String clsName = this.getClass().getName();
        int lastDot = clsName.lastIndexOf('.');
        if(lastDot > 0)
        {
            lastDot++;
        }
        //      System.out.println("Constructing a new Config object with the group of:  " + clsName.substring(lastDot));
        m_config = new Config(clsName.substring(lastDot));
        m_notify = new Notify(clsName.substring(lastDot));

        String temp = m_config.getValue ("SE_ARM_ENABLED");
        if (temp != null && temp.equals ("Y"))
        {
          m_armEnabled = true;
//          m_armApp = new ARMApplication ("CCII", "*");
          traceLog("BusinessActionBase","CCII Arming will be performed");
        }
        else
        {
          traceLog("BusinessActionBase","CCII Arming will NOT be performed");
        }
        initialize();
    }

    public BusinessActionBase(String actionName) throws Exception
    {
        //      System.out.println("BusinessActionBase(" + actionName + ")");
        m_config = new Config(actionName);
        m_notify = new Notify(actionName);
        initialize();
    }

    protected void initialize() throws Exception
    {
        traceLog("BusinessActionBase","initialize() for BA:  " + this.getClass().getName());

//      m_db = new DatabaseBean();
//      m_db.connect(getDBConnection());
        m_db = null;

        m_locationList = new LocationList(m_config);
        m_configDefaultedNumb = readConfigVariableString("BA_CONFIG_DEFAULTED_NUMB");

//        initialized = true;
    }

    private void outputVersionInfo()
    {
        m_showVersionInfo = false;

        AppVersionInfo theApp = new AppVersionInfo();

        try
        {
          theApp.dumpProperties(readConfigVariableBool("VERSIONINFO_DUMP_PROPERTIES",true));
          theApp.dumpJarFileManifest(readConfigVariableString("VERSIONINFO_FILE_CONTAINING_MANIFEST","applications/CCIIApplication.ear"),
             readConfigVariableBool("VERSIONINFO_DUMP_MANIFEST",true));
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }

    private InitialContext m_ctx = null;

    private java.sql.Connection getDBConnection()
	    throws Exception
    {
        if ( m_ctx == null )
        {
            Hashtable ht = new Hashtable();
            String webAddress = m_config.getValue("WEB_SERVER_ADDRESS");
            ht.put(Context.INITIAL_CONTEXT_FACTORY,
                   "weblogic.jndi.WLInitialContextFactory");
//            ht.put(Context.PROVIDER_URL,
//                   "t3://" + webAddress);
            try
            {
                m_ctx = new InitialContext(ht);
            }
            catch (Exception ex)
            {
                System.out.println("Get Connection Exception1: " + ex);
                ex.printStackTrace();
		throw ex;
            }
        }
        try
        {
//          XADataSource ds = (XADataSource) ctx.lookup("ccii.DS");
//          javax.sql.XAConnection xaconn = ds.getXAConnection();
//          java.sql.Connection aconn = xaconn.getConnection();
            javax.sql.DataSource ds = (javax.sql.DataSource)m_ctx.lookup("ccii.DS");
//          javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("cdd.TXDS");

//          if(ds.getLogWriter() == null)
//          {
//              System.out.println("Setting System.out as the log writer for the datasource");
//              ds.setLogWriter(new PrintWriter(System.out));
//          }
//          else
//          {
//              System.out.println("Already has a Log Writer");
//          }

            long start = System.currentTimeMillis();
            java.sql.Connection aconn = ds.getConnection();
            long end = System.currentTimeMillis();
            traceLog("BusinessActionBase","getConnection time: " + (end - start));


//          System.out.println("BAB.getDBConnection()");
//          System.out.println("---------------------");
//          System.out.println("Connection.AutoCommit():  " + aconn.getAutoCommit());
//          System.out.println("Connection.isClosed():  " + aconn.isClosed());
//          System.out.println("Connection.isReadOnly():  " + aconn.isReadOnly());
//          java.sql.SQLWarning warn = aconn.getWarnings();
//          while(warn != null)
//          {
//              System.out.println("Warning:  " + warn);
//              warn = warn.getNextWarning();
//          }
//          System.out.println("DatabaseMetaData:");
//          java.sql.DatabaseMetaData dmd = aconn.getMetaData();
//          System.out.println("DriverName:  " + dmd.getDriverName());
//          System.out.println("Tables:");
//          String tblTypes[] = { "TABLE" };
//          java.sql.ResultSet tbls = dmd.getTables(null,null,null,tblTypes);
//          while(tbls.next())
//          {
//              System.out.println(tbls.getString("TABLE_NAME"));
//          }
//          System.out.println("---------------------");


            //Class.forName("weblogic.jdbc.pool.Driver").newInstance();
            //java.sql.Connection aconn = DriverManager.getConnection("jdbc:weblogic:pool:CCIIConnectionPool", null);
            //      aconn.setAutoCommit(false);
            return aconn;
        }
        catch(Exception ex) {
            System.out.println("Get Connection Exception2: " + ex);
            ex.printStackTrace();
            throw ex;
        }

    }

    protected void readSiteConfigVariables() throws Exception
    {
        m_localTimeZone = readConfigVariableString("LOCAL_TIMEZONE","America/Denver");
        m_traceLevel = readConfigVariableString("TRACE_LEVEL");
        m_armTag = m_config.getString("ARM_TAG");
    }

    private void addLogMessageReadConfigFailed(String configName) throws Exception
    {
        traceLog("businessActionBase","Unable to read config variable (" + configName + ") at " + m_locationCd);
        Exception ex = new Exception("businessActionBase: Unable to read configVariable (" + configName + ") at " + m_locationCd);
        String errorMsg = formatError(m_configDefaultedNumb,
                                      "Unable to read " + configName +  "from config file");
        notifyLog(errorMsg,ex);
        throw ex;
    }

    private void addLogMessageReadConfigUseDefault(String configName, String defaultValue)
    {
        traceLog("businessActionBase","Assigning default value (" + defaultValue + ") to config variable (" + configName + ") at " + m_locationCd);
        Exception ex = new Exception("businessActionBase: Assigning default value (" + defaultValue + ") to configVariable (" + configName + ") at " + m_locationCd);
        String errorMsg = formatError(m_configDefaultedNumb,
                                      "Setting Default value " + defaultValue + ", unable to read " + configName +  " at " + m_locationCd + " from config file");
        notifyLog(errorMsg,ex);
    }

    private void addLogMessageReadConfigFailedFormat(String configName, String valueRead, String formatType, Exception e) throws Exception
    {
        traceLog("businessActionBase","For: " + configName + " failed to format " + valueRead + " at "+ m_locationCd +" as a " + formatType );
        String errorMsg = formatError(m_configDefaultedNumb,
                                      configName + " Failed to format " + valueRead + " at "+ m_locationCd + " as a " + formatType);
        notifyLog(errorMsg,e);
        throw e;
    }

    protected void setConfigSection(String sectionName)
    {
        if (sectionName == null)
        {
            m_config.setGroup("ALL");
        }
        else
        {
            m_config.setGroup(sectionName);
        }
    }

    protected String readConfigVariableString(String configName) throws Exception
    { //basic read, most other readConfig methods call this one
        String tempString = null;
        if (m_config == null)
        {
            m_config = new Config();
        }
        if (configName == null)
        {
            traceLog("businessActionBase","config name is null");
            addLogMessageReadConfigFailed(configName);
            //the last call will add log messages and then throw an exception
        }
        else
        {
            tempString =  m_config.getValue(configName);
            if ( tempString == null )
            {
                traceLog("businessActionBase",configName + " value is null in config file " + m_locationCd);
                addLogMessageReadConfigFailed(configName);
                //the last call with add log messagees then throw an exception
            }
        }
        //return with a value if you haven't been thrown out by an exception
        return tempString;
    }

    protected int readConfigVariableInt(String configName) throws Exception
    {
        int returnInt = -9999;
        //this call will throw an exception and kick you out if the variable doesn't exist
        String tempString = readConfigVariableString(configName);
        try
        {
            returnInt = Integer.parseInt(tempString);
        } catch (Exception e)
        {
            addLogMessageReadConfigFailedFormat(configName,tempString,"int",e);
            //the last call will add log messsages and then throw an exception
        }
        //return value if you haven't been thrown out by an exception
        return returnInt;
    }

    protected boolean readConfigVariableBool(String configName) throws Exception
    {
        boolean returnBool = false;
        //this call will throw an exception and kick you out if the variable doesn't exist
        String tempString = readConfigVariableString(configName);
        try
        {
            tempString.trim();
            returnBool = tempString.equalsIgnoreCase("TRUE")
                || tempString.equalsIgnoreCase("T")
                || tempString.equalsIgnoreCase("YES")
                || tempString.equalsIgnoreCase("Y");
        }
        catch (Exception e)
        {
            addLogMessageReadConfigFailedFormat(configName,tempString,"boolean",e);
            //this call will add log messages then throw an exception
        }
        return returnBool;
    }

    protected String readConfigVariableString(String configName, String defaultValue)
    {
        String tempString = null;
        try
        {
            tempString = readConfigVariableString(configName);
        }
        catch (Exception e)
        {
            //catch the exception so that you can continue
            //don't have to do anything here, the temp String = null will take care
            // setting the default value
        }
        if (tempString == null)
        {
            tempString = defaultValue;
            addLogMessageReadConfigUseDefault(configName,defaultValue);
            //this call will add log messages, but will not throw an exception
        }
        //return either the value read in or the default value if not found
        return tempString;
    }

    protected boolean readConfigVariableBool(String configName, boolean defaultValue)
    {
        boolean returnBool = defaultValue;
        //this call will return either the value read in or the default value
        //it will not throw an exception (if it did, it was already caught)
        String tempString = readConfigVariableString(configName,String.valueOf(defaultValue));
        try
        {
            tempString.trim();
            returnBool = tempString.equalsIgnoreCase("TRUE")
                || tempString.equalsIgnoreCase("T")
                || tempString.equalsIgnoreCase("YES")
                || tempString.equalsIgnoreCase("Y");
        }
        catch (Exception e)
        {
            try
            {
                addLogMessageReadConfigFailedFormat(configName,tempString,"boolean",e);
                //adds log messages and then throws an exception
            } catch (Exception e2)
            {
                //catch the exception and then force the default value
                System.out.println("Unable to add log message, Read Config Failed Format Boolean");
            }
            returnBool = defaultValue;
        }
        //returns either the value read in or the default value if not found or not of the right format
        return returnBool;
    }

    protected int readConfigVariableInt(String configName, int defaultValue)
    {
        int returnInt = -9999;
        //this call will return either the value read in or the default value
        // it will not throw an exception (if it did, it was already caught)
        String tempString = readConfigVariableString(configName,String.valueOf(defaultValue));
        try
        {
            returnInt = Integer.parseInt(tempString);
        } catch (Exception e)
        {
            try
            {
                addLogMessageReadConfigFailedFormat(configName,tempString,"int",e);
                //adds log messages and then throws an exception
            } catch (Exception e2)
            {
                //caught the exception and then force the default value
                returnInt = defaultValue;
            }
        }
        //returns either the value read in or the default value if not found or not of the right format
        return returnInt;
    }

    public abstract CCIIState doIt (CCIIState s, DatabaseBean db) throws Exception;

    /**
     * Method:       BusinessActionBase.actionEntry()
     * Description:  Establish a Jolt session. Call doIt() method to process
     *               business action. Catch any exceptions thrown while processing
     *               the business action and call notifyLog() to write the error
     *               information to the notification log file. Close the Jolt session and
     *               return the state object to the caller.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @exception    java.lang.Exception if error encountered getting a Jolt session.
     * @throws       java.lang.Exception WARNING: Jolt Session died prior to closing in BusinessActionBase
     *
     * @param        state - CCIIState object to be updated.
     * @param        dbConnection - DatabaseBean connection object.
     *
     * @return       cciij.cciidata.CCIIState updated state object.
     */

    //    public CCIIState actionEntry(CCIIState state)
    public com.fedex.css.ruleprocessor.State actionEntry(com.fedex.css.ruleprocessor.State inState)
    {
        boolean armResult = false;

        //System.out.println(this.getClass().getName() + ".actionEntry(state)");
        
        if(inState instanceof CCIIState)
        {
            //      System.out.println("actionEntry called with correct state object");
        }
        else
        {
            throw new RuntimeException("Invalid State Class passed to BusinessActionBase.actionEntry():  " + inState.getClass().getName());
        }

        CCIIState state = (CCIIState)inState;
       
	try
	{
          if(m_db == null)
          {
            m_db = new DatabaseBean();
            m_db.setLocationCode(state.getScan().getLocationCode());
            m_db.connect(getDBConnection());
          }
          else
          {
            m_db.setConnection(getDBConnection());
          }
	}
        catch (Exception ex ) 
	{
	    System.out.println ( "actionEntry(): Failed to obtain a DB connection from pool... Setting the abort flag." );
            ex.printStackTrace(System.out);
            // first set the abortTransaction member of the state object
            state.setAbortTransaction(true);

            // call the method to send the stackTrace to the log file
            String errorNumber = "000000";
            String errorMsg = formatError(errorNumber,BEGIN_STACK_TRACE);
            notifyLog(errorMsg,ex);

	    /************************************/
	    /********* R E T U R N I N G ********/
	    /************************************/
	    return state;
        }

        m_temp = state;
        String locationCd = state.getScan().getLocationCode();
        //      System.out.println("actionEntry() with location of:  " + locationCd);
        
        if (!locationCd.equals(m_locationCd))
        {
            m_config.setLocationCode(locationCd);
            if ( m_showVersionInfo )
            {
                outputVersionInfo();
            }
            //      System.out.println("Setting location code to:  |" + locationCd + "|");
            m_db.setLocationCode(locationCd);
            m_locationCd = locationCd;
            try
            {
                readSiteConfigVariables();
            }catch (Exception e)
            {
                state.setAbortTransaction(true);
                state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
            }
        }
        
        try
        {
            armStart ();
            
            // System.out.println(this.getClass().getName() + ".doIt(" + state.getScan().getLocationCode() + ");");
            m_temp = doIt(state,m_db);

            armResult = true;
        }
        catch (CCIILogException lx) {
            //            System.out.println("Caught a CCIILogException from " + this.getClass().getName() + ".doIt:  " + lx);
            lx.printStackTrace(System.out);
            state.setAbortTransaction(true);

            // if the error number is not set then give the Scan failed message
            if ( state.getScan().getErrorNumber() == 0 ) {
                state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
            }
            // if there was an IM (information message) then give the Scan failed message
            if ( state.getScan().getErrorNumber() < Messages.START_OF_ERROR_MSGS ) {
                state.getScan().setErrorNumber(Messages.EM_START_OVER);
            }

            // if intercept creat failed, EM_INTERCEPT_INVALID, then give scan failed
            if ( state.getScan().getErrorNumber() == Messages.EM_INTERCPT_ERROR ) {
                state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
            }

            // get the config item for the error number
            String errorNumber = m_config.getValue(lx.getConfigString());
            if ( errorNumber == null ) {
                errorNumber = "000000";
            }

            // now format the log file message
            String errorMessage = formatError(errorNumber,lx.getMessageString());

            // sent it to NotifyLog
            notifyLog(errorMessage,lx);

        }
        catch (Exception ex ) {
            //            System.out.println("Caught an Exception from " + this.getClass().getName() + ".doIt:  " + ex);
            ex.printStackTrace(System.out);
            // first set the abortTransaction member of the state object
            state.setAbortTransaction(true);

            // if the error number is not set then give the Scan failed message
            if ( state.getScan().getErrorNumber() == 0 ) {
                state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
            }
            // if there was an IM (information message) then give the Scan failed message
            if ( state.getScan().getErrorNumber() < Messages.START_OF_ERROR_MSGS ) {
                state.getScan().setErrorNumber(Messages.EM_START_OVER);
            }

            // if intercept creat failed, EM_INTERCEPT_INVALID, then give scan failed
            if ( state.getScan().getErrorNumber() == Messages.EM_INTERCPT_ERROR ) {
                state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
            }
            // call the method to send the stackTrace to the log file
            String errorNumber = "000000";
            String errorMsg = formatError(errorNumber,BEGIN_STACK_TRACE);
            notifyLog(errorMsg,ex);
        }

        if ( state.getScan().getErrorNumber() > Messages.START_OF_ERROR_MSGS ) {
            state.setAbortTransaction(true);
        }

        if((state.getExceptionActivityCodes().isEmpty() == false))
        {
            postExceptionActivityCodes(state);
        }

        try
        {
            m_db.getConnection().close();
        }
        catch(Exception e)
        {
            m_notify.triggerNotify("Failed to close DB connection from pool... I may have just leaked a connection",
                                   e);
        }

        m_db.setConnection(null);
        
        armEnd ( armResult );
        return m_temp;

    }

    /**
     * Method:       BusinessActionBase.traceLog(actionName, data)
     * Description:  Check if the trace level is NOT 0 (ZERO), see if a Jolt
     *               session exists. If a Jolt session does NOT exist, get a new
     *               Jolt session.
     *
     *               Verify the length of the data string does NOT exceed 2047. If
     *               the string exceeds the 2047 limit, truncate the string to 2047
     *               characters.
     *
     *               Call the remote Jolt trace service to write the trace information
     *               to the trace log file.
     *
     *               Close the Jolt session if a new session was creaeted in the above check.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @exception    java.lang.Exception if error encountered getting a Jolt session.
     * @exception    bea.jolt.ApplicationException exception traying to call trace service.
     * @throws       java.lang.Exception WARNING: Jolt Session died prior to closing in BusinessActionBase
     *
     * @param        actionName - String containing the action name.
     * @param        data - String to be written to the trace log.
     *
     * @return       void
     */

    public void traceLog(String actionName,String data)
    {
        m_notify.trace(data);
    }


    public void traceLog_old(String actionName, String data) {

        boolean endJoltSession = false;

        if ( m_traceLevel.equals("0") ) {
            return;
        }

        if (m_session == null) {
            try {
                getJoltSession();
                endJoltSession = true;
            }
            catch (Exception ex) {
                System.out.println("TraceLog failed to get a Jolt session");
                if ( m_temp != null && m_temp.getScan() != null ) {
                    m_temp.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
                }
                return;
            }
        }

        try {
            m_traceService = new JoltRemoteService("WLTRACE",m_session);
            m_traceService.addString("s_returnMessage","Trace checkpoint from : " + actionName);
            if (data.length() > 2047 ) {
                m_traceService.addString("s_toString",data.substring(0,2047));
            }
            else {
                m_traceService.addString("s_toString",data);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            m_traceService.call(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to trace -> " + data);
        }


        if (m_traceService != null)
           m_traceService.done();
        m_traceService = null;

        if ( endJoltSession == true ) {
            m_session.endSession();
            m_session = null;
            m_sessionAttributes.clear();
            m_sessionAttributes = null;
        }
    }

    /**
     * Method:       BusinessActionBase.traceLog(actionName, state)
     * Description:  Check trace level for 0 (ZERO) and call traceLog() if
     *               the trace level is anything other than 0, to write the
     *               trace information into the trace log file.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @param        actionName - String containing the action name.
     * @param        state - cciij.cciidata.CCIIState updated state object.
     *
     * @return       void
     */

    public void traceLog(String actionName,CCIIState state)
    {
        m_notify.trace("State Object Dump:",state);
    }

    public void traceLog_old(String actionName, CCIIState state) {
        if ( m_traceLevel.equals("0") ) {
            return;
        }
        traceLog(actionName, state.toString());
        traceLog(actionName,state.getScan().toString());
    }

    /**
     * Method:       BusinessActionBase.traceLog(actionName, hu)
     * Description:  Check if trace level is NOT 0 (ZERO) call traceLog
     *               to write the HandlingUnit trace information into the trace log file.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @param        actionName - String containing the action name.
     * @param        hu - HandlingUnit.
     *
     * @return       void
     */

    public void traceLog(String actionName, HandlingUnit hu)
    {
        m_notify.trace("Handling Unit Object Dump:",hu);
    }

    public void traceLog_old(String actionName, HandlingUnit hu) {
        if ( m_traceLevel.equals("0") ) {
            return;
        }
        traceLog(actionName, hu.toString());
    }

    /**
     * Method:       BusinessActionBase.traceLog(actionName, ship)
     * Description:  Check if trace level is NOT 0 (ZERO) call traceLog
     *               to write shipment trace information into the trace log file.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @param        actionName - String containing the action name.
     * @param        ship - Shipment.
     *
     * @return       void
     */

    public void traceLog(String actionName,Shipment ship)
    {
        m_notify.trace("Shipment Object Dump:  ",ship);
    }

    public void traceLog_old(String actionName, Shipment ship) {
        if ( m_traceLevel.equals("0") ) {
            return;
        }
        traceLog(actionName, ship.toString());
    }

    /**
     * Method:       BusinessActionBase.traceLog(actionName, intercept)
     * Description:  Check if trace level is NOT 0 (ZERO) call traceLog
     *               to write the intercept trace information into the trace log file.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @param        actionName - String containing the action name.
     * @param        intercept - Intercept.
     *
     * @return       void
     */

    public void traceLog(String actionName,Intercept intercept)
    {
        m_notify.trace("Intercept Object Dump:  ", intercept);
    }

    public void traceLog_old(String actionName, Intercept intercept) {
        if ( m_traceLevel.equals("0") ) {
            return;
        }
        traceLog(actionName, intercept.toString());
    }

    /**
     * Method:       BusinessActionBase.getJoltSession()
     * Description:  This method gets a Jolt session.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @exception    java.lang.Exception attempt to get a new Jolt session.
     * @throws       java.lang.Exception Jolt session exception.
     *
     * @return       void
     */

    public void getJoltSession(String sessionName) throws Exception {
        String hostAddress = readConfigVariableString("JOLT_IP_ADDRESS");
        String hostPort = readConfigVariableString("JOLT_PORT");
        try {
            m_sessionAttributes = new JoltSessionAttributes();
            m_sessionAttributes.setString(m_sessionAttributes.APPADDRESS,
                                          "//" + hostAddress + ":" + hostPort);
            //  IdleTimeout of zero, makes client connections in retained mode
            m_sessionAttributes.setInt(m_sessionAttributes.IDLETIMEOUT,0);
            m_session = new JoltSession(m_sessionAttributes,sessionName,"","","");
        }
        catch (Exception ex) {
            System.out.println("BusinessActionBase: caught an exception while establishing jolt session");
            System.out.println(ex);
            ex.printStackTrace();
            throw ex;
        }
    }

    public void getJoltSession() throws Exception
    {
        getJoltSession("ActionBase");
    }

    /**
     * Method:       BusinessActionBase.notifyLog(exIn)
     * Description:  For backwards compatability with the original interface
     *               set the string to a default and send it to the notifyLog
     *               method with the call to the Tux env
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @exception    java.lang.Exception attempt to get a Jolt session.
     * @exception    bea.jolt.ApplicationException occurred during call to notify service.
     *
     * @param        exIn - java.lang.Exception to be placed in the notify log.
     *
     * @return       void
     */


    final protected void notifyLog(Exception ex) {
        notifyLog("",ex);
    }

    /**
     * Method:       BusinessActionBase.postExceptionActivityCodes
     * Description:  Apply the Exception Activity Codes before we let ruleprocessor
     *               rollback the transaction.
     *
     * @author       Mike Roderick
     * @version      1.0
     *
     * @param        state - CCIIState with the exception codes
     * @return       void
     */

    final private void postExceptionActivityCodes(CCIIState state)
    {
        try
        {
            if(m_exceptionActivityCodeQueueWriter == null)
            {
                m_exceptionActivityCodeQueueWriter = new QueueWriter();
            }

            CCIIState s = (CCIIState)state.clone();

            s.getScan().setErrorNumber(0);
            s.setAbortFlag(false);

            s.setActivityCodes(state.getExceptionActivityCodes());
            s.setExceptionActivityCodes(new Vector());

            s.setRuleSetName(m_config.getValue("EXCEPTION_ACTIVITY_CODE_RULESET"));

            m_exceptionActivityCodeQueueWriter.putOnQueue(m_config.getValue("EXCEPTION_ACT_CODE_QUEUE_NAME"),
                                                          m_locationCd,
                                                          s);
        }
        catch(Exception e)
        {
            notifyLog("Failed to Post the Exception Activity:  ",e);
        }
        finally
        {
            state.getExceptionActivityCodes().clear();
        }

    }


    /**
     * Method:       BusinessActionBase.notifyLog(errorMessage, exIn)
     * Description:  If a Jolt session is not established, get a Jolt session.
     *               Construct a remove notification Jolt service object. Check
     *               the notification message length to see if it's greater than
     *               2000. For messages greater than 2000, truncate the message
     *               string to 2000 characters. Call the remote notification service to
     *               write the notification information to the notify log. Close
     *               the Jolt session if a new session was creaeted in the above check.
     *
     * @author       Robert Fisher
     * @version 1.0
     *
     * @exception    java.lang.Exception attempt to get a Jolt session.
     * @exception    bea.jolt.ApplicationException occurred during call to notify service.
     *
     * @param        exIn - java.lang.Exception to be placed in the notify log.
     *
     * @return       void
     */

    final protected void notifyLog(String errorMessage, Exception exIn)
    {
        m_notify.triggerNotify(errorMessage,exIn);
    }

    final protected void notifyLog_old(String errorMessage, Exception exIn) {
        boolean endJoltSession = false;
        // this method is called when an exception is caught in action entry
        StringWriter sw = new StringWriter();
        exIn.printStackTrace(new PrintWriter(sw));
        String theStackTrace = "";
        Date currentDtTm = new Date();
        // Get formatted date.

        // Check for valid state and scan objects. If both objects are NOT null
        // append the AWB# and scan object to theStrackTrace string. This was done
        // because the errorMessage was being truncated if it contained the AWB and
        // scan object.

        if ( m_temp != null && m_temp.getScan() != null )
        {
            RPBScan scan = m_temp.getScan();
            theStackTrace = theStackTrace + ("\n\t<<< *** Scan Object *** >>>\n\t" + scan.toString());
            theStackTrace = theStackTrace + ("\n\t<<< *** State Object *** >>>\n\t" + m_temp.toString() + "\n\n");
        }

        // Append the stack trace
        theStackTrace = theStackTrace + "<<< *** Stack Trace *** >>>\n";
        theStackTrace = theStackTrace + sw.toString();
        theStackTrace = theStackTrace + END_STACK_TRACE;

        // look and see if i_errorNumber is set
        // truncate the stacktrace and call
        // notify via JSL with the error

        if (m_session == null) {
            try {
                getJoltSession();
                endJoltSession = true;
            }
            catch (Exception ex) {
                System.out.println(BEGIN_STACK_TRACE);
                System.out.println(m_simpDateFmt.format(currentDtTm));
                ex.printStackTrace();
                System.out.println(errorMessage);
                System.out.println(theStackTrace);
                System.out.println(END_STACK_TRACE);
                return;
            }
        }

        try {
            m_notifyService = new JoltRemoteService("WLNOTIFY",m_session);


            if (errorMessage.length() > 255 ) {
                m_notifyService.addString("s_returnMessage",errorMessage.substring(0,254));
            }
            else {
                m_notifyService.addString("s_returnMessage",errorMessage);
            }

            //      if (theStackTrace.length() > 2000 ) {
            //        m_notifyService.addString("s_stackTrace",theStackTrace.substring(0,1999));
            //      }
            //      else {
            m_notifyService.addString("s_stackTrace",theStackTrace);
            //      }
        }
        catch (Exception ex) {
            System.out.println(BEGIN_STACK_TRACE);
            System.out.println(m_simpDateFmt.format(currentDtTm));
            ex.printStackTrace();
            System.out.println(errorMessage);
            System.out.println(theStackTrace);
            System.out.println(END_STACK_TRACE);
        }

        try {
            m_notifyService.call(null);
        }
        catch (Exception ex) {
            // since we could not get the exception in the default log via WLNOTIFY
            //  print the stack trace to stdout
            System.out.println("" + new Date() + BEGIN_STACK_TRACE);
            System.out.println(m_simpDateFmt.format(currentDtTm));
            ex.printStackTrace();
            System.out.println("" + new Date() + "Original Message that did not get to WLNotify");
            System.out.println(errorMessage);
            System.out.println(theStackTrace);
            System.out.println("" + new Date() + END_STACK_TRACE);
        }


        m_notifyService.done();
        m_notifyService = null;


        if ( endJoltSession == true ) {
            m_session.endSession();
            m_session = null;
            m_sessionAttributes.clear();
            m_sessionAttributes = null;
        }
    }

    /**
     * Method:       BusinessActionBase.formatError()
     * Description:  Create a formatted error message string using the method
     *               formatError() that accepts an Object as one of the arguments.
     *
     * @author       Ed McAleer
     * @version 1.0
     *
     * @param        errorNmbr error number
     * @param        errorMsg  error message string
     *
     * @return       formatted error message string
     */
    final protected String formatError(String errorNmbr, String errorMsg) {

        return m_notify.formatError(errorNmbr,errorMsg,this);
    }

    /**
     * Method:       BusinessActionBase.formatError()
     * Description:  This method creates a formatted error message string that contains the following:
     *               - Severity type
     *               - Timestamp
     *               - Application name
     *               - "Java"
     *               - Class name
     *               - Error number
     *               - Error message
     *
     *               The formatted error message is returned to the caller.
     *
     * @author       Ed McAleer
     * @version 1.0
     *
     * @param        errorNmbr error number
     * @param        errorMsg  error message string
     * @param        BusnActClass reference to business action class
     *
     * @return       formattedErrMsg - formatted error message string
     */
     final public String formatError(String errorNmbr, String errorMsg, Object BusnActClass)
     {
        return m_notify.formatError(errorNmbr,errorMsg,BusnActClass);
     }

    public void initSite(String site)
    {
      if (!site.equals(m_locationCd))
      {
          m_config.setLocationCode(site);
          //db.setLocationCode(site);
          m_locationCd = site;
          try
          {
              readSiteConfigVariables();
          }catch (Exception e)
          {
              System.out.println("Unable to initSite in BusinessActionBase");
          }
      }
    }

    private void armStart ()
    {
      m_armedTransaction = false;

      if ( m_armEnabled )
      {
        traceLog("BusinessActionBase:armStart","Arming enabled, armTag is: " + m_armTag);

        if ( (m_armTag != null) && (m_armTag.trim().length() > 0) )
        {
//          m_tran = m_armApp.createTransaction (m_armTag, m_armTag);
//          m_transInstance = m_tran.createTransactionInstance ();
//          m_transInstance.startTran ();
          m_armedTransaction = true;
        }
      }
    }

    private void armEnd (boolean noError)
    {

      if (!m_armedTransaction)
      {
        return;
      }

/*      if (noError)
      {
        m_transInstance.stopTranInstance (ARMConstants.ARM_GOOD);
      }
      else
      {
        m_transInstance.stopTranInstance (ARMConstants.ARM_FAILED);
      }
     */
    }



}

