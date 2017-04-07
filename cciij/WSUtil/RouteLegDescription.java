package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

import cciij.cciidata.CCIIDataVector;
public class RouteLegDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: RouteLegDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public RouteLegDescription()
  {
  }
  public boolean init(String locationCd)
  {
    m_actionName = "RouteLegDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.ROUTE_LEG);
  }

  public boolean addValues(CCIIDataVector dataVector)
  {
    /*
    cciij.cciidata.HandlingInstructionDefinition def = null;
    Vector data = null;
    if (dataVector.getDataType() != CCIIDataVector.HANDLING_INSTRUCTION_DEF)
    {
      //m_notify.traceLog("Hey, Got the wrong data type");
    }
    else
    {
      data = dataVector.getData();
      if (data == null)
      {
        //m_notify.traceLog("data in DataVector is Null");
        return false;
      }
      else if (data.isEmpty())
      {
        //m_notify.traceLog("data in Data Vector is not null but is empty");
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          def = (cciij.cciidata.HandlingInstructionDefinition) it.next();
          codes.add(def.getHandlingInstructionCode());
          definitions.add(def.getHandlingInstructionDescription());
          m_notify.traceLog(def.getHandlingInstructionCode() + " : " + def.getHandlingInstructionDescription());
        }
      }
    }
    */
    return true;
  }
}