package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Verify ReleaseCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException RELEASE_CODE_UPLOAD_TIMING_CODE not found
 * @throws      cciij.util.CCIILogException DETAINMENT_OUT_SCAN_TYPE not found
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Shipment is invalid
 * @throws      cciij.util.CCIILogException HandlingUnit is invalid
 * @throws      cciij.util.CCIILogException Release Code not found in ReleaseCode Vector
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReleaseCodeDef
 * @throws      cciij.util.CCIILogException ReleaseCodeDef not found
 * @throws      cciij.util.CCIILogException ReleaseCodeDef not active
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
 *  01/13/2004  Tom Knobeloch   Corrected edit and message for no ReleaseCode input.
 *  12/16/2003  Tom Knobeloch   Modified check for Activity code to differenciate
 *                              between Shipment and Piece level activity.
 *                              Added additional Activity Code verifications.
 */

public class VerifyReleaseCode extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateReleaseCode";
  private static final String UPDATE_PROCESS_NAME = "";
  String m_releaseCodeUploadTimingCode = "";
  String m_detainmentOutScanType = "";
  ReleaseCode rc = null;
  ReleaseCodeDef rcd = null;

  public VerifyReleaseCode() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_releaseCodeUploadTimingCode
         = readConfigVariableString("RELEASE_CODE_UPLOAD_TIMING_CODE").toUpperCase();
    m_detainmentOutScanType
         = readConfigVariableString("DETAINMENT_OUT_SCAN_TYPE").toUpperCase();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    String activityCode = null;

    traceLog("VerifyReleaseCode", "Beginning doIt()");
    traceLog("VerifyReleaseCode", state);
    
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
      
    if (   (state.getScan().getReleaseCode() == null)
        || (state.getScan().getReleaseCode().equals("") == true))
    {
      state.getScan().setErrorNumber(Messages.EM_RELEASE_CODE_REQD);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "ReleaseCode required.");
      throw cciiEx;
    }
    else
    {
      try
      {
        rcd = dbConnection.fetchReleaseCodeDef(state.getScan().getReleaseCode());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of ReleaseCodeDefinition:  " + ex);
        throw cciiEx;
      }

      if (rcd == null)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_RELEASE_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ReleaseCodeDefinition "
                                  + state.getScan().getReleaseCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not found in DB");
        throw cciiEx;
      }

      if (rcd.getRecordActiveFlag().equals("Y") != true)
      {
        state.getScan().setErrorNumber(Messages.EM_INV_RELEASE_CODE);
        CCIILogException cciiEx = 
            new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                                 "ReleaseCodeDefinition "
                                  + state.getScan().getReleaseCode()
                                  + ":"
                                  + state.getScan().getLocationCode()
                                  + " not active");
        throw cciiEx;
      }
          
      if (m_releaseCodeUploadTimingCode.equals("") == true)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "RELEASE_CODE_UPLOAD_TIMING_CODE not defined: ");
        throw cciiEx;
      }

      if (m_detainmentOutScanType.equals("") == true)
      {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx =
            new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                 "DETAINMENT_OUT_SCAN_TYPE not defined: ");
        throw cciiEx;
      }
    }  

    traceLog("VerifyReleaseCode", state);
    traceLog("VerifyReleaseCode", "returning...");

    return state;
  }
}
