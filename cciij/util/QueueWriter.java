package cciij.util;


import javax.jms.*;
import java.util.*;
import java.io.*;
import javax.naming.*;

import com.fedex.css.ruleprocessor.State;

public final class QueueWriter
{
    private Map m_queueMap = new TreeMap();

    public QueueWriter()
    {
    }

    public boolean putOnQueue(String queueName,String locationCode,State state)
    {
	String lookName = locationCode + "." + queueName;

	QueueWriterConnection conn = null;

	try
	{
	    if(m_queueMap.containsKey(lookName))
	    {
		conn = (QueueWriterConnection)m_queueMap.get(lookName);
	    }
	    else
	    {
		conn = new QueueWriterConnection(queueName,locationCode);
		m_queueMap.put(lookName,conn);
	    }
	    
	    conn.setState(state);
	    conn.send();
	}
	catch(Exception e)
	{
	    System.out.println("Failed to enqueue the message:  " + e);
	    e.printStackTrace(System.out);
	    return false;
	}

	return true;
    }

    private class QueueWriterConnection
    {
	private QueueConnectionFactory m_qconFactory;
	private QueueConnection m_qcon;
	private QueueSession m_qsession;
	private QueueSender m_qsender;
	private Queue m_queue;
	private ObjectMessage m_msg;

	

	public QueueWriterConnection(String queueName,String locationCode) throws Exception
	{
	    rmtc.util.Config cfg = new rmtc.util.Config(queueName);
	    cfg.setLocationCode(locationCode);

	    InitialContext ctx = getInitialContext(cfg.getValue("WEB_SERVER_ADDRESS"));
	    m_qconFactory = (QueueConnectionFactory) ctx.lookup(cfg.getValue("JMS_CONNECTION_FACTORY"));
	    m_qcon = m_qconFactory.createQueueConnection();
	    m_qsession = m_qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	    m_queue = (Queue) ctx.lookup(cfg.getValue("QUEUE_NAME"));
	    m_qsender = m_qsession.createSender(m_queue);
	    m_msg = m_qsession.createObjectMessage();
	    m_qcon.start();	    
	    ctx.close();
	}


	public void setState(State state) throws Exception
	{
	    m_msg.setObject(state);
	}

	public void send() throws Exception
	{
	    m_qsender.send(m_msg);
	}

	private InitialContext getInitialContext(String webServerAddress)  throws Exception 
	{
	    Hashtable env = new Hashtable();
	    env.put(Context.INITIAL_CONTEXT_FACTORY,
		    "weblogic.jndi.WLInitialContextFactory");
	    
	    env.put(Context.PROVIDER_URL, "t3://" + webServerAddress);
	    
	    try 
	    {
		InitialContext initialContext = new InitialContext(env);
		return initialContext;
	    }
	    catch(Exception e) 
	    {
		System.out.println(e);
		e.printStackTrace(System.out);
		throw e;
	    }
	}


	protected void finalize() throws Throwable 
	{
	    if (m_qsender != null)
	    {
		m_qsender.close();
	    }

	    if (m_qsession != null)
	    {
		m_qsession.close();
	    }

	    if (m_qcon != null)
	    {
		m_qcon.close();
	    }
	}

    }

    public static void main(String args[])
    {
	QueueWriter qw = new QueueWriter();

	cciij.cciidata.CCIIState state = new cciij.cciidata.CCIIState();
	state.getScan().setLocationCode("NRT");
	
	qw.putOnQueue("TestQueue","NRT",state);
    }
}
