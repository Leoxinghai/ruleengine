package cciij.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;

import java.lang.reflect.Constructor;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;


import javax.transaction.UserTransaction;


import rmtc.util.Config;
import rmtc.util.CmdLineArgs;
import rmtc.util.JMSDestination;
import rmtc.util.JMSDestinationException;
import rmtc.util.JNDILookup;

public abstract class CCIIBatchTestClientBase
{
    //    private ByteQueueWriter m_queueWriter = new ByteQueueWriter();
    private JMSDestination m_destination = null;

    private int m_errorCount = 0;
    private int m_errorThreshold = 5;

    
    private String m_filename=null;
    private String m_className="";
    protected JNDILookup m_lookup = null;
    protected Config m_config = null;

    protected int m_sleepStartRange = 0;
    protected int m_sleepEndRange = 0;

    private static Random m_randomEngine = new Random();

    private UserTransaction m_ut=null;

    private String m_delimiter = ":";
    private String m_queueName = "Unknown";
    private String m_location = "ALL";
    protected int m_lineNumber = 0;
    protected boolean m_outputMessageContents = false;
    private int m_minDataElements=0;

    private int m_batchSize = -1;

    private boolean m_jta = true;

    public CCIIBatchTestClientBase()
    {
    }
        
    public void initialize(String args[]) throws Exception
    {
        //        init();

        String name = getClass().getName();
        int index = name.lastIndexOf('.') + 1;
        m_className = name.substring(index);
        m_filename = "./" + m_className + ".in";
        m_queueName = m_className;
        m_lookup = new JNDILookup(m_className);
        m_config = new Config(m_className);


        if(args.length > 0)
        {
            m_filename = args[0];
        }
    }


    private void init() throws Exception
    {

        //        System.out.println("Constructing new JMSDestination(" + m_queueName + ")");

        m_destination = new JMSDestination(m_queueName);

        if(m_jta == false)
        {
            m_destination.setTransacted(true);
        }

        if(m_batchSize > 0)
        {
            m_destination.setBatchSize(m_batchSize);
        }


        childInit();
    }

    protected void done() throws Exception
    {
        m_destination.close();
    }

    protected void setDefaultQueueName(String defQueueName)
    {
        m_queueName = defQueueName;
    }    

    protected void setMinDataElements(int count)
    {
        m_minDataElements = count;
    }

    protected abstract void childInit();

    protected int calcDelayTime ( int valStart, int valEnd )
    {
        int seedValue = valEnd - valStart;
        int delayTime = 0;
        if ( seedValue <= 0 )
        {
            delayTime = valStart;
        }
        else
        {
            delayTime = valStart + m_randomEngine.nextInt(seedValue);
        }
        if ( delayTime < 0 )
        {
            delayTime = 0;
        }
        return delayTime;
    }


    public void executeTest() throws Exception
    {
        //        System.out.println(getClass().getName() + ".executeTest()");

        FileReader fr = new FileReader(m_filename);
        BufferedReader br = new BufferedReader(fr);

        boolean inited = false;

        String line;
        while((line = br.readLine()) != null)
        {            
            m_lineNumber++;

            //            System.out.println("Processing Line:  " + line);

            if(line.startsWith("!"))
            {
                processDirective(line.substring(1));
            }
            else if((line.trim().length() > 0)
               && (line.startsWith("#") == false)
               && (line.startsWith("//") == false))
            {
                if(inited == false)
                {
                    init();
                    inited = true;
                }

                if(m_sleepEndRange > 0)
                {
                    Thread.sleep(calcDelayTime(m_sleepStartRange,m_sleepEndRange));                    
                }

                beginTransaction();

                executeSingleTest(line);
            
                commitTransaction();
            }
        }

        if(m_jta == false)
        {
            m_destination.commit();
        }

        System.out.println("Test Complete after processing " + m_lineNumber + " lines");

        done();
    }


