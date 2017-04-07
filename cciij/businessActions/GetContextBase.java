package cciij.businessActions;
/**
 * Title:       Get Context Base
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001   Ed McAleer   Changes exceptions to CCIILogException.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public abstract class GetContextBase extends BusinessActionBase {
    private static final String m_whatVersion = "@(#) $RCSfile: GetContextBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public GetContextBase() throws Exception {
        traceLog("GetContext","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read in
    }

    protected void changeRuleSets(CCIIState state, String contextDescriptor) throws Exception
    {
        String s = m_config.getValue(state.getScan().getInViewName().toUpperCase() + "_" + contextDescriptor + "_RULESET");
        if(s == null)
        {
            state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                                           contextDescriptor + "_RULESET not found for view == " + state.getScan().getInViewName());
            throw cciiEx;
        }

        state.setRuleSetName(s);
    }

    public abstract CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception;
}
