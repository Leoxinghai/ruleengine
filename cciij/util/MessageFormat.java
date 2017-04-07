package cciij.util;

import java.util.*;

import cciij.businessActions.Messages;

public class MessageFormat extends Messages
{
    private int mi_currentLanguage;

    private static final String m_spaces="                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ";

    public MessageFormat()
    {
        init(1);
    }

    public MessageFormat(int ai_language)
    {
        init(ai_language);
    }

    private void init(int ai_language)
    {
        setLanguage(ai_language);

        return;
    }

    public boolean setLanguage(int ai_language)
    {
        if((ai_language <= 0)
           || ((ai_language > SM_NUMBER_OF_LANGUAGES_ERRORMESSAGE)
               && (ai_language > SM_NUMBER_OF_LANGUAGES_PROMPTMESSAGE)
               && (ai_language > SM_NUMBER_OF_LANGUAGES_LOGMESSAGE)
               && (ai_language > SM_NUMBER_OF_LANGUAGES_TRACEMESSAGE)
               )
           )
        {
            return false;
        }

        mi_currentLanguage = ai_language;

        return true;
    }

    public int getLanguage()
    {
        return mi_currentLanguage;
    }

    /**
     * Get an array populated with all of the Error ID codes
     */
    public String[] getErrorIDs()
    {
      String[] sTemp = new String[ErrorMessage.length - 1]; // skip end sentinal

      for ( int x = 0; x < sTemp.length; x++ )
      {
        sTemp[x] = ErrorMessage[x][0];
      }

      return sTemp;
    }

    /**
     * Get the specific String representation of the error code passed
     */
    public String getErrorID(int ai_msgCode)
    {
      if (( ai_msgCode < 0 ) || ( ai_msgCode > ErrorMessage.length ))
      {
        return "";  // invalid index passed
      }

      return ErrorMessage[ai_msgCode][0];
    }

    public String errorMessage(int ai_msgCode)
    {
      try
      {
        return errorMessage(ai_msgCode,mi_currentLanguage);
      }
      catch (ArrayIndexOutOfBoundsException aiobe)
      {
        aiobe.printStackTrace();
        return "Error message array index is out of bounds";
      }
    }

    public static String errorMessage(int ai_msgCode,int ai_langCode)
    {
        if((ai_msgCode < 0)
           || (ai_msgCode > ErrorMessage.length)
           || (ai_langCode <= 0)
           || (ai_langCode > SM_NUMBER_OF_LANGUAGES_ERRORMESSAGE) )
        {
                return null;
        }

        try
        {
          return ErrorMessage[ai_msgCode][ai_langCode];
        }
        catch (ArrayIndexOutOfBoundsException aiobe)
        {
          aiobe.printStackTrace();
          return "Error message array index is out of bounds";
        }
    }

    public String promptMessage(int ai_msgCode)
    {
      try
      {
        return promptMessage(ai_msgCode,mi_currentLanguage);
      }
      catch (ArrayIndexOutOfBoundsException aiobe)
      {
        aiobe.printStackTrace();
        return "Prompt message array index is out of bounds";
      }
    }

    public static String promptMessage(int ai_msgCode,int ai_langCode)
    {
        if((ai_msgCode < 0)
           || (ai_msgCode > PromptMessage.length)
           || (ai_langCode <= 0)
           || (ai_langCode > SM_NUMBER_OF_LANGUAGES_PROMPTMESSAGE)  )
        {
                return null;
        }

        try
        {
          return PromptMessage[ai_msgCode][ai_langCode];
        }
        catch(ArrayIndexOutOfBoundsException aiobe)
        {
          aiobe.printStackTrace();
          return "Prompt message array index is out of bounds";
        }
    }

    public String logMessage(int ai_msgCode)
    {
      try
      {
        return logMessage(ai_msgCode,mi_currentLanguage);
      }
      catch (ArrayIndexOutOfBoundsException aiobe)
      {
        aiobe.printStackTrace();
        return "log message array index is out of bounds";
      }
    }

    public static String logMessage(int ai_msgCode,int ai_langCode)
    {
        if((ai_msgCode < 0)
           || (ai_msgCode > LogMessage.length)
           || (ai_langCode <= 0)
           || (ai_langCode > SM_NUMBER_OF_LANGUAGES_LOGMESSAGE)  )
        {
                return null;
        }
        try
        {
          return LogMessage[ai_msgCode][ai_langCode];
        }
        catch (ArrayIndexOutOfBoundsException aiobe)
        {
          aiobe.printStackTrace();
          return "log message array index is out of bounds";
        }
    }

