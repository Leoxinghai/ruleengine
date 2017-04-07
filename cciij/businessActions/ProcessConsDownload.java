package cciij.businessActions;

/**
 * Title:        ProcessConsDownload
 * Description:  Checks existance of ConsSummary and creates
 *               it if it doesn't exist.  Then checks existance
 *               of Cons and creates it if it doesn't exist.  If
 *               it does exist, it may be updated.
 *               Before this BA is executed another BA
 *               (FindNestedConsSummary or FindHandlingUnit) may
 *               set the element OidNbr to match to manifest data.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Tom Knobeloch
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Cons Creation failed
 *               cciij.util.CCIILogException ConsSummary Creation failed
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   07/05/04    Tom Knobeloch - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ProcessConsDownload extends BusinessActionBaseWithOidGeneration
{
  private static final String m_whatVersion = "@(#) $RCSfile: ProcessConsDownload.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  int adjustmentQty = 0;

  public ProcessConsDownload() throws Exception
  {
    traceLog("ProcessConsDownload","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    java.util.Date flightDate = new java.util.Date();
    java.util.Date updateDate = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String deconsFlg = "";
    Cons cons = null;
    ConsSummary consSummary = null;

    traceLog("ProcessConsDownload", state);

    try
    {
      if (state.getScan().getConsOid() == 0)
      {
        consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsId());
      }
      else
      {
        consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsOid());
      }
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
      throw cciiEx;
    }

    if ( consSummary == null )
    {
      try
      {
        flightDate = sdf.parse(state.getScan().getFlightDate());
      }
      catch (Exception ex)
      {
        //  Ignore the error and set flightDate to null
        flightDate = null;
      }
     
      // Now Create the ConsSummary entry
      consSummary = new ConsSummary(getOid(OidFactoryTypes.CONSSUMMARY),          // Cons Oid (Create one here)
                                    state.getScan().getConsId(),                  // Cons Number
                                    state.getScan().getConsFormType(),            // Cons Number Form Type
                                    state.getScan().getConsCreateDate(),          // Creation Date
                                    state.getScan().getFlightNumber(),            // Flight Number
                                    state.getScan().getFlightOriginLocCode(),     // Flight Origin Loc Code
                                    state.getScan().getFlightDestLocCode(),       // Flight Destination Loc Code
                                    flightDate,                                   // Flight Arrival Date
                                    state.getScan().getContainerId(),             // Container Number
                                    state.getScan().getContainerInd(),            // Container Indicator (Bag, ULD, ...)
                                    state.getScan().getConsDestLoc(),             // Cons Destination Location Code
                                    state.getScan().getDestCountry(),             // Cons Destination Country
                                    state.getScan().getConsNoiDestLocCode(),      // noi Destination Location Code
                                    state.getScan().getUserLogon(),               // Employee Number
                                    state.getScan().getConsScanLocCode(),         // Scan Location Code
                                    state.getScan().getConsScanDate(),            // Scan Date
                                    state.getScan().getConsComponentDate(),       // Update Date
                                    0,                                            // Total Piece Quantity
                                    0,                                            // Regular Notice Quantity
                                    0,                                            // Intercept Quantity
                                    0,                                            // Release Quantity
                                    0,                                            // Clearance Piece Quantity
                                    0,                                            // Manifested Quantity
                                    0);                                           // Unique Quantity
      // Now Save the new ConsSummary
      try
      {
        dbConnection.saveConsSummary(consSummary);
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
			  "Save ConsSummary failed for CONS ID: " + state.getScan().getConsId(),ex);
        throw cciiEx;
      }
    }

    // Set some fields in the Scan object
    state.getScan().setConsOid( consSummary.getConsOidNumber() );

    if (state.getScan().getComments().equals(""))
    {
      // Set the default value to "SCANNER"
      state.getScan().setComments("SCANNER");
    }

    // Look to see if the entry already exists in the CONS database table
    try
    {
      cons = dbConnection.fetchCons(state.getScan().getConsOid(), state.getScan().getAirbillNumber());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
      throw cciiEx;
    }

    // If cons is null then the entry does not exist, just create it
    if ( cons == null )
    {
      state = createCons(state, dbConnection);
      state = updateConsSummary(state, consSummary, dbConnection);
    }
    else
    {
      // CONS entry exists with the Airbill Number in CONSView
      adjustmentQty = 0;
      if (   (cons.getDeconsFlag().equals("D"))
          && (state.getScan().getConsDeconsDate() == null))
        {
          updateDate = new java.util.Date(state.getScan().getSysDateTime());
          deconsFlg = "";
          adjustmentQty = 1;
        }

      if (   (cons.getDeconsFlag().equals(""))
          && (state.getScan().getConsDeconsDate() != null))
      {
        updateDate = state.getScan().getConsDeconsDate();
        deconsFlg = "D";
        adjustmentQty = -1;
      }

      if (adjustmentQty != 0)
      {
        // Now Update the existing entry
        dbConnection.updateCons(cons);
        state = updateConsSummary(state, consSummary, dbConnection);
      }
      else
      {
        traceLog("ProcessConsDownload", "Airbill is already here and it is not Deleted");
      }
    }

    traceLog("ProcessConsDownload", "Saved");

    return state;
  }

  private CCIIState createCons(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    int PorCOidNumber = 0;
    String PorC = null;
    String Comments = null;
    String deconsFlg = "";
    java.util.Date updateDt = null;
    Cons cons = null;

    if (state.getScan().getComments().length() > 10)
    {
      Comments = state.getScan().getComments().substring(0,9);
    }
    else
    {
      Comments = state.getScan().getComments();
    }

    if (state.getScan().getConsDeconsDate() == null)
    {
      updateDt = state.getScan().getConsComponentDate();
      adjustmentQty = +1;
    }
    else
    {
      updateDt = state.getScan().getConsDeconsDate();
      deconsFlg = "D";
      adjustmentQty = -1;
    }
      
    // If this is a nested CONS put
    if (state.getScan().getAirbillType().equals("3"))
    {
      // The CONS Oid was placed here by FindNestedConsSummary
      PorCOidNumber = state.getScan().getHandlingUnitOid();
      PorC = "C";
    }
    else
    {
      // The Piece Oid was placed here by ?????FindNestedConsSummary?????
      PorCOidNumber = state.getScan().getHandlingUnitOid();
      PorC = "P";
    }

    cons = new Cons(state.getScan().getConsOid(),             // Cons Oid from ConsSummary
                    state.getScan().getAirbillNumber(),       // Tracking Number or another Cons Number
                    state.getScan().getAirbillFormType(),     // Tracking Number Form Type
                    state.getScan().getConsId(),              // CONS Number
                    state.getScan().getConsFormType(),        // CONS Form Type
                    PorCOidNumber,                            // Oid Number of either Piece or Cons
                    PorC,                                     // 'P'=Piece Oid, 'C'=Cons
                    state.getScan().getConsComponentDate(),   // Scan Date
                    deconsFlg,                                // DCONS flag
                    Comments,                                 // First 10 characters of the Comments
                    updateDt);                                // Update Date

    try
    {
      dbConnection.saveCons(cons);
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Save Cons failed");
      throw cciiEx;
    }

    return state;
  }

  private CCIIState updateConsSummary(CCIIState state, ConsSummary consSummary, DatabaseBean dbConnection) throws Exception
  {
    // Increment/decrement the Piece count and set the Update Date
    consSummary.setTotalPieceQuantity(consSummary.getTotalPieceQuantity()+adjustmentQty);
    consSummary.setUpdateDate(state.getScan().getConsComponentDate());

    try
    {
      dbConnection.updateConsSummary(consSummary);
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", 
			   "ConsSummary update failed", ex);
      throw cciiEx;
    }

    return state;
  }


  public static void main(String[] args)
  {
    System.out.println("CreateCons in main");

    System.out.println("Leaving main");
  }

}
