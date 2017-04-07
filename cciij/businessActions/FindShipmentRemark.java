package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Find ShipmentRemark
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException FindShipmentRemark called with out valid shipment or hu oid
 * @throws      cciij.util.CCIILogException Fetch of shipmentRemark using shipmentOid or PieceOid failed
 * @throws      cciij.util.CCIILogException FetchNext of ShipmentRemark failed
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


public class FindShipmentRemark extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindShipmentRemark.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public FindShipmentRemark() throws Exception {
    traceLog("FindShipmentRemark","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception {
    super.readSiteConfigVariables();
  }

  // FindShipmentRemark looks for shipmentRemarks
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
    ShipmentRemark shipmentRemark = null;
    Vector shipmentRemarkVector = null;

    traceLog("FindShipmentRemark","begining doIt");
    traceLog("FindShipmentRemark",state);

    if (   state.getScan().getShipmentOid() == 0
        && state.getScan().getHandlingUnitOid() == 0 ) {
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                     "FindShipmentRemark called with out valid shipment or hu oid");
      throw cciiEx;
    }

    try {
      shipmentRemark = dbConnection.fetchShipmentRemarkByShipmentOrPieceOidNbr(state.getScan().getShipmentOid(),
                                                                               state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Fetch of shipmentRemark using shipmentOid or PieceOid failed:  " + ex);
      throw cciiEx;
    }

    if ( shipmentRemark == null ) {
      // the fetch for ShipmentRemarks found none
      state.setShipmentRemarkFlag(false);
    }
    else {
      while ( shipmentRemark != null ) {
        traceLog("FindShipmentRemark","Found a ShipmentRemark");

        state.setShipmentRemarkFlag(true);
        state.addShipmentRemark(shipmentRemark);

        try {
          shipmentRemark = dbConnection.fetchNextShipmentRemark();
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                         "Next ShipmentRemark fetch failed:  " + ex);
          throw cciiEx;
        }
      }
    }

    return state;
  }


  public static void main(String[] args){
    System.out.println("Business Action FindShipmentRemark in main");

    System.out.println("Leaving Business Action main");
  }
}
