package cciij.businessActions;

/**
 * Title:        PostMQMessage
 * Description:  
 *              
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Kathy Smathers
 * @version 1.0
 *
 * NOTE: as of November 2005 this routine supports MQ and JMS queues
 *
 * @throws       
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   03/04/04    Kathy Smathers - Initial creation
 *   11/09/05    Gary Rockwood  - Added the JMS queue interface
 */

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciicosmos.Cciicosmos;
import cciicosmos.cosmosasn.*;
import java.text.*;
import java.util.*;
import java.io.*;
import com.oss.asn1.*;
import com.oss.util.*;


public abstract class PostMQMessage extends BusinessActionBase implements PostMessageInterface
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostMQMessage.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    private MQQueue m_mqQueue = null;
    private UploadJMSQueueWriter m_jmsQueue = null;
    private UploadJMSTopicWriter m_topicQueue = null;
    private String m_queueName = "";                        
    protected byte[] m_outboundEncodedMsg = null;  
    private UploadCategoryDef m_uploadCategoryDef;
    private  String m_uploadActive = "";
    protected String  m_format = "";
    protected String  m_transactionType = "";
    private String  m_systemLevel = "";
    private String  m_cciiReturnQueueName = "";
    private String  m_uploadMethod = "";
    private  SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MMddHHmmss"); // MonthDayHourMinuteSecond


  public PostMQMessage() throws Exception
  { 
    traceLog("PostMQMessage","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) 
		   throws Exception
  {
    return state;
  } 

  public void initialize(UploadCategoryDef uploadCategoryDef, String system, String mode) throws Exception
  { 
    super.initialize();
    m_uploadCategoryDef = uploadCategoryDef;
    m_uploadActive = readConfigVariableString("UPLOAD_ACTIVE");
    System.out.println("PostMQMessage, UPLOAD_ACTIVE=" + m_uploadActive);
    if (m_uploadActive.equals("Y"))
    {
      // Determine which level of system is being accessed
      m_systemLevel = readConfigVariableString("SYSTEM_LEVEL");

      // Determine if MQ queue or JMS queue
//    For production the upload method will effect all scans based on SCAN_UPLOAD_METHOD
      m_uploadMethod = readConfigVariableString("SCAN_UPLOAD_METHOD");

      System.out.println("PostMQMessage, ScanUpload vie " + m_uploadMethod);

      if (m_uploadMethod.equals("MQ"))
      {     
        try
        {
          if ( m_mqQueue == null )
          {
            traceLog("PostMQMessage","Initializing MQQueue object");
            traceLog("EncodeAndUpload","Initializing m_cciiQueueManagerName: " + 
	               m_uploadCategoryDef.getQueueContainerName());
            traceLog("EncodeAndUpload","Initializing m_cciiQueueName: " +
	               m_uploadCategoryDef.getQueueName()); 
            m_mqQueue = new MQQueue(m_uploadCategoryDef.getQueueContainerName(),
                                    m_uploadCategoryDef.getQueueName(),
				                    system, mode);
          }
        }
        catch (Exception ex)
        {
          System.out.println("Caught MQQueue Object creation error " + ex);
          ex.printStackTrace(System.out);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
			  	  "MQQueue create failed");
          throw cciiEx;
        }
      }

      if (m_uploadMethod.equals("JMS"))
      {
        try
        {
          if ( m_jmsQueue == null )
          {
              m_queueName = m_uploadCategoryDef.getQueueName();
            m_jmsQueue = new UploadJMSQueueWriter(m_uploadCategoryDef.getQueueContainerName(),
                                             m_uploadCategoryDef.getQueueName());
          }
        }
        catch (Exception ex)
        {
          System.out.println("Caught JMSQueue Object creation error " + ex);
          ex.printStackTrace(System.out);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                  "JMSQueue create failed");
          throw cciiEx;
        }
      } else if (m_uploadMethod.equals("TOPIC"))
      {
        try
        {
          if ( m_jmsQueue == null )
          {
              m_queueName = m_uploadCategoryDef.getQueueName();
            m_topicQueue = new UploadJMSTopicWriter(m_uploadCategoryDef.getQueueContainerName(),
                                             m_uploadCategoryDef.getQueueName());
          }
        }
        catch (Exception ex)
        {
          System.out.println("Caught JMSQueue Object creation error " + ex);
          ex.printStackTrace(System.out);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                  "JMSQueue create failed");
          throw cciiEx;
        }
      }

    }
  }

  public void createMessage(CCIIState state, DatabaseBean dbConnection, 
                              Upload upload) throws Exception

  { 
      Date l_convertDt = new Date(state.getScan().getSysDateTime());
      String l_dateTime = dateTimeFormat.format(l_convertDt);
      if (m_uploadActive.equals("Y") && m_outboundEncodedMsg != null)
      {
        if (m_uploadMethod.equals("MQ"))
        {
          try
          {
            m_mqQueue.putBytes(m_outboundEncodedMsg,
                             state.getScan().getUserLogon() + 
                             state.getCurrentScan().getScanTypeCode() + 
                             l_dateTime,
                             m_format,
                             state.getScan().getUserLogon(),
                             m_transactionType,
                             m_cciiReturnQueueName,
                             "CCII");
          }
          catch (Exception ex)
          {
            System.out.println("Caught MQ Put error " + ex);
            ex.printStackTrace(System.out);
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
				      "MQ Put failed");
            throw cciiEx;
          }
        }

        if (m_uploadMethod.equals("JMS"))
        {
          try
          {
              m_jmsQueue.putOnQueue(m_queueName,state.getScan().getLocationCode(),m_outboundEncodedMsg);
/*            m_jmsQueue.putOnQueueWithHeader(state.getScan().getLocationCode(),   // Location
                                            "CCII",                              // Application
                                            m_format,                            // Format of Message
                                            state.getScan().getUserLogon() +
                                            state.getCurrentScan().getScanTypeCode() +
                                            l_dateTime,                          // Appl Identifier
                                            m_transactionType,                   // Transaction Identifier
                                            m_outboundEncodedMsg);               // Message, either ASN1 for IMS
                                            */
          }
          catch (Exception ex)
          {
            System.out.println("Caught JMS putOnQueueWiothHeader error " + ex);
            ex.printStackTrace(System.out);
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                      "JMS putOnQueueWithHeader failed");
            throw cciiEx;
          }
        } else if (m_uploadMethod.equals("TOPIC"))
        {
          try
          {
              m_topicQueue.putOnQueue(m_queueName,state.getScan().getLocationCode(),m_outboundEncodedMsg);
/*            m_jmsQueue.putOnQueueWithHeader(state.getScan().getLocationCode(),   // Location
                                            "CCII",                              // Application
                                            m_format,                            // Format of Message
                                            state.getScan().getUserLogon() +
                                            state.getCurrentScan().getScanTypeCode() +
                                            l_dateTime,                          // Appl Identifier
                                            m_transactionType,                   // Transaction Identifier
                                            m_outboundEncodedMsg);               // Message, either ASN1 for IMS
                                            */
          }
          catch (Exception ex)
          {
            System.out.println("Caught JMS putOnQueueWiothHeader error " + ex);
            ex.printStackTrace(System.out);
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                      "JMS putOnQueueWithHeader failed");
            throw cciiEx;
          }
        } 

      }
  }


  protected void finalize() throws Throwable
  {
    if ( m_mqQueue != null )
    {
      m_mqQueue.closeQueue();
    }
  }
}

