package cciij.businessActions;

/**
 * Title:         Post Activity
 * Description:   Post entries to the Clearance Activity Table
 * Copyright:     Copyright (c) 2002
 * Company:       FedEx Services
 * @author        Mike Roderick
 * @version 3.2
 *
 * @throws        cciij.util.CCIILogException Failed to find the activityDef in the DB
 * @throws        cciij.util.CCIILogException Failed to parse the template
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *  FindHandlingUnit
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer   Add tags and complete description. Also changed the
 *                            exceptions to CCIILogException.
 *
 * 05/06/2002    Robert Fisher Calls done() on JoltRemoteService
 *                             Establishes Jolt session if m_session == null
 *
 * 05/09/2002    Mike Roderick Complete re-write to do the work instead of calling WLActivity
 * 03/18/2003    Mike Roderick Changed to use the time/date from the scan object
 * 01/28/2004    Mike Roderick Changed to use the rmtc.util.TemplateParser.  This allows more dynamic templates.
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class PostActivity extends BusinessActionBaseWithOidGeneration {
    private static final String m_whatVersion = "@(#) $RCSfile: PostActivity.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    TreeMap m_parsers;
    private TreeMap m_oidTypes;
    private rmtc.util.TemplateParser m_parser = new rmtc.util.TemplateParser("PostActivity");

    public PostActivity() throws Exception
    {
        traceLog("PostActivity","In Constructor");
	//        m_parsers = new TreeMap();
	m_oidTypes = new TreeMap();
    }

    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
	//no local variables to read in
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception 
    {
        // need to call the PostActivity on the Inventory side

        traceLog("PostActivity","Begining doIt()");
        traceLog("PostActivity",state);

        traceLog("PostActivity.",state.getActivityCodes().toString());

        String ls_oldInterceptCode = state.getScan().getInterceptCode();
        String ls_oldAgencyCode = state.getScan().getAgencyCode();

        ClearanceActivity l_activity;
        int li_oidNbr;

        try
        {
            // loop thru the vector and make a call for each activity code
            String activityCode = null;
            Intercept intercept = null;
            traceLog("PostActivity","vector contains : " + state.getActivityCodes().size());
            for (  Iterator i = state.getActivityCodes().iterator() ; i.hasNext(); ) {
                activityCode = (String) i.next();
                intercept = (Intercept) i.next();
                traceLog("PostActivity","retrieved : " + activityCode + " and " + intercept + " from vector");
                // need to get the agency and intercept from the intercept object
                if ( intercept != null ) {
                    state.getScan().setInterceptCode(intercept.getInterceptCode());
                    state.getScan().setAgencyCode(intercept.getAgencyCode());
                }
                else {
                    state.getScan().setInterceptCode("");
                    state.getScan().setAgencyCode("");
                }

                // Done setting things up lets just do the work!!
		//                TemplateParser l_parser;
		String oidType="";

                String key = state.getScan().getLocationCode() + ":" + activityCode;

		if(m_oidTypes.containsKey(key) == false)
		{
		    try
		    {
			m_oidTypes.put(key,getDBOidType(activityCode,dbConnection));
		    }
		    catch(CCIILogException e)
		    {
			state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
			throw e;
		    }
                    catch(Exception e)
                    {
                        state.getScan().setErrorNumber(Messages.EM_CHECK_LOG);
                        throw new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Failed to get a TemplateParser for actCode:  "
                                                   + activityCode
                                                   + ":  Reason:  "
                                                   + e);
                    }
		}

		oidType = (String)m_oidTypes.get(key);

		Date l_now = null;

		//                Date l_now = new Date();
		if(state.getScan().getSysDateTime() > 0)
		{
		    l_now = new Date(state.getScan().getSysDateTime());
		}
		else
		{
		    l_now = new Date();
		}

		l_activity = new ClearanceActivity(getOid(OidFactoryTypes.ACTIVITYLOG),
						   activityCode,
						   m_parser.buildString(activityCode,state.getScan().getLocationCode(),state),
						   l_now,
						   (int)(l_now.getTime() % 1000),
						   getOid(oidType,state),
						   oidType,
						   state.getScanTypeCode(),
						   l_now,
						   state.getRuleSetName(),
						   state.getScan().getUserLogon(),
						   state.getScan().getAgencyCode());

		//		System.out.println("Saving Clearance Activity:  " + l_activity);

		try
		{
		    dbConnection.saveClearanceActivity(l_activity);
		}
		catch(Exception ex)
		{
		    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
		    throw new CCIILogException("BA_DB_ERROR_NUMB",
					       "Failed to Save the ClearanceActivity:  "
					       + ex);
		}


	    }  // end for ( Iterator

	}
	catch(CCIILogException e)
	{
	    if(state.getScan().getErrorNumber() == 0)
	    {
		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    }
	    throw e;
	}
	catch(Exception e)
	{
	    // We have a failure in PostActivity, dump the relevent information
	    System.out.println("PostActivity.doit() caught:  " + e);
	    e.printStackTrace();

	    if(state.getScan().getErrorNumber() == 0)
	    {
		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    }

	    throw new CCIILogException("BA_DB_ERROR_NUMB",e.toString());
	}
	finally
	{
	    state.getScan().setInterceptCode(ls_oldInterceptCode);
	    state.getScan().setAgencyCode(ls_oldAgencyCode);
	}

	traceLog("PostActivity","returning ...");
	return state;
    }

    private String getDBOidType(String as_activityCode,DatabaseBean dbConnection) throws Exception
    {
	ActivityDef l_def;
	//	System.out.println("PostAcitivty.getDBTemplateParser( " + as_activityCode + " , db)");

	if((l_def = dbConnection.fetchActivityDef(as_activityCode)) == null)
	{
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
							   "Failed to find the ActivityCode in the Database:  "
							   + as_activityCode);
	    throw cciiEx;
	}

	//	System.out.println("Just Retrieved from the db:  " + as_activityCode + " = " + l_def.getActivityTextTemplateDescription());

	return l_def.getOidTypeCode();
    }

    public int getOid(String oidType,CCIIState state)
    {
	switch(oidType.charAt(0))
	{
	case 'S':
	    return state.getScan().getShipmentOid();
	case 'P':
	    return state.getScan().getHandlingUnitOid();
	case 'R':
	    return state.getScan().getRouteLegOid();
	default:
	    return 0;
	}
    }


    public static void main(String args[]) throws Exception
    {
	PostActivity l_activityLog = new PostActivity();

	CCIIState state = new CCIIState();
	RPBScan scan = new RPBScan();

	scan.setHAWB("40033333333");
	scan.setAirbillNumber("40033333333");
	scan.setInterceptCode("OVG");
	state.setInterceptedFlag("OVERAGE");
	state.setScanTypeCode("IPA");
	state.setRuleSetName("IPATEST5");
	scan.setAgencyCode("OV");
	scan.setRouteLegDate(new Date());
	scan.setRouteNumber("MR0000");
	scan.setUserLogon("364942");
	scan.setSysDateTime(new Date());
	scan.setStagingAreaCode("OVRG");
	scan.setDetainLoc("BUNK 1");

	scan.setHandlingUnitOid(2222);
	scan.setShipmentOid(2222);
	scan.setRouteLegOid(2222);

	state.setScan(scan);

	DatabaseBean db = new DatabaseBean();

	db.connect();

	// 	Intercept l_int = new Intercept(int interceptOidNumber,

	// 					int shipmentOidNumber,

	// 					int pieceOidNumber,

	// 					String interceptCode,

	// 					String activeFlag,

	// 					Date createDate,

	//                      String employeeNumberForCreation,

	//                      String processNameCreated,

	//                      Date dateUpdated,

	//                      String employeeNumberForUpdate,

	//                      String processNameUpdated,

	//                      int stagingAreaPriorityNumber,

	//                      Date transactionDate,

	//                      String agencyCode,

	//                      String fromRecurringCriteriaFlag)



	Intercept l_int = new Intercept(0,0,0,"MPS","Y",new Date(),"364942",null,new Date(),"364942",null,0,new Date(),"MP",null);

	state.m_activityCodes.add("MA");
	state.m_activityCodes.add(l_int);

	java.util.Date firstStartDt = new java.util.Date();

	l_activityLog.actionEntry(state);

	state.m_activityCodes.clear();

	for(int i=0;i<args.length;i++)
	{
	    state.m_activityCodes.add(args[i]);
	    state.m_activityCodes.add(l_int);
	}

	java.util.Date startDt = new java.util.Date();
	java.util.Date endDt = null;
	long elapsedMS = 0;

	l_activityLog.actionEntry(state);

	endDt = new java.util.Date();
	elapsedMS = endDt.getTime() - firstStartDt.getTime();
	System.out.println("Including the first time through Posting of " + (args.length + 1) + " Activities took " + elapsedMS + " ms");
	elapsedMS = endDt.getTime() - startDt.getTime();
	System.out.println("Posting of " + args.length + " Activities took " + elapsedMS + " ms");
	System.out.println("Which averages to " + (elapsedMS / args.length) + " ms per activityCode to Post");


	db.commitTransaction();
    }
}
