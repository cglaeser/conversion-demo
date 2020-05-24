package de.numerals.conversionbackend.conversion;

import de.numerals.conversionbackend.conversion.converters.ConverterEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api
public class ConversionResultDTO {

    /**
     * The input value
     */
    @ApiModelProperty(position = 1, notes = "The input value, encoded as a string", required = true)
    String inputValue;

    /**
     * The roman numeral
     */
    @ApiModelProperty(position = 2, notes = "The numeral to which the input value has been converted - may be null in case of an error")
    String result;

    /**
     * The conversion executed
     */
    @ApiModelProperty(position = 3, notes = "The conversion that took place", required = true)
    ConverterEnum conversion;

    /**
     * Optional message for errors
     */
    @ApiModelProperty(position = 1, notes = "The errorMessage, if an error occured", required = false)
    String errorMessage;


    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ConverterEnum getConversion() {
        return conversion;
    }

    public void setConversion(ConverterEnum conversion) {
        this.conversion = conversion;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    @Override
    public String toString() {
        return "ConversionResultDTO{" +
                "inputValue='" + inputValue + '\'' +
                ", romanNumeral='" + result + '\'' +
                ", conversion=" + conversion +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
