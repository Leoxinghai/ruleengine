/*
 * Created on Jul 27, 2006
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



public class DummyMasterHawb extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: DummyMasterHawb.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  SortDate m_sortDate = new SortDate();

  public DummyMasterHawb() throws Exception
  {
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
      RPBScan scan = state.getScan();
      boolean isDummyMaster = false;
      
      return state;
  }
  
  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
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
   

}