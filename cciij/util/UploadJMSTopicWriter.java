/*
 * Created on Feb 28, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.util;
import javax.jms.BytesMessage;
import javax.jms.QueueConnection;
//    import cciij.util.ByteQueueWriter;
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
//    import cciij.util.ByteQueueWriter.ByteQueueWriterConnection;

import com.tibco.tibjms.*;

import javax.jms.*;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UploadJMSTopicWriter {
    // add member viaribles 
    private Map m_queueMap;

    protected String m_connectionFactory = "";
    protected String m_queueName = "";
    protected String m_webAddress = "";
    
    public UploadJMSTopicWriter() {
        m_queueMap = new TreeMap();
    }

    public UploadJMSTopicWriter(String connectionFactory, String queueName) {
        m_queueMap = new TreeMap();
        m_connectionFactory = connectionFactory;
        m_queueName = queueName;
    }
    
    public boolean putOnQueue(String queueName, String locationCode, byte msg[]) 
    { 
        String lookName = locationCode + "." + queueName;
        UploadQueueWriterConnection conn = null;

        try
        {
            if (m_queueMap.containsKey(lookName))
            {
                conn = (UploadQueueWriterConnection)m_queueMap.get(lookName);
            }
            else
            {
                conn = new UploadQueueWriterConnection(m_connectionFactory,m_queueName, locationCode);
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
    
    // Inner classes
    private class UploadQueueWriterConnection 
    {
        // Fields
        private QueueConnectionFactory m_qconFactory;
        private QueueConnection m_qcon;
        private QueueSession m_qsession;
        private QueueSender m_qsender;
        private Queue m_queue;
        private BytesMessage m_msg;
        private String m_serverURL;
        private String m_queueName;
        private String m_locationCode;
        javax.jms.TopicPublisher publisher ;

        // Constructors
        public UploadQueueWriterConnection(String serverURL, String queueName, String locationCode) throws Exception 
        {
            m_serverURL = serverURL;
            m_queueName = queueName;
            m_locationCode = locationCode;
            SetUpQueue();
        }


        private void SetUpQueue() throws Exception
        {
            javax.jms.TopicConnectionFactory factory = new com.tibco.tibjms.TibjmsTopicConnectionFactory(m_serverURL);
            javax.jms.TopicConnection connection = factory.createTopicConnection("","");
            TopicSession session = connection.createTopicSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);
            /*
            * Use createTopic() to enable publishing into dynamic topics.
            */
            javax.jms.Topic topic = session.createTopic(m_queueName);
            m_msg = session.createBytesMessage();
            publisher = session.createPublisher(topic);
            
        }

        // Methods
        public void setBytes(byte msg[]) throws Exception 
        { 
            m_msg.writeBytes(msg);
         
            //m_msg.writeBytes(msg);
        }

        public void send() throws Exception 
        { 
            //m_qsender.send(m_msg);
            publisher.publish(m_msg);
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
