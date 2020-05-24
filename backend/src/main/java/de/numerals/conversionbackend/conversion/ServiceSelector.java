package de.numerals.conversionbackend.conversion;


import de.numerals.conversionbackend.conversion.common.exceptions.ConverterInvalidSelection;
import de.numerals.conversionbackend.conversion.converters.ConverterEnum;
import de.numerals.conversionbackend.conversion.converters.INumeralConverter;
import de.numerals.conversionbackend.conversion.converters.instances.AnyNumberToRomanNumerals;
import de.numerals.conversionbackend.conversion.converters.instances.RomanNumeralsToAnyNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceSelector {

    @Autowired
    AnyNumberToRomanNumerals toRomanNumerals;

    @Autowired
    RomanNumeralsToAnyNumber fromRomanNumerals;

    public INumeralConverter getConverter(ConverterEnum converterEnum) throws ConverterInvalidSelection {
        switch (converterEnum){
            case TO_ROMAN:
                return toRomanNumerals;
            case FROM_ROMAN:
                return fromRomanNumerals;
            default:
                throw new ConverterInvalidSelection("Unknown converter requested");
        }
    }


}
