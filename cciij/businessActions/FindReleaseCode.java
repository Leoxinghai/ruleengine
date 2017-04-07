package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Find ReleaseCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException FindReleaseCode called with out valid shipment or hu oid
 * @throws      cciij.util.CCIILogException Fetch of releaseCode using shipmentOid or PieceOid failed
 * @throws      cciij.util.CCIILogException FetchNext of ReleaseCode failed
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


public class FindReleaseCode extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public FindReleaseCode() throws Exception {
    traceLog("FindReleaseCode","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception {
    super.readSiteConfigVariables();
  }

  // FindReleaseCode looks for releaseCodes
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
    ReleaseCode releaseCode = null;
    Vector releaseCodeVector = null;

    traceLog("FindReleaseCode","begining doIt");
    traceLog("FindReleaseCode",state);

    if (   state.getScan().getShipmentOid() == 0
        && state.getScan().getHandlingUnitOid() == 0 ) {
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                     "FindReleaseCode called with out valid shipment or hu oid");
      throw cciiEx;
    }

    try {
      releaseCode = dbConnection.fetchReleaseCodeByShipOrPieceOid(state.getScan().getLocationCode(),
                                                                  state.getScan().getShipmentOid(),
                                                                  state.getScan().getHandlingUnitOid());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Fetch of releaseCode using shipmentOid or PieceOid failed:  " + ex);
      throw cciiEx;
    }

    if ( releaseCode == null ) {
      // the fetch for ReleaseCodes found none
      state.setCAGEReleaseCodeFlag(false);
    }
    else {
      while ( releaseCode != null ) {
        traceLog("FindReleaseCode","Found a ReleaseCode");

        if (releaseCode.getActiveInactiveFlag().equals("Y") == true) {
          state.setCAGEReleaseCodeFlag(true);
        }
        state.addCAGEReleaseCode(releaseCode);

        try {
          releaseCode = dbConnection.fetchNextReleaseCode();
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                         "Next ReleaseCode fetch failed:  " + ex);
          throw cciiEx;
        }
      }
    }

    return state;
  }


  public static void main(String[] args){
    System.out.println("Business Action FindReleaseCode in main");

    System.out.println("Leaving Business Action main");
  }
}
