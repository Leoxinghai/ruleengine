package cciij.businessActions;

/**
 * Title:       Find Shipmnent
 * Description:
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Fetch by shipmentOid returned NULL, shipmentOid
 * @throws      cciij.util.CCIILogException Shipment Fetch Failed
 *
 * @param       state - CCIIState object to be updated.
 * @param       dbConnection - DatabaseBean connection object.
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindShipment extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: FindShipment.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  public FindShipment() throws Exception {
    traceLog("FindShipment","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Shipment shipment = null;
    HandlingUnit handlingUnit = null;
    traceLog("FindShipment", state);

    try {
      shipment =  dbConnection.fetchShipment(state.getScan().getShipmentOid());
      if ( shipment == null ) {
        System.out.println("Got null from Shipment fetch using shipmentOid");
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                        "Fetch by shipmentOid returned NULL, shipmentOid ==" + state.getScan().getShipmentOid());
        throw cciiEx;
      }
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment Fetch Failed");
      throw cciiEx;
    }
    try {
	    handlingUnit = dbConnection.fetchHandlingUnitWithShipmentOid(state.getScan().getShipmentOid());
	      if ( handlingUnit == null ) {
	        System.out.println("Got null from HandlingUnit fetch using shipmentOid");
	        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	        CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
	                        "Fetch by shipmentOid returned NULL, shipmentOid ==" + state.getScan().getShipmentOid());
	        throw cciiEx;
	      }
    } catch (Exception ex2) {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment Fetch Failed");
        throw cciiEx;
    }
    state.getScan().setCustomsReleasedFlag(shipment.getCustomsReleaseFlag());
    state.getScan().setDeclarationCode(shipment.getDeclaredFlag());
    state.getScan().setAirbillNumber(shipment.getAWBNumber());
    state.getScan().setAirbillFormType(shipment.getFormTypeCode());
    state.getScan().setHandlingUnitOid(handlingUnit.getHandlingUnitOidNumber());
    
    return state;
  }

public static void main(String[] args){
     System.out.println("FindShipment in main");


     System.out.println("Leaving main");
    }

}