package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

 import cciij.cciidata.RPBScan;
 import cciij.cciidata.UploadStatus;
 import cciij.cciidata.RouteLeg;


public class WorkstationScanClient extends cciij.ruleprocessor.CCIIScanClient
{

  public static final String MASS_ENTRY_SCAN_VIEWNAME = "MASS_ENTRY_INTERCEPT";

  public WorkstationScanClient() throws Exception
  {
  }

    /**
     * doMassEntryScan
     * Used to send Mass Entry Intercept scans to the Scan Engine
     * @param scanObj populated RPBScan object
     * @param uploadObj populated UploadStatus object
     * @return the RPBScan object returned from the Scan Engine
     */
    public RPBScan doMassEntryScan(RPBScan scanObj, UploadStatus uploadObj, boolean isPieceLevelIntercept)
           throws Exception
    {
      scanObj.setInViewName(MASS_ENTRY_SCAN_VIEWNAME);
      return doCommonCode(scanObj,uploadObj,null,false,isPieceLevelIntercept);
    }
    /**
     * doRouteEdit
     * Used to send route edit commands to the Scan Engine
     * @param scanObj populated RPBScan object
     * @param uploadObj populated UploadStatus object
     * @param rl populated with the edited route leg
     * @return the RPBScan object returned from the Scan Engine
     */

    public RPBScan doRouteEdit(RPBScan scanObj, UploadStatus uploadObj,RouteLeg rl) throws Exception
    {
      scanObj.setInViewName(ROUTE_EDIT_SCAN_VIEWNAME);
      return doCommonCode(scanObj,uploadObj,rl,false,false);
    }

    /**
     * doAssociateCRN2HAWB
     * Used to associate a CRN to a HAWB on the workstation
     * @param scanObj populated RPBScan object
     * @return the RPBScan object returned from the Scan Engine
     */

    public RPBScan doAssociateCRN2HAWB(RPBScan scanObj) throws Exception
    {
      scanObj.setInViewName(ASSOCIATE_CRN_VIEWNAME);
      return doCommonCode(scanObj,null,null);
    }

    /**
     * doAssociateCRN2HAWB
     * Used to associate a CRN to a HAWB on the workstation
     * @param scanObj populated RPBScan object
     * @return the RPBScan object returned from the Scan Engine
     */

    public RPBScan doAssociateCRN2HAWB(RPBScan scanObj,UploadStatus uploadObj) throws Exception
    {
      scanObj.setInViewName(ASSOCIATE_CRN_VIEWNAME);
      return doCommonCode(scanObj,uploadObj,null);
    }

}