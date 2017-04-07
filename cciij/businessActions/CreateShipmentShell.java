package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:       Create Shipment Shell
 *
 * Description: This Business Action creates a shell Shipment object using the context
 *              information contained in the scan object.
 *
 *              A shipment object is created and the customs reviewed flag is set to "N".
 *              Furthermore, the shipmentOid number attribute is set to the shipmentOid
 *              number that was retreived from the Oid Factory.
 *
 *              The shipment object is persisted to the database.
 *
 *              The Scan object is updated with the shipmentOid number and the
 *              state object is returned to the caller.
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during Jolt service call to get Shipment Oid Number
 * @throws      cciij.util.CCIILogException Failure attempting to save Shipment
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *		None
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */

public class CreateShipmentShell extends BusinessActionBaseWithOidGeneration {

  private static final String m_whatVersion = "@(#) $RCSfile: CreateShipmentShell.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public CreateShipmentShell() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db_connection) throws Exception {

    boolean l_createMasterPieceRecord = false;

    traceLog("CreateShipmentShell","begining doIt()");
    traceLog("CreateShipmentShell",state);

    Shipment shipment = new Shipment(0,                          // shipmentOidNumber
                                     state.getScan().getHAWB(),  // airwayBill
                                     new Date(0),                // shipdate date time
                                     0,
                                     0,
                                     false,
                                     false,
                                     "",
                                     "",
                                     "",                         // formTypeCode
                                     "",                         // manifestSatusCode
                                     "N");                       // customs released flag

    shipment.setCustomsReviewedFlag("N");

    try {
      shipment.setShipmentOidNumber(getOid(OidFactoryTypes.SHIPMENT));
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_JOLT_ERROR_NUMB",
                                                     "Failure during Jolt service call to get Shipment Oid Number");
      throw cciiEx;
    }

    try {
      db_connection.saveShipment(shipment);
    }
    catch (Exception ex ) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                      "Failure attempting to save Shipment");
       throw cciiEx;
    }

    state.getScan().setShipmentOid( shipment.getShipmentOidNumber() );

    traceLog("CreateShipmentShell","Returning...");

    return state;
    }
}
