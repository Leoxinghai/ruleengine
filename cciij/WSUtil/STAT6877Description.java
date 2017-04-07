package cciij.WSUtil;
import cciij.cciidata.ScanDefinition;
import cciij.cciidata.CCIIDataVector;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

public class STAT6877Description extends CodeDefinition
{
  private static final String m_whatVersion = "@(#) $RCSfile: STAT6877Description.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public ScanDefinition m_stat68 = null;
  public ScanDefinition m_stat77 = null;

  public STAT6877Description()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName= "STATDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    STATDescription statDesc = new STATDescription();
    statDesc.init(locationCd);
    m_stat68 = statDesc.m_stat68;
    m_stat77 = statDesc.m_stat77;
    addValues(null);
    return true;
  }

  public boolean addValues(CCIIDataVector dataVector)
  {
    if (m_stat68 != null && m_stat68.getRecordActiveFlag().equals("Y"))
    {
      m_codes.add(m_stat68.getLocStatNumber());
      m_definitions.add(m_stat68.getScanTypeCode() + " "
                  + m_stat68.getLocStatNumber() + ": "
                  + m_stat68.getScanDescription());
    }
    if (m_stat77 != null && m_stat77.getRecordActiveFlag().equals("Y"))
    {
      m_codes.add(m_stat77.getLocStatNumber());
      m_definitions.add(m_stat77.getScanTypeCode() + " "
                  + m_stat77.getLocStatNumber() + ": "
                  + m_stat77.getScanDescription());


    }
    return true;
  }
}