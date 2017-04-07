package cciij.util;

/**
 * Title:        EBCDIC to ASCII Converter
 * Description:
 * Copyright:    Copyright (c) 2005
 * Company:      FedEx
 * @author Joey Cline
 * @version 1.0
 *
 * Modification history:
 *   01/05/2006  Joey Cline     Added this comment block.
 *                              Added new dumpToString method
 *                              that accepts the number of bytes
 *                              out of the byte array that should be
 *                              dumped (with length check for overrun).
 */

public class EbcdicToAscii
{

  /*************************************************
  *++
  *  EBCDIC to ASCII conversion table
  *--
  *************************************************/
  static byte etoa_table[] = {
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x7F,  /*00*/
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*10*/
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*20*/
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*30*/
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
    0x20,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*40*/
    0x00,0x00,0x00,0x2E,0x3C,0x28,0x2B,0x7C,
    0x26,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*50*/
    0x00,0x00,0x21,0x24,0x2A,0x29,0x3B,0x5E,
    0x2D,0x2F,0x00,0x00,0x00,0x00,0x00,0x00,  /*60*/
    0x00,0x00,0x00,0x2C,0x25,0x5F,0x3E,0x3F,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*70*/
    0x00,0x60,0x3A,0x23,0x40,0x27,0x3D,0x22,
    0x00,0x61,0x62,0x63,0x64,0x65,0x66,0x67,  /*80*/
    0x68,0x69,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x6A,0x6B,0x6C,0x6D,0x6E,0x6F,0x70,  /*90*/
    0x71,0x72,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x7E,0x73,0x74,0x75,0x76,0x77,0x78,  /*A0*/
    0x79,0x7A,0x00,0x00,0x00,0x5B,0x00,0x00,
    0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,  /*B0*/
    0x00,0x00,0x00,0x00,0x00,0x00,0x5D,0x00,
    0x00,0x41,0x42,0x43,0x44,0x45,0x46,0x47,  /*C0*/
    0x48,0x49,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x4A,0x4B,0x4C,0x4D,0x4E,0x4F,0x50,  /*D0*/
    0x51,0x52,0x00,0x00,0x00,0x00,0x00,0x00,
    0x00,0x00,0x53,0x54,0x55,0x56,0x57,0x58,  /*E0*/
    0x59,0x5A,0x00,0x00,0x00,0x00,0x00,0x00,
    0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,  /*F0*/
    0x38,0x39,0x00,0x00,0x00,0x00,0x00,0x00
  };


  public String convert (String indata)
  {
    return new String ( convert ( indata.getBytes() ) );
  }

  public byte[] convert (byte[] indata)
  {
    return convert ( indata, false );
  }

  public byte[] convert (byte[] indata, boolean traceOn)
  {
    byte[] outdata = new byte[indata.length];

    if ( traceOn )
    {
      System.out.println ( "--------------------------------------------------------------" );
      System.out.println ( "Conversion source: " );
      System.out.println ( dumpToString(indata) );
    }

    byte tableVal;

    for (int i=0; i < outdata.length; i++)
    {
      int xlateNdx;
      if ( indata[i] < 0 )
      {
        xlateNdx = (indata[i]) + 256;
      }
      else
      {
        xlateNdx = indata[i];
      }
      //System.out.println ( "indata[i] = " + indata[i] + "; xlateNdx = " + xlateNdx );
      tableVal = etoa_table[xlateNdx];
      if ( tableVal != 0 )
      {
        outdata[i] = tableVal;
      }
      else
      {
        outdata[i] = indata[i];
      }
    }

    if ( traceOn )
    {
      System.out.println ( "Conversion result: " );
      System.out.println ( dumpToString(outdata) );
      System.out.println ( "--------------------------------------------------------------" );
    }

    return outdata;
  }

    public String dumpEbcdicToString(byte buffer[])
    {
      byte[] tempdata = convert(buffer, false);

      return dumpToString(tempdata);
    }

    public String dumpToString(byte buffer[])
    {
        return dumpToString ( buffer, buffer.length );
    }

