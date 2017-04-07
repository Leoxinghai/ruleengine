package cciij.cciidata;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import cciij.cciidata.*;

public class CCIIState extends CCIIStateBase implements java.io.Serializable, Cloneable
{
    public Map m_printData;

    public Vector m_activityCodes = null;

    public CCIIState()
    {
	super();
	m_activityCodes = m_ActivityCodes;
	m_printData = m_PrintData = new TreeMap();
    }

    public void setAbortTransaction(boolean b) 
    {
	setAbortFlag(b);
    }

    public boolean getAbortTransaction()
    {
	return getAbortFlag();
    }

    public void addActivity(String activityCode) 
    {
	m_ActivityCodes.add(activityCode);
	m_ActivityCodes.add(null);
    }

    public void addActivity(String activityCode, Intercept i) 
    {
	m_ActivityCodes.add(activityCode);
	m_ActivityCodes.add(i);
    }

    public void addExceptionActivity(String activityCode) 
    {
	m_ExceptionActivityCodes.add(activityCode);
	m_ExceptionActivityCodes.add(null);
    }

    public void addExceptionActivity(String activityCode, Intercept i) 
    {
	m_ExceptionActivityCodes.add(activityCode);
	m_ExceptionActivityCodes.add(i);
    }

    public void addPrintMapElement(String key,String value)
    {
	m_PrintData.put(key,value);
    }

    public void setNullValue(String value)
    {
	throw new RuntimeException("Never attempt to set the NullValue in the state object, it is for use by the rules ONLY!!!");
    }

    public String getNullValue()
    {
	return "";
    }

    public void addCAGEReasonCode(cciij.cciidata.ReasonCode reasonCode) 
    {
	if (m_CAGEReasonCodes == null)
	{
  	    m_CAGEReasonCodes = new Vector();
	}
	m_CAGEReasonCodes.add(reasonCode);
    }

    public void addCAGEReleaseCode(cciij.cciidata.ReleaseCode releaseCode) 
    {
	if (m_CAGEReleaseCodes == null)
	{
	    m_CAGEReleaseCodes = new Vector();
	}
        m_CAGEReleaseCodes.add(releaseCode);
    }

    public void addHandlingInstruction(cciij.cciidata.HandlingInstructions handlingInstruction) 
    {
	if (m_HandlingInstructions == null)
	{
	    m_HandlingInstructions = new Vector();
	}
	m_HandlingInstructions.add(handlingInstruction);
    }

    public void addShipmentRemark(cciij.cciidata.ShipmentRemark shipmentRemark) 
    {
	if (m_ShipmentRemarks == null)
	{
	    m_ShipmentRemarks = new Vector();
	}
	m_ShipmentRemarks.add(shipmentRemark);
    }
    public void addUploadKey(cciij.cciidata.UploadKey uploadKey) 
    {
	if (m_UploadKey == null)
	{
  	    m_UploadKey = new Vector();
	}
	m_UploadKey.add(uploadKey);
    }
    public void addUploadKey(String locationCd, String linkedTableCd, 
				String keyValueCd,
				String subkeyValueCd) 
    {
	UploadKey uploadKey = new cciij.cciidata.UploadKey (
				   locationCd, linkedTableCd, 
				   keyValueCd, subkeyValueCd);
        addUploadKey(uploadKey);
    }

    public void addScan(cciij.cciidata.Scan scan) 
    {
	if (m_ScanVectorElement == null)
	{
  	    m_ScanVectorElement = new Vector();
	}
	m_ScanVectorElement.add(scan);
    }

    public void setScan(RPBScan scan)
    {
	scan.setState(this);

	super.setScan(scan);
    }

    public static void main(String args[])
    {
	if(args.length < 3)
	{
	    CCIIState state = new CCIIState();
	    System.out.println("Usage:  java " + state.getClass().getName() + " <classID> <fieldID> <value>");
	    System.exit(-1);
	}

	try
	{
	    int cls = Integer.parseInt(args[0]);
	    int fld = Integer.parseInt(args[1]);

	    CCIIState state = new CCIIState();

	    System.out.println("Default value of " + cls + ", " + fld + " is:  " + state.get(cls,fld));
	    state.set(cls,fld,args[2]);
	    System.out.println("After setting the value of " + cls + ", " + fld + " is:  " + state.get(cls,fld));


	}
	catch(Exception e)
	{
	    System.out.println("Caught an exception:  " + e);
	    e.printStackTrace(System.out);
	}
    }
}
