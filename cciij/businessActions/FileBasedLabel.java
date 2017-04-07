package cciij.businessActions;

import java.io.*;
import cciij.cciidata.*;
import cciij.util.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;

import java.util.Date;

/**
 *
 * Filename:  FileBasedLabel.java
 *
 * Description:  File Based Label
 *
 * Revision History:
 *
 *      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
 *
 *      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/FileBasedLabel.java,v $
 *      $Revision: 1.1 $
 *      $Date: 2006/06/26 07:26:01 $
 *
 * Modification History:
 *
 *   09/14/01  Michael Roderick Commented
 *   12/11/03  Joey Cline       Added call to superclass readSiteConfigVariables
 *                              in the readSiteConfigVariables method
 *
 */

public class FileBasedLabel extends LabelBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: FileBasedLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    FileBasedLabelDefinition m_myReference;

    int mi_readFrequency;
    int mi_currentUseCount=-1;

    //    LabelDefinitionInterface m_definition;
    public FileBasedLabel(String as_LabelName) throws Exception
    {
        super(as_LabelName);

        int li_formatNumber;
        String ls_formatNumber;
        String ls_filename;

// 	try
// 	{

        try
        {
            if((ls_formatNumber = m_config.getValue("LABEL_DEFINITION_FORMAT_NUMBER")) == null)
            {
                li_formatNumber = 0;
                throw new Exception("null value");
            }
            else
            {
                li_formatNumber = Integer.parseInt(ls_formatNumber);
            }
        }
        catch(Throwable e)
        {
            throw new LabelPrintException("Failed to retrieve LABEL_DEFINITION_FORMAT_NUMBER from the config file for: "
                                          + as_LabelName + ":  " + e);
        }

//         if((ls_filename =  m_config.getValue("LABEL_DEFINITION_FILE_NAME")) == null)
//         {
//             throw new LabelPrintException("LABEL_DEFINITION_FILE_NAME not defined in config file for:  " + as_LabelName);
//         }

        try
        {
	    //            m_myReference = new FileBasedLabelDefinition(li_formatNumber,
	    //                                                         ls_filename);
	    FileBasedLabelDefinition.addSupportedLabelFormats(m_definitions,m_config,li_formatNumber);
        }
        catch(Throwable e)
        {
            throw new LabelPrintException("Failed to create the label Definition Object for: " + as_LabelName + ": " + e);
        }

	//        m_definition = m_myReference;

        try
        {
            mi_readFrequency = Integer.parseInt(m_config.getValue("LABEL_DEFINITION_READ_FREQUENCY"));
        }
        catch(Throwable e)
        {
            // This is not a critical error, here we will just default it to 0
            mi_readFrequency = 0;
        }
// 	}
// 	catch(Exception e)
// 	{
// 	    System.out.println("Caught an exception in FileBasedLabel constructor:  " + e);
// 	    e.printStackTrace();
// 	    throw e;
// 	}
    }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

    protected LabelData getLabelData(CCIIState a_data)
    {
        Boolean l_readFormatFile;

        l_readFormatFile = (Boolean)a_data.m_printData.get("READ_FORMAT");
        if(((l_readFormatFile != null) && (l_readFormatFile.booleanValue() == false))
            || ((mi_currentUseCount >= mi_readFrequency)
                && (mi_readFrequency >= 0)))
        {
//	    System.out.println("Reading the file definition again!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

//            m_myReference.readLabelFormatFile();
	    m_definitions.resetLabelFormat();
            mi_currentUseCount = 0;

            // Since we are re-reading the input file, we need to download the format as well
            //	    a_data.m_printData.put("SEND_LABEL",new Boolean(true));
            a_data.m_printData.put("SEND_FORMAT",new Boolean(true));
        }
        else
        {
            mi_currentUseCount++;
        }

        return null;
    }


    public static void main(String args[])
    {
        System.out.println("FileBasedLabel.main()");

        try
        {
            CCIIState l_data = new CCIIState();

            RPBScan l_scan = new RPBScan();
	    l_scan.setLocationCode("NRT");

            Date now = new Date();

            int li_labelCount=0;

            if(args.length < 2)
            {
                System.out.println("Usage:");
                System.out.println("    FileBasedLabel <Label Type>  [Location Code [Print Server Code [Label Count> [Send Format [Read File] ] ] ] ]");
                System.out.println("                    Location Code:      The location to execute for");
		System.out.println("                    Label Type:         Label Name(used to lookup in ccii.cfg)");
		System.out.println("                    Print Server Code:  Printer Code(used to index into CCII.PRINTER_CONFIGURATION)");
		System.out.println("                    Label Count:        How many to print");
		System.out.println("                    Send Format:        Dummy param if present, send the format");
		System.out.println("                    Read File:          Dummy param if present, read the file...");
                System.out.println("");
                return;
            }

            if(args.length > 1)
            {
                l_scan.setLocationCode(args[1]);
            }
            else
            {
                l_scan.setLocationCode("NRT");
            }

            if(args.length > 2)
            {
                l_scan.setPrinterCode(args[2]);
            }
            else
            {
                l_scan.setPrinterCode("PRTEST003");
            }

            if(args.length > 3)
            {
                li_labelCount = Integer.parseInt(args[3]);
            }
            else
            {
                li_labelCount = 1;
            }

            l_scan.setAirbillNumber("802049333852");
            l_scan.setHAWB("802049333863");
            l_data.setDiverterCode("3");
            l_scan.setAgencyCode("AG");
            l_scan.setInterceptCode("BP");
            l_scan.setUserLogon("364942");
            l_scan.setSysDateTime(now);

                        l_scan.setStagingAreaCode("STAGE AREA");
                        l_scan.setDetainLoc("Detain Loc");

            l_data.m_printData.put("PieceQuantity","33");
            l_data.m_printData.put("LabelInterceptType","??? Staging");
            l_data.m_printData.put("Agency1","FX");
            l_data.m_printData.put("Agency1Intercept1","PS");
            l_data.m_printData.put("Agency1Intercept2","WJ");
            l_data.m_printData.put("Agency1Intercept3","LSM");
            l_data.m_printData.put("Agency1Intercept4","HSM");
            l_data.m_printData.put("Agency2","CA");
            l_data.m_printData.put("Agency2Intercept1","ROD");

            l_data.m_printData.put("BrokerEntryNumber","12345678901234");

            //            l_data.m_printData.put("LocationCode","YYZ");

            l_data.m_printData.put("ServiceCode","IP");

            l_data.setScan(l_scan);

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new FileBasedLabel(args[0]);
            System.out.println("Got the OverageLabel Object...");

            DatabaseBean db = new DatabaseBean();

            db.connect();

            if(args.length > 4)
            {
                l_data.m_printData.put("SEND_LABEL",new Boolean(true));
                l_data.m_printData.put("SEND_FORMAT",new Boolean(true));
            }

            if(args.length > 5)
            {
                l_data.m_printData.put("READ_FORMAT",new Boolean(true));
            }

            db.setLocationCode(l_scan.getLocationCode());
            //	    db.setLocationCode("NRT");

            for(int i=0;i<li_labelCount;i++)
            {
                l_label.doIt(l_data,db);
            }
        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
            e.printStackTrace();
        }

        System.out.println("FileBasedLabel.main()...end");

        return;
    }
}
