package cciij.businessActions;

/**
 * Title:        Business Action Factory Types
 * Description:  Business Action type constants
 * Copyright:    Copyright (c) 2001
 * Company:      Fedex Services
 * @author       Robert Fisher
 * @version 1.0
 */

public class BusinessActionFactoryTypes {
    private static final String m_whatVersion = "@(#) $RCSfile: BusinessActionFactoryTypes.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    public static final int DO_IT = 0;


    public static final int FINDTRACKINGNUMBER  = 0;
    public static final int FINDINTERCEPT       = 1;
    public static final int ENCODEANDUPLOAD     = 2;
    public static final int HANDLINGUNITOVERAGE = 3;
    public static final int SHIPMENTOVERAGE     = 4;
    public static final int POSTSCAN            = 5;
    public static final int INTERCEPTLABEL      = 6;
    public static final int OVERAGELABEL        = 7;
    public static final int CLEAREDLABEL        = 8;
    public static final int PRINTERLABEL        = 9;
    public static final int MPSLABEL            = 10;
    public static final int DUPLICATELABEL      = 11;
    public static final int DATEOVERAGELABEL    = 12;
    public static final int ROUTEOVERAGELABEL   = 13;
    public static final int VERIFYHUROUTE       = 14;
    public static final int VERIFYHUSORTDATE    = 15;
    public static final int GETPACKAGESTATUS    = 16;
    public static final int GETROUTING          = 17;
    public static final int BACKGROUNDPRINT     = 18;
    public static final int VERIFYSTAGINGAREA   = 19;
    public static final int POSTHANDLINGUNIT    = 20;
    public static final int POSTSHIPMENT        = 21;
    public static final int POSTACTIVITY        = 22;
    public static final int CREATEINTERCEPT     = 23;
    public static final int SATISFYSTAGEAREAINTERCEPTS = 24;
    public static final int VERIFYROUTEPROVIDED = 25;
    public static final int GETCONTEXT          = 26;
    public static final int FINDHANDLINGUNIT    = 27;
    public static final int FINDSHIPMENT        = 28;
    public static final int FINDHAWB            = 29;
    public static final int FINDCUSTOMSRELEASE  = 30;
    public static final int BACKGROUNDQUEUE     = 31;
    public static final int ADDDELSATINTERCEPT  = 32;
    public static final int ASSIGNCRNTOHAWB     = 33;
    public static final int PICKLISTLABEL       = 34;
    public static final int FORMATSUCCESSLABEL  = 35;
    public static final int DOWNLOADLABELFORMATS= 36;
    public static final int VERIFYARRIVALSCAN   = 37;
    public static final int STAGEAREALABEL      = 38;
    public static final int DETAINLOCLABEL      = 39;
    public static final int DUPLICATEPROCESSING01 = 40;
    public static final int POSTMASTERROUTETOCRN= 41;
    public static final int FINDCONSSUMMARY     = 42;
    public static final int FINDCONS            = 43;
    public static final int FINDNESTEDCONSSUMMARY = 44;
    public static final int CREATECONSSUMMARY   = 45;
    public static final int CREATECONS          = 46;
    public static final int REMOVECONS          = 47;

    public static final int ACTIONMAX = 48;

    private BusinessActionFactoryTypes() {
    }
}
