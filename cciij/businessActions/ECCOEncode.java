package cciij.businessActions;

/**
 * Title:        ECCO Encode
 * Description:  Create an ECCO message based on the State.   When created put the
 *               ECCO buffer onto the MQ communicating with the Event Translator.
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @throws
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   02/26/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import java.text.*;
import java.util.*;
import java.io.*;


public class ECCOEncode extends PostMQMessage
{
  private static final String m_whatVersion = "@(#) $RCSfile: ECCOEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $$Date: 2006/06/26 07:26:01 $\n";
  private String m_ignoreRODFlagOnDeparture = "";

  public ECCOEncode() throws Exception
  {
    m_format = "IMS";
    m_transactionType = "AZT731";
    traceLog("ECCOEncode","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    m_ignoreRODFlagOnDeparture = readConfigVariableString("IGNORE_ROD_AT_DEPARTURE", "N");

    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    return state;
  }

  public void createMessage(CCIIState state,
                            DatabaseBean dbConnection, 
                            Upload upload) throws Exception
  {

    traceLog("ECCOEncode", state);

    int    MAX_PECO         = 102;
    String MAX_PECO_MINUS_4 = "098";
    int    MAX_CECO         = 124; 
    String MAX_CECO_MINUS_4 = "120";


    Date m_convertDt = null;

    String ms_hourMinute   = null;
    String ms_monthDay     = null;

    if (state.getScan().getSysDateTime() > 0)
    {
      // Get Date/Time information from l_sysDateTime
      m_convertDt = new Date(state.getScan().getSysDateTime());

    }
    else
    {
      // Get Date/Time information as current Date/Time
      m_convertDt = new Date();
    }

    // set the calendar to the local timezone
//    System.out.println("ECCOEncode, ready to perform Date conversion for time zone " + m_localTimeZone);

    TimeZone m_timeZone = TimeZone.getTimeZone(m_localTimeZone);       // Comes from LOCAL_TIMEZONE parameter
    Calendar calendar = new GregorianCalendar(m_timeZone);             // Build a Calendar based on m_timeZone
    calendar.setTime(m_convertDt);                                     // Load in the time

//    System.out.println("HOUR " + calendar.get(Calendar.HOUR_OF_DAY));
//    System.out.println("MINUTE " + calendar.get(Calendar.MINUTE));
//    System.out.println("YEAR " + calendar.get(Calendar.YEAR));
//    System.out.println("MONTH " + (calendar.get(Calendar.MONTH)+1));
//    System.out.println("DAY_OF_MONTH " + calendar.get(Calendar.DAY_OF_MONTH));
//    System.out.println("ZONE OFFSET " + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
//    System.out.println("DST OFFSET " + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));

    // set ms_hourMinute in HHMM format
    if (calendar.get(Calendar.HOUR_OF_DAY) < 10)
    {
      ms_hourMinute = "0" + Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    }
    else
    {
      ms_hourMinute = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
    }
    if (calendar.get(Calendar.MINUTE) < 10)
    {
      ms_hourMinute = ms_hourMinute + "0" + Integer.toString(calendar.get(Calendar.MINUTE));
    }
    else
    {
      ms_hourMinute = ms_hourMinute + Integer.toString(calendar.get(Calendar.MINUTE));
    }
//    System.out.println("ECCOEncode, AFTER Time being sent to COSMOS " + ms_hourMinute);

    // set  ms_monthDay    in yyMMDD format  (NOTE: this will break in the year 2100)
    if ((calendar.get(Calendar.YEAR)-2000) < 10)
    {
      ms_monthDay = "0" + Integer.toString(calendar.get(Calendar.YEAR)-2000);
    }
    else
    {
      ms_monthDay = Integer.toString(calendar.get(Calendar.YEAR)-2000);
    }
    if (calendar.get(Calendar.MONTH)+1 < 10)
    {
      ms_monthDay = ms_monthDay + "0" + Integer.toString(calendar.get(Calendar.MONTH)+1);
    }
    else
    {
      ms_monthDay = ms_monthDay + Integer.toString(calendar.get(Calendar.MONTH)+1);
    }
    if (calendar.get(Calendar.DAY_OF_MONTH) < 10)
    {
      ms_monthDay = ms_monthDay + "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    }
    else
    {
      ms_monthDay = ms_monthDay + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    }
    // System.out.println("ECCOEncode, Date being sent to COSMOS " + ms_monthDay);

    // Check if this is a Primary ECCO Scan
    if (state.getCurrentScan().getScanTypeCode().equals("PECO"))                                        // Primary ECCO Scan
    {
      m_outboundEncodedMsg = new byte[MAX_PECO];

      // Initialize all positions to spaces
      for (int i=0; i<MAX_PECO; i++)
      {
        m_outboundEncodedMsg[i] = ' ';
      }
      
      //                   destination, offset, source, offset, count
      moveStringToByteArray(m_outboundEncodedMsg, 0, "P", 1);              //   0 -  1 Primary ECCO Scan
      moveStringToByteArray(m_outboundEncodedMsg, 1, MAX_PECO_MINUS_4, 3); //   1 -  3 Character Number 

      moveStringToByteArray(m_outboundEncodedMsg, 4, upload.getCosmosLocCode(), 5);      //   4  -  5 COSMOS Loc Code
      moveStringToByteArray(m_outboundEncodedMsg, 9, "", 2);               //   9  -  2 Scanner Address ??

      // Based on Airbill Type fill in either Airbill Number or MPS Airbill Number
      if (state.getScan().getAirbillType().equals("6") ||
          state.getScan().getAirbillType().equals("G"))
      {
        // Its an MPS or CRN
        moveStringToByteArray(m_outboundEncodedMsg, 23, state.getScan().getAirbillNumber(), 12); //  23  - 12 MPS Airbill Number    
      }
      else
      {
        // Treat as a normal Airbill
        moveStringToByteArray(m_outboundEncodedMsg, 11, state.getScan().getAirbillNumber(), 12); //  11  - 12 Airbill Number	
      }
      moveStringToByteArray(m_outboundEncodedMsg, 35, ms_monthDay, 6);          //  35  -  6 Arrival Date YYMMDD 
      moveStringToByteArray(m_outboundEncodedMsg, 41, state.getScan().getRouteNumber(), 6); //  41  -  6 Route Number
      moveStringToByteArray(m_outboundEncodedMsg, 47, "", 5);                   //  47  -  5 Origin Location
      moveStringToByteArray(m_outboundEncodedMsg, 52, "", 5);                   //  52  -  5 Destination Location
      moveStringToByteArray(m_outboundEncodedMsg, 57, ms_monthDay, 6);          //  57  -  6 Scan Date YYMMDD
      moveStringToByteArray(m_outboundEncodedMsg, 63, ms_hourMinute, 4);        //  63  -  4 Scan Time HHMM
      moveStringToByteArray(m_outboundEncodedMsg, 67, state.getScan().getUserLogon(), 6);  //  67  -  6 User Logon Id
      if ( state.getIntransitFlag().equals("N") )
      {
        if ( state.getInterceptedFlag().equals("C") )
        {
          moveStringToByteArray(m_outboundEncodedMsg, 73, "3", 1);                //  73  -  1 Comment Code 
                                                          // 'IN CLEARANCE AREA (NO REGULATORY DELAY)' on cosmos
        }
        else 
        {
          moveStringToByteArray(m_outboundEncodedMsg, 73, "2", 1);                //  73  -  1 Comment Code 
                                                          //'IN CLEARANCE AREA' on cosmos
        }
      }
      else
      {
          // This is an Intransit package
          moveStringToByteArray(m_outboundEncodedMsg, 73, "1", 1);
                                                          // 'IN TRANSIT AREA" on cosmos
      }

      moveStringToByteArray(m_outboundEncodedMsg, 74, "", 1);                   //  74  -  1 OverageShortage Code 
      if ( state.getOverageFlag().equals("Y")
           || state.getOverageFlag().equals("M")
           || state.getOverageFlag().equals("DELETED")
           || state.getOverageFlag().equals("SORTDATE")
           || state.getOverageFlag().equals("ROUTE")
           || state.getOverageFlag().equals("D") ) {
        moveStringToByteArray(m_outboundEncodedMsg, 75, "Y", 1);                //  75  -  1 Primary Overage
      }
      moveStringToByteArray(m_outboundEncodedMsg, 76, "", 1);                   //  76  -  1 InTransit
      moveStringToByteArray(m_outboundEncodedMsg, 77, "", 3);                   //  77  -  3 Disposition Type
      moveStringToByteArray(m_outboundEncodedMsg, 80, "", 4);                   //  80  -  4 Commodity Type
      moveStringToByteArray(m_outboundEncodedMsg, 84, "", 14);                  //  84  - 14 Entry Number
      moveStringToByteArray(m_outboundEncodedMsg, 98, state.getScan().getAirbillFormType(), 4); //  98  -  4 Airbill Form Type 
    }

    // Check if this is a Confirmation ECCO Scan
    else if (state.getCurrentScan().getScanTypeCode().equals("CECO"))                                   // Confirmation ECCO
    {
      m_outboundEncodedMsg = new byte[MAX_CECO];

      // Initialize all positions to spaces
      for (int i=0; i<MAX_CECO; i++)
      {
        m_outboundEncodedMsg[i] = ' ';
      }

      //                   destination, offset, source, offset, count
      moveStringToByteArray(m_outboundEncodedMsg, 0, "C", 1);              //   0 -  1 Confirmation ECCO Scan
      moveStringToByteArray(m_outboundEncodedMsg, 1, MAX_CECO_MINUS_4, 3); //   1 -  3 Character Number

      moveStringToByteArray(m_outboundEncodedMsg, 4, upload.getCosmosLocCode(), 5);      //   4  -  5 COSMOS Loc Code
      moveStringToByteArray(m_outboundEncodedMsg, 9, "", 2);               //   9  -  2 Scanner Address ??

      // Based on Airbill Type fill in either Airbill Number or MPS Airbill Number
      if (state.getScan().getAirbillType().equals("6") ||
          state.getScan().getAirbillType().equals("G"))
      {
        // Its an MPS or CRN
        moveStringToByteArray(m_outboundEncodedMsg, 23, state.getScan().getAirbillNumber(), 12); //  23  - 12 MPS Airbill Number
      }
      else
      {
        // Treat as a normal Airbill
        moveStringToByteArray(m_outboundEncodedMsg, 11, state.getScan().getAirbillNumber(), 12); //  11  - 12 Airbill Number
      }
      moveStringToByteArray(m_outboundEncodedMsg, 35, ms_monthDay, 6);          //  35  -  6 Arrival Date YYMMDD
      moveStringToByteArray(m_outboundEncodedMsg, 41, state.getScan().getRouteNumber(), 6); //  41  -  6 Route Number
      // get the shipment to obtain orig and dest
      Shipment shipment;
      try 
      {
        shipment = dbConnection.fetchShipment(state.getScan().getShipmentOid());
      }
      catch (Exception ex) 
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","CECO Shipment fetch failed");
        throw cciiEx;
      }

      if (shipment == null) 
      {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB","CECO Shipment not found");
        throw cciiEx;
      }
      moveStringToByteArray(m_outboundEncodedMsg, 47, shipment.getOriginLocCode(), 5);  
// 47  -  5 Origin Location
      moveStringToByteArray(m_outboundEncodedMsg, 52, shipment.getDestinationLocCode(), 5); // 52  -  5  Destination Location
      moveStringToByteArray(m_outboundEncodedMsg, 57, ms_monthDay, 6);          //  57  -  6 Scan Date YYMMDD
      moveStringToByteArray(m_outboundEncodedMsg, 63, ms_hourMinute, 4);        //  63  -  4 Scan Time HHMM
      moveStringToByteArray(m_outboundEncodedMsg, 67, state.getScan().getUserLogon(), 6);  
//  67  -  6 User Logon Id
      if ( state.getIntransitFlag().equals("N") )
      {
        if (( shipment.getRODFlag().equals("Y") ) &&
            ( m_ignoreRODFlagOnDeparture.equals("N")))
        {
          moveStringToByteArray(m_outboundEncodedMsg, 73, "6", 1);              //  73  -  1 Clearance Complete-ROD
        }
        else
        {
          moveStringToByteArray(m_outboundEncodedMsg, 73, "5", 1);              //  73  -  1 Clearance Complete
        }
      }
      else
      {
        moveStringToByteArray(m_outboundEncodedMsg, 73, "4", 1);                //  73  -  1 Transit Complete
      }
      moveStringToByteArray(m_outboundEncodedMsg, 74, "", 1);                   //  74  -  1 OverageShortage Code
      moveStringToByteArray(m_outboundEncodedMsg, 75, "", 1);                   //  75  -  1 Primary Overage
      moveStringToByteArray(m_outboundEncodedMsg, 76, "", 1);                   //  76  -  1 InTransit
      moveStringToByteArray(m_outboundEncodedMsg, 77, "", 3);                   //  77  -  3 Disposition Type
      moveStringToByteArray(m_outboundEncodedMsg, 80, "", 4);                   //  80  -  4 Commodity Type
      moveStringToByteArray(m_outboundEncodedMsg, 84, "", 14);                  //  84  - 14 Entry Number
      moveStringToByteArray(m_outboundEncodedMsg, 98, "", 10);                  //  98  - 10 ULD Number
      moveStringToByteArray(m_outboundEncodedMsg, 108, "", 1);                  // 108  -  1 Mini Sort Flag
      moveStringToByteArray(m_outboundEncodedMsg, 109, "", 1);                  // 109  -  1 Freight Checked flag
      moveStringToByteArray(m_outboundEncodedMsg, 110, "", 10);                 // 110  - 10 Managers Org Code
      moveStringToByteArray(m_outboundEncodedMsg, 120, 
                            state.getScan().getAirbillFormType(), 4); 
//  98  -  4 Airbill Form Type
    }
    super.createMessage( state, dbConnection, upload);
  }

  private void moveStringToByteArray(byte[] destArray,       // Byte Array to transfer to 
                                     int i_byteOffset,       // Offset into Byte Array to start
                                     String origString,      // String to transfer from
                                     int i_count)            // Count of bytes to transfer
  {
    int  destLoop;
    int  count;
    byte[] holdByte = null;

    holdByte = new byte[origString.length()];
    holdByte = origString.getBytes();

    for (destLoop=i_byteOffset, count=0; count<i_count; destLoop++, count++)
    {
      if (count < origString.length())
      {
        destArray[destLoop] = holdByte[count];
      }
    } 
  }

}

