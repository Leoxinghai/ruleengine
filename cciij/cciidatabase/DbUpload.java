// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbUpload.java

package cciij.cciidatabase;

import cciij.cciidata.Upload;
import cciij.cciidata.UploadKey;
import java.io.PrintStream;
import java.sql.*;
import java.util.Vector;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbUpload extends DbBase
{

    public DbUpload()
    {
        selectAllUploadStmt = null;
        selectByUploadKeyStmt = null;
        saveUploadStmt = null;
        updateUploadStmt = null;
        deleteUploadStmt = null;
    }

    public Upload fetchNext()
        throws SQLException
    {
        Upload upload = new Upload();
        if(m_hasMore)
        {
            upload.setLocationCode(m_resultSet.getString("LOCATION_CD"));
            upload.setEventName(m_resultSet.getString("EVENT_NM"));
            upload.setEventValueCode(m_resultSet.getString("EVENT_VALUE_CD"));
            upload.setEventDetailCode(m_resultSet.getString("EVENT_DETAIL_CD"));
            upload.setUploadSeqNumber(m_resultSet.getInt("UPLOAD_SEQ_NBR"));
            upload.setClassIdCode(m_resultSet.getInt("CLASS_ID_CD"));
            upload.setFieldIdCode(m_resultSet.getInt("FIELD_ID_CD"));
            upload.setUploadCategoryCode(m_resultSet.getString("UPLOAD_CATEGORY_CD"));
            upload.setCosmosLocCode(m_resultSet.getString("COSMOS_LOC_CD"));
            upload.setUploadCode(m_resultSet.getString("UPLOAD_CD"));
            upload.setUploadTemplateDescription(m_resultSet.getString("UPLOAD_TEMPLATE_DESC"));
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
            upload = null;
            m_recordCount = 0;
        }
        return upload;
    }

    public Upload fetchAllUpload(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllUploadStmt = conn.prepareStatement("SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD ");
            runQuery(selectAllUploadStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAllUpload", "SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD ", "");
            throw e;
        }
        return fetchNext();
    }

    public Upload fetchUpload(Connection conn, String locationCd, Vector uploadKeyVector)
        throws SQLException
    {
        String uploadKeyString = null;
        UploadKey uploadKey = null;
        String uploadKeyListInSQL = "";
        for(int i = 0; i < uploadKeyVector.size(); i++)
        {
            if(i > 0)
                uploadKeyListInSQL = uploadKeyListInSQL + ",";
            uploadKeyListInSQL = uploadKeyListInSQL + "(?, ?, ?)";
        }

        String selectString = "SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD  WHERE LOCATION_CD = ?   AND (EVENT_NM,  EVENT_VALUE_CD, EVENT_DETAIL_CD) IN (" + uploadKeyListInSQL + ")" + " ORDER BY UPLOAD_SEQ_NBR";
        try
        {
            selectByUploadKeyStmt = conn.prepareStatement(selectString);
            selectByUploadKeyStmt.setString(1, locationCd);
            int index = 2;
            for(int i = 0; i < uploadKeyVector.size(); i++)
            {
                uploadKey = (UploadKey)uploadKeyVector.elementAt(i);
                uploadKeyString = uploadKeyString + uploadKey.getEventName() + " " + uploadKey.getEventValueCode() + " " + uploadKey.getEventDetailCode();
                selectByUploadKeyStmt.setString(index, uploadKey.getEventName());
                selectByUploadKeyStmt.setString(index + 1, uploadKey.getEventValueCode());
                selectByUploadKeyStmt.setString(index + 2, uploadKey.getEventDetailCode());
                index += 3;
            }

            runQuery(selectByUploadKeyStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchUpload", "SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD  WHERE LOCATION_CD = ?   AND (EVENT_NM,  EVENT_VALUE_CD, EVENT_DETAIL_CD) ", locationCd + ", " + uploadKeyString);
            throw e;
        }
        return fetchNext();
    }

    public void saveUpload(Connection conn, Upload upload)
        throws SQLException
    {
        try
        {
            saveUploadStmt = conn.prepareStatement("INSERT INTO UPLOAD ( LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC )  VALUES( ?,?,?,?,?,?,?,?,?,?,? )");
            saveUploadStmt.setString(1, upload.getLocationCode());
            saveUploadStmt.setString(2, upload.getEventName());
            saveUploadStmt.setString(3, upload.getEventValueCode());
            saveUploadStmt.setString(4, upload.getEventDetailCode());
            saveUploadStmt.setInt(5, upload.getUploadSeqNumber());
            saveUploadStmt.setInt(6, upload.getClassIdCode());
            saveUploadStmt.setInt(7, upload.getFieldIdCode());
            saveUploadStmt.setString(8, upload.getUploadCategoryCode());
            saveUploadStmt.setString(9, upload.getCosmosLocCode());
            saveUploadStmt.setString(10, upload.getUploadCode());
            saveUploadStmt.setString(11, upload.getUploadTemplateDescription());
            saveUploadStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "saveUpload", "INSERT INTO UPLOAD ( LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC )  VALUES( ?,?,?,?,?,?,?,?,?,?,? )", upload.getLocationCode() + ", " + upload.getEventName() + ", " + upload.getEventValueCode() + ", " + upload.getEventDetailCode() + ", " + upload.getUploadSeqNumber() + ", " + upload.getClassIdCode() + ", " + upload.getFieldIdCode() + ", " + upload.getUploadCategoryCode() + ", " + upload.getCosmosLocCode() + ", " + upload.getUploadCode() + ", " + upload.getUploadTemplateDescription());
            throw e;
        }
    }

    public void updateUpload(Connection conn, Upload upload)
        throws SQLException
    {
        try
        {
            updateUploadStmt = conn.prepareStatement("UPDATE UPLOAD SET CLASS_ID_CD = ?, FIELD_ID_CD = ?, UPLOAD_CATEGORY_CD = ?, COSMOS_LOC_CD = ?, UPLOAD_CD = ?, UPLOAD_TEMPLATE_DESC = ? WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ");
            updateUploadStmt.setInt(1, upload.getClassIdCode());
            updateUploadStmt.setInt(2, upload.getFieldIdCode());
            updateUploadStmt.setString(3, upload.getUploadCategoryCode());
            updateUploadStmt.setString(4, upload.getCosmosLocCode());
            updateUploadStmt.setString(5, upload.getUploadCode());
            updateUploadStmt.setString(6, upload.getUploadTemplateDescription());
            updateUploadStmt.setString(7, upload.getLocationCode());
            updateUploadStmt.setString(8, upload.getEventName());
            updateUploadStmt.setString(9, upload.getEventValueCode());
            updateUploadStmt.setString(10, upload.getEventDetailCode());
            updateUploadStmt.setInt(11, upload.getUploadSeqNumber());
            updateUploadStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "updateUpload", "UPDATE UPLOAD SET CLASS_ID_CD = ?, FIELD_ID_CD = ?, UPLOAD_CATEGORY_CD = ?, COSMOS_LOC_CD = ?, UPLOAD_CD = ?, UPLOAD_TEMPLATE_DESC = ? WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ", upload.getClassIdCode() + ", " + upload.getFieldIdCode() + ", " + upload.getUploadCategoryCode() + ", " + upload.getCosmosLocCode() + ", " + upload.getUploadCode() + ", " + upload.getUploadTemplateDescription() + ", " + upload.getLocationCode() + ", " + upload.getEventName() + ", " + upload.getEventValueCode() + ", " + upload.getEventDetailCode() + ", " + upload.getUploadSeqNumber());
            throw e;
        }
    }

    public void deleteUpload(Connection conn, Upload upload)
        throws SQLException
    {
        try
        {
            deleteUploadStmt = conn.prepareStatement("DELETE FROM UPLOAD WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ");
            deleteUploadStmt.setString(1, upload.getLocationCode());
            deleteUploadStmt.setString(2, upload.getEventName());
            deleteUploadStmt.setString(3, upload.getEventValueCode());
            deleteUploadStmt.setString(4, upload.getEventDetailCode());
            deleteUploadStmt.setInt(5, upload.getUploadSeqNumber());
            deleteUploadStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "deleteUpload", "DELETE FROM UPLOAD WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ", upload.getLocationCode() + ", " + upload.getEventName() + ", " + upload.getEventValueCode() + ", " + upload.getEventDetailCode() + ", " + upload.getUploadSeqNumber());
            throw e;
        }
    }

    public int getUploadRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("LOC4");
        db.connect();
        DbUpload dbUpload = new DbUpload();
        dbUpload.testDbUpload(db);
        db.closeConnection();
    }

    private void testDbUpload(DatabaseBean db)
    {
        Upload upload = null;
        UploadKey uploadKey = null;
        try
        {
            System.out.println("============Executing INSERT LOC4, SCAN_DEF, SC1, YY, 1 ");
            db.saveUpload(new Upload("LOC4", "SCAN_DEF", "SC1", "YY", 1, 2, 3, "XX", "LOC4", "YY", "TEMPDESC1"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting upload " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4");
            Vector uploadKeyVector = null;
            uploadKeyVector.add(new UploadKey("LOC4", "SCAN_DEF", "SC1", "YY"));
            upload = db.fetchUpload(uploadKeyVector);
            if(upload != null)
                System.out.println(upload);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATIONCD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE LOCATION_CD LOC4");
            db.updateUpload(new Upload("LOC4", "SCAN_DEF", "SC1", "YY", 1, 2, 3, "XX", "LOC4", "YY", "TEMPDESC222"));
            if(upload != null)
                System.out.println(upload);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by LOCATION_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT *");
            if((upload = db.fetchAllUpload()) != null)
                System.out.println(upload);
            while((upload = db.fetchNextUpload()) != null) 
                System.out.println(upload);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all upload " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_DEF, SC1, YY ");
            Vector uploadKeyVector = null;
            uploadKeyVector.add(new UploadKey("LOC4", "SCAN_DEF", "SC1", "YY"));
            upload = db.fetchUpload(uploadKeyVector);
            if(upload != null)
                System.out.println(upload);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting upload by scantype, etc.. " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE LOC4, SCAN_DEF, WH1, YY, 1 ");
            db.removeUpload(new Upload("LOC4", "SCAN_DEF", "SC1", "YY", 1, 2, 3, "XX", "LOC4", "YY", "TEMPDESC222"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting Upload " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY LOCATION_CD LOC4, SCAN_DEF, SC1, YY ");
            Vector uploadKeyVector = null;
            uploadKeyVector.add(new UploadKey("LOC4", "SCAN_DEF", "SC1", "YY"));
            upload = db.fetchUpload(uploadKeyVector);
            if(upload != null)
                System.out.println(upload);
            else
                System.out.println("UploadKey not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Upload " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbUpload.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private final String tableName = "UPLOAD ";
    private final String selectAllUploadSQL = "SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD ";
    private final String selectByUploadKeySQL = "SELECT LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC FROM UPLOAD  WHERE LOCATION_CD = ?   AND (EVENT_NM,  EVENT_VALUE_CD, EVENT_DETAIL_CD) ";
    private final String orderBySQL = " ORDER BY UPLOAD_SEQ_NBR";
    private final String saveUploadSQL = "INSERT INTO UPLOAD ( LOCATION_CD, EVENT_NM, EVENT_VALUE_CD, EVENT_DETAIL_CD, UPLOAD_SEQ_NBR, CLASS_ID_CD, FIELD_ID_CD, UPLOAD_CATEGORY_CD, COSMOS_LOC_CD, UPLOAD_CD, UPLOAD_TEMPLATE_DESC )  VALUES( ?,?,?,?,?,?,?,?,?,?,? )";
    private final String updateUploadSQL = "UPDATE UPLOAD SET CLASS_ID_CD = ?, FIELD_ID_CD = ?, UPLOAD_CATEGORY_CD = ?, COSMOS_LOC_CD = ?, UPLOAD_CD = ?, UPLOAD_TEMPLATE_DESC = ? WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ";
    private final String deleteUploadSQL = "DELETE FROM UPLOAD WHERE LOCATION_CD = ? AND EVENT_NM = ? AND EVENT_VALUE_CD = ? AND EVENT_DETAIL_CD = ? AND UPLOAD_SEQ_NBR = ? ";
    private PreparedStatement selectAllUploadStmt;
    private PreparedStatement selectByUploadKeyStmt;
    private PreparedStatement saveUploadStmt;
    private PreparedStatement updateUploadStmt;
    private PreparedStatement deleteUploadStmt;
}
