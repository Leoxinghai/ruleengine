package cciij.businessActions;

/**
 * Title:        Creste CONS Summary
 * Description:  CreateConsSummary from the content of CONSView.
 *               First determine if the ConsSummary already exists.
 *               If it does not exist, create it
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException ConsSummary Creation failed
 *
 * @return       state -  State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   07/30/02    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class CreateConsSummary extends BusinessActionBaseWithOidGeneration {
  private static final String m_whatVersion = "@(#) $RCSfile: CreateConsSummary.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private String m_siteParamLocCd = "";
  public CreateConsSummary() throws Exception {
    traceLog("CreateConsSummary","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_siteParamLocCd = readConfigVariableString("SITE_PARAM_LOCATION_CD");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    ConsSummary consSummary = null;

    traceLog("CreateConsSummary", state);

    // Check that if Split Number entered it is valid
    if (state.getScan().getSplitNumber().length() > 0)
    {
        int i_splitNumber = Integer.parseInt(state. getScan().getSplitNumber());
        if (i_splitNumber > SplitsCheck.SPLIT_MAX)
        {
            state.getScan().setErrorNumber(Messages.EM_INVALID_SPLIT);
            return state;
        }
    }


    try
    {
        consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsId());
    }
    catch (Exception ex)
    {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
        throw cciiEx;
    }

    if ( consSummary == null )
    {
        // Set the form type to 0504 and change to other below
        state.getScan().setConsFormType("0504");

        // If this is a ULD set the form type to 0501
        if (state.getScan().getContainerInd().equals("U"))
        {
            state.getScan().setConsFormType("0501");
        }

        // If this is a CAGE set the form type to 0502
        if (state.getScan().getContainerInd().equals("C"))
        {
            state.getScan().setConsFormType("0502");
        }

        // If this is a BAG container set ContainerId to blank
        if (state.getScan().getContainerInd().equals("B"))
        {
            state.getScan().setContainerId("BAG");
            state.getScan().setConsFormType("0503");
        }

        // If we do not know what kind of container, set to Other
        if (state.getScan().getContainerInd().equals(""))
        {
            // Set to the default value of Other "O"
            state.getScan().setContainerInd("O");
            state.getScan().setContainerId("OTHER");
        }

        // The Cons Summary does not exist, set some default values if blank
        if (state.getScan().getContainerId().equals(""))
        {
            // Set to the default value of "PALLET"
            state.getScan().setContainerId("PALLET");
        }

        if (state.getScan().getConsDestLoc().equals(""))
        {
            // Set to the SITE_PARAM_LOCATION_CD found in the ccii.cfg
            // This will be modified if there is a Split defined
            state.getScan().setConsDestLoc(m_siteParamLocCd);

            // If this has a split, get dest location from split record
            if (state.getScan().getSplitNumber().length() > 0)
            {
                // Define the split object
                Split rdSplit = new Split();
                byte[]  m_splitFormat = new byte[200];
                char[] s_working = new char[10];

                try
                {
                    int i_splitNumber = Integer.parseInt(state. getScan().getSplitNumber());
                    rdSplit = dbConnection.fetchSplit(i_splitNumber);
                }
                catch (Exception ex)
                {
                    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Split Read failed in CreatConsSummary");
                }

                // Check if a Split Record was found
                if (rdSplit != null)
                {
                    // We have a split, extract the destination
                    m_splitFormat = rdSplit.getSplitValue();

                    // Prefix and Suffix splits may have destination at different places
                    if (m_splitFormat[182] == (byte)0xFF)    // Prefix
                    {
                        for (int i=0; i<5; i++)  s_working[i] = (char)m_splitFormat[i+1];
                    }
                    else
                    {
                        for (int i=0; i<5; i++)  s_working[i] = (char)m_splitFormat[i+6];
                    }
                    state.getScan().setConsDestLoc(String.copyValueOf(s_working,0,5));
//                  System.out.println("DestLocation " + state.getScan().getConsDestLoc());
                }
            }
        }

        // Now Create the ConsSummary entry
        consSummary = new ConsSummary(0,                                                 // Cons Oid (Unknown here)
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

        // Set the Split Number
        if (state.getScan().getSplitNumber().length() > 0)
        {
            int i_splitNumber = Integer.parseInt(state. getScan().getSplitNumber());
            consSummary.setSplitNumber (i_splitNumber);
        }
        else
        {
            consSummary.setSplitNumber( 0 );
        }

        // Now Save the new ConsSummary
        try
        {
            dbConnection.saveConsSummary(consSummary);
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
