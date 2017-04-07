package cciij.util;


import java.util.*;
import java.io.FileNotFoundException;
import rmtc.util.*;
import java.text.DateFormat;

public class SortDate 
{
    Config m_config;

    //     static long m_sortDateStart = -1;
    static public final long milliSecondsPerDay = 86400000;
    //     static TimeZone tz = null;

    public SortDate() 
    {
	m_config = new Config("SortDate");
    }

    public SortDate(Config config) 
    {
	m_config = config;
    }

    public void setConfig(Config config) 
    {
	m_config = config;
    }

    protected long getSortDateStart(String locationCd)
    {
	long sortDateStart = -1;

        m_config.setLocationCode(locationCd);

	try 
	{
	    // get the value that represents the number of seconds since midnight
	    sortDateStart =  ( Integer.parseInt(m_config.getValue("SORTDATESTART"),10) );
	}
	catch (NumberFormatException ex) 
	{
	    ex.printStackTrace();
	}

	sortDateStart *= 1000;  // convert to milliseconds

	return sortDateStart;
    }
	    
    protected long getSortDateStart()
    {
	long sortDateStart = -1;

	try 
	{
	    // get the value that represents the number of seconds since midnight
	    sortDateStart =  ( Integer.parseInt(m_config.getValue("SORTDATESTART"),10) );
	}
	catch (NumberFormatException ex) 
	{
	    ex.printStackTrace();
	}

	sortDateStart *= 1000;  // convert to milliseconds

	return sortDateStart;
    }
	    
    protected TimeZone getLocalTimeZone()
    {
	return TimeZone.getTimeZone("UTC");
// 	TimeZone tz;
// 	String localTimeZone = null;
// 	localTimeZone = m_config.getValue("LOCAL_TIMEZONE");

// 	if ( localTimeZone == null || localTimeZone.length() <= 0 ) 
// 	{
// 	    tz = TimeZone.getTimeZone("GMT+00:00");
// 	}
// 	else 
// 	{
// 	    tz = TimeZone.getTimeZone(localTimeZone);
// 	}

// 	return tz;
    }


    //Returns a long value that represents milliSeconds since the ephoc
    public long currentSortDate(String locationCode) 
    {
	return currentSortDate(locationCode,null).getTime();
// 	long j;
// 	Calendar rightNow = Calendar.getInstance(getLocalTimeZone());
// 	j = calculateSecondsSinceMidNight(rightNow);
// 	if ( j <= getSortDateStart() )
// 	{
// 	    rightNow.add(Calendar.DATE, -1);
// 	}
// 	return rightNow.getTime().getTime() - (j);
    }

    //returns the sort date for the date it was passed
    public Date currentSortDate(String locationCode,Date d) 
    {
	long j;
	Calendar fromParam = Calendar.getInstance(getLocalTimeZone());
	if(d != null)
	{
	    fromParam.setTime(d);
	}
	j = calculateSecondsSinceMidNight(fromParam);
	if ( j <= getSortDateStart(locationCode) ) 
	{
	    fromParam.add(Calendar.DATE, -1);
	}
	return new Date(fromParam.getTime().getTime() - (j) );

    }

    private long calculateSecondsSinceMidNight(Calendar c) 
    {
	long j;
	j  = c.get(Calendar.HOUR_OF_DAY) * 3600;
	j += c.get(Calendar.MINUTE) * 60;
	j += c.get(Calendar.SECOND);
	j = j*1000; // convert to milliseconds
	j += c.get(Calendar.MILLISECOND);
	return j;
    }

    public static void main(String[] args)
    {
	System.out.println("SortDate in main");
	SortDate o = new SortDate();

	String locationCode="YYZ";

	int hourOffset=0;

	if(args.length > 0)
	{
	    locationCode = args[0];

	    try
	    {
		hourOffset = Integer.parseInt(args[1]);
		
		System.out.println("Found an offset argument of:  " + hourOffset);
	    }
	    catch(Exception e)
	    {
		System.out.println(" No Valid offset argument, using current time");
	    }
	}

	o.m_config.setLocationCode(locationCode);
	Calendar rightNow = Calendar.getInstance(o.getLocalTimeZone());

	System.out.println("Operating with the following parameters:");
	System.out.println("Local TimeZone:         " + o.getLocalTimeZone().getDisplayName());
	System.out.println("SortDateStartOffset:    " + o.getSortDateStart());

	if(hourOffset != 0)
	{
	    rightNow.add(Calendar.HOUR,hourOffset);
	}

	Date dt = rightNow.getTime();
	DateFormat df = DateFormat.getDateInstance();
	DateFormat tf = DateFormat.getTimeInstance();

	TimeZone ltz = o.getLocalTimeZone();
	//	TimeZone.setDefaultTimeZone(ltz);
	df.setTimeZone(ltz);
	tf.setTimeZone(ltz);

	System.out.println("Date:               " + df.format(dt) + " " + tf.format(dt));
	System.out.println("Date:               " + dt.getTime());
	System.out.println("CurrentSortDate:    " + df.format(o.currentSortDate(locationCode,dt)) + " " + tf.format(o.currentSortDate(locationCode,dt)));
	System.out.println("CurrentSortDate:    " + o.currentSortDate(locationCode,dt).getTime());

// 	System.out.println ( "Testing the currentSortDate() method" );
// 	Calendar rightNow = Calendar.getInstance(o.getLocalTimeZone());
// 	System.out.println ( "Time right now      : " + rightNow.getTime() );
// 	System.out.println ( "Sort date calculated: " + new Date(o.currentSortDate()));

// 	System.out.println ( "Testing the currentSortDate(Date) method" );
// 	rightNow.add(Calendar.HOUR, 6);
// 	Date dt = rightNow.getTime();
// 	System.out.println ( "Date object passed  : " + dt );
// 	System.out.println ( "Sort date calculated: " + o.currentSortDate(dt));

// 	rightNow.add(Calendar.HOUR, -12);
// 	dt = rightNow.getTime();
// 	System.out.println ( "Date object passed  : " + dt );
// 	System.out.println ( "Sort date calculated: " + o.currentSortDate(dt));

// 	System.out.println("Leaving SortDate");
    }



}
