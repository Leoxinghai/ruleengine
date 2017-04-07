// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SimpleNotify.java

package cciij.util;


// Referenced classes of package cciij.util:
//            Notify

public class SimpleNotify extends Notify
{

    public SimpleNotify()
    {
    }

    public SimpleNotify(String a_name)
    {
        super(a_name);
    }

    public boolean trace_Service(int ai_code)
    {
        return trace(1, ai_code);
    }

    public boolean trace_Service(int ai_code, Object o1)
    {
        return trace(1, ai_code, o1);
    }

    public boolean trace_Service(int ai_code, Object o1, Object o2)
    {
        return trace(1, ai_code, o1, o2);
    }

    public boolean trace_Service(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(1, ai_code, o1, o2, o3);
    }

    public boolean trace_Service(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_4S_UNKNOWN_CODE()
    {
        return trace(1, 0);
    }

    public boolean trace_Service_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(1, 0, o1);
    }

    public boolean trace_Service_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(1, 0, o1, o2);
    }

    public boolean trace_Service_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(1, 0, o1, o2, o3);
    }

    public boolean trace_Service_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 0, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVER_BOOTING()
    {
        return trace(1, 1);
    }

    public boolean trace_Service_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(1, 1, o1);
    }

    public boolean trace_Service_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(1, 1, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(1, 1, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 1, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(1, 2);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(1, 2, o1);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(1, 2, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(1, 2, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 2, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(1, 3);
    }

    public boolean trace_Service_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(1, 3, o1);
    }

    public boolean trace_Service_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(1, 3, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(1, 3, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 3, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_CLIENT_BOOTING()
    {
        return trace(1, 4);
    }

    public boolean trace_Service_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(1, 4, o1);
    }

    public boolean trace_Service_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(1, 4, o1, o2);
    }

    public boolean trace_Service_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(1, 4, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 4, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(1, 5);
    }

    public boolean trace_Service_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(1, 5, o1);
    }

    public boolean trace_Service_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(1, 5, o1, o2);
    }

    public boolean trace_Service_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(1, 5, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 5, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_CALLING_GETSERVICE()
    {
        return trace(1, 6);
    }

    public boolean trace_Service_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(1, 6, o1);
    }

    public boolean trace_Service_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(1, 6, o1, o2);
    }

    public boolean trace_Service_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(1, 6, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 6, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(1, 7);
    }

    public boolean trace_Service_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(1, 7, o1);
    }

    public boolean trace_Service_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(1, 7, o1, o2);
    }

    public boolean trace_Service_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(1, 7, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 7, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(1, 8);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(1, 8, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(1, 8, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(1, 8, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 8, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(1, 9);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(1, 9, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(1, 9, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(1, 9, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 9, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(1, 10);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(1, 10, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(1, 10, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(1, 10, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 10, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(1, 11);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(1, 11, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(1, 11, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(1, 11, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 11, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(1, 12);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(1, 12, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(1, 12, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(1, 12, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 12, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_3S_ACTIVATING_RESET()
    {
        return trace(1, 13);
    }

    public boolean trace_Service_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(1, 13, o1);
    }

    public boolean trace_Service_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(1, 13, o1, o2);
    }

    public boolean trace_Service_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(1, 13, o1, o2, o3);
    }

    public boolean trace_Service_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 13, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_4S_SUBSCRIBING()
    {
        return trace(1, 14);
    }

    public boolean trace_Service_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(1, 14, o1);
    }

    public boolean trace_Service_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(1, 14, o1, o2);
    }

    public boolean trace_Service_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(1, 14, o1, o2, o3);
    }

    public boolean trace_Service_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 14, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(1, 15);
    }

    public boolean trace_Service_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(1, 15, o1);
    }

    public boolean trace_Service_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(1, 15, o1, o2);
    }

    public boolean trace_Service_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(1, 15, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 15, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_3S_RESETTING()
    {
        return trace(1, 16);
    }

    public boolean trace_Service_TM_3S_RESETTING(Object o1)
    {
        return trace(1, 16, o1);
    }

    public boolean trace_Service_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(1, 16, o1, o2);
    }

    public boolean trace_Service_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(1, 16, o1, o2, o3);
    }

    public boolean trace_Service_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 16, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(1, 17);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(1, 17, o1);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(1, 17, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(1, 17, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 17, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_CHECKPOINT()
    {
        return trace(1, 18);
    }

    public boolean trace_Service_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(1, 18, o1);
    }

    public boolean trace_Service_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(1, 18, o1, o2);
    }

    public boolean trace_Service_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(1, 18, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 18, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_CHECKPOINT()
    {
        return trace(1, 19);
    }

    public boolean trace_Service_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(1, 19, o1);
    }

    public boolean trace_Service_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(1, 19, o1, o2);
    }

    public boolean trace_Service_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(1, 19, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 19, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_3S_CHECKPOINT()
    {
        return trace(1, 20);
    }

    public boolean trace_Service_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(1, 20, o1);
    }

    public boolean trace_Service_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(1, 20, o1, o2);
    }

    public boolean trace_Service_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(1, 20, o1, o2, o3);
    }

    public boolean trace_Service_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 20, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_4S_CHECKPOINT()
    {
        return trace(1, 21);
    }

    public boolean trace_Service_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(1, 21, o1);
    }

    public boolean trace_Service_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(1, 21, o1, o2);
    }

    public boolean trace_Service_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(1, 21, o1, o2, o3);
    }

    public boolean trace_Service_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 21, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_3S_DEBUG_MSG()
    {
        return trace(1, 22);
    }

    public boolean trace_Service_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(1, 22, o1);
    }

    public boolean trace_Service_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(1, 22, o1, o2);
    }

    public boolean trace_Service_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(1, 22, o1, o2, o3);
    }

    public boolean trace_Service_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 22, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_DATA_OUTPUT()
    {
        return trace(1, 23);
    }

    public boolean trace_Service_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(1, 23, o1);
    }

    public boolean trace_Service_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(1, 23, o1, o2);
    }

    public boolean trace_Service_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(1, 23, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 23, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(1, 24);
    }

    public boolean trace_Service_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(1, 24, o1);
    }

    public boolean trace_Service_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(1, 24, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(1, 24, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 24, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(1, 25);
    }

    public boolean trace_Service_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(1, 25, o1);
    }

    public boolean trace_Service_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(1, 25, o1, o2);
    }

    public boolean trace_Service_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(1, 25, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 25, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(1, 26);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(1, 26, o1);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(1, 26, o1, o2);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(1, 26, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 26, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_0S_CONNECTING_TO_DB()
    {
        return trace(1, 27);
    }

    public boolean trace_Service_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(1, 27, o1);
    }

    public boolean trace_Service_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(1, 27, o1, o2);
    }

    public boolean trace_Service_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(1, 27, o1, o2, o3);
    }

    public boolean trace_Service_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 27, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_CONFIG_READING_FILE()
    {
        return trace(1, 28);
    }

    public boolean trace_Service_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(1, 28, o1);
    }

    public boolean trace_Service_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(1, 28, o1, o2);
    }

    public boolean trace_Service_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(1, 28, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 28, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_1S_REVISION()
    {
        return trace(1, 29);
    }

    public boolean trace_Service_TM_1S_REVISION(Object o1)
    {
        return trace(1, 29, o1);
    }

    public boolean trace_Service_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(1, 29, o1, o2);
    }

    public boolean trace_Service_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(1, 29, o1, o2, o3);
    }

    public boolean trace_Service_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 29, o1, o2, o3, o4);
    }

    public boolean trace_Service_TM_2S_ARM_ACTION()
    {
        return trace(1, 30);
    }

    public boolean trace_Service_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(1, 30, o1);
    }

    public boolean trace_Service_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(1, 30, o1, o2);
    }

    public boolean trace_Service_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(1, 30, o1, o2, o3);
    }

    public boolean trace_Service_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(1, 30, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData(int ai_code)
    {
        return trace(2, ai_code);
    }

    public boolean trace_ServiceData(int ai_code, Object o1)
    {
        return trace(2, ai_code, o1);
    }

    public boolean trace_ServiceData(int ai_code, Object o1, Object o2)
    {
        return trace(2, ai_code, o1, o2);
    }

    public boolean trace_ServiceData(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(2, ai_code, o1, o2, o3);
    }

    public boolean trace_ServiceData(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_4S_UNKNOWN_CODE()
    {
        return trace(2, 0);
    }

    public boolean trace_ServiceData_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(2, 0, o1);
    }

    public boolean trace_ServiceData_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(2, 0, o1, o2);
    }

    public boolean trace_ServiceData_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(2, 0, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 0, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_BOOTING()
    {
        return trace(2, 1);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(2, 1, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(2, 1, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(2, 1, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 1, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(2, 2);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(2, 2, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(2, 2, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(2, 2, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 2, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(2, 3);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(2, 3, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(2, 3, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(2, 3, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 3, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_BOOTING()
    {
        return trace(2, 4);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(2, 4, o1);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(2, 4, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(2, 4, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 4, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(2, 5);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(2, 5, o1);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(2, 5, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(2, 5, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 5, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_CALLING_GETSERVICE()
    {
        return trace(2, 6);
    }

    public boolean trace_ServiceData_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(2, 6, o1);
    }

    public boolean trace_ServiceData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(2, 6, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(2, 6, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 6, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(2, 7);
    }

    public boolean trace_ServiceData_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(2, 7, o1);
    }

    public boolean trace_ServiceData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(2, 7, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(2, 7, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 7, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(2, 8);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(2, 8, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(2, 8, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(2, 8, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 8, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(2, 9);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(2, 9, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(2, 9, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(2, 9, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 9, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(2, 10);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(2, 10, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(2, 10, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(2, 10, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 10, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(2, 11);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(2, 11, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(2, 11, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(2, 11, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 11, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(2, 12);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(2, 12, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(2, 12, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(2, 12, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 12, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_3S_ACTIVATING_RESET()
    {
        return trace(2, 13);
    }

    public boolean trace_ServiceData_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(2, 13, o1);
    }

    public boolean trace_ServiceData_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(2, 13, o1, o2);
    }

    public boolean trace_ServiceData_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(2, 13, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 13, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_4S_SUBSCRIBING()
    {
        return trace(2, 14);
    }

    public boolean trace_ServiceData_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(2, 14, o1);
    }

    public boolean trace_ServiceData_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(2, 14, o1, o2);
    }

    public boolean trace_ServiceData_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(2, 14, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 14, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(2, 15);
    }

    public boolean trace_ServiceData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(2, 15, o1);
    }

    public boolean trace_ServiceData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(2, 15, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(2, 15, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 15, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_3S_RESETTING()
    {
        return trace(2, 16);
    }

    public boolean trace_ServiceData_TM_3S_RESETTING(Object o1)
    {
        return trace(2, 16, o1);
    }

    public boolean trace_ServiceData_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(2, 16, o1, o2);
    }

    public boolean trace_ServiceData_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(2, 16, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 16, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(2, 17);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(2, 17, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(2, 17, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(2, 17, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 17, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_CHECKPOINT()
    {
        return trace(2, 18);
    }

    public boolean trace_ServiceData_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(2, 18, o1);
    }

    public boolean trace_ServiceData_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(2, 18, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(2, 18, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 18, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_CHECKPOINT()
    {
        return trace(2, 19);
    }

    public boolean trace_ServiceData_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(2, 19, o1);
    }

    public boolean trace_ServiceData_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(2, 19, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(2, 19, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 19, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_3S_CHECKPOINT()
    {
        return trace(2, 20);
    }

    public boolean trace_ServiceData_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(2, 20, o1);
    }

    public boolean trace_ServiceData_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(2, 20, o1, o2);
    }

    public boolean trace_ServiceData_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(2, 20, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 20, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_4S_CHECKPOINT()
    {
        return trace(2, 21);
    }

    public boolean trace_ServiceData_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(2, 21, o1);
    }

    public boolean trace_ServiceData_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(2, 21, o1, o2);
    }

    public boolean trace_ServiceData_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(2, 21, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 21, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_3S_DEBUG_MSG()
    {
        return trace(2, 22);
    }

    public boolean trace_ServiceData_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(2, 22, o1);
    }

    public boolean trace_ServiceData_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(2, 22, o1, o2);
    }

    public boolean trace_ServiceData_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(2, 22, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 22, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_DATA_OUTPUT()
    {
        return trace(2, 23);
    }

    public boolean trace_ServiceData_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(2, 23, o1);
    }

    public boolean trace_ServiceData_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(2, 23, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(2, 23, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 23, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(2, 24);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(2, 24, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(2, 24, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(2, 24, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 24, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(2, 25);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(2, 25, o1);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(2, 25, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(2, 25, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 25, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(2, 26);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(2, 26, o1);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(2, 26, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(2, 26, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 26, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_0S_CONNECTING_TO_DB()
    {
        return trace(2, 27);
    }

    public boolean trace_ServiceData_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(2, 27, o1);
    }

    public boolean trace_ServiceData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(2, 27, o1, o2);
    }

    public boolean trace_ServiceData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(2, 27, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 27, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_CONFIG_READING_FILE()
    {
        return trace(2, 28);
    }

    public boolean trace_ServiceData_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(2, 28, o1);
    }

    public boolean trace_ServiceData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(2, 28, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(2, 28, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 28, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_1S_REVISION()
    {
        return trace(2, 29);
    }

    public boolean trace_ServiceData_TM_1S_REVISION(Object o1)
    {
        return trace(2, 29, o1);
    }

    public boolean trace_ServiceData_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(2, 29, o1, o2);
    }

    public boolean trace_ServiceData_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(2, 29, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 29, o1, o2, o3, o4);
    }

    public boolean trace_ServiceData_TM_2S_ARM_ACTION()
    {
        return trace(2, 30);
    }

    public boolean trace_ServiceData_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(2, 30, o1);
    }

    public boolean trace_ServiceData_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(2, 30, o1, o2);
    }

    public boolean trace_ServiceData_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(2, 30, o1, o2, o3);
    }

    public boolean trace_ServiceData_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(2, 30, o1, o2, o3, o4);
    }

    public boolean trace_Server(int ai_code)
    {
        return trace(4, ai_code);
    }

    public boolean trace_Server(int ai_code, Object o1)
    {
        return trace(4, ai_code, o1);
    }

    public boolean trace_Server(int ai_code, Object o1, Object o2)
    {
        return trace(4, ai_code, o1, o2);
    }

    public boolean trace_Server(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(4, ai_code, o1, o2, o3);
    }

    public boolean trace_Server(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_4S_UNKNOWN_CODE()
    {
        return trace(4, 0);
    }

    public boolean trace_Server_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(4, 0, o1);
    }

    public boolean trace_Server_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(4, 0, o1, o2);
    }

    public boolean trace_Server_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(4, 0, o1, o2, o3);
    }

    public boolean trace_Server_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 0, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVER_BOOTING()
    {
        return trace(4, 1);
    }

    public boolean trace_Server_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(4, 1, o1);
    }

    public boolean trace_Server_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(4, 1, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(4, 1, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 1, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(4, 2);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(4, 2, o1);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(4, 2, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(4, 2, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 2, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(4, 3);
    }

    public boolean trace_Server_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(4, 3, o1);
    }

    public boolean trace_Server_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(4, 3, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(4, 3, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 3, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_CLIENT_BOOTING()
    {
        return trace(4, 4);
    }

    public boolean trace_Server_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(4, 4, o1);
    }

    public boolean trace_Server_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(4, 4, o1, o2);
    }

    public boolean trace_Server_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(4, 4, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 4, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(4, 5);
    }

    public boolean trace_Server_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(4, 5, o1);
    }

    public boolean trace_Server_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(4, 5, o1, o2);
    }

    public boolean trace_Server_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(4, 5, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 5, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_CALLING_GETSERVICE()
    {
        return trace(4, 6);
    }

    public boolean trace_Server_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(4, 6, o1);
    }

    public boolean trace_Server_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(4, 6, o1, o2);
    }

    public boolean trace_Server_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(4, 6, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 6, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(4, 7);
    }

    public boolean trace_Server_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(4, 7, o1);
    }

    public boolean trace_Server_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(4, 7, o1, o2);
    }

    public boolean trace_Server_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(4, 7, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 7, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(4, 8);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(4, 8, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(4, 8, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(4, 8, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 8, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(4, 9);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(4, 9, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(4, 9, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(4, 9, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 9, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(4, 10);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(4, 10, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(4, 10, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(4, 10, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 10, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(4, 11);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(4, 11, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(4, 11, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(4, 11, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 11, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(4, 12);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(4, 12, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(4, 12, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(4, 12, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 12, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_3S_ACTIVATING_RESET()
    {
        return trace(4, 13);
    }

    public boolean trace_Server_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(4, 13, o1);
    }

    public boolean trace_Server_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(4, 13, o1, o2);
    }

    public boolean trace_Server_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(4, 13, o1, o2, o3);
    }

    public boolean trace_Server_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 13, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_4S_SUBSCRIBING()
    {
        return trace(4, 14);
    }

    public boolean trace_Server_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(4, 14, o1);
    }

    public boolean trace_Server_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(4, 14, o1, o2);
    }

    public boolean trace_Server_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(4, 14, o1, o2, o3);
    }

    public boolean trace_Server_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 14, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(4, 15);
    }

    public boolean trace_Server_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(4, 15, o1);
    }

    public boolean trace_Server_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(4, 15, o1, o2);
    }

    public boolean trace_Server_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(4, 15, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 15, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_3S_RESETTING()
    {
        return trace(4, 16);
    }

    public boolean trace_Server_TM_3S_RESETTING(Object o1)
    {
        return trace(4, 16, o1);
    }

    public boolean trace_Server_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(4, 16, o1, o2);
    }

    public boolean trace_Server_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(4, 16, o1, o2, o3);
    }

    public boolean trace_Server_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 16, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(4, 17);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(4, 17, o1);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(4, 17, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(4, 17, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 17, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_CHECKPOINT()
    {
        return trace(4, 18);
    }

    public boolean trace_Server_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(4, 18, o1);
    }

    public boolean trace_Server_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(4, 18, o1, o2);
    }

    public boolean trace_Server_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(4, 18, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 18, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_CHECKPOINT()
    {
        return trace(4, 19);
    }

    public boolean trace_Server_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(4, 19, o1);
    }

    public boolean trace_Server_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(4, 19, o1, o2);
    }

    public boolean trace_Server_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(4, 19, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 19, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_3S_CHECKPOINT()
    {
        return trace(4, 20);
    }

    public boolean trace_Server_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(4, 20, o1);
    }

    public boolean trace_Server_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(4, 20, o1, o2);
    }

    public boolean trace_Server_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(4, 20, o1, o2, o3);
    }

    public boolean trace_Server_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 20, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_4S_CHECKPOINT()
    {
        return trace(4, 21);
    }

    public boolean trace_Server_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(4, 21, o1);
    }

    public boolean trace_Server_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(4, 21, o1, o2);
    }

    public boolean trace_Server_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(4, 21, o1, o2, o3);
    }

    public boolean trace_Server_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 21, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_3S_DEBUG_MSG()
    {
        return trace(4, 22);
    }

    public boolean trace_Server_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(4, 22, o1);
    }

    public boolean trace_Server_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(4, 22, o1, o2);
    }

    public boolean trace_Server_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(4, 22, o1, o2, o3);
    }

    public boolean trace_Server_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 22, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_DATA_OUTPUT()
    {
        return trace(4, 23);
    }

    public boolean trace_Server_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(4, 23, o1);
    }

    public boolean trace_Server_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(4, 23, o1, o2);
    }

    public boolean trace_Server_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(4, 23, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 23, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(4, 24);
    }

    public boolean trace_Server_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(4, 24, o1);
    }

    public boolean trace_Server_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(4, 24, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(4, 24, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 24, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(4, 25);
    }

    public boolean trace_Server_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(4, 25, o1);
    }

    public boolean trace_Server_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(4, 25, o1, o2);
    }

    public boolean trace_Server_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(4, 25, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 25, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(4, 26);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(4, 26, o1);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(4, 26, o1, o2);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(4, 26, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 26, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_0S_CONNECTING_TO_DB()
    {
        return trace(4, 27);
    }

    public boolean trace_Server_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(4, 27, o1);
    }

    public boolean trace_Server_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(4, 27, o1, o2);
    }

    public boolean trace_Server_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(4, 27, o1, o2, o3);
    }

    public boolean trace_Server_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 27, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_CONFIG_READING_FILE()
    {
        return trace(4, 28);
    }

    public boolean trace_Server_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(4, 28, o1);
    }

    public boolean trace_Server_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(4, 28, o1, o2);
    }

    public boolean trace_Server_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(4, 28, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 28, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_1S_REVISION()
    {
        return trace(4, 29);
    }

    public boolean trace_Server_TM_1S_REVISION(Object o1)
    {
        return trace(4, 29, o1);
    }

    public boolean trace_Server_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(4, 29, o1, o2);
    }

    public boolean trace_Server_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(4, 29, o1, o2, o3);
    }

    public boolean trace_Server_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 29, o1, o2, o3, o4);
    }

    public boolean trace_Server_TM_2S_ARM_ACTION()
    {
        return trace(4, 30);
    }

    public boolean trace_Server_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(4, 30, o1);
    }

    public boolean trace_Server_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(4, 30, o1, o2);
    }

    public boolean trace_Server_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(4, 30, o1, o2, o3);
    }

    public boolean trace_Server_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(4, 30, o1, o2, o3, o4);
    }

    public boolean trace_Method(int ai_code)
    {
        return trace(8, ai_code);
    }

    public boolean trace_Method(int ai_code, Object o1)
    {
        return trace(8, ai_code, o1);
    }

    public boolean trace_Method(int ai_code, Object o1, Object o2)
    {
        return trace(8, ai_code, o1, o2);
    }

    public boolean trace_Method(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(8, ai_code, o1, o2, o3);
    }

    public boolean trace_Method(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_4S_UNKNOWN_CODE()
    {
        return trace(8, 0);
    }

    public boolean trace_Method_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(8, 0, o1);
    }

    public boolean trace_Method_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(8, 0, o1, o2);
    }

    public boolean trace_Method_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(8, 0, o1, o2, o3);
    }

    public boolean trace_Method_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 0, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVER_BOOTING()
    {
        return trace(8, 1);
    }

    public boolean trace_Method_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(8, 1, o1);
    }

    public boolean trace_Method_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(8, 1, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(8, 1, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 1, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(8, 2);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(8, 2, o1);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(8, 2, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(8, 2, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 2, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(8, 3);
    }

    public boolean trace_Method_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(8, 3, o1);
    }

    public boolean trace_Method_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(8, 3, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(8, 3, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 3, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_CLIENT_BOOTING()
    {
        return trace(8, 4);
    }

    public boolean trace_Method_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(8, 4, o1);
    }

    public boolean trace_Method_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(8, 4, o1, o2);
    }

    public boolean trace_Method_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(8, 4, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 4, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(8, 5);
    }

    public boolean trace_Method_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(8, 5, o1);
    }

    public boolean trace_Method_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(8, 5, o1, o2);
    }

    public boolean trace_Method_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(8, 5, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 5, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_CALLING_GETSERVICE()
    {
        return trace(8, 6);
    }

    public boolean trace_Method_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(8, 6, o1);
    }

    public boolean trace_Method_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(8, 6, o1, o2);
    }

    public boolean trace_Method_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(8, 6, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 6, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(8, 7);
    }

    public boolean trace_Method_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(8, 7, o1);
    }

    public boolean trace_Method_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(8, 7, o1, o2);
    }

    public boolean trace_Method_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(8, 7, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 7, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(8, 8);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(8, 8, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(8, 8, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(8, 8, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 8, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(8, 9);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(8, 9, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(8, 9, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(8, 9, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 9, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(8, 10);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(8, 10, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(8, 10, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(8, 10, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 10, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(8, 11);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(8, 11, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(8, 11, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(8, 11, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 11, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(8, 12);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(8, 12, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(8, 12, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(8, 12, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 12, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_3S_ACTIVATING_RESET()
    {
        return trace(8, 13);
    }

    public boolean trace_Method_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(8, 13, o1);
    }

    public boolean trace_Method_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(8, 13, o1, o2);
    }

    public boolean trace_Method_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(8, 13, o1, o2, o3);
    }

    public boolean trace_Method_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 13, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_4S_SUBSCRIBING()
    {
        return trace(8, 14);
    }

    public boolean trace_Method_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(8, 14, o1);
    }

    public boolean trace_Method_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(8, 14, o1, o2);
    }

    public boolean trace_Method_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(8, 14, o1, o2, o3);
    }

    public boolean trace_Method_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 14, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(8, 15);
    }

    public boolean trace_Method_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(8, 15, o1);
    }

    public boolean trace_Method_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(8, 15, o1, o2);
    }

    public boolean trace_Method_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(8, 15, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 15, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_3S_RESETTING()
    {
        return trace(8, 16);
    }

    public boolean trace_Method_TM_3S_RESETTING(Object o1)
    {
        return trace(8, 16, o1);
    }

    public boolean trace_Method_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(8, 16, o1, o2);
    }

    public boolean trace_Method_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(8, 16, o1, o2, o3);
    }

    public boolean trace_Method_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 16, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(8, 17);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(8, 17, o1);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(8, 17, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(8, 17, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 17, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_CHECKPOINT()
    {
        return trace(8, 18);
    }

    public boolean trace_Method_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(8, 18, o1);
    }

    public boolean trace_Method_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(8, 18, o1, o2);
    }

    public boolean trace_Method_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(8, 18, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 18, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_CHECKPOINT()
    {
        return trace(8, 19);
    }

    public boolean trace_Method_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(8, 19, o1);
    }

    public boolean trace_Method_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(8, 19, o1, o2);
    }

    public boolean trace_Method_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(8, 19, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 19, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_3S_CHECKPOINT()
    {
        return trace(8, 20);
    }

    public boolean trace_Method_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(8, 20, o1);
    }

    public boolean trace_Method_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(8, 20, o1, o2);
    }

    public boolean trace_Method_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(8, 20, o1, o2, o3);
    }

    public boolean trace_Method_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 20, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_4S_CHECKPOINT()
    {
        return trace(8, 21);
    }

    public boolean trace_Method_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(8, 21, o1);
    }

    public boolean trace_Method_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(8, 21, o1, o2);
    }

    public boolean trace_Method_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(8, 21, o1, o2, o3);
    }

    public boolean trace_Method_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 21, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_3S_DEBUG_MSG()
    {
        return trace(8, 22);
    }

    public boolean trace_Method_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(8, 22, o1);
    }

    public boolean trace_Method_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(8, 22, o1, o2);
    }

    public boolean trace_Method_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(8, 22, o1, o2, o3);
    }

    public boolean trace_Method_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 22, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_DATA_OUTPUT()
    {
        return trace(8, 23);
    }

    public boolean trace_Method_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(8, 23, o1);
    }

    public boolean trace_Method_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(8, 23, o1, o2);
    }

    public boolean trace_Method_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(8, 23, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 23, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(8, 24);
    }

    public boolean trace_Method_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(8, 24, o1);
    }

    public boolean trace_Method_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(8, 24, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(8, 24, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 24, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(8, 25);
    }

    public boolean trace_Method_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(8, 25, o1);
    }

    public boolean trace_Method_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(8, 25, o1, o2);
    }

    public boolean trace_Method_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(8, 25, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 25, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(8, 26);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(8, 26, o1);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(8, 26, o1, o2);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(8, 26, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 26, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_0S_CONNECTING_TO_DB()
    {
        return trace(8, 27);
    }

    public boolean trace_Method_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(8, 27, o1);
    }

    public boolean trace_Method_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(8, 27, o1, o2);
    }

    public boolean trace_Method_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(8, 27, o1, o2, o3);
    }

    public boolean trace_Method_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 27, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_CONFIG_READING_FILE()
    {
        return trace(8, 28);
    }

    public boolean trace_Method_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(8, 28, o1);
    }

    public boolean trace_Method_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(8, 28, o1, o2);
    }

    public boolean trace_Method_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(8, 28, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 28, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_1S_REVISION()
    {
        return trace(8, 29);
    }

    public boolean trace_Method_TM_1S_REVISION(Object o1)
    {
        return trace(8, 29, o1);
    }

    public boolean trace_Method_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(8, 29, o1, o2);
    }

    public boolean trace_Method_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(8, 29, o1, o2, o3);
    }

    public boolean trace_Method_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 29, o1, o2, o3, o4);
    }

    public boolean trace_Method_TM_2S_ARM_ACTION()
    {
        return trace(8, 30);
    }

    public boolean trace_Method_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(8, 30, o1);
    }

    public boolean trace_Method_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(8, 30, o1, o2);
    }

    public boolean trace_Method_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(8, 30, o1, o2, o3);
    }

    public boolean trace_Method_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(8, 30, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode(int ai_code)
    {
        return trace(16, ai_code);
    }

    public boolean trace_CriticalCode(int ai_code, Object o1)
    {
        return trace(16, ai_code, o1);
    }

    public boolean trace_CriticalCode(int ai_code, Object o1, Object o2)
    {
        return trace(16, ai_code, o1, o2);
    }

    public boolean trace_CriticalCode(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(16, ai_code, o1, o2, o3);
    }

    public boolean trace_CriticalCode(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_4S_UNKNOWN_CODE()
    {
        return trace(16, 0);
    }

    public boolean trace_CriticalCode_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(16, 0, o1);
    }

    public boolean trace_CriticalCode_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(16, 0, o1, o2);
    }

    public boolean trace_CriticalCode_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(16, 0, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 0, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_BOOTING()
    {
        return trace(16, 1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(16, 1, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(16, 1, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(16, 1, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 1, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(16, 2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(16, 2, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(16, 2, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(16, 2, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 2, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(16, 3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(16, 3, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(16, 3, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(16, 3, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 3, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_BOOTING()
    {
        return trace(16, 4);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(16, 4, o1);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(16, 4, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(16, 4, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 4, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(16, 5);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(16, 5, o1);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(16, 5, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(16, 5, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 5, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_CALLING_GETSERVICE()
    {
        return trace(16, 6);
    }

    public boolean trace_CriticalCode_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(16, 6, o1);
    }

    public boolean trace_CriticalCode_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(16, 6, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(16, 6, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 6, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(16, 7);
    }

    public boolean trace_CriticalCode_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(16, 7, o1);
    }

    public boolean trace_CriticalCode_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(16, 7, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(16, 7, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 7, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(16, 8);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(16, 8, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(16, 8, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(16, 8, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 8, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(16, 9);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(16, 9, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(16, 9, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(16, 9, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 9, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(16, 10);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(16, 10, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(16, 10, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(16, 10, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 10, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(16, 11);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(16, 11, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(16, 11, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(16, 11, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 11, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(16, 12);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(16, 12, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(16, 12, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(16, 12, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 12, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_3S_ACTIVATING_RESET()
    {
        return trace(16, 13);
    }

    public boolean trace_CriticalCode_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(16, 13, o1);
    }

    public boolean trace_CriticalCode_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(16, 13, o1, o2);
    }

    public boolean trace_CriticalCode_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(16, 13, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 13, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_4S_SUBSCRIBING()
    {
        return trace(16, 14);
    }

    public boolean trace_CriticalCode_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(16, 14, o1);
    }

    public boolean trace_CriticalCode_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(16, 14, o1, o2);
    }

    public boolean trace_CriticalCode_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(16, 14, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 14, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(16, 15);
    }

    public boolean trace_CriticalCode_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(16, 15, o1);
    }

    public boolean trace_CriticalCode_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(16, 15, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(16, 15, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 15, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_3S_RESETTING()
    {
        return trace(16, 16);
    }

    public boolean trace_CriticalCode_TM_3S_RESETTING(Object o1)
    {
        return trace(16, 16, o1);
    }

    public boolean trace_CriticalCode_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(16, 16, o1, o2);
    }

    public boolean trace_CriticalCode_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(16, 16, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 16, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(16, 17);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(16, 17, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(16, 17, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(16, 17, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 17, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_CHECKPOINT()
    {
        return trace(16, 18);
    }

    public boolean trace_CriticalCode_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(16, 18, o1);
    }

    public boolean trace_CriticalCode_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(16, 18, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(16, 18, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 18, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_CHECKPOINT()
    {
        return trace(16, 19);
    }

    public boolean trace_CriticalCode_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(16, 19, o1);
    }

    public boolean trace_CriticalCode_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(16, 19, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(16, 19, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 19, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_3S_CHECKPOINT()
    {
        return trace(16, 20);
    }

    public boolean trace_CriticalCode_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(16, 20, o1);
    }

    public boolean trace_CriticalCode_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(16, 20, o1, o2);
    }

    public boolean trace_CriticalCode_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(16, 20, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 20, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_4S_CHECKPOINT()
    {
        return trace(16, 21);
    }

    public boolean trace_CriticalCode_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(16, 21, o1);
    }

    public boolean trace_CriticalCode_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(16, 21, o1, o2);
    }

    public boolean trace_CriticalCode_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(16, 21, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 21, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_3S_DEBUG_MSG()
    {
        return trace(16, 22);
    }

    public boolean trace_CriticalCode_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(16, 22, o1);
    }

    public boolean trace_CriticalCode_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(16, 22, o1, o2);
    }

    public boolean trace_CriticalCode_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(16, 22, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 22, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_DATA_OUTPUT()
    {
        return trace(16, 23);
    }

    public boolean trace_CriticalCode_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(16, 23, o1);
    }

    public boolean trace_CriticalCode_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(16, 23, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(16, 23, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 23, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(16, 24);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(16, 24, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(16, 24, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(16, 24, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 24, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(16, 25);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(16, 25, o1);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(16, 25, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(16, 25, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 25, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(16, 26);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(16, 26, o1);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(16, 26, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(16, 26, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 26, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_0S_CONNECTING_TO_DB()
    {
        return trace(16, 27);
    }

    public boolean trace_CriticalCode_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(16, 27, o1);
    }

    public boolean trace_CriticalCode_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(16, 27, o1, o2);
    }

    public boolean trace_CriticalCode_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(16, 27, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 27, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_CONFIG_READING_FILE()
    {
        return trace(16, 28);
    }

    public boolean trace_CriticalCode_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(16, 28, o1);
    }

    public boolean trace_CriticalCode_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(16, 28, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(16, 28, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 28, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_1S_REVISION()
    {
        return trace(16, 29);
    }

    public boolean trace_CriticalCode_TM_1S_REVISION(Object o1)
    {
        return trace(16, 29, o1);
    }

    public boolean trace_CriticalCode_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(16, 29, o1, o2);
    }

    public boolean trace_CriticalCode_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(16, 29, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 29, o1, o2, o3, o4);
    }

    public boolean trace_CriticalCode_TM_2S_ARM_ACTION()
    {
        return trace(16, 30);
    }

    public boolean trace_CriticalCode_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(16, 30, o1);
    }

    public boolean trace_CriticalCode_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(16, 30, o1, o2);
    }

    public boolean trace_CriticalCode_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(16, 30, o1, o2, o3);
    }

    public boolean trace_CriticalCode_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(16, 30, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess(int ai_code)
    {
        return trace(32, ai_code);
    }

    public boolean trace_DBAccess(int ai_code, Object o1)
    {
        return trace(32, ai_code, o1);
    }

    public boolean trace_DBAccess(int ai_code, Object o1, Object o2)
    {
        return trace(32, ai_code, o1, o2);
    }

    public boolean trace_DBAccess(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(32, ai_code, o1, o2, o3);
    }

    public boolean trace_DBAccess(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_4S_UNKNOWN_CODE()
    {
        return trace(32, 0);
    }

    public boolean trace_DBAccess_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(32, 0, o1);
    }

    public boolean trace_DBAccess_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(32, 0, o1, o2);
    }

    public boolean trace_DBAccess_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(32, 0, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 0, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_BOOTING()
    {
        return trace(32, 1);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(32, 1, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(32, 1, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(32, 1, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 1, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(32, 2);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(32, 2, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(32, 2, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(32, 2, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 2, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(32, 3);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(32, 3, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(32, 3, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(32, 3, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 3, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_BOOTING()
    {
        return trace(32, 4);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(32, 4, o1);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(32, 4, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(32, 4, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 4, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(32, 5);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(32, 5, o1);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(32, 5, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(32, 5, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 5, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_CALLING_GETSERVICE()
    {
        return trace(32, 6);
    }

    public boolean trace_DBAccess_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(32, 6, o1);
    }

    public boolean trace_DBAccess_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(32, 6, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(32, 6, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 6, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(32, 7);
    }

    public boolean trace_DBAccess_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(32, 7, o1);
    }

    public boolean trace_DBAccess_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(32, 7, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(32, 7, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 7, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(32, 8);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(32, 8, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(32, 8, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(32, 8, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 8, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(32, 9);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(32, 9, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(32, 9, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(32, 9, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 9, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(32, 10);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(32, 10, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(32, 10, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(32, 10, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 10, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(32, 11);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(32, 11, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(32, 11, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(32, 11, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 11, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(32, 12);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(32, 12, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(32, 12, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(32, 12, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 12, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_3S_ACTIVATING_RESET()
    {
        return trace(32, 13);
    }

    public boolean trace_DBAccess_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(32, 13, o1);
    }

    public boolean trace_DBAccess_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(32, 13, o1, o2);
    }

    public boolean trace_DBAccess_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(32, 13, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 13, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_4S_SUBSCRIBING()
    {
        return trace(32, 14);
    }

    public boolean trace_DBAccess_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(32, 14, o1);
    }

    public boolean trace_DBAccess_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(32, 14, o1, o2);
    }

    public boolean trace_DBAccess_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(32, 14, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 14, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(32, 15);
    }

    public boolean trace_DBAccess_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(32, 15, o1);
    }

    public boolean trace_DBAccess_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(32, 15, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(32, 15, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 15, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_3S_RESETTING()
    {
        return trace(32, 16);
    }

    public boolean trace_DBAccess_TM_3S_RESETTING(Object o1)
    {
        return trace(32, 16, o1);
    }

    public boolean trace_DBAccess_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(32, 16, o1, o2);
    }

    public boolean trace_DBAccess_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(32, 16, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 16, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(32, 17);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(32, 17, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(32, 17, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(32, 17, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 17, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_CHECKPOINT()
    {
        return trace(32, 18);
    }

    public boolean trace_DBAccess_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(32, 18, o1);
    }

    public boolean trace_DBAccess_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(32, 18, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(32, 18, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 18, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_CHECKPOINT()
    {
        return trace(32, 19);
    }

    public boolean trace_DBAccess_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(32, 19, o1);
    }

    public boolean trace_DBAccess_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(32, 19, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(32, 19, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 19, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_3S_CHECKPOINT()
    {
        return trace(32, 20);
    }

    public boolean trace_DBAccess_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(32, 20, o1);
    }

    public boolean trace_DBAccess_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(32, 20, o1, o2);
    }

    public boolean trace_DBAccess_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(32, 20, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 20, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_4S_CHECKPOINT()
    {
        return trace(32, 21);
    }

    public boolean trace_DBAccess_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(32, 21, o1);
    }

    public boolean trace_DBAccess_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(32, 21, o1, o2);
    }

    public boolean trace_DBAccess_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(32, 21, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 21, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_3S_DEBUG_MSG()
    {
        return trace(32, 22);
    }

    public boolean trace_DBAccess_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(32, 22, o1);
    }

    public boolean trace_DBAccess_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(32, 22, o1, o2);
    }

    public boolean trace_DBAccess_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(32, 22, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 22, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_DATA_OUTPUT()
    {
        return trace(32, 23);
    }

    public boolean trace_DBAccess_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(32, 23, o1);
    }

    public boolean trace_DBAccess_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(32, 23, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(32, 23, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 23, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(32, 24);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(32, 24, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(32, 24, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(32, 24, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 24, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(32, 25);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(32, 25, o1);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(32, 25, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(32, 25, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 25, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(32, 26);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(32, 26, o1);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(32, 26, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(32, 26, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 26, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_0S_CONNECTING_TO_DB()
    {
        return trace(32, 27);
    }

    public boolean trace_DBAccess_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(32, 27, o1);
    }

    public boolean trace_DBAccess_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(32, 27, o1, o2);
    }

    public boolean trace_DBAccess_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(32, 27, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 27, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_CONFIG_READING_FILE()
    {
        return trace(32, 28);
    }

    public boolean trace_DBAccess_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(32, 28, o1);
    }

    public boolean trace_DBAccess_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(32, 28, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(32, 28, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 28, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_1S_REVISION()
    {
        return trace(32, 29);
    }

    public boolean trace_DBAccess_TM_1S_REVISION(Object o1)
    {
        return trace(32, 29, o1);
    }

    public boolean trace_DBAccess_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(32, 29, o1, o2);
    }

    public boolean trace_DBAccess_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(32, 29, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 29, o1, o2, o3, o4);
    }

    public boolean trace_DBAccess_TM_2S_ARM_ACTION()
    {
        return trace(32, 30);
    }

    public boolean trace_DBAccess_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(32, 30, o1);
    }

    public boolean trace_DBAccess_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(32, 30, o1, o2);
    }

    public boolean trace_DBAccess_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(32, 30, o1, o2, o3);
    }

    public boolean trace_DBAccess_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(32, 30, o1, o2, o3, o4);
    }

    public boolean trace_Component(int ai_code)
    {
        return trace(64, ai_code);
    }

    public boolean trace_Component(int ai_code, Object o1)
    {
        return trace(64, ai_code, o1);
    }

    public boolean trace_Component(int ai_code, Object o1, Object o2)
    {
        return trace(64, ai_code, o1, o2);
    }

    public boolean trace_Component(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(64, ai_code, o1, o2, o3);
    }

    public boolean trace_Component(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_4S_UNKNOWN_CODE()
    {
        return trace(64, 0);
    }

    public boolean trace_Component_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(64, 0, o1);
    }

    public boolean trace_Component_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(64, 0, o1, o2);
    }

    public boolean trace_Component_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(64, 0, o1, o2, o3);
    }

    public boolean trace_Component_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 0, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVER_BOOTING()
    {
        return trace(64, 1);
    }

    public boolean trace_Component_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(64, 1, o1);
    }

    public boolean trace_Component_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(64, 1, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(64, 1, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 1, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(64, 2);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(64, 2, o1);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(64, 2, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(64, 2, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 2, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(64, 3);
    }

    public boolean trace_Component_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(64, 3, o1);
    }

    public boolean trace_Component_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(64, 3, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(64, 3, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 3, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_CLIENT_BOOTING()
    {
        return trace(64, 4);
    }

    public boolean trace_Component_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(64, 4, o1);
    }

    public boolean trace_Component_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(64, 4, o1, o2);
    }

    public boolean trace_Component_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(64, 4, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 4, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(64, 5);
    }

    public boolean trace_Component_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(64, 5, o1);
    }

    public boolean trace_Component_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(64, 5, o1, o2);
    }

    public boolean trace_Component_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(64, 5, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 5, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_CALLING_GETSERVICE()
    {
        return trace(64, 6);
    }

    public boolean trace_Component_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(64, 6, o1);
    }

    public boolean trace_Component_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(64, 6, o1, o2);
    }

    public boolean trace_Component_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(64, 6, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 6, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(64, 7);
    }

    public boolean trace_Component_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(64, 7, o1);
    }

    public boolean trace_Component_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(64, 7, o1, o2);
    }

    public boolean trace_Component_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(64, 7, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 7, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(64, 8);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(64, 8, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(64, 8, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(64, 8, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 8, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(64, 9);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(64, 9, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(64, 9, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(64, 9, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 9, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(64, 10);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(64, 10, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(64, 10, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(64, 10, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 10, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(64, 11);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(64, 11, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(64, 11, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(64, 11, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 11, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(64, 12);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(64, 12, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(64, 12, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(64, 12, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 12, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_3S_ACTIVATING_RESET()
    {
        return trace(64, 13);
    }

    public boolean trace_Component_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(64, 13, o1);
    }

    public boolean trace_Component_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(64, 13, o1, o2);
    }

    public boolean trace_Component_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(64, 13, o1, o2, o3);
    }

    public boolean trace_Component_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 13, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_4S_SUBSCRIBING()
    {
        return trace(64, 14);
    }

    public boolean trace_Component_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(64, 14, o1);
    }

    public boolean trace_Component_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(64, 14, o1, o2);
    }

    public boolean trace_Component_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(64, 14, o1, o2, o3);
    }

    public boolean trace_Component_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 14, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(64, 15);
    }

    public boolean trace_Component_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(64, 15, o1);
    }

    public boolean trace_Component_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(64, 15, o1, o2);
    }

    public boolean trace_Component_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(64, 15, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 15, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_3S_RESETTING()
    {
        return trace(64, 16);
    }

    public boolean trace_Component_TM_3S_RESETTING(Object o1)
    {
        return trace(64, 16, o1);
    }

    public boolean trace_Component_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(64, 16, o1, o2);
    }

    public boolean trace_Component_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(64, 16, o1, o2, o3);
    }

    public boolean trace_Component_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 16, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(64, 17);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(64, 17, o1);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(64, 17, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(64, 17, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 17, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_CHECKPOINT()
    {
        return trace(64, 18);
    }

    public boolean trace_Component_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(64, 18, o1);
    }

    public boolean trace_Component_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(64, 18, o1, o2);
    }

    public boolean trace_Component_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(64, 18, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 18, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_CHECKPOINT()
    {
        return trace(64, 19);
    }

    public boolean trace_Component_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(64, 19, o1);
    }

    public boolean trace_Component_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(64, 19, o1, o2);
    }

    public boolean trace_Component_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(64, 19, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 19, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_3S_CHECKPOINT()
    {
        return trace(64, 20);
    }

    public boolean trace_Component_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(64, 20, o1);
    }

    public boolean trace_Component_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(64, 20, o1, o2);
    }

    public boolean trace_Component_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(64, 20, o1, o2, o3);
    }

    public boolean trace_Component_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 20, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_4S_CHECKPOINT()
    {
        return trace(64, 21);
    }

    public boolean trace_Component_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(64, 21, o1);
    }

    public boolean trace_Component_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(64, 21, o1, o2);
    }

    public boolean trace_Component_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(64, 21, o1, o2, o3);
    }

    public boolean trace_Component_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 21, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_3S_DEBUG_MSG()
    {
        return trace(64, 22);
    }

    public boolean trace_Component_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(64, 22, o1);
    }

    public boolean trace_Component_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(64, 22, o1, o2);
    }

    public boolean trace_Component_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(64, 22, o1, o2, o3);
    }

    public boolean trace_Component_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 22, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_DATA_OUTPUT()
    {
        return trace(64, 23);
    }

    public boolean trace_Component_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(64, 23, o1);
    }

    public boolean trace_Component_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(64, 23, o1, o2);
    }

    public boolean trace_Component_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(64, 23, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 23, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(64, 24);
    }

    public boolean trace_Component_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(64, 24, o1);
    }

    public boolean trace_Component_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(64, 24, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(64, 24, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 24, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(64, 25);
    }

    public boolean trace_Component_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(64, 25, o1);
    }

    public boolean trace_Component_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(64, 25, o1, o2);
    }

    public boolean trace_Component_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(64, 25, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 25, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(64, 26);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(64, 26, o1);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(64, 26, o1, o2);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(64, 26, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 26, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_0S_CONNECTING_TO_DB()
    {
        return trace(64, 27);
    }

    public boolean trace_Component_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(64, 27, o1);
    }

    public boolean trace_Component_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(64, 27, o1, o2);
    }

    public boolean trace_Component_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(64, 27, o1, o2, o3);
    }

    public boolean trace_Component_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 27, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_CONFIG_READING_FILE()
    {
        return trace(64, 28);
    }

    public boolean trace_Component_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(64, 28, o1);
    }

    public boolean trace_Component_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(64, 28, o1, o2);
    }

    public boolean trace_Component_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(64, 28, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 28, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_1S_REVISION()
    {
        return trace(64, 29);
    }

    public boolean trace_Component_TM_1S_REVISION(Object o1)
    {
        return trace(64, 29, o1);
    }

    public boolean trace_Component_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(64, 29, o1, o2);
    }

    public boolean trace_Component_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(64, 29, o1, o2, o3);
    }

    public boolean trace_Component_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 29, o1, o2, o3, o4);
    }

    public boolean trace_Component_TM_2S_ARM_ACTION()
    {
        return trace(64, 30);
    }

    public boolean trace_Component_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(64, 30, o1);
    }

    public boolean trace_Component_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(64, 30, o1, o2);
    }

    public boolean trace_Component_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(64, 30, o1, o2, o3);
    }

    public boolean trace_Component_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(64, 30, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData(int ai_code)
    {
        return trace(128, ai_code);
    }

    public boolean trace_CriticalData(int ai_code, Object o1)
    {
        return trace(128, ai_code, o1);
    }

    public boolean trace_CriticalData(int ai_code, Object o1, Object o2)
    {
        return trace(128, ai_code, o1, o2);
    }

    public boolean trace_CriticalData(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(128, ai_code, o1, o2, o3);
    }

    public boolean trace_CriticalData(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_4S_UNKNOWN_CODE()
    {
        return trace(128, 0);
    }

    public boolean trace_CriticalData_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(128, 0, o1);
    }

    public boolean trace_CriticalData_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(128, 0, o1, o2);
    }

    public boolean trace_CriticalData_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(128, 0, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 0, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_BOOTING()
    {
        return trace(128, 1);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(128, 1, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(128, 1, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(128, 1, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 1, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(128, 2);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(128, 2, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(128, 2, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(128, 2, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 2, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(128, 3);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(128, 3, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(128, 3, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(128, 3, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 3, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_BOOTING()
    {
        return trace(128, 4);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(128, 4, o1);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(128, 4, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(128, 4, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 4, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(128, 5);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(128, 5, o1);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(128, 5, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(128, 5, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 5, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_CALLING_GETSERVICE()
    {
        return trace(128, 6);
    }

    public boolean trace_CriticalData_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(128, 6, o1);
    }

    public boolean trace_CriticalData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(128, 6, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(128, 6, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 6, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(128, 7);
    }

    public boolean trace_CriticalData_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(128, 7, o1);
    }

    public boolean trace_CriticalData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(128, 7, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(128, 7, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 7, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(128, 8);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(128, 8, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(128, 8, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(128, 8, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 8, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(128, 9);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(128, 9, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(128, 9, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(128, 9, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 9, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(128, 10);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(128, 10, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(128, 10, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(128, 10, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 10, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(128, 11);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(128, 11, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(128, 11, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(128, 11, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 11, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(128, 12);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(128, 12, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(128, 12, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(128, 12, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 12, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_3S_ACTIVATING_RESET()
    {
        return trace(128, 13);
    }

    public boolean trace_CriticalData_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(128, 13, o1);
    }

    public boolean trace_CriticalData_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(128, 13, o1, o2);
    }

    public boolean trace_CriticalData_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(128, 13, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 13, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_4S_SUBSCRIBING()
    {
        return trace(128, 14);
    }

    public boolean trace_CriticalData_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(128, 14, o1);
    }

    public boolean trace_CriticalData_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(128, 14, o1, o2);
    }

    public boolean trace_CriticalData_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(128, 14, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 14, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(128, 15);
    }

    public boolean trace_CriticalData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(128, 15, o1);
    }

    public boolean trace_CriticalData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(128, 15, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(128, 15, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 15, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_3S_RESETTING()
    {
        return trace(128, 16);
    }

    public boolean trace_CriticalData_TM_3S_RESETTING(Object o1)
    {
        return trace(128, 16, o1);
    }

    public boolean trace_CriticalData_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(128, 16, o1, o2);
    }

    public boolean trace_CriticalData_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(128, 16, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 16, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(128, 17);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(128, 17, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(128, 17, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(128, 17, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 17, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_CHECKPOINT()
    {
        return trace(128, 18);
    }

    public boolean trace_CriticalData_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(128, 18, o1);
    }

    public boolean trace_CriticalData_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(128, 18, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(128, 18, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 18, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_CHECKPOINT()
    {
        return trace(128, 19);
    }

    public boolean trace_CriticalData_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(128, 19, o1);
    }

    public boolean trace_CriticalData_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(128, 19, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(128, 19, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 19, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_3S_CHECKPOINT()
    {
        return trace(128, 20);
    }

    public boolean trace_CriticalData_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(128, 20, o1);
    }

    public boolean trace_CriticalData_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(128, 20, o1, o2);
    }

    public boolean trace_CriticalData_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(128, 20, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 20, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_4S_CHECKPOINT()
    {
        return trace(128, 21);
    }

    public boolean trace_CriticalData_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(128, 21, o1);
    }

    public boolean trace_CriticalData_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(128, 21, o1, o2);
    }

    public boolean trace_CriticalData_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(128, 21, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 21, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_3S_DEBUG_MSG()
    {
        return trace(128, 22);
    }

    public boolean trace_CriticalData_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(128, 22, o1);
    }

    public boolean trace_CriticalData_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(128, 22, o1, o2);
    }

    public boolean trace_CriticalData_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(128, 22, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 22, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_DATA_OUTPUT()
    {
        return trace(128, 23);
    }

    public boolean trace_CriticalData_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(128, 23, o1);
    }

    public boolean trace_CriticalData_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(128, 23, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(128, 23, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 23, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(128, 24);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(128, 24, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(128, 24, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(128, 24, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 24, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(128, 25);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(128, 25, o1);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(128, 25, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(128, 25, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 25, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(128, 26);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(128, 26, o1);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(128, 26, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(128, 26, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 26, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_0S_CONNECTING_TO_DB()
    {
        return trace(128, 27);
    }

    public boolean trace_CriticalData_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(128, 27, o1);
    }

    public boolean trace_CriticalData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(128, 27, o1, o2);
    }

    public boolean trace_CriticalData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(128, 27, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 27, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_CONFIG_READING_FILE()
    {
        return trace(128, 28);
    }

    public boolean trace_CriticalData_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(128, 28, o1);
    }

    public boolean trace_CriticalData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(128, 28, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(128, 28, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 28, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_1S_REVISION()
    {
        return trace(128, 29);
    }

    public boolean trace_CriticalData_TM_1S_REVISION(Object o1)
    {
        return trace(128, 29, o1);
    }

    public boolean trace_CriticalData_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(128, 29, o1, o2);
    }

    public boolean trace_CriticalData_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(128, 29, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 29, o1, o2, o3, o4);
    }

    public boolean trace_CriticalData_TM_2S_ARM_ACTION()
    {
        return trace(128, 30);
    }

    public boolean trace_CriticalData_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(128, 30, o1);
    }

    public boolean trace_CriticalData_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(128, 30, o1, o2);
    }

    public boolean trace_CriticalData_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(128, 30, o1, o2, o3);
    }

    public boolean trace_CriticalData_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(128, 30, o1, o2, o3, o4);
    }

    public boolean trace_Revision(int ai_code)
    {
        return trace(256, ai_code);
    }

    public boolean trace_Revision(int ai_code, Object o1)
    {
        return trace(256, ai_code, o1);
    }

    public boolean trace_Revision(int ai_code, Object o1, Object o2)
    {
        return trace(256, ai_code, o1, o2);
    }

    public boolean trace_Revision(int ai_code, Object o1, Object o2, Object o3)
    {
        return trace(256, ai_code, o1, o2, o3);
    }

    public boolean trace_Revision(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, ai_code, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_4S_UNKNOWN_CODE()
    {
        return trace(256, 0);
    }

    public boolean trace_Revision_TM_4S_UNKNOWN_CODE(Object o1)
    {
        return trace(256, 0, o1);
    }

    public boolean trace_Revision_TM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return trace(256, 0, o1, o2);
    }

    public boolean trace_Revision_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return trace(256, 0, o1, o2, o3);
    }

    public boolean trace_Revision_TM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 0, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVER_BOOTING()
    {
        return trace(256, 1);
    }

    public boolean trace_Revision_TM_2S_SERVER_BOOTING(Object o1)
    {
        return trace(256, 1, o1);
    }

    public boolean trace_Revision_TM_2S_SERVER_BOOTING(Object o1, Object o2)
    {
        return trace(256, 1, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(256, 1, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVER_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 1, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_INIT()
    {
        return trace(256, 2);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_INIT(Object o1)
    {
        return trace(256, 2, o1);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2)
    {
        return trace(256, 2, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3)
    {
        return trace(256, 2, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_INIT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 2, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVER_SHUTTING_DOWN()
    {
        return trace(256, 3);
    }

    public boolean trace_Revision_TM_2S_SERVER_SHUTTING_DOWN(Object o1)
    {
        return trace(256, 3, o1);
    }

    public boolean trace_Revision_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(256, 3, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(256, 3, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVER_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 3, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_CLIENT_BOOTING()
    {
        return trace(256, 4);
    }

    public boolean trace_Revision_TM_2S_CLIENT_BOOTING(Object o1)
    {
        return trace(256, 4, o1);
    }

    public boolean trace_Revision_TM_2S_CLIENT_BOOTING(Object o1, Object o2)
    {
        return trace(256, 4, o1, o2);
    }

    public boolean trace_Revision_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3)
    {
        return trace(256, 4, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_CLIENT_BOOTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 4, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_CLIENT_SHUTTING_DOWN()
    {
        return trace(256, 5);
    }

    public boolean trace_Revision_TM_2S_CLIENT_SHUTTING_DOWN(Object o1)
    {
        return trace(256, 5, o1);
    }

    public boolean trace_Revision_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2)
    {
        return trace(256, 5, o1, o2);
    }

    public boolean trace_Revision_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3)
    {
        return trace(256, 5, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_CLIENT_SHUTTING_DOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 5, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_CALLING_GETSERVICE()
    {
        return trace(256, 6);
    }

    public boolean trace_Revision_TM_1S_CALLING_GETSERVICE(Object o1)
    {
        return trace(256, 6, o1);
    }

    public boolean trace_Revision_TM_1S_CALLING_GETSERVICE(Object o1, Object o2)
    {
        return trace(256, 6, o1, o2);
    }

    public boolean trace_Revision_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3)
    {
        return trace(256, 6, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_CALLING_GETSERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 6, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_SUCCESS_FROM_SERVICE()
    {
        return trace(256, 7);
    }

    public boolean trace_Revision_TM_1S_SUCCESS_FROM_SERVICE(Object o1)
    {
        return trace(256, 7, o1);
    }

    public boolean trace_Revision_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(256, 7, o1, o2);
    }

    public boolean trace_Revision_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(256, 7, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_SUCCESS_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 7, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE()
    {
        return trace(256, 8);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE(Object o1)
    {
        return trace(256, 8, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2)
    {
        return trace(256, 8, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3)
    {
        return trace(256, 8, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 8, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN()
    {
        return trace(256, 9);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1)
    {
        return trace(256, 9, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2)
    {
        return trace(256, 9, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3)
    {
        return trace(256, 9, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 9, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY()
    {
        return trace(256, 10);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1)
    {
        return trace(256, 10, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2)
    {
        return trace(256, 10, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3)
    {
        return trace(256, 10, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 10, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION()
    {
        return trace(256, 11);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1)
    {
        return trace(256, 11, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2)
    {
        return trace(256, 11, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3)
    {
        return trace(256, 11, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 11, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN()
    {
        return trace(256, 12);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1)
    {
        return trace(256, 12, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2)
    {
        return trace(256, 12, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3)
    {
        return trace(256, 12, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 12, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_3S_ACTIVATING_RESET()
    {
        return trace(256, 13);
    }

    public boolean trace_Revision_TM_3S_ACTIVATING_RESET(Object o1)
    {
        return trace(256, 13, o1);
    }

    public boolean trace_Revision_TM_3S_ACTIVATING_RESET(Object o1, Object o2)
    {
        return trace(256, 13, o1, o2);
    }

    public boolean trace_Revision_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3)
    {
        return trace(256, 13, o1, o2, o3);
    }

    public boolean trace_Revision_TM_3S_ACTIVATING_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 13, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_4S_SUBSCRIBING()
    {
        return trace(256, 14);
    }

    public boolean trace_Revision_TM_4S_SUBSCRIBING(Object o1)
    {
        return trace(256, 14, o1);
    }

    public boolean trace_Revision_TM_4S_SUBSCRIBING(Object o1, Object o2)
    {
        return trace(256, 14, o1, o2);
    }

    public boolean trace_Revision_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3)
    {
        return trace(256, 14, o1, o2, o3);
    }

    public boolean trace_Revision_TM_4S_SUBSCRIBING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 14, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(256, 15);
    }

    public boolean trace_Revision_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return trace(256, 15, o1);
    }

    public boolean trace_Revision_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return trace(256, 15, o1, o2);
    }

    public boolean trace_Revision_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return trace(256, 15, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 15, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_3S_RESETTING()
    {
        return trace(256, 16);
    }

    public boolean trace_Revision_TM_3S_RESETTING(Object o1)
    {
        return trace(256, 16, o1);
    }

    public boolean trace_Revision_TM_3S_RESETTING(Object o1, Object o2)
    {
        return trace(256, 16, o1, o2);
    }

    public boolean trace_Revision_TM_3S_RESETTING(Object o1, Object o2, Object o3)
    {
        return trace(256, 16, o1, o2, o3);
    }

    public boolean trace_Revision_TM_3S_RESETTING(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 16, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_RESET()
    {
        return trace(256, 17);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_RESET(Object o1)
    {
        return trace(256, 17, o1);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2)
    {
        return trace(256, 17, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3)
    {
        return trace(256, 17, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVER_FAILED_RESET(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 17, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_CHECKPOINT()
    {
        return trace(256, 18);
    }

    public boolean trace_Revision_TM_1S_CHECKPOINT(Object o1)
    {
        return trace(256, 18, o1);
    }

    public boolean trace_Revision_TM_1S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(256, 18, o1, o2);
    }

    public boolean trace_Revision_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(256, 18, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 18, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_CHECKPOINT()
    {
        return trace(256, 19);
    }

    public boolean trace_Revision_TM_2S_CHECKPOINT(Object o1)
    {
        return trace(256, 19, o1);
    }

    public boolean trace_Revision_TM_2S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(256, 19, o1, o2);
    }

    public boolean trace_Revision_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(256, 19, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 19, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_3S_CHECKPOINT()
    {
        return trace(256, 20);
    }

    public boolean trace_Revision_TM_3S_CHECKPOINT(Object o1)
    {
        return trace(256, 20, o1);
    }

    public boolean trace_Revision_TM_3S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(256, 20, o1, o2);
    }

    public boolean trace_Revision_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(256, 20, o1, o2, o3);
    }

    public boolean trace_Revision_TM_3S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 20, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_4S_CHECKPOINT()
    {
        return trace(256, 21);
    }

    public boolean trace_Revision_TM_4S_CHECKPOINT(Object o1)
    {
        return trace(256, 21, o1);
    }

    public boolean trace_Revision_TM_4S_CHECKPOINT(Object o1, Object o2)
    {
        return trace(256, 21, o1, o2);
    }

    public boolean trace_Revision_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3)
    {
        return trace(256, 21, o1, o2, o3);
    }

    public boolean trace_Revision_TM_4S_CHECKPOINT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 21, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_3S_DEBUG_MSG()
    {
        return trace(256, 22);
    }

    public boolean trace_Revision_TM_3S_DEBUG_MSG(Object o1)
    {
        return trace(256, 22, o1);
    }

    public boolean trace_Revision_TM_3S_DEBUG_MSG(Object o1, Object o2)
    {
        return trace(256, 22, o1, o2);
    }

    public boolean trace_Revision_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3)
    {
        return trace(256, 22, o1, o2, o3);
    }

    public boolean trace_Revision_TM_3S_DEBUG_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 22, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_DATA_OUTPUT()
    {
        return trace(256, 23);
    }

    public boolean trace_Revision_TM_2S_DATA_OUTPUT(Object o1)
    {
        return trace(256, 23, o1);
    }

    public boolean trace_Revision_TM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return trace(256, 23, o1, o2);
    }

    public boolean trace_Revision_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return trace(256, 23, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 23, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVICE_ENTRY_DATA()
    {
        return trace(256, 24);
    }

    public boolean trace_Revision_TM_2S_SERVICE_ENTRY_DATA(Object o1)
    {
        return trace(256, 24, o1);
    }

    public boolean trace_Revision_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2)
    {
        return trace(256, 24, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3)
    {
        return trace(256, 24, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVICE_ENTRY_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 24, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_SERVICE_EXIT_DATA()
    {
        return trace(256, 25);
    }

    public boolean trace_Revision_TM_2S_SERVICE_EXIT_DATA(Object o1)
    {
        return trace(256, 25, o1);
    }

    public boolean trace_Revision_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2)
    {
        return trace(256, 25, o1, o2);
    }

    public boolean trace_Revision_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3)
    {
        return trace(256, 25, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_SERVICE_EXIT_DATA(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 25, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN()
    {
        return trace(256, 26);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1)
    {
        return trace(256, 26, o1);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2)
    {
        return trace(256, 26, o1, o2);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3)
    {
        return trace(256, 26, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 26, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_0S_CONNECTING_TO_DB()
    {
        return trace(256, 27);
    }

    public boolean trace_Revision_TM_0S_CONNECTING_TO_DB(Object o1)
    {
        return trace(256, 27, o1);
    }

    public boolean trace_Revision_TM_0S_CONNECTING_TO_DB(Object o1, Object o2)
    {
        return trace(256, 27, o1, o2);
    }

    public boolean trace_Revision_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3)
    {
        return trace(256, 27, o1, o2, o3);
    }

    public boolean trace_Revision_TM_0S_CONNECTING_TO_DB(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 27, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_CONFIG_READING_FILE()
    {
        return trace(256, 28);
    }

    public boolean trace_Revision_TM_1S_CONFIG_READING_FILE(Object o1)
    {
        return trace(256, 28, o1);
    }

    public boolean trace_Revision_TM_1S_CONFIG_READING_FILE(Object o1, Object o2)
    {
        return trace(256, 28, o1, o2);
    }

    public boolean trace_Revision_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3)
    {
        return trace(256, 28, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_CONFIG_READING_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 28, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_1S_REVISION()
    {
        return trace(256, 29);
    }

    public boolean trace_Revision_TM_1S_REVISION(Object o1)
    {
        return trace(256, 29, o1);
    }

    public boolean trace_Revision_TM_1S_REVISION(Object o1, Object o2)
    {
        return trace(256, 29, o1, o2);
    }

    public boolean trace_Revision_TM_1S_REVISION(Object o1, Object o2, Object o3)
    {
        return trace(256, 29, o1, o2, o3);
    }

    public boolean trace_Revision_TM_1S_REVISION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 29, o1, o2, o3, o4);
    }

    public boolean trace_Revision_TM_2S_ARM_ACTION()
    {
        return trace(256, 30);
    }

    public boolean trace_Revision_TM_2S_ARM_ACTION(Object o1)
    {
        return trace(256, 30, o1);
    }

    public boolean trace_Revision_TM_2S_ARM_ACTION(Object o1, Object o2)
    {
        return trace(256, 30, o1, o2);
    }

    public boolean trace_Revision_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3)
    {
        return trace(256, 30, o1, o2, o3);
    }

    public boolean trace_Revision_TM_2S_ARM_ACTION(Object o1, Object o2, Object o3, Object o4)
    {
        return trace(256, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug(int ai_code)
    {
        return trace(0, ai_code);
    }

    public boolean triggerNotify_Debug(int ai_code, Object o1)
    {
        return triggerNotify(0, ai_code, o1);
    }

    public boolean triggerNotify_Debug(int ai_code, Object o1, Object o2)
    {
        return triggerNotify(0, ai_code, o1, o2);
    }

    public boolean triggerNotify_Debug(int ai_code, Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, ai_code, o1, o2, o3);
    }

    public boolean triggerNotify_Debug(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, ai_code, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug(int ai_code)
        throws Notify
    {
        return trace(0, ai_code);
    }

    public boolean throwNotify_Debug(int ai_code, Object o1)
        throws Notify
    {
        return throwNotify(0, ai_code, o1);
    }

    public boolean throwNotify_Debug(int ai_code, Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, ai_code, o1, o2);
    }

    public boolean throwNotify_Debug(int ai_code, Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, ai_code, o1, o2, o3);
    }

    public boolean throwNotify_Debug(int ai_code, Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, ai_code, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_LOAD_ERROR()
    {
        return trace(0, 0);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1)
    {
        return triggerNotify(0, 0, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 0, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 0, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 0, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_LOAD_ERROR()
        throws Notify
    {
        return trace(0, 0);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 0, o1);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 0, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 0, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 0, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_VERSION_ERROR()
    {
        return trace(0, 1);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1)
    {
        return triggerNotify(0, 1, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 1, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 1, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 1, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_VERSION_ERROR()
        throws Notify
    {
        return trace(0, 1);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 1, o1);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 1, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 1, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 1, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_0S_EDIT_READ_ERROR()
    {
        return trace(0, 2);
    }

    public boolean triggerNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1)
    {
        return triggerNotify(0, 2, o1);
    }

    public boolean triggerNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 2, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 2, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 2, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_0S_EDIT_READ_ERROR()
        throws Notify
    {
        return trace(0, 2);
    }

    public boolean throwNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 2, o1);
    }

    public boolean throwNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 2, o1, o2);
    }

    public boolean throwNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 2, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 2, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY()
    {
        return trace(0, 3);
    }

    public boolean triggerNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
    {
        return triggerNotify(0, 3, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
    {
        return triggerNotify(0, 3, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 3, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 3, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY()
        throws Notify
    {
        return trace(0, 3);
    }

    public boolean throwNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
        throws Notify
    {
        return throwNotify(0, 3, o1);
    }

    public boolean throwNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 3, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 3, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 3, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_CORRUPTION_ERROR()
    {
        return trace(0, 4);
    }

    public boolean triggerNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1)
    {
        return triggerNotify(0, 4, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 4, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 4, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 4, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_CORRUPTION_ERROR()
        throws Notify
    {
        return trace(0, 4);
    }

    public boolean throwNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 4, o1);
    }

    public boolean throwNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 4, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 4, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 4, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_CONSECUTIVE_ERRORS()
    {
        return trace(0, 5);
    }

    public boolean triggerNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1)
    {
        return triggerNotify(0, 5, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
    {
        return triggerNotify(0, 5, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 5, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 5, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_CONSECUTIVE_ERRORS()
        throws Notify
    {
        return trace(0, 5);
    }

    public boolean throwNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1)
        throws Notify
    {
        return throwNotify(0, 5, o1);
    }

    public boolean throwNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 5, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 5, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 5, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_ERROR()
    {
        return trace(0, 6);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1)
    {
        return triggerNotify(0, 6, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 6, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 6, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 6, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_ERROR()
        throws Notify
    {
        return trace(0, 6);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 6, o1);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 6, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 6, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 6, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_INFO()
    {
        return trace(0, 7);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1)
    {
        return triggerNotify(0, 7, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
    {
        return triggerNotify(0, 7, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 7, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 7, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_INFO()
        throws Notify
    {
        return trace(0, 7);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1)
        throws Notify
    {
        return throwNotify(0, 7, o1);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 7, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 7, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 7, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_WARN()
    {
        return trace(0, 8);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1)
    {
        return triggerNotify(0, 8, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
    {
        return triggerNotify(0, 8, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 8, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 8, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_WARN()
        throws Notify
    {
        return trace(0, 8);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1)
        throws Notify
    {
        return throwNotify(0, 8, o1);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 8, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 8, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 8, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_ERROR()
    {
        return trace(0, 9);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1)
    {
        return triggerNotify(0, 9, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 9, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 9, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 9, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_ERROR()
        throws Notify
    {
        return trace(0, 9);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 9, o1);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 9, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 9, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 9, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_FATAL()
    {
        return trace(0, 10);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1)
    {
        return triggerNotify(0, 10, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
    {
        return triggerNotify(0, 10, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 10, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 10, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_FATAL()
        throws Notify
    {
        return trace(0, 10);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(0, 10, o1);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 10, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 10, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 10, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_0S_NO_MIDDLEWARE()
    {
        return trace(0, 11);
    }

    public boolean triggerNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1)
    {
        return triggerNotify(0, 11, o1);
    }

    public boolean triggerNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
    {
        return triggerNotify(0, 11, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 11, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 11, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_0S_NO_MIDDLEWARE()
        throws Notify
    {
        return trace(0, 11);
    }

    public boolean throwNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1)
        throws Notify
    {
        return throwNotify(0, 11, o1);
    }

    public boolean throwNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 11, o1, o2);
    }

    public boolean throwNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 11, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 11, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_FAILED()
    {
        return trace(0, 12);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1)
    {
        return triggerNotify(0, 12, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
    {
        return triggerNotify(0, 12, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 12, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 12, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_FAILED()
        throws Notify
    {
        return trace(0, 12);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(0, 12, o1);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 12, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 12, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 12, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_CALL_FAILED()
    {
        return trace(0, 13);
    }

    public boolean triggerNotify_Debug_LM_1S_CALL_FAILED(Object o1)
    {
        return triggerNotify(0, 13, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(0, 13, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 13, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 13, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_CALL_FAILED()
        throws Notify
    {
        return trace(0, 13);
    }

    public boolean throwNotify_Debug_LM_1S_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(0, 13, o1);
    }

    public boolean throwNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 13, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 13, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 13, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_QUEUE_ERROR()
    {
        return trace(0, 14);
    }

    public boolean triggerNotify_Debug_LM_1S_QUEUE_ERROR(Object o1)
    {
        return triggerNotify(0, 14, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 14, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 14, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 14, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_QUEUE_ERROR()
        throws Notify
    {
        return trace(0, 14);
    }

    public boolean throwNotify_Debug_LM_1S_QUEUE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 14, o1);
    }

    public boolean throwNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 14, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 14, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 14, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_REQUIRED()
    {
        return trace(0, 15);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1)
    {
        return triggerNotify(0, 15, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
    {
        return triggerNotify(0, 15, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 15, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 15, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_REQUIRED()
        throws Notify
    {
        return trace(0, 15);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1)
        throws Notify
    {
        return throwNotify(0, 15, o1);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 15, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 15, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 15, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_TPOPEN_FAIL()
    {
        return trace(0, 16);
    }

    public boolean triggerNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1)
    {
        return triggerNotify(0, 16, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
    {
        return triggerNotify(0, 16, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 16, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 16, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_TPOPEN_FAIL()
        throws Notify
    {
        return trace(0, 16);
    }

    public boolean throwNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(0, 16, o1);
    }

    public boolean throwNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 16, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 16, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 16, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_TPCLOSE_FAIL()
    {
        return trace(0, 17);
    }

    public boolean triggerNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1)
    {
        return triggerNotify(0, 17, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
    {
        return triggerNotify(0, 17, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 17, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 17, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_TPCLOSE_FAIL()
        throws Notify
    {
        return trace(0, 17);
    }

    public boolean throwNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(0, 17, o1);
    }

    public boolean throwNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 17, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 17, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 17, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_TRANSACTION_ERROR()
    {
        return trace(0, 18);
    }

    public boolean triggerNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1)
    {
        return triggerNotify(0, 18, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 18, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 18, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 18, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_TRANSACTION_ERROR()
        throws Notify
    {
        return trace(0, 18);
    }

    public boolean throwNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 18, o1);
    }

    public boolean throwNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 18, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 18, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 18, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_CONNECT_DB_FAIL()
    {
        return trace(0, 19);
    }

    public boolean triggerNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1)
    {
        return triggerNotify(0, 19, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
    {
        return triggerNotify(0, 19, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 19, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 19, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_CONNECT_DB_FAIL()
        throws Notify
    {
        return trace(0, 19);
    }

    public boolean throwNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(0, 19, o1);
    }

    public boolean throwNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 19, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 19, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 19, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_DB_ERROR()
    {
        return trace(0, 20);
    }

    public boolean triggerNotify_Debug_LM_3S_DB_ERROR(Object o1)
    {
        return triggerNotify(0, 20, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 20, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 20, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 20, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_DB_ERROR()
        throws Notify
    {
        return trace(0, 20);
    }

    public boolean throwNotify_Debug_LM_3S_DB_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 20, o1);
    }

    public boolean throwNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 20, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 20, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 20, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR()
    {
        return trace(0, 21);
    }

    public boolean triggerNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
    {
        return triggerNotify(0, 21, o1);
    }

    public boolean triggerNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 21, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 21, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 21, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR()
        throws Notify
    {
        return trace(0, 21);
    }

    public boolean throwNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 21, o1);
    }

    public boolean throwNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 21, o1, o2);
    }

    public boolean throwNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 21, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 21, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_NOENTRY()
    {
        return trace(0, 22);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_NOENTRY(Object o1)
    {
        return triggerNotify(0, 22, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2)
    {
        return triggerNotify(0, 22, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 22, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 22, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_DB_NOENTRY()
        throws Notify
    {
        return trace(0, 22);
    }

    public boolean throwNotify_Debug_LM_2S_DB_NOENTRY(Object o1)
        throws Notify
    {
        return throwNotify(0, 22, o1);
    }

    public boolean throwNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 22, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 22, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 22, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY()
    {
        return trace(0, 23);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
    {
        return triggerNotify(0, 23, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
    {
        return triggerNotify(0, 23, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 23, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 23, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY()
        throws Notify
    {
        return trace(0, 23);
    }

    public boolean throwNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
        throws Notify
    {
        return throwNotify(0, 23, o1);
    }

    public boolean throwNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 23, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 23, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 23, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_DB_INVALID_RESULTS()
    {
        return trace(0, 24);
    }

    public boolean triggerNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1)
    {
        return triggerNotify(0, 24, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
    {
        return triggerNotify(0, 24, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 24, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 24, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_DB_INVALID_RESULTS()
        throws Notify
    {
        return trace(0, 24);
    }

    public boolean throwNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1)
        throws Notify
    {
        return throwNotify(0, 24, o1);
    }

    public boolean throwNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 24, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 24, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 24, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION()
    {
        return trace(0, 25);
    }

    public boolean triggerNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(0, 25, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(0, 25, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 25, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 25, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION()
        throws Notify
    {
        return trace(0, 25);
    }

    public boolean throwNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(0, 25, o1);
    }

    public boolean throwNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 25, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 25, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 25, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_4S_FX_EXCEPTION()
    {
        return trace(0, 26);
    }

    public boolean triggerNotify_Debug_LM_4S_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(0, 26, o1);
    }

    public boolean triggerNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(0, 26, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 26, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 26, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_4S_FX_EXCEPTION()
        throws Notify
    {
        return trace(0, 26);
    }

    public boolean throwNotify_Debug_LM_4S_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(0, 26, o1);
    }

    public boolean throwNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 26, o1, o2);
    }

    public boolean throwNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 26, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 26, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_SVCBASE_CALL_FAILED()
    {
        return trace(0, 27);
    }

    public boolean triggerNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1)
    {
        return triggerNotify(0, 27, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(0, 27, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 27, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 27, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_SVCBASE_CALL_FAILED()
        throws Notify
    {
        return trace(0, 27);
    }

    public boolean throwNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(0, 27, o1);
    }

    public boolean throwNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 27, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 27, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 27, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_0S_INVALID_DATAMANAGER()
    {
        return trace(0, 28);
    }

    public boolean triggerNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1)
    {
        return triggerNotify(0, 28, o1);
    }

    public boolean triggerNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
    {
        return triggerNotify(0, 28, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 28, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 28, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_0S_INVALID_DATAMANAGER()
        throws Notify
    {
        return trace(0, 28);
    }

    public boolean throwNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1)
        throws Notify
    {
        return throwNotify(0, 28, o1);
    }

    public boolean throwNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 28, o1, o2);
    }

    public boolean throwNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 28, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 28, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_STANDARD_EXCEPTION()
    {
        return trace(0, 29);
    }

    public boolean triggerNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1)
    {
        return triggerNotify(0, 29, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(0, 29, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 29, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 29, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_STANDARD_EXCEPTION()
        throws Notify
    {
        return trace(0, 29);
    }

    public boolean throwNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(0, 29, o1);
    }

    public boolean throwNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 29, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 29, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 29, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION()
    {
        return trace(0, 30);
    }

    public boolean triggerNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
    {
        return triggerNotify(0, 30, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(0, 30, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 30, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 30, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION()
        throws Notify
    {
        return trace(0, 30);
    }

    public boolean throwNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(0, 30, o1);
    }

    public boolean throwNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 30, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 30, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG()
    {
        return trace(0, 31);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
    {
        return triggerNotify(0, 31, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
    {
        return triggerNotify(0, 31, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 31, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 31, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG()
        throws Notify
    {
        return trace(0, 31);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
        throws Notify
    {
        return throwNotify(0, 31, o1);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 31, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 31, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 31, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_DATA_TYPE()
    {
        return trace(0, 32);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1)
    {
        return triggerNotify(0, 32, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
    {
        return triggerNotify(0, 32, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 32, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 32, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_DATA_TYPE()
        throws Notify
    {
        return trace(0, 32);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(0, 32, o1);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 32, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 32, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 32, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_GET()
    {
        return trace(0, 33);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1)
    {
        return triggerNotify(0, 33, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
    {
        return triggerNotify(0, 33, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 33, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 33, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_GET()
        throws Notify
    {
        return trace(0, 33);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1)
        throws Notify
    {
        return throwNotify(0, 33, o1);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 33, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 33, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 33, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CREATE()
    {
        return trace(0, 34);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1)
    {
        return triggerNotify(0, 34, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
    {
        return triggerNotify(0, 34, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 34, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 34, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CREATE()
        throws Notify
    {
        return trace(0, 34);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1)
        throws Notify
    {
        return throwNotify(0, 34, o1);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 34, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 34, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 34, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CTL()
    {
        return trace(0, 35);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1)
    {
        return triggerNotify(0, 35, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
    {
        return triggerNotify(0, 35, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 35, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 35, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CTL()
        throws Notify
    {
        return trace(0, 35);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1)
        throws Notify
    {
        return throwNotify(0, 35, o1);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 35, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 35, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 35, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_OP()
    {
        return trace(0, 36);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1)
    {
        return triggerNotify(0, 36, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
    {
        return triggerNotify(0, 36, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 36, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 36, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_OP()
        throws Notify
    {
        return trace(0, 36);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1)
        throws Notify
    {
        return throwNotify(0, 36, o1);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 36, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 36, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 36, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_4S_UNKNOWN_CODE()
    {
        return trace(0, 37);
    }

    public boolean triggerNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1)
    {
        return triggerNotify(0, 37, o1);
    }

    public boolean triggerNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return triggerNotify(0, 37, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 37, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 37, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_4S_UNKNOWN_CODE()
        throws Notify
    {
        return trace(0, 37);
    }

    public boolean throwNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1)
        throws Notify
    {
        return throwNotify(0, 37, o1);
    }

    public boolean throwNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 37, o1, o2);
    }

    public boolean throwNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 37, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 37, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_INIT_OBJECT()
    {
        return trace(0, 38);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1)
    {
        return triggerNotify(0, 38, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
    {
        return triggerNotify(0, 38, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 38, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 38, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_INIT_OBJECT()
        throws Notify
    {
        return trace(0, 38);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1)
        throws Notify
    {
        return throwNotify(0, 38, o1);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 38, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 38, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 38, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_OPEN_FILE()
    {
        return trace(0, 39);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1)
    {
        return triggerNotify(0, 39, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
    {
        return triggerNotify(0, 39, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 39, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 39, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_OPEN_FILE()
        throws Notify
    {
        return trace(0, 39);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1)
        throws Notify
    {
        return throwNotify(0, 39, o1);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 39, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 39, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 39, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_SYSTEM_CALL()
    {
        return trace(0, 40);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1)
    {
        return triggerNotify(0, 40, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
    {
        return triggerNotify(0, 40, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 40, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 40, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_SYSTEM_CALL()
        throws Notify
    {
        return trace(0, 40);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1)
        throws Notify
    {
        return throwNotify(0, 40, o1);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 40, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 40, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 40, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_DATA_OUTPUT()
    {
        return trace(0, 41);
    }

    public boolean triggerNotify_Debug_LM_2S_DATA_OUTPUT(Object o1)
    {
        return triggerNotify(0, 41, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return triggerNotify(0, 41, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 41, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 41, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_DATA_OUTPUT()
        throws Notify
    {
        return trace(0, 41);
    }

    public boolean throwNotify_Debug_LM_2S_DATA_OUTPUT(Object o1)
        throws Notify
    {
        return throwNotify(0, 41, o1);
    }

    public boolean throwNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 41, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 41, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 41, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(0, 42);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return triggerNotify(0, 42, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return triggerNotify(0, 42, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 42, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 42, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
        throws Notify
    {
        return trace(0, 42);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(0, 42, o1);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 42, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 42, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 42, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_ARM_FAILURE()
    {
        return trace(0, 43);
    }

    public boolean triggerNotify_Debug_LM_2S_ARM_FAILURE(Object o1)
    {
        return triggerNotify(0, 43, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(0, 43, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 43, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 43, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_ARM_FAILURE()
        throws Notify
    {
        return trace(0, 43);
    }

    public boolean throwNotify_Debug_LM_2S_ARM_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(0, 43, o1);
    }

    public boolean throwNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 43, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 43, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 43, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL()
    {
        return trace(0, 44);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
    {
        return triggerNotify(0, 44, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
    {
        return triggerNotify(0, 44, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 44, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 44, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL()
        throws Notify
    {
        return trace(0, 44);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(0, 44, o1);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 44, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 44, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 44, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN()
    {
        return trace(0, 45);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
    {
        return triggerNotify(0, 45, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
    {
        return triggerNotify(0, 45, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 45, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 45, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN()
        throws Notify
    {
        return trace(0, 45);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
        throws Notify
    {
        return throwNotify(0, 45, o1);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 45, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 45, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 45, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_3S_MQ_FAILURE()
    {
        return trace(0, 46);
    }

    public boolean triggerNotify_Debug_LM_3S_MQ_FAILURE(Object o1)
    {
        return triggerNotify(0, 46, o1);
    }

    public boolean triggerNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(0, 46, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 46, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 46, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_3S_MQ_FAILURE()
        throws Notify
    {
        return trace(0, 46);
    }

    public boolean throwNotify_Debug_LM_3S_MQ_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(0, 46, o1);
    }

    public boolean throwNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 46, o1, o2);
    }

    public boolean throwNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 46, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 46, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_MQ_MESSAGE()
    {
        return trace(0, 47);
    }

    public boolean triggerNotify_Debug_LM_1S_MQ_MESSAGE(Object o1)
    {
        return triggerNotify(0, 47, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(0, 47, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 47, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 47, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_MQ_MESSAGE()
        throws Notify
    {
        return trace(0, 47);
    }

    public boolean throwNotify_Debug_LM_1S_MQ_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(0, 47, o1);
    }

    public boolean throwNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 47, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 47, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 47, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_ASN_FAILURE()
    {
        return trace(0, 48);
    }

    public boolean triggerNotify_Debug_LM_1S_ASN_FAILURE(Object o1)
    {
        return triggerNotify(0, 48, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(0, 48, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 48, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 48, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_ASN_FAILURE()
        throws Notify
    {
        return trace(0, 48);
    }

    public boolean throwNotify_Debug_LM_1S_ASN_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(0, 48, o1);
    }

    public boolean throwNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 48, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 48, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 48, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_ASN_FAILED()
    {
        return trace(0, 49);
    }

    public boolean triggerNotify_Debug_LM_2S_ASN_FAILED(Object o1)
    {
        return triggerNotify(0, 49, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2)
    {
        return triggerNotify(0, 49, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 49, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 49, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_ASN_FAILED()
        throws Notify
    {
        return trace(0, 49);
    }

    public boolean throwNotify_Debug_LM_2S_ASN_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(0, 49, o1);
    }

    public boolean throwNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 49, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 49, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 49, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_OID_TYPE()
    {
        return trace(0, 50);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1)
    {
        return triggerNotify(0, 50, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
    {
        return triggerNotify(0, 50, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 50, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 50, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_OID_TYPE()
        throws Notify
    {
        return trace(0, 50);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(0, 50, o1);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 50, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 50, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 50, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_OIDFACTORY_FAILED()
    {
        return trace(0, 51);
    }

    public boolean triggerNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1)
    {
        return triggerNotify(0, 51, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
    {
        return triggerNotify(0, 51, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 51, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 51, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_OIDFACTORY_FAILED()
        throws Notify
    {
        return trace(0, 51);
    }

    public boolean throwNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(0, 51, o1);
    }

    public boolean throwNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 51, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 51, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 51, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE()
    {
        return trace(0, 52);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
    {
        return triggerNotify(0, 52, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
    {
        return triggerNotify(0, 52, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 52, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 52, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE()
        throws Notify
    {
        return trace(0, 52);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
        throws Notify
    {
        return throwNotify(0, 52, o1);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 52, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 52, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 52, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_2S_FAILED_MEM_ALLOC()
    {
        return trace(0, 53);
    }

    public boolean triggerNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1)
    {
        return triggerNotify(0, 53, o1);
    }

    public boolean triggerNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
    {
        return triggerNotify(0, 53, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 53, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 53, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_2S_FAILED_MEM_ALLOC()
        throws Notify
    {
        return trace(0, 53);
    }

    public boolean throwNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1)
        throws Notify
    {
        return throwNotify(0, 53, o1);
    }

    public boolean throwNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 53, o1, o2);
    }

    public boolean throwNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 53, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 53, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_CREATE_OID_ERROR()
    {
        return trace(0, 54);
    }

    public boolean triggerNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1)
    {
        return triggerNotify(0, 54, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
    {
        return triggerNotify(0, 54, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 54, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 54, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_CREATE_OID_ERROR()
        throws Notify
    {
        return trace(0, 54);
    }

    public boolean throwNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(0, 54, o1);
    }

    public boolean throwNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 54, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 54, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 54, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN()
    {
        return trace(0, 55);
    }

    public boolean triggerNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
    {
        return triggerNotify(0, 55, o1);
    }

    public boolean triggerNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
    {
        return triggerNotify(0, 55, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 55, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 55, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN()
        throws Notify
    {
        return trace(0, 55);
    }

    public boolean throwNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
        throws Notify
    {
        return throwNotify(0, 55, o1);
    }

    public boolean throwNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 55, o1, o2);
    }

    public boolean throwNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 55, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 55, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_4S_WARN_MESSAGE()
    {
        return trace(0, 56);
    }

    public boolean triggerNotify_Debug_LM_4S_WARN_MESSAGE(Object o1)
    {
        return triggerNotify(0, 56, o1);
    }

    public boolean triggerNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(0, 56, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 56, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 56, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_4S_WARN_MESSAGE()
        throws Notify
    {
        return trace(0, 56);
    }

    public boolean throwNotify_Debug_LM_4S_WARN_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(0, 56, o1);
    }

    public boolean throwNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 56, o1, o2);
    }

    public boolean throwNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 56, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 56, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Debug_LM_5S_USER_LOGOUT()
    {
        return trace(0, 57);
    }

    public boolean triggerNotify_Debug_LM_5S_USER_LOGOUT(Object o1)
    {
        return triggerNotify(0, 57, o1);
    }

    public boolean triggerNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2)
    {
        return triggerNotify(0, 57, o1, o2);
    }

    public boolean triggerNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(0, 57, o1, o2, o3);
    }

    public boolean triggerNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(0, 57, o1, o2, o3, o4);
    }

    public boolean throwNotify_Debug_LM_5S_USER_LOGOUT()
        throws Notify
    {
        return trace(0, 57);
    }

    public boolean throwNotify_Debug_LM_5S_USER_LOGOUT(Object o1)
        throws Notify
    {
        return throwNotify(0, 57, o1);
    }

    public boolean throwNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(0, 57, o1, o2);
    }

    public boolean throwNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(0, 57, o1, o2, o3);
    }

    public boolean throwNotify_Debug_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(0, 57, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info(int ai_code)
    {
        return trace(1, ai_code);
    }

    public boolean triggerNotify_Info(int ai_code, Object o1)
    {
        return triggerNotify(1, ai_code, o1);
    }

    public boolean triggerNotify_Info(int ai_code, Object o1, Object o2)
    {
        return triggerNotify(1, ai_code, o1, o2);
    }

    public boolean triggerNotify_Info(int ai_code, Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, ai_code, o1, o2, o3);
    }

    public boolean triggerNotify_Info(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, ai_code, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info(int ai_code)
        throws Notify
    {
        return trace(1, ai_code);
    }

    public boolean throwNotify_Info(int ai_code, Object o1)
        throws Notify
    {
        return throwNotify(1, ai_code, o1);
    }

    public boolean throwNotify_Info(int ai_code, Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, ai_code, o1, o2);
    }

    public boolean throwNotify_Info(int ai_code, Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, ai_code, o1, o2, o3);
    }

    public boolean throwNotify_Info(int ai_code, Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, ai_code, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_LOAD_ERROR()
    {
        return trace(1, 0);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1)
    {
        return triggerNotify(1, 0, o1);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 0, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 0, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 0, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_LOAD_ERROR()
        throws Notify
    {
        return trace(1, 0);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 0, o1);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 0, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 0, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 0, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_VERSION_ERROR()
    {
        return trace(1, 1);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1)
    {
        return triggerNotify(1, 1, o1);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 1, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 1, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 1, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_VERSION_ERROR()
        throws Notify
    {
        return trace(1, 1);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 1, o1);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 1, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 1, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 1, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_0S_EDIT_READ_ERROR()
    {
        return trace(1, 2);
    }

    public boolean triggerNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1)
    {
        return triggerNotify(1, 2, o1);
    }

    public boolean triggerNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 2, o1, o2);
    }

    public boolean triggerNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 2, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 2, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_0S_EDIT_READ_ERROR()
        throws Notify
    {
        return trace(1, 2);
    }

    public boolean throwNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 2, o1);
    }

    public boolean throwNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 2, o1, o2);
    }

    public boolean throwNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 2, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 2, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_INTERNAL_INCONSISTANCY()
    {
        return trace(1, 3);
    }

    public boolean triggerNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
    {
        return triggerNotify(1, 3, o1);
    }

    public boolean triggerNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
    {
        return triggerNotify(1, 3, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 3, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 3, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_INTERNAL_INCONSISTANCY()
        throws Notify
    {
        return trace(1, 3);
    }

    public boolean throwNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
        throws Notify
    {
        return throwNotify(1, 3, o1);
    }

    public boolean throwNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 3, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 3, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 3, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_CORRUPTION_ERROR()
    {
        return trace(1, 4);
    }

    public boolean triggerNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1)
    {
        return triggerNotify(1, 4, o1);
    }

    public boolean triggerNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 4, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 4, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 4, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_CORRUPTION_ERROR()
        throws Notify
    {
        return trace(1, 4);
    }

    public boolean throwNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 4, o1);
    }

    public boolean throwNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 4, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 4, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 4, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_CONSECUTIVE_ERRORS()
    {
        return trace(1, 5);
    }

    public boolean triggerNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1)
    {
        return triggerNotify(1, 5, o1);
    }

    public boolean triggerNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
    {
        return triggerNotify(1, 5, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 5, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 5, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_CONSECUTIVE_ERRORS()
        throws Notify
    {
        return trace(1, 5);
    }

    public boolean throwNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1)
        throws Notify
    {
        return throwNotify(1, 5, o1);
    }

    public boolean throwNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 5, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 5, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 5, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_ERROR()
    {
        return trace(1, 6);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1)
    {
        return triggerNotify(1, 6, o1);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 6, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 6, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 6, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_ERROR()
        throws Notify
    {
        return trace(1, 6);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 6, o1);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 6, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 6, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 6, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_INFO()
    {
        return trace(1, 7);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1)
    {
        return triggerNotify(1, 7, o1);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
    {
        return triggerNotify(1, 7, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 7, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 7, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_INFO()
        throws Notify
    {
        return trace(1, 7);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1)
        throws Notify
    {
        return throwNotify(1, 7, o1);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 7, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 7, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 7, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_WARN()
    {
        return trace(1, 8);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1)
    {
        return triggerNotify(1, 8, o1);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
    {
        return triggerNotify(1, 8, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 8, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 8, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_WARN()
        throws Notify
    {
        return trace(1, 8);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1)
        throws Notify
    {
        return throwNotify(1, 8, o1);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 8, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 8, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 8, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_ERROR()
    {
        return trace(1, 9);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1)
    {
        return triggerNotify(1, 9, o1);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 9, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 9, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 9, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_ERROR()
        throws Notify
    {
        return trace(1, 9);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 9, o1);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 9, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 9, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 9, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_FATAL()
    {
        return trace(1, 10);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1)
    {
        return triggerNotify(1, 10, o1);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
    {
        return triggerNotify(1, 10, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 10, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 10, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_FATAL()
        throws Notify
    {
        return trace(1, 10);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(1, 10, o1);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 10, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 10, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 10, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_0S_NO_MIDDLEWARE()
    {
        return trace(1, 11);
    }

    public boolean triggerNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1)
    {
        return triggerNotify(1, 11, o1);
    }

    public boolean triggerNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
    {
        return triggerNotify(1, 11, o1, o2);
    }

    public boolean triggerNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 11, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 11, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_0S_NO_MIDDLEWARE()
        throws Notify
    {
        return trace(1, 11);
    }

    public boolean throwNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1)
        throws Notify
    {
        return throwNotify(1, 11, o1);
    }

    public boolean throwNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 11, o1, o2);
    }

    public boolean throwNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 11, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 11, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_FAILED()
    {
        return trace(1, 12);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1)
    {
        return triggerNotify(1, 12, o1);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
    {
        return triggerNotify(1, 12, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 12, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 12, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_FAILED()
        throws Notify
    {
        return trace(1, 12);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(1, 12, o1);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 12, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 12, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 12, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_CALL_FAILED()
    {
        return trace(1, 13);
    }

    public boolean triggerNotify_Info_LM_1S_CALL_FAILED(Object o1)
    {
        return triggerNotify(1, 13, o1);
    }

    public boolean triggerNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(1, 13, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 13, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 13, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_CALL_FAILED()
        throws Notify
    {
        return trace(1, 13);
    }

    public boolean throwNotify_Info_LM_1S_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(1, 13, o1);
    }

    public boolean throwNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 13, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 13, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 13, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_QUEUE_ERROR()
    {
        return trace(1, 14);
    }

    public boolean triggerNotify_Info_LM_1S_QUEUE_ERROR(Object o1)
    {
        return triggerNotify(1, 14, o1);
    }

    public boolean triggerNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 14, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 14, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 14, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_QUEUE_ERROR()
        throws Notify
    {
        return trace(1, 14);
    }

    public boolean throwNotify_Info_LM_1S_QUEUE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 14, o1);
    }

    public boolean throwNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 14, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 14, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 14, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_REQUIRED()
    {
        return trace(1, 15);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1)
    {
        return triggerNotify(1, 15, o1);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
    {
        return triggerNotify(1, 15, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 15, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 15, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_REQUIRED()
        throws Notify
    {
        return trace(1, 15);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1)
        throws Notify
    {
        return throwNotify(1, 15, o1);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 15, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 15, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 15, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_TPOPEN_FAIL()
    {
        return trace(1, 16);
    }

    public boolean triggerNotify_Info_LM_2S_TPOPEN_FAIL(Object o1)
    {
        return triggerNotify(1, 16, o1);
    }

    public boolean triggerNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
    {
        return triggerNotify(1, 16, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 16, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 16, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_TPOPEN_FAIL()
        throws Notify
    {
        return trace(1, 16);
    }

    public boolean throwNotify_Info_LM_2S_TPOPEN_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(1, 16, o1);
    }

    public boolean throwNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 16, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 16, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 16, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_TPCLOSE_FAIL()
    {
        return trace(1, 17);
    }

    public boolean triggerNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1)
    {
        return triggerNotify(1, 17, o1);
    }

    public boolean triggerNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
    {
        return triggerNotify(1, 17, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 17, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 17, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_TPCLOSE_FAIL()
        throws Notify
    {
        return trace(1, 17);
    }

    public boolean throwNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(1, 17, o1);
    }

    public boolean throwNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 17, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 17, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 17, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_TRANSACTION_ERROR()
    {
        return trace(1, 18);
    }

    public boolean triggerNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1)
    {
        return triggerNotify(1, 18, o1);
    }

    public boolean triggerNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 18, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 18, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 18, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_TRANSACTION_ERROR()
        throws Notify
    {
        return trace(1, 18);
    }

    public boolean throwNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 18, o1);
    }

    public boolean throwNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 18, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 18, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 18, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_CONNECT_DB_FAIL()
    {
        return trace(1, 19);
    }

    public boolean triggerNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1)
    {
        return triggerNotify(1, 19, o1);
    }

    public boolean triggerNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
    {
        return triggerNotify(1, 19, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 19, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 19, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_CONNECT_DB_FAIL()
        throws Notify
    {
        return trace(1, 19);
    }

    public boolean throwNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(1, 19, o1);
    }

    public boolean throwNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 19, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 19, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 19, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_DB_ERROR()
    {
        return trace(1, 20);
    }

    public boolean triggerNotify_Info_LM_3S_DB_ERROR(Object o1)
    {
        return triggerNotify(1, 20, o1);
    }

    public boolean triggerNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 20, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 20, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 20, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_DB_ERROR()
        throws Notify
    {
        return trace(1, 20);
    }

    public boolean throwNotify_Info_LM_3S_DB_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 20, o1);
    }

    public boolean throwNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 20, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 20, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 20, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_0S_INTERNAL_TABLE_ERROR()
    {
        return trace(1, 21);
    }

    public boolean triggerNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
    {
        return triggerNotify(1, 21, o1);
    }

    public boolean triggerNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 21, o1, o2);
    }

    public boolean triggerNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 21, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 21, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_0S_INTERNAL_TABLE_ERROR()
        throws Notify
    {
        return trace(1, 21);
    }

    public boolean throwNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 21, o1);
    }

    public boolean throwNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 21, o1, o2);
    }

    public boolean throwNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 21, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 21, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_DB_NOENTRY()
    {
        return trace(1, 22);
    }

    public boolean triggerNotify_Info_LM_2S_DB_NOENTRY(Object o1)
    {
        return triggerNotify(1, 22, o1);
    }

    public boolean triggerNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2)
    {
        return triggerNotify(1, 22, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 22, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 22, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_DB_NOENTRY()
        throws Notify
    {
        return trace(1, 22);
    }

    public boolean throwNotify_Info_LM_2S_DB_NOENTRY(Object o1)
        throws Notify
    {
        return throwNotify(1, 22, o1);
    }

    public boolean throwNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 22, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 22, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 22, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY()
    {
        return trace(1, 23);
    }

    public boolean triggerNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
    {
        return triggerNotify(1, 23, o1);
    }

    public boolean triggerNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
    {
        return triggerNotify(1, 23, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 23, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 23, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY()
        throws Notify
    {
        return trace(1, 23);
    }

    public boolean throwNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
        throws Notify
    {
        return throwNotify(1, 23, o1);
    }

    public boolean throwNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 23, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 23, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 23, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_DB_INVALID_RESULTS()
    {
        return trace(1, 24);
    }

    public boolean triggerNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1)
    {
        return triggerNotify(1, 24, o1);
    }

    public boolean triggerNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
    {
        return triggerNotify(1, 24, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 24, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 24, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_DB_INVALID_RESULTS()
        throws Notify
    {
        return trace(1, 24);
    }

    public boolean throwNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1)
        throws Notify
    {
        return throwNotify(1, 24, o1);
    }

    public boolean throwNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 24, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 24, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 24, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION()
    {
        return trace(1, 25);
    }

    public boolean triggerNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(1, 25, o1);
    }

    public boolean triggerNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(1, 25, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 25, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 25, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION()
        throws Notify
    {
        return trace(1, 25);
    }

    public boolean throwNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(1, 25, o1);
    }

    public boolean throwNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 25, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 25, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 25, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_4S_FX_EXCEPTION()
    {
        return trace(1, 26);
    }

    public boolean triggerNotify_Info_LM_4S_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(1, 26, o1);
    }

    public boolean triggerNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(1, 26, o1, o2);
    }

    public boolean triggerNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 26, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 26, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_4S_FX_EXCEPTION()
        throws Notify
    {
        return trace(1, 26);
    }

    public boolean throwNotify_Info_LM_4S_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(1, 26, o1);
    }

    public boolean throwNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 26, o1, o2);
    }

    public boolean throwNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 26, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 26, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_SVCBASE_CALL_FAILED()
    {
        return trace(1, 27);
    }

    public boolean triggerNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1)
    {
        return triggerNotify(1, 27, o1);
    }

    public boolean triggerNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(1, 27, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 27, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 27, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_SVCBASE_CALL_FAILED()
        throws Notify
    {
        return trace(1, 27);
    }

    public boolean throwNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(1, 27, o1);
    }

    public boolean throwNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 27, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 27, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 27, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_0S_INVALID_DATAMANAGER()
    {
        return trace(1, 28);
    }

    public boolean triggerNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1)
    {
        return triggerNotify(1, 28, o1);
    }

    public boolean triggerNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
    {
        return triggerNotify(1, 28, o1, o2);
    }

    public boolean triggerNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 28, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 28, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_0S_INVALID_DATAMANAGER()
        throws Notify
    {
        return trace(1, 28);
    }

    public boolean throwNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1)
        throws Notify
    {
        return throwNotify(1, 28, o1);
    }

    public boolean throwNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 28, o1, o2);
    }

    public boolean throwNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 28, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 28, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_STANDARD_EXCEPTION()
    {
        return trace(1, 29);
    }

    public boolean triggerNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1)
    {
        return triggerNotify(1, 29, o1);
    }

    public boolean triggerNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(1, 29, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 29, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 29, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_STANDARD_EXCEPTION()
        throws Notify
    {
        return trace(1, 29);
    }

    public boolean throwNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(1, 29, o1);
    }

    public boolean throwNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 29, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 29, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 29, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_UNEXPECTED_EXCEPTION()
    {
        return trace(1, 30);
    }

    public boolean triggerNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
    {
        return triggerNotify(1, 30, o1);
    }

    public boolean triggerNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(1, 30, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 30, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 30, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_UNEXPECTED_EXCEPTION()
        throws Notify
    {
        return trace(1, 30);
    }

    public boolean throwNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(1, 30, o1);
    }

    public boolean throwNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 30, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 30, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG()
    {
        return trace(1, 31);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
    {
        return triggerNotify(1, 31, o1);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
    {
        return triggerNotify(1, 31, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 31, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 31, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG()
        throws Notify
    {
        return trace(1, 31);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
        throws Notify
    {
        return throwNotify(1, 31, o1);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 31, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 31, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 31, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_DATA_TYPE()
    {
        return trace(1, 32);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1)
    {
        return triggerNotify(1, 32, o1);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
    {
        return triggerNotify(1, 32, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 32, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 32, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_DATA_TYPE()
        throws Notify
    {
        return trace(1, 32);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(1, 32, o1);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 32, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 32, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 32, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_GET()
    {
        return trace(1, 33);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_GET(Object o1)
    {
        return triggerNotify(1, 33, o1);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
    {
        return triggerNotify(1, 33, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 33, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 33, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_GET()
        throws Notify
    {
        return trace(1, 33);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_GET(Object o1)
        throws Notify
    {
        return throwNotify(1, 33, o1);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 33, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 33, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 33, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CREATE()
    {
        return trace(1, 34);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1)
    {
        return triggerNotify(1, 34, o1);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
    {
        return triggerNotify(1, 34, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 34, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 34, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CREATE()
        throws Notify
    {
        return trace(1, 34);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1)
        throws Notify
    {
        return throwNotify(1, 34, o1);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 34, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 34, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 34, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CTL()
    {
        return trace(1, 35);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1)
    {
        return triggerNotify(1, 35, o1);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
    {
        return triggerNotify(1, 35, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 35, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 35, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CTL()
        throws Notify
    {
        return trace(1, 35);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1)
        throws Notify
    {
        return throwNotify(1, 35, o1);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 35, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 35, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 35, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_OP()
    {
        return trace(1, 36);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_OP(Object o1)
    {
        return triggerNotify(1, 36, o1);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
    {
        return triggerNotify(1, 36, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 36, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 36, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_OP()
        throws Notify
    {
        return trace(1, 36);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_OP(Object o1)
        throws Notify
    {
        return throwNotify(1, 36, o1);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 36, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 36, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 36, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_4S_UNKNOWN_CODE()
    {
        return trace(1, 37);
    }

    public boolean triggerNotify_Info_LM_4S_UNKNOWN_CODE(Object o1)
    {
        return triggerNotify(1, 37, o1);
    }

    public boolean triggerNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return triggerNotify(1, 37, o1, o2);
    }

    public boolean triggerNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 37, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 37, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_4S_UNKNOWN_CODE()
        throws Notify
    {
        return trace(1, 37);
    }

    public boolean throwNotify_Info_LM_4S_UNKNOWN_CODE(Object o1)
        throws Notify
    {
        return throwNotify(1, 37, o1);
    }

    public boolean throwNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 37, o1, o2);
    }

    public boolean throwNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 37, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 37, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_INIT_OBJECT()
    {
        return trace(1, 38);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1)
    {
        return triggerNotify(1, 38, o1);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
    {
        return triggerNotify(1, 38, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 38, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 38, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_INIT_OBJECT()
        throws Notify
    {
        return trace(1, 38);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1)
        throws Notify
    {
        return throwNotify(1, 38, o1);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 38, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 38, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 38, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_OPEN_FILE()
    {
        return trace(1, 39);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1)
    {
        return triggerNotify(1, 39, o1);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
    {
        return triggerNotify(1, 39, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 39, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 39, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_OPEN_FILE()
        throws Notify
    {
        return trace(1, 39);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1)
        throws Notify
    {
        return throwNotify(1, 39, o1);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 39, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 39, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 39, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_SYSTEM_CALL()
    {
        return trace(1, 40);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1)
    {
        return triggerNotify(1, 40, o1);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
    {
        return triggerNotify(1, 40, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 40, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 40, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_SYSTEM_CALL()
        throws Notify
    {
        return trace(1, 40);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1)
        throws Notify
    {
        return throwNotify(1, 40, o1);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 40, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 40, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 40, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_DATA_OUTPUT()
    {
        return trace(1, 41);
    }

    public boolean triggerNotify_Info_LM_2S_DATA_OUTPUT(Object o1)
    {
        return triggerNotify(1, 41, o1);
    }

    public boolean triggerNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return triggerNotify(1, 41, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 41, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 41, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_DATA_OUTPUT()
        throws Notify
    {
        return trace(1, 41);
    }

    public boolean throwNotify_Info_LM_2S_DATA_OUTPUT(Object o1)
        throws Notify
    {
        return throwNotify(1, 41, o1);
    }

    public boolean throwNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 41, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 41, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 41, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(1, 42);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return triggerNotify(1, 42, o1);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return triggerNotify(1, 42, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 42, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 42, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
        throws Notify
    {
        return trace(1, 42);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(1, 42, o1);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 42, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 42, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 42, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_ARM_FAILURE()
    {
        return trace(1, 43);
    }

    public boolean triggerNotify_Info_LM_2S_ARM_FAILURE(Object o1)
    {
        return triggerNotify(1, 43, o1);
    }

    public boolean triggerNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(1, 43, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 43, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 43, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_ARM_FAILURE()
        throws Notify
    {
        return trace(1, 43);
    }

    public boolean throwNotify_Info_LM_2S_ARM_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(1, 43, o1);
    }

    public boolean throwNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 43, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 43, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 43, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL()
    {
        return trace(1, 44);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
    {
        return triggerNotify(1, 44, o1);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
    {
        return triggerNotify(1, 44, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 44, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 44, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL()
        throws Notify
    {
        return trace(1, 44);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(1, 44, o1);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 44, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 44, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 44, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_WARN()
    {
        return trace(1, 45);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
    {
        return triggerNotify(1, 45, o1);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
    {
        return triggerNotify(1, 45, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 45, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 45, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_WARN()
        throws Notify
    {
        return trace(1, 45);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
        throws Notify
    {
        return throwNotify(1, 45, o1);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 45, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 45, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 45, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_3S_MQ_FAILURE()
    {
        return trace(1, 46);
    }

    public boolean triggerNotify_Info_LM_3S_MQ_FAILURE(Object o1)
    {
        return triggerNotify(1, 46, o1);
    }

    public boolean triggerNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(1, 46, o1, o2);
    }

    public boolean triggerNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 46, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 46, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_3S_MQ_FAILURE()
        throws Notify
    {
        return trace(1, 46);
    }

    public boolean throwNotify_Info_LM_3S_MQ_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(1, 46, o1);
    }

    public boolean throwNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 46, o1, o2);
    }

    public boolean throwNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 46, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 46, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_MQ_MESSAGE()
    {
        return trace(1, 47);
    }

    public boolean triggerNotify_Info_LM_1S_MQ_MESSAGE(Object o1)
    {
        return triggerNotify(1, 47, o1);
    }

    public boolean triggerNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(1, 47, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 47, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 47, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_MQ_MESSAGE()
        throws Notify
    {
        return trace(1, 47);
    }

    public boolean throwNotify_Info_LM_1S_MQ_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(1, 47, o1);
    }

    public boolean throwNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 47, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 47, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 47, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_ASN_FAILURE()
    {
        return trace(1, 48);
    }

    public boolean triggerNotify_Info_LM_1S_ASN_FAILURE(Object o1)
    {
        return triggerNotify(1, 48, o1);
    }

    public boolean triggerNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(1, 48, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 48, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 48, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_ASN_FAILURE()
        throws Notify
    {
        return trace(1, 48);
    }

    public boolean throwNotify_Info_LM_1S_ASN_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(1, 48, o1);
    }

    public boolean throwNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 48, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 48, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 48, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_ASN_FAILED()
    {
        return trace(1, 49);
    }

    public boolean triggerNotify_Info_LM_2S_ASN_FAILED(Object o1)
    {
        return triggerNotify(1, 49, o1);
    }

    public boolean triggerNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2)
    {
        return triggerNotify(1, 49, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 49, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 49, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_ASN_FAILED()
        throws Notify
    {
        return trace(1, 49);
    }

    public boolean throwNotify_Info_LM_2S_ASN_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(1, 49, o1);
    }

    public boolean throwNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 49, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 49, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 49, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_OID_TYPE()
    {
        return trace(1, 50);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1)
    {
        return triggerNotify(1, 50, o1);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
    {
        return triggerNotify(1, 50, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 50, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 50, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_OID_TYPE()
        throws Notify
    {
        return trace(1, 50);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(1, 50, o1);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 50, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 50, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 50, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_OIDFACTORY_FAILED()
    {
        return trace(1, 51);
    }

    public boolean triggerNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1)
    {
        return triggerNotify(1, 51, o1);
    }

    public boolean triggerNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
    {
        return triggerNotify(1, 51, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 51, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 51, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_OIDFACTORY_FAILED()
        throws Notify
    {
        return trace(1, 51);
    }

    public boolean throwNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(1, 51, o1);
    }

    public boolean throwNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 51, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 51, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 51, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE()
    {
        return trace(1, 52);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
    {
        return triggerNotify(1, 52, o1);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
    {
        return triggerNotify(1, 52, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 52, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 52, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE()
        throws Notify
    {
        return trace(1, 52);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
        throws Notify
    {
        return throwNotify(1, 52, o1);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 52, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 52, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 52, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_2S_FAILED_MEM_ALLOC()
    {
        return trace(1, 53);
    }

    public boolean triggerNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1)
    {
        return triggerNotify(1, 53, o1);
    }

    public boolean triggerNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
    {
        return triggerNotify(1, 53, o1, o2);
    }

    public boolean triggerNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 53, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 53, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_2S_FAILED_MEM_ALLOC()
        throws Notify
    {
        return trace(1, 53);
    }

    public boolean throwNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1)
        throws Notify
    {
        return throwNotify(1, 53, o1);
    }

    public boolean throwNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 53, o1, o2);
    }

    public boolean throwNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 53, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 53, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_CREATE_OID_ERROR()
    {
        return trace(1, 54);
    }

    public boolean triggerNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1)
    {
        return triggerNotify(1, 54, o1);
    }

    public boolean triggerNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
    {
        return triggerNotify(1, 54, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 54, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 54, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_CREATE_OID_ERROR()
        throws Notify
    {
        return trace(1, 54);
    }

    public boolean throwNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(1, 54, o1);
    }

    public boolean throwNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 54, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 54, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 54, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_1S_INVALID_NTN_AWB_GEN()
    {
        return trace(1, 55);
    }

    public boolean triggerNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
    {
        return triggerNotify(1, 55, o1);
    }

    public boolean triggerNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
    {
        return triggerNotify(1, 55, o1, o2);
    }

    public boolean triggerNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 55, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 55, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_1S_INVALID_NTN_AWB_GEN()
        throws Notify
    {
        return trace(1, 55);
    }

    public boolean throwNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
        throws Notify
    {
        return throwNotify(1, 55, o1);
    }

    public boolean throwNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 55, o1, o2);
    }

    public boolean throwNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 55, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 55, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_4S_WARN_MESSAGE()
    {
        return trace(1, 56);
    }

    public boolean triggerNotify_Info_LM_4S_WARN_MESSAGE(Object o1)
    {
        return triggerNotify(1, 56, o1);
    }

    public boolean triggerNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(1, 56, o1, o2);
    }

    public boolean triggerNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 56, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 56, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_4S_WARN_MESSAGE()
        throws Notify
    {
        return trace(1, 56);
    }

    public boolean throwNotify_Info_LM_4S_WARN_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(1, 56, o1);
    }

    public boolean throwNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 56, o1, o2);
    }

    public boolean throwNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 56, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 56, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Info_LM_5S_USER_LOGOUT()
    {
        return trace(1, 57);
    }

    public boolean triggerNotify_Info_LM_5S_USER_LOGOUT(Object o1)
    {
        return triggerNotify(1, 57, o1);
    }

    public boolean triggerNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2)
    {
        return triggerNotify(1, 57, o1, o2);
    }

    public boolean triggerNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(1, 57, o1, o2, o3);
    }

    public boolean triggerNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(1, 57, o1, o2, o3, o4);
    }

    public boolean throwNotify_Info_LM_5S_USER_LOGOUT()
        throws Notify
    {
        return trace(1, 57);
    }

    public boolean throwNotify_Info_LM_5S_USER_LOGOUT(Object o1)
        throws Notify
    {
        return throwNotify(1, 57, o1);
    }

    public boolean throwNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(1, 57, o1, o2);
    }

    public boolean throwNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(1, 57, o1, o2, o3);
    }

    public boolean throwNotify_Info_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(1, 57, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning(int ai_code)
    {
        return trace(3, ai_code);
    }

    public boolean triggerNotify_Warning(int ai_code, Object o1)
    {
        return triggerNotify(3, ai_code, o1);
    }

    public boolean triggerNotify_Warning(int ai_code, Object o1, Object o2)
    {
        return triggerNotify(3, ai_code, o1, o2);
    }

    public boolean triggerNotify_Warning(int ai_code, Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, ai_code, o1, o2, o3);
    }

    public boolean triggerNotify_Warning(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, ai_code, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning(int ai_code)
        throws Notify
    {
        return trace(3, ai_code);
    }

    public boolean throwNotify_Warning(int ai_code, Object o1)
        throws Notify
    {
        return throwNotify(3, ai_code, o1);
    }

    public boolean throwNotify_Warning(int ai_code, Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, ai_code, o1, o2);
    }

    public boolean throwNotify_Warning(int ai_code, Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, ai_code, o1, o2, o3);
    }

    public boolean throwNotify_Warning(int ai_code, Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, ai_code, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_LOAD_ERROR()
    {
        return trace(3, 0);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1)
    {
        return triggerNotify(3, 0, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 0, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 0, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 0, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_LOAD_ERROR()
        throws Notify
    {
        return trace(3, 0);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 0, o1);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 0, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 0, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 0, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_VERSION_ERROR()
    {
        return trace(3, 1);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1)
    {
        return triggerNotify(3, 1, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 1, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 1, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 1, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_VERSION_ERROR()
        throws Notify
    {
        return trace(3, 1);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 1, o1);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 1, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 1, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 1, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_0S_EDIT_READ_ERROR()
    {
        return trace(3, 2);
    }

    public boolean triggerNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1)
    {
        return triggerNotify(3, 2, o1);
    }

    public boolean triggerNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 2, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 2, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 2, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_0S_EDIT_READ_ERROR()
        throws Notify
    {
        return trace(3, 2);
    }

    public boolean throwNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 2, o1);
    }

    public boolean throwNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 2, o1, o2);
    }

    public boolean throwNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 2, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 2, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY()
    {
        return trace(3, 3);
    }

    public boolean triggerNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
    {
        return triggerNotify(3, 3, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
    {
        return triggerNotify(3, 3, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 3, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 3, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY()
        throws Notify
    {
        return trace(3, 3);
    }

    public boolean throwNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
        throws Notify
    {
        return throwNotify(3, 3, o1);
    }

    public boolean throwNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 3, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 3, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 3, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_CORRUPTION_ERROR()
    {
        return trace(3, 4);
    }

    public boolean triggerNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1)
    {
        return triggerNotify(3, 4, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 4, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 4, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 4, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_CORRUPTION_ERROR()
        throws Notify
    {
        return trace(3, 4);
    }

    public boolean throwNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 4, o1);
    }

    public boolean throwNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 4, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 4, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 4, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_CONSECUTIVE_ERRORS()
    {
        return trace(3, 5);
    }

    public boolean triggerNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1)
    {
        return triggerNotify(3, 5, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
    {
        return triggerNotify(3, 5, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 5, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 5, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_CONSECUTIVE_ERRORS()
        throws Notify
    {
        return trace(3, 5);
    }

    public boolean throwNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1)
        throws Notify
    {
        return throwNotify(3, 5, o1);
    }

    public boolean throwNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 5, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 5, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 5, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_ERROR()
    {
        return trace(3, 6);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1)
    {
        return triggerNotify(3, 6, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 6, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 6, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 6, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_ERROR()
        throws Notify
    {
        return trace(3, 6);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 6, o1);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 6, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 6, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 6, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_INFO()
    {
        return trace(3, 7);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1)
    {
        return triggerNotify(3, 7, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
    {
        return triggerNotify(3, 7, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 7, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 7, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_INFO()
        throws Notify
    {
        return trace(3, 7);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1)
        throws Notify
    {
        return throwNotify(3, 7, o1);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 7, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 7, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 7, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_WARN()
    {
        return trace(3, 8);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1)
    {
        return triggerNotify(3, 8, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
    {
        return triggerNotify(3, 8, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 8, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 8, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_WARN()
        throws Notify
    {
        return trace(3, 8);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1)
        throws Notify
    {
        return throwNotify(3, 8, o1);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 8, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 8, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 8, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_ERROR()
    {
        return trace(3, 9);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1)
    {
        return triggerNotify(3, 9, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 9, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 9, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 9, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_ERROR()
        throws Notify
    {
        return trace(3, 9);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 9, o1);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 9, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 9, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 9, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_FATAL()
    {
        return trace(3, 10);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1)
    {
        return triggerNotify(3, 10, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
    {
        return triggerNotify(3, 10, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 10, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 10, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_FATAL()
        throws Notify
    {
        return trace(3, 10);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(3, 10, o1);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 10, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 10, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 10, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_0S_NO_MIDDLEWARE()
    {
        return trace(3, 11);
    }

    public boolean triggerNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1)
    {
        return triggerNotify(3, 11, o1);
    }

    public boolean triggerNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
    {
        return triggerNotify(3, 11, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 11, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 11, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_0S_NO_MIDDLEWARE()
        throws Notify
    {
        return trace(3, 11);
    }

    public boolean throwNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1)
        throws Notify
    {
        return throwNotify(3, 11, o1);
    }

    public boolean throwNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 11, o1, o2);
    }

    public boolean throwNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 11, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 11, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_FAILED()
    {
        return trace(3, 12);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1)
    {
        return triggerNotify(3, 12, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
    {
        return triggerNotify(3, 12, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 12, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 12, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_FAILED()
        throws Notify
    {
        return trace(3, 12);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(3, 12, o1);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 12, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 12, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 12, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_CALL_FAILED()
    {
        return trace(3, 13);
    }

    public boolean triggerNotify_Warning_LM_1S_CALL_FAILED(Object o1)
    {
        return triggerNotify(3, 13, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(3, 13, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 13, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 13, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_CALL_FAILED()
        throws Notify
    {
        return trace(3, 13);
    }

    public boolean throwNotify_Warning_LM_1S_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(3, 13, o1);
    }

    public boolean throwNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 13, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 13, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 13, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_QUEUE_ERROR()
    {
        return trace(3, 14);
    }

    public boolean triggerNotify_Warning_LM_1S_QUEUE_ERROR(Object o1)
    {
        return triggerNotify(3, 14, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 14, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 14, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 14, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_QUEUE_ERROR()
        throws Notify
    {
        return trace(3, 14);
    }

    public boolean throwNotify_Warning_LM_1S_QUEUE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 14, o1);
    }

    public boolean throwNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 14, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 14, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 14, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_REQUIRED()
    {
        return trace(3, 15);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1)
    {
        return triggerNotify(3, 15, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
    {
        return triggerNotify(3, 15, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 15, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 15, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_REQUIRED()
        throws Notify
    {
        return trace(3, 15);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1)
        throws Notify
    {
        return throwNotify(3, 15, o1);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 15, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 15, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 15, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_TPOPEN_FAIL()
    {
        return trace(3, 16);
    }

    public boolean triggerNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1)
    {
        return triggerNotify(3, 16, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
    {
        return triggerNotify(3, 16, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 16, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 16, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_TPOPEN_FAIL()
        throws Notify
    {
        return trace(3, 16);
    }

    public boolean throwNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(3, 16, o1);
    }

    public boolean throwNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 16, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 16, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 16, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_TPCLOSE_FAIL()
    {
        return trace(3, 17);
    }

    public boolean triggerNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1)
    {
        return triggerNotify(3, 17, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
    {
        return triggerNotify(3, 17, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 17, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 17, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_TPCLOSE_FAIL()
        throws Notify
    {
        return trace(3, 17);
    }

    public boolean throwNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(3, 17, o1);
    }

    public boolean throwNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 17, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 17, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 17, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_TRANSACTION_ERROR()
    {
        return trace(3, 18);
    }

    public boolean triggerNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1)
    {
        return triggerNotify(3, 18, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 18, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 18, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 18, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_TRANSACTION_ERROR()
        throws Notify
    {
        return trace(3, 18);
    }

    public boolean throwNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 18, o1);
    }

    public boolean throwNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 18, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 18, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 18, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_CONNECT_DB_FAIL()
    {
        return trace(3, 19);
    }

    public boolean triggerNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1)
    {
        return triggerNotify(3, 19, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
    {
        return triggerNotify(3, 19, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 19, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 19, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_CONNECT_DB_FAIL()
        throws Notify
    {
        return trace(3, 19);
    }

    public boolean throwNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(3, 19, o1);
    }

    public boolean throwNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 19, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 19, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 19, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_DB_ERROR()
    {
        return trace(3, 20);
    }

    public boolean triggerNotify_Warning_LM_3S_DB_ERROR(Object o1)
    {
        return triggerNotify(3, 20, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 20, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 20, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 20, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_DB_ERROR()
        throws Notify
    {
        return trace(3, 20);
    }

    public boolean throwNotify_Warning_LM_3S_DB_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 20, o1);
    }

    public boolean throwNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 20, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 20, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 20, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR()
    {
        return trace(3, 21);
    }

    public boolean triggerNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
    {
        return triggerNotify(3, 21, o1);
    }

    public boolean triggerNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 21, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 21, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 21, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR()
        throws Notify
    {
        return trace(3, 21);
    }

    public boolean throwNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 21, o1);
    }

    public boolean throwNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 21, o1, o2);
    }

    public boolean throwNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 21, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 21, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_NOENTRY()
    {
        return trace(3, 22);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_NOENTRY(Object o1)
    {
        return triggerNotify(3, 22, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2)
    {
        return triggerNotify(3, 22, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 22, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 22, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_DB_NOENTRY()
        throws Notify
    {
        return trace(3, 22);
    }

    public boolean throwNotify_Warning_LM_2S_DB_NOENTRY(Object o1)
        throws Notify
    {
        return throwNotify(3, 22, o1);
    }

    public boolean throwNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 22, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 22, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 22, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY()
    {
        return trace(3, 23);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
    {
        return triggerNotify(3, 23, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
    {
        return triggerNotify(3, 23, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 23, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 23, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY()
        throws Notify
    {
        return trace(3, 23);
    }

    public boolean throwNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
        throws Notify
    {
        return throwNotify(3, 23, o1);
    }

    public boolean throwNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 23, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 23, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 23, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_DB_INVALID_RESULTS()
    {
        return trace(3, 24);
    }

    public boolean triggerNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1)
    {
        return triggerNotify(3, 24, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
    {
        return triggerNotify(3, 24, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 24, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 24, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_DB_INVALID_RESULTS()
        throws Notify
    {
        return trace(3, 24);
    }

    public boolean throwNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1)
        throws Notify
    {
        return throwNotify(3, 24, o1);
    }

    public boolean throwNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 24, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 24, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 24, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION()
    {
        return trace(3, 25);
    }

    public boolean triggerNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(3, 25, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(3, 25, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 25, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 25, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION()
        throws Notify
    {
        return trace(3, 25);
    }

    public boolean throwNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(3, 25, o1);
    }

    public boolean throwNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 25, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 25, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 25, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_4S_FX_EXCEPTION()
    {
        return trace(3, 26);
    }

    public boolean triggerNotify_Warning_LM_4S_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(3, 26, o1);
    }

    public boolean triggerNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(3, 26, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 26, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 26, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_4S_FX_EXCEPTION()
        throws Notify
    {
        return trace(3, 26);
    }

    public boolean throwNotify_Warning_LM_4S_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(3, 26, o1);
    }

    public boolean throwNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 26, o1, o2);
    }

    public boolean throwNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 26, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 26, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_SVCBASE_CALL_FAILED()
    {
        return trace(3, 27);
    }

    public boolean triggerNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1)
    {
        return triggerNotify(3, 27, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(3, 27, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 27, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 27, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_SVCBASE_CALL_FAILED()
        throws Notify
    {
        return trace(3, 27);
    }

    public boolean throwNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(3, 27, o1);
    }

    public boolean throwNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 27, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 27, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 27, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_0S_INVALID_DATAMANAGER()
    {
        return trace(3, 28);
    }

    public boolean triggerNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1)
    {
        return triggerNotify(3, 28, o1);
    }

    public boolean triggerNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
    {
        return triggerNotify(3, 28, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 28, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 28, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_0S_INVALID_DATAMANAGER()
        throws Notify
    {
        return trace(3, 28);
    }

    public boolean throwNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1)
        throws Notify
    {
        return throwNotify(3, 28, o1);
    }

    public boolean throwNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 28, o1, o2);
    }

    public boolean throwNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 28, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 28, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_STANDARD_EXCEPTION()
    {
        return trace(3, 29);
    }

    public boolean triggerNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1)
    {
        return triggerNotify(3, 29, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(3, 29, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 29, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 29, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_STANDARD_EXCEPTION()
        throws Notify
    {
        return trace(3, 29);
    }

    public boolean throwNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(3, 29, o1);
    }

    public boolean throwNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 29, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 29, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 29, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION()
    {
        return trace(3, 30);
    }

    public boolean triggerNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
    {
        return triggerNotify(3, 30, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(3, 30, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 30, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 30, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION()
        throws Notify
    {
        return trace(3, 30);
    }

    public boolean throwNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(3, 30, o1);
    }

    public boolean throwNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 30, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 30, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG()
    {
        return trace(3, 31);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
    {
        return triggerNotify(3, 31, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
    {
        return triggerNotify(3, 31, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 31, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 31, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG()
        throws Notify
    {
        return trace(3, 31);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
        throws Notify
    {
        return throwNotify(3, 31, o1);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 31, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 31, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 31, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_DATA_TYPE()
    {
        return trace(3, 32);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1)
    {
        return triggerNotify(3, 32, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
    {
        return triggerNotify(3, 32, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 32, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 32, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_DATA_TYPE()
        throws Notify
    {
        return trace(3, 32);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(3, 32, o1);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 32, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 32, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 32, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_GET()
    {
        return trace(3, 33);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1)
    {
        return triggerNotify(3, 33, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
    {
        return triggerNotify(3, 33, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 33, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 33, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_GET()
        throws Notify
    {
        return trace(3, 33);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1)
        throws Notify
    {
        return throwNotify(3, 33, o1);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 33, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 33, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 33, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CREATE()
    {
        return trace(3, 34);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1)
    {
        return triggerNotify(3, 34, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
    {
        return triggerNotify(3, 34, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 34, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 34, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CREATE()
        throws Notify
    {
        return trace(3, 34);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1)
        throws Notify
    {
        return throwNotify(3, 34, o1);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 34, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 34, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 34, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CTL()
    {
        return trace(3, 35);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1)
    {
        return triggerNotify(3, 35, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
    {
        return triggerNotify(3, 35, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 35, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 35, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CTL()
        throws Notify
    {
        return trace(3, 35);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1)
        throws Notify
    {
        return throwNotify(3, 35, o1);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 35, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 35, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 35, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_OP()
    {
        return trace(3, 36);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1)
    {
        return triggerNotify(3, 36, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
    {
        return triggerNotify(3, 36, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 36, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 36, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_OP()
        throws Notify
    {
        return trace(3, 36);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1)
        throws Notify
    {
        return throwNotify(3, 36, o1);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 36, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 36, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 36, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_4S_UNKNOWN_CODE()
    {
        return trace(3, 37);
    }

    public boolean triggerNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1)
    {
        return triggerNotify(3, 37, o1);
    }

    public boolean triggerNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return triggerNotify(3, 37, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 37, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 37, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_4S_UNKNOWN_CODE()
        throws Notify
    {
        return trace(3, 37);
    }

    public boolean throwNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1)
        throws Notify
    {
        return throwNotify(3, 37, o1);
    }

    public boolean throwNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 37, o1, o2);
    }

    public boolean throwNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 37, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 37, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_INIT_OBJECT()
    {
        return trace(3, 38);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1)
    {
        return triggerNotify(3, 38, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
    {
        return triggerNotify(3, 38, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 38, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 38, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_INIT_OBJECT()
        throws Notify
    {
        return trace(3, 38);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1)
        throws Notify
    {
        return throwNotify(3, 38, o1);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 38, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 38, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 38, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_OPEN_FILE()
    {
        return trace(3, 39);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1)
    {
        return triggerNotify(3, 39, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
    {
        return triggerNotify(3, 39, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 39, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 39, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_OPEN_FILE()
        throws Notify
    {
        return trace(3, 39);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1)
        throws Notify
    {
        return throwNotify(3, 39, o1);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 39, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 39, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 39, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_SYSTEM_CALL()
    {
        return trace(3, 40);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1)
    {
        return triggerNotify(3, 40, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
    {
        return triggerNotify(3, 40, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 40, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 40, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_SYSTEM_CALL()
        throws Notify
    {
        return trace(3, 40);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1)
        throws Notify
    {
        return throwNotify(3, 40, o1);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 40, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 40, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 40, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_DATA_OUTPUT()
    {
        return trace(3, 41);
    }

    public boolean triggerNotify_Warning_LM_2S_DATA_OUTPUT(Object o1)
    {
        return triggerNotify(3, 41, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return triggerNotify(3, 41, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 41, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 41, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_DATA_OUTPUT()
        throws Notify
    {
        return trace(3, 41);
    }

    public boolean throwNotify_Warning_LM_2S_DATA_OUTPUT(Object o1)
        throws Notify
    {
        return throwNotify(3, 41, o1);
    }

    public boolean throwNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 41, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 41, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 41, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(3, 42);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return triggerNotify(3, 42, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return triggerNotify(3, 42, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 42, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 42, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
        throws Notify
    {
        return trace(3, 42);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(3, 42, o1);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 42, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 42, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 42, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_ARM_FAILURE()
    {
        return trace(3, 43);
    }

    public boolean triggerNotify_Warning_LM_2S_ARM_FAILURE(Object o1)
    {
        return triggerNotify(3, 43, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(3, 43, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 43, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 43, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_ARM_FAILURE()
        throws Notify
    {
        return trace(3, 43);
    }

    public boolean throwNotify_Warning_LM_2S_ARM_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(3, 43, o1);
    }

    public boolean throwNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 43, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 43, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 43, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL()
    {
        return trace(3, 44);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
    {
        return triggerNotify(3, 44, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
    {
        return triggerNotify(3, 44, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 44, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 44, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL()
        throws Notify
    {
        return trace(3, 44);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(3, 44, o1);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 44, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 44, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 44, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN()
    {
        return trace(3, 45);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
    {
        return triggerNotify(3, 45, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
    {
        return triggerNotify(3, 45, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 45, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 45, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN()
        throws Notify
    {
        return trace(3, 45);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
        throws Notify
    {
        return throwNotify(3, 45, o1);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 45, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 45, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 45, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_3S_MQ_FAILURE()
    {
        return trace(3, 46);
    }

    public boolean triggerNotify_Warning_LM_3S_MQ_FAILURE(Object o1)
    {
        return triggerNotify(3, 46, o1);
    }

    public boolean triggerNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(3, 46, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 46, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 46, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_3S_MQ_FAILURE()
        throws Notify
    {
        return trace(3, 46);
    }

    public boolean throwNotify_Warning_LM_3S_MQ_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(3, 46, o1);
    }

    public boolean throwNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 46, o1, o2);
    }

    public boolean throwNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 46, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 46, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_MQ_MESSAGE()
    {
        return trace(3, 47);
    }

    public boolean triggerNotify_Warning_LM_1S_MQ_MESSAGE(Object o1)
    {
        return triggerNotify(3, 47, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(3, 47, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 47, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 47, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_MQ_MESSAGE()
        throws Notify
    {
        return trace(3, 47);
    }

    public boolean throwNotify_Warning_LM_1S_MQ_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(3, 47, o1);
    }

    public boolean throwNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 47, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 47, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 47, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_ASN_FAILURE()
    {
        return trace(3, 48);
    }

    public boolean triggerNotify_Warning_LM_1S_ASN_FAILURE(Object o1)
    {
        return triggerNotify(3, 48, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(3, 48, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 48, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 48, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_ASN_FAILURE()
        throws Notify
    {
        return trace(3, 48);
    }

    public boolean throwNotify_Warning_LM_1S_ASN_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(3, 48, o1);
    }

    public boolean throwNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 48, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 48, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 48, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_ASN_FAILED()
    {
        return trace(3, 49);
    }

    public boolean triggerNotify_Warning_LM_2S_ASN_FAILED(Object o1)
    {
        return triggerNotify(3, 49, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2)
    {
        return triggerNotify(3, 49, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 49, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 49, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_ASN_FAILED()
        throws Notify
    {
        return trace(3, 49);
    }

    public boolean throwNotify_Warning_LM_2S_ASN_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(3, 49, o1);
    }

    public boolean throwNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 49, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 49, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 49, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_OID_TYPE()
    {
        return trace(3, 50);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1)
    {
        return triggerNotify(3, 50, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
    {
        return triggerNotify(3, 50, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 50, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 50, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_OID_TYPE()
        throws Notify
    {
        return trace(3, 50);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(3, 50, o1);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 50, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 50, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 50, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_OIDFACTORY_FAILED()
    {
        return trace(3, 51);
    }

    public boolean triggerNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1)
    {
        return triggerNotify(3, 51, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
    {
        return triggerNotify(3, 51, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 51, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 51, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_OIDFACTORY_FAILED()
        throws Notify
    {
        return trace(3, 51);
    }

    public boolean throwNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(3, 51, o1);
    }

    public boolean throwNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 51, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 51, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 51, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE()
    {
        return trace(3, 52);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
    {
        return triggerNotify(3, 52, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
    {
        return triggerNotify(3, 52, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 52, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 52, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE()
        throws Notify
    {
        return trace(3, 52);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
        throws Notify
    {
        return throwNotify(3, 52, o1);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 52, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 52, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 52, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_2S_FAILED_MEM_ALLOC()
    {
        return trace(3, 53);
    }

    public boolean triggerNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1)
    {
        return triggerNotify(3, 53, o1);
    }

    public boolean triggerNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
    {
        return triggerNotify(3, 53, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 53, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 53, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_2S_FAILED_MEM_ALLOC()
        throws Notify
    {
        return trace(3, 53);
    }

    public boolean throwNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1)
        throws Notify
    {
        return throwNotify(3, 53, o1);
    }

    public boolean throwNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 53, o1, o2);
    }

    public boolean throwNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 53, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 53, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_CREATE_OID_ERROR()
    {
        return trace(3, 54);
    }

    public boolean triggerNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1)
    {
        return triggerNotify(3, 54, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
    {
        return triggerNotify(3, 54, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 54, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 54, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_CREATE_OID_ERROR()
        throws Notify
    {
        return trace(3, 54);
    }

    public boolean throwNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(3, 54, o1);
    }

    public boolean throwNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 54, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 54, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 54, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN()
    {
        return trace(3, 55);
    }

    public boolean triggerNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
    {
        return triggerNotify(3, 55, o1);
    }

    public boolean triggerNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
    {
        return triggerNotify(3, 55, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 55, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 55, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN()
        throws Notify
    {
        return trace(3, 55);
    }

    public boolean throwNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
        throws Notify
    {
        return throwNotify(3, 55, o1);
    }

    public boolean throwNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 55, o1, o2);
    }

    public boolean throwNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 55, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 55, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_4S_WARN_MESSAGE()
    {
        return trace(3, 56);
    }

    public boolean triggerNotify_Warning_LM_4S_WARN_MESSAGE(Object o1)
    {
        return triggerNotify(3, 56, o1);
    }

    public boolean triggerNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(3, 56, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 56, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 56, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_4S_WARN_MESSAGE()
        throws Notify
    {
        return trace(3, 56);
    }

    public boolean throwNotify_Warning_LM_4S_WARN_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(3, 56, o1);
    }

    public boolean throwNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 56, o1, o2);
    }

    public boolean throwNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 56, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 56, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Warning_LM_5S_USER_LOGOUT()
    {
        return trace(3, 57);
    }

    public boolean triggerNotify_Warning_LM_5S_USER_LOGOUT(Object o1)
    {
        return triggerNotify(3, 57, o1);
    }

    public boolean triggerNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2)
    {
        return triggerNotify(3, 57, o1, o2);
    }

    public boolean triggerNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(3, 57, o1, o2, o3);
    }

    public boolean triggerNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(3, 57, o1, o2, o3, o4);
    }

    public boolean throwNotify_Warning_LM_5S_USER_LOGOUT()
        throws Notify
    {
        return trace(3, 57);
    }

    public boolean throwNotify_Warning_LM_5S_USER_LOGOUT(Object o1)
        throws Notify
    {
        return throwNotify(3, 57, o1);
    }

    public boolean throwNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(3, 57, o1, o2);
    }

    public boolean throwNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(3, 57, o1, o2, o3);
    }

    public boolean throwNotify_Warning_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(3, 57, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error(int ai_code)
    {
        return trace(4, ai_code);
    }

    public boolean triggerNotify_Error(int ai_code, Object o1)
    {
        return triggerNotify(4, ai_code, o1);
    }

    public boolean triggerNotify_Error(int ai_code, Object o1, Object o2)
    {
        return triggerNotify(4, ai_code, o1, o2);
    }

    public boolean triggerNotify_Error(int ai_code, Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, ai_code, o1, o2, o3);
    }

    public boolean triggerNotify_Error(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, ai_code, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error(int ai_code)
        throws Notify
    {
        return trace(4, ai_code);
    }

    public boolean throwNotify_Error(int ai_code, Object o1)
        throws Notify
    {
        return throwNotify(4, ai_code, o1);
    }

    public boolean throwNotify_Error(int ai_code, Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, ai_code, o1, o2);
    }

    public boolean throwNotify_Error(int ai_code, Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, ai_code, o1, o2, o3);
    }

    public boolean throwNotify_Error(int ai_code, Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, ai_code, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_LOAD_ERROR()
    {
        return trace(4, 0);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1)
    {
        return triggerNotify(4, 0, o1);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 0, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 0, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 0, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_LOAD_ERROR()
        throws Notify
    {
        return trace(4, 0);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 0, o1);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 0, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 0, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 0, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_VERSION_ERROR()
    {
        return trace(4, 1);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1)
    {
        return triggerNotify(4, 1, o1);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 1, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 1, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 1, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_VERSION_ERROR()
        throws Notify
    {
        return trace(4, 1);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 1, o1);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 1, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 1, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 1, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_0S_EDIT_READ_ERROR()
    {
        return trace(4, 2);
    }

    public boolean triggerNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1)
    {
        return triggerNotify(4, 2, o1);
    }

    public boolean triggerNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 2, o1, o2);
    }

    public boolean triggerNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 2, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 2, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_0S_EDIT_READ_ERROR()
        throws Notify
    {
        return trace(4, 2);
    }

    public boolean throwNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 2, o1);
    }

    public boolean throwNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 2, o1, o2);
    }

    public boolean throwNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 2, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 2, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_INTERNAL_INCONSISTANCY()
    {
        return trace(4, 3);
    }

    public boolean triggerNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
    {
        return triggerNotify(4, 3, o1);
    }

    public boolean triggerNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
    {
        return triggerNotify(4, 3, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 3, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 3, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_INTERNAL_INCONSISTANCY()
        throws Notify
    {
        return trace(4, 3);
    }

    public boolean throwNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
        throws Notify
    {
        return throwNotify(4, 3, o1);
    }

    public boolean throwNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 3, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 3, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 3, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_CORRUPTION_ERROR()
    {
        return trace(4, 4);
    }

    public boolean triggerNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1)
    {
        return triggerNotify(4, 4, o1);
    }

    public boolean triggerNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 4, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 4, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 4, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_CORRUPTION_ERROR()
        throws Notify
    {
        return trace(4, 4);
    }

    public boolean throwNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 4, o1);
    }

    public boolean throwNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 4, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 4, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 4, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_CONSECUTIVE_ERRORS()
    {
        return trace(4, 5);
    }

    public boolean triggerNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1)
    {
        return triggerNotify(4, 5, o1);
    }

    public boolean triggerNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
    {
        return triggerNotify(4, 5, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 5, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 5, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_CONSECUTIVE_ERRORS()
        throws Notify
    {
        return trace(4, 5);
    }

    public boolean throwNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1)
        throws Notify
    {
        return throwNotify(4, 5, o1);
    }

    public boolean throwNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 5, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 5, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 5, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_ERROR()
    {
        return trace(4, 6);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1)
    {
        return triggerNotify(4, 6, o1);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 6, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 6, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 6, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_ERROR()
        throws Notify
    {
        return trace(4, 6);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 6, o1);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 6, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 6, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 6, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_INFO()
    {
        return trace(4, 7);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1)
    {
        return triggerNotify(4, 7, o1);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
    {
        return triggerNotify(4, 7, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 7, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 7, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_INFO()
        throws Notify
    {
        return trace(4, 7);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1)
        throws Notify
    {
        return throwNotify(4, 7, o1);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 7, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 7, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 7, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_WARN()
    {
        return trace(4, 8);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1)
    {
        return triggerNotify(4, 8, o1);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
    {
        return triggerNotify(4, 8, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 8, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 8, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_WARN()
        throws Notify
    {
        return trace(4, 8);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1)
        throws Notify
    {
        return throwNotify(4, 8, o1);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 8, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 8, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 8, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_ERROR()
    {
        return trace(4, 9);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1)
    {
        return triggerNotify(4, 9, o1);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 9, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 9, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 9, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_ERROR()
        throws Notify
    {
        return trace(4, 9);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 9, o1);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 9, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 9, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 9, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_FATAL()
    {
        return trace(4, 10);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1)
    {
        return triggerNotify(4, 10, o1);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
    {
        return triggerNotify(4, 10, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 10, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 10, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_FATAL()
        throws Notify
    {
        return trace(4, 10);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(4, 10, o1);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 10, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 10, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 10, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_0S_NO_MIDDLEWARE()
    {
        return trace(4, 11);
    }

    public boolean triggerNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1)
    {
        return triggerNotify(4, 11, o1);
    }

    public boolean triggerNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
    {
        return triggerNotify(4, 11, o1, o2);
    }

    public boolean triggerNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 11, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 11, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_0S_NO_MIDDLEWARE()
        throws Notify
    {
        return trace(4, 11);
    }

    public boolean throwNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1)
        throws Notify
    {
        return throwNotify(4, 11, o1);
    }

    public boolean throwNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 11, o1, o2);
    }

    public boolean throwNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 11, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 11, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_FAILED()
    {
        return trace(4, 12);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1)
    {
        return triggerNotify(4, 12, o1);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
    {
        return triggerNotify(4, 12, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 12, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 12, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_FAILED()
        throws Notify
    {
        return trace(4, 12);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(4, 12, o1);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 12, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 12, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 12, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_CALL_FAILED()
    {
        return trace(4, 13);
    }

    public boolean triggerNotify_Error_LM_1S_CALL_FAILED(Object o1)
    {
        return triggerNotify(4, 13, o1);
    }

    public boolean triggerNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(4, 13, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 13, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 13, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_CALL_FAILED()
        throws Notify
    {
        return trace(4, 13);
    }

    public boolean throwNotify_Error_LM_1S_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(4, 13, o1);
    }

    public boolean throwNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 13, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 13, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 13, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_QUEUE_ERROR()
    {
        return trace(4, 14);
    }

    public boolean triggerNotify_Error_LM_1S_QUEUE_ERROR(Object o1)
    {
        return triggerNotify(4, 14, o1);
    }

    public boolean triggerNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 14, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 14, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 14, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_QUEUE_ERROR()
        throws Notify
    {
        return trace(4, 14);
    }

    public boolean throwNotify_Error_LM_1S_QUEUE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 14, o1);
    }

    public boolean throwNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 14, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 14, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 14, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_REQUIRED()
    {
        return trace(4, 15);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1)
    {
        return triggerNotify(4, 15, o1);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
    {
        return triggerNotify(4, 15, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 15, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 15, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_REQUIRED()
        throws Notify
    {
        return trace(4, 15);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1)
        throws Notify
    {
        return throwNotify(4, 15, o1);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 15, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 15, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 15, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_TPOPEN_FAIL()
    {
        return trace(4, 16);
    }

    public boolean triggerNotify_Error_LM_2S_TPOPEN_FAIL(Object o1)
    {
        return triggerNotify(4, 16, o1);
    }

    public boolean triggerNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
    {
        return triggerNotify(4, 16, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 16, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 16, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_TPOPEN_FAIL()
        throws Notify
    {
        return trace(4, 16);
    }

    public boolean throwNotify_Error_LM_2S_TPOPEN_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(4, 16, o1);
    }

    public boolean throwNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 16, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 16, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 16, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_TPCLOSE_FAIL()
    {
        return trace(4, 17);
    }

    public boolean triggerNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1)
    {
        return triggerNotify(4, 17, o1);
    }

    public boolean triggerNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
    {
        return triggerNotify(4, 17, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 17, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 17, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_TPCLOSE_FAIL()
        throws Notify
    {
        return trace(4, 17);
    }

    public boolean throwNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(4, 17, o1);
    }

    public boolean throwNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 17, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 17, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 17, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_TRANSACTION_ERROR()
    {
        return trace(4, 18);
    }

    public boolean triggerNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1)
    {
        return triggerNotify(4, 18, o1);
    }

    public boolean triggerNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 18, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 18, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 18, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_TRANSACTION_ERROR()
        throws Notify
    {
        return trace(4, 18);
    }

    public boolean throwNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 18, o1);
    }

    public boolean throwNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 18, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 18, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 18, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_CONNECT_DB_FAIL()
    {
        return trace(4, 19);
    }

    public boolean triggerNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1)
    {
        return triggerNotify(4, 19, o1);
    }

    public boolean triggerNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
    {
        return triggerNotify(4, 19, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 19, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 19, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_CONNECT_DB_FAIL()
        throws Notify
    {
        return trace(4, 19);
    }

    public boolean throwNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(4, 19, o1);
    }

    public boolean throwNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 19, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 19, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 19, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_DB_ERROR()
    {
        return trace(4, 20);
    }

    public boolean triggerNotify_Error_LM_3S_DB_ERROR(Object o1)
    {
        return triggerNotify(4, 20, o1);
    }

    public boolean triggerNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 20, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 20, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 20, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_DB_ERROR()
        throws Notify
    {
        return trace(4, 20);
    }

    public boolean throwNotify_Error_LM_3S_DB_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 20, o1);
    }

    public boolean throwNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 20, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 20, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 20, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_0S_INTERNAL_TABLE_ERROR()
    {
        return trace(4, 21);
    }

    public boolean triggerNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
    {
        return triggerNotify(4, 21, o1);
    }

    public boolean triggerNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 21, o1, o2);
    }

    public boolean triggerNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 21, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 21, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_0S_INTERNAL_TABLE_ERROR()
        throws Notify
    {
        return trace(4, 21);
    }

    public boolean throwNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 21, o1);
    }

    public boolean throwNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 21, o1, o2);
    }

    public boolean throwNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 21, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 21, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_DB_NOENTRY()
    {
        return trace(4, 22);
    }

    public boolean triggerNotify_Error_LM_2S_DB_NOENTRY(Object o1)
    {
        return triggerNotify(4, 22, o1);
    }

    public boolean triggerNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2)
    {
        return triggerNotify(4, 22, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 22, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 22, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_DB_NOENTRY()
        throws Notify
    {
        return trace(4, 22);
    }

    public boolean throwNotify_Error_LM_2S_DB_NOENTRY(Object o1)
        throws Notify
    {
        return throwNotify(4, 22, o1);
    }

    public boolean throwNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 22, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 22, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 22, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY()
    {
        return trace(4, 23);
    }

    public boolean triggerNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
    {
        return triggerNotify(4, 23, o1);
    }

    public boolean triggerNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
    {
        return triggerNotify(4, 23, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 23, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 23, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY()
        throws Notify
    {
        return trace(4, 23);
    }

    public boolean throwNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
        throws Notify
    {
        return throwNotify(4, 23, o1);
    }

    public boolean throwNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 23, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 23, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 23, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_DB_INVALID_RESULTS()
    {
        return trace(4, 24);
    }

    public boolean triggerNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1)
    {
        return triggerNotify(4, 24, o1);
    }

    public boolean triggerNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
    {
        return triggerNotify(4, 24, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 24, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 24, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_DB_INVALID_RESULTS()
        throws Notify
    {
        return trace(4, 24);
    }

    public boolean throwNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1)
        throws Notify
    {
        return throwNotify(4, 24, o1);
    }

    public boolean throwNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 24, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 24, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 24, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION()
    {
        return trace(4, 25);
    }

    public boolean triggerNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(4, 25, o1);
    }

    public boolean triggerNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(4, 25, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 25, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 25, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION()
        throws Notify
    {
        return trace(4, 25);
    }

    public boolean throwNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(4, 25, o1);
    }

    public boolean throwNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 25, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 25, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 25, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_4S_FX_EXCEPTION()
    {
        return trace(4, 26);
    }

    public boolean triggerNotify_Error_LM_4S_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(4, 26, o1);
    }

    public boolean triggerNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(4, 26, o1, o2);
    }

    public boolean triggerNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 26, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 26, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_4S_FX_EXCEPTION()
        throws Notify
    {
        return trace(4, 26);
    }

    public boolean throwNotify_Error_LM_4S_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(4, 26, o1);
    }

    public boolean throwNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 26, o1, o2);
    }

    public boolean throwNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 26, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 26, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_SVCBASE_CALL_FAILED()
    {
        return trace(4, 27);
    }

    public boolean triggerNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1)
    {
        return triggerNotify(4, 27, o1);
    }

    public boolean triggerNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(4, 27, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 27, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 27, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_SVCBASE_CALL_FAILED()
        throws Notify
    {
        return trace(4, 27);
    }

    public boolean throwNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(4, 27, o1);
    }

    public boolean throwNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 27, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 27, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 27, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_0S_INVALID_DATAMANAGER()
    {
        return trace(4, 28);
    }

    public boolean triggerNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1)
    {
        return triggerNotify(4, 28, o1);
    }

    public boolean triggerNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
    {
        return triggerNotify(4, 28, o1, o2);
    }

    public boolean triggerNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 28, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 28, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_0S_INVALID_DATAMANAGER()
        throws Notify
    {
        return trace(4, 28);
    }

    public boolean throwNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1)
        throws Notify
    {
        return throwNotify(4, 28, o1);
    }

    public boolean throwNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 28, o1, o2);
    }

    public boolean throwNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 28, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 28, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_STANDARD_EXCEPTION()
    {
        return trace(4, 29);
    }

    public boolean triggerNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1)
    {
        return triggerNotify(4, 29, o1);
    }

    public boolean triggerNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(4, 29, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 29, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 29, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_STANDARD_EXCEPTION()
        throws Notify
    {
        return trace(4, 29);
    }

    public boolean throwNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(4, 29, o1);
    }

    public boolean throwNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 29, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 29, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 29, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_UNEXPECTED_EXCEPTION()
    {
        return trace(4, 30);
    }

    public boolean triggerNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
    {
        return triggerNotify(4, 30, o1);
    }

    public boolean triggerNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(4, 30, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 30, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 30, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_UNEXPECTED_EXCEPTION()
        throws Notify
    {
        return trace(4, 30);
    }

    public boolean throwNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(4, 30, o1);
    }

    public boolean throwNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 30, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 30, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG()
    {
        return trace(4, 31);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
    {
        return triggerNotify(4, 31, o1);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
    {
        return triggerNotify(4, 31, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 31, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 31, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG()
        throws Notify
    {
        return trace(4, 31);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
        throws Notify
    {
        return throwNotify(4, 31, o1);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 31, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 31, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 31, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_DATA_TYPE()
    {
        return trace(4, 32);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1)
    {
        return triggerNotify(4, 32, o1);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
    {
        return triggerNotify(4, 32, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 32, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 32, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_DATA_TYPE()
        throws Notify
    {
        return trace(4, 32);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(4, 32, o1);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 32, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 32, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 32, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_GET()
    {
        return trace(4, 33);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_GET(Object o1)
    {
        return triggerNotify(4, 33, o1);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
    {
        return triggerNotify(4, 33, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 33, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 33, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_GET()
        throws Notify
    {
        return trace(4, 33);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_GET(Object o1)
        throws Notify
    {
        return throwNotify(4, 33, o1);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 33, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 33, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 33, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CREATE()
    {
        return trace(4, 34);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1)
    {
        return triggerNotify(4, 34, o1);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
    {
        return triggerNotify(4, 34, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 34, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 34, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CREATE()
        throws Notify
    {
        return trace(4, 34);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1)
        throws Notify
    {
        return throwNotify(4, 34, o1);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 34, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 34, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 34, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CTL()
    {
        return trace(4, 35);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1)
    {
        return triggerNotify(4, 35, o1);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
    {
        return triggerNotify(4, 35, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 35, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 35, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CTL()
        throws Notify
    {
        return trace(4, 35);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1)
        throws Notify
    {
        return throwNotify(4, 35, o1);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 35, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 35, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 35, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_OP()
    {
        return trace(4, 36);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_OP(Object o1)
    {
        return triggerNotify(4, 36, o1);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
    {
        return triggerNotify(4, 36, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 36, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 36, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_OP()
        throws Notify
    {
        return trace(4, 36);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_OP(Object o1)
        throws Notify
    {
        return throwNotify(4, 36, o1);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 36, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 36, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 36, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_4S_UNKNOWN_CODE()
    {
        return trace(4, 37);
    }

    public boolean triggerNotify_Error_LM_4S_UNKNOWN_CODE(Object o1)
    {
        return triggerNotify(4, 37, o1);
    }

    public boolean triggerNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return triggerNotify(4, 37, o1, o2);
    }

    public boolean triggerNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 37, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 37, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_4S_UNKNOWN_CODE()
        throws Notify
    {
        return trace(4, 37);
    }

    public boolean throwNotify_Error_LM_4S_UNKNOWN_CODE(Object o1)
        throws Notify
    {
        return throwNotify(4, 37, o1);
    }

    public boolean throwNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 37, o1, o2);
    }

    public boolean throwNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 37, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 37, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_INIT_OBJECT()
    {
        return trace(4, 38);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1)
    {
        return triggerNotify(4, 38, o1);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
    {
        return triggerNotify(4, 38, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 38, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 38, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_INIT_OBJECT()
        throws Notify
    {
        return trace(4, 38);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1)
        throws Notify
    {
        return throwNotify(4, 38, o1);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 38, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 38, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 38, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_OPEN_FILE()
    {
        return trace(4, 39);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1)
    {
        return triggerNotify(4, 39, o1);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
    {
        return triggerNotify(4, 39, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 39, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 39, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_OPEN_FILE()
        throws Notify
    {
        return trace(4, 39);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1)
        throws Notify
    {
        return throwNotify(4, 39, o1);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 39, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 39, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 39, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_SYSTEM_CALL()
    {
        return trace(4, 40);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1)
    {
        return triggerNotify(4, 40, o1);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
    {
        return triggerNotify(4, 40, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 40, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 40, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_SYSTEM_CALL()
        throws Notify
    {
        return trace(4, 40);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1)
        throws Notify
    {
        return throwNotify(4, 40, o1);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 40, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 40, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 40, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_DATA_OUTPUT()
    {
        return trace(4, 41);
    }

    public boolean triggerNotify_Error_LM_2S_DATA_OUTPUT(Object o1)
    {
        return triggerNotify(4, 41, o1);
    }

    public boolean triggerNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return triggerNotify(4, 41, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 41, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 41, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_DATA_OUTPUT()
        throws Notify
    {
        return trace(4, 41);
    }

    public boolean throwNotify_Error_LM_2S_DATA_OUTPUT(Object o1)
        throws Notify
    {
        return throwNotify(4, 41, o1);
    }

    public boolean throwNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 41, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 41, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 41, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(4, 42);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return triggerNotify(4, 42, o1);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return triggerNotify(4, 42, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 42, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 42, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
        throws Notify
    {
        return trace(4, 42);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(4, 42, o1);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 42, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 42, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 42, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_ARM_FAILURE()
    {
        return trace(4, 43);
    }

    public boolean triggerNotify_Error_LM_2S_ARM_FAILURE(Object o1)
    {
        return triggerNotify(4, 43, o1);
    }

    public boolean triggerNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(4, 43, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 43, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 43, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_ARM_FAILURE()
        throws Notify
    {
        return trace(4, 43);
    }

    public boolean throwNotify_Error_LM_2S_ARM_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(4, 43, o1);
    }

    public boolean throwNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 43, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 43, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 43, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL()
    {
        return trace(4, 44);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
    {
        return triggerNotify(4, 44, o1);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
    {
        return triggerNotify(4, 44, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 44, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 44, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL()
        throws Notify
    {
        return trace(4, 44);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(4, 44, o1);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 44, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 44, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 44, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_WARN()
    {
        return trace(4, 45);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
    {
        return triggerNotify(4, 45, o1);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
    {
        return triggerNotify(4, 45, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 45, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 45, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_WARN()
        throws Notify
    {
        return trace(4, 45);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
        throws Notify
    {
        return throwNotify(4, 45, o1);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 45, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 45, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 45, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_3S_MQ_FAILURE()
    {
        return trace(4, 46);
    }

    public boolean triggerNotify_Error_LM_3S_MQ_FAILURE(Object o1)
    {
        return triggerNotify(4, 46, o1);
    }

    public boolean triggerNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(4, 46, o1, o2);
    }

    public boolean triggerNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 46, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 46, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_3S_MQ_FAILURE()
        throws Notify
    {
        return trace(4, 46);
    }

    public boolean throwNotify_Error_LM_3S_MQ_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(4, 46, o1);
    }

    public boolean throwNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 46, o1, o2);
    }

    public boolean throwNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 46, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 46, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_MQ_MESSAGE()
    {
        return trace(4, 47);
    }

    public boolean triggerNotify_Error_LM_1S_MQ_MESSAGE(Object o1)
    {
        return triggerNotify(4, 47, o1);
    }

    public boolean triggerNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(4, 47, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 47, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 47, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_MQ_MESSAGE()
        throws Notify
    {
        return trace(4, 47);
    }

    public boolean throwNotify_Error_LM_1S_MQ_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(4, 47, o1);
    }

    public boolean throwNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 47, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 47, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 47, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_ASN_FAILURE()
    {
        return trace(4, 48);
    }

    public boolean triggerNotify_Error_LM_1S_ASN_FAILURE(Object o1)
    {
        return triggerNotify(4, 48, o1);
    }

    public boolean triggerNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(4, 48, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 48, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 48, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_ASN_FAILURE()
        throws Notify
    {
        return trace(4, 48);
    }

    public boolean throwNotify_Error_LM_1S_ASN_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(4, 48, o1);
    }

    public boolean throwNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 48, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 48, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 48, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_ASN_FAILED()
    {
        return trace(4, 49);
    }

    public boolean triggerNotify_Error_LM_2S_ASN_FAILED(Object o1)
    {
        return triggerNotify(4, 49, o1);
    }

    public boolean triggerNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2)
    {
        return triggerNotify(4, 49, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 49, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 49, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_ASN_FAILED()
        throws Notify
    {
        return trace(4, 49);
    }

    public boolean throwNotify_Error_LM_2S_ASN_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(4, 49, o1);
    }

    public boolean throwNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 49, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 49, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 49, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_OID_TYPE()
    {
        return trace(4, 50);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1)
    {
        return triggerNotify(4, 50, o1);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
    {
        return triggerNotify(4, 50, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 50, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 50, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_OID_TYPE()
        throws Notify
    {
        return trace(4, 50);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(4, 50, o1);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 50, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 50, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 50, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_OIDFACTORY_FAILED()
    {
        return trace(4, 51);
    }

    public boolean triggerNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1)
    {
        return triggerNotify(4, 51, o1);
    }

    public boolean triggerNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
    {
        return triggerNotify(4, 51, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 51, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 51, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_OIDFACTORY_FAILED()
        throws Notify
    {
        return trace(4, 51);
    }

    public boolean throwNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(4, 51, o1);
    }

    public boolean throwNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 51, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 51, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 51, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE()
    {
        return trace(4, 52);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
    {
        return triggerNotify(4, 52, o1);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
    {
        return triggerNotify(4, 52, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 52, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 52, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE()
        throws Notify
    {
        return trace(4, 52);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
        throws Notify
    {
        return throwNotify(4, 52, o1);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 52, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 52, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 52, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_2S_FAILED_MEM_ALLOC()
    {
        return trace(4, 53);
    }

    public boolean triggerNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1)
    {
        return triggerNotify(4, 53, o1);
    }

    public boolean triggerNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
    {
        return triggerNotify(4, 53, o1, o2);
    }

    public boolean triggerNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 53, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 53, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_2S_FAILED_MEM_ALLOC()
        throws Notify
    {
        return trace(4, 53);
    }

    public boolean throwNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1)
        throws Notify
    {
        return throwNotify(4, 53, o1);
    }

    public boolean throwNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 53, o1, o2);
    }

    public boolean throwNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 53, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 53, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_CREATE_OID_ERROR()
    {
        return trace(4, 54);
    }

    public boolean triggerNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1)
    {
        return triggerNotify(4, 54, o1);
    }

    public boolean triggerNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
    {
        return triggerNotify(4, 54, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 54, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 54, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_CREATE_OID_ERROR()
        throws Notify
    {
        return trace(4, 54);
    }

    public boolean throwNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(4, 54, o1);
    }

    public boolean throwNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 54, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 54, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 54, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_1S_INVALID_NTN_AWB_GEN()
    {
        return trace(4, 55);
    }

    public boolean triggerNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
    {
        return triggerNotify(4, 55, o1);
    }

    public boolean triggerNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
    {
        return triggerNotify(4, 55, o1, o2);
    }

    public boolean triggerNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 55, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 55, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_1S_INVALID_NTN_AWB_GEN()
        throws Notify
    {
        return trace(4, 55);
    }

    public boolean throwNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
        throws Notify
    {
        return throwNotify(4, 55, o1);
    }

    public boolean throwNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 55, o1, o2);
    }

    public boolean throwNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 55, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 55, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_4S_WARN_MESSAGE()
    {
        return trace(4, 56);
    }

    public boolean triggerNotify_Error_LM_4S_WARN_MESSAGE(Object o1)
    {
        return triggerNotify(4, 56, o1);
    }

    public boolean triggerNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(4, 56, o1, o2);
    }

    public boolean triggerNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 56, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 56, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_4S_WARN_MESSAGE()
        throws Notify
    {
        return trace(4, 56);
    }

    public boolean throwNotify_Error_LM_4S_WARN_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(4, 56, o1);
    }

    public boolean throwNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 56, o1, o2);
    }

    public boolean throwNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 56, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 56, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Error_LM_5S_USER_LOGOUT()
    {
        return trace(4, 57);
    }

    public boolean triggerNotify_Error_LM_5S_USER_LOGOUT(Object o1)
    {
        return triggerNotify(4, 57, o1);
    }

    public boolean triggerNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2)
    {
        return triggerNotify(4, 57, o1, o2);
    }

    public boolean triggerNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(4, 57, o1, o2, o3);
    }

    public boolean triggerNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(4, 57, o1, o2, o3, o4);
    }

    public boolean throwNotify_Error_LM_5S_USER_LOGOUT()
        throws Notify
    {
        return trace(4, 57);
    }

    public boolean throwNotify_Error_LM_5S_USER_LOGOUT(Object o1)
        throws Notify
    {
        return throwNotify(4, 57, o1);
    }

    public boolean throwNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(4, 57, o1, o2);
    }

    public boolean throwNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(4, 57, o1, o2, o3);
    }

    public boolean throwNotify_Error_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(4, 57, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical(int ai_code)
    {
        return trace(5, ai_code);
    }

    public boolean triggerNotify_Critical(int ai_code, Object o1)
    {
        return triggerNotify(5, ai_code, o1);
    }

    public boolean triggerNotify_Critical(int ai_code, Object o1, Object o2)
    {
        return triggerNotify(5, ai_code, o1, o2);
    }

    public boolean triggerNotify_Critical(int ai_code, Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, ai_code, o1, o2, o3);
    }

    public boolean triggerNotify_Critical(int ai_code, Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, ai_code, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical(int ai_code)
        throws Notify
    {
        return trace(5, ai_code);
    }

    public boolean throwNotify_Critical(int ai_code, Object o1)
        throws Notify
    {
        return throwNotify(5, ai_code, o1);
    }

    public boolean throwNotify_Critical(int ai_code, Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, ai_code, o1, o2);
    }

    public boolean throwNotify_Critical(int ai_code, Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, ai_code, o1, o2, o3);
    }

    public boolean throwNotify_Critical(int ai_code, Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, ai_code, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_LOAD_ERROR()
    {
        return trace(5, 0);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1)
    {
        return triggerNotify(5, 0, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 0, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 0, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 0, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_LOAD_ERROR()
        throws Notify
    {
        return trace(5, 0);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 0, o1);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 0, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 0, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_LOAD_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 0, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_VERSION_ERROR()
    {
        return trace(5, 1);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1)
    {
        return triggerNotify(5, 1, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 1, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 1, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 1, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_VERSION_ERROR()
        throws Notify
    {
        return trace(5, 1);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 1, o1);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 1, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 1, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_EDIT_VERSION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 1, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_0S_EDIT_READ_ERROR()
    {
        return trace(5, 2);
    }

    public boolean triggerNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1)
    {
        return triggerNotify(5, 2, o1);
    }

    public boolean triggerNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 2, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 2, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 2, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_0S_EDIT_READ_ERROR()
        throws Notify
    {
        return trace(5, 2);
    }

    public boolean throwNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 2, o1);
    }

    public boolean throwNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 2, o1, o2);
    }

    public boolean throwNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 2, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_0S_EDIT_READ_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 2, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY()
    {
        return trace(5, 3);
    }

    public boolean triggerNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
    {
        return triggerNotify(5, 3, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
    {
        return triggerNotify(5, 3, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 3, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 3, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY()
        throws Notify
    {
        return trace(5, 3);
    }

    public boolean throwNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1)
        throws Notify
    {
        return throwNotify(5, 3, o1);
    }

    public boolean throwNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 3, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 3, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_INTERNAL_INCONSISTANCY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 3, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_CORRUPTION_ERROR()
    {
        return trace(5, 4);
    }

    public boolean triggerNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1)
    {
        return triggerNotify(5, 4, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 4, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 4, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 4, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_CORRUPTION_ERROR()
        throws Notify
    {
        return trace(5, 4);
    }

    public boolean throwNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 4, o1);
    }

    public boolean throwNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 4, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 4, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_CORRUPTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 4, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_CONSECUTIVE_ERRORS()
    {
        return trace(5, 5);
    }

    public boolean triggerNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1)
    {
        return triggerNotify(5, 5, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
    {
        return triggerNotify(5, 5, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 5, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 5, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_CONSECUTIVE_ERRORS()
        throws Notify
    {
        return trace(5, 5);
    }

    public boolean throwNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1)
        throws Notify
    {
        return throwNotify(5, 5, o1);
    }

    public boolean throwNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 5, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 5, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_CONSECUTIVE_ERRORS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 5, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_ERROR()
    {
        return trace(5, 6);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1)
    {
        return triggerNotify(5, 6, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 6, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 6, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 6, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_ERROR()
        throws Notify
    {
        return trace(5, 6);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 6, o1);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 6, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 6, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 6, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_INFO()
    {
        return trace(5, 7);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1)
    {
        return triggerNotify(5, 7, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
    {
        return triggerNotify(5, 7, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 7, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 7, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_INFO()
        throws Notify
    {
        return trace(5, 7);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1)
        throws Notify
    {
        return throwNotify(5, 7, o1);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 7, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 7, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_INFO(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 7, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_WARN()
    {
        return trace(5, 8);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1)
    {
        return triggerNotify(5, 8, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
    {
        return triggerNotify(5, 8, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 8, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 8, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_WARN()
        throws Notify
    {
        return trace(5, 8);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1)
        throws Notify
    {
        return throwNotify(5, 8, o1);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 8, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 8, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 8, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_ERROR()
    {
        return trace(5, 9);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1)
    {
        return triggerNotify(5, 9, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 9, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 9, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 9, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_ERROR()
        throws Notify
    {
        return trace(5, 9);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 9, o1);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 9, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 9, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 9, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_FATAL()
    {
        return trace(5, 10);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1)
    {
        return triggerNotify(5, 10, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
    {
        return triggerNotify(5, 10, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 10, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 10, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_FATAL()
        throws Notify
    {
        return trace(5, 10);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(5, 10, o1);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 10, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 10, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_MIDDLEWARE_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 10, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_0S_NO_MIDDLEWARE()
    {
        return trace(5, 11);
    }

    public boolean triggerNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1)
    {
        return triggerNotify(5, 11, o1);
    }

    public boolean triggerNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
    {
        return triggerNotify(5, 11, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 11, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 11, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_0S_NO_MIDDLEWARE()
        throws Notify
    {
        return trace(5, 11);
    }

    public boolean throwNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1)
        throws Notify
    {
        return throwNotify(5, 11, o1);
    }

    public boolean throwNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 11, o1, o2);
    }

    public boolean throwNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 11, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_0S_NO_MIDDLEWARE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 11, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_FAILED()
    {
        return trace(5, 12);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1)
    {
        return triggerNotify(5, 12, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
    {
        return triggerNotify(5, 12, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 12, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 12, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_FAILED()
        throws Notify
    {
        return trace(5, 12);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(5, 12, o1);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 12, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 12, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_ALLOCATION_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 12, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_CALL_FAILED()
    {
        return trace(5, 13);
    }

    public boolean triggerNotify_Critical_LM_1S_CALL_FAILED(Object o1)
    {
        return triggerNotify(5, 13, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(5, 13, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 13, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 13, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_CALL_FAILED()
        throws Notify
    {
        return trace(5, 13);
    }

    public boolean throwNotify_Critical_LM_1S_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(5, 13, o1);
    }

    public boolean throwNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 13, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 13, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 13, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_QUEUE_ERROR()
    {
        return trace(5, 14);
    }

    public boolean triggerNotify_Critical_LM_1S_QUEUE_ERROR(Object o1)
    {
        return triggerNotify(5, 14, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 14, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 14, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 14, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_QUEUE_ERROR()
        throws Notify
    {
        return trace(5, 14);
    }

    public boolean throwNotify_Critical_LM_1S_QUEUE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 14, o1);
    }

    public boolean throwNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 14, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 14, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_QUEUE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 14, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_REQUIRED()
    {
        return trace(5, 15);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1)
    {
        return triggerNotify(5, 15, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
    {
        return triggerNotify(5, 15, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 15, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 15, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_REQUIRED()
        throws Notify
    {
        return trace(5, 15);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1)
        throws Notify
    {
        return throwNotify(5, 15, o1);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 15, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 15, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_REQUIRED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 15, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_TPOPEN_FAIL()
    {
        return trace(5, 16);
    }

    public boolean triggerNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1)
    {
        return triggerNotify(5, 16, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
    {
        return triggerNotify(5, 16, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 16, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 16, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_TPOPEN_FAIL()
        throws Notify
    {
        return trace(5, 16);
    }

    public boolean throwNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(5, 16, o1);
    }

    public boolean throwNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 16, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 16, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_TPOPEN_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 16, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_TPCLOSE_FAIL()
    {
        return trace(5, 17);
    }

    public boolean triggerNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1)
    {
        return triggerNotify(5, 17, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
    {
        return triggerNotify(5, 17, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 17, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 17, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_TPCLOSE_FAIL()
        throws Notify
    {
        return trace(5, 17);
    }

    public boolean throwNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(5, 17, o1);
    }

    public boolean throwNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 17, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 17, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_TPCLOSE_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 17, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_TRANSACTION_ERROR()
    {
        return trace(5, 18);
    }

    public boolean triggerNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1)
    {
        return triggerNotify(5, 18, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 18, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 18, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 18, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_TRANSACTION_ERROR()
        throws Notify
    {
        return trace(5, 18);
    }

    public boolean throwNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 18, o1);
    }

    public boolean throwNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 18, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 18, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_TRANSACTION_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 18, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_CONNECT_DB_FAIL()
    {
        return trace(5, 19);
    }

    public boolean triggerNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1)
    {
        return triggerNotify(5, 19, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
    {
        return triggerNotify(5, 19, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 19, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 19, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_CONNECT_DB_FAIL()
        throws Notify
    {
        return trace(5, 19);
    }

    public boolean throwNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1)
        throws Notify
    {
        return throwNotify(5, 19, o1);
    }

    public boolean throwNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 19, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 19, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_CONNECT_DB_FAIL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 19, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_DB_ERROR()
    {
        return trace(5, 20);
    }

    public boolean triggerNotify_Critical_LM_3S_DB_ERROR(Object o1)
    {
        return triggerNotify(5, 20, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 20, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 20, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 20, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_DB_ERROR()
        throws Notify
    {
        return trace(5, 20);
    }

    public boolean throwNotify_Critical_LM_3S_DB_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 20, o1);
    }

    public boolean throwNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 20, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 20, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_DB_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 20, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR()
    {
        return trace(5, 21);
    }

    public boolean triggerNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
    {
        return triggerNotify(5, 21, o1);
    }

    public boolean triggerNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 21, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 21, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 21, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR()
        throws Notify
    {
        return trace(5, 21);
    }

    public boolean throwNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 21, o1);
    }

    public boolean throwNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 21, o1, o2);
    }

    public boolean throwNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 21, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_0S_INTERNAL_TABLE_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 21, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_NOENTRY()
    {
        return trace(5, 22);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_NOENTRY(Object o1)
    {
        return triggerNotify(5, 22, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2)
    {
        return triggerNotify(5, 22, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 22, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 22, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_DB_NOENTRY()
        throws Notify
    {
        return trace(5, 22);
    }

    public boolean throwNotify_Critical_LM_2S_DB_NOENTRY(Object o1)
        throws Notify
    {
        return throwNotify(5, 22, o1);
    }

    public boolean throwNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 22, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 22, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_DB_NOENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 22, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY()
    {
        return trace(5, 23);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
    {
        return triggerNotify(5, 23, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
    {
        return triggerNotify(5, 23, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 23, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 23, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY()
        throws Notify
    {
        return trace(5, 23);
    }

    public boolean throwNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1)
        throws Notify
    {
        return throwNotify(5, 23, o1);
    }

    public boolean throwNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 23, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 23, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_DB_MORE_THAN_ONE_ENTRY(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 23, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_DB_INVALID_RESULTS()
    {
        return trace(5, 24);
    }

    public boolean triggerNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1)
    {
        return triggerNotify(5, 24, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
    {
        return triggerNotify(5, 24, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 24, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 24, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_DB_INVALID_RESULTS()
        throws Notify
    {
        return trace(5, 24);
    }

    public boolean throwNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1)
        throws Notify
    {
        return throwNotify(5, 24, o1);
    }

    public boolean throwNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 24, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 24, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_DB_INVALID_RESULTS(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 24, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION()
    {
        return trace(5, 25);
    }

    public boolean triggerNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(5, 25, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(5, 25, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 25, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 25, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION()
        throws Notify
    {
        return trace(5, 25);
    }

    public boolean throwNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(5, 25, o1);
    }

    public boolean throwNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 25, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 25, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_CAUGHT_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 25, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_4S_FX_EXCEPTION()
    {
        return trace(5, 26);
    }

    public boolean triggerNotify_Critical_LM_4S_FX_EXCEPTION(Object o1)
    {
        return triggerNotify(5, 26, o1);
    }

    public boolean triggerNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(5, 26, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 26, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 26, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_4S_FX_EXCEPTION()
        throws Notify
    {
        return trace(5, 26);
    }

    public boolean throwNotify_Critical_LM_4S_FX_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(5, 26, o1);
    }

    public boolean throwNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 26, o1, o2);
    }

    public boolean throwNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 26, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_4S_FX_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 26, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_SVCBASE_CALL_FAILED()
    {
        return trace(5, 27);
    }

    public boolean triggerNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1)
    {
        return triggerNotify(5, 27, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
    {
        return triggerNotify(5, 27, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 27, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 27, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_SVCBASE_CALL_FAILED()
        throws Notify
    {
        return trace(5, 27);
    }

    public boolean throwNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(5, 27, o1);
    }

    public boolean throwNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 27, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 27, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_SVCBASE_CALL_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 27, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_0S_INVALID_DATAMANAGER()
    {
        return trace(5, 28);
    }

    public boolean triggerNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1)
    {
        return triggerNotify(5, 28, o1);
    }

    public boolean triggerNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
    {
        return triggerNotify(5, 28, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 28, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 28, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_0S_INVALID_DATAMANAGER()
        throws Notify
    {
        return trace(5, 28);
    }

    public boolean throwNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1)
        throws Notify
    {
        return throwNotify(5, 28, o1);
    }

    public boolean throwNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 28, o1, o2);
    }

    public boolean throwNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 28, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_0S_INVALID_DATAMANAGER(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 28, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_STANDARD_EXCEPTION()
    {
        return trace(5, 29);
    }

    public boolean triggerNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1)
    {
        return triggerNotify(5, 29, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(5, 29, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 29, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 29, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_STANDARD_EXCEPTION()
        throws Notify
    {
        return trace(5, 29);
    }

    public boolean throwNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(5, 29, o1);
    }

    public boolean throwNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 29, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 29, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_STANDARD_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 29, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION()
    {
        return trace(5, 30);
    }

    public boolean triggerNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
    {
        return triggerNotify(5, 30, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
    {
        return triggerNotify(5, 30, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 30, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 30, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION()
        throws Notify
    {
        return trace(5, 30);
    }

    public boolean throwNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1)
        throws Notify
    {
        return throwNotify(5, 30, o1);
    }

    public boolean throwNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 30, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 30, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_UNEXPECTED_EXCEPTION(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 30, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG()
    {
        return trace(5, 31);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
    {
        return triggerNotify(5, 31, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
    {
        return triggerNotify(5, 31, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 31, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 31, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG()
        throws Notify
    {
        return trace(5, 31);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1)
        throws Notify
    {
        return throwNotify(5, 31, o1);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 31, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 31, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_TRANSACTION_MONITOR_MSG(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 31, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_DATA_TYPE()
    {
        return trace(5, 32);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1)
    {
        return triggerNotify(5, 32, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
    {
        return triggerNotify(5, 32, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 32, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 32, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_DATA_TYPE()
        throws Notify
    {
        return trace(5, 32);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(5, 32, o1);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 32, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 32, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_DATA_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 32, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_GET()
    {
        return trace(5, 33);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1)
    {
        return triggerNotify(5, 33, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
    {
        return triggerNotify(5, 33, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 33, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 33, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_GET()
        throws Notify
    {
        return trace(5, 33);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1)
        throws Notify
    {
        return throwNotify(5, 33, o1);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 33, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 33, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_GET(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 33, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CREATE()
    {
        return trace(5, 34);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1)
    {
        return triggerNotify(5, 34, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
    {
        return triggerNotify(5, 34, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 34, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 34, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CREATE()
        throws Notify
    {
        return trace(5, 34);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1)
        throws Notify
    {
        return throwNotify(5, 34, o1);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 34, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 34, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CREATE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 34, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CTL()
    {
        return trace(5, 35);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1)
    {
        return triggerNotify(5, 35, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
    {
        return triggerNotify(5, 35, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 35, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 35, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CTL()
        throws Notify
    {
        return trace(5, 35);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1)
        throws Notify
    {
        return throwNotify(5, 35, o1);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 35, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 35, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_CTL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 35, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_OP()
    {
        return trace(5, 36);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1)
    {
        return triggerNotify(5, 36, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
    {
        return triggerNotify(5, 36, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 36, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 36, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_OP()
        throws Notify
    {
        return trace(5, 36);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1)
        throws Notify
    {
        return throwNotify(5, 36, o1);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 36, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 36, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_IPC_OP(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 36, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_4S_UNKNOWN_CODE()
    {
        return trace(5, 37);
    }

    public boolean triggerNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1)
    {
        return triggerNotify(5, 37, o1);
    }

    public boolean triggerNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
    {
        return triggerNotify(5, 37, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 37, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 37, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_4S_UNKNOWN_CODE()
        throws Notify
    {
        return trace(5, 37);
    }

    public boolean throwNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1)
        throws Notify
    {
        return throwNotify(5, 37, o1);
    }

    public boolean throwNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 37, o1, o2);
    }

    public boolean throwNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 37, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_4S_UNKNOWN_CODE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 37, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_INIT_OBJECT()
    {
        return trace(5, 38);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1)
    {
        return triggerNotify(5, 38, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
    {
        return triggerNotify(5, 38, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 38, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 38, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_INIT_OBJECT()
        throws Notify
    {
        return trace(5, 38);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1)
        throws Notify
    {
        return throwNotify(5, 38, o1);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 38, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 38, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_INIT_OBJECT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 38, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_OPEN_FILE()
    {
        return trace(5, 39);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1)
    {
        return triggerNotify(5, 39, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
    {
        return triggerNotify(5, 39, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 39, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 39, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_OPEN_FILE()
        throws Notify
    {
        return trace(5, 39);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1)
        throws Notify
    {
        return throwNotify(5, 39, o1);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 39, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 39, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_FAILED_OPEN_FILE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 39, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_SYSTEM_CALL()
    {
        return trace(5, 40);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1)
    {
        return triggerNotify(5, 40, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
    {
        return triggerNotify(5, 40, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 40, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 40, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_SYSTEM_CALL()
        throws Notify
    {
        return trace(5, 40);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1)
        throws Notify
    {
        return throwNotify(5, 40, o1);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 40, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 40, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_FAILED_SYSTEM_CALL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 40, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_DATA_OUTPUT()
    {
        return trace(5, 41);
    }

    public boolean triggerNotify_Critical_LM_2S_DATA_OUTPUT(Object o1)
    {
        return triggerNotify(5, 41, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2)
    {
        return triggerNotify(5, 41, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 41, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 41, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_DATA_OUTPUT()
        throws Notify
    {
        return trace(5, 41);
    }

    public boolean throwNotify_Critical_LM_2S_DATA_OUTPUT(Object o1)
        throws Notify
    {
        return throwNotify(5, 41, o1);
    }

    public boolean throwNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 41, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 41, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_DATA_OUTPUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 41, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
    {
        return trace(5, 42);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
    {
        return triggerNotify(5, 42, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
    {
        return triggerNotify(5, 42, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 42, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 42, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE()
        throws Notify
    {
        return trace(5, 42);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(5, 42, o1);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 42, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 42, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_NOTIFICATION_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 42, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_ARM_FAILURE()
    {
        return trace(5, 43);
    }

    public boolean triggerNotify_Critical_LM_2S_ARM_FAILURE(Object o1)
    {
        return triggerNotify(5, 43, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(5, 43, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 43, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 43, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_ARM_FAILURE()
        throws Notify
    {
        return trace(5, 43);
    }

    public boolean throwNotify_Critical_LM_2S_ARM_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(5, 43, o1);
    }

    public boolean throwNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 43, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 43, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_ARM_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 43, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL()
    {
        return trace(5, 44);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
    {
        return triggerNotify(5, 44, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
    {
        return triggerNotify(5, 44, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 44, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 44, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL()
        throws Notify
    {
        return trace(5, 44);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1)
        throws Notify
    {
        return throwNotify(5, 44, o1);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 44, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 44, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_FATAL(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 44, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN()
    {
        return trace(5, 45);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
    {
        return triggerNotify(5, 45, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
    {
        return triggerNotify(5, 45, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 45, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 45, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN()
        throws Notify
    {
        return trace(5, 45);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1)
        throws Notify
    {
        return throwNotify(5, 45, o1);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 45, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 45, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_NO_CONFIG_VAR_WARN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 45, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_3S_MQ_FAILURE()
    {
        return trace(5, 46);
    }

    public boolean triggerNotify_Critical_LM_3S_MQ_FAILURE(Object o1)
    {
        return triggerNotify(5, 46, o1);
    }

    public boolean triggerNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(5, 46, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 46, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 46, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_3S_MQ_FAILURE()
        throws Notify
    {
        return trace(5, 46);
    }

    public boolean throwNotify_Critical_LM_3S_MQ_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(5, 46, o1);
    }

    public boolean throwNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 46, o1, o2);
    }

    public boolean throwNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 46, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_3S_MQ_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 46, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_MQ_MESSAGE()
    {
        return trace(5, 47);
    }

    public boolean triggerNotify_Critical_LM_1S_MQ_MESSAGE(Object o1)
    {
        return triggerNotify(5, 47, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(5, 47, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 47, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 47, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_MQ_MESSAGE()
        throws Notify
    {
        return trace(5, 47);
    }

    public boolean throwNotify_Critical_LM_1S_MQ_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(5, 47, o1);
    }

    public boolean throwNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 47, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 47, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_MQ_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 47, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_ASN_FAILURE()
    {
        return trace(5, 48);
    }

    public boolean triggerNotify_Critical_LM_1S_ASN_FAILURE(Object o1)
    {
        return triggerNotify(5, 48, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2)
    {
        return triggerNotify(5, 48, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 48, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 48, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_ASN_FAILURE()
        throws Notify
    {
        return trace(5, 48);
    }

    public boolean throwNotify_Critical_LM_1S_ASN_FAILURE(Object o1)
        throws Notify
    {
        return throwNotify(5, 48, o1);
    }

    public boolean throwNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 48, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 48, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_ASN_FAILURE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 48, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_ASN_FAILED()
    {
        return trace(5, 49);
    }

    public boolean triggerNotify_Critical_LM_2S_ASN_FAILED(Object o1)
    {
        return triggerNotify(5, 49, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2)
    {
        return triggerNotify(5, 49, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 49, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 49, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_ASN_FAILED()
        throws Notify
    {
        return trace(5, 49);
    }

    public boolean throwNotify_Critical_LM_2S_ASN_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(5, 49, o1);
    }

    public boolean throwNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 49, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 49, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_ASN_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 49, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_OID_TYPE()
    {
        return trace(5, 50);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1)
    {
        return triggerNotify(5, 50, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
    {
        return triggerNotify(5, 50, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 50, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 50, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_OID_TYPE()
        throws Notify
    {
        return trace(5, 50);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1)
        throws Notify
    {
        return throwNotify(5, 50, o1);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 50, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 50, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_INVALID_OID_TYPE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 50, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_OIDFACTORY_FAILED()
    {
        return trace(5, 51);
    }

    public boolean triggerNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1)
    {
        return triggerNotify(5, 51, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
    {
        return triggerNotify(5, 51, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 51, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 51, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_OIDFACTORY_FAILED()
        throws Notify
    {
        return trace(5, 51);
    }

    public boolean throwNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1)
        throws Notify
    {
        return throwNotify(5, 51, o1);
    }

    public boolean throwNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 51, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 51, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_OIDFACTORY_FAILED(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 51, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE()
    {
        return trace(5, 52);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
    {
        return triggerNotify(5, 52, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
    {
        return triggerNotify(5, 52, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 52, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 52, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE()
        throws Notify
    {
        return trace(5, 52);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1)
        throws Notify
    {
        return throwNotify(5, 52, o1);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 52, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 52, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_UNKNOWN_IMPORT_RULE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 52, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_2S_FAILED_MEM_ALLOC()
    {
        return trace(5, 53);
    }

    public boolean triggerNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1)
    {
        return triggerNotify(5, 53, o1);
    }

    public boolean triggerNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
    {
        return triggerNotify(5, 53, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 53, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 53, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_2S_FAILED_MEM_ALLOC()
        throws Notify
    {
        return trace(5, 53);
    }

    public boolean throwNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1)
        throws Notify
    {
        return throwNotify(5, 53, o1);
    }

    public boolean throwNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 53, o1, o2);
    }

    public boolean throwNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 53, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_2S_FAILED_MEM_ALLOC(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 53, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_CREATE_OID_ERROR()
    {
        return trace(5, 54);
    }

    public boolean triggerNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1)
    {
        return triggerNotify(5, 54, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
    {
        return triggerNotify(5, 54, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 54, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 54, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_CREATE_OID_ERROR()
        throws Notify
    {
        return trace(5, 54);
    }

    public boolean throwNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1)
        throws Notify
    {
        return throwNotify(5, 54, o1);
    }

    public boolean throwNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 54, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 54, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_CREATE_OID_ERROR(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 54, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN()
    {
        return trace(5, 55);
    }

    public boolean triggerNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
    {
        return triggerNotify(5, 55, o1);
    }

    public boolean triggerNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
    {
        return triggerNotify(5, 55, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 55, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 55, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN()
        throws Notify
    {
        return trace(5, 55);
    }

    public boolean throwNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1)
        throws Notify
    {
        return throwNotify(5, 55, o1);
    }

    public boolean throwNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 55, o1, o2);
    }

    public boolean throwNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 55, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_1S_INVALID_NTN_AWB_GEN(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 55, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_4S_WARN_MESSAGE()
    {
        return trace(5, 56);
    }

    public boolean triggerNotify_Critical_LM_4S_WARN_MESSAGE(Object o1)
    {
        return triggerNotify(5, 56, o1);
    }

    public boolean triggerNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2)
    {
        return triggerNotify(5, 56, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 56, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 56, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_4S_WARN_MESSAGE()
        throws Notify
    {
        return trace(5, 56);
    }

    public boolean throwNotify_Critical_LM_4S_WARN_MESSAGE(Object o1)
        throws Notify
    {
        return throwNotify(5, 56, o1);
    }

    public boolean throwNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 56, o1, o2);
    }

    public boolean throwNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 56, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_4S_WARN_MESSAGE(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 56, o1, o2, o3, o4);
    }

    public boolean triggerNotify_Critical_LM_5S_USER_LOGOUT()
    {
        return trace(5, 57);
    }

    public boolean triggerNotify_Critical_LM_5S_USER_LOGOUT(Object o1)
    {
        return triggerNotify(5, 57, o1);
    }

    public boolean triggerNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2)
    {
        return triggerNotify(5, 57, o1, o2);
    }

    public boolean triggerNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
    {
        return triggerNotify(5, 57, o1, o2, o3);
    }

    public boolean triggerNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
    {
        return triggerNotify(5, 57, o1, o2, o3, o4);
    }

    public boolean throwNotify_Critical_LM_5S_USER_LOGOUT()
        throws Notify
    {
        return trace(5, 57);
    }

    public boolean throwNotify_Critical_LM_5S_USER_LOGOUT(Object o1)
        throws Notify
    {
        return throwNotify(5, 57, o1);
    }

    public boolean throwNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2)
        throws Notify
    {
        return throwNotify(5, 57, o1, o2);
    }

    public boolean throwNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3)
        throws Notify
    {
        return throwNotify(5, 57, o1, o2, o3);
    }

    public boolean throwNotify_Critical_LM_5S_USER_LOGOUT(Object o1, Object o2, Object o3, Object o4)
        throws Notify
    {
        return throwNotify(5, 57, o1, o2, o3, o4);
    }
}
