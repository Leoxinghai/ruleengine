package cciij.util;

import java.io.ByteArrayOutputStream;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.oss.asn1.*;
import com.oss.util.*;
import cciicons.*;
import cciicons.consdwnld.*;


public class ConsDwnldTestClient extends CCIIBatchTestClientBase
{
    private SimpleDateFormat m_sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    protected void childInit()
    {
        // This is where we setup stuff
    }

    private Coder getCoder()
    {
        try
        {
            Cciicons.initialize();
            Coder coder = Cciicons.getBERCoder();
            coder.enableAutomaticDecoding();
            coder.enableAutomaticEncoding();
            coder.disableDecoderDebugging();
            coder.disableEncoderDebugging();
            coder.disableDecoderConstraints();
            coder.disableEncoderConstraints();
            
            return coder;
        }
        catch(Exception e)
        {
            System.out.println("Failed to \"getCoder()\" with exception:  " + e);
            e.printStackTrace(System.out);
            throw new RuntimeException("Failed to getCoder():  " + e,e);
        }
    }

    ConsDwnldTran m_msg = null;

    protected byte[] getMessageBytes(String data[])
    {
        //        ConsDwnldTran msg = new ConsDwnldTran();
        Coder coder = getCoder();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();

        //        sink.write("Mike was here".getBytes(),0,10);

        if(data[0].equals("New"))
        {
            m_msg = new ConsDwnldTran();
        }

        if(data[0].equals("End") == false)
        {
            m_msg = getMessage(data,m_msg);

            return new byte[0];
        }

        sink.write("Mike was here".getBytes(),0,10);



        if(m_outputMessageContents)
        {
            System.out.println("Message Before Encoding:  \n" + m_msg);
        }

        try
        {
            coder.encode(m_msg,sink);
        }
        catch(Exception e)
        {
            if(m_outputMessageContents == false)
            {
                System.out.println("Failed Message:\n" + m_msg);
            }
            System.out.println("failed to encode Message:  " + e);
            e.printStackTrace(System.out);
            System.exit(-1);
        }

        byte message[] = sink.toByteArray();
        
        return message;
    }


    private Aggregate215 m_agg215 = null;
    private int m_currAgg = 0;

    private ConsDwnldTran getMessage(String data[],ConsDwnldTran msg)
    {
        boolean agg = false;

        if(data[0].equals("New"))
        {
            agg = false;
        }
        else
        {
            agg = true;
        }

        for(int i=0;i<data.length;i++)
        {
            int idx;

            if(agg)
            {
                idx = i + 200;
            }
            else
            {
                idx = i;
            }

            String str=null;
            try
            {
                // the two EBCDIC encodings mentioned on the java.sun.com website are:  IBM500 & IBM1047
                //  with the java encoding names:                                       Cp500  & Cp1047
                byte tmpbytes[] = data[i].getBytes("Cp500");

                str = new String(tmpbytes);
            }
            catch(java.io.UnsupportedEncodingException uee)
            {
                System.out.println("Failed to encode the String..." + uee);
                uee.printStackTrace(System.out);
                System.exit(-1);
            }

//            String str = T.translateString(data[i]);

            //            String str = data[i]; // here is where we need to convert to E

            

            switch(idx)
            {
            case 0:
                // This is the "New" indicater; ignore it
                break;
            case 1:
                msg.setConsTrakItemNbr(new IA5String(str));
                m_currAgg = 0;
                m_agg215 = null;
                break;
            case 2:
                msg.setConsTypeCd(new IA5String(str));
                break;
            case 3:
                msg.setConsFormCd(new IA5String(str));
                break;
            case 4:
                msg.setTrakType(new IA5String(str));
                break;
            case 5:
                msg.setNoiDestinationLocId(new IA5String(str));
                break;
            case 6:
                msg.setConsScanLoc(new IA5String(str));
                break;
            case 7:
                msg.setSourceCd(new IA5String(str));
                break;
            case 8:
                msg.setTransmitCd(new IA5String(str));
                break;
            case 9:
                msg.setAstraLabelScannedFlg(new IA5String(str));
                break;
            case 10:
                msg.setConsFailedFlg(new IA5String(str));
                break;
            case 11:
                msg.setContainerId(new IA5String(str));
                break;
            case 12:
                msg.setContainerIndicator(new IA5String(str));
                break;
            case 13:
                msg.setConsCategory(new IA5String(str));
                break;
            case 14:
                msg.setConsDestination(new IA5String(str));
                break;
            case 15:
                msg.setConsDestCountry(new IA5String(str));
                break;
            case 16:
                msg.setConsMinisortFlg(new IA5String(str));
                break;
            case 17:
                msg.setConsScanDt(new IA5String(str));
                break;
            case 18:
                msg.setConsScanTm(new IA5String(str));
                break;
            case 19:
                msg.setConsCreateDt(new IA5String(str));
                break;
            case 20:
                msg.setConsCreateTm(new IA5String(str));
                break;
            case 21:
                msg.setConsTimeZoneChgCd(new IA5String(str));
                break;
            case 22:
                msg.setConsAirbillGroupCnt(new IA5String(str));
                break;
            case 23:
                msg.setEmployeeNbr(new IA5String(str));
                break;
            case 24:
                msg.setPriorDayFlg(new IA5String(str));
                break;
            case 25:
                msg.setBeginFunctionDt(new IA5String(str));
                break;
            case 26:
                msg.setEndFunctionDt(new IA5String(str));
                break;
            case 27:
                msg.setTrakEndFunctionTm(new IA5String(str));
                break;
            case 28:
                msg.setTrakBeginFunctionTm(new IA5String(str));
                break;
            case 29:
                msg.setDestApplicationId(new IA5String(str));
                break;
            case 30:
                msg.setFlightNbr(new IA5String(str));
                break;
            case 31:
                msg.setFlightDt(new IA5String(str));
                break;
            case 32:
                msg.setFlightOrigin(new IA5String(str));
                break;
            case 33:
                msg.setFlightDest(new IA5String(str));
                break;
            case 34:
                msg.setActualDepDt(new IA5String(str));
                break;
            case 35:
                msg.setActualDepTm(new IA5String(str));
                break;
       
            case 200:
                m_agg215 = new Aggregate215();
                if(m_currAgg == 0)
                {
                    msg.setAgg215(new ConsDwnldTran.Agg215());
                }
                msg.getAgg215().insert(m_agg215,m_currAgg++);
                m_agg215.setComponentTrakNbr(new IA5String(str));
                break;
            case 201:
                m_agg215.setComponentTypeCd(new IA5String(str));
                break;
            case 202:
                m_agg215.setComponentFormTypeCd(new IA5String(str));
                break;
            case 203:
                m_agg215.setComponentEntryType(new IA5String(str));
                break;
            case 204:
                m_agg215.setComponentTimeStamp(new IA5String(str));
                break;
            case 205:
                m_agg215.setDeconsDt(new IA5String(str));
                break;
            case 206:
                m_agg215.setDeconsTm(new IA5String(str));
                break;
            default:
                System.out.println("Invalid Data Element:  " + i + ":  " + data[i]);
                break;
            }
        }
        return msg;
    }

