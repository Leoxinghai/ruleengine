//*************************************************************************
//
// Filename: FormatSuccessLabel.java
//
// Description:  FormatDownload Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/FormatSuccessLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   09/28/01  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;

import java.util.Map;

public class FormatSuccessLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: FormatSuccessLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public FormatSuccessLabel() throws Exception
    {
        super("FormatSuccessLabel");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        a_data.m_printData.put("SEND_LABEL",new Boolean(true));
        a_data.m_printData.put("SEND_FORMAT",new Boolean(true));

        return null;
    }



    public static void main(String args[])
    {
        System.out.println("FormatSuccessLabel.main()");

        try
        {
            //	    DummyDataObject l_data = new DummyDataObject();
            CCIIState l_data = new CCIIState();

            l_data.m_printData = new java.util.HashMap();

            RPBScan l_scan = new RPBScan();

            l_scan.setPrinterCode(args[0]);

            l_data.setScan(l_scan);

            if((l_data == null) || (l_data.getScan() == null) || (l_data.m_printData == null))
            {
                System.out.println("Found an un-expected null....#########################################");
                System.exit(1);
            }

            DatabaseBean db = new DatabaseBean();

            db.connect();

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new PrinterLabel();
            System.out.println("Got the PrinterLabel Object...");

            try
            {
                l_label.doIt(l_data,db);
            }
            catch(Exception e)
            {
                System.out.println("Caught:  " + e);
            }

        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
            e.printStackTrace();
        }

        System.out.println("FormatSuccessLabel.main()...end");

        return;
    }
}
