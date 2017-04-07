package cciij.businessActions;

/**
 * Title:        Find CONS Summary
 * Description:  Find a  ConsSummary by CONS number. If the ConsSummary
 *               is not found, set the o_consOid to 0 in the CONSView.
 *               If the ConsSummary entry is found, set the following fields
 *               in the CONSView:
 *                  o_consOid,  s_containerInd,  s_containerId,  s_consDestLoc,
 *                  s_destCountry  from the ConsSummary record.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException ConsSummary fetch failed
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
 *   07/30/02    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindConsSummary extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: FindConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindConsSummary() throws Exception {
    traceLog("FindConsSummary","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    ConsSummary consSummary = null;

    traceLog("FindConsSummary", state);

    try {
      consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsId());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
      throw cciiEx;
    }

    if ( consSummary == null ) {
            state.getScan().setConsOid(0);
    }
    else
    {
            state.getScan().setConsOid( consSummary.getConsOidNumber() );

            state.getScan().setContainerInd( consSummary.getConsCode());
        state.getScan().setContainerId( consSummary.getContainerNumber());
        state.getScan().setConsDestLoc( consSummary.getDestinationLocationCode());
        state.getScan().setDestCountry( consSummary.getDestinationCountryCode());
    }

    return state;

  }

public static void main(String[] args){
     System.out.println("FindConsSummary in main");

     System.out.println("Leaving main");
    }


}
