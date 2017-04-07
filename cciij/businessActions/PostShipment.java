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

public class PostShipment extends PostShipmentBase {
private static final String m_whatVersion = "@(#) $RCSfile: PostShipment.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public PostShipment() throws Exception {
      super("PostShipment");
    traceLog("PostShipment","In Constructor");
  }
protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  //no local variables to read
}

public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception
{
    traceLog("PostShipment","Begining modifyShipmentData()");

    if(ship.getOverageReasonCode().equals(""))
    {
        if(state.getOverageFlag().equals("SORTDATE"))
        {
            ship.setOverageReasonCode("D");
            m_updateShipmentCoreClearance = true;
        }
        else if(state.getOverageFlag().equals("") == false)
        {  // This is the default Case to catch any overages that have not yet been marked.
            ship.setOverageReasonCode("M");
            m_updateShipmentCoreClearance = true;
        }
    }

    traceLog("PostShipment","returning from modifyShipmentData() ...");
    return state;
  }
}
