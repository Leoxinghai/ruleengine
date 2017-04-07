package cciij.businessActions;

/**
 * Title:        DummyBrokerLookup
 * Description:  BA to allow the rule to add configurable activities when appropriate
 *                  ie:  Associate Master to CRN
 *
 *
 *
 *
 *
 *
 *
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author      Liu Xinghai
 * @version 1.0
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        state - valid state object, set up by actionEntry(from base class)
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   3/11/2003  MWR  Created
 *
 */

import cciij.cciidatabase.DatabaseBean;
import cciij.cciidata.CCIIState;
import cciij.util.CCIILogException;

public class DummyBrokerLookup extends BusinessActionBase {

    private static final String m_whatVersion = "@(#) $RCSfile: DummyBrokerLookup.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    protected String m_groupName;

    public DummyBrokerLookup() throws Exception
    {
	traceLog("DummyBrokerLookup","In Constructor()");
    }

    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
	state.getScan().setBrokerClassificationCode("TST");
	state.addPrintMapElement("ClearanceStatus","DUMMY");
	state.addPrintMapElement("MAWB","000000000000");
	state.getUploadStatus().setBondTransferFlag(false);
	state.getUploadStatus().setMPSIncompleteFlag(false);

	return state;
    }



    public static void main(String[] args){
	System.out.println("DummyBrokerLookup in main");


	System.out.println("Leaving main");
    }


}
