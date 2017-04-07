package cciij.businessActions;

/**
 * Title:       Business Action Interface
 * Description: Abstract definitions for Business Actions
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author       Robert Fisher
 * @version      1.0
 */

import cciij.cciidata.*;
import cciij.cciidatabase.DatabaseBean;

public interface BusinessActionInterface {
  public com.fedex.css.ruleprocessor.State actionEntry(com.fedex.css.ruleprocessor.State s);
  public CCIIState doIt(CCIIState s, DatabaseBean db) throws Exception;
};
