package Exercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999; i++) {
            String number = "" + i;
            boolean isSpecial = true;

            for (int j = 0; j < 4; j++) {
                int currentNumber = Integer.parseInt(String.valueOf(number.charAt(j)));

                if (currentNumber == 0 || n % currentNumber != 0) {
                    isSpecial = false;
                    break;
                }
            }

            if (isSpecial) {
                System.out.print(number + " ");
            }
        }
    }
}
