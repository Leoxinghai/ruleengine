package cciij.businessActions;

import cciij.cciidata.*;
import cciij.cciidatabase.*;
import java.util.Date;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 * <br>
 * <br>
 * Modification History:<br>
 *   <UL>
 *     <LI>Date: 2004/12/10
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Correct the call to update the intransit row in the deActivateIntransitRow method.
 *         </UL>
 *       </UL>
 *     <LI>Date: 2004/12/06
 *       <UL>
 *         <LI>By: Joey Cline
 *         <LI>Modifications:<BR>
 *         <UL>
 *            <LI>Move the call to deActivateIntransitRow into checkEntryDefinition from generateEntryNumber
 *                since we do not go into generateEntryNumber every time that we need to call deActivateIntransitRow.
 *            <LI>Increased criteria around the saving of the row to the Entry table to only happen when the 
 *                entry number in the Entry Type Def table is empty.  Although this change does cause some
 *                cases to fall further into the code (since the row will no longer be in the Entry table),
 *                this is good, since we need some of the subsequent logic executed.
 *         </UL>
 *       </UL>
 *   </UL>
 *
 */

public class FindEntryTypeCode extends BusinessActionBase {

    private String clearanceFetchCode = "";
    private String intransitFetchCode = "";

    public FindEntryTypeCode() throws Exception
    {
        super("FindEntryTypeCode");
        traceLog("FindEntryTypeCode","In Constructor");
        clearanceFetchCode = m_config.getString("FINDENTRYTYPE_CLEARANCE_FETCH_CODE");
        intransitFetchCode = m_config.getString("FINDENTRYTYPE_INTRANSIT_FETCH_CODE");
    }

    protected void readSiteConfigVariables () throws Exception
    {
        super.readSiteConfigVariables();
    }

    /**
     *
     * @param s
     * @param db
     * @return
     * @throws java.lang.Exception
     */
    public CCIIState doIt(CCIIState s, DatabaseBean db) throws java.lang.Exception
    {
        System.out.println("FindEntryTypecode.doIt()");
        // check to ensure entryTypeCode and routeLegOid are available
        if ( s.getScan().getEntryType() == null
             || s.getScan().getEntryType().length() == 0
             || s.getRouteLegInfo() == null
             || s.getRouteLegInfo().getRouteLegOidNumber() == 0 )
        {
            traceLog("FindEntryTypeCode.doIt()", " failed validation, returning error");
            s.getScan().setErrorNumber( Messages.EM_INVALID_ENTRY_TYP);
            return s;
        }


        System.out.println("FindEntryTypeCode.doIt()"+ " lookup the entryTypeCode");
        System.out.println("FindEntryTypeCode.doIt()"+ " entryType:: " + s.getScan().getEntryType());
        System.out.println("FindEntryTypeCode.doIt()"+ " routeLegOid:: " + s.getRouteLegInfo().getRouteLegOidNumber() );
        traceLog("FindEntryTypeCode.doIt()", " lookup the entryTypeCode");
        traceLog("FindEntryTypeCode.doIt()", " entryType:: " + s.getScan().getEntryType());
        traceLog("FindEntryTypeCode.doIt()", " routeLegOid:: " + s.getRouteLegInfo().getRouteLegOidNumber() );
        // call fetchEntry
        //   if returns null,  need to possibly generate and save the entryType data

        Entry entry = null;

        try
        {
            entry = db.fetchEntry(s.getScan().getEntryType(),
                                  s.getRouteLegInfo().getRouteLegOidNumber());

            System.out.println("Returned Entry Row:  " + entry);
        }
        catch ( Exception ex )
        {
            traceLog("FindEntryTypeCode.doIt()","caught exception fetching entry:: " + ex );
            ex.printStackTrace();
            s.getScan().setErrorNumber(Messages.EM_DB_ERROR);
            return s;
        }

        if ( entry != null )
        {
            System.out.println("Using EntryNbr from Entry Object:  " + entry.getEntryNbr());
            traceLog("FindEntryTypeCode.doIt()", " fetch returned entry:: " + entry);
            s.getScan().setEntryNumber( entry.getEntryNbr() );
        }
        else
        {
            traceLog("FindEntryTypeCode.doIt()", " fetch returned NULL ");
            //  Look at EntryDef and determine if a number should be created
            //
            checkEntryDefinition( s, db );

        }


        return s;
    }

