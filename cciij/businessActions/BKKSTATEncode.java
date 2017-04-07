/*
 * Created on Mar 19, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import cciicosmos.cosmosasn.CosmosMasterGrp;
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

import java.util.*;

import com.oss.asn1.IA5String;

public class BKKSTATEncode extends BusinessActionBase
{
	  private static final String m_whatVersion = "@(#) $RCSfile: BKKSTATEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
	  SortDate m_sortDate = new SortDate();

	  public BKKSTATEncode() throws Exception
	  {
	  }

	  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
	  {
	  	String ms_scanTypeCode = state.getScanTypeCode();
	  	
	    if (ms_scanTypeCode.equals("SIP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 SIP scan is type 02
	    }

	    // This paragraph for the SOP Scan
	    if (ms_scanTypeCode.equals("SOP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 SOP scan is type 01
	    }

	    // this paragraph for the RIP Scan
	    if (ms_scanTypeCode.equals("RIP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 RIP scan is type 24
	    }

	    // This paragraph for the ROP Scan
	    if (ms_scanTypeCode.equals("ROP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 ROP scan is type 22
	    }

	    // this paragraph for the HIP Scan
	    if (ms_scanTypeCode.equals("HIP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 HIP scan is type 13
	    }

	    // This paragraph for the HOP Scan
	    if (ms_scanTypeCode.equals("HOP"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 HOP scan is type 10
	      // Fields not done in CCII application
	      //        Container Id                                      // 141 Container Id
	      //        Freight Checked Flag                              // 184 Freight Checked
	      //        Mini Sort Flag                                    // 268 Mini Sort
	      //        Cons Destination Location                         // 631 Cons Destination
	      //        Container Indicator                               // 222 Container Indicator
	    }
/*
	    if (ms_scanTypeCode.equals("STAT"))
	    {
	    	state.getScan().setLocStatNbr("07");                                       //  41 STAT scan is type 07
	    }
*/
	    // this paragraph for the CONS Scan
	    if (ms_scanTypeCode.equals("CONS"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 CONS scan is type 12
	    }

	    if (ms_scanTypeCode.equals("DCON"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 DCON scan is type 14
	    }

	    if (ms_scanTypeCode.equals("CMT"))
	    {
	    	state.getScan().setLocStatNbr("00");                                       //  41 CMT scan is type 90
	    }
	    state.getUploadStatus().setAlwaysFlag(true);
	    //state.getScan().setEntryNumber("3");
	    state.getScan().setAirbillEntry("3");
	    return state;
	  }
	  protected void readSiteConfigVariables() throws Exception
	  {
	    super.readSiteConfigVariables();
	    //no local variables to read in
	  }
	  
	public static void main(String args[])
	{
	} 
	   
	}
