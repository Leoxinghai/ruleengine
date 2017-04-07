package cciij.util.remoteuvsdk;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmtc.util.Config;

import cciij.util.*;

public class RemoteJava2uvsdkClient implements Java2uvsdkInterface
{

    private RemoteJava2uvsdk m_serverReference=null;

    protected RemoteJava2uvsdkException processException(String method,Throwable t) throws RemoteJava2uvsdkException
    {
        m_serverReference = null;
        return new RemoteJava2uvsdkException(method,t);
    }

    protected RemoteJava2uvsdk getServerReference() throws RemoteJava2uvsdkException
    {
        if(m_serverReference == null)
        {
            try
            {
                Registry registry = getRegistry();
                RemoteJava2uvsdkFactory factory = (RemoteJava2uvsdkFactory) registry.lookup("RemoteJava2uvsdkFactory");
                System.out.println("Got the Factory");
                m_serverReference = factory.getRemoteJava2uvsdk(this.toString());
            }
            catch(Exception e)
            {
                throw processException("getServerReference",e);
            }
        }

        return m_serverReference;
    }

    public Registry getRegistry() throws RemoteException
    {
        Config config = new Config("RemoteJava2uvsdkFactory");
        int port = 1099;
        try
        {
            String portStr = config.getString("RMI_REGISTRY_PORT","1099");
            if(portStr != null)
            {
                port = Integer.parseInt(portStr);
            }
        }
        catch(Exception e)
        {
            // use default port of 1099
        }
        Registry registry = LocateRegistry.getRegistry(port);
        return registry;
    }


    public int LoadUrsaEditFiles() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().LoadUrsaEditFiles();
        }
        catch(RemoteException re)
        {
            throw processException("LoadUrsaEditFiles",re);
        }
    }

    public int LoadSplitFile(String splitFileName, boolean loadCheck) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().LoadSplitFile(splitFileName, loadCheck);
        }
        catch(RemoteException re)
        {
            throw processException("LoadSplitFile",re);
        }
    }

    public String GetUrsaEffectiveDate(String s_formatString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetUrsaEffectiveDate(s_formatString);
        }
        catch(RemoteException re)
        {
            throw processException("GetUrsaEffectiveDate",re);
        }
    }

    public String GetUrsaExpirationDate(String s_formatString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetUrsaExpirationDate(s_formatString);
        }
        catch(RemoteException re)
        {
            throw processException("GetUrsaExpirationDate",re);
        }
    }

    public int GetUrsaVersion() throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetUrsaVersion();
        }
        catch(RemoteException re)
        {
            throw processException("GetUrsaVersion",re);
        }
    }

    public void UEInitialize() throws  RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().UEInitialize();
        }
        catch(RemoteException re)
        {
            throw processException("UEInitialize",re);
        }
    }

    public void SInitialize() throws  RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().SInitialize();
        }
        catch(RemoteException re)
        {
            throw processException("SInitialize",re);
        }
    }
    public int GetUrsaFileType() throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetUrsaFileType();
        }
        catch(RemoteException re)
        {
            throw processException("GetUrsaFileType",re);
        }
    }

    public void UInitialize() throws  RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().UInitialize();
        }
        catch(RemoteException re)
        {
            throw processException("UInitialize",re);
        }
    }

    public int SetTodaysDate(String DateString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetTodaysDate(DateString);
        }
        catch(RemoteException re)
        {
            throw processException("SetTodaysDate",re);
        }
    }

    public int SetShipDate(String DateString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetShipDate(DateString);
        }
        catch(RemoteException re)
        {
            throw processException("SetShipDate",re);
        }
    }

    public int SetDestCountry(String CountryString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetDestCountry(CountryString);
        }
        catch(RemoteException re)
        {
            throw processException("SetDestCountry",re);
        }
    }

    public boolean PostalCountry() throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().PostalCountry();
        }
        catch(RemoteException re)
        {
            throw processException("PostalCountry",re);
        }
    }

    public int SetDestPostalCode(String PostalString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetDestPostalCode(PostalString);
        }
        catch(RemoteException re)
        {
            throw processException("SetDestPostalCode",re);
        }
    }

    public int SetDestStation(String StationString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetDestStation(StationString);
        }
        catch(RemoteException re)
        {
            throw processException("SetDestStation",re);
        }
    }

    public int SetOriginStation(String StationString) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SetOriginStation(StationString);
        }
        catch(RemoteException re)
        {
            throw processException("SetOriginStation",re);
        }
    }

    public String CheckAirbill(String TrackNumber) throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().CheckAirbill(TrackNumber);
        }
        catch(RemoteException re)
        {
            throw processException("CheckAirbill",re);
        }
    }

    public String GetABFormCode() throws  RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetABFormCode();
        }
        catch(RemoteException re)
        {
            throw processException("GetABFormCode",re);
        }
    }

    public String GetABTypeCode() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetABTypeCode();
        }
        catch(RemoteException re)
        {
            throw processException("GetABTypeCode",re);
        }
    }

    public String GetHandlingText(int HandCode) throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetHandlingText(HandCode);
        }
        catch(RemoteException re)
        {
            throw processException("GetHandlingText",re);
        }
    }

    public void SetServiceCode(int serviceCode) throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().SetServiceCode(serviceCode);
        }
        catch(RemoteException re)
        {
            throw processException("SetServiceCode",re);
        }
    }

    public void SetHandlingCode(int handlingCode) throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().SetHandlingCode(handlingCode);
        }
        catch(RemoteException re)
        {
            throw processException("SetHandlingCode",re);
        }
    }

    public void SetAirbillAndFormCode(String airbillNumber, String formCode) throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().SetAirbillAndFormCode(airbillNumber,formCode);
        }
        catch(RemoteException re)
        {
            throw processException("SetAirbillAndFormCode",re);
        }
    }

    public void RouteUrsa() throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().RouteUrsa();
        }
        catch(RemoteException re)
        {
            throw processException("RouteUrsa",re);
        }
    }

    public void CommitUrsa() throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().CommitUrsa();
        }
        catch(RemoteException re)
        {
            throw processException("CommitUrsa",re);
        }
    }

    public String GetServiceAreaCode() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetServiceAreaCode();
        }
        catch(RemoteException re)
        {
            throw processException("GetServiceAreaCode",re);
        }
    }

    public String GetDestinationAirport() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetDestinationAirport();
        }
        catch(RemoteException re)
        {
            throw processException("GetDestinationAirport",re);
        }
    }

    public String GetRoutingPrefix() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetRoutingPrefix();
        }
        catch(RemoteException re)
        {
            throw processException("GetRoutingPrefix",re);
        }
    }

    public String GetRoutingSuffix() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetRoutingSuffix();
        }
        catch(RemoteException re)
        {
            throw processException("GetRoutingSuffix",re);
        }
    }

    public String GetAstraBarcode() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetAstraBarcode();
        }
        catch(RemoteException re)
        {
            throw processException("GetAstraBarcode",re);
        }
    }

    public String GetDeliveryDayOfWeek() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetDeliveryDayOfWeek();
        }
        catch(RemoteException re)
        {
            throw processException("GetDeliveryDayOfWeek",re);
        }
    }

    public String GetDeliveryDate() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetDeliveryDate();
        }
        catch(RemoteException re)
        {
            throw processException("GetDeliveryDate",re);
        }
    }

    public String GetAstraLine1() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetAstraLine1();
        }
        catch(RemoteException re)
        {
            throw processException("GetAstraLine1",re);
        }
    }

    public int CommitCalculated() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().CommitCalculated();
        }
        catch(RemoteException re)
        {
            throw processException("CommitCalculated",re);
        }
    }

    public String GetServiceText(int ServiceCode) throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetServiceText(ServiceCode);
        }
        catch(RemoteException re)
        {
            throw processException("GetServiceText",re);
        }
    }

    public int CreateCrc(byte[] array, int length) throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().CreateCrc(array,length);
        }
        catch(RemoteException re)
        {
            throw processException("CreateCrc",re);
        }
    }

    public int SelectSplit(int i_pos, int i_split) throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SelectSplit(i_pos,i_split);
        }
        catch(RemoteException re)
        {
            throw processException("",re);
        }
    }

    public int SplitsCheck() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().SplitsCheck();
        }
        catch(RemoteException re)
        {
            throw processException("SplitsCheck",re);
        }
    }

    public int GetSplitsErrorNumber() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetSplitsErrorNumber();
        }
        catch(RemoteException re)
        {
            throw processException("GetSplitsErrorNumber",re);
        }
    }

    public String GetSplitsErrorText() throws RemoteJava2uvsdkException
    {
        try
        {
            return getServerReference().GetSplitsErrorText();
        }
        catch(RemoteException re)
        {
            throw processException("GetSplitsErrorText",re);
        }
    }

    public void AstraScan() throws RemoteJava2uvsdkException
    {
        try
        {
            getServerReference().AstraScan();
        }
        catch(RemoteException re)
        {
            throw processException("AstraScan",re);
        }
    }


}
