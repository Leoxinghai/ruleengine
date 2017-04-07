package cciij.businessActions;

/**
 * Title:        Verify Shuttle Data
 * Description:  This business action verifies that the shuttle id and destination
 *               location code that is defined in the Scan object exists (so the
 *               package's destination location maps to the shuttle indicated).
 *               If it is not correct an error code will be set.  The state object
 *               is returned to the caller.
 *
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author       Julie McCarthy
 * @version 1.1
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
 * Modifications:
 * 2003-04-10  Joey Cline   Added code to validate the shuttle status code
 *
 * 09/6/2005   Julie McCarthy
 *                          Removed dbb.setDatabaseSchemaName();
 */

 import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

public class VerifyShuttleData extends BusinessActionBase
{
    private static final String m_whatVersion = "@(#) $RCSfile: VerifyShuttleData.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    protected Vector m_codes = null;
    protected Vector m_fedexShuttleTypes = null;

    public VerifyShuttleData() throws Exception
    {
        traceLog("VerifyShuttleData","In Constructor");
    }
    protected void readSiteConfigVariables() throws Exception
    {
        super.readSiteConfigVariables();

        m_codes = new Vector();
        String codes = readConfigVariableString("VALID_SHUTTLE_STATUS_CODES","");

        if ( codes != null )
        {
          StringTokenizer st = new StringTokenizer ( codes, "," );
          while ( st.hasMoreTokens() )
          {
            m_codes.add(st.nextToken());
          }
        }

        m_fedexShuttleTypes = new Vector();
        codes = readConfigVariableString("VALID_FEDEX_SHUTTLE_TYPE_CD");

        if (codes != null)
        {
          StringTokenizer st = new StringTokenizer ( codes, "," );
          while ( st.hasMoreTokens() )
          {
            m_fedexShuttleTypes.add(st.nextToken());
          }
        }
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)  throws Exception
    {
        Shuttle shuttle = null;
        traceLog("","in doIt method");
        traceLog("VerifyShuttleData",state);

        try
        {
            String ms_shuttleCd = null;
            String ms_destLocationCd = null;
            ms_shuttleCd = (state.getScan().getShuttleID());
            ms_destLocationCd = (state.getScan().getDestLocationCode());
            shuttle = dbConnection.fetchShuttleByDestLocShuttleCd(ms_destLocationCd, ms_shuttleCd);
        }
        catch (Exception ex )
        {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                     "Failure during fetch of Shuttle data");
            throw cciiEx;
        }

        if ( shuttle == null )
        {
            state.getScan().setErrorNumber(Messages.EM_WRONG_SHUTTLE);
            state.addExceptionActivity(m_config.getValue("WRONG_SHUTTLE_ACTIVITY_CODE"));
        }
        else if ( !m_codes.contains(shuttle.getShuttleStatusCd()))
        {
            state.getScan().setErrorNumber(Messages.EM_SHUTTLE_STATUS);
        }

        boolean isFedexShuttle = m_fedexShuttleTypes.contains(shuttle.getShuttleTypeCd());
        state.getUploadStatus().setFedExShuttleFlag(isFedexShuttle);

        traceLog("VerifyShuttleData","returning..");
        return state;
    }

    public static void main(String args[]) throws Exception
    {
         try
         {
             VerifyShuttleData obj = new VerifyShuttleData();
             obj.test(args[0], args[1], args[2]);
         }
         catch (Exception e)
         {
            System.out.println(e);
            e.printStackTrace(System.out);
         }
    }

    public void test(String locationCd, String destinationCd, String shuttleCd) throws Exception
    {
        this.m_config.setLocationCode("YYZ");
        traceLog("VerifyShuttleData","In test method");
        rmtc.util.Config cfg = new rmtc.util.Config();
        cfg.setLocationCode("YYZ");
        cfg.setGroup("ALL");
        traceLog("VerifyShuttleData","Loading Oracle driver");
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        traceLog("VerifyShuttleData","Establishing a connection");
        String server = cfg.getValue("JDBC_SERVER");
        String user = cfg.getValue("JDBC_USER");
        String pass = cfg.getValue("JDBC_PASSWORD");
        traceLog("VerifyShuttleData","Server:" + server);
        traceLog("VerifyShuttleData","User:" + user);
        traceLog("VerifyShuttleData","Pass:" + pass);


        java.sql.Connection conn =
             java.sql.DriverManager.getConnection ( "jdbc:oracle:thin:@" + server, user, pass );

        traceLog("VerifyShuttleData","Creating DB Bean");

        DatabaseBean dbb = new DatabaseBean();

        traceLog("VerifyShuttleData","Setting Connection object in bean");

        dbb.connect(conn);

        dbb.setLocationCode("YYZ");
        traceLog("VerifyShuttleData","************* location code = "  + dbb.getLocationCode());

        traceLog("VerifyShuttleData","Creating State object");

        CCIIState cciiState = new CCIIState();

        traceLog("VerifyShuttleData","Setting State values");

        cciiState.getScan().setLocationCode(locationCd);
        cciiState.getScan().setDestLocationCode(destinationCd);
        cciiState.getScan().setShuttleID(shuttleCd);
        java.util.Date time = new java.util.Date();
        cciiState.getScan().setTransactionTimestamp(time);

        traceLog("VerifyShuttleData","Calling doIt");

        readSiteConfigVariables();
        cciiState = (CCIIState) doIt(cciiState, dbb);

        traceLog("VerifyShuttleData","Returned from doIt");
        System.out.println("state after execution " + cciiState);

        conn.commit();
        conn.close();

        return;
  }

}
