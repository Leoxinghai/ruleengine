package cciij.businessActions;

/**
 * Title:        ExplodeConsBase
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Lorraine Dominguez
 * @version 1.0
 *
 * @throws       cciij.util.CCIILogException ConsSummary fetch failed
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
 *   07/31/02    Lorraine Dominguez - Initial creation
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public abstract class ExplodeConsBase extends BusinessActionBase {

  private static final String m_whatVersion = "@(#) $RCSfile: ExplodeConsBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  public ExplodeConsBase() throws Exception
  {
    traceLog("ExplodeConsBase","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    //no local variables to read in
  }

  public abstract CCIIState doIt (CCIIState s, DatabaseBean db) throws Exception;

  protected void setStateAndScanProperties(CCIIState stateObj)
  {
    //empty in this implementation
    //will give subclasses ability to set specific values in CCIIState and RPBScan objects
  }

  protected Vector explodeCons (CCIIState s, DatabaseBean db) throws Exception
  {
     Vector pieceVector = new Vector();
     UnrollCons consInfo = new UnrollCons();

     //this method returns a vector of state objects
     //one object for each piece belonging to the cons number
     pieceVector = consInfo.getVector(s);

     //go through vector
     for (Iterator it = pieceVector.iterator(); it.hasNext();)
     {
       //call method for each object within vector
       setStateAndScanProperties((CCIIState)it.next());
     }

     return pieceVector;
  }

  public static void main(String[] args)
  {
     System.out.println("");
     System.out.println("Leaving main");
  }

}

