package cciij.businessActions;

import java.io.ByteArrayOutputStream;
// Imports
import javax.jms.BytesMessage;
import javax.jms.QueueConnection;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.naming.InitialContext;
import java.util.Hashtable;

import cciij.util.CCIILogException;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.TreeMap;

/**
 * Title:        JMSByteMessagePushBase<br>
 * Description:  Base class for business actions that need
 *               to write to a JMS queue.
 * Copyright:    Copyright (c) 2004<br>
 * Company:      FedEx<br>
 * Config values used:<br>
 * <UL>
 *   <LI>WEB_SERVER_ADDRESS
 *   <LI>JMS_CONNECTION_FACTORY
 *   <LI>JMS_QUEUE_NAME
 * </UL>
 * <br>
 * @author       Joey Cline
 * @version 1.0
 * <br>
 * <br>
 * Modification History:<br>
 *   <UL>
 *     <LI>Date: 2004/08/28
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Initial release
 *         </UL>
 *       </UL>
 *   </UL>
 *
 */

public abstract class JMSByteMessagePushBase extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: JMSByteMessagePushBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  // Fields
  private QueueConnection m_qcon;
  private QueueSession m_qsession;
  private QueueSender m_qsender;
  private BytesMessage m_msg;


  /**
   * Default constructor does nothing
   */
  public JMSByteMessagePushBase ()
  throws Exception
  {
    traceLog("JMSByteMessagePushBase","In Constructor");
  }

  /**
   * Pass the group name to this constructor
   */
  public JMSByteMessagePushBase (String group)
  throws Exception
  {
    super(group);
    traceLog("JMSByteMessagePushBase","In Constructor with " + group);
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();

    InitialContext ctx = getInitialContext(readConfigVariableString("WEB_SERVER_ADDRESS"));
    QueueConnectionFactory qconFactory =
        (QueueConnectionFactory)ctx.lookup(readConfigVariableString("JMS_CONNECTION_FACTORY"));
    m_qcon = qconFactory.createQueueConnection();
    m_qsession = m_qcon.createQueueSession(false, 1);
    Queue queue = (Queue)ctx.lookup(readConfigVariableString("JMS_QUEUE_NAME"));
    m_qsender = m_qsession.createSender(queue);
    m_msg = m_qsession.createBytesMessage();
    m_qcon.start();
    ctx.close();
  }

  /**
   * Call this method with your encoded byte message to put on the queue.
   */
  public final boolean pushToQueue(byte msg[])
  {
    try
    {
      setBytes(msg);
      send();
      return true;
    }
    catch (Exception e)
    {
      System.out.println("Failed to enqueue the message: msg = [" + msg + "]\nException:" + e);
      e.printStackTrace(System.out);
      return false;
    }
  }

  private void setBytes(byte msg[]) throws Exception
  {
    System.out.println("ByteQueueWriterConnection.setBytes() with msg of length:  " + msg.length);
    m_msg.writeBytes(msg);
  }

  private void send() throws Exception
  {
    System.out.println("ByteQueueWriterConnection.send():  Send the message to the queue");
    m_qsender.send(m_msg);
    m_msg = null;
    m_msg = m_qsession.createBytesMessage();
  }

  private InitialContext getInitialContext(String webServerAddress) throws Exception
  {
    InitialContext initialContext;
    Hashtable env = new Hashtable();
    env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
    env.put("java.naming.provider.url", "t3://" + webServerAddress);
    try
    {
      initialContext = new InitialContext(env);
      return initialContext;
    }
    catch (Exception e)
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


