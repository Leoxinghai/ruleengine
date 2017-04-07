//*************************************************************************
//
// Filename: DuplicateLabel.java
//
// Description:  Printer Code Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/DuplicateLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   06/06/02  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;

import cciij.businessActions.label.*;
import java.util.Map;

public class DuplicateLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: DuplicateLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public DuplicateLabel() throws Exception
    {
        super("DuplicateLabel");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        try
        {
            String ls_dupStagingAreaCode = m_config.getValue(a_data.getScan().getLocationCode(),"DUPLICATE_STAGING_AREA");

            if(ls_dupStagingAreaCode != null)
            {
                StagingArea l_dupStage;
                String ls_diverterCode;

                l_dupStage = m_db.fetchStagingArea(ls_dupStagingAreaCode);

                ls_diverterCode = l_dupStage.getDiverterNumber();

                a_data.setDiverterCode(ls_diverterCode);

                a_data.m_printData.put("DIVERTER_TEXT",ls_diverterCode);
                a_data.m_printData.put("DIVERTER_LOCATION",l_dupStage.getLocationCode());
                a_data.m_printData.put("STAGING_AREA_CODE",l_dupStage.getStagingAreaCode());
                a_data.m_printData.put("STAGING_AREA_DESC",CenterDescription(l_dupStage.getStagingAreaDescription()));

                switch(ls_diverterCode.length())
                {
                case 1:
                    ls_diverterCode = "000" + ls_diverterCode;
                    break;
                case 2:
                    ls_diverterCode = "00" + ls_diverterCode;
                    break;
                case 3:
                    ls_diverterCode = "0" + ls_diverterCode;
                    break;
                }

                a_data.m_printData.put("DIVERTER_BARCODE_TEXT",ls_diverterCode);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error looking up the Duplicate Staging Area Diverter Code:  " + e);
            e.printStackTrace();
        }

        return null;
    }

    private String CenterDescription(String Description)
    {
        String s_centerDescription = "";

        // Center the description in an area of 30 characters
        if (Description.length() > 0)
        {
            // Center the description
            int knt = (30 - Description.length()) / 2;
            for (int i=0; i<knt; i++)
            {
                s_centerDescription += " ";
            }
            s_centerDescription += Description;
        }

        return s_centerDescription;
    }

    public static void main(String args[])
    {
        System.out.println("DuplicateLabel.main()");

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
            BusinessActionInterface l_label = new DuplicateLabel();
            System.out.println("Got the PrinterLabel Object...");

            try
            {
                l_label.actionEntry(l_data);
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

        System.out.println("DuplicateLabel.main()...end");

        return;
    }
}
