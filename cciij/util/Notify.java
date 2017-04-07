//*************************************************************************
//
// Filename: Notify.C
//
// Description:  implementation of the java Notify Class
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/util/Notify.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:20 $
//
// Modification History:
//
//   05/29/01  Michael Roderick Commented
//   10/21/05  Joey Cline       Moved the call to "initTrace" before the
//                              call to "initialize" in order to make sure
//                              that the Config object is initialized before
//                              use.  "initialize" was trying to use Config 
//                              values, and creating a new Config object, 
//                              since initTrace had not yet been called to 
//                              create the Config object.
//
//*************************************************************************

package cciij.util;

import java.lang.reflect.*;
import cciij.businessActions.Messages;
import java.util.*;
import java.io.*;
import cciij.cciidata.*;
import rmtc.util.*;
import java.text.SimpleDateFormat;

public class Notify extends Exception
{

    public static final int errorLevelDebug=0;    // Debugging
    public static final int errorLevelInfo=1;     // Informational
    public static final int errorLevelTrace=2;    // Used by trace()
    public static final int errorLevelWarning=3;  // Problem, but can recover
    public static final int errorLevelError=4;    // Problem, cannont recover
    public static final int errorLevelCritical=5; // Problem, I wont work anymore
    public static final int maxNotifyLevels=6;  //

    private static String m_seperator;
    private static String m_beginErrorLine;
    private static int m_severityMask;
    private static int m_severityFatal;
    private static int m_severityError;
    private static int m_severityWarn;
    private static int m_severityInfo;
    private static String m_severity;
    private static String m_simpleDateFormatStr;
    private static SimpleDateFormat m_simpDateFmt;
    private static String m_localTimeZone;


    // These are the trace levels, if something qualifies as two, they can
    //   be bit-wise |'ed together.
    public static final int serviceEntryExit      = 0x01;
    public static final int serviceEntryExitData  = 0x02;
    public static final int serverInitDone        = 0x04;
    public static final int methodEntryExit       = 0x08;
    public static final int criticalCodeEntryExit = 0x10;
    public static final int dbAccess              = 0x20;
    public static final int componentEntryExit    = 0x40;
    public static final int criticalData          = 0x80;
    public static final int revision              = 0x100;
    public static final int traceMask             = 0x1FF;


    private MessageFormat mf = new MessageFormat();

    private Vector m_dataVector = new Vector();
    private Vector m_stringVector = new Vector();
    private List m_utilList = new Vector();

    private int m_currentTraceLevel = traceMask;

    private static NotifyMessage m_notifyMessage=null;

    private String m_serviceName="";

    protected Config m_config;

    public Notify()
    {
        super("Notify, check contents for more Info");
        initTrace("ALL");
        initialize();
    }

    public Notify(String as_serviceObjectName)
    {
        super("Notify, check contents for more Info");
        initTrace(as_serviceObjectName);
        initialize();
    }

    public void setServiceName (String as_serviceObjectName)
    {
        initTrace(as_serviceObjectName);
    }

