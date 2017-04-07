package cciij.WSUtil;
import cciij.cciidata.CCIIDataVector;
import cciij.cciidata.ScanDefinition;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class STAT37Description extends CodeDefinition
{
  private static final String m_whatVersion = "@(#) $RCSfile: STAT37Description.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public ScanDefinition m_stat37 = null;
  public STAT37Description()
  {
  }
  public boolean init(String locationCd)
  {
    m_actionName= "STATDescription";
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    STATDescription statDesc = new STATDescription();
    statDesc.init(locationCd);
    m_stat37 = statDesc.m_stat37;
    addValues(null);
    return true;
  }

  public boolean addValues(CCIIDataVector dataVector)
  {
    m_codes.add("A");
    m_definitions.add("A: Crushed");
    m_codes.add("B");
    m_definitions.add("B: Wet");
    m_codes.add("C");
    m_definitions.add("C: Torn");
    m_codes.add("D");
    m_definitions.add("D: Rewrap");
    m_codes.add("E");
    m_definitions.add("E: Retape");
    return true;
  }
}