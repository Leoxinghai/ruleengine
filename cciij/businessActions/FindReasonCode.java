package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Find ReasonCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException FindReasonCode called with out valid shipment or hu oid
 * @throws      cciij.util.CCIILogException Fetch of reasonCode using shipmentOid or PieceOid failed
 * @throws      cciij.util.CCIILogException FetchNext of ReasonCode failed
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *  none
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *  01/26/2004  Tom Knobeloch   Enhanced database exception logging.
 */


public class FindReasonCode extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindReasonCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public FindReasonCode() throws Exception {
    traceLog("FindReasonCode","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception {
    super.readSiteConfigVariables();
  }

  // FindReasonCode looks for reasonCodes
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
    ReasonCode reasonCode = null;
    Vector reasonCodeVector = null;

    traceLog("FindReasonCode","begining doIt");
    traceLog("FindReasonCode",state);

    if (   state.getScan().getShipmentOid() == 0
        && state.getScan().getHandlingUnitOid() == 0 ) {
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                     "FindReasonCode called with out valid shipment or hu oid");
      throw cciiEx;
    }

    try {
      reasonCode = dbConnection.fetchReasonCodeByShipOrPieceOid(state.getScan().getLocationCode(),
                                                                state.getScan().getShipmentOid(),
                                                                state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Fetch of reasonCode using shipmentOid or PieceOid failed:  " + ex);
      throw cciiEx;
    }

    if ( reasonCode == null ) {
      // the fetch for ReasonCodes found none
      state.setCAGEReasonCodeFlag(false);
    }
    else {
      while ( reasonCode != null ) {
        traceLog("FindReasonCode","Found a ReasonCode");

        if (reasonCode.getActiveInactiveFlag().equals("Y") == true) {
          state.setCAGEReasonCodeFlag(true);
        }
        state.addCAGEReasonCode(reasonCode);

        try {
          reasonCode = dbConnection.fetchNextReasonCode();
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                         "Next ReasonCode fetch failed:  " + ex);
          throw cciiEx;
        }
      }
    }

    return state;
  }


  public static void main(String[] args){
    System.out.println("Business Action FindReasonCode in main");

    System.out.println("Leaving Business Action main");
  }
}
