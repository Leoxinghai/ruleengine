package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Post ReleaseCode
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure attempting to fetch DetainmentOut Scan
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReasonCode
 * @throws      cciij.util.CCIILogException Failure attempting to update ReasonCode
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReleaseCodeDef
 * @throws      cciij.util.CCIILogException Failure attempting to save ReleaseCode
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
 *                              when a Release Code is added.
 *  01/26/2004  Tom Knobeloch   Enhanced database exception logging.
 *  01/16/2004  Tom Knobeloch   Corrected String comparisons
 *  12/16/2003  Tom Knobeloch   Modified code to differenciate between Shipment
 *                              and Piece level activity.
 *                              Removed logic to inactivate any Reason Codes
 *                              Added code to reactivate an inactive matching 
 *                              ReleaseCode.
 */

public class PostReleaseCode extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateReleaseCode";
  private static final String UPDATE_PROCESS_NAME = "";
  String m_releaseCodeUploadTimingCode = "";
  String m_detainmentOutScanType = "";
  ReleaseCode m_rc = null;

  public PostReleaseCode() throws Exception
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

  public CCIIState performUploadActions(CCIIState state, DatabaseBean dbConnection)
         throws Exception
  {
    ReleaseCodeDef rcd = null;
    
    Scan scan = null;

    // Look for a Detainment Out scan for any piece of this shipment.
    try
    {
      scan= dbConnection.fetchScan(m_detainmentOutScanType,
                                   state.getScan().getHandlingUnitOid(),
                                   state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = 
          new CCIILogException("BA_DB_ERROR_NUMB",
                               "Failure during fetch of Detainment Out Scan:  " + ex);
      throw cciiEx;
    }

    if (   (m_releaseCodeUploadTimingCode.equals("P") == true)
        || (scan != null))
    {
      m_rc.setUploadFlag(true);
      state.addUploadKey(state.getScan().getLocationCode(),
                         "RELEASE_CODE_ADD",
                         state.getScan().getReleaseCode(),
                         "00");
      
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
      
      if (rcd.getCloseCerFlag().equals("Y") == true)
      {
        //                                       //
        // add logic to close any CER/Trace here //
        //                                       //
      }
      
      if (rcd.getPostLocStatNumber().equals("") != true)
      {
        //state.getScan().setLocStatNbr(rcd.getPostLocStatNumber());
      }
    }
    
    return state;
  }

  private ReleaseCode checkForExistingReleaseCode(CCIIState state,
                                                  DatabaseBean dbConnection)
          throws Exception
  {
    ReleaseCode dbRC = null;
    
    if (state.getPieceLevelInventory() == true)
    {
      try
      {
        dbRC = dbConnection.fetchReleaseCodeByPieceOid(state.getScan().getLocationCode(),
                                                       state.getScan().getHandlingUnitOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch ReleaseCode:  " + ex);
        throw cciiEx;
      }
    }
    else
    {
      try
      {
        dbRC = dbConnection.fetchReleaseCodeByShipmentOid(state.getScan().getLocationCode(),
                                                          state.getScan().getShipmentOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetch ReleaseCode:  " + ex);
        throw cciiEx;
      }
    }
    
    while (dbRC != null)
    {
      if (dbRC.getReleaseCode().equals(state.getScan().getReleaseCode()) == true)
      {
        return dbRC;
      }
      
      try
      {
        dbRC = dbConnection.fetchNextReleaseCode();
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to fetchNext ReleaseCode:  " + ex);
        throw cciiEx;
      }
    }
    return null;
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    String activityCode = null;

    traceLog("PostReleaseCode", "Beginning doIt()");
    traceLog("PostReleaseCode", state);
                                                    
    m_rc = checkForExistingReleaseCode(state, dbConnection);
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
          dbConnection.updateReleaseCode(m_rc);
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = 
              new CCIILogException("BA_DB_ERROR_NUMB",
                                   "Failure attempting to update ReleaseCode:  " + ex);
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
        m_rc = new ReleaseCode(getOid(OidFactoryTypes.REASONCODE),
                               0,
                               state.getScan().getReleaseCode(),                           
                               "Y",
                               new Date(state.getScan().getSysDateTime()),
                               state.getScan().getUserLogon(),
                               CREATE_PROCESS_NAME,
                               new Date(state.getScan().getSysDateTime()),
                               "",
                               UPDATE_PROCESS_NAME,
                               "N",
                               state.getScan().getHandlingUnitOid(),
                               state.getScan().getLocationCode());
      }
      else
      {
        activityCode = m_config.getValue(state.getScan().getInViewName().toUpperCase()
                                         + "_SHIPMENT_ACTIVITY_CODE");
        m_rc = new ReleaseCode(getOid(OidFactoryTypes.REASONCODE),
                               state.getScan().getShipmentOid(),
                               state.getScan().getReleaseCode(),                           
                               "Y",
                               new Date(state.getScan().getSysDateTime()),
                               state.getScan().getUserLogon(),
                               CREATE_PROCESS_NAME,
                               new Date(state.getScan().getSysDateTime()),
                               "",
                               UPDATE_PROCESS_NAME,
                               "N",
                               0,
                               state.getScan().getLocationCode());
      }
          
      state = performUploadActions(state, dbConnection);
      state.addCAGEReleaseCode(m_rc);
      state.addActivity(activityCode);

      try
      {
        dbConnection.saveReleaseCode(m_rc);
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure attempting to save ReleaseCode:  " + ex);
        throw cciiEx;
      }
    }

    traceLog("PostReleaseCode", state);
    traceLog("PostReleaseCode", "returning...");

    return state;
  }
}