    public String dumpToString(byte buffer[], int length)
    {
        String retString="";
        int i;
        int j;
        String tempStr="";

	if ( buffer.length < length )
	{
	    length = buffer.length;
        }

        //        System.out.println("HexDumper.dumpToString(byte[])");

        for(i=0;i<length;i+=16)
        {
            tempStr = "" + hexString(i);
            for(int k=tempStr.length();k<6;k++)
            {
                tempStr = "0" + tempStr;
            }

            //            System.out.print(tempStr + ":  ");
            retString += tempStr + ":  ";

            for(j=0;((j<16) && ((i+j) < length));j++)
            {
                //                tempStr = "" + buffer[i+j];
                //                System.out.print(hexString(buffer[i+j]) + "  ");
                retString += hexString(buffer[i+j]) + "  ";
            }

            if(length < (i+16))
            {
                for(;j<16;j++)
                {
                    //                    System.out.print("    ");
                    retString += "    ";
                }
                //                System.out.println("\t|" + (new String(buffer,i,length-i)) + "|");
                //retString += "\t|" + (new String(buffer,i,length-i)) + "|\n";
                retString += "\t|";
                for ( int a = 0; a < length - i; a++ )
                {
                  char temp = (char)buffer[a+i];
                  if ( Character.isLetterOrDigit(temp)
                    || temp == ' ' )
                  {
                    retString += temp;
                  }
                  else
                  {
                    retString += "_";
                  }
                }
                retString += "|\n";
            }
            else
            {
                //                System.out.println("\t|" + (new String(buffer,i,10)) + "|");
//                retString += "\t|" + (new String(buffer,i,16)) + "|\n";
                retString += "\t|";
                for ( int a = 0; a < 16; a++ )
                {
                  char temp = (char)buffer[a+i];
                  if ( Character.isLetterOrDigit(temp)
                    || temp == ' ' )
                  {
                    retString += temp;
                  }
                  else
                  {
                    retString += "_";
                  }
                }
                retString += "|\n";
            }
        }

        return retString;
    }

    protected String hexString(int b)
    {
	String temp = Integer.toString(b, 16).toUpperCase();

	temp = temp.replace( '-', ' ' ).trim();

	if ( temp.length() == 1 )
	{
	  temp = "0" + temp;
	}
	else if ( temp.length() == 0 )
	{
	  temp = "00";
	}

	return temp;
/***********************************
        int lower = b%16;
        int upper = b/16;

        //        System.out.println("hexString(" + b + ") -->  hexHalf(" + upper + ") + hexHalf(" + lower + ")");

        return hexHalf(upper) + hexHalf(lower);
*********************************************/
    }

    protected String hexString(byte b)
    {
	String temp = Integer.toString((int)b, 16).toUpperCase();

	temp = temp.replace( '-', ' ' ).trim();

	if ( temp.length() == 1 )
	{
	  temp = "0" + temp;
	}
	else if ( temp.length() == 0 )
	{
	  temp = "00";
	}

	return temp;
/***********************************
        int val = b;
        if(val < 0)
        {
            val = val + 256;
        }

        int lower = val%16;
        int upper = val/16;

        //        System.out.println("hexString(" + b + ") -->  hexHalf(" + upper + ") + hexHalf(" + lower + ")");

        return hexHalf(upper) + hexHalf(lower);
*********************************************/
    }

    protected String hexHalf(int i)
    {
        String retString = "";
        int c;

        if(i < 0)
        {
            i = -i;
            retString = "-";
        }

        switch(i)
        {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            retString += i;
            break;
        case 10:
            retString += "A";
            break;
        case 11:
            retString += "B";
            break;
        case 12:
            retString += "C";
            break;
        case 13:
            retString += "D";
            break;
        case 14:
            retString += "E";
            break;
        case 15:
            retString += "F";
            break;
        default:
            throw new RuntimeException("You dont know what you are talking about:  I can't convert " + i + " to hex ");
        }

        return retString;
    }


