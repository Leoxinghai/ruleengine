//*************************************************************************
//
// Filename: LabelBase.java
//
// Description:  base class of all labels
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/DownloadLabelFormats.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   06/14/01  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import java.io.*;
import java.util.Map;

import cciij.businessActions.label.*;

public class DownloadLabelFormats extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: DownloadLabelFormats.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public DownloadLabelFormats() throws Exception
    {
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read
    }

    public CCIIState doIt(CCIIState a_data,DatabaseBean a_db)
    {
        a_data.m_printData.put("SEND_LABEL",new Boolean(false));
        a_data.m_printData.put("SEND_FORMAT",new Boolean(true));
        a_data.m_printData.put("RELOAD_PRINTER",new Boolean(true));

        return a_data;
    }
}
