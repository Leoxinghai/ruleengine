package cciij.util.remoteuvsdk;

public class RemoteJava2uvsdkException extends cciij.util.Java2uvsdkException
{
    public RemoteJava2uvsdkException(String method,Throwable t)
    {
        super("Failed RemoteJava2uvsdk","Failed to call the remote Java2uvsdk method " + method + "()  reason:  " + t,t);
    }
}