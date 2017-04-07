package cciij.businessActions;

import com.oss.asn1.*;
import com.oss.util.*;
import cciiftn.*;
import cciiftn.ftnupld.*;
import cciij.util.ByteQueueWriter;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import java.util.Date;
import java.util.Vector;
import java.text.*;
import java.io.*;

/**
 * <p>Title: WriteMsgToFTN</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class WriteMsgToFTN extends BusinessActionBase {

  private String m_broker_agency_code = null;
  private String m_queueName = "FTN_OUTBOUND_QUEUE";
  private ByteQueueWriter m_outboundQueue = null;
  
  public WriteMsgToFTN() throws Exception
  {
    super("WriteMsgToFTN");
    traceLog("WriteMsgToFTN","In Constructor");
  }

  protected void readSiteConfigVariables () throws Exception
  {
    super.readSiteConfigVariables();
    // get the broker agency id
    m_broker_agency_code = readConfigVariableString("BROKER_AGENCY_CODE", "BK");  
  }

  /**
   *
   * @param state
   * @param db
   * @return
   * @throws java.lang.Exception
   */
  public CCIIState doIt(CCIIState state, DatabaseBean db) throws java.lang.Exception
  {
    FTNUpldTran tran = new FTNUpldTran();
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyMMddHHmmss");                
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHH");                
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    // Initialize the ASN transaction Coder
    Cciiftn.initialize();
    Coder coder = Cciiftn.getBERCoder();
    coder.enableAutomaticDecoding();
    coder.enableAutomaticEncoding();
    coder.disableDecoderDebugging();
    coder.disableEncoderDebugging();
    coder.disableDecoderConstraints();
    coder.disableEncoderConstraints();

    //A state is passed in.  It contains a reference (shipmentOidNbr) to a shipment.
    //Read the shipment record to get mawb, hawb, entryCategoryTypeCode,
      // entryCategorySourceCode, EntryRecurringCriteriaFlg
    traceLog("WriteMsgToFTN.doIt()", " lookup the shipment");
    traceLog("WriteMsgToFTN.doIt()", " shipment:: " + state.getScan().getShipmentOid());
    Shipment shp = null;
    try
    {
      shp = db.fetchShipment(state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      traceLog("WriteMsgToFTN.doIt()","caught exception fetching shipment:: " + ex );
      ex.printStackTrace();
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.setAbortFlag(true);
      return state;
    }

    if ( shp == null )
    {
      traceLog("WriteMsgToFTN.doIt()", " fetch returned null shipment ");
      state.getScan().setErrorNumber(Messages.EM_NOT_FOUND);
      state.setAbortFlag(true);
      return state;
    }
    else
    {
      traceLog("WriteMsgToFTN.doIt()", " fetch returned shipment:: " + shp);

      tran.setMawbNbr(new IA5String(shp.getMawbNbr()));
      tran.setHawbNbr(new IA5String(shp.getAWBNumber()));
      //tran.setSubHouseNbr(new IA5String(shp.getSubHouseNbr()));   Not Yet Defined
      tran.setEntryCategoryTypeCode(new IA5String(shp.getEntryCategoryTypeCode()));
      tran.setEntryCategorySourceCode(new IA5String(shp.getEntryCategorySourceCode()));
      //tran.setEntryRecurringCriteriaFlag(new IA5String(shp.getEntryRecurringCriteriaFlag()));   Do we set this?
    }
      
    //Read a routeLeg with destinationLoc = OAK to get routeNbr, routeDate, arrivalDate
    traceLog("WriteMsgToFTN.doIt()", " lookup the routeLeg by shipmentOid");
    traceLog("WriteMsgToFTN.doIt()", " shipmentOid:: " + state.getScan().getShipmentOid());
    RouteLeg rl = null;
    try
    {
      rl = db.fetchRouteLeg(db.getLocationCode(),  // this may have to be the LOC's COSMOS LOC to match routing
                            state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      traceLog("WriteMsgToFTN.doIt()","caught exception fetching routeLeg:: " + ex );
      ex.printStackTrace();
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.setAbortFlag(true);
      return state;
    }

    if ( rl == null )
    {
      traceLog("WriteMsgToFTN.doIt()", " fetch returned null routeLeg ");
      state.getScan().setErrorNumber(Messages.IM_NOT_FOUND);
    }
    else
    {
      traceLog("WriteMsgToFTN.doIt()", " fetch returned routeLeg:: " + rl);

      tran.setRouteNbr(new IA5String(rl.getRouteNumber()));
      tran.setRouteDate(new IA5String(dateFormat.format(rl.getRouteDate())));
      tran.setArrivalDate(new IA5String(dateFormat.format(rl.getArrivalLocalTimestamp())));

      //Read a routeLegTrip (flightInfo) to get flightNbr, flightDate
      traceLog("WriteMsgToFTN.doIt()", " lookup the flightInfo by routeNbr, routeLegNbr, routeDate");
      traceLog("WriteMsgToFTN.doIt()", " routeNbr:: " + rl.getRouteNumber());
      traceLog("WriteMsgToFTN.doIt()", " routeLegNbr:: " + rl.getRouteLegNumber());
      traceLog("WriteMsgToFTN.doIt()", " routeDate:: " + rl.getRouteDate());
      FlightInfo fi = null;
      try
      {
        fi = db.fetchFlightInfo(rl.getRouteNumber(),
                                rl.getRouteLegNumber(),
                                rl.getRouteDate());
      }
      catch (Exception ex)
      {
        traceLog("WriteMsgToFTN.doIt()","caught exception fetching flightInfo:: " + ex );
        ex.printStackTrace();
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        state.setAbortFlag(true);
        return state;
      }

      if ( fi == null )
      {
        traceLog("WriteMsgToFTN.doIt()", " fetch returned null flightInfo ");
        state.getScan().setErrorNumber(Messages.IM_NOT_FOUND);
      }
      else
      {
        traceLog("WriteMsgToFTN.doIt()", " fetch returned flightInfo:: " + fi);

        tran.setFlightNbr(new IA5String(fi.getTravelPlanNbr()));
        tran.setFlightDate(new IA5String(dateFormat.format(fi.getScheduledDepartureDt())));
      }
    }  
      
    //Read intercepts for the shipment (excluding those restricted by security)
    traceLog("WriteMsgToFTN.doIt()", " lookup the intercepts by shipmentOid");
    traceLog("WriteMsgToFTN.doIt()", " shipmentOid:: " + state.getScan().getShipmentOid());
    Intercept i = null;
    try
    {
      i = db.fetchInterceptSecuredWithActiveFlag(state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      traceLog("WriteMsgToFTN.doIt()","caught exception fetching routeLeg:: " + ex );
      ex.printStackTrace();
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.setAbortFlag(true);
      return state;
    }
    
    //tran.setAgg1(new Agg1());
    //tran.setAgg2(new Agg2());

    while ( i != null )
    {
      traceLog("WriteMsgToFTN.doIt()", " fetch returned intercept:: " + i);
      
      //If broker intercept, add full details
      if (i.getAgencyCode().equals(m_broker_agency_code))
      {
        BrokerIntercepts bkInts = new BrokerIntercepts();

        bkInts.setInterceptCode(new IA5String(i.getInterceptCode()));
        bkInts.setCreateDate(new IA5String(dateTimeFormat.format(i.getCreateDate())));
        bkInts.setCreateEmployeeNumber(new IA5String(i.getEmployeeNumberForCreation()));
        bkInts.setRecurringCriteriaFlag(new IA5String(i.getFromRecurringCriteriaFlag()));
        bkInts.setUpdateDate(new IA5String(dateTimeFormat.format(i.getDateUpdated())));
        bkInts.setUpdateEmployeeNumber(new IA5String(i.getEmployeeNumberForUpdate()));
        
        tran.getAgg1().add(bkInts);
      }
      //else, add selecting agency
      else
      {
        InterceptingAgencies intAgs = new InterceptingAgencies();
        
        intAgs.setAgencyCode(new IA5String(i.getAgencyCode()));
        
        tran.getAgg2().add(intAgs);
      }

      try
      {
        i = db.fetchNextIntercept();
      }
      catch (Exception ex)
      {
        traceLog("WriteMsgToFTN.doIt()","caught exception fetching next routeLeg:: " + ex );
        ex.printStackTrace();
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        state.setAbortFlag(true);
        return state;
      }
    }
    
    //ASN encode the message
    coder.encode(tran,baos);

    //Queue the message
    try
    {
      if (m_outboundQueue == null)
      {
        m_outboundQueue = new ByteQueueWriter();
      }
      m_outboundQueue.putOnQueue(m_queueName, db.getLocationCode(), baos.toByteArray());
    }
    catch (Exception ex)
    {
      traceLog("WriteMsgToFTN.doIt()","caught exception writing to JMS queue:: " + ex );
      ex.printStackTrace();
      state.getScan().setErrorNumber(Messages.EM_QUEUE_ERR);
      state.setAbortFlag(true);
      return state;
    }
    
    return state;
  }

  public static void main(String[] args) throws Exception
  {
  //  WriteMsgToFTN findEntryTypeCode1 = new WriteMsgToFTN();
  }

}
