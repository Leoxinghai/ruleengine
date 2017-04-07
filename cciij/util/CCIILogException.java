package cciij.util;


import java.util.*;

public class CCIILogException extends Exception {

    private String m_messageString = "";
    private String m_configString = "";

    public CCIILogException() {
        super();
        m_messageString = "Uknown Error";
        m_configString  = "DEFAULT_SEVERITY";
    }

    public CCIILogException(String configString, String messageString)
    {
        this(configString,messageString,null);
    }

    public  CCIILogException(String configString, String messageString,Throwable t) {
        super(messageString); 
        if ( configString == null ) {
            m_configString  = "DEFAULT_SEVERITY";
        }
        else {
            m_configString = configString;
        }

        if ( messageString == null ) {
            m_messageString  = "Uknown Error";
        }
        else {
            m_messageString = messageString;
        }

        if(t != null)
        {
            initCause(t);
        }
    }

    public String getConfigString() {
        return m_configString;
    }

    public String getMessageString() {
        return m_messageString;
    }


    public static void main(String[] args){
        System.out.println("CCIILogException in main");

        try {
            throw new CCIILogException("BAD_THINGS_GOIN_ON","CHECKEM OUT");
        }
        catch (CCIILogException lx) {
            lx.printStackTrace();

        }


        System.out.println("Leaving CCIILogException");
    }



}
