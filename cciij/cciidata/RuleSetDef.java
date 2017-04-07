  package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

public class RuleSetDef
{
  private static final String m_whatVersion = "@(#) $RCSfile: RuleSetDef.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_stateId = "";
  private String m_set = "";
  private String m_comment = "";

  /**
   * RuleSetDef
   */
  public RuleSetDef()
  {
  }

   /**
  * finalize
  */
  protected void finalize() {

  }

  /**
   * getStateId
   * @return String
   */
  public String getStateId()
  {
    return m_stateId;
  }

  /**
   * getSet
   * @return String
   */
  public String getSet()
  {
    return m_set;
  }

  /**
   * getComment
   * @return String
   */
  public String getComment()
  {
    return m_comment;
  }

  /**
   * setStateId
   * @param String
   */
  public void setStateId(String stateId)
  {
    if(stateId == null)
    {
      m_stateId = "";
    }
    else
    {
      m_stateId = stateId;
    }
  }

  /**
   * setSet
   * @param String
   */
  public void setSet(String set)
  {
    if(set == null)
    {
      m_set = "";
    }
    else
    {
      m_set = set;
    }
 }

  /**
   * setComment
   * @param String
   */
  public void setComment(String comment)
  {
    if(comment == null)
    {
      m_comment = "";
    }
    else
    {
      m_comment = comment;
    }
  }

  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "RuleSetDef object -- " + "\n";

         s += "stateId        : " + m_stateId+ "\n";
         s += "set               : " + m_set+ "\n";
         s += "comment        : " + m_comment+ "\n";

      return s;
  }
}