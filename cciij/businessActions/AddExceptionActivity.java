package cciij.businessActions;

/**
 * Title:        AddExceptionActivity
 * Description:  BA to allow the rule to add configurable activities when appropriate
 *                  ie:  Scan failure, but we want a record of attempt
 *
 *
 *
 *
 *
 *
 *
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Mike Roderick
 *               This code was initially copied from AddActivity
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
 *   3/11/2003  MWR  Created original AddActivity
 *   3/17/2004  Gary Rockwood  Created AddExceptionActivity
 *
 */

import cciij.cciidatabase.DatabaseBean;
import cciij.cciidata.CCIIState;
import cciij.util.CCIILogException;

public class AddExceptionActivity extends BusinessActionBase {

    private static final String m_whatVersion = "@(#) $RCSfile: AddExceptionActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    protected String m_groupName;

    public AddExceptionActivity(String groupName) throws Exception 
    {
	super(groupName);

	m_groupName = groupName;
	
	traceLog("AddExceptionActivity","In Constructor(" + groupName + ")");
    }

    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception 
    {
	String actCode;

	if((actCode = m_config.getValue("EXCEPTION_ACTIVITY_CODE")) == null)
	{
	    state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
	    CCIILogException cciiEx =
		new CCIILogException("BA_CONFIG_ERROR_NUMB",
				     "Exception Activity code not found for AddExceptionActivity(" + m_groupName + "): EXCEPTION_ACTIVITY_CODE)");
	    throw cciiEx;
	}
	else
	{   
	    state.addExceptionActivity(actCode);
	}

	return state;
    }



    public static void main(String[] args){
	System.out.println("AddExceptionActivity in main");

	rmtc.util.Config cfg = new rmtc.util.Config();

	cfg.setLocationCode("NRT");

	try
	{
	    CCIIState state = new CCIIState();
	    
	    AddExceptionActivity assMst = new AddExceptionActivity("DEPnotCleared");
	    
	    assMst.doIt(state,null);
	    
	    System.out.println("Activity Vector after AddExceptionActivity:  " + state.getActivityCodes());
	}
	catch(Exception e)
	{
	    System.out.println("AddExceptionActivity.main caught exception:  " + e);
	    e.printStackTrace(System.out);
	}

	System.out.println("Leaving main");
    }


}
