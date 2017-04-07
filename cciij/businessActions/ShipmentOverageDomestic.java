package cciij.businessActions;

import cciij.cciidata.*;

/**
 * Title:       Shipment Overage Domestic
 *
 * Description: Inherits from ShipmentOverageBase.   Sets Travel Status to "D".
 *
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Gary Rockwood
 * @version 1.0
 *
 * Modification History:
 * 03/10/2004   Gary Rockwood  Initial creation.   Sets Travel Status to "D"
 *
 */

public class ShipmentOverageDomestic extends ShipmentOverageBase {

  private static final String m_whatVersion = "@(#) $RCSfile: ShipmentOverageDomestic.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public ShipmentOverageDomestic() throws Exception
  {
    traceLog("ShipmentOverageDomestic","In constructor");
  }

  protected void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception
  {
    traceLog("ShipmentOverageDomestic","In setTravelStatusValue");

    hu.setTravelStatus("D");

    state.getScan().setErrorNumber(Messages.IM_DOMESTIC_PKG);
  }

}
