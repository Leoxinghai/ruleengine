package cciij.businessActions;

/**
 * Title:         TemplateParser.java
 * Description:   Function to build a String for the activityDesc field in clearance activity
 * Copyright:     Copyright (c) 2007
 * Company:       FedEx Services
 * @author       Liu Xinghai
 * @version 1.0
 *
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 *
 * Pre-conditions:
 *
 * Modification History:
 * 05/09/2002   Liu Xinghai Created
 *
 */

import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
import java.lang.reflect.*;

public class TemplateParser {
    private static final String m_whatVersion = "@(#) $RCSfile: TemplateParser.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public static final int CONSTANT = 1;
    public static final int STATE=2;
    public static final int SCAN=3;
    public static final int DETERMINE=4;

    /////////////////////////////////////////////////////////////////////////////
    private class TemplateElement {
        private boolean m_isConstant;
        private String m_constString;
        private Method m_method;
        private int    m_dataSource;

        public TemplateElement(int a_dataSource,String a_str) throws Exception
        {
            Object l_object;

            switch(a_dataSource)
            {
            case CONSTANT:
                m_constString = a_str;
                m_isConstant = true;
                return;
                //		break;
            case STATE:
                l_object = new CCIIState();
                break;
            case SCAN:
                l_object = new RPBScan();
                break;
            case DETERMINE:
                l_object = new CCIIState();
                break;
            default:
                throw new Exception("Invalid data Source in TemplateElement constructor:  " + a_dataSource);
                //		break;
            }

            try
            {
                Class l_class = l_object.getClass();
                Class l_paramTypes[] = new Class[0];

                try
                {
                    m_method = l_class.getMethod(a_str,l_paramTypes);

                    if(a_dataSource == DETERMINE)
                    {
                        a_dataSource = STATE;
                    }
                }
                catch(Exception e)
                {
                    if(a_dataSource == DETERMINE)
                    {
                        l_object = new RPBScan();
                        l_class = l_object.getClass();
                        m_method = l_class.getMethod(a_str,l_paramTypes);
                        a_dataSource = SCAN;
                    }
                    else
                    {
                        throw e;
                    }
                }

                m_dataSource = a_dataSource;
                m_isConstant = false;
            }
            catch(Exception e)
            {
                System.out.println("Caught an exception in the reflection stuff, assume blank const string:  + e");
                e.printStackTrace();
                m_constString = "";
                m_isConstant = true;
            }

            return;
        }

        public String getValue(CCIIState state) throws Exception
        {
            if(m_isConstant)
            {
                return m_constString;
            }

            Object l_paramList[] = new Object[0];
            Object l_dataSource=null;
            Object l_methodResult;

            switch(m_dataSource)
            {
            case STATE:
                l_dataSource = state;
                break;
            case SCAN:
                l_dataSource = state.getScan();
                break;
            default:
                throw new Exception("Invalid internal state in TemplateElement:  " + m_dataSource);
                //		break;
            }

            l_methodResult = m_method.invoke(l_dataSource,l_paramList);

            if(l_methodResult == null)
            {
                return "";
            }
            else
            {
                return l_methodResult.toString();
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    Vector m_components;

    public TemplateParser(String as_template) throws Exception
    {
        //	System.out.println("TemplateParser(" + as_template + ") ");

        m_components = new Vector();

        boolean l_isConstant=true;

        int li_start=0;
        int li_div=0;
        int li_secondDiv;

        while((li_div = as_template.indexOf("\\",li_start)) >= li_start)
        {
            if(li_div > li_start)
            {
                if(l_isConstant)
                {
                    m_components.add(new TemplateElement(CONSTANT,as_template.substring(li_start,li_div)));
                }
                else
                {
                    m_components.add(getElement(as_template.substring(li_start,li_div)));
                }
            }

            l_isConstant = !l_isConstant;
            li_start = li_div + 2;
        }

        m_components.add(new TemplateElement(CONSTANT,as_template.substring(li_start)));

        return;
    }

    private TemplateElement getElement(String as_key) throws Exception
    {
        String ls_key = as_key.toUpperCase();

        // HAWB & AWB is the shipment airbill number
        if(ls_key.equals("HAWB") || ls_key.equals("AWB"))
        {
            return new TemplateElement(SCAN,"getHAWB");
        }

        // TrkNbr is the CRN or MPS number
        if(ls_key.equals("TRKNBR"))
        {
            return new TemplateElement(SCAN,"getAirbillNumber");
        }

        // IntCd  is the intercept Code
        if(ls_key.equals("INTCD"))
        {
            return new TemplateElement(SCAN,"getInterceptCode");
        }

        // IntDesc is the Intercepted Flag
        if(ls_key.equals("INTDESC"))
        {
            return new TemplateElement(STATE,"getInterceptedFlag");
        }

        // ScanCd is the scan type cd
        if(ls_key.equals("SCANCD"))
        {
            return new TemplateElement(STATE,"getScanTypeCode");
        }

        // ScanDesc is the RuleSet name
        if(ls_key.equals("SCANDESC"))
        {
            return new TemplateElement(STATE,"getRuleSetName");
        }

        // AgencyCd is the Agency Code
        if(ls_key.equals("AGENCYCD"))
        {
            return new TemplateElement(STATE,"getAgencyCode");
        }

        // RouteDate is the route date from the route_leg table
        if(ls_key.equals("ROUTEDATE"))
        {
            return new TemplateElement(SCAN,"getRouteLegDate");
        }

        // Route Number is the route name
        if(ls_key.equals("ROUTENUMBER"))
        {
            return new TemplateElement(SCAN,"getRouteNumber");
        }

        // UserLogon  is the person who did this thing
        if(ls_key.equals("USERLOGON"))
        {
            return new TemplateElement(SCAN,"getUserLogon");
        }

        // Timestamp  is the time of the event
        if(ls_key.equals("TIMESTAMP"))
        {
            return new TemplateElement(SCAN,"getSysDateTime");
        }

        // LocStatNbr is the Loc Stat Number
        if(ls_key.equals("LOCSTATNBR"))
        {
            return new TemplateElement(SCAN,"getLocStatNbr");
        }

        // StageArea is the Staging Area of this scan
        if(ls_key.equals("STAGEAREA"))
        {
            return new TemplateElement(SCAN,"getStagingAreaCode");
        }

        // DetainLoc  is the Detainment Location of this scan
        if(ls_key.equals("DETAINLOC"))
        {
            return new TemplateElement(SCAN,"getDetainLoc");
        }

	// ConsTag is the ConsID that the awb is scanned into/outof
	if(ls_key.equals("CONSID"))
	{
	    return new TemplateElement(SCAN,"getConsId");
	}

        return new TemplateElement(CONSTANT,"*** Unknown " + as_key + " ***");
    }

    public String buildString(CCIIState state) throws Exception
    {
        String ls_retString="";
        int i;
        TemplateElement l_element;

        for(i=0;i<m_components.size();i++)
        {
            l_element = (TemplateElement)m_components.elementAt(i);
            ls_retString += l_element.getValue(state);
        }

        return ls_retString;
    }

    private static final int SHIPOID=1;
    private static final int PIECEOID=2;
    private static final int ROUTEOID=3;

    private int mi_oidType=0;

    public void setOidType(String as_oidType)
    {
        if(as_oidType.equals("S"))
        {
            mi_oidType = SHIPOID;
        }
        else if(as_oidType.equals("P"))
        {
            mi_oidType = PIECEOID;
        }
        else if(as_oidType.equals("R"))
        {
            mi_oidType = ROUTEOID;
        }
        else
        {
            mi_oidType = 0;
        }

        return;
    }

    public String getOidType()
    {
        switch(mi_oidType)
        {
        case SHIPOID:
            return "S";
        case PIECEOID:
            return "P";
        case ROUTEOID:
            return "R";
        default:
            return "";
        }
    }

    public int getOid(CCIIState state)
    {
        switch(mi_oidType)
        {
        case SHIPOID:
            return state.getScan().getShipmentOid();
        case PIECEOID:
            return state.getScan().getHandlingUnitOid();
        case ROUTEOID:
            return state.getScan().getRouteLegOid();
        default:
            return 0;
        }
    }


    public static void main(String args[]) throws Exception
    {
        TemplateParser l_parser = new TemplateParser(args[0]);

        CCIIState state = new CCIIState();
        RPBScan scan = new RPBScan();

        scan.setHAWB(">HAWB<");
        scan.setAirbillNumber(">AirbillNbr<");
        scan.setInterceptCode(">Intercept<");
        state.setInterceptedFlag(">IntFlag<");
        state.setScanTypeCode(">ScanCode<");
        state.setRuleSetName(">RuleSetName<");
        scan.setAgencyCode(">Agency<");
        scan.setRouteLegDate(new Date());
        scan.setRouteNumber(">RouteNbr<");
        scan.setUserLogon(">364942<");
        scan.setSysDateTime(new Date());
        scan.setStagingAreaCode(">Stage_Area_Code<");
        scan.setDetainLoc(">Detainment_location<");

        state.setScan(scan);

        String resultString = l_parser.buildString(state);

        System.out.println("Template Parser came up with:  |" + resultString + "|");

        return;
    }
}
