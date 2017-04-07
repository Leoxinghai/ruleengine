// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Messages.java

package cciij.businessActions;


public class Messages
{

    public Messages()
    {
    }

    protected static final String MESSAGE_SENTINAL = "MeSSaGe SenTInAL";
    public static final int SM_MESSAGE_NAME = 0;
    public static final int SM_ENGLISH = 1;
    public static final int SM_SPANISH = 2;
    public static final int SM_FRENCH = 3;
    public static final int SM_GERMAN = 4;
    public static final int SM_NUMBER_OF_LANGUAGES_ERRORMESSAGE = 4;
    public static final int SM_MAX_FIELD_WIDTH_ERRORMESSAGE = 20;
    public static final int EM_NO_ERROR = 0;
    public static final int IM_MPS = 1;
    public static final int IM_OVERAGE = 2;
    public static final int IM_CLEARED = 3;
    public static final int IM_DUP = 4;
    public static final int IM_INTERCEPTED = 5;
    public static final int IM_DISPLAY_RTN_MSG = 6;
    public static final int IM_NOT_FOUND = 7;
    public static final int IM_NOT_RELEASED = 8;
    public static final int IM_NO_ARRIVAL_SCAN = 9;
    public static final int IM_NO_DEPART_SCAN = 10;
    public static final int IM_DEL_FROM_CONS = 11;
    public static final int IM_CONS_EXPANDED = 12;
    public static final int IM_CLEARED_CONS = 13;
    public static final int IM_NOT_CLRED_CONS = 14;
    public static final int IM_ARRIVAL_SCAN = 15;
    public static final int IM_DEPART_SCAN = 16;
    public static final int IM_NOT_DECLARED = 17;
    public static final int IM_INVALID_INT = 18;
    public static final int IM_EXT_BEAN_FAIL = 19;
    public static final int IM_DOMESTIC_PKG = 20;
    public static final int IM_CONS_ACCEPTED = 21;
    public static final int IM_MSG_USER_LOGOUT = 22;
    public static final int IM_MSG_AUTOLOGOUT = 23;
    public static final int IM_INTRANSIT = 24;
    public static final int IM_RELEASED = 25;
    public static final int IM_ENTRY_RANGE_EXHAUSTED = 26;
    public static final int IM_MSG_04_LEFT = 27;
    public static final int IM_MSG_03_LEFT = 28;
    public static final int IM_MSG_02_LEFT = 29;
    public static final int IM_MSG_01_LEFT = 30;
    public static final int START_OF_ERROR_MSGS = 31;
    public static final int EM_INVALID_SCAN = 32;
    public static final int EM_TRUNC_INPUT = 33;
    public static final int EM_SCAN_ERROR = 34;
    public static final int EM_USER_ERROR = 35;
    public static final int EM_REQ_INPUT = 36;
    public static final int EM_UNKNOWN_KEY = 37;
    public static final int EM_INVALID_LOGON = 38;
    public static final int EM_EXPIRED_LOGON = 39;
    public static final int EM_REVOKED_LOGON = 40;
    public static final int EM_SYSTEM_ERROR = 41;
    public static final int EM_INVALID_AB = 42;
    public static final int EM_AB_NOT_ALLOWD = 43;
    public static final int EM_EDIT_ERROR = 44;
    public static final int EM_EDIT_VER_ERR = 45;
    public static final int EM_DUP_PIECE = 46;
    public static final int EM_INV_STATUS = 47;
    public static final int EM_CHECK_LOG = 48;
    public static final int EM_CONTACT_MGR = 49;
    public static final int EM_RE_ENABLE = 50;
    public static final int EM_CANNOT_MSTR = 51;
    public static final int EM_DUP_SHIPMENT = 52;
    public static final int EM_NEED_MSTR_AB = 53;
    public static final int EM_INTERNAL_ERR = 54;
    public static final int EM_TRANS_XA_ERR = 55;
    public static final int EM_MIDDLEWR_ERR = 56;
    public static final int EM_DB_ERROR = 57;
    public static final int EM_DM_BADVALUE = 58;
    public static final int EM_REASON_CODE_REQD = 59;
    public static final int EM_INV_REASON_CODE = 60;
    public static final int EM_START_OVER = 61;
    public static final int EM_RELEASE_CODE_REQD = 62;
    public static final int EM_UNKNOWN_CODE = 63;
    public static final int EM_CONFIG_FILE_ERROR = 64;
    public static final int EM_REQ_PASSWORD = 65;
    public static final int EM_INVALID_DATA_FOR_SVC = 66;
    public static final int EM_QUEUE_ERR = 67;
    public static final int EM_INV_RELEASE_CODE = 68;
    public static final int EM_DETAIN_LOC_REQD = 69;
    public static final int EM_INVALID_FORMID = 70;
    public static final int EM_USER_NOT_ACTIVE = 71;
    public static final int EM_FAILED_UPLOAD = 72;
    public static final int EM_NO_FUNCTION = 73;
    public static final int EM_PW_FAILED = 74;
    public static final int EM_CHANGE_ABORT = 75;
    public static final int EM_CONS_NOT_ALLOWED = 76;
    public static final int EM_CONS_NOT_FOUND = 77;
    public static final int EM_CONS_NOT_UNIQUE = 78;
    public static final int EM_FAILED_SPLIT = 79;
    public static final int EM_NO_LOGON_GROUP = 80;
    public static final int EM_INVALID_CONS = 81;
    public static final int EM_INV_HANDLING_CODE = 82;
    public static final int EM_HANDLING_CD_REQD = 83;
    public static final int EM_INV_REMARK_CODE = 84;
    public static final int EM_REMARK_CODE_REQD = 85;
    public static final int EM_INVALID_LANGUAGE = 86;
    public static final int EM_INVALID_CMD_CODE = 87;
    public static final int EM_NO_CMD_CODE = 88;
    public static final int EM_FORM_ID_REQD = 89;
    public static final int EM_INVALID_SPLIT = 90;
    public static final int EM_PW_LENGTH_ERROR = 91;
    public static final int EM_INVALID_CHARS = 92;
    public static final int EM_PW_CHG_NOT_ALLOW = 93;
    public static final int EM_INVALID_PRINTER = 94;
    public static final int EM_AUTO_LOGOFF = 95;
    public static final int EM_SHUTDOWN = 96;
    public static final int EM_LABEL_PRESENT = 97;
    public static final int EM_PRINTER_JAMMED = 98;
    public static final int EM_PRINT_BUF_FULL = 99;
    public static final int EM_OUT_OF_PAPER = 100;
    public static final int EM_PRINTER_ERROR = 101;
    public static final int EM_JOLT_APP_ERROR = 102;
    public static final int EM_PASSWD_DONT_MATCH = 103;
    public static final int EM_WSL_ERROR = 104;
    public static final int EM_INTERCPT_ERROR = 105;
    public static final int EM_EJB_CONNECT = 106;
    public static final int EM_EJB_EXECUTE = 107;
    public static final int EM_INV_STAGE_AREA = 108;
    public static final int EM_ROUTE_NOT_CLOSED = 109;
    public static final int EM_NOT_RELEASED = 110;
    public static final int EM_NOT_CLEARED = 111;
    public static final int EM_AGENCY_PERMISSION = 112;
    public static final int EM_AGENCY_RESTRICT = 113;
    public static final int EM_NOT_FOUND = 114;
    public static final int EM_NO_INT2SAT = 115;
    public static final int EM_SAT_DEL_INT = 116;
    public static final int EM_DEL_SAT_INT = 117;
    public static final int EM_INVALID_HAWB = 118;
    public static final int EM_NO_INT2DEL = 119;
    public static final int EM_AB_DROPED = 120;
    public static final int EM_DUP_LABEL = 121;
    public static final int EM_PASSWORD_EXP = 122;
    public static final int EM_CHANGE_PW = 123;
    public static final int EM_SAME_AIRBILL = 124;
    public static final int EM_AB_NOT_IN_CONS = 125;
    public static final int EM_ALREADY_ADDED = 126;
    public static final int EM_PREVIOUS_ARRIVAL = 127;
    public static final int EM_PREVIOUS_DEPART = 128;
    public static final int EM_NO_ARRIVAL_SCAN = 129;
    public static final int EM_NO_DEPART_SCAN = 130;
    public static final int EM_WRONG_SHUTTLE = 131;
    public static final int EM_NO_LOOKUP = 132;
    public static final int EM_LKUP_CALL_ERR = 133;
    public static final int EM_LKUP_DATA_ERR = 134;
    public static final int EM_NOT_IN_SHIPMENT = 135;
    public static final int EM_INV_RTE_STAT_CHG = 136;
    public static final int EM_SHUTTLE_STATUS = 137;
    public static final int EM_INV_BRKR_FIN_CHG = 138;
    public static final int EM_INV_CSTM_FIN_CHG = 139;
    public static final int EM_EXT_BEAN_FAIL = 140;
    public static final int EM_INV_DETAIN_LOC = 141;
    public static final int EM_SHUTTLE_NOT_FND = 142;
    public static final int EM_ROUTE_NOT_FND = 143;
    public static final int EM_MQ_FAILURE = 144;
    public static final int EM_ASN_ERROR = 145;
    public static final int EM_INCOMPLETE_MSG = 146;
    public static final int EM_PDFFILE_CREATE = 147;
    public static final int EM_HEADER_ERROR = 148;
    public static final int EM_PRINT_CMD = 149;
    public static final int EM_INV_RTE_SDTE_CHG = 150;
    public static final int EM_NEED_TRVL_STATUS = 151;
    public static final int EM_SPLIT_MSTR = 152;
    public static final int EM_UNKNOWN_SPLIT = 153;
    public static final int EM_SPLIT_ADD_ERR = 154;
    public static final int EM_SPLIT_UPDATE_ERR = 155;
    public static final int EM_SPLIT_READ_ERR = 156;
    public static final int EM_SPLIT_DELETE_ERR = 157;
    public static final int EM_SPLIT_EXISTS = 158;
    public static final int EM_SPLIT_PRINT_ERR = 159;
    public static final int EM_SPLIT_RNM_EXISTS = 160;
    public static final int EM_SPLIT_RENAME_ERR = 161;
    public static final int EM_SPLIT_UNDEL_ERR = 162;
    public static final int EM_SPLIT_LOAD_ERR = 163;
    public static final int EM_SPLIT_ASTRA_ERR = 164;
    public static final int EM_BROKER_INFO_MIS = 165;
    public static final int EM_PARTY_INFO_MIS = 166;
    public static final int EM_NO_SHIPMENT_INFO = 167;
    public static final int EM_INVALID_POSTAL = 168;
    public static final int EM_INVALID_DEST = 169;
    public static final int EM_INVALID_ENTRY_TYP = 170;
    public static final int EM_ENTRY_RANGE_EXHAUSTED = 171;
    public static final int EM_VALUE_RESTRICTION = 172;
    public static final int EM_NOT_A_CONS = 173;
    public static final int EM_UNKNOWN_AWB = 174;
    public static final int EM_NOT_ENOUGH_INFO = 175;
    public static final int EM_CONS_PRINT_ERROR = 176;
    public static final int EM_MAX_CONS = 177;
    public static final int EM_USER_DISABLED = 178;
    
