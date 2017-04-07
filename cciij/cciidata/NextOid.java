package cciij.cciidata;

/**
 * Title:        Intercept
 * Description:  Models a row in the NEXT_OID table
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author       Monica Marshall
 * @version      1.0
 */

import java.io.Serializable;
import java.util.Date;

public class NextOid implements Serializable
{
   //private static final String m_whatVersion = "@(#) $RCSfile: NextOid.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
   private static final String m_whatVersion = "@(#) $RCSfile: NextOid.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
   private  String m_tableName     = null;
   private  int    m_next_OidNumber = 0;

   /**
   * Default Constructor
   */
   public NextOid()
   {
   }

   /**
   * Public Constructor
   * @param String tableName
   * @param int nextOidNbr
   */
   public NextOid( String tableName, int oidNumber )
   {
      this.m_tableName = tableName;
      this.m_next_OidNumber = oidNumber;
   }

   /**
   * setTableName
   * @param String tableName
   */
   public void setTableName( String tableName )
   {
      this.m_tableName = tableName;
   }

   /**
   * setNextOidNumber
   * @param int oidNumber
   */
   public void setNextOidNumber( int oidNumber )
   {
     this.m_next_OidNumber = oidNumber;
   }

   /**
   * getTableName
   * @return String for TableName attribute
   */
   public String getTableName()
   {
      return this.m_tableName;
   }

   /**
   * getNextOidNumber
   * @return NextOidNumber attribute.
   */
   public int getNextOidNumber()
   {
      return this.m_next_OidNumber;
   }

   /**
   * toString
   * @Return String.
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("NEXT_OID object -- \n");
      sb.append("TABLE_NAME  : " + m_tableName + "\n" );
      sb.append("NEXT_OID_NBR: " + m_next_OidNumber + "\n" );
      return sb.toString();
   }
}
