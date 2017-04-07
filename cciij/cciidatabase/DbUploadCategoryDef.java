// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbUploadCategoryDef.java

package cciij.cciidatabase;

import cciij.cciidata.UploadCategoryDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbUploadCategoryDef extends DbBase
{

    public DbUploadCategoryDef()
    {
        selectAllUploadCategoryDefStmt = null;
        selectUploadCategoryDefByLocStmt = null;
        selectUploadCategoryDefStmt = null;
        saveUploadCategoryDefStmt = null;
        updateUploadCategoryDefStmt = null;
        deleteUploadCategoryDefStmt = null;
    }

    public UploadCategoryDef fetchNext()
        throws SQLException
    {
        UploadCategoryDef uploadCategoryDef = new UploadCategoryDef();
        if(m_hasMore)
        {
            uploadCategoryDef.setLocationCode(m_resultSet.getString("LOCATION_CD"));
            uploadCategoryDef.setUploadCategoryCode(m_resultSet.getString("UPLOAD_CATEGORY_CD"));
            uploadCategoryDef.setEncodeFormatTypeCode(m_resultSet.getString("ENCODE_FORMAT_TYPE_CD"));
            uploadCategoryDef.setQueueContainerName(m_resultSet.getString("QUEUE_CONTAINER_NM"));
            uploadCategoryDef.setQueueName(m_resultSet.getString("QUEUE_NM"));
            uploadCategoryDef.setClassName(m_resultSet.getString("CLASS_NM"));
            uploadCategoryDef.setReturnQueueContainerName(m_resultSet.getString("RETURN_QUEUE_CONTAINER_NM"));
            uploadCategoryDef.setReturnQueueName(m_resultSet.getString("RETURN_QUEUE_NM"));
            try
            {
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            }
            catch(SQLException e)
            {
                printSQLException(e, getClass().getName(), "fetchNext", "", "");
                throw e;
            }
        } else
        {
            uploadCategoryDef = null;
            m_recordCount = 0;
        }
        return uploadCategoryDef;
    }

    public UploadCategoryDef fetchUploadCategoryDefs(Connection conn, String locationCd, String uploadCategoryCd)
        throws SQLException
    {
        try
        {
            selectUploadCategoryDefByLocStmt = conn.prepareStatement("SELECT ENCODE_FORMAT_TYPE_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ");
            selectUploadCategoryDefByLocStmt.setString(1, locationCd);
            selectUploadCategoryDefByLocStmt.setString(2, uploadCategoryCd);
            runQuery(selectUploadCategoryDefByLocStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchUploadCategoryDefs", "SELECT ENCODE_FORMAT_TYPE_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ", locationCd + ", " + uploadCategoryCd);
            throw e;
        }
        return fetchNext();
    }

    public UploadCategoryDef fetchAllUploadCategoryDef(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllUploadCategoryDefStmt = conn.prepareStatement("SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ");
            runQuery(selectAllUploadCategoryDefStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAllUploadCategoryDef", "SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ", "");
            throw e;
        }
        return fetchNext();
    }

    public UploadCategoryDef fetchUploadCategoryDef(Connection conn)
        throws SQLException
    {
        try
        {
            selectUploadCategoryDefStmt = conn.prepareStatement("SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ORDER BY LOCATION_CD, UPLOAD_CATEGORY_CD ");
            runQuery(selectUploadCategoryDefStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchUploadCategoryDef", "SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ORDER BY LOCATION_CD, UPLOAD_CATEGORY_CD ", "");
            throw e;
        }
        return fetchNext();
    }

    public void saveUploadCategoryDef(Connection conn, UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        try
        {
            saveUploadCategoryDefStmt = conn.prepareStatement("INSERT INTO UPLOAD_CATEGORY_DEF ( LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM )  VALUES( ?,?,?,?,?,?,?,? )");
            saveUploadCategoryDefStmt.setString(1, uploadCategoryDef.getLocationCode());
            saveUploadCategoryDefStmt.setString(2, uploadCategoryDef.getUploadCategoryCode());
            saveUploadCategoryDefStmt.setString(3, uploadCategoryDef.getEncodeFormatTypeCode());
            saveUploadCategoryDefStmt.setString(4, uploadCategoryDef.getQueueContainerName());
            saveUploadCategoryDefStmt.setString(5, uploadCategoryDef.getQueueName());
            saveUploadCategoryDefStmt.setString(6, uploadCategoryDef.getClassName());
            saveUploadCategoryDefStmt.setString(7, uploadCategoryDef.getReturnQueueContainerName());
            saveUploadCategoryDefStmt.setString(8, uploadCategoryDef.getReturnQueueName());
            saveUploadCategoryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "saveUploadCategoryDef", "INSERT INTO UPLOAD_CATEGORY_DEF ( LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM )  VALUES( ?,?,?,?,?,?,?,? )", uploadCategoryDef.getLocationCode() + ", " + uploadCategoryDef.getUploadCategoryCode() + ", " + uploadCategoryDef.getEncodeFormatTypeCode() + ", " + uploadCategoryDef.getQueueContainerName() + ", " + uploadCategoryDef.getQueueName() + ", " + uploadCategoryDef.getClassName() + ", " + uploadCategoryDef.getReturnQueueContainerName() + ", " + uploadCategoryDef.getReturnQueueName());
            throw e;
        }
    }

    public void updateUploadCategoryDef(Connection conn, UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        try
        {
            updateUploadCategoryDefStmt = conn.prepareStatement("UPDATE UPLOAD_CATEGORY_DEF SET ENCODE_FORMAT_TYPE_CD = ?, QUEUE_CONTAINER_NM = ?, QUEUE_NM = ?, CLASS_NM = ?, RETURN_QUEUE_CONTAINER_NM = ?, RETURN_QUEUE_NM = ? WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ");
            updateUploadCategoryDefStmt.setString(1, uploadCategoryDef.getEncodeFormatTypeCode());
            updateUploadCategoryDefStmt.setString(2, uploadCategoryDef.getQueueContainerName());
            updateUploadCategoryDefStmt.setString(3, uploadCategoryDef.getQueueName());
            updateUploadCategoryDefStmt.setString(4, uploadCategoryDef.getClassName());
            updateUploadCategoryDefStmt.setString(5, uploadCategoryDef.getReturnQueueContainerName());
            updateUploadCategoryDefStmt.setString(6, uploadCategoryDef.getReturnQueueName());
            updateUploadCategoryDefStmt.setString(7, uploadCategoryDef.getLocationCode());
            updateUploadCategoryDefStmt.setString(8, uploadCategoryDef.getUploadCategoryCode());
            updateUploadCategoryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "updateUploadCategoryDef", "UPDATE UPLOAD_CATEGORY_DEF SET ENCODE_FORMAT_TYPE_CD = ?, QUEUE_CONTAINER_NM = ?, QUEUE_NM = ?, CLASS_NM = ?, RETURN_QUEUE_CONTAINER_NM = ?, RETURN_QUEUE_NM = ? WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ", uploadCategoryDef.getEncodeFormatTypeCode() + ", " + uploadCategoryDef.getQueueContainerName() + ", " + uploadCategoryDef.getQueueName() + ", " + uploadCategoryDef.getClassName() + ", " + uploadCategoryDef.getReturnQueueContainerName() + ", " + uploadCategoryDef.getReturnQueueName() + ", " + uploadCategoryDef.getLocationCode() + ", " + uploadCategoryDef.getUploadCategoryCode());
            throw e;
        }
    }

    public void deleteUploadCategoryDef(Connection conn, UploadCategoryDef uploadCategoryDef)
        throws SQLException
    {
        try
        {
            deleteUploadCategoryDefStmt = conn.prepareStatement("DELETE FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ");
            deleteUploadCategoryDefStmt.setString(1, uploadCategoryDef.getLocationCode());
            deleteUploadCategoryDefStmt.setString(2, uploadCategoryDef.getUploadCategoryCode());
            deleteUploadCategoryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "deleteUploadCategoryDef", "DELETE FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ", uploadCategoryDef.getLocationCode() + ", " + uploadCategoryDef.getUploadCategoryCode());
            throw e;
        }
    }

    public int getUploadCategoryDefRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbUploadCategoryDef dbUploadCategoryDef = new DbUploadCategoryDef();
        dbUploadCategoryDef.testDbUploadCategoryDef(db);
        db.closeConnection();
    }

    private void testDbUploadCategoryDef(DatabaseBean db)
    {
        UploadCategoryDef uploadCategoryDef = null;
        try
        {
            System.out.println("============Executing INSERT LOC4, SCAN_DEF, SC1, YY, XX, YY, YY, XX");
            db.saveUploadCategoryDef(new UploadCategoryDef("LOC4", "SCAN_DEF", "SC1", "YY", "XX", "YY", "YY", "XX"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting uploadCategoryDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_DEF ");
            uploadCategoryDef = db.fetchUploadCategoryDefs("SC1", "YY");
            if(uploadCategoryDef != null)
                System.out.println(uploadCategoryDef);
            else
                System.out.println("UploadCategoryDef not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE LOCATION_CD LOC4");
            db.updateUploadCategoryDef(new UploadCategoryDef("LOC4", "SCAN_DEF", "SC1", "YY", "XX", "YY", "YY", "XX"));
            if(uploadCategoryDef != null)
                System.out.println(uploadCategoryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATION_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT *");
            if((uploadCategoryDef = db.fetchAllUploadCategoryDef()) != null)
                System.out.println(uploadCategoryDef);
            while((uploadCategoryDef = db.fetchNextUploadCategoryDef()) != null) 
                System.out.println(uploadCategoryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all uploadCategoryDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_DEF ");
            uploadCategoryDef = db.fetchUploadCategoryDefs("SC1", "YY");
            if(uploadCategoryDef != null)
                System.out.println(uploadCategoryDef);
            else
                System.out.println("UploadCategoryDef not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting uploadCategoryDef by scantype, etc.. " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE LOC4, SCAN_DEF, WH1, YY, 1 ");
            db.removeUploadCategoryDef(new UploadCategoryDef("LOC4", "SCAN_DEF", "SC1", "YY", "XX", "YY", "YY", "XX"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting UploadCategoryDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_DEF ");
            uploadCategoryDef = db.fetchUploadCategoryDefs("SC1", "YY");
            if(uploadCategoryDef != null)
                System.out.println(uploadCategoryDef);
            else
                System.out.println("UploadCategoryDef not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Upload Category def " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbUploadCategoryDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private final String tableName = "UPLOAD_CATEGORY_DEF ";
    private final String selectAllUploadCategoryDefSQL = "SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ";
    private final String selectUploadCategoryDefByLocSQL = "SELECT ENCODE_FORMAT_TYPE_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ";
    private final String selectUploadCategoryDefSQL = "SELECT LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM FROM UPLOAD_CATEGORY_DEF ORDER BY LOCATION_CD, UPLOAD_CATEGORY_CD ";
    private final String saveUploadCategoryDefSQL = "INSERT INTO UPLOAD_CATEGORY_DEF ( LOCATION_CD, UPLOAD_CATEGORY_CD, ENCODE_FORMAT_TYPE_CD, QUEUE_CONTAINER_NM, QUEUE_NM, CLASS_NM, RETURN_QUEUE_CONTAINER_NM, RETURN_QUEUE_NM )  VALUES( ?,?,?,?,?,?,?,? )";
    private final String updateUploadCategoryDefSQL = "UPDATE UPLOAD_CATEGORY_DEF SET ENCODE_FORMAT_TYPE_CD = ?, QUEUE_CONTAINER_NM = ?, QUEUE_NM = ?, CLASS_NM = ?, RETURN_QUEUE_CONTAINER_NM = ?, RETURN_QUEUE_NM = ? WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ";
    private final String deleteUploadCategoryDefSQL = "DELETE FROM UPLOAD_CATEGORY_DEF WHERE LOCATION_CD = ? AND UPLOAD_CATEGORY_CD = ? ";
    private PreparedStatement selectAllUploadCategoryDefStmt;
    private PreparedStatement selectUploadCategoryDefByLocStmt;
    private PreparedStatement selectUploadCategoryDefStmt;
    private PreparedStatement saveUploadCategoryDefStmt;
    private PreparedStatement updateUploadCategoryDefStmt;
    private PreparedStatement deleteUploadCategoryDefStmt;
}
