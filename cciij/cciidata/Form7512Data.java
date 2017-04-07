package cciij.cciidata;

import java.util.*;

/**
 * Title:        Form7512Data<br>
 * Description:  This class represents the field values of form7512.
 * Copyright:    Copyright (c) 2004<br>
 * Company:      FedEx<br>
 * Exceptions:<br>
 * <UL>
 *   <LI>None
 * </UL>
 * <br>
 * @author       Annie Wu
 * @version 1.0
 * <br>
 * <br>
 * Modification History:<br>
 *   <UL>
 *     <LI>Date: 2004/08/11
 *       <UL>
 *         <LI>By: Annie Wu
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Initial release
 *         </UL>
 *       </UL>
 *   </UL>
 *
 */
public class Form7512Data 
{
  private String entryNo;  // field1
  private String port;  // field2
  private Date date3;  // field3
  private String ccnNumber;  // field4
  private String classOfEntry;  // field5
  private String distNo;  // field6
  private String portCodeNo;  // field7
  private String usPortOfUnlading;  // field8
  private String portOf;  // field9
  private Date preparationDate;  // field10

  private String enteredBy;  // field11
  private String irsNbr;    // field111
  private String inBondVia;  // field12
  private String portDirector;  // field13
  private String finalForeignDestination;  // field14
  private String consignee;  // field15
  private String foreignPortOfLading;  // field16
  private String blNo;  // field17
  private Date dateOfSailing;  // field18
  private String importedOn;  // field19
  private String flag;  // field20

  private Date flightArrivalDate;  // field21
  private String lastForeignPort;  // field22
  private String exportedFrom;  // field23
  private Date flightDepartureDate;  // field24
  private String goodsNowAt;  // field25
  private int marksAndNumbers;  // field26
  private String descriptionAndQuantity;  // field27
  private float grossWeight;  // field28
  private double value;  // field29
  private String pnNumber;  // field291
  private String lineItemNote;  // field30

  private String certificateOfLading;  // field31
  private String enteredOrWithdrawnComp;  // field32
  private String enteredOrWithdrawnInd;  // field33
  private String nos;  // field34
  private String carrierName;  // field35
  private String agentOfCarrier;  // field36

  /**
   * Default constructor.  
   */
  public Form7512Data() 
  {
  }


