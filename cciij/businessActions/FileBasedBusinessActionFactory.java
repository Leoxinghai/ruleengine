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
import java.util.*;
import java.io.*;

public class FileBasedBusinessActionFactory extends RunTimeBusinessActionFactoryBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: FileBasedBusinessActionFactory.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public FileBasedBusinessActionFactory (String as_fileName) throws Exception
    {
        if(m_outputDiag) System.out.println("FileBasedBusinessActionFactory::FileBasedBusinessActionFactory( " + as_fileName + ")");

        //	BufferedReader l_reader = new BufferedReader(new FileReader(as_fileName));
        java.net.URL fileURL = FileBasedBusinessActionFactory.class.getResource(as_fileName);
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(fileURL.openStream()));
        String ls_line;
        int i=0;

        while(((ls_line = l_reader.readLine()) != null))
        {
            i++;

            if((ls_line.length() <= 0)
               || (ls_line.charAt(0) == '#'))
            {
                continue;
            }

            StringTokenizer l_tokenizer = new StringTokenizer(ls_line,":");


            //	    System.out.println("Line Number:  " + i);

            while(l_tokenizer.hasMoreTokens())
            {
                String ls_actionID = l_tokenizer.nextToken();

                int li_actionID = Integer.parseInt(ls_actionID);

                String ls_className = l_tokenizer.nextToken();
                String ls_constructorParam=null;
                boolean l_constructorParam;

                try
                {
                    ls_constructorParam = l_tokenizer.nextToken();
                }
                catch(NoSuchElementException e)
                {
                    l_constructorParam = false;
                }

                if((ls_constructorParam != null) && (ls_constructorParam.length() > 0))
                {
                    l_constructorParam = true;
                }
                else
                {
                    l_constructorParam = false;
                }

                String ls_displayName;

                try
                {
                    ls_displayName = l_tokenizer.nextToken();
                }
                catch(NoSuchElementException e)
                {
                    l_constructorParam = false;
                    ls_displayName = ls_constructorParam;
                }


// 		System.out.println("Action ID:                " + li_actionID);
// 		System.out.println("Class Name:               " + ls_className);
// 		if(l_constructorParam)
// 		{
// 		    System.out.println("Constructor Param:        " + ls_constructorParam);
// 		}
// 		System.out.println("Display Name:             " + ls_displayName);


                buildAndSetAction(li_actionID,ls_className,l_constructorParam,ls_constructorParam);
            }

        }
    }

    public static void main(String[] args)
    {
        try
        {
            FileBasedBusinessActionFactory l_factory = new FileBasedBusinessActionFactory(args[0]);

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
