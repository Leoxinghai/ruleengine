// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelBase.java

package cciij.businessActions.label;

import cciij.businessActions.BusinessActionBase;
import cciij.businessActions.LabelData;
import cciij.cciidata.*;
import cciij.cciidatabase.DatabaseBean;
import cciij.util.SimpleNotify;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;
import rmtc.util.Config;

import cciij.businessActions.Messages;

// Referenced classes of package cciij.businessActions.label:
//            LabelDefinitionMux, LabelTransmition, LabelPrintMessageException, LabelPrintException, 
//            PrintServer, StdOutPrintServer, ScannerPrintServer, LPDPrintServer, 
//            LPDFastPrintServer, LPExecPrintServer

public abstract class LabelBase extends BusinessActionBase
{
    private class PrinterCodeKey
        implements Comparable
    {

        public String getPrinterCode()
        {
            return m_printerCode;
        }

        public String getLocationCode()
        {
            return m_locationCode;
        }

        public String toString()
        {
            return "Printer Code:  " + m_printerCode + " in Location:  " + m_locationCode;
        }

        public int compareTo(Object o)
        {
            if(o instanceof PrinterCodeKey)
            {
                PrinterCodeKey pck = (PrinterCodeKey)o;
                if(m_printerCode.equals(pck.getPrinterCode()))
                    return m_locationCode.compareTo(pck.getLocationCode());
                else
                    return m_printerCode.compareTo(pck.getPrinterCode());
            } else
            {
                return 0xfff0bdc1;
            }
        }

        String m_printerCode;
        String m_locationCode;

        public PrinterCodeKey(String printerCode, String locationCode)
        {
            m_printerCode = "";
            m_locationCode = "";
            m_printerCode = printerCode;
            m_locationCode = locationCode;
        }
    }


    protected LabelBase(String as_objName)
        throws Exception
    {
        super(as_objName);
        m_definitions = new LabelDefinitionMux();
        m_printers = new TreeMap();
        m_notify = new SimpleNotify(as_objName);
    }

    protected String formatAWB(String as_awb)
    {
        String ls_formattedAWB = "";
        String ls_spaces = "                                           ";
        int li_grpBegin[] = null;
        int li_grpEnd[] = null;
        String lc_interSpace[] = null;
        int li_preSpaces = 0;
        int li_postSpaces = 0;
        int li_grpCount = 0;
        switch(as_awb.length())
        {
        case 12: // '\f'
            li_grpBegin = (new int[] {
                0, 4, 8
            });
            li_grpEnd = (new int[] {
                4, 8, 12
            });
            li_preSpaces = 0;
            li_postSpaces = 0;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 11: // '\013'
            li_grpBegin = (new int[] {
                0, 3, 7
            });
            li_grpEnd = (new int[] {
                3, 7, 11
            });
            li_preSpaces = 1;
            li_postSpaces = 0;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            if(as_awb.substring(0, 3).equals("400"))
                lc_interSpace[0] = "-";
            li_grpCount = 3;
            break;

        case 10: // '\n'
            li_grpBegin = (new int[] {
                0, 3, 7
            });
            li_grpEnd = (new int[] {
                3, 7, 10
            });
            li_preSpaces = 1;
            li_postSpaces = 1;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 9: // '\t'
            li_grpBegin = (new int[] {
                0, 3, 6
            });
            li_grpEnd = (new int[] {
                3, 6, 9
            });
            li_preSpaces = 1;
            li_postSpaces = 2;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 8: // '\b'
            li_grpBegin = (new int[] {
                0, 2, 5
            });
            li_grpEnd = (new int[] {
                2, 5, 8
            });
            li_preSpaces = 2;
            li_postSpaces = 2;
            lc_interSpace = (new String[] {
                " ", " ", ""
            });
            li_grpCount = 3;
            break;

        case 0: // '\0'
        case 1: // '\001'
            li_preSpaces = 0;
            li_postSpaces = 0;
            li_grpCount = 0;
            break;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            li_grpBegin = (new int[] {
                0
            });
            li_grpEnd = (new int[] {
                as_awb.length()
            });
            li_preSpaces = 0;
            li_postSpaces = 14 - as_awb.length();
            li_grpCount = 1;
            lc_interSpace = (new String[] {
                ""
            });
            break;
        }
        if(li_preSpaces > 0)
            ls_formattedAWB = ls_formattedAWB.concat(ls_spaces.substring(0, li_preSpaces));
        for(int i = 0; i < li_grpCount; i++)
        {
            ls_formattedAWB = ls_formattedAWB.concat(as_awb.substring(li_grpBegin[i], li_grpEnd[i]));
            ls_formattedAWB = ls_formattedAWB.concat(lc_interSpace[i]);
        }

        if(li_postSpaces > 0)
            ls_formattedAWB = ls_formattedAWB.concat(ls_spaces.substring(0, li_postSpaces));
        return ls_formattedAWB;
    }

    protected String getStrTime(long al_dateTime)
    {
        String ls_tmp = new String();
        String timeZoneStr = m_config.getString("LOCAL_TIMEZONE", "GMT+00:00");
        Calendar l_calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneStr));
        l_calendar.setTime(new Date(al_dateTime));
        int tmp = l_calendar.get(11);
        ls_tmp = "" + tmp + ":";
        tmp = l_calendar.get(12);
        if(tmp < 10)
            ls_tmp = ls_tmp + "0";
        ls_tmp = ls_tmp + tmp;
        return ls_tmp;
    }

    protected String getStrDate(long al_dateTime)
    {
        String ls_tmp = new String();
        String timeZoneStr = m_config.getString("LOCAL_TIMEZONE", "GMT+00:00");
        Calendar l_calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneStr));
        int tmp = l_calendar.get(5);
        ls_tmp = ls_tmp + tmp;
        switch(l_calendar.get(2))
        {
        case 0: // '\0'
            ls_tmp = ls_tmp + "JAN";
            break;

        case 1: // '\001'
            ls_tmp = ls_tmp + "FEB";
            break;

        case 2: // '\002'
            ls_tmp = ls_tmp + "MAR";
            break;

        case 3: // '\003'
            ls_tmp = ls_tmp + "APR";
            break;

        case 4: // '\004'
            ls_tmp = ls_tmp + "MAY";
            break;

        case 5: // '\005'
            ls_tmp = ls_tmp + "JUN";
            break;

        case 6: // '\006'
            ls_tmp = ls_tmp + "JUL";
            break;

        case 7: // '\007'
            ls_tmp = ls_tmp + "AUG";
            break;

        case 8: // '\b'
            ls_tmp = ls_tmp + "SEP";
            break;

        case 9: // '\t'
            ls_tmp = ls_tmp + "OCT";
            break;

        case 10: // '\n'
            ls_tmp = ls_tmp + "NOV";
            break;

        case 11: // '\013'
            ls_tmp = ls_tmp + "DEC";
            break;

        default:
            ls_tmp = ls_tmp + "UNK";
            break;
        }
        ls_tmp = ls_tmp + l_calendar.get(1);
        return ls_tmp;
    }

    protected abstract LabelData getLabelData(CCIIState cciistate);

    private boolean isOverageCRN(CCIIState s)
    {
        HandlingUnit hu = new HandlingUnit(0, s.getScan().getAirbillNumber(), s.getScan().getAirbillFormType(), 0, "", 0.0F, "", 0.0D, "", s.getScan().getAirbillType(), "", "", "");
        return hu.isCRN();
    }

    public CCIIState doIt(CCIIState a_data, DatabaseBean a_db)
        throws LabelPrintException
    {
        Map l_printData = a_data.m_printData;
        int li_pieceQty = 0;
        m_db = a_db;
        if((a_data.getMPSFlag() == null || a_data.getMPSFlag().trim().length() == 0) && isOverageCRN(a_data) && a_data.getScan().getHAWB() != null && !a_data.getScan().getAirbillNumber().equals(a_data.getScan().getHAWB()))
            a_data.setMPSFlag("CRN");
        m_notify.trace_Service_TM_1S_CALLING_GETSERVICE();
        RPBScan l_scan = a_data.getScan();
        String ls_printerCode = l_scan.getPrinterCode();
        if(ls_printerCode.equals("none"))
        {
            m_db = null;
            m_notify.trace_Service_TM_1S_SUCCESS_FROM_SERVICE();
            return a_data;
        }
        m_notify.trace_CriticalCode_TM_3S_CHECKPOINT("doIt", "Got the printer Code", ls_printerCode);
        if(l_printData.containsKey("PieceQuantity"))
            li_pieceQty = Integer.parseInt((String)l_printData.get("PieceQuantity"));
        l_printData.put("TRACKING_NUMBER", formatAWB(l_scan.getAirbillNumber()));
        if(l_scan.getConsId().length() > 0)
            l_printData.put("CONS_NUMBER", formatAWB(l_scan.getConsId()));
        if(li_pieceQty < 1 && l_scan.getHAWB().length() <= 0)
        {
            if(l_scan.getHAWB().trim().equals("0"))
            {
                a_data.addPrintMapElement("HAWB", "");
                a_data.addPrintMapElement("HAWBForm", "");
            } else
            {
                a_data.addPrintMapElement("HAWB", formatAWB(l_scan.getAirbillNumber()));
                a_data.addPrintMapElement("HAWBForm", l_scan.getAirbillFormType());
            }
        } else
        {
            a_data.addPrintMapElement("HAWB", formatAWB(l_scan.getHAWB()));
            a_data.addPrintMapElement("HAWBForm", l_scan.getHAWBFormType());
        }
        if(li_pieceQty > 1)
        {
            if(l_scan.getAirbillNumber().equals(l_scan.getHAWB()) || l_scan.getHAWB().length() <= 0)
            {
                l_printData.put("AWB", "      MASTER      ");
            } else
            {
                l_printData.put("AWB", formatAWB(l_scan.getAirbillNumber()));
                l_printData.put("AWBForm", l_scan.getAirbillFormType());
            }
        } else
        if(li_pieceQty == 1)
        {
            if(!l_scan.getAirbillNumber().trim().equals(l_scan.getHAWB().trim()))
            {
                l_printData.put("AWB", formatAWB(l_scan.getAirbillNumber()));
                l_printData.put("AWBForm", l_scan.getAirbillFormType());
            } else
            {
                l_printData.put("AWB", "");
                l_printData.put("AWBForm", "");
            }
        } else
        if(l_scan.getAirbillNumber().equals(l_scan.getHAWB()) || l_scan.getHAWB().length() <= 0)
        {
            l_printData.put("AWB", "");
            l_printData.put("AWBForm", "");
        } else
        {
            l_printData.put("AWB", formatAWB(l_scan.getAirbillNumber()));
            l_printData.put("AWBForm", l_scan.getAirbillFormType());
        }
        l_printData.put("TIME", getStrTime(l_scan.getSysDateTime()));
        l_printData.put("DATE", getStrDate(l_scan.getSysDateTime()));
        String ls_diverterCode = a_data.getDiverterCode();
        if(ls_diverterCode != null)
        {
            switch(ls_diverterCode.length())
            {
            case 1: // '\001'
                ls_diverterCode = "000" + ls_diverterCode;
                break;

            case 2: // '\002'
                ls_diverterCode = "00" + ls_diverterCode;
                break;

            case 3: // '\003'
                ls_diverterCode = "0" + ls_diverterCode;
                break;
            }
            l_printData.put("DIVERTER_BARCODE_TEXT", ls_diverterCode);
        }
        i_labelCount = 0;
        i_labelMax = 1;
        do
        {
            i_labelCount++;
            LabelData l_data = getLabelData(a_data);
            try
            {
            	m_notify.trace_CriticalCode_TM_1S_CHECKPOINT("Lets get the print Server Object");
                Boolean l_reQueryPrinter = (Boolean)l_printData.get("RELOAD_PRINTER");
                boolean lb_reQueryPrinter;
                if(l_reQueryPrinter == null || !l_reQueryPrinter.booleanValue())
                {
                    lb_reQueryPrinter = false;
                } else
                {
                    lb_reQueryPrinter = true;
                    l_printData.remove("RELOAD_PRINTER");
                }
                PrintServer l_server = getPrintServer(ls_printerCode, a_data.getScan().getLocationCode(), a_db, lb_reQueryPrinter);
                LabelTransmition cmds = new LabelTransmition(l_server.getPrinterFormatType(), a_data.getScan().getLocationCode(), m_definitions);
                Boolean l_sendFormat = (Boolean)l_printData.get("SEND_FORMAT");
                boolean lb_sendFormat;
                if(l_sendFormat == null || !l_sendFormat.booleanValue())
                {
                    if(m_definitions.isFormatNeeded(cmds, a_data))
                        lb_sendFormat = true;
                    else
                        lb_sendFormat = false;
                } else
                if(m_definitions.isFormatNeeded(cmds, a_data))
                    lb_sendFormat = false;
                else
                    lb_sendFormat = true;
                Boolean l_sendLabel = (Boolean)l_printData.get("SEND_LABEL");
                boolean lb_sendLabel;
                if(l_sendLabel == null || l_sendLabel.booleanValue())
                    lb_sendLabel = true;
                else
                    lb_sendLabel = false;
                if(lb_sendFormat)
                {
                    m_notify.trace_CriticalCode_TM_1S_CHECKPOINT("Sending the Label Format to the printer");
                    m_definitions.sendFormat(cmds);
                }
                if(lb_sendLabel)
                {
                    m_notify.trace_CriticalCode_TM_1S_CHECKPOINT("Send the Label Data to the printer");
                    m_definitions.printLabel(cmds, a_data);
                }
                l_server.transmit(cmds, a_data);
            }
            catch(LabelPrintMessageException e)
            {
                a_data.getScan().setErrorNumber(Messages.EM_PRINTER_NOTSET);
                System.out.println("LabelPrintMessageException in LabelBase");
                l_scan.setErrorNumber(e.getErrorNumber());
                throw e;
            }
            catch(LabelPrintException e)
            {
                a_data.getScan().setErrorNumber(Messages.EM_PRINTER_NOTSET);
                System.out.println("LabelPrintException in LabelBase");
                throw e;
            }
            catch(Exception e)
            {
                a_data.getScan().setErrorNumber(Messages.EM_PRINTER_NOTSET);
                System.out.println("Exception in LabelBase");
                e.printStackTrace();
                throw new LabelPrintException("" + e);
            }
        } while(i_labelCount < i_labelMax);
        m_notify.trace_Service_TM_1S_SUCCESS_FROM_SERVICE();
        m_db = null;
        return a_data;
    }

    protected PrintServer getPrintServer(String as_printerCode, String locationCode, DatabaseBean db)
        throws LabelPrintException
    {
        return getPrintServer(as_printerCode, locationCode, db, false);
    }

    protected PrintServer getPrintServer(String as_printerCode, String locationCode, DatabaseBean db, boolean a_reQuery)
        throws LabelPrintException
    {
        String ls_printerCode = as_printerCode.trim();
        PrinterCodeKey key = new PrinterCodeKey(as_printerCode, locationCode);
        if(m_printers.containsKey(key))
            if(a_reQuery)
                m_printers.remove(key);
            else
                return (PrintServer)m_printers.get(key);
        String s_lookupMethod = m_config.getValue("PRINT_SERVER_LOOKUP_METHOD");
        PrintServer l_retServer;
        if(s_lookupMethod == null || s_lookupMethod.compareTo("FILE") == 0)
            l_retServer = getPrintServerFile(key, db);
        else
        if(s_lookupMethod.compareTo("DB") == 0)
            l_retServer = getPrintServerDb(key, db);
        else
            l_retServer = null;
        return l_retServer;
    }

    private PrintServer buildPrintServer(PrinterCodeKey as_code, String as_type, String as_printerFormatType, String as_param1, String as_param2, String as_param3, String as_param4)
        throws LabelPrintException
    {
        PrintServer l_server;
        if(as_type == null || as_type.compareTo("STDOUT") == 0)
        {
            l_server = new StdOutPrintServer();
            m_printers.put(as_code, l_server);
        } else
        if(as_type.compareTo("SCANNER") == 0)
        {
            l_server = new ScannerPrintServer();
            m_printers.put(as_code, l_server);
        } else
        if(as_type.compareTo("LPD") == 0 || as_type.compareTo("FASTLPD") == 0)
        {
            if(as_param1 == null || as_param1.length() < 1)
                throw new LabelPrintException("No host specified for LPD print server: " + as_code);
            int li_serverPort;
            if((li_serverPort = (new Integer(as_param2)).intValue()) <= 0)
                throw new LabelPrintException("No port specified for LPD print server:  " + as_code);
            if(as_param3 == null || as_param3.length() < 1)
                throw new LabelPrintException("No queueName specified for LPD print server: " + as_code);
            int li_timeout;
            if((li_timeout = (new Integer(as_param4)).intValue()) <= 0)
                throw new LabelPrintException("No timeout specified for LPD print server:  " + as_code);
            if(as_type.compareTo("LPD") == 0)
                l_server = new LPDPrintServer(as_param1, li_serverPort, as_param3, li_timeout);
            else
                l_server = new LPDFastPrintServer(as_param1, li_serverPort, as_param3, li_timeout);
            m_printers.put(as_code, l_server);
        } else
        if(as_type.compareTo("LPEXEC") == 0)
        {
            if(as_param3 == null || as_param3.length() < 1)
                throw new LabelPrintException("No queueName specified for LPD print server: " + as_code);
            l_server = new LPExecPrintServer(as_param3);
            m_printers.put(as_code, l_server);
        } else
        {
            throw new LabelPrintException("Dont know how to handle the Print Server:  " + as_type);
        }
        l_server.setPrinterFormatType(as_printerFormatType);
        return l_server;
    }

    private PrintServer getPrintServerFile(PrinterCodeKey as_printerCode, DatabaseBean db)
        throws LabelPrintException
    {
        String ls_serverType = m_config.getValue("PRINT_SERVER_TYPE_" + as_printerCode.toString().toUpperCase());
        String ls_printerFormatType = m_config.getValue("PRINT_SERVER_TYPE_" + as_printerCode.toString().toUpperCase());
        String ls_param1 = m_config.getValue("PRINT_SERVER_PARAM1_" + as_printerCode.toString().toUpperCase());
        String ls_param2 = m_config.getValue("PRINT_SERVER_PARAM2_" + as_printerCode.toString().toUpperCase());
        String ls_param3 = m_config.getValue("PRINT_SERVER_PARAM3_" + as_printerCode.toString().toUpperCase());
        String ls_param4 = m_config.getValue("PRINT_SERVER_PARAM4_" + as_printerCode.toString().toUpperCase());
        return buildPrintServer(as_printerCode, ls_serverType, ls_printerFormatType, ls_param1, ls_param2, ls_param3, ls_param4);
    }

    private PrintServer getPrintServerDb(PrinterCodeKey as_printerCode, DatabaseBean db)
        throws LabelPrintException
    {
        String ls_serverType = "";
        String ls_printerFormatType = "";
        String ls_param1 = "";
        String ls_param2 = "";
        String ls_param3 = "";
        String ls_param4 = "";
        try
        {
            if(db == null)
            {
                System.out.println("Creating a databasebean cuz mine is null");
                db = new DatabaseBean();
                db.connect();
            }
            db.setLocationCode(as_printerCode.getLocationCode());
            PrinterConfiguration l_ptrConfig;
            if((l_ptrConfig = db.fetchPrinterConfiguration(as_printerCode.getPrinterCode())) == null)
                throw new LabelPrintException("Printer Code not defined in the Database:  |" + as_printerCode + "|");
            ls_serverType = l_ptrConfig.getPrinterType();
            ls_printerFormatType = l_ptrConfig.getFormatTypeCode();
            ls_param1 = l_ptrConfig.getPrinterParameterOne();
            ls_param2 = l_ptrConfig.getPrinterParameterTwo();
            ls_param3 = l_ptrConfig.getPrinterParameterThree();
            ls_param4 = l_ptrConfig.getPrinterParameterFour();
        }
        catch(SQLException e)
        {
            throw new LabelPrintException("Failed to retrieve the label data" + e);
        }
        return buildPrintServer(as_printerCode, ls_serverType, ls_printerFormatType, ls_param1, ls_param2, ls_param3, ls_param4);
    }

    private static final String m_whatVersion = "@(#) $RCSfile: LabelBase.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:20 $\n";
    protected LabelDefinitionMux m_definitions;
    protected SimpleNotify m_notify;
    protected TreeMap m_printers;
    protected int i_labelCount;
    protected int i_labelMax;
    protected DatabaseBean m_db;
}
