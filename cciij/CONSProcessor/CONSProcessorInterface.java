/*
 * Created on Oct 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cciij.CONSProcessor;

import cciij.cciidata.CCIIState;

public interface CONSProcessorInterface
{

    public abstract CCIIState processCONS(CCIIState cciistate)
        throws Exception;
}
