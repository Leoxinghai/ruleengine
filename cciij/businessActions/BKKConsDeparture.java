package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.fedex.accs.base.BusinessDataException;
import com.fedex.accs.base.InBatchErrorException;
import com.fedex.accs.base.PersistenceFailureException;
import com.fedex.accs.base.RowErrorDescriptor;
import com.fedex.accs.base.SiteContext;
import com.fedex.accs.cih.ejb.ShipmentServiceHome;
import com.fedex.accs.cih.ejb.ShipmentServiceRemote;
import com.fedex.accs.entity.MDEShipment;



public class BKKConsDeparture extends BusinessActionBaseWithOidGeneration
{
 private static final String m_whatVersion = "@(#) $RCSfile: BKKConsDeparture.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
 SortDate m_sortDate = new SortDate();
 
   public final static String JNDI_FACTORY=
       "weblogic.jndi.WLInitialContextFactory";

   private String m_errorMsg=null;
   private String m_fetchErrorNumber = "";
   private String m_configErrorNumber = "";
   private HashMap m_datamap = new HashMap();
   private BackgroundQueueConfigData2 m_configData = null;
   private String m_ruleSet = null;


 public BKKConsDeparture() throws Exception
 {
   m_fetchErrorNumber = readConfigVariableString("BA_FETCH_ERROR_NUMB");
   m_configErrorNumber = readConfigVariableString("BA_CONFIG_ERROR_NUMB");
 }

 public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
 {
 	ConsSummary conssummary =null;
 	Cons cons  = null;
 	Vector consVec = new Vector();
 	try {
 		conssummary = dbConnection.fetchConsSummary(state.getScan().getAirbillNumber());
 	} catch(Exception ex1) {
 		state.getScan().setErrorNumber(Messages.EM_DB_ERROR); //CONS not FOUND;
 		return state;
 	}
 	if(conssummary == null) {
 		state.getScan().setErrorNumber(Messages.EM_CONS_NOT_FOUND);
 		return state;
 	}
 	state.getScan().setConsOid(conssummary.getConsOidNumber());
 	try {
 		cons = dbConnection.fetchCons(state.getScan().getConsOid());
 	} catch(Exception ex2) {
 		ex2.printStackTrace();
 	}
 	while(cons != null) {
 		consVec.addElement(cons);
	  	try {
	  		cons = dbConnection.fetchNextCons();
	  	} catch(Exception ex2) {
	  		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	  		ex2.printStackTrace();
	  		throw ex2;
	  	}
 	}
 	
 	Enumeration enum = consVec.elements();
 	BKKFindTrackingnumber finder = new BKKFindTrackingnumber();
 	BKKPostScan postscan = new BKKPostScan();
 	BKKBackgroundQueue backgroundqueue = new BKKBackgroundQueue();
 
 	backgroundqueue.readSiteConfigVariables();
 	while(enum.hasMoreElements()) {
 		cons =(Cons)enum.nextElement();
		CCIIState newstate = (CCIIState)state.clone();
		newstate.getScan().setAirbillNumber(cons.getTrackingNumber());
		newstate.getScan().setAirbillFormType(cons.getFormTypeCode());
		try {
			newstate = finder.doIt(newstate,dbConnection);
		} catch(Exception ex3) {
		}
		if(cons.getFormTypeCode().equals("0503") && !state.getScan().getAirbillFormType().equals("0503") && !state.getScan().getAirbillFormType().equals("0501")) {
	    	newstate = doIt(newstate,dbConnection);
	    } else { 
	    	try {
		    	newstate = postscan.doIt(newstate,dbConnection);
		    	backgroundqueue.doIt(newstate,dbConnection);
	    	} catch(Exception ex4) {
	    	}
//	    	sendBackgroundQueue(state,dbConnection,false);
	    }
 	} 	
    return state;
 }
 
