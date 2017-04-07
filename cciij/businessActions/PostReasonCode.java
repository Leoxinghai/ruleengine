package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Post ReasonCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure attempting to fetch DetainmentIn Scan
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReleaseCode
 * @throws      cciij.util.CCIILogException Failure attempting to update ReleaseCode
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReasonCodeDef
 * @throws      cciij.util.CCIILogException Failure attempting to save ReasonCode
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *  05/10/2004  Tom Knobeloch   Added code to cause upload of configured 'scans'
 *                              when a Reason Code is added.
 *  01/26/2004  Tom Knobeloch   Enhanced database exception logging.
 *  01/16/2004  Tom Knobeloch   Corrected String comparisons
 *  12/16/2003  Tom Knobeloch   Modified code to differenciate between Shipment
 *                              and Piece level activity.
 *                              Removed logic to inactivate any Release Codes.
 *                              Added logic for recurringCriteria attribute.
 *                              Added code to reactivate an inactive matching 
 *                              ReasonCode.
 */

public class PostReasonCode extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostReasonCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateReasonCode";
  private static final String UPDATE_PROCESS_NAME = "";
  String m_reasonCodeUploadTimingCode = "";
  String m_detainmentInScanType = "";
  ReasonCode m_rc = null;
  
  public PostReasonCode() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_reasonCodeUploadTimingCode
         = readConfigVariableString("REASON_CODE_UPLOAD_TIMING_CODE").toUpperCase();
    m_detainmentInScanType
         = readConfigVariableString("DETAINMENT_IN_SCAN_TYPE").toUpperCase();
  }

  public CCIIState performUploadActions(CCIIState state, DatabaseBean dbConnection)
         throws Exception
  {
    ReasonCodeDefinition rcd = null;
    
    Scan scan = null;

    // Look for a Detainment In scan for any piece of this shipment.
    try
    {
      scan= dbConnection.fetchScan(m_detainmentInScanType,
                                   state.getScan().getHandlingUnitOid(),
                                   state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = 
          new CCIILogException("BA_DB_ERROR_NUMB",
                               "Failure during fetch of Detainment In Scan:  " + ex);
      throw cciiEx;
    }

    if (   (m_reasonCodeUploadTimingCode.equals("P") == true)
        || (scan != null))
    {
      m_rc.setUploadFlag(true);
      state.addUploadKey(state.getScan().getLocationCode(),
                         "REASON_CODE_ADD",
                         state.getScan().getReasonCode(),
                         "00");
      
      try
      {
        rcd = dbConnection.fetchReasonCodeDef(state.getScan().getReasonCode());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of ReasonCodeDefinition:  " + ex);
        throw cciiEx;
      }
      
      if (rcd.getOpenCERFlag().equals("Y") == true)
      {
        //                                    //
        // add logic to open a CER/Trace here //
        //                                    //
      }
      
      if (rcd.getPostLocStatNumber().equals("") != true)
      {
        //state.getScan().setLocStatNbr(rcd.getPostLocStatNumber());
      }
    }
    
    return state;
  }

  private ReasonCode checkForExistingReasonCode(CCIIState state,
                                                DatabaseBean dbConnection)
          throws Exception
  {
    ReasonCode dbRC = null;
    
    if (state.getPieceLevelInventory() == true)
    {
      try
      {
        dbRC = dbConnection.fetchReasonCodeByPieceOid(state.getScan().getLocationCode(),
                                                      state.getScan().getHandlingUnitOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch ReasonCode:  " + ex);
        throw cciiEx;
      }
    }
    else
    {
      try
      {
        dbRC = dbConnection.fetchReasonCodeByShipmentOid(state.getScan().getLocationCode(),
                                                         state.getScan().getShipmentOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch ReasonCode:  " + ex);
        throw cciiEx;
      }
    }
    
    while (dbRC != null)
    {
      if (dbRC.getReasonCode().equals(state.getScan().getReasonCode()) == true)
      {
        return dbRC;
      }
      
      try
      {
        dbRC = dbConnection.fetchNextReasonCode();
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetchNext ReasonCode:  " + ex);
        throw cciiEx;
      }
    }
    return null;
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    String activityCode = null;
    String fromRecurringCriteria = "";

    traceLog("PostReasonCode", "Beginning doIt()");
    traceLog("PostReasonCode", state);
    
    if (state.getRecuringInventoryFlag() == true)
    {
      fromRecurringCriteria = "Y";
    }
    else
    {
      fromRecurringCriteria = "N";
    } 
    
    m_rc = checkForExistingReasonCode(state, dbConnection);
    if (m_rc != null)
    {
      if (m_rc.getActiveInactiveFlag().equals("Y") == true)
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
      else if (m_rc.getActiveInactiveFlag().equals("N") == true)
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
        
        m_rc.setActiveInactiveFlag(true);
        m_rc.setDateUpdated(new Date(state.getScan().getSysDateTime()));
        m_rc.setEmployeeNumberForUpdate(state.getScan().getUserLogon());
        m_rc.setUpdatedProcessName(CREATE_PROCESS_NAME);
        state.addActivity(activityCode);

        try
        {
          dbConnection.updateReasonCode(m_rc);
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = 
              new CCIILogException("BA_DB_ERROR_NUMB",
                                   "Failure attempting to update ReasonCode:  " + ex);
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
        m_rc = new ReasonCode(state.getScan().getReasonCode(),
                              getOid(OidFactoryTypes.REASONCODE),
                              0,
                              state.getScan().getHandlingUnitOid(),
                              fromRecurringCriteria,
                              "Y",
                              new Date(state.getScan().getSysDateTime()),
                              state.getScan().getUserLogon(),
                              new Date(state.getScan().getSysDateTime()),
                              "",
                              CREATE_PROCESS_NAME,
                              UPDATE_PROCESS_NAME,
                              "N",
                              state.getScan().getLocationCode());
      }
      else
      {
        activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                         + "_SHIPMENT_ACTIVITY_CODE");
        m_rc = new ReasonCode(state.getScan().getReasonCode(),
                              getOid(OidFactoryTypes.REASONCODE),
                              state.getScan().getShipmentOid(),
                              0,
                              fromRecurringCriteria,
                              "Y",
                              new Date(state.getScan().getSysDateTime()),
                              state.getScan().getUserLogon(),
                              new Date(state.getScan().getSysDateTime()),
                              "",
                              CREATE_PROCESS_NAME,
                              UPDATE_PROCESS_NAME,
                              "N",
                              state.getScan().getLocationCode());
      }
        
      state = performUploadActions(state, dbConnection);
      state.addCAGEReasonCode(m_rc);
      state.addActivity(activityCode);

      try
      {
        dbConnection.saveReasonCode(m_rc);
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to save ReasonCode:  " + ex);
        throw cciiEx;
      }
    }

    traceLog("PostReasonCode", state);
    traceLog("PostReasonCode", "returning...");

    return state;
  }
}
