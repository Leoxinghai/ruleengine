package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:        SetRODFlag
 * Description:  Business Action to set the RODFlag in Shipment 
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Lorraine Dominguez
 * @version 1.0
 */

public class SetRODFlag extends PostShipmentBase 
{
  private static final String m_whatVersion = "@(#) $RCSfile: SetRODFlag.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public SetRODFlag() throws Exception 
  {
    super("PostShipment");
    traceLog("SetRODFlag","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception 
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception 
  {
    traceLog("SetRODFlag","Begining modifyShipmentData()");

    ship.setRODFlag("Y");
    m_updateShipment = true;

    traceLog("SetRODFlag","returning from modifyShipmentData() ...");
    return state;
  }
}