 protected void readSiteConfigVariables() throws Exception
 {
   super.readSiteConfigVariables();
     super.readSiteConfigVariables();
     //check to see if any of this has changed (it shouldn't)
     m_configData = (BackgroundQueueConfigData2)m_datamap.get(m_locationCd);
     if (m_configData == null)
     {
       m_configData = new BackgroundQueueConfigData2();
       m_configData.m_useBackupQueue = readConfigVariableBool("ENABLE_BACKUP_JMS_QUEUE",false);
       m_configData.m_webAddress =  readConfigVariableString("WEB_SERVER_ADDRESS");
       m_configData.m_queueJMSName = readConfigVariableString("QUEUE_JMS_NAME");
       m_configData.m_jmsFactory = readConfigVariableString("JMS_FACTORY");
       m_configData.m_queueJMSNameBackup = "";
       m_configData.m_jmsFactoryBackup = "";
       if (m_configData.m_useBackupQueue)
       {
         m_configData.m_queueJMSNameBackup = readConfigVariableString("QUEUE_JMS_NAME_BACKUP");
         m_configData.m_jmsFactoryBackup = readConfigVariableString("JMS_FACTORY_BACKUP");
       }
       //setting these to null will cause them to reinit
       m_configData.m_msg = null;
       m_configData.m_msgBackup = null;
       m_datamap.put(m_locationCd,m_configData);
     }

 }
 
 public CCIIState sendBackgroundQueue(CCIIState state, DatabaseBean db, boolean backupQueue) throws Exception {
   QueueConnectionFactory qconFactory = m_configData.m_qconFactory;
   QueueConnection qcon = m_configData.m_qcon;
   QueueSession qsession = m_configData.m_qsession;
   QueueSender qsender = m_configData.m_qsender;
   Queue queue = m_configData.m_queue;
   ObjectMessage msg = m_configData.m_msg;
   String queueJMSName = m_configData.m_queueJMSName;
   if (backupQueue)
   {
          if (m_configData.m_useBackupQueue)
          {
            qconFactory = m_configData.m_qconFactoryBackup;
            qcon = m_configData.m_qconBackup;
            qsession = m_configData.m_qsessionBackup;
            qsender = m_configData.m_qsenderBackup;
            queue = m_configData.m_queueBackup;
            msg = m_configData.m_msgBackup;
            queueJMSName = m_configData.m_queueJMSNameBackup;
            System.out.println("standard background queue must have failed, attempting to queue to backup queue");
            traceLog("BackgroundQueue","standard background queue must have failed, attempting to queue to backup queue");
          }
          else
          {
            traceLog("BackgqroundQueue", "shouldn't be here, not suppose to be using backgroundQueue");
            return state;
          }
       }
       if(msg == null)
          {
              try {
                  traceLog("BackgroundQueue","Trying to get the Initial Context from:  " + m_configData.m_webAddress);
                  InitialContext ctx =  getInitialContext("t3://" + m_configData.m_webAddress);
                  traceLog("BackgroundQueue","Now trying to find the JMS Queue:  " + queueJMSName);
                  m_configData.init(ctx, queueJMSName, backupQueue);
                  //reset the local variables after the init
                  if (backupQueue)
                  {
                    qconFactory = m_configData.m_qconFactoryBackup;
                    qcon = m_configData.m_qconBackup;
                    qsession = m_configData.m_qsessionBackup;
                    queue = m_configData.m_queueBackup;
                    qsender = m_configData.m_qsenderBackup;
                    msg = m_configData.m_msgBackup;
                  }
                  else
                  {
                    qconFactory = m_configData.m_qconFactory;
                    qcon = m_configData.m_qcon;
                    qsession = m_configData.m_qsession;
                    queue = m_configData.m_queue;
                    qsender = m_configData.m_qsender;
                    msg = m_configData.m_msg;
                  }
              }
              catch(Exception ex) {


                  if (backupQueue)
                  {
                     m_errorMsg = formatError(m_fetchErrorNumber,
                                          "GetInitialContext for backup JMS queue failed!!",
                                          this);
                  }
                  else if (m_configData.m_useBackupQueue)
                  {
                     m_errorMsg = formatError(m_fetchErrorNumber,
                                         "GetInitialContext for JMS queue failed!!, attempting to requeue to backup queue",
                                         this);
                  }
                  else
                  {
                     m_errorMsg = formatError(m_fetchErrorNumber,
                                         "GetInitialContext for JMS queue failed!!",
                                         this);
                  }
                  notifyLog(m_errorMsg,ex);
                  try
                  {
                    if(qsender != null)
                        qsender.close();
                    if(qsession != null)
                        qsession.close();
                    if(qcon != null)
                        qcon.close();
                  }
                  catch(Exception e)
                  {
                      System.out.println("Exception caught while cleaning up:  " + e);
                      // now ignore it
                  }

                  if (backupQueue)
                  {
                    // This will cause the next call to doit to rebuild the JMS connection
                     m_configData.m_msgBackup = null;
                  }
                  else
                  {
                    // This will cause the next call to doit to rebuild the JMS connection
                    m_configData.m_msg = null;
                    if (m_configData.m_useBackupQueue)
                    {
                      //try using the backup queue
                      return sendBackgroundQueue(state,db,true);
                    }
                  }
                 throw ex;
              }
          }

          //System.out.println("BackgroundQueue, begining doIt");
          traceLog("BackgroundQueue","begining doIt");
          m_ruleSet = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                      + "_POST_RULESET");

