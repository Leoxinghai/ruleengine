package cciij.businessActions;

/**
 * Title:        VerifyShipmentInCons
 * Description:  Verify that the Airbill being scanned belongs
 *               to the same shipment as other airbills already
 *               existing in this CONS.   If this is the first
 *               airbill to be put into the CONS, then it will
 *               determine the Shipment Identification.
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
 *   04/02/03    Gary Rockwood - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

public class VerifyShipmentInCons extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: VerifyShipmentInCons.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    private String m_shipmentInCons = "";

    public VerifyShipmentInCons() throws Exception
    {
        traceLog("VerifyShipmentInCons","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();

        m_shipmentInCons = readConfigVariableString("CONS_MUST_BE_SAME_SHIPMENT", "Y");
        if (m_shipmentInCons.equals("TRUE") ||
            m_shipmentInCons.equals("true"))
        {
            m_shipmentInCons = "Y";
        }
        else if (m_shipmentInCons.equals("FALSE") ||
                 m_shipmentInCons.equals("false"))
        {
            m_shipmentInCons = "N";
        }
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
    {
        traceLog("VerifyShipmentInCons", state);

        // Set the Default as Tracking Number accepted on CONS
        state.getScan().setErrorNumber(Messages.IM_CONS_ACCEPTED);

        // Check if the CONS must be only 1 shipment
        if (m_shipmentInCons.equals("N"))
        {
            traceLog("VerifyShipmentInCons", "CONS not restricted to same Shipment");

            return state;
        }

        Cons cons = null;

        // Attempt to do a CONS table lookup with the CONS number in the State object
        try
        {
            cons = dbConnection.fetchCons(state.getScan().getConsId());
        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Cons fetch failed");
            throw cciiEx;
        }

        // If cons is null then the entry does not exist, this must be the first one
        if ( cons != null )
        {
//            System.out.println("CONS found, Cons Oid Nbr = " + cons.getConsOidNumber());
            // If the Oid type is 'S', then the Oid Number is the Shipment
            if (cons.getOidTypeCode().equals("S"))
            {
//                System.out.println("Oid in Cons is type 'S'");
//                System.out.println("Compare ConsOid " + cons.getOidNumber() +
//                                   " with ShipmentOid " + state.getScan().getShipmentOid());
                // Check that the Shipment Oid is the same
                if (cons.getOidNumber() != state.getScan().getShipmentOid())
                {
                    // The Oid numbers do not match, set the error number
                    state.getScan().setErrorNumber(Messages.EM_NOT_IN_SHIPMENT);
                }
            }
            else
            {
                // If the Oid type is 'P', then the Oid number is a PieceOid
                if (cons.getOidTypeCode().equals("P"))
                {
//                    System.out.println("Oid in Cons is type 'P'");
                    // Define a structure to hold the HandlingUnit object
                    HandlingUnit piece = null;

                    try
                    {
                        // If the Oid Type is 'P', (pieceOid), then do a piece table lookup
                        piece = dbConnection.fetchHandlingUnit(cons.getOidNumber());
                    }
                    catch (Exception ex)
                    {
                        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Handling Unit fetch failed");
                        throw cciiEx;
                    }

                    // Check that an entry was found
                    if (piece != null)
                    {
//                        System.out.println("Compare Piece ShipmentOid " + piece.getShipmentOidNumber() +
//                                   " with ShipmentOid " + state.getScan().getShipmentOid());

                        // Check the ShipmentOidNumber against what is in the state object
                        if (piece.getShipmentOidNumber() != state.getScan().getShipmentOid())
                        {
                            // The oid's do not match, set the error number
                            state.getScan().setErrorNumber(Messages.EM_NOT_IN_SHIPMENT);
                        }
                    }
                    else
                    {
                        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Handling Unit Oid not found");
                        throw cciiEx;
                    }
                }
                else
                {
                    // The Oid type must be another CONS, do not allow airbill in a CONS with nesting
                    state.getScan().setErrorNumber(Messages.EM_NOT_IN_SHIPMENT);
                }
            }
        }
        traceLog("VerifyShipmentInCons", "Finished");

        return state;
    }

    public static void main(String[] args)
    {
        System.out.println("VerifyShipmentInCons in main");

        System.out.println("Leaving main");
    }

}

