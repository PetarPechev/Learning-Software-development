package Exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String numberAsString = "" + number;
        int totalSum = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            int currentNumber = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            int currentSum = 1;

            for (int j = 2; j <= currentNumber; j++) {
                currentSum *= j;
            }

            totalSum += currentSum;
        }

        if (totalSum == number) {
            System.out.print("yes");
        } else {
            System.out.print("no");
        }
    }
}
