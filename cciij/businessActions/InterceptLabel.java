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
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/InterceptLabel.java,v $
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

public class InterceptLabel extends FileBasedLabel
{
    protected    Boolean l_readFormatFile;
    protected    Boolean l_sendFormat;

    private static final String m_whatVersion = "@(#) $RCSfile: InterceptLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public InterceptLabel() throws Exception
    {
        super("InterceptLabel");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        RPBScan l_scan = a_data.getScan();
        Map l_printData = a_data.m_printData;

        String ls_curAgencyCode=new String();
        String ls_curIntCode=new String();
        String ls_curAgencyName;
        int li_intCount=0;

        l_readFormatFile = (Boolean)a_data.m_printData.get("READ_FORMAT");

        // Only attempt to gather data for the label if SEND_FORMAT is false
        l_sendFormat = (Boolean)l_printData.get("SEND_FORMAT");

        for(int li_curAgency=1;li_curAgency <= 3;li_curAgency++)
        {
            ls_curAgencyCode = "Agency" + li_curAgency;

            //	    System.out.println("Working on:  " + ls_curAgencyCode);

            li_intCount=0;

            for(int li_curInt=4;
                (li_curInt >= 1) && (li_intCount == 0);
                li_curInt--)
            {
                ls_curIntCode = ls_curAgencyCode + "Intercept" + li_curInt;

                //		System.out.println("Checking to see if " + ls_curIntCode + " is blank");

                if(l_printData.containsKey(ls_curIntCode))
                {
                    // Found the last intercept
                    li_intCount = li_curInt;
                    //		    System.out.println("There are " + li_curInt + " Intercept for this agency");
                }
                else
                {
                    //		    l_data.addString("");
                    //		    System.out.println("Slot number:  " + li_curInt + " is blank");
                }
            }

            for(int li_curInt=1;li_curInt <= li_intCount;li_curInt++)
            {
                ls_curIntCode = ls_curAgencyCode + "Intercept" + li_curInt;

                //		System.out.println("Lets add data for " + ls_curIntCode);

                if(l_printData.containsKey(ls_curIntCode))
                {
                    //		    l_data.addString((String)l_printData.get(ls_curIntCode));
                    l_printData.put((ls_curAgencyCode + "Intercept" + (li_curInt + (4 - li_intCount)) + "_Formatted"),
                                     (String)l_printData.get(ls_curIntCode));
                }
                else
                {
                    //		    l_data.addString("");
                }
            }
        }

        // Now lets Change the Agency Codes to Agency Names, if present

        int li_curAgency = 1;

        String ls_curAgency = "Agency" + li_curAgency;

        while((ls_curAgencyCode = (String)l_printData.get(ls_curAgency)) != null)
        {
            Agency l_curAgency;

            ls_curAgency = "AgencyName" + li_curAgency;

            try
            {
                if((l_curAgency = m_db.fetchAgency(ls_curAgencyCode)) == null)
                {
                    throw new Exception();
                }

                if(((ls_curAgencyName = (String)l_curAgency.getAgencyDescription()) == null)
                   || (ls_curAgencyName.length() < 1))
                {
                    throw new Exception();
                }

                l_printData.put(ls_curAgency,ls_curAgencyName);
            }
            catch(Exception e)
            {
                // since it didnt work, put the agency code in the name field...
                l_printData.put(ls_curAgency,ls_curAgencyCode);
            }

            li_curAgency++;
            ls_curAgency = "Agency" + li_curAgency;
        }

        if ((l_sendFormat != null) && (l_sendFormat.booleanValue() == true))
        {
            // Do no fetching of data
        }
        else
        {
//             AgencyStagingArea asa = null;

//             // fetch the AgencyStageingArea record
//             try
//             {
//                 asa = m_db.fetchAgencyStagingAreaByLocCdWhCdAgCd(a_data.getScan().getWarehouseCode(),
//                                                                  a_data.getScan().getAgencyCode());
//             }
//             catch (Exception ex)
//             {
//                 System.out.println("AgencyStagingArea Fetch failed, looking for agency " + a_data.getScan().getAgencyCode());
//                 a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
//                 CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","AgencyStagingArea fetch failed");
//             }

//             if ( asa == null )
//             {
//                 System.out.println("AgencyStagingArea Fetch not found, agency " + a_data.getScan().getAgencyCode());
//                 a_data.getScan().setErrorNumber(Messages.EM_DB_ERROR);
//                 CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","AgencyStagingArea fetch failed");
//                 return null;
//             }

            if (a_data.getStagingArea().length() <= 2)
            {
                l_printData.put("STAGING_AREA_CODE", " " + a_data.getStagingArea());
            }
            else
            {
                l_printData.put("STAGING_AREA_CODE", a_data.getStagingArea());
            }

            StagingArea sa = null;

            // fetch the StageingArea record
            try
            {
                sa = m_db.fetchStagingArea( a_data.getStagingArea() );
            }
            catch (Exception ex)
            {
                System.out.println("StagingArea Fetch failed, looking for StagingAgency " + a_data.getStagingArea());
                l_printData.put("STAGING_AREA_DESC", "");
                return null;
            }

            if ( sa == null )
            {
                System.out.println("StagingArea Fetch not found, StagingAgency " + a_data.getStagingArea());
                l_printData.put("STAGING_AREA_DESC", "");
                return null;
            }

            l_printData.put("STAGING_AREA_DESC",centerAgencyDescription(sa.getStagingAreaDescription()));
        }

        return null;
    }

    private String centerAgencyDescription(String Description)
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
        System.out.println("InterceptLabel.main()");

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

            l_data.setScan(l_scan);

            System.out.println("Got the dummy object...");
            BusinessActionInterface l_label = new InterceptLabel();
            System.out.println("Got the OverageLabel Object...");

            DatabaseBean db = new DatabaseBean();

            db.connect();

            l_label.doIt(l_data,db);
        }
        catch(Exception e)
        {
            System.err.println("Caught an exception..." + e);
            e.printStackTrace();
        }

        System.out.println("InterceptLabel.main()...end");

        return;
    }
}
