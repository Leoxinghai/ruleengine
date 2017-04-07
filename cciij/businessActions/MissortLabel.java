//*************************************************************************
//
// Filename: MissortLabel.java
//
// Description:  Printer Code Label
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/MissortLabel.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   04/18/05  Gary Rockwood     initial creation
//
//*************************************************************************

package cciij.businessActions;

import java.io.*;
import cciij.util.*;
import cciij.cciidata.*;
import cciij.cciidatabase.*;

import cciij.businessActions.label.*;
import java.util.Map;

public class MissortLabel extends FileBasedLabel
{
    private static final String m_whatVersion = "@(#) $RCSfile: MissortLabel.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    //    LabelDefinitionInterface m_definition;
    public MissortLabel() throws Exception
    {
        super("MissortLabel");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        return null;
    }


    public static void main(String args[])
    {
        return;
    }
}
