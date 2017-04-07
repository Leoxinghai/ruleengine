// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UploadStatusBase.java

package cciij.cciidata;

import java.io.Serializable;

public class UploadStatusBase
    implements Cloneable, Serializable
{

    public UploadStatusBase()
    {
    }

    public UploadStatusBase(boolean BSOFlag, boolean BondTransferFlag, boolean DocFlag, boolean FedExShuttleFlag, boolean ODAShuttleFlag, boolean MPSIncompleteFlag, boolean DamagedFlag, 
            boolean CrushedFlag, boolean WetFlag, boolean TornFlag, boolean RewrappedFlag, boolean RetapedFlag, boolean WrongFlightFlag, boolean FlightDelayFlag, 
            boolean MissedShuttleFlag, boolean AlwaysFlag, boolean InterceptedFlag, boolean ClearedFlag, boolean NonDocFlag, boolean OverageFlag, boolean NotClearedFlag, 
            boolean TravelStatusDomesticFlag, boolean TravelStatusIntlFlag, boolean ConsUploadFlag, boolean NoConsUploadFlag)
    {
        setBSOFlag(BSOFlag);
        setBondTransferFlag(BondTransferFlag);
        setDocFlag(DocFlag);
        setFedExShuttleFlag(FedExShuttleFlag);
        setODAShuttleFlag(ODAShuttleFlag);
        setMPSIncompleteFlag(MPSIncompleteFlag);
        setDamagedFlag(DamagedFlag);
        setCrushedFlag(CrushedFlag);
        setWetFlag(WetFlag);
        setTornFlag(TornFlag);
        setRewrappedFlag(RewrappedFlag);
        setRetapedFlag(RetapedFlag);
        setWrongFlightFlag(WrongFlightFlag);
        setFlightDelayFlag(FlightDelayFlag);
        setMissedShuttleFlag(MissedShuttleFlag);
        setAlwaysFlag(AlwaysFlag);
        setInterceptedFlag(InterceptedFlag);
        setClearedFlag(ClearedFlag);
        setNonDocFlag(NonDocFlag);
        setOverageFlag(OverageFlag);
        setNotClearedFlag(NotClearedFlag);
        setTravelStatusDomesticFlag(TravelStatusDomesticFlag);
        setTravelStatusIntlFlag(TravelStatusIntlFlag);
        setConsUploadFlag(ConsUploadFlag);
        setNoConsUploadFlag(NoConsUploadFlag);
    }

    public boolean getBSOFlag()
    {
        return m_BSOFlag;
    }

    public void setBSOFlag(boolean setValue)
    {
        m_BSOFlag = setValue;
    }

    public boolean getBondTransferFlag()
    {
        return m_BondTransferFlag;
    }

    public void setBondTransferFlag(boolean setValue)
    {
        m_BondTransferFlag = setValue;
    }

    public boolean getDocFlag()
    {
        return m_DocFlag;
    }

    public void setDocFlag(boolean setValue)
    {
        m_DocFlag = setValue;
    }

    public boolean getFedExShuttleFlag()
    {
        return m_FedExShuttleFlag;
    }

    public void setFedExShuttleFlag(boolean setValue)
    {
        m_FedExShuttleFlag = setValue;
    }

    public boolean getODAShuttleFlag()
    {
        return m_ODAShuttleFlag;
    }

    public void setODAShuttleFlag(boolean setValue)
    {
        m_ODAShuttleFlag = setValue;
    }

    public boolean getMPSIncompleteFlag()
    {
        return m_MPSIncompleteFlag;
    }

    public void setMPSIncompleteFlag(boolean setValue)
    {
        m_MPSIncompleteFlag = setValue;
    }

    public boolean getDamagedFlag()
    {
        return m_DamagedFlag;
    }

    public void setDamagedFlag(boolean setValue)
    {
        m_DamagedFlag = setValue;
    }

    public boolean getCrushedFlag()
    {
        return m_CrushedFlag;
    }

    public void setCrushedFlag(boolean setValue)
    {
        m_CrushedFlag = setValue;
    }

    public boolean getWetFlag()
    {
        return m_WetFlag;
    }

    public void setWetFlag(boolean setValue)
    {
        m_WetFlag = setValue;
    }

    public boolean getTornFlag()
    {
        return m_TornFlag;
    }

    public void setTornFlag(boolean setValue)
    {
        m_TornFlag = setValue;
    }

    public boolean getRewrappedFlag()
    {
        return m_RewrappedFlag;
    }

    public void setRewrappedFlag(boolean setValue)
    {
        m_RewrappedFlag = setValue;
    }

    public boolean getRetapedFlag()
    {
        return m_RetapedFlag;
    }

    public void setRetapedFlag(boolean setValue)
    {
        m_RetapedFlag = setValue;
    }

    public boolean getWrongFlightFlag()
    {
        return m_WrongFlightFlag;
    }

    public void setWrongFlightFlag(boolean setValue)
    {
        m_WrongFlightFlag = setValue;
    }

    public boolean getFlightDelayFlag()
    {
        return m_FlightDelayFlag;
    }

    public void setFlightDelayFlag(boolean setValue)
    {
        m_FlightDelayFlag = setValue;
    }

    public boolean getMissedShuttleFlag()
    {
        return m_MissedShuttleFlag;
    }

    public void setMissedShuttleFlag(boolean setValue)
    {
        m_MissedShuttleFlag = setValue;
    }

    public boolean getAlwaysFlag()
    {
        return m_AlwaysFlag;
    }

    public void setAlwaysFlag(boolean setValue)
    {
        m_AlwaysFlag = setValue;
    }

    public boolean getInterceptedFlag()
    {
        return m_InterceptedFlag;
    }

    public void setInterceptedFlag(boolean setValue)
    {
        m_InterceptedFlag = setValue;
    }

    public boolean getClearedFlag()
    {
        return m_ClearedFlag;
    }

    public void setClearedFlag(boolean setValue)
    {
        m_ClearedFlag = setValue;
    }

    public boolean getNonDocFlag()
    {
        return m_NonDocFlag;
    }

    public void setNonDocFlag(boolean setValue)
    {
        m_NonDocFlag = setValue;
    }

    public boolean getOverageFlag()
    {
        return m_OverageFlag;
    }

    public void setOverageFlag(boolean setValue)
    {
        m_OverageFlag = setValue;
    }

    public boolean getNotClearedFlag()
    {
        return m_NotClearedFlag;
    }

    public void setNotClearedFlag(boolean setValue)
    {
        m_NotClearedFlag = setValue;
    }

    public boolean getTravelStatusDomesticFlag()
    {
        return m_TravelStatusDomesticFlag;
    }

    public void setTravelStatusDomesticFlag(boolean setValue)
    {
        m_TravelStatusDomesticFlag = setValue;
    }

    public boolean getTravelStatusIntlFlag()
    {
        return m_TravelStatusIntlFlag;
    }

    public void setTravelStatusIntlFlag(boolean setValue)
    {
        m_TravelStatusIntlFlag = setValue;
    }

    public boolean getConsUploadFlag()
    {
        return m_ConsUploadFlag;
    }

    public void setConsUploadFlag(boolean setValue)
    {
        m_ConsUploadFlag = setValue;
    }

    public boolean getNoConsUploadFlag()
    {
        return m_NoConsUploadFlag;
    }

    public void setNoConsUploadFlag(boolean setValue)
    {
        m_NoConsUploadFlag = setValue;
    }

    public String toString()
    {
        String s = "Data Object:  " + getClass().getName() + "\n\n";
        s = s + "BSOFlag\t\t = " + m_BSOFlag + "\n";
        s = s + "BondTransferFlag\t\t = " + m_BondTransferFlag + "\n";
        s = s + "DocFlag\t\t = " + m_DocFlag + "\n";
        s = s + "FedExShuttleFlag\t\t = " + m_FedExShuttleFlag + "\n";
        s = s + "ODAShuttleFlag\t\t = " + m_ODAShuttleFlag + "\n";
        s = s + "MPSIncompleteFlag\t\t = " + m_MPSIncompleteFlag + "\n";
        s = s + "DamagedFlag\t\t = " + m_DamagedFlag + "\n";
        s = s + "CrushedFlag\t\t = " + m_CrushedFlag + "\n";
        s = s + "WetFlag\t\t = " + m_WetFlag + "\n";
        s = s + "TornFlag\t\t = " + m_TornFlag + "\n";
        s = s + "RewrappedFlag\t\t = " + m_RewrappedFlag + "\n";
        s = s + "RetapedFlag\t\t = " + m_RetapedFlag + "\n";
        s = s + "WrongFlightFlag\t\t = " + m_WrongFlightFlag + "\n";
        s = s + "FlightDelayFlag\t\t = " + m_FlightDelayFlag + "\n";
        s = s + "MissedShuttleFlag\t\t = " + m_MissedShuttleFlag + "\n";
        s = s + "AlwaysFlag\t\t = " + m_AlwaysFlag + "\n";
        s = s + "InterceptedFlag\t\t = " + m_InterceptedFlag + "\n";
        s = s + "ClearedFlag\t\t = " + m_ClearedFlag + "\n";
        s = s + "NonDocFlag\t\t = " + m_NonDocFlag + "\n";
        s = s + "OverageFlag\t\t = " + m_OverageFlag + "\n";
        s = s + "NotClearedFlag\t\t = " + m_NotClearedFlag + "\n";
        s = s + "TravelStatusDomesticFlag\t\t = " + m_TravelStatusDomesticFlag + "\n";
        s = s + "TravelStatusIntlFlag\t\t = " + m_TravelStatusIntlFlag + "\n";
        s = s + "ConsUploadFlag\t\t = " + m_ConsUploadFlag + "\n";
        s = s + "NoConsUploadFlag\t\t = " + m_NoConsUploadFlag + "\n";
        return s;
    }

    public Object clone()
    {
        UploadStatusBase copy = null;
        try
        {
            copy = (UploadStatusBase)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError(e.toString());
        }
        return copy;
    }

    protected boolean m_BSOFlag;
    protected boolean m_BondTransferFlag;
    protected boolean m_DocFlag;
    protected boolean m_FedExShuttleFlag;
    protected boolean m_ODAShuttleFlag;
    protected boolean m_MPSIncompleteFlag;
    protected boolean m_DamagedFlag;
    protected boolean m_CrushedFlag;
    protected boolean m_WetFlag;
    protected boolean m_TornFlag;
    protected boolean m_RewrappedFlag;
    protected boolean m_RetapedFlag;
    protected boolean m_WrongFlightFlag;
    protected boolean m_FlightDelayFlag;
    protected boolean m_MissedShuttleFlag;
    protected boolean m_AlwaysFlag;
    protected boolean m_InterceptedFlag;
    protected boolean m_ClearedFlag;
    protected boolean m_NonDocFlag;
    protected boolean m_OverageFlag;
    protected boolean m_NotClearedFlag;
    protected boolean m_TravelStatusDomesticFlag;
    protected boolean m_TravelStatusIntlFlag;
    protected boolean m_ConsUploadFlag;
    protected boolean m_NoConsUploadFlag;
}
