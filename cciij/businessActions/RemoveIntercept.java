package cciij.businessActions;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */
 import cciij.cciidata.*;
 import cciij.cciidatabase.*;
 import cciij.util.CCIILogException;

public class RemoveIntercept extends ModifyIntercept
{

  private static final String m_whatVersion = "@(#) $RCSfile: RemoveIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected String m_removeAllReadyRemovedCode = null;
  protected String m_removePieceAllReadyRemovedCode = null;

  public RemoveIntercept() throws Exception
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
    interceptDef = verifyInterceptDef(state,dbConnection);
    if (interceptDef != null && interceptDef.getRecordActiveFlag().equalsIgnoreCase(INTERCEPT_DEF_ACTIVE))
    {
      activeInterceptDef = true;
    }
    intercept = getActiveIntercept(state,dbConnection);
    if (intercept != null)
    {
      //an active intercept exist
      if (state.getRecuringInterceptFlag()
         && intercept.getFromRecurringCriteriaFlag().equalsIgnoreCase(
         RECURING_CRITERIA_NO_STRING) )
      {
        //the msg recuring is Y and the db is N then do nothing
        traceLog("RemoveIntercept"
                ,"Intercept has a recuring N and scan object has recuring 'Y', doing nothing"
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
      }
      else
      {
          //set active flag to 'N'
          intercept.setActiveFlag(INTERCEPT_REMOVED);
          intercept = updateModifyIntercept(state,dbConnection,intercept);
          state = addClearanceActivity(state,intercept,isExceptionActivity);
      }
    }
    else if ((intercept = getSatisfiedIntercept(state,dbConnection)) != null)
    {//a satisfied intercept exist
      //error deleting an already satisified Intercept
      state.getScan().setErrorNumber(Messages.EM_DEL_SAT_INT);
      traceLog("RemoveIntercept","deleting already satisfied Intercept"
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());

    }
    else if ((intercept = getRemovedIntercept(state,dbConnection)) != null)
    {// a removed intercept exist
        //removing an intercept that is already removed
        //add activity to show that this happened
        String activityCode = m_removeAllReadyRemovedCode;
        if (state.getPieceLevelIntercept())
           activityCode = m_removePieceAllReadyRemovedCode;
        state = addClearanceActivity(state,intercept,activityCode,isExceptionActivity);
        //nothing else to do
        traceLog("RemoveIntercept","Removing intercept that is already removed"
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
    }
    else if (activeInterceptDef)
    {//this intercept does not already exist in database
      if(state.getRecuringInterceptFlag())
      { //if the recurring flag is Y then do create with a notactive flag
        intercept = createAndSaveNewIntercept(state,dbConnection,INTERCEPT_REMOVED);
        //add clearance activity
        state = addClearanceActivity(state,intercept,isExceptionActivity);
        traceLog("RemoveIntercept","Removing intercept that does not exist, but recuring flag is set"
                  + state.getScan().getAirbillNumber() + " "
                  + intercept.getAgencyCode() + " "
                  + intercept.getInterceptCode());
      }
      else
      {//everything else is an error
        state.getScan().setErrorNumber(Messages.EM_NO_INT2DEL);
        traceLog("RemoveIntercept","Removing intercept that does not exist"
                  + state.getScan().getAirbillNumber() + " "
                  + state.getScan().getAgencyCode() + " "
                  + state.getScan().getInterceptCode());
      }
    } else//not active intercept
    {
        state.getScan().setErrorNumber(Messages.EM_INTERCPT_ERROR);
    }

    return state;
  }
}