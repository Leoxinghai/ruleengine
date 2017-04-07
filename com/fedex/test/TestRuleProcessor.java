/*
 * Created on Oct 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.test;

/*
 * Created on Sep 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


import cciij.cciidata.*;

import com.fedex.css.ruleprocessor.*;

import java.rmi.ConnectException;
import java.util.*;

import javax.ejb.EJBObject;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestRuleProcessor {

	public static void main(String[] args) {
        String m_webServerAddress = "t3://" + "127.0.0.1:7001";
        Hashtable env = new Hashtable();
        CCIIState retState = null;
        CCIIState state = new CCIIState();

        RPBScan rpb = new RPBScan();
//        String scan = args[0];
        rpb.setLocationCode("AKJ");
        rpb.setWarehouseCode("AK1");
        rpb.setAirbillNumber("849581125901");
        rpb.setAirbillType("D");
        rpb.setAirbillFormType("0430");
        rpb.setAirbillEntry("2");
            rpb.setPrinterCode("NZ01");
        rpb.setUserLogon("TSClient");
        rpb.setInViewName("IPAVIEW");
        rpb.setErrorNumber(0);
        rpb.setShipmentOid(0);
        rpb.setInterceptCode("PW");
        
        state.setScanTypeCode("BIN");
        state.setScan(rpb);
        state.setDuplicateFlag("true");
        state.setOverageFlag("Y");
       
        state.setInterceptedFlag("true");
        state.setUploadFlag("");
        state.setMPSFlag("");
        
        state.setRuleSetName("YMX_CNAHUR_1");
        state.getScan().setPrinterCode("NZ01");
        state.setAbortTransaction(false);
        state.setAlwaysEmptyString(null);
        
        
//      state.setRuleSetName()"");
        
        env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        env.put("java.naming.provider.url", m_webServerAddress);
        try
        {
            InitialContext initialContext = new InitialContext(env);
//            return initialContext;
        	Object home = initialContext.lookup("ccii.rplarge1");
            RuleProcessorHome rpHome = (RuleProcessorHome)PortableRemoteObject.narrow(home, com.fedex.css.ruleprocessor.RuleProcessorHome.class);
            RuleProcessor rp = (RuleProcessor)PortableRemoteObject.narrow(rpHome.create(), com.fedex.css.ruleprocessor.RuleProcessor.class);
            System.out.println("succesful");
            
            retState = (CCIIState)rp.executeRules(state);
            System.out.println(retState);
            
        }
        catch(Exception e)
        {
        	System.out.println(e.toString());
        	
        	//          outputDiag(e);
   //         throw e;
        }
	}
}
