package cciij.util;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.print.*;
import java.lang.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;
import cciij.cciidata.*;
import cciij.businessActions.*;

import rmtc.util.*;

/**
 * Title:        Print7512Form<br>
 * Description:  This class represents the logic to print values for form7512.
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
public class Print7512Form
{
  
  /**
   * print7512Form handles printing logic of form7512
   * @param formData data object of form 7512 
   */
  public void print(Form7512Data formData, Config configVar, String fileName)
  {
    int field4Length = 0;
    int field5Length = 0;
    int field6Length = 0;
    int field7Length = 0;
    int field3EndCol = 0;
    int field7EndCol = 0;
    int field9EndCol = 0;
    int field11EndCol = 0;
    int field111EndCol = 0;
    int field13EndCol = 0;
    int field16EndCol = 0;
    int field17EndCol = 0;
    int field19EndCol = 0;
    int field20EndCol = 0;
    int field21EndCol = 0;
    int field23EndCol = 0;
    int field24EndCol = 0;
    int rowCount = 1;
    int spaceCountBetweenFields = 0;
    PrintHandler printHandler = new PrintHandler();
    PrintWriter printWriter = null;
    String datePattern = null;
    String outputFileNameWithPath = null;
    String value1 = null;
    String value2 = null;
    String value3 = null;
    String value4 = null;
    String value5 = null;
    String value7 = null;
    String value8 = null;
    String value9 = null;
    String value10 = null;
    String value11 = null;
    String value111 = null;
    String value12 = null;
    String value13 = null;
    String value14 = null;
    String value15 = null;
    String value16 = null;
    String value17 = null;
    String value18 = null;
    String value19 = null;
    String value20 = null;
    String value21 = null;
    String value22 = null;
    String value23 = null;
    String value24 = null;
    String value25 = null;
    String value26 = null;
    String value27 = null;
    String value28 = null;
    String value29 = null;
    String value291 = null;
    String value30 = null;
    String value31 = null;
    String value32 = null;
    String value33 = null;
    String value34 = null;
    String value35 = null;
    String value36 = null;
    Vector lineItemVector = new Vector();
    String fileNameTemp = "";
    String fileNameFinal = "";
    
    outputFileNameWithPath = (configVar.getValue("FORM7512_FILE_NAME_WITH_PATH"));
    fileNameTemp =  outputFileNameWithPath + fileName + ".tmp";
    fileNameFinal = outputFileNameWithPath + fileName + ".txt";
    File envFile = new File ( fileNameTemp ) ;
    try {
      printHandler.trace("outputfilename: " + outputFileNameWithPath);
      printWriter = new PrintWriter(new BufferedWriter(new FileWriter(envFile)));
      datePattern = configVar.getString("FORM7512_DATE_FORMAT");
      printHandler.trace("datepattern: " + datePattern);

      //print field4
      printHandler.trace("Before printing field 4");
      value4 = formData.getCcnNumber();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 4, rowCount, configVar,
          value4);

      //print field1
      printHandler.trace("Before printing field 1");
      value1 = formData.getEntryNo();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 1, rowCount, configVar,
          value1);
    
      //print field5
      printHandler.trace("Before printing field 5");
      value5 = formData.getClassOfEntry();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 5, rowCount, configVar,
          value5);

      //print field2
      printHandler.trace("Before printing field 2");
      value2 = formData.getPort();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 2, rowCount, configVar,
          value2);
     
      //print field3
      printHandler.trace("Before printing field 3");
      if (formData.getDate3() != null) 
      {
        value3 = formatDate(formData.getDate3(), datePattern);
      } 
      rowCount = printHandler.printBlankLine(printWriter, 3, rowCount, configVar);
      field3EndCol = printHandler.printField(printWriter, 
          configVar.getInt("FORM7512_FIELD3_START_COL"), value3, 3, configVar);

      //print field7
      printHandler.trace("Before printing field 7");
      value7 = formData.getPortCodeNo();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD7_START_COL") - 
          field3EndCol;
      printHandler.trace("field7 spaceCountBetweenFields: " + spaceCountBetweenFields);
      field7EndCol = printHandler.printField(printWriter, spaceCountBetweenFields, value7, 7, configVar);

      //print field8
      printHandler.trace("Before printing field 8");
      value8 = formData.getUsPortOfUnlading();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD8_START_COL") - 
          field7EndCol;
      printHandler.trace("field8 spaceCountBetweenFields: " + spaceCountBetweenFields);
      printHandler.printField(printWriter, spaceCountBetweenFields, value8, 8, configVar);

      //print field9
      printHandler.trace("Before printing field 9");
      value9 = formData.getPortOf();
      rowCount = printHandler.printBlankLine(printWriter, 9, rowCount, configVar);
      field9EndCol = printHandler.printField(printWriter, configVar.getInt("FORM7512_FIELD9_START_COL"),
          value9, 9, configVar);

      //print field10
      printHandler.trace("Before printing field 10");
      if (formData.getPreparationDate() != null) 
      {
        value10 = formatDate(formData.getPreparationDate(), datePattern);
      } 
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD10_START_COL") - field9EndCol;
      printHandler.printField(printWriter, spaceCountBetweenFields, value10, 10, configVar); 

      //print field11
      printHandler.trace("Before printing field 11");
      value11 = formData.getEnteredBy();
      rowCount = printHandler.printBlankLine(printWriter, 11, rowCount, configVar);
      field11EndCol = printHandler.printField(printWriter, 
          configVar.getInt("FORM7512_FIELD11_START_COL"), value11, 11, configVar);

      //print field111
      printHandler.trace("Before printing field 111");
      value111 = formData.getIrsNbr();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD111_START_COL") - 
          field11EndCol;
      printHandler.trace("field111 spaceCountBetweenFields: " + spaceCountBetweenFields);
      printHandler.printField(printWriter, spaceCountBetweenFields, value111, 111, configVar);                    

      //print field12
      printHandler.trace("Before printing field 12");
      value12 = formData.getInBondVia();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 12, rowCount, configVar, value12);

      //print field13
      printHandler.trace("Before printing field 13");
      value13 = formData.getPortDirector();
      rowCount = printHandler.printBlankLine(printWriter, 13, rowCount, configVar);
      field13EndCol = printHandler.printField(printWriter, configVar.getInt("FORM7512_FIELD13_START_COL"),
          value13, 13, configVar);

      //print field14
      printHandler.trace("Before printing field 14");
      value14 = formData.getFinalForeignDestination();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD14_START_COL") - field13EndCol;
      printHandler.printField(printWriter, spaceCountBetweenFields, value14, 14, configVar); 

      //print field15
      printHandler.trace("Before printing field 15");
      value15 = formData.getConsignee();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 15, rowCount, configVar, value15);

      //print field16
      printHandler.trace("Before printing field 16");
      value16 = formData.getForeignPortOfLading();
      rowCount = printHandler.printBlankLine(printWriter, 16, rowCount, configVar);
      field16EndCol = printHandler.printField(printWriter, configVar.getInt("FORM7512_FIELD16_START_COL"),
          value16, 16, configVar);

      //print field17
      printHandler.trace("Before printing field 17");
      value17 = formData.getBlNo();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD17_START_COL") - field16EndCol;
      field17EndCol = printHandler.printField(printWriter, spaceCountBetweenFields, value17, 17, configVar); 

      //print field18
      printHandler.trace("Before printing field 18");
      if (formData.getDateOfSailing() != null) 
      {
        value18 = formatDate(formData.getDateOfSailing(), datePattern);
      } 
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD18_START_COL") - field17EndCol;
      printHandler.printField(printWriter, spaceCountBetweenFields, value18, 18, configVar);

      //print field19
      printHandler.trace("Before printing field 19");
      value19 = formData.getImportedOn();
      rowCount = printHandler.printBlankLine(printWriter, 19, rowCount, configVar);
      field19EndCol = printHandler.printField(printWriter, configVar.getInt("FORM7512_FIELD19_START_COL"),
          value19, 19, configVar);

      //print field20
      printHandler.trace("Before printing field 20");
      value20 = formData.getFlag();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD20_START_COL") - field19EndCol;
      field20EndCol = printHandler.printField(printWriter, spaceCountBetweenFields, value20, 20, configVar); 

      //print field21
      printHandler.trace("Before printing field 21");
      if (formData.getFlightArrivalDate() != null)
      {
        value21 = formatDate(formData.getFlightArrivalDate(), datePattern);
      }
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD21_START_COL") - field20EndCol;
      field21EndCol = printHandler.printField(printWriter, spaceCountBetweenFields, value21, 21, configVar); 

      //print field22
      printHandler.trace("Before printing field 22");
      value22 = formData.getLastForeignPort();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD22_START_COL") - field21EndCol;
      printHandler.printField(printWriter, spaceCountBetweenFields, value22, 22, configVar);

      //print field23
      printHandler.trace("Before printing field 23");
      value23 = formData.getExportedFrom();
      rowCount = printHandler.printBlankLine(printWriter, 23, rowCount, configVar);
      field23EndCol = printHandler.printField(printWriter, configVar.getInt("FORM7512_FIELD23_START_COL"),
          value23, 23, configVar);

      //print field24
      printHandler.trace("Before printing field 24");
      if (formData.getFlightDepartureDate() != null)
      {
        value24 = formatDate(formData.getFlightDepartureDate(), datePattern);
      }
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD24_START_COL") - field23EndCol;
      field24EndCol = printHandler.printField(printWriter, spaceCountBetweenFields, value24, 24, configVar); 

      //print field25
      printHandler.trace("Before printing field 25");
      value25 = formData.getGoodsNowAt();
      spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD25_START_COL") - field24EndCol;
      printHandler.printField(printWriter, spaceCountBetweenFields, value25, 25, configVar);
      
      //print line item section field 26-29
      printHandler.trace("\r\n===========Before print line item.===========");
      rowCount = printHandler.printBlankLine(printWriter, 26, rowCount, configVar);

      value26 = "" + formData.getMarksAndNumbers();
      lineItemVector.add(value26);
      value27 = formData.getDescriptionAndQuantity();
      lineItemVector.add(value27);
      value28 = "" + formData.getGrossWeight();
      lineItemVector.add(value28);
      value29 = "" + formData.getValue();
      lineItemVector.add(value29);

      rowCount = printHandler.printTableFieldsByDelimiterAndSize(printWriter, lineItemVector, configVar, rowCount, 26, 291);
      
      printHandler.trace("\r\n===========After print line item.===========");
      printHandler.trace("\r\n====rowCount: " + rowCount);

      //print field291
      if (formData.getPnNumber() != null) {
         value291 = "" + "PN# " + formData.getPnNumber();
      }
      rowCount = printHandler.printSingleFieldOnMultipleLines(printWriter, 291, rowCount, configVar, value291);

      //print field30
      value30 = formData.getLineItemNote();
      rowCount = printHandler.printSingleFieldOnMultipleLines(printWriter, 30, rowCount, configVar, value30);

      //print field31
      value31 = formData.getCertificateOfLading();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 31, rowCount, configVar, value31);

      //print field32
      value32 = formData.getEnteredOrWithdrawnComp();
      printHandler.trace("value32: " + value32);
      rowCount = printHandler.printSingleFieldOnMultipleLines(printWriter, 32, rowCount, configVar, value32);

      //print field33
      value33 = formData.getEnteredOrWithdrawnInd();
      printHandler.trace("value33: " + value33);
      rowCount = printHandler.printSingleFieldOnMultipleLines(printWriter, 33, rowCount, configVar, value33);

      //print field34
      value34 = formData.getNos();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 34, rowCount, configVar, value34);

      //print field35
      value35 = formData.getCarrierName();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 35, rowCount, configVar, value35);

      //print field36
      value36 = formData.getAgentOfCarrier();
      rowCount = printHandler.printSingleFieldPerLine(printWriter, 36, rowCount, configVar, value36);
      //print 1 blank line after the last printed field
      printHandler.printBlankLine(printWriter, 1);

    } catch (Exception e) 
    {
      printHandler.trace("\nERROR WRITING OUTPUT TO FILE /" + outputFileNameWithPath + 
          ": " + e);
    } finally 
    {
      try
      {
        printWriter.flush();
      	printWriter.close();
      	File envFileFinal = new File ( fileNameFinal );
        envFile.renameTo ( envFileFinal );
      }
      catch (Exception e)
      {
        printHandler.trace("Error closing print writer.");
      }
    }
    
    printHandler.trace("End of print form 7512");   
    
}  


  /**
   * formatDate
   * @param calendarField date field represented as GregorianCalendar
   * @param datePattern the String pattern to format the date to
   * @return formatted date String
   */
  public String formatDate(Date calendarField, String datePattern)
  {
    SimpleDateFormat dateFormat = null;
    String dateStr = null;
    
    dateFormat = new SimpleDateFormat(datePattern);
    dateStr = dateFormat.format(calendarField);

    PrintHandler.trace("dateStr: " + dateStr);

    return dateStr;
  }
 
 
}
