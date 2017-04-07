package cciij.businessActions;

/**
 * Title:        Duplicate Processing 01
 * Description:
 *
 *
 *
 *
 *
 *
 *
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @exception    java.lang.Exception if error encountered attempting to fetch HandlingUnit.
 * @throws       java.lang.Exception fetch by HandlingUnitOid returned NULL
 * @throws       java.lang.Exception after setting the error number in the state object.
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class DuplicateProcessing01 extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: DuplicateProcessing01.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public DuplicateProcessing01() throws Exception {
    traceLog("DuplicateProcessing01","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    HandlingUnit handlingUnit = null;
    Shipment shipment = null;
    String currentOrigin = "";
    String currentDestination = "";
    boolean allowUserResolution = false;

    traceLog("DuplicateProcessing01", state);

    if ( state.getDuplicateResolution() == false ) {
      state.setRuleSetName("DUPLABEL");
      return state;
    }

    try {
      handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getAirbillNumber(),
						     m_locationList.getLocationList());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed");
      throw cciiEx;
    }

    if ( handlingUnit == null ) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","HandlingUnit fetch by tracking number returned null");
      throw cciiEx;
    }

    shipment = getShipment(handlingUnit, dbConnection, state);

    currentOrigin = shipment.getOriginLocCode();
    currentDestination = shipment.getDestinationLocCode();

    handlingUnit = getNextHandlingUnit(dbConnection, state);

    while ( handlingUnit != null && allowUserResolution == false ) {

      shipment = getShipment(handlingUnit, dbConnection, state);

      if ( shipment.getOriginLocCode().equals(currentOrigin) == false
           || shipment.getDestinationLocCode().equals(currentDestination) == false ) {
       allowUserResolution = true;
      }

      handlingUnit = getNextHandlingUnit(dbConnection, state);
    }

// if allowUser resolution has been set then update the error to
//  EM_DUP and the action sequence will abort and return the message
//  otherwise change the ruleset name and ruleprocessor will execute
//  the ruleset to produce the label

    if ( allowUserResolution == true ) 
    {
	state.getScan().setErrorNumber(Messages.EM_DUP_PIECE);
    }
    else 
    {
	String dupRuleSetName = m_config.getValue("DUPLABVIEW_RULESET");

	if((dupRuleSetName == null) || (dupRuleSetName.equals("")))
	{
	    state.getScan().setErrorNumber(Messages.EM_SYSTEM_ERROR);
	}
	else
	{
	    state.setRuleSetName(dupRuleSetName);
	}
    }

   return state;

  }


private Shipment getShipment(HandlingUnit hu,
                             DatabaseBean db,
                             CCIIState s) throws Exception {
   Shipment ship = null;

    try {
      ship = db.fetchShipment(hu.getShipmentOidNumber());
    }
    catch (Exception ex) {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment fetch failed");
      throw cciiEx;
    }

    if ( ship == null ) {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","shipment fetch by shipmentOid returned null");
      throw cciiEx;
    }

    return ship;

}

private HandlingUnit getNextHandlingUnit(DatabaseBean db,
                                         CCIIState s) throws Exception {

  HandlingUnit hu = null;

    try {
      hu = db.fetchNextHandlingUnit();
    }
    catch (Exception ex) {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Next Handling Unit fetch failed");
      throw cciiEx;
    }

    return hu;
}

public static void main(String[] args){
     System.out.println("DuplicateProcessing01 in main");

     System.out.println("Leaving main");
    }


}
