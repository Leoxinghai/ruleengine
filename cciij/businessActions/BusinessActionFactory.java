package cciij.businessActions;

/**
 * Title:        Business Action Factory
 * Description:  Construct Vector of Business Action objects.
 * Copyright:    Copyright (c) 2001
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
import cciij.cciidatabase.DatabaseBean;
import java.util.Vector;

public class BusinessActionFactory
{
    protected Config m_config;
    private static final String m_whatVersion = "@(#) $RCSfile: BusinessActionFactory.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    private BusinessActionFactoryBase m_implementation;

    private boolean m_outputDiag = false;

    public BusinessActionFactory () throws Exception {

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

        String ls_busActFactDataSource = m_config.getValue("BUSINESS_ACTION_FACTORY_DATA_SOURCE");

        if(m_outputDiag) System.out.println("BusinessActionFactory::BusinessActionFactory():  Using the FactoryDataSource of:  " + ls_busActFactDataSource);

        if((ls_busActFactDataSource == null) || (ls_busActFactDataSource.equalsIgnoreCase("FILE")))
        {
            m_implementation = new FileBasedBusinessActionFactory(m_config.getValue("BUSINESS_ACTION_FACTORY_DATA_SOURCE_FILE"));
        }
        else if(ls_busActFactDataSource.equalsIgnoreCase("DB"))
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            m_implementation = new DataBaseBasedBusinessActionFactory(db);
        }
        else
        {
            System.out.println("Failed to figure out what businessActions to build!!!");
        }
    }

/**
 * Methoc:       getAction()
 * Description:  Return the BusinessActionInterface object retrieved from
 *               the action objects Vector, using actionType as the index
 *               value for the Vector.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Robert Fisher
 * @version 1.0
 *
 * @param   actionType - index value for Vector of action objects.
 *
 * @returns   cciij.businessActions.BusinessActionInterface
 */

public BusinessActionInterface getAction(int actionType) {
    if(m_outputDiag) System.out.println("BusinessActionFactory::getAction( " + actionType + ");");

    return m_implementation.getAction(actionType);
    //    return (BusinessActionInterface) m_actionObjects.get(actionType);
}


}