    public void traceLog(String where,String what)
    {
        System.out.println("" + new Date() + ":  " + where + ":  " + what);
    }

    /**
     *
     * @param state
     * @param db
     */
    protected void checkEntryDefinition(CCIIState state, DatabaseBean db )
    {
        System.out.println("FETC.checkEntryDefinition()");
        EntryTypeDefinition etd = null;
        try
        {
            etd = db.fetchEntryTypeDef(state.getScan().getEntryType());
            System.out.println("Got an EntryTypeDefinition of:  " + etd);
        }
        catch (Exception ex)
        {
            traceLog("FindEntryTypeCode.checkEntryDefinition()","caught exception fetching entryDef:: " + ex );
            ex.printStackTrace();
            etd = null;
        }

        if ( etd == null ) {
            state.getScan().setErrorNumber(Messages.EM_INVALID_ENTRY_TYP);
            state.setAbortFlag(true);
            return;
        }

        traceLog("FindEntryTypeCode.checkEntryDefinition()", "Found definition, proceeding ");
        Entry entry = new Entry();
        entry.setEntryCategoryTypeCd( state.getScan().getEntryType() );
        entry.setRouteLegOidNbr( state.getRouteLegInfo().getRouteLegOidNumber() );
        entry.setBrokerFileNbr(0);

        if(etd.getCategoryTypeCode().equals("F"))
        {
            deActivateIntransitRow(state,db);
        }

        if ( etd.getEntryNbrNeededFlg().equals("Y") )
        {
            traceLog("FindEntryTypeCode.checkEntryDefinition()", "EntryNbrNeeded, proceeding ");
            boolean generateNumber = true;

            // first check entry_nbr if its there, use it, don't ask just use it
            if ( etd.getEntryNumber() != null
                 && etd.getEntryNumber().length() > 0 )
            {
                traceLog("FindEntryTypeCode.checkEntryDefinition()", "Found always use value, proceeding ");
                entry.setEntryNbr( etd.getEntryNumber() );
                state.getScan().setEntryNumber(etd.getEntryNumber());
                generateNumber = false;
            }

            //  gotta generate one

            if ( generateNumber )
            {
                if ( generateEntryNumber( state, etd, db ) )
                {
                    traceLog("FindEntryTypeCode.checkEntryDefinition()", "Using generatedEntryNumber, proceeding ");
                    entry.setEntryNbr( state.getScan().getEntryNumber() );
                }
                else
                {
                    return;
                }
            }
        }
        else
        {  //  save an entry record with type and routeLegOid only
            entry.setEntryNbr("");
        }

        // if multiple entry flag == Y then save it else every shipment gets a unique nbr
        if (  ( etd.getMultipleEntryFlg().equals("Y")  )
	   && ( ( etd.getEntryNumber() == null ) || ( etd.getEntryNumber().trim().length() == 0 ) ) )
        {
            try {
                db.saveEntry(entry);
            }
            catch (Exception ex) {
                traceLog("FindEntryTypeCode.checkEntryDefinition()",
                         "caught exception saving entry:: " + ex);
                ex.printStackTrace();
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                state.setAbortFlag(true);
                return;
            }
        }

        return;
    }

    protected boolean canUsePreviousCCN(CCIIState state,DatabaseBean db)
    {
        System.out.println("FETC.canUsePreviousCCN()");

        String errMsg="Unexpected Error Condition";

        try
        {
            errMsg = "trying to retrieve the previous Intransit Record";
            InTransit it = db.fetchInTransitByLocCdAndShipmentOid(state.getScan().getLocationCode(),
                                                                  state.getScan().getShipmentOid());

            if(it != null)
            {
                String oldCCN = it.getCCNNumber();
                
                if((oldCCN != null) && (oldCCN.trim().length() > 0))
                {
                    state.getScan().setEntryNumber(oldCCN.trim());
                    it.setActiveFlg("Y");
                    it.setChangedFlg("Y");
                    errMsg = "Saving Updates to the Intransit Record";
                    db.updateInTransit(it);
                    System.out.println("Returning true");
                    return true;
                }
            }

            System.out.println("Returning false");
            return false;
        }
        catch(Exception e)
        {
            traceLog("FindEntryTypeCode.canUsePreviousCCN()",
                     "Caught Exception " + errMsg + ":" + e);
            e.printStackTrace(System.out);
            
            return false;
        }
    }

