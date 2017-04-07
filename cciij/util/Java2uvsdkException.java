package cciij.util;

public class Java2uvsdkException extends CCIILogException
{
    public Java2uvsdkException(String method,Throwable t)
    {
        super("Failed Java2uvsdk","Failed to call the Java2uvsdk method " + method + "()  reason:  " + t,t);
    }

    public Java2uvsdkException(String msg1,String msg2,Throwable t)
    {
        super(msg1,msg2,t);
    }
}