package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

public class TuxWSWrapper implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: TuxWSWrapper.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  static
  {
    //System.load("J:\\TempClient\\jtxtran.dll");
    System.loadLibrary("jtxtran");
  }
  public TuxWSWrapper()
  {
  }
  private String returnMessage;

  public native int TuxInit(String userName, String password, String clientName);
  public native int TuxDone();
  public native int TuxAMessage(String svcName,String inMsg,int flag);
  public native int TuxGetReply(int code,int flag);
  public native int TuxMessage(String svcName,String inMsg);
  public native int TestFunction(String msg1);
  public void setReturnMessage(String newMessage)
  {
    returnMessage = newMessage;
  }
  public String getReturnMessage()
  {
    return returnMessage;
  }

  public static void main(String[] args)
  {
    String inString = "This is A Test";
    TuxWSWrapper tuxWSWrapper1 = new TuxWSWrapper();
    tuxWSWrapper1.TestFunction(inString);
    //System.out.println(inString + " " + tuxWSWrapper1.getReturnMessage());
    tuxWSWrapper1.TuxInit("TestUser","password","JavaTest");
    //System.out.println("Called Tux Init");
    tuxWSWrapper1.TuxDone();
    //System.out.println("Called Tux Done");
  }
}