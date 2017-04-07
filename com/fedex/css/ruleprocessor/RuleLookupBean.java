/*
 * Created on Oct 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.css.ruleprocessor;

import com.fedex.css.ruleprocessor.ejb.*;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


/**
 *
 * <!-- begin-user-doc --> A generated session bean <!-- end-user-doc --> *
 <!-- lomboz.beginDefinition -->
 <?xml version="1.0" encoding="UTF-8"?>
 <lomboz:EJB xmlns:j2ee="http://java.sun.com/xml/ns/j2ee" xmlns:lomboz="http://lomboz.objectlearn.com/xml/lomboz">
 <lomboz:session>
 <lomboz:sessionEjb>
 <j2ee:display-name>RuleLookup</j2ee:display-name>
 <j2ee:ejb-name>ruleprocessor.RuleLookup</j2ee:ejb-name>
 <j2ee:ejb-class>com.fedex.css.ruleprocessor.RuleLookupBean</j2ee:ejb-class>
 <j2ee:session-type>Stateless</j2ee:session-type>
 <j2ee:transaction-type>Container</j2ee:transaction-type>
 </lomboz:sessionEjb>
 </lomboz:session>
 </lomboz:EJB>
 <!-- lomboz.endDefinition -->
 *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="RuleLookup"	
 *           jndi-name="ruleprocessor.RuleLookup"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */
public class RuleLookupBean extends RuleLookupImpl
implements SessionBean
{

public RuleLookupBean()
{
}

public void ejbActivate()
{
}

public void ejbPassivate()
{
}

public void ejbRemove()
{
}

public void setSessionContext(SessionContext sessioncontext)
{
    sctx = sessioncontext;
}

public void ejbCreate()
{
	updateRules();
}

SessionContext sctx;
}