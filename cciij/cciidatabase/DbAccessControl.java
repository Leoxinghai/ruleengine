// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbAccessControl.java

package cciij.cciidatabase;

import cciij.cciidata.AccessControl;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase

public class DbAccessControl extends DbBase
{

    public DbAccessControl(Connection conn)
        throws SQLException
    {
        fetchAccessControlSQL = "SELECT AC_CODE, AC_DESCRIPTION FROM SECURITY.ACCESS_CONTROL WHERE AC_CODE = ?";
        saveAccessControlSQL = "INSERT INTO SECURITY.ACCESS_CONTROL (AC_CODE, AC_DESCRIPTION ) VALUES(?,?)";
        removeAccessControlSQL = "DELETE FROM SECURITY.ACCESS_CONTROL WHERE AC_CODE = ?";
        updateAccessControlSQL = "UPDATE SECURITY.ACCESS_CONTROL SET AC_DESCRIPTION = ? WHERE AC_CODE = ?";
        fetchAccessControlStmt = null;
        saveAccessControlStmt = null;
        removeAccessControlStmt = null;
        updateAccessControlStmt = null;
        try
        {
            fetchAccessControlStmt = conn.prepareStatement(fetchAccessControlSQL);
            saveAccessControlStmt = conn.prepareStatement(saveAccessControlSQL);
            removeAccessControlStmt = conn.prepareStatement(removeAccessControlSQL);
            updateAccessControlStmt = conn.prepareStatement(updateAccessControlSQL);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR in DbAccessControl Constructor: " + ex);
            throw ex;
        }
    }

    public int getAccessControlRecordCount()
    {
        return m_recordCount;
    }

    public AccessControl fetch(String accessCd)
        throws SQLException
    {
        try
        {
            fetchAccessControlStmt.setString(1, accessCd);
            runQuery(fetchAccessControlStmt);
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbAccessControl fetchAccessControl: " + ex);
            throw ex;
        }
        return fetchNext();
    }

    public AccessControl fetchNext()
        throws SQLException
    {
        AccessControl ac = new AccessControl();
        try
        {
            if(m_hasMore)
            {
                String accessCd = m_resultSet.getString(1);
                String accessDesc = m_resultSet.getString(2);
                ac.setAccessControlCode(accessCd);
                ac.setAccessControlDescription(accessDesc);
                if(m_resultSet.next())
                {
                    m_recordCount = 2;
                } else
                {
                    m_hasMore = false;
                    m_recordCount = 1;
                }
            } else
            {
                ac = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR in DbAccessControl fetchNext: " + ex);
            throw ex;
        }
        return ac;
    }

    public void save(AccessControl ac)
        throws SQLException
    {
        try
        {
            saveAccessControlStmt.setString(1, ac.getAccessControlCode());
            saveAccessControlStmt.setString(2, ac.getAccessControlDescription());
            saveAccessControlStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.getMessage();
            ex.printStackTrace();
            ex.toString();
            System.out.println("ERROR DbAccessControl save(): " + ex);
            throw ex;
        }
    }

    public void remove(AccessControl ac)
        throws SQLException
    {
        try
        {
            removeAccessControlStmt.setString(1, ac.getAccessControlCode());
            removeAccessControlStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbAccessControl remove(): " + ex);
            throw ex;
        }
    }

    public void update(AccessControl ac)
        throws SQLException
    {
        try
        {
            updateAccessControlStmt.setString(1, ac.getAccessControlDescription());
            updateAccessControlStmt.setString(2, ac.getAccessControlCode());
            updateAccessControlStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR DbAccessControl update(): " + ex);
            throw ex;
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbAccessControl.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchAccessControlSQL;
    private String saveAccessControlSQL;
    private String removeAccessControlSQL;
    private String updateAccessControlSQL;
    private PreparedStatement fetchAccessControlStmt;
    private PreparedStatement saveAccessControlStmt;
    private PreparedStatement removeAccessControlStmt;
    private PreparedStatement updateAccessControlStmt;
}
