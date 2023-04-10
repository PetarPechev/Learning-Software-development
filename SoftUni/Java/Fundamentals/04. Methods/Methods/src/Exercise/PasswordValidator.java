package Exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        passwordValidator(password);
    }

    private static void passwordValidator(String password) {
        boolean isLengthValid = checkPasswordLength(password);
        boolean isConsistingDigitsAndLetters = passwordConsistDigitsAndLetters(password);
        boolean isHavingAtLeastTwoDigits = passwordHaveAtLeastTwoDigits(password);
        boolean isValid = isPasswordValid(isLengthValid, isConsistingDigitsAndLetters, isHavingAtLeastTwoDigits);

        if (isValid){
            System.out.println("Password is valid");
        } else {
            if (!isLengthValid){
                System.out.println("Password must be between 6 and 10 characters");
            }

            if (!isConsistingDigitsAndLetters){
                System.out.println("Password must consist only of letters and digits");
            }

            if (!isHavingAtLeastTwoDigits) {
                System.out.println("Password must have at least 2 digits");
            }
        }
    }

    private static boolean isPasswordValid(boolean isLengthValid, boolean isConsistingDigitsAndLetters, boolean isHavingAtLeastTwoDigits) {
        return isLengthValid && isConsistingDigitsAndLetters && isHavingAtLeastTwoDigits;
    }

    private static boolean passwordHaveAtLeastTwoDigits(String password) {
        int countDigits = 0;

        for (int index = 0; index < password.length() && countDigits < 2; index++) {
            char currentChar = password.charAt(index);

            if (Character.isDigit(currentChar)) {
                countDigits++;
            }
        }

        return countDigits == 2;
    }

    private static boolean passwordConsistDigitsAndLetters(String password) {
        return password.matches("[a-zA-Z0-9]*");
    }

    private static boolean checkPasswordLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }
}
