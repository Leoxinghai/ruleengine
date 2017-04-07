package cciij.businessActions;

import cciij.cciidata.*;

/**
 * Title:       Shipment Overage
 *
 * Description: Inherits from ShipmentOverageBase.  Sets Travel Status to "I"
 *
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Gary Rockwood
 * @version 1.0
 *
 * Modification History:
 * 03/10/2004   Gary Rockwood  Initial Creation.  Sets Travel Status to "I"
 *
 */

public class ShipmentOverage extends ShipmentOverageBase {

  private static final String m_whatVersion = "@(#) $RCSfile: ShipmentOverage.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public ShipmentOverage() throws Exception 
  {
    traceLog("ShipmentOverage","In constructor");
  }

  protected void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception
  {
    traceLog("ShipmentOverage","In setTravelStatusValue");

    // the default value for Travel Status is "I" - International
    hu.setTravelStatus("I");
  }

}
