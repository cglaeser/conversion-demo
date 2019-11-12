package de.numerals.conversionbackend.conversion.converters.instances;

import de.numerals.conversionbackend.conversion.common.ConverterMethods;
import de.numerals.conversionbackend.conversion.common.exceptions.ClassicalRomanNumberRangeExceededException;
import de.numerals.conversionbackend.conversion.converters.IRomanNumeralConverter;

public class AnyNumberToRomanNumerals implements IRomanNumeralConverter {

    private int radix;

    /**
     * Added default constructor for decimal numbers (as it's default Western numbering scheme)
     */
    public AnyNumberToRomanNumerals() {
        this(10);
    }

    /**
     * @param radix The radix or base is the number of unique digits, including the digit zero, used to represent numbers in a positional numeral system
     */
    public AnyNumberToRomanNumerals(int radix) {
        this.radix = radix;
    }

    @Override
    public boolean validateInputValue(String inputValue) {
        try {
            convertToInt(inputValue);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    @Override
    public String convertToRomanNumeral(String inputValue) throws NumberFormatException, ClassicalRomanNumberRangeExceededException {
        int value = convertToInt(inputValue);
        return ConverterMethods.convertToRomanNumeral(value);
    }

    private int convertToInt(String inputValue) throws NumberFormatException, ClassicalRomanNumberRangeExceededException {
        int value = Integer.valueOf(inputValue, this.radix).intValue();
        ConverterMethods.checkBounds(value);
        return value;
    }
}
