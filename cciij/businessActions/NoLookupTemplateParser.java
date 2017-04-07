package cciij.businessActions;

/**
 * Title:         NoLookupTemplateParser.java
 * Description:   Function to build return a key which the Template Parser can 
 *                use for it's template lookups.
 * Copyright:     Copyright (c) 2001
 * Company:       FedEx Services
 * @author        Kathy Smathers
 * @version 1.0
 *
 *
 * @return       cciij.cciidata.CCIIState updated state object.
 *
 *
 * Pre-conditions:
 *
 * Modification History:
 * 03/10/2004    Kathy Smathers Created
 *
 */

import cciij.cciidata.*;
import cciij.util.*;
import java.util.*;
import java.lang.reflect.*;

public class NoLookupTemplateParser implements rmtc.util.KeyTranslationInterface
{
    private static final String m_whatVersion = "@(#) $RCSfile: NoLookupTemplateParser.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:01 $\n";


    public String translateKey(String key)
    {
	return key;
    }
    public String translateKey(String key, String locationCd)
    {
	return key;
    }
}
