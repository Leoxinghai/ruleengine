// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package cciij.util.remoteuvsdk;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

// Referenced classes of package cciij.util.remoteuvsdk:
//            RemoteJava2uvsdkFactoryImpl

public final class RemoteJava2uvsdkFactoryImpl_Skel
    implements Skeleton
{

    public RemoteJava2uvsdkFactoryImpl_Skel()
    {
    }

    public void dispatch(Remote remote, RemoteCall remotecall, int i, long l)
        throws Exception
    {
        if(i < 0)
        {
            if(l == 0x46c689bcb5cb71a6L)
                i = 0;
            else
            if(l == 0x49b4826fd0d1d938L)
                i = 1;
            else
                throw new UnmarshalException("invalid method hash");
        } else
        if(l != 0x71c4c7efc65cd3f7L)
            throw new SkeletonMismatchException("interface hash mismatch");
        RemoteJava2uvsdkFactoryImpl remotejava2uvsdkfactoryimpl = (RemoteJava2uvsdkFactoryImpl)remote;
        switch(i)
        {
        case 0: // '\0'
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception2)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception2);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            RemoteJava2uvsdk remotejava2uvsdk = remotejava2uvsdkfactoryimpl.getRemoteJava2uvsdk(s);
            try
            {
                ObjectOutput objectoutput1 = remotecall.getResultStream(true);
                objectoutput1.writeObject(remotejava2uvsdk);
            }
            catch(IOException ioexception1)
            {
                throw new MarshalException("error marshalling return", ioexception1);
            }
            break;

        case 1: // '\001'
            remotecall.releaseInputStream();
            int j = remotejava2uvsdkfactoryimpl.getStatus();
            try
            {
                ObjectOutput objectoutput = remotecall.getResultStream(true);
                objectoutput.writeInt(j);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling return", ioexception);
            }
            break;

        default:
            throw new UnmarshalException("invalid method number");
        }
    }

    public Operation[] getOperations()
    {
        return (Operation[])operations.clone();
    }

    private static final Operation operations[] = {
        new Operation("cciij.util.remoteuvsdk.RemoteJava2uvsdk getRemoteJava2uvsdk(java.lang.String)"), new Operation("int getStatus()")
    };
    private static final long interfaceHash = 0x71c4c7efc65cd3f7L;

}
