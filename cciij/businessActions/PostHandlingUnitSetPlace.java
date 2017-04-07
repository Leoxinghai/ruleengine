package cciij.businessActions;

/**
 * Title:       Post Handling Unit Set Place
 * Description: This Business Action retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the staging area code
 *              - the detainment location description
 *              - the last modified date timestamp
 *              - the last user name
 *
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Lorraine Dominguez
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
 * Pre-conditions:
 * @param       dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostHandlingUnitSetPlace extends PostHandlingUnitBase 
{

private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingUnitSetPlace.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

public PostHandlingUnitSetPlace() throws Exception 
{
   traceLog("PostHandlingUnitSetPlace","In Constructor");

}


protected void setPlaceValues(HandlingUnit hu, CCIIState state) throws Exception
{
   traceLog("PostHandlingUnitSetPlace","Beginning setPlaceValues(hu, state)");
   hu.setStagingAreaCode(state.getScan().getStagingAreaCode());
   hu.setDetainmentLocationDescription(state.getScan().getDetainLoc());
   hu.setWarehouseCode(state.getScan().getWarehouseCode());

   // If the comments field is blank put the Detainment location there
   if (state.getScan().getComments().length() == 0)
   {
       state.getScan().setComments(state.getScan().getDetainLoc());
   }

}


public static void main(String args[])
{
   try
   { 
      PostHandlingUnitSetPlace postHandlingUnitSetPlace = new PostHandlingUnitSetPlace();
      postHandlingUnitSetPlace.test();
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
   cciiState.getScan().setStagingAreaCode("MPS");
   cciiState.getScan().setDetainLoc("");
   cciiState.getScan().setWarehouseCode("WH1");
   cciiState.getScan().setLocationCode("YYZ");
   cciiState.getScan().setHandlingUnitOid(5621);
   java.util.Date time = new java.util.Date();
   cciiState.getScan().setTransactionTimestamp(time);

   cciiState = (CCIIState) actionEntry(cciiState);
   System.out.println("state after execution " + cciiState);

   return;
}

}

