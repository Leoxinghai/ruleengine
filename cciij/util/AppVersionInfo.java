package cciij.util;

import weblogic.common.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import java.io.*;
import java.net.*;
import java.lang.reflect.*;

import cciij.util.*;
import rmtc.util.*;

/**
 * Title:        Application Version Information<br>
 * Description:  This class is used to output the contents of the manifest in a jar file.
 *               Although not currently used, this class does implement and conform to 
 *               the standard for being used as a Startup class in WebLogic, so that
 *               it can be used in the future to output manifest information automatically
 *               when the WebLogic server boots. 
 *               <BR>
 * Copyright:    Copyright (c) 2003<BR>
 * Company:      FedEx<BR>
 * @author Joey Cline
 * @version 1.0                                                          <BR>
 * <BR>
 * <BR>
 * Version History:<br>
 *    <UL>
 *        <LI>1.0 - Original Version
 *    </UL>
 * <BR>
 */
public class AppVersionInfo implements T3StartupDef
{
  private T3ServicesDef m_services;
  private PrintStream m_outputDest;
  private rmtc.util.Config m_config;

  /**
   * Default constructor; all output will go to System.out
   */
  public AppVersionInfo()
  {
    this(System.out);
  }

  /**
   * Invoke this constructor if you want to set a different output destination
   * @param outputDest the output destination for this object; if null, System.out is selected
   */
  public AppVersionInfo(PrintStream outputDest)
  {
    m_config = new rmtc.util.Config("AppVersionInfo");

    if ( outputDest != null )
    {
      m_outputDest = outputDest;
    }
    else
    {
      m_outputDest = System.out;
    }
  }

  public void setServices(T3ServicesDef services)
  {
    m_services = services;
  }

  /**
   * This is the method automatically invoked by the WebLogic startup procedure
   */
  public String startup(String name, Hashtable args)
         throws Exception
  {
    dumpProperties(m_config.getBoolean("VERSIONINFO_DUMP_PROPERTIES", true));
    dumpJarFileManifest(m_config.getValue("VERSIONINFO_FILE_CONTAINING_MANIFEST","applications/CCIIApplication.ear"), 
			m_config.getBoolean("VERSIONINFO_DUMP_MANIFEST", true));

    return "ok";
  }

  /**
   * This method dumps either the entire System properties, or only hard-coded select values
   * @param out the PrintWriter from the servlet to output the HTML into
   * @param doSelectOnly if true, only the hard-coded System properties entries will be displayed
   */
  public void dumpPropertiesAsHTML (PrintWriter out,boolean doSelectOnly)
  {
    Properties props = System.getProperties();

    out.println("<TABLE border=1 cellspacing=2 cellpadding=2>");
    out.println("<TH colspan=2><h2>Java and JVM Properties</h2></TH>");

    if ( doSelectOnly )
    {
      String[] propsToPrint = {
        "java.vm.specification.version",
        "java.vm.specification.vendor",
        "java.vm.specification.name",
        "java.vm.version",
        "java.vm.vendor",
        "java.vm.name",
        "java.version",
        "java.vendor",
        "java.specification.version",
        "java.specification.name",
        "java.specification.vendor"
      };

      for ( int ndx = 0; ndx < propsToPrint.length; ndx++ )
      {
        out.println("<TR>");
        out.println("<TD>" + propsToPrint[ndx] + "</TD>");
        out.println("<TD>" + props.getProperty(propsToPrint[ndx], "NOT DEFINED") + "</TD>");
        out.println("</TR>");
      }
    }
    else
    {
      Enumeration enum = props.propertyNames();

      while ( enum.hasMoreElements() )
      {
	String key = (String) enum.nextElement();
        out.println("<TR>");
        out.println("<TD>" + key + "</TD>");
        out.println("<TD>" + props.getProperty(key, "NOT DEFINED") + "</TD>");
        out.println("</TR>");
      }
    }
    out.println("</TABLE>");
  }

