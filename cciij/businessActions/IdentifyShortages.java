package cciij.businessActions;

/**
 * Title:        Identify Shortages
 * Description:  This is the business action which identify pieces which hava not
 *               had a physical Custody scan performed and put an entry on the
 *               background queue
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Route Leg fetch failed
 * @throws       cciij.util.CCIILogException RouteLeg record not found for handlingUnitOid
 *
 * return        state - state object.
 *
 * Pre-condition:
 * @param        dbConnection - valid database connection from connection pool.
 *               routeLeg - RouteLeg record object exists in the DB 
 *                          Pieces associated with the RouteLeg are in the DB
 *
 * Modification History:
 *   09/16/2004  Gary Rockwood  Initial createion
 *   10/07/2004  Joey Cline     Changed due to modified SQL.
 *
 */



import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class  IdentifyShortages extends BusinessActionBase
{

  private static final String m_whatVersion = "@(#) $RCSfile: IdentifyShortages.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  private QueueWriter m_pieceShortageQueueWriter = null;
  private String s_locationCd = null;      
  private String s_activityCd = null;
  private String s_groupName = null;

  /**
   * IdentifyShortages
   *
   */
  public IdentifyShortages() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();

    s_activityCd = m_config.getValue("MARKED_ROUTE_SHORTAGE_ACTIVITY_CODE");
    s_groupName =  m_config.getValue("SHORTAGE_QUEUE_GROUP_NAME");

  }

  /**
   * doIt
   * @param CCIIState state
   * @param DatabaseBean dbConnection
   * @return CCIIState
   */

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    HandlingUnit  piece = null;             // Piece Object
    Shipment      ship  = null;             // Shipment Object

    traceLog("IdentifyShortages (RouteClosed)",state);
   
    // Only do this on a Closed Route
    if ( state.getRouteLegInfo().getRouteLegStatusCd().equals("C"))
    {
      // Initialize the count of shortage pieces
      int i_shortCount = 0;

      // set the locationCd
      s_locationCd = state.getScan().getLocationCode();

      // Get the actual Tracking Number for use in the posting part of Shortages
      try
      { 
        piece = dbConnection.fetchAllNonScannedPiecesOnRoute( 
		                state.getRouteLegInfo().getRouteNumber(),
                                state.getRouteLegInfo().getRouteDate(),
                                state.getRouteLegInfo().getRouteLegNumber() );
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed",ex);
        throw cciiEx;
      }

      // Find all non scanned pieces for the route leg
      while ( piece != null ) 
      {
        // Check in the Shipment table for Manifest Status Code = 'A' and that value only
        try
        {
          ship = dbConnection.fetchShipment( piece.getShipmentOidNumber() );
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment fetch failed",ex);
          throw cciiEx;
        }

        if ( ship.isManifested() )
        {
          // Increment the count of Shortages entries found for this RouteLeg
          i_shortCount++;

          state.getScan().setAirbillNumber( piece.getTrackingNumber() );
          state.getScan().setShipmentOid( piece.getShipmentOidNumber() );
          state.getScan().setHandlingUnitOid( piece.getHandlingUnitOidNumber() );

          // Put an entry on the BackgroundQueue for posting to the PieceStatus table
          PostShortageOnBackgroundQueue(state);
        }
 
        // Get the next piece from this route leg           
        try
        {
          piece = dbConnection.fetchNextHandlingUnit();
        }
        catch (Exception ex)
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Piece fetchNext failed", ex);
          throw cciiEx;
        }
      }

      // Set the messages as to the number of shortages found for this RouteLeg
      state.getScan().setReturnMessage( i_shortCount + " pieces identified as shortages" );

      // Set an activity entry for this route
      state.addActivity( s_activityCd );
    }
    else
    {
      state.getScan().setErrorNumber(Messages.EM_ROUTE_NOT_CLOSED);
    }

    return state;
  }

  private void PostShortageOnBackgroundQueue(CCIIState state)
  {
    try
    {
      if (m_pieceShortageQueueWriter == null)
      {
        m_pieceShortageQueueWriter = new QueueWriter();
      }

      CCIIState s = (CCIIState)state.clone();

      s.setRuleSetName(m_config.getValue("SHORTAGE_POST_RULESET"));

      m_pieceShortageQueueWriter.putOnQueue(s_groupName,
                                            s_locationCd,
                                            s);
    }
    catch(Exception e)
    {
      notifyLog("Failed to Post the Exception Activity:  ",e);
    }
  }

}

