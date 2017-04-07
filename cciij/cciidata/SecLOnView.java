package cciij.cciidata;

import java.io.*;
import java.lang.*;
import weblogic.wtc.jatmi.*;
import weblogic.wtc.jatmi.Utilities;

/**
 * <p>Title: SecLOnView</p>
 *
 * <p>Description: Java class that was derived from the Tuxedo view SecLOnView.
 * The class will be used as an argument to the CCIISecurityTuxedoBean.</p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: FedEx Services</p>
 * @author Ed McAleer
 * @version 1.0
 */
public class SecLOnView
    extends TypedView32
    implements Serializable
{

  private double d_returnStatus = 0.0;
  private String s_returnMessage = null;
  private String s_inViewName = null;
  private String s_outViewName = null;
  private String s_locationCode = null;
  private int l_sysDateTime = 0;
  private String s_userLogon = null;
  private String s_orgCode = null;
  private String s_inputDevice = null;
  private int i_errorNumber = 0;
  private int i_auditCode = 0;
  private String s_userId = null;
  private String s_password = null;
  private String s_newPassword = null;
  private String s_appCode = null;
  private String s_dutyCode = null;
  private String s_orgCd = null;
  private String s_accessList = null;
  private boolean _associatedFieldHandling = false;

  /**
   * SecLOnView
   */
  public SecLOnView()
  {
    super("SecLOnView");
    return;
  }

  /**
   * Gets the current state of associated field handling.
   * @return the current state (true=on, false=off)
   */
  public boolean getAssociatedFieldHandling()
  {
    return _associatedFieldHandling;
  }

  /**
   * Sets the state of associated field handling.
   * @param state the desired state (true=on, false=off)
   */
  public void setAssociatedFieldHandling(boolean state)
  {
    _associatedFieldHandling = state;
  }

  /**
   * Gets the value of the d_returnStatus element of this view
   * @return The value which this element has
   */
  public double getd_returnStatus()
  {
    return (this.d_returnStatus);
  }

  /**
   * Sets the value of the d_returnStatus element of this view
   * @param value The value to set the element to
   */
  public void setd_returnStatus(double value)
  {
    this.d_returnStatus = value;
  }

  /**
   * Gets the value of the s_returnMessage element of this view
   * @return The value which this element has
   */
  public String gets_returnMessage()
  {
    return (this.s_returnMessage);
  }

  /**
   * Sets the value of the s_returnMessage element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_returnMessage(String value)
  {
    if (value.length() > 256)
    {
      throw new IllegalArgumentException("Data too large for s_returnMessage");
    }
    this.s_returnMessage = value;
  }

  /**
   * Gets the value of the s_inViewName element of this view
   * @return The value which this element has
   */
  public String gets_inViewName()
  {
    return (this.s_inViewName);
  }

  /**
   * Sets the value of the s_inViewName element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_inViewName(String value)
  {
    if (value.length() > 16)
    {
      throw new IllegalArgumentException("Data too large for s_inViewName");
    }
    this.s_inViewName = value;
  }

  /**
   * Gets the value of the s_outViewName element of this view
   * @return The value which this element has
   */
  public String gets_outViewName()
  {
    return (this.s_outViewName);
  }

  /**
   * Sets the value of the s_outViewName element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_outViewName(String value)
  {
    if (value.length() > 16)
    {
      throw new IllegalArgumentException("Data too large for s_outViewName");
    }
    this.s_outViewName = value;
  }

  /**
   * Gets the value of the s_locationCode element of this view
   * @return The value which this element has
   */
  public String gets_locationCode()
  {
    return (this.s_locationCode);
  }

  /**
   * Sets the value of the s_locationCode element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_locationCode(String value)
  {
    if (value.length() > 6)
    {
      throw new IllegalArgumentException("Data too large for s_locationCode");
    }
    this.s_locationCode = value;
  }

  /**
   * Gets the value of the l_sysDateTime element of this view
   * @return The value which this element has
   */
  public int getl_sysDateTime()
  {
    return (this.l_sysDateTime);
  }

  /**
   * Sets the value of the l_sysDateTime element of this view
   * @param value The value to set the element to
   */
  public void setl_sysDateTime(int value)
  {
    this.l_sysDateTime = value;
  }

  /**
   * Gets the value of the s_userLogon element of this view
   * @return The value which this element has
   */
  public String gets_userLogon()
  {
    return (this.s_userLogon);
  }

  /**
   * Sets the value of the s_userLogon element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_userLogon(String value)
  {
    if (value.length() > 10)
    {
      throw new IllegalArgumentException("Data too large for s_userLogon");
    }
    this.s_userLogon = value;
  }

  /**
   * Gets the value of the s_orgCode element of this view
   * @return The value which this element has
   */
  public String gets_orgCode()
  {
    return (this.s_orgCode);
  }

  /**
   * Sets the value of the s_orgCode element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_orgCode(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_orgCode");
    }
    this.s_orgCode = value;
  }

  /**
   * Gets the value of the s_inputDevice element of this view
   * @return The value which this element has
   */
  public String gets_inputDevice()
  {
    return (this.s_inputDevice);
  }

  /**
   * Sets the value of the s_inputDevice element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_inputDevice(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_inputDevice");
    }
    this.s_inputDevice = value;
  }

  /**
   * Gets the value of the i_errorNumber element of this view
   * @return The value which this element has
   */
  public int geti_errorNumber()
  {
    return (this.i_errorNumber);
  }

  /**
   * Sets the value of the i_errorNumber element of this view
   * @param value The value to set the element to
   */
  public void seti_errorNumber(int value)
  {
    this.i_errorNumber = value;
  }

  /**
   * Gets the value of the i_auditCode element of this view
   * @return The value which this element has
   */
  public int geti_auditCode()
  {
    return (this.i_auditCode);
  }

  /**
   * Sets the value of the i_auditCode element of this view
   * @param value The value to set the element to
   */
  public void seti_auditCode(int value)
  {
    this.i_auditCode = value;
  }

  /**
   * Gets the value of the s_userId element of this view
   * @return The value which this element has
   */
  public String gets_userId()
  {
    return (this.s_userId);
  }

  /**
   * Sets the value of the s_userId element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_userId(String value)
  {
    if (value.length() > 10)
    {
      throw new IllegalArgumentException("Data too large for s_userId");
    }
    this.s_userId = value;
  }

  /**
   * Gets the value of the s_password element of this view
   * @return The value which this element has
   */
  public String gets_password()
  {
    return (this.s_password);
  }

  /**
   * Sets the value of the s_password element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_password(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_password");
    }
    this.s_password = value;
  }

  /**
   * Gets the value of the s_newPassword element of this view
   * @return The value which this element has
   */
  public String gets_newPassword()
  {
    return (this.s_newPassword);
  }

  /**
   * Sets the value of the s_newPassword element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_newPassword(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_newPassword");
    }
    this.s_newPassword = value;
  }

  /**
   * Gets the value of the s_appCode element of this view
   * @return The value which this element has
   */
  public String gets_appCode()
  {
    return (this.s_appCode);
  }

  /**
   * Sets the value of the s_appCode element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_appCode(String value)
  {
    if (value.length() > 6)
    {
      throw new IllegalArgumentException("Data too large for s_appCode");
    }
    this.s_appCode = value;
  }

  /**
   * Gets the value of the s_dutyCode element of this view
   * @return The value which this element has
   */
  public String gets_dutyCode()
  {
    return (this.s_dutyCode);
  }

  /**
   * Sets the value of the s_dutyCode element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_dutyCode(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_dutyCode");
    }
    this.s_dutyCode = value;
  }

  /**
   * Gets the value of the s_orgCd element of this view
   * @return The value which this element has
   */
  public String gets_orgCd()
  {
    return (this.s_orgCd);
  }

  /**
   * Sets the value of the s_orgCd element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_orgCd(String value)
  {
    if (value.length() > 12)
    {
      throw new IllegalArgumentException("Data too large for s_orgCd");
    }
    this.s_orgCd = value;
  }

  /**
   * Gets the value of the s_accessList element of this view
   * @return The value which this element has
   */
  public String gets_accessList()
  {
    return (this.s_accessList);
  }

  /**
   * Sets the value of the s_accessList element of this view
   * @param value The value to set the element to
   * @throws IllegalArgumentException if the value is too long
   */
  public void sets_accessList(String value)
  {
    if (value.length() > 1000)
    {
      throw new IllegalArgumentException("Data too large for s_accessList");
    }
    this.s_accessList = value;
  }

  /**
   * _tmpresend
   *
   * @param encoder DataOutputStream
   * @throws TPException
   * @throws IOException
   */
  public void _tmpresend(DataOutputStream encoder) throws TPException,
      IOException
  {
    int lcv;
    boolean addNull;
    try
    {
      //Encode d_returnStatus
      encoder.writeDouble(d_returnStatus);

      //Check s_returnMessage lentgh and encode.
      if (s_returnMessage != null)
      {
        addNull = (s_returnMessage.length() < 256);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_returnMessage, addNull);

      //Check s_inViewName length and encode.
      if (s_inViewName != null)
      {
        addNull = (s_inViewName.length() < 16);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_inViewName, addNull);

      //Check s_outViewName length and encode
      if (s_outViewName != null)
      {
        addNull = (s_outViewName.length() < 16);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_outViewName, addNull);

      //Check s_locationCode length and encode
      if (s_locationCode != null)
      {
        addNull = (s_locationCode.length() < 6);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_locationCode, addNull);

      //Encode l_sysDateTime
      encoder.writeInt(l_sysDateTime);

      //Check s_userLogon length and encode
      if (s_userLogon != null)
      {
        addNull = (s_userLogon.length() < 10);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_userLogon, addNull);

      //Check s_orgCode length and encode.
      if (s_orgCode != null)
      {
        addNull = (s_orgCode.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_orgCode, addNull);

      //Check s_inputDevice length and encode.
      if (s_inputDevice != null)
      {
        addNull = (s_inputDevice.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_inputDevice, addNull);

      //Encode i_errorNumber and i_auditCode
      encoder.writeInt(i_errorNumber);
      encoder.writeInt(i_auditCode);

      //Check s_userId length and encode.
      if (s_userId != null)
      {
        addNull = (s_userId.length() < 10);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_userId, addNull);

      //Check s_password length and encode.
      if (s_password != null)
      {
        addNull = (s_password.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_password, addNull);

      //Check s_newPassword length and encode.
      if (s_newPassword != null)
      {
        addNull = (s_newPassword.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_newPassword, addNull);

      //Check s_appCode length and encode.
      if (s_appCode != null)
      {
        addNull = (s_appCode.length() < 6);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_appCode, addNull);

      //Check s_dutyCode length and encode.
      if (s_dutyCode != null)
      {
        addNull = (s_dutyCode.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_dutyCode, addNull);

      //Check s_orgCd length and encode.
      if (s_orgCd != null)
      {
        addNull = (s_orgCd.length() < 12);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_orgCd, addNull);

      //Check s_accessList length and encode.
      if (s_accessList != null)
      {
        addNull = (s_accessList.length() < 1000);
      }
      else
      {
        addNull = false;
      }
      Utilities.xdr_encode_string(encoder, s_accessList, addNull);

    }
    catch (IOException ie)
    {
      System.out.println("Error encoding view buffer: " + ie);
    }
    return;
  }

  /**
   * toString
   *
   * @return String - formatted string containing all of the SecLOnView attributes.
   */
  public String toString()
  {
    String secLOnView =
/*
        "\nd_returnStatus = " + getd_returnStatus() +
                         "\ns_returnMessage = " + gets_returnMessage() +
                         "\ns_inViewName = " + gets_inViewName() +
                         "\ns_outViewName = " + gets_outViewName() +
 */
                         "\ns_locationCode " + gets_locationCode() +
/*
                         "\nl_sysDateTime = " + getl_sysDateTime() +
                         "\ns_userLogon = " + gets_userLogon() +
                         "\ns_orgCode = " + gets_orgCode() +
                         "\ns_inputDevice = " + gets_inputDevice() +
                         "\ni_errorNumber = " + geti_errorNumber() +
                         "\ni_auditCode = " + geti_auditCode() +
*/
                         "\ns_userId = " + gets_userId() +
                         "\ns_password = " + gets_password() +
                         "\ns_newPassword = " + gets_newPassword() +
/*
                         "\ns_appCode = " + gets_appCode() +
                         "\ns_dutyCode = " + gets_dutyCode() +
                         "\ns_orgCd = " + gets_orgCd() +
*/
                         "\ns_accessList = " + gets_accessList();
    return secLOnView;
  }
  /**
   * _tmpostrecv
   *
   * @param decoder DataInputStream
   * @param recv_size int
   * @throws TPException
   * @throws IOException
   */
  public void _tmpostrecv(DataInputStream decoder, int recv_size) throws
      TPException, IOException
  {
    int lcv;
    d_returnStatus = decoder.readDouble();
    s_returnMessage = Utilities.xdr_decode_string(decoder, null, true);
    s_inViewName = Utilities.xdr_decode_string(decoder, null, true);
    s_outViewName = Utilities.xdr_decode_string(decoder, null, true);
    s_locationCode = Utilities.xdr_decode_string(decoder, null, true);
    l_sysDateTime = decoder.readInt();
    s_userLogon = Utilities.xdr_decode_string(decoder, null, true);
    s_orgCode = Utilities.xdr_decode_string(decoder, null, true);
    s_inputDevice = Utilities.xdr_decode_string(decoder, null, true);
    i_errorNumber = decoder.readInt();
    i_auditCode = decoder.readInt();
    s_userId = Utilities.xdr_decode_string(decoder, null, true);
    s_password = Utilities.xdr_decode_string(decoder, null, true);
    s_newPassword = Utilities.xdr_decode_string(decoder, null, true);
    s_appCode = Utilities.xdr_decode_string(decoder, null, true);
    s_dutyCode = Utilities.xdr_decode_string(decoder, null, true);
    s_orgCd = Utilities.xdr_decode_string(decoder, null, true);
    s_accessList = Utilities.xdr_decode_string(decoder, null, true);
    return;
  }
}

//================================== END OF CLASS ==============================
