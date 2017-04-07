package cciij.businessActions;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.Date;
import java.sql.Timestamp;

public abstract class PostShipmentBase extends BusinessActionBase {

    protected boolean m_updateShipment;
    protected boolean m_updateShipmentCoreClearance;

    public PostShipmentBase() throws Exception
    {
        this("PostShipmentBase");
    }

    protected void readSiteConfigVariables() throws Exception
    {
      super.readSiteConfigVariables();
      //no local variables to read in
    }

    public PostShipmentBase(String childName) throws Exception {
        super(childName);
        traceLog("PostShipmentBase","In Constructor");
    }

    public abstract CCIIState modifyShipmentData(Shipment ship,CCIIState state) throws Exception;

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection) throws Exception {
        Shipment ship;
        boolean l_changed=false;

        traceLog("PostShipmentBase","Beginning doIt()");

        m_updateShipment = false;
        m_updateShipmentCoreClearance = false;

        try {
            ship = dbConnection.fetchShipment(state.getScan().getShipmentOid());
        }
        catch (Exception ex) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failure during fetch of Shipment");
            throw cciiEx;
        }

        if ( ship == null ) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_FETCH_ERROR_NUMB",
                                                           "Shipment fetch by Oid failed, shipOid == "
                                                           + state.getScan().getShipmentOid());
            throw cciiEx;
        }

        state = modifyShipmentData(ship,state);

        try {
            if(m_updateShipment)
            {
                traceLog("PostShipmentBase","Updating Shipment");
                dbConnection.updateShipment(ship);
            }
            else if(m_updateShipmentCoreClearance)
            {
                traceLog("PostShipmentBase",
		         "Updating ShipmentCoreClearance");
                dbConnection.updateShipmentCoreClearance(ship);
            }
        }
        catch (Exception ex ) {
            state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB",
                                                           "Failure during update of Shipment " + ex);
            throw cciiEx;
        }

        traceLog("PostShipmentBase","returning ...");
        return state;
    }
  /**
   *PostShipmentBase
   * @param Timestamp transactionTmstp
   * @param String dbTransactionTimestamp
   */
    protected boolean isNewTransaction(Date transactionTimestamp, 
                                       Timestamp dbTimestamp) throws Exception
    {
        if ( dbTimestamp == null ) // if the db timestamp is empty, assume it is new
        {
	    return true;
        }
        if (transactionTimestamp.after(dbTimestamp))
	{
	    return true;
        }
	else
	{
	    return false;
        }
    }
}
