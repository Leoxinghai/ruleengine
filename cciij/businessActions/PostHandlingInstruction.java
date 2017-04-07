package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Post HandlingInstruction
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure attempting to save HandlingInstruction
 * @throws      cciij.util.CCIILogException Failure attempting to fetch HandlingInstructionDef
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
 *                              Shortened CREATE_PROCESS_NAME value to supported length.
 *  01/16/2004  Tom Knobeloch   Corrected String comparisons
 *  12/16/2003  Tom Knobeloch   Modified code to differenciate between Shipment
 *                              and Piece level activity.
 *                              Added code to reactivate an inactive matching 
 *                              HandlingInstruction.
 */

public class PostHandlingInstruction extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingInstruction.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateHndlngInstruct";
  private static final String UPDATE_PROCESS_NAME = "";
  
  public PostHandlingInstruction() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  private HandlingInstructions checkForExistingHandlingInstruction(CCIIState state,
                                                                   DatabaseBean dbConnection)
          throws Exception
  {
    HandlingInstructions dbHI = null;
    
    if (state.getPieceLevelInventory() == true)
    {
      try
      {
        dbHI = dbConnection.fetchHandlingInstructionByPieceOid(state.getScan().getHandlingUnitOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch HandlingInstruction:  " + ex);
        throw cciiEx;
      }
    }
    else
    {
      try
      {
        dbHI = dbConnection.fetchHandlingInstructionByShipmentOid(state.getScan().getShipmentOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch HandlingInstruction:  " + ex);
        throw cciiEx;
      }
    }
    
    while (dbHI != null)
    {
      if (   (state.getScan().getHandlingInstructionCode() == null)
          || (state.getScan().getHandlingInstructionCode().equals("") == true))
      {
        if (dbHI.getHandlingInstructionDescription().equals(state.getScan().getHandlingInstructionDesc()) == true)
        {
          return dbHI;
        }
      }
      else
      {
        if (dbHI.getHandlingInstructionCode().equals(state.getScan().getHandlingInstructionCode()) == true)
        {
          return dbHI;
        }
      }
      
      try
      {
        dbHI = dbConnection.fetchNextHandlingInstruction();
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetchNext HandlingInstruction:  " + ex);
        throw cciiEx;
      }
    }
    return null;
  }
  
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    HandlingInstructions hi = null;
    HandlingInstructionDefinition hid = null;
    String activityCode = null;
    ReasonCode rc = null;

    traceLog("PostHandlingInstruction", "Beginning doIt()");
    traceLog("PostHandlingInstruction", state);
    
    hi = checkForExistingHandlingInstruction(state, dbConnection);
    if (hi != null)
    {
      if (hi.getActiveFlag().equals("Y") == true)
      {
        if (state.getPieceLevelInventory() == true)
        {
          activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                           + "_PCE_MTCH_ACT_ACTIVITY_CODE");
        }
        else
        {
          activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                           + "_SHP_MTCH_ACT_ACTIVITY_CODE");
        }
        state.addActivity(activityCode);
      }
      else if (hi.getActiveFlag().equals("N") == true)
      {
        if (state.getPieceLevelInventory() == true)
        {
          activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                           + "_PCE_MTCH_INACT_ACTIVITY_CODE");
        }
        else
        {
          activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                           + "_SHP_MTCH_INACT_ACTIVITY_CODE");
        }
        
        hi.setActiveFlag(true);
        hi.setUpdateDate(new Date(state.getScan().getSysDateTime()));
        hi.setUpdateEmployeeNumber(state.getScan().getUserLogon());
        hi.setUpdateProcessName(CREATE_PROCESS_NAME);
        state.addActivity(activityCode);
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
      }
    }
    else
    {
      if (state.getPieceLevelInventory() == true)
      {
        activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                         + "_PIECE_ACTIVITY_CODE");
      }
      else
      {
        activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                         + "_SHIPMENT_ACTIVITY_CODE");
      }
      
      if (   (state.getScan().getHandlingInstructionCode() == null)
          || (state.getScan().getHandlingInstructionCode().equals("") == true))
      {
        if (state.getPieceLevelInventory() == true)
        {
          hi = new HandlingInstructions(getOid(OidFactoryTypes.HANDLINGINSTRUCTIONS),
                                        0,
                                        state.getScan().getHandlingUnitOid(),
                                        state.getScan().getLocationCode(),
                                        "",
                                        state.getScan().getHandlingInstructionDesc(),
                                        "Y",
                                        new Date(state.getScan().getSysDateTime()),
                                        state.getScan().getUserLogon(),
                                        CREATE_PROCESS_NAME,
                                        new Date(state.getScan().getSysDateTime()),
                                        "",
                                        UPDATE_PROCESS_NAME);
        }
        else
        {
          hi = new HandlingInstructions(getOid(OidFactoryTypes.HANDLINGINSTRUCTIONS),
                                        state.getScan().getShipmentOid(),
                                        0,
                                        state.getScan().getLocationCode(),
                                        "",
                                        state.getScan().getHandlingInstructionDesc(),
                                        "Y",
                                        new Date(state.getScan().getSysDateTime()),
                                        state.getScan().getUserLogon(),
                                        CREATE_PROCESS_NAME,
                                        new Date(state.getScan().getSysDateTime()),
                                        "",
                                        UPDATE_PROCESS_NAME);
        }
      }
      else
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
      
        if (hid.getAppliesReleaseCode().equals("") != true)
        {
          state.getScan().setReleaseCode(hid.getAppliesReleaseCode());
        }
                                                    
        if (state.getPieceLevelInventory() == true)
        {
          hi = new HandlingInstructions(getOid(OidFactoryTypes.HANDLINGINSTRUCTIONS),
                                        0,
                                        state.getScan().getHandlingUnitOid(),
                                        state.getScan().getLocationCode(),
                                        state.getScan().getHandlingInstructionCode(),
                                        hid.getHandlingInstructionDescription(),
                                        "Y",
                                        new Date(state.getScan().getSysDateTime()),
                                        state.getScan().getUserLogon(),
                                        CREATE_PROCESS_NAME,
                                        new Date(state.getScan().getSysDateTime()),
                                        "",
                                        UPDATE_PROCESS_NAME);
        }
        else
        {
          hi = new HandlingInstructions(getOid(OidFactoryTypes.HANDLINGINSTRUCTIONS),
                                        state.getScan().getShipmentOid(),
                                        0,
                                        state.getScan().getLocationCode(),
                                        state.getScan().getHandlingInstructionCode(),
                                        hid.getHandlingInstructionDescription(),
                                        "Y",
                                        new Date(state.getScan().getSysDateTime()),
                                        state.getScan().getUserLogon(),
                                        CREATE_PROCESS_NAME,
                                        new Date(state.getScan().getSysDateTime()),
                                        "",
                                        UPDATE_PROCESS_NAME);
        }
      }

      state.addHandlingInstruction(hi);
      state.addActivity(activityCode);

      try
      {
        dbConnection.saveHandlingInstruction(hi);
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to save HandlingInstruction:  " + ex);
        throw cciiEx;
      }
    }    

    traceLog("PostHandlingInstruction", state);
    traceLog("PostHandlingInstruction", "returning...");

    return state;
  }
}
