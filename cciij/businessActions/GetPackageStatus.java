package cciij.businessActions;

/**
 * Title:       Get Package Status
 * Description: This Business Action checks the package status.
 *
 *              First, check for either an OverageFlag of "Y" or a shipmentOid
 *              of 0 (ZERO). When either of the condition exists, set the return
 *              and error messsages of the state object to the appropriate value
 *              and return the object to the caller.
 *
 *              Next, Check the InterceptFlag for a value of "Y". If the InterceptFlag
 *              is "Y", determine if the InViewName id "DEPVIEW". For an InViewName of
 *              "DEPVIEW" evaluate the state ErrorNumber attribute for a not released
 *              value. When not released, set the state object error message number
 *              to not released. Otherwise, set the state object error message number
 *              to not cleared. If the InViewName is NOT "DEPVIEW", set the state
 *              object error message to intercepted.
 *
 *              When the InterceptFlag is NOT "Y", examine the state error number attribute
 *              for a value of cleared, and the state PostiveSort for a value of false.
 *              Set te state object return message to cleared.
 *
 *              If the state error number attribute is 0 (ZERO), set the error number to
 *              the start over value.
 *
 *              Return the state object to the caller.
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer   Add comments and document tags.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;


public class GetPackageStatus extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: GetPackageStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public GetPackageStatus() throws Exception  {
    traceLog("GetPackageStatus","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();

    m_notReleasedDepartureExceptionCode = readConfigVariableString("UNCLEARED_DEPARTURE_EXCEPTION");
    m_notClearedDepartureExceptionCode = readConfigVariableString("UNRELEASED_DEPARTURE_EXCEPTION");
  }

  protected String m_notReleasedDepartureExceptionCode = "";
  protected String m_notClearedDepartureExceptionCode = "";

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

// This class uses state.getScan().getInViewName to determine if its the CNF scan
//  being performed, probably need ScanTypeCode in the state Object

    Intercept intercept = null;
    Intercept customsRelease = null;

    if ( state.getOverageFlag().equals("Y")
         || state.getScan().getShipmentOid() == 0 ) {
      traceLog("GetPackageStatus",state);
      state.getScan().setReturnMessage("Not found");
      state.getScan().setErrorNumber(Messages.IM_NOT_FOUND);
      return state;
    }


    if ( state.getInterceptedFlag().equals("Y") ) {
      state.getScan().setReturnMessage("Intercepts Exist");
      if ( ( state.getScan().getInViewName().toUpperCase().equals("DEPVIEW") )
        || ( state.getScan().getInViewName().toUpperCase().equals("CONSE_DEPVIEW") ) )
      {
        if ( state.getScan().getErrorNumber() == Messages.IM_NOT_RELEASED ) {
         state.addExceptionActivity(m_notReleasedDepartureExceptionCode);
         state.getScan().setErrorNumber(Messages.EM_NOT_RELEASED);
        }
        else {
         state.addExceptionActivity(m_notClearedDepartureExceptionCode);
         state.getScan().setErrorNumber(Messages.EM_NOT_CLEARED);
        }
      }
      else {
        state.getScan().setReturnMessage("   INTCRPT " + state.getScan().getInterceptCode() + " ");
        state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
//      state.getScan().setErrorNumber(Messages.IM_INTERCEPTED);
      }
      traceLog("GetPacakgeStatus","Package has active intercepts, status == Intercepts Exist");
    }
    else if ( state.getScan().getErrorNumber() == Messages.IM_CLEARED ) {
      state.getScan().setReturnMessage("Cleared");
      traceLog("GetPacakgeStatus","Package has not active intercepts, status == Cleared");
    }
    else if ( state.getPositiveSort() == false && state.getInterceptedFlag().equals("") ) {
      state.getScan().setReturnMessage("Cleared");
// does not exist, need to add IM      state.getScan().setErrorNumber(Messages.IM_NOT_INTERCEPTED);
      traceLog("GetPacakgeStatus","Package has NO intercepts, status == NOT_INTERCEPTED");
    }
    else if ( state.getScan().getErrorNumber() == 0 ) {
     // nothing else matched and no messages so set it to something
     state.getScan().setErrorNumber(Messages.EM_START_OVER);
    }

    traceLog("GetPackageStatus",state);

    return state;

  }

 public static void main(String[] args){
     System.out.println("Business Action GetPackageStatus in main");

     System.out.println("Leaving Business Action main");
    }



}
