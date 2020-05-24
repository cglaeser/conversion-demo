package de.numerals.conversionbackend.conversion.converters.instances;

import de.numerals.conversionbackend.conversion.common.exceptions.ArgumentOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexadecimalToRomanNumeralsTest {
    AnyNumberToRomanNumerals hexadecimalToRomanNumeral = new AnyNumberToRomanNumerals(16);

    @Test
    void validateInputValueCorrect() {
        //value of 1234
        String inputValue = "4D2";
        assertTrue(hexadecimalToRomanNumeral.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueFalse() {
        String inputValue = "WrongValue";
        assertFalse(hexadecimalToRomanNumeral.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueNegative() {
        String inputValue = "FFFFFFFFFFFFFFFF";
        assertFalse(hexadecimalToRomanNumeral.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueZero() {
        String inputValue = "0";
        assertFalse(hexadecimalToRomanNumeral.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueTooLarge() {
        //edge case 4000
        String inputValue = "FA0";
        assertFalse(hexadecimalToRomanNumeral.validateInputValue(inputValue));
    }

    @Test
    void longestRomanNumber() throws ArgumentOutOfRangeException {
        //number 1888
        String inputValue = "760";
        String resultValue = "MDCCCLXXXVIII";
        assertEquals(hexadecimalToRomanNumeral.convert(inputValue), resultValue);
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralSimple() throws ArgumentOutOfRangeException {
        String inputValue = "1";
        assertEquals("I", hexadecimalToRomanNumeral.convert(inputValue));
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralComplex() throws ArgumentOutOfRangeException {
        String inputValue = "F9F";
        assertEquals("MMMCMXCIX", hexadecimalToRomanNumeral.convert(inputValue));
    }
}