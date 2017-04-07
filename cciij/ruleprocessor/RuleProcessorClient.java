// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleProcessorClient.java

package cciij.ruleprocessor;

import cciij.CONSProcessor.CONSProcessor;
import cciij.CONSProcessor.CONSProcessorHome;
import cciij.cciidata.*;
import cciij.util.UnrollCons;
import com.fedex.css.ruleprocessor.RuleProcessor;
import com.fedex.css.ruleprocessor.RuleProcessorHome;
import java.io.PrintStream;
import java.rmi.ConnectException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import rmtc.util.Config;

import org.apache.log4j.Logger;

public class RuleProcessorClient
{

    public RuleProcessorClient()
        throws Exception
    {
        m_rpPool = null;
        m_config = null;
        m_ucons = new UnrollCons();
        m_cpPool = null;
        m_webServerAddress = null;
        m_outputDiag = false;
        m_preApplicationDateFromEpoch = 0xdc6c503180L;
        m_preApplicationDate = new Date(m_preApplicationDateFromEpoch);
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");
        m_context = null;
        m_config = new Config("UNKNOWN");
        m_rpPool = new TreeMap();
        m_cpPool = new TreeMap();
        String outputValue = m_config.getValue("RULE_PROCESSOR_CLIENT_OUTPUT");
        if(outputValue != null && outputValue.equals("TRUE"))
        {
            m_outputDiag = true;
            outputDiag("RULE_PROCESSOR_CLIENT_OUTPUT is set to TRUE");
        } else
        {
            m_outputDiag = false;
        }
        outputDiag("RuleProcessorClient()");
        
        m_webServerAddress = "t3://" + m_config.getValue("WEB_SERVER_ADDRESS");
        logger.debug("web address is:: " + m_webServerAddress);
        outputDiag("web address is:: " + m_webServerAddress);
        outputDiag("Attempting the connection");
        getInitialContext();
        outputDiag("Got the Context, we'll save the lookup for the first call!!!");
    }

    public RPBScan sendScan(RPBScan scn)
    {
        return sendScan(scn, null, null, null, false);
    }

    public RPBScan sendScan(RPBScan scn, UploadStatus uload)
    {
        return sendScan(scn, uload, null, null, false);
    }

    public RPBScan sendScan(RPBScan scn, UploadStatus uload, ActivitiesList alist)
    {
        return sendScan(scn, uload, alist, null, false);
    }

    public RPBScan sendScan(RPBScan scn, UploadStatus uload, ActivitiesList alist, RouteLeg rl, boolean isPieceLevelIntercept)
    {
        int rc = 0;
        CCIIState state = null;
        Vector stateVector = new Vector();
        CONSProcessor cp = null;
        m_config.setLocationCode(scn.getLocationCode());
        
        if(scn.getWarehouseCode() == null || scn.getWarehouseCode().equals(""))
        {
            scn.setWarehouseCode(m_config.getValue("DEFAULT_WAREHOUSE_CODE"));
            outputDiag("Using configured warehouse code:  " + scn.getWarehouseCode());
        }
        if(scn.getTransactionTimestamp() == null || scn.getTransactionTimestamp().before(m_preApplicationDate))
        {
            Date tempDt = new Date();
            String sourceTime = scn.getTransactionTimestamp() != null ? scn.getTransactionTimestamp().toString() : "null";
            outputDiag("Changing transaction time of [" + sourceTime + "] to be [" + sdf.format(tempDt) + "]");
            scn.setTransactionTimestamp(tempDt);
        }
        
        state = createState(scn, uload, alist, rl, isPieceLevelIntercept);
        state = sendState(state);

        /*
        if(!scn.getAirbillType().equals("3") || scn.getInViewName().compareTo("CONSView") == 0 || scn.getInViewName().compareTo("DCONView") == 0 || scn.getInViewName().compareTo("CONSDwnldView") == 0 )
        {
            state = createState(scn, uload, alist, rl, isPieceLevelIntercept);
            state = sendState(state);
        } else
        {
            if(!m_config.getValue(scn.getInViewName().toUpperCase() + "_ALLOW_CONS").equals("Y"))
            {
                scn.setErrorNumber(76);
                return scn;
            }
            try
            {
                outputDiag("Getting a reference to CONSProcessor");
                cp = getCONSProcessor(scn.getLocationCode());
                outputDiag("Got it");
                outputDiag("Calling the method on the CONSProcessor reference");
                state = createState(scn, uload, alist, rl, isPieceLevelIntercept);
                state = cp.processCONS(state);
                outputDiag("Returned from processCONS()...");
            }
            catch(ConnectException ce)
            {
                try
                {
                    outputDiag("Caught a Connect Exception: " + ce);
                    removeCONSProcessor(scn.getLocationCode());
                    outputDiag("Attempting to reconnect to weblogic");
                    cp = getCONSProcessor(scn.getLocationCode());
                    if(cp != null)
                    {
                        outputDiag("Reconnection established, retrying the CONSProcessing method???()");
                        state = createState(scn, uload, alist, rl, isPieceLevelIntercept);
                        state = cp.processCONS(state);
                    }
                }
                catch(Throwable e)
                {
                    outputDiag("EXCEPTION: " + e);
                    e.printStackTrace();
                    scn.setErrorNumber(34);
                    if(e instanceof ConnectException)
                        removeCONSProcessor(scn.getLocationCode());
                    if(scn.getErrorNumber() > 0)
                        return scn;
                }
            }
            catch(Throwable e)
            {
                outputDiag("EXCEPTION: " + e);
                e.printStackTrace();
                scn.setErrorNumber(34);
                if(e instanceof ConnectException)
                    removeCONSProcessor(scn.getLocationCode());
                if(scn.getErrorNumber() > 0)
                    return scn;
            }
        }
        */
        scn = state.getScan();
        return scn;
    }

