package cciij.businessActions;

import bea.jolt.*;
import cciij.util.*;
import java.io.*;
import java.util.*;
import java.text.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciicosmos.Cciicosmos;
import cciicosmos.cosmosasn.*;


/**
 * Title:       Encode And Upload
 * Description:
 * Copyright:   Copyright (c) 2001
 * Company:
 * @author      Robert Fisher
 *  NOTE:
 * All Post Scan functionality should be done in this routine, none in the Rule Sets
 * The  POSTACTIVITY.doit()  rule set should follow the  ENCODEANDUPLOAD.doit()  Rule
 *
 *
 * @throw       cciij.util.CCIILogException Fetch Scan Definition failed
 * @throw       cciij.util.CCIILogException SCAN_CODE not found
 * @throw       cciij.util.CCIILogException Jolt COMMENT Comment Service call failed
 * @throw       cciij.util.CCIILogException Jolt LOCSTAT Loc Stat Service call failed
 * @throw       cciij.util.CCIILogException Jolt CORP Service call failed
 * @throw       cciij.util.CCIILogException Jolt ECCO Service call failed
 * @throw       cciij.util.CCIILogException STAT Shipment fetch failed
 * @throw       cciij.util.CCIILogException STAT Shipment not found for shipmentOid
 * @throw       cciij.util.CCIILogException Piece Route Leg not found for handlingUnitOid
 * @throw       cciij.util.CCIILogException Piece Route Leg fetch failed
 * @throw       cciij.util.CCIILogException CECO Shipment fetch failed
 * @throw       cciij.util.CCIILogException CECO Shipment not found
 * @throw       cciij.util.CCIILogException Failure assigning Encode View data, no such field
 * @throw       cciij.util.CCIILogException Failure during Jolt Remote Service call
 * @throw       cciij.util.CCIILogException BBQ Service is null, jolt call failed
 *
 * Modification History:
 *   05/06/02    Robert Fisher Collect jolt remote serices in a vector, and call
 *                             their done() at end of doIt
 *   07/26/02    Gary Rockwood All scans to pass thru BBQ to post to COSMOS
 *                             All scans produce a PostScan to SCAN database
 *   09/27/2002  Ed McAleer    Add ROUTE, SORTDATE, and D to overageFlag checks to
 *                             upload to COSMOS for route, sort date, or date overages
 *                             on IPA scans.
 *   10/02/2002  Gary Rockwood Added the CONS and DCON codeing for CorpScan upload
 *
 *   03/04/2003  Gary Rockwood Modified for ASN1 and ECCO in java
 *                             Changes to 'Scan_Def' table    
 *                             New database table called 'Upload_Def'
 *
 *   11/14/2003  Joey Cline    Modified the MQQueue object to be a property
 *                             instead of being a local variable, so that
 *                             the connection manager is not created/destroyed
 *                             with each call.                                 
 *                             Migrated property initialization into the       
 *                             initialize method, since creation of the 
 *                             MQQueue object is dependent on it.
 *
 *   03/08/2003  K. Smathers   Split functionality into the following classes:
 *                             PostMQMessage, ASNEncode, CMTEncode, ECCOEncode,
 *                             STATEncode
 *
 *   08/16/2004  J. Cline      Modified to gather all upload records and place
 *                             into a vector.  Then the vector is process in
 *                             order to add the generated scan objects.
 *                             This change was made in order to circumvent an
 *                             issue with the WL8.1SP2 database drivers
 *                             returning a "Result set closed" error.
 *
 *   12/02/2005  G. Rockwood   Created the only if there are no db errors
 *                             Added some System.out.println to discover what is happening
 *                             Moved private variables into the associated method
 * 
 *   12/16/2005  J. McCarthy   Removed dbb.setDatabaseSchemaName();
 * @version 1.0
 */

public class EncodeAndUpload extends BusinessActionBaseWithOidGeneration 
{
  private  TreeMap m_uploadCategoryDefTree = null;


  private static final String m_whatVersion = "@(#) $RCSfile: EncodeAndUpload.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public EncodeAndUpload() throws Exception 
  {
  }

