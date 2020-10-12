import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConversionTDD {
    @Test
    public void testMphKph(){
        //Test if 1 mph converts to 1.60934 kph
        assertTrue("Test Failed", Conversion.mphKphConversion("1", true) == 1.60934f);
        assertTrue("Test Failed", Conversion.mphKphConversion("2", true) == 3.21868f);
        assertTrue("Test Failed", Conversion.mphKphConversion("1.60934", false) == 1.0f);
    }

    @Test
    public void testKelvinCelsius(){
        //Test if 1 kelvin converts to -272.15 celsius
        assertTrue("Test Failed", Conversion.kelvinCelsiusConversion("1", true) == -272.15f);
        assertTrue("Test Failed", Conversion.kelvinCelsiusConversion("2", true) == -271.15f);
        assertTrue("Test Failed", Conversion.kelvinCelsiusConversion("-272.15", false) == 1.0f);
    }

    public static void main(String[] args) {
        ConversionTDD tests = new ConversionTDD();
        tests.testMphKph();
        tests.testKelvinCelsius();
    }
}
