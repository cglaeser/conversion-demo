package de.numerals.conversionbackend.conversion.converters;

import de.numerals.conversionbackend.conversion.common.exceptions.ArgumentOutOfRangeException;

public interface INumeralConverter<T extends INumeralConverter<T>> {

    boolean validateInputValue(String inputValue);

    String convert(String inputValue) throws ArgumentOutOfRangeException, NumberFormatException;

    T setRadix(Integer radix);
}
