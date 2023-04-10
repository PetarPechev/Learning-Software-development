package MockExam3;

import java.util.Arrays;
import java.util.Scanner;

public class Energy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEvenDigits = 0;
        int sumOddDigits = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            if (currentNumber % 2 == 0) {
                sumEvenDigits += currentNumber;
            } else {
                sumOddDigits += currentNumber;
            }
        }

        if (sumEvenDigits > sumOddDigits) {
            System.out.print(sumEvenDigits + " energy drinks");
        } else if (sumEvenDigits < sumOddDigits) {
            System.out.print(sumOddDigits + " cups of coffee");
        } else {
            System.out.print(sumOddDigits + " of both");
        }
    }
}
