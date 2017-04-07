package cciij.util;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.security.Policy;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.CodeSource;
import java.security.AllPermission;


import java.rmi.Naming;

public class Java2uvsdkTest
{
    public static void main(final String argv[]) throws Exception
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

        int iterations = 2;
        int threads = 1;

        if(argv.length > 1)
        {
            iterations = Integer.parseInt(argv[1]);
            
            if(argv.length > 2)
            {
                threads = Integer.parseInt(argv[2]);
            }
        }

        final int threadIterations = iterations;

        System.out.println("Starting RemoteJava2uvsdkTestClient with name:  " + argv[0]);

//         Java2uvsdkInterface uvsdk = new Java2uvsdk();
        for(int j=0;j<threads;j++)
        {
            Thread t = new Thread(new Runnable()
                {
                    public void run()
                    {
                        Java2uvsdkInterface uvsdk = Java2uvsdkFactory.getJava2uvsdk();
                        try
                        {
                            uvsdk.LoadUrsaEditFiles();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Failed to load the edit file:  " + e);
                            e.printStackTrace(System.out);
                            return;
                        }
                        //                        Java2uvsdkInterface uvsdk = null;
                        long startTmstp = System.currentTimeMillis();
                        long lastTmstp = startTmstp;
                        for(int i=0;i<threadIterations;i++)
                        {
                            try
                            {
                                lastTmstp = test(uvsdk,argv[0],i,lastTmstp);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace(System.out);
                            }

                            //                            System.gc();
                        }
                        System.out.println("Processed " + threadIterations + " iterations in " + (lastTmstp - startTmstp) + " ms for an average of:  " + ((lastTmstp - startTmstp) / threadIterations) + "ms per iteration");
                    }
                });
            t.start();
        }
                                  
    }

    public static long test(Java2uvsdkInterface uvsdk,String name,int iteration,long last) throws Exception
    {
        
        
        try
        {
            //        RemoteJava2uvsdkFactory factory = (RemoteJava2uvsdkFactory)Naming.lookup("RemoteJava2uvsdkFactory");
//             Registry registry = LocateRegistry.getRegistry();
//             RemoteJava2uvsdkFactory factory = (RemoteJava2uvsdkFactory) registry.lookup("RemoteJava2uvsdkFactory");
//             System.out.println("Got the Factory");
//             RemoteJava2uvsdk uvsdk = factory.getRemoteJava2uvsdk(name);
            //        RemoteJava2uvsdk uvsdk = (RemoteJava2uvsdk)Naming.lookup(argv[0]);
            if(uvsdk == null)
            {
                uvsdk = Java2uvsdkFactory.getJava2uvsdk();
                System.out.println("Got a remote referecne");
                uvsdk.LoadUrsaEditFiles();
                System.out.println("Loaded the Ursa/Edit Files...");
            }
            else
            {
                System.out.println("Checking awbNbr:  " + name);
                uvsdk.CheckAirbill(name);
                System.out.println("FormTypeCode:  " + uvsdk.GetABFormCode());
                System.out.println("AWBTypeCode:   " + uvsdk.GetABTypeCode());
            }

        }
        catch(Exception re)
        {
            System.out.println("Load failed because of:  " + re);
            re.printStackTrace(System.out);
        }

        long endTmstp = System.currentTimeMillis();

        System.out.println("Iteration " + iteration + " took " + (endTmstp - last) + " ms");
        return endTmstp;
    }
}