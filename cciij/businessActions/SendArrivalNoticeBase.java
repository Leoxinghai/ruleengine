package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Title:       SendArrivalNoticeBase.java
 * Description: Base class that will be used for sending notification to 
 *              NACCS for APAC. 
 * Copyright:   Copyright (c) 2001
 * Company:
 * @author      Julie McCarthy
 * @version 1.0
 *
 * Modification History:
 *   11/14/2003  Joey Cline    Modified the MQQueue object to be a property
 *                             instead of being a local variable, so that
 *                             the connection manager is not created/destroyed
 *                             with each call.                                 
 *                             Migrated property initialization into the       
 *                             initialize method, since creation of the 
 *                             MQQueue object is dependent on it.
 *
 */

public abstract class SendArrivalNoticeBase extends BusinessActionBase 
{
    private  String m_systemLevel = "";
    protected  String m_cciiQueueManagerName = "";
    protected  String m_cciiQueueName = "";
    protected  MQQueue m_mqQueue = null;
  
    protected String m_uploadActive = ""; 

    public SendArrivalNoticeBase() throws Exception
    {
        this("SendArrivalNoticeBase");
    }

    public SendArrivalNoticeBase(String childName) throws Exception {
        super(childName);
        traceLog("SendArrivalNoticeBase","In Constructor");
    }

    protected void initialize() throws Exception
    {
        super.initialize();

        // Read in Upload config setting
        m_uploadActive = readConfigVariableString("UPLOAD_ACTIVE", "Y");
        if (m_uploadActive.equals("Y"))
        {
            // Determine which level of system is being accessed
            m_systemLevel = readConfigVariableString("SYSTEM_LEVEL");

            // Get the QueueManagerName
            m_cciiQueueManagerName = readConfigVariableString(m_systemLevel + "_QUEUE_MANAGER_NAME");

            // Get the QueueName
            m_cciiQueueName  = readConfigVariableString("ACCS_SEND_QUEUE_NAME");
            try
            {
              if ( m_mqQueue == null )
              {
                traceLog("SendArrivalNoticeBase","Initializing MQQueue object");
                traceLog("SendArrivalNoticeBase","Initializing m_cciiQueueManagerName: " + m_cciiQueueManagerName);
                traceLog("SendArrivalNoticeBase","Initializing m_cciiQueueName: " + m_cciiQueueName);
                m_mqQueue = new MQQueue(m_cciiQueueManagerName, m_cciiQueueName, "COSMOS", "Output");
              }
            }
            catch (Exception ex)
            {
              System.out.println("Caught MQQueue Object creation error " + ex);
              ex.printStackTrace(System.out);
              // newState.getScan().setErrorNumber(Messages.EM_DB_ERROR);
              CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","MQQueue create failed");
              throw cciiEx;
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

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        return state;
    } 
}