  public static void main (String[] args)
  {
    byte[] in = //{ -27, -30, -29, -11, -12, -10 };
/**********/
{
2,9,-27,-30,-29,-11,-12,-10,64,64,
97,-128,-126,1,-62,-117,4,-44,-59,-44,
-56,-114,6,-15,-9,-13,-12,-9,-13,-97,
35,8,-14,-16,-16,-12,-15,-16,-14,-16,
-97,40,4,-15,-10,-16,-16,-97,41,2,
-15,-14,-97,125,4,-16,-16,-14,-10,-97,
-127,13,9,-30,-63,-63,-16,-16,-16,-13,
-58,-25,-97,-127,22,12,-7,-11,-7,-12,
-9,-16,-8,-8,-7,-16,-15,-15,-97,-127,
84,3,-11,-16,-16,-65,-127,87,-128,-96,
37,-128,12,-11,-7,-14,-8,-9,-16,-8,
-8,-7,-16,-15,-16,-127,1,-15,-126,3,
-12,-16,-16,-125,1,-15,-124,4,-14,-14,
-16,-10,-122,4,64,64,64,-16,-96,37,
-128,12,-10,-7,-14,-8,-9,-16,-8,-8,
-7,-16,-15,-13,-127,1,-15,-126,3,-12,
-16,-16,-125,1,-15,-124,4,-14,-14,-16,
-10,-122,4,64,64,64,-16,-96,37,-128,
12,-9,-7,-14,-8,-9,-16,-8,-8,-7,
-16,-15,-10,-127,1,-15,-126,3,-12,-16,
-16,-125,1,-15,-124,4,-14,-14,-16,-10,
-122,4,64,64,64,-16,-96,37,-128,12,
-8,-7,-14,-8,-9,-16,-8,-8,-7,-16,
-15,-7,-127,1,-15,-126,3,-12,-16,-16,
-125,1,-15,-124,4,-14,-14,-16,-10,-122,
4,64,64,64,-16,-96,37,-128,12,-7,
-7,-14,-8,-9,-16,-8,-8,-7,-16,-15,
-15,-127,1,-15,-126,3,-12,-16,-16,-125,
1,-15,-124,4,-14,-14,-16,-9,-122,4,
64,64,64,-16,-96,37,-128,12,-15,-16,
-13,-8,-9,-16,-8,-8,-7,-16,-15,-8,
-127,1,-15,-126,3,-12,-16,-16,-125,1,
-15,-124,4,-14,-14,-16,-9,-122,4,64,
64,64,-16,-96,37,-128,12,-14,-16,-13,
-8,-9,-16,-8,-8,-7,-16,-15,-16,-127,
1,-15,-126,3,-12,-16,-16,-125,1,-15,
-124,4,-14,-14,-16,-9,-122,4,64,64,
64,-16,-96,37,-128,12,-13,-16,-13,-8,
-9,-16,-8,-8,-7,-16,-15,-13,-127,1,
-15,-126,3,-12,-16,-16,-125,1,-15,-124,
4,-14,-14,-16,-9,-122,4,64,64,64,
-16,0,0,-97,-127,94,1,-62,-97,-127,
95,1,-42,-97,-127,102,8,-14,-16,-16,
-12,-15,-16,-15,-7,-97,-127,103,4,-14,
-14,-16,-9,-97,-126,35,5,-46,-55,-25,
-55,-41,-97,-126,36,3,-42,-63,-46,-97,
-126,53,4,-63,-44,-30,-25,-97,-126,54,
8,-14,-16,-16,-12,-15,-16,-15,-9,-97,
-126,55,3,-46,-55,-25,-97,-126,56,3,
-42,-63,-46,-97,-126,57,8,-14,-16,-16,
-12,-15,-16,-15,-8,-97,-126,58,4,-14,
-15,-16,-11,0,0,0,0,0,0,0
};
/***********/
    String strIn = new String (in);

    EbcdicToAscii e2a = new EbcdicToAscii();

    System.out.print ( e2a.dumpToString(in) );

    byte[] out = e2a.convert(in);

    System.out.print ( e2a.dumpToString(out) );

//    String strOut = e2a.convert(strIn);

//    System.out.println ( "strOut = " + strOut );
  }
}
