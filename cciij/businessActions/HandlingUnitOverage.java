package cciij.businessActions;

import cciij.cciidata.*;

/**
 * Title:       Handling Unit Overage
 *
 * Description: Inherits from HandlingUnitOverageBase.   Sets the Travel Status to "I"
 *
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Gary Rockwood
 * @version 1.0
 *
 * Modification History:
 * 03/10/2004    Gary Rockwood Initial creation.   Sets Travel Status to "I"
 *
 */

public class HandlingUnitOverage extends HandlingUnitOverageBase {

  private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnitOverage.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public HandlingUnitOverage () throws Exception
  {
    traceLog("HandlingUnitOverage","In constructor");
  }

  protected void setTravelStatusValue(HandlingUnit hu, CCIIState state) throws Exception
  {
    traceLog("HandlingUnitOverage","In setTravelStatusValue");

    // The default value is "I" for International
    hu.setTravelStatus("I");
  }

}
