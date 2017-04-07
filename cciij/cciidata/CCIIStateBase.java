// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CCIIStateBase.java

package cciij.cciidata;

import com.fedex.css.ruleprocessor.State;
import java.util.*;
import rmtc.util.TemplateParserDataSourceInterface;

// Referenced classes of package cciij.cciidata:
//            RPBScan, UploadStatus, RouteLeg, Scan

public class CCIIStateBase extends State
    implements TemplateParserDataSourceInterface
{
    private class objectMethodID
    {

        public int getObjectID()
        {
            return m_objectID;
        }

        public int getMethodID()
        {
            return m_methodID;
        }

        int m_objectID;
        int m_methodID;

        public objectMethodID(int objectID, int methodID)
        {
            m_objectID = 0;
            m_methodID = 0;
            m_objectID = objectID;
            m_methodID = methodID;
        }
    }


    public CCIIStateBase()
    {
        m_Scan = new RPBScan();
        m_UploadStatus = new UploadStatus();
        m_ActivityCodes = new Vector();
        m_PrintData = new TreeMap();
        m_ExceptionActivityCodes = new Vector();
        m_RouteLegInfo = new RouteLeg();
        m_CAGEReasonCodes = new Vector();
        m_CAGEReleaseCodes = new Vector();
        m_HandlingInstructions = new Vector();
        m_ShipmentRemarks = new Vector();
        m_UploadKey = new Vector();
        m_ScanVectorElement = new Vector();
        m_CurrentScan = new Scan();
        m_OverageFlag = "";
        m_InterceptedFlag = "";
        m_MPSFlag = "";
        m_UploadFlag = "";
        m_ScanTypeCode = "";
        m_AgencyCode = "";
        m_DiverterCode = "";
        m_AlwaysEmptyString = "";
        m_StagingArea = "";
        m_DuplicateFlag = "";
        m_TravelStatus = "";
        m_IntransitFlag = "";
        m_AbScanned = "";
        m_AbFormTypeScanned = "";
        m_AbTypeScanned = "";
        m_ServiceCode = "";
    }

    public CCIIStateBase(String OverageFlag, String InterceptedFlag, String MPSFlag, String UploadFlag, String ScanTypeCode, String AgencyCode, String DiverterCode, 
            String AlwaysEmptyString, boolean DuplicateResolution, boolean RouteVerification, boolean SortDateVerification, boolean PositiveSort, Date CurrentSortDate, String StagingArea, 
            boolean MPSStagingFlag, String DuplicateFlag, boolean PieceLevelIntercept, boolean RecuringInterceptFlag, boolean MPSOverageFlag, boolean CAGEReasonCodeFlag, boolean CAGEReleaseCodeFlag, 
            boolean HandlingInstructionFlag, boolean ShipmentRemarkFlag, boolean PieceLevelInventory, boolean RecuringInventoryFlag, String TravelStatus, boolean UseExternalLookup, String IntransitFlag, 
            boolean RouteWasClosed, boolean IsManifested, boolean IsPieceManifested, String AbScanned, String AbFormTypeScanned, String AbTypeScanned, String ServiceCode)
    {
        m_Scan = new RPBScan();
        m_UploadStatus = new UploadStatus();
        m_ActivityCodes = new Vector();
        m_PrintData = new TreeMap();
        m_ExceptionActivityCodes = new Vector();
        m_RouteLegInfo = new RouteLeg();
        m_CAGEReasonCodes = new Vector();
        m_CAGEReleaseCodes = new Vector();
        m_HandlingInstructions = new Vector();
        m_ShipmentRemarks = new Vector();
        m_UploadKey = new Vector();
        m_ScanVectorElement = new Vector();
        m_CurrentScan = new Scan();
        m_OverageFlag = "";
        m_InterceptedFlag = "";
        m_MPSFlag = "";
        m_UploadFlag = "";
        m_ScanTypeCode = "";
        m_AgencyCode = "";
        m_DiverterCode = "";
        m_AlwaysEmptyString = "";
        m_StagingArea = "";
        m_DuplicateFlag = "";
        m_TravelStatus = "";
        m_IntransitFlag = "";
        m_AbScanned = "";
        m_AbFormTypeScanned = "";
        m_AbTypeScanned = "";
        m_ServiceCode = "";
        setOverageFlag(OverageFlag);
        setInterceptedFlag(InterceptedFlag);
        setMPSFlag(MPSFlag);
        setUploadFlag(UploadFlag);
        setScanTypeCode(ScanTypeCode);
        setAgencyCode(AgencyCode);
        setDiverterCode(DiverterCode);
        setAlwaysEmptyString(AlwaysEmptyString);
        setDuplicateResolution(DuplicateResolution);
        setRouteVerification(RouteVerification);
        setSortDateVerification(SortDateVerification);
        setPositiveSort(PositiveSort);
        setCurrentSortDate(CurrentSortDate);
        setStagingArea(StagingArea);
        setMPSStagingFlag(MPSStagingFlag);
        setDuplicateFlag(DuplicateFlag);
        setPieceLevelIntercept(PieceLevelIntercept);
        setRecuringInterceptFlag(RecuringInterceptFlag);
        setMPSOverageFlag(MPSOverageFlag);
        setCAGEReasonCodeFlag(CAGEReasonCodeFlag);
        setCAGEReleaseCodeFlag(CAGEReleaseCodeFlag);
        setHandlingInstructionFlag(HandlingInstructionFlag);
        setShipmentRemarkFlag(ShipmentRemarkFlag);
        setPieceLevelInventory(PieceLevelInventory);
        setRecuringInventoryFlag(RecuringInventoryFlag);
        setTravelStatus(TravelStatus);
        setUseExternalLookup(UseExternalLookup);
        setIntransitFlag(IntransitFlag);
        setRouteWasClosed(RouteWasClosed);
        setIsManifested(IsManifested);
        setIsPieceManifested(IsPieceManifested);
        setAbScanned(AbScanned);
        setAbFormTypeScanned(AbFormTypeScanned);
        setAbTypeScanned(AbTypeScanned);
        setServiceCode(ServiceCode);
    }

    public Object getContainedClass(int classID, int methodID)
    {
        Object retVal = null;
        switch(classID)
        {
        default:
            break;

        case 1: // '\001'
            switch(methodID)
            {
            case 10: // '\n'
                retVal = getOverageFlag();
                break;

            case 11: // '\013'
                retVal = getInterceptedFlag();
                break;

            case 13: // '\r'
                retVal = getMPSFlag();
                break;

            case 14: // '\016'
                retVal = getUploadFlag();
                break;

            case 15: // '\017'
                retVal = getScanTypeCode();
                break;

            case 16: // '\020'
                retVal = getAgencyCode();
                break;

            case 17: // '\021'
                retVal = getDiverterCode();
                break;

            case 18: // '\022'
                retVal = getAlwaysEmptyString();
                break;

            case 19: // '\023'
                retVal = new Boolean(getDuplicateResolution());
                break;

            case 20: // '\024'
                retVal = new Boolean(getRouteVerification());
                break;

            case 21: // '\025'
                retVal = new Boolean(getSortDateVerification());
                break;

            case 22: // '\026'
                retVal = new Boolean(getPositiveSort());
                break;

            case 24: // '\030'
                retVal = getStagingArea();
                break;

            case 25: // '\031'
                retVal = new Boolean(getMPSStagingFlag());
                break;

            case 26: // '\032'
                retVal = getDuplicateFlag();
                break;

            case 27: // '\033'
                retVal = new Boolean(getPieceLevelIntercept());
                break;

            case 28: // '\034'
                retVal = new Boolean(getRecuringInterceptFlag());
                break;

            case 29: // '\035'
                retVal = new Boolean(getMPSOverageFlag());
                break;

            case 30: // '\036'
                retVal = new Boolean(getCAGEReasonCodeFlag());
                break;

            case 31: // '\037'
                retVal = new Boolean(getCAGEReleaseCodeFlag());
                break;

            case 32: // ' '
                retVal = new Boolean(getHandlingInstructionFlag());
                break;

            case 33: // '!'
                retVal = new Boolean(getShipmentRemarkFlag());
                break;

            case 34: // '"'
                retVal = new Boolean(getPieceLevelInventory());
                break;

            case 35: // '#'
                retVal = new Boolean(getRecuringInventoryFlag());
                break;

            case 36: // '$'
                retVal = getTravelStatus();
                break;

            case 37: // '%'
                retVal = new Boolean(getUseExternalLookup());
                break;

            case 38: // '&'
                retVal = getIntransitFlag();
                break;

            case 39: // '\''
                retVal = new Boolean(getRouteWasClosed());
                break;

            case 40: // '('
                retVal = new Boolean(getIsManifested());
                break;

            case 41: // ')'
                retVal = new Boolean(getIsPieceManifested());
                break;

            case 42: // '*'
                retVal = getAbScanned();
                break;

            case 43: // '+'
                retVal = getAbFormTypeScanned();
                break;

            case 44: // ','
                retVal = getAbTypeScanned();
                break;

            case 45: // '-'
                retVal = getServiceCode();
                break;
            }
            break;

        case 2: // '\002'
            switch(methodID)
            {
            case 110: // 'n'
                retVal = new Double(getScan().getReturnStatus());
                break;

            case 111: // 'o'
                retVal = getScan().getReturnMessage();
                break;

            case 112: // 'p'
                retVal = getScan().getInViewName();
                break;

            case 113: // 'q'
                retVal = getScan().getOutViewName();
                break;

            case 114: // 'r'
                retVal = new Long(getScan().getSysDateTime());
                break;

            case 115: // 's'
                retVal = new Long(getScan().getSysDateTimeNoMilliSeconds());
                break;

            case 116: // 't'
                retVal = getScan().getUserLogon();
                break;

            case 117: // 'u'
                retVal = getScan().getOrgCode();
                break;

            case 118: // 'v'
                retVal = getScan().getInputDevice();
                break;

            case 119: // 'w'
                retVal = new Integer(getScan().getErrorNumber());
                break;

            case 120: // 'x'
                retVal = getScan().getFromConsFlag();
                break;

            case 121: // 'y'
                retVal = getScan().getAirbillNumber();
                break;

            case 122: // 'z'
                retVal = getScan().getAirbillType();
                break;

            case 123: // '{'
                retVal = getScan().getAirbillFormType();
                break;

            case 124: // '|'
                retVal = getScan().getAirbillEntry();
                break;

            case 125: // '}'
                retVal = getScan().getAstraData();
                break;

            case 126: // '~'
                retVal = new Integer(getScan().getHandlingUnitOid());
                break;

            case 127: // '\177'
                retVal = getScan().getHAWB();
                break;

            case 128: 
                retVal = getScan().getHAWBFormType();
                break;

            case 129: 
                retVal = new Integer(getScan().getShipmentOid());
                break;

            case 130: 
                retVal = getScan().getHAWBUnknownFlag();
                break;

            case 131: 
                retVal = getScan().getReasonCode();
                break;

            case 132: 
                retVal = getScan().getReleaseCode();
                break;

            case 133: 
                retVal = getScan().getDetainLoc();
                break;

            case 134: 
                retVal = getScan().getInterceptCode();
                break;

            case 135: 
                retVal = getScan().getPrinterCode();
                break;

            case 136: 
                retVal = getScan().getRouteNumber();
                break;

            case 138: 
                retVal = new Integer(getScan().getRouteLegOid());
                break;

            case 139: 
                retVal = getScan().getStagingAreaCode();
                break;

            case 140: 
                retVal = getScan().getLocStatNbr();
                break;

            case 141: 
                retVal = getScan().getComments();
                break;

            case 142: 
                retVal = getScan().getAstray();
                break;

            case 143: 
                retVal = getScan().getMdeRoute();
                break;

            case 144: 
                retVal = getScan().getFlightNumber();
                break;

            case 145: 
                retVal = getScan().getFlightDate();
                break;

            case 146: 
                retVal = getScan().getPkgRouted();
                break;

            case 147: 
                retVal = getScan().getServiceCode();
                break;

            case 148: 
                retVal = getScan().getHandlingCodes();
                break;

            case 149: 
                retVal = getScan().getHalPostal();
                break;

            case 150: 
                retVal = getScan().getDestPostal();
                break;

            case 151: 
                retVal = getScan().getRoutingId();
                break;

            case 152: 
                retVal = getScan().getDelCommit();
                break;

            case 153: 
                retVal = getScan().getDestCountry();
                break;

            case 154: 
                retVal = getScan().getPkgCondition();
                break;

            case 155: 
                retVal = getScan().getConsId();
                break;

            case 156: 
                retVal = getScan().getConsFormType();
                break;

            case 157: 
                retVal = getScan().getConsType();
                break;

            case 158: 
                retVal = getScan().getContainerInd();
                break;

            case 159: 
                retVal = getScan().getContainerId();
                break;

            case 160: 
                retVal = getScan().getConsDestLoc();
                break;

            case 161: 
                retVal = new Integer(getScan().getConsOid());
                break;

            case 162: 
                retVal = getScan().getSplitName();
                break;

            case 163: 
                retVal = getScan().getActionCode();
                break;

            case 164: 
                retVal = getScan().getAgencyCode();
                break;

            case 165: 
                retVal = getScan().getLocationCode();
                break;

            case 166: 
                retVal = getScan().getWarehouseCode();
                break;

            case 167: 
                retVal = getScan().getBrokerClassificationCode();
                break;

            case 169: 
                retVal = getScan().getRouteStatusCode();
                break;

            case 170: 
                retVal = new Boolean(getScan().getPreviousBondInFlag());
                break;

            case 171: 
                retVal = getScan().getDestLocationCode();
                break;

            case 172: 
                retVal = new Boolean(getScan().getAddressChangeFlag());
                break;

            case 173: 
                retVal = getScan().getDeclarationCode();
                break;

            case 174: 
                retVal = getScan().getShuttleID();
                break;

            case 175: 
                retVal = getScan().getCustomsReleasedFlag();
                break;

            case 176: 
                retVal = getScan().getInputMethodCode();
                break;

            case 177: 
                retVal = new Integer(getScan().getLabel1Length());
                break;

            case 178: 
                retVal = getScan().getLabel1Data();
                break;

            case 179: 
                retVal = new Integer(getScan().getLabel2Length());
                break;

            case 180: 
                retVal = getScan().getLabel2Data();
                break;

            case 181: 
                retVal = new Integer(getScan().getLabel3Length());
                break;

            case 182: 
                retVal = getScan().getLabel3Data();
                break;

            case 183: 
                retVal = getScan().getHandlingInstructionCode();
                break;

            case 184: 
                retVal = getScan().getHandlingInstructionDesc();
                break;

            case 185: 
                retVal = getScan().getShipmentRemarkCode();
                break;

            case 186: 
                retVal = getScan().getShipmentRemarkDesc();
                break;

            case 187: 
                retVal = getScan().getReturnAWBNumber();
                break;

            case 188: 
                retVal = getScan().getTravelStatus();
                break;

            case 189: 
                retVal = getScan().getSplitFunction();
                break;

            case 190: 
                retVal = getScan().getSplitLocation();
                break;

            case 191: 
                retVal = getScan().getSplitNumber();
                break;

            case 192: 
                retVal = getScan().getSplitDestId();
                break;

            case 193: 
                retVal = getScan().getSplitArray();
                break;

            case 194: 
                retVal = getScan().getSplitServices();
                break;

            case 195: 
                retVal = getScan().getSplitHandling();
                break;

            case 196: 
                retVal = getScan().getSplitSpcHandling();
                break;

            case 197: 
                retVal = getScan().getSplitBoxDoc();
                break;

            case 198: 
                retVal = getScan().getSplitAltSplit();
                break;

            case 199: 
                retVal = getScan().getSplitType();
                break;

            case 200: 
                retVal = getScan().getSplitIntlDom();
                break;

            case 201: 
                retVal = getScan().getSplitZipCode();
                break;

            case 206: 
                retVal = getScan().getConsNoiDestLocCode();
                break;

            case 207: 
                retVal = getScan().getConsScanLocCode();
                break;

            case 208: 
                retVal = getScan().getFlightOriginLocCode();
                break;

            case 209: 
                retVal = getScan().getFlightDestLocCode();
                break;

            case 210: 
                retVal = new Integer(getScan().getHAWBSerialNumber());
                break;

            case 211: 
                retVal = getScan().getOriginLocationCode();
                break;

            case 212: 
                retVal = getScan().getTransCode();
                break;

            case 213: 
                retVal = getScan().getEntryNumber();
                break;

            case 214: 
                retVal = getScan().getEntryType();
                break;

            case 215: 
                retVal = getScan().getEntryValRestOverride();
                break;
            }
            break;

        case 3: // '\003'
            switch(methodID)
            {
            case 210: 
                retVal = new Boolean(getUploadStatus().getBSOFlag());
                break;

            case 211: 
                retVal = new Boolean(getUploadStatus().getBondTransferFlag());
                break;

            case 212: 
                retVal = new Boolean(getUploadStatus().getDocFlag());
                break;

            case 213: 
                retVal = new Boolean(getUploadStatus().getFedExShuttleFlag());
                break;

            case 214: 
                retVal = new Boolean(getUploadStatus().getODAShuttleFlag());
                break;

            case 215: 
                retVal = new Boolean(getUploadStatus().getMPSIncompleteFlag());
                break;

            case 216: 
                retVal = new Boolean(getUploadStatus().getDamagedFlag());
                break;

            case 217: 
                retVal = new Boolean(getUploadStatus().getCrushedFlag());
                break;

            case 218: 
                retVal = new Boolean(getUploadStatus().getWetFlag());
                break;

            case 219: 
                retVal = new Boolean(getUploadStatus().getTornFlag());
                break;

            case 220: 
                retVal = new Boolean(getUploadStatus().getRewrappedFlag());
                break;

            case 221: 
                retVal = new Boolean(getUploadStatus().getRetapedFlag());
                break;

            case 222: 
                retVal = new Boolean(getUploadStatus().getWrongFlightFlag());
                break;

            case 223: 
                retVal = new Boolean(getUploadStatus().getFlightDelayFlag());
                break;

            case 224: 
                retVal = new Boolean(getUploadStatus().getMissedShuttleFlag());
                break;

            case 225: 
                retVal = new Boolean(getUploadStatus().getAlwaysFlag());
                break;

            case 226: 
                retVal = new Boolean(getUploadStatus().getInterceptedFlag());
                break;

            case 227: 
                retVal = new Boolean(getUploadStatus().getClearedFlag());
                break;

            case 228: 
                retVal = new Boolean(getUploadStatus().getNonDocFlag());
                break;

            case 229: 
                retVal = new Boolean(getUploadStatus().getOverageFlag());
                break;

            case 230: 
                retVal = new Boolean(getUploadStatus().getNotClearedFlag());
                break;

            case 231: 
                retVal = new Boolean(getUploadStatus().getTravelStatusDomesticFlag());
                break;

            case 232: 
                retVal = new Boolean(getUploadStatus().getTravelStatusIntlFlag());
                break;

            case 233: 
                retVal = new Boolean(getUploadStatus().getConsUploadFlag());
                break;

            case 234: 
                retVal = new Boolean(getUploadStatus().getNoConsUploadFlag());
                break;
            }
            break;

        case 4: // '\004'
            int _tmp = methodID;
            break;

        case 5: // '\005'
            int _tmp1 = methodID;
            break;

        case 6: // '\006'
            int _tmp2 = methodID;
            break;

        case 7: // '\007'
            int _tmp3 = methodID;
            break;

        case 8: // '\b'
            int _tmp4 = methodID;
            break;

        case 9: // '\t'
            int _tmp5 = methodID;
            break;

        case 10: // '\n'
            int _tmp6 = methodID;
            break;

        case 11: // '\013'
            int _tmp7 = methodID;
            break;

        case 12: // '\f'
            int _tmp8 = methodID;
            break;

        case 13: // '\r'
            int _tmp9 = methodID;
            break;

        case 14: // '\016'
            switch(methodID)
            {
            case 300: 
                retVal = getCurrentScan().getScanTypeCode();
                break;

            case 301: 
                retVal = getCurrentScan().getCommentDescription();
                break;

            case 304: 
                retVal = getCurrentScan().getEmployeeNumber();
                break;

            case 305: 
                retVal = getCurrentScan().getLocationCd();
                break;

            case 306: 
                retVal = getCurrentScan().getLocStatNumber();
                break;

            case 307: 
                retVal = getCurrentScan().getStagingAreaCode();
                break;

            case 308: 
                retVal = getCurrentScan().getStagingAreaFlag();
                break;

            case 309: 
                retVal = getCurrentScan().getFromConsFlag();
                break;

            case 310: 
                retVal = getCurrentScan().getScanLocationDescription();
                break;

            case 311: 
                retVal = getCurrentScan().getWarehouseCd();
                break;

            case 312: 
                retVal = getCurrentScan().getInputMethodCode();
                break;
            }
            break;
        }
        return retVal;
    }

    public void setContainedClass(int classID, int methodID, String value)
    {
        switch(classID)
        {
        default:
            break;

        case 1: // '\001'
            switch(methodID)
            {
            case 10: // '\n'
                setOverageFlag(value);
                break;

            case 11: // '\013'
                setInterceptedFlag(value);
                break;

            case 13: // '\r'
                setMPSFlag(value);
                break;

            case 14: // '\016'
                setUploadFlag(value);
                break;

            case 15: // '\017'
                setScanTypeCode(value);
                break;

            case 16: // '\020'
                setAgencyCode(value);
                break;

            case 17: // '\021'
                setDiverterCode(value);
                break;

            case 18: // '\022'
                setAlwaysEmptyString(value);
                break;

            case 19: // '\023'
                setDuplicateResolution(Boolean.valueOf(value).booleanValue());
                break;

            case 20: // '\024'
                setRouteVerification(Boolean.valueOf(value).booleanValue());
                break;

            case 21: // '\025'
                setSortDateVerification(Boolean.valueOf(value).booleanValue());
                break;

            case 22: // '\026'
                setPositiveSort(Boolean.valueOf(value).booleanValue());
                break;

            case 24: // '\030'
                setStagingArea(value);
                break;

            case 25: // '\031'
                setMPSStagingFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 26: // '\032'
                setDuplicateFlag(value);
                break;

            case 27: // '\033'
                setPieceLevelIntercept(Boolean.valueOf(value).booleanValue());
                break;

            case 28: // '\034'
                setRecuringInterceptFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 29: // '\035'
                setMPSOverageFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 30: // '\036'
                setCAGEReasonCodeFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 31: // '\037'
                setCAGEReleaseCodeFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 32: // ' '
                setHandlingInstructionFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 33: // '!'
                setShipmentRemarkFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 34: // '"'
                setPieceLevelInventory(Boolean.valueOf(value).booleanValue());
                break;

            case 35: // '#'
                setRecuringInventoryFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 36: // '$'
                setTravelStatus(value);
                break;

            case 37: // '%'
                setUseExternalLookup(Boolean.valueOf(value).booleanValue());
                break;

            case 38: // '&'
                setIntransitFlag(value);
                break;

            case 39: // '\''
                setRouteWasClosed(Boolean.valueOf(value).booleanValue());
                break;

            case 40: // '('
                setIsManifested(Boolean.valueOf(value).booleanValue());
                break;

            case 41: // ')'
                setIsPieceManifested(Boolean.valueOf(value).booleanValue());
                break;

            case 42: // '*'
                setAbScanned(value);
                break;

            case 43: // '+'
                setAbFormTypeScanned(value);
                break;

            case 44: // ','
                setAbTypeScanned(value);
                break;

            case 45: // '-'
                setServiceCode(value);
                break;
            }
            break;

        case 2: // '\002'
            switch(methodID)
            {
            case 110: // 'n'
                getScan().setReturnStatus(Double.parseDouble(value));
                break;

            case 111: // 'o'
                getScan().setReturnMessage(value);
                break;

            case 112: // 'p'
                getScan().setInViewName(value);
                break;

            case 113: // 'q'
                getScan().setOutViewName(value);
                break;

            case 114: // 'r'
                getScan().setSysDateTime(Long.parseLong(value));
                break;

            case 116: // 't'
                getScan().setUserLogon(value);
                break;

            case 117: // 'u'
                getScan().setOrgCode(value);
                break;

            case 118: // 'v'
                getScan().setInputDevice(value);
                break;

            case 119: // 'w'
                getScan().setErrorNumber(Integer.parseInt(value));
                break;

            case 120: // 'x'
                getScan().setFromConsFlag(value);
                break;

            case 121: // 'y'
                getScan().setAirbillNumber(value);
                break;

            case 122: // 'z'
                getScan().setAirbillType(value);
                break;

            case 123: // '{'
                getScan().setAirbillFormType(value);
                break;

            case 124: // '|'
                getScan().setAirbillEntry(value);
                break;

            case 125: // '}'
                getScan().setAstraData(value);
                break;

            case 126: // '~'
                getScan().setHandlingUnitOid(Integer.parseInt(value));
                break;

            case 127: // '\177'
                getScan().setHAWB(value);
                break;

            case 128: 
                getScan().setHAWBFormType(value);
                break;

            case 129: 
                getScan().setShipmentOid(Integer.parseInt(value));
                break;

            case 130: 
                getScan().setHAWBUnknownFlag(value);
                break;

            case 131: 
                getScan().setReasonCode(value);
                break;

            case 132: 
                getScan().setReleaseCode(value);
                break;

            case 133: 
                getScan().setDetainLoc(value);
                break;

            case 134: 
                getScan().setInterceptCode(value);
                break;

            case 135: 
                getScan().setPrinterCode(value);
                break;

            case 136: 
                getScan().setRouteNumber(value);
                break;

            case 138: 
                getScan().setRouteLegOid(Integer.parseInt(value));
                break;

            case 139: 
                getScan().setStagingAreaCode(value);
                break;

            case 140: 
                getScan().setLocStatNbr(value);
                break;

            case 141: 
                getScan().setComments(value);
                break;

            case 142: 
                getScan().setAstray(value);
                break;

            case 143: 
                getScan().setMdeRoute(value);
                break;

            case 144: 
                getScan().setFlightNumber(value);
                break;

            case 145: 
                getScan().setFlightDate(value);
                break;

            case 146: 
                getScan().setPkgRouted(value);
                break;

            case 147: 
                getScan().setServiceCode(value);
                break;

            case 148: 
                getScan().setHandlingCodes(value);
                break;

            case 149: 
                getScan().setHalPostal(value);
                break;

            case 150: 
                getScan().setDestPostal(value);
                break;

            case 151: 
                getScan().setRoutingId(value);
                break;

            case 152: 
                getScan().setDelCommit(value);
                break;

            case 153: 
                getScan().setDestCountry(value);
                break;

            case 154: 
                getScan().setPkgCondition(value);
                break;

            case 155: 
                getScan().setConsId(value);
                break;

            case 156: 
                getScan().setConsFormType(value);
                break;

            case 157: 
                getScan().setConsType(value);
                break;

            case 158: 
                getScan().setContainerInd(value);
                break;

            case 159: 
                getScan().setContainerId(value);
                break;

            case 160: 
                getScan().setConsDestLoc(value);
                break;

            case 161: 
                getScan().setConsOid(Integer.parseInt(value));
                break;

            case 162: 
                getScan().setSplitName(value);
                break;

            case 163: 
                getScan().setActionCode(value);
                break;

            case 164: 
                getScan().setAgencyCode(value);
                break;

            case 165: 
                getScan().setLocationCode(value);
                break;

            case 166: 
                getScan().setWarehouseCode(value);
                break;

            case 167: 
                getScan().setBrokerClassificationCode(value);
                break;

            case 169: 
                getScan().setRouteStatusCode(value);
                break;

            case 170: 
                getScan().setPreviousBondInFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 171: 
                getScan().setDestLocationCode(value);
                break;

            case 172: 
                getScan().setAddressChangeFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 173: 
                getScan().setDeclarationCode(value);
                break;

            case 174: 
                getScan().setShuttleID(value);
                break;

            case 175: 
                getScan().setCustomsReleasedFlag(value);
                break;

            case 176: 
                getScan().setInputMethodCode(value);
                break;

            case 177: 
                getScan().setLabel1Length(Integer.parseInt(value));
                break;

            case 178: 
                getScan().setLabel1Data(value);
                break;

            case 179: 
                getScan().setLabel2Length(Integer.parseInt(value));
                break;

            case 180: 
                getScan().setLabel2Data(value);
                break;

            case 181: 
                getScan().setLabel3Length(Integer.parseInt(value));
                break;

            case 182: 
                getScan().setLabel3Data(value);
                break;

            case 183: 
                getScan().setHandlingInstructionCode(value);
                break;

            case 184: 
                getScan().setHandlingInstructionDesc(value);
                break;

            case 185: 
                getScan().setShipmentRemarkCode(value);
                break;

            case 186: 
                getScan().setShipmentRemarkDesc(value);
                break;

            case 187: 
                getScan().setReturnAWBNumber(value);
                break;

            case 188: 
                getScan().setTravelStatus(value);
                break;

            case 189: 
                getScan().setSplitFunction(value);
                break;

            case 190: 
                getScan().setSplitLocation(value);
                break;

            case 191: 
                getScan().setSplitNumber(value);
                break;

            case 192: 
                getScan().setSplitDestId(value);
                break;

            case 193: 
                getScan().setSplitArray(value);
                break;

            case 194: 
                getScan().setSplitServices(value);
                break;

            case 195: 
                getScan().setSplitHandling(value);
                break;

            case 196: 
                getScan().setSplitSpcHandling(value);
                break;

            case 197: 
                getScan().setSplitBoxDoc(value);
                break;

            case 198: 
                getScan().setSplitAltSplit(value);
                break;

            case 199: 
                getScan().setSplitType(value);
                break;

            case 200: 
                getScan().setSplitIntlDom(value);
                break;

            case 201: 
                getScan().setSplitZipCode(value);
                break;

            case 206: 
                getScan().setConsNoiDestLocCode(value);
                break;

            case 207: 
                getScan().setConsScanLocCode(value);
                break;

            case 208: 
                getScan().setFlightOriginLocCode(value);
                break;

            case 209: 
                getScan().setFlightDestLocCode(value);
                break;

            case 210: 
                getScan().setHAWBSerialNumber(Integer.parseInt(value));
                break;

            case 211: 
                getScan().setOriginLocationCode(value);
                break;

            case 212: 
                getScan().setTransCode(value);
                break;

            case 213: 
                getScan().setEntryNumber(value);
                break;

            case 214: 
                getScan().setEntryType(value);
                break;

            case 215: 
                getScan().setEntryValRestOverride(value);
                break;
            }
            break;

        case 3: // '\003'
            switch(methodID)
            {
            case 210: 
                getUploadStatus().setBSOFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 211: 
                getUploadStatus().setBondTransferFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 212: 
                getUploadStatus().setDocFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 213: 
                getUploadStatus().setFedExShuttleFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 214: 
                getUploadStatus().setODAShuttleFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 215: 
                getUploadStatus().setMPSIncompleteFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 216: 
                getUploadStatus().setDamagedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 217: 
                getUploadStatus().setCrushedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 218: 
                getUploadStatus().setWetFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 219: 
                getUploadStatus().setTornFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 220: 
                getUploadStatus().setRewrappedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 221: 
                getUploadStatus().setRetapedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 222: 
                getUploadStatus().setWrongFlightFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 223: 
                getUploadStatus().setFlightDelayFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 224: 
                getUploadStatus().setMissedShuttleFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 225: 
                getUploadStatus().setAlwaysFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 226: 
                getUploadStatus().setInterceptedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 227: 
                getUploadStatus().setClearedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 228: 
                getUploadStatus().setNonDocFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 229: 
                getUploadStatus().setOverageFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 230: 
                getUploadStatus().setNotClearedFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 231: 
                getUploadStatus().setTravelStatusDomesticFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 232: 
                getUploadStatus().setTravelStatusIntlFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 233: 
                getUploadStatus().setConsUploadFlag(Boolean.valueOf(value).booleanValue());
                break;

            case 234: 
                getUploadStatus().setNoConsUploadFlag(Boolean.valueOf(value).booleanValue());
                break;
            }
            break;

        case 4: // '\004'
            int _tmp = methodID;
            break;

        case 5: // '\005'
            int _tmp1 = methodID;
            break;

        case 6: // '\006'
            int _tmp2 = methodID;
            break;

        case 7: // '\007'
            int _tmp3 = methodID;
            break;

        case 8: // '\b'
            int _tmp4 = methodID;
            break;

        case 9: // '\t'
            int _tmp5 = methodID;
            break;

        case 10: // '\n'
            int _tmp6 = methodID;
            break;

        case 11: // '\013'
            int _tmp7 = methodID;
            break;

        case 12: // '\f'
            int _tmp8 = methodID;
            break;

        case 13: // '\r'
            int _tmp9 = methodID;
            break;

        case 14: // '\016'
            switch(methodID)
            {
            case 300: 
                getCurrentScan().setScanTypeCode(value);
                break;

            case 301: 
                getCurrentScan().setCommentDescription(value);
                break;

            case 304: 
                getCurrentScan().setEmployeeNumber(value);
                break;

            case 305: 
                getCurrentScan().setLocationCd(value);
                break;

            case 306: 
                getCurrentScan().setLocStatNumber(value);
                break;

            case 307: 
                getCurrentScan().setStagingAreaCode(value);
                break;

            case 308: 
                getCurrentScan().setStagingAreaFlag(value);
                break;

            case 309: 
                getCurrentScan().setFromConsFlag(value);
                break;

            case 310: 
                getCurrentScan().setScanLocationDescription(value);
                break;

            case 311: 
                getCurrentScan().setWarehouseCd(value);
                break;

            case 312: 
                getCurrentScan().setInputMethodCode(value);
                break;
            }
            break;
        }
    }

    public Object getTemplateTranslationKeyObject(String key)
    {
        if(key.equals("INTDESC"))
            return new objectMethodID(1, 11);
        if(key.equals("IntDesc"))
            return new objectMethodID(1, 11);
        if(key.equals("SCANCD"))
            return new objectMethodID(1, 15);
        if(key.equals("ScanCd"))
            return new objectMethodID(1, 15);
        if(key.equals("TIMESTAMP"))
            return new objectMethodID(2, 114);
        if(key.equals("TimeStamp"))
            return new objectMethodID(2, 114);
        if(key.equals("USERLOGON"))
            return new objectMethodID(2, 116);
        if(key.equals("UserLogon"))
            return new objectMethodID(2, 116);
        if(key.equals("TRKNBR"))
            return new objectMethodID(2, 121);
        if(key.equals("TrkNbr"))
            return new objectMethodID(2, 121);
        if(key.equals("HAWB"))
            return new objectMethodID(2, 127);
        if(key.equals("AWB"))
            return new objectMethodID(2, 127);
        if(key.equals("HAWBForm"))
            return new objectMethodID(2, 128);
        if(key.equals("AWBForm"))
            return new objectMethodID(2, 128);
        if(key.equals("REACD"))
            return new objectMethodID(2, 131);
        if(key.equals("ReaCd"))
            return new objectMethodID(2, 131);
        if(key.equals("RELCD"))
            return new objectMethodID(2, 132);
        if(key.equals("RelCd"))
            return new objectMethodID(2, 132);
        if(key.equals("DETAINLOC"))
            return new objectMethodID(2, 133);
        if(key.equals("DetainLoc"))
            return new objectMethodID(2, 133);
        if(key.equals("INTCD"))
            return new objectMethodID(2, 134);
        if(key.equals("IntCd"))
            return new objectMethodID(2, 134);
        if(key.equals("ROUTENUMBER"))
            return new objectMethodID(2, 136);
        if(key.equals("RouteNumber"))
            return new objectMethodID(2, 136);
        if(key.equals("ROUTEDATE"))
            return new objectMethodID(2, 137);
        if(key.equals("RouteDate"))
            return new objectMethodID(2, 137);
        if(key.equals("STAGEAREA"))
            return new objectMethodID(2, 139);
        if(key.equals("StageArea"))
            return new objectMethodID(2, 139);
        if(key.equals("LOCSTATNBR"))
            return new objectMethodID(2, 140);
        if(key.equals("LocStatNbr"))
            return new objectMethodID(2, 140);
        if(key.equals("COMMENT"))
            return new objectMethodID(2, 141);
        if(key.equals("Comment"))
            return new objectMethodID(2, 141);
        if(key.equals("FLIGHTNBR"))
            return new objectMethodID(2, 144);
        if(key.equals("FlightNbr"))
            return new objectMethodID(2, 144);
        if(key.equals("FLIGHTDT"))
            return new objectMethodID(2, 145);
        if(key.equals("FlightDt"))
            return new objectMethodID(2, 145);
        if(key.equals("CONSID"))
            return new objectMethodID(2, 155);
        if(key.equals("AGENCYCD"))
            return new objectMethodID(2, 164);
        if(key.equals("AgencyCd"))
            return new objectMethodID(2, 164);
        if(key.equals("SHUTTLEID"))
            return new objectMethodID(2, 174);
        if(key.equals("ShuttleId"))
            return new objectMethodID(2, 174);
        if(key.equals("HNDLGINSTCD"))
            return new objectMethodID(2, 183);
        if(key.equals("HndlgInstCd"))
            return new objectMethodID(2, 183);
        if(key.equals("SHPREMARKCD"))
            return new objectMethodID(2, 185);
        if(key.equals("ShpRemarkCd"))
            return new objectMethodID(2, 185);
        if(key.equals("RETURNAWB"))
            return new objectMethodID(2, 187);
        if(key.equals("ReturnAwb"))
            return new objectMethodID(2, 187);
        if(key.equals("SCANTYPE"))
            return new objectMethodID(14, 300);
        if(key.equals("SCANCOMMENT"))
            return new objectMethodID(14, 301);
        if(key.equals("SCANLOCSTAT"))
            return new objectMethodID(14, 306);
        if(key.equals("SCANSTAGINGAREA"))
            return new objectMethodID(14, 307);
        if(key.equals("SCANLOC"))
            return new objectMethodID(14, 310);
        else
            return null;
    }

    public String getTemplateTranslation(Object oKey)
    {
        if(oKey != null)
        {
            objectMethodID key = (objectMethodID)oKey;
            int objectID = key.getObjectID();
            int methodID = key.getMethodID();
            Object retVal = get(objectID, methodID);
            if(retVal != null)
                return retVal.toString();
        }
        return "";
    }

    public RPBScan getScan()
    {
        return m_Scan;
    }

    public void setScan(RPBScan setValue)
    {
        m_Scan = setValue;
    }

    public UploadStatus getUploadStatus()
    {
        return m_UploadStatus;
    }

    public void setUploadStatus(UploadStatus setValue)
    {
        m_UploadStatus = setValue;
    }

    public Vector getActivityCodes()
    {
        return m_ActivityCodes;
    }

    public void setActivityCodes(Vector setValue)
    {
        m_ActivityCodes = setValue;
    }

    public TreeMap getPrintData()
    {
        return m_PrintData;
    }

    public void setPrintData(TreeMap setValue)
    {
        m_PrintData = setValue;
    }

    public Vector getExceptionActivityCodes()
    {
        return m_ExceptionActivityCodes;
    }

    public void setExceptionActivityCodes(Vector setValue)
    {
        m_ExceptionActivityCodes = setValue;
    }

    public RouteLeg getRouteLegInfo()
    {
        return m_RouteLegInfo;
    }

    public void setRouteLegInfo(RouteLeg setValue)
    {
        m_RouteLegInfo = setValue;
    }

    public Vector getCAGEReasonCodes()
    {
        return m_CAGEReasonCodes;
    }

    public void setCAGEReasonCodes(Vector setValue)
    {
        m_CAGEReasonCodes = setValue;
    }

    public Vector getCAGEReleaseCodes()
    {
        return m_CAGEReleaseCodes;
    }

    public void setCAGEReleaseCodes(Vector setValue)
    {
        m_CAGEReleaseCodes = setValue;
    }

    public Vector getHandlingInstructions()
    {
        return m_HandlingInstructions;
    }

    public void setHandlingInstructions(Vector setValue)
    {
        m_HandlingInstructions = setValue;
    }

    public Vector getShipmentRemarks()
    {
        return m_ShipmentRemarks;
    }

    public void setShipmentRemarks(Vector setValue)
    {
        m_ShipmentRemarks = setValue;
    }

    public Vector getUploadKey()
    {
        return m_UploadKey;
    }

    public void setUploadKey(Vector setValue)
    {
        m_UploadKey = setValue;
    }

    public Vector getScanVectorElement()
    {
        return m_ScanVectorElement;
    }

    public void setScanVectorElement(Vector setValue)
    {
        m_ScanVectorElement = setValue;
    }

    public Scan getCurrentScan()
    {
        return m_CurrentScan;
    }

    public void setCurrentScan(Scan setValue)
    {
        m_CurrentScan = setValue;
    }

    public String getOverageFlag()
    {
        return m_OverageFlag;
    }

    public void setOverageFlag(String setValue)
    {
        if(setValue == null)
        {
            m_OverageFlag = "";
            return;
        } else
        {
            m_OverageFlag = setValue;
            return;
        }
    }

    public String getInterceptedFlag()
    {
        return m_InterceptedFlag;
    }

    public void setInterceptedFlag(String setValue)
    {
        if(setValue == null)
        {
            m_InterceptedFlag = "";
            return;
        } else
        {
            m_InterceptedFlag = setValue;
            return;
        }
    }

    public String getMPSFlag()
    {
        return m_MPSFlag;
    }

    public void setMPSFlag(String setValue)
    {
        if(setValue == null)
        {
            m_MPSFlag = "";
            return;
        } else
        {
            m_MPSFlag = setValue;
            return;
        }
    }

    public String getUploadFlag()
    {
        return m_UploadFlag;
    }

    public void setUploadFlag(String setValue)
    {
        if(setValue == null)
        {
            m_UploadFlag = "";
            return;
        } else
        {
            m_UploadFlag = setValue;
            return;
        }
    }

    public String getScanTypeCode()
    {
        return m_ScanTypeCode;
    }

    public void setScanTypeCode(String setValue)
    {
        if(setValue == null)
        {
            m_ScanTypeCode = "";
            return;
        } else
        {
            m_ScanTypeCode = setValue;
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

    public String getDiverterCode()
    {
        return m_DiverterCode;
    }

    public void setDiverterCode(String setValue)
    {
        if(setValue == null)
        {
            m_DiverterCode = "";
            return;
        } else
        {
            m_DiverterCode = setValue;
            return;
        }
    }

    public String getAlwaysEmptyString()
    {
        return m_AlwaysEmptyString;
    }

    public void setAlwaysEmptyString(String setValue)
    {
        if(setValue == null)
        {
            m_AlwaysEmptyString = "";
            return;
        } else
        {
            m_AlwaysEmptyString = setValue;
            return;
        }
    }

    public boolean getDuplicateResolution()
    {
        return m_DuplicateResolution;
    }

    public void setDuplicateResolution(boolean setValue)
    {
        m_DuplicateResolution = setValue;
    }

    public boolean getRouteVerification()
    {
        return m_RouteVerification;
    }

    public void setRouteVerification(boolean setValue)
    {
        m_RouteVerification = setValue;
    }

    public boolean getSortDateVerification()
    {
        return m_SortDateVerification;
    }

    public void setSortDateVerification(boolean setValue)
    {
        m_SortDateVerification = setValue;
    }

    public boolean getPositiveSort()
    {
        return m_PositiveSort;
    }

    public void setPositiveSort(boolean setValue)
    {
        m_PositiveSort = setValue;
    }

    public Date getCurrentSortDate()
    {
        return m_CurrentSortDate;
    }

    public void setCurrentSortDate(Date setValue)
    {
        m_CurrentSortDate = setValue;
    }

    public String getStagingArea()
    {
        return m_StagingArea;
    }

    public void setStagingArea(String setValue)
    {
        if(setValue == null)
        {
            m_StagingArea = "";
            return;
        } else
        {
            m_StagingArea = setValue;
            return;
        }
    }

    public boolean getMPSStagingFlag()
    {
        return m_MPSStagingFlag;
    }

    public void setMPSStagingFlag(boolean setValue)
    {
        m_MPSStagingFlag = setValue;
    }

    public String getDuplicateFlag()
    {
        return m_DuplicateFlag;
    }

    public void setDuplicateFlag(String setValue)
    {
        if(setValue == null)
        {
            m_DuplicateFlag = "";
            return;
        } else
        {
            m_DuplicateFlag = setValue;
            return;
        }
    }

    public boolean getPieceLevelIntercept()
    {
        return m_PieceLevelIntercept;
    }

    public void setPieceLevelIntercept(boolean setValue)
    {
        m_PieceLevelIntercept = setValue;
    }

    public boolean getRecuringInterceptFlag()
    {
        return m_RecuringInterceptFlag;
    }

    public void setRecuringInterceptFlag(boolean setValue)
    {
        m_RecuringInterceptFlag = setValue;
    }

    public boolean getMPSOverageFlag()
    {
        return m_MPSOverageFlag;
    }

    public void setMPSOverageFlag(boolean setValue)
    {
        m_MPSOverageFlag = setValue;
    }

    public boolean getCAGEReasonCodeFlag()
    {
        return m_CAGEReasonCodeFlag;
    }

    public void setCAGEReasonCodeFlag(boolean setValue)
    {
        m_CAGEReasonCodeFlag = setValue;
    }

    public boolean getCAGEReleaseCodeFlag()
    {
        return m_CAGEReleaseCodeFlag;
    }

    public void setCAGEReleaseCodeFlag(boolean setValue)
    {
        m_CAGEReleaseCodeFlag = setValue;
    }

    public boolean getHandlingInstructionFlag()
    {
        return m_HandlingInstructionFlag;
    }

    public void setHandlingInstructionFlag(boolean setValue)
    {
        m_HandlingInstructionFlag = setValue;
    }

    public boolean getShipmentRemarkFlag()
    {
        return m_ShipmentRemarkFlag;
    }

    public void setShipmentRemarkFlag(boolean setValue)
    {
        m_ShipmentRemarkFlag = setValue;
    }

    public boolean getPieceLevelInventory()
    {
        return m_PieceLevelInventory;
    }

    public void setPieceLevelInventory(boolean setValue)
    {
        m_PieceLevelInventory = setValue;
    }

    public boolean getRecuringInventoryFlag()
    {
        return m_RecuringInventoryFlag;
    }

    public void setRecuringInventoryFlag(boolean setValue)
    {
        m_RecuringInventoryFlag = setValue;
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

    public boolean getUseExternalLookup()
    {
        return m_UseExternalLookup;
    }

    public void setUseExternalLookup(boolean setValue)
    {
        m_UseExternalLookup = setValue;
    }

    public String getIntransitFlag()
    {
        return m_IntransitFlag;
    }

    public void setIntransitFlag(String setValue)
    {
        if(setValue == null)
        {
            m_IntransitFlag = "";
            return;
        } else
        {
            m_IntransitFlag = setValue;
            return;
        }
    }

    public boolean getRouteWasClosed()
    {
        return m_RouteWasClosed;
    }

    public void setRouteWasClosed(boolean setValue)
    {
        m_RouteWasClosed = setValue;
    }

    public boolean getIsManifested()
    {
        return m_IsManifested;
    }

    public void setIsManifested(boolean setValue)
    {
        m_IsManifested = setValue;
    }

    public boolean getIsPieceManifested()
    {
        return m_IsPieceManifested;
    }

    public void setIsPieceManifested(boolean setValue)
    {
        m_IsPieceManifested = setValue;
    }

    public String getAbScanned()
    {
        return m_AbScanned;
    }

    public void setAbScanned(String setValue)
    {
        if(setValue == null)
        {
            m_AbScanned = "";
            return;
        } else
        {
            m_AbScanned = setValue;
            return;
        }
    }

    public String getAbFormTypeScanned()
    {
        return m_AbFormTypeScanned;
    }

    public void setAbFormTypeScanned(String setValue)
    {
        if(setValue == null)
        {
            m_AbFormTypeScanned = "";
            return;
        } else
        {
            m_AbFormTypeScanned = setValue;
            return;
        }
    }

    public String getAbTypeScanned()
    {
        return m_AbTypeScanned;
    }

    public void setAbTypeScanned(String setValue)
    {
        if(setValue == null)
        {
            m_AbTypeScanned = "";
            return;
        } else
        {
            m_AbTypeScanned = setValue;
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

    public String toString()
    {
        String s = "State Object:  " + getClass().getName() + "\n\n";
        s = s + "OverageFlag\t\t = " + m_OverageFlag + "\n";
        s = s + "InterceptedFlag\t\t = " + m_InterceptedFlag + "\n";
        s = s + "MPSFlag\t\t = " + m_MPSFlag + "\n";
        s = s + "UploadFlag\t\t = " + m_UploadFlag + "\n";
        s = s + "ScanTypeCode\t\t = " + m_ScanTypeCode + "\n";
        s = s + "AgencyCode\t\t = " + m_AgencyCode + "\n";
        s = s + "DiverterCode\t\t = " + m_DiverterCode + "\n";
        s = s + "AlwaysEmptyString\t\t = " + m_AlwaysEmptyString + "\n";
        s = s + "DuplicateResolution\t\t = " + m_DuplicateResolution + "\n";
        s = s + "RouteVerification\t\t = " + m_RouteVerification + "\n";
        s = s + "SortDateVerification\t\t = " + m_SortDateVerification + "\n";
        s = s + "PositiveSort\t\t = " + m_PositiveSort + "\n";
        s = s + "CurrentSortDate\t\t = " + m_CurrentSortDate + "\n";
        s = s + "StagingArea\t\t = " + m_StagingArea + "\n";
        s = s + "MPSStagingFlag\t\t = " + m_MPSStagingFlag + "\n";
        s = s + "DuplicateFlag\t\t = " + m_DuplicateFlag + "\n";
        s = s + "PieceLevelIntercept\t\t = " + m_PieceLevelIntercept + "\n";
        s = s + "RecuringInterceptFlag\t\t = " + m_RecuringInterceptFlag + "\n";
        s = s + "MPSOverageFlag\t\t = " + m_MPSOverageFlag + "\n";
        s = s + "CAGEReasonCodeFlag\t\t = " + m_CAGEReasonCodeFlag + "\n";
        s = s + "CAGEReleaseCodeFlag\t\t = " + m_CAGEReleaseCodeFlag + "\n";
        s = s + "HandlingInstructionFlag\t\t = " + m_HandlingInstructionFlag + "\n";
        s = s + "ShipmentRemarkFlag\t\t = " + m_ShipmentRemarkFlag + "\n";
        s = s + "PieceLevelInventory\t\t = " + m_PieceLevelInventory + "\n";
        s = s + "RecuringInventoryFlag\t\t = " + m_RecuringInventoryFlag + "\n";
        s = s + "TravelStatus\t\t = " + m_TravelStatus + "\n";
        s = s + "UseExternalLookup\t\t = " + m_UseExternalLookup + "\n";
        s = s + "IntransitFlag\t\t = " + m_IntransitFlag + "\n";
        s = s + "RouteWasClosed\t\t = " + m_RouteWasClosed + "\n";
        s = s + "IsManifested\t\t = " + m_IsManifested + "\n";
        s = s + "IsPieceManifested\t\t = " + m_IsPieceManifested + "\n";
        s = s + "AbScanned\t\t = " + m_AbScanned + "\n";
        s = s + "AbFormTypeScanned\t\t = " + m_AbFormTypeScanned + "\n";
        s = s + "AbTypeScanned\t\t = " + m_AbTypeScanned + "\n";
        s = s + "ServiceCode\t\t = " + m_ServiceCode + "\n";
        s = s + "m_Scan\t\t = " + m_Scan + "\n";
        s = s + "m_UploadStatus\t\t = " + m_UploadStatus + "\n";
        s = s + "m_ActivityCodes\t\t = " + m_ActivityCodes + "\n";
        s = s + "m_PrintData\t\t = " + m_PrintData + "\n";
        s = s + "m_ExceptionActivityCodes\t\t = " + m_ExceptionActivityCodes + "\n";
        s = s + "m_RouteLegInfo\t\t = " + m_RouteLegInfo + "\n";
        s = s + "m_CAGEReasonCodes\t\t = " + m_CAGEReasonCodes + "\n";
        s = s + "m_CAGEReleaseCodes\t\t = " + m_CAGEReleaseCodes + "\n";
        s = s + "m_HandlingInstructions\t\t = " + m_HandlingInstructions + "\n";
        s = s + "m_ShipmentRemarks\t\t = " + m_ShipmentRemarks + "\n";
        s = s + "m_UploadKey\t\t = " + m_UploadKey + "\n";
        s = s + "m_ScanVectorElement\t\t = " + m_ScanVectorElement + "\n";
        s = s + "m_CurrentScan\t\t = " + m_CurrentScan + "\n";
        return s;
    }

    public Object clone()
    {
        CCIIStateBase copy = null;
        try
        {
            copy = (CCIIStateBase)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError(e.toString());
        }
        if(getScan() == null)
            copy.setScan(null);
        else
            copy.setScan((RPBScan)getScan().clone());
        if(getUploadStatus() == null)
            copy.setUploadStatus(null);
        else
            copy.setUploadStatus((UploadStatus)getUploadStatus().clone());
        if(getActivityCodes() == null)
            copy.setActivityCodes(null);
        else
            copy.setActivityCodes((Vector)getActivityCodes().clone());
        if(getPrintData() == null)
            copy.setPrintData(null);
        else
            copy.setPrintData((TreeMap)getPrintData().clone());
        if(getExceptionActivityCodes() == null)
            copy.setExceptionActivityCodes(null);
        else
            copy.setExceptionActivityCodes((Vector)getExceptionActivityCodes().clone());
        if(getRouteLegInfo() == null)
            copy.setRouteLegInfo(null);
        else
            copy.setRouteLegInfo((RouteLeg)getRouteLegInfo().clone());
        if(getCAGEReasonCodes() == null)
            copy.setCAGEReasonCodes(null);
        else
            copy.setCAGEReasonCodes((Vector)getCAGEReasonCodes().clone());
        if(getCAGEReleaseCodes() == null)
            copy.setCAGEReleaseCodes(null);
        else
            copy.setCAGEReleaseCodes((Vector)getCAGEReleaseCodes().clone());
        if(getHandlingInstructions() == null)
            copy.setHandlingInstructions(null);
        else
            copy.setHandlingInstructions((Vector)getHandlingInstructions().clone());
        if(getShipmentRemarks() == null)
            copy.setShipmentRemarks(null);
        else
            copy.setShipmentRemarks((Vector)getShipmentRemarks().clone());
        if(getUploadKey() == null)
            copy.setUploadKey(null);
        else
            copy.setUploadKey((Vector)getUploadKey().clone());
        if(getScanVectorElement() == null)
            copy.setScanVectorElement(null);
        else
            copy.setScanVectorElement((Vector)getScanVectorElement().clone());
        if(getCurrentScan() == null)
            copy.setCurrentScan(null);
        else
            copy.setCurrentScan((Scan)getCurrentScan().clone());
        if(getCurrentSortDate() == null)
            copy.setCurrentSortDate(null);
        else
            copy.setCurrentSortDate((Date)getCurrentSortDate().clone());
        return copy;
    }

    protected RPBScan m_Scan;
    protected UploadStatus m_UploadStatus;
    protected Vector m_ActivityCodes;
    protected TreeMap m_PrintData;
    protected Vector m_ExceptionActivityCodes;
    protected RouteLeg m_RouteLegInfo;
    protected Vector m_CAGEReasonCodes;
    protected Vector m_CAGEReleaseCodes;
    protected Vector m_HandlingInstructions;
    protected Vector m_ShipmentRemarks;
    protected Vector m_UploadKey;
    protected Vector m_ScanVectorElement;
    protected Scan m_CurrentScan;
    protected String m_OverageFlag;
    protected String m_InterceptedFlag;
    protected String m_MPSFlag;
    protected String m_UploadFlag;
    protected String m_ScanTypeCode;
    protected String m_AgencyCode;
    protected String m_DiverterCode;
    protected String m_AlwaysEmptyString;
    protected boolean m_DuplicateResolution;
    protected boolean m_RouteVerification;
    protected boolean m_SortDateVerification;
    protected boolean m_PositiveSort;
    protected Date m_CurrentSortDate;
    protected String m_StagingArea;
    protected boolean m_MPSStagingFlag;
    protected String m_DuplicateFlag;
    protected boolean m_PieceLevelIntercept;
    protected boolean m_RecuringInterceptFlag;
    protected boolean m_MPSOverageFlag;
    protected boolean m_CAGEReasonCodeFlag;
    protected boolean m_CAGEReleaseCodeFlag;
    protected boolean m_HandlingInstructionFlag;
    protected boolean m_ShipmentRemarkFlag;
    protected boolean m_PieceLevelInventory;
    protected boolean m_RecuringInventoryFlag;
    protected String m_TravelStatus;
    protected boolean m_UseExternalLookup;
    protected String m_IntransitFlag;
    protected boolean m_RouteWasClosed;
    protected boolean m_IsManifested;
    protected boolean m_IsPieceManifested;
    protected String m_AbScanned;
    protected String m_AbFormTypeScanned;
    protected String m_AbTypeScanned;
    protected String m_ServiceCode;
}
