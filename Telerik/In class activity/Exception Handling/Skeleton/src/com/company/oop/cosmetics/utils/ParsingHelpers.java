package com.company.oop.cosmetics.utils;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
public class ParsingHelpers {

    private static final String INVALID_NUMBER_FIELD_MESSAGE = "Third parameter should be price (real number).";
    private static final String INVALID_BOOLEAN_FIELD_MESSAGE = "Invalid value for %s. Should be one of 'true' or 'false'.";
    public static final String INVALID_PRICE = "Invalid value for price. Should be a number.";


    public static double tryParseDouble(String valueToParse) {
        try {
            return Double.parseDouble(valueToParse);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(INVALID_NUMBER_FIELD_MESSAGE);
        }
    }


    public static boolean tryParseBoolean(String valueToParse, String parameterName) {
        if (!valueToParse.equalsIgnoreCase("true") &&
                !valueToParse.equalsIgnoreCase("false")) {
            throw new InvalidUserInputException(String.format(INVALID_BOOLEAN_FIELD_MESSAGE, parameterName));
        }

        return Boolean.parseBoolean(valueToParse);
    }

    public static <E extends Enum<E>> E tryParseEnum(String valueToParse, Class<E> type, String errorMessage) {
        try {
            return Enum.valueOf(type, valueToParse.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(errorMessage, valueToParse));
        }
    }

}
