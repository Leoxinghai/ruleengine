package cciij.util.remoteuvsdk;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import rmtc.util.Config;

public class RemoteJava2uvsdkFactoryMonitorClient
{
    public static Registry getRegistry() throws RemoteException
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


    public static void main(String args[]) 
    {
        int retVal = 0;

        try
        {
            Registry registry = getRegistry();
            RemoteJava2uvsdkFactory factory = (RemoteJava2uvsdkFactory) registry.lookup("RemoteJava2uvsdkFactory");
            System.out.println("Got the Factory");
            retVal = factory.getStatus();
            System.exit(retVal);
        }
        catch(Exception e)
        {
            System.out.println("Failed to contact RemoteJava2uvsdkFactory in rmi registry:  " + e);
            e.printStackTrace(System.out);
            System.exit(-1);
        }
    }
            
}