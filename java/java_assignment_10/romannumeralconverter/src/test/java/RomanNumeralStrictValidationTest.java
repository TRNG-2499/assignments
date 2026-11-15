import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Strict Validation Tests")
public class RomanNumeralStrictValidationTest {
    
    @DisplayName("Standard roman numerals convert")
    @ParameterizedTest
    @CsvSource({
        "I,1", "III,3", "IV,4", "V,5", "VIII,8", "IX,9",
        "XL,40", "XLIX,49", "L,50", "XC,90",
        "CD,400", "D,500", "CM,900",
        "MDCXCVII,1697", "MCMXCIV,1994", "MMXXVI,2026", "MMMCMXCIX,3999"
    })
    void validNumeralsConvert(String numeral, int expected) {
        assertEquals(expected, RomanNumeralConverter.toInteger(numeral));
    }

    @DisplayName("Too many repeated standard characters throws IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {
        "IIII", "XXXX", "CCCC", "MMMM",
        "VIIII", "LXXXX", "DCCCC",
        "VV", "LL", "DD",
        "VVV", "XVV"
    })
    void tooManyRepeatsThrows(String numeral) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(numeral));
    }

    @DisplayName("Illegal subtractive pairs throws IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {
        "IC", "IL", "ID", "IM",
        "XD", "XM",
        "VX", "VL", "VC", "VD", "VM",
        "LC", "LD", "LM",
        "DM"
    })
    void illegalSubtractivePairsThrows(String numeral) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(numeral));
    }

    @DisplayName("Symbols out of order or reused throws IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {
        "IIV", "IIX", "XIIX",
        "IVI", "IXI", "XCX", "XLX",
        "CMC", "CDC", "MCMC",
        "IXV", "VIV",
        "XXC", "CCM",
        "IM", "XIM"
    })
    void malformedOrderingThrows(String numeral) {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.toInteger(numeral));
    }

}
