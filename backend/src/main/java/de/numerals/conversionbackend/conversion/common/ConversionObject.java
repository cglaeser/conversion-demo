package de.numerals.conversionbackend.conversion.common;

import de.numerals.conversionbackend.conversion.converters.ConverterEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * The input object consists of a conversion method and a value formatted as a string
 */
@Api
public class ConversionObject {
    @ApiModelProperty(position = 1, notes = "The conversion method to be applied to the input", required = true)
    ConverterEnum converter;
    @ApiModelProperty(position = 2, example = "\"1000\"", allowableValues = "1-3999 (decimal)", notes = "All numbers without fractions between a decimal value of 1 to 3,999", required = true)
    String value;

    public ConverterEnum getConverter() {
        return converter;
    }

    public void setConverter(ConverterEnum converter) {
        this.converter = converter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
