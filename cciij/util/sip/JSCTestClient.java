// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JSCTestClient.java

package cciij.util.sip;

import java.io.*;
import rmtc.util.StopWatch;

// Referenced classes of package cciij.util.sip:
//            JSIPConverter

public class JSCTestClient
{

    public JSCTestClient(String application, String location, String logonId, String password, String newPassword)
    {
        JSIPConverter converter = new JSIPConverter();
        if(newPassword.equals(""))
        {
            for(int x = 0; x < 10; x++)
            {
                System.out.println("Do logon...");
                timer.split();
                System.out.println(timer);
                converter.logon(logonId, password, application, location);
                if(converter.getErrorNumber() == 0)
                {
                    String ACL = converter.getAccessList();
                    System.out.println("the ACL for user " + logonId + " is:");
                    System.out.println(ACL);
                    String orgCode = converter.getOrgCode();
                    System.out.println("Org. Code = " + orgCode);
                } else
                {
                    System.out.println("Error #" + converter.getErrorNumber() + " logging on.");
                }
                timer.split();
                System.out.println("Logon completed...");
                System.out.println(timer);
            }

        } else
        {
            converter.changePassword(logonId, application, password, newPassword, location);
            if(converter.getErrorNumber() == 0)
                System.out.println("Password for user " + logonId + " has been changed.");
            else
                System.out.println("Error #" + converter.getErrorNumber() + " while changing password.");
        }
    }

    public static void main(String args[])
    {
        try
        {
            FileWriter fw = new FileWriter("xyz123.txt");
            fw.write("this is a test");
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("======== Start =========");
        timer = new StopWatch();
        timer.start();
        timer.split();
        System.out.println(timer);
        JSCTestClient jSCTestClient;
        if(args.length == 4)
            jSCTestClient = new JSCTestClient(args[0], args[1], args[2], args[3], "");
        else
        if(args.length == 5)
        {
            jSCTestClient = new JSCTestClient(args[0], args[1], args[2], args[3], args[4]);
        } else
        {
            System.out.println("Error - syntax is:");
            System.out.println("java fedex.ccii.sip.JSCTestClient application location logonId password newpassword");
        }
        timer.stop();
        System.out.println(timer);
        System.out.println("+++++++++++ Done! ++++++++++");
    }

    private static StopWatch timer = null;

}
