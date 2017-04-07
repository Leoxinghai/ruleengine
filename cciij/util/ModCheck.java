//*************************************************************************
//
// Filename: ModCheck.java
//
// Description:  implementation of the java ModCheck Class
//
// Revision History:
//
//      THE FOLLOWING VARIABLES ARE FILLED-IN BY RCS.
//
//      $Source: /home/cvsroot/fedexccii/src/cciij/util/ModCheck.java,v $
//      $Revision: 1.1 $
//      $Date: 2006/06/26 07:26:20 $
//
// Modification History:
//
//   08/05/01  Gary Rockwood  Initial Creation
//
//*************************************************************************

package cciij.util;

import java.io.*;

public class ModCheck
{
	// The class does not have to be instantiated because all methods are static
    public ModCheck()
    {
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  computeCheckDigit returns computed CheckDigit from the airbill argument    //
    //                                                                             //
    //  The first argument 's_airbill' is the airbill passed as a string.          //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    public static int computeCheckDigit(String s_airbill)
    {
        int     i_returnCheckDigit = 0;
        int     i_loop;
        String  s_localAirbill;

        // Move s_airbill into s_localAirbill, so it can be modified if needed
        s_localAirbill = s_airbill;

		// There is a minimum length, so check this first
		if (s_localAirbill.length() < 8)
		{
			// This is not a valid Fedex Airbill
			return -1;
		}

        // Check for the 4th position set to '-'
        if (s_localAirbill.charAt(3) == '-')
        {
            // Remove the 4th character
            s_localAirbill = s_airbill.substring(0,3);
            s_localAirbill += s_airbill.substring(4,s_airbill.length());
        }

        // Make sure that all characters are digit
        for (i_loop=0; i_loop< s_localAirbill.length(); i_loop++)
        {
            if (!Character.isDigit(s_localAirbill.charAt(i_loop)) )
            {
                return -1;
            }
        }

        // The actual mod check to be used depends on the length of the airbill
        switch (s_localAirbill.length())
        {
            case 32:                // ASTRA label
                i_returnCheckDigit = AstraModCheck(s_localAirbill);
                break;

            case 12:                // NTN without form type
            case 16:                // NTN with form type
                i_returnCheckDigit = NTNModCheck(s_localAirbill);
                break;

            default:
                // Its probably an older airbills
                // Make sure the length is at least 8 characters, all digits
                if (s_localAirbill.length() < 8)
                {
                    i_returnCheckDigit = -1;
                }
                else
                {
                    // Perform the MOD7DR or MOD7DSR ModCheck
                    i_returnCheckDigit = TrackModCheck(s_localAirbill);

					// Check if the DSR checkdigit needs to be computed
        			if (i_returnCheckDigit >= 0 && 
						i_returnCheckDigit != (s_localAirbill.charAt(s_localAirbill.length()-1) - '0'))
					{
                        // Compute the MOD7DSR check digit
                        i_returnCheckDigit =  (7 - i_returnCheckDigit);
                    }
                 }
        }

        return i_returnCheckDigit;
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  'TrackModCheck' creates MOD7DR check digit (Used on older Fedex Airbills)  //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    private static int TrackModCheck(String s_localAirbill)
    {
        int[]   ab_wt = {1, 3, 2, 6, 4, 5};        // Weights
        int     i_divisor = 7;
        int     i_stop = 0;
        String  s_airbillPrefix;

        // Check for the special prefixed airbills, they are all 11 digits long
        if (s_localAirbill.length() == 11)
        {
            // Extract the prefix and check if it is in this list
            s_airbillPrefix = s_localAirbill.substring(0, 3);
            if (s_airbillPrefix.equals("400") ||
                s_airbillPrefix.equals("023") ||
                s_airbillPrefix.equals("100") ||
                s_airbillPrefix.equals("101") ||
                s_airbillPrefix.equals("500") ||
                s_airbillPrefix.equals("300") ||
                s_airbillPrefix.equals("320") )
            {
                i_stop = 3;
            }
        }

        // Call the general Check Digit routine
        return GenCkDig( s_localAirbill, ab_wt, i_divisor, i_stop, s_localAirbill.length()-1);
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  'AstraModCheck' creates the ModCheck on an ASTRA airbill (32 digits)       //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    private static int AstraModCheck(String s_localAirbill)
    {
        int[]   ab_wt = {1, 3, 7};              // Weights
        int     i_divisor = 10;

        return GenCkDig( s_localAirbill, ab_wt, i_divisor, 0, s_localAirbill.length()-1);
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  'NTNModCheck' creates the ModCheck on the NTN tracking Number (11 digits)  //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    private static int NTNModCheck(String s_localAirbill)
    {
        int[]   ab_wt = {1, 3, 7};               // Weights
        int     i_divisor = 11;

        return (GenCkDig( s_localAirbill, ab_wt, i_divisor, 0, 11 ) % 10);
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  'GenCkDig' creates actual Check Digit based on weighted parameter string   //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    private static int GenCkDig( String s_localAirbill,        // Airbill to compute check digit against
                          int ab_wt[],                  // Weights to use in Check Digit, first value is count
                          int i_divisor,                // Divisor for final mod check
                          int i_stop,                   // Character where check routine stops
                          int i_length)                 // Length of Airbill to check
    {
        int     i_sum = 0;          // Accumulated weighted sum
        int     i_loop;             // Loop index
        int     i_weightIndex = -1; // Weight index

        // Loop thru each digit of airbill and compute weighted sum
        for (i_loop=i_length-1; i_loop>=i_stop; i_loop--)
        {
            // Check if at the end of the weight array, then reset
            i_weightIndex = (i_weightIndex == ab_wt.length-1) ? 0 : i_weightIndex+1;

            i_sum += ab_wt[i_weightIndex] * (s_localAirbill.charAt(i_loop) - '0'); 
        }

        return (i_sum % i_divisor);
    }


    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  'checkDigitTest' will perform ModCheck on Airbill passed as parameter      //
    //                                                                             //
    //  Returns 'true' if the check digit is correct,                              //
    //          'false' if the check digit is NOT correct                          //
    //                                                                             //
    /////////////////////////////////////////////////////////////////////////////////
    public static boolean checkDigitTest(String s_airbill)
    {
        int     i_checkDigit = 0;


        // Perform the Check Digit on the passed airbill, initially with DSR 7 turned off
        i_checkDigit = computeCheckDigit(s_airbill);

        // If the returned value is < 0 (-1), there was some kind of an error
        if (i_checkDigit < 0)
        {
            // Return failure
            return false;
        }
        else
        {
            // Now check if the Check Digit returned matches the last digit of the airbill
            if (i_checkDigit == (s_airbill.charAt(s_airbill.length()-1) - '0')) 
            {
                // The check digit matched, return success
                return true;
            }
            else
            {
                // The check digit failed to match, return failure
                return false;
            }
        }
    }
 

    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //  Main Routine used for testing                                              //
    //                                                                             //
    ///////////////////////////////////////////////////////////////////////////////// 
    public static void main(String[] args)
    {
        int     i_checkDigit = 0;
//      String  s_airbill = "789398789016";                             // NTN airbill
//      String  s_airbill = "14770141081520001803430812990016";         // ASTRA airbill
        String  s_airbill = "8510119554";                               // Old Fedex airbill
//      String  s_airbill = "400-22222222";                             // Old Fedex airbill with imbedded dash
//		String  s_airbill = "123";										// Invalid Legeht airbill

        try
        {
            // Retrieve the computed Check Digit
            i_checkDigit = computeCheckDigit(s_airbill);

            // Display results
            System.out.println("(DR)  ModCheck for " + s_airbill + " is " + i_checkDigit);

			// Use the method which will be used by others
            if (checkDigitTest(s_airbill))
            {
                System.out.println("ModCheck passed");
            }
            else
            {
                System.out.println("ModCheck failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Caught an Exception in main():");
            System.out.println("Exception:  " + e.toString());
            System.out.println("Message:    " + e.getMessage());
            e.printStackTrace();
        }
    }
}


