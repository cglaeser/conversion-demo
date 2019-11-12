package de.numerals.conversionbackend.conversion.converters;

import de.numerals.conversionbackend.conversion.common.exceptions.ClassicalRomanNumberRangeExceededException;

public interface IRomanNumeralConverter {

    boolean validateInputValue(String inputValue);

    String convertToRomanNumeral(String inputValue) throws ClassicalRomanNumberRangeExceededException;
}
