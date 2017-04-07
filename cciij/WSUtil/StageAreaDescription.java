package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */
 import java.util.*;
 import cciij.cciidata.StagingArea;
 import cciij.cciidata.CCIIDataVector;
 import cciij.util.CCIILogException;

public class StageAreaDescription extends CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: StageAreaDescription.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public StageAreaDescription()
  {
  }

  public void addAllStageAreasPrefix()
  {
    Vector codes = new Vector();
    Vector desc = new Vector();
    codes.add(CCIIProperties.ALL_STAGE_AREA_DEFINED_CODE);
    desc.add(CCIIProperties.ALL_STAGE_AREA_DEFINED_DESC);
    setPrefixValues(codes,desc);
  }
  public boolean init(String locationCd)
  {
    m_actionName = "StageAreaDescription";
    m_locationCd = locationCd;
    m_notify.setActionName(m_actionName);
    m_notify.initSite(locationCd);
    return internalInit(CCIIDataVector.STAGING_AREA);
  }
  public boolean addValues(CCIIDataVector dataVector)
  {
    StagingArea area = null;
    Vector data = null;
    String tempString = "";
    if (dataVector.getDataType() != CCIIDataVector.STAGING_AREA)
    {
      //m_notify.traceLog("Hey, Got the wrong data type");
       String str = "Ack!, was expecting STAGING_AREA type, got this instead: " +  dataVector.getDataType();
       CCIILogException ex = new CCIILogException (CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str);
       m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str,ex,this);
    }
    else
    {
       if (m_prefixValues)
      {
        Iterator itDesc = m_prefixDescription.iterator();
        for (Iterator itCodes=m_prefixCodes.iterator();itCodes.hasNext();)
        {
          m_codes.add((String)itCodes.next());
          try
          {
            tempString = (String)itDesc.next();

          }
          catch (NoSuchElementException nsee)
          {
            //m_notify.traceLog("No such element, trying to add description in Stage Area");
            String str = "No such element, trying to add description in Stage Area";
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NO_ELEMENT,str,nsee,this);
            tempString = "";
          }
          finally
          {
            m_definitions.add(tempString);
          }

        }

      }
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
        //CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str);
        //m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_EMPTY_DATA,str,ex,this);
        return false;
      }
      else
      {
        for (Iterator it=data.iterator(); it.hasNext(); )
        {
          area = (StagingArea) it.next();
          m_codes.add(area.getStagingAreaCode());
          m_definitions.add(area.getStagingAreaDescription());
          //m_notify.traceLog(area.getStagingAreaCode() + " : " + area.getStagingAreaDescription());
        }
      }
    }
    return true;
  }
}