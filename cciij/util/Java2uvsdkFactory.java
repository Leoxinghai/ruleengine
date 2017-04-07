package cciij.util;

import cciij.util.remoteuvsdk.RemoteJava2uvsdkClient;

import rmtc.util.Config;

public class Java2uvsdkFactory
{
    private static Java2uvsdkFactory m_factory = new Java2uvsdkFactory();
    private static Config m_config = new Config("Java2uvsdkFactory");

    private Java2uvsdkFactory()
    {
    }

    public static Java2uvsdkInterface getJava2uvsdk()
    {
        String uvsdkType = m_config.getString("JAVA2UVSDK_TYPE","LOCAL");

        if(uvsdkType.equals("REMOTE"))
        {
            return new RemoteJava2uvsdkClient();
        }
        else if(uvsdkType.equals("LOCAL"))
        {
            return new Java2uvsdk();
        }
        else
        {
            System.out.println("INVALID JAVA2UVSDK_TYPE:  " + uvsdkType + "  defaulting to REMOTE");
            return new RemoteJava2uvsdkClient();
        }
            
    }
}