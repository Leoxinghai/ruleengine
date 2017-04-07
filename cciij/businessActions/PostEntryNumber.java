package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PostEntryNumber extends PostShipmentBase {

  private static final String m_whatVersion = "@(#) $RCSfile: PostEntryNumber.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  protected String m_postEntryNumberActivityCode = "";

  public PostEntryNumber() throws Exception
  {
    super("PostEntryNumber");
    traceLog("PostEntryNumber","In Constructor");
  }

  protected void readSiteConfigVariables () throws Exception
  {
    super.readSiteConfigVariables();
    m_postEntryNumberActivityCode = readConfigVariableString("POSTENTRY_NUMBER_ACTIVITY_CODE");
  }

  public CCIIState modifyShipmentData(Shipment ship, CCIIState state) throws Exception
  {
    traceLog("PostEntryNumber","Begining modifyShipmentData()");

    ship.setBrokerEntryNumber( state.getScan().getEntryNumber() );
    state.addActivity(m_postEntryNumberActivityCode);
    m_updateShipmentCoreClearance = true;

    traceLog("PostEntryNumber","completed modifyShipmentData()");
    return state;
  }




  public static void main(String[] args) throws Exception {
  //  PostEntryNumber postEntryNumber1 = new PostEntryNumber();
  }

}