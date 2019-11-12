package de.numerals.conversionbackend.conversion.converters;

import de.numerals.conversionbackend.conversion.converters.instances.AnyNumberToRomanNumerals;
import io.swagger.annotations.Api;

/**
 *
 */
@Api
public enum ConverterEnum {
    DECIMAL_TO_ROMAN_NUMERALS(new AnyNumberToRomanNumerals(10)), BINARY_TO_ROMAN_NUMERALS(new AnyNumberToRomanNumerals(2));


    private IRomanNumeralConverter converterInstance;

    ConverterEnum(IRomanNumeralConverter converterInstance) {
        this.converterInstance = converterInstance;
    }

    public IRomanNumeralConverter getConverterInstance() {
        return converterInstance;
    }

    public void setConverterInstance(IRomanNumeralConverter converterInstance) {
        this.converterInstance = converterInstance;
    }
}
