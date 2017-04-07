package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Verify ShipmentRemark
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Shipment is invalid
 * @throws      cciij.util.CCIILogException HandlingUnit is invalid
 * @throws      cciij.util.CCIILogException ShipmentRemark Code and Description are invalid
 * @throws      cciij.util.CCIILogException Failure attempting to save ShipmentRemark
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ShipmentRemarkDef
 * @throws      cciij.util.CCIILogException ShipmentRemarkDef not found
 * @throws      cciij.util.CCIILogException ShipmentRemarkDef not active
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *  01/26/2004  Tom Knobeloch   Enhanced database exception logging.
 *  01/16/2004  Tom Knobeloch   Corrected error message numbers
 *  01/13/2004  Tom Knobeloch   Corrected edits and messages for ShipmentRemarkCode
 *  12/16/2003  Tom Knobeloch   Modified check for Activity code to differenciate
 *                              between Shipment and Piece level activity.
 */

public class VerifyShipmentRemark extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyShipmentRemark.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateShipmentRemark";
  private static final String UPDATE_PROCESS_NAME = "";

  public VerifyShipmentRemark() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    ShipmentRemarkDef srd = null;
    String activityCode = null;

    traceLog("VerifyShipmentRemark", "Beginning doIt()");
    traceLog("VerifyShipmentRemark", state);
    
    if (state.getPieceLevelInventory() == true)
    {
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_PIECE_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_PIECE_ACTIVITY_CODE");
        throw cciiEx;
      }
      
      if (state.getScan().getHandlingUnitOid() == 0)
      {
        state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "HandlingUnitOid is invalid: ");
        throw cciiEx;
      }
    }
    else
    {
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_SHIPMENT_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_SHIPMENT_ACTIVITY_CODE");
        throw cciiEx;
      }
      
      if (state.getScan().getShipmentOid() == 0)
      {
        state.getScan().setErrorNumber(Messages.EM_SCAN_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ShipmentOid is invalid: ");
        throw cciiEx;
      }
    }

    if (   (   (state.getScan().getShipmentRemarkCode() == null)
            || (state.getScan().getShipmentRemarkCode().equals("") == true))
        && (   (state.getScan().getShipmentRemarkDesc() == null)
            || (state.getScan().getShipmentRemarkDesc().equals("") == true)))
    {
      state.getScan().setErrorNumber(Messages.EM_REMARK_CODE_REQD);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "ShipmentRemark Code and Description are invalid. ");
      throw cciiEx;
    }
      
    if (   (state.getScan().getShipmentRemarkCode() != null)
        && (state.getScan().getShipmentRemarkCode().equals("") != true))
    {
      try
      {
        srd = dbConnection.fetchShipmentRemarkDef(state.getScan().getShipmentRemarkCode());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of ShipmentRemarkDef:  " + ex);
        throw cciiEx;
      }

      if (srd == null)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_REMARK_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ShipmentRemarkDef "
                                  + state.getScan().getShipmentRemarkCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not found in DB");
        throw cciiEx;
      }

      if (srd.getRecordActiveFlag().equals("Y") != true)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_REMARK_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ShipmentRemarkDef "
                                  + state.getScan().getShipmentRemarkCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not active");
        throw cciiEx;
      }
    }  

    traceLog("VerifyShipmentRemark", state);
    traceLog("VerifyShipmentRemark", "returning...");

    return state;
  }
}
