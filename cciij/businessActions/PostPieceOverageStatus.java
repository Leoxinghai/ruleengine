package cciij.businessActions;

/**
 * Title:       Post Piece Status
 * Description: 
 * Copyright:   Copyright (c) 2001
 * Company:     FedEx Services
 * @author      Lorraine Dominguez
 * @version 1.0
 * Modification History:
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;

public class PostPieceOverageStatus extends BusinessActionBase {

   private static final String m_whatVersion = "@(#) $RCSfile: PostPieceOverageStatus.java,v $Revision: 1.1 $Author: xinghai $Date: \n";

   SortDate m_sortDate = new SortDate();

   public PostPieceOverageStatus() throws Exception 
   {
      traceLog("PostPieceStatus","In Constructor");
   }

   protected void readSiteConfigVariables() throws Exception
   {
      super.readSiteConfigVariables();
      //no local variables to read in
   }


  private PieceStatus getPieceStatus(int pieceOidNbr, String locationCd, Date sortDate, String pieceStatusCd, DatabaseBean dbConnection) throws Exception
  {
     PieceStatus ps = null;
     try
     {
        ps = dbConnection.fetchPieceStatus(pieceOidNbr, locationCd, sortDate, pieceStatusCd); 
     }
     catch (Exception ex)
     {
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure during fetch of Piece Status:  " + ex);
        throw cciiEx;
     }

     return ps;
  }



public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {

  String activityCode = null;
  Date sortDate = null;

  traceLog("PostPieceStatus","Begining doIt()");
  traceLog("PostPieceStatus",state);

  try 
  {
      PieceStatus pieceStatus = null;
      sortDate = m_sortDate.currentSortDate(state.getScan().getLocationCode(),new Date(state.getScan().getSysDateTime()));
      pieceStatus = getPieceStatus(state.getScan().getHandlingUnitOid(), state.getScan().getLocationCode(), sortDate, "O", dbConnection);
      if (pieceStatus != null)
      {
	 activityCode = m_config.getValue("PIECE_STATUS_OVERAGE_DUP");
      }

      else
      {
	 pieceStatus = new PieceStatus();
	 pieceStatus.setPieceOidNbr(state.getScan().getHandlingUnitOid());
	 pieceStatus.setLocationCd(state.getScan().getLocationCode());
	 pieceStatus.setSortDt(sortDate);
	 pieceStatus.setPieceStatusCd("O");
	 pieceStatus.setShipmentOidNbr(state.getScan().getShipmentOid());
	 pieceStatus.setRouteLegOidNbr(state.getScan().getRouteLegOid());


         try
         {
   	    dbConnection.savePieceStatus(pieceStatus);
	 }
	 catch (Exception ex)
	 {
	    state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
	    CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure attempting to save PieceStatus:  " + ex);
	    throw cciiEx;
	 }

	 activityCode = m_config.getValue("PIECE_STATUS_OVERAGE_ADD");
       }
	    
  }
  catch (Exception ex) 
  {
       state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
       CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Failure during fetch of PieceStatus", ex);
       throw cciiEx;
  }


   state.addActivity(activityCode);

   traceLog("PostHandlingUnit","returning ...");
   return state;
}


    public static void main(String args[])
    {
       try
       {
          PostPieceOverageStatus postPieceOverageStatus = new PostPieceOverageStatus();
          postPieceOverageStatus.test();
       }
       catch (Exception e)
       {
          System.out.println(e);
       }
    }

    public void test() throws Exception
    {
       CCIIState cciiState = new CCIIState();
       cciiState.getScan().setLocationCode("OAK");
       cciiState.getScan().setHandlingUnitOid(682425);

       cciiState = (CCIIState) actionEntry(cciiState);
       System.out.println("state after execution " + cciiState);


       return;
    }

}
