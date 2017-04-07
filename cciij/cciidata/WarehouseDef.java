package cciij.cciidata;

/**
 * Title:        WarehouseDefinition Role Class
 * Description:  Models WAREHOUSE_DEF table
 * Copyright:    Copyright (c) 2003
 * Company:      Fedex Services
 * @author:      Srinivas Jawaji
 * @version 1.0
 */
import java.util.*;
import java.io.Serializable;

public class WarehouseDef implements Serializable{

  private static final String m_whatVersion = "@(#) $RCSfile: WarehouseDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode ;
  private String m_warehouseCode ;
  private String m_warehouseDescription ;


  /**
   * WarehouseDefinition
   */
  public WarehouseDef()
  {
  }


  /**
   * WarehouseDef
   * @param String locationCode
   * @param String warehouseCode
   * @param String warehouseDescription
   */
  public WarehouseDef(String locationCode,
                      String warehouseCode,
                      String warehouseDescription)
  {
    setLocationCode(locationCode);
    setWarehouseCode(warehouseCode);
    setWarehouseDescription(warehouseDescription);
  }

 /**
  * finalize
  */
  protected void finalize()
  {
  }

 /**
  * getLocationCode
  * @return String
  */
  public String getLocationCode()
  {
    return m_locationCode;
  }

 /**
  * getWarehouseCode
  * @return String
  */
  public String getWarehouseCode()
  {
    return m_warehouseCode;
  }

 /**
  * getWarehouseDescription
  * @return String
  */
  public String getWarehouseDescription()
  {
    return m_warehouseDescription;
  }

  /**
   * setLocationCode
   * @param String
   */
  public void setLocationCode(String s)
  {
      if(s == null)
      {
        m_locationCode = "";
      }
      else
      {
        m_locationCode = s;
      }
  }

  /**
   * setWarehouseCode
   * @param String
   */
  public void setWarehouseCode(String s)
  {
      if(s == null)
      {
        m_warehouseCode = "";
      }
      else
      {
        m_warehouseCode = s;
      }
  }

  /**
   * setWarehouseDescription
   * @param String
   */
  public void setWarehouseDescription(String s)
  {
      if(s == null)
      {
        m_warehouseDescription = "";
      }
      else
      {
        m_warehouseDescription = s;
      }
  }

  /**
   * toString
   * @return String
   */
  public String toString()
   {
       StringBuffer sb = new StringBuffer() ;

       sb.append("WarehouseDef object --\n");
       sb.append("locationCode         : " + m_locationCode+ "\n");
       sb.append("warehouseCode        : " + m_warehouseCode+ "\n");
       sb.append("warehouseDescription : " + m_warehouseDescription+"\n");
       return sb.toString();
   }
}