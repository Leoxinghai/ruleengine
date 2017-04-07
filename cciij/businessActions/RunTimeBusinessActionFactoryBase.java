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
import java.lang.reflect.*;

public class RunTimeBusinessActionFactoryBase extends BusinessActionFactoryBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: RunTimeBusinessActionFactoryBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    RunTimeBusinessActionFactoryBase() throws Exception
    {
    }

    protected void buildAndSetAction(int actionType,String classNm, boolean constructorParamPresent,String constructorParam) throws Exception
    {
        if(m_outputDiag) System.out.println("RunTimeBusinessActionFactoryBase(" + actionType + ", " + classNm + ", " + constructorParamPresent + ", " + constructorParam + ")");

        Class l_class = Class.forName(classNm);

        Constructor l_constructor;
        Class l_constrParams[];
        Object l_params[];

        if(constructorParamPresent)
        {
            l_constrParams = new Class[1];
            l_constrParams[0] = (new String()).getClass();
            l_params = new Object[1];
            l_params[0] = constructorParam;
        }
        else
        {
            l_constrParams = new Class[0];
            l_params = new Object[0];
        }


        try
        {
            l_constructor = l_class.getConstructor(l_constrParams);

            Object l_thisClass = l_constructor.newInstance(l_params);

            setAction(actionType,(BusinessActionInterface)l_thisClass);
        }
        catch(InvocationTargetException ite)
        {
            System.out.println("Caught an InvocationTargetException:  " + ite);
            System.out.println("With a included Exception of:  " + ite.getTargetException());
            ite.getTargetException().printStackTrace(System.out);
            //	    System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("Caught an exception trying to construct a BA..." + e);
            e.printStackTrace();
            System.exit(0);
        }

        if(m_outputDiag) System.out.println("RuntimeBusinessActionFactoryBase construction Success");

        return;
    }
}