  protected void initialize() throws Exception
  {
    super.initialize(); 
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception 
  {
    CCIIState m_state = null;
    DatabaseBean m_dbConnection = null;
    ScanDefinition m_scanDefinition = null;
    UploadCategoryDef m_uploadCategoryDef = null;
    Upload m_upload = null;
    Scan m_scan = null;
    String m_errorMessage = null;

    traceLog("EncodeAndUpload",state);

    m_state = state;
    m_dbConnection = dbConnection;
    String key = null;
    UploadKey uploadKey = new UploadKey(state.getScan().getLocationCode(),"SCAN_DEF",state.getScanTypeCode(),state.getScan().getLocStatNbr());
    Vector vecUploadKeys = new Vector();
    vecUploadKeys.addElement(uploadKey);
    state.setUploadKey(vecUploadKeys);
    
    if (m_uploadCategoryDefTree == null)
    { 
      // Create a temporary TreeMap being used while the build is being done
      // Transfer to m_uploadCategoryDefTree only after successful completion  
  	  TreeMap tempTreeMap = new TreeMap();
 
      try
      {
        m_uploadCategoryDef = m_dbConnection.fetchUploadCategoryDef();
      }
      catch (Exception ex)
      {
         m_uploadCategoryDefTree = null;
         System.out.println("Caught UploadCategoryDef fetch error " + ex);
         ex.printStackTrace(System.out);
         m_state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
         CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch Upload Category Def failed");
         throw cciiEx;
      }
      while (m_uploadCategoryDef != null)
      {
        key = m_uploadCategoryDef.getLocationCode() + ":" +
                           m_uploadCategoryDef.getUploadCategoryCode();
        if(tempTreeMap.containsKey(key) == false)
        {
          System.out.println("EncodeAndUpload, adding category " + key);
          tempTreeMap.put(key,m_uploadCategoryDef);
        }
        // Read the next Record from Upload Definition
        try
        {
          m_uploadCategoryDef = 
                     m_dbConnection.fetchNextUploadCategoryDef();
        }
        catch (Exception ex)
        {
          m_uploadCategoryDefTree = null;
          m_state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch UploadCategoryDef failed");
          throw cciiEx;
        }
      }
      // If we got here there were no errors or exceptions 
      m_uploadCategoryDefTree = tempTreeMap;
    }

    try
    { 
      traceLog("EncodeAndUpload", "m_state.getUploadKey().size() " + m_state.getUploadKey().size() );
      if (m_state.getUploadKey().size() > 0)
      {
        traceLog("EncodeAndUpload", "m_state.getUploadKey() " + m_state.getUploadKey() );
        m_upload = m_dbConnection.fetchUpload(m_state.getUploadKey());
      }
    }
    catch (Exception ex)
    {
      m_state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
				  "Fetch Upload Definition failed");
      ex.printStackTrace ( System.err );
      throw cciiEx;
    }

    if (m_state.getUploadKey().size() > 0)
    {
      if (m_upload == null)
      {
        System.out.println("EncodeAndUpload, no upload for scan type " + m_state.getScanTypeCode() + 
                           " with key >" + m_state.getUploadKey() + "<");
      }
    }
    else
    {
      System.out.println("EncodeAndUpload, no upload for scan type " + m_state.getScanTypeCode() +
                         " No key specified");
    }
    
    Vector uObjects = new Vector();

    while (m_upload != null)
    {
//      System.out.println("EncodeAndUpload, upload " + m_state.getUploadKey() + " " + 
//                                                      m_upload.getUploadSeqNumber() + " " +
//                                                      m_upload.getUploadCategoryCode() + " " +
//                                                      m_upload.getUploadCode() + " " + 
//                                                      m_upload.getClassIdCode() + ":" + 
//                                                      m_upload.getFieldIdCode());
      traceLog("EncodeAndUpload", "Adding to the Vector: " + m_upload );
      uObjects.add ( m_upload );
      try
      {
        // Read the next Record from Upload 
        m_upload= m_dbConnection.fetchNextUpload();
      }
      catch (Exception ex)
      {
        m_state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Fetch Upload Definition failed");
        ex.printStackTrace ( System.err );
        throw cciiEx;
      }
    }     // end of while     

    Enumeration uEnum = uObjects.elements();

    while (uEnum.hasMoreElements())
    {
      m_upload = (Upload) uEnum.nextElement();
      traceLog("EncodeAndUpload", "Processing via enumeration: " + m_upload );

      Boolean  getCondition;

      System.out.println("EncodeAndUpload, looking for " + m_upload.getClassIdCode() + 
                         ":" + m_upload.getFieldIdCode() + " Scan " + m_upload.getUploadCode()); 
      traceLog("EncodeAndUpload", "Testing for Upload Definition, class :" 
               + m_upload.getClassIdCode() + ":, field :" 
               + m_upload.getFieldIdCode() + " scan " 
               + m_upload.getUploadCode());

      getCondition = (Boolean)m_state.get(m_upload.getClassIdCode(), m_upload.getFieldIdCode());

      if (getCondition != null && getCondition.booleanValue())
      {
        key = m_upload.getLocationCode() + ":" +
                           m_upload.getUploadCategoryCode();
        if(m_uploadCategoryDefTree.containsKey(key) == true)
        {
          m_uploadCategoryDef = 
                 (UploadCategoryDef)m_uploadCategoryDefTree.get(key);
          System.out.println("EncodeAndUpload, Scan className " + m_uploadCategoryDef.getClassName());
          Class l_class = 
                 Class.forName(m_uploadCategoryDef.getClassName()); 
          PostMessageInterface message = 
                 (PostMessageInterface) l_class.newInstance();
          m_scan = createScan(m_state, m_upload);
          state.setCurrentScan(m_scan);
          // createMessage may change the the scanTypeCode or 
          // locStatNbr in the scan object
          message.initialize(m_uploadCategoryDef, "COSMOS", "Output");
          message.createMessage( m_state, m_dbConnection,
					m_upload);
          m_state.addScan(m_scan);
        }
        else
        {
          System.out.println("EncodeAndUpload, key " + key + " not found");
        }
      }
      else
      {
        System.out.println("EncodeAndUpload, upload set to false");
        traceLog("EncodeAndUpload", "Upload not set to true" ); 
      }
 
    }     // end of while     

    m_state.setUploadFlag("C");

    return m_state;
  }