  /**
   * Form7512Data
   * @param newEntryNo String value of the newEntryNo field for the form 
   * @param newPort String value of the newPort field for the form 
   * @param newDate3 value of the newDate3 field as Date for the form 
   * @param newCcnNumber String value of the newCcnNumber field for the form 
   * @param newClassOfEntry String value of the newClassOfEntry field for the form 
   * @param newDistNo String value of the newDistNo field for the form 
   * @param newPortCodeNo String value of the newPortCodeNo field for the form 
   * @param newUsPortOfUnlading String value of the newUsPortOfUnlading field for the 
   * form 
   * @param newPortOf String value of the newPortOf field for the form 
   * @param newPreparationDate value of the newDate3 field as Date for the 
   * form 
   * @param newEnteredBy String value of the newEnteredBy field for the form 
   * @param newIrsNbr String value of the newIrsNbr field for the form 
   * @param newInBondVia String value of the newInBondVia field for the form 
   * @param newPortDirector String value of the newPortDirector field for the form 
   * @param newFinalForeignDestination String value of the newFinalForeignDestination 
   * field for the form 
   * @param newConsignee String value of the newConsignee field for the form 
   * @param newForeignPortOfLading String value of the newForeignPortOfLading field for 
   * the form 
   * @param newBlNo String value of the newBlNo field for the form 
   * @param newDateOfSailing value of the newDate3 field as Date for the form 
   * @param newImportedOn String value of the newImportedOn field for the form 
   * @param newFlag String value of the newFlag field for the form 
   * @param newFlightArrivalDate value of the newDate3 field as Date for the
   * form 
   * @param newLastForeignPort String value of the newLastForeignPort field for the form  
   * @param newExportedFrom String value of the newExportedFrom field for the form   
   * @param newFlightDepartureDate value of the newDate3 field as Date for 
   * the form 
   * @param newGoodsNowAt String value of the newGoodsNowAt field for the form 
   * @param newMarksAndNumbers String value of the newMarksAndNumbers field for the form  
   * @param newDescriptionAndQuantity String value of the newDescriptionAndQuantity field
   * for the form 
   * @param newGrossWeight String value of the newGrossWeight field for the form 
   * @param newValue String value of the newValue field for the form 
   * @param newPnNumber int value of the newPnNumber field for the form 
   * @param newLineItemNote String value of the newLineItemNote field for the form 
   * @param newCertificateOfLading String value of the newCertificateOfLading field for 
   * the form 
   * @param newEnteredOrWithdrawnComp String value of the newEnteredOrWithdrawnComp field
   * for the form 
   * @param newEnteredOrWithdrawnInd String value of the newEnteredOrWithdrawnInd field 
   * for the form 
   * @param newNos String value of the newNos field for the form       
   * @param newCarrierName String value of the newCarrierName field for the form    
   * @param newAgentOfCarrier String value of the newAgentOfCarrier field for the form 
   */
  public Form7512Data(String newEntryNo, 
                      String newPort, 
                      Date newDate3, 
                      String newCcnNumber, 
                      String newClassOfEntry, 
                      String newDistNo, 
                      String newPortCodeNo, 
                      String newUsPortOfUnlading, 
                      String newPortOf, 
                      Date newPreparationDate, 
                      String newEnteredBy, 
                      String newIrsNbr,
                      String newInBondVia, 
                      String newPortDirector, 
                      String newFinalForeignDestination, 
                      String newConsignee, 
                      String newForeignPortOfLading, 
                      String newBlNo, 
                      Date newDateOfSailing, 
                      String newImportedOn, 
                      String newFlag, 
                      Date newFlightArrivalDate, 
                      String newLastForeignPort, 
                      String newExportedFrom, 
                      Date newFlightDepartureDate,
                      String newGoodsNowAt, 
                      int newMarksAndNumbers, 
                      String newDescriptionAndQuantity, 
                      float newGrossWeight, 
                      double newValue, 
                      String newPnNumber,
                      String newLineItemNote, 
                      String newCertificateOfLading, 
                      String newEnteredOrWithdrawnComp, 
                      String newEnteredOrWithdrawnInd, 
                      String newNos, 
                      String newCarrierName, 
                      String newAgentOfCarrier) 
  {
    setEntryNo( newEntryNo ); 
    setPort( newPort ); 
    setDate3( newDate3 ); 
    setCcnNumber( newCcnNumber ); 
    setClassOfEntry( newClassOfEntry ); 
    setDistNo( newDistNo ); 
    setPortCodeNo( newPortCodeNo ); 
    setUsPortOfUnlading( newUsPortOfUnlading ); 
    setPortOf( newPortOf ); 
    setPreparationDate( newPreparationDate ); 
    setEnteredBy( newEnteredBy ); 
    setIrsNbr(newIrsNbr);
    setInBondVia( newInBondVia ); 
    setPortDirector( newPortDirector ); 
    setFinalForeignDestination( newFinalForeignDestination ); 
    setConsignee( newConsignee ); 
    setForeignPortOfLading( newForeignPortOfLading ); 
    setBlNo( newBlNo ); 
    setDateOfSailing( newDateOfSailing ); 
    setImportedOn( newImportedOn ); 
    setFlag( newFlag ); 
    setFlightArrivalDate( newFlightArrivalDate ); 
    setLastForeignPort( newLastForeignPort ); 
    setExportedFrom( newExportedFrom ); 
    setFlightDepartureDate( newFlightDepartureDate ); 
    setGoodsNowAt( newGoodsNowAt ); 
    setMarksAndNumbers( newMarksAndNumbers ); 
    setDescriptionAndQuantity( newDescriptionAndQuantity ); 
    setGrossWeight( newGrossWeight ); 
    setValue( newValue ); 
    setPnNumber( newPnNumber );
    setLineItemNote( newLineItemNote ); 
    setCertificateOfLading( newCertificateOfLading ); 
    setEnteredOrWithdrawnComp( newEnteredOrWithdrawnComp ); 
    setEnteredOrWithdrawnInd( newEnteredOrWithdrawnInd ); 
    setNos( newNos ); 
    setCarrierName( newCarrierName ); 
    setAgentOfCarrier( newAgentOfCarrier ); 
  }

