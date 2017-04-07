package cciij.util;

/**
 * Title:        CosmosMq2Log
 * Description:  Read messages from the COSMOS MQ and puts a notification to the default.log
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
 *   03/14/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import rmtc.util.*;
import java.util.*;
import java.io.*;
import weblogic.common.*;

public class CosmosMq2Log extends Thread implements T3StartupDef 
{
  private T3ServicesDef services;
  private Config config = null;
  public static boolean shutdown = false;
  protected Notify m_notify = null;
  protected long sleepTime = 1000;


  /**
   * Main method for running in stand alone mode.
   */
  public static void main(String[] args) 
  {
    CosmosMq2Log cosmosMq2Log = new CosmosMq2Log();
    cosmosMq2Log.transferFromMQ();
  }


  /**
   * Default constutor for CosmosMq2Log
   */
  public CosmosMq2Log() 
  {
  }


  /**
   * Required method to run as a Weblogic Startup class
   */
  public void setServices(T3ServicesDef services) 
  {
    this.services = services;
  }


  /**
   * Method called by weblogic when run as a startup class
   */
  public String startup(String name, Hashtable args) throws Exception 
  {
    // Write your startup code here...
    System.out.println("CosmosMq2Log in the startup method");

    String key;
    String value;
    key = "DELAYTIME";
    value = (String) args.get(key);
    if (value != null)
    {
     try
     {
       sleepTime = Long.parseLong(value);
     }
     catch (Exception e)
     {
      System.out.println("Caught an exception while trying format delay time");
     }
     args.remove(key);
    }

    //transferFromMQ();
    start();

    return "ok";
  }


  /**
   * Method run when start called, runs in a new thread
   */
  public void run() 
  {
    System.out.println("CosmosM12Log in the run method");

    // Lets do some Delay Time before we actually start
    try
    {
      Thread.sleep(sleepTime);         //sleep for some configurable time period
    }
    catch (InterruptedException ie)
    {
      System.out.println("startup class: caught an interrupted exception while trying to sleep");
    }

    // Start the actual application
    transferFromMQ();
  }


  /**
   * Loops forever looking for messages from MQ to give notice to the Default.log
   */
  public void transferFromMQ() 
  {
    // Constants
    int     MAX_MESSAGES = 1000;                   // Count of messages left on queue before quiting

    // Local variables 
    String  s_cosmosCommunicationsPath = null;     // TUXEDO or WEBLOGIC communications
    String  s_downloadActive = null;               // Flag indicating if Download is Active	
    String  s_systemLevel = null;                  // System Level being operated on
    String  s_cciiQueueManagerName = null;         // MQ Manager Name
    String  s_cciiReturnQueueName = null;          // MQ Receive queue Name
    String  s_defaultLogFileName = null;           // Default.Log file name
    String  s_messageId = null;                    // Field to receive the MessageId
    String  s_messageType = null;                  // Field to receive the MessageType
    String  s_correlationId = null;                // Field to receive the CorrilationId
    String  s_messagesToLeave = null;              // String containing messages types to leave on MQ

    int     i_readCount = 0;                       // Counter of messages read from MQ
    boolean b_firstTime = true;                    // Used to control Browse mode

    // Set up interface to the config file
    config = new Config();

    // Prepare for any entries to the Default.log
    m_notify = new Notify(this.getClass().getName());

    System.out.println("CosmosMq2Log in the TransferFromMq method");
    // Read configuration parameters
    try
    {
      Config cfg = new Config("All");

      s_cosmosCommunicationsPath = cfg.getValue("COSMOS_COMMUNICATIONS_PATH");
      if (s_cosmosCommunicationsPath.equals("TUXEDO"))
      {
        // Tuxedo is doing the communications, so terminate
        return;
      }
      s_downloadActive = cfg.getValue("DOWNLOAD_ACTIVE");
      s_systemLevel = cfg.getValue("SYSTEM_LEVEL");
      s_cciiQueueManagerName = cfg.getValue(s_systemLevel + "_QUEUE_MANAGER_NAME");
      s_cciiReturnQueueName = cfg.getValue("CCII_RECV_QUEUE_NAME");
      s_messagesToLeave = cfg.getValue("MESSAGES_TO_LEAVE_ON_MQ");
    }
    catch (Exception ex)
    {
      m_notify.triggerNotify("Configuration variables missing", ex);
      return;
    }

    // Only continue if download is active
    if (s_downloadActive.equals("N"))
    {
      // No download configured, so just terminate this process
      return;
    }

    // Define the MQ to read from
    MQQueue receiveMQ;

    try 
    {
      System.out.println("CosmosMq2Log just before Activating the MQ");
      // Open the MQ to read from
      receiveMQ = new MQQueue(s_cciiQueueManagerName,         // Queue Manager Name
                              s_cciiReturnQueueName,          // Queue Name
                              "COSMOS",                       // Application Identification
                              "Browse");                      // Mode of operation
    }
    catch(Exception ex) 
    {
      m_notify.triggerNotify("Unable to open MQ file to read from", ex);
      return;
    }

    // Define some space to receive the message
    byte[] msg = new byte[1024];

    while(! shutdown) 
    {
      // start at the beginning and read until MAX_MESSAGES is reached
      try
      {
        if (b_firstTime)
        {
          System.out.println("CosmosMq2Log Ready to perform the browseFirst call");
          // read but do not remove from the MQ
          msg = receiveMQ.browseFirstBytes(s_messageId,
                                           s_messageType,
                                           s_correlationId);

          // Set the counter back to 1
          i_readCount = 1;
        }
        else
        {
          System.out.println("CosmosMq2Log Ready to perform the browseNext call");
          // Read the next record but do not remove from the MQ
          msg = receiveMQ.browseNextBytes(s_messageId,
                                          s_messageType,
                                          s_correlationId);

          // Increment the count of reads
          i_readCount++;
        }
      }
      catch(Exception ex) 
      {
        m_notify.triggerNotify("Problem reading from MQ", ex);
        return;
      }

      if(msg != null)
      {
        // Is this a message we want removed from the MQ
        // -1 means that the message is not of the type contained in the string 's_messagesToLeave'
        if ( s_messagesToLeave.indexOf(s_messageType) == -1)
        {
          System.out.println("CosmosMq2Log ready to perform the browseRemove call");
          // Remove this message
          // Read and remove from the MQ
          try
          {
            msg = receiveMQ.browseRemoveBytes(s_messageId,
                                              s_messageType,
                                              s_correlationId);
          }
          catch (Exception ex)
          {
            m_notify.triggerNotify("Unable to browseRemoveBytes from MQ", ex);
            return;
          }


          // Build a message for the default.log
          m_notify.triggerNotify("Message returned from COSMOS " + 
                                 s_messageId + " " + 
                                 s_messageType + " " + 
                                 s_correlationId, null);

          // Set the firstTime so we will begin again
          b_firstTime = true;
        }
        else
        {
          // Set the firstTime to false, so we will read the next message
          b_firstTime = false;

          // Check if we have read MAX_MESSAGES messages 
          if (i_readCount >= MAX_MESSAGES)
          {
            // There are extensive messages on the MQ, stop reading them, but notify the user
            try
            {
              // Write message to default log
              m_notify.triggerNotify("More than " + MAX_MESSAGES + " on the MQ, processing stopped", null);
            }
            catch (Exception ex)
            {
              System.out.println("Unable to write to the 'default.log', message " + ex);
              return;
            }
            // There are to many messages on the MQ, decide what to do with them later
            // Set to start over from the start, but only after aa delay of 
            b_firstTime = true;
            try
            {
              sleep(1200000);   // 1,200,000 = 1,200 seconds = 20 minutes
            }
            catch (Exception ex)
            {
              System.out.println("Sleep interupted in CosmosMq2Log routine " + ex);
            }
          }
          else
          {
            // Set the firstTime to false, so we will read the next message
            b_firstTime = false;

            // Now get the next message on the MQ
          }
        }
      }
    }
  }
}
