package cciij.businessActions;

import java.util.*;

import cciij.cciilookup.*;
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import cciij.WSUtil.*;

/**
 * Title:       Post Unresolved Duplicate Activity
 * Description: This Business Action retrieves the AWB from the scan object, finds
 *              all DUP entries with this AWB, and post Unresolved Dup activities
 *              for every piece found with this AWB number.
 *              This Business Action is invoked when the user or system cannot
 *              resolve a duplicate.
 *
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Joey Cline
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Could not get to the Lookup bean
 * @throws      cciij.util.CCIILogException Failure calling the Lookup bean to resolve dups for awb
 * @throws      cciij.util.CCIILogException The bean returned an unexpected data type
 * @throws      cciij.util.CCIILogException Error during processing of vector from lookup call
 * @throws      cciij.util.CCIILogException Creation Exception: could not create CCIIlookup
 * @throws      cciij.util.CCIILogException Remote Exception: could not create CCIIlookup
 * @throws      cciij.util.CCIILogException Naming Exception: could not connect to lookup home
 * @throws      cciij.util.CCIILogException Problem cleaning up lookup ejb
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */
public class PostUnresolvedDupActivity extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: PostUnresolvedDupActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    protected static LookupHome m_lookupHome = null;
    protected static String m_jndi_lookup_ccii_lookup = "";
    protected static String m_lookupT3Address = "";

    public PostUnresolvedDupActivity() throws Exception
    {
        traceLog("PostUnresolvedDupActivity","In Constructor");
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        traceLog("PostUnresolvedDupActivity","In doIt method");

        String activityCode = m_config.getValue("ACTIVITY_CODE");
        String rulesetName = m_config.getValue("RULESET_NAME");
        String queueName = m_config.getValue("QUEUE_NAME");
        String awb = state.getScan().getAirbillNumber();
        
        traceLog("PostUnresolvedDupActivity","activityCode = [" + activityCode + "]");
        traceLog("PostUnresolvedDupActivity","rulesetName = [" + rulesetName + "]");
        traceLog("PostUnresolvedDupActivity","queueName = [" + queueName + "]");
        traceLog("PostUnresolvedDupActivity","awb = [" + awb + "]");

        traceLog("PostUnresolvedDupActivity","Calling Lookup bean");

        Lookup lookup = getCCIILookup(state);
        if (lookup == null)
        {
            state.getScan().setErrorNumber(Messages.EM_NO_LOOKUP);
            CCIILogException cciiEx = new CCIILogException("BA_LOOKUP_NOT_FOUND",
                                                           "Could not get to the Lookup bean, awb == " + awb);
            throw cciiEx;
        }

        traceLog("PostUnresolvedDupActivity","Calling getDupRecords with location " + m_locationCd);

        CCIIDataVector cdv = null;
        try
        {
            cdv = lookup.getDupRecords(awb, m_locationCd);
        }
        catch (java.rmi.RemoteException ex)
        {
            state.getScan().setErrorNumber(Messages.EM_LKUP_CALL_ERR);
            CCIILogException cciiEx = new CCIILogException("BA_LOOKUP_CALL_ERROR",
                                                           "Failure calling the Lookup bean to resolve dups for awb: " + awb + " Exception: " + ex);
            throw cciiEx;
        }

        traceLog("PostUnresolvedDupActivity","Checking return value");

        if ( cdv.getDataType() != CCIIDataVector.HU_AND_SHIPMENT )
        {
            state.getScan().setErrorNumber(Messages.EM_LKUP_DATA_ERR);
            CCIILogException cciiEx = new CCIILogException("BA_LOOKUP_DATA_TYPE_ERROR",
                                                           "The bean returned an unexpected data type, data type == " + cdv.getDataType());
            throw cciiEx;
        }

        traceLog("PostUnresolvedDupActivity","Processing vector");

        try
        {
            Vector vec = cdv.getData();

            QueueWriter stateQueue = new QueueWriter();

            traceLog("PostUnresolvedDupActivity","Size of vector returned : " + vec.size() );
            for ( int ndx = 0; ndx < vec.size(); ndx++ )
            {
                CCIIState newState = (CCIIState)state.clone();
                newState.getScan().setErrorNumber(0);
                newState.setAbortFlag(false);
                newState.addActivity(activityCode);
                newState.setRuleSetName(rulesetName);

                HandlingUnitAndShipment huas = (HandlingUnitAndShipment)vec.get(ndx);
                HandlingUnit hu = huas.getHU();

                traceLog("PostUnresolvedDupActivity","Processing for HU Oid: " + hu.getHandlingUnitOidNumber());

                newState.getScan().setHandlingUnitOid(hu.getHandlingUnitOidNumber());

                stateQueue.putOnQueue(queueName, m_locationCd, newState);
            }

            cleanupCCIILookup(lookup, state);
        }
        catch (Exception e)
        {
            state.getScan().setErrorNumber(Messages.EM_LKUP_CALL_ERR);
            CCIILogException cciiEx = new CCIILogException("BA_LOOKUP_CALL_ERROR",
                                                           "Error during processing of vector from lookup call: " + e);
            throw cciiEx;
        }

        traceLog("PostUnresolvedDupActivity","returning ...");
        return state;
    }

    protected synchronized final Lookup getCCIILookup(CCIIState state) throws CCIILogException
    {
        traceLog("PostUnresolvedDupActivity","In getCCIILookup method");

        //init only executes needed code
        initCCIILookupEJB(state, m_config);
        Lookup lookup = null;
        try
        {
            if (m_lookupHome == null)
            {
                String str = "Ack!, CCIIlookup home was null, trying to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,str);
                //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,
                //                     str,ex,this);
                initCCIILookupEJB(state, m_config);
            }
            if (m_lookupHome != null)
            {
                lookup = m_lookupHome.create();
            }
            else
            {
                String str = "Ack!, CCIILookup Home is still NULL!!! after attempting to reinit";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME,str);
                //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME,
                //                     str,ex,this);
            }
        }
        catch (javax.ejb.CreateException ce)
        {
            state.getScan().setErrorNumber(Messages.EM_EJB_CONNECT);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                       "Creation Exception: could not create CCIIlookup" + ce);
            throw cciiEx;
        }
        catch (java.rmi.RemoteException re)
        {
            state.getScan().setErrorNumber(Messages.EM_EJB_CONNECT);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                   "Remote Exception: could not create CCIIlookup" + re);
            throw cciiEx;
        }
        return lookup;
    }

    protected synchronized static final void initCCIILookupEJB(CCIIState state, rmtc.util.Config cfg) throws CCIILogException
    {

        String site = state.getScan().getLocationCode();
        //need to change this to the JNDI name for CCII
        String jndi_lookup_ccii_lookup = cfg.getValue("JNDI_LOOKUP_CCII_LOOKUP");
        //need to change this to get the T3 Address for APAC
        String accsLookupT3Address = "t3://" + cfg.getValue("WEB_SERVER_ADDRESS");
        if (m_lookupHome == null
          || !m_jndi_lookup_ccii_lookup.equals(jndi_lookup_ccii_lookup)
          || !m_lookupT3Address.equals(accsLookupT3Address))
        {
            m_jndi_lookup_ccii_lookup = jndi_lookup_ccii_lookup;

            m_lookupT3Address = accsLookupT3Address;

            Hashtable env = new Hashtable();
            env.put (javax.naming.Context.INITIAL_CONTEXT_FACTORY, CCIIProperties.CCII_INITIAL_CONTEXT_FACTORY);
            env.put(javax.naming.Context.PROVIDER_URL,accsLookupT3Address );
            try
            {
                javax.naming.InitialContext ctx = new javax.naming.InitialContext(env);
                Object objref = ctx.lookup(jndi_lookup_ccii_lookup);
                m_lookupHome = (LookupHome) javax.rmi.PortableRemoteObject.narrow(objref,LookupHome.class);
            }
            catch (javax.naming.NamingException ne)
            {
                //WSNotify notify = new WSNotify("EJBProcessing");
                //notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,
                //                  "Naming Exception: could not connect to lookup home",ne,"EJBProcessing");
                state.getScan().setErrorNumber(Messages.EM_EJB_CONNECT);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                       "Naming Exception: could not connect to lookup home" + ne);
                throw cciiEx;
            }
        }
    }

    protected final void cleanupCCIILookup(Lookup lookup, CCIIState state) throws CCIILogException
    {
        try
        {
            if (lookup != null)
            lookup.remove();
        }
        catch (javax.ejb.RemoveException re)
        {
            //String str = "Problem cleaning up lookup ejb";
            //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOOKUP_EJB_CLEANUP,str,re,this);
            state.getScan().setErrorNumber(Messages.EM_EJB_CONNECT);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                   "Problem cleaning up lookup ejb");
            throw cciiEx;
        }
        catch (java.rmi.RemoteException re)
        {
            //String str = "Problem cleaning up lookup ejb";
            //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_LOOKUP_EJB_CLEANUP,str,re,this);
            state.getScan().setErrorNumber(Messages.EM_EJB_CONNECT);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                   "Problem cleaning up lookup ejb");
            throw cciiEx;
        }
    }

    public static void main(String args[])
    {
        if ( args.length != 2 )
        {
            System.out.println ( "Must supply a location code and an AWB number" );
            System.exit(1);
        }
 
         try
         {
             PostUnresolvedDupActivity obj = new PostUnresolvedDupActivity();

             obj.test(args[0], args[1]);
         }
         catch (Exception e)
         {
            System.out.println(e);
         }
    }

    public void test(String locationCd, String awbNbr) throws Exception
    {
        traceLog("PostUnresolvedDupActivity","In test method");

        rmtc.util.Config cfg = new rmtc.util.Config();

        traceLog("PostUnresolvedDupActivity","Loading Oracle driver");

        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        traceLog("PostUnresolvedDupActivity","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("PostUnresolvedDupActivity","Server:" + server);
        traceLog("PostUnresolvedDupActivity","User:" + user);
        traceLog("PostUnresolvedDupActivity","Pass:" + pass);

        java.sql.Connection conn =
             java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("PostUnresolvedDupActivity","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("PostUnresolvedDupActivity","Setting Connection object in bean");

        dbb.connect(conn);

        traceLog("PostUnresolvedDupActivity","Creating State object");

        CCIIState cciiState = new CCIIState();

        traceLog("PostUnresolvedDupActivity","Setting State values");

        cciiState.getScan().setLocationCode(locationCd);
        cciiState.getScan().setAirbillNumber(awbNbr);
        java.util.Date time = new java.util.Date();
        cciiState.getScan().setTransactionTimestamp(time);

        traceLog("PostUnresolvedDupActivity","Calling doIt");

        cciiState = (CCIIState) doIt(cciiState, dbb);

        traceLog("PostUnresolvedDupActivity","Returned from doIt");
        System.out.println("state after execution " + cciiState);

        conn.commit();

        return;
    }
}
