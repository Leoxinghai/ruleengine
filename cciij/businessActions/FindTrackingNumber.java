package cciij.businessActions;

/**
 * Title:        Find Tracking Number
 * Description:  This business action will attempt to find a tracking number for
 *               a shipment.
 *
 *               First a check is made for duplicate DB HandlingUnit
 *               records. If duplicate HandlingUnits are found, error information
 *               is communicated to the caller.
 *
 *               Next, check for an overage condition. If no HandlingUnits records
 *               are found in the DB, the tracking number is an overage and the
 *               condition is returned to the caller.
 *
 *               When only one HandlingUnit exists, get the corrisponding shipment
 *               record from the DB. Check the to see if the shipment is an MPS
 *               shipment. Capture the MPS state information.
 *
 *               Finally, return the state information to the caller.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @throws       java.lang.Exception config item missing: DEFAULT_AGENCY_CODE.
 * @throws       java.lang.Exception config item missing: DEFAULT_INTERCEPT_CODE.
 * @throws       java.lang.Exception config item missing: OVERAGE_INTERCEPT_CODE.
 * @throws       java.lang.Exception config item missing: OVERAGE_AGENCY_CODE.
 * @throws       java.lang.Exception config item missing: MPS_INTERCEPT_CODE.
 * @throws       java.lang.Exception config item missing: MPS_AGENCY_CODE.
 * @throws       java.lang.Exception config item missing: SITE_MPS_STAGING
 *
 * @throws       cciij.util.CCIILogException HandlingUnit fetch failed
 * @throws       cciij.util.CCIILogException Next HandlingUnit fetch failed
 * @throws       cciij.util.CCIILogException hipment fetch by oid failed
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *  FindHandlingUnit
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 10/26/2001    Ed McAleer   Add tags and complete description. Also change
 *                            constructor to throw exceptions to notifyLog and
 *                            to Rule Processor instead of traceLog.
 * 03/09/3004    Gary Rockwood Added TravelStatus information
 * 10/25/2004    Joey Cline   Added call to HandlingUnit isManifested to set
 *                            the IsPieceManifested flag in the state object.
 * 11/15/2004    Joey Cline   Include original exception when there is a 
 *                            problem with the getting the handling unit 
 *
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Vector;

public class FindTrackingNumber extends BusinessActionBase {

    private static final String m_whatVersion = "@(#) $RCSfile: FindTrackingNumber.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    private String m_defaultAgencyCode = null;
    private String m_defaultInterceptCode = null;
    private String m_overageInterceptCode = null;
    private String m_overageAgencyCode = null;
    private String m_mpsInterceptCode = null;
    private String m_mpsAgencyCode = null;
    private String m_mpsOverageInterceptCode = null;
    private String m_mpsOverageAgencyCode = null;
    private String m_siteMPSStaging = null;
    private Vector m_manifestActiveHandlingUnit = new Vector();
    private String m_errorMessage = null;
    private String m_defaultFormType = null;
    private String m_defaultMPSFormType = null;

    public FindTrackingNumber() throws Exception {
    	traceLog("FindTrackingNumber","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
	m_defaultAgencyCode = readConfigVariableString("DEFAULT_AGENCY_CODE").toUpperCase();
	m_defaultInterceptCode = readConfigVariableString("DEFAULT_INTERCEPT_CODE").toUpperCase();
	m_overageInterceptCode = readConfigVariableString("OVERAGE_INTERCEPT_CODE").toUpperCase();
	m_overageAgencyCode = readConfigVariableString("OVERAGE_AGENCY_CODE").toUpperCase();
	m_mpsOverageInterceptCode = readConfigVariableString("MPSOVERAGE_INTERCEPT_CODE");
	m_mpsOverageAgencyCode = readConfigVariableString("MPSOVERAGE_AGENCY_CODE");
	m_mpsInterceptCode = readConfigVariableString("MPS_INTERCEPT_CODE").toUpperCase();
	m_mpsAgencyCode = readConfigVariableString("MPS_AGENCY_CODE").toUpperCase();
	m_siteMPSStaging = readConfigVariableString("SITE_MPS_STAGING").toUpperCase();
    m_defaultFormType = readConfigVariableString("DEFAULT_FORM_TYPE", "0400");
    m_defaultMPSFormType = readConfigVariableString("DEFAULT_MPS_FORM_TYPE", "0440");
    }


    /**
     * Method:       FindTrackingNumber.doIt()
     * Description:  Fetch a HandlingUnit from the DB using the AWB number attribute
     *               of the state object. Check the HandlingUnit returned from the
     *               DB fetch, if the HandlingUnit is null throw an exception and return
     *               state to the caller.
     *
     *               Check for mutiple HandlingUnit records. Process each HandlingUnit
     *               record checking for a pieceStatusCode of "A". For those HandlingUnit
     *               records that have a pieceStatusCode of "A", add the HandlingUnit to
     *               the manifestActiveHandlingUnit Vector.
     *
     *               Examine the manifestActiveHandlingUnit Vector for duplicate records
     *               (more than one entry or no entries). If duplicate HandlingUnits are
     *               found, update the state object error message and duplicate attributes.
     *               Otherwise, retrieve the HandlingUnit from the Vector and clear the Vector.
     *
     *               Determine if the HandlingUnit is an overage by evaluating both the
     *               OverageReasonCode and the PieceStatusCode. For intercept overages,
     *               return the state object to the caller.
     *
     *               Get the shipment record from the DB using the HandlingUnit shipmentOidNumber
     *               attribute. Check to see if the shipment is an MPS shipment. If the HandlingUnit
     *               is a CRN set the state object MPSFlag attribute to "CRN". If the HandlingUnit
     *               is a master, set the state object MPSFlag attribute to "MASTER".
     *
     *               Inspect the site configuration for MPS staging and update the state
     *               object with the appropriate information.
     *
     *               Finally, return the state object to the caller.
     *
     * @exception    java.lang.Exception when retrieving HandlingUnit from the DB.
     * @throws       java.lang.Exception after setting the error number in the state object.
     *
     * @param        state - CCIIState object to be updated.
     * @param        dbConnection - DatabaseBean connection object.
     *
     * @return       cciij.cciidata.CCIIState updated state object.
     */

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

	HandlingUnit handlingUnit = null;

	traceLog("FindTrackingNumber",state);

    // Set the Intransit Indicator to "N" as a default, this could be changed later
    state.setIntransitFlag("N");
 
    // Set a Default scan message equal to the Scan Type
