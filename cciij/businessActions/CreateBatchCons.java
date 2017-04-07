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

public class CreateBatchCons extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: CreateBatchCons.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

    public CreateBatchCons() throws Exception
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
        BatchCons cons = null;

        traceLog("CreateCons", state);

//   System.out.println("AbScaned " + state.getAbScanned());
//   System.out.println("AbFormTypeScanned " + state.getAbFormTypeScanned());
//   System.out.println("AbTypeScanned " + state.getAbTypeScanned());

        // Look to see if the entry already exists in the CONS database table
        try
        {
            cons = dbConnection.fetchBatchCons(state.getScan().getHandlingUnitOid(), state.getAbScanned(),true);
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
            throw cciiEx;
        }

        // Put message that the AB was accepted in the CONS
//        state.getScan().setErrorNumber(Messages.IM_CONS_ACCEPTED);

        // If cons is null then the entry does not exist, just create it
        
        if(cons != null) {
            	if(cons.getConsOidNumber() == state.getScan().getConsOid())
                    state.getScan().setErrorNumber(Messages.EM_ALREADY_ADDED);
            	else
	                state.getScan().setErrorNumber(Messages.EM_BATCH_EXISTED);
                return state;
        }

        try
        {
            cons = dbConnection.fetchBatchCons(state.getScan().getConsOid(), state.getAbScanned(),false);
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
            throw cciiEx;
        }
        
        if ( cons == null )
        {
            state = createCons(state, dbConnection);
            state = updateConsSummary(state, dbConnection);
            
        }
        else
        {
            if (cons.getDeconsFlag().equals("D"))
            {
                // The DCON flag is set, clear it out
                cons.setDeconsFlag("");

                // Now Update the existing entry
                dbConnection.updateBatchCons(cons);
                dbConnection.updateBatchPieceTruckNbr(state.getScan().getContainerId(),state.getScan().getHandlingUnitOid());
                HandlingUnit handlingUnit = dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
                handlingUnit.setWarehouseCode(state.getScan().getWarehouseCode());
                dbConnection.updateHandlingUnitCoreClearance(handlingUnit);
                if(!handlingUnit.isCRN()) {
                    dbConnection.updateShipmentCoreClearanceWarehouse(state.getScan().getShipmentOid(),state.getScan().getWarehouseCode());
                }
                
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
        BatchCons cons = null;
        BatchConsSummary consSummary = null;


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
                consSummary = dbConnection.fetchBatchConsSummary(state.getAbScanned());
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

        cons = new BatchCons(state.getScan().getConsOid(),                      // Cons Oid from ConsSummary
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
            dbConnection.saveBatchCons(cons);
            dbConnection.updateBatchPieceTruckNbr(state.getScan().getContainerId(),state.getScan().getHandlingUnitOid());
            HandlingUnit handlingUnit = dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
            handlingUnit.setWarehouseCode(state.getScan().getWarehouseCode());
            dbConnection.updateHandlingUnitCoreClearance(handlingUnit);
            if(!handlingUnit.isCRN()) {
                dbConnection.updateShipmentCoreClearanceWarehouse(state.getScan().getShipmentOid(),state.getScan().getWarehouseCode());
            }
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
        BatchConsSummary consSummary = null;

        try
        {
            consSummary =  dbConnection.fetchBatchConsSummary(state.getScan().getConsOid());
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
                dbConnection.updateBatchConsSummary(consSummary);
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