    /**
     *
     * @param state
     * @param db
     * @return
     */
    protected boolean generateEntryNumber(CCIIState state, EntryTypeDefinition etd, DatabaseBean db )
    {
        String entryNbr = null;
        CustomsNumberManagement cnm = null;
        int oldLastUsedNumber = 0;
        boolean rangeAvailable = false;
        String fetchCode = "";

        if ( etd.getCategoryTypeCode().equals("I") )
        {
            fetchCode = intransitFetchCode;
            state.setIntransitFlag("Y");
	 
            if(canUsePreviousCCN(state,db))
            {
                return true;
            }
        }
        else
        {
            fetchCode = clearanceFetchCode;
        }

        // generate a number and update customs_number_mgmt table
        try
        {
            System.out.println("Fetching by CustomsNumberManagement row by:  " + fetchCode);
            cnm = db.fetchCustomsEntryTypeAndActive( fetchCode );
            System.out.println("Got:  " + cnm);
        }
        catch (Exception ex )
        {
            traceLog("FindEntryTypeCode.generateEntryNumber()",
                     "caught exception retrieving entry:: " + ex);
            ex.printStackTrace();
            return rangeAvailable;
        }

        if ( cnm == null )
        {
            traceLog("FindEntryTypeCode.generateEntryNumber()",
                     "CustomsNumberManagement record not found");
            return rangeAvailable;
        }

        if(cnm.getTypeLastUsedNbr() >= cnm.getTypeHighNbr())
        {
            cnm.setStatusCd("C");
            try
            {
                db.updateCustomsNumberManagement(cnm);
            }
            catch(Exception e)
            {
                traceLog("FindEntryTypeCode.generateEntryNumber()",
                         "caught exception updating customsNumberManagement table with a complete status; Oh Well...");
                e.printStackTrace(System.out);                
            }

            try
            {
                cnm = db.fetchNextCustomsNumberManagement();
            }
            catch(Exception e)
            {
                traceLog("FindEntryTypeCode.generateEntryNumber()",
                         "caught exception fetchNexting after completing the used up range...:  " + e);
                e.printStackTrace(System.out);
                return rangeAvailable;
            }
        }

        if ( cnm.getTypeLastUsedNbr() < cnm.getTypeHighNbr() )
        {
            // get number
            oldLastUsedNumber = cnm.getTypeLastUsedNbr();
            cnm.setTypeLastUsedNbr( oldLastUsedNumber + 1);
            cnm.setLastModifiedNm("FindEntryTypeCode");
            cnm.setLastModifiedTmstp( new Date() );
            // updateRecord
            try
            {
                db.updateCustomsNumberLastUsed( cnm, oldLastUsedNumber );
            }
            catch ( Exception ex )
            {
                traceLog("FindEntryTypeCode.generateEntryNumber()",
                         "CustomsNumberManagement updateLastUsed failed " + ex );
                ex.printStackTrace();
                state.getScan().setErrorNumber(Messages.EM_DB_ERROR);
                state.setAbortFlag(true);
                return rangeAvailable;
            }

            // filler and modulator
            String filerNbr = m_config.getValue("FILER_NBR");

            if ( etd.getCategoryTypeCode().equals("I") )
            {
                System.out.println("Calculating Intransit Check Digit for:  " + cnm.getTypeLastUsedNbr());
                entryNbr = addIntransitCheckDigit( cnm.getTypeLastUsedNbr());
                System.out.println("Got:  " + entryNbr);
            }
            else
            {
                entryNbr = addCustomsCheckDigit( new Long(filerNbr + cnm.getTypeLastUsedNbr()).longValue() ) ;
            }

            System.out.println("FETC setting entry Nbr:  " + entryNbr);
            state.getScan().setEntryNumber(entryNbr);
            rangeAvailable = true;

            if ( etd.getCategoryTypeCode().equals("I") )
            {
                insertNewIntransitRow(state,db);
            }
        }
        else
        {
            traceLog("FindEntryTypeCode.generateEntryNumber()",
                     "CustomsNumberManagement range check failed "  );
            state.getScan().setErrorNumber(Messages.EM_CHECK_LOG);
            state.setAbortFlag(true);
        }

        return  rangeAvailable;
    }