//    state.getScan().setErrorNumber(Messages.IM_DISPLAY_RTN_MSG);
//    state.getScan().setReturnMessage(state.getScanTypeCode());

    // Clear the Service Code from any previous entry
    state.setServiceCode("");

	// set the LocationCode of the PrintData, other print info is collected
	//  during shipment processing
	state.m_printData.put("LocationCode",state.getScan().getLocationCode());

	try {
	    handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getAirbillNumber(),m_locationList.getLocationList());
	}
	catch (Exception ex) {
            
	    m_notify.triggerNotify("Failed to call db.fetchHandlingUnit(" + state.getScan().getAirbillNumber()
				   + ", " + m_locationList.getLocationList() + ")", ex);
	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed",ex);
	    throw cciiEx;
	}

	if ( handlingUnit == null ) {
	    traceLog("FindTrackingNumber","Got null from HU fetch");
	    state.setOverageFlag("Y");
	    //this check makes sure an overage wasn't scanned from the workstation first
	    if (state.getScan().getAirbillFormType().equals(""))
	    { //need form type to determine if this is a CRN
		state.getScan().setErrorNumber(Messages.EM_FORM_ID_REQD);
		return state;
	    }
	    /*
	    if ( isOverageCRN(state) && m_config.getValue(state.getScan().getInViewName().toUpperCase()
							  + "_ALLOW_MPS_OVERAGE_PROCESSING").equals("Y") ) {
		assignInterceptAndAgency(state, m_mpsOverageInterceptCode, m_mpsOverageAgencyCode);
	    }
	    else {
		assignInterceptAndAgency(state, m_overageInterceptCode, m_overageAgencyCode);
	    }
	    */
	    //  These System.out's do not compile... why are they check into CVS????? -mwr 08/19/2002
	    //       System.out.println("isOverageCRN " + isOverateCRN(state));
	    //       System.out.println("getHSWB " + state.getStac().getHAWB());
	    //       System.out.println("UnknownFlag " + state.getScan().getHAWBUnknownFlag());

	    
	    if ( /*m_config.getValue(state.getScan().getInViewName().toUpperCase()
				   + "_ALLOW_MPS_OVERAGE_PROCESSING").equals("Y")
		 && */isOverageCRN(state)
		 && state.getScan().getHAWB().equals("")
		 && state.getScan().getHAWBUnknownFlag().equals("T") == false  ) {
		state.getScan().setErrorNumber(Messages.EM_NEED_MSTR_AB);
	    }
	    else {
        if (state.getScan().getTravelStatus().equals("D"))
        {
            state.getScan().setErrorNumber(Messages.IM_DOMESTIC_PKG);
        }
        else
        {
            state.getScan().setErrorNumber(Messages.IM_OVERAGE);
        }
		//        assignInterceptAndAgency(state, m_overageInterceptCode, m_overageAgencyCode);
	    }
	    	    
	    return state;
	}

	// need to check the record count and manifest status
	traceLog("FindTrackingNumber","Record Count == " + dbConnection.getHandlingUnitRecordCount());

	if ( dbConnection.getHandlingUnitRecordCount() > 1 ) {
	    // more than one record exists, see how many have a manifest status == A
	    //   Also eliminate any record that is not manifested to this location ie:  nullCoreClearance == true
	    // put the active records in a vector
	    while ( handlingUnit != null ) {
		traceLog("FindTrackingNumber","Manifest Status Code == /" + handlingUnit.getPieceStatusCode().toUpperCase() + "/");
		if (( handlingUnit.getPieceStatusCode().toUpperCase().trim().equals("A") )
		    && (handlingUnit.getNullCoreClearance() == false))
		{
		    m_manifestActiveHandlingUnit.add(handlingUnit);
		}
		try {
		    handlingUnit = dbConnection.fetchNextHandlingUnit();
		}
		catch (Exception ex) {
		    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
		    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Next HandlingUnit fetch failed");
		    throw cciiEx;
		}
	    }

	    // If there are no actives then its a dup
	    // If there is more than one active then its a dup
	    if ( m_manifestActiveHandlingUnit.isEmpty()
		 || m_manifestActiveHandlingUnit.size() > 1 ) {
		m_manifestActiveHandlingUnit.clear();
		if (state.getScan().getInputDevice().equals("JavaWS") ) {
		    state.getScan().setErrorNumber(Messages.EM_DUP_PIECE);
		}
		else {
		    state.getScan().setErrorNumber(Messages.IM_DUP);
		}
		state.setDuplicateFlag("Y");
		return state;
	    }
	    else {
		// theres only one manifest Active record so it must be the one
		handlingUnit = (HandlingUnit) m_manifestActiveHandlingUnit.get(0);
		m_manifestActiveHandlingUnit.clear();
	    }
	}

	//  The fetch returned a single record or a single active record
	//  if its not active then its an overage

	state.getScan().setHandlingUnitOid( handlingUnit.getHandlingUnitOidNumber() );
	state.getScan().setShipmentOid( handlingUnit.getShipmentOidNumber() );

    // Set the Travel Status from the pieceCoreClearance table 
    state.setTravelStatus( handlingUnit.getTravelStatus() );

	//  If the fetch returned a single record with the nullCoreClearance flag set, then this is a mis-sort
	if(handlingUnit.getNullCoreClearance())
	{
	    state.setOverageFlag(readConfigVariableString("MISORT_STATE_OVERAGE_FLAG","S"));
	}

	// Get the shipment data for this package

	Shipment shipment = getShipmentInformation(state,dbConnection,handlingUnit.getShipmentOidNumber());

	state = updateStateInformation(state,handlingUnit,shipment);

	return state;
    }

    protected CCIIState updateStateInformation(CCIIState state,HandlingUnit handlingUnit,Shipment shipment)
    {

	// Need to set the overage flag to M, to indicate to downstream
	//  business actions that all manifest data and route data might
	//  not exist ( ie piece_route_leg )
	// M also means the shell records already exist

	traceLog("FindTrackingNumber","Piece Status Code == /" + handlingUnit.getPieceStatusCode() + "/");   // gdr
        state.getScan().setDestLocationCode(handlingUnit.getDestLocationCd() );
	if ( handlingUnit.getOverageReasonCode().equals("M")
	     && handlingUnit.getPieceStatusCode().equals("") ) 
    {
      state.setOverageFlag("M");
      if (state.getTravelStatus().equals("D"))
      {
        state.getScan().setErrorNumber(Messages.IM_DOMESTIC_PKG);
      }
      else
      {
	    state.getScan().setErrorNumber(Messages.IM_OVERAGE);
      }
	}

	// Check for a Deleted Piece and we just scanned it, indicate that it as an overage                 // gdr
	// "DELETED" (NON 'Y') will indicates that the shell records already exist                          // gdr
	if ( handlingUnit.getPieceStatusCode().toUpperCase().trim().equals("D") ) {                      // gdr
	    state.setOverageFlag("DELETED");                                                               // gdr
	    state.getScan().setErrorNumber(Messages.IM_OVERAGE);                                           // gdr

	    // Set an overage intercept on this piece                                                           // gdr
	    if ( handlingUnit.isCRN() == true                                                              // gdr
		 && handlingUnit.getTrackingNumber().equals(shipment.getAWBNumber()) == false) {           // gdr
		assignInterceptAndAgency(state, m_mpsOverageInterceptCode, m_mpsOverageAgencyCode);         // gdr
	    }                                                                                              // gdr
	    else {                                                                                         // gdr
		assignInterceptAndAgency(state, m_overageInterceptCode, m_overageAgencyCode);               // gdr
	    }                                                                                              // gdr
	}                                                                                                // gdr

	state.setIsPieceManifested ( handlingUnit.isManifested() );

	// need to check and see if its an MPS, set flag in state accordingly
	// the MPS routing flag needs to be added to the state object
	//  for now just read it directly from the config file

	boolean mps = false;
	if ( handlingUnit.isCRN() == true
	     && handlingUnit.getTrackingNumber().equals(shipment.getAWBNumber()) == false ) {
	    mps = true;
	    state.setMPSFlag("CRN");
	}
	else {
	    if ( handlingUnit.isMPSMaster(shipment) == true ) {
		mps = true;
		state.setMPSFlag("MASTER");
	    }
	}

	if ( mps && ( m_siteMPSStaging.equals("ALWAYS")
		      || m_siteMPSStaging.equals("INTERCEPT") ) ) {
	    assignInterceptAndAgency(state, m_mpsInterceptCode, m_mpsAgencyCode);
	}

    // Set the Intransit Flag       
    if ((shipment.getIntransitCd() == null) ||
        (shipment.getIntransitCd().length() == 0) ||
        (shipment.getIntransitCd().equals("N")))
    {
        state.setIntransitFlag("N");
    }
    else
    {
        state.setIntransitFlag("Y");
        state.getScan().setErrorNumber(Messages.IM_INTRANSIT);
    }

    // Set the Service Code field
    state.setServiceCode(shipment.getServiceCode());

    // Insure that the Form Type has a valid entry
    if ((state.getScan().getAirbillFormType() == null) ||
        (state.getScan().getAirbillFormType().length() <= 0) ||
        (state.getScan().getAirbillFormType().trim().equals("0")))
    {
        // No Form Type value set, default to defaults as configured
        if (state.getMPSFlag().equals("CRN"))
        {
            state.getScan().setAirbillFormType(m_defaultMPSFormType);
        }
        else
        {
            state.getScan().setAirbillFormType(m_defaultFormType);
        }
    }

	return state;
    }

    /**
     * Method:       assignInterceptAndAgency()
     * Description:  Check for empty string in both the interceptCode and
     *               agencyCode. If both contain the empty string set the
     *               state object interceptCode and agencyCode to the
     *               appropriate argument in the argument list.
     *
     * @param        state - CCIIState object to be updated.
     * @param        interceptCode - intercept code.
     * @param        agencyCode - agency code.
     *
     * @return       void
     */

    protected void assignInterceptAndAgency(CCIIState state,
					    String interceptCode,
					    String agencyCode) {
	// if the agency and intercepts codes have been
	//   already set then don't over write them

	if ( state.getScan().getInterceptCode().equals("")
	     && state.getScan().getAgencyCode().equals("") ) {
	    state.getScan().setInterceptCode(interceptCode);
	    state.getScan().setAgencyCode(agencyCode);
	}

    }

    /**
     * Method:       getShipmentInformation()
     * Description:  Fetch the shipment from the database using the shipmentOidNumber.
     *               Check for a null shipment object and throw an exception if the
     *               object is null. Set the HAWB attribute of the state object with
     *               the value of the AWB number attribute of the shipment object.
     *               Return the shipment object to the caller.
     *
     * @exception    java.lang.Exception when trying to fetch a Shipment from DB.
     * @throws       java.lang.Exception after setting the error number in the state object.
     *
     * @param        s - CCIIState object to be updated.
     * @param        db - DatabaseBean
     * @param        shipmentOidNumber - Shipment OID Number
     *
     * @return       cciij.cciidata.Shipment shipment fetched from the database
     */

    protected Shipment getShipmentInformation(CCIIState s,
					      DatabaseBean db,
					      int shipmentOidNumber) throws Exception {

	Shipment shipment = null;

	try {
	    shipment = db.fetchShipment(shipmentOidNumber);
	}
	catch (Exception ex) {
	    s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment fetch failed");
	    throw cciiEx;
	}

	if ( shipment == null ) {
	    s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
							   "Shipment fetch by oid failed, oid == " + shipmentOidNumber);
	    throw cciiEx;
	}

	// get the hawb for this piece
	s.getScan().setHAWB(shipment.getAWBNumber());
    s.getScan().setHAWBFormType(shipment.getFormTypeCode());
	// get the customs released indicator
	s.getScan().setCustomsReleasedFlag(shipment.getCustomsReleaseFlag());
	s.getScan().setDeclarationCode(shipment.getDeclaredFlag());
	// add items to the printData map for label purposes
	s.m_printData.put("PieceQuantity",new Integer(shipment.getPieceQuanity()).toString());
	s.m_printData.put("BrokerEntryNumber",shipment.getBrokerEntryNumber());
	s.m_printData.put("ServiceCode",shipment.getServiceCode());
	//   s.m_printData.put("LocationCode",m_config.getValue(m_routeMaintDestLocCode));

	return shipment;

    }

    private boolean isOverageCRN(CCIIState s) {

	HandlingUnit hu = new HandlingUnit(0,
					   s.getScan().getAirbillNumber(),
					   s.getScan().getAirbillFormType(),
					   0,
					   "",
					   0.0f,
					   "",
					   0.0,
					   "",
					   s.getScan().getAirbillType(),
					   "",
					   "",
					   "");


	return  hu.isCRN();

    }

    public static void main(String[] args){
	System.out.println("FindTrackingNumber in main");

	DatabaseBean db = new DatabaseBean();

	db.connect();
	HandlingUnit hu = null ;

	try {
	    hu = db.fetchHandlingUnit("805510148006");
	}
	catch (Exception ex) {
	    System.out.println("Caught an Exception during fetch");
	    ex.printStackTrace();
	}

	if ( hu != null ) {
	    System.out.println(hu.toString());
	    System.out.println("AirbillTypeCode == " + hu.getAirbillTypeCode() + ", len == " + hu.getAirbillTypeCode().length());
	    System.out.println("IsCRN == " + hu.isCRN());
	}
	else {
	    System.out.println("Didnt find the HU you wanted!!");
	}

	System.out.println("Leaving main"); 
  
    }

}