  /**
   * getEntryNo
   * @return String value of the entry number
   */
  public String getEntryNo()
  {
    return entryNo;
  }
  
  /**
   * setEntryNo
   * @param val String value of the entry number 
   */
  public void setEntryNo(String val)
  {
    entryNo = val;
  }

  /**
   * getPort
   * @return String value of the port
   */
  public String getPort()
  {
    return port;
  }
  
  /**
   * setPort
   * @param val String value of the port 
   */
  public void setPort(String val)
  {
    port = val;
  }

  /**
   * getDate3
   * @return String value of the date3 
   */
  public Date getDate3()
  {
    return date3;
  }
  
  /**
   * setDate3
   * @param val String value of the date3 
   */
  public void setDate3(Date val)
  {
    date3 = val;
  }

  /**
   * getCcnNumber
   * @return String value of the ccnNumber
   */
  public String getCcnNumber()
  {
    return ccnNumber;
  }
  
  /**
   * setCcnNumber
   * @param val String value of the ccnNumber 
   */
  public void setCcnNumber(String val)
  {
    ccnNumber = val;
  }

  /**
   * getClassOfEntry
   * @return String value of the clearance type code
   */
  public String getClassOfEntry()
  {
    return classOfEntry;
  }
  
  /**
   * setClassOfEntry
   * @param val String value of the clearance type code 
   */
  public void setClassOfEntry(String val)
  {
    classOfEntry = val;
  }

  /**
   * getDistNo
   * @return String value of the district number
   */
  public String getDistNo()
  {
    return distNo;
  }
  
  /**
   * setDistNo
   * @param val String value of the district number 
   */
  public void setDistNo(String val)
  {
    distNo = val;
  }

  /**
   * getPortCodeNo
   * @return String value of the port code number
   */
  public String getPortCodeNo()
  {
    return portCodeNo;
  }
  
  /**
   * setPortCodeNo
   * @param val String value of the port code number 
   */
  public void setPortCodeNo(String val)
  {
    portCodeNo = val;
  }

  /**
   * getUsPortOfUnlading
   * @return String value of the first US port of unlading
   */
  public String getUsPortOfUnlading()
  {
    return usPortOfUnlading;
  }
  
  /**
   * setUsPortOfUnlading
   * @param val String value of the first US port of unlading 
   */
  public void setUsPortOfUnlading(String val)
  {
    usPortOfUnlading = val;
  }

  /**
   * getPortOf
   * @return String value of the port of
   */
  public String getPortOf()
  {
    return portOf;
  }
  
  /**
   * setPortOf
   * @param val String value of the port of 
   */
  public void setPortOf(String val)
  {
    portOf = val;
  }

  /**
   * getPreparationDate
   * @return the preparation date as Date
   */
  public Date getPreparationDate()
  {
    return preparationDate;
  }
  
  /**
   * setPreparationDate
   * @param val the preparation date as Date
   */
  public void setPreparationDate(Date val)
  {
    preparationDate = val;
  }

  /**
   * getEnteredBy
   * @return String value of the entered by
   */
  public String getEnteredBy()
  {
    return enteredBy;
  }
  
