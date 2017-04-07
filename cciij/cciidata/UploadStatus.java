package cciij.cciidata;

/**
 * Title:        UploadStatus
 * Description:
 * Copyright:    Copyright (c) 2003
 * Company:      FedEx
 * @author
 * @version 1.0
 *  *
 * Modification history:
 * 3/13/2003    Tom Knobeloch  added over-ride methods for setDocFlag(),
 *                             setNonDocFlag(),setFedExShuttleFlag(), and
 *                             setODAShuttleFlag()
 */
 
public class UploadStatus extends UploadStatusBase
{
    public void setFedExShuttleFlag(boolean setValue)
    {
        super.setFedExShuttleFlag(setValue);
        super.setODAShuttleFlag(!setValue);
    }
    
    public void setODAShuttleFlag(boolean setValue)
    {
        super.setODAShuttleFlag(setValue);
        super.setFedExShuttleFlag(!setValue);
    }
}
