/*
 * Created on Mar 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;


import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.util.*;

public class FindSplit extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: FindSplit.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  SortDate m_sortDate = new SortDate();

  public FindSplit() throws Exception
  {
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
  	Split split = null;
  	int iSplitNumber = 0;
  	if(state.getScan().getSplitNumber() == null || state.getScan().getSplitNumber().equals("")) {
  		state.getScan().setErrorNumber(Messages.EM_SPLIT_INVALID);
  		return state;
  	}
  	try {
  		iSplitNumber = Integer.parseInt(state.getScan().getSplitNumber());
  	} catch(Exception ex0) {
  		state.getScan().setErrorNumber(Messages.EM_SPLIT_INVALID);
  		return state;
  	}
  	
  	try {
  		split = dbConnection.fetchSplit(iSplitNumber);
  	} catch(Exception ex) {
  		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
  		throw ex;
  	}
  	if(split == null) {
  		state.getScan().setErrorNumber(Messages.EM_SPLIT_NOT_EXIST);
  	}
    return state;
  }
  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }
  
   public static void main(String args[])
  {
   } 
   
   public void  test() throws Exception
   {
        return;
    }
  
}

