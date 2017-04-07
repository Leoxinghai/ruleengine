package cciij.WSUtil;

import cciij.cciidata.HandlingUnit;
/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

public class HandlingUnitAndStatus extends HandlingUnit implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: HandlingUnitAndStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected String m_status = "";

  public HandlingUnitAndStatus()
  {
    super();
  }

  public HandlingUnitAndStatus(HandlingUnit hu)
  {
    this(hu,"");
  }

  public HandlingUnitAndStatus (HandlingUnit hu, String status)
  {
      super(hu.getHandlingUnitOidNumber(),hu.getTrackingNumber(),hu.getFormTypeCode(),
      hu.getShipmentOidNumber(),hu.getHarmonizedTariffNumber(),hu.getTotalWeight(),
      hu.getTotalWeightTypeCode(),hu.getCustomsValueAmount(),hu.getEntryStatusCode(),
      hu.getAirbillTypeCode(),hu.getDetainmentLocationDescription(),hu.getManifestStatusCode(),
      hu.getPieceStatusCode());
      setTransactionSequenceTimestamp(hu.getTransactionSequenceTimestamp());
      setLastModifiedTimeStamp(hu.getLastModifiedTimeStamp());
      setLastUserName(hu.getLastUserName());
      setEntryCategoryTypeCode(hu.getEntryCategoryTypeCode());
      setRecurringSelectFlag(hu.getRecurringSelectFlag());
      setOverageReasonCode(hu.getOverageReasonCode());
      setStagingAreaCode(hu.getStagingAreaCode());
      setStatus(status);
  }

  public String getStatus()
  {
    return m_status;
  }
  public void setStatus(String status)
  {
    if (status != null)
       m_status = status;
    else
      m_status = "";
  }
}