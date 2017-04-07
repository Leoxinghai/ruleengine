package cciij.businessActions;

import cciij.cciidata.CCIIState;
import cciij.cciidatabase.DatabaseBean;
import cciij.cciidata.DetainmentLocDef;
import cciij.util.CCIILogException;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2002
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class VerifyDetainmentLocation extends BusinessActionBase
{

  public VerifyDetainmentLocation() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
        //no local variables to read in
    }

  public CCIIState doIt(CCIIState state, DatabaseBean db) throws java.lang.Exception
  {
    String locationCd = state.getScan().getLocationCode();
    String whseCd = state.getScan().getWarehouseCode();
    String stagingArea = state.getScan().getStagingAreaCode();
    String detainmentLoc =  state.getScan().getDetainLoc();
    DetainmentLocDef detainLocDef = null;

    if (locationCd != null && whseCd != null && stagingArea != null && detainmentLoc != null)
    {
      try
      {
        detainLocDef = db.fetchDetainmentLocDef(
                     locationCd,whseCd,stagingArea,detainmentLoc);
      } catch (Exception ex)
      {
        ex.printStackTrace(System.out);
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","Detainment loc def fetch failed");
        throw cciiEx;
      }
    }
    if (detainLocDef == null)
    {
       state.getScan().setErrorNumber(Messages.EM_INV_DETAIN_LOC);
    }

    return state;
  }
}