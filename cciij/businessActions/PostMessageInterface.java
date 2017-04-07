package cciij.businessActions;

/**
 * Title:       Post Message Interface
 * Description: Abstract definitions for Messages to be sent to a queue
 * Company:      FedEx
 * @author       Kathy Smathers
 * @version      1.0
 */

import cciij.cciidata.*;
import cciij.cciidatabase.*;

public interface PostMessageInterface {
  public void initialize(UploadCategoryDef uploadCategoryDef, String system, String mode) throws Exception;
  public void createMessage(CCIIState state, DatabaseBean dbConnection,
			    Upload upload) throws Exception;
};
