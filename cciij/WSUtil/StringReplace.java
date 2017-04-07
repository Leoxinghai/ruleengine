package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

public class StringReplace implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: StringReplace.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  public static String replaceString (String incomingString, String searchString, String replaceString)
  {
    String resultString = incomingString;
    if (incomingString != null)
    {
      int location = incomingString.indexOf(searchString);
      if (location != -1)
      {
        while (location != -1)
        {
          resultString = resultString.substring(0,location)
                     + replaceString
                     + resultString.substring(location + searchString.length());
          location += replaceString.length();
          location = resultString.indexOf(searchString, location);
        }
      }

    }
    return resultString;
  }
}