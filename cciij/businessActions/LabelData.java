//*************************************************************************
//
// Filename: LabelData.java
//
// Description:  implementation of core data container for labels
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/businessActions/LabelData.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:01 $
//
// Modification History:
//
//   06/05/01  Michael Roderick Commented
//
//*************************************************************************

package cciij.businessActions;
import cciij.businessActions.label.*;

public class LabelData
{
    private static final String m_whatVersion = "@(#) $RCSfile: LabelData.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";
    private final int DEFAULT_LABEL_STRING_COUNT=200;

    private int mi_dataCount;
    private int mi_nextLocation=0;

    private String[] ms_data;

    public LabelData(int ai_stringCount)
    {
        ms_data = new String[ai_stringCount];
        mi_dataCount = ai_stringCount;
    }

    public LabelData()
    {
        ms_data = new String[DEFAULT_LABEL_STRING_COUNT];
        mi_dataCount = DEFAULT_LABEL_STRING_COUNT;
    }

    public int getDataCount()
    {
        return mi_dataCount;
    }

    public void addString(String as_data)
    {
        //	System.out.println("Going to try to add one to slot:  " + (mi_nextLocation + 1));
        ms_data[mi_nextLocation++] = as_data;
    }

    public String getString(int ai_stringLocation)
    {
        return ms_data[ai_stringLocation];
    }
}