    public CCIIState sendState(CCIIState state)
    {
        CCIIState retState = null;
        RPBScan scn = state.getScan();
        RuleProcessor rp = null;
        m_config.setLocationCode(scn.getLocationCode());
        outputDiag("RuleProcessorClient.sendStateVector()");
        logger.debug("RuleProcessorClient.sendStateVector()");
        try
        {
            try
            {
                outputDiag("Getting a reference to a ruleProcessor");
                rp = getRuleProcessor(scn.getLocationCode());
                outputDiag("Got it");
                outputDiag("Calling the executeRules method on the ruleprocessor reference");
                logger.debug("Calling the executeRules method on the ruleprocessor reference");
                retState = (CCIIState)rp.executeRules(state);
                logger.debug("Returned from executeRules()");
                outputDiag("Returned from executeRules()...");
            }
            catch(ConnectException ce)
            {
                outputDiag("Caught a Connect Exception:  " + ce);
                removeRuleProcessor(scn.getLocationCode());
                outputDiag("Attempting to reconnect to weblogic");
                rp = getRuleProcessor(scn.getLocationCode());
                if(rp != null)
                {
                    outputDiag("Reconnection established, retrying the executeRules()");
                    retState = (CCIIState)rp.executeRules(state);
                } else {
                	retState.getScan().setErrorNumber(309);
                }
            }
        }
        catch(Throwable e)
        {
            outputDiag("EXCEPTION: " + e);
            e.printStackTrace();
            scn.setErrorNumber(34);
            if(e instanceof ConnectException)
                removeRuleProcessor(scn.getLocationCode());
        }
        outputDiag("After all the hoopla");
        if(retState.getStatusCd() < 0 && retState.getScan().getErrorNumber() < 31)
            retState.getScan().setErrorNumber(41);
        outputDiag("Returned a state of:  " + retState);
        return retState;
    }

    public String getScanRuleSetName(RPBScan scan)
    {
    	String szRuleSetName = m_config.getValue(scan.getInViewName().toUpperCase() + "_RULESET");
    	logger.debug("view_ruleset."+scan.getInViewName().toUpperCase() + "_RULESET");
    	logger.debug("rulesetName."+szRuleSetName);
    	return szRuleSetName;
		
    }

    protected void outputDiag(String msg)
    {
        if(m_outputDiag)
            System.out.println(msg);
    }

    protected void outputDiag(Throwable ex)
    {
        if(m_outputDiag)
            outputDiag(ex.toString());
    }

