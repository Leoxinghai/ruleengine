/*
 * Created on Feb 14, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.DatabaseBean;
import cciij.util.CCIILogException;
import cciij.util.LocationList;
import java.io.PrintStream;
import rmtc.util.Config;

// Referenced classes of package cciij.businessActions:
//            BusinessActionBase

public class BKKDuplicateHawb extends BusinessActionBase
{

    public BKKDuplicateHawb()
        throws Exception
    {
    
        traceLog("BKKDuplicateHawb", "In Constructor");
    }

    protected void readSiteConfigVariables()
        throws Exception
    {
        super.readSiteConfigVariables();
    }

    public CCIIState doIt(CCIIState state, DatabaseBean dbConnection)
        throws Exception
    {
        HandlingUnit handlingUnit = null;
        Shipment shipment = null;
        String currentOrigin = "";
        String currentDestination = "";
        boolean allowUserResolution = false;
        traceLog("DuplicateProcessing01", state);
        try
        {
            shipment = dbConnection.fetchShipment(state.getScan().getShipmentOid());
        }
        catch(Exception ex)
        {
            state.getScan().setErrorNumber(57);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "HandlingUnit fetch failed");
            throw cciiEx;
        }
        
        return state;
    }

    private Shipment getShipment(HandlingUnit hu, DatabaseBean db, CCIIState s)
        throws Exception
    {
        Shipment ship = null;
        try
        {
            ship = db.fetchShipment(hu.getShipmentOidNumber());
        }
        catch(Exception ex)
        {
            s.getScan().setErrorNumber(57);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Shipment fetch failed");
            throw cciiEx;
        }
        if(ship == null)
        {
            s.getScan().setErrorNumber(57);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "shipment fetch by shipmentOid returned null");
            throw cciiEx;
        } else
        {
            return ship;
        }
    }

    private HandlingUnit getNextHandlingUnit(DatabaseBean db, CCIIState s)
        throws Exception
    {
        HandlingUnit hu = null;
        try
        {
            hu = db.fetchNextHandlingUnit();
        }
        catch(Exception ex)
        {
            s.getScan().setErrorNumber(57);
            CCIILogException cciiEx = new CCIILogException("BA_DB_ERROR_NUMB", "Next Handling Unit fetch failed");
            throw cciiEx;
        }
        return hu;
    }

    public static void main(String args[])
    {
        System.out.println("BKKDuplicateHawb in main");
        System.out.println("Leaving main");
    }

    private static final String m_whatVersion = "@(#) $RCSfile: BKKDuplicateHawb.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
}