    public static void main(String args[]) throws Exception
    {
        main(new ConsDwnldTestClient(),args);
    }

    private Translate T = new Translate();

    private class Translate {
        
        private final int SIZE = 95;
        
        private final int ASCII[] = {
            0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28,
            0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f,
            0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38,
            0x39, 0x3a, 0x3b, 0x3c, 0x3d, 0x3e, 0x3f,
            0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48,
            0x49, 0x4a, 0x4b, 0x4c, 0x4d, 0x4e, 0x4f,
            0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58,
            0x59, 0x5a, 0x5b, 0x5c, 0x5d, 0x5e, 0x5f,
            0x60, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68,
            0x69, 0x6a, 0x6b, 0x6c, 0x6d, 0x6e, 0x6f,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78,
            0x79, 0x7a, 0x7b, 0x7c, 0x7d, 0x7e
        };      
        private final int EBCDIC[] = {
            0x40, 0x5a, 0x7f, 0x7b, 0x5b, 0x6c, 0x50, 0x7d, 0x4d,
            0x5d, 0x5c, 0x4e, 0x6b, 0x60, 0x4b, 0x61,
            0xf0, 0xf1, 0xf2, 0xf3, 0xf4, 0xf5, 0xf6, 0xf7, 0xf8,
            0xf9, 0x7a, 0x5e, 0x4c, 0x7e, 0x6e, 0x6f,
            0x7c, 0xc1, 0xc2, 0xc3, 0xc4, 0xc5, 0xc6, 0xc7, 0xc8,
            0xc9, 0xd1, 0xd2, 0xd3, 0xd4, 0xd5, 0xd6,
            0xd7, 0xd8, 0xd9, 0xe2, 0xe3, 0xe4, 0xe5, 0xe6, 0xe7,
            0xe8, 0xe9, 0xad, 0xe0, 0xbd, 0x5f, 0x6d,
            0x79, 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88,
            0x89, 0x91, 0x92, 0x93, 0x94, 0x95, 0x96,
            0x97, 0x98, 0x99, 0xa2, 0xa3, 0xa4, 0xa5, 0xa6, 0xa7,
            0xa8, 0xa9, 0xc0, 0x6a, 0xd0, 0xa1
        };      
        
        /**
         * Description:   Translates a int, either ASCII to EBCDIC or vice versa
         * @param int the int to be translated
         * @return int the translated int
         * @exception
         **/                                                                    
        public byte translateByte(byte i) 
        {
            for (int j = 0; j<SIZE; j++) 
            {
                if (i == ASCII[j]) 
                {
                    return (byte)EBCDIC[j];
                }
            }               
       
            return i;
        }

        public String translateString(String str)
        {
            byte before[] = str.getBytes();
            byte after[] = new byte[before.length];

            for(int i=0;i<before.length;i++)
            {
                after[i] = translateByte(before[i]);
            }

            return new String(after);
        }
    }
}



