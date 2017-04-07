//*************************************************************************
//
// Filename: ClearedLabel.java
//
// Description:  Cleared Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/MPSLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   06/14/01  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.cciidata.*;
import cciij.util.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;

public class MPSLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: MPSLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public MPSLabel() throws Exception
    {
        super("MPSLabel");

        //	m_definition = new FileBasedLabelDefinition("/ccs/home/mr34682c/source/ccii/foundation/jccii/input.dat");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        LabelData l_data = new LabelData();

// 	l_data.addString(a_data.getAgencyCode());
// 	l_data.addString(a_data.getScan().getInterceptCode());
// 	l_data.addString(a_data.getDiverterCode());
        l_data.addString("MULTI-PCE");
        l_data.addString(a_data.getScan().getAirbillNumber());

        return l_data;
    }

//     public CCIIState doIt(CCIIState a_data,DatabaseBean a_db)
//     {
// 	String ls_printerCode;
// 	String ls_agencyCode;
// 	String ls_interceptCode;
// 	String ls_awb;
// 	String ls_diverterCode;

// 	LabelData l_data = new LabelData();

// 	PrintServer l_server;

// 	RPBScan l_scan;

// 	l_scan = a_data.getScan();

// 	ls_printerCode = l_scan.getPrinterCode();
// 	ls_awb = l_scan.getAirbillNumber();

// 	ls_diverterCode = a_data.getDiverterCode();
// 	ls_agencyCode = a_data.getAgencyCode();
// 	ls_interceptCode = l_scan.getInterceptCode();

// 	// 	l_data.addString(ls_agencyCode);
// 	// 	l_data.addString(ls_interceptCode);
// 	//	l_data.addString(ls_diverterCode);
// 	l_data.addString("MULTI-PCE");
// 	//                DUPLICATE
// 	l_data.addString(ls_awb);

// 	try
// 	{
// 	    l_server = getPrintServer(ls_printerCode,a_db);

// 	    m_definition.sendFormat(l_server,false);
// 	    m_definition.printLabel(l_server,l_data);
// 	}
// // 	catch(LabelPrintException e)
// // 	{
// // 	    throw e;
// // 	}
// 	catch(Exception e)
// 	{
// 	    //	    throw new LabelPrintException(""+e);
// 	    System.err.println("" + e);
// 	    l_scan.setErrorNumber(Messages.EM_CHECK_LOG);
// 	    a_data.setScan(l_scan);
// 	}

// 	return a_data;
//     }

    public static void main(String args[])
    {
        System.out.println("MPSLabel.main()");

        try
        {
            CCIIState l_data = new CCIIState();

            RPBScan l_scan = new RPBScan();

            l_data.m_printData.put("LabelInterceptType","MPS Staging");

            if(args.length > 0)
            {
                l_scan.setPrinterCode(args[0]);
            }
            else
            {
                l_scan.setPrinterCode("PRTEST001");
            }
            l_scan.setAirbillNumber("40012312312");
            l_data.setDiverterCode("3");
            l_scan.setAgencyCode("AG");
            l_scan.setInterceptCode("BP");

            l_data.setScan(l_scan);

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new MPSLabel();
            System.out.println("Got the OverageLabel Object...");

            DatabaseBean db = new DatabaseBean();

            db.connect();

            l_label.doIt(l_data,db);
        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
        }

        System.out.println("MPSLabel.main()...end");

        return;
    }
}
