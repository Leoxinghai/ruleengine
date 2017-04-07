package cciij.cciidata;

/**
 * Title:        EntryTypeDef - used to store data from the EntryTypeDef table
 * Description:
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Joey Cline
 * @version 1.0
 */
import java.io.Serializable;

public class EntryTypeDefinition implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: EntryTypeDefinition.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

  private String m_entryTypeCd;
  private String m_entryTypeDesc;
  private String m_hsNeededFlg;
  private String m_entryNbrNeededFlg;
  private String m_multipleEntryFlg;
  private float m_upperEntryValueAmt;
  private String m_autoReleaseFlg;
  private String m_entryNumber;
  private String m_categoryTypeCode;


  /**
   * Public default constructor
   */
  public EntryTypeDefinition()
  {
  }

  /**
   * Public constructor
   * @param  String entryTypeCd
   * @param  String entryTypeDesc
   * @param  String hsNeededFlg
   * @param  String entryNbrNeededFlg
   * @param  String multipleEntryFlg
   * @param  float upperEntryValueAmt
   * @param  String autoReleaseFlg
   */
  public EntryTypeDefinition(
    String entryTypeCd,
    String entryTypeDesc,
    String hsNeededFlg,
    String entryNbrNeededFlg,
    String multipleEntryFlg,
    float upperEntryValueAmt,
    String autoReleaseFlg
    )
  {
    setEntryTypeCd(entryTypeCd);
    setEntryTypeDesc(entryTypeDesc);
    setHsNeededFlg(hsNeededFlg);
    setEntryNbrNeededFlg(entryNbrNeededFlg);
    setMultipleEntryFlg(multipleEntryFlg);
    setUpperEntryValueAmt(upperEntryValueAmt);
    setAutoReleaseFlg(autoReleaseFlg);
  }


  public boolean setEntryTypeCd (String val)
  {
    m_entryTypeCd = val;
    return true;
  }

  public boolean setEntryTypeDesc (String val)
  {
    m_entryTypeDesc = val;
    return true;
  }

  public boolean setHsNeededFlg (String val)
  {
    m_hsNeededFlg = val;
    return true;
  }

  public boolean setEntryNbrNeededFlg (String val)
  {
    m_entryNbrNeededFlg = val;
    return true;
  }

  public boolean setMultipleEntryFlg (String val)
  {
    m_multipleEntryFlg = val;
    return true;
  }

  public boolean setUpperEntryValueAmt (float val)
  {
    m_upperEntryValueAmt = val;
    return true;
  }

  public boolean setAutoReleaseFlg (String val)
  {
    m_autoReleaseFlg = val;
    return true;
  }

  public boolean setEntryNumber (String val)
  {
    m_entryNumber = val;
    return true;
  }

  public boolean setCategoryTypeCode (String val)
  {
    m_categoryTypeCode = val;
    return true;
  }

  public String getEntryTypeCd ()
  {
    return m_entryTypeCd;
  }

  public String getEntryTypeDesc ()
  {
    return m_entryTypeDesc;
  }

  public String getHsNeededFlg ()
  {
    return m_hsNeededFlg;
  }

  public String getEntryNbrNeededFlg ()
  {
    return m_entryNbrNeededFlg;
  }

  public String getMultipleEntryFlg ()
  {
    return m_multipleEntryFlg;
  }

  public float getUpperEntryValueAmt ()
  {
    return m_upperEntryValueAmt;
  }

  public String getAutoReleaseFlg ()
  {
    return m_autoReleaseFlg;
  }

  public String getEntryNumber ()
  {
    return m_entryNumber;
  }

  public String getCategoryTypeCode ()
  {
    return m_categoryTypeCode;
  }


  /**
   * toString
   * @return String
   */
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("Entry Type Cd        : " + m_entryTypeCd + "\n" );
    sb.append("Entry Type Desc      : " + m_entryTypeDesc + "\n" );
    sb.append("Hs Needed Flg        : " + m_hsNeededFlg + "\n" );
    sb.append("Entry Nbr Needed Flg : " + m_entryNbrNeededFlg + "\n" );
    sb.append("Multiple Entry Flg   : " + m_multipleEntryFlg + "\n" );
    sb.append("Upper Entry Value Amt: " + m_upperEntryValueAmt + "\n" );
    sb.append("Auto Release Flg     : " + m_autoReleaseFlg + "\n" );
    sb.append("Entry Number         : " + m_entryNumber + "\n" );
    sb.append("Category Type Code   : " + m_categoryTypeCode + "\n" );
    return sb.toString();
  }

}

