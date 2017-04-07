package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;

/**
 * Title:        Set Handling Unit Oid
 * Description:  Set the Handling Unit Oid property of the scan object
 *               by looking up the AWB in the DB.
 * Copyright:    Copyright (c) 2005
 * Company:      FedEx Services
 * @author       Joey Cline
 * @version 1.0
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 01/11/2005    Joey Cline   Initial version
 */

public class SetHandlingUnitOid extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: SetHandlingUnitOid.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public SetHandlingUnitOid() throws Exception
  {
    traceLog("SetHandlingUnitOid","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    HandlingUnit handlingUnit = null;

    try
    {
      handlingUnit =  dbConnection.fetchHandlingUnit(state.getScan().getAirbillNumber(),m_locationList.getLocationList());
      if ( handlingUnit == null )
      {
        state.getScan().setHandlingUnitOid(0);
        state.getScan().setShipmentOid(0);
        return state;
      }
      else
      {
        if ( dbConnection.getHandlingUnitRecordCount() > 1 )
        {
          int activeHitsFound = 0;
          // more than one record exists, see how many have a manifest status == A
          while ( ( handlingUnit != null )
               && ( activeHitsFound < 2 ) )
          {
            if ( handlingUnit.isManifested() )
            {
              activeHitsFound++;
            }
            try
            {
              handlingUnit = dbConnection.fetchNextHandlingUnit();
            }
            catch (Exception ex)
            {
              handlingUnit = null;
            }
          }

          if ( activeHitsFound > 1 )
          {
            // duplicates found
            state.getScan().setHandlingUnitOid(0);
            state.getScan().setShipmentOid(0);
            return state;
          }
        }
      }

      state.getScan().setHandlingUnitOid( handlingUnit.getHandlingUnitOidNumber() );
      state.getScan().setShipmentOid( handlingUnit.getShipmentOidNumber() );

    }
    catch (Exception ex)
    {
      m_notify.triggerNotify("Failed to call db.fetchHandlingUnit(" + state.getScan().getAirbillNumber()
           + ", " + m_locationList.getLocationList() + ")", ex);
      state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
      CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB","HandlingUnit fetch failed",ex);
      throw cciiEx;
    }

    return state;
  }

  public static void main(String[] args)
  {
    System.out.println("SetHandlingUnitOid in main");

    System.out.println("Leaving main");
  }
}
