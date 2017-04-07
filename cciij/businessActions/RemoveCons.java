package cciij.businessActions;

/**
 * Title:        Remove CONS
 * Description:  Find a Tracking Number in the Cons database table.  If the Cons entry
 *               is not found, set the i_errorNumber to EM_AB_NOT_IN_CONS.
 *               If the entry is found mark it with a "D" in the DeconsFlag field and
 *               put the IM_DEL_FROM_CONS in i_errorNumber.
 *               Return the state object to the caller.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException ConsSummary fetch failed
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
 *   07/31/02    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class RemoveCons extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: RemoveCons.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public RemoveCons() throws Exception {
    traceLog("RemoveCons","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Cons cons = null;
    traceLog("RemoveCons", state);
    try
    {
        cons =  dbConnection.fetchCons(state.getScan().getConsOid(), state.getScan().getAirbillNumber());
    }
    catch (Exception ex)
    {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
        throw cciiEx;
    }

    if ( cons == null )
    {
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
    }
    else
    {
        if(!cons.getFormTypeCode().equals("0501") &&!cons.getFormTypeCode().equals("0503") && cons.getOidNumber() != state.getScan().getHandlingUnitOid()) {
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
        	return state;
        }
        // Check if the DCon Flag is already set
        if (cons.getDeconsFlag().equals("D"))
        {
            // The entry is already marked as deleted, set error code and return
            state.getScan().setErrorNumber(Messages.EM_AB_NOT_IN_CONS);
            state.getScan().setReturnMessage("AWB already marked as deleted from CONS");
        }
        else
        {
            // Do the update on the Cons record and update the ConsSummary record
            Date scanDate = new Date(state.getScan().getSysDateTime());

            cons.setUpdateDate(scanDate);
            cons.setDeconsFlag("D");
            state.getScan().setErrorNumber(Messages.IM_DEL_FROM_CONS);

            try
            {
                dbConnection.updateCons(cons);
            }
            catch (Exception ex)
            {
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Cons update failed");
                throw cciiEx;
            }

            // Update the ConsSummary record, decrementing the piece count
            ConsSummary consSummary = null;
            int  i_pieceCount;

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
                // Some kind of error
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","ConsSummary missing when expected");
                throw cciiEx;
            }
            else
            {
                // Decrement the Piece count and set the Update Date
                i_pieceCount = consSummary.getTotalPieceQuantity();

                if (i_pieceCount > 0)
                {
                    i_pieceCount--;
                }

                consSummary.setTotalPieceQuantity(i_pieceCount);
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
        }
    }

    return state;

  }

public static void main(String[] args){
     System.out.println("RemoveCons in main");

     System.out.println("Leaving main");
    }


}
