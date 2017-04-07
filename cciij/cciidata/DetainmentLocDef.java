package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author       Lorraine Dominguez
 * @version 1.0
 *
 * Modification history:
 * 4/29/2003     Initial Creation
 */

import java.io.Serializable;


public class DetainmentLocDef implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: DetainmentLocDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCd = "";
  private String m_warehouseCd = "";
  private String m_stagingAreaCd = "";
  private String m_detainmentLocCd = "";
  private String m_detainmentLocDesc = "";

  public DetainmentLocDef()
  {
  }

  public DetainmentLocDef(String locationCd,
                        String warehouseCd,
                        String stagingAreaCd,
                        String detainmentLocCd,
                        String detainmentLocDesc)

  {
     m_locationCd = locationCd;
     setLocationCd(locationCd);
     setWarehouseCd(warehouseCd);
     setStagingAreaCd(stagingAreaCd);
     setDetainmentLocCd(detainmentLocCd);
     setDetainmentLocDesc(detainmentLocDesc);
  }


  protected void finalize()
  {
  }

  public String getLocationCd()
  {
    return m_locationCd;
  }


  public String getWarehouseCd()
  {
    return m_warehouseCd;
  }

  public String getStagingAreaCd()
  {
    return m_stagingAreaCd;
  }

  public String getDetainmentLocCd()
  {
    return m_detainmentLocCd;
  }

  public String getDetainmentLocDesc()
  {
    return m_detainmentLocDesc;
  }


  public void setLocationCd(String s)
  {
     if(s == null)
     {
        m_locationCd = "";
     }
     else
     {
        m_locationCd = s;
     }
   }


   public void setWarehouseCd(String s)
   {
      if (s == null)
      {
        m_warehouseCd = "";
      }
      else
      {
        m_warehouseCd = s;
      }
    }


   public void setStagingAreaCd(String s)
   {
      if (s == null)
      {
        m_stagingAreaCd = "";
      }
      else
      {
        m_stagingAreaCd = s;
      }
   }


   private void setDetainmentLocCd(String s)
   {
      if(s == null)
      {
         m_detainmentLocCd = "";
      }
      else
      {
        m_detainmentLocCd = s;
      }
   }


   public void setDetainmentLocDesc(String s)
   {
      if( s == null)
      {
         m_detainmentLocDesc = "";
      }
      else
      {
         m_detainmentLocDesc = s;
      }
    }


   public String toString()
   {
      String s = "";
         s +=  "DetainmentLocDef object -- " + "\n";
         s += "locationCd                               : " + m_locationCd+ "\n";
         s += "warehouseCd                              : " + m_warehouseCd+ "\n";
         s += "stagingAreaCd                            : " + m_stagingAreaCd+ "\n";
         s += "detainmentLocCd                          : " + m_detainmentLocCd+ "\n";
         s += "detainmentLocDesc                        : " + m_detainmentLocDesc+ "\n";

      return s;
  }

}