    public void initialize ()
    {
        m_severityMask = readConfigVariableInt("ERROR_MSG_SEVERITY_MASK",7);
        m_severityFatal = readConfigVariableInt("ERROR_MSG_SEVERITY_FATAL",4);
        m_severityError = readConfigVariableInt("ERROR_MSG_SEVERITY_ERROR",3);
        m_severityWarn = readConfigVariableInt("ERROR_MSG_SEVERITY_WARN",2);
        m_severityInfo = readConfigVariableInt("ERROR_MSG_SEVERITY_INFO",1);
        m_seperator = readConfigVariableString("ERROR_MSG_STR_SEPERATOR","|");
        m_seperator = " " + m_seperator + " ";
        m_beginErrorLine = readConfigVariableString("ERROR_MSG_BEGIN_STR", "***");
        m_simpleDateFormatStr = readConfigVariableString("ERROR_MSG_SIMPLE_DATE_FORMAT","yyyy-MM-d HH:mm:ss");
        m_localTimeZone = readConfigVariableString("LOCAL_TIMEZONE","America/Denver");
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
            System.out.println("Notify: " + "unable to read config variable: "
                               + configName + " using default: " + defaultValue);
            returnInt = defaultValue;
        }
        //returns either the value read in or the default value if not found or not of the right format
        return returnInt;
    }

    protected String readConfigVariableString(String configName) throws Exception
    { //basic read, most other readConfig methods call this one
        String tempString = null;
        if (m_config == null)
        {
            m_config = new Config();
        }
        tempString =  m_config.getValue(configName);
        return tempString;
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
            System.out.println("Notify: " + "unable to read config variable: "
                               + configName + " using default: " + defaultValue);
            //addLogMessageReadConfigUseDefault(configName,defaultValue);
            //this call will add log messages, but will not throw an exception
        }
        //return either the value read in or the default value if not found
        return tempString;
    }

    private void initTrace(String as_serviceObjectName)
    {
        m_config = new Config(as_serviceObjectName);

        m_serviceName = as_serviceObjectName;

        if(m_notifyMessage == null)
        {
            m_notifyMessage = new NotifyMessage();
        }

        String ls_traceLevel = m_config.getValue("TRACE_LEVEL");

        int li_newTraceLevel = 0;

        if((ls_traceLevel == null) || (ls_traceLevel.length() <= 0))
        {
            li_newTraceLevel = 0;
        }
        else
        {
            li_newTraceLevel = Integer.parseInt(ls_traceLevel);
        }

        if(li_newTraceLevel < 0)
        {
            li_newTraceLevel = 0;
        }

        setTraceLevel(li_newTraceLevel);
        return;
    }

    public int getTraceLevel()
    {
        return m_currentTraceLevel;
    }

    public int setTraceLevel(int ai_newTraceLevel)
    {
        int l_traceLevel;

        //      System.out.println("Notify.setTraceLevel(" + ai_newTraceLevel + ");");

        l_traceLevel = m_currentTraceLevel;

        m_currentTraceLevel = ai_newTraceLevel;

        return l_traceLevel;
    }

    private boolean isProcessedClass(Class as_class)
    {
        boolean l_retVal=false;
        String ls_className;

        if(as_class.isPrimitive())
        {
            l_retVal = false;
        }
        else
        {
            ls_className = as_class.getName();

            if(ls_className.startsWith("cciij."))
            {
                l_retVal = true;
            }
        }

        return l_retVal;
    }

    private void addDumpMsg(String as_msg)
    {
        //      System.out.println("Adding Dump Message:  " + as_msg);

        m_dataVector.add(as_msg);

        return;
    }

    private void addStringParam(String as_param)
    {
        //      System.out.println("Adding String Param:  " + as_param);

        m_stringVector.add(as_param);

        return;
    }

    private boolean processObject(Object a_obj,boolean a_trace)
    {
        return processObject(null,a_obj,true,a_trace);
    }

    private int currentDepth = 0;

    private boolean processObject(String as_name,Object a_obj,boolean a_initialRun,boolean a_trace)
    {
        //        System.out.println("Notify.processObject(" + as_name + ", " + ((a_obj == null) ? "null" : a_obj.getClass().getName()) + ", " + a_initialRun + ", " + a_trace + ")");

        Class l_class;
        String l_className;
        Method[] l_methodList;
        int i;
        String l_methodName;

        Class[] l_parameters;

        Class l_returnType;

        Object l_returnValue;

        Object[] l_callParamList=null;

        String l_name = new String();
        String l_value = new String();


        currentDepth++;
        if(currentDepth > m_config.getInt("NOTIFY_MAX_OBJECT_DEPTH",5))
        {
            return true;
        }

        try
        {

            //      System.out.println("Notify:processObject.........................................");

            // Initialize the prefix to blank if it is null
            if(as_name == null)
            {
                as_name = new String("");
            }

            if(a_obj == null)
            {
                if(as_name.length() > 0)
                {
                    m_utilList.clear();
                    m_utilList.add(as_name);
                    m_utilList.add("null");

                    if(a_trace)
                    {
                        addDumpMsg(mf.formatTraceMessage(Messages.TM_2S_DATA_OUTPUT,
                                                         m_utilList));
                    }
                    else
                    {
                        addDumpMsg(mf.formatLogMessage(Messages.LM_2S_DATA_OUTPUT,
                                                       m_utilList));
                    }
                }

                currentDepth--;
                return true;
            }

            // Get the class of the object
            l_class = a_obj.getClass();

            // Get the name of the class
            l_className = l_class.getName();

            //      System.out.println("ClassName:  " + l_className);

            if(isProcessedClass(l_class) == false)
            {
                if(a_obj instanceof Throwable)
                {
                    //              System.out.println("YES!!!!!!!!!!!!!!!!!!!!!");
                    Throwable t = (Throwable)a_obj;

                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    t.printStackTrace(pw);
                    //              System.out.println(sw);
                    java.util.StringTokenizer st = new java.util.StringTokenizer(sw.toString(),"\n\r\f");
                    addDumpMsg("  START OF EXCEPTION STACK TRACE");
                    while(st.hasMoreTokens())
                    {
                        addDumpMsg(st.nextToken());
                    }
                    addDumpMsg("  END OF EXCEPTION STACK TRACE");
                }
                else
                {
                    if(a_initialRun)
                    {
                        addStringParam("" + a_obj);
                    }
                    else
                    {
                        m_utilList.clear();
                        m_utilList.add(as_name);
                        m_utilList.add(""+a_obj);

                        if(a_trace)
                        {
                            addDumpMsg(mf.formatTraceMessage(Messages.TM_2S_DATA_OUTPUT,
                                                             m_utilList));
                        }
                        else
                        {
                            addDumpMsg(mf.formatLogMessage(Messages.LM_2S_DATA_OUTPUT,
                                                           m_utilList));
                        }
                    }
                }

                currentDepth--;
                return true;
            }
            else // insert the name/value in the member vars first, then process
            {
                if(as_name.length() > 0)
                {
                    m_utilList.clear();
                    m_utilList.add(as_name);
                    m_utilList.add(""+l_className);

                    if(a_trace)
                    {
                        addDumpMsg(mf.formatTraceMessage(Messages.TM_2S_DATA_OUTPUT,
                                                         m_utilList));
                    }
                    else
                    {
                        addDumpMsg(mf.formatLogMessage(Messages.LM_2S_DATA_OUTPUT,
                                                       m_utilList));
                    }
                }
            }

            l_methodList = l_class.getMethods();

            for(i=0;i<l_methodList.length;i++)
            {
                l_methodName = l_methodList[i].getName();

                // Test to see if the method name meets standards...
                if(((l_methodName.length() > 2)
                    && (l_methodName.charAt(0) == 'i')
                    && (l_methodName.charAt(1) == 's') )
                   || ((l_methodName.length() >3)
                       && (l_methodName.charAt(0) == 'g')
                       && (l_methodName.charAt(1) == 'e')
                       && (l_methodName.charAt(2) == 't'))
                   && (l_methodName.equals("getClass") != true) )
                {

                    // Only run methods that take No parameters
                    l_parameters = l_methodList[i].getParameterTypes();
                    if(l_parameters.length == 0)
                    {

                        // Only run public methods
                        if(Modifier.isPublic(l_methodList[i].getModifiers()))
                        {
                            try
                            {
                                l_returnValue = l_methodList[i].invoke(a_obj,l_callParamList);

                                if(as_name.length() > 0)
                                {
                                    l_name = as_name + ":";
                                }
                                else
                                {
                                    l_name = "";
                                }

                                l_name += l_className + "." + l_methodName + "()";

                                processObject(l_name,l_returnValue,false,a_trace);

                                //                      System.out.println("Method:  " + l_name + " returned:  " + l_value);
                            }
                            catch(Exception e)
                            {
                                System.out.println("Caught an exception:  " + e);
                            }
                        } // if is public
                    }  //    if no parameters
                }  //        if method name meets standards
            }  //            for methods...

            currentDepth--;
            return true;
        }
        catch(RuntimeException rte)
        {
            currentDepth--;
            throw rte;
        }

    }

    // Full Blown Tracing

    public boolean trace(int ai_traceLevel,int ai_traceCode)
    {
        return trace(ai_traceLevel,ai_traceCode,null,null,null,null);
    }

    public boolean trace(int ai_traceLevel,int ai_traceCode,Object a_p1)
    {
        return trace(ai_traceLevel,ai_traceCode,a_p1,null,null,null);
    }

    public boolean trace(int ai_traceLevel,int ai_traceCode,Object a_p1,Object a_p2)
    {
        return trace(ai_traceLevel,ai_traceCode,a_p1,a_p2,null,null);
    }

    public boolean trace(int ai_traceLevel,int ai_traceCode,Object a_p1,Object a_p2,Object a_p3)
    {
        return trace(ai_traceLevel,ai_traceCode,a_p1,a_p2,a_p3,null);
    }

    public boolean trace(int ai_traceLevel,int ai_traceCode,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        if((m_currentTraceLevel & ai_traceCode) == 0)
        {
            return true;
        }

        return processMessage(true,true,ai_traceLevel,ai_traceCode,null,a_p1,a_p2,a_p3,a_p4);
    }

    // Tracing with a message and a level(no code)
    public boolean trace(int level, String msg)
    {
        return trace(level,msg,null,null,null,null);
    }

    public boolean trace(int level, String msg,Object a_p1)
    {
        return trace(level,msg,a_p1,null,null,null);
    }

    public boolean trace(int level,String msg,Object a_p1,Object a_p2)
    {
        return trace(level,msg,a_p1,a_p2,null,null);
    }

    public boolean trace(int level,String msg,Object a_p1,Object a_p2,Object a_p3)
    {
        return trace(level,msg,a_p1,a_p2,a_p3,null);
    }

    public boolean trace(int level,String msg,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        if((m_currentTraceLevel & level)  == 0)
        {
            return true;
        }

        return processMessage(true,true,level,0,msg,a_p1,a_p2,a_p3,a_p4);
    }

    // Tracing with only a message(no level/code)
    public boolean trace(String msg)
    {
        return trace(msg,null,null,null,null);
    }

    public boolean trace(String msg,Object a_p1)
    {
        return trace(msg,a_p1,null,null,null);
    }

    public boolean trace(String msg,Object a_p1,Object a_p2)
    {
        return trace(msg,a_p1,a_p2,null,null);
    }

    public boolean trace(String msg,Object a_p1,Object a_p2,Object a_p3)
    {
        return trace(msg,a_p1,a_p2,a_p3,null);
    }

    public boolean trace(String msg,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        if(m_currentTraceLevel  == 0)
        {
            return true;
        }

        return processMessage(true,true,m_currentTraceLevel,0,msg,a_p1,a_p2,a_p3,a_p4);
    }


    // Trigger notify with all options avail
    public boolean triggerNotify(int ai_errorLevel,int ai_errorCode)
    {
        return triggerNotify(ai_errorLevel,ai_errorCode,null,null,null,null);
    }

    public boolean triggerNotify(int ai_errorLevel,int ai_errorCode,Object a_p1)
    {
        return triggerNotify(ai_errorLevel,ai_errorCode,a_p1,null,null,null);
    }

    public boolean triggerNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2)
    {
        return triggerNotify(ai_errorLevel,ai_errorCode,a_p1,a_p2,null,null);
    }

    public boolean triggerNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2,Object a_p3)
    {
        return triggerNotify(ai_errorLevel,ai_errorCode,a_p1,a_p2,a_p3,null);
    }

    public boolean triggerNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        return processMessage(true,false,ai_errorLevel,ai_errorCode,null,a_p1,a_p2,a_p3,a_p4);
    }


    // Trigger notify with only msg
    public boolean triggerNotify(String msg)
    {
        return triggerNotify(msg,null,null,null,null);
    }

    public boolean triggerNotify(String msg,Object a_p1)
    {
        return triggerNotify(msg,a_p1,null,null,null);
    }

    public boolean triggerNotify(String msg,Object a_p1,Object a_p2)
    {
        return triggerNotify(msg,a_p1,a_p2,null,null);
    }

    public boolean triggerNotify(String msg,Object a_p1,Object a_p2,Object a_p3)
    {
        return triggerNotify(msg,a_p1,a_p2,a_p3,null);
    }

    public boolean triggerNotify(String msg,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        return processMessage(true,false,0,0,msg,a_p1,a_p2,a_p3,a_p4);
    }



    // Throw notify with all options
    public boolean throwNotify(int ai_errorLevel,int ai_errorCode) throws Notify
    {
        return throwNotify(ai_errorLevel,ai_errorCode,null,null,null,null);
    }

    public boolean throwNotify(int ai_errorLevel,int ai_errorCode,Object a_p1) throws Notify
    {
        return throwNotify(ai_errorLevel,ai_errorCode,a_p1,null,null,null);
    }

    public boolean throwNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2) throws Notify
    {
        return throwNotify(ai_errorLevel,ai_errorCode,a_p1,a_p2,null,null);
    }

    public boolean throwNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2,Object a_p3) throws Notify
    {
        return throwNotify(ai_errorLevel,ai_errorCode,a_p1,a_p2,a_p3,null);
    }

    public boolean throwNotify(int ai_errorLevel,int ai_errorCode,Object a_p1,Object a_p2,Object a_p3,Object a_p4) throws Notify
    {
        processMessage(false,false,ai_errorLevel,ai_errorCode,null,a_p1,a_p2,a_p3,a_p4);

        throw this;
    }

    // throwNotify with only msg
    public boolean throwNotify(String msg) throws Notify
    {
        return throwNotify(msg,null,null,null,null);
    }

    public boolean throwNotify(String msg,Object a_p1) throws Notify
    {
        return throwNotify(msg,a_p1,null,null,null);
    }

    public boolean throwNotify(String msg,Object a_p1,Object a_p2) throws Notify
    {
        return throwNotify(msg,a_p1,a_p2,null,null);
    }

    public boolean throwNotify(String msg,Object a_p1,Object a_p2,Object a_p3) throws Notify
    {
        return throwNotify(msg,a_p1,a_p2,a_p3,null);
    }

    public boolean throwNotify(String msg,Object a_p1,Object a_p2,Object a_p3,Object a_p4) throws Notify
    {
        processMessage(false,false,0,0,msg,a_p1,a_p2,a_p3,a_p4);

        throw this;
    }



    private boolean processMessage(boolean a_sendMsg,boolean a_trace,int ai_level,int ai_code,String msg,Object a_p1,Object a_p2,Object a_p3,Object a_p4)
    {
        m_stringVector.clear();
        m_dataVector.clear();

        processObject("",a_p1,true,a_trace);
        processObject("",a_p2,true,a_trace);
        processObject("",a_p3,true,a_trace);
        processObject("",a_p4,true,a_trace);

        //      return sendMessage(mf.formatTraceMessage(ai_traceCode,m_stringVector));
        if(a_sendMsg)
        {
            if(a_trace)
            {
                sendMessage(((msg == null) ? mf.formatTraceMessage(ai_code,m_stringVector) : msg),
                            ai_level,
                            ai_code,
                            a_trace);
            }
            else
            {
                sendMessage(((msg == null) ? mf.formatLogMessage(ai_code,m_stringVector) : msg),
                            ai_level,
                            ai_code,
                            a_trace);
            }
        }

        return true;
    }

    private boolean sendMessage(String as_message,
                                int ai_level,
                                int ai_code,
                                boolean a_trace)
    {
        boolean l_mainSuccess=false;

        getStackInfo();

        l_mainSuccess = sendSingleMessage(as_message,ai_level,ai_code,a_trace);

        if(l_mainSuccess && (m_dataVector.isEmpty() == false))
        {
            Enumeration l_enum;

            l_enum = m_dataVector.elements();

            while(l_enum.hasMoreElements())
            {
                if(sendSingleMessage((String)l_enum.nextElement(),ai_level,ai_code,a_trace) == false)
                {
                    l_mainSuccess = false;
                    break;
                }
            }
        }

        return l_mainSuccess;
    }

    private boolean sendSingleMessage(String as_message,
                                      int ai_level,
                                      int ai_code,
                                      boolean a_trace)
    {
        //      System.out.println("Transmitting:  |" + as_message + "|");
        m_notifyMessage.sendMessage(m_serviceName,as_message,ai_level,ai_code,a_trace);
        return true;
    }

    private boolean getStackInfo()
    {
        StringWriter l_sWriter = new StringWriter();

        PrintWriter l_pWriter = new PrintWriter(l_sWriter,true);

        String l_stackString;
        String l_line;
        StringTokenizer l_lines;
        int l_currentLine=0;
        int l_currentIndex=0;
        int l_methodName=0;
        int l_className=0;
        int l_fileName=0;
        int l_lineNumber=0;
        int l_end=0;
        String ls_methodName;
        String ls_className;
        String ls_fileName;
        String ls_lineNumber;

        boolean l_foundInfo=false;

        try
        {
            Exception e = new Exception("Testing");
            e.printStackTrace(l_pWriter);

            l_stackString = l_sWriter.toString();

            //      System.out.println("Captured String:  " + l_stackString);

            l_lines = new StringTokenizer(l_stackString,"\n\r\f");

            while(l_lines.hasMoreTokens())
            {
                l_line = l_lines.nextToken();

                if(l_currentLine >= 2)
                {
                    l_currentIndex = l_line.lastIndexOf('(');

                    l_methodName = l_line.lastIndexOf('.',l_currentIndex - 1) + 1;

                    l_className = l_line.lastIndexOf(' ',l_methodName) + 1;

                    l_fileName = l_currentIndex + 1;

                    ls_methodName = l_line.substring(l_methodName,l_fileName - 1);
                    ls_className  = l_line.substring(l_className,l_methodName - 1);

                    if((ls_className.endsWith("Notify"))
                       //                     && ((ls_methodName.startsWith("trace"))
                       //                         || (ls_methodName.startsWith("trigger"))
                       //                         || (ls_methodName.startsWith("throw")))
                       )
                    {
                        //                      System.out.println("Ignoring Notify Methods in the stack trace");
                        continue;
                    }

                    if((ls_className.endsWith("BusinessActionBase"))
                       && ((ls_methodName.startsWith("trace"))
                           || (ls_methodName.startsWith("notify"))))
                    {
                        //                      System.out.println("Ignoring the BABase trace/notify methods in the stack trace");
                        continue;
                    }


                    l_lineNumber = l_line.indexOf(':',l_fileName) + 1;

                    l_end = l_line.indexOf(')',l_lineNumber);

                    ls_fileName   = l_line.substring(l_fileName,l_lineNumber - 1);
                    ls_lineNumber = l_line.substring(l_lineNumber,l_end);

                    //                          System.out.println("Class Name:      |" + ls_className + "|");
                    //                          System.out.println("Method Name:     |" + ls_methodName + "|");
                    //                          System.out.println("FileName:        |" + ls_fileName + "|");
                    //                          System.out.println("Line Number:     |" + ls_lineNumber + "|");

                    m_notifyMessage.setLocationInfo(ls_className,ls_methodName,ls_fileName,ls_lineNumber);
                    break;
                }

                l_currentLine++;
            }

            return true;
        }
        catch(Exception e)
        {
            m_notifyMessage.setLocationInfo("Unknown","Unknown","Unknown","0");
        }

        return true;
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
    final public String formatError(String errorNmbr, String errorMsg, Object BusnActClass) {
        String formattedErrMsg = null;
        SimpleDateFormat simDtFmt = null;
        String classNm = null;
        // Get formatted date.
        simDtFmt = getFormattedDt();
        // Get the class name
        if (BusnActClass == null) {
            classNm = "UNAVAILABLE";
        } else {
            classNm = BusnActClass.getClass().getName();
        }

        if (errorNmbr == null) {
            errorNmbr = "000000";
        }
        // Determine the severity contained in the errorNmbr value
        determineSeverity(errorNmbr);
        if (errorMsg == null) {
            errorMsg = "Unknown Error";
        }

        // Format the error message.
        formattedErrMsg = formatErrMsg(errorNmbr,classNm,errorMsg);
        return formattedErrMsg;
    }

    /**
     * Method:       BusinessActionBase.getFormattedDt()
     * Description:  Get current date/time and format using parameters
     *               contained in m_simpleDateFormat, for the local time zone
     *               specified in m_localTimeZone.
     *
     * @author       Ed McAleer
     * @version 1.0
     *
     * @return       SimpleDateFormat
     */
    private SimpleDateFormat getFormattedDt(){
        m_simpDateFmt = new SimpleDateFormat(m_simpleDateFormatStr);
        m_simpDateFmt.setTimeZone(TimeZone.getTimeZone(m_localTimeZone));
        return m_simpDateFmt;
    }

    /**
     * Method:       BusinessActionBase.determineSeverity(String errorMsg)
     * Description:
     *
     * @author       Ed McAleer
     * @version 1.0
     *
     * @param        errorNmbr
     *
     * @return       void
     */
    private void determineSeverity(String errorNmbr) {

        char severity;
        int tmpErrNumb = 0;

        severity = errorNmbr.charAt(0);

        tmpErrNumb = (m_severityMask & severity);

        if (tmpErrNumb == m_severityFatal)
        {
            m_severity = "FATAL";
        }
        else if (tmpErrNumb == m_severityError) {
            m_severity = "ERROR";
        }
        else if (tmpErrNumb == m_severityWarn) {
            m_severity = "WARN";
        }
        else if (tmpErrNumb == m_severityInfo) {
            m_severity = "INFO";
        }
        else {
            m_severity = "UNKNOWN";
        }
    }

    /**
     * Method:       BusinessActionBase.formatErrMsg()
     * Description:  Get current date/time and format using parameters
     *               contained in m_simpleDateFormat.
     *
     * @author       Ed McAleer
     * @version 1.0
     *
     * @param        errNumb - error description number
     * @param        classNm - class name that detected/reported the error
     * @param        errMsg - error message describing the error
     *
     * @return       formattedErrMsg - formated error message string.
     */
    private String formatErrMsg(String errorNmbr, String classNm, String errorMsg) {
        String formattedErrMsg = null;
        Date currentDtTm = new Date();
        String prefix = null;
        String suffix = null;
        String tmpMaxDisplayLength = null;
        int maxDisplayLength = 0;
        String appName = "CCII";
        if (m_config == null)
            m_config = new Config();
        try
        {
            appName = m_config.getValue("APPLICATION_NAME");
        }
        catch (Exception e)
        {
            appName = "CCII";
            System.out.println("Unable to read APPPLICATION_NAME from config file");
        }
        formattedErrMsg = (m_beginErrorLine + m_severity + m_seperator + "APPLICATION" + m_seperator);
        SimpleDateFormat simpleDateFormat = getFormattedDt();
        formattedErrMsg = formattedErrMsg + simpleDateFormat.format(currentDtTm);
        formattedErrMsg = formattedErrMsg + (m_seperator + appName + m_seperator + "JAVA" + m_seperator + classNm);
        formattedErrMsg = formattedErrMsg + (m_seperator + errorNmbr + " - " + errorMsg + "\n");
        return formattedErrMsg;
    }


    public static void main(String[] args)
    {

        CCIIState state = new CCIIState();
        RPBScan scan = new RPBScan();

        scan.setAirbillNumber("40012345678");

        state.setScan(scan);

        Notify n = new Notify();

        //      System.out.println("Calling Notify.trace()");
        n.trace(Notify.criticalCodeEntryExit,Messages.TM_4S_CHECKPOINT,"TESTMSG1","TST2",state);

        try
        {
            throw new RuntimeException("Test Exception");
        }
        catch(Exception e)
        {
            n.triggerNotify(Notify.errorLevelWarning,Messages.LM_4S_WARN_MESSAGE,"Notify.main()",state,e);
        }

        //      n.processObject("Test",s,true,false);

        return;
    }
}
