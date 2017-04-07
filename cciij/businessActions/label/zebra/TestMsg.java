// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TestMsg.java

package cciij.businessActions.label.zebra;

import cciij.businessActions.LabelData;
import cciij.businessActions.label.*;
import cciij.cciidata.CCIIState;
import cciij.cciidata.RPBScan;
import cciij.cciidatabase.DatabaseBean;
import java.io.PrintStream;

// Referenced classes of package cciij.businessActions.label.zebra:
//            LabelFormatTypeUtil

public class TestMsg extends LabelBase
{

    public TestMsg()
        throws Exception
    {
        super("TestMsg");
    }

    protected LabelData getLabelData(CCIIState a_data)
    {
        return null;
    }

    public void test(CCIIState a_data)
        throws Exception
    {
        DatabaseBean db = new DatabaseBean();
        db.connect();
        db.setLocationCode("ALL");
        System.out.println("Get the printServer");
        PrintServer ps = getPrintServer("TestMsg", "COS", db, false);
        System.out.println("Create the LabelDefinitionMux");
        LabelDefinitionMux defs = new LabelDefinitionMux();
        System.out.println("Construct the dummy FileBasedLabelDefinition()");
        FileBasedLabelDefinition def = new FileBasedLabelDefinition(0, "/ccs/home/mr364942/source/cciirun/etc/TestMsg.dat", "zebra");
        System.out.println("def.setFormatTypeUtil()");
        def.setFormatTypeUtil(new LabelFormatTypeUtil());
        System.out.println("defs.addLabelDefinition()");
        defs.addLabelDefinition("zebra", a_data.getScan().getLocationCode(), def);
        System.out.println("construct the LabelTransmition Object");
        LabelTransmition cmds = new LabelTransmition(ps.getPrinterFormatType(), a_data.getScan().getLocationCode(), defs);
        cmds.addFormattedCommand("! 0 200 200 20 1\r\n");
        cmds.addFormattedCommand("TEXT 4 0 30 40 Hello World\r\n");
        cmds.addFormattedCommand("FORM\r\n");
        cmds.addFormattedCommand("PRINT\r\n");
        ps.transmit(cmds, a_data);
    }

    public static void main(String args[])
    {
        CCIIState a_data = new CCIIState();
        try
        {
            TestMsg msg = new TestMsg();
            msg.test(a_data);
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception in TestMsg.main():  " + e);
            e.printStackTrace(System.out);
        }
    }
}