    //added by Xinghai
    public static final int EM_REPEAT_SCAN = 301;
    public static final int EM_CONS_ALREADY_EXIST = 302;
    public static final int EM_SPLIT_INVALID = 303;
    public static final int EM_CIH_SERVICE_DOWN = 304;
    public static final int EM_SPLIT_NOT_EXIST = 305;
    public static final int EM_ULDNUMBER_INVALID = 306;
    public static final int EM_DESTINATION_NOTMATCH_SPLIT = 307;
    public static final int EM_INVALID_STAT_NUMBER = 308;
    public static final int EM_CCII_FATAL = 309;
    public static final int EM_SHIPMENT_OID_NULL = 310;
    public static final int EM_HAWB_NOT_EXIST = 311;
    public static final int EM_FORGOT_RIPSCAN = 312;
    public static final int EM_PRINTER_NOTSET = 313;
    public static final int EM_NOINTERCEPT_REMOVED= 314;
    
    public static final int EM_NOT_IN_BATCH = 315;
    public static final int EM_BATCH_NOT_FOUND = 316;
	public static final int EM_DUMMY_AWB = 317;
	public static final int EM_TRUCK_NOT_FOUND = 318;
	public static final int EM_BATCH_EXISTED = 319;
	
    
    protected static final String ErrorMessage[][] = {
        {
            "EM_NO_ERROR", "Success", "", "", ""
        }, {
            "IM_MPS", "        MPS         ", "        MPS         ", "        MPS         ", "        MPS         "
        }, {
            "IM_OVERAGE", "      OVERAGE       ", "      OVERAGE       ", "      OVERAGE       ", "      OVERAGE       "
        }, {
            "IM_CLEARED", "      CLEARED       ", "      CLEARED       ", "      CLEARED       ", "      CLEARED       "
        }, {
            "IM_DUP", "        DUP         ", "        DUP         ", "        DUP         ", "        DUP         "
        }, {
            "IM_INTERCEPTED", "      INTRCPT       ", "      INTRCPT       ", "      INTRCPT       ", "      INTRCPT       "
        }, {
            "IM_DISPLAY_RTN_MSG", "", "", "", ""
        }, {
            "IM_NOT_FOUND", "     NOT FOUND      ", "     NOT FOUND      ", "     NOT FOUND      ", "     NOT FOUND      "
        }, {
            "IM_NOT_RELEASED", "    NOT RELEASED    ", "    NOT RELEASED    ", "    NOT RELEASED    ", "    NOT RELEASED    "
        }, {
            "IM_NO_ARRIVAL_SCAN", "    NO IPA SCAN     ", "    NO IPA SCAN     ", "    NO IPA SCAN     ", "    NO IPA SCAN     "
        }, {
            "IM_NO_DEPART_SCAN", "    NO DEP SCAN     ", "    NO DEP SCAN     ", "    NO DEP SCAN     ", "    NO DEP SCAN     "
        }, {
            "IM_DEL_FROM_CONS", " DELETED FROM CONS  ", " DELETED FROM CONS  ", " DELETED FROM CONS  ", " DELETED FROM CONS  "
        }, {
            "IM_CONS_EXPANDED", "   CONS EXPANDED    ", "   CONS EXPANDED    ", "   CONS EXPANDED    ", "   CONS EXPANDED    "
        }, {
            "IM_CLEARED_CONS", "    CLEARED CONS    ", "    CLEARED CONS    ", "    CLEARED CONS    ", "    CLEARED CONS    "
        }, {
            "IM_NOT_CLRED_CONS", "   NOT CLRED CONS   ", "   NOT CLRED CONS   ", "   NOT CLRED CONS   ", "   NOT_CLRED CONS   "
        }, {
            "IM_ARRIVAL_SCAN", " ARRIVAL SCAN FOUND ", " ARRIVAL SCAN FOUND ", " ARRIVAL SCAN FOUND ", " ARRIVAL SCAN FOUND "
        }, {
            "IM_DEPART_SCAN", "  DEPART SCAN FOUND ", "  DEPART SCAN FOUND ", "  DEPART SCAN FOUND ", "  DEPART SCAN FOUND "
        }, {
            "IM_NOT_DECLARED", "    NOT DECLARED    ", "    NOT DECLARED    ", "    NOT DECLARED    ", "    NOT DECLARED    "
        }, {
            "IM_INVALID_INT", " INVALID INTERCEPT  ", " INVALID INTERCEPT  ", " INVALID INTERCEPT  ", " INVALID INTERCPET  "
        }, {
            "IM_EXT_BEAN_FAIL", "External Bean Failed", "External Bean Failed", "External Bean Failed", "External Bean Failed"
        }, {
            "IM_DOMESTIC_PKG", "    DOMESTC PKG     ", "    DOMESTC PKG     ", "    DOMESTC PKG     ", "    DOMESTC PKG     "
        }, {
            "IM_CONS_ACCEPTED", "      IN CONS       ", "      IN CONS       ", "      IN CONS       ", "      IN CONS       "
        }, {
            "IM_MSG_USER_LOGOUT", "   USER LOGGED OFF  ", "   USER LOGGED OFF  ", "   USER LOGGED OFF  ", "   USER LOGGED OFF  "
        }, {
            "IM_MSG_AUTOLOGOUT", "   AUTO LOG USER OFF", "  AUTO LOG USER OFF ", "  AUTO LOG USER OFF ", "   AUTO LOG USER OFF"
        }, {
            "IM_INTRANSIT", "     INTRANSIT      ", "     INTRANSIT      ", "     INTRANSIT      ", "     INTRANSIT      "
        }, {
            "IM_RELEASED", "      RELEASED      ", "      RELEASED      ", "      RELEASED      ", "      RELEASED      "
        }, {
            "IM_ENTRY_RANGE_EXHAUSTED", "   NBR NOT AVAIL    ", "   NBR NOT AVAIL    ", "   NBR NOT AVAIL    ", "   NBR NOT AVAIL    "
        }, {
            "IM_MSG_04_LEFT", "", "", "", ""
        }, {
            "IM_MSG_03_LEFT", "", "", "", ""
        }, {
            "IM_MSG_02_LEFT", "", "", "", ""
        }, {
            "IM_MSG_01_LEFT", "", "", "", ""
        }, {
            "START_OF_ERROR_MSGS", "-+-+-+-+-+-+-+-+-+-+", "-+-+-+-+-+-+-+-+-+-+", "-+-+-+-+-+-+-+-+-+-+", "-+-+-+-+-+-+-+-+-+-+"
        }, {
            "EM_INVALID_SCAN", "   Invalid Option   ", " La Opcion Invalida ", " Option d'invalide  ", "  Ungultige Option  "
        }, {
            "EM_TRUNC_INPUT", "  Input Truncated   ", "Truncated de entrada", "Donnees ont tronque ", " Geben gekurzt ein  "
        }, {
            "EM_SCAN_ERROR", "Internal Scan Error ", " Escudrine el error ", "  Scruter l'erreur  ", "   Fuhler Prufen    "
        }, {
            "EM_USER_ERROR", " Invalid Selection  ", " Seleccion Invalida ", "Selection d'invalide", " Ungultige Auswahl  "
        }, {
            "EM_REQ_INPUT", "   Input Required   ", "La entrada Requirio ", " Les donnees Exige  ", "  Eingabe Brauchen  "
        }, {
            "EM_UNKNOWN_KEY", "Unknown Key pressed ", "La Llave desconocida", "   Clef inconnue    ", "  Unbekannte Taste  "
        }, {
            "EM_INVALID_LOGON", "   Invalid Logon    ", "   Logon Invalido   ", "  Logon d'invalide  ", "   Ungultig Logon   "
        }, {
            "EM_EXPIRED_LOGON", " UserId has expired ", "    La Id Expiro    ", "    Id a expire     ", "   Id gelaufen ab   "
        }, {
            "EM_REVOKED_LOGON", " UserId is revoked  ", "   Revoked de Id    ", "    Id revoked      ", " Id hat widerrufen  "
        }, {
            "EM_SYSTEM_ERROR", "   SYSTEM FAILURE   ", "FRACASO del SISTEMA ", "  ECHEC DE SYSTEME  ", "   SYSTEMAUSFALL    "
        }, {
            "EM_INVALID_AB", "  Invalid Airbill   ", " El Numero Invalido ", " Numero d'invalide  ", "   Ungultige Zahl   "
        }, {
            "EM_AB_NOT_ALLOWD", "Airbill not allowed ", "Numere no permitido ", "Numeroter l'invalide", "  Ungultigi Zahlen  "
        }, {
            "EM_EDIT_ERROR", "  EDIT not Loaded   ", "   EDIT no cargo    ", " EDIT ne charge pas ", " EDIT nicht beladen "
        }, {
            "EM_EDIT_VER_ERR", "    Invalid EDIT    ", "   EDIT invalido    ", "  EDIT d'invalide   ", "   Ungultig EDIT    "
        }, {
            "EM_DUP_PIECE", " Airbill not Unique ", "Numere no Extraordna", "Numeroter pas Unique", "Zahlen nicht Einmalg"
        }, {
            "EM_INV_STATUS", "Invalid Status Code ", " El Codigo Invalido ", "  Code d'invalide   ", "  Ungultiger Code   "
        }, {
            "EM_CHECK_LOG", "   CHECK LOG FILE   ", "VERIFIQUE el TRONCO ", "VERIFIER LE FICHIER ", "    KLOTZ PRUFEN    "
        }, {
            "EM_CONTACT_MGR", "  Contact Manager   ", "  Avise a Director  ", "Contacter Directeur ", " Verwalter beruhren "
        }, {
            "EM_RE_ENABLE", " to get Re-enabled  ", "  a re habilitado   ", " a re-rendu capable ", "zu betr.-ermachtigt "
        }, {
            "EM_CANNOT_MSTR", "Master not allowed  ", "Numere no permitido ", "Numeroter pas permis", "   Ungultige Zahl   "
        }, {
            "EM_DUP_SHIPMENT", "Master is not Unique", "Numere no Extraordna", "Numeroter pas Unique", "Zahlen nicht Einmalg"
        }, {
            "EM_NEED_MSTR_AB", " Need Master Number ", " Magistral Necesito ", "Maitre eu besoin de ", "Hauptzahl Gebraucht "
        }, {
            "EM_INTERNAL_ERR", "Internal Table Error", "  El Error Interno  ", "   Erreur Interne   ", "   Innerer Fehler   "
        }, {
            "EM_TRANS_XA_ERR", "   XA Trans Error   ", "El Error de XA Trans", "L'Erreur de Trans XA", "  XA Trans Fehler   "
        }, {
            "EM_MIDDLEWR_ERR", "  MiddleWare Error  ", "Error de MiddleWare ", " MiddleWare Erreur  ", " MiddleWare Fehler  "
        }, {
            "EM_DB_ERROR", "  Data Base Error   ", "El Error de DataBase", "  Data Base Erreur  ", "  Data Base Fehler  "
        }, {
            "EM_DM_BADVALUE", "DataMgr Return Error", "El Error de DataMgr ", "   DataMgr Erreur   ", "   DataMgr Fehler   "
        }, {
            "EM_REASON_CODE_REQD", "Reason Code Required", "El Codigo Requerido ", "  Le Code a Exige   ", " Code hat erfordert "
        }, {
            "EM_INV_REASON_CODE", "Invalid Reason Code ", " El Codigo Invalido ", "  Code d'invalide   ", "  Ungultiger Code   "
        }, {
            "EM_START_OVER", "Scan Error, Re-enter", " El Error, Reentre  ", "  Erreur, Rentrer   ", "Geben Sie wieder ein"
        }, {
            "EM_RELEASE_CODE_REQD", "Release Cd Required ", " Libere Codigo Req. ", " Relacher Code Exig ", "Geben Erforderlichen"
        }, {
            "EM_UNKNOWN_CODE", " Unknown Error Code ", "El Error desconocido", "  Erreur inconnue   ", " Unbekannter Fehler "
        }, {
            "EM_CONFIG_FILE_ERROR", " Config File Error  ", " El Error de Config ", "  Erreur de Config  ", " Config Dateifehler "
        }, {
            "EM_REQ_PASSWORD", " Password Required  ", "  El Sena Requirio  ", " De passse a Exige  ", " Kennwort Erfordert "
        }, {
            "EM_INVALID_DATA_FOR_SVC", "Invalid In Data Type", "Los Datos Invalidos ", " Donnees d'invalide ", "  Ungultige Daten   "
        }, {
            "EM_QUEUE_ERR", "Queue Attempt Failed", "Fracaso Que Anuncia ", "  Echec qui poste   ", "Aufstelenden Ausfall"
        }, {
            "EM_INV_RELEASE_CODE", "Invalid Release Code", "El Codigo Invalido  ", "  Code d'invalide   ", "  Ungultiger Code   "
        }, {
            "EM_DETAIN_LOC_REQD", "Detainment Loc Reqd ", "Ubicacionn Requirio ", "L'emplacement Exige ", " Ort Hat Erfordert  "
        }, {
            "EM_INVALID_FORMID", "   Invalid Entry    ", "La Entrada Invalida ", " Entree d'invalide  ", " Ungultiger Zugang  "
        }, {
            "EM_USER_NOT_ACTIVE", "  User NOT Active   ", "El usuario no activo", "Utilisatur pas actif", "    Nicht tatig     "
        }, {
            "EM_FAILED_UPLOAD", "   Upload Failure   ", " Cargue el Fracaso  ", "    Upload Echec    ", " Laden Sie Ausfall  "
        }, {
            "EM_NO_FUNCTION", " No Scans Permited  ", "    No Excudrine    ", "  Aucuns Balayages  ", "  Prufen Sie Nein   "
        }, {
            "EM_PW_FAILED", " No Password Match  ", "    Ningun Igual    ", "  Aucune Allumette  ", "  Kein Gegenstuck   "
        }, {
            "EM_CHANGE_ABORT", "   Change Aborted   ", "  El cambio Aborto  ", "Le Changement Avorte", "Anderung Abgebrochen"
        }, {
            "EM_CONS_NOT_ALLOWED", "  CONS Not Allowed  ", " CONS no permitido  ", "CONS n'a pas permis ", " CONS nicht erlaubt "
        }, {
            "EM_CONS_NOT_FOUND", "   CONS Not Found   ", "  CONS no encontro  ", "CONS n'a pas trouve ", "CONS nicht gefunden "
        }, {
            "EM_CONS_NOT_UNIQUE", "  CONS Not Unique   ", "CONS no extraordinar", "  CONS pas unique   ", "CONS nicht einmalig "
        }, {
            "EM_FAILED_SPLIT", "    Failed Split    ", "  Fallado Partido   ", "  Division Echouee  ", "  Versagten Spalt   "
        }, {
            "EM_NO_LOGON_GROUP", "   No UserId Group  ", " Gropo no Definido  ", "Ne Groupr pas Defini", "Gruppieren Verpasen "
        }, {
            "EM_INVALID_CONS", "  CONS not defined  ", "  CONS no definido  ", "CONS n'a pas defini ", "CONS nicht definiert"
        }, {
            "EM_INV_HANDLING_CODE", "Invalid Handling Cd ", " El Codigo Invalido ", "  L'invalide Code   ", "  Ungultiger Code   "
        }, {
            "EM_HANDLING_CD_REQD", " Handling Code Reqd ", "El Codigo Requerido ", "  Le Code a Exige   ", " Code hat erfordert "
        }, {
            "EM_INV_REMARK_CODE", "Invalid Remark Code ", "El Codigo Invalido  ", "  Code d'invalide   ", "  Ungultiger Code   "
        }, {
            "EM_REMARK_CODE_REQD", "Remark Code Required", "El Codigo Requerido ", "  Le Code a Exige   ", " Code hat erfordert "
        }, {
            "EM_INVALID_LANGUAGE", "  Invalid Language  ", " El Idioma Invalido ", " Langue d_invalide  ", " Ungultige Sprache  "
        }, {
            "EM_INVALID_CMD_CODE", "  Invalid Command   ", " La Orden Invalida  ", " L'invalide Ordonne ", " Ungultiger Befehl  "
        }, {
            "EM_NO_CMD_CODE", " Cmd Code Not Found ", "La Orden no Encontro", "Ordone na pas trouve", " Ungultiger Befehl  "
        }, {
            "EM_FORM_ID_REQD", "Form Type Code Reqd ", "  Forme Codigo Req  ", " Forme Code A Exige ", " Form Hat Erfordert "
        }, {
            "EM_INVALID_SPLIT", "   Invalid Split    ", " La Split Invalida  ", "  L'invalide Split  ", "  Ungultiger Split  "
        }, {
            "EM_PW_LENGTH_ERROR", "Password Length Err ", "Password Length Err ", "Password Length err ", "Password Length err "
        }, {
            "EM_INVALID_CHARS", " Invalid Characters ", " Invalid Characters ", " Invalid Characters ", " Invalid Characters "
        }, {
            "EM_PW_CHG_NOT_ALLOW", "Cannot Chng Password", "Cannot Chng Password", "Cannot Chng Password", "Cannot Chng Password"
        }, {
            "EM_INVALID_PRINTER", " Invalid Printer Id ", " Invalid Printer Id ", " Invalid Printer Id ", " Invalid Printer Id "
        }, {
            "EM_AUTO_LOGOFF", "AUTO LOGOFF OCCURED ", "AUTO LOGOFF OCCURED ", "AUTO LOGOFF OCCURED ", "AUTO LOGOFF OCCURED "
        }, {
            "EM_SHUTDOWN", "  **  SHUTDOWN  **  ", "  **  SHUTDOWN  **  ", "  **  SHUTDOWN  **  ", "  **  SHUTDOWN  **  "
        }, {
            "EM_LABEL_PRESENT", " Prev Label Present ", " Prev Label Present ", " Prev Label Present ", " Prev Label Present "
        }, {
            "EM_PRINTER_JAMMED", "   Printer Jammed   ", "   Printer Jammed   ", "   Printer Jammed   ", "   Printer Jammed   "
        }, {
            "EM_PRINT_BUF_FULL", "Printer Buffer Full ", "Printer Buffer Full ", "Printer Buffer Full ", "Printer Buffer Full "
        }, {
            "EM_OUT_OF_PAPER", "Printer Out of Paper", "Printer Out of Paper", "Printer Out of Paper", "Printer Out of Paper"
        }, {
            "EM_PRINTER_ERROR", "    Printer Error   ", "    Printer Error   ", "    Printer Error   ", "    Printer Error   "
        }, {
            "EM_JOLT_APP_ERROR", "Jolt Application Err", "Jolt Application Err", "Jolt Application Err", "Jolt Application Err"
        }, {
            "EM_PASSWD_DONT_MATCH", "Passwords dont match", "Passwords dont match", "Passwords dont match", "Passwords dont match"
        }, {
            "EM_WSL_ERROR", "WS Listner Error    ", "WS Listner Error    ", "WS Listner Error    ", "WS Listner Error    "
        }, {
            "EM_INTERCPT_ERROR", "Intercept is Invalid", "Intercept is Invalid", "Intercept is Invalid", "Intercept is Invalid"
        }, {
            "EM_EJB_CONNECT", "EJB Connect Error   ", "EJB Connect Error   ", "EJB Connect Error   ", "EJB Connect Error   "
        }, {
            "EM_EJB_EXECUTE", "EJB Execute Error   ", "EJB Execute Error   ", "EJB Execute Error   ", "EJB Execute Error   "
        }, {
            "EM_INV_STAGE_AREA", " Invalid Stage Area ", " Invalid Stage Area ", " Invalid Stage Area ", " Invalid Stage Area "
        }, {
            "EM_ROUTE_NOT_CLOSED", "  Route NOT Closed  ", "  Route NOT Closed  ", "  Route NOT Closed  ", "  Route NOT Closed  "
        }, {
            "EM_NOT_RELEASED", "    NOT RELEASED    ", "    NOT RELEASED    ", "    NOT RELEASED    ", "    NOT RELEASED    "
        }, {
            "EM_NOT_CLEARED", "    NOT CLEARED     ", "    NOT CLEARED     ", "    NOT CLEARED     ", "    NOT CLEARED     "
        }, {
            "EM_AGENCY_PERMISSION", "No Agency Permission", "No Agency Permission", "No Agency Permission", "No Agency Permission"
        }, {
            "EM_AGENCY_RESTRICT", "Agncy Invld 4 Intcpt", "Agncy Invld 4 Intcpt", "Agncy Invld 4 Intcpt", "Agncy Invld 4 Intcpt"
        }, {
            "EM_NOT_FOUND", "AWB not in Database ", "AWB not in Database ", "AWB not in Database ", "AWB not in Database "
        }, {
            "EM_NO_INT2SAT", "NO intrcpt to Satify", "NO intrcpt to Satify", "NO intrcpt to Satify", "NO intrcpt to Satify"
        }, {
            "EM_SAT_DEL_INT", "Cannot SAT a DEL Int", "Cannot SAT a DEL Int", "Cannot SAT a DEL Int", "Cannot SAT a DEL Int"
        }, {
            "EM_DEL_SAT_INT", "Cannot DEL a SAT Int", "Cannot DEL a SAT Int", "Cannot DEL a SAT Int", "Cannot DEL a SAT Int"
        }, {
            "EM_INVALID_HAWB", "    Invalid HAWB    ", "    Invalid HAWB    ", "    Invalid HAWB    ", "    Invalid HAWB    "
        }, {
            "EM_NO_INT2DEL", "NO intrcpt to Remove", "NO intrcpt to Remove", "NO intrcpt to Remove", "NO intrcpt to Remove"
        }, {
            "EM_AB_DROPED", "AWB NOT processed", "Numere NO Procesado", "Numeroter pas Traite", "Nicht Bearbeitet"
        }, {
            "EM_DUP_LABEL", " Apply Label to Pkg ", " Apply Label to Pkg ", " Apply Label to Pkg ", " Apply Label to Pkg "
        }, {
            "EM_PASSWORD_EXP", "  Password Expired  ", "  Password Expired  ", "  Password Expired  ", "  Password Expired  "
        }, {
            "EM_CHANGE_PW", "  Change Password   ", "  Change Password   ", "  Change Password   ", "  Change Password   "
        }, {
            "EM_SAME_AIRBILL", "    Same Airbill    ", "    Same Airbill    ", "    Same Airbill    ", "    Same Airbill    "
        }, {
            "EM_AB_NOT_IN_CONS", " Entry not in CONS  ", " Entry not in CONS  ", " Entry not in CONS  ", " Entry not in CONS  "
        }, {
            "EM_ALREADY_ADDED", " AWB Already Added  ", " AWB Already Added  ", " AWB Already Added  ", " AWB Already Added  "
        }, {
            "EM_PREVIOUS_ARRIVAL", "Previous Arrival Scn", "Previous Arrival Scn", "Previous Arrival Scn", "Previous Arrival Scn"
        }, {
            "EM_PREVIOUS_DEPART", " Previous Depart Scn", " Previous Depart Scn", " Previous Depart Scn", " Previous Depart Scn"
        }, {
            "EM_NO_ARRIVAL_SCAN", "  No Arrival Scan   ", "  No Arrival Scan   ", "  No Arrival Scan   ", "  No Arrival Scan   "
        }, {
            "EM_NO_DEPART_SCAN", "   No Depart Scan   ", "   No Depart Scan   ", "   No Depart Scan   ", "   No Depart Scan   "
        }, {
            "EM_WRONG_SHUTTLE", "   Wrong Shuttle    ", "   Wrong Shuttle    ", "   Wrong Shuttle    ", "   Wrong Shuttle    "
        }, {
            "EM_NO_LOOKUP", "  Lookup Not Found  ", "  Lookup Not Found  ", "  Lookup Not Found  ", "  Lookup Not Found  "
        }, {
            "EM_LKUP_CALL_ERR", "  Lookup Call Error ", "  Lookup Call Error ", "  Lookup Call Error ", "  Lookup Call Error "
        }, {
            "EM_LKUP_DATA_ERR", "  Lookup Data Error ", "  Lookup Data Error ", "  Lookup Data Error ", "  Lookup Data Error "
        }, {
            "EM_NOT_IN_SHIPMENT", "Not part of Shipment", "Not part of Shipment", "Not part of Shipment", "Not part of Shipment"
        }, {
            "EM_INV_RTE_STAT_CHG", "Invalid Rte Stat Chg", "Invalid Rte Stat Chg", "Invalid Rte Stat Chg", "Invalid Rte Stat Chg"
        }, {
            "EM_SHUTTLE_STATUS", "  Bad Shuttle Status", "  Bad Shuttle Status", "  Bad Shuttle Status", "  Bad Shuttle Status"
        }, {
            "EM_INV_BRKR_FIN_CHG", "Invalid Brkr Fin Chg", "Invalid Brkr Fin Chg", "Invalid Brkr Fin Chg", "Invalid Brkr Fin Chg"
        }, {
            "EM_INV_CSTM_FIN_CHG", "Invalid Cstm Fin Chg", "Invalid Cstm Fin Chg", "Invalid Cstm Fin Chg", "Invalid Cstm Fin Chg"
        }, {
            "EM_EXT_BEAN_FAIL", "External Bean Failed", "External Bean Failed", "External Bean Failed", "External Bean Failed"
        }, {
            "EM_INV_DETAIN_LOC", " Invalid Detain Loc ", " Invalid Detain Loc ", " Invalid Detain Loc ", " Invalid Detain Loc "
        }, {
            "EM_SHUTTLE_NOT_FND", " Shuttle Not Found  ", " Shuttle Not Found  ", " Shuttle Not Found  ", " Shuttle Not Found  "
        }, {
            "EM_ROUTE_NOT_FND", "Inbnd Rte Not Found ", "Inbnd Rte Not Found ", "Inbnd Rte Not Found ", "Inbnd Rte Not Found "
        }, {
            "EM_MQ_FAILURE", "     MQ Failure     ", "     MQ Failure     ", "     MQ Failure     ", "     MQ Failure     "
        }, {
            "EM_ASN_ERROR", "  ASN Encode Error  ", "  ASN Encode Error  ", "  ASN Encode Error  ", "  ASN Encode Error  "
        }, {
            "EM_INCOMPLETE_MSG", "    Empty Message   ", "    Empty Message   ", "  Empty Message     ", "  Empty Message     "
        }, {
            "EM_PDFFILE_CREATE", "Cannotcreate PDFFile", "Cannotcreate PDFFile", "Cannotcreate PDFFile", "Cannotcreate PDFFile"
        }, {
            "EM_HEADER_ERROR", "Error creatingHeader", "Error creatingHeader", "Error creatingHeader", "Error creatingHeader"
        }, {
            "EM_PRINT_CMD", "Print Command Error ", "Print Command Error ", "Print Command Error ", "Print Command Error "
        }, {
            "EM_INV_RTE_SDTE_CHG", "Inv Rte Sort Dt  Chg", "Inv Rte Sort Dt  Chg", "Inv Rte Sort Dt  Chg", "Inv Rte Sort Dt  Chg"
        }, {
            "EM_NEED_TRVL_STATUS", " Need Travel Status ", " Need Travel Status ", " Need Travel Status ", " Need Travel Status "
        }, {
            "EM_SPLIT_MSTR", " Scan Split Master  ", " Scan Split Master  ", " Scan Split Master  ", " Scan Split Master  "
        }, {
            "EM_UNKNOWN_SPLIT", "   Unknown Split    ", "   Unknown Split    ", "   Unknown Split    ", "   Unknown Split    "
        }, {
            "EM_SPLIT_ADD_ERR", "  Split ADD Error   ", "  Split ADD Error   ", "  Split ADD Error   ", "  Split ADD Error   "
        }, {
            "EM_SPLIT_UPDATE_ERR", " Split UPDATE Error ", " Split UPDATE Error ", " Split UPDATE Error ", " Split UPDATE Error "
        }, {
            "EM_SPLIT_READ_ERR", "  Split READ Error  ", "  Split READ Error  ", "  Split READ Error  ", "  Split READ Error  "
        }, {
            "EM_SPLIT_DELETE_ERR", " Split DELETE Error ", " Split DELETE Error ", " Split DELETE Error ", " Split DELETE Error "
        }, {
            "EM_SPLIT_EXISTS", "Split already Exists", "Split already Exists", "Split already Exists", "Split already Exists"
        }, {
            "EM_SPLIT_PRINT_ERR", " Split PRINT Error  ", " Split PRINT Error  ", " Split PRINT Error  ", " Split PRINT Error  "
        }, {
            "EM_SPLIT_RNM_EXISTS", "Rename alredy Exists", "Rename alredy Exists", "Rename alredy Exists", "Rename Alredy Exists"
        }, {
            "EM_SPLIT_RENAME_ERR", " Split RENAME Error ", " Split RENAME Error ", " Split RENAME Error ", " Split RENAME Error "
        }, {
            "EM_SPLIT_UNDEL_ERR", "Split UNDELETE Error", "Split UNDELETE Error", "Split UNDELETE Error", "Split UNDELETE Error"
        }, {
            "EM_SPLIT_LOAD_ERR", "  Split LOAD Error  ", "  Split LOAD Error  ", "  Split LOAD Error  ", "  Split LOAD Error  "
        }, {
            "EM_SPLIT_ASTRA_ERR", "Split Invalid ASTRA ", "Split Invalid ASTRA ", "Split Invalid ASTRA ", "Split Invalid ASTRA "
        }, {
            "EM_BROKER_INFO_MIS", "Broker Info missing ", "Broker Info missing ", "Broker Info missing ", "Broker Info missing "
        }, {
            "EM_PARTY_INFO_MIS", " Party Info missing ", " Party Info missing ", " Party Info missing ", " Party Info missing "
        }, {
            "EM_NO_SHIPMENT_INFO", "  NO Shipment Info  ", "  NO Shipment Info  ", "  NO Shipment Info  ", "  NO Shipment Info  "
        }, {
            "EM_INVALID_POSTAL", "Invalid Postal Info ", "Invalid Postal Info ", "Invalid Postal Info ", "Invalid Postal Info "
        }, {
            "EM_INVALID_DEST", " Invalid Dest Info  ", " Invalid Dest Info  ", " Invalid Dest Info  ", " Invalid Dest Info  "
        }, {
            "EM_INVALID_ENTRY_TYP", " Invalid Entry Type ", " Invalid Entry Type ", " Invalid Entry Type ", " Invalid Entry Type "
        }, {
            "EM_ENTRY_RANGE_EXHAUSTED", "Entry Nbr not Avail ", "Entry Nbr not Avail ", "Entry Nbr not Avail ", "Entry Nbr not Avail "
        }, {
            "EM_VALUE_RESTRICTION", " Value Restriction  ", " Value Restriction  ", " Value Restriction  ", " Value Restriction  "
        }, {
            "EM_NOT_A_CONS", "  Entry NOT a CONS  ", "  Entry NOT a CONS  ", "  Entry NOT a CONS  ", "  Entry NOT a CONS  "
        }, {
            "EM_UNKNOWN_AWB", " Unknown AirwayBill ", " Unknown AirwayBill ", " Unknown AirwayBill ", " Unknown AirwayBill "
        }, {
            "EM_NOT_ENOUGH_INFO", "  NOT enough Info   ", "  NOT enough Info   ", "  NOT enough Info   ", "  NOT enough Info   "
        }, {
            "EM_CONS_PRINT_ERROR", "  CONS Print Error  ", "  CONS Print Error  ", "  CONS Print Error  ", "  CONS Print Error  "
        }, {
            "EM_MAX_CONS", "MAX entries in List ", "MAX entries in List ", "MAX entries in List ", "MAX entries in List "
        }, {
            "EM_USER_DISABLED", " UserId is Disabled ", " UserId is Disabled ", " UserId is Disabled ", " UserId is Disabled "
        }, {
            "MeSSaGe SenTInAL", "MeSSaGe SenTInAL", "", "", ""
        }
    };
    public static final int SM_NUMBER_OF_LANGUAGES_PROMPTMESSAGE = 4;
    public static final int SM_MAX_FIELD_WIDTH_PROMPTMESSAGE = 20;
    public static final int PM_UNKNOWN_CODE = 0;
    public static final int PM_LANGUAGE = 1;
    public static final int PM_ASK_TITLE = 2;
    public static final int PM_DEVICE_1 = 3;
    public static final int PM_DEVICE_2 = 4;
    public static final int PM_DEVICE_3 = 5;
    public static final int PM_DEVICE_4 = 6;
    public static final int PM_DEVICE_5 = 7;
    public static final int PM_DEVICE_6 = 8;
    public static final int PM_DEVICE_7 = 9;
    public static final int PM_DEVICE_8 = 10;
    public static final int PM_DEVICE_9 = 11;
    public static final int PM_DEVICE_10 = 12;
    public static final int PM_DEVICE_11 = 13;
    public static final int PM_DEVICE_12 = 14;
    public static final int PM_DISPLAY_MENU = 15;
    public static final int PM_EXIT = 16;
    public static final int PM_RESET_SCAN = 17;
    public static final int PM_SCAN_AIRBILL = 18;
    public static final int PM_SPS_SCAN = 19;
    public static final int PM_LANG_TITLE = 20;
    public static final int PM_LOGON_EXIT = 21;
    public static final int PM_SELECTION = 22;
    public static final int PM_SCAN_COMPLETE = 23;
    public static final int PM_ADD_TO_CONS_LIST = 24;
    public static final int PM_OVER_RIDE_1 = 25;
    public static final int PM_OVER_RIDE_2 = 26;
    public static final int PM_PACKAGE = 27;
    public static final int PM_SPLIT_NUMBER = 28;
    public static final int PM_SPLITS_RENAME = 29;
    public static final int PM_NEW_SPLIT_NUM = 30;
    public static final int PM_ORIG_SPLIT_NUM = 31;
    public static final int PM_SPLITS_CONTINUE = 32;
    public static final int PM_SCAN_SPLITS = 33;
    public static final int PM_F1_BACK_TO_MENU = 34;
    public static final int PM_F2_TO_CONTINUE = 35;
    public static final int PM_ENTER_F2_FOR_I = 36;
    public static final int PM_ENTER_F4_FOR_D = 37;
    public static final int PM_DOM_OR_INTL = 38;
    public static final int PM_ASK_FORMID = 39;
    public static final int PM_REASON_CODE = 40;
    public static final int PM_STATUS_CODE = 41;
    public static final int PM_COMMENTS = 42;
    public static final int PM_MDE_ROUTE = 43;
    public static final int PM_FLIGHT_NUMBER = 44;
    public static final int PM_FLIGHT_DATE = 45;
    public static final int PM_LOGON_REQ = 46;
    public static final int PM_DUPLICATES = 47;
    public static final int PM_DUP_SELECT = 48;
    public static final int PM_DUP_INCREMENT = 49;
    public static final int PM_DUP_ORIG_INFO = 50;
    public static final int PM_DUP_DEST_INFO = 51;
    public static final int PM_DUP_SERVICE = 52;
    public static final int PM_DUP_LABEL = 53;
    public static final int PM_REASON = 54;
    public static final int PM_DAMAGE = 55;
    public static final int PM_PAPERWORK = 56;
    public static final int PM_CONS_TYPE = 57;
    public static final int PM_PPWK_CONS = 58;
    public static final int PM_OTHER_CONS = 59;
    public static final int PM_SCAN_CONS = 60;
    public static final int PM_CONT_TYPE = 61;
    public static final int PM_ULD = 62;
    public static final int PM_CAGE = 63;
    public static final int PM_BAG = 64;
    public static final int PM_OTHER = 65;
    public static final int PM_CTV = 66;
    public static final int PM_FLIGHT = 67;
    public static final int PM_FEEDER = 68;
    public static final int PM_SHUTTLE = 69;
    public static final int PM_BULK = 70;
    public static final int PM_POUCH = 71;
    public static final int PM_BOX = 72;
    public static final int PM_CONS_DEST = 73;
    public static final int PM_OTHER_DESC = 74;
    public static final int PM_ULD_NUMBER = 75;
    public static final int PM_CAGE_NUMBER = 76;
    public static final int PM_COMMENT_TYPE = 77;
    public static final int PM_CONS_ID = 78;
    public static final int PM_MASTER = 79;
    public static final int PM_UNKNOWN = 80;
    public static final int PM_LOADING_APP = 81;
    public static final int PM_WELCOME = 82;
    public static final int PM_GOOD_BYE = 83;
    public static final int PM_UNLOAD_APP = 84;
    public static final int PM_FREIGHT = 85;
    public static final int PM_NEED_MSTR_AB = 86;
    public static final int PM_PASSWORD = 87;
    public static final int PM_RELEASE_CODE = 88;
    public static final int PM_DETAIN_LOC = 89;
    public static final int PM_AB_PROBLEM = 90;
    public static final int PM_AB_CONFIRM = 91;
    public static final int PM_DET_LOC = 92;
    public static final int PM_ENTRY_TYPE = 93;
    public static final int PM_SUCCESS = 94;
    public static final int PM_PASSWORD_CHANGE = 95;
    public static final int PM_OLD_PASSWORD = 96;
    public static final int PM_NEW_PASSWORD = 97;
    public static final int PM_PW_CHANGED = 98;
    public static final int PM_ABORT_CHANGE = 99;
    public static final int PM_REENTER_PW = 100;
    public static final int PM_PKG_CONDITION = 101;
    public static final int PM_PKG_CRUSHED = 102;
    public static final int PM_PKG_WET = 103;
    public static final int PM_PKG_TORN = 104;
    public static final int PM_PKG_RE_WRAP = 105;
    public static final int PM_PKG_RE_TAPE = 106;
    public static final int PM_WS_LANGUAGE = 107;
    public static final int PM_HAND_INST = 108;
    public static final int PM_HAND_DESC = 109;
    public static final int PM_REMARK_CODE = 110;
    public static final int PM_REMARK_DESC = 111;
    public static final int PM_SPLIT_NAME = 112;
    public static final int PM_DUTY_CODE = 113;
    public static final int PM_ROUTE_NBR = 114;
    public static final int PM_PRINTER_ID = 115;
    public static final int PM_STAGE_AREA = 116;
    public static final int PM_PECO_SCAN = 117;
    public static final int PM_CECO_SCAN = 118;
    public static final int PM_DEP_SCAN = 119;
    public static final int PM_MENU_GROUP_0 = 120;
    public static final int PM_MENU_GROUP_1 = 121;
    public static final int PM_MENU_GROUP_2 = 122;
    public static final int PM_MENU_GROUP_3 = 123;
    public static final int PM_MENU_GROUP_4 = 124;
    public static final int PM_MENU_GROUP_5 = 125;
    public static final int PM_MENU_GROUP_6 = 126;
    public static final int PM_MENU_GROUP_7 = 127;
    public static final int PM_MENU_GROUP_8 = 128;
    public static final int PM_MENU_GROUP_9 = 129;
    public static final int PM_INFO_TITLE = 130;
    public static final int PM_INFO_RETURN = 131;
    public static final int PM_CONS_LABEL = 132;
    public static final int PM_RETRIEVE_LABEL = 133;
    public static final int PM_CONS_LIST = 134;
    public static final int PM_ENTER_MASTER = 135;
    public static final int PM_PROCESSING_CONS = 136;
    public static final int PM_DUP_FUNC_KEYS = 137;
    public static final int PM_DUP_INCRE = 138;
    public static final int PM_LABEL_YN = 139;
    public static final int PM_ADD_CONS = 140;
    public static final int PM_DELIV_CONS = 141;
    
    

