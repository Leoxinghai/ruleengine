package cciij.businessActions;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */
 import cciij.cciidata.*;
 import cciij.cciidatabase.*;
 import cciij.util.CCIILogException;

public class SatisfyIntercept extends ModifyIntercept
{
  private static final String m_whatVersion = "@(#) $RCSfile: SatisfyIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected String m_satisfyAllReadySatisfiedCode = null;
  protected String m_satisfyPieceAllReadySatisfiedCode = null;
  protected String m_defaultInterceptCode = null;
  protected String m_defaultAgencyCode = null;
  protected String m_defaultOverageInterceptCode = null;
  protected String m_defaultOverageAgencyCode = null;
  protected String m_defaultMPSInterceptCode = null;
  protected String m_defaultMPSAgencyCode = null;

  public SatisfyIntercept() throws Exception
  {
  }

  public SatisfyIntercept(String group) throws Exception
  {
    super(group);
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    readActivityCode("INTERCEPT_SATISFIED_ACTIVITY_CODE","INT_SS",false);
    readActivityCode("INTERCEPT_PIECE_SATISFIED_ACTIVITY_CODE","INT_SP",true);
    m_satisfyAllReadySatisfiedCode =  readConfigVariableString("INTERCEPT_SAT_INT_ERROR_SHIPMENT_ACTIVITY_CODE","INTSSE");
    m_satisfyPieceAllReadySatisfiedCode =  readConfigVariableString("INTERCEPT_SAT_INT_ERROR_PIECE_ACTIVITY_CODE","INTSPE");
    m_defaultInterceptCode = readConfigVariableString("DEFAULT_INTERCEPT_CODE","CGE");
    m_defaultAgencyCode = readConfigVariableString("DEFAULT_AGENCY_CODE","CG");
    m_defaultOverageInterceptCode = readConfigVariableString("OVERAGE_INTERCEPT_CODE","OVG");
    m_defaultOverageAgencyCode = readConfigVariableString("OVERAGE_AGENCY_CODE","OV");
    m_defaultMPSInterceptCode = readConfigVariableString("MPS_INTERCEPT_CODE","MPS");
    m_defaultMPSAgencyCode = readConfigVariableString("MPS_AGENCY_CODE","M");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
     Intercept intercept = null;
     InterceptCodeDefinition interceptDef = null;
     boolean activeInterceptDef = false;
     boolean isExceptionActivity = true;
    //probably don't need to verify Intercept def to satisfy it
    interceptDef = verifyInterceptDef(state,dbConnection);
    if (interceptDef != null && interceptDef.getRecordActiveFlag().equalsIgnoreCase(INTERCEPT_DEF_ACTIVE))
    {
      activeInterceptDef = true;
    }

    intercept = getActiveIntercept(state,dbConnection);
    if (intercept != null)
    {
      //an active intercept exist
      state = satisfyIndividualIntercpet(state,dbConnection,intercept);
    }
    else if ((intercept = getSatisfiedIntercept(state,dbConnection)) != null)
    {//a satisfied intercept exist
      //add a clearance activity stating that it is already satisfied
          String activityCode = m_satisfyAllReadySatisfiedCode;
          if (state.getPieceLevelIntercept())
             activityCode = m_satisfyPieceAllReadySatisfiedCode;
          state = addClearanceActivity(state,intercept,activityCode,isExceptionActivity);
         //do nothing else becasue a satisfied intercept already exists
         traceLog("SatisfyIntercept","Satisfying Intercept already satisified: "
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());

    }
    else if ((intercept = getRemovedIntercept(state,dbConnection)) != null)
    {// a removed intercept exist
      //error satisfying intercept that is already removed
      state.getScan().setErrorNumber(Messages.EM_SAT_DEL_INT);
      traceLog("SatisfyIntercept","satisfying a removed intercept: "
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
    }
    else
    {
      //this intercept does not already exist in database
      if (!activeInterceptDef)
      {
        state.getScan().setErrorNumber(Messages.IM_INVALID_INT);
        return state;
      }
      //figuire out what the default intercept is
      String defaultIntercept = m_defaultInterceptCode;
      String defaultAgency = m_defaultAgencyCode;
      if (state.getMPSFlag().equalsIgnoreCase(YES_FLAG))
      {
        defaultIntercept = m_defaultMPSInterceptCode;
        defaultAgency = m_defaultMPSAgencyCode;
      }
      else if (state.getOverageFlag().equalsIgnoreCase(YES_FLAG))
      {
        defaultIntercept = m_defaultOverageInterceptCode;
        defaultAgency = m_defaultOverageAgencyCode;
      }
      //if the intercept code is the default then create a satisfied intercept
      if (state.getScan().getInterceptCode().equalsIgnoreCase(defaultIntercept)
         && state.getScan().getAgencyCode().equalsIgnoreCase(defaultAgency))
      {
        intercept = createAndSaveNewIntercept(state,dbConnection,INTERCEPT_SATISFIED);
        //add clearance activity
        state = addClearanceActivity(state,intercept,isExceptionActivity);
        traceLog("SatisfyIntercept","Intercept to satisfy didn't exists but the intercept code was default: "
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
      }
      //otherwise it is an error
      else
      {
        state.getScan().setErrorNumber(Messages.EM_NO_INT2SAT);
        traceLog("SatisfyIntercept","Intercept to satisfy didn't exists: "
                  + state.getScan().getAirbillNumber() + " "
                  + state.getScan().getAgencyCode() + " "
                  + state.getScan().getInterceptCode());
      }
    }
    return state;
  }

  protected CCIIState satisfyIndividualIntercpet(CCIIState state, DatabaseBean dbConnection, Intercept intercept) throws Exception
  {
      boolean isExceptionActivity = true;
      //mark the intercept as satisfied
      intercept.setActiveFlag(INTERCEPT_SATISFIED);
      intercept = updateModifyIntercept(state,dbConnection,intercept);
      traceLog("SatisfyIntercept","Satisfying intercept: "
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
      //add clearance activity
      state = addClearanceActivity(state,intercept,isExceptionActivity);
      return state;
  }
}
