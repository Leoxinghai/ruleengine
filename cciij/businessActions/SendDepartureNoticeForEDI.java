package cciij.businessActions;

import com.oss.asn1.*;
import com.oss.util.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import bondinout.Bondinout;
import bondinout.cciievent.*;
import java.util.Date;
import java.text.*;
import java.io.*;

/*
 * Title:        SendDepartureNoticeForEDI.java     
 * Description:  This class will be used to notify APAC when a package departs
 *               the sort facility.  An ASN message will be created based 
 *               and encoded.  This message will be put on MQ for APAC to 
 *               retrieve.
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx Services
 * @author       Julie McCarthy
 * @version 1.0
 *
 * Modification History:
 *   02/24/03    Julie McCarthy - Initial creation
 *
 *   11/14/2003  Joey Cline    Modified the MQQueue object to be a property
 *                             instead of being a local variable, so that
 *                             the connection manager is not created/destroyed
 *                             with each call.                                 
 *                             Migrated property initialization into the       
 *                             initialize method, since creation of the 
 *                             MQQueue object is dependent on it.
 *
 */
 
public class SendDepartureNoticeForEDI extends SendArrivalNoticeBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: SendDepartureNoticeForEDI.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  
  public SendDepartureNoticeForEDI() throws Exception
  { 
      traceLog("SendDepartureNoticeForEDI","In Constructor");
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
      traceLog("In SendDepartureNoticeForEDI Class", "In doIt Method");
      ScanOut scanOut = new ScanOut();
      byte[]  outboundEncodedASNMsg;
      outboundEncodedASNMsg = createMessage(state, scanOut);
      m_mqQueue.putBytes(outboundEncodedASNMsg);
        
      return state;
  } 

  public byte[] createMessage(CCIIState state, ScanOut scanOut) throws Exception
  { 
      traceLog("In SendDepartureNoticeForEDI Class", "In createMessage Method");
      traceLog("SendDepartureNoticeForEDI", state); 
      
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSS");                
      byte[] outboundASNMsg = null;
      Date m_convertDt = null;
      Date m_scanDt = null;
      String ms_scanDt = null;
      String ms_date   = null;
      String ls_shipmentOid = null;
      String ls_handlingUnitOid = null;
      int li_shipmentOid;
      int li_handlingUnitOid;
    
      // Move the common fields to their position
      scanOut.setAirbillNumber(new IA5String(state.getScan().getAirbillNumber()));
      scanOut.setEventType(new IA5String("BOUT"));
      
      // Convert shipmentOid to a string
      li_shipmentOid = (state.getScan().getShipmentOid());    
      ls_shipmentOid = String.valueOf(li_shipmentOid);  
     
      scanOut.setShipmentOid(new IA5String(ls_shipmentOid)); 
      
      // Convert handlingUnitOid to a string
      li_handlingUnitOid = (state.getScan().getHandlingUnitOid());    
      ls_handlingUnitOid = String.valueOf(li_handlingUnitOid);    

      scanOut.setHandlingUnitOid(new IA5String(ls_handlingUnitOid));    
      
      scanOut.setLocationCode(new IA5String(state.getScan().getLocationCode()));       
      scanOut.setMasterAirbillNumber(new IA5String(state.getScan().getHAWB()));          
      // Format scanDt
      m_scanDt = new Date(state.getScan().getSysDateTime());
      ms_scanDt = dateFormat.format(m_scanDt);
      scanOut.setScanDate(new IA5String(ms_scanDt)); 
    
      // Format millisecondtimestamp
      m_convertDt = new Date();
      ms_date = dateFormat.format(m_convertDt);
      scanOut.setMillisecondtimestamp(new IA5String(ms_date));                          
      // Encode the message into ASN format
      try
      {
          Bondinout.initialize();
          Coder coder = Bondinout.getBERCoder();
          coder.enableAutomaticEncoding();
          coder.disableEncoderDebugging();
          coder.disableEncoderConstraints();
          ByteArrayOutputStream aSink = new ByteArrayOutputStream();
          coder.encode(scanOut, aSink);
          outboundASNMsg = aSink.toByteArray();
      }
      catch (EncodeFailedException efe)
      {
          System.out.println(efe.getLocalizedMessage());
          System.out.println(efe.getReason());
          System.out.println(efe.getMessage());
      }
      
      return outboundASNMsg;
  }

 
  public static void main(String args[]) throws Exception
  {
      SendDepartureNoticeForEDI l_activityLog = new SendDepartureNoticeForEDI();

      CCIIState state = new CCIIState();
      RPBScan scan = new RPBScan();
      scan.setLocationCode("YYZ");
      scan.setAirbillNumber("40033333333");
      scan.setSysDateTime(new Date());
      scan.setHandlingUnitOid(2222);
      scan.setShipmentOid(2222);
      scan.setHAWB("40033333333");
     
      state.setScan(scan);

      java.util.Date startDt = new java.util.Date();
      java.util.Date endDt = null;
      long elapsedMS = 0;
      state = (CCIIState)l_activityLog.actionEntry(state);
    
      endDt = new java.util.Date();
      elapsedMS = endDt.getTime() - startDt.getTime();
      System.out.println("Posting of Send Departure took " + elapsedMS + " ms");

  }

}