  /**
   * This method dumps either the entire System properties, or only hard-coded select values
   * @param doSelectOnly if true, only the hard-coded System properties entries will be displayed
   */
  public void dumpProperties (boolean doSelectOnly)
  {
    Properties props = System.getProperties();

    if ( doSelectOnly )
    {
      String[] propsToPrint = {
        "java.vm.specification.version",
        "java.vm.specification.vendor",
        "java.vm.specification.name",
        "java.vm.version",
        "java.vm.vendor",
        "java.vm.name",
        "java.version",
        "java.vendor",
        "java.specification.version",
        "java.specification.name",
        "java.specification.vendor"
      };


      m_outputDest.println ( "-----------------------------------------------------" );
      m_outputDest.println ( "-----------   Java and JVM properites  --------------" );
      m_outputDest.println ( "-----------------------------------------------------" );
      for ( int ndx = 0; ndx < propsToPrint.length; ndx++ )
      {
        m_outputDest.println ( propsToPrint[ndx] + " = [" + props.getProperty(propsToPrint[ndx], "NOT DEFINED") +"]" );
      }
      m_outputDest.println ( "-----------------------------------------------------" );
    }
    else
    {
      props.list(m_outputDest);
    }
  }

  /**
   * This method dumps either the entire manifest contents, or only hard-coded select values, for the specified jar
   * @param out the PrintWriter from the servlet to output the HTML into
   * @param jarFileName name of the jar file to get the manifest from
   */
  public void dumpJarFileManifestAsHTML(PrintWriter out, String jarFileName)
  {
    try
    {
      JarFile jarFile = new JarFile ( jarFileName );

      out.println("<TABLE border=1 cellspacing=2 cellpadding=2>");
      out.println("<TH colspan=2><h2>Manifest info for " + jarFile.getName() + "</h2></TH>");

      dumpManifestInfoAsHTML ( out, jarFile.getManifest() );

      out.println("</TABLE>");
    }
    catch(Exception e)
    {
      e.printStackTrace(System.err);
    }
  }

  /**
   * This method dumps either the entire manifest contents, or only hard-coded select values, for the specified jar
   * @param jarFileName name of the jar file to get the manifest from
   * @param doSelectOnly if true, only the hard-coded manifest entries will be displayed
   */
  public void dumpJarFileManifest(String jarFileName, boolean doSelectOnly)
  {
    try
    {
      JarFile jarFile = new JarFile ( jarFileName );

      m_outputDest.println ( "===========================================" );
      m_outputDest.println ( "Manifest info for " + jarFile.getName() );
      dumpManifestInfo ( jarFile.getManifest(), doSelectOnly );
      m_outputDest.println ( "===========================================" );
    }
    catch(Exception e)
    {
      e.printStackTrace(System.err);
    }
  }

