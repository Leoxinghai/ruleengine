package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;

public class UtilCleanState extends com.fedex.css.ruleprocessor.BusinessAction
{
  public UtilCleanState() throws Exception
  {
  }

  protected void initialize() throws Exception
  {
  }

  public com.fedex.css.ruleprocessor.State actionEntry(com.fedex.css.ruleprocessor.State inState)
  {
    CCIIState state = (CCIIState)inState;

    state.setActivityCodes(null);
    state.setPrintData(null);
    state.setExceptionActivityCodes(null);
    state.setCAGEReasonCodes(null);
    state.setCAGEReleaseCodes(null);
    state.setHandlingInstructions(null);
    state.setShipmentRemarks(null);
    state.setUploadKey(null);
    state.setScanVectorElement(null);
    state.setUploadStatus(null);
    state.setCurrentScan(null);

    return state;
  }

}
