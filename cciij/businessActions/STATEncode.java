package cciij.businessActions;

/**
 * Title:        Comment Encode
 * Description:  
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx Services
 * @author       Kathy Smathers 
 * @version 1.0
 *
 * @throws       
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   02/24/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciicosmos.Cciicosmos;
import cciicosmos.cosmosasn.*;
import java.text.*;
import java.util.*;
import java.io.*;
import com.oss.asn1.*;
import com.oss.util.*;


public class STATEncode extends ASNEncode
{
  private static final String m_whatVersion = "@(#) $RCSfile: STATEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private rmtc.util.TemplateParser m_parser = null;
  public STATEncode() throws Exception
  { 
    NoLookupTemplateParser parserKey = new NoLookupTemplateParser();
    m_parser = new rmtc.util.TemplateParser(parserKey);
    traceLog("CMTEncode","In Constructor");
  }


  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    return state;
  } 

  public void createMessage(CCIIState state, 
			      DatabaseBean dbConnection,
                              Upload upload)
			      throws Exception

  {  
    state.getCurrentScan().setScanTypeCode("STAT");
    state.getCurrentScan().setLocStatNumber(upload.getUploadCode());
    String comment = m_parser.buildString(
	 state.getCurrentScan().getCommentDescription(), state);
    state.getCurrentScan().setCommentDescription(comment);

    // we need a shipment and pieceRouteLeg for additional fields required
    //   for a locStat upload
    Shipment shipment = null;
    PieceRouteLeg pieceRouteLeg = null;

    try
    {
      shipment = dbConnection.fetchShipment(state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
					   "STAT Shipment fetch failed");
      throw cciiEx;
    }

    if ( shipment == null )
    {
     /* state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                               "STAT Shipment not found for shipmentOid");
      throw cciiEx;
      */
        super.createMessage(state, dbConnection, upload);
        return;
    }

    state.getScan().setServiceCode(shipment.getServiceCode());
    state.getScan().setDestPostal(shipment.getConsigneePostalCode());
    state.getScan().setDestCountry(shipment.getDestinationCountryCode());

    //Check if the overage flag is NOT M - manifested, Y - yes,
    //DELETED, ROUTE, SORTDATE, or D - date.

    if ( state.getOverageFlag().equals("M") == false
         && state.getOverageFlag().equals("Y") == false
         && state.getOverageFlag().equals("DELETED") == false
         && state.getOverageFlag().equals("ROUTE") == false
         && state.getOverageFlag().equals("SORTDATE") == false
         && state.getOverageFlag().equals("D") == false)
    {
      try
      {
        pieceRouteLeg = dbConnection.fetchPieceRouteLeg(
	                state.getScan().getHandlingUnitOid());
        if ( pieceRouteLeg == null )
        {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                 "Piece Route Leg not found for handlingUnitOid");
          throw cciiEx;
        }
      }
      catch (Exception ex)
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
	                          "Piece Route Leg fetch failed");
        throw cciiEx;
      }
//      state.getScan().setMdeRoute(pieceRouteLeg.getRouteNumber());
    }
    super.createMessage(state, dbConnection, upload);
  }


  public static void main(String[] args)
  {
     System.out.println("CMTEncode in main");

     System.out.println("Leaving main");
  }

}

