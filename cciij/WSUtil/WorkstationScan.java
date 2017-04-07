package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 * Modification History:
 * 02/03/2004   Tom Knobeloch    Added code for invoking Inventory scans.
 * 12/22/2004   Mike Roderick    Added logic to get the uvsdk from the factory, and deal with the exceptions
 */
import cciij.cciidata.RPBScan;
import cciij.businessActions.Messages;
import java.util.Vector;
import cciij.cciidata.RouteLeg;
import java.util.Iterator;
import java.util.Date;
import cciij.util.CCIILogException;
import cciij.WSUtil.WSNotify;
import cciij.util.Java2uvsdkInterface;
import cciij.util.Java2uvsdkFactory;
import cciij.util.Java2uvsdkException;
import cciij.cciidata.UploadStatus;
import cciij.util.ModCheck;
import cciij.WSUtil.WorkstationScanClient;

public class WorkstationScan implements java.io.Serializable, Cloneable
{
    private static final String m_whatVersion = "@(#) $RCSfile: WorkstationScan.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
    protected WSNotify m_notify = new WSNotify();
    protected String m_actionName = "WorkstationScan";
    protected Java2uvsdkInterface uvsdk = null;
    protected RPBScan m_RPBScan = new RPBScan();

    //items in comments are mapping between old variable names and RPBscan properties
    protected int m_existingErrorCode = Messages.EM_NO_ERROR;
    //User.getUusername = setUserLogon(user.getUserName());
    //User.getOrgcode = scan.setOrgCode
    //User.getLanguage new language
    protected int m_language = 1;
    //trackingNumber scan.setAwbnumber
    protected String m_trackingNumberType = CCIIProperties.TRACKING_NUMBER_TYPE_AWB;
    protected boolean m_overrideCheckDigit = false;
    //shipOid = scan.setShipmentOid;
    //huOid = scan.setPieceOid;
    protected String m_formCode = "";
    //hawb = scan.setHAWB
    //isHAWBUnknown scan.setHAWBUnknownFlag("T");
    //reasonCode scan.setReasonCode()
    //releaseCode scan.setReleaseCode()
    //actionCode scan.setActionCode()
    //agency scan.setAgencyCode()
    //interceptCode scan.setInterceptCode()
    //printerId scan.setPrinterCode(printerId);
    protected Vector m_routeVector = new Vector();
    //stagingAreaCode scan.setStagingAreaCode(
    protected boolean m_usePieceLevelIntercept = false; //not used currently
    protected String m_genericCode = "";
    protected String m_genericDesc = "";
    protected boolean m_evaluateGenericCode = false;
    protected Vector m_singleLineVec = new Vector();
    protected int m_useSingleLine = CCIIProperties.EJB_SINGLELINE_USE_NOTHING;
    //site scan.setLocationCode()
    protected RouteLeg m_routeLeg = new RouteLeg(); //not currently used
    // warehouseCd scan.setWarehouseCode()
    protected Vector m_checkboxVector = new Vector();
    protected int m_ejbCodeType = CCIIProperties.EJB_CODE_USES_NONE;
    protected UploadStatus m_uploadStatus = null;
    protected int m_ejbType = CCIIProperties.EJB_TYPE_NO_PROCESS;


    public WorkstationScan()
    {
        m_notify.setActionName(m_actionName);
        try
        {
            uvsdk = Java2uvsdkFactory.getJava2uvsdk();
            uvsdk.LoadUrsaEditFiles();
        }
        catch(Java2uvsdkException e)
        {
            System.out.println("Failed to get the uvsdk from the factory...:  " + e);
            throw new RuntimeException("Error getting a uvsdk from the factory:  " + e,e);
        }
    }

