//*************************************************************************
//
// Filename: PrinterLabel.java
//
// Description:  Printer Code Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/PrinterLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   06/15/01  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;

import java.util.Map;

public class PrinterLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: PrinterLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public PrinterLabel() throws Exception
    {
        super("PrinterLabel");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        //	LabelData l_data = new LabelData();

        String ls_printerCode;
        String ls_area;
        String ls_ID;

        Map l_printerData = a_data.m_printData;

        ls_printerCode = a_data.getScan().getPrinterCode();

        ls_area = ls_printerCode.substring(2,6);
        ls_ID   = ls_printerCode.substring(6);

        l_printerData.put("PrinterArea",ls_area);
        l_printerData.put("PrinterNumber",ls_ID);

        // This causes the Printer to be re-looked up in the DB
        a_data.m_printData.put("RELOAD_PRINTER",new Boolean(true));

// 	l_data.addString(ls_area);
// 	l_data.addString(ls_ID);
// 	l_data.addString(ls_printerCode);
// 	l_data.addString(ls_printerCode);

        return null;
    }



    public static void main(String args[])
    {
        System.out.println("PrinterLabel.main()");

        try
        {
            //	    DummyDataObject l_data = new DummyDataObject();
            CCIIState l_data = new CCIIState();

            l_data.m_printData = new java.util.HashMap();

            RPBScan l_scan = new RPBScan();

            l_scan.setPrinterCode(args[0]);
	    l_scan.setLocationCode(args[1]);

            l_data.setScan(l_scan);

	    l_data.m_printData.put("SEND_FORMAT",new Boolean(true));

            if((l_data == null) || (l_data.getScan() == null) || (l_data.m_printData == null))
            {
                System.out.println("Found an un-expected null....#########################################");
                System.exit(1);
            }

            DatabaseBean db = new DatabaseBean();

            db.connect();

	    db.setLocationCode(args[1]);

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

        System.out.println("PrinterLabel.main()...end");

        return;
    }
}
