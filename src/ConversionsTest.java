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

    public static void main(String[] args) {
        testFarAndCel();
        testInAndCm();
    }
}
