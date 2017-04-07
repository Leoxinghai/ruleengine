// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package cciij.util.remoteuvsdk;

import java.io.*;
import java.lang.reflect.Method;
import java.rmi.*;
import java.rmi.server.*;

// Referenced classes of package cciij.util.remoteuvsdk:
//            RemoteJava2uvsdk

public final class RemoteJava2uvsdkImpl_Stub extends RemoteStub
    implements RemoteJava2uvsdk, Remote
{

    public RemoteJava2uvsdkImpl_Stub()
    {
    }

    public RemoteJava2uvsdkImpl_Stub(RemoteRef remoteref)
    {
        super(remoteref);
    }

    public void AstraScan()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_AstraScan_0, null, 0x4f819d0f914a02b1L);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 0, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String CheckAirbill(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_CheckAirbill_1, new Object[] {
                    s
                }, 0x620f0c99af4fcef3L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 1, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            String s1;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s1 = (String)objectinput.readObject();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s1;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int CommitCalculated()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_CommitCalculated_2, null, 0x68a9bad1525a9270L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 2, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void CommitUrsa()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_CommitUrsa_3, null, 0xf4d700700b009726L);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 3, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int CreateCrc(byte abyte0[], int i)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_CreateCrc_4, new Object[] {
                    abyte0, new Integer(i)
                }, 0x608ff1a49c0b8243L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 4, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(abyte0);
                objectoutput.writeInt(i);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            int j;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                j = objectinput.readInt();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return j;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetABFormCode()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetABFormCode_5, null, 0x6ef89e9baf59e948L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 5, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetABTypeCode()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetABTypeCode_6, null, 0x42ac8eb783b0871fL);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 6, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetAstraBarcode()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetAstraBarcode_7, null, 0xa2a1180718e0257L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 7, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetAstraLine1()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetAstraLine1_8, null, 0x2384287c1865e5bdL);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 8, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetDeliveryDate()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetDeliveryDate_9, null, 0xef6738eaca064e2L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 9, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetDeliveryDayOfWeek()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetDeliveryDayOfWeek_10, null, 0x4434899049826356L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 10, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetDestinationAirport()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetDestinationAirport_11, null, 0x2a5628b4c90bfd04L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 11, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetHandlingText(int i)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetHandlingText_12, new Object[] {
                    new Integer(i)
                }, 0x2369f82ceacf98e1L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 12, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeInt(i);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetRoutingPrefix()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetRoutingPrefix_13, null, 0x359caf2f9e9f4278L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 13, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetRoutingSuffix()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetRoutingSuffix_14, null, 0x91720d0c3b22fb47L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 14, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetServiceAreaCode()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetServiceAreaCode_15, null, 0xeab5aa245426a4d0L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 15, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetServiceText(int i)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetServiceText_16, new Object[] {
                    new Integer(i)
                }, 0xc510e23a02d749eaL);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 16, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeInt(i);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int GetSplitsErrorNumber()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetSplitsErrorNumber_17, null, 0xdf9da1fe9917d4f5L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 17, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetSplitsErrorText()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetSplitsErrorText_18, null, 0x6ded9e15e7745d77L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 18, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetUrsaEffectiveDate(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetUrsaEffectiveDate_19, new Object[] {
                    s
                }, 0xee090f87ce48f2feL);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 19, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            String s1;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s1 = (String)objectinput.readObject();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s1;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public String GetUrsaExpirationDate(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetUrsaExpirationDate_20, new Object[] {
                    s
                }, 0x7c4ce0e78dfc400L);
                return (String)obj;
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 20, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            String s1;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s1 = (String)objectinput.readObject();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling return", classnotfoundexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return s1;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int GetUrsaFileType()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetUrsaFileType_21, null, 0x5fd9ab62b7d7b245L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 21, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int GetUrsaVersion()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_GetUrsaVersion_22, null, 0xc8daee20fff09b45L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 22, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int LoadSplitFile(String s, boolean flag)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_LoadSplitFile_23, new Object[] {
                    s, new Boolean(flag)
                }, 0x78c85c3d4edcbc3aL);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 23, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
                objectoutput.writeBoolean(flag);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int LoadUrsaEditFiles()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_LoadUrsaEditFiles_24, null, 0x603cfbe8d8f759d8L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 24, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public boolean PostalCountry()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_PostalCountry_25, null, 0xd5f79997fc923ef4L);
                return ((Boolean)obj).booleanValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 25, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            boolean flag;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                flag = objectinput.readBoolean();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return flag;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void RouteUrsa()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_RouteUrsa_26, null, 0xe4a0db565f413913L);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 26, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void SInitialize()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_SInitialize_27, null, 0x2a74c528a9fb1b7aL);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 27, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SelectSplit(int i, int j)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SelectSplit_28, new Object[] {
                    new Integer(i), new Integer(j)
                }, 0x80af5bce902e1fe2L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 28, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeInt(i);
                objectoutput.writeInt(j);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
            super.ref.invoke(remotecall);
            int k;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                k = objectinput.readInt();
            }
            catch(IOException ioexception1)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception1);
            }
            finally
            {
                super.ref.done(remotecall);
            }
            return k;
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void SetAirbillAndFormCode(String s, String s1)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_SetAirbillAndFormCode_29, new Object[] {
                    s, s1
                }, 0x1ac0ca087f3fc891L);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 29, 0x876ca3a10c36d8c4L);
                try
                {
                    ObjectOutput objectoutput = remotecall.getOutputStream();
                    objectoutput.writeObject(s);
                    objectoutput.writeObject(s1);
                }
                catch(IOException ioexception)
                {
                    throw new MarshalException("error marshalling arguments", ioexception);
                }
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetDestCountry(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetDestCountry_30, new Object[] {
                    s
                }, 0x20b1b0d32ddcec5bL);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 30, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetDestPostalCode(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetDestPostalCode_31, new Object[] {
                    s
                }, 0xd14b602a3c2357cbL);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 31, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetDestStation(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetDestStation_32, new Object[] {
                    s
                }, 0xb633900d284a7768L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 32, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void SetHandlingCode(int i)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_SetHandlingCode_33, new Object[] {
                    new Integer(i)
                }, 0x4712b58233145bbeL);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 33, 0x876ca3a10c36d8c4L);
                try
                {
                    ObjectOutput objectoutput = remotecall.getOutputStream();
                    objectoutput.writeInt(i);
                }
                catch(IOException ioexception)
                {
                    throw new MarshalException("error marshalling arguments", ioexception);
                }
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetOriginStation(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetOriginStation_34, new Object[] {
                    s
                }, 0x78b79c423db28bcfL);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 34, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void SetServiceCode(int i)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_SetServiceCode_35, new Object[] {
                    new Integer(i)
                }, 0x47af6779521b380cL);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 35, 0x876ca3a10c36d8c4L);
                try
                {
                    ObjectOutput objectoutput = remotecall.getOutputStream();
                    objectoutput.writeInt(i);
                }
                catch(IOException ioexception)
                {
                    throw new MarshalException("error marshalling arguments", ioexception);
                }
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetShipDate(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetShipDate_36, new Object[] {
                    s
                }, 0x1b925c74496bed20L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 36, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SetTodaysDate(String s)
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SetTodaysDate_37, new Object[] {
                    s
                }, 0x8cd52e273e286d89L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 37, 0x876ca3a10c36d8c4L);
            try
            {
                ObjectOutput objectoutput = remotecall.getOutputStream();
                objectoutput.writeObject(s);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling arguments", ioexception);
            }
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public int SplitsCheck()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                Object obj = super.ref.invoke(this, $method_SplitsCheck_38, null, 0x1005bc703bdc2548L);
                return ((Integer)obj).intValue();
            }
            RemoteCall remotecall = super.ref.newCall(this, operations, 38, 0x876ca3a10c36d8c4L);
            super.ref.invoke(remotecall);
            int i;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                i = objectinput.readInt();
            }
            catch(IOException ioexception)
            {
                throw new UnmarshalException("error unmarshalling return", ioexception);
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
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void UEInitialize()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_UEInitialize_39, null, 0xa2eccd9813cb51bcL);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 39, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
    }

    public void UInitialize()
        throws RemoteException
    {
        try
        {
            if(useNewInvoke)
            {
                super.ref.invoke(this, $method_UInitialize_40, null, 0xf8de99f5526d60ffL);
            } else
            {
                RemoteCall remotecall = super.ref.newCall(this, operations, 40, 0x876ca3a10c36d8c4L);
                super.ref.invoke(remotecall);
                super.ref.done(remotecall);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(RemoteException remoteexception)
        {
            throw remoteexception;
        }
        catch(Exception exception)
        {
            throw new UnexpectedException("undeclared checked exception", exception);
        }
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

    private static final Operation operations[] = {
        new Operation("void AstraScan()"), new Operation("java.lang.String CheckAirbill(java.lang.String)"), new Operation("int CommitCalculated()"), new Operation("void CommitUrsa()"), new Operation("int CreateCrc(byte[], int)"), new Operation("java.lang.String GetABFormCode()"), new Operation("java.lang.String GetABTypeCode()"), new Operation("java.lang.String GetAstraBarcode()"), new Operation("java.lang.String GetAstraLine1()"), new Operation("java.lang.String GetDeliveryDate()"), 
        new Operation("java.lang.String GetDeliveryDayOfWeek()"), new Operation("java.lang.String GetDestinationAirport()"), new Operation("java.lang.String GetHandlingText(int)"), new Operation("java.lang.String GetRoutingPrefix()"), new Operation("java.lang.String GetRoutingSuffix()"), new Operation("java.lang.String GetServiceAreaCode()"), new Operation("java.lang.String GetServiceText(int)"), new Operation("int GetSplitsErrorNumber()"), new Operation("java.lang.String GetSplitsErrorText()"), new Operation("java.lang.String GetUrsaEffectiveDate(java.lang.String)"), 
        new Operation("java.lang.String GetUrsaExpirationDate(java.lang.String)"), new Operation("int GetUrsaFileType()"), new Operation("int GetUrsaVersion()"), new Operation("int LoadSplitFile(java.lang.String, boolean)"), new Operation("int LoadUrsaEditFiles()"), new Operation("boolean PostalCountry()"), new Operation("void RouteUrsa()"), new Operation("void SInitialize()"), new Operation("int SelectSplit(int, int)"), new Operation("void SetAirbillAndFormCode(java.lang.String, java.lang.String)"), 
        new Operation("int SetDestCountry(java.lang.String)"), new Operation("int SetDestPostalCode(java.lang.String)"), new Operation("int SetDestStation(java.lang.String)"), new Operation("void SetHandlingCode(int)"), new Operation("int SetOriginStation(java.lang.String)"), new Operation("void SetServiceCode(int)"), new Operation("int SetShipDate(java.lang.String)"), new Operation("int SetTodaysDate(java.lang.String)"), new Operation("int SplitsCheck()"), new Operation("void UEInitialize()"), 
        new Operation("void UInitialize()")
    };
    private static final long interfaceHash = 0x876ca3a10c36d8c4L;
    private static final long serialVersionUID = 2L;
    private static boolean useNewInvoke;
    private static Method $method_AstraScan_0;
    private static Method $method_CheckAirbill_1;
    private static Method $method_CommitCalculated_2;
    private static Method $method_CommitUrsa_3;
    private static Method $method_CreateCrc_4;
    private static Method $method_GetABFormCode_5;
    private static Method $method_GetABTypeCode_6;
    private static Method $method_GetAstraBarcode_7;
    private static Method $method_GetAstraLine1_8;
    private static Method $method_GetDeliveryDate_9;
    private static Method $method_GetDeliveryDayOfWeek_10;
    private static Method $method_GetDestinationAirport_11;
    private static Method $method_GetHandlingText_12;
    private static Method $method_GetRoutingPrefix_13;
    private static Method $method_GetRoutingSuffix_14;
    private static Method $method_GetServiceAreaCode_15;
    private static Method $method_GetServiceText_16;
    private static Method $method_GetSplitsErrorNumber_17;
    private static Method $method_GetSplitsErrorText_18;
    private static Method $method_GetUrsaEffectiveDate_19;
    private static Method $method_GetUrsaExpirationDate_20;
    private static Method $method_GetUrsaFileType_21;
    private static Method $method_GetUrsaVersion_22;
    private static Method $method_LoadSplitFile_23;
    private static Method $method_LoadUrsaEditFiles_24;
    private static Method $method_PostalCountry_25;
    private static Method $method_RouteUrsa_26;
    private static Method $method_SInitialize_27;
    private static Method $method_SelectSplit_28;
    private static Method $method_SetAirbillAndFormCode_29;
    private static Method $method_SetDestCountry_30;
    private static Method $method_SetDestPostalCode_31;
    private static Method $method_SetDestStation_32;
    private static Method $method_SetHandlingCode_33;
    private static Method $method_SetOriginStation_34;
    private static Method $method_SetServiceCode_35;
    private static Method $method_SetShipDate_36;
    private static Method $method_SetTodaysDate_37;
    private static Method $method_SplitsCheck_38;
    private static Method $method_UEInitialize_39;
    private static Method $method_UInitialize_40;

    static 
    {
        try
        {
            (java.rmi.server.RemoteRef.class).getMethod("invoke", new Class[] {
                java.rmi.Remote.class, java.lang.reflect.Method.class, java.lang.Object[].class, Long.TYPE
            });
            useNewInvoke = true;
            $method_AstraScan_0 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("AstraScan", new Class[0]);
            $method_CheckAirbill_1 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("CheckAirbill", new Class[] {
                java.lang.String.class
            });
            $method_CommitCalculated_2 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("CommitCalculated", new Class[0]);
            $method_CommitUrsa_3 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("CommitUrsa", new Class[0]);
            $method_CreateCrc_4 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("CreateCrc", new Class[] {
                byte[].class, Integer.TYPE
            });
            $method_GetABFormCode_5 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetABFormCode", new Class[0]);
            $method_GetABTypeCode_6 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetABTypeCode", new Class[0]);
            $method_GetAstraBarcode_7 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetAstraBarcode", new Class[0]);
            $method_GetAstraLine1_8 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetAstraLine1", new Class[0]);
            $method_GetDeliveryDate_9 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetDeliveryDate", new Class[0]);
            $method_GetDeliveryDayOfWeek_10 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetDeliveryDayOfWeek", new Class[0]);
            $method_GetDestinationAirport_11 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetDestinationAirport", new Class[0]);
            $method_GetHandlingText_12 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetHandlingText", new Class[] {
                Integer.TYPE
            });
            $method_GetRoutingPrefix_13 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetRoutingPrefix", new Class[0]);
            $method_GetRoutingSuffix_14 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetRoutingSuffix", new Class[0]);
            $method_GetServiceAreaCode_15 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetServiceAreaCode", new Class[0]);
            $method_GetServiceText_16 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetServiceText", new Class[] {
                Integer.TYPE
            });
            $method_GetSplitsErrorNumber_17 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetSplitsErrorNumber", new Class[0]);
            $method_GetSplitsErrorText_18 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetSplitsErrorText", new Class[0]);
            $method_GetUrsaEffectiveDate_19 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetUrsaEffectiveDate", new Class[] {
                java.lang.String.class
            });
            $method_GetUrsaExpirationDate_20 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetUrsaExpirationDate", new Class[] {
                java.lang.String.class
            });
            $method_GetUrsaFileType_21 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetUrsaFileType", new Class[0]);
            $method_GetUrsaVersion_22 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("GetUrsaVersion", new Class[0]);
            $method_LoadSplitFile_23 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("LoadSplitFile", new Class[] {
                java.lang.String.class, Boolean.TYPE
            });
            $method_LoadUrsaEditFiles_24 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("LoadUrsaEditFiles", new Class[0]);
            $method_PostalCountry_25 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("PostalCountry", new Class[0]);
            $method_RouteUrsa_26 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("RouteUrsa", new Class[0]);
            $method_SInitialize_27 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SInitialize", new Class[0]);
            $method_SelectSplit_28 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SelectSplit", new Class[] {
                Integer.TYPE, Integer.TYPE
            });
            $method_SetAirbillAndFormCode_29 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetAirbillAndFormCode", new Class[] {
                java.lang.String.class, java.lang.String.class
            });
            $method_SetDestCountry_30 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetDestCountry", new Class[] {
                java.lang.String.class
            });
            $method_SetDestPostalCode_31 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetDestPostalCode", new Class[] {
                java.lang.String.class
            });
            $method_SetDestStation_32 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetDestStation", new Class[] {
                java.lang.String.class
            });
            $method_SetHandlingCode_33 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetHandlingCode", new Class[] {
                Integer.TYPE
            });
            $method_SetOriginStation_34 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetOriginStation", new Class[] {
                java.lang.String.class
            });
            $method_SetServiceCode_35 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetServiceCode", new Class[] {
                Integer.TYPE
            });
            $method_SetShipDate_36 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetShipDate", new Class[] {
                java.lang.String.class
            });
            $method_SetTodaysDate_37 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SetTodaysDate", new Class[] {
                java.lang.String.class
            });
            $method_SplitsCheck_38 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("SplitsCheck", new Class[0]);
            $method_UEInitialize_39 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("UEInitialize", new Class[0]);
            $method_UInitialize_40 = (cciij.util.remoteuvsdk.RemoteJava2uvsdk.class).getMethod("UInitialize", new Class[0]);
        }
        catch(NoSuchMethodException _ex)
        {
            useNewInvoke = false;
        }
    }
}
