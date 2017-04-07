package cciij.util.remoteuvsdk;

import java.io.IOException;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.rmi.activation.ActivationException;

public interface RemoteJava2uvsdkFactory extends Remote
{
    public RemoteJava2uvsdk getRemoteJava2uvsdk(String name) throws RemoteException,ActivationException,IOException;
    public int getStatus() throws RemoteException,ActivationException,IOException;
}