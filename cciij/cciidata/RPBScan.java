package cciij.cciidata;

public class RPBScan extends RPBScanBase implements java.io.Serializable, Cloneable
{
    CCIIState m_state=null;

    public void setSysDateTime(java.util.Date setValue)
    {
	m_SysDateTime = setValue.getTime();
    

    }

    public void setState(CCIIState state)
    {
	m_state = state;
    }

    public void setErrorNumber(int errorNumber)
    {
	super.setErrorNumber(errorNumber);
	
	if((errorNumber > cciij.businessActions.Messages.START_OF_ERROR_MSGS)
	   && (m_state != null))
	{
	    m_state.setAbortFlag(true);
	}
    }

    /**
     * getSysDateTimeNoMillSeconds
     * @return long
     */
    public long getSysDateTimeNoMilliSeconds() {
	// in order to make comparisons to a long value
	//  returned from the database (which loses percision) the milliseconds need to be
	//  zeroed out.
	return (getSysDateTime()/1000)*1000;
    }

}
