package cciij.businessActions;

/**
 * Title:        RouteLegStatusChangeAPAC
 * Description:  Concrete class that extends RouteLegStatusChangeBase.  Used for the
 *               validation and update of the route_leg_status_cd field in the Route_Leg
 *               database table for APAC.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author       Tom Knobeloch
 * @version      1.0
 *
 * Modification History:
 *  04/10/02    Tom Knobeloch  Initial version.
 *  06/11/03    Tom Knobeloch  Changed attribute RouteLegStatusChange to RouteLegInfo
 *  08/21/03    Joey Cline     Renamed method isValidRouteLegChange (from isValidRouteStatusChange)
 *                             Changed to inherit from RouteLegChangeBase.                          
 */
 
import cciij.cciidatabase.*;
import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;

public class RouteLegStatusChangeAPAC extends RouteLegChangeBase
{ 
    private static final String m_whatVersion = "@(#) $RCSFile: RouteLegStatusChangeAPAC.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    
/**
 * Method:       RouteLegStatusChangeAPAC()
 * Description:  Constructor for RouteLegStatusChangeAPAC.
 * @author       Tom Knobeloch
 *
 */
    public RouteLegStatusChangeAPAC() throws Exception
    {
    }
     
/**
 * Method:       isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
 * Description:  Validates the change of route leg status from the existing value
 *               (in the databaseRLeg) to the new route leg status (in newRLeg).
 * @author       Tom Knobeloch
 *
 * @param        databaseRLeg - RouteLeg with data contents from the database.
 * @param        newRLeg - RouteLeg with the new route leg status.
 *
 * @return       int - 0 for valid change or an error number
 */
    protected int isValidRouteLegChange(RouteLeg databaseRLeg, RouteLeg newRLeg)
    {
        if (databaseRLeg.getRouteLegStatusCd().equals("N") == true)
        {
            if (   (newRLeg.getRouteLegStatusCd().equals("D") == true)
                || (newRLeg.getRouteLegStatusCd().equals("Y") == true))
            {
                return Messages.EM_NO_ERROR;
            }
            else
            {
                return Messages.EM_INV_RTE_STAT_CHG;
            }
        }
        else
        {
            if (databaseRLeg.getRouteLegStatusCd().equals("Y") == true)
            {
                if (   (newRLeg.getRouteLegStatusCd().equals("N") == true)
                    || (newRLeg.getRouteLegStatusCd().equals("C") == true))
                {
                    return Messages.EM_NO_ERROR;
                }
                else
                {
                    return Messages.EM_INV_RTE_STAT_CHG;
                }
            }
            else
            {
                if (databaseRLeg.getRouteLegStatusCd().equals("C") == true)
                {
                    if (   (newRLeg.getRouteLegStatusCd().equals("Y") == true)
                        || (newRLeg.getRouteLegStatusCd().equals("S") == true))
                    {
                        return Messages.EM_NO_ERROR;
                    }
                    else
                    {
                        return Messages.EM_INV_RTE_STAT_CHG;
                    }
                }
                else
                {
                    if (databaseRLeg.getRouteLegStatusCd().equals("S") == true)
                    {
                        if (   (newRLeg.getRouteLegStatusCd().equals("C") == true)
                            || (newRLeg.getRouteLegStatusCd().equals("D") == true))
                        {
                            return Messages.EM_NO_ERROR;
                        }
                        else
                        {
                            return Messages.EM_INV_RTE_STAT_CHG;
                        }
                        }
                    else
                    {
                        if (databaseRLeg.getRouteLegStatusCd().equals("D") == true)
                        {
                            if (   (newRLeg.getRouteLegStatusCd().equals("S") == true)
                                || (newRLeg.getRouteLegStatusCd().equals("N") == true))
                            {
                                return Messages.EM_NO_ERROR;
                            }
                            else
                            {
                                return Messages.EM_INV_RTE_STAT_CHG;
                            }
                        }
                        else
                        {
                            return Messages.EM_INV_RTE_STAT_CHG;
                        }
                    }
                }
            }
        }
    }
    
/**
 * Method:       addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
 * Description:  Adds an Activity, appropriate to the route leg status change, to the
 *               activity vector in state.
 * @author       Tom Knobeloch
 *
 * @param        state - CCIIState for the existing 'scan'.
 * @param        dbRLeg - RouteLeg with data contents from the database.
 *
 * @return       void
 */
    protected void addClearanceActivity(CCIIState state, RouteLeg dbRLeg)
    {
        if (   (dbRLeg.getRouteLegStatusCd().equals("N") == true)
            && (state.getRouteLegInfo().getRouteLegStatusCd().equals("D") == true))
        {
            state.addActivity(m_config.getValue("ROUTE_STATUS_N_TO_D"));
        }
        else
        {
            if (   (dbRLeg.getRouteLegStatusCd().equals("N") == true)
                && (state.getRouteLegInfo().getRouteLegStatusCd().equals("Y") == true))
            {
                state.addActivity(m_config.getValue("ROUTE_STATUS_N_TO_Y"));
            }
            else
            {
                if (   (dbRLeg.getRouteLegStatusCd().equals("Y") == true)
                    && (state.getRouteLegInfo().getRouteLegStatusCd().equals("N") == true))
                {
                    state.addActivity(m_config.getValue("ROUTE_STATUS_Y_TO_N"));
                }
                else
                {
                    if (   (dbRLeg.getRouteLegStatusCd().equals("Y") == true)
                        && (state.getRouteLegInfo().getRouteLegStatusCd().equals("C") == true))
                    {
                        state.addActivity(m_config.getValue("ROUTE_STATUS_Y_TO_C"));
                    }
                    else
                    {
                        if (   (dbRLeg.getRouteLegStatusCd().equals("C") == true)
                            && (state.getRouteLegInfo().getRouteLegStatusCd().equals("Y") == true))
                        {
                            state.addActivity(m_config.getValue("ROUTE_STATUS_C_TO_Y"));
                        }
                        else
                        {
                            if (   (dbRLeg.getRouteLegStatusCd().equals("C") == true)
                                && (state.getRouteLegInfo().getRouteLegStatusCd().equals("S") == true))
                            {
                                state.addActivity(m_config.getValue("ROUTE_STATUS_C_TO_S"));
                            }
                            else
                            {
                                if (   (dbRLeg.getRouteLegStatusCd().equals("S") == true)
                                    && (state.getRouteLegInfo().getRouteLegStatusCd().equals("C") == true))
                                {
                                    state.addActivity(m_config.getValue("ROUTE_STATUS_S_TO_C"));
                                }
                                else
                                {
                                    if (   (dbRLeg.getRouteLegStatusCd().equals("S") == true)
                                        && (state.getRouteLegInfo().getRouteLegStatusCd().equals("D") == true))
                                    {
                                        state.addActivity(m_config.getValue("ROUTE_STATUS_S_TO_D"));
                                    }
                                    else
                                    {
                                        if (   (dbRLeg.getRouteLegStatusCd().equals("D") == true)
                                            && (state.getRouteLegInfo().getRouteLegStatusCd().equals("S") == true))
                                        {
                                            state.addActivity(m_config.getValue("ROUTE_STATUS_D_TO_S"));
                                        }
                                        else
                                        {
                                            if (   (dbRLeg.getRouteLegStatusCd().equals("D") == true)
                                                && (state.getRouteLegInfo().getRouteLegStatusCd().equals("N") == true))
                                            {
                                                state.addActivity(m_config.getValue("ROUTE_STATUS_D_TO_N"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

/**
 * Method:       main(String arg[])
 * Description:  Main method used only for testing of businessAction.
 * @author       Tom Knobeloch
 *
 * @param        arg - list of input arguments.  None required.
 *
 * @return       void
 */
    public static void main(String arg[])
    {
        System.out.println("RouteLegStatusChangeAPAC in main");
        try
        {
            RouteLegStatusChangeAPAC obj = new RouteLegStatusChangeAPAC();
            obj.m_config.setLocationCode("NRT");
            obj.test();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Leaving RouteLegStatusChangeAPAC main");       
    }
    
/**
 * Method:       test()
 * Description:  Test method used only for testing of businessAction.
 * @author       Tom Knobeloch
 *
 * @return       void
 */
    public void test()
    {        
        System.out.println("RouteLegStatusChangeAPAC in test");

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
                                       "OC", date, "N", "N", "N", -111);
                                     
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

        
        // change from Y to C; expect success
        System.out.println("Beginning Test6: Y to C");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("C");
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

                
        // change from C to X; expect error
        System.out.println("Beginning Test7: C to X - INVALID CHANGE");
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

                
        // change from C to Y; expect success; change back to C
        System.out.println("Beginning Test8: C to Y");
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
            System.out.println("Test8 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test8 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

        System.out.println("Reset test RouteLegStatusCd: Y to C");              
        chgRLeg.setRouteLegStatusCd("C");
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

        
        // change from C to S; expect success
        System.out.println("Beginning Test9: C to S");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("S");
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
            System.out.println("Test9 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test9 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from S to X; expect error
        System.out.println("Beginning Test10: S to X - INVALID CHANGE");
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
            System.out.println("Test10 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test10 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from S to C; expect success; change back to S
        System.out.println("Beginning Test11: S to C");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("C");
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
            System.out.println("Test11 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test11 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }
                
        System.out.println("Reset test RouteLegStatusCd: C to S");
        chgRLeg.setRouteLegStatusCd("S");
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

        
        // change from S to D; expect success
        System.out.println("Beginning Test12: S to D");
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
            System.out.println("Test12 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test12 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from D to X; expect error
        System.out.println("Beginning Test13: D to X - INVALID CHANGE");
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
            System.out.println("Test13 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test13 failed: ErrorNumber = " + state.getScan().getErrorNumber());
        }

                
        // change from D to S; expect success; change back to D
        System.out.println("Beginning Test14: D to S");
        state.getScan().setErrorNumber(Messages.EM_NO_ERROR);
        chgRLeg.setRouteLegStatusCd("S");
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
                
        System.out.println("Reset test RouteLegStatusCd: S to D");
        chgRLeg.setRouteLegStatusCd("D");
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

                
        // change from D to N; expect success
        System.out.println("Beginning Test15: D to N");
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
            System.out.println("Test15 passed");
            System.out.println("Activity list = " + state.m_activityCodes.toString());
        }
        else
        {
            System.out.println("Test15 failed: ErrorNumber = " + state.getScan().getErrorNumber());
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
        
        System.out.println("Leaving RouteLegStatusChangeAPAC test");
    }
}    
