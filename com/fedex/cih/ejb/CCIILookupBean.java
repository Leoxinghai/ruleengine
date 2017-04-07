/*
 * Created on Oct 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.ejb;

import com.fedex.cih.vo.*;
import com.fedex.cih.datamanager.DataManagerImpl;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.*;

import javax.ejb.*;


/**
 *
 * <!-- begin-user-doc --> A generated session bean <!-- end-user-doc --> *
 <!-- lomboz.beginDefinition -->
 <?xml version="1.0" encoding="UTF-8"?>
 <lomboz:EJB xmlns:j2ee="http://java.sun.com/xml/ns/j2ee" xmlns:lomboz="http://lomboz.objectlearn.com/xml/lomboz">
 <lomboz:session>
 <lomboz:sessionEjb>
 <j2ee:display-name>CCIILookup</j2ee:display-name>
 <j2ee:ejb-name>ccii.rplarge1cons</j2ee:ejb-name>
 <j2ee:ejb-class>com.fedex.cih.ejb.CCIILookupBean</j2ee:ejb-class>
 <j2ee:session-type>Stateless</j2ee:session-type>
 <j2ee:transaction-type>Container</j2ee:transaction-type>
 </lomboz:sessionEjb>
 </lomboz:session>
 </lomboz:EJB>
 <!-- lomboz.endDefinition -->
 *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="CCIILookup"	
 *           jndi-name="ccii.cihLookup"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */
public class CCIILookupBean
implements SessionBean
{

public CCIILookupBean()
{
}

public void ejbCreate()
    throws CreateException
{
}

public void setSessionContext(SessionContext cntx)
    throws EJBException, RemoteException
{
    m_SessionContext = cntx;
}

public void ejbRemove()
    throws EJBException, RemoteException
{
}

public void ejbActivate()
    throws EJBException, RemoteException
{
}

public void ejbPassivate()
    throws EJBException, RemoteException
{
}

/**
 * @ejb.interface-method
 *	view-type="remote" 
**/
public ShipmentInfo getShipmentInfo(int aShipmentId, String aLocation)
    throws RemoteException
{
	ShipmentInfo info = null;
	ShipmentStatus status = null;
	try
    {
        DataManagerImpl datamanagerimpl = new DataManagerImpl();
        info = datamanagerimpl.fetchShipment(aShipmentId);
        status = datamanagerimpl.fetchShipmentStatus(aShipmentId,"S");
        datamanagerimpl.closeConnection();
    }
    catch(Exception exception)
    {
        exception.printStackTrace();
        return null;
    }
    
    String statusCd = "";
    String clearenceStatus = "";
    String decFlag = "";
    if(status != null) {
//    	decFlag = 
		if(decFlag == null || decFlag.equals("N")) {
		    clearenceStatus = "NDEC";
		    info.setClearanceStatus(clearenceStatus);
		    info.setDestLocationCode(aLocation);
		    info.setShipmentOid(aShipmentId);
		    System.out.println(" Shipment Info " + info.toString());
		    return info;
		}
        statusCd = status.getStatusCode();
	    if(statusCd == null) {
	        clearenceStatus = "DEC";
	        info.setClearanceStatus(clearenceStatus);
	        info.setDestLocationCode(aLocation);
	        info.setShipmentOid(aShipmentId);
	        info.setBondTransfered(false);
	        return info;
	    } else if(statusCd.equals("CLRD") || !statusCd.equals("BPCL")) {
	        clearenceStatus = "CLEAR";
	        info.setClearanceStatus(clearenceStatus);
	        info.setDestLocationCode(aLocation);
	        info.setShipmentOid(aShipmentId);
	        info.setBondTransfered(false);
	        return info;
	    } else if(statusCd.equals("1")) {
	        clearenceStatus = "CAT1";
	        info.setClearanceStatus(clearenceStatus);
	        info.setDestLocationCode(aLocation);
	        info.setShipmentOid(aShipmentId);
	        info.setBondTransfered(false);
	        return info;
		} else if(statusCd.equals("BXFR")) {
	        clearenceStatus = "DEC";
	        info.setClearanceStatus(clearenceStatus);
	        info.setDestLocationCode(aLocation);
	        info.setShipmentOid(aShipmentId);
	        info.setBondTransfered(true);
	        System.out.println("In BXFR Flag : " + info.getBondTransfered());
	        return info;
	    } else {
	        clearenceStatus = "DEC";
	        info.setClearanceStatus(clearenceStatus);
	        info.setDestLocationCode(aLocation);
	        info.setShipmentOid(aShipmentId);
	        info.setBondTransfered(false);
	        return info;
	    }
    }
    return info;
}
/**
 * @ejb.interface-method
 *	view-type="remote" 
**/
public DeliveryAddressInfo getDeliveryAddressInfo(int oid, char aOIdType, String aLocation)
    throws RemoteException
{
	DeliveryAddressInfo deliveryAddress = null;
	try
    {
        DataManagerImpl datamanagerimpl = new DataManagerImpl();
        deliveryAddress = datamanagerimpl.fetchDeliveryAddress(oid);
        datamanagerimpl.closeConnection();
    }
    catch(Exception exception)
    {
        exception.printStackTrace();
        return null;
    }
    return deliveryAddress;
}

private DeliveryAddressInfo loadDeliveryAddressInfoByOJB(int oid, char Type, String aLocation)
{
	DeliveryAddressInfo deliveryAddress = null;
	try
    {
        DataManagerImpl datamanagerimpl = new DataManagerImpl();
        deliveryAddress = datamanagerimpl.fetchDeliveryAddress(oid);
        datamanagerimpl.closeConnection();
    }
    catch(Exception exception)
    {
        exception.printStackTrace();
        return null;
    }
    return deliveryAddress;
}

private ShipmentInfo getCoreShipmentRef(int aShipmentId, String aLocation)
    throws RemoteException
{
	ShipmentInfo shipment = null;
	try
    {
        DataManagerImpl datamanagerimpl = new DataManagerImpl();
        shipment = datamanagerimpl.fetchShipment(aShipmentId);
        datamanagerimpl.closeConnection();
    }
    catch(Exception exception)
    {
        exception.printStackTrace();
        return null;
    }
    return shipment;
}

private ShipmentStatus getCoreShpStatus(int aShipmentId, String statusTypeCodee)
    throws RemoteException
{
	ShipmentStatus shipment = null;
    	try
        {
            DataManagerImpl datamanagerimpl = new DataManagerImpl();
            shipment = datamanagerimpl.fetchShipmentStatus(aShipmentId,statusTypeCodee);
            datamanagerimpl.closeConnection();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return shipment;
}


public void testShipmentRef()
{
}

public static void main(String ar[])
    throws Exception
{
    System.out.println("Testing ..");
    CCIILookupBean bean = new CCIILookupBean();
    bean.getShipmentInfo(34131, "NRT");
}

private SessionContext m_SessionContext;
private final String PIECE = "P";
private final String SHIP = "S";
private final String IPD = "ID";
private final String NONTX = "nonTX";
}
