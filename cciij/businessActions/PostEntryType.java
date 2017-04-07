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

public class PostEntryType extends PostShipmentBase {

  private static final String m_whatVersion = "@(#) $RCSfile: PostEntryType.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  protected String  m_defaultSourceCode = "";
  protected String  m_recurringSourceCode = "";
  protected String  m_postEntryTypeActivityCode = "";

  public PostEntryType() throws Exception
  {
    super("PostEntryType");
    traceLog("PostEntryType","In Constructor");
  }

  protected void readSiteConfigVariables () throws Exception
  {
    super.readSiteConfigVariables();
    m_defaultSourceCode = readConfigVariableString("POSTENTRY_DEFAULT_SOURCE_CODE");
    m_recurringSourceCode = readConfigVariableString("POSTENTRY_RECURRING_SOURCE_CODE");
    m_postEntryTypeActivityCode = readConfigVariableString("POSTENTRY_TYPE_ACTIVITY_CODE");
  }

  public CCIIState modifyShipmentData(Shipment ship, CCIIState state) throws Exception
  {
    traceLog("PostEntryType","Begining modifyShipmentData()");

    if ( state.getRecuringInterceptFlag() )
    {
      ship.setEntryCategorySourceCd(m_recurringSourceCode);
    }
    else
    {
      ship.setEntryCategorySourceCd(m_defaultSourceCode);
    }

    ship.setEntryCategoryTypeCd( state.getScan().getEntryType() );
    state.addActivity( m_postEntryTypeActivityCode );
    m_updateShipmentCoreClearance = true;

    traceLog("PostEntryType","completed modifyShipmentData()");
    return state;
  }




  public static void main(String[] args) throws Exception {
  //  PostEntryType postEntryType1 = new PostEntryType();
  }

}