  /**
   * setEnteredBy
   * @param val String value of the entered by 
   */
  public void setEnteredBy(String val)
  {
    enteredBy = val;
  }

/**
   * getIRSnbr
   * @return String value of the entered by
   */
  public String getIrsNbr()
  {
    return irsNbr;
  }
  
  /**
   * setEnteredBy
   * @param val String value of the entered by 
   */
  public void setIrsNbr(String val)
  {
    irsNbr = val;
  }
  /**
   * getInBondVia
   * @return String value of the in bond via
   */
  public String getInBondVia()
  {
    return inBondVia;
  }
  
  /**
   * setInBondVia
   * @param val String value of the in bond via 
   */
  public void setInBondVia(String val)
  {
    inBondVia = val;
  }

  /**
   * getPortDirector
   * @return String value of the district director of Customs
   */
  public String getPortDirector()
  {
    return portDirector;
  }
  
  /**
   * setPortDirector
   * @param val String value of the district director of Customs 
   */
  public void setPortDirector(String val)
  {
    portDirector = val;
  }

  /**
   * getFinalForeignDestination
   * @return String value of the final foreign destination
   */
  public String getFinalForeignDestination()
  {
    return finalForeignDestination;
  }
  
  /**
   * setFinalForeignDestination
   * @param val String value of the final foreign destination 
   */
  public void setFinalForeignDestination(String val)
  {
    finalForeignDestination = val;
  }

  /**
   * getConsignee
   * @return String value of the consignee
   */
  public String getConsignee()
  {
    return consignee;
  }
  
  /**
   * setConsignee
   * @param val String value of the consignee 
   */
  public void setConsignee(String val)
  {
    consignee = val;
  }

  /**
   * getForeignPortOfLadinge
   * @return String value of the foreign port of lading
   */
  public String getForeignPortOfLading()
  {
    return foreignPortOfLading;
  }
  
  /**
   * setForeignPortOfLadinge
   * @param val String value of the foreign port of lading 
   */
  public void setForeignPortOfLading(String val)
  {
    foreignPortOfLading = val;
  }

  /**
   * getBlNo
   * @return String value of the B/L No
   */
  public String getBlNo()
  {
    return blNo;
  }
  
  /**
   * setBlNo
   * @param val String value of the B/L No 
   */
  public void setBlNo(String val)
  {
    blNo = val;
  }

  /**
   * getDateOfSailing
   * @return Date value of the date of sailing 
   */
  public Date getDateOfSailing()
  {
    return dateOfSailing;
  }
  
  /**
   * setDateOfSailing
   * @param val Date value of the date of sailing 
   */
  public void setDateOfSailing(Date val)
  {
    dateOfSailing = val;
  }

  /**
   * getImportedOn
   * @return String value of the imported on the
   */
  public String getImportedOn()
  {
    return importedOn;
  }
  
  /**
   * setImportedOn
   * @param val String value of the imported on the 
   */
  public void setImportedOn(String val)
  {
    importedOn = val;
  }

  /**
   * getFlag
   * @return String value of the flag
   */
  public String getFlag()
  {
    return flag;
  }
  
  /**
   * setFlag
   * @param val String value of the flag 
   */
  public void setFlag(String val)
  {
    flag = val;
  }

  /**
   * getFlightArrivalDate
   * @return the flight arrive date as Date
   */
  public Date getFlightArrivalDate()
  {
    return flightArrivalDate;
  }
  
  /**
   * setFlightArrivalDate
   * @param val the flight arrive date as Date
   */
  public void setFlightArrivalDate(Date val)
  {
    flightArrivalDate = val;
  }

  /**
   * getLastForeignPort
   * @return String value of the last foreign port
   */
  public String getLastForeignPort()
  {
    return lastForeignPort;
  }
  
  /**
   * setLastForeignPort
   * @param val String value of the last foreign port 
   */
  public void setLastForeignPort(String val)
  {
    lastForeignPort = val;
  }

