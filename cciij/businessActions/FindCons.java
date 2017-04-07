package cciij.businessActions;

/**
 * Title:        Find CONS
 * Description:  Find a Tracking Number in the Cons database table.  If the Cons entry
 *               is not found, set the i_errorNumber to EM_AB_NOT_IN_CONS.
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
 *   07/31/02    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindCons extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindCons.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindCons() throws Exception {
    traceLog("FindCons","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Cons cons = null;

    traceLog("FindCons", state);

    try {
      cons =  dbConnection.fetchCons(state.getScan().getConsOid(), state.getScan().getAirbillNumber());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
      throw cciiEx;
    }

    if ( cons == null ) {
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);

    } else if(cons != null && !cons.getConsFormTypeCode().equals("0503")&& !cons.getConsFormTypeCode().equals("0501")) {
        if(cons.getOidNumber() != state.getScan().getHandlingUnitOid())
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
    } else if (cons.getDeconsFlag().equals("D"))
    {
        // The entry is already marked as deleted, set error code and return
        state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
        state.getScan().setReturnMessage("AWB already marked as deleted from CONS");
    }
    return state;

  }

public static void main(String[] args){
     System.out.println("FindCons in main");

     System.out.println("Leaving main");
    }


}
