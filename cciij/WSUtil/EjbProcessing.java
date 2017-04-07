package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

import cciij.ruleprocessor.RuleProcessorClient;
import cciij.ruleprocessor.CCIIScanClient;
import cciij.TuxJoltServices.TuxJoltServiceHome;
import cciij.TuxJoltServices.TuxJoltService;
import cciij.cciilookup.LookupHome;
import cciij.cciilookup.Lookup;
import cciij.Security.CCIISecurityHome;
import cciij.Security.CCIISecurity;
import java.util.*;
import cciij.cciidata.*;
import cciij.businessActions.Messages;
import javax.naming.*;
import javax.rmi.*;
import cciij.util.*;
import cciij.WSUtil.WSNotify;
import cciij.ruleprocessor.CCIIScanClient;


public class EjbProcessing implements java.io.Serializable
{
    protected final static boolean EJB_REMOVE_RULE_PROCESSOR = true;
    protected final static boolean EJB_REMOVE_LOGIN = true;
    protected final static boolean EJB_REMOVE_JOLT_TUX = true;
    protected final static boolean EJB_REMOVE_LOOKUP = true;
    private static final String m_whatVersion = "@(#) $RCSfile: EjbProcessing.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
    //protected int m_ejbType = CCIIProperties.EJB_TYPE_NO_PROCESS;
    //protected int m_ejbCodeType = CCIIProperties.EJB_CODE_USES_NONE;
    //protected static TuxJoltServiceHome m_joltTuxHome = null;
    protected static LookupHome m_lookupHome = null;
    protected static CCIISecurityHome m_SecurityHome = null;
    //protected String m_viewName = "";
    //protected String m_scanName;
    protected String m_actionName = "EJBProcessing";
    protected static String m_jndi_lookup_ccii_rule_processor = "";
    protected static String m_jndi_lookup_ccii_jolt_tux_ejb = "";
    protected static String m_jndi_lookup_ccii_lookup = "";
    protected static String jndi_lookup_ccii_login = "";
    protected static String m_ruleprocessorT3Address = "";
    protected static String m_joltTuxT3Address = "";
    protected static String m_lookupT3Address = "";
    protected static String securityT3Address = "";
    protected WSNotify m_notify = new WSNotify();
    //protected Java2uvsdk uvsdk = new Java2uvsdk();

    //static
    //{
    //  initAllEJB();
    //}

    public EjbProcessing()
    {
        m_notify.setActionName(m_actionName);
    }


    /*
    public void setAll(int ejbType, String ruleSetName, String viewName,
                       String scanName, int ejbCodeType)
    {
        //      setRuleSetName(ruleSetName);
        setViewName(viewName);
        setScanName(scanName);
        setEJBCodeType(ejbCodeType);
        setEjbType(ejbType);
    }


    public int getEjbType()
    {
        return m_ejbType;
    }

    public void setViewName(String viewName)
    {
        if (viewName != null)
            m_viewName = viewName;
    }

    public void setScanName(String scanName)
    {
        if (scanName != null)
            m_scanName = scanName;
    }

    public void setEJBCodeType(int ejbCodeType)
    {
        m_ejbCodeType = ejbCodeType;
    }
*/
//     public void setRuleSetName(String ruleSetName)
//     {
//      if (ruleSetName != null)
//          m_ruleSetName = ruleSetName;
//     }

    public synchronized final RuleProcessorClient getRuleProcessor()
    {
        try
        {
            return new RuleProcessorClient();
        }
        catch(Exception e)
        {
            System.out.println("Caught ane Exception constructing a RuleProcClient:  " + e);
            e.printStackTrace(System.out);
        }
        return null;
    }

    public synchronized final WorkstationScanClient getScanClient()
    {
        try
        {
            return new WorkstationScanClient();
        }
        catch(Exception e)
        {
            System.out.println("Caught ane Exception constructing a WorkstationScan:  " + e);
            e.printStackTrace(System.out);
        }
        return null;
    }

