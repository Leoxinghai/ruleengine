package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import cciij.util.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;

public class UtilDumpState extends BusinessActionBase
{
  public UtilDumpState() throws Exception 
  {
  }

  public CCIIState doIt(CCIIState state, DatabaseBean db_connection) throws Exception 
  {
    System.out.println("*****************************************************************");
    System.out.println("*****************************************************************");
    System.out.println("***  Dumping the State object: " + state.hashCode());
    System.out.println(state);
    System.out.println("*****************************************************************");
    System.out.println("*****************************************************************");

    return state;
  }

}
