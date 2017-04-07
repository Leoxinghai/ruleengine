package cciij.businessActions;

/**
 * Title:       Satisfy Area Intercepts
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Config item missing, INTERCEPT_SATISFIED_ACTIVITY_CODE not found
 * @throws      cciij.util.CCIILogException Staging Area fetch failed
 * @throws      cciij.util.CCIILogException Staging Area fetch by stageAreaCode returned null
 * @throws      cciij.util.CCIILogException Fetch Intercept by Intercept Definition Join failed
 * @throws      cciij.util.CCIILogException Fetch Intercept Join Agency Table failed
 * @throws      cciij.util.CCIILogException Config Error, SITE_STAGE_AGENCY_OR_INTERCEPT unknown value
 * @throws      cciij.util.CCIILogException Failure during fetch of Intercept
 * @throws      cciij.util.CCIILogException Failure during fetch of Agency
 * @throws      cciij.util.CCIILogException Agency not found in DB
 * @throws      cciij.util.CCIILogException Failure during fetch of Next Intercept
 * @throws      cciij.util.CCIILogException Failure Attempting to update Intercept
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer     Add tags and changed exceptions to CCIILogException.
 * 10/12/2004    Gary Rockwood  Modified so that Intercepts outside the staging area are satisfied individually
 *                              based on the indication of the agency.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.util.Vector;
import java.util.Iterator;


public class SatisfyStageAreaIntercepts extends SatisfyIntercept {

  private static final String m_whatVersion = "@(#) $RCSfile: SatisfyStageAreaIntercepts.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private String m_stageAgencyOrIntercept;
public SatisfyStageAreaIntercepts() throws Exception {
   traceLog("SatisfyStageAreaIntercepts","In constructor");
   //m_activityCode =  readConfigVariableString("INTERCEPT_SATISFIED_ACTIVITY_CODE");
  }

protected void readSiteConfigVariables() throws Exception
{
  super.readSiteConfigVariables();
  m_stageAgencyOrIntercept = readConfigVariableString("SITE_STAGE_AGENCY_OR_INTERCEPT");
  //no local variables to read in
}

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

    StagingArea stagingArea = null;

    traceLog("SatisfyStageAreaIntercepts","begining doIt()");
    traceLog("SatisfyStageAreaIntercepts",state);

//  this if block deals with some of the EM and IM conditions
//   from FindTrackingNumber

    if ( state.getOverageFlag().equals("Y") ) {
      state.getScan().setErrorNumber(Messages.EM_NOT_FOUND);
      return state;
    }
    else if (  state.getScan().getErrorNumber() == Messages.IM_MPS ) {
      state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
    }

//  Look up the Staging Area
    stagingArea = lookupStagingArea(state,dbConnection);

    // All intercepts can only be satisfied if all in this SA can be satisfied
    satisfyCurrentStageArea(dbConnection, state);

    if ( state.getScan().getErrorNumber() == Messages.EM_NOT_CLEARED )
    {
      traceLog("SatisfyStageAreaIntercepts","Could'nt satisfy in the current stage area.. returning");
      return state;
    }

    // Only check the other staging areas if the current staging area is all clear and
    // The stageOutside area Satisfy flag is set to 'Y'
    if ( stagingArea.getStageOutSatisfiesAllIntercepts().equals("Y") )
    {
      // Run thru remaining Intercepts and see if they can be satisifed individually
      satisfyAllStageAreas(dbConnection, state);
    }

    traceLog("SatisfyStageAreaIntercepts",state);

    traceLog("SatisfyStageAreaIntercepts","returning ...");

    return state;

  }


private void satisfyCurrentStageArea(DatabaseBean db, CCIIState s) throws Exception {

    Intercept intercept = null;
    InterceptCodeDefinition interceptCodeDefinition = null;
    boolean allAgenciesAllowSatisfy = true;
    Vector interceptVector = null;

// Look for active intercepts for this SA based on staging by AGENCY or INTERCEPT
  if ( m_stageAgencyOrIntercept.toUpperCase().equals("INTERCEPT") )
  {
    traceLog("SatisfyStageAreaIntercepts","lookup by intercept staging");
    try {
      intercept =  db.fetchInterceptByInterceptDefJoin (s.getScan().getShipmentOid(),
                                                        s.getScan().getHandlingUnitOid(),
                                                        s.getScan().getStagingAreaCode(),
                                                        s.getScan().getWarehouseCode());
    }
    catch (Exception ex)
    {
       s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                      "Fetch Intercept by Intercept Definition Join failed");
       throw cciiEx;
    }
  }
  else if ( m_stageAgencyOrIntercept.toUpperCase().equals("AGENCY") )
  {
    traceLog("SatisfyStageAreaIntercepts","lookup by agency staging");
    try
    {
      intercept =  db.fetchInterceptJoiningAgencyTable(s.getScan().getShipmentOid(),
                                                       s.getScan().getHandlingUnitOid(),
                                                       s.getScan().getStagingAreaCode(),
                                                       s.getScan().getWarehouseCode());
    }
    catch (Exception ex)
    {
       s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                      "Fetch Intercept Join Agency Table failed");
       throw cciiEx;
    }
  }
  else
  {
    CCIILogException cciiEx = new CCIILogException("BA_CONFIG_ERROR_NUMB",
    "Config Error, SITE_STAGE_AGENCY_OR_INTERCEPT unknown value == "
    +  m_stageAgencyOrIntercept);
    throw cciiEx;
  }

  if ( intercept == null )
  {
    // no work to do here so just return
    traceLog("SatisfyStageAreaIntercepts","no active intercepts, leaving");
    return;
  }
  else
  {
    // Put this entry in the vector of intercepts along with possible others
    traceLog("SatisfyStageAreaIntercepts","call loadInterceptVectory");
    interceptVector = loadInterceptVector(db, intercept, s);
  }

    // Go thru the Intercept vector and check if then can be satisified
    // In this case all must be able to be satisfied
    allAgenciesAllowSatisfy = verifyAllAgenciesAllowSatisfy(db,
                                                          interceptVector,
                                                          s,
                                                          false);     // 'false' means means not outside SA

//  If allAgenciesAllowSatisfy then proceed, else return with error message
    if ( allAgenciesAllowSatisfy == false )
    {
      // At lease 1 agency in this Staging Area does not allow the clear
      s.getScan().setErrorNumber(Messages.EM_NOT_CLEARED);
    }
    else
    {
      // if we got here then all intercepts in this Staging Area are allowed to be satisfied
      traceLog("SatisfyStageAreaIntercepts","going to try and clear'em");
      clearIntercepts(db, interceptVector, s);
    }
    return;
}


private void satisfyAllStageAreas(DatabaseBean db, CCIIState s) throws Exception {

  Intercept intercept = null;
  InterceptCodeDefinition interceptCodeDefinition = null;
  boolean allAgenciesAllowSatisfy = true;
  Vector interceptVector = null;

  try
  {
    intercept = db.fetchIntercept(s.getScan().getShipmentOid(), s.getScan().getHandlingUnitOid());
  }
  catch (Exception ex)
  {
    s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Failure during fetch of Intercept");
    throw cciiEx;
  }

  if ( intercept == null )
  {
    // no work to do here so just return
    traceLog("SatisfyStageAreaIntercepts","no active intercepts for other stage areas, leaving");
    return;
  }
  else
  {
    // Put the intercept into a intercept vector, others may also be added
    traceLog("SatisfyStageAreaIntercepts","call loadInterceptVector for other stage areas");
    interceptVector = loadInterceptVector(db, intercept, s);
  }

   // if the agency indicates that the intercept can be satisified, then do it
   allAgenciesAllowSatisfy = verifyAllAgenciesAllowSatisfy(db,
                                                          interceptVector,
                                                          s,
                                                          true);    // 'true' means ourside Staging Area

   // For agencies outside the Staging Area are satisified individually, if the
   // Agency entry indicates that they can be satisified.  This is done in the
   // verifyAllAgenciesAllowSatisfy when last argument is 'true'

   return;

}

private boolean verifyAllAgenciesAllowSatisfy(DatabaseBean db,
                                              Vector interceptVector,
                                              CCIIState s,
                                              boolean b_outsideStageArea ) throws Exception {
// step thru the fetched records and determine if ALL intercepting agencies allow
//   intercepts to be satisfied by the scan.
// If a single agency says no, do not continue the scan
  Intercept intercept = null;
  Agency agency = null;
  boolean   b_satisfiedFlag = true;

  // Assume all is good until there is a false
  b_satisfiedFlag = true;

  for ( Iterator it = interceptVector.iterator(); it.hasNext(); )
  {
    intercept = (Intercept) it.next();

    // fetch the agency for the intercept
    try
    {
      agency = db.fetchAgency(intercept.getAgencyCode());
    }
    catch (Exception ex)
    {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Failure during fetch of Agency");
      throw cciiEx;
    }

    if ( agency == null )
    {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                "Agency ( " + intercept.getAgencyCode() + " ), not found in DB");
      throw cciiEx;
    }

    if ( agency.getStageOutInterceptSatisfyFlag().equals("N") )
    {
      b_satisfiedFlag = false;

      // If the check is for agencies within the current staging area, there is not need to continue
      if (b_outsideStageArea == false)
      {
        return false;
      }
    }
    else if ( b_outsideStageArea == true )
    {
      // Satisfy this intercept only if outside the staging area
      s = satisfyIndividualIntercpet(s,db,intercept);
    }

  }

  return b_satisfiedFlag;

}

private StagingArea lookupStagingArea(CCIIState state, DatabaseBean dbConnection) throws CCIILogException
{
    StagingArea stagingArea;
    try
    {
      stagingArea = dbConnection.fetchStagingArea(state.getScan().getStagingAreaCode());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Staging Area fetch failed");
      throw cciiEx;
    }

    if (stagingArea == null ) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                      "Staging Area fetch by stageAreaCode returned null");
       throw cciiEx;

    }
    return stagingArea;
}


private Vector loadInterceptVector(DatabaseBean db,
                                   Intercept i,
                                   CCIIState s ) throws Exception {

    int cnt=1;
 Vector v = new Vector();

  while ( i != null  ) {
      if(m_config.getBoolean("RESTRICT_CUSTOMS_SCANNING_ACCESS",true)
         && (s.getScan().getStagingAreaCode().equals("CUST")
             || (!(i.getAgencyCode().equals("CU")))))
      {
          v.add(i);
      }
      else
      {
          String msg = "Ignoring Customs Intercept "
              + i.getInterceptCode() + ":" + i.getAgencyCode()
              + " when staging out of " + s.getScan().getStagingAreaCode()
              + " on AWB:  " + s.getScan().getAirbillNumber();

          System.out.println(msg);
          traceLog("SatisfyStageAreaIntercepts",msg);
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

private void clearIntercepts(DatabaseBean db, Vector v, CCIIState s)
              throws Exception
{
  Intercept intercept = null;

  for ( Iterator it = v.iterator(); it.hasNext(); )
  {
    intercept = (Intercept) it.next();
    s = satisfyIndividualIntercpet(s,db,intercept);
  }
}

 public static void main(String[] args)
 {
  System.out.println("Business Action SatisfyStageAreaIntercepts in main");
  System.out.println("Leaving Business Action main");
 }
}
