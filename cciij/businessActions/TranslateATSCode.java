package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Translate ATS Code
 * Description: Translate ATS code (eg. 1H, 2H... 1I, 2I) to an agency, intercept and
 *              action code (eg. A for add, D for delete, S for satisfy).
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Config Error on ATS Agency
 * @throws      cciij.util.CCIILogException Config Error on ATS Intercept
 * @throws      cciij.util.CCIILogException Config Error on ATS Action
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */

public class TranslateATSCode extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: TranslateATSCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  
  public TranslateATSCode() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    traceLog("TranslateATSCode", "Beginning doIt()");
    traceLog("TranslateATSCode", state);
    
    state.getScan().setAgencyCode(m_config.getValue(state.getScan().getTransCode().toUpperCase()
                                                    + "_AGENCY_CODE"));
    if (state.getScan().getAgencyCode() == null)
    {
      state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
      CCIILogException cciiEx =
          new CCIILogException("BA_CONFIG_ERROR_NUMB",
                               "ATS Agency code not found: "
                                + state.getScan().getTransCode().toUpperCase()
                                + "_AGENCY_CODE");
      throw cciiEx;
    }

    state.getScan().setInterceptCode(m_config.getValue(state.getScan().getTransCode().toUpperCase()
                                                     + "_INTERCEPT_CODE"));
    if (state.getScan().getInterceptCode() == null)
    {
      state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
      CCIILogException cciiEx =
          new CCIILogException("BA_CONFIG_ERROR_NUMB",
                               "ATS Intercept code not found: "
                                + state.getScan().getTransCode().toUpperCase()
                                + "_INTERCEPT_CODE");
      throw cciiEx;
    }

    state.getScan().setActionCode(m_config.getValue(state.getScan().getTransCode().toUpperCase()
                                                  + "_ACTION_CODE"));
    if (state.getScan().getActionCode() == null)
    {
      state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
      CCIILogException cciiEx =
          new CCIILogException("BA_CONFIG_ERROR_NUMB",
                               "ATS Action code not found: "
                                + state.getScan().getTransCode().toUpperCase()
                                + "_ACTION_CODE");
      throw cciiEx;
    }

    traceLog("TranslateATSCode", state);
    traceLog("TranslateATSCode", "returning...");

    return state;
  }
}
