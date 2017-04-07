package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

 import java.util.*;
 import cciij.businessActions.*;
 import java.io.Serializable;

public class ReleaseCodeDef implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ReleaseCodeDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_releaseCode = "";
  private String m_releaseCodeDescription = "";
  private String m_closeCerFlag = "";
  private String m_postLocStatNumber = "";
  private String m_temporaryPermanentCode = "";
  private String m_recordActiveFlag = "";
  private String m_locationCd = "";


  public ReleaseCodeDef()
  {
  }

  public ReleaseCodeDef(String releaseCode,
                        String releaseCodeDescription,
                        String closeCerFlag,
                        String postLocStatNumber,
                        String temporaryPermanentCode,
                        String recordActiveFlag,
			String locationCode)
  {
    setReleaseCode(releaseCode);
    setReleaseCodeDescription(releaseCodeDescription);
    setCloseCerFlag(closeCerFlag);
    setPostLocStatNumber(postLocStatNumber);
    setTemporaryPermanentCode(temporaryPermanentCode);
    setRecordActiveFlag(recordActiveFlag);
    setLocationCd(locationCode);
  }

  /**
  * finalize
  */
  protected void finalize() {

  }

  public String getReleaseCode()
  {
    return m_releaseCode;
  }

  public String getReleaseCodeDescription()
  {
    return m_releaseCodeDescription;
  }

  public String getCloseCerFlag()
  {
    return m_closeCerFlag;
  }

  public String getPostLocStatNumber()
  {
    return m_postLocStatNumber;
  }

  public String getTemporaryPermanentCode()
  {
    return m_temporaryPermanentCode;
  }

  public String getRecordActiveFlag()
  {
    return m_recordActiveFlag;
  }

  public String getLocationCd()
  {
    return m_locationCd;
  }

  public void setLocationCd(String s)
  {
     if( s == null)
    {
      m_locationCd = "";
    }
    else
    {
      m_locationCd = s;
    }
  }

  private void setReleaseCode(String s)
  {
     if( s == null)
    {
      m_releaseCode = "";
    }
    else
    {
      m_releaseCode = s;
    }
  }

  private void setReleaseCodeDescription(String s)
  {
     if( s == null)
    {
      m_releaseCodeDescription = "";
    }
    else
    {
      m_releaseCodeDescription = s;
    }
  }

  private void setCloseCerFlag(String s)
  {
     if( s == null)
    {
      m_closeCerFlag = "";
    }
    else
    {
      m_closeCerFlag = s;
    }
  }

  public void setPostLocStatNumber(String s)
  {
     if( s == null)
    {
      m_postLocStatNumber = "";
    }
    else
    {
      m_postLocStatNumber = s;
    }
  }

  private void setTemporaryPermanentCode(String s)
  {
     if( s == null)
    {
      m_temporaryPermanentCode = "";
    }
    else
    {
      m_temporaryPermanentCode = s;
    }
  }

  public void setRecordActiveFlag(String s)
  {
     if( s == null)
    {
      m_recordActiveFlag = "";
    }
    else
    {
      m_recordActiveFlag = s;
    }
  }

  /**
    * toString
    * @return String
    */
    public String toString()
   {
      String s = "";

         s +=  "ReleaseCodeDef object -- " + "\n";

         s += "releaseCode            : " + m_releaseCode+ "\n";
         s += "releaseCodeDescription : " + m_releaseCodeDescription+ "\n";
         s += "closeCerFlag           : " + m_closeCerFlag+ "\n";
         s += "postLocStatNumber      : " + m_postLocStatNumber+ "\n";
         s += "temporaryPermanentCode : " + m_temporaryPermanentCode+ "\n";
         s += "recordActiveFlag       : " + m_recordActiveFlag+ "\n";
         s += "locationCd             : " + m_locationCd + "\n";

      return s;
  }
}
