package cciij.businessActions;

/**
 * Title:        Test For Missort
 * Description:  This business action will determine if a package which has been
 *               identified as an overage is an actual Missort to this country.
 *
 * Copyright:    Copyright (c) 2005
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Modification History:
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class TestForMissort extends BusinessActionBase {

    private static final String m_whatVersion = "@(#) $RCSfile: TestForMissort.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public TestForMissort() throws Exception 
    {
        traceLog("TestForMissort","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception 
    {
        return state;
    }
}