    protected void deActivateIntransitRow(CCIIState state,DatabaseBean db)
    {
        try
        {
            InTransit it = db.fetchInTransitByLocCdAndShipmentOid(state.getScan().getLocationCode(),
                                                                  state.getScan().getShipmentOid());

            if(it == null)
            {
                return;
            }

            it.setActiveFlg("N");
            it.setChangedFlg("Y");
            db.updateInTransit(it);
        }
        catch(Exception e)
        {
            traceLog("deActivateIntransitRow()","failed to fetch and update a row to inactive:  " + e);
            e.printStackTrace(System.out);
            state.getScan().setErrorNumber(Messages.EM_CHECK_LOG);
            state.setAbortFlag(true);
        }
    }

    protected void insertNewIntransitRow(CCIIState state,DatabaseBean db)
    {
        InTransit it = new InTransit(state.getScan().getLocationCode(),
                                     state.getScan().getShipmentOid(),
                                     state.getScan().getEntryNumber(),
                                     null,
                                     null,
                                     "Y",
                                     "N");

        try
        {
            traceLog("FETC.insertNewIntransitRow()","Saving new Intransit Row:  " + it);
            db.saveInTransit(it);
        }
        catch(Exception e)
        {
            traceLog("FindEntryTypeCode.insertNewIntransitRow()",
                     "Failed to save new Intransit Row: " + e  );
            e.printStackTrace(System.out);
            state.getScan().setErrorNumber(Messages.EM_CHECK_LOG);
            state.setAbortFlag(true);
          
        }            
    }


    /// THIS METHOD SHOULD BECOME A UTILITY CLASS

        public String addIntransitCheckDigit(int currentNbr)
    {
        return "" + currentNbr + (currentNbr%7);
    }

    /**
     *
     * @param entryNbrIn
     * @return
     */
    public String addCustomsCheckDigit( long entryNbrIn )
    {
        String entryNbr =  (new Long(entryNbrIn)).toString();
        int len = entryNbr.length();
        int digit = 0;
        int sum = 0;
        int product = 0;
        /* Sum the digits from right to left */
        for (int i = 1; i <= len; i++)
        {
            int position = len - i;
            String entryChar = entryNbr.substring(position, position+1);
            int entryInt = (new Integer(entryChar)).intValue();
            if (position % 2 == 0)
            {
                /* Even digits:  just sum in the value */

                sum += entryInt;
            }
            else
            {
                /* Odd digits: double the value, sum the digits of the result */
                product = (2 * entryInt);
                if (product >= 10)
                {
                    product -= 10;
                    product += 1;
                }
                sum += product;
            }
        }

        /* Create the check digit */
        digit = 10 - (sum % 10);

        /* Add one to the check digit, despite the Customs document not specifying
         * this, because that's what AJ Fritz does (so that they could
         * reuse their number range with new check digits in Oakland).
         * This is a total kludge and will probably break in the future,
         * and probably also won't work at other AMSX sites.
         */

        /* (4/17/98)  Fritz is changing method of calculating check digit
         * because they are out of the +1 entry number.  Use +2 henceforth.
         */

        digit += 2;

        if (digit >= 10)
        {
            digit -= 10;
        }

        /* Stick the check digit onto the end of the input string */
        entryNbr +=  new Long(digit).longValue();

        return entryNbr;
    }


    public void standAloneTest( )
    {
        try {
            DatabaseBean db = new DatabaseBean();
            db.connect();
            db.setLocationCode("OAK");
            CCIIState state = new CCIIState();
            state.getScan().setEntryType("EX");

            RouteLeg rl = new RouteLeg( "duh",
                                        new Date(),
                                        123,
                                        "duh",
                                        "OAK",
                                        "SIN",
                                        new Date(),
                                        new Date(),
                                        new Date(),
                                        new Date(),
                                        "US",
                                        "SIN",
                                        new Date(),
                                        "duh",
                                        "N",
                                        "N",
                                        454003);

            state.setRouteLegInfo(rl);
            doIt(state, db);
            System.out.println("scan object == " + state.getScan());
            System.out.println("mighnt have worked, if you got this message");
        }
        catch (Exception e) {
            System.out.println("standAloneTest caught an exception:  " + e);
            e.printStackTrace(System.out);
        }

    }

    public static void main(String[] args) throws Exception
    {
        FindEntryTypeCode o = new FindEntryTypeCode();
        o.standAloneTest();
    }

}
