package cciij.WSUtil;
import cciij.cciidata.CCIIDataVector;
import cciij.cciidata.ScanDefinition;
import java.util.*;
import cciij.util.CCIILogException;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class ScanDefDescription extends CodeDefinition
{
  private static final String m_whatVersion = "@(#) $RCSfile: ScanDefDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public boolean m_activeDefsOnly = true;

  public ScanDefDescription()
  {
  }
  public boolean init(String locationCd)
  {
    m_actionName= "ScanDefDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.SCAN_DEF);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    ScanDefinition scanDef = null;
    Vector data = null;
    String tempString = "";
    if (dataVector.getDataType() != CCIIDataVector.SCAN_DEF)
    {
       String str = "Ack!, was expecting SCAN_DEF type, got this instead: " +  dataVector.getDataType();
       CCIILogException ex = new CCIILogException (CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str);
       m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str,ex,this);
    }
    else
    {
      data = dataVector.getData();
      if (data == null)
      {
        String str = "data in DataVector is Null";
        CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str);
        m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str,ex,this);
        return false;
      }
      else if (data.isEmpty())
      {
        //String str = "data in Data Vector is not null but is empty";
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          scanDef = (ScanDefinition) it.next();
          if (!m_activeDefsOnly || scanDef.getRecordActiveFlag().equalsIgnoreCase("Y"))
          {
            m_codes.add(scanDef.getScanTypeCode());
            if (scanDef.getScanTypeCode().equalsIgnoreCase("STAT"))
            {
              m_definitions.add(scanDef.getScanTypeCode() + " "
                +  scanDef.getLocStatNumber() + ": "
                + scanDef.getScanDescription());
            }
            else
            {
              m_definitions.add( scanDef.getScanTypeCode()
                + ": " + scanDef.getScanDescription());
            }
          }
        }
      }
    }
    return true;
  }
}