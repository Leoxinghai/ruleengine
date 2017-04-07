package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class VerifyEntryTypeCode extends BusinessActionBase
{

  public VerifyEntryTypeCode() throws Exception
  {
    super("VerifyEntryTypeCode");
    traceLog("VerifyEntryTypeCode", "In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
  }


  public CCIIState doIt(CCIIState state, DatabaseBean db) throws java.lang.Exception
  {


    // check to ensure entryTypeCode is present
    if (state.getScan().getEntryType() == null
        || state.getScan().getEntryType().length() == 0 )
    {
      traceLog("FindEntryTypeCode.doIt()",
               " failed validation, returning error");
      state.getScan().setErrorNumber(Messages.EM_INVALID_ENTRY_TYP);
      return state;
    }

    EntryTypeDefinition entryTypeDef = null;

    try
    {
       entryTypeDef = db.fetchEntryTypeDef(state.getScan().getEntryType());
    }
    catch ( Exception ex )
    {
      traceLog("VerifyEntryTypeCode.doIt()",
               "caught exception fetching entryTypeDefinition:: " + ex);
      ex.printStackTrace();
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.setAbortFlag(true);
      return state;
    }

    // there is no active flag in this definition, just see if something returned
    if ( entryTypeDef == null )
    {
      state.getScan().setErrorNumber(Messages.EM_INVALID_ENTRY_TYP);
      return state;
    }

    Shipment ship = null;
    // need to check etd upper limit against the shipment local_customs_value
    try
    {
      ship = db.fetchShipment(state.getScan().getShipmentOid());
    }
    catch (Exception ex)
    {
      traceLog("VerifyEntryTypeCode.doIt()",
               "caught exception fetching shipment:: " + ex);
      ex.printStackTrace();
      ship = null;
    }

    // if ship == null it was not found in the database an exception during the fetch
    if ( ship == null )
    {
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      state.setAbortFlag(true);
      return state;
    }

    // Check if this is the first time thru 
 System.out.println("EntryValRestOverride >" + state.getScan().getEntryValRestOverride() + "<");
    if (state.getScan().getEntryValRestOverride().equals("U"))
    {
       if ( entryTypeDef.getUpperEntryValueAmt() > 0
           && ship.getLocalCustomValueAmount() > entryTypeDef.getUpperEntryValueAmt())
      {
        state.getScan().setErrorNumber(Messages.EM_VALUE_RESTRICTION);
        //??? Hey Tom, should I set the abort flag
        state.setAbortFlag(true);
        return state;
      }
    }

    return state;

  }
  public static void main(String[] args) throws Exception {
//    VerifyEntryTypeCode verifyEntryTypeCode1 = new VerifyEntryTypeCode();
  }

}
