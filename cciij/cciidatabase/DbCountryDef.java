// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbCountryDef.java

package cciij.cciidatabase;

import cciij.cciidata.CountryDef;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbCountryDef extends DbBase
{

    public DbCountryDef()
    {
        selectAllCountryDefStmt = null;
        selectCountryDefStmt = null;
        saveCountryDefStmt = null;
        updateCountryDefStmt = null;
        deleteCountryDefStmt = null;
    }

    public CountryDef fetchNext()
        throws SQLException
    {
        CountryDef countryDef = new CountryDef();
        if(m_hasMore)
        {
            countryDef.setCountryCode(countryCode);
            countryDef.setCountryName(m_resultSet.getString("COUNTRY_NM"));
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
            countryDef = null;
            m_recordCount = 0;
        }
        return countryDef;
    }

    public CountryDef fetchAllCountryDef(Connection conn)
        throws SQLException
    {
        try
        {
            selectAllCountryDefStmt = conn.prepareStatement("SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF ");
            runQuery(selectAllCountryDefStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchAllCountryDef", "SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF ", "");
            throw e;
        }
        return fetchNext();
    }

    public CountryDef fetchCountryDef(Connection conn, String countryCd)
        throws SQLException
    {
        try
        {
            countryCode = countryCd;
            selectCountryDefStmt = conn.prepareStatement("SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF  WHERE COUNTRY_CD = ?");
            selectCountryDefStmt.setString(1, countryCd);
            runQuery(selectCountryDefStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetchCountryDef", "SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF  WHERE COUNTRY_CD = ?", countryCd);
            throw e;
        }
        return fetchNext();
    }

    public void saveCountryDef(Connection conn, CountryDef countryDef)
        throws SQLException
    {
        try
        {
            saveCountryDefStmt = conn.prepareStatement("INSERT INTO ENT.COUNTRY_DEF (COUNTRY_CD, COUNTRY_NM )  VALUES( ?,? )");
            saveCountryDefStmt.setString(1, countryDef.getCountryCode());
            saveCountryDefStmt.setString(2, countryDef.getCountryName());
            saveCountryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "saveCountryDef", "INSERT INTO ENT.COUNTRY_DEF (COUNTRY_CD, COUNTRY_NM )  VALUES( ?,? )", countryDef.getCountryCode() + ", " + countryDef.getCountryName());
            throw e;
        }
    }

    public void updateCountryDef(Connection conn, CountryDef countryDef)
        throws SQLException
    {
        try
        {
            updateCountryDefStmt = conn.prepareStatement("UPDATE ENT.COUNTRY_DEF SET COUNTRY_CD = ?, COUNTRY_NM = ? WHERE COUNTRY_CD = ? ");
            updateCountryDefStmt.setString(1, countryDef.getCountryCode());
            updateCountryDefStmt.setString(2, countryDef.getCountryName());
            updateCountryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "updateCountryDef", "UPDATE ENT.COUNTRY_DEF SET COUNTRY_CD = ?, COUNTRY_NM = ? WHERE COUNTRY_CD = ? ", countryDef.getCountryCode() + ", " + countryDef.getCountryName());
            throw e;
        }
    }

    public void deleteCountryDef(Connection conn, CountryDef countryDef)
        throws SQLException
    {
        try
        {
            deleteCountryDefStmt = conn.prepareStatement("DELETE FROM ENT.COUNTRY_DEF WHERE COUNTRY_CD = ?");
            deleteCountryDefStmt.setString(1, countryDef.getCountryCode());
            deleteCountryDefStmt.setString(2, countryDef.getCountryName());
            deleteCountryDefStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "deleteCountryDef", "DELETE FROM ENT.COUNTRY_DEF WHERE COUNTRY_CD = ?", countryDef.getCountryCode() + ", " + countryDef.getCountryName());
            throw e;
        }
    }

    public int getCountryDefRecordCount()
    {
        return m_recordCount;
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        DbCountryDef dbCountryDef = new DbCountryDef();
        dbCountryDef.testDbCountryDef(db);
        db.closeConnection();
    }

    private void testDbCountryDef(DatabaseBean db)
    {
        CountryDef countryDef = null;
        try
        {
            System.out.println("============Executing INSERT US, UNITED STATE ");
            db.saveCountryDef(new CountryDef("US", "UNITED STATE"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting countryDef " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY US");
            countryDef = db.fetchCountryDef("US");
            if(countryDef != null)
                System.out.println(countryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by COUNTRY_CD" + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE COUNTRY_CD US");
            db.updateCountryDef(new CountryDef("US", "UNITED STATES"));
            if(countryDef != null)
                System.out.println(countryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by COUNTRY_CD" + e.getMessage());
        }
        try
        {
            System.out.println("===============Executing SELECT *");
            if((countryDef = db.fetchAllCountryDef()) != null)
                System.out.println(countryDef);
            while((countryDef = db.fetchNextCountryDef()) != null) 
                System.out.println(countryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting all country " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY COUNTRY_CD US ");
            countryDef = db.fetchCountryDef("US");
            if(countryDef != null)
                System.out.println(countryDef);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting country by countrycd " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE US, UNITED STATES ");
            db.removeCountryDef(new CountryDef("US", "UNITED STATES"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while deleting Country " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY COUNTRY_CD US ");
            countryDef = db.fetchCountryDef("US");
            if(countryDef != null)
                System.out.println(countryDef);
            else
                System.out.println("Country not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting Country " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbCountryDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:16 $\n";
    private final String tableName = "ENT.COUNTRY_DEF ";
    private final String selectAllCountryDefSQL = "SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF ";
    private final String selectCountryDefSQL = "SELECT COUNTRY_CD, COUNTRY_NM FROM ENT.COUNTRY_DEF  WHERE COUNTRY_CD = ?";
    private final String saveCountryDefSQL = "INSERT INTO ENT.COUNTRY_DEF (COUNTRY_CD, COUNTRY_NM )  VALUES( ?,? )";
    private final String updateCountryDefSQL = "UPDATE ENT.COUNTRY_DEF SET COUNTRY_CD = ?, COUNTRY_NM = ? WHERE COUNTRY_CD = ? ";
    private final String deleteCountryDefSQL = "DELETE FROM ENT.COUNTRY_DEF WHERE COUNTRY_CD = ?";
    private PreparedStatement selectAllCountryDefStmt;
    private PreparedStatement selectCountryDefStmt;
    private PreparedStatement saveCountryDefStmt;
    private PreparedStatement updateCountryDefStmt;
    private PreparedStatement deleteCountryDefStmt;
    private String countryCode;
}
