import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Provided test suite for RomanNumeralConverter. DO NOT MODIFY.
 *
 * The tests are organized into groups that progress from easy to hard.
 * Work through them in order, one failing test at a time.
 */
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@DisplayName("RomanNumeralConverter")
class RomanNumeralConverterTest {

    // ------------------------------------------------------------------
    // Group 1: Single symbols
    // ------------------------------------------------------------------
    @Nested
    @Order(1)
    @DisplayName("1. Single symbols")
    class SingleSymbols {

        @ParameterizedTest(name = "toRoman({0}) = {1}")
        @CsvSource({"1,I", "5,V", "10,X", "50,L", "100,C", "500,D", "1000,M"})
        void toRoman_singleSymbolValues_returnsSymbol(int number, String expected) {
            assertEquals(expected, RomanNumeralConverter.toRoman(number));
        }

        @ParameterizedTest(name = "toInteger({1}) = {0}")
        @CsvSource({"1,I", "5,V", "10,X", "50,L", "100,C", "500,D", "1000,M"})
        void toInteger_singleSymbols_returnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }
    }

    // ------------------------------------------------------------------
    // Group 2: Additive numerals
    // ------------------------------------------------------------------
    @Nested
    @Order(2)
    @DisplayName("2. Additive numerals")
    class Additive {

        @ParameterizedTest(name = "toRoman({0}) = {1}")
        @CsvSource({"2,II", "3,III", "6,VI", "8,VIII", "11,XI", "15,XV", "27,XXVII",
                "30,XXX", "75,LXXV", "200,CC", "1003,MIII", "2000,MM", "3000,MMM"})
        void toRoman_additiveValues_returnsNumeral(int number, String expected) {
            assertEquals(expected, RomanNumeralConverter.toRoman(number));
        }

        @ParameterizedTest(name = "toInteger({1}) = {0}")
        @CsvSource({"2,II", "3,III", "6,VI", "8,VIII", "11,XI", "15,XV", "27,XXVII",
                "30,XXX", "75,LXXV", "200,CC", "1003,MIII", "2000,MM", "3000,MMM"})
        void toInteger_additiveNumerals_returnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }
    }

    // ------------------------------------------------------------------
    // Group 3: Subtractive numerals
    // ------------------------------------------------------------------
    @Nested
    @Order(3)
    @DisplayName("3. Subtractive numerals")
    class Subtractive {

        @ParameterizedTest(name = "toRoman({0}) = {1}")
        @CsvSource({"4,IV", "9,IX", "14,XIV", "19,XIX", "40,XL", "49,XLIX", "90,XC",
                "94,XCIV", "400,CD", "900,CM", "949,CMXLIX"})
        void toRoman_subtractiveValues_returnsNumeral(int number, String expected) {
            assertEquals(expected, RomanNumeralConverter.toRoman(number));
        }

        @ParameterizedTest(name = "toInteger({1}) = {0}")
        @CsvSource({"4,IV", "9,IX", "14,XIV", "19,XIX", "40,XL", "49,XLIX", "90,XC",
                "94,XCIV", "400,CD", "900,CM", "949,CMXLIX"})
        void toInteger_subtractiveNumerals_returnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }
    }

    // ------------------------------------------------------------------
    // Group 4: Larger and mixed values
    // ------------------------------------------------------------------
    @Nested
    @Order(4)
    @DisplayName("4. Larger and mixed values")
    class LargerValues {

        @ParameterizedTest(name = "toRoman({0}) = {1}")
        @CsvSource({"58,LVIII", "444,CDXLIV", "1666,MDCLXVI", "1994,MCMXCIV",
                "2024,MMXXIV", "3888,MMMDCCCLXXXVIII", "3999,MMMCMXCIX"})
        void toRoman_largeValues_returnsNumeral(int number, String expected) {
            assertEquals(expected, RomanNumeralConverter.toRoman(number));
        }

        @ParameterizedTest(name = "toInteger({1}) = {0}")
        @CsvSource({"58,LVIII", "444,CDXLIV", "1666,MDCLXVI", "1994,MCMXCIV",
                "2024,MMXXIV", "3888,MMMDCCCLXXXVIII", "3999,MMMCMXCIX"})
        void toInteger_largeNumerals_returnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }
    }

    // ------------------------------------------------------------------
    // Group 5: Case handling
    // ------------------------------------------------------------------
    @Nested
    @Order(5)
    @DisplayName("5. Case handling")
    class CaseHandling {

        @ParameterizedTest(name = "toInteger(\"{1}\") = {0}")
        @CsvSource({"14,xiv", "1994,mcmxciv", "4,iv", "3999,mmmcmxcix", "42,xLii"})
        void toInteger_lowerOrMixedCase_returnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }

        @Test
        void toInteger_mixedCaseMatchesUpperCase() {
            assertEquals(RomanNumeralConverter.toInteger("MCMXCIV"),
                    RomanNumeralConverter.toInteger("McMxCiV"));
        }

        @ParameterizedTest(name = "toRoman({0}) is uppercase")
        @ValueSource(ints = {4, 14, 49, 1994, 2024, 3999})
        void toRoman_alwaysReturnsUpperCase(int number) {
            String result = RomanNumeralConverter.toRoman(number);
            assertEquals(result.toUpperCase(), result);
        }
    }

    // ------------------------------------------------------------------
    // Group 6: Round trips
    // ------------------------------------------------------------------
    @Nested
    @Order(6)
    @DisplayName("6. Round trips")
    class RoundTrips {

        @ParameterizedTest(name = "round trip of {0}")
        @ValueSource(ints = {1, 4, 9, 14, 40, 90, 400, 999, 1994, 2024, 3999})
        void roundTrip_selectedValues_returnsOriginal(int number) {
            assertEquals(number, RomanNumeralConverter.toInteger(RomanNumeralConverter.toRoman(number)));
        }

        @Test
        void roundTrip_everyValidNumber_returnsOriginal() {
            for (int number = 1; number <= 3999; number++) {
                int result = RomanNumeralConverter.toInteger(RomanNumeralConverter.toRoman(number));
                assertEquals(number, result, "Round trip failed for " + number);
            }
        }
    }

    // ------------------------------------------------------------------
    // Group 7: Invalid input
    // ------------------------------------------------------------------
    @Nested
    @Order(7)
    @DisplayName("7. Invalid input")
    class InvalidInput {

        @ParameterizedTest(name = "toRoman({0}) throws")
        @ValueSource(ints = {0, -1, -100, 4000, 10000, Integer.MIN_VALUE, Integer.MAX_VALUE})
        void toRoman_outOfRange_throwsIllegalArgumentException(int number) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toRoman(number));
        }

        @ParameterizedTest(name = "toInteger(\"{0}\") throws")
        @NullAndEmptySource
        @ValueSource(strings = {"   ", "ABC", "XIZ", "123", "X I", "IV!", "hello"})
        void toInteger_invalidInput_throwsIllegalArgumentException(String roman) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(roman));
        }

        @Test
        void toRoman_outOfRange_hasClearMessage() {
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toRoman(0));
            assertFalse(exception.getMessage() == null || exception.getMessage().isBlank(),
                    "The exception should include a clear message.");
        }

        @Test
        void toInteger_invalidInput_hasClearMessage() {
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger("ABC"));
            assertFalse(exception.getMessage() == null || exception.getMessage().isBlank(),
                    "The exception should include a clear message.");
        }
    }
}
