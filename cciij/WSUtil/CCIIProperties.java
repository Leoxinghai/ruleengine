package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

import rmtc.util.Config;
import java.io.FileNotFoundException;
import cciij.businessActions.Messages;
import java.util.TimeZone;
import cciij.WSUtil.WSNotify;
import cciij.util.CCIILogException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.Date;

public class CCIIProperties implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CCIIProperties.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  protected static Config m_config = null;
  protected static WSNotify m_notify = new WSNotify("CCIIProperties");
  protected static long m_lastSystemResetTime = System.currentTimeMillis();
  protected static Date m_lastSystemResetDate = new Date(m_lastSystemResetTime);
  protected static long m_lastStaticInstanceResetTime = 0;
  protected static Date m_lastStaticInstanceResetDate = new Date(m_lastStaticInstanceResetTime);
  protected long m_lastInstanceResetTime = 0;
  protected Date m_lastInstanceResetDate = new Date(m_lastInstanceResetTime);

  public final static int NUM_LANG_SUPPORTED=4;
  public final static String SITE_LANGUAGE_NAMES[] = { "Language Names","ENGLISH","SPANISH","FRENCH","GERMAN"};

 public static final String TRACKING_NUMBER_TYPE = "TrackingNumberType";
 public static final String TRACKING_NUMBER_TYPE_AWB = "AWB";
 public static final String TRACKING_NUMBER_TYPE_CONS = "CONS";
 public static final String SHIPMENT_OR_PIECE_TYPE = "ShipOrPieceType";
 public static final String SHIPMENT_LEVEL_TYPE = "ShipmentLevel";
 public static final String PIECE_LEVEL_TYPE = "PieceLevel";

  public final static String ACCESS_CONTROL_ALL_ACCESS = "AllAccess";
  public final static String INPUT_DEVICE_NAME = "WORKSTATION_INPUT_DEVICE";
  public final static String INPUT_DEVICE_DEFAULT = "JavaWS";
  public final static String LOGIN_APP_CODE_NAME = "LOGIN_APP_CODE";
  public final static String LOGIN_APP_CODE_DEFAULT = "INT";
  public final static String CCII_INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";

  public static final int EJB_CODE_USES_NONE = 0;
  public static final int EJB_CODE_USES_REASON_CODE = 1;
  public static final int EJB_CODE_USES_RELEASE_CODE = 2;
  public static final int EJB_CODE_USES_DETAIN_LOC = 3;
  public static final int EJB_CODE_USES_INTERCEPT_CODE = 4;
  public static final int EJB_CODE_USES_PRINTER_ID = 5;
  public static final int EJB_CODE_USES_ROUTE_NBR = 6;
  public static final int EJB_CODE_USES_STAGING_AREA_CODE = 7;
  public static final int EJB_CODE_USES_REMARK_CODE = 8;
  public static final int EJB_CODE_USES_LOCSTAT_NUM = 9;
  public static final int EJB_CODE_USES_STAT37_DAMAGE = 10;
  public static final int EJB_CODE_USES_AGENCY = 11;
  public static final int EJB_CODE_USES_WHSE_CD = 12;
  public static final int EJB_CODE_USES_HANDLING_INSTRUCTION_CODE = 13;

  public static final int EJB_CODE2_USES_NONE = 0;
  public static final int EJB_CODE2_USES_AGENCY = 11;
  public static final int EJB_CODE2_USES_WHSE_CD = 12;


  public static final int EJB_TYPE_NO_PROCESS = 0;
  public static final int EJB_TYPE_RULE_PROCESSOR = 1;
  public static final int EJB_TYPE_JOLT_TUX = 2;
  public static final int EJB_TYPE_BOTH = 3;
  public static final int EJB_TYPE_MAX = 3;

  public static final int EJB_SINGLELINE_USE_NOTHING = 0;
  public static final int EJB_SINGLELINE_USE_DETAINMENT_LOC = 1;
  public static final int EJB_SINGLELINE_USE_COMMENTS = 2;
  public static final int EJB_SINGLELINE_USE_HAWB = 3;
  public static final int EJB_SINGLELINE_USE_CONSNUM = 4;
  public static final int EJB_SINGLELINE_USE_MDE_ROUTE_AND_COMMENTS = 5;
  public static final int EJB_SINGLELINE_USE_ASTRAY_AND_COMMENTS = 6;
  public static final int EJB_SINGLELINE_USE_FLTNUM_FLTDATE_AND_COMMENTS = 7;

  //session attribute names

  public final static String SESSION_LANGUAGE = "language";
  public final static String SESSION_USER_ATTRIB = "userAttrib";
  public final static String SESSION_RESULT_BEAN = "resultBean";
  public final static String SESSION_SCAN_OBJECT = "ScanObject";
  public final static String SESSION_CHOOSE_APP_BEAN = "chooseAppBean";
  public final static String SESSION_CHOOSE_SPECIFIC_BEAN = "chooseSpecificBean";
  public final static String SESSION_TOP_MENU_BEAN = "topMenu";
  public final static String SESSION_LEFT_MENU_INV_BEAN = "leftMenuInv";
  public final static String SESSION_LEFT_MENU_INT_BEAN = "leftMenuInt";
  public final static String SESSION_LEFT_MENU_INT_APAC_BEAN = "leftMenuIntAPAC";
  public final static String SESSION_LEFT_MENU_INT_US_BEAN = "leftMenuIntUS";
  public final static String SESSION_LEFT_MENU_REPORT_BEAN = "leftMenuReport";
  public final static String SESSION_PACKAGE_ARRIVAL_PRINTER = "Package Arrival Printer";
  public final static String SESSION_LEAVE_FACILITY_PRINTER = "Leave Facility Printer";
  public final static String SESSION_STAGE_OUT_PRINTER = "Stage Out Printer";
  public final static String SESSION_STAGE_OUT_STRIP_PRINTER = "Stage Out Strip Printer";
  public final static String SESSION_SESSION_EXPIRED = "SessionExpired";
  public final static String SESSION_NO_PERMISSION_BEAN = "noPermissionBean";
  public final static String SESSION_INPUT_BEAN = "inputBean";
  public final static String SESSION_CODE_DEFINITION = "codeDef";
  public final static String SESSION_CODE_DEFINITION2 = "codeDef2";
  public final static String SESSION_LOGIN_BEAN = "loginBean";
  public final static String SESSION_REPROCESS_ALL = "ReprocessAll";
  public final static String SESSION_CHOOSE_PRINTER = "ChoosePrinter";
  public final static String SESSION_CHOOSE_PRINTER_REDIRECT = "ChoosePrinterRedirect";
  public final static String SESSION_CHOOSE_STAGE_AREA = "ChooseStageArea";
  public final static String SESSION_CHOOSE_WHSE_CD = "ChooseWhseCd";
  public final static String SESSION_CHOOSE_STAGE_AREA_REDIRECT = "ChooseStageAreaRedirect";
  public final static String SESSION_STAGE_AREA_PICK_LIST_STAGE_AREA = "StageAreaPickListStageArea";
  public final static String SESSION_STAGE_AREA_PICK_LIST_WHSE_CODE = "StageAreaPickListWhseCd";
  public final static String SESSION_CHANGE_PASS_SUCCESS = "ChangePassSuccessBean";
  public final static String SESSION_ROUTE_EDIT = "RouteEditBean";
  public final static String SESSION_ROUTE_LEG = "RouteLeg";
  public final static String SESSION_ROUTE_BEAN = "RouteBean";
  public final static String SESSION_NEW_SORT_DATE = "NewSortDate";
  public final static String SESSION_NEW_STAGE_AREA = "NewStageArea";
  public final static String SESSION_STAGE_AREA_PICK_BEAN = "StageAreaPickBean";
  public final static String SESSION_REPROCESS_RESULT_STATE = "ReprocessResultState";
  public final static String SESSION_MAIN_FRAME_BEAN = "MainFrameBean";
  public final static String SESSION_LOGOUT_BEAN = "LogoutBean";
  public final static String SESSION_REPROCESS_ORIGINAL_SCREEN = "ReprocessOriginalScreen";
  public static final String SESSION_LEFT_MENU_PRINT_OPT_BEAN = "LeftMenuPrintOptionsJSPBean";
  public static final String SESSION_LEFT_MENU_CORP_SCANS_BEAN = "LeftMenuCorpScansJSPBean";
  //public static final String SESSION_LEFT_MENU_SECADMIN_BEAN = "LeftMenuSecurityAdminJSPBean";
  public static final String SESSION_SITE_LOCATION_CD = "SiteLocationCd";
  public static final String SESSION_AUTOLOGOUT_BEAN = "AutoLogoutBean";
  public static final String SESSION_CMT_PRINTER = "CMTPrinter";
  public static final String SESSION_RIP_PRINTER = "RIPPrinter";
  public static final String SESSION_ROP_PRINTER = "ROPPrinter";
  public static final String SESSION_SIP_PRINTER = "SIPPrinter";
  public static final String SESSION_SOP_PRINTER = "SOPPrinter";
  public static final String SESSION_HIP_PRINTER = "HIPPrinter";
  public static final String SESSION_HOP_PRINTER = "HOPPrinter";
  public static final String SESSION_STAT_PRINTER = "STATPrinter";
  public static final String SESSION_BONDIN_PRINTER = "BondInPrinter";
  public static final String SESSION_BONDOUT_PRINTER = "BondOutPrinter";
  public static final String SESSION_MOVEMENT_PRINTER = "MovementPrinter";
  public static final String SESSION_CAGE_PRINTER = "CagePrinter";
  public static final String SESSION_QUERY_PRINTER = "QueryPrinter";
  public static final String SESSION_RESET_FORM_ACTION = "ResetFormAction";
  public static final String SESSION_DETAINMENT_LOC_LABEL_PRINTER = "DetainmentLocLabelPrinter";

  public final static String AWB_INFO_NAMES[] = {"FormCode","Hawb","shipOid",
         "huOid","HawbUnknown","ErrorNumber","ScanName"};

  public final static String DEFAULT_DATE_FORMAT = "MMM d, yyyy";
  public final static String DEFAULT_TIME_FORMAT = "h:mm:ss a z";
  public static String DEFAULT_DATE_FORMAT_ERROR_LOG = "yyyy-MM-d HH:mm:ss";
  public static TimeZone LOCAL_TIME_ZONE = null;

  public final static int REPROCESSABLE_ERRORS [] = { Messages.EM_INVALID_AB,
    Messages.EM_AB_NOT_ALLOWD,Messages.EM_DUP_PIECE,Messages.EM_NEED_MSTR_AB,
    Messages.EM_REASON_CODE_REQD,Messages.EM_INV_REASON_CODE,
    Messages.EM_RELEASE_CODE_REQD,Messages.EM_INV_RELEASE_CODE,
    Messages.EM_DETAIN_LOC_REQD,Messages.EM_INV_HANDLING_CODE,
    Messages.EM_HANDLING_CD_REQD, Messages.EM_INV_REMARK_CODE,
    Messages.EM_REMARK_CODE_REQD,Messages.EM_FORM_ID_REQD,
    Messages.EM_INV_STAGE_AREA};


  public static boolean REQUEST_FORWARD_USES_CONTEXT_ROOT = false;
  public static String CONTEXT_ROOT_DEFAULT = "/ccii";
  public static String JNLPS_CONTEXT_ROOT_DEFAULT = "/";
  public static String JNLPS_PREFIX_DEFAULT="jnlps/";
  public static String JSP_PREFIX_DEFAULT= "/";
  //this is a JBuilder value if using the JBuilder server
  //public static String SERVLET_PREFIX_DEFAULT="/servlet/cciij.WSServlet.";
  public static String SERVLET_PREFIX_DEFAULT="/";

  public final static String RELAY_SERVLET_NAME = "RelayServlet";

  //GenericScan Settings
  public final static String GENERIC_SCAN_INPUT_PAGE_NAME = "GenericScanJSP.jsp";
  public static final String GENERIC_SCAN_NAME_NA = "N/A";
  public static final String GENERIC_VIEW_NAME_ENDING = "VIEW";

  //admin setting
  public final static String ADMIN_APPS_NAME = "adminapp.jnlp";
  public final static String ADMIN_ACTIVITY_SCREEN_ACCESS = "ADMN ACTDF";
  public final static String ADMIN_AGENCY_SCREEN_ACCSESS = "ADMN AGNCY";
  public final static String ADMIN_INTERCEPT_SCREEN_ACCESS = "ADMN INDEF";
  public final static String ADMIN_PRINTER_DEF_SCREEN_ACCESS = "ADMN PRCFG";
  public final static String ADMIN_SCAN_SCREEN_ACCESS = "ADMN SCNDF";
  public final static String ADMIN_SITE_PARAM_SCREEN_ACCESS = "ADMN SPARM";
  public final static String ADMIN_STAGING_AREA_SCREEN_ACCESS = "ADMN STGAR";
  public final static String ADMIN_WHSE_DEF_SCREEN_ACCESS = "ADMN WHSE";
  public final static String ADMIN_INTERCEPT_STAGING_SCREEN_ACCESS = "ADMN INTSA";
  public final static String ADMIN_AGENCY_STAGING_SCREEN_ACCESS = "ADMN AGTSA";
  public final static String ADMIN_SHUTTLE_SCREEN_ACCESS = "ADMN SHTL";
  public final static String ADMIN_UPLOAD_DEF_SCREEN_ACCESS = "ADMN UPLD";
  public final static String ADMIN_DETAINMENT_LOC_DEF_SCREEN_ACCESS = "ADMN DTNLC";

  //Login Settings
  public final static String LOGIN_NAME = "LoginServlet";
  public final static String LOGIN_DISPLAY_FORWARD_NAME = "LoginCCIIJSP.jsp";
  public final static String LOGIN_CHANGE_PASSWORD_SUCCESS_NAME = "ChangePasswordSuccessJSP.jsp";

  //logout Settings
  public final static String LOGOUT_NAME = "LogoutServlet";
  public final static String LOGOUT_SUCCESS_PAGE = "LogoutSuccessJSP.jsp";
  public final static boolean LOGOUT_LOADS_HOMEPAGE_DEFAULT = false;
  public final static String LOGOUT_LOADS_HOMEPAGE_NAME = "LOGOUT_LOADS_HOMEPAGE";
  public final static String LOGOUT_LOADS_LOGIN_PAGE = "LOGOUT_LOADS_LOGIN_PAGE";
  public final static boolean LOGOUT_LOADS_LOGIN_PAGE_DEFAULT = true;
  public final static String AUTOLOGOUT_NAME = "AutoLogoffJsp.jsp";

   //Main Frame Settings
  public final static String MAIN_FRAME_NAME = "MainFrameJsp.jsp";
  public final static String MAIN_FRAME_BLANK_PAGE = "BlankCCIIJSP.jsp";
  public final static String MAIN_FRAME_TOP_MENU = "TopMenuJsp.jsp";
  public final static String MAIN_FRAME_CONTENT = "ChooseApplicationJSP.jsp";
  public final static String MAIN_FRAME_CHOOSE_SPECIFIC = "ChooseSpecificFunctionJsp.jsp";

  //Result window settings
  public final static String RESULT_WINDOW_NAME = "ResultWindowServlet";
  public final static String RESULT_WINDOW_FORWARD_OUTPUT_PAGE = "ResultWindowJSP.jsp";

  //No permissions Settings
  public final static String NO_PERMISSION_FORWARD_DISPLAY = "NoPermissionJSP.jsp";

  //EmptyFields
  public final static String EMPTY_INPUT_FORWARD_DISPLAY = "EmptyInputsJsp.jsp";

  //Server unavailable settings
  public final static String SERVER_UNAVAILABLE_FORWARD_DISPLAY = "ServerUnavailableJSP.jsp";

  //Detainment In variables
  public static final String DETAINMENT_IN_SCREEN_ACCESS = "DIN";
  public static String DETAINMENT_IN_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String DETAINMENT_IN_FORM_ACTION_NAME = "DetainmentInServlet";
  public final static String DETAINMENT_IN_SCAN_PREFIX = "EFPA";

  //Detainment Out variables
  public static final String DETAINMENT_OUT_SCREEN_ACCESS = "DOUT";
  public final static String DETAINMENT_OUT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static String DETAINMENT_OUT_FORM_ACTION_NAME = "DetainmentOutServlet";
  public final static String DETAINMENT_OUT_SCAN_PREFIX = "EFDO";

  //Reason code variables
  public final static String REASON_FORM_ACTION_NAME = "ReasonCodeServlet";
  public final static String REASON_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static String REASON_SCAN_PREFIX = "EFREAC";
  public final static int REASON_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String REASON_CODE_SCREEN_ACCESS = "REAC";

  //Release code variables
  public final static String RELEASE_FORM_ACTION_NAME = "ReleaseCodeServlet";
  public final static String RELEASE_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static String RELEASE_SCAN_PREFIX = "EFRELC";
  public final static int RELEASE_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String RELEASE_CODE_SCREEN_ACCESS = "RELC";

  // Handling Instructions Variables.
  public final static String HI_FORM_ACTION_NAME = "HandlingInstructionServlet";
  public final static String HI_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int HI_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String HI_SCAN_PREFIX = "EFHI";
  public final static String HI_SCREEN_ACCESS = "HAND";

  // Shipment Remark Variables.
  public final static String SHIP_REMARK_FORM_ACTION_NAME = "ShipmentRemarkServlet";
  public final static String SHIP_REMARK_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int SHIP_REMARK_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String SHIP_REMARK_SCAN_PREFIX = "EFSR";
  public final static String SHIP_REMARK_SCREEN_ACCESS = "RMRK";

  //Detainment Location Settings
  public final static String DETAIN_LOC_FORM_ACTION_NAME = "DetainmentLocationServlet";
  public final static String DETAIN_LOC_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int DETAIN_LOC_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String DETAIN_LOC_SCAN_PREFIX = "DL";
  public final static String DETAIN_LOC_SCREEN_ACCESS = "RPL";

  //PackageStatus Settings
  public final static String PACKAGE_STATUS_FORM_ACTION_NAME = "PackageStatusServlet";
  public final static String PACKAGE_STATUS_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public final static String PACKAGE_STATUS_RULE_SET_NAME = "SPSVIEW_RULE_SET";
  public final static int PACKAGE_STATUS_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String PACKAGE_STATUS_SCAN_PREFIX = "SPS";

  public final static String PACKAGE_STATUS_SCREEN_ACCESS = "SPS";

  //PackageStageStatus Settings
  public final static String PACKAGE_STAGE_STATUS_FORM_ACTION_NAME = "PackageStageStatusServlet";
  public final static String PACKAGE_STAGE_STATUS_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int PACKAGE_STAGE_STATUS_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String PACKAGE_STAGE_STATUS_SCAN_PREFIX = "SPS";
  public final static String PACKAGE_STAGE_STATUS_SCREEN_ACCESS = "ISPS";

  //ReturnPackageToShipper Settings
  public final static String RETURN_PKG_SHIPPER_FORM_ACTION_NAME = "ReturnPackageToShipperServlet";
  public final static String RETURN_PKG_SHIPPER_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int RETURN_PKG_SHIPPER_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String RETURN_PKG_SHIPPER_SCAN_PREFIX = "RPS";
  public final static String RETURN_PKG_SHIPPER_SCREEN_ACCESS = "VO RS";

  //PackageArrival Settings
  public final static String PACKAGE_ARRIVAL_FORM_ACTION_NAME = "PackageArrivalServlet";
  public final static String PACKAGE_ARRIVAL_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int PACKAGE_ARRIVAL_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String PACKAGE_ARRIVAL_PREFIX = "IPA";
  public final static boolean PACKAGE_ARRIVAL_CODES_OPTIONAL_DEFAULT = true;
  public final static String PACKAGE_ARRIVAL_CODES_OPTIONAL_NAME = "PACKAGE_ARRIVAL_CODES_OPTIONAL";
  public final static String PACKAGE_ARRIVAL_SCREEN_ACCESS = "IPA";

  //StageInSettings
  public final static String STAGEIN_FORM_ACTION_NAME = "StageInServlet";
  public final static String STAGEIN_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int STAGEIN_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAGEIN_SCAN_PREFIX = "STI";
  public final static String STAGEIN_SCREEN_ACCESS = "STI";

  //StageOut Settings
  public final static String STAGEOUT_FORM_ACTION_NAME = "StageOutServlet";
  public final static String STAGEOUT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int STAGEOUT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAGEOUT_SCAN_PREFIX = "STO";
  public final static String STAGEOUT_SCREEN_ACCESS = "STO";

  //StageOutStrip Settings
  public final static String STAGEOUTSTRIP_FORM_ACTION_NAME = "StageOutStripServlet";
  public final static String STAGEOUTSTRIP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int STAGEOUTSTRIP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAGEOUTSTRIP_SCAN_PREFIX = "STR";
  public final static String STAGEOUTSTRIP_SCREEN_ACCESS = "STR";

  //Leave Facility Settings
  public final static String LEAVE_FACILITY_FORM_ACTION_NAME = "LeaveFacilityServlet";
  public final static String LEAVE_FACILITY_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int LEAVE_FACILITY_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String LEAVE_FACILITY_SCAN_PREFIX = "DEP";
  public final static String LEAVE_FACILITY_SCREEN_ACCESS = "DEP";

  //StageAreaPickList Settings
  public final static String STAGE_AREA_PICK_FORM_ACTION_NAME = "StageAreaPickListServlet";
  public final static String STAGE_AREA_PICK_INPUT_PAGE_NAME = "StageAreaPickListJSP.jsp";
  //public final static String STAGE_AREA_PICK_VIEW_NAME = "";
  public final static int STAGE_AREA_PICK_EJB_TYPE = EJB_TYPE_NO_PROCESS;
  public final static String STAGE_AREA_PICK_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String STAGE_AREA_PICK_SCAN_PREFIX = "RPBINTERCPT";
  public final static String STAGE_AREA_PICK_SCREEN_ACCESS = "SSTAT";

  //StageAreaPick Choose Settings
  //public final static String STAGE_AREA_PICK_CHOOSE_VIEW_NAME = "SPSVIEW";
  //need to see if this variable can be made to follow the convention
  //public final static String STAGE_AREA_PICK_CHOOSE_RULE_SET_NAME = "STAGE_AREA_PICK_CHOOSE_RULE_SET";
  public final static int STAGE_AREA_PICK_CHOOSE_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAGE_AREA_PICK_CHOOSE_SCAN_NAME = "SPS";

  //PackageHistory Settings
  public final static String PACKAGE_HISTORY_FORM_ACTION_NAME = "PackageHistoryServlet";
  public final static String PACKAGE_HISTORY_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public static String PACKAGE_HISTORY_RULE_SET = "STEVETEST";
  //public static String PACKAGE_HISTORY_VIEW_NAME = "SPSVIEW";
  public final static int PACKAGE_HISTORY_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String PACKAGE_HISTORY_SCAN_NAME = "SPS";

  public final static String PACKAGE_HISTORY_SCREEN_ACCESS = "HIST";

  //Route Maint settings
  public final static String ROUTE_MAINT_FORM_ACTION_NAME = "RouteMaintenanceServlet";;
  public final static String ROUTE_MAINT_INPUT_PAGE_NAME = "RouteMaintenanceJSP.jsp";
  public final static String ROUTE_MAINT_OID_TYPE = "R";
  public final static String ROUTE_MAINT_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String ROUTE_MAINT_SCREEN_ACCESS = "ROUTE";

  //Route Maint APAC settings
  public final static String ROUTE_MAINT_APAC_FORM_ACTION_NAME = "RouteMaintenanceAPACServlet";;
  public final static String ROUTE_MAINT_APAC_INPUT_PAGE_NAME = "RouteMaintenanceAPACJsp.jsp";
  public final static String ROUTE_MAINT_APAC_OID_TYPE = "R";
  public final static String ROUTE_MAINT_APAC_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String ROUTE_MAINT_APAC_SCREEN_ACCESS = "ROUTE";

  //Route Edit Settings
  public final static String ROUTE_EDIT_FORM_ACTION_NAME = "RouteEditServlet";
  public final static String ROUTE_EDIT_INPUT_PAGE_NAME = "RouteEditJSP.jsp";
  //public final static String ROUTE_EDIT_RULE_SET_NAME = "POST_ACTIVITY_RULE_SET";
  public final static String ROUTE_EDIT_SCAN_PREFIX = "ROUTE_EDIT_";
  public final static int ROUTE_EDIT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String ROUTE_EDIT_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String ROUTE_EDIT_SCREEN_ACCESS = "ROUTE";

  //Route Edit US Settings
  public final static String ROUTE_EDIT_US_FORM_ACTION_NAME = "RouteEditUSServlet";
  public final static String ROUTE_EDIT_US_INPUT_PAGE_NAME = "RouteEditUSJsp.jsp";
  //public final static String ROUTE_EDIT_US_RULE_SET_NAME = "POST_ACTIVITY_RULE_SET";
  public final static String ROUTE_EDIT_US_SCAN_PREFIX = "ROUTE_EDIT_";
  public final static int ROUTE_EDIT_US_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String ROUTE_EDIT_US_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String ROUTE_EDIT_US_SCREEN_ACCESS = "ROUTE";
  public final static String ROUTE_EDIT_US_SCREEN_CUSTOMS_ACCESS = "RTE_CUSTOMS";
  public final static String ROUTE_EDIT_US_SCREEN_BROKER_ACCESS = "RTE_BROKER";
  public final static String ROUTE_EDIT_US_SCREEN_ROUTE_ACCESS = "RTE_ROUTE";

  //Route Edit APAC Settings
  public final static String ROUTE_EDIT_APAC_FORM_ACTION_NAME = "RouteEditAPACServlet";
  public final static String ROUTE_EDIT_APAC_INPUT_PAGE_NAME = "RouteEditAPACJsp.jsp";
  //public final static String ROUTE_EDIT_APAC_RULE_SET_NAME = "POST_ACTIVITY_RULE_SET";
  public final static String ROUTE_EDIT_APAC_SCAN_PREFIX = "ROUTE_EDIT_";
  public final static int ROUTE_EDIT_APAC_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String ROUTE_EDIT_APAC_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String ROUTE_EDIT_APAC_SCREEN_ACCESS = "ROUTE";

  //Reset Servlet
  public final static String RESET_FORM_ACTION_NAME = "ResetServlet";
  public final static String RESET_INPUT_PAGE_NAME = "ResetJsp.jsp";
  public final static String RESET_SCREEN_ACCESS = "RESET";

  //public static String POST_ACTIVITY_RULE_SET;

  //Manipulate Intercepts Settings
  public final static String MANIPULATE_INTERCEPT_FORM_ACTION_NAME = "ManipulateInterceptServlet";
  public final static String MANIPULATE_INTERCEPT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //need to change this to match naming convention
  //public final static String MANIPULATE_INTERCEPT_RULE_SET_NAME = "MASS_ENTRY_INTERCEPT_RULESET";
  public final static int MANIPULATE_INTERCEPT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public static String MANIPULATE_INTERCEPT_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  //need to change this to match naming convention
  //public final static String MANIPULATE_INTERCEPT_VIEW_NAME = "MASS_ENTRY_INTERCEPT";
  public final static String MANIPULATE_INTERCEPT_SCREEN_ACCESS = "MANINT";

  //regulatory Release Settings
  public final static String REGULATOR_RELEASE_FORM_ACTION_NAME = "RegulatoryReleaseServlet";;
  public final static String REGULATOR_RELEASE_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public static String REGULATOR_RELEASE_RULE_SET;
  public final static int REGULATOR_RELEASE_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String REGULATOR_RELEASE_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  //public static String REGULATOR_RELEASE_VIEW_NAME = "";
  public final static int REGULATOR_RELEASE_AWB_NUM_MAX = 1;
  public final static int REGULATOR_RELEASE_SINGLE_LINE_NUM_MAX = 1;
  public final static int REGULATOR_RELEASE_SINGLE_LINE_SIZE = 12;
  public final static String REGULATOR_RELEASE_SCREEN_ACCESS = "REGREL";


  //Choose Sort Date Settings
  public final static String CHOOSE_SORT_FORM_ACTION_NAME = "ChooseSortDateServlet";
  public final static String CHOOSE_SORT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public final static String CHOOSE_SORT_RULE_SET = "NONE";
  public final static int CHOOSE_SORT_EJB_TYPE = EJB_TYPE_NO_PROCESS;
  public final static String CHOOSE_SORT_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String CHOOSE_SORT_SCREEN_ACCESS = ACCESS_CONTROL_ALL_ACCESS;


  //ChoosePrinter Settings
  public final static String CHOOSE_PRINTER_FORM_ACTION_NAME = "ChoosePrinterServlet";
  public final static String CHOOSE_PRINTER_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public final static String CHOOSE_PRINTER_RULE_SET = "NONE";
  public final static int CHOOSE_PRINTER_EJB_TYPE = EJB_TYPE_NO_PROCESS;
  public final static String CHOOSE_PRINTER_SCAN_NAME = GENERIC_SCAN_NAME_NA;
  public final static String CHOOSE_PRINTER_SCREEN_ACCESS = ACCESS_CONTROL_ALL_ACCESS;

  //ChooseStageArea Settings
  public final static String CHOOSE_STAGE_AREA_FORM_ACTION_NAME = "ChooseStageAreaServlet";
  public final static String CHOOSE_STAGE_AREA_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  //public final static String CHOOSE_STAGE_AREA_RULE_SET = "NONE";
  public final static int CHOOSE_STAGE_AREA_EJB_TYPE  = EJB_TYPE_NO_PROCESS;
  public final static String CHOOSE_STAGE_AREA_SCAN_NAME = GENERIC_SCAN_NAME_NA;

  public final static String CHOOSE_STAGE_AREA_SCREEN_ACCESS = ACCESS_CONTROL_ALL_ACCESS;


  //AssociateCRN
  public final static String ASSOCIATE_CRN_FORM_ACTION_NAME = "AssociateCRNServlet";
  public final static String ASSOCIATE_CRN_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int ASSOCIATE_CRN_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  //public final static String ASSOCIATE_CRN_RULESET_NAME = "ASSOCIATE_CRN_RULE_SET";
  public final static String ASSOCIATE_CRN_SCAN_PREFIX = "CRN";
  public final static String ASSOCIATE_CRN_SCREEN_ACCESS = "ASCRN";


  //reprocess settings
  public final static String REPROCESS_DECIDE_FORM_ACTION_NAME = "ReprocessDecideServlet";
  public final static String REPROCESS_DECIDE_INPUT_PAGE_NAME = "ReprocessJsp.jsp";
  public final static String REPROCESS_COMPLETE_INPUT_PAGE_NAME = "ReprocessCompleteJsp.jsp";
  public final static String REPROCESS_UNABLE_INPUT_PAGE_NAME = "ReprocessUnableJsp.jsp";
  public final static String REPROCESS_DUPLICATE_INPUT_PAGE = "ReprocessDupJsp.jsp";
  public final static String REPROCESS_PROCESS_FORM_ACTION_NAME = "ReprocessProcessServlet";

  //LeftMenuInventory Settings
  public final static String LEFT_MENU_INV_NAME =  "LeftMenuInventoryJSP.jsp";
  //LeftMenuIntercept Settings
  public final static String LEFT_MENU_INT_NAME = "LeftMenuInterceptJSP.jsp";
  public final static String WORKSTATION_DISPLAY_LAYOUT = "WORKSTATION_DISPLAY_LAYOUT";
  //LeftMenuInterceptAPAC Settings
  public final static String LEFT_MENU_INT_APAC_NAME = "LeftMenuInterceptAPACJsp.jsp";
  public final static String LEFT_MENU_INT_US_NAME = "LeftMenuInterceptUSJSP.jsp";


  //Detainment Loc Label
  public static final String DETAINMENT_LOC_LABEL_SCREEN_ACCESS = "DETL";
  public static final String DETAINMENT_LOC_LABEL_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String DETAINMENT_LOC_LABEL_FORM_ACTION_NAME = "DetainmentLocLabelServlet";
  public final static int DETAINMENT_LOC_LABEL_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String DETAINMENT_LOC_LABEL_PREFIX = "DETL";

  //Download Formats
  public static final String DOWNLOAD_FORMATS_SCREEN_ACCESS = "DNLD";
  public static final String DOWNLOAD_FORMATS_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String DOWNLOAD_FORMATS_FORM_ACTION_NAME = "DownloadFormatsServlet";
  public final static int DOWNLOAD_FORMATS_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String DOWNLOAD_FORMATS_PREFIX = "DNLD";
  public final static String DOWNLOAD_FORMAT_EXCEPTION_ALL = "AllPrinters";

  //Printer ID Label
  public static final String PRINTERID_LABEL_SCREEN_ACCESS = "PTRL";
  public static final String PRINTERID_LABEL_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String PRINTERID_LABEL_FORM_ACTION_NAME = "PrinterIDLabelServlet";
  public final static int PRINTERID_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String PRINTERID_PREFIX = "PTRL";
  public final static String PRINTERID_EXCEPTION_ALL = "AllPrinters";

  //Stage Area ID Label
  public static final String STAGEAREAID_LABEL_SCREEN_ACCESS = "STGL";
  public static final String STAGEAREAID_LABEL_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String STAGEAREAID_LABEL_FORM_ACTION_NAME = "StageAreaIDLabelServlet";
  public final static int STAGEAREAID_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAGEAREAID_PREFIX = "STGL";
  public static final String SESSION_STAGEAREAID_PRINTER = "StageAreaIdPrinter";
  public static final String STAGEAREAID_EXCEPTION_ALL = "ALLStageAreas";

  //Warehouse ID Label
  public static final String WHSEID_LABEL_SCREEN_ACCESS = "WHLB";
  public static final String WHSEID_LABEL_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String WHSEID_LABEL_FORM_ACTION_NAME = "WarehouseIDLabelServlet";
  public final static int WHSEID_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String WHSEID_PREFIX = "WHLB";
  public static final String SESSION_WHSEID_PRINTER = "WarehouseIDPrinter";
  public static final String WHSEID_EXCEPTION_ALL = "AllWarehouses";


 //Left Menu Printer Options Settings
  public static final String LEFT_MENU_PRINTOPT_NAME = "LeftMenuPrinterOptionsJSP.jsp";

  //Left Menu Corporate Scans Settings
  public static final String LEFT_MENU_CORPSCANS_NAME = "LeftMenuCorpScansJSP.jsp";

  //Comment Scan
  public static final String CMT_SCREEN_ACCESS = "CMT";
  public static final String CMT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String CMT_FORM_ACTION_NAME = "CorpCMTServlet";
  public static final int CMT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public static final String CMT_SCAN_PREFIX = "CMT";

  //CONS Scan
  public static final String CONS_SCREEN_ACCESS = "CONS";
  public static final String CONS_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String CONS_FORM_ACTION_LOCATION = "CONSServlet";
  public final static int CONS_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public static String CONS_SCAN_PREFIX = "CONS";

  //DCON Scan
  public static final String DCON_SCREEN_ACCESS = "DCON";
  public final static String DCON_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;;
  public final static String DCON_FORM_ACTION_LOCATION = "DCONServlet";
  public final static int DCON_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String DCON_SCAN_PREFIX = "DCON";

  // HIP Scan
  public static final String HIP_SCREEN_ACCESS = "HIP";
  public static final String HIP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String HIP_FORM_ACTION_NAME = "CorpHIPServlet";
  public final static int HIP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String HIP_SCAN_PREFIX = "HIP";

  // HOP Scan
  public static final String HOP_SCREEN_ACCESS = "HOP";
  public static final String HOP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String HOP_FORM_ACTION_NAME = "CorpHOPServlet";
  public final static int HOP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String HOP_SCAN_PREFIX = "HOP";

  // RIP Scan
  public static final String RIP_SCREEN_ACCESS = "RIP";
  public static final String RIP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String RIP_FORM_ACTION_NAME = "CorpRIPServlet";
  public final static int RIP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String RIP_SCAN_PREFIX = "RIP";

  // ROP Scan
  public static final String ROP_SCREEN_ACCESS = "ROP";
  public static final String ROP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String ROP_FORM_ACTION_NAME = "CorpROPServlet";
  public final static int ROP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String ROP_SCAN_PREFIX = "ROP";

  // SIP Scan
  public static final String SIP_SCREEN_ACCESS = "SIP";
  public static final String SIP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String SIP_FORM_ACTION_NAME = "CorpSIPServlet";
  public final static int SIP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String SIP_SCAN_PREFIX = "SIP";

  // SOP Scan
  public static final String SOP_SCREEN_ACCESS = "SOP";
  public static final String SOP_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public static final String SOP_FORM_ACTION_NAME = "CorpSOPServlet";
  public final static int SOP_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String SOP_SCAN_PREFIX = "SOP";

  // STAT Scan
  public final static String STAT_SCREEN_ACCESS = "STAT";
  public final static String STAT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static String STAT_FORM_ACTION_NAME = "CorpSTATServlet";
  public final static int STAT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String STAT_SCAN_PREFIX = "STAT";

  //STAT37 Scan
  public static final String STAT37_FORM_ACTION_NAME = "CorpSTAT37Servlet";
  // STAT6877 Scan
  public final static String STAT6877_FORM_ACTION_NAME = "CorpSTAT6877Servlet";
  // STAT69 Scan
  public final static String STAT69_FORM_ACTION_NAME = "CorpSTAT69Servlet";
  // STAT8590 Scan
  public final static String STAT8590_FORM_ACTION_NAME = "CorpSTAT8590Servlet";

  //BondIn Settings
  public final static String BONDIN_FORM_ACTION_NAME = "BondInServlet";
  public final static String BONDIN_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int BONDIN_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String BONDIN_PREFIX = "BIN";
  public final static String BONDIN_SCREEN_ACCESS = "BIN";
  public final static String BONDIN_DAMAGED = "Damaged";
  public final static String BONDIN_WRONG_FLIGHT = "WrongFlight";
  public final static String BONDIN_FLIGHT_DELAYED = "FlightDelayed";

  //BondOut Settings
  public final static String BONDOUT_FORM_ACTION_NAME = "BondOutServlet";
  public final static String BONDOUT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int BONDOUT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String BONDOUT_PREFIX = "BOUT";
  public final static String BONDOUT_SCREEN_ACCESS = "BOUT";
  public final static String BONDOUT_MISSED_SHUTTLE = "MissedShuttle";

  //Movement Settings
  public final static String MOVEMENT_FORM_ACTION_NAME = "MovementServlet";
  public final static String MOVEMENT_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int MOVEMENT_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String MOVEMENT_PREFIX = "MOVE";
  public final static String MOVEMENT_SCREEN_ACCESS = "MOVE";

  //Cage Settings
  public final static String CAGE_FORM_ACTION_NAME = "CageServlet";
  public final static String CAGE_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int CAGE_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String CAGE_PREFIX = "CAGE";
  public final static String CAGE_SCREEN_ACCESS = "CAGE";

  //Query Settings
  public final static String QUERY_FORM_ACTION_NAME = "QueryServlet";
  public final static String QUERY_INPUT_PAGE_NAME = GENERIC_SCAN_INPUT_PAGE_NAME;
  public final static int QUERY_EJB_TYPE = EJB_TYPE_RULE_PROCESSOR;
  public final static String QUERY_PREFIX = "QRY";
  public final static String QUERY_SCREEN_ACCESS = "QRY";

  //LeftMenuReports Settings
  public final static String REPORTS_NOT_HERE_NAME = "ReportsNotHereJSP.jsp";

  public final static String CCII_WS_CONNECT_TESTING_NAME = "CCII_WS_CONNECT_TESTING";
  public final static boolean CCII_WS_CONNECT_TESTING_DEFAULT = false;
  public final static String CCII_WS_CONNECT_TESTING_LOGIN = "CCIITest";
  public final static String CCII_WS_CONNECT_TESTING_PASSWORD = "aaaaa";
  public final static String CCII_WS_CONNECT_TESTING_ORGCODE = "TempOrg";
  public final static boolean USE_BACKGROUND_IMAGE_DEFAULT = false;
  public final static String BACKGROUND_IMAGE_DEFAULT = "http://localhost:8080/images/grey.gif";
  public final static boolean USE_BACKGROUND_COLOR_DEFAULT = false;
  public final static boolean BACKGROUND_IS_RGB_DEFAULT = false;
  public final static String BACKGROUND_COLOR_DEFAULT = "gray";
  public final static String INACTIVE_LINK_COLOR_NAME = "INACTIVE_LINK_COLOR";
  public final static String INACTIVE_LINK_COLOR_DEFAULT = "gray";


  public static final String NO_PRINTER_DEFINED_CODE = "none";
  public static final String NO_PRINTER_DEFINED_DESC = "No Printer Defined";
  public static final String CONTEXT_GETTING_PRINTER = "Getting Printer";

  public static final String ALL_STAGE_AREA_DEFINED_CODE = "ALL";
  public static final String ALL_STAGE_AREA_DEFINED_DESC = "All Stage areas";

  public static String WS_ERROR_PROPERTIES_TIMEZONE = "207001";
  public static String WS_ERROR_PROPERTIES_DEFAULT_LANG = "207002";
  public static String WS_ERROR_PROPERTIES_READ_PROPERTIES = "207003";
  public static String WS_ERROR_PROPERTIES_NUMBER_FORMAT = "207004";
  public static String WS_ERROR_CODE_DEF_INIT_LOOKUP_BEAN_HOME = "207005";
  public static String WS_ERROR_CODE_DEF_REINIT_LOOKUP_BEAN_HOME = "307006";
  public static String WS_ERROR_CODE_DEF_CREATE_LOOKUP = "307007";
  public static String WS_ERROR_CODE_DEF_REMOTE_ERROR = "307008";
  public static String WS_ERROR_CODE_DEF_EMPTY_DATA = "207009";
  public static String WS_ERROR_CODE_DEF_NULL_DATA = "207010";
  public static String WS_ERROR_CODE_DEF_NO_ELEMENT = "207011";
  public static String WS_ERROR_CODE_DEF_WRONG_DATA_TYPE = "207012";
  public static String WS_ERROR_LOOKUP_EJB_CLEANUP = "207013";
  public static String WS_ERROR_DUP_HU_INIT_LOOKUP_BEAN_HOME = "207014";
  public static String WS_ERROR_DUP_HU_REINIT_LOOKUP_BEAN_HOME = "307015";
  public static String WS_ERROR_DUP_HU_CREATE_LOOKUP = "307016";
  public static String WS_ERROR_DUP_HU_REMOTE_ERROR = "307017";
  public static String WS_ERROR_DUP_HU_EMPTY_DATA = "207018";
  public static String WS_ERROR_DUP_HU_NULL_DATA = "207019";
  public static String WS_ERROR_DUP_HU_NO_ELEMENT = "207020";
  public static String WS_ERROR_DUP_HU_WRONG_DATA_TYPE = "207021";
  public static String WS_ERROR_EJBPROC_INIT_RULEPROC_BEAN_HOME = "207022";
  public static String WS_ERROR_EJBPROC_REINIT_RULEPROC_BEAN_HOME = "307023";
  public static String WS_ERROR_EJBPROC_CREATE_RULEPROC = "307024";
  public static String WS_ERROR_EJBPROC_RULEPROC_REMOTE_ERROR = "307025";
  public static String WS_ERROR_RULEPROC_EJB_CLEANUP = "307026";
  public static String WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME = "207027";
  public static String WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME = "307028";
  public static String WS_ERROR_EJBPROC_CREATE_LOOKUP = "307029";
  public static String WS_ERROR_MULTIPLE_EJB_CLEANUP = "307030";
  public static String WS_ERROR_JOLT_TUX_EJB_CLEANUP = "307031";
  public static String WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME = "207032";
  public static String WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME = "307033";
  public static String WS_ERROR_EJBPROC_CREATE_JOLTTUX = "307034";
  public static String WS_ERROR_EJBPROC_CONS = "307035";
  public static String WS_ERROR_EJBPROC_UNKNOWN_TRACK_TYPE = "307036";
  public static String WS_ERROR_EJBPROC_NULL_RULEPROC = "307037";
  public static String WS_ERROR_UNKNOWN_EJBTYPE = "307038";
  public static String WS_ERROR_EJBPROC_ROUTE_ACTIVITY = "207039";
  public static String WS_ERROR_EJBPROC_UNKNOWN_EJBCODE = "307040";
  public static String WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE = "107041";
  public static String WS_ERROR_ROUTE_MAINT_INIT_LOOKUP_BEAN_HOME = "207042";
  public static String WS_ERROR_ROUTE_MAINT_REINIT_LOOKUP_BEAN_HOME = "307043";
  public static String WS_ERROR_ROUTE_MAINT_CREATE_LOOKUP = "307044";
  public static String WS_ERROR_ROUTE_MAINT_REMOTE_ERROR = "307045";
  public static String WS_ERROR_ROUTE_MAINT_NULL_DATA = "307046";
  public static String WS_ERROR_ROUTE_MAINT_EMPTY_DATA = "107047";
  public static String WS_ERROR_ROUTE_MAINT_WRONG_DATA_TYPE = "307048";
  public static String WS_ERROR_STAGE_PICK_REMOTE_ERROR = "307049";
  public static String WS_ERROR_STAGE_PICK_WRONG_DATA_TYPE = "207050";
  public static String WS_ERROR_STAGE_PICK_READ_FORM = "207051";
  public static String WS_ERROR_GENERIC_READ_FORM = "207052";
  public static String WS_ERROR_REDIRECT_ERROR = "207053";
  public static String WS_ERROR_ROUTE_MAINT_READ_FORM = "207054";
  public static String WS_ERROR_PARSE_SORT_DATE = "307055";
  public static String WS_ERROR_DEFAULT_SORT_DATE = "107056";
  public static String WS_ERROR_MAIN_FRAME_JSP_BEAN_NULL = "107057";
  public static String WS_ERROR_ROUTE_EDIT_READ_FORM = "207058";
  public static String WS_ERROR_ROUTE_EDIT_REMOTE_ERROR = "307059";
  public static String WS_ERROR_ROUTE_EDIT_NO_ACTIVITY_CODE = "107060";
  public static String WS_ERROR_ROUTE_EDIT_NULL_DATA = "307061";
  public static String WS_ERROR_ROUTE_EDIT_NO_CHANGED = "107062";
  public static String WS_ERROR_RESULT_WINDOW_READ_FORM = "207063";
  public static String WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME = "207064";
  public static String WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME = "307065";
  public static String WS_ERROR_LOGIN_CREATE_SECURITY = "307066";
  public static String WS_ERROR_LOGIN_REMOTE_ERROR = "307067";
  public static String WS_ERROR_LOGIN_READ_FORM = "207068";
  public static String WS_ERROR_SECURITY_REMOVE = "207069";
  public static String WS_ERROR_LOGIN_USER_NULL = "307070";
  public static String WS_ERROR_LOGOUT_INIT_SECURITY_BEAN_HOME = "207071";
  public static String WS_ERROR_LOGOUT_REMOTE_ERROR = "207072";
  public static String WS_ERROR_LOGOUT_REINIT_SECURITY_BEAN_HOME = "207073";
  public static String WS_ERROR_LOGOUT_CREATE_SECURITY = "207074";
  public static String WS_ERROR_PACKAGE_HIST_CREATE_LOOKUP = "307075";
  public static String WS_ERROR_PACKAGE_HIST_NULL_DATA = "307076";
  public static String WS_ERROR_PACKAGE_HIST_EMPTY_DATA = "207077";
  public static String WS_ERROR_PACKAGE_HIST_REMOTE_ERROR = "207078";
  public static String WS_ERROR_PACKAGE_HIST_WRONG_DATA_TYPE = "307079";
  public static String WS_ERROR_RESULT_BEAN = "207080";
  public static String WS_ERROR_GENERIC_PRINTER_ID = "107081";
  public static String WS_ERROR_NO_PERMISSION = "107082";
  public static String WS_ERROR_REPROCESS_AWB = "307083";
  public static String WS_ERROR_REPROCESS_INVALID_ERROR = "207084";
  public static String WS_ERROR_REPROCESS_NULL_DATA = "307085";
  public static String WS_ERROR_GENERIC_SCAN_INPUT_BEAN = "207086";
  public static String WS_ERROR_CONFIG_INFO = "107087";
  public static String WS_ERROR_CONFIG_WARN = "207088";
  public static String WS_ERROR_CONFIG_ERROR = "307089";
  public static String WS_ERROR_NOTIFY_ERROR = "307090";
  public static String WS_ERROR_RESET_READ_FORM = "307092";


  private static String APPLICATION_NAME = "CCII";
  private static SimpleDateFormat m_df = new SimpleDateFormat(DEFAULT_DATE_FORMAT_ERROR_LOG);
  private static String m_basicConfigString = " | APPLICATION | "
            + m_df.format(new java.util.Date())
            + " | " + APPLICATION_NAME + " | JAVA | cciij.util.CCIIProperties | ";
  private static String m_infoConfigString = "***INFO" + m_basicConfigString
            + WS_ERROR_CONFIG_INFO + " - ";
  private static String m_warnConfigString =  "***WARN" + m_basicConfigString
            + WS_ERROR_CONFIG_WARN + " - ";
  private static String m_errorConfigString = "***ERROR" + m_basicConfigString
            + WS_ERROR_CONFIG_ERROR + " - ";
  private static final int WS_DONT_CARE = 0;
  private static final int WS_INFO = 1;
  private static final int WS_WARN = 2;
  private static final int WS_ERROR = 3;
  private static final Integer WS_INT_DONT_CARE = new Integer(WS_DONT_CARE);
  private static final Integer WS_INT_INFO = new Integer(WS_INFO);
  private static final Integer WS_INT_WARN = new Integer(WS_INFO);
  private static final Integer WS_INT_ERROR = new Integer(WS_ERROR);

  static
  {
    initialize();
  }

  public CCIIProperties()
  {
    if (m_lastStaticInstanceResetTime < m_lastSystemResetTime)
    {
      synchronized (m_lastSystemResetDate)
      {
        if (m_lastStaticInstanceResetTime < m_lastSystemResetTime)
        {
          initialize();
        }
      }
    }
    if (m_lastInstanceResetTime < m_lastSystemResetTime)
    {
      synchronized (m_lastSystemResetDate)
      {
        if (m_lastInstanceResetTime < m_lastSystemResetTime)
        {
          instanceReset();
        }
      }
    }
  }

  public void instanceReset()
  {
    //add any code here that is instance specific that might need to be reset

    synchronized (m_lastInstanceResetDate)
    {
      m_lastInstanceResetTime = System.currentTimeMillis();
      m_lastInstanceResetDate = new Date(m_lastInstanceResetTime);
    }
  }


  public static void initialize()
  {
    String actionName = "CCIIProperties";
    m_notify.setActionName(actionName);
    m_notify.initSite("ALL");
    String tempString = "";
    String forwardJSPPrefix = "";

    int tempInt = 0;
    m_notify.traceLog("CCIIProperties: Workstation, Reading config file");
    m_config = new Config("ALL");

    tempString = m_config.getValue("APPLICATION_NAME");
    if (tempString != null && tempString.length() > 0)
    {
      APPLICATION_NAME = tempString;
    }
    else
    {
      System.out.println(m_errorConfigString + "Could not read APPLICATION_NAME from config file");
    }

    m_config.setGroup("WLTrace");
    tempString = m_config.getValue("ERROR_MSG_SIMPLE_DATE_FORMAT");
    if (tempString != null && tempString.length() > 0)
    {
      DEFAULT_DATE_FORMAT_ERROR_LOG = tempString;
    }
    else
    {
       System.out.println(m_errorConfigString + "Could not read ERROR_MSG_SIMPLE_DATE_FORMAT from config file");
    }
    m_config.setGroup("ALL");
    tempString = m_config.getValue("LOCAL_TIMEZONE");
    if (tempString != null && tempString.length() >0)
      LOCAL_TIME_ZONE = TimeZone.getTimeZone(tempString);
    else
    {
       System.out.println(m_errorConfigString + "Could not read LOCAL_TIMEZONE from m_config file");
    }
    m_df = new SimpleDateFormat(DEFAULT_DATE_FORMAT_ERROR_LOG);
    m_df.setTimeZone(LOCAL_TIME_ZONE);
    //now that the dateformat and time zone have been read in, reinitialize the configstrings
    refreshConfigStrings();

    //now we should be able to use some of the automated functions to read these values in
    // read in the error codes
    WS_ERROR_PROPERTIES_TIMEZONE = internalReadConfigVariableString("WS_ERROR_PROPERTIES_TIMEZONE",WS_ERROR_PROPERTIES_TIMEZONE,WS_DONT_CARE);
    WS_ERROR_PROPERTIES_DEFAULT_LANG = internalReadConfigVariableString("WS_ERROR_PROPERTIES_DEFAULT_LANG",WS_ERROR_PROPERTIES_DEFAULT_LANG,WS_DONT_CARE);
    WS_ERROR_PROPERTIES_READ_PROPERTIES = internalReadConfigVariableString("WS_ERROR_PROPERTIES_READ_PROPERTIES",WS_ERROR_PROPERTIES_READ_PROPERTIES,WS_DONT_CARE);
    WS_ERROR_PROPERTIES_NUMBER_FORMAT = internalReadConfigVariableString("WS_ERROR_PROPERTIES_NUMBER_FORMAT",WS_ERROR_PROPERTIES_NUMBER_FORMAT,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_INIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_CODE_DEF_INIT_LOOKUP_BEAN_HOME",WS_ERROR_CODE_DEF_INIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_REINIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_CODE_DEF_REINIT_LOOKUP_BEAN_HOME",WS_ERROR_CODE_DEF_REINIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_CREATE_LOOKUP = internalReadConfigVariableString("WS_ERROR_CODE_DEF_CREATE_LOOKUP",WS_ERROR_CODE_DEF_CREATE_LOOKUP,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_CODE_DEF_REMOTE_ERROR",WS_ERROR_CODE_DEF_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_EMPTY_DATA = internalReadConfigVariableString("WS_ERROR_CODE_DEF_EMPTY_DATA",WS_ERROR_CODE_DEF_EMPTY_DATA,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_NULL_DATA = internalReadConfigVariableString("WS_ERROR_CODE_DEF_NULL_DATA",WS_ERROR_CODE_DEF_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_NO_ELEMENT = internalReadConfigVariableString("WS_ERROR_CODE_DEF_NO_ELEMENT",WS_ERROR_CODE_DEF_NO_ELEMENT,WS_DONT_CARE);
    WS_ERROR_CODE_DEF_WRONG_DATA_TYPE = internalReadConfigVariableString("WS_ERROR_CODE_DEF_WRONG_DATA_TYPE",WS_ERROR_CODE_DEF_WRONG_DATA_TYPE,WS_DONT_CARE);
    WS_ERROR_LOOKUP_EJB_CLEANUP = internalReadConfigVariableString("WS_ERROR_LOOKUP_EJB_CLEANUP",WS_ERROR_LOOKUP_EJB_CLEANUP,WS_DONT_CARE);
    WS_ERROR_DUP_HU_INIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_DUP_HU_INIT_LOOKUP_BEAN_HOME",WS_ERROR_DUP_HU_INIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_DUP_HU_REINIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_DUP_HU_REINIT_LOOKUP_BEAN_HOME",WS_ERROR_DUP_HU_REINIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_DUP_HU_CREATE_LOOKUP = internalReadConfigVariableString("WS_ERROR_DUP_HU_CREATE_LOOKUP",WS_ERROR_DUP_HU_CREATE_LOOKUP,WS_DONT_CARE);
    WS_ERROR_DUP_HU_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_DUP_HU_REMOTE_ERROR",WS_ERROR_DUP_HU_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_DUP_HU_EMPTY_DATA = internalReadConfigVariableString("WS_ERROR_DUP_HU_EMPTY_DATA",WS_ERROR_DUP_HU_EMPTY_DATA,WS_DONT_CARE);
    WS_ERROR_DUP_HU_NULL_DATA = internalReadConfigVariableString("WS_ERROR_DUP_HU_NULL_DATA",WS_ERROR_DUP_HU_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_DUP_HU_NO_ELEMENT = internalReadConfigVariableString("WS_ERROR_DUP_HU_NO_ELEMENT",WS_ERROR_DUP_HU_NO_ELEMENT,WS_DONT_CARE);
    WS_ERROR_DUP_HU_WRONG_DATA_TYPE = internalReadConfigVariableString("WS_ERROR_DUP_HU_WRONG_DATA_TYPE",WS_ERROR_DUP_HU_WRONG_DATA_TYPE,WS_DONT_CARE);
    WS_ERROR_EJBPROC_INIT_RULEPROC_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_INIT_RULEPROC_BEAN_HOME",WS_ERROR_EJBPROC_INIT_RULEPROC_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_REINIT_RULEPROC_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_REINIT_RULEPROC_BEAN_HOME",WS_ERROR_EJBPROC_REINIT_RULEPROC_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_CREATE_RULEPROC = internalReadConfigVariableString("WS_ERROR_EJBPROC_CREATE_RULEPROC",WS_ERROR_EJBPROC_CREATE_RULEPROC,WS_DONT_CARE);
    WS_ERROR_EJBPROC_RULEPROC_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_EJBPROC_RULEPROC_REMOTE_ERROR",WS_ERROR_EJBPROC_RULEPROC_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_RULEPROC_EJB_CLEANUP = internalReadConfigVariableString("WS_ERROR_RULEPROC_EJB_CLEANUP",WS_ERROR_RULEPROC_EJB_CLEANUP,WS_DONT_CARE);
    WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME",WS_ERROR_EJBPROC_INIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME",WS_ERROR_EJBPROC_REINIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_CREATE_LOOKUP = internalReadConfigVariableString("WS_ERROR_EJBPROC_CREATE_LOOKUP",WS_ERROR_EJBPROC_CREATE_LOOKUP,WS_DONT_CARE);
    WS_ERROR_MULTIPLE_EJB_CLEANUP = internalReadConfigVariableString("WS_ERROR_MULTIPLE_EJB_CLEANUP",WS_ERROR_MULTIPLE_EJB_CLEANUP,WS_DONT_CARE);
    WS_ERROR_JOLT_TUX_EJB_CLEANUP = internalReadConfigVariableString("WS_ERROR_JOLT_TUX_EJB_CLEANUP",WS_ERROR_JOLT_TUX_EJB_CLEANUP,WS_DONT_CARE);
    WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME",WS_ERROR_EJBPROC_INIT_JOLTTUX_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME",WS_ERROR_EJBPROC_REINIT_JOLTTUX_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_EJBPROC_CREATE_JOLTTUX = internalReadConfigVariableString("WS_ERROR_EJBPROC_CREATE_JOLTTUX",WS_ERROR_EJBPROC_CREATE_JOLTTUX,WS_DONT_CARE);
    WS_ERROR_EJBPROC_CONS = internalReadConfigVariableString("WS_ERROR_EJBPROC_CONS",WS_ERROR_EJBPROC_CONS,WS_DONT_CARE);
    WS_ERROR_EJBPROC_UNKNOWN_TRACK_TYPE = internalReadConfigVariableString("WS_ERROR_EJBPROC_UNKNOWN_TRACK_TYPE",WS_ERROR_EJBPROC_UNKNOWN_TRACK_TYPE,WS_DONT_CARE);
    WS_ERROR_EJBPROC_NULL_RULEPROC = internalReadConfigVariableString("WS_ERROR_EJBPROC_NULL_RULEPROC",WS_ERROR_EJBPROC_NULL_RULEPROC,WS_DONT_CARE);
    WS_ERROR_UNKNOWN_EJBTYPE = internalReadConfigVariableString("WS_ERROR_UNKNOWN_EJBTYPE",WS_ERROR_UNKNOWN_EJBTYPE,WS_DONT_CARE);
    WS_ERROR_EJBPROC_ROUTE_ACTIVITY = internalReadConfigVariableString("WS_ERROR_EJBPROC_ROUTE_ACTIVITY",WS_ERROR_EJBPROC_ROUTE_ACTIVITY,WS_DONT_CARE);
    WS_ERROR_EJBPROC_UNKNOWN_EJBCODE = internalReadConfigVariableString("WS_ERROR_EJBPROC_UNKNOWN_EJBCODE",WS_ERROR_EJBPROC_UNKNOWN_EJBCODE,WS_DONT_CARE);
    WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE = internalReadConfigVariableString("WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE",WS_ERROR_EJBPROC_ONLY_FIRST_ROUTE,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_INIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_INIT_LOOKUP_BEAN_HOME",WS_ERROR_ROUTE_MAINT_INIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_REINIT_LOOKUP_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_REINIT_LOOKUP_BEAN_HOME",WS_ERROR_ROUTE_MAINT_REINIT_LOOKUP_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_CREATE_LOOKUP = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_CREATE_LOOKUP",WS_ERROR_ROUTE_MAINT_CREATE_LOOKUP,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_REMOTE_ERROR",WS_ERROR_ROUTE_MAINT_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_NULL_DATA = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_NULL_DATA",WS_ERROR_ROUTE_MAINT_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_EMPTY_DATA = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_EMPTY_DATA",WS_ERROR_ROUTE_MAINT_EMPTY_DATA,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_WRONG_DATA_TYPE = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_WRONG_DATA_TYPE",WS_ERROR_ROUTE_MAINT_WRONG_DATA_TYPE,WS_DONT_CARE);
    WS_ERROR_STAGE_PICK_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_STAGE_PICK_REMOTE_ERROR",WS_ERROR_STAGE_PICK_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_STAGE_PICK_WRONG_DATA_TYPE = internalReadConfigVariableString("WS_ERROR_STAGE_PICK_WRONG_DATA_TYPE",WS_ERROR_STAGE_PICK_WRONG_DATA_TYPE,WS_DONT_CARE);
    WS_ERROR_STAGE_PICK_READ_FORM = internalReadConfigVariableString("WS_ERROR_STAGE_PICK_READ_FORM",WS_ERROR_STAGE_PICK_READ_FORM,WS_DONT_CARE);
    WS_ERROR_GENERIC_READ_FORM = internalReadConfigVariableString("WS_ERROR_GENERIC_READ_FORM",WS_ERROR_GENERIC_READ_FORM,WS_DONT_CARE);
    WS_ERROR_REDIRECT_ERROR = internalReadConfigVariableString("WS_ERROR_REDIRECT_ERROR",WS_ERROR_REDIRECT_ERROR,WS_DONT_CARE);
    WS_ERROR_ROUTE_MAINT_READ_FORM = internalReadConfigVariableString("WS_ERROR_ROUTE_MAINT_READ_FORM",WS_ERROR_ROUTE_MAINT_READ_FORM,WS_DONT_CARE);
    WS_ERROR_PARSE_SORT_DATE = internalReadConfigVariableString("WS_ERROR_PARSE_SORT_DATE",WS_ERROR_PARSE_SORT_DATE,WS_DONT_CARE);
    WS_ERROR_DEFAULT_SORT_DATE = internalReadConfigVariableString("WS_ERROR_DEFAULT_SORT_DATE",WS_ERROR_DEFAULT_SORT_DATE,WS_DONT_CARE);
    WS_ERROR_MAIN_FRAME_JSP_BEAN_NULL = internalReadConfigVariableString("WS_ERROR_MAIN_FRAME_JSP_BEAN_NULL",WS_ERROR_MAIN_FRAME_JSP_BEAN_NULL,WS_DONT_CARE);
    WS_ERROR_ROUTE_EDIT_READ_FORM = internalReadConfigVariableString("WS_ERROR_ROUTE_EDIT_READ_FORM",WS_ERROR_ROUTE_EDIT_READ_FORM,WS_DONT_CARE);
    WS_ERROR_ROUTE_EDIT_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_ROUTE_EDIT_REMOTE_ERROR",WS_ERROR_ROUTE_EDIT_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_ROUTE_EDIT_NO_ACTIVITY_CODE = internalReadConfigVariableString("WS_ERROR_ROUTE_EDIT_NO_ACTIVITY_CODE",WS_ERROR_ROUTE_EDIT_NO_ACTIVITY_CODE,WS_DONT_CARE);
    WS_ERROR_ROUTE_EDIT_NULL_DATA = internalReadConfigVariableString("WS_ERROR_ROUTE_EDIT_NULL_DATA",WS_ERROR_ROUTE_EDIT_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_ROUTE_EDIT_NO_CHANGED = internalReadConfigVariableString("WS_ERROR_ROUTE_EDIT_NO_CHANGED",WS_ERROR_ROUTE_EDIT_NO_CHANGED,WS_DONT_CARE);
    WS_ERROR_RESULT_WINDOW_READ_FORM = internalReadConfigVariableString("WS_ERROR_RESULT_WINDOW_READ_FORM",WS_ERROR_RESULT_WINDOW_READ_FORM,WS_DONT_CARE);
    WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME",WS_ERROR_LOGIN_INIT_SECURITY_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME",WS_ERROR_LOGIN_REINIT_SECURITY_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_LOGIN_CREATE_SECURITY = internalReadConfigVariableString("WS_ERROR_LOGIN_CREATE_SECURITY",WS_ERROR_LOGIN_CREATE_SECURITY,WS_DONT_CARE);
    WS_ERROR_LOGIN_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_LOGIN_REMOTE_ERROR",WS_ERROR_LOGIN_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_LOGIN_READ_FORM = internalReadConfigVariableString("WS_ERROR_LOGIN_READ_FORM",WS_ERROR_LOGIN_READ_FORM,WS_DONT_CARE);
    WS_ERROR_SECURITY_REMOVE = internalReadConfigVariableString("WS_ERROR_SECURITY_REMOVE",WS_ERROR_SECURITY_REMOVE,WS_DONT_CARE);
    WS_ERROR_LOGIN_USER_NULL = internalReadConfigVariableString("WS_ERROR_LOGIN_USER_NULL",WS_ERROR_LOGIN_USER_NULL,WS_DONT_CARE);
    WS_ERROR_LOGOUT_INIT_SECURITY_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_LOGOUT_INIT_SECURITY_BEAN_HOME",WS_ERROR_LOGOUT_INIT_SECURITY_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_LOGOUT_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_LOGOUT_REMOTE_ERROR",WS_ERROR_LOGOUT_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_LOGOUT_REINIT_SECURITY_BEAN_HOME = internalReadConfigVariableString("WS_ERROR_LOGOUT_REINIT_SECURITY_BEAN_HOME",WS_ERROR_LOGOUT_REINIT_SECURITY_BEAN_HOME,WS_DONT_CARE);
    WS_ERROR_LOGOUT_CREATE_SECURITY = internalReadConfigVariableString("WS_ERROR_LOGOUT_CREATE_SECURITY",WS_ERROR_LOGOUT_CREATE_SECURITY,WS_DONT_CARE);
    WS_ERROR_PACKAGE_HIST_CREATE_LOOKUP = internalReadConfigVariableString("WS_ERROR_PACKAGE_HIST_CREATE_LOOKUP",WS_ERROR_PACKAGE_HIST_CREATE_LOOKUP,WS_DONT_CARE);
    WS_ERROR_PACKAGE_HIST_NULL_DATA = internalReadConfigVariableString("WS_ERROR_PACKAGE_HIST_NULL_DATA",WS_ERROR_PACKAGE_HIST_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_PACKAGE_HIST_EMPTY_DATA = internalReadConfigVariableString("WS_ERROR_PACKAGE_HIST_EMPTY_DATA",WS_ERROR_PACKAGE_HIST_EMPTY_DATA,WS_DONT_CARE);
    WS_ERROR_PACKAGE_HIST_REMOTE_ERROR = internalReadConfigVariableString("WS_ERROR_PACKAGE_HIST_REMOTE_ERROR",WS_ERROR_PACKAGE_HIST_REMOTE_ERROR,WS_DONT_CARE);
    WS_ERROR_PACKAGE_HIST_WRONG_DATA_TYPE = internalReadConfigVariableString("WS_ERROR_PACKAGE_HIST_WRONG_DATA_TYPE",WS_ERROR_PACKAGE_HIST_WRONG_DATA_TYPE,WS_DONT_CARE);
    WS_ERROR_RESULT_BEAN = internalReadConfigVariableString("WS_ERROR_RESULT_BEAN",WS_ERROR_RESULT_BEAN,WS_DONT_CARE);
    WS_ERROR_GENERIC_PRINTER_ID = internalReadConfigVariableString("WS_ERROR_GENERIC_PRINTER_ID",WS_ERROR_GENERIC_PRINTER_ID,WS_DONT_CARE);
    WS_ERROR_NO_PERMISSION = internalReadConfigVariableString("WS_ERROR_NO_PERMISSION",WS_ERROR_NO_PERMISSION,WS_DONT_CARE);
    WS_ERROR_REPROCESS_AWB = internalReadConfigVariableString("WS_ERROR_REPROCESS_AWB",WS_ERROR_REPROCESS_AWB,WS_DONT_CARE);
    WS_ERROR_REPROCESS_INVALID_ERROR = internalReadConfigVariableString("WS_ERROR_REPROCESS_INVALID_ERROR",WS_ERROR_REPROCESS_INVALID_ERROR,WS_DONT_CARE);
    WS_ERROR_REPROCESS_NULL_DATA = internalReadConfigVariableString("WS_ERROR_REPROCESS_NULL_DATA",WS_ERROR_REPROCESS_NULL_DATA,WS_DONT_CARE);
    WS_ERROR_GENERIC_SCAN_INPUT_BEAN = internalReadConfigVariableString("WS_ERROR_GENERIC_SCAN_INPUT_BEAN",WS_ERROR_GENERIC_SCAN_INPUT_BEAN,WS_DONT_CARE);
    WS_ERROR_NOTIFY_ERROR = internalReadConfigVariableString("WS_ERROR_NOTIFY_ERROR",WS_ERROR_NOTIFY_ERROR,WS_DONT_CARE);
    WS_ERROR_RESET_READ_FORM = internalReadConfigVariableString("WS_ERROR_RESET_READ_FORM",WS_ERROR_RESET_READ_FORM,WS_DONT_CARE);

    synchronized (m_lastSystemResetDate)
    {
      m_lastStaticInstanceResetTime = System.currentTimeMillis();
      m_lastStaticInstanceResetDate = new Date(m_lastStaticInstanceResetTime);
    }

  }

  public void reset()
  {
    System.out.println("In CCIIProperties:  Reseting workstation");
    try
    {
      m_config.reread();
    } catch (Exception e)
    {
      System.out.println("Error rereading config file");
    }
    initialize();
    instanceReset();
    synchronized (m_lastSystemResetDate)
    {
      m_lastSystemResetTime = System.currentTimeMillis();
      m_lastSystemResetDate = new Date(m_lastStaticInstanceResetTime);
    }
  }

  public static boolean isSystemReset(long lastResetTime)
  {
    boolean retValue = false;
    if (lastResetTime < m_lastSystemResetTime)
    {
      synchronized (m_lastSystemResetDate)
      {
        if (lastResetTime < m_lastSystemResetTime)
        {
          retValue = true;
        }
      }
    }
    return retValue;
  }

  public static boolean isSystemReset(Date lastResetDate)
  {
    boolean retValue = false;
    if (lastResetDate.getTime() < m_lastSystemResetDate.getTime())
    {
      synchronized (m_lastSystemResetDate)
      {
        if (lastResetDate.getTime() < m_lastSystemResetDate.getTime())
        {
          retValue = true;
        }
      }
    }
    return retValue;
  }

  protected static void setConfigSection(String sectionName)
  {
    if (sectionName == null || sectionName.equals(""))
    {
      m_config.setGroup("ALL");
    }
    else
    {
      m_config.setGroup(sectionName);
    }
  }

  protected static String getErrorConfigString(int errorLevel)
  {
    refreshConfigStrings();
    switch (errorLevel)
    {
      case WS_ERROR:
           return m_errorConfigString;
      case WS_WARN:
           return m_warnConfigString;
      case WS_INFO:
           //no break or return, want same as default behavior
      case WS_DONT_CARE:
           //no break or return, want same as default behavior
      default:
          return m_infoConfigString;
    }
  }

  protected static void refreshConfigStrings()
  {
    m_basicConfigString = " | APPLICATION | " + m_df.format(new java.util.Date())
           + " | " + APPLICATION_NAME + " | JAVA | cciij.util.CCIIProperties | ";
    m_infoConfigString = "***INFO" + m_basicConfigString + WS_ERROR_CONFIG_INFO + " - ";
    m_warnConfigString =  "***WARN" + m_basicConfigString + WS_ERROR_CONFIG_WARN + " - ";
    m_errorConfigString = "***ERROR" + m_basicConfigString + WS_ERROR_CONFIG_ERROR + " - ";

  }

  public static String readConfigVariableString(String key, String locationCd)
  {
    //basic read, most other readConfig methods call this one
    m_notify.initSite(locationCd);
    String tempString = null;
    if (m_config == null)
    {
      m_config = new Config();
    }
    if (key == null)
    {
       m_notify.traceLog("config name is null");
       addLogMessageReadConfigFailed(key, WS_ERROR, locationCd);
    }
    else
    {
      m_config.setLocationCode(locationCd);
      tempString =  m_config.getValue(key);
      if ( tempString == null )
      {
        m_notify.traceLog(key + " value is null in config file");
        addLogMessageReadConfigFailed(key, WS_ERROR,locationCd);
      }
    }
    return tempString;
  }

  public static String readConfigVariableString(String key, String locationCd, String defaultValue)
  {
    String tempString = null;
    tempString = readConfigVariableString(key,locationCd);
    if (tempString == null)
    {
       tempString = defaultValue;
       addLogMessageReadConfigUseDefault(key,defaultValue, WS_ERROR,locationCd);
    }
    return tempString;
  }

  public static int readConfigVariableInt(String key, String locationCd)
  {
    int returnInt = -9999;
    String tempString = readConfigVariableString(key,locationCd);
    try
    {
      returnInt = Integer.parseInt(tempString);
    } catch (Exception e)
    {
      addLogMessageReadConfigFailedFormat(key,tempString,"int",e,WS_ERROR,locationCd);
    }
    return returnInt;
  }

  public static int readConfigVariableInt(String key, String locationCd, int defaultValue)
  {
    int returnInt = -9999;
    //this call will return either the value read in or the default value
    String tempString = readConfigVariableString(key,locationCd,String.valueOf(defaultValue));
    try
    {
      returnInt = Integer.parseInt(tempString);
    } catch (Exception e)
    {
        addLogMessageReadConfigFailedFormat(key,tempString,"int",e, WS_ERROR,locationCd);
        //caught the exception and then force the default value
        returnInt = defaultValue;
    }
    //returns either the value read in or the default value if not found or not of the right format
    return returnInt;
  }

  public static boolean readConfigVariableBoolean(String key, String locationCd)
  {
    boolean returnBool = false;
    String tempString = readConfigVariableString(key,locationCd);
    try
    {
      if (tempString.equalsIgnoreCase("TRUE") || tempString.equalsIgnoreCase("T")
          || tempString.equalsIgnoreCase("YES") || tempString.equalsIgnoreCase("Y"))
         returnBool = true;
    }
    catch (Exception e)
    {
      addLogMessageReadConfigFailedFormat(key,tempString,"boolean",e,WS_ERROR,locationCd);
    }
    return returnBool;
  }

  public static boolean readConfigVariableBoolean(String key, String locationCd, boolean defaultValue)
  {
    boolean returnBool = false;
    //this call will return either the value read in or the default value
    String tempString = readConfigVariableString(key,locationCd, String.valueOf(defaultValue));
    try
    {
      returnBool = tempString.equalsIgnoreCase("TRUE")  || tempString.equalsIgnoreCase("T")
                    || tempString.equalsIgnoreCase("YES") || tempString.equalsIgnoreCase("Y");
    }
    catch (Exception e)
    {
        addLogMessageReadConfigFailedFormat(key,tempString,"boolean",e,WS_ERROR,locationCd);
        //catch the exception and then force the default value
        returnBool = defaultValue;
    }
    //returns either the value read in or the default value if not found or not of the right format
    return returnBool;
  }

  protected static String internalReadConfigVariableString(String configName)
  {
    return internalReadConfigVariableString(configName,WS_INFO);
  }

  protected static String internalReadConfigVariableString(String configName, int errorLevel)
  { //basic read, most other readConfig methods call this one
    String tempString = null;
    String locationCd = "ALL";
    m_notify.initSite(locationCd);
    if (m_config == null)
    {
      m_config = new Config();
    }
    if (configName == null)
    {
       m_notify.traceLog("config name is null");
       addLogMessageReadConfigFailed(configName, errorLevel, locationCd);
    }
    else
    {
      tempString =  m_config.getValue(configName);
      if ( tempString == null )
      {
        m_notify.traceLog(configName + " value is null in config file");
        addLogMessageReadConfigFailed(configName,errorLevel,locationCd);
      }
    }
    return tempString;
  }

  protected static int internalReadConfigVariableInt(String configName)
  {
    return internalReadConfigVariableInt(configName,WS_INFO);
  }

  protected static int internalReadConfigVariableInt(String configName,Integer errorLevelInt)
  {
    int returnInt = -9999;
    String locationCd = "ALL";
    String tempString = internalReadConfigVariableString(configName,errorLevelInt.intValue());
    try
    {
      returnInt = Integer.parseInt(tempString);
    } catch (Exception e)
    {
      addLogMessageReadConfigFailedFormat(configName,tempString,"int",e,errorLevelInt.intValue(),locationCd);
    }
    return returnInt;
  }

  protected static boolean internalReadConfigVariableBool(String configName)
  {
    return internalReadConfigVariableBool(configName,WS_INFO);
  }

  protected static boolean internalReadConfigVariableBool(String configName,int errorLevel)
  {
    boolean returnBool = false;
    String locationCd = "ALL";
    String tempString = internalReadConfigVariableString(configName,errorLevel);
    try
    {
      if (tempString.equalsIgnoreCase("TRUE") || tempString.equalsIgnoreCase("T")
          || tempString.equalsIgnoreCase("YES") || tempString.equalsIgnoreCase("Y"))
         returnBool = true;
    }
    catch (Exception e)
    {
      addLogMessageReadConfigFailedFormat(configName,tempString,"boolean",e,errorLevel,locationCd);
    }
    return returnBool;
  }

  protected static String internalReadConfigVariableString(String configName, String defaultValue)
  {
    return internalReadConfigVariableString(configName,defaultValue,WS_INFO);
  }

  protected static String internalReadConfigVariableString(String configName, String defaultValue, int errorLevel)
  {
    String tempString = null;
    String locationCd ="ALL";
    tempString = internalReadConfigVariableString(configName,errorLevel);
    if (tempString == null)
    {
       tempString = defaultValue;
       addLogMessageReadConfigUseDefault(configName,defaultValue, errorLevel,locationCd);
    }
    return tempString;
  }

  protected static  boolean internalReadConfigVariableBool(String configName, boolean defaultValue)
  {
    return internalReadConfigVariableBool(configName,defaultValue,WS_INFO);
  }

  protected static  boolean internalReadConfigVariableBool(String configName, boolean defaultValue, int errorLevel)
  {
    boolean returnBool = false;
    String locationCd = "ALL";
    //this call will return either the value read in or the default value
    String tempString = internalReadConfigVariableString(configName,String.valueOf(defaultValue),errorLevel);
    try
    {
      returnBool = tempString.equalsIgnoreCase("TRUE") || tempString.equalsIgnoreCase("T")
                  || tempString.equalsIgnoreCase("YES") || tempString.equalsIgnoreCase("Y");
    }
    catch (Exception e)
    {
        addLogMessageReadConfigFailedFormat(configName,tempString,"boolean",e,errorLevel,locationCd);
        //catch the exception and then force the default value
        returnBool = defaultValue;
    }
    //returns either the value read in or the default value if not found or not of the right format
    return returnBool;
  }

  protected static int internalReadConfigVariableInt(String configName, int defaultValue)
  {
    return internalReadConfigVariableInt(configName,defaultValue,WS_INT_INFO);
  }

  protected static int internalReadConfigVariableInt(String configName, int defaultValue, Integer errorLevelInt)
  {
    int returnInt = -9999;
    String locationCd = "ALL";
    String tempString = internalReadConfigVariableString(configName,String.valueOf(defaultValue), errorLevelInt.intValue());
    try
    {
      returnInt = Integer.parseInt(tempString);
    } catch (Exception e)
    {
        addLogMessageReadConfigFailedFormat(configName,tempString,"int",e, errorLevelInt.intValue(),locationCd);
        //caught the exception and then force the default value
        returnInt = defaultValue;
    }
    //returns either the value read in or the default value if not found or not of the right format
    return returnInt;
  }

 private static void addLogMessageReadConfigFailed(String configName, int errorLevel, String locationCd)
  {
     String errorString = "Unable to read variable '" + configName + "' at " + locationCd;
     m_notify.initSite(locationCd);
     if (errorLevel != WS_DONT_CARE)
     {
        m_notify.traceLog(errorString);
        Exception ex = new Exception("CCIIProperties: " + errorString);
        String errorMsg = getErrorConfigString(errorLevel) + errorString;
        m_notify.wsNotifyLog(errorMsg,ex);
     }
     else
     {
        m_notify.traceLog(errorString + " has an error level of DONT CARE");
     }
  }

  private static void addLogMessageReadConfigUseDefault(String configName, String defaultValue, int errorLevel, String locationCd)
  {
    String errorString = "Could not read: '" + configName
           + "' at location " + locationCd
           + ", using default: '" + defaultValue + "'";
    m_notify.initSite(locationCd);
    if (errorLevel != WS_DONT_CARE)
    {
      m_notify.traceLog(errorString);
      Exception ex = new Exception("CCIIProperties: " + errorString);
      String errorMsg = getErrorConfigString(errorLevel) + errorString;
      m_notify.wsNotifyLog(errorMsg,ex);
    }
    else
    {
      m_notify.traceLog(errorString + " has an error level of DONT CARE");
    }
  }

  private static void addLogMessageReadConfigFailedFormat(String configName, String valueRead, String formatType, Exception e, int errorLevel, String locationCd)
  {
    String errorString = "At: " + locationCd + " For: " + configName
           + " failed to format " + valueRead + " as a " + formatType;
    m_notify.initSite(locationCd);
    if (errorLevel != WS_DONT_CARE)
    {
      m_notify.traceLog(errorString);
      String errorMsg = getErrorConfigString(errorLevel) + errorString;
      m_notify.wsNotifyLog(errorMsg,e);
    }
    else
    {
      m_notify.traceLog(errorString + " has an error level of DONT CARE");
    }
  }

  public static String getJoltAddress(String site)
  {
    String tempString = readConfigVariableString("JOLT_IP_ADDRESS",site);
    String joltAddress = "//" + tempString;
    tempString = readConfigVariableString("JOLT_PORT",site);
    joltAddress = joltAddress + ":" + tempString;
    return joltAddress;
  }

  public static String getT3WebAddress(String site)
  {
    return "t3://" + readConfigVariableString("WEB_SERVER_ADDRESS",site);
  }

  public static String getServletPrefix(String site)
  {
    //This variable is not normally in the config file
    String contextRoot = readConfigVariableString(
           "CONTEXT_ROOT",site,CONTEXT_ROOT_DEFAULT);
    //This variable is not normally in the config file
    String servletPrefix = readConfigVariableString(
           "SERVLET_PREFIX",site,SERVLET_PREFIX_DEFAULT);
    return contextRoot + servletPrefix;
  }

  public static String getServletAddress(String name,String site)
  {
    return getServletPrefix(site) + name;
  }

  public static String getforwardJSPPrefix(String locationCd)
  {
    String forwardJSPPrefix = null;
    //This variable is not normally in the config file
    String contextRoot = readConfigVariableString(
           "CONTEXT_ROOT",locationCd,CONTEXT_ROOT_DEFAULT);
    //This variable is not normally in the config file
    String jspPrefix = readConfigVariableString(
           "JSP_PREFIX",locationCd,JSP_PREFIX_DEFAULT);
    //This variable is not normally in the config file
    boolean requestForwardUsesContextRoot = readConfigVariableBoolean(
        "REQUEST_FORWARD_USES_CONTEXT_ROOT",
        locationCd,REQUEST_FORWARD_USES_CONTEXT_ROOT);
    if (requestForwardUsesContextRoot)
    {
       forwardJSPPrefix = contextRoot + jspPrefix;
    }
    else
    {
       forwardJSPPrefix = jspPrefix;
    }
    return forwardJSPPrefix;
  }

  public static String getJSPForwardAddress(String name, String locationCd)
  {
    return getforwardJSPPrefix(locationCd) + name;
  }

  public static String getJSPAddress(String name, String site)
  {
    //This variable is not normally in the config file
    String contextRoot = readConfigVariableString(
           "CONTEXT_ROOT",site,CONTEXT_ROOT_DEFAULT);
    //This variable is not normally in the config file
    String jspPrefix = readConfigVariableString(
           "JSP_PREFIX",site,JSP_PREFIX_DEFAULT);
    return contextRoot + jspPrefix + name;
  }

  public static String getJNLPSPrefix(String site)
  {
   //This variable is not normally in the config file
    String jnlpsContextRoot = readConfigVariableString(
           "JNLPS_CONTEXT_ROOT",site,JNLPS_CONTEXT_ROOT_DEFAULT);
    //This variable is not normally in the config file
    String jnlpsPrefix = readConfigVariableString(
           "JNLPS_PREFIX",site,JNLPS_PREFIX_DEFAULT);
    return (jnlpsContextRoot + jnlpsPrefix);
  }

  public static String getJNLPSAddress(String name,String site)
  {
    return getJNLPSPrefix(site) + name;
  }

  public static boolean scanAllowsCONS(String scanName, String site)
  {
    boolean scanAllowCONS = false;
    boolean workstationAllowsCONS = readConfigVariableBoolean(
            "WORKSTATION_ALLOWS_CONS",site,false);
    if (workstationAllowsCONS)
    {
      scanAllowCONS = readConfigVariableBoolean(
            scanName + "VIEW_ALLOW_CONS",site,false);
    }
    return scanAllowCONS;
  }

  public static synchronized SimpleDateFormat getDateFormat(String site)
  {
    m_config.setGroup("WLTrace");
    String defaultDateFormat = DEFAULT_DATE_FORMAT_ERROR_LOG;
    TimeZone localTimeZone = LOCAL_TIME_ZONE;
    SimpleDateFormat df = new SimpleDateFormat(defaultDateFormat);
    m_config.setLocationCode(site);
    String tempString = m_config.getValue("ERROR_MSG_SIMPLE_DATE_FORMAT");
    if (tempString != null && tempString.length() > 0)
    {
      defaultDateFormat = tempString;
    }
    else
    {
       System.out.println(m_errorConfigString + "Could not read ERROR_MSG_SIMPLE_DATE_FORMAT from config file");
    }
    m_config.setGroup("ALL");
    m_config.setLocationCode(site);
    tempString = m_config.getValue("LOCAL_TIMEZONE");
    if (tempString != null && tempString.length() >0)
      localTimeZone = TimeZone.getTimeZone(tempString);
    else
    {
       System.out.println(m_errorConfigString + "Could not read LOCAL_TIMEZONE from m_config file");
    }
    df = new SimpleDateFormat(defaultDateFormat);
    df.setTimeZone(localTimeZone);
    return df;
  }

  public static String getBodyTag(String locationCd)
  {
    String backgroundColor = BACKGROUND_COLOR_DEFAULT;
    String backgroundImage = BACKGROUND_IMAGE_DEFAULT;
    boolean useBackGroundImage = readConfigVariableBoolean(
           "USE_BACKGROUND_IMAGE",locationCd,USE_BACKGROUND_IMAGE_DEFAULT);
    if (useBackGroundImage)
       backgroundImage = readConfigVariableString("BACKGROUND_IMAGE",locationCd);
    boolean useBackgroundColor = readConfigVariableBoolean("USE_BACKGROUND_COLOR",locationCd);
    if (useBackgroundColor)
       backgroundColor = readConfigVariableString("BACKGROUND_COLOR",locationCd);
    String bodyTag = "<BODY";
    if (useBackGroundImage)
      bodyTag += " BACKGROUND=\"" + backgroundImage + "\"";
    if (useBackgroundColor)
      bodyTag += " BGCOLOR=\"" + backgroundColor + "\"";
    bodyTag += ">";
    return bodyTag;
  }

  /*
  public static String getRuleSetName(String scanPrefix, String site)
  {
    return readConfigVariableString(scanPrefix + "VIEW_RULESET",site);
  }
*/
  public static String getScanCode(String scanPrefix,String site)
  {
    return readConfigVariableString(scanPrefix + "VIEW_SCAN_CODE",site);
  }

  /*
  public static String getViewName(String scanPrefix)
  {
    return scanPrefix + GENERIC_VIEW_NAME_ENDING;
  }
  */

  public static int getDefaultSiteLanguage(String locationCd)
  {
    int defaultSiteLanguage = 1;
    String tempString = readConfigVariableString("DEFAULT_LANGUAGE",locationCd);
    if (tempString != null && tempString.length() > 0)
    {
      try
      {
        boolean determinedLanguage = false;
        if (tempString != null && !tempString.equals(""))
        {
          for (int i =1;i<=NUM_LANG_SUPPORTED;i++)
          {
            if (tempString.equalsIgnoreCase(SITE_LANGUAGE_NAMES[i]))
            {
              determinedLanguage = true;
              defaultSiteLanguage = i;
              break;
            }
          }
        }
        if (!determinedLanguage)
        {
          defaultSiteLanguage = 1;
          System.out.println(m_warnConfigString + "Could not read DEFAULT_LANGUAGE from config file");
        }
      } catch (Exception e)
      {
        defaultSiteLanguage = 1;
        System.out.println(m_warnConfigString + "Could not read DEFAULT_LANGUAGE from config file");
      }
    }
    else
    {
      System.out.println(m_warnConfigString + "Could not read DEFAULT_LANGUAGE from config file");
    }
    return defaultSiteLanguage;
  }

  public static void main(String[] args)
  {
    CCIIProperties CCIIProperties1 = new CCIIProperties();
  }
}
