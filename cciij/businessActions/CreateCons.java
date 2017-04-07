package cciij.businessActions;

/**
 * Title:        Create CONS entry in CONS database
 * Description:  CreateCons from the content of CONSView.
 *               Determine if the entry already exists in the
 *               CONS table.  If it is already present in the
 *               CONS table, then check if the CONS Oid is the
 *               same, if it is the same then set the DCON_flag
 *               to cleared and return.   If the entry is present
 *               but the CONS Oid is different, then the airbill
 *               belongs to another CONS, but will still be added
 *               to the new CONS.   If the entry is not present in
 *               the database then add the entry.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException Cons Creation failed
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
 *   07/30/02    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import org.apache.log4j.Logger;

import sun.tools.tree.ThisExpression;

public class CreateCons extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: CreateCons.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    private Logger logger = Logger.getLogger("hello");
    public CreateCons() throws Exception
    {
        traceLog("CreateCons","In Constructor");
    }
    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read
    }
    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        Cons cons = null;

        traceLog("CreateCons", state);

//   System.out.println("AbScaned " + state.getAbScanned());
//   System.out.println("AbFormTypeScanned " + state.getAbFormTypeScanned());
//   System.out.println("AbTypeScanned " + state.getAbTypeScanned());

        // Look to see if the entry already exists in the CONS database table
        try
        {
            cons = dbConnection.fetchCons(state.getScan().getConsOid(), state.getAbScanned());
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
            throw cciiEx;
        }

        // Put message that the AB was accepted in the CONS
//        state.getScan().setErrorNumber(Messages.IM_CONS_ACCEPTED);

        if(cons != null && !cons.getFormTypeCode().equals("0503") && !cons.getFormTypeCode().equals("0501")) {
            if(cons.getOidNumber() != state.getScan().getHandlingUnitOid())
                cons = null;
        }
        // If cons is null then the entry does not exist, just create it
        if ( cons == null )
        {
            state = createCons(state, dbConnection);
            state = updateConsSummary(state, dbConnection);
        }
        else
        {
            // CONS entry exists with the Airbill Number in CONSView
            if (cons.getDeconsFlag().equals("D"))
            {
                // The DCON flag is set, clear it out
                cons.setDeconsFlag("");

                // Now Update the existing entry
                dbConnection.updateCons(cons);
                state = updateConsSummary(state, dbConnection);
            }
            else
            {
                // Airbill is already here and it is not Deleted, send a message back
                if (state.getAbScanned().equals(state.getScan().getAirbillNumber()))
                {
                    state.getScan().setErrorNumber(Messages.EM_ALREADY_ADDED);
                }
            }
        }

        traceLog("CreateCons", "Saved");

        return state;
    }

    private CCIIState createCons(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        int SorPorCOidNumber = 0;
        String SorPorC = null;
        String Comments = null;
        Cons cons = null;
        ConsSummary consSummary = null;


        if (state.getScan().getComments().length() > 10)
        {
            Comments = state.getScan().getComments().substring(0,9);
        }
        else
        {
            Comments = state.getScan().getComments();
        }

        // If this is a nested CONS put
        if (state.getAbTypeScanned().equals("3"))
        {
            // The CONS Oid from the original scanned should be used
            try
            {
                consSummary = dbConnection.fetchConsSummary(state.getAbScanned());
            }
            catch (Exception ex)
            {
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
                throw cciiEx;
            }

            // If cons is null then the entry does not exist, problem
            if ( consSummary != null )
            {
                SorPorCOidNumber = consSummary.getConsOidNumber();
                SorPorC = "C";
            }
            else
            {
                System.out.println("Scanned Cons does not exist in our table");

                SorPorCOidNumber = 0;
                SorPorC = "C";
            }
        }
        else
        {
            if (state.getScan().getHandlingUnitOid() != 0)
            {
                SorPorCOidNumber = state.getScan().getHandlingUnitOid();
                SorPorC = "P";
            }
            else
            {
                if (state.getScan().getShipmentOid() != 0)
                {
                    SorPorCOidNumber = state.getScan().getShipmentOid();
                    SorPorC = "S";
                }
                else
                {
                    traceLog("CreateCons", "Piece & Shipment Oid are 0");

                    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Piece & Shipment Oid are 0");
                    throw cciiEx;
                }
            }
        }

        cons = new Cons(state.getScan().getConsOid(),                      // Cons Oid from ConsSummary
                        state.getAbScanned(),                              // Tracking Number or another Cons Number
                        state.getAbFormTypeScanned(),                      // Tracking Number Form Type
                        state.getScan().getConsId(),                       // CONS Number
                        state.getScan().getConsFormType(),                 // CONS Form Type
                        SorPorCOidNumber,                                  // Oid Number of either Piece or Shipment or Cons
                        SorPorC,                                           // 'P'=Piece Oid, 'S'=Shipment Oid, 'C'=Cons
                        new Date(state.getScan().getSysDateTime()),        // Scan Date
                        "",                                                // DCONS flag set to empty
                        Comments,                                          // First 10 characters of the Comments
                        new Date(state.getScan().getSysDateTime()));       // Update Date

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

    private CCIIState updateConsSummary(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        ConsSummary consSummary = null;

        try
        {
            consSummary =  dbConnection.fetchConsSummary(state.getScan().getConsOid());
        }
        catch (Exception ex)
        {
            System.out.println("Updating ConsSummary fetch failed on ConsOid " + state.getScan().getConsOid());
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary fetch failed");
            throw cciiEx;
        }

        if ( consSummary == null )
        {
            // Some kind of error
            System.out.println("Updating ConsSummary fetch returned null on ConsOid " + state.getScan().getConsOid());
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary missing when expected");
            throw cciiEx;
        }
        else
        {
            // Increment the Piece count and set the Update Date
            Date scanDate = new Date(state.getScan().getSysDateTime());

            consSummary.setTotalPieceQuantity(consSummary.getTotalPieceQuantity()+1);
            consSummary.setUpdateDate(scanDate);

            try
            {
                dbConnection.updateConsSummary(consSummary);
            }
            catch (Exception ex)
            {
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "ConsSummary update failed");
                throw cciiEx;
            }
        }

        return state;
    }


    public static void main(String[] args)
    {
        System.out.println("CreateCons in main");

        System.out.println("Leaving main");
    }

}

