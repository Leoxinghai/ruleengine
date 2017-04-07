/*
 * Created on Mar 11, 2006
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

import java.util.Date;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class BKKMPSLinkToShipment extends BusinessActionBaseWithOidGeneration {

	  private static final String m_whatVersion = "@(#) $RCSfile: BKKMPSLinkToShipment.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
	  public BKKMPSLinkToShipment() throws Exception {
	    traceLog("FindShipment","In Constructor");
	  }

	  protected void readSiteConfigVariables() throws Exception
	  {
	    super.readSiteConfigVariables();
	    //no local variables to read
	  }

	public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

	    Shipment shipment = null;
	    traceLog("BKKMPSLinkToShipment", state);
	    HandlingUnit handlingunit = null;
	    try {
	      shipment =  dbConnection.fetchShipment(state.getScan().getAirbillNumber());
	      if(shipment ==null) {
	      	shipmentOverage(state,dbConnection);
	      }
	      handlingunit = dbConnection.fetchHandlingUnit(state.getScan().getConsId());
	      if(handlingunit !=null) {
	      	state.getScan().setErrorNumber(303);
	      }
	      handlingUnitOverage(state,dbConnection);
	      
	    }
	    catch (Exception ex) {
	      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment Fetch Failed");
	      throw cciiEx;
	    }

	    return state;

	  }

	private CCIIState shipmentOverage(CCIIState state,DatabaseBean dbConnection) throws Exception {
	    Shipment shipment = new Shipment(0,                                         // shipmentOidNumber
                state.getScan().getAirbillNumber(),         // airwayBill
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
		state.getScan().setShipmentOid(shipment.getShipmentOidNumber());
		}
		catch (Exception ex) {
		state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
		CCIILogException cciiEx = new CCIILogException("BA_JOLT_ERROR_NUMB",
		                                "Failure during Jolt service call to get Shipment Oid Number");
		throw cciiEx;
		}

		try {
			dbConnection.saveShipment(shipment);
		}
		catch (Exception ex ) {
		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
		CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
		                                "Failure attempting to save Shipment", ex);
		throw cciiEx;
		}
	
		state.getScan().setShipmentOid( shipment.getShipmentOidNumber() );
		traceLog("ShipmentOverageBase","Returning...");

		
		return state;
	}
	
	
	private CCIIState handlingUnitOverage(CCIIState state, DatabaseBean dbConnection) throws Exception {
	    HandlingUnit handlingUnit = new HandlingUnit(0,
                state.getScan().getConsId(),
                state.getScan().getConsFormType(),
                state.getScan().getShipmentOid(),
                "",                                 //harmonized tariff Number
                0.0f,                               //total weight
                "",                                 //total weight type code
                0.0,                                //customs value amount
                "",                                 //entryStatusCode
                state.getScan().getAirbillType(),   //airbillTypeCode
                state.getScan().getDetainLoc(),     //detainmentLocDescription
                "",                                 //manifest status code
                "");                                //piece status code
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
			handlingUnit.setOverageReasonCode("");
			
			try {
			dbConnection.saveHandlingUnit(handlingUnit);
			}
			catch (Exception ex ) {
			state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
			CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMBER","Error during save of HandlingUnit.");
			throw cciiEx;
			}
			
			state.getScan().setHandlingUnitOid( handlingUnit.getHandlingUnitOidNumber() );
			
			traceLog("HandlingUnitOverage","returning....");
			return state;
		
	}
	
	public static void main(String[] args){
	     System.out.println("FindShipment in main");


	     System.out.println("Leaving main");
	    }

	}