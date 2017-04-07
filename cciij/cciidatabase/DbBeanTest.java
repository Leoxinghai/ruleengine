// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbBeanTest.java

package cciij.cciidatabase;

import cciij.cciidata.*;
import java.io.PrintStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DatabaseBean

public class DbBeanTest
{

    public DbBeanTest()
    {
        dbBean = null;
        System.out.println("in constructor");
        dbBean = new DatabaseBean();
        dbBean.connect();
    }

    public static void main(String args[])
        throws SQLException
    {
        DbBeanTest dbBeanTest = new DbBeanTest();
        dbBeanTest.fetchScanDef();
        dbBeanTest.fetchIntercept();
    }

    public void saveShipment()
    {
        Date today = new Date();
        Timestamp currentTime = new Timestamp(0L);
        Shipment saveShip = new Shipment(0x1cc7fc, "9858585", today, 5, 1, false, false, 25D, 6D, "Y", "DE", "US", "B", "809", "DE", "WIN", "62", "US", "CD", "REN", "YY", "YY", "40", "K", "K", "NK", "a", "N", currentTime);
        try
        {
            dbBean.saveShipment(saveShip);
            System.out.println("Shipment saved");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in saving Shipment " + ex);
        }
    }

    public void fetchSiteParamWithLocGroupNms()
    {
        try
        {
            SiteParam sp = dbBean.fetchSiteParam("OR", "N");
            if(sp != null)
                System.out.println("Site Param fetched = " + sp.toString());
            else
                System.out.println("No values for SiteParam retrieved");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR fetch SiteParm with Loc & Group failed");
        }
    }

    public void fetchShipment()
    {
        try
        {
            Shipment s = dbBean.fetchShipment(0x1cc7fc);
            if(s != null)
                System.out.println(s.toString());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in fetching shipment: " + ex);
        }
    }

    public void fetchScanDef()
    {
        try
        {
            ScanDefinition sd = dbBean.fetchScanDefinition();
            if(sd != null)
                System.out.println(sd.toString());
        }
        catch(Exception ex)
        {
            System.out.println("ERROR in fetchScanDef: " + ex);
        }
    }

    public void fetchIntercept()
    {
        try
        {
            Intercept i = dbBean.fetchInterceptByShipmentOrPieceOid(12345, 0x1093a);
            if(i != null)
                System.out.println(i.toString());
            else
                System.out.println("no intercepts found in test");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR in fetchIntercept: " + ex);
        }
    }

    public void fetchAllActiveAgency()
    {
        try
        {
            for(Agency a = dbBean.fetchAgencyAllActive(); a != null; a = dbBean.fetchNextAgency())
                System.out.println(a.toString());

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in dbTest fetchAllActiveAgency: " + ex);
        }
    }

    public void fetchAllActiveInterceptsByShipmentOrPieceOid()
    {
        try
        {
            for(Intercept i = dbBean.fetchIntercept(12345, 55555); i != null; i = dbBean.fetchNextIntercept())
                System.out.println(i.toString());

            System.out.println("no more to fetch");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR in dbTest fetchAllActiveInterceptsByShipmentOrPieceOd: " + ex);
        }
    }

    public void fetchHUPickList()
    {
        try
        {
            for(HandlingUnit hu = dbBean.fetchHandlingUnitPickList("lstr", "WHD"); hu != null; hu = dbBean.fetchNextHandlingUnit())
                System.out.println(hu.toString());

        }
        catch(Exception ex)
        {
            System.out.println("ERROR in dbTest fetchHUPickList: " + ex);
        }
    }

    public void fetchAllActiveInterceptDef()
    {
        try
        {
            for(InterceptCodeDefinition icd = dbBean.fetchInterceptCodeDefAllActive(); icd != null; icd = dbBean.fetchNextInterceptCodeDef())
                System.out.println(icd.toString());

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in dbTest fetchAllActiveIntereceptDef: " + ex);
        }
    }

    public void fetchAllActiveStagingArea()
    {
        try
        {
            for(StagingArea sa = dbBean.fetchStagingAreaAllActive(); sa != null; sa = dbBean.fetchNextStagingArea())
                System.out.println(sa.toString());

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in dbTest fetchAllActiveStagingArea: " + ex);
        }
    }

    public void saveHU()
    {
        HandlingUnit hu = new HandlingUnit(0x6c81e, "KK", "MY", 1, "test", 4F, "for", 30D, "b", "n", "b", "kk", "Y");
        try
        {
            dbBean.saveHandlingUnit(hu);
            System.out.println("Saved HU");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in saving hu: " + ex);
        }
    }

    public void fetchHU()
    {
        try
        {
            HandlingUnit hu = dbBean.fetchHandlingUnit("40055555533");
            if(hu != null)
                System.out.println(hu.toString());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR in fetching hu: " + ex);
        }
    }

    public void testInterceptSQL()
    {
        try
        {
            Intercept intcpt = dbBean.fetchInterceptWithActiveFlag(0x9177e);
            if(intcpt != null)
                System.out.println("Intercept vals: " + intcpt.toString());
            do
            {
                if(dbBean.getInterceptRecordCount() == 0)
                    break;
                intcpt = dbBean.fetchNextIntercept();
                if(intcpt != null)
                    System.out.println("Intercept vals: " + intcpt.toString());
            } while(true);
        }
        catch(Exception ex)
        {
            System.out.println("ERROR in testing Intercept SQL: " + ex);
        }
    }

    public void fetchAgency()
    {
        try
        {
            Agency agcy = dbBean.fetchAgency();
            if(agcy != null)
                System.out.println("Agency vasl: " + agcy.toString());
        }
        catch(Exception ex)
        {
            System.out.println("ERROR fetching Agency: " + ex);
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbBeanTest.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    public DatabaseBean dbBean;
}
