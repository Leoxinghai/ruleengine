package cciij.util.remoteuvsdk;

import java.io.IOException;

import java.rmi.Naming;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;

import java.rmi.activation.*;

//import java.rmi.server.UnicastRemoteObject;

import cciij.util.Java2uvsdk;

public class RemoteJava2uvsdkImpl extends Activatable implements RemoteJava2uvsdk
{
    private Java2uvsdk m_uvsdk;
    private String m_name;

    private boolean m_inited = false;

    private boolean m_splitsLoaded = false;

    public RemoteJava2uvsdkImpl(String name) throws RemoteException,ActivationException,IOException
    {
        super(null,new MarshalledObject(name),false,0);
        m_name = name;
        m_uvsdk = new Java2uvsdk();
        System.out.println("RemoteJava2uvsdkImpl(" + name + ") Initialization constructor called.");
    }

    public RemoteJava2uvsdkImpl(ActivationID id, MarshalledObject arg) throws RemoteException
    {
        super(id,0);
        System.out.println("RemoteJava2uvsdkImpl(ActivationID id,MarshalledObject arg)  Activating Server");

        try
        {
            Object oarg = arg.get();
            if(oarg instanceof String)
            {
                m_name = (String)oarg;
            }
            else
            {
                System.out.println("Unknown arguemtn recieved on activation of class:  " + oarg.getClass().getName() + " with value:  " + oarg);
            }

            m_uvsdk = new Java2uvsdk();
        }
        catch(Exception e)
        {
            System.out.println("Failed to retrieve argument to activation from MarshelledObject:  " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("RemoteJava2uvsdkImpl (re)Activation complete for object:  " + m_name);
    }

    protected void init() throws RemoteException
    {
        if(m_inited == false)
        {
             LoadUrsaEditFiles();
//             LoadSplitFile();
             m_inited = true;
        }
    }

    private java.util.Random m_random = new java.util.Random();

    public synchronized int LoadUrsaEditFiles() throws RemoteException
    {
        System.out.println("RemoteJava2uvsdkImpl.LoadUrsaEditFiles()");
//         if(m_random.nextInt(20) == 0)
//         {
//             System.exit(-1);
//         }
        return m_uvsdk.LoadUrsaEditFiles();
    }

    public synchronized int LoadSplitFile(String splitFileName, boolean loadCheck) throws RemoteException
    {
        int loadSuccess = 0;

        init();

        if (loadCheck || m_splitsLoaded == false)
        {
             // Force the load of Splits
             loadSuccess = m_uvsdk.LoadSplitFile(splitFileName, true);
             if (loadSuccess == 0)
             {
                 // Loaded Successfully
                 m_splitsLoaded = true;
             }
         }
         return loadSuccess;
    }

    public synchronized String GetUrsaEffectiveDate(String s_formatString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetUrsaEffectiveDate()");
        return m_uvsdk.GetUrsaEffectiveDate(s_formatString);
    }

    public synchronized String GetUrsaExpirationDate(String s_formatString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetUrsaExpirationDate()");
        return m_uvsdk.GetUrsaExpirationDate(s_formatString);
    }

    public synchronized int GetUrsaVersion() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetUrsaVersion()");
        return m_uvsdk.GetUrsaVersion();
    }

    public synchronized void UEInitialize() throws RemoteException
    {
        init();
        m_uvsdk.UEInitialize();
        System.out.println("RemoteJava2uvsdkImpl.UEInitialize()");
    }

    public synchronized void SInitialize() throws RemoteException
    {
        init();
        m_uvsdk.SInitialize();
        System.out.println("RemoteJava2uvsdkImpl.SInitialize()");
    }

    public synchronized int GetUrsaFileType() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetUrsaFileType()");
        return m_uvsdk.GetUrsaFileType();
    }

