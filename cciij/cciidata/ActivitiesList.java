package cciij.cciidata;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

/**
 * Title:        Class to wrap around a Vector of activity codes
 * Description:  This class is used as a container to hold clearance activity
 *               codes (as Strings).  This class will NOT validate if the
 *               codes given are valid activity codes.
 *               Long term, this class may provide validation of data.
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author
 * @version 1.0
 *
 * @Modification History:
 *  06/24/2003  Tom Knobeloch  Added instanciator and method to support the
 *                             addition of a collection/vector.
 */

public class ActivitiesList {

  private Vector m_clearanceActivities = new Vector();

  public ActivitiesList() {
  }

  public ActivitiesList(String codeToAdd) {
    m_clearanceActivities.add (codeToAdd);
  }

  public ActivitiesList(Collection codesToAdd) {
    add(codesToAdd);
  }
  
  public void add(Collection coll) {
    m_clearanceActivities.addAll(coll);
  }
  
  public boolean add (String codeToAdd) {
    return m_clearanceActivities.add (codeToAdd);
  }

  public boolean remove (String codeToRemove) {
    return m_clearanceActivities.remove (codeToRemove);
  }

  public Iterator iterator() {
    return m_clearanceActivities.iterator();
  }

  public boolean addAll (ActivitiesList alist) {
    return m_clearanceActivities.addAll(alist.getAll());
  }

  public Vector getAll() {
    return m_clearanceActivities;
  }
}
