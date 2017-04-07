package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

public class RuleActions
{
  private static final String m_whatVersion = "@(#) $RCSfile: RuleActions.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_set = "";
  private int m_ruleNumber;
  private int m_stepNumber;
  private int m_actionFactoryType;
  private int m_actionMethod;

  /**
   * RuleActions
   */
  public RuleActions()
  {

  }

  /**
  * finalize
  */
  protected void finalize() {

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
   * getRuleNumber
   * @return int
   */
  public int getRuleNumber()
  {
    return m_ruleNumber;
  }

  /**
   * getStepNumber
   * @return int
   */
  public int getStepNumber()
  {
    return m_stepNumber;
  }

  /**
   * getActionFactoryType
   * @return int
   */
  public int getActionFactoryType()
  {
    return m_actionFactoryType;
  }

  /**
   * getActionMethod
   * @return int
   */
  public int getActionMethod()
  {
    return m_actionMethod;
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
   * setRuleNumber
   * @param int
   */
  public void setRuleNumber(int ruleNumber)
  {
    m_ruleNumber = ruleNumber;
  }

  /**
   * setStepNumber
   * @param int
   */
  public void setStepNumber(int stepNumber)
  {
    m_stepNumber = stepNumber;
  }

  /**
   * setActionFactoryType
   * @param int
   */
  public void setActionFactoryType(int actionFactoryType)
  {
    m_actionFactoryType = actionFactoryType;
  }

  /**
   * setActionMethod
   * @param int
   */
  public void setActionMethod(int actionMethod)
  {
    m_actionMethod = actionMethod;
  }

  /**
   * toString
   * @return String
   */
   public String toString()
   {
      String s = "";

         s +=  "RuleActions object -- " + "\n";

         s += "set               : " + m_set+ "\n";
         s += "ruleNumber        : " + m_ruleNumber+ "\n";
         s += "stepNumber        : " + m_stepNumber+ "\n";
         s += "actionFactoryType : " + m_actionFactoryType+ "\n";
         s += "actionMethod      : " + m_actionMethod+ "\n";

      return s;
  }
}
