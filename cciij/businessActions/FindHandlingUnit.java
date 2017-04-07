package cciij.businessActions;

/**
 * Title:        Find Handling Unit
 * Description:  Find a Handling Unit by HandlingUnitOid number. If the
 *               Handling Unit is not found using the HandlingUnitOid throw
 *               an exception "Fetch by HandlingUnitOid returned NULL". After
 *               locating the Handling Unit, set the state object shipmentOid
 *               attribute to the shipmentOid contained in the Handling Unit.
 *               Retrieve the shipment information from the DB using the
 *               value contained in the state object shipmentOid attribute
 *               (future use).
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Fetch by HandlingUnitOid returned NULL\
 * @throws       cciij.util.CCIILogException Fetch of HandlingUnit failed
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
 * 12/26/2001    Ed McAleer   Change exceptions to CCIILogException.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindHandlingUnit extends FindTrackingNumber {
  private static final String m_whatVersion = "@(#) $RCSfile: FindHandlingUnit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindHandlingUnit() throws Exception {
    traceLog("FindHandlingUnit","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    HandlingUnit handlingUnit = null;
    Shipment shipment = null;

    traceLog("FindHandlingUnit", state);

    try {
      handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
      if ( handlingUnit == null ) {
        System.out.println("Got null from HU fetch using HUOid");
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                      "Fetch by HandlingUnitOid returned NULL, huOid ==" + state.getScan().getHandlingUnitOid());
        throw cciiEx;
      }
      else {
        state.getScan().setShipmentOid( handlingUnit.getShipmentOidNumber() );
      }
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch of HandlingUnit failed");
      throw cciiEx;
    }

   // getShipmetInformation is inherited, it places the needed shipment data
   //  for label processing in the print map.
   // the shipment object is returned, don't really need it but might in the future

   shipment = getShipmentInformation(state,dbConnection,state.getScan().getShipmentOid());

   state = updateStateInformation(state,handlingUnit,shipment);

   return state;

  }

public static void main(String[] args){
     System.out.println("FindHandlingUnit in main");

     System.out.println("Leaving main");
    }


}
