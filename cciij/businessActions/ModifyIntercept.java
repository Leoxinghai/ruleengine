package cciij.businessActions;

/**
 * Title:        CCII Server Side GUI Development
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 * Modification History
 *   12/05/2005  Tom Knobeloch  Added edits for when timestamps should be checked.
 */

 //This class is a base class for CreateIntercept, SatisfyIntercpet, and RemoveIntercept
 //basic utility functions will be contained in this class but each child
 //class will need to implment its own doIt() method
 import cciij.cciidata.*;
 import cciij.cciidatabase.*;
 import cciij.util.*;
 import java.util.Date;

public abstract class ModifyIntercept extends BusinessActionBaseWithOidGeneration
{

  private static final String m_whatVersion = "@(#) $RCSfile: ModifyIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public final static String YES_FLAG = "Y";
  public final static String NO_FLAG = "N";
  public final static String INTERCEPT_DEF_ACTIVE = YES_FLAG;
  public final static String INTERCEPT_ACTIVE = YES_FLAG;
  public final static String INTERCEPT_REMOVED = NO_FLAG;
  public final static String INTERCEPT_SATISFIED = "C";
  public final static String RECURING_CRITERIA_YES_STRING = YES_FLAG;
  public final static String RECURING_CRITERIA_NO_STRING = NO_FLAG;
  public final static String CREATE_PROCESS_NAME = "CreateIntercept";
  public final static String MODIFY_INTERCEPT_PROCESS_NAME = "ModifyIntercept";

  protected String m_ShipmentActivityCode = "Must Set this in Child classes";
  protected String m_PieceActivityCode = "Must Set this in Child classes";
  protected String m_agencyErrorActivityCode = null;
  protected String m_oldTransactionActivityCode = null;


    public ModifyIntercept() throws Exception
    {
    }

