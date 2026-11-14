
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralAdditionTest {

    @ParameterizedTest
    @CsvSource({
        "I, I, II",
        "X, V, XV",
        "IV, VI, X",
        "XL, II, XLII",
        "C, XC, CXC",
        "M, CMXCIV, MCMXCIV",
        "xiv, vi, XX",
        "MM, M, MMM",
        "MCM, XCIV, MCMXCIV"
    })
    void addValidRomanNumerals(
            String a, String b, String expected) {

        assertEquals(
            expected,
            RomanNumeralConverter.add(a, b)
        );
    }

    @Test
    void sumGreaterThan3999ThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add("MMM", "M")
        );
    }

    @Test
    void sumExactly3999IsAllowed() {
        assertEquals(
            "MMMCMXCIX",
            RomanNumeralConverter.add("MMM", "CMXCIX")
        );
    }

    @Test
    void invalidFirstInputThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add("ABC", "X")
        );
    }

    @Test
    void invalidSecondInputThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add("X", "IIII")
        );
    }

    @Test
    void nullFirstInputThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add(null, "X")
        );
    }

    @Test
    void nullSecondInputThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add("X", null)
        );
    }

    @Test
    void emptyInputThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.add("", "X")
        );
    }

    @Test
    void resultAlwaysUppercase() {
        assertEquals(
            "XX",
            RomanNumeralConverter.add("xiv", "vi")
        );
    }
}
