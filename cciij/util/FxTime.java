package cciij.util;

import java.util.*;
import java.sql.Timestamp;


public class FxTime extends Timestamp
{
    int m_yearStart = 0;
    int m_monthStart = 0;
    int m_dayStart = 0;
    int m_hourStart = 0;
    int m_minuteStart = 0;
    int m_secondStart = 0;
    int m_millisecondStart = 0;

    public FxTime()
    {
	super(0);
    }

   /**
   *FxTime
   * @param String dateTime
   * @param String format
   *               includes century - A
   *               does not include century - B
   *    formats allowed: 
   *               YYYYMMDDHHMMSSMMM - only first 8 characters required
   *               YYMMDDHHMMSSMMM - only first 6 characters required
   */

   public void createTimestampFromString(String dateTime, String format)
   {
        System.out.println("createTimestampFromString input = " + dateTime +
	"format requested = " + format);
        for (int i=0; dateTime.length() < 17; i++) 
        {
           dateTime = dateTime.concat("0");
        }
        if (format.equals("A"))
        {
            m_monthStart= 4; 
        }
        else
        if (format.equals("B"))
        {
            m_monthStart= 2; 
        } 

        m_dayStart = m_monthStart + 2;
        m_hourStart = m_dayStart + 2;
        m_minuteStart = m_hourStart + 2;
        m_secondStart = m_minuteStart + 2;
        m_millisecondStart = m_secondStart + 2;
			      
	String jdbcTime;
	if (m_monthStart == 2)  
	{
	    jdbcTime = "20";
	    jdbcTime = jdbcTime.concat(dateTime.substring(0, 2));
	}   
	else
	{
	    jdbcTime = dateTime.substring(0, 4);
        }
	jdbcTime = jdbcTime.concat("-");
	System.out.println(" month " + dateTime.substring(m_monthStart,
						m_monthStart + 2));
	jdbcTime = jdbcTime.concat(dateTime.substring(m_monthStart,
						      m_monthStart + 2));
	jdbcTime= jdbcTime.concat("-");
	jdbcTime = jdbcTime.concat(dateTime.substring(m_dayStart,
						      m_dayStart + 2));
	jdbcTime= jdbcTime.concat(" ");
	jdbcTime = jdbcTime.concat(dateTime.substring(m_hourStart,
						      m_hourStart + 2));
	jdbcTime= jdbcTime.concat(":");
	jdbcTime = jdbcTime.concat(dateTime.substring(m_minuteStart,
						      m_minuteStart + 2));
	jdbcTime= jdbcTime.concat(":");
	jdbcTime = jdbcTime.concat(dateTime.substring(m_secondStart,
						      m_secondStart + 2));
	jdbcTime= jdbcTime.concat(".");
	jdbcTime = jdbcTime.concat(dateTime.substring(m_millisecondStart,
						      m_millisecondStart + 3));
        jdbcTime = jdbcTime.concat("000000");
	
        System.out.println("jdbc date " + jdbcTime);

        Timestamp  time = valueOf(jdbcTime);

        System.out.println("timestamp " + time );
	return;

    }


    public static void main(String args[])
    {
	 FxTime time = new FxTime();
	 time.timeTest();
    
    }
    public void timeTest()
    {
    //                                               YYYYMMHHMISSMMM
         createTimestampFromString("200301022347002", "A");
	 
         createTimestampFromString("0301022347002", "B");
         createTimestampFromString("20030102", "A");
         createTimestampFromString("030102", "B");
	 return;
    }
}
