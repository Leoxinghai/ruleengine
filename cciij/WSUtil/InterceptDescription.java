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

public class InterceptDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: InterceptDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public InterceptDescription()
  {
  }
  public boolean init(String locationCd)
  {
    m_actionName = "InterceptDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.INTERCEPT_CODE_DEF);
  }

  public boolean addValues(CCIIDataVector dataVector)
  {
    cciij.cciidata.InterceptCodeDefinition def = null;
    Vector data = null;
    if (dataVector.getDataType() != CCIIDataVector.INTERCEPT_CODE_DEF)
    {
      //m_notify.traceLog("Hey, Got the wrong data type " + dataVector.getDataType());
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
        //String str = "data in Data Vector is not null but is empty";
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          def = (cciij.cciidata.InterceptCodeDefinition) it.next();
          m_codes.add(def.getInterceptCode());
          String temp = def.getInterceptDescription();
	  if ( ( def.getRestrictedAgencyCode() != null )
	    && ( def.getRestrictedAgencyCode().trim().length() > 0 ) )
	  {
	    temp = temp + " (" + def.getRestrictedAgencyCode().trim() + ")";
          }
          m_definitions.add(temp);
          //m_notify.traceLog(def.getReasonCode() + " : " + def.getReasonCodeDescription());
        }
      }
    }
    return true;
  }
}