    public void setHAWBUnknownFlag(boolean hawbUnknownFlag)
    {
        String hawbFlag = "";
        if (hawbUnknownFlag)
            hawbFlag = "T";
        m_RPBScan.setHAWBUnknownFlag(hawbFlag);
    }
    public boolean getHAWBUnknownBooleanFlag()
    {
        boolean flag = false;
        if (m_RPBScan.getHAWBUnknownFlag() != null && m_RPBScan.getHAWBUnknownFlag().equals("T"))
            flag = true;
        return flag;
    }
    public int getExistingErrorCode()
    {
        return m_existingErrorCode;
    }
    public void setExistingErrorCode(int existingErrorCode)
    {
        m_existingErrorCode = existingErrorCode;
    }
    public int getLanguage()
    {
        return m_language;
    }
    public void setLanguage(int language)
    {
        m_language = language;
    }
    public String getTrackingNumberType()
    {
        return m_trackingNumberType;
    }
    public void setTrackingNumberType(String trackingNumberType)
    {
        if (trackingNumberType == null)
            trackingNumberType = "";
        m_trackingNumberType = trackingNumberType;
    }
    public boolean getOverrideCheckDigit()
    {
        return m_overrideCheckDigit;
    }
    public void setOverrideCheckDigit(boolean overrideCheckDigit)
    {
        m_overrideCheckDigit = overrideCheckDigit;
    }
    public String getFormCode()
    {
        return m_formCode;
    }
    public void setFormCode(String formCode)
    {
        if (formCode == null)
            formCode = "";
        m_formCode = formCode;
    }
    public Vector getRouteVector()
    {
        return m_routeVector;
    }
    public void setRouteVector(Vector routeVector)
    {
        if (routeVector == null)
            routeVector = new Vector();
        m_routeVector = routeVector;
    }
    public void addRouteToRouteVector(String routeName)
    {
        if (m_routeVector == null)
            m_routeVector = new Vector();
        m_routeVector.add(routeName);
    }
    public boolean getUsePieceLevelIntercept()
    {
        return m_usePieceLevelIntercept;
    }
    public void setUsePieceLevelIntercept(boolean usePieceLevelIntercept)
    {
        m_usePieceLevelIntercept = usePieceLevelIntercept;
    }
    public String getGenericCode()
    {
        return m_genericCode;
    }
    public void setGenericCode(String genericCode)
    {
        if (genericCode == null)
            genericCode = "";
        m_genericCode = genericCode;
    }
    public String getGenericDesc()
    {
        return m_genericDesc;
    }
    public void setGenericDesc(String genericDesc)
    {
        if (genericDesc == null)
            genericDesc = "";
        m_genericDesc = genericDesc;
    }
    public boolean getEvaluateGenericCode()
    {
        return m_evaluateGenericCode;
    }
    public void setEvaluateGenericCode(boolean evaluateGenericCode)
    {
        m_evaluateGenericCode = evaluateGenericCode;
    }
    public Vector getSingleLineVec()
    {
        return m_singleLineVec;
    }
    public void setSingleLineVec(Vector singleLineVec)
    {
        if (singleLineVec == null)
            singleLineVec = new Vector();
        m_singleLineVec = singleLineVec;
    }
    public void addSingleLineToSingleLineVec(String singleLine)
    {
        if (m_singleLineVec == null)
            m_singleLineVec = new Vector();
        m_singleLineVec.add(singleLine);
    }
    public int getUseSingleLine()
    {
        return m_useSingleLine;
    }
    public void setUseSingleLine(int useSingleLine)
    {
        m_useSingleLine = useSingleLine;
    }
    public RouteLeg getRouteLeg()
    {
        return m_routeLeg;
    }
    public void setRouteLeg(RouteLeg routeLeg)
    {
        if (routeLeg == null)
            routeLeg = new RouteLeg();
        m_routeLeg = routeLeg;
    }
    public Vector getCheckboxVector()
    {
        return m_checkboxVector;
    }
    public void setCheckboxVector(Vector checkboxVector)
    {
        if (checkboxVector == null)
            checkboxVector = new Vector();
        m_checkboxVector = checkboxVector;
    }

    public void addCheckboxToCheckboxVector(String checkbox)
    {
        if (m_checkboxVector == null)
            m_checkboxVector = new Vector();
        m_checkboxVector.add(checkbox);
    }

    public RPBScan getRPBScan()
    {
        //RPBScan scan = null;
        //scan = (RPBScan)super.clone();
        return m_RPBScan;
    }

    public void setRPBScan(RPBScan rpbScan)
    {
        if (rpbScan == null)
            rpbScan = new RPBScan();
        m_RPBScan = rpbScan;
    }

    public int getEjbCodeType()
    {
        return m_ejbCodeType;
    }
    public void setEjbCodeType(int codeType)
    {
        m_ejbCodeType = codeType;
    }
    public UploadStatus getUploadStatus()
    {
        return m_uploadStatus;
    }

    public void setUploadStatus(UploadStatus uploadStatus)
    {
        m_uploadStatus = uploadStatus;
    }