    protected static final String PromptMessage[][] = {
        {
            "PM_UNKNOWN_CODE", "Unknown Prompt Code", "Unknown Prompt Code", "Unknown Prompt Code", "Unknown Prompt Code"
        }, {
            "PM_LANGUAGE", " 1 - ENGLISH", " 2 - EL_ESPANOL", " 3 - FRANCAIS", " 4 - DEUTSCH"
        }, {
            "PM_ASK_TITLE", "   SELECT  DEVICE   ", "EL ARTEFACTO SELECTO", "CHOISIR L'APPAREIL", "ERLESENE VORRICHTUNG"
        }, {
            "PM_DEVICE_1", " Intermec 2415", " Intermec 2415", " Intermec 2415", " Intermec 2415"
        }, {
            "PM_DEVICE_2", " Ring Scanner", " Ring Scanner", " Ring Scanner", " Ring Scanner"
        }, {
            "PM_DEVICE_3", " LXE 2280", " LXE 2280", " LXE 2280", " LXE 2280"
        }, {
            "PM_DEVICE_4", " Janus 2010", " Janus 2010", " Janus 2010", " Janus 2010"
        }, {
            "PM_DEVICE_5", " Intermec 2480", " Intermec 2480", " Intermec 2480", " Intermec 2480"
        }, {
            "PM_DEVICE_6", " Intermec 2485", " Intermec 2485", " Intermec 2485", " Intermec 2485"
        }, {
            "PM_DEVICE_7", " Monarch 4-Line", " Monarch 4-Line", " Monarch 4-Line", " Monarch 4-Line"
        }, {
            "PM_DEVICE_8", " Monarch 8-Line", " Monarch 8-Line", " Monarch 8-Line", " Monarch 8-Line"
        }, {
            "PM_DEVICE_9", " Intermec CK30", " Intermec CK30", " Intermec CK30", " Intermec CK30"
        }, {
            "PM_DEVICE_10", " PC Terminal", " PC Terminal", " PC Terminal", " PC Terminal"
        }, {
            "PM_DEVICE_11", "", "", "", ""
        }, {
            "PM_DEVICE_12", "", "", "", ""
        }, {
            "PM_DISPLAY_MENU", "Select from List", "Escoja de la Lista", "Choisir de la Liste", "Wahlen von Liste aus"
        }, {
            "PM_EXIT", "<F1> to Exit", "<F1> a la Salida", "<F1> a la Sortie ", "<F1> Zu Ausgang"
        }, {
            "PM_RESET_SCAN", "<F3> to ReStart", "<F3> al Comienzo", "<F3> du Debut", "<F3> Zu Anfang"
        }, {
            "PM_SCAN_AIRBILL", "SCAN:", "ESCUDRINE:", "BALAYAGE:", "PRUFEN SIE:"
        }, {
            "PM_SPS_SCAN", " PKG STATUS:        ", " PKG STATUS:        ", " PKG STATUS:        ", " PKG STATUS:        "
        }, {
            "PM_LANG_TITLE", "Languages Supported", "Los Idiomas", "Langues Disponibles", "Verfugbare Sprachen"
        }, {
            "PM_LOGON_EXIT", "Exiting, no Signin", "Salir, ningun Signin", "Sortir, aucun Signin", "Ausgang, kein Signin"
        }, {
            "PM_SELECTION", "Selection:", "La Seleccion:", "Selection:", "Auswhal:"
        }, {
            "PM_SCAN_COMPLETE", "Scan Completed", "Escudrine Completado", "Le Balayage Complete", "Prufen Sie Vollendet"
        }, {
            "PM_ADD_TO_CONS_LIST", "<F6>Add to CONS list", "<F6>Add to CONS list", "<F6>Add to CONS list", "<F6>Add to CONS list"
        }, {
            "PM_OVER_RIDE_1", "Override Restriction", "Override Restriction", "Override Restriction", "Override Restriction"
        }, {
            "PM_OVER_RIDE_2", "On Value (Y or N):  ", "On Value (Y or N):  ", "On Value (Y or N):  ", "On Value (Y or N):  "
        }, {
            "PM_PACKAGE", "PKG:", "PKG:", "PKG:", "PKG:"
        }, {
            "PM_SPLIT_NUMBER", "Split Num:          ", "Split Num:          ", "Split Num:          ", " Split Num:         "
        }, {
            "PM_SPLITS_RENAME", "   Splits Rename    ", "   Splits Rename    ", "   Splits Rename    ", "   Splits Rename    "
        }, {
            "PM_NEW_SPLIT_NUM", "New Split Num:      ", "New Split Num:      ", "New Split Num:      ", "New Split Num:      "
        }, {
            "PM_ORIG_SPLIT_NUM", "Orig Split Num:     ", "Orig Split Num:     ", "Orig Split Num:     ", "Orig Split Num:     "
        }, {
            "PM_SPLITS_CONTINUE", "Continue Split Scan ", "Continue Split Scan ", "Continue Split Scan ", "Continue Split Scan "
        }, {
            "PM_SCAN_SPLITS", "Scan Splits         ", "Scan Splits         ", "Scan Splits         ", "Scan Splits         "
        }, {
            "PM_F1_BACK_TO_MENU", "<F1> Back to MENU   ", "<F1> Back to MENU   ", "<F1> Back to MENU   ", "<F1> Back to MENU   "
        }, {
            "PM_F2_TO_CONTINUE", "<F2> to Continue:   ", "<F2> to Continue:   ", "<F2> to Continue:   ", "<F2> to Continue:   "
        }, {
            "PM_ENTER_F2_FOR_I", "<F2> Intl Pkg:      ", "<F2> Intl Pkg:      ", "<F2> Intl Pkg:      ", "<F2> Intl Pkg:      "
        }, {
            "PM_ENTER_F4_FOR_D", "<F4> Domestic Pkg:  ", "<F4> Domestic Pkg:  ", "<F4> Domestic Pkg:  ", "<F4> Domestic Pkg:  "
        }, {
            "PM_DOM_OR_INTL", "INTL or DOMSTIC Pkg ", "INTL or DOMSTIC Pkg ", "INTL or DOMSTIC Pkg ", "INTL or DOMSTIC Pkg "
        }, {
            "PM_ASK_FORMID", "FORM ID:", "FORME TIPO:", "FORMER TYPE:", "BILDEN TYP:"
        }, {
            "PM_REASON_CODE", "REASON CODE:", "RAZONE CODIGO:", "RAISSONER CODE:", "LOGISCH CODE:"
        }, {
            "PM_STATUS_CODE", "STATUS CODE:", "LA POSICION:", "CODE DE STATUT:", "STATUS CODE:"
        }, {
            "PM_COMMENTS", "COMMENTS:", "LOS COMENTARIOS:", "COMMENTAIRES:", "BEMERKUNGEN:"
        }, {
            "PM_MDE_ROUTE", "MDE ROUTE#:", "RUTA de MDE#:", "MDE ROUTE#:", "MDE ROUTE#:"
        }, {
            "PM_FLIGHT_NUMBER", "FLT/RTE#:", "VUELO/RUTA#:", "VOL/ROUTE:", "FLUG/ROUTE#:"
        }, {
            "PM_FLIGHT_DATE", "FLT/RTE DATE (^ - v)", "FECHA VUELO (^ - v)", "DATE de VOL (^ - v)", "FLUG DATUM (^ - v)"
        }, {
            "PM_LOGON_REQ", "User Id:", "El Usuario:", "Utilisateur:", "Verbraucher:"
        }, {
            "PM_DUPLICATES", "Resolve Duplicates", "Resuelva Duplicado", "Resoudre le Double", "Losen Kopie auf"
        }, {
            "PM_DUP_SELECT", "<F6> to Select      ", "<F6> a Selecto      ", "<F6> a Choisir      ", "<F6> Zu erlesen     "
        }, {
            "PM_DUP_INCREMENT", " Increment (^ - v)  ", " Incremento (^ - v) ", " Graduation (^ - v) ", "  Inkrement (^ - v) "
        }, {
            "PM_DUP_ORIG_INFO", "ORIG:", "ORIG:", "ORIG:", "ORIG:"
        }, {
            "PM_DUP_DEST_INFO", "DEST:", "DEST:", "DEST:", "DEST"
        }, {
            "PM_DUP_SERVICE", "SERVICE:", "SERVICIO:", "SERVICE:", "DIENST:"
        }, {
            "PM_DUP_LABEL", "<F8> DUP Label      ", "<F8> DUP Lable      ", "<F8> DUP Label      ", "<F8> DUP Label      "
        }, {
            "PM_REASON", "REASON:", "RAZON:", "RAISON:", "GRUND:"
        }, {
            "PM_DAMAGE", "DAMAGE:", "EL DANO:", "DOMMAGES:", "SCHADEN:"
        }, {
            "PM_PAPERWORK", "Paperwork", "El papeleo", "Travail de Papier", "Papierearbiet"
        }, {
            "PM_CONS_TYPE", "  Select CONS Type  ", "Tipo selecto de CONS", "Choisir le type CONS", "Erlesen CONS typ"
        }, {
            "PM_PPWK_CONS", "Paperwork CONS", "El papelco de CONS", "Travail Papier CONS", "Papierearbiet CONS"
        }, {
            "PM_OTHER_CONS", "Other CONS", "Otro CONS", "Autre CONS", "Ander CONS"
        }, {
            "PM_SCAN_CONS", "SCAN CONS:", "SCAN CONS:", "SCAN CONS:", "SCAN CONS:"
        }, {
            "PM_CONT_TYPE", "Select Container", "Contenedor Selecto", "Choisir le Recipient", "Erlesener Behalter"
        }, {
            "PM_ULD", "ULD", "ULD", "ULD", "ULD"
        }, {
            "PM_CAGE", "Cage", "Jaula", "Cage", "Kafig"
        }, {
            "PM_BAG", "Bag", "Bolsa", "Sac", "Sack"
        }, {
            "PM_OTHER", "Other", "Otro", "Autre", "Ander"
        }, {
            "PM_CTV", "CTV", "CIV", "CIV", "Civ"
        }, {
            "PM_FLIGHT", "Flight", "Vuelo", "Vol", "Flug"
        }, {
            "PM_FEEDER", "Feeder Flight", "Vuelo de Alimentador", "Vol d'alimenteur", "Feeder Flug"
        }, {
            "PM_SHUTTLE", "Shuttle Flight", "Vuelo Transbordador", "Vol de Navette", "Shuttle Flug"
        }, {
            "PM_BULK", "Bulk Wrap", "El Bulto Envuelve", "La Masse Emballe", "Hauptteil Hulle"
        }, {
            "PM_POUCH", "Pouch", "Pouch", "Pouch", "Pouch"
        }, {
            "PM_BOX", "Box", "Caja", "Boite", "Kasten"
        }, {
            "PM_CONS_DEST", "CONS DEST:", "CONS DEST:", "CONS DEST:", "CONS DEST:"
        }, {
            "PM_OTHER_DESC", "OTHER:", "OTRO:", "AUTRE:", "ANDER:"
        }, {
            "PM_ULD_NUMBER", "ENTER ULD:", "ENTRE ULD:", "ENTRER ULD:", "TRAGEN ULD:"
        }, {
            "PM_CAGE_NUMBER", "ENTER CAGE:", "ENTRE JAULA:", "ENGRER CAGE:", "TRAGEN KAFIG:"
        }, {
            "PM_COMMENT_TYPE", "Select Comment Type", "Comenta el Tipo ?", "Commente le Type ?", "Kommentiren Sie Typ?"
        }, {
            "PM_CONS_ID", "CONS:", "CONS:", "CONS:", "CONS:"
        }, {
            "PM_MASTER", "MASTER:", "EL AMO:", "MAITRE:", "MEISTER:"
        }, {
            "PM_UNKNOWN", "<F6> if unknown ", "<F6> si desconocido", "<F6> S'Inconnu", "<F6> wenn unbekannt "
        }, {
            "PM_LOADING_APP", "Loading Application ", "Aplicacion que Carga", "Aplicaton qui charge", "   Ladeanwendung    "
        }, {
            "PM_WELCOME", "      Welcome       ", "   La Bienvenida    ", "      Accueil       ", "      Empfang       "
        }, {
            "PM_GOOD_BYE", " Have a nice day !! ", "Tenga dia agradable!", "Avoir jour agreable!", "Haben Sie netten Tag"
        }, {
            "PM_UNLOAD_APP", " Unload Application ", "Descargue Aplicacion", "Decharger Applicaton", " Entladen Anwendung "
        }, {
            "PM_FREIGHT", "Freight", "El Flete", "Fret", "Fracht"
        }, {
            "PM_NEED_MSTR_AB", "Need Master Number", "Magistral Necesito", "Maitre eu besoin de", "Hauptzahl Gebraucht"
        }, {
            "PM_PASSWORD", "Password:", "La sena:", "Mot de passe:", "Kennwort:"
        }, {
            "PM_RELEASE_CODE", "RELEASE CODE:", "LIBERE CODIGO:", "RELACHEMENT CODE:", "ENTLASSUNG CODE:"
        }, {
            "PM_DETAIN_LOC", "Detainment Loc:", "Retenga Ubica:", "Detainment Empla:", "Ort der Haft:"
        }, {
            "PM_AB_PROBLEM", "Entry Error !!", "Entrada del Error!!", "Entree d'erreur !!", "Fehlerzugang !!"
        }, {
            "PM_AB_CONFIRM", "Override Error?:", "Haga caso omiso?:", "Annule l'Erruer?:", "Haben Sie auf?:"
        }, {
            "PM_DET_LOC", "Detain Loc:", "Detain Loc:", "Detain Loc:", "Detain Loc:"
        }, {
            "PM_ENTRY_TYPE", "Entry Type:", "Entry Type:", "Entry Type:", "Entry Type:"
        }, {
            "PM_SUCCESS", "   ** SUCCESS **    ", "   ** SUCCESS **    ", "   ** SUCCESS **    ", "   ** SUCCESS **    "
        }, {
            "PM_PASSWORD_CHANGE", "<F4> Change Password", "<F4> Cambie La Sena", "<F4>Changer de passe", "<F4> Andern Kennwort"
        }, {
            "PM_OLD_PASSWORD", "Old Password:", "La sena viega:", "Vieux passe:", "Altes Kennwort:"
        }, {
            "PM_NEW_PASSWORD", "New Password:", "La sena nueva:", "Nouveau passe:", "Neues Kennwort:"
        }, {
            "PM_PW_CHANGED", "  Password Changed  ", "   La sena Cambio   ", " De Passe A Change  ", "  Kennwort Geandert "
        }, {
            "PM_ABORT_CHANGE", "<F1> Abort Change", "<F1> Aborte Cambio", "<F1> Avorter Change", "<F1>Brachen Anderung"
        }, {
            "PM_REENTER_PW", "Re-enter Password", "Reentre la Sena", "Rentrer de passe", "Tragen Sie Kennwort"
        }, {
            "PM_PKG_CONDITION", "Package Condition", "Embale la Condidion", "Emballer Condition", "Verpacken Bedingung"
        }, {
            "PM_PKG_CRUSHED", "Crushed", "Aplastado", "Ecrase", "Zerquetscht"
        }, {
            "PM_PKG_WET", "Wet", "Mojado", "Mouille", "Nass"
        }, {
            "PM_PKG_TORN", "Torn", "Roto", "Dechire", "Zerrissen"
        }, {
            "PM_PKG_RE_WRAP", "Re-Wrap", "Re-Envuelva", "Emballer nouveau", "Betr. Hulle"
        }, {
            "PM_PKG_RE_TAPE", "Re-Tape", "Re Cinta", "Re la Bande", "Betr. Band"
        }, {
            "PM_WS_LANGUAGE", "ENGLISH", "EL ESPANOL", "FRANCAIS", "DEUTSCH"
        }, {
            "PM_HAND_INST", "HNDL INST:", "INSTRUC:", "INSTRUC:", "ANWEISUNGEN:"
        }, {
            "PM_HAND_DESC", "HANDL DESC:", "LA DESC:", "DESC:", "BESCH:"
        }, {
            "PM_REMARK_CODE", "REMARK CODE:", "OBSERVE CODIGO:", "REMARQUE CODE:", "BEMERKEN CODE:"
        }, {
            "PM_REMARK_DESC", "REMARK DESC:", "LA DESC:", "DESC:", "BESCH:"
        }, {
            "PM_SPLIT_NAME", "SPLIT:", "SPLIT:", "SPLIT:", "SPLIT:"
        }, {
            "PM_DUTY_CODE", "Duty Code:", "Duty Code:", "Duty Code:", "Duty Code:"
        }, {
            "PM_ROUTE_NBR", "Route Nbr:", "Route Nbr:", "Route Nbr:", "Route Nbr:"
        }, {
            "PM_PRINTER_ID", "Printer Id:", "Printer Id:", "Printer Id:", "Printer Id:"
        }, {
            "PM_STAGE_AREA", "Staging Area:", "Staging Area:", "Staging Area:", "Staging Area:"
        }, {
            "PM_PECO_SCAN", " PECO SCAN:         ", " PECO SCAN:         ", " PECO SCAN:         ", " PECO SCAN:         "
        }, {
            "PM_CECO_SCAN", " CECO SCAN:         ", " CECO SCAN:         ", " CECO SCAN:         ", " CECO SCAN:         "
        }, {
            "PM_DEP_SCAN", " DEP SCAN:          ", " DEP SCAN:          ", " DEP SCAN:          ", " DEP SCAN:          "
        }, {
            "PM_MENU_GROUP_0", "Corporate Scans", "Corporatvo Scan", "Corporatin Scan", "Betriegs Scans"
        }, {
            "PM_MENU_GROUP_1", "Inventory Scans", "Inventario Scan", "Inventaire Scan", "Inventar Scans"
        }, {
            "PM_MENU_GROUP_2", "Intercept Scans", "Intercepte Scan", "Interceptr Scan", "Abschnitt Scans"
        }, {
            "PM_MENU_GROUP_3", "Printer Options", "Printer Options", "Printer Options", "Printer Options"
        }, {
            "PM_MENU_GROUP_4", "", "", "", ""
        }, {
            "PM_MENU_GROUP_5", "", "", "", ""
        }, {
            "PM_MENU_GROUP_6", "", "", "", ""
        }, {
            "PM_MENU_GROUP_7", "", "", "", ""
        }, {
            "PM_MENU_GROUP_8", "", "", "", ""
        }, {
            "PM_MENU_GROUP_9", "", "", "", ""
        }, {
            "PM_INFO_TITLE", "--Additional Info-- ", "--Additional Info-- ", "--Additional Info-- ", "--Additional Info-- "
        }, {
            "PM_INFO_RETURN", "   <F2> to return   ", "   <F2> to return   ", "   <F2> to return   ", "   <F2> to return   "
        }, {
            "PM_CONS_LABEL", "<F8> Print CONS labl", "<F8> Print CONS labl", "<F8> Print CONS labl", "<F8> Print CONS labl"
        }, {
            "PM_RETRIEVE_LABEL", "   Retrieve Label   ", "   Retrieve Label   ", "   Retrieve Label   ", "   Retrieve Label   "
        }, {
            "PM_CONS_LIST", " Building CONS List ", " Building CONS List ", " Building CONS List ", " Building CONS List "
        }, {
            "PM_ENTER_MASTER", "<F4> Enter Master", "<F4> Enter Master", "<F4> Enter Master", "<F4> Enter Master"
        }, {
            "PM_PROCESSING_CONS", "  Processing CONS   ", "  Processing CONS   ", "  Processing CONS   ", "  Processing CONS   "
        }, {
            "PM_DUP_FUNC_KEYS", "<F6>Selct  <F8>Label", "<F6>Selct  <F8>Label", "<F6>Selct  <F8>Label", "<F6>Selct  <F8>Label"
        }, {
            "PM_DUP_INCRE", "Incre(^-v)", "Incre(^-v)", "Incre(^-v)", "Incre(^-v)"
        }, {
            "PM_LABEL_YN", "Next Label(Y/N):    ", "Next Label(Y/N):    ", "Next Label(Y/N):    ", "Next Label(Y/N):    "
        }, {
            "PM_ADD_CONS", "  Add to CONS List  ", "  Add to CONS List  ", "  Add to CONS List  ", "  Add to CONS List  "
        }, {
            "PM_DELIV_CONS", "Delivery CONS       ", "Delivery CONS       ", "Delivery CONS       ", "Delivery CONS       "
        }, {
            "MeSSaGe SenTInAL", "MeSSaGe SenTInAL", "", "", ""
        }
    };
    public static final int SM_NUMBER_OF_LANGUAGES_LOGMESSAGE = 1;
    public static final int SM_MAX_FIELD_WIDTH_LOGMESSAGE = 0;
    public static final int LM_1S_EDIT_LOAD_ERROR = 0;
    public static final int LM_1S_EDIT_VERSION_ERROR = 1;
    public static final int LM_0S_EDIT_READ_ERROR = 2;
    public static final int LM_1S_INTERNAL_INCONSISTANCY = 3;
    public static final int LM_1S_CORRUPTION_ERROR = 4;
    public static final int LM_1S_CONSECUTIVE_ERRORS = 5;
    public static final int LM_1S_ALLOCATION_ERROR = 6;
    public static final int LM_2S_MIDDLEWARE_INFO = 7;
    public static final int LM_2S_MIDDLEWARE_WARN = 8;
    public static final int LM_2S_MIDDLEWARE_ERROR = 9;
    public static final int LM_2S_MIDDLEWARE_FATAL = 10;
    public static final int LM_0S_NO_MIDDLEWARE = 11;
    public static final int LM_1S_ALLOCATION_FAILED = 12;
    public static final int LM_1S_CALL_FAILED = 13;
    public static final int LM_1S_QUEUE_ERROR = 14;
    public static final int LM_1S_TRANSACTION_REQUIRED = 15;
    public static final int LM_2S_TPOPEN_FAIL = 16;
    public static final int LM_2S_TPCLOSE_FAIL = 17;
    public static final int LM_2S_TRANSACTION_ERROR = 18;
    public static final int LM_3S_CONNECT_DB_FAIL = 19;
    public static final int LM_3S_DB_ERROR = 20;
    public static final int LM_0S_INTERNAL_TABLE_ERROR = 21;
    public static final int LM_2S_DB_NOENTRY = 22;
    public static final int LM_2S_DB_MORE_THAN_ONE_ENTRY = 23;
    public static final int LM_1S_DB_INVALID_RESULTS = 24;
    public static final int LM_1S_CAUGHT_FX_EXCEPTION = 25;
    public static final int LM_4S_FX_EXCEPTION = 26;
    public static final int LM_1S_SVCBASE_CALL_FAILED = 27;
    public static final int LM_0S_INVALID_DATAMANAGER = 28;
    public static final int LM_2S_STANDARD_EXCEPTION = 29;
    public static final int LM_1S_UNEXPECTED_EXCEPTION = 30;
    public static final int LM_1S_TRANSACTION_MONITOR_MSG = 31;
    public static final int LM_2S_INVALID_DATA_TYPE = 32;
    public static final int LM_3S_FAILED_IPC_GET = 33;
    public static final int LM_3S_FAILED_IPC_CREATE = 34;
    public static final int LM_3S_FAILED_IPC_CTL = 35;
    public static final int LM_3S_FAILED_IPC_OP = 36;
    public static final int LM_4S_UNKNOWN_CODE = 37;
    public static final int LM_1S_FAILED_INIT_OBJECT = 38;
    public static final int LM_1S_FAILED_OPEN_FILE = 39;
    public static final int LM_3S_FAILED_SYSTEM_CALL = 40;
    public static final int LM_2S_DATA_OUTPUT = 41;
    public static final int LM_2S_UNKNOWN_NOTIFICATION_TYPE = 42;
    public static final int LM_2S_ARM_FAILURE = 43;
    public static final int LM_2S_NO_CONFIG_VAR_FATAL = 44;
    public static final int LM_2S_NO_CONFIG_VAR_WARN = 45;
    public static final int LM_3S_MQ_FAILURE = 46;
    public static final int LM_1S_MQ_MESSAGE = 47;
    public static final int LM_1S_ASN_FAILURE = 48;
    public static final int LM_2S_ASN_FAILED = 49;
    public static final int LM_2S_INVALID_OID_TYPE = 50;
    public static final int LM_1S_OIDFACTORY_FAILED = 51;
    public static final int LM_2S_UNKNOWN_IMPORT_RULE = 52;
    public static final int LM_2S_FAILED_MEM_ALLOC = 53;
    public static final int LM_1S_CREATE_OID_ERROR = 54;
    public static final int LM_1S_INVALID_NTN_AWB_GEN = 55;
    public static final int LM_4S_WARN_MESSAGE = 56;
    public static final int LM_5S_USER_LOGOUT = 57;
    protected static final String LogMessage[][] = {
        {
            "LM_1S_EDIT_LOAD_ERROR", "401001 EDIT Table did not load, Error: %s"
        }, {
            "LM_1S_EDIT_VERSION_ERROR", "401002 Invalid EDIT File Version or Expired EDIT File: %s"
        }, {
            "LM_0S_EDIT_READ_ERROR", "401003 EDIT file memory transfer error"
        }, {
            "LM_1S_INTERNAL_INCONSISTANCY", "401004 Internal Table Inconsistancy: %s"
        }, {
            "LM_1S_CORRUPTION_ERROR", "101005 Corruption Repaired: %s"
        }, {
            "LM_1S_CONSECUTIVE_ERRORS", "201006 Consecutive Errors: %s"
        }, {
            "LM_1S_ALLOCATION_ERROR", "402001 Memory Allocation Error: %s"
        }, {
            "LM_2S_MIDDLEWARE_INFO", "103001 MiddleWare Information %s : %s"
        }, {
            "LM_2S_MIDDLEWARE_WARN", "203002 MiddleWare Warning %s : %s"
        }, {
            "LM_2S_MIDDLEWARE_ERROR", "303003 MiddleWare Error %s : %s"
        }, {
            "LM_2S_MIDDLEWARE_FATAL", "403004 MiddleWare Fatal %s : %s"
        }, {
            "LM_0S_NO_MIDDLEWARE", "403005 MiddleWare Product had not been started"
        }, {
            "LM_1S_ALLOCATION_FAILED", "403006 Allocate View Error in MiddleWare Object: %s"
        }, {
            "LM_1S_CALL_FAILED", "403007 MiddleWare 'Call' failure: %s"
        }, {
            "LM_1S_QUEUE_ERROR", "303008 Failure to put message on Tux Queue: %s"
        }, {
            "LM_1S_TRANSACTION_REQUIRED", "303009 Method call:  %s was called outside a MW Transaction"
        }, {
            "LM_2S_TPOPEN_FAIL", "403010 tpopen() call Failed:  %s:%s"
        }, {
            "LM_2S_TPCLOSE_FAIL", "403011 tpclose() call Failed:  %s:%s"
        }, {
            "LM_2S_TRANSACTION_ERROR", "403012 Error calling: %s;  TM Message:  %s"
        }, {
            "LM_3S_CONNECT_DB_FAIL", "404001 Failed to connect to database: %s:%s:%s"
        }, {
            "LM_3S_DB_ERROR", "404002 Database Error: Msg:%s  VMsg1:%s  VMsg2:%s"
        }, {
            "LM_0S_INTERNAL_TABLE_ERROR", "404003 Unable to load Internal Tables"
        }, {
            "LM_2S_DB_NOENTRY", "304004 No Entry Found: %s %s"
        }, {
            "LM_2S_DB_MORE_THAN_ONE_ENTRY", "304005 More Than One Entry Found: %s %s"
        }, {
            "LM_1S_DB_INVALID_RESULTS", "304006 Invalid results returned by DB:  Result: %s"
        }, {
            "LM_1S_CAUGHT_FX_EXCEPTION", "304007 FxException from: %s"
        }, {
            "LM_4S_FX_EXCEPTION", "304008 AppCode1:  %s  AppCode2:  %s  AppText:  %s  TextDesc:  %s"
        }, {
            "LM_1S_SVCBASE_CALL_FAILED", "408001 Failed to call SvcBase::%s"
        }, {
            "LM_0S_INVALID_DATAMANAGER", "308002 Datamanager object is invalid"
        }, {
            "LM_2S_STANDARD_EXCEPTION", "408003 Caught a C++ run-time exception from:  %s  Desc:  %s"
        }, {
            "LM_1S_UNEXPECTED_EXCEPTION", "408004 Caught an unexpected exception from:  %s"
        }, {
            "LM_1S_TRANSACTION_MONITOR_MSG", "208005 TM Message:  %s"
        }, {
            "LM_2S_INVALID_DATA_TYPE", "308006 Invalid data type for this service...%s:%s"
        }, {
            "LM_3S_FAILED_IPC_GET", "308007 Failed to get %s ID:  (%s):%s"
        }, {
            "LM_3S_FAILED_IPC_CREATE", "308008 Failed to create a %s:  (%s):%s"
        }, {
            "LM_3S_FAILED_IPC_CTL", "308009 Failed to %sctl():  (%s):%s"
        }, {
            "LM_3S_FAILED_IPC_OP", "308010 Failed to %sop():  (%s):%s"
        }, {
            "LM_4S_UNKNOWN_CODE", "308011 Unknown Log Code:  %s:%s:%s:%s"
        }, {
            "LM_1S_FAILED_INIT_OBJECT", "408012 Failed to initialize %s object"
        }, {
            "LM_1S_FAILED_OPEN_FILE", "408013 Failed to open file:  %s"
        }, {
            "LM_3S_FAILED_SYSTEM_CALL", "408014 Failed to %s:  (%s):%s"
        }, {
            "LM_2S_DATA_OUTPUT", "208015 %-20s = %s"
        }, {
            "LM_2S_UNKNOWN_NOTIFICATION_TYPE", "308016 Unknown Notification Type for Level %s:  %s"
        }, {
            "LM_2S_ARM_FAILURE", "208017 ARM Failure: %s %s"
        }, {
            "LM_2S_NO_CONFIG_VAR_FATAL", "411001 CONFIG variable %s not configured,  %s"
        }, {
            "LM_2S_NO_CONFIG_VAR_WARN", "211002 CONFIG variable %s not configured, (default used)  %s"
        }, {
            "LM_3S_MQ_FAILURE", "311003 MQ error, MQ name: %s, MQ reason %s, Error: %s"
        }, {
            "LM_1S_MQ_MESSAGE", "211004 MQ Message: %s"
        }, {
            "LM_1S_ASN_FAILURE", "411005 ASN Failure: %s"
        }, {
            "LM_2S_ASN_FAILED", "411006 Failed to perform ASN function %s:  %s"
        }, {
            "LM_2S_INVALID_OID_TYPE", "311007 Invalid Oid Type specified in table:  %s row:  %s"
        }, {
            "LM_1S_OIDFACTORY_FAILED", "311008 OidFactory Failure detected:  %s"
        }, {
            "LM_2S_UNKNOWN_IMPORT_RULE", "411009 Specified Import Rule Not Found  Project:  %s  Service:  %s"
        }, {
            "LM_2S_FAILED_MEM_ALLOC", "411010 Failed to allocate Memory:  (%s):%s "
        }, {
            "LM_1S_CREATE_OID_ERROR", "311011 Failed to create an Oid value for %s "
        }, {
            "LM_1S_INVALID_NTN_AWB_GEN", "311012 NTN AWB created by awbGen service was invalid. AWB generated: %s"
        }, {
            "LM_4S_WARN_MESSAGE", "211013 Warning Message: %s : %s : %s : %s"
        }, {
            "LM_5S_USER_LOGOUT", "101002 User: %s Location: %s Duty code: %s Org code: %s Device: %s"
        }, {
            "MeSSaGe SenTInAL", "MeSSaGe SenTInAL"
        }
    };
    public static final int SM_NUMBER_OF_LANGUAGES_TRACEMESSAGE = 1;
    public static final int SM_MAX_FIELD_WIDTH_TRACEMESSAGE = 0;
    public static final int TM_4S_UNKNOWN_CODE = 0;
    public static final int TM_2S_SERVER_BOOTING = 1;
    public static final int TM_2S_SERVER_FAILED_INIT = 2;
    public static final int TM_2S_SERVER_SHUTTING_DOWN = 3;
    public static final int TM_2S_CLIENT_BOOTING = 4;
    public static final int TM_2S_CLIENT_SHUTTING_DOWN = 5;
    public static final int TM_1S_CALLING_GETSERVICE = 6;
    public static final int TM_1S_SUCCESS_FROM_SERVICE = 7;
    public static final int TM_1S_FAILURE_FROM_SERVICE = 8;
    public static final int TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN = 9;
    public static final int TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY = 10;
    public static final int TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION = 11;
    public static final int TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN = 12;
    public static final int TM_3S_ACTIVATING_RESET = 13;
    public static final int TM_4S_SUBSCRIBING = 14;
    public static final int TM_2S_UNKNOWN_NOTIFICATION_TYPE = 15;
    public static final int TM_3S_RESETTING = 16;
    public static final int TM_2S_SERVER_FAILED_RESET = 17;
    public static final int TM_1S_CHECKPOINT = 18;
    public static final int TM_2S_CHECKPOINT = 19;
    public static final int TM_3S_CHECKPOINT = 20;
    public static final int TM_4S_CHECKPOINT = 21;
    public static final int TM_3S_DEBUG_MSG = 22;
    public static final int TM_2S_DATA_OUTPUT = 23;
    public static final int TM_2S_SERVICE_ENTRY_DATA = 24;
    public static final int TM_2S_SERVICE_EXIT_DATA = 25;
    public static final int TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN = 26;
    public static final int TM_0S_CONNECTING_TO_DB = 27;
    public static final int TM_1S_CONFIG_READING_FILE = 28;
    public static final int TM_1S_REVISION = 29;
    public static final int TM_2S_ARM_ACTION = 30;
    protected static final String TraceMessage[][] = {
        {
            "TM_4S_UNKNOWN_CODE", "000001 Unknown Trace Message:  %s:%s:%s:%s"
        }, {
            "TM_2S_SERVER_BOOTING", "000002 Server %s(%s) booting"
        }, {
            "TM_2S_SERVER_FAILED_INIT", "000003 Server %s(%s) Failed to initialize"
        }, {
            "TM_2S_SERVER_SHUTTING_DOWN", "000004 Server %s(%s) shutting down"
        }, {
            "TM_2S_CLIENT_BOOTING", "000005 Client %s(%s) booting"
        }, {
            "TM_2S_CLIENT_SHUTTING_DOWN", "000006 Client %s(%s) shutting down"
        }, {
            "TM_1S_CALLING_GETSERVICE", "000007 Service %s now calling getService()"
        }, {
            "TM_1S_SUCCESS_FROM_SERVICE", "000008 Returning Success from service %s"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE", "000009 Returning Failure from service %s"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE_UNEXPECTED_RETURN", "000010 Returning Failure from service %s:  Unexpected return value"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE_CAUGHT_NOTIFY", "000011 Returning Failure from service %s:  caught notify"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE_CAUGHT_FXEXCEPTION", "000012 Returning Failure from service %s:  caught FxException"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE_CAUGHT_UNKNOWN", "000013 Returning Failure from service %s:  caught unknown exception"
        }, {
            "TM_3S_ACTIVATING_RESET", "000014 Activating a reset for IPC_KEY:  %s  OldVal:  %s  NewVal: %s"
        }, {
            "TM_4S_SUBSCRIBING", "000015 Subscribing:  Expr:  %s  Filter:  %s  Method: %s  Name: %s"
        }, {
            "TM_2S_UNKNOWN_NOTIFICATION_TYPE", "000016 Unknown Notification Type for Level %s:  %s"
        }, {
            "TM_3S_RESETTING", "000017 Reset detected for IPC_KEY:  %s  OldVal:  %s NewVal:  %s"
        }, {
            "TM_2S_SERVER_FAILED_RESET", "000018 Server %s(%s) Failed to reset()"
        }, {
            "TM_1S_CHECKPOINT", "000019 Trace check point:  <%s>"
        }, {
            "TM_2S_CHECKPOINT", "000020 Method: %s, Trace check point:  <%s>"
        }, {
            "TM_3S_CHECKPOINT", "000021 Method: %s, Trace check point: <%s>  <%s>"
        }, {
            "TM_4S_CHECKPOINT", "000022 Method: %s, Trace check point  <%s>  <%s>  <%s>"
        }, {
            "TM_3S_DEBUG_MSG", "000023 **** DEBUG - Service Name: %s  Method: %s  Text: %s"
        }, {
            "TM_2S_DATA_OUTPUT", "000024 %-20s = %s"
        }, {
            "TM_2S_SERVICE_ENTRY_DATA", "000025 Service %s(%s) Input Data"
        }, {
            "TM_2S_SERVICE_EXIT_DATA", "000026 Service %s(%s) Return Data"
        }, {
            "TM_1S_FAILURE_FROM_SERVICE_CAUGHT_STD_EXCPTN", "000027 Returning Failure from service %s:  caught Standard Exception"
        }, {
            "TM_0S_CONNECTING_TO_DB", "000028 Connecting to the database"
        }, {
            "TM_1S_CONFIG_READING_FILE", "000029 Reading config file:  %s"
        }, {
            "TM_1S_REVISION", "000030 %s"
        }, {
            "TM_2S_ARM_ACTION", "000031 ARM Action: %s %s"
        }, {
            "MeSSaGe SenTInAL", "MeSSaGe SenTInAL"
        }
    };

}
