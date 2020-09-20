/** *****************************************************************
 Conversion.java
 Converts various measures from one unit to another

 @author Jeff Offutt & Ren Li

 @version 1.0    October 2000
 @version 2.0    June 2015
 @version 2.1    January 2020
  ********************************************************************* */
// Import Java Libraries
import java.io.*;
import java.util.*;
import java.lang.*;

// conversion class
//
// CONSTRUCTOR: no constructor specified (default)
//
// ****************  PUBLIC OPERATIONS  **********************************
// void  doGet()      --> Uses PrintHead() and PrintForm() to print the screen
// void  PrintHead()  --> Generates the head of the web page
// void  PrintForm()  --> Generates the form of the web page
// void  doPost()     --> Handles the conversions
// float convertX2Y() --> One for each conversion pair
//*************************************************************************
//
// The possible IOException on the PrintWriter is thrown up.

public class Conversion
{
    public static float convertF2C (String FAsStr)
    {  // Convert farenheit to celsius
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf(FAsStr).floatValue());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return (num2);
    }

    public static float convertC2F (String CAsStr)
    {  // Convert celsius to farenheit
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (CAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // small distance
    public static float convertIn2Cm (String inAsStr)
    {  // Convert inches to centimeters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (inAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 2.54);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertCm2In (String cmAsStr)
    {  // Convert centimeters to inches
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (cmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3937);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // medium distance
    public static float convertF2M (String ftAsStr)
    {  // Convert feet to meters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (ftAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertM2F (String mAsStr)
    {  // Convert meters to feet
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (mAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 0.3048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // large distance
    public static float convertM2K (String miAsStr)
    {  // Convert miles to kilometers
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (miAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 1.609);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertK2M (String kmAsStr)
    {  // Convert kilometers to miles
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (kmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.6214);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // volume
    public static float convertG2L (String galAsStr)
    {  // Convert gallons to liters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (galAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 3.785);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertL2G (String LAsStr)
    {  // Convert liters to gallons
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (LAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 3.785);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // small weight
    public static float convertOz2G (String ozAsStr)
    {  // Convert ounces to grams
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (ozAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 28.35);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertG2Oz (String gAsStr)
    {  // Convert grams to ounces
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (gAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 28.35);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // medium weight
    public static float convertLb2K (String lbAsStr)
    {  // Convert pounds to kilograms
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (lbAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.4536);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertK2Lb (String kgAsStr)
    {  // Convert kilograms to pounds
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (kgAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 2.205);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    public static float convertHr2Sec (String hrAsString){
        float num1, num2;

        num1 = (Float.valueOf(hrAsString));
        num2 = (float) num1 * 3600;

        return num2;
    }

    public static float convertSec2Hr (String secAsString){
        float num1, num2;

        num1 = (Float.valueOf(secAsString));
        num2 = (float) num1 / 3600;

        return num2;
    }

}