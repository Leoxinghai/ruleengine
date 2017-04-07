// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 6/10/2003 5:24:38 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CCIIScanClientInteractiveTest.java

package cciij.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import com.oss.asn1.*;
import com.oss.util.*;


import cciij.cciidata.*;
import cciij.cciiimport.*;
import cciij.cciilookup.Lookup;
import cciij.ruleprocessor.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import rmtc.util.ui.gui.PropertiesBase;
import rmtc.util.Config;
import rmtc.util.JNDILookup;

// Referenced classes of package cciij.util:
//            GetCCIILookupBean, MessageFormat

public class CCIIScanClientInteractiveTest extends JFrame
{

    JPanel m_contentPane;
    JComponent m_buttonPane;
    JScrollPane m_scanPane;
    JScrollPane m_uploadPane;
    JScrollPane m_importPane;
    JSplitPane m_splitPane;
    JSplitPane m_splitPane2;
    JTextField m_awb;
    JCheckBox m_crn;
    JCheckBox m_cons;
    JTextField m_huOid;
    JTextField m_HAWB;
    JCheckBox m_HAWBUnknown;
    JTextField m_shipOid;
    JTextField m_user;
    JTextField m_location;
    JTextField m_warehouse;
    JTextField m_stageArea;
    JTextField m_detainLoc;
    JTextField m_printerCode;
    JComboBox m_statNbr;
    JTextField m_consTag;
    JTextField m_shuttleID;
    JTextField m_destLocationCode;
    JTextField m_comments;
    JCheckBox m_useUpload;
    JCheckBox m_bondTransfer;
    JCheckBox m_damaged;
    JRadioButton m_crushed;
    JRadioButton m_torn;
    JRadioButton m_wet;
    JRadioButton m_noDamage;
    JRadioButton m_retaped;
    JRadioButton m_rewraped;
    JRadioButton m_noAction;
    JCheckBox m_wrongFlight;
    JCheckBox m_flightDelay;
    JCheckBox m_missedShuttle;
    JTextField m_crushedLabel;
    JTextField m_tornLabel;
    JTextField m_wetLabel;
    JTextField m_retapedLabel;
    JTextField m_rewrapedLabel;
    JTextField m_noActionLabel;
    JTextField m_interceptCode;
    JTextField m_agencyCode;
    JComboBox m_actionCode;
    JTextField m_activityCode;
    JTextField m_reasonCode;
    JTextField m_releaseCode;
    JTextField m_shipRemarkCode;
    JTextField m_shipRemarkDesc;
    JTextField m_handInstCode;
    JTextField m_handInstDesc;
    JTextField m_returnAWB;
    JTextField m_hawbSerialNumber;
    JTextField m_originLoc;
    JTextField m_destLoc;
    JTextField m_inputDate;
    JTextField m_commentText;
    JTextField m_locStatNbr;
    JComboBox m_requestingProject;
    JComboBox m_requestedService;
    JComboBox m_webServerAddress;
    JComboBox m_webServerPort;
    private static final int RESET_CLIENT = -3;
    private static final int RESET_SERVER = -2;
    private static final int EXIT = -1;
    private static final int BOND_IN = 1;
    private static final int BOND_OUT = 2;
    private static final int CAGE = 3;
    private static final int MOVE_IN = 4;
    private static final int MOVE_OUT = 5;
    private static final int QUERY = 6;
    private static final int CORP = 7;
    private static final int BATCH_ADD = 8;
    private static final int BATCH_REM = 9;
    private static final int STAGE_IN = 10;
    private static final int STAGE_OUT = 11;
    private static final int DOWNLOAD_FORMATS = 12;
    private static final int POST_ACTIVITY = 13;
    private static final int DUP_LABEL = 14;
    private static final int PRINTER_ID_LABEL = 15;
    private static final int STAGE_AREA_LABEL = 16;
    private static final int WAREHOUSE_LABEL = 17;
    private static final int DETAIN_LOC_LABEL = 18;
    private static final int IMPORT = 19;
    private static final int CLEARANCE_LABEL = 20;
    private static final int GET_INTERCEPT_LIST = 21;
    private static final int IPA = 22;
    private static final int STI = 23;
    private static final int STO = 24;
    private static final int STR = 25;
    private static final int DEP = 26;
    private static final int SPS = 27;
    private static final int SIP = 101;
    private static final int SOP = 102;
    private static final int HIP = 103;
    private static final int HOP = 104;
    private static final int RIP = 105;
    private static final int ROP = 106;
    private static final int STAT = 107;
    private static final int CMT = 108;
    private static final int BOOLEAN = -100;
    private static final int RPBSCAN = -101;
    private static final int STRING = -102;
    //    CCIIScanClientWithLabelTiming m_client;
    CCIIScanClient m_client;
    RuleProcessorClient m_rpClient;
    protected Config m_config;


