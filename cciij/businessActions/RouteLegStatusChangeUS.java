package cciij.businessActions;

import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

/**
 * Title:        RouteLegStatusChangeUS
 * Description:  Concrete class that extends RouteLegChangeBase.  Used for the
 *               validation and update of the route_leg_status_cd field in the Route_Leg
 *               database table for the US.
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx Services
 * @author       Joey Cline
 * @version      1.0
 *
 * Modification History:
 *  09/25/04    Joey Cline     Initial version.
 */
 
public class RouteLegStatusChangeUS extends RouteLegChangeBase
{ 
    private static final String m_whatVersion = "@(#) $RCSFile: RouteLegStatusChangeUS.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    protected boolean customsCompleteRequired = false;
    protected boolean brokerCompleteRequired = false;

/**
 * Method:       RouteLegStatusChangeUS()
 * Description:  Constructor for RouteLegStatusChangeUS.
 */
    public RouteLegStatusChangeUS() throws Exception
    {
	traceLog("RouteLegStatusChangeUS","In Constructor");
    }

/**
 * Method:       readSiteConfigVariables()
 * Description:  Used to intitialize properties
 */
    protected void readSiteConfigVariables() throws Exception
    {
	super.readSiteConfigVariables();

        customsCompleteRequired = readConfigVariableBool("SITE_CUSTOMS_COMPLETE_REQUIRED",false);
        brokerCompleteRequired = readConfigVariableBool("SITE_BROKER_COMPLETE_REQUIRED",false);
    }

/**
 * Method:       setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
 * Description:  When not null, copies RouteLegStatusCd, RouteLegBrokerFinishFlg,
 *               and RouteLegCustomsFinishFlg from changeRLeg to dbRLeg.
 * @param        dbRLeg - RouteLeg with data contents from the database.
 * @param        changeRLeg - RouteLeg with the new route leg status.
 *
 * @return       void
 */
    protected void setDbFields(RouteLeg dbRLeg, RouteLeg changeRLeg)
    {
        if (changeRLeg.getRouteLegStatusCd().equals("") != true)
        {
            dbRLeg.setRouteLegStatusCd(changeRLeg.getRouteLegStatusCd());
        }

        if (changeRLeg.getBrokerCompleteFlag().equals("") != true)
        {
            dbRLeg.setBrokerCompleteFlag(changeRLeg.getBrokerCompleteFlag());
        }

        if (changeRLeg.getCustomsCompleteFlag().equals("") != true)
        {
            dbRLeg.setCustomsCompleteFlag(changeRLeg.getCustomsCompleteFlag());
        }
    }
     
/**
 * Method:       isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
 * Description:  Validates the change of route leg status from the existing value
 *               (in the databaseRLeg) to the new route leg status (in newRLeg).
 *
 * @param        databaseRLeg - RouteLeg with data contents from the database.
 * @param        newRLeg - RouteLeg with the new route leg status.
 *
 * @return       int - 0 for valid change or an error number
 */
    protected int isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
    {    
        traceLog("RouteLegStatusChangeUS","newRLeg.getBrokerCompleteFlag() = " + newRLeg.getBrokerCompleteFlag() );
        traceLog("RouteLegStatusChangeUS","databaseRLeg.getBrokerCompleteFlag() = " + databaseRLeg.getBrokerCompleteFlag() );
        if (   newRLeg.getBrokerCompleteFlag().equals("") != true
            && newRLeg.getBrokerCompleteFlag().equals(databaseRLeg.getBrokerCompleteFlag()) != true)
        {
            if (databaseRLeg.getBrokerCompleteFlag().equals("N") == true)
            {
                if (newRLeg.getBrokerCompleteFlag().equals("Y") != true)
                {
                    return Messages.EM_INV_BRKR_FIN_CHG;
                }
            }
            else
            {
                if (databaseRLeg.getBrokerCompleteFlag().equals("Y") == true)
                {
                    if (newRLeg.getBrokerCompleteFlag().equals("N") != true)
                    {
                        return Messages.EM_INV_BRKR_FIN_CHG;
                    }
                }
            }
        }
        
        traceLog("RouteLegStatusChangeUS","newRLeg.getCustomsCompleteFlag() = " + newRLeg.getCustomsCompleteFlag() );
        traceLog("RouteLegStatusChangeUS","databaseRLeg.getCustomsCompleteFlag() = " + databaseRLeg.getCustomsCompleteFlag() );
        if (   newRLeg.getCustomsCompleteFlag().equals("") != true
            && newRLeg.getCustomsCompleteFlag().equals(databaseRLeg.getCustomsCompleteFlag()) != true)
        {
            if (databaseRLeg.getCustomsCompleteFlag().equals("N") == true)
            {
                if (newRLeg.getCustomsCompleteFlag().equals("Y") != true)
                {
                    return Messages.EM_INV_CSTM_FIN_CHG;
                }
            }
            else
            {
                if (databaseRLeg.getCustomsCompleteFlag().equals("Y") == true)
                {
                    if (newRLeg.getCustomsCompleteFlag().equals("N") != true)
                    {
                        return Messages.EM_INV_CSTM_FIN_CHG;
                    }
                }
            }
        }
        
	traceLog("RouteLegStatusChangeUS","databaseRLeg.getRouteLegStatusCd() = " + databaseRLeg.getRouteLegStatusCd() );
        if (   newRLeg.getRouteLegStatusCd().equals("") != true
            && newRLeg.getRouteLegStatusCd().equals(databaseRLeg.getRouteLegStatusCd()) != true)
        {
            traceLog("RouteLegStatusChangeUS","newRLeg.getRouteLegStatusCd() = " +   newRLeg.getRouteLegStatusCd() );
	    // check for when existing route leg status is New
            if (databaseRLeg.getRouteLegStatusCd().equals("N") == true)
            {
                if ( newRLeg.getRouteLegStatusCd().equals("C") == true )
                {   // can't change from New to Complete
                    return Messages.EM_INV_RTE_STAT_CHG;
                }

                // Can't close route if broker or customs is required to complete the
                // route before closure and they haven't.
                // if new route status value is anything but New
        	traceLog("RouteLegStatusChangeUS","brokerCompleteRequired = " + brokerCompleteRequired );
        	traceLog("RouteLegStatusChangeUS","customsCompleteRequired = " + customsCompleteRequired );
                if ( newRLeg.getRouteLegStatusCd().equals("N") != true )
		{
                    if (  ( brokerCompleteRequired 
                            // and the new broker complete flag is not complete
                            && newRLeg.getBrokerCompleteFlag().equals("N") )
                        // or customs complete is required    
                       || ( customsCompleteRequired 
                            // and the new customs complete flag is not complete
                            && newRLeg.getCustomsCompleteFlag().equals("N") ) )
                    {
                        return Messages.EM_INV_RTE_STAT_CHG;
                    }
                }
            }
            else if (databaseRLeg.getRouteLegStatusCd().equals("Y") == true)
            {
                if (   (newRLeg.getRouteLegStatusCd().equals("N") != true)
                    && (newRLeg.getRouteLegStatusCd().equals("D") != true)
                    && (newRLeg.getRouteLegStatusCd().equals("C") != true))
                {
                    return Messages.EM_INV_RTE_STAT_CHG;
                }
            }
            else if (databaseRLeg.getRouteLegStatusCd().equals("D") == true)
            {
                if (newRLeg.getRouteLegStatusCd().equals("N") != true)
                {
                    return Messages.EM_INV_RTE_STAT_CHG;
                }
            }
        }
        
        return Messages.EM_NO_ERROR;
    }
    
/**
 * Method:       addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
 * Description:  Adds an Activity, appropriate to the route leg status change, to the
 *               activity vector in state.
 *
 * @param        state - CCIIState for the existing 'scan'.
 * @param        dbRLeg - RouteLeg with data contents from the database.
 *
 * @return       void
 */
    protected void addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
    {
        if ( ( state.getRouteLegInfo().getRouteLegStatusCd().equals("") != true )
          && ( dbRLeg.getRouteLegStatusCd().equals("") != true ) )
        {
	    traceLog("RouteLegStatusChangeUS", "dbRLeg.getRouteLegStatusCd() = " + dbRLeg.getRouteLegStatusCd() );
	    traceLog("RouteLegStatusChangeUS", "state.getRouteLegInfo().getRouteLegStatusCd() = " + state.getRouteLegInfo().getRouteLegStatusCd() );
            String actCode = m_config.getValue("ROUTE_STATUS_" +
		    dbRLeg.getRouteLegStatusCd() + "_TO_" +
		    state.getRouteLegInfo().getRouteLegStatusCd() );
	    traceLog("RouteLegStatusChangeUS", "actCode = " + actCode );
            if ( actCode != null )
	    {
                state.addActivity ( actCode );
	    }
        }
        
        if (state.getRouteLegInfo().getBrokerCompleteFlag().equals("") != true)
        {
            if (   (dbRLeg.getBrokerCompleteFlag().equals("N") == true)
                && (state.getRouteLegInfo().getBrokerCompleteFlag().equals("Y") == true))
            {
                state.addActivity(m_config.getValue("ROUTE_EDIT_BROKER_COMPLETE_ACTIVITY_CODE"));
            }
            else
            {
                if (   (dbRLeg.getBrokerCompleteFlag().equals("Y") == true)
                    && (state.getRouteLegInfo().getBrokerCompleteFlag().equals("N") == true))
                {
                    state.addActivity(m_config.getValue("ROUTE_EDIT_BROKER_NOT_COMPLETE_ACTIVITY_CODE"));
                }
            }
        }
        
        if (state.getRouteLegInfo().getCustomsCompleteFlag().equals("") != true)
        {
            if (   (dbRLeg.getCustomsCompleteFlag().equals("N") == true)
                && (state.getRouteLegInfo().getCustomsCompleteFlag().equals("Y") == true))
            {
                state.addActivity(m_config.getValue("ROUTE_EDIT_CUSTOMS_COMPLETE_ACTIVITY_CODE"));
            }
            else
            {
                if (   (dbRLeg.getCustomsCompleteFlag().equals("Y") == true)
                    && (state.getRouteLegInfo().getCustomsCompleteFlag().equals("N") == true))
                {
                    state.addActivity(m_config.getValue("ROUTE_EDIT_CUSTOMS_NOT_COMPLETE_ACTIVITY_CODE"));
                }
            }
        }
    }

/**
 * Method:       main(String arg[])
 * Description:  Main method used only for testing of businessAction.
 *
 * @param        arg - list of input arguments.  None required.
 *
 * @return       void
 */
    public static void main(String arg[])
    {
        System.out.println("RouteLegStatusChangeUS in main");
        try
        {
            RouteLegStatusChangeUS obj = new RouteLegStatusChangeUS();
            obj.m_config.setLocationCode("YYZ");
            obj.test();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Leaving RouteLegStatusChangeUS main");       
    }
    
/**
 * Method:       test()
 * Description:  Test method used only for testing of businessAction.
 *
 * @return       void
 */
    public void test()
    {        
        System.out.println("RouteLegStatusChangeUS in test");

        GregorianCalendar now = new GregorianCalendar();
        Date dateTime = now.getTime();
        
        now.set(Calendar.HOUR_OF_DAY,0);
        now.set(Calendar.MINUTE,0);
        now.set(Calendar.SECOND,0);
        Date date = now.getTime();
        
        DatabaseBean db = new DatabaseBean();
        db.connect();
        
        RouteLeg dbRLeg = new RouteLeg("TK123", date, 10, "023", "DESTN", "ORIGN",
                                       dateTime, dateTime, dateTime, dateTime, "DC",
                                       "OC", date, "N", "N", "N", -111);
        
        RouteLeg chgRLeg = new RouteLeg("TK123", date, 10, "023", "DESTN", "ORIGN",
                                       dateTime, dateTime, dateTime, dateTime, "DC",
                                       "OC", date, null, null, null, -111);
                                     
        CCIIState state = new CCIIState();
        state.setRouteLegInfo(chgRLeg);


        // write a RouteLeg
        try
        {
            System.out.println("Inserting RouteLeg, with OID -111, for testing");
            db.saveRouteLeg(dbRLeg);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }

        
        // change from N to X; expect error
        System.out.println("Beginning Test1: N to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("X");
        state.setRouteLegInfo(chgRLeg);
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_RTE_STAT_CHG)
        {
            System.out.println("Test1 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test1 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        
                
        // change from N to D; expect success; change back to N
        System.out.println("Beginning Test2: N to D");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("D");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test2 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test2 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
                
        System.out.println("Reset test RouteLegStatusCd: D to N");
        chgRLeg.setRouteLegStatusCd("N");
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Activity list = " + state.m_activityCodes.toString());
        
        
        // change from N to Y; expect success
        System.out.println("Beginning Test3: N to Y");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("Y");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test3 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test3 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to X; expect error
        System.out.println("Beginning Test4: Y to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("X");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_RTE_STAT_CHG)
        {
            System.out.println("Test4 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test4 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to N; expect success; change back to Y
        System.out.println("Beginning Test5: Y to N");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("N");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test5 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test5 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
                
        System.out.println("Reset test RouteLegStatusCd: N to Y");
        chgRLeg.setRouteLegStatusCd("Y");
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Activity list = " + state.m_activityCodes.toString());

        
        // change from Y to D; expect success
        System.out.println("Beginning Test6: Y to D");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("D");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test6 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test6 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from D to X; expect error
        System.out.println("Beginning Test7: D to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("X");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_RTE_STAT_CHG)
        {
            System.out.println("Test7 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test7 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from D to N; expect success
        System.out.println("Beginning Test8: D to N");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("N");
        state.setRouteLegInfo(chgRLeg);      
          
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test8 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test8 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        chgRLeg.setRouteLegStatusCd(null);

        
        // change from N to X; expect error
        System.out.println("Beginning Test9: BrokerCompleteFlag N to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setBrokerCompleteFlag("X");
        state.setRouteLegInfo(chgRLeg);
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_BRKR_FIN_CHG)
        {
            System.out.println("Test9 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test9 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        
        
        // change from N to Y; expect success
        System.out.println("Beginning Test10: BrokerCompleteFlag N to Y");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setBrokerCompleteFlag("Y");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test10 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test10 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to X; expect error
        System.out.println("Beginning Test11: BrokerCompleteFlag Y to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setBrokerCompleteFlag("X");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_BRKR_FIN_CHG)
        {
            System.out.println("Test11 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test11 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to N; expect success; change back to Y
        System.out.println("Beginning Test12: BrokerCompleteFlag Y to N");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setBrokerCompleteFlag("N");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test12 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test12 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        chgRLeg.setBrokerCompleteFlag(null);

        
        // change from N to X; expect error
        System.out.println("Beginning Test13: CustomsCompleteFlag N to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setCustomsCompleteFlag("X");
        state.setRouteLegInfo(chgRLeg);
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_CSTM_FIN_CHG)
        {
            System.out.println("Test13 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test13 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
        
        
        // change from N to Y; expect success
        System.out.println("Beginning Test14: CustomsCompleteFlag N to Y");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setCustomsCompleteFlag("Y");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test14 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test14 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to X; expect error
        System.out.println("Beginning Test15: CustomsCompleteFlag Y to X - INVALID CHANGE");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setCustomsCompleteFlag("X");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_INV_CSTM_FIN_CHG)
        {
            System.out.println("Test15 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test15 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from Y to N; expect success; change back to Y
        System.out.println("Beginning Test16: CustomsCompleteFlag Y to N");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setCustomsCompleteFlag("N");
        state.setRouteLegInfo(chgRLeg);      
        
        try
        {
            state = this.doIt(state, db);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        if (state.getScan().getErrorNumber() == Messages.EM_NO_ERROR)
        {
            System.out.println("Test16 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test16 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // delete test RouteLeg
        try
        {
            System.out.println("Deleting RouteLeg, with OID -111");
            db.removeRouteLeg(dbRLeg);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        System.out.println("Leaving RouteLegStatusChangeUS test");
    }
}    
