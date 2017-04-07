/*
 * Created on May 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindBatchCons extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindBatchCons.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  public FindBatchCons() throws Exception {
    traceLog("FindCons","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    BatchCons cons = null;

    traceLog("FindCons", state);

    try {
      cons =  dbConnection.fetchBatchCons(state.getScan().getConsOid(), state.getScan().getAirbillNumber(),false);
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
      throw cciiEx;
    }

    if ( cons == null ) {
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
    }

    return state;

  }

public static void main(String[] args){
     System.out.println("FindCons in main");

     System.out.println("Leaving main");
    }


}

