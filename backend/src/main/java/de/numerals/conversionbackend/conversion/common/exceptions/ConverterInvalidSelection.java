package de.numerals.conversionbackend.conversion.common.exceptions;

public class ConverterInvalidSelection extends Exception {

    public ConverterInvalidSelection() {
        super("Invalid Selection");
    }

    public ConverterInvalidSelection(String message) {
        super(message);
    }
}
