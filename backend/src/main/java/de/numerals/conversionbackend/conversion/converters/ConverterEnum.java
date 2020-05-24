package de.numerals.conversionbackend.conversion.converters;

import de.numerals.conversionbackend.conversion.converters.instances.AnyNumberToRomanNumerals;
import io.swagger.annotations.Api;

/**
 *
 */
@Api
public enum ConverterEnum {
    TO_ROMAN(), FROM_ROMAN();

    ConverterEnum() { }

}
