package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

import cciij.WSUtil.*;
import cciij.cciidata.*;
import cciij.util.*;
import cciij.businessActions.Messages;

public class CCIIResultState implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CCIIResultState.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
    //  protected CCIIState m_state;
  protected RPBScan m_scan;
  protected int m_errorNumber;
  protected double m_returnStatus;
  protected String m_returnMessage;
  protected String m_errorMessage;
  protected String m_description;
  protected int m_language = CCIIProperties.getDefaultSiteLanguage("ALL");
  protected String m_scanName;
  protected String m_trackingNumber;
  protected String m_ruleSetName;
  protected String m_originalScreen;
  protected boolean m_usesRuleSet = false;

  public CCIIResultState()
  {
  }

  public CCIIResultState (RPBScan scan,String scanName, int language)
  {
    setLanguage(language);
    initializeWithScan(scan, scanName);
  }

  public void setLanguage(int language)
  {
     if (language < 1 || language > CCIIProperties.NUM_LANG_SUPPORTED)
      language = CCIIProperties.getDefaultSiteLanguage("ALL");
    m_language = language;
  }
  public int getLanguage()
  {
      return m_language;
  }
  public void initializeWithScan(RPBScan scan, String scanName)
  {
      //    m_state = state;
      //    if (m_state != null)
      //    {
      //      m_scan = m_state.getScan();
      m_scan = scan;
      //      m_ruleSetName = m_state.getRuleSetName();
      if (m_scan != null)
      {
        m_errorNumber = m_scan.getErrorNumber();
        m_returnStatus = m_scan.getReturnStatus();
        m_returnMessage = m_scan.getReturnMessage();
        m_description = m_scan.getReturnMessage();
        if (m_description == null)
           m_description = "";
        if ( m_errorNumber == Messages.IM_DISPLAY_RTN_MSG )
	{
          m_errorMessage = m_scan.getReturnMessage();
	}
	else
	{
          m_errorMessage = MessageFormat.errorMessage(m_errorNumber,m_language);
	}
        m_scanName = scanName;
        m_trackingNumber = m_scan.getAirbillNumber();
      }

      //    }
  }

//   public CCIIState getState()
//   {
//     return m_state;
//   }
//   public void setState(CCIIState state)
//   {
//     if (state != null)
//       m_state = state;
//   }
  public RPBScan getScan()
  {
    return m_scan;
  }
  public void setScan(RPBScan scan)
  {
    if (scan != null)
       m_scan = scan;
  }
  public void setErrorNumber(int errorNum)
  {
    m_errorNumber = errorNum;
    if ( m_errorNumber == Messages.IM_DISPLAY_RTN_MSG )
    {
      m_errorMessage = m_scan.getReturnMessage();
    }
    else
    {
      m_errorMessage = MessageFormat.errorMessage(m_errorNumber,m_language);
    }
  }
  public void setOriginalScreen(String originalScreen)
  {
    if (originalScreen != null)
       m_originalScreen = originalScreen;
  }
  public String getOriginalScreen()
  {
    return m_originalScreen;
  }
  public int getErrorNumber()
  {
    return m_errorNumber;
  }
  public void setErrorMessage(String message)
  {
    if (message != null)
       m_errorMessage = message;
  }
  public String getErrorMessage()
  {
    return m_errorMessage;
  }
  public void setReturnStatus(double returnStatus)
  {
    m_returnStatus = returnStatus;
  }
  public double getReturnStatus()
  {
    return m_returnStatus;
  }
  public void setReturnMessage(String message)
  {
    if (message != null)
       m_returnMessage = message;
  }
  public String getReturnMessage()
  {
    return m_returnMessage;
  }
  public void setDescription(String description)
  {
    if (description != null)
       m_description = description;
  }
  public String getDescription ()
  {
    return m_description;
  }

  public void setScanName(String scanName)
  {
    if (scanName != null)
       m_scanName = scanName;
  }

  public String getScanName()
  {
    return m_scanName;
  }

  public void setTrackingNumber(String trackingNumber)
  {
    if (trackingNumber != null)
       m_trackingNumber = trackingNumber;
  }

  public String getTrackingNumber()
  {
    return m_trackingNumber;
  }

  public void setRuleSetName(String ruleSetName)
  {
    if (ruleSetName != null)
       m_ruleSetName = ruleSetName;
  }

  public String getRuleSetName()
  {
    return m_ruleSetName;
  }

  public boolean isSuccessfulResult()
  {
    if (m_errorNumber < Messages.START_OF_ERROR_MSGS)
       return true;
    else
      return false;
  }

  public boolean isReprocessableError()
  {
    boolean retValue = false;
    for (int i=0;i<CCIIProperties.REPROCESSABLE_ERRORS.length;i++)
    {
      if (m_errorNumber == CCIIProperties.REPROCESSABLE_ERRORS[i])
      {
         retValue = true;
         break;
      }
    }
    return retValue;
  }
  public boolean getUsesRuleSet()
  {
    return m_usesRuleSet;
  }

  public void setUsesRuleSet(boolean usesRuleSet)
  {
    m_usesRuleSet = usesRuleSet;
  }

  public String getRuleSetOrScanName()
  {
    if (m_usesRuleSet)
       return m_ruleSetName;
    else
      return m_scanName;
  }

  public String toString()
  {
    String returnString = "CCIIResultState object dump" + "\n";
    returnString += "version        :" + m_whatVersion + "\n";
    returnString += "errorNumber    :" +  m_errorNumber + "\n";
    returnString += "returnStatus   :" + m_returnStatus + "\n";
    returnString += "returnMessage  :" + m_returnMessage + "\n";
    returnString += "errorMessage   :" + m_errorMessage + "\n";
    returnString += "description    :" + m_description + "\n";
    returnString += "language       :" + m_language + "\n";
    returnString += "scanName       :" + m_scanName + "\n";
    returnString += "trackingNumber :" + m_trackingNumber + "\n";
    returnString += "ruleSetName    :" + m_ruleSetName + "\n";
    returnString += "originalScreen :" + m_originalScreen + "\n";
    returnString += "usesRuleSet    :" + m_usesRuleSet+ "\n";
    //    returnString += "state          :" + m_state + "\n";
    returnString += "scan           :" + m_scan + "\n";
    return returnString;

  }
}
