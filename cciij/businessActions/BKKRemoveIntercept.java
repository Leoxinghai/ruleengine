/*
 * Created on Apr 27, 2006
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

public class BKKRemoveIntercept extends ModifyIntercept
   {

     private static final String m_whatVersion = "@(#) $RCSfile: BKKRemoveIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

     protected String m_removeAllReadyRemovedCode = null;
     protected String m_removePieceAllReadyRemovedCode = null;

     public BKKRemoveIntercept() throws Exception
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
       Intercept intercept = null;
       InterceptCodeDefinition interceptDef = null;
       boolean activeInterceptDef = false;
       boolean isExceptionActivity = true;
       //broke this out so it would be easier to access for child classes
       //probably don't need to verify Intercept def to satisfy it
             //set active flag to 'N'
       if(state.getScan().getShipmentOid() ==0 ) {
           state.getScan().setErrorNumber(Messages.EM_HAWB_NOT_EXIST);
           return state;
       }
       
//       intercept = new Intercept();
//       intercept.setActiveFlag(INTERCEPT_REMOVED);
       String interceptCode = state.getScan().getInterceptCode();
       if(interceptCode.trim().length()==0) return state;
       String interceptCodes[] = interceptCode.split(" ");
       int removed = 0;
       for(int i =0 ;i<interceptCodes.length;i++) {
           state.getScan().setInterceptCode(interceptCodes[i]);
           try {
               intercept = dbConnection.fetchInterceptWithShipOidAndInterceptCd(state.getScan().getShipmentOid(),
                                                                           state.getScan().getInterceptCode());
             }
             catch (Exception ex) {
                 state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                             "Fetch of intercept using shipmentOid or PieceOid failed");
                 throw cciiEx;
             }
             if(intercept != null && intercept.getActiveFlag().equals("Y")) {
	             intercept.setActiveFlag(INTERCEPT_REMOVED);
	             updateModifyIntercept(state,dbConnection,intercept);
	             state = addClearanceActivity(state,intercept,"INT_SS",isExceptionActivity);
	             removed = 1;
             }
           
       }
       if(removed ==0) {
           state.getScan().setErrorNumber(Messages.EM_NOINTERCEPT_REMOVED);
       }
       state.getScan().setInterceptCode("");
       //state = addClearanceActivity(state,intercept,isExceptionActivity);
       return state;
     }
   }