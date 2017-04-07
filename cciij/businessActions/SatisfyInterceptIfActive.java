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

public class SatisfyInterceptIfActive extends SatisfyIntercept
{
    private String m_int = null;
    private String m_agency = null;
    private static final String m_whatVersion = "@(#) $RCSfile: SatisfyInterceptIfActive.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public SatisfyInterceptIfActive() throws Exception
    {
    }

    public SatisfyInterceptIfActive(String group) throws Exception
    {
        super(group);
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      m_int =  readConfigVariableString("INTERCEPT_CODE","");
      m_agency = readConfigVariableString("AGENCY_CODE","");
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        Intercept intercept = null;
        InterceptCodeDefinition interceptDef = null;
        boolean activeInterceptDef = false;
        CCIIState localState = (CCIIState)state.clone();
        localState.getScan().setAgencyCode(m_agency);
        localState.getScan().setInterceptCode(m_int);
        try
        {
            interceptDef = verifyInterceptDef(localState,dbConnection);
            if (interceptDef != null && interceptDef.getRecordActiveFlag().equalsIgnoreCase(INTERCEPT_DEF_ACTIVE))
            {
              activeInterceptDef = true;
            }
            if((intercept = getActiveIntercept(localState,dbConnection)) != null)
            {
              satisfyIndividualIntercpet(state,dbConnection,intercept);
            }
        }
        catch(Exception e)
        {
            if(localState.getScan().getErrorNumber() != 0)
            {
                state.getScan().setErrorNumber(localState.getScan().getErrorNumber());
            }
        }

        return state;
    }

}
