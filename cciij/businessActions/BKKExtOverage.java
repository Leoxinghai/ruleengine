/*
 * Created on Mar 12, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.rmi.RemoteException;

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



public class BKKExtOverage extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: BKKExtOverage.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  SortDate m_sortDate = new SortDate();

  public BKKExtOverage() throws Exception
  {
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
  	String viewName = state.getScan().getInViewName();
  	String pieceNumber = null;
  	String shipNumber = null;
  	if(viewName.equals("RIPVIEW") || viewName.equals("CONSVIEW") || viewName.equals("BAT")) {
  		shipNumber = state.getScan().getAirbillNumber() + state.getScan().getAirbillFormType();
  	} else {
  		pieceNumber = state.getScan().getAirbillNumber()+ state.getScan().getAirbillFormType();
  		shipNumber = state.getScan().getHAWB() + state.getScan().getHAWBFormType();
//  		shipNumber = state.getScan().getConsId()+ state.getScan().getConsFormType();
  	}
  	if(pieceNumber == null) {
  	    pieceNumber = shipNumber;
  	}
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

  	/*
    try {
        getService().setShipmentPiece(new SiteContext("TH","BKK"), pieceNumber, shipNumber);
    } catch (Exception e) {
        e.printStackTrace();
        state.getScan().setErrorNumber(304);
    }
    */
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

