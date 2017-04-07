/*
 * Created on Mar 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.cih.datamanager;

import com.fedex.cih.vo.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface DataManagerInterface
{

    public abstract void closeConnection()
        throws RemoteException, Exception;

    public abstract boolean commitTransaction()
        throws RemoteException, Exception;

    public abstract boolean rollbackTransaction()
        throws RemoteException, Exception;

    public abstract ShipmentInfo fetchShipment(int shipment_oid)
        throws RemoteException, SQLException;


    public abstract ShipmentInfo fetchNextShipment()
        throws RemoteException, SQLException;

    public abstract void saveShipment(ShipmentInfo shipmentinfo)
        throws RemoteException, SQLException;

    public abstract void updateShipment(ShipmentInfo shipmentinfo)
        throws RemoteException, SQLException;

    public abstract void removeShipment(ShipmentInfo shipmentinfo)
        throws RemoteException, SQLException;


    public abstract DeliveryAddressInfo fetchDeliveryAddress(int shipment_oid)
        throws RemoteException, SQLException;

    public abstract DeliveryAddressInfo fetchNextDeliveryAddress()
        throws RemoteException, SQLException;

    public abstract void saveDeliveryAddress(DeliveryAddressInfo deliveryAddressInfo)
        throws RemoteException, SQLException;

    public abstract void updateDeliveryAddress(DeliveryAddressInfo deliveryAddressInfo)
        throws RemoteException, SQLException;

    public abstract void removeDeliveryAddress(DeliveryAddressInfo deliveryAddressInfo)
        throws RemoteException, SQLException;

    public abstract ShipmentStatus fetchShipmentStatus(int shipmentOid, String statusTypeCode)
        throws RemoteException, SQLException;

    public abstract ShipmentStatus fetchNextShipmentStatus()
        throws RemoteException, SQLException;
}