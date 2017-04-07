package cciij.Security;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx Services
 * @author Steven Hurd
 * @version 1.0
 */

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.*;
import cciij.WSUtil.UserAttributes;

public interface CCIISecurity extends EJBObject
{
  /**
   * login
   * @return UserAttributes
   */

  public UserAttributes login (String userName, String password,
      int language, String site) throws RemoteException;
  /**
   * login
   * @return UserAttributes
   */
  public UserAttributes login (String userName, String password,
      int language, boolean changePass, String newPass, String confirmPass,
      String site) throws RemoteException;
  /**
   * login
   * @return Vector
   */
  public Vector login (String userName, String password, String site) throws RemoteException;
  /**
   * login
   * @return Vector
   */
  public Vector login(String userName, String password,
       boolean changePass, String newPass, String site) throws RemoteException;

  public void logout(String userName, String site) throws RemoteException;
  public void autoLogout(String userName, String site) throws RemoteException;
  public void reset() throws RemoteException;
}