    public String traceMessage(int ai_msgCode)
    {
      try
      {
        return traceMessage(ai_msgCode,mi_currentLanguage);
      }
      catch (ArrayIndexOutOfBoundsException aiobe)
      {
        aiobe.printStackTrace();
        return "trace message array index is out of bounds";
      }

    }

    public static String traceMessage(int ai_msgCode,int ai_langCode)
    {
        if((ai_msgCode < 0)
           || (ai_msgCode > TraceMessage.length)
           || (ai_langCode <= 0)
           || (ai_langCode > SM_NUMBER_OF_LANGUAGES_TRACEMESSAGE)  )
        {
                return null;
        }

        try
        {
          return TraceMessage[ai_msgCode][ai_langCode];
        }
        catch (ArrayIndexOutOfBoundsException aiobe)
        {
          aiobe.printStackTrace();
          return "trace message array index is out of bounds";
        }
    }


    public static int getErrorCode(String as_msgName)
    {
        int i;

        for(i=0;i<ErrorMessage.length;i++)
        {
            if(as_msgName == ErrorMessage[i][0])
            {
                return i;
            }
        }

        return -1;
    }

    public static int getPromptCode(String as_msgName)
    {
        int i;

        for(i=0;i<PromptMessage.length;i++)
        {
            if(as_msgName == PromptMessage[i][0])
            {
                return i;
            }
        }

        return -1;
    }

    public static int getLogCode(String as_msgName)
    {
        int i;

        for(i=0;i<LogMessage.length;i++)
        {
            if(as_msgName == LogMessage[i][0])
            {
                return i;
            }
        }

        return -1;
    }

    public static int getTraceCode(String as_msgName)
    {
        int i;

        for(i=0;i<TraceMessage.length;i++)
        {
            if(as_msgName == TraceMessage[i][0])
            {
                return i;
            }
        }

        return -1;
    }

    public String formatLogMessage(int ai_logCode,List a_params)
    {
	return buildMessage(logMessage(ai_logCode),a_params);
    }

    public String formatTraceMessage(int ai_logCode,List a_params)
    {
	return buildMessage(traceMessage(ai_logCode),a_params);
    }

    public String formatErrorMessage(int ai_logCode,List a_params)
    {
	return buildMessage(errorMessage(ai_logCode),a_params);
    }

    public String formatPromptMessage(int ai_logCode,List a_params)
    {
	return buildMessage(promptMessage(ai_logCode),a_params);
    }

    private String buildMessage(String as_format,List a_params)
    {
	String l_retMsg = "";

	int i=0;
	int j;
	int k=0;
	int l=a_params.size();
	int m;
	int l_spaceCount=0;
	String l_str;

	//	System.out.println("BuildMessage format:  " + as_format);

	if((as_format == null) || (a_params == null))
	{
	    return "";
	}

	while((j = as_format.indexOf("%",i)) >= 0)
	{
	    l_retMsg += as_format.substring(i,j);

	    if((m = as_format.indexOf("s",j)) < 0)
	    {
		break;
	    }

	    if(m == j + 1)
	    {
		l_spaceCount = 0;
	    }
	    else
	    {
		l_spaceCount = Integer.parseInt(as_format.substring(j+1,m));
	    }

	    //	    System.out.println("l_spaceCount == " + l_spaceCount);

	    if(k <= l)
	    {
		try
		{
		    l_str = (String)a_params.get(k);

		    if((l_spaceCount > 0) && (l_spaceCount > l_str.length()))
		    {
			l_retMsg += m_spaces.substring(0,l_spaceCount - l_str.length());
		    }

		    l_retMsg += l_str;

		    if(l_spaceCount < 0)
		    {
			l_spaceCount = 0 - l_spaceCount;

			if(l_spaceCount > l_str.length())
			{
			    l_retMsg += m_spaces.substring(0,l_spaceCount - l_str.length());
			}
		    }

		    k++;

		    //		    System.out.println("Current Line:  |" + l_retMsg + "|");
		}
		catch(IndexOutOfBoundsException e)
		{
		    //		    System.out.println("Caught a IndexOutOfBoundsException:  " + e);
		    k = l + 1; // make it stop trying
		}
	    }

	    i = m + 1;
	}

	l_retMsg += as_format.substring(i);

	//	System.out.println("Returning:  " + l_retMsg);

	return l_retMsg;
    }

    public static void main(String[] args)
    {
        MessageFormat mf = new MessageFormat(1);
        int msgCode;

        try
        {
            msgCode = mf.getErrorCode("EM_EJB_EXECUTE");

            System.out.println("Error Message " + msgCode + " == " + mf.errorMessage(msgCode) + "," + mf.errorMessage(msgCode,2));
        }
        catch(Exception e)
        {
            System.out.println("Caught:  " + e);
        }

    }
}