  private Scan createScan(CCIIState m_state, Upload m_upload) throws Exception
  {
    SortDate m_sortDate = new SortDate();
    String scanCode = null;
    Date sortDate = null;

    sortDate = m_sortDate.currentSortDate(m_state.getScan().getLocationCode(),new Date(m_state.getScan().getSysDateTime()));

    Scan scan = new Scan(0, //ScanOid
               m_state.getScan().getHandlingUnitOid(), //HUOid
               m_state.getScan().getShipmentOid(), //ShipmentOid
               new Date(m_state.getScan().getSysDateTime()), //DateTime
               m_state.getScan().getUserLogon(), //User
               m_upload.getUploadCode(), 
               "00", //locStatNbr
               m_state.getScan().getStagingAreaCode(), //StagingAreaCode
               "", //StagingAreaFlag
               "", //fromCONSFlag
               sortDate,//sort date
               m_state.getScan().getLocationCode(),//locationcd
               m_state.getScan().getWarehouseCode(),//warehouseCd
               m_state.getScan().getInputMethodCode(),  //inputMethodCd
               m_upload.getUploadTemplateDescription()); 
  
    try                                                                       
    {                                                                         
      scan.setScanOidNumber(getOid(OidFactoryTypes.SCAN));                    
    }                                                                         
    catch (Exception ex)                                                      
    {                                                                         
      m_state.getScan().setErrorNumber(Messages.EM_JOLT_APP_ERROR);
      String msg = "Failure during Jolt service call to get Scan Oid Number " + ex + "(See System.err for initial stack trace)";
      traceLog("PostScan", msg);
      System.err.println(msg);
      ex.printStackTrace(System.err); 
      CCIILogException cciiEx = 
           new CCIILogException("BA_JOLT_ERROR_NUMB", msg );
      throw cciiEx;
    }                                                                         
    scan.setScanLocationDescription(m_state.getScan().getDetainLoc());          
    // This field is set in the 'UnrollCons.java" routine 
    if (m_state.getScan().getFromConsFlag().equals("Y")) 
    {
      scan.setFromConsFlag("Y");   
    }
    return scan;
  }


  public static void main(String args[])
  {
    try
    {
      EncodeAndUpload encodeAndUpload = new EncodeAndUpload();
      encodeAndUpload.test();
    }
    catch (Exception ex)
    {
      System.out.println(ex);
    } 
  } 
   
  public void  test() throws Exception
  {
    traceLog("EncodeAndUpload","In test method");

    Date now = new Date();
    rmtc.util.Config cfg = new rmtc.util.Config();
    traceLog("EncodeAndUpload","Loading Oracle driver");
    java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    traceLog("VerifyDepartureScan","Establishing a connection");
    String server = cfg.getValue("JDBC_SERVER");
    String user = cfg.getValue("JDBC_USER");
    String pass = cfg.getValue("JDBC_PASSWORD");
    traceLog("EncodeAndUpload","Server:" + server);
    traceLog("EncodeAndUpload","User:" + user);
    traceLog("EncodeAndUpload","Pass:" + pass);

    System.out.println("calling getconnection....................");
    java.sql.Connection conn =
    java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

    traceLog("EncodeAndUpload","Creating DB Bean");

    DatabaseBean dbb = new DatabaseBean();

    traceLog("EncodeAndUpload","Setting Connection object in bean");

    dbb.connect(conn);
    dbb.setLocationCode("NRT");
    traceLog("EncodeAndUpload","************* location code = "  + dbb.getLocationCode());

    traceLog("EncodeAndUpload","Creating State object");

    CCIIState state = new CCIIState();
    RPBScan scan = new RPBScan();
    scan.setSysDateTime(now);
    scan.setInViewName("   ");
    scan.setShipmentOid(12345);
    scan.setHandlingUnitOid(12345);
    scan.setUserLogon("92163");
    scan.setLocStatNbr("22"); 
    scan.setStagingAreaCode("EEC");
    scan.setLocationCode("NRT");
    scan.setWarehouseCode("IWJ");
    scan.setInputMethodCode("YYZ");
    scan.setFromConsFlag("N");
    scan.setDetainLoc("" );
    scan.setTransactionTimestamp(now);
    state.setScan(scan);
    state.setScanTypeCode("STAT");
    state.addUploadKey("NRT", "SCAN_DEF", "STAT", "22");
    state.addUploadKey("NRT", "SCAN_DEF", "BOUT", "00");
    System.out.println("Before" + state);
    state = (CCIIState) actionEntry(state);

    System.out.println("After" + state);
    return;
  }

} // End of EncodeAndUpload Class


