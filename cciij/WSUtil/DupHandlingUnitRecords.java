package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
//import cciij.cciilookup.LookupHome;
import cciij.WSUtil.EjbProcessing;
import cciij.cciilookup.Lookup;
import cciij.cciidata.*;
import cciij.WSUtil.WSNotify;
import cciij.util.CCIILogException;

public class DupHandlingUnitRecords implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: DupHandlingUnitRecords.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected Vector m_vecHuAndShipment;
  //protected static LookupHome m_lookupHome;
  protected String m_actionName = "DupHandlingUnitRecords";
  protected WSNotify m_notify = new WSNotify();
  protected EjbProcessing ejbProcess = new EjbProcessing();

  //static
  //{
  //  initEJB();
  //}


  private DupHandlingUnitRecords()
  {
  }

  public DupHandlingUnitRecords(String trackingNumber, String site)
  {
    getDupInfo(trackingNumber,site);
  }

  public Vector getHuAndShipmentVector()
  {
   return m_vecHuAndShipment;
  }

  public Iterator getHuAndShipmentIterator()
  {
    return m_vecHuAndShipment.iterator();
  }

  public boolean hasRecords()
  {
    if (m_vecHuAndShipment == null)
       return false;
    else
      return !m_vecHuAndShipment.isEmpty();
  }

  public boolean getDupInfo(String trackingNumber, String site)
  {
    Lookup lookup = null;
    CCIIDataVector dataVector = null;
    HandlingUnitAndShipment huAndShipment;
    Vector huAndShipmentVec = new Vector();
    boolean retValue = false;
    m_notify.setActionName(m_actionName);
    try
    {
      lookup = ejbProcess.getLookup(site);
      if (lookup != null)
      {
        dataVector = lookup.getDupRecords(trackingNumber, site);
        retValue = true;
      }
      ejbProcess.cleanupLookup(lookup);
    }
    catch (java.rmi.RemoteException re)
    {
     m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_REMOTE_ERROR,"DupHandlingUnitRecords, remote Error",re,this);
    }
    if (dataVector == null)
    {
      //m_notify.traceLog("Dup HandlingUnit Must have had an error data vector is null");
      String str = "Probably had an error since data vector is null";
      CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str);
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str,ex,this);
      return false;
    }
    if (dataVector.getDataType() != CCIIDataVector.HU_AND_SHIPMENT)
    {
      //m_notify.traceLog("Ack!, was expecting HU_AND_SHIPMENT type, got this instead: " +  dataVector.getDataType());
      String str = "Ack!, was expecting HU_AND_SHIPMENT type, got this instead: " +  dataVector.getDataType();
      CCIILogException ex = new CCIILogException (CCIIProperties.WS_ERROR_DUP_HU_WRONG_DATA_TYPE,str);
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_WRONG_DATA_TYPE,str,ex,this);

      /*Vector data = dataVector.getData();

      if (data == null)
      {
        String str = "data in DataVector is Null";
        CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str);
        m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str,ex,this);
        retValue = false;

      } else if (data.isEmpty())
      {
        //m_notify.traceLog("data vector is no elements");
        String str = "data in Data Vector is not null but is empty";
        CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_DUP_HU_EMPTY_DATA,str);
        m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_EMPTY_DATA,str,ex,this);
      }
      else
      {
        for (Iterator it = data.iterator(); it.hasNext();)
        {
          Object obj = it.next();
          //m_notify.traceLog("Data Vector element " + obj);
        }
      }
      */
      retValue = false;
    }
    if (retValue)
    {
      m_vecHuAndShipment = dataVector.getData();
      if (m_vecHuAndShipment == null)
      {
        //m_notify.traceLog("Ack!,HU and Shipment Vector is null after retrieve");
        String str = "data in DataVector is Null";
        CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str);
        m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_NULL_DATA,str,ex,this);
        retValue = false;
      }
      //took this condition out as an error condition
      else if (m_vecHuAndShipment.isEmpty())
      {
      //  //m_notify.traceLog("Hmmm..., HU and Shipment vector is not null, but it is empty");
      //  String str = "data in Data Vector is not null but is empty";
      //  CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_DUP_HU_EMPTY_DATA,str);
      //  m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_DUP_HU_EMPTY_DATA,str,ex,this);
      }
    }
    return retValue;
  }

}