package cciij.businessActions;

/**
 * Title:       Set BTS Scan For Posting 
 * Description:
 * Copyright:   Copyright (c) 2004
 * Company:     FedEx Services
 * @author      Tom Knobeloch
 * @version 	1.0
 *
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;

public class SetBTSScanForPosting extends SetScanForPosting
{
  private static final String m_whatVersion = "@(#) $RCSfile: SetBTSScanForPosting.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public SetBTSScanForPosting() throws Exception
  {
  }
  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    return super.doIt(state, dbConnection);
  }
      
  protected String setScanTypeCode(CCIIState state)
  {
    return state.getScan().getTransCode();
  }
}

