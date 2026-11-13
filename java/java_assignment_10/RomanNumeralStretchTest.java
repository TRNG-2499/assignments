import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class RomanNumeralStretchTest {


    // --------------- STRICT VALIDATION TESTS ---------------

    @Nested
    class StrictValidation {

        @ParameterizedTest
        @ValueSource(strings = {"IIII", "VV", "IC", "VX", "XXXX", "LL", "DD", "IL", "XM", "IIV", "MMMM"})
        public void nonStandardNumeralTest(String roman) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(roman));
        }

        @Test
        public void lowercaseNonStandardNumeralTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger("iiii"));
        }

        @Test
        public void standardNumeralStillWorksTest() {
            int result = RomanNumeralConverter.toInteger("MCMXCIV");
            Assertions.assertEquals(1994, result);
        }
    }


    // --------------- ADD TESTS ---------------

    @Nested
    class Add {

        @ParameterizedTest
        @CsvSource({
                "I, I, II",
                "IV, VI, X",
                "XIV, VI, XX",
                "MCM, XCIV, MCMXCIV",
                "MMM, CMXCIX, MMMCMXCIX"
        })
        public void addTest(String a, String b, String expected) {
            String result = RomanNumeralConverter.add(a, b);
            Assertions.assertEquals(expected, result);
        }

        @Test
        public void addLowercaseReturnsUppercaseTest() {
            String result = RomanNumeralConverter.add("xiv", "vi");
            Assertions.assertEquals("XX", result);
        }

        @Test
        public void addSumOverMaxTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("MMM", "M"));
        }

        @Test
        public void addInvalidFirstInputTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("ABC", "X"));
        }

        @Test
        public void addInvalidSecondInputTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("X", "IIII"));
        }

        @Test
        public void addNullInputTest() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(null, "X"));
        }
    }
}