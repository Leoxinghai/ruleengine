package cciij.businessActions;

/**
 * Title:        Find HAWB With Dup Resolution
 * Description:  Find a  Shipment by HAWB number. If the Shipment is not found throw
 *               exception "Fetch by HAWB returned NULL". After
 *               locating the Shipment, set the state object shipmentOid
 *               attribute to the shipmentOid contained in the Shipment.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Tom Knobeloch
 * @version 1.0
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class FindHAWBWithDupResolution extends FindHAWB {
private static final String m_whatVersion = "@(#) $RCSfile: FindHAWBWithDupResolution.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public FindHAWBWithDupResolution() throws Exception {
    traceLog("FindHAWBWithDupResolution","In Constructor");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    CCIIState retState = super.doIt(state, dbConnection);
    if(retState.getOverageFlag().equals("H"))
    {
        retState.getScan().setErrorNumber(Messages.IM_NOT_FOUND);
    }
    return retState;
  }

  protected void processDup(CCIIState state, DatabaseBean dbConnection, Shipment shipment) throws Exception
  {
    if (   (state.getScan().getHAWBSerialNumber() != 0)
        || (   (! (state.getScan().getOriginLocationCode().equals("")))
            && (! (state.getScan().getDestLocationCode().equals(""))) ))
    {
      while (shipment != null)
      {
        if (state.getScan().getHAWBSerialNumber() != 0)
        {
          if (state.getScan().getHAWBSerialNumber() == shipment.getHAWBSerialNumber())
          {
            return;
          }
        }
        else
        {
          if (   (! (state.getScan().getOriginLocationCode().equals("")))
              && (! (state.getScan().getDestLocationCode().equals(""))) )
          {
            if (   (state.getScan().getOriginLocationCode().equals(shipment.getOriginLocCode()) )
                && (state.getScan().getDestLocationCode().equals(shipment.getDestinationLocCode()) ) )
            {
              return;
            }
          }
        }

        try
        {
          shipment = dbConnection.fetchNextShipment();
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                         "Shipment fetchNext failed");
          throw cciiEx;
        }
      }
    }

    state.getScan().setReturnMessage("Duplicate HAWB");
    state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
    throw new Exception("Duplicate HAWB from fetch");
  }
}
