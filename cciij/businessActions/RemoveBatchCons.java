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

public class RemoveBatchCons extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: RemoveBatchCons.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
  public RemoveBatchCons() throws Exception {
    traceLog("RemoveCons","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    BatchCons cons = null;
    traceLog("RemoveCons", state);
    try
    {
        cons =  dbConnection.fetchBatchCons(state.getScan().getConsOid(),state.getScan().getAirbillNumber(),false);
    }
    catch (Exception ex)
    {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
        throw cciiEx;
    }

    if ( cons == null )
    {
            state.getScan().setErrorNumber(Messages.EM_NOT_IN_BATCH);
    }
    else
    {
        // Check if the DCon Flag is already set
        if (cons.getDeconsFlag().equals("D"))
        {
            // The entry is already marked as deleted, set error code and return
            state.getScan().setErrorNumber(Messages.EM_NOT_IN_BATCH);
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
                dbConnection.updateBatchCons(cons);
                dbConnection.updateBatchPieceTruckNbr("",state.getScan().getHandlingUnitOid());
            }
            catch (Exception ex)
            {
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Cons update failed");
                throw cciiEx;
            }

            // Update the ConsSummary record, decrementing the piece count
            BatchConsSummary consSummary = null;
            int  i_pieceCount;

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
                    dbConnection.updateBatchConsSummary(consSummary);
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

