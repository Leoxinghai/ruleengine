package cciij.businessActions;

/**
 * Title:        Business Action Factory
 * Description:  Construct Vector of Business Action objects.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * N/A
 *
 * NOTICE: The constructor is defined to throw exceptions. Currently all the exceptions
 *         are passed through from the various Business Actions to the
 *         Rule Processor. In the future special error handling could be implemented
 *         to handle specific exceptions.
 *
 * Modification History:
 * 10/29/2001    Ed McAleer   Add tags and complete description. Also change
 *                            the class definition to include throws.
 * 04/29/2002    Ed McAleer   Comment out System.out.println().
 */

import cciij.util.*;
import rmtc.util.*;
import java.util.Vector;

public class BusinessActionFactoryBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: BusinessActionFactoryBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    private Vector    m_actionObjects;

    private int m_vectorInitedSize;

    protected Config m_config;
    protected boolean m_outputDiag=false;

    public BusinessActionFactoryBase()
    {
        m_config = new Config();

        String outputDiag = m_config.getValue("BUSINESS_ACTION_FACTORY_OUTPUT");
        if((outputDiag != null) && (outputDiag.equals("TRUE")))
        {
            m_outputDiag = true;
        }
        else
        {
            m_outputDiag = false;
        }

        m_actionObjects = new Vector();

        m_vectorInitedSize = 0;
    }



/**
 * Methoc:       getAction()
 * Description:  Return the BusinessActionInterface object retrieved from
 *               the action objects Vector, using actionType as the index
 *               value for the Vector.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @param   actionType - index value for Vector of action objects.
 *
 * @returns   cciij.businessActions.BusinessActionInterface
 */

    public BusinessActionInterface getAction(int actionType)
    {
        if(m_outputDiag) System.out.println("BusinessActionFactoryBase::getAction( " + actionType + ");");
        return (BusinessActionInterface) m_actionObjects.get(actionType);
    }

    protected void setAction(int actionType,BusinessActionInterface action) throws Exception
    {
        for(;m_vectorInitedSize <= actionType;m_vectorInitedSize++)
        {
            m_actionObjects.add(new DummyBusinessAction());
        }

        m_actionObjects.set(actionType,action);

        return;
    }

}
