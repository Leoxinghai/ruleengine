package cciij.util.remoteuvsdk;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteJava2uvsdk extends Remote
{
    public int LoadUrsaEditFiles() throws RemoteException;
    public int LoadSplitFile(String splitFileName, boolean loadCheck) throws RemoteException;
    public String GetUrsaEffectiveDate(String s_formatString) throws RemoteException;
    public String GetUrsaExpirationDate(String s_formatString) throws RemoteException;
    public int GetUrsaVersion() throws RemoteException;
    public void UEInitialize() throws RemoteException;
    public void SInitialize() throws RemoteException;
    public int GetUrsaFileType() throws RemoteException;
    public void UInitialize() throws RemoteException;
    public int SetTodaysDate(String DateString) throws RemoteException;
    public int SetShipDate(String DateString) throws RemoteException;
    public int SetDestCountry(String CountryString) throws RemoteException;
    public boolean PostalCountry() throws RemoteException;
    public int SetDestPostalCode(String PostalString) throws RemoteException;
    public int SetDestStation(String StationString) throws RemoteException;
    public int SetOriginStation(String StationString) throws RemoteException;
    public String CheckAirbill(String TrackNumber) throws RemoteException;
    public String GetABFormCode() throws RemoteException;
    public String GetABTypeCode() throws RemoteException;
    public String GetHandlingText(int HandCode) throws RemoteException;
    public void SetServiceCode(int serviceCode) throws RemoteException;
    public void SetHandlingCode(int handlingCode) throws RemoteException;
    public void SetAirbillAndFormCode(String airbillNumber, String formCode) throws RemoteException;
    public void RouteUrsa() throws RemoteException;
    public void CommitUrsa() throws RemoteException;
    public String GetServiceAreaCode() throws RemoteException;
    public String GetDestinationAirport() throws RemoteException;
    public String GetRoutingPrefix() throws RemoteException;
    public String GetRoutingSuffix() throws RemoteException;
    public String GetAstraBarcode() throws RemoteException;
    public String GetDeliveryDayOfWeek() throws RemoteException;
    public String GetDeliveryDate() throws RemoteException;
    public String GetAstraLine1() throws RemoteException;
    public int CommitCalculated() throws RemoteException;
    public String GetServiceText(int ServiceCode) throws RemoteException;
    public int CreateCrc(byte[] array, int length) throws RemoteException;
    public int SelectSplit(int i_pos, int i_split) throws RemoteException;
    public int SplitsCheck() throws RemoteException;
    public int GetSplitsErrorNumber() throws RemoteException;
    public String GetSplitsErrorText() throws RemoteException;
    public void AstraScan() throws RemoteException;
}
