package cciij.businessActions;

/**
 * Title:        Find Nested CONS Summary
 * Description:  Find a  NestedConsSummary by CONS number. If the NestedConsSummary
 *               is not found, set the i_inputError to EM_CONS_NOT_FOUND in the CONSView.
 *               If the NestedConsSummary entry is found, return without setting any error.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2001
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

public class FindNestedConsSummary extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindNestedConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindNestedConsSummary() throws Exception {
    traceLog("FindNestedConsSummary","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    ConsSummary consSummary = null;

    traceLog("FindNestedConsSummary", state);

    try {
      consSummary =  dbConnection.fetchConsSummary(state.getScan().getAirbillNumber());   // The airbill field has the nested CONS
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
      throw cciiEx;
    }

    if ( consSummary == null ) {
            state.getScan().setErrorNumber(Messages.EM_CONS_NOT_FOUND);
    }
    else
    {
        // Get the Cons Oid and put into PieceOid area of View
        state.getScan().setHandlingUnitOid(consSummary.getConsOidNumber());
    }

    return state;

  }

public static void main(String[] args){
     System.out.println("FindNestedConsSummary in main");

     System.out.println("Leaving main");
    }


}
