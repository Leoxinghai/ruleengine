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

public class PostCustomsUnRelease extends PostShipmentBase
{
    String ms_unreleaseActivityCode;
    private static final String m_whatVersion = "@(#) $RCSfile: PostCustomsUnRelease.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public PostCustomsUnRelease() throws Exception
    {
        super("PostCustomsUnRelease");
        traceLog("PostCustomsUnRelease","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      ms_unreleaseActivityCode = readConfigVariableString("INTERCEPT_SHIPMENT_UNRELEASE_ACTIVITY_CODE","INT_US");
    }

    public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception
    {
        traceLog("PostCustomsUnRelease","Begining modifyShipmentData()");


        if(ship.getCustomsReleaseFlag().equals("Y"))
        {
            ship.setCustomsReleaseFlag("N");
            ship.setBrokerEntryNumber("");
            m_updateShipmentCoreClearance = true;
            state.addActivity(ms_unreleaseActivityCode);
        }

        // Notify Scanner that the package is NOT RELEASED
        state.getScan().setErrorNumber(Messages.IM_NOT_RELEASED);

        traceLog("PostCustomsUnRelease","returning from modifyShipmentData() ...");
        return state;
    }
}
