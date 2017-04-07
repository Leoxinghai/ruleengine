package cciij.businessActions;

/**
 * Title:       Verify Scan Base
 *
 * Description: Base class for all scan checks.  This business action checks the database
 *              for a scan record that matches the shipmentOid number, the handlingUnit
 *              Oid number, and has an arrival scan type. If no record is found an error
 *              message (IM_NO_ARRIVAL_SCAN) is set in the scan object error message attribute.
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Lorraine Dominguez
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Scan fetch failed
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:  VerifyArrivalScan.java
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 03/06/2003   Lorraine Dominguez   Initial Creation.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public abstract class VerifyScanBase extends BusinessActionBase {

private static final String m_whatVersion = "@(#) $RCSfile: VerifyScanBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n" ;


    public VerifyScanBase() throws Exception {
	traceLog("VerifyScanBase","In Constructor");
    }

    public VerifyScanBase(String groupName) throws Exception
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

	traceLog("VerifyScanBase","Begining doIt()");
	traceLog("VerifyScanBase",state);

	try {
		if (state.getScan().getHandlingUnitOid() == 0)
			scan = dbConnection.fetchScan(getScanName(),
						      state.getScan().getShipmentOid());
                else
	    		scan = dbConnection.fetchScan(getScanName(),
					              state.getScan().getHandlingUnitOid(),
					              state.getScan().getShipmentOid());
	}
	catch (Exception ex) {
	    System.out.println("caught exception calling fetch scan" + ex);
	    ex.printStackTrace(System.out);
	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Scan fetch failed");
	    throw cciiEx;
	}

	traceLog("VerifyScanBase","Fetch returned");
	if ( scan == null ) {
	    state.getScan().setErrorNumber(getCodeForScanMissing(state));
	    traceLog("VerifyScanBase","scan is null");
	}
	else {
	    state.getScan().setErrorNumber(getCodeForScanThere(state));
	}

	traceLog("VerifyScanBase",state);
	traceLog("VerifyScanBase","returning....");

	return state;
    }
}
