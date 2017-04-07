/*
 * Created on Apr 3, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.util.*;
import rmtc.util.*;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.fedex.css.ruleprocessor.RuleProcessor;
import com.fedex.css.ruleprocessor.RuleProcessorHome;
import org.apache.log4j.Logger;

public class BKKCosmosBatchUpload extends Thread 
{
  private static final String m_whatVersion = "@(#) $RCSfile: BKKCosmosBatchUpload.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  SortDate m_sortDate = new SortDate();
  CCIIState m_state  =null;
  DatabaseBean m_dbConnection = null;
  Config m_config = new Config();
  Logger logger = Logger.getLogger(BKKCosmosBatchUpload.class);

  public BKKCosmosBatchUpload(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
  	if(m_rpPool == null)
  		m_rpPool = new TreeMap();
  	m_state = state;
  	m_dbConnection = new DatabaseBean();//dbConnection;
  	m_dbConnection.connect();
  	m_dbConnection.setLocationCode( state.getScan().getLocationCode());
  }
  
  public void run() {
  	try {
  		doIt(m_state,m_dbConnection);
  	} catch(Exception ex) {
  		
  	}
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
  	RuleProcessor rp = this.getRuleProcessor(state.getScan().getLocationCode());
  	state.setAbortFlag(false);
  	state.getScan().setErrorNumber(0);
  	
  	String  m_ruleSet = m_config.getValue(state.getScan().getInViewName().toUpperCase()
    + "_POST_RULESET");

  	state.setRuleSetName(m_ruleSet);
  	
  	if(state.getScan().getAirbillFormType().equals("0503") || state.getScan().getAirbillFormType().equals("0501")) {
    	state.getScan().setFromConsFlag("Y");

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
  	 	    if(state.getScanTypeCode().equals("RIP")) {
  	 	        conssummary.setStatusFlag(1);
  	  	 	    dbConnection.updateConsSummary(conssummary);
  	  	 	    dbConnection.commitTransaction();
  	 	    } else if(state.getScanTypeCode().equals("ROP")) {
  	 	        if(conssummary.getStatusFlag() != 1)
  	 	            conssummary.setStatusFlag(10);
  	 	        else 
  	 	            conssummary.setStatusFlag(11);
  	  	 	    dbConnection.updateConsSummary(conssummary);
  	  	 	    dbConnection.commitTransaction();
  	 	    }
  	 		cons = dbConnection.fetchCons(state.getScan().getConsOid());
  	 	} catch(Exception ex2) {
  	 		ex2.printStackTrace();
  	 	}
  	 	while(cons != null) {
  	 	    if(!cons.getDeconsFlag().equals("D"))
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
		if(state.getScanTypeCode().equals("CONS")) {
		    state.setScanTypeCode("CMT");
		      if(state.getScan().getConsFormType().equals("0503")) {
		          state.getScan().setComments("BAG CONS."+" SPLIT#:"+ state.getScan().getSplitNumber());
		      } else if(state.getScan().getConsFormType().equals("0501")) {
		          state.getScan().setComments("ULD#:"+state.getScan().getContainerId()+" SPLIT#:"+ state.getScan().getSplitNumber());
		      }
//		    state.getScan().setComments("ULD")
			state = (CCIIState)rp.executeRules(state);
		    state.setScanTypeCode("CONS");
		}
		
  		if(state.getScan().getOutViewName() == null || state.getScan().getOutViewName().equals("") || !state.getScan().getOutViewName().equals("NOCOSMOS"))
			state = (CCIIState)rp.executeRules(state);

		while(enum.hasMoreElements()) {
  	 		cons =(Cons)enum.nextElement();
  			CCIIState newstate = (CCIIState)state.clone();
  			newstate.getScan().setAirbillNumber(cons.getTrackingNumber());
  			newstate.getScan().setAirbillFormType(cons.getFormTypeCode());
  			newstate.getScan().setHandlingUnitOid(cons.getOidNumber());
  			newstate.getScan().setAirbillType("");
  			try {
  				newstate = finder.doIt(newstate,dbConnection);
  			} catch(Exception ex3) {
  			}
  			if((cons.getFormTypeCode().equals("0503") || cons.getFormTypeCode().equals("0501")) && state.getScan().getAirbillFormType().equals("0501") ) {
  		    	logger.debug("BAG."+state.getScanTypeCode()+";"+state.getScan().getAirbillNumber());
  		    	try {
  		    		postscan.m_locationCd = state.getScan().getLocationCode();
  	  		    	logger.debug("TRACK#."+state.getScanTypeCode()+";"+state.getScan().getAirbillNumber());
  		    		newstate = postscan.doIt(newstate,dbConnection);
  		  	  		newstate.setRuleSetName(m_ruleSet);
  		  	  		newstate.getScan().setErrorNumber(0);
  		  	  		newstate.setAbortFlag(false);
  		  	  		if(state.getScanTypeCode().equals("DCON") || state.getScanTypeCode().equals("CONS"))
  		  	  		     newstate.getScan().setOutViewName("NOCOSMOS");
  		  	  		else 
  		  	  		    newstate = (CCIIState)rp.executeRules(newstate);
  		    	} catch(Exception ex4) {
  		    		ex4.printStackTrace();
  		    	}
  			    
  		    	newstate.getScan().setContainerId(state.getScan().getContainerId());
  				newstate = doIt(newstate,dbConnection);
  		    	
  		    } else { 
  		    	try {
  		    		postscan.m_locationCd = state.getScan().getLocationCode();
  	  		    	logger.debug("TRACK#."+state.getScanTypeCode()+";"+state.getScan().getAirbillNumber());
  		    		newstate = postscan.doIt(newstate,dbConnection);
  		  	  		newstate.setRuleSetName(m_ruleSet);
  		  	  		newstate.getScan().setErrorNumber(0);
  		  	  		newstate.setAbortFlag(false);
//  		  	  		if(newstate.getScan().getOutViewName() == null || !newstate.getScan().getOutViewName().equals("NOCOSMOS"))
  		  	  		if(newstate.getScanTypeCode().equals("STAT")) {
						newstate.setScanTypeCode("CMT");
						rp.executeRules(newstate);
						newstate.setScanTypeCode("STAT");
  		  	  		} else if(!newstate.getScanTypeCode().equals("CONS") && !newstate.getScanTypeCode().equals("DCON") && !newstate.getScanTypeCode().equals("RIP") &&!newstate.getScanTypeCode().equals("ROP"))
  		  	  		    newstate = (CCIIState)rp.executeRules(newstate);
  		    	} catch(Exception ex4) {
  		    		ex4.printStackTrace();
  		    	}
  		    }
  	 	} 	  		
  	} else {
  		state.setRuleSetName(m_ruleSet);
  		if(state.getScan().getOutViewName() == null || !state.getScan().getOutViewName().equals("NOCOSMOS"))
		  	state = (CCIIState)rp.executeRules(state);
    }

  	state.setAbortFlag(false);
	state.getScan().setErrorNumber(0);
  	state.setUploadFlag("C");
    return state;
  }
  

  private InitialContext getInitialContext()
  throws Exception
	{
	  Hashtable env = null;
      m_webServerAddress = "t3://" + m_config.getValue("WEB_SERVER_ADDRESS");
	  if(m_context == null)
	  {
	      env = new Hashtable();
	      env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
	      env.put("java.naming.provider.url", m_webServerAddress);
	      try
	      {
	          m_context = new InitialContext(env);
	      }
	      catch(Exception e)
	      {
	          e.printStackTrace(System.out);
	          throw e;
	      }
	  }
	  return m_context;
	}
  
  private RuleProcessor getRuleProcessor(String locationCode)
  throws Exception
{
	try {
      if(m_rpPool.containsKey(locationCode)) {
	        return (RuleProcessor)m_rpPool.get(locationCode);
      }
      InitialContext initialContext;
      String jndiName;
      initialContext = getInitialContext();
      jndiName = null;
      m_config.setLocationCode(locationCode);
      
      if((jndiName = m_config.getValue("RULEPROCESSOR_JNDI_NAME")) == null) {
	        System.out.println("No JNDI Name set for location " + locationCode + " with name RULEPROCESSOR_JNDI_NAME");
	        return null;
		}
      RuleProcessor rp;
      Object home = initialContext.lookup(jndiName);
      RuleProcessorHome rpHome = (RuleProcessorHome)PortableRemoteObject.narrow(home, com.fedex.css.ruleprocessor.RuleProcessorHome.class);
      rp = (RuleProcessor)PortableRemoteObject.narrow(rpHome.create(), com.fedex.css.ruleprocessor.RuleProcessor.class);
      m_rpPool.put(locationCode, rp);
      return rp;
	} catch(Exception e) {
      e.printStackTrace();
      throw e;
//      return null;
	} catch(Throwable thr) {
		return null;
	}
}

  private static Map m_rpPool =null;
  protected String m_webServerAddress;	  
  private InitialContext m_context;
}

