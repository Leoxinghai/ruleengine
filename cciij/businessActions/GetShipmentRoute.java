package cciij.businessActions;

/**
 * Title:         Get Routing
 * Description:   Stubb to be implimented in the future.
 * Copyright:     Copyright (c) 2007
 * Company:       FedEx Services
 * @author        Robert Fisher
 * @version 1.0
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * Modification History:
 * 12/26/2001    Ed McAleer   Add comments and document tags.
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.CCIILogException;


public class GetShipmentRoute extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: GetShipmentRoute.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
  public GetShipmentRoute() throws Exception
  {
  }

  protected void readSiteConfigVariables() throws Exception
  {
    super.readSiteConfigVariables();
    // no local variables to read in
  }

  public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception
  {

    RouteLeg routeLeg;
    try
    {
        state.setRouteLegInfo(dbConnection.fetchRouteLeg(state.getScan().getLocationCode(),
                                                         state.getScan().getShipmentOid()));
//        routeLeg = dbConnection.fetchRouteLeg(state.getScan().getLocationCode(),
// 					     state.getScan().getShipmentOid());
//        state.getRouteLegInfo().setRouteNumber(routeLeg.getRouteNumber());
//        state.getRouteLegInfo().setRouteDate(routeLeg.getRouteDate());
//        state.getRouteLegInfo().setSortDate(routeLeg.getSortDate());
    }
    catch (Exception ex )
    {
        state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
        CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
             "Failure during fetch of PieceRouteLeg data",ex);
        throw cciiEx;
    }

    traceLog("GetShipmentRouting",state);
    return state;


  }

  public static void main(String[] args)
  {
     System.out.println("Business Action GetShipmentRoute in main");

     try
     {
        GetShipmentRoute getShipmentRoute = new GetShipmentRoute();
        getShipmentRoute.test();
     }
     catch (Exception e)
     {
         System.out.println(e);
         e.printStackTrace(System.out);
     }
  }

  public void test() throws Exception
  {
     rmtc.util.Config cfg = new rmtc.util.Config();
     java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
     String server = cfg.getValue("JDBC_SERVER");
     String user = cfg.getValue("JDBC_USER");
     String pass = cfg.getValue("JDBC_PASSWORD");
     m_config.setLocationCode("OAK");
     java.sql.Connection conn =
         java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

     DatabaseBean dbb = new DatabaseBean();


     dbb.connect(conn);
     dbb.setLocationCode("OAK");
     CCIIState state = new CCIIState();
     state.getScan().setShipmentOid(23647144);
     state.getScan().setLocationCode("OAK");
     state = (CCIIState) doIt(state, dbb);
     System.out.println("Leaving Business Action main");
     conn.commit();
     conn.close();
  }

}
