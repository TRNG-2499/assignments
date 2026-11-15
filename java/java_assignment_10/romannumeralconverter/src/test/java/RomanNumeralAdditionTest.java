import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("Adding Roman Numerals Tests")
public class RomanNumeralAdditionTest {
    
    @DisplayName("Valid arguments correctly sum and return correct numerals")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "I,      I,        II",
        "I,      II,       III",
        "II,     II,       IV",
        "IV,     I,        V",
        "V,      V,        X",
        "IX,     I,        X",
        "VI,     IV,       X",
        "IX,     IX,       XVIII",
        "XIX,    XIX,      XXXVIII",
        "XIV,    XXVI,     XL",
        "XLIX,   I,        L",
        "L,      L,        C",
        "XC,     X,        C",
        "XCIX,   I,        C",
        "CD,     C,        D",
        "CD,     CD,       DCCC",
        "CCCXC,  CCCXC,    DCCLXXX",
        "D,      D,        M",
        "CM,     C,        M",
        "CM,     I,        CMI",
        "CMXCIX, I,        M",
        "XXVI,   MCMXCIV,  MMXX",
        "MCMXCIV, XXVI,    MMXX",
        "MMM,    CMXCIX,   MMMCMXCIX",
        "MMDCCCLXXXVIII, MCXI, MMMCMXCIX",
        "MMMCMXCVIII, I,   MMMCMXCIX"
    })
    void validNumeralsSum(String a, String b, String expected) {
        assertEquals(expected, RomanNumeralConverter.add(a, b));
    }

    @DisplayName("Sum greater than 3999 throws IllegalArgumentException")
    @ParameterizedTest(name = "{0} + {1} exceeds 3999")
    @CsvSource({
        "MMMCMXCIX, I",
        "I,         MMMCMXCIX",
        "MMM,       M",
        "M,         MMM",
        "MM,        MM",
        "MMMD,      D",
        "MMMCM,     C",
        "MMMCMXC,   X",
        "MMM,       MMM",
        "MMMCMXCIX, MMMCMXCIX"
    })
    void validArgsIllegalSumThrows(String a, String b) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(a, b));
    }

    @DisplayName("Non-valid roman numeral arguments throws IllegalArgumentException")
    @ParameterizedTest(name = "add({0}, {1}) is rejected")
    @CsvSource(nullValues = "NULL", value = {
        // too many repeats
        "IIII,  I",
        "I,     IIII",
        "VV,    V",
        "XXXX,  X",
        "MMMM,  I",
        "I,     MMMM",

        //illegal subtractive pairs
        "IC,    I",
        "I,     VX",
        "XD,    I",

        //bad ordering
        "IIX,   V",
        "IVI,   I",
        "CMC,   I",

        //both malformed
        "IIII,  VV",

        //not valid numerals
        "ABC,   I",
        "I,     ABC",
        "12,    I",
        "I,     1",
        "'X I', I",
        "MCMXCIVZ, I",

        //empty/null
        "'',    I",
        "I,     ''",
        "'',    ''",
        "' ',   I",
        "I,     ' '",
        "NULL,  I",
        "I,     NULL",
        "NULL,  NULL"
    })
    void invalidArgsThrows(String a, String b) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.add(a, b));
    }

}