    protected void processDirective(String directive)
    {
        String data[] = parseLine(directive," ");
        if(data[0].equals("MinimumTimeDelay"))
        {
            m_sleepStartRange = Integer.parseInt(data[1]);
        }
        else if(data[0].equals("MaximumTimeDelay"))
        {
            m_sleepEndRange = Integer.parseInt(data[1]);
        }
        else if(data[0].equals("QueueName"))
        {
            m_queueName=data[1];
            //            System.out.println("Just set Queue Name to:  " + m_queueName);
        }
        else if(data[0].equals("QueueLocationCode"))
        {
            m_location=data[1];
        }
        else if(data[0].equals("OutputMessageContents"))
        {
            m_outputMessageContents = (data[1].equals("ON"));
        }
        else if(data[0].equals("BatchSize"))
        {
//             try
//             {
                m_jta = false;
                m_batchSize = Integer.parseInt(data[1]);
//                 m_destination.setTransacted(true);
//                 m_destination.setBatchSize(Integer.parseInt(data[1]));
//             }
//             catch(JMSDestinationException jde)
//             {
//                 System.out.println("Ignoring Failure to set batchSize:  " + jde);
//                 jde.printStackTrace(System.out);
//             }
        }
        else
        {
            System.out.println("**********************************");
            System.out.println("**********************************");
            System.out.println("**  Unknown Directive:  " + data[0] + "  **");
            System.out.println("**  Found on Line #:  " + m_lineNumber + "  **");
            System.out.println("**********************************");
            System.out.println("**********************************");
            
        }
    }

    protected void beginTransaction() throws Exception
    {
        if(m_jta)
        {
            m_ut = (UserTransaction)m_lookup.lookup("javax.transaction.UserTransaction");
            m_ut.begin();
        }
    }

    protected void commitTransaction() throws Exception
    {
        if(m_jta)
        {
            if(m_ut != null)
            {
                m_ut.commit();
            }
            m_ut = null;
        }
    }

    private final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";
    private SimpleDateFormat m_dateFormatter = new SimpleDateFormat (DEFAULT_DATE_FORMAT);
    private int m_numberProcessed = 0;


    protected abstract byte[] getMessageBytes(String data[]);

    protected String[] parseLine(String line,String delimiter)
    {
        StringTokenizer tokens = new StringTokenizer(line,delimiter);
        Vector strings = new Vector();
        while(tokens.hasMoreTokens())
        {
            strings.add(tokens.nextToken());
        }
        
        String data[] = new String[strings.size()];
        data = (String[])strings.toArray(data);
        
        return data;
    }


    public void executeSingleTest(String line)
    {
        try
        {
            String data[] = parseLine(line,m_delimiter);

            if(data.length < m_minDataElements)
            {
                throw new Exception("Not enough data elements:  Required:  " + m_minDataElements + " Line # " + m_lineNumber + " only contains " + data.length);
            }
            else
            {
                byte msg[] = getMessageBytes(data);
                if(msg.length > 0)
                {
                    if(m_outputMessageContents)
                    {
                        System.out.println("Message:  \n" + new String(msg));
                    }
                    //                m_queueWriter.putOnQueue(m_queueName,m_location,msg);            
                    m_destination.putBytesMessage(msg);
                }
            }
        }
        catch(Exception e)
        {
            m_errorCount++;
            System.out.println("Failed to send a message to import:  " + e);
            e.printStackTrace(System.out);
            if(m_errorCount > m_errorThreshold)
            {
                throw new RuntimeException("Error Count Exceeded.  " ,e);
            }
        }
    }


    public static void main(CCIIBatchTestClientBase client,String args[]) throws Exception
    {
        System.out.println("CCIIBatchTestClientBase.main()");

//         Class classArgs[] = new Class[0];
//         //        classArgs[0] = args.getClass();

//         Constructor constr = getClassType().getConstructor(classArgs);

//         Object objArgs[] = new Object[0];
//         //        objArgs[0] = args;

//         CCIIBatchTestClientBase client = (CCIIBatchTestClientBase)constr.newInstance(objArgs);

        //        ImportTestClient client = new ImportTestClient(args);

        client.initialize(args);

        client.executeTest();

        client = null;

        System.gc();
        System.out.println("End of main()");
    }

}