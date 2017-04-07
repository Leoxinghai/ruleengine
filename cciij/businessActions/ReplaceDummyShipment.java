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

public class ReplaceDummyShipment extends BusinessActionBase {

      private static final String m_whatVersion = "@(#) $RCSfile: ReplaceDummyShipment.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
      public ReplaceDummyShipment() throws Exception {
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
        traceLog("ReplaceDummyShipment", state);
        try {
          shipment =  dbConnection.fetchShipment(state.getScan().getHAWB());
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
    	    handlingUnit = dbConnection.fetchHandlingUnit(state.getScan().getAirbillNumber());
		    if ( handlingUnit == null ) {
			    System.out.println("Got null from HandlingUnit fetch using shipmentOid");
				state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
				CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
			                "Fetch by shipmentOid returned NULL, shipmentOid ==" + state.getScan().getShipmentOid());
			    throw cciiEx;
			}
		    handlingUnit.setShipmentOidNumber(shipment.getShipmentOidNumber());
    	    dbConnection.updateHandlingUnit(handlingUnit);
    	    state.getScan().setHandlingUnitOid(handlingUnit.getHandlingUnitOidNumber());
    	    state.getScan().setShipmentOid(shipment.getShipmentOidNumber());
        } catch (Exception ex2) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment Fetch Failed");
            throw cciiEx;
        }
       
        return state;
      }

    public static void main(String[] args){
         System.out.println("FindShipment in main");


         System.out.println("Leaving main");
        }

    }