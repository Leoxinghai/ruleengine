package cciij.businessActions;

/**
 * Title:       Oid Generator
 * Description:
 * Copyright:   Copyright (c) 2007
 * Company:     FedEx Services
 * @author      Robert Fisher
 * @version 1.0
 *
 * @throw       cciij.util.CCIILogException Failure during Jolt Service call Oid service
 *
 * @throw       java.lang.Exception Config item missing, JOLT_IP_ADDRESS not found
 *
 * @return      cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 *
 * Modification History:
 * 12/26/2001    Ed McAleer   Add tags and complete description.
 *
 * 05/06/2002  Robert Fisher  Clean up jolt remote service, and session attributes each call
 * 05/08/2002 Liu Xinghai  Now calls OIDSERVER directly and only does so when the block is empty
 * 10/27/2003 Liu Xinghai  Now calls rmtc.OidServer.OidFactory.getOid() which calls the new EJB OidServer
 *
 */

import cciij.util.*;
import rmtc.util.*;
import java.io.*;


public class OidGenerator {
    private static final String m_whatVersion = "@(#) $RCSfile: OidGenerator.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public OidGenerator() throws Exception {
        m_config = new Config("OidGenerator");
        initialize();
    }

    protected  Config m_config;

    //    protected String m_tableName[] = new String[64];

    protected rmtc.OidServer.OidFactory m_oidFactory;

    private void initialize() throws Exception
    {
//         m_tableName[OidFactoryTypes.ACTIVITYLOG] = "clearanceActivity";
//         m_tableName[OidFactoryTypes.CHANGE] = "change";
//         m_tableName[OidFactoryTypes.SHIPMENT] = "shipment";
//         m_tableName[OidFactoryTypes.SHIPMENTREMARK] = "shipmentRemark";
//         m_tableName[OidFactoryTypes.SCAN] = "scan";
//         m_tableName[OidFactoryTypes.HANDLINGUNIT] = "piece";
//         m_tableName[OidFactoryTypes.CONS] = "cons";
//         m_tableName[OidFactoryTypes.CONSSUMMARY] = "conssummary";
//         m_tableName[OidFactoryTypes.REASONCODE] = "reasonCd";
//         m_tableName[OidFactoryTypes.RELEASECODE] = "releaseCd";
//         m_tableName[OidFactoryTypes.HANDLINGINSTRUCTIONS] = "handlingInstruction";
//         m_tableName[OidFactoryTypes.INTERCEPT] = "intercept";
//         m_tableName[OidFactoryTypes.MISCELLANEOUS] = "miscellaneous";
//         m_tableName[OidFactoryTypes.PARTY] = "party";
//         m_tableName[OidFactoryTypes.ENTRY] = "entry";
//         m_tableName[OidFactoryTypes.PIECEROUTELEG] = "piece_route_leg";
//         m_tableName[OidFactoryTypes.SECURITYLOG] = "securityLog";

        m_oidFactory = new rmtc.OidServer.OidFactory();
    }


    public int getOid(int what) throws Exception
    {
        //	System.out.println("OidGenerator.getOid(" + what + ");");

        return m_oidFactory.getOid(OidFactoryTypes.tableNames[what]);
    }



    public static void main(String[] args) throws Exception
    {
        System.out.println("OID Generator in main");

        OidGenerator o = new OidGenerator();

	java.util.Set s = new java.util.TreeSet();

        int oid;
        if(args.length == 1)
        {
            System.out.println("Using the new method");
	    int howMany = Integer.parseInt(args[0]);
	    TestClass tc = new TestClass(howMany,OidFactoryTypes.SHIPMENT,s,"ALL");
	    Thread th = new Thread(tc);
	    th.start();
// 	    for(int i=0;i<howMany;i++)
// 	    {
// 		oid = o.getOid(OidFactoryTypes.SHIPMENT);
// 		System.out.println("Got an OID:  " + oid);
// 	    }
        }
	else if(args.length == 2)
	{
	    System.out.println("Using the new multi-thread method");
	    int howManyThreads = Integer.parseInt(args[0]);
	    int howMany = Integer.parseInt(args[1]);
            Thread th[] = new Thread[howManyThreads];
            TestClass tc[] = new TestClass[howManyThreads];
	    for(int i=0;i<howManyThreads;i++)
	    {
		System.out.println("Starting Thread #" + i);

		tc[i] = new TestClass(howMany,
                                      OidFactoryTypes.SHIPMENT,
                                      s,
                                      (((i%2) == 0) ? "EVEN" : "ODD"));
		th[i] = new Thread(tc[i]);
		th[i].start();
	    }

            for(int j=0;j<howManyThreads;j++)
            {
                th[j].join();
            }

            for(int k=0;k<howManyThreads;k++)
            {
                tc[k].printResults();
                th[k] = null;
                tc[k] = null;
            }

            th=null;
            tc=null;
	}
        else
        {
//             System.out.println("Using the Old Method");
//             oid = o.getOid2(OidFactoryTypes.SHIPMENT);
// 	    System.out.println("Got an OID:  " + oid);
            System.out.println("Old Method disabled");
	}


        System.out.println("Leaving Oid Generator");

        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    private static class TestClass implements Runnable
    {
	private int iterations=0;
	private OidGenerator o = null;
	private int oidType=0;
	private java.util.Set m_set=null;
        private String m_results="";

	public TestClass(int iterations,int oidType,java.util.Set set,String address) throws Exception
	{
	    this.iterations = iterations;
	    this.oidType = oidType;
	    this.m_set = set;
	    o = new OidGenerator();
	    o.m_config.setGroup(address);
	    //	    o.m_config.setValue(,"ALL","WEB_SERVER_ADDRESS",address);
	}

	public void run()
	{
	    int oid=0;
            java.util.Date startDt = new java.util.Date();

	    try
	    {
		for(int i=0;i<iterations;i++)
		{
		    oid = o.getOid(oidType);
		    System.out.println("Got an OID:  " + oid);
		    if(m_set.add(new Integer(oid)) == false)
		    {
			System.out.println("Found a duplicate in the set!!!!!!!!!!!!");
			System.exit(0);
		    }
		}
	    }
	    catch(Exception e)
	    {
		System.out.println("Oidgenerator.TestClass.run() caught Exception:  " + e);
		e.printStackTrace(System.out);
	    }

            java.util.Date endDt = new java.util.Date();
            long timeTaken = endDt.getTime() - startDt.getTime();

            m_results = "" + iterations + " getOidCalls took:  " + timeTaken + " ms for an average time of " + (timeTaken/iterations) + " ms";

            System.gc();
	}

        public void printResults()
        {
            System.out.println(m_results);
        }

	public void setIteration(int it)
	{
	    iterations = it;
	}
    }

}
