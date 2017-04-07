// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JSIPConverter.java

package cciij.util.sip;

import cciij.util.Notify;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import queries.UserQuery;
import rmtc.util.Config;
import sipdata.CategoryNameType;
import sipdata.User;
import sipexception.SIPException;
import sipinterface.UserAccess;
import sipinterface.UserAccessHome;

public class JSIPConverter
{

    public JSIPConverter()
    {
        s_returnMessage = null;
        s_accessList = null;
        i_errorNumber = 0;
        context = null;
        myUserAccessHome = null;
        host = "patrai";
        port = "7001";
        query = null;
        s_orgCode = null;
        notify = new Notify();
        if(getHostAndPort())
            try
            {
                context = getInitialContext();
                Object objref = context.lookup("SIPUserAccess");
                myUserAccessHome = (UserAccessHome)PortableRemoteObject.narrow(objref, sipinterface.UserAccessHome.class);
            }
            catch(NamingException e)
            {
                System.out.println("JSIPConverter - Naming exception dump stack and then report error");
                e.printStackTrace();
                i_errorNumber = 57;
                Notify _tmp = notify;
                logError(5, 57, "Naming Exception using SIPUserAccess");
            }
            catch(Throwable te)
            {
                System.out.println("JSIPConverter::JSIPConverter - Throwable exception caught");
                System.out.println("\n**************** Begin Exception **************\n");
                te.printStackTrace(System.out);
                System.out.println("\n**************** END Exception **************\n");
            }
    }

    private boolean getHostAndPort()
    {
        String configFileName = System.getProperty("CONFIG_FILENAME");
        Config config = new Config();
        host = config.getString("HOST");
        port = config.getString("PORT");
        if(host.length() == 0 || port.length() == 0)
        {
            i_errorNumber = 57;
            Notify _tmp = notify;
            logError(5, 57, "Host or Port have no value.");
            return false;
        } else
        {
            return true;
        }
    }

    private UserAccess getAccessInstance()
    {
        UserAccess access = null;
        try
        {
            access = myUserAccessHome.create();
        }
        catch(RemoteException re)
        {
            System.out.println("JSIPConverter::getAccessInstance - Remote Exception");
            i_errorNumber = 57;
            Notify _tmp = notify;
            logError(5, 57, re.getMessage());
        }
        catch(CreateException ce)
        {
            System.out.println("JSIPConverter::getAccessInstance - Create Exception");
            i_errorNumber = 57;
            Notify _tmp1 = notify;
            logError(5, 57, ce.getMessage());
        }
        catch(SIPException e)
        {
            System.out.println("JSIPConverter::getAccessInstance - SIP Exception");
            i_errorNumber = 57;
            Notify _tmp2 = notify;
            logError(5, 57, e.getMessage());
        }
        catch(Throwable te)
        {
            System.out.println("JSIPConverter::getAccessInstance - Throwable Exception");
            System.out.println("\n**************** Begin Exception **************\n");
            te.printStackTrace(System.out);
            System.out.println("\n**************** END Exception **************\n");
        }
        return access;
    }

    private InitialContext getInitialContext()
        throws NamingException
    {
        Hashtable ht = new Hashtable();
        String url = "t3://" + host + ":" + port;
        ht.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
        ht.put("java.naming.provider.url", "t3://" + host + ":" + port);
        InitialContext context = new InitialContext(ht);
        return context;
    }

    private boolean createACL(String location)
    {
        boolean locationFound = false;
        s_accessList = "";
        Vector aclVector = new Vector();
        String groups[] = query.getGroups();
        if(groups != null)
        {
            for(int g = 0; g < groups.length; g++)
            {
                String groupList[] = new String[1];
                groupList[0] = groups[g];
                CategoryNameType categories[] = query.getCategories(groupList);
                if(categories != null)
                {
                    for(int c = 0; c < categories.length; c++)
                        if(categories[c].getName().equals("LOC_CODE") && categories[c].getType().equals(location))
                        {
                            locationFound = true;
                            String rights[] = query.getRights(groupList);
                            if(rights != null)
                            {
                                for(int r = 0; r < rights.length; r++)
                                    if(!aclVector.contains(rights[r]))
                                        aclVector.addElement(rights[r]);

                            } else
                            {
                                System.out.println("INFO: JSIPConverter::createACL - rights list is NULL");
                            }
                        } else
                        if(categories[c].getName().equals("AG_CODE") && !aclVector.contains(categories[c].getType()))
                            aclVector.addElement(categories[c].getType());

                } else
                {
                    System.out.println("INFO:  JSIPConverter::createACL - categories is NULL");
                }
            }

        } else
        {
            System.out.println("INFO:  JSIPConverter::createACL - groups is NULL");
        }
        if(locationFound)
        {
            for(int v = 0; v < aclVector.size(); v++)
            {
                if(s_accessList.length() > 0)
                    s_accessList += ",";
                s_accessList += (String)aclVector.elementAt(v);
            }

        }
        return locationFound;
    }

    public void changePassword(String logonId, String application, String password, String newPassword, String location)
    {
        boolean status = false;
        if(application.equals("CCIITE"))
            application = "CCIITEST";
        UserAccess access = getAccessInstance();
        if(access != null)
        {
            status = doLogon(access, logonId, password, application);
            if(!status && i_errorNumber == 39)
            {
                i_errorNumber = 0;
                s_returnMessage = "";
                status = true;
            }
            if(status)
                try
                {
                    if(!createACL(location))
                    {
                        i_errorNumber = 38;
                        Notify _tmp = notify;
                        logError(0, 38, "Logon Exception: User " + logonId + " does not have privilages in location " + location);
                    } else
                    {
                        access.changePassword(password, newPassword);
                    }
                    access.remove();
                    access = null;
                }
                catch(SIPException e)
                {
                    System.out.println("JSIPConverter::changePassword - SIP exception");
                    if(e.getMessage().startsWith("Secure Password Exception"))
                    {
                        i_errorNumber = 91;
                    } else
                    {
                        i_errorNumber = 57;
                        Notify _tmp1 = notify;
                        logError(4, 57, e.getMessage());
                    }
                }
                catch(RemoteException e)
                {
                    System.out.println("JSIPConverter::changePassword - Remote exception");
                    i_errorNumber = 57;
                    Notify _tmp2 = notify;
                    logError(4, 57, e.getMessage());
                }
                catch(RemoveException e)
                {
                    System.out.println("JSIPConverter::changePassword - Remove exception");
                    i_errorNumber = 57;
                    Notify _tmp3 = notify;
                    logError(4, 57, e.getMessage());
                }
                catch(Throwable te)
                {
                    System.out.println("JSIPConverter::changePassword - Throwable Exception");
                    System.out.println("\n**************** Begin Exception **************\n");
                    te.printStackTrace(System.out);
                    System.out.println("\n**************** END Exception **************\n");
                }
        } else
        {
            i_errorNumber = 57;
            Notify _tmp4 = notify;
            logError(4, 57, "Error creating instance of UserAccess.");
        }
    }

    public void logon(String logonId, String password, String application, String location)
    {
        if(application.equals("CCIITE"))
            application = "CCIITEST";
        UserAccess access = getAccessInstance();
        if(access != null)
        {
            if(doLogon(access, logonId, password, application) && !createACL(location))
            {
                i_errorNumber = 38;
                Notify _tmp = notify;
                logError(0, 38, "Logon Exception: User " + logonId + " does not have privilages in location " + location);
            }
            try
            {
                access.remove();
                access = null;
            }
            catch(RemoveException e)
            {
                System.out.println("JSIPConverter::logon - Remove Exception caught");
                i_errorNumber = 57;
                Notify _tmp1 = notify;
                logError(4, 57, e.getMessage());
            }
            catch(RemoteException e)
            {
                System.out.println("JSIPConverter::logon - Remote Exception caught");
                i_errorNumber = 57;
                Notify _tmp2 = notify;
                logError(4, 57, e.getMessage());
            }
            catch(Throwable te)
            {
                System.out.println("JSIPConverter::logon - Throwable Exception");
                System.out.println("\n**************** Begin Exception **************\n");
                te.printStackTrace(System.out);
                System.out.println("\n**************** END Exception **************\n");
            }
        } else
        {
            i_errorNumber = 57;
            Notify _tmp3 = notify;
            logError(4, 57, "Error creating instance of UserAccess.");
        }
    }

