package Exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while (!number.equals("END")) {
            boolean isPalindrome = checkPalindrome(number);

            System.out.println(isPalindrome);

            number = scanner.nextLine();
        }
    }

    private static boolean checkPalindrome(String number) {
        if (number.length() == 1 || number.charAt(0) == number.charAt(number.length() - 1)){
            return true;
        } else {
            return false;
        }
    }
}
