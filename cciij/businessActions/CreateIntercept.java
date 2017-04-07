package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class CreateIntercept extends ModifyIntercept
{

  private static final String m_whatVersion = "@(#) $RCSfile: CreateIntercept.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

  String m_mpsStaging = null;
  String m_mpsInterceptCode = null;
  String m_stageAgencyOrIntercept = null;


  public CreateIntercept() throws Exception
  {

  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    readActivityCode("INTERCEPT_CREATED_ACTIVITY_CODE","INT_AS",false);
    readActivityCode("INTERCEPT_PIECE_CREATED_ACTIVITY_CODE","INT_AP",true);
    m_mpsStaging = readConfigVariableString("SITE_MPS_STAGING","INTERCEPT");
    m_mpsInterceptCode = readConfigVariableString("MPS_INTERCEPT_CODE","MPS");
    m_stageAgencyOrIntercept = readConfigVariableString("SITE_STAGE_AGENCY_OR_INTERCEPT").toUpperCase();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    InterceptCodeDefinition interceptDef = null;
    Intercept intercept = null;
    boolean activeInterceptDef = false;
    boolean isExceptionActivity = true;

    traceLog("CreateIntercept","Begining doIt()");

     //there are several potential 'do nothing' cases if it is the mps intercept
     if ( state.getScan().getInterceptCode().equals(m_mpsInterceptCode) )
     {
        if ( checkForMPSdoNothingCases(state,dbConnection) )
        {
           traceLog("CreateIntercept","Found a MPS do nothing case");
           return state;
        }
     }

//  First check to see if the Intercept Definition is still active, if its not
//   don't create the intercept
     interceptDef = verifyInterceptDef(state,dbConnection);

     if (interceptDef != null && interceptDef.getRecordActiveFlag().equalsIgnoreCase(INTERCEPT_DEF_ACTIVE))
     {
        activeInterceptDef = true;
     }

// check to see it the agency/intercpet/shipment combo already exists, and is active
//   if it does return
     intercept = getActiveIntercept(state,dbConnection);

     // if you got a result then an active intercept exists for
//   this agency/code/shipment combo, time to leave , no action required
    if ( intercept != null )
    {
      if (state.getRecuringInterceptFlag() == false
         && intercept.getFromRecurringCriteriaFlag().equalsIgnoreCase(RECURING_CRITERIA_YES_STRING))
      {
        traceLog("CreateIntercept","Agency/Intercept/Shipment combo already exists, but with different Recur flag");
        intercept.setFromRecurringCriteriaFlag(RECURING_CRITERIA_NO_STRING);
        updateModifyIntercept(state,dbConnection,intercept);
        state = addClearanceActivity(state,intercept,isExceptionActivity);
      }
      else
      {
        traceLog("CreateIntercept","Agency/Intercept/Shipment combo already exists, doing nothing");
      }
      return state;
    }
    intercept = getRemovedIntercept(state,dbConnection);
    if (intercept == null)
    {
      intercept = getSatisfiedIntercept(state,dbConnection);
      if (intercept != null)
      {
         traceLog("CreateIntercept","found an already satisified intercept");
      }
    }
    else
    {
      traceLog("CreateIntercept","found an already removed intercept");
    }
    if (intercept != null)
    {
      if (activeInterceptDef)
      {
        intercept.setActiveFlag(INTERCEPT_ACTIVE);
        updateModifyIntercept(state,dbConnection,intercept);
        state = addClearanceActivity(state,intercept,isExceptionActivity);
        return state;
      }
      else
      {
        state.getScan().setErrorNumber(Messages.EM_INTERCPT_ERROR);
        return state;
      }
    }

    if (!activeInterceptDef)
    {
       state.getScan().setErrorNumber(Messages.EM_INTERCPT_ERROR);
       return state;
    }
    traceLog("CreateIntercept","Create the intercept object");
    intercept = createAndSaveNewIntercept(state,dbConnection,INTERCEPT_ACTIVE);
    //add clearance activity
    state = addClearanceActivity(state,intercept,isExceptionActivity);
    state.addUploadKey(state.getScan().getLocationCode(), "INTERCEPT_DEF",
			  intercept.getInterceptCode(), "ADD");

    state.setInterceptedFlag("Y");


// Don't change the error Message to IM_INTERCEPTED if an Overage or MPS
    if ( state.getScan().getErrorNumber() != Messages.IM_OVERAGE &&
         state.getScan().getErrorNumber() != Messages.IM_MPS )
    {
//    get the stage area //always create problem for CCII disable by xinghai.

        /*
      getStageAreaForIntercept(state.getScan().getWarehouseCode(),
                            intercept.getAgencyCode(),
                             intercept.getInterceptCode(),
                             state,
                             dbConnection);
      */
      state.getScan().setReturnMessage("  " + state.getStagingArea() + " INTRCPT ");
      state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
//    state.getScan().setErrorNumber(Messages.IM_INTERCEPTED);
    }

    traceLog("CreateIntercept",state);
    traceLog("CreateIntercept","Returning...");


    return state;
  }

  protected void getStageAreaForIntercept(String warehouseCode,
                                          String agencyCode,
                                          String interceptCode,
                                          CCIIState state,
                                          DatabaseBean db) throws Exception {
//   fetch to get the stagingArea based on config settings
      if ( m_stageAgencyOrIntercept.equals("AGENCY") ) {
        try {
          state.setStagingArea( getAgencyStagingArea(warehouseCode, agencyCode, state, db) );
        }
        catch (Exception ex) {
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Failure trying to set staging area via agencyCd");
          throw cciiEx;
        }
      }
      else if ( m_stageAgencyOrIntercept.equals("INTERCEPT") ) {
        try {
          state.setStagingArea( getInterceptStagingArea(warehouseCode, interceptCode, state, db) );
        }
        catch (Exception ex)
        {
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                           "Failure trying to set staging area via interceptCd." +
                           "warehouseCode = [" + warehouseCode + "]" +
                           "interceptCode = [" + interceptCode + "]" +
                           "state = [" + state + "]" );
          throw cciiEx;
        }
      }
      else {
        state.getScan().setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_CONFIG_ERROR_NUMB",
                                                   "Unknown value for SITE_STAGE_AGENCY_OR_INTERCEPT");
        throw cciiEx;
      }
  }

  protected String getInterceptStagingArea(String warehouseCode,
                                        String interceptCode,
                                        CCIIState s,
                                        DatabaseBean db) throws Exception {
     InterceptCodeDefinition interceptCodeDefinition = null;

     try {
        interceptCodeDefinition = db.fetchInterceptCodeDef(interceptCode);
     }
     catch (Exception ex ) {
        s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Staging Area Intercept Code Definition fetch failed");
        throw cciiEx;
     }
     if (interceptCodeDefinition == null) {
       s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                   "Staging Area Intercept Code Definition not found in db: " + interceptCode);
       throw cciiEx;
     }


     //return interceptCodeDefinition.getStagingAreaCode();
     InterceptStagingArea isa = db.fetchInterceptStagingAreaByWhCdIntCd(warehouseCode, interceptCode);
     return isa.getStagingAreaCd();

  }

  protected String getAgencyStagingArea(String warehouseCd, String agencyCode,
                    CCIIState s, DatabaseBean db) throws Exception {
    Agency agency = null;

    try {
      agency = db.fetchAgency(agencyCode);
    }
    catch (Exception ex) {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Staging Area Agency fetch failed");
      throw cciiEx;
    }
    if (agency == null) {
      s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                   "Staging Area Agency Code (" + agencyCode + ") not found in db");
      throw cciiEx;
    }

    AgencyStagingArea asa = db.fetchAgencyStagingAreaByLocCdWhCdAgCd(warehouseCd, agencyCode);
    return asa.getStagingAreaCode();
    //return agency.getStagingAreaCode();

  }

  protected boolean checkForMPSdoNothingCases (CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    Intercept intercept = null;
    traceLog("CreateIntercept","Starting Check for do nothing MPS case");
    //  MPS intercepts are special case
   if ( !state.getScan().getInterceptCode().equals(m_mpsInterceptCode) )
   { //not even an MPS intercept, shouldn't have been here
      traceLog("CreateIntercept","Shouldn't be checking for a MPS do nothing... not an MPS");
     return false;
   }

    //  if MPS staging is not INTERCEPT or ALWAYS then return
    if ( m_mpsStaging.equals("INTERCEPT") == false
        && m_mpsStaging.equals("ALWAYS") == false  )
    {
      traceLog("CreateIntercept","MPS intercepting not enabled");
      return true;
    }

    // MPS intercepts should not be created if SITE_MPS_STAGING = INTERCEPT
    //  and the shipment is not intercepted

    if ( m_mpsStaging.equals("INTERCEPT" ) )
    {
      intercept = getAnyActiveIntercept(state,dbConnection);
      traceLog("CreateIntercept","Looking for Active Intercepts for " + state.getScan().getAirbillNumber() +  " shipOid: " + state.getScan().getShipmentOid());
      if (intercept != null)
      {
        traceLog("CreateIntercept","Intercept; "  + intercept.toString());
      }
      else
      {
        traceLog("CreateIntercept","Intercept: Not Found");
      }
      // If you did not get an intercept  and its got a customs release then don't
      //  create the MPS intercept, just return
       if ( intercept == null && state.getScan().getCustomsReleasedFlag().equals("Y") )
       {
         traceLog("CreateIntercept","CRNs shipment not intercepted, and customs released");
         return true;
       }
    }

    //  need to check for a active MPS intercept
    //   if it exists then don't create a new one


    intercept = getActiveIntercept(state,dbConnection);
    traceLog("CreateIntercept","Active MPS Intercept for " + state.getScan().getAirbillNumber() +  " shipOid: " + state.getScan().getShipmentOid());
    if (intercept != null)
    {
      // If you got a result then a active MPS intercept exists, dont create
      //  another intercept just return, not action required
      traceLog("CreateIntercept","active MPS intercept already exists");
      traceLog("CreateIntercept","Intercept; "  + intercept.toString());
      return true;
    }
    else
    {
      traceLog("CreateIntercept","Intercept: Not Found");
    }

    //  need to check for a satisfied MPS intercept
    //   if it exists then don't create a new one

    intercept = getSatisfiedIntercept(state,dbConnection);
    traceLog("CreateIntercept","Satisfied MPS Intercept for " + state.getScan().getAirbillNumber() +  " shipOid: " + state.getScan().getShipmentOid());
    if (intercept != null)
    {
      traceLog("CreateIntercept","Intercept; "  + intercept.toString());
    }
    else
    {
      traceLog("CreateIntercept","Intercept: Not Found");
    }
    // If you got a result then a satisfied MPS intercept exists, dont create
    //  another intercept just return, not action required
     if ( intercept != null )
     {
       traceLog("CreateIntercept","Cleared MPS intercept already exists");
       return true;
     }
     //if you got all the way to the end without returning...
     // you are NOT in an MPS do nothing case
     return false;
  }

  public static void main(String args[])
  {
      System.out.println("APACClearanceLabel.main()");

      try
      {
          CCIIState l_data = new CCIIState();

          RPBScan l_scan = new RPBScan();

          Date now = new Date();

          l_scan.setAirbillNumber("802049333852");
          l_scan.setShipmentOid(16517288);
          l_scan.setLocationCode("BKK");
          l_scan.setTransactionTimestamp(new Date(System.currentTimeMillis()));
          //	    l_scan.setHAWB("802049333863");
          l_scan.setAgencyCode("FX");
          l_scan.setInterceptCode("IN");
          l_scan.setUserLogon("bkkuat01");
          l_scan.setInViewName("RINVIEW");

          l_scan.setSysDateTime(now);
          l_data.setRuleSetName("CREATEINT1");

          //	    l_data.setLabelInterceptType("MPS STAGING");

          //	    l_data.m_printData.put("PieceQuantity","33");


          l_data.setScan(l_scan);

          System.out.println("Got the dummy object...");
          CreateIntercept l_create = new CreateIntercept();
          System.out.println("Got the OverageLabel Object...");

          DatabaseBean db = new DatabaseBean();

          db.connect();

          db.setLocationCode("BKK");
          l_create.readSiteConfigVariables();
	      l_create.doIt(l_data,db);
      }
      catch(Exception e)
      {
          System.err.println("Caught an exception..." + e);
          e.printStackTrace();
      }

      System.out.println("CreateIntercept.main()...end");

      return;
  }

}
