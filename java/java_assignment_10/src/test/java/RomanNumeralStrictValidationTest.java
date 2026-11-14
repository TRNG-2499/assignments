
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralStrictValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "IIII", "VV", "IC", "VX",
        "IL", "XM", "IIV", "XXXX",
        "MMMM", "LL", "DD", "LC",
        "DM", "IXIX", "VIV"
    })
    void invalidRomanNumeralsThrowException(String roman) {
        assertThrows(
            IllegalArgumentException.class,
            () -> RomanNumeralConverter.toInteger(roman)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "I", "IV", "IX", "XIV",
        "XLII", "XC", "CD", "CM",
        "MCMXCIV", "MMMCMXCIX"
    })
    void validRomanNumeralsAreAccepted(String roman) {
        int number = RomanNumeralConverter.toInteger(roman);

        assertEquals(
            roman,
            RomanNumeralConverter.toRoman(number)
        );
    }

    @Test
    void lowercaseNumeralsAreAccepted() {
        assertEquals(
            1994,
            RomanNumeralConverter.toInteger("mcmxciv")
        );
    }

    @Test
    void mixedCaseNumeralsAreAccepted() {
        assertEquals(
            42,
            RomanNumeralConverter.toInteger("xLiI")
        );
    }

    @Test
    void invalidNumeralsHaveClearMessage() {
        IllegalArgumentException exception =
            assertThrows(
                IllegalArgumentException.class,
                () -> RomanNumeralConverter.toInteger("IIII")
            );

        assertNotNull(exception.getMessage());
        assertFalse(exception.getMessage().isBlank());
    }
}
