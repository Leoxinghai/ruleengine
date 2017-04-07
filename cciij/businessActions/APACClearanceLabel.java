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
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/APACClearanceLabel.java,v $
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
import java.util.*;
import cciij.util.*;
import cciij.cciidatabase.*;
import cciij.businessActions.label.*;
import java.text.SimpleDateFormat;

public class APACClearanceLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: APACClearanceLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;

    private String m_labelType=null;
    private boolean m_exception=false;


    public APACClearanceLabel() throws Exception
    {
        super("APACClearanceLabel");
    }

    public APACClearanceLabel(String group) throws Exception
    {
        super(group);
    }


    protected void getLabelType(CCIIState state)
    {
	// First we check for duplicate flag
	if(state.getDuplicateFlag().equals("Y"))
	{
	    m_labelType = m_config.getValue("DUPLICATE_BELT_ID");
	    m_exception = true;
	    return;
	}

	// Next we check to see if it is an overage
	if((state.getOverageFlag() != null) 
	   && (state.getOverageFlag().equals("") == false))
	{
	    // It is an overage, lets see which kind
	    String ovgFlg = state.getOverageFlag();

	    if(ovgFlg.equals("Y") || ovgFlg.equals("DELETED"))
	    {
		m_labelType = m_config.getValue("OVERAGE_BELT_ID");
		m_exception = true;
		return;
	    } 
	    else if(ovgFlg.equals("D"))
	    {
		m_labelType = m_config.getValue("DATE_OVERAGE_BELT_ID");
		m_exception = true;
		return;
	    }
	    else if(ovgFlg.equals("S"))
	    {
		m_labelType = m_config.getValue("MISSORT_BELT_ID");
		m_exception = true;
		return;
	    }
	}

	String intFlg = state.getInterceptedFlag();

	if((intFlg != null) && (intFlg.equals("") == false))
	{
	    if(intFlg.equals("C"))
	    {
		m_labelType = m_config.getValue("CLEARED_BELT_ID");
		m_exception = false;
		return;
	    }
	}

	// Default case, send it to the staging area
	m_labelType = m_config.getValue("INTERCEPTED_BELT_ID");
	m_exception = false;
	return;
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        RPBScan l_scan = a_data.getScan();
        Map l_printData = a_data.getPrintData();

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
	}

	if((interceptOrDestCode != null) && (interceptOrDestCode.length() > 0))
	{
	    a_data.addPrintMapElement("INTERCEPT_OR_DEST_CODE",interceptOrDestCode);
	}


// 	// Finally we do the intercept code setup stuff
//         String ls_curAgencyCode=new String();
//         String ls_curIntCode=new String();
//         String ls_curAgencyName;
//         int li_intCount=0;

//         for(int li_curAgency=1;li_curAgency <= 3;li_curAgency++)
//         {
//             ls_curAgencyCode = "Agency" + li_curAgency;

//             //	    System.out.println("Working on:  " + ls_curAgencyCode);

//             li_intCount=0;

//             for(int li_curInt=4;
//                 (li_curInt >= 1) && (li_intCount == 0);
//                 li_curInt--)
//             {
//                 ls_curIntCode = ls_curAgencyCode + "Intercept" + li_curInt;

//                 //		System.out.println("Checking to see if " + ls_curIntCode + " is blank");

//                 if(l_printData.containsKey(ls_curIntCode))
//                 {
//                     // Found the last intercept
//                     li_intCount = li_curInt;
//                     //		    System.out.println("There are " + li_curInt + " Intercept for this agency");
//                 }
//                 else
//                 {
//                     //		    l_data.addString("");
//                     //		    System.out.println("Slot number:  " + li_curInt + " is blank");
//                 }
//             }

//             for(int li_curInt=1;li_curInt <= li_intCount;li_curInt++)
//             {
//                 ls_curIntCode = ls_curAgencyCode + "Intercept" + li_curInt;

//                 //		System.out.println("Lets add data for " + ls_curIntCode);

//                 if(l_printData.containsKey(ls_curIntCode))
//                 {
//                     //		    l_data.addString((String)l_printData.get(ls_curIntCode));
//                     l_printData.put((ls_curAgencyCode + "Intercept" + (li_curInt + (4 - li_intCount)) + "_Formatted"),
//                                      (String)l_printData.get(ls_curIntCode));
//                 }
//                 else
//                 {
//                     //		    l_data.addString("");
//                 }
//             }
//         }

//         // Now lets Change the Agency Codes to Agency Names, if present

//         int li_curAgency = 1;

//         String ls_curAgency = "Agency" + li_curAgency;

//         while((ls_curAgencyCode = (String)l_printData.get(ls_curAgency)) != null)
//         {
//             Agency l_curAgency;

//             ls_curAgency = "AgencyName" + li_curAgency;

//             try
//             {
//                 if((l_curAgency = m_db.fetchAgency(ls_curAgencyCode)) == null)
//                 {
//                     throw new Exception();
//                 }

//                 if(((ls_curAgencyName = (String)l_curAgency.getAgencyDescription()) == null)
//                    || (ls_curAgencyName.length() < 1))
//                 {
//                     throw new Exception();
//                 }

//                 l_printData.put(ls_curAgency,ls_curAgencyName);
//             }
//             catch(Exception e)
//             {
//                 // since it didnt work, put the agency code in the name field...
//                 l_printData.put(ls_curAgency,ls_curAgencyCode);
//             }

//             li_curAgency++;
//             ls_curAgency = "Agency" + li_curAgency;
//         }

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

//            l_data.m_printData.put("SEND_LABEL",new Boolean(true));
//            l_data.m_printData.put("SEND_FORMAT",new Boolean(true));


            if(args.length > 0)
            {
                l_scan.setPrinterCode(args[0]);
            }
            else
            {
                l_scan.setPrinterCode("BRKT17");
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

	    db.setLocationCode("BKK");

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
