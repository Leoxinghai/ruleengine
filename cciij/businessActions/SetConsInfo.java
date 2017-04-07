package cciij.businessActions;

/**
 * Title:        Set CONS Info
 * Description:  Find a  ConsSummary by CONS number. If the ConsSummary
 *               is not found, clear cons info in the current scan also
 *               set the split Number to 0.
 *               If the ConsSummary entry is found, set the following fields
 *               in the CONSView:
 *                  o_consOid,  s_containerInd,  s_containerId,  s_consDestLoc,
 *                  s_destCountry, s_splitNumber from the ConsSummary record.
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
 *   11/02/04    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class SetConsInfo extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: SetConsInfo.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public SetConsInfo() throws Exception {
    traceLog("SetConsInfo","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    ConsSummary consSummary = null;

    traceLog("SetConsInfo", state);

    try {
      consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsId());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
      throw cciiEx;
    }

    if ( consSummary == null ) {
        // Cons entry not found, set fields to empty string
        state.getScan().setConsOid(0);
        state.getScan().setConsType( "" );
        state.getScan().setContainerInd( "" );
        state.getScan().setContainerId( "" );
        state.getScan().setConsDestLoc( "" );
        state.getScan().setDestCountry( "" );
        state.getScan().setSplitNumber( "" );
        state.getScan().setConsId( "" );
        state.getScan().setConsFormType( "" );
    }
    else
    {
        // Get the information from the Cons Summary and put into current Scan View
        state.getScan().setConsOid( consSummary.getConsOidNumber() );
        state.getScan().setConsType( "O" );       // Cons Type is always "O"ther
        state.getScan().setContainerInd( consSummary.getConsCode() );
        state.getScan().setContainerId( consSummary.getContainerNumber() );
        state.getScan().setConsDestLoc( consSummary.getDestinationLocationCode() );
        state.getScan().setDestCountry( consSummary.getDestinationCountryCode() );
        state.getScan().setSplitNumber( Integer.toString((int)consSummary.getSplitNumber()) );
        state.getScan().setConsFormType( consSummary.getConsFormTypeCode());
    }

    return state;

  }

public static void main(String[] args){
     System.out.println("FindConsSummary in main");

     System.out.println("Leaving main");
    }


}
