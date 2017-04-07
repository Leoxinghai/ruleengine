package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */
import java.net.*;
import java.util.*;
import java.io.*;
import weblogic.common.*;


public class CheckURL implements T3StartupDef, Runnable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CheckURL.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected static Vector m_URLVector = new Vector();
  protected Integer m_threadCounter = new Integer(0);
  protected long m_millisecondDelayTime = 10000;
  protected boolean m_verbose = false;
  protected boolean m_file = false;
  protected String m_fileName = "";
  protected String m_serverName = "";

  public CheckURL()
  {
  }

  public void setServices(T3ServicesDef services)
  {
  }

  /**
   * Bind selected values into the Naming Service.
   */
  public String startup(String name, Hashtable args) throws Exception
  {
    System.out.println("Startup class invoked - " + name);
    //System.out.println("reading in argument variables that were passed in");
    String key;
    String value;
    key = "DELAYTIME";
    value = (String) args.get(key);
    if (value != null)
    {
     try
     {
       m_millisecondDelayTime = Long.parseLong(value);
     }
     catch (Exception e)
     {
      System.out.println("Caught an exception while trying format delay time");
     }
     args.remove(key);
    }
    key = "VERBOSE";
    value = (String) args.get(key);
    if (value != null)
    {
     try
     {
       if (value.equalsIgnoreCase("TRUE"))
          m_verbose = true;
       else
          m_verbose = false;
     }
     catch (Exception e)
     {
      System.out.println("Caught an exception while trying format verbose time");
     }
     args.remove(key);
     key = "FILE";
     value = (String) args.get(key);
     if (value != null)
     {
        try
        {
         if (value.equalsIgnoreCase("TRUE"))
            m_file = true;
         else
            m_file = false;
        }
        catch (Exception e)
        {
          System.out.println("Caught an exception while trying format FILE");
        }
        args.remove(key);
      }
    }
    key = "FILENAME";
    value = (String) args.get(key);
    if (value != null)
    {
      m_fileName = value;
      args.remove(key);
    }
    key = "SERVERNAME";
    value = (String) args.get(key);
    if (value != null)
    {
      m_serverName = value;
      args.remove(key);
    }
    if (m_file)
    {
      readURLsFromFile();
    }
    else
    {
      readURLsFromArgs(args);
    }
    //System.out.println("Done sorting out arguments");
    //System.out.println("Old thread starting new thread to check URL's");
    synchronized (m_threadCounter)
    {
      m_threadCounter = new Integer(m_threadCounter.intValue() + 1);
      Thread newThread = new Thread(this);
      newThread.start();
    }
    //System.out.println("Old thread, new thread started, exiting now");
    return "ok";
  }

  public void readURLsFromFile()
  {
    BufferedReader reader;
    if(m_verbose)
    {
      System.out.println("filename: " + m_fileName);
      System.out.println("serverName: " + m_serverName);
    }
    try
    {
      java.net.URL fileURL = CheckURL.class.getResource(m_fileName);
      reader = new BufferedReader(new InputStreamReader(fileURL.openStream()));
    } catch (Exception e)
    {
      System.out.println("Unable to open filestream");
      e.printStackTrace();
      return;
    }
    String url;
    String fileLine;
    synchronized (m_URLVector)
    {
      try
      {
        while(((fileLine = reader.readLine()) != null))
        {
          if((fileLine.length() <= 0)
             || (fileLine.charAt(0) == '#'))
          {
              continue;
          }
          url = "http://" + m_serverName + fileLine.trim();
          m_URLVector.add(url);
        }
      } catch (Exception e)
      {
        System.out.println("caught exception during file read");
      }
    }
  }

  public void readURLsFromArgs(Hashtable args)
  {
    String baseKeyValue= "URL";
    String key;
    String value;
    synchronized (m_URLVector)
    {
      boolean startThread = !m_URLVector.isEmpty();
      int hashtableSize = args.size();
      for (int i = 0; i <= hashtableSize; i++ )
      {
        //look for variables in the format that I am expecting
        key = baseKeyValue + String.valueOf(i).trim();
        value = (String)args.get(key);
        if (value != null)
        {
           //System.out.println("URL loop, URL Key: " + key + " URL Value: " + value );
           m_URLVector.add(value);
           //remove the entry now that I have sorted it out of the hash table
           args.remove(key);
        }
      }
      //look for anything else that has a URL as the key
      Vector keyVector = new Vector();
      Enumeration keys = args.keys();
      while(keys.hasMoreElements())
      {
        key = (String)keys.nextElement();
        value = (String)args.get(key);
        if (key != null && key.length() > 2)
        {
          String key3 = key.substring(0,3);
          if (key3.equalsIgnoreCase("URL"))
          {
            //System.out.println("URL search, URL Key: " + key + " URL Value: " + value );
            m_URLVector.add(value);
            //add key to a vector so you can remove it later.
            keyVector.add(key);
          }
        }
      }
      for (Iterator it = keyVector.iterator();it.hasNext();)
      {
        //remove all the entries we have already processed
        args.remove((String)it.next());
      }
      //Now see if there is anything left in the hashtable
      if (args.size() > 0)
      {
        Enumeration moreKeys = args.keys();
        while(keys.hasMoreElements())
        {
          key = (String)keys.nextElement();
          value = (String)args.get(key);
          System.out.println("CheckURL: Don't know what to do with there arguments, Key: " + key + " value: " + value);
        }
      }
    }
  }
  public void lookupURLVector(Vector urlVector)
  {
    synchronized (m_URLVector)
    {
      if (m_URLVector.isEmpty())
      {
        m_URLVector = urlVector;
      }
      else
      {
        for (Iterator it = urlVector.iterator();it.hasNext();)
        {
          m_URLVector.add(it.next());
        }
      }
      Thread newThread = new Thread(this);
      newThread.start();
    }
  }

  public String lookupIndividualURL(String urlString)
  {
    URL url = null;
    URLConnection urlConnect = null;
    String httpPage = "";
    String tempString = "";
    String pageText = "Page error";
    long startTime = System.currentTimeMillis();

    try
    {
      if (m_verbose)
         System.out.println("Looking up: " + urlString );
      //System.out.println("creating URL");
      url = new URL(urlString);
      //System.out.println("Opening Conneciton");
      urlConnect = url.openConnection();
      //System.out.println("Setting usesCaches to false");
      urlConnect.setUseCaches(false);
      //System.out.println("Connecting");
      urlConnect.connect();
      //System.out.println("Getting content");
      //Object obj = urlConnect.getContent();
      pageText = getPageText(urlConnect);
      //System.out.println(pageText);
      //System.out.println("finished getting content");
    }
    catch (MalformedURLException mfurl)
    {
      System.out.println("caught a malformed URL exception looking up " + urlString);
      mfurl.printStackTrace();
      return "Malformed URL Exception";
    }
    catch (java.io.IOException ioex)
    {
      System.out.println("caught an IO exception while trying to access URL " + urlString);
      ioex.printStackTrace();
      return "IOException";
    }
    //System.out.println("Total time to make the request: " + (System.currentTimeMillis() - startTime) + " (msec)");
    return pageText;
  }

  public String getPageText(URLConnection urlConnect)
  {
    StringBuffer wholePage = new StringBuffer("");
    try
    {
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));
      String line;
      while ((line = in.readLine()) != null)
      {
        wholePage.append(line);
        wholePage.append("\n");
      }
    } catch (IOException ioex)
    {
      System.out.println("Caught an IO exception while trying to read the text of the URL page");
      ioex.printStackTrace();
    }
    return wholePage.toString();
  }

  public void run()
  {
    //System.out.println("New thread started");
    //System.out.println("New thread going to sleep to allow the weblogic server to finish startup");
    try
    {
      Thread.sleep(m_millisecondDelayTime); //sleep for 10 seconds
    }catch (InterruptedException ie)
    {
      System.out.println("startup class: caught an interrupted exception while trying to sleep");
    }
    long startTime = System.currentTimeMillis();
    //System.out.println("New thread waking up to check urls");
    String pageString;
    String url;
    boolean continueLoop;
    //if (m_verbose)
    {
      System.out.println("CheckURL startup class thread waking up to run.");
      System.out.println("The server is fully up and available, you do not have to wait till this startup class finishes");
      System.out.println("This startup class will go out and touch all of the jsp files so that "
         + "it forces weblogic to precompile and load all the jsp files. "
         + "In the process of asking for the jsp files, it will cause three known errors where the system will complain "
         + "about not being able to find certain beans and creating new ones.  These are expected errors and no action "
         +" needs to be taken.");
    }
    synchronized (m_URLVector)
    {
      continueLoop = !m_URLVector.isEmpty();
    }
    while (continueLoop)
    {
      synchronized (m_URLVector)
      {
        try
        {
          url = (String)m_URLVector.firstElement();
          m_URLVector.remove(url);
        }
        catch (Exception ex)
        {
          break;
        }
      }
      //this method can take several seconds to complete for each call.
      //didn't want to be blocked the whole time while looping
      pageString = lookupIndividualURL(url);
      synchronized (m_URLVector)
      {
        continueLoop = !m_URLVector.isEmpty();
      }
    }
    //if (m_verbose)
       System.out.println("Startup class completed checking URLS " + (System.currentTimeMillis() - startTime) + " (msec)");
    synchronized (m_threadCounter)
    {
      m_threadCounter = new Integer(m_threadCounter.intValue() - 1);
    }
  }


  public static void main(String[] args)
  {
  }
}