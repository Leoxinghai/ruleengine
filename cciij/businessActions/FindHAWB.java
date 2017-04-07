package cciij.businessActions;

/**
 * Title:        Find HAWB
 * Description:  Find a  Shipment by HAWB number. If the Shipment is not found throw
 *               exception "Fetch by HAWB returned NULL". After
 *               locating the Shipment, set the state object shipmentOid
 *               attribute to the shipmentOid contained in the Shipment.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Shipment fetch failed
 * @throws       cciij.util.CCIILogException Fetch Shipment by HAWB returned NULL
 *
 * @throws       java.lang.Exception Duplicate HAWB from fetch
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 10/25/2001    Ed McAleer   Add tags and complete description.
 * 12/26/2001    Ed McAleer   Change shipment fetch failures to CCIILogException.
 * 08/12/2004    Tom Knobeloch  Added method processDup to support extention
 * 10/18/2004    Joey Cline   Added code to set the IsManifested flag in the
 *                            State object for use in rules.
 * 10/25/2004    Joey Cline   Modified to reflect new isManifested method in
 *                            the Shipment class.
 * 09/13/2005    Tom Knobeloch  Included db exception in posted exception
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindHAWB extends BusinessActionBase {
private static final String m_whatVersion = "@(#) $RCSfile: FindHAWB.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindHAWB() throws Exception {
    traceLog("FindHAWB","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    // no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Shipment shipment = null;

    traceLog("FindHAWB", state);

    try {
      shipment =  dbConnection.fetchShipment(state.getScan().getHAWB(),
					     m_locationList.getLocationList());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment fetch failed", ex);
      throw cciiEx;
    }

    if ( shipment == null ) {
//       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
//       CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","Fetch Shipment by HAWB returned NULL");
//       throw cciiEx;
        state.getScan().setShipmentOid(0);
        state.setOverageFlag("H");
    }
    else
    {
        if ( dbConnection.getShipmentRecordCount() > 1 ) {
            processDup(state, dbConnection, shipment);
        }


        state.getScan().setShipmentOid( shipment.getShipmentOidNumber() );

        state.getScan().setCustomsReleasedFlag( shipment.getCustomsReleaseFlag());
        state.setIsManifested( shipment.isManifested() );

        state.m_printData.put("PieceQuantity",new Integer(shipment.getPieceQuanity()).toString());
        state.m_printData.put("BrokerEntryNumber",shipment.getBrokerEntryNumber());
        state.m_printData.put("ServiceCode",shipment.getServiceCode());

        if(shipment.getOverageReasonCode().equals("M") && shipment.getManifestStatusCode().equals(""))
        {
            state.setOverageFlag("M");
            state.getScan().setErrorNumber(Messages.IM_OVERAGE);
        }

    }

    return state;

  }

  protected void processDup(CCIIState state, DatabaseBean dbConnection, Shipment shipment) throws Exception
  {
      state.getScan().setReturnMessage("Duplicate HAWB");
      state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
      throw new Exception("Duplicate HAWB from fetch");
  }
  
public static void main(String[] args) throws Exception
{
      System.out.println("FindHAWB in main");
   
      System.out.println("Leaving main");
    }


}
