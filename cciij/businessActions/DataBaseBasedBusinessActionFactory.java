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

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import java.util.*;
import java.io.*;

public class DataBaseBasedBusinessActionFactory extends RunTimeBusinessActionFactoryBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: DataBaseBasedBusinessActionFactory.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public DataBaseBasedBusinessActionFactory (DatabaseBean db) throws Exception
    {
        int li_actionID;
        String ls_className;
        boolean l_constructorParam;
        String ls_constructorParam;

        // Here we will iterate through the new DB table and call buildAndSetAction
        //	buildAndSetAction(li_actionID,ls_className,l_constructorParam,ls_constructorParam);
    }

    public static void main(String[] args)
    {
        try
        {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            DataBaseBasedBusinessActionFactory l_factory = new DataBaseBasedBusinessActionFactory(db);

            for(int i=0;i<42;i++)
            {
                System.out.println(l_factory.getAction(i).getClass().getName());
            }
        }
        catch(Exception e)
        {
            System.out.println("Caught an exception:  " + e);
            e.printStackTrace();
        }
        return;
    }
}
