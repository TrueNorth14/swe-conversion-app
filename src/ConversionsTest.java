import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConversionsTest {

    //CONTROLLABILITY: by being able to provide sample inputs with just one array. We are easily able to affect the software's behavior.
    private final static String [] INPUTS = {"-17", "32", "0.01", "12243"}; //test at least one negative, one positive, one small, and one large number for each

    //OBSERVABILITY: by being able to provide sample outputs with ease. We are easily able to observe the software's behavior.
    private final static float [] FAR_ANS = {1.4f, 89.6f, 32.018f, 22069.4f}; //when input is cel
    private final static float [] CEL_ANS = {-27.2222f, 0, -17.77222f, 6783.8889f}; //when input is far

    private final static float [] IN_ANS = {-6.69291f, 12.5984f, 0.003937008f, 4820.0787f}; //when input is cm
    private final static float [] CM_ANS = {-43.18f, 81.28f, 0.0254f, 31097.22f}; //when input is far

    private final static float [] FT_ANS = {-55.7743f, 104.987f, 0.0328084f, 40167.323f}; //when input is M
    private final static float [] M_ANS = {-5.1816f, 9.7536f, 0.003048f, 3731.6664f}; //when input is FT

    private final static float [] MILE_ANS = {-10.5633f, 19.8839f, 0.00621371f, 7607.4475f}; //when input is KM
    private final static float [] KM_ANS = {-27.3588f, 51.499f, 0.01609344f, 19703.199f}; //when input is MILE

    private final static float [] GAL_ANS = {-4.49092f, 8.45351f, 0.002641721f, 3234.2584f}; //when input is LITER
    private final static float [] L_ANS = {-64.352f, 121.133f, 0.0378541f, 46344.796f}; //when input is GAL

    private final static float [] OZ_ANS = {-0.599657f, 1.12877f, 0.0003527396f, 431.85912f}; //when input is GRAM
    private final static float [] G_ANS = {-481.942f, 907.185f, 0.2834952f, 347083.21f}; //when input is OUNCE

    private final static float [] LB_ANS = {-37.4786f, 70.5479f, 0.02204623f, 26991.195f}; //when input is KG
    private final static float [] KG_ANS = {-7.71107f, 14.515f, 0.004535924f, 5553.3314f}; //when input is LB

    private final static float [] HR_ANS = {-0.00472222f, 0.00888889f, 0.00000277f, 3.4008333f}; //when input is SEC
    private final static float [] SEC_ANS = {-61200f, 115200f, 36f, 44074800f}; //when input is HR

    @Test
    private static void testFarAndCel(){

        //Test far to cel
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.farCelConversion(INPUTS[i], true);
            float actual = CEL_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test Celsius %f does not equal actual Celsius %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cel to far
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.farCelConversion(INPUTS[i], false);
            float actual = FAR_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test Fahrenheit %f does not equal actual Fahrenheit %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testInAndCm(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.inCmConversion(INPUTS[i], true);
            float actual = CM_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test CM %f does not equal actual CM %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.inCmConversion(INPUTS[i], false);
            float actual = IN_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test IN %f does not equal actual IN %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testFtAndM(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.feetMeterConversion(INPUTS[i], true);
            float actual = M_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test M %f does not equal actual M %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.feetMeterConversion(INPUTS[i], false);
            float actual = FT_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test FT %f does not equal actual FT %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }


    @Test
    private static void testMileAndKm(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.mileKmConversion(INPUTS[i], true);
            float actual = KM_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test KM %f does not equal actual KM %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.mileKmConversion(INPUTS[i], false);
            float actual = MILE_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test Mile %f does not equal actual Mile %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testGalAndLiter(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.galLiterConversion(INPUTS[i], true);
            float actual = L_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test Liter %f does not equal actual Liter %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.galLiterConversion(INPUTS[i], false);
            float actual = GAL_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test Gal %f does not equal actual Gal %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testOzAndG(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.ozGConversion(INPUTS[i], true);
            float actual = G_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test G %f does not equal actual G %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.ozGConversion(INPUTS[i], false);
            float actual = OZ_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test OZ %f does not equal actual OZ %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testLbAndKg(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.lbKgConversion(INPUTS[i], true);
            float actual = KG_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test KG %f does not equal actual KG %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.lbKgConversion(INPUTS[i], false);
            float actual = LB_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test lb %f does not equal actual lb %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testHrAndSec(){

        //Test in to cm
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.hrSecConversion(INPUTS[i], true);
            float actual = SEC_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test SEC %f does not equal actual SEC %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }

        //Test cm to in
        for (int i = 0; i < INPUTS.length; i++) {

            //CONTROLLABILITY
            float test = Conversion.hrSecConversion(INPUTS[i], false);
            float actual = HR_ANS[i];

            try {
                //OBSERVABILITY
                assertTrue(String.format("Test HR %f does not equal actual HR %f", test, actual), test == actual);
            } catch (AssertionError e){
                System.out.println(e);
            }
        }
    }



    public static void main(String[] args) {
        testFarAndCel();
        testInAndCm();
        testFtAndM();
        testGalAndLiter();
        testHrAndSec();
        testLbAndKg();
        testMileAndKm();
        testOzAndG();
    }
}
