/*
 * Created on Mar 11, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

import cciij.cciidata.CCIIState;
import cciij.cciidata.Scan;
import cciij.cciidatabase.DatabaseBean;
import cciij.util.CCIILogException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
	public abstract class BKKRIPCoreProcessor extends BusinessActionBase {

	private static final String m_whatVersion = "@(#) $RCSfile: BKKRIPCoreProcessor.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n" ; 
	    

	    public BKKRIPCoreProcessor() throws Exception {
		traceLog("VerifyScanBase","In Constructor");
	    }

	    public BKKRIPCoreProcessor(String groupName) throws Exception
	    {
		super(groupName);

		traceLog("VerifyScanBase","In Constructor");
	    }

	    protected void readSiteConfigVariables() throws Exception
	    {
		super.readSiteConfigVariables();
		//no local variables to read in
	    }

	    // reads and returns the string value of ARRIVAL_SCAN_NAME from the config file 
	    protected abstract String getScanName() throws Exception;
	    
	    protected abstract int getCodeForScanMissing(CCIIState state);
	    protected abstract int getCodeForScanThere(CCIIState state);

	    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
			Scan scan = null;
			traceLog("RIPCoreProcessor","Begining doIt()");
		    if(state.getOverageFlag().equals("M")) 
		    	state.setOverageFlag("");
			return state;
	    }
	}