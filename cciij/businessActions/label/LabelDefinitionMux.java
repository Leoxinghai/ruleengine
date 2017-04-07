// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LabelDefinitionMux.java

package cciij.businessActions.label;

import cciij.businessActions.LabelData;
import cciij.cciidata.CCIIState;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package cciij.businessActions.label:
//            LabelDefinitionInterface, LabelPrintException, LabelTransmition, LabelFormatTypeUtilInterface

public class LabelDefinitionMux
{

    public LabelDefinitionMux()
    {
        m_definitions = new TreeMap();
    }

    public void addLabelDefinition(String printerFormatType, String locationCode, LabelDefinitionInterface ldef)
    {
        String key = locationCode + ":" + printerFormatType;
        m_definitions.put(key, ldef);
    }

    public boolean sendInit(LabelTransmition cmds)
        throws LabelPrintException
    {
        String key = cmds.getFormatLocationCode() + ":" + cmds.getFormatTypeCode();
        LabelDefinitionInterface labDef;
        if((labDef = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return labDef.sendInit(cmds);
        }
    }

    public boolean isFormatNeeded(LabelTransmition cmds, CCIIState a_data)
        throws LabelPrintException
    {
        String key = cmds.getFormatLocationCode() + ":" + cmds.getFormatTypeCode();
        LabelDefinitionInterface labDef;
        if((labDef = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return labDef.isFormatNeeded(a_data);
        }
    }

    public boolean sendFormat(LabelTransmition cmds)
        throws LabelPrintException
    {
        String key = cmds.getFormatLocationCode() + ":" + cmds.getFormatTypeCode();
        LabelDefinitionInterface labDef;
        if((labDef = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return labDef.sendFormat(cmds);
        }
    }

    public boolean printLabel(LabelTransmition cmds, LabelData a_data)
        throws LabelPrintException
    {
        String key = cmds.getFormatLocationCode() + ":" + cmds.getFormatTypeCode();
        LabelDefinitionInterface labDef;
        if((labDef = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return labDef.printLabel(cmds, a_data);
        }
    }

    public boolean printLabel(LabelTransmition cmds, CCIIState a_data)
        throws LabelPrintException
    {
        String key = cmds.getFormatLocationCode() + ":" + cmds.getFormatTypeCode();
        LabelDefinitionInterface labDef;
        if((labDef = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return labDef.printLabel(cmds, a_data);
        }
    }

    public LabelFormatTypeUtilInterface getFormatTypeUtil(String printerCode, String locationCode)
        throws LabelPrintException
    {
        String key = locationCode + ":" + printerCode;
        LabelDefinitionInterface def;
        if((def = (LabelDefinitionInterface)m_definitions.get(key)) == null)
        {
            System.out.println("Update site_param entry 'LABEL_DEFINITION_LOCATION_LIST'");
            throw new LabelPrintException("Can't Find Definition for Format Type:  " + key);
        } else
        {
            return def.getFormatTypeUtil();
        }
    }

    public void setFormatNumber(int ai_formatNumber)
    {
        m_formatNumber = ai_formatNumber;
    }

    public int getFormatNumber()
    {
        return m_formatNumber;
    }

    public void resetLabelFormat()
    {
        LabelDefinitionInterface labDef;
        for(Iterator iter = m_definitions.values().iterator(); iter.hasNext(); labDef.resetLabelFormat())
            labDef = (LabelDefinitionInterface)iter.next();

    }

    private int m_formatNumber;
    private Map m_definitions;
}
