package Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        int sum = calculateSum(number);

        System.out.print(sum);
    }

    private static int calculateSum(int number) {
        int sumEvens = 0;
        int sumOdds = 0;

        while (number > 0) {
            int currentDigit = number % 10;
            number /= 10;

            if (currentDigit % 2 == 0) {
                sumEvens += currentDigit;
            } else {
                sumOdds += currentDigit;
            }
        }

        return sumEvens * sumOdds;
    }
}