  /**
   * This class can be invoked from the command line to output the manifest information.
   */
  public static void main( String [] s)
  {

    AppVersionInfo theApp = new AppVersionInfo();

    try
    {
      theApp.startup(null, null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * This method dumps either the entire manifest contents, or only hard-coded select values
   * @param out the PrintWriter from the servlet to output the HTML into
   * @param mfst the manifest object retrieved from the jar file
   */
  protected void dumpManifestInfoAsHTML (PrintWriter out, Manifest mfst)
  {
      String[] mfstToPrint = {
        "Implementation-Title",
        "Implementation-Vendor",
        "Implementation-Version",
        "Specification-Title",
        "Specification-Vendor",
        "Specification-Version",
        "WebLogic-Build-Dir",
        "Created-By",
        "Built-By",
        "Installation-Location",
        "Sealed",
        "Signature-Version",
        "Release-Note"
      };

      Attributes attribs = mfst.getMainAttributes();
      for ( int ndx = 0; ndx < mfstToPrint.length; ndx++ )
      {
        String temp = attribs.getValue (mfstToPrint[ndx]);
        if ( temp != null )
        {
          out.println("<TR>");
          out.println("<TD>" + mfstToPrint[ndx] + "</TD>");
          out.println("<TD>" + temp + "</TD>");
          out.println("</TR>");
        }
      }
  }

  /**
   * This method dumps either the entire manifest contents, or only hard-coded select values
   * @param mfst the manifest object retrieved from the jar file
   * @param doSelectOnly if true, only the hard-coded manifest entries will be displayed
   */
  protected void dumpManifestInfo (Manifest mfst, boolean doSelectOnly)
  {
    if ( doSelectOnly )
    {
      String[] mfstToPrint = {
        "Implementation-Title",
        "Implementation-Vendor",
        "Implementation-Version",
        "Specification-Title",
        "Specification-Vendor",
        "Specification-Version",
        "WebLogic-Build-Dir",
        "Created-By",
        "Built-By",
        "Installation-Location",
        "Sealed",
        "Signature-Version",
        "Release-Note"
      };

      Attributes attribs = mfst.getMainAttributes();
      for ( int ndx = 0; ndx < mfstToPrint.length; ndx++ )
      {
        String temp = attribs.getValue (mfstToPrint[ndx]);
        if ( temp != null )
        {
          m_outputDest.println ( mfstToPrint[ndx] + " = " + temp );
        }
      }
    }
    else
    {
      m_outputDest.println ( "Dumping all manifest entries..." );
      try
      {
        mfst.write(m_outputDest);
      }
      catch (IOException ioe)
      {
      }
    }
  }

  /**
   * This method determines which packages will have manifest and detailed class version output
   * @param doSelectOnly if true, only the hard-coded packages will be displayed
   * @param dumpEntireManifest if true, the entire manifest contents will be displayed
   */
  protected void dumpPackages (boolean doSelectOnly, boolean dumpEntireManifest)
  {
    if ( doSelectOnly )
    {
      String[] pckgsToPrint = {
        "cciij.businessActions"
      };

      for ( int ndx = 0; ndx < pckgsToPrint.length; ndx++ )
      {
        Package pkg = Package.getPackage(pckgsToPrint[ndx]);

        if ( pkg != null )
        {
          // dumpMetaInfo(pkg);
        }
        find (pckgsToPrint[ndx], dumpEntireManifest);
      }
    }
    else
    {
      Package[] pckgs = Package.getPackages();

      for ( int ndx = 0; ndx < pckgs.length; ndx++ )
      {
        m_outputDest.println (pckgs[ndx]);
        find (pckgs[ndx].getName(), dumpEntireManifest);
      }
    }

  }

  /**
   * This method finds the resource that contains the package specified and outputs its manifest
   * @param pckgname name of the package to find the jar file for to get the manifest from
   * @param doSelectOnly if true, only the hard-coded manifest entries will be displayed
   */
  protected void find(String pckgname, boolean doSelectOnly)
  {
    pckgname = pckgname.replace('.','/');

    String name = new String(pckgname);
    if (!name.startsWith("/")) {
        name = "/" + name;
    }

    // Get a File object for the package
    try
    {
      URL url = AppVersionInfo.class.getResource(name);
      m_outputDest.println ("url is " + url.getPath());
      m_outputDest.println ("url name is " + url.getFile());

      String filename = url.getFile();
      int exclLoc = filename.indexOf('!');
      if ( exclLoc > 0 )
      {
        filename = filename.substring(0, exclLoc);
      }
      m_outputDest.println ("filename is " + filename);

      File directory = new File(filename);
      m_outputDest.println ("directory is " + directory);

      JarFile jfile = new JarFile ( directory );

      m_outputDest.println ( "===========================================" );
      m_outputDest.println ( "Manifest info for " + jfile.getName() );
      dumpManifestInfo ( jfile.getManifest(), doSelectOnly );
      m_outputDest.println ( "===========================================" );
    }
    catch(Exception e)
    {
      e.printStackTrace(System.err);
    }
  }
}
