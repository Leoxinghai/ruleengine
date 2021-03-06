package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

/**
 * Title:       Post Handling Unit Set Form Code
 * Description: This Business Action retrieves a HandlingUnit from the database
 *              and updates it with information from Rule Processor Bridge (RPB). The
 *              information from RPB consists of:
 *              - the form type code
 *
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Lorraine Dominguez
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
 */
public class PostHandlingUnitSetFormCode extends PostHandlingUnitBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: PostHandlingUnitSetFormCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public PostHandlingUnitSetFormCode() throws Exception
  {
     traceLog("PostHandlingUnitSetFormCode","In Constructor");
  }

  protected void setPlaceValues(HandlingUnit hu, CCIIState state) throws Exception
  {
     traceLog("PostHandlingUnitSetFormCode","Beginning setPlaceValues(hu, state)");
     hu.setFormTypeCode(state.getScan().getAirbillFormType());
  }

  public static void main(String args[])
  {
     try
     {
        PostHandlingUnitSetFormCode postHandlingUnitSetFormCode = new PostHandlingUnitSetFormCode();
        postHandlingUnitSetFormCode.test();
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
     cciiState.getScan().setHandlingUnitOid(12176336);
     java.util.Date time = new java.util.Date();
     cciiState.getScan().setTransactionTimestamp(time);

     cciiState = (CCIIState) actionEntry(cciiState);
     System.out.println("state after execution " + cciiState);

     return;
  }

}

