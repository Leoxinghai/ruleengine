//*************************************************************************
//
// Filename: NotifyMessage.C
//
// Description:  implementation of the java NotifyMessage Class
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/util/NotifyMessage.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:20 $
//
// Modification History:
//
//   07/23/01  Michael Roderick Commented
//
//*************************************************************************


package cciij.util;

import java.util.*;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.io.PrintStream;
import java.io.File;
import rmtc.util.Config;

class NotifyMessage
{
    private String ms_message="";

    private String ms_className="";
    private String ms_methodName="";
    private String ms_fileName="";
    private int    mi_lineNumber=0;

    private String ms_serviceName="";

    private Date m_createTime;

    private File m_fTrace = null;
    private File m_fNotify = null;

    private FileOutputStream m_fileTrace = null;
    private FileOutputStream m_fileNotify = null;

    private PrintStream m_trace = System.out;
    private PrintStream m_notify = System.err;

    private boolean m_traceSystemOut = false;
    private boolean m_notifySystemErr = false;

    private static int m_deleteCount = 1;
    private int m_myDeleteCount = 0;

    Config m_config = new Config("notifyManager");

    public NotifyMessage()
    {
	init("UNKNOWN");
    }

    public NotifyMessage(String as_serviceName)
    {
	init(as_serviceName);
    }

    public void setServiceName(String as_serviceName)
    {
	ms_serviceName = as_serviceName;
    }

    private void init(String as_serviceName)
    {
	setServiceName(as_serviceName);

	m_createTime = new Date();

	m_config.setLocationCode("ALL");

	ensureOutputStreamValidity();

	return;
    }

    private void ensureOutputStreamValidity()
    {
	//	System.out.println("Notify.ensureOutputStreamValidity()");

	try
	{
	    if(((m_fTrace != null) && (m_fTrace.exists() == false))
	       || ((m_fNotify != null) && (m_fNotify.exists() == false)))
	    {
		m_deleteCount++;
	    }
	    if(m_deleteCount > m_myDeleteCount)
	    {
		openLogFiles();
		m_myDeleteCount++;
	    }
	}
	catch(Exception e)
	{
	    //	    System.out.println("NotifyMessage.ensureOutputStreamValidity caught exception:  " + e);
	    //	    e.printStackTrace(System.out);
	    openLogFiles();  // last ditch attempt
	}
    }

    private void openLogFiles()
    {
	//	System.out.println("Notify.openLogFiles()");

	String traceFileName = m_config.getValue("TRACE_LOG_FILE");
	String notifyFileName = m_config.getValue("DEFAULT_LOG_FILE");

	m_traceSystemOut = true;
	if(traceFileName != null)
	{
	    try
	    {
		System.out.println("Opening Trace Log:  " + traceFileName);
		m_fTrace = new File(traceFileName);
		m_fileTrace = new FileOutputStream(m_fTrace.getPath(),true);
		m_trace = new PrintStream(m_fileTrace);
		m_trace.println("");
		m_trace.println("           Opening File:  " + m_fTrace.getPath() + " @ " + new Date());
		m_trace.println("");
		m_traceSystemOut = false;
	    }
	    catch(Exception e)
	    {
		;  // Ignore it
	    }
	}

	if(m_traceSystemOut)
	{
	    m_fTrace = null;
	    m_fileTrace = null;
	    m_trace = System.out;
	}

	m_notifySystemErr = true;
	if(notifyFileName != null)
	{
	    try
	    {
		System.out.println("Opeining Notify Log:  " + notifyFileName);
		m_fNotify = new File(notifyFileName);
		m_fileNotify = new FileOutputStream(m_fNotify.getPath(),true);
		m_notify = new PrintStream(m_fileNotify);
		m_notify.println("");
		m_notify.println("           Opening File:  " + m_fTrace.getPath() + " @ " + new Date());
		m_notify.println("");
		m_notifySystemErr = false;
	    }
	    catch(Exception e)
	    {
		;  // Ignore it
	    }
	}

	if(m_notifySystemErr)
	{
	    m_fNotify = null;
	    m_fileNotify = null;
	    m_notify = System.err;
	}
    }
	
    public void setLocationInfo(String as_className,
				String as_methodName,
				String as_fileName,
				String as_lineNumber)
    {
	try
	{
	    setLocationInfo(as_className,
			    as_methodName,
			    as_fileName,
			    Integer.parseInt(as_lineNumber));
	}
	catch(NumberFormatException e)
	{
	    setLocationInfo(as_className,
			    as_methodName,
			    as_fileName,
			    0);
	}

	return;
    }

    public void setLocationInfo(String as_className,
				String as_methodName,
				String as_fileName,
				int    ai_lineNumber)
    {
	ms_className = as_className;
	ms_methodName = as_methodName;
	ms_fileName = as_fileName;
	mi_lineNumber = ai_lineNumber;

	return;
    }
    
    public synchronized boolean sendMessage(String serviceName,String as_message,int ai_level,int ai_code,boolean a_trace)
    {
	//	System.out.println("sendMessage(" + as_message + ", " + ai_level + ", " + ai_code + ", " + a_trace + ");");
	// Here we send the message to notifyManager
	Date l_notifyTime = new Date();

	String ls_message;

	ensureOutputStreamValidity();

	ls_message = new String(serviceName
				+ " "
				+ ai_level
				+ " "
				+ ai_code
				+ " "
				+ ms_fileName
				+ " "
				+ mi_lineNumber
				+ " "
				+ l_notifyTime.toString()
				+ " "
				+ as_message);

	if(a_trace)
	{
	    m_trace.println(ls_message);
	}
	else
	{
	    m_notify.println(ls_message);
	}

	return true;
    }



}
