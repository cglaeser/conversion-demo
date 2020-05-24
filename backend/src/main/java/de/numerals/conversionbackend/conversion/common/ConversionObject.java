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
    ConverterEnum method;
    @ApiModelProperty(position = 2, example = "\"1000\"", allowableValues = "1-3999 (decimal)", notes = "All numbers without fractions between a decimal value of 1 to 3,999", required = true)
    String value;

    @ApiModelProperty(position = 3, example = "2", allowableValues = "a radix, e.g. 2 (binary) or 10(decimal)")
    Integer radix;

    public ConverterEnum getMethod() {
        return method;
    }

    public void setMethod(ConverterEnum method) {
        this.method = method;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Integer getRadix() {
        return radix;
    }

    public void setRadix(Integer radix) {
        this.radix = radix;
    }
}
