package cciij.util;

import java.io.ByteArrayOutputStream;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.oss.asn1.*;
import com.oss.util.*;
import cciibts.*;
import cciibts.btsdwnld.*;


public class BTSTestClient extends CCIIBatchTestClientBase
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
            Cciibts.initialize();
            Coder coder = Cciibts.getBERCoder();
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


    protected byte[] getMessageBytes(String data[])
    {
        BTSDwnldTran msg = new BTSDwnldTran();
        Coder coder = getCoder();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();

        sink.write("Mike was here".getBytes(),0,5);

        msg = getMessage(data,msg);

        if(m_outputMessageContents)
        {
            System.out.println("Message Before Encoding:  \n" + msg);
        }

        try
        {
            coder.encode(msg,sink);
        }
        catch(Exception e)
        {
            if(m_outputMessageContents == false)
            {
                System.out.println("Failed Message:\n" + msg);
            }
            System.out.println("failed to encode Message:  " + e);
            e.printStackTrace(System.out);
            System.exit(-1);
        }

        byte message[] = sink.toByteArray();
        
        return message;
    }

//     protected String[] getSetters()
//     {
//         Vector sv = new Vector();
//         sv.add("setAirbillNbr");
//         sv.add("setFormCd");
//         sv.add("setSerialNbr");
//         sv.add("setOriginLoc");
//         sv.add("setDestinationLoc");
//         sv.add("setTransCd");
//         sv.add("setTotalPieces");
//         sv.add("setEmployeeNbr");
//         sv.add("setComment");
//         sv.add("setEntryNbr");
//         sv.add("setEntryType");
//         sv.add("setEntryDtEst");
//         sv.add("setAgencyCd");
//         sv.add("setSelectCd");
//         sv.add("setReasonCd1");
//         sv.add("setReasonCd2");
//         sv.add("setReasonCd3");
//         sv.add("setReasonCd4");
//         sv.add("setReasonCd5");
//         sv.add("setReasonCd6");
//         sv.add("setReasonCd7");
//         sv.add("setReasonCd8");
//         return (String[])sv.toArray(new String[sv.size()]);
//     }


    private BTSDwnldTran getMessage(String data[],BTSDwnldTran msg)
    {
        for(int i=0;i<data.length;i++)
        {
            switch(i)
            {
            case 0:
                msg.setAirbillNbr(new IA5String(data[i]));
                break;
            case 1:
                msg.setFormCd(new IA5String(data[i]));
                break;
            case 2:
                msg.setSerialNbr(new IA5String(data[i]));
                break;
            case 3:
                msg.setOriginLoc(new IA5String(data[i]));
                break;
            case 4:
                msg.setDestinationLoc(new IA5String(data[i]));
                break;
            case 5:
                msg.setTransCd(new IA5String(data[i]));
                break;
            case 6:
                msg.setTotalPieces(new IA5String(data[i]));
                break;
            case 7:
                if((data[i] == null) || (data[i].trim().length() <= 0))
                {
                    data[i] = m_sdf.format(new Date());
                }
                msg.setTransDtEst(new IA5String(data[i]));
                break;
            case 8:
                if((data[i] == null) || (data[i].trim().length() <= 0))
                {
                    data[i] = m_config.getString("user.name","Unknown");
                }
                msg.setEmployeeNbr(new IA5String(data[i]));
                break;
            case 9:
                msg.setComment(new IA5String(data[i]));
                break;
            case 10:
                msg.setEntryNbr(new IA5String(data[i]));
                break;
            case 11:
                msg.setEntryType(new IA5String(data[i]));
                break;
            case 12:
                if((data[i] == null) || (data[i].trim().length() <= 0))
                {
                    data[i] = m_sdf.format(new Date());
                }
                msg.setEntryDtEst(new IA5String(data[i]));
                break;
            case 13:
                msg.setAgencyCd(new IA5String(data[i]));
                break;
            case 14:
                msg.setSelectCd(new IA5String(data[i]));
                break;
            case 15:
                msg.setReasonCd1(new IA5String(data[i]));
                break;
            case 16:
                msg.setReasonCd2(new IA5String(data[i]));
                break;
            case 17:
                msg.setReasonCd3(new IA5String(data[i]));
                break;
            case 18:
                msg.setReasonCd4(new IA5String(data[i]));
                break;
            case 19:
                msg.setReasonCd5(new IA5String(data[i]));
                break;
            case 20:
                msg.setReasonCd6(new IA5String(data[i]));
                break;
            case 21:
                msg.setReasonCd7(new IA5String(data[i]));
                break;
            case 22:
                msg.setReasonCd8(new IA5String(data[i]));
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
        main(new BTSTestClient(),args);
    }

}