    public synchronized void UInitialize() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.UInitialize()");
        m_uvsdk.UInitialize();
    }

    public synchronized int SetTodaysDate(String DateString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetTodaysDate()");
        return m_uvsdk.SetTodaysDate(DateString);
    }

    public synchronized int SetShipDate(String DateString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetShipDate()");
        return m_uvsdk.SetShipDate(DateString);
    }

    public synchronized int SetDestCountry(String CountryString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetDestCountry()");
        return m_uvsdk.SetDestCountry(CountryString);
    }

    public synchronized boolean PostalCountry() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.PostalCountry()");
        return m_uvsdk.PostalCountry();
    }

    public synchronized int SetDestPostalCode(String PostalString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetDestPostalCode()");
        return m_uvsdk.SetDestPostalCode(PostalString);
    }

    public synchronized int SetDestStation(String StationString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetDestStation()");
        return m_uvsdk.SetDestStation(StationString);
    }

    public synchronized int SetOriginStation(String StationString) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetOriginStation()");
        return m_uvsdk.SetOriginStation(StationString);
    }

    public synchronized String CheckAirbill(String TrackNumber) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.CheckAirbill()");
        return m_uvsdk.CheckAirbill(TrackNumber);
    }

    public synchronized String GetABFormCode() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetABFormCode()");
        return m_uvsdk.GetABFormCode();
    }

    public synchronized String GetABTypeCode() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetABTypeCode()");
        return m_uvsdk.GetABTypeCode();
    }

    public synchronized String GetHandlingText(int HandCode) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetHandlingText()");
        return m_uvsdk.GetHandlingText(HandCode);
    }

    public synchronized void SetServiceCode(int serviceCode) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetServiceCode()");
        m_uvsdk.SetServiceCode(serviceCode);
    }

    public synchronized void SetHandlingCode(int handlingCode) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetHandlingCode()");
        m_uvsdk.SetHandlingCode(handlingCode);
    }

    public synchronized void SetAirbillAndFormCode(String airbillNumber, String formCode) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SetAirbillAndFormCode()");
        m_uvsdk.SetAirbillAndFormCode(airbillNumber,formCode);
    }

    public synchronized void RouteUrsa() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.RouteUrsa()");
        m_uvsdk.RouteUrsa();
    }

    public synchronized void CommitUrsa() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.CommitUrsa()");
        m_uvsdk.CommitUrsa();
    }

    public synchronized String GetServiceAreaCode() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetServiceAreaCode()");
        return m_uvsdk.GetServiceAreaCode();
    }

    public synchronized String GetDestinationAirport() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetDestinationAirport()");
        return m_uvsdk.GetDestinationAirport();
    }

    public synchronized String GetRoutingPrefix() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetRoutingPrefix()");
        return m_uvsdk.GetRoutingPrefix();
    }

    public synchronized String GetRoutingSuffix() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetRoutingSuffix()");
        return m_uvsdk.GetRoutingSuffix();
    }

    public synchronized String GetAstraBarcode() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetAstraBarcode()");
        return m_uvsdk.GetAstraBarcode();
    }

    public synchronized String GetDeliveryDayOfWeek() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetDeliveryDayOfWeek()");
        return m_uvsdk.GetDeliveryDayOfWeek();
    }

    public synchronized String GetDeliveryDate() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetDeliveryDate()");
        return m_uvsdk.GetDeliveryDate();
    }

    public synchronized String GetAstraLine1() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetAstraLine1()");
        return m_uvsdk.GetAstraLine1();
    }

    public synchronized int CommitCalculated() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.CommitCalculated()");
        return m_uvsdk.CommitCalculated();
    }

    public synchronized String GetServiceText(int ServiceCode) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetServiceText()");
        return m_uvsdk.GetServiceText(ServiceCode);
    }

    public synchronized int CreateCrc(byte[] array, int length) throws RemoteException
    {
        //        init();
        System.out.println("RemoteJava2uvsdkImpl.CreateCrc()");
        return m_uvsdk.CreateCrc(array,length);
    }

    public synchronized int SelectSplit(int i_pos, int i_split) throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SelectSplit()");
        return m_uvsdk.SelectSplit(i_pos,i_split);
    }

    public synchronized int SplitsCheck() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.SplitsCheck()");
        return m_uvsdk.SplitsCheck();
    }

    public synchronized int GetSplitsErrorNumber() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetSplitsErrorNumber()");
        return m_uvsdk.GetSplitsErrorNumber();
    }

    public synchronized String GetSplitsErrorText() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.GetSplitsErrorText()");
        return m_uvsdk.GetSplitsErrorText();
    }

    public synchronized void AstraScan() throws RemoteException
    {
        init();
        System.out.println("RemoteJava2uvsdkImpl.AstraScan()");
        m_uvsdk.AstraScan();
    }

    public static void main(String args[]) throws Exception
    {
        RemoteJava2uvsdkImpl impl = new RemoteJava2uvsdkImpl(args[0]);

        Naming.rebind(args[0],impl);

        System.out.println("RemoteJava2uvsdkImpl bound to name:  " + args[0]);
    }
}
