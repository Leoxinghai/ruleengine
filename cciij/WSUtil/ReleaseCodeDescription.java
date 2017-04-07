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
import java.util.*;
import cciij.util.CCIILogException;

public class ReleaseCodeDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ReleaseCodeDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public ReleaseCodeDescription()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName = "ReleaseCodeDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.RELEASE_CODE_DEF);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {

    cciij.cciidata.ReleaseCodeDef def = null;
    Vector data = null;
    if (dataVector.getDataType() != CCIIDataVector.RELEASE_CODE_DEF)
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
        //notify.traceLog("data in DataVector is Null");
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
          def = (cciij.cciidata.ReleaseCodeDef) it.next();
          m_codes.add(def.getReleaseCode());
          m_definitions.add(def.getReleaseCodeDescription());
          //m_notify.traceLog(def.getReleaseCode() + " : " + def.getReleaseCodeDescription());
        }
      }
    }
    return true;
  }
}