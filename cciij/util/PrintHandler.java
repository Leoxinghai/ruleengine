package cciij.util;


import java.io.*;
import java.text.*;
import java.util.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;

import rmtc.util.*;

/**
 * Title:        PrintHandler<br>
 * Description:  This class represents different printing logic to print different kind
 *               of fields and sections.
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
public class PrintHandler
{
  /**
   * printTableFieldsByDelimiterAndSize Split field values by both delimiter and size of 
   * each delimited part. The table has multiple columns and 1 row. Multiple values 
   * to be printed on seperate lines are required to be delimited by the delimiter defined
   * in configuration text file. If one table cell cannot acommodate a long field value
   * delimited by the delimiter, then the field value will be spit and printed on multiple
   * lines.
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param lineItemVector Vector of field values in lineItem Section
   * @param configVar Config variable
   * @param rowCount int value of the global row number of the document
   * @param startingFieldNumber field sequence number of the first field in line item
   * @param nextFieldNumber field sequence number of the next field after line item
   * section.
   * @return row count
   */
  public int printTableFieldsByDelimiterAndSize( PrintWriter printWriter, 
                                                 Vector lineItemVector, 
                                                 Config configVar, 
                                                 int rowCount, 
                                                 int startingFieldNumber,
                                                 int nextFieldNumber) throws Exception 
  {
    ArrayList fieldList = null;
    ArrayList tempList = null;
    int endIndex = 0;
    int startIndex = 0;
    int width = 0;
    String fieldLineValue = null;
    String fieldValue = null;
    String lineItemDelimiter = null;
    Vector fieldListVec = new Vector();
    Vector listSizeVec = new Vector();
    
    lineItemDelimiter = configVar.getString("FORM7512_LINEITEM_FIELD_DELIMITER");
    trace("lineItemDelimiter: " + lineItemDelimiter);

    for (int i = 0; i < lineItemVector.size(); i ++) 
    {
      fieldValue = (String)lineItemVector.elementAt(i);
      width = configVar.getInt("FORM7512_FIELD" + (startingFieldNumber + i) + "_END_COL")
        - configVar.getInt("FORM7512_FIELD" + (startingFieldNumber + i) + "_START_COL");
      fieldList = new ArrayList();
      
      if (fieldValue == null )
      {
        fieldValue = " " + lineItemDelimiter + " ";
      } else 
      {
        fieldValue = fieldValue.trim();
        if (fieldValue.length() == 0)
        {
          fieldValue = " " + lineItemDelimiter + " ";
        }
      }
      tempList = tokenize(fieldValue, lineItemDelimiter);
      for (int j=0; j < tempList.size(); j++ )
      {
        fieldLineValue = (String)tempList.get(j);
        while (fieldLineValue.length() > width)
        {
          endIndex = width;
          fieldList.add(fieldLineValue.substring(startIndex, endIndex));
          fieldLineValue = fieldLineValue.substring(endIndex, fieldLineValue.length());
        }
        if (fieldLineValue.length() > 0)
        {
          fieldList.add(fieldLineValue);
        }
      }
      trace("PrintHandler", 
            "printTableFieldsByDelimiterAndSize", 
            "fieldValue: " + fieldValue + "; fieldList size: " + fieldList.size());
      fieldListVec.add(fieldList);
      listSizeVec.add(new Integer(fieldList.size()));
    }

    rowCount = printTableFields(printWriter, fieldListVec, getMax(listSizeVec), configVar,
        rowCount, startingFieldNumber, nextFieldNumber);

    return rowCount;   
  }


  /**
   * printTableFieldsBySize Split field value by size. 
   * The table has multiple columns and 1 row. Long field value is
   * printed on multiple lines based on table cell width.
   * @param printWriter Print formatted representations of objects to a text-output 
   * stream.
   * @param lineItemVector Vector of field values in lineItem Section
   * @param configVar Config variable
   * @param rowCount int value of the global row number of the document
   * @param startingFieldNumber field sequence number of the first field in line item
   * @param nextFieldNumber field sequence number of the next field after line item
   * section.
   * @return row count
   */
  public int printTableFieldsBySize( PrintWriter printWriter, 
                                     Vector lineItemVector, 
                                     Config configVar, 
                                     int rowCount, 
                                     int startingFieldNumber,
                                     int nextFieldNumber) throws Exception 
  {
    ArrayList fieldList = null;
    int endIndex = 0;
    int linesInTable = 0;
    int startIndex = 0;
    int width = 0;
    String fieldValue = null;
    Vector fieldListVec = new Vector();
    Vector listSizeVec = new Vector();

    linesInTable = configVar.getInt("FORM7512_FIELD" + nextFieldNumber + "_START_ROW")
        - configVar.getInt("FORM7512_FIELD" + startingFieldNumber + "_START_ROW");

    for (int i = 0; i < lineItemVector.size(); i ++) 
    {
      fieldValue = (String)lineItemVector.elementAt(i);
      if (fieldValue == null )
      {
        fieldValue = "";
      } else 
      {
        fieldValue = fieldValue.trim();
      }

      width = configVar.getInt("FORM7512_FIELD" + (startingFieldNumber + i) + "_END_COL")
        - configVar.getInt("FORM7512_FIELD" + (startingFieldNumber + i) + "_START_COL");
      fieldList = new ArrayList();
      
      while (fieldValue.length() > width)
      {
        endIndex = width;
        fieldList.add(fieldValue.substring(startIndex, endIndex));
        fieldValue = fieldValue.substring(endIndex, fieldValue.length());
      }
      if (fieldValue.length() > 0)
      {
        fieldList.add(fieldValue);
      }
      fieldListVec.add(fieldList);
      listSizeVec.add(new Integer(fieldList.size()));
    }

    trace("PrintHandler", "printTableFieldsBySize", 
        "fieldListVec: " + fieldListVec + "**listSizeVec: " + listSizeVec);

    rowCount = printTableFields(printWriter, fieldListVec, getMax(listSizeVec), configVar,
        rowCount, startingFieldNumber, nextFieldNumber);

    return rowCount;
  }


  /**
   * printTableFieldsByDelimiter Split field value by delimiter. 
   * The table has multiple columns and 1 row. Multiple values 
   * to be printed on seperate lines are required to be delimited by the delimiter defined
   * in the configuration text file.
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param lineItemVector Vector of field values in lineItem Section
   * @param configVar Config variable
   * @param rowCount int value of the global row number of the document
   * @param startingFieldNumber field sequence number of the first field in line item
   * @param nextFieldNumber field sequence number of the next field after line item
   * section.
   * @return row count
   */
  public int printTableFieldsByDelimiter( PrintWriter printWriter, 
                                          Vector lineItemVector, 
                                          Config configVar, 
                                          int rowCount, 
                                          int startingFieldNumber,
                                          int nextFieldNumber) throws Exception 
  {
    ArrayList fieldList = null;
    int linesInTable = 0;
    String fieldValue = null;
    String lineItemDelimiter = null;
    Vector fieldListVec = new Vector();
    Vector listSizeVec = new Vector();

    linesInTable = configVar.getInt("FORM7512_FIELD" + nextFieldNumber + "_START_ROW")
        - configVar.getInt("FORM7512_FIELD" + startingFieldNumber + "_START_ROW");
    lineItemDelimiter = configVar.getString("FORM7512_LINEITEM_FIELD_DELIMITER");

    for (int i = 0; i < lineItemVector.size(); i ++) 
    {
      fieldValue = (String)lineItemVector.elementAt(i);
      
      if (fieldValue == null )
      {
        fieldValue = "";
      } else 
      {
        fieldValue = fieldValue.trim();
      }
      fieldList = tokenize(fieldValue, lineItemDelimiter);
      trace("PrintHandler", 
            "printTableFieldsByDelimiter", 
            "fieldValue: " + fieldValue + "; fieldList size: " + fieldList.size());
      fieldListVec.add(fieldList);
      listSizeVec.add(new Integer(fieldList.size()));
    }

    rowCount = printTableFields(printWriter, fieldListVec, getMax(listSizeVec), configVar,
        rowCount, startingFieldNumber, nextFieldNumber);

    return rowCount;
  }


  /**
   * printTableFields Print table section
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param fieldListVec Vector of field value lists in lineItem Section
   * @param configVar Config variable
   * @param rowCount int value of the global row number of the document
   * @param startingFieldNumber field sequence number of the first field in line item
   * @param nextFieldNumber field sequence number of the next field after line item
   * section.
   * @return row count
   */
  public int printTableFields(PrintWriter printWriter, 
                              Vector fieldListVec, 
                              int maxLines, 
                              Config configVar, 
                              int rowCount,
                              int startingFieldNumber, 
                              int nextFieldNumber) throws Exception 
  {
    ArrayList fieldList = null;
    boolean skipField = false;
    int currentFieldEndCol = 0;
    int linesInTable = 0;
    int previousFieldEndCol = 0;
    String fieldValue = null;

    linesInTable = configVar.getInt("FORM7512_FIELD" + nextFieldNumber + "_START_ROW")
        - configVar.getInt("FORM7512_FIELD" + startingFieldNumber + "_START_ROW");

    for (int lineCount = 0; (lineCount < maxLines) && (lineCount < linesInTable); 
      lineCount++) 
    {
      for (int fieldCount = 0; fieldCount < fieldListVec.size(); fieldCount++) 
      {
        skipField = false;
        fieldList = (ArrayList)fieldListVec.elementAt(fieldCount);
        trace("lineCount: " + lineCount + "; fieldCount: " + fieldCount + "; fieldList:" 
            + fieldList);
        if (fieldCount == 0)
        {
          if (lineCount < fieldList.size())
          {
            previousFieldEndCol = printField(printWriter, configVar.getInt("FORM7512_FIELD"
                + startingFieldNumber + "_START_COL"), (String)fieldList.get(lineCount), 
                startingFieldNumber, configVar);
            trace("previousFieldEndCol of field" + startingFieldNumber + " on line "
                + lineCount + ": " + previousFieldEndCol);
          } else 
          {
            skipField = true;
            previousFieldEndCol = 0;
          }
        } else 
        {
          currentFieldEndCol = printTableFieldPerLine(printWriter, lineCount, fieldList, 
              (startingFieldNumber + fieldCount), configVar, skipField, 
              previousFieldEndCol);
          trace("previousFieldEndCol of field" + (startingFieldNumber + fieldCount) +
              " on line " + lineCount + ": " + previousFieldEndCol);
          trace("currentFieldEndCol of field" + (startingFieldNumber + fieldCount) + 
              " on line " + lineCount + ": " + currentFieldEndCol);
          if (currentFieldEndCol > previousFieldEndCol) 
          {
            skipField = false;
          } else 
          {
            skipField = true;
          }
          previousFieldEndCol = currentFieldEndCol;
        }
      }
      printWriter.println();
      rowCount++;
    }
    return rowCount;
  }


  /**
   * printTableFieldPerLine
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param lineCount line count of the line item section
   * @param fieldList array list of tokenized String values of a line item field
   * @param fieldNumber field sequence number
   * @param configVar Config variable
   * @param skipField boolean value indicating whether a field is empty of not.
   * @param previousFieldEndCol int value indicating the end column number of the previous
   * field on the same line
   * @return column number of the current field being printed
   */
  public int printTableFieldPerLine(PrintWriter printWriter, 
                                    int lineCount, 
                                    ArrayList fieldList, 
                                    int fieldNumber,
                                    Config configVar, 
                                    boolean skipField, 
                                    int previousFieldEndCol) throws Exception
  {
    int currentFieldEndCol = 0;
    int spaceCountBetweenFields = 0;
    //print field27 ith line 
    if (lineCount < fieldList.size()) 
    {
      if (skipField) 
      {
        spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD" + fieldNumber +
            "_START_COL");
      } else {
        spaceCountBetweenFields = configVar.getInt("FORM7512_FIELD" + fieldNumber +
            "_START_COL") - previousFieldEndCol;
      }

      currentFieldEndCol = printField(printWriter, spaceCountBetweenFields, 
          (String)fieldList.get(lineCount), fieldNumber, configVar); 
    } else 
    {
      currentFieldEndCol = previousFieldEndCol;
    }

    return currentFieldEndCol;
  }

  /**
   * printSingleFieldPerLine
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param fieldNumber field sequence number
   * @param rowCount int value of the global row number of the document
   * @param configVar Config variable
   * @param fieldValue String value of the field data
   * @return row count
   */
  public int printSingleFieldPerLine( PrintWriter printWriter, 
                                      int fieldNumber, 
                                      int rowCount, 
                                      Config configVar, 
                                      String fieldValue) throws Exception 
  {
    //print blank lines before print the field
    rowCount = printBlankLine(printWriter, fieldNumber, rowCount, configVar);
    //print the field
    printField(printWriter, configVar.getInt("FORM7512_FIELD" + fieldNumber +
        "_START_COL"), fieldValue, fieldNumber, configVar);

    return rowCount;
  }

 /**
   * printSingleFieldOnMultipleLines
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param fieldNumber field sequence number
   * @param rowCount int value of the global row number of the document
   * @param configVar Config variable
   * @param fieldValue String value of the field data
   * @return row count
   */
  public int printSingleFieldOnMultipleLines( PrintWriter printWriter, 
                                              int fieldNumber, 
                                              int rowCount, 
                                              Config configVar, 
                                              String fieldValue) throws Exception 
  {
    boolean completePrint = false;
    int columnsOccupied = 0;
    int rowsOccupied = 0;
    int valueStartIndex = 0;

    if (fieldValue == null) 
    {
      fieldValue = "";
    } else 
    {
      fieldValue = fieldValue.trim();
    }

    trace("PrintHandler", "printSingleFieldOnMultipleLines", "fieldValue: " + fieldValue);

    //print blank lines before print the field
    rowCount = printBlankLine(printWriter, fieldNumber, rowCount, configVar);

    rowsOccupied = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_END_ROW") - 
        configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_ROW") + 1;
    if (rowsOccupied > 0)
    {
      columnsOccupied = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_END_COL") - 
        configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_COL") + 1;

      trace("PrintHandler", "printSingleFieldOnMultipleLines", "columnsOccupied: " +
          columnsOccupied + "; fieldLength: " + fieldValue.length());
      if (fieldValue.length() > columnsOccupied)
      {
        for (int i = 0; ((i < rowsOccupied) && (!completePrint)); i++)
        {
          trace("PrintHandler", "printSingleFieldOnMultipleLines", "valueStartIndex: " +
              valueStartIndex);
          printWriter.print(generateSpace(configVar.getInt("FORM7512_FIELD" + fieldNumber
              + "_START_COL")));
          if (i == 0)
          {
            printWriter.print(fieldValue.substring(valueStartIndex, columnsOccupied));
            valueStartIndex = columnsOccupied;
          } else {
            if ( (fieldValue.length() - columnsOccupied * i ) > columnsOccupied) 
            {
              printWriter.print(fieldValue.substring(valueStartIndex, 
                  (valueStartIndex + columnsOccupied)));
              valueStartIndex += columnsOccupied;
            } else {
              printWriter.print(fieldValue.substring(valueStartIndex, 
                  (valueStartIndex + fieldValue.length() - columnsOccupied * i)));
              completePrint = true;
            }
          }
          printWriter.println();
          rowCount++;
        }
      } else 
      {
        printField(printWriter, configVar.getInt("FORM7512_FIELD" + fieldNumber +
            "_START_COL"), fieldValue, fieldNumber, configVar);
      }
    }
    
    return rowCount;
  }


  /**
   * printField
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param spaceBeforeField number of spaces before print current field
   * @param fieldValue String value of the field data
   * @param fieldNumber field sequence number
   * @param configVar Config variable
   * @return actual end column number of the field printed
   */
  public int printField( PrintWriter printWriter, 
                         int spaceBeforeField, 
                         String fieldValue, 
                         int fieldNumber, 
                         Config configVar) throws Exception 
  {
    int fieldLength = 0;
    int actualEndCol = 0;

    if (fieldValue == null)
    {
      fieldValue = "";
    } else 
    {
      fieldValue = fieldValue.trim();
    }

    printWriter.print(generateSpace(spaceBeforeField));
      
    fieldLength = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_END_COL") - 
        configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_COL");
    trace("Printing field" + fieldNumber + ": fieldLength: " + fieldLength + "; fieldValue: " + fieldValue);
    if (fieldValue.length() > fieldLength) 
    {
      printWriter.print(fieldValue.substring(0, fieldLength));
      actualEndCol = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_COL") + 
          fieldLength;
    } else 
    {
      printWriter.print(fieldValue);
      actualEndCol = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_COL") + 
          fieldValue.length();
    }

    trace("field" + fieldNumber + " end column: " + actualEndCol);
    return actualEndCol;
  }


  /**
   * printBlankLine
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param fieldNumber field sequence number
   * @param rowCount int value of the global row number of the document
   * @param configVar Config variable
   * @return row count
   */
  public int printBlankLine( PrintWriter printWriter, 
                             int fieldNumber, 
                             int rowCount,
                             Config configVar) throws Exception 
  {
    int fieldRow = 0;

    fieldRow = configVar.getInt("FORM7512_FIELD" + fieldNumber + "_START_ROW");
    trace("Print blank lines after field " + (fieldNumber -1) + 
        "; rowCount: " + rowCount + "; field" + fieldNumber + "Row: " + fieldRow);
    if (rowCount < fieldRow ) 
    {
      printBlankLine(printWriter, (fieldRow - rowCount));
      rowCount = fieldRow;
    }
    return rowCount;
  }


  /**
   * printBlankLine
   * @param printWriter Print formatted representations of objects to a text-output stream.
   * @param blankLineNumber number of blank lines
   */
  public void printBlankLine( PrintWriter printWriter, 
                              int blankLineNumber ) throws Exception 
  {
    int i = 0;

    while (i < blankLineNumber) 
    {
      printWriter.println();
      i++;
    }
  }

  /**
   * generateSpace
   * @param configVar Config variable
   * @param configPropertyName name of the property in configuration file
   * @return string value of spaces of a certain length
   */
  public String generateSpace( Config configVar, 
                               String configPropertyName) 
  {
    int spaceNumber = 0;
    StringBuffer space = null;
    
    space = new StringBuffer( );
    spaceNumber = configVar.getInt(configPropertyName);

    for (int i = 0; i < spaceNumber; i++) 
    {
      space.append(" ");
    }
    return space.toString();
  }


  /**
   * generateSpace
   * @param spaceNumber number of spaces
   * @return string value of spaces of a certain length
   */
  public String generateSpace(int spaceNumber) 
  {
    StringBuffer space = null;
    
    space = new StringBuffer( );

    for (int i = 0; i < spaceNumber; i++) 
    {
      space.append(" ");
    }
    return space.toString();
  }


  /**
   * tokenize
   * @param str the string to tokenize
   * @param delimiter 
   * @return a list of strings tokenized
   */
  public ArrayList tokenize( String str, 
                             String delimiter ) 
  {
    ArrayList strList = new ArrayList();
    String tempStr = null;
    StringTokenizer strTokens = new StringTokenizer(str, delimiter);

    while (strTokens.hasMoreTokens())
    {
      tempStr = strTokens.nextToken();
      strList.add(tempStr);
    }

    return strList;
  }


  /**
   * getMax
   * @param numVec Vector of numeric numbers
   * @return the maximum of the numric numbers in the vector
   */
  public int getMax(Vector numVec) 
  {
    int maxValue = 0;

    if (numVec.size() > 0)
    {
      for (int i = 0; i < numVec.size(); i++) 
      {
        maxValue = Math.max(maxValue, ((Integer)numVec.elementAt(i)).intValue());
      }
    }

    return maxValue;
  }
  

  /**
   * trace
   * @param className
   * @param methodName
   * @param message
   */
  public static void trace(String className, 
                           String methodName, 
                           String message) 
  {
    String newMessage = null;

    newMessage = "[" + className + "] - " + "<" + methodName + "> - " + message;
    trace(message);
  }


  /**
   * trace
   * @param message
   */
  public static void trace(String message) 
  {
    System.out.println(message);
  }

}