package cciij.util;

// Imports
import javax.jms.BytesMessage;
import javax.jms.QueueConnection;
//import cciij.util.ByteQueueWriter;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.naming.InitialContext;
import java.util.Hashtable;

import rmtc.util.Config;

public final class ByteQueueWriter 
{
    // Fields
    private Map m_queueMap;

    protected String m_connectionFactory = "";
    protected String m_queueName = "";
    protected String m_webAddress = "";

    // Constructors
    public ByteQueueWriter() 
    { 
        m_queueMap = new TreeMap();
    }

    public ByteQueueWriter(String connectionFactory, String queueName) 
    {
        m_queueMap = new TreeMap();

        m_connectionFactory = connectionFactory;
        m_queueName = queueName;
        System.out.println("ByteQueueWriter, connectionFactory " + m_connectionFactory);
        System.out.println("ByteQueueWriter, queueName " + m_queueName);
    }

    // Methods
    public boolean putOnQueue(String queueName, String locationCode, byte msg[]) 
    { 
        String lookName = locationCode + "." + queueName;
        ByteQueueWriterConnection conn = null;

        try
        {
            if (m_queueMap.containsKey(lookName))
            {
                conn = (ByteQueueWriterConnection)m_queueMap.get(lookName);
            }
            else
            {
                conn = new ByteQueueWriterConnection(queueName, locationCode);
                m_queueMap.put(lookName, conn);
            }

            conn.setBytes(msg);
            conn.send();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Failed to enqueue the message:  " + e);
            e.printStackTrace(System.out);
            return false;
        }
    }


    public boolean putOnQueueWithHeader(String locationCode, 
                                        String applicationName,
                                        String messageFormat,
                                        String messageIdentifier,
                                        String transactionName,
                                        byte msg[])
    {
        String lookName = locationCode + "." + m_queueName;
        ByteQueueWriterConnection conn = null;

        try
        {
            if (m_queueMap.containsKey(lookName))
            {
                conn = (ByteQueueWriterConnection)m_queueMap.get(lookName);
            }
            else
            {
                conn = new ByteQueueWriterConnection(locationCode);
                m_queueMap.put(lookName, conn);
            }
 
            conn.setHeader(applicationName, messageFormat, messageIdentifier, transactionName);
            conn.setBytes(msg);
            conn.send();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Failed to enqueue the message:  " + e);
            e.printStackTrace(System.out);
            return false;
        }
    }

    // Inner classes
    private class ByteQueueWriterConnection 
    {
        // Fields
        private QueueConnectionFactory m_qconFactory;
        private QueueConnection m_qcon;
        private QueueSession m_qsession;
        private QueueSender m_qsender;
        private Queue m_queue;
        private BytesMessage m_msg;


        // Constructors
        public ByteQueueWriterConnection(String queueName, String locationCode) throws Exception 
        {
            Config cfg = new Config(queueName);
            cfg.setLocationCode(locationCode);
            m_connectionFactory = cfg.getValue("JMS_CONNECTION_FACTORY");
            m_queueName = cfg.getValue("QUEUE_NAME");
            m_webAddress = cfg.getValue("WEB_SERVER_ADDRESS");
            SetUpQueue();
        }

        // Constructors
        public ByteQueueWriterConnection(String locationCode) throws Exception
        {
            Config cfg = new Config(m_queueName);
            cfg.setLocationCode(locationCode);
            m_webAddress = cfg.getValue("WEB_SERVER_ADDRESS");
            SetUpQueue();
        }

        private void SetUpQueue() throws Exception
        {
            InitialContext ctx = getInitialContext(m_webAddress);
            m_qconFactory = (QueueConnectionFactory)ctx.lookup(m_connectionFactory);
            m_qcon = m_qconFactory.createQueueConnection();
            m_qsession = m_qcon.createQueueSession(false, 1);
            m_queue = (Queue)ctx.lookup(m_queueName);
            m_qsender = m_qsession.createSender(m_queue);
            m_msg = m_qsession.createBytesMessage();
            m_qcon.start();
            ctx.close();
        }

        // Methods
        public void setHeader(String applicationName, 
                              String messageFormat, 
                              String messageIdentifier, 
                              String transactionName) throws Exception
        {
            m_msg.setStringProperty("TransactionName", transactionName);
            m_msg.setStringProperty("MsgSource", applicationName);
            m_msg.setStringProperty("SourceType", applicationName);
            m_msg.setStringProperty("MsgCharCd", messageFormat);
            m_msg.setStringProperty("MsgUser", messageIdentifier);
            m_msg.setStringProperty("DeviceType", messageIdentifier);
            m_msg.setStringProperty("DeviceId", messageIdentifier);
        }
 
        public void setBytes(byte msg[]) throws Exception 
        { 
            m_msg.writeBytes(msg);
        }

        public void send() throws Exception 
        { 
            m_qsender.send(m_msg);
            m_msg = null;
            m_msg = m_qsession.createBytesMessage();
            System.out.println("ByteQueueWriter, Message sent");     
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
                m_qsender.close();
            if (m_qsession != null)
                m_qsession.close();
            if (m_qcon != null)
                m_qcon.close();
        }
    }
}
