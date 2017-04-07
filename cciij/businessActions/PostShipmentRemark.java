package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:       Post ShipmentRemark
 * Description:
 * Copyright:   Copyright (c) 2003
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure attempting to save ShipmentRemark
 * @throws      cciij.util.CCIILogException Failure attempting to fetch ShipmentRemarkDef
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
 *  01/16/2004  Tom Knobeloch   Corrected String comparisons
 *  12/16/2003  Tom Knobeloch   Modified code to differenciate between Shipment
 *                              and Piece level activity.
 */

public class PostShipmentRemark extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostShipmentRemark.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private static final String CREATE_PROCESS_NAME = "CreateShipmentRemark";
  private static final String UPDATE_PROCESS_NAME = "";

  public PostShipmentRemark() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    ShipmentRemark sr = null;
    ShipmentRemarkDef srd = null;
    String activityCode = null;

    traceLog("PostShipmentRemark", "Beginning doIt()");
    traceLog("PostShipmentRemark", state);
    
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
      
    if (   (state.getScan().getShipmentRemarkCode() == null)
        || (state.getScan().getShipmentRemarkCode().equals("") == true))
    {
      if (state.getPieceLevelInventory() == true)
      {
        sr = new ShipmentRemark(getOid(OidFactoryTypes.SHIPMENTREMARK),
                                0,
                                state.getScan().getLocationCode(),
                                "",
                                state.getScan().getHandlingUnitOid(),
                                state.getScan().getShipmentRemarkDesc(),
                                new Date(state.getScan().getSysDateTime()),
                                state.getScan().getUserLogon(),
                                CREATE_PROCESS_NAME,
                                new Date(state.getScan().getSysDateTime()),
                                "",
                                UPDATE_PROCESS_NAME,
                                state.getScan().getAgencyCode());
      }
      else
      {
        sr = new ShipmentRemark(getOid(OidFactoryTypes.SHIPMENTREMARK),
                                state.getScan().getShipmentOid(),
                                state.getScan().getLocationCode(),
                                "",
                                0,
                                state.getScan().getShipmentRemarkDesc(),
                                new Date(state.getScan().getSysDateTime()),
                                state.getScan().getUserLogon(),
                                CREATE_PROCESS_NAME,
                                new Date(state.getScan().getSysDateTime()),
                                "",
                                UPDATE_PROCESS_NAME,
                                state.getScan().getAgencyCode());
      }
    }
    else
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
                                                    
      if (state.getPieceLevelInventory() == true)
      {
        sr = new ShipmentRemark(getOid(OidFactoryTypes.SHIPMENTREMARK),
                                0,
                                state.getScan().getLocationCode(),
                                state.getScan().getShipmentRemarkCode(),
                                state.getScan().getHandlingUnitOid(),
                                srd.getShipmentDescription(),
                                new Date(state.getScan().getSysDateTime()),
                                state.getScan().getUserLogon(),
                                CREATE_PROCESS_NAME,
                                new Date(state.getScan().getSysDateTime()),
                                "",
                                UPDATE_PROCESS_NAME,
                                state.getScan().getAgencyCode());
      }
      else
      {
        sr = new ShipmentRemark(getOid(OidFactoryTypes.SHIPMENTREMARK),
                                state.getScan().getShipmentOid(),
                                state.getScan().getLocationCode(),
                                state.getScan().getShipmentRemarkCode(),
                                0,
                                srd.getShipmentDescription(),
                                new Date(state.getScan().getSysDateTime()),
                                state.getScan().getUserLogon(),
                                CREATE_PROCESS_NAME,
                                new Date(state.getScan().getSysDateTime()),
                                "",
                                UPDATE_PROCESS_NAME,
                                state.getScan().getAgencyCode());
      }
    }

    state.addShipmentRemark(sr);
    state.addActivity(activityCode);
    
    try
    {
      dbConnection.saveShipmentRemark(sr);
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = 
          new CCIILogException("BA_DB_ERROR_NUMB",
                               "Failure attempting to save ShipmentRemark:  " + ex);
      throw cciiEx;
    }

    traceLog("PostShipmentRemark", state);
    traceLog("PostShipmentRemark", "returning...");

    return state;
  }
}
