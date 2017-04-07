package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class ScanCCIIOldTux implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ScanCCIIOldTux.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  //private static TuxWSWrapper tux = new TuxWSWrapper();
  //private String command = CCIIProperties.DEFAULT_COMMAND;
  private int currentLanguage = CCIIProperties.getDefaultSiteLanguage("ALL");
  private int defaultLanguage = CCIIProperties.getDefaultSiteLanguage("ALL");
  private int numLanguages = CCIIProperties.NUM_LANG_SUPPORTED;
  //private String langDesc(20);
  private String scanName = " ";
  private String trackingNumber = " ";
  private String hawb = " ";
  private long shipmentOid;
  private long huOid;
  private String formCode = " ";
  private String userID = " ";
  private String code = "  ";
  private String comment = " ";
  private String hawbUnknownFlag = " " ;
  private String uild = " ";
  private String returnHAWB = " ";
  private String userOrgCode = " ";
  private String inputDevice = "CCIIJava";
  private boolean async = false;
  private boolean asyncResponseNeeded = true;
  private String outputString = "";
  private int returnValue = 0;
  private int replyFlag = 0;
  private String outMessage = "";

  private ScanCCIIOldTux()
  {

  }

  public ScanCCIIOldTux(String userIdIn, String orgCodeIn)
  {
    if (userIdIn != null && !userIdIn.equals(""))
    {
      userID = userIdIn;
    }
    else
    {
      userID = " ";
    }
    if (orgCodeIn != null && userIdIn.equals(""))
    {
      userOrgCode = orgCodeIn;
    }
    else
      userOrgCode = orgCodeIn;
  }

  public void resetScanInfo()
  {
    //command = CCIIProperties.DEFAULT_COMMAND;
    currentLanguage=defaultLanguage;
    scanName = " ";
    trackingNumber= " ";
    hawb = " ";
    shipmentOid = 0;
    huOid = 0;
    formCode= " ";
    code = " ";
    comment = " ";
    hawbUnknownFlag = " ";
    uild = " ";
    returnHAWB = " ";
    userOrgCode = " ";
    async = false;
    asyncResponseNeeded = true;
  }

  public void setScanName(String newScanName)
  {

    if (newScanName != null && !newScanName.equals(""))
     scanName = newScanName;
    else
      scanName = " ";
  }

  public void setTrackingNumber (String newTracking)
  {
    if (newTracking != null && !newTracking.equals(""))
      trackingNumber = newTracking;
    else
      trackingNumber = " ";
  }

  public void setHAWBUnknownFlag(boolean flag)
  {
    hawbUnknownFlag = flag ? "T" : " ";
  }

  public void setUild(String newUild)
  {
    if (uild != null && !uild.equals(""))
      uild = newUild;
    else
      uild = " ";
  }

  public void setReturnHAWB(String newReturnHAWB)
  {
    if (newReturnHAWB != null && !newReturnHAWB.equals(""))
      returnHAWB = newReturnHAWB;
    else
      returnHAWB = " ";
  }

  public void setFormCode(String newFormCode)
  {
    if (newFormCode != null && !newFormCode.equals(""))
      formCode = newFormCode;
    else
      formCode = " ";
  }

  public void setShipmentOid(long newShipOid)
  {
    shipmentOid=newShipOid;
  }

  public void setCode(String newCode)
  {
    if (newCode != null && !newCode.equals(""))
      code = newCode;
    else
      code = " ";
  }

  public void setComment(String newComment)
  {
    if (newComment != null && !newComment.equals(""))
      comment = newComment;
    else
      comment = " ";
  }

  public void setAsync(boolean flag)
  {
    async = flag;
  }

  public void setAsyncResponseNeeded(boolean flag)
  {
    asyncResponseNeeded = flag;
  }

  public String getNextNewLineArgument()
  {
    return getNextArgument('\n');
  }

  public String getNextTabArgument()
  {
    return getNextArgument('\t');
  }

  private String getNextArgument(char delimiter)
  {
    String newArgument;
    int searchPosition;
    searchPosition = outMessage.indexOf(delimiter);
    if (searchPosition == -1) // not found
    {
      newArgument = outMessage; //send everything
      outMessage = "";
    }
    else
    {
      newArgument = outMessage.substring(0,searchPosition);
      outMessage = outMessage.substring(searchPosition + 1);
    }
    return newArgument;
  }

  public String getRemainingReturnString()
  {
    String temp = outMessage;
    outMessage = "";
    return temp;
  }

  public int createAsyncFlag()
  {
    int tempFlag = 0;
    //build async Flag
   // if (asyncResponseNeeded = false) tempFlag += CCIIProperties.DONT_NEED_RESPONCE;
    //any additional flags needed
    return tempFlag;
  }

  public void setHuOid (long newHuOid)
  {
    huOid = newHuOid;
  }

  public boolean setLanguage(int newLang)
  {
    if (newLang >0 && newLang <= CCIIProperties.NUM_LANG_SUPPORTED)
    {
      currentLanguage = newLang;
      return true;
    }
    else
      return false;
  }

  public int getLanguage()
  {
    return currentLanguage;
  }

  public int createReplyFlag()
  {
    int tempFlag = 0;
    //create the getreply flag
    //if <condition> tempFlag += SOME_CONSTANT;
    //and additional flags go here
    return tempFlag;
  }

  public void setHAWB(String newHAWB)
  {
    if (newHAWB != null && !newHAWB.equals(""))
      hawb = newHAWB;
    else
      hawb = " ";

  }

  public boolean downloadErrorCodes()
  {
  /** @todo  downloadErrorCodes
   //SEH:: implement later
   */
   return false;
  }


  public boolean downloadLanguages()
  {
    /** @todo downloadLanguages
    //SEH:: implement later
    * */
    return false;
  }

  public boolean resolveDup( int emErrorNum)
  {
    /** @todo ResolveDup
    //SEH:: implement later
    * */
    return false;
  }

  public int getReturnValue()
  {
    return returnValue;
  }

  public boolean process()
  {
    String msg = "";
    int asyncFlag = 0;

   // msg += command + "\t";
    msg += currentLanguage + "\t";;
    msg += scanName + "\t";
    msg += inputDevice + "\t";
    msg += userOrgCode + "\t";
    msg += trackingNumber + "\t";
    msg += hawb + "\t";
    msg += shipmentOid + "\t";
    msg += huOid + "\t";
    msg += formCode + "\t";
    msg += userID + "\t";
    msg += code + "\t";
    msg += comment + "\t";
    msg += hawbUnknownFlag + "\t";
    msg += uild + "\t";
    msg += returnHAWB + "\t";

    if (async) asyncFlag = createAsyncFlag();

/*
    if (CCIIProperties.USE_TUX_WS_INTERFACE)
    {

      //Not sure if TuxWS is thread safe so force sychronization
      //This may cause a bottleneck and sychroization is expensive so
      //if this is to be used in production, should try to verify if TuxWS
      //is thread safe.

      synchronized(this)
      {
        //TuxInit(String userName, String password, String clientName)
        //returnValue = tux.TuxInit(userID,userOrgCode,inputDevice);
        returnValue = tux.TuxMessage(CCIIProperties.MSGROUTER_SERVICE,msg);
        outMessage = tux.getReturnMessage();
        //tux.TuxDone();
      }
    }else
    {*/
      outMessage = ("0\tHave to write Jolt Interface\t");
      //System.out.println(outMessage);
    //}
    //System.out.println("Current Language = " + currentLanguage);
    //System.out.println("ScanName = " + scanName);
    //System.out.println("Msg " + msg);

    if (returnValue < 0)
    {
      //scan did not complete
      return false;
    }
    if (returnValue > 0)
    {
      if (async) // a positive return value for async is the async code
      {
        return true;
      }
      else
      {
        //returning a value greater than zero means that there an error occured
        // but there is something to look at in the out Message
        return false;
      }
    }
    resetScanInfo();
    return true;
  }

  public String getTrackingNumber()
  {
    return trackingNumber;
  }

  public boolean checkForReply(int asyncNum)
  {
    //SEH:: Implment later
    return false;
  }

  /*

  public boolean normalScan(String trackingNumber,String scanName, String code)
  {
    setTrackingNumber(trackingNumber);
    setScanName(scanName);
    setCode(code);
    return process();
  }
*/
  public static void main(String[] args)
  {
    ScanCCIIOldTux scan1 = new ScanCCIIOldTux();
    //System.out.println(scan1.getNextTabArgument());
    //System.out.println(scan1.getNextTabArgument());
    //System.out.println(scan1.getNextTabArgument());
  }
}