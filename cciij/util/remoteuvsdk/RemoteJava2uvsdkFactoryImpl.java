package cciij.util.remoteuvsdk;

import java.security.Policy;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.CodeSource;
import java.security.AllPermission;

import java.io.IOException;

import java.rmi.Naming;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;

import java.rmi.activation.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import java.rmi.server.UnicastRemoteObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import rmtc.util.Config;

public class RemoteJava2uvsdkFactoryImpl extends Activatable implements RemoteJava2uvsdkFactory
{
    private HashSet m_nameSet = new HashSet();
    private HashMap m_grpMap = new HashMap();
    private Config m_config = new Config("RemoteJava2uvsdkFactoryImpl");
    private boolean m_uniqueGroups = true;
    private int m_groupCount = 0;
    private int m_currentGroup = 0;

    public RemoteJava2uvsdkFactoryImpl() throws RemoteException,ActivationException,IOException
    {
        super(null,new MarshalledObject("RemoteJava2uvsdkFactory"),false,0);
        constructor();
    }

    public RemoteJava2uvsdkFactoryImpl(ActivationID id,MarshalledObject arg) throws RemoteException
    {
        super(id,0);
        constructor();
    }

    private void constructor()
    {
        m_groupCount = m_config.getInt("GROUP_COUNT",0);
        if(m_groupCount > 0)
        {
            m_uniqueGroups = false;
        }
    }

    protected ActivationGroupID getGroup(String grpName) throws RemoteException,ActivationException,IOException
    {
        if(m_grpMap.containsKey(grpName))
        {
            return (ActivationGroupID)m_grpMap.get(grpName);
        }

        Properties prop = new Properties();
        prop.setProperty("java.security.policy",m_config.getString("POLICY_FILE","./RemoteJava2uvsdk.policy"));
        String configfilename = m_config.getValue("CONFIG_FILENAME");
        if(configfilename != null)
        {
            prop.setProperty("CONFIG_FILENAME",configfilename);
        }

        MarshalledObject grpArg = new MarshalledObject(grpName);
        ActivationGroupDesc gdesc = new ActivationGroupDesc(null,null,grpArg,prop,null);
        ActivationGroupID gid = ActivationGroup.getSystem().registerGroup(gdesc);
        //        ActivationGroup.createGroup(gid,gdesc,0);
        m_grpMap.put(grpName,gid);
        return gid;
    }

    public int getStatus() throws RemoteException,ActivationException,IOException
    {
        return 1;
    }

    public RemoteJava2uvsdk getRemoteJava2uvsdk(String name) throws RemoteException,ActivationException,IOException
    {
        if(m_nameSet.contains(name))
        {
            System.out.println("Looking up the already used name in the registry!!!");
            try
            {
                return (RemoteJava2uvsdk)Naming.lookup(name);
            }
            catch(java.rmi.NotBoundException e)
            {
                e.printStackTrace(System.out);
                // and fall through to bind it
            }
        }

        System.out.println("Attempting to setup a new RemoteJava2uvsdkImpl in the activation system...");
        String grpName = name;
        if(m_uniqueGroups == false)
        {
            grpName = "RemoteJava2uvsdkGroup" + m_currentGroup++;
            if(m_currentGroup >= m_groupCount)
            {
                m_currentGroup = 0;
            }
        }
        
        System.out.println("Registering " + name + " into group:  " + grpName);
        ActivationGroupID gid = getGroup(grpName);

        MarshalledObject activationArg = new MarshalledObject(name);
        String classlocation = m_config.getString("CLASS_LOCATION","");
        System.out.println("Looking for RemoteJava2uvsdkImpl @ " + classlocation);
        ActivationDesc desc = new ActivationDesc(gid,"cciij.util.remoteuvsdk.RemoteJava2uvsdkImpl",classlocation,activationArg);
        RemoteJava2uvsdk serverRef = (RemoteJava2uvsdk)Activatable.register(desc);
        getRegistry().rebind(name,serverRef);
        m_nameSet.add(name);
        System.out.println("Activation setup complete return the stub");
        return serverRef;
    }

    public static void main(String args[]) throws Exception
    {
        Policy.setPolicy(new Policy()
            {
                public PermissionCollection getPermissions(CodeSource codesource)
                {
                    Permissions perms = new Permissions();
                    perms.add(new AllPermission());
                    return (perms);
                }
                public void refresh() {}
            });

        //        ActivationGroupID gid = getGroup("RemoteJava2uvsdkFactory");

        Config config = new Config();

        Properties prop = new Properties();
        prop.setProperty("java.security.policy",config.getString("POLICY_FILE","./RemoteJava2uvsdk.policy"));
        String configfilename = config.getValue("CONFIG_FILENAME");
        if(configfilename != null)
        {
            prop.setProperty("CONFIG_FILENAME",configfilename);
        }

        String grpName = "RemoteJava2uvsdkFactory";
        MarshalledObject grpArg = new MarshalledObject(grpName);
        ActivationGroupDesc gdesc = new ActivationGroupDesc(null,"",grpArg,prop,null);
        ActivationGroupID gid = ActivationGroup.getSystem().registerGroup(gdesc);

        String classlocation = config.getString("CLASS_LOCATION","");

        MarshalledObject activationArg = new MarshalledObject(grpName);
        System.out.println("Using location:  " + classlocation);
        ActivationDesc desc = new ActivationDesc(gid,"cciij.util.remoteuvsdk.RemoteJava2uvsdkFactoryImpl",classlocation,activationArg);
        RemoteJava2uvsdkFactory serverRef = (RemoteJava2uvsdkFactory)Activatable.register(desc);

//         RemoteJava2uvsdkFactoryImpl factory = new RemoteJava2uvsdkFactoryImpl();
        //        Naming.rebind("RemoteJava2uvsdkFactory",factory);
        getRegistry().rebind(grpName,serverRef);
        System.out.println("Bound the RemoteJava2uvsdkFactoryImpl into the RMI Repository");
    }

    public static Registry getRegistry() throws RemoteException
    {
        Config config = new Config("RemoteJava2uvsdkFactory");
        int port = 1099;
        try
        {
            String portStr = config.getString("RMI_REGISTRY_PORT","1099");
            if(portStr != null)
            {
                port = Integer.parseInt(portStr);
            }
        }
        catch(Exception e)
        {
            // use default port of 1099
        }
        Registry registry = LocateRegistry.getRegistry(port);
        return registry;
    }
}