    private CCIIState createState(RPBScan scan, UploadStatus uload, ActivitiesList alist, RouteLeg rl, boolean isPieceLevelIntercept)
    {
        CCIIState state = null;
        try {
            state = new CCIIState();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        state.setScan(scan);
        if(uload != null)
            state.setUploadStatus(uload);
        state.setDuplicateFlag("");
        state.setOverageFlag("");
        state.setInterceptedFlag("");
        state.setUploadFlag("");
        state.setMPSFlag("");
        state.setAbScanned(state.getScan().getAirbillNumber());
        state.setAbFormTypeScanned(state.getScan().getAirbillFormType());
        state.setAbTypeScanned(state.getScan().getAirbillType());
        if(m_config.getValue("USE_EXTERNAL_LOOKUP").equals("FALSE"))
            state.setUseExternalLookup(false);
        else
            state.setUseExternalLookup(true);
        state.setPieceLevelIntercept(isPieceLevelIntercept);
        if(state.getScan().getPrinterCode().equals(""))
            state.getScan().setPrinterCode("none");
        state.setAbortTransaction(false);
        state.setRuleSetName(getScanRuleSetName(state.getScan()));
        if(scan.getInViewName().equals("BKKDUP")) 
        	state.setScanTypeCode(scan.getOutViewName());
        else 
        	state.setScanTypeCode(m_config.getValue(scan.getInViewName().toUpperCase() + "_SCAN_CODE"));
        outputDiag("Setting RuleSetName to:  " + state.getRuleSetName());
        if(state.getRuleSetName() == null || state.getScanTypeCode() == null)
        {
            scan.setErrorNumber(64);
            return state;
        }
        if(m_config.getValue("SITE_RESOLVE_DUPLICATES_AT_SORT").equals("TRUE"))
            state.setDuplicateResolution(true);
        else
            state.setDuplicateResolution(false);
        if(m_config.getValue("SITE_VERIFY_ROUTE").equals("TRUE"))
            state.setRouteVerification(true);
        else
            state.setRouteVerification(false);
        if(m_config.getValue("SITE_VERIFY_SORT_DATE").equals("TRUE"))
            state.setSortDateVerification(true);
        else
            state.setSortDateVerification(false);
        if(m_config.getValue("SITE_POSITIVE_SORT").equals("TRUE"))
            state.setPositiveSort(true);
        else
            state.setPositiveSort(false);
        if(alist != null)
        {
            Iterator iter = null;
            for(iter = alist.iterator(); iter.hasNext(); state.addActivity((String)iter.next()));
        }
        state.setRouteLegInfo(rl);
        return state;
    }

    private InitialContext getInitialContext()
        throws Exception
    {
        Hashtable env = null;
        if(m_context == null)
        {
            outputDiag("RPC.getInitialContext()");
            env = new Hashtable();
            env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
            env.put("java.naming.provider.url", m_webServerAddress);
            outputDiag("got the env(hashtable):  " + env);
            try
            {
                outputDiag("Get Initial Context...");
                m_context = new InitialContext(env);
                outputDiag("Got Initial Context");
            }
            catch(Exception e)
            {
                outputDiag(e);
                e.printStackTrace(System.out);
                throw e;
            }
        }
        return m_context;
    }

    private void removeRuleProcessor(String locationCode)
    {
        m_rpPool.remove(locationCode);
    }

    private void removeCONSProcessor(String locationCode)
    {
        m_cpPool.remove(locationCode);
    }

    public void removeCONS()
    {
        Iterator iter2 = m_cpPool.values().iterator();
        CONSProcessor cp = null;
        while(iter2.hasNext()) 
            try
            {
                cp = (CONSProcessor)iter2.next();
                cp.remove();
            }
            catch(Exception e)
            {
                outputDiag("Caught an Exception calling CONSProcessor.remove():  " + e);
                e.printStackTrace();
            }
        m_cpPool.clear();
    }

    public void remove()
    {
        Iterator iter = m_rpPool.values().iterator();
        RuleProcessor rp = null;
        while(iter.hasNext()) 
            try
            {
                rp = (RuleProcessor)iter.next();
                rp.remove();
            }
            catch(Exception e)
            {
                outputDiag("Caught an Exception calling RuleProcessor.remove():  " + e);
                e.printStackTrace();
            }
        m_rpPool.clear();
    }

    private RuleProcessor getRuleProcessor(String locationCode)
        throws Exception
    {
        logger.debug("getRuleProcessor.Initial context0."+locationCode);
    	try {
	        if(m_rpPool.containsKey(locationCode)) {
		        return (RuleProcessor)m_rpPool.get(locationCode);
	        }
	        InitialContext initialContext;
	        String jndiName;
	        initialContext = getInitialContext();
	        jndiName = null;
	        logger.debug("getRuleProcessor.Initial context."+locationCode);
	        m_config.setLocationCode(locationCode);
	        logger.debug("getRuleProcessor."+m_config.getValue("RULEPROCESSOR_JNDI_NAME"));
	        
	        if((jndiName = m_config.getValue("RULEPROCESSOR_JNDI_NAME")) == null) {
		        System.out.println("No JNDI Name set for location " + locationCode + " with name RULEPROCESSOR_JNDI_NAME");
		        return null;
    		}
	        RuleProcessor rp;
	        outputDiag("RuleProcessorClient.getRuleProcessor() Now lookup the home associated to the jndi name:  " + jndiName);
	        Object home = initialContext.lookup(jndiName);
	        outputDiag("RPC.getRuleProcessor() got the home, now narrow it");
	        RuleProcessorHome rpHome = (RuleProcessorHome)PortableRemoteObject.narrow(home, com.fedex.css.ruleprocessor.RuleProcessorHome.class);
	        outputDiag("RPC.getRuleProcessor() got the narrowed home, now \"create\" the rp stub");
	        rp = (RuleProcessor)PortableRemoteObject.narrow(rpHome.create(), com.fedex.css.ruleprocessor.RuleProcessor.class);
	        outputDiag("RPC.getRuleProcessor() got the rp reference, store it for future use and return it...");
	        m_rpPool.put(locationCode, rp);
	        return rp;
    	} catch(Exception e) {
    		logger.fatal(e);
	        outputDiag("Connect to application failed, will re-try for next message");
	        e.printStackTrace();
	        throw e;
//	        return null;
    	} catch(Throwable thr) {
    		logger.fatal(thr);
    		return null;
    	}
    }

    private CONSProcessor getCONSProcessor(String locationCode)
        throws Exception
    {
        outputDiag("RuleProcessorClient.getCONSProcessor(" + locationCode + ")");
        try {
	        if(m_cpPool.containsKey(locationCode))
	            return (CONSProcessor)m_cpPool.get(locationCode);
	        InitialContext initialContext;
	        String jndiName;
	        initialContext = getInitialContext();
	        jndiName = null;
	        m_config.setLocationCode(locationCode);
	        if((jndiName = m_config.getValue("CONSPROCESSOR_JNDI_NAME")) == null) {
		        System.out.println("No JNDI Name set for location " + locationCode + " with name CONSPROCESSOR_JNDI_NAME");
		        return null;
	        }
	        CONSProcessor cp;
	        Object home = initialContext.lookup(jndiName);
	        CONSProcessorHome cpHome = (CONSProcessorHome)PortableRemoteObject.narrow(home, cciij.CONSProcessor.CONSProcessorHome.class);
	        cp = (CONSProcessor)PortableRemoteObject.narrow(cpHome.create(), cciij.CONSProcessor.CONSProcessor.class);
	        m_cpPool.put(locationCode, cp);
	        return cp;
        } catch(Exception e) {
	        outputDiag("Connect to application failed, will re-try for next message");
	        e.printStackTrace();
	        return null;
        }
    }

    public static void main(String arg[])
        throws Exception
    {
        RuleProcessorClient rpc = new RuleProcessorClient();
        CONSProcessor cons;
        if(arg[0].equals("RP"))
        {
            System.out.println("Going after a RuleProcessor Stub");
            RuleProcessor rp = rpc.getRuleProcessor(arg[1]);
            if(rp == null)
                System.out.println("Got A NULL STUB!!!!!!!!!");
            else
                System.out.println("Got a non-null rp stub of type:  " + rp.getClass().getName() + ":  " + rp);
        } else
        if(arg[0].equals("CONS"))
            cons = rpc.getCONSProcessor(arg[1]);
    }

    private Map m_rpPool;
    private Config m_config;
    private UnrollCons m_ucons;
    private Map m_cpPool;
    protected String m_webServerAddress;
    protected boolean m_outputDiag;
    private long m_preApplicationDateFromEpoch;
    protected Date m_preApplicationDate;
    protected SimpleDateFormat sdf;
    private InitialContext m_context;
    
    private Logger logger = Logger.getLogger(RuleProcessorClient.class);
}
