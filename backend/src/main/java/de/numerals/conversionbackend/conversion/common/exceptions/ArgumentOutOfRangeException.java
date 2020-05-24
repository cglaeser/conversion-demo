package de.numerals.conversionbackend.conversion.common.exceptions;

public class ArgumentOutOfRangeException extends Exception {

    public ArgumentOutOfRangeException() {
        super("Number outside of range: larger than 3,999 or smaller than 1");
    }

    public ArgumentOutOfRangeException(String message) {
        super(message);
    }
}
