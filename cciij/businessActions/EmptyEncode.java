package cciij.businessActions;

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;

/**
 * Title:        Empty Encode
 * Description:  Does not send a message.  Dummy class placeholder used to bypass
 *               certain events.
 * Copyright:    Copyright (c) 2005
 * Company:      FedEx Services
 * @author       Joey Cline
 * @version 1.0
 * <br>
 * Known SubClasses:
 * N/A
 * <br>
 * Pre-conditions:
 * <br>
 * Modification History:<br>
 *   01/03/05    Joey Cline - Initial creation<br>
 */

public class EmptyEncode implements PostMessageInterface
{
  private static final String m_whatVersion = "@(#) $RCSfile: EmptyEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public EmptyEncode() throws Exception
  {
  }

  public void initialize(UploadCategoryDef uploadCategoryDef, String system, String mode) throws Exception
  {
  }

  public void createMessage(CCIIState state,
                            DatabaseBean dbConnection,
                            Upload upload)
                            throws Exception

  {
  }
}
