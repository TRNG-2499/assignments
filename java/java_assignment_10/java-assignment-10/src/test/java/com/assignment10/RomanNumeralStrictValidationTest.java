package com.assignment10;

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

class RomanNumeralStrictValidationTest {

    @ParameterizedTest 
    @ValueSource (strings = {"IIII", "VV", "IC", "VX"})
    void reject_nonStandard_toInteger(String roman) {
        assertThrows(IllegalArgumentException.class, () -> {RomanNumeralConverter.toInteger(roman);});
    }

    @ParameterizedTest 
    @CsvSource ({"IV, 4", "III, 3", "MMMCMXCIX, 3999", "MCMXCIV, 1994"})
    void accept_standard_toInteger(String roman, int expected) {
        assertEquals(expected, RomanNumeralConverter.toInteger(roman));
    }

    @ParameterizedTest 
    @CsvSource ({"CXXIII, CMII, MXXV", "IV, IX, XIII", "CDXLIV, DLXXXVII, MXXXI", "i, x, XI"})
    void test_working_add(String roman1, String roman2, String expected) {
        assertEquals(expected, RomanNumeralConverter.add(roman1, roman2));
    }

    @ParameterizedTest
    @CsvSource ({"MMMM, MMMM", "MMM, M"})
    void test_sumTooGreat_add(String roman1, String roman2) {
        assertThrows(IllegalArgumentException.class, () -> {RomanNumeralConverter.add(roman1, roman2);});
    }

    @ParameterizedTest 
    @CsvSource ({"IIII, X"})
    void test_invalid_roman_add(String roman1, String roman2) {
        assertThrows(IllegalArgumentException.class, () -> {RomanNumeralConverter.add(roman1, roman2);});
    }
}
