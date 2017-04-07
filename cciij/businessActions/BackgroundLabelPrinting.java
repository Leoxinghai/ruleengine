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

import cciij.businessActions.label.*;

public class BackgroundLabelPrinting extends BusinessActionBase {

private FileBasedLabel picklistLabel;
private BusinessActionInterface labelObject = null;
private static final String m_whatVersion = "@(#) $RCSfile: BackgroundLabelPrinting.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public BackgroundLabelPrinting() throws Exception {
    traceLog("BackgroundLabelPrinting","In Constructor");
     picklistLabel = new FileBasedLabel("PickListLabel");
  }
protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
}

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
    Shipment shipment = null;
    HandlingUnit hu = null;
    StagingArea stageArea = null;



// look up the stageArea from piece_core_clearance, if its not there
//  just return without any action,
// look up the printer for the stage area, if its not defined return

    try {
      hu = dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       throw ex;
    }

    if ( hu == null ) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      throw new Exception("HU fetch by handlingUnitOid failed, oid == " + state.getScan().getHandlingUnitOid());
    }

    if ( hu.getStagingAreaCode().equals("") == false ) {
      state.getScan().setStagingAreaCode(hu.getStagingAreaCode());
      state.getScan().setDetainLoc(hu.getDetainmentLocationDescription());
      traceLog("BackgroundLabelPrinting",state);
      stageArea = dbConnection.fetchStagingArea(hu.getStagingAreaCode());
      if ( stageArea != null ) {
        if ( stageArea.getPrinterCode().equals("") == false ) {
          state.getScan().setPrinterCode(stageArea.getPrinterCode());
        }
        else {  // printer not defined for this stage area
          state.getScan().setReturnMessage("No printer for stageArea, nothing printed");
          return state;
        }
      }
      else {
        state.getScan().setErrorNumber(Messages.EM_INV_STAGE_AREA);
        state.getScan().setReturnMessage("Invalid stageArea from handlingUnit record");
        return state;
      }
    }
    else { // no stageArea in the hu record
 //      state.getScan().setErrorNumber(Messages.IM_NOT_PRINTED) // or something
       return state;
    }

// get the shipment data for the handling unit

   try {
     shipment = dbConnection.fetchShipment(hu.getShipmentOidNumber());
   }
   catch (Exception ex) {
     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
     throw ex;
   }

   if ( shipment == null ) {
     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
     throw new Exception("Shipment fetch by shipmentOid failed, oid == " + hu.getShipmentOidNumber());
   }

// get the hawb for this piece
   state.getScan().setHAWB(shipment.getAWBNumber());
   state.getScan().setHAWBFormType(shipment.getFormTypeCode());
// add items to the printData map for label purposes
   state.m_printData.put("PieceQuantity",new Integer(shipment.getPieceQuanity()).toString());
   state.m_printData.put("BrokerEntryNumber",shipment.getBrokerEntryNumber());
   state.m_printData.put("ServiceCode",shipment.getServiceCode());
   state.m_printData.put("LocationCode",state.getScan().getLocationCode());

   picklistLabel.doIt(state,dbConnection);

   return state;
  }

 public static void main(String[] args){
     System.out.println("Business Action BackgroundLabelPrinting in main");

     System.out.println("Leaving Business Action main");
    }

}
