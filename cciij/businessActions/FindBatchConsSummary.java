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

public class FindBatchConsSummary extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: FindBatchConsSummary.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  public FindBatchConsSummary() throws Exception {
    traceLog("FindConsSummary","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    BatchConsSummary consSummary = null;

    traceLog("FindConsSummary", state);

    try {
      consSummary =  dbConnection.fetchBatchConsSummary(state.getScan().getConsId());
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
      throw cciiEx;
    }

    if ( consSummary == null ) {
            state.getScan().setConsOid(0);
            state.getScan().setErrorNumber(Messages.EM_BATCH_NOT_FOUND);
    }
    else
    {
        state.getScan().setConsOid( consSummary.getConsOidNumber() );

        state.getScan().setContainerInd( consSummary.getConsCode());
        state.getScan().setContainerId( consSummary.getFlightNumber());
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
