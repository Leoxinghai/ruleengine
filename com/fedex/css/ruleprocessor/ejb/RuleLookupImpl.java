// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RuleLookupImpl.java

package com.fedex.css.ruleprocessor.ejb;

import com.fedex.css.ruleprocessor.*;
import com.fedex.css.ruleprocessor.datamanager.DataManagerImpl;
import com.fedex.css.ruleprocessor.datamanager.DataManagerInterface;
import com.fedex.css.util.Trace;
import java.io.PrintStream;
import java.util.*;
import rmtc.util.Config;

// Referenced classes of package com.fedex.css.ruleprocessor.ejb:
//            RuleProcessorImpl

public class RuleLookupImpl
    implements RuleLookupInterface
{

    public RuleLookupImpl()
    {
        theRuleSets = null;
        businessActions = null;
        actionMethods = null;
        trace = new Trace();
    }

    public void initialize()
    {
        beanHashCode = hashCode();
        trace = new Trace();
    }

    public boolean updateRules()
    {
    	try {
	        if(!loadRules())
	            return false;
	        ruleTimeStamp = new Date();
	        return true;
    	} catch(Exception ex) {
	        return false;
    	}
    }

    public boolean updateBusinessActions()
    {
        trace.trace(64, "RuleLookupImpl, updateBusinessActions called");
        try
        {
            trace.trace(64, "RuleLookupImpl, reread Config");
            Config config = new Config();
            config.reread();
            trace.trace(64, "RuleLookupImpl, Config returned");
        }
        catch(Exception exception)
        {
            trace.trace(2, "0009", "RuleLookupImpl.udateBusinessActions", "Error reading config: " + exception);
        }
        if(loadBusinessActions() && loadActionMethods())
        {
            trace.trace(64, "RuleLookupImpl, loadBusinessAction true ");
            actionTimeStamp = new Date();
            return true;
        } else
        {
            trace.trace(64, "RuleLookupImpl, loadBusinessAction false");
            return false;
        }
    }

    public boolean updateActionMethods()
    {
        if(loadActionMethods())
        {
            methodTimeStamp = new Date();
            return true;
        } else
        {
            return false;
        }
    }

    public RuleLookupContainer getRules(Date date)
    {
        if(ruleTimeStamp == null)
            updateRules();
        RuleLookupContainer rulelookupcontainer = new RuleLookupContainer();
        if(date.equals(ruleTimeStamp))
        {
            return null;
        } else
        {
            rulelookupcontainer.setData(theRuleSets);
            rulelookupcontainer.setTimeStamp(ruleTimeStamp);
            return rulelookupcontainer;
        }
    }

    public RuleLookupContainer getBusinessActions(Date date)
    {
        if(actionTimeStamp == null)
            updateBusinessActions();
        RuleLookupContainer rulelookupcontainer = new RuleLookupContainer();
        if(date.equals(actionTimeStamp))
        {
            return null;
        } else
        {
            rulelookupcontainer.setData(businessActions);
            rulelookupcontainer.setTimeStamp(actionTimeStamp);
            return rulelookupcontainer;
        }
    }

    public RuleLookupContainer getActionMethods(Date date, int i)
    {
        if(methodTimeStamp == null)
            updateActionMethods();
        RuleLookupContainer rulelookupcontainer = new RuleLookupContainer();
        if(date.equals(actionTimeStamp))
        {
            trace.trace(16, "RuleLookupImpl.getActionMethods - Date are equal returning null");
            return null;
        } else
        {
            rulelookupcontainer.setData((Hashtable)actionMethods.get(new Integer(i)));
            rulelookupcontainer.setTimeStamp(methodTimeStamp);
            return rulelookupcontainer;
        }
    }

    private boolean loadRules()
        throws Exception
    {
        Date date = new Date();
        printMessage("Start LoadRules");
        DataManagerImpl datamanagerimpl = new DataManagerImpl();
        printTimingMessage("loadRules: Datamanager ready", date);
        Hashtable hashtable = new Hashtable();
        try
        {
            Vector vector = new Vector();
            Rule rule = new Rule();
            RuleSet ruleset = new RuleSet();
            RuleAction ruleaction = new RuleAction();
            ruleset = datamanagerimpl.fetchRuleSet();
            if(ruleset == null)
            {
                trace.trace(1, "NO RULE SETS FOUND, SYSTEM EXITING...");
                System.exit(-1);
            }
            int i = ruleset.getRuleNbr();
            String s = ruleset.getSetNm();
            for(; ruleset != null; ruleset = datamanagerimpl.fetchNextRuleSet())
            {
                printTimingMessage("loadRules: fetchRuleSet returned", date);
                if(ruleset.getRuleNbr() != i || s.compareTo(ruleset.getSetNm()) != 0)
                {
                    Action action = new Action();
                    for(RuleAction ruleaction1 = datamanagerimpl.fetchRuleAction(i, s); ruleaction1 != null; ruleaction1 = datamanagerimpl.fetchNextRuleAction())
                    {
                        printTimingMessage("loadRules: fetchRuleAction returned", date);
                        action.setClassID(ruleaction1.getFactoryActionTypeNbr());
                        action.setMethodID(ruleaction1.getActionMethodNbr());
                        action.setPostCondClassID(ruleaction1.getPcClassIDNbr());
                        action.setPostCondFieldID(ruleaction1.getPcFieldIDNbr());
                        action.setPostCondVal(ruleaction1.getPcValue());
                        rule.addAction(action);
                        action = new Action();
                    }

                    vector.add(rule);
                    rule = new Rule();
                    i = ruleset.getRuleNbr();
                    s = ruleset.getSetNm();
                }
                Condition condition = new Condition();
                condition.setClassID(ruleset.getClassIdNbr());
                condition.setFieldID(ruleset.getFieldIdNbr());
                condition.setOp(ruleset.getOperationNbr());
                condition.setSetName(ruleset.getSetNm());
                condition.setValue(ruleset.getValueDesc());
                condition.setCompareClassID(ruleset.getCompClassIdNbr());
                condition.setCompareFieldID(ruleset.getCompFieldIdNbr());
                rule.addCondition(condition);
            }

            Action action1 = new Action();
            for(RuleAction ruleaction2 = datamanagerimpl.fetchRuleAction(i, s); ruleaction2 != null; ruleaction2 = datamanagerimpl.fetchNextRuleAction())
            {
                action1.setClassID(ruleaction2.getFactoryActionTypeNbr());
                action1.setMethodID(ruleaction2.getActionMethodNbr());
                action1.setPostCondClassID(ruleaction2.getPcClassIDNbr());
                action1.setPostCondFieldID(ruleaction2.getPcFieldIDNbr());
                action1.setPostCondVal(ruleaction2.getPcValue());
                rule.addAction(action1);
                action1 = new Action();
            }

            vector.add(rule);
            Rule rule1 = (Rule)vector.elementAt(0);
            Condition condition1 = (Condition)rule1.getConditions().elementAt(0);
            String s1 = condition1.getSetName();
            Vector vector1 = null;
            vector1 = new Vector();
            for(int j = 0; j < vector.size(); j++)
            {
                Rule rule3 = (Rule)vector.elementAt(j);
                Condition condition3 = (Condition)rule3.getConditions().elementAt(0);
                String s2 = condition3.getSetName();
                if(s2.compareTo(s1) != 0)
                {
                    hashtable.put(s1, vector1);
                    vector1 = new Vector();
                    Rule rule2 = (Rule)vector.elementAt(j);
                    Condition condition2 = (Condition)rule2.getConditions().elementAt(0);
                    s1 = condition2.getSetName();
                }
                Rule rule4 = (Rule)vector.elementAt(j);
                vector1.add(rule4);
            }

            hashtable.put(s1, vector1);
        }
        catch(Exception exception)
        {
            trace.trace(4, "0500", "RuleLookupImpl.loadRules", "Exception: " + exception + "\nContinue with old previous rule sets");
            exception.printStackTrace();
            datamanagerimpl.closeConnection();
            throw exception;
        }
        datamanagerimpl.closeConnection();
        theRuleSets = hashtable;
        printTimingMessage("loadRules: Total time", date);
        return true;
    }

    public boolean loadBusinessActions()
    {
        Date date = new Date();
        Hashtable hashtable = new Hashtable();
        printMessage("Start loadBusinessActions");
        try
        {
            DataManagerImpl datamanagerimpl = new DataManagerImpl();
            for(BusinessActionEntry businessactionentry = datamanagerimpl.fetchBusinessActionEntry(); businessactionentry != null; businessactionentry = datamanagerimpl.fetchNextBusinessActionEntry())
                hashtable.put(new Integer(businessactionentry.getActionID()), businessactionentry);

            datamanagerimpl.closeConnection();
        }
        catch(Exception exception)
        {
            trace.trace(4, "Exception in loadBusinessActions: " + exception + " continue to use old actions");
            exception.printStackTrace();
            return false;
        }
        businessActions = hashtable;
        printTimingMessage("loadBusinessActions: Total time", date);
        return true;
    }

    public boolean loadActionMethods()
    {
        Hashtable hashtable = new Hashtable();
        char c = '\uD8F1';
        Hashtable hashtable1 = new Hashtable();
        trace.trace(16, "STARTING RuleLookupImpl.loadActionMethods()");
        try
        {
            DataManagerImpl datamanagerimpl = new DataManagerImpl();
            ActionMethod actionmethod = datamanagerimpl.fetchActionMethod();
            int i = actionmethod.getClassID();
            for(; actionmethod != null; actionmethod = datamanagerimpl.fetchNextActionMethod())
            {
                if(i != actionmethod.getClassID())
                {
                    hashtable.put(new Integer(i), hashtable1);
                    hashtable1 = new Hashtable();
                    i = actionmethod.getClassID();
                }
                hashtable1.put(new Integer(actionmethod.getMethodID()), actionmethod);
            }

            datamanagerimpl.closeConnection();
            hashtable.put(new Integer(i), hashtable1);
        }
        catch(Exception exception)
        {
            trace.trace(4, "Exception in RuleLookupImpl.loadActionMethods: " + exception + " continue to use old actions");
            exception.printStackTrace();
            return false;
        }
        actionMethods = hashtable;
        return true;
    }

    void printTimingMessage(String s, Date date)
    {
        long l = 0L;
        if(printDiagnostics)
        {
            Date date1 = new Date();
            long l1 = date1.getTime() - date.getTime();
            printMessage(s + "@ " + l1 + " ms");
        }
    }

    void printMessage(String s)
    {
        if(printDiagnostics)
            System.out.println("(" + beanHashCode + ") -> " + s);
    }

    private static void setLookupPrintDiagnostics(boolean flag)
    {
        printDiagnostics = flag;
    }

    public void setTraceLevel(int i)
    {
        Trace _tmp = trace;
        Trace.setTraceLevel(i);
    }

    public void setPrintDiagnostics(boolean flag)
    {
        trace.trace(16, "RuleLookupImpl.setPrintDiagnostics(" + flag + ")");
        RuleProcessorImpl.setPrintDiagnostics(flag);
    }

    public static final String whatVersion = "@(#) $RCSfile: RuleLookupImpl.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:23 $\n";
    Date ruleTimeStamp;
    Date actionTimeStamp;
    Date methodTimeStamp;
    protected Hashtable theRuleSets;
    protected Hashtable businessActions;
    protected Hashtable actionMethods;
    protected int beanHashCode;
    private static boolean printDiagnostics = true;
    private Trace trace;

}
