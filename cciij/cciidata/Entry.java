package cciij.cciidata;

/**
 * Title:        Entry - used to store data from the Entry table
 * Description:
 * Copyright:    Copyright (c) 2004
 * Company:      FedEx
 * @author       Joey Cline
 * @version 1.0
 */
import java.io.Serializable;


public class Entry  implements Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: Entry.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:11 $\n";

  private String m_entryCategoryTypeCd;
  private int m_routeLegOidNbr;
  private String m_entryNbr;
  private int m_brokerFileNbr;

  /**
   * Public default constructor
   */
  public Entry()
  {
  }

  /**
   * Public constructor
   * @param String entryCategoryTypeCd
   * @param int routeLegOidNbr
   * @param String entryNbr
   * @param int brokerFileNbr
   */
  public Entry( String entryCategoryTypeCd,
                int routeLegOidNbr,
                String entryNbr,
                int brokerFileNbr )
  {
    m_entryCategoryTypeCd = entryCategoryTypeCd;
    m_routeLegOidNbr = routeLegOidNbr;
    m_entryNbr = entryNbr;
    m_brokerFileNbr = brokerFileNbr;
  }

  public boolean setEntryCategoryTypeCd (String val)
  {
    m_entryCategoryTypeCd = val;
    return true;
  }

  public boolean setRouteLegOidNbr (int val)
  {
    m_routeLegOidNbr = val;
    return true;
  }

  public boolean setEntryNbr (String val)
  {
    m_entryNbr = val;
    return true;
  }

  public boolean setBrokerFileNbr (int val)
  {
    m_brokerFileNbr = val;
    return true;
  }


  public String getEntryCategoryTypeCd ()
  {
    return m_entryCategoryTypeCd;
  }

  public int getRouteLegOidNbr ()
  {
    return m_routeLegOidNbr;
  }

  public String getEntryNbr ()
  {
    return m_entryNbr;
  }

  public int getBrokerFileNbr ()
  {
    return m_brokerFileNbr;
  }

  /**
   * toString
   * @return String
   */
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("EntryCategoryTypeCd: " + m_entryCategoryTypeCd + "\n");
    sb.append("RouteLegOidNbr     : " + m_routeLegOidNbr + "\n");
    sb.append("EntryNbr           : " + m_entryNbr + "\n");
    sb.append("BrokerFileNbr      : " + m_brokerFileNbr + "\n");
    return sb.toString();
  }

}