          if ( m_ruleSet == null ) {
              state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
              Exception ex = new Exception("Unable to read ruleset name from config file");
              m_errorMsg = formatError(m_configErrorNumber,
                                     "Unable to read ruleset name" + state.getScan().getInViewName().toUpperCase()
                                     + "_POST_RULESET",
                                     this);
              notifyLog(m_errorMsg,ex);
              throw ex;
          }

          try {
              CCIIState newState = new CCIIState();
              newState = (CCIIState)state.clone();
              newState.setRuleSetName(m_ruleSet);
              send(newState,backupQueue);
              if (backupQueue)
              {
                System.out.println("Successfully queue to the backup queue");
                traceLog("BackgroundQueue","Successfully queue to the backup queue");
              }
          }
          catch(JMSException ex) {
              //  This is the exception where problems with the JMS would show up
              System.out.println("JMSException:  " + ex);
              try
              {
                  if(qsender != null)
                      qsender.close();
                  if(qsession != null)
                      qsession.close();
                  if(qcon != null)
                      qcon.close();
              }
              catch(Exception e)
              {
                  System.out.println("Exception caught while cleaning up:  " + e);
                  // now ignore it
              }

              if (backupQueue)
              {
                // This will cause the next call to doit to rebuild the JMS connection
                m_configData.m_msgBackup = null;
                state.getScan().setErrorNumber(Messages.EM_QUEUE_ERR);
                m_errorMsg = formatError(m_fetchErrorNumber,
                                          "Send queue for backup JMS queue failed!!",
                                          this);
                notifyLog(m_errorMsg,ex);
              }
              else if (m_configData.m_useBackupQueue)
              {
                // This will cause the next call to doit to rebuild the JMS connection
                m_configData.m_msg = null;
                m_errorMsg = formatError(m_fetchErrorNumber,
                                         "Send Queue for JMS queue failed!!, attempting to requeue to backup queue",
                                         this);
                notifyLog(m_errorMsg,ex);
                return sendBackgroundQueue(state,db,true);
              }
              else
              {
                state.getScan().setErrorNumber(Messages.EM_QUEUE_ERR);
                m_errorMsg = formatError(m_fetchErrorNumber,
                                         "Send Queue for JMS queue failed!!",
                                         this);
                notifyLog(m_errorMsg,ex);
                m_configData.m_msg = null;
              }
              throw ex;
          }
          catch(Exception ex) {
              // This exception will get caught by ActionEntry and labeled with
              // the UNKNOWN type error number until a valid number can be defined.
              // 03/29/02 EM.
              System.out.println("Exception: " + ex);
              //Queue error exception
              if (backupQueue)
              {
                m_configData.m_msgBackup = null;
                state.getScan().setErrorNumber(Messages.EM_QUEUE_ERR);
                m_errorMsg = formatError(m_fetchErrorNumber,
                                          "General exception caught for backup JMS queue failed!!",
                                          this);
                notifyLog(m_errorMsg,ex);

              }
              else if (m_configData.m_useBackupQueue)
              {
                m_configData.m_msg = null;
                m_errorMsg = formatError(m_fetchErrorNumber,
                                         "General exception for JMS queue failed!!, attempting to requeue to backup queue",
                                         this);
                notifyLog(m_errorMsg,ex);
                return sendBackgroundQueue(state,db,true);
              }
              else
              {
                state.getScan().setErrorNumber(Messages.EM_QUEUE_ERR);
                m_errorMsg = formatError(m_fetchErrorNumber,
                                         "General exception for JMS queue failed!!",
                                         this);
                notifyLog(m_errorMsg,ex);
                m_configData.m_msg = null;
              }
              throw ex;
          }
          traceLog("BackgroundQueue", "returning ....");
          return state;

    }

    private void send(CCIIState state, boolean backupQueue)
        throws JMSException
    {
        if (backupQueue)
        {
          traceLog("BackgroundQueue", "sending to backup QUEUE");
          m_configData.m_msgBackup.setObject(state);
          m_configData.m_qsenderBackup.send(m_configData.m_msgBackup);
        } else
        {
          traceLog("BackgroundQueue", "sending to QUEUE");
          m_configData.m_msg.setObject(state);
          m_configData.m_qsender.send(m_configData.m_msg);
        }
    }

    private InitialContext getInitialContext(String url) throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, url);
        return new InitialContext(env);
    }

 

private class BackgroundQueueConfigData2 implements java.io.Serializable
{

 QueueConnectionFactory m_qconFactory;
 QueueConnection m_qcon;
 QueueSession m_qsession;
 QueueSender m_qsender;
 Queue m_queue;
 ObjectMessage m_msg;
 //backup queue info
 QueueConnectionFactory m_qconFactoryBackup;
 QueueConnection m_qconBackup;
 QueueSession m_qsessionBackup;
 QueueSender m_qsenderBackup;
 Queue m_queueBackup;
 ObjectMessage m_msgBackup;

 String m_jmsFactory=null;
 String m_webAddress=null;
 String m_queueJMSName=null;
 String m_queueJMSNameBackup = "";
 String m_jmsFactoryBackup = "";

 boolean m_useBackupQueue = false;

 public void init(Context ctx, String queueName, boolean backupQueue)
   throws NamingException, JMSException
{
   //backup queue
   if (backupQueue)
   {
     m_qconFactoryBackup = (QueueConnectionFactory) ctx.lookup(m_configData.m_jmsFactoryBackup);
     m_qconBackup = m_configData.m_qconFactoryBackup.createQueueConnection();
     m_qsessionBackup = m_qconBackup.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
     m_queueBackup = (Queue) ctx.lookup(queueName);
     m_qsenderBackup = m_qsessionBackup.createSender(m_configData.m_queueBackup);
     m_msgBackup = m_qsessionBackup.createObjectMessage();
     m_qconBackup.start();
   } else
   {
     m_qconFactory = (QueueConnectionFactory) ctx.lookup(m_jmsFactory);
     m_qcon = m_qconFactory.createQueueConnection();
     m_qsession = m_qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
     m_queue = (Queue) ctx.lookup(queueName);
     m_qsender = m_qsession.createSender(m_queue);
     m_msg = m_qsession.createObjectMessage();
     m_qcon.start();
   }
}
// finalize method to close queue connection and sessions.
protected void finalize() throws Throwable {
   if (m_qsender != null)
      m_qsender.close();
   if (m_qsession != null)
      m_qsession.close();
   if (m_qcon != null)
      m_qcon.close();
   if (m_useBackupQueue)
   {
     if (m_qsenderBackup != null)
        m_qsenderBackup.close();
     if (m_qsessionBackup != null)
        m_qsessionBackup.close();
     if (m_qconBackup != null)
        m_qconBackup.close();
   }
}
}
}