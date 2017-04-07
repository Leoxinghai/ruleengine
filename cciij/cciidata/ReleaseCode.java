package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Lorraine Dominguez
 * @version 1.0
 */

 import java.util.*;
 import cciij.businessActions.*;
 import java.io.Serializable;

public class ReleaseCode implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: ReleaseCode.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private int m_releaseCodeOidNumber;
  private int m_shipmentOidNumber;
  private String m_releaseCode = "";
  private String m_activeInactiveFlag = "";
  private Date m_createDate = new Date(0);
  private String m_createEmployeeNumber = "";
  private String m_createProcessName = "";
  private Date m_dateReleaseCodeUpdated = new Date(0);
  private String m_updateEmployeeNumber = "";
  private String m_updateProcessName = "";
  private String m_uploadedFlag = "";
  private int m_pieceOidNumber;
  private String m_locationCd = "";


  public ReleaseCode()
  {
  }

  public ReleaseCode(int releaseCodeOidNumber,
		     int shipmentOidNumber,
		     String releaseCode,
		     String activeInactiveFlag,
                     Date createDate,
                     String createEmployeeNumber,
		     String createProcessName,
		     Date dateReleaseCodeUpdated,
		     String updateEmployeeNumber,
		     String updateProcessName, 
		     String uploadedFlag,
		     int pieceOidNumber,
		     String locationCode)

  {
    setReleaseCode(releaseCode);
    m_releaseCodeOidNumber = releaseCodeOidNumber;
    m_shipmentOidNumber = shipmentOidNumber;
    m_pieceOidNumber = pieceOidNumber;
    setActiveInactiveFlag(activeInactiveFlag);
    m_createDate = createDate;
    setCreateEmployeeNumber(createEmployeeNumber);
    m_dateReleaseCodeUpdated = dateReleaseCodeUpdated;
    setEmployeeNumberForUpdate(updateEmployeeNumber);
    setCreateProcessName(createProcessName);
    setUpdatedProcessName(updateProcessName);
    setUploadFlag(uploadedFlag);
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

  public int getReleaseCodeOidNumber()
  {
    return m_releaseCodeOidNumber;
  }

  /**
   * getShipmentOidNumber
   * @return int
  */
  public int getShipmentOidNumber() 
  {
     return  m_shipmentOidNumber;
  }

  /**
   * getPieceOidNumber
   * @return int
  */
  public int getPieceOidNumber() 
  {
     return  m_pieceOidNumber;
  }

  /**
   * getActiveInactiveFlag
   * @return String
  */
  public String getActiveInactiveFlag() 
  {
     return  m_activeInactiveFlag;
  }

  /**
    * getCreateDate
    * @return Date
  */
  public Date getCreateDate() 
  {
     return m_createDate;
  }

  /**
    * getUpdateDate
    * @return Date
  */
  public Date getUpdateDate() 
  {
     return m_dateReleaseCodeUpdated;
  }


  /**
   * getCreateEmployeeNumber
   * @return String
  */
  public String getCreateEmployeeNumber() 
  {
     return  m_createEmployeeNumber;
  }
		
  /**
   * getDateReleaseCodeUpdated
   * @return Date
  */
  public Date getDateReleaseCodeUpdated() 
  {
     return m_dateReleaseCodeUpdated;
  }


  /**
   * getUpdateEmployeeNumber
   * @return String
  */
  public String getUpdateEmployeeNumber() 
  {
     return m_updateEmployeeNumber;
  }

  /**
   * getCreatedProcessName
   * @return String
  */
  public String getCreatedProcessName() 
  {
     return m_createProcessName;
  }

  /**
   * getUpdatedProcessName
   * @return String
  */
  public String getUpdatedProcessName() 
  {
     return m_updateProcessName;
  }

  /**
   * getUploadedFlag
   * @return String
  */
  public String getUploadedFlag() 
  {
     return m_uploadedFlag;
  }


  /**
   * getLocationCd
   * @return String
  */
  public String getLocationCd() 
  {
     return m_locationCd;
  }

  /**
   * setLocationCd
   * @param String
  */
  public void setLocationCd(String s) 
  {
     if(s == null)
     {
        m_locationCd = "";
     }
     else
     {
        m_locationCd = s;
     }
   }


   /**
    * setActiveInactiveFlag
    * @param boolean
   */
   public void setActiveInactiveFlag(boolean isActive) 
   {
      if(isActive == true)
      {
         m_activeInactiveFlag = "Y";
      }
      else
      {
         m_activeInactiveFlag = "N";
      }
   }


   /**
    * setUploadFlag
    * @param boolean
  */
  public void setUploadFlag(boolean isUploaded) 
  {
     if(isUploaded == true)
     {
        m_uploadedFlag = "Y";
     }
     else
     {
        m_uploadedFlag = "N";
     }
  }


  /**
   * setReleaseCodeOidNumber
   * @param int
  */
  public void setReleaseCodeOidNumber(int i)
  {
     if (m_releaseCodeOidNumber == 0)
     {
        m_releaseCodeOidNumber = i;
     }
  }

  /**
   * setReleaseCode
   * @param String
  */
  private void setReleaseCode(String s)
  {
     if(s == null)
     {
        m_releaseCode = "";
     }
     else
     {
        m_releaseCode = s;
     }
   }

   /**
    * setCreateEmployeeNumber
    * @param String
   */
   private void setCreateEmployeeNumber(String s)
   {
      if(s == null)
      {
         m_createEmployeeNumber = "";
      }
      else
      {
         m_createEmployeeNumber = s;
      }
   }


 /**
  * setCreateProcessName
  * @param String
 */
 private void setCreateProcessName(String s)
 {
    if(s == null)
    {
       m_createProcessName = "";
    }
    else
    {
       m_createProcessName = s;
    }
 }

 /**
  * setActiveInactiveFlag
  * @param String
 */
 private void setActiveInactiveFlag(String s)
 {
    if(s == null)
    {
       m_activeInactiveFlag = "";
    }
    else
    {
       m_activeInactiveFlag = s;
    }
 }

  /**
   * setUploadFlag
   * @param String
  */
  private void setUploadFlag(String s)
  {
     if(s == null)
     {
        m_uploadedFlag = "";
     }
     else
     {
        m_uploadedFlag = s;
     }
  }

  /**
   * setDateUpdated
   * @param Date
  */
  public void setDateUpdated(Date newDate) 
  {
     m_dateReleaseCodeUpdated = newDate;
  }

  /**
   * setEmployeeNumberForUpdate
   * @param String
  */
  public void setEmployeeNumberForUpdate(String s)
  {
     if(s == null)
     {
        m_updateEmployeeNumber = "";
     }
     else
     {
        m_updateEmployeeNumber = s;
     }
  }

  /**
   * setUpdatedProcessName
   * @param String
  */
  public void setUpdatedProcessName(String s)
  {
     if(s == null)
     {
        m_updateProcessName = "";
     }
     else
     {
        m_updateProcessName = s;
     }
   }


  /**
    * toString
    * @return String
    */
    public String toString()
   {
      String s = "";

         s += "ReleaseCode object -- " + "\n";
         s += "releaseCodeOidNumber   : " + m_releaseCodeOidNumber+ "\n";
	 s += "shipmentOidNumber      : " + m_shipmentOidNumber+ "\n";
         s += "releaseCode            : " + m_releaseCode+ "\n";
	 s += "activeInactiveFlag     : " + m_activeInactiveFlag+ "\n";
	 s += "createDate             : " + m_createDate+ "\n";
         s += "createEmployeeNumber   : " + m_createEmployeeNumber+ "\n";
         s += "createProcessName      : " + m_createProcessName+ "\n";
         s += "dateReleaseCodeUpdated : " + m_dateReleaseCodeUpdated+ "\n";
         s += "updateEmployeeNumber   : " + m_updateEmployeeNumber+ "\n";
         s += "updateProcessName      : " + m_updateProcessName+ "\n";
         s += "uploadedFlag           : " + m_uploadedFlag+ "\n";
	 s += "pieceOidNumber         : " + m_pieceOidNumber+ "\n";
         s += "locationCd             : " + m_locationCd + "\n";

      return s;
  }
}
