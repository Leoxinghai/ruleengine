package cciij.businessActions;

/**
 * Title:        Verify Staging Area
 * Description:  Business action that verifys a staging area. If the staging
 *               area code is "null" after the fetch from the database, an
 *               error message number is set in the state object. The state
 *               object is returned to the caller.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author       Robert Fisher
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Failure during fetch of Staging Area
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *               stagingArea - staging area code string set to either a staging
 *                             area code or an empty string.
 *
 * Modification History:
 * 10/24/2001    Ed McAleer   Add tags and complete description.
 * 12/26/2001    Ed McAleer   Change exception to CCIILogException.
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.TreeSet;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class VerifyStagingArea extends BusinessActionBase
{
    private Map m_allowedStageUsers = null;

    public VerifyStagingArea() throws Exception
    {
	traceLog("VerifyStagingArea","In Constructor");
	m_allowedStageUsers = new TreeMap();
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
        //no local variables to read in
    }


    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
	StagingArea stagingArea = null;

	traceLog("VerifyStagingArea","Begining doIt()");
	traceLog("VerifyStagingArea",state);

	try {
	    stagingArea = dbConnection.fetchStagingArea(state.getScan().getStagingAreaCode());
	}
	catch (Exception ex) {
	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
							   "Failure during fetch of Staging Area");
	    throw cciiEx;
	}

	traceLog("VerifyStagingArea","Fetch returned");

	if ( stagingArea == null ) {
	    state.getScan().setErrorNumber(Messages.EM_INV_STAGE_AREA);
            state.addExceptionActivity("INVSTG");
            return state;
	}

	// Begining of kwick fix for CU 2/5/2003 mwr
	String allowedStageUsers = null;
	String allowedUserKey = state.getScan().getStagingAreaCode() + "_"
	    + state.getScan().getInViewName().toUpperCase() + "_ALLOWED_STAGE_USERS";
	if((allowedStageUsers = m_config.getValue(allowedUserKey)) != null)
	{
	    Set allowedStageUserSet = null;
	    if(m_allowedStageUsers.containsKey(allowedUserKey))
	    {
		allowedStageUserSet = (Set)m_allowedStageUsers.get(allowedUserKey);
	    }
	    else
	    {
		allowedStageUserSet = buildStageUserSet(allowedStageUsers);
		m_allowedStageUsers.put(allowedUserKey,allowedStageUserSet);
	    }

	    if(allowedStageUserSet.contains(state.getScan().getUserLogon()))
	    {
		traceLog("VerifyStagingArea","Allowing Access to stage area "
			 + state.getScan().getStagingAreaCode() + " to user:  "
			 + state.getScan().getUserLogon());
	    }
	    else
	    {
		String msg = "Denying Access to stage area "
		    + state.getScan().getStagingAreaCode() + " to user:  "
		    + state.getScan().getUserLogon() + " @ "
		    + new java.util.Date();

		System.out.println(msg);

                state.addExceptionActivity("ILLSTG");

		state.getScan().setErrorNumber(Messages.EM_INV_STAGE_AREA);
	    }
	}
	else
	{
	    traceLog("VerifyStagingArea","Allowing Unrestricted Access to stage area "
                     + state.getScan().getStagingAreaCode() + " to user:  "
                     + state.getScan().getUserLogon());
	}


	traceLog("VerifyStagingArea",state);
	traceLog("VerifyStagingArea","returning....");

	return state;
    }

    private Set buildStageUserSet(String userString)
    {
	Set s = new TreeSet();
	StringTokenizer t = new StringTokenizer(userString,",");

	while(t.hasMoreTokens())
	{
	    s.add(t.nextToken());
	}

	return s;
    }

}
