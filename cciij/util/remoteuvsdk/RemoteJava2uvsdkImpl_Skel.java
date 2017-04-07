// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package cciij.util.remoteuvsdk;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

// Referenced classes of package cciij.util.remoteuvsdk:
//            RemoteJava2uvsdkImpl

public final class RemoteJava2uvsdkImpl_Skel
    implements Skeleton
{

    public RemoteJava2uvsdkImpl_Skel()
    {
    }

    public void dispatch(Remote remote, RemoteCall remotecall, int i, long l)
        throws Exception
    {
        if(i < 0)
        {
            if(l == 0x4f819d0f914a02b1L)
                i = 0;
            else
            if(l == 0x620f0c99af4fcef3L)
                i = 1;
            else
            if(l == 0x68a9bad1525a9270L)
                i = 2;
            else
            if(l == 0xf4d700700b009726L)
                i = 3;
            else
            if(l == 0x608ff1a49c0b8243L)
                i = 4;
            else
            if(l == 0x6ef89e9baf59e948L)
                i = 5;
            else
            if(l == 0x42ac8eb783b0871fL)
                i = 6;
            else
            if(l == 0xa2a1180718e0257L)
                i = 7;
            else
            if(l == 0x2384287c1865e5bdL)
                i = 8;
            else
            if(l == 0xef6738eaca064e2L)
                i = 9;
            else
            if(l == 0x4434899049826356L)
                i = 10;
            else
            if(l == 0x2a5628b4c90bfd04L)
                i = 11;
            else
            if(l == 0x2369f82ceacf98e1L)
                i = 12;
            else
            if(l == 0x359caf2f9e9f4278L)
                i = 13;
            else
            if(l == 0x91720d0c3b22fb47L)
                i = 14;
            else
            if(l == 0xeab5aa245426a4d0L)
                i = 15;
            else
            if(l == 0xc510e23a02d749eaL)
                i = 16;
            else
            if(l == 0xdf9da1fe9917d4f5L)
                i = 17;
            else
            if(l == 0x6ded9e15e7745d77L)
                i = 18;
            else
            if(l == 0xee090f87ce48f2feL)
                i = 19;
            else
            if(l == 0x7c4ce0e78dfc400L)
                i = 20;
            else
            if(l == 0x5fd9ab62b7d7b245L)
                i = 21;
            else
            if(l == 0xc8daee20fff09b45L)
                i = 22;
            else
            if(l == 0x78c85c3d4edcbc3aL)
                i = 23;
            else
            if(l == 0x603cfbe8d8f759d8L)
                i = 24;
            else
            if(l == 0xd5f79997fc923ef4L)
                i = 25;
            else
            if(l == 0xe4a0db565f413913L)
                i = 26;
            else
            if(l == 0x2a74c528a9fb1b7aL)
                i = 27;
            else
            if(l == 0x80af5bce902e1fe2L)
                i = 28;
            else
            if(l == 0x1ac0ca087f3fc891L)
                i = 29;
            else
            if(l == 0x20b1b0d32ddcec5bL)
                i = 30;
            else
            if(l == 0xd14b602a3c2357cbL)
                i = 31;
            else
            if(l == 0xb633900d284a7768L)
                i = 32;
            else
            if(l == 0x4712b58233145bbeL)
                i = 33;
            else
            if(l == 0x78b79c423db28bcfL)
                i = 34;
            else
            if(l == 0x47af6779521b380cL)
                i = 35;
            else
            if(l == 0x1b925c74496bed20L)
                i = 36;
            else
            if(l == 0x8cd52e273e286d89L)
                i = 37;
            else
            if(l == 0x1005bc703bdc2548L)
                i = 38;
            else
            if(l == 0xa2eccd9813cb51bcL)
                i = 39;
            else
            if(l == 0xf8de99f5526d60ffL)
                i = 40;
            else
                throw new UnmarshalException("invalid method hash");
        } else
        if(l != 0x876ca3a10c36d8c4L)
            throw new SkeletonMismatchException("interface hash mismatch");
        RemoteJava2uvsdkImpl remotejava2uvsdkimpl = (RemoteJava2uvsdkImpl)remote;
        switch(i)
        {
        case 0: // '\0'
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.AstraScan();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception)
            {
                throw new MarshalException("error marshalling return", ioexception);
            }
            break;

        case 1: // '\001'
            String s;
            try
            {
                ObjectInput objectinput = remotecall.getInputStream();
                s = (String)objectinput.readObject();
            }
            catch(IOException ioexception38)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception38);
            }
            catch(ClassNotFoundException classnotfoundexception)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            String s22 = remotejava2uvsdkimpl.CheckAirbill(s);
            try
            {
                ObjectOutput objectoutput18 = remotecall.getResultStream(true);
                objectoutput18.writeObject(s22);
            }
            catch(IOException ioexception26)
            {
                throw new MarshalException("error marshalling return", ioexception26);
            }
            break;

        case 2: // '\002'
            remotecall.releaseInputStream();
            int j = remotejava2uvsdkimpl.CommitCalculated();
            try
            {
                ObjectOutput objectoutput = remotecall.getResultStream(true);
                objectoutput.writeInt(j);
            }
            catch(IOException ioexception6)
            {
                throw new MarshalException("error marshalling return", ioexception6);
            }
            break;

        case 3: // '\003'
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.CommitUrsa();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception1)
            {
                throw new MarshalException("error marshalling return", ioexception1);
            }
            break;

        case 4: // '\004'
            byte abyte0[];
            int j3;
            try
            {
                ObjectInput objectinput13 = remotecall.getInputStream();
                abyte0 = (byte[])objectinput13.readObject();
                j3 = objectinput13.readInt();
            }
            catch(IOException ioexception54)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception54);
            }
            catch(ClassNotFoundException classnotfoundexception9)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception9);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int j5 = remotejava2uvsdkimpl.CreateCrc(abyte0, j3);
            try
            {
                ObjectOutput objectoutput29 = remotecall.getResultStream(true);
                objectoutput29.writeInt(j5);
            }
            catch(IOException ioexception39)
            {
                throw new MarshalException("error marshalling return", ioexception39);
            }
            break;

        case 5: // '\005'
            remotecall.releaseInputStream();
            String s1 = remotejava2uvsdkimpl.GetABFormCode();
            try
            {
                ObjectOutput objectoutput1 = remotecall.getResultStream(true);
                objectoutput1.writeObject(s1);
            }
            catch(IOException ioexception7)
            {
                throw new MarshalException("error marshalling return", ioexception7);
            }
            break;

        case 6: // '\006'
            remotecall.releaseInputStream();
            String s2 = remotejava2uvsdkimpl.GetABTypeCode();
            try
            {
                ObjectOutput objectoutput2 = remotecall.getResultStream(true);
                objectoutput2.writeObject(s2);
            }
            catch(IOException ioexception8)
            {
                throw new MarshalException("error marshalling return", ioexception8);
            }
            break;

        case 7: // '\007'
            remotecall.releaseInputStream();
            String s3 = remotejava2uvsdkimpl.GetAstraBarcode();
            try
            {
                ObjectOutput objectoutput3 = remotecall.getResultStream(true);
                objectoutput3.writeObject(s3);
            }
            catch(IOException ioexception9)
            {
                throw new MarshalException("error marshalling return", ioexception9);
            }
            break;

        case 8: // '\b'
            remotecall.releaseInputStream();
            String s4 = remotejava2uvsdkimpl.GetAstraLine1();
            try
            {
                ObjectOutput objectoutput4 = remotecall.getResultStream(true);
                objectoutput4.writeObject(s4);
            }
            catch(IOException ioexception10)
            {
                throw new MarshalException("error marshalling return", ioexception10);
            }
            break;

        case 9: // '\t'
            remotecall.releaseInputStream();
            String s5 = remotejava2uvsdkimpl.GetDeliveryDate();
            try
            {
                ObjectOutput objectoutput5 = remotecall.getResultStream(true);
                objectoutput5.writeObject(s5);
            }
            catch(IOException ioexception11)
            {
                throw new MarshalException("error marshalling return", ioexception11);
            }
            break;

        case 10: // '\n'
            remotecall.releaseInputStream();
            String s6 = remotejava2uvsdkimpl.GetDeliveryDayOfWeek();
            try
            {
                ObjectOutput objectoutput6 = remotecall.getResultStream(true);
                objectoutput6.writeObject(s6);
            }
            catch(IOException ioexception12)
            {
                throw new MarshalException("error marshalling return", ioexception12);
            }
            break;

        case 11: // '\013'
            remotecall.releaseInputStream();
            String s7 = remotejava2uvsdkimpl.GetDestinationAirport();
            try
            {
                ObjectOutput objectoutput7 = remotecall.getResultStream(true);
                objectoutput7.writeObject(s7);
            }
            catch(IOException ioexception13)
            {
                throw new MarshalException("error marshalling return", ioexception13);
            }
            break;

        case 12: // '\f'
            int k;
            try
            {
                ObjectInput objectinput1 = remotecall.getInputStream();
                k = objectinput1.readInt();
            }
            catch(IOException ioexception40)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception40);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            String s23 = remotejava2uvsdkimpl.GetHandlingText(k);
            try
            {
                ObjectOutput objectoutput19 = remotecall.getResultStream(true);
                objectoutput19.writeObject(s23);
            }
            catch(IOException ioexception27)
            {
                throw new MarshalException("error marshalling return", ioexception27);
            }
            break;

        case 13: // '\r'
            remotecall.releaseInputStream();
            String s8 = remotejava2uvsdkimpl.GetRoutingPrefix();
            try
            {
                ObjectOutput objectoutput8 = remotecall.getResultStream(true);
                objectoutput8.writeObject(s8);
            }
            catch(IOException ioexception14)
            {
                throw new MarshalException("error marshalling return", ioexception14);
            }
            break;

        case 14: // '\016'
            remotecall.releaseInputStream();
            String s9 = remotejava2uvsdkimpl.GetRoutingSuffix();
            try
            {
                ObjectOutput objectoutput9 = remotecall.getResultStream(true);
                objectoutput9.writeObject(s9);
            }
            catch(IOException ioexception15)
            {
                throw new MarshalException("error marshalling return", ioexception15);
            }
            break;

        case 15: // '\017'
            remotecall.releaseInputStream();
            String s10 = remotejava2uvsdkimpl.GetServiceAreaCode();
            try
            {
                ObjectOutput objectoutput10 = remotecall.getResultStream(true);
                objectoutput10.writeObject(s10);
            }
            catch(IOException ioexception16)
            {
                throw new MarshalException("error marshalling return", ioexception16);
            }
            break;

        case 16: // '\020'
            int i1;
            try
            {
                ObjectInput objectinput2 = remotecall.getInputStream();
                i1 = objectinput2.readInt();
            }
            catch(IOException ioexception41)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception41);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            String s24 = remotejava2uvsdkimpl.GetServiceText(i1);
            try
            {
                ObjectOutput objectoutput20 = remotecall.getResultStream(true);
                objectoutput20.writeObject(s24);
            }
            catch(IOException ioexception28)
            {
                throw new MarshalException("error marshalling return", ioexception28);
            }
            break;

        case 17: // '\021'
            remotecall.releaseInputStream();
            int j1 = remotejava2uvsdkimpl.GetSplitsErrorNumber();
            try
            {
                ObjectOutput objectoutput11 = remotecall.getResultStream(true);
                objectoutput11.writeInt(j1);
            }
            catch(IOException ioexception17)
            {
                throw new MarshalException("error marshalling return", ioexception17);
            }
            break;

        case 18: // '\022'
            remotecall.releaseInputStream();
            String s11 = remotejava2uvsdkimpl.GetSplitsErrorText();
            try
            {
                ObjectOutput objectoutput12 = remotecall.getResultStream(true);
                objectoutput12.writeObject(s11);
            }
            catch(IOException ioexception18)
            {
                throw new MarshalException("error marshalling return", ioexception18);
            }
            break;

        case 19: // '\023'
            String s12;
            try
            {
                ObjectInput objectinput3 = remotecall.getInputStream();
                s12 = (String)objectinput3.readObject();
            }
            catch(IOException ioexception42)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception42);
            }
            catch(ClassNotFoundException classnotfoundexception1)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception1);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            String s25 = remotejava2uvsdkimpl.GetUrsaEffectiveDate(s12);
            try
            {
                ObjectOutput objectoutput21 = remotecall.getResultStream(true);
                objectoutput21.writeObject(s25);
            }
            catch(IOException ioexception29)
            {
                throw new MarshalException("error marshalling return", ioexception29);
            }
            break;

        case 20: // '\024'
            String s13;
            try
            {
                ObjectInput objectinput4 = remotecall.getInputStream();
                s13 = (String)objectinput4.readObject();
            }
            catch(IOException ioexception43)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception43);
            }
            catch(ClassNotFoundException classnotfoundexception2)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception2);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            String s26 = remotejava2uvsdkimpl.GetUrsaExpirationDate(s13);
            try
            {
                ObjectOutput objectoutput22 = remotecall.getResultStream(true);
                objectoutput22.writeObject(s26);
            }
            catch(IOException ioexception30)
            {
                throw new MarshalException("error marshalling return", ioexception30);
            }
            break;

        case 21: // '\025'
            remotecall.releaseInputStream();
            int k1 = remotejava2uvsdkimpl.GetUrsaFileType();
            try
            {
                ObjectOutput objectoutput13 = remotecall.getResultStream(true);
                objectoutput13.writeInt(k1);
            }
            catch(IOException ioexception19)
            {
                throw new MarshalException("error marshalling return", ioexception19);
            }
            break;

        case 22: // '\026'
            remotecall.releaseInputStream();
            int l1 = remotejava2uvsdkimpl.GetUrsaVersion();
            try
            {
                ObjectOutput objectoutput14 = remotecall.getResultStream(true);
                objectoutput14.writeInt(l1);
            }
            catch(IOException ioexception20)
            {
                throw new MarshalException("error marshalling return", ioexception20);
            }
            break;

        case 23: // '\027'
            String s14;
            boolean flag1;
            try
            {
                ObjectInput objectinput14 = remotecall.getInputStream();
                s14 = (String)objectinput14.readObject();
                flag1 = objectinput14.readBoolean();
            }
            catch(IOException ioexception55)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception55);
            }
            catch(ClassNotFoundException classnotfoundexception10)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception10);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int k5 = remotejava2uvsdkimpl.LoadSplitFile(s14, flag1);
            try
            {
                ObjectOutput objectoutput30 = remotecall.getResultStream(true);
                objectoutput30.writeInt(k5);
            }
            catch(IOException ioexception44)
            {
                throw new MarshalException("error marshalling return", ioexception44);
            }
            break;

        case 24: // '\030'
            remotecall.releaseInputStream();
            int i2 = remotejava2uvsdkimpl.LoadUrsaEditFiles();
            try
            {
                ObjectOutput objectoutput15 = remotecall.getResultStream(true);
                objectoutput15.writeInt(i2);
            }
            catch(IOException ioexception21)
            {
                throw new MarshalException("error marshalling return", ioexception21);
            }
            break;

        case 25: // '\031'
            remotecall.releaseInputStream();
            boolean flag = remotejava2uvsdkimpl.PostalCountry();
            try
            {
                ObjectOutput objectoutput16 = remotecall.getResultStream(true);
                objectoutput16.writeBoolean(flag);
            }
            catch(IOException ioexception22)
            {
                throw new MarshalException("error marshalling return", ioexception22);
            }
            break;

        case 26: // '\032'
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.RouteUrsa();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception2)
            {
                throw new MarshalException("error marshalling return", ioexception2);
            }
            break;

        case 27: // '\033'
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.SInitialize();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception3)
            {
                throw new MarshalException("error marshalling return", ioexception3);
            }
            break;

        case 28: // '\034'
            int j2;
            int k3;
            try
            {
                ObjectInput objectinput15 = remotecall.getInputStream();
                j2 = objectinput15.readInt();
                k3 = objectinput15.readInt();
            }
            catch(IOException ioexception56)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception56);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int l5 = remotejava2uvsdkimpl.SelectSplit(j2, k3);
            try
            {
                ObjectOutput objectoutput31 = remotecall.getResultStream(true);
                objectoutput31.writeInt(l5);
            }
            catch(IOException ioexception45)
            {
                throw new MarshalException("error marshalling return", ioexception45);
            }
            break;

        case 29: // '\035'
            String s15;
            String s27;
            try
            {
                ObjectInput objectinput16 = remotecall.getInputStream();
                s15 = (String)objectinput16.readObject();
                s27 = (String)objectinput16.readObject();
            }
            catch(IOException ioexception57)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception57);
            }
            catch(ClassNotFoundException classnotfoundexception11)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception11);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            remotejava2uvsdkimpl.SetAirbillAndFormCode(s15, s27);
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception31)
            {
                throw new MarshalException("error marshalling return", ioexception31);
            }
            break;

        case 30: // '\036'
            String s16;
            try
            {
                ObjectInput objectinput5 = remotecall.getInputStream();
                s16 = (String)objectinput5.readObject();
            }
            catch(IOException ioexception46)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception46);
            }
            catch(ClassNotFoundException classnotfoundexception3)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception3);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int l3 = remotejava2uvsdkimpl.SetDestCountry(s16);
            try
            {
                ObjectOutput objectoutput23 = remotecall.getResultStream(true);
                objectoutput23.writeInt(l3);
            }
            catch(IOException ioexception32)
            {
                throw new MarshalException("error marshalling return", ioexception32);
            }
            break;

        case 31: // '\037'
            String s17;
            try
            {
                ObjectInput objectinput6 = remotecall.getInputStream();
                s17 = (String)objectinput6.readObject();
            }
            catch(IOException ioexception47)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception47);
            }
            catch(ClassNotFoundException classnotfoundexception4)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception4);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int i4 = remotejava2uvsdkimpl.SetDestPostalCode(s17);
            try
            {
                ObjectOutput objectoutput24 = remotecall.getResultStream(true);
                objectoutput24.writeInt(i4);
            }
            catch(IOException ioexception33)
            {
                throw new MarshalException("error marshalling return", ioexception33);
            }
            break;

        case 32: // ' '
            String s18;
            try
            {
                ObjectInput objectinput7 = remotecall.getInputStream();
                s18 = (String)objectinput7.readObject();
            }
            catch(IOException ioexception48)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception48);
            }
            catch(ClassNotFoundException classnotfoundexception5)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception5);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int j4 = remotejava2uvsdkimpl.SetDestStation(s18);
            try
            {
                ObjectOutput objectoutput25 = remotecall.getResultStream(true);
                objectoutput25.writeInt(j4);
            }
            catch(IOException ioexception34)
            {
                throw new MarshalException("error marshalling return", ioexception34);
            }
            break;

        case 33: // '!'
            int k2;
            try
            {
                ObjectInput objectinput8 = remotecall.getInputStream();
                k2 = objectinput8.readInt();
            }
            catch(IOException ioexception49)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception49);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            remotejava2uvsdkimpl.SetHandlingCode(k2);
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception23)
            {
                throw new MarshalException("error marshalling return", ioexception23);
            }
            break;

        case 34: // '"'
            String s19;
            try
            {
                ObjectInput objectinput9 = remotecall.getInputStream();
                s19 = (String)objectinput9.readObject();
            }
            catch(IOException ioexception50)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception50);
            }
            catch(ClassNotFoundException classnotfoundexception6)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception6);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int k4 = remotejava2uvsdkimpl.SetOriginStation(s19);
            try
            {
                ObjectOutput objectoutput26 = remotecall.getResultStream(true);
                objectoutput26.writeInt(k4);
            }
            catch(IOException ioexception35)
            {
                throw new MarshalException("error marshalling return", ioexception35);
            }
            break;

        case 35: // '#'
            int l2;
            try
            {
                ObjectInput objectinput10 = remotecall.getInputStream();
                l2 = objectinput10.readInt();
            }
            catch(IOException ioexception51)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception51);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            remotejava2uvsdkimpl.SetServiceCode(l2);
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception24)
            {
                throw new MarshalException("error marshalling return", ioexception24);
            }
            break;

        case 36: // '$'
            String s20;
            try
            {
                ObjectInput objectinput11 = remotecall.getInputStream();
                s20 = (String)objectinput11.readObject();
            }
            catch(IOException ioexception52)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception52);
            }
            catch(ClassNotFoundException classnotfoundexception7)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception7);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int l4 = remotejava2uvsdkimpl.SetShipDate(s20);
            try
            {
                ObjectOutput objectoutput27 = remotecall.getResultStream(true);
                objectoutput27.writeInt(l4);
            }
            catch(IOException ioexception36)
            {
                throw new MarshalException("error marshalling return", ioexception36);
            }
            break;

        case 37: // '%'
            String s21;
            try
            {
                ObjectInput objectinput12 = remotecall.getInputStream();
                s21 = (String)objectinput12.readObject();
            }
            catch(IOException ioexception53)
            {
                throw new UnmarshalException("error unmarshalling arguments", ioexception53);
            }
            catch(ClassNotFoundException classnotfoundexception8)
            {
                throw new UnmarshalException("error unmarshalling arguments", classnotfoundexception8);
            }
            finally
            {
                remotecall.releaseInputStream();
            }
            int i5 = remotejava2uvsdkimpl.SetTodaysDate(s21);
            try
            {
                ObjectOutput objectoutput28 = remotecall.getResultStream(true);
                objectoutput28.writeInt(i5);
            }
            catch(IOException ioexception37)
            {
                throw new MarshalException("error marshalling return", ioexception37);
            }
            break;

        case 38: // '&'
            remotecall.releaseInputStream();
            int i3 = remotejava2uvsdkimpl.SplitsCheck();
            try
            {
                ObjectOutput objectoutput17 = remotecall.getResultStream(true);
                objectoutput17.writeInt(i3);
            }
            catch(IOException ioexception25)
            {
                throw new MarshalException("error marshalling return", ioexception25);
            }
            break;

        case 39: // '\''
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.UEInitialize();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception4)
            {
                throw new MarshalException("error marshalling return", ioexception4);
            }
            break;

        case 40: // '('
            remotecall.releaseInputStream();
            remotejava2uvsdkimpl.UInitialize();
            try
            {
                remotecall.getResultStream(true);
            }
            catch(IOException ioexception5)
            {
                throw new MarshalException("error marshalling return", ioexception5);
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
        new Operation("void AstraScan()"), new Operation("java.lang.String CheckAirbill(java.lang.String)"), new Operation("int CommitCalculated()"), new Operation("void CommitUrsa()"), new Operation("int CreateCrc(byte[], int)"), new Operation("java.lang.String GetABFormCode()"), new Operation("java.lang.String GetABTypeCode()"), new Operation("java.lang.String GetAstraBarcode()"), new Operation("java.lang.String GetAstraLine1()"), new Operation("java.lang.String GetDeliveryDate()"), 
        new Operation("java.lang.String GetDeliveryDayOfWeek()"), new Operation("java.lang.String GetDestinationAirport()"), new Operation("java.lang.String GetHandlingText(int)"), new Operation("java.lang.String GetRoutingPrefix()"), new Operation("java.lang.String GetRoutingSuffix()"), new Operation("java.lang.String GetServiceAreaCode()"), new Operation("java.lang.String GetServiceText(int)"), new Operation("int GetSplitsErrorNumber()"), new Operation("java.lang.String GetSplitsErrorText()"), new Operation("java.lang.String GetUrsaEffectiveDate(java.lang.String)"), 
        new Operation("java.lang.String GetUrsaExpirationDate(java.lang.String)"), new Operation("int GetUrsaFileType()"), new Operation("int GetUrsaVersion()"), new Operation("int LoadSplitFile(java.lang.String, boolean)"), new Operation("int LoadUrsaEditFiles()"), new Operation("boolean PostalCountry()"), new Operation("void RouteUrsa()"), new Operation("void SInitialize()"), new Operation("int SelectSplit(int, int)"), new Operation("void SetAirbillAndFormCode(java.lang.String, java.lang.String)"), 
        new Operation("int SetDestCountry(java.lang.String)"), new Operation("int SetDestPostalCode(java.lang.String)"), new Operation("int SetDestStation(java.lang.String)"), new Operation("void SetHandlingCode(int)"), new Operation("int SetOriginStation(java.lang.String)"), new Operation("void SetServiceCode(int)"), new Operation("int SetShipDate(java.lang.String)"), new Operation("int SetTodaysDate(java.lang.String)"), new Operation("int SplitsCheck()"), new Operation("void UEInitialize()"), 
        new Operation("void UInitialize()")
    };
    private static final long interfaceHash = 0x876ca3a10c36d8c4L;

}
