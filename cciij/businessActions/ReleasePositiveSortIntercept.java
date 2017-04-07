package cciij.businessActions;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */
 import cciij.cciidata.*;
 import cciij.cciidatabase.*;
 import cciij.util.CCIILogException;

public class ReleasePositiveSortIntercept extends SatisfyIntercept
{
    private String m_positiveSortInt = null;
    private String m_positiveSortAgency = null;
    private static final String m_whatVersion = "@(#) $RCSfile: ReleasePositiveSortIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public ReleasePositiveSortIntercept() throws Exception
    {
    }

    public ReleasePositiveSortIntercept(String group) throws Exception
    {
      super(group);
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      m_positiveSortInt =  readConfigVariableString("DEFAULT_INTERCEPT_CODE","PS");
      m_positiveSortAgency = readConfigVariableString("DEFAULT_AGENCY_CODE","PS");
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        Intercept intercept = null;
        InterceptCodeDefinition interceptDef = null;
        boolean activeInterceptDef = false;
        CCIIState localState = (CCIIState)state.clone();
        localState.getScan().setAgencyCode(m_positiveSortAgency);
        localState.getScan().setInterceptCode(m_positiveSortInt);
        try
        {
            interceptDef = verifyInterceptDef(localState,dbConnection);
            if (interceptDef != null && interceptDef.getRecordActiveFlag().equalsIgnoreCase(INTERCEPT_DEF_ACTIVE))
            {
              activeInterceptDef = true;
            }
            if((intercept = getActiveIntercept(localState,dbConnection)) != null)
            {
                satisfyIndividualIntercpet(localState,dbConnection,intercept);
            }
        }
        catch(Exception ex)
        {
            if(localState.getScan().getErrorNumber() != 0)
            {
                state.getScan().setErrorNumber(localState.getScan().getErrorNumber());
            }

            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failed to satisfy the Positive Sort Intercept:  " + ex,
                                                           ex); 
            throw cciiEx;

        }

        return state;
    }

}
