/*
 * Created on Apr 28, 2006
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
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.CCIILogException;

public class BKKCheckRIPBeforeAddToULD extends ModifyIntercept
   {

         private static final String m_whatVersion = "@(#) $RCSfile: BKKCheckRIPBeforeAddToULD.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

         protected String m_removeAllReadyRemovedCode = null;
         protected String m_removePieceAllReadyRemovedCode = null;

         public BKKCheckRIPBeforeAddToULD() throws Exception
         {
         }

         protected void readSiteConfigVariables() throws Exception
         {
           super.readSiteConfigVariables();
           readActivityCode("INTERCEPT_SHIPMENT_REMOVE_ACTIVITY_CODE","INT_DS",false);
           readActivityCode("INTERCEPT_PIECE_REMOVE_ACTIVITY_CODE","INT_SP",true);
           m_removeAllReadyRemovedCode =  readConfigVariableString("INTERCEPT_DEL_INT_ERROR_SHIPMENT_ACTIVITY_CODE","INTDSE");
           m_removePieceAllReadyRemovedCode =  readConfigVariableString("INTERCEPT_DEL_INT_ERROR_PIECE_ACTIVITY_CODE","INTDPE");
         }

         public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
         {
             
             if(state.getScan().getAirbillFormType().equals("0501")) {
                 return state;
             } else if(state.getScan().getAirbillFormType().equals("0503")) {
                 try {
                     ConsSummary conssummary = dbConnection.fetchConsSummary(state.getScan().getAirbillNumber());
                     if(conssummary.getStatusFlag() !=1 && conssummary.getStatusFlag() !=11) {
                         state.getScan().setErrorNumber(Messages.EM_FORGOT_RIPSCAN);
                     }
                 } catch(Exception ex) {
                     state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                     throw ex;
                 }
             } else {
                 Scan scan = dbConnection.fetchScan("RIP",state.getScan().getHandlingUnitOid(),state.getScan().getShipmentOid());
                 if(scan == null) {
                     state.getScan().setErrorNumber(Messages.EM_FORGOT_RIPSCAN);
                 }
             }
             
             return state;
         }
       }