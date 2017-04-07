// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbPrinterConfiguration.java

package cciij.cciidatabase;

import cciij.cciidata.PrinterConfiguration;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package cciij.cciidatabase:
//            DbBase, DatabaseBean

public class DbPrinterConfiguration extends DbBase
{

    public DbPrinterConfiguration()
    {
        fetchAllSQL = "SELECT LOCATION_CD, PRINTER_CD, PRINTER_TYPE_CD, PRINTER_NM, PRINTER_PARAM1_DESC, PRINTER_PARAM2_DESC, PRINTER_PARAM3_DESC, PRINTER_PARAM4_DESC, FORMAT_TYPE_CD FROM PRINTER_CONFIGURATION WHERE LOCATION_CD = ? ORDER BY PRINTER_CD";
        fetchByPrimaryKeySQL = "SELECT LOCATION_CD, PRINTER_CD, PRINTER_TYPE_CD, PRINTER_NM, PRINTER_PARAM1_DESC, PRINTER_PARAM2_DESC, PRINTER_PARAM3_DESC, PRINTER_PARAM4_DESC, FORMAT_TYPE_CD FROM PRINTER_CONFIGURATION WHERE LOCATION_CD = ? AND PRINTER_CD = ?";
        savePrintConfigSQL = "INSERT INTO PRINTER_CONFIGURATION (LOCATION_CD, PRINTER_CD, PRINTER_TYPE_CD, PRINTER_NM, PRINTER_PARAM1_DESC, PRINTER_PARAM2_DESC, PRINTER_PARAM3_DESC, PRINTER_PARAM4_DESC, FORMAT_TYPE_CD) VALUES(?,?,?,?,?,?,?,?,?)";
        removePrintConfigSQL = "DELETE FROM PRINTER_CONFIGURATION WHERE LOCATION_CD = ? AND PRINTER_CD = ?";
        updatePrintConfigSQL = "UPDATE PRINTER_CONFIGURATION SET PRINTER_TYPE_CD = ?, PRINTER_NM = ?, PRINTER_PARAM1_DESC = ?, PRINTER_PARAM2_DESC = ?, PRINTER_PARAM3_DESC = ?, PRINTER_PARAM4_DESC = ?, FORMAT_TYPE_CD = ? WHERE LOCATION_CD = ? AND PRINTER_CD = ?";
        fetchByPrimaryKeyStmt = null;
        fetchAllStmt = null;
        savePrintConfigStmt = null;
        removePrintConfigStmt = null;
        updatePrintConfigStmt = null;
    }

    public int getPrinterConfigurationRecordCount()
    {
        return m_recordCount;
    }

