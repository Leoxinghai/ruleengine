package cciij.util;



// import java.util.StringTokenizer;
// import java.util.Random;
// import java.util.Date;
// import java.text.SimpleDateFormat;

import java.io.ByteArrayOutputStream;

import java.sql.*;
import javax.sql.DataSource;


import com.oss.asn1.*;
import com.oss.util.*;
import cciiasn.*;
import cciiasn.ddtran.*;


import rmtc.util.Config;
import rmtc.util.JNDILookup;

public class ImportTestClient extends CCIIBatchTestClientBase
{

//     public static void main(String args[]) throws Exception
//     {
//         System.out.println("ImportTestClient.main()");

//         ImportTestClient client = new ImportTestClient(args);

//         client.executeTest();

//         client = null;

//         System.gc();
//         System.out.println("End of main()");
//     }


    protected void childInit()
    {
        setDefaultQueueName("ImportQueue");
        setMinDataElements(5);
    }

    private Coder getCoder()
    {
        try
        {
            Cciiasn.initialize();
            Coder coder = Cciiasn.getBERCoder();
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

    protected String m_airbillNumber = "";
    protected String m_shipmentOid = "";
    protected String m_handlingUnitOid = "";

    protected byte[] getMessageBytes(String data[])
    {
        ASNccii msg = new ASNccii();
        Coder coder = getCoder();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        
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
            System.out.println("failed to encode Message:  " + e);
            e.printStackTrace(System.out);
            System.exit(-1);
        }

        byte message[] = sink.toByteArray();

        return message;
        //        return getMessageBytes(data,null);
    }

    private ASNccii getMessage(String data[],ASNccii msg)
    {
        // Static values
        msg.setReturnStatus(new IA5String("0"));
        msg.setReturnMessage(new IA5String("Input Message"));
        msg.setErrorNumber(new IA5String("0"));
        msg.setTransTimeStamp(new IA5String("" + (System.currentTimeMillis()/1000)));

        for(int i=0;i<data.length;i++)
        {
            switch(i)
            {
            case 0:
                msg.setRequestingProj(new IA5String(data[i]));
                break;
            case 1:
                msg.setRequestedSvc(new IA5String(data[i]));
                break;
            case 2:
                msg.setUserLogon(new IA5String(data[i]));
                break;
            case 3:
                msg.setLocationCode(new IA5String(data[i]));
                break;
            case 4:
                m_airbillNumber = data[i];
                msg.setAirbillNumber(new IA5String(data[i]));
                break;               
        // Optional Values from file
            case 5:
                msg.setOrgCode(new IA5String(data[i]));
                break;
            case 6:
                msg.setInputDevice(new IA5String(data[i]));
                break;
            case 7:
                msg.setOriginLoc(new IA5String(data[i]));
                break;
            case 8:
                msg.setDestLoc(new IA5String(data[i]));
                break;
            case 9:
                msg.setInputDate(new IA5String(data[i]));
                break;
            case 10:
                msg.setHawbSerialNbr(new IA5String(data[i]));
                break;
            case 11:
                {
                    long poid = Long.parseLong(data[i]);
                    if(poid == -1)
                    {
                        poid = getPieceOidNbr(m_airbillNumber);
                    }
                    m_handlingUnitOid = "" + poid;
                    msg.setHandlingUnitOid(new IA5String("" + poid));
                }
                break;
            case 12:
                {
                    String hawb = data[i];
                    if(hawb.equals("Master"))
                    {
                        hawb = msg.getAirbillNumber().stringValue();
                    }
                    msg.setHawb(new IA5String(hawb));
                }
                break;
            case 13:
                {
                    long soid = Long.parseLong(data[i]);
                    if(soid == -1)
                    {
                        soid = getShipmentOidNbr(msg.getHawb().stringValue());
                    }
                    m_shipmentOid = "" + soid;
                    msg.setShipmentOid(new IA5String("" + soid));
                }
                break;
            case 14:
                msg.setHawbUnknownFlag(new IA5String(data[i]));
                break;
            case 15:
                msg.setReasonCode(new IA5String(data[i]));
                break;
            case 16:
                msg.setDetainLoc(new IA5String(data[i]));
                break;
            case 17:
                msg.setReleaseCode(new IA5String(data[i]));
                break;
            case 18:
                msg.setReturnHAWBNbr(new IA5String(data[i]));
                break;
            case 19:
                msg.setHandlingInstrCode(new IA5String(data[i]));
                break;
            case 20:
                msg.setHandlingInstrDesc(new IA5String(data[i]));
                break;
            case 21:
                msg.setInterceptCode(new IA5String(data[i]));
                break;
            case 22:
                msg.setAgencyCode(new IA5String(data[i]));
                break;
            case 23:
                msg.setStrTranDate(new IA5String(data[i]));
                break;
            case 24:
                msg.setStrTranTime(new IA5String(data[i]));
                break;
            case 25:
                msg.setCommentText(new IA5String(data[i]));
                break;
            case 26:
                msg.setLocStatNbr(new IA5String(data[i]));
                break;
            case 27:
                msg.setEntryTypeCode(new IA5String(data[i]));
                break;
            default:
                System.out.println("Unexpected Data Element Number:  " + i + " on line:  " + m_lineNumber);
                break;
            }
        }
     
        return msg;
    }



    
    protected long getShipmentOidNbr(String awb)
    {
        return getOid("ENT.SHIPMENT","SHIPMENT_OID_NBR","AWB_NBR",awb);
    }

    protected long getPieceOidNbr(String trkNbr)
    {
        return getOid("ENT.PIECE","PIECE_OID_NBR","TRACKING_NBR",trkNbr);
    }

    private Connection m_conn = null;

    protected void getConnection() throws Exception
    {
        if(m_conn == null)
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            m_conn = DriverManager.getConnection("jdbc:oracle:thin:@" + m_config.getString("DBCONFIG_JDBC_SERVER_URL"),
                                                 m_config.getString("DBCONFIG_JDBC_USER"),
                                                 m_config.getString("DBCONFIG_JDBC_PASSWORD"));
        }
    }


    protected long getOid(String tableName,String oidColumn,String trkNbr,String value)
    {
        long retVal = -1;
            
        String sql = "select " + oidColumn + " from " + tableName + " where " + trkNbr + " = ? ";

        try
        {            
            //            Connection conn = m_lookup.lookupConnection("ccii.LookupDS");
//             DataSource ds = (DataSource)m_lookup.lookup("ccii.LookupDS");

//             Connection conn = ds.getConnection();

//            Connection conn = getConnection();
            
            PreparedStatement ps = m_conn.prepareStatement(sql);
            
            ps.setString(1,value);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                retVal = rs.getLong(1);
            }
            
            rs.close();
            ps.close();
//            conn.close();
        }
        catch(Exception sqle)
        {
            System.out.println("Failed to get OID with SQL: [" + sql + "]" );
            System.out.println("                oidColumn : [" + oidColumn + "]" );
            System.out.println("                tableName : [" + tableName + "]" );
            System.out.println("                   trkNbr : [" + trkNbr + "]" );
            System.out.println("                    value : [" + value + "]" );
            sqle.printStackTrace(System.out);
            throw new RuntimeException("Failed to get OID with SQL:  " + sql,sqle);
        }

        // System.out.println("Returning oid " + retVal + " for trkNbr:  " + value);

        return retVal;
    }

        


    public void executeTest() throws Exception
    {
        getConnection();
     
        super.executeTest();

	m_conn.close();
    }


    public static void main(String args[]) throws Exception
    {
        main(new ImportTestClient(),args);
    }
}
