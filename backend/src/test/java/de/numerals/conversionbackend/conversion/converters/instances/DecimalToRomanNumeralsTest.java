package de.numerals.conversionbackend.conversion.converters.instances;

import de.numerals.conversionbackend.conversion.common.exceptions.ArgumentOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToRomanNumeralsTest {
    AnyNumberToRomanNumerals decimalToRomanNumerals = new AnyNumberToRomanNumerals(10);

    @Test
    void validateInputValueCorrect() {
        String inputValue = "1234";
        assertTrue(decimalToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueFalse() {
        String inputValue = "WrongValue";
        assertFalse(decimalToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueNegative() {
        String inputValue = "-1";
        assertFalse(decimalToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueZero() {
        String inputValue = "0";
        assertFalse(decimalToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueTooLarge() {
        String inputValue = "4000";
        assertFalse(decimalToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void longestRomanNumber() throws ArgumentOutOfRangeException {
        String inputValue = "1888";
        String resultValue = "MDCCCLXXXVIII";
        assertEquals(decimalToRomanNumerals.convert(inputValue), resultValue);
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralSimple() throws ArgumentOutOfRangeException {
        String inputValue = "1";
        assertEquals("I", decimalToRomanNumerals.convert(inputValue));
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralComplex() throws ArgumentOutOfRangeException {
        String inputValue = "3999";
        assertEquals("MMMCMXCIX", decimalToRomanNumerals.convert(inputValue));
    }
}