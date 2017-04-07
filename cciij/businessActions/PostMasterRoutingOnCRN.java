package cciij.businessActions;

/**
 * Title:       Post Handling Unit
 * Description: This Business Action retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the staging area code
 *              - the detainment location description
 *              - the last modified date timestamp
 *              - the last user name
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author     Liu Xinghai
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of HandlingUnit
 * @throws      cciij.util.CCIILogException HandlingUnit fetch by Oid failed
 * @throws      cciij.util.CCIILogException Failure during update of HandlingUnit
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 02/14/2002Liu Xinghai Created from PostHandlingUnit.java
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostMasterRoutingOnCRN extends BusinessActionBase {

    SimpleNotify m_notify;
    private static final String m_whatVersion = "@(#) $RCSfile: PostMasterRoutingOnCRN.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public PostMasterRoutingOnCRN() throws Exception {
        traceLog("PostMasterRoutingOnCRN","In Constructor");
        m_notify = new SimpleNotify("PostMasterOnCRN");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read in
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

        HandlingUnit hu = null;
        Shipment ship = null;
        PieceRouteLeg prl = null;
        PieceRouteLeg newPRL = null;
        boolean l_loop = true;

        traceLog("PostMasterRoutingOnCRN","Begining doIt()");
        traceLog("PostMasterRoutingOnCRN",state);

        try {
            if((ship = dbConnection.fetchShipment(state.getScan().getShipmentOid())) != null)
            {
                hu = dbConnection.fetchHandlingUnitWithShipmentOid(state.getScan().getShipmentOid());
                while(hu != null)
                {
                    if(hu.getTrackingNumber().equals(ship.getAWBNumber()))
                    {
                        break; // We have found the master's hu...
                    }

                    hu = dbConnection.fetchNextHandlingUnit();
                }
            }
        }
        catch (Exception ex) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failure during fetch of the master HandlingUnit");
            throw cciiEx;
        }

        if ( ship == null ) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                           "shipment fetch by shipOid failed, shipOid == " + state.getScan().getShipmentOid());;
            throw cciiEx;
        }

        if ( hu == null ) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                           "HandlingUnit fetch of master failed, shipOid == " + state.getScan().getShipmentOid());;
            throw cciiEx;
        }

        // now we have the master hu... lets find it's pieceRouteLeg table record...

        try {
            prl = dbConnection.fetchPieceRouteLeg(hu.getHandlingUnitOidNumber());

            while(prl != null)
            {
                m_notify.trace_CriticalCode_TM_3S_CHECKPOINT("PostMasterRoutingOnCRN::doIt()",
                                                             "Found a PieceRouteLeg",
                                                             prl);


                newPRL = new PieceRouteLeg(prl.getRouteNumber(),
                                           prl.getRouteDate(),
                                           prl.getRouteLegNumber(),
                                           state.getScan().getShipmentOid(),
                                           state.getScan().getHandlingUnitOid(),
                                           prl.getOriginLocationCode(),
                                           prl.getSequenceNumber(),
                                           prl.getScanReconFlag());

                m_notify.trace_CriticalCode_TM_3S_CHECKPOINT("PostMasterRoutingOnCRN::doIt()",
                                                             "created a new PiecrRouteLeg, lets save it",
                                                             newPRL);

                dbConnection.savePieceRouteLeg(newPRL);

                prl = dbConnection.fetchNextPieceRouteLeg();
            }
        }
        catch (Exception ex) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failure during copy of master's pieceRouteLeg's to the associated CRN");
            throw cciiEx;
        }



        // update the hu object with data from the RPBScan/State Obj

// 	if(hu.getOverageReasonCode().equals(""))
// 	{
// 	    hu.setOverageReasonCode("D");

// 	    try {
// 		dbConnection.updateHandlingUnit(hu);
// 	    }
// 	    catch (Exception ex ) {
// 		state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
// 		CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
// 							       "Failure during update of HandlingUnit");
// 		throw cciiEx;
// 	    }
// 	}

        traceLog("PostMasterRoutingOnCRN","returning ...");
        return state;
    }
}
