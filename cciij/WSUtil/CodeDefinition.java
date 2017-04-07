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
import javax.naming.*;
import javax.rmi.*;
import cciij.WSUtil.EjbProcessing;
import cciij.cciilookup.Lookup;
import cciij.cciidata.CCIIDataVector;
import cciij.WSUtil.WSNotify;
import cciij.WSUtil.CCIIProperties;
import cciij.util.CCIILogException;

public abstract class CodeDefinition implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CodeDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected Vector m_codes;
  protected Vector m_definitions;

  protected boolean m_prefixValues = false;
  protected Vector m_prefixCodes;
  protected Vector m_prefixDescription;
  protected Vector m_completeObjectsVector = null;
  protected String m_actionName = "CodeDefinition";
  protected WSNotify m_notify = new WSNotify();
  protected String m_locationCd = "";
  protected EjbProcessing ejbProcess = new EjbProcessing();
  protected CCIIProperties prop = new CCIIProperties();
  protected UserAttributes m_user = null;

  public CodeDefinition()
  {
    m_codes = new Vector();
    m_definitions = new Vector();
  }

  public abstract boolean init(String locationCd);

  public boolean reinit(String locationCd, UserAttributes user)
  {
    m_notify.initSite(locationCd);
    m_codes = new Vector();
    m_definitions = new Vector();
    m_user = user;
    return init(locationCd);
  }

  public boolean reinit(String locationCd)
  {
    return reinit ( locationCd, null );
  }

  protected boolean internalInit(int codeDef)
  {
    m_notify.setActionName(m_actionName);
    CCIIDataVector dataVector = getDataVector(codeDef);
    if (dataVector != null)
       return addValues(dataVector);
    else
      return false;
  }
  public abstract boolean addValues(CCIIDataVector dataVector);


   public void setPrefixValues(Vector codes, Vector descriptions)
  {
    if ( codes != null && descriptions != null)
    {
      m_prefixValues = true;
      m_prefixCodes = codes;
      m_prefixDescription = descriptions;
    }
  }
  public Vector getAllCodes()
  {
    return m_codes;
  }

  public Vector getAllDefinitions()
  {
    return m_definitions;
  }

  public Vector getAllCodesDescriptions()
  {
    Vector combo;
    combo = new Vector() ;
    String code;
    String desc;
    Iterator itDesc = m_definitions.iterator();
    for (Iterator itCode=m_codes.iterator();itCode.hasNext();)
    {
      code = (String)itCode.next();
      desc = (String)itDesc.next();
      if (desc == null || desc.equals(""))
      {
        combo.add(code);
      }
      else
      {
        combo.add(code + ": " + desc);
      }
    }
    return combo;
  }

  public String getDescriptionOfCode(String code)
  {
    String returnString = "";
    try
    {
      int index = m_codes.indexOf(code);
      if (index != -1)
         returnString = (String)m_definitions.elementAt(index);
    } catch (NoSuchElementException nsee)
    {
      String str = "No such element when trying to getDescription";
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NO_ELEMENT,str,nsee,this);
    }
    return returnString;
  }
  public boolean isCodeValid(String code)
  {
    return m_codes.contains(code.toUpperCase());
  }

  protected CCIIDataVector getDataVector(int codeType)
  {
    if (codeType != CCIIDataVector.ROUTE_LEG)
       //&& codeType != CCIIDataVector.SHIPMENT)
       return getDataVector(codeType,null,"");
    return null;
  }

  protected CCIIDataVector getDateVector(int codeType,Date routeDate)
  {
    if (true)//codeType != CCIIDataVector.SHIPMENT)
       return getDataVector(codeType,routeDate,"");
    return null;
  }
  protected CCIIDataVector getDateVector(int codeType,String stageArea)
  {
    if (codeType != CCIIDataVector.ROUTE_LEG)
       return getDataVector(codeType,null,stageArea);
    return null;
  }


  private CCIIDataVector getDataVector(int codeType,Date routeDate,
                                           String stageArea)//,String whseCd)
  {
    CCIIDataVector dataVector = null;
    Lookup lookup = ejbProcess.getLookup(m_locationCd);
    try
    {
      if (lookup != null)
      {
        switch (codeType)
        {
          case (CCIIDataVector.REASON_CODE_DEF):
               dataVector = lookup.getReasonCodeDefs(m_locationCd);
               break;
          case (CCIIDataVector.RELEASE_CODE_DEF):
               dataVector = lookup.getReleaseCodeDefs(m_locationCd);
               break;
          case (CCIIDataVector.HANDLING_INSTRUCTION_DEF):
               dataVector = lookup.getHandlingInstructionCodeDefs(m_locationCd);
               break;
          case (CCIIDataVector.SHIPMENT_REMARK_DEF):
               dataVector = lookup.getShipmentRemarkCodeDefs(m_locationCd);
               break;
          case (CCIIDataVector.INTERCEPT_CODE_DEF):
	       if ( m_user != null )
	       {
                 dataVector = lookup.getInterceptDefs(m_locationCd, m_user.getAgencies());
	       }
	       else
	       {
                 dataVector = lookup.getInterceptDefs(m_locationCd);
	       }
               break;
          case (CCIIDataVector.PRINTER_CONFIGURATION):
               dataVector = lookup.getPrinters(m_locationCd);
               break;
          case (CCIIDataVector.STAGING_AREA):
               dataVector = lookup.getStagingAreas(m_locationCd);
               break;
          //case (CCIIDataVector.ROUTE_LEG):
            //   dataVector = lookup.getRouteLegs(routeDate);
              // break;
          case (CCIIDataVector.JAVA_UTIL_DATE):
               dataVector = lookup.getSortDates(m_locationCd);
               break;
          //not used anymore
          //case (CCIIDataVector.SHIPMENT):
          //     dataVector = lookup.getStageAreaPickList(whseCd,stageArea,m_locationCd);
          //     break;
          case (CCIIDataVector.ROUTE_NBR):
               dataVector = lookup.getDistinctRouteNbrs(m_locationCd);
               break;
          case (CCIIDataVector.AGENCY_DEF):
	       if ( m_user != null )
	       {
                 dataVector = lookup.getAgencies(m_locationCd, m_user.getAgencies());
	       }
	       else
	       {
                 dataVector = lookup.getAgencies(m_locationCd);
	       }
               break;
          case (CCIIDataVector.SCAN_DEF):
                dataVector = lookup.getScanDefs(m_locationCd);
                break;
          case (CCIIDataVector.STAT_SCAN_DEF):
                dataVector = lookup.getSTATScanDefs(m_locationCd);
                break;
          case (CCIIDataVector.WHSE_CD):
               dataVector = lookup.getWarehousesBySite(m_locationCd);
               break;
          default:
              String str = "Didn't know what type of data to get";
              CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str);
              m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,str,ex,this);
              break;
        }
         m_completeObjectsVector = dataVector.getData();
         ejbProcess.cleanupLookup(lookup);
      }
    }
    catch (java.rmi.RemoteException re)
    {
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_REMOTE_ERROR,"CodeDefinition, remote Error",re,this);
    }

    if (dataVector == null)
    {
      String str = "Probably had an error since data vector is null";
      CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str);
      m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_CODE_DEF_NULL_DATA,str,ex,this);
    }
  return dataVector;
  }

  public Vector getCompleteObjectsVector()
  {
    return m_completeObjectsVector;
  }
}
