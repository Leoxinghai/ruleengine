package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Verify ReasonCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException REASON_CODE_UPLOAD_TIMING_CODE not found
 * @throws      cciij.util.CCIILogException DETAINMENT_IN_SCAN_TYPE not found
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Shipment is invalid
 * @throws      cciij.util.CCIILogException HandlingUnit is invalid
 * @throws      cciij.util.CCIILogException Reason Code not found in ReasonCode Vector
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReasonCodeDef
 * @throws      cciij.util.CCIILogException ReasonCodeDef not found
 * @throws      cciij.util.CCIILogException ReasonCodeDef not active
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
 *  01/13/2004  Tom Knobeloch   Corrected edit and message for no ReasonCode input.
 *  12/16/2003  Tom Knobeloch   Modified check for Activity code to differenciate
 *                              between Shipment and Piece level activity.
 *                              Added additional Activity Code verifications.
 */

public class VerifyReasonCode extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyReasonCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateReasonCode";
  private static final String UPDATE_PROCESS_NAME = "";
  String m_reasonCodeUploadTimingCode = "";
  String m_detainmentInScanType = "";
  ReasonCodeDefinition rcd = null;
  ReasonCode newrc = null;
  
  public VerifyReasonCode() throws Exception
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

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    String activityCode = null;

    traceLog("VerifyReasonCode", "Beginning doIt()");
    traceLog("VerifyReasonCode", state);
    
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
      
    if (   (state.getScan().getReasonCode() == null)
        || (state.getScan().getReasonCode().equals("") == true))
    {
      state.getScan().setErrorNumber(Messages.EM_REASON_CODE_REQD);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "ReasonCode required.");
      throw cciiEx;
    }
    else
    {
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

      if (rcd == null)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_REASON_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ReasonCodeDefinition "
                                  + state.getScan().getReasonCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not found in DB");
        throw cciiEx;
      }

      if (rcd.getRecordActiveFlag().equals("Y") != true)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_REASON_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ReasonCodeDefinition "
                                  + state.getScan().getReasonCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not active");
        throw cciiEx;
      }
         
      if (m_reasonCodeUploadTimingCode.equals("") == true)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "REASON_CODE_UPLOAD_TIMING_CODE not defined: ");
        throw cciiEx;
      }

      if (m_detainmentInScanType.equals("") == true)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "DETAINMENT_IN_SCAN_TYPE not defined: ");
        throw cciiEx;
      }
    }  

    traceLog("VerifyReasonCode", state);
    traceLog("VerifyReasonCode", "returning...");

    return state;
  }
}
