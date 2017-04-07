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
//      $Source: /cvs/fedexccii/src/cciij/businessActions/BKKClearanceLabel.java,v $
//      $Revision: 1.2 $
//      $Date: 2006/09/05 10:09:25 $
//
// Modification History:
//
//   2006/03/05  Liu Xinghai Commented
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.cciidata.*;
import java.util.*;
import cciij.util.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;
import java.text.SimpleDateFormat;

public class BKKClearanceLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: BKKClearanceLabel.java,v $ $Revision: 1.2 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";
    //    LabelDefinitionInterface m_definition;

    private String m_labelType=null;
    private boolean m_exception=false;


    public BKKClearanceLabel() throws Exception
    {
        super("APACClearanceLabel");
    }

    public BKKClearanceLabel(String group) throws Exception
    {
        super(group);
    }


    protected void getLabelType(CCIIState state)
    {
		m_labelType ="";
		m_exception = false;
		return;
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        RPBScan l_scan = a_data.getScan();
        Map l_printData = a_data.getPrintData();
        
//        l_printData.put("SEND_FORMAT",new Boolean(true));
        
        //Clearance status
        if(l_scan.getCustomsReleasedFlag().equals("Y")) {
    		l_printData.put("ClearanceStatus","CLR");
        } else {
    		l_printData.put("ClearanceStatus","NCLR");
        }
        /*
        if(l_scan.getReleaseCode().equals("Y")) {
        	if(l_scan.getInterceptCode().equals("HD") || l_scan.getInterceptCode().equals("FO")) {
        	    l_printData.put("ClearanceStatus","HOLD");
        	} else 
        		l_printData.put("ClearanceStatus","CLEAR");
        } else {
    	    l_printData.put("ClearanceStatus","-");
        }
        */

	    // First we pick which Belt/Exception to put on the label

	getLabelType(a_data);

	String labelType = "  " + m_labelType + "  ";

	if(m_exception)
	{
	    a_data.addPrintMapElement("EXCEPTION_LABEL_TYPE",labelType);
	    a_data.addPrintMapElement("NORMAL_LABEL_TYPE","");
	}
	else
	{
	    a_data.addPrintMapElement("EXCEPTION_LABEL_TYPE","");
	    a_data.addPrintMapElement("NORMAL_LABEL_TYPE",labelType);
	}


        // Set the flight data field to N/A if not present or empty
        String flghtData = (String)l_printData.get("FLGHTDATA");
        if((flghtData == null) || (flghtData.trim().length() <= 0))
        {
           flghtData = "N/A";
        }

        l_printData.put("FLGHTDATA",flghtData);


        // Get the route leg data for the label
        String rteLegPrintData = "N/A";

        RouteLeg rl = a_data.getRouteLegInfo();
	if(rl != null)
	{
            SimpleDateFormat df = 
                 new SimpleDateFormat(readConfigVariableString("ROUTE_DATE_FORMAT","MMM d, yyyy"));
	    rteLegPrintData = rl.getRouteNumber() + " " + df.format(rl.getRouteDate());
	}

        l_printData.put("RTELEGDATA",rteLegPrintData);


	// Next, lets format the MAWB if it is present
	String mawb = (String)l_printData.get("MAWB");
	if((mawb != null) && (mawb.equals("") == false))
	{
	    a_data.addPrintMapElement("FORMATTED_MAWB",formatAWB(mawb));
	}

		String interceptOrDestCode = (String)l_printData.get("PiorityIntercept1");
	
		if(interceptOrDestCode == null)
		{
		    // There are no intercept Codes so set it to the dest...
		    interceptOrDestCode = a_data.getScan().getDestLocationCode();
		} else {
			if(interceptOrDestCode.indexOf(" ")>0) {
				interceptOrDestCode = interceptOrDestCode.substring(0,interceptOrDestCode.indexOf(" "));
			}
		}

		if((interceptOrDestCode != null) && (interceptOrDestCode.length() > 0))
		{
		    a_data.addPrintMapElement("INTERCEPT_OR_DEST_CODE",interceptOrDestCode);
		}

        return null;
    }


    public static void main(String args[])
    {
        System.out.println("APACClearanceLabel.main()");

        try
        {
            CCIIState l_data = new CCIIState();

            RPBScan l_scan = new RPBScan();

            Date now = new Date();

            l_data.m_printData.put("SEND_LABEL",new Boolean(true));
            l_data.m_printData.put("SEND_FORMAT",new Boolean(true));


            if(args.length > 0)
            {
                l_scan.setPrinterCode(args[0]);
            }
            else
            {
                l_scan.setPrinterCode("PRTEST003");
            }
            l_scan.setAirbillNumber("802049333852");
            //	    l_scan.setHAWB("802049333863");
            l_data.setDiverterCode("3");
            l_scan.setAgencyCode("AG");
            l_scan.setInterceptCode("BP");
            l_scan.setUserLogon("364942");
            l_scan.setSysDateTime(now);
            //	    l_data.setLabelInterceptType("MPS STAGING");

            //	    l_data.m_printData.put("PieceQuantity","33");
            l_data.m_printData.put("LabelInterceptType","MPS Staging");
            l_data.m_printData.put("Agency3","FX");
            l_data.m_printData.put("Agency3Intercept1","PS");
            l_data.m_printData.put("Agency3Intercept2","WJ");
            l_data.m_printData.put("Agency3Intercept3","LSM");
            l_data.m_printData.put("Agency3Intercept4","HSM");
            l_data.m_printData.put("Agency2","CA");
            l_data.m_printData.put("Agency2Intercept1","ROD");
            l_data.m_printData.put("Agency1","CA");
            l_data.m_printData.put("Agency1Intercept1","RLV");
            l_data.m_printData.put("Agency1Intercept2","RHV");

            l_data.m_printData.put("BrokerEntryNumber","12345678901234");

            l_data.m_printData.put("LocationCode","YYZ");

            l_data.m_printData.put("ServiceCode","IP");

	    // APAC stuff
	    l_data.m_printData.put("LabelType","U");
	    l_data.m_printData.put("EntryType","DOC");
	    l_data.m_printData.put("ClearanceStatus","CLRST");
	    l_data.m_printData.put("CustomerInstruction","FF");
	    l_data.m_printData.put("CommitmentDate","GG");
	    l_data.m_printData.put("DestLocationCode","NRTA");
	    l_data.m_printData.put("LocalDispatchCode","IIII");
	    

            l_data.setScan(l_scan);

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new APACClearanceLabel();
            System.out.println("Got the OverageLabel Object...");

            DatabaseBean db = new DatabaseBean();

            db.connect();

	    db.setLocationCode("NRT");

            l_label.doIt(l_data,db);
        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
            e.printStackTrace();
        }

        System.out.println("APACClearanceLabel.main()...end");

        return;
    }
}
