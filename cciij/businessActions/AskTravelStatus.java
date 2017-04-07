package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:        AskTravelStatus
 * Description:  Set the error number to EM_NEED_TRVL_STATUS if we need to
 *               know the travel status of a package
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx Services
 * @author       Gary Rockwood
 * @version 1.0
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        None
 *
 * Modification History:
 *   03/09/04    Gary Rockwood - Initial creation
 */

public class AskTravelStatus extends BusinessActionBase 
{

  private static final String m_whatVersion = "@(#) $RCSfile: AskTravelStatus.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

  private String travelStatusAssumption = "?";
  private Set DomesticIds = new HashSet();
  private int setCount = 0;

  public AskTravelStatus() throws Exception 
  {
    traceLog("AskTravelStatus","In Constructor");
  }

  protected void readSiteConfigVariables() throws Exception
  {
    int paramCount = 1;
    int commaPos = -1;
    String formList = "";
    String paramString = "";
    String patternString = "";
 
    super.readSiteConfigVariables();

    // Only parse if there is a parameter value
    formList = readConfigVariableString("DOMESTIC_FORM_IDS_" + Integer.toString(paramCount), ""); 
    while (formList.length() > 0)
    {
      // Parse each form id and place into set.  Form Id's should be separated by comma's
      StringTokenizer st = new StringTokenizer ( formList, "," );
      while ( st.hasMoreTokens() )
      {
        DomesticIds.add(st.nextToken());
        ++setCount;
      }

      // Increment the paramCount
      ++paramCount;

      formList = readConfigVariableString("DOMESTIC_FORM_IDS_" + Integer.toString(paramCount), "");
    }
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {
    // Determine what the Travel Status assumption is to be set too
    // ? - Ask user if unable to determine after checking the FormId list for known Domestic
    // * - Run FormId past list, if in list then "D", if not in list then "I", Do not ask
    // D - Assume all unknown airbills are Domestic "D", Do not ask
    // I - Assume all unknown airbills are International "I", Do not ask
    // ! - Confirm if Domestic "D" is indicated from list, Ask user
    //   - Any value will set Travel Status to that value (Except for ? and *)
    travelStatusAssumption = readConfigVariableString("TRAVEL_STATUS_ASSUMPTION_" +
                                                      state.getScan().getInViewName().toUpperCase(), "*");

    // If we are not to ask travel status then just return
    if ((travelStatusAssumption.equals("?")) ||
        (travelStatusAssumption.equals("*")) ||
        (travelStatusAssumption.equals("!")))
    {
      // Check if the form id of the scanned package is in the domesticIds set
      if (DomesticIds.contains(state.getScan().getAirbillFormType()))
      {
        // Contained in the list, but do we need to confirm
        if (travelStatusAssumption.equals("!"))
        {
            // Set error Number so we ask user to confirm
            state.getScan().setErrorNumber(Messages.EM_NEED_TRVL_STATUS);
        }
        else
        {
            // Form Type contained in the list, set the travel Status to Domestic "D"
            state.getScan().setTravelStatus("D");
        }
      }
      else
      {
        if (travelStatusAssumption.equals("*"))
        {
          // Not in Domestic List so automatically put into International
          state.getScan().setTravelStatus("I");
        }
        else
        {
          // check if there is a Shell record already created
          if (state.getOverageFlag().equals("Y"))
          {
            // No shell record exists, this must be OverageFlag set to "Y", the first time scanned
            state.getScan().setErrorNumber(Messages.EM_NEED_TRVL_STATUS);
          }
          else
          {
            // Only allow the user to change the travel status if previously selected Domestic
            // Shell record could have been created by other scans, and we do not want to change the entry
            // "D" can only be set from the current scan
            if (state.getTravelStatus().equals("D")) 
            {
              // Allow the user to change travel status if they want
              state.getScan().setErrorNumber(Messages.EM_NEED_TRVL_STATUS);
            }
          }
        }
      }
    }
    else
    {
      // Assign the assumed value
      state.getScan().setTravelStatus( travelStatusAssumption );
    }

    return state;

  }

  public static void main(String[] args)
  {
    System.out.println("AskTravelStatus in main");

    try
    {
      AskTravelStatus askTravelStatus = new AskTravelStatus();
      askTravelStatus.test();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  public void test() throws Exception
  {
    //Test the AskTravelStatus method
    CCIIState cciiState = new CCIIState();
    DatabaseBean dbConnection = null;				// No database connection used

    // Test 1, Ask user for answer by putting 151 in Error Number
    travelStatusAssumption = "?";
    cciiState.getScan().setAirbillFormType("0400");
    cciiState.getScan().setTravelStatus("U");
    cciiState.getScan().setErrorNumber(0);
    cciiState.setOverageFlag("Y");

    cciiState = (CCIIState) doIt(cciiState, dbConnection); 

    System.out.println("Result should be: TravelStatus=U, ErrorNumber=151");
    System.out.println("TravelStatus >" + cciiState.getScan().getTravelStatus() + "<");
    System.out.println("ErrorMessage >" + cciiState.getScan().getErrorNumber() + "<");


    // Test 2, Form Type not in list, so assign Travel Status = I, Error Number = 0
    travelStatusAssumption = "*";
    cciiState.getScan().setAirbillFormType("0400");
    cciiState.getScan().setTravelStatus("U");
    cciiState.getScan().setErrorNumber(0);
    cciiState.setOverageFlag("Y");

    cciiState = (CCIIState) doIt(cciiState, dbConnection);
     
    System.out.println("Result should be: TravelStatus=I, ErrorNumber=0");
    System.out.println("TravelStatus >" + cciiState.getScan().getTravelStatus() + "<");
    System.out.println("ErrorMessage >" + cciiState.getScan().getErrorNumber() + "<");
 

    // Test 3, Form Type in list, so assign Travel Status = D, Error Number = 0
    travelStatusAssumption = "?";
    cciiState.getScan().setAirbillFormType("0450");
    cciiState.getScan().setTravelStatus("U");
    cciiState.getScan().setErrorNumber(0);
    cciiState.setOverageFlag("Y");
    
    cciiState = (CCIIState) doIt(cciiState, dbConnection);
     
    System.out.println("Result should be: TravelStatus=D, ErrorNumber=0");
    System.out.println("TravelStatus >" + cciiState.getScan().getTravelStatus() + "<");
    System.out.println("ErrorMessage >" + cciiState.getScan().getErrorNumber() + "<");


    // Test 4, Second time pkg scanned after asnwering 'D' first time
    travelStatusAssumption = "?";
    cciiState.getScan().setAirbillFormType("0400");
    cciiState.getScan().setTravelStatus("D");
    cciiState.getScan().setErrorNumber(0);
    cciiState.setOverageFlag("M");
    
    cciiState = (CCIIState) doIt(cciiState, dbConnection);
     
    System.out.println("Result should be: TravelStatus=D, ErrorNumber=151");
    System.out.println("TravelStatus >" + cciiState.getScan().getTravelStatus() + "<");
    System.out.println("ErrorMessage >" + cciiState.getScan().getErrorNumber() + "<");


    // Test 5, Set TravelStatus to Assumption value, Error Number = 0
    travelStatusAssumption = "X";
    cciiState.getScan().setAirbillFormType("0400");
    cciiState.getScan().setTravelStatus("U");
    cciiState.getScan().setErrorNumber(0);
    cciiState.setOverageFlag("Y");
    
    cciiState = (CCIIState) doIt(cciiState, dbConnection);
     
    System.out.println("Result should be: TravelStatus=X, ErrorNumber=0");
    System.out.println("TravelStatus >" + cciiState.getScan().getTravelStatus() + "<");
    System.out.println("ErrorMessage >" + cciiState.getScan().getErrorNumber() + "<");

  }

}
