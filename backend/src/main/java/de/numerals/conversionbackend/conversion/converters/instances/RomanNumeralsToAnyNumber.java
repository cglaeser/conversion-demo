package de.numerals.conversionbackend.conversion.converters.instances;

import de.numerals.conversionbackend.conversion.common.exceptions.ArgumentOutOfRangeException;
import de.numerals.conversionbackend.conversion.converters.INumeralConverter;
import org.springframework.stereotype.Component;

@Component
public class RomanNumeralsToAnyNumber implements INumeralConverter {
    private Integer radix;

    public int getRadix() {
        return this.radix;
    }

    public RomanNumeralsToAnyNumber setRadix(Integer radix) {
        this.radix = radix;
        return this;
    }

    @Override
    public boolean validateInputValue(String inputValue) {
        return false;
    }

    @Override
    public String convert(String inputValue) throws NumberFormatException {
        // Initialize result
        int result = ToArabic(inputValue);

        return Integer.toString(result, radix);
    }

    private int ToArabic(String number) throws NumberFormatException{
        if (number.length() == 0) return 0;
        if (number.startsWith("M")) return 1000 + ToArabic(number.substring( 1));
        if (number.startsWith("CM")) return 900 + ToArabic(number.substring(2));
        if (number.startsWith("D")) return 500 + ToArabic(number.substring(1));
        if (number.startsWith("CD")) return 400 + ToArabic(number.substring(2));
        if (number.startsWith("C")) return 100 + ToArabic(number.substring(1));
        if (number.startsWith("XC")) return 90 + ToArabic(number.substring(2));
        if (number.startsWith("L")) return 50 + ToArabic(number.substring(1));
        if (number.startsWith("XL")) return 40 + ToArabic(number.substring(2));
        if (number.startsWith("X")) return 10 + ToArabic(number.substring(1));
        if (number.startsWith("IX")) return 9 + ToArabic(number.substring(2));
        if (number.startsWith("V")) return 5 + ToArabic(number.substring(1));
        if (number.startsWith("IV")) return 4 + ToArabic(number.substring(2));
        if (number.startsWith("I")) return 1 + ToArabic(number.substring(1));
        throw new NumberFormatException("Invalid character detected");
    }
}
