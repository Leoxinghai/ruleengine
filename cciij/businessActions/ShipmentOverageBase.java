package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:       Shipment Overage Base
 *
 * Description: This Business Action creates a HandlingUnit using the context
 *              information contained in the scan object. A check is performed to
 *              see if the hew HandlingUnit is a CRN. If it is a CRN, the AWB is
 *              set to 0 (ZERO), otherwise the AWB is set to the scan objects AWB.
 *
 *              A shipment object is created and the shipmentDate attribute is set
 *              to the timestamp contained in the scan object. Also, the customs
 *              reviewed flag is set to "N" and the overage reason code is set to
 *              "M". Furthermore, the shipmentOid number attribute is set to the
 *              shpmentOid number that was retreived from the Oid Factory.
 *
 *              The shipment object is persisted to the database.
 *
 *              The Scan object is updated with the shipmentOid number and the
 *              state object is returned to the caller.
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during Jolt service call to get Shipment Oid Number
 * @throws      cciij.util.CCIILogException Failure attempting to save Shipment
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *		ShipmentOverage
 *		ShipmentOverageDomestic
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001   Ed McAleer     Add tags and changed exceptions to CCIILogException.
 * 04/29/2002  Liu Xinghai  Added code for handling overage CRNs
 * 08/29/2002  Liu Xinghai  Fixed code to avoid invalid duplicate HU's being created in
 *                             wierd situations.
 * 03/10/2004   Gary Rockwood  Moved ShipmentOverage.java to ShipmentOverageBase.java and
 *                             added the 'setTravelStatusValue' method
 */

public abstract class ShipmentOverageBase extends BusinessActionBaseWithOidGeneration {

  private static final String m_whatVersion = "@(#) $RCSfile: ShipmentOverageBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public ShipmentOverageBase() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  protected abstract void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception;

    private void createMasterShellPieceRecord(CCIIState state,Shipment ship,DatabaseBean dbConnection) throws CCIILogException
    {
        HandlingUnit handlingUnit = new HandlingUnit(0,                                    // handlingUnitOid
                                                     state.getScan().getHAWB(),            // airbillNumber
                                                     state.getScan().getHAWBFormType(),    // formTypeCode
                                                     ship.getShipmentOidNumber(),          // shipmentOid
                                                     "",                                   // harmonizedTariffNumber
                                                     0.0f,                                 // totalWeight
                                                     "",                                   // totalWeightTypeCode
                                                     0.0,                                  // customsValueAmount
                                                     "",                                   // entryStatusCode
                                                     "",                                   // airbillTypeCode
                                                     "",                                   // detainmentLocationDescription
                                                     "",                                   //manifest status code
                                                     "");                                  //  pieceStatusCode

        try {
            handlingUnit.setHandlingUnitOidNumber(getOid(OidFactoryTypes.HANDLINGUNIT));
        }
        catch (Exception ex) {
            state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_JOLT_ERROR_NUMBER",
                                                           "Failure retreiving HandlingUnit Oid number");
            throw cciiEx;
        }

        handlingUnit.setRecurringSelectFlag("");
        handlingUnit.setLastModifiedTimeStamp( new Date(state.getScan().getSysDateTime()) );
        handlingUnit.setLastUserName(state.getScan().getUserLogon());
        //handlingUnit.setOverageReasonCode("M");
        handlingUnit.setOverageReasonCode("");
        try {
          setTravelStatusValue(handlingUnit, state);
        }
        catch (Exception ex) {
          traceLog("ShipmentOverageBase", "Exception in setting Travel Status");
        }

        try {
            dbConnection.saveHandlingUnit(handlingUnit);
        }
        catch (Exception ex ) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMBER","Error during save of HandlingUnit.");
            throw cciiEx;
        }

        return;
    }




   public CCIIState doIt(CCIIState state, DatabaseBean db_connection) throws Exception {

       boolean l_createMasterPieceRecord = false;

    traceLog("ShipmentOverageBase","begining doIt()");
    traceLog("ShipmentOverageBase",state);

    String awb = "";

    // need to check and see if the package is a CRN
    //  if true then set awb to "0"
    // so, create a handlingUnit from the data in the
    //  RPBScan, and check its isCRN() method

    HandlingUnit hu = new HandlingUnit(0,                                    // handlingUnitOid
                                       state.getScan().getAirbillNumber(),   // airbillNumber
                                       state.getScan().getAirbillFormType(), // formTypeCode
                                       0,                                    // shipmentOid
                                       "",                                   // harmonizedTariffNumber
                                       0.0f,                                 // totalWeight
                                       "",                                   // totalWeightTypeCode
                                       0.0,                                  // customsValueAmount
                                       "",                                   // entryStatusCode
                                       state.getScan().getAirbillType(),     // airbillTypeCode
                                       "",                                   // detainmentLocationDescription
                                       "",                                   //manifest status code
                                       "");                                  //  pieceStatusCode

    if ( hu.isCRN() == true ) {
        String l_HAWB=state.getScan().getHAWB();

        if((l_HAWB != null) && (l_HAWB.length() > 1))
        {
            awb = l_HAWB;
            if(l_HAWB.equals(state.getScan().getAirbillNumber()) == false)
            {
                l_createMasterPieceRecord = true;
            }
        }
        else
        {
            awb = "0";
        }
    }
    else {
        awb = state.getScan().getAirbillNumber();
    }

    Shipment shipment = new Shipment(0,                                         // shipmentOidNumber
                                     awb,                                       // airwayBill
                                     new Date(0),                               // shipdate date time
                                     0,
                                     0,
                                     false,
                                     false,
                                     "",
                                     "",
                                     state.getScan().getAirbillFormType(),    // formTypeCode
                                     "",                                     // manifestSatusCode
                                     "N");                                   // customs released flage

    shipment.setCustomsReviewedFlag("N");
    shipment.setOverageReasonCode("M");

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
                                                     "Failure attempting to save Shipment", ex);
       throw cciiEx;
    }

    if(l_createMasterPieceRecord)
    {
        createMasterShellPieceRecord(state,shipment,db_connection);
    }

    state.getScan().setShipmentOid( shipment.getShipmentOidNumber() );

    traceLog("ShipmentOverageBase","Returning...");

    return state;

    }

}
