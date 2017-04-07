package cciij.businessActions;
/**
 * Title:       Find Upload Status
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Gary Rockwood
 * @version 1.0
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   03/04/2004  Tom Knobeloch  Added initialization for NotClearedFlag.
 *   03/10/2004  Gary Rockwood  Added the Travel Status flags (Domestic and International)
 *   11/04/2004  Gary Rockwood  Added the Cons Flags
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import mrsj.businessActions.*;

public class FindUploadStatus extends GetContextBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: FindUploadStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  private MessageToCaBrkr MTCB = null;

  public FindUploadStatus() throws Exception
  {
    traceLog("GetContext","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {

    if (state.getScan().getUserLogon().equals("112233"))
    {
      MTCB = new MessageToCaBrkr();

      System.out.println("Calling MessageToCanBrkr.LoadDummy from FindUploadStatus");
      MTCB.LoadDummy();
      System.out.println("Return reached in FindUploadStatus");
    }

    traceLog("FindUploadStatus", state);

    // Always Flag is always set to true
    state.getUploadStatus().setAlwaysFlag(true);

    // Cons Upload Flag
    if ((state.getScan().getConsId().length() > 0) &&
        (state.getAbScanned().equals(state.getScan().getAirbillNumber())))
    {
        state.getUploadStatus().setConsUploadFlag(true);
        state.getUploadStatus().setNoConsUploadFlag(false);
    }
    else
    {
        state.getUploadStatus().setConsUploadFlag(false);
        state.getUploadStatus().setNoConsUploadFlag(true);
    }

    if (state.getScan().getShipmentOid() != 0)
    {
        // there is a associated Shipment, read the record

        Shipment shipment = null;

        // The shipment record will need to be read
        try
        {
            traceLog("FindUploadStatus", "fetchShipment with Oid " + state.getScan().getShipmentOid());

            shipment =  dbConnection.fetchShipment(state.getScan().getShipmentOid());

            if ( shipment == null )
            {
                System.out.println("shipment was null");
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                     "Fetch by shipmentOid returned NULL, shipmentOid ==" + state.getScan().getShipmentOid());
                throw cciiEx;
            }

        }
        catch (Exception ex)
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Shipment Fetch Failed, Oid = <" +
                                                      state.getScan().getShipmentOid() + ">");
            throw cciiEx;
        }

        // BSO Flag
        if ((shipment.getSpecialHandling1Cd() != null &&
             shipment.getSpecialHandling1Cd().equals("40")) ||
            (shipment.getSpecialHandling2Cd() != null &&
             shipment.getSpecialHandling2Cd().equals("40")) ||
            (shipment.getSpecialHandling3Cd() != null &&
             shipment.getSpecialHandling3Cd().equals("40")) ||
            (shipment.getSpecialHandling4Cd() != null &&
             shipment.getSpecialHandling4Cd().equals("40")) ||
            (shipment.getSpecialHandling5Cd() != null &&
             shipment.getSpecialHandling5Cd().equals("40")))
        {
            state.getUploadStatus().setBSOFlag(true);
        }
        else
        {
          state.getUploadStatus().setBSOFlag(false);
        }

        // BondTransfer Flag
//        if (????)
//        {
//            state.getUploadStatus().setBondTransferFlag(true);
//        }
//        else
//        {
//            state.getUploadStatus().setBondTransferFlag(false);
//        }

        // Doc and Non-Doc Flag with Overage Flag
        if( state.getScan().getErrorNumber() == Messages.IM_OVERAGE )
        {
            state.getUploadStatus().setDocFlag(false);
            state.getUploadStatus().setNonDocFlag(false);
            state.getUploadStatus().setOverageFlag(true);
        }
        else
        {
            state.getUploadStatus().setOverageFlag(false);
            // Doc Flag & Non-Doc Flag
            if (shipment.getDutiableFlg() != null &&
                shipment.getDutiableFlg().equals("Y"))
            {
               state.getUploadStatus().setDocFlag(false);
               state.getUploadStatus().setNonDocFlag(true);
            }
            else if (shipment.getDutiableFlg() != null &&
                shipment.getDutiableFlg().equals("N"))
            {
                state.getUploadStatus().setDocFlag(true);
                state.getUploadStatus().setNonDocFlag(false);
            }
            else
            {
                state.getUploadStatus().setDocFlag(false);
                state.getUploadStatus().setNonDocFlag(false);
            }
        }

        // MPS Incomplete Flag
        // This interface is documented in section 2.3.2 of the
        // 'APAC Core Clearance System Requirements'
        // Document written by Tom Knobeloch
//        if (BrokerData.MPSCompleteStatus   ????)
//        {
//            state.getUploadStatus().setMPSIncompleteFlag(true);
//        }
//        else
//        {
//            state.getUploadStatus().setMPSIncompleteFlag(false);
//        }

        // Package Damaged Flag, if condition already set do not mess with it
        if (state.getScan().getPkgCondition().equals(""))
        {
            int i_bit = 0;
            boolean b_damaged = false;
            // Package Crushed
            if (state.getUploadStatus().getCrushedFlag())
            {
                i_bit = 0;
                b_damaged = true;
            }
            // Packaged Wet
            if (state.getUploadStatus().getWetFlag())
            {
                i_bit = 1;
                b_damaged = true;
            }
            // Package Torn
            if (state.getUploadStatus().getTornFlag())
            {
                i_bit += 2;
                b_damaged = true;
            }
            // Package Re-wrapped
            if (state.getUploadStatus().getRewrappedFlag())
            {
                i_bit += 4;
                b_damaged = true;
            }
            // Package Re-taped
            if (state.getUploadStatus().getRetapedFlag())
            {
                i_bit += 8;
                b_damaged = true;
            }
            // If any of the above then the package is damaged
            if (b_damaged)
            {
                char[] s_condition = {'A'};
                s_condition[0] += i_bit;
                state.getScan().setPkgCondition(String.copyValueOf(s_condition));
            }
        }
//      System.out.println("PkgCondition " + state.getScan().getPkgCondition());

        if (state.getScan().getPkgCondition().equals(""))
        {
            state.getUploadStatus().setDamagedFlag(false);
        }
        else
        {
            state.getUploadStatus().setDamagedFlag(true);
        }

        // Wrong Flight Flag
//        if (????)
//        {
//            state.getUploadStatus().setWrongFlightFlag(true);
//        }
//        else
//        {
//            state.getUploadStatus().setWrongFlightFlag(false);
//        }

        // Flight Delay Flag
//        if (????)
//        {
//            state.getUploadStatus().setFlightDelayFlag(true);
//        }
//        else
//        {
//            state.getUploadStatus().setFlightDelayFlag(false);
//        }

      // Missed Shuttle Flag
//        if (????)
//        {
//            state.getUploadStatus().setMissedShuttleFlag(true);
//        }
//        else
//        {
//            state.getUploadStatus().setMissedShuttleFlag(false);
//        }

        // Intercepted Flag
        if (state.getInterceptedFlag() != null &&
            state.getInterceptedFlag().equals("Y") )
        {
            state.getUploadStatus().setInterceptedFlag(true);
        }
        else
        {
            state.getUploadStatus().setInterceptedFlag(false);
        }

        // Cleared Flag
        if (state.getInterceptedFlag() != null &&
            state.getInterceptedFlag().equals("C") )
        {
            state.getUploadStatus().setClearedFlag(true);
            state.getUploadStatus().setNotClearedFlag(false);
        }
        else
        {
            state.getUploadStatus().setClearedFlag(false);
            state.getUploadStatus().setNotClearedFlag(true);
        }

        // Travel Status Flag
        if (state.getTravelStatus().equals("D") )
        {
            state.getUploadStatus().setTravelStatusDomesticFlag(true);
            state.getUploadStatus().setTravelStatusIntlFlag(false);
        }
        else
        {
            state.getUploadStatus().setTravelStatusDomesticFlag(false);
            state.getUploadStatus().setTravelStatusIntlFlag(true);
        }
    }

    traceLog("FindUploadStatus", "processing complete");
    traceLog("FindUploadStatus", state);

    return state;

  }

  public static void main(String[] args)
  {
    System.out.println("FindUploadStatus in main");

    DatabaseBean db = new DatabaseBean();

    db.connect();

    System.out.println("Leaving main");
  }
}
