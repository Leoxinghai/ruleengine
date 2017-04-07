package cciij.businessActions;

import cciij.cciidata.*;

/**
 * Title:       Handling Unit Overage Domestic
 *
 * Description: Inherits from HandlingUnitOverageBase.   Sets the Travel Status to "D"
 *
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Gary Rockwood
 * @version 1.0
 *
 * Modification History:
 * 03/10/2004    Gary Rockwood Initial creation, sets travelStatus to "D"
 *
 */

public class HandlingUnitOverageDomestic extends HandlingUnitOverageBase {

  private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnitOverageDomestic.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public HandlingUnitOverageDomestic () throws Exception
  {
    traceLog("HandlingUnitOverageDomestic","In constructor");
  }

  protected void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception
  {
    traceLog("HandlingUnitOverageDomestic","In setTravelStatusValue");

    hu.setTravelStatus("D");

    state.getScan().setErrorNumber(Messages.IM_DOMESTIC_PKG);
  }

}
