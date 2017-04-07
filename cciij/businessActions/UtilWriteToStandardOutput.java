package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;

public class UtilWriteToStandardOutput extends BusinessActionBase
{
  private static final String m_whatVersion = "@(#) $RCSfile: UtilWriteToStandardOutput.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
 
  protected String m_stdoutString = "";
  protected String m_groupName = "";

  public UtilWriteToStandardOutput() throws Exception 
  {
  }

  public UtilWriteToStandardOutput(String groupName) throws Exception 
  {
    super ( groupName );
    m_groupName = groupName;
  }

  protected void readSiteConfigVariables() throws Exception
  {
    String m_stdoutString = m_config.getString ( "UTIL_WRITE_TO_STDOUT", "UTIL_WRITE_TO_STDOUT_NOT_DEFINED" );

    super.readSiteConfigVariables();
    //no local variables to read
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db_connection) throws Exception 
  {
    System.out.println ( "UTIL_WRITE_TO_STDOUT[" + m_groupName + "] = [" + m_stdoutString + "]" );

    return state;
  }

}
