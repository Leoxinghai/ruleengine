package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Verify HandlingInstruction
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Shipment is invalid
 * @throws      cciij.util.CCIILogException HandlingUnit is invalid
 * @throws      cciij.util.CCIILogException HandlingInstruction Code and Description are invalid
 * @throws      cciij.util.CCIILogException Failure attempting to save HandlingInstruction
 * @throws      cciij.util.CCIILogException Failure attempting to fetch HandlingInstructionDef
 * @throws      cciij.util.CCIILogException HandlingInstructionDef not found
 * @throws      cciij.util.CCIILogException HandlingInstructionDef not active
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
 *  01/13/2004  Tom Knobeloch   Corrected edit and messages for HandlingInstructionCode
 *  12/16/2003  Tom Knobeloch   Modified check for Activity code to differenciate
 *                              between Shipment and Piece level activity.
 *                              Added additional Activity Code verifications.
 */

public class VerifyHandlingInstruction extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyHandlingInstruction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateHandlingInstruction";
  private static final String UPDATE_PROCESS_NAME = "";
  
  public VerifyHandlingInstruction() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    HandlingInstructionDefinition hid = null;
    String activityCode = null;

    traceLog("VerifyHandlingInstruction", "Beginning doIt()");
    traceLog("VerifyHandlingInstruction", state);
    
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
      
      activityCode = null;
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_PCE_MTCH_ACT_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_PCE_MTCH_ACT_ACTIVITY_CODE");
        throw cciiEx;
      }
      
      activityCode = null;
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_PCE_MTCH_INACT_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_PCE_MTCH_INACT_ACTIVITY_CODE");
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
      
      activityCode = null;
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_SHP_MTCH_ACT_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_SHP_MTCH_ACT_ACTIVITY_CODE");
        throw cciiEx;
      }
      
      activityCode = null;
      activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                       + "_SHP_MTCH_INACT_ACTIVITY_CODE");
      if (activityCode == null)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "Activity code not found: "
                                  + state.getScan().getInViewName().toUpperCase()
                                  + "_SHP_MTCH_INACT_ACTIVITY_CODE");
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

    if (   (   (state.getScan().getHandlingInstructionCode() == null)
            || (state.getScan().getHandlingInstructionCode().equals("") == true))
        && (   (state.getScan().getHandlingInstructionDesc() == null)
            || (state.getScan().getHandlingInstructionDesc().equals("") == true)))
    {
      state.getScan().setErrorNumber(Messages.EM_INV_HANDLING_CODE);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "HandlingInstruction Code and Description are invalid. ");
      throw cciiEx;
    }
        
    if (   (state.getScan().getHandlingInstructionCode() != null)
        && (state.getScan().getHandlingInstructionCode().equals("") != true))
    {
      try
      {
        hid = dbConnection.fetchHandlingInstructionDef(state.getScan().getHandlingInstructionCode());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of HandlingInstructionDef:  " + ex);
        throw cciiEx;
      }

      if (hid == null)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_HANDLING_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "HandlingInstructionDef "
                                  + state.getScan().getHandlingInstructionCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not found in DB");
        throw cciiEx;
      }

      if (hid.getRecordActiveFlag().equals("Y") != true)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_HANDLING_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "HandlingInstructionDef "
                                  + state.getScan().getHandlingInstructionCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not active");
        throw cciiEx;
      }
    }

    traceLog("VerifyHandlingInstruction", state);
    traceLog("VerifyHandlingInstruction", "returning...");

    return state;
  }
}
