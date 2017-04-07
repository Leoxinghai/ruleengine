// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CSSSocket.java

package com.fedex.css.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import rmtc.util.Config;

public class CSSSocket
{

    public CSSSocket(String s, String s1)
    {
        socket = null;
        out = null;
        in = null;
        serverHost = null;
        portStr = null;
        serverSocket = null;
        Config config = new Config();
        serverHost = s;
        portNumber = Integer.parseInt(s1);
    }

    public void createSocket(boolean flag)
        throws Exception
    {
        if(flag)
            serverSocket = new ServerSocket(portNumber);
        else
            socket = new Socket(serverHost, portNumber);
        socket.setSoTimeout(16000);
        socket.setSoLinger(true, 0);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void closeSocket()
        throws Exception
    {
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }

    public String listen()
        throws Exception
    {
        String s = in.readLine();
        return s;
    }

    public void send(String s)
        throws Exception
    {
        s = s + '\n';
        out.write(s);
        out.flush();
    }

    Socket socket;
    PrintWriter out;
    BufferedReader in;
    int portNumber;
    String serverHost;
    String portStr;
    ServerSocket serverSocket;
}
