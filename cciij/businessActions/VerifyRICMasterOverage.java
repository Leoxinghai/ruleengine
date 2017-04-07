/*
 * Created on Jul 21, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.rmi.RemoteException;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.fedex.accs.base.BusinessDataException;
import com.fedex.accs.base.InBatchErrorException;
import com.fedex.accs.base.PersistenceFailureException;
import com.fedex.accs.base.RowErrorDescriptor;
import com.fedex.accs.base.SiteContext;
import com.fedex.accs.cih.ejb.ShipmentServiceHome;
import com.fedex.accs.cih.ejb.ShipmentServiceRemote;
import com.fedex.accs.entity.MDEShipment;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;


public class VerifyRICMasterOverage extends BusinessActionBaseWithOidGeneration
{

      private static final String m_whatVersion = "@(#) $RCSfile: VerifyRICMasterOverage.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
      SortDate m_sortDate = new SortDate();

      public VerifyRICMasterOverage() throws Exception
      {
      }

      public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
      {
      	String viewName = state.getScan().getInViewName();
      	String pieceNumber = null;
      	String shipNumber = null;
      	HandlingUnit handlingUnit = null;
    	try {
    	    handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getHAWB(),m_locationList.getLocationList());
    	}
    	catch (Exception ex) {
                
    	    m_notify.triggerNotify("Failed to call db.fetchHandlingUnit(" + state.getScan().getAirbillNumber()
    				   + ", " + m_locationList.getLocationList() + ")", ex);
    	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
    	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed",ex);
    	    throw cciiEx;
    	}

    	if ( handlingUnit == null ) {
      		shipNumber = state.getScan().getHAWB() + state.getScan().getHAWBFormType();
      		if(pieceNumber == null) pieceNumber = shipNumber;
      		
    	    Connection conn = dbConnection.getConnection();
	        ResultSet rs = null;
	        PreparedStatement pstmt = null;
	        
	        String shpOidSql = "select cih_overage.eCreate_ov(?,?,?,?) from dual";
	        try {
	            conn = dbConnection.getConnection();
	            pstmt = conn.prepareStatement(shpOidSql);
	            pstmt.setString(1, state.getScan().getUserLogon());
	            pstmt.setString(2, pieceNumber);
	            pstmt.setString(3,shipNumber);
	            pstmt.setString(4,state.getScan().getWarehouseCode());

	            rs = pstmt.executeQuery();
	
	        } catch ( Exception e ) {
	            e.printStackTrace();
	
	        } finally {
	            try {
	                if ( rs!=null ) {
	                    rs.close(); rs = null;
	                }
	                if ( pstmt!=null ) { 
	                    pstmt.close(); pstmt = null; 
	                }
	            } catch ( Exception e ) {
	                e.printStackTrace();
	            }
	        }

	        
	    	try {
	    	    handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getHAWB(),m_locationList.getLocationList());
	    	}
	    	catch (Exception ex) {
	                
	    	    m_notify.triggerNotify("Failed to call db.fetchHandlingUnit(" + state.getScan().getAirbillNumber()
	    				   + ", " + m_locationList.getLocationList() + ")", ex);
	    	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed",ex);
	    	    throw cciiEx;
	    	}
	    	if(handlingUnit == null) {
	    	    state.getScan().setErrorNumber(Messages.EM_CIH_SERVICE_DOWN);
	    	    return state;
    		}
	    	state.getScan().setShipmentOid(handlingUnit.getShipmentOidNumber());

	        state.getScan().setAgencyCode("FX");
	    	int pieceOid = handlingUnit.getHandlingUnitOidNumber();
	        int shipOid = state.getScan().getShipmentOid();
	        String recurString = state.getRecuringInterceptFlag()?"Y":"N";
     		state.setInterceptedFlag("Y");
      		state.getScan().setInterceptCode("OV");
	        Intercept intercept =
	            new Intercept(0,                                           // InterceptOid
	                          shipOid,                                     // SHipmentOid
	                          pieceOid,                                    // handlingUnitOid
	                          state.getScan().getInterceptCode(),          // intercept code
	                          "Y",                                  // active flag
	                          new Date(state.getScan().getSysDateTime()),  // createDate
	                          state.getScan().getUserLogon(),              // user name
	                          "RICMasterOv",                         // process name
	                          new Date(state.getScan().getSysDateTime()),  // update date
	                          "",                                          // update user
	                          "",                                          // update process name
	                          0,                                           // staging area priority number
	                          state.getScan().getTransactionTimestamp(),   // transaction date
	                          state.getScan().getAgencyCode(),             // agency code
	                          recurString);                                // recurring intercept flag


	       intercept.setInterceptOidNumber(getOid(OidFactoryTypes.INTERCEPT));
	       try
	       {
	         dbConnection.saveIntercept(intercept);
	       }
	       catch (Exception ex )
	       {
	          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
	                                    "Save Intercept failed");
	          notifyLog("Save Intercept failed",ex);
	          throw cciiEx;
	       }
    	}
        return state;
      }

      protected void readSiteConfigVariables() throws Exception
      {
        super.readSiteConfigVariables();
        m_EXTCID_JNDI_NAME = m_config.getString("EXTCID_JNDI_NAME");
        m_EXTCID_JNDI_SERVER = m_config.getString("EXTCID_JNDI_SERVER");
        //no local variables to read in
      }
      
       public static void main(String args[])
      {
          try
          {
    	  PostScan postScan = new PostScan();
    	  postScan.test();
           }
           catch (Exception ex)
           {
              System.out.println(ex);
           }
       } 
       
       private InitialContext getInitialContext() throws Exception {
    	    Hashtable env = new Hashtable();
    	    env.put("java.naming.factory.initial", "weblogic.jndi.T3InitialContextFactory");
    	    env.put("java.naming.provider.url", m_EXTCID_JNDI_SERVER);
    	    try {
    	        InitialContext initialContext = new InitialContext(env);
    	        return initialContext;
    	    }
    	    catch(Exception e) { 
    	        throw e; 
    	    }
       }
       
       private ShipmentServiceRemote getService() {
        ShipmentServiceRemote service = null;
        try {
            String jndiName = m_EXTCID_JNDI_NAME;//"accs.cih.ejb.ShipmentServiceRemote";
            Object home = getInitialContext().lookup(jndiName);

            ShipmentServiceHome chome = (ShipmentServiceHome) 
                PortableRemoteObject.narrow(home, ShipmentServiceHome.class);
            service = (ShipmentServiceRemote)
                PortableRemoteObject.narrow(chome.create(), ShipmentServiceRemote.class);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return service;
    }

       
       private String m_EXTCID_JNDI_NAME;
       private String m_EXTCID_JNDI_SERVER;
    }
