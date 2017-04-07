package cciij.businessActions;

/**
 * Title:         Get Routing
 * Description:   Stubb to be implimented in the future.
 * Copyright:     Copyright (c) 2001
 * Company:       FedEx Services
 * @author        Robert Fisher
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


public class GetRouting extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: GetRouting.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public GetRouting() throws Exception {
//    System.out.println("GetRouting Constructor");
        traceLog("GetRouting","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    // no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Intercept intercept = null;
    InterceptCodeDefinition interceptCodeDefinition = null;
    StagingArea stagingArea = null;

    traceLog("GetRouting","begining doIt()");



    traceLog("GetRouting",state);

  //  traceLog("GetRouting",state.getScan());

    traceLog("GetRouting","returning ...");

    return state;


  }

 public static void main(String[] args){
     System.out.println("Business Action GetRouting in main");

     System.out.println("Leaving Business Action main");
    }



}