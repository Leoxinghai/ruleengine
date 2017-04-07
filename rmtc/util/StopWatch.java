// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StopWatch.java

package rmtc.util;


public class StopWatch
{

    public StopWatch()
    {
        startTime = -1L;
        stopTime = -1L;
    }

    public void start()
    {
        startTime = System.currentTimeMillis();
    }

    public void stop()
    {
        stopTime = System.currentTimeMillis();
    }

    public void reset()
    {
        startTime = -1L;
        stopTime = -1L;
    }

    public void split()
    {
        stopTime = System.currentTimeMillis();
    }

    public void unsplit()
    {
        stopTime = -1L;
    }

    public long getTime()
    {
        if(stopTime != -1L)
            return System.currentTimeMillis() - startTime;
        else
            return stopTime - startTime;
    }

    public String toString()
    {
        return getTimeString();
    }

    public String getTimeString()
    {
        long time = getTime();
        int hours = (int)(time / (long)AN_HOUR);
        time -= hours * AN_HOUR;
        int minutes = (int)(time / (long)A_MINUTE);
        time -= minutes * A_MINUTE;
        int seconds = (int)(time / 1000L);
        time -= seconds * 1000;
        int milliseconds = (int)time;
        return hours + "h:" + minutes + "m:" + seconds + "s:" + milliseconds + "ms";
    }

    public static int AN_HOUR = 0x36ee80;
    public static int A_MINUTE = 60000;
    private long startTime;
    private long stopTime;

}
