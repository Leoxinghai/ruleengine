package cciij.Security;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.*;

import weblogic.wtc.jatmi.Reply;
import weblogic.wtc.jatmi.TPException;
import weblogic.wtc.jatmi.TPServiceInformation;
import weblogic.wtc.jatmi.TypedView32;

import cciij.cciidata.SecLOnView;
import cciij.cciidata.SecLOffView;
import cciij.Security.CCIISecurityBean;
import cciij.WSUtil.UserAttributes;
import rmtc.util.Config;

/**
 * <p>Title: CCIISecurityTuxedoBean</p>
 *
 * <p>Description: This Bean will be instantiated by the Web Logic to Tuxedo
 *    Connector (WTC). The WTC will convert the Tuxedo view SecLOnView or SecLOffView to a
 *    Java class using the same name (e.g. SecLOnView). The view object will be
 *    passed as an argument to the service() method. The service() method will
 *    determine the view type and call the appropriate method (e.g. login(), or logout()).
 *    The actual login and logout of the user to/from the application will be via the
 *    CCIISecurityBean.</p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: FedEx Services</p>
 * @author Ed McAleer
 * @version 1.0
 *
 * Modification History:
 * 
 *	09/30/2004	Ed McAleer - Add code to call SIP a second time for password change and
 *							 fix problem with not returning error code.
 */
