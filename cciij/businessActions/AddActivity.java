package cciij.businessActions;

/**
 * Title:        AddActivity
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
 * @author       Mike Roderick
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

public class AddActivity extends BusinessActionBase {

    private static final String m_whatVersion = "@(#) $RCSfile: AddActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    protected String m_groupName;

    public AddActivity(String groupName) throws Exception 
    {
	super(groupName);

	m_groupName = groupName;
	
	traceLog("AddActivity","In Constructor(" + groupName + ")");
    }

    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception 
    {
	String actCode;

	if((actCode = m_config.getValue("ACTIVITY_CODE")) == null)
	{
	    state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
	    CCIILogException cciiEx =
		new CCIILogException("BA_CONFIG_ERROR_NUMB",
				     "Activity code not found for AddActivity(" + m_groupName + "): ACTIVITY_CODE)");
	    throw cciiEx;
	}
	else
	{
	    state.addActivity(actCode);
	}

	return state;
    }



    public static void main(String[] args){
	System.out.println("AddActivity in main");

	rmtc.util.Config cfg = new rmtc.util.Config();

	cfg.setLocationCode("NRT");

	try
	{
	    CCIIState state = new CCIIState();
	    
	    AddActivity assMst = new AddActivity("ASSOCIATE_MASTER");
	    
	    assMst.doIt(state,null);
	    
	    System.out.println("Activity Vector after AddActivity:  " + state.getActivityCodes());
	}
	catch(Exception e)
	{
	    System.out.println("AddActivity.main caught exception:  " + e);
	    e.printStackTrace(System.out);
	}

	System.out.println("Leaving main");
    }


}