    private boolean doLogon(UserAccess access, String logonId, String password, String application)
    {
        s_returnMessage = null;
        s_accessList = null;
        i_errorNumber = 0;
        query = null;
        s_orgCode = null;
        boolean success = false;
        try
        {
            int logonResult = access.logon(logonId, password, application, null);
            if(logonResult != 1)
            {
                i_errorNumber = 39;
                s_returnMessage = " " + Math.abs(logonResult);
                s_returnMessage = s_returnMessage.concat(" Grace Logons Left");
                Notify _tmp = notify;
                logError(0, 39, "Password has expired, " + Math.abs(logonResult) + " grace logons left.");
            } else
            {
                success = true;
            }
            User userProfile = access.getUserProfile();
            s_orgCode = userProfile.getOrgCode();
            query = new UserQuery(userProfile);
        }
        catch(SIPException e)
        {
            if(e.getMessage().startsWith("Logon Exception"))
            {
                String extraErrorMsg = e.getExtraMessage();
                if(extraErrorMsg.startsWith("Grace logon maximum exceeded"))
                {
                    i_errorNumber = 39;
                    Notify _tmp1 = notify;
                    logError(0, 39, "Logon Exception: Grace logon maximum exceeded");
                } else
                if(extraErrorMsg.startsWith("Password expired"))
                {
                    i_errorNumber = 39;
                    Notify _tmp2 = notify;
                    logError(0, 39, "Logon Exception: Password expired");
                } else
                if(extraErrorMsg.startsWith("Invalid attempts limit exceeded"))
                {
                    i_errorNumber = 40;
                    Notify _tmp3 = notify;
                    logError(0, 39, "Logon Exception: Logon Exception: Invalid attempts limit exceeded");
                } else
                if(extraErrorMsg.startsWith("Invalid Password"))
                {
                    i_errorNumber = 38;
                    Notify _tmp4 = notify;
                    logError(0, 38, "Logon Exception: Invalid Password");
                } else
                if(extraErrorMsg.startsWith("User is Disabled"))
                {
                    i_errorNumber = 178;
                    Notify _tmp5 = notify;
                    logError(0, 178, "Logon Exception: User is Disabled");
                } else
                if(extraErrorMsg.startsWith("LogonId"))
                {
                    i_errorNumber = 38;
                    Notify _tmp6 = notify;
                    logError(0, 38, "Logon Exception: LogonId " + logonId + " for application " + application + " does not exist");
                } else
                if(extraErrorMsg.startsWith("Application"))
                {
                    i_errorNumber = 38;
                    Notify _tmp7 = notify;
                    logError(0, 38, "Logon Exception: Application " + application + " does not exist");
                }
            } else
            {
                i_errorNumber = 57;
                Notify _tmp8 = notify;
                logError(4, 57, e.getMessage());
            }
        }
        catch(RemoteException e)
        {
            System.out.println("JSIPConverter::doLogon - Remote Exception caught");
            i_errorNumber = 57;
            Notify _tmp9 = notify;
            logError(4, 57, e.getMessage());
        }
        catch(Throwable te)
        {
            System.out.println("JSIPConverter::doLogon - Throwable Exception");
            System.out.println("\n**************** Begin Exception **************\n");
            te.printStackTrace(System.out);
            System.out.println("\n**************** END Exception **************\n");
        }
        return success;
    }

    public String getReturnMessage()
    {
        return s_returnMessage;
    }

    public String getOrgCode()
    {
        return s_orgCode;
    }

    public int getErrorNumber()
    {
        return i_errorNumber;
    }

    public String getAccessList()
    {
        return s_accessList;
    }

    private void logError(int errorLevel, int errorNumber, String errorMessage)
    {
        notify.triggerNotify(errorMessage);
    }

    private String s_returnMessage;
    private String s_accessList;
    private int i_errorNumber;
    private Context context;
    private UserAccessHome myUserAccessHome;
    private String host;
    private String port;
    private UserQuery query;
    private String s_orgCode;
    private Notify notify;
}
