package cciij.businessActions;

/**
 * Title:        Find Shuttle Data
 * Description:  This business action finds the shuttle to send this package to
 *

 * Copyright:    Copyright (c) 2003
 * Company:      FedE

 * @author      Liu Xinghai
 * @version 1.0
 *
 * @throws
 *
 * @return       state - State object.
 *
 * Known SubClasses:
 * N/A
 *
 * Pre-conditions:
 * @param        dbConnection - valid database connection from connection pool.
 *
 * 09/6/2005   Julie McCarthy
 *                          Removed dbb.setDatabaseSchemaName();
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.util.Vector;
import java.util.StringTokenizer;

public class FindShuttleData extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: FindShuttleData.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";

    public FindShuttleData() throws Exception
    {
        traceLog("FindShuttleData","In Constructor");
    }

    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)  throws Exception
    {

        Shuttle shuttle = null;
        String warehouseCd = "";
        String destLocationCd = "";
        traceLog("","in doIt method");
        traceLog("FindShuttleData",state);

        try
        {
            warehouseCd = (state.getScan().getWarehouseCode());
            destLocationCd = (state.getScan().getDestLocationCode());
            shuttle = dbConnection.fetchShuttleByWhDest(warehouseCd, destLocationCd);
        }
        catch (Exception ex )
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Failure during fetch of Shuttle data: " + ex);
            throw cciiEx;
        }

        if ( shuttle == null )
        {
            state.getScan().setErrorNumber(Messages.EM_SHUTTLE_NOT_FND);
            state.getScan().setReturnMessage("Shuttle not found for " +
                            "location = " + state.getScan().getLocationCode() +
                            " whse = " + warehouseCd + " and dest = " + destLocationCd);
            return state;
        }

        state.setDiverterCode(shuttle.getSlideAreaCd());
        traceLog("FindShuttleData","returning..");
        return state;
    }

    public static void main(String args[]) throws Exception
  {
         try
         {
             FindShuttleData obj = new FindShuttleData();
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
        traceLog("FindShuttleData","In test method");

        this.m_config.setLocationCode("YYZ");
        rmtc.util.Config cfg = new rmtc.util.Config();
        traceLog("FindShuttleData","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("FindShuttleData","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("FindShuttleData","Server:" + server);
        traceLog("FindShuttleData","User:" + user);
        traceLog("FindShuttleData","Pass:" + pass);

        java.sql.Connection conn =
             java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("FindShuttleData","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("FindShuttleData","Setting Connection object in bean");

        dbb.connect(conn);

        dbb.setLocationCode("YYZ");
        traceLog("FindShuttleData","************* location code = "  + dbb.getLocationCode());

        traceLog("FindShuttleData","Creating State object");

        CCIIState cciiState = new CCIIState();

        traceLog("FindShuttleData","Setting State values");

        cciiState.getScan().setLocationCode(locationCd);
        cciiState.getScan().setDestLocationCode(destinationCd);
        cciiState.getScan().setWarehouseCode(warehouseCd);
        java.util.Date time = new java.util.Date();
        cciiState.getScan().setTransactionTimestamp(time);

        traceLog("FindShuttleData","Calling doIt");

        readSiteConfigVariables();
        cciiState = (CCIIState) doIt(cciiState, dbb);

        traceLog("FindShuttleData","Returned from doIt");
        System.out.println("state after execution " + cciiState);
        System.out.println("State diverter code set to [" + cciiState.getDiverterCode() + "]");

        conn.commit();
        conn.close();

        return;
  }
}
