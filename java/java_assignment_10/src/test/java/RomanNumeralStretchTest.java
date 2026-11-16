import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the stretch goals: strict validation in toInteger, and the add method.
 */
@DisplayName("RomanNumeralConverter stretch goals")
class RomanNumeralStretchTest {

    @Nested
    @DisplayName("Strict validation")
    class StrictValidation {

        @ParameterizedTest(name = "toInteger(\"{0}\") throws")
        @ValueSource(strings = {
                "IIII", "XXXX", "CCCC", "MMMM",   // a letter repeated more than three times
                "VV", "LL", "DD",                 // V, L and D may never repeat
                "IC", "IL", "IM", "XD", "XM",     // subtracting from a letter that is too large
                "VX", "LC", "DM",                 // V, L and D may never be subtracted
                "IIV", "IIX", "XXC",              // subtracting more than one letter
                "IXI", "IVI", "IXV", "XCX", "CMC" // adding after a subtractive pair it overlaps
        })
        void toInteger_nonStandardNumeral_throwsIllegalArgumentException(String roman) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(roman));
        }

        @ParameterizedTest(name = "toInteger(\"{0}\") throws")
        @ValueSource(strings = {"iiii", "vV", "Ic"})
        void toInteger_nonStandardNumeralInAnyCase_throwsIllegalArgumentException(String roman) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(roman));
        }

        @Test
        void toInteger_nonStandardNumeral_hasClearMessage() {
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger("IIII"));
            assertFalse(exception.getMessage() == null || exception.getMessage().isBlank(),
                    "The exception should include a clear message.");
        }

        @ParameterizedTest(name = "toInteger({1}) = {0}")
        @CsvSource({"3,III", "4,IV", "9,IX", "19,XIX", "444,CDXLIV", "3888,MMMDCCCLXXXVIII"})
        void toInteger_standardNumeral_stillReturnsValue(int expected, String roman) {
            assertEquals(expected, RomanNumeralConverter.toInteger(roman));
        }
    }

    @Nested
    @DisplayName("add")
    class Add {

        @ParameterizedTest(name = "add({0}, {1}) = {2}")
        @CsvSource({
                "I,I,II",
                "II,II,IV",
                "IV,V,IX",
                "XIV,XXVIII,XLII",
                "MCMXCIV,XXX,MMXXIV",
                "MM,MCMXCIX,MMMCMXCIX"
        })
        void add_validNumerals_returnsSum(String a, String b, String expected) {
            assertEquals(expected, RomanNumeralConverter.add(a, b));
        }

        @Test
        void add_isCommutative() {
            assertEquals(RomanNumeralConverter.add("XL", "IX"), RomanNumeralConverter.add("IX", "XL"));
        }

        @ParameterizedTest(name = "add({0}, {1}) = {2}")
        @CsvSource({"xiv,xxviii,XLII", "Iv,v,IX", "mm,MCMXCIX,MMMCMXCIX"})
        void add_lowerOrMixedCaseInput_returnsUpperCaseSum(String a, String b, String expected) {
            assertEquals(expected, RomanNumeralConverter.add(a, b));
        }

        @ParameterizedTest(name = "add({0}, {1}) throws")
        @CsvSource({"MMMCMXCIX,I", "MM,MM", "MMM,M", "MMMCMXCIX,MMMCMXCIX"})
        void add_sumGreaterThan3999_throwsIllegalArgumentException(String a, String b) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(a, b));
        }

        @Test
        void add_sumGreaterThan3999_hasClearMessage() {
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("MM", "MM"));
            assertFalse(exception.getMessage() == null || exception.getMessage().isBlank(),
                    "The exception should include a clear message.");
        }

        @ParameterizedTest(name = "add(\"{0}\", X) and add(X, \"{0}\") throw")
        @NullAndEmptySource
        @ValueSource(strings = {"   ", "ABC", "123", "X I", "IIII", "VX"})
        void add_invalidInputOnEitherSide_throwsIllegalArgumentException(String invalid) {
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(invalid, "X"));
            assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("X", invalid));
        }
    }
}
