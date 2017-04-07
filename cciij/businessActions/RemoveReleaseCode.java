package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Remove ReleaseCode
 * Description: This business action sets the ActiveFlag to false in the indicated
 *              Release Code(s)
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Activity code not found
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ReleaseCode
 * @throws      cciij.util.CCIILogException Failure attempting to update ReleaseCode
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

public class RemoveReleaseCode extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: RemoveReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String UPDATE_PROCESS_NAME = "RemoveReleaseCode";
  
  public RemoveReleaseCode() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    ReleaseCode rc = null;
    String activityCode = null;

    traceLog("RemoveReleaseCode", "Beginning doIt()");
    traceLog("RemoveReleaseCode", state);
      
    if (   (state.getScan().getReleaseCode() == null)
        || (state.getScan().getReleaseCode().equals("") == true))
    {
      state.getScan().setErrorNumber(Messages.EM_RELEASE_CODE_REQD);
      CCIILogException cciiEx =
          new CCIILogException("BA_INVENTORY_ERROR_NUMB",
                               "Input Release Code is invalid: ");
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
        rc = dbConnection.fetchReleaseCodeByPieceOid(state.getScan().getLocationCode(),
                                                     state.getScan().getHandlingUnitOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of ReleaseCode:  " + ex);
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
        rc = dbConnection.fetchReleaseCodeByShipmentOid(state.getScan().getLocationCode(),
                                                        state.getScan().getShipmentOid());
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = 
            new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Failure during fetch of ReleaseCode:  " + ex);
        throw cciiEx;
      }
    }
        
    while (rc != null)
    {
      if (rc.getReleaseCode().equals(state.getScan().getReleaseCode()))
      {
        rc.setActiveInactiveFlag(false);
        rc.setDateUpdated(new Date(state.getScan().getSysDateTime()));
        rc.setEmployeeNumberForUpdate(state.getScan().getUserLogon());
        rc.setUpdatedProcessName(UPDATE_PROCESS_NAME);
        
        try
        {
          dbConnection.updateReleaseCode(rc);
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = 
              new CCIILogException("BA_DB_ERROR_NUMB",
                                   "Failure attempting to update ReleaseCode:  " + ex);
          throw cciiEx;
        }

        state.addActivity(activityCode);
      }

      try
      {
        rc = dbConnection.fetchNextReleaseCode();
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                       "Next ReleaseCode fetch failed:  " + ex);
        throw cciiEx;
      }
    }

    traceLog("RemoveReleaseCode", state);
    traceLog("RemoveReleaseCode", "returning...");

    return state;
  }
}