  /**
   * getExportedFrom
   * @return String value of the exported from
   */
  public String getExportedFrom()
  {
    return exportedFrom;
  }
  
  /**
   * setExportedFrom
   * @param val String value of the exported from 
   */
  public void setExportedFrom(String val)
  {
    exportedFrom = val;
  }

  /**
   * getFlightDepartureDate
   * @return the flight departure date as Date
   */
  public Date getFlightDepartureDate()
  {
    return flightDepartureDate;
  }
  
  /**
   * setFlightDepartureDate
   * @param val the flight departure date as Date
   */
  public void setFlightDepartureDate(Date val)
  {
    flightDepartureDate = val;
  }

  /**
   * getGoodsNowAt
   * @return String value of the goods now at
   */
  public String getGoodsNowAt()
  {
    return goodsNowAt;
  }
  
  /**
   * setGoodsNowAt
   * @param val String value of the goods now at 
   */
  public void setGoodsNowAt(String val)
  {
    goodsNowAt = val;
  }

  /**
   * getMarksAndNumbers
   * @return int value of the marks and numbers
   */
  public int getMarksAndNumbers()
  {
    return marksAndNumbers;
  }
  
  /**
   * setMarksAndNumbers
   * @param val int value of the marks and numbers 
   */
  public void setMarksAndNumbers(int val)
  {
    marksAndNumbers = val;
  }

  /**
   * getDescriptionAndQuantity
   * @return String value of the description and quantity
   */
  public String getDescriptionAndQuantity()
  {
    return descriptionAndQuantity;
  }
  
  /**
   * setDescriptionAndQuantity
   * @param val String value of the description and quantity 
   */
  public void setDescriptionAndQuantity(String val)
  {
    descriptionAndQuantity = val;
  }

  /**
   * getGrossWeight
   * @return String value of the gross weight
   */
  public float getGrossWeight()
  {
    return grossWeight;
  }
  
  /**
   * setGrossWeight
   * @param val float value of the gross weight 
   */
  public void setGrossWeight(float val)
  {
    grossWeight = val;
  }

  /**
   * getValue
   * @return String value of the value
   */
  public double getValue()
  {
    return value;
  }
  
  /**
   * setValue
   * @param val String value of the value 
   */
  public void setValue(double val)
  {
    value = val;
  }

 /**
   * getPnNumber
   * @return String pnNumber of the pn number
   */
  public String getPnNumber()
  {
    return pnNumber;
  }
  
  /**
   * setPnNumber
   * @param val String pnNumber of the pn number 
   */
  public void setPnNumber(String val)
  {
    pnNumber = val;
  }

  /**
   * getLineItemNote
   * @return String lineItemNote of the line item note
   */
  public String getLineItemNote()
  {
    return lineItemNote;
  }
  
  /**
   * setLineItemNote
   * @param val String lineItemNote of the line item note 
   */
  public void setLineItemNote(String val)
  {
    lineItemNote = val;
  }

  /**
   * getCertificateOfLading
   * @return String certificateOfLading of the Certificate of lading
   */
  public String getCertificateOfLading()
  {
    return certificateOfLading;
  }
  
  /**
   * setCertificateOfLading
   * @param val String certificateOfLading of the Certificate of lading 
   */
  public void setCertificateOfLading(String val)
  {
    certificateOfLading = val;
  }

  /**
   * getEnteredOrWithdrawnComp
   * @return String enteredOrWithdrawnComp of the entered or withdrawn company
   */
  public String getEnteredOrWithdrawnComp()
  {
    return enteredOrWithdrawnComp;
  }
  
  /**
   * setEnteredOrWithdrawnComp
   * @param val String enteredOrWithdrawnComp of the entered or withdrawn company 
   */
  public void setEnteredOrWithdrawnComp(String val)
  {
    enteredOrWithdrawnComp = val;
  }

