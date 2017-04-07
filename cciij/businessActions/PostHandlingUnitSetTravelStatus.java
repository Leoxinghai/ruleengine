package cciij.businessActions;

/**
 * Title:       Post Handling Unit Set Travel Status
 * Description: This Business Action retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the travel status ('D' or 'I')
 *              - the last modified date timestamp
 *              - the last user name
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Gary Rockwood with code cut from PostHandlingUnitSetPlaceToBlank
 * @version 1.0
 *
 * @throws      cciij.util.CCIILogException Failure during fetch of HandlingUnit
 * @throws      cciij.util.CCIILogException HandlingUnit fetch by Oid failed
 * @throws      cciij.util.CCIILogException Failure during update of HandlingUnit
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostHandlingUnitSetTravelStatus extends PostHandlingUnitBase {

private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingUnitSetTravelStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

public PostHandlingUnitSetTravelStatus() throws Exception
{
   traceLog("PostHandlingUnitBase","In Constructor");

}


protected void setPlaceValues(HandlingUnit hu, CCIIState state) throws Exception
{
  traceLog("PostHandlingUnitSetTravelStatus","Beginning setPlaceValues(hu, state)");

  // Get the travel status as entered by the user
  String m_userEnteredTravelStatus = state.getScan().getTravelStatus();

  // Check if something has changed
  if (state.getTravelStatus().equals(m_userEnteredTravelStatus))
  {
    // We have it correct, change nothing
  }
  else
  {
    // Set the Piece Core Clearance table correctly
    hu.setTravelStatus(m_userEnteredTravelStatus);

    // The ErrorNumber IM value will need to change
    if (state.getScan().getErrorNumber() == Messages.IM_DOMESTIC_PKG)
    {
      state.getScan().setErrorNumber(Messages.IM_OVERAGE);
    }
    else
    {
      state.getScan().setErrorNumber(Messages.IM_DOMESTIC_PKG);
    }
  }
}

public static void main(String args[])
{
   try
   {
      PostHandlingUnitSetTravelStatus postHandlingUnitSetTravelStatus = new PostHandlingUnitSetTravelStatus();
      postHandlingUnitSetTravelStatus.test();
   }
   catch (Exception e)
   {
      System.out.println(e);
   }
}

public void test() throws Exception
{
   //test data must include an oid number that exists in the database
   CCIIState cciiState = new CCIIState();
   cciiState.getScan().setStagingAreaCode("");
   cciiState.getScan().setDetainLoc("");
   cciiState.getScan().setWarehouseCode("");
   cciiState.getScan().setLocationCode("YYZ");
   cciiState.getScan().setHandlingUnitOid(5621);
   java.util.Date time = new java.util.Date();
   cciiState.getScan().setTransactionTimestamp(time);

   cciiState = (CCIIState) actionEntry(cciiState);
   System.out.println("state after execution " + cciiState);

   return;
}





}
