package cciij.businessActions;

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
 * @author Steven Hurd
 * @version 1.0
 */

public class VerifyAddressChange extends BusinessActionBase
{
  protected GetAPACLookupBean m_APACLookup = new GetAPACLookupBean();
  private static final String m_whatVersion = "@(#) $RCSfile: VerifyAddressChange.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected boolean m_failsTransaction = false;
  protected boolean m_useShipmentOid = true;

  public VerifyAddressChange() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();

    m_failsTransaction = readConfigVariableBool("VERIFY_ADDRESS_FAILS_TRANSACTION",false);
    m_useShipmentOid = readConfigVariableBool("VERIFY_ADDRESS_USE_SHIPMENT_OID",true);
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db) throws java.lang.Exception
  {
    traceLog("VerifyAddressChange","VerifyAddressChange doIt");
    traceLog("VerifyAddressChange",state);
    String locationCode = state.getScan().getLocationCode();
    com.fedex.cih.ejb.CCIILookup lookup = null;
    DeliveryAddressInfo deliveryAddressInfo = null;
    ShipmentInfo shipInfo = null;
    lookup = m_APACLookup.getLookup(locationCode);
    if (lookup == null)
    {
      String str = "Unable to get ACCS LookupBean";
      traceLog("VerifyAddressChange",str);
      throw new CCIILogException("EM_EXT_BEAN_FAIL",str);
    }

    try
    {
      traceLog("VerifyAddressChange","Tracking number: " + state.getScan().getAirbillNumber());
      if ( m_useShipmentOid )
      {
        traceLog("VerifyAddressChange","Using shipment oid");
        deliveryAddressInfo = lookup.getDeliveryAddressInfo(state.getScan().getShipmentOid(),'S',locationCode);
      }
      else
      {
        traceLog("VerifyAddressChange","Using piece oid");
        deliveryAddressInfo = lookup.getDeliveryAddressInfo(state.getScan().getHandlingUnitOid(),'P',locationCode);
      }
      traceLog("VerifyAddressChange","Delivery Info: " + deliveryAddressInfo);
      if (deliveryAddressInfo != null)
      {
        state.getScan().setDestLocationCode(deliveryAddressInfo.getLocationCode());
        traceLog("VerifyAddressChange","Location code (from deliveryAddressInfo): " + deliveryAddressInfo.getLocationCode());
        if ( ((deliveryAddressInfo.getContactName() != null) && (deliveryAddressInfo.getContactName().length() > 0))
          && ((deliveryAddressInfo.getContactCompany() != null) && (deliveryAddressInfo.getContactCompany().length() > 0)) )
        {
          state.getScan().setAddressChangeFlag(true);
          //put information into the print map here
          state.addPrintMapElement("ADDRESS_CHANGE_NAME",deliveryAddressInfo.getContactName());
          state.addPrintMapElement("ADDRESS_CHANGE_COMPANY",deliveryAddressInfo.getContactCompany());
          if ( deliveryAddressInfo.getContactAddress1() != null )
          {
            state.addPrintMapElement("ADDRESS_CHANGE_ADDRESS1",deliveryAddressInfo.getContactAddress1());
          }
          else
          {
            state.addPrintMapElement("ADDRESS_CHANGE_ADDRESS1","*null*");
          }
          if ( deliveryAddressInfo.getContactAddress2() != null )
          {
            state.addPrintMapElement("ADDRESS_CHANGE_ADDRESS2",deliveryAddressInfo.getContactAddress2());
          }
          else
          {
            state.addPrintMapElement("ADDRESS_CHANGE_ADDRESS2","*null*");
          }
          if ( deliveryAddressInfo.getComments() != null )
          {
            state.addPrintMapElement("ADDRESS_CHANGE_COMMENTS",deliveryAddressInfo.getComments());
          }
          else
          {
            state.addPrintMapElement("ADDRESS_CHANGE_COMMENTS","*null*");
          }

          traceLog("VerifyAddressChange","Print Map: " + state.m_printData.toString());
        }
      }
      m_APACLookup.cleanupAPACLookup(lookup);
    }
    catch (Exception e)
    {
      String str = "VerifyAddressChange: problem trying to verify address";
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
    traceLog("VerifyAddressChange","leaving VerifyAddressChange");
    traceLog("VerifyAddressChange",state);
    return state;
  }
}
