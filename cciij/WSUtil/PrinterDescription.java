package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */
import cciij.WSUtil.CCIIProperties;
import java.util.*;
import cciij.cciidata.CCIIDataVector;
import cciij.util.CCIILogException;

public class PrinterDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: PrinterDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public PrinterDescription()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName= "PrinterDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    m_codes.add(CCIIProperties.NO_PRINTER_DEFINED_CODE);
    m_definitions.add(CCIIProperties.NO_PRINTER_DEFINED_DESC);
    return internalInit(CCIIDataVector.PRINTER_CONFIGURATION);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    cciij.cciidata.PrinterConfiguration def = null;
    Vector data = null;
    if (dataVector.getDataType() != CCIIDataVector.PRINTER_CONFIGURATION)
    {
      //m_notify.traceLog("Hey, Got the wrong data type");
      String str = "Hey, Got the wrong data type: " + dataVector.getDataType();
      CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str);
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str,ex,this);
    }
    else
    {
      data = dataVector.getData();
      if (data == null)
      {
        //m_notify.traceLog("data in DataVector is Null");
        String str = "data in DataVector is Null";
        CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str);
        m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str,ex,this);
        return false;
      }
      //took this condition out as an error condition
      else if (data.isEmpty())
      {
        //m_notify.traceLog("data in Data Vector is not null but is empty");
        //String str = "data in Data Vector is not null but is empty";
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          def = (cciij.cciidata.PrinterConfiguration) it.next();
          m_codes.add(def.getPrinterCode());
          m_definitions.add(def.getPrinterName());
          //m_notify.traceLog(def.getPrinterCode() + " : " + def.getPrinterName());
        }
      }
    }
    return true;
  }
}