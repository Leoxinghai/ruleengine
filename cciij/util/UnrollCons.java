package cciij.util;

import rmtc.util.*;
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.businessActions.Messages;
import java.util.*;
import java.io.FileNotFoundException;


public class UnrollCons {
Config m_config;
DatabaseBean m_db = new DatabaseBean();

public UnrollCons() {

  m_config = new Config("UNKNOWN");
  m_db.connect();

}

// Make sure the tracking number belongs to the CONS number scanned.   A Tracking number
// can belong to multiple CONS.

public Vector getVector(CCIIState state) throws Exception {
  Vector tempV = new Vector();
  Cons cons = null;
  HandlingUnit handlingUnit = null;
  CCIIState tempState = null;

  try {
    cons = m_db.fetchCons(state.getScan().getAirbillNumber());         // Airbill Number contains the scanned CONS number
  }
  catch (Exception ex) {
    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
    throw ex;
  }

  if ( cons == null ) {
     state.getScan().setErrorNumber(Messages.EM_CONS_NOT_FOUND);
     tempV.add(state);

     // Do not throw an exception, handle it programatically 
//     throw new Exception("CONS fetch returned null for:  " + state.getScan().getAirbillNumber());
  }

  while ( cons != null ) {

    // Only include the entry if the DeconsFlag is not set to "D"
    if (cons.getDeconsFlag().equals("D"))
    {
      // The entry is marked as deleted, just ignore it
    }
    else {
      if (cons.getOidTypeCode().equals("C")) {
        // This is a nested CONS
        UnrollCons m_ucons = new UnrollCons();
        Vector consV = new Vector();

        tempState = (CCIIState) state.clone();

        tempState.getScan().setAirbillNumber(cons.getTrackingNumber());
        tempState.getScan().setAirbillType("3");
        tempState.getScan().setAirbillFormType(cons.getFormTypeCode());
//        tempState.getScan().setAirbillFormType("0500");    // Should be the form type code from the CONS_SUMMARY

        // This field is checked to setting the 'from_cons_flg' in the Scan table
        tempState.getScan().setFromConsFlag("Y");

        // Expand this CONS into a vector
        consV = m_ucons.getVector(tempState);

        // Check that there were no problems in this nesting
        if (tempState.getScan().getErrorNumber() == 0)
        {
          // No errors, Add the content of consV vector to tempV vector
          tempV.addAll(consV);
        }
        else {
          // Some kind of error on the nested Cons
          return tempV;
        }
      }
      else {  
        // Not a CONS airbill
        try {
          handlingUnit = m_db.fetchHandlingUnit(cons.getOidNumber());
        }
        catch (Exception ex) {
          state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
          tempV.add(state);
          throw new Exception("HU (in CONS) fetch returned null for oid:  " + cons.getOidNumber());
        }

        tempState = (CCIIState) state.clone();

        tempState.getScan().setAirbillNumber(handlingUnit.getTrackingNumber());
        tempState.getScan().setAirbillType(handlingUnit.getAirbillTypeCode());
        tempState.getScan().setAirbillFormType(cons.getFormTypeCode());
//        tempState.getScan().setAirbillFormType(handlingUnit.getFormTypeCode());
        tempState.getScan().setHandlingUnitOid(handlingUnit.getHandlingUnitOidNumber());

        // This field is checked to setting the 'from_cons_flg' in the Scan table    
        tempState.getScan().setFromConsFlag("Y");

        tempV.add(tempState);
      }
    }

    cons = m_db.fetchNextCons();
  }

  return tempV;
}
 

 public static void main(String[] args){
     System.out.println("UnrollCons in main");

     UnrollCons o = new UnrollCons();


     System.out.println("Leaving UnrollCons");
    }



}
