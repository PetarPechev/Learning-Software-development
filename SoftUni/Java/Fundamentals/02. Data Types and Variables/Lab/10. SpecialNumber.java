package Lab;

import java.util.Scanner;

public class SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String numberAsString = "" + i;
            int result = 0;

            for (int j = 0; j < numberAsString.length(); j++) {
                int currentNumber = Integer.parseInt(String.valueOf(numberAsString.charAt(j)));
                result += currentNumber;
            }

            if (result == 5 || result == 7 || result == 11) {
                System.out.println(i + " -> " + "True");
            } else {
                System.out.println(i + " -> " + "False");
            }
        }
    }
}
