package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Monica Marshall
 * @version 	 1.0
 *
 * 2/12/04  	Julie McCarthy
 * Changes made to split Upload into 2 classes:  UploadKey and Upload.  And to reflect
 * new column names in the UPLOAD table.
 */

public class Upload extends UploadKey
{
   private static final String m_whatVersion = "@(#) $RCSfile: Upload.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd         = "";
   private String m_eventNm            = "";
   private String m_eventValueCd       = "";
   private String m_eventDetailCd      = "";
   private int    m_uploadSeqNbr       = 0;
   private int    m_classIdCd          = 0;
   private int    m_fieldIdCd          = 0;
   private String m_uploadCategoryCd   = "";
   private String m_cosmosLocCd        = "";
   private String m_uploadCd           = "";
   private String m_uploadTemplateDesc = "";

   public Upload()
   {
   }

   /**
    * Public Constructor
    
    */
   public Upload(String locationCd, 
    	         String eventNm,
    		 String eventValueCd,
    		 String eventDetailCd,
    		 int    uploadSeqNbr)
   {
      super(locationCd, eventNm, 
      	    eventValueCd, eventDetailCd);
			 
      this.m_locationCd = locationCd;
      this.m_eventNm = eventNm;
      this.m_eventValueCd = eventValueCd;
      this.m_eventDetailCd = eventDetailCd;
      this.m_uploadSeqNbr = uploadSeqNbr;
   }

   /**
    * Public constructor
    * @param String locationCd
    * @param String eventNm
    * @param String eventValueCd
    * @param String eventDetailCd
    * @param int    uploadSeqNbr
    * @param int    classIdCd
    * @param int    fieldIdCd
    * @param String uploadCategoryCd
    * @param String cosmosLocCd
    * @param String uploadCd
    * @param String uploadTemplateDesc
    */
   public Upload( String locationCd, 
    		     String eventNm,
    		     String eventValueCd,
                     String eventDetailCd,
                     int    uploadSeqNbr,
   		     int    classIdCd,
                     int    fieldIdCd,
                     String uploadCategoryCd,
                     String cosmosLocCd,
                     String uploadCd,
                     String uploadTemplateDesc )
   {
      super(locationCd, eventNm, 
      	    eventValueCd, eventDetailCd);

      this.m_locationCd = locationCd;
      this.m_eventNm = eventNm;
      this.m_eventValueCd = eventValueCd;
      this.m_eventDetailCd = eventDetailCd;
      this.m_uploadSeqNbr = uploadSeqNbr;
      this.m_classIdCd = classIdCd;
      this.m_fieldIdCd = fieldIdCd;
      this.m_uploadCategoryCd = uploadCategoryCd;
      this.m_cosmosLocCd = cosmosLocCd;
      this.m_uploadCd = uploadCd;
      this.m_uploadTemplateDesc = uploadTemplateDesc;
   }

/**
    * getUploadSeqNumber
    * @return int
    */
   public int getUploadSeqNumber()
   {
      return this.m_uploadSeqNbr;
   }

 /**
    * getUploadCategoryCode
    * @return String
    */
   public String getUploadCategoryCode()
   {
      return this.m_uploadCategoryCd;
   }

   /**
    * getClassIdCode
    * @return int
    */
   public int getClassIdCode()
   {
      return this.m_classIdCd;
   }

   /**
    * getFieldIdCode
    * @return int
    */
   public int getFieldIdCode()
   {
      return this.m_fieldIdCd;
   }


   /**
    * getCosmosLocCode
    * @return String
    */
   public String getCosmosLocCode()
   {
      return this.m_cosmosLocCd;
   }

 /**
    * getUploadCode
    * @return String
    */
   public String getUploadCode()
   {
      return this.m_uploadCd;
   }
   
    /**
    * getUploadTemplateDescription
    * @return String
    */
   public String getUploadTemplateDescription()
   {
      return this.m_uploadTemplateDesc;
   }
   
   /**
    * setUploadCategoryCode
    * @param string uploadCategoryCd
    */
   public void setUploadCategoryCode( String  uploadCategoryCd )
   {
      this.m_uploadCategoryCd = uploadCategoryCd;
   }

/**
    * setUploadSeqNumber
    * @param int uploadSeqNbr
    */
   public void setUploadSeqNumber( int uploadSeqNbr )
   {
      this.m_uploadSeqNbr = uploadSeqNbr;
   }

   /**
    * setClassIdCode
    * @param int classIdCd
    */
   public void setClassIdCode( int classIdCd )
   {
      this.m_classIdCd = classIdCd;
   }

   /**
    * setFieldIdCode
    * @param int fieldIdCd
    */
   public void setFieldIdCode( int fieldIdCd )
   {
      this.m_fieldIdCd = fieldIdCd;
   }
   
   /**
    * setCosmosLocCode
    * @param String cosmosLocCd
    */
   public void setCosmosLocCode( String cosmosLocCd )
   {
      m_cosmosLocCd = cosmosLocCd;
   } 

/**
    * setUploadCode
    * @param String uploadCd
    */
   public void setUploadCode( String uploadCd )
   {
      m_uploadCd = uploadCd;
   } 
   
   /**
    * setUploadTemplateDescription
    * @param String uploadTemplateDesc
    */
   public void setUploadTemplateDescription( String uploadTemplateDesc )
   {
      m_uploadTemplateDesc = uploadTemplateDesc;
   } 

    /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer(super.toString());
      sb.append("UPLOAD_ object -- \n");
      sb.append("UPLOAD_SEQ_NBR       : " + m_uploadSeqNbr + "\n" );
      sb.append("CLASS_ID_CD          : " + m_classIdCd + "\n" );
      sb.append("FIELD_ID_CD          : " + m_fieldIdCd + "\n" );
      sb.append("UPLOAD_CATEGORY_CD   : " + m_uploadCategoryCd + "\n" );
      sb.append("COSMOS_LOC_CD        : " + m_cosmosLocCd + "\n" );
      sb.append("UPLOAD_CD            : " + m_uploadCd + "\n" );
      sb.append("UPLOAD_TEMPLATE_DESC : " + m_uploadTemplateDesc + "\n" );
      return sb.toString();
   }
}
