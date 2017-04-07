package cciij.util;

import rmtc.util.Config;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.StringTokenizer;

public class LocationList
{
    Config m_config = null;

    Map m_locations = null;

    public LocationList(Config cfg)
    {
	if(cfg == null)
	{
	    throw new RuntimeException("Null Config passed to cciij.util.LocationList");
	}
	m_config = cfg;
	m_locations = new TreeMap();
    }

    public String[] getLocationList()
    {
	String retVal[];
	String locationList = m_config.getValue("ALLOWED_LOCATION_LIST");
	if(locationList == null)
	{
	    if(m_config.getLocationCode() == null || m_config.getLocationCode().equals(""))
	    {
		retVal = new String[0];
	    }
	    else
	    {
		retVal = new String[1];
		retVal[0] = m_config.getLocationCode();
	    }
	}
	else
	{
	    String fullLocationList = null;
	    if(m_config.getLocationCode() == null || m_config.getLocationCode().equals(""))
	    {
		fullLocationList = locationList;
	    }
	    else
	    {
		fullLocationList = m_config.getLocationCode() + "," + locationList;
	    }

	    if(m_locations.containsKey(fullLocationList))
	    {
		retVal = (String[])m_locations.get(fullLocationList);
	    }
	    else
	    {
		retVal = buildLocationList(fullLocationList);
		m_locations.put(fullLocationList,retVal);
	    }
	}

	return retVal;
    }

    protected String[] buildLocationList(String locations)
    {
	String retVal[] = new String[0];

	Vector locs = new Vector();

	StringTokenizer tok = new StringTokenizer(locations,",");

	while(tok.hasMoreTokens())
	{
	    String nextTok = tok.nextToken();
	    if(locs.contains(nextTok) == false)
	    {
		locs.add(nextTok);
	    }
	}

	retVal = (String[])locs.toArray(retVal);

	return retVal;
    }

    public static void main(String args[])
    {
	Config cfg = new Config();
	LocationList ll = new LocationList(cfg);

	for(int i=0;i<args.length;i++)
	{
	    cfg.setLocationCode(args[i]);

	    System.out.println("For Location:  " + args[i]);
	    System.out.println("---------------------------");

	    String llist[] = ll.getLocationList();

	    for(int j=0;j<llist.length;j++)
	    {
		System.out.println(j + ":  " + llist[j]);
	    }

	    System.out.println("---------------------------");
	}
    }
}
