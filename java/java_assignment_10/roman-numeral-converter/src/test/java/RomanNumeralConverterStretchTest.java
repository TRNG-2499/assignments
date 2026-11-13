import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.revature.RomanNumeralConverter;

// stretch goal tests, kept in their own file so the provided RomanNumeralConverterTest stays unchanged
public class RomanNumeralConverterStretchTest {

    // stretch goal 1
    // each of these reads as a number with simple adding/subtracting, but none is how that number is written
    @ParameterizedTest
    @ValueSource(strings = {"IIII", "VV", "IC", "VX", "XXXX", "LL", "DD", "IL", "XM", "IIV", "MMMM", "iiii"})
    void toInteger_nonStandardNumeral_throwsIllegalArgumentException(String roman) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(roman));
    }

    // stretch goal 1
    // strict checking shouldn't reject the standard forms, including lowercase ones
    @ParameterizedTest
    @CsvSource({"4, IV", "9, IX", "40, XL", "99, XCIX", "3999, MMMCMXCIX", "14, xiv"})
    void toInteger_standardNumeral_stillReturnsValue(int expected, String roman) {
        assertEquals(expected, RomanNumeralConverter.toInteger(roman));
    }

    // stretch goal 2
    @ParameterizedTest
    @CsvSource({
        "I,      I,      II",
        "II,     II,     IV",
        "IX,     I,      X",
        "XIV,    XXVI,   XL",
        "MCM,    XCIV,   MCMXCIV",
        "MMM,    CMXCIX, MMMCMXCIX"
    })
    void add_twoValidNumerals_returnsSum(String a, String b, String expected) {
        assertEquals(expected, RomanNumeralConverter.add(a, b));
    }

    // stretch goal 2
    @Test
    void add_lowercaseInput_returnsUppercase() {
        assertEquals("XV", RomanNumeralConverter.add("x", "v"));
    }

    // stretch goal 2
    // the quotes keep CsvSource from turning the blank value into null
    @ParameterizedTest
    @CsvSource({
        "ABC,  I",
        "I,    XIZ",
        "IIII, I",
        "'',   I"
    })
    void add_invalidNumeral_throwsIllegalArgumentException(String a, String b) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(a, b));
    }

    // stretch goal 2
    @Test
    void add_nullNumeral_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(null, "I"));
    }

    // stretch goal 2
    // boundary: 3999 is the largest valid sum, so 4000 should be rejected
    @Test
    void add_sumOver3999_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add("MMMCMXCIX", "I"));
    }
}