    public ModifyIntercept(String group) throws Exception
    {
        super(group);
    }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_agencyErrorActivityCode =  readConfigVariableString("INTERCEPT_AGENCY_ERROR_ACTIVITY_CODE","INT_ER");
    m_oldTransactionActivityCode =  readConfigVariableString("INTERCEPT_TRANS_OLD_ACTIVITY_CODE","INTOO");
  }

  protected void readActivityCode (String configName, String defaultValue, boolean isPieceLevel) throws Exception
  {
    if (isPieceLevel)
       m_PieceActivityCode = readConfigVariableString(configName,defaultValue);
    else
      m_ShipmentActivityCode = readConfigVariableString(configName,defaultValue);
  }

  protected InterceptCodeDefinition verifyInterceptDef(CCIIState state
                                    , DatabaseBean dbConnection)
                                    throws CCIILogException
  {
    //the database tables do not Differentiate between defs for piece or shipment
    //level.  All intercept defs are valid for both piece and shipment.
    //this method throws an exception if it can't find an intercept def
    boolean isExceptionActivity = true;
    InterceptCodeDefinition interceptDef = null;
    try
    {
      m_notify.trace("Attempting to call fetchInterceptCodeDef(" + state.getScan().getInterceptCode() + "); with loc of:  " + dbConnection.getLocationCode());
      interceptDef = dbConnection.fetchInterceptCodeDef(state.getScan().getInterceptCode());
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Intercept Code Definition fetch failed");
      notifyLog("Intercept Code Definition fetch failed",ex);
      throw cciiEx;
    }

    if ( interceptDef == null )
    {
      // something is wrong, the lookup failed to find anything
      //state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.getScan().setErrorNumber(Messages.IM_INVALID_INT);
      //add a clearance activty that says that the agency or intercept is marked as nonacitve or not found
      state = addClearanceActivity(state,m_agencyErrorActivityCode,isExceptionActivity);
      //CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","Intercept Definition not found for: " + state.getScan().getInterceptCode());
      //throw cciiEx;
      //let it return a null intercept def
    }
    else if ( interceptDef.getRecordActiveFlag().equals(INTERCEPT_ACTIVE) == false )
    {
      // check the record_active_flag, if its not active then throw an exception
       state.getScan().setErrorNumber(Messages.IM_INVALID_INT);
       //add a clearance activty that says that the agency or intercept is marked as nonacitve or not found
       state = addClearanceActivity(state,m_agencyErrorActivityCode,isExceptionActivity);
       //CCIILogException cciiEx = new CCIILogException("BA_INTERCEPT_ERROR_NUMB",
       //                        "Intercept Code is not active: " + state.getScan().getInterceptCode());
       //throw cciiEx;
       //let it return a interceptDef with a recordActiveFlag not equal to Y
    }
    else
    {
      traceLog("ModifyIntercept","Intercept def exists and is active");
    }

    return interceptDef;
  }

  protected Intercept getAnyActiveIntercept(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    Intercept intercept = null;
    try
    {
      if (state.getPieceLevelIntercept() == true)
      {
        //should replace this fetch with a dedicated fetch
        intercept = dbConnection.fetchInterceptByShipmentOrPieceOid(0,state.getScan().getHandlingUnitOid());
      }
      else
      {
        intercept = dbConnection.fetchInterceptWithActiveFlag(state.getScan().getShipmentOid());
      }
    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      throw ex;
    }
    return intercept;
  }

  protected Intercept getActiveIntercept(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    // check to see it the agency/intercpet/shipment combo already exists, and is active
    return getInterceptByActiveFlag(state,dbConnection,INTERCEPT_ACTIVE);
  }

  protected Intercept getSatisfiedIntercept(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    // check to see it the agency/intercpet/shipment combo already exists, and is satisfied
    return getInterceptByActiveFlag(state,dbConnection,INTERCEPT_SATISFIED);
  }

  protected Intercept getRemovedIntercept(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    // check to see it the agency/intercpet/shipment combo already exists, and is removed
    return getInterceptByActiveFlag(state,dbConnection,INTERCEPT_REMOVED);
  }

  protected Intercept getInterceptByActiveFlag(CCIIState state,
                                            DatabaseBean dbConnection,
                                            String activeFlag) throws Exception
  {
    Intercept intercept = null;
    try
    {
      if (state.getPieceLevelIntercept() == true)
      {
        intercept = dbConnection.fetchInterceptByPieceOid(state.getScan().getAgencyCode(),
                                                           state.getScan().getHandlingUnitOid(),
                                                           state.getScan().getInterceptCode(),
                                                           activeFlag);
      }
      else
      {
        intercept = dbConnection.fetchInterceptByShipmentOid(state.getScan().getAgencyCode(),
                                                           state.getScan().getShipmentOid(),
                                                           state.getScan().getInterceptCode(),
                                                           activeFlag);
      }

    }
    catch (Exception ex)
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      throw ex;
    }
    return intercept;
  }

  protected Intercept createAndSaveNewIntercept(CCIIState state, DatabaseBean dbConnection, String activeFlag)  throws Exception
  {
     int shipOid = 0;
     int pieceOid = 0;
     //only want EITHER piece oid OR Shipment Oid
     if (state.getPieceLevelIntercept() == true)
     {
      pieceOid = state.getScan().getHandlingUnitOid();
     }
     else
     {
      shipOid = state.getScan().getShipmentOid();
     }
     String recurString = state.getRecuringInterceptFlag()?"Y":"N";
     Intercept intercept =
         new Intercept(0,                                           // InterceptOid
                       shipOid,                                     // SHipmentOid
                       pieceOid,                                    // handlingUnitOid
                       state.getScan().getInterceptCode(),          // intercept code
                       activeFlag,                                  // active flag
                       new Date(state.getScan().getSysDateTime()),  // createDate
                       state.getScan().getUserLogon(),              // user name
                       CREATE_PROCESS_NAME,                         // process name
                       new Date(state.getScan().getSysDateTime()),  // update date
                       "",                                          // update user
                       "",                                          // update process name
                       0,                                           // staging area priority number
                       state.getScan().getTransactionTimestamp(),   // transaction date
                       state.getScan().getAgencyCode(),             // agency code
                       recurString);                                // recurring intercept flag


    intercept.setInterceptOidNumber(getOid(OidFactoryTypes.INTERCEPT));
    try
    {
      dbConnection.saveIntercept(intercept);
    }
    catch (Exception ex )
    {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Save Intercept failed");
       notifyLog("Save Intercept failed",ex);
       throw cciiEx;
    }
    traceLog("ModifyIntercept","new Intercept created and saved");
    return intercept;
  }

  protected Intercept updateModifyIntercept(CCIIState state, DatabaseBean dbConnection,
                                                     Intercept intercept)
                                                     throws CCIILogException
  {
    intercept.setDateUpdated(new Date(state.getScan().getSysDateTime()));
    intercept.setEmployeeNumberForUpdate(state.getScan().getUserLogon());
    intercept.setProcessNameUpdated(MODIFY_INTERCEPT_PROCESS_NAME);
    
    // Only check transaction timestamps if the intercept db record has a timestamp
    // and if the incoming RecurringFlag logically matches the intercept db record
    if (   state.getScan().getTransactionTimestamp() != null
        && (   intercept.getFromRecurringCriteriaFlag().equals(state.getRecuringInterceptFlag()?"Y":"N")
            || (   intercept.getFromRecurringCriteriaFlag().equals(" ")
                && state.getRecuringInterceptFlag() == false)))
    {
      if (   (intercept.getTransactionDate() == null)
          || (state.getScan().getTransactionTimestamp().after(intercept.getTransactionDate())))
      {
        intercept.setTransactionDate(state.getScan().getTransactionTimestamp());
      }
      else
      {
        // transaction too old
        state = addClearanceActivity(state,m_oldTransactionActivityCode,true);
        return intercept;
      }
    }
    try
    {
      dbConnection.updateIntercept(intercept);
    }
    catch (Exception ex )
    {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                 "Save Intercept failed");
       notifyLog("Save Intercept failed",ex);
       throw cciiEx;
    }
    return intercept;
  }

  //use this function to automatically determine the activity code
  protected CCIIState addClearanceActivity(CCIIState state, Intercept intercept, boolean isExceptionActivity)
  {
    String clearActCode = m_ShipmentActivityCode;
    if (intercept == null)
    {
      //error occured
      traceLog("ModifyIntercept","Intercept was null");
      state.getScan().setErrorNumber(Messages.EM_INTERCPT_ERROR);
      return state;
    }
    final String activeFlag = intercept.getActiveFlag();
    if (state.getPieceLevelIntercept())
    {
      clearActCode = m_PieceActivityCode;
    }
    state = addClearanceActivity(state,intercept,clearActCode,isExceptionActivity);
    return state;
  }

  //use this function if you want to explicitly state the activity code;
  protected CCIIState addClearanceActivity(CCIIState state, Intercept intercept, String activityCode, boolean isExceptionActivity)
  {
    //add clearance activity
    if (intercept == null)
    {
      state = addClearanceActivity(state,activityCode,isExceptionActivity);
    }
    else
    {
      if (isExceptionActivity)
      {
        state.addActivity(activityCode,intercept);
      }
      else
      {
        state.addExceptionActivity(activityCode,intercept);
      }
      traceLog("ModifyIntercept","adding clearance activity: "
                    + activityCode + " : "
                    + state.getScan().getAirbillNumber() + " : "
                    + intercept.getAgencyCode() + " : "
                    + intercept.getInterceptCode());
    }
    return state;
  }
  //this function only puts in the activity code
  protected CCIIState addClearanceActivity(CCIIState state, String activityCode, boolean isExceptionActivity)
  {
    if (isExceptionActivity)
    {
      state.addExceptionActivity(activityCode);
    }
    else
    {
      state.addActivity(activityCode);
    }

    traceLog("ModifyIntercept","adding clearance activity: "
                  + activityCode + " : "
                  + state.getScan().getAirbillNumber());
    return state;
  }
}
