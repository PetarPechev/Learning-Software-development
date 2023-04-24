package com.company.oop.cosmetics.utils;

import java.util.List;

public class ValidationHelpers {
    public static final String INVALID_NUMBER_OF_ARGUMENTS = "%s command expects %d parameters.";

    private static final String STRING_LENGTH_ERROR = "should be between %d and %d symbols.";
    private static final String INVALID_PRICE = "Price can't be negative.";





    public static void validateValueInRange(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(errorMessage, min, max));
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String type) {
        String errorMessage = String.format("%s %s", type, STRING_LENGTH_ERROR);

        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount, String type) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, type, expectedArgumentsCount));
        }
    }

    public static void validatePrice(double price) {
        if (price < 0.00) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

}
