package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      Fedex Services
 * @author Lorraine Dominguez
 * @version 1.0
 */

import cciij.cciidata.*;


public class HandlingUnitShipmentAndRoute extends HandlingUnitAndShipment
{
   protected RouteLeg m_route = null;


public HandlingUnitShipmentAndRoute()
{
}

  public HandlingUnitShipmentAndRoute(HandlingUnit hu, Shipment shipment, RouteLeg route)
  {
    addHU(hu);
    addShipment(shipment);
    addRoute(route);
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

  public void addRoute (RouteLeg route)
  {
     m_route = route;
  }


  public HandlingUnit getHU()
  {
    return m_hu;
  }

  public Shipment getShipment()
  {
    return m_shipment;
  }

  public RouteLeg getRoute()
  {
     return m_route;
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

  public String toString()
  {
     String s = "HandlingUnitShipmentAndRoute object \n";
     s += "status = " + m_status;
     s += m_hu.toString();
     s += m_shipment.toString();
     s += m_route.toString();
     return s;
  }
}