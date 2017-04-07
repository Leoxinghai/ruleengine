package cciij.businessActions;

/**
 * Title:        Find Customs Release
 *
 * Description:  This business action will first determine if the site allows
 *               positive sorts. If the site is NOT configured to support positive
 *               sorts, then no other processing is necessary and the state object
 *               is returned to the caller.
 *
 *               If the site supports postive sorts, check for either an overage flag of
 *               "Y" or a shipmentOid of "0" (ZERO) and a view name other than
 *               IPAVIEW. If the above conditions are met, set the state object return message
 *               and error message to "Not found". Return the state object to the caller.
 *
 *               If the site supports postive sorts and the check above fails
 *               (Not an overage OR shipmentOid > 0 AND view name != IPAVIEW)
 *               Look at the customsReleased attirbute in the state object,
 *               If its not released, set the state object to indicate
 *               a Positive Sort intercept condition exists, and assign
 *               print data to the print map
 *
 *               Finally, return the state object to the caller.
 *
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author       Robert Fisher
 * @version 1.0
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
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.CCIILogException;


public class FindCustomsRelease extends FindIntercept {

  private static final String m_whatVersion = "@(#) $RCSfile: FindCustomsRelease.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  private String m_defaultAgencyCode = "";
  private String m_defaultInterceptCode = "";

  public FindCustomsRelease() throws Exception {
    traceLog("FindCustomsRelease","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_defaultAgencyCode = readConfigVariableString("DEFAULT_AGENCY_CODE");
    m_defaultInterceptCode = readConfigVariableString("DEFAULT_INTERCEPT_CODE");
  }

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Intercept customsRelease = null;
    boolean released = false;
    boolean foundActive = false;
    Shipment shipment = null;
    // if the site is NOT a positive sort then no need
    //   to proceed beyond this check
    if ( state.getPositiveSort() == false ) {
      return state;
    }

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

      state.getScan().setCustomsReleasedFlag(shipment.getCustomsReleaseFlag());

/*
    if ( (state.getOverageFlag().equals("Y")
//         || state.getOverageFlag().equals("M")
         || state.getScan().getShipmentOid() == 0 )
         && state.getScan().getInViewName().toUpperCase().equals("IPAVIEW") == false ) {
      state.getScan().setReturnMessage("Not found");
      state.getScan().setErrorNumber(Messages.IM_NOT_FOUND);
      return state;
    }


    if ( state.getScan().getCustomsReleasedFlag().equals("Y") == false ) {
       traceLog("FindCustomsRelease","not released: need a positive sort intercept");
       state.getScan().setReturnMessage("Not Released");
       state.getScan().setErrorNumber(Messages.IM_NOT_RELEASED);
       state.setInterceptedFlag("POSITIVESORT");
       state.getScan().setAgencyCode(m_defaultAgencyCode);
       state.getScan().setInterceptCode(m_defaultInterceptCode);

       getStageAreaForIntercept(state.getScan().getWarehouseCode(),
				state.getScan().getAgencyCode(),
                                state.getScan().getInterceptCode(),
                                state,
                                dbConnection);
       getDiverterForStageArea(state,dbConnection);
       state.m_printData.put("Agency" + "1",state.getScan().getAgencyCode());
       state.m_printData.put("Agency" + "1" + "Intercept" + "1", state.getScan().getInterceptCode());
    }

    traceLog("FindCustomsRelease",state);
*/
    return state;
}


}