/*
 * Created on Mar 11, 2006
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

import cciij.cciidata.CCIIState;
import cciij.cciidata.Scan;
import cciij.cciidatabase.DatabaseBean;

	/**
	 * @author Administrator
	 *
	 * TODO To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */

	public abstract class BKKCONSDCoreProcessor extends BusinessActionBase {

			private static final String m_whatVersion = "@(#) $RCSfile: BKKCONSDCoreProcessor.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n" ; 

		    public BKKCONSDCoreProcessor() throws Exception {
			traceLog("VerifyScanBase","In Constructor");
		    }

		    public BKKCONSDCoreProcessor(String groupName) throws Exception
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
				traceLog("CONSDCore","Begining doIt()");
				return state;
		    }
		}