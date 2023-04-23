package com.company.oop.cosmetics.utils;

public class ValidationHelpers {

    private static final String NAME_LENGTH_ERROR = "name should be between %d and %d symbols.";

    public static void validateValueInRange(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(errorMessage, min, max));
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateNameLength(String stringToValidate, int minLength, int maxLength, String type) {
        String errorMessage = type + " " + NAME_LENGTH_ERROR;
        validateStringLength(stringToValidate, minLength, maxLength, errorMessage);
    }

}
