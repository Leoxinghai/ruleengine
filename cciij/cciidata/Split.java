package cciij.cciidata;

/**
 * Title:        Split
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Gary Rockwood
 * @version 1.0
 */

import java.util.*; 

public class Split
{
   private static final String m_whatVersion = "@(#) $RCSfile: Split.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd = "";
   private int    m_splitNbr = 0;
   private byte[] m_splitValue = new byte[200];
   private String m_splitDesc = "";
   private String m_splitVersionNbr = "";
   private String m_recordActiveFlg = "";
   private Date   m_updateDt = new Date(0);
   private String m_updateEmployeeNbr = "";

   /**
    * Public default constructor
    */
   public Split()
   {
   }

   /**
    * Public constructor
    * @param locationCd
    * @param splitNbr
    * @param splitValue
    * @param splitDesc
    * @param splitVersionNbr
    * @param recordActiveFlg
    * @param updateDt
    * @param updateEmployeeNbr
    */
   public Split( String locationCd,
                 int splitNbr,
                 byte[] splitValue,
                 String splitDesc,
                 String splitVersionNbr,
                 String recordActiveFlg,
                 Date   updateDt,
                 String updateEmployeeNbr )
   {
      setLocationCd(locationCd);
      setSplitNbr(splitNbr);
      setSplitValue(splitValue);
      setSplitDesc(splitDesc);
      setSplitVersionNbr(splitVersionNbr);
      setRecordActiveFlg(recordActiveFlg);
      setUpdateDt(updateDt);
      setUpdateEmployeeNbr(updateEmployeeNbr);
   }

    /**
     * getLocationCd
     * @return String
     */
    public String getLocationCd() {
        return m_locationCd;
    }

   /**
    * getSplitNbr
    * @return int
    */
   public int getSplitNbr()
   {
      return m_splitNbr;
   }

   /**
    * getSplitValue
    * @return byte[]
    */
   public byte[] getSplitValue()
   {
      return m_splitValue;
   }

   /**
    * getSplitDesc
    * @return String
    */
   public String getSplitDesc()
   {
      return m_splitDesc;
   }

   /**
    * getSplitVersionNbr
    * @return String
    */
   public String getSplitVersionNbr()
   {
      return m_splitVersionNbr;
   }

   /**
    * getRecordActiveFlg
    * @return String
    */
   public String getRecordActiveFlg()
   {
      return m_recordActiveFlg;
   }

   /**
    * getUpdateDt
    * @return Date
    */
   public Date getUpdateDt()
   {
      return m_updateDt;
   }

   /**
    * getUpdateiEmployeeNbr
    * @return String
    */
   public String getUpdateEmployeeNbr()
   {
      return m_updateEmployeeNbr;
   }

   /**
     * setLocationCd
     * @param String locationCd
     */
   public void setLocationCd(String locationCd) 
   {
       if( locationCd != null )
       {
           m_locationCd = locationCd;
       }
       else
       {
           m_locationCd = "";
       }
   }

   /**
    * setSplitNbr
    * @param int splitNbr
    */
   public void setSplitNbr( int splitNbr )
   {
      m_splitNbr = splitNbr;
   }

   /**
    * setSplitValue
    * @param byte[] splitValue
    */
   public void setSplitValue( byte[] splitValue )
   {
      m_splitValue = splitValue;
   }

   /**
    * setSplitDesc
    * @param String splitDesc
    */
   public void setSplitDesc( String splitDesc )
   {
       if( splitDesc != null )
       {
           m_splitDesc = splitDesc;
       }
       else
       {
           m_splitDesc = "";
       }
   }

   /**
    * setSplitVersionNbr
    * @param String splitVersionNbr
    */
   public void setSplitVersionNbr( String splitVersionNbr )
   {
       if( splitVersionNbr != null )
       {
           m_splitVersionNbr = splitVersionNbr;
       }
       else
       {
           m_splitVersionNbr = "0403";
       }
   }

   /** setRecordActiveFlg
    *  @param String recordActiveFlg
    */
   public void setRecordActiveFlg( String recordActiveFlg )
   {
       if( recordActiveFlg != null )
       {
           m_recordActiveFlg = recordActiveFlg;
       }
       else
       {
           m_recordActiveFlg = "Y";
       }
   }

   /** setUpdateDt
    *  @param Date updateDt
    */
   public void setUpdateDt( Date updateDt )
   {
      m_updateDt = updateDt;
   }

   /** setUpdateEmployeeNbr
    *  @param String updateEmployeeNbr
    */
   public void setUpdateEmployeeNbr( String updateEmployeeNbr )
   {
       if( updateEmployeeNbr != null )
       {
           m_updateEmployeeNbr = updateEmployeeNbr;
       }
       else
       {
           m_updateEmployeeNbr = "";
       }
   }

   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("Split object -- \n");
      sb.append("LOCATION_CD        : " + m_locationCd + "\n" );
      sb.append("SPLIT_NBR          : " + m_splitNbr + "\n" );
      sb.append("SPLIT_VALUE        : SplitValue is Binary date \n" );
      sb.append("SPLIT_DESC         : " + m_splitDesc + "\n" );
      sb.append("SPLIT_VERSION_NBR  : " + m_splitVersionNbr + "\n" );
      sb.append("RECORD_ACTIVE_FLG  : " + m_recordActiveFlg + "\n" );
      sb.append("UPDATE_DT          : " + m_updateDt + "\n" );
      sb.append("UPDATE_EMPLOYEE_NBR: " + m_updateEmployeeNbr + "\n" );
      return sb.toString();
   }

}
