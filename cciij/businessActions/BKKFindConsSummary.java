/*
 * Created on Mar 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */



import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class BKKFindConsSummary extends BusinessActionBase {

	  private static final String m_whatVersion = "@(#) $RCSfile: BKKFindConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
	  public BKKFindConsSummary() throws Exception {
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
	    		state.getScan().setErrorNumber(Messages.EM_CONS_NOT_FOUND);
	            state.getScan().setConsOid(0);
	    }
	    else
	    {
            state.getScan().setConsOid( consSummary.getConsOidNumber() );
            state.getScan().setContainerInd( consSummary.getConsCode());
	        state.getScan().setContainerId( consSummary.getContainerNumber());
	        state.getScan().setConsDestLoc( consSummary.getDestinationLocationCode());
	        state.getScan().setDestCountry( consSummary.getDestinationCountryCode());
	        state.getScan().setSplitNumber(String.valueOf(consSummary.getSplitNumber()));
	    }

	    return state;

	  }

	public static void main(String[] args){
	     System.out.println("FindConsSummary in main");

	     System.out.println("Leaving main");
	    }


	}
