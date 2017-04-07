package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class ScanResultOldTux implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ScanResultOldTux.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  private int oid = 0;
  private String awb = "";
  private String hawb = "";
  private String formType = "";
  private String scanName = "";
  private String scanCode = "";
  private int scanResultCode = 0;
  private String scanResult = "";

  public ScanResultOldTux()
  {
  }

  public ScanResultOldTux(String awbIn,String scanNameIn,String scanCodeIn,
          int scanResultCodeIn,String scanResultIn)
  {
     if (awbIn != null) awb = awbIn;
     if (scanNameIn != null) scanName = scanNameIn;
     if (scanCodeIn != null) scanCode = scanCodeIn;
     if (scanResultIn != null) scanResult = scanResultIn;
     scanResultCode = scanResultCodeIn;
  }

  public int getOid()
  {
    return oid;
  }
  public void setOid(int newValue)
  {
    oid = newValue;
  }

  public String getAWB()
  {
    return awb;
  }

  public boolean setAWB(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      awb = newValue;
    }
    return retValue;
  }

  public String getHAWB()
  {
    return hawb;
  }

  public boolean setHAWB(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      hawb = newValue;
    }
    return retValue;
  }

  public String getFormType()
  {
    return formType;
  }

  public boolean setFormType(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      formType = newValue;
    }
    return retValue;
  }

  public String getScanName()
  {
    return scanName;
  }

  public boolean setScanName(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      scanName = newValue;
    }
    return retValue;
  }

  public String getScanCode()
  {
    return scanCode;
  }

  public boolean setScanCode(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      scanCode = newValue;
    }
    return retValue;
  }

  public int getScanResultCode()
  {
    return scanResultCode;
  }
  public void setScanResultCode(int newValue)
  {
    scanResultCode = newValue;
  }

  public String getScanResult()
  {
    return scanResult;
  }

  public boolean setScanResult(String newValue)
  {
    boolean retValue = false;
    if (newValue != null)
    {
      retValue = true;
      scanResult = newValue;
    }
    return retValue;
  }


  public static void main(String[] args)
  {
    ScanResultOldTux scanResult1 = new ScanResultOldTux();
  }

}