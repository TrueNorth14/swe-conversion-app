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
    public static float farCelConversion (String input, boolean convertToCel){
        float num1, num2; // temporary variables
        int n; // temporary variable

        if(convertToCel){ //assume input is F
            num1 = (Float.valueOf(input).floatValue());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
            // Back to 2 digits
        } else { //assume input is C
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
            // Back to 2 digits
        }
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);

    }


    public static float inCmConversion (String input, boolean convertToCm){
        float num1, num2; // temporary variables
        int n; // temporary variable

        if (convertToCm){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 2.54);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else {
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 0.3937);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }
    }


    public static float feetMeterConversion(String input, boolean convertToM){
        float num1, num2; // temporary variables
        int n; // temporary variable

        if (convertToM){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 0.3048);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else{
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 / 0.3048);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }
    }


    public static float mileKmConversion (String input, boolean convertToKm){
        float num1, num2; // temporary variables
        int n; // temporary variable

        if (convertToKm){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 1.609);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else {
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 0.6214);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }
    }


    public static float galLiterConversion (String input, boolean convertToL) {
        float num1, num2; // temporary variables
        int n; // temporary variable

        if (convertToL){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 3.785);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else {
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 / 3.785);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }
    }


    public static float ozGConversion (String input, boolean convertToG) {
        float num1, num2; // temporary variables
        int n;

        if(convertToG){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 28.35);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else {
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 / 28.35);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }
    }


    public static float lbKgConversion (String input, boolean convertToKg) {

        float num1, num2; // temporary variables
        int n;

        if(convertToKg){
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 0.4536);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        } else {
            num1 = (Float.valueOf (input).floatValue ());
            n    = Math.round(num1 * (float)100.0);
            num1 = (float) (n / (float)100.0);
            // Convert
            num2 = (float) (num1 * 2.205);
            // Back to 2 digits
            n    = Math.round(num2 * (float)100.0);
            num2 = (float) (n / (float)100.0);
            return(num2);
        }

    }



    public static float hrSecConversion (String input, boolean convertToSec) {
        float num1, num2;

        if(convertToSec){
            num1 = (Float.valueOf(input));
            num2 = (float) num1 * 3600;

            return num2;
        } else {
            num1 = (Float.valueOf(input));
            num2 = (float) num1 / 3600;

            return num2;
        }

    }

    public static float mphKphConversion (String input, boolean convertToKph) {
        float num;
        float conversion;
        conversion = 1.60934f;

        num = Float.valueOf(input);

        return (convertToKph) ?  num * conversion : num / conversion;
    }

    public static float kelvinCelsiusConversion (String input, boolean convertToCelsius){
        float num;
        float conversion;
        conversion = 273.15f;

        num = Float.valueOf(input);

        return (convertToCelsius) ? num - conversion : num + conversion;
    }
}