    private class ReturnScanOutput extends JFrame
    {

        JPanel m_contentPane;


        public ReturnScanOutput(String outBuffer, final RPBScan scan, boolean disScanButton)
        {
            m_contentPane = null;
            m_contentPane = (JPanel)getContentPane();
            m_contentPane.setLayout(new BorderLayout());
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            if(outBuffer.length() < 100)
                setSize(new Dimension((int)((double)screenSize.width * 0.40000000000000002D), (int)((double)screenSize.height * 0.20000000000000001D)));
            else
                setSize(new Dimension((int)((double)screenSize.width * 0.5D), (int)((double)screenSize.height * 0.90000000000000002D)));
            JPanel buttonPane = new JPanel();
            JButton done = new JButton("Done");
            done.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    setVisible(false);
                }

            });
            buttonPane.add(done);
            if(disScanButton)
            {
                JButton scanButton = new JButton("See Entire Returned Scan Object");
                scanButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e)
                    {
                        setVisible(false);
                        ReturnScanOutput fullScan = new ReturnScanOutput(scan.toString(), null, false);
                        fullScan.setVisible(true);
                    }

                });
                buttonPane.add(scanButton);
            }
            m_contentPane.add(buttonPane, "South");
            JPanel tp = new JPanel();
            tp.setLayout(new GridLayout(1, 1));
            JTextArea ta = new JTextArea(outBuffer);
            tp.add(ta);
            JScrollPane textPane = new JScrollPane(tp);
            m_contentPane.add(textPane, "Center");
        }
    }

    private class UploadProperties extends PropertiesBase
    {


        public UploadProperties()
        {
            super("Upload Status");
            m_useUpload = new JCheckBox();
            addProperty("Use Upload", m_useUpload);
            m_bondTransfer = new JCheckBox();
            addProperty("Bond Transfer", m_bondTransfer);
            m_wrongFlight = new JCheckBox();
            addProperty("Wrong Flight", m_wrongFlight);
            m_flightDelay = new JCheckBox();
            addProperty("Flight Delay", m_flightDelay);
            m_missedShuttle = new JCheckBox();
            addProperty("Missed Shuttle", m_missedShuttle);
            JCheckBox onFire = new JCheckBox();
            onFire.setSelected(true);
            addProperty("On Fire", onFire);
            m_damaged = new JCheckBox();
            m_damaged.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    boolean enabled = m_damaged.isSelected();
                    m_crushed.setEnabled(enabled);
                    m_torn.setEnabled(enabled);
                    m_wet.setEnabled(enabled);
                    m_noDamage.setEnabled(enabled);
                    m_retaped.setEnabled(enabled);
                    m_rewraped.setEnabled(enabled);
                    m_noAction.setEnabled(enabled);
                    m_crushedLabel.setEnabled(enabled);
                    m_tornLabel.setEnabled(enabled);
                    m_wetLabel.setEnabled(enabled);
                    m_retapedLabel.setEnabled(enabled);
                    m_rewrapedLabel.setEnabled(enabled);
                    m_noActionLabel.setEnabled(enabled);
                    m_noDamage.setSelected(true);
                    m_noAction.setSelected(true);
                }

            });
            addProperty("Damaged", m_damaged);
            ButtonGroup damageGroup = new ButtonGroup();
            m_crushed = new JRadioButton();
            m_crushed.setEnabled(false);
            damageGroup.add(m_crushed);
            m_crushedLabel = new JTextField("Crushed");
            m_crushedLabel.setEditable(false);
            m_crushedLabel.setBorder(null);
            m_crushedLabel.setEnabled(false);
            addProperty(m_crushedLabel, m_crushed);
            m_torn = new JRadioButton();
            m_torn.setEnabled(false);
            damageGroup.add(m_torn);
            m_tornLabel = new JTextField("Torn");
            m_tornLabel.setEditable(false);
            m_tornLabel.setBorder(null);
            m_tornLabel.setEnabled(false);
            addProperty(m_tornLabel, m_torn);
            m_wet = new JRadioButton();
            m_wet.setEnabled(false);
            damageGroup.add(m_wet);
            m_wetLabel = new JTextField("Wet");
            m_wetLabel.setEditable(false);
            m_wetLabel.setBorder(null);
            m_wetLabel.setEnabled(false);
            addProperty(m_wetLabel, m_wet);
            m_noDamage = new JRadioButton();
            m_noDamage.setEnabled(true);
            damageGroup.add(m_noDamage);
            ButtonGroup fixGroup = new ButtonGroup();
            m_retaped = new JRadioButton();
            m_retaped.setEnabled(false);
            fixGroup.add(m_retaped);
            m_retapedLabel = new JTextField("Retaped");
            m_retapedLabel.setEditable(false);
            m_retapedLabel.setBorder(null);
            m_retapedLabel.setEnabled(false);
            addProperty(m_retapedLabel, m_retaped);
            m_rewraped = new JRadioButton();
            m_rewraped.setEnabled(false);
            fixGroup.add(m_rewraped);
            m_rewrapedLabel = new JTextField("Rewraped");
            m_rewrapedLabel.setEditable(false);
            m_rewrapedLabel.setBorder(null);
            m_rewrapedLabel.setEnabled(false);
            addProperty(m_rewrapedLabel, m_rewraped);
            m_noAction = new JRadioButton();
            m_noAction.setEnabled(false);
            m_noAction.setSelected(true);
            fixGroup.add(m_noAction);
            m_noActionLabel = new JTextField("No Damage Resolution");
            m_noActionLabel.setEditable(false);
            m_noActionLabel.setBorder(null);
            m_noActionLabel.setEnabled(false);
            addProperty(m_noActionLabel, m_noAction);
        }
    }

    private class ScanProperties extends PropertiesBase
    {

        public ScanProperties()
        {
            super("Scan Properties");
            m_awb = new JTextField("", 12);
            addProperty("AWB", m_awb);
            m_crn = new JCheckBox();
            m_crn.setSelected(false);
            addProperty("CRN", m_crn);
            m_cons = new JCheckBox();
            m_cons.setSelected(false);
            addProperty("CONS", m_cons);
            m_printerCode = new JTextField("PRTEST003", 8);
            addProperty("Printer Code", m_printerCode);
            m_user = new JTextField("364942", 6);
            addProperty("User Logon", m_user);
            m_location = new JTextField("NRT", 3);
            addProperty("Clearance Gateway", m_location);
            m_warehouse = new JTextField("CG3", 3);
            addProperty("Warehouse", m_warehouse);
            m_stageArea = new JTextField("ARR1", 6);
            addProperty("Stage Area", m_stageArea);
            m_detainLoc = new JTextField("Shelf 1", 10);
            addProperty("Detainment Location", m_detainLoc);
            m_huOid = new JTextField("0", 10);
            addProperty("Handling Unit Oid Number", m_huOid);
            m_HAWB = new JTextField("", 12);
            addProperty("HAWB", m_HAWB);
            m_HAWBUnknown = new JCheckBox();
            addProperty("HAWB Unknown", m_HAWBUnknown);
            m_shipOid = new JTextField("0", 10);
            addProperty("Shipment Oid Number", m_shipOid);
            String statList[] = {
                "00", "22", "32", "37", "44", "48", "53", "56", "57", "60", 
                "64", "65", "67", "68", "71", "72", "74"
            };
            m_statNbr = new JComboBox(statList);
            addProperty("Loc Stat Number", m_statNbr);
            m_consTag = new JTextField("", 12);
            addProperty("Cons Tag", m_consTag);
            m_shuttleID = new JTextField("", 12);
            addProperty("Shuttle ID", m_shuttleID);
            m_destLocationCode = new JTextField("COS", 5);
            addProperty("Dest LocationCode", m_destLocationCode);
            m_comments = new JTextField("", 15);
            addProperty("Comments", m_comments);
        }
    }

    private class ImportProperties extends PropertiesBase
    {

        public ImportProperties()
        {
            super("Import Properties");
            m_requestingProject = new JComboBox(new String[] { "MRS",
                                                               "CANADABROKR",
							       "SCAN_UPLOAD"});
            m_requestingProject.setEditable(true);
            addProperty("Requesting Project",m_requestingProject);
            m_requestedService = new JComboBox(new String[] { 
                "ADDINTERCEPT",   
                "ADDMASTERINT", 
                "ADDSHIPINT",     
                "DELINTERCEPT",   
                "DELMASTERINT",   
                "DELSHIPINT",     
                "addIntercept",   
                "addRIntercept",  
                "addRReasonCd",   
                "addRReleaseCd",  
                "addReasonCd",    
                "addReleaseCd",   
                "declared",       
                "delIntercept",   
                "delRIntercept",  
                "delRReasonCd",   
                "delRReleaseCd",  
                "delReasonCd",    
                "delReleaseCd",   
                "relIntercept",   
                "satIntercept",   
                "satRIntercept",  
                "undeclared",     
                "unrelIntercept",
                "SEND_COMMENT",});
            m_requestedService.setEditable(true);
            addProperty("Requested Service",m_requestedService);
                                               
            
            m_hawbSerialNumber = new JTextField("",2);
            addProperty("HAWB Serial Number",m_hawbSerialNumber);
            m_originLoc = new JTextField("",5);
            addProperty("Origin Location",m_originLoc);
            m_destLoc = new JTextField("",5);
            addProperty("Destination Location",m_destLoc);
            m_inputDate = new JTextField("",10);  // should be a JFormattedTextField ???
            addProperty("Input Date",m_inputDate);
            m_agencyCode = new JTextField("", 2);
            addProperty("Agency Code", m_agencyCode);
            m_interceptCode = new JTextField("", 3);
            addProperty("Intercept Code", m_interceptCode);
            m_reasonCode = new JTextField("",5);
            addProperty("Reason Code",m_reasonCode);
            m_releaseCode = new JTextField("",5);
            addProperty("Release Code",m_releaseCode);
            m_shipRemarkCode = new JTextField("",5);
            addProperty("Shipment Remark Code",m_shipRemarkCode);
            m_shipRemarkDesc = new JTextField("",10);
            addProperty("Shipment Remark Description",m_shipRemarkDesc);
            m_handInstCode = new JTextField("",5);
            addProperty("Handling Instruction Code",m_handInstCode);
            m_handInstDesc = new JTextField("",10);
            addProperty("Handling Instruction Description",m_handInstDesc);
            m_returnAWB = new JTextField("",12);
            addProperty("Return AWB",m_returnAWB);
            String actionList[] = {
                "A", "B", "D", "E", "S", "T", "Q", "U", "G", "H"
            };
            m_actionCode = new JComboBox(actionList);
            addProperty("Action Code", m_actionCode);
            m_activityCode = new JTextField("", 5);
            addProperty("Activity Code", m_activityCode);

            
            m_commentText = new JTextField("",30);
            addProperty("Comment Text",m_commentText);
            m_locStatNbr = new JTextField("",3); 
            addProperty("Loc Stat Nbr",m_locStatNbr);
        }
    }


    public CCIIScanClientInteractiveTest()
    {
        m_contentPane = null;
        m_buttonPane = null;
        m_scanPane = null;
        m_uploadPane = null;
        m_importPane = null;
        m_splitPane = null;
        m_splitPane2 = null;
        m_client = null;
        m_config = new Config("CCIIScanClientInteractiveTest");
        try
        {
            //            m_client = new CCIIScanClientWithLabelTiming();
            m_client = new CCIIScanClient();
        }
        catch(Exception e)
        {
            System.out.println("Failed to construct a CCIIScanClient():  " + e);
            e.printStackTrace(System.out);
            System.exit(-1);
        }
        initializeGUI();
    }

    protected String doImportMessage()
    {
        try
        {
        cciiasn.ddtran.ASNccii msg = createImportMessage();
        System.out.println("Created Message:  " + msg);
        JNDILookup lookup = new JNDILookup("CCIIScanClientInteractiveTest");
        
        CCIIImportHome home = (CCIIImportHome)lookup.lookupNarrow("ccii.import",CCIIImportHome.class);
        CCIIImport importEJB = (CCIIImport)javax.rmi.PortableRemoteObject.narrow(home.create(),CCIIImport.class);

        cciiasn.Cciiasn.initialize();
        Coder coder = cciiasn.Cciiasn.getBERCoder();
        coder.enableAutomaticDecoding();
        coder.enableAutomaticEncoding();
        coder.disableDecoderDebugging();
        coder.disableEncoderDebugging();
        coder.disableDecoderConstraints();
        coder.disableEncoderConstraints();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        coder.encode(msg,baos);

        byte retMsg[] = importEJB.processMessage(baos.toByteArray());

        ByteArrayInputStream sink = new ByteArrayInputStream(retMsg);

        cciiasn.ddtran.ASNccii retObject = new cciiasn.ddtran.ASNccii();	    

        retObject = (cciiasn.ddtran.ASNccii)coder.decode(sink,retObject);
        
        System.out.println("Import returned this message:  \n" + retObject);
        return retObject.toString();
        }
        catch(Exception e)
        {
            System.out.println("Failed to do import processing:  " + e);
            e.printStackTrace(System.out);
            return "Failed to do import processing:  " + e;
        }

    }

    private java.text.SimpleDateFormat m_dateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
    private java.text.SimpleDateFormat m_timeFormat = new java.text.SimpleDateFormat("HHmmss");


    protected cciiasn.ddtran.ASNccii createImportMessage()
    {
        cciiasn.ddtran.ASNccii retMsg = new cciiasn.ddtran.ASNccii();
        
        retMsg.setRequestingProj(new IA5String(m_requestingProject.getSelectedItem().toString()));
        retMsg.setRequestedSvc(new IA5String(m_requestedService.getSelectedItem().toString()));

        retMsg.setUserLogon(new IA5String(m_user.getText()));
        retMsg.setOrgCode(new IA5String("TEST"));
        retMsg.setInputDevice(new IA5String("TESTCLNT"));
        retMsg.setLocationCode(new IA5String(m_location.getText()));
        
        retMsg.setAirbillNumber(new IA5String(m_awb.getText()));
        retMsg.setDestLoc(new IA5String(m_destLoc.getText()));
        retMsg.setOriginLoc(new IA5String(m_originLoc.getText()));
        retMsg.setHandlingUnitOid(new IA5String(m_huOid.getText()));
        retMsg.setShipmentOid(new IA5String(m_shipOid.getText()));
        retMsg.setHawb(new IA5String(m_HAWB.getText()));
        retMsg.setHawbUnknownFlag(new IA5String((m_HAWBUnknown.isSelected() ? "T" : "F")));
        retMsg.setHawbSerialNbr(new IA5String(m_hawbSerialNumber.getText()));
        retMsg.setInputDate(new IA5String(m_inputDate.getText()));

        retMsg.setReasonCode(new IA5String(m_reasonCode.getText()));
        retMsg.setDetainLoc(new IA5String(m_detainLoc.getText()));
        retMsg.setReleaseCode(new IA5String(m_releaseCode.getText()));

        retMsg.setReturnHAWBNbr(new IA5String(m_returnAWB.getText()));
        retMsg.setHandlingInstrCode(new IA5String(m_handInstCode.getText()));
        retMsg.setHandlingInstrDesc(new IA5String(m_handInstDesc.getText()));
        retMsg.setShipmentRemarkCode(new IA5String(m_shipRemarkCode.getText()));
        retMsg.setShipmentRemarkDesc(new IA5String(m_shipRemarkDesc.getText()));

        retMsg.setCommentText(new IA5String(m_commentText.getText()));
        retMsg.setLocStatNbr(new IA5String(m_locStatNbr.getText()));

        // Missing components in RPBScan for:  returnHAWBNbr, handlingInstrCode, handlingInstrDesc,
        //                                     shipmentRemarkCode, shipmentRemarkDesc

        retMsg.setInterceptCode(new IA5String(m_interceptCode.getText()));
        retMsg.setAgencyCode(new IA5String(m_agencyCode.getText()));

        Date tranTime = new Date();
        long tranlong = tranTime.getTime();

        retMsg.setTransTimeStamp(new IA5String("" + (tranlong/1000)));

        retMsg.setStrTranDate(new IA5String(m_dateFormat.format(tranTime)));
        retMsg.setStrTranTime(new IA5String(m_timeFormat.format(tranTime)));

        retMsg.setErrorNumber(new IA5String("" + 0));
        retMsg.setReturnMessage(new IA5String(""));

        return retMsg;
    }

    private RPBScan getScanData()
    {
        RPBScan scan = new RPBScan();
        scan.setAirbillNumber(m_awb.getText());
        if(m_cons.isSelected())
        {
            scan.setAirbillFormType("0000");
            scan.setAirbillType("3");
        } else
        if(m_crn.isSelected())
        {
            scan.setAirbillFormType("0440");
            scan.setAirbillType("G");
        } else
        {
            scan.setAirbillFormType("0400");
            scan.setAirbillType("D");
        }
        scan.setUserLogon(m_user.getText());
        scan.setLocationCode(m_location.getText());
        scan.setWarehouseCode(m_warehouse.getText());
        scan.setStagingAreaCode(m_stageArea.getText());
        scan.setDetainLoc(m_detainLoc.getText());
        scan.setPrinterCode(m_printerCode.getText());
        scan.setHAWB(m_HAWB.getText());
        scan.setLocStatNbr((String)m_statNbr.getSelectedItem());
        scan.setConsId(m_consTag.getText());
        scan.setShuttleID(m_shuttleID.getText());
        scan.setInterceptCode(m_interceptCode.getText());
        scan.setAgencyCode(m_agencyCode.getText());
        scan.setActionCode((String)m_actionCode.getSelectedItem());
        scan.setDestLocationCode(m_destLocationCode.getText());
        scan.setComments(m_comments.getText());
        scan.setTransactionTimestamp(new Date());
        if(m_HAWBUnknown.isSelected())
            scan.setHAWBUnknownFlag("T");
        else
            scan.setHAWBUnknownFlag("F");
        try
        {
            scan.setHandlingUnitOid(Integer.parseInt(m_huOid.getText()));
        }
        catch(Exception e)
        {
            System.out.println("Invalid HandlingUnitOid Number format:  " + e);
            return null;
        }
        try
        {
            scan.setShipmentOid(Integer.parseInt(m_shipOid.getText()));
        }
        catch(Exception e)
        {
            System.out.println("Invalid ShipmentOid Number:  " + e);
            return null;
        }
        return scan;
    }

    private UploadStatus getUploadStatus()
    {
        if(!m_useUpload.isSelected())
        {
            return null;
        } else
        {
            UploadStatus upld = new UploadStatus();
            upld.setBondTransferFlag(m_bondTransfer.isSelected());
            upld.setDamagedFlag(m_damaged.isSelected());
            upld.setCrushedFlag(m_crushed.isSelected());
            upld.setTornFlag(m_torn.isSelected());
            upld.setWetFlag(m_wet.isSelected());
            upld.setRetapedFlag(m_retaped.isSelected());
            upld.setRewrappedFlag(m_rewraped.isSelected());
            upld.setWrongFlightFlag(m_wrongFlight.isSelected());
            upld.setFlightDelayFlag(m_flightDelay.isSelected());
            upld.setMissedShuttleFlag(m_missedShuttle.isSelected());
            return upld;
        }
    }

    private RPBScan runCorpScan(RPBScan scan, UploadStatus upload)
    {
        throw new RuntimeException("This dont work yet either");
    }

    private RPBScan runPostActivity(RPBScan scan)
        throws Exception
    {
        ActivitiesList alist = new ActivitiesList(m_activityCode.getText());
        return m_client.postActivity(scan, alist);
    }

    private void runScan(int scanType)
    {
        System.out.println("runScan(" + scanType + ")");
        int resultType = RPBSCAN;
        boolean boolresults = false;
        String stringResults = "";
        RPBScan scan = getScanData();
        UploadStatus upload = getUploadStatus();
        RPBScan retScn = null;
        try
        {
            switch(scanType)
            {
            case IPA:
            case BOND_IN: // '\001'
                retScn = m_client.doArrivalScan(scan, upload);
                break;                
            case DEP:
            case BOND_OUT: // '\002'
                retScn = m_client.doDepartureScan(scan, upload);
                break;

            case MOVE_OUT: // '\005'
                retScn = m_client.doMoveOutScan(scan, upload);
                break;

            case QUERY: // '\006'
                retScn = m_client.doQueryScan(scan, upload);
                break;

            case CORP: // '\007'
                retScn = runCorpScan(scan, upload);
                break;

            case BATCH_ADD: // '\b'
                retScn = m_client.doBatchAddScan(scan, upload);
                break;

            case BATCH_REM: // '\t'
                retScn = m_client.doBatchRemoveScan(scan, upload);
                break;
            case STI:
            case STAGE_IN: // '\n'
                retScn = m_client.doStageInScan(scan, upload);
                break;
            case STO:
            case STAGE_OUT: // '\013'
                retScn = m_client.doStageOutScan(scan, upload);
                break;

            case CLEARANCE_LABEL: // '\024'
                retScn = m_client.printClearanceLabel(scan);
                break;

            case SIP: // 'e'
            case SOP: // 'f'
            case HIP: // 'g'
            case HOP: // 'h'
            case RIP: // 'i'
            case ROP: // 'j'
            case STR:
            case SPS:
                stringResults = "Corporate Scans waiting for joey to workout the CCIIScanClient stuff";
                resultType = -102;
                break;

            case STAT: // 'k'
                retScn = m_client.doCorporateScan(scan);
                break;

            case CMT: // 'l'
                retScn = m_client.doCommentScan(scan);
                break;

            case IMPORT: // '\023'
                resultType = STRING;
                stringResults = doImportMessage();
                
//                 if(m_rpClient == null)
//                     try
//                     {
//                         m_rpClient = new RuleProcessorClient();
//                     }
//                     catch(Exception e)
//                     {
//                         System.out.println("Failed to construct a RuleProcessorClient:  " + e);
//                         e.printStackTrace(System.out);
//                         System.exit(-3);
//                     }
//                 scan.setInViewName("PCRFVIEW");
//                 retScn = m_rpClient.sendScan(scan);
                break;

            case GET_INTERCEPT_LIST: // '\025'
                GetCCIILookupBean glb = new GetCCIILookupBean();
                Lookup lookup = glb.getLookup(scan.getLocationCode());
                resultType = STRING;
                CCIIDataVector dv;
                if((dv = lookup.getActiveIntercepts(scan.getHandlingUnitOid(), scan.getLocationCode())) != null)
                {
                    Vector ints = dv.getData();
                    if(ints.isEmpty())
                        stringResults = "No Active Intercepts for Handling Unit Oid:  " + scan.getHandlingUnitOid();
                    else
                        stringResults = ints.toString();
                } else
                {
                    stringResults = "Lookup returned me a null CCIIDataVector";
                }
                glb.cleanupCCIILookup(lookup);
                break;

            case DOWNLOAD_FORMATS: // '\f'
                boolresults = m_client.downloadPrinterCodes(scan.getLocationCode(), scan.getPrinterCode());
                resultType = BOOLEAN;
                break;

            case POST_ACTIVITY: // '\r'
                runPostActivity(scan);
                break;

            case DUP_LABEL: // '\016'
                retScn = m_client.doDupLabel(scan);
                break;

            case PRINTER_ID_LABEL: // '\017'
                boolresults = m_client.printPrinterLabel(scan.getPrinterCode(), scan.getLocationCode());
                resultType = BOOLEAN;
                break;

            case STAGE_AREA_LABEL: // '\020'
                boolresults = m_client.printStageAreaLabel(scan.getPrinterCode(), scan.getWarehouseCode(), scan.getStagingAreaCode(), scan.getLocationCode());
                resultType = BOOLEAN;
                break;

            case WAREHOUSE_LABEL: // '\021'
                boolresults = m_client.printWarehouseLabel(scan.getPrinterCode(), scan.getWarehouseCode(), scan.getLocationCode());
                resultType = BOOLEAN;
                break;

            case DETAIN_LOC_LABEL: // '\022'
                throw new RuntimeException("This doesnt work yet either");

            case CAGE: // '\003'
                retScn = m_client.doCageScan(scan, upload);
                break;

            case MOVE_IN: // '\004'
                retScn = m_client.doMoveInScan(scan, upload);
                break;

            case EXIT: 
                exit();
                break;

            case RESET_CLIENT: 
                try
                {
                    m_config.reread();
                    String newWebAddr = ((String)m_webServerAddress.getSelectedItem()).trim() + ":" + ((String)m_webServerPort.getSelectedItem()).trim();
                    System.out.println("Setting WEB_SERVER_ADDRESS to " + newWebAddr);
                    m_config.setValue("ALL", "ALL", "WEB_SERVER_ADDRESS", newWebAddr);
                    //                    m_client.stopTimingThread();
                    //                    m_client = new CCIIScanClientWithLabelTiming();
                    m_client = new CCIIScanClient();
                    stringResults = "Client Reset Successfully\n\nWith WEB_SERVER_ADDRESS:  " + newWebAddr;
                    resultType = STRING;
                }
                catch(Exception e)
                {
                    System.out.println("Failed to reconstruct the scan client:  " + e);
                    e.printStackTrace(System.out);
                    System.exit(0);
                }
                break;

            case RESET_SERVER: 
                try
                {
                    RuleProcessorClientWithReset rpcwr = new RuleProcessorClientWithReset();
                    rpcwr.reset();
                }
                catch(Exception e)
                {
                    System.out.println("Caught an Exception while resetting the server:  " + e);
                    e.printStackTrace(System.out);
                    System.exit(-2);
                }
                stringResults = "Server Reset Successfully";
                resultType = STRING;
                // fall through
                break;

            default:
                System.out.println("Unsupported Scan");
                break;
            }
        }
        catch(Exception e)
        {
            System.out.println("Caught one of Steve's new Exceptions:  " + e);
            e.printStackTrace(System.out);
            resultType = STRING;
            stringResults = "Caught one of Steve's new Exceptions(But I know Joey put him up to it!!!):  " + e;
        }
        switch(resultType)
        {
        case RPBSCAN: 
            displayReturnScan(retScn);
            break;

        case BOOLEAN: 
            displayReturnBoolean(boolresults);
            break;

        case STRING: 
            displayReturnString(stringResults);
            break;
        }
    }

    private void displayReturnBoolean(boolean results)
    {
        String msg = null;
        if(results)
            msg = "Success";
        else
            msg = "Failure";
        displayReturnString(msg);
    }

    private void displayReturnString(String msg)
    {
        ReturnScanOutput out = new ReturnScanOutput(msg, null, false);
        out.setVisible(true);
    }

    private void displayReturnScan(RPBScan retScn)
    {
	if(retScn == null)
	{
	    displayReturnString("Server returned NULL scan object");
	}
	else
	{
	    MessageFormat mf = new MessageFormat();
	    String Header = "Finished with Scan:  " + retScn.getErrorNumber() + ":" + MessageFormat.errorMessage(retScn.getErrorNumber(), 0) + ":" + MessageFormat.errorMessage(retScn.getErrorNumber(), 1) + "\n\n";
	    String msg = Header;
	    ReturnScanOutput out = new ReturnScanOutput(msg, retScn, true);
	    out.setVisible(true);
	}
    }

    private void exit()
    {
        System.exit(0);
    }

    private void initButton(JPanel pane, String buttonName, final int scanCode)
    {
        JButton RunScan = new JButton(buttonName);
        RunScan.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                runScan(scanCode);
            }

        });
        pane.add(RunScan);
    }

    private JComponent initButtons()
    {
        JPanel scanPane = new JPanel();
        JPanel canadaPane = new JPanel();
        JPanel ctlPane = new JPanel();
        JPanel corpPane = new JPanel();
        JPanel labelPane = new JPanel();
        initButton(scanPane, "Bond-In", BOND_IN);
        initButton(scanPane, "Bond-Out", BOND_OUT);
        initButton(scanPane, "Cage", CAGE);
        initButton(scanPane, "Move-In", MOVE_IN);
        initButton(scanPane, "Query", QUERY);
        initButton(scanPane, "Dup Label", DUP_LABEL);
        initButton(scanPane, "Batch Add", BATCH_ADD);
        initButton(scanPane, "Batch Remove", BATCH_REM);
        initButton(scanPane, "Post Activity", POST_ACTIVITY);
        initButton(scanPane, "Import", IMPORT);
        initButton(scanPane, "Get Active Intercepts", GET_INTERCEPT_LIST);
        initButton(canadaPane, "IPA",IPA);
        initButton(canadaPane, "DEP",DEP);
        initButton(canadaPane, "STI",STI);
        initButton(canadaPane, "STO",STO);
        initButton(canadaPane, "STR",STR);
        initButton(canadaPane, "SPS",SPS);
        initButton(corpPane, "SIP", SIP);
        initButton(corpPane, "SOP", SOP);
        initButton(corpPane, "HIP", HIP);
        initButton(corpPane, "HOP", HOP);
        initButton(corpPane, "RIP", RIP);
        initButton(corpPane, "ROP", ROP);
        initButton(corpPane, "STAT", STAT);
        initButton(corpPane, "CMT", CMT);
        initButton(labelPane, "Download Formats", DOWNLOAD_FORMATS);
        initButton(labelPane, "Printer ID", PRINTER_ID_LABEL);
        initButton(labelPane, "Warehouse Label", WAREHOUSE_LABEL);
        initButton(labelPane, "Staging Area Label", STAGE_AREA_LABEL);
        initButton(labelPane, "Detain Loc Label", DETAIN_LOC_LABEL);
        initButton(labelPane, "Clearance Label", CLEARANCE_LABEL);
        String serverNames[] = {
            "ccsap19.rmtc.fedex.com", "ccsap12.rmtc.fedex.com", "ccsap13.rmtc.fedex.com", "cciiAp12Ap13.rmtc.fedex.com", "cciiAp12Ap19.rmtc.fedex.com", "lavender.apac.fedex.com"
        };
        String portNames[] = {
            "7061", "7120", "7180", "7199", "7200", "7305", "7315", "7325", "7335", "7345", 
            "7355", "7365", "7405", "7415", "7425", "7445", "7455", "7465", "7475"
        };
        m_webServerAddress = new JComboBox(serverNames);
        m_webServerAddress.setEditable(true);
        m_webServerPort = new JComboBox(portNames);
        m_webServerPort.setEditable(true);
        try
        {
            String currAddr = m_config.getValue("WEB_SERVER_ADDRESS");
            StringTokenizer tokens = new StringTokenizer(currAddr, ":");
            String currHost = tokens.nextToken();
            String currPort = tokens.nextToken();
            m_webServerAddress.setSelectedItem(currHost);
            m_webServerPort.setSelectedItem(currPort);
        }
        catch(Exception e)
        {
            System.out.println("Caught an excpetion trying to default the server address and port:  " + e);
        }
        ctlPane.add(m_webServerAddress);
        ctlPane.add(m_webServerPort);
        initButton(ctlPane, "Reset Client", RESET_CLIENT);
        initButton(ctlPane, "Reset Server", RESET_SERVER);
        initButton(ctlPane, "Exit", EXIT);
        JPanel retPane = new JPanel();
        retPane.setLayout(new GridLayout(0, 1));
        retPane.add(scanPane);
        retPane.add(canadaPane);
        retPane.add(corpPane);
        retPane.add(labelPane);
        retPane.add(ctlPane);
        return retPane;
    }

    private void initializeGUI()
    {
        m_contentPane = (JPanel)getContentPane();
        m_contentPane.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension((int)((double)screenSize.width * 0.90000000000000002D), (int)((double)screenSize.height * 0.69999999999999996D)));
        m_buttonPane = initButtons();
        m_contentPane.add(m_buttonPane, "South");
        m_scanPane = new JScrollPane(new ScanProperties());
        m_uploadPane = new JScrollPane(new UploadProperties());
        m_splitPane = new JSplitPane(1, m_scanPane, m_uploadPane);
        m_splitPane.setDividerLocation((int)((double)screenSize.width * 0.29999999999999999D));
        m_importPane = new JScrollPane(new ImportProperties());
        m_splitPane2 = new JSplitPane(1, m_splitPane, m_importPane);
        m_splitPane2.setDividerLocation((int)((double)screenSize.width * 0.59999999999999998D));
        m_contentPane.add(m_splitPane2, "Center");
    }

    public static void main(String args[])
    {
        CCIIScanClientInteractiveTest mframe = new CCIIScanClientInteractiveTest();
        mframe.setVisible(true);
    }

}
