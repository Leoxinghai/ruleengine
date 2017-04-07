package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostCustomsRelease extends PostShipmentBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: PostCustomsRelease.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    String ms_releaseActivityCode;
    String ms_errorActivityCode;

    public PostCustomsRelease() throws Exception
    {
        super("PostCustomsRelease");
        traceLog("PostCustomsRelease","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      ms_releaseActivityCode = readConfigVariableString("INTERCEPT_SHIPMENT_RELEASE_ACTIVITY_CODE","INT_RS");
      ms_errorActivityCode = readConfigVariableString("INTERCEPT_SHIPMENT_RELEASE_ERROR_ACTIVITY_CODE","INT_RE");
    }

    public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception
    {
        traceLog("PostCustomsRelease","Begining modifyShipmentData()");

// 	System.out.println("PostCustomsrelease::modifyShipmentData:  actionCode:  |"
// 			   + state.getScan().getActionCode() + "|");

        if(!(state.getScan().getActionCode().equals("S")))
        {
            if(ship.getBrokerEntryNumber().equals(""))
            {
                state.addActivity(ms_errorActivityCode);
                return state;
            }
        }

        if(!(ship.getCustomsReleaseFlag().equals("Y")))
        {
            ship.setCustomsReleaseFlag("Y");
            m_updateShipmentCoreClearance = true;
            state.addActivity(ms_releaseActivityCode);
        }

        // Notify Scanner that the package is RELEASED
        state.getScan().setErrorNumber(Messages.IM_RELEASED);

        traceLog("PostCustomsRelease","returning from modifyShipmentData() ...");
        return state;
    }
}
