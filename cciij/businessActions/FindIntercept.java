package cciij.businessActions;

/**
 * Title:       Find Intercept
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throws      java.lang.Exception Config item missing, SITE_STAGE_AGENCY_OR_INTERCEPT not found
 * @throws      java.lang.Exception Config item missing, SITE_MPS_STAGING not found
 *
 * @throws      cciij.util.CCIILogException FindIntercept called with out valid shipment or hu oid
 * @throws      cciij.util.CCIILogException Fetch of intercept using shipmentOid or PieceOid failed
 * @throws      cciij.util.CCIILogException Fetch of Intercept failed using shipmentOid and InterceptCd
 * @throws      cciij.util.CCIILogException Failure trying to set staging area via agencyCd
 * @throws      cciij.util.CCIILogException Failure trying to set staging area via interceptCd
 * @throws      cciij.util.CCIILogException Unknown value for SITE_STAGE_AGENCY_OR_INTERCEPT
 * @throws      cciij.util.CCIILogException Staging Area fetch failed
 * @throws      cciij.util.CCIILogException Staging Area Definition not found in db
 * @throws      cciij.util.CCIILogException Print Data Intercept Code Definition fetch failed
 * @throws      cciij.util.CCIILogException Print Data Intercept code def fetch returned null
 * @throws      cciij.util.CCIILogException Staging Area Intercept Code Definition fetch failed
 * @throws      cciij.util.CCIILogException Staging Area Intercept code def fetch returned null
 * @throws      cciij.util.CCIILogException Staging Area Agency fetch failed
 * @throws      cciij.util.CCIILogException Staging Area Agency Code not found in db
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *  ???
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer  Add CCIILogException error handling and reporting.
 * 04/26/2002    Ed McAleer  Change System.out.println to traceLog().
 * 11/11/2004    Joey Cline  Added check for IsManifested to make ensure that a
 *                           CRN that has a manifested master is not treated as
 *                           an overage.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;


public class FindIntercept extends BusinessActionBase {
  private static final String m_whatVersion = "@(#) $RCSfile: FindIntercept.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  String m_stageAgencyOrIntercept = null;
  String m_mpsStaging = null;
  String m_errorMessage = null;
  String m_mpsInterceptCode = "";

  private String[] mapText = new String[] {"1","2","3","4","5","6","7","8","9","10"};

  public FindIntercept() throws Exception {
    traceLog("FindIntercept","In constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    m_stageAgencyOrIntercept = readConfigVariableString("SITE_STAGE_AGENCY_OR_INTERCEPT").toUpperCase();
    m_mpsStaging = readConfigVariableString("SITE_MPS_STAGING").toUpperCase();
    m_mpsInterceptCode = readConfigVariableString("MPS_INTERCEPT_CODE");
  }

// FindIntercept looks for active intercepts,
// If an intercept exists the associated routing data is collected
// the fetch for active assumes intercepts are returned based on
// agency/intercept priority numbers

public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
  Intercept intercept = null;
  Vector interceptVector = null;

  traceLog("FindIntercept","begining doIt");
  traceLog("FindIntercept",state);

  if ( state.getScan().getShipmentOid() == 0
       && state.getScan().getHandlingUnitOid() == 0 ) {
    CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                   "FindIntercept called with out valid shipment or hu oid");
    throw cciiEx;
  }

   try {
     intercept = dbConnection.fetchInterceptByShipmentOrPieceOid(state.getScan().getShipmentOid(),
                                                                 state.getScan().getHandlingUnitOid());
   }
   catch (Exception ex) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Fetch of intercept using shipmentOid or PieceOid failed");
       throw cciiEx;
   }

   if ( intercept == null ) {
        // the fetch for actives found none
        state.setInterceptedFlag("C");
        if (state.getScan().getErrorNumber() != Messages.IM_INTRANSIT)
        {
            state.getScan().setErrorNumber(Messages.IM_CLEARED);
        }
        return state;
   }

	if (state.getScan().getAirbillType().equals("G") || state.getScan().getAirbillType().equals("6") ||
			state.getScan().getAirbillFormType().equals("0491") || state.getScan().getAirbillFormType().equals("491") ) {
		state.setMPSFlag("CRN");
	}

   traceLog("FindIntercept","Found an Intercept, collecting print & routing data");

   interceptVector = loadInterceptVector(intercept,dbConnection,state);

// now do MPS processing if required.....
    if ( state.getMPSFlag().equals("CRN")
         || state.getMPSFlag().equals("MASTER") ) {
      mpsIntercepts( dbConnection, state, interceptVector);
    }

    intercept = (Intercept) interceptVector.firstElement();

//  get the stage area and diverter codes
    getStageAreaForIntercept(state.getScan().getWarehouseCode(),
    			     intercept.getAgencyCode(),
                             intercept.getInterceptCode(),
                             state,
                             dbConnection);

    getDiverterForStageArea(state,dbConnection);

    state = getInterceptPrintData(interceptVector, dbConnection, state);

   if ( state.getScan().getErrorNumber() != Messages.IM_MPS
        && ( state.getScan().getErrorNumber() != Messages.IM_OVERAGE
	  || state.getIsManifested() == true ) ) {
       state.getScan().setReturnMessage("  " + state.getStagingArea() + " INTRCPT ");
       state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
   }


    traceLog("FindIntercept",state);

    if(!state.getScan().getInterceptCode().equals(""))
        intercept.setInterceptCode(state.getScan().getInterceptCode());

    if((intercept.getInterceptCode().equals("INS") || intercept.getInterceptCode().equals("FO")) && (state.getMPSFlag().equals("CRN"))) {
 	   state.setInterceptedFlag("N");
 	   state.getScan().setInterceptCode("");
    	} else {
 	   state.setInterceptedFlag("Y");
 	   state.getScan().setInterceptCode(intercept.getInterceptCode());
 	   state.getScan().setAgencyCode(intercept.getAgencyCode());
    	}

    return state;
}


private void mpsIntercepts(DatabaseBean db, CCIIState state, Vector interceptVector) throws Exception {
  Intercept intercept = null;
  Intercept activeIntercept = null;

  if (  m_mpsStaging.equals("ALWAYS") == false
        && m_mpsStaging.equals("INTERCEPT") == false  )  {
    return;
  }

//  look for active MPS intercepts

   try {
      intercept =  db.fetchInterceptWithShipOidAndInterceptCd(state.getScan().getShipmentOid(),
                                                              m_mpsInterceptCode );
      // the fetch found MPS intercepts, look for an active flag of 'Y'
      while ( intercept != null ) {
        if ( intercept.getActiveFlag().equals("Y") && activeIntercept == null ) {
          activeIntercept = intercept;
          traceLog("FindIntercept","Found active MPS intercept");
        }
        intercept = db.fetchNextIntercept();
      }
    }
    catch (Exception ex) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Fetch of Intercept failed using shipmentOid and InterceptCd");
       throw cciiEx;
    }

  if ( activeIntercept != null ) {
    // the fetch for actives found at least one, if the package
    // is a crn, so remove it from the vector and reinsert it at
    //  the top
    if ( state.getMPSFlag().equals("CRN") ) {
      interceptVector.remove(activeIntercept);
      interceptVector.add(0,activeIntercept);
    }
  }

}


protected Vector loadInterceptVector(Intercept i, DatabaseBean db, CCIIState state) throws Exception {

  Vector tempV = new Vector();

  while ( i != null ) {
   tempV.add(i);
    try {
      i = db.fetchNextIntercept();
    }
    catch (Exception ex) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Next Intercept fetch failed");
      throw cciiEx;
    }
  }

  return tempV;
}

protected void getStageAreaForIntercept(String warehouseCode,
					String agencyCode,
                                        String interceptCode,
                                        CCIIState state,
                                        DatabaseBean db) throws Exception {
// fetch to get the stagingArea based on config settings
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



protected void getDiverterForStageArea(CCIIState state,
                                       DatabaseBean db) throws Exception {
StagingArea stagingArea = null;
//  Get the diverter code with a staging area fetch
    try {
      stagingArea = db.fetchStagingArea(state.getStagingArea());
    }
    catch (Exception ex ) {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Staging Area fetch failed");
       throw cciiEx;
    }

    if (stagingArea == null) {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Staging Area Definition not found in db: " + state.getStagingArea());
      throw cciiEx;
    }

    state.setDiverterCode( stagingArea.getDiverterNumber() );
}


    protected CCIIState getRawInterceptPrintData(Vector interceptVector,
					    DatabaseBean db,
					    CCIIState state) throws Exception
    {
	Intercept intercept;

	// Loop thru the intercepts and build a map for label printing

	traceLog("FindIntercept","Begin getRawInterceptPrintData");

	int curIntercept=1;
	String interceptCodes = "";

	for (  Iterator i = interceptVector.iterator() ; i.hasNext(); )
	{
	    intercept = (Intercept) i.next();
	    traceLog("FindIntercept","iterating " + curIntercept);
	    traceLog("FindIntercept",intercept);



	    //	    state.m_printData.put("Agency" + mapText[agencyCount] + "Intercept" + mapText[interceptCount], currentIntercept);
        if((intercept.getInterceptCode().equals("INS") || intercept.getInterceptCode().equals("FO")) && (state.getMPSFlag().equals("CRN"))) {
            state.addPrintMapElement("PiorityIntercept" + curIntercept,"");
    	    curIntercept++;
        } else {
            state.addPrintMapElement("PiorityIntercept" + curIntercept,intercept.getInterceptCode());
	        interceptCodes +=intercept.getInterceptCode() +" ";
		    curIntercept++;
        }
	}

	state.getScan().setInterceptCode(interceptCodes.trim());
	return state;
    }


protected CCIIState getInterceptPrintData(Vector interceptVector,
                                     DatabaseBean db,
                                     CCIIState state) throws Exception {
// Loop thru the intercepts and build a map for label printing

    traceLog("FindIntercept","Begin getInterceptPrintData");

    String currentAgency = null;
    String currentIntercept = null;
    int agencyCount = 0;
    int interceptCount = 0;
    Intercept intercept = null;
    boolean firstIntercept = true;
    InterceptCodeDefinition interceptDef = null;

    // First we call the method that just gets the intercepts in order
    state = getRawInterceptPrintData(interceptVector,db,state);

    for (  Iterator i = interceptVector.iterator() ; i.hasNext(); ) {
      intercept = (Intercept) i.next();
      traceLog("FindIntercept","begin iterating " + agencyCount);
      traceLog("FindIntercept",intercept);

      if ( firstIntercept ) {
        try {
          interceptDef = db.fetchInterceptCodeDef(intercept.getInterceptCode());
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                   "Print Data Intercept Code Definition fetch failed");
          throw cciiEx;
        }

        if ( interceptDef == null ) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                   "Print DataIntercept code def fetch returned null");
          throw cciiEx;
        }

	//        state.m_printData.put("InterceptType",interceptDef.getInterceptLabelTextDescription());
	state.addPrintMapElement("InterceptType",interceptDef.getInterceptLabelTextDescription());
        firstIntercept = false;
      }

      while ( intercept != null && agencyCount < 10 ) {
           traceLog("FindIntercept","while #1");
           currentAgency = intercept.getAgencyCode();
	   //           state.m_printData.put("Agency" + mapText[agencyCount],intercept.getAgencyCode());
	   state.addPrintMapElement("Agency" + mapText[agencyCount],intercept.getAgencyCode());
           while ( intercept != null && currentAgency.equals(intercept.getAgencyCode()) && interceptCount < 4 ) {
             traceLog("FindIntercept","while #2");
             currentIntercept = intercept.getInterceptCode();
             if (intercept.getShipmentOidNumber() == 0 ) {
               currentIntercept = "*" + currentIntercept;
             }
	     //             state.m_printData.put("Agency" + mapText[agencyCount] + "Intercept" + mapText[interceptCount], currentIntercept);
	     state.addPrintMapElement("Agency" + mapText[agencyCount] + "Intercept" + mapText[interceptCount], currentIntercept);
             interceptCount++;
             if ( i.hasNext() ) {
               intercept = (Intercept) i.next();
             }
             else {
               intercept = null;
             }
           }
      agencyCount++;
      interceptCount = 0;
      }
    }
    return state;
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




 public static void main(String[] args){
     System.out.println("Business Action FindIntercept in main");

     System.out.println("Leaving Business Action main");
    }

}
