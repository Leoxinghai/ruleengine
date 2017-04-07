package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;

public class UtilCleanScanVector extends BusinessActionBase
{
  public UtilCleanScanVector() throws Exception 
  {
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db_connection) throws Exception 
  {
    state.setScanVectorElement(new java.util.Vector());

    return state;
  }

}
