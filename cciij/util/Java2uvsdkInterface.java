package cciij.util;

public interface Java2uvsdkInterface
{
    public int LoadUrsaEditFiles() throws Java2uvsdkException;
    public int LoadSplitFile(String splitFileName, boolean loadCheck) throws Java2uvsdkException;
    public String GetUrsaEffectiveDate(String s_formatString) throws Java2uvsdkException;
    public String GetUrsaExpirationDate(String s_formatString) throws Java2uvsdkException;
    public int GetUrsaVersion() throws Java2uvsdkException;
    public void UEInitialize() throws Java2uvsdkException;
    public void SInitialize() throws Java2uvsdkException;
    public int GetUrsaFileType() throws Java2uvsdkException;
    public void UInitialize() throws Java2uvsdkException;
    public int SetTodaysDate(String DateString) throws Java2uvsdkException;
    public int SetShipDate(String DateString) throws Java2uvsdkException;
    public int SetDestCountry(String CountryString) throws Java2uvsdkException;
    public boolean PostalCountry() throws Java2uvsdkException;
    public int SetDestPostalCode(String PostalString) throws Java2uvsdkException;
    public int SetDestStation(String StationString) throws Java2uvsdkException;
    public int SetOriginStation(String StationString) throws Java2uvsdkException;
    public String CheckAirbill(String TrackNumber) throws Java2uvsdkException;
    public String GetABFormCode() throws Java2uvsdkException;
    public String GetABTypeCode() throws Java2uvsdkException;
    public String GetHandlingText(int HandCode) throws Java2uvsdkException;
    public void SetServiceCode(int serviceCode) throws Java2uvsdkException;
    public void SetHandlingCode(int handlingCode) throws Java2uvsdkException;
    public void SetAirbillAndFormCode(String airbillNumber, String formCode) throws Java2uvsdkException;
    public void RouteUrsa() throws Java2uvsdkException;
    public void CommitUrsa() throws Java2uvsdkException;
    public String GetServiceAreaCode() throws Java2uvsdkException;
    public String GetDestinationAirport() throws Java2uvsdkException;
    public String GetRoutingPrefix() throws Java2uvsdkException;
    public String GetRoutingSuffix() throws Java2uvsdkException;
    public String GetAstraBarcode() throws Java2uvsdkException;
    public String GetDeliveryDayOfWeek() throws Java2uvsdkException;
    public String GetDeliveryDate() throws Java2uvsdkException;
    public String GetAstraLine1() throws Java2uvsdkException;
    public int CommitCalculated() throws Java2uvsdkException;
    public String GetServiceText(int ServiceCode) throws Java2uvsdkException;
    public int CreateCrc(byte[] array, int length) throws Java2uvsdkException;
    public int SelectSplit(int i_pos, int i_split) throws Java2uvsdkException;
    public int SplitsCheck() throws Java2uvsdkException;
    public int GetSplitsErrorNumber() throws Java2uvsdkException;
    public String GetSplitsErrorText() throws Java2uvsdkException;
    public void AstraScan() throws Java2uvsdkException;
}
