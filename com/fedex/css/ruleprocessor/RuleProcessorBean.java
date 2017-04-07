/*
 * Created on Oct 27, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.css.ruleprocessor;

import javax.ejb.SessionBean;
import com.fedex.css.ruleprocessor.RuleLookup;
import com.fedex.css.ruleprocessor.RuleLookupHome;
import java.io.PrintStream;
import java.util.Hashtable;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import rmtc.util.Config;
import com.fedex.css.ruleprocessor.ejb.RuleProcessorImpl;;

/**
 *
 * <!-- begin-user-doc --> A generated session bean <!-- end-user-doc --> *
 <!-- lomboz.beginDefinition -->
 <?xml version="1.0" encoding="UTF-8"?>
 <lomboz:EJB xmlns:j2ee="http://java.sun.com/xml/ns/j2ee" xmlns:lomboz="http://lomboz.objectlearn.com/xml/lomboz">
 <lomboz:session>
 <lomboz:sessionEjb>
 <j2ee:display-name>RuleProcessor</j2ee:display-name>
 <j2ee:ejb-name>ccii.rplarge1</j2ee:ejb-name>
 <j2ee:ejb-class>com.fedex.css.ruleprocessor.RuleProcessorBean</j2ee:ejb-class>
 <j2ee:session-type>Stateless</j2ee:session-type>
 <j2ee:transaction-type>Container</j2ee:transaction-type>
 </lomboz:sessionEjb>
 </lomboz:session>
 </lomboz:EJB>
 <!-- lomboz.endDefinition -->
 *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="RuleProcessor"	
 *           jndi-name="ccii.rplarge1"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */
public abstract class RuleProcessorBean extends RuleProcessorImpl
implements javax.ejb.SessionBean {
    public RuleProcessorBean()
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

    public void ejbCreate() throws javax.ejb.CreateException 
    {
        try
        {
            Config config = new Config();
            String s = config.getValue("WEB_SERVER_ADDRESS");
            InitialContext initialcontext = null;
            Hashtable hashtable = new Hashtable();
            hashtable.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
            hashtable.put("java.naming.provider.url", "t3://" + s);
            initialcontext = new InitialContext();
            Object obj = initialcontext.lookup("ruleprocessor.RuleLookup");
            RuleLookupHome rulelookuphome = (RuleLookupHome)PortableRemoteObject.narrow(obj, com.fedex.css.ruleprocessor.RuleLookupHome.class);
            super.ruleLookup = (RuleLookup)PortableRemoteObject.narrow(rulelookuphome.create(), com.fedex.css.ruleprocessor.RuleLookup.class);
        }
        catch(Exception exception)
        {
            System.out.println("EXCEPTION: " + exception);
            exception.printStackTrace();
            throw new javax.ejb.CreateException(exception.toString());
        }
        initialize();
    }

    protected void setRollback()
    {
        try
        {
            if(sctx != null)
                sctx.setRollbackOnly();
        }
        catch(Exception exception)
        {
            System.out.println("EXCEPTION DURING setRollback: " + exception);
            exception.printStackTrace();
        }
    }

    SessionContext sctx;

}
