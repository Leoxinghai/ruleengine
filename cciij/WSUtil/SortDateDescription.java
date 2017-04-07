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
import java.text.*;
import cciij.util.CCIILogException;

public class SortDateDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: SortDateDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public SortDateDescription()
  {
  }
  public boolean init(String locationCd)
  {
    m_actionName = "SortDateDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.JAVA_UTIL_DATE);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    String defString = null;
    Date defDate = null;
    Vector data = null;
    SimpleDateFormat df = new SimpleDateFormat(CCIIProperties.DEFAULT_DATE_FORMAT);
    //df.setTimeZone(CCIIProperties.LOCAL_TIME_ZONE);
    //DateFormat df = DateFormat.getDateInstance();
    if (dataVector.getDataType() != CCIIDataVector.JAVA_UTIL_DATE)
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
        //String str = "data in Data Vector is not null but is empty";
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          defDate = (Date)it.next();
          defString = df.format(defDate);
          m_codes.add(defString);
          m_definitions.add("");
          //m_notify.traceLog(defString);
        }
      }
    }
    return true;
  }
}