    public synchronized final Lookup getLookup(String site)
    {
        //init only executes needed code
        initLookupEJB(site);
        Lookup lookup = null;
        try
        {
            if (m_lookupHome == null)
            {
                String str = "Ack!, lookup home was null, trying to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,
                                     str,ex,this);
                initLookupEJB(site);
            }
            if (m_lookupHome != null)
            {
                lookup = m_lookupHome.create();
            }
            else
            {
                String str = "Ack!, Lookup Home is still NULL!!! after attempting to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME,
                                     str,ex,this);
            }
        }
        catch (javax.ejb.CreateException ce)
        {
            String str = "Creation Exception: could not create lookup";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_CREATE_LOOKUP,str,ce,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "Remote Exception: could not create lookup";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_CREATE_LOOKUP,str,re,this);
        }
        return lookup;
    }

    public synchronized final CCIISecurity getSecurity(String site)
    {
        //init only calls if needed
        initSecurityEJB(site);
        CCIISecurity security = null;
        try
        {
            if (m_SecurityHome == null)
            {
                String str = "Ack!, Security home was null, trying to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME,
                                     str,ex,this);
                initSecurityEJB(site);
            }
            if (m_SecurityHome != null)
            {
                security = m_SecurityHome.create();
            }
            else
            {
                String str = "Ack!, Security Home is still NULL!!! after attempting to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME,
                                     str,ex,this);
            }
        }
        catch (javax.ejb.CreateException ce)
        {
            String str = "Creation Exception: could not create security";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOGIN_CREATE_SECURITY,str,ce,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "Remote Exception: could not create security";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOGIN_REMOTE_ERROR,str,re,this);
        }
        return security;
    }


    /*
    public final void cleanupAllEJBs(RuleProcessorClient ruleProcessor,
                                     TuxJoltService joltTux, Lookup lookup, CCIISecurity security)
    {
        //could just call the sub methods
        //but trying to optimize by doing it all in one try block
        try
        {
            if (EJB_REMOVE_RULE_PROCESSOR && ruleProcessor != null)
                ruleProcessor.remove();
            if (EJB_REMOVE_JOLT_TUX && joltTux != null)
                joltTux.remove();
            if (EJB_REMOVE_LOOKUP && lookup != null)
                lookup.remove();
            if (EJB_REMOVE_LOGIN && lookup != null)
                security.remove();
        }
        catch (javax.ejb.RemoveException re)
        {
            String str = "ejb remove exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_MULTIPLE_EJB_CLEANUP,str,re,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "ejb remove remote exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_MULTIPLE_EJB_CLEANUP,str,re,this);
        }
    }
    */

    /*
    public final void cleanupRuleAndJolt(RuleProcessorClient ruleProcessor,
                                         TuxJoltService joltTux)
    {
        //could just call the sub methods
        //but trying to optimize by doing it all in one try block
        try
        {
            if (EJB_REMOVE_RULE_PROCESSOR && ruleProcessor != null)
                ruleProcessor.remove();
            if (EJB_REMOVE_JOLT_TUX && joltTux != null)
                joltTux.remove();
        }
        catch (javax.ejb.RemoveException re)
        {
            String str = "ejb remove exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_MULTIPLE_EJB_CLEANUP,str,re,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "ejb remove remote exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_MULTIPLE_EJB_CLEANUP,str,re,this);
        }
    }
    */

    public final void cleanupRuleProcessor(RuleProcessorClient ruleProcessor)
    {
        if (EJB_REMOVE_RULE_PROCESSOR && ruleProcessor != null)
            ruleProcessor.remove();
    }

    public final void cleanupScanClient(WorkstationScanClient scanClient)
    {
      //no method to clean up scan client currently
    }

    public final void cleanupSecurity(CCIISecurity security)
    {
        try
        {
            if (EJB_REMOVE_LOGIN && security != null)
                security.remove();
        } catch (javax.ejb.RemoveException re)
        {
            String str = "Problem cleaning up security ejb";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_SECURITY_REMOVE,str,re,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "Problem cleaning up security ejb";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_SECURITY_REMOVE,str,re,this);
        }
    }

    /*
    public final void cleanupJoltTux(TuxJoltService joltTux)
    {
        try
        {
            if (EJB_REMOVE_JOLT_TUX && joltTux != null)
                joltTux.remove();
        } catch (javax.ejb.RemoveException re)
        {
            String str = "jolt tux ejb remove exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_JOLT_TUX_EJB_CLEANUP,str,re,this);
        } catch (java.rmi.RemoteException re)
        {
            String str = "jolt tux ejb remove exception";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_JOLT_TUX_EJB_CLEANUP,str,re,this);
        }

    }
    */

    public final void cleanupLookup(Lookup lookup)
    {
        try
        {
            if (EJB_REMOVE_LOOKUP && lookup != null)
                lookup.remove();
        }
        catch (javax.ejb.RemoveException re)
        {
            String str = "Problem cleaning up lookup ejb";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOOKUP_EJB_CLEANUP,str,re,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "Problem cleaning up lookup ejb";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOOKUP_EJB_CLEANUP,str,re,this);
        }
    }


    /*
    public synchronized final TuxJoltService getJoltTux(String site)
    {
        //this init call only execute if needed
        initJoltTuxEJB(site);
        TuxJoltService joltTux = null;
        try
        {
            if (m_joltTuxHome == null)
            {
                String str = "Ack!, joltTux is null, trying to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME,
                                     str,ex,this);
                initJoltTuxEJB(site);
            }
            if (m_joltTuxHome != null)
            {
                joltTux = m_joltTuxHome.create();
            }
            else
            {
                String str = "Ack!, joltTux was still null after trying to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME,
                                     str,ex,this);
            }
        }
        catch (javax.ejb.CreateException ce)
        {
            String str = "Creation Exception: could not create Tux Jolt";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_CREATE_JOLTTUX,str,ce,this);
        }
        catch (java.rmi.RemoteException re)
        {
            String str = "Remote Exception: could not create Tux Jolt";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_CREATE_JOLTTUX,str,re,this);
        }
        return joltTux;
    }
    */


    /*public synchronized final RPBScan processScan(final CCIIScanClient scanClient,
                                                    final int existingErrorCode,
                                                    final UserAttributes user, final String trackingNumber,
                                                    final String trackingNumberType,
                                                    final boolean overrideCheckDigit, final int shipOid, final int huOid,
                                                    String formCode, final String hawb,
                                                    final boolean isHAWBUnknown,  String reasonCode,
                                                    String releaseCode, //String detainLoc,
                                                    final String actionCode,final String agency,
                                                    String interceptCode, String printerId,
                                                    Vector routeVector, String stagingAreaCode,
                                                    String remarkCode,//String comment,
                                                    final boolean usePieceLevelIntercept,
                                                    final String genericCode,final boolean evaluateGenericCode,
                                                    final Vector singleLineVec, final int useSingleLine,
                                                    final String site, final RouteLeg rtLeg,
                                                    final String warehouseCd,final Vector checkboxVector)
    {
      WorkstationScan wsScan = new WorkstationScan();
      wsScan.setExistingErrorCode(existingErrorCode);
      wsScan.setUserLogon(user.getUserName());
      wsScan.setOrgCode(user.getOrgCode());
      wsScan.setLanguage(user.getLanguage());
      wsScan.setAirbillNumber(trackingNumber);
      wsScan.setTrackingNumberType(trackingNumberType);
      wsScan.setOverrideCheckDigit(overrideCheckDigit);
      wsScan.setShipmentOid(shipOid);
      wsScan.setHandlingUnitOid(huOid);
      wsScan.setFormCode(formCode);
      //the following line use to be commented out
      wsScan.setHAWB(hawb);
      wsScan.setHAWBUnknownFlag(isHAWBUnknown);
      wsScan.setReasonCode(reasonCode);
      wsScan.setReleaseCode(releaseCode);
      wsScan.setActionCode(actionCode);
      wsScan.setAgencyCode(agency);
      wsScan.setInterceptCode(interceptCode);
      wsScan.setPrinterCode(printerId);
      wsScan.setRouteVector(routeVector);
      wsScan.setStagingAreaCode(stagingAreaCode);
      wsScan.setRemarkCode(remarkCode);
      wsScan.setUsePieceLevelIntercept(usePieceLevelIntercept);
      wsScan.setGenericCode(genericCode);
      wsScan.setEvaluateGenericCode(evaluateGenericCode);
      wsScan.setSingleLineVec(singleLineVec);
      wsScan.setLocationCode(site);
      wsScan.setRouteLeg(rtLeg);
      wsScan.setWarehouseCode(warehouseCd);
      wsScan.setCheckboxVector(checkboxVector);
      wsScan.setEjbCodeType(m_ejbCodeType);
      wsScan.setInViewName(m_viewName);


      return wsScan.processScan(scanClient);
    }
*/
    public synchronized void postRouteLegActivityScan(RuleProcessorClient ruleProcessor, UserAttributes user,
                                                      final String agency, String activityCode, RouteLeg rl, String site)
    {
        //System.out.println("postRouteLegActivityScan");
        //	CCIIState cciiState = new CCIIState();
        //	RPBScan scan = cciiState.getScan();
        RPBScan scan = new RPBScan();
        //	CCIIState returnState = null;
        RPBScan returnScan = null;

        //scan.setScanSeqName(m_scanName);
        //scan.setInViewName(m_viewName);
        scan.setSysDateTime(System.currentTimeMillis());
        scan.setUserLogon(user.getUserName());
        scan.setOrgCode(user.getOrgCode());
        scan.setInputDevice(CCIIProperties.readConfigVariableString(
                                                                    CCIIProperties.INPUT_DEVICE_NAME,site,
                                                                    CCIIProperties.INPUT_DEVICE_DEFAULT));
        scan.setRouteNumber(rl.getRouteNumber());
        scan.setRouteLegDate(rl.getRouteDate());
        scan.setRouteLegOid(rl.getRouteLegOidNumber());
        scan.setLocationCode(site);
// 	cciiState.setRuleSetName(m_ruleSetName);
// 	cciiState.addActivity(activityCode);
        //use this when activityCode becomes a Vector
        /*
          for (Iterator it=activityCode.iterator();it.hasNext();)
          {
          cciiState.addActivity((String)it.next());
          }
        */
        //cciiState.setDuplicateResolution(CCIIProperties.SITE_WS_RESOLVE_DUPLICATES);
        //cciiState.setRouteVerification(CCIIProperties.SITE_VERIFY_ROUTE);
        //cciiState.setSortDateVerification(CCIIProperties.SITE_VERIFY_SORT_DATE);
        //cciiState.setPositiveSort(CCIIProperties.SITE_POSITIVE_SORT);
        scan.setAgencyCode(agency);

        if (ruleProcessor == null)
        {
            //m_notify.traceLog("rule processor is Null");
            returnScan.setErrorNumber(Messages.EM_EJB_CONNECT);
        }
        else
        {
            try
            {

                returnScan = ruleProcessor.sendScan(scan);
// 		//m_notify.traceLog("Dumping the state object to see what's there");
// 		//m_notify.traceLog(m_actionName,cciiState);
// 		returnState = ruleProcessor.executeRules(cciiState);
// 		//m_notify.traceLog("Return State: " + returnState);
// 		//m_notify.traceLog("Returned Scan :" + returnState.getScan());
// 		if (returnState == null)
// 		{
// 		    String str = "PostRouteLegActivity, Return State is null";
// 		    CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_ROUTE_ACTIVITY,str);
// 		    m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_ROUTE_ACTIVITY,str,ex,this);
// 		}
// 		else if (returnState.getScan().getErrorNumber() != Messages.EM_NO_ERROR)
// 		{
// 		    String str = "PostRouteLegActivity, Returned Error: "
// 			+ returnState.getScan().getErrorNumber() + ", "
// 			+ MessageFormat.errorMessage(returnState.getScan().getErrorNumber(), user.getLanguage());
// 		    CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_ROUTE_ACTIVITY,str);
// 		    m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_ROUTE_ACTIVITY,str,ex,this);
// 		}

            }
            catch (Exception ex)
            {
                String str = "PostRouteLegActivity, Exception executing ruleprocessor";
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_ROUTE_ACTIVITY,str,ex,this);
                returnScan.setErrorNumber(Messages.EM_EJB_EXECUTE);
            }
        }
    }

    protected synchronized static final void initAllEJB(String site)
    {
        initRuleProcessorEJB(site);
        //initJoltTuxEJB(site);
        initLookupEJB(site);
        initSecurityEJB(site);
    }

    protected synchronized static final void initRuleProcessorEJB(String site)
    {
//      String jndi_lookup_ccii_rule_processor =
//          CCIIProperties.readConfigVariableString(
//                                                  "JNDI_LOOKUP_CCII_RULE_PROCESSOR",site,"ccii-RuleProcessorHome");
//      String ruleprocessorT3Address = CCIIProperties.getT3WebAddress(site);
//      if (m_ruleProcessorHome == null
//          || !m_jndi_lookup_ccii_rule_processor.equals(jndi_lookup_ccii_rule_processor)
//          || !m_ruleprocessorT3Address.equals(ruleprocessorT3Address))
//      {
//          m_jndi_lookup_ccii_rule_processor = jndi_lookup_ccii_rule_processor;
//          m_ruleprocessorT3Address = ruleprocessorT3Address;
//          Hashtable env= new Hashtable();
//          //m_notify.traceLog("Inital context Factory " + CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
//          env.put (Context.INITIAL_CONTEXT_FACTORY, CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
//          //m_notify.traceLog("Rule Processor Provider URL " + CCIIProperties.CCII_RULE_PROCESSOR_PROVIDER_URL);
//          env.put(Context.PROVIDER_URL, ruleprocessorT3Address);
//          try
//          {
//              InitialContext ctx = new InitialContext(env);
//              //m_notify.traceLog("JNDI name for Rule Processor: " + CCIIProperties.JNDI_LOOKUP_CCII_RULE_PROCESSOR);
//              Object objref = ctx.lookup(jndi_lookup_ccii_rule_processor);
//              //m_notify.traceLog("Object: " + objref);
//              //m_notify.traceLog("Object with the toString(): " + objref.toString());
//              //m_notify.traceLog("Using the object analyzer:");
//              //m_notify.traceLog(ObjectAnalyzer.toString(objref));
//              //m_notify.traceLog("Gonna try instaniating a copy of RuleProcessorHome.class");
//              //Class test = RuleProcessorHome.class;
//              //m_notify.traceLog("Object analyzer on that class");
//              //m_notify.traceLog(ObjectAnalyzer.toString(objref));
//              //m_notify.traceLog("Checking to see if it is an instance of: " + test.isInstance(objref) );

//              //m_notify.traceLog("going to do just the narrow command without the cast");
//              //PortableRemoteObject.narrow(objref,RuleProcessorHome.class);
//              //m_notify.traceLog("Now going to do the narrow and the cast");
//              m_ruleProcessorHome = (RuleProcessorHome) PortableRemoteObject.narrow(objref,RuleProcessorHome.class);
//          }
//          catch (NamingException ne)
//          {
//              WSNotify notify = new WSNotify("EJBProcessing");
//              notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_RULEPROC_BEAN_HOME,
//                                 "Naming Exception: Unable to get the rule Processor home",ne,"EJBProcessing");
//          }
//      }
    }

    protected synchronized static final void initLookupEJB(String site)
    {

        String jndi_lookup_ccii_lookup =
            CCIIProperties.readConfigVariableString(
                                                    "JNDI_LOOKUP_CCII_LOOKUP",site,"ccii_cciilookup");
        String lookupT3Address = CCIIProperties.getT3WebAddress(site);
        if (m_lookupHome == null
            || !m_jndi_lookup_ccii_lookup.equals(jndi_lookup_ccii_lookup)
            || !m_lookupT3Address.equals(lookupT3Address))
        {
            m_jndi_lookup_ccii_lookup = jndi_lookup_ccii_lookup;
            m_lookupT3Address = lookupT3Address;
            Hashtable env = new Hashtable();
            env.put (Context.INITIAL_CONTEXT_FACTORY, CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL,lookupT3Address );
            try
            {
                InitialContext ctx = new InitialContext(env);
                Object objref = ctx.lookup(jndi_lookup_ccii_lookup);
                m_lookupHome = (LookupHome) PortableRemoteObject.narrow(objref,LookupHome.class);
            }
            catch (NamingException ne)
            {
                WSNotify notify = new WSNotify("EJBProcessing");
                notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,
                                   "Naming Exception: could not connect to lookup home",ne,"EJBProcessing");
            }
        }
    }
  /*
    protected synchronized static final void initJoltTuxEJB(String site)
    {
        String jndi_lookup_ccii_jolt_tux_ejb =
            CCIIProperties.readConfigVariableString(
                                                    "JNDI_LOOKUP_CCII_JOLT_TUX_EJB",site,"cciiTuxJolt");
        String joltTuxT3Address = CCIIProperties.getT3WebAddress(site);
        if (m_joltTuxHome == null
            || !m_jndi_lookup_ccii_jolt_tux_ejb.equals(jndi_lookup_ccii_jolt_tux_ejb)
            || !m_joltTuxT3Address.equals(joltTuxT3Address))
        {
            m_jndi_lookup_ccii_jolt_tux_ejb = jndi_lookup_ccii_jolt_tux_ejb;
            m_joltTuxT3Address = joltTuxT3Address;
            Hashtable env= new Hashtable();
            //m_notify.traceLog("Inital context Factory " + CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
            env.put (Context.INITIAL_CONTEXT_FACTORY, CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
            //m_notify.traceLog("Jolt Tux Provider URL " + CCIIProperties.CCII_JOLT_TUX_EJB_PROVIDER_URL);
            env.put(Context.PROVIDER_URL, joltTuxT3Address);
            try
            {
                InitialContext ctx = new InitialContext(env);
                //m_notify.traceLog("JNDI name for JoltTux: " + CCIIProperties.JNDI_LOOKUP_CCII_JOLT_TUX_EJB);
                Object objref = ctx.lookup(jndi_lookup_ccii_jolt_tux_ejb);
                m_joltTuxHome = (TuxJoltServiceHome) PortableRemoteObject.narrow(objref,TuxJoltServiceHome.class);
            }
            catch (NamingException ne)
            {
                WSNotify notify = new WSNotify("EJBProcessing");
                notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME,
                                   "Naming Exception: could not connect to jolttux home",ne,"EJBProcessing");
            }
        }
    }
*/
    protected synchronized static final void initSecurityEJB(String site)
    {
        String jndi_lookup_ccii_login =
            CCIIProperties.readConfigVariableString(
                                                    "JNDI_LOOKUP_CCII_LOGIN",site,"cciiSecurity");
        String securityT3Address = CCIIProperties.getT3WebAddress(site);
        if (m_SecurityHome == null
            || !jndi_lookup_ccii_login.equals(jndi_lookup_ccii_login)
            || !securityT3Address.equals(securityT3Address))
        {
            jndi_lookup_ccii_login = jndi_lookup_ccii_login;
            securityT3Address = securityT3Address;
            Hashtable env= new Hashtable();
            env.put (Context.INITIAL_CONTEXT_FACTORY, CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, securityT3Address );
            try
            {
                InitialContext ctx = new InitialContext(env);
                Object objref = ctx.lookup(jndi_lookup_ccii_login);
                m_SecurityHome = (CCIISecurityHome) PortableRemoteObject.narrow(objref,CCIISecurityHome.class);
            }
            catch (NamingException ne)
            {
                WSNotify notify = new WSNotify("EJBProcessing");
                notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME,
                                   "Naming Exception: could not connect to Security home",ne,"EJBProcessing");
            }
        }
    }

    /*
    protected final int setEjbType(int ejbType)
    {
        if (ejbType < 0 || ejbType > CCIIProperties.EJB_TYPE_MAX)
            ejbType = CCIIProperties.EJB_TYPE_RULE_PROCESSOR;
        m_ejbType = ejbType;
        return m_ejbType;
    }
*/
    public synchronized final RPBScan doRouteEdit(UserAttributes user,String inputDevice,RouteLeg rl, String locationCode)
    {
      WorkstationScanClient sc = getScanClient();
      RPBScan scan = new RPBScan();
      scan.setInViewName(sc.ROUTE_EDIT_SCAN_VIEWNAME);
      scan.setSysDateTime(System.currentTimeMillis());
      scan.setUserLogon(user.getUserName());
      scan.setOrgCode(user.getOrgCode());
      scan.setInputDevice(inputDevice);
      scan.setLocationCode(locationCode);
      try
      {
        scan = sc.doRouteEdit(scan,null,rl);
      } catch (Exception e)
      {
        scan.setErrorNumber(Messages.EM_EJB_CONNECT);
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return scan;
    }

    public synchronized final boolean printPrinterLabel(String printerID, String locationCd)
    {
      boolean retValue = true;
      CCIIScanClient sc = getScanClient();
      try
      {
        retValue = sc.printPrinterLabel(printerID, locationCd);
      } catch (Exception e)
      {
        e.printStackTrace();
        retValue = false;
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return retValue;
    }

    public synchronized final boolean printStageAreaLabel(String printerID,
           String warehouseCode,String stagingArea, String locationCd)
    {
      boolean retValue = true;
      CCIIScanClient sc = getScanClient();
      try
      {
        retValue = sc.printStageAreaLabel(printerID,warehouseCode,stagingArea, locationCd);
      } catch  (Exception e)
      {
        e.printStackTrace();
        retValue = false;
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return retValue;
    }

    public synchronized final boolean printWarehouseLabel(String printerID,
           String warehouseCode, String locationCd)
    {
      boolean retValue = true;
      CCIIScanClient sc = getScanClient();
      try
      {
        retValue = sc.printWarehouseLabel(printerID,warehouseCode,locationCd);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        retValue = false;
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return retValue;
    }

    public synchronized final boolean downloadPrinterCodes(String locationCd, String printerID)
    {
      boolean retValue = true;
      CCIIScanClient sc = getScanClient();
      try
      {
        retValue = sc.downloadPrinterCodes(locationCd,printerID);
      } catch (Exception e)
      {
        e.printStackTrace();
        retValue = false;
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return retValue;
    }

    public synchronized final boolean printDetainmentLocLabel
           (String printerID, String warehouseCode, String stagingArea,
            String detainmentLoc,String locationCd)
    {
      boolean retValue = true;
      CCIIScanClient sc = getScanClient();
      try
      {
        retValue = sc.printDetainmentLocLabel(printerID, warehouseCode,
                 stagingArea,detainmentLoc,locationCd);
      } catch (Exception e)
      {
        e.printStackTrace();
        retValue = false;
      } finally
      {
        if (sc != null)
           sc.cleanup();
      }
      return retValue;
    }
}
