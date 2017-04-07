package cciij.businessActions;

import java.text.SimpleDateFormat;
import cciij.cciidata.CCIIState;
import cciij.cciidatabase.DatabaseBean;
import cciij.util.CCIILogException;
import com.fedex.cih.ejb.CCIILookup;
import com.fedex.cih.ejb.CCIILookupHome;
import com.fedex.cih.vo.DeliveryAddressInfo;
import com.fedex.cih.vo.ShipmentInfo;
import cciij.util.GetAPACLookupBean;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

public class FindExternalShipmentInfoAPAC extends BusinessActionBase
{
  protected GetAPACLookupBean m_APACLookup = new GetAPACLookupBean();
  private static final String m_whatVersion = "@(#) $RCSfile: FindExternalShipmentInfoAPAC.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected boolean m_failsTransaction = false;

  public FindExternalShipmentInfoAPAC() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();

    m_failsTransaction = readConfigVariableBool("FIND_EXT_SHIP_APAC_FAILS_TRANSACTION",false);
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db) throws java.lang.Exception
  {
    traceLog("FindExternalShipmentInfoAPAC","FindExternalShipmentInfoAPAC doIt");
    traceLog("FindExternalShipmentInfoAPAC",state);
    String locationCode = state.getScan().getLocationCode();
    com.fedex.cih.ejb.CCIILookup lookup = null;
    ShipmentInfo shipInfo = null;
    traceLog("FindExternalShipmentInfoAPAC","Getting the APAC lookup");
    lookup = m_APACLookup.getLookup(locationCode);
    if (lookup == null)
    {
      String str = "Unable to get ACCS LookupBean";
      traceLog("FindExternalShipmentInfoAPAC",str);
      throw new CCIILogException("EM_EXT_BEAN_FAIL",str);
    }

    try
    {
      traceLog("FindExternalShipmentInfoAPAC","Tracking number: " + state.getScan().getAirbillNumber());

      shipInfo = lookup.getShipmentInfo(state.getScan().getShipmentOid(),locationCode);
      traceLog("FindExternalShipmentInfoAPAC","Shipment Info: " + shipInfo);
      if (shipInfo != null)
      {
        // This is now based on info from download and decision is made in FindUploadStatus
        //if ( shipInfo.getClassification().equals("BSO") )
        //{
        //  state.getUploadStatus().setBSOFlag(true);
        //}
		state.getScan().setBrokerClassificationCode(shipInfo.getClassification());
		if(shipInfo.getClassification() != null) {
			if(shipInfo.getClassification().equals("DOC") ||shipInfo.getClassification().equals("EXP")){
				state.getScan().setReleaseCode("Y");
				state.getScan().setDeclarationCode("Y");
			}
		} else {
			state.getScan().setReleaseCode("Y");
			state.getScan().setCustomsReleasedFlag("Y");
			state.getScan().setDeclarationCode("Y");
		}


		state.getUploadStatus().setBondTransferFlag(shipInfo.getBondTransfered());
		state.getUploadStatus().setMPSIncompleteFlag(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String flightDate = "*null*";
        if ( shipInfo.getFlightDate() != null )
        {
			flightDate = dateFormat.format(shipInfo.getFlightDate());
			state.addPrintMapElement("ADDRESS_CHANGE_FLIGHT_DATE",flightDate);
        }
        else
        {
        	state.addPrintMapElement("ADDRESS_CHANGE_FLIGHT_DATE","");
        }
        if ( shipInfo.getFlightNumber() != null )
        {
			state.addPrintMapElement("ADDRESS_CHANGE_FLIGHT_NUMBER",shipInfo.getFlightNumber());
			state.addPrintMapElement("FLGHTDATA",shipInfo.getFlightNumber() + " " + flightDate);
        }
        else
        {
			state.addPrintMapElement("ADDRESS_CHANGE_FLIGHT_NUMBER","");
			state.addPrintMapElement("FLGHTDATA","");
        }
        if (shipInfo.getClearanceStatus() != null )
        {
        	state.getScan().setReleaseCode("Y");
        	state.addPrintMapElement("ClearanceStatus",shipInfo.getClearanceStatus());
        }
        else
        {
        	state.addPrintMapElement("ClearanceStatus","");
        }
        if (shipInfo.getMAWBNumber() != null )
        {
        	state.addPrintMapElement("MAWB",shipInfo.getMAWBNumber());
        }
        else
        {
        	state.addPrintMapElement("MAWB","*null*");
        }
      }
      m_APACLookup.cleanupAPACLookup(lookup);
    }
    catch (Exception e)
    {
      String str = "FindExternalShipmentInfoAPAC: problem trying to get shipment info";
      if (m_failsTransaction)
      {
        state.getScan().setErrorNumber(Messages.EM_EXT_BEAN_FAIL);
      }
      else
      {
        state.getScan().setErrorNumber(Messages.IM_EXT_BEAN_FAIL);
      }
      notifyLog(str,e);
    }
    traceLog("FindExternalShipmentInfoAPAC","leaving FindExternalShipmentInfoAPAC");
    traceLog("FindExternalShipmentInfoAPAC",state);

    return state;
  }
}
