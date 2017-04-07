package cciij.businessActions;

/**
 * Title:       Satisfy Agency Intercepts
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of active Intercept
 * @throws      cciij.util.CCIILogException Failure during fetch of Next Intercept
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.util.Vector;
import java.util.Iterator;


public class SatisfyAgencyIntercepts extends SatisfyIntercept {

  private static final String m_whatVersion = "@(#) $RCSfile: SatisfyAgencyIntercepts.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public SatisfyAgencyIntercepts() throws Exception {
    traceLog("SatisfyAgencyIntercepts","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    Intercept intercept = null;
    Vector interceptVector = null;

    traceLog("SatisfyAgencyIntercepts","begining doIt()");
    traceLog("SatisfyAgencyIntercepts",state);

    // Look for active intercepts for this AGENCY
    try {
      intercept =  dbConnection.fetchInterceptWithActiveFlag (state.getScan().getShipmentOid());
    }
    catch (Exception ex) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                      "Fetch Intercept With Active Flag failed");
       throw cciiEx;
    }

    if ( intercept == null ) {
      // no work to do here so just return
      traceLog("SatisfyAgencyIntercepts","no active intercepts, leaving");
    }
    else {
      traceLog("SatisfyAgencyIntercepts","call loadInterceptVector");
      interceptVector = loadInterceptVector(dbConnection, intercept, state);

      // clear em
      traceLog("SatisfyAgencyIntercepts","going to try and clear'em");
      clearIntercepts(dbConnection, interceptVector, state);
    }

    traceLog("SatisfyAgencyIntercepts",state);
    traceLog("SatisfyAgencyIntercepts","returning ...");

    return state;
  }

  private Vector loadInterceptVector(DatabaseBean db,
                                     Intercept i,
                                     CCIIState s ) throws Exception {

    int cnt=1;
    Vector v = new Vector();

    while ( i != null  ) {
      if (i.getAgencyCode().equals(s.getScan().getAgencyCode())) {
        v.add(i);
      }

      try {
        i = db.fetchNextIntercept();
      }
      catch (Exception ex) {
        s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                       "Failure during fetch of Next Intercept");
        throw cciiEx;
      }
    }
    return v;
  }

  private void clearIntercepts(DatabaseBean db, Vector v, CCIIState s) throws Exception {

    Intercept intercept = null;

    for ( Iterator it = v.iterator(); it.hasNext(); )
    {
      intercept = (Intercept) it.next();
      s = satisfyIndividualIntercpet(s,db,intercept);
    }
  }

 public static void main(String[] args)
 {
  System.out.println("Business Action SatisfyAgencyIntercepts in main");
  System.out.println("Leaving Business Action main");
 }
}
