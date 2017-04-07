package cciij.businessActions;

/**
 * Title:       Business Action Base
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Robert Fisher
 * @version 1.0
 */

import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import bea.jolt.*;

public abstract class BusinessActionBaseWithOidGeneration extends  BusinessActionBase 
{
    private static final String m_whatVersion = "@(#) $RCSfile: BusinessActionBaseWithOidGeneration.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    
    OidGenerator oid = null;
    
    public BusinessActionBaseWithOidGeneration() throws Exception 
    {
	traceLog("BusinessActionBaseWithOidGeneration()","Constructing object ["+hashCode()+"]");
    }

    public BusinessActionBaseWithOidGeneration(String group) throws Exception 
    {
	super(group);
	traceLog("BusinessActionBaseWithOidGeneration()","Constructing with parm("+group+") object ["+hashCode()+"]");
    }


    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();
    }

    protected void initialize() throws Exception 
    {
	traceLog("BusinessActionBaseWithOidGeneration","In initialize for object ["+hashCode()+"]");
	super.initialize();
	// oid = new OidGenerator();
	// traceLog("BusinessActionBaseWithOidGeneration", "initialize - oid is " + oid );
    }
    
    protected int getOid(int oidType) throws Exception {
	int returnOid = 0;

        if ( oid == null )
        {
            oid = new OidGenerator();
	    traceLog("BusinessActionBaseWithOidGeneration", "getOid for object ["+hashCode()+"], new oid is " + oid );
        }
        else
        {
	    traceLog("BusinessActionBaseWithOidGeneration", "getOid, oid is for object ["+hashCode()+"] " + oid );
        }
	traceLog("BusinessActionBaseWithOidGeneration", "getOid, oidType for object ["+hashCode()+"] is " + oidType );
	returnOid = oid.getOid(oidType);
	traceLog("BusinessActionBaseWithOidGeneration", "getOid, returning oid for object ["+hashCode()+"] " + returnOid );
	return  returnOid;
    }
}
