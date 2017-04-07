/*
 * Created on Oct 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.CONSProcessor;

import cciij.CONSProcessor.ejb.*;

import java.io.PrintStream;
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
 <j2ee:display-name>CONSProcessor</j2ee:display-name>
 <j2ee:ejb-name>ccii.consprocessor</j2ee:ejb-name>
 <j2ee:ejb-class>cciij.CONSProcessor.CONSProcessorBean</j2ee:ejb-class>
 <j2ee:session-type>Stateless</j2ee:session-type>
 <j2ee:transaction-type>Container</j2ee:transaction-type>
 </lomboz:sessionEjb>
 </lomboz:session>
 </lomboz:EJB>
 <!-- lomboz.endDefinition -->
 *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="CONSProcessor"	
 *           jndi-name="ccii.rplarge1cons"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */
public class CONSProcessorBean extends CONSProcessorImpl
implements SessionBean
{

public CONSProcessorBean()
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

public void setSessionContext(SessionContext arg1)
{
    sctx = arg1;
}

public void ejbCreate()
{
}

protected void setRollback()
{
    try
    {
        if(sctx != null)
            sctx.setRollbackOnly();
    }
    catch(Exception ex)
    {
        System.out.println("EXCEPTION DURING setRollback: " + ex);
        ex.printStackTrace();
    }
}

SessionContext sctx;
}
