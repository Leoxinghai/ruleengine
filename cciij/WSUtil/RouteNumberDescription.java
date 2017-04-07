package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */
import cciij.cciidata.CCIIDataVector;
import java.util.*;
import cciij.util.CCIILogException;

public class RouteNumberDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: RouteNumberDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public RouteNumberDescription()
  {
  }

  public boolean init(String locationCd)
  {
    m_actionName = "RouteNumberDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.ROUTE_NBR);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    String defRouteNbr = null;
    Vector data = null;
    if (dataVector.getDataType() != CCIIDataVector.ROUTE_NBR)
    {
      //m_notify.traceLog("Hey, Got the wrong data type '" + dataVector.getDataType()+ "'");
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
      else if (data.isEmpty())
      {
        //String str = "data in DataVector is Null";
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          defRouteNbr = (String)it.next();
          m_codes.add(defRouteNbr);
          m_definitions.add("");
          //m_notify.traceLog(defRouteNbr);
        }
      }
    }
    return true;
  }
}