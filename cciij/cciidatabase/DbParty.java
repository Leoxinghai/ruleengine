// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbParty.java

package cciij.cciidatabase;

import cciij.cciidata.Party;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbParty extends DbBase
{

    public DbParty()
    {
        fetchPartySql = "SELECT OID_NBR, OID_TYPE_CD, PARTY_TYPE_CD, CUSTOMER_ACCT_NBR, COUNTRY_CD, COUNTRY_SUB_ENTITY_CD, CUSTOMS_ID_CD, COMPANY_NM, CONTACT_NM, ADDRESS1_DESC, ADDRESS2_DESC, CITY_NM, STATE_CD, POSTAL_CD, CONTACT_PHONE_NBR, EMAIL_NM, LAST_MODIFIED_NM, LAST_MODIFIED_TMSTP, CUSTOMS_SELF_ASSESSMENT_FLG FROM PARTY WHERE OID_NBR = ? AND OID_TYPE_CD = ? ";
        savePartySql = "INSERT INTO PARTY  (OID_NBR, OID_TYPE_CD, PARTY_TYPE_CD, CUSTOMER_ACCT_NBR, COUNTRY_CD, COUNTRY_SUB_ENTITY_CD, CUSTOMS_ID_CD, COMPANY_NM, CONTACT_NM, ADDRESS1_DESC, ADDRESS2_DESC, CITY_NM, STATE_CD, POSTAL_CD, CONTACT_PHONE_NBR, EMAIL_NM, LAST_MODIFIED_NM, LAST_MODIFIED_TMSTP, CUSTOMS_SELF_ASSESSMENT_FLG VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        deletePartySql = "DELETE FROM PARTY  WHERE OID_NBR = ? AND OID_TYPE_CD = ? ";
        updatePartySql = "UPDATE PARTY  SET OID_NBR = ?, OID_TYPE_CD = ?, PARTY_TYPE_CD + ?, CUSTOMER_ACCT_NBR = ?, COUNTRY_CD = ?, COUNTRY_SUB_ENTITY_CD = ?, CUSTOMS_ID_CD = ?, COMPANY_NM = ?, CONTACT_NM = ?, ADDRESS1_DESC = ?, ADDRESS2_DESC = ?, CITY_NM = ?, STATE_CD = ?, POSTAL_CD = ?, CONTACT_PHONE_NBR = ?, EMAIL_NM = ?, LAST_MODIFIED_NM = ?, LAST_MODIFIED_TMSTP = ?, CUSTOMS_SELF_ASSESSMENT_FLG = ? WHERE OID_NBR = ? AND OID_TYPE_CD = ? ";
        fetchPartyStmt = null;
        savePartyStmt = null;
        deletePartyStmt = null;
        updatePartyStmt = null;
    }

    public Party fetch(Connection conn, int OidNbr, String OidNbrType)
        throws SQLException
    {
        try
        {
            fetchPartyStmt = conn.prepareStatement(fetchPartySql);
            fetchPartyStmt.setInt(1, OidNbr);
            fetchPartyStmt.setString(2, OidNbrType);
            runQuery(fetchPartyStmt);
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "fetch", fetchPartySql, "");
            throw e;
        }
        return fetchNext();
    }

    public Party fetchNext()
        throws SQLException
    {
        Party party = new Party();
        if(m_hasMore)
        {
            party.setOidNbr(m_resultSet.getInt("OID_NBR"));
            party.setOidTypeCd(m_resultSet.getString("OID_TYPE_CD"));
            party.setPartyTypeCd(m_resultSet.getString("PARTY_TYPE_CD"));
            party.setCustomerAcctNbr(m_resultSet.getInt("CUSTOMER_ACCT_NBR"));
            party.setCountryCd(m_resultSet.getString("COUNTRY_CD"));
            party.setCountrySubEntityCd(m_resultSet.getString("COUNTRY_SUB_ENTITY_CD"));
            party.setCustomsIdCd(m_resultSet.getString("CUSTOMS_ID_CD"));
            party.setCompanyNm(m_resultSet.getString("COMPANY_NM"));
            party.setContactNm(m_resultSet.getString("CONTACT_NM"));
            party.setAddress1Desc(m_resultSet.getString("ADDRESS1_DESC"));
            party.setAddress2Desc(m_resultSet.getString("ADDRESS2_DESC"));
            party.setCityNm(m_resultSet.getString("CITY_NM"));
            party.setStateCd(m_resultSet.getString("STATE_CD"));
            party.setPostalCd(m_resultSet.getString("POSTAL_CD"));
            party.setContactPhoneNbr(m_resultSet.getString("CONTACT_PHONE_NBR"));
            party.setEmailNm(m_resultSet.getString("EMAIL_NM"));
            party.setLastModifiedNm(m_resultSet.getString("LAST_MODIFIED_NM"));
            party.setLastModifiedTmstp(m_resultSet.getTimestamp("LAST_MODIFIED_TMSTP"));
            party.setCustomsSelfAssessmentFlg(m_resultSet.getString("CUSTOMS_SELF_ASSESSMENT_FLG"));
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
            party = null;
            m_recordCount = 0;
        }
        return party;
    }

    public void save(Connection conn, Party party)
        throws SQLException
    {
        Timestamp lastModifiedTimestamp = null;
        try
        {
            savePartyStmt = conn.prepareStatement(savePartySql);
            lastModifiedTimestamp = new Timestamp(party.getLastModifiedTmstp().getTime());
            savePartyStmt.setInt(1, party.getOidNbr());
            savePartyStmt.setString(2, party.getOidTypeCd());
            savePartyStmt.setString(3, party.getPartyTypeCd());
            savePartyStmt.setInt(4, party.getCustomerAcctNbr());
            savePartyStmt.setString(5, party.getCountryCd());
            savePartyStmt.setString(6, party.getCountrySubEntityCd());
            savePartyStmt.setString(7, party.getCustomsIdCd());
            savePartyStmt.setString(8, party.getCompanyNm());
            savePartyStmt.setString(9, party.getContactNm());
            savePartyStmt.setString(10, party.getAddress1Desc());
            savePartyStmt.setString(11, party.getAddress2Desc());
            savePartyStmt.setString(12, party.getCityNm());
            savePartyStmt.setString(13, party.getStateCd());
            savePartyStmt.setString(14, party.getPostalCd());
            savePartyStmt.setString(15, party.getContactPhoneNbr());
            savePartyStmt.setString(16, party.getEmailNm());
            savePartyStmt.setString(17, party.getLastModifiedNm());
            savePartyStmt.setTimestamp(18, lastModifiedTimestamp);
            savePartyStmt.setString(19, party.getCustomsSelfAssessmentFlg());
            savePartyStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "save", savePartySql, party.getOidNbr() + ", " + party.getOidTypeCd() + ", " + party.getPartyTypeCd() + ", " + party.getCustomerAcctNbr() + ", " + party.getCountryCd() + ", " + party.getCountrySubEntityCd() + ", " + party.getCustomsIdCd() + ", " + party.getCompanyNm() + ", " + party.getContactNm() + ", " + party.getAddress1Desc() + ", " + party.getAddress2Desc() + ", " + party.getCityNm() + ", " + party.getStateCd() + ", " + party.getPostalCd() + ", " + party.getContactPhoneNbr() + ", " + party.getEmailNm() + ", " + party.getLastModifiedNm() + ", " + party.getLastModifiedTmstp() + ", " + party.getCustomsSelfAssessmentFlg());
            throw e;
        }
    }

    public void update(Connection conn, Party party, int OidNbr, String OidTypeCd)
        throws SQLException
    {
        Timestamp lastModifiedTimestamp = null;
        try
        {
            updatePartyStmt = conn.prepareStatement(updatePartySql);
            lastModifiedTimestamp = new Timestamp(party.getLastModifiedTmstp().getTime());
            updatePartyStmt.setInt(1, party.getOidNbr());
            updatePartyStmt.setString(2, party.getOidTypeCd());
            updatePartyStmt.setString(3, party.getPartyTypeCd());
            updatePartyStmt.setInt(4, party.getCustomerAcctNbr());
            updatePartyStmt.setString(5, party.getCountryCd());
            updatePartyStmt.setString(6, party.getCountrySubEntityCd());
            updatePartyStmt.setString(7, party.getCustomsIdCd());
            updatePartyStmt.setString(8, party.getCompanyNm());
            updatePartyStmt.setString(9, party.getContactNm());
            updatePartyStmt.setString(10, party.getAddress1Desc());
            updatePartyStmt.setString(11, party.getAddress2Desc());
            updatePartyStmt.setString(12, party.getCityNm());
            updatePartyStmt.setString(13, party.getStateCd());
            updatePartyStmt.setString(14, party.getPostalCd());
            updatePartyStmt.setString(15, party.getContactPhoneNbr());
            updatePartyStmt.setString(16, party.getEmailNm());
            updatePartyStmt.setString(17, party.getLastModifiedNm());
            updatePartyStmt.setTimestamp(18, lastModifiedTimestamp);
            updatePartyStmt.setString(19, party.getCustomsSelfAssessmentFlg());
            updatePartyStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "update", updatePartySql, party.getOidNbr() + ", " + party.getOidTypeCd() + ", " + party.getPartyTypeCd() + ", " + party.getCustomerAcctNbr() + ", " + party.getCountryCd() + ", " + party.getCountrySubEntityCd() + ", " + party.getCustomsIdCd() + ", " + party.getCompanyNm() + ", " + party.getContactNm() + ", " + party.getAddress1Desc() + ", " + party.getAddress2Desc() + ", " + party.getCityNm() + ", " + party.getStateCd() + ", " + party.getPostalCd() + ", " + party.getContactPhoneNbr() + ", " + party.getEmailNm() + ", " + party.getLastModifiedNm() + ", " + party.getLastModifiedTmstp() + ", " + party.getCustomsSelfAssessmentFlg());
            throw e;
        }
    }

    public void delete(Connection conn, int OidNbr, String OidTypeCd)
        throws SQLException
    {
        try
        {
            deletePartyStmt = conn.prepareStatement(deletePartySql);
            deletePartyStmt.setInt(1, OidNbr);
            deletePartyStmt.setString(2, OidTypeCd);
            deletePartyStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            printSQLException(e, getClass().getName(), "delete", deletePartySql, "");
            throw e;
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.setLocationCode("COSA");
        db.connect();
        DbParty dbParty = new DbParty();
        dbParty.testDbParty(db);
        db.closeConnection();
    }

    private void testDbParty(DatabaseBean db)
    {
        Party party = null;
        try
        {
            System.out.println("====Executing INSERT 12345, XYZ BROKER, COLORADO SPRINGS, US, 80132, COSA, 123-4567");
            db.saveParty(new Party(12345, "P", "X", 234, "CA", "", "CUSTOMS CD 1212", "XYZ Broker", "Joe Schmo", "Colorado Ave", "", "Toronto", "OT", "M5A3W9", "123-4567", "EMail.yahoo.com", "Somebody's Name", new Date(), "?"));
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while inserting party " + e.getMessage());
        }
        try
        {
            System.out.println("====Executing SELECT BY OID_NBR 12345, OID_TYPE_CD P");
            party = db.fetchParty(12345, "P");
            if(party != null)
                System.out.println(party);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by OID_NBR and OID_TYPE_CD " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing UPDATE BY OID_NBR and OID_TYPE_CD");
            db.updateParty(new Party(54321, "P", "X", 567, "CA", "", "CUSTOMS CD 3434", "ABC Broker", "Joe Schmo", "Colorado Ave", "", "Toronto", "OT", "M5A3W9", "123-4567", "EMail.yahoo.com", "Somebody's Name", new Date(), "?"), 12345, "P");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while updateing by OID_NBR and OID_TYPE_CD " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY OID_NBR and OID_TYPE_CD");
            party = db.fetchParty(54321, "P");
            if(party != null)
                System.out.println(party);
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while selecting by OID_NBR and OID_TYPE_CD " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing DELETE 54321, 'P' ");
            db.removeParty(54321, "P");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while deleting Party " + e.getMessage());
        }
        try
        {
            System.out.println("============Executing SELECT BY OID_NBR 12345 and OID_TYPE_CD P ");
            party = db.fetchParty(54321, "P");
            if(party != null)
                System.out.println(party);
            else
                System.out.println("Party not found");
        }
        catch(SQLException e)
        {
            System.out.println("Caught sqlEx while fetching Party by OID_NBR and OID_TYPE_CD " + e.getMessage());
        }
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbParty.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private static final String tableName = "PARTY ";
    private String fetchPartySql;
    private String savePartySql;
    private String deletePartySql;
    private String updatePartySql;
    private PreparedStatement fetchPartyStmt;
    private PreparedStatement savePartyStmt;
    private PreparedStatement deletePartyStmt;
    private PreparedStatement updatePartyStmt;
}