  /**
   * getEnteredOrWithdrawnInd
   * @return String enteredOrWithdrawnInd of the entered or withdrawn individual
   */
  public String getEnteredOrWithdrawnInd()
  {
    return enteredOrWithdrawnInd;
  }
  
  /**
   * setEnteredOrWithdrawnInd
   * @param val String enteredOrWithdrawnInd of the entered or withdrawn individual
   */
  public void setEnteredOrWithdrawnInd(String val)
  {
    enteredOrWithdrawnInd = val;
  }

  /**
   * getNos
   * @return String nos of the nos
   */
  public String getNos()
  {
    return nos;
  }
  
  /**
   * setNos
   * @param val String nos of the nos
   */
  public void setNos(String val)
  {
    nos = val;
  }

  /**
   * getCarrierName
   * @return String carrierName of the carrier name
   */
  public String getCarrierName()
  {
    return carrierName;
  }
  
  /**
   * setCarrierName
   * @param val String carrierName of the carrier name
   */
  public void setCarrierName(String val)
  {
    carrierName = val;
  }

  /**
   * getAgentOfCarrier
   * @return String agentOfCarrier of the agent of carrier
   */
  public String getAgentOfCarrier()
  {
    return agentOfCarrier;
  }
  
  /**
   * setAgentOfCarrier
   * @param val String agentOfCarrier of the agent of carrier
   */
  public void setAgentOfCarrier(String val)
  {
    agentOfCarrier = val;
  }


  /**
   * toString
   * @return String represntation of the data in the class
   */
  public String toString()
   {
      String s = "";

      s +=  "Form7512Data object --\n";

      s += "entryNo : " + entryNo + "\n";
      s += "port : " + port + "\n";
      s += "date3 : " + date3 + "\n";
      s += "ccnNumber : " + ccnNumber + "\n";
      s += "classOfEntry : " + classOfEntry + "\n";
      s += "distNo : " + distNo + "\n";
      s += "portCodeNo : " + portCodeNo + "\n";
      s += "usPortOfUnlading : " + usPortOfUnlading + "\n";
      s += "portOf : " + portOf + "\n";
      s += "preparationDate : " + preparationDate + "\n";
       
      s += "enteredBy : " + enteredBy + "\n";
      s += "irsNbr : " + irsNbr + "\n";
      s += "inBondVia : " + inBondVia + "\n";
      s += "portDirector : " + portDirector + "\n";
      s += "finalForeignDestination : " + finalForeignDestination + "\n";
      s += "consignee : " + consignee + "\n";
      s += "foreignPortOfLading : " + foreignPortOfLading + "\n";
      s += "blNo : " + blNo + "\n";
      s += "dateOfSailing : " + dateOfSailing + "\n";
      s += "importedOn : " + importedOn + "\n";
      s += "flag : " + flag + "\n";
       
      s += "flightArrivalDate : " + flightArrivalDate + "\n";
      s += "lastForeignPort : " + lastForeignPort + "\n";
      s += "exportedFrom : " + exportedFrom + "\n";
      s += "flightDepartureDate : " + flightDepartureDate + "\n";
      s += "goodsNowAt : " + goodsNowAt + "\n";
      s += "marksAndNumbers : " + marksAndNumbers + "\n";
      s += "descriptionAndQuantity : " + descriptionAndQuantity + "\n";
      s += "grossWeight : " + grossWeight + "\n";
      s += "value : " + value + "\n";
      s += "pnNumber : " + pnNumber + "\n";
      s += "lineItemNote : " + lineItemNote + "\n";
       
      s += "certificateOfLading : " + certificateOfLading + "\n";
      s += "enteredOrWithdrawnComp : " + enteredOrWithdrawnComp + "\n";
      s += "enteredOrWithdrawnInd : " + enteredOrWithdrawnInd + "\n";
      s += "nos : " + nos + "\n";
      s += "carrierName : " + carrierName + "\n";
      s += "agentOfCarrier : " + agentOfCarrier + "\n";

      return s;
   }
}
