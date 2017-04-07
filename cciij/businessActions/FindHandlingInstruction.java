package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Find HandlingInstruction
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException FindHandlingInstruction called with out valid shipment or hu oid
 * @throws      cciij.util.CCIILogException Fetch of handlingInstruction using shipmentOid or PieceOid failed
 * @throws      cciij.util.CCIILogException FetchNext of HandlingInstruction failed
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


public class FindHandlingInstruction extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindHandlingInstruction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public FindHandlingInstruction() throws Exception {
    traceLog("FindHandlingInstruction","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception {
    super.readSiteConfigVariables();
  }

  // FindHandlingInstruction looks for handlingInstructions
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
    HandlingInstructions handlingInstruction = null;
    Vector handlingInstructionVector = null;

    traceLog("FindHandlingInstruction","begining doIt");
    traceLog("FindHandlingInstruction",state);

    if (   state.getScan().getShipmentOid() == 0
        && state.getScan().getHandlingUnitOid() == 0 ) {
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                     "FindHandlingInstruction called with out valid shipment or hu oid");
      throw cciiEx;
    }

    try {
      handlingInstruction = dbConnection.fetchHandlingInstructionByShipmentOrPieceOid(state.getScan().getShipmentOid(),
                                                                                      state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Fetch of handlingInstruction using shipmentOid or PieceOid failed:  " + ex);
      throw cciiEx;
    }

    if ( handlingInstruction == null ) {
      // the fetch for handlingInstructions found none
      state.setHandlingInstructionFlag(false);
    }
    else {
      while ( handlingInstruction != null ) {
        traceLog("FindHandlingInstruction","Found a HandlingInstruction");

        if (handlingInstruction.getActiveFlag().equals("Y") == true) {
          state.setHandlingInstructionFlag(true);
        }
        state.addHandlingInstruction(handlingInstruction);

        try {
          handlingInstruction = dbConnection.fetchNextHandlingInstruction();
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                         "Next HandlingInstruction fetch failed:  " + ex);
          throw cciiEx;
        }
      }
    }

    return state;
  }


  public static void main(String[] args){
    System.out.println("Business Action FindHandlingInstruction in main");

    System.out.println("Leaving Business Action main");
  }

}