    public int getEJBType()
    {
        return m_ejbType;
    }
    public void setEJBType(int ejbType)
    {
        m_ejbType = ejbType;
    }

    public void setUserInfo (UserAttributes user)
    {
        m_RPBScan.setUserLogon(user.getUserName());
        m_RPBScan.setOrgCode(user.getOrgCode());
        setLanguage(user.getLanguage());
    }

    public void evaluateGenericCode(boolean evaluateCode, String genericCode)
    {
        setEvaluateGenericCode(evaluateCode);
        setGenericCode(genericCode);
        evaluateGenericCode();
    }

    public void evaluateGenericCode()
    {
        if (m_evaluateGenericCode )//&& (m_genericCode != null || !m_genericCode.equals("")))
        {
            switch (m_ejbCodeType)
            {
            case CCIIProperties.EJB_CODE_USES_NONE:
                //code isn't used for anything
                break;
            case CCIIProperties.EJB_CODE_USES_REASON_CODE:
                m_RPBScan.setReasonCode(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_RELEASE_CODE:
                m_RPBScan.setReleaseCode(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_DETAIN_LOC:
                m_RPBScan.setDetainLoc(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_INTERCEPT_CODE:
                m_RPBScan.setInterceptCode(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_PRINTER_ID:
                m_RPBScan.setPrinterCode(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_ROUTE_NBR:
                Vector tempVect = new Vector();
                tempVect.add(m_genericCode);
                setRouteVector(tempVect);
                break;
            case CCIIProperties.EJB_CODE_USES_STAGING_AREA_CODE:
                m_RPBScan.setStagingAreaCode(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_REMARK_CODE:
                m_RPBScan.setShipmentRemarkCode(m_genericCode);
                m_RPBScan.setShipmentRemarkDesc(m_genericDesc);
                break;
            case CCIIProperties.EJB_CODE_USES_HANDLING_INSTRUCTION_CODE:
                m_RPBScan.setHandlingInstructionCode(m_genericCode);
                m_RPBScan.setHandlingInstructionDesc(m_genericDesc);
                break;
            case CCIIProperties.EJB_CODE_USES_LOCSTAT_NUM:
                m_RPBScan.setLocStatNbr(m_genericCode);
                break;
            case CCIIProperties.EJB_CODE_USES_STAT37_DAMAGE:
                m_RPBScan.setLocStatNbr("37");
                //not sure if this is the right field for damage code
                m_RPBScan.setComments(m_genericCode);
                break;
            default:
                String str = "Unable to assign code string during processing";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_UNKNOWN_EJBCODE,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_UNKNOWN_EJBCODE,str,ex,this);
                break;
            }
        }
    }

    public void evaluateSingleLine(int useSingleLine, Vector singleLineVector)
    {
        setUseSingleLine(useSingleLine);
        setSingleLineVec(singleLineVector);
        evaluateSingleLine();
    }

    public void evaluateSingleLine()
    {
        if (m_useSingleLine != CCIIProperties.EJB_SINGLELINE_USE_NOTHING)
        {
            String singleLine;
            if (m_singleLineVec != null && !m_singleLineVec.isEmpty())
            {
                Iterator itSingleLine = m_singleLineVec.iterator();
                try
                {
                    singleLine = (String)itSingleLine.next();
                }
                catch (Exception e)
                {
                    singleLine = "";
                }
                switch (m_useSingleLine)
                {
                case CCIIProperties.EJB_SINGLELINE_USE_NOTHING:
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_DETAINMENT_LOC:
                    m_RPBScan.setDetainLoc(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_COMMENTS:
                    m_RPBScan.setComments(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_HAWB:
                    m_RPBScan.setHAWB(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_CONSNUM:
                    m_RPBScan.setConsId(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_MDE_ROUTE_AND_COMMENTS:
                    if (m_RPBScan.getLocStatNbr().equals("68"))
                    { //not sure if this is the correct place to fill in routing
                        m_RPBScan.setMdeRoute(singleLine);
                    }
                    else if (m_RPBScan.getLocStatNbr().equals("77"))
                    {
                        m_RPBScan.setMdeRoute(singleLine);
                    }
                    else
                    {
                        System.out.println("Unknown routing type");
                    }
                    try
                    {
                        singleLine = (String)itSingleLine.next();
                    } catch (Exception e)
                    {
                        singleLine = "";
                    }
                    m_RPBScan.setComments(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_ASTRAY_AND_COMMENTS:
                    m_RPBScan.setAstray(singleLine);
                    try
                    {
                        singleLine = (String)itSingleLine.next();
                    } catch (Exception e)
                    {
                        singleLine = "";
                    }
                    m_RPBScan.setComments(singleLine);
                    break;
                case CCIIProperties.EJB_SINGLELINE_USE_FLTNUM_FLTDATE_AND_COMMENTS:
                    m_RPBScan.setFlightNumber(singleLine);
                    try
                    {
                        singleLine = (String)itSingleLine.next();
                    } catch (Exception e)
                    {
                        singleLine = "";
                    }
                    m_RPBScan.setFlightDate(singleLine);
                    try
                    {
                        singleLine = (String)itSingleLine.next();
                    } catch (Exception e)
                    {
                        singleLine = "";
                    }
                    m_RPBScan.setComments(singleLine);
                    break;
                default:
                    String str = "Unable to determine single line usage during processing";
                    CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_UNKNOWN_EJBCODE,str);
                    m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_UNKNOWN_EJBCODE,str,ex,this);
                    break;
                } //end switch
            } //end if single line is null or empty
        } //end if single line is not do nothing
    }

    public void evaluateRouteVector(Vector routeVector)
    {
        setRouteVector(routeVector);
        evaluateRouteVector();
    }

    public void evaluateRouteVector()
    {
        String routeNum = "";
        //conversion of routeVector to a single string
        if (m_routeVector != null && !m_routeVector.isEmpty())
        {
            if (m_routeVector.size() > 1)
            {
                String str = "Only using the first route number";
                CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE,str);
                m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE, str,ex,this);
            }
            routeNum = (String)m_routeVector.firstElement();
        }
        m_RPBScan.setRouteNumber(routeNum);
    }

    public void evaluateCheckboxVector(Vector checkboxVector)
    {
        setCheckboxVector(checkboxVector);
        evaluateCheckboxVector();
    }
    public void evaluateCheckboxVector()
    {
        if (m_checkboxVector != null && !m_checkboxVector.isEmpty())
        {
            if (m_uploadStatus == null)
            {
                m_uploadStatus = new UploadStatus();
            }
            for (Iterator itCheckBox = m_checkboxVector.iterator();itCheckBox.hasNext();)
            {
                String exceptionString = (String)itCheckBox.next();
                if (exceptionString.equals(CCIIProperties.BONDIN_DAMAGED))
                {
                    m_uploadStatus.setDamagedFlag(true);
                    continue;
                } else if (exceptionString.equals(CCIIProperties.BONDIN_FLIGHT_DELAYED))
                {
                    m_uploadStatus.setFlightDelayFlag(true);
                    continue;
                } else if (exceptionString.equals(CCIIProperties.BONDIN_WRONG_FLIGHT))
                {
                    m_uploadStatus.setWrongFlightFlag(true);
                    continue;
                } else if (exceptionString.equals(CCIIProperties.BONDOUT_MISSED_SHUTTLE))
                {
                    m_uploadStatus.setMissedShuttleFlag(true);
                    continue;
                }
            }
        }
    }

    public void evaluateFormCode(String formCode)
    {
        setFormCode(formCode);
        evaluateFormCode();
    }
    public void evaluateFormCode()
    {
        // Interface with the UVSDK if possible
        String formType = "";
        if ((m_formCode != null && m_formCode.length() > 1) ||
            ((m_RPBScan.getAirbillNumber().length() < 12) && (m_RPBScan.getAirbillNumber().length() > 7)))
        {
            formType = evaluateUVSDK();
        }
        else
        {
            //System.out.println("did not process the uvsdk");
            // Set formType to unknown
            formType = "";
        }
        m_RPBScan.setAirbillType(formType);
    }

    protected String evaluateUVSDK()
    {
        String formType = "";
        synchronized(uvsdk)
        {
            try
            {
                //System.out.println("processing tracking number " + trackingNumber);
                String newTrackingNumber;
                //System.out.println("evaluate UVSDK WS object " + this.toString());
                if (m_RPBScan.getAirbillNumber().length() == 12)
                {
                    // Must be an ETN/NTN tracking number, append the formCode
                    while (getFormCode().length() < 4)
                    {
                        setFormCode("0" + m_formCode);
                    }
                    newTrackingNumber = m_RPBScan.getAirbillNumber() + getFormCode();
                }
                else if (m_RPBScan.getAirbillNumber().length() == 32)
                {
                    // Must be ASTRA, the CheckAirbill will put the start/stop char
                    newTrackingNumber = m_RPBScan.getAirbillNumber();
                }
                else
                {
                    // An old tracking number, uvsdk will supply the form code and form type
                    newTrackingNumber = m_RPBScan.getAirbillNumber();
                }
                newTrackingNumber = uvsdk.CheckAirbill(newTrackingNumber);
                if (newTrackingNumber.length() > 0)
                {
                    // The trackingNumber was valid, now extract the trackingNumber info
                    m_RPBScan.setAirbillNumber(newTrackingNumber);
                    m_RPBScan.setAirbillFormType(uvsdk.GetABFormCode());
                    formType = uvsdk.GetABTypeCode();
                    //System.out.println("Airbill Valid, formCode " + formCode + ", formType " + formType);
                }
                else
                {
                    //System.out.println("Airbill Invalid");
                    // Some kind of invalid AB
                    if (!m_overrideCheckDigit)
                    {
                        m_RPBScan.setErrorNumber(Messages.EM_INVALID_AB);
                        m_RPBScan.setReturnMessage(cciij.util.MessageFormat.errorMessage(Messages.EM_INVALID_AB,getLanguage()));
                    }
                    else
                    {
                        // Set formType to unknown
                        formType = "";
                    }
                }
            }
            catch(Java2uvsdkException e)
            {
                System.out.println("Caught Exception from uvsdk:  " + e);
                e.printStackTrace(System.out);
                throw new RuntimeException("Failed to checkFormType in WorkstationScan:  " + e,e);
            }
        }       // end of synchronized block
        return formType;
    }

    public void evaluateModCheck()
    {
        boolean passedModCheck = true;
        //checking to see if the checkdigit is valid
        if (m_overrideCheckDigit && m_RPBScan.getAirbillNumber() != null && !m_RPBScan.getAirbillNumber().equals(""))
        {
            passedModCheck = ModCheck.checkDigitTest(getTrackingNumberType());
        }
        if (passedModCheck == false && m_overrideCheckDigit == false)
        {
            m_RPBScan.setErrorNumber(Messages.EM_INVALID_AB);
            m_RPBScan.setReturnMessage(cciij.util.MessageFormat.errorMessage(Messages.EM_INVALID_AB,getLanguage()));
        }
        if (!m_overrideCheckDigit && m_RPBScan.getHAWB() != null && !m_RPBScan.getHAWB().equals(""))
        {
            passedModCheck = ModCheck.checkDigitTest(m_RPBScan.getHAWB());
        }
        if (passedModCheck == false && m_overrideCheckDigit == false)
        {
            m_RPBScan.setErrorNumber(Messages.EM_INVALID_HAWB);
            m_RPBScan.setReturnMessage(cciij.util.MessageFormat.errorMessage(Messages.EM_INVALID_AB,getLanguage()));
        }
    }

    public RPBScan evaluateEJBType(WorkstationScanClient scanClient)
    {
        RPBScan returnScan = null;
        switch (m_ejbType)
        {
        case CCIIProperties.EJB_TYPE_NO_PROCESS:
            //get a better error number for this
            m_notify.traceLog("No ejb type set");
            m_RPBScan.setErrorNumber(Messages.EM_CONFIG_FILE_ERROR);
            returnScan = getRPBScan();
            break;
        case CCIIProperties.EJB_TYPE_RULE_PROCESSOR:
            returnScan = processRuleProcessor(scanClient);
            break;
        case CCIIProperties.EJB_TYPE_JOLT_TUX:
            m_RPBScan.setErrorNumber(Messages.EM_WSL_ERROR);
            returnScan = getRPBScan();
            break;
        default:
            m_RPBScan.setErrorNumber(Messages.EM_UNKNOWN_CODE);
            returnScan = getRPBScan();
            String str = "Ack!, didn't find a known ejb_type during processing";
            CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_UNKNOWN_EJBTYPE,str);
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_UNKNOWN_EJBTYPE,str,ex,this);
            break;
        }//end switch
        return returnScan;
    }

    protected RPBScan processRuleProcessor(WorkstationScanClient scanClient)
    {
        //	    System.out.println("cciiState " + cciiState + cciiState.getScan());
        RPBScan returnScan = getRPBScan();
        if (scanClient == null)
        {
            String str = "scan client is Null";
            CCIILogException ex = new CCIILogException(CCIIProperties.WS_ERROR_EJBPROC_NULL_RULEPROC,str);
            m_notify.wsNotifyLog(CCIIProperties.WS_ERROR_EJBPROC_NULL_RULEPROC,str,ex,this);
            m_RPBScan.setErrorNumber(Messages.EM_EJB_CONNECT);
        }
        else
        {
            RPBScan sendingScan = getRPBScan();
            if ( sendingScan.getTransactionTimestamp() == null )
            {
                sendingScan.setTransactionTimestamp ( new Date() );
            }
            //System.out.println("Workstation scan  " + this);
            System.out.println("Workstation sending scan" + sendingScan);
            //returnScan = ruleProcessom_RPBScan.sendScan(scan);
            try
            {
                if (m_RPBScan.getInViewName().equals(scanClient.ARRIVAL_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doArrivalScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.DEPARTURE_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doDepartureScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.QUERY_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doQueryScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.CAGE_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doCageScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.CORP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doCorporateScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.HIP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doHipScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.HOP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doHopScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.RIP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doRipScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.ROP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doRopScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.SIP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doSipScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.SOP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doSopScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.MASS_ENTRY_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doMassEntryScan(sendingScan,m_uploadStatus,m_usePieceLevelIntercept);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.SPS_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doShowPackageStatusScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.ROUTE_EDIT_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doRouteEdit(sendingScan,m_uploadStatus,m_routeLeg);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.STAGE_IN_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doStageInScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.STAGE_OUT_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doStageOutScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.DOWNLOAD_PRINTER_CODES_VIEWNAME))
                {
                    boolean retStatus = scanClient.downloadPrinterCodes(sendingScan.getLocationCode(),sendingScan.getPrinterCode());
                    returnScan = sendingScan;
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.ASSOCIATE_CRN_VIEWNAME))
                {
                    returnScan = scanClient.doAssociateCRN2HAWB(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.STRIP_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doStripPaperworkScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.DETAINMENT_IN_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doDetainmentInScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.DETAINMENT_OUT_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doDetainmentOutScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.REASON_CODE_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doReasonCodeScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.RELEASE_CODE_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doReleaseCodeScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.HANDLING_INSTRUCTION_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doHandlingInstructionScan(sendingScan,m_uploadStatus);
                }
                else if (m_RPBScan.getInViewName().equals(scanClient.SHIPMENT_REMARK_SCAN_VIEWNAME))
                {
                    returnScan = scanClient.doShipmentRemarkScan(sendingScan,m_uploadStatus);
                }
                else
                {
                    System.out.println("Unable to determine scan type, sending generic scan");
                    m_notify.traceLog("Unable to determine scan type, sending generic scan");
                    returnScan = scanClient.doSendGenericScan(sendingScan,m_uploadStatus);
                }
            }catch (Exception e)
            {
                m_RPBScan.setErrorNumber(Messages.EM_EJB_CONNECT);
            }
        }
        return returnScan;
    }
    public void evaluateMiscStep()
    {
        if (m_RPBScan.getPrinterCode() == null || m_RPBScan.getPrinterCode().equals(""))
        {
            m_RPBScan.setPrinterCode(CCIIProperties.NO_PRINTER_DEFINED_CODE);
        }
        if (m_RPBScan.getStagingAreaCode() == null)
        {
            m_RPBScan.setStagingAreaCode("");
        }
        m_RPBScan.setInputDevice(CCIIProperties.readConfigVariableString(
                                                                         CCIIProperties.INPUT_DEVICE_NAME,m_RPBScan.getLocationCode(),
                                                                         CCIIProperties.INPUT_DEVICE_DEFAULT));
        m_RPBScan.setSysDateTime(System.currentTimeMillis());
    }

    public RPBScan processScan(WorkstationScanClient scanClient)
    {
        long startProcess = 0;
        boolean showTiming = CCIIProperties.readConfigVariableBoolean("CCII_SHOW_TIMING",m_RPBScan.getLocationCode(),false);
        if (showTiming)
            startProcess = System.currentTimeMillis();
        RPBScan returnScan=null;
        String routeNum = "";

        String detainLoc = "";

        boolean damagedFlag = false;
        boolean flightDelayedFlag = false;
        boolean wrongFlightFlag = false;
        boolean missedShuttleFlag = false;

        evaluateGenericCode();
        evaluateSingleLine();
        evaluateRouteVector();
        evaluateCheckboxVector();
        evaluateFormCode();
        if (m_RPBScan.getErrorNumber() > Messages.START_OF_ERROR_MSGS)
            return getRPBScan();
        evaluateMiscStep();
        if (getExistingErrorCode() != 0)
        {
            System.out.println("Found existing error: " + getExistingErrorCode());
            m_RPBScan.setReturnMessage(cciij.util.MessageFormat.errorMessage(getExistingErrorCode(),getLanguage()));
            m_RPBScan.setErrorNumber(getExistingErrorCode());
            //error condition, return now
            return getRPBScan();
        }
        evaluateModCheck();
        if (m_RPBScan.getErrorNumber() > Messages.START_OF_ERROR_MSGS)
        {
            return getRPBScan();
        }

        returnScan = evaluateEJBType(scanClient);
        if (showTiming)
            m_notify.traceLog("Time to make EJB call to rule processsor: " + (System.currentTimeMillis() - startProcess));
        return returnScan;
    }

    public Object clone()
    {
        WorkstationScan copy = null;
        try
        {
            copy = (WorkstationScan)super.clone();
        } catch (CloneNotSupportedException e)
        {
            System.out.println("Clone not supported");
            copy = new WorkstationScan();
        }
        copy.setRPBScan((RPBScan)this.getRPBScan().clone());
        copy.setRouteVector((Vector)this.getRouteVector().clone());
        copy.setSingleLineVec((Vector)this.getSingleLineVec().clone());
        copy.setRouteLeg((RouteLeg)this.getRouteLeg().clone());
        copy.setCheckboxVector((Vector)this.getCheckboxVector().clone());
        return copy;
    }

    public String toString()
    {
        String s = this.getClass().getName() + "\n";
        s+= "RPBScan " + m_RPBScan + "\n";
        s+= "existingErrorCode " + m_existingErrorCode + "\n";
        s+= "langauge " + m_language + "\n";
        s+= "trackingNumberType " + m_trackingNumberType + "\n";
        s+= "overrideCheckDigit " + m_overrideCheckDigit + "\n";
        s+= "formCode " + m_formCode + "\n";
        s+= "routeVector: \n";
        if (m_routeVector == null)
        {
            s+= "route Vector is null \n";
        }
        else if (m_routeVector.isEmpty())
        {
            s+= "route Vector is empty";
        }
        else
        {
            for (Iterator it = m_routeVector.iterator(); it.hasNext(); )
            {
                s+= it.next() + "\n";
            }
        }
        s+= "End of Route Vector \n";
        s+= "usePieceLevelIntercept " + m_usePieceLevelIntercept + "\n";
        s+= "genericCode " + m_genericCode + "\n";
        s+= "evaluateGenericCode " + m_evaluateGenericCode + "\n";
        s+= "singleLineVec: \n";
        if (m_singleLineVec == null)
        {
            s+= "Single Line Vector is null \n";
        }
        else if (m_singleLineVec.isEmpty())
        {
            s+= "Single Line Vector is empty";
        }
        else
        {
            for (Iterator it = m_singleLineVec.iterator(); it.hasNext(); )
            {
                s+= it.next() + "\n";
            }
        }
        s+= "end of SingleLineVector\n";
        s+= "useSingleLine " + m_useSingleLine + "\n";
        s+= "routeLeg " + m_routeLeg + "\n";
        s+= "checkboxVector: \n";
        if (m_checkboxVector == null)
        {
            s+= "checkbox Vector is null \n";
        }
        else if (m_checkboxVector.isEmpty())
        {
            s+= "checkbox Vector is empty";
        }
        else
        {
            for (Iterator it = m_checkboxVector.iterator(); it.hasNext(); )
            {
                s+= it.next() + "\n";
            }
        }
        s+= "End of checkbox vector\n";
        s+= "ejbCodeType " + m_ejbCodeType + "\n";
        s+= "upload status " + m_uploadStatus + "\n";
        s+= "ejbType " + m_ejbType +"\n";
        return s;
    }
}
