/*
 * Created on Aug 4, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

/**
 * @author Liu Xinghai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.util.Vector;
import java.util.StringTokenizer;

public class FindTruck extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: FindTruck.java,v $ $Revision: 1.1 $ $Author: cvs $ $Date: 2006/09/05 10:09:25 $\n";

    public FindTruck() throws Exception
    {
        traceLog("FindTruckData","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)  throws Exception
    {

        Truck truck = null;
        String warehouseCd = "";
        traceLog("","in doIt method");
        traceLog("FindTruckData",state);

        try
        {
            //warehouseCd = (state.getScan().getWarehouseCode());
            truck = dbConnection.fetchTruckByTruckId(state.getScan().getShuttleID());
        }
        catch (Exception ex )
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Failure during fetch of Truck data: " + ex);
            throw cciiEx;
        }

        if ( truck == null )
        {
            state.getScan().setErrorNumber(Messages.EM_TRUCK_NOT_FOUND);
            state.getScan().setReturnMessage("Truck not found for " +
                            "location = " + state.getScan().getLocationCode() +
                            " whse = " + warehouseCd);
            return state;
        }
        if(truck.getActiveFlag().equals("N")) {
            state.getScan().setErrorNumber(Messages.EM_TRUCK_NOT_FOUND);
            return state;
        }

        traceLog("FindTruckData","returning..");
        return state;
    }

    public static void main(String args[]) throws Exception
  {
         try
         {
             FindTruck obj = new FindTruck();
             obj.test(args[0], args[1], args[2]);
         }
         catch (Exception e)
         {
            System.out.println(e);
            e.printStackTrace(System.out);
         }
    }


    public void test(String locationCd, String warehouseCd, String destinationCd) throws Exception
    {
        traceLog("FindTruckData","In test method");

        this.m_config.setLocationCode("YYZ");
        rmtc.util.Config cfg = new rmtc.util.Config();
        traceLog("FindTruckData","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("FindTruckData","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("FindTruckData","Server:" + server);
        traceLog("FindTruckData","User:" + user);
        traceLog("FindTruckData","Pass:" + pass);

        java.sql.Connection conn =
             java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("FindTruckData","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("FindTruckData","Setting Connection object in bean");

        dbb.connect(conn);

        dbb.setLocationCode("YYZ");
        traceLog("FindTruckData","************* location code = "  + dbb.getLocationCode());

        traceLog("FindTruckData","Creating State object");

        CCIIState cciiState = new CCIIState();

        traceLog("FindTruckData","Setting State values");

        cciiState.getScan().setLocationCode(locationCd);
        cciiState.getScan().setDestLocationCode(destinationCd);
        cciiState.getScan().setWarehouseCode(warehouseCd);
        java.util.Date time = new java.util.Date();
        cciiState.getScan().setTransactionTimestamp(time);

        traceLog("FindTruckData","Calling doIt");

        readSiteConfigVariables();
        cciiState = (CCIIState) doIt(cciiState, dbb);

        traceLog("FindTruckData","Returned from doIt");
        System.out.println("state after execution " + cciiState);
        System.out.println("State diverter code set to [" + cciiState.getDiverterCode() + "]");

        conn.commit();
        conn.close();

        return;
  }
}
