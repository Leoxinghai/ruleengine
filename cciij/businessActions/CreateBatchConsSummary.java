/*
 * Created on May 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class CreateBatchConsSummary extends BusinessActionBaseWithOidGeneration {
  private static final String m_whatVersion = "@(#) $RCSfile: CreateBatchConsSummary.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  private String m_siteParamLocCd = "";
  public CreateBatchConsSummary() throws Exception {
    traceLog("CreateBatchConsSummary","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_siteParamLocCd = readConfigVariableString("SITE_PARAM_LOCATION_CD");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    BatchConsSummary consSummary = null;

    traceLog("CreateBatchConsSummary", state);

    try
    {
        consSummary =  dbConnection.fetchBatchConsSummary(state.getScan().getConsId());
    }
    catch (Exception ex)
    {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
        throw cciiEx;
    }

    if ( consSummary == null )
    {

        if (state.getScan().getConsDestLoc().equals(""))
        {
            // Set to the SITE_PARAM_LOCATION_CD found in the ccii.cfg
            // This will be modified if there is a Split defined
            state.getScan().setConsDestLoc(m_siteParamLocCd);

        }
        // Now Create the ConsSummary entry
        consSummary = new BatchConsSummary(0,                                                 // Cons Oid (Unknown here)
                                      state.getScan().getConsId(),                       // Cons Number
                                      state.getScan().getConsFormType(),                 // Cons Number Form Type
                                      new Date(state.getScan().getSysDateTime()),        // Creation Date
                                      "",                                                // Flight Number
                                      "",                                                // Flight Origin Loc Code
                                      "",                                                // Flight Destination Loc Code
                                      new Date(state.getScan().getSysDateTime()),        // Flight Arrival Date
                                      state.getScan().getContainerId(),                  // Container Number
                                      state.getScan().getContainerInd(),                 // Container Indicator (Bag, ULD, ...)
                                      state.getScan().getConsDestLoc(),                  // Cons Destination Location Code
                                      state.getScan().getDestCountry(),                  // Cons Destination Country
                                      "",                                                // noi Destination Location Code
                                      state.getScan().getUserLogon(),                    // Employee Number
                                      state.getScan().getLocationCode(),                 // Scan Location Code
                                      new Date(state.getScan().getSysDateTime()),        // Scan Date
                                      new Date(state.getScan().getSysDateTime()),        // Update Date
                                      0,                                                 // Total Piece Quantity
                                      0,                                                 // Regular Notice Quantity
                                      0,                                                 // Intercept Quantity
                                      0,                                                 // Release Quantity
                                      0,                                                 // Clearance Piece Quantity
                                      0,                                                 // Manifested Quantity
                                      0);                                                // Unique Quantity

        // Create a unique ConsSummary Oid Number
        consSummary.setConsSummaryOidNumber(getOid(OidFactoryTypes.CONSSUMMARY));


        // Now Save the new ConsSummary
        try
        {
            dbConnection.saveBatchConsSummary(consSummary);
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Save ConsSummary failed");
            throw cciiEx;
        }

        // The assumption is that the corresponding Cons does not exist, it can't without this ConsSummary
    }
    else
    {
        state.getScan().setConsFormType(consSummary.getConsFormTypeCode());
        state.getScan().setConsDestLoc(consSummary.getDestinationLocationCode());
    }


    // Set some fields in the Scan object
    state.getScan().setConsOid( consSummary.getConsOidNumber() );

    if (state.getScan().getConsType().equals(""))
    {
        // Set the default value as "Other CONS" ("O")
        state.getScan().setConsType("O");
    }
    if (state.getScan().getComments().equals(""))
    {
        // Set the default value to "SCANNER"
        state.getScan().setComments("SCANNER");
    }
    state.getScan().setContainerInd( consSummary.getConsCode());
    state.getScan().setContainerId( consSummary.getContainerNumber());
    state.getScan().setConsDestLoc( consSummary.getDestinationLocationCode());

    traceLog("CreateConsSummary", "Saved");

    return state;

  }

public static void main(String[] args){
     System.out.println("CreateConsSummary in main");

     System.out.println("Leaving main");
    }


}
