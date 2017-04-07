package cciij.cciidata;

/**
 * Title:        RoleClasses
 * Description:
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx
 * @author Kathleen Krucoff
 * @version 1.0
 */

public class RuleSets
{
  private static final String m_whatVersion = "@(#) $RCSfile: RuleSets.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";
  private String m_set = "";
  private int m_ruleNumber;
  private int m_conditionNumber;
  private int m_classId;
  private int m_fieldId;
  private int m_operation;
  private String m_value = "";

  /**
   * RuleSets
   */
  public RuleSets()
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
   * getConditionNumber
   * @return int
   */
  public int getConditionNumber()
  {
    return m_conditionNumber;
  }

  /**
   * getClassId
   * @retrun int
  */
  public int getClassId()
  {
    return m_classId;
  }

  /**
   * getFieldId
   * @return int
   */
  public int getFieldId()
  {
    return m_fieldId;
  }


 /**
   * getOperation
   * @return int
   */
  public int getOperation()
  {
    return m_operation;
  }

  /**
   * getValue
   * @return String
   */
  public String getValue()
  {
    return m_value;
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
   * @param String
   */
  public void setRuleNumber(int ruleNumber)
  {
       m_ruleNumber = ruleNumber;
  }

  /**
   * setConditionNumber
   * @param int
   */
  public void setConditionNumber(int conditionNumber)
  {
       m_conditionNumber = conditionNumber;
  }

  /**
   * setClassId
   * @param int
   */
  public void setClassId(int classId)
  {
       m_classId = classId;
  }

  /**
   * setFieldId
   * @param int
   */
  public void setFieldId(int fieldId)
  {
       m_fieldId = fieldId;
  }

  /**
   * setOperation
   * @param int
   */
  public void setOperation(int operation)
  {
       m_operation = operation;
  }

  /**
   * setValue
   * @param String
   */
  public void setValue(String value)
  {
     if(value == null)
     {
        m_value = "";
     }
     else
     {
        m_value = value;
     }
  }

  /**
   * toString
   * @return String
   */
  public String toString()
   {
      String s = "";

         s +=  "RuleSets object -- " + "\n";

         s += "set             : " + m_set+ "\n";
         s += "ruleNumber      : " + m_ruleNumber+ "\n";
         s += "conditionNumber : " + m_conditionNumber+ "\n";
         s += "classId         : " + m_classId+ "\n";
         s += "fieldId         : " + m_fieldId+ "\n";
         s += "operation       : " + m_operation+ "\n";
         s += "value           : " + m_value+ "\n";

      return s;
   }
}