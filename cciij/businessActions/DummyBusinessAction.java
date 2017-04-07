package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class DummyBusinessAction extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: DummyBusinessAction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public DummyBusinessAction() throws Exception
    {
        traceLog("DummyBusinessAction","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        throw new Exception("Called DummyBusinessAction   RuleSet Problem suspected");
        //	return state;
    }
}
