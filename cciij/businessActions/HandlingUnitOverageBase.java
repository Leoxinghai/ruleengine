package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:       Handling Unit Overage Base
 *
 * Description: Create a HandlingUnit object using the attributes of the scan object.
 *              Obtain an Oid number from the Oid factory for a HandlingUnit.
 *              Persist the HandlingUnit object to the database. \
 *              Return the state object to the caller.
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throw       cciij.util.CCIILogException Failure retreiving HandlingUnit Oid number
 * @throw       cciij.util.CCIILogException Error during save of HandlingUnit
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *		HandlingUnitOverage
 *		HandlingUnitOverageDomestic
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer    Add comments and document tags.
 * 03/10/2004    Gary Rockwood Created the Base from the original HandlingUnitOverage.java
 *                             Added the 'setTravelStatusValue' method
 */

public abstract class HandlingUnitOverageBase extends BusinessActionBaseWithOidGeneration {

   public HandlingUnitOverageBase() throws Exception
   {
       traceLog("HandlingUnitOverage","In constructor");
   }

  private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnitOverageBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  protected abstract void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception;

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    traceLog("HandlingUnitOverage","Begining doIt()");

    traceLog("HandlingUnitOverage","Create HU Shell");

    HandlingUnit handlingUnit = new HandlingUnit(0,
                                                 state.getScan().getAirbillNumber(),
                                                 state.getScan().getAirbillFormType(),
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
    handlingUnit.setOverageReasonCode("M");

    try {
      setTravelStatusValue(handlingUnit, state);
    }
    catch (Exception ex) {
      traceLog("HandlingUnitOverageBase", "Exception in setting Travel Status");
    }


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


}
