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

public class STATDescription extends CodeDefinition
{
  private static final String m_whatVersion = "@(#) $RCSfile: STATDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public boolean m_activeDefsOnly = true;
  public ScanDefinition m_stat37 = null;
  public ScanDefinition m_stat68 = null;
  public ScanDefinition m_stat69 = null;
  public ScanDefinition m_stat77 = null;
  public ScanDefinition m_stat85 = null;
  public ScanDefinition m_stat90 = null;

  public STATDescription()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName= "STATDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.STAT_SCAN_DEF);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    ScanDefinition scanDef = null;
    Vector data = null;
    String tempString = "";
    if (dataVector.getDataType() != CCIIDataVector.STAT_SCAN_DEF)
    {
       String str = "Ack!, was expecting STAT_SCAN_DEF type, got this instead: " +  dataVector.getDataType();
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
            int locStatNumber = 0;
            try
            {
              locStatNumber = Integer.parseInt(scanDef.getLocStatNumber());
            }
            catch (NumberFormatException nfe)
            {
              System.out.println("Unable to format locStatNumber");
            }
            switch (locStatNumber)
            {
              case 37:
                m_stat37 = scanDef;
                break;
              case 68:
                m_stat68 = scanDef;
                break;
              case 69:
                m_stat69 = scanDef;
                break;
              case 77:
                m_stat77 = scanDef;
                break;
              case 85:
                m_stat85 = scanDef;
                break;
              case 90:
                m_stat90 = scanDef;
                break;
              default:
                m_codes.add(scanDef.getLocStatNumber());
                m_definitions.add(scanDef.getScanTypeCode() + " "
                  + scanDef.getLocStatNumber() + ": "
                  + scanDef.getScanDescription());
                break;
            }
          }
        }
      }
    }
    return true;
  }
}