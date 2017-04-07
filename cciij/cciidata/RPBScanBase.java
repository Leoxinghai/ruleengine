// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RPBScanBase.java

package cciij.cciidata;

import java.io.Serializable;
import java.util.Date;

public class RPBScanBase
    implements Cloneable, Serializable
{

    public RPBScanBase()
    {
        m_ReturnMessage = "";
        m_InViewName = "";
        m_OutViewName = "";
        m_UserLogon = "";
        m_OrgCode = "";
        m_InputDevice = "";
        m_FromConsFlag = "";
        m_AirbillNumber = "";
        m_AirbillType = "";
        m_AirbillFormType = "";
        m_AirbillEntry = "";
        m_AstraData = "";
        m_HAWB = "";
        m_HAWBFormType = "";
        m_HAWBUnknownFlag = "";
        m_ReasonCode = "";
        m_ReleaseCode = "";
        m_DetainLoc = "";
        m_InterceptCode = "";
        m_PrinterCode = "";
        m_RouteNumber = "";
        m_StagingAreaCode = "";
        m_LocStatNbr = "";
        m_Comments = "";
        m_Astray = "";
        m_MdeRoute = "";
        m_FlightNumber = "";
        m_FlightDate = "";
        m_PkgRouted = "";
        m_ServiceCode = "";
        m_HandlingCodes = "";
        m_HalPostal = "";
        m_DestPostal = "";
        m_RoutingId = "";
        m_DelCommit = "";
        m_DestCountry = "";
        m_PkgCondition = "";
        m_ConsId = "";
        m_ConsFormType = "";
        m_ConsType = "";
        m_ContainerInd = "";
        m_ContainerId = "";
        m_ConsDestLoc = "";
        m_SplitName = "";
        m_ActionCode = "";
        m_AgencyCode = "";
        m_LocationCode = "";
        m_WarehouseCode = "";
        m_BrokerClassificationCode = "";
        m_RouteStatusCode = "";
        m_DestLocationCode = "";
        m_DeclarationCode = "";
        m_ShuttleID = "";
        m_CustomsReleasedFlag = "";
        m_InputMethodCode = "";
        m_Label1Data = "";
        m_Label2Data = "";
        m_Label3Data = "";
        m_HandlingInstructionCode = "";
        m_HandlingInstructionDesc = "";
        m_ShipmentRemarkCode = "";
        m_ShipmentRemarkDesc = "";
        m_ReturnAWBNumber = "";
        m_TravelStatus = "";
        m_SplitFunction = "";
        m_SplitLocation = "";
        m_SplitNumber = "";
        m_SplitDestId = "";
        m_SplitArray = "";
        m_SplitServices = "";
        m_SplitHandling = "";
        m_SplitSpcHandling = "";
        m_SplitBoxDoc = "";
        m_SplitAltSplit = "";
        m_SplitType = "";
        m_SplitIntlDom = "";
        m_SplitZipCode = "";
        m_ConsNoiDestLocCode = "";
        m_ConsScanLocCode = "";
        m_FlightOriginLocCode = "";
        m_FlightDestLocCode = "";
        m_OriginLocationCode = "";
        m_TransCode = "";
        m_EntryNumber = "";
        m_EntryType = "";
        m_EntryValRestOverride = "";
    }

    public RPBScanBase(double ReturnStatus, String ReturnMessage, String InViewName, String OutViewName, long SysDateTime, 
            long SysDateTimeNoMilliSeconds, String UserLogon, String OrgCode, String InputDevice, int ErrorNumber, String FromConsFlag, 
            String AirbillNumber, String AirbillType, String AirbillFormType, String AirbillEntry, String AstraData, int HandlingUnitOid, String HAWB, 
            String HAWBFormType, int ShipmentOid, String HAWBUnknownFlag, String ReasonCode, String ReleaseCode, String DetainLoc, String InterceptCode, 
            String PrinterCode, String RouteNumber, Date RouteLegDate, int RouteLegOid, String StagingAreaCode, String LocStatNbr, String Comments, 
            String Astray, String MdeRoute, String FlightNumber, String FlightDate, String PkgRouted, String ServiceCode, String HandlingCodes, 
            String HalPostal, String DestPostal, String RoutingId, String DelCommit, String DestCountry, String PkgCondition, String ConsId, 
            String ConsFormType, String ConsType, String ContainerInd, String ContainerId, String ConsDestLoc, int ConsOid, String SplitName, 
            String ActionCode, String AgencyCode, String LocationCode, String WarehouseCode, String BrokerClassificationCode, Date TransactionTimestamp, String RouteStatusCode, 
            boolean PreviousBondInFlag, String DestLocationCode, boolean AddressChangeFlag, String DeclarationCode, String ShuttleID, String CustomsReleasedFlag, String InputMethodCode, 
            int Label1Length, String Label1Data, int Label2Length, String Label2Data, int Label3Length, String Label3Data, String HandlingInstructionCode, 
            String HandlingInstructionDesc, String ShipmentRemarkCode, String ShipmentRemarkDesc, String ReturnAWBNumber, String TravelStatus, String SplitFunction, String SplitLocation, 
            String SplitNumber, String SplitDestId, String SplitArray, String SplitServices, String SplitHandling, String SplitSpcHandling, String SplitBoxDoc, 
            String SplitAltSplit, String SplitType, String SplitIntlDom, String SplitZipCode, Date ConsScanDate, Date ConsCreateDate, Date ConsComponentDate, 
            Date ConsDeconsDate, String ConsNoiDestLocCode, String ConsScanLocCode, String FlightOriginLocCode, String FlightDestLocCode, int HAWBSerialNumber, String OriginLocationCode, 
            String TransCode, String EntryNumber, String EntryType, String EntryValRestOverride)
    {
        m_ReturnMessage = "";
        m_InViewName = "";
        m_OutViewName = "";
        m_UserLogon = "";
        m_OrgCode = "";
        m_InputDevice = "";
        m_FromConsFlag = "";
        m_AirbillNumber = "";
        m_AirbillType = "";
        m_AirbillFormType = "";
        m_AirbillEntry = "";
        m_AstraData = "";
        m_HAWB = "";
        m_HAWBFormType = "";
        m_HAWBUnknownFlag = "";
        m_ReasonCode = "";
        m_ReleaseCode = "";
        m_DetainLoc = "";
        m_InterceptCode = "";
        m_PrinterCode = "";
        m_RouteNumber = "";
        m_StagingAreaCode = "";
        m_LocStatNbr = "";
        m_Comments = "";
        m_Astray = "";
        m_MdeRoute = "";
        m_FlightNumber = "";
        m_FlightDate = "";
        m_PkgRouted = "";
        m_ServiceCode = "";
        m_HandlingCodes = "";
        m_HalPostal = "";
        m_DestPostal = "";
        m_RoutingId = "";
        m_DelCommit = "";
        m_DestCountry = "";
        m_PkgCondition = "";
        m_ConsId = "";
        m_ConsFormType = "";
        m_ConsType = "";
        m_ContainerInd = "";
        m_ContainerId = "";
        m_ConsDestLoc = "";
        m_SplitName = "";
        m_ActionCode = "";
        m_AgencyCode = "";
        m_LocationCode = "";
        m_WarehouseCode = "";
        m_BrokerClassificationCode = "";
        m_RouteStatusCode = "";
        m_DestLocationCode = "";
        m_DeclarationCode = "";
        m_ShuttleID = "";
        m_CustomsReleasedFlag = "";
        m_InputMethodCode = "";
        m_Label1Data = "";
        m_Label2Data = "";
        m_Label3Data = "";
        m_HandlingInstructionCode = "";
        m_HandlingInstructionDesc = "";
        m_ShipmentRemarkCode = "";
        m_ShipmentRemarkDesc = "";
        m_ReturnAWBNumber = "";
        m_TravelStatus = "";
        m_SplitFunction = "";
        m_SplitLocation = "";
        m_SplitNumber = "";
        m_SplitDestId = "";
        m_SplitArray = "";
        m_SplitServices = "";
        m_SplitHandling = "";
        m_SplitSpcHandling = "";
        m_SplitBoxDoc = "";
        m_SplitAltSplit = "";
        m_SplitType = "";
        m_SplitIntlDom = "";
        m_SplitZipCode = "";
        m_ConsNoiDestLocCode = "";
        m_ConsScanLocCode = "";
        m_FlightOriginLocCode = "";
        m_FlightDestLocCode = "";
        m_OriginLocationCode = "";
        m_TransCode = "";
        m_EntryNumber = "";
        m_EntryType = "";
        m_EntryValRestOverride = "";
        setReturnStatus(ReturnStatus);
        setReturnMessage(ReturnMessage);
        setInViewName(InViewName);
        setOutViewName(OutViewName);
        setSysDateTime(SysDateTime);
        m_SysDateTimeNoMilliSeconds = SysDateTimeNoMilliSeconds;
        setUserLogon(UserLogon);
        setOrgCode(OrgCode);
        setInputDevice(InputDevice);
        setErrorNumber(ErrorNumber);
        setFromConsFlag(FromConsFlag);
        setAirbillNumber(AirbillNumber);
        setAirbillType(AirbillType);
        setAirbillFormType(AirbillFormType);
        setAirbillEntry(AirbillEntry);
        setAstraData(AstraData);
        setHandlingUnitOid(HandlingUnitOid);
        setHAWB(HAWB);
        setHAWBFormType(HAWBFormType);
        setShipmentOid(ShipmentOid);
        setHAWBUnknownFlag(HAWBUnknownFlag);
        setReasonCode(ReasonCode);
        setReleaseCode(ReleaseCode);
        setDetainLoc(DetainLoc);
        setInterceptCode(InterceptCode);
        setPrinterCode(PrinterCode);
        setRouteNumber(RouteNumber);
        setRouteLegDate(RouteLegDate);
        setRouteLegOid(RouteLegOid);
        setStagingAreaCode(StagingAreaCode);
        setLocStatNbr(LocStatNbr);
        setComments(Comments);
        setAstray(Astray);
        setMdeRoute(MdeRoute);
        setFlightNumber(FlightNumber);
        setFlightDate(FlightDate);
        setPkgRouted(PkgRouted);
        setServiceCode(ServiceCode);
        setHandlingCodes(HandlingCodes);
        setHalPostal(HalPostal);
        setDestPostal(DestPostal);
        setRoutingId(RoutingId);
        setDelCommit(DelCommit);
        setDestCountry(DestCountry);
        setPkgCondition(PkgCondition);
        setConsId(ConsId);
        setConsFormType(ConsFormType);
        setConsType(ConsType);
        setContainerInd(ContainerInd);
        setContainerId(ContainerId);
        setConsDestLoc(ConsDestLoc);
        setConsOid(ConsOid);
        setSplitName(SplitName);
        setActionCode(ActionCode);
        setAgencyCode(AgencyCode);
        setLocationCode(LocationCode);
        setWarehouseCode(WarehouseCode);
        setBrokerClassificationCode(BrokerClassificationCode);
        setTransactionTimestamp(TransactionTimestamp);
        setRouteStatusCode(RouteStatusCode);
        setPreviousBondInFlag(PreviousBondInFlag);
        setDestLocationCode(DestLocationCode);
        setAddressChangeFlag(AddressChangeFlag);
        setDeclarationCode(DeclarationCode);
        setShuttleID(ShuttleID);
        setCustomsReleasedFlag(CustomsReleasedFlag);
        setInputMethodCode(InputMethodCode);
        setLabel1Length(Label1Length);
        setLabel1Data(Label1Data);
        setLabel2Length(Label2Length);
        setLabel2Data(Label2Data);
        setLabel3Length(Label3Length);
        setLabel3Data(Label3Data);
        setHandlingInstructionCode(HandlingInstructionCode);
        setHandlingInstructionDesc(HandlingInstructionDesc);
        setShipmentRemarkCode(ShipmentRemarkCode);
        setShipmentRemarkDesc(ShipmentRemarkDesc);
        setReturnAWBNumber(ReturnAWBNumber);
        setTravelStatus(TravelStatus);
        setSplitFunction(SplitFunction);
        setSplitLocation(SplitLocation);
        setSplitNumber(SplitNumber);
        setSplitDestId(SplitDestId);
        setSplitArray(SplitArray);
        setSplitServices(SplitServices);
        setSplitHandling(SplitHandling);
        setSplitSpcHandling(SplitSpcHandling);
        setSplitBoxDoc(SplitBoxDoc);
        setSplitAltSplit(SplitAltSplit);
        setSplitType(SplitType);
        setSplitIntlDom(SplitIntlDom);
        setSplitZipCode(SplitZipCode);
        setConsScanDate(ConsScanDate);
        setConsCreateDate(ConsCreateDate);
        setConsComponentDate(ConsComponentDate);
        setConsDeconsDate(ConsDeconsDate);
        setConsNoiDestLocCode(ConsNoiDestLocCode);
        setConsScanLocCode(ConsScanLocCode);
        setFlightOriginLocCode(FlightOriginLocCode);
        setFlightDestLocCode(FlightDestLocCode);
        setHAWBSerialNumber(HAWBSerialNumber);
        setOriginLocationCode(OriginLocationCode);
        setTransCode(TransCode);
        setEntryNumber(EntryNumber);
        setEntryType(EntryType);
        setEntryValRestOverride(EntryValRestOverride);
    }

    public double getReturnStatus()
    {
        return m_ReturnStatus;
    }

    public void setReturnStatus(double setValue)
    {
        m_ReturnStatus = setValue;
    }

    public String getReturnMessage()
    {
        return m_ReturnMessage;
    }

    public void setReturnMessage(String setValue)
    {
        if(setValue == null)
        {
            m_ReturnMessage = "";
            return;
        } else
        {
            m_ReturnMessage = setValue;
            return;
        }
    }

    public String getInViewName()
    {
        return m_InViewName;
    }

    public void setInViewName(String setValue)
    {
        if(setValue == null)
        {
            m_InViewName = "";
            return;
        } else
        {
            m_InViewName = setValue;
            return;
        }
    }

    public String getOutViewName()
    {
        return m_OutViewName;
    }

    public void setOutViewName(String setValue)
    {
        if(setValue == null)
        {
            m_OutViewName = "";
            return;
        } else
        {
            m_OutViewName = setValue;
            return;
        }
    }

    public long getSysDateTime()
    {
        return m_SysDateTime;
    }

    public void setSysDateTime(long setValue)
    {
        m_SysDateTime = setValue;
    }

    public long getSysDateTimeNoMilliSeconds()
    {
        return m_SysDateTimeNoMilliSeconds;
    }

    public String getUserLogon()
    {
        return m_UserLogon;
    }

    public void setUserLogon(String setValue)
    {
        if(setValue == null)
        {
            m_UserLogon = "";
            return;
        } else
        {
            m_UserLogon = setValue;
            return;
        }
    }

    public String getOrgCode()
    {
        return m_OrgCode;
    }

    public void setOrgCode(String setValue)
    {
        if(setValue == null)
        {
            m_OrgCode = "";
            return;
        } else
        {
            m_OrgCode = setValue;
            return;
        }
    }

    public String getInputDevice()
    {
        return m_InputDevice;
    }

    public void setInputDevice(String setValue)
    {
        if(setValue == null)
        {
            m_InputDevice = "";
            return;
        } else
        {
            m_InputDevice = setValue;
            return;
        }
    }

    public int getErrorNumber()
    {
        return m_ErrorNumber;
    }

    public void setErrorNumber(int setValue)
    {
        m_ErrorNumber = setValue;
    }

    public String getFromConsFlag()
    {
        return m_FromConsFlag;
    }

    public void setFromConsFlag(String setValue)
    {
        if(setValue == null)
        {
            m_FromConsFlag = "";
            return;
        } else
        {
            m_FromConsFlag = setValue;
            return;
        }
    }

    public String getAirbillNumber()
    {
        return m_AirbillNumber;
    }

    public void setAirbillNumber(String setValue)
    {
        if(setValue == null)
        {
            m_AirbillNumber = "";
            return;
        } else
        {
            m_AirbillNumber = setValue;
            return;
        }
    }

    public String getAirbillType()
    {
        return m_AirbillType;
    }

    public void setAirbillType(String setValue)
    {
        if(setValue == null)
        {
            m_AirbillType = "";
            return;
        } else
        {
            m_AirbillType = setValue;
            return;
        }
    }

    public String getAirbillFormType()
    {
        return m_AirbillFormType;
    }

    public void setAirbillFormType(String setValue)
    {
        if(setValue == null)
        {
            m_AirbillFormType = "";
            return;
        } else
        {
            m_AirbillFormType = setValue;
            return;
        }
    }

    public String getAirbillEntry()
    {
        return m_AirbillEntry;
    }

    public void setAirbillEntry(String setValue)
    {
        if(setValue == null)
        {
            m_AirbillEntry = "";
            return;
        } else
        {
            m_AirbillEntry = setValue;
            return;
        }
    }

    public String getAstraData()
    {
        return m_AstraData;
    }

    public void setAstraData(String setValue)
    {
        if(setValue == null)
        {
            m_AstraData = "";
            return;
        } else
        {
            m_AstraData = setValue;
            return;
        }
    }

    public int getHandlingUnitOid()
    {
        return m_HandlingUnitOid;
    }

    public void setHandlingUnitOid(int setValue)
    {
        m_HandlingUnitOid = setValue;
    }

    public String getHAWB()
    {
        return m_HAWB;
    }

    public void setHAWB(String setValue)
    {
        if(setValue == null)
        {
            m_HAWB = "";
            return;
        } else
        {
            m_HAWB = setValue;
            return;
        }
    }

    public String getHAWBFormType()
    {
        return m_HAWBFormType;
    }

    public void setHAWBFormType(String setValue)
    {
        if(setValue == null)
        {
            m_HAWBFormType = "";
            return;
        } else
        {
            m_HAWBFormType = setValue;
            return;
        }
    }

    public int getShipmentOid()
    {
        return m_ShipmentOid;
    }

    public void setShipmentOid(int setValue)
    {
        m_ShipmentOid = setValue;
    }

    public String getHAWBUnknownFlag()
    {
        return m_HAWBUnknownFlag;
    }

    public void setHAWBUnknownFlag(String setValue)
    {
        if(setValue == null)
        {
            m_HAWBUnknownFlag = "";
            return;
        } else
        {
            m_HAWBUnknownFlag = setValue;
            return;
        }
    }

    public String getReasonCode()
    {
        return m_ReasonCode;
    }

    public void setReasonCode(String setValue)
    {
        if(setValue == null)
        {
            m_ReasonCode = "";
            return;
        } else
        {
            m_ReasonCode = setValue;
            return;
        }
    }

    public String getReleaseCode()
    {
        return m_ReleaseCode;
    }

    public void setReleaseCode(String setValue)
    {
        if(setValue == null)
        {
            m_ReleaseCode = "";
            return;
        } else
        {
            m_ReleaseCode = setValue;
            return;
        }
    }

    public String getDetainLoc()
    {
        return m_DetainLoc;
    }

    public void setDetainLoc(String setValue)
    {
        if(setValue == null)
        {
            m_DetainLoc = "";
            return;
        } else
        {
            m_DetainLoc = setValue;
            return;
        }
    }

    public String getInterceptCode()
    {
        return m_InterceptCode;
    }

    public void setInterceptCode(String setValue)
    {
        if(setValue == null)
        {
            m_InterceptCode = "";
            return;
        } else
        {
            m_InterceptCode = setValue;
            return;
        }
    }

    public String getPrinterCode()
    {
        return m_PrinterCode;
    }

    public void setPrinterCode(String setValue)
    {
        if(setValue == null)
        {
            m_PrinterCode = "";
            return;
        } else
        {
            m_PrinterCode = setValue;
            return;
        }
    }

    public String getRouteNumber()
    {
        return m_RouteNumber;
    }

    public void setRouteNumber(String setValue)
    {
        if(setValue == null)
        {
            m_RouteNumber = "";
            return;
        } else
        {
            m_RouteNumber = setValue;
            return;
        }
    }

    public Date getRouteLegDate()
    {
        return m_RouteLegDate;
    }

    public void setRouteLegDate(Date setValue)
    {
        m_RouteLegDate = setValue;
    }

    public int getRouteLegOid()
    {
        return m_RouteLegOid;
    }

    public void setRouteLegOid(int setValue)
    {
        m_RouteLegOid = setValue;
    }

    public String getStagingAreaCode()
    {
        return m_StagingAreaCode;
    }

    public void setStagingAreaCode(String setValue)
    {
        if(setValue == null)
        {
            m_StagingAreaCode = "";
            return;
        } else
        {
            m_StagingAreaCode = setValue;
            return;
        }
    }

    public String getLocStatNbr()
    {
        return m_LocStatNbr;
    }

    public void setLocStatNbr(String setValue)
    {
        if(setValue == null)
        {
            m_LocStatNbr = "";
            return;
        } else
        {
            m_LocStatNbr = setValue;
            return;
        }
    }

    public String getComments()
    {
        return m_Comments;
    }

    public void setComments(String setValue)
    {
        if(setValue == null)
        {
            m_Comments = "";
            return;
        } else
        {
            m_Comments = setValue;
            return;
        }
    }

    public String getAstray()
    {
        return m_Astray;
    }

    public void setAstray(String setValue)
    {
        if(setValue == null)
        {
            m_Astray = "";
            return;
        } else
        {
            m_Astray = setValue;
            return;
        }
    }

    public String getMdeRoute()
    {
        return m_MdeRoute;
    }

    public void setMdeRoute(String setValue)
    {
        if(setValue == null)
        {
            m_MdeRoute = "";
            return;
        } else
        {
            m_MdeRoute = setValue;
            return;
        }
    }

    public String getFlightNumber()
    {
        return m_FlightNumber;
    }

    public void setFlightNumber(String setValue)
    {
        if(setValue == null)
        {
            m_FlightNumber = "";
            return;
        } else
        {
            m_FlightNumber = setValue;
            return;
        }
    }

    public String getFlightDate()
    {
        return m_FlightDate;
    }

    public void setFlightDate(String setValue)
    {
        if(setValue == null)
        {
            m_FlightDate = "";
            return;
        } else
        {
            m_FlightDate = setValue;
            return;
        }
    }

    public String getPkgRouted()
    {
        return m_PkgRouted;
    }

    public void setPkgRouted(String setValue)
    {
        if(setValue == null)
        {
            m_PkgRouted = "";
            return;
        } else
        {
            m_PkgRouted = setValue;
            return;
        }
    }

    public String getServiceCode()
    {
        return m_ServiceCode;
    }

    public void setServiceCode(String setValue)
    {
        if(setValue == null)
        {
            m_ServiceCode = "";
            return;
        } else
        {
            m_ServiceCode = setValue;
            return;
        }
    }

    public String getHandlingCodes()
    {
        return m_HandlingCodes;
    }

    public void setHandlingCodes(String setValue)
    {
        if(setValue == null)
        {
            m_HandlingCodes = "";
            return;
        } else
        {
            m_HandlingCodes = setValue;
            return;
        }
    }

    public String getHalPostal()
    {
        return m_HalPostal;
    }

    public void setHalPostal(String setValue)
    {
        if(setValue == null)
        {
            m_HalPostal = "";
            return;
        } else
        {
            m_HalPostal = setValue;
            return;
        }
    }

    public String getDestPostal()
    {
        return m_DestPostal;
    }

    public void setDestPostal(String setValue)
    {
        if(setValue == null)
        {
            m_DestPostal = "";
            return;
        } else
        {
            m_DestPostal = setValue;
            return;
        }
    }

    public String getRoutingId()
    {
        return m_RoutingId;
    }

    public void setRoutingId(String setValue)
    {
        if(setValue == null)
        {
            m_RoutingId = "";
            return;
        } else
        {
            m_RoutingId = setValue;
            return;
        }
    }

    public String getDelCommit()
    {
        return m_DelCommit;
    }

    public void setDelCommit(String setValue)
    {
        if(setValue == null)
        {
            m_DelCommit = "";
            return;
        } else
        {
            m_DelCommit = setValue;
            return;
        }
    }

    public String getDestCountry()
    {
        return m_DestCountry;
    }

    public void setDestCountry(String setValue)
    {
        if(setValue == null)
        {
            m_DestCountry = "";
            return;
        } else
        {
            m_DestCountry = setValue;
            return;
        }
    }

    public String getPkgCondition()
    {
        return m_PkgCondition;
    }

    public void setPkgCondition(String setValue)
    {
        if(setValue == null)
        {
            m_PkgCondition = "";
            return;
        } else
        {
            m_PkgCondition = setValue;
            return;
        }
    }

    public String getConsId()
    {
        return m_ConsId;
    }

    public void setConsId(String setValue)
    {
        if(setValue == null)
        {
            m_ConsId = "";
            return;
        } else
        {
            m_ConsId = setValue;
            return;
        }
    }

    public String getConsFormType()
    {
        return m_ConsFormType;
    }

    public void setConsFormType(String setValue)
    {
        if(setValue == null)
        {
            m_ConsFormType = "";
            return;
        } else
        {
            m_ConsFormType = setValue;
            return;
        }
    }

    public String getConsType()
    {
        return m_ConsType;
    }

    public void setConsType(String setValue)
    {
        if(setValue == null)
        {
            m_ConsType = "";
            return;
        } else
        {
            m_ConsType = setValue;
            return;
        }
    }

    public String getContainerInd()
    {
        return m_ContainerInd;
    }

    public void setContainerInd(String setValue)
    {
        if(setValue == null)
        {
            m_ContainerInd = "";
            return;
        } else
        {
            m_ContainerInd = setValue;
            return;
        }
    }

    public String getContainerId()
    {
        return m_ContainerId;
    }

    public void setContainerId(String setValue)
    {
        if(setValue == null)
        {
            m_ContainerId = "";
            return;
        } else
        {
            m_ContainerId = setValue;
            return;
        }
    }

    public String getConsDestLoc()
    {
        return m_ConsDestLoc;
    }

    public void setConsDestLoc(String setValue)
    {
        if(setValue == null)
        {
            m_ConsDestLoc = "";
            return;
        } else
        {
            m_ConsDestLoc = setValue;
            return;
        }
    }

    public int getConsOid()
    {
        return m_ConsOid;
    }

    public void setConsOid(int setValue)
    {
        m_ConsOid = setValue;
    }

    public String getSplitName()
    {
        return m_SplitName;
    }

    public void setSplitName(String setValue)
    {
        if(setValue == null)
        {
            m_SplitName = "";
            return;
        } else
        {
            m_SplitName = setValue;
            return;
        }
    }

    public String getActionCode()
    {
        return m_ActionCode;
    }

    public void setActionCode(String setValue)
    {
        if(setValue == null)
        {
            m_ActionCode = "";
            return;
        } else
        {
            m_ActionCode = setValue;
            return;
        }
    }

    public String getAgencyCode()
    {
        return m_AgencyCode;
    }

    public void setAgencyCode(String setValue)
    {
        if(setValue == null)
        {
            m_AgencyCode = "";
            return;
        } else
        {
            m_AgencyCode = setValue;
            return;
        }
    }

    public String getLocationCode()
    {
        return m_LocationCode;
    }

    public void setLocationCode(String setValue)
    {
        if(setValue == null)
        {
            m_LocationCode = "";
            return;
        } else
        {
            m_LocationCode = setValue;
            return;
        }
    }

    public String getWarehouseCode()
    {
        return m_WarehouseCode;
    }

    public void setWarehouseCode(String setValue)
    {
        if(setValue == null)
        {
            m_WarehouseCode = "";
            return;
        } else
        {
            m_WarehouseCode = setValue;
            return;
        }
    }

    public String getBrokerClassificationCode()
    {
        return m_BrokerClassificationCode;
    }

    public void setBrokerClassificationCode(String setValue)
    {
        if(setValue == null)
        {
            m_BrokerClassificationCode = "";
            return;
        } else
        {
            m_BrokerClassificationCode = setValue;
            return;
        }
    }

    public Date getTransactionTimestamp()
    {
        return m_TransactionTimestamp;
    }

    public void setTransactionTimestamp(Date setValue)
    {
        m_TransactionTimestamp = setValue;
    }

    public String getRouteStatusCode()
    {
        return m_RouteStatusCode;
    }

    public void setRouteStatusCode(String setValue)
    {
        if(setValue == null)
        {
            m_RouteStatusCode = "";
            return;
        } else
        {
            m_RouteStatusCode = setValue;
            return;
        }
    }

    public boolean getPreviousBondInFlag()
    {
        return m_PreviousBondInFlag;
    }

    public void setPreviousBondInFlag(boolean setValue)
    {
        m_PreviousBondInFlag = setValue;
    }

    public String getDestLocationCode()
    {
        return m_DestLocationCode;
    }

    public void setDestLocationCode(String setValue)
    {
        if(setValue == null)
        {
            m_DestLocationCode = "";
            return;
        } else
        {
            m_DestLocationCode = setValue;
            return;
        }
    }

    public boolean getAddressChangeFlag()
    {
        return m_AddressChangeFlag;
    }

    public void setAddressChangeFlag(boolean setValue)
    {
        m_AddressChangeFlag = setValue;
    }

    public String getDeclarationCode()
    {
        return m_DeclarationCode;
    }

    public void setDeclarationCode(String setValue)
    {
        if(setValue == null)
        {
            m_DeclarationCode = "";
            return;
        } else
        {
            m_DeclarationCode = setValue;
            return;
        }
    }

    public String getShuttleID()
    {
        return m_ShuttleID;
    }

    public void setShuttleID(String setValue)
    {
        if(setValue == null)
        {
            m_ShuttleID = "";
            return;
        } else
        {
            m_ShuttleID = setValue;
            return;
        }
    }

    public String getCustomsReleasedFlag()
    {
        return m_CustomsReleasedFlag;
    }

    public void setCustomsReleasedFlag(String setValue)
    {
        if(setValue == null)
        {
            m_CustomsReleasedFlag = "";
            return;
        } else
        {
            m_CustomsReleasedFlag = setValue;
            return;
        }
    }

    public String getInputMethodCode()
    {
        return m_InputMethodCode;
    }

    public void setInputMethodCode(String setValue)
    {
        if(setValue == null)
        {
            m_InputMethodCode = "";
            return;
        } else
        {
            m_InputMethodCode = setValue;
            return;
        }
    }

    public int getLabel1Length()
    {
        return m_Label1Length;
    }

    public void setLabel1Length(int setValue)
    {
        m_Label1Length = setValue;
    }

    public String getLabel1Data()
    {
        return m_Label1Data;
    }

    public void setLabel1Data(String setValue)
    {
        if(setValue == null)
        {
            m_Label1Data = "";
            return;
        } else
        {
            m_Label1Data = setValue;
            return;
        }
    }

    public int getLabel2Length()
    {
        return m_Label2Length;
    }

    public void setLabel2Length(int setValue)
    {
        m_Label2Length = setValue;
    }

    public String getLabel2Data()
    {
        return m_Label2Data;
    }

    public void setLabel2Data(String setValue)
    {
        if(setValue == null)
        {
            m_Label2Data = "";
            return;
        } else
        {
            m_Label2Data = setValue;
            return;
        }
    }

    public int getLabel3Length()
    {
        return m_Label3Length;
    }

    public void setLabel3Length(int setValue)
    {
        m_Label3Length = setValue;
    }

    public String getLabel3Data()
    {
        return m_Label3Data;
    }

    public void setLabel3Data(String setValue)
    {
        if(setValue == null)
        {
            m_Label3Data = "";
            return;
        } else
        {
            m_Label3Data = setValue;
            return;
        }
    }

    public String getHandlingInstructionCode()
    {
        return m_HandlingInstructionCode;
    }

    public void setHandlingInstructionCode(String setValue)
    {
        if(setValue == null)
        {
            m_HandlingInstructionCode = "";
            return;
        } else
        {
            m_HandlingInstructionCode = setValue;
            return;
        }
    }

    public String getHandlingInstructionDesc()
    {
        return m_HandlingInstructionDesc;
    }

    public void setHandlingInstructionDesc(String setValue)
    {
        if(setValue == null)
        {
            m_HandlingInstructionDesc = "";
            return;
        } else
        {
            m_HandlingInstructionDesc = setValue;
            return;
        }
    }

    public String getShipmentRemarkCode()
    {
        return m_ShipmentRemarkCode;
    }

    public void setShipmentRemarkCode(String setValue)
    {
        if(setValue == null)
        {
            m_ShipmentRemarkCode = "";
            return;
        } else
        {
            m_ShipmentRemarkCode = setValue;
            return;
        }
    }

    public String getShipmentRemarkDesc()
    {
        return m_ShipmentRemarkDesc;
    }

    public void setShipmentRemarkDesc(String setValue)
    {
        if(setValue == null)
        {
            m_ShipmentRemarkDesc = "";
            return;
        } else
        {
            m_ShipmentRemarkDesc = setValue;
            return;
        }
    }

    public String getReturnAWBNumber()
    {
        return m_ReturnAWBNumber;
    }

    public void setReturnAWBNumber(String setValue)
    {
        if(setValue == null)
        {
            m_ReturnAWBNumber = "";
            return;
        } else
        {
            m_ReturnAWBNumber = setValue;
            return;
        }
    }

    public String getTravelStatus()
    {
        return m_TravelStatus;
    }

    public void setTravelStatus(String setValue)
    {
        if(setValue == null)
        {
            m_TravelStatus = "";
            return;
        } else
        {
            m_TravelStatus = setValue;
            return;
        }
    }

    public String getSplitFunction()
    {
        return m_SplitFunction;
    }

    public void setSplitFunction(String setValue)
    {
        if(setValue == null)
        {
            m_SplitFunction = "";
            return;
        } else
        {
            m_SplitFunction = setValue;
            return;
        }
    }

    public String getSplitLocation()
    {
        return m_SplitLocation;
    }

    public void setSplitLocation(String setValue)
    {
        if(setValue == null)
        {
            m_SplitLocation = "";
            return;
        } else
        {
            m_SplitLocation = setValue;
            return;
        }
    }

    public String getSplitNumber()
    {
        return m_SplitNumber;
    }

    public void setSplitNumber(String setValue)
    {
        if(setValue == null)
        {
            m_SplitNumber = "";
            return;
        } else
        {
            m_SplitNumber = setValue;
            return;
        }
    }

    public String getSplitDestId()
    {
        return m_SplitDestId;
    }

    public void setSplitDestId(String setValue)
    {
        if(setValue == null)
        {
            m_SplitDestId = "";
            return;
        } else
        {
            m_SplitDestId = setValue;
            return;
        }
    }

    public String getSplitArray()
    {
        return m_SplitArray;
    }

    public void setSplitArray(String setValue)
    {
        if(setValue == null)
        {
            m_SplitArray = "";
            return;
        } else
        {
            m_SplitArray = setValue;
            return;
        }
    }

    public String getSplitServices()
    {
        return m_SplitServices;
    }

    public void setSplitServices(String setValue)
    {
        if(setValue == null)
        {
            m_SplitServices = "";
            return;
        } else
        {
            m_SplitServices = setValue;
            return;
        }
    }

    public String getSplitHandling()
    {
        return m_SplitHandling;
    }

    public void setSplitHandling(String setValue)
    {
        if(setValue == null)
        {
            m_SplitHandling = "";
            return;
        } else
        {
            m_SplitHandling = setValue;
            return;
        }
    }

    public String getSplitSpcHandling()
    {
        return m_SplitSpcHandling;
    }

    public void setSplitSpcHandling(String setValue)
    {
        if(setValue == null)
        {
            m_SplitSpcHandling = "";
            return;
        } else
        {
            m_SplitSpcHandling = setValue;
            return;
        }
    }

    public String getSplitBoxDoc()
    {
        return m_SplitBoxDoc;
    }

    public void setSplitBoxDoc(String setValue)
    {
        if(setValue == null)
        {
            m_SplitBoxDoc = "";
            return;
        } else
        {
            m_SplitBoxDoc = setValue;
            return;
        }
    }

    public String getSplitAltSplit()
    {
        return m_SplitAltSplit;
    }

    public void setSplitAltSplit(String setValue)
    {
        if(setValue == null)
        {
            m_SplitAltSplit = "";
            return;
        } else
        {
            m_SplitAltSplit = setValue;
            return;
        }
    }

    public String getSplitType()
    {
        return m_SplitType;
    }

    public void setSplitType(String setValue)
    {
        if(setValue == null)
        {
            m_SplitType = "";
            return;
        } else
        {
            m_SplitType = setValue;
            return;
        }
    }

    public String getSplitIntlDom()
    {
        return m_SplitIntlDom;
    }

    public void setSplitIntlDom(String setValue)
    {
        if(setValue == null)
        {
            m_SplitIntlDom = "";
            return;
        } else
        {
            m_SplitIntlDom = setValue;
            return;
        }
    }

    public String getSplitZipCode()
    {
        return m_SplitZipCode;
    }

    public void setSplitZipCode(String setValue)
    {
        if(setValue == null)
        {
            m_SplitZipCode = "";
            return;
        } else
        {
            m_SplitZipCode = setValue;
            return;
        }
    }

    public Date getConsScanDate()
    {
        return m_ConsScanDate;
    }

    public void setConsScanDate(Date setValue)
    {
        m_ConsScanDate = setValue;
    }

    public Date getConsCreateDate()
    {
        return m_ConsCreateDate;
    }

    public void setConsCreateDate(Date setValue)
    {
        m_ConsCreateDate = setValue;
    }

    public Date getConsComponentDate()
    {
        return m_ConsComponentDate;
    }

    public void setConsComponentDate(Date setValue)
    {
        m_ConsComponentDate = setValue;
    }

    public Date getConsDeconsDate()
    {
        return m_ConsDeconsDate;
    }

    public void setConsDeconsDate(Date setValue)
    {
        m_ConsDeconsDate = setValue;
    }

    public String getConsNoiDestLocCode()
    {
        return m_ConsNoiDestLocCode;
    }

    public void setConsNoiDestLocCode(String setValue)
    {
        if(setValue == null)
        {
            m_ConsNoiDestLocCode = "";
            return;
        } else
        {
            m_ConsNoiDestLocCode = setValue;
            return;
        }
    }

    public String getConsScanLocCode()
    {
        return m_ConsScanLocCode;
    }

    public void setConsScanLocCode(String setValue)
    {
        if(setValue == null)
        {
            m_ConsScanLocCode = "";
            return;
        } else
        {
            m_ConsScanLocCode = setValue;
            return;
        }
    }

    public String getFlightOriginLocCode()
    {
        return m_FlightOriginLocCode;
    }

    public void setFlightOriginLocCode(String setValue)
    {
        if(setValue == null)
        {
            m_FlightOriginLocCode = "";
            return;
        } else
        {
            m_FlightOriginLocCode = setValue;
            return;
        }
    }

    public String getFlightDestLocCode()
    {
        return m_FlightDestLocCode;
    }

    public void setFlightDestLocCode(String setValue)
    {
        if(setValue == null)
        {
            m_FlightDestLocCode = "";
            return;
        } else
        {
            m_FlightDestLocCode = setValue;
            return;
        }
    }

    public int getHAWBSerialNumber()
    {
        return m_HAWBSerialNumber;
    }

    public void setHAWBSerialNumber(int setValue)
    {
        m_HAWBSerialNumber = setValue;
    }

    public String getOriginLocationCode()
    {
        return m_OriginLocationCode;
    }

    public void setOriginLocationCode(String setValue)
    {
        if(setValue == null)
        {
            m_OriginLocationCode = "";
            return;
        } else
        {
            m_OriginLocationCode = setValue;
            return;
        }
    }

    public String getTransCode()
    {
        return m_TransCode;
    }

    public void setTransCode(String setValue)
    {
        if(setValue == null)
        {
            m_TransCode = "";
            return;
        } else
        {
            m_TransCode = setValue;
            return;
        }
    }

    public String getEntryNumber()
    {
        return m_EntryNumber;
    }

    public void setEntryNumber(String setValue)
    {
        if(setValue == null)
        {
            m_EntryNumber = "";
            return;
        } else
        {
            m_EntryNumber = setValue;
            return;
        }
    }

    public String getEntryType()
    {
        return m_EntryType;
    }

    public void setEntryType(String setValue)
    {
        if(setValue == null)
        {
            m_EntryType = "";
            return;
        } else
        {
            m_EntryType = setValue;
            return;
        }
    }

    public String getEntryValRestOverride()
    {
        return m_EntryValRestOverride;
    }

    public void setEntryValRestOverride(String setValue)
    {
        if(setValue == null)
        {
            m_EntryValRestOverride = "";
            return;
        } else
        {
            m_EntryValRestOverride = setValue;
            return;
        }
    }

    public String toString()
    {
        String s = "Data Object:  " + getClass().getName() + "\n\n";
        s = s + "ReturnStatus\t\t = " + m_ReturnStatus + "\n";
        s = s + "ReturnMessage\t\t = " + m_ReturnMessage + "\n";
        s = s + "InViewName\t\t = " + m_InViewName + "\n";
        s = s + "OutViewName\t\t = " + m_OutViewName + "\n";
        s = s + "SysDateTime\t\t = " + m_SysDateTime + "\n";
        s = s + "SysDateTimeNoMilliSeconds\t\t = " + m_SysDateTimeNoMilliSeconds + "\n";
        s = s + "UserLogon\t\t = " + m_UserLogon + "\n";
        s = s + "OrgCode\t\t = " + m_OrgCode + "\n";
        s = s + "InputDevice\t\t = " + m_InputDevice + "\n";
        s = s + "ErrorNumber\t\t = " + m_ErrorNumber + "\n";
        s = s + "FromConsFlag\t\t = " + m_FromConsFlag + "\n";
        s = s + "AirbillNumber\t\t = " + m_AirbillNumber + "\n";
        s = s + "AirbillType\t\t = " + m_AirbillType + "\n";
        s = s + "AirbillFormType\t\t = " + m_AirbillFormType + "\n";
        s = s + "AirbillEntry\t\t = " + m_AirbillEntry + "\n";
        s = s + "AstraData\t\t = " + m_AstraData + "\n";
        s = s + "HandlingUnitOid\t\t = " + m_HandlingUnitOid + "\n";
        s = s + "HAWB\t\t = " + m_HAWB + "\n";
        s = s + "HAWBFormType\t\t = " + m_HAWBFormType + "\n";
        s = s + "ShipmentOid\t\t = " + m_ShipmentOid + "\n";
        s = s + "HAWBUnknownFlag\t\t = " + m_HAWBUnknownFlag + "\n";
        s = s + "ReasonCode\t\t = " + m_ReasonCode + "\n";
        s = s + "ReleaseCode\t\t = " + m_ReleaseCode + "\n";
        s = s + "DetainLoc\t\t = " + m_DetainLoc + "\n";
        s = s + "InterceptCode\t\t = " + m_InterceptCode + "\n";
        s = s + "PrinterCode\t\t = " + m_PrinterCode + "\n";
        s = s + "RouteNumber\t\t = " + m_RouteNumber + "\n";
        s = s + "RouteLegDate\t\t = " + m_RouteLegDate + "\n";
        s = s + "RouteLegOid\t\t = " + m_RouteLegOid + "\n";
        s = s + "StagingAreaCode\t\t = " + m_StagingAreaCode + "\n";
        s = s + "LocStatNbr\t\t = " + m_LocStatNbr + "\n";
        s = s + "Comments\t\t = " + m_Comments + "\n";
        s = s + "Astray\t\t = " + m_Astray + "\n";
        s = s + "MdeRoute\t\t = " + m_MdeRoute + "\n";
        s = s + "FlightNumber\t\t = " + m_FlightNumber + "\n";
        s = s + "FlightDate\t\t = " + m_FlightDate + "\n";
        s = s + "PkgRouted\t\t = " + m_PkgRouted + "\n";
        s = s + "ServiceCode\t\t = " + m_ServiceCode + "\n";
        s = s + "HandlingCodes\t\t = " + m_HandlingCodes + "\n";
        s = s + "HalPostal\t\t = " + m_HalPostal + "\n";
        s = s + "DestPostal\t\t = " + m_DestPostal + "\n";
        s = s + "RoutingId\t\t = " + m_RoutingId + "\n";
        s = s + "DelCommit\t\t = " + m_DelCommit + "\n";
        s = s + "DestCountry\t\t = " + m_DestCountry + "\n";
        s = s + "PkgCondition\t\t = " + m_PkgCondition + "\n";
        s = s + "ConsId\t\t = " + m_ConsId + "\n";
        s = s + "ConsFormType\t\t = " + m_ConsFormType + "\n";
        s = s + "ConsType\t\t = " + m_ConsType + "\n";
        s = s + "ContainerInd\t\t = " + m_ContainerInd + "\n";
        s = s + "ContainerId\t\t = " + m_ContainerId + "\n";
        s = s + "ConsDestLoc\t\t = " + m_ConsDestLoc + "\n";
        s = s + "ConsOid\t\t = " + m_ConsOid + "\n";
        s = s + "SplitName\t\t = " + m_SplitName + "\n";
        s = s + "ActionCode\t\t = " + m_ActionCode + "\n";
        s = s + "AgencyCode\t\t = " + m_AgencyCode + "\n";
        s = s + "LocationCode\t\t = " + m_LocationCode + "\n";
        s = s + "WarehouseCode\t\t = " + m_WarehouseCode + "\n";
        s = s + "BrokerClassificationCode\t\t = " + m_BrokerClassificationCode + "\n";
        s = s + "TransactionTimestamp\t\t = " + m_TransactionTimestamp + "\n";
        s = s + "RouteStatusCode\t\t = " + m_RouteStatusCode + "\n";
        s = s + "PreviousBondInFlag\t\t = " + m_PreviousBondInFlag + "\n";
        s = s + "DestLocationCode\t\t = " + m_DestLocationCode + "\n";
        s = s + "AddressChangeFlag\t\t = " + m_AddressChangeFlag + "\n";
        s = s + "DeclarationCode\t\t = " + m_DeclarationCode + "\n";
        s = s + "ShuttleID\t\t = " + m_ShuttleID + "\n";
        s = s + "CustomsReleasedFlag\t\t = " + m_CustomsReleasedFlag + "\n";
        s = s + "InputMethodCode\t\t = " + m_InputMethodCode + "\n";
        s = s + "Label1Length\t\t = " + m_Label1Length + "\n";
        s = s + "Label1Data\t\t = " + m_Label1Data + "\n";
        s = s + "Label2Length\t\t = " + m_Label2Length + "\n";
        s = s + "Label2Data\t\t = " + m_Label2Data + "\n";
        s = s + "Label3Length\t\t = " + m_Label3Length + "\n";
        s = s + "Label3Data\t\t = " + m_Label3Data + "\n";
        s = s + "HandlingInstructionCode\t\t = " + m_HandlingInstructionCode + "\n";
        s = s + "HandlingInstructionDesc\t\t = " + m_HandlingInstructionDesc + "\n";
        s = s + "ShipmentRemarkCode\t\t = " + m_ShipmentRemarkCode + "\n";
        s = s + "ShipmentRemarkDesc\t\t = " + m_ShipmentRemarkDesc + "\n";
        s = s + "ReturnAWBNumber\t\t = " + m_ReturnAWBNumber + "\n";
        s = s + "TravelStatus\t\t = " + m_TravelStatus + "\n";
        s = s + "SplitFunction\t\t = " + m_SplitFunction + "\n";
        s = s + "SplitLocation\t\t = " + m_SplitLocation + "\n";
        s = s + "SplitNumber\t\t = " + m_SplitNumber + "\n";
        s = s + "SplitDestId\t\t = " + m_SplitDestId + "\n";
        s = s + "SplitArray\t\t = " + m_SplitArray + "\n";
        s = s + "SplitServices\t\t = " + m_SplitServices + "\n";
        s = s + "SplitHandling\t\t = " + m_SplitHandling + "\n";
        s = s + "SplitSpcHandling\t\t = " + m_SplitSpcHandling + "\n";
        s = s + "SplitBoxDoc\t\t = " + m_SplitBoxDoc + "\n";
        s = s + "SplitAltSplit\t\t = " + m_SplitAltSplit + "\n";
        s = s + "SplitType\t\t = " + m_SplitType + "\n";
        s = s + "SplitIntlDom\t\t = " + m_SplitIntlDom + "\n";
        s = s + "SplitZipCode\t\t = " + m_SplitZipCode + "\n";
        s = s + "ConsScanDate\t\t = " + m_ConsScanDate + "\n";
        s = s + "ConsCreateDate\t\t = " + m_ConsCreateDate + "\n";
        s = s + "ConsComponentDate\t\t = " + m_ConsComponentDate + "\n";
        s = s + "ConsDeconsDate\t\t = " + m_ConsDeconsDate + "\n";
        s = s + "ConsNoiDestLocCode\t\t = " + m_ConsNoiDestLocCode + "\n";
        s = s + "ConsScanLocCode\t\t = " + m_ConsScanLocCode + "\n";
        s = s + "FlightOriginLocCode\t\t = " + m_FlightOriginLocCode + "\n";
        s = s + "FlightDestLocCode\t\t = " + m_FlightDestLocCode + "\n";
        s = s + "HAWBSerialNumber\t\t = " + m_HAWBSerialNumber + "\n";
        s = s + "OriginLocationCode\t\t = " + m_OriginLocationCode + "\n";
        s = s + "TransCode\t\t = " + m_TransCode + "\n";
        s = s + "EntryNumber\t\t = " + m_EntryNumber + "\n";
        s = s + "EntryType\t\t = " + m_EntryType + "\n";
        s = s + "EntryValRestOverride\t\t = " + m_EntryValRestOverride + "\n";
        return s;
    }

    public Object clone()
    {
        RPBScanBase copy = null;
        try
        {
            copy = (RPBScanBase)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError(e.toString());
        }
        if(getRouteLegDate() == null)
            copy.setRouteLegDate(null);
        else
            copy.setRouteLegDate((Date)getRouteLegDate().clone());
        if(getTransactionTimestamp() == null)
            copy.setTransactionTimestamp(null);
        else
            copy.setTransactionTimestamp((Date)getTransactionTimestamp().clone());
        if(getConsScanDate() == null)
            copy.setConsScanDate(null);
        else
            copy.setConsScanDate((Date)getConsScanDate().clone());
        if(getConsCreateDate() == null)
            copy.setConsCreateDate(null);
        else
            copy.setConsCreateDate((Date)getConsCreateDate().clone());
        if(getConsComponentDate() == null)
            copy.setConsComponentDate(null);
        else
            copy.setConsComponentDate((Date)getConsComponentDate().clone());
        if(getConsDeconsDate() == null)
            copy.setConsDeconsDate(null);
        else
            copy.setConsDeconsDate((Date)getConsDeconsDate().clone());
        return copy;
    }

    protected double m_ReturnStatus;
    protected String m_ReturnMessage;
    protected String m_InViewName;
    protected String m_OutViewName;
    protected long m_SysDateTime;
    protected long m_SysDateTimeNoMilliSeconds;
    protected String m_UserLogon;
    protected String m_OrgCode;
    protected String m_InputDevice;
    protected int m_ErrorNumber;
    protected String m_FromConsFlag;
    protected String m_AirbillNumber;
    protected String m_AirbillType;
    protected String m_AirbillFormType;
    protected String m_AirbillEntry;
    protected String m_AstraData;
    protected int m_HandlingUnitOid;
    protected String m_HAWB;
    protected String m_HAWBFormType;
    protected int m_ShipmentOid;
    protected String m_HAWBUnknownFlag;
    protected String m_ReasonCode;
    protected String m_ReleaseCode;
    protected String m_DetainLoc;
    protected String m_InterceptCode;
    protected String m_PrinterCode;
    protected String m_RouteNumber;
    protected Date m_RouteLegDate;
    protected int m_RouteLegOid;
    protected String m_StagingAreaCode;
    protected String m_LocStatNbr;
    protected String m_Comments;
    protected String m_Astray;
    protected String m_MdeRoute;
    protected String m_FlightNumber;
    protected String m_FlightDate;
    protected String m_PkgRouted;
    protected String m_ServiceCode;
    protected String m_HandlingCodes;
    protected String m_HalPostal;
    protected String m_DestPostal;
    protected String m_RoutingId;
    protected String m_DelCommit;
    protected String m_DestCountry;
    protected String m_PkgCondition;
    protected String m_ConsId;
    protected String m_ConsFormType;
    protected String m_ConsType;
    protected String m_ContainerInd;
    protected String m_ContainerId;
    protected String m_ConsDestLoc;
    protected int m_ConsOid;
    protected String m_SplitName;
    protected String m_ActionCode;
    protected String m_AgencyCode;
    protected String m_LocationCode;
    protected String m_WarehouseCode;
    protected String m_BrokerClassificationCode;
    protected Date m_TransactionTimestamp;
    protected String m_RouteStatusCode;
    protected boolean m_PreviousBondInFlag;
    protected String m_DestLocationCode;
    protected boolean m_AddressChangeFlag;
    protected String m_DeclarationCode;
    protected String m_ShuttleID;
    protected String m_CustomsReleasedFlag;
    protected String m_InputMethodCode;
    protected int m_Label1Length;
    protected String m_Label1Data;
    protected int m_Label2Length;
    protected String m_Label2Data;
    protected int m_Label3Length;
    protected String m_Label3Data;
    protected String m_HandlingInstructionCode;
    protected String m_HandlingInstructionDesc;
    protected String m_ShipmentRemarkCode;
    protected String m_ShipmentRemarkDesc;
    protected String m_ReturnAWBNumber;
    protected String m_TravelStatus;
    protected String m_SplitFunction;
    protected String m_SplitLocation;
    protected String m_SplitNumber;
    protected String m_SplitDestId;
    protected String m_SplitArray;
    protected String m_SplitServices;
    protected String m_SplitHandling;
    protected String m_SplitSpcHandling;
    protected String m_SplitBoxDoc;
    protected String m_SplitAltSplit;
    protected String m_SplitType;
    protected String m_SplitIntlDom;
    protected String m_SplitZipCode;
    protected Date m_ConsScanDate;
    protected Date m_ConsCreateDate;
    protected Date m_ConsComponentDate;
    protected Date m_ConsDeconsDate;
    protected String m_ConsNoiDestLocCode;
    protected String m_ConsScanLocCode;
    protected String m_FlightOriginLocCode;
    protected String m_FlightDestLocCode;
    protected int m_HAWBSerialNumber;
    protected String m_OriginLocationCode;
    protected String m_TransCode;
    protected String m_EntryNumber;
    protected String m_EntryType;
    protected String m_EntryValRestOverride;
}
