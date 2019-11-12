package de.numerals.conversionbackend.conversion.common.exceptions;

public class ClassicalRomanNumberRangeExceededException extends Exception {

    public ClassicalRomanNumberRangeExceededException() {
        super("Number outside of range: larger than 3,999 or smaller than 1");
    }

    public ClassicalRomanNumberRangeExceededException(String message) {
        super(message);
    }
}
