/*
 * Created on Aug 17, 2006
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

public class WarehouseCodeUpdate extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: WarehouseCodeUpdate.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

    public WarehouseCodeUpdate() throws Exception
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

        traceLog("WarehouseCodeUpdate", state);

        HandlingUnit handlingUnit = dbConnection.fetchHandlingUnit(state.getScan().getHandlingUnitOid());
        handlingUnit.setWarehouseCode(state.getScan().getWarehouseCode());
        dbConnection.updateHandlingUnitCoreClearance(handlingUnit);
        if(!handlingUnit.isCRN()) {
            dbConnection.updateShipmentCoreClearanceWarehouse(state.getScan().getShipmentOid(),state.getScan().getWarehouseCode());
        }

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