public class CCIISecurityTuxedoBean
    implements SessionBean
{
    protected SessionContext m_sctx = null;

    public void setSessionContext(SessionContext sctx)
    {
        m_sctx = sctx;
    }

    public void ejbCreate()
    {
        System.out.println("CCIISecurityTuxedoBean.ejbCreate()");
    }

    public void ejbRemove()
    {
        System.out.println("CCIISecurityTuxedoBean.ejbRemove()");
    }

    public void ejbActivate()
    {
        System.out.println("CCIISecurityTuxedoBean.ejbActivate()");
    }

    public void ejbPassivate()
    {
        System.out.println("CCIISecurityTuxedoBean.ejbPassivate()");
    }

    public void rollback()
    {
        if (m_sctx != null)
        {
            m_sctx.setRollbackOnly();
        }

        // If this class were to implement a MessageDriven Bean or Entity Bean,
        //   here would be the code to set the rollbackonly flag on those Context types
    }

    /**
     * login
     * <p>This method will log a user into the application via the CCIISecurityBean.</p>
     * @param secLOnView View containing the following information that is used to log
     *        the user into the application.
     * <UL>
     * <LI>User Id
     * <LI>Password
     * <LI>New Password
     * <LI>Loacation Code
     * </UL>
     *
     * <p> NOTE:  The current
     * @return SecLOnView - updated view that includes org code and access list.
     */
    protected SecLOnView login(SecLOnView secLOnView) throws java.lang.Exception
    {
        boolean chgPwd = false;
        SecLOnView returnData = new SecLOnView();
        String confirmPwd = secLOnView.gets_newPassword();
        int DEFAULT_LOCATION_LANGUAGE = 0;

        //Gather configuration information and set the location code for the site
        //specific parameters.
        Config config = new Config();
        config.setLocationCode(secLOnView.gets_locationCode());

        try
        {
            //The following is a work around because the SecLOnView does not contain a language argument.
            Integer defLang = new Integer(config.getValue("DEFAULT_LOCATION_LANGUAGE"));
            DEFAULT_LOCATION_LANGUAGE = defLang.intValue();
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("CCIISecurityTuxedoBean.login() - Number Format Exception for Integer");
            nfe.printStackTrace(System.out);
            throw new java.lang.Exception("CCIISecurityTuxedoBean.login() - Number Format Exception for Integer");
        }

        //Check if new password is populated and set chgPwd flag true.
        if (secLOnView.gets_newPassword() != null)
        {
            chgPwd = true;
        }

        System.out.println("CCIISecurityTuxedoBean.login() - Perform login");

        //Call security bean login method to log user into application.
        CCIISecurityBean cciiSecBean = new CCIISecurityBean();
        UserAttributes userAttributes;

        try
        {
            userAttributes = cciiSecBean.login(secLOnView.gets_userId(),
                                               secLOnView.gets_password(),
                                               DEFAULT_LOCATION_LANGUAGE,
                                               chgPwd,
                                               secLOnView.gets_newPassword(),
                                               confirmPwd,
                                               secLOnView.gets_locationCode());

            System.out.println("CCIISecurityTuxedoBean.login() - Login user attributes"
                               + userAttributes.toString());

			//If password was changed call login again to actually log the user into the application 
			//with the new password.
			if ( chgPwd )
			{
				//Set password data and chgPwd flag for normal login.
				chgPwd = false;
				secLOnView.sets_password(secLOnView.gets_newPassword());
				secLOnView.sets_newPassword("");
				confirmPwd="";


            	userAttributes = cciiSecBean.login(secLOnView.gets_userId(),
                                               		secLOnView.gets_password(),
                                               		DEFAULT_LOCATION_LANGUAGE,
                                               		chgPwd,
                                               		secLOnView.gets_newPassword(),
                                               		confirmPwd,
                                               		secLOnView.gets_locationCode());

            	System.out.println("CCIISecurityTuxedoBean.login() - Login user attributes"
                               		+ userAttributes.toString());

			}

            //Convert UserAttribute Acl vector into a string
            Enumeration enum = userAttributes.getAcl().elements();
            String accessList = "";

            while (enum.hasMoreElements())
            {
				if (accessList.length() > 0)
				{
                    accessList += ",";
				}
                accessList = accessList + enum.nextElement();

            }

			accessList += "";

            System.out.println("CCIISecurityTuexdoBean.login() - Error Code = " + userAttributes.getErrorCode());
            returnData.seti_errorNumber(userAttributes.getErrorCode());

            System.out.println("CCIISecurityTuxedoBean.login() - Access list string = " + accessList);

            //Set accessList attribute to accessList string.
            returnData.sets_accessList(accessList);
        }
        catch (java.rmi.RemoteException ae)
        {
            System.out.println("CCIISecurityTuxedoBean.login() - RMI Remote Exception");
            ae.printStackTrace(System.out);
            throw new java.lang.Exception("CCIISecurityTuxedoBean.login() - RMI Remote Exception");
        }

        return returnData;
    }

    /**
     * logout
     * <p> Method that logs a user out of the Application via the CCIISecurityBean.</p>
     * @param secLOffView - View containing the logout user and site information.
     */
    protected void logout(SecLOffView secLOffView) throws java.lang.Exception
    {

        CCIISecurityBean cciiSecBean = new CCIISecurityBean();

        //Log the user out of the application.
        try
        {
            cciiSecBean.logout(secLOffView.gets_userId(), secLOffView.gets_locationCode());
        }
        catch (java.rmi.RemoteException ae)
        {
            System.out.println("CCIISecurityTuxedoBean.logout() - RMI Remote Exception");
            ae.printStackTrace();

            throw new java.lang.Exception("CCIISecurityTuxedoBean.logout() - RMI Remote Exception");
        }
    }

    /**
     * service
     *
     * @param mydata TPServiceInformation Tuxedo view containing either SecLOnView or SecLOffView data.
     * @throws TPException
     * @return Reply - Modified view data containing the login or logout information.
     */
    public Reply service(TPServiceInformation tuxView) throws TPException
    {
        String serviceName = tuxView.getServiceName();
        System.out.println("CCIISecurityTuxedoBean.service() DataType = " + serviceName);

        try
        {
            System.out.println("CCIISecurityTuxedoBean.service()   (from System.out)");

            SecLOnView data;
            SecLOnView returnData = new SecLOnView();
            data = (SecLOnView) tuxView.getServiceData();

            String tmp ="\nd_returnStatus = " + data.getd_returnStatus() +
                "\ns_returnMessage = " + data.gets_returnMessage() +
                "\ns_inViewName = " + data.gets_inViewName() +
                "\ns_outViewName = " + data.gets_outViewName() +
                "\ns_locationCode " + data.gets_locationCode() +
                "\nl_sysDateTime = " + data.getl_sysDateTime() +
                "\ns_userLogon = " + data.gets_userLogon() +
                "\ns_orgCode = " + data.gets_orgCode() +
                "\ns_inputDevice = " + data.gets_inputDevice() +
                "\ni_errorNumber = " + data.geti_errorNumber() +
                "\ni_auditCode = " + data.geti_auditCode() +
                "\ns_userId = " + data.gets_userId() +
                "\ns_password = " + data.gets_password() +
                "\ns_newPassword = " + data.gets_newPassword() +
                "\ns_appCode = " + data.gets_appCode() +
                "\ns_dutyCode = " + data.gets_dutyCode() +
                "\ns_orgCd = " + data.gets_orgCd() +
                "\ns_accessList = " + data.gets_accessList();

            /*
              SecLOffView logOffData;
              SecLOffView logOffRtnData = new SecLOffView();
              logOffData = (SecLOffView) tuxView.getServiceData();
            */
            System.out.println("CCIISecurityTuxedoBean.service() - \n\nSecLOnView contains = \n" + tmp + "\n\n");
            System.out.println("CCIISecurityTuxedoBean.service() - \nSecLOnView using toString(): "
                               + data.toString() + "\n");

            //Determine which Security view is contained in the tuxView.
            if (serviceName.equals("SECLON"))
            {
                //System.out.println("CCIISecurityTuxedoBean.service() - \nSecLOnView contains: "
                //                 + data.toString() + "\n");

                returnData = login(data);
            }
            /*
              else if (serviceName.equals("SECLOFF"))
              {
              System.out.println("CCIISecurityTuxedoBean.service() - \nSecLOffView contains: "
              + logOffData.toString() + "\n");
              logout(logOffData);
              }
              else //tuxView contains unknown service name.
              {
              System.out.println("CCIISecurityTuxedoBean.service() - Tux View contains an unknown service name");
              }
            */
            //            returnData.sets_accessList("BIN");
            System.out.println("CCIISecurityTuxedoBean.service() return data = " + returnData.toString());
            tuxView.setReplyBuffer(returnData);

            return (tuxView);
        }
        catch (Exception e)
        {
            System.out.println("CCIISecurityTuxedoBean.service() Caught Exception in CCIISecurityTuxedoBean:  " + e);
            e.printStackTrace(System.out);
            throw new TPException(TPException.TPESYSTEM,
                                  "CCIISecurityTuxedoBean.service()Caught Exception in CCIISecurityTuxedoBean:  " + e);
        }
    }
}
//*************************************** END OF CLASS **************************************************


