package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Julie McCarthy
 * @version 	 1.0
 */
 
 public class UploadCategoryDef
{
   private static final String m_whatVersion = "@(#) $RCSfile: UploadCategoryDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

   private String m_locationCd             = "";
   private String m_uploadCategoryCd       = "";
   private String m_encodeFormatTypeCd     = "";
   private String m_queueContainerNm       = "";
   private String m_queueNm                = "";
   private String m_classNm                = "";
   private String m_returnQueueContainerNm = "";
   private String m_returnQueueNm          = "";
   
   public UploadCategoryDef()
   {
   }

   /**
    * Public Constructor
    * @param String locationCd
    * @param String uploadCategoryCd
    * @param String encodeFormatTypeCd
    * @param String queueContainerNm
    * @param String queueNm
    * @param String classNm
    * @param String returnQueueContainerNm
    * @param String returnQueueNm
   */
   public UploadCategoryDef(String locationCd,
   		    String uploadCategoryCd,
                    String encodeFormatTypeCd,
                    String queueContainerNm,
                    String queueNm,
                    String classNm,
                    String returnQueueContainerNm,
                    String returnQueueNm)
                    
   {
      this.m_locationCd = locationCd;
      this.m_uploadCategoryCd = uploadCategoryCd;
      this.m_encodeFormatTypeCd = encodeFormatTypeCd;
      this.m_queueContainerNm = queueContainerNm;
      this.m_queueNm = queueNm;
      this.m_classNm = classNm;
      this.m_returnQueueContainerNm = returnQueueContainerNm;
      this.m_returnQueueNm = returnQueueNm;
   }

    /**
    * getLocationCode
    * @return String
    */
   public String getLocationCode()
   {
      return this.m_locationCd;
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
    * getEncodeFormatTypeCode
    * @return String
    */
   public String getEncodeFormatTypeCode()
   {
      return this.m_encodeFormatTypeCd;
   }

   /**
    * getQueueContainerName
    * @return String
    */
   public String getQueueContainerName()
   {
      return this.m_queueContainerNm;
   }

 /**
    * getQueueName
    * @return String
    */
   public String getQueueName()
   {
      return this.m_queueNm;
   }
  
   /**
    * getClassName
    * @return String
    */
   public String getClassName()
   {
      return this.m_classNm;
   }
    /**
    
  /**
    * getReturnQueueContainerName
    * @return String
    */
   public String getReturnQueueContainerName()
   {
      return this.m_returnQueueContainerNm;
   }
    /**
    
   /**
    * getReturnQueueName
    * @return String
    */
   public String getReturnQueueName()
   {
      return this.m_returnQueueNm;
   }
  
  /** 
    * setLocationCode
    * @param String locationCd
    */
   public void setLocationCode( String locationCd )
   {
      this.m_locationCd = locationCd;
   }
 
   /**
    * setUploadCategoryCode
    * @param String uploadCategoryCd
    */
   public void setUploadCategoryCode( String uploadCategoryCd )
   {
      this.m_uploadCategoryCd = uploadCategoryCd;
   }

   /**
    * setEncodeFormatTypeCode
    * @param String encodeFormatTypeCd
    */
   public void setEncodeFormatTypeCode( String encodeFormatTypeCd )
   {
      this.m_encodeFormatTypeCd = encodeFormatTypeCd;
   }

   /**
    * setQueueContainerName
    * @param String queueContainerNm
    */
   public void setQueueContainerName( String queueContainerNm )
   {
      this.m_queueContainerNm = queueContainerNm;
   }
   
   /**
    * setQueueName
    * @param String queueNm
    */
   public void setQueueName( String queueNm )
   {
      this.m_queueNm = queueNm;
   }
   
   /**
    * setClassName
    * @param String classNm
    */
   public void setClassName( String classNm )
   {
      this.m_classNm = classNm;
   }
   
   /**
    * setReturnQueueContainerName
    * @param String returnQueueContainerNm
    */
   public void setReturnQueueContainerName( String returnQueueContainerNm )
   {
      this.m_returnQueueContainerNm = returnQueueContainerNm;
   }
   
   /**
    * setReturnQueueName
    * @param String returnQueueNm
    */
   public void setReturnQueueName( String returnQueueNm )
   {
      this.m_returnQueueNm = returnQueueNm;
   }
   
   
   /**
    * toString
    * @return String
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("UPLOAD_DEF object -- \n");
      sb.append("LOCATION_CD               : " + m_locationCd + "\n" );
      sb.append("UPLOAD_CATEGORY_CD        : " + m_uploadCategoryCd + "\n" );
      sb.append("ENCODE_FORMAT_TYPE_CD     : " + m_encodeFormatTypeCd + "\n" );
      sb.append("QUEUE_CONTAINER_NM        : " + m_queueContainerNm + "\n" );
      sb.append("QUEUE_NM                  : " + m_queueNm + "\n" );
      sb.append("CLASS_NM                  : " + m_classNm + "\n" );
      sb.append("RETURN_QUEUE_CONTAINER_NM : " + m_returnQueueContainerNm + "\n" );
      sb.append("RETURN_QUEUE_NM           : " + m_returnQueueNm + "\n" );
      return sb.toString();
   }
 }
