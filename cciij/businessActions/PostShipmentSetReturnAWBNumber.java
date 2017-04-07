package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:        PostShipmentSetReturnAWBNumber
 * Description:  Business Action to update the ReturnAWBNumber in Shipment Core Clearance
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Tom Knobeloch
 * @version 1.0
 */

public class PostShipmentSetReturnAWBNumber extends PostShipmentBase {
  private static final String m_whatVersion = "@(#) $RCSfile: PostShipmentSetReturnAWBNumber.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public PostShipmentSetReturnAWBNumber() throws Exception {
    super("PostShipment");
    traceLog("PostShipmentSetReturnAWBNumber","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception {
    traceLog("PostShipmentSetReturnAWBNumber","Begining modifyShipmentData()");

    ship.setReturnAWBNumber(state.getScan().getReturnAWBNumber());
    m_updateShipmentCoreClearance = true;

    traceLog("PostShipmentSetReturnAWBNumber","returning from modifyShipmentData() ...");
    return state;
  }
}
