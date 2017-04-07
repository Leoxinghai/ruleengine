package cciij.businessActions;

/**
 * Title:        Comment Encode
 * Description:  
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx Services
 * @author       Kathy Smathers 
 * @version 1.0
 *
 * @throws       
 *
 * @return       nothing
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 *   02/24/03    Gary Rockwood - Initial creation
 */

import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciicosmos.Cciicosmos;
import cciicosmos.cosmosasn.*;
import java.text.*;
import java.util.*;
import java.io.*;
import com.oss.asn1.*;
import com.oss.util.*;
import rmtc.util.*;


public class CMTEncode extends ASNEncode
{
  private static final String m_whatVersion = "@(#) $RCSfile: CMTEncode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  private rmtc.util.TemplateParser m_parser = null;
  public CMTEncode() throws Exception
  { 
    NoLookupTemplateParser parserKey = new NoLookupTemplateParser();
    m_parser = new rmtc.util.TemplateParser(parserKey);
    traceLog("CMTEncode","In Constructor");
  }


  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
       return state;
  } 

  public  void createMessage(CCIIState state, 
			      DatabaseBean dbConnection,
                              Upload upload)
			      throws Exception

  {  
       String comment = m_parser.buildString(state.getCurrentScan().getCommentDescription(), state);
       state.getCurrentScan().setCommentDescription(comment);
       super.createMessage(state, dbConnection, upload);
  }


  public static void main(String[] args)
  {
     System.out.println("CMTEncode in main");
     System.out.println("Leaving main");
  }

}

