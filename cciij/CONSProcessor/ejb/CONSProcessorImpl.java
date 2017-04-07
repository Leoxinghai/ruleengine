package cciij.CONSProcessor.ejb;

import cciij.CONSProcessor.CONSProcessorInterface;
import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;
import cciij.ruleprocessor.RuleProcessorClient;
import cciij.util.Notify;
import cciij.util.UnrollCons;
import java.util.Iterator;
import java.util.Vector;
import rmtc.util.Config;

public abstract class CONSProcessorImpl
    implements CONSProcessorInterface
{

    public CONSProcessorImpl()
    {
        m_config = null;
        m_notify = null;
        m_config = new Config("CONSProcessor");
        m_notify = new Notify("CONSProcessor");
    }

    protected abstract void setRollback();

    public CCIIState processCONS(CCIIState CONSstate)
        throws Exception
    {
        UnrollCons urc = new UnrollCons();
        Vector v = new Vector(25, 10);
        Vector vv = new Vector(25, 10);
        Vector vvv = new Vector(25, 10);
        Iterator vIterator = null;
        CCIIState pieceState = null;
        RPBScan scan = null;
        CCIIState stateResult = null;
        String original_InViewName = null;
        int m_getConsOidNumber = 0;
        String m_getConsCode = null;
        String m_getContainerNumber = null;
        String m_getDestinationLocationCode = null;
        String m_getDestinationCountryCode = null;
        String m_getSplitNumber = null;
        String m_getConsFormTypeCode = null;
        m_notify.trace(1, "Beginning processCONS");
        m_notify.trace(2, "Processing on: ", CONSstate);
        CONSstate.getScan().setErrorNumber(13);
        CONSstate.getScan().setReturnMessage("");
        m_notify.trace(16, "Unrolling CONS");
        v = urc.getVector(CONSstate);
        vIterator = v.iterator();
        pieceState = (CCIIState)v.lastElement();
        if(pieceState.getScan().getErrorNumber() > 31)
        {
            pieceState = (CCIIState)v.lastElement();
            CONSstate.getScan().setErrorNumber(pieceState.getScan().getErrorNumber());
            CONSstate.getScan().setReturnMessage(pieceState.getScan().getReturnMessage());
            m_notify.triggerNotify("Error unrolling CONS: ", pieceState);
            setRollback();
            return CONSstate;
        }
        checkRuleProcessorClient();
        original_InViewName = CONSstate.getScan().getInViewName();
        original_InViewName = original_InViewName.toUpperCase();
        m_notify.trace(16, "Performing Edit Step on CONS");
        for(vIterator = v.iterator(); vIterator.hasNext(); vv.add(stateResult))
        {
            pieceState = (CCIIState)vIterator.next();
            m_notify.trace(128, "Edit Processing Piece: ", pieceState);
            scan = pieceState.getScan();
            scan.setSysDateTime(CONSstate.getScan().getSysDateTime());
            scan.setErrorNumber(0);
            scan.setInViewName("CONSE_" + original_InViewName);
            pieceState.setRuleSetName(m_rpc.getScanRuleSetName(scan));
            stateResult = m_rpc.sendState(pieceState);
            if(stateResult.getScan().getErrorNumber() > 31)
            {
                CONSstate.getScan().setErrorNumber(stateResult.getScan().getErrorNumber());
                CONSstate.getScan().setReturnMessage(stateResult.getScan().getReturnMessage());
                m_notify.triggerNotify("Error on Edit step of CONS: ", stateResult);
                setRollback();
                return CONSstate;
            }
            if(stateResult.getScan().getErrorNumber() != 0 && stateResult.getScan().getErrorNumber() != 3)
                CONSstate.getScan().setErrorNumber(14);
        }

        m_notify.trace(16, "Performing Work Step on CONS");
label0:
        switch(m_config.getInt("CONSWorkConfig", 0))
        {
        case 1: // '\001'
            m_notify.trace(16, "Performing Work Step at CONS level");
            scan = CONSstate.getScan();
            scan.setInViewName("CONSW_" + original_InViewName);
            CONSstate.setRuleSetName(m_rpc.getScanRuleSetName(scan));
            stateResult = m_rpc.sendState(CONSstate);
            if(stateResult.getScan().getErrorNumber() > 31)
            {
                CONSstate.getScan().setErrorNumber(stateResult.getScan().getErrorNumber());
                CONSstate.getScan().setReturnMessage(stateResult.getScan().getReturnMessage());
                m_notify.triggerNotify("Error on Work step of CONS: ", stateResult);
                setRollback();
                return CONSstate;
            }
            for(vIterator = vv.iterator(); vIterator.hasNext(); vvv.add(stateResult))
                stateResult = (CCIIState)vIterator.next();

            break;

        case 2: // '\002'
            m_notify.trace(16, "Performing Work Step at Piece level");
            vIterator = vv.iterator();
            do
            {
                if(!vIterator.hasNext())
                    break label0;
                pieceState = (CCIIState)vIterator.next();
                m_notify.trace(128, "Work Processing Piece: ", pieceState);
                scan = pieceState.getScan();
                scan.setInViewName("CONSW_" + original_InViewName);
                pieceState.setRuleSetName(m_rpc.getScanRuleSetName(scan));
                stateResult = m_rpc.sendState(pieceState);
                if(stateResult.getScan().getErrorNumber() > 31)
                {
                    CONSstate.getScan().setErrorNumber(stateResult.getScan().getErrorNumber());
                    CONSstate.getScan().setReturnMessage(stateResult.getScan().getReturnMessage());
                    m_notify.triggerNotify("Error on Work step of CONS: ", stateResult);
                    setRollback();
                    return CONSstate;
                }
                vvv.add(stateResult);
            } while(true);

        default:
            m_notify.trace(16, "Skipping Work Step on CONS");
            for(vIterator = vv.iterator(); vIterator.hasNext(); vvv.add(stateResult))
                stateResult = (CCIIState)vIterator.next();

            break;
        }
        m_notify.trace(16, "Performing Post Step on CONS");
        for(vIterator = vvv.iterator(); vIterator.hasNext();)
        {
            pieceState = (CCIIState)vIterator.next();
            m_notify.trace(128, "Post Processing Piece: ", pieceState);
            scan = pieceState.getScan();
            scan.setInViewName("CONSP_" + original_InViewName);
            pieceState.setRuleSetName(m_rpc.getScanRuleSetName(scan));
            stateResult = m_rpc.sendState(pieceState);
            m_getConsOidNumber = stateResult.getScan().getConsOid();
            m_getConsCode = stateResult.getScan().getContainerInd();
            m_getContainerNumber = stateResult.getScan().getContainerId();
            m_getDestinationLocationCode = stateResult.getScan().getConsDestLoc();
            m_getDestinationCountryCode = stateResult.getScan().getDestCountry();
            m_getSplitNumber = stateResult.getScan().getSplitNumber();
            m_getConsFormTypeCode = stateResult.getScan().getConsFormType();
            if(stateResult.getScan().getErrorNumber() > 31)
            {
                CONSstate.getScan().setErrorNumber(stateResult.getScan().getErrorNumber());
                CONSstate.getScan().setReturnMessage(stateResult.getScan().getReturnMessage());
                m_notify.triggerNotify("Error on Post step of CONS: ", stateResult);
                setRollback();
                return CONSstate;
            }
        }

        if(m_config.getString("ConsPostConfig_UploadNestedCons", "FALSE").equals("TRUE"))
        {
            m_notify.trace(128, "Nested Post Processing: ", CONSstate);
            scan = CONSstate.getScan();
            if(scan.getConsId() != null && !scan.getConsId().equals("*NONE*") && scan.getConsId().length() != 0)
            {
                CONSstate.setScanTypeCode(m_config.getString("CONSPN_" + original_InViewName + "_SCAN_CODE"));
                scan.setInViewName("CONSPN_" + original_InViewName);
                scan.setConsOid(m_getConsOidNumber);
                scan.setConsType("O");
                scan.setContainerInd(m_getConsCode);
                scan.setContainerId(m_getContainerNumber);
                scan.setConsDestLoc(m_getDestinationLocationCode);
                scan.setDestCountry(m_getDestinationCountryCode);
                scan.setSplitNumber(m_getSplitNumber);
                scan.setConsFormType(m_getConsFormTypeCode);
                CONSstate.setRuleSetName(m_rpc.getScanRuleSetName(scan));
                stateResult = m_rpc.sendState(CONSstate);
                if(stateResult.getScan().getErrorNumber() > 31)
                {
                    CONSstate.getScan().setErrorNumber(stateResult.getScan().getErrorNumber());
                    CONSstate.getScan().setReturnMessage(stateResult.getScan().getReturnMessage());
                    m_notify.triggerNotify("Error on Nested Post step of CONS: ", stateResult);
                    setRollback();
                    return CONSstate;
                }
            }
        }
        m_notify.trace(1, "processCONS successfully completed");
        return CONSstate;
    }

    protected void checkRuleProcessorClient()
        throws Exception
    {
        if(m_rpc == null)
            m_rpc = new RuleProcessorClient();
    }

    protected RuleProcessorClient m_rpc;
    private Config m_config;
    private Notify m_notify;
    public static final String CONS_EDIT_VIEWNAME = "CONSE_";
    public static final String CONS_WORK_VIEWNAME = "CONSW_";
    public static final String CONS_POST_VIEWNAME = "CONSP_";
    public static final String CONS_POST_NESTED_VIEWNAME = "CONSPN_";
}
