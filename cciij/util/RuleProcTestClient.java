package cciij.util;

import cciij.ruleprocessor.RuleProcessorClient;
import cciij.cciidata.RPBScan;

public class RuleProcTestClient
{
    public static void main(String args[])
    {
	try
	{
	    RuleProcessorClient client = new RuleProcessorClient();
	    RPBScan scan = new RPBScan();
	    
	    // Set any params needed here...
	    
	    scan.setInViewName("RINTView");
	    scan.setInterceptCode("QST");
	    scan.setAgencyCode("AGI");
	    scan.setShipmentOid(-2003);

	    // Valid values for actionCode (from MRS & CABRK only)
	    //   A Add User Int
	    //   B Add Recuring Int
	    //   D Del User Int
	    //   E Del Recuring Int
	    //   S Sat User Int
	    //   T Sat Recuring Int
	    //   Q Release Shipment
	    //   U Un-Reelase Shipment
	    scan.setActionCode("A");
	    
	    RPBScan retScan = client.sendScan(scan);
	    
	    System.out.println("****************************************************");
	    System.out.println("Return Scan:");
	    System.out.println("****************************************************");
	    System.out.println(retScan);
	}
	catch(Exception e)
	{
	    System.out.println("Caught an Exception in RuleProcTestClient.main():  " + e);
	    e.printStackTrace(System.out);
	}
    }
}
