package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import java.util.Date;

public class AssignCRNToHAWB extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: AssignCRNToHAWB.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public AssignCRNToHAWB() throws Exception {
    traceLog("AssignCRNToHAWB","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Shipment shipment = null;
    HandlingUnit handlingUnit = null;

// Look up the shipment, we need the shipment_oid
//  to update the CRN with

   try {
     shipment = dbConnection.fetchShipment(state.getScan().getHAWB(),
                                           m_locationList.getLocationList());
   }
   catch(Exception ex) {
     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
     throw ex;
   }

   if ( shipment == null ) {
     state.getScan().setErrorNumber(Messages.EM_NOT_FOUND);
     return state;
   }

   if ( dbConnection.getShipmentRecordCount() > 1 ) {
     state.getScan().setErrorNumber(Messages.EM_DUP_SHIPMENT);
     return state;
   }
// Look up the CRN for updating

   try {
     handlingUnit = dbConnection.fetchHandlingUnit(state.getScan().getAirbillNumber(),
                                                   m_locationList.getLocationList());
   }
   catch(Exception ex) {
     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
     throw ex;
   }

   if ( handlingUnit == null ) {
     state.getScan().setErrorNumber(Messages.EM_NOT_FOUND);
     return state;
   }

   if ( dbConnection.getHandlingUnitRecordCount() > 1 ) {
     state.getScan().setErrorNumber(Messages.EM_DUP_PIECE);
     return state;
   }


   HandlingUnit hu = new HandlingUnit(handlingUnit.getHandlingUnitOidNumber(),
                                   handlingUnit.getTrackingNumber(),
                                   handlingUnit.getFormTypeCode(),
                                   shipment.getShipmentOidNumber(),
                                   handlingUnit.getHarmonizedTariffNumber(),
                                   handlingUnit.getTotalWeight(),
                                   handlingUnit.getTotalWeightTypeCode(),
                                   handlingUnit.getCustomsValueAmount(),
                                   handlingUnit.getEntryStatusCode(),
                                   handlingUnit.getAirbillTypeCode(),
                                   handlingUnit.getDetainmentLocationDescription(),
                                   handlingUnit.getManifestStatusCode(),
                                   handlingUnit.getPieceStatusCode());


   hu.setLastModifiedTimeStamp(new Date(state.getScan().getSysDateTime()));
   hu.setLastUserName(state.getScan().getUserLogon());
   hu.setOverageReasonCode(handlingUnit.getOverageReasonCode());
   hu.setNullCoreClearance(handlingUnit.getNullCoreClearance());
   hu.setLocationCode(handlingUnit.getLocationCode());


   traceLog("AssignCRNToHAWB",shipment);

   traceLog("AssignCRNToHAWB",hu);

   try {
     dbConnection.updateHandlingUnit(hu);
   }
   catch (Exception ex) {
     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
     throw ex;
   }
   state.getScan().setShipmentOid(shipment.getShipmentOidNumber());
   state.getScan().setHandlingUnitOid(hu.getHandlingUnitOidNumber());
    traceLog("AssignCRNToHAWB", state);

    return state;

  }

public static void main(String[] args){
     System.out.println("AssignCRNToHAWB in main");

     DatabaseBean db = new DatabaseBean();

     db.connect();
     HandlingUnit hu = null ;

     try {
       hu = db.fetchHandlingUnit("825955495854");
     }
     catch (Exception ex) {
       System.out.println("Caught an Exception during fetch");
       ex.printStackTrace();
     }

     if ( hu != null ) {
       System.out.println(hu.getHandlingUnitOidNumber());
     }
     else {
       System.out.println("Didnt find the HU you wanted!!");
     }

     System.out.println("Leaving main");
    }

}
