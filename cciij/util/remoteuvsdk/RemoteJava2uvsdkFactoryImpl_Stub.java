// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package cciij.util.remoteuvsdk;

import java.io.*;
import java.lang.reflect.Method;
import java.rmi.*;
import java.rmi.activation.ActivationException;
import java.rmi.server.*;

// Referenced classes of package cciij.util.remoteuvsdk:
//            RemoteJava2uvsdk, RemoteJava2uvsdkFactory

public final class RemoteJava2uvsdkFactoryImpl_Stub extends RemoteStub
    implements RemoteJava2uvsdkFactory, Remote
{

    public RemoteJava2uvsdkFactoryImpl_Stub()
    {
    }

    public RemoteJava2uvsdkFactoryImpl_Stub(RemoteRef remoteref)
    {
        super(remoteref);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public RemoteJava2uvsdk getRemoteJava2uvsdk(String s)
        throws IOException, RemoteException, ActivationException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_getRemoteJava2uvsdk_0, new Object[] {
                    s
                }, 0x46c689bcb5cb71a6L);
                return (RemoteJava2uvsdk)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 0, 0x71c4c7efc65cd3f7L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception1)
            {
                throw new MarshalException("error marshalling arguments", ioexception1);
            }
            super.ref.invoke(remotecall);
            RemoteJava2uvsdk remotejava2uvsdk;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                remotejava2uvsdk = (RemoteJava2uvsdk)objectinput.readObject();
            }
            catch(IOException ioexception2)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception2);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return remotejava2uvsdk;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(IOException ioexception)
        {
            throw ioexception;
        }
        catch(ActivationException activationexception)
        {
            throw activationexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int getStatus()
        throws IOException, RemoteException, ActivationException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_getStatus_1, null, 0x49b4826fd0d1d938L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 1, 0x71c4c7efc65cd3f7L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return i;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(IOException ioexception)
        {
            throw ioexception;
        }
        catch(ActivationException activationexception)
        {
            throw activationexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    private static final Operation operations[] = {
        new Operation("cciij.util.remoteuvsdk.RemoteJava2uvsdk getRemoteJava2uvsdk(java.lang.String)"), new Operation("int getStatus()")
    };
    private static final long interfaceHash = 0x71c4c7efc65cd3f7L;
    private static final long serialVersionUID = 2L;
    private static boolean useNewInvoke;
    private static Method $method_getRemoteJava2uvsdk_0;
    private static Method $method_getStatus_1;

    static 
    {
        try
        {
            (java.rmi.server.RemoteRef.class).getMethod("invoke", new Class[] {
                java.rmi.Remote.class, java.lang.reflect.Method.class, java.lang.Object[].class, Long.TYPE
            });
            useNewInvoke = true;
            $method_getRemoteJava2uvsdk_0 = (cciij.util.remoteuvsdk.RemoteJava2uvsdkFactory.class).getMethod("getRemoteJava2uvsdk", new Class[] {
                java.lang.String.class
            });
            $method_getStatus_1 = (cciij.util.remoteuvsdk.RemoteJava2uvsdkFactory.class).getMethod("getStatus", new Class[0]);
        }
        catch(NoSuchMethodException _ex)
        {
            useNewInvoke = false;
        }
    }
}
