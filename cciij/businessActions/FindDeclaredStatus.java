package cciij.businessActions;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Monica Marshall
 * @version 1.0
 */
import cciij.cciidata.CCIIState;
import cciij.cciidatabase.DatabaseBean;

public class FindDeclaredStatus  extends FindIntercept
{
   private static final String m_whatVersion =
   "@(#) $RCSfile: FindDeclaredStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

   private String m_notDeclaredAgencyCode = "";
   private String m_notDeclaredInterceptCode = "";

   public FindDeclaredStatus()
   throws Exception
   {
      traceLog("FindDeclaredStatus","In constructor");
   }

   protected void readSiteConfigVariables() throws Exception
   {
      super.readSiteConfigVariables();
      m_notDeclaredAgencyCode = readConfigVariableString("NOT_DECLARED_AGENCY_CODE");
      m_notDeclaredInterceptCode = readConfigVariableString("NOT_DECLARED_INTERCEPT_CODE");
   }

   public CCIIState doIt( CCIIState state, DatabaseBean dbConnection)
   throws Exception
   {
//       System.out.println("In FindDeclaredStatus.doIt() method!!!");

//        if ( state.getScan().getErrorNumber() == Messages.IM_OVERAGE )
//        {
//          return state;
//        }

       if(state.getOverageFlag().equals("Y"))
       {
	   return state;
       }

       String declaredStatus = state.getScan().getDeclarationCode();
       if ( !declaredStatus.equals("Y") )
       {
          traceLog("FindDeclaredStatus"," not declared: need a NOTDECLARED intercept");
          state.getScan().setReturnMessage("Not Declared");
          if ( state.getScan().getErrorNumber() != Messages.IM_OVERAGE &&
               state.getScan().getErrorNumber() != Messages.IM_MPS )
          {
              state.getScan().setErrorNumber( Messages.IM_NOT_DECLARED );
          }
          state.setInterceptedFlag("NOTDECLARED");
          state.getScan().setAgencyCode(m_notDeclaredAgencyCode);
          state.getScan().setInterceptCode(m_notDeclaredInterceptCode);
          state.getScan().setDeclarationCode( declaredStatus );
          getStageAreaForIntercept(state.getScan().getWarehouseCode(),
                                   state.getScan().getAgencyCode(),
                                   state.getScan().getInterceptCode(),
                                   state,
                                   dbConnection);
          getDiverterForStageArea(state, dbConnection);
      }

      return state;
   }
}