    public PrinterConfiguration fetch(Connection conn, String locationCode)
        throws SQLException
    {
        try
        {
            fetchAllStmt = conn.prepareStatement(fetchAllSQL);
            fetchAllStmt.setString(1, locationCode);
            runQuery(fetchAllStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchAllSQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public PrinterConfiguration fetch(Connection conn, String locationCode, String printerCode)
        throws SQLException
    {
        try
        {
            fetchByPrimaryKeyStmt = conn.prepareStatement(fetchByPrimaryKeySQL);
            fetchByPrimaryKeyStmt.setString(1, locationCode);
            fetchByPrimaryKeyStmt.setString(2, printerCode);
            runQuery(fetchByPrimaryKeyStmt);
        }
        catch(SQLException ex)
        {
            String paramList = locationCode + ", " + printerCode;
            printSQLException(ex, getClass().getName(), "fetch", fetchByPrimaryKeySQL, paramList);
            throw ex;
        }
        return fetchNext();
    }

    public PrinterConfiguration fetchNext()
        throws SQLException
    {
        PrinterConfiguration pc = new PrinterConfiguration();
        try
        {
            if(m_hasMore)
            {
                String locationCode = m_resultSet.getString(1);
                String printerCode = m_resultSet.getString(2);
                String printerTypeCode = m_resultSet.getString(3);
                String printerName = m_resultSet.getString(4);
                String printerParam1 = m_resultSet.getString(5);
                String printerParam2 = m_resultSet.getString(6);
                String printerParam3 = m_resultSet.getString(7);
                String printerParam4 = m_resultSet.getString(8);
                String formatTypeCode = m_resultSet.getString(9);
                pc = new PrinterConfiguration(locationCode, printerCode, printerTypeCode, printerName, printerParam1, printerParam2, printerParam3, printerParam4, formatTypeCode);
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
                pc = null;
                m_recordCount = 0;
            }
        }
        catch(SQLException ex)
        {
            printSQLException(ex, getClass().getName(), "fetchNext()", " ", " ");
            throw ex;
        }
        return pc;
    }

    public void save(Connection conn, PrinterConfiguration pc, String locationCode)
        throws SQLException
    {
        try
        {
            savePrintConfigStmt = conn.prepareStatement(savePrintConfigSQL);
            if(pc.getLocationCode() == null || pc.getLocationCode().equals(""))
                savePrintConfigStmt.setString(1, locationCode);
            else
                savePrintConfigStmt.setString(1, pc.getLocationCode());
            savePrintConfigStmt.setString(2, pc.getPrinterCode());
            savePrintConfigStmt.setString(3, pc.getPrinterType());
            savePrintConfigStmt.setString(4, pc.getPrinterName());
            savePrintConfigStmt.setString(5, pc.getPrinterParameterOne());
            savePrintConfigStmt.setString(6, pc.getPrinterParameterTwo());
            savePrintConfigStmt.setString(7, pc.getPrinterParameterThree());
            savePrintConfigStmt.setString(8, pc.getPrinterParameterFour());
            savePrintConfigStmt.setString(9, pc.getFormatTypeCode());
            savePrintConfigStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pc.getLocationCode() + ", " + pc.getPrinterCode() + ", " + pc.getPrinterType() + ", " + pc.getPrinterName() + ", " + pc.getPrinterParameterOne() + ", " + pc.getPrinterParameterTwo() + ", " + pc.getPrinterParameterThree() + ", " + pc.getPrinterParameterFour() + ", " + pc.getFormatTypeCode();
            printSQLException(ex, getClass().getName(), "save", savePrintConfigSQL, paramList);
            throw ex;
        }
    }

    public void remove(Connection conn, PrinterConfiguration pc, String locationCode)
        throws SQLException
    {
        try
        {
            removePrintConfigStmt = conn.prepareStatement(removePrintConfigSQL);
            if(pc.getLocationCode() == null || pc.getLocationCode().equals(""))
                removePrintConfigStmt.setString(1, locationCode);
            else
                removePrintConfigStmt.setString(1, pc.getLocationCode());
            removePrintConfigStmt.setString(2, pc.getPrinterCode());
            removePrintConfigStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList;
            if(pc.getLocationCode() == null || pc.getLocationCode().equals(""))
                paramList = locationCode + ", " + pc.getPrinterCode();
            else
                paramList = pc.getLocationCode() + ", " + pc.getPrinterCode();
            printSQLException(ex, getClass().getName(), "remove", removePrintConfigSQL, paramList);
            throw ex;
        }
    }

    public void update(Connection conn, PrinterConfiguration pc, String locationCode)
        throws SQLException
    {
        try
        {
            updatePrintConfigStmt = conn.prepareStatement(updatePrintConfigSQL);
            updatePrintConfigStmt.setString(1, pc.getPrinterType());
            updatePrintConfigStmt.setString(2, pc.getPrinterName());
            updatePrintConfigStmt.setString(3, pc.getPrinterParameterOne());
            updatePrintConfigStmt.setString(4, pc.getPrinterParameterTwo());
            updatePrintConfigStmt.setString(5, pc.getPrinterParameterThree());
            updatePrintConfigStmt.setString(6, pc.getPrinterParameterFour());
            updatePrintConfigStmt.setString(7, pc.getFormatTypeCode());
            if(pc.getLocationCode() == null || pc.getLocationCode().equals(""))
                updatePrintConfigStmt.setString(8, locationCode);
            else
                updatePrintConfigStmt.setString(8, pc.getLocationCode());
            updatePrintConfigStmt.setString(9, pc.getPrinterCode());
            updatePrintConfigStmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            String paramList = pc.getPrinterType() + ", " + pc.getPrinterName() + ", " + pc.getPrinterParameterOne() + ", " + pc.getPrinterParameterTwo() + ", " + pc.getPrinterParameterThree() + ", " + pc.getPrinterParameterFour() + ", " + pc.getFormatTypeCode() + ", ";
            if(pc.getLocationCode() == null || pc.getLocationCode().equals(""))
                paramList = paramList + locationCode + ", " + pc.getPrinterCode();
            else
                paramList = paramList + pc.getLocationCode() + ", " + pc.getPrinterCode();
            printSQLException(ex, getClass().getName(), "update", updatePrintConfigSQL, paramList);
            throw ex;
        }
    }

    public static void dbTest(DatabaseBean db)
    {
        PrinterConfiguration pc = new PrinterConfiguration();
        PrinterConfiguration pc1 = new PrinterConfiguration("TEK", "TEKPR001", "TK", "TEK'S TEST PRINTER ONE", "PARAM1", "PARAM2", "PARAM3", "PARAM4", "INTERMEC");
        PrinterConfiguration pc2 = new PrinterConfiguration("TEK", "TEKPR002", "TK", "TEK'S TEST PRINTER TWO", "PARAM1", "PARAM2", "PARAM3", "PARAM4", "ZEBRA");
        db.setLocationCode("TEK");
        try
        {
            db.savePrinterConfiguration(pc1);
            System.out.println("Test Case 1: Successfully saved PrinterConfiguration pc1");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
            db.savePrinterConfiguration(pc2);
            System.out.println("Test Case 1: Successfully saved PrinterConfiguration pc2");
            db.commitTransaction();
            System.out.println("Test Case 1: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 1: unsuccessful" + ex);
        }
        pc2.setPrinterParameterOne("1PARAM");
        pc2.setPrinterParameterTwo("2PARAM");
        pc2.setPrinterParameterThree("3PARAM");
        pc2.setPrinterParameterFour("4PARAM");
        pc2.setFormatTypeCode("ZEBRA2");
        try
        {
            db.updatePrinterConfiguration(pc2);
            System.out.println("Test Case 2: Successfully updated PrinterConfiguration pc2");
            db.commitTransaction();
            System.out.println("Test Case 2: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 2: unsuccessful" + ex);
        }
        try
        {
            pc = db.fetchPrinterConfiguration("TEKPR001");
            System.out.println("Test Case 3a: Successfully fetched pc1; PrinterConfiguration = " + pc);
            pc = db.fetchPrinterConfiguration();
            for(int currentRow = 1; db.getPrinterConfigurationRecordCount() > 0; currentRow++)
            {
                System.out.println("Test Case 3b: Successfully fetched Row = " + currentRow + " PrinterConfiguration = " + pc);
                pc = db.fetchNextPrinterConfiguration();
            }

        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 3: unsuccessful" + ex);
        }
        try
        {
            db.removePrinterConfiguration(pc1);
            System.out.println("Test Case 4: Successfully removed PrinterConfiguration pc1");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
            db.removePrinterConfiguration(pc2);
            System.out.println("Test Case 4: Successfully removed PrinterConfiguration pc2");
            db.commitTransaction();
            System.out.println("Test Case 4: Successfully committed");
        }
        catch(SQLException ex)
        {
            System.out.println("Test Case 4: unsuccessful" + ex);
        }
    }

    public static void main(String args[])
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        dbTest(db);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: DbPrinterConfiguration.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:15 $\n";
    private String fetchAllSQL;
    private String fetchByPrimaryKeySQL;
    private String savePrintConfigSQL;
    private String removePrintConfigSQL;
    private String updatePrintConfigSQL;
    private PreparedStatement fetchByPrimaryKeyStmt;
    private PreparedStatement fetchAllStmt;
    private PreparedStatement savePrintConfigStmt;
    private PreparedStatement removePrintConfigStmt;
    private PreparedStatement updatePrintConfigStmt;
}
