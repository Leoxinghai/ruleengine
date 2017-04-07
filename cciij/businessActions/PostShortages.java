package cciij.businessActions;

/**
 * Title:        Post Shortages
 * Description:  This is the business action which posts entries into the
 *               PIECE_STATUS table from a background queue.  (See IdentifyShortages)
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       java.lang.Exception Config error, MARKED_PIECE_SHORTAGE_ACTIVITY_CODE not found
 *
 * return        state - state object.
 *
 * Pre-condition:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   09/16/2004  Gary Rockwood  Initial createion
 *
 */



import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class  PostShortages extends BusinessActionBase
{

  private static final String m_whatVersion = "@(#) $RCSfile: PostShortages.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";


  /**
   * PostShortages
   *
   */
  public PostShortages() throws Exception
  {
  }

  /**
   * doIt
   * @param CCIIState state
   * @param DatabaseBean dbConnection
   * @return CCIIState
   */

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    PieceStatus   pieceStatus = null;       // PieceStatus Object

    traceLog("PostShortages (RouteClosed)",state);
   
    // Loop thru the Piece Status from entries on a background queue

    // Establish the location Code
    String s_locationCd = state.getScan().getLocationCode();

    // This must be a Shortage, create a Shortage record in PIECE_STATUS
    // but first check if an entry of this kind already exists
    try
    {
      pieceStatus = dbConnection.fetchPieceStatus( state.getScan().getHandlingUnitOid(),        // Piece Oid Number
                                                   s_locationCd,                      // Location Cd
                                                   state.getRouteLegInfo().getSortDate(),               // Sort Date
                                                   "S");                              // Shortage Status Code
    }
    catch (Exception ex)
    {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","PieceStatus fetch failed");
       throw cciiEx;
    }
          
    // if there is nothing returned, then we can create an entry
    if (pieceStatus == null)
    {
      pieceStatus = new PieceStatus();

      // Create a PIECE_STATUS indicating Shortage
      pieceStatus.setPieceOidNbr( state.getScan().getHandlingUnitOid() );
      pieceStatus.setLocationCd( s_locationCd );
      pieceStatus.setSortDt( state.getRouteLegInfo().getSortDate() );
      pieceStatus.setPieceStatusCd( "S" );
      pieceStatus.setShipmentOidNbr( state.getScan().getShipmentOid() );
      pieceStatus.setRouteLegOidNbr( state.getScan().getRouteLegOid() );
      pieceStatus.setResolutionStatusCd( "" );
      pieceStatus.setRfaCd( "" );

      try
      {
        dbConnection.savePieceStatus( pieceStatus );
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","PieceStatus save failed",ex);
	ex.printStackTrace();
        throw cciiEx;
      }
    }

    // Add an activity to the Activity Vector
    state.addActivity(m_config.getValue("MARKED_PIECE_SHORTAGE_ACTIVITY_CODE"));
 
    return state;
  }
}
