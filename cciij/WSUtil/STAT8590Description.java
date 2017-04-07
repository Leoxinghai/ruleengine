package cciij.WSUtil;
import cciij.WSUtil.CCIIProperties;
import cciij.cciidata.ScanDefinition;
import cciij.cciidata.CCIIDataVector;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class STAT8590Description extends CodeDefinition
{
  private static final String m_whatVersion = "@(#) $RCSfile: STAT8590Description.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public ScanDefinition m_stat85 = null;
  public ScanDefinition m_stat90 = null;

  public STAT8590Description()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName= "STATDescription";
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    STATDescription statDesc = new STATDescription();
    statDesc.init(locationCd);
    m_locationCd = locationCd;
    m_stat85 = statDesc.m_stat85;
    m_stat90 = statDesc.m_stat90;
    addValues(null);
    return true;
  }

  public boolean addValues(CCIIDataVector dataVector)
  {
    if (m_stat85 != null && m_stat85.getRecordActiveFlag().equals("Y"))
    {
      m_codes.add(m_stat85.getLocStatNumber());
      m_definitions.add(m_stat85.getScanTypeCode() + " "
                  + m_stat85.getLocStatNumber() + ": "
                  + m_stat85.getScanDescription());
    }
    if (m_stat90 != null && m_stat90.getRecordActiveFlag().equals("Y"))
    {
      m_codes.add(m_stat90.getLocStatNumber());
      m_definitions.add(m_stat90.getScanTypeCode() + " "
                  + m_stat90.getLocStatNumber() + ": "
                  + m_stat90.getScanDescription());


    }
    return true;
  }
}