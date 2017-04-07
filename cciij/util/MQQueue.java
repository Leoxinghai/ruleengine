package cciij.util;

/**
 * Title:        MQ Queue
 * Description:  Post messages to an IBM defined MQ
 *     NOTE:  This routine is patterened after the MQQueue.java routine used
 *            by the CDD project the author is Dan Krucoff
 *
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 *
 * Modification History:
 *   02/26/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import java.util.*;
import java.io.*;
import java.io.Serializable;
import com.ibm.mq.*;            // Include the MQSeries classes for Java package
import rmtc.util.Config;


public class MQQueue 
{

  private static final String m_whatVersion = "@(#) $RCSfile: MQQueue.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";

  protected Notify m_notify = null;

  private String qManager = null;      // define name of Que Manager to connect to
  private String qName = null;         // define name of Que to connect to
  private String qReply = null;

  private MQQueueManager qMgr;         // define a queue manager object
  com.ibm.mq.MQQueue theQueue;
    rmtc.util.Config m_config;


  /**
   * Constructor - sets configuration values and initializes the queue
   * @param mqQManagerName String with the MQ Queue Manager name
   * @param myQueueName  String with the MQ Queue name
   *
   * This open uses the default mode of Input/Output
   */
  public MQQueue(String mqQManagerName, String mqQueueName) throws Exception      // Use MQ defaults
  {
    qManager = new String(mqQManagerName);
    qName = new String(mqQueueName);
    init("default", "Input/Output");
  }

  public MQQueue(String mqQManagerName, String mqQueueName, String system, String mode) throws Exception 
  {
    qManager = new String(mqQManagerName);
    qName = new String(mqQueueName);
    init(system, mode);
    m_notify.trace("MQQueue Manager Name " + mqQManagerName + ", queue Name " + mqQueueName);
  }


  /**
   * Sets parameters and connects to the MQ Queue
   */
  public void init(String system, String mode) throws Exception
  {
      m_config = new Config("MQQueue");

    // Prepare for any entries to the Default.log
    m_notify = new Notify(this.getClass().getName());

    m_notify.trace("Start of MQ init for " + system + ", mode " + mode);
    try 
    {
        String txtValue=null;

        txtValue = m_config.getValue("MQ_TRACING_ENABLED_LEVEL");
        if(txtValue != null)
        {
            try
            {
                MQEnvironment.enableTracing(Integer.parseInt(txtValue));
            }
            catch(Exception e)
            {
                System.out.println("Failed to enable Tracing for level:  " + txtValue);
            }
        }

        txtValue = m_config.getValue("MQ_CLIENT_CHANNEL_NAME");
        if(txtValue != null)
        {
            MQEnvironment.channel = txtValue;
        }

        txtValue = m_config.getValue("MQ_CLIENT_HOSTNAME");
        if(txtValue != null)
        {
            MQEnvironment.hostname = txtValue;
        }

        txtValue = m_config.getValue("MQ_CLIENT_PORT");
        if(txtValue != null)
        {
            MQEnvironment.port = Integer.parseInt(txtValue);
        }

         System.out.println("Creating a QueueManager with the environment of:  ");
         System.out.println("Channel:        " + MQEnvironment.channel);
         System.out.println("HostName:       " + MQEnvironment.hostname);
         System.out.println("Port:           " + MQEnvironment.port);

      qMgr = new MQQueueManager(qManager);

      // Set up the options on the queue we wish to open...
      // Note. All MQSeries Options are prefixed with MQC in Java.
      int openOptions = 0;

      if (mode.compareToIgnoreCase("Input/Output") == 0)
      {
        openOptions = MQC.MQOO_INPUT_AS_Q_DEF | 
                      MQC.MQOO_OUTPUT ;
      }
     
      if (mode.compareToIgnoreCase("Output") == 0)
      {
        openOptions = MQC.MQOO_OUTPUT;
      }

      if (mode.compareToIgnoreCase("Input") == 0)
      {
        openOptions = MQC.MQOO_INPUT_AS_Q_DEF;
      }

      if (mode.compareToIgnoreCase("Browse") == 0)
      {
        openOptions = MQC.MQOO_INPUT_AS_Q_DEF |
                      MQC.MQOO_BROWSE; 
      }

      if (system.compareToIgnoreCase("COSMOS") == 0)
      { 
        openOptions = openOptions |
                      MQC.MQOO_SET_IDENTITY_CONTEXT;
      }

      if (system.compareToIgnoreCase("IMS") == 0)
      {
        openOptions = openOptions |
                      MQC.MQOO_FAIL_IF_QUIESCING;
      }

      // Now specify the queue that we wish to open, and the open options...
      theQueue = qMgr.accessQueue(qName, openOptions, null, null, null);

      m_notify.trace("MQ open completed");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  } // end of init


  /**
   * Use MQ Defaults
   * Method for puting an array of bytes on a queue
   * @param msg  byte[] to be placed on the queue
   *
   * This entry does not permit  MQC.MQOO_SET_IDENTITY_CONTEXT in the MQ open
   */
  public void putBytes(byte[] msg) throws Exception
  {
    try 
    {
      MQPutMessageOptions pmo = new MQPutMessageOptions();  // accept the defaults,
                                                            // same as MQPMO_DEFAULT constant
      // put the message on the queue
      MQMessage outMessage = new MQMessage();
      outMessage.write(msg);
      theQueue.put(outMessage, pmo);
      m_notify.trace("Put Bytes, length is " + outMessage.getMessageLength() + " Bytes long");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  }


  /**
   * Use MQ Object Description parameters
   * Method for puting an array of bytes on a queue
   * @param msg  byte[] to be placed on the queue
   *
   * This entry requires the open occured with MQC.MQOO_SET_IDENTITY_CONTEXT
   */
  public void putBytes(byte[] msg, 
                       String messageId,
                       String messageType, 
                       String userLogon, 
                       String transactionId, 
                       String receiveMQName,
                       String processId ) throws Exception
  {
    try
    {
      MQPutMessageOptions pmo = new MQPutMessageOptions();  
      pmo.options = MQC.MQPMO_SET_IDENTITY_CONTEXT;

      // put the message on the queue
      MQMessage outMessage = new MQMessage();
      outMessage.messageId = messageId.getBytes();
      outMessage.format = messageType;
      outMessage.userId = userLogon;
      outMessage.applicationIdData = receiveMQName;
      outMessage.accountingToken = transactionId.getBytes();
      outMessage.correlationId = processId.getBytes();
      outMessage.persistence = MQC.MQPER_PERSISTENT;
 
      outMessage.write(msg);
      theQueue.put(outMessage, pmo);
      m_notify.trace("Put Bytes, length is " + outMessage.getMessageLength() + " Bytes long");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  }


  /**
   * Use MQ Object Description parameters
   * Method for puting an array of bytes on a queue
   * @param msg  byte[] to be placed on the queue
   *
   * This entry is used for passing directly to IMS
   */
  public void putBytes(byte[] msg,
                       int msgSize,
                       String transactionId,
                       String mqQueueReply) throws Exception
  {
    char[] ASCII_to_EBCDIC = {
        0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F,
        0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F,
        0x40, 0x5A, 0x7F, 0x7B, 0x5B, 0x6C, 0x50, 0x7D, 0x4D, 0x5D, 0x5C, 0x4E, 0x6B, 0x60, 0x4B, 0x61,
        0xF0, 0xF1, 0xF2, 0xF3, 0xF4, 0xF5, 0xF6, 0xF7, 0xF8, 0xF9, 0x7A, 0x5E, 0x4C, 0x7E, 0x6E, 0x6F,
        0x7C, 0xC1, 0xC2, 0xC3, 0xC4, 0xC5, 0xC6, 0xC7, 0xC8, 0xC9, 0xD1, 0xD2, 0xD3, 0xD4, 0xD5, 0xD6,
        0xD7, 0xD8, 0xD9, 0xE2, 0xE3, 0xE4, 0xE5, 0xE6, 0xE7, 0xE8, 0xE9, 0xAD, 0xE0, 0xBD, 0x5F, 0x6D,
        0x7D, 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89, 0x91, 0x92, 0x93, 0x94, 0x95, 0x96,
        0x97, 0x98, 0x99, 0xA2, 0xA3, 0xA4, 0xA5, 0xA6, 0xA7, 0xA8, 0xA9, 0xC0, 0x6A, 0xD0, 0xA1, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B,
        0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B, 0x4B } ;

    // Save the Reply Queue name
    qReply = new String(mqQueueReply);

    try
    {
      // Define the output options
      MQPutMessageOptions pmo = new MQPutMessageOptions();  // accept the defaults,
                                                            // same as MQPMO_DEFAULT constant
      pmo.options = MQC.MQOO_FAIL_IF_QUIESCING;             // Options for message

      // Build the message Descriptor
      MQMessage outMessage = new MQMessage();
      outMessage.messageType = MQC.MQMT_REQUEST;
      outMessage.format = MQC.MQFMT_IMS; 
      outMessage.replyToQueueName = qReply;

      // Put the IMS Bridge Header information in the message
      outMessage.writeString("IIH ");                             // MQIIH Structure Identifier
      outMessage.writeInt(1);                                     // MQIIH Version number
      outMessage.writeInt(84);                                    // MQIIH Structure Length
      outMessage.writeInt(MQC.MQENC_NATIVE);                      // MQIIH Encoding MQENC_NATIVE=0x00000111=273 dec
      outMessage.writeInt(0);                                     // MQIIH Codeed Char Set Id
      outMessage.writeString("        ");                         // MQIIH MQ Format Name
      outMessage.writeInt(0);                                     // MQIIH Flags
      outMessage.writeString("        ");                         // MQIIH Logical Terminal Override
      outMessage.writeString("        ");                         // MQIIH Message Format Service Map name
      outMessage.writeString("        ");                         // MQIIH MQ Format Name of reply message
      outMessage.writeString("        ");                         // MQIIH RACF Password
      outMessage.writeString("\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0"); // MQIIH Transaction Instance Identifier
      outMessage.writeString(" ");                                // MQIIH Transaction State
      outMessage.writeString("0");                                // MQIIH Commit Mode
      outMessage.writeString("C");                                // MQIIH Security scope
      outMessage.writeString(" ");                                // MQIIH Reserved, must be blank

      // Write the Transaction Information
      outMessage.writeShort(msgSize + 12);                         // LL Transaction length
      outMessage.writeShort(0);                                    // ZZ

      // Transaction Id in EBCDIC form
      // Move the Transaction Id into position
      for (int i=0; i<8; i++)
      {
        if (i > transactionId.length()-1)
        {
          outMessage.writeChar(ASCII_to_EBCDIC[' ']);
        }
        else
        {
          outMessage.writeByte(ASCII_to_EBCDIC[transactionId.charAt(i)]);
        }
      }

      // Put the Encoded message on the outMessage
      outMessage.write(msg);

      // Put the Encoded message on the queue for IMS
      theQueue.put(outMessage, pmo);
      m_notify.trace("Put Bytes, length is " + outMessage.getMessageLength() + " Bytes long");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  }


  /**
   * Method for getting a byte array off of a queue
   * @return byte[] containing data
   *
   * This entry does not permit MQC.MQOO_SET_IDENTITY_CONTEXT in the MQ open
   */
  public byte[] getBytes() throws Exception 
  {
    byte[] byteArray = null;
    try 
    {
      MQGetMessageOptions gmo = new MQGetMessageOptions();  // accept the defaults
                                                            // same as MQGMO_DEFAULT
      gmo.options = MQC.MQGMO_WAIT;
      gmo.waitInterval = MQC.MQWI_UNLIMITED;

      MQMessage inMessage = new MQMessage();

      theQueue.get(inMessage, gmo);
      m_notify.trace("Get Bytes, length is " + inMessage.getMessageLength() + " Bytes long");
      byteArray = new byte[inMessage.getMessageLength()];
      inMessage.readFully(byteArray);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
    return byteArray;
  }

  /**
   * Method for getting a byte array off of a queue from the first position
   * @return byte[] containing data
   *
   * This entry must have MQ open with MQC.MQOO_SET_IDENTITY_CONTEXT
   */
  public byte[] browseFirstBytes(String messageId,
                                 String messageType,
                                 String correlationId) throws Exception
  {
    byte[] byteArray = null;
    try
    {
      MQGetMessageOptions gmo = new MQGetMessageOptions();  // accept the defaults
                                                            // same as MQGMO_DEFAULT
      gmo.options = MQC.MQGMO_WAIT |
                    MQC.MQGMO_NO_SYNCPOINT |
                    MQC.MQGMO_BROWSE_FIRST;
      gmo.waitInterval = MQC.MQWI_UNLIMITED;

      MQMessage inMessage = new MQMessage();

      theQueue.get(inMessage, gmo);
      m_notify.trace("Browse first, length is " + inMessage.getMessageLength() + " Bytes long");
      byteArray = new byte[inMessage.getMessageLength()];
      inMessage.readFully(byteArray);

      messageId = new String(inMessage.messageId);
      messageType = inMessage.format;
      correlationId = new String(inMessage.correlationId); 
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
    return byteArray;
  }


  /**
   * Method for getting a byte array off of a queue from the first position
   * @return byte[] containing data
   *
   * This entry must have MQ open with MQC.MQOO_SET_IDENTITY_CONTEXT
   */
  public byte[] browseNextBytes(String messageId,
                                 String messageType,
                                 String correlationId) throws Exception
  {
    byte[] byteArray = null;
    try
    {
      MQGetMessageOptions gmo = new MQGetMessageOptions();  // accept the defaults
                                                           // same as MQGMO_DEFAULT
      gmo.options = MQC.MQGMO_WAIT |
                    MQC.MQGMO_NO_SYNCPOINT |
                    MQC.MQGMO_BROWSE_NEXT;
      gmo.waitInterval = MQC.MQWI_UNLIMITED;

      MQMessage inMessage = new MQMessage();

      theQueue.get(inMessage, gmo);
      m_notify.trace("Browse Next, length is " + inMessage.getMessageLength() + " Bytes long");
      byteArray = new byte[inMessage.getMessageLength()];
      inMessage.readFully(byteArray);

      messageId = new String(inMessage.messageId);
      messageType = inMessage.format;
      correlationId = new String(inMessage.correlationId);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
    return byteArray;
  }


  /**
   * Method for getting a byte array off of a queue from the first position
   * @return byte[] containing data
   *
   * This entry must have MQ open with MQC.MQOO_SET_IDENTITY_CONTEXT
   */
  public byte[] browseRemoveBytes(String messageId,
                                  String messageType,
                                  String correlationId) throws Exception
  {
    byte[] byteArray = null;
    try
    {
      MQGetMessageOptions gmo = new MQGetMessageOptions();  // accept the defaults
                                                            // same as MQGMO_DEFAULT
      gmo.options = MQC.MQGMO_WAIT |
                    MQC.MQGMO_NO_SYNCPOINT |
                    MQC.MQGMO_MSG_UNDER_CURSOR;
      gmo.waitInterval = MQC.MQWI_UNLIMITED;

      MQMessage inMessage = new MQMessage();

      theQueue.get(inMessage, gmo);
      m_notify.trace("Browse remove, length is " + inMessage.getMessageLength() + " Bytes long");
      byteArray = new byte[inMessage.getMessageLength()];
      inMessage.readFully(byteArray);

      messageId = new String(inMessage.messageId);
      messageType = inMessage.format;
      correlationId = new String(inMessage.correlationId);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
    return byteArray;
  }


  public void closeQueue() throws Exception 
  {
    try
    {
      theQueue.close();
    }
    catch(Exception ex)
    {
      m_notify.triggerNotify("Error on MQ close");
      throw ex;
    }

    try
    {
      qMgr.disconnect();
    }
    catch (Exception ex2)
    {
      m_notify.triggerNotify("Error on MQ dosconnect");
      throw ex2;
    }
  }
    
  protected void finalize() throws Throwable
  {
    try 
    {
      theQueue.close();
    }
    catch(Exception ex) 
    {
    }

    try 
    {
      qMgr.disconnect();
    }
    catch(Exception ex2) 
    {
    }
  }

    public static void main(String args[]) throws Exception
    {
        MQQueue q = null;

        switch(args.length)
        {
        case 3:
            q = new MQQueue(args[0],args[1],args[2],"Output");
            break;
        case 2:
            q = new MQQueue(args[0],args[1],"default","Output");
            break;
        default:
            System.out.println("Usage:");
            System.out.println("\t\tjava " + MQQueue.class.getName() + " <QMgrName> <QName> [<System>]");
            System.exit(-1);
            break;
        }

        System.out.println("MQQueue class constructed... lets try to write to it...");

        String msg = "Hello MQ!!";
        byte buffer[] = msg.getBytes();        
        System.out.println("Got the message:  " + msg);

        q.putBytes(buffer,buffer.length,"TestTransaction","CCII_ERROR_MDE_IDD");

        System.out.println("Wrote to the queue...");
        q.closeQueue();
        System.out.println("Closed the queue");
                   
    }
}

