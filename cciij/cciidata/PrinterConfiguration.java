package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 *  *
 * Modification history:
 * 3/11/2003    Tom Knobeloch  modified members and methods to handle the addition
 *                             of FORM_TYPE_CD in the database table definition as
 *                             a new member.
 * 1/13/2003    Tom Knobeloch  modified members and methods to handle the addition
 *                             of LOCATION_CD in the database table definition as
 *                             a new member.  added new instantiation method with
 *                             eight parameters.
 */

import java.io.Serializable;

public class PrinterConfiguration implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: PrinterConfiguration.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_locationCode = "";
  private String m_printerCode = "";
  private String m_printerType = "";
  private String m_printerName = "";
  private String m_printerParameterOne = "";
  private String m_printerParameterTwo = "";
  private String m_printerParameterThree = "";
  private String m_printerParameterFour = "";
  private String m_formatTypeCode = "";

  /**
   * PrinterConfiguration
   */
  public PrinterConfiguration()
  {

  }

  /**
   * PrinterConfiguration
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public PrinterConfiguration(String locationCode,
                              String printerCode,
                              String printerType,
                              String printerName,
                              String printerParameterOne,
                              String printerParameterTwo,
                              String printerParameterThree,
                              String printerParameterFour,
                              String formatTypeCode)
  {
     setLocationCode(locationCode);
     setPrinterCode(printerCode);
     setPrinterType(printerType);
     setPrinterName(printerName);
     setPrinterParameterOne(printerParameterOne);
     setPrinterParameterTwo(printerParameterTwo);
     setPrinterParameterThree(printerParameterThree);
     setPrinterParameterFour(printerParameterFour);
     setFormatTypeCode(formatTypeCode);
  }

  /**
   * PrinterConfiguration
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   * @param String
   */
  public PrinterConfiguration(String printerCode,
                              String printerType,
                              String printerName,
                              String printerParameterOne,
                              String printerParameterTwo,
                              String printerParameterThree,
                              String printerParameterFour)
  {
     this("", printerCode, printerType, printerName, printerParameterOne,
          printerParameterTwo, printerParameterThree, printerParameterFour, "");
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
   * getPrinterCode
   * @return String
   */
  public String getPrinterCode()
  {
     return m_printerCode;
  }

  /**
   * getPrinterType
   * @return String
   */
  public String getPrinterType()
  {
     return m_printerType;
  }

  /**
   * getPrinterName
   * @return String
   */
  public String getPrinterName()
  {
     return m_printerName;
  }

  /**
   * getPrinterParameterOne
   * @return String
   */
  public String getPrinterParameterOne()
  {
     return m_printerParameterOne;
  }

  /**
   * getPrinterParameterTwo
   * @return String
   */

  public String getPrinterParameterTwo()
  {
     return m_printerParameterTwo;
  }

  /**
   * getPrinterParameterThree
   * @return String
   */
  public String getPrinterParameterThree()
  {
     return m_printerParameterThree;
  }

  /**
   * getPrinterParameterFour
   * @return String
   */
  public String getPrinterParameterFour()
  {
     return m_printerParameterFour;
  }

  /**
   * getFormatTypeCode
   * @return String
   */
  public String getFormatTypeCode()
  {
     return m_formatTypeCode;
  }

  /**
   * setLocationCode
   * @param String
   */
  private void setLocationCode(String s)
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
   * setPrinterCode
   * @param String
   */
  private void setPrinterCode(String s)
  {
    if(s == null)
    {
       m_printerCode = "";
    }
    else
    {
       m_printerCode = s;
    }
  }

  /**
   * setPrinterType
   * @param String
   */
  public void setPrinterType(String s)
  {
    if(s == null)
    {
       m_printerType = "";
    }
    else
    {
       m_printerType = s;
    }
  }

  /**
   * setPrinterName
   * @param String
   */
  public void setPrinterName(String s)
  {
    if(s == null)
    {
       m_printerName = "";
    }
    else
    {
       m_printerName = s;
    }
  }

  /**
   * setPrinterParameterOne
   * @param String
   */
  public void setPrinterParameterOne(String s)
  {
    if(s == null)
    {
       m_printerParameterOne = "";
    }
    else
    {
       m_printerParameterOne = s;
    }
  }

  /**
   * setPrinterParameterTwo
   * @param String
   */
  public void setPrinterParameterTwo(String s)
  {
    if(s == null)
    {
       m_printerParameterTwo = "";
    }
    else
    {
       m_printerParameterTwo = s;
    }
  }

  /**
   * setPrinterParameterThree
   * @param String
   */
  public void setPrinterParameterThree(String s)
  {
    if(s == null)
    {
       m_printerParameterThree = "";
    }
    else
    {
       m_printerParameterThree = s;
    }
  }

  /**
   * setPrinterParameterFour
   * @param String
   */
  public void setPrinterParameterFour(String s)
  {
    if(s == null)
    {
       m_printerParameterFour = "";
    }
    else
    {
       m_printerParameterFour = s;
    }
  }

  /**
   * setFormatTypeCode
   * @param String
   */
  public void setFormatTypeCode(String s)
  {
    if(s == null)
    {
       m_formatTypeCode = "";
    }
    else
    {
       m_formatTypeCode = s;
    }
  }

  /**
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

      s +=  "PrinterConfiguration object -- " + "\n";

      s += "locationCode          : " + m_locationCode+ "\n";
      s += "printerCode           : " + m_printerCode+ "\n";
      s += "printerType           : " + m_printerType+ "\n";
      s += "printerName           : " + m_printerName+ "\n";
      s += "printerParameterOne   : " + m_printerParameterOne+ "\n";
      s += "printerParameterTwo   : " + m_printerParameterTwo+ "\n";
      s += "printerParameterThree : " + m_printerParameterThree+ "\n";
      s += "printerParameterFour  : " + m_printerParameterFour+ "\n";
      s += "formatTypeCode        : " + m_formatTypeCode+ "\n";
      return s;
   }
}