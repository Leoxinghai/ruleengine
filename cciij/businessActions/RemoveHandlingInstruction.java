package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Remove HandlingInstruction
 * Description: This business action sets the ActiveFlag to false in the indicated
 *              Handling Instruction(s)
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Failure attempting to fetch HandlingInstruction
 * @throws      cciij.util.CCIILogException Failure attempting to update HandlingInstruction
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
 */

public class RemoveHandlingInstruction extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: RemoveHandlingInstruction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String UPDATE_PROCESS_NAME = "RemoveHandlingInstruction";
  
  public RemoveHandlingInstruction() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    HandlingInstructions hi = null;
    String activityCode = null;

    traceLog("RemoveHandlingInstruction", "Beginning doIt()");
    traceLog("RemoveHandlingInstruction", state);
      
    if (   (   (state.getScan().getHandlingInstructionCode() == null)
            || (state.getScan().getHandlingInstructionCode().equals("") == true))
        && (   (state.getScan().getHandlingInstructionDesc() == null)
            || (state.getScan().getHandlingInstructionDesc().equals("") == true)))
    {
      state.getScan().setErrorNumber(Messages.EM_INV_HANDLING_CODE);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "Input Handling Instruction is invalid: ");
      throw cciiEx;
    }
    
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
      
      try
      {
        hi = dbConnection.fetchHandlingInstructionByPieceOid(state.getScan().getHandlingUnitOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of HandlingInstruction:  " + ex);
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
      
      try
      {
        hi = dbConnection.fetchHandlingInstructionByShipmentOid(state.getScan().getShipmentOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of HandlingInstruction:  " + ex);
        throw cciiEx;
      }
    }
        
    while (hi != null)
    {
      if (   (hi.getHandlingInstructionCode().equals(state.getScan().getHandlingInstructionCode()))
          || (hi.getHandlingInstructionDescription().equals(state.getScan().getHandlingInstructionDesc())))
      {
        hi.setActiveFlag(false);
        hi.setUpdateDate(new Date(state.getScan().getSysDateTime()));
        hi.setUpdateEmployeeNumber(state.getScan().getUserLogon());
        hi.setUpdateProcessName(UPDATE_PROCESS_NAME);
       
        try
        {
          dbConnection.updateHandlingInstruction(hi);
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = 
              new CCIILogException("BA_DB_ERROR_NUMB",
                                   "Failure attempting to update HandlingInstruction:  " + ex);
          throw cciiEx;
        }

        state.addActivity(activityCode);
      }

      try
      {
        hi = dbConnection.fetchNextHandlingInstruction();
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                       "Next HandlingInstruction fetch failed:  " + ex);
        throw cciiEx;
      }  
    }

    traceLog("RemoveHandlingInstruction", state);
    traceLog("RemoveHandlingInstruction", "returning...");

    return state;
  }
}
