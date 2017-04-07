//Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://www.geocities.com/kpdus/jad.html
//Decompiler options: packimports(3) 
//Source File Name:   RuleProcessorImpl.java

package com.fedex.css.ruleprocessor.ejb;

import com.fedex.css.ruleprocessor.*;
import com.fedex.css.util.Trace;
import java.io.PrintStream;
import java.util.*;

import org.apache.log4j.Logger;

public class RuleProcessorImpl
 implements RuleProcessorInterface
{

 static void printMessage(String s)
 {
     if(printDiagnostics)
         System.out.println(s);
 }

 public RuleProcessorImpl()
 {
     stateChanged = false;
     ruleSets = null;
     baFactory = null;
     rulesLoaded = false;
     vectorProcessing = false;
     ruleLookup = null;
     currentRuleSetTimeStamp = new Date(0L);
 }

 public RuleProcessorImpl(int i)
 {
     stateChanged = false;
     ruleSets = null;
     baFactory = null;
     rulesLoaded = false;
     vectorProcessing = false;
     ruleLookup = null;
     currentRuleSetTimeStamp = new Date(0L);
     initialize();
 }

 protected void initialize()
 {
     try
     {
         System.out.println("RULEPROCESSOR COPYRIGHT (C) 2000-2003 FEDERAL EXPRESS CORP. ALL RIGHTS RESERVED");
         ruleSets = new Hashtable();
         baFactory = new BusinessActionFactory();
         Trace.trace(16, "RuleProcessorImpl.initialize");
     }
     catch(Exception exception)
     {
         Trace.trace(4, "Exception int RuleProcessorImp.initialize: " + exception);
         exception.printStackTrace();
     }
 }

 public State executeRules(Vector vector)
 {
     vectorProcessing = true;
     State state = null;
     boolean flag = false;
     
     try
     {
         loadRules();
         for(int i = 0; i < vector.size(); i++)
         {
             state = executeRuleSets((State)vector.elementAt(i));
             if(state.getStatusCd() >= 0 && !state.getAbortFlag())
                 continue;
             flag = true;
             break;
         }

         if(!flag)
             commit();
     }
     finally
     {
         vectorProcessing = false;
     }
     return state;
 }

 public State executeRules(State state)
 {
 	 logger.debug("executeRules.state."+state.getRuleSetName());
     loadRules();
     state =executeRuleSets(state);
	 logger.debug("["+Runtime.getRuntime().freeMemory()+"] free bytes of ["+Runtime.getRuntime().totalMemory()+"] bytes!");
	 logger.debug("["+Runtime.getRuntime().availableProcessors() +"].available.processor.");
     
  	 logger.debug("end of executeRules");
     return state;
 }

 protected State executeRuleSets(State state)
 {
     Date date = new Date();
     Date date1 = null;
     long l = 0L;
     boolean flag = false;
     boolean flag1 = false;
     boolean flag2 = false;
     printMessage("Start ExecuteRuleSets");
     try
     {
         if(!ruleSets.containsKey(state.getRuleSetName()))
         {
             Trace.trace(4, "0300", "RuleProcessorImpl.executeRuleSets", "No rules for set " + state.getRuleSetName());
             state.setStatusCd(-1);
             date1 = new Date();
             l = date1.getTime() - date.getTime();
             printMessage("ExecuteRule took " + l + " ms");
             rollBack();
             return state;
         }
         Trace.trace(16, "Found rule set: " + state.getRuleSetName());
         Vector vector = (Vector)ruleSets.get(state.getRuleSetName());
         for(int i = 0; i < vector.size(); i++)
         {
             Rule rule = (Rule)vector.elementAt(i);
             logger.debug("rule.match.;"+rule.match(state));
             if(rule.match(state))
             {
                 printMessage("RULE MATCHED");
                 Vector vector1 = rule.getActions();
                 for(int j = 0; j < vector1.size(); j++)
                 {
                     Action action = (Action)vector1.elementAt(j);
                     if(action.getClassID() == -1)
                     {
                         flag2 = true;
                         break;
                     }
                     String s = state.getRuleSetName();
                     executeAction(action, state);
                     if(state.getAbortFlag())
                     {
                         flag1 = true;
                         break;
                     }
                     if(state.getStatusCd() < 0)
                     {
                         flag2 = true;
                         break;
                     }
                     if(s.compareTo(state.getRuleSetName()) == 0)
                         continue;
                     printMessage("RULE SET CHANGE");
                     flag = true;
                     break;
                 }

             }
             if(flag1 || flag2 || flag)
                 break;
         }

     }
     catch(Exception exception)
     {
         Trace.trace(4, "0400", "ruleProcessorImpl.executeRuleSets", "Exception: " + exception);
         exception.printStackTrace();
         state.setStatusCd(-1);
         flag1 = true;
     }
     if(flag1)
     {
         ;//rollBack();
     } else
     {
         if(flag)
             return executeRuleSets(state);
         if(!vectorProcessing)
             commit();
     }
     date1 = new Date();
     l = date1.getTime() - date.getTime();
     printMessage("ExecuteRule took " + l + " ms");
     logger.debug("END of executeRuleSets");
     return state;
 }

 private void executeAction(Action action, State state)
 {
     try
     {
         Date date = new Date();
         if(action.getClassID() == 0)
         {
		     logger.debug("Post Condition:");
             printMessage("POST CONDITION SET CLASS " + action.getPostCondClassID() + " FIELD " + action.getPostCondFieldID() + " TO " + action.getPostCondVal());
             state.set(action.getPostCondClassID(), action.getPostCondFieldID(), action.getPostCondVal());
         } else
         if(action.getClassID() == -2)
         {
             String s = new String(state.getRuleSetName());
             logger.debug("RULESET:"+ s);
             state.setRuleSetName(action.getPostCondVal());
             executeRuleSets(state);
             state.setRuleSetName(s);
             logger.debug("RuleSet End.");
         } else
         {
             BusinessAction businessaction = baFactory.getAction(action.getClassID());
             logger.debug("  "+businessaction.getClass()+";"+((cciij.cciidata.CCIIState)state).getScan().getErrorNumber());
             state = businessaction.actionEntry(state, action.getMethodID());
             logger.debug("  doIt End.");
         }
         Date date1 = new Date();
         long l = date1.getTime() - date.getTime();
         printMessage("ACTION " + action.getMethodID() + " took " + l + "ms");
     }
     catch(Exception exception)
     {
         Trace.trace(4, "0410", "ruleProcessorImpl.executeAction", "Exception: " + exception);
         exception.printStackTrace();
         state.setStatusCd(-1);
     }
 }

 protected void loadRules()
 {
     try
     {
         Trace.trace(16, "LOADRULES");
         RuleLookupContainer rulelookupcontainer = ruleLookup.getRules(currentRuleSetTimeStamp);
         if(rulelookupcontainer != null)
         {
             ruleSets = rulelookupcontainer.getData();
             currentRuleSetTimeStamp = rulelookupcontainer.getTimeStamp();
             Trace.trace(16, "RULE SETS UPDATED");
         } else
         {
             Trace.trace(16, "RULE SETS UNCHANGED");
         }
     }
     catch(Exception exception)
     {
         Trace.trace(4, "ruleProcessorImpl.loadRules: " + exception);
         exception.printStackTrace();
     }
 }

 protected void rollBack()
 {
     try
     {
         setRollback();
     }
     catch(Exception exception)
     {
         Trace.trace(4, "1400", "ruleProcessorImpl.rollBack", "Exception:" + exception);
         exception.printStackTrace();
     }
 }

 protected void commit()
 {
 }

 protected void setRollback()
 {
     Trace.trace(8, "RuleProcessorImpl.setRollback()");
 }

 public static void setPrintDiagnostics(boolean flag)
 {
     printDiagnostics = flag;
 }

 protected boolean stateChanged;
 protected Hashtable ruleSets;
 protected BusinessActionFactory baFactory;
 protected boolean rulesLoaded;
 protected boolean vectorProcessing;
 private static boolean printDiagnostics = true;
 protected RuleLookupInterface ruleLookup;
 protected Date currentRuleSetTimeStamp;
 protected static final int POST_CONDITION = 0;
 protected static final int QUICK_EXIT = -1;
 protected static final int CALL_RULE_SET = -2;
 private Logger logger = Logger.getLogger(RuleProcessorImpl.class);

}
