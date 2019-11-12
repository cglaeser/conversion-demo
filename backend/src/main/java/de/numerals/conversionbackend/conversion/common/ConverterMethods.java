package de.numerals.conversionbackend.conversion.common;

import de.numerals.conversionbackend.conversion.common.exceptions.ClassicalRomanNumberRangeExceededException;

public class ConverterMethods {

    //prevent instantiation
    private ConverterMethods() {
    }

    public static String convertToRomanNumeral(int value) throws ClassicalRomanNumberRangeExceededException {
        checkBounds(value);
        StringBuilder sb = new StringBuilder();
        while (value >= 1000) {
            sb.append("M");
            value -= 1000;
        }
        if (value >= 900) {
            sb.append("CM");
            value -= 900;
        }
        if (value >= 500) {
            sb.append("D");
            value -= 500;
        }
        if (value >= 400) {
            sb.append("CD");
            value -= 400;
        }
        while (value >= 100) {
            sb.append("C");
            value -= 100;
        }
        if (value >= 90) {
            sb.append("XC");
            value -= 90;
        }
        if (value >= 50) {
            sb.append("L");
            value -= 50;
        }
        if (value >= 40) {
            sb.append("XL");
            value -= 40;
        }
        while (value > 10) {
            sb.append("X");
            value -= 10;
        }
        if (value == 9) {
            sb.append("IX");
            value -= 9;
        }
        if (value >= 5) {
            sb.append("V");
            value -= 5;
        }
        if (value == 4) {
            sb.append("IV");
            value -= 4;
        }
        while (value > 0) {
            sb.append("I");
            System.out.println(value);
            value -= 1;
        }
        return sb.toString();
    }

    public static boolean checkBounds(Integer value) throws ClassicalRomanNumberRangeExceededException {
        if (value < 1) throw new ClassicalRomanNumberRangeExceededException("Number smaller than 1");
        if (value > 3999) throw new ClassicalRomanNumberRangeExceededException("Number larger than 3,999");
        return true;
    }

}
