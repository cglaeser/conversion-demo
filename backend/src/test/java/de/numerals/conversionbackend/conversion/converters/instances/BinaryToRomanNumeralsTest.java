package de.numerals.conversionbackend.conversion.converters.instances;

import de.numerals.conversionbackend.conversion.common.exceptions.ClassicalRomanNumberRangeExceededException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToRomanNumeralsTest {
    AnyNumberToRomanNumerals binaryToRomanNumerals = new AnyNumberToRomanNumerals(2);

    @Test
    void validateInputValueCorrect() {
        //value of 1234
        String inputValue = "010011010010";
        assertTrue(binaryToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueFalse() {
        String inputValue = "WrongValue";
        assertFalse(binaryToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueNegative() {
        String inputValue = "-1";
        assertFalse(binaryToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueZero() {
        String inputValue = "0";
        assertFalse(binaryToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void validateInputValueTooLarge() {
        //edge case 4000
        String inputValue = "111110100000";
        assertFalse(binaryToRomanNumerals.validateInputValue(inputValue));
    }

    @Test
    void longestRomanNumber() throws ClassicalRomanNumberRangeExceededException {
        //number 1888
        String inputValue = "011101100000";
        String resultValue = "MDCCCLXXXVIII";
        assertEquals(binaryToRomanNumerals.convertToRomanNumeral(inputValue), resultValue);
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralSimple() throws ClassicalRomanNumberRangeExceededException {
        String inputValue = "1";
        assertEquals("I", binaryToRomanNumerals.convertToRomanNumeral(inputValue));
    }

    //Exception lets test fail
    @Test
    void convertToRomanNumeralComplex() throws ClassicalRomanNumberRangeExceededException {
        String inputValue = "111110011111";
        assertEquals("MMMCMXCIX", binaryToRomanNumerals.convertToRomanNumeral(inputValue));
    }
}