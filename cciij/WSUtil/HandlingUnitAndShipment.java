package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */
import cciij.cciidata.*;

public class HandlingUnitAndShipment implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnitAndShipment.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected HandlingUnit m_hu = null;
  protected Shipment m_shipment = null;
  protected String m_status = "";

  public HandlingUnitAndShipment()
  {
  }

  public HandlingUnitAndShipment(HandlingUnit hu)
  {
    addHU(hu);
  }
  public HandlingUnitAndShipment(Shipment shipment)
  {
    addShipment(shipment);
  }
  public HandlingUnitAndShipment(HandlingUnit hu, Shipment shipment)
  {
    addHU(hu);
    addShipment(shipment);
  }

  public void addHU(HandlingUnit hu)
  {
    if (hu != null)
       m_hu = hu;
  }

  public void addShipment(Shipment shipment)
  {
    if (shipment != null)
       m_shipment = shipment;
  }

  public HandlingUnit getHU()
  {
    return m_hu;
  }

  public Shipment getShipment()
  {
    return m_shipment;
  }

  public String getStatus()
  {
    return m_status;
  }
  public void setStatus(String status)
  {
    if (status != null)
       m_status = status;
    else
      m_status = "";